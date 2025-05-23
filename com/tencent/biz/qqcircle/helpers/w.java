package com.tencent.biz.qqcircle.helpers;

import com.tencent.biz.qqcircle.manager.diffres.beans.QFSQQVipLikeResPackage;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.qcircle.api.event.QCircleNotifyClearCacheEvent;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.qphone.base.util.QLog;
import fa0.d;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class w implements d.a, SimpleEventReceiver {

    /* renamed from: e, reason: collision with root package name */
    private static volatile w f84669e;

    /* renamed from: d, reason: collision with root package name */
    private final fa0.d<QFSQQVipLikeResPackage> f84670d = new fa0.d<>(QFSQQVipLikeResPackage.getDefaultResBean());

    w() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    public static w a() {
        if (f84669e == null) {
            synchronized (r.class) {
                if (f84669e == null) {
                    f84669e = new w();
                }
            }
        }
        return f84669e;
    }

    @Override // fa0.d.a
    public void A2() {
        QLog.d("QFSQQVipLikeResLoadHelper", 1, "onPreloadSucceed");
    }

    public String b(String str) {
        fa0.d<QFSQQVipLikeResPackage> dVar = this.f84670d;
        return dVar.n(dVar.o().mCommentQQVipLikeResUrl, null, str);
    }

    public String c(String str) {
        fa0.d<QFSQQVipLikeResPackage> dVar = this.f84670d;
        return dVar.n(dVar.o().mFeedQQVipLikeLineResUrl, null, str);
    }

    public boolean d() {
        return this.f84670d.r();
    }

    public void e() {
        if (!this.f84670d.r()) {
            QLog.d("QFSQQVipLikeResLoadHelper", 1, "[preLoadRes]");
            this.f84670d.x(this);
            this.f84670d.v();
            return;
        }
        QLog.d("QFSQQVipLikeResLoadHelper", 1, "[preLoadRes] has loaded");
    }

    public boolean f() {
        if (!QCircleHostGlobalInfo.isQQVip()) {
            return false;
        }
        return this.f84670d.w();
    }

    public boolean g() {
        if (!QCircleHostGlobalInfo.isQQVip() || !uq3.c.Z()) {
            return false;
        }
        if (d()) {
            return true;
        }
        QLog.e("QFSQQVipLikeResLoadHelper", 1, "[useQQVipLike] res not download success");
        e();
        return false;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QCircleNotifyClearCacheEvent.class);
        return arrayList;
    }

    @Override // fa0.d.a
    public void h4() {
        QLog.e("QFSQQVipLikeResLoadHelper", 1, "onPreloadError");
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleNotifyClearCacheEvent) {
            QLog.d("QFSQQVipLikeResLoadHelper", 1, "[onReceiveEvent] clear cache event, reset preload success flag.");
            f();
        }
    }
}
