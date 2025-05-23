package com.tencent.mobileqq.soload.biz.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class RelatedFileInfo implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<RelatedFileInfo> CREATOR;
    public String md5;
    public String url;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements Parcelable.Creator<RelatedFileInfo> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RelatedFileInfo createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (RelatedFileInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new RelatedFileInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RelatedFileInfo[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (RelatedFileInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new RelatedFileInfo[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33735);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            CREATOR = new a();
        }
    }

    public RelatedFileInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public static RelatedFileInfo create(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("url");
        String optString2 = jSONObject.optString("md5");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            return null;
        }
        RelatedFileInfo relatedFileInfo = new RelatedFileInfo();
        relatedFileInfo.url = optString;
        relatedFileInfo.md5 = optString2;
        return relatedFileInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 0;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "ri{u='" + this.url + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel, i3);
        } else {
            parcel.writeString(this.url);
            parcel.writeString(this.md5);
        }
    }

    protected RelatedFileInfo(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
        } else {
            this.url = parcel.readString();
            this.md5 = parcel.readString();
        }
    }
}
