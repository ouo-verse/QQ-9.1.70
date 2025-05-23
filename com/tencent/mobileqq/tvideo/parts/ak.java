package com.tencent.mobileqq.tvideo.parts;

import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.mobileqq.tvideo.channel.event.QFSTVideoChannelClickEvent;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes19.dex */
public class ak extends q {
    public ak(QCircleLayerBean qCircleLayerBean, int i3) {
        super(qCircleLayerBean, i3);
    }

    @Override // com.tencent.mobileqq.tvideo.parts.q, com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        if (eventClass != null) {
            eventClass.remove(QFSTVideoChannelClickEvent.class);
        }
        return eventClass;
    }
}
