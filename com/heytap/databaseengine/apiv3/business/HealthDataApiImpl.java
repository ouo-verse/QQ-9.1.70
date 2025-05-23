package com.heytap.databaseengine.apiv3.business;

import com.heytap.databaseengine.apiv2.HResponse;
import com.heytap.databaseengine.apiv3.DataInsertRequest;
import com.heytap.databaseengine.apiv3.DataReadRequest;
import com.heytap.databaseengine.apiv3.data.DataSet;
import com.heytap.databaseengine.utils.HExecutorService;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HealthDataApiImpl implements IHealthDataApi {
    @Override // com.heytap.databaseengine.apiv3.business.IHealthDataApi
    public void insert(DataInsertRequest dataInsertRequest, HResponse<Integer> hResponse) {
        HExecutorService.create().execute(new HealthDataInsert(dataInsertRequest, hResponse));
    }

    @Override // com.heytap.databaseengine.apiv3.business.IHealthDataApi
    public void read(DataReadRequest dataReadRequest, HResponse<List<DataSet>> hResponse) {
        HExecutorService.create().execute(new HealthDataRead(dataReadRequest, hResponse));
    }
}
