package com.qzone.reborn.feedx.part.moodlist;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.feedx.itemview.memoryseal.QZoneMemorySealFeedItemView;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.reborn.feedx.util.ah;
import com.qzone.reborn.feedx.viewmodel.QZoneFeedxMoodListViewModel;
import com.qzone.reborn.feedx.viewmodel.r;
import com.qzone.reborn.feedx.widget.userhome.QZoneFeedMemorySealView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b(\u0010)J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u0016\u0010\u0014\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006*"}, d2 = {"Lcom/qzone/reborn/feedx/part/moodlist/QZoneMoodListMemorySealPart;", "Lcom/qzone/reborn/feedx/part/g;", "Landroid/view/View;", "memoryItemView", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", ViewStickEventHelper.IS_SHOW, "", "K9", "J9", "", "I9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "i6", "", "getLogTag", "d", "Z", "mIsClose", "e", "I", "mMemoryItemPosition", "Landroid/view/ViewStub;", "f", "Landroid/view/ViewStub;", "mViewStub", "Lcom/qzone/reborn/feedx/viewmodel/r;", h.F, "Lcom/qzone/reborn/feedx/viewmodel/r;", "mScrollViewModel", "Lcom/qzone/reborn/feedx/viewmodel/QZoneFeedxMoodListViewModel;", "i", "Lcom/qzone/reborn/feedx/viewmodel/QZoneFeedxMoodListViewModel;", "mFeedDataViewModel", "Lcom/qzone/reborn/feedx/widget/userhome/QZoneFeedMemorySealView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/feedx/widget/userhome/QZoneFeedMemorySealView;", "mMemoryBar", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneMoodListMemorySealPart extends com.qzone.reborn.feedx.part.g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mIsClose;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mMemoryItemPosition;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ViewStub mViewStub;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private r mScrollViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZoneFeedxMoodListViewModel mFeedDataViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QZoneFeedMemorySealView mMemoryBar;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/qzone/reborn/feedx/part/moodlist/QZoneMoodListMemorySealPart$a", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (QZoneMoodListMemorySealPart.this.mIsClose) {
                return;
            }
            int a16 = ah.a(recyclerView);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            View findViewByPosition = layoutManager != null ? layoutManager.findViewByPosition(a16) : null;
            if (findViewByPosition instanceof QZoneMemorySealFeedItemView) {
                QZoneMoodListMemorySealPart.this.mMemoryItemPosition = a16;
                QZoneMoodListMemorySealPart.this.K9(findViewByPosition, recyclerView, true);
                return;
            }
            RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
            View findViewByPosition2 = layoutManager2 != null ? layoutManager2.findViewByPosition(a16 + 1) : null;
            if (findViewByPosition2 instanceof QZoneMemorySealFeedItemView) {
                QZoneMoodListMemorySealPart.this.K9(findViewByPosition2, recyclerView, false);
            }
        }
    }

    private final int I9() {
        return QZoneFeedxViewUtils.b(getActivity());
    }

    private final void J9() {
        ViewStub viewStub = this.mViewStub;
        if (viewStub == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewStub");
            viewStub = null;
        }
        View inflate = viewStub.inflate();
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type com.qzone.reborn.feedx.widget.userhome.QZoneFeedMemorySealView");
        QZoneFeedMemorySealView qZoneFeedMemorySealView = (QZoneFeedMemorySealView) inflate;
        this.mMemoryBar = qZoneFeedMemorySealView;
        ViewGroup.LayoutParams layoutParams = qZoneFeedMemorySealView != null ? qZoneFeedMemorySealView.getLayoutParams() : null;
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, ef.d.b(48));
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = I9();
            QZoneFeedMemorySealView qZoneFeedMemorySealView2 = this.mMemoryBar;
            if (qZoneFeedMemorySealView2 != null) {
                qZoneFeedMemorySealView2.setLayoutParams(layoutParams);
            }
        }
        QZoneFeedMemorySealView qZoneFeedMemorySealView3 = this.mMemoryBar;
        if (qZoneFeedMemorySealView3 != null) {
            qZoneFeedMemorySealView3.setBackgroundResource(R.drawable.qzone_common_bg_card_bg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K9(View memoryItemView, final RecyclerView recyclerView, boolean isShow) {
        if (memoryItemView instanceof QZoneMemorySealFeedItemView) {
            if (isShow) {
                QZoneFeedMemorySealView qZoneFeedMemorySealView = this.mMemoryBar;
                if (qZoneFeedMemorySealView != null && qZoneFeedMemorySealView.getVisibility() == 0) {
                    return;
                }
                if (this.mMemoryBar == null) {
                    J9();
                }
                QZoneFeedMemorySealView qZoneFeedMemorySealView2 = this.mMemoryBar;
                if (qZoneFeedMemorySealView2 != null) {
                    qZoneFeedMemorySealView2.setVisibility(0);
                }
                QZoneFeedMemorySealView qZoneFeedMemorySealView3 = this.mMemoryBar;
                if (qZoneFeedMemorySealView3 != null) {
                    qZoneFeedMemorySealView3.c(((QZoneMemorySealFeedItemView) memoryItemView).C);
                }
                QZoneFeedMemorySealView qZoneFeedMemorySealView4 = this.mMemoryBar;
                if (qZoneFeedMemorySealView4 != null) {
                    qZoneFeedMemorySealView4.setOnCloseListener(new Function0<Unit>() { // from class: com.qzone.reborn.feedx.part.moodlist.QZoneMoodListMemorySealPart$toggleMemoryBar$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            RecyclerView.Adapter adapter;
                            int i3;
                            QZoneMoodListMemorySealPart.this.mIsClose = true;
                            RecyclerView recyclerView2 = recyclerView;
                            if (recyclerView2 == null || (adapter = recyclerView2.getAdapter()) == null) {
                                return;
                            }
                            i3 = QZoneMoodListMemorySealPart.this.mMemoryItemPosition;
                            adapter.notifyItemRemoved(i3);
                        }
                    });
                    return;
                }
                return;
            }
            QZoneFeedMemorySealView qZoneFeedMemorySealView5 = this.mMemoryBar;
            if (qZoneFeedMemorySealView5 == null) {
                return;
            }
            qZoneFeedMemorySealView5.setVisibility(8);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneMoodListMemorySealPart";
    }

    @Override // com.qzone.reborn.feedx.part.g, com.qzone.reborn.feedx.viewmodel.b
    public void i6() {
        super.i6();
        r rVar = this.mScrollViewModel;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScrollViewModel");
            rVar = null;
        }
        rVar.N1(new a());
    }

    @Override // com.qzone.reborn.feedx.part.g, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        ViewModel viewModel = getViewModel(r.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneFriend\u2026ollViewModel::class.java)");
        this.mScrollViewModel = (r) viewModel;
        ViewModel viewModel2 = getViewModel(QZoneFeedxMoodListViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(QZoneFeedxM\u2026istViewModel::class.java)");
        this.mFeedDataViewModel = (QZoneFeedxMoodListViewModel) viewModel2;
        View findViewById = rootView.findViewById(R.id.n0v);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026dx_memory_seal_view_stub)");
        this.mViewStub = (ViewStub) findViewById;
    }
}
