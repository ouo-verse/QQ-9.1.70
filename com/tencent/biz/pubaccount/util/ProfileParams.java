package com.tencent.biz.pubaccount.util;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class ProfileParams implements Parcelable {
    public static final Parcelable.Creator<ProfileParams> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    String f80183d;

    /* renamed from: e, reason: collision with root package name */
    int f80184e;

    /* renamed from: f, reason: collision with root package name */
    String f80185f;

    /* renamed from: h, reason: collision with root package name */
    String f80186h;

    /* renamed from: i, reason: collision with root package name */
    String f80187i;

    /* renamed from: m, reason: collision with root package name */
    CurLoginUsr f80188m;

    /* loaded from: classes4.dex */
    public static class CurLoginUsr implements Parcelable {
        public static final Parcelable.Creator<CurLoginUsr> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        public final String f80189d;

        /* renamed from: e, reason: collision with root package name */
        public final String f80190e;

        /* loaded from: classes4.dex */
        class a implements Parcelable.Creator<CurLoginUsr> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public CurLoginUsr createFromParcel(Parcel parcel) {
                return new CurLoginUsr(parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public CurLoginUsr[] newArray(int i3) {
                return new CurLoginUsr[i3];
            }
        }

        public CurLoginUsr(String str, String str2) {
            this.f80189d = str;
            this.f80190e = str2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f80189d);
            parcel.writeString(this.f80190e);
        }
    }

    /* loaded from: classes4.dex */
    class a implements Parcelable.Creator<ProfileParams> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ProfileParams createFromParcel(Parcel parcel) {
            b bVar = new b();
            bVar.g(parcel.readString()).b(parcel.readInt()).f(parcel.readString()).e(parcel.readString()).d(parcel.readString()).c((CurLoginUsr) parcel.readParcelable(CurLoginUsr.CREATOR.getClass().getClassLoader()));
            return bVar.a();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ProfileParams[] newArray(int i3) {
            return new ProfileParams[i3];
        }
    }

    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private ProfileParams f80191a = new ProfileParams();

        public ProfileParams a() {
            return this.f80191a;
        }

        public b b(int i3) {
            this.f80191a.f80184e = i3;
            return this;
        }

        public b c(CurLoginUsr curLoginUsr) {
            this.f80191a.f80188m = curLoginUsr;
            return this;
        }

        public b d(String str) {
            this.f80191a.f80187i = str;
            return this;
        }

        public b e(String str) {
            this.f80191a.f80186h = str;
            return this;
        }

        public b f(String str) {
            this.f80191a.f80185f = str;
            return this;
        }

        public b g(String str) {
            this.f80191a.f80183d = str;
            return this;
        }
    }

    ProfileParams() {
    }

    public CurLoginUsr a() {
        return this.f80188m;
    }

    public String b() {
        CurLoginUsr curLoginUsr = this.f80188m;
        if (curLoginUsr != null) {
            return curLoginUsr.f80189d;
        }
        return null;
    }

    public String c() {
        return this.f80186h;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f80183d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f80183d);
        parcel.writeInt(this.f80184e);
        parcel.writeString(this.f80185f);
        parcel.writeString(this.f80186h);
        parcel.writeString(this.f80187i);
        parcel.writeParcelable(this.f80188m, i3);
    }
}
