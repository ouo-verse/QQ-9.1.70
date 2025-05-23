package com.tencent.mobileqq.vas.api;

import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import eipc.EIPCCallback;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasUpdateManager extends IVasManager {
    public static final List<a> INTERCEPTOR_LIST = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        void a(String str);
    }

    void startRemoteDownload(long j3, String str, String str2);

    <T extends QQVasUpdateBusiness> void startRemoteDownload(Class<T> cls, String str, EIPCCallback eIPCCallback);

    <T extends QQVasUpdateBusiness> void startRemoteDownload(Class<T> cls, String str, String str2, EIPCCallback eIPCCallback);

    <T extends QQVasUpdateBusiness> void startRemoteDownload(Class<T> cls, List<BusinessUpdateParams> list, String str, EIPCCallback eIPCCallback);
}
