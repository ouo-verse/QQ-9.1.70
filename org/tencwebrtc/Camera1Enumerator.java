package org.tencwebrtc;

import android.hardware.Camera;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import com.tencent.qmethod.pandoraex.monitor.CameraMonitor;
import java.util.ArrayList;
import java.util.List;
import org.tencwebrtc.CameraEnumerationAndroid;
import org.tencwebrtc.CameraVideoCapturer;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Camera1Enumerator implements CameraEnumerator {
    private static final String TAG = "Camera1Enumerator";
    private static List<List<CameraEnumerationAndroid.CaptureFormat>> cachedSupportedFormats;
    private final boolean captureToTexture;

    public Camera1Enumerator() {
        this(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<CameraEnumerationAndroid.CaptureFormat.FramerateRange> convertFramerates(List<int[]> list) {
        ArrayList arrayList = new ArrayList();
        for (int[] iArr : list) {
            arrayList.add(new CameraEnumerationAndroid.CaptureFormat.FramerateRange(iArr[0], iArr[1]));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Size> convertSizes(List<Camera.Size> list) {
        ArrayList arrayList = new ArrayList();
        for (Camera.Size size : list) {
            arrayList.add(new Size(size.width, size.height));
        }
        return arrayList;
    }

    private static List<CameraEnumerationAndroid.CaptureFormat> enumerateFormats(int i3) {
        int i16;
        Logging.d(TAG, "Get supported formats for camera index " + i3 + ".");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Camera camera2 = null;
        try {
            try {
                Logging.d(TAG, "Opening camera with index " + i3);
                camera2 = CameraMonitor.open(i3);
                Camera.Parameters parameters = camera2.getParameters();
                camera2.release();
                ArrayList arrayList = new ArrayList();
                try {
                    List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
                    int i17 = 0;
                    if (supportedPreviewFpsRange != null) {
                        int[] iArr = supportedPreviewFpsRange.get(supportedPreviewFpsRange.size() - 1);
                        i17 = iArr[0];
                        i16 = iArr[1];
                    } else {
                        i16 = 0;
                    }
                    for (Camera.Size size : parameters.getSupportedPreviewSizes()) {
                        arrayList.add(new CameraEnumerationAndroid.CaptureFormat(size.width, size.height, i17, i16));
                    }
                } catch (Exception e16) {
                    Logging.e(TAG, "getSupportedFormats() failed on camera index " + i3, e16);
                }
                Logging.d(TAG, "Get supported formats for camera index " + i3 + " done. Time spent: " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " ms.");
                return arrayList;
            } catch (Throwable th5) {
                if (camera2 != null) {
                    camera2.release();
                }
                throw th5;
            }
        } catch (RuntimeException e17) {
            Logging.e(TAG, "Open camera failed on camera index " + i3, e17);
            ArrayList arrayList2 = new ArrayList();
            if (camera2 != null) {
                camera2.release();
            }
            return arrayList2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getCameraIndex(String str) {
        Logging.d(TAG, "getCameraIndex: " + str);
        for (int i3 = 0; i3 < Camera.getNumberOfCameras(); i3++) {
            if (str.equals(getDeviceName(i3))) {
                return i3;
            }
        }
        throw new IllegalArgumentException("No such camera: " + str);
    }

    @Nullable
    private static Camera.CameraInfo getCameraInfo(int i3) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        try {
            Camera.getCameraInfo(i3, cameraInfo);
            return cameraInfo;
        } catch (Exception e16) {
            Logging.e(TAG, "getCameraInfo failed on index " + i3, e16);
            return null;
        }
    }

    @Nullable
    static String getDeviceName(int i3) {
        String str;
        Camera.CameraInfo cameraInfo = getCameraInfo(i3);
        if (cameraInfo == null) {
            return null;
        }
        if (cameraInfo.facing == 1) {
            str = "front";
        } else {
            str = "back";
        }
        return "Camera " + i3 + ", Facing " + str + ", Orientation " + cameraInfo.orientation;
    }

    @Override // org.tencwebrtc.CameraEnumerator
    public CameraVideoCapturer createCapturer(String str, CameraVideoCapturer.CameraEventsHandler cameraEventsHandler) {
        return new Camera1Capturer(str, cameraEventsHandler, this.captureToTexture);
    }

    @Override // org.tencwebrtc.CameraEnumerator
    public String[] getDeviceNames() {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < Camera.getNumberOfCameras(); i3++) {
            String deviceName = getDeviceName(i3);
            if (deviceName != null) {
                arrayList.add(deviceName);
                Logging.d(TAG, "Index: " + i3 + ". " + deviceName);
            } else {
                Logging.e(TAG, "Index: " + i3 + ". Failed to query camera name.");
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @Override // org.tencwebrtc.CameraEnumerator
    public List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(String str) {
        return getSupportedFormats(getCameraIndex(str));
    }

    @Override // org.tencwebrtc.CameraEnumerator
    public boolean isBackFacing(String str) {
        Camera.CameraInfo cameraInfo = getCameraInfo(getCameraIndex(str));
        if (cameraInfo != null && cameraInfo.facing == 0) {
            return true;
        }
        return false;
    }

    @Override // org.tencwebrtc.CameraEnumerator
    public boolean isFrontFacing(String str) {
        Camera.CameraInfo cameraInfo = getCameraInfo(getCameraIndex(str));
        if (cameraInfo != null && cameraInfo.facing == 1) {
            return true;
        }
        return false;
    }

    public Camera1Enumerator(boolean z16) {
        this.captureToTexture = z16;
    }

    static synchronized List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(int i3) {
        List<CameraEnumerationAndroid.CaptureFormat> list;
        synchronized (Camera1Enumerator.class) {
            if (cachedSupportedFormats == null) {
                cachedSupportedFormats = new ArrayList();
                for (int i16 = 0; i16 < Camera.getNumberOfCameras(); i16++) {
                    cachedSupportedFormats.add(enumerateFormats(i16));
                }
            }
            list = cachedSupportedFormats.get(i3);
        }
        return list;
    }
}
