package com.tencent.mobileqq.mini.entry.newdesktop.part.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppModuleInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDeskTopViewModel;
import com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDesktopEffect;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppDragHelper;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.section.MiniAppMoreUiSection;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.report.MiniValidExpoReportHelper;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0099\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0006\u0018\u0000 I2\u00020\u0001:\u0001IB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J&\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u001d052\b\b\u0002\u00106\u001a\u00020\u0019J\u001a\u00107\u001a\u0002012\b\u00108\u001a\u0004\u0018\u00010\u00012\u0006\u00109\u001a\u00020\u001dH\u0002J\b\u0010:\u001a\u000201H\u0002J$\u0010;\u001a\u0002012\b\u00108\u001a\u0004\u0018\u00010\u00012\u0006\u0010<\u001a\u00020\t2\b\u00109\u001a\u0004\u0018\u00010\u001dH\u0002J\u001e\u0010=\u001a\u00020\t2\u0006\u0010>\u001a\u00020?2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u001d05H\u0002J\u0010\u0010@\u001a\u00020\t2\u0006\u0010A\u001a\u00020\u0003H\u0002J\u0010\u0010B\u001a\u00020\t2\u0006\u0010C\u001a\u00020\tH\u0002J\u0016\u0010D\u001a\u0002012\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u001d05H\u0002J \u0010E\u001a\u0002012\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u001d052\b\b\u0002\u00106\u001a\u00020\u0019H\u0002J\u0010\u0010F\u001a\u0002012\u0006\u0010G\u001a\u00020HH\u0002R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010-X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/MiniAppMineViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "mDragListener", "com/tencent/mobileqq/mini/entry/newdesktop/part/adapter/MiniAppMineViewHolder$mDragListener$1", "Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/MiniAppMineViewHolder$mDragListener$1;", "mDragMineRvOut", "", "mDragMirrorLl", "Landroid/widget/LinearLayout;", "mDragMirrorView", "Landroid/widget/RelativeLayout;", "mDragMirrorView0", "mDragMirrorView1", "mDragMirrorView2", "mDragMirrorView3", "mEnterMineInnerTime", "", "mExpoReportHelper", "Lcom/tencent/mobileqq/mini/report/MiniValidExpoReportHelper;", "getMExpoReportHelper", "()Lcom/tencent/mobileqq/mini/report/MiniValidExpoReportHelper;", "mListScrolling", "", "mLocationDragMineViewId", "mMineRvDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "Lkotlin/collections/ArrayList;", "mMiniAppDesktopViewModel", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopViewModel;", "getMMiniAppDesktopViewModel", "()Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopViewModel;", "mMiniAppDesktopViewModel$delegate", "Lkotlin/Lazy;", "mMiniAppInnerMineRv", "Landroidx/recyclerview/widget/RecyclerView;", "mMiniAppMineInnerRvAdapter", "Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/MiniAppMineInnerRvAdapter;", "mMiniAppMineMoreSection", "Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/section/MiniAppMoreUiSection;", "mMiniEmptyGuideRl", "mMiniEmptyGuideTv", "Landroid/widget/TextView;", "mRecentInsertSwitchCurrentFromPosition", "mTitleTv", "bindView", "", "titleInfo", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppModuleInfo;", "dataList", "", "isForceRefresh", "cancelMiniAppExpoReport", "holder", "desktopAppInfo", "doExpoReportAfterScroll", "doMiniAppExpoReport", "position", "findIndexFromMineRv", "fromDesktopAppInfo", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "getInsertMyMiniAppPosition", "draggingView", "getInsertMyMiniAppPositionIndex", "draggingViewId", "handleDragMirrorView", "setData", "setDragMirrorViewHeight", "height", "", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppMineViewHolder extends RecyclerView.ViewHolder {
    private static final String TAG = "MiniAppDesktopPart.MiniAppMineViewHolder";
    private final MiniAppMineViewHolder$mDragListener$1 mDragListener;
    private int mDragMineRvOut;
    private LinearLayout mDragMirrorLl;
    private RelativeLayout mDragMirrorView;
    private View mDragMirrorView0;
    private View mDragMirrorView1;
    private View mDragMirrorView2;
    private View mDragMirrorView3;
    private volatile long mEnterMineInnerTime;
    private final MiniValidExpoReportHelper mExpoReportHelper;
    private boolean mListScrolling;
    private volatile int mLocationDragMineViewId;
    private ArrayList<DesktopItemInfo> mMineRvDataList;

    /* renamed from: mMiniAppDesktopViewModel$delegate, reason: from kotlin metadata */
    private final Lazy mMiniAppDesktopViewModel;
    private RecyclerView mMiniAppInnerMineRv;
    private MiniAppMineInnerRvAdapter mMiniAppMineInnerRvAdapter;
    private MiniAppMoreUiSection mMiniAppMineMoreSection;
    private RelativeLayout mMiniEmptyGuideRl;
    private TextView mMiniEmptyGuideTv;
    private volatile int mRecentInsertSwitchCurrentFromPosition;
    private TextView mTitleTv;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppMineViewHolder$mDragListener$1, android.view.View$OnDragListener] */
    public MiniAppMineViewHolder(final View itemView) {
        super(itemView);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MiniAppDeskTopViewModel>() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppMineViewHolder$mMiniAppDesktopViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MiniAppDeskTopViewModel invoke() {
                ViewModelStoreOwner viewModelStoreOwner = ViewTreeViewModelStoreOwner.get(itemView);
                MiniAppDeskTopViewModel miniAppDeskTopViewModel = viewModelStoreOwner != null ? (MiniAppDeskTopViewModel) new ViewModelProvider(viewModelStoreOwner).get(MiniAppDeskTopViewModel.class) : null;
                if (miniAppDeskTopViewModel != null) {
                    Context context = itemView.getContext();
                    Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                    miniAppDeskTopViewModel.setContextHashCode(((Activity) context).hashCode());
                }
                return miniAppDeskTopViewModel;
            }
        });
        this.mMiniAppDesktopViewModel = lazy;
        this.mMineRvDataList = new ArrayList<>();
        this.mExpoReportHelper = new MiniValidExpoReportHelper("MiniAppMineViewHolder");
        this.mRecentInsertSwitchCurrentFromPosition = -1;
        this.mEnterMineInnerTime = -1L;
        this.mLocationDragMineViewId = -1;
        ?? r06 = new View.OnDragListener() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppMineViewHolder$mDragListener$1
            private final boolean myMiniAppInnerDraggingEvent(View view, DragEvent event) {
                LifecycleCoroutineScope lifecycleScope;
                LifecycleCoroutineScope lifecycleScope2;
                if (event.getAction() != 2) {
                    QLog.i("MiniAppDesktopPart.MiniAppMineViewHolder", 1, "myMiniAppInnerDraggingEvent\uff0cviewId:" + view.getId() + ", action:" + MiniAppDragHelper.INSTANCE.getDragActionString(event.getAction()) + ", view:" + view + ", event:" + event);
                }
                switch (event.getAction()) {
                    case 3:
                        LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(itemView);
                        if (lifecycleOwner != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) != null) {
                            BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new MiniAppMineViewHolder$mDragListener$1$myMiniAppInnerDraggingEvent$2(MiniAppMineViewHolder.this, event, view, null), 3, null);
                        }
                        break;
                    case 1:
                    case 2:
                        return true;
                    case 4:
                        MiniAppMineViewHolder.this.mDragMineRvOut = 0;
                        MiniAppMineViewHolder.this.mLocationDragMineViewId = -1;
                        MiniAppMineViewHolder.this.mRecentInsertSwitchCurrentFromPosition = -1;
                        return true;
                    case 5:
                        LifecycleOwner lifecycleOwner2 = ViewTreeLifecycleOwner.get(itemView);
                        if (lifecycleOwner2 != null && (lifecycleScope2 = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner2)) != null) {
                            BuildersKt__Builders_commonKt.launch$default(lifecycleScope2, null, null, new MiniAppMineViewHolder$mDragListener$1$myMiniAppInnerDraggingEvent$1(MiniAppMineViewHolder.this, event, view, null), 3, null);
                        }
                        return true;
                    case 6:
                        MiniAppMineViewHolder.this.mDragMineRvOut = 1;
                        MiniAppMineViewHolder.this.mLocationDragMineViewId = -1;
                        return true;
                    default:
                        return false;
                }
            }

            private final void recentMiniAppDragDrop(View view, DragEvent event) {
                LifecycleCoroutineScope lifecycleScope;
                Object localState = event.getLocalState();
                Intrinsics.checkNotNull(localState, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppDragData");
                MiniAppDragData miniAppDragData = (MiniAppDragData) localState;
                miniAppDragData.getStartViewHolder().itemView.setVisibility(0);
                ((FrameLayout) miniAppDragData.getStartViewHolder().itemView.findViewById(R.id.rg_)).setVisibility(4);
                LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(itemView);
                if (lifecycleOwner == null || (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) == null) {
                    return;
                }
                BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new MiniAppMineViewHolder$mDragListener$1$recentMiniAppDragDrop$1(MiniAppMineViewHolder.this, miniAppDragData, view, null), 3, null);
            }

            private final void recentMiniAppDragEntered(DragEvent event) {
                MiniAppDragHelper.Companion companion = MiniAppDragHelper.INSTANCE;
                Object localState = event.getLocalState();
                Intrinsics.checkNotNull(localState, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppDragData");
                companion.updateDragShadow((MiniAppDragData) localState, R.drawable.ho9, 0);
                MiniAppMineViewHolder.this.mEnterMineInnerTime = System.currentTimeMillis();
            }

            private final void recentMiniAppDragLocation(View view, DragEvent event) {
                long j3;
                int i3;
                RelativeLayout relativeLayout;
                TextView textView;
                int insertMyMiniAppPositionIndex;
                LifecycleCoroutineScope lifecycleScope;
                long currentTimeMillis = System.currentTimeMillis();
                j3 = MiniAppMineViewHolder.this.mEnterMineInnerTime;
                if (currentTimeMillis - j3 >= 300 && MiniAppMineViewHolder.this.mMiniAppMineInnerRvAdapter != null) {
                    i3 = MiniAppMineViewHolder.this.mLocationDragMineViewId;
                    if (i3 == view.getId()) {
                        return;
                    }
                    MiniAppMineViewHolder.this.mLocationDragMineViewId = view.getId();
                    Object localState = event.getLocalState();
                    Intrinsics.checkNotNull(localState, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppDragData");
                    DesktopAppInfo fromDesktopAppInfo = ((MiniAppDragData) localState).getFromDesktopAppInfo();
                    fromDesktopAppInfo.isTemp = true;
                    relativeLayout = MiniAppMineViewHolder.this.mMiniEmptyGuideRl;
                    if (relativeLayout != null) {
                        relativeLayout.setBackgroundResource(R.drawable.jy6);
                    }
                    textView = MiniAppMineViewHolder.this.mMiniEmptyGuideTv;
                    if (textView != null) {
                        textView.setText(HardCodeUtil.qqStr(R.string.f213415q5));
                    }
                    insertMyMiniAppPositionIndex = MiniAppMineViewHolder.this.getInsertMyMiniAppPositionIndex(view.getId());
                    QLog.i("MiniAppDesktopPart.MiniAppMineViewHolder", 1, "recentInsertToPosition:" + insertMyMiniAppPositionIndex);
                    LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(itemView);
                    if (lifecycleOwner == null || (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) == null) {
                        return;
                    }
                    BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new MiniAppMineViewHolder$mDragListener$1$recentMiniAppDragLocation$1(MiniAppMineViewHolder.this, fromDesktopAppInfo, insertMyMiniAppPositionIndex, null), 3, null);
                }
            }

            private final void recentMiniAppDragStarted() {
                RelativeLayout relativeLayout;
                MiniAppMoreUiSection miniAppMoreUiSection;
                RecyclerView recyclerView;
                relativeLayout = MiniAppMineViewHolder.this.mMiniEmptyGuideRl;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(0);
                }
                MiniAppMineViewHolder.this.setDragMirrorViewHeight(84.0f);
                miniAppMoreUiSection = MiniAppMineViewHolder.this.mMiniAppMineMoreSection;
                if (miniAppMoreUiSection != null) {
                    miniAppMoreUiSection.setTitleVisibleWhenDragStar(3, MiniAppMineViewHolder.this.mMineRvDataList.size());
                }
                recyclerView = MiniAppMineViewHolder.this.mMiniAppInnerMineRv;
                if (recyclerView == null) {
                    return;
                }
                recyclerView.setVisibility(0);
            }

            private final boolean recentMiniAppDraggingEvent(View view, DragEvent event) {
                LifecycleCoroutineScope lifecycleScope;
                if (event.getAction() != 2) {
                    QLog.i("MiniAppDesktopPart.MiniAppMineViewHolder", 1, "recentMiniAppDraggingEvent\uff0cviewId:" + view.getId() + ", action:" + MiniAppDragHelper.INSTANCE.getDragActionString(event.getAction()) + ", view:" + view + ", event:" + event);
                }
                switch (event.getAction()) {
                    case 1:
                        recentMiniAppDragStarted();
                        return true;
                    case 2:
                        recentMiniAppDragLocation(view, event);
                        return true;
                    case 3:
                        recentMiniAppDragDrop(view, event);
                        return true;
                    case 4:
                        recentMiniAppDragEnded();
                        MiniAppMineViewHolder.this.mDragMineRvOut = 0;
                        MiniAppMineViewHolder.this.mLocationDragMineViewId = -1;
                        MiniAppMineViewHolder.this.mRecentInsertSwitchCurrentFromPosition = -1;
                        return true;
                    case 5:
                        recentMiniAppDragEntered(event);
                        return true;
                    case 6:
                        LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(itemView);
                        if (lifecycleOwner != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) != null) {
                            BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new MiniAppMineViewHolder$mDragListener$1$recentMiniAppDraggingEvent$1(MiniAppMineViewHolder.this, null), 3, null);
                        }
                        MiniAppDragHelper.Companion companion = MiniAppDragHelper.INSTANCE;
                        Object localState = event.getLocalState();
                        Intrinsics.checkNotNull(localState, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppDragData");
                        companion.updateDragShadow((MiniAppDragData) localState, -1, 4);
                        MiniAppMineViewHolder.this.mDragMineRvOut = 1;
                        MiniAppMineViewHolder.this.mLocationDragMineViewId = -1;
                        return true;
                    default:
                        return false;
                }
            }

            private final void subPageDragDrop(DragEvent event, View draggingView) {
                int insertMyMiniAppPosition;
                LifecycleCoroutineScope lifecycleScope;
                insertMyMiniAppPosition = MiniAppMineViewHolder.this.getInsertMyMiniAppPosition(draggingView);
                Object localState = event.getLocalState();
                Intrinsics.checkNotNull(localState, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppDragData");
                MiniAppDragData miniAppDragData = (MiniAppDragData) localState;
                LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(itemView);
                if (lifecycleOwner == null || (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) == null) {
                    return;
                }
                BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new MiniAppMineViewHolder$mDragListener$1$subPageDragDrop$1(MiniAppMineViewHolder.this, miniAppDragData, insertMyMiniAppPosition, null), 3, null);
            }

            private final void subPageDragEntered(DragEvent event, View draggingView) {
                int insertMyMiniAppPosition;
                LifecycleCoroutineScope lifecycleScope;
                Object localState = event.getLocalState();
                Intrinsics.checkNotNull(localState, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppDragData");
                int fromPosition = ((MiniAppDragData) localState).getFromPosition();
                insertMyMiniAppPosition = MiniAppMineViewHolder.this.getInsertMyMiniAppPosition(draggingView);
                if (MiniAppMineViewHolder.this.mMiniAppMineInnerRvAdapter != null && fromPosition != insertMyMiniAppPosition && fromPosition >= 0 && fromPosition < MiniAppMineViewHolder.this.mMineRvDataList.size() && insertMyMiniAppPosition >= 0 && insertMyMiniAppPosition < MiniAppMineViewHolder.this.mMineRvDataList.size()) {
                    LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(itemView);
                    if (lifecycleOwner == null || (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) == null) {
                        return;
                    }
                    BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new MiniAppMineViewHolder$mDragListener$1$subPageDragEntered$1(MiniAppMineViewHolder.this, fromPosition, insertMyMiniAppPosition, null), 3, null);
                    return;
                }
                QLog.i("MiniAppDesktopPart.MiniAppMineViewHolder", 1, "\"\u963b\u6b62\u76f8\u540c or \u975e\u6cd5\uff0cfromPosition:" + fromPosition + ", toPosition:" + insertMyMiniAppPosition + "\"");
            }

            private final boolean subPageDraggingEvent(View view, DragEvent event) {
                if (event.getAction() != 2) {
                    QLog.i("MiniAppDesktopPart.MiniAppMineViewHolder", 1, "subPageDraggingEvent\uff0cviewId:" + view.getId() + ", action:" + MiniAppDragHelper.INSTANCE.getDragActionString(event.getAction()) + ", view:" + view + ", event:" + event);
                }
                int action = event.getAction();
                if (action != 1) {
                    if (action != 3) {
                        if (action == 4) {
                            MiniAppMineViewHolder.this.mDragMineRvOut = 0;
                            MiniAppMineViewHolder.this.mLocationDragMineViewId = -1;
                            MiniAppMineViewHolder.this.mRecentInsertSwitchCurrentFromPosition = -1;
                            return true;
                        }
                        if (action == 5) {
                            subPageDragEntered(event, view);
                            return true;
                        }
                        if (action != 6) {
                            return false;
                        }
                        MiniAppMineViewHolder.this.mDragMineRvOut = 1;
                        MiniAppMineViewHolder.this.mLocationDragMineViewId = -1;
                        return true;
                    }
                    subPageDragDrop(event, view);
                }
                return true;
            }

            private final void recentMiniAppDragEnded() {
                RelativeLayout relativeLayout;
                RecyclerView recyclerView;
                MiniAppMoreUiSection miniAppMoreUiSection;
                RecyclerView recyclerView2;
                MiniAppMoreUiSection miniAppMoreUiSection2;
                QLog.i("MiniAppDesktopPart.MiniAppMineViewHolder", 1, "onDrag()");
                relativeLayout = MiniAppMineViewHolder.this.mMiniEmptyGuideRl;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
                if (MiniAppMineViewHolder.this.mMineRvDataList.isEmpty()) {
                    MiniAppMineViewHolder.this.setDragMirrorViewHeight(0.1f);
                    recyclerView2 = MiniAppMineViewHolder.this.mMiniAppInnerMineRv;
                    if (recyclerView2 != null) {
                        recyclerView2.setVisibility(8);
                    }
                    miniAppMoreUiSection2 = MiniAppMineViewHolder.this.mMiniAppMineMoreSection;
                    if (miniAppMoreUiSection2 != null) {
                        miniAppMoreUiSection2.setTitleGoneWhenDragging();
                        return;
                    }
                    return;
                }
                recyclerView = MiniAppMineViewHolder.this.mMiniAppInnerMineRv;
                if (recyclerView != null) {
                    recyclerView.setVisibility(0);
                }
                miniAppMoreUiSection = MiniAppMineViewHolder.this.mMiniAppMineMoreSection;
                if (miniAppMoreUiSection != null) {
                    miniAppMoreUiSection.setTitleVisibleWhenDragging(3, MiniAppMineViewHolder.this.mMineRvDataList.size());
                }
            }

            @Override // android.view.View.OnDragListener
            public boolean onDrag(View view, DragEvent event) {
                if (view != null && event != null && event.getLocalState() != null && (event.getLocalState() instanceof MiniAppDragData)) {
                    Object localState = event.getLocalState();
                    Intrinsics.checkNotNull(localState, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppDragData");
                    int id5 = ((MiniAppDragData) localState).getStartRv().getId();
                    if (id5 == R.id.rfb) {
                        return subPageDraggingEvent(view, event);
                    }
                    if (id5 == R.id.rgh) {
                        return myMiniAppInnerDraggingEvent(view, event);
                    }
                    if (id5 != R.id.rgk) {
                        return false;
                    }
                    return recentMiniAppDraggingEvent(view, event);
                }
                QLog.e("MiniAppDesktopPart.MiniAppMineViewHolder", 1, "onDrag failed!");
                return false;
            }
        };
        this.mDragListener = r06;
        this.mMiniAppInnerMineRv = (RecyclerView) itemView.findViewById(R.id.rgh);
        this.mTitleTv = (TextView) itemView.findViewById(R.id.rgt);
        this.mMiniAppMineMoreSection = new MiniAppMoreUiSection(itemView, 3, new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppMineViewHolder.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                QLog.i(MiniAppMineViewHolder.TAG, 1, "MiniAppMineViewHolder more btn click");
                MiniAppDeskTopViewModel mMiniAppDesktopViewModel = MiniAppMineViewHolder.this.getMMiniAppDesktopViewModel();
                if (mMiniAppDesktopViewModel != null) {
                    final MiniAppMineViewHolder miniAppMineViewHolder = MiniAppMineViewHolder.this;
                    mMiniAppDesktopViewModel.setEffect(new Function0<MiniAppDesktopEffect>() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppMineViewHolder.1.1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final MiniAppDesktopEffect invoke() {
                            ArrayList arrayList = MiniAppMineViewHolder.this.mMineRvDataList;
                            TextView textView = MiniAppMineViewHolder.this.mTitleTv;
                            Intrinsics.checkNotNull(textView);
                            return new MiniAppDesktopEffect.SetSubLayoutDesktopDataList(arrayList, 3, textView.getText().toString());
                        }
                    });
                }
            }
        });
        this.mMiniEmptyGuideRl = (RelativeLayout) itemView.findViewById(R.id.f163685rg2);
        this.mMiniEmptyGuideTv = (TextView) itemView.findViewById(R.id.f163686rg3);
        this.mDragMirrorLl = (LinearLayout) itemView.findViewById(R.id.f163684rg1);
        this.mDragMirrorView0 = itemView.findViewById(R.id.rft);
        this.mDragMirrorView1 = itemView.findViewById(R.id.rfu);
        this.mDragMirrorView2 = itemView.findViewById(R.id.rfv);
        this.mDragMirrorView3 = itemView.findViewById(R.id.rfw);
        this.mMiniAppMineInnerRvAdapter = new MiniAppMineInnerRvAdapter(new MiniAppItemCallback(), new MiniAppMineInnerRvDelegatesManager()) { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppMineViewHolder.2
            @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
            public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                super.onViewAttachedToWindow(holder);
                MiniAppMineViewHolder miniAppMineViewHolder = MiniAppMineViewHolder.this;
                int adapterPosition = holder.getAdapterPosition();
                Object tag = holder.itemView.getTag();
                Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo");
                miniAppMineViewHolder.doMiniAppExpoReport(holder, adapterPosition, (DesktopItemInfo) tag);
            }

            @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
            public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                super.onViewDetachedFromWindow(holder);
                MiniAppMineViewHolder miniAppMineViewHolder = MiniAppMineViewHolder.this;
                Object tag = holder.itemView.getTag();
                Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo");
                miniAppMineViewHolder.cancelMiniAppExpoReport(holder, (DesktopItemInfo) tag);
            }
        };
        final Context context = itemView.getContext();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context) { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppMineViewHolder$gridLayoutManager$1
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean isAutoMeasureEnabled() {
                return false;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
            public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int widthSpec, int heightSpec) {
                RecyclerView recyclerView;
                Intrinsics.checkNotNullParameter(recycler, "recycler");
                Intrinsics.checkNotNullParameter(state, "state");
                recyclerView = MiniAppMineViewHolder.this.mMiniAppInnerMineRv;
                setMeasuredDimension(widthSpec, Utils.n(84.0f, recyclerView != null ? recyclerView.getResources() : null));
            }
        };
        gridLayoutManager.setOrientation(1);
        RecyclerView recyclerView = this.mMiniAppInnerMineRv;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(gridLayoutManager);
        }
        RecyclerView recyclerView2 = this.mMiniAppInnerMineRv;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.mMiniAppMineInnerRvAdapter);
        }
        RecyclerView recyclerView3 = this.mMiniAppInnerMineRv;
        if (recyclerView3 != null) {
            recyclerView3.setHasFixedSize(false);
        }
        RecyclerView recyclerView4 = this.mMiniAppInnerMineRv;
        if (recyclerView4 != null) {
            Intrinsics.checkNotNull(recyclerView4);
            recyclerView4.addOnItemTouchListener(new MiniAppInnerRvItemTouchForDragListener(recyclerView4, new MiniAppInnerRvItemLongClickForDragListener() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppMineViewHolder.3
                @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppInnerRvItemLongClickForDragListener
                public void onItemClick(RecyclerView rv5, RecyclerView.ViewHolder vh5, int fromPosition) {
                    Intrinsics.checkNotNullParameter(rv5, "rv");
                    Intrinsics.checkNotNullParameter(vh5, "vh");
                    QLog.i(MiniAppMineViewHolder.TAG, 1, "mMiniAppInnerRecentRv, onItemClick");
                    if (fromPosition >= 0 && fromPosition < MiniAppMineViewHolder.this.mMineRvDataList.size()) {
                        MiniAppItemClickLaunchUtils miniAppItemClickLaunchUtils = MiniAppItemClickLaunchUtils.INSTANCE;
                        Object obj = MiniAppMineViewHolder.this.mMineRvDataList.get(fromPosition);
                        Intrinsics.checkNotNullExpressionValue(obj, "mMineRvDataList[fromPosition]");
                        Context context2 = rv5.getContext();
                        Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.app.Activity");
                        MiniAppItemClickLaunchUtils.startMini$default(miniAppItemClickLaunchUtils, (DesktopItemInfo) obj, vh5, (Activity) context2, MiniAppMineViewHolder.this.getMMiniAppDesktopViewModel(), 0, 16, null);
                        MiniAppUtils.updateMiniAppList(104);
                        return;
                    }
                    QLog.i(MiniAppMineViewHolder.TAG, 1, "onItemClick fromPosition:" + fromPosition + "is invalid!");
                }

                @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppInnerRvItemLongClickForDragListener
                public void onItemLongClick(RecyclerView rv5, RecyclerView.ViewHolder vh5, int fromPosition, float rawX, float rawY) {
                    List<DesktopItemInfo> items;
                    List<DesktopItemInfo> items2;
                    Intrinsics.checkNotNullParameter(rv5, "rv");
                    Intrinsics.checkNotNullParameter(vh5, "vh");
                    QLog.i(MiniAppMineViewHolder.TAG, 1, "mMiniAppInnerRecentRv, onItemLongClick");
                    if (MiniAppMineViewHolder.this.mMiniAppMineInnerRvAdapter != null) {
                        MiniAppMineInnerRvAdapter miniAppMineInnerRvAdapter = MiniAppMineViewHolder.this.mMiniAppMineInnerRvAdapter;
                        DesktopItemInfo desktopItemInfo = null;
                        if ((miniAppMineInnerRvAdapter != null ? miniAppMineInnerRvAdapter.getItems() : null) != null && fromPosition >= 0) {
                            MiniAppMineInnerRvAdapter miniAppMineInnerRvAdapter2 = MiniAppMineViewHolder.this.mMiniAppMineInnerRvAdapter;
                            Integer valueOf = (miniAppMineInnerRvAdapter2 == null || (items2 = miniAppMineInnerRvAdapter2.getItems()) == null) ? null : Integer.valueOf(items2.size());
                            Intrinsics.checkNotNull(valueOf);
                            if (fromPosition < valueOf.intValue()) {
                                MiniAppDragHelper.Companion companion = MiniAppDragHelper.INSTANCE;
                                RelativeLayout relativeLayout = MiniAppMineViewHolder.this.mDragMirrorView;
                                MiniAppMineInnerRvAdapter miniAppMineInnerRvAdapter3 = MiniAppMineViewHolder.this.mMiniAppMineInnerRvAdapter;
                                if (miniAppMineInnerRvAdapter3 != null && (items = miniAppMineInnerRvAdapter3.getItems()) != null) {
                                    desktopItemInfo = items.get(fromPosition);
                                }
                                Intrinsics.checkNotNull(desktopItemInfo, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo");
                                companion.startDrag(rv5, vh5, relativeLayout, fromPosition, (DesktopAppInfo) desktopItemInfo, rawX, rawY);
                                return;
                            }
                        }
                    }
                    QLog.i(MiniAppMineViewHolder.TAG, 1, "onItemLongClick fromPosition:" + fromPosition + "is invalid!");
                }
            }));
        }
        itemView.post(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.j
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppMineViewHolder._init_$lambda$0(itemView, this);
            }
        });
        View view = this.mDragMirrorView0;
        if (view != 0) {
            view.setOnDragListener(r06);
        }
        View view2 = this.mDragMirrorView1;
        if (view2 != 0) {
            view2.setOnDragListener(r06);
        }
        View view3 = this.mDragMirrorView2;
        if (view3 != 0) {
            view3.setOnDragListener(r06);
        }
        View view4 = this.mDragMirrorView3;
        if (view4 != 0) {
            view4.setOnDragListener(r06);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(View itemView, MiniAppMineViewHolder this$0) {
        LifecycleCoroutineScope lifecycleScope;
        Intrinsics.checkNotNullParameter(itemView, "$itemView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(itemView);
        if (lifecycleOwner == null || (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new MiniAppMineViewHolder$4$1(this$0, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doExpoReportAfterScroll() {
        View view;
        RecyclerView recyclerView = this.mMiniAppInnerMineRv;
        if (recyclerView == null || this.mMiniAppMineInnerRvAdapter == null) {
            return;
        }
        Intrinsics.checkNotNull(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        if (findFirstVisibleItemPosition > findLastVisibleItemPosition) {
            return;
        }
        while (true) {
            RecyclerView recyclerView2 = this.mMiniAppInnerMineRv;
            Intrinsics.checkNotNull(recyclerView2);
            RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView2.findViewHolderForAdapterPosition(findFirstVisibleItemPosition);
            Object tag = (findViewHolderForAdapterPosition == null || (view = findViewHolderForAdapterPosition.itemView) == null) ? null : view.getTag();
            doMiniAppExpoReport(findViewHolderForAdapterPosition, findFirstVisibleItemPosition, tag instanceof DesktopItemInfo ? (DesktopItemInfo) tag : null);
            if (findFirstVisibleItemPosition == findLastVisibleItemPosition) {
                return;
            } else {
                findFirstVisibleItemPosition++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doMiniAppExpoReport(final RecyclerView.ViewHolder holder, final int position, final DesktopItemInfo desktopAppInfo) {
        if (this.mListScrolling) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.k
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppMineViewHolder.doMiniAppExpoReport$lambda$2(RecyclerView.ViewHolder.this, desktopAppInfo, position, this);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int findIndexFromMineRv(DesktopAppInfo fromDesktopAppInfo, List<DesktopItemInfo> dataList) {
        for (DesktopItemInfo desktopItemInfo : dataList) {
            if (desktopItemInfo instanceof DesktopAppInfo) {
                Boolean areItemsTheSame = desktopItemInfo.areItemsTheSame(fromDesktopAppInfo);
                Intrinsics.checkNotNullExpressionValue(areItemsTheSame, "item.areItemsTheSame(fromDesktopAppInfo)");
                if (areItemsTheSame.booleanValue()) {
                    return dataList.indexOf(desktopItemInfo);
                }
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getInsertMyMiniAppPosition(View draggingView) {
        switch (draggingView.getId()) {
            case R.id.rft /* 2063925383 */:
                return 0;
            case R.id.rfu /* 2063925384 */:
                return 1;
            case R.id.rfv /* 2063925385 */:
                return 2;
            case R.id.rfw /* 2063925386 */:
                return 3;
            default:
                return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getInsertMyMiniAppPositionIndex(int draggingViewId) {
        switch (draggingViewId) {
            case R.id.rft /* 2063925383 */:
                return 0;
            case R.id.rfu /* 2063925384 */:
                return 1;
            case R.id.rfv /* 2063925385 */:
                return 2;
            case R.id.rfw /* 2063925386 */:
                return 3;
            default:
                return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MiniAppDeskTopViewModel getMMiniAppDesktopViewModel() {
        return (MiniAppDeskTopViewModel) this.mMiniAppDesktopViewModel.getValue();
    }

    private final void handleDragMirrorView(List<DesktopItemInfo> dataList) {
        if (dataList.isEmpty()) {
            setDragMirrorViewHeight(0.1f);
            RecyclerView recyclerView = this.mMiniAppInnerMineRv;
            if (recyclerView == null) {
                return;
            }
            recyclerView.setVisibility(8);
            return;
        }
        RecyclerView recyclerView2 = this.mMiniAppInnerMineRv;
        if (recyclerView2 == null) {
            return;
        }
        recyclerView2.setVisibility(0);
    }

    private final void setData(List<DesktopItemInfo> dataList, boolean isForceRefresh) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(dataList);
        MiniAppMineInnerRvAdapter miniAppMineInnerRvAdapter = this.mMiniAppMineInnerRvAdapter;
        Intrinsics.checkNotNull(miniAppMineInnerRvAdapter);
        miniAppMineInnerRvAdapter.setItems(arrayList);
        if (isForceRefresh) {
            MiniAppMineInnerRvAdapter miniAppMineInnerRvAdapter2 = this.mMiniAppMineInnerRvAdapter;
            Intrinsics.checkNotNull(miniAppMineInnerRvAdapter2);
            miniAppMineInnerRvAdapter2.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDragMirrorViewHeight(float height) {
        LinearLayout linearLayout = this.mDragMirrorLl;
        ViewGroup.LayoutParams layoutParams = linearLayout != null ? linearLayout.getLayoutParams() : null;
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.height = ViewUtils.dpToPx(height);
        LinearLayout linearLayout2 = this.mDragMirrorLl;
        if (linearLayout2 == null) {
            return;
        }
        linearLayout2.setLayoutParams(layoutParams2);
    }

    public final void bindView(DesktopAppModuleInfo titleInfo, List<DesktopItemInfo> dataList, boolean isForceRefresh) {
        Intrinsics.checkNotNullParameter(titleInfo, "titleInfo");
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        QLog.i(TAG, 1, "\u6211\u7684\u5c0f\u7a0b\u5e8f, RV bindView");
        this.mMineRvDataList.clear();
        this.mMineRvDataList.addAll(dataList);
        setData(this.mMineRvDataList, isForceRefresh);
        RelativeLayout relativeLayout = this.mMiniEmptyGuideRl;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            return;
        }
        MiniAppMoreUiSection miniAppMoreUiSection = this.mMiniAppMineMoreSection;
        if (miniAppMoreUiSection != null) {
            miniAppMoreUiSection.bindView(titleInfo, dataList);
        }
        handleDragMirrorView(dataList);
    }

    public final MiniValidExpoReportHelper getMExpoReportHelper() {
        return this.mExpoReportHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelMiniAppExpoReport(RecyclerView.ViewHolder holder, DesktopItemInfo desktopAppInfo) {
        MiniAppInfo miniAppInfo;
        if (holder == null || !(desktopAppInfo instanceof DesktopAppInfo) || (miniAppInfo = ((DesktopAppInfo) desktopAppInfo).mMiniAppInfo) == null) {
            return;
        }
        MiniAppDesktopRvPartExpoHelper miniAppDesktopRvPartExpoHelper = MiniAppDesktopRvPartExpoHelper.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(miniAppInfo, "desktopAppInfo.mMiniAppInfo");
        String buildMiniAppExpoReportIdentity = miniAppDesktopRvPartExpoHelper.buildMiniAppExpoReportIdentity(miniAppInfo);
        this.mExpoReportHelper.cancelExpoReport(buildMiniAppExpoReportIdentity + MiniAppExposureManager.EXPO_VALID);
        this.mExpoReportHelper.cancelExpoReport(buildMiniAppExpoReportIdentity + MiniAppExposureManager.EXPO);
        this.mExpoReportHelper.cancelExpoReport(buildMiniAppExpoReportIdentity + MiniAppExposureManager.EXPO_TIAN_SHU);
        this.mExpoReportHelper.cancelExpoReport(buildMiniAppExpoReportIdentity + MiniAppExposureManager.EXPO_CATEGORY);
    }

    public static /* synthetic */ void bindView$default(MiniAppMineViewHolder miniAppMineViewHolder, DesktopAppModuleInfo desktopAppModuleInfo, List list, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        miniAppMineViewHolder.bindView(desktopAppModuleInfo, list, z16);
    }

    static /* synthetic */ void setData$default(MiniAppMineViewHolder miniAppMineViewHolder, List list, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        miniAppMineViewHolder.setData(list, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doMiniAppExpoReport$lambda$2(RecyclerView.ViewHolder viewHolder, DesktopItemInfo desktopItemInfo, int i3, MiniAppMineViewHolder this$0) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (viewHolder == null || desktopItemInfo == null || !(desktopItemInfo instanceof DesktopAppInfo)) {
            return;
        }
        DesktopAppInfo desktopAppInfo = (DesktopAppInfo) desktopItemInfo;
        if (desktopAppInfo.mMiniAppInfo != null) {
            MiniAppConfig miniAppConfig = new MiniAppConfig(desktopAppInfo.mMiniAppInfo);
            miniAppConfig.launchParam.scene = 3003;
            MiniAppDesktopRvPartExpoHelper miniAppDesktopRvPartExpoHelper = MiniAppDesktopRvPartExpoHelper.INSTANCE;
            MiniAppInfo miniAppInfo = desktopAppInfo.mMiniAppInfo;
            Intrinsics.checkNotNullExpressionValue(miniAppInfo, "desktopAppInfo.mMiniAppInfo");
            String buildMiniAppExpoReportIdentity = miniAppDesktopRvPartExpoHelper.buildMiniAppExpoReportIdentity(miniAppInfo);
            if (desktopAppInfo.isRecommendBadgeShow()) {
                str = "1";
            } else {
                str = "0";
            }
            if (desktopAppInfo.isBubbleShown()) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            String str3 = str;
            String str4 = str2;
            MiniAppExposureManager.MiniAppModuleExposureData miniAppModuleExposureData = new MiniAppExposureManager.MiniAppModuleExposureData(miniAppConfig, "page_view", "expo_valid", null, String.valueOf(i3), str3, str4);
            this$0.mExpoReportHelper.beginExpoReport(viewHolder.itemView, miniAppModuleExposureData, buildMiniAppExpoReportIdentity + MiniAppExposureManager.EXPO_VALID);
            MiniAppExposureManager.MiniAppModuleExposureData miniAppModuleExposureData2 = new MiniAppExposureManager.MiniAppModuleExposureData(miniAppConfig, "page_view", "expo", null, null, str3, str4);
            this$0.mExpoReportHelper.beginExpoReport(viewHolder.itemView, miniAppModuleExposureData2, buildMiniAppExpoReportIdentity + MiniAppExposureManager.EXPO);
            int i16 = desktopAppInfo.mMiniAppInfo.tianshuAdId;
            if (i16 > 0) {
                MiniAppExposureManager.TianShuExposureData tianShuExposureData = new MiniAppExposureManager.TianShuExposureData("tianshu.78", "tianshu.78", String.valueOf(i16), 101);
                this$0.mExpoReportHelper.beginExpoReport(viewHolder.itemView, tianShuExposureData, buildMiniAppExpoReportIdentity + MiniAppExposureManager.EXPO_TIAN_SHU);
            }
            MiniAppExposureManager.MiniAppModuleExposureData miniAppModuleExposureData3 = new MiniAppExposureManager.MiniAppModuleExposureData(miniAppConfig, "desktop", MiniProgramLpReportDC04239.DESKTOP_SUB_ACTION_TYPE_MY_APP, "expo", null);
            this$0.mExpoReportHelper.beginExpoReport(viewHolder.itemView, miniAppModuleExposureData3, buildMiniAppExpoReportIdentity + MiniAppExposureManager.EXPO_CATEGORY);
        }
    }
}
