package com.qq.e.comm.plugin.e.a;

import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.managers.status.DeviceInfoSetting;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.plugin.k.aj;
import com.qq.e.comm.plugin.stat.StatTracer;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b extends a {
    private Pair<Boolean, Boolean> a(int i3) {
        if (aj.i() != null) {
            if (i3 == 101 && !TextUtils.isEmpty(aj.i().getImei())) {
                return new Pair<>(Boolean.TRUE, Boolean.FALSE);
            }
            if (SDKStatus.getSDKVersionCode() >= 240 && i3 == 110 && !TextUtils.isEmpty(aj.i().getDeviceId())) {
                return new Pair<>(Boolean.TRUE, Boolean.FALSE);
            }
            if (i3 == 115 && !TextUtils.isEmpty(aj.i().getAndroidId())) {
                return new Pair<>(Boolean.TRUE, Boolean.FALSE);
            }
            if (SDKStatus.getSDKVersionCode() >= 240 && i3 == 104 && !TextUtils.isEmpty(aj.i().getImsi())) {
                return new Pair<>(Boolean.TRUE, Boolean.FALSE);
            }
            if (SDKStatus.getSDKVersionCode() >= 250 && i3 == 117 && !TextUtils.isEmpty(aj.i().getBuildModel())) {
                return new Pair<>(Boolean.TRUE, Boolean.FALSE);
            }
        }
        return new Pair<>(Boolean.FALSE, null);
    }

    private void b(int i3, int i16) {
        if (!d.a().e()) {
            return;
        }
        StatTracer.trackEvent(i3, i16, new com.qq.e.comm.plugin.stat.b(), new com.qq.e.comm.plugin.stat.c());
    }

    private Pair<Boolean, Object> e(int i3, boolean z16) {
        if (i3 == 2 && !TextUtils.isEmpty(aj.i().getTaid())) {
            return new Pair<>(Boolean.TRUE, aj.i().getTaid());
        }
        if (i3 == 1 && !TextUtils.isEmpty(aj.i().getOaid())) {
            return new Pair<>(Boolean.TRUE, aj.i().getOaid());
        }
        if (i3 == 309 && !TextUtils.isEmpty(aj.i().getLat())) {
            return new Pair<>(Boolean.TRUE, aj.i().getLat());
        }
        if (i3 == 310 && !TextUtils.isEmpty(aj.i().getLng())) {
            return new Pair<>(Boolean.TRUE, aj.i().getLng());
        }
        if (i3 == 305 && !TextUtils.isEmpty(aj.i().getOperator())) {
            return new Pair<>(Boolean.TRUE, aj.i().getOperator());
        }
        if (i3 == 101 && !TextUtils.isEmpty(aj.i().getImei())) {
            String imei = aj.i().getImei();
            Boolean bool = Boolean.TRUE;
            if (z16) {
                imei = com.qq.e.comm.plugin.e.b.a(imei);
            }
            return new Pair<>(bool, imei);
        }
        if (i3 == 115 && !TextUtils.isEmpty(aj.i().getAndroidId())) {
            String androidId = aj.i().getAndroidId();
            Boolean bool2 = Boolean.TRUE;
            if (z16) {
                androidId = com.qq.e.comm.plugin.e.b.b(androidId);
            }
            return new Pair<>(bool2, androidId);
        }
        if (SDKStatus.getSDKVersionCode() >= 240 && i3 == 110 && !TextUtils.isEmpty(aj.i().getDeviceId())) {
            String deviceId = aj.i().getDeviceId();
            Boolean bool3 = Boolean.TRUE;
            if (z16) {
                deviceId = com.qq.e.comm.plugin.e.b.a(deviceId);
            }
            return new Pair<>(bool3, deviceId);
        }
        if (SDKStatus.getSDKVersionCode() >= 240 && i3 == 104 && !TextUtils.isEmpty(aj.i().getImsi())) {
            String imsi = aj.i().getImsi();
            Boolean bool4 = Boolean.TRUE;
            if (z16) {
                imsi = com.qq.e.comm.plugin.e.b.a(imsi);
            }
            return new Pair<>(bool4, imsi);
        }
        if (SDKStatus.getSDKVersionCode() >= 250 && i3 == 117 && !TextUtils.isEmpty(aj.i().getBuildModel())) {
            return new Pair<>(Boolean.TRUE, aj.i().getBuildModel());
        }
        return new Pair<>(Boolean.FALSE, null);
    }

    @Override // com.qq.e.comm.plugin.e.a.a
    protected Pair<Boolean, Boolean> c(int i3, boolean z16) {
        Boolean bool;
        Object obj;
        Pair<Boolean, Boolean> a16 = a(i3);
        if (a16 != null && (obj = a16.first) != null && ((Boolean) obj).booleanValue() && a16.second != null) {
            return a16;
        }
        if (SDKStatus.getSDKVersionCode() < 260) {
            return new Pair<>(Boolean.FALSE, null);
        }
        DeviceInfoSetting deviceInfoSetting = GlobalSetting.getDeviceInfoSetting();
        if (deviceInfoSetting == null) {
            return new Pair<>(Boolean.FALSE, null);
        }
        if (deviceInfoSetting.getDeviceInfoValue(i3) != null) {
            return new Pair<>(Boolean.TRUE, Boolean.FALSE);
        }
        ConcurrentHashMap<Integer, Boolean> deviceInfoConfig = deviceInfoSetting.getDeviceInfoConfig();
        if (deviceInfoConfig != null && deviceInfoConfig.containsKey(Integer.valueOf(i3)) && (bool = deviceInfoConfig.get(Integer.valueOf(i3))) != null && !bool.booleanValue()) {
            b(80104, i3);
            return new Pair<>(Boolean.TRUE, Boolean.FALSE);
        }
        return new Pair<>(Boolean.FALSE, null);
    }

    @Override // com.qq.e.comm.plugin.e.a.a
    protected Pair<Boolean, Object> d(int i3, boolean z16) {
        Pair<Boolean, Object> e16;
        Object obj;
        if (aj.i() != null && (e16 = e(i3, z16)) != null && (obj = e16.first) != null && ((Boolean) obj).booleanValue()) {
            return e16;
        }
        Object obj2 = null;
        if (SDKStatus.getSDKVersionCode() < 260) {
            return new Pair<>(Boolean.FALSE, null);
        }
        DeviceInfoSetting deviceInfoSetting = GlobalSetting.getDeviceInfoSetting();
        if (deviceInfoSetting != null && deviceInfoSetting.getDeviceInfoValue(i3) != null) {
            b(80105, i3);
            Object deviceInfoValue = deviceInfoSetting.getDeviceInfoValue(i3);
            if (deviceInfoValue != null && deviceInfoValue.equals(Constants.KEYS.DEVICE_INFO_DEFAULT_VALUE)) {
                return new Pair<>(Boolean.TRUE, null);
            }
            if (z16) {
                if (deviceInfoValue instanceof String) {
                    obj2 = a(i3, (String) deviceInfoValue);
                }
            } else {
                obj2 = deviceInfoValue;
            }
            return new Pair<>(Boolean.TRUE, obj2);
        }
        return new Pair<>(Boolean.FALSE, null);
    }

    private String a(int i3, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (i3 == 115) {
            return com.qq.e.comm.plugin.e.b.b(str);
        }
        if (i3 != 307) {
            switch (i3) {
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                case 106:
                case 107:
                case 108:
                case 109:
                case 110:
                case 111:
                case 112:
                    return com.qq.e.comm.plugin.e.b.a(str);
                default:
                    return null;
            }
        }
        return com.qq.e.comm.plugin.e.b.c(str);
    }
}
