package com.tencent.mobileqq.zplan.room.impl.jni;

import android.graphics.SurfaceTexture;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.api.common.TPTrackInfo;
import java.io.Serializable;
import kk3.j;

/* loaded from: classes34.dex */
public class QQMeetingLivePlayer {
    private static final int PLATFORM_ID = 5000303;
    private static final int STATUS_COMPLETION = 2;
    private static final int STATUS_ERROR = 3;
    private static final int STATUS_PREPARE = 1;
    private static final String TAG = "QQMeetingLivePlayer";
    private static final int TYPE_VID = 2;
    private boolean enabledAudioFrame;
    private boolean enabledPlayAudio;
    private boolean enabledVideoFrame;
    private int mCurrentUrlType;
    private long mIdentifier;
    private b mOESTextureRenderer;
    private int mPlayType;
    private String mUrlPath;
    private kk3.a meetingPlayer;
    private volatile boolean isPrepared = true;
    private int mVideoWidth = 1280;
    private int mVideoHeight = 720;
    private boolean isPlaying = false;

    /* loaded from: classes34.dex */
    public static class AudioFrameData implements Serializable {
        public byte[][] bufferdata;
        public int channels;
        public int duration;
        public int format;
        public boolean isSucceed;
        public int sampleRate;
        public int[] size;
        public long time;
    }

    /* loaded from: classes34.dex */
    public static class VideoFrameData implements Serializable {
        public int frameRate;
        public int height;
        public boolean isSucceed;
        public float[] transformMatrix;
        public int width;
    }

