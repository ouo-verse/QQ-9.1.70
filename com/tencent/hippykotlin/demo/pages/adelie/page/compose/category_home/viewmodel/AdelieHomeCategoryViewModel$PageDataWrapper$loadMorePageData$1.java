package com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel;

import c45.a;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomeDataManager;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.AdelieHomeCategoryViewModel;
import com.tencent.hippykotlin.demo.pages.foundation.module.OIDBResponse;
import com.tencent.kuikly.core.coroutines.b;
import com.tencent.kuikly.core.log.KLog;
import g25.c;
import g25.h;
import g25.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.AdelieHomeCategoryViewModel$PageDataWrapper$loadMorePageData$1", f = "AdelieHomeCategoryViewModel.kt", i = {}, l = {362}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class AdelieHomeCategoryViewModel$PageDataWrapper$loadMorePageData$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Function1<Boolean, Unit> $callback;
    public final /* synthetic */ Ref.ObjectRef<List<AbsDelegateData>> $oldData;
    public int label;
    public final /* synthetic */ AdelieHomeCategoryViewModel.PageDataWrapper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AdelieHomeCategoryViewModel$PageDataWrapper$loadMorePageData$1(AdelieHomeCategoryViewModel.PageDataWrapper pageDataWrapper, Function1<? super Boolean, Unit> function1, Ref.ObjectRef<List<AbsDelegateData>> objectRef, Continuation<? super AdelieHomeCategoryViewModel$PageDataWrapper$loadMorePageData$1> continuation) {
        super(2, continuation);
        this.this$0 = pageDataWrapper;
        this.$callback = function1;
        this.$oldData = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdelieHomeCategoryViewModel$PageDataWrapper$loadMorePageData$1(this.this$0, this.$callback, this.$oldData, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((AdelieHomeCategoryViewModel$PageDataWrapper$loadMorePageData$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.List, T] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        List<h> emptyList;
        a aVar;
        String str;
        List<g25.b> emptyList2;
        List plus;
        ?? emptyList3;
        j jVar;
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
            obj = adelieCategoryHomeDataManager.fetchMobileRobotRecommendCards$qecommerce_biz_release(aVar2, str2, str3, false, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        OIDBResponse oIDBResponse = (OIDBResponse) obj;
        boolean z16 = oIDBResponse.success;
        c cVar = (c) oIDBResponse.rsp;
        this.this$0.loadMoreing.setValue(Boxing.boxBoolean(false));
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("loadMorePageData end ");
        m3.append(this.this$0.tabInfo);
        m3.append(" success:");
        m3.append(z16);
        m3.append(", hasNextPage:");
        AdelieCategoryHomePage$$ExternalSyntheticOutline2.m(m3, cVar == null || cVar.C, kLog, "AdelieHomeCategoryViewModel");
        Function1<Boolean, Unit> function1 = this.$callback;
        if (function1 != null) {
            function1.invoke(Boxing.boxBoolean(z16));
        }
        if (z16) {
            Function2<List<h>, PageDataType, Unit> function2 = this.this$0.fillCategoryHooker;
            if (cVar == null || (jVar = cVar.f401141e) == null || (emptyList = jVar.f401167d) == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            }
            PageDataType pageDataType = PageDataType.BACKEND;
            function2.invoke(emptyList, pageDataType);
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
            if (cVar != null && cVar.F) {
                this.this$0.refreshDone.setValue(Boxing.boxBoolean(true));
                this.this$0.refreshing.setValue(Boxing.boxBoolean(false));
                Ref.ObjectRef<List<AbsDelegateData>> objectRef = this.$oldData;
                emptyList3 = CollectionsKt__CollectionsKt.emptyList();
                objectRef.element = emptyList3;
            }
            ArrayList arrayList = new ArrayList();
            AdelieHomeCategoryViewModel.PageDataWrapper pageDataWrapper3 = this.this$0;
            if (cVar == null || (emptyList2 = cVar.f401142f) == null) {
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            }
            List<g25.b> list = emptyList2;
            h hVar = this.this$0.tabInfo;
            plus = CollectionsKt___CollectionsKt.plus((Collection) this.$oldData.element, (Iterable) pageDataWrapper3.processRobotRecommendCards(list, null, hVar.f401164e, hVar.f401163d, false, arrayList));
            this.this$0.recommondPageData._state.setValue(new RecommondPageData(pageDataType, plus));
            StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("loadMorePageData recommondPageData ");
            m16.append(this.this$0.tabInfo.f401164e);
            m16.append(" setValue");
            kLog.i("AdelieHomeCategoryViewModel", m16.toString());
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
