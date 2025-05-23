package com.tencent.qzonehub.api.impl;

import com.tencent.qzonehub.api.IQZoneJustLocationApi;
import cooperation.qzone.LbsDataV2;

/* compiled from: P */
/* loaded from: classes34.dex */
public class QZoneJustLocationApiImpl implements IQZoneJustLocationApi {
    @Override // com.tencent.qzonehub.api.IQZoneJustLocationApi
    public LbsDataV2.GpsInfo getCurrGps(String str) {
        return ez3.b.b(str).a();
    }
}
