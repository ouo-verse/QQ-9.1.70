package com.tencent.mobileqq.activity.photo;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.Serializable;

/* loaded from: classes10.dex */
public class PhotoSendParams implements Parcelable, Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final Parcelable.Creator<PhotoSendParams> CREATOR;
    public static final int SEND_PIC_NORMAL = 0;
    public static final int SEND_PIC_QZONE = 1;
    public long fileSize;
    public int picType;
    public String rawDownloadUrl;
    public int rawHeight;
    public String rawMd5;
    public String rawPicPath;
    public int rawWidth;
    public String thumbPath;

    /* loaded from: classes10.dex */
    class a implements Parcelable.Creator<PhotoSendParams> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PhotoSendParams createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (PhotoSendParams) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new PhotoSendParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PhotoSendParams[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (PhotoSendParams[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new PhotoSendParams[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27841);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            CREATOR = new a();
        }
    }

    public PhotoSendParams(String str, String str2, String str3, long j3, int i3, int i16, String str4, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), str4, Integer.valueOf(i17));
            return;
        }
        this.thumbPath = str;
        this.rawMd5 = str2;
        this.rawPicPath = str3;
        this.fileSize = j3;
        this.rawHeight = i3;
        this.rawWidth = i16;
        this.rawDownloadUrl = str4;
        this.picType = i17;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 0;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "PhotoSendParams:&thumbPath:" + this.thumbPath + " &rawMd5:" + this.rawMd5 + " &rawPicPath:" + this.rawPicPath + " &rawHeight:" + this.rawHeight + " &rawWidth:" + this.rawWidth + " &rawDownloadUrl:" + this.rawDownloadUrl + " &picType:" + this.picType;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeString(this.thumbPath);
        parcel.writeString(this.rawMd5);
        parcel.writeString(this.rawPicPath);
        parcel.writeLong(this.fileSize);
        parcel.writeInt(this.rawHeight);
        parcel.writeInt(this.rawWidth);
        parcel.writeString(this.rawDownloadUrl);
        parcel.writeInt(this.picType);
    }

    public PhotoSendParams(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel);
            return;
        }
        this.picType = 0;
        this.thumbPath = parcel.readString();
        this.rawMd5 = parcel.readString();
        this.rawPicPath = parcel.readString();
        this.fileSize = parcel.readLong();
        this.rawHeight = parcel.readInt();
        this.rawWidth = parcel.readInt();
        this.rawDownloadUrl = parcel.readString();
        this.picType = parcel.readInt();
    }
}
