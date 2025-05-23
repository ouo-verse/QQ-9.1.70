package com.tencent.biz.qqcircle.events;

import com.tencent.biz.qqcircle.manager.QCircleSpecialFollowManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleSpecialFollowListLoadEvent extends SimpleBaseEvent {
    public final boolean isRefresh;
    public final QCircleSpecialFollowManager.g resp;

    public QCircleSpecialFollowListLoadEvent(QCircleSpecialFollowManager.g gVar, boolean z16) {
        this.resp = gVar;
        this.isRefresh = z16;
    }
}
