package com.tencent.mobileqq.qqlive.report.tianjige;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface b extends IQQLiveModule {

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface a {
        void a(boolean z16);
    }

    String a(ToServiceMsg toServiceMsg, String str, String str2);

    String c(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);

    void i(a aVar);

    boolean isInit();
}
