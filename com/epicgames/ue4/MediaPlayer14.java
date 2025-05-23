package com.epicgames.ue4;

import android.annotation.SuppressLint;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.SurfaceTexture;
import android.media.MediaDataSource;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaPlayer;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.view.Surface;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.google.android.exoplayer2.C;
import com.tencent.ark.EGLContextHolder;
import com.tencent.filter.GLSLRender;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes2.dex */
public class MediaPlayer14 extends ReportMediaPlayer {
    private boolean AudioEnabled;
    private float AudioVolume;
    private boolean NeedTrackInfo;
    private boolean SwizzlePixels;
    private boolean VulkanRenderer;
    private volatile boolean WaitOnBitmapRender;
    private boolean Looping = false;
    private volatile boolean Prepared = false;
    private volatile boolean Completed = false;
    private BitmapRenderer mBitmapRenderer = null;
    private OESTextureRenderer mOESTextureRenderer = null;
    private ArrayList<AudioTrackInfo> audioTracks = new ArrayList<>();
    private ArrayList<VideoTrackInfo> videoTracks = new ArrayList<>();
    private boolean mVideoEnabled = true;

    /* loaded from: classes2.dex */
    public class AudioTrackInfo {
        public int Channels;
        public String DisplayName;
        public int Index;
        public String Language;
        public String MimeType;
        public int SampleRate;

        public AudioTrackInfo() {
        }
    }

    /* loaded from: classes2.dex */
    public class CaptionTrackInfo {
        public String DisplayName;
        public int Index;
        public String Language;
        public String MimeType;

        public CaptionTrackInfo() {
        }
    }

    /* loaded from: classes2.dex */
    public class FrameUpdateInfo {
        public int CurrentPosition;
        public boolean FrameReady;
        public boolean RegionChanged;
        public float UOffset;
        public float UScale;
        public float VOffset;
        public float VScale;

        public FrameUpdateInfo() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class OESTextureRenderer implements SurfaceTexture.OnFrameAvailableListener {
        private Surface mSurface;
        private SurfaceTexture mSurfaceTexture;
        private int mTextureID;
        private int mTextureWidth = -1;
        private int mTextureHeight = -1;
        private boolean mFrameAvailable = false;
        private float[] mTransformMatrix = new float[16];
        private boolean mTextureSizeChanged = true;
        private int GL_TEXTURE_EXTERNAL_OES = 36197;
        private float mUScale = 1.0f;
        private float mVScale = -1.0f;
        private float mUOffset = 0.0f;
        private float mVOffset = 1.0f;

        public OESTextureRenderer(int i3) {
            this.mSurfaceTexture = null;
            this.mSurface = null;
            this.mTextureID = i3;
            SurfaceTexture surfaceTexture = new SurfaceTexture(this.mTextureID);
            this.mSurfaceTexture = surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener(this);
            this.mSurface = new Surface(this.mSurfaceTexture);
        }

        private FrameUpdateInfo getFrameUpdateInfo() {
            FrameUpdateInfo frameUpdateInfo = new FrameUpdateInfo();
            frameUpdateInfo.CurrentPosition = MediaPlayer14.this.getCurrentPosition();
            frameUpdateInfo.FrameReady = false;
            frameUpdateInfo.RegionChanged = false;
            frameUpdateInfo.UScale = this.mUScale;
            frameUpdateInfo.UOffset = this.mUOffset;
            frameUpdateInfo.VScale = -this.mVScale;
            frameUpdateInfo.VOffset = 1.0f - this.mVOffset;
            if (!this.mFrameAvailable) {
                return frameUpdateInfo;
            }
            this.mFrameAvailable = false;
            SurfaceTexture surfaceTexture = this.mSurfaceTexture;
            if (surfaceTexture == null) {
                return frameUpdateInfo;
            }
            frameUpdateInfo.FrameReady = true;
            surfaceTexture.updateTexImage();
            this.mSurfaceTexture.getTransformMatrix(this.mTransformMatrix);
            float f16 = this.mUScale;
            float[] fArr = this.mTransformMatrix;
            float f17 = fArr[0];
            if (f16 != f17 || this.mVScale != fArr[5] || this.mUOffset != fArr[12] || this.mVOffset != fArr[13]) {
                this.mUScale = f17;
                float f18 = fArr[5];
                this.mVScale = f18;
                float f19 = fArr[12];
                this.mUOffset = f19;
                float f26 = fArr[13];
                this.mVOffset = f26;
                frameUpdateInfo.RegionChanged = true;
                frameUpdateInfo.UScale = f17;
                frameUpdateInfo.UOffset = f19;
                frameUpdateInfo.VScale = -f18;
                frameUpdateInfo.VOffset = 1.0f - f26;
            }
            GLES20.glBindTexture(this.GL_TEXTURE_EXTERNAL_OES, 0);
            return frameUpdateInfo;
        }

        public int getExternalTextureId() {
            return this.mTextureID;
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
                }
            }
        }

