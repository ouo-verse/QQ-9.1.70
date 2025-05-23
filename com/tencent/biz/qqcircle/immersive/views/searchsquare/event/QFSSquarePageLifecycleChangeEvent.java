package com.tencent.biz.qqcircle.immersive.views.searchsquare.event;

import androidx.lifecycle.Lifecycle;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QFSSquarePageLifecycleChangeEvent extends SimpleBaseEvent {
    public final Lifecycle.Event event;

    public QFSSquarePageLifecycleChangeEvent(Lifecycle.Event event) {
        this.event = event;
    }
}
