package com.tencent.luggage.wxa.g6;

import android.view.MenuItem;
import com.tencent.luggage.util.LuggageActivityHelper;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class j extends com.tencent.luggage.wxa.ga.a implements u, com.tencent.luggage.wxa.g6.a, q, LuggageActivityHelper.g {

    /* renamed from: b, reason: collision with root package name */
    public static final a f126553b = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static /* synthetic */ boolean a(j jVar, boolean z16, int i3, Object obj) {
        obj.getClass();
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyDayNight");
    }

    @Override // android.app.Activity, com.tencent.luggage.wxa.g6.u
    public abstract void onStart();

    @Override // com.tencent.luggage.wxa.g6.u
    public /* synthetic */ void setBackBtn(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        o21.b.a(this, onMenuItemClickListener);
    }
}
