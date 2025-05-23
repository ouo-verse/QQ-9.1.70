package com.tencent.mobileqq.flashshow.api.hybird;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.webview.WebViewTitleStyle;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FSWebViewTitleStyle extends WebViewTitleStyle {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<FSWebViewTitleStyle> CREATOR;

    /* renamed from: i, reason: collision with root package name */
    public int f209847i;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements Parcelable.Creator<FSWebViewTitleStyle> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FSWebViewTitleStyle createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (FSWebViewTitleStyle) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new FSWebViewTitleStyle(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FSWebViewTitleStyle[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (FSWebViewTitleStyle[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new FSWebViewTitleStyle[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71981);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            CREATOR = new a();
        }
    }

    public FSWebViewTitleStyle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this);
    }

    @Override // com.tencent.mobileqq.webview.WebViewTitleStyle, android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.webview.WebViewTitleStyle, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel, i3);
        } else {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f209847i);
        }
    }

    protected FSWebViewTitleStyle(Parcel parcel) {
        super(parcel);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.f209847i = parcel.readInt();
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel);
        }
    }
}
