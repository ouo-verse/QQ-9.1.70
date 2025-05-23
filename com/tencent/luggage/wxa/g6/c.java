package com.tencent.luggage.wxa.g6;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog;
import com.tencent.mm.ui.widget.dialog.MMBottomSheet;
import kotlin.jvm.internal.Intrinsics;
import org.joor.Reflect;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c implements p {

    /* renamed from: a, reason: collision with root package name */
    public static final c f126467a = new c();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements f {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MMBottomSheet f126468a;

        public a(MMBottomSheet mMBottomSheet) {
            this.f126468a = mMBottomSheet;
        }

        @Override // com.tencent.luggage.wxa.g6.f
        public void a(View view) {
            this.f126468a.setTitleView(view);
        }

        @Override // com.tencent.luggage.wxa.g6.f
        public void a(com.tencent.luggage.wxa.mo.p pVar) {
            this.f126468a.setOnCreateMenuListener(pVar);
        }

        @Override // com.tencent.luggage.wxa.g6.f
        public void a(com.tencent.luggage.wxa.mo.u uVar) {
            this.f126468a.setOnMenuSelectedListener(uVar);
        }

        @Override // com.tencent.luggage.wxa.g6.f
        public void a() {
            this.f126468a.tryShow();
        }
    }

    public final Intent a(Intent intent, boolean z16) {
        ComponentName component = intent.getComponent();
        Intrinsics.checkNotNull(component);
        String className = component.getClassName();
        Intrinsics.checkNotNullExpressionValue(className, "intent.component!!.className");
        Class<?> cls = Class.forName(className);
        if (Activity.class.isAssignableFrom(cls)) {
            if (z16) {
                intent.addFlags(268435456);
            }
        } else if (r.class.isAssignableFrom(cls)) {
            ComponentName component2 = intent.getComponent();
            Intrinsics.checkNotNull(component2);
            intent.setClassName(component2.getPackageName(), ((Class) Reflect.on(cls).get("ACTIVITY_CLASS")).getName());
        } else {
            throw new IllegalArgumentException("intent component class is not either Activity nor UIPage");
        }
        return intent;
    }

    @Override // com.tencent.luggage.wxa.g6.p
    public d e(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new d(new MMAlertDialog(context));
    }

    @Override // com.tencent.luggage.wxa.g6.p
    public ProgressDialog f(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new b(context);
    }

    @Override // com.tencent.luggage.wxa.g6.p
    public k g(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new m(context, 0, 2, null);
    }

    @Override // com.tencent.luggage.wxa.g6.p
    public void a(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intent a16 = a(intent, !(context instanceof Activity));
        com.tencent.luggage.wxa.fa.b.a(context, a16);
        context.startActivity(a16);
    }

    @Override // com.tencent.luggage.wxa.g6.p
    public void a(Context context, Intent intent, LuggageActivityHelper.d resultCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
        LuggageActivityHelper.FOR(context).startActivityForResult(a(intent, !(context instanceof Activity)), resultCallback);
    }

    @Override // com.tencent.luggage.wxa.g6.p
    public f a(Context context, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new a(new MMBottomSheet(context, i3, z16));
    }
}
