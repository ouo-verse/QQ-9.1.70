package com.tencent.qqmini.miniapp.widget.camera;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.hardware.Camera;
import android.media.MediaRecorder;
import android.media.ThumbnailUtils;
import android.os.Build;
import android.os.Looper;
import android.view.ViewGroup;
import com.tencent.hippy.qq.adapter.image.HippyImageInfo;
import com.tencent.luggage.wxa.n1.a;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qmethod.pandoraex.monitor.AudioMonitor;
import com.tencent.qmethod.pandoraex.monitor.CameraMonitor;
import com.tencent.qqmini.miniapp.util.CameraCompatibleList;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.ImageUtil;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.DeviceInfoUtil;
import com.tencent.qqmini.sdk.widget.ToastView;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes23.dex */
public class MiniAppCamera extends GlCameraHolderSurfaceView {
    public static final String DEVICE_POSITION_BACK = "back";
    public static final String DEVICE_POSITION_FRONT = "front";
    private static final String TAG = "MiniAppCamera";
    private static volatile boolean isRecordStart;
    private static int recordCallBackId;
    private static MediaRecorder recorder;
    private static WeakReference<IJsService> sRecordJsService;
    private static String videoPath;
    private int cameraId;
    private CameraCallBack mCallback;
    protected WeakReference<IJsService> mJsService;
    private WeakReference<IMiniAppContext> mMiniAppContext;
    private int mWebviewId;
    private ToastView toastView;
    private static final ExecutorService mExecutor = ProxyExecutors.newSingleThreadExecutor();
    public static int cameraWidth = 320;
    public static int cameraHeight = 240;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface GetPhotoCallback {
        void onGetPhoto(String str);
    }

    public MiniAppCamera(IMiniAppContext iMiniAppContext, IJsService iJsService) {
        super(iMiniAppContext.getContext());
        this.mMiniAppContext = new WeakReference<>(iMiniAppContext);
        this.mJsService = new WeakReference<>(iJsService);
        QMLog.i(TAG, "MiniAppCamera: " + Build.BRAND + " " + DeviceInfoUtil.getPhoneModel());
    }

