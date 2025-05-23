package com.tencent.biz.qqcircle.immersive.feed.event;

import com.tencent.biz.qqcircle.beans.QCircleTagChallengeInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSTagChallengeInfoEvent extends SimpleBaseEvent {
    private List<QCircleTagChallengeInfo> mTagChallengeInfoList;

    public QFSTagChallengeInfoEvent(List<QCircleTagChallengeInfo> list) {
        this.mTagChallengeInfoList = list;
    }

    public List<QCircleTagChallengeInfo> getTagChallengeInfoList() {
        return this.mTagChallengeInfoList;
    }
}
