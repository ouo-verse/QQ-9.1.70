package com.huawei.hms.hihealth.data;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HealthKitApiInvoker {
    private String appId;
    private String appVersion;
    private boolean gzip;
    private String interfaceInvoked;
    private String interfaceProvider;
    private String packageName;
    private String requestBody;
    private String sdkVersion;

    public HealthKitApiInvoker() {
    }

    public HealthKitApiInvoker(HealthKitApiInvoker healthKitApiInvoker) {
        this.packageName = healthKitApiInvoker.packageName;
        this.appId = healthKitApiInvoker.appId;
        this.sdkVersion = healthKitApiInvoker.sdkVersion;
        this.appVersion = healthKitApiInvoker.appVersion;
        this.interfaceProvider = healthKitApiInvoker.interfaceProvider;
        this.interfaceInvoked = healthKitApiInvoker.interfaceInvoked;
        this.requestBody = healthKitApiInvoker.requestBody;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getInterfaceInvoked() {
        return this.interfaceInvoked;
    }

    public String getInterfaceProvider() {
        return this.interfaceProvider;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getRequestBody() {
        return this.requestBody;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public boolean isGzip() {
        return this.gzip;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setGzip(boolean z16) {
        this.gzip = z16;
    }

    public void setInterfaceInvoked(String str) {
        this.interfaceInvoked = str;
    }

    public void setInterfaceProvider(String str) {
        this.interfaceProvider = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setRequestBody(String str) {
        this.requestBody = str;
    }

    public void setSdkVersion(String str) {
        this.sdkVersion = str;
    }
}
