package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "picMd5")
/* loaded from: classes10.dex */
public class VipComicFavorEmoStructMsgInfo extends Entity {
    public static final int init = 1;
    public static final int updated = 2;
    public String actionData;
    public String picMd5;
    public int status = 1;

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if ((obj instanceof VipComicFavorEmoStructMsgInfo) && !TextUtils.isEmpty(this.picMd5) && !TextUtils.isEmpty(this.actionData)) {
            VipComicFavorEmoStructMsgInfo vipComicFavorEmoStructMsgInfo = (VipComicFavorEmoStructMsgInfo) obj;
            if (this.picMd5.equalsIgnoreCase(vipComicFavorEmoStructMsgInfo.picMd5) && this.actionData.equals(vipComicFavorEmoStructMsgInfo.actionData)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "md5 = " + this.picMd5 + " , actionData = " + this.actionData + " , status = " + this.status;
    }
}
