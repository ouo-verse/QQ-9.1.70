package com.tencent.freesia;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class RespControlInfo implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<RespControlInfo> CREATOR;
    public final long mConfigSeq;
    public final byte[] mCookies;
    public final ArrayList<String> mGroups;
    public final byte[] mIncCookies;
    public final byte[] mIncNologinCookies;
    public final int mIntervalReconnect;
    public final ArrayList<MuteDuration> mMuteDurations;
    public final NextFetchType mNextFetchType;
    public final ArrayList<Integer> mNextIntReqGroups;
    public final ArrayList<GroupInfo> mQpsLimitedGroups;
    public final int mUpdateInterval;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7582);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            CREATOR = new Parcelable.Creator<RespControlInfo>() { // from class: com.tencent.freesia.RespControlInfo.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public RespControlInfo createFromParcel(Parcel parcel) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new RespControlInfo(parcel) : (RespControlInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public RespControlInfo[] newArray(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new RespControlInfo[i3] : (RespControlInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
            };
        }
    }

    public RespControlInfo(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.mCookies = parcel.createByteArray();
        this.mIntervalReconnect = parcel.readInt();
        ArrayList<String> arrayList = new ArrayList<>();
        this.mGroups = arrayList;
        parcel.readList(arrayList, RespControlInfo.class.getClassLoader());
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        this.mNextIntReqGroups = arrayList2;
        parcel.readList(arrayList2, RespControlInfo.class.getClassLoader());
        this.mUpdateInterval = parcel.readInt();
        ArrayList<MuteDuration> arrayList3 = new ArrayList<>();
        this.mMuteDurations = arrayList3;
        parcel.readList(arrayList3, RespControlInfo.class.getClassLoader());
        this.mConfigSeq = parcel.readLong();
        ArrayList<GroupInfo> arrayList4 = new ArrayList<>();
        this.mQpsLimitedGroups = arrayList4;
        parcel.readList(arrayList4, RespControlInfo.class.getClassLoader());
        if (parcel.readByte() == 0) {
            this.mNextFetchType = null;
        } else {
            this.mNextFetchType = NextFetchType.values()[parcel.readInt()];
        }
        if (parcel.readByte() == 0) {
            this.mIncCookies = null;
        } else {
            this.mIncCookies = parcel.createByteArray();
        }
        if (parcel.readByte() == 0) {
            this.mIncNologinCookies = null;
        } else {
            this.mIncNologinCookies = parcel.createByteArray();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return 0;
    }

    public long getConfigSeq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
        }
        return this.mConfigSeq;
    }

    @NonNull
    public byte[] getCookies() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (byte[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mCookies;
    }

    @NonNull
    public ArrayList<String> getGroups() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ArrayList) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mGroups;
    }

    @Nullable
    public byte[] getIncCookies() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (byte[]) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.mIncCookies;
    }

    @Nullable
    public byte[] getIncNologinCookies() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (byte[]) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.mIncNologinCookies;
    }

    public int getIntervalReconnect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.mIntervalReconnect;
    }

    @NonNull
    public ArrayList<MuteDuration> getMuteDurations() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ArrayList) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.mMuteDurations;
    }

    @Nullable
    public NextFetchType getNextFetchType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (NextFetchType) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.mNextFetchType;
    }

    @NonNull
    public ArrayList<Integer> getNextIntReqGroups() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ArrayList) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mNextIntReqGroups;
    }

    @NonNull
    public ArrayList<GroupInfo> getQpsLimitedGroups() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (ArrayList) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.mQpsLimitedGroups;
    }

    public int getUpdateInterval() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.mUpdateInterval;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return "RespControlInfo{mCookies=" + this.mCookies + ",mIntervalReconnect=" + this.mIntervalReconnect + ",mGroups=" + this.mGroups + ",mNextIntReqGroups=" + this.mNextIntReqGroups + ",mUpdateInterval=" + this.mUpdateInterval + ",mMuteDurations=" + this.mMuteDurations + ",mConfigSeq=" + this.mConfigSeq + ",mQpsLimitedGroups=" + this.mQpsLimitedGroups + ",mNextFetchType=" + this.mNextFetchType + ",mIncCookies=" + this.mIncCookies + ",mIncNologinCookies=" + this.mIncNologinCookies + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeByteArray(this.mCookies);
        parcel.writeInt(this.mIntervalReconnect);
        parcel.writeList(this.mGroups);
        parcel.writeList(this.mNextIntReqGroups);
        parcel.writeInt(this.mUpdateInterval);
        parcel.writeList(this.mMuteDurations);
        parcel.writeLong(this.mConfigSeq);
        parcel.writeList(this.mQpsLimitedGroups);
        if (this.mNextFetchType != null) {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.mNextFetchType.ordinal());
        } else {
            parcel.writeByte((byte) 0);
        }
        if (this.mIncCookies != null) {
            parcel.writeByte((byte) 1);
            parcel.writeByteArray(this.mIncCookies);
        } else {
            parcel.writeByte((byte) 0);
        }
        if (this.mIncNologinCookies != null) {
            parcel.writeByte((byte) 1);
            parcel.writeByteArray(this.mIncNologinCookies);
        } else {
            parcel.writeByte((byte) 0);
        }
    }

    public RespControlInfo(@NonNull byte[] bArr, int i3, @NonNull ArrayList<String> arrayList, @NonNull ArrayList<Integer> arrayList2, int i16, @NonNull ArrayList<MuteDuration> arrayList3, long j3, @NonNull ArrayList<GroupInfo> arrayList4, @Nullable NextFetchType nextFetchType, @Nullable byte[] bArr2, @Nullable byte[] bArr3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bArr, Integer.valueOf(i3), arrayList, arrayList2, Integer.valueOf(i16), arrayList3, Long.valueOf(j3), arrayList4, nextFetchType, bArr2, bArr3);
            return;
        }
        this.mCookies = bArr;
        this.mIntervalReconnect = i3;
        this.mGroups = arrayList;
        this.mNextIntReqGroups = arrayList2;
        this.mUpdateInterval = i16;
        this.mMuteDurations = arrayList3;
        this.mConfigSeq = j3;
        this.mQpsLimitedGroups = arrayList4;
        this.mNextFetchType = nextFetchType;
        this.mIncCookies = bArr2;
        this.mIncNologinCookies = bArr3;
    }
}