    /* loaded from: classes34.dex */
    class a extends TPTrackInfo {
        a() {
            setSelected(true);
            setMediaType(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes34.dex */
    public class b implements SurfaceTexture.OnFrameAvailableListener {

        /* renamed from: d, reason: collision with root package name */
        private SurfaceTexture f335204d;

        /* renamed from: h, reason: collision with root package name */
        private Surface f335207h;

        /* renamed from: m, reason: collision with root package name */
        private final int f335209m;

        /* renamed from: e, reason: collision with root package name */
        private int f335205e = -1;

        /* renamed from: f, reason: collision with root package name */
        private int f335206f = -1;

        /* renamed from: i, reason: collision with root package name */
        private boolean f335208i = false;
        private final float[] C = new float[16];
        private boolean D = true;

        public b(int i3) {
            this.f335209m = i3;
            SurfaceTexture surfaceTexture = new SurfaceTexture(i3);
            this.f335204d = surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener(this);
            this.f335207h = new Surface(this.f335204d);
        }

        public int d() {
            return this.f335209m;
        }

        public VideoFrameData e() {
            VideoFrameData videoFrameData = new VideoFrameData();
            videoFrameData.frameRate = 30;
            videoFrameData.width = 0;
            videoFrameData.height = 0;
            videoFrameData.isSucceed = false;
            if (this.f335208i) {
                this.f335208i = false;
                SurfaceTexture surfaceTexture = this.f335204d;
                if (surfaceTexture != null) {
                    try {
                        surfaceTexture.updateTexImage();
                        this.f335204d.getTransformMatrix(this.C);
                        videoFrameData.transformMatrix = this.C;
                        videoFrameData.width = QQMeetingLivePlayer.this.mVideoWidth;
                        videoFrameData.height = QQMeetingLivePlayer.this.mVideoHeight;
                        videoFrameData.isSucceed = true;
                        QQMeetingLivePlayer.this.playerLog("videoFrame frameRate:" + videoFrameData.frameRate + ",videoFrame width:" + videoFrameData.width + ",videoFrame height:" + videoFrameData.height);
                    } catch (Exception e16) {
                        videoFrameData.isSucceed = false;
                        Log.e(QQMeetingLivePlayer.TAG, "getFrameUpdateInfo exception!", e16);
                    }
                }
            }
            return videoFrameData;
        }

        public Surface f() {
            return this.f335207h;
        }

        public boolean g() {
            return this.f335204d != null;
        }

        public void h() {
            Surface surface = this.f335207h;
            if (surface != null) {
                surface.release();
                this.f335207h = null;
            }
            SurfaceTexture surfaceTexture = this.f335204d;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.f335204d = null;
            }
        }

        public void i(int i3, int i16) {
            synchronized (this) {
                if (i3 != this.f335205e || i16 != this.f335206f) {
                    this.f335205e = i3;
                    this.f335206f = i16;
                    this.D = true;
                    SurfaceTexture surfaceTexture = this.f335204d;
                    if (surfaceTexture != null) {
                        surfaceTexture.setDefaultBufferSize(i3, i16);
                    }
                }
            }
        }

        public VideoFrameData j() {
            VideoFrameData e16;
            synchronized (this) {
                e16 = e();
            }
            return e16;
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            synchronized (this) {
                this.f335208i = true;
            }
        }
    }

    public QQMeetingLivePlayer(int i3, boolean z16) {
        QLog.i(TAG, 1, "QQMeetingLivePlayer() sceneId:" + i3 + ",playAudio" + z16);
        this.enabledPlayAudio = z16;
        this.meetingPlayer = new j();
    }

    private boolean createOESTextureRenderer(int i3) {
        QLog.i(TAG, 1, "createOESTextureRenderer externalTextureId:" + i3);
        releaseOESTextureRenderer();
        b bVar = new b(i3);
        this.mOESTextureRenderer = bVar;
        if (!bVar.g()) {
            this.mOESTextureRenderer = null;
            return false;
        }
        this.mOESTextureRenderer.i(this.mVideoWidth, this.mVideoHeight);
        setVideoEnabled(true);
        return true;
    }

    private String getRealUrl(String str) {
        return (!TextUtils.isEmpty(str) && str.startsWith("trtc://")) ? str.substring(7) : str;
    }

    private boolean isFlvType() {
        return false;
    }

    public static boolean loadMediaPlayer() {
        new j().preInitTRTC();
        return true;
    }

    public static native void onMediaPlayerLoaded(boolean z16);

    /* JADX INFO: Access modifiers changed from: private */
    public void playerLog(String str) {
        Log.i(TAG, str);
    }

    private void releaseOESTextureRenderer() {
        b bVar = this.mOESTextureRenderer;
        if (bVar != null) {
            bVar.h();
            this.mOESTextureRenderer = null;
        }
    }

    public float getCurrentProgress() {
        QLog.i(TAG, 1, "seek mUrlPath:" + this.mUrlPath);
        return 0.0f;
    }

    public boolean isPlaying() {
        QLog.i(TAG, 1, "isPlaying mUrlPath:" + this.mUrlPath + " isPlaying:" + this.isPlaying);
        return this.isPlaying;
    }

    public boolean isPrepared() {
        QLog.i(TAG, 1, "isPrepared mUrlPath:" + this.mUrlPath + " isPrepared:" + this.isPrepared);
        return this.isPrepared;
    }

    public native void onAudioFrameOutput(long j3, byte[][] bArr, int[] iArr, int i3, int i16, long j16, long j17, int i17, int i18);

    public native void onStateChanged(long j3, int i3);

    public void pause() {
        QLog.i(TAG, 1, "pause mUrlPath:" + this.mUrlPath);
    }

    public void prepareAsync() {
        QLog.i(TAG, 1, "prepareAsync ");
        start();
        onStateChanged(this.mIdentifier, 1);
    }

    public void release() {
        QLog.i(TAG, 1, "release mUrlPath:" + this.mUrlPath);
        if (this.mOESTextureRenderer != null) {
            releaseOESTextureRenderer();
        }
        this.isPrepared = false;
    }

    public void reset() {
        QLog.i(TAG, 1, "reset mUrlPath:" + this.mUrlPath);
        if (this.mOESTextureRenderer != null) {
            releaseOESTextureRenderer();
        }
        this.isPrepared = false;
    }

    public void seek(float f16) {
        QLog.i(TAG, 1, "seek mUrlPath:" + this.mUrlPath);
    }

    public void setAudioChannelLayout(long j3) {
        Log.i(TAG, "setAudioChannelLayout:" + j3);
    }

    public void setAudioEnabled(boolean z16) {
        this.enabledAudioFrame = z16;
        Log.i(TAG, "setAudioEnabled enabled:" + z16);
    }

    public void setAudioFrameSize(long j3) {
        Log.i(TAG, "setAudioFrameSize:" + j3);
    }

    public void setAudioSampleFormat(int i3) {
        Log.i(TAG, "setAudioSampleFormat:" + i3);
    }

    public void setAudioSampleRate(long j3) {
        Log.i(TAG, "setAudioSampleRate:" + j3);
    }

    public boolean setDataSourceURL(String str, int i3, int i16) {
        QLog.i(TAG, 1, "setDataSourceURL " + i3 + "-" + str + ", playType == " + i16);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        this.mUrlPath = getRealUrl(str);
        this.mCurrentUrlType = i3;
        this.mPlayType = i16;
        return true;
    }

    public void setIdentifier(long j3) {
        this.mIdentifier = j3;
    }

    public void setVideoEnabled(boolean z16) {
        this.enabledVideoFrame = z16;
        if (z16) {
            b bVar = this.mOESTextureRenderer;
            if (bVar != null && bVar.f() != null) {
                this.meetingPlayer.updateScreenCaptureSurface(this.mUrlPath, this.mOESTextureRenderer.f335207h, this.mOESTextureRenderer.f335205e, this.mOESTextureRenderer.f335206f);
            }
        } else {
            this.meetingPlayer.updateScreenCaptureSurface(this.mUrlPath, null, this.mOESTextureRenderer.f335205e, this.mOESTextureRenderer.f335206f);
        }
        Log.i(TAG, "setVideoEnabled:" + z16);
    }

    public void start() {
        QLog.i(TAG, 1, "start mUrlPath:" + this.mUrlPath);
        if (TextUtils.isEmpty(this.mUrlPath) || this.isPlaying) {
            return;
        }
        b bVar = this.mOESTextureRenderer;
        if (bVar != null && bVar.g()) {
            this.meetingPlayer.playScreenCaptureWithSurface(this.mUrlPath, this.mOESTextureRenderer.f335207h, this.mOESTextureRenderer.f335205e, this.mOESTextureRenderer.f335206f);
        } else {
            this.meetingPlayer.playScreenCapture(this.mUrlPath);
        }
    }

    public void stop() {
        QLog.i(TAG, 1, "stop mUrlPath:" + this.mUrlPath);
        this.meetingPlayer.stopPlayScreenCapture(this.mUrlPath);
    }

    public AudioFrameData updateAudioFrame() {
        return new AudioFrameData();
    }

    public VideoFrameData updateVideoFrame(int i3) {
        if (this.mOESTextureRenderer == null && !createOESTextureRenderer(i3)) {
            QLog.i(TAG, 1, "updateVideoFrame  failed to alloc mOESTextureRenderer externalTextureId:" + i3);
            reset();
            return null;
        }
        b bVar = this.mOESTextureRenderer;
        if (bVar == null) {
            QLog.i(TAG, 1, "updateVideoFrame  failed to mOESTextureRenderer is null");
            return null;
        }
        return bVar.j();
    }

    public int getExternalTextureId() {
        QLog.i(TAG, 1, "getExternalTextureI");
        b bVar = this.mOESTextureRenderer;
        if (bVar != null) {
            return bVar.d();
        }
        return 0;
    }

    public TPTrackInfo[] getTrackInfo() {
        return new TPTrackInfo[]{new a()};
    }

    public void setAudioVolume(float f16) {
    }

    public void setStartPosition(float f16) {
    }

    public void selectOrDeselectTrack(int i3, boolean z16) {
    }

    public void switchDefinitionForUrl(String str, int i3, int i16) {
    }
}
