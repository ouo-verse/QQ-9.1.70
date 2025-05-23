package com.tencent.od.app.profilecard.photo.compress;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes22.dex */
public class CompressInfo implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<CompressInfo> CREATOR;
    public String C;
    public String D;
    public int E;
    public int F;
    public int G;
    public String H;
    public boolean I;
    public boolean J;

    /* renamed from: d, reason: collision with root package name */
    public String f339479d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f339480e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f339481f;

    /* renamed from: h, reason: collision with root package name */
    public String f339482h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f339483i;

    /* renamed from: m, reason: collision with root package name */
    public String f339484m;

    /* compiled from: P */
    /* loaded from: classes22.dex */
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
            return new CompressInfo(parcel);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23249);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            CREATOR = new a();
        }
    }

    public CompressInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f339483i = true;
            this.J = false;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return 0;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "\nCompressInfo\n|-localUUID:" + this.f339479d + "\n|-isSuccess:" + this.f339480e + "\n|-isOOM:" + this.f339481f + "\n|-oomMsg:" + this.f339482h + "\n|-srcPath:" + this.f339484m + "\n|-specPath:" + this.C + "\n|-destPath:" + this.D + "\n|-picType:" + this.E + "\n|-picQuality:" + this.F + "\n|-sampleCompressCnt:" + this.G + "\n|-compressMsg:" + this.H + "\n|-isResultOriginal:" + this.I;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) parcel, i3);
        } else {
            parcel.writeBooleanArray(new boolean[]{this.f339480e, this.f339481f});
            parcel.writeString(this.f339482h);
        }
    }

    CompressInfo(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) parcel);
            return;
        }
        this.f339483i = true;
        this.J = false;
        boolean[] zArr = new boolean[2];
        parcel.readBooleanArray(zArr);
        this.f339480e = zArr[0];
        this.f339481f = zArr[1];
        this.f339482h = parcel.readString();
    }
}
