package com.tencent.mobileqq.qcircle.api.requests;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudCommon$StCommonExt;
import java.util.List;
import qqcircle.QQCircleCounter$RedPointInfo;

/* loaded from: classes16.dex */
public class QCircleRedPointEvent extends SimpleBaseEvent {
    public FeedCloudCommon$StCommonExt mExtInfo;
    public List<QQCircleCounter$RedPointInfo> mRedPointInfoList;
    public int mRedPointMainMsgType;
    public int mRedPointSubMsgType;

    public QCircleRedPointEvent(int i3, int i16, List<QQCircleCounter$RedPointInfo> list, FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt) {
        this.mRedPointMainMsgType = i3;
        this.mRedPointSubMsgType = i16;
        this.mRedPointInfoList = list;
        this.mExtInfo = feedCloudCommon$StCommonExt;
    }
}
