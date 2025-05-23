package com.tencent.luggage.wxa.g5;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.luggage.wxa.sb.e;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c implements Parcelable {

    @NotNull
    public static final a CREATOR = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public boolean f126441a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f126442b;

    /* renamed from: c, reason: collision with root package name */
    public List f126443c;

    /* renamed from: d, reason: collision with root package name */
    public String f126444d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.luggage.wxa.sb.c f126445e;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable.Creator {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c[] newArray(int i3) {
            return new c[i3];
        }
    }

    public c(com.tencent.luggage.wxa.sb.c result, boolean z16) {
        String a16;
        Intrinsics.checkNotNullParameter(result, "result");
        this.f126445e = result;
        this.f126441a = result.f();
        this.f126442b = result.n();
        e j3 = result.j();
        this.f126444d = (j3 == null || (a16 = j3.a()) == null) ? "" : a16;
        ArrayList arrayList = new ArrayList();
        for (com.tencent.luggage.wxa.sb.d dVar : result.i()) {
            Parcel obtain = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
            dVar.writeToParcel(obtain, 0);
            obtain.setDataPosition(0);
            arrayList.add(new com.tencent.luggage.wxa.sb.d(obtain));
            OaidMonitor.parcelRecycle(obtain);
        }
        this.f126443c = arrayList;
    }

    public final void a(boolean z16) {
        this.f126442b = z16;
    }

    public final List b() {
        ArrayList i3;
        Object obj;
        ArrayList arrayList = new ArrayList();
        for (com.tencent.luggage.wxa.sb.d dVar : this.f126443c) {
            com.tencent.luggage.wxa.sb.c cVar = this.f126445e;
            if (cVar != null && (i3 = cVar.i()) != null) {
                Iterator it = i3.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (TextUtils.equals(((com.tencent.luggage.wxa.sb.d) obj).f(), dVar.f())) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                com.tencent.luggage.wxa.sb.d dVar2 = (com.tencent.luggage.wxa.sb.d) obj;
                if (dVar2 != null && a(dVar2, dVar)) {
                    arrayList.add(dVar);
                }
            }
        }
        return arrayList;
    }

    public final List c() {
        return this.f126443c;
    }

    public final boolean d() {
        return this.f126441a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final boolean e() {
        return this.f126442b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeByte(this.f126441a ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f126442b ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.f126443c);
        parcel.writeString(this.f126444d);
        parcel.writeParcelable(this.f126445e, i3);
    }

    public final String a() {
        return this.f126444d;
    }

    public final void a(com.tencent.luggage.wxa.sb.c result) {
        String str;
        com.tencent.luggage.wxa.sb.d dVar;
        int indexOf;
        ArrayList i3;
        Object obj;
        Intrinsics.checkNotNullParameter(result, "result");
        this.f126441a = result.f();
        this.f126442b = result.n();
        e j3 = result.j();
        if (j3 == null || (str = j3.a()) == null) {
            str = "";
        }
        this.f126444d = str;
        List a16 = a(result.i());
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f126443c);
        Iterator it = a16.iterator();
        int i16 = 0;
        while (true) {
            Object obj2 = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int i17 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            com.tencent.luggage.wxa.sb.d dVar2 = (com.tencent.luggage.wxa.sb.d) next;
            Iterator it5 = arrayList.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                Object next2 = it5.next();
                if (TextUtils.equals(((com.tencent.luggage.wxa.sb.d) next2).f(), dVar2.f())) {
                    obj2 = next2;
                    break;
                }
            }
            com.tencent.luggage.wxa.sb.d dVar3 = (com.tencent.luggage.wxa.sb.d) obj2;
            if (dVar3 != null) {
                arrayList.set(arrayList.indexOf(dVar3), dVar2);
            }
            i16 = i17;
        }
        this.f126443c = arrayList;
        for (com.tencent.luggage.wxa.sb.d dVar4 : result.i()) {
            com.tencent.luggage.wxa.sb.c cVar = this.f126445e;
            if (cVar == null || (i3 = cVar.i()) == null) {
                dVar = null;
            } else {
                Iterator it6 = i3.iterator();
                while (true) {
                    if (it6.hasNext()) {
                        obj = it6.next();
                        if (TextUtils.equals(dVar4.f(), ((com.tencent.luggage.wxa.sb.d) obj).f())) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                dVar = (com.tencent.luggage.wxa.sb.d) obj;
            }
            com.tencent.luggage.wxa.sb.c cVar2 = this.f126445e;
            Intrinsics.checkNotNull(cVar2);
            ArrayList i18 = cVar2.i();
            com.tencent.luggage.wxa.sb.c cVar3 = this.f126445e;
            Intrinsics.checkNotNull(cVar3);
            indexOf = CollectionsKt___CollectionsKt.indexOf((List<? extends com.tencent.luggage.wxa.sb.d>) ((List<? extends Object>) cVar3.i()), dVar);
            i18.set(indexOf, dVar4);
        }
    }

    public /* synthetic */ c(com.tencent.luggage.wxa.sb.c cVar, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(cVar, (i3 & 2) != 0 ? true : z16);
    }

    public c(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.f126441a = parcel.readByte() != 0;
        this.f126442b = parcel.readByte() != 0;
        ArrayList arrayList = new ArrayList();
        parcel.readTypedList(arrayList, com.tencent.luggage.wxa.sb.d.CREATOR);
        this.f126443c = arrayList;
        String readString = parcel.readString();
        this.f126444d = readString == null ? "" : readString;
        this.f126445e = (com.tencent.luggage.wxa.sb.c) parcel.readParcelable(com.tencent.luggage.wxa.sb.c.class.getClassLoader());
    }

    public final List a(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            com.tencent.luggage.wxa.sb.d dVar = (com.tencent.luggage.wxa.sb.d) it.next();
            Parcel obtain = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
            dVar.writeToParcel(obtain, 0);
            obtain.setDataPosition(0);
            arrayList2.add(new com.tencent.luggage.wxa.sb.d(obtain));
            OaidMonitor.parcelRecycle(obtain);
        }
        return arrayList2;
    }

    public final boolean a(com.tencent.luggage.wxa.sb.d dVar, com.tencent.luggage.wxa.sb.d dVar2) {
        return dVar.e() != dVar2.e();
    }
}
