package com.tencent.mobileqq.app.face.bean;

import AvatarInfo.DestQQHeadInfo;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QQHeadDetails implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<QQHeadDetails> CREATOR;
    public boolean enableZplanOutbound;
    public FaceInfo faceInfo;
    public long headImgTimestamp;
    public byte level;
    public int sizeType;
    public String uinOrMobile;
    public int userType;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements Parcelable.Creator<QQHeadDetails> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QQHeadDetails createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (QQHeadDetails) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            QQHeadDetails qQHeadDetails = new QQHeadDetails(null);
            qQHeadDetails.userType = parcel.readInt();
            qQHeadDetails.uinOrMobile = parcel.readString();
            qQHeadDetails.headImgTimestamp = parcel.readLong();
            qQHeadDetails.level = parcel.readByte();
            qQHeadDetails.sizeType = parcel.readInt();
            qQHeadDetails.faceInfo = (FaceInfo) parcel.readParcelable(FaceInfo.class.getClassLoader());
            return qQHeadDetails;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QQHeadDetails[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (QQHeadDetails[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new QQHeadDetails[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37724);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            CREATOR = new a();
        }
    }

    /* synthetic */ QQHeadDetails(a aVar) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 0;
    }

    public DestQQHeadInfo getDestQQHeadInfo() {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (DestQQHeadInfo) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.userType == 11) {
            return new DestQQHeadInfo(0L, this.headImgTimestamp, this.uinOrMobile);
        }
        try {
            j3 = Long.parseLong(this.uinOrMobile);
        } catch (Exception unused) {
            j3 = 0;
        }
        return new DestQQHeadInfo(j3, this.headImgTimestamp, null);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "{uinOrMobile:" + this.uinOrMobile + ",timestamp:" + this.headImgTimestamp + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeInt(this.userType);
        parcel.writeString(this.uinOrMobile);
        parcel.writeLong(this.headImgTimestamp);
        parcel.writeByte(this.level);
        parcel.writeInt(this.sizeType);
        parcel.writeParcelable(this.faceInfo, i3);
    }

    QQHeadDetails() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public QQHeadDetails(int i3, String str, long j3, byte b16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, Long.valueOf(j3), Byte.valueOf(b16), Integer.valueOf(i16));
            return;
        }
        this.userType = i3;
        this.uinOrMobile = str;
        this.headImgTimestamp = j3;
        this.level = b16;
        this.sizeType = i16;
    }
}
