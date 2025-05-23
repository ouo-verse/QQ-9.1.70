package com.heytap.databaseengine.apiv2.health.business;

import com.heytap.databaseengine.apiv2.HResponse;
import com.heytap.databaseengine.apiv2.health.HeytapHealthParams;
import com.heytap.databaseengine.utils.HExecutorService;
import java.util.List;

/* compiled from: P */
@Deprecated
/* loaded from: classes2.dex */
public final class SportHealthApiImpl implements ISportHealthApi {
    @Override // com.heytap.databaseengine.apiv2.health.business.ISportHealthApi
    public <T> void query(HeytapHealthParams heytapHealthParams, HResponse<List<T>> hResponse) {
        HExecutorService.create().execute(new SportHealthQuery(new ParamPack(heytapHealthParams), hResponse));
    }
}
