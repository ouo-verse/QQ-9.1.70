package com.tencent.tmdownloader.internal.notification;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes26.dex */
public class NotifyParam implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<NotifyParam> CREATOR;
    public String content;
    public String nKey;
    public int notificationTypeId;
    public String title;
    public String url;

    /* loaded from: classes26.dex */
    class a implements Parcelable.Creator<NotifyParam> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public NotifyParam createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new NotifyParam(parcel) : (NotifyParam) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public NotifyParam[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new NotifyParam[i3] : (NotifyParam[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18388);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            CREATOR = new a();
        }
    }

    public NotifyParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.url = "";
        this.title = "";
        this.content = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeString(this.url);
        parcel.writeString(this.title);
        parcel.writeString(this.content);
        parcel.writeString(this.nKey);
        parcel.writeInt(this.notificationTypeId);
    }

    public NotifyParam(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.url = "";
        this.title = "";
        this.content = "";
        this.url = parcel.readString();
        this.title = parcel.readString();
        this.content = parcel.readString();
        this.nKey = parcel.readString();
        this.notificationTypeId = parcel.readInt();
    }
}
