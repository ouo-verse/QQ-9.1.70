package com.tencent.biz.qqcircle.beans;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleTagChallenge implements Serializable {
    public String subTitle;
    public int tagChallengeRank;
    public String title;

    public String toString() {
        return "QCircleTagChallenge{title='" + this.title + "', subTitle='" + this.subTitle + "', tagChallengeRank=" + this.tagChallengeRank + '}';
    }
}
