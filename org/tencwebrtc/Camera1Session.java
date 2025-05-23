package org.tencwebrtc;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.qmethod.pandoraex.monitor.CameraMonitor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.tencwebrtc.Camera1Session;
import org.tencwebrtc.CameraEnumerationAndroid;
import org.tencwebrtc.CameraSession;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes29.dex */
public class Camera1Session implements CameraSession {
    private static final int NUMBER_OF_CAPTURE_BUFFERS = 3;
    private static final String TAG = "Camera1Session";
    private final Context applicationContext;

    /* renamed from: camera, reason: collision with root package name */
    private final Camera f423840camera;
    private final int cameraId;
    private final Handler cameraThreadHandler;
    private final CameraEnumerationAndroid.CaptureFormat captureFormat;
    private final boolean captureToTexture;
    private final long constructionTimeNs;
    private final CameraSession.Events events;
    private boolean firstFrameReported;
    private final Camera.CameraInfo info;
    private SessionState state;
    private final SurfaceTextureHelper surfaceTextureHelper;
    private static final Histogram camera1StartTimeMsHistogram = Histogram.createCounts("WebRTC.Android.Camera1.StartTimeMs", 1, 10000, 50);
    private static final Histogram camera1StopTimeMsHistogram = Histogram.createCounts("WebRTC.Android.Camera1.StopTimeMs", 1, 10000, 50);
    private static final Histogram camera1ResolutionHistogram = Histogram.createEnumeration("WebRTC.Android.Camera1.Resolution", CameraEnumerationAndroid.COMMON_RESOLUTIONS.size());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: org.tencwebrtc.Camera1Session$2, reason: invalid class name */
    /* loaded from: classes29.dex */
    public class AnonymousClass2 implements Camera.PreviewCallback {
        AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPreviewFrame$0(byte[] bArr) {
            if (Camera1Session.this.state == SessionState.RUNNING) {
                Camera1Session.this.f423840camera.addCallbackBuffer(bArr);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPreviewFrame$1(final byte[] bArr) {
            Camera1Session.this.cameraThreadHandler.post(new Runnable() { // from class: org.tencwebrtc.b
                @Override // java.lang.Runnable
                public final void run() {
                    Camera1Session.AnonymousClass2.this.lambda$onPreviewFrame$0(bArr);
                }
            });
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(final byte[] bArr, Camera camera2) {
            Camera1Session.this.checkIsOnCameraThread();
            if (camera2 != Camera1Session.this.f423840camera) {
                Logging.e(Camera1Session.TAG, "Callback from a different camera. This should never happen.");
                return;
            }
            if (Camera1Session.this.state != SessionState.RUNNING) {
                Logging.d(Camera1Session.TAG, "Bytebuffer frame captured but camera is no longer running.");
                return;
            }
            long nanos = TimeUnit.MILLISECONDS.toNanos(SystemClock.elapsedRealtime());
            if (!Camera1Session.this.firstFrameReported) {
                Camera1Session.camera1StartTimeMsHistogram.addSample((int) TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - Camera1Session.this.constructionTimeNs));
                Camera1Session.this.firstFrameReported = true;
            }
            VideoFrame videoFrame = new VideoFrame(new NV21Buffer(bArr, Camera1Session.this.captureFormat.width, Camera1Session.this.captureFormat.height, new Runnable() { // from class: org.tencwebrtc.c
                @Override // java.lang.Runnable
                public final void run() {
                    Camera1Session.AnonymousClass2.this.lambda$onPreviewFrame$1(bArr);
                }
            }), Camera1Session.this.getFrameOrientation(), nanos);
            Camera1Session.this.events.onFrameCaptured(Camera1Session.this, videoFrame);
            videoFrame.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum SessionState {
        RUNNING,
        STOPPED
    }

    Camera1Session(CameraSession.Events events, boolean z16, Context context, SurfaceTextureHelper surfaceTextureHelper, int i3, Camera camera2, Camera.CameraInfo cameraInfo, CameraEnumerationAndroid.CaptureFormat captureFormat, long j3) {
        Logging.d(TAG, "Create new camera1 session on camera " + i3);
        this.cameraThreadHandler = new Handler();
        this.events = events;
        this.captureToTexture = z16;
        this.applicationContext = context;
        this.surfaceTextureHelper = surfaceTextureHelper;
        this.cameraId = i3;
        this.f423840camera = camera2;
        this.info = cameraInfo;
        this.captureFormat = captureFormat;
        this.constructionTimeNs = j3;
        surfaceTextureHelper.setTextureSize(captureFormat.width, captureFormat.height);
        startCapturing();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkIsOnCameraThread() {
        if (Thread.currentThread() == this.cameraThreadHandler.getLooper().getThread()) {
        } else {
            throw new IllegalStateException("Wrong thread");
        }
    }

    public static void create(CameraSession.CreateSessionCallback createSessionCallback, CameraSession.Events events, boolean z16, Context context, SurfaceTextureHelper surfaceTextureHelper, int i3, int i16, int i17, int i18) {
        long nanoTime = System.nanoTime();
        Logging.d(TAG, "Open camera " + i3);
        events.onCameraOpening();
        try {
            Camera open = CameraMonitor.open(i3);
            if (open == null) {
                createSessionCallback.onFailure(CameraSession.FailureType.ERROR, "android.hardware.Camera.open returned null for camera id = " + i3);
                return;
            }
            try {
                open.setPreviewTexture(surfaceTextureHelper.getSurfaceTexture());
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i3, cameraInfo);
                try {
                    Camera.Parameters parameters = open.getParameters();
                    CameraEnumerationAndroid.CaptureFormat findClosestCaptureFormat = findClosestCaptureFormat(parameters, i16, i17, i18);
                    updateCameraParameters(open, parameters, findClosestCaptureFormat, findClosestPictureSize(parameters, i16, i17), z16);
                    if (!z16) {
                        int frameSize = findClosestCaptureFormat.frameSize();
                        for (int i19 = 0; i19 < 3; i19++) {
                            open.addCallbackBuffer(ByteBuffer.allocateDirect(frameSize).array());
                        }
                    }
                    open.setDisplayOrientation(0);
                    createSessionCallback.onDone(new Camera1Session(events, z16, context, surfaceTextureHelper, i3, open, cameraInfo, findClosestCaptureFormat, nanoTime));
                } catch (RuntimeException e16) {
                    open.release();
                    createSessionCallback.onFailure(CameraSession.FailureType.ERROR, e16.getMessage());
                }
            } catch (IOException | RuntimeException e17) {
                open.release();
                createSessionCallback.onFailure(CameraSession.FailureType.ERROR, e17.getMessage());
            }
        } catch (RuntimeException e18) {
            createSessionCallback.onFailure(CameraSession.FailureType.ERROR, e18.getMessage());
        }
    }

    private static CameraEnumerationAndroid.CaptureFormat findClosestCaptureFormat(Camera.Parameters parameters, int i3, int i16, int i17) {
        List<CameraEnumerationAndroid.CaptureFormat.FramerateRange> convertFramerates = Camera1Enumerator.convertFramerates(parameters.getSupportedPreviewFpsRange());
        Logging.d(TAG, "Available fps ranges: " + convertFramerates);
        CameraEnumerationAndroid.CaptureFormat.FramerateRange closestSupportedFramerateRange = CameraEnumerationAndroid.getClosestSupportedFramerateRange(convertFramerates, i17);
        Size closestSupportedSize = CameraEnumerationAndroid.getClosestSupportedSize(Camera1Enumerator.convertSizes(parameters.getSupportedPreviewSizes()), i3, i16);
        CameraEnumerationAndroid.reportCameraResolution(camera1ResolutionHistogram, closestSupportedSize);
        return new CameraEnumerationAndroid.CaptureFormat(closestSupportedSize.width, closestSupportedSize.height, closestSupportedFramerateRange);
    }

    private static Size findClosestPictureSize(Camera.Parameters parameters, int i3, int i16) {
        return CameraEnumerationAndroid.getClosestSupportedSize(Camera1Enumerator.convertSizes(parameters.getSupportedPictureSizes()), i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getFrameOrientation() {
        int b16 = e.b(this.applicationContext);
        Camera.CameraInfo cameraInfo = this.info;
        if (cameraInfo.facing == 0) {
            b16 = 360 - b16;
        }
        return (cameraInfo.orientation + b16) % 360;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$listenForTextureFrames$0(VideoFrame videoFrame) {
        checkIsOnCameraThread();
        if (this.state != SessionState.RUNNING) {
            Logging.d(TAG, "Texture frame captured but camera is no longer running.");
            return;
        }
        boolean z16 = true;
        if (!this.firstFrameReported) {
            camera1StartTimeMsHistogram.addSample((int) TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.constructionTimeNs));
            this.firstFrameReported = true;
        }
        TextureBufferImpl textureBufferImpl = (TextureBufferImpl) videoFrame.getBuffer();
        if (this.info.facing != 1) {
            z16 = false;
        }
        VideoFrame videoFrame2 = new VideoFrame(e.a(textureBufferImpl, z16, 0), getFrameOrientation(), videoFrame.getTimestampNs());
        this.events.onFrameCaptured(this, videoFrame2);
        videoFrame2.release();
    }

    private void listenForBytebufferFrames() {
        this.f423840camera.setPreviewCallbackWithBuffer(new AnonymousClass2());
    }

    private void listenForTextureFrames() {
        this.surfaceTextureHelper.startListening(new VideoSink() { // from class: org.tencwebrtc.a
            @Override // org.tencwebrtc.VideoSink
            public final void onFrame(VideoFrame videoFrame) {
                Camera1Session.this.lambda$listenForTextureFrames$0(videoFrame);
            }
        });
    }

    private void startCapturing() {
        Logging.d(TAG, "Start capturing");
        checkIsOnCameraThread();
        this.state = SessionState.RUNNING;
        this.f423840camera.setErrorCallback(new Camera.ErrorCallback() { // from class: org.tencwebrtc.Camera1Session.1
            @Override // android.hardware.Camera.ErrorCallback
            public void onError(int i3, Camera camera2) {
                String str;
                if (i3 == 100) {
                    str = "Camera server died!";
                } else {
                    str = "Camera error: " + i3;
                }
                Logging.e(Camera1Session.TAG, str);
                Camera1Session.this.stopInternal();
                if (i3 == 2) {
                    Camera1Session.this.events.onCameraDisconnected(Camera1Session.this);
                } else {
                    Camera1Session.this.events.onCameraError(Camera1Session.this, str);
                }
            }
        });
        if (this.captureToTexture) {
            listenForTextureFrames();
        } else {
            listenForBytebufferFrames();
        }
        try {
            this.f423840camera.startPreview();
        } catch (RuntimeException e16) {
            stopInternal();
            this.events.onCameraError(this, e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopInternal() {
        Logging.d(TAG, "Stop internal");
        checkIsOnCameraThread();
        SessionState sessionState = this.state;
        SessionState sessionState2 = SessionState.STOPPED;
        if (sessionState == sessionState2) {
            Logging.d(TAG, "Camera is already stopped");
            return;
        }
        this.state = sessionState2;
        this.surfaceTextureHelper.stopListening();
        this.f423840camera.stopPreview();
        this.f423840camera.release();
        this.events.onCameraClosed(this);
        Logging.d(TAG, "Stop done");
    }

    private static void updateCameraParameters(Camera camera2, Camera.Parameters parameters, CameraEnumerationAndroid.CaptureFormat captureFormat, Size size, boolean z16) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        CameraEnumerationAndroid.CaptureFormat.FramerateRange framerateRange = captureFormat.framerate;
        parameters.setPreviewFpsRange(framerateRange.min, framerateRange.max);
        parameters.setPreviewSize(captureFormat.width, captureFormat.height);
        parameters.setPictureSize(size.width, size.height);
        if (!z16) {
            parameters.setPreviewFormat(17);
        }
        if (parameters.isVideoStabilizationSupported()) {
            parameters.setVideoStabilization(true);
        }
        if (supportedFocusModes.contains("continuous-video")) {
            parameters.setFocusMode("continuous-video");
        }
        camera2.setParameters(parameters);
    }

    @Override // org.tencwebrtc.CameraSession
    public void stop() {
        Logging.d(TAG, "Stop camera1 session on camera " + this.cameraId);
        checkIsOnCameraThread();
        if (this.state != SessionState.STOPPED) {
            long nanoTime = System.nanoTime();
            stopInternal();
            camera1StopTimeMsHistogram.addSample((int) TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime));
        }
    }
}
