package com.tencent.qqmini.sdk.launcher.core.model;

/* compiled from: P */
/* loaded from: classes23.dex */
public class AuthRequestEvent extends RequestEvent {
    private boolean isOnceSubscribeReq;
    public byte[] originalDataBytes;
    public String scopePermission;
    public String settingItem;

    public static AuthRequestEvent obtain(RequestEvent requestEvent, String str, String str2, byte[] bArr) {
        AuthRequestEvent authRequestEvent = new AuthRequestEvent();
        authRequestEvent.event = requestEvent.event;
        authRequestEvent.jsonParams = requestEvent.jsonParams;
        authRequestEvent.callbackId = requestEvent.callbackId;
        authRequestEvent.jsService = requestEvent.jsService;
        authRequestEvent.scopePermission = str;
        authRequestEvent.settingItem = str2;
        authRequestEvent.originalDataBytes = bArr;
        authRequestEvent.webViewId = requestEvent.webViewId;
        return authRequestEvent;
    }

    public boolean isOnceSubscribeReq() {
        return this.isOnceSubscribeReq;
    }

    public void setOnceSubscribe(boolean z16) {
        this.isOnceSubscribeReq = z16;
    }
}
