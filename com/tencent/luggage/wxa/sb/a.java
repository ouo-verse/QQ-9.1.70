package com.tencent.luggage.wxa.sb;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    public int f140221a;

    /* renamed from: b, reason: collision with root package name */
    public String f140222b;

    /* renamed from: c, reason: collision with root package name */
    public String f140223c;

    /* renamed from: d, reason: collision with root package name */
    public static final b f140220d = new b(null);

    @JvmField
    @NotNull
    public static final Parcelable.Creator<a> CREATOR = new C6710a();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.sb.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6710a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i3) {
            return new a[i3];
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

    public a(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.f140221a = parcel.readInt();
        String readString = parcel.readString();
        this.f140222b = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.f140223c = readString2 != null ? readString2 : "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.f140221a);
        parcel.writeString(this.f140222b);
        parcel.writeString(this.f140223c);
    }

    public a(int i3, String title, String content) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content, "content");
        this.f140221a = i3;
        this.f140222b = title;
        this.f140223c = content;
    }
}
