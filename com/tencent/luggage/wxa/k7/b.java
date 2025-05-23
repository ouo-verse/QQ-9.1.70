package com.tencent.luggage.wxa.k7;

import android.content.res.Resources;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b extends com.tencent.luggage.wxa.il.a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f131756b = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Resources resources) {
        super(resources);
        Intrinsics.checkNotNullParameter(resources, "resources");
    }

    @Override // com.tencent.luggage.wxa.il.a, android.content.res.Resources
    public int getColor(int i3, Resources.Theme theme) {
        if (i3 == R.color.ajr) {
            w.f("Luggage.WxaAdaptiveResourceWrapper", "getColor: hack here! R.color.transparent -> Color.TRANSPARENT");
            return 0;
        }
        return super.getColor(i3, theme);
    }

    @Override // com.tencent.luggage.wxa.il.a, android.content.res.Resources
    public int getColor(int i3) {
        if (i3 == R.color.ajr) {
            w.f("Luggage.WxaAdaptiveResourceWrapper", "getColor: hack here! R.color.transparent -> Color.TRANSPARENT");
            return 0;
        }
        return super.getColor(i3);
    }
}
