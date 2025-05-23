package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class BmqqUserSimpleInfo extends Entity implements Cloneable, Parcelable {
    private static final String TAG = "BmqqUserSimpleInfo";
    public String mBmqqCompany;
    public String mBmqqEmail;
    public String mBmqqJobTitle;
    public String mBmqqMasterUin;
    public String mBmqqMobileNum;
    public String mBmqqNickName;
    public String mBmqqRemarkName;
    public String mBmqqTelphone;

    @unique
    public String mBmqqUin;
    public int mFlag;

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "BmqqUser clone failed." + e16.toString());
            }
            return this;
        }
    }

    public void copyValue(BmqqUserSimpleInfo bmqqUserSimpleInfo) {
        if (bmqqUserSimpleInfo != null) {
            this.mBmqqUin = bmqqUserSimpleInfo.mBmqqUin;
            this.mBmqqMasterUin = bmqqUserSimpleInfo.mBmqqMasterUin;
            this.mBmqqNickName = bmqqUserSimpleInfo.mBmqqNickName;
            this.mBmqqRemarkName = bmqqUserSimpleInfo.mBmqqRemarkName;
            this.mBmqqJobTitle = bmqqUserSimpleInfo.mBmqqJobTitle;
            this.mBmqqMobileNum = bmqqUserSimpleInfo.mBmqqMobileNum;
            this.mBmqqTelphone = bmqqUserSimpleInfo.mBmqqTelphone;
            this.mBmqqEmail = bmqqUserSimpleInfo.mBmqqEmail;
            this.mBmqqCompany = bmqqUserSimpleInfo.mBmqqCompany;
            this.mFlag = bmqqUserSimpleInfo.mFlag;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == null || !(obj instanceof BmqqUserSimpleInfo)) {
            return false;
        }
        BmqqUserSimpleInfo bmqqUserSimpleInfo = (BmqqUserSimpleInfo) obj;
        if (!bmqqUserSimpleInfo.mBmqqUin.equals(this.mBmqqUin)) {
            return false;
        }
        String str2 = bmqqUserSimpleInfo.mBmqqMasterUin;
        if ((str2 == null && this.mBmqqMasterUin != null) || (str2 != null && this.mBmqqMasterUin == null)) {
            return false;
        }
        if ((str2 != null && (str = this.mBmqqMasterUin) != null && !str2.equals(str)) || !bmqqUserSimpleInfo.mBmqqNickName.equals(this.mBmqqNickName) || !bmqqUserSimpleInfo.mBmqqRemarkName.equals(this.mBmqqRemarkName) || !bmqqUserSimpleInfo.mBmqqJobTitle.equals(this.mBmqqJobTitle) || !bmqqUserSimpleInfo.mBmqqMobileNum.equals(this.mBmqqMobileNum) || !bmqqUserSimpleInfo.mBmqqTelphone.equals(this.mBmqqTelphone) || !bmqqUserSimpleInfo.mBmqqEmail.equals(this.mBmqqEmail) || !bmqqUserSimpleInfo.mBmqqCompany.equals(this.mBmqqCompany) || bmqqUserSimpleInfo.mFlag != this.mFlag) {
            return false;
        }
        return true;
    }

    public boolean isCertified() {
        if ((this.mFlag & 1) == 1) {
            return true;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
    }
}
