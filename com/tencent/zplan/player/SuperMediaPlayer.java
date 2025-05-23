package com.tencent.zplan.player;

import android.graphics.SurfaceTexture;
import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.epicgames.ue4.UE4;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.player.MediaInfo;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.common.ITPContainerInfo;
import com.tencent.thumbplayer.api.common.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.common.TPDashFormat;
import com.tencent.thumbplayer.api.common.TPHlsTag;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import com.tencent.zplan.luabridge.ZPlanLuaBridge;
import com.tencent.zplan.luabridge.a;
import com.tencent.zplan.utils.ZLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import sx4.b;
import zx4.r;

/* loaded from: classes27.dex */
public class SuperMediaPlayer {
    private static final int PLATFORM_ID = 5000303;
    private static final int SF_DEFAULT = 0;
    private static final int SF_FLV = 2;
    private static final int SF_M3U8 = 3;
    private static final int SF_RTMP = 1;
    private static final int STATUS_COMPLETION = 2;
    private static final int STATUS_ERROR = 3;
    private static final int STATUS_PREPARE = 1;
    private static final String TAG = "SUPER_PLAYER_LOG";
    private static final int TYPE_VID = 2;
    private boolean enabledAudioFrame;
    private boolean enabledPlayAudio;
    private boolean enabledVideoFrame;
    private volatile boolean isPrepared;
    private int mCurrentUrlType;
    private long mIdentifier;
    private OESTextureRenderer mOESTextureRenderer;
    private int mPlayType;
    private ISuperPlayer mSuperPlayer;
    private String mUrlPath;
    private int mVideoHeight;
    private int mVideoWidth;
    private AudioFrameData mPreAudioFrameData = new AudioFrameData();
    private long mStartPosition = 0;
    private long mAudioSampleRate = -1;
    private long mAudioFrameSize = -1;
    private long mAudioChannelLayout = -1;
    private int mAudioSampleFormat = -1;

    /* loaded from: classes27.dex */
    public static class AudioFrameData {
        public byte[][] bufferdata;
        public int channels;
        public int duration;
        public int format;
        public boolean isSucceed;
        public int sampleRate;
        public int[] size;
        public long time;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes27.dex */
    public class OESTextureRenderer implements SurfaceTexture.OnFrameAvailableListener {
        private Surface mSurface;
        private SurfaceTexture mSurfaceTexture;
        private final int mTextureID;
        private int mTextureWidth = -1;
        private int mTextureHeight = -1;
        private boolean mFrameAvailable = false;
        private final float[] mTransformMatrix = new float[16];
        private boolean mTextureSizeChanged = true;

        public OESTextureRenderer(int i3) {
            this.mTextureID = i3;
            SurfaceTexture surfaceTexture = new SurfaceTexture(i3);
            this.mSurfaceTexture = surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener(this);
            this.mSurface = new Surface(this.mSurfaceTexture);
        }

        public int getExternalTextureId() {
            return this.mTextureID;
        }

        public VideoFrameData getFrameUpdateInfo() {
            MediaInfo mediaInfo;
            VideoFrameData videoFrameData = new VideoFrameData();
            videoFrameData.frameRate = 0;
            videoFrameData.width = 0;
            videoFrameData.height = 0;
            videoFrameData.isSucceed = false;
            if (this.mFrameAvailable) {
                this.mFrameAvailable = false;
                SurfaceTexture surfaceTexture = this.mSurfaceTexture;
                if (surfaceTexture != null) {
                    try {
                        surfaceTexture.updateTexImage();
                        this.mSurfaceTexture.getTransformMatrix(this.mTransformMatrix);
                        videoFrameData.transformMatrix = this.mTransformMatrix;
                        if (SuperMediaPlayer.this.mSuperPlayer != null) {
                            mediaInfo = SuperMediaPlayer.this.mSuperPlayer.getMediaInfo();
                        } else {
                            mediaInfo = null;
                        }
                        if (mediaInfo != null) {
                            videoFrameData.frameRate = mediaInfo.getVideoFps();
                            if (SuperMediaPlayer.this.mVideoWidth != 0) {
                                videoFrameData.width = SuperMediaPlayer.this.mVideoWidth;
                            } else {
                                videoFrameData.width = mediaInfo.getVideoWidth();
                            }
                            if (SuperMediaPlayer.this.mVideoHeight != 0) {
                                videoFrameData.height = SuperMediaPlayer.this.mVideoHeight;
                            } else {
                                videoFrameData.height = mediaInfo.getVideoHeight();
                            }
                            videoFrameData.isSucceed = true;
                            SuperMediaPlayer.this.playerLog("videoFrame frameRate:" + videoFrameData.frameRate + ",videoFrame width:" + videoFrameData.width + ",videoFrame height:" + videoFrameData.height);
                        } else {
                            ZLog.f386189b.d(SuperMediaPlayer.TAG, 1, "getFrameUpdateInfo MediaInfo is NULL!");
                        }
                    } catch (Exception e16) {
                        videoFrameData.isSucceed = false;
                        ZLog.f386189b.e(SuperMediaPlayer.TAG, 1, "getFrameUpdateInfo exception!", e16);
                    }
                }
            }
            return videoFrameData;
        }

