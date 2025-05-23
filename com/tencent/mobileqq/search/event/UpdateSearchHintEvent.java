package com.tencent.mobileqq.search.event;

import circlesearch.CircleSearchExhibition$UnifySearchResultExt;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes18.dex */
public class UpdateSearchHintEvent extends SimpleBaseEvent {
    public final CircleSearchExhibition$UnifySearchResultExt unifySearchResultExt;

    public UpdateSearchHintEvent(CircleSearchExhibition$UnifySearchResultExt circleSearchExhibition$UnifySearchResultExt) {
        this.unifySearchResultExt = circleSearchExhibition$UnifySearchResultExt;
    }
}
