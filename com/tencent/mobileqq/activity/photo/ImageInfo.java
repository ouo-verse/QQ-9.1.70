package com.tencent.mobileqq.activity.photo;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ImageInfo extends com.tencent.mobileqq.activity.photo.a implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<ImageInfo> CREATOR;
    public String F;
    public int G;
    public String H;
    public int I;
    public int J;
    public boolean K;
    public long L;
    public boolean M;
    public boolean N;
    public boolean P;
    public String Q;
    public long R;
    public String S;
    public long T;
    public String U;
    public int V;
    public int W;
    public int X;
    public int Y;
    public String Z;

    /* renamed from: a0, reason: collision with root package name */
    public int f183965a0;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f183966b0;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f183967c0;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f183968d0;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f183969e0;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f183970f0;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f183971g0;

    /* renamed from: h0, reason: collision with root package name */
    public boolean f183972h0;

    /* renamed from: i0, reason: collision with root package name */
    public int f183973i0;

    /* renamed from: j0, reason: collision with root package name */
    public int f183974j0;

    /* renamed from: k0, reason: collision with root package name */
    public long f183975k0;

    /* renamed from: l0, reason: collision with root package name */
    public String f183976l0;

    /* renamed from: m0, reason: collision with root package name */
    public String f183977m0;

    /* renamed from: n0, reason: collision with root package name */
    public String f183978n0;

    /* renamed from: o0, reason: collision with root package name */
    public boolean f183979o0;

    /* renamed from: p0, reason: collision with root package name */
    public int f183980p0;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements Parcelable.Creator<ImageInfo> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ImageInfo createFromParcel(Parcel parcel) {
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            boolean z26;
            boolean z27;
            boolean z28;
            boolean z29;
            boolean z36;
            boolean z37;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ImageInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            ImageInfo imageInfo = new ImageInfo();
            boolean z38 = false;
            if (parcel.readInt() == 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            imageInfo.f184134d = z16;
            if (parcel.readInt() == 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            imageInfo.f184135e = z17;
            imageInfo.f184136f = parcel.readString();
            if (parcel.readInt() == 0) {
                z18 = false;
            } else {
                z18 = true;
            }
            imageInfo.f184137h = z18;
            if (parcel.readInt() == 0) {
                z19 = false;
            } else {
                z19 = true;
            }
            imageInfo.f184138i = z19;
            imageInfo.f184139m = parcel.readString();
            imageInfo.C = parcel.readString();
            imageInfo.D = parcel.readInt();
            if (parcel.readInt() == 0) {
                z26 = false;
            } else {
                z26 = true;
            }
            imageInfo.E = z26;
            imageInfo.F = parcel.readString();
            imageInfo.G = parcel.readInt();
            imageInfo.H = parcel.readString();
            imageInfo.I = parcel.readInt();
            imageInfo.J = parcel.readInt();
            if (parcel.readInt() == 0) {
                z27 = false;
            } else {
                z27 = true;
            }
            imageInfo.K = z27;
            imageInfo.L = parcel.readLong();
            if (parcel.readInt() == 0) {
                z28 = false;
            } else {
                z28 = true;
            }
            imageInfo.N = z28;
            if (parcel.readInt() == 0) {
                z29 = false;
            } else {
                z29 = true;
            }
            imageInfo.P = z29;
            imageInfo.Q = parcel.readString();
            imageInfo.R = parcel.readLong();
            imageInfo.S = parcel.readString();
            imageInfo.T = parcel.readLong();
            imageInfo.U = parcel.readString();
            imageInfo.W = parcel.readInt();
            imageInfo.W = parcel.readInt();
            imageInfo.Y = parcel.readInt();
            imageInfo.Z = parcel.readString();
            imageInfo.f183974j0 = parcel.readInt();
            if (parcel.readInt() == 1) {
                z36 = true;
            } else {
                z36 = false;
            }
            imageInfo.f183971g0 = z36;
            if (parcel.readInt() == 1) {
                z37 = true;
            } else {
                z37 = false;
            }
            imageInfo.f183970f0 = z37;
            if (parcel.readInt() == 1) {
                z38 = true;
            }
            imageInfo.f183979o0 = z38;
            imageInfo.f183975k0 = parcel.readLong();
            imageInfo.f183976l0 = parcel.readString();
            imageInfo.f183977m0 = parcel.readString();
            imageInfo.f183978n0 = parcel.readString();
            imageInfo.f183980p0 = parcel.readInt();
            return imageInfo;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ImageInfo[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ImageInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new ImageInfo[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68816);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            CREATOR = new a();
        }
    }

    public ImageInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.L = -1L;
        this.M = false;
        this.N = true;
        this.P = false;
        this.V = 54;
        this.W = -1;
        this.X = 0;
        this.Y = 0;
        this.f183966b0 = false;
        this.f183967c0 = false;
        this.f183968d0 = true;
        this.f183969e0 = false;
        this.f183970f0 = false;
        this.f183971g0 = false;
        this.f183972h0 = false;
        this.f183973i0 = 0;
        this.f183980p0 = 2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
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
        parcel.writeInt(this.f184134d ? 1 : 0);
        parcel.writeInt(this.f184135e ? 1 : 0);
        parcel.writeString(this.f184136f);
        parcel.writeInt(this.f184137h ? 1 : 0);
        parcel.writeInt(this.f184138i ? 1 : 0);
        parcel.writeString(this.f184139m);
        parcel.writeString(this.C);
        parcel.writeInt(this.D);
        parcel.writeInt(this.E ? 1 : 0);
        parcel.writeString(this.F);
        parcel.writeInt(this.G);
        parcel.writeString(this.H);
        parcel.writeInt(this.I);
        parcel.writeInt(this.J);
        parcel.writeInt(this.K ? 1 : 0);
        parcel.writeLong(this.L);
        parcel.writeInt(this.N ? 1 : 0);
        parcel.writeInt(this.P ? 1 : 0);
        parcel.writeString(this.Q);
        parcel.writeLong(this.R);
        parcel.writeString(this.S);
        parcel.writeLong(this.T);
        parcel.writeString(this.U);
        parcel.writeInt(this.W);
        parcel.writeInt(this.X);
        parcel.writeInt(this.Y);
        parcel.writeString(this.Z);
        parcel.writeInt(this.f183974j0);
        parcel.writeInt(this.f183971g0 ? 1 : 0);
        parcel.writeInt(this.f183970f0 ? 1 : 0);
        parcel.writeInt(this.f183979o0 ? 1 : 0);
        parcel.writeLong(this.f183975k0);
        parcel.writeString(this.f183976l0);
        parcel.writeString(this.f183977m0);
        parcel.writeString(this.f183978n0);
        parcel.writeInt(this.f183980p0);
    }
}
