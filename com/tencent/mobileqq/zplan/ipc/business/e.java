package com.tencent.mobileqq.zplan.ipc.business;

import com.tencent.mobileqq.zplan.ipc.annotation.RemoteCallBack;
import com.tencent.mobileqq.zplan.ipc.annotation.ServletImpl;

/* compiled from: P */
@ServletImpl(impl = ZPlanUploadPicImpl.class)
/* loaded from: classes34.dex */
public interface e {

    /* compiled from: P */
    @RemoteCallBack
    /* loaded from: classes34.dex */
    public interface a {
        void a(boolean z16, String str);
    }

    void upLoadPic(String str, String str2, String str3, a aVar);
}
