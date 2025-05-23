package com.tencent.luggage.wxa.n7;

import android.content.Context;
import com.tencent.luggage.wxa.bk.q;
import com.tencent.luggage.wxa.eo.g;
import com.tencent.luggage.wxa.s6.h;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.ui.b;
import com.tencent.mobileqq.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a extends com.tencent.luggage.wxa.vi.a {

    /* renamed from: c, reason: collision with root package name */
    public static final C6504a f135556c = new C6504a(null);

    /* renamed from: b, reason: collision with root package name */
    public boolean f135557b;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.n7.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6504a {
        public C6504a() {
        }

        public /* synthetic */ C6504a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a() {
        super(b.ModifyCollection.ordinal());
    }

    @Override // com.tencent.luggage.wxa.vi.a
    public void a(Context context, h pageView, com.tencent.luggage.wxa.mo.h menu, String appId) {
        String string;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pageView, "pageView");
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(appId, "appId");
        String str = pageView.getRuntime().S().G;
        int l06 = pageView.getRuntime().l0();
        try {
            com.tencent.luggage.wxa.sc.b bVar = (com.tencent.luggage.wxa.sc.b) g.a(com.tencent.luggage.wxa.sc.b.class);
            boolean a16 = bVar != null ? bVar.a(str, l06) : false;
            if (a16) {
                string = context.getString(R.string.z1q);
            } else {
                string = context.getString(R.string.z1n);
            }
            String str2 = string;
            Intrinsics.checkNotNullExpressionValue(str2, "if (added) {\n           \u2026_for_menu_item)\n        }");
            int i3 = a16 ? R.drawable.m9c : R.drawable.m9b;
            this.f135557b = a16;
            menu.add(a(), (CharSequence) str2, i3, 0, false);
        } catch (Throwable th5) {
            w.d("Luggage.MenuDelegateAddCollection", "attachTo check isCollection(" + str + ',' + l06 + ") tr=" + th5);
        }
    }

    @Override // com.tencent.luggage.wxa.vi.a
    public void a(Context context, h pageView, String str, com.tencent.luggage.wxa.ui.a aVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pageView, "pageView");
        boolean a16 = com.tencent.luggage.wxa.pk.a.a(this.f135557b, context, pageView.getRuntime().S().G, pageView.getRuntime().l0());
        q.f123029a.a(pageView, this.f135557b ? 25 : 24, (r17 & 4) != 0 ? "" : null, (r17 & 8) != 0 ? w0.d() : 0L, (r17 & 16) != 0 ? 1 : a16 ? 1 : 2, (r17 & 32) != 0 ? 0 : 0);
        if (a16) {
            this.f135557b = !this.f135557b;
            pageView.getRuntime().L1().f122986e = this.f135557b ? 1 : 2;
        }
    }
}
