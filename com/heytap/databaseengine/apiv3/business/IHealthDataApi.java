package com.heytap.databaseengine.apiv3.business;

import com.heytap.databaseengine.apiv2.HResponse;
import com.heytap.databaseengine.apiv3.DataInsertRequest;
import com.heytap.databaseengine.apiv3.DataReadRequest;
import com.heytap.databaseengine.apiv3.data.DataSet;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface IHealthDataApi {
    void insert(DataInsertRequest dataInsertRequest, HResponse<Integer> hResponse);

    void read(DataReadRequest dataReadRequest, HResponse<List<DataSet>> hResponse);
}
