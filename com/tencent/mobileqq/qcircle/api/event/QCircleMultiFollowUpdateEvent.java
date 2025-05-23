package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleMultiFollowUpdateEvent extends SimpleBaseEvent {
    public HashMap<String, Integer> mUserFollowStatusMap;

    public QCircleMultiFollowUpdateEvent(HashMap<String, Integer> hashMap) {
        this.mUserFollowStatusMap = hashMap;
    }
}
