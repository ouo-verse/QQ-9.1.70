package com.tencent.luggage.wxa.k7;

import android.app.Activity;
import android.content.res.TypedArray;
import com.tencent.luggage.wxa.v6.c;
import com.tencent.mobileqq.R;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f extends com.tencent.luggage.wxa.l4.d {

    /* renamed from: a, reason: collision with root package name */
    public static final f f131770a = new f();

    @Override // com.tencent.luggage.wxa.l4.d, com.tencent.luggage.wxa.ok.o
    public void a(com.tencent.luggage.wxa.ic.g toEnter, Runnable runnable, com.tencent.luggage.wxa.ic.g gVar, Runnable runnable2) {
        Intrinsics.checkNotNullParameter(toEnter, "toEnter");
        if (toEnter instanceof c.f) {
            com.tencent.luggage.wxa.l4.d.a(toEnter, R.anim.f155120wq, runnable);
            if (gVar != null) {
                com.tencent.luggage.wxa.l4.d.a(gVar, R.anim.f155119wp, runnable2);
                return;
            }
            return;
        }
        super.a(toEnter, runnable, gVar, runnable2);
    }

    public final void b(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        TypedArray typedArray = null;
        try {
            typedArray = activity.obtainStyledAttributes(android.R.style.Animation.Activity, new int[]{android.R.attr.activityCloseEnterAnimation, android.R.attr.activityCloseExitAnimation});
            activity.overridePendingTransition(typedArray.getResourceId(0, 0), typedArray.getResourceId(1, 0));
        } catch (Exception unused) {
            if (typedArray == null) {
                return;
            }
        } catch (Throwable th5) {
            if (typedArray != null) {
                typedArray.recycle();
            }
            throw th5;
        }
        typedArray.recycle();
    }
}
