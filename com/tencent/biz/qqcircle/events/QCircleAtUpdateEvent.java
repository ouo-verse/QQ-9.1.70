package com.tencent.biz.qqcircle.events;

import android.content.Context;
import android.content.Intent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleAtUpdateEvent extends SimpleBaseEvent {
    public Intent mData;

    public QCircleAtUpdateEvent(Context context, Intent intent) {
        int i3;
        this.mData = intent;
        if (context != null) {
            i3 = context.hashCode();
        } else {
            i3 = 0;
        }
        this.mHashCode = i3;
    }
}
