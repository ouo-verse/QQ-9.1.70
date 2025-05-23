package com.tencent.mobileqq.data;

import com.tencent.qphone.base.remote.FromServiceMsg;
import mqq.app.MSFServlet;

/* loaded from: classes10.dex */
public interface RespProcessor {
    void accept(MSFServlet mSFServlet, QzoneCommonIntent qzoneCommonIntent, FromServiceMsg fromServiceMsg);
}
