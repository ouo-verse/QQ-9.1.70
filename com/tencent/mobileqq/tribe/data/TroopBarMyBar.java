package com.tencent.mobileqq.tribe.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopBarMyBar implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<TroopBarMyBar> CREATOR;
    public int C;
    public String D;
    public int E;
    public int F;
    public String G;
    public String H;
    public int I;
    public String J;
    public int K;
    public String L;

    /* renamed from: d, reason: collision with root package name */
    public int f293477d;

    /* renamed from: e, reason: collision with root package name */
    public int f293478e;

    /* renamed from: f, reason: collision with root package name */
    public int f293479f;

    /* renamed from: h, reason: collision with root package name */
    public int f293480h;

    /* renamed from: i, reason: collision with root package name */
    public int f293481i;

    /* renamed from: m, reason: collision with root package name */
    public int f293482m;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements Parcelable.Creator<TroopBarMyBar> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TroopBarMyBar createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (TroopBarMyBar) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel);
            }
            return new TroopBarMyBar(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TroopBarMyBar[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TroopBarMyBar[]) iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
            return null;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25985);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            CREATOR = new a();
        }
    }

    public TroopBarMyBar(int i3, int i16, int i17, int i18, int i19, int i26, int i27, String str, int i28, int i29, String str2, String str3, int i36, String str4, int i37, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), str, Integer.valueOf(i28), Integer.valueOf(i29), str2, str3, Integer.valueOf(i36), str4, Integer.valueOf(i37), str5);
            return;
        }
        this.f293477d = i3;
        this.f293478e = i16;
        this.f293479f = i17;
        this.f293480h = i18;
        this.f293481i = i19;
        this.f293482m = i26;
        this.C = i27;
        this.D = str;
        this.E = i28;
        this.F = i29;
        this.G = str2;
        this.H = str3;
        this.I = i36;
        this.J = str4;
        this.K = i37;
        this.L = str5;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, obj)).booleanValue();
        }
        if (obj instanceof TroopBarMyBar) {
            return ((TroopBarMyBar) obj).H.equals(this.H);
        }
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeInt(this.f293477d);
        parcel.writeInt(this.f293478e);
        parcel.writeInt(this.f293479f);
        parcel.writeInt(this.f293480h);
        parcel.writeInt(this.f293481i);
        parcel.writeInt(this.f293482m);
        parcel.writeInt(this.C);
        String str = this.D;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        parcel.writeString(str);
        parcel.writeInt(this.E);
        parcel.writeInt(this.F);
        String str3 = this.G;
        if (str3 == null) {
            str3 = "";
        }
        parcel.writeString(str3);
        String str4 = this.H;
        if (str4 == null) {
            str4 = "";
        }
        parcel.writeString(str4);
        parcel.writeInt(this.I);
        String str5 = this.J;
        if (str5 == null) {
            str5 = "";
        }
        parcel.writeString(str5);
        parcel.writeInt(this.K);
        String str6 = this.L;
        if (str6 != null) {
            str2 = str6;
        }
        parcel.writeString(str2);
    }
}
