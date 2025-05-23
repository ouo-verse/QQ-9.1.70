package com.tencent.luggage.wxa.o5;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.luggage.wxa.g6.d;
import com.tencent.luggage.wxa.g6.p;
import com.tencent.mobileqq.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final C6536a f136190a = new C6536a(null);

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.o5.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6536a {
        public C6536a() {
        }

        public /* synthetic */ C6536a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context ctx, DialogInterface.OnClickListener onPositiveClick, DialogInterface.OnClickListener onNegativeCLick, DialogInterface.OnCancelListener onCancelCLick) {
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            Intrinsics.checkNotNullParameter(onPositiveClick, "onPositiveClick");
            Intrinsics.checkNotNullParameter(onNegativeCLick, "onNegativeCLick");
            Intrinsics.checkNotNullParameter(onCancelCLick, "onCancelCLick");
            d e16 = p.f126564o.b(ctx).e(ctx);
            e16.a(ctx.getString(R.string.ywr));
            e16.c(ctx.getString(R.string.ywq));
            e16.b(onPositiveClick);
            e16.b(ctx.getString(R.string.f170647xd));
            e16.a(onNegativeCLick);
            e16.a(onCancelCLick);
            e16.b(false);
            e16.a();
        }
    }
}
