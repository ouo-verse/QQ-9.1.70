package com.tencent.qzonehub.api.impl;

import android.content.Context;
import com.tencent.qzonehub.api.IQZonePadApi;
import rn.g;

/* loaded from: classes34.dex */
public class QZonePadApiImpl implements IQZonePadApi {
    @Override // com.tencent.qzonehub.api.IQZonePadApi
    public int getScreenWidth(Context context) {
        return pl.a.f426446a.o(context);
    }

    @Override // com.tencent.qzonehub.api.IQZonePadApi
    public boolean isMomentSwitchClosed() {
        return !g.d();
    }

    @Override // com.tencent.qzonehub.api.IQZonePadApi
    public boolean isPadOrFold() {
        return pl.a.f426446a.y();
    }

    @Override // com.tencent.qzonehub.api.IQZonePadApi
    public boolean shouldAdapt(Context context) {
        return pl.a.f426446a.B(context);
    }
}
