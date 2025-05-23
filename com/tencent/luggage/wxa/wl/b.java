package com.tencent.luggage.wxa.wl;

import android.view.View;
import android.view.ViewParent;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f144287a = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(View view, View view2) {
            if (view != null && view2 != null) {
                ViewParent parent = view2.getParent();
                while (view != parent) {
                    Intrinsics.checkNotNull(parent);
                    parent = parent.getParent();
                    if (parent == null) {
                    }
                }
                return true;
            }
            return false;
        }
    }

    public static final boolean a(View view, View view2) {
        return f144287a.a(view, view2);
    }
}
