package com.vivo.datashare.permission;

import java.io.Serializable;

/* loaded from: classes27.dex */
public class PermissionRequest implements Serializable {
    private String appDisplayName;
    private String appIconUrl;
    private String appId;
    private int appType;
    private int permissionGroup;
    private String permissionName;
    private long requestTime;
    private String requestTips;

    @Deprecated
    private String token;

    /* loaded from: classes27.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private PermissionRequest f387539a = new PermissionRequest();

        public b a(String str) {
            this.f387539a.appId = str;
            return this;
        }

        public b b(int i3) {
            this.f387539a.appType = i3;
            return this;
        }

        public PermissionRequest c() {
            return new PermissionRequest();
        }

        public b d(int i3) {
            this.f387539a.permissionGroup = i3;
            return this;
        }

        public b e(String str) {
            this.f387539a.permissionName = str;
            return this;
        }
    }

    public String getAppIconUrl() {
        return this.appIconUrl;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppName() {
        return this.appDisplayName;
    }

    public int getAppType() {
        return this.appType;
    }

    public int getPermissionGroup() {
        return this.permissionGroup;
    }

    public String getPermissionName() {
        return this.permissionName;
    }

    public long getRequestTime() {
        return this.requestTime;
    }

    public String getRequestTips() {
        return this.requestTips;
    }

    public String getToken() {
        return this.token;
    }

    public String toString() {
        return "{\"token\":\"" + this.token + "\", \"appId\":\"" + this.appId + "\", \"requestTime\":" + this.requestTime + ", \"requestTips\":\"" + this.requestTips + "\", \"permissionName\":\"" + this.permissionName + "\", \"permissionGroup\":" + this.permissionGroup + ", \"appDisplayName\":\"" + this.appDisplayName + "\", \"appIconUrl\":\"" + this.appIconUrl + "\", \"appType\":" + this.appType + '}';
    }

    PermissionRequest() {
        this.appType = 0;
    }

    PermissionRequest(PermissionRequest permissionRequest) {
        this.appType = 0;
        this.token = permissionRequest.token;
        this.appId = permissionRequest.appId;
        this.requestTime = System.currentTimeMillis();
        this.requestTips = permissionRequest.requestTips;
        this.permissionName = permissionRequest.permissionName;
        this.appDisplayName = permissionRequest.appDisplayName;
        this.permissionGroup = permissionRequest.permissionGroup;
        this.appType = permissionRequest.appType;
        this.appIconUrl = permissionRequest.appIconUrl;
    }
}
