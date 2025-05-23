package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause = ConflictClause.IGNORE, columnNames = "userUin,friendUin")
/* loaded from: classes10.dex */
public class UinPair extends Entity {
    public String friendUin;
    public String userUin;

    public UinPair() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UinPair) {
            String str = this.userUin;
            if (str == null) {
                UinPair uinPair = (UinPair) obj;
                if (uinPair.userUin == null) {
                    String str2 = this.friendUin;
                    if (str2 == null) {
                        if (uinPair.friendUin == null) {
                            return true;
                        }
                        return false;
                    }
                    return str2.equals(uinPair.friendUin);
                }
            } else {
                UinPair uinPair2 = (UinPair) obj;
                if (str.equals(uinPair2.userUin)) {
                    String str3 = this.friendUin;
                    if (str3 == null) {
                        if (uinPair2.friendUin == null) {
                            return true;
                        }
                        return false;
                    }
                    return str3.equals(uinPair2.friendUin);
                }
            }
        }
        return super.equals(obj);
    }

    public UinPair(String str, String str2) {
        this.userUin = str;
        this.friendUin = str2;
    }
}
