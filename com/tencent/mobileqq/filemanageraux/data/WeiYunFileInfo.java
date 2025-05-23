package com.tencent.mobileqq.filemanageraux.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes12.dex */
public class WeiYunFileInfo implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<WeiYunFileInfo> CREATOR;
    public String C;
    public int D;
    public String E;
    public String F;
    public String G;
    public String H;
    public String I;
    public String J;
    public boolean K;

    /* renamed from: d, reason: collision with root package name */
    public String f209603d;

    /* renamed from: e, reason: collision with root package name */
    public String f209604e;

    /* renamed from: f, reason: collision with root package name */
    public String f209605f;

    /* renamed from: h, reason: collision with root package name */
    public long f209606h;

    /* renamed from: i, reason: collision with root package name */
    public long f209607i;

    /* renamed from: m, reason: collision with root package name */
    public int f209608m;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements Parcelable.Creator<WeiYunFileInfo> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WeiYunFileInfo createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (WeiYunFileInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new WeiYunFileInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public WeiYunFileInfo[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (WeiYunFileInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new WeiYunFileInfo[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36214);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            CREATOR = new a();
        }
    }

    public WeiYunFileInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f209608m = 0;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeString(this.f209603d);
        parcel.writeString(this.f209604e);
        parcel.writeString(this.f209605f);
        parcel.writeLong(this.f209606h);
        parcel.writeLong(this.f209607i);
        parcel.writeInt(this.f209608m);
        parcel.writeString(this.C);
        parcel.writeInt(this.D);
        parcel.writeString(this.E);
        parcel.writeString(this.F);
        parcel.writeString(this.G);
        parcel.writeString(this.H);
        parcel.writeString(this.I);
        parcel.writeString(this.J);
        parcel.writeByte(this.K ? (byte) 1 : (byte) 0);
    }

    public WeiYunFileInfo(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.f209608m = 0;
        this.f209603d = parcel.readString();
        this.f209604e = parcel.readString();
        this.f209605f = parcel.readString();
        this.f209606h = parcel.readLong();
        this.f209607i = parcel.readLong();
        this.f209608m = parcel.readInt();
        this.C = parcel.readString();
        this.D = parcel.readInt();
        this.E = parcel.readString();
        this.F = parcel.readString();
        this.G = parcel.readString();
        this.H = parcel.readString();
        this.I = parcel.readString();
        this.J = parcel.readString();
        this.K = parcel.readByte() != 0;
    }
}
