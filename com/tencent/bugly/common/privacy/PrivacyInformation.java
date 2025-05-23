package com.tencent.bugly.common.privacy;

import android.content.Context;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import com.tencent.bugly.common.utils.ContextUtil;

/* loaded from: classes5.dex */
public final class PrivacyInformation implements IPrivacyInformationProvider {
    private static final PrivacyInformation instance = new PrivacyInformation();
    private final AppSetValue appSetValue = new AppSetValue();
    private String manufacture = null;
    private String osVersion = null;
    private String model = null;
    private String product = null;
    private String hardware = null;
    private String cpuABI = null;
    private String cpuABI2 = null;
    private String[] supportedABIs = null;
    private int androidFrameworkVersion = -1;
    private Boolean isX86CPU = null;
    private IPrivacyInformationProvider provider = new PrivacyInformationCache();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class AppSetValue {
        public String model;

        AppSetValue() {
            this.model = null;
        }
    }

    PrivacyInformation() {
    }

    private String checkValue(String str) {
        return str == null ? "" : str;
    }

    public static IPrivacyInformationProvider createProviderWithContext(Context context) {
        if (context != null && ContextUtil.getGlobalContext() == null) {
            ContextUtil.setGlobalContext(context);
        }
        return new PrivacyInformationCache();
    }

    public static PrivacyInformation getInstance() {
        return instance;
    }

    @Override // com.tencent.bugly.common.privacy.IPrivacyInformationProvider
    public int getAndroidFrameworkVersion() {
        if (this.androidFrameworkVersion == -1) {
            this.androidFrameworkVersion = this.provider.getAndroidFrameworkVersion();
        }
        return this.androidFrameworkVersion;
    }

    @Override // com.tencent.bugly.common.privacy.IPrivacyInformationProvider
    public String getCpuABI() {
        if (this.cpuABI == null) {
            this.cpuABI = checkValue(this.provider.getCpuABI());
        }
        return checkValue(this.cpuABI);
    }

    @Override // com.tencent.bugly.common.privacy.IPrivacyInformationProvider
    public String getCpuABI2() {
        if (this.cpuABI2 == null) {
            this.cpuABI2 = checkValue(this.provider.getCpuABI2());
        }
        return checkValue(this.cpuABI2);
    }

    @Override // com.tencent.bugly.common.privacy.IPrivacyInformationProvider
    public String getHardware() {
        if (this.hardware == null) {
            this.hardware = checkValue(this.provider.getHardware());
        }
        return checkValue(this.hardware);
    }

    @Override // com.tencent.bugly.common.privacy.IPrivacyInformationProvider
    public String getManufacture() {
        if (this.manufacture == null) {
            this.manufacture = checkValue(this.provider.getManufacture());
        }
        return checkValue(this.manufacture);
    }

    @Override // com.tencent.bugly.common.privacy.IPrivacyInformationProvider
    public String getModel() {
        if (!TextUtils.isEmpty(this.appSetValue.model)) {
            this.model = this.appSetValue.model;
        }
        if (TextUtils.isEmpty(this.model)) {
            this.model = checkValue(this.provider.getModel());
        }
        return checkValue(this.model);
    }

    @Override // com.tencent.bugly.common.privacy.IPrivacyInformationProvider
    public String getOSVersion() {
        if (this.osVersion == null) {
            this.osVersion = checkValue(this.provider.getOSVersion());
        }
        return checkValue(this.osVersion);
    }

    @Override // com.tencent.bugly.common.privacy.IPrivacyInformationProvider
    public String getProduct() {
        if (this.product == null) {
            this.product = checkValue(this.provider.getProduct());
        }
        return checkValue(this.product);
    }

    @Override // com.tencent.bugly.common.privacy.IPrivacyInformationProvider
    @RequiresApi(api = 21)
    public String[] getSupportedABIs() {
        if (this.supportedABIs == null) {
            this.supportedABIs = this.provider.getSupportedABIs();
        }
        return checkValue(this.supportedABIs);
    }

    @Override // com.tencent.bugly.common.privacy.IPrivacyInformationProvider
    public boolean isX86CPU() {
        if (this.isX86CPU == null) {
            this.isX86CPU = Boolean.valueOf(this.provider.isX86CPU());
        }
        return this.isX86CPU.booleanValue();
    }

    public void reset() {
        this.manufacture = null;
        this.osVersion = null;
        this.model = this.appSetValue.model;
        this.product = null;
        this.hardware = null;
        this.cpuABI = null;
        this.cpuABI2 = null;
        this.supportedABIs = null;
        this.androidFrameworkVersion = -1;
        this.isX86CPU = null;
    }

    public void setModel(String str) {
        this.appSetValue.model = str;
        this.model = str;
    }

    public void setProvider(IPrivacyInformationProvider iPrivacyInformationProvider) {
        if (iPrivacyInformationProvider != null) {
            this.provider = iPrivacyInformationProvider;
        }
        reset();
    }

    private String[] checkValue(String[] strArr) {
        return strArr == null ? IPrivacyInformationProvider.EMPTY_STRING_ARRAY : strArr;
    }
}
