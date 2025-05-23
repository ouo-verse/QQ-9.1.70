package com.tencent.qqlive.module.videoreport.dtreport.audio.data;

import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.data.VideoReportDataStorage;

/* compiled from: P */
/* loaded from: classes22.dex */
class AudioDataStorage {
    private static final VideoReportDataStorage<AudioEntity> DATA_MAP = new VideoReportDataStorage<>();

    AudioDataStorage() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AudioEntity getData(@NonNull Object obj) {
        return DATA_MAP.getData(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setData(@NonNull Object obj, @NonNull AudioEntity audioEntity) {
        DATA_MAP.setData(obj, audioEntity);
    }
}
