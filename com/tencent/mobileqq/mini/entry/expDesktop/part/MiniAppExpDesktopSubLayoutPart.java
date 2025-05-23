package com.tencent.mobileqq.mini.entry.expDesktop.part;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopGroupAppInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.mvi.MiniAppExpDesktopEffect;
import com.tencent.mobileqq.mini.entry.expDesktop.mvi.MiniAppExpDesktopUIState;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpDesktopSubAdapter;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpDragData;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpDragHelper;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.SearchBarViewAdapter;
import com.tencent.mobileqq.mini.entry.expDesktop.utils.MiniAppListDiffUtils;
import com.tencent.mobileqq.mini.entry.expDesktop.utils.MiniExpValidExpoReportHelper;
import com.tencent.mobileqq.mini.entry.util.MiniAppDesktopCompatibleUtils;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.mini.report.MiniAppExpDesktop04239ReportHelper;
import com.tencent.mobileqq.mini.report.MiniProgramReporter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.az;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 82\u00020\u00012\u00020\u0002:\u00018B\u0005\u00a2\u0006\u0002\u0010\u0003J \u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\b\b\u0002\u0010#\u001a\u00020\u000eH\u0002J\b\u0010$\u001a\u00020!H\u0002J\b\u0010%\u001a\u00020!H\u0002J\u001e\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u00162\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002J\b\u0010(\u001a\u00020\u0007H\u0016J\u0010\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020!H\u0002J\u0006\u0010-\u001a\u00020\u000eJ\u0018\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u0007H\u0002J\u0006\u00101\u001a\u00020\u000eJ\u0012\u00102\u001a\u00020!2\b\u00103\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u00104\u001a\u00020!2\u0006\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u00020!H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/part/MiniAppExpDesktopSubLayoutPart;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/part/MiniAppExpDesktopAbstractPart;", "Landroid/view/View$OnClickListener;", "()V", "mBackBtn", "Landroid/widget/ImageView;", "mCurrentDeleteAppId", "", "mDesktopDraggingProhibitClickView", "Landroid/view/View;", "mExpoReportHelper", "Lcom/tencent/mobileqq/mini/entry/expDesktop/utils/MiniExpValidExpoReportHelper;", "mHostScene", "mIsFinished", "", "mIsViewInit", "mModuleType", "", "mRvConcatAdapter", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "mSubPageDataList", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "mSubPageNavBarLayout", "Landroid/widget/RelativeLayout;", "mSubPageRoot", "Landroid/widget/LinearLayout;", "mSubPageRv", "Landroidx/recyclerview/widget/RecyclerView;", "mSubPageTitle", "Landroid/widget/TextView;", "mVia", "bindSubPageRvView", "", "dataList", "isNeedScrollToTop", "closeSubPage", "compatibleNavigationBar", "findIndexFromMineRv", "fromDesktopAppInfo", "getLogTag", "handleUiState", "uiState", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopUIState;", "initSubPageView", "isSubPageVisible", "miniAppOperateReport", "desktopAppInfo", AdMetricTag.EVENT_NAME, "onBackPressed", NodeProps.ON_CLICK, "v", "openSubPage", QQWinkConstants.TAB_EFFECT, "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopEffect$SetSubLayoutDesktopDataList;", "setLiveDataObserver", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppExpDesktopSubLayoutPart extends MiniAppExpDesktopAbstractPart implements View.OnClickListener {
    private static final String ANIMATION_ALPHA = "alpha";
    private static final long ANIMATION_DURATION = 400;
    private static final String ANIMATION_TRANSLATION_X = "translationX";
    private static final long REFRESH_TIME_INTERVAL = 300;
    private static final int SCROLL_TO_TOP_MIN_COUNT = 20;
    private ImageView mBackBtn;
    private View mDesktopDraggingProhibitClickView;
    private boolean mIsFinished;
    private boolean mIsViewInit;
    private RFWConcatAdapter mRvConcatAdapter;
    private RelativeLayout mSubPageNavBarLayout;
    private LinearLayout mSubPageRoot;
    private RecyclerView mSubPageRv;
    private TextView mSubPageTitle;
    private List<DesktopAppInfo> mSubPageDataList = new ArrayList();
    private int mModuleType = 1;
    private String mVia = "";
    private String mHostScene = "";
    private final MiniExpValidExpoReportHelper mExpoReportHelper = new MiniExpValidExpoReportHelper("subPageMiniAppViewHolder");
    private String mCurrentDeleteAppId = "";

    private final void bindSubPageRvView(List<DesktopAppInfo> dataList, boolean isNeedScrollToTop) {
        this.mSubPageDataList.clear();
        this.mSubPageDataList.addAll(dataList);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.mSubPageDataList);
        RFWConcatAdapter rFWConcatAdapter = this.mRvConcatAdapter;
        Intrinsics.checkNotNull(rFWConcatAdapter);
        List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> adapters = rFWConcatAdapter.getAdapters();
        Intrinsics.checkNotNullExpressionValue(adapters, "mRvConcatAdapter!!.adapters");
        Iterator<T> it = adapters.iterator();
        while (it.hasNext()) {
            RecyclerView.Adapter adapter = (RecyclerView.Adapter) it.next();
            if (adapter instanceof SearchBarViewAdapter) {
                ((SearchBarViewAdapter) adapter).setModuleType(this.mModuleType);
            } else if (adapter instanceof MiniAppExpDesktopSubAdapter) {
                ((MiniAppExpDesktopSubAdapter) adapter).setData(this.mSubPageRv, arrayList, this.mVia, this.mHostScene, this.mModuleType);
            }
        }
        if (!isNeedScrollToTop || arrayList.size() <= 20) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.ab
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppExpDesktopSubLayoutPart.bindSubPageRvView$lambda$5(MiniAppExpDesktopSubLayoutPart.this);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindSubPageRvView$lambda$5(MiniAppExpDesktopSubLayoutPart this$0) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isSubPageVisible() || (recyclerView = this$0.mSubPageRv) == null) {
            return;
        }
        recyclerView.scrollToPosition(0);
    }

    private final void closeSubPage() {
        LinearLayout linearLayout = this.mSubPageRoot;
        if (linearLayout != null && linearLayout.getVisibility() == 8) {
            QLog.w(getTAG(), 1, "closeSubPage but rootView is gone");
            return;
        }
        LinearLayout linearLayout2 = this.mSubPageRoot;
        Intrinsics.checkNotNull(getPartRootView());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(linearLayout2, ANIMATION_TRANSLATION_X, 0.0f, r5.getWidth());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mSubPageRoot, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(400L);
        ofFloat2.setDuration(400L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopSubLayoutPart$closeSubPage$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                LinearLayout linearLayout3;
                int i3;
                String str;
                MiniExpValidExpoReportHelper miniExpValidExpoReportHelper;
                QLog.d(MiniAppExpDesktopSubLayoutPart.this.getTAG(), 4, " --rightOutAnim onAnimationRepeat-- ");
                linearLayout3 = MiniAppExpDesktopSubLayoutPart.this.mSubPageRoot;
                if (linearLayout3 != null) {
                    linearLayout3.setVisibility(8);
                }
                MiniAppDesktopDtReportHelper companion = MiniAppDesktopDtReportHelper.INSTANCE.getInstance();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                i3 = MiniAppExpDesktopSubLayoutPart.this.mModuleType;
                if (i3 == 1) {
                    str = MiniAppDesktopDtReportHelper.MINI_APP_PG_APPLET_RECENTLY_USE_LEVEL2;
                } else {
                    str = MiniAppDesktopDtReportHelper.MINI_APP_PG_APPLET_PERSONAL_LEVEL2;
                }
                companion.miniAppDesktopCommonReport("dt_pgout", "", linkedHashMap, str);
                MiniAppExpDesktopSubLayoutPart.this.getMMiniAppDesktopViewModel().updateSubLayoutOpenState(false);
                miniExpValidExpoReportHelper = MiniAppExpDesktopSubLayoutPart.this.mExpoReportHelper;
                miniExpValidExpoReportHelper.stopValidExpoReport(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                QLog.d(MiniAppExpDesktopSubLayoutPart.this.getTAG(), 4, " --rightOutAnim onAnimationStart-- ");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
            }
        });
        animatorSet.start();
    }

    private final void compatibleNavigationBar() {
        if (az.e(getContext())) {
            float c16 = az.c(getContext());
            RecyclerView recyclerView = this.mSubPageRv;
            Intrinsics.checkNotNull(recyclerView);
            recyclerView.setPadding(0, 0, 0, ((int) c16) + ViewUtils.dip2px(80.0f));
            return;
        }
        RecyclerView recyclerView2 = this.mSubPageRv;
        Intrinsics.checkNotNull(recyclerView2);
        recyclerView2.setPadding(0, 0, 0, ViewUtils.dip2px(80.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int findIndexFromMineRv(DesktopAppInfo fromDesktopAppInfo, List<DesktopAppInfo> dataList) {
        for (DesktopAppInfo desktopAppInfo : dataList) {
            Boolean areItemsTheSame = desktopAppInfo.areItemsTheSame(fromDesktopAppInfo);
            Intrinsics.checkNotNullExpressionValue(areItemsTheSame, "item.areItemsTheSame(fromDesktopAppInfo)");
            if (areItemsTheSame.booleanValue()) {
                return dataList.indexOf(desktopAppInfo);
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initSubPageView() {
        int roundToInt;
        List mutableListOf;
        if (this.mIsViewInit) {
            QLog.i(getTAG(), 1, "initSubPageView is init!");
            return;
        }
        View partRootView = getPartRootView();
        this.mSubPageRoot = partRootView != null ? (LinearLayout) partRootView.findViewById(R.id.req) : null;
        View partRootView2 = getPartRootView();
        this.mSubPageNavBarLayout = partRootView2 != null ? (RelativeLayout) partRootView2.findViewById(R.id.rf_) : null;
        View partRootView3 = getPartRootView();
        this.mBackBtn = partRootView3 != null ? (ImageView) partRootView3.findViewById(R.id.rh6) : null;
        View partRootView4 = getPartRootView();
        this.mSubPageTitle = partRootView4 != null ? (TextView) partRootView4.findViewById(R.id.rhu) : null;
        View partRootView5 = getPartRootView();
        this.mSubPageRv = partRootView5 != null ? (RecyclerView) partRootView5.findViewById(R.id.rfb) : null;
        View findViewById = getPartRootView().findViewById(R.id.rcx);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.mDesktopDraggingProhibitClickView = findViewById;
        Intrinsics.checkNotNull(findViewById);
        findViewById.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.aa
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean initSubPageView$lambda$1;
                initSubPageView$lambda$1 = MiniAppExpDesktopSubLayoutPart.initSubPageView$lambda$1(view, motionEvent);
                return initSubPageView$lambda$1;
            }
        });
        roundToInt = MathKt__MathJVMKt.roundToInt(ImmersiveUtils.getStatusBarHeight(getContext()));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ViewUtils.dpToPx(46.0f));
        layoutParams.setMargins(0, roundToInt, 0, 0);
        RelativeLayout relativeLayout = this.mSubPageNavBarLayout;
        if (relativeLayout != null) {
            relativeLayout.setLayoutParams(layoutParams);
        }
        RelativeLayout relativeLayout2 = this.mSubPageNavBarLayout;
        if (relativeLayout2 != null) {
            relativeLayout2.setOnClickListener(this);
        }
        RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new SearchBarViewAdapter(), new MiniAppExpDesktopSubAdapter());
        this.mRvConcatAdapter = new RFWConcatAdapter(build, (List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>>) mutableListOf);
        RecyclerView recyclerView = this.mSubPageRv;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getPartRootView().getContext()));
            recyclerView.setAdapter(this.mRvConcatAdapter);
        }
        RecyclerView recyclerView2 = this.mSubPageRv;
        if (recyclerView2 != null) {
            recyclerView2.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopSubLayoutPart$initSubPageView$3
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView3, int newState) {
                    int i3;
                    String str;
                    MiniExpValidExpoReportHelper miniExpValidExpoReportHelper;
                    RecyclerView recyclerView4;
                    String str2;
                    String str3;
                    Map<String, String> mutableMapOf;
                    Intrinsics.checkNotNullParameter(recyclerView3, "recyclerView");
                    super.onScrollStateChanged(recyclerView3, newState);
                    if (newState == 0) {
                        i3 = MiniAppExpDesktopSubLayoutPart.this.mModuleType;
                        if (i3 == 1) {
                            str = MiniAppDesktopDtReportHelper.MINI_APP_PG_APPLET_RECENTLY_USE_LEVEL2;
                        } else if (i3 != 3) {
                            str = "";
                        } else {
                            str = MiniAppDesktopDtReportHelper.MINI_APP_PG_APPLET_PERSONAL_LEVEL2;
                        }
                        miniExpValidExpoReportHelper = MiniAppExpDesktopSubLayoutPart.this.mExpoReportHelper;
                        recyclerView4 = MiniAppExpDesktopSubLayoutPart.this.mSubPageRv;
                        str2 = MiniAppExpDesktopSubLayoutPart.this.mVia;
                        str3 = MiniAppExpDesktopSubLayoutPart.this.mHostScene;
                        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("via", str2), TuplesKt.to("module", MiniAppDesktopDtReportHelper.MINI_APP_EM_APPLET_RECENTLY_USE_MODULE), TuplesKt.to("page_id", str), TuplesKt.to(MiniExpValidExpoReportHelper.ReportKeyConst.REPORT_KEY_NOT_POSITION_HOST_SCENE, str3));
                        miniExpValidExpoReportHelper.reportMiniAppExpoEvent(recyclerView4, mutableMapOf);
                    }
                }
            });
        }
        RecyclerView recyclerView3 = this.mSubPageRv;
        if (recyclerView3 != null) {
            recyclerView3.setOnDragListener(new View.OnDragListener() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopSubLayoutPart$initSubPageView$4
                @Override // android.view.View.OnDragListener
                public boolean onDrag(View view, DragEvent event) {
                    View view2;
                    View view3;
                    if (view == null || event == null || event.getLocalState() == null || !(event.getLocalState() instanceof MiniAppExpDragData)) {
                        return false;
                    }
                    if (event.getAction() != 2) {
                        QLog.i(MiniAppExpDesktopSubLayoutPart.this.getTAG(), 1, "root view action:" + MiniAppExpDragHelper.INSTANCE.getDragActionString(event.getAction()) + "\uff0cevent=" + event);
                    }
                    int action = event.getAction();
                    if (action == 1) {
                        if (MiniAppExpDesktopSubLayoutPart.this.getContext() instanceof Activity) {
                            MiniAppDesktopCompatibleUtils.Companion companion = MiniAppDesktopCompatibleUtils.INSTANCE;
                            view2 = MiniAppExpDesktopSubLayoutPart.this.mDesktopDraggingProhibitClickView;
                            companion.compatibleDeviceDraggingState(view2, true);
                        }
                        return true;
                    }
                    if (action != 4) {
                        return false;
                    }
                    if (MiniAppExpDesktopSubLayoutPart.this.getContext() instanceof Activity) {
                        MiniAppDesktopCompatibleUtils.Companion companion2 = MiniAppDesktopCompatibleUtils.INSTANCE;
                        view3 = MiniAppExpDesktopSubLayoutPart.this.mDesktopDraggingProhibitClickView;
                        companion2.compatibleDeviceDraggingState(view3, false);
                    }
                    return true;
                }
            });
        }
        compatibleNavigationBar();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new MiniAppExpDesktopSubLayoutPart$initSubPageView$5(this, null), 3, null);
        ImageView imageView = this.mBackBtn;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        this.mIsViewInit = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initSubPageView$lambda$1(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void miniAppOperateReport(DesktopAppInfo desktopAppInfo, String eventName) {
        String str;
        String str2;
        Map<String, String> mutableMapOf;
        if (this.mModuleType == 1) {
            str = MiniAppDesktopDtReportHelper.MINI_APP_PG_APPLET_RECENTLY_USE_LEVEL2;
        } else {
            str = MiniAppDesktopDtReportHelper.MINI_APP_PG_APPLET_PERSONAL_LEVEL2;
        }
        if (desktopAppInfo.mMiniAppInfo.isWxMiniApp()) {
            str2 = "2";
        } else {
            str2 = "1";
        }
        MiniAppDesktopDtReportHelper companion = MiniAppDesktopDtReportHelper.INSTANCE.getInstance();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("applet_appid", desktopAppInfo.mMiniAppInfo.appId), TuplesKt.to("applet_type", String.valueOf(desktopAppInfo.mMiniAppInfo.engineType)), TuplesKt.to(MiniAppDesktopDtReportHelper.DT_MINI_APP_SOURCE, str2));
        companion.miniAppDesktopCommonReport("qq_clck", eventName, mutableMapOf, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openSubPage(final MiniAppExpDesktopEffect.SetSubLayoutDesktopDataList effect) {
        LinearLayout linearLayout = this.mSubPageRoot;
        Intrinsics.checkNotNull(getPartRootView());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(linearLayout, ANIMATION_TRANSLATION_X, r3.getWidth(), 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mSubPageRoot, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(400L);
        ofFloat2.setDuration(400L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopSubLayoutPart$openSubPage$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                LinearLayout linearLayout2;
                TextView textView;
                QLog.d(MiniAppExpDesktopSubLayoutPart.this.getTAG(), 4, " --rightInAnim onAnimationStart-- ");
                linearLayout2 = MiniAppExpDesktopSubLayoutPart.this.mSubPageRoot;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                }
                textView = MiniAppExpDesktopSubLayoutPart.this.mSubPageTitle;
                if (textView != null) {
                    textView.setText(effect.getTitleName());
                }
                MiniAppExpDesktopSubLayoutPart.this.mModuleType = effect.getModuleType();
                MiniAppExpDesktopSubLayoutPart.this.mVia = effect.getVia();
                MiniAppExpDesktopSubLayoutPart.this.mHostScene = effect.getHostScene();
                MiniAppExpDesktopSubLayoutPart.this.mIsFinished = effect.isFinished();
                MiniAppExpDesktopSubLayoutPart.bindSubPageRvView$default(MiniAppExpDesktopSubLayoutPart.this, effect.getDesktopDataList(), false, 2, null);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                boolean z16;
                boolean z17;
                int i3;
                String str;
                int i16;
                String tag = MiniAppExpDesktopSubLayoutPart.this.getTAG();
                z16 = MiniAppExpDesktopSubLayoutPart.this.mIsFinished;
                QLog.d(tag, 4, " --rightInAnim onAnimationRepeat-- mIsFinished:" + z16);
                MiniAppExpDesktopSubLayoutPart.this.getMMiniAppDesktopViewModel().updateSubLayoutOpenState(true);
                z17 = MiniAppExpDesktopSubLayoutPart.this.mIsFinished;
                if (!z17) {
                    LifecycleOwner lifecycleOwner = MiniAppExpDesktopSubLayoutPart.this.getPartHost().getLifecycleOwner();
                    Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
                    BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new MiniAppExpDesktopSubLayoutPart$openSubPage$1$onAnimationEnd$1(MiniAppExpDesktopSubLayoutPart.this, null), 3, null);
                }
                MiniAppDesktopDtReportHelper companion = MiniAppDesktopDtReportHelper.INSTANCE.getInstance();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                i3 = MiniAppExpDesktopSubLayoutPart.this.mModuleType;
                if (i3 == 1) {
                    str = MiniAppDesktopDtReportHelper.MINI_APP_PG_APPLET_RECENTLY_USE_LEVEL2;
                } else {
                    str = MiniAppDesktopDtReportHelper.MINI_APP_PG_APPLET_PERSONAL_LEVEL2;
                }
                companion.miniAppDesktopCommonReport("dt_pgin", "", linkedHashMap, str);
                MiniAppExpDesktop04239ReportHelper miniAppExpDesktop04239ReportHelper = MiniAppExpDesktop04239ReportHelper.INSTANCE;
                i16 = MiniAppExpDesktopSubLayoutPart.this.mModuleType;
                miniAppExpDesktop04239ReportHelper.report((r23 & 1) != 0 ? null : null, (r23 & 2) != 0 ? null : null, "em_expo", (r23 & 8) != 0 ? null : miniAppExpDesktop04239ReportHelper.getPageReserveAction(i16, true), (r23 & 16) != 0 ? null : null, (r23 & 32) != 0 ? null : null, (r23 & 64) != 0 ? null : null, (r23 & 128) != 0 ? null : null, (r23 & 256) != 0 ? null : null);
                MiniProgramReporter.getInstance().flush();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
            }
        });
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setLiveDataObserver$lambda$0(MiniAppExpDesktopSubLayoutPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LifecycleOwner lifecycleOwner = this$0.getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new MiniAppExpDesktopSubLayoutPart$setLiveDataObserver$1$1(this$0, null), 3, null);
        QLog.i(this$0.getTAG(), 1, "setLiveDataObserver");
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "MiniAppExpDesktopPart.MiniAppExpDesktopSubLayoutPart";
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopPartInterface
    public void handleUiState(MiniAppExpDesktopUIState uiState) {
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        if (!isSubPageVisible()) {
            QLog.e(getTAG(), 1, "handleUiState is sub page not visible!");
            return;
        }
        QLog.i(getTAG(), 1, "handleUiState, uiState:" + uiState);
        if (uiState instanceof MiniAppExpDesktopUIState.UpdateDesktopPersonalMiniAppInfo) {
            if (isSubPageVisible()) {
                MiniAppExpDesktopUIState.UpdateDesktopPersonalMiniAppInfo updateDesktopPersonalMiniAppInfo = (MiniAppExpDesktopUIState.UpdateDesktopPersonalMiniAppInfo) uiState;
                if (updateDesktopPersonalMiniAppInfo.getModuleType() == this.mModuleType) {
                    RFWConcatAdapter rFWConcatAdapter = this.mRvConcatAdapter;
                    Intrinsics.checkNotNull(rFWConcatAdapter);
                    List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> adapters = rFWConcatAdapter.getAdapters();
                    Intrinsics.checkNotNullExpressionValue(adapters, "mRvConcatAdapter!!.adapters");
                    Iterator<T> it = adapters.iterator();
                    while (it.hasNext()) {
                        RecyclerView.Adapter adapter = (RecyclerView.Adapter) it.next();
                        if (adapter instanceof MiniAppExpDesktopSubAdapter) {
                            if (this.mCurrentDeleteAppId.length() > 0) {
                                ((MiniAppExpDesktopSubAdapter) adapter).removeDeleteMiniAppItem(this.mSubPageRv, this.mCurrentDeleteAppId);
                                this.mCurrentDeleteAppId = "";
                            } else {
                                DesktopItemInfo desktopItemInfo = updateDesktopPersonalMiniAppInfo.getPersonalModuleMap().get(Integer.valueOf(this.mModuleType));
                                Intrinsics.checkNotNull(desktopItemInfo, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopGroupAppInfo");
                                bindSubPageRvView$default(this, ((ExpDesktopGroupAppInfo) desktopItemInfo).getGroupAppInfo(), false, 2, null);
                            }
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (uiState instanceof MiniAppExpDesktopUIState.MyMiniAppDraggingTempSwitchPosition) {
            if (isSubPageVisible()) {
                MiniAppExpDesktopUIState.MyMiniAppDraggingTempSwitchPosition myMiniAppDraggingTempSwitchPosition = (MiniAppExpDesktopUIState.MyMiniAppDraggingTempSwitchPosition) uiState;
                if (!(!myMiniAppDraggingTempSwitchPosition.getDeepCopyMyMiniAppInfo().isEmpty()) || FastClickUtils.isFastDoubleClick(getTAG(), 300L)) {
                    return;
                }
                QLog.d(getTAG(), 1, "SetDesktopData bindView!");
                bindSubPageRvView$default(this, myMiniAppDraggingTempSwitchPosition.getDeepCopyMyMiniAppInfo(), false, 2, null);
                return;
            }
            return;
        }
        if (uiState instanceof MiniAppExpDesktopUIState.UpdateDesktopMoreMiniAppInfo) {
            if (isSubPageVisible()) {
                MiniAppExpDesktopUIState.UpdateDesktopMoreMiniAppInfo updateDesktopMoreMiniAppInfo = (MiniAppExpDesktopUIState.UpdateDesktopMoreMiniAppInfo) uiState;
                if (updateDesktopMoreMiniAppInfo.getModuleType() == this.mModuleType && (!updateDesktopMoreMiniAppInfo.getMoreMiniAppInfo().isEmpty())) {
                    bindSubPageRvView(MiniAppListDiffUtils.INSTANCE.getDiffListInfoFromLocalToMoreList(this.mSubPageDataList, updateDesktopMoreMiniAppInfo.getMoreMiniAppInfo()), true);
                    return;
                }
                return;
            }
            return;
        }
        if (uiState instanceof MiniAppExpDesktopUIState.CloseMiniAppSubPage) {
            closeSubPage();
        }
    }

    public final boolean isSubPageVisible() {
        LinearLayout linearLayout = this.mSubPageRoot;
        return linearLayout != null && linearLayout.getVisibility() == 0;
    }

    public final boolean onBackPressed() {
        if (!isSubPageVisible()) {
            return false;
        }
        closeSubPage();
        return true;
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartCreate(Activity activity, Bundle bundle) {
        com.tencent.biz.richframework.part.b.a(this, activity, bundle);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartPause(Activity activity) {
        com.tencent.biz.richframework.part.b.c(this, activity);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartResume(Activity activity) {
        com.tencent.biz.richframework.part.b.d(this, activity);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartSaveInstanceState(Activity activity, Bundle bundle) {
        com.tencent.biz.richframework.part.b.e(this, activity, bundle);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartStart(Activity activity) {
        com.tencent.biz.richframework.part.b.f(this, activity);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartStop(Activity activity) {
        com.tencent.biz.richframework.part.b.g(this, activity);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopPartInterface
    public void setLiveDataObserver() {
        if (getPartRootView() == null) {
            QLog.e(getTAG(), 1, "setLiveDataObserver rootView is null");
        } else {
            getPartRootView().post(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.z
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppExpDesktopSubLayoutPart.setLiveDataObserver$lambda$0(MiniAppExpDesktopSubLayoutPart.this);
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.rh6) {
            closeSubPage();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void bindSubPageRvView$default(MiniAppExpDesktopSubLayoutPart miniAppExpDesktopSubLayoutPart, List list, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        miniAppExpDesktopSubLayoutPart.bindSubPageRvView(list, z16);
    }
}
