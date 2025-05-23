package com.tencent.mobileqq.vas.updatesystem.service;

import android.content.Intent;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.vas.updatesystem.data.VasUpdateData;
import com.tencent.qphone.base.remote.FromServiceMsg;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface IVasUpdateHandler {
    public static final int NOTIFY_TYPE_BEGIN = 0;
    public static final int NOTIFY_TYPE_QUICK_UPDATE_GETURL = 17;
    public static final int NOTIFY_TYPE_QUICK_UPDATE_SYNC = 16;
    public static final String QUICK_UPDATE_CMD_GETURL = "GetUrlReq";
    public static final String QUICK_UPDATE_CMD_SYNCVCR = "SyncVCRReq";
    public static final String QUICK_UPDATE_RSP_GETURL = "GetUrlRsp";
    public static final String QUICK_UPDATE_RSP_SYNCVCR = "SyncVCRRsp";

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        boolean a(int i3, boolean z16, VasUpdateData.QuickUpdateRsp quickUpdateRsp);
    }

    void addHandleQuickUpdateInterceptor(a aVar);

    void handleQuickUpdate(Intent intent, FromServiceMsg fromServiceMsg, byte[] bArr);

    void request(String str, MessageMicro messageMicro, Class cls, BusinessObserver businessObserver);

    void request(String str, String str2, BusinessObserver businessObserver);

    void request(String str, String str2, String str3, BusinessObserver businessObserver);

    void request(String str, byte[] bArr, BusinessObserver businessObserver);

    boolean requestQuickUpdate(String str, String str2);
}
