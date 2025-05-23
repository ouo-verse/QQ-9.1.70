package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;

/* loaded from: classes10.dex */
public class PhoneContact extends Entity implements Cloneable, Serializable {
    private static final String TAG = "PhoneContact";
    public int ability;
    public int age;
    public long bindingDate;
    public int contactID;
    public byte detalStatusFlag;
    public int eNetworkType;

    @Deprecated
    public String faceUrl;
    public long highLightTimeStamp;
    public int iTermType;
    public boolean isHiden;
    public boolean isNewRecommend;
    public int isRecommend;
    public String label;

    @Deprecated
    public long lastScanTime;
    public String md5;

    @Deprecated
    public String mobileCode;

    @unique
    public String mobileNo;
    public String name;

    @Deprecated
    public String nationCode;
    public String nickName;

    @Deprecated
    public long originBinder;
    public String pinyinAll;

    @notColumn
    public String pinyinFirst;
    public String pinyinInitial;
    public String remark;
    public byte[] richBuffer;
    public long richTime;
    public int samFriend;
    public int sex;
    public int type;
    public String uin;
    public String unifiedCode;
    public boolean isUploaded = false;
    public int sortWeight = 0;
    public boolean hasSendAddReq = false;
    public long abilityBits = 0;
    public String strTermDesc = "";
    public int netTypeIconIdIphoneOrWphoneNoWifi = 0;
    public int netTypeIconId = 0;

    private static int getNetTypeByIconType(int i3, int i16) {
        int i17 = 1;
        if (i3 != 1) {
            i17 = 2;
            if (i3 != 2) {
                i17 = 3;
                if (i3 != 3) {
                    i17 = 4;
                    if (i3 != 4) {
                        if (i3 != 12) {
                            return i16;
                        }
                        return 5;
                    }
                }
            }
        }
        return i17;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "PhoneContact clone failed." + e16.toString());
            }
            return this;
        }
    }

    public int getNetWorkType() {
        int i3;
        int i16;
        byte b16 = this.detalStatusFlag;
        if (b16 == -55 && (((i16 = this.iTermType) == 67586 || i16 == 66566 || i16 == 72194 || i16 == 65804 || i16 == 72706) && (this.abilityBits & 1) == 0)) {
            return getNetTypeByIconType(this.netTypeIconIdIphoneOrWphoneNoWifi, this.eNetworkType);
        }
        if ((b16 == -55 && this.iTermType == 68361 && (1 & this.abilityBits) == 0) || (i3 = this.iTermType) == 68104 || i3 == 65805) {
            return 0;
        }
        com.tencent.mobileqq.friend.status.a c16 = com.tencent.mobileqq.friend.status.a.c();
        if (this.eNetworkType == 0) {
            int i17 = this.iTermType;
            if (i17 == 69378 || i17 == 73474 || i17 == 73730) {
                return 0;
            }
            if (1 != c16.b(i17, 1)) {
                return 2;
            }
        }
        if (1 != c16.b(this.iTermType, 1)) {
            return getNetTypeByIconType(this.netTypeIconId, this.eNetworkType);
        }
        return this.eNetworkType;
    }

    public void setRichBuffer(byte[] bArr, long j3) {
        this.richBuffer = bArr;
        this.richTime = j3;
    }
}
