package com.tencent.tgpa.lite;

/* loaded from: classes26.dex */
public interface PrivacyDataCallback {
    public static final String KEY_BRAND = "BuildBrand";
    public static final String KEY_CPUABI = "BuildCPUABI";
    public static final String KEY_DEVICE = "BuildDevice";
    public static final String KEY_MANUFACTURER = "BuildManufacturer";
    public static final String KEY_MODEL = "BuildModel";

    boolean canReadPrivacyDataBySelf();

    String getPrivacyData(String str);
}
