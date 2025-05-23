package com.tencent.state.status;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.mmkv.SKey;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.data.OnlineStatus;
import com.tencent.state.square.databinding.VasSquareCommonItemPanelBinding;
import com.tencent.state.square.detail.DetailAvatarConfig;
import com.tencent.state.square.detail.DetailMeFragmentConfig;
import com.tencent.state.square.location.IMotionLockListener;
import com.tencent.state.square.location.SquareAvatarMotionLockBar;
import com.tencent.state.square.mmkv.IMMKV;
import com.tencent.state.status.SquareOnlineStatusGridAdapter;
import com.tencent.state.status.SquareOnlineStatusViewPanel;
import com.tencent.state.utils.FastClickUtils;
import com.tencent.state.view.StatusPanelTitleListView;
import com.tencent.state.view.TitleData;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b \b\u0016\u0018\u0000 o2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002opB%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u000200H\u0002J\u0010\u00101\u001a\u0002002\u0006\u0010-\u001a\u000202H\u0002J\u0018\u00103\u001a\u00020\u00192\u0006\u00104\u001a\u00020,2\u0006\u00105\u001a\u00020,H\u0002J\u001c\u00106\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u000208072\u0006\u0010-\u001a\u000202H\u0002J\b\u00109\u001a\u000200H\u0002J=\u0010:\u001a\u0002002\u0018\u0010;\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002020=0<2\b\u0010>\u001a\u0004\u0018\u00010\t2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020,0=\u00a2\u0006\u0002\u0010@J\u000e\u0010A\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010=J\u0006\u0010B\u001a\u00020\tJ\b\u0010C\u001a\u00020\tH\u0016J1\u0010D\u001a\u00020\t2\u0018\u0010E\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002020=0<2\b\u0010>\u001a\u0004\u0018\u00010\tH\u0002\u00a2\u0006\u0002\u0010FJ(\u0010G\u001a\b\u0012\u0004\u0012\u00020.0=2\u0018\u0010-\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002020=0<H\u0002J\u0006\u0010H\u001a\u000200J\b\u0010I\u001a\u000200H\u0002J\b\u0010J\u001a\u000200H\u0002J\u0006\u0010K\u001a\u00020\u0019J\u0018\u0010L\u001a\u0002002\u0006\u0010M\u001a\u00020\t2\u0006\u0010N\u001a\u00020\tH\u0014J\u0018\u0010O\u001a\u0002002\u0006\u0010P\u001a\u00020Q2\u0006\u0010-\u001a\u000202H\u0016J\u0006\u0010R\u001a\u000200J\u000e\u0010S\u001a\u0002002\u0006\u0010T\u001a\u00020\tJ\u0010\u0010U\u001a\u0002002\u0006\u0010V\u001a\u00020\u0019H\u0002J\u0010\u0010W\u001a\u0002002\u0006\u0010-\u001a\u000202H\u0014J\u0010\u0010X\u001a\u0002002\u0006\u0010Y\u001a\u00020\tH\u0002J\u0018\u0010Z\u001a\u0002002\u0006\u0010-\u001a\u0002022\u0006\u0010[\u001a\u00020\u0019H\u0014J\u0010\u0010\\\u001a\u0002002\u0006\u0010-\u001a\u00020.H\u0014J\u0010\u0010]\u001a\u0002002\u0006\u0010^\u001a\u00020.H\u0014J\u0006\u0010_\u001a\u000200J\u000e\u0010`\u001a\u0002002\u0006\u0010a\u001a\u00020 J+\u0010b\u001a\u0002002\b\u0010>\u001a\u0004\u0018\u00010\t2\b\u0010c\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010d\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010eJ\u0010\u0010f\u001a\u0002002\b\u0010\u001f\u001a\u0004\u0018\u00010&J'\u0010g\u001a\u0002002\u0006\u0010>\u001a\u00020\t2\u0006\u0010h\u001a\u00020\t2\b\u0010d\u001a\u0004\u0018\u00010\tH\u0002\u00a2\u0006\u0002\u0010iJ\b\u0010j\u001a\u000200H\u0002J \u0010k\u001a\u0002002\u0006\u0010Y\u001a\u00020\t2\u0006\u0010-\u001a\u00020.2\u0006\u0010l\u001a\u00020\u0019H\u0016J\u0018\u0010m\u001a\u0002002\u0006\u0010Y\u001a\u00020\t2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010n\u001a\u0002002\u0006\u0010-\u001a\u00020.H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R0\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00190\u0018j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0019`\u001aX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u00020\"8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010$R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u00020(8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010*\u00a8\u0006q"}, d2 = {"Lcom/tencent/state/status/SquareOnlineStatusViewPanel;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/state/view/StatusPanelTitleListView$ClickListener;", "Lcom/tencent/state/status/SquareOnlineStatusGridAdapter$OnlineStatusClickListener;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareCommonItemPanelBinding;", "clickUtils", "Lcom/tencent/state/utils/FastClickUtils;", "curActionId", "Ljava/lang/Integer;", "curPageIndex", "curRichStatus", "curSelectStatusId", "curStatusId", "gridAdapter", "Lcom/tencent/state/status/SquareOnlineStatusPageAdapter;", "hasExposure", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getHasExposure", "()Ljava/util/HashMap;", "initPageIndex", "initStatusId", "listener", "Lcom/tencent/state/status/SquareOnlineStatusViewPanel$PanelItemClickListener;", "mmkv", "Lcom/tencent/state/square/mmkv/IMMKV;", "getMmkv", "()Lcom/tencent/state/square/mmkv/IMMKV;", "panelListener", "Lcom/tencent/state/status/ISquareOnlineStatusPanelListener;", "reporter", "Lcom/tencent/state/square/IReporter;", "getReporter", "()Lcom/tencent/state/square/IReporter;", "activityText", "", "data", "Lcom/tencent/state/view/TitleData;", "bindElement", "", "changeMotionLookBar", "Lcom/tencent/state/status/StatusPanelData;", "checkIsShowTitleRedPoint", "newStatus", "oldStatus", "commonReportData", "", "", "fetchAvatarMotion", "fillList", "mapData", "", "", DetailMeFragmentConfig.CURRENT_STATUS_ID, "panelTip", "(Ljava/util/Map;Ljava/lang/Integer;Ljava/util/List;)V", "getCurPageData", "getCurSelectedStatusId", "getHeightOutScreen", "getPageIndex", "map", "(Ljava/util/Map;Ljava/lang/Integer;)I", "getTitleData", "hidePanelWithAnima", "initClick", "initView", "isMotionLockBarShow", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onStatusChangeListener", "view", "Landroid/view/View;", "openPanelWithAnima", "panelLoadFailVisible", NodeProps.VISIBLE, "reportImpMotionData", "show", "reportPanelImp", "reportPanelImpAfterTitleClick", "index", "reportPanelItemClick", "hasRecorded", "reportTitleClick", "reportTitleImp", "titleData", "resetPanelView", "setClickListener", "clickListener", "setMotionSelect", "richStatus", "actionId", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "setPanelListener", "setSelect", DetailMeFragmentConfig.CURRENT_RICH_ID, "(IILjava/lang/Integer;)V", "setSelectItemIfNeed", "titleClick", "isFromClick", "updateActivityPanel", "updateHotPointSp", "Companion", "PanelItemClickListener", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public class SquareOnlineStatusViewPanel extends RelativeLayout implements StatusPanelTitleListView.ClickListener, SquareOnlineStatusGridAdapter.OnlineStatusClickListener {
    private static final int CACHE_PAGE = 2;
    private static final long DETAIL_TIMES = 300;
    private final VasSquareCommonItemPanelBinding binding;
    private final FastClickUtils clickUtils;
    private Integer curActionId;
    private int curPageIndex;
    private Integer curRichStatus;
    private int curSelectStatusId;
    private Integer curStatusId;
    private SquareOnlineStatusPageAdapter gridAdapter;
    private final HashMap<Integer, Boolean> hasExposure;
    private int initPageIndex;
    private int initStatusId;
    private PanelItemClickListener listener;
    private ISquareOnlineStatusPanelListener panelListener;

    public SquareOnlineStatusViewPanel(Context context) {
        this(context, null, 0, 6, null);
    }

    private final String activityText(TitleData data) {
        return data.getActivityData().getTip();
    }

    private final void bindElement() {
        getReporter().setElementInfo(this.binding.motionLockBar.getUnLockView(), SquareReportConst.ElementId.ELEMENT_ID_ENTER_MAP, new LinkedHashMap(), false, false);
        IReporter reporter = getReporter();
        SquareAvatarMotionLockBar squareAvatarMotionLockBar = this.binding.motionLockBar;
        Intrinsics.checkNotNullExpressionValue(squareAvatarMotionLockBar, "binding.motionLockBar");
        reporter.setElementInfo(squareAvatarMotionLockBar, SquareReportConst.ElementId.ELEMENT_ID_UNLOCK_STATE_FLOATS, new LinkedHashMap(), false, false);
    }

    private final void changeMotionLookBar(StatusPanelData data) {
        boolean isBlank;
        CardView cardView = this.binding.activityPanel;
        Intrinsics.checkNotNullExpressionValue(cardView, "binding.activityPanel");
        cardView.setVisibility(8);
        if (data.getTaskInfo().getPrizeStatus() != PanelStatusTaskPrizeStatus.PRIZE_PENDING) {
            return;
        }
        VasSquareCommonItemPanelBinding vasSquareCommonItemPanelBinding = this.binding;
        StatusPanelTitleListView statusPanelTitleListView = vasSquareCommonItemPanelBinding.titleView;
        ViewPager viewPager = vasSquareCommonItemPanelBinding.onlineStatusViewpager;
        Intrinsics.checkNotNullExpressionValue(viewPager, "binding.onlineStatusViewpager");
        isBlank = StringsKt__StringsJVMKt.isBlank(statusPanelTitleListView.getIndexData(viewPager.getCurrentItem()).getActivityData().getTip());
        if (!isBlank) {
            reportImpMotionData(false);
            return;
        }
        this.binding.motionLockBar.fillBanner(data.getTaskInfo());
        CardView cardView2 = this.binding.activityPanel;
        Intrinsics.checkNotNullExpressionValue(cardView2, "binding.activityPanel");
        cardView2.setVisibility(0);
        PanelItemClickListener panelItemClickListener = this.listener;
        if (panelItemClickListener != null) {
            panelItemClickListener.onPublicButtonStatus(false);
        }
        reportImpMotionData(true);
        fetchAvatarMotion();
    }

    private final boolean checkIsShowTitleRedPoint(String newStatus, String oldStatus) {
        if (newStatus.length() == 0) {
            return false;
        }
        return (oldStatus.length() == 0) || (Intrinsics.areEqual(newStatus, oldStatus) ^ true);
    }

    private final void fetchAvatarMotion() {
        this.binding.motionLockBar.setMotionListener(new IMotionLockListener() { // from class: com.tencent.state.status.SquareOnlineStatusViewPanel$fetchAvatarMotion$1
            @Override // com.tencent.state.square.location.IMotionLockListener
            public void onFetchAvatarMotion(PanelStatusTaskInfo taskInfo) {
                SquareOnlineStatusPageAdapter squareOnlineStatusPageAdapter;
                VasSquareCommonItemPanelBinding vasSquareCommonItemPanelBinding;
                SquareOnlineStatusViewPanel.PanelItemClickListener panelItemClickListener;
                SquareOnlineStatusViewPanel.PanelItemClickListener panelItemClickListener2;
                VasSquareCommonItemPanelBinding vasSquareCommonItemPanelBinding2;
                int i3;
                Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
                squareOnlineStatusPageAdapter = SquareOnlineStatusViewPanel.this.gridAdapter;
                if (squareOnlineStatusPageAdapter != null) {
                    i3 = SquareOnlineStatusViewPanel.this.curSelectStatusId;
                    squareOnlineStatusPageAdapter.updateLockIcon(i3);
                }
                vasSquareCommonItemPanelBinding = SquareOnlineStatusViewPanel.this.binding;
                CardView cardView = vasSquareCommonItemPanelBinding.activityPanel;
                Intrinsics.checkNotNullExpressionValue(cardView, "binding.activityPanel");
                cardView.setVisibility(8);
                panelItemClickListener = SquareOnlineStatusViewPanel.this.listener;
                if (panelItemClickListener != null) {
                    panelItemClickListener.onPublicButtonStatus(true);
                }
                panelItemClickListener2 = SquareOnlineStatusViewPanel.this.listener;
                if (panelItemClickListener2 != null) {
                    panelItemClickListener2.onFragmentShowToast(taskInfo.getBannerInfo().getSucTitle());
                }
                IReporter reporter = SquareOnlineStatusViewPanel.this.getReporter();
                vasSquareCommonItemPanelBinding2 = SquareOnlineStatusViewPanel.this.binding;
                SquareAvatarMotionLockBar squareAvatarMotionLockBar = vasSquareCommonItemPanelBinding2.motionLockBar;
                Intrinsics.checkNotNullExpressionValue(squareAvatarMotionLockBar, "binding.motionLockBar");
                reporter.reportEvent("clck", squareAvatarMotionLockBar, new LinkedHashMap());
            }
        });
    }

    private final void initClick() {
        this.binding.panelLoadFail.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.status.SquareOnlineStatusViewPanel$initClick$1
            /* JADX WARN: Code restructure failed: missing block: B:5:0x000d, code lost:
            
                r1 = r0.this$0.listener;
             */
            @Override // android.view.View.OnClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void onClick(View view) {
                FastClickUtils fastClickUtils;
                SquareOnlineStatusViewPanel.PanelItemClickListener panelItemClickListener;
                fastClickUtils = SquareOnlineStatusViewPanel.this.clickUtils;
                if (fastClickUtils.isFastDoubleClick() || panelItemClickListener == null) {
                    return;
                }
                panelItemClickListener.onLoadClick();
            }
        });
    }

    private final void reportPanelImpAfterTitleClick(int index) {
        SquareOnlineStatusPageAdapter squareOnlineStatusPageAdapter;
        List<StatusPanelData> positionData;
        if (!Intrinsics.areEqual(this.hasExposure.get(Integer.valueOf(index)), Boolean.FALSE) || (squareOnlineStatusPageAdapter = this.gridAdapter) == null || (positionData = squareOnlineStatusPageAdapter.getPositionData(index)) == null) {
            return;
        }
        Iterator<T> it = positionData.iterator();
        while (it.hasNext()) {
            reportPanelImp((StatusPanelData) it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setSelect(final int statusId, final int richStatusId, Integer actionId) {
        final StatusPanelData statusPanelData;
        SquareOnlineStatusPageAdapter squareOnlineStatusPageAdapter = this.gridAdapter;
        if (squareOnlineStatusPageAdapter == null || (statusPanelData = squareOnlineStatusPageAdapter.getStatusPanelData(statusId, richStatusId)) == null) {
            return;
        }
        statusPanelData.setSelectActionId(actionId);
        int pageIndex = statusPanelData.getPageIndex();
        ViewPager viewPager = this.binding.onlineStatusViewpager;
        Intrinsics.checkNotNullExpressionValue(viewPager, "binding.onlineStatusViewpager");
        if (pageIndex != viewPager.getCurrentItem()) {
            titleClick(pageIndex, this.binding.titleView.getIndexData(pageIndex), true);
        }
        if (statusPanelData.getStatus().getId() == this.curSelectStatusId) {
            int actionId2 = statusPanelData.getReportData().getActionId();
            if (actionId != null && actionId2 == actionId.intValue()) {
                return;
            }
        }
        SquareBaseKt.getSquareThread().postOnUiDelayed(500L, new Function0<Unit>() { // from class: com.tencent.state.status.SquareOnlineStatusViewPanel$setSelect$1
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
                SquareOnlineStatusPageAdapter squareOnlineStatusPageAdapter2;
                squareOnlineStatusPageAdapter2 = SquareOnlineStatusViewPanel.this.gridAdapter;
                if (squareOnlineStatusPageAdapter2 != null) {
                    squareOnlineStatusPageAdapter2.scrollSelect(statusId, richStatusId, new Function0<Unit>() { // from class: com.tencent.state.status.SquareOnlineStatusViewPanel$setSelect$1.1
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
                            SquareOnlineStatusPageAdapter squareOnlineStatusPageAdapter3;
                            squareOnlineStatusPageAdapter3 = SquareOnlineStatusViewPanel.this.gridAdapter;
                            if (squareOnlineStatusPageAdapter3 != null) {
                                SquareOnlineStatusViewPanel$setSelect$1 squareOnlineStatusViewPanel$setSelect$1 = SquareOnlineStatusViewPanel$setSelect$1.this;
                                View statusView = squareOnlineStatusPageAdapter3.getStatusView(statusId, richStatusId);
                                if (statusView != null) {
                                    SquareOnlineStatusViewPanel$setSelect$1 squareOnlineStatusViewPanel$setSelect$12 = SquareOnlineStatusViewPanel$setSelect$1.this;
                                    SquareOnlineStatusViewPanel.this.onStatusChangeListener(statusView, statusPanelData);
                                }
                            }
                        }
                    });
                }
            }
        });
    }

    private final void setSelectItemIfNeed() {
        Integer num = this.curStatusId;
        if (num != null) {
            final int intValue = num.intValue();
            Integer num2 = this.curRichStatus;
            if (num2 != null) {
                final int intValue2 = num2.intValue();
                final Integer num3 = this.curActionId;
                SquareBaseKt.getSquareThread().postOnUiDelayed(600L, new Function0<Unit>() { // from class: com.tencent.state.status.SquareOnlineStatusViewPanel$setSelectItemIfNeed$$inlined$let$lambda$1
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
                        this.setSelect(intValue, intValue2, num3);
                    }
                });
                this.curStatusId = null;
                this.curRichStatus = null;
                this.curActionId = null;
            }
        }
    }

    private final void updateActivityPanel(int index, TitleData data) {
        boolean isBlank;
        SquareOnlineStatusPageAdapter squareOnlineStatusPageAdapter;
        List<StatusPanelData> positionData;
        CardView cardView = this.binding.activityPanel;
        Intrinsics.checkNotNullExpressionValue(cardView, "binding.activityPanel");
        cardView.setVisibility(8);
        LinearLayout linearLayout = this.binding.activityTimeContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.activityTimeContainer");
        linearLayout.setVisibility(8);
        isBlank = StringsKt__StringsJVMKt.isBlank(data.getActivityData().getTip());
        if (!isBlank) {
            return;
        }
        LinearLayout linearLayout2 = this.binding.activityTimeContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.activityTimeContainer");
        linearLayout2.setVisibility(0);
        TextView textView = this.binding.activityTime;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.activityTime");
        textView.setText(activityText(data));
        this.binding.activityTime.requestLayout();
        if (!Intrinsics.areEqual(this.hasExposure.get(Integer.valueOf(index)), Boolean.TRUE) || (squareOnlineStatusPageAdapter = this.gridAdapter) == null || (positionData = squareOnlineStatusPageAdapter.getPositionData(index)) == null) {
            return;
        }
        for (StatusPanelData statusPanelData : positionData) {
            if (statusPanelData.isSelect() && statusPanelData.getTaskInfo().getPrizeStatus() == PanelStatusTaskPrizeStatus.PRIZE_PENDING) {
                CardView cardView2 = this.binding.activityPanel;
                Intrinsics.checkNotNullExpressionValue(cardView2, "binding.activityPanel");
                cardView2.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateHotPointSp(TitleData data) {
        String str;
        String id5 = data.getId();
        if (data.getHasRed()) {
            str = data.getStatusIdList();
        } else {
            str = "";
        }
        String str2 = str;
        if (str2.length() == 0) {
            return;
        }
        IMMKV.DefaultImpls.encodeString$default(getMmkv(), SKey.DetailMe.KEY_TITLE_RED_POINT_SP, str2, id5, false, 8, null);
    }

    public final void fillList(Map<Integer, ? extends List<StatusPanelData>> mapData, Integer statusId, List<String> panelTip) {
        Intrinsics.checkNotNullParameter(mapData, "mapData");
        Intrinsics.checkNotNullParameter(panelTip, "panelTip");
        int i3 = 0;
        int intValue = statusId != null ? statusId.intValue() : 0;
        this.initStatusId = intValue;
        this.curSelectStatusId = intValue;
        Iterator<Map.Entry<Integer, ? extends List<StatusPanelData>>> it = mapData.entrySet().iterator();
        while (it.hasNext()) {
            this.hasExposure.put(it.next().getKey(), Boolean.FALSE);
        }
        int pageIndex = getPageIndex(mapData, statusId);
        this.initPageIndex = pageIndex;
        this.curPageIndex = pageIndex;
        SquareOnlineStatusPageAdapter squareOnlineStatusPageAdapter = this.gridAdapter;
        if (squareOnlineStatusPageAdapter != null) {
            squareOnlineStatusPageAdapter.fillListData(mapData, this);
            List<TitleData> titleData = getTitleData(mapData);
            if (titleData.size() == panelTip.size()) {
                for (Object obj : panelTip) {
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    titleData.get(i3).getActivityData().setTip((String) obj);
                    i3 = i16;
                }
            }
            this.binding.titleView.setData(titleData, this);
            Iterator<T> it5 = titleData.iterator();
            while (it5.hasNext()) {
                reportTitleImp((TitleData) it5.next());
            }
        }
        ViewPager viewPager = this.binding.onlineStatusViewpager;
        Intrinsics.checkNotNullExpressionValue(viewPager, "binding.onlineStatusViewpager");
        viewPager.setCurrentItem(this.initPageIndex);
    }

    public final List<StatusPanelData> getCurPageData() {
        SquareOnlineStatusPageAdapter squareOnlineStatusPageAdapter = this.gridAdapter;
        if (squareOnlineStatusPageAdapter != null) {
            return squareOnlineStatusPageAdapter.getPositionData(this.curPageIndex);
        }
        return null;
    }

    /* renamed from: getCurSelectedStatusId, reason: from getter */
    public final int getCurSelectStatusId() {
        return this.curSelectStatusId;
    }

    protected final HashMap<Integer, Boolean> getHasExposure() {
        return this.hasExposure;
    }

    public int getHeightOutScreen() {
        return DetailAvatarConfig.INSTANCE.getHeightOutScreen();
    }

    public IMMKV getMmkv() {
        return SquareBaseKt.getSquareMMKV();
    }

    public IReporter getReporter() {
        return Square.INSTANCE.getConfig().getReporter();
    }

    public final void hidePanelWithAnima() {
        Animation anima = AnimationUtils.loadAnimation(getContext(), R.anim.f154356jd);
        Intrinsics.checkNotNullExpressionValue(anima, "anima");
        anima.setDuration(300L);
        startAnimation(anima);
        SquareOnlineStatusPageAdapter squareOnlineStatusPageAdapter = this.gridAdapter;
        if (squareOnlineStatusPageAdapter != null) {
            squareOnlineStatusPageAdapter.updateSelected(this.curSelectStatusId);
        }
        ViewPager viewPager = this.binding.onlineStatusViewpager;
        Intrinsics.checkNotNullExpressionValue(viewPager, "binding.onlineStatusViewpager");
        viewPager.setCurrentItem(this.initPageIndex);
        SquareOnlineStatusPageAdapter squareOnlineStatusPageAdapter2 = this.gridAdapter;
        if (squareOnlineStatusPageAdapter2 != null) {
            squareOnlineStatusPageAdapter2.setDefaultSelectView(this.curSelectStatusId, this.initStatusId);
        }
        int i3 = this.initStatusId;
        this.curSelectStatusId = i3;
        PanelItemClickListener panelItemClickListener = this.listener;
        if (panelItemClickListener != null) {
            panelItemClickListener.onResetStatus(i3, this.curStatusId);
        }
    }

    public final boolean isMotionLockBarShow() {
        CardView cardView = this.binding.activityPanel;
        Intrinsics.checkNotNullExpressionValue(cardView, "binding.activityPanel");
        return cardView.getVisibility() == 0;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec - getHeightOutScreen());
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0049, code lost:
    
        if (r0 != r3.intValue()) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a1  */
    @Override // com.tencent.state.status.SquareOnlineStatusGridAdapter.OnlineStatusClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onStatusChangeListener(View view, final StatusPanelData data) {
        boolean z16;
        boolean z17;
        SquareOnlineStatusPageAdapter squareOnlineStatusPageAdapter;
        SquareOnlineStatusPageAdapter squareOnlineStatusPageAdapter2;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        if (this.clickUtils.isFastDoubleClick()) {
            return;
        }
        PanelItemClickListener panelItemClickListener = this.listener;
        if (panelItemClickListener != null) {
            panelItemClickListener.onStatusSelected(data.getStatus().getId(), data.getSelectActionId());
        }
        if (data.getSelectActionId() != null) {
            if (data.getSelectActionId() != null) {
                int actionId = data.getReportData().getActionId();
                Integer selectActionId = data.getSelectActionId();
                if (selectActionId != null) {
                }
            }
            z16 = false;
            z17 = data.getStatus().getId() != this.curSelectStatusId && z16;
            if (!view.isSelected() && z17) {
                changeMotionLookBar(data);
                return;
            }
            if (!z17) {
                boolean z18 = data.getTaskInfo().getPrizeStatus() == PanelStatusTaskPrizeStatus.PRIZE_PENDING;
                PanelItemClickListener panelItemClickListener2 = this.listener;
                if (panelItemClickListener2 != null) {
                    panelItemClickListener2.onStatusClick(data.getStatus(), z18, new Function1<Boolean, Unit>() { // from class: com.tencent.state.status.SquareOnlineStatusViewPanel$onStatusChangeListener$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z19) {
                            SquareOnlineStatusViewPanel.this.reportPanelItemClick(data, z19);
                        }
                    });
                }
            }
            view.setSelected(true);
            squareOnlineStatusPageAdapter = this.gridAdapter;
            if (squareOnlineStatusPageAdapter != null) {
                squareOnlineStatusPageAdapter.updateSelected(data.getStatus().getId());
            }
            squareOnlineStatusPageAdapter2 = this.gridAdapter;
            if (squareOnlineStatusPageAdapter2 != null) {
                SquareOnlineStatusPageAdapter.updateSelectView$default(squareOnlineStatusPageAdapter2, this.curSelectStatusId, data.getStatus().getId(), false, 4, null);
            }
            this.curSelectStatusId = data.getStatus().getId();
            changeMotionLookBar(data);
            setSelectItemIfNeed();
        }
        z16 = true;
        if (data.getStatus().getId() != this.curSelectStatusId) {
        }
        if (!view.isSelected()) {
        }
        if (!z17) {
        }
        view.setSelected(true);
        squareOnlineStatusPageAdapter = this.gridAdapter;
        if (squareOnlineStatusPageAdapter != null) {
        }
        squareOnlineStatusPageAdapter2 = this.gridAdapter;
        if (squareOnlineStatusPageAdapter2 != null) {
        }
        this.curSelectStatusId = data.getStatus().getId();
        changeMotionLookBar(data);
        setSelectItemIfNeed();
    }

    public final void openPanelWithAnima() {
        Animation anima = AnimationUtils.loadAnimation(getContext(), R.anim.f154357je);
        Intrinsics.checkNotNullExpressionValue(anima, "anima");
        anima.setDuration(300L);
        startAnimation(anima);
        PanelItemClickListener panelItemClickListener = this.listener;
        if (panelItemClickListener != null) {
            panelItemClickListener.onStatusSelected(this.curSelectStatusId, this.curActionId);
        }
    }

    public final void panelLoadFailVisible(int visible) {
        LinearLayout linearLayout = this.binding.panelLoadFail;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.panelLoadFail");
        linearLayout.setVisibility(visible);
    }

    protected void reportPanelImp(StatusPanelData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        IReporter reporter = getReporter();
        Map<String, Object> commonReportData = commonReportData(data);
        commonReportData.put("zplan_action_type", "imp");
        commonReportData.put(SquareReportConst.Key.KEY_NEED_LOADING, Integer.valueOf(!data.getReportData().getHasRecorded() ? 1 : 0));
        commonReportData.put(SquareReportConst.Key.KEY_ZPLAN_STATE_IS_LOCK, Integer.valueOf(data.getTaskInfo().getPrizeStatus() != PanelStatusTaskPrizeStatus.PRIZE_PENDING ? 0 : 1));
        Unit unit = Unit.INSTANCE;
        reporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_STATE_ICON, commonReportData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportPanelItemClick(StatusPanelData data, boolean hasRecorded) {
        Long longOrNull;
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(data, "data");
        IReporter reporter = getReporter();
        Map<String, Object> commonReportData = commonReportData(data);
        commonReportData.put("zplan_action_type", "click");
        commonReportData.put(SquareReportConst.Key.KEY_NEED_LOADING, Integer.valueOf(!hasRecorded ? 1 : 0));
        PanelStatusTaskPrizeStatus prizeStatus = data.getTaskInfo().getPrizeStatus();
        PanelStatusTaskPrizeStatus panelStatusTaskPrizeStatus = PanelStatusTaskPrizeStatus.PRIZE_PENDING;
        commonReportData.put(SquareReportConst.Key.KEY_ZPLAN_STATE_IS_LOCK, Integer.valueOf(prizeStatus == panelStatusTaskPrizeStatus ? 1 : 0));
        Unit unit = Unit.INSTANCE;
        reporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_STATE_ICON, commonReportData);
        IReporter reporter2 = getReporter();
        Pair[] pairArr = new Pair[5];
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(Square.INSTANCE.getConfig().getCommonUtils().getCurrentAccountUin());
        pairArr[0] = TuplesKt.to("uin", Long.valueOf(longOrNull != null ? longOrNull.longValue() : 0L));
        pairArr[1] = TuplesKt.to(SquareReportConst.Param.EN_MOTION_ID, Integer.valueOf(data.getReportData().getActionId()));
        pairArr[2] = TuplesKt.to(SquareReportConst.Param.EM_STATIC_SRC, Integer.valueOf(data.getReportData().getStaticSrc()));
        pairArr[3] = TuplesKt.to(SquareReportConst.Param.EM_DYNAMIC_SRC, Integer.valueOf(data.getReportData().getDynamicSrc()));
        pairArr[4] = TuplesKt.to("zplan_action_type", Integer.valueOf(data.getTaskInfo().getPrizeStatus() != panelStatusTaskPrizeStatus ? 0 : 1));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        reporter2.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_STATUS_PANEL_MOTION_SRC, mutableMapOf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportTitleClick(TitleData data) {
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(data, "data");
        IReporter reporter = getReporter();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", "click"), TuplesKt.to("zplan_choose_tab_id", data.getId()), TuplesKt.to("zplan_is_redpoint", Integer.valueOf(data.getHasRed() ? 1 : 0)));
        reporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_STATE_TITLE, mutableMapOf);
    }

    protected void reportTitleImp(TitleData titleData) {
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(titleData, "titleData");
        IReporter reporter = getReporter();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", "imp"), TuplesKt.to("zplan_choose_tab_id", titleData.getId()), TuplesKt.to("zplan_is_redpoint", Integer.valueOf(titleData.getHasRed() ? 1 : 0)));
        reporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_STATE_TITLE, mutableMapOf);
    }

    public final void resetPanelView() {
        initView();
    }

    public final void setClickListener(PanelItemClickListener clickListener) {
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.listener = clickListener;
    }

    public final void setMotionSelect(Integer statusId, Integer richStatus, Integer actionId) {
        this.curStatusId = statusId;
        this.curRichStatus = richStatus;
        this.curActionId = actionId;
    }

    public final void setPanelListener(ISquareOnlineStatusPanelListener listener) {
        this.panelListener = listener;
    }

    @Override // com.tencent.state.view.StatusPanelTitleListView.ClickListener
    public void titleClick(int index, TitleData data, boolean isFromClick) {
        Intrinsics.checkNotNullParameter(data, "data");
        reportPanelImpAfterTitleClick(index);
        this.hasExposure.put(Integer.valueOf(index), Boolean.TRUE);
        if (isFromClick) {
            ViewPager viewPager = this.binding.onlineStatusViewpager;
            Intrinsics.checkNotNullExpressionValue(viewPager, "binding.onlineStatusViewpager");
            viewPager.setCurrentItem(index);
        }
        updateActivityPanel(index, data);
    }

    public SquareOnlineStatusViewPanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    private final Map<String, Object> commonReportData(StatusPanelData data) {
        Map<String, Object> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_SELECT_STATE_ID, Integer.valueOf(data.getStatus().getTopStatusId())), TuplesKt.to(SquareReportConst.Key.KEY_SELECT_RICH_STATE_ID, Integer.valueOf(data.getStatus().getRichStatus())), TuplesKt.to(SquareReportConst.Key.KEY_IS_NEW_HOT, data.getReportData().getCornerName()), TuplesKt.to(SquareReportConst.Key.KEY_IS_SINGLE_ACTION, Integer.valueOf(!data.getReportData().isMultiAction() ? 1 : 0)));
        return mutableMapOf;
    }

    private final void initView() {
        setClickable(true);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.gridAdapter = new SquareOnlineStatusPageAdapter(context, null, 2, 0 == true ? 1 : 0);
        ViewPager it = this.binding.onlineStatusViewpager;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        ViewGroup.LayoutParams layoutParams = it.getLayoutParams();
        layoutParams.height -= getHeightOutScreen();
        it.setLayoutParams(layoutParams);
        it.setAdapter(this.gridAdapter);
        it.setOffscreenPageLimit(2);
        it.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.tencent.state.status.SquareOnlineStatusViewPanel$initView$$inlined$let$lambda$1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int position) {
                VasSquareCommonItemPanelBinding vasSquareCommonItemPanelBinding;
                VasSquareCommonItemPanelBinding vasSquareCommonItemPanelBinding2;
                int i3;
                ISquareOnlineStatusPanelListener iSquareOnlineStatusPanelListener;
                int i16;
                vasSquareCommonItemPanelBinding = SquareOnlineStatusViewPanel.this.binding;
                TitleData indexData = vasSquareCommonItemPanelBinding.titleView.getIndexData(position);
                SquareOnlineStatusViewPanel.this.reportTitleClick(indexData);
                SquareOnlineStatusViewPanel.this.updateHotPointSp(indexData);
                vasSquareCommonItemPanelBinding2 = SquareOnlineStatusViewPanel.this.binding;
                StatusPanelTitleListView statusPanelTitleListView = vasSquareCommonItemPanelBinding2.titleView;
                i3 = SquareOnlineStatusViewPanel.this.curPageIndex;
                statusPanelTitleListView.updateTitleStyle(i3, position);
                SquareOnlineStatusViewPanel.this.curPageIndex = position;
                iSquareOnlineStatusPanelListener = SquareOnlineStatusViewPanel.this.panelListener;
                if (iSquareOnlineStatusPanelListener != null) {
                    i16 = SquareOnlineStatusViewPanel.this.curPageIndex;
                    iSquareOnlineStatusPanelListener.onStatusPanelPageSelected(i16);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int state) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
        });
    }

    public /* synthetic */ SquareOnlineStatusViewPanel(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    private final List<TitleData> getTitleData(Map<Integer, ? extends List<StatusPanelData>> data) {
        List sortedWith;
        int collectionSizeOrDefault;
        Object firstOrNull;
        String obj;
        Object firstOrNull2;
        String str;
        Object firstOrNull3;
        String titleName;
        String titleId;
        ArrayList arrayList = new ArrayList(data.size());
        for (Map.Entry<Integer, ? extends List<StatusPanelData>> entry : data.entrySet()) {
            List<StatusPanelData> value = entry.getValue();
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = value.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((StatusPanelData) next).getCornerUrl().length() > 0) {
                    arrayList2.add(next);
                }
            }
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList2, new Comparator<T>() { // from class: com.tencent.state.status.SquareOnlineStatusViewPanel$$special$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t16, T t17) {
                    int compareValues;
                    compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((StatusPanelData) t16).getStatus().getId()), Integer.valueOf(((StatusPanelData) t17).getStatus().getId()));
                    return compareValues;
                }
            });
            List list = sortedWith;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
            Iterator it5 = list.iterator();
            while (it5.hasNext()) {
                arrayList3.add(Integer.valueOf(((StatusPanelData) it5.next()).getStatus().getId()));
            }
            IMMKV mmkv = getMmkv();
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) entry.getValue());
            StatusPanelData statusPanelData = (StatusPanelData) firstOrNull;
            String decodeString$default = IMMKV.DefaultImpls.decodeString$default(mmkv, SKey.DetailMe.KEY_TITLE_RED_POINT_SP, "", (statusPanelData == null || (titleId = statusPanelData.getTitleId()) == null) ? "" : titleId, false, 8, null);
            if (arrayList3.isEmpty()) {
                obj = "";
            } else {
                obj = arrayList3.toString();
            }
            firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) entry.getValue());
            StatusPanelData statusPanelData2 = (StatusPanelData) firstOrNull2;
            if (statusPanelData2 == null || (str = statusPanelData2.getTitleId()) == null) {
                str = "0";
            }
            String str2 = str;
            firstOrNull3 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) entry.getValue());
            StatusPanelData statusPanelData3 = (StatusPanelData) firstOrNull3;
            arrayList.add(new TitleData(str2, (statusPanelData3 == null || (titleName = statusPanelData3.getTitleName()) == null) ? "" : titleName, checkIsShowTitleRedPoint(obj, decodeString$default), obj, this.initPageIndex == entry.getKey().intValue(), null, 32, null));
        }
        return arrayList;
    }

    private final void reportImpMotionData(boolean show) {
        String str;
        if (show) {
            str = "imp";
        } else {
            str = "imp_end";
        }
        IReporter reporter = getReporter();
        SquareAvatarMotionLockBar squareAvatarMotionLockBar = this.binding.motionLockBar;
        Intrinsics.checkNotNullExpressionValue(squareAvatarMotionLockBar, "binding.motionLockBar");
        reporter.reportEvent(str, squareAvatarMotionLockBar, new LinkedHashMap());
        getReporter().reportEvent(str, this.binding.motionLockBar.getUnLockView(), new LinkedHashMap());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareOnlineStatusViewPanel(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        VasSquareCommonItemPanelBinding inflate = VasSquareCommonItemPanelBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareCommonItemPanel\u2026ater.from(context), this)");
        this.binding = inflate;
        this.curSelectStatusId = -1;
        this.clickUtils = new FastClickUtils(800L);
        this.hasExposure = new HashMap<>();
        initView();
        initClick();
        bindElement();
    }

    private final int getPageIndex(Map<Integer, ? extends List<StatusPanelData>> map, Integer statusId) {
        Object obj;
        if (statusId == null) {
            return 0;
        }
        Iterator<T> it = map.values().iterator();
        while (it.hasNext()) {
            Iterator it5 = ((List) it.next()).iterator();
            while (true) {
                if (!it5.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it5.next();
                if (((StatusPanelData) obj).getStatus().getId() == statusId.intValue()) {
                    break;
                }
            }
            StatusPanelData statusPanelData = (StatusPanelData) obj;
            int pageIndex = statusPanelData != null ? statusPanelData.getPageIndex() : -1;
            if (pageIndex >= 0) {
                return pageIndex;
            }
        }
        return 0;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J!\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH&\u00a2\u0006\u0002\u0010\u000eJ,\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u0014H&J!\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH&\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/state/status/SquareOnlineStatusViewPanel$PanelItemClickListener;", "", "onFragmentShowToast", "", "tip", "", "onLoadClick", "onPublicButtonStatus", "enable", "", "onResetStatus", DetailMeFragmentConfig.CURRENT_STATUS_ID, "", "actionId", "(ILjava/lang/Integer;)V", "onStatusClick", "status", "Lcom/tencent/state/square/data/OnlineStatus;", "motionLock", "callback", "Lkotlin/Function1;", "onStatusSelected", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public interface PanelItemClickListener {
        void onFragmentShowToast(String tip);

        void onLoadClick();

        void onPublicButtonStatus(boolean enable);

        void onResetStatus(int statusId, Integer actionId);

        void onStatusClick(OnlineStatus status, boolean motionLock, Function1<? super Boolean, Unit> callback);

        void onStatusSelected(int statusId, Integer actionId);

        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
        /* loaded from: classes38.dex */
        public static final class DefaultImpls {
            public static /* synthetic */ void onResetStatus$default(PanelItemClickListener panelItemClickListener, int i3, Integer num, int i16, Object obj) {
                if (obj == null) {
                    if ((i16 & 2) != 0) {
                        num = null;
                    }
                    panelItemClickListener.onResetStatus(i3, num);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onResetStatus");
            }

            public static /* synthetic */ void onStatusSelected$default(PanelItemClickListener panelItemClickListener, int i3, Integer num, int i16, Object obj) {
                if (obj == null) {
                    if ((i16 & 2) != 0) {
                        num = null;
                    }
                    panelItemClickListener.onStatusSelected(i3, num);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onStatusSelected");
            }
        }
    }

    public static /* synthetic */ void setMotionSelect$default(SquareOnlineStatusViewPanel squareOnlineStatusViewPanel, Integer num, Integer num2, Integer num3, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                num3 = null;
            }
            squareOnlineStatusViewPanel.setMotionSelect(num, num2, num3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMotionSelect");
    }
}
