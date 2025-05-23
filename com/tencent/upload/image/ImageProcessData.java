package com.tencent.upload.image;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes27.dex */
public class ImageProcessData implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<ImageProcessData> CREATOR;
    public boolean autoRotate;
    public boolean compressToWebp;

    /* renamed from: id, reason: collision with root package name */
    public int f383917id;

    /* renamed from: msg, reason: collision with root package name */
    public String f383918msg;
    public String originalFilePath;
    public String targetFilePath;
    public int targetHeight;
    public int targetQuality;
    public int targetWidth;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10389);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            CREATOR = new Parcelable.Creator<ImageProcessData>() { // from class: com.tencent.upload.image.ImageProcessData.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public ImageProcessData createFromParcel(Parcel parcel) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new ImageProcessData(parcel, null) : (ImageProcessData) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public ImageProcessData[] newArray(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new ImageProcessData[i3] : (ImageProcessData[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
            };
        }
    }

    /* synthetic */ ImageProcessData(Parcel parcel, AnonymousClass1 anonymousClass1) {
        this(parcel);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, (Object) this, (Object) parcel, (Object) anonymousClass1);
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
        return super.toString() + "file = " + this.originalFilePath + " target w=" + this.targetWidth + " h = " + this.targetHeight + " q = " + this.targetQuality + " a = " + this.autoRotate + " webp = " + this.compressToWebp;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeInt(this.f383917id);
        parcel.writeString(this.originalFilePath);
        parcel.writeString(this.targetFilePath);
        parcel.writeInt(this.targetWidth);
        parcel.writeInt(this.targetHeight);
        parcel.writeInt(this.targetQuality);
        parcel.writeByte(this.autoRotate ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.compressToWebp ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f383918msg);
    }

    public ImageProcessData(int i3, String str, String str2, int i16, int i17, int i18, boolean z16, boolean z17, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, str2, Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z16), Boolean.valueOf(z17), str3);
            return;
        }
        this.f383917id = i3;
        this.originalFilePath = str;
        this.targetFilePath = str2;
        this.targetWidth = i16;
        this.targetHeight = i17;
        this.targetQuality = i18;
        this.autoRotate = z16;
        this.compressToWebp = z17;
        this.f383918msg = str3;
    }

    ImageProcessData(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel);
            return;
        }
        this.f383917id = parcel.readInt();
        this.originalFilePath = parcel.readString();
        this.targetFilePath = parcel.readString();
        this.targetWidth = parcel.readInt();
        this.targetHeight = parcel.readInt();
        this.targetQuality = parcel.readInt();
        this.autoRotate = parcel.readByte() == 1;
        this.compressToWebp = parcel.readByte() == 1;
        this.f383918msg = parcel.readString();
    }
}
