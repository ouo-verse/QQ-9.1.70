package com.qzone.common.activities.base;

import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.luan.ioc.annotation.Inject;
import com.tencent.mobileqq.app.ThreadManagerV2;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.TimeCostTrace;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class BaseFeedFragmentEventImp implements d5.i, IObserver.main, IObserver.background {

    /* renamed from: d, reason: collision with root package name */
    private final QZoneBaseFeedFragment f45024d;

    /* renamed from: e, reason: collision with root package name */
    private d5.l f45025e;

    @Inject
    public BaseFeedFragmentEventImp(QZoneBaseFeedFragment qZoneBaseFeedFragment) {
        this.f45024d = qZoneBaseFeedFragment;
    }

    @Override // d5.i
    public void a() {
        EventCenter.getInstance().addUIObserver(this, "Feed", 1, 4);
        EventCenter.getInstance().addObserver(this, 3, "Feed", 26);
    }

    @Override // d5.i
    public void b(String str, int i3, Object... objArr) {
        EventCenter.getInstance().post(str, i3, objArr);
    }

    @Override // d5.i
    public void c() {
        EventCenter.getInstance().removeObserver(this);
    }

    @Override // com.qzone.common.event.IObserver.background
    public void onEventBackgroundThread(Event event) {
        if (event.what != 26) {
            return;
        }
        this.f45024d.sj(false);
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        QZoneBaseFeedFragment qZoneBaseFeedFragment;
        QZoneBaseFeedFragment qZoneBaseFeedFragment2 = this.f45024d;
        if (qZoneBaseFeedFragment2 != null && !qZoneBaseFeedFragment2.isFinishing()) {
            if (event.source.getSender() == this.f45024d.si()) {
                int i3 = event.what;
                if (i3 != 1) {
                    if (i3 != 4) {
                        return;
                    }
                    try {
                        this.f45025e.g(event.params);
                        if (com.qzone.adapter.feedcomponent.i.H().g1()) {
                            this.f45024d.gj();
                        }
                        this.f45024d.hj(1000L);
                        return;
                    } catch (Exception e16) {
                        QZLog.e("BaseFeedFragmentEventIm", "EVENT_FEED_PARTION_CHANGE error;", e16);
                        return;
                    }
                }
                QZLog.w(TimeCostTrace.TAG_QZONE_LAUNCH, "notifyFeedDataChange end");
                Object obj = event.params;
                if (obj instanceof Object[]) {
                    Object[] objArr = (Object[]) obj;
                    if (objArr.length < 2) {
                        return;
                    }
                    int intValue = ((Integer) objArr[1]).intValue();
                    boolean z16 = (intValue != 1 || this.f45024d.C == 1) && (intValue != 2 || this.f45024d.C == 2) && (intValue != 3 || this.f45024d.C == 3);
                    QZoneBaseFeedFragment qZoneBaseFeedFragment3 = this.f45024d;
                    com.qzone.feed.business.service.a si5 = qZoneBaseFeedFragment3 == null ? null : qZoneBaseFeedFragment3.si();
                    com.qzone.adapter.feedcomponent.k F = si5 == null ? null : si5.F();
                    if (F != null) {
                        F.b(5);
                        final com.qzone.adapter.feedcomponent.k clone = F.clone();
                        F.d();
                        ThreadManagerV2.post(new Runnable() { // from class: com.qzone.common.activities.base.BaseFeedFragmentEventImp.1
                            @Override // java.lang.Runnable
                            public void run() {
                                clone.c();
                            }
                        }, 5, null, false);
                    }
                    if (z16 && (qZoneBaseFeedFragment = this.f45024d) != null) {
                        List<BusinessFeedData> list = (List) objArr[0];
                        qZoneBaseFeedFragment.Pi(list);
                        TimeCostTrace.getTrace(TimeCostTrace.TAG_QZONE_LAUNCH).startStep("updateFeedData:" + intValue);
                        this.f45024d.Aj(list, intValue == 1);
                        this.f45024d.Ai(list, intValue == 0);
                        this.f45024d.getHandler().postDelayed(new Runnable() { // from class: com.qzone.common.activities.base.BaseFeedFragmentEventImp.2
                            @Override // java.lang.Runnable
                            public void run() {
                                BaseFeedFragmentEventImp.this.f45024d.ab();
                            }
                        }, 1000L);
                        TimeCostTrace.getTrace(TimeCostTrace.TAG_QZONE_LAUNCH).stopStep("updateFeedData:" + intValue);
                        if (intValue == 1) {
                            TimeCostTrace.getTrace(TimeCostTrace.TAG_QZONE_REFRESH).stopStep("updateFeeds");
                            TimeCostTrace.getTrace(TimeCostTrace.TAG_QZONE_REFRESH).stopStep("100");
                            this.f45024d.pj(TimeCostTrace.getTrace(TimeCostTrace.TAG_QZONE_REFRESH), true);
                            TimeCostTrace.getTrace(TimeCostTrace.TAG_QZONE_REFRESH).destroy();
                            return;
                        }
                        TimeCostTrace.getTrace(TimeCostTrace.TAG_QZONE_REFRESH_MORE).stopStep("updateFeeds");
                        TimeCostTrace.getTrace(TimeCostTrace.TAG_QZONE_REFRESH_MORE).stopStep("101");
                        this.f45024d.pj(TimeCostTrace.getTrace(TimeCostTrace.TAG_QZONE_REFRESH_MORE), false);
                        TimeCostTrace.getTrace(TimeCostTrace.TAG_QZONE_REFRESH_MORE).destroy();
                        return;
                    }
                    QZLog.w(QZLog.TO_DEVICE_TAG, "QZoneBaseFeedFragment onLogicEventUI() failed, type: " + intValue + "\t reqType:" + this.f45024d.C);
                    return;
                }
                return;
            }
            return;
        }
        QZLog.i(QZLog.TO_DEVICE_TAG, 2, "QZoneBaseFriendFeedFragment\u4e0d\u53ef\u89c1\uff0cevent\u4e0d\u5904\u7406", String.valueOf(event));
    }

    @Inject
    public void setFeedInf(d5.l lVar) {
        this.f45025e = lVar;
    }
}
