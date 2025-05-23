package com.qzone.reborn.feedx.part;

import android.app.Activity;
import android.view.View;
import com.qzone.app.QZoneFeedAlertService;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.component.banner.Banner;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tianshu.event.TianshuRedDataChangeEvent;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes37.dex */
public class at extends g implements IObserver.main, SimpleEventReceiver {

    /* renamed from: d, reason: collision with root package name */
    private gf.g f55020d;

    /* renamed from: e, reason: collision with root package name */
    private com.qzone.reborn.feedx.viewmodel.q f55021e;

    private com.qzone.feed.business.model.a E9(int i3) {
        com.qzone.feed.business.model.a aVar = new com.qzone.feed.business.model.a();
        aVar.f47117a = 17;
        aVar.f47122f = new ArrayList<>();
        aVar.f47124h = this.f55021e.A2();
        if (i3 < 100) {
            aVar.f47119c = i3 + com.qzone.util.l.a(R.string.rwl);
        } else {
            aVar.f47119c = com.qzone.util.l.a(R.string.rwz);
        }
        return aVar;
    }

    private com.qzone.feed.business.model.a F9(int i3) {
        com.qzone.feed.business.model.a aVar = new com.qzone.feed.business.model.a();
        aVar.f47117a = 17;
        aVar.f47122f = dh.d.f393812a.r();
        aVar.f47124h = this.f55021e.A2();
        if (i3 < 100) {
            aVar.f47119c = i3 + com.qzone.util.l.a(R.string.rwl);
        } else {
            aVar.f47119c = com.qzone.util.l.a(R.string.rwz);
        }
        return aVar;
    }

    private void H9() {
        QLog.d(getTAG(), 1, "checkShowPassiveFeedBubbleNew");
        int D = dh.d.f393812a.D();
        if (D > 0) {
            N9(D);
        } else {
            K9();
        }
    }

    private void I9(final com.qzone.feed.business.model.a aVar) {
        runOnActivityUiThread(new Runnable() { // from class: com.qzone.reborn.feedx.part.as
            @Override // java.lang.Runnable
            public final void run() {
                at.this.L9(aVar);
            }
        });
    }

    private void J9(Event event) {
        if (event.what == 1) {
            QZLog.d(getTAG(), 1, "receive unread change event");
            G9();
        }
    }

    private void K9() {
        if (QZLog.isColorLevel()) {
            QZLog.d(getTAG(), 2, "PassiveFeedBubbleBanner passiveFeedUnread <= 0 but banner has been created, so hide it");
        }
        Banner k3 = this.f55020d.k(17);
        if (k3 != null) {
            k3.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L9(com.qzone.feed.business.model.a aVar) {
        this.f55020d.b(aVar);
    }

    private void M9(int i3) {
        com.qzone.feed.business.model.a E9 = E9(i3);
        com.qzone.adapter.feedcomponent.i.v2(E9.f47124h);
        ArrayList<QZoneCountUserInfo> qZonePassiveUnreadUserList = QZoneFeedAlertService.getInstance().getQZonePassiveUnreadUserList();
        if (qZonePassiveUnreadUserList == null || qZonePassiveUnreadUserList.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i16 = 0; i16 < qZonePassiveUnreadUserList.size(); i16++) {
            QZoneCountUserInfo qZoneCountUserInfo = qZonePassiveUnreadUserList.get(i16);
            Pair<QZoneCountUserInfo, String> pair = new Pair<>(qZoneCountUserInfo, "");
            if (qZoneCountUserInfo != null && !arrayList.contains(Long.valueOf(qZoneCountUserInfo.uin))) {
                E9.f47122f.add(pair);
                arrayList.add(Long.valueOf(qZoneCountUserInfo.uin));
            }
            if (arrayList.size() >= 3) {
                break;
            }
        }
        I9(E9);
    }

    private void N9(int i3) {
        com.qzone.feed.business.model.a F9 = F9(i3);
        com.qzone.adapter.feedcomponent.i.v2(F9.f47124h);
        I9(F9);
    }

    public void G9() {
        if (TianshuRedTouch.INSTANCE.j()) {
            H9();
            return;
        }
        QZLog.d(getTAG(), 1, "checkShowPassiveFeedBubble");
        int qZonePassiveUnreadTotal = QZoneFeedAlertService.getInstance().getQZonePassiveUnreadTotal();
        if (qZonePassiveUnreadTotal > 0) {
            M9(qZonePassiveUnreadTotal);
            QZLog.d(getTAG(), 1, "PassiveFeedBubbleBanner passiveFeedUnread: " + qZonePassiveUnreadTotal);
            return;
        }
        gf.g gVar = this.f55020d;
        if (gVar == null || !gVar.e(17)) {
            return;
        }
        K9();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(TianshuRedDataChangeEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFeedxPassiveFeedBubbleBannerPart";
    }

    @Override // com.qzone.reborn.feedx.part.g, com.qzone.reborn.feedx.viewmodel.b
    public void i6() {
        super.i6();
        G9();
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        if ("UnRead".equals(event.source.getName())) {
            J9(event);
        }
    }

    @Override // com.qzone.reborn.feedx.part.g, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f55020d = (gf.g) getIocInterface(gf.g.class);
        this.f55021e = (com.qzone.reborn.feedx.viewmodel.q) getViewModel(com.qzone.reborn.feedx.viewmodel.q.class);
        EventCenter.getInstance().addUIObserver(this, "UnRead", 1);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        EventCenter.getInstance().removeObserver(this);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        G9();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if ((simpleBaseEvent instanceof TianshuRedDataChangeEvent) && TianshuRedTouch.INSTANCE.j()) {
            H9();
        }
    }
}
