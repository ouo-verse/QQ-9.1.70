package com.hihonor.cloudservice.support.api.entity.auth;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Scope implements Parcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    private String f36227d;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Scope createFromParcel(Parcel parcel) {
            return new Scope(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Scope[] newArray(int i3) {
            return new Scope[i3];
        }
    }

    public Scope() {
        this.f36227d = null;
    }

    public String a() {
        return this.f36227d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof Scope)) {
            return ((Scope) obj).f36227d.equals(this.f36227d);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f36227d;
        if (str == null) {
            return super.hashCode();
        }
        return str.hashCode();
    }

    public final String toString() {
        return this.f36227d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f36227d);
    }

    public Scope(String str) {
        this.f36227d = str;
    }

    protected Scope(Parcel parcel) {
        this.f36227d = parcel.readString();
    }
}
