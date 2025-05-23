package org.tencwebrtc;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.AndroidException;
import android.util.Range;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.tencwebrtc.CameraEnumerationAndroid;
import org.tencwebrtc.CameraVideoCapturer;

/* compiled from: P */
@TargetApi(21)
/* loaded from: classes29.dex */
public class Camera2Enumerator implements CameraEnumerator {
    private static final double NANO_SECONDS_PER_SECOND = 1.0E9d;
    private static final String TAG = "Camera2Enumerator";
    private static final Map<String, List<CameraEnumerationAndroid.CaptureFormat>> cachedSupportedFormats = new HashMap();

    @Nullable
    final CameraManager cameraManager;
    final Context context;

    public Camera2Enumerator(Context context) {
        this.context = context;
        this.cameraManager = (CameraManager) context.getSystemService("camera");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<CameraEnumerationAndroid.CaptureFormat.FramerateRange> convertFramerates(Range<Integer>[] rangeArr, int i3) {
        ArrayList arrayList = new ArrayList();
        for (Range<Integer> range : rangeArr) {
            arrayList.add(new CameraEnumerationAndroid.CaptureFormat.FramerateRange(range.getLower().intValue() * i3, range.getUpper().intValue() * i3));
        }
        return arrayList;
    }

    private static List<Size> convertSizes(android.util.Size[] sizeArr) {
        ArrayList arrayList = new ArrayList();
        for (android.util.Size size : sizeArr) {
            arrayList.add(new Size(size.getWidth(), size.getHeight()));
        }
        return arrayList;
    }

    @Nullable
    private CameraCharacteristics getCameraCharacteristics(String str) {
        try {
            return this.cameraManager.getCameraCharacteristics(str);
        } catch (AndroidException e16) {
            Logging.e(TAG, "Camera access exception: " + e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getFpsUnitFactor(Range<Integer>[] rangeArr) {
        if (rangeArr.length == 0 || rangeArr[0].getUpper().intValue() < 1000) {
            return 1000;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Size> getSupportedSizes(CameraCharacteristics cameraCharacteristics) {
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        ((Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue();
        return convertSizes(streamConfigurationMap.getOutputSizes(SurfaceTexture.class));
    }

    public static boolean isSupported(Context context) {
        CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
        try {
            for (String str : cameraManager.getCameraIdList()) {
                if (((Integer) cameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue() == 2) {
                    return false;
                }
            }
            return true;
        } catch (AndroidException e16) {
            Logging.e(TAG, "Camera access exception: " + e16);
            return false;
        }
    }

    @Override // org.tencwebrtc.CameraEnumerator
    public CameraVideoCapturer createCapturer(String str, CameraVideoCapturer.CameraEventsHandler cameraEventsHandler) {
        return new Camera2Capturer(this.context, str, cameraEventsHandler);
    }

    @Override // org.tencwebrtc.CameraEnumerator
    public String[] getDeviceNames() {
        try {
            return this.cameraManager.getCameraIdList();
        } catch (AndroidException e16) {
            Logging.e(TAG, "Camera access exception: " + e16);
            return new String[0];
        }
    }

    @Override // org.tencwebrtc.CameraEnumerator
    public List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(String str) {
        return getSupportedFormats(this.context, str);
    }

    @Override // org.tencwebrtc.CameraEnumerator
    public boolean isBackFacing(String str) {
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(str);
        if (cameraCharacteristics != null && ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 1) {
            return true;
        }
        return false;
    }

    @Override // org.tencwebrtc.CameraEnumerator
    public boolean isFrontFacing(String str) {
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(str);
        if (cameraCharacteristics != null && ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 0) {
            return true;
        }
        return false;
    }

    static List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(Context context, String str) {
        return getSupportedFormats((CameraManager) context.getSystemService("camera"), str);
    }

    static List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(CameraManager cameraManager, String str) {
        long j3;
        Map<String, List<CameraEnumerationAndroid.CaptureFormat>> map = cachedSupportedFormats;
        synchronized (map) {
            if (map.containsKey(str)) {
                return map.get(str);
            }
            Logging.d(TAG, "Get supported formats for camera index " + str + ".");
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
                StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                Range[] rangeArr = (Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
                List<CameraEnumerationAndroid.CaptureFormat.FramerateRange> convertFramerates = convertFramerates(rangeArr, getFpsUnitFactor(rangeArr));
                List<Size> supportedSizes = getSupportedSizes(cameraCharacteristics);
                Iterator<CameraEnumerationAndroid.CaptureFormat.FramerateRange> it = convertFramerates.iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    i3 = Math.max(i3, it.next().max);
                }
                ArrayList arrayList = new ArrayList();
                for (Size size : supportedSizes) {
                    try {
                        j3 = streamConfigurationMap.getOutputMinFrameDuration(SurfaceTexture.class, new android.util.Size(size.width, size.height));
                    } catch (Exception unused) {
                        j3 = 0;
                    }
                    int round = j3 == 0 ? i3 : ((int) Math.round(NANO_SECONDS_PER_SECOND / j3)) * 1000;
                    arrayList.add(new CameraEnumerationAndroid.CaptureFormat(size.width, size.height, 0, round));
                    Logging.d(TAG, "Format: " + size.width + HippyTKDListViewAdapter.X + size.height + "@" + round);
                }
                cachedSupportedFormats.put(str, arrayList);
                Logging.d(TAG, "Get supported formats for camera index " + str + " done. Time spent: " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " ms.");
                return arrayList;
            } catch (Exception e16) {
                Logging.e(TAG, "getCameraCharacteristics(): " + e16);
                return new ArrayList();
            }
        }
    }
}
