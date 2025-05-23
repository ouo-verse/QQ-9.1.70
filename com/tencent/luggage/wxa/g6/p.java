package com.tencent.luggage.wxa.g6;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import com.tencent.luggage.util.LuggageActivityHelper;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface p extends com.tencent.luggage.wxa.h1.b {

    /* renamed from: o, reason: collision with root package name */
    public static final a f126564o = a.f126565a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f126565a = new a();

        public final p a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            p c16 = c(context);
            if (c16 != null) {
                return c16;
            }
            throw new IllegalArgumentException("unknown context " + context);
        }

        public final p b(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return a(context);
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:?, code lost:
        
            return ((com.tencent.luggage.wxa.g6.q) r3).getNavigator();
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final p c(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Object obj = context;
            while (true) {
                boolean z16 = obj instanceof q;
                if (z16 || (obj instanceof Activity) || !(obj instanceof ContextWrapper)) {
                    break;
                }
                Context baseContext = ((ContextWrapper) obj).getBaseContext();
                Intrinsics.checkNotNullExpressionValue(baseContext, "context.baseContext");
                obj = baseContext;
            }
            if (obj instanceof Activity) {
                return (p) com.tencent.luggage.wxa.h1.e.a(p.class);
            }
            return null;
        }
    }

    f a(Context context, int i3, boolean z16);

    void a(Context context, Intent intent);

    void a(Context context, Intent intent, LuggageActivityHelper.d dVar);

    d e(Context context);

    ProgressDialog f(Context context);

    k g(Context context);
}