        public Surface getSurface() {
            return this.mSurface;
        }

        public SurfaceTexture getSurfaceTexture() {
            return this.mSurfaceTexture;
        }

        public boolean isValid() {
            if (this.mSurfaceTexture != null) {
                return true;
            }
            return false;
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            synchronized (this) {
                this.mFrameAvailable = true;
            }
        }

        public void release() {
            Surface surface = this.mSurface;
            if (surface != null) {
                surface.release();
                this.mSurface = null;
            }
            SurfaceTexture surfaceTexture = this.mSurfaceTexture;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.mSurfaceTexture = null;
            }
        }

        public boolean resolutionChanged() {
            boolean z16;
            synchronized (this) {
                z16 = this.mTextureSizeChanged;
                this.mTextureSizeChanged = false;
            }
            return z16;
        }

        public void setSize(int i3, int i16) {
            synchronized (this) {
                if (i3 != this.mTextureWidth || i16 != this.mTextureHeight) {
                    this.mTextureWidth = i3;
                    this.mTextureHeight = i16;
                    this.mTextureSizeChanged = true;
                    SurfaceTexture surfaceTexture = this.mSurfaceTexture;
                    if (surfaceTexture != null) {
                        surfaceTexture.setDefaultBufferSize(i3, i16);
                    }
                }
            }
        }

        public VideoFrameData updateVideoFrame() {
            VideoFrameData frameUpdateInfo;
            synchronized (this) {
                frameUpdateInfo = getFrameUpdateInfo();
            }
            return frameUpdateInfo;
        }
    }

    /* loaded from: classes27.dex */
    public static class VideoFrameData {
        public int frameRate;
        public int height;
        public boolean isSucceed;
        public float[] transformMatrix;
        public int width;
    }

    public SuperMediaPlayer(int i3, boolean z16) {
        ZLog.f386189b.k(TAG, "SuperMediaPlayer() sceneId:" + i3 + ",playAudio" + z16);
        this.enabledPlayAudio = z16;
        this.mSuperPlayer = SuperPlayerFactory.createMediaPlayer(UE4.getContext(), i3, null);
    }

    private void copyInfo(TPTrackInfo tPTrackInfo, com.tencent.thumbplayer.api.common.TPTrackInfo tPTrackInfo2) {
        if (tPTrackInfo != null && tPTrackInfo2 != null) {
            ITPContainerInfo containerInfo = tPTrackInfo2.getContainerInfo();
            tPTrackInfo.trackType = tPTrackInfo2.getMediaType();
            if (containerInfo != null) {
                tPTrackInfo.containerType = containerInfo.getContainerType();
            }
            tPTrackInfo.isExclusive = tPTrackInfo2.isExclusive();
            tPTrackInfo.isInternal = tPTrackInfo2.isInternal();
            tPTrackInfo.isSelected = tPTrackInfo2.isSelected();
            tPTrackInfo.language = tPTrackInfo2.getLanguage();
            tPTrackInfo.name = tPTrackInfo2.getName();
            if (containerInfo instanceof TPDashFormat) {
                tPTrackInfo.dashFormat = (TPDashFormat) containerInfo;
            }
            if (containerInfo instanceof TPHlsTag) {
                tPTrackInfo.hlsTag = (TPHlsTag) containerInfo;
            }
        }
    }

