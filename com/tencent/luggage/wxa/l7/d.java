package com.tencent.luggage.wxa.l7;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.mo.a0;
import com.tencent.luggage.wxa.q7.q;
import com.tencent.luggage.wxa.s6.h;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxaapi.WxaAppCustomActionSheetDelegate;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends com.tencent.luggage.wxa.ui.a {

    /* renamed from: m, reason: collision with root package name */
    public static final a f133104m = new a(null);

    /* renamed from: f, reason: collision with root package name */
    public final int f133105f;

    /* renamed from: g, reason: collision with root package name */
    public final String f133106g;

    /* renamed from: h, reason: collision with root package name */
    public final int f133107h;

    /* renamed from: i, reason: collision with root package name */
    public final int f133108i;

    /* renamed from: j, reason: collision with root package name */
    public Function3 f133109j;

    /* renamed from: k, reason: collision with root package name */
    public Function3 f133110k;

    /* renamed from: l, reason: collision with root package name */
    public Function2 f133111l;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function3 {

        /* renamed from: a, reason: collision with root package name */
        public static final b f133114a = new b();

        public b() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Context context, v vVar, String str) {
            Intrinsics.checkNotNullParameter(context, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(vVar, "<anonymous parameter 1>");
            Intrinsics.checkNotNullParameter(str, "<anonymous parameter 2>");
            return Boolean.TRUE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends Lambda implements Function3 {

        /* renamed from: a, reason: collision with root package name */
        public static final c f133115a = new c();

        public c() {
            super(3);
        }

        public final void a(Context context, v vVar, String str) {
            Intrinsics.checkNotNullParameter(context, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(vVar, "<anonymous parameter 1>");
            Intrinsics.checkNotNullParameter(str, "<anonymous parameter 2>");
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            a((Context) obj, (v) obj2, (String) obj3);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.l7.d$d, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6424d extends Lambda implements Function2 {
        public C6424d() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Context context, v vVar) {
            Intrinsics.checkNotNullParameter(context, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(vVar, "<anonymous parameter 1>");
            return Boolean.valueOf(d.this.d());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(int i3, String str, int i16, boolean z16, int i17, com.tencent.luggage.wxa.l7.b delegate) {
        super(i3, z16, delegate);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f133105f = i3;
        this.f133106g = str;
        this.f133107h = i16;
        this.f133108i = i17;
        this.f133109j = b.f133114a;
        this.f133110k = c.f133115a;
        this.f133111l = new C6424d();
    }

    public final void a(Context context, v pageView, String appId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pageView, "pageView");
        Intrinsics.checkNotNullParameter(appId, "appId");
        if (d()) {
            return;
        }
        this.f133110k.invoke(context, pageView, appId);
    }

    public final void b(Function3 function3) {
        Intrinsics.checkNotNullParameter(function3, "<set-?>");
        this.f133110k = function3;
    }

    public final Function3 f() {
        return this.f133109j;
    }

    public final Function2 g() {
        return this.f133111l;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.l7.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public /* synthetic */ class C6423a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f133112a;

            static {
                int[] iArr = new int[WxaAppCustomActionSheetDelegate.ActionType.values().length];
                iArr[WxaAppCustomActionSheetDelegate.ActionType.onShareAPPMessage.ordinal()] = 1;
                iArr[WxaAppCustomActionSheetDelegate.ActionType.onAddToFavorites.ordinal()] = 2;
                iArr[WxaAppCustomActionSheetDelegate.ActionType.onAddToMine.ordinal()] = 3;
                f133112a = iArr;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b extends Lambda implements Function3 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.l7.c f133113a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(com.tencent.luggage.wxa.l7.c cVar) {
                super(3);
                this.f133113a = cVar;
            }

            public final void a(Context context, h pageView, String appId) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(pageView, "pageView");
                Intrinsics.checkNotNullParameter(appId, "appId");
                q.f138021a.a(context, appId, pageView, this.f133113a);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                a((Context) obj, (h) obj2, (String) obj3);
                return Unit.INSTANCE;
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ d a(a aVar, String str, int i3, boolean z16, int i16, int i17, boolean z17, int i18, Object obj) {
            if ((i18 & 4) != 0) {
                z16 = true;
            }
            boolean z18 = z16;
            if ((i18 & 8) != 0) {
                Context c16 = z.c();
                Intrinsics.checkNotNullExpressionValue(c16, "getContext()");
                i16 = a0.b(c16, R.color.ar9);
            }
            int i19 = i16;
            if ((i18 & 16) != 0) {
                i17 = str.hashCode();
            }
            int i26 = i17;
            if ((i18 & 32) != 0) {
                z17 = false;
            }
            return aVar.a(str, i3, z18, i19, i26, z17);
        }

        public final d a(String desc, int i3, boolean z16, int i16, int i17, boolean z17) {
            Intrinsics.checkNotNullParameter(desc, "desc");
            com.tencent.luggage.wxa.l7.b bVar = new com.tencent.luggage.wxa.l7.b(i17);
            d dVar = new d(i17, desc, i3, z16, i16, bVar);
            if (z17) {
                dVar.a(true);
            }
            bVar.a(dVar);
            return dVar;
        }

        public final com.tencent.luggage.wxa.l7.c a(WxaAppCustomActionSheetDelegate.ActionItem actionStruct) {
            boolean z16;
            Intrinsics.checkNotNullParameter(actionStruct, "actionStruct");
            int i3 = actionStruct.f146880i | ITVKAsset.VOD_ASSET_MASK_BIT;
            com.tencent.luggage.wxa.l7.b bVar = new com.tencent.luggage.wxa.l7.b(i3);
            com.tencent.luggage.wxa.l7.c cVar = new com.tencent.luggage.wxa.l7.c(actionStruct, i3, actionStruct.f146877e, actionStruct.f146879h, actionStruct.f146878f, bVar);
            int i16 = C6423a.f133112a[cVar.l().ordinal()];
            if (i16 == 1) {
                z16 = true;
            } else {
                if (i16 != 2 && i16 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                z16 = false;
            }
            if (z16) {
                cVar.a(true);
            }
            bVar.a(cVar);
            cVar.b(new b(cVar));
            return cVar;
        }
    }

    public final void a(Context context, v pageView, com.tencent.luggage.wxa.mo.h menu, String appId) {
        Bitmap a16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pageView, "pageView");
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(appId, "appId");
        if (((Boolean) this.f133109j.invoke(context, pageView, appId)).booleanValue()) {
            if (this instanceof com.tencent.luggage.wxa.l7.c) {
                com.tencent.luggage.wxa.l7.c cVar = (com.tencent.luggage.wxa.l7.c) this;
                String k3 = cVar.k();
                if (!(k3 == null || k3.length() == 0) && (a16 = com.tencent.luggage.wxa.l7.a.f133099a.a(cVar.k())) != null && !a16.isRecycled()) {
                    menu.add(this.f133105f, this.f133106g, "", new com.tencent.luggage.wxa.pb.c(Resources.getSystem(), a16), this.f133108i, ((Boolean) this.f133111l.invoke(context, pageView)).booleanValue());
                    return;
                }
            }
            menu.add(this.f133105f, this.f133106g, this.f133107h, this.f133108i, ((Boolean) this.f133111l.invoke(context, pageView)).booleanValue());
        }
    }

    public final void a(Function3 function3) {
        Intrinsics.checkNotNullParameter(function3, "<set-?>");
        this.f133109j = function3;
    }

    public final void a(Function2 function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.f133111l = function2;
    }
}
