package com.tencent.biz.qqcircle.immersive.search.prompt.rank.staggered;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.search.prompt.event.QFSSearchPromptSetTopEvent;
import com.tencent.biz.qqcircle.immersive.search.prompt.rank.QFSSearchPromptRankDataModel;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u001c\u0010\u000f\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0014J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0014J\b\u0010\u001b\u001a\u00020\u0016H\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001b\u0010.\u001a\u00020)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\u00a8\u00061"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/search/prompt/rank/staggered/QFSSearchPromptRankStaggeredFragment;", "Lcom/tencent/biz/qqcircle/immersive/QFSBaseFragment;", "", "Ih", "Fh", "Eh", "Bh", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Dh", OcrConfig.CHINESE, "Landroid/view/View;", "contentView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onViewCreatedBeforePartInit", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "registerDaTongReportPageId", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "", "getContentLayoutId", "", "getLogTag", "getDaTongPageId", "getPageId", "E", "Landroidx/recyclerview/widget/RecyclerView;", UserInfo.SEX_FEMALE, "Landroid/view/View;", "setTopView", "Lcom/tencent/biz/qqcircle/immersive/search/prompt/rank/staggered/e;", "G", "Lcom/tencent/biz/qqcircle/immersive/search/prompt/rank/staggered/e;", "staggeredAdapter", "Lcom/tencent/biz/qqcircle/immersive/search/prompt/rank/staggered/h;", "H", "Lcom/tencent/biz/qqcircle/immersive/search/prompt/rank/staggered/h;", "dcReporter", "Lcom/tencent/biz/qqcircle/immersive/search/prompt/rank/staggered/QFSSearchPromptRankVideoViewModel;", "I", "Lkotlin/Lazy;", "Ah", "()Lcom/tencent/biz/qqcircle/immersive/search/prompt/rank/staggered/QFSSearchPromptRankVideoViewModel;", "viewModel", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSSearchPromptRankStaggeredFragment extends QFSBaseFragment {

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private RecyclerView recyclerView;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private View setTopView;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final e staggeredAdapter = new e();

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private h dcReporter = new h();

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/biz/qqcircle/immersive/search/prompt/rank/staggered/QFSSearchPromptRankStaggeredFragment$a", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "newState", "onScrollStateChanged", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
                QFSSearchPromptRankStaggeredFragment.this.Dh(recyclerView);
                VideoReport.traverseExposure();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            boolean z16;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
            if (recyclerView.canScrollVertically(-1)) {
                View view = QFSSearchPromptRankStaggeredFragment.this.setTopView;
                if (view != null && view.getVisibility() == 8) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    View view2 = QFSSearchPromptRankStaggeredFragment.this.setTopView;
                    if (view2 != null) {
                        view2.setVisibility(0);
                    }
                    VideoReport.reportEvent("dt_imp", QFSSearchPromptRankStaggeredFragment.this.setTopView, new QCircleDTParamBuilder().buildElementParams());
                    return;
                }
                return;
            }
            View view3 = QFSSearchPromptRankStaggeredFragment.this.setTopView;
            if (view3 != null) {
                view3.setVisibility(8);
            }
        }
    }

    public QFSSearchPromptRankStaggeredFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QFSSearchPromptRankVideoViewModel>() { // from class: com.tencent.biz.qqcircle.immersive.search.prompt.rank.staggered.QFSSearchPromptRankStaggeredFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QFSSearchPromptRankVideoViewModel invoke() {
                return (QFSSearchPromptRankVideoViewModel) QFSSearchPromptRankStaggeredFragment.this.getViewModel(QFSSearchPromptRankVideoViewModel.class);
            }
        });
        this.viewModel = lazy;
    }

    private final QFSSearchPromptRankVideoViewModel Ah() {
        Object value = this.viewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-viewModel>(...)");
        return (QFSSearchPromptRankVideoViewModel) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Bh() {
        QLog.d(getLogTag(), 1, "[loadMore]");
        Ah().c2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(QFSSearchPromptRankStaggeredFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView recyclerView = this$0.recyclerView;
        if (recyclerView != null) {
            recyclerView.scrollToPosition(0);
        }
        SimpleEventBus.getInstance().dispatchEvent(new QFSSearchPromptSetTopEvent());
        VideoReport.reportEvent("dt_clck", view, new QCircleDTParamBuilder().buildElementParams());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Dh(RecyclerView recyclerView) {
        int intValue;
        int intValue2;
        Pair<Integer, Integer> a16 = h.INSTANCE.a(recyclerView);
        if (a16 == null || a16.getFirst().intValue() < 0 || a16.getSecond().intValue() < 0 || (intValue = a16.getFirst().intValue()) > (intValue2 = a16.getSecond().intValue())) {
            return;
        }
        while (true) {
            this.dcReporter.a(intValue, this.staggeredAdapter.getItem(intValue));
            if (intValue != intValue2) {
                intValue++;
            } else {
                return;
            }
        }
    }

    private final void Eh() {
        e eVar = this.staggeredAdapter;
        eVar.setEnableRefresh(false);
        eVar.setEnableLoadMore(true);
        eVar.i0(new QFSSearchPromptRankStaggeredFragment$setupAdapter$1$1(this));
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            recyclerView.setAdapter(this.staggeredAdapter);
        }
    }

    private final void Fh() {
        LiveData<QFSSearchPromptRankDataModel<FeedCloudMeta$StFeed>> Z1 = Ah().Z1();
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        final QFSSearchPromptRankStaggeredFragment$setupObserver$1 qFSSearchPromptRankStaggeredFragment$setupObserver$1 = new QFSSearchPromptRankStaggeredFragment$setupObserver$1(this);
        Z1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.search.prompt.rank.staggered.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSSearchPromptRankStaggeredFragment.Gh(Function1.this, obj);
            }
        });
        LiveData<QFSSearchPromptRankDataModel<FeedCloudMeta$StFeed>> X1 = Ah().X1();
        LifecycleOwner lifecycleOwner2 = getLifecycleOwner();
        final Function1<QFSSearchPromptRankDataModel<FeedCloudMeta$StFeed>, Unit> function1 = new Function1<QFSSearchPromptRankDataModel<FeedCloudMeta$StFeed>, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.search.prompt.rank.staggered.QFSSearchPromptRankStaggeredFragment$setupObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QFSSearchPromptRankDataModel<FeedCloudMeta$StFeed> qFSSearchPromptRankDataModel) {
                invoke2(qFSSearchPromptRankDataModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QFSSearchPromptRankDataModel<FeedCloudMeta$StFeed> qFSSearchPromptRankDataModel) {
                e eVar;
                e eVar2;
                e eVar3;
                QLog.d(QFSSearchPromptRankStaggeredFragment.this.getLogTag(), 1, "[appendChanged] success=" + qFSSearchPromptRankDataModel.getIsSuccess() + ", hasMore=" + qFSSearchPromptRankDataModel.getHasMore() + ", size=" + qFSSearchPromptRankDataModel.b().size());
                if (qFSSearchPromptRankDataModel.getIsSuccess()) {
                    eVar2 = QFSSearchPromptRankStaggeredFragment.this.staggeredAdapter;
                    eVar2.onLoadMoreCompleted(true, !qFSSearchPromptRankDataModel.getHasMore(), false);
                    eVar3 = QFSSearchPromptRankStaggeredFragment.this.staggeredAdapter;
                    eVar3.addAll(qFSSearchPromptRankDataModel.b());
                    return;
                }
                eVar = QFSSearchPromptRankStaggeredFragment.this.staggeredAdapter;
                eVar.onLoadMoreCompleted(false, true);
            }
        };
        X1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.search.prompt.rank.staggered.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSSearchPromptRankStaggeredFragment.Hh(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Ih() {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        }
        int b16 = com.tencent.qqnt.base.utils.c.f353052a.b(8);
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 != null) {
            recyclerView2.setPadding(b16, 0, b16, 0);
        }
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 != null) {
            recyclerView3.setClipToPadding(false);
        }
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 != null) {
            recyclerView4.addItemDecoration(new i());
        }
        RecyclerView recyclerView5 = this.recyclerView;
        if (recyclerView5 != null) {
            recyclerView5.addOnScrollListener(new a());
        }
    }

    private final void zh() {
        VideoReport.setElementId(this.recyclerView, QCircleDaTongConstant.ElementId.EM_XSJ_GUESS_WANT_TO_SEE_MODULE);
        VideoReport.setElementExposePolicy(this.recyclerView, ExposurePolicy.REPORT_ALL);
        RecyclerView recyclerView = this.recyclerView;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        VideoReport.setElementClickPolicy(recyclerView, clickPolicy);
        VideoReport.setElementId(this.setTopView, QCircleDaTongConstant.ElementId.EM_XSJ_SCROLL_TO_TOP_BUTTON);
        VideoReport.setElementExposePolicy(this.setTopView, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(this.setTopView, clickPolicy);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.gro;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    @NotNull
    public String getDaTongPageId() {
        return QCircleDaTongConstant.PageId.PG_XSJ_SEARCH_PAGE;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    public String getLogTag() {
        return "QFSSearchPromptRankStaggeredFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return 129;
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.dcReporter.c();
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        VideoReport.traversePage(this.recyclerView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(@Nullable View contentView, @Nullable Bundle savedInstanceState) {
        View view;
        super.onViewCreatedBeforePartInit(contentView, savedInstanceState);
        RecyclerView recyclerView = null;
        if (contentView != null) {
            view = contentView.findViewById(R.id.f54002e1);
        } else {
            view = null;
        }
        this.setTopView = view;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.search.prompt.rank.staggered.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    QFSSearchPromptRankStaggeredFragment.Ch(QFSSearchPromptRankStaggeredFragment.this, view2);
                }
            });
        }
        if (contentView != null) {
            recyclerView = (RecyclerView) contentView.findViewById(R.id.f53982dz);
        }
        this.recyclerView = recyclerView;
        zh();
        Ih();
        Eh();
        Fh();
        Ah().b2(getArguments());
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public void registerDaTongReportPageId() {
    }
}
