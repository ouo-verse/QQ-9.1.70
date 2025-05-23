package com.tencent.luggage.wxa.v4;

import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import com.tencent.luggage.wxa.ka.o;
import com.tencent.luggage.wxa.ka.r;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d extends e {

    /* renamed from: e, reason: collision with root package name */
    public static final a f143229e = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public final int f143230b;

    /* renamed from: c, reason: collision with root package name */
    public final String f143231c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f143232d = new AtomicBoolean(false);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f143233a;

        public b(Function0 function0) {
            this.f143233a = function0;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f143233a.invoke();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends Lambda implements Function0 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f143235b;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/os/Parcelable;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/luggage/wxa/v4/h;", "message", "Lcom/tencent/luggage/wxa/va/e;", "a", "(Lcom/tencent/luggage/wxa/v4/h;)Lcom/tencent/luggage/wxa/va/e;"}, k = 3, mv = {1, 7, 1})
        /* loaded from: classes8.dex */
        public static final class a<InputType, ResultType> implements r {

            /* renamed from: a, reason: collision with root package name */
            public static final a f143236a = new a();

            @Override // com.tencent.luggage.wxa.ka.r
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final com.tencent.luggage.wxa.va.e invoke(h hVar) {
                try {
                } catch (Exception e16) {
                    w.b("MicroMsg.OnWXAppResultEventSender", "IPCSyncInvokeTask error, " + Log.getStackTraceString(e16));
                }
                if (hVar == null) {
                    return com.tencent.luggage.wxa.va.e.f143316a;
                }
                w.d("MicroMsg.OnWXAppResultEventSender", "IPCSyncInvokeTask publish event, " + hVar.c());
                g gVar = new g();
                gVar.b(hVar.d());
                gVar.a(hVar.a());
                gVar.a(hVar.c());
                gVar.b(hVar.e());
                gVar.a(hVar.b());
                gVar.c();
                return com.tencent.luggage.wxa.va.e.f143316a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(h hVar) {
            super(0);
            this.f143235b = hVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.va.e invoke() {
            return (com.tencent.luggage.wxa.va.e) com.tencent.luggage.wxa.ka.b.a(d.this.b(), this.f143235b, a.f143236a);
        }
    }

    public d(int i3, String str) {
        this.f143230b = i3;
        this.f143231c = str;
    }

    public final int a() {
        return this.f143230b;
    }

    public final String b() {
        return this.f143231c;
    }

    public final void c() {
        if (!this.f143232d.getAndSet(true)) {
            a(new h(this.f143230b, 2, null, null, null, 24, null));
        }
    }

    @Override // com.tencent.luggage.wxa.v4.e
    public void a(Parcelable parcelable) {
        a(new h(this.f143230b, 1, parcelable, null, null, 24, null));
    }

    public final void a(h hVar) {
        String str = this.f143231c;
        if (str == null || str.length() == 0) {
            w.b("MicroMsg.OnWXAppResultEventSender", "sendMessage, processName empty, message:" + hVar.a());
            return;
        }
        if (!z.d(this.f143231c)) {
            w.b("MicroMsg.OnWXAppResultEventSender", "sendMessage, process dead, message:" + hVar.a());
            return;
        }
        w.d("MicroMsg.OnWXAppResultEventSender", "sendMessage, " + hVar.c());
        c cVar = new c(hVar);
        boolean a16 = o.a(this.f143231c);
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) && !a16) {
            com.tencent.luggage.wxa.zp.h.f146825d.d(new b(cVar));
        } else {
            cVar.invoke();
        }
    }
}
