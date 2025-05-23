package com.tencent.gamematrix.gmcg.webrtc;

/* compiled from: P */
/* loaded from: classes6.dex */
public class DeviceConfig {
    public String area;
    public String cluster;
    private String controlKey;
    private String deviceId;
    private DeviceModel deviceModel;
    public int fps;
    private String identity;
    private String instAddress;
    private String instHost;
    public int resolutionHeight;
    public int resolutionWidth;
    private String signalServer;
    private String token;
    private boolean useInstIp;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public enum DeviceModel {
        DEVICE_VCA,
        DEVICE_ARM
    }

    public String getControlKey() {
        return this.controlKey;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public DeviceModel getDeviceModel() {
        return this.deviceModel;
    }

    public String getIdentity() {
        return this.identity;
    }

    public String getInstAddress() {
        return this.instAddress;
    }

    public String getInstHost() {
        return this.instHost;
    }

    public String getSignalServer() {
        return this.signalServer;
    }

    public String getToken() {
        return this.token;
    }

    public boolean isUseInstIp() {
        return this.useInstIp;
    }

    public void setControlKey(String str) {
        this.controlKey = str;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setDeviceModel(DeviceModel deviceModel) {
        this.deviceModel = deviceModel;
    }

    public void setIdentity(String str) {
        this.identity = str;
    }

    public DeviceConfig setInstAddress(String str) {
        this.instAddress = str;
        return this;
    }

    public DeviceConfig setInstHost(String str) {
        this.instHost = str;
        return this;
    }

    public void setSignalServer(String str) {
        this.signalServer = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public DeviceConfig setUseInstIp(boolean z16) {
        this.useInstIp = z16;
        return this;
    }
}
