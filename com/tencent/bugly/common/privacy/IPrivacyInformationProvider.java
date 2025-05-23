package com.tencent.bugly.common.privacy;

/* loaded from: classes5.dex */
public interface IPrivacyInformationProvider {
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final int INIT_FRAMEWORK_VERSION = -1;

    int getAndroidFrameworkVersion();

    String getCpuABI();

    String getCpuABI2();

    String getHardware();

    String getManufacture();

    String getModel();

    String getOSVersion();

    String getProduct();

    String[] getSupportedABIs();

    boolean isX86CPU();
}
