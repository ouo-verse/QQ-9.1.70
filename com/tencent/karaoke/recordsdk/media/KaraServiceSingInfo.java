package com.tencent.karaoke.recordsdk.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes7.dex */
public class KaraServiceSingInfo implements Parcelable {
    public static final Parcelable.Creator<KaraServiceSingInfo> CREATOR = new a();
    private int C;
    public int D;
    public boolean E;
    public boolean F;
    public int G;
    public int H;
    public int I;
    public int[] J;
    public String K;
    public boolean L;
    private boolean M;
    public boolean N;
    public String P;
    public RecordServiceFromType Q;

    /* renamed from: d, reason: collision with root package name */
    public int f116957d;

    /* renamed from: e, reason: collision with root package name */
    public String f116958e;

    /* renamed from: f, reason: collision with root package name */
    public String f116959f;

    /* renamed from: h, reason: collision with root package name */
    public String f116960h;

    /* renamed from: i, reason: collision with root package name */
    public String f116961i;

    /* renamed from: m, reason: collision with root package name */
    public String f116962m;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static class a implements Parcelable.Creator<KaraServiceSingInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public KaraServiceSingInfo createFromParcel(Parcel parcel) {
            return new KaraServiceSingInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public KaraServiceSingInfo[] newArray(int i3) {
            return new KaraServiceSingInfo[i3];
        }
    }

    public KaraServiceSingInfo() {
        this.f116958e = "";
        this.E = false;
        this.F = false;
        this.J = new int[2];
        this.L = false;
        this.M = false;
        this.N = false;
        this.P = null;
        this.Q = RecordServiceFromType.NormalRecord;
    }

    private RecordServiceFromType a(String str) {
        if (TextUtils.isEmpty(str)) {
            return RecordServiceFromType.NormalRecord;
        }
        RecordServiceFromType recordServiceFromType = RecordServiceFromType.AcapellaRecordMode;
        if (str.equals(recordServiceFromType.name())) {
            return recordServiceFromType;
        }
        return RecordServiceFromType.NormalRecord;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "KaraServiceSingInfo[SingMode:" + this.f116957d + ", ObbFilePath:" + this.f116958e + ", ObbPcmPath:" + this.f116960h + ", MicPcmPath:" + this.f116961i + ", mMicRepairPath:" + this.f116962m + ", MicPcmOffsetTime:" + this.C + ", isPcmExist:" + this.E + ", ObbDuration:" + this.G + ", SingFirstPosition:" + this.H + ", SingLastPosition:" + this.I + ", mRecordServiceFromType:" + this.Q.toString() + ", mMultiScoreConfigPath:" + this.K + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f116957d);
        parcel.writeString(this.f116958e);
        parcel.writeString(this.f116959f);
        parcel.writeString(this.f116960h);
        parcel.writeString(this.f116961i);
        parcel.writeString(this.f116962m);
        parcel.writeInt(this.D);
        parcel.writeInt(this.C);
        parcel.writeInt(this.H);
        parcel.writeInt(this.I);
        parcel.writeString(this.Q.name());
    }

    protected KaraServiceSingInfo(Parcel parcel) {
        this.f116958e = "";
        this.E = false;
        this.F = false;
        this.J = new int[2];
        this.L = false;
        this.M = false;
        this.N = false;
        this.P = null;
        this.Q = RecordServiceFromType.NormalRecord;
        this.f116957d = parcel.readInt();
        this.f116958e = parcel.readString();
        this.f116959f = parcel.readString();
        this.f116960h = parcel.readString();
        this.f116961i = parcel.readString();
        this.f116962m = parcel.readString();
        this.D = parcel.readInt();
        this.C = parcel.readInt();
        this.H = parcel.readInt();
        this.I = parcel.readInt();
        try {
            this.Q = a(parcel.readString());
        } catch (Exception unused) {
        }
    }
}
