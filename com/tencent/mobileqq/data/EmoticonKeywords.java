package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.IGNORE, columnNames = "keyword")
/* loaded from: classes10.dex */
public class EmoticonKeywords extends Entity {
    public String keyword;
    public long lastReqTime;

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (getClass() != obj.getClass() || !(obj instanceof EmoticonKeywords) || !this.keyword.equals(((EmoticonKeywords) obj).keyword)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.keyword.hashCode();
    }

    public String toString() {
        return "EmoticonKeywords{keyword = " + this.keyword + ",lastReqTime = " + this.lastReqTime + "}";
    }
}
