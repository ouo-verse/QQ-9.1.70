package com.tencent.biz.qqcircle.richframework.sender.iml.fake;

import com.tencent.biz.qqcircle.immersive.utils.z;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.richframework.sender.iml.QCircleFakeInterceptor;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qcircle.api.event.QCircleFollowUpdateEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import cooperation.qqcircle.helpers.QCircleFollowManager;
import x20.c;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a extends QCircleFakeInterceptor {

    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.richframework.sender.iml.fake.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0926a {

        /* renamed from: a, reason: collision with root package name */
        public String f92010a;

        /* renamed from: b, reason: collision with root package name */
        public int f92011b;

        /* renamed from: c, reason: collision with root package name */
        public int f92012c;

        public C0926a(String str, int i3, int i16) {
            this.f92010a = str;
            this.f92011b = i3;
            this.f92012c = i16;
        }
    }

    public a(boolean z16, Object obj) {
        super(z16, obj);
    }

    @Override // com.tencent.biz.qqcircle.richframework.sender.iml.QCircleFakeInterceptor
    public void d(QCircleBaseRequest qCircleBaseRequest, Object obj, BaseSenderChain baseSenderChain, Object obj2) {
        if (obj2 instanceof C0926a) {
            C0926a c0926a = (C0926a) obj2;
            QCircleFollowManager.getInstance().clearFakeUinFollowed(c0926a.f92010a);
            c.e(new y20.a(c0926a.f92010a, c0926a.f92011b));
            z.d(c0926a.f92010a, c0926a.f92011b);
            QLog.d("QCircleFollowFakeInterceptor", 1, "resetFake uin:" + c0926a.f92010a + "preFollowState:" + c0926a.f92011b + " newFollowState:" + c0926a.f92012c);
            QCircleFollowUpdateEvent qCircleFollowUpdateEvent = new QCircleFollowUpdateEvent(c0926a.f92011b, c0926a.f92010a);
            if (baseSenderChain.getListener() != null) {
                qCircleFollowUpdateEvent.mHashCode = baseSenderChain.getListener().hashCode();
            }
            SimpleEventBus.getInstance().dispatchEvent(qCircleFollowUpdateEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.richframework.sender.iml.QCircleFakeInterceptor
    public void e(QCircleBaseRequest qCircleBaseRequest, Object obj, BaseSenderChain baseSenderChain) {
        if (obj instanceof C0926a) {
            C0926a c0926a = (C0926a) obj;
            QCircleFollowManager.getInstance().setFakeUinFollowed(c0926a.f92010a, c0926a.f92012c);
            c.e(new y20.a(c0926a.f92010a, c0926a.f92012c));
            z.d(c0926a.f92010a, c0926a.f92012c);
            QCircleFollowUpdateEvent qCircleFollowUpdateEvent = new QCircleFollowUpdateEvent(c0926a.f92012c, c0926a.f92010a);
            if (baseSenderChain.getListener() != null) {
                qCircleFollowUpdateEvent.mHashCode = baseSenderChain.getListener().hashCode();
            }
            SimpleEventBus.getInstance().dispatchEvent(qCircleFollowUpdateEvent);
        }
    }
}
