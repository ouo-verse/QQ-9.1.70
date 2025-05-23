package com.tencent.mobileqq.webview;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* loaded from: classes20.dex */
public class URLCheckParams implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<URLCheckParams> CREATOR;
    public String C;
    public String D;
    public boolean E;
    public boolean F;
    public ArrayList<String> G;
    public Collection<String> H;

    /* renamed from: d, reason: collision with root package name */
    public String f313760d;

    /* renamed from: e, reason: collision with root package name */
    public int f313761e;

    /* renamed from: f, reason: collision with root package name */
    public int f313762f;

    /* renamed from: h, reason: collision with root package name */
    public String f313763h;

    /* renamed from: i, reason: collision with root package name */
    public String f313764i;

    /* renamed from: m, reason: collision with root package name */
    public String f313765m;

    /* loaded from: classes20.dex */
    class a implements Parcelable.Creator<URLCheckParams> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public URLCheckParams createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (URLCheckParams) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new URLCheckParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public URLCheckParams[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (URLCheckParams[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new URLCheckParams[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77282);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            CREATOR = new a();
        }
    }

    public URLCheckParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this);
    }

    public static URLCheckParams a(String str, int i3, int i16, String str2, String str3, String str4, String str5, String str6, boolean z16, boolean z17, ArrayList<String> arrayList) {
        URLCheckParams uRLCheckParams = new URLCheckParams();
        uRLCheckParams.f313760d = str;
        uRLCheckParams.f313761e = i3;
        uRLCheckParams.f313762f = i16;
        uRLCheckParams.f313763h = str2;
        uRLCheckParams.f313764i = str3;
        uRLCheckParams.f313765m = str4;
        uRLCheckParams.C = str5;
        uRLCheckParams.D = str6;
        uRLCheckParams.E = z16;
        uRLCheckParams.F = z17;
        uRLCheckParams.G = new ArrayList<>(arrayList);
        return uRLCheckParams;
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.H = Collections.singletonList(this.f313760d);
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

    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "URLCheckParams{ " + QQBrowserActivity.KEY_MSG_TYPE + ":" + this.f313761e + ", msgFrom:" + this.f313762f + ", " + AppConstants.Key.COLUMN_MSG_SENDER_UIN + ":" + this.f313763h + ", chatId:" + this.f313764i + ", urlSource:" + this.f313765m + ", arkBusinessName:" + this.D + ", isPageFinish:" + this.E + ", isMultiMsg:" + this.F + ", url:" + this.f313760d + ", originUrl:" + this.C + ", preJumpUrls:" + this.G + " }";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeString(this.f313760d);
        parcel.writeInt(this.f313761e);
        parcel.writeInt(this.f313762f);
        parcel.writeString(this.f313763h);
        parcel.writeString(this.f313764i);
        parcel.writeString(this.f313765m);
        parcel.writeString(this.C);
        parcel.writeString(this.D);
        parcel.writeInt(this.E ? 1 : 0);
        parcel.writeInt(this.F ? 1 : 0);
        parcel.writeStringList(this.G);
    }

    protected URLCheckParams(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) parcel);
            return;
        }
        this.f313760d = parcel.readString();
        this.f313761e = parcel.readInt();
        this.f313762f = parcel.readInt();
        this.f313763h = parcel.readString();
        this.f313764i = parcel.readString();
        this.f313765m = parcel.readString();
        this.C = parcel.readString();
        this.D = parcel.readString();
        this.E = parcel.readInt() == 1;
        this.F = parcel.readInt() == 1;
        this.G = parcel.createStringArrayList();
    }
}
