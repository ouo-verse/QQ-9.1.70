package com.tencent.bugly.common.privacy;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.SystemProperties;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import com.tencent.bugly.common.sp.SharedPreferencesProvider;
import com.tencent.bugly.common.utils.ContextUtil;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.thumbplayer.libloader.TPFromApkLibraryLoader;

/* loaded from: classes5.dex */
public class PrivacyInformationCache implements IPrivacyInformationProvider {
    public static final String KEY_MANUFACTURER = "manufacture";
    public static final String KEY_MODEL = "model";
    public static final String KEY_PRODUCT = "product";
    static final String TAG = "RMonitor_Privacy";
    public static final String UNKNOWN = "unknown";

    private boolean hasContext() {
        if (ContextUtil.getGlobalContext() != null) {
            return true;
        }
        return false;
    }

    private String readValue(String str) {
        SharedPreferences multiProcessSP = SharedPreferencesProvider.getInstance().getMultiProcessSP(ContextUtil.getGlobalContext());
        String str2 = null;
        if (multiProcessSP != null) {
            str2 = multiProcessSP.getString(str, null);
        }
        Logger.f365497g.d(TAG, "readValue, key: " + str + ", value: " + str2);
        return str2;
    }

    private void writeValue(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            SharedPreferences multiProcessSP = SharedPreferencesProvider.getInstance().getMultiProcessSP(ContextUtil.getGlobalContext());
            if (multiProcessSP != null) {
                multiProcessSP.edit().putString(str, str2).apply();
            }
            Logger.f365497g.d(TAG, "writeValue, key: " + str + ", value: " + str2);
        }
    }

    @Override // com.tencent.bugly.common.privacy.IPrivacyInformationProvider
    public int getAndroidFrameworkVersion() {
        return Build.VERSION.SDK_INT;
    }

    @Override // com.tencent.bugly.common.privacy.IPrivacyInformationProvider
    public String getCpuABI() {
        return Build.CPU_ABI;
    }

    @Override // com.tencent.bugly.common.privacy.IPrivacyInformationProvider
    public String getCpuABI2() {
        return Build.CPU_ABI2;
    }

    @Override // com.tencent.bugly.common.privacy.IPrivacyInformationProvider
    public String getHardware() {
        return Build.HARDWARE;
    }

    @Override // com.tencent.bugly.common.privacy.IPrivacyInformationProvider
    public synchronized String getManufacture() {
        if (!hasContext()) {
            return "unknown";
        }
        String readValue = readValue("manufacture");
        if (TextUtils.isEmpty(readValue)) {
            readValue = Build.MANUFACTURER;
            writeValue("manufacture", readValue);
        }
        return readValue;
    }

    @Override // com.tencent.bugly.common.privacy.IPrivacyInformationProvider
    public synchronized String getModel() {
        if (!hasContext()) {
            return "unknown";
        }
        String readValue = readValue("model");
        if (TextUtils.isEmpty(readValue)) {
            readValue = DeviceInfoMonitor.getModel();
            writeValue("model", readValue);
        }
        return readValue;
    }

    @Override // com.tencent.bugly.common.privacy.IPrivacyInformationProvider
    public String getOSVersion() {
        return Build.VERSION.RELEASE;
    }

    @Override // com.tencent.bugly.common.privacy.IPrivacyInformationProvider
    public synchronized String getProduct() {
        if (!hasContext()) {
            return "unknown";
        }
        String readValue = readValue("product");
        if (TextUtils.isEmpty(readValue)) {
            readValue = Build.PRODUCT;
            writeValue("product", readValue);
        }
        return readValue;
    }

    @Override // com.tencent.bugly.common.privacy.IPrivacyInformationProvider
    @RequiresApi(api = 21)
    public String[] getSupportedABIs() {
        String[] strArr = Build.SUPPORTED_ABIS;
        if (strArr == null) {
            return IPrivacyInformationProvider.EMPTY_STRING_ARRAY;
        }
        return strArr;
    }

    @Override // com.tencent.bugly.common.privacy.IPrivacyInformationProvider
    public boolean isX86CPU() {
        try {
            Object invoke = SystemProperties.class.getMethod("get", String.class, String.class).invoke(SystemProperties.class, TPFromApkLibraryLoader.RO_PRODUCT_CPU_ABI, "");
            if (!(invoke instanceof String)) {
                return false;
            }
            return ((String) invoke).contains(ResourceAttributes.HostArchValues.X86);
        } catch (Throwable unused) {
            return false;
        }
    }
}
