package com.tencent.hippykotlin.demo.pages.nearby.choose_theme;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendPbRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.GetMapThemeListRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NearbyMapThemeRepo$fetchMapThemeList$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.timer.TimerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import o25.f;
import v25.i;

/* loaded from: classes31.dex */
public final class NBPChooseThemeViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {IPagerIdKtxKt$$ExternalSyntheticOutline0.m(NBPChooseThemeViewModel.class, "mapThemeList", "getMapThemeList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPChooseThemeViewModel.class, "pageState", "getPageState()I", 0)};
    public final ReadWriteProperty mapThemeList$delegate = c.b();
    public final ReadWriteProperty pageState$delegate = c.a(0);
    public int retryCount;

    public final com.tencent.kuikly.core.reactive.collection.c<f> getMapThemeList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.mapThemeList$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void requestMapThemeList() {
        this.retryCount++;
        Function2<Boolean, i, Unit> function2 = new Function2<Boolean, i, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemeViewModel$requestMapThemeList$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Boolean bool, i iVar) {
                i iVar2 = iVar;
                if (bool.booleanValue() && (!iVar2.f440858e.isEmpty())) {
                    NBPChooseThemeViewModel.this.getMapThemeList().addAll(iVar2.f440858e);
                    NBPChooseThemeViewModel.this.setPageState(2);
                } else {
                    final NBPChooseThemeViewModel nBPChooseThemeViewModel = NBPChooseThemeViewModel.this;
                    if (nBPChooseThemeViewModel.retryCount <= 3) {
                        TimerKt.d(300, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemeViewModel$requestMapThemeList$1.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                NBPChooseThemeViewModel.this.requestMapThemeList();
                                return Unit.INSTANCE;
                            }
                        });
                    } else {
                        ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetch themesList error retryCount: "), NBPChooseThemeViewModel.this.retryCount, KLog.INSTANCE, "NBPMainThemeViewModel");
                        NBPChooseThemeViewModel.this.setPageState(1);
                    }
                }
                return Unit.INSTANCE;
            }
        };
        KLog kLog = KLog.INSTANCE;
        kLog.i("NearbyMapThemeRepo", "start fetch map themes");
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        i cachedMapThemeList = NearbyProUtilsKt.getCachedMapThemeList();
        if (cachedMapThemeList != null) {
            function2.invoke(Boolean.TRUE, cachedMapThemeList);
            booleanRef.element = true;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Callback from local cache, theme number:");
            m3.append(cachedMapThemeList.f440858e.size());
            kLog.i("NearbyMapThemeRepo", m3.toString());
        }
        GetMapThemeListRequest getMapThemeListRequest = new GetMapThemeListRequest(true);
        NearbyMapThemeRepo$fetchMapThemeList$1 nearbyMapThemeRepo$fetchMapThemeList$1 = new NearbyMapThemeRepo$fetchMapThemeList$1(booleanRef, function2);
        APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.lplan.map_svr.Map.SsoGetMapThemeList");
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.sendPbRequest$default(getMapThemeListRequest, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter, nearbyMapThemeRepo$fetchMapThemeList$1), 6);
    }

    public final void setPageState(int i3) {
        this.pageState$delegate.setValue(this, $$delegatedProperties[1], Integer.valueOf(i3));
    }
}
