package com.tencent.mobileqq.doutu;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes10.dex */
public class DoutuData extends Entity implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<DoutuData> CREATOR;
    public String picDownUrl;
    public int picHeight;
    public String picMd5;
    public long picSize;

    @notColumn
    public int picType;
    public int picWidth;
    public String suppliersName;
    public String thumbDownUrl;
    public int thumbHeight;
    public String thumbMd5;
    public long thumbSize;
    public int thumbWidth;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements Parcelable.Creator<DoutuData> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DoutuData createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (DoutuData) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new DoutuData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DoutuData[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (DoutuData[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new DoutuData[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31024);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            CREATOR = new a();
        }
    }

    public DoutuData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.picType = 1;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
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
        parcel.writeString(this.picMd5);
        parcel.writeLong(this.picSize);
        parcel.writeInt(this.picHeight);
        parcel.writeInt(this.picWidth);
        parcel.writeString(this.picDownUrl);
        parcel.writeString(this.thumbMd5);
        parcel.writeLong(this.thumbSize);
        parcel.writeInt(this.thumbHeight);
        parcel.writeInt(this.thumbWidth);
        parcel.writeString(this.thumbDownUrl);
        parcel.writeString(this.suppliersName);
        parcel.writeInt(this.picType);
    }

    public DoutuData(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
            return;
        }
        this.picType = 1;
        this.picMd5 = str;
        this.thumbDownUrl = str2;
    }

    public DoutuData(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel);
            return;
        }
        this.picType = 1;
        this.picMd5 = parcel.readString();
        this.picSize = parcel.readLong();
        this.picHeight = parcel.readInt();
        this.picWidth = parcel.readInt();
        this.picDownUrl = parcel.readString();
        this.thumbMd5 = parcel.readString();
        this.thumbSize = parcel.readLong();
        this.thumbHeight = parcel.readInt();
        this.thumbWidth = parcel.readInt();
        this.thumbDownUrl = parcel.readString();
        this.suppliersName = parcel.readString();
        this.picType = parcel.readInt();
    }
}