        public FrameUpdateInfo updateVideoFrame() {
            FrameUpdateInfo frameUpdateInfo;
            synchronized (this) {
                frameUpdateInfo = getFrameUpdateInfo();
            }
            return frameUpdateInfo;
        }
    }

    @SuppressLint({"NewApi"})
    /* loaded from: classes2.dex */
    public class PakDataSource extends MediaDataSource {
        ByteBuffer fileBuffer = ByteBuffer.allocateDirect(65536);
        long fileSize;
        long identifier;

        public PakDataSource(long j3, long j16) {
            this.identifier = j3;
            this.fileSize = j16;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
        }

        @Override // android.media.MediaDataSource
        public synchronized long getSize() throws IOException {
            return this.fileSize;
        }

        @Override // android.media.MediaDataSource
        public synchronized int readAt(long j3, byte[] bArr, int i3, int i16) throws IOException {
            synchronized (this.fileBuffer) {
                long j16 = this.fileSize;
                if (j3 >= j16) {
                    return -1;
                }
                if (i16 + j3 > j16) {
                    i16 = (int) (j16 - j3);
                }
                int i17 = i16;
                if (i17 > 0) {
                    int nativeReadAt = MediaPlayer14.this.nativeReadAt(this.identifier, j3, this.fileBuffer, 0, i17);
                    if (nativeReadAt > 0) {
                        System.arraycopy(this.fileBuffer.array(), this.fileBuffer.arrayOffset(), bArr, i3, nativeReadAt);
                    }
                    return nativeReadAt;
                }
                return 0;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class VideoTrackInfo {
        public int BitRate;
        public String DisplayName;
        public float FrameRate;
        public int Height;
        public int Index;
        public String Language;
        public String MimeType;
        public int Width;

        public VideoTrackInfo() {
        }
    }

    public MediaPlayer14(boolean z16, boolean z17, boolean z18) {
        this.SwizzlePixels = true;
        this.VulkanRenderer = false;
        this.NeedTrackInfo = true;
        this.AudioEnabled = true;
        this.AudioVolume = 1.0f;
        this.WaitOnBitmapRender = false;
        this.SwizzlePixels = z16;
        this.VulkanRenderer = z17;
        this.NeedTrackInfo = z18;
        this.WaitOnBitmapRender = false;
        this.AudioEnabled = true;
        this.AudioVolume = 1.0f;
        setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.epicgames.ue4.MediaPlayer14.1
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
                UE4.Log.debug("MediaPlayer14: onError returned what=" + i3 + ", extra=" + i16);
                return true;
            }
        });
        setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.epicgames.ue4.MediaPlayer14.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                synchronized (mediaPlayer) {
                    MediaPlayer14.this.Prepared = true;
                }
            }
        });
        setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.epicgames.ue4.MediaPlayer14.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                synchronized (mediaPlayer) {
                    if (MediaPlayer14.this.Looping) {
                        MediaPlayer14.this.seekTo(0);
                        MediaPlayer14.this.start();
                    }
                    MediaPlayer14.this.Completed = true;
                }
            }
        });
    }

    private boolean CreateBitmapRenderer() {
        releaseBitmapRenderer();
        BitmapRenderer bitmapRenderer = new BitmapRenderer(this.SwizzlePixels, this.VulkanRenderer);
        this.mBitmapRenderer = bitmapRenderer;
        if (!bitmapRenderer.isValid()) {
            this.mBitmapRenderer = null;
            return false;
        }
        this.mBitmapRenderer.setSize(getVideoWidth(), getVideoHeight());
        setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.epicgames.ue4.MediaPlayer14.4
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i3, int i16) {
                if (MediaPlayer14.this.mBitmapRenderer != null) {
                    MediaPlayer14.this.mBitmapRenderer.setSize(i3, i16);
                }
            }
        });
        setVideoEnabled(true);
        if (this.AudioEnabled) {
            setAudioEnabled(true);
        }
        return true;
    }

    private boolean CreateOESTextureRenderer(int i3) {
        releaseOESTextureRenderer();
        OESTextureRenderer oESTextureRenderer = new OESTextureRenderer(i3);
        this.mOESTextureRenderer = oESTextureRenderer;
        if (!oESTextureRenderer.isValid()) {
            this.mOESTextureRenderer = null;
            return false;
        }
        this.mOESTextureRenderer.setSize(getVideoWidth(), getVideoHeight());
        setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.epicgames.ue4.MediaPlayer14.5
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i16, int i17) {
                if (MediaPlayer14.this.mOESTextureRenderer != null) {
                    MediaPlayer14.this.mOESTextureRenderer.setSize(i16, i17);
                }
            }
        });
        setVideoEnabled(true);
        if (this.AudioEnabled) {
            setAudioEnabled(true);
        }
        return true;
    }

    public static String RemoteFileExists(String str) {
        boolean followRedirects = HttpURLConnection.getFollowRedirects();
        HttpURLConnection.setFollowRedirects(false);
        int i3 = 5;
        while (true) {
            int i16 = i3 - 1;
            if (i3 > 0) {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setRequestMethod("HEAD");
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        httpURLConnection.disconnect();
                        HttpURLConnection.setFollowRedirects(followRedirects);
                        return str;
                    }
                    if (responseCode != 303 && responseCode != 301 && responseCode != 302) {
                        HttpURLConnection.setFollowRedirects(followRedirects);
                        return null;
                    }
                    str = httpURLConnection.getHeaderField("Location");
                    URL url = httpURLConnection.getURL();
                    httpURLConnection.disconnect();
                    if (!str.contains(QzoneWebViewOfflinePlugin.STR_DEVIDER)) {
                        str = url.getProtocol() + QzoneWebViewOfflinePlugin.STR_DEVIDER + url.getHost() + str;
                    }
                    i3 = i16;
                } catch (Exception e16) {
                    e16.printStackTrace();
                    HttpURLConnection.setFollowRedirects(followRedirects);
                    return null;
                }
            } else {
                HttpURLConnection.setFollowRedirects(followRedirects);
                return null;
            }
        }
    }

    private AudioTrackInfo findAudioTrackIndex(int i3) {
        Iterator<AudioTrackInfo> it = this.audioTracks.iterator();
        while (it.hasNext()) {
            AudioTrackInfo next = it.next();
            if (next.Index == i3) {
                return next;
            }
        }
        return null;
    }

    private VideoTrackInfo findVideoTrackIndex(int i3) {
        Iterator<VideoTrackInfo> it = this.videoTracks.iterator();
        while (it.hasNext()) {
            VideoTrackInfo next = it.next();
            if (next.Index == i3) {
                return next;
            }
        }
        return null;
    }

    private void updateTrackInfo(MediaExtractor mediaExtractor) {
        if (mediaExtractor == null) {
            return;
        }
        int trackCount = mediaExtractor.getTrackCount();
        this.audioTracks.ensureCapacity(trackCount);
        this.videoTracks.ensureCapacity(trackCount);
        int i3 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < trackCount; i17++) {
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(i17);
            String string = trackFormat.getString("mime");
            if (string.startsWith("audio")) {
                AudioTrackInfo audioTrackInfo = new AudioTrackInfo();
                audioTrackInfo.Index = i17;
                audioTrackInfo.MimeType = string;
                audioTrackInfo.DisplayName = "Audio Track " + i3 + " (Stream " + i17 + ")";
                audioTrackInfo.Language = C.LANGUAGE_UNDETERMINED;
                audioTrackInfo.Channels = trackFormat.getInteger("channel-count");
                audioTrackInfo.SampleRate = trackFormat.getInteger("sample-rate");
                this.audioTracks.add(audioTrackInfo);
                i3++;
            } else if (string.startsWith("video")) {
                VideoTrackInfo videoTrackInfo = new VideoTrackInfo();
                videoTrackInfo.Index = i17;
                videoTrackInfo.MimeType = string;
                videoTrackInfo.DisplayName = "Video Track " + i16 + " (Stream " + i17 + ")";
                videoTrackInfo.Language = C.LANGUAGE_UNDETERMINED;
                videoTrackInfo.BitRate = 0;
                videoTrackInfo.Width = trackFormat.getInteger("width");
                videoTrackInfo.Height = trackFormat.getInteger("height");
                videoTrackInfo.FrameRate = 30.0f;
                if (trackFormat.containsKey("frame-rate")) {
                    videoTrackInfo.FrameRate = trackFormat.getInteger("frame-rate");
                }
                this.videoTracks.add(videoTrackInfo);
                i16++;
            }
        }
    }

    public AudioTrackInfo[] GetAudioTracks() {
        boolean z16;
        AudioTrackInfo findAudioTrackIndex;
        if (this.NeedTrackInfo) {
            MediaPlayer.TrackInfo[] trackInfo = getTrackInfo();
            int i3 = 0;
            for (MediaPlayer.TrackInfo trackInfo2 : trackInfo) {
                if (trackInfo2.getTrackType() == 2) {
                    i3++;
                }
            }
            AudioTrackInfo[] audioTrackInfoArr = new AudioTrackInfo[i3];
            int i16 = 0;
            for (int i17 = 0; i17 < trackInfo.length; i17++) {
                if (trackInfo[i17].getTrackType() == 2) {
                    AudioTrackInfo audioTrackInfo = new AudioTrackInfo();
                    audioTrackInfoArr[i16] = audioTrackInfo;
                    audioTrackInfo.Index = i17;
                    audioTrackInfo.DisplayName = "Audio Track " + i16 + " (Stream " + i17 + ")";
                    audioTrackInfoArr[i16].Language = trackInfo[i17].getLanguage();
                    MediaFormat format = trackInfo[i17].getFormat();
                    if (format != null) {
                        audioTrackInfoArr[i16].MimeType = format.getString("mime");
                        audioTrackInfoArr[i16].Channels = format.getInteger("channel-count");
                        audioTrackInfoArr[i16].SampleRate = format.getInteger("sample-rate");
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16 && this.audioTracks.size() > 0 && (findAudioTrackIndex = findAudioTrackIndex(i17)) != null) {
                        AudioTrackInfo audioTrackInfo2 = audioTrackInfoArr[i16];
                        audioTrackInfo2.MimeType = findAudioTrackIndex.MimeType;
                        audioTrackInfo2.Channels = findAudioTrackIndex.Channels;
                        audioTrackInfo2.SampleRate = findAudioTrackIndex.SampleRate;
                        z16 = true;
                    }
                    if (!z16) {
                        AudioTrackInfo audioTrackInfo3 = audioTrackInfoArr[i16];
                        audioTrackInfo3.MimeType = "audio/unknown";
                        audioTrackInfo3.Channels = 2;
                        audioTrackInfo3.SampleRate = 44100;
                    }
                    i16++;
                }
            }
            return audioTrackInfoArr;
        }
        AudioTrackInfo audioTrackInfo4 = new AudioTrackInfo();
        AudioTrackInfo[] audioTrackInfoArr2 = {audioTrackInfo4};
        audioTrackInfo4.Index = 0;
        audioTrackInfo4.MimeType = "audio/unknown";
        audioTrackInfo4.DisplayName = "Audio Track 0 (Stream 0)";
        audioTrackInfo4.Language = C.LANGUAGE_UNDETERMINED;
        audioTrackInfo4.Channels = 2;
        audioTrackInfo4.SampleRate = 44100;
        return audioTrackInfoArr2;
    }

    @SuppressLint({"WrongConstant"})
    public CaptionTrackInfo[] GetCaptionTracks() {
        if (this.NeedTrackInfo) {
            MediaPlayer.TrackInfo[] trackInfo = getTrackInfo();
            int i3 = 0;
            for (MediaPlayer.TrackInfo trackInfo2 : trackInfo) {
                if (trackInfo2.getTrackType() == 4) {
                    i3++;
                }
            }
            CaptionTrackInfo[] captionTrackInfoArr = new CaptionTrackInfo[i3];
            int i16 = 0;
            for (int i17 = 0; i17 < trackInfo.length; i17++) {
                if (trackInfo[i17].getTrackType() == 4) {
                    CaptionTrackInfo captionTrackInfo = new CaptionTrackInfo();
                    captionTrackInfoArr[i16] = captionTrackInfo;
                    captionTrackInfo.Index = i17;
                    captionTrackInfo.DisplayName = "Caption Track " + i16 + " (Stream " + i17 + ")";
                    MediaFormat format = trackInfo[i17].getFormat();
                    if (format != null) {
                        captionTrackInfoArr[i16].MimeType = format.getString("mime");
                        captionTrackInfoArr[i16].Language = format.getString(IjkMediaMeta.IJKM_KEY_LANGUAGE);
                    } else {
                        CaptionTrackInfo captionTrackInfo2 = captionTrackInfoArr[i16];
                        captionTrackInfo2.MimeType = "caption/unknown";
                        captionTrackInfo2.Language = trackInfo[i17].getLanguage();
                    }
                    i16++;
                }
            }
            return captionTrackInfoArr;
        }
        return new CaptionTrackInfo[0];
    }

    public VideoTrackInfo[] GetVideoTracks() {
        boolean z16;
        VideoTrackInfo findVideoTrackIndex;
        int videoWidth = getVideoWidth();
        int videoHeight = getVideoHeight();
        if (this.NeedTrackInfo) {
            MediaPlayer.TrackInfo[] trackInfo = getTrackInfo();
            int i3 = 0;
            for (MediaPlayer.TrackInfo trackInfo2 : trackInfo) {
                if (trackInfo2.getTrackType() == 1) {
                    i3++;
                }
            }
            VideoTrackInfo[] videoTrackInfoArr = new VideoTrackInfo[i3];
            int i16 = 0;
            for (int i17 = 0; i17 < trackInfo.length; i17++) {
                if (trackInfo[i17].getTrackType() == 1) {
                    VideoTrackInfo videoTrackInfo = new VideoTrackInfo();
                    videoTrackInfoArr[i16] = videoTrackInfo;
                    videoTrackInfo.Index = i17;
                    videoTrackInfo.DisplayName = "Video Track " + i16 + " (Stream " + i17 + ")";
                    videoTrackInfoArr[i16].Language = trackInfo[i17].getLanguage();
                    videoTrackInfoArr[i16].BitRate = 0;
                    MediaFormat format = trackInfo[i17].getFormat();
                    if (format != null) {
                        videoTrackInfoArr[i16].MimeType = format.getString("mime");
                        videoTrackInfoArr[i16].Width = Integer.parseInt(format.getString("width"));
                        videoTrackInfoArr[i16].Height = Integer.parseInt(format.getString("height"));
                        videoTrackInfoArr[i16].FrameRate = format.getFloat("frame-rate");
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16 && this.videoTracks.size() > 0 && (findVideoTrackIndex = findVideoTrackIndex(i17)) != null) {
                        VideoTrackInfo videoTrackInfo2 = videoTrackInfoArr[i16];
                        videoTrackInfo2.MimeType = findVideoTrackIndex.MimeType;
                        videoTrackInfo2.Width = findVideoTrackIndex.Width;
                        videoTrackInfo2.Height = findVideoTrackIndex.Height;
                        videoTrackInfo2.FrameRate = findVideoTrackIndex.FrameRate;
                        z16 = true;
                    }
                    if (!z16) {
                        VideoTrackInfo videoTrackInfo3 = videoTrackInfoArr[i16];
                        videoTrackInfo3.MimeType = "video/unknown";
                        videoTrackInfo3.Width = videoWidth;
                        videoTrackInfo3.Height = videoHeight;
                        videoTrackInfo3.FrameRate = 30.0f;
                    }
                    i16++;
                }
            }
            if (i3 > 0) {
                return videoTrackInfoArr;
            }
        }
        if (videoWidth > 0 && videoHeight > 0) {
            VideoTrackInfo videoTrackInfo4 = new VideoTrackInfo();
            VideoTrackInfo[] videoTrackInfoArr2 = {videoTrackInfo4};
            videoTrackInfo4.Index = 0;
            videoTrackInfo4.MimeType = "video/unknown";
            videoTrackInfo4.DisplayName = "Video Track 0 (Stream 0)";
            videoTrackInfo4.Language = C.LANGUAGE_UNDETERMINED;
            videoTrackInfo4.BitRate = 0;
            videoTrackInfo4.Width = videoWidth;
            videoTrackInfo4.Height = videoHeight;
            videoTrackInfo4.FrameRate = 30.0f;
            return videoTrackInfoArr2;
        }
        return new VideoTrackInfo[0];
    }

    public boolean didComplete() {
        boolean z16;
        synchronized (this) {
            z16 = this.Completed;
            this.Completed = false;
        }
        return z16;
    }

    public boolean didResolutionChange() {
        OESTextureRenderer oESTextureRenderer = this.mOESTextureRenderer;
        if (oESTextureRenderer != null) {
            return oESTextureRenderer.resolutionChanged();
        }
        BitmapRenderer bitmapRenderer = this.mBitmapRenderer;
        if (bitmapRenderer != null) {
            return bitmapRenderer.resolutionChanged();
        }
        return false;
    }

    @Override // android.media.MediaPlayer
    public int getCurrentPosition() {
        int i3;
        synchronized (this) {
            if (this.Prepared) {
                i3 = super.getCurrentPosition();
            } else {
                i3 = 0;
            }
        }
        return i3;
    }

    @Override // android.media.MediaPlayer
    public int getDuration() {
        int i3;
        synchronized (this) {
            if (this.Prepared) {
                i3 = super.getDuration();
            } else {
                i3 = 0;
            }
        }
        return i3;
    }

    public int getExternalTextureId() {
        OESTextureRenderer oESTextureRenderer = this.mOESTextureRenderer;
        if (oESTextureRenderer != null) {
            return oESTextureRenderer.getExternalTextureId();
        }
        BitmapRenderer bitmapRenderer = this.mBitmapRenderer;
        if (bitmapRenderer != null) {
            return bitmapRenderer.getExternalTextureId();
        }
        return -1;
    }

    public boolean getVideoLastFrame(int i3) {
        initBitmapRenderer();
        if (this.mBitmapRenderer == null) {
            return false;
        }
        this.WaitOnBitmapRender = true;
        boolean updateFrameData = this.mBitmapRenderer.updateFrameData(i3);
        this.WaitOnBitmapRender = false;
        return updateFrameData;
    }

    public Buffer getVideoLastFrameData() {
        initBitmapRenderer();
        if (this.mBitmapRenderer != null) {
            this.WaitOnBitmapRender = true;
            Buffer updateFrameData = this.mBitmapRenderer.updateFrameData();
            this.WaitOnBitmapRender = false;
            return updateFrameData;
        }
        return null;
    }

    public void initBitmapRenderer() {
        if (this.mBitmapRenderer == null && !CreateBitmapRenderer()) {
            UE4.Log.warn("initBitmapRenderer failed to alloc mBitmapRenderer ");
            reset();
        }
    }

    @Override // android.media.MediaPlayer
    public boolean isLooping() {
        return this.Looping;
    }

    public boolean isPrepared() {
        boolean z16;
        synchronized (this) {
            z16 = this.Prepared;
        }
        return z16;
    }

    public native void nativeClearCachedAttributeState(int i3, int i16);

    public native int nativeReadAt(long j3, long j16, ByteBuffer byteBuffer, int i3, int i16);

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer, android.media.MediaPlayer
    public void prepare() throws IOException, IllegalStateException {
        synchronized (this) {
            this.Completed = false;
            try {
                try {
                    try {
                        super.prepare();
                        this.Prepared = true;
                    } catch (IllegalStateException e16) {
                        UE4.Log.debug("MediaPlayer14: Prepare IllegalStateExecption: " + e16.toString());
                        throw e16;
                    }
                } catch (IOException e17) {
                    UE4.Log.debug("MediaPlayer14: Prepare IOException: " + e17.toString());
                    throw e17;
                }
            } catch (Exception e18) {
                UE4.Log.debug("MediaPlayer14: Prepare Exception: " + e18.toString());
                throw e18;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0012, code lost:
    
        if (r1.WaitOnBitmapRender == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0015, code lost:
    
        releaseOESTextureRenderer();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0018, code lost:
    
        super.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x001b, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x0002, code lost:
    
        if (r1.mOESTextureRenderer != null) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0006, code lost:
    
        if (r1.WaitOnBitmapRender == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0009, code lost:
    
        releaseOESTextureRenderer();
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x000e, code lost:
    
        if (r1.mBitmapRenderer == null) goto L14;
     */
    @Override // android.media.MediaPlayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void release() {
    }

    void releaseBitmapRenderer() {
        BitmapRenderer bitmapRenderer = this.mBitmapRenderer;
        if (bitmapRenderer != null) {
            bitmapRenderer.release();
            this.mBitmapRenderer = null;
            setSurface(null);
            setOnVideoSizeChangedListener(null);
        }
    }

    void releaseOESTextureRenderer() {
        OESTextureRenderer oESTextureRenderer = this.mOESTextureRenderer;
        if (oESTextureRenderer != null) {
            oESTextureRenderer.release();
            this.mOESTextureRenderer = null;
            setSurface(null);
            setOnVideoSizeChangedListener(null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0010, code lost:
    
        releaseOESTextureRenderer();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0015, code lost:
    
        if (r1.mBitmapRenderer == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0019, code lost:
    
        if (r1.WaitOnBitmapRender == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x001c, code lost:
    
        releaseBitmapRenderer();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x001f, code lost:
    
        super.reset();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0022, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0009, code lost:
    
        if (r1.mOESTextureRenderer != null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x000d, code lost:
    
        if (r1.WaitOnBitmapRender == false) goto L25;
     */
    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer, android.media.MediaPlayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void reset() {
        synchronized (this) {
            this.Prepared = false;
            this.Completed = false;
        }
    }

    @Override // android.media.MediaPlayer
    public void seekTo(int i3) {
        synchronized (this) {
            this.Completed = false;
            if (this.Prepared) {
                super.seekTo(i3);
            }
        }
    }

    public void setAudioEnabled(boolean z16) {
        this.AudioEnabled = z16;
        if (z16) {
            float f16 = this.AudioVolume;
            setVolume(f16, f16);
        } else {
            setVolume(0.0f, 0.0f);
        }
    }

    public void setAudioVolume(float f16) {
        this.AudioVolume = f16;
        setAudioEnabled(this.AudioEnabled);
    }

    public boolean setDataSource(String str, long j3, long j16) throws IOException, InterruptedException, ExecutionException {
        synchronized (this) {
            this.Prepared = false;
            this.Completed = false;
        }
        this.Looping = false;
        this.AudioEnabled = true;
        this.audioTracks.clear();
        this.videoTracks.clear();
        try {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
                setDataSource(randomAccessFile.getFD(), j3, j16);
                releaseOESTextureRenderer();
                releaseBitmapRenderer();
                if (this.NeedTrackInfo) {
                    MediaExtractor mediaExtractor = new MediaExtractor();
                    mediaExtractor.setDataSource(randomAccessFile.getFD(), j3, j16);
                    updateTrackInfo(mediaExtractor);
                    mediaExtractor.release();
                }
                return true;
            }
            return false;
        } catch (IOException e16) {
            UE4.Log.debug("setDataSource (file): Exception = " + e16);
            return false;
        }
    }

    public boolean setDataSourceArchive(long j3, long j16) throws IOException, InterruptedException, ExecutionException {
        synchronized (this) {
            this.Prepared = false;
            this.Completed = false;
        }
        this.Looping = false;
        this.AudioEnabled = true;
        this.audioTracks.clear();
        this.videoTracks.clear();
        try {
            PakDataSource pakDataSource = new PakDataSource(j3, j16);
            setDataSource(pakDataSource);
            releaseOESTextureRenderer();
            releaseBitmapRenderer();
            if (this.NeedTrackInfo) {
                MediaExtractor mediaExtractor = new MediaExtractor();
                mediaExtractor.setDataSource(pakDataSource);
                updateTrackInfo(mediaExtractor);
                mediaExtractor.release();
            }
            return true;
        } catch (IOException e16) {
            UE4.Log.debug("setDataSource (archive): Exception = " + e16);
            return false;
        }
    }

    public boolean setDataSourceURL(String str) throws IOException, InterruptedException, ExecutionException {
        synchronized (this) {
            this.Prepared = false;
            this.Completed = false;
        }
        this.Looping = false;
        this.AudioEnabled = true;
        this.audioTracks.clear();
        this.videoTracks.clear();
        String RemoteFileExists = RemoteFileExists(str);
        if (RemoteFileExists == null) {
            return false;
        }
        try {
            setDataSource(RemoteFileExists);
            releaseOESTextureRenderer();
            releaseBitmapRenderer();
            if (this.NeedTrackInfo) {
                MediaExtractor mediaExtractor = new MediaExtractor();
                try {
                    mediaExtractor.setDataSource(RemoteFileExists);
                    updateTrackInfo(mediaExtractor);
                    mediaExtractor.release();
                } catch (Exception e16) {
                    UE4.Log.debug("setDataSourceURL: Exception = " + e16);
                    UE4.Log.debug("setDataSourceURL: Continuing without track info");
                    mediaExtractor.release();
                }
            }
            return true;
        } catch (IOException e17) {
            UE4.Log.debug("setDataSourceURL: Exception = " + e17);
            return false;
        }
    }

    @Override // android.media.MediaPlayer
    public void setLooping(boolean z16) {
        this.Looping = z16;
    }

    public void setVideoEnabled(boolean z16) {
        this.WaitOnBitmapRender = true;
        this.mVideoEnabled = z16;
        if (z16) {
            OESTextureRenderer oESTextureRenderer = this.mOESTextureRenderer;
            if (oESTextureRenderer != null && oESTextureRenderer.getSurface() != null) {
                setSurface(this.mOESTextureRenderer.getSurface());
            }
            BitmapRenderer bitmapRenderer = this.mBitmapRenderer;
            if (bitmapRenderer != null && bitmapRenderer.getSurface() != null) {
                setSurface(this.mBitmapRenderer.getSurface());
            }
        } else {
            setSurface(null);
        }
        this.WaitOnBitmapRender = false;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer, android.media.MediaPlayer
    public void start() {
        synchronized (this) {
            this.Completed = false;
            if (this.Prepared) {
                super.start();
            }
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer, android.media.MediaPlayer
    public void stop() {
        synchronized (this) {
            this.Completed = false;
            if (this.Prepared) {
                super.stop();
            }
        }
    }

    public FrameUpdateInfo updateVideoFrame(int i3) {
        if (this.mOESTextureRenderer == null && !CreateOESTextureRenderer(i3)) {
            UE4.Log.warn("updateVideoFrame failed to alloc mOESTextureRenderer ");
            reset();
            return null;
        }
        this.WaitOnBitmapRender = true;
        FrameUpdateInfo updateVideoFrame = this.mOESTextureRenderer.updateVideoFrame();
        this.WaitOnBitmapRender = false;
        return updateVideoFrame;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class BitmapRenderer implements SurfaceTexture.OnFrameAvailableListener {
        private static final int FLOAT_SIZE_BYTES = 4;
        private static final int TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
        private static final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 16;
        private static final int TRIANGLE_VERTICES_DATA_UV_OFFSET = 2;
        private int mBlitBuffer;
        private EGLDisplay mEglDisplay;
        private int mPositionAttrib;
        private int mProgram;
        private EGLContext mSavedContext;
        private EGLDisplay mSavedDisplay;
        private EGLSurface mSavedSurfaceDraw;
        private EGLSurface mSavedSurfaceRead;
        private boolean mSwizzlePixels;
        private int mTexCoordsAttrib;
        private int mTextureUniform;
        private FloatBuffer mTriangleVertices;
        private boolean mUseOwnContext;
        private boolean mVulkanRenderer;
        private Buffer mFrameData = null;
        private int mLastFramePosition = -1;
        private SurfaceTexture mSurfaceTexture = null;
        private int mTextureWidth = -1;
        private int mTextureHeight = -1;
        private Surface mSurface = null;
        private boolean mFrameAvailable = false;
        private int mTextureID = -1;
        private int mFBO = -1;
        private int mBlitVertexShaderID = -1;
        private int mBlitFragmentShaderID = -1;
        private float[] mTransformMatrix = new float[16];
        private boolean mTriangleVerticesDirty = true;
        private boolean mTextureSizeChanged = true;
        private int GL_TEXTURE_EXTERNAL_OES = 36197;
        private boolean mCreatedEGLDisplay = false;
        private float[] mTriangleVerticesData = {-1.0f, -1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f};
        private final String mBlitVextexShader = "attribute vec2 Position;\nattribute vec2 TexCoords;\nvarying vec2 TexCoord;\nvoid main() {\n\tTexCoord = TexCoords;\n\tgl_Position = vec4(Position, 0.0, 1.0);\n}\n";
        private final String mBlitFragmentShaderBGRA = "#extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES VideoTexture;\nvarying highp vec2 TexCoord;\nvoid main()\n{\n\tgl_FragColor = texture2D(VideoTexture, TexCoord).bgra;\n}\n";
        private final String mBlitFragmentShaderRGBA = "#extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES VideoTexture;\nvarying highp vec2 TexCoord;\nvoid main()\n{\n\tgl_FragColor = texture2D(VideoTexture, TexCoord).rgba;\n}\n";
        private EGLSurface mEglSurface = EGL14.EGL_NO_SURFACE;
        private EGLContext mEglContext = EGL14.EGL_NO_CONTEXT;

        public BitmapRenderer(boolean z16, boolean z17) {
            this.mUseOwnContext = true;
            this.mSwizzlePixels = z16;
            this.mVulkanRenderer = z17;
            this.mUseOwnContext = true;
            if (z17) {
                this.mSwizzlePixels = true;
            } else {
                String glGetString = GLES20.glGetString(7937);
                if (glGetString.contains("Adreno (TM) ") && Integer.parseInt(glGetString.substring(12)) < 400) {
                    UE4.Log.debug("MediaPlayer14: disabled shared GL context on " + glGetString);
                    this.mUseOwnContext = false;
                }
            }
            if (this.mUseOwnContext) {
                initContext();
                saveContext();
                makeCurrent();
                initSurfaceTexture();
                restoreContext();
                return;
            }
            initSurfaceTexture();
        }

        private void UpdateVertexData() {
            if (this.mTriangleVerticesDirty && this.mBlitBuffer > 0) {
                this.mTriangleVertices.position(0);
                this.mTriangleVertices.put(this.mTriangleVerticesData).position(0);
                int[] iArr = new int[1];
                GLES20.glGetIntegerv(34964, iArr, 0);
                int i3 = iArr[0];
                GLES20.glBindBuffer(34962, this.mBlitBuffer);
                GLES20.glBufferData(34962, this.mTriangleVerticesData.length * 4, this.mTriangleVertices, 35044);
                GLES20.glBindBuffer(34962, i3);
                this.mTriangleVerticesDirty = false;
            }
        }

        private boolean copyFrameTexture(int i3, Buffer buffer) {
            int i16;
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            boolean z26;
            int i17;
            boolean z27;
            int i18;
            int i19;
            int i26;
            int i27;
            int i28;
            int i29;
            int i36;
            int i37;
            char c16;
            if (!this.mFrameAvailable) {
                return false;
            }
            this.mFrameAvailable = false;
            this.mLastFramePosition = MediaPlayer14.this.getCurrentPosition();
            if (this.mSurfaceTexture == null) {
                return false;
            }
            int[] iArr = new int[1];
            int[] iArr2 = new int[4];
            if (this.mUseOwnContext) {
                GLES20.glActiveTexture(33984);
                GLES20.glGetTexParameteriv(GLSLRender.GL_TEXTURE_2D, 10241, iArr, 0);
                int i38 = iArr[0];
                GLES20.glGetTexParameteriv(GLSLRender.GL_TEXTURE_2D, 10240, iArr, 0);
                int i39 = iArr[0];
                saveContext();
                makeCurrent();
                i16 = i39;
                i19 = 0;
                z27 = false;
                z26 = false;
                z19 = false;
                z18 = false;
                z17 = false;
                z16 = false;
                i17 = i38;
                i18 = 0;
            } else {
                GLES20.glGetError();
                boolean glIsEnabled = GLES20.glIsEnabled(3042);
                boolean glIsEnabled2 = GLES20.glIsEnabled(2884);
                boolean glIsEnabled3 = GLES20.glIsEnabled(3089);
                boolean glIsEnabled4 = GLES20.glIsEnabled(2960);
                boolean glIsEnabled5 = GLES20.glIsEnabled(2929);
                boolean glIsEnabled6 = GLES20.glIsEnabled(3024);
                GLES20.glGetIntegerv(36006, iArr, 0);
                int i46 = iArr[0];
                GLES20.glGetIntegerv(34964, iArr, 0);
                int i47 = iArr[0];
                GLES20.glGetIntegerv(2978, iArr2, 0);
                GLES20.glActiveTexture(33984);
                GLES20.glGetTexParameteriv(GLSLRender.GL_TEXTURE_2D, 10241, iArr, 0);
                int i48 = iArr[0];
                GLES20.glGetTexParameteriv(GLSLRender.GL_TEXTURE_2D, 10240, iArr, 0);
                int i49 = iArr[0];
                glVerify("save state");
                i16 = i49;
                z16 = glIsEnabled6;
                z17 = glIsEnabled5;
                z18 = glIsEnabled4;
                z19 = glIsEnabled3;
                z26 = glIsEnabled2;
                i17 = i48;
                z27 = glIsEnabled;
                i18 = i47;
                i19 = i46;
            }
            this.mSurfaceTexture.updateTexImage();
            this.mSurfaceTexture.getTransformMatrix(this.mTransformMatrix);
            float[] fArr = this.mTransformMatrix;
            float f16 = fArr[12];
            float f17 = f16 + fArr[0];
            float f18 = fArr[13];
            float f19 = f18 + fArr[5];
            float[] fArr2 = this.mTriangleVerticesData;
            if (fArr2[2] != f16 || fArr2[6] != f17 || fArr2[11] != f18 || fArr2[3] != f19) {
                fArr2[10] = f16;
                fArr2[2] = f16;
                fArr2[14] = f17;
                fArr2[6] = f17;
                fArr2[15] = f18;
                fArr2[11] = f18;
                fArr2[7] = f19;
                fArr2[3] = f19;
                this.mTriangleVerticesDirty = true;
            }
            if (buffer != null) {
                buffer.position(0);
            }
            if (!this.mUseOwnContext) {
                GLES20.glDisable(3042);
                GLES20.glDisable(2884);
                GLES20.glDisable(3089);
                GLES20.glDisable(2960);
                GLES20.glDisable(2929);
                GLES20.glDisable(3024);
                GLES20.glColorMask(true, true, true, true);
                glVerify("reset state");
            }
            GLES20.glViewport(0, 0, this.mTextureWidth, this.mTextureHeight);
            glVerify("set viewport");
            if (buffer != null) {
                GLES20.glGenTextures(1, iArr, 0);
                i26 = iArr[0];
            } else {
                i26 = i3;
            }
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i26);
            GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10241, 9728);
            GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10240, 9728);
            GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
            GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
            if (buffer != null) {
                GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, this.mTextureWidth, this.mTextureHeight, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
            }
            glVerify("set-up FBO texture");
            GLES20.glBindFramebuffer(36160, this.mFBO);
            GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, i26, 0);
            int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
            if (glCheckFramebufferStatus != 36053) {
                UE4.Log.warn("Failed to complete framebuffer attachment (" + glCheckFramebufferStatus + ")");
            }
            GLES20.glUseProgram(this.mProgram);
            UpdateVertexData();
            GLES20.glBindBuffer(34962, this.mBlitBuffer);
            GLES20.glEnableVertexAttribArray(this.mPositionAttrib);
            GLES20.glVertexAttribPointer(this.mPositionAttrib, 2, 5126, false, 16, 0);
            GLES20.glEnableVertexAttribArray(this.mTexCoordsAttrib);
            GLES20.glVertexAttribPointer(this.mTexCoordsAttrib, 2, 5126, false, 16, 8);
            glVerify("setup movie texture read");
            GLES20.glClear(16384);
            GLES20.glUniform1i(this.mTextureUniform, 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(this.GL_TEXTURE_EXTERNAL_OES, this.mTextureID);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glFlush();
            if (buffer != null) {
                i37 = 36064;
                i27 = i18;
                i28 = i16;
                i29 = i17;
                i36 = i26;
                GLES20.glReadPixels(0, 0, this.mTextureWidth, this.mTextureHeight, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, buffer);
            } else {
                i27 = i18;
                i28 = i16;
                i29 = i17;
                i36 = i26;
                i37 = 36064;
            }
            glVerify("draw & read movie texture");
            if (this.mUseOwnContext) {
                GLES20.glFramebufferTexture2D(36160, i37, GLSLRender.GL_TEXTURE_2D, 0, 0);
                if (buffer != null && i36 > 0) {
                    iArr[0] = i36;
                    GLES20.glDeleteTextures(1, iArr, 0);
                }
                restoreContext();
                GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10241, i29);
                GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10240, i28);
                return true;
            }
            int i56 = i29;
            GLES20.glBindFramebuffer(36160, i19);
            if (buffer != null && i36 > 0) {
                iArr[0] = i36;
                c16 = 1;
                GLES20.glDeleteTextures(1, iArr, 0);
            } else {
                c16 = 1;
            }
            GLES20.glBindBuffer(34962, i27);
            GLES20.glViewport(iArr2[0], iArr2[c16], iArr2[2], iArr2[3]);
            if (z27) {
                GLES20.glEnable(3042);
            }
            if (z26) {
                GLES20.glEnable(2884);
            }
            if (z19) {
                GLES20.glEnable(3089);
            }
            if (z18) {
                GLES20.glEnable(2960);
            }
            if (z17) {
                GLES20.glEnable(2929);
            }
            if (z16) {
                GLES20.glEnable(3024);
            }
            GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10241, i56);
            GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10240, i28);
            GLES20.glDisableVertexAttribArray(this.mPositionAttrib);
            GLES20.glDisableVertexAttribArray(this.mTexCoordsAttrib);
            MediaPlayer14.this.nativeClearCachedAttributeState(this.mPositionAttrib, this.mTexCoordsAttrib);
            return true;
        }

        private int createShader(int i3, String str) {
            int glCreateShader = GLES20.glCreateShader(i3);
            if (glCreateShader != 0) {
                GLES20.glShaderSource(glCreateShader, str);
                GLES20.glCompileShader(glCreateShader);
                int[] iArr = new int[1];
                GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
                if (iArr[0] == 0) {
                    UE4.Log.error("Could not compile shader " + i3 + ":");
                    UE4.Log.error(GLES20.glGetShaderInfoLog(glCreateShader));
                    GLES20.glDeleteShader(glCreateShader);
                    return 0;
                }
                return glCreateShader;
            }
            return glCreateShader;
        }

        private void glVerify(String str) {
            int glGetError = GLES20.glGetError();
            if (glGetError == 0) {
                return;
            }
            showGlError(str, glGetError);
            throw new RuntimeException(str + ": glGetError " + glGetError);
        }

        private void glWarn(String str) {
            while (true) {
                int glGetError = GLES20.glGetError();
                if (glGetError != 0) {
                    showGlError(str, glGetError);
                } else {
                    return;
                }
            }
        }

        private void initContext() {
            this.mEglDisplay = EGL14.EGL_NO_DISPLAY;
            EGLContext eGLContext = EGL14.EGL_NO_CONTEXT;
            int[] iArr = {0};
            int[] iArr2 = {0};
            if (!this.mVulkanRenderer) {
                this.mEglDisplay = EGL14.eglGetCurrentDisplay();
                eGLContext = EGL14.eglGetCurrentContext();
                if (EGL14.eglQueryContext(this.mEglDisplay, eGLContext, EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, iArr, 0) && EGL14.eglQueryContext(this.mEglDisplay, eGLContext, 12539, iArr2, 0)) {
                    UE4.Log.debug("MediaPlayer14: Existing GL context is version " + iArr[0] + "." + iArr2[0]);
                } else if (EGL14.eglQueryContext(this.mEglDisplay, eGLContext, EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, iArr, 0)) {
                    UE4.Log.debug("MediaPlayer14: Existing GL context is version " + iArr[0]);
                } else {
                    UE4.Log.debug("MediaPlayer14: Existing GL context version not detected");
                }
            } else {
                EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
                this.mEglDisplay = eglGetDisplay;
                if (eglGetDisplay == EGL14.EGL_NO_DISPLAY) {
                    UE4.Log.error("unable to get EGL14 display");
                    return;
                }
                int[] iArr3 = new int[2];
                if (!EGL14.eglInitialize(eglGetDisplay, iArr3, 0, iArr3, 1)) {
                    this.mEglDisplay = null;
                    UE4.Log.error("unable to initialize EGL14 display");
                    return;
                }
                this.mCreatedEGLDisplay = true;
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            EGL14.eglChooseConfig(this.mEglDisplay, new int[]{12352, 4, 12339, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0);
            int[] iArr4 = {EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 2, 12344};
            int[] iArr5 = {EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 3, 12539, 1, 12344};
            EGLDisplay eGLDisplay = this.mEglDisplay;
            EGLConfig eGLConfig = eGLConfigArr[0];
            if (iArr[0] == 3) {
                iArr4 = iArr5;
            }
            this.mEglContext = EGL14.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr4, 0);
            if (EGL14.eglQueryString(this.mEglDisplay, 12373).contains("EGL_KHR_surfaceless_context")) {
                this.mEglSurface = EGL14.EGL_NO_SURFACE;
            } else {
                this.mEglSurface = EGL14.eglCreatePbufferSurface(this.mEglDisplay, eGLConfigArr[0], new int[]{12344}, 0);
            }
        }

        private void initSurfaceTexture() {
            String str;
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            int i3 = iArr[0];
            this.mTextureID = i3;
            if (i3 <= 0) {
                UE4.Log.error("mTextureID <= 0");
                release();
                return;
            }
            SurfaceTexture surfaceTexture = new SurfaceTexture(this.mTextureID);
            this.mSurfaceTexture = surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener(this);
            this.mSurface = new Surface(this.mSurfaceTexture);
            int[] iArr2 = new int[1];
            GLES20.glGenFramebuffers(1, iArr2, 0);
            int i16 = iArr2[0];
            this.mFBO = i16;
            if (i16 <= 0) {
                UE4.Log.error("mFBO <= 0");
                release();
                return;
            }
            int createShader = createShader(35633, "attribute vec2 Position;\nattribute vec2 TexCoords;\nvarying vec2 TexCoord;\nvoid main() {\n\tTexCoord = TexCoords;\n\tgl_Position = vec4(Position, 0.0, 1.0);\n}\n");
            this.mBlitVertexShaderID = createShader;
            if (createShader == 0) {
                UE4.Log.error("mBlitVertexShaderID == 0");
                release();
                return;
            }
            if (this.mSwizzlePixels) {
                str = "#extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES VideoTexture;\nvarying highp vec2 TexCoord;\nvoid main()\n{\n\tgl_FragColor = texture2D(VideoTexture, TexCoord).bgra;\n}\n";
            } else {
                str = "#extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES VideoTexture;\nvarying highp vec2 TexCoord;\nvoid main()\n{\n\tgl_FragColor = texture2D(VideoTexture, TexCoord).rgba;\n}\n";
            }
            int createShader2 = createShader(35632, str);
            if (createShader2 == 0) {
                UE4.Log.error("mBlitFragmentShaderID == 0");
                release();
                return;
            }
            int glCreateProgram = GLES20.glCreateProgram();
            this.mProgram = glCreateProgram;
            if (glCreateProgram <= 0) {
                UE4.Log.error("mProgram <= 0");
                release();
                return;
            }
            GLES20.glAttachShader(glCreateProgram, this.mBlitVertexShaderID);
            GLES20.glAttachShader(this.mProgram, createShader2);
            GLES20.glLinkProgram(this.mProgram);
            int[] iArr3 = new int[1];
            GLES20.glGetProgramiv(this.mProgram, 35714, iArr3, 0);
            if (iArr3[0] != 1) {
                UE4.Log.error("Could not link program: ");
                UE4.Log.error(GLES20.glGetProgramInfoLog(this.mProgram));
                GLES20.glDeleteProgram(this.mProgram);
                this.mProgram = 0;
                release();
                return;
            }
            this.mPositionAttrib = GLES20.glGetAttribLocation(this.mProgram, "Position");
            this.mTexCoordsAttrib = GLES20.glGetAttribLocation(this.mProgram, "TexCoords");
            this.mTextureUniform = GLES20.glGetUniformLocation(this.mProgram, "VideoTexture");
            GLES20.glGenBuffers(1, iArr2, 0);
            int i17 = iArr2[0];
            this.mBlitBuffer = i17;
            if (i17 <= 0) {
                UE4.Log.error("mBlitBuffer <= 0");
                release();
                return;
            }
            this.mTriangleVertices = ByteBuffer.allocateDirect(this.mTriangleVerticesData.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.mTriangleVerticesDirty = true;
            if (this.mUseOwnContext) {
                GLES20.glDisable(3042);
                GLES20.glDisable(2884);
                GLES20.glDisable(3089);
                GLES20.glDisable(2960);
                GLES20.glDisable(2929);
                GLES20.glDisable(3024);
                GLES20.glColorMask(true, true, true, true);
            }
        }

        private void makeCurrent() {
            EGLDisplay eGLDisplay = this.mEglDisplay;
            EGLSurface eGLSurface = this.mEglSurface;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.mEglContext);
        }

        private void restoreContext() {
            EGL14.eglMakeCurrent(this.mSavedDisplay, this.mSavedSurfaceDraw, this.mSavedSurfaceRead, this.mSavedContext);
        }

        private void saveContext() {
            this.mSavedDisplay = EGL14.eglGetCurrentDisplay();
            this.mSavedContext = EGL14.eglGetCurrentContext();
            this.mSavedSurfaceDraw = EGL14.eglGetCurrentSurface(12377);
            this.mSavedSurfaceRead = EGL14.eglGetCurrentSurface(12378);
        }

        private void showGlError(String str, int i3) {
            switch (i3) {
                case 1280:
                    UE4.Log.error("MediaPlayer$BitmapRenderer: " + str + ": glGetError GL_INVALID_ENUM");
                    return;
                case 1281:
                    UE4.Log.error("MediaPlayer$BitmapRenderer: " + str + ": glGetError GL_INVALID_VALUE");
                    return;
                case 1282:
                    UE4.Log.error("MediaPlayer$BitmapRenderer: " + str + ": glGetError GL_INVALID_OPERATION");
                    return;
                case 1285:
                    UE4.Log.error("MediaPlayer$BitmapRenderer: " + str + ": glGetError GL_OUT_OF_MEMORY");
                    return;
                case 1286:
                    UE4.Log.error("MediaPlayer$BitmapRenderer: " + str + ": glGetError GL_INVALID_FRAMEBUFFER_OPERATION");
                    return;
                case 36054:
                    UE4.Log.error("MediaPlayer$BitmapRenderer: " + str + ": glGetError GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT");
                    return;
                case 36057:
                    UE4.Log.error("MediaPlayer$BitmapRenderer: " + str + ": glGetError GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS");
                    return;
                case 36061:
                    UE4.Log.error("MediaPlayer$BitmapRenderer: " + str + ": glGetError GL_FRAMEBUFFER_UNSUPPORTED");
                    return;
                default:
                    UE4.Log.error("MediaPlayer$BitmapRenderer: " + str + ": glGetError " + i3);
                    return;
            }
        }

        public int getExternalTextureId() {
            return this.mTextureID;
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
            int[] iArr = new int[1];
            int i3 = this.mBlitBuffer;
            if (i3 > 0) {
                iArr[0] = i3;
                GLES20.glDeleteBuffers(1, iArr, 0);
                this.mBlitBuffer = -1;
            }
            int i16 = this.mProgram;
            if (i16 > 0) {
                GLES20.glDeleteProgram(i16);
                this.mProgram = -1;
            }
            int i17 = this.mBlitVertexShaderID;
            if (i17 > 0) {
                GLES20.glDeleteShader(i17);
                this.mBlitVertexShaderID = -1;
            }
            int i18 = this.mBlitFragmentShaderID;
            if (i18 > 0) {
                GLES20.glDeleteShader(i18);
                this.mBlitFragmentShaderID = -1;
            }
            int i19 = this.mFBO;
            if (i19 > 0) {
                iArr[0] = i19;
                GLES20.glDeleteFramebuffers(1, iArr, 0);
                this.mFBO = -1;
            }
            int i26 = this.mTextureID;
            if (i26 > 0) {
                iArr[0] = i26;
                GLES20.glDeleteTextures(1, iArr, 0);
                this.mTextureID = -1;
            }
            EGLSurface eGLSurface = this.mEglSurface;
            if (eGLSurface != EGL14.EGL_NO_SURFACE) {
                EGL14.eglDestroySurface(this.mEglDisplay, eGLSurface);
                this.mEglSurface = EGL14.EGL_NO_SURFACE;
            }
            EGLContext eGLContext = this.mEglContext;
            if (eGLContext != EGL14.EGL_NO_CONTEXT) {
                EGL14.eglDestroyContext(this.mEglDisplay, eGLContext);
                this.mEglContext = EGL14.EGL_NO_CONTEXT;
            }
            if (this.mCreatedEGLDisplay) {
                EGL14.eglTerminate(this.mEglDisplay);
                this.mEglDisplay = EGL14.EGL_NO_DISPLAY;
                this.mCreatedEGLDisplay = false;
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
                    this.mFrameData = null;
                    this.mTextureSizeChanged = true;
                }
            }
        }

        public Buffer updateFrameData() {
            int i3;
            int i16;
            synchronized (this) {
                if (this.mFrameData == null && (i3 = this.mTextureWidth) > 0 && (i16 = this.mTextureHeight) > 0) {
                    this.mFrameData = ByteBuffer.allocateDirect(i3 * i16 * 4);
                }
                if (copyFrameTexture(0, this.mFrameData)) {
                    return this.mFrameData;
                }
                return null;
            }
        }

        public boolean updateFrameData(int i3) {
            synchronized (this) {
                return copyFrameTexture(i3, null);
            }
        }
    }

    public boolean setDataSource(AssetManager assetManager, String str, long j3, long j16) throws InterruptedException, ExecutionException {
        synchronized (this) {
            this.Prepared = false;
            this.Completed = false;
        }
        this.Looping = false;
        this.AudioEnabled = true;
        this.audioTracks.clear();
        this.videoTracks.clear();
        try {
            AssetFileDescriptor openFd = assetManager.openFd(str);
            setDataSource(openFd.getFileDescriptor(), j3, j16);
            releaseOESTextureRenderer();
            releaseBitmapRenderer();
            if (this.NeedTrackInfo) {
                MediaExtractor mediaExtractor = new MediaExtractor();
                mediaExtractor.setDataSource(openFd.getFileDescriptor(), j3, j16);
                updateTrackInfo(mediaExtractor);
                mediaExtractor.release();
            }
            return true;
        } catch (IOException e16) {
            UE4.Log.debug("setDataSource (asset): Exception = " + e16);
            return false;
        }
    }
}
