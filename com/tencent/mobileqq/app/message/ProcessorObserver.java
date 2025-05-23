package com.tencent.mobileqq.app.message;

/* loaded from: classes11.dex */
public interface ProcessorObserver {
    void onReceiveBusinessMessage(int i3, boolean z16, Object obj);

    void onReceiveBusinessResp(int i3, boolean z16, Object obj);

    void onReceiveNewMessage(String str, String str2, boolean z16, int i3, boolean z17, boolean z18);
}
