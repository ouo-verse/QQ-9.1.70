package com.tencent.robot.discoveryv2.common.recommend.page.core;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.robot.discoveryv2.common.core.viewmodel.BaseRobotViewModel;
import com.tencent.robot.discoveryv2.common.data.RecommendRobotsData;
import com.tencent.robot.discoveryv2.common.data.SingleCategoryDetailData;
import com.tencent.robot.discoveryv2.common.data.SingleCategoryFetchArgs;
import com.tencent.robot.discoveryv2.common.data.SingleCategoryLoadData;
import com.tencent.robot.discoveryv2.common.data.SingleCategoryLoadType;
import com.tencent.robot.discoveryv2.common.data.SingleCategoryNextPageData;
import com.tencent.robot.discoveryv2.common.recommend.page.core.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ,2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001-B\u0007\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\b\u0010\u0011\u001a\u00020\u0007H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\u0006\u0010\u0016\u001a\u00020\u0007J\u000e\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001aR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R$\u0010)\u001a\u0012\u0012\u0004\u0012\u00020%0$j\b\u0012\u0004\u0012\u00020%`&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Lcom/tencent/robot/discoveryv2/common/recommend/page/core/RecommendPageViewModel;", "Lcom/tencent/robot/discoveryv2/common/core/viewmodel/BaseRobotViewModel;", "Lcom/tencent/robot/discoveryv2/common/repository/core/d;", "Lcom/tencent/robot/discoveryv2/common/recommend/page/core/b;", "", "Lcom/tencent/robot/discoveryv2/common/data/g;", "loadData", "", "k2", "Lcom/tencent/robot/discoveryv2/common/data/d;", "recommendRobotsData", "Z1", "Lcom/tencent/robot/discoveryv2/common/data/i;", "singleCategoryNextPageData", "b2", "e2", "d2", "c2", "", "getLogTag", "Q1", "T1", "g2", "Lcom/tencent/robot/discoveryv2/common/recommend/page/core/a;", "recommendPageParams", "f2", "Lcom/tencent/robot/discoveryv2/common/data/SingleCategoryLoadType;", "loadType", ICustomDataEditor.STRING_ARRAY_PARAM_2, "", BdhLogUtil.LogTag.Tag_Conn, "Z", "mHasRegisteredNotification", "D", "Lcom/tencent/robot/discoveryv2/common/recommend/page/core/a;", "mRecommendPageParams", "Ljava/util/ArrayList;", "Lkotlinx/coroutines/Job;", "Lkotlin/collections/ArrayList;", "E", "Ljava/util/ArrayList;", "notificationJobList", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RecommendPageViewModel extends BaseRobotViewModel<com.tencent.robot.discoveryv2.common.repository.core.d, b, Object> {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mHasRegisteredNotification;

    /* renamed from: D, reason: from kotlin metadata */
    private RecommendPageParams mRecommendPageParams;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<Job> notificationJobList = new ArrayList<>();

    private final void Z1(RecommendRobotsData recommendRobotsData) {
        String categoryId = recommendRobotsData.getCategoryId();
        RecommendPageParams recommendPageParams = this.mRecommendPageParams;
        if (recommendPageParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecommendPageParams");
            recommendPageParams = null;
        }
        if (!Intrinsics.areEqual(categoryId, recommendPageParams.getCategoryId())) {
            return;
        }
        P1().setValue(new b.UpdatePageDataUIState(recommendRobotsData.b()));
    }

    private final void b2(SingleCategoryNextPageData singleCategoryNextPageData) {
        String categoryId = singleCategoryNextPageData.getCategoryId();
        RecommendPageParams recommendPageParams = this.mRecommendPageParams;
        if (recommendPageParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecommendPageParams");
            recommendPageParams = null;
        }
        if (!Intrinsics.areEqual(categoryId, recommendPageParams.getCategoryId())) {
            return;
        }
        P1().setValue(new b.UpdateHaveNextPageUIState(singleCategoryNextPageData.getHaveNextPage()));
    }

    private final void c2() {
        MutableLiveData<b> P1 = P1();
        com.tencent.robot.discoveryv2.common.repository.core.d M1 = M1();
        RecommendPageParams recommendPageParams = this.mRecommendPageParams;
        if (recommendPageParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecommendPageParams");
            recommendPageParams = null;
        }
        P1.setValue(new b.UpdateHaveNextPageUIState(M1.l(recommendPageParams.getCategoryId())));
    }

    private final void d2() {
        com.tencent.robot.discoveryv2.common.repository.core.d M1 = M1();
        RecommendPageParams recommendPageParams = this.mRecommendPageParams;
        if (recommendPageParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecommendPageParams");
            recommendPageParams = null;
        }
        SingleCategoryLoadData c16 = M1.c(recommendPageParams.getCategoryId());
        P1().setValue(new b.UpdatePageLoadStateUIState(c16.getLoadState(), c16.getLoadType()));
    }

    private final void e2() {
        List<s34.b> emptyList;
        com.tencent.robot.discoveryv2.common.repository.core.d M1 = M1();
        RecommendPageParams recommendPageParams = this.mRecommendPageParams;
        if (recommendPageParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecommendPageParams");
            recommendPageParams = null;
        }
        SingleCategoryDetailData f16 = M1.f(recommendPageParams.getCategoryId());
        if (f16 == null || (emptyList = f16.c()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        P1().setValue(new b.UpdatePageDataUIState(emptyList));
        if (emptyList.isEmpty()) {
            a2(SingleCategoryLoadType.LOAD_CATEGORY_FIRST);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object h2(RecommendPageViewModel recommendPageViewModel, RecommendRobotsData recommendRobotsData, Continuation continuation) {
        recommendPageViewModel.Z1(recommendRobotsData);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object i2(RecommendPageViewModel recommendPageViewModel, SingleCategoryNextPageData singleCategoryNextPageData, Continuation continuation) {
        recommendPageViewModel.b2(singleCategoryNextPageData);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object j2(RecommendPageViewModel recommendPageViewModel, SingleCategoryLoadData singleCategoryLoadData, Continuation continuation) {
        recommendPageViewModel.k2(singleCategoryLoadData);
        return Unit.INSTANCE;
    }

    private final void k2(SingleCategoryLoadData loadData) {
        String categoryId = loadData.getCategoryId();
        RecommendPageParams recommendPageParams = this.mRecommendPageParams;
        if (recommendPageParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecommendPageParams");
            recommendPageParams = null;
        }
        if (!Intrinsics.areEqual(categoryId, recommendPageParams.getCategoryId())) {
            return;
        }
        P1().setValue(new b.UpdatePageLoadStateUIState(loadData.getLoadState(), loadData.getLoadType()));
    }

    @Override // com.tencent.robot.discoveryv2.common.core.viewmodel.BaseRobotViewModel
    public void Q1() {
        super.Q1();
        if (this.mHasRegisteredNotification) {
            return;
        }
        this.mHasRegisteredNotification = true;
        Job launchIn = FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(M1().i(), new RecommendPageViewModel$registerNotification$loadStateJob$1(this)), Dispatchers.getMain()), ViewModelKt.getViewModelScope(this));
        Job launchIn2 = FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(M1().k(), new RecommendPageViewModel$registerNotification$dataChangedJob$1(this)), Dispatchers.getMain()), ViewModelKt.getViewModelScope(this));
        Job launchIn3 = FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(M1().g(), new RecommendPageViewModel$registerNotification$nextPageJob$1(this)), Dispatchers.getMain()), ViewModelKt.getViewModelScope(this));
        ArrayList<Job> arrayList = this.notificationJobList;
        arrayList.add(launchIn);
        arrayList.add(launchIn2);
        arrayList.add(launchIn3);
    }

    @Override // com.tencent.robot.discoveryv2.common.core.viewmodel.BaseRobotViewModel
    public void T1() {
        super.T1();
        if (!this.mHasRegisteredNotification) {
            return;
        }
        this.mHasRegisteredNotification = false;
        Iterator<T> it = this.notificationJobList.iterator();
        while (it.hasNext()) {
            Job.DefaultImpls.cancel$default((Job) it.next(), (CancellationException) null, 1, (Object) null);
        }
        this.notificationJobList.clear();
    }

    public final void a2(@NotNull SingleCategoryLoadType loadType) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        com.tencent.robot.discoveryv2.common.repository.core.d M1 = M1();
        RecommendPageParams recommendPageParams = this.mRecommendPageParams;
        RecommendPageParams recommendPageParams2 = null;
        if (recommendPageParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecommendPageParams");
            recommendPageParams = null;
        }
        String uin = recommendPageParams.getUin();
        RecommendPageParams recommendPageParams3 = this.mRecommendPageParams;
        if (recommendPageParams3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecommendPageParams");
            recommendPageParams3 = null;
        }
        String categoryId = recommendPageParams3.getCategoryId();
        RecommendPageParams recommendPageParams4 = this.mRecommendPageParams;
        if (recommendPageParams4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecommendPageParams");
        } else {
            recommendPageParams2 = recommendPageParams4;
        }
        M1.j(new SingleCategoryFetchArgs(uin, categoryId, recommendPageParams2.getCategoryName(), loadType));
    }

    public final void f2(@NotNull RecommendPageParams recommendPageParams) {
        Intrinsics.checkNotNullParameter(recommendPageParams, "recommendPageParams");
        this.mRecommendPageParams = recommendPageParams;
        Q1();
        e2();
        c2();
        d2();
    }

    public final void g2() {
        T1();
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "RecommendPageViewModel";
    }
}
