package com.tencent.qqlive.module.videoreport.data;

import android.support.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes22.dex */
class GlobalDataStorage {
    private static final VideoReportDataStorage<DataEntity> DATA_MAP = new VideoReportDataStorage<>();

    GlobalDataStorage() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DataEntity getData(@NonNull Object obj) {
        return DATA_MAP.getData(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setData(@NonNull Object obj, DataEntity dataEntity) {
        DATA_MAP.setData(obj, dataEntity);
    }
}
