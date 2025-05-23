package com.tencent.hy.module.room;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.hy.kernel.account.VipInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class AnchorInfo implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<AnchorInfo> CREATOR;
    public String C;
    public long D;
    public int E;
    public int F;
    public boolean G;
    public int H;
    public int I;
    public long J;
    public long K;
    public List<LiveVideoInfo> L;
    public boolean M;
    public int N;
    public int P;
    public long Q;
    public long R;
    public VipInfo S;
    public long T;

    /* renamed from: d, reason: collision with root package name */
    public long f114715d;

    /* renamed from: e, reason: collision with root package name */
    public int f114716e;

    /* renamed from: f, reason: collision with root package name */
    public int f114717f;

    /* renamed from: h, reason: collision with root package name */
    public long f114718h;

    /* renamed from: i, reason: collision with root package name */
    public String f114719i;

    /* renamed from: m, reason: collision with root package name */
    public String f114720m;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a implements Parcelable.Creator<AnchorInfo> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AnchorInfo createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (AnchorInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new AnchorInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AnchorInfo[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (AnchorInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new AnchorInfo[0];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20094);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            CREATOR = new a();
        }
    }

    public AnchorInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f114719i = "";
        this.f114720m = "";
        this.C = "";
        this.J = 0L;
        this.K = 0L;
        this.L = new ArrayList();
        this.M = false;
        this.N = 0;
        this.S = new VipInfo();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeLong(this.f114715d);
        parcel.writeInt(this.f114716e);
        parcel.writeInt(this.f114717f);
        parcel.writeLong(this.f114718h);
        parcel.writeString(this.f114719i);
        parcel.writeString(this.f114720m);
        parcel.writeLong(this.D);
        parcel.writeInt(this.E);
        parcel.writeInt(this.F);
        parcel.writeByte(this.G ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.H);
        parcel.writeInt(this.I);
        parcel.writeTypedList(this.L);
        parcel.writeByte(this.M ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.P);
        parcel.writeLong(this.Q);
        parcel.writeLong(this.R);
        parcel.writeParcelable(this.S, i3);
        parcel.writeLong(this.T);
    }

    AnchorInfo(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.f114719i = "";
        this.f114720m = "";
        this.C = "";
        this.J = 0L;
        this.K = 0L;
        this.L = new ArrayList();
        this.M = false;
        this.N = 0;
        this.S = new VipInfo();
        this.f114715d = parcel.readLong();
        this.f114716e = parcel.readInt();
        this.f114717f = parcel.readInt();
        this.f114718h = parcel.readLong();
        this.f114719i = parcel.readString();
        this.f114720m = parcel.readString();
        this.D = parcel.readLong();
        this.E = parcel.readInt();
        this.F = parcel.readInt();
        this.G = parcel.readByte() != 0;
        this.H = parcel.readInt();
        this.I = parcel.readInt();
        parcel.readTypedList(this.L, LiveVideoInfo.CREATOR);
        this.M = parcel.readByte() != 0;
        this.P = parcel.readInt();
        this.Q = parcel.readLong();
        this.R = parcel.readLong();
        this.S = (VipInfo) parcel.readParcelable(VipInfo.class.getClassLoader());
        this.T = parcel.readLong();
    }
}
