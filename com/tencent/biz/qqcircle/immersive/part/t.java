package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.qqcircle.events.QCircleTabPageFeedUpdateEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.creatorad.api.ICreatorAd;
import com.tencent.mobileqq.qroute.QRoute;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class t extends u implements SimpleEventReceiver {
    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCircleTabPageFeedUpdateEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSBannerAdPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleTabPageFeedUpdateEvent) {
            x9(((QCircleTabPageFeedUpdateEvent) simpleBaseEvent).getFeedList());
        }
    }

    public void x9(List<e30.b> list) {
        ArrayList arrayList = new ArrayList();
        for (e30.b bVar : list) {
            if (com.tencent.biz.qqcircle.utils.p.a(bVar)) {
                FeedCloudMeta$StFeed g16 = bVar.g();
                if (g16.liteBanner.business_type.get() == 9) {
                    arrayList.add(g16.poster.f398463id.get() + "_1_" + g16.f398449id.get());
                }
            }
        }
        if (!arrayList.isEmpty()) {
            ((ICreatorAd) QRoute.api(ICreatorAd.class)).preloadAdList(arrayList, 21);
        }
    }
}
