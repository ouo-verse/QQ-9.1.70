package com.tencent.luggage.sdk.launching;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.v4.c;
import com.tencent.luggage.wxa.v4.d;
import com.tencent.luggage.wxa.v4.e;
import com.tencent.luggage.wxa.v4.g;
import com.tencent.luggage.wxa.z8.b;
import com.tencent.mm.sdk.event.IListener;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class OnWXAppResultXPCLeakFreeWrapper {

    /* renamed from: a, reason: collision with root package name */
    public static final OnWXAppResultXPCLeakFreeWrapper f120260a = new OnWXAppResultXPCLeakFreeWrapper();

    /* loaded from: classes2.dex */
    public static final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OnWXAppResultXPCLeakFreeWrapper$writeToParcel$eventListener$1 f120261a;

        public a(OnWXAppResultXPCLeakFreeWrapper$writeToParcel$eventListener$1 onWXAppResultXPCLeakFreeWrapper$writeToParcel$eventListener$1) {
            this.f120261a = onWXAppResultXPCLeakFreeWrapper$writeToParcel$eventListener$1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            dead();
        }
    }

    public static final void a(e eVar, Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        a(eVar, parcel, 0, 4, null);
    }

    public static /* synthetic */ void a(e eVar, Parcel parcel, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        a(eVar, parcel, i3);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.tencent.mm.sdk.event.IListener, com.tencent.luggage.sdk.launching.OnWXAppResultXPCLeakFreeWrapper$writeToParcel$eventListener$1] */
    public static final void a(final e eVar, Parcel parcel, int i3) {
        c cVar;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        if (eVar == null) {
            cVar = null;
        } else if (eVar instanceof d) {
            d dVar = (d) eVar;
            cVar = new c(dVar.a(), dVar.b());
        } else {
            final int hash = Objects.hash(Integer.valueOf(eVar.hashCode()), Long.valueOf(System.currentTimeMillis()));
            final b bVar = b.f146383a;
            ?? r26 = new IListener<g>(bVar) { // from class: com.tencent.luggage.sdk.launching.OnWXAppResultXPCLeakFreeWrapper$writeToParcel$eventListener$1
                @Override // com.tencent.mm.sdk.event.IListener
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public boolean callback(g event) {
                    Intrinsics.checkNotNullParameter(event, "event");
                    w.d("MicroMsg.OnWXAppResultEventSender", "OnWXAppResultLocalEvent instance:" + event.f() + ", action:" + event.d() + ", data:" + event.e());
                    if (hash != event.f()) {
                        return false;
                    }
                    int d16 = event.d();
                    if (d16 != 1) {
                        if (d16 != 2) {
                            return false;
                        }
                        dead();
                    } else {
                        e eVar2 = eVar;
                        Parcelable e16 = event.e();
                        if (!(e16 instanceof Parcelable)) {
                            e16 = null;
                        }
                        eVar2.a(e16);
                    }
                    return true;
                }
            };
            r26.alive();
            c cVar2 = new c(hash, z.i());
            eVar.a(new a(r26));
            cVar = cVar2;
        }
        parcel.writeParcelable(cVar, i3);
    }

    public static final e a(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        c cVar = (c) parcel.readParcelable(c.class.getClassLoader());
        if (cVar == null) {
            return null;
        }
        return new d(cVar.a(), cVar.b());
    }

    public static final void a(e eVar) {
        d dVar = eVar instanceof d ? (d) eVar : null;
        if (dVar != null) {
            dVar.c();
        }
    }
}
