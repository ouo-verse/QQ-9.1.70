package com.qzone.reborn.feedx.part;

import android.app.Activity;
import android.view.View;
import com.qzone.app.QZoneFeedAlertService;
import com.qzone.component.banner.Banner;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.util.Pair;
import common.config.service.QzoneConfig;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes37.dex */
public class bl extends g {

    /* renamed from: d, reason: collision with root package name */
    private gf.g f55054d;

    /* renamed from: e, reason: collision with root package name */
    private com.qzone.reborn.feedx.viewmodel.q f55055e;

    private void E9() {
        int singleUnreadCount = QZoneFeedAlertService.getInstance().getSingleUnreadCount(54);
        if (singleUnreadCount > 0) {
            I9(singleUnreadCount);
            return;
        }
        gf.g gVar = this.f55054d;
        if (gVar == null || !gVar.e(17)) {
            return;
        }
        G9();
    }

    private void F9(final com.qzone.feed.business.model.a aVar) {
        runOnActivityUiThread(new Runnable() { // from class: com.qzone.reborn.feedx.part.bk
            @Override // java.lang.Runnable
            public final void run() {
                bl.this.H9(aVar);
            }
        });
    }

    private void G9() {
        if (QZLog.isColorLevel()) {
            QZLog.d(getTAG(), 2, "VisitorBubbleBanner visitorUnread <= 0 but banner has been created, so hide it");
        }
        Banner k3 = this.f55054d.k(23);
        if (k3 != null) {
            k3.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H9(com.qzone.feed.business.model.a aVar) {
        this.f55054d.b(aVar);
    }

    private void I9(int i3) {
        ArrayList<QZoneCountUserInfo> arrayList;
        com.qzone.feed.business.model.a aVar = new com.qzone.feed.business.model.a();
        aVar.f47117a = 23;
        aVar.f47122f = new ArrayList<>();
        int A2 = this.f55055e.A2();
        aVar.f47124h = A2;
        com.qzone.adapter.feedcomponent.i.v2(A2);
        QZoneCountInfo singleUnReadItem = QZoneFeedAlertService.getInstance().getSingleUnReadItem(54);
        if (singleUnReadItem == null || (arrayList = singleUnReadItem.friendList) == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList<QZoneCountUserInfo> arrayList2 = singleUnReadItem.friendList;
        int min = Math.min(arrayList2.size(), 3);
        for (int i16 = 0; i16 < min; i16++) {
            aVar.f47122f.add(new Pair<>(arrayList2.get(i16), ""));
        }
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "VisitorBubbleBannerText", "\u4e2a\u65b0\u8bbf\u5ba2");
        if (i3 < 100) {
            aVar.f47119c = i3 + config;
        } else {
            aVar.f47119c = "99+" + config;
        }
        F9(aVar);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFeedxVisitorBubbleBannerPart";
    }

    @Override // com.qzone.reborn.feedx.part.g, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f55054d = (gf.g) getIocInterface(gf.g.class);
        this.f55055e = (com.qzone.reborn.feedx.viewmodel.q) getViewModel(com.qzone.reborn.feedx.viewmodel.q.class);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        E9();
    }
}
