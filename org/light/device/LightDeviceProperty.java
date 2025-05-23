package org.light.device;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.light.utils.LightDataUtils;
import org.light.utils.LightLogUtil;

/* loaded from: classes29.dex */
public class LightDeviceProperty {
    private static final String DEVICE_ID_SP_KEY = "light.deviceId";
    public static final int PROP_BUILD_BRAND = 3;
    public static final int PROP_BUILD_CPU_ABI = 4;
    public static final int PROP_BUILD_CPU_ABI2 = 5;
    public static final int PROP_BUILD_MANUFACTURER = 2;
    public static final int PROP_BUILD_MODEL = 1;
    public static final int PROP_BUILD_SUPPORTED_ABIS = 6;
    public static final int PROP_BUILD_VERSION_RELEASE = 8;
    public static final int PROP_BUILD_VERSION_SDK_INT = 7;
    public static final int PROP_DEVICE_ID = 0;
    private static final String TAG = "LightDeviceProperty";
    private static ConcurrentHashMap<Integer, Object> props = new ConcurrentHashMap<>();

    /* loaded from: classes29.dex */
    public static class VERSION {
        public static final int SDK_INT = Build.VERSION.SDK_INT;
    }

    /* loaded from: classes29.dex */
    public static class VERSION_CODES {
        public static final int BASE = 1;
        public static final int BASE_1_1 = 2;
        public static final int CUPCAKE = 3;
        public static final int DONUT = 4;
        public static final int ECLAIR = 5;
        public static final int ECLAIR_0_1 = 6;
        public static final int ECLAIR_MR1 = 7;
        public static final int FROYO = 8;
        public static final int GINGERBREAD = 9;
        public static final int GINGERBREAD_MR1 = 10;
        public static final int HONEYCOMB = 11;
        public static final int HONEYCOMB_MR1 = 12;
        public static final int HONEYCOMB_MR2 = 13;
        public static final int ICE_CREAM_SANDWICH = 14;
        public static final int ICE_CREAM_SANDWICH_MR1 = 15;
        public static final int JELLY_BEAN = 16;
        public static final int JELLY_BEAN_MR1 = 17;
        public static final int JELLY_BEAN_MR2 = 18;
        public static final int KITKAT = 19;
        public static final int KITKAT_WATCH = 20;
        public static final int L = 21;
        public static final int LOLLIPOP = 21;
        public static final int LOLLIPOP_MR1 = 22;
        public static final int M = 23;
        public static final int N = 24;
        public static final int NOUGAT = 24;
        public static final int N_MR1 = 25;
        public static final int O = 26;
        public static final int O_MR1 = 27;
        public static final int P = 28;
        public static final int Q = 29;
        public static final int R = 30;
        public static final int S = 31;
        public static final int S_V2 = 32;
    }

    private static void getAndSaveDeviceProp(int i3) {
        switch (i3) {
            case 0:
                String value = LightDataUtils.getValue(DEVICE_ID_SP_KEY);
                if (TextUtils.isEmpty(value)) {
                    value = UUID.randomUUID().toString();
                    LightDataUtils.saveValue(DEVICE_ID_SP_KEY, value);
                }
                LightLogUtil.e(TAG, "getAndSaveDeviceProp deviceId:" + value);
                props.put(0, value);
                break;
            case 1:
                props.put(1, DeviceInfoMonitor.getModel());
                break;
            case 2:
                props.put(2, Build.MANUFACTURER);
                break;
            case 3:
                props.put(3, Build.BRAND);
                break;
            case 4:
                props.put(4, Build.CPU_ABI);
                break;
            case 5:
                props.put(5, Build.CPU_ABI2);
                break;
            case 6:
                if (VERSION.SDK_INT >= 21) {
                    props.put(6, Build.SUPPORTED_ABIS);
                    break;
                }
                break;
            case 7:
                props.put(7, Integer.valueOf(Build.VERSION.SDK_INT));
                break;
            case 8:
                props.put(8, Build.VERSION.RELEASE);
                break;
        }
        LightLogUtil.e(TAG, "getAndSaveDeviceProp:key=" + i3 + ", value=" + props.get(Integer.valueOf(i3)));
    }

    public static boolean getBooleanProp(int i3) {
        Object tryGetProp = tryGetProp(i3);
        if (tryGetProp != null && ((Boolean) tryGetProp).booleanValue()) {
            return true;
        }
        return false;
    }

    public static int getIntProp(int i3) {
        Object tryGetProp = tryGetProp(i3);
        if (tryGetProp == null) {
            return 0;
        }
        return ((Integer) tryGetProp).intValue();
    }

    public static String[] getStringArrayProp(int i3) {
        Object tryGetProp = tryGetProp(i3);
        if (tryGetProp == null) {
            return null;
        }
        return (String[]) tryGetProp;
    }

    public static String getStringProp(int i3) {
        Object tryGetProp = tryGetProp(i3);
        if (tryGetProp == null) {
            return "";
        }
        return tryGetProp.toString();
    }

    public static void setDeviceProp(int i3, Object obj) {
        if (obj != null) {
            props.put(Integer.valueOf(i3), obj);
        }
    }

    private static Object tryGetProp(int i3) {
        if (!props.containsKey(Integer.valueOf(i3))) {
            getAndSaveDeviceProp(i3);
        }
        return props.get(Integer.valueOf(i3));
    }
}
