package com.tencent.mobileqq.app;

import com.tencent.qphone.base.remote.ToServiceMsg;

/* compiled from: P */
/* loaded from: classes11.dex */
public interface IBusinessHandler {
    void notifyUI(int i3, boolean z16, Object obj);

    void notifyUI(int i3, boolean z16, Object obj, boolean z17);

    void notifyUI(ToServiceMsg toServiceMsg, int i3, boolean z16, Object obj);

    void send(ToServiceMsg toServiceMsg);

    void sendPbReq(ToServiceMsg toServiceMsg);
}