    private boolean createOESTextureRenderer(int i3) {
        releaseOESTextureRenderer();
        OESTextureRenderer oESTextureRenderer = new OESTextureRenderer(i3);
        this.mOESTextureRenderer = oESTextureRenderer;
        if (!oESTextureRenderer.isValid()) {
            this.mOESTextureRenderer = null;
            return false;
        }
        this.mOESTextureRenderer.setSize(this.mSuperPlayer.getVideoWidth(), this.mSuperPlayer.getVideoHeight());
        this.mSuperPlayer.setOnVideoSizeChangedListener(new ISuperPlayer.OnVideoSizeChangedListener() { // from class: com.tencent.zplan.player.SuperMediaPlayer.5
            @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(ISuperPlayer iSuperPlayer, int i16, int i17) {
                if (SuperMediaPlayer.this.mOESTextureRenderer != null) {
                    SuperMediaPlayer.this.mOESTextureRenderer.setSize(iSuperPlayer.getVideoWidth(), iSuperPlayer.getVideoHeight());
                    SuperMediaPlayer.this.mVideoWidth = i16;
                    SuperMediaPlayer.this.mVideoHeight = i17;
                }
                ZLog.f386189b.f(SuperMediaPlayer.TAG, "onVideoSizeChanged :: width == ");
            }
        });
        setVideoEnabled(true);
        return true;
    }

