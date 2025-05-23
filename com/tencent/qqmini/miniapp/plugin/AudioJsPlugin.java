package com.tencent.qqmini.miniapp.plugin;

import android.app.Activity;
import android.os.Environment;
import android.os.RemoteException;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.luggage.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.tritonaudio.WebAudioPlugin;
import com.tencent.qqmini.miniapp.R;
import com.tencent.qqmini.miniapp.audiorecorder.LameMp3Recorder;
import com.tencent.qqmini.miniapp.util.AudioHelper;
import com.tencent.qqmini.miniapp.widget.media.MiniAppAudioPlayer;
import com.tencent.qqmini.minigame.audiorecorder.MiniGameLameMp3EncodeThread;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.core.utils.JSONUtil;
import com.tencent.qqmini.sdk.core.utils.NativeBuffer;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.model.SongInfo;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.DeviceInfoUtil;
import com.tencent.xweb.FileReaderHelper;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class AudioJsPlugin extends BaseJsPlugin {
    private static final String EVENT_ON_AUDIO_STATE_CHANGE = "onAudioStateChange";
    private static final String EVENT_ON_BACKGROUND_STATE_CHANGE = "onBackgroundAudioStateChange";
    private static final String EVENT_RECORD_STATE_CHANGE = "onRecorderStateChange";
    private static final int RECORD_TO_CANCEL = 1;
    private static final int RECORD_TO_SEND = 0;
    public static final int STATE_ERROR = 8;
    public static final String TAG = "AudioJsPlugin";
    private BgMusicData lastPlayData;
    private volatile AudioManager mAudioManager;
    private JSONObject mBgAudioState;
    private volatile BgMusicManager mBgMusicManager;
    private RequestEvent mBgMusicReq;
    private SongInfo mCurrentSongInfo;
    private int mPlayState;
    public static AtomicInteger sId = new AtomicInteger();
    private static boolean mMixWithOther = true;
    private volatile SparseArray<InnerAudioManager> mInnerAudioManagers = new SparseArray<>();
    private int mCurrentSongDuration = -1;
    private int mCurrentSongPosition = -1;
    private MusicPlayerProxy.MusicPlayerListener mMusicPlayerListener = new MusicPlayerProxy.MusicPlayerListener() { // from class: com.tencent.qqmini.miniapp.plugin.AudioJsPlugin.1
        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy.MusicPlayerListener
        public void onPlaySongChanged(SongInfo songInfo) {
            MusicPlayerProxy musicPlayerProxy = (MusicPlayerProxy) ProxyManager.get(MusicPlayerProxy.class);
            if (musicPlayerProxy != null) {
                AudioJsPlugin.this.mCurrentSongInfo = musicPlayerProxy.getCurrentSong();
            }
            AudioJsPlugin.this.onMusicStop();
            QMLog.i(AudioJsPlugin.TAG, "onPlaySongChanged title:" + songInfo.title + " url:" + songInfo.url);
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy.MusicPlayerListener
        public void onPlayStateChanged(int i3) {
            MusicPlayerProxy musicPlayerProxy = (MusicPlayerProxy) ProxyManager.get(MusicPlayerProxy.class);
            AudioJsPlugin.this.mPlayState = i3;
            switch (AudioJsPlugin.this.mPlayState) {
                case 1:
                    AudioJsPlugin.this.onMusicWaiting();
                    return;
                case 2:
                    AudioJsPlugin.this.onMusicPlay();
                    AudioJsPlugin.this.onMusicCanplay();
                    return;
                case 3:
                    AudioJsPlugin.this.onMusicPause();
                    AudioJsPlugin.this.mCurrentSongPosition = Math.max(musicPlayerProxy.getCurrentSongPosition(), 0);
                    return;
                case 4:
                    AudioJsPlugin.this.onMusicStop();
                    return;
                case 5:
                case 6:
                case 7:
                    AudioJsPlugin.this.onMusicError();
                    return;
                case 8:
                    AudioJsPlugin.this.evaluateBgAudioStateJs("ended");
                    return;
                default:
                    return;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class AudioManager implements LameMp3Recorder.OnErrorListener, LameMp3Recorder.AudioPlayerListener, LameMp3Recorder.AudioRecordListener {
        private long audioDuration;
        private Activity context;
        private int fateOfRecorder;
        private String fileFormat;
        private boolean isRecordManagerApi;
        private int maxTime;
        private RequestEvent playVoiceReq;
        private volatile LameMp3Recorder recorder;
        private RequestEvent startRecordReq;
        private RequestEvent stopRecordReq;

        private int getFateOfRecorder() {
            return this.fateOfRecorder;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public LameMp3Recorder getLameMp3Recorder() {
            if (this.recorder == null) {
                this.recorder = new LameMp3Recorder(this.context);
                this.recorder.setMaxRecordTime(this.maxTime);
                this.recorder.setRecordTime(this.audioDuration);
                this.recorder.setRecordFileFormat(this.fileFormat);
                this.recorder.setRecordFilPath(getTransferFilePath(this.fileFormat));
                this.recorder.setAudioRecordListener(this);
                this.recorder.setOnErrorListener(this);
                this.recorder.setOnPlayListener(this);
            }
            return this.recorder;
        }

        private String getTransferFilePath(String str) {
            String tmpPath = ((MiniAppFileManager) ((BaseJsPlugin) AudioJsPlugin.this).mMiniAppContext.getManager(MiniAppFileManager.class)).getTmpPath(str);
            try {
                FileUtils.createFile(tmpPath);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            return tmpPath;
        }

        private void handleOnRecordEnd(String str, long j3, long j16) {
            try {
                JSONObject jSONObject = new JSONObject();
                String wxFilePath = ((MiniAppFileManager) ((BaseJsPlugin) AudioJsPlugin.this).mMiniAppContext.getManager(MiniAppFileManager.class)).getWxFilePath(str);
                QMLog.d(AudioJsPlugin.TAG, "handleOnRecordEnd, tempFilePath:" + wxFilePath + ", duration:" + j3 + ", fileSize:" + j16);
                jSONObject.put("tempFilePath", wxFilePath);
                jSONObject.put("duration", j3);
                jSONObject.put("fileSize", j16);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("handleOnRecordEnd : ");
                sb5.append(this.isRecordManagerApi);
                QMLog.d(AudioJsPlugin.TAG, sb5.toString());
                if (this.isRecordManagerApi) {
                    jSONObject.put("state", "stop");
                    AudioJsPlugin.this.sendSubscribeEvent(AudioJsPlugin.EVENT_RECORD_STATE_CHANGE, jSONObject.toString());
                } else {
                    this.startRecordReq.ok(jSONObject);
                    RequestEvent requestEvent = this.stopRecordReq;
                    if (requestEvent != null) {
                        requestEvent.ok();
                        this.stopRecordReq = null;
                    }
                }
            } catch (Exception unused) {
                handleRecordFail("onRecordEnd exception");
            }
        }

        private void handlePlayVoice(int i3) {
            if (i3 == 8) {
                this.playVoiceReq.fail();
            } else {
                this.playVoiceReq.ok();
            }
        }

        private void handleRecordFail(String str) {
            QMLog.d(AudioJsPlugin.TAG, "handleRecordFail : " + this.isRecordManagerApi);
            if (this.isRecordManagerApi) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("state", "error");
                    jSONObject.put("errMsg", "recordError:" + str);
                    AudioJsPlugin.this.sendSubscribeEvent(AudioJsPlugin.EVENT_RECORD_STATE_CHANGE, jSONObject.toString());
                    return;
                } catch (Exception e16) {
                    e16.printStackTrace();
                    return;
                }
            }
            this.startRecordReq.fail();
        }

        private void releasePlayer() {
            if (this.recorder != null) {
                this.recorder.playStop();
            }
        }

        private void setFateOfRecorder(int i3) {
            this.fateOfRecorder = i3;
        }

        public boolean isRecording() {
            if (this.recorder != null && this.recorder.isRecording()) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.qqmini.miniapp.audiorecorder.LameMp3Recorder.OnErrorListener
        public void onErrorInfo(String str) {
            QMLog.e(AudioJsPlugin.TAG, "AudioManager.onRecorderNotReady() is called,path is:" + getLameMp3Recorder().getRecordFilPath());
            RequestEvent requestEvent = this.startRecordReq;
            if (requestEvent != null) {
                requestEvent.fail();
            }
        }

        @Override // com.tencent.qqmini.miniapp.audiorecorder.LameMp3Recorder.AudioPlayerListener
        public void onPlayFinish() {
            QMLog.d(AudioJsPlugin.TAG, "onPlayFinish");
            releasePlayer();
            this.playVoiceReq.ok();
        }

        @Override // com.tencent.qqmini.miniapp.audiorecorder.LameMp3Recorder.AudioPlayerListener
        public void onPlayPause() {
            QMLog.d(AudioJsPlugin.TAG, "onPlayPause");
        }

        @Override // com.tencent.qqmini.miniapp.audiorecorder.LameMp3Recorder.AudioPlayerListener
        public void onPlayResume() {
            QMLog.d(AudioJsPlugin.TAG, "onPlayResume");
        }

        @Override // com.tencent.qqmini.miniapp.audiorecorder.LameMp3Recorder.AudioPlayerListener
        public void onPlayStart() {
            QMLog.d(AudioJsPlugin.TAG, HippyQQPagView.EventName.ON_PLAY_START);
        }

        @Override // com.tencent.qqmini.miniapp.audiorecorder.LameMp3Recorder.AudioPlayerListener
        public void onPlayStop() {
            QMLog.d(AudioJsPlugin.TAG, "onPlayStop");
            releasePlayer();
            this.playVoiceReq.ok();
        }

        @Override // com.tencent.qqmini.miniapp.audiorecorder.LameMp3Recorder.AudioRecordListener
        public void onRecordFrame(byte[] bArr, boolean z16) {
            if (bArr != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("state", "frameRecorded");
                    NativeBuffer.packNativeBuffer(null, bArr, NativeBuffer.TYPE_BUFFER_BASE64, "frameBuffer", jSONObject);
                    jSONObject.put("isLastFrame", z16);
                    AudioJsPlugin.this.sendSubscribeEvent(AudioJsPlugin.EVENT_RECORD_STATE_CHANGE, jSONObject.toString());
                } catch (Throwable th5) {
                    if (QMLog.isColorLevel()) {
                        QMLog.e(AudioJsPlugin.TAG, "onRecordFrame failed! " + Log.getStackTraceString(th5));
                    }
                }
            }
        }

        @Override // com.tencent.qqmini.miniapp.audiorecorder.LameMp3Recorder.AudioRecordListener
        public void onRecordPause() {
            QMLog.d(AudioJsPlugin.TAG, "onRecordPause : " + this.isRecordManagerApi);
            if (this.isRecordManagerApi) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("state", "pause");
                    AudioJsPlugin.this.sendSubscribeEvent(AudioJsPlugin.EVENT_RECORD_STATE_CHANGE, jSONObject.toString());
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }

        @Override // com.tencent.qqmini.miniapp.audiorecorder.LameMp3Recorder.AudioRecordListener
        public void onRecordResume() {
            QMLog.d(AudioJsPlugin.TAG, "onRecordResume : " + this.isRecordManagerApi);
            if (this.isRecordManagerApi) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("state", "resume");
                    AudioJsPlugin.this.sendSubscribeEvent(AudioJsPlugin.EVENT_RECORD_STATE_CHANGE, jSONObject.toString());
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }

        @Override // com.tencent.qqmini.miniapp.audiorecorder.LameMp3Recorder.AudioRecordListener
        public void onRecordStart() {
            QMLog.d(AudioJsPlugin.TAG, "onRecordStart : " + this.isRecordManagerApi);
            if (this.isRecordManagerApi) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("state", "start");
                    AudioJsPlugin.this.sendSubscribeEvent(AudioJsPlugin.EVENT_RECORD_STATE_CHANGE, jSONObject.toString());
                } catch (Exception e16) {
                    e16.printStackTrace();
                    QMLog.e(AudioJsPlugin.TAG, e16.getMessage());
                }
            }
        }

        @Override // com.tencent.qqmini.miniapp.audiorecorder.LameMp3Recorder.AudioRecordListener
        public void onRecordStop(String str, long j3, long j16) {
            if (this.recorder == null) {
                return;
            }
            int fateOfRecorder = getFateOfRecorder();
            QMLog.d(AudioJsPlugin.TAG, "onRecordStop, fateOfRecorder is:" + fateOfRecorder + ", recordFilePath:" + str);
            if (fateOfRecorder == 0) {
                handleOnRecordEnd(str, j3, j16);
            }
        }

        public void pauseVoice(RequestEvent requestEvent) {
            if (this.recorder != null) {
                this.recorder.playPause();
                requestEvent.ok();
            } else {
                requestEvent.fail();
            }
        }

        public void playVoice(String str, RequestEvent requestEvent) {
            this.playVoiceReq = requestEvent;
            if (new File(str).exists()) {
                if (this.recorder == null) {
                    this.recorder = getLameMp3Recorder();
                    this.recorder.setOnPlayListener(this);
                    this.recorder.playStart(str);
                    return;
                }
                this.recorder.playStart(str);
                return;
            }
            handlePlayVoice(8);
        }

        public void release() {
            if (this.recorder != null) {
                this.recorder.onDestory();
            }
        }

        public void startRecord(RequestEvent requestEvent, boolean z16) {
            QMLog.i(AudioJsPlugin.TAG, "startRecord() begin");
            this.startRecordReq = requestEvent;
            this.isRecordManagerApi = z16;
            if (this.recorder != null && this.recorder.isRecording()) {
                QMLog.i(AudioJsPlugin.TAG, "startRecord() is recording now");
                return;
            }
            if (Environment.getExternalStorageState().equals("mounted")) {
                long[] sDCardMemory = DeviceInfoUtil.getSDCardMemory();
                if (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() > 1 && sDCardMemory != null && sDCardMemory[1] > 2) {
                    if (AudioHelper.isForbidByRubbishMeizu(1)) {
                        QMLog.i(AudioJsPlugin.TAG, "startRecord() " + this.context.getString(R.string.mini_sdk_microphone_forbidden));
                        requestEvent.fail();
                        return;
                    }
                    QMLog.d(AudioJsPlugin.TAG, "startRecord() is called");
                    if (this.recorder == null) {
                        this.recorder = getLameMp3Recorder();
                    }
                    QMLog.i(AudioJsPlugin.TAG, "path: " + this.recorder.getRecordFilPath());
                    ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).muteAudioFocus(this.context, true);
                    this.recorder.recordStart();
                    setFateOfRecorder(0);
                    return;
                }
                QMLog.d(AudioJsPlugin.TAG, "startRecord() " + this.context.getString(R.string.mini_sdk_sdcard_full_no_send));
                requestEvent.fail();
                return;
            }
            QMLog.w(AudioJsPlugin.TAG, "startRecord() " + this.context.getString(R.string.mini_sdk_nosdcardnosend));
            requestEvent.fail();
        }

        public void stopRecord(int i3, RequestEvent requestEvent, boolean z16) {
            this.isRecordManagerApi = z16;
            this.stopRecordReq = requestEvent;
            if (this.recorder != null) {
                this.recorder.recordStop();
                requestEvent.ok();
            } else {
                requestEvent.fail();
            }
        }

        public void stopVoice(RequestEvent requestEvent) {
            if (this.recorder != null) {
                this.recorder.playStop();
                requestEvent.ok();
            } else {
                requestEvent.fail();
            }
        }

        AudioManager(Activity activity) {
            this.maxTime = 600;
            this.audioDuration = 60000L;
            this.fileFormat = FileReaderHelper.MP3_EXT;
            this.fateOfRecorder = 0;
            this.context = activity;
        }

        @Override // com.tencent.qqmini.miniapp.audiorecorder.LameMp3Recorder.AudioPlayerListener
        public void onPlayUpdate(int i3, int i16) {
        }

        @Override // com.tencent.qqmini.miniapp.audiorecorder.LameMp3Recorder.AudioRecordListener
        public void onRecordUpdate(int i3, int i16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class BgMusicData {
        public final JSONObject jsonObject;
        public final RequestEvent req;

        BgMusicData(JSONObject jSONObject, RequestEvent requestEvent) {
            this.jsonObject = jSONObject;
            this.req = requestEvent;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class BgMusicManager {
        private static final int MSG_GET_MUSIC_PLAYER_STATE = 5;
        private static final int MSG_PAUSE = 2;
        private static final int MSG_PLAY = 1;
        private static final int MSG_SEEK = 4;
        private static final int MSG_STOP = 3;
        private MusicPlayerProxy musicPlayerProxy;

        private int convertState(int i3) {
            if (i3 == 2) {
                return 1;
            }
            if (i3 != 3) {
                return 2;
            }
            return 0;
        }

        private void getMusicPlayerState(RequestEvent requestEvent) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (AudioJsPlugin.this.getCurrentSongInfo() != null) {
                    AudioJsPlugin audioJsPlugin = AudioJsPlugin.this;
                    jSONObject.put("currentPosition", audioJsPlugin.mSecToSec(audioJsPlugin.getCurrentSongPosition()));
                    AudioJsPlugin audioJsPlugin2 = AudioJsPlugin.this;
                    jSONObject.put("duration", audioJsPlugin2.mSecToSec(audioJsPlugin2.getCurrentSongDuration()));
                    jSONObject.put("status", convertState(AudioJsPlugin.this.mPlayState));
                    jSONObject.put("dataUrl", AudioJsPlugin.this.getCurrentSongInfo().url);
                    requestEvent.ok(jSONObject);
                } else {
                    requestEvent.fail();
                }
            } catch (Exception unused) {
                requestEvent.fail();
            }
        }

        private void pauseQQMusic(RequestEvent requestEvent) {
            MusicPlayerProxy musicPlayerProxy = (MusicPlayerProxy) ProxyManager.get(MusicPlayerProxy.class);
            AudioJsPlugin.this.mBgMusicReq = requestEvent;
            try {
                musicPlayerProxy.pause();
            } catch (Exception unused) {
                requestEvent.fail();
            }
        }

        private void playNew(JSONObject jSONObject) throws RemoteException {
            SongInfo songInfo = new SongInfo();
            songInfo.f348087id = System.currentTimeMillis();
            songInfo.url = jSONObject.optString("dataUrl", jSONObject.optString("src"));
            songInfo.title = jSONObject.optString("title");
            songInfo.album = jSONObject.optString("epname");
            songInfo.singer = jSONObject.optString("singer");
            songInfo.coverUrl = jSONObject.optString(MessageForQQStory.KEY_COVER_IMG_URL);
            songInfo.detailUrl = jSONObject.optString("webUrl");
            songInfo.type = 9;
            songInfo.startTime = jSONObject.optInt("startTime", 0) * 1000;
            songInfo.fromMini = true;
            MusicPlayerProxy musicPlayerProxy = (MusicPlayerProxy) ProxyManager.get(MusicPlayerProxy.class);
            musicPlayerProxy.setPlayMode(100);
            musicPlayerProxy.startPlay(new SongInfo[]{songInfo}, 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void playQQMusic(JSONObject jSONObject, RequestEvent requestEvent) {
            MusicPlayerProxy musicPlayerProxy = (MusicPlayerProxy) ProxyManager.get(MusicPlayerProxy.class);
            if (musicPlayerProxy.isInit() && jSONObject != null) {
                AudioJsPlugin.this.mBgMusicReq = requestEvent;
                try {
                    SongInfo currentSong = musicPlayerProxy.getCurrentSong();
                    String optString = jSONObject.optString("dataUrl", jSONObject.optString("src"));
                    if (currentSong != null && optString.equals(currentSong.url)) {
                        if (AudioJsPlugin.this.mPlayState != 3 && AudioJsPlugin.this.mPlayState != 1) {
                            if (AudioJsPlugin.this.mPlayState == 4 || AudioJsPlugin.this.mPlayState == 0 || AudioJsPlugin.this.mPlayState == 8) {
                                playNew(jSONObject);
                            }
                        }
                        musicPlayerProxy.resume();
                    } else {
                        playNew(jSONObject);
                    }
                    return;
                } catch (Exception unused) {
                    requestEvent.fail();
                    return;
                }
            }
            requestEvent.fail();
        }

        private void seekMusic(JSONObject jSONObject, RequestEvent requestEvent) {
            float floatValue;
            if (this.musicPlayerProxy != null && jSONObject != null) {
                try {
                    String optString = jSONObject.optString("position");
                    String optString2 = jSONObject.optString(InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME);
                    float f16 = 0.0f;
                    if (TextUtils.isEmpty(optString)) {
                        floatValue = 0.0f;
                    } else {
                        floatValue = Float.valueOf(optString).floatValue();
                    }
                    if (!TextUtils.isEmpty(optString2)) {
                        f16 = Float.valueOf(optString2).floatValue();
                    }
                    int max = (int) (Math.max(floatValue, f16) * 1000.0f);
                    if (max >= 0) {
                        AudioJsPlugin.this.evaluateBgAudioStateJs("waiting");
                        AudioJsPlugin.this.evaluateBgAudioStateJs("seeking");
                        this.musicPlayerProxy.seekTo(max);
                        requestEvent.ok();
                        AudioJsPlugin.this.evaluateBgAudioStateJs("seeked");
                        AudioJsPlugin.this.evaluateBgAudioStateJs("play");
                        return;
                    }
                    requestEvent.fail();
                } catch (Exception e16) {
                    e16.printStackTrace();
                    QMLog.e(AudioJsPlugin.TAG, "seekMusic error. " + e16);
                    requestEvent.fail();
                }
            }
        }

        private void stopQQmMusic(RequestEvent requestEvent) {
            MusicPlayerProxy musicPlayerProxy = (MusicPlayerProxy) ProxyManager.get(MusicPlayerProxy.class);
            AudioJsPlugin.this.mBgMusicReq = requestEvent;
            try {
                musicPlayerProxy.stop();
            } catch (Exception unused) {
                requestEvent.fail();
            }
        }

        public void handleMessage(int i3, RequestEvent requestEvent) {
            handleMessage(i3, requestEvent, null);
        }

        BgMusicManager() {
            MusicPlayerProxy musicPlayerProxy = (MusicPlayerProxy) ProxyManager.get(MusicPlayerProxy.class);
            this.musicPlayerProxy = musicPlayerProxy;
            musicPlayerProxy.init(AudioJsPlugin.this.mMusicPlayerListener, ((BaseJsPlugin) AudioJsPlugin.this).mMiniAppInfo.appId, ((BaseJsPlugin) AudioJsPlugin.this).mMiniAppInfo.name);
        }

        public void handleMessage(int i3, RequestEvent requestEvent, JSONObject jSONObject) {
            if (i3 == 1) {
                playQQMusic(jSONObject, requestEvent);
                AudioJsPlugin.this.lastPlayData = new BgMusicData(jSONObject, requestEvent);
            } else if (i3 == 2) {
                pauseQQMusic(requestEvent);
                AudioJsPlugin.this.lastPlayData = null;
            } else if (i3 == 3) {
                stopQQmMusic(requestEvent);
                AudioJsPlugin.this.lastPlayData = null;
            } else if (i3 == 4) {
                seekMusic(jSONObject, requestEvent);
            } else {
                if (i3 != 5) {
                    return;
                }
                getMusicPlayerState(requestEvent);
            }
        }
    }

    private boolean checkAvalibleSdCard() {
        if (this.mMiniAppContext.getAttachActivity() == null) {
            return false;
        }
        if (Environment.getExternalStorageState().equals("mounted")) {
            long[] sDCardMemory = DeviceInfoUtil.getSDCardMemory();
            if (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() > 1 && sDCardMemory != null && sDCardMemory[1] > 2) {
                return true;
            }
            QMLog.d(TAG, "startRecord() " + this.mMiniAppContext.getAttachActivity().getString(R.string.mini_sdk_sdcard_full_no_send));
            return false;
        }
        QMLog.w(TAG, "startRecord() " + this.mMiniAppContext.getAttachActivity().getString(R.string.mini_sdk_nosdcardnosend));
        return false;
    }

    private int convertErrorCode(int i3) {
        if (i3 != 5) {
            if (i3 != 6) {
                if (i3 != 7) {
                    return -1;
                }
                return 10003;
            }
            return 10002;
        }
        return 10001;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void evaluateBgAudioStateJs(String str) {
        sendSubscribeEvent(EVENT_ON_BACKGROUND_STATE_CHANGE, JSONUtil.append(null, "state", str).toString());
    }

    private AudioManager getAudioManager() {
        if (this.mAudioManager == null) {
            this.mAudioManager = new AudioManager(this.mMiniAppContext.getAttachActivity());
        }
        return this.mAudioManager;
    }

    private BgMusicManager getBgMusicManager() {
        if (this.mBgMusicManager == null) {
            this.mBgMusicManager = new BgMusicManager();
        }
        return this.mBgMusicManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentSongDuration() {
        MusicPlayerProxy musicPlayerProxy = (MusicPlayerProxy) ProxyManager.get(MusicPlayerProxy.class);
        if (musicPlayerProxy != null) {
            try {
                this.mCurrentSongDuration = Math.max(musicPlayerProxy.getDuration(), 0);
            } catch (Exception e16) {
                QMLog.e(TAG, "getCurrentSongDuration exception ", e16);
            }
        }
        return this.mCurrentSongDuration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SongInfo getCurrentSongInfo() {
        MusicPlayerProxy musicPlayerProxy;
        SongInfo songInfo = this.mCurrentSongInfo;
        if (songInfo == null && (musicPlayerProxy = (MusicPlayerProxy) ProxyManager.get(MusicPlayerProxy.class)) != null) {
            try {
                return musicPlayerProxy.getCurrentSong();
            } catch (Exception e16) {
                QMLog.e(TAG, "getCurrentSongInfo exception ", e16);
                return songInfo;
            }
        }
        return songInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentSongPosition() {
        MusicPlayerProxy musicPlayerProxy = (MusicPlayerProxy) ProxyManager.get(MusicPlayerProxy.class);
        if (this.mPlayState == 3) {
            return this.mCurrentSongPosition;
        }
        if (musicPlayerProxy != null) {
            try {
                int max = Math.max(musicPlayerProxy.getCurrentSongPosition(), 0);
                this.mCurrentSongPosition = max;
                if (max % 1000 != 0) {
                    this.mCurrentSongPosition = ((max / 1000) + 1) * 1000;
                }
                this.mCurrentSongPosition = Math.min(this.mCurrentSongPosition, this.mCurrentSongDuration);
            } catch (Exception e16) {
                QMLog.e(TAG, "getCurrentSongPosition exception ", e16);
            }
        }
        return this.mCurrentSongPosition;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InnerAudioManager getInnerAudioManager(JSONObject jSONObject) {
        return this.mInnerAudioManagers.get(jSONObject.optInt(WebAudioPlugin.AUDIO_ID, -1));
    }

    private LameMp3Recorder getLameMp3Recorder() {
        return getAudioManager().getLameMp3Recorder();
    }

    private JSONObject getStateJson() throws Exception {
        SongInfo currentSong = ((MusicPlayerProxy) ProxyManager.get(MusicPlayerProxy.class)).getCurrentSong();
        if (currentSong == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("duration", mSecToSec(getCurrentSongDuration()));
        jSONObject.put(InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, mSecToSec(getCurrentSongPosition()));
        jSONObject.put("paused", isPaused());
        jSONObject.put("src", currentSong.url);
        jSONObject.put("title", currentSong.title);
        jSONObject.put("epname", currentSong.album);
        jSONObject.put("singer", currentSong.singer);
        jSONObject.put(MessageForQQStory.KEY_COVER_IMG_URL, currentSong.coverUrl);
        jSONObject.put("webUrl", currentSong.detailUrl);
        jSONObject.put(InnerAudioPlugin.AUDIO_PROPERTY_BUFFERED, mSecToSec(getCurrentSongDuration()));
        return jSONObject;
    }

    private boolean isPaused() {
        if (this.mPlayState != 2) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double mSecToSec(int i3) {
        return Math.max(i3 / 1000, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onMusicCanplay() {
        Log.i(TAG, "onMusicCanplay: " + Thread.currentThread().getId());
        evaluateBgAudioStateJs("canplay");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onMusicError() {
        QMLog.i(TAG, "onMusicError " + this.mPlayState);
        if (this.mPlayState == 5) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("state", "error");
            jSONObject.put("errorCode", convertErrorCode(this.mPlayState));
            sendSubscribeEvent(EVENT_ON_BACKGROUND_STATE_CHANGE, jSONObject.toString());
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        this.mBgMusicReq.fail();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onMusicPause() {
        sendSubscribeEvent("onMusicPause", null);
        evaluateBgAudioStateJs("pause");
        this.mBgMusicReq.ok();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onMusicPlay() {
        try {
            LockMethodProxy.sleep(500L);
        } catch (InterruptedException unused) {
        }
        String str = null;
        try {
            JSONObject stateJson = getStateJson();
            if (stateJson != null) {
                str = stateJson.toString();
            }
        } catch (Exception e16) {
            Log.w(TAG, "onMusicPlay: ", e16);
        }
        Log.i(TAG, "onMusicPlay: " + str);
        sendSubscribeEvent("onMusicPlay", str);
        evaluateBgAudioStateJs("play");
        this.mBgMusicReq.ok();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onMusicStop() {
        sendSubscribeEvent("onMusicEnd", null);
        evaluateBgAudioStateJs("stop");
        this.mBgMusicReq.ok();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onMusicWaiting() {
        evaluateBgAudioStateJs("waiting");
    }

    private void operateRecorderByLameMp3(String str, RequestEvent requestEvent) {
        LameMp3Recorder lameMp3Recorder = getLameMp3Recorder();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("operationType");
            if ("start".equals(optString)) {
                if (!checkAvalibleSdCard()) {
                    requestEvent.fail();
                    return;
                } else {
                    updateAudioConfig(lameMp3Recorder, jSONObject);
                    getAudioManager().startRecord(requestEvent, true);
                }
            } else if ("stop".equals(optString)) {
                getAudioManager().stopRecord(0, requestEvent, true);
            } else if ("pause".equals(optString)) {
                lameMp3Recorder.recordPause();
            } else if ("resume".equals(optString)) {
                lameMp3Recorder.recordResume();
            }
            requestEvent.ok();
        } catch (Exception e16) {
            QMLog.e(TAG, "operateRecorderByLameMp3 failed:", e16);
            requestEvent.fail();
        }
    }

    private String parseAudioFormat(String str) {
        if (TextUtils.isEmpty(str)) {
            return FileReaderHelper.MP3_EXT;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.endsWith(FileReaderHelper.AAC_EXT)) {
            return FileReaderHelper.M4A_EXT;
        }
        lowerCase.endsWith(FileReaderHelper.MP3_EXT);
        return FileReaderHelper.MP3_EXT;
    }

    private void updateAudioConfig(LameMp3Recorder lameMp3Recorder, JSONObject jSONObject) throws Exception {
        String optString = jSONObject.optString("sampleRate");
        String optString2 = jSONObject.optString("numberOfChannels");
        String optString3 = jSONObject.optString("audioSource");
        if (!TextUtils.isEmpty(optString3)) {
            lameMp3Recorder.setAudioSource(optString3);
        }
        if (!TextUtils.isEmpty(optString)) {
            lameMp3Recorder.setSampleRate(Integer.parseInt(optString));
        }
        if (!TextUtils.isEmpty(optString2)) {
            lameMp3Recorder.setOutChannel(Integer.parseInt(optString2));
        }
        String optString4 = jSONObject.optString("encodeBitRate");
        if (!TextUtils.isEmpty(optString4)) {
            lameMp3Recorder.setOutBitRate(Integer.parseInt(optString4));
        }
        String parseAudioFormat = parseAudioFormat(jSONObject.optString("format"));
        if (!TextUtils.isEmpty(parseAudioFormat)) {
            lameMp3Recorder.setRecordFileFormat(parseAudioFormat);
        }
        int optInt = jSONObject.optInt("duration");
        if (optInt < 0) {
            optInt = 1000;
        } else if (optInt > 600000) {
            optInt = 600000;
        }
        if (optInt > 1) {
            lameMp3Recorder.setMaxRecordTime(optInt / 1000);
        }
        lameMp3Recorder.setCallbackFrameSize(jSONObject.optInt("frameSize") * 1024);
        lameMp3Recorder.setRecordFilPath(((MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class)).getTmpPath(parseAudioFormat));
    }

    @JsEvent({"createAudioInstance"})
    public String createAudioInstance(RequestEvent requestEvent) {
        InnerAudioManager innerAudioManager = new InnerAudioManager();
        JSONObject audioContext = innerAudioManager.getAudioContext();
        try {
            int duration = innerAudioManager.getDuration();
            double currentPosition = innerAudioManager.getCurrentPosition();
            boolean isPaused = innerAudioManager.isPaused();
            int incrementAndGet = sId.incrementAndGet();
            audioContext.put("duration", duration);
            audioContext.put(InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, currentPosition);
            audioContext.put("paused", isPaused);
            audioContext.put(InnerAudioPlugin.AUDIO_PROPERTY_BUFFERED, duration);
            audioContext.put(WebAudioPlugin.AUDIO_ID, incrementAndGet);
            innerAudioManager.audioId = incrementAndGet;
            this.mInnerAudioManagers.put(incrementAndGet, innerAudioManager);
            requestEvent.ok(audioContext);
            return ApiUtil.wrapCallbackOk("createAudioInstance", audioContext).toString();
        } catch (Exception e16) {
            QMLog.e(TAG, "createAudioInstance failed:", e16);
            requestEvent.fail();
            return ApiUtil.wrapCallbackFail("createAudioInstance", null).toString();
        }
    }

    @JsEvent({"destroyAudioInstance"})
    public void destroyAudioInstance(RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            InnerAudioManager innerAudioManager = getInnerAudioManager(jSONObject);
            if (innerAudioManager != null) {
                innerAudioManager.destroy();
                this.mInnerAudioManagers.remove(jSONObject.optInt(WebAudioPlugin.AUDIO_ID, -1));
            }
        } catch (Exception e16) {
            QMLog.e(TAG, "destroyAudioInstance failed:", e16);
            requestEvent.fail();
        }
    }

    @JsEvent({"getAudioState"})
    public void getAudioState(RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            InnerAudioManager innerAudioManager = getInnerAudioManager(jSONObject);
            if (innerAudioManager != null) {
                JSONObject audioContext = innerAudioManager.getAudioContext();
                InnerAudioManager innerAudioManager2 = getInnerAudioManager(jSONObject);
                int duration = innerAudioManager2.getDuration();
                double currentPosition = innerAudioManager2.getCurrentPosition();
                boolean isPaused = innerAudioManager2.isPaused();
                audioContext.put("duration", duration);
                audioContext.put(InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, currentPosition);
                audioContext.put("paused", isPaused);
                audioContext.put(InnerAudioPlugin.AUDIO_PROPERTY_BUFFERED, duration);
                requestEvent.ok(audioContext);
            } else {
                requestEvent.fail();
            }
        } catch (Exception e16) {
            QMLog.e(TAG, "getAudioState failed:", e16);
            requestEvent.fail();
        }
    }

    @JsEvent({"getAvailableAudioSources"})
    public void getAvailableAudioSources(RequestEvent requestEvent) {
        String[] strArr = {"auto", MiniGameLameMp3EncodeThread.AUDIO_SOURCE_MIC, MiniGameLameMp3EncodeThread.AUDIO_SOURCE_CAMCORDER, MiniGameLameMp3EncodeThread.AUDIO_SOURCE_VOICE_COMMUNICATION, MiniGameLameMp3EncodeThread.AUDIO_SOURCE_VOICE_RECOGNITION};
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("audioSources", Arrays.toString(strArr));
            requestEvent.ok(jSONObject);
        } catch (Exception e16) {
            QMLog.e(TAG, "getAvailableAudioSources failed:", e16);
            requestEvent.fail();
        }
    }

    @JsEvent({com.tencent.luggage.wxa.zd.k.NAME})
    public void getBackgroundAudioState(RequestEvent requestEvent) {
        JSONObject jSONObject;
        try {
            int i3 = this.mPlayState;
            if ((i3 == 3 || i3 == 1) && (jSONObject = this.mBgAudioState) != null) {
                jSONObject.put("paused", isPaused());
                requestEvent.ok(this.mBgAudioState);
                Log.i(TAG, "getBackgroundAudioState: pause");
                return;
            }
            if (!((MusicPlayerProxy) ProxyManager.get(MusicPlayerProxy.class)).isPlaying()) {
                Log.i(TAG, "getBackgroundAudioState: isPlaying = false ");
                return;
            }
            JSONObject stateJson = getStateJson();
            Log.i(TAG, "getBackgroundAudioState: " + stateJson);
            if (stateJson != null) {
                Log.i(TAG, "getBackgroundAudioState: ok " + Thread.currentThread().getId() + " " + stateJson.toString());
                requestEvent.ok(stateJson);
                this.mBgAudioState = stateJson;
            }
        } catch (Exception e16) {
            QMLog.e(TAG, "getBackgroundAudioState failed:", e16);
            requestEvent.fail();
        }
    }

    @JsEvent({com.tencent.luggage.wxa.zd.l.NAME})
    public void getMusicPlayerState(RequestEvent requestEvent) {
        getBgMusicManager().handleMessage(5, requestEvent);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onCreate(IMiniAppContext iMiniAppContext) {
        super.onCreate(iMiniAppContext);
        MusicPlayerProxy musicPlayerProxy = (MusicPlayerProxy) ProxyManager.get(MusicPlayerProxy.class);
        MusicPlayerProxy.MusicPlayerListener musicPlayerListener = this.mMusicPlayerListener;
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        musicPlayerProxy.init(musicPlayerListener, miniAppInfo.appId, miniAppInfo.name);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onDestroy() {
        super.onDestroy();
        try {
            QMLog.d(TAG, "audio plugin onDestroy");
            if (this.mAudioManager != null) {
                this.mAudioManager.release();
            }
            for (int i3 = 0; i3 > this.mInnerAudioManagers.size(); i3++) {
                this.mInnerAudioManagers.valueAt(i3).release();
            }
            ((MusicPlayerProxy) ProxyManager.get(MusicPlayerProxy.class)).unInit();
        } catch (Throwable th5) {
            QMLog.e(TAG, "onDestroy Exception ", th5);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onPause() {
        super.onPause();
        try {
            if (this.mInnerAudioManagers != null && this.mInnerAudioManagers.size() > 0) {
                QMLog.i(TAG, "onPause mInnerAudioManagers size:" + this.mInnerAudioManagers.size());
                for (int i3 = 0; i3 < this.mInnerAudioManagers.size(); i3++) {
                    InnerAudioManager valueAt = this.mInnerAudioManagers.valueAt(i3);
                    if (valueAt != null && !valueAt.isPaused()) {
                        valueAt.pause();
                    }
                }
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, "onPause - manager.pause get a throwable", th5);
        }
        if (this.lastPlayData == null) {
            return;
        }
        if (isPaused()) {
            this.lastPlayData = null;
            return;
        }
        SongInfo currentSongInfo = getCurrentSongInfo();
        if (currentSongInfo == null) {
            this.lastPlayData = null;
            return;
        }
        String str = currentSongInfo.url;
        JSONObject jSONObject = this.lastPlayData.jsonObject;
        String optString = jSONObject.optString("dataUrl", jSONObject.optString("src"));
        if (TextUtils.isEmpty(optString) || !optString.equals(str)) {
            this.lastPlayData = null;
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onResume() {
        super.onResume();
        if (this.lastPlayData == null) {
            return;
        }
        Log.i(TAG, "onResume: resume play");
        BgMusicManager bgMusicManager = getBgMusicManager();
        BgMusicData bgMusicData = this.lastPlayData;
        bgMusicManager.playQQMusic(bgMusicData.jsonObject, bgMusicData.req);
    }

    @JsEvent({"operateAudio"})
    public void operateAudio(RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            InnerAudioManager innerAudioManager = getInnerAudioManager(jSONObject);
            if (innerAudioManager != null) {
                String optString = jSONObject.optString("operationType");
                if ("play".equals(optString)) {
                    innerAudioManager.play();
                } else if ("pause".equals(optString)) {
                    innerAudioManager.pause();
                } else if ("stop".equals(optString)) {
                    innerAudioManager.stop();
                } else if (InnerAudioPlugin.AUDIO_OPERATE_SEEK.equals(optString)) {
                    innerAudioManager.seek((int) jSONObject.optDouble(InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME));
                }
                requestEvent.ok();
            }
        } catch (Exception e16) {
            QMLog.e(TAG, "operateAudio failed:", e16);
            requestEvent.fail();
        }
    }

    @JsEvent({com.tencent.mm.plugin.appbrand.jsapi.audio.b.NAME})
    public void operateBackgroundAudio(RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            String optString = jSONObject.optString("operationType");
            if ("play".equals(optString)) {
                if (this.mBgAudioState != null) {
                    getBgMusicManager().handleMessage(1, requestEvent, this.mBgAudioState);
                }
            } else if ("pause".equals(optString)) {
                getBgMusicManager().handleMessage(2, requestEvent);
            } else if ("stop".equals(optString)) {
                getBgMusicManager().handleMessage(3, requestEvent);
            } else if (InnerAudioPlugin.AUDIO_OPERATE_SEEK.equals(optString) && this.mBgAudioState != null) {
                getBgMusicManager().handleMessage(4, requestEvent, jSONObject);
                requestEvent.ok();
            }
        } catch (Exception e16) {
            QMLog.e(TAG, "operateBackgroundAudio failed:", e16);
            requestEvent.fail();
        }
    }

    @JsEvent({JsApiOperateMusicPlayer.NAME})
    public void operateMusicPlayer(RequestEvent requestEvent) {
        MusicPlayerProxy musicPlayerProxy = (MusicPlayerProxy) ProxyManager.get(MusicPlayerProxy.class);
        MusicPlayerProxy.MusicPlayerListener musicPlayerListener = this.mMusicPlayerListener;
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        musicPlayerProxy.init(musicPlayerListener, miniAppInfo.appId, miniAppInfo.name);
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            String optString = jSONObject.optString("operationType");
            Log.i(TAG, "operateMusicPlayer: " + optString);
            if ("play".equals(optString)) {
                this.mBgAudioState = jSONObject;
                getBgMusicManager().handleMessage(1, requestEvent, jSONObject);
            } else if ("pause".equals(optString)) {
                getBgMusicManager().handleMessage(2, requestEvent);
            } else if ("stop".equals(optString)) {
                getBgMusicManager().handleMessage(3, requestEvent);
            } else if (InnerAudioPlugin.AUDIO_OPERATE_SEEK.equals(optString)) {
                getBgMusicManager().handleMessage(4, requestEvent, jSONObject);
                requestEvent.ok();
            }
        } catch (Exception e16) {
            QMLog.e(TAG, "operateMusicPlayer failed:", e16);
            requestEvent.fail();
        }
    }

    @JsEvent({"operateRecorder"})
    public void operateRecorder(RequestEvent requestEvent) {
        try {
            operateRecorderByLameMp3(requestEvent.jsonParams, requestEvent);
        } catch (Exception e16) {
            QMLog.e(TAG, "operateRecorder failed:", e16);
            requestEvent.fail();
        }
    }

    @JsEvent({"pauseVoice"})
    public void pauseVoice(RequestEvent requestEvent) {
        getAudioManager().pauseVoice(requestEvent);
    }

    @JsEvent({"playVoice"})
    public void playVoice(RequestEvent requestEvent) {
        try {
            String optString = new JSONObject(requestEvent.jsonParams).optString("filePath");
            if (!TextUtils.isEmpty(optString)) {
                getAudioManager().playVoice(((MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(optString), requestEvent);
            } else {
                requestEvent.fail();
            }
        } catch (Exception e16) {
            QMLog.e(TAG, "playVoice failed:", e16);
            requestEvent.fail();
        }
    }

    @JsEvent({"setAudioState"})
    public void setAudioState(final RequestEvent requestEvent) {
        try {
            final JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            getInnerAudioManager(jSONObject).setAudioContext(jSONObject);
            String optString = jSONObject.optString("src");
            if (!TextUtils.isEmpty(optString)) {
                jSONObject.put("src", ((MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(optString));
                getInnerAudioManager(jSONObject).playNew(jSONObject.optBoolean("autoplay"), new MiniAppAudioPlayer.OnPreparedListener() { // from class: com.tencent.qqmini.miniapp.plugin.AudioJsPlugin.2
                    @Override // com.tencent.qqmini.miniapp.widget.media.MiniAppAudioPlayer.OnPreparedListener
                    public void onPrepared() {
                        JSONObject audioContext = AudioJsPlugin.this.getInnerAudioManager(jSONObject).getAudioContext();
                        InnerAudioManager innerAudioManager = AudioJsPlugin.this.getInnerAudioManager(jSONObject);
                        int duration = innerAudioManager.getDuration();
                        double currentPosition = innerAudioManager.getCurrentPosition();
                        boolean isPaused = innerAudioManager.isPaused();
                        try {
                            audioContext.put("duration", duration);
                            audioContext.put(InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, currentPosition);
                            audioContext.put("paused", isPaused);
                            audioContext.put(InnerAudioPlugin.AUDIO_PROPERTY_BUFFERED, duration);
                        } catch (JSONException e16) {
                            e16.printStackTrace();
                        }
                        requestEvent.ok(audioContext);
                    }
                });
            } else {
                QMLog.e(TAG, "setAudioState err" + requestEvent.jsonParams);
                requestEvent.fail();
            }
        } catch (Exception e16) {
            QMLog.e(TAG, "setAudioState err", e16);
            requestEvent.fail();
        }
    }

    @JsEvent({JsApiSetBackgroundAudioState.NAME})
    public void setBackgroundAudioState(RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            String optString = jSONObject.optString("src");
            Log.i(TAG, "setBackgroundAudioState: " + requestEvent.jsonParams);
            if (!TextUtils.isEmpty(optString)) {
                jSONObject.put("src", ((MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(optString));
                this.mBgAudioState = jSONObject;
                getBgMusicManager().handleMessage(1, requestEvent, this.mBgAudioState);
                requestEvent.ok();
            }
        } catch (Exception e16) {
            QMLog.e(TAG, "setBackgroundAudioState failed:", e16);
            requestEvent.fail();
        }
    }

    @JsEvent({com.tencent.luggage.wxa.zd.n.NAME})
    public void setInnerAudioOption(RequestEvent requestEvent) {
        try {
            String optString = new JSONObject(requestEvent.jsonParams).optString("mixWithOther");
            if (!TextUtils.isEmpty(optString)) {
                if (optString.equalsIgnoreCase("true")) {
                    mMixWithOther = true;
                } else if (optString.equalsIgnoreCase("false")) {
                    mMixWithOther = false;
                }
                requestEvent.ok();
            }
        } catch (Exception e16) {
            QMLog.e(TAG, "setInnerAudioOption failed:", e16);
            requestEvent.fail();
        }
    }

    @JsEvent({"startRecord"})
    public void startRecord(RequestEvent requestEvent) {
        try {
            updateAudioConfig(getLameMp3Recorder(), new JSONObject(requestEvent.jsonParams));
            getAudioManager().startRecord(requestEvent, false);
        } catch (Exception e16) {
            QMLog.e(TAG, "startRecord failed:", e16);
            requestEvent.fail();
        }
    }

    @JsEvent({"stopRecord"})
    public void stopRecord(RequestEvent requestEvent) {
        getAudioManager().stopRecord(0, requestEvent, false);
    }

    @JsEvent({"stopVoice"})
    public void stopVoice(RequestEvent requestEvent) {
        getAudioManager().stopVoice(requestEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class InnerAudioManager implements MiniAppAudioPlayer.AudioPlayerListener {
        public int audioId;
        private volatile boolean isStart;
        private long lastStartTime;
        private MiniAppAudioPlayer mPlayer;
        private int startTime;
        private String src = "";
        private JSONObject audioContext = new JSONObject();

        public InnerAudioManager() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            release();
        }

        private void evaluateAudioState(String str) {
            JSONObject append = JSONUtil.append(null, "state", str);
            JSONUtil.append(append, WebAudioPlugin.AUDIO_ID, Integer.valueOf(this.audioId));
            AudioJsPlugin.this.sendSubscribeEvent("onAudioStateChange", append.toString());
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x001a, code lost:
        
            if (r3 == 200) goto L18;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void evaluateErrorCallback(int i3, int i16) {
            int i17;
            if (i3 != -1010) {
                if (i3 != -1007) {
                    if (i3 != -1004 && i3 != -110) {
                        i17 = -1;
                        if (i3 != 1) {
                            if (i3 != 100) {
                            }
                        }
                    } else {
                        i17 = 10002;
                    }
                }
                i17 = 10001;
            } else {
                i17 = 10003;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("state", "Error");
                jSONObject.put(WebAudioPlugin.AUDIO_ID, this.audioId);
                jSONObject.put("errCode", i17);
                AudioJsPlugin.this.sendSubscribeEvent("onAudioStateChange", jSONObject.toString());
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getCurrentPosition() {
            MiniAppAudioPlayer miniAppAudioPlayer = this.mPlayer;
            if (miniAppAudioPlayer != null) {
                return miniAppAudioPlayer.getCurrentPosition();
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getDuration() {
            MiniAppAudioPlayer miniAppAudioPlayer = this.mPlayer;
            if (miniAppAudioPlayer != null) {
                return miniAppAudioPlayer.getDuration();
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isPaused() {
            MiniAppAudioPlayer miniAppAudioPlayer = this.mPlayer;
            if (miniAppAudioPlayer != null && miniAppAudioPlayer.isPlaying()) {
                return false;
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void pause() {
            long currentTimeMillis = System.currentTimeMillis() - this.lastStartTime;
            if (currentTimeMillis < 50) {
                AppBrandTask.runTaskOnUiThreadDelay(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.AudioJsPlugin.InnerAudioManager.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (InnerAudioManager.this.mPlayer != null && InnerAudioManager.this.mPlayer.isPlaying()) {
                            InnerAudioManager.this.mPlayer.pause();
                        }
                    }
                }, 50 - currentTimeMillis);
                return;
            }
            MiniAppAudioPlayer miniAppAudioPlayer = this.mPlayer;
            if (miniAppAudioPlayer != null && miniAppAudioPlayer.isPlaying()) {
                this.mPlayer.pause();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void play() {
            MiniAppAudioPlayer miniAppAudioPlayer = this.mPlayer;
            if (miniAppAudioPlayer != null && (miniAppAudioPlayer.isPaused() || this.mPlayer.isPrepared())) {
                this.mPlayer.setAudioFocus(true ^ AudioJsPlugin.mMixWithOther);
                this.mPlayer.start();
            } else {
                playNew(true, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void playNew(final boolean z16, final MiniAppAudioPlayer.OnPreparedListener onPreparedListener) {
            JSONObject jSONObject = this.audioContext;
            if (jSONObject != null) {
                String optString = jSONObject.optString("src");
                int optInt = this.audioContext.optInt("startTime");
                final boolean optBoolean = this.audioContext.optBoolean("loop");
                final double optDouble = this.audioContext.optDouble(InnerAudioPlugin.AUDIO_PROPERTY_VOLUME);
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                if (this.mPlayer == null) {
                    this.mPlayer = new MiniAppAudioPlayer(ThreadManager.getSubThreadHandler());
                }
                if (this.mPlayer.isPlaying() && this.src.equals(optString) && this.startTime == optInt) {
                    this.mPlayer.setVolume((float) optDouble);
                    this.mPlayer.setLooping(optBoolean);
                    return;
                }
                this.src = optString;
                this.startTime = optInt;
                this.mPlayer.setAudioPlayerListener(this);
                this.mPlayer.setAudioContext(AppLoaderFactory.g().getContext());
                this.mPlayer.setStartTime(this.startTime);
                this.mPlayer.setDataSource(this.src, new MiniAppAudioPlayer.OnPreparedListener() { // from class: com.tencent.qqmini.miniapp.plugin.AudioJsPlugin.InnerAudioManager.1
                    @Override // com.tencent.qqmini.miniapp.widget.media.MiniAppAudioPlayer.OnPreparedListener
                    public void onPrepared() {
                        if (z16 && InnerAudioManager.this.mPlayer != null) {
                            InnerAudioManager.this.mPlayer.setLooping(optBoolean);
                            InnerAudioManager.this.mPlayer.setVolume((float) optDouble);
                            InnerAudioManager.this.mPlayer.setAudioFocus(!AudioJsPlugin.mMixWithOther);
                            InnerAudioManager.this.mPlayer.start();
                        }
                        MiniAppAudioPlayer.OnPreparedListener onPreparedListener2 = onPreparedListener;
                        if (onPreparedListener2 != null) {
                            onPreparedListener2.onPrepared();
                        }
                    }
                });
                this.lastStartTime = System.currentTimeMillis();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void release() {
            MiniAppAudioPlayer miniAppAudioPlayer = this.mPlayer;
            if (miniAppAudioPlayer != null) {
                miniAppAudioPlayer.release();
                this.mPlayer = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void seek(final int i3) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastStartTime;
            if (currentTimeMillis < 100) {
                AppBrandTask.runTaskOnUiThreadDelay(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.AudioJsPlugin.InnerAudioManager.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (InnerAudioManager.this.mPlayer != null) {
                            InnerAudioManager.this.mPlayer.seekTo(i3);
                        }
                    }
                }, 100 - currentTimeMillis);
                return;
            }
            MiniAppAudioPlayer miniAppAudioPlayer = this.mPlayer;
            if (miniAppAudioPlayer != null) {
                miniAppAudioPlayer.seekTo(i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void stop() {
            MiniAppAudioPlayer miniAppAudioPlayer = this.mPlayer;
            if (miniAppAudioPlayer != null) {
                miniAppAudioPlayer.stop();
            }
        }

        public JSONObject getAudioContext() {
            return this.audioContext;
        }

        @Override // com.tencent.qqmini.miniapp.widget.media.MiniAppAudioPlayer.AudioPlayerListener
        public void onError(int i3, int i16) {
            evaluateErrorCallback(i3, i16);
        }

        @Override // com.tencent.qqmini.miniapp.widget.media.MiniAppAudioPlayer.AudioPlayerListener
        public void onPlayerProgress(String str, int i3, int i16) {
            if (this.isStart) {
                evaluateAudioState("TimeUpdate");
            }
        }

        @Override // com.tencent.qqmini.miniapp.widget.media.MiniAppAudioPlayer.AudioPlayerListener
        public void onPlayerSeek(boolean z16, int i3) {
            String str;
            QMLog.i(AudioJsPlugin.TAG, "onPlayerSeek Completed : " + z16 + "; position : " + i3);
            if (z16) {
                str = "Seeked";
            } else {
                str = "Seeking";
            }
            evaluateAudioState(str);
        }

        @Override // com.tencent.qqmini.miniapp.widget.media.MiniAppAudioPlayer.AudioPlayerListener
        public void onPlayerStateChange(int i3) {
            if (i3 == 0) {
                evaluateAudioState("Waiting");
                return;
            }
            if (i3 == 1) {
                evaluateAudioState("Canplay");
                return;
            }
            if (i3 == 2) {
                this.isStart = true;
                evaluateAudioState("Play");
                return;
            }
            if (i3 == 3) {
                this.isStart = false;
                evaluateAudioState("Pause");
            } else if (i3 == 4) {
                this.isStart = false;
                evaluateAudioState("Stop");
            } else if (i3 == 5) {
                this.isStart = false;
                evaluateAudioState("Ended");
                release();
            }
        }

        public void setAudioContext(JSONObject jSONObject) {
            this.audioContext = jSONObject;
        }

        @Override // com.tencent.qqmini.miniapp.widget.media.MiniAppAudioPlayer.AudioPlayerListener
        public void onPlayerBufferingUpdate(int i3) {
        }
    }
}
