package com.tencent.biz.qqcircle.debug.controller;

import com.tencent.biz.qqcircle.immersive.feed.event.QFSShowFeedDebugEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;

/* compiled from: P */
/* loaded from: classes4.dex */
public class as extends bs {

    /* renamed from: d, reason: collision with root package name */
    private static final String f84203d = QCircleDebugKey$SwitchStateKey.QCIRCLE_FEED_DEBUG_INFO_CONTROLLER.name();

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String c() {
        return null;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String d() {
        return f84203d;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String e() {
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f195794fk);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.debug.controller.bs, com.tencent.qcircle.cooperation.config.debug.d
    public void g(int i3) {
        super.g(i3);
        SimpleEventBus.getInstance().dispatchEvent(new QFSShowFeedDebugEvent(n()));
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.d
    public int h() {
        return 0;
    }
}
