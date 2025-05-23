package com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel;

import c45.a;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieAgreementConsentPage$onCreate$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomeDataManager;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.AdelieHomeCategoryViewModel;
import com.tencent.hippykotlin.demo.pages.base.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.OIDBResponse;
import com.tencent.kuikly.core.coroutines.b;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import g25.c;
import g25.g;
import g25.h;
import g25.j;
import g25.k;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.AdelieHomeCategoryViewModel$PageDataWrapper$refreshPageData$1", f = "AdelieHomeCategoryViewModel.kt", i = {}, l = {276}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class AdelieHomeCategoryViewModel$PageDataWrapper$refreshPageData$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ List<AbsDelegateData> $oldData;
    public int label;
    public final /* synthetic */ AdelieHomeCategoryViewModel.PageDataWrapper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AdelieHomeCategoryViewModel$PageDataWrapper$refreshPageData$1(AdelieHomeCategoryViewModel.PageDataWrapper pageDataWrapper, List<? extends AbsDelegateData> list, Continuation<? super AdelieHomeCategoryViewModel$PageDataWrapper$refreshPageData$1> continuation) {
        super(2, continuation);
        this.this$0 = pageDataWrapper;
        this.$oldData = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdelieHomeCategoryViewModel$PageDataWrapper$refreshPageData$1(this.this$0, this.$oldData, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((AdelieHomeCategoryViewModel$PageDataWrapper$refreshPageData$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        List<h> emptyList;
        j jVar;
        List<h> emptyList2;
        a aVar;
        String str;
        List<g25.b> emptyList3;
        List<g> list;
        j jVar2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            AdelieCategoryHomeDataManager adelieCategoryHomeDataManager = AdelieCategoryHomeDataManager.INSTANCE;
            AdelieHomeCategoryViewModel.PageDataWrapper pageDataWrapper = this.this$0;
            a aVar2 = pageDataWrapper.pagingCookie;
            String str2 = pageDataWrapper.dataVersion;
            String str3 = pageDataWrapper.tabInfo.f401163d;
            this.label = 1;
            obj = adelieCategoryHomeDataManager.fetchMobileRobotRecommendCards$qecommerce_biz_release(aVar2, str2, str3, true, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        OIDBResponse oIDBResponse = (OIDBResponse) obj;
        this.this$0.hasFetchServerData = true;
        boolean z16 = oIDBResponse.success;
        c cVar = (c) oIDBResponse.rsp;
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("refreshPageData end ");
        m3.append(this.this$0.tabInfo);
        m3.append(" success:");
        m3.append(z16);
        m3.append(", hasNextPage:");
        AdelieCategoryHomePage$$ExternalSyntheticOutline2.m(m3, cVar == null || cVar.C, kLog, "AdelieHomeCategoryViewModel");
        this.this$0.refreshing.setValue(Boxing.boxBoolean(false));
        if (z16) {
            Function2<List<h>, PageDataType, Unit> function2 = this.this$0.fillCategoryHooker;
            if (cVar == null || (jVar2 = cVar.f401141e) == null || (emptyList2 = jVar2.f401167d) == null) {
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            }
            PageDataType pageDataType = PageDataType.BACKEND;
            function2.invoke(emptyList2, pageDataType);
            AdelieHomeCategoryViewModel.PageDataWrapper pageDataWrapper2 = this.this$0;
            if (cVar == null || (aVar = cVar.f401145m) == null) {
                aVar = a.f30290b;
            }
            pageDataWrapper2.pagingCookie = aVar;
            if (cVar == null || (str = cVar.D) == null) {
                str = "";
            }
            pageDataWrapper2.dataVersion = str;
            pageDataWrapper2.hasNextPage.setValue(Boxing.boxBoolean(!(!(cVar != null ? cVar.C : true))));
            ArrayList arrayList = new ArrayList();
            AdelieHomeCategoryViewModel.PageDataWrapper pageDataWrapper3 = this.this$0;
            if (cVar == null || (emptyList3 = cVar.f401142f) == null) {
                emptyList3 = CollectionsKt__CollectionsKt.emptyList();
            }
            List<g25.b> list2 = emptyList3;
            List<g> list3 = cVar != null ? cVar.f401144i : null;
            h hVar = this.this$0.tabInfo;
            List<AbsDelegateData> processRobotRecommendCards = pageDataWrapper3.processRobotRecommendCards(list2, list3, hVar.f401164e, hVar.f401163d, true, arrayList);
            if ((cVar == null || (list = cVar.f401144i) == null || !(list.isEmpty() ^ true)) ? false : true) {
                k kVar = cVar.f401144i.get(0).f401162m;
                if (kVar != null) {
                    Boxing.boxBoolean(arrayList.add(kVar));
                }
                ((AdelieKuiklyHomePageModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("AdelieKuiklyHomePageModule")).preloadAIOGuideInfo$qecommerce_biz_release(cVar.f401144i.get(0), new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.AdelieHomeCategoryViewModel$PageDataWrapper$refreshPageData$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(e eVar) {
                        return Unit.INSTANCE;
                    }
                });
            }
            if (Intrinsics.areEqual(this.this$0.tabInfo.f401163d, "0")) {
                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ADELIE_GUIDE_HAS_SHOWN_NATIVE_GUIDE_");
                com.tencent.kuikly.core.manager.c cVar2 = com.tencent.kuikly.core.manager.c.f117352a;
                m16.append(PageDataExtKt.getUin(cVar2.g().getPageData()));
                String sb5 = m16.toString();
                if (!this.this$0.getAdelieKuiklyModule().getBooleanFromCache(sb5)) {
                    AdelieAgreementConsentPage$onCreate$1$1$3$$ExternalSyntheticOutline0.m((com.tencent.kuikly.core.module.k) cVar2.g().acquireModule("KRNotifyModule"), "adelie_show_native_guide", false, 4, null);
                    AdelieKuiklyBaseModule adelieKuiklyModule = this.this$0.getAdelieKuiklyModule();
                    adelieKuiklyModule.getClass();
                    adelieKuiklyModule.setStringToCache$enumunboxing$(sb5, String.valueOf(true), 1, 2);
                }
            }
            this.this$0.recommondPageData._state.setValue(new RecommondPageData(pageDataType, processRobotRecommendCards));
            this.this$0.updateTurboDisplayIfNeeded();
            StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("refreshPageData recommondPageData ");
            m17.append(this.this$0.tabInfo.f401164e);
            m17.append(" setValue");
            kLog.i("AdelieHomeCategoryViewModel", m17.toString());
            this.this$0.refreshDone.setValue(Boxing.boxBoolean(true));
            this.this$0.loadMorePageData(null);
            return Unit.INSTANCE;
        }
        Function2<List<h>, PageDataType, Unit> function22 = this.this$0.fillCategoryHooker;
        if (cVar == null || (jVar = cVar.f401141e) == null || (emptyList = jVar.f401167d) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        PageDataType pageDataType2 = PageDataType.ERROR;
        function22.invoke(emptyList, pageDataType2);
        this.this$0.recommondPageData._state.setValue(new RecommondPageData(pageDataType2, this.$oldData));
        return Unit.INSTANCE;
    }
}
