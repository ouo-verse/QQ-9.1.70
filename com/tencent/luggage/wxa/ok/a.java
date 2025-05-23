package com.tencent.luggage.wxa.ok;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import com.tencent.luggage.wxa.tn.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f136555b = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "isBlockSplashHideForDebug", "isBlockSplashHideForDebug()Z", 0))};

    /* renamed from: a, reason: collision with root package name */
    public static final a f136554a = new a();

    /* renamed from: c, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.h6.i f136556c = new com.tencent.luggage.wxa.h6.i(Boolean.FALSE);

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ok.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6554a extends View.AccessibilityDelegate {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f136557a;

        public C6554a(View view) {
            this.f136557a = view;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
            Intrinsics.checkNotNullParameter(host, "host");
            Intrinsics.checkNotNullParameter(info, "info");
            super.onInitializeAccessibilityNodeInfo(host, info);
            if (info.isSelected()) {
                return;
            }
            info.setTraversalAfter(this.f136557a);
            info.setTraversalBefore(null);
        }
    }

    public final boolean a() {
        return ((Boolean) f136556c.a(this, f136555b[0])).booleanValue();
    }

    public static final void a(j jVar) {
        View view;
        if (jVar == null || (view = jVar.getView()) == null) {
            return;
        }
        Animation animation = view.getAnimation();
        if (animation != null) {
            animation.cancel();
        }
        view.animate().cancel();
        a(view);
    }

    public static final void a(View view) {
        if (view == null) {
            return;
        }
        view.setVisibility(8);
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
    }

    public static final int a(Context context, int i3) {
        int roundToInt;
        Intrinsics.checkNotNullParameter(context, "<this>");
        roundToInt = MathKt__MathJVMKt.roundToInt(context.getResources().getDisplayMetrics().density * i3);
        return roundToInt;
    }

    public static final void a(List order, View splashView) {
        Intrinsics.checkNotNullParameter(order, "order");
        Intrinsics.checkNotNullParameter(splashView, "splashView");
        AccessibilityManager accessibilityManager = (AccessibilityManager) z.c().getSystemService("accessibility");
        int i3 = 0;
        if (accessibilityManager != null ? accessibilityManager.isEnabled() : false) {
            ArrayList arrayList = new ArrayList();
            Iterator it = order.iterator();
            while (it.hasNext()) {
                View findViewById = splashView.findViewById(((Number) it.next()).intValue());
                if (findViewById != null) {
                    arrayList.add(findViewById);
                }
            }
            for (Object obj : arrayList) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                View view = (View) obj;
                view.setAccessibilityTraversalAfter(-1);
                view.setAccessibilityTraversalBefore(-1);
                if (i3 > 0) {
                    view.setAccessibilityDelegate(new C6554a((View) arrayList.get(i3 - 1)));
                }
                i3 = i16;
            }
        }
    }
}
