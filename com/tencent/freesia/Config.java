package com.tencent.freesia;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class Config implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<Config> CREATOR;
    public final String mBusinessId;
    public final ArrayList<Content> mContents;
    public final String mGroup;
    public final int mGroupId;
    public final boolean mIsNoLoginConfig;
    public final int mNewVersion;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(AppConstants.RichMediaErrorCode.ERROR_UPLOAD_THUMB);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            CREATOR = new Parcelable.Creator<Config>() { // from class: com.tencent.freesia.Config.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public Config createFromParcel(Parcel parcel) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new Config(parcel) : (Config) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public Config[] newArray(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new Config[i3] : (Config[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
            };
        }
    }

    public Config(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.mGroup = parcel.readString();
        ArrayList<Content> arrayList = new ArrayList<>();
        this.mContents = arrayList;
        parcel.readList(arrayList, Config.class.getClassLoader());
        this.mBusinessId = parcel.readByte() == 0 ? null : parcel.readString();
        this.mGroupId = parcel.readInt();
        this.mNewVersion = parcel.readInt();
        this.mIsNoLoginConfig = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return 0;
    }

    @Nullable
    public String getBusinessId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mBusinessId;
    }

    @NonNull
    public ArrayList<Content> getContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ArrayList) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mContents;
    }

    @NonNull
    public String getGroup() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mGroup;
    }

    public int getGroupId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.mGroupId;
    }

    public boolean getIsNoLoginConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.mIsNoLoginConfig;
    }

    public int getNewVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.mNewVersion;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return "Config{mGroup=" + this.mGroup + ",mContents=" + this.mContents + ",mBusinessId=" + this.mBusinessId + ",mGroupId=" + this.mGroupId + ",mNewVersion=" + this.mNewVersion + ",mIsNoLoginConfig=" + this.mIsNoLoginConfig + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeString(this.mGroup);
        parcel.writeList(this.mContents);
        if (this.mBusinessId != null) {
            parcel.writeByte((byte) 1);
            parcel.writeString(this.mBusinessId);
        } else {
            parcel.writeByte((byte) 0);
        }
        parcel.writeInt(this.mGroupId);
        parcel.writeInt(this.mNewVersion);
        parcel.writeByte(this.mIsNoLoginConfig ? (byte) 1 : (byte) 0);
    }

    public Config(@NonNull String str, @NonNull ArrayList<Content> arrayList, @Nullable String str2, int i3, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, arrayList, str2, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
            return;
        }
        this.mGroup = str;
        this.mContents = arrayList;
        this.mBusinessId = str2;
        this.mGroupId = i3;
        this.mNewVersion = i16;
        this.mIsNoLoginConfig = z16;
    }
}
