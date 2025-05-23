package com.tencent.mobileqq.guild.feed.util;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes13.dex */
public class bl {

    /* renamed from: a, reason: collision with root package name */
    private static bl f223892a;

    bl() {
    }

    public static bl c() {
        if (f223892a == null) {
            synchronized (bl.class) {
                if (f223892a == null) {
                    f223892a = new bl();
                }
            }
        }
        return f223892a;
    }

    public void a(SimpleBaseEvent simpleBaseEvent) {
        b(simpleBaseEvent, false);
    }

    public void b(SimpleBaseEvent simpleBaseEvent, boolean z16) {
        SimpleEventBus.getInstance().dispatchEvent(simpleBaseEvent, z16);
        QLog.d("GUP-eb-SimpleEventBusLogHelper", 1, "dispatchEvent isIpc:" + z16 + " ->", simpleBaseEvent);
    }

    public void d(SimpleEventReceiver simpleEventReceiver) {
        SimpleEventBus.getInstance().registerReceiver(simpleEventReceiver);
        QLog.d("GUP-eb-SimpleEventBusLogHelper", 1, "registerReceiver receiver:" + simpleEventReceiver);
    }

    public void e(SimpleEventReceiver simpleEventReceiver) {
        SimpleEventBus.getInstance().unRegisterReceiver(simpleEventReceiver);
        QLog.d("GUP-eb-SimpleEventBusLogHelper", 1, "unRegisterReceiver receiver:" + simpleEventReceiver);
    }
}
