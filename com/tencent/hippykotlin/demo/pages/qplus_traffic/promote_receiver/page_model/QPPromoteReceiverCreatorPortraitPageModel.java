package com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.protocol.list.IListRequestLogic;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSectionListModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.QPlusTrafficRepository;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusSearchTalentsReq;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusSearchTalentsRsp;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusUserInfo;
import com.tencent.kuikly.core.views.FooterRefreshState;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class QPPromoteReceiverCreatorPortraitPageModel extends QPPromoteReceiverPortraitPageModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {IPagerIdKtxKt$$ExternalSyntheticOutline0.m(QPPromoteReceiverCreatorPortraitPageModel.class, "portraitSectionListModels", "getPortraitSectionListModels()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPPromoteReceiverCreatorPortraitPageModel.class, "listReqCount", "getListReqCount()I", 0)};
    public ArrayList<String> categoryLists = new ArrayList<>();
    public final ReadWriteProperty portraitSectionListModels$delegate = c.b();
    public final ReadWriteProperty listReqCount$delegate = c.a(0);
    public QPPromoteReceiverPortraitSectionListModel topSectionListModel = new QPPromoteReceiverPortraitSectionListModel(this);

    public QPPromoteReceiverCreatorPortraitPageModel() {
        setNeedSearchResultFooter();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0049, code lost:
    
        if (r12.isEnd() == true) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void access$handleSuccess(QPPromoteReceiverCreatorPortraitPageModel qPPromoteReceiverCreatorPortraitPageModel, ArrayList arrayList) {
        boolean z16;
        qPPromoteReceiverCreatorPortraitPageModel.getClass();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            QPlusUserInfo qPlusUserInfo = (QPlusUserInfo) it.next();
            qPPromoteReceiverCreatorPortraitPageModel.getShowItemList().add(new QPPromoteReceiverPortraitListItem(String.valueOf(qPlusUserInfo.uin), Utils.INSTANCE.currentBridgeModule().urlDecode(qPlusUserInfo.nickname), qPlusUserInfo.icon, 0, qPlusUserInfo.isBlueV, qPlusUserInfo.isBigV));
        }
        qPPromoteReceiverCreatorPortraitPageModel.setSearchResultState(FooterRefreshState.IDLE);
        IListRequestLogic<QPlusSearchTalentsReq, QPlusSearchTalentsRsp> iListRequestLogic = qPPromoteReceiverCreatorPortraitPageModel.searchLogic;
        if (iListRequestLogic != null) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            qPPromoteReceiverCreatorPortraitPageModel.setSearchResultState(FooterRefreshState.NONE_MORE_DATA);
        }
        qPPromoteReceiverCreatorPortraitPageModel.isRequesting = false;
    }

    public final int getListReqCount() {
        return ((Number) this.listReqCount$delegate.getValue(this, $$delegatedProperties[1])).intValue();
    }

    public final com.tencent.kuikly.core.reactive.collection.c<QPPromoteReceiverPortraitSectionListModel> getPortraitSectionListModels() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.portraitSectionListModels$delegate.getValue(this, $$delegatedProperties[0]);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverPortraitPageModel
    public final void loadMore() {
        if (this.isRequesting) {
            return;
        }
        this.isRequesting = true;
        IListRequestLogic<QPlusSearchTalentsReq, QPlusSearchTalentsRsp> iListRequestLogic = this.searchLogic;
        if (iListRequestLogic != null) {
            iListRequestLogic.reqNextPage(new Function1<QPlusSearchTalentsRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverCreatorPortraitPageModel$loadMore$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(QPlusSearchTalentsRsp qPlusSearchTalentsRsp) {
                    ArrayList<QPlusUserInfo> arrayList = qPlusSearchTalentsRsp.talents;
                    if (arrayList != null) {
                        QPPromoteReceiverCreatorPortraitPageModel.access$handleSuccess(QPPromoteReceiverCreatorPortraitPageModel.this, arrayList);
                    }
                    return Unit.INSTANCE;
                }
            }, new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverCreatorPortraitPageModel$handleError$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, String str) {
                    num.intValue();
                    QPPromoteReceiverCreatorPortraitPageModel qPPromoteReceiverCreatorPortraitPageModel = QPPromoteReceiverCreatorPortraitPageModel.this;
                    qPPromoteReceiverCreatorPortraitPageModel.isRequesting = false;
                    qPPromoteReceiverCreatorPortraitPageModel.setSearchResultState(FooterRefreshState.FAILURE);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverPortraitPageModel
    public final void onSwitchItemStatus(QPPromoteReceiverPortraitListItem qPPromoteReceiverPortraitListItem) {
        super.onSwitchItemStatus(qPPromoteReceiverPortraitListItem);
        if (hasAddedToAllItems(qPPromoteReceiverPortraitListItem)) {
            return;
        }
        getAllItemList().add(qPPromoteReceiverPortraitListItem);
        this.topSectionListModel.getSectionList().add(qPPromoteReceiverPortraitListItem);
    }

    public final void setListReqCount(int i3) {
        this.listReqCount$delegate.setValue(this, $$delegatedProperties[1], Integer.valueOf(i3));
    }

    @Override // com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverPortraitPageModel
    public final void onBeginSearch(String str) {
        setSearchStatus(1);
        this.isRequesting = true;
        QPlusTrafficRepository qPlusTrafficRepository = QPlusTrafficRepository.INSTANCE;
        QPlusSearchTalentsReq qPlusSearchTalentsReq = new QPlusSearchTalentsReq(str, "");
        final Function1<QPlusSearchTalentsRsp, Unit> function1 = new Function1<QPlusSearchTalentsRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverCreatorPortraitPageModel$onBeginSearch$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(QPlusSearchTalentsRsp qPlusSearchTalentsRsp) {
                QPPromoteReceiverCreatorPortraitPageModel.this.getShowItemList().clear();
                ArrayList<QPlusUserInfo> arrayList = qPlusSearchTalentsRsp.talents;
                if (arrayList != null) {
                    QPPromoteReceiverCreatorPortraitPageModel.access$handleSuccess(QPPromoteReceiverCreatorPortraitPageModel.this, arrayList);
                }
                return Unit.INSTANCE;
            }
        };
        final Function2<Integer, String, Unit> function2 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverCreatorPortraitPageModel$onBeginSearch$2
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Integer num, String str2) {
                num.intValue();
                QPPromoteReceiverCreatorPortraitPageModel.this.getShowItemList().clear();
                QPPromoteReceiverCreatorPortraitPageModel.this.setSearchResultState(FooterRefreshState.FAILURE);
                QPPromoteReceiverCreatorPortraitPageModel.this.isRequesting = false;
                return Unit.INSTANCE;
            }
        };
        QPPromoteReceiverSearchListLogic qPPromoteReceiverSearchListLogic = new QPPromoteReceiverSearchListLogic(qPlusSearchTalentsReq);
        qPPromoteReceiverSearchListLogic.reqFirstPage(new Function1<QPlusSearchTalentsRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.QPlusTrafficRepository$reqSearchTalents$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(QPlusSearchTalentsRsp qPlusSearchTalentsRsp) {
                function1.invoke(qPlusSearchTalentsRsp);
                return Unit.INSTANCE;
            }
        }, new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.QPlusTrafficRepository$reqSearchTalents$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Integer num, String str2) {
                int intValue = num.intValue();
                function2.invoke(Integer.valueOf(intValue), str2);
                return Unit.INSTANCE;
            }
        });
        this.searchLogic = qPPromoteReceiverSearchListLogic;
    }
}
