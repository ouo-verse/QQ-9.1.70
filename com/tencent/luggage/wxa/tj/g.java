package com.tencent.luggage.wxa.tj;

import android.content.Context;
import com.tencent.luggage.wxa.ml.r;
import com.tencent.luggage.wxa.tn.f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final a f141492a = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(com.tencent.luggage.wxa.ic.d mComponent) {
            Intrinsics.checkNotNullParameter(mComponent, "mComponent");
            f0 e16 = f0.e();
            if (!e16.getBoolean("has_ever_show_wmpf_voip_call_in_scope_auth_notify_bottom_sheet", false)) {
                r H = mComponent.getRuntime().H();
                Context context = mComponent.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "mComponent.context");
                H.a(new f(context));
                e16.putBoolean("has_ever_show_wmpf_voip_call_in_scope_auth_notify_bottom_sheet", true);
            }
        }
    }

    public static final void a(com.tencent.luggage.wxa.ic.d dVar) {
        f141492a.a(dVar);
    }
}
