package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.dating.e;
import com.tencent.mobileqq.dating.f;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class DatingInfo extends Entity {

    @notColumn
    private static final int FLAG_MASK_COMMENT_NEW_OVER = 32;

    @notColumn
    private static final int FLAG_MASK_STRANGER_NEW_OVER = 8;

    @notColumn
    private static final int FLAG_MASK_VISIT_NEW_OVER = 2;

    @notColumn
    public static final int TYPE_COMMENT = 1;
    public String commentPacked;

    @unique
    public String datingId;
    public int datingSubject;
    public long datingTime;

    @notColumn
    public long lastUpdateTime;
    public int owner;

    @notColumn
    public String strDatingTime;
    public String strangerInfosPacked;
    public String visitorInfosPacked;

    @notColumn
    public boolean isInit = false;

    @notColumn
    private int nPrivateFlag = 0;

    @notColumn
    private List<e> strangerInfos = new ArrayList(20);

    @notColumn
    private List<e> visitorInfos = new ArrayList(20);

    @notColumn
    private List<com.tencent.mobileqq.dating.c> commentList = new ArrayList(20);

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        DatingInfo datingInfo = (DatingInfo) obj;
        String str = this.datingId;
        if ((str != null || datingInfo.datingId != null) && (str == null || !str.equals(datingInfo.datingId))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        if (TextUtils.isEmpty(this.datingId)) {
            return 0;
        }
        return this.datingId.hashCode();
    }

    public void init() {
        long j3 = this.datingTime;
        if (j3 == 0) {
            this.strDatingTime = "";
        } else {
            this.strDatingTime = f.g(j3, this.datingSubject, false);
        }
        e.d(this.visitorInfos, this.visitorInfosPacked);
        this.nPrivateFlag |= 2;
        com.tencent.mobileqq.dating.c.e(this.commentList, this.commentPacked);
        this.nPrivateFlag |= 32;
        e.d(this.strangerInfos, this.strangerInfosPacked);
        this.nPrivateFlag |= 8;
    }

    public boolean isDefaultValue() {
        if (this.datingSubject != 0 && this.datingTime != 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        synchronized (this.strangerInfos) {
            if ((this.nPrivateFlag & 8) == 8) {
                this.strangerInfosPacked = e.b(this.strangerInfos);
            } else {
                this.strangerInfosPacked = "";
            }
        }
        synchronized (this.visitorInfos) {
            if ((this.nPrivateFlag & 2) == 2) {
                this.visitorInfosPacked = e.b(this.visitorInfos);
            } else {
                this.visitorInfosPacked = "";
            }
        }
        synchronized (this.commentList) {
            if ((this.nPrivateFlag & 8) == 8) {
                this.commentPacked = com.tencent.mobileqq.dating.c.c(this.commentList);
            } else {
                this.commentPacked = "";
            }
        }
    }
}
