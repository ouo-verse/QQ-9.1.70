package com.tencent.luggage.wxa.l7;

import android.content.Context;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.mo.h;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b extends com.tencent.luggage.wxa.vi.a {

    /* renamed from: b, reason: collision with root package name */
    public d f133101b;

    public b(int i3) {
        super(i3);
    }

    public final void a(d dVar) {
        this.f133101b = dVar;
    }

    @Override // com.tencent.luggage.wxa.vi.a
    public void a(Context context, v pageView, String appId, com.tencent.luggage.wxa.ui.a menuInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pageView, "pageView");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(menuInfo, "menuInfo");
        d dVar = this.f133101b;
        if (dVar != null) {
            dVar.a(context, pageView, appId);
        }
    }

    @Override // com.tencent.luggage.wxa.vi.a
    public void a(Context context, v pageView, h menu, String appId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pageView, "pageView");
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(appId, "appId");
        d dVar = this.f133101b;
        if (dVar != null) {
            dVar.a(context, pageView, menu, appId);
        }
    }
}
