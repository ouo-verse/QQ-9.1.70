package com.tencent.luggage.wxa.mb;

import com.tencent.mm.plugin.mmsight.model.MMSightCameraFrameDataCallback;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b extends com.tencent.luggage.wxa.mb.a {

    /* renamed from: o, reason: collision with root package name */
    public final MMSightCameraFrameDataCallback f134244o;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements MMSightCameraFrameDataCallback {
        public a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(com.tencent.luggage.wxa.lb.c view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.f134244o = new a();
    }

    @Override // com.tencent.luggage.wxa.mb.a
    public MMSightCameraFrameDataCallback b() {
        return this.f134244o;
    }
}
