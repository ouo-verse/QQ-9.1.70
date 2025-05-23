package com.tencent.luggage.wxa.k5;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.wxa.g6.p;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.n5.b;
import com.tencent.luggage.wxa.tn.w0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static final a f131509a = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.k5.i$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class RunnableC6359a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Context f131510a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int[] f131511b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Intent f131512c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ b.e f131513d;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.k5.i$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public static final class C6360a implements LuggageActivityHelper.d {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ b.e f131514a;

                public C6360a(b.e eVar) {
                    this.f131514a = eVar;
                }

                @Override // com.tencent.luggage.util.LuggageActivityHelper.d
                public final void a(int i3, Intent intent) {
                    i.f131509a.a(intent, this.f131514a, i3);
                }
            }

            public RunnableC6359a(Context context, int[] iArr, Intent intent, b.e eVar) {
                this.f131510a = context;
                this.f131511b = iArr;
                this.f131512c = intent;
                this.f131513d = eVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                p.a aVar = p.f126564o;
                Context context = this.f131510a;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                p b16 = aVar.b(context);
                Context context2 = this.f131510a;
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                com.tencent.luggage.wxa.g6.k g16 = b16.g(context2);
                Context context3 = this.f131510a;
                Intrinsics.checkNotNullExpressionValue(context3, "context");
                new com.tencent.luggage.wxa.l5.c(g16, context3, this.f131511b, this.f131512c, new C6360a(this.f131513d));
                g16.show();
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b implements LuggageActivityHelper.d {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b.e f131515a;

            public b(b.e eVar) {
                this.f131515a = eVar;
            }

            @Override // com.tencent.luggage.util.LuggageActivityHelper.d
            public final void a(int i3, Intent intent) {
                i.f131509a.a(intent, this.f131515a, i3);
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(v pv5, String str, String str2, String str3, boolean z16, b.e eVar) {
            Intrinsics.checkNotNullParameter(pv5, "pv");
            a(pv5, str, str2, str3, z16, null, eVar);
        }

        public final void a(v pv5, String str, String str2, String str3, boolean z16, int[] iArr, b.e eVar) {
            Intrinsics.checkNotNullParameter(pv5, "pv");
            Context context = pv5.getContext();
            Intent intent = new Intent(context, (Class<?>) j.class);
            a(intent, str, str2, str3, context, iArr);
            if (z16) {
                com.tencent.luggage.wxa.tk.l.a(new RunnableC6359a(context, iArr, intent, eVar));
                return;
            }
            p.a aVar = p.f126564o;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            aVar.b(context).a(context, intent, new b(eVar));
        }

        public final void a(Intent intent, String str, String str2, String str3, Context context, int[] iArr) {
            intent.putExtra("KEY_APPID", str);
            intent.putExtra("KEY_USERNAME", str2);
            intent.putExtra("KEY_NICKNAME", str3);
            intent.putExtra("KEY_FORCE_ACTIVITY_FULLSCREEN", com.tencent.luggage.wxa.ok.g.h(context));
            if (iArr != null) {
                intent.putExtra("KEY_MENU_VIEW_SIZE", iArr);
            }
        }

        public final void a(Intent intent, b.e eVar, int i3) {
            if (intent == null) {
                if (eVar != null) {
                    eVar.a(-1, "", 0);
                    return;
                }
                return;
            }
            String b16 = w0.b(intent.getStringExtra("KEY_AUTHORIZE_STR"), "");
            String b17 = w0.b(intent.getStringExtra("KEY_APP_SUBSCRIPTIONS_SETTING"), "");
            int intExtra = intent.getIntExtra("KEY_LOCATION_AUTH_FLAG", 0);
            if (eVar != null) {
                if (eVar instanceof b.f) {
                    ((b.f) eVar).a(i3, b16, b17, intExtra, intent.getBooleanExtra("KEY_APP_CLOSE_MENU", true));
                } else {
                    eVar.a(i3, b16, intExtra);
                }
            }
        }
    }

    public static final void a(v vVar, String str, String str2, String str3, boolean z16, b.e eVar) {
        f131509a.a(vVar, str, str2, str3, z16, eVar);
    }

    public static final void a(v vVar, String str, String str2, String str3, boolean z16, int[] iArr, b.e eVar) {
        f131509a.a(vVar, str, str2, str3, z16, iArr, eVar);
    }
}
