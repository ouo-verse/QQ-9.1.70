package com.tencent.qqmini.minigame.plugins;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.qqmini.minigame.R;
import com.tencent.qqmini.minigame.audiorecorder.MiniGameLameMp3Recorder;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.core.utils.NativeBuffer;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.DeviceInfoUtil;
import com.tencent.xweb.FileReaderHelper;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class AudioRecorderJsPlugin extends BaseJsPlugin {
    private static final String EVENT_RECORD_STATE_CHANGE = "onRecorderStateChange";
    private static final String LAME_MP3_SO_PATH_STRING = "lameMp3SoPath";
    private static final String MINI_GAME_LAME_MP3_SO_PATH = "MiniGameLameMp3SoPath";
    private static final String RECORD_PAUSE = "pause";
    private static final String RECORD_RESUME = "resume";
    private static final String RECORD_START = "start";
    private static final String RECORD_STOP = "stop";
    private static final String TAG = "AudioRecorderJsPlugin";
    private boolean hasLoadedSo = false;
    private volatile AudioManager mAudioManager;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class AudioManager implements MiniGameLameMp3Recorder.AudioRecordListener {
        public static final String CLASS_NAME_APP_OPS_MANAGER = "AppOpsManager";
        private static final String DEFAULT_AUDIO_SOURCE = "mic";
        private static final String DEFAULT_FILE_FORMAT = "mp3";
        private static final int DEFAULT_FRAME_SIZE = 0;
        private static final int DEFAULT_IN_CHANNEL = 1;
        private static final int DEFAULT_OUT_BIT_RATE = 48000;
        private static final long DEFAULT_RECORD_TIME = 60000;
        private static final int DEFAULT_SAMPLE_RATE = 8000;
        public static final String FUNCTION_NAME_CHECK_OP_NOT_THROW = "checkOpNoThrow";
        public static final String MANUFACTURER_MEI_ZU = "MeiZu";
        private static final int MAX_FRAME_SIZE = 100;
        private static final int MAX_IN_CHANNEL = 2;
        private static final long MAX_RECORD_TIME = 600000;
        private static final long MIN_RECORD_TIME = 1000;
        public static final int OP_RECORD_AUDIO = 27;
        private String audioSourceStr;
        private Context context;
        private String fileFormat;
        private int frameSize;
        private IJsService iJsService;
        private int inChannel;
        private int outBitRate;
        private long recordTime;
        private volatile MiniGameLameMp3Recorder recorder;
        private int sampleRate;

        private String getAudioFormat(String str) {
            if (TextUtils.isEmpty(str)) {
                return "mp3";
            }
            String lowerCase = str.toLowerCase();
            if (lowerCase.endsWith(FileReaderHelper.AAC_EXT)) {
                return FileReaderHelper.M4A_EXT;
            }
            lowerCase.endsWith("mp3");
            return "mp3";
        }

        private String getTransferFilePath(String str) {
            String tmpPath = ((MiniAppFileManager) ((BaseJsPlugin) AudioRecorderJsPlugin.this).mMiniAppContext.getManager(MiniAppFileManager.class)).getTmpPath(str);
            try {
                FileUtils.createFile(tmpPath);
            } catch (Exception e16) {
                QMLog.w(AudioRecorderJsPlugin.TAG, "getTransferFilePath fail", e16);
            }
            return tmpPath;
        }

        private void initRecorder(String str) {
            if (this.recorder == null) {
                this.recorder = new MiniGameLameMp3Recorder();
            }
            updateRecorderConfig(str);
            this.recorder.initThread();
            this.recorder.setAudioRecordListener(this);
            this.recorder.setRecordFilePath(getTransferFilePath(this.fileFormat));
            this.recorder.setRecordTime(this.recordTime);
            this.recorder.setSampleRate(this.sampleRate);
            this.recorder.setInChannel(this.inChannel);
            this.recorder.setOutBitRate(this.outBitRate);
            this.recorder.setRecordFileFormat(this.fileFormat);
            this.recorder.setCallbackFrameSize(this.frameSize);
            this.recorder.setAudioSource(this.audioSourceStr);
        }

        private void updateRecorderConfig(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                long optLong = jSONObject.optLong("duration");
                this.recordTime = optLong;
                if (optLong <= 0) {
                    optLong = 60000;
                }
                this.recordTime = optLong;
                long max = Math.max(optLong, 1000L);
                this.recordTime = max;
                this.recordTime = Math.min(max, 600000L);
                int optInt = jSONObject.optInt("sampleRate");
                this.sampleRate = optInt;
                if (optInt <= 0) {
                    optInt = 8000;
                }
                this.sampleRate = optInt;
                int optInt2 = jSONObject.optInt("numberOfChannels");
                this.inChannel = optInt2;
                if (optInt2 <= 0) {
                    optInt2 = 1;
                }
                this.inChannel = optInt2;
                Math.min(optInt2, 2);
                this.inChannel = 1;
                int optInt3 = jSONObject.optInt("encodeBitRate");
                this.outBitRate = optInt3;
                if (optInt3 <= 0) {
                    optInt3 = 48000;
                }
                this.outBitRate = optInt3;
                this.outBitRate = optInt3 / 1000;
                getAudioFormat(jSONObject.optString("format"));
                this.fileFormat = "mp3";
                int optInt4 = jSONObject.optInt("frameSize");
                this.frameSize = optInt4;
                if (optInt4 < 0) {
                    optInt4 = 0;
                }
                this.frameSize = optInt4;
                this.frameSize = Math.min(optInt4, 100) * 1024;
                String optString = jSONObject.optString("audioSource");
                this.audioSourceStr = optString;
                if (TextUtils.isEmpty(optString)) {
                    this.audioSourceStr = "mic";
                }
            } catch (JSONException e16) {
                QMLog.w(AudioRecorderJsPlugin.TAG, "updateRecorderConfig fail", e16);
            }
        }

        public void destroy() {
            try {
                this.context = null;
                this.iJsService = null;
                if (this.recorder != null) {
                    this.recorder.recordStop();
                }
            } catch (Exception e16) {
                QMLog.e(AudioRecorderJsPlugin.TAG, "destroy exception", e16);
            }
        }

        public boolean isForbidByMeiZu(Context context) {
            boolean z16 = false;
            if (!MANUFACTURER_MEI_ZU.equalsIgnoreCase(Build.MANUFACTURER)) {
                return false;
            }
            Object systemService = context.getSystemService("appops");
            if (systemService != null && systemService.getClass().getSimpleName().equals(CLASS_NAME_APP_OPS_MANAGER)) {
                try {
                    Class<?> cls = systemService.getClass();
                    Class<?> cls2 = Integer.TYPE;
                    Method method = cls.getMethod(FUNCTION_NAME_CHECK_OP_NOT_THROW, cls2, cls2, String.class);
                    ApplicationInfo applicationInfo = AppLoaderFactory.g().getContext().getApplicationInfo();
                    if (((Integer) method.invoke(systemService, 27, Integer.valueOf(applicationInfo.uid), applicationInfo.packageName)).intValue() != 0) {
                        z16 = true;
                    }
                    QMLog.i(AudioRecorderJsPlugin.TAG, "isForbidByMeiZu result = " + z16);
                } catch (Exception e16) {
                    QMLog.e(AudioRecorderJsPlugin.TAG, "isForbidByMeiZu fail", e16);
                }
            }
            return z16;
        }

        @Override // com.tencent.qqmini.minigame.audiorecorder.MiniGameLameMp3Recorder.AudioRecordListener
        public void onRecordError(String str) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("state", "error");
                jSONObject.put("errMsg", "recordError:" + str);
                AudioRecorderJsPlugin.this.sendSubscribeEvent(AudioRecorderJsPlugin.EVENT_RECORD_STATE_CHANGE, jSONObject.toString());
            } catch (Exception e16) {
                QMLog.w(AudioRecorderJsPlugin.TAG, "onRecordError fail", e16);
            }
        }

        @Override // com.tencent.qqmini.minigame.audiorecorder.MiniGameLameMp3Recorder.AudioRecordListener
        public void onRecordFrame(byte[] bArr, boolean z16) {
            if (bArr == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("state", "frameRecorded");
                NativeBuffer.packNativeBuffer(this.iJsService, bArr, NativeBuffer.TYPE_BUFFER_NATIVE, "frameBuffer", jSONObject);
                jSONObject.put("isLastFrame", z16);
                QMLog.i(AudioRecorderJsPlugin.TAG, "onRecordFrame length: " + bArr.length + " isLastFrame: " + z16);
                AudioRecorderJsPlugin.this.sendSubscribeEvent(AudioRecorderJsPlugin.EVENT_RECORD_STATE_CHANGE, jSONObject.toString());
            } catch (JSONException e16) {
                QMLog.e(AudioRecorderJsPlugin.TAG, "onRecordFrame failed", e16);
            }
        }

        @Override // com.tencent.qqmini.minigame.audiorecorder.MiniGameLameMp3Recorder.AudioRecordListener
        public void onRecordPause() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("state", "pause");
                AudioRecorderJsPlugin.this.sendSubscribeEvent(AudioRecorderJsPlugin.EVENT_RECORD_STATE_CHANGE, jSONObject.toString());
            } catch (JSONException e16) {
                QMLog.w(AudioRecorderJsPlugin.TAG, "onRecordPause fail", e16);
            }
        }

        @Override // com.tencent.qqmini.minigame.audiorecorder.MiniGameLameMp3Recorder.AudioRecordListener
        public void onRecordResume() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("state", "resume");
                AudioRecorderJsPlugin.this.sendSubscribeEvent(AudioRecorderJsPlugin.EVENT_RECORD_STATE_CHANGE, jSONObject.toString());
            } catch (JSONException e16) {
                QMLog.w(AudioRecorderJsPlugin.TAG, "onRecordResume fail", e16);
            }
        }

        @Override // com.tencent.qqmini.minigame.audiorecorder.MiniGameLameMp3Recorder.AudioRecordListener
        public void onRecordStart() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("state", "start");
                AudioRecorderJsPlugin.this.sendSubscribeEvent(AudioRecorderJsPlugin.EVENT_RECORD_STATE_CHANGE, jSONObject.toString());
            } catch (JSONException e16) {
                QMLog.w(AudioRecorderJsPlugin.TAG, "onRecordStart fail", e16);
            }
        }

        @Override // com.tencent.qqmini.minigame.audiorecorder.MiniGameLameMp3Recorder.AudioRecordListener
        public void onRecordStop(String str, long j3, long j16) {
            JSONObject jSONObject = new JSONObject();
            try {
                String wxFilePath = ((MiniAppFileManager) ((BaseJsPlugin) AudioRecorderJsPlugin.this).mMiniAppContext.getManager(MiniAppFileManager.class)).getWxFilePath(str);
                QMLog.d(AudioRecorderJsPlugin.TAG, "onRecordStop tempFilePath: " + wxFilePath + " duration: " + j3 + " fileSize: " + j16);
                jSONObject.put("state", "stop");
                jSONObject.put("tempFilePath", wxFilePath);
                jSONObject.put("duration", j3);
                jSONObject.put("fileSize", j16);
                AudioRecorderJsPlugin.this.sendSubscribeEvent(AudioRecorderJsPlugin.EVENT_RECORD_STATE_CHANGE, jSONObject.toString());
            } catch (JSONException e16) {
                QMLog.w(AudioRecorderJsPlugin.TAG, "onRecordStop fail", e16);
            }
        }

        public void pauseRecord(RequestEvent requestEvent) {
            if (this.recorder == null) {
                requestEvent.fail(this.context.getString(R.string.mini_game_record_do_not_start));
            } else {
                this.recorder.recordPause();
                requestEvent.ok();
            }
        }

        public void resumeRecord(RequestEvent requestEvent) {
            if (this.recorder == null) {
                requestEvent.fail(this.context.getString(R.string.mini_game_record_do_not_start));
            } else {
                this.recorder.recordResume();
                requestEvent.ok();
            }
        }

        public void startRecord(RequestEvent requestEvent) {
            if (this.recorder != null && !this.recorder.isRecordIdle()) {
                Context context = this.context;
                int i3 = R.string.mini_game_record_is_recording_now;
                requestEvent.fail(context.getString(i3));
                QMLog.w(AudioRecorderJsPlugin.TAG, "startRecord fail " + this.context.getString(i3));
                return;
            }
            if (!AudioRecorderJsPlugin.this.loadLameMp3So()) {
                Context context2 = this.context;
                int i16 = R.string.mini_game_record_so_load_error;
                requestEvent.fail(context2.getString(i16));
                QMLog.w(AudioRecorderJsPlugin.TAG, "startRecord fail " + this.context.getString(i16));
                return;
            }
            try {
                String externalStorageState = Environment.getExternalStorageState();
                QMLog.w(AudioRecorderJsPlugin.TAG, "sdcard state: " + externalStorageState);
                if ("mounted".equals(externalStorageState)) {
                    long[] sDCardMemory = DeviceInfoUtil.getSDCardMemory();
                    if (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() > 1 && sDCardMemory != null && sDCardMemory[1] > 2) {
                        if (isForbidByMeiZu(this.context)) {
                            Context context3 = this.context;
                            int i17 = R.string.mini_game_record_microphone_forbidden;
                            requestEvent.fail(context3.getString(i17));
                            QMLog.w(AudioRecorderJsPlugin.TAG, "startRecord fail " + this.context.getString(i17));
                        } else {
                            QMLog.i(AudioRecorderJsPlugin.TAG, "startRecord initRecorder");
                            initRecorder(requestEvent.jsonParams);
                            QMLog.i(AudioRecorderJsPlugin.TAG, "startRecord path: " + this.recorder.getRecordFilePath());
                            ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).muteAudioFocus(this.context, true);
                            this.iJsService = requestEvent.jsService;
                            this.recorder.recordStart();
                            requestEvent.ok();
                        }
                    } else {
                        Context context4 = this.context;
                        int i18 = R.string.mini_game_record_sdcard_full;
                        requestEvent.fail(context4.getString(i18));
                        QMLog.w(AudioRecorderJsPlugin.TAG, "startRecord fail " + this.context.getString(i18));
                    }
                } else if ("mounted_ro".equals(externalStorageState)) {
                    requestEvent.fail("sdcard can't write");
                    QMLog.w(AudioRecorderJsPlugin.TAG, "startRecord fail: " + externalStorageState);
                } else {
                    Context context5 = this.context;
                    int i19 = R.string.mini_game_record_no_sdcard;
                    requestEvent.fail(context5.getString(i19));
                    QMLog.w(AudioRecorderJsPlugin.TAG, "startRecord fail " + this.context.getString(i19));
                }
            } catch (Exception e16) {
                requestEvent.fail();
                QMLog.w(AudioRecorderJsPlugin.TAG, "startRecord exception", e16);
            }
        }

        public void stopRecord(RequestEvent requestEvent) {
            if (this.recorder == null) {
                requestEvent.fail(this.context.getString(R.string.mini_game_record_do_not_start));
            } else {
                this.recorder.recordStop();
                requestEvent.ok();
            }
        }

        AudioManager(Context context) {
            this.context = context;
        }
    }

    private AudioManager getAudioManager() {
        if (this.mAudioManager == null) {
            this.mAudioManager = new AudioManager(this.mMiniAppContext.getAttachActivity());
        }
        return this.mAudioManager;
    }

    public static String getLameMp3SoPath(Context context) {
        return getSharedPreferences(context).getString(LAME_MP3_SO_PATH_STRING, "");
    }

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(MINI_GAME_LAME_MP3_SO_PATH, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean loadLameMp3So() {
        if (this.hasLoadedSo) {
            return true;
        }
        String lameMp3SoPath = getLameMp3SoPath(this.mMiniAppContext.getContext());
        if (TextUtils.isEmpty(lameMp3SoPath)) {
            this.hasLoadedSo = false;
            return false;
        }
        try {
            com.tencent.qqmini.sdk.utils.d.c(lameMp3SoPath);
            System.load(lameMp3SoPath);
            this.hasLoadedSo = true;
            return true;
        } catch (UnsatisfiedLinkError e16) {
            QMLog.e(TAG, "loadLameMp3So error", e16);
            return false;
        }
    }

    public static void setLameMp3SoPath(Context context, String str) {
        getSharedPreferences(context).edit().putString(LAME_MP3_SO_PATH_STRING, str).apply();
    }

    @JsEvent({"getRecorderManager"})
    public void getRecorderManager(RequestEvent requestEvent) {
        requestEvent.ok();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onDestroy() {
        super.onDestroy();
        if (this.mAudioManager != null) {
            this.mAudioManager.destroy();
        }
    }

    @JsEvent({"operateRecorder"})
    public void operateRecorder(RequestEvent requestEvent) {
        try {
            String optString = new JSONObject(requestEvent.jsonParams).optString("operationType");
            if ("start".equals(optString)) {
                getAudioManager().startRecord(requestEvent);
            } else if ("resume".equals(optString)) {
                getAudioManager().resumeRecord(requestEvent);
            } else if ("pause".equals(optString)) {
                getAudioManager().pauseRecord(requestEvent);
            } else if ("stop".equals(optString)) {
                getAudioManager().stopRecord(requestEvent);
            }
            requestEvent.ok();
        } catch (Exception e16) {
            requestEvent.fail();
            QMLog.e(TAG, "operateRecorder failed", e16);
        }
    }
}
