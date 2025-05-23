package com.tencent.mapsdk.internal;

import androidx.core.app.NotificationCompat;
import com.tencent.mapsdk.shell.events.EngineWriteDataModel;
import com.tencent.mapsdk.shell.events.ReportEvent;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class tg extends ReportEvent {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    tg(EngineWriteDataModel engineWriteDataModel) {
        super("map_engine_writeData", null);
        engineWriteDataModel.getClass();
        HashMap hashMap = new HashMap();
        this.params = hashMap;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(engineWriteDataModel.resultCode);
        hashMap.put(NotificationCompat.CATEGORY_ERROR, sb5.toString());
        Map<String, String> map = this.params;
        StringBuilder sb6 = new StringBuilder();
        sb6.append(engineWriteDataModel.totalWriteCount);
        map.put("writeCount", sb6.toString());
        Map<String, String> map2 = this.params;
        StringBuilder sb7 = new StringBuilder();
        sb7.append(engineWriteDataModel.dataSize);
        map2.put("size", sb7.toString());
        Map<String, String> map3 = this.params;
        StringBuilder sb8 = new StringBuilder();
        sb8.append(engineWriteDataModel.ptr);
        map3.put("ptr", sb8.toString());
        this.params.put("url", engineWriteDataModel.url);
    }
}
