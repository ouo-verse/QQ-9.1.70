package com.tencent.qzonehub.api.impl;

import NS_UNDEAL_COUNT.count_info;
import com.qzone.reborn.albumx.qzone.local.l;
import com.qzone.reborn.configx.g;
import com.tencent.qzonehub.api.IQzoneUndealCountApi;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes34.dex */
public class QzoneUndealCountApiImpl implements IQzoneUndealCountApi {
    @Override // com.tencent.qzonehub.api.IQzoneUndealCountApi
    public void handleRecommendPhotoConfig(Map<Integer, count_info> map) {
        l.f52668a.e(map);
    }

    @Override // com.tencent.qzonehub.api.IQzoneUndealCountApi
    public boolean isShowQZoneIntimateSpaceEntrance() {
        return g.f53821a.h().F();
    }

    @Override // com.tencent.qzonehub.api.IQzoneUndealCountApi
    public void recordQZoneShowIntimateSpaceMessageTab() {
        g.f53821a.h().H();
    }
}
