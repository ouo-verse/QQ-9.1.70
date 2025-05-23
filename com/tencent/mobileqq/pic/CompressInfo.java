package com.tencent.mobileqq.pic;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes16.dex */
public class CompressInfo implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<CompressInfo> CREATOR;
    public boolean C;
    public String D;
    public int E;
    public int F;
    public String G;
    public String H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public String P;
    public boolean Q;
    public boolean R;
    public int S;
    public boolean T;
    public ThumbWidthHeightDP U;
    public int V;

    /* renamed from: d, reason: collision with root package name */
    public String f258514d;

    /* renamed from: e, reason: collision with root package name */
    public int f258515e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f258516f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f258517h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f258518i;

    /* renamed from: m, reason: collision with root package name */
    public String f258519m;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements Parcelable.Creator<CompressInfo> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CompressInfo createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (CompressInfo) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel);
            }
            return new CompressInfo(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CompressInfo[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (CompressInfo[]) iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
            return new CompressInfo[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28944);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            CREATOR = new a();
        }
    }

    /* synthetic */ CompressInfo(Parcel parcel, a aVar) {
        this(parcel);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            return;
        }
        iPatchRedirector.redirect((short) 11, (Object) this, (Object) parcel, (Object) aVar);
    }

    public void a(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) parcel);
            return;
        }
        boolean[] zArr = new boolean[7];
        parcel.readBooleanArray(zArr);
        boolean z16 = zArr[0];
        boolean z17 = zArr[1];
        this.f258516f = z16;
        this.f258517h = z17;
        this.f258518i = zArr[2];
        this.C = zArr[3];
        this.Q = zArr[4];
        this.R = zArr[5];
        this.T = zArr[6];
        this.f258514d = parcel.readString();
        this.f258515e = parcel.readInt();
        this.f258519m = parcel.readString();
        this.D = parcel.readString();
        this.E = parcel.readInt();
        this.F = parcel.readInt();
        this.G = parcel.readString();
        this.H = parcel.readString();
        this.I = parcel.readInt();
        this.J = parcel.readInt();
        this.K = parcel.readInt();
        this.L = parcel.readInt();
        this.M = parcel.readInt();
        this.N = parcel.readInt();
        this.P = parcel.readString();
        this.S = parcel.readInt();
        this.V = parcel.readInt();
    }

    public void b(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        this.f258517h = true;
        BaseApplication context = BaseApplication.getContext();
        if (z16) {
            i3 = R.string.a7s;
        } else {
            i3 = R.string.a7o;
        }
        this.f258519m = context.getString(i3);
    }

    public void c(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.f258518i = z16;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return 0;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "\nCompressInfo\n|-localUUID:" + this.f258514d + "\n|-isSuccess:" + this.f258516f + "\n|-isOOM:" + this.f258517h + "\n|-isOOS:" + this.f258518i + "\n|-oomMsg:" + this.f258519m + "\n|-srcPath:" + this.D + "\n|-specPath:" + this.G + "\n|-destPath:" + this.H + "\n|-picType:" + this.K + "\n|-picQuality:" + this.L + "\n|-networkType:" + this.M + "\n|-sampleCompressCnt:" + this.N + "\n|-compressMsg:" + this.P + "\n|-isResultOriginal:" + this.Q + "\n|-uinType:" + this.S + "\n|-mCheckJpgQualityAndSize:" + this.T + "\n|-isOverride:" + this.R + "\n|-maxPx:" + this.V;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeBooleanArray(new boolean[]{this.f258516f, this.f258517h, this.f258518i, this.C, this.Q, this.R, this.T});
        parcel.writeString(this.f258514d);
        parcel.writeInt(this.f258515e);
        parcel.writeString(this.f258519m);
        parcel.writeString(this.D);
        parcel.writeInt(this.E);
        parcel.writeInt(this.F);
        parcel.writeString(this.G);
        parcel.writeString(this.H);
        parcel.writeInt(this.I);
        parcel.writeInt(this.J);
        parcel.writeInt(this.K);
        parcel.writeInt(this.L);
        parcel.writeInt(this.M);
        parcel.writeInt(this.N);
        parcel.writeString(this.P);
        parcel.writeInt(this.S);
        parcel.writeInt(this.V);
    }

    public CompressInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f258515e = -1;
        this.C = true;
        this.M = 2;
        this.R = false;
        this.S = -1;
        this.T = false;
    }

    public CompressInfo(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
            return;
        }
        this.f258515e = -1;
        this.C = true;
        this.M = 2;
        this.R = false;
        this.S = -1;
        this.T = false;
        this.D = str;
        this.L = i3;
    }

    public CompressInfo(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.C = true;
        this.M = 2;
        this.R = false;
        this.S = -1;
        this.T = false;
        this.D = str;
        this.L = i3;
        this.f258515e = i16;
    }

    CompressInfo(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) parcel);
            return;
        }
        this.f258515e = -1;
        this.C = true;
        this.M = 2;
        this.R = false;
        this.S = -1;
        this.T = false;
        a(parcel);
    }
}
