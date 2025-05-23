package com.tencent.mobileqq.pad;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes16.dex */
public class LaunchParam implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<LaunchParam> CREATOR;
    private int C;
    private final boolean D;
    private final boolean E;
    private final String F;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f257073d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f257074e;

    /* renamed from: f, reason: collision with root package name */
    private final LaunchMode f257075f;

    /* renamed from: h, reason: collision with root package name */
    private final int f257076h;

    /* renamed from: i, reason: collision with root package name */
    private final int f257077i;

    /* renamed from: m, reason: collision with root package name */
    private int f257078m;

    /* loaded from: classes16.dex */
    class a implements Parcelable.Creator<LaunchParam> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LaunchParam createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (LaunchParam) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new LaunchParam(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public LaunchParam[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (LaunchParam[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new LaunchParam[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44397);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            CREATOR = new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LaunchParam(boolean z16, boolean z17, LaunchMode launchMode, int i3, int i16, int i17, int i18, boolean z18, boolean z19, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), Boolean.valueOf(z17), launchMode, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z18), Boolean.valueOf(z19), str);
            return;
        }
        this.f257073d = z16;
        this.f257074e = z17;
        this.f257075f = launchMode;
        this.f257076h = i3;
        this.f257077i = i16;
        this.f257078m = i17;
        this.C = i18;
        this.D = z18;
        this.E = z19;
        this.F = str;
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.f257076h;
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f257077i;
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.F;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return 0;
    }

    public LaunchMode e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LaunchMode) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f257075f;
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f257078m;
    }

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.C;
    }

    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.E;
    }

    public boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.f257074e;
    }

    public boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.D;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return "LaunchParam{isAddToNavigationZone=" + this.f257073d + ", isNeedClearOtherFragment=" + this.f257074e + ", launchMode=" + this.f257075f + ", enterAnim=" + this.f257076h + ", exitAnim=" + this.f257077i + ", popEnterAnim=" + this.f257078m + ", popExitAnim=" + this.C + ", supreme=" + this.D + ", isCoverOnExistFragment=" + this.E + ", fragmentId=" + this.F + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeByte(this.f257073d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f257074e ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.f257075f, i3);
        parcel.writeInt(this.f257076h);
        parcel.writeInt(this.f257077i);
        parcel.writeInt(this.f257078m);
        parcel.writeInt(this.C);
        parcel.writeByte(this.D ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.E ? (byte) 1 : (byte) 0);
        String str = this.F;
        if (str == null) {
            str = "";
        }
        parcel.writeString(str);
    }

    protected LaunchParam(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) parcel);
            return;
        }
        this.f257073d = parcel.readByte() != 0;
        this.f257074e = parcel.readByte() != 0;
        this.f257075f = (LaunchMode) parcel.readParcelable(LaunchMode.class.getClassLoader());
        this.f257076h = parcel.readInt();
        this.f257077i = parcel.readInt();
        this.f257078m = parcel.readInt();
        this.C = parcel.readInt();
        this.D = parcel.readByte() != 0;
        this.E = parcel.readByte() != 0;
        this.F = parcel.readString();
    }
}
