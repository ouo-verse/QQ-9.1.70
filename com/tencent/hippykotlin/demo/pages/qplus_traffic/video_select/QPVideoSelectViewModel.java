package com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.define.QPlusTrafficUIState;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoItemModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.QPlusCirFeedRepository;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusCirStFeed;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusCirStGetMainPageCommDataRsp;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusCirStRecommendInfo;
import com.tencent.kuikly.core.views.FooterRefreshState;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class QPVideoSelectViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPVideoSelectViewModel.class, "uiState", "getUiState()Lcom/tencent/hippykotlin/demo/pages/qplus_traffic/define/QPlusTrafficUIState;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPVideoSelectViewModel.class, "footerRefreshState", "getFooterRefreshState()Lcom/tencent/kuikly/core/views/FooterRefreshState;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPVideoSelectViewModel.class, "isFinish", "isFinish()Z", 0), IPagerIdKtxKt$$ExternalSyntheticOutline0.m(QPVideoSelectViewModel.class, "feeds", "getFeeds()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPVideoSelectViewModel.class, "selectItem", "getSelectItem()Lcom/tencent/hippykotlin/demo/pages/qplus_traffic/home/card/video/QPlusTrafficHomeVideoItemModel;", 0)};
    public String feedAttachInfo;
    public final ArrayList<String> feedIds;
    public final ReadWriteProperty feeds$delegate;
    public final ReadWriteProperty isFinish$delegate;
    public final ReadWriteProperty selectItem$delegate;
    public String uin = "";
    public final ReadWriteProperty uiState$delegate = c.a(QPlusTrafficUIState.LOADING);

    public QPVideoSelectViewModel() {
        c.a(FooterRefreshState.IDLE);
        this.isFinish$delegate = c.a(Boolean.FALSE);
        this.feedAttachInfo = "";
        this.feedIds = new ArrayList<>();
        this.feeds$delegate = c.b();
        this.selectItem$delegate = c.a(null);
    }

    public final com.tencent.kuikly.core.reactive.collection.c<QPlusTrafficHomeVideoItemModel> getFeeds() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.feeds$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final QPlusTrafficHomeVideoItemModel getSelectItem() {
        return (QPlusTrafficHomeVideoItemModel) this.selectItem$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final QPlusTrafficUIState getUiState() {
        return (QPlusTrafficUIState) this.uiState$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final boolean isFinish() {
        return ((Boolean) this.isFinish$delegate.getValue(this, $$delegatedProperties[2])).booleanValue();
    }

    public final void loadMore() {
        if (isFinish()) {
            return;
        }
        QPlusTrafficUIState uiState = getUiState();
        QPlusTrafficUIState qPlusTrafficUIState = QPlusTrafficUIState.LOADING;
        if (uiState == qPlusTrafficUIState) {
            return;
        }
        setUiState(qPlusTrafficUIState);
        QPlusCirFeedRepository qPlusCirFeedRepository = QPlusCirFeedRepository.INSTANCE;
        String str = this.uin;
        if (str.length() == 0) {
            str = Utils.INSTANCE.currentBridgeModule().getCurrentAccount();
        }
        qPlusCirFeedRepository.reqCirFeedList(str, this.feedAttachInfo, new Function1<QPlusCirStGetMainPageCommDataRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectViewModel$loadMore$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(QPlusCirStGetMainPageCommDataRsp qPlusCirStGetMainPageCommDataRsp) {
                QPVideoSelectViewModel.this.handleReqSuccess(qPlusCirStGetMainPageCommDataRsp, false);
                return Unit.INSTANCE;
            }
        }, new QPVideoSelectViewModel$handleReqFailure$1(this));
    }

    public final void setUiState(QPlusTrafficUIState qPlusTrafficUIState) {
        this.uiState$delegate.setValue(this, $$delegatedProperties[0], qPlusTrafficUIState);
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0099, code lost:
    
        if ((r3 - ((com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusCirStFeed) r12).createTime) > 7776000) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void handleReqSuccess(QPlusCirStGetMainPageCommDataRsp qPlusCirStGetMainPageCommDataRsp, boolean z16) {
        ArrayList<QPlusCirStFeed> arrayList;
        Object last;
        ArrayList<QPlusCirStFeed> arrayList2;
        String str;
        if (!z16) {
            this.isFinish$delegate.setValue(this, $$delegatedProperties[2], Boolean.valueOf(qPlusCirStGetMainPageCommDataRsp != null && qPlusCirStGetMainPageCommDataRsp.isFinish == 1));
            if (qPlusCirStGetMainPageCommDataRsp == null || (str = qPlusCirStGetMainPageCommDataRsp.feedAttchInfo) == null) {
                str = "";
            }
            this.feedAttachInfo = str;
        }
        long currentTimeStamp = Utils.INSTANCE.currentBridgeModule().currentTimeStamp() / 1000;
        if (qPlusCirStGetMainPageCommDataRsp != null && (arrayList2 = qPlusCirStGetMainPageCommDataRsp.vecFeed) != null) {
            for (QPlusCirStFeed qPlusCirStFeed : arrayList2) {
                if (!this.feedIds.contains(qPlusCirStFeed.feedId)) {
                    QPlusCirStRecommendInfo qPlusCirStRecommendInfo = qPlusCirStFeed.recommendInfo;
                    if ((qPlusCirStRecommendInfo != null && qPlusCirStRecommendInfo.recommendStatus == 1) && currentTimeStamp - qPlusCirStFeed.createTime <= 7776000) {
                        this.feedIds.add(qPlusCirStFeed.feedId);
                        getFeeds().add(new QPlusTrafficHomeVideoItemModel(qPlusCirStFeed));
                    }
                }
            }
        }
        if (qPlusCirStGetMainPageCommDataRsp != null && (arrayList = qPlusCirStGetMainPageCommDataRsp.vecFeed) != null && !z16) {
            if (!arrayList.isEmpty()) {
                last = CollectionsKt___CollectionsKt.last((List<? extends Object>) arrayList);
            }
            this.isFinish$delegate.setValue(this, $$delegatedProperties[2], Boolean.TRUE);
        }
        setUiState(QPlusTrafficUIState.COMPLETED);
    }
}
