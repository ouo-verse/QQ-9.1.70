package com.tencent.qqmini.miniapp.core.service;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ServiceEventListener {
    void onServiceEvent(String str, String str2, int[] iArr);

    String onServiceNativeRequest(String str, String str2, int i3);
}
