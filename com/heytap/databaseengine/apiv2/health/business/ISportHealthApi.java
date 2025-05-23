package com.heytap.databaseengine.apiv2.health.business;

import com.heytap.databaseengine.apiv2.HResponse;
import com.heytap.databaseengine.apiv2.health.HeytapHealthParams;
import java.util.List;

/* compiled from: P */
@Deprecated
/* loaded from: classes2.dex */
public interface ISportHealthApi {
    <T> void query(HeytapHealthParams heytapHealthParams, HResponse<List<T>> hResponse);
}
