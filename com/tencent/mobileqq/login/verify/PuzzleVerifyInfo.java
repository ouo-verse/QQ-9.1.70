package com.tencent.mobileqq.login.verify;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes15.dex */
public class PuzzleVerifyInfo implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<PuzzleVerifyInfo> CREATOR;
    public String C;
    public String D;
    public int E;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f242682d;

    /* renamed from: e, reason: collision with root package name */
    public String f242683e;

    /* renamed from: f, reason: collision with root package name */
    public int f242684f;

    /* renamed from: h, reason: collision with root package name */
    public int f242685h;

    /* renamed from: i, reason: collision with root package name */
    public int f242686i;

    /* renamed from: m, reason: collision with root package name */
    public String f242687m;

    /* loaded from: classes15.dex */
    class a implements Parcelable.Creator<PuzzleVerifyInfo> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PuzzleVerifyInfo createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (PuzzleVerifyInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new PuzzleVerifyInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PuzzleVerifyInfo[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (PuzzleVerifyInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new PuzzleVerifyInfo[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41228);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            CREATOR = new a();
        }
    }

    public PuzzleVerifyInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
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
        parcel.writeByteArray(this.f242682d);
        parcel.writeString(this.f242683e);
        parcel.writeInt(this.f242684f);
        parcel.writeInt(this.f242685h);
        parcel.writeInt(this.f242686i);
        parcel.writeString(this.f242687m);
        parcel.writeString(this.C);
        parcel.writeString(this.D);
        parcel.writeInt(this.E);
    }

    protected PuzzleVerifyInfo(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.f242682d = parcel.createByteArray();
        this.f242683e = parcel.readString();
        this.f242684f = parcel.readInt();
        this.f242685h = parcel.readInt();
        this.f242686i = parcel.readInt();
        this.f242687m = parcel.readString();
        this.C = parcel.readString();
        this.D = parcel.readString();
        this.E = parcel.readInt();
    }
}
