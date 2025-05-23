package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;

/* compiled from: P */
/* loaded from: classes10.dex */
public class TroopKeyWord extends Entity {
    public boolean enable;
    public int expiredFlag;
    public String keyword;
    public String troopUin;
    public long wordId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TroopKeyWord)) {
            return false;
        }
        TroopKeyWord troopKeyWord = (TroopKeyWord) obj;
        return equals(this.troopUin, troopKeyWord.troopUin) && equals(this.keyword, troopKeyWord.keyword);
    }

    public int hashCode() {
        String str = this.keyword;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("TroopKeyWord{");
        stringBuffer.append("wordId=");
        stringBuffer.append(this.wordId);
        stringBuffer.append(", troopUin='");
        stringBuffer.append(this.troopUin);
        stringBuffer.append('\'');
        stringBuffer.append(", keyword='");
        stringBuffer.append(this.keyword);
        stringBuffer.append('\'');
        stringBuffer.append(", expiredFlag=");
        stringBuffer.append(this.expiredFlag);
        stringBuffer.append(", enable=");
        stringBuffer.append(this.enable);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public static boolean equals(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
