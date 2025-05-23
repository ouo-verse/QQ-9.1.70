package com.tencent.mobileqq.nearby.now.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class Comments implements Parcelable {
    public static final Parcelable.Creator<Comments> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public long f252663d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f252664e;

    /* renamed from: f, reason: collision with root package name */
    public List<Comment> f252665f = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public List<Comment> f252666h = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class Comment implements Parcelable {
        public static final Parcelable.Creator<Comment> CREATOR = new a();
        public String C;
        public int D;
        public long E;
        public String F;
        public long G;
        public String H;
        public int I;
        public long J;
        public MedalInfo K;

        /* renamed from: d, reason: collision with root package name */
        public long f252667d;

        /* renamed from: e, reason: collision with root package name */
        public String f252668e;

        /* renamed from: f, reason: collision with root package name */
        public long f252669f;

        /* renamed from: h, reason: collision with root package name */
        public int f252670h;

        /* renamed from: i, reason: collision with root package name */
        public String f252671i;

        /* renamed from: m, reason: collision with root package name */
        public long f252672m;

        /* compiled from: P */
        /* loaded from: classes15.dex */
        class a implements Parcelable.Creator<Comment> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Comment createFromParcel(Parcel parcel) {
                return new Comment(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Comment[] newArray(int i3) {
                return new Comment[i3];
            }
        }

        public Comment() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return hashCode();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Comment) || this.f252667d != ((Comment) obj).f252667d) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return super.hashCode();
        }

        public String toString() {
            return super.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeParcelable(this.K, i3);
            parcel.writeLong(this.f252667d);
            parcel.writeString(this.f252668e);
            parcel.writeLong(this.f252669f);
            parcel.writeLong(this.f252672m);
            parcel.writeString(this.f252671i);
            parcel.writeString(this.C);
            parcel.writeInt(this.D);
            parcel.writeLong(this.E);
            parcel.writeLong(this.G);
            parcel.writeString(this.F);
            parcel.writeString(this.H);
            parcel.writeInt(this.I);
            parcel.writeLong(this.J);
        }

        public Comment(Parcel parcel) {
            this.K = (MedalInfo) parcel.readParcelable(MedalInfo.class.getClassLoader());
            this.f252667d = parcel.readLong();
            this.f252668e = parcel.readString();
            this.f252669f = parcel.readLong();
            this.f252670h = parcel.readInt();
            this.f252672m = parcel.readLong();
            this.f252671i = parcel.readString();
            this.C = parcel.readString();
            this.D = parcel.readInt();
            this.E = parcel.readLong();
            this.G = parcel.readLong();
            this.F = parcel.readString();
            this.H = parcel.readString();
            this.I = parcel.readInt();
            this.J = parcel.readLong();
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Parcelable.Creator<Comments> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Comments createFromParcel(Parcel parcel) {
            return new Comments(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Comments[] newArray(int i3) {
            return new Comments[i3];
        }
    }

    public Comments() {
    }

    public boolean a(Comment comment) {
        return this.f252665f.contains(comment);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f252663d);
        parcel.writeByte(this.f252664e ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.f252665f);
    }

    public Comments(Parcel parcel) {
        this.f252663d = parcel.readLong();
        this.f252664e = parcel.readByte() != 0;
        parcel.readTypedList(this.f252665f, Comment.CREATOR);
    }
}
