package com.tencent.biz.qqcircle.beans;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleTagChallengeInfo implements Serializable {
    public QCircleTagChallenge mTagChallenge;
    public String mTagId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        String str = this.mTagId;
        String str2 = ((QCircleTagChallengeInfo) obj).mTagId;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.mTagId;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "QCircleTagChallengeInfo{mTagId='" + this.mTagId + "', mTagChallenge=" + this.mTagChallenge + '}';
    }
}
