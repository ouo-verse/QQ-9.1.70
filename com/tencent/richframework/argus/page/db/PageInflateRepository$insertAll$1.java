package com.tencent.richframework.argus.page.db;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.map.geolocation.TencentLocation;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 4, 1})
/* loaded from: classes25.dex */
final class PageInflateRepository$insertAll$1 implements Runnable {
    final /* synthetic */ List $pageInflateRecords;

    @Override // java.lang.Runnable
    public final void run() {
        InflateRecordDao inflateRecordDao;
        long currentTimeMillis = System.currentTimeMillis();
        inflateRecordDao = PageInflateRepository.INSTANCE.getInflateRecordDao();
        if (inflateRecordDao != null) {
            inflateRecordDao.insertAll(this.$pageInflateRecords);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        RFWLog.d("PageInflateRepository", RFWLog.USR, "[insertAll] pageInflateRecords: " + this.$pageInflateRecords + ", timeCost: " + currentTimeMillis2 + "ms");
    }
}
