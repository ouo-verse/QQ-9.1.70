package com.qzone.proxy.vipcomponent.adapter;

/* compiled from: P */
/* loaded from: classes39.dex */
public interface VipObserver {
    void onEventAsync(int i3, String str, Object obj);

    void onEventBackgroundThread(int i3, String str, Object obj);

    void onEventMainThread(int i3, String str, Object obj);

    void onEventPostThread(int i3, String str, Object obj);
}
