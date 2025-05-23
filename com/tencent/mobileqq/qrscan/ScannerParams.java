package com.tencent.mobileqq.qrscan;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.dt.api.ScanPicData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes17.dex */
public class ScannerParams implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<ScannerParams> CREATOR;
    public boolean C;
    public int D;
    public int E;
    public String F;
    public ScannerResult G;
    public ScanPicData H;

    /* renamed from: d, reason: collision with root package name */
    public boolean f276514d;

    /* renamed from: e, reason: collision with root package name */
    public String f276515e;

    /* renamed from: f, reason: collision with root package name */
    public String f276516f;

    /* renamed from: h, reason: collision with root package name */
    public String f276517h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f276518i;

    /* renamed from: m, reason: collision with root package name */
    public boolean f276519m;

    /* loaded from: classes17.dex */
    class a implements Parcelable.Creator<ScannerParams> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ScannerParams createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ScannerParams) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new ScannerParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ScannerParams[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ScannerParams[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new ScannerParams[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24783);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            CREATOR = new a();
        }
    }

    public ScannerParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 0;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "ScannerParams { scanForResult: " + this.f276514d + "  from: " + this.f276515e + "  fromPicQRDecode: " + this.f276518i + "  detectType: " + this.E + "  preResult: " + this.F + "  preScanResult: " + this.G + "  hasCameraSysFeature: " + this.C + "  toDecodeFilePath: " + this.f276516f + "  qrPhotoPath: " + this.f276517h + " scanPicData: " + this.H + "} ";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeByte(this.f276514d ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f276515e);
        parcel.writeString(this.f276516f);
        parcel.writeByte(this.f276518i ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f276519m ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.C ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.E);
        parcel.writeString(this.F);
        parcel.writeParcelable(this.G, i3);
        parcel.writeString(this.f276517h);
        parcel.writeInt(this.D);
        parcel.writeParcelable(this.H, i3);
    }

    protected ScannerParams(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel);
            return;
        }
        this.f276514d = parcel.readByte() != 0;
        this.f276515e = parcel.readString();
        this.f276516f = parcel.readString();
        this.f276518i = parcel.readByte() != 0;
        this.f276519m = parcel.readByte() != 0;
        this.C = parcel.readByte() != 0;
        this.E = parcel.readInt();
        this.F = parcel.readString();
        this.G = (ScannerResult) parcel.readParcelable(ScannerResult.class.getClassLoader());
        this.f276517h = parcel.readString();
        this.D = parcel.readInt();
        this.H = (ScanPicData) parcel.readParcelable(ScanPicData.class.getClassLoader());
    }
}
