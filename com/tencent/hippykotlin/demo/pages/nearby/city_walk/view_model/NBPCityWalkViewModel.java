package com.tencent.hippykotlin.demo.pages.nearby.city_walk.view_model;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendPbRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.city_walk.repository.GetActFeedWithPicRequest;
import com.tencent.kuikly.core.base.BaseObject;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import n25.a;
import n25.j;
import n25.k;
import n25.l;
import s25.b;

/* loaded from: classes31.dex */
public final class NBPCityWalkViewModel extends BaseObject {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPCityWalkViewModel.class, "showEntry", "getShowEntry()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPCityWalkViewModel.class, "bottomBarHeight", "getBottomBarHeight()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPCityWalkViewModel.class, "barIndex", "getBarIndex()I", 0), IPagerIdKtxKt$$ExternalSyntheticOutline0.m(NBPCityWalkViewModel.class, "tabList", "getTabList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPCityWalkViewModel.class, "selectListLoadingStatus", "getSelectListLoadingStatus()Lcom/tencent/hippykotlin/demo/pages/nearby/city_walk/view_model/LoadingStatus;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPCityWalkViewModel.class, "selectListView", "getSelectListView()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPCityWalkViewModel.class, "chooseList", "getChooseList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPCityWalkViewModel.class, "isPreview", "isPreview()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPCityWalkViewModel.class, "isDisplay", "isDisplay()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPCityWalkViewModel.class, "isPublishing", "isPublishing()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPCityWalkViewModel.class, "previewList", "getPreviewList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0)};
    public final ReadWriteProperty barIndex$delegate;
    public final ReadWriteProperty bottomBarHeight$delegate;
    public final ReadWriteProperty chooseList$delegate;
    public String content;
    public final ReadWriteProperty isDisplay$delegate;
    public final ReadWriteProperty isPreview$delegate;
    public final ReadWriteProperty isPublishing$delegate;
    public final Function0<Unit> jumpFeedDetailPageCb;
    public final ReadWriteProperty previewList$delegate;
    public final ReadWriteProperty selectListLoadingStatus$delegate;
    public final ReadWriteProperty selectListView$delegate;
    public final ReadWriteProperty showEntry$delegate;
    public final String source;
    public String times;

    public NBPCityWalkViewModel(String str, Function0 function0) {
        this.source = str;
        this.jumpFeedDetailPageCb = function0;
        Boolean bool = Boolean.FALSE;
        this.showEntry$delegate = c.a(bool);
        this.bottomBarHeight$delegate = c.a(Float.valueOf(0.0f));
        initEntry();
        this.barIndex$delegate = c.a(0);
        c.b();
        this.selectListLoadingStatus$delegate = c.a(LoadingStatus.INIT);
        this.selectListView$delegate = c.b();
        this.times = "";
        this.chooseList$delegate = c.b();
        this.isPreview$delegate = c.a(bool);
        this.isDisplay$delegate = c.a(bool);
        this.isPublishing$delegate = c.a(bool);
        this.previewList$delegate = c.b();
        this.content = "";
    }

    public final void fetchSelectList() {
        LoadingStatus selectListLoadingStatus = getSelectListLoadingStatus();
        LoadingStatus loadingStatus = LoadingStatus.LOADING;
        if (selectListLoadingStatus == loadingStatus) {
            return;
        }
        setSelectListLoadingStatus(loadingStatus);
        String str = this.times;
        int parseInt = Integer.parseInt(this.source);
        final Function1<b, Unit> function1 = new Function1<b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view_model.NBPCityWalkViewModel$fetchSelectList$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(b bVar) {
                LoadingStatus loadingStatus2;
                b bVar2 = bVar;
                if (bVar2 == null) {
                    NBPCityWalkViewModel.this.setSelectListLoadingStatus(LoadingStatus.ERROR);
                    KLog.INSTANCE.e("NBPCityWalkViewModel", "requestActFeedWithPic, is null");
                } else {
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchSelectList: add, roundParam: ");
                    m3.append(bVar2.f433127f);
                    m3.append(", isOver: ");
                    ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(m3, bVar2.f433128h, kLog, "NBPCityWalkViewModel");
                    NBPCityWalkViewModel nBPCityWalkViewModel = NBPCityWalkViewModel.this;
                    nBPCityWalkViewModel.times = bVar2.f433127f;
                    nBPCityWalkViewModel.getSelectListView().addAll(bVar2.f433126e);
                    NBPCityWalkViewModel nBPCityWalkViewModel2 = NBPCityWalkViewModel.this;
                    if (bVar2.f433128h == 1) {
                        loadingStatus2 = LoadingStatus.NO_MORE;
                    } else {
                        loadingStatus2 = LoadingStatus.SUCCESS;
                    }
                    nBPCityWalkViewModel2.setSelectListLoadingStatus(loadingStatus2);
                }
                return Unit.INSTANCE;
            }
        };
        final Function2<Integer, String, Unit> function2 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view_model.NBPCityWalkViewModel$fetchSelectList$2
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Integer num, String str2) {
                NBPCityWalkViewModel.this.setSelectListLoadingStatus(LoadingStatus.ERROR);
                KLog.INSTANCE.e("NBPCityWalkViewModel", AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0.m("fetchSelectList failed, errorCode: ", num.intValue(), ", errorMsg: ", str2));
                return Unit.INSTANCE;
            }
        };
        GetActFeedWithPicRequest getActFeedWithPicRequest = new GetActFeedWithPicRequest(str, parseInt);
        Function1<PbResponse<b>, Unit> function12 = new Function1<PbResponse<b>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.repository.NBPCityWalkRepository$requestActFeedWithPic$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(PbResponse<b> pbResponse) {
                PbResponse<b> pbResponse2 = pbResponse;
                if (pbResponse2.success) {
                    b bVar = pbResponse2.rsp;
                    if (bVar == null) {
                        function2.invoke(-1, "rsp is null");
                    } else {
                        function1.invoke(bVar);
                    }
                } else {
                    function2.invoke(Integer.valueOf(pbResponse2.code), pbResponse2.f114187msg);
                }
                return Unit.INSTANCE;
            }
        };
        APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.lplan.feed_svr.StatusRead.SsoGetActFeedWithPic");
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.sendPbRequest$default(getActFeedWithPicRequest, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter, function12), 6);
    }

    public final com.tencent.kuikly.core.reactive.collection.c<l> getChooseList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.chooseList$delegate.getValue(this, $$delegatedProperties[6]);
    }

    public final com.tencent.kuikly.core.reactive.collection.c<l> getPreviewList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.previewList$delegate.getValue(this, $$delegatedProperties[10]);
    }

    public final LoadingStatus getSelectListLoadingStatus() {
        return (LoadingStatus) this.selectListLoadingStatus$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final com.tencent.kuikly.core.reactive.collection.c<l> getSelectListView() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.selectListView$delegate.getValue(this, $$delegatedProperties[5]);
    }

    public final void initEntry() {
        try {
            String stringFromQQCommonConfig = QQNearbyModule.Companion.getInstance().getStringFromQQCommonConfig("101987", "");
            if (stringFromQQCommonConfig.length() == 0) {
                KLog.INSTANCE.e("NBPCityWalkViewModel", "entry switch config id :101987 is empty, use default value: false");
                this.showEntry$delegate.setValue(this, $$delegatedProperties[0], Boolean.FALSE);
                return;
            }
            boolean g16 = new e(stringFromQQCommonConfig).g("show", false);
            this.showEntry$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(g16));
            KLog.INSTANCE.i("NBPCityWalkViewModel", "entry switch success :101987, show: " + g16);
        } catch (Throwable th5) {
            AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("entry switch error: ", th5, KLog.INSTANCE, "NBPCityWalkViewModel");
        }
    }

    public final boolean isDisplay() {
        return ((Boolean) this.isDisplay$delegate.getValue(this, $$delegatedProperties[8])).booleanValue();
    }

    public final boolean isPreview() {
        return ((Boolean) this.isPreview$delegate.getValue(this, $$delegatedProperties[7])).booleanValue();
    }

    public final boolean isPublishing() {
        return ((Boolean) this.isPublishing$delegate.getValue(this, $$delegatedProperties[9])).booleanValue();
    }

    public final e jsonWithPreviewPgId() {
        return AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_nearby_citywalk_line_view");
    }

    public final n25.b makeCityWalkInfo() {
        int collectionSizeOrDefault;
        List mutableList;
        com.tencent.kuikly.core.reactive.collection.c<l> previewList = getPreviewList();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(previewList, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (l lVar : previewList) {
            int indexOf = getPreviewList().indexOf(lVar);
            String str = lVar.f418092d;
            List<j> list = lVar.f418097m;
            k kVar = lVar.C;
            arrayList.add(new a(str, indexOf, list, kVar != null ? kVar.C : null, (int) lVar.D, lVar.f418096i));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        return new n25.b(mutableList);
    }

    public final void setDisplay(boolean z16) {
        this.isDisplay$delegate.setValue(this, $$delegatedProperties[8], Boolean.valueOf(z16));
    }

    public final void setPreview(boolean z16) {
        this.isPreview$delegate.setValue(this, $$delegatedProperties[7], Boolean.valueOf(z16));
    }

    public final void setPublishing(boolean z16) {
        this.isPublishing$delegate.setValue(this, $$delegatedProperties[9], Boolean.valueOf(z16));
    }

    public final void setSelectListLoadingStatus(LoadingStatus loadingStatus) {
        this.selectListLoadingStatus$delegate.setValue(this, $$delegatedProperties[4], loadingStatus);
    }
}
