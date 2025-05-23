package com.tencent.luggage.wxa.no;

import android.content.Context;
import android.content.res.Resources;
import androidx.arch.core.util.Function;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static Function f135890a = new C6520a();

    /* renamed from: b, reason: collision with root package name */
    public static Function f135891b = new b();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.no.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6520a implements Function {
        @Override // androidx.arch.core.util.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Resources apply(Context context) {
            return context.getResources();
        }
    }

    public static Resources a(Context context) {
        return (Resources) f135890a.apply(context);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Function {
        @Override // androidx.arch.core.util.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String apply(String str) {
            return str;
        }
    }
}
