package com.tencent.mobileqq.troop.activity;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes19.dex */
public class MediaPreviewInfo implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<MediaPreviewInfo> CREATOR;

    /* renamed from: d, reason: collision with root package name */
    public int f293514d;

    /* renamed from: e, reason: collision with root package name */
    public String f293515e;

    /* renamed from: f, reason: collision with root package name */
    public String f293516f;

    /* renamed from: h, reason: collision with root package name */
    public String f293517h;

    /* loaded from: classes19.dex */
    class a implements Parcelable.Creator<MediaPreviewInfo> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediaPreviewInfo createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (MediaPreviewInfo) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel);
            }
            MediaPreviewInfo mediaPreviewInfo = new MediaPreviewInfo();
            mediaPreviewInfo.f293514d = parcel.readInt();
            mediaPreviewInfo.f293515e = parcel.readString();
            mediaPreviewInfo.f293516f = parcel.readString();
            mediaPreviewInfo.f293517h = parcel.readString();
            return mediaPreviewInfo;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MediaPreviewInfo[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (MediaPreviewInfo[]) iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
            return new MediaPreviewInfo[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76068);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            CREATOR = new a();
        }
    }

    public MediaPreviewInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f293514d = -1;
        this.f293515e = null;
        this.f293516f = null;
        this.f293517h = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 0;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        StringBuffer stringBuffer = new StringBuffer("type = ");
        stringBuffer.append(this.f293514d);
        stringBuffer.append(", imageUrl = ");
        stringBuffer.append(this.f293515e);
        stringBuffer.append(", videoUrl = ");
        stringBuffer.append(this.f293516f);
        stringBuffer.append(", videoLocalPath = ");
        stringBuffer.append(this.f293517h);
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeInt(this.f293514d);
        parcel.writeString(this.f293515e);
        parcel.writeString(this.f293516f);
        parcel.writeString(this.f293517h);
    }
}
