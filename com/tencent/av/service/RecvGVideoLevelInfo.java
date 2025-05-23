package com.tencent.av.service;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class RecvGVideoLevelInfo implements Parcelable, Cloneable, Comparable<RecvGVideoLevelInfo> {
    public static final Parcelable.Creator<RecvGVideoLevelInfo> CREATOR = new a();
    public int C;
    public int D;
    public int E;
    public String F;
    public List<Medal> G;
    public long H = 0;

    /* renamed from: d, reason: collision with root package name */
    public long f74353d;

    /* renamed from: e, reason: collision with root package name */
    public int f74354e;

    /* renamed from: f, reason: collision with root package name */
    public int f74355f;

    /* renamed from: h, reason: collision with root package name */
    public int f74356h;

    /* renamed from: i, reason: collision with root package name */
    public int f74357i;

    /* renamed from: m, reason: collision with root package name */
    public int f74358m;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<RecvGVideoLevelInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RecvGVideoLevelInfo createFromParcel(Parcel parcel) {
            return new RecvGVideoLevelInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RecvGVideoLevelInfo[] newArray(int i3) {
            return new RecvGVideoLevelInfo[i3];
        }
    }

    public RecvGVideoLevelInfo(long j3, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, String str, List<Medal> list) {
        this.f74353d = j3;
        this.f74354e = i3;
        this.f74355f = i16;
        this.f74356h = i17;
        this.f74357i = i18;
        this.f74358m = i19;
        this.C = i26;
        this.D = i27;
        this.E = i28;
        this.F = str;
        this.G = list;
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(RecvGVideoLevelInfo recvGVideoLevelInfo) {
        int j3 = j();
        int j16 = recvGVideoLevelInfo.j();
        if (j3 != j16) {
            return j3 - j16;
        }
        int i3 = this.E;
        int i16 = recvGVideoLevelInfo.E;
        if (i3 != i16) {
            return i3 - i16;
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int j() {
        List<Medal> list = this.G;
        if (list == null || list.size() == 0) {
            return 0;
        }
        for (int i3 = 0; i3 < this.G.size(); i3++) {
            Medal medal = this.G.get(i3);
            if (medal.f74361f == 1) {
                return medal.f74360e;
            }
        }
        return 0;
    }

    public void k(Parcel parcel) {
        try {
            this.f74353d = parcel.readLong();
            this.f74354e = parcel.readInt();
            this.f74355f = parcel.readInt();
            this.f74356h = parcel.readInt();
            this.f74357i = parcel.readInt();
            this.f74358m = parcel.readInt();
            this.C = parcel.readInt();
            this.D = parcel.readInt();
            this.E = parcel.readInt();
            this.F = parcel.readString();
            ArrayList arrayList = new ArrayList();
            this.G = arrayList;
            parcel.readTypedList(arrayList, Medal.CREATOR);
        } catch (RuntimeException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("RecvGVideoLevelInfo", 2, "readFromParcel RuntimeException", e16);
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        try {
            parcel.writeLong(this.f74353d);
            parcel.writeInt(this.f74354e);
            parcel.writeInt(this.f74355f);
            parcel.writeInt(this.f74356h);
            parcel.writeInt(this.f74357i);
            parcel.writeInt(this.f74358m);
            parcel.writeInt(this.C);
            parcel.writeInt(this.D);
            parcel.writeInt(this.E);
            parcel.writeString(this.F);
            parcel.writeTypedList(this.G);
        } catch (RuntimeException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("RecvGVideoLevelInfo", 2, "writeToParcel RuntimeException", e16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Medal implements Parcelable {
        public static final Parcelable.Creator<Medal> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        public int f74359d;

        /* renamed from: e, reason: collision with root package name */
        public int f74360e;

        /* renamed from: f, reason: collision with root package name */
        public int f74361f;

        /* renamed from: h, reason: collision with root package name */
        public String f74362h;

        /* renamed from: i, reason: collision with root package name */
        public String f74363i;

        /* renamed from: m, reason: collision with root package name */
        public String f74364m;

        /* compiled from: P */
        /* loaded from: classes3.dex */
        class a implements Parcelable.Creator<Medal> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Medal createFromParcel(Parcel parcel) {
                return new Medal(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Medal[] newArray(int i3) {
                return new Medal[i3];
            }
        }

        public Medal(Parcel parcel) {
            a(parcel);
        }

        public void a(Parcel parcel) {
            try {
                this.f74359d = parcel.readInt();
                this.f74360e = parcel.readInt();
                this.f74361f = parcel.readInt();
                this.f74362h = parcel.readString();
                this.f74363i = parcel.readString();
                this.f74364m = parcel.readString();
            } catch (RuntimeException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("RecvGVideoLevelInfo", 2, "readFromParcel RuntimeException", e16);
                }
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            try {
                parcel.writeInt(this.f74359d);
                parcel.writeInt(this.f74360e);
                parcel.writeInt(this.f74361f);
                parcel.writeString(this.f74362h);
                parcel.writeString(this.f74363i);
                parcel.writeString(this.f74364m);
            } catch (RuntimeException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("RecvGVideoLevelInfo", 2, "writeToParcel RuntimeException", e16);
                }
            }
        }

        public Medal(int i3, int i16, int i17, String str, String str2, String str3) {
            this.f74359d = i3;
            this.f74360e = i16;
            this.f74361f = i17;
            this.f74362h = str;
            this.f74363i = str2;
            this.f74364m = str3;
        }
    }

    public RecvGVideoLevelInfo(Parcel parcel) {
        k(parcel);
    }
}
