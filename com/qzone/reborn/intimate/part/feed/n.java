package com.qzone.reborn.intimate.part.feed;

import android.app.Activity;
import android.view.View;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.intimate.event.QZoneIntimateDeleteFeedEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nk.ar;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016J$\u0010\u0011\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000f0\u000ej\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000f`\u0010H\u0016J\u0012\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/qzone/reborn/intimate/part/feed/n;", "Lcom/qzone/reborn/intimate/part/feed/QZoneIntimateBaseFeedOperateDialogPart;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/qzone/reborn/intimate/event/QZoneIntimateDeleteFeedEvent;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "N9", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "", "getDtPageId", "<init>", "()V", "f", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class n extends QZoneIntimateBaseFeedOperateDialogPart implements SimpleEventReceiver<QZoneIntimateDeleteFeedEvent> {
    @Override // com.qzone.reborn.intimate.part.feed.QZoneIntimateBaseFeedOperateDialogPart
    public void N9(BusinessFeedData feedData) {
        ar arVar;
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        if (getHostFragment() == null || getHostFragment().isDetached() || getHostFragment().getFragmentManager() == null || (arVar = (ar) getViewModel(ar.class)) == null) {
            return;
        }
        arVar.X1(feedData);
    }

    @Override // com.qzone.reborn.intimate.part.feed.QZoneIntimateBaseFeedOperateDialogPart
    public String getDtPageId() {
        return "pg_qz_intimate_space_home";
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<QZoneIntimateDeleteFeedEvent>> getEventClass() {
        ArrayList<Class<QZoneIntimateDeleteFeedEvent>> arrayList = new ArrayList<>();
        arrayList.add(QZoneIntimateDeleteFeedEvent.class);
        return arrayList;
    }

    @Override // com.qzone.reborn.intimate.part.feed.QZoneIntimateBaseFeedOperateDialogPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof QZoneIntimateDeleteFeedEvent) {
            N9(((QZoneIntimateDeleteFeedEvent) event).getFeedData());
        }
    }
}
