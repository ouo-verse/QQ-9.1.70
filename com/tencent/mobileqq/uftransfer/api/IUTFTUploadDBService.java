package com.tencent.mobileqq.uftransfer.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.uftransfer.data.UploadInfoEntity;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes19.dex */
public interface IUTFTUploadDBService extends IRuntimeService {

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
        void a(UploadInfoEntity uploadInfoEntity);
    }

    void addOrReplaceAsync(UploadInfoEntity uploadInfoEntity, a aVar);

    void getEntityAsync(String str, a aVar);

    void removeAsync(String str, a aVar);
}
