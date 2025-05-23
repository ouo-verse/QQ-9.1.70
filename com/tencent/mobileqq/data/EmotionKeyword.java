package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.IGNORE, columnNames = "eId,epId,keyword")
/* loaded from: classes10.dex */
public class EmotionKeyword extends Entity {
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
        if (getClass() != obj.getClass() || !(obj instanceof EmotionKeyword)) {
            return false;
        }
        EmotionKeyword emotionKeyword = (EmotionKeyword) obj;
        if (!this.epId.equals(emotionKeyword.epId) || !this.eId.equals(emotionKeyword.eId) || !this.keyword.equals(emotionKeyword.keyword)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.epId.hashCode() + this.eId.hashCode() + this.keyword.hashCode();
    }

    public void replace(EmotionKeyword emotionKeyword) {
        if (emotionKeyword != null) {
            this.exposeNum = emotionKeyword.exposeNum;
        }
    }

    public String toString() {
        return "EmotionKeyword{keyword='" + this.keyword + "', epId='" + this.epId + "', eId='" + this.eId + "', exposeNum=" + this.exposeNum + '}';
    }
}
