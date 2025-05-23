package com.tencent.mobileqq.dating;

import android.os.Parcel;
import android.os.Parcelable;
import appoint.define.appoint_define$LocaleInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.UnsupportedEncodingException;

/* compiled from: P */
/* loaded from: classes10.dex */
public class DatingFilters implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<DatingFilters> CREATOR;
    public static final String[] E;
    public static final int[] F;
    public static final int[] G;
    public static final String[] H;
    public static String[] I;
    public appoint_define$LocaleInfo C;
    public int D;

    /* renamed from: d, reason: collision with root package name */
    public int f203356d;

    /* renamed from: e, reason: collision with root package name */
    public int f203357e;

    /* renamed from: f, reason: collision with root package name */
    public int f203358f;

    /* renamed from: h, reason: collision with root package name */
    public int f203359h;

    /* renamed from: i, reason: collision with root package name */
    public int f203360i;

    /* renamed from: m, reason: collision with root package name */
    public int f203361m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements Parcelable.Creator<DatingFilters> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DatingFilters createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (DatingFilters) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new DatingFilters(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DatingFilters[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (DatingFilters[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new DatingFilters[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71466);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        E = new String[]{HardCodeUtil.qqStr(R.string.lad), "18-22\u5c81", "23-26\u5c81", "27-35\u5c81", "35\u5c81\u4ee5\u4e0a"};
        F = new int[]{0, 22, 26, 35, 120};
        G = new int[]{0, 18, 23, 27, 36};
        H = new String[]{HardCodeUtil.qqStr(R.string.lab), HardCodeUtil.qqStr(R.string.lah), HardCodeUtil.qqStr(R.string.lag), HardCodeUtil.qqStr(R.string.lae), HardCodeUtil.qqStr(R.string.lac)};
        I = new String[]{HardCodeUtil.qqStr(R.string.laj), HardCodeUtil.qqStr(R.string.lal), HardCodeUtil.qqStr(R.string.lai), HardCodeUtil.qqStr(R.string.laf), HardCodeUtil.qqStr(R.string.laa), HardCodeUtil.qqStr(R.string.lak)};
        CREATOR = new a();
    }

    DatingFilters(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) parcel);
            return;
        }
        this.f203361m = 0;
        this.C = null;
        this.f203356d = parcel.readInt();
        this.f203357e = parcel.readInt();
        this.f203358f = parcel.readInt();
        this.f203359h = parcel.readInt();
        this.f203360i = parcel.readInt();
        this.f203361m = parcel.readInt();
        this.D = parcel.readInt();
        String readString = parcel.readString();
        if (readString != null && !readString.equals("")) {
            try {
                appoint_define$LocaleInfo appoint_define_localeinfo = new appoint_define$LocaleInfo();
                appoint_define_localeinfo.mergeFrom(readString.getBytes("ISO-8859-1"));
                this.C = appoint_define_localeinfo;
                return;
            } catch (Exception unused) {
                this.C = null;
                return;
            }
        }
        this.C = null;
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DatingFilters datingFilters = (DatingFilters) obj;
        if (this.f203360i != datingFilters.f203360i || this.f203361m != datingFilters.f203361m || this.f203358f != datingFilters.f203358f || this.f203357e != datingFilters.f203357e || this.f203356d != datingFilters.f203356d) {
            return false;
        }
        appoint_define$LocaleInfo appoint_define_localeinfo = this.C;
        appoint_define$LocaleInfo appoint_define_localeinfo2 = datingFilters.C;
        if (appoint_define_localeinfo == appoint_define_localeinfo2 || (appoint_define_localeinfo != null && appoint_define_localeinfo2 != null && appoint_define_localeinfo.str_name.get().equals(datingFilters.C.str_name.get()))) {
            return true;
        }
        return false;
    }

    public String toString() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("DatingFilters [gender=");
        sb5.append(this.f203356d);
        sb5.append(", datingTime=");
        sb5.append(this.f203357e);
        sb5.append(", datingContent=");
        sb5.append(this.f203358f);
        sb5.append(", age=");
        sb5.append(this.f203360i);
        sb5.append(", career=");
        sb5.append(this.f203361m);
        sb5.append(", dest=");
        appoint_define$LocaleInfo appoint_define_localeinfo = this.C;
        if (appoint_define_localeinfo == null) {
            str = "null";
        } else {
            str = appoint_define_localeinfo.str_name.get();
        }
        sb5.append(str);
        sb5.append("]");
        return sb5.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeInt(this.f203356d);
        parcel.writeInt(this.f203357e);
        parcel.writeInt(this.f203358f);
        parcel.writeInt(this.f203359h);
        parcel.writeInt(this.f203360i);
        parcel.writeInt(this.f203361m);
        parcel.writeInt(this.D);
        try {
            appoint_define$LocaleInfo appoint_define_localeinfo = this.C;
            if (appoint_define_localeinfo == null) {
                str = "";
            } else {
                str = new String(appoint_define_localeinfo.toByteArray(), "ISO-8859-1");
            }
            parcel.writeString(str);
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
        }
    }
}
