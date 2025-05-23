package com.tencent.mobileqq.winkpublish.api.impl;

import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.winkpublish.api.IUploadApi;
import com.tencent.mobileqq.winkpublish.uploader.a;
import com.tencent.mobileqq.winkpublish.uploader.b;
import com.tencent.mobileqq.winkpublish.uploader.c;
import com.tencent.mobileqq.winkpublish.uploader.d;
import com.tencent.upload.network.NetworkState;
import com.tencent.upload.network.base.ConnectionImpl;
import com.tencent.upload.uinterface.UploadServiceBuilder;

/* compiled from: P */
/* loaded from: classes35.dex */
public class UploadApiImpl implements IUploadApi {
    @Override // com.tencent.mobileqq.winkpublish.api.IUploadApi
    public int getNetWorkStackType() {
        return NetworkState.getNetworkStackType();
    }

    @Override // com.tencent.mobileqq.winkpublish.api.IUploadApi
    public void initUpload() {
        if (ConnectionImpl.isLibraryPrepared()) {
            return;
        }
        b bVar = new b();
        UploadServiceBuilder.init(RFWApplication.getApplication(), new a(), new c(), new d(), bVar, bVar, null);
    }
}
