package com.qzone.reborn.feedx.part;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.qzone.app.QZoneFeedAlertService;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tianshu.event.TianshuRedDataChangeEvent;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes37.dex */
public class al extends g implements IObserver.main, SimpleEventReceiver {

    /* renamed from: d, reason: collision with root package name */
    private gf.n f55004d;

    /* renamed from: e, reason: collision with root package name */
    private com.qzone.reborn.feedx.viewmodel.q f55005e;

    /* JADX INFO: Access modifiers changed from: private */
    public void F9() {
        if (H9() || this.f55005e.I2() || !TianshuRedTouch.INSTANCE.j()) {
            return;
        }
        dh.d dVar = dh.d.f393812a;
        dh.c x16 = dVar.x();
        dh.c u16 = dVar.u();
        if (dVar.m(x16)) {
            com.qzone.feed.business.model.a aVar = new com.qzone.feed.business.model.a();
            aVar.f47117a = 2;
            aVar.f47118b = 1;
            aVar.f47122f = dVar.w();
            this.f55004d.b(aVar);
            return;
        }
        if (dVar.l(u16)) {
            com.qzone.feed.business.model.a aVar2 = new com.qzone.feed.business.model.a();
            aVar2.f47117a = 2;
            aVar2.f47118b = 2;
            aVar2.f47122f = dVar.t();
            this.f55004d.b(aVar2);
        }
    }

    private boolean H9() {
        View findViewById;
        if (getPartRootView() == null || (findViewById = getPartRootView().findViewById(R.id.hlv)) == null || findViewById.getVisibility() != 0) {
            return false;
        }
        Rect rect = new Rect(0, 0, ImmersiveUtils.getScreenWidth(), ImmersiveUtils.getScreenHeight());
        findViewById.getGlobalVisibleRect(rect);
        QLog.d(getTAG(), 1, "isExitPassiveBubbleBanner  | visibleHeight = " + (rect.bottom - rect.top) + " | bubbleLayout.height = " + findViewById.getHeight());
        return rect.bottom - rect.top == findViewById.getHeight();
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
        return "QZoneFeedxMessageBubbleTopBannerPart";
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        if (TianshuRedTouch.INSTANCE.j()) {
            return;
        }
        Object[] objArr = (Object[]) event.params;
        if (!"UnRead".equals(event.source.getName()) || objArr == null || objArr.length <= 0) {
            return;
        }
        Object obj = objArr[0];
        if (obj instanceof Bundle) {
            G9((Bundle) obj);
        }
    }

    @Override // com.qzone.reborn.feedx.part.g, com.qzone.reborn.feedx.viewmodel.b
    public void onHandleMessage(Message message) {
        super.onHandleMessage(message);
        if (TianshuRedTouch.INSTANCE.j()) {
            return;
        }
        QZoneResult unpack = QZoneResult.unpack(message);
        if (message.what == 1000041) {
            E9(unpack);
        }
    }

    @Override // com.qzone.reborn.feedx.part.g, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f55005e = (com.qzone.reborn.feedx.viewmodel.q) getViewModel(com.qzone.reborn.feedx.viewmodel.q.class);
        this.f55004d = (gf.n) getIocInterface(gf.n.class);
        EventCenter.getInstance().addUIObserver(this, "UnRead", 1);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        EventCenter.getInstance().removeObserver(this);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof TianshuRedDataChangeEvent) {
            runOnActivityUiThread(new Runnable() { // from class: com.qzone.reborn.feedx.part.ak
                @Override // java.lang.Runnable
                public final void run() {
                    al.this.F9();
                }
            });
        }
    }

    private void E9(QZoneResult qZoneResult) {
        if (qZoneResult == null || !qZoneResult.getSucceed() || qZoneResult.getBundle() == null) {
            return;
        }
        long newCnt = qZoneResult.getNewCnt();
        boolean z16 = qZoneResult.getBundle().getInt(QZoneResult.KEY_SHOW_BANNER, 1) == 1;
        if (newCnt != 0 && z16 && (qZoneResult.getData() instanceof ArrayList)) {
            I9((ArrayList) qZoneResult.getData(), newCnt, qZoneResult.getJumpType());
        }
    }

    private void I9(ArrayList<Pair<QZoneCountUserInfo, String>> arrayList, long j3, int i3) {
        String str;
        if (arrayList == null || arrayList.size() <= 0 || arrayList.size() >= QZoneConfigHelper.R()) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        if (arrayList.size() == 1) {
            sb5.append(arrayList.get(0).second);
            str = com.qzone.util.l.a(R.string.rwy);
        } else {
            str = "";
        }
        if (arrayList.size() == 2) {
            sb5.append(arrayList.get(0).second);
            str = com.qzone.util.l.a(R.string.rwq);
        }
        if (arrayList.size() > 2) {
            sb5.append(arrayList.get(0).second);
            str = com.qzone.util.l.a(R.string.rwp) + j3 + com.qzone.util.l.a(R.string.rwu);
        }
        com.qzone.feed.business.model.a aVar = new com.qzone.feed.business.model.a();
        if (i3 == 1) {
            aVar.f47117a = 2;
            aVar.f47118b = 2;
        }
        aVar.f47119c = sb5.toString();
        aVar.f47120d = str;
        aVar.f47122f = arrayList;
        this.f55004d.b(aVar);
    }

    private void G9(Bundle bundle) {
        String string;
        if (bundle == null || (string = bundle.getString("com.tencent.qq.syncQZoneUnreadAction")) == null || TextUtils.isEmpty(string)) {
            return;
        }
        boolean d16 = this.f55004d.d();
        QZoneCountInfo singleUnReadItem = QZoneFeedAlertService.getInstance().getSingleUnReadItem(1);
        if (singleUnReadItem != null) {
            long j3 = 0;
            if (singleUnReadItem.uCount > 0 || !d16) {
                String str = singleUnReadItem.pushMesssage;
                if (TextUtils.isEmpty(str) || this.f55005e.I2() || H9()) {
                    return;
                }
                ArrayList<QZoneCountUserInfo> arrayList = singleUnReadItem.friendList;
                com.qzone.feed.business.model.a aVar = new com.qzone.feed.business.model.a();
                aVar.f47117a = 2;
                aVar.f47118b = 1;
                if (arrayList != null && arrayList.size() > 0) {
                    j3 = arrayList.get(0).uin;
                }
                aVar.f47121e = j3;
                if (arrayList != null) {
                    ArrayList<Pair<QZoneCountUserInfo, String>> arrayList2 = new ArrayList<>();
                    Iterator<QZoneCountUserInfo> it = arrayList.iterator();
                    while (it.hasNext()) {
                        QZoneCountUserInfo next = it.next();
                        if (next != null) {
                            arrayList2.add(new Pair<>(next, String.valueOf(next.uin)));
                        }
                    }
                    aVar.f47122f = arrayList2;
                }
                aVar.f47119c = str;
                if (d16) {
                    this.f55004d.b(aVar);
                    return;
                }
                return;
            }
        }
        this.f55004d.hide(2);
    }
}
