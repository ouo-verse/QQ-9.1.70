package com.tencent.mobileqq.gamecenter.qa.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QASelectExpertsEvent extends SimpleBaseEvent {
    public List<String> selectedUinList = new ArrayList();
}
