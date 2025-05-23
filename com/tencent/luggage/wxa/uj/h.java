package com.tencent.luggage.wxa.uj;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uj.i;
import com.tencent.mm.ui.BaseActivity;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h implements i {

    /* renamed from: a, reason: collision with root package name */
    public static final a f142486a = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements LuggageActivityHelper.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2 f142487a;

        public b(Function2 function2) {
            this.f142487a = function2;
        }

        @Override // com.tencent.luggage.util.LuggageActivityHelper.d
        public final void a(int i3, Intent intent) {
            this.f142487a.invoke(Integer.valueOf(i3), intent);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements LuggageActivityHelper.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2 f142488a;

        public c(Function2 function2) {
            this.f142488a = function2;
        }

        @Override // com.tencent.luggage.util.LuggageActivityHelper.d
        public final void a(int i3, Intent intent) {
            this.f142488a.invoke(Integer.valueOf(i3), intent);
        }
    }

    @Override // com.tencent.luggage.wxa.uj.i
    public boolean L() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.uj.i
    public void a(Context context, String appId, String extDesc, q qVar, k phoneItem, i.a aVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(extDesc, "extDesc");
        Intrinsics.checkNotNullParameter(phoneItem, "phoneItem");
        new s(context, appId, qVar, extDesc, phoneItem, aVar).i();
    }

    @Override // com.tencent.luggage.wxa.uj.i
    public void c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        boolean z16 = context instanceof BaseActivity;
    }

    @Override // com.tencent.luggage.wxa.uj.i
    public void a(q report) {
        Intrinsics.checkNotNullParameter(report, "report");
        w.d("Luggage.FULL.DefaultPhoneNumberLogic", "report:" + report);
    }

    @Override // com.tencent.luggage.wxa.uj.i
    public void a(Context context, String appId, Function2 callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LuggageActivityHelper FOR = LuggageActivityHelper.FOR(context);
        Intent intent = new Intent(context, (Class<?>) m.class);
        intent.putExtra("APPID", appId);
        FOR.startActivityForResult(intent, new b(callback));
    }

    @Override // com.tencent.luggage.wxa.uj.i
    public void a(Context context, String appId, String pagePath, Function2 callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(pagePath, "pagePath");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LuggageActivityHelper FOR = LuggageActivityHelper.FOR(context);
        Intent intent = new Intent(context, (Class<?>) p.class);
        intent.putExtra("APPID", appId);
        intent.putExtra("PAGEPATH", pagePath);
        FOR.startActivityForResult(intent, new c(callback));
    }

    @Override // com.tencent.luggage.wxa.uj.i
    public void a(Context context, Function1 callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.invoke(0);
    }
}
