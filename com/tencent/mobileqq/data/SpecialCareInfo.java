package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
@KeepClassConstructor
/* loaded from: classes10.dex */
public class SpecialCareInfo extends Entity implements Cloneable, Parcelable {
    public static final Parcelable.Creator<SpecialCareInfo> CREATOR = new a();
    public long dateTime;
    public int friendRingId;
    public int globalSwitch;
    public int groupFriendSwitch;
    public int qzoneSwitch;
    public int specialRingSwitch;

    @unique
    public String uin;
    public byte[] zoneInfo;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements Parcelable.Creator<SpecialCareInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SpecialCareInfo createFromParcel(Parcel parcel) {
            return new SpecialCareInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SpecialCareInfo[] newArray(int i3) {
            return new SpecialCareInfo[i3];
        }
    }

    public SpecialCareInfo() {
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("FriendsManager", 2, "SpecialCareInfo clone failed." + e16.toString());
            }
            return this;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "\n SpecialCareInfo\n |-uin:" + this.uin + "\n |-status:" + getStatus() + "\n |-dateTime:" + this.dateTime + "\n |-globalSwitch:" + this.globalSwitch + "\n |-specialRingSwitch:" + this.specialRingSwitch + "\n |-friendRingId:" + this.friendRingId + "\n |-qzoneSwitch:" + this.qzoneSwitch;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.uin);
        parcel.writeLong(this.dateTime);
        parcel.writeInt(this.globalSwitch);
        parcel.writeInt(this.specialRingSwitch);
        parcel.writeInt(this.friendRingId);
        parcel.writeInt(this.qzoneSwitch);
    }

    public SpecialCareInfo(Parcel parcel) {
        this.uin = parcel.readString();
        this.dateTime = parcel.readLong();
        this.globalSwitch = parcel.readInt();
        this.specialRingSwitch = parcel.readInt();
        this.friendRingId = parcel.readInt();
        this.qzoneSwitch = parcel.readInt();
    }
}