    private void execCommand(String str, final String str2, final String str3, final RequestEvent requestEvent) {
        showLoading("\u6b63\u5728\u5904\u7406");
        final String[] split = str.split(" ");
        mExecutor.execute(new Runnable() { // from class: com.tencent.qqmini.miniapp.widget.camera.MiniAppCamera.7
            @Override // java.lang.Runnable
            public void run() {
                new File(str2).deleteOnExit();
                try {
                    LockMethodProxy.sleep(50L);
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                    QMLog.e(MiniAppCamera.TAG, "execCommand: ", e16);
                }
                QMLog.i(MiniAppCamera.TAG, "execCommand start ");
                try {
                    ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
                    if (channelProxy != null) {
                        channelProxy.ffmpegExecCommand(split, new ChannelProxy.ICommandListenr() { // from class: com.tencent.qqmini.miniapp.widget.camera.MiniAppCamera.7.1
                            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy.ICommandListenr
                            public void onFailure(String str4) {
                                QMLog.i(MiniAppCamera.TAG, "compress failed " + str4);
                                AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                                MiniAppCamera.this.reportRecordAns(str3, requestEvent);
                            }

                            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy.ICommandListenr
                            public void onFinish(boolean z16) {
                                QMLog.i(MiniAppCamera.TAG, "compress finish " + z16);
                                MiniAppCamera.this.hideLoading();
                            }

                            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy.ICommandListenr
                            public void onProgress(String str4) {
                                QMLog.i(MiniAppCamera.TAG, "compress progress " + str4);
                            }

                            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy.ICommandListenr
                            public void onStart() {
                                QMLog.i(MiniAppCamera.TAG, "compress start");
                            }

                            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy.ICommandListenr
                            public void onSuccess(String str4) {
                                QMLog.i(MiniAppCamera.TAG, "compress success " + str4);
                                AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                                MiniAppCamera.this.reportRecordAns(str2, requestEvent);
                            }
                        });
                    }
                } catch (Exception e17) {
                    QMLog.e(MiniAppCamera.TAG, "run: ", e17);
                    MiniAppCamera.this.reportRecordAns(str3, requestEvent);
                    MiniAppCamera.this.hideLoading();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getDegrees() {
        if (CameraCompatibleList.isFoundProduct(CameraCompatibleList.KEY_PREVIEW_ORIENTATION_270_OF_BACK_MODEL)) {
            if (!this.isBackCameraNow) {
                return 90.0f;
            }
        } else if (this.isBackCameraNow) {
            return 90.0f;
        }
        return 270.0f;
    }

    private static Bitmap getFirstKeyFrame(String str) {
        return ThumbnailUtils.createVideoThumbnail(str, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getQuScale(String str) {
        if ("normal".equals(str)) {
            return 0.8f;
        }
        if (HippyImageInfo.QUALITY_LOW.equals(str)) {
            return 0.6f;
        }
        return 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoading() {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.widget.camera.MiniAppCamera.9
            @Override // java.lang.Runnable
            public void run() {
                if (MiniAppCamera.this.toastView != null) {
                    MiniAppCamera.this.toastView.hide();
                    MiniAppCamera.this.toastView.onViewDestroy();
                    MiniAppCamera.this.toastView = null;
                }
            }
        });
    }

    private boolean isMainThread() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return true;
        }
        return false;
    }

    private void nativeStartRecord() throws IOException, IllegalStateException {
        int i3;
        if (recorder == null) {
            return;
        }
        String tmpPath = getTmpPath("mp4");
        videoPath = tmpPath;
        if (tmpPath == null) {
            return;
        }
        QMLog.i(TAG, "nativeStartRecord: " + videoPath);
        try {
            this.f346338camera.unlock();
        } catch (Exception e16) {
            QMLog.e(TAG, "nativeStartRecord: ", e16);
        }
        MediaRecorder mediaRecorder = recorder;
        if (this.isBackCameraNow) {
            i3 = 90;
        } else {
            i3 = 270;
        }
        mediaRecorder.setOrientationHint(i3);
        try {
            recorder.reset();
        } catch (IllegalStateException e17) {
            QMLog.e(TAG, "nativeStartRecord: ", e17);
        }
        recorder.setCamera(this.f346338camera);
        AudioMonitor.setAudioSource(recorder, 0);
        CameraMonitor.setVideoSource(recorder, 1);
        recorder.setOutputFormat(2);
        recorder.setVideoEncoder(2);
        recorder.setAudioEncoder(3);
        Camera.Size size = this.cameraSize;
        if (size != null) {
            recorder.setVideoSize(size.width, size.height);
        }
        recorder.setVideoEncodingBitRate(5242880);
        recorder.setOutputFile(videoPath);
        recorder.prepare();
        AudioMonitor.start(recorder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nativeStopRecord() {
        MediaRecorder mediaRecorder = recorder;
        if (mediaRecorder == null) {
            return;
        }
        try {
            mediaRecorder.stop();
        } catch (IllegalStateException e16) {
            QMLog.e(TAG, "nativeStopRecord: failed to stop", e16);
        }
        try {
            recorder.reset();
            recorder.release();
        } catch (IllegalStateException e17) {
            QMLog.e(TAG, "stopRecord: ", e17);
        }
        try {
            this.f346338camera.unlock();
        } catch (Exception e18) {
            QMLog.e(TAG, "stopRecord: ", e18);
        }
        try {
            this.f346338camera.reconnect();
        } catch (Exception e19) {
            QMLog.e(TAG, "stopRecord: ", e19);
        }
    }

    private void nativeTakePhoto(final String str, final boolean z16, final GetPhotoCallback getPhotoCallback) {
        if (getPhotoCallback == null) {
            return;
        }
        QMLog.i(TAG, "nativeTakePhoto: ");
        try {
            CameraMonitor.takePicture(this.f346338camera, null, null, new Camera.PictureCallback() { // from class: com.tencent.qqmini.miniapp.widget.camera.MiniAppCamera.2
                @Override // android.hardware.Camera.PictureCallback
                public void onPictureTaken(byte[] bArr, Camera camera2) {
                    QMLog.i(MiniAppCamera.TAG, "onPictureTaken: ");
                    try {
                        camera2.reconnect();
                    } catch (Exception e16) {
                        QMLog.e(MiniAppCamera.TAG, "onPictureTaken: ", e16);
                    }
                    camera2.startPreview();
                    MiniAppCamera.this.postProcessPhoto(bArr, z16, str, getPhotoCallback);
                }
            });
        } catch (Exception e16) {
            QMLog.e(TAG, "nativeTakePhoto: ", e16);
            getPhotoCallback.onGetPhoto(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postProcessPhoto(final byte[] bArr, final boolean z16, final String str, final GetPhotoCallback getPhotoCallback) {
        ThreadManager.executeOnDiskIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.miniapp.widget.camera.MiniAppCamera.3
            @Override // java.lang.Runnable
            public void run() {
                float f16;
                float f17;
                QMLog.i(MiniAppCamera.TAG, "run: onPictureTaken");
                try {
                    long j3 = Runtime.getRuntime().totalMemory() / 1024;
                    long maxMemory = Runtime.getRuntime().maxMemory() / 1024;
                    long freeMemory = Runtime.getRuntime().freeMemory() / 1024;
                    long j16 = maxMemory - (j3 - freeMemory);
                    QMLog.d(MiniAppCamera.TAG, "remain= " + j16 + ",totalMemory=" + j3 + ",maxMemory=" + maxMemory + ",freeMemory" + freeMemory);
                    if (j16 < 51200) {
                        System.gc();
                    }
                    byte[] bArr2 = bArr;
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length);
                    int width = decodeByteArray.getWidth();
                    int height = decodeByteArray.getHeight();
                    Matrix matrix = new Matrix();
                    float degrees = MiniAppCamera.this.getDegrees();
                    QMLog.i(MiniAppCamera.TAG, "run: " + MiniAppCamera.this.getWidth() + ":" + MiniAppCamera.this.getHeight());
                    float f18 = 0.0f;
                    if (z16) {
                        float f19 = width;
                        float f26 = height;
                        f17 = Math.max(MiniAppCamera.this.getHeight() / f19, MiniAppCamera.this.getWidth() / f26);
                        float height2 = (MiniAppCamera.this.getHeight() - (f19 * f17)) / f17;
                        float width2 = (MiniAppCamera.this.getWidth() - (f26 * f17)) / f17;
                        if (height2 > 0.0f) {
                            height2 = 0.0f;
                        }
                        if (width2 <= 0.0f) {
                            f18 = width2;
                        }
                        f16 = f18;
                        f18 = height2;
                    } else {
                        f16 = 0.0f;
                        f17 = 1.0f;
                    }
                    matrix.postRotate(degrees);
                    matrix.postScale(f17, f17);
                    if (!MiniAppCamera.this.isBackCameraNow) {
                        matrix.postScale(-1.0f, 1.0f);
                    }
                    Bitmap createBitmap = Bitmap.createBitmap(decodeByteArray, (int) ((-f18) / 2.0f), (int) ((-f16) / 2.0f), (int) (decodeByteArray.getWidth() + f18), (int) (decodeByteArray.getHeight() + f16), matrix, true);
                    float quScale = MiniAppCamera.this.getQuScale(str);
                    if (quScale < 1.0f) {
                        Matrix matrix2 = new Matrix();
                        matrix2.postScale(quScale, quScale);
                        createBitmap = Bitmap.createBitmap(createBitmap, 0, 0, createBitmap.getWidth(), createBitmap.getHeight(), matrix2, true);
                    }
                    File file = new File(MiniAppCamera.this.getTmpPath("jpg"));
                    file.getParentFile().mkdirs();
                    String saveJpeg = MiniAppCamera.saveJpeg(createBitmap, file, str);
                    QMLog.i(MiniAppCamera.TAG, "run: return");
                    getPhotoCallback.onGetPhoto(saveJpeg);
                } catch (Exception e16) {
                    QMLog.e(MiniAppCamera.TAG, "run: nativeTakePhoto ", e16);
                    getPhotoCallback.onGetPhoto(null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportRecordAns(final String str, final RequestEvent requestEvent) {
        QMLog.i(TAG, "reportRecordAns: " + str);
        ThreadManager.executeOnComputationThreadPool(new Runnable() { // from class: com.tencent.qqmini.miniapp.widget.camera.MiniAppCamera.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String saveVideoThumbImg = MiniAppCamera.this.saveVideoThumbImg(str);
                    if (StringUtil.isEmpty(saveVideoThumbImg)) {
                        QMLog.i(MiniAppCamera.TAG, "run: null video thumb path");
                        requestEvent.fail();
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("tempThumbPath", MiniAppCamera.this.getWxFilePath(saveVideoThumbImg));
                    jSONObject.put("tempVideoPath", MiniAppCamera.this.getWxFilePath(str));
                    RequestEvent requestEvent2 = requestEvent;
                    requestEvent2.jsService.evaluateCallbackJs(requestEvent2.callbackId, jSONObject.toString());
                } catch (Exception e16) {
                    QMLog.e(MiniAppCamera.TAG, "run: failed to stop record", e16);
                    requestEvent.fail();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String saveJpeg(Bitmap bitmap, File file, String str) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        int i3;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            if ("normal".equals(str)) {
                i3 = 80;
            } else if (HippyImageInfo.QUALITY_LOW.equals(str)) {
                i3 = 60;
            } else {
                i3 = 100;
            }
            bitmap.compress(Bitmap.CompressFormat.JPEG, Math.min(100, i3), bufferedOutputStream);
            bufferedOutputStream.flush();
            String compressImageJpg = ImageUtil.compressImageJpg(file.getAbsolutePath(), file.getAbsolutePath(), cameraWidth, cameraHeight, i3);
            try {
                bufferedOutputStream.close();
            } catch (Exception e16) {
                QMLog.e(TAG, "saveJpeg", e16);
            }
            return compressImageJpg;
        } catch (Throwable th6) {
            th = th6;
            bufferedOutputStream2 = bufferedOutputStream;
            if (bufferedOutputStream2 != null) {
                try {
                    bufferedOutputStream2.close();
                } catch (Exception e17) {
                    QMLog.e(TAG, "saveJpeg", e17);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String saveVideoThumbImg(String str) throws IOException {
        File file = new File(str);
        if (file.length() == 0) {
            return null;
        }
        QMLog.i(TAG, "saveVideoThumbImg: " + file.length());
        String tmpPath = getTmpPath("jpg");
        Bitmap firstKeyFrame = getFirstKeyFrame(file.getAbsolutePath());
        if (firstKeyFrame == null) {
            return null;
        }
        saveJpeg(firstKeyFrame, new File(tmpPath), "");
        QMLog.i(TAG, "saveVideoThumbImg: " + tmpPath);
        return tmpPath;
    }

    private void setupCamera(String str) {
        Integer num;
        Integer num2;
        if ("front".equals(str) && (num2 = this.frontCameraId) != null) {
            setupCamera(num2.intValue());
            return;
        }
        if ("back".equals(str) && (num = this.backCameraId) != null) {
            setupCamera(num.intValue());
            return;
        }
        Integer num3 = this.backCameraId;
        if (num3 == null) {
            num3 = this.frontCameraId;
        }
        setupCamera(num3.intValue());
    }

    private void showLoading(final String str) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.widget.camera.MiniAppCamera.8
            @Override // java.lang.Runnable
            public void run() {
                Activity activity;
                if (MiniAppCamera.this.mMiniAppContext != null) {
                    activity = ((IMiniAppContext) MiniAppCamera.this.mMiniAppContext.get()).getAttachActivity();
                } else {
                    activity = null;
                }
                if (activity != null && !activity.isFinishing()) {
                    if (MiniAppCamera.this.toastView == null) {
                        MiniAppCamera.this.toastView = new ToastView(activity, (ViewGroup) activity.findViewById(R.id.content));
                        MiniAppCamera.this.toastView.show(1, ToastView.ICON_LOADING, null, str, -1, false);
                        return;
                    }
                    return;
                }
                QMLog.w(MiniAppCamera.TAG, "showLoading(). Do nothing, activity is null or finishing");
            }
        });
    }

    private void startCrop(String str, RequestEvent requestEvent) {
        int i3;
        String tmpPath = getTmpPath("mp4");
        int width = getWidth();
        int height = getHeight();
        Camera.Size size = this.cameraSize;
        int i16 = size.height;
        int i17 = size.width;
        int i18 = i16 * height;
        int i19 = 0;
        if (i17 * width > i18) {
            int i26 = i18 / width;
            i3 = (i17 - i26) / 2;
            i17 = i26;
        } else {
            int i27 = (i17 / height) * width;
            i3 = 0;
            i19 = (i16 - i27) / 2;
            i16 = i27;
        }
        QMLog.i(TAG, "startCrop: " + str);
        execCommand("-y -i " + str + " -strict -2 -vcodec libx264 -preset ultrafast -vf crop=" + i16 + ":" + i17 + ":" + i19 + ":" + i3 + " " + tmpPath, tmpPath, str, requestEvent);
    }

    public void closeCamera() {
        MediaRecorder mediaRecorder = recorder;
        if (mediaRecorder != null) {
            try {
                mediaRecorder.stop();
            } catch (IllegalStateException e16) {
                QMLog.e(TAG, "nativeStopRecord: failed to stop", e16);
            } catch (RuntimeException e17) {
                QMLog.e(TAG, "closeCamera: failed to stop", e17);
            }
            try {
                recorder.reset();
                recorder.release();
            } catch (IllegalStateException e18) {
                QMLog.e(TAG, "closeCamera: failed to stop", e18);
            }
            recorder = null;
        }
        stopPreview();
        releaseCamera();
    }

    public String getTmpPath(String str) {
        IMiniAppContext iMiniAppContext = this.mMiniAppContext.get();
        if (iMiniAppContext != null) {
            return ((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getTmpPath(str);
        }
        return "";
    }

    public String getWxFilePath(String str) {
        IMiniAppContext iMiniAppContext = this.mMiniAppContext.get();
        if (iMiniAppContext != null) {
            return ((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getWxFilePath(str);
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqmini.miniapp.widget.camera.GlCameraHolderSurfaceView
    public void onCodeRead(String str) {
        IJsService iJsService;
        super.onCodeRead(str);
        if (!this.isScanMode || (iJsService = this.mJsService.get()) == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", str);
            jSONObject.put("type", "barcode");
            jSONObject.put("cameraId", this.cameraId);
            iJsService.evaluateSubscribeJS(a.NAME, jSONObject.toString(), this.mWebviewId);
            QMLog.i(TAG, "onCodeRead, result = " + jSONObject + ", webviewId = " + this.mWebviewId);
        } catch (JSONException e16) {
            QMLog.e(TAG, "onCodeRead: ", e16);
        }
    }

    public void openCamera(String str) {
        if (this.frontCameraId == null && this.backCameraId == null) {
            CameraCallBack cameraCallBack = this.mCallback;
            if (cameraCallBack != null) {
                cameraCallBack.onStartPreview(false);
                return;
            }
            return;
        }
        try {
            setupCamera(str);
            setCameraSize(this.cameraSize);
            startPreview();
            CameraCallBack cameraCallBack2 = this.mCallback;
            if (cameraCallBack2 != null) {
                cameraCallBack2.onStartPreview(true);
            }
        } catch (Exception e16) {
            QMLog.e(TAG, "openCamera: ", e16);
            CameraCallBack cameraCallBack3 = this.mCallback;
            if (cameraCallBack3 != null) {
                cameraCallBack3.onStartPreview(false);
            }
        }
    }

    public void setCameraId(int i3) {
        this.cameraId = i3;
    }

    public void setCameraSurfaceCallBack(CameraCallBack cameraCallBack) {
        this.mCallback = cameraCallBack;
    }

    public void setWebviewId(int i3) {
        this.mWebviewId = i3;
    }

    @Override // com.tencent.qqmini.miniapp.widget.camera.GlCameraHolderSurfaceView
    public void startPreview() {
        super.startPreview();
    }

    public void startRecord(final RequestEvent requestEvent) {
        if (isRecordStart) {
            return;
        }
        isRecordStart = true;
        sRecordJsService = new WeakReference<>(requestEvent.jsService);
        recordCallBackId = requestEvent.callbackId;
        MediaRecorder mediaRecorder = new MediaRecorder();
        recorder = mediaRecorder;
        mediaRecorder.setOnErrorListener(new MediaRecorder.OnErrorListener() { // from class: com.tencent.qqmini.miniapp.widget.camera.MiniAppCamera.4
            @Override // android.media.MediaRecorder.OnErrorListener
            public void onError(MediaRecorder mediaRecorder2, int i3, int i16) {
                QMLog.e(MiniAppCamera.TAG, "onError: " + i3);
                requestEvent.fail();
                MiniAppCamera.this.nativeStopRecord();
            }
        });
        recorder.setOnInfoListener(new MediaRecorder.OnInfoListener() { // from class: com.tencent.qqmini.miniapp.widget.camera.MiniAppCamera.5
            @Override // android.media.MediaRecorder.OnInfoListener
            public void onInfo(MediaRecorder mediaRecorder2, int i3, int i16) {
                QMLog.i(MiniAppCamera.TAG, "setOnInfoListener|reson: " + i3);
                if (i3 == 800) {
                    MiniAppCamera.this.stopRecord(requestEvent);
                }
            }
        });
        try {
            nativeStartRecord();
        } catch (Exception e16) {
            QMLog.e(TAG, "startRecord: ", e16);
            requestEvent.fail();
            isRecordStart = false;
            try {
                recorder.reset();
                recorder.release();
            } catch (Exception unused) {
                QMLog.e(TAG, "startRecord: ", e16);
            }
            recorder = null;
        }
    }

    public void stopPreview(boolean z16) {
        String str;
        QMLog.i(TAG, "stopPreview: ");
        if (isRecordStart) {
            isRecordStart = false;
            IJsService iJsService = sRecordJsService.get();
            if (iJsService != null) {
                JSONObject wrapCallbackFail = ApiUtil.wrapCallbackFail("operateCamera", null);
                if (wrapCallbackFail != null) {
                    str = wrapCallbackFail.toString();
                } else {
                    str = "";
                }
                iJsService.evaluateCallbackJs(recordCallBackId, str);
            }
            sRecordJsService.clear();
            nativeStopRecord();
        }
        stopPreview();
        if (z16) {
            releaseCamera();
        }
    }

    public void stopRecord(RequestEvent requestEvent) {
        QMLog.i(TAG, "stopRecord: " + isRecordStart + " " + isMainThread());
        if (!isRecordStart) {
            return;
        }
        isRecordStart = false;
        nativeStopRecord();
        if (this.cameraSize.width * getWidth() == this.cameraSize.height * getHeight()) {
            reportRecordAns(videoPath, requestEvent);
        } else {
            startCrop(videoPath, requestEvent);
        }
    }

    public void switchCamera(final boolean z16, String str) {
        QMLog.i(TAG, "switchCamera: ");
        setFlashMode(str);
        if (this.frontCameraId != null && this.backCameraId != null && z16 != this.isBackCameraNow) {
            ThreadManager.executeOnComputationThreadPool(new Runnable() { // from class: com.tencent.qqmini.miniapp.widget.camera.MiniAppCamera.10
                @Override // java.lang.Runnable
                public void run() {
                    Integer num;
                    MiniAppCamera.this.stopPreview(true);
                    MiniAppCamera miniAppCamera = MiniAppCamera.this;
                    if (z16) {
                        num = miniAppCamera.backCameraId;
                    } else {
                        num = miniAppCamera.frontCameraId;
                    }
                    miniAppCamera.setupCamera(num.intValue());
                    MiniAppCamera miniAppCamera2 = MiniAppCamera.this;
                    miniAppCamera2.onCameraSurfaceCreate(((GlCameraHolderSurfaceView) miniAppCamera2).mPreviewSt);
                    MiniAppCamera miniAppCamera3 = MiniAppCamera.this;
                    miniAppCamera3.setCameraSize(miniAppCamera3.cameraSize);
                    MiniAppCamera.this.f346338camera.startPreview();
                }
            });
        } else {
            updateFlashMode();
        }
    }

    public void takePhoto(final RequestEvent requestEvent, String str) {
        nativeTakePhoto(str, true, new GetPhotoCallback() { // from class: com.tencent.qqmini.miniapp.widget.camera.MiniAppCamera.1
            @Override // com.tencent.qqmini.miniapp.widget.camera.MiniAppCamera.GetPhotoCallback
            public void onGetPhoto(String str2) {
                if (StringUtil.isEmpty(str2)) {
                    requestEvent.fail();
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("tempImagePath", MiniAppCamera.this.getWxFilePath(str2));
                    RequestEvent requestEvent2 = requestEvent;
                    requestEvent2.jsService.evaluateCallbackJs(requestEvent2.callbackId, jSONObject.toString());
                } catch (JSONException e16) {
                    e16.printStackTrace();
                    QMLog.e(MiniAppCamera.TAG, "takePhoto", e16);
                }
            }
        });
    }
}
