package com.tencent.mapsdk.internal;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class sz extends tr {
    public sz(Context context, TencentMapOptions tencentMapOptions, ViewGroup viewGroup) {
        super(context, tencentMapOptions, viewGroup);
    }

    @Override // com.tencent.mapsdk.internal.tz, com.tencent.mapsdk.internal.bq
    /* renamed from: a */
    public final VectorMap createMap(ne neVar) {
        return new sy(neVar);
    }
}
