package com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.shell.QPlusTrafficHomeCardView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusCirStFeed;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusCirStGetMainPageCommDataRsp;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusCirStImage;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusCirStRecommendInfo;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusLiveStatus;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.shell.IQPlusTrafficCardHomeViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;

/* loaded from: classes31.dex */
public final class QPlusTrafficHomeVideoListViewModel implements IQPlusTrafficCardHomeViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPlusTrafficHomeVideoListViewModel.class, "scrollTopRefresh", "getScrollTopRefresh()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPlusTrafficHomeVideoListViewModel.class, "showMostItem", "getShowMostItem()Z", 0), IPagerIdKtxKt$$ExternalSyntheticOutline0.m(QPlusTrafficHomeVideoListViewModel.class, "feeds", "getFeeds()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPlusTrafficHomeVideoListViewModel.class, "selectItem", "getSelectItem()Lcom/tencent/hippykotlin/demo/pages/qplus_traffic/home/card/video/QPlusTrafficHomeVideoItemModel;", 0)};
    public QPlusCirStFeed initSelectFeed;
    public final String initSelectFeedId;
    public QPlusLiveStatus liveStatus;
    public final String uin;
    public final ReadWriteProperty scrollTopRefresh$delegate = c.a(0);
    public final ReadWriteProperty showMostItem$delegate = c.a(Boolean.FALSE);
    public final ReadWriteProperty feeds$delegate = c.b();
    public final ReadWriteProperty selectItem$delegate = c.a(new QPlusTrafficHomeVideoItemModel(new QPlusCirStFeed(null, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 1023)));

    public QPlusTrafficHomeVideoListViewModel(String str, String str2) {
        this.uin = str;
        this.initSelectFeedId = str2;
    }

    public final void addFeedAtFirst(QPlusCirStFeed qPlusCirStFeed) {
        QPlusTrafficHomeVideoItemModel qPlusTrafficHomeVideoItemModel;
        String str = qPlusCirStFeed.feedId;
        Iterator<QPlusTrafficHomeVideoItemModel> it = getFeeds().iterator();
        while (true) {
            if (!it.hasNext()) {
                qPlusTrafficHomeVideoItemModel = null;
                break;
            } else {
                qPlusTrafficHomeVideoItemModel = it.next();
                if (Intrinsics.areEqual(qPlusTrafficHomeVideoItemModel.info.feedId, str)) {
                    break;
                }
            }
        }
        if (qPlusTrafficHomeVideoItemModel != null) {
            return;
        }
        if (Intrinsics.areEqual(qPlusCirStFeed.feedId, "live_feed_id")) {
            if (hasLiveItem()) {
                CollectionsKt__MutableCollectionsKt.removeFirst(getFeeds());
            }
            getFeeds().add(0, new QPlusTrafficHomeVideoItemModel(qPlusCirStFeed));
        } else if (hasLiveItem()) {
            getFeeds().add(1, new QPlusTrafficHomeVideoItemModel(qPlusCirStFeed));
        } else {
            getFeeds().add(0, new QPlusTrafficHomeVideoItemModel(qPlusCirStFeed));
        }
        if (getFeeds().size() > 5) {
            this.showMostItem$delegate.setValue(this, $$delegatedProperties[1], Boolean.TRUE);
            CollectionsKt__MutableCollectionsKt.removeLast(getFeeds());
        }
        ReadWriteProperty readWriteProperty = this.scrollTopRefresh$delegate;
        KProperty<?>[] kPropertyArr = $$delegatedProperties;
        this.scrollTopRefresh$delegate.setValue(this, kPropertyArr[0], Integer.valueOf(((Number) readWriteProperty.getValue(this, kPropertyArr[0])).intValue() + 1));
    }

    public final QPlusTrafficHomeVideoItemModel createLiveItemModel(QPlusLiveStatus qPlusLiveStatus) {
        return new QPlusTrafficHomeVideoItemModel(new QPlusCirStFeed("live_feed_id", new QPlusCirStImage(qPlusLiveStatus.cover), OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0.m(new StringBuilder(), qPlusLiveStatus.name, "\u76f4\u64ad\u95f4"), 942), qPlusLiveStatus);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qplus_traffic.shell.IQPlusTrafficCardHomeViewModel
    public final QPlusTrafficHomeCardView getCardView() {
        return new QPlusTrafficHomeVideoList();
    }

    public final com.tencent.kuikly.core.reactive.collection.c<QPlusTrafficHomeVideoItemModel> getFeeds() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.feeds$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final QPlusTrafficHomeVideoItemModel getSelectItem() {
        return (QPlusTrafficHomeVideoItemModel) this.selectItem$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final boolean hasLiveItem() {
        Object first;
        if (!getFeeds().isEmpty()) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) getFeeds());
            if (((QPlusTrafficHomeVideoItemModel) first).isLiveItem()) {
                return true;
            }
        }
        return false;
    }

    public final boolean isSameFeeds(com.tencent.kuikly.core.reactive.collection.c<QPlusTrafficHomeVideoItemModel> cVar) {
        boolean equals$default;
        QPlusCirStFeed qPlusCirStFeed;
        if (getFeeds().isEmpty()) {
            return false;
        }
        Iterator<QPlusTrafficHomeVideoItemModel> it = cVar.iterator();
        boolean z16 = true;
        int i3 = 0;
        while (it.hasNext()) {
            QPlusTrafficHomeVideoItemModel next = it.next();
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            QPlusTrafficHomeVideoItemModel qPlusTrafficHomeVideoItemModel = next;
            if (i3 < 5) {
                QPlusTrafficHomeVideoItemModel qPlusTrafficHomeVideoItemModel2 = getFeeds().size() > i3 ? getFeeds().get(i3) : null;
                equals$default = StringsKt__StringsJVMKt.equals$default((qPlusTrafficHomeVideoItemModel2 == null || (qPlusCirStFeed = qPlusTrafficHomeVideoItemModel2.info) == null) ? null : qPlusCirStFeed.feedId, qPlusTrafficHomeVideoItemModel.info.feedId, false, 2, null);
                if (!equals$default) {
                    z16 = false;
                }
            }
            i3 = i16;
        }
        return z16;
    }

    public final void resetVideo(QPlusCirStGetMainPageCommDataRsp qPlusCirStGetMainPageCommDataRsp) {
        boolean z16;
        Object first;
        if (qPlusCirStGetMainPageCommDataRsp.vecFeed == null) {
            return;
        }
        QPlusLiveStatus qPlusLiveStatus = this.liveStatus;
        QPlusCirStFeed qPlusCirStFeed = this.initSelectFeed;
        com.tencent.kuikly.core.reactive.collection.c<QPlusTrafficHomeVideoItemModel> cVar = new com.tencent.kuikly.core.reactive.collection.c<>(null, null, null, 7, null);
        long currentTimeStamp = Utils.INSTANCE.currentBridgeModule().currentTimeStamp() / 1000;
        ArrayList<QPlusCirStFeed> arrayList = qPlusCirStGetMainPageCommDataRsp.vecFeed;
        if (arrayList != null) {
            z16 = false;
            for (QPlusCirStFeed qPlusCirStFeed2 : arrayList) {
                if (currentTimeStamp - qPlusCirStFeed2.createTime <= 7776000) {
                    if (cVar.size() >= 5) {
                        this.showMostItem$delegate.setValue(this, $$delegatedProperties[1], Boolean.TRUE);
                    } else {
                        QPlusCirStRecommendInfo qPlusCirStRecommendInfo = qPlusCirStFeed2.recommendInfo;
                        if (qPlusCirStRecommendInfo != null && qPlusCirStRecommendInfo.recommendStatus == 1) {
                            if (!z16) {
                                if (!Intrinsics.areEqual(qPlusCirStFeed2.feedId, qPlusCirStFeed != null ? qPlusCirStFeed.feedId : null)) {
                                    z16 = false;
                                    cVar.add(new QPlusTrafficHomeVideoItemModel(qPlusCirStFeed2));
                                }
                            }
                            z16 = true;
                            cVar.add(new QPlusTrafficHomeVideoItemModel(qPlusCirStFeed2));
                        }
                    }
                }
            }
        } else {
            z16 = false;
        }
        if (qPlusCirStFeed != null && !z16) {
            QPlusTrafficHomeVideoItemModel qPlusTrafficHomeVideoItemModel = new QPlusTrafficHomeVideoItemModel(qPlusCirStFeed);
            qPlusTrafficHomeVideoItemModel.setSelect(true);
            Unit unit = Unit.INSTANCE;
            cVar.add(0, qPlusTrafficHomeVideoItemModel);
        }
        if (qPlusLiveStatus != null) {
            cVar.add(0, createLiveItemModel(qPlusLiveStatus));
        }
        if (isSameFeeds(cVar)) {
            return;
        }
        getFeeds().clear();
        getFeeds().addAll(cVar);
        if (this.initSelectFeedId.length() > 0) {
            Iterator<QPlusTrafficHomeVideoItemModel> it = cVar.iterator();
            while (it.hasNext()) {
                QPlusTrafficHomeVideoItemModel next = it.next();
                if (Intrinsics.areEqual(next.info.feedId, this.initSelectFeedId)) {
                    selectFeed(next.info.feedId);
                    this.initSelectFeed = null;
                }
            }
            return;
        }
        if (!cVar.isEmpty()) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) cVar);
            selectItemModel((QPlusTrafficHomeVideoItemModel) first);
        }
    }

    public final void selectFeed(String str) {
        for (QPlusTrafficHomeVideoItemModel qPlusTrafficHomeVideoItemModel : getFeeds()) {
            if (Intrinsics.areEqual(qPlusTrafficHomeVideoItemModel.info.feedId, str)) {
                getSelectItem().setSelect(false);
                qPlusTrafficHomeVideoItemModel.setSelect(true);
                this.selectItem$delegate.setValue(this, $$delegatedProperties[3], qPlusTrafficHomeVideoItemModel);
                return;
            }
        }
    }

    public final void selectItemModel(QPlusTrafficHomeVideoItemModel qPlusTrafficHomeVideoItemModel) {
        selectFeed(qPlusTrafficHomeVideoItemModel.info.feedId);
        this.initSelectFeed = null;
    }
}
