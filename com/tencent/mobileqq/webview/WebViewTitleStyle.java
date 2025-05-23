package com.tencent.mobileqq.webview;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes20.dex */
public class WebViewTitleStyle implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<WebViewTitleStyle> CREATOR;

    /* renamed from: d, reason: collision with root package name */
    public int f313797d;

    /* renamed from: e, reason: collision with root package name */
    public int f313798e;

    /* renamed from: f, reason: collision with root package name */
    public int f313799f;

    /* renamed from: h, reason: collision with root package name */
    public int f313800h;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements Parcelable.Creator<WebViewTitleStyle> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WebViewTitleStyle createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (WebViewTitleStyle) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new WebViewTitleStyle(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public WebViewTitleStyle[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (WebViewTitleStyle[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new WebViewTitleStyle[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48493);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            CREATOR = new a();
        }
    }

    public WebViewTitleStyle() {
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

    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "WebViewTitleStyle[titleBgColor" + ContainerUtils.KEY_VALUE_DELIMITER + "#" + String.format("%08X", Integer.valueOf(this.f313798e)) + ", titleColor" + ContainerUtils.KEY_VALUE_DELIMITER + "#" + String.format("%08X", Integer.valueOf(this.f313799f)) + ", leftAndRightBtnColor" + ContainerUtils.KEY_VALUE_DELIMITER + "#" + String.format("%08X", Integer.valueOf(this.f313800h)) + ", statusBarColor" + ContainerUtils.KEY_VALUE_DELIMITER + "#" + String.format("%08X", Integer.valueOf(this.f313797d)) + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeInt(this.f313797d);
        parcel.writeInt(this.f313798e);
        parcel.writeInt(this.f313799f);
        parcel.writeInt(this.f313800h);
    }

    public WebViewTitleStyle(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.f313797d = parcel.readInt();
        this.f313798e = parcel.readInt();
        this.f313799f = parcel.readInt();
        this.f313800h = parcel.readInt();
    }
}
