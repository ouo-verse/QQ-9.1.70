package com.tencent.luggage.wxa.wb;

import android.os.Parcelable;
import android.os.Process;
import com.tencent.luggage.wxa.zp.h;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    public final Lazy f144163a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.this.f();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.wb.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class RunnableC6877b implements Runnable {
        public RunnableC6877b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.this.g();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends Lambda implements Function0 {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(Process.myPid());
            sb5.append(util.base64_pad_url);
            sb5.append(b.this.hashCode());
            return sb5.toString();
        }
    }

    public b() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new c());
        this.f144163a = lazy;
    }

    public final void a() {
        h.f146825d.b(new a(), "CompatProcessTask_" + c());
    }

    public final void b() {
        h.f146825d.b(new RunnableC6877b(), "CompatProcessTask_" + c());
    }

    public final String c() {
        return (String) this.f144163a.getValue();
    }

    public abstract void f();

    public abstract void g();

    public final void d() {
    }

    public final void e() {
    }
}
