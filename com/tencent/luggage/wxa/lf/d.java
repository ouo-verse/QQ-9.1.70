package com.tencent.luggage.wxa.lf;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.tb.a;
import com.tencent.luggage.wxa.wb.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d implements a.c, Parcelable {

    /* renamed from: a, reason: collision with root package name */
    public final String f133396a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.sb.b f133397b;

    /* renamed from: c, reason: collision with root package name */
    public c f133398c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f133399d;

    /* renamed from: e, reason: collision with root package name */
    public List f133400e;

    /* renamed from: f, reason: collision with root package name */
    public a.InterfaceC6874a f133401f;

    /* renamed from: g, reason: collision with root package name */
    public static final b f133395g = new b(null);

    @JvmField
    @NotNull
    public static final Parcelable.Creator<d> CREATOR = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new d(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d[] newArray(int i3) {
            return new d[i3];
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface c {
        void a(int i3, int i16, String str, com.tencent.luggage.wxa.sb.c cVar);

        void a(com.tencent.luggage.wxa.sb.c cVar);
    }

    public d(String str) {
        this.f133396a = str;
        this.f133400e = new ArrayList();
        this.f133401f = com.tencent.luggage.wxa.lf.a.f133339a;
    }

    public final void a(com.tencent.luggage.wxa.sb.b bVar) {
        this.f133397b = bVar;
    }

    public void b() {
        a.C6747a.C6748a c6748a = a.C6747a.f141209a;
        String str = this.f133396a;
        List list = this.f133400e;
        byte[] bArr = this.f133399d;
        if (bArr == null) {
            bArr = new byte[0];
        }
        a.C6747a.C6748a.a(c6748a, str, list, (a.c) this, false, bArr, this.f133397b, 8, (Object) null).a(a());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i3) {
        int i16;
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.f133396a);
        dest.writeTypedList(this.f133400e);
        byte[] bArr = this.f133399d;
        if (bArr != null) {
            i16 = bArr.length;
        } else {
            i16 = 0;
        }
        dest.writeInt(i16);
        byte[] bArr2 = this.f133399d;
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        dest.writeByteArray(bArr2);
        dest.writeParcelable(this.f133397b, i3);
    }

    public final void a(c cVar) {
        this.f133398c = cVar;
    }

    public final void a(byte[] bArr) {
        this.f133399d = bArr;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(String username, c eventListener) {
        this(username);
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        this.f133398c = eventListener;
    }

    public final void a(List value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f133400e.clear();
        this.f133400e.addAll(value);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(Parcel parcel) {
        this(String.valueOf(parcel.readString()));
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        List list = this.f133400e;
        List createTypedArrayList = parcel.createTypedArrayList(com.tencent.luggage.wxa.sb.d.CREATOR);
        list.addAll(createTypedArrayList == null ? CollectionsKt__CollectionsKt.emptyList() : createTypedArrayList);
        byte[] bArr = new byte[parcel.readInt()];
        this.f133399d = bArr;
        Intrinsics.checkNotNull(bArr);
        parcel.readByteArray(bArr);
        this.f133397b = (com.tencent.luggage.wxa.sb.b) parcel.readParcelable(com.tencent.luggage.wxa.sb.b.class.getClassLoader());
    }

    public a.InterfaceC6874a a() {
        return this.f133401f;
    }

    public void a(a.InterfaceC6874a interfaceC6874a) {
        Intrinsics.checkNotNullParameter(interfaceC6874a, "<set-?>");
        this.f133401f = interfaceC6874a;
    }

    public void a(Context context, com.tencent.luggage.wxa.sb.c result) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(result, "result");
        c cVar = this.f133398c;
        if (cVar != null) {
            cVar.a(result);
        }
    }

    @Override // com.tencent.luggage.wxa.tb.a.c
    public void a(int i3, int i16, String errMsg, com.tencent.luggage.wxa.sb.c cVar) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        c cVar2 = this.f133398c;
        if (cVar2 != null) {
            cVar2.a(i3, i16, errMsg, cVar);
        }
    }
}
