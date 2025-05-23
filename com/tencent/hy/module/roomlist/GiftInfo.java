package com.tencent.hy.module.roomlist;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class GiftInfo implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<GiftInfo> CREATOR;
    public long C;
    public String D;
    public String E;
    public String F;
    public String G;
    public String H;
    public int I;
    public int J;
    public int K;
    public String L;
    public int M;
    public int N;
    public long P;
    public int Q;
    public String R;
    public int S;
    public int T;
    public int U;
    public List<Object> V;
    public boolean W;
    public boolean X;
    public int Y;
    public int Z;

    /* renamed from: d, reason: collision with root package name */
    public long f114725d;

    /* renamed from: e, reason: collision with root package name */
    public String f114726e;

    /* renamed from: f, reason: collision with root package name */
    public int f114727f;

    /* renamed from: h, reason: collision with root package name */
    public int f114728h;

    /* renamed from: i, reason: collision with root package name */
    public int f114729i;

    /* renamed from: m, reason: collision with root package name */
    public boolean f114730m;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a implements Parcelable.Creator<GiftInfo> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GiftInfo createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (GiftInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new GiftInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GiftInfo[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (GiftInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new GiftInfo[0];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20131);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            CREATOR = new a();
        }
    }

    public GiftInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.T = 0;
        this.Y = 0;
        this.Z = 0;
    }

    private boolean a(GiftInfo giftInfo) {
        String str = this.D;
        if (str == null ? giftInfo.D != null : !str.equals(giftInfo.D)) {
            return true;
        }
        String str2 = this.E;
        if (str2 == null ? giftInfo.E != null : !str2.equals(giftInfo.E)) {
            return true;
        }
        String str3 = this.F;
        if (str3 == null ? giftInfo.F != null : !str3.equals(giftInfo.F)) {
            return true;
        }
        String str4 = this.G;
        if (str4 == null ? giftInfo.G != null : !str4.equals(giftInfo.G)) {
            return true;
        }
        String str5 = this.H;
        if (str5 == null ? giftInfo.H != null : !str5.equals(giftInfo.H)) {
            return true;
        }
        if (this.M != giftInfo.M || this.N != giftInfo.N || this.P != giftInfo.P || this.Q != giftInfo.Q || this.W != giftInfo.W || this.X != giftInfo.X || this.Z != giftInfo.Z) {
            return true;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GiftInfo giftInfo = (GiftInfo) obj;
        if (this.f114725d != giftInfo.f114725d || this.f114727f != giftInfo.f114727f || this.f114728h != giftInfo.f114728h || this.f114729i != giftInfo.f114729i || this.f114730m != giftInfo.f114730m || this.J != giftInfo.J || this.K != giftInfo.K || this.S != giftInfo.S || this.T != giftInfo.T || this.U != giftInfo.U || a(giftInfo)) {
            return false;
        }
        String str = this.L;
        String str2 = giftInfo.L;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        long j3 = this.f114725d;
        int i19 = ((((((((((int) (j3 ^ (j3 >>> 32))) * 31) + this.f114727f) * 31) + this.f114728h) * 31) + this.f114729i) * 31) + (this.f114730m ? 1 : 0)) * 31;
        String str = this.D;
        int i26 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i27 = (i19 + i3) * 31;
        String str2 = this.F;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i28 = (i27 + i16) * 31;
        String str3 = this.G;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i29 = (i28 + i17) * 31;
        String str4 = this.H;
        if (str4 != null) {
            i18 = str4.hashCode();
        } else {
            i18 = 0;
        }
        int i36 = (((((i29 + i18) * 31) + this.J) * 31) + this.K) * 31;
        String str5 = this.L;
        if (str5 != null) {
            i26 = str5.hashCode();
        }
        int i37 = (((((((((((i36 + i26) * 31) + this.S) * 31) + this.T) * 31) + this.U) * 31) + this.M) * 31) + this.N) * 31;
        long j16 = this.P;
        return i37 + ((int) ((j16 >>> 32) ^ j16));
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "GiftInfo{id=" + this.f114725d + ", name='" + this.f114726e + "', price=" + this.f114727f + ", defaultCount=" + this.f114728h + ", priority=" + this.f114729i + ", visible=" + this.f114730m + ", timestamp=" + this.C + ", middleIcon='" + this.D + "', bigIcon='" + this.E + "', smallIcon='" + this.F + "', apngUrl='" + this.G + "', effectId='" + this.H + "', duration=" + this.I + ", effectNum=" + this.J + ", comboGradientIndex=" + this.K + ", activeIcon='" + this.L + "', nobelType=" + this.M + ", effectType=" + this.N + ", gameType=" + this.P + ", comment='" + this.R + "', repositoryGiftNum=" + this.S + ", fromType=" + this.T + ", type=" + this.U + ", hideGiftType=" + this.Q + ", effectList=" + this.V + ", giftUsage=" + this.Z + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeLong(this.f114725d);
        parcel.writeString(this.f114726e);
        parcel.writeInt(this.f114727f);
        parcel.writeInt(this.f114728h);
        parcel.writeInt(this.f114729i);
        parcel.writeByte(this.f114730m ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.C);
        parcel.writeString(this.D);
        parcel.writeInt(this.U);
        parcel.writeInt(this.M);
        parcel.writeInt(this.N);
        parcel.writeLong(this.P);
    }

    GiftInfo(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel);
            return;
        }
        this.T = 0;
        this.Y = 0;
        this.Z = 0;
        this.f114725d = parcel.readLong();
        this.f114726e = parcel.readString();
        this.f114727f = parcel.readInt();
        this.f114728h = parcel.readInt();
        this.f114729i = parcel.readInt();
        this.f114730m = parcel.readByte() != 0;
        this.C = parcel.readLong();
        this.D = parcel.readString();
        this.U = parcel.readInt();
        this.M = parcel.readInt();
        this.N = parcel.readInt();
        this.P = parcel.readLong();
    }
}
