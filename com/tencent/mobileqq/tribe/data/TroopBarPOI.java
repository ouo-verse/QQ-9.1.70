package com.tencent.mobileqq.tribe.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import hd0.c;

/* loaded from: classes19.dex */
public class TroopBarPOI implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<TroopBarPOI> CREATOR;
    public final String C;

    /* renamed from: d, reason: collision with root package name */
    public final String f293483d;

    /* renamed from: e, reason: collision with root package name */
    public final String f293484e;

    /* renamed from: f, reason: collision with root package name */
    public final String f293485f;

    /* renamed from: h, reason: collision with root package name */
    public final int f293486h;

    /* renamed from: i, reason: collision with root package name */
    public final String f293487i;

    /* renamed from: m, reason: collision with root package name */
    public final int f293488m;

    /* loaded from: classes19.dex */
    class a implements Parcelable.Creator<TroopBarPOI> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TroopBarPOI createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (TroopBarPOI) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel);
            }
            return new TroopBarPOI(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TroopBarPOI[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TroopBarPOI[]) iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
            return null;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26003);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            CREATOR = new a();
        }
    }

    public TroopBarPOI(String str, String str2, String str3, int i3, String str4, int i16, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3, Integer.valueOf(i3), str4, Integer.valueOf(i16), str5);
            return;
        }
        this.f293483d = str;
        this.f293484e = str2;
        this.f293485f = str3;
        this.f293486h = i3;
        this.f293487i = str4;
        this.f293488m = i16;
        this.C = str5;
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        if (TextUtils.isEmpty(this.f293485f)) {
            c.g("TroopBarPOI", "name is empty while get location string!");
            return null;
        }
        if (TextUtils.isEmpty(this.f293484e)) {
            c.t("TroopBarPOI", "catelog is empty while get location string!");
            return this.f293485f;
        }
        String str = this.f293484e;
        if (str.endsWith(HardCodeUtil.qqStr(R.string.uck))) {
            str = str.substring(0, str.length() - 1);
        }
        return str + "\u00b7" + this.f293485f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, obj)).booleanValue();
        }
        if (!(obj instanceof TroopBarPOI)) {
            return false;
        }
        TroopBarPOI troopBarPOI = (TroopBarPOI) obj;
        if (!TextUtils.equals(troopBarPOI.f293485f, this.f293485f) || !TextUtils.equals(troopBarPOI.f293487i, this.f293487i)) {
            return false;
        }
        return true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeString(this.f293483d);
        parcel.writeString(this.f293484e);
        parcel.writeString(this.f293485f);
        parcel.writeInt(this.f293486h);
        parcel.writeString(this.f293487i);
        parcel.writeInt(this.f293488m);
        parcel.writeString(this.C);
    }
}
