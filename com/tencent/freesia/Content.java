package com.tencent.freesia;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class Content implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<Content> CREATOR;
    public final int mCheckSum;
    public final int mCompress;
    public final byte[] mContent;
    public final boolean mIsCdnConfig;
    public final long mSize;
    public final boolean mSwitchStatus;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10162);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            CREATOR = new Parcelable.Creator<Content>() { // from class: com.tencent.freesia.Content.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public Content createFromParcel(Parcel parcel) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new Content(parcel) : (Content) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public Content[] newArray(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new Content[i3] : (Content[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
            };
        }
    }

    public Content(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.mContent = parcel.createByteArray();
        this.mCompress = parcel.readInt();
        this.mSize = parcel.readLong();
        this.mSwitchStatus = parcel.readByte() != 0;
        this.mIsCdnConfig = parcel.readByte() != 0;
        this.mCheckSum = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return 0;
    }

    public int getCheckSum() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.mCheckSum;
    }

    public int getCompress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.mCompress;
    }

    @NonNull
    public byte[] getContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (byte[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mContent;
    }

    public boolean getIsCdnConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.mIsCdnConfig;
    }

    public long getSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.mSize;
    }

    public boolean getSwitchStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.mSwitchStatus;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return "Content{mContent=" + this.mContent + ",mCompress=" + this.mCompress + ",mSize=" + this.mSize + ",mSwitchStatus=" + this.mSwitchStatus + ",mIsCdnConfig=" + this.mIsCdnConfig + ",mCheckSum=" + this.mCheckSum + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeByteArray(this.mContent);
        parcel.writeInt(this.mCompress);
        parcel.writeLong(this.mSize);
        parcel.writeByte(this.mSwitchStatus ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mIsCdnConfig ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.mCheckSum);
    }

    public Content(@NonNull byte[] bArr, int i3, long j3, boolean z16, boolean z17, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bArr, Integer.valueOf(i3), Long.valueOf(j3), Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i16));
            return;
        }
        this.mContent = bArr;
        this.mCompress = i3;
        this.mSize = j3;
        this.mSwitchStatus = z16;
        this.mIsCdnConfig = z17;
        this.mCheckSum = i16;
    }
}
