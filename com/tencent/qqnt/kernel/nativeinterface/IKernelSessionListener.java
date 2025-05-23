package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelSessionListener {
    void onNTSessionCreate(int i3, String str);

    void onOpentelemetryInit(OpentelemetryInit opentelemetryInit);

    void onSessionInitComplete(int i3, String str, String str2);

    void onUserOnlineResult(int i3, String str, RegisterRes registerRes);
}
