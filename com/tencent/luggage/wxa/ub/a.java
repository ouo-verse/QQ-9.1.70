package com.tencent.luggage.wxa.ub;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.vas.qid.QidPagView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final C6791a f142165a = new C6791a(null);

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ub.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6791a {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.ub.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6792a extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ View f142166a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Context f142167b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C6792a(View view, Context context) {
                super(0);
                this.f142166a = view;
                this.f142167b = context;
            }

            public final void a() {
                int d16;
                ViewGroup.LayoutParams layoutParams = this.f142166a.getLayoutParams();
                Context context = this.f142167b;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                d16 = b.d(context, this.f142166a.getMeasuredWidth());
                layoutParams.width = d16;
                b.b(this.f142166a);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        public C6791a() {
        }

        public /* synthetic */ C6791a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(int i3, View dialogRootView) {
            int c16;
            boolean b16;
            Intrinsics.checkNotNullParameter(dialogRootView, "dialogRootView");
            Context context = dialogRootView.getContext();
            if (i3 != 1 && i3 != 3) {
                Intrinsics.checkNotNullExpressionValue(context, "context");
                b16 = b.b(context);
                if (b16) {
                    b.b(dialogRootView, new C6792a(dialogRootView, context));
                    return;
                }
                ViewGroup.LayoutParams layoutParams = dialogRootView.getLayoutParams();
                layoutParams.width = -1;
                dialogRootView.setLayoutParams(layoutParams);
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = dialogRootView.getLayoutParams();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            c16 = b.c(context, QidPagView.DESIGN_PAG_WIDTH);
            layoutParams2.width = c16;
            dialogRootView.setLayoutParams(layoutParams2);
        }
    }
}
