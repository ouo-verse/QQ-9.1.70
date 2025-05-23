package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.IGNORE, columnNames = "epId,eId,keyword")
/* loaded from: classes10.dex */
public class RecentEmotion extends Entity {
    public String eId;
    public String epId;
    public int exposeNum;
    public String keyword;

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (getClass() != obj.getClass() || !(obj instanceof RecentEmotion)) {
            return false;
        }
        RecentEmotion recentEmotion = (RecentEmotion) obj;
        if (!this.epId.equals(recentEmotion.epId) || !this.eId.equals(recentEmotion.eId) || !this.keyword.equals(recentEmotion.keyword)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.epId.hashCode() + this.eId.hashCode() + this.keyword.hashCode();
    }

    public void replace(RecentEmotion recentEmotion) {
        if (recentEmotion != null) {
            this.exposeNum = recentEmotion.exposeNum;
        }
    }

    public String toString() {
        return "RecentEmotion{keyword='" + this.keyword + "', epId='" + this.epId + "', eId='" + this.eId + "', exposeNum=" + this.exposeNum + '}';
    }
}
