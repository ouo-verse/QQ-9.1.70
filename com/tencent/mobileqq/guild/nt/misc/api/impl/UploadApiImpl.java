package com.tencent.mobileqq.guild.nt.misc.api.impl;

import com.tencent.mobileqq.guild.nt.misc.api.IUploadApi;
import com.tencent.qphone.base.util.QLog;
import ev1.a;

/* compiled from: P */
/* loaded from: classes14.dex */
public class UploadApiImpl implements IUploadApi {
    public static final String TAG = "UploadApiImpl";

    @Override // com.tencent.mobileqq.guild.nt.misc.api.IUploadApi
    public IUploadApi.c startUploadTask(IUploadApi.e eVar) {
        QLog.i(TAG, 1, "startUploadTask params:" + eVar);
        a aVar = new a(eVar);
        aVar.l();
        return aVar;
    }
}
