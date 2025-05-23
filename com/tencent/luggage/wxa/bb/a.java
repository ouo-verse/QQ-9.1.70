package com.tencent.luggage.wxa.bb;

import android.os.Looper;
import android.view.View;
import com.tencent.luggage.wxa.tn.c0;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f122389a = Pattern.compile("%([0-9]+\\$|<?)([^a-zA-z%]*)([[a-zA-Z%]&&[^tT]]|[tT][a-zA-Z])");

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.bb.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class RunnableC6045a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f122390a;

        public RunnableC6045a(Function0 function0) {
            this.f122390a = function0;
        }

        @Override // java.lang.Runnable
        public final /* synthetic */ void run() {
            this.f122390a.invoke();
        }
    }

    public static final void a(Function0 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            block.invoke();
        } else {
            c0.a(new RunnableC6045a(block));
        }
    }

    public static final int[] a(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr;
    }
}
