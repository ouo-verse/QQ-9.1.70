package com.tencent.mobileqq.app.handler;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* compiled from: P */
/* loaded from: classes11.dex */
public interface IMsgHandler {
    boolean handle(String str, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj);

    boolean handleError(String str, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);

    boolean handleTimeOut(String str, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);
}
