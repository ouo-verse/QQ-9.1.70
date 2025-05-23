package com.tencent.bugly.common.utils;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.rmonitor.common.logger.Logger;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DeviceInfo {
    private static final String TAG = "RMonitor_device";
    private final HashMap<String, String> operatorMap;
    private boolean init = false;
    private String simOperatorName = null;
    private String simOperator = null;
    private String netWorkOperator = null;
    private String netWorkOperatorName = null;
    private String simCountryIso = null;
    private String netCountryIso = null;

    public DeviceInfo() {
        HashMap<String, String> hashMap = new HashMap<>(11);
        this.operatorMap = hashMap;
        hashMap.put("46001", "\u4e2d\u56fd\u8054\u901a");
        hashMap.put("46006", "\u4e2d\u56fd\u8054\u901a");
        hashMap.put("46009", "\u4e2d\u56fd\u8054\u901a");
        hashMap.put("46000", "\u4e2d\u56fd\u79fb\u52a8");
        hashMap.put("46002", "\u4e2d\u56fd\u79fb\u52a8");
        hashMap.put("46004", "\u4e2d\u56fd\u79fb\u52a8");
        hashMap.put("46007", "\u4e2d\u56fd\u79fb\u52a8");
        hashMap.put("46003", "\u4e2d\u56fd\u7535\u4fe1");
        hashMap.put("46005", "\u4e2d\u56fd\u7535\u4fe1");
        hashMap.put("46011", "\u4e2d\u56fd\u7535\u4fe1");
        hashMap.put("46020", "\u4e2d\u56fd\u94c1\u901a");
    }

    private void init(Context context) {
        if (context != null && !this.init) {
            this.init = true;
            try {
                if (DeviceInfoUtil.hasPermission(context, DeviceInfoUtil.PERMISSION_READ_PHONE)) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    this.simOperatorName = telephonyManager.getSimOperatorName();
                    this.simOperator = DeviceInfoMonitor.getSimOperator(telephonyManager);
                    this.netWorkOperator = DeviceInfoMonitor.getNetworkOperator(telephonyManager);
                    this.netWorkOperatorName = telephonyManager.getNetworkOperatorName();
                    this.simCountryIso = telephonyManager.getSimCountryIso();
                    this.netCountryIso = telephonyManager.getNetworkCountryIso();
                    Logger.f365497g.v(TAG, "init simOperatorName: " + this.simOperatorName + ", simOperator: " + this.simOperator + ", netWorkOperator: " + this.netWorkOperator + ", netWorkOperatorName: " + this.netWorkOperatorName + ", simCountryIso: " + this.simCountryIso + ", netCountryIso: " + this.netCountryIso);
                } else {
                    Logger.f365497g.v(TAG, "init fail for no permission.");
                }
            } catch (Throwable th5) {
                Logger.f365497g.v(TAG, "init fail for " + th5.getMessage());
            }
        }
    }

    public String getCountryCode() {
        String str;
        init(ContextUtil.getGlobalContext());
        if (TextUtils.isEmpty(this.simCountryIso)) {
            str = this.netCountryIso;
        } else {
            str = this.simCountryIso;
        }
        if (TextUtils.isEmpty(str)) {
            return "unknown";
        }
        return str;
    }

    public String getOperator() {
        init(ContextUtil.getGlobalContext());
        String operatorInner = getOperatorInner();
        if (TextUtils.isEmpty(operatorInner)) {
            return "unknown";
        }
        return operatorInner;
    }

    protected String getOperatorInner() {
        if (TextUtils.isEmpty(this.simOperator)) {
            return this.netWorkOperator;
        }
        return this.simOperator;
    }

    public String getOperatorName() {
        String str;
        init(ContextUtil.getGlobalContext());
        String operatorInner = getOperatorInner();
        if (TextUtils.isEmpty(operatorInner)) {
            if (TextUtils.isEmpty(this.simOperatorName)) {
                str = this.netWorkOperatorName;
            } else {
                str = this.simOperatorName;
            }
        } else {
            str = this.operatorMap.get(operatorInner);
            if (TextUtils.isEmpty(str)) {
                str = "Other";
            }
        }
        if (TextUtils.isEmpty(str)) {
            return "unknown";
        }
        return str;
    }

    public String getRegionID() {
        return "unknown";
    }
}
