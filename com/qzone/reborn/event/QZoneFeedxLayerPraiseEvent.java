package com.qzone.reborn.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes37.dex */
public class QZoneFeedxLayerPraiseEvent extends SimpleBaseEvent {
    public boolean isPraise;
    public int likeNum;
    public String lloc;

    public QZoneFeedxLayerPraiseEvent(boolean z16, int i3, String str) {
        this.isPraise = z16;
        this.likeNum = i3;
        this.lloc = str;
    }
}
