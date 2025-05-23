package com.tencent.could.aicamare;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.WindowManager;
import com.tencent.could.aicamare.callback.CameraEventListener;
import com.tencent.could.aicamare.callback.CameraLoggerCallBack;
import com.tencent.could.aicamare.entity.CameraConfig;
import com.tencent.could.aicamare.enums.CameraZoom;
import com.tencent.could.aicamare.util.CameraLogger;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.CameraMonitor;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CameraHolder {
    static IPatchRedirector $redirector_ = null;
    private static final int EVENT_AUTO_FOCUS_CAMERA = 3;
    private static final int EVENT_CHANGE_CAMERA_PARAMETER = 8;
    private static final int EVENT_CHANGE_ZOOM = 4;
    private static final int EVENT_CLOSE_CAMERA = 2;
    private static final int EVENT_LIFE_CYCLE_START_PREVIEW = 6;
    private static final int EVENT_LIFE_CYCLE_STOP_PREVIEW = 7;
    private static final int EVENT_OPEN_CAMERA = 1;
    private static final int EVENT_START_PREVIEW = 5;
    public static final String PARAMETER_EXPOSURE_COMPENSATION = "camera_param_exposure";
    public static final String PARAMETER_WHITE_BALANCE = "camera_param_white_balance";
    public static final String PARAMETER_ZOOM_VALUE = "camera_param_zoom";
    private static final String TAG = "CameraHolder";
    private CameraConfig cameraConfig;
    private d cameraHolderImp;
    private CameraEventListener eventListener;
    private volatile Handler handler;
    private HandlerThread handlerThread;
    private volatile boolean isUseSurfaceHolder;
    private CameraLoggerCallBack loggerCallBack;
    private float oldDist;
    private SurfaceHolder surfaceHolder;
    private SurfaceTexture surfaceTexture;
    private Matrix transformMatrix;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a extends Handler {
        static IPatchRedirector $redirector_;

        public a(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CameraHolder.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            boolean z16 = false;
            switch (message.what) {
                case 1:
                    CameraHolder.this.doOpenCamera();
                    return;
                case 2:
                    CameraHolder.this.doCloseCamera();
                    return;
                case 3:
                    if (message.arg1 == 1) {
                        z16 = true;
                    }
                    CameraHolder.this.doAutoFocus(z16);
                    return;
                case 4:
                    if (message.arg1 == 1) {
                        z16 = true;
                    }
                    CameraHolder.this.doChangeZoom(z16);
                    return;
                case 5:
                    CameraHolder.this.doStartPreview();
                    return;
                case 6:
                    CameraHolder.this.doLifeResume();
                    return;
                case 7:
                    CameraHolder.this.doLifeOnPause();
                    return;
                case 8:
                    try {
                        CameraHolder.this.doEventChangeCameraParameter((Map) message.obj);
                        return;
                    } catch (Exception e16) {
                        CameraLogger.a(CameraHolder.TAG, "doEventChangeCameraParameter error " + e16.getLocalizedMessage(), CameraHolder.this.loggerCallBack);
                        return;
                    }
                default:
                    Log.d(CameraHolder.TAG, "default case");
                    return;
            }
        }
    }

    public CameraHolder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.isUseSurfaceHolder = true;
        this.oldDist = 1.0f;
        this.cameraConfig = new CameraConfig();
        this.cameraHolderImp = new d();
    }

    private void cleanAllListener() {
        if (this.loggerCallBack != null) {
            this.loggerCallBack = null;
        }
        if (this.eventListener != null) {
            this.eventListener = null;
        }
        d dVar = this.cameraHolderImp;
        if (dVar != null) {
            if (dVar.f99920b != null) {
                dVar.f99920b = null;
            }
            if (dVar.f99921c != null) {
                dVar.f99921c = null;
            }
        }
    }

    private Matrix computePreviewMatrix(TextureView textureView, Point point, Point point2) {
        float f16;
        float f17;
        Matrix matrix = new Matrix();
        textureView.getTransform(matrix);
        matrix.reset();
        if (point.equals(point2)) {
            return matrix;
        }
        int displayRotate = getDisplayRotate();
        Point point3 = getCurrentCameraInfo().f99930f;
        int i3 = point3.x;
        int i16 = point2.x;
        int i17 = (i3 - i16) / 2;
        int i18 = point3.y;
        int i19 = point2.y;
        int i26 = (i18 - i19) / 2;
        if (displayRotate % 180 != 0) {
            f16 = (i16 * 1.0f) / point.y;
            i26 = (i3 - i19) / 2;
            i17 = (i18 - i16) / 2;
            f17 = (i19 * 1.0f) / point.x;
        } else {
            f16 = (i16 * 1.0f) / point.x;
            f17 = (i19 * 1.0f) / point.y;
        }
        float max = Math.max(f16, f17);
        matrix.preScale(1.0f / f16, 1.0f / f17);
        matrix.postScale(max, max);
        matrix.postTranslate(-i17, -i26);
        return matrix;
    }

    private void createHandlerThread() {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("camera-preview");
        this.handlerThread = baseHandlerThread;
        baseHandlerThread.start();
        this.handler = new a(this.handlerThread.getLooper());
    }

    private Matrix createTransformMatrix(TextureView textureView) {
        if (this.transformMatrix == null) {
            Camera.Size cameraSize = getCameraSize();
            if (cameraSize == null) {
                CameraLogger.a(TAG, "createTransformMatrix size == null", this.loggerCallBack);
                CameraEventListener cameraEventListener = this.eventListener;
                if (cameraEventListener != null) {
                    cameraEventListener.onEventError(3, "createTransformMatrix size is null");
                    return null;
                }
                return null;
            }
            this.transformMatrix = computePreviewMatrix(textureView, new Point(cameraSize.width, cameraSize.height), new Point(textureView.getWidth(), textureView.getHeight()));
        }
        return this.transformMatrix;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doAutoFocus(boolean z16) {
        d dVar = this.cameraHolderImp;
        if (dVar != null) {
            if (dVar.f99923e) {
                dVar.a(4, "isFocusing!");
                return;
            }
            Camera camera2 = dVar.f99919a.f99925a;
            if (camera2 == null) {
                dVar.a(4, "current camera is null!");
                return;
            }
            try {
                Camera.Parameters parameters = camera2.getParameters();
                if (parameters == null) {
                    dVar.a(4, "current camera  parameters is null!");
                    return;
                }
                dVar.f99923e = true;
                if ("auto".equals(parameters.getFocusMode()) && !z16) {
                    dVar.f99923e = false;
                    dVar.a(4, "there is no need change auto mode");
                    return;
                }
                if (parameters.getSupportedFocusModes().contains("continuous-video")) {
                    parameters.setFocusMode("continuous-video");
                    camera2.setParameters(parameters);
                }
                String focusMode = parameters.getFocusMode();
                if ("continuous-video".equals(focusMode)) {
                    dVar.f99923e = false;
                    dVar.a(4, "there is no need change auto mode");
                } else {
                    if (!"auto".equals(focusMode)) {
                        parameters.setFocusMode("auto");
                        camera2.setParameters(parameters);
                    }
                    camera2.autoFocus(new com.tencent.could.aicamare.a(dVar));
                }
            } catch (Exception e16) {
                dVar.b("there is some error with set auto mode + e: " + e16.getLocalizedMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doChangeZoom(boolean z16) {
        d dVar = this.cameraHolderImp;
        if (dVar != null) {
            Camera camera2 = dVar.f99919a.f99925a;
            if (camera2 == null) {
                dVar.a(4, "current camera is null");
                return;
            }
            try {
                Camera.Parameters parameters = camera2.getParameters();
                if (parameters.isZoomSupported()) {
                    int maxZoom = parameters.getMaxZoom();
                    int zoom = parameters.getZoom();
                    if (z16 && zoom < maxZoom) {
                        zoom++;
                    } else if (zoom > 0) {
                        zoom--;
                    }
                    parameters.setZoom(zoom);
                    camera2.setParameters(parameters);
                    return;
                }
                dVar.a("this camera do not support");
            } catch (Exception e16) {
                dVar.b("doChangeZoom error: " + e16.getLocalizedMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doCloseCamera() {
        d dVar = this.cameraHolderImp;
        if (dVar != null) {
            dVar.a("do close camera");
            Camera camera2 = dVar.f99919a.f99925a;
            if (camera2 == null) {
                CameraLogger.a("CameraHolderImp", "do close camera is null!", dVar.f99921c);
                return;
            }
            synchronized (d.class) {
                try {
                    com.tencent.could.aicamare.entity.a aVar = dVar.f99919a;
                    aVar.f99925a = null;
                    aVar.f99928d = null;
                    aVar.f99930f = null;
                    aVar.f99926b = 0;
                    aVar.f99927c = 0;
                    aVar.f99929e = 0;
                    camera2.cancelAutoFocus();
                    camera2.stopPreview();
                    camera2.setOneShotPreviewCallback(null);
                    camera2.setPreviewCallback(null);
                    camera2.release();
                    dVar.a("close camera success\uff01");
                    CameraEventListener cameraEventListener = dVar.f99920b;
                    if (cameraEventListener != null) {
                        cameraEventListener.onCameraClosed();
                    }
                } catch (Exception e16) {
                    String str = "some error happen in close e: " + e16.getMessage();
                    dVar.b(str);
                    dVar.a(2, str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLifeOnPause() {
        com.tencent.could.aicamare.entity.a aVar;
        Camera camera2;
        d dVar = this.cameraHolderImp;
        if (dVar == null || (aVar = dVar.f99919a) == null || (camera2 = aVar.f99925a) == null) {
            return;
        }
        try {
            camera2.stopPreview();
        } catch (Exception e16) {
            CameraLogger.a(TAG, "doLifeResume error: e " + e16.getLocalizedMessage(), this.loggerCallBack);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLifeResume() {
        com.tencent.could.aicamare.entity.a aVar;
        Camera camera2;
        d dVar = this.cameraHolderImp;
        if (dVar == null || (aVar = dVar.f99919a) == null || (camera2 = aVar.f99925a) == null) {
            return;
        }
        try {
            this.cameraHolderImp.a(camera2);
            camera2.startPreview();
        } catch (Exception e16) {
            CameraLogger.a(TAG, "doLifeResume error: e " + e16.getLocalizedMessage(), this.loggerCallBack);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x038b, code lost:
    
        if (r8[1] != r8[0]) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0215, code lost:
    
        if ((r14 - r11) < (r11 - r12.get(r15).intValue())) goto L100;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x04f5  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x04fe  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0198  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doOpenCamera() {
        int i3;
        Context context;
        int i16;
        int i17;
        int i18;
        boolean z16;
        boolean z17;
        boolean z18;
        String str;
        boolean z19;
        float f16;
        float f17;
        int i19;
        int[] iArr;
        int i26;
        int i27;
        String str2 = "Exception e: ";
        d dVar = this.cameraHolderImp;
        if (dVar != null) {
            if (Camera.getNumberOfCameras() < 0) {
                dVar.a(1, "There are not camera devices found!");
            } else {
                try {
                    boolean z26 = !dVar.f99922d.isBackCamera();
                    int numberOfCameras = Camera.getNumberOfCameras();
                    Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                    i3 = 0;
                    while (true) {
                        if (i3 < numberOfCameras) {
                            Camera.getCameraInfo(i3, cameraInfo);
                            if (cameraInfo.facing == z26) {
                                break;
                            } else {
                                i3++;
                            }
                        } else {
                            i3 = -808;
                            break;
                        }
                    }
                } catch (RuntimeException e16) {
                    dVar.a(1, "open camera happen runtime error: " + e16.getLocalizedMessage());
                }
                if (i3 == -808) {
                    dVar.a(1, "can not find a suit camera devices!");
                } else {
                    com.tencent.could.aicamare.entity.a aVar = dVar.f99919a;
                    aVar.f99926b = i3;
                    aVar.f99925a = CameraMonitor.open(i3);
                    WeakReference<Context> weakReference = dVar.f99924f;
                    if (weakReference == null) {
                        context = null;
                    } else {
                        context = weakReference.get();
                    }
                    if (context == null) {
                        dVar.a(1, "open camera context is null!");
                    } else {
                        int i28 = !dVar.f99922d.isBackCamera() ? 1 : 0;
                        int i29 = dVar.f99919a.f99926b;
                        Camera.CameraInfo cameraInfo2 = new Camera.CameraInfo();
                        Camera.getCameraInfo(i29, cameraInfo2);
                        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
                        dVar.a("row DefaultDisplay rotation:" + (rotation * 90));
                        int i36 = 2;
                        if (rotation != 1) {
                            if (rotation != 2) {
                                if (rotation != 3) {
                                    i16 = 0;
                                } else {
                                    i16 = 270;
                                }
                            } else {
                                i16 = 180;
                            }
                        } else {
                            i16 = 90;
                        }
                        if (cameraInfo2.facing == 1) {
                            i17 = (360 - ((cameraInfo2.orientation + i16) % 360)) % 360;
                        } else {
                            i17 = ((cameraInfo2.orientation - i16) + 360) % 360;
                        }
                        dVar.a("debug camera orientation is " + cameraInfo2.orientation + " ui degrees is " + i16 + " display need change: " + i17);
                        dVar.f99919a.f99929e = i17;
                        if (i17 == 90) {
                            i18 = 7;
                        } else if (i17 == 180) {
                            i18 = 3;
                        } else if (i17 == 270) {
                            i18 = 5;
                        } else {
                            dVar.a("camera rotate not 90 degree or 180 degree, input cameraRotate: " + i17);
                            i18 = 1;
                        }
                        if (i28 == 1) {
                            i36 = i18;
                        } else if (i18 != 1) {
                            if (i18 == 2) {
                                i36 = 1;
                            } else {
                                i36 = 4;
                                if (i18 != 3) {
                                    if (i18 == 4) {
                                        i36 = 3;
                                    } else {
                                        i36 = 8;
                                        if (i18 != 5) {
                                            if (i18 == 6) {
                                                i36 = 7;
                                            } else if (i18 == 7) {
                                                i36 = 6;
                                            } else if (i18 == 8) {
                                                i36 = 5;
                                            } else {
                                                dVar.a("[CameraSetting.transBackFacingCameraRatateTag] unsurported rotateTag: " + i18);
                                                i36 = 0;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        dVar.a("cameraFacing: " + i28 + " rotateTag: " + i36);
                        dVar.f99919a.f99927c = i36;
                        z16 = true;
                        if (z16) {
                            CameraLogger.a("CameraHolderImp", "localOpenCamera fail!", dVar.f99921c);
                            return;
                        }
                        int preWidth = dVar.f99922d.getPreWidth();
                        int preHeight = dVar.f99922d.getPreHeight();
                        Camera camera2 = dVar.f99919a.f99925a;
                        if (camera2 == null) {
                            dVar.a(1, "init camera fail, current camera is null!");
                            z18 = false;
                        } else {
                            try {
                                Camera.Parameters parameters = camera2.getParameters();
                                if (dVar.f99922d.isBackCamera()) {
                                    CameraZoom zoom = dVar.f99922d.getZoom();
                                    if (zoom != CameraZoom.ZOOM_1X) {
                                        if (zoom == CameraZoom.ZOOM_1_5X) {
                                            i27 = 150;
                                        } else if (zoom == CameraZoom.ZOOM_2X) {
                                            i27 = 200;
                                        } else {
                                            i27 = 0;
                                        }
                                        Camera camera3 = dVar.f99919a.f99925a;
                                        if (camera3 != null) {
                                            List<Integer> zoomRatios = camera3.getParameters().getZoomRatios();
                                            for (int i37 = 0; i37 < zoomRatios.size(); i37++) {
                                                int intValue = zoomRatios.get(i37).intValue();
                                                if (intValue != i27) {
                                                    if (intValue > i27) {
                                                        i26 = i37 - 1;
                                                    }
                                                }
                                                i26 = i37;
                                            }
                                        }
                                    }
                                    i26 = 0;
                                    parameters.setZoom(i26);
                                }
                                List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
                                int max = Math.max(preWidth, preHeight);
                                int min = Math.min(preWidth, preHeight);
                                double d16 = max / min;
                                ArrayList arrayList = new ArrayList();
                                Iterator<Camera.Size> it = supportedPreviewSizes.iterator();
                                while (it.hasNext()) {
                                    Camera.Size next = it.next();
                                    String str3 = str2;
                                    Iterator<Camera.Size> it5 = it;
                                    int i38 = preHeight;
                                    double d17 = next.height / next.width;
                                    if (d17 == 0.75d) {
                                        arrayList.add(next);
                                    }
                                    if (d17 == 0.5625d) {
                                        arrayList.add(next);
                                    }
                                    str2 = str3;
                                    it = it5;
                                    preHeight = i38;
                                }
                                String str4 = str2;
                                int i39 = preHeight;
                                if (arrayList.size() != 0) {
                                    supportedPreviewSizes = arrayList;
                                }
                                Iterator<Camera.Size> it6 = supportedPreviewSizes.iterator();
                                double d18 = Double.MAX_VALUE;
                                Camera.Size size = null;
                                while (it6.hasNext()) {
                                    Camera.Size next2 = it6.next();
                                    Iterator<Camera.Size> it7 = it6;
                                    int i46 = preWidth;
                                    if (Math.abs((next2.width / next2.height) - d16) <= 0.1d) {
                                        double abs = Math.abs(next2.height - min);
                                        if (abs < d18) {
                                            d18 = abs;
                                            size = next2;
                                        }
                                    }
                                    it6 = it7;
                                    preWidth = i46;
                                }
                                int i47 = preWidth;
                                if (size == null) {
                                    double d19 = Double.MAX_VALUE;
                                    for (Camera.Size size2 : supportedPreviewSizes) {
                                        if (Math.abs(size2.height - min) < d19) {
                                            d19 = Math.abs(size2.height - min);
                                            size = size2;
                                        }
                                    }
                                }
                                Camera.Size size3 = size;
                                Log.e("CameraUtil", "optimalSize: " + size3 + " w: " + max + " h: " + min);
                                try {
                                    parameters.setPreviewSize(size3.width, size3.height);
                                    int minFps = dVar.f99922d.getMinFps() * 1000;
                                    int maxFps = dVar.f99922d.getMaxFps() * 1000;
                                    List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
                                    if (!dVar.f99922d.isMustDiffMinAndMaxFps() || minFps != maxFps) {
                                        for (int[] iArr2 : supportedPreviewFpsRange) {
                                            try {
                                                if (iArr2[0] == minFps && iArr2[1] == maxFps) {
                                                    z19 = true;
                                                    break;
                                                }
                                            } catch (Exception e17) {
                                                e = e17;
                                                z17 = false;
                                                str = str4;
                                                Log.e("CameraHolderImp", str + e.getLocalizedMessage());
                                                dVar.a(1, "set preview parameter size error");
                                                z18 = z17;
                                                if (!z18) {
                                                }
                                            }
                                        }
                                    }
                                    z19 = false;
                                    if (!z19) {
                                        int i48 = Integer.MAX_VALUE;
                                        for (int i49 = 0; i49 < supportedPreviewFpsRange.size(); i49++) {
                                            try {
                                                iArr = supportedPreviewFpsRange.get(i49);
                                                z17 = false;
                                            } catch (Exception e18) {
                                                e = e18;
                                                z17 = false;
                                                str = str4;
                                                Log.e("CameraHolderImp", str + e.getLocalizedMessage());
                                                dVar.a(1, "set preview parameter size error");
                                                z18 = z17;
                                                if (!z18) {
                                                }
                                            }
                                            try {
                                                if (iArr[1] - iArr[0] <= i48) {
                                                    if (dVar.f99922d.isMustDiffMinAndMaxFps()) {
                                                    }
                                                    int i56 = iArr[1];
                                                    int i57 = iArr[0];
                                                    i48 = i56 - i57;
                                                    z19 = true;
                                                    maxFps = i56;
                                                    minFps = i57;
                                                }
                                            } catch (Exception e19) {
                                                e = e19;
                                                str = str4;
                                                Log.e("CameraHolderImp", str + e.getLocalizedMessage());
                                                dVar.a(1, "set preview parameter size error");
                                                z18 = z17;
                                                if (!z18) {
                                                }
                                            }
                                        }
                                    }
                                    z17 = false;
                                    if (!z19) {
                                        dVar.a("not found, using defaut, min : " + minFps + " max: " + maxFps);
                                        minFps = 30000;
                                        maxFps = 30000;
                                    }
                                    dVar.a("using range min: " + minFps + " max: " + maxFps);
                                    parameters.setPreviewFpsRange(minFps, maxFps);
                                    camera2.setParameters(parameters);
                                    try {
                                        if (parameters.getSupportedFocusModes().contains("continuous-video")) {
                                            parameters.setFocusMode("continuous-video");
                                            camera2.setParameters(parameters);
                                        }
                                    } catch (Exception unused) {
                                        dVar.a("This phone not support AutoFocus");
                                    }
                                    try {
                                        camera2.setDisplayOrientation(dVar.f99919a.f99929e);
                                        dVar.f99919a.f99928d = parameters.getPreviewSize();
                                        com.tencent.could.aicamare.entity.a aVar2 = dVar.f99919a;
                                        Point point = new Point(i47, i39);
                                        com.tencent.could.aicamare.entity.a aVar3 = dVar.f99919a;
                                        Camera.Size size4 = aVar3.f99928d;
                                        if (aVar3.f99929e % 180 != 0) {
                                            f16 = (point.x * 1.0f) / size4.height;
                                            f17 = point.y * 1.0f;
                                            i19 = size4.width;
                                        } else {
                                            f16 = (point.x * 1.0f) / size4.width;
                                            f17 = point.y * 1.0f;
                                            i19 = size4.height;
                                        }
                                        float f18 = f17 / i19;
                                        Log.e("CameraHolderImp", "scaleX: " + f16 + " scaleY: " + f18);
                                        float max2 = Math.max(f16, f18);
                                        aVar2.f99930f = new Point((int) (((float) size4.width) * max2), (int) (((float) size4.height) * max2));
                                        dVar.a("initCamera success!");
                                        z18 = true;
                                    } catch (Exception e26) {
                                        Log.e("CameraHolderImp", str4 + e26.getLocalizedMessage());
                                        dVar.a(7, "set display orientation error.");
                                        z18 = z17;
                                        if (!z18) {
                                        }
                                    }
                                } catch (Exception e27) {
                                    e = e27;
                                    str = str4;
                                    z17 = false;
                                }
                            } catch (RuntimeException e28) {
                                z17 = false;
                                Log.e("CameraHolderImp", "RuntimeException e: " + e28.getLocalizedMessage());
                                dVar.a(1, "currentCamera, getParameters error!");
                            }
                        }
                        if (!z18) {
                            CameraLogger.a("CameraHolderImp", "initCamera fail!", dVar.f99921c);
                            return;
                        }
                        CameraEventListener cameraEventListener = dVar.f99920b;
                        if (cameraEventListener != null) {
                            cameraEventListener.onCameraSucceed();
                            return;
                        }
                        return;
                    }
                }
            }
            z16 = false;
            if (z16) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doStartPreview() {
        d dVar = this.cameraHolderImp;
        if (dVar != null) {
            boolean z16 = this.isUseSurfaceHolder;
            SurfaceHolder surfaceHolder = this.surfaceHolder;
            SurfaceTexture surfaceTexture = this.surfaceTexture;
            dVar.a("start camera preview");
            Camera camera2 = dVar.f99919a.f99925a;
            if (camera2 == null) {
                CameraLogger.a("CameraHolderImp", "start preview with currentCamera is null!", dVar.f99921c);
                dVar.a(6, "current camera is null!");
                return;
            }
            if (!dVar.a(camera2)) {
                dVar.a(6, "add camera preview fail!");
                return;
            }
            if (z16 && surfaceHolder != null) {
                try {
                    camera2.setPreviewDisplay(surfaceHolder);
                } catch (IOException | RuntimeException e16) {
                    dVar.a(6, "set preview display error : " + e16.getMessage());
                    return;
                }
            }
            if (!z16 && surfaceTexture != null) {
                camera2.setPreviewTexture(surfaceTexture);
            }
            camera2.startPreview();
            dVar.a("start camera preview success");
            CameraEventListener cameraEventListener = dVar.f99920b;
            if (cameraEventListener != null) {
                cameraEventListener.onPreviewSucceed();
            } else {
                CameraLogger.a("CameraHolderImp", "start preview fail eventListener is null", dVar.f99921c);
            }
        }
    }

    private void stopCurrentThread() {
        if (this.handler == null) {
            return;
        }
        CameraLoggerCallBack cameraLoggerCallBack = this.loggerCallBack;
        CameraLogger.LOG_LEVEL log_level = CameraLogger.f99931a;
        if (CameraLogger.LOG_LEVEL.LEVEL_DEBUG.compareTo(CameraLogger.f99931a) >= 0) {
            CameraLogger.a(true, TAG, "clean handler and thread", cameraLoggerCallBack);
        }
        this.handler.removeMessages(1);
        this.handler.removeMessages(2);
        this.handler.removeMessages(3);
        this.handler.removeMessages(4);
        this.handler.removeMessages(5);
        this.handler.removeMessages(7);
        this.handler.removeMessages(6);
        this.handler = null;
        HandlerThread handlerThread = this.handlerThread;
        if (handlerThread != null && handlerThread.isAlive()) {
            this.handlerThread.quitSafely();
        }
    }

    public void closeCamera() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.cameraConfig.isMainThread()) {
            doCloseCamera();
            return;
        }
        if (this.handler == null) {
            CameraLogger.a(TAG, "close camera handler == null", this.loggerCallBack);
            doCloseCamera();
        } else {
            Message obtainMessage = this.handler.obtainMessage();
            obtainMessage.what = 2;
            this.handler.sendMessage(obtainMessage);
        }
    }

    public void doEventChangeCameraParameter(Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) map);
            return;
        }
        d dVar = this.cameraHolderImp;
        if (dVar != null) {
            Camera camera2 = dVar.f99919a.f99925a;
            if (camera2 != null && map != null) {
                try {
                    Camera.Parameters parameters = camera2.getParameters();
                    if (map.containsKey(PARAMETER_EXPOSURE_COMPENSATION)) {
                        parameters.setExposureCompensation(((Integer) map.get(PARAMETER_EXPOSURE_COMPENSATION)).intValue());
                    }
                    if (map.containsKey(PARAMETER_ZOOM_VALUE)) {
                        parameters.setZoom(((Integer) map.get(PARAMETER_ZOOM_VALUE)).intValue());
                    }
                    if (map.containsKey(PARAMETER_WHITE_BALANCE)) {
                        parameters.setWhiteBalance((String) map.get(PARAMETER_WHITE_BALANCE));
                    }
                    camera2.setParameters(parameters);
                    return;
                } catch (RuntimeException e16) {
                    dVar.b("changeCameraExposureInfo:" + e16.getLocalizedMessage());
                    return;
                }
            }
            CameraLogger.a("CameraHolderImp", "setEventChangeCameraParameter, currentCamera is null or parameter is null", dVar.f99921c);
        }
    }

    public void doFocus(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        if (this.cameraConfig.isMainThread()) {
            doAutoFocus(z16);
            return;
        }
        if (this.handler == null) {
            CameraLogger.a(TAG, "do focus handler == null", this.loggerCallBack);
            return;
        }
        Message obtainMessage = this.handler.obtainMessage();
        obtainMessage.what = 3;
        obtainMessage.arg1 = z16 ? 1 : 0;
        this.handler.sendMessage(obtainMessage);
    }

    public int getCameraId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        d dVar = this.cameraHolderImp;
        if (dVar != null) {
            return dVar.f99919a.f99926b;
        }
        return 0;
    }

    public Camera.Size getCameraSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Camera.Size) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        d dVar = this.cameraHolderImp;
        if (dVar != null) {
            return dVar.f99919a.f99928d;
        }
        return null;
    }

    public Camera getCurrentCamera() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Camera) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        d dVar = this.cameraHolderImp;
        if (dVar != null) {
            return dVar.f99919a.f99925a;
        }
        return null;
    }

    public com.tencent.could.aicamare.entity.a getCurrentCameraInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.could.aicamare.entity.a) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        d dVar = this.cameraHolderImp;
        if (dVar != null) {
            return dVar.f99919a;
        }
        return null;
    }

    public int getCurrentRotate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        d dVar = this.cameraHolderImp;
        if (dVar != null) {
            return dVar.f99919a.f99927c;
        }
        return 0;
    }

    public int getDisplayRotate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        d dVar = this.cameraHolderImp;
        if (dVar != null) {
            return dVar.f99919a.f99929e;
        }
        return 0;
    }

    public void initCameraHolder(Context context, CameraConfig cameraConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) cameraConfig);
            return;
        }
        if (cameraConfig != null) {
            this.cameraConfig = cameraConfig;
        }
        this.cameraHolderImp.a(context);
        this.cameraHolderImp.f99922d = cameraConfig;
        if (!cameraConfig.isMainThread()) {
            createHandlerThread();
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) motionEvent);
            return;
        }
        if (motionEvent.getPointerCount() == 1) {
            doFocus(true);
            return;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 2) {
            if (action == 5) {
                this.oldDist = com.tencent.could.aicamare.util.a.a(motionEvent);
                return;
            }
            return;
        }
        float a16 = com.tencent.could.aicamare.util.a.a(motionEvent);
        float f16 = this.oldDist;
        if (a16 > f16) {
            zoomCamera(true);
        } else if (a16 < f16) {
            zoomCamera(false);
        }
        this.oldDist = a16;
    }

    public void openCamera(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
            return;
        }
        this.cameraHolderImp.a(context);
        if (this.cameraConfig.isMainThread()) {
            doOpenCamera();
        } else {
            if (this.handler == null) {
                CameraLogger.a(TAG, "open camera handler == null", this.loggerCallBack);
                return;
            }
            Message obtainMessage = this.handler.obtainMessage();
            obtainMessage.what = 1;
            this.handler.sendMessage(obtainMessage);
        }
    }

    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        doCloseCamera();
        stopCurrentThread();
        cleanAllListener();
        if (this.surfaceTexture != null) {
            this.surfaceTexture = null;
        }
        if (this.surfaceHolder != null) {
            this.surfaceHolder = null;
        }
        if (this.transformMatrix != null) {
            this.transformMatrix = null;
        }
    }

    public void setEventChangeCameraParameter(Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) map);
            return;
        }
        if (this.cameraConfig.isMainThread()) {
            doEventChangeCameraParameter(map);
            return;
        }
        if (this.handler == null) {
            CameraLogger.a(TAG, "set camera parameter handler == null", this.loggerCallBack);
            return;
        }
        Message obtainMessage = this.handler.obtainMessage();
        obtainMessage.what = 8;
        obtainMessage.obj = map;
        this.handler.sendMessage(obtainMessage);
    }

    public void setEventListener(CameraEventListener cameraEventListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) cameraEventListener);
            return;
        }
        this.eventListener = cameraEventListener;
        d dVar = this.cameraHolderImp;
        if (dVar != null) {
            dVar.f99920b = cameraEventListener;
        }
    }

    public void setLoggerCallBack(CameraLoggerCallBack cameraLoggerCallBack, CameraLogger.LOG_LEVEL log_level) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) cameraLoggerCallBack, (Object) log_level);
            return;
        }
        CameraLogger.f99931a = log_level;
        this.loggerCallBack = cameraLoggerCallBack;
        d dVar = this.cameraHolderImp;
        if (dVar != null) {
            dVar.f99921c = cameraLoggerCallBack;
        }
    }

    public void startPreview(SurfaceHolder surfaceHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) surfaceHolder);
            return;
        }
        this.surfaceHolder = surfaceHolder;
        this.isUseSurfaceHolder = true;
        if (this.cameraConfig.isMainThread()) {
            doStartPreview();
        } else {
            if (this.handler == null) {
                CameraLogger.a(TAG, "start camera preview handler == null", this.loggerCallBack);
                return;
            }
            Message obtainMessage = this.handler.obtainMessage();
            obtainMessage.what = 5;
            this.handler.sendMessage(obtainMessage);
        }
    }

    public void startPreviewByResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        if (this.cameraConfig.isMainThread()) {
            doLifeResume();
        } else {
            if (this.handler == null) {
                CameraLogger.a(TAG, "do focus handler == null", this.loggerCallBack);
                return;
            }
            Message obtainMessage = this.handler.obtainMessage();
            obtainMessage.what = 6;
            this.handler.sendMessage(obtainMessage);
        }
    }

    public void startPreviewWithTexture(TextureView textureView, SurfaceTexture surfaceTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) textureView, (Object) surfaceTexture);
            return;
        }
        if (textureView != null) {
            createTransformMatrix(textureView);
            Matrix matrix = this.transformMatrix;
            if (matrix != null) {
                textureView.setTransform(matrix);
            } else {
                CameraLogger.a(TAG, "transformMatrix do not create is null", this.loggerCallBack);
            }
        }
        this.isUseSurfaceHolder = false;
        this.surfaceTexture = surfaceTexture;
        if (this.cameraConfig.isMainThread()) {
            doStartPreview();
        } else {
            if (this.handler == null) {
                CameraLogger.a(TAG, "start camera preview handler == null", this.loggerCallBack);
                return;
            }
            Message obtainMessage = this.handler.obtainMessage();
            obtainMessage.what = 5;
            this.handler.sendMessage(obtainMessage);
        }
    }

    public void stopPreviewByOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        if (this.cameraConfig.isMainThread()) {
            doLifeOnPause();
        } else {
            if (this.handler == null) {
                CameraLogger.a(TAG, "do focus handler == null", this.loggerCallBack);
                return;
            }
            Message obtainMessage = this.handler.obtainMessage();
            obtainMessage.what = 7;
            this.handler.sendMessage(obtainMessage);
        }
    }

    public void zoomCamera(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
            return;
        }
        if (this.cameraConfig.isMainThread()) {
            doChangeZoom(z16);
            return;
        }
        if (this.handler == null) {
            CameraLogger.a(TAG, "zoom camera handler == null", this.loggerCallBack);
            return;
        }
        Message obtainMessage = this.handler.obtainMessage();
        obtainMessage.what = 4;
        obtainMessage.arg1 = z16 ? 1 : 0;
        this.handler.sendMessage(obtainMessage);
    }

    public void setLoggerCallBack(CameraLoggerCallBack cameraLoggerCallBack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) {
            setLoggerCallBack(cameraLoggerCallBack, CameraLogger.LOG_LEVEL.LEVEL_VERBOSE);
        } else {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) cameraLoggerCallBack);
        }
    }
}