    private void initPlayerListener() {
        this.mSuperPlayer.setOnVideoPreparedListener(new ISuperPlayer.OnVideoPreparedListener() { // from class: com.tencent.zplan.player.SuperMediaPlayer.1
            @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
            public void onVideoPrepared(ISuperPlayer iSuperPlayer) {
                ZLog.f386189b.k(SuperMediaPlayer.TAG, "onVideoPrepared");
                SuperMediaPlayer.this.isPrepared = true;
                SuperMediaPlayer superMediaPlayer = SuperMediaPlayer.this;
                superMediaPlayer.onStateChanged(superMediaPlayer.mIdentifier, 1);
            }
        });
        if (!this.enabledPlayAudio) {
            this.mSuperPlayer.setOnAudioFrameOutputListener(new ISuperPlayer.OnAudioFrameOutputListener() { // from class: com.tencent.zplan.player.SuperMediaPlayer.2
                @Override // com.tencent.superplayer.api.ISuperPlayer.OnAudioFrameOutputListener
                public void onAudioFrameOutput(TPAudioFrameBuffer tPAudioFrameBuffer) {
                    if (tPAudioFrameBuffer == null) {
                        return;
                    }
                    SuperMediaPlayer superMediaPlayer = SuperMediaPlayer.this;
                    superMediaPlayer.onAudioFrameOutput(superMediaPlayer.mIdentifier, tPAudioFrameBuffer.getData(), tPAudioFrameBuffer.getDataSize(), tPAudioFrameBuffer.getFormat(), tPAudioFrameBuffer.getSampleRate(), tPAudioFrameBuffer.getChannelLayout(), tPAudioFrameBuffer.getPtsMs(), tPAudioFrameBuffer.getNbSamples(), tPAudioFrameBuffer.getChannels());
                }
            });
        }
        this.mSuperPlayer.setOnCompletionListener(new ISuperPlayer.OnCompletionListener() { // from class: com.tencent.zplan.player.SuperMediaPlayer.3
            @Override // com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
            public void onCompletion(ISuperPlayer iSuperPlayer) {
                SuperMediaPlayer superMediaPlayer = SuperMediaPlayer.this;
                superMediaPlayer.onStateChanged(superMediaPlayer.mIdentifier, 2);
                ZLog.f386189b.k(SuperMediaPlayer.TAG, "SuperPlayer onCompletion");
            }
        });
        this.mSuperPlayer.setOnErrorListener(new ISuperPlayer.OnErrorListener() { // from class: com.tencent.zplan.player.SuperMediaPlayer.4
            @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
            public boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
                SuperMediaPlayer superMediaPlayer = SuperMediaPlayer.this;
                superMediaPlayer.onStateChanged(superMediaPlayer.mIdentifier, 3);
                ZLog.f386189b.f(SuperMediaPlayer.TAG, "module: " + i3 + " errorType: " + i16 + " errorCode: " + i17 + " extraInfo: " + str);
                if (iSuperPlayer == SuperMediaPlayer.this.mSuperPlayer) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("module", i3);
                        jSONObject.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, i16);
                        jSONObject.put("errorCode", i17);
                        jSONObject.put("extraInfo", str);
                        jSONObject.put("url", SuperMediaPlayer.this.mUrlPath);
                        ZPlanLuaBridge.INSTANCE.callLua("N2L_OnSuperPlayerError", jSONObject.toString(), new a.b() { // from class: com.tencent.zplan.player.SuperMediaPlayer.4.1
                            @Override // com.tencent.zplan.luabridge.a.b
                            public void onExecuteLua() {
                                ZLog.f386189b.k(SuperMediaPlayer.TAG, "superplayer onError onExecuteLua");
                            }

                            @Override // com.tencent.zplan.luabridge.a.b
                            public void onLuaResult(boolean z16, @Nullable String str2) {
                                ZLog.f386189b.k(SuperMediaPlayer.TAG, "superplayer onLuaResult success = " + z16 + " result = " + str2);
                            }
                        });
                        return false;
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                        return false;
                    }
                }
                return false;
            }
        });
    }

    private void initPlayerOptionalParamList() {
        ArrayList arrayList = new ArrayList();
        if (!this.enabledPlayAudio) {
            arrayList.add(TPOptionalParam.buildQueueInt(TPOptionalID.OPTIONAL_ID_BEFORE_QUEUE_INT_AUDIO_RENDERER_TYPE, new int[]{-1}));
            int i3 = this.mAudioSampleFormat;
            if (i3 > -1) {
                arrayList.add(TPOptionalParam.buildInt(TPOptionalID.OPTIONAL_ID_BEFORE_INT_OUT_AUDIO_SAMPLE_FORMAT, i3));
            }
            long j3 = this.mAudioChannelLayout;
            if (j3 > -1) {
                arrayList.add(TPOptionalParam.buildLong(TPOptionalID.OPTIONAL_ID_BEFORE_LONG_OUT_AUDIO_CHANNEL_LAYOUT, j3));
            }
            long j16 = this.mAudioSampleRate;
            if (j16 > -1) {
                arrayList.add(TPOptionalParam.buildInt(TPOptionalID.OPTIONAL_ID_BEFORE_INT_OUT_AUDIO_SAMPLE_RATE_HZ, (int) j16));
            }
            long j17 = this.mAudioFrameSize;
            if (j17 > -1) {
                arrayList.add(TPOptionalParam.buildInt(TPOptionalID.OPTIONAL_ID_BEFORE_INT_OUT_AUDIO_FRAME_SIZE_BYTE, (int) j17));
            }
        }
        if (isFlvType()) {
            arrayList.add(TPOptionalParam.buildQueueInt(TPOptionalID.OPTIONAL_ID_BEFORE_QUEUE_INT_DEMUXER_TYPE, new int[]{1}));
        }
        if (arrayList.size() > 0) {
            this.mSuperPlayer.setPlayerOptionalParamList(arrayList);
        }
    }

    private boolean isFlvType() {
        if (this.mCurrentUrlType == 2) {
            return true;
        }
        return false;
    }

    public static boolean loadMediaPlayer() {
        r rVar = (r) mx4.a.f417748a.a(r.class);
        if (rVar == null) {
            ZLog.f386189b.f(TAG, "loadMediaPlayer without proxy");
            return false;
        }
        rVar.b();
        if (rVar.isSDKReady()) {
            ZLog.f386189b.k(TAG, "isSuperPlayerReady true");
            return true;
        }
        ZLog.f386189b.f(TAG, "isSuperPlayerReady false");
        rVar.a(new b() { // from class: com.tencent.zplan.player.SuperMediaPlayer.6
            @Override // sx4.b
            public void onSDKInited(boolean z16) {
            }
        });
        return false;
    }

    public static native void onMediaPlayerLoaded(boolean z16);

    /* JADX INFO: Access modifiers changed from: private */
    public void playerLog(String str) {
        ZLog.f386189b.a(TAG, 4, str);
    }

    private void releaseOESTextureRenderer() {
        if (this.mOESTextureRenderer != null) {
            this.mSuperPlayer.setSurface(null);
            this.mOESTextureRenderer.release();
            this.mOESTextureRenderer = null;
            this.mVideoWidth = 0;
            this.mVideoHeight = 0;
        }
    }

    public float getCurrentProgress() {
        synchronized (this) {
            ISuperPlayer iSuperPlayer = this.mSuperPlayer;
            if (iSuperPlayer != null) {
                float currentPositionMs = ((float) iSuperPlayer.getCurrentPositionMs()) / 1000.0f;
                ZLog.f386189b.k(TAG, "getCurrentProgress :: " + currentPositionMs);
                return currentPositionMs;
            }
            ZLog.f386189b.k(TAG, "getCurrentProgress :: SuperPlayer is null");
            return 0.0f;
        }
    }

    public int getExternalTextureId() {
        OESTextureRenderer oESTextureRenderer = this.mOESTextureRenderer;
        if (oESTextureRenderer != null) {
            return oESTextureRenderer.getExternalTextureId();
        }
        return 0;
    }

    public TPTrackInfo[] getTrackInfo() {
        ISuperPlayer iSuperPlayer = this.mSuperPlayer;
        if (iSuperPlayer != null) {
            try {
                com.tencent.thumbplayer.api.common.TPTrackInfo[] trackInfo = iSuperPlayer.getTrackInfo();
                if (trackInfo != null && trackInfo.length != 0) {
                    TPTrackInfo[] tPTrackInfoArr = new TPTrackInfo[trackInfo.length];
                    for (int i3 = 0; i3 < trackInfo.length; i3++) {
                        TPTrackInfo tPTrackInfo = new TPTrackInfo();
                        copyInfo(tPTrackInfo, trackInfo[i3]);
                        tPTrackInfoArr[i3] = tPTrackInfo;
                    }
                    return tPTrackInfoArr;
                }
                return null;
            } catch (Exception unused) {
                ZLog.f386189b.f(TAG, "transForm TpTrackInfo error");
            }
        }
        return null;
    }

    public boolean isPlaying() {
        ISuperPlayer iSuperPlayer = this.mSuperPlayer;
        if (iSuperPlayer != null) {
            return iSuperPlayer.isPlaying();
        }
        return false;
    }

    public boolean isPrepared() {
        return this.isPrepared;
    }

    public native void onAudioFrameOutput(long j3, byte[][] bArr, int[] iArr, int i3, int i16, long j16, long j17, int i17, int i18);

    public native void onStateChanged(long j3, int i3);

    public void pause() {
        synchronized (this) {
            ISuperPlayer iSuperPlayer = this.mSuperPlayer;
            if (iSuperPlayer != null) {
                iSuperPlayer.pause();
                ZLog.f386189b.k(TAG, "pause");
            }
        }
    }

    public void prepareAsync() {
        SuperPlayerVideoInfo createVideoInfoForUrl;
        if (TextUtils.isEmpty(this.mUrlPath)) {
            return;
        }
        ZLog zLog = ZLog.f386189b;
        zLog.k(TAG, "prepareAsync");
        initPlayerListener();
        initPlayerOptionalParamList();
        SuperPlayerOption obtain = SuperPlayerOption.obtain();
        obtain.enableAudioFrameOutput = true;
        obtain.accurateSeekOnOpen = true;
        if (this.mPlayType == 2) {
            zLog.k(TAG, "prepareAsync :: createVideoInfoForTVideo :: urlPath = " + this.mUrlPath);
            createVideoInfoForUrl = SuperPlayerFactory.createVideoInfoForTVideo(5000303, this.mUrlPath);
        } else {
            zLog.k(TAG, "prepareAsync :: createVideoInfoForUrl");
            createVideoInfoForUrl = SuperPlayerFactory.createVideoInfoForUrl(this.mUrlPath, 201, "SuperMediaPlayer");
        }
        this.mSuperPlayer.openMediaPlayer(UE4.getContext(), createVideoInfoForUrl, this.mStartPosition, obtain);
        this.mStartPosition = 0L;
    }

    public void release() {
        if (this.mOESTextureRenderer != null) {
            releaseOESTextureRenderer();
        }
        ISuperPlayer iSuperPlayer = this.mSuperPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.release();
            ZLog.f386189b.k(TAG, "release");
        }
        this.isPrepared = false;
    }

    public void reset() {
        if (this.mOESTextureRenderer != null) {
            releaseOESTextureRenderer();
        }
        ISuperPlayer iSuperPlayer = this.mSuperPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.reset();
            ZLog.f386189b.k(TAG, "reset");
        }
        this.isPrepared = false;
    }

    public void seek(float f16) {
        synchronized (this) {
            ISuperPlayer iSuperPlayer = this.mSuperPlayer;
            if (iSuperPlayer != null) {
                iSuperPlayer.seekTo(((int) f16) * 1000);
                ZLog.f386189b.k(TAG, "seek :: " + f16);
            }
        }
    }

    public void selectOrDeselectTrack(int i3, boolean z16) {
        ISuperPlayer iSuperPlayer = this.mSuperPlayer;
        if (iSuperPlayer != null) {
            if (z16) {
                iSuperPlayer.selectTrack(i3, 0L);
            } else {
                iSuperPlayer.deselectTrack(i3, 0L);
            }
            ZLog.f386189b.k(TAG, "selectOrDeselectTrack trackIndex:" + i3 + ",isSelect:" + z16);
        }
    }

    public void setAudioChannelLayout(long j3) {
        this.mAudioChannelLayout = j3;
        ZLog.f386189b.k(TAG, "setAudioChannelLayout:" + j3);
    }

    public void setAudioEnabled(boolean z16) {
        this.enabledAudioFrame = z16;
        ZLog.f386189b.k(TAG, "setAudioEnabled enabled:" + z16);
    }

    public void setAudioFrameSize(long j3) {
        this.mAudioFrameSize = j3;
        ZLog.f386189b.k(TAG, "setAudioFrameSize:" + j3);
    }

    public void setAudioSampleFormat(int i3) {
        this.mAudioSampleFormat = i3;
        ZLog.f386189b.k(TAG, "setAudioSampleFormat:" + i3);
    }

    public void setAudioSampleRate(long j3) {
        this.mAudioSampleRate = j3;
        ZLog.f386189b.k(TAG, "setAudioSampleRate:" + j3);
    }

    public boolean setDataSourceURL(String str, int i3, int i16) {
        ZLog.f386189b.k(TAG, "setDataSourceURL " + i3 + "-" + str + ", playType == " + i16);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        this.mUrlPath = str;
        this.mCurrentUrlType = i3;
        this.mPlayType = i16;
        return true;
    }

    public void setIdentifier(long j3) {
        this.mIdentifier = j3;
        ZLog.f386189b.k(TAG, "setIdentifier identifier:" + j3);
    }

    public void setStartPosition(float f16) {
        synchronized (this) {
            if (this.mSuperPlayer != null) {
                this.mStartPosition = f16 * 1000.0f;
                ZLog.f386189b.k(TAG, "setStartPosition :: " + this.mStartPosition);
            }
        }
    }

    public void setVideoEnabled(boolean z16) {
        this.enabledVideoFrame = z16;
        if (z16) {
            OESTextureRenderer oESTextureRenderer = this.mOESTextureRenderer;
            if (oESTextureRenderer != null && oESTextureRenderer.getSurface() != null) {
                this.mSuperPlayer.setSurface(this.mOESTextureRenderer.getSurface());
            }
        } else {
            this.mSuperPlayer.setSurface(null);
        }
        ZLog.f386189b.k(TAG, "setVideoEnabled:" + z16);
    }

    public void start() {
        synchronized (this) {
            ISuperPlayer iSuperPlayer = this.mSuperPlayer;
            if (iSuperPlayer != null) {
                iSuperPlayer.start();
                ZLog.f386189b.k(TAG, "start");
            }
        }
    }

    public void stop() {
        synchronized (this) {
            ISuperPlayer iSuperPlayer = this.mSuperPlayer;
            if (iSuperPlayer != null) {
                iSuperPlayer.stop();
                ZLog.f386189b.k(TAG, "stop");
            }
        }
    }

    public void switchDefinitionForUrl(String str, int i3, int i16) {
        ISuperPlayer iSuperPlayer = this.mSuperPlayer;
        if (iSuperPlayer != null) {
            if (i16 == 2) {
                iSuperPlayer.switchDefinition(str, i3);
            } else {
                iSuperPlayer.switchDefinitionForUrl(str, i3);
            }
            ZLog.f386189b.k(TAG, "switchDefinitionForUrl url:" + str + ",mode:" + i3);
        }
    }

    public AudioFrameData updateAudioFrame() {
        if (!this.enabledAudioFrame) {
            ZLog.f386189b.d(TAG, 1, "updateAudioFrame enabledAudioFrame == false!!");
            return null;
        }
        AudioFrameData audioFrameData = new AudioFrameData();
        AudioFrameData audioFrameData2 = this.mPreAudioFrameData;
        audioFrameData.time = audioFrameData2.time;
        audioFrameData.bufferdata = audioFrameData2.bufferdata;
        audioFrameData.size = audioFrameData2.size;
        audioFrameData.format = audioFrameData2.format;
        audioFrameData.sampleRate = audioFrameData2.sampleRate;
        audioFrameData.channels = audioFrameData2.channels;
        audioFrameData.isSucceed = audioFrameData2.isSucceed;
        audioFrameData2.isSucceed = false;
        return audioFrameData;
    }

    public VideoFrameData updateVideoFrame(int i3) {
        if (this.mOESTextureRenderer == null && !createOESTextureRenderer(i3)) {
            ZLog.f386189b.f(TAG, "updateVideoFrame failed to alloc mOESTextureRenderer ");
            reset();
            return null;
        }
        return this.mOESTextureRenderer.updateVideoFrame();
    }

    public void setAudioVolume(float f16) {
    }
}
