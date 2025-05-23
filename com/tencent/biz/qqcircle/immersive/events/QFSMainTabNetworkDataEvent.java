package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import java.util.List;
import qqcircle.QQCircleFeedBase$StTabInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSMainTabNetworkDataEvent extends SimpleBaseEvent {
    public List<QQCircleFeedBase$StTabInfo> tabInfos;

    public QFSMainTabNetworkDataEvent(List<QQCircleFeedBase$StTabInfo> list) {
        this.tabInfos = list;
    }
}
