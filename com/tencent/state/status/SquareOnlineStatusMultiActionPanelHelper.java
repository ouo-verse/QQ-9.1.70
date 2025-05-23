package com.tencent.state.status;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.data.BaseResourceInfo;
import com.tencent.state.square.data.OnlineStatus;
import com.tencent.state.square.data.RecordResourceInfo;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.detail.DetailMeFragmentConfig;
import com.tencent.state.square.detail.DetailSelectMeView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 *2\u00020\u0001:\u0001*B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0006\u0010\u0014\u001a\u00020\u0015J\u0014\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017H\u0002J\u000e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0013J\u000e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u001eH\u0016J\b\u0010!\u001a\u00020\u0015H\u0002J\u0015\u0010\"\u001a\u00020\u00152\b\u0010#\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0002\u0010$J%\u0010%\u001a\u00020\u00152\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0002\u0010)R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/tencent/state/status/SquareOnlineStatusMultiActionPanelHelper;", "Lcom/tencent/state/status/ISquareOnlineStatusPanelListener;", "context", "Landroid/content/Context;", "detailContainer", "Lcom/tencent/state/square/detail/DetailSelectMeView;", "panelContainer", "Landroid/widget/FrameLayout;", "panelRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "(Landroid/content/Context;Lcom/tencent/state/square/detail/DetailSelectMeView;Landroid/widget/FrameLayout;Landroidx/recyclerview/widget/RecyclerView;)V", "adapter", "Lcom/tencent/state/status/SquareOnlineStatusMultiActionPanelAdapter;", "mask", "Landroid/view/View;", "kotlin.jvm.PlatformType", "reporter", "Lcom/tencent/state/square/IReporter;", "canShowPanel", "", "clearActionId", "", "getPanelReportParams", "", "", "", "hidePanel", "reset", "isChangeSelectedByUser", DetailMeFragmentConfig.CURRENT_STATUS_ID, "", "onStatusPanelPageSelected", "pageIndex", "resetStatus", "setActionId", "actionId", "(Ljava/lang/Integer;)V", "showPanel", "data", "", "Lcom/tencent/state/square/data/BaseResourceInfo;", "(Ljava/util/List;Ljava/lang/Integer;)V", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareOnlineStatusMultiActionPanelHelper implements ISquareOnlineStatusPanelListener {
    public static final int PICKER_ITEM_HEIGHT = 52;
    public static final int PICKER_ITEM_MARGIN = 2;
    public static final int PICKER_MORE_THAN_FOUR_HEIGHT = 220;
    public static final int PICKER_SELECTED_MARGIN_TOP_COMMON = 66;
    public static final int PICKER_SELECTED_MARGIN_TOP_TWO = 20;
    public static final int PICKER_THREE_HEIGHT = 184;
    public static final int PICKER_TWO_HEIGHT = 148;
    private static final String TAG = "MultiActionPanelHelper";
    private final SquareOnlineStatusMultiActionPanelAdapter adapter;
    private final Context context;
    private final DetailSelectMeView detailContainer;
    private final View mask;
    private final FrameLayout panelContainer;
    private final RecyclerView panelRecyclerView;
    private final IReporter reporter;

    public SquareOnlineStatusMultiActionPanelHelper(Context context, DetailSelectMeView detailContainer, FrameLayout panelContainer, RecyclerView panelRecyclerView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(detailContainer, "detailContainer");
        Intrinsics.checkNotNullParameter(panelContainer, "panelContainer");
        Intrinsics.checkNotNullParameter(panelRecyclerView, "panelRecyclerView");
        this.context = context;
        this.detailContainer = detailContainer;
        this.panelContainer = panelContainer;
        this.panelRecyclerView = panelRecyclerView;
        SquareOnlineStatusMultiActionPanelAdapter squareOnlineStatusMultiActionPanelAdapter = new SquareOnlineStatusMultiActionPanelAdapter(context, panelRecyclerView, new IReportDependency() { // from class: com.tencent.state.status.SquareOnlineStatusMultiActionPanelHelper$adapter$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.state.status.IReportDependency
            public <T> void fillReportParams(Map<String, Object> map, String key, T params) {
                DetailSelectMeView detailSelectMeView;
                Resource resource;
                Intrinsics.checkNotNullParameter(map, "map");
                Intrinsics.checkNotNullParameter(key, "key");
                if (key.hashCode() == -628700888 && key.equals(SquareReportConst.Key.KEY_ACTION_ID) && (params instanceof BaseResourceInfo)) {
                    detailSelectMeView = SquareOnlineStatusMultiActionPanelHelper.this.detailContainer;
                    RecordResourceInfo displayResource$default = BaseResourceInfo.getDisplayResource$default((BaseResourceInfo) params, detailSelectMeView.getCurrentSquareItem(), null, null, null, 14, null);
                    map.put(SquareReportConst.Key.KEY_ACTION_ID, Integer.valueOf((displayResource$default == null || (resource = displayResource$default.getResource()) == null) ? 0 : resource.getActionId()));
                }
            }

            @Override // com.tencent.state.status.IReportDependency
            public IReporter getIReporter() {
                return SquareOnlineStatusMultiActionPanelHelper.this.reporter;
            }
        }, null, 8, null);
        squareOnlineStatusMultiActionPanelAdapter.setChangedListener(new ISelectedChangedListener() { // from class: com.tencent.state.status.SquareOnlineStatusMultiActionPanelHelper$$special$$inlined$apply$lambda$1
            @Override // com.tencent.state.status.ISelectedChangedListener
            public void onSelectChanged(OnlineStatus status, BaseResourceInfo resourceInfo) {
                DetailSelectMeView detailSelectMeView;
                DetailSelectMeView detailSelectMeView2;
                Intrinsics.checkNotNullParameter(status, "status");
                detailSelectMeView = SquareOnlineStatusMultiActionPanelHelper.this.detailContainer;
                DetailSelectMeView.changeStatus$default(detailSelectMeView, status, false, 2, null);
                detailSelectMeView2 = SquareOnlineStatusMultiActionPanelHelper.this.detailContainer;
                detailSelectMeView2.updateLockStatus(resourceInfo != null ? resourceInfo.getLockInfo() : null);
            }
        });
        Unit unit = Unit.INSTANCE;
        this.adapter = squareOnlineStatusMultiActionPanelAdapter;
        this.reporter = Square.INSTANCE.getConfig().getReporter();
        this.mask = panelContainer.findViewById(R.id.q_w);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(1);
        panelRecyclerView.setLayoutManager(linearLayoutManager);
        panelRecyclerView.addItemDecoration(new SquareOnlineStatusMultiActionItemDivider());
        panelRecyclerView.setAdapter(squareOnlineStatusMultiActionPanelAdapter);
        panelRecyclerView.setOverScrollMode(2);
        panelContainer.setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, Color.parseColor("#99FFFFFF"), Color.parseColor("#99FFFFFF"), 0}));
        panelContainer.post(new Runnable() { // from class: com.tencent.state.status.SquareOnlineStatusMultiActionPanelHelper.2
            @Override // java.lang.Runnable
            public final void run() {
                IReporter iReporter = SquareOnlineStatusMultiActionPanelHelper.this.reporter;
                if (iReporter != null) {
                    iReporter.setElementInfo(SquareOnlineStatusMultiActionPanelHelper.this.panelContainer, SquareReportConst.ElementId.ELEMENT_ID_MULTI_ACTION_PANEL, new LinkedHashMap(), false, false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean canShowPanel() {
        return this.adapter.getNUM_BACKGOURND_ICON() >= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0008, code lost:
    
        r0 = kotlin.collections.MapsKt__MapsKt.mutableMapOf(kotlin.TuplesKt.to(com.tencent.state.report.SquareReportConst.Key.KEY_STATE_ID, java.lang.Integer.valueOf(r0.getId())), kotlin.TuplesKt.to(com.tencent.state.report.SquareReportConst.Key.KEY_RICH_STATE_ID, java.lang.Integer.valueOf(r0.getRichStatus())));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Map<String, Object> getPanelReportParams() {
        Map<String, Object> mutableMapOf;
        OnlineStatus onlineStatus = this.adapter.getOnlineStatus();
        return (onlineStatus == null || mutableMapOf == null) ? new LinkedHashMap() : mutableMapOf;
    }

    private final void resetStatus() {
        this.adapter.resetSelectedItemToPicked();
        this.adapter.clear();
    }

    public final void clearActionId() {
        this.adapter.clearActionId();
    }

    public final void hidePanel(boolean reset) {
        IReporter iReporter;
        if (this.panelContainer.getVisibility() == 0 && (iReporter = this.reporter) != null) {
            iReporter.reportEvent("imp_end", this.panelContainer, getPanelReportParams());
        }
        this.panelContainer.setVisibility(8);
        this.detailContainer.updateBlindBoxTips(false);
        if (reset) {
            resetStatus();
        }
    }

    public final boolean isChangeSelectedByUser(int statusId) {
        OnlineStatus onlineStatus = this.adapter.getOnlineStatus();
        if (onlineStatus == null || onlineStatus.getId() != statusId || this.adapter.getNUM_BACKGOURND_ICON() <= 1) {
            return false;
        }
        int curSelectedIndex = this.adapter.getCurSelectedIndex();
        return (curSelectedIndex == -1 || curSelectedIndex == this.adapter.getDefaultPickIndex()) ? false : true;
    }

    @Override // com.tencent.state.status.ISquareOnlineStatusPanelListener
    public void onStatusPanelPageSelected(int pageIndex) {
        SquareOnlineStatusViewPanel statusPanelView = this.detailContainer.getStatusPanelView();
        int curSelectStatusId = statusPanelView.getCurSelectStatusId();
        OnlineStatus onlineStatus = this.adapter.getOnlineStatus();
        if (onlineStatus == null || onlineStatus.getId() != curSelectStatusId) {
            return;
        }
        List<StatusPanelData> curPageData = statusPanelView.getCurPageData();
        if (curPageData != null) {
            Iterator<T> it = curPageData.iterator();
            while (it.hasNext()) {
                if (curSelectStatusId == ((StatusPanelData) it.next()).getStatus().getId()) {
                    showPanel$default(this, this.detailContainer.getResourceList(curSelectStatusId), null, 2, null);
                    return;
                }
            }
        }
        hidePanel(false);
    }

    public final void setActionId(Integer actionId) {
        this.adapter.setActionId(actionId);
    }

    public final void showPanel(final List<? extends BaseResourceInfo> data, Integer actionId) {
        int dip;
        Intrinsics.checkNotNullParameter(data, "data");
        SquareBaseKt.getSquareLog().d(TAG, "showPanel:" + data.size());
        ViewGroup.LayoutParams layoutParams = this.panelRecyclerView.getLayoutParams();
        if (layoutParams != null) {
            int size = data.size();
            if (size == 2) {
                dip = ViewExtensionsKt.dip(this.context, 148);
            } else if (size != 3) {
                dip = ViewExtensionsKt.dip(this.context, 220);
            } else {
                dip = ViewExtensionsKt.dip(this.context, 184);
            }
            layoutParams.height = dip;
        }
        View mask = this.mask;
        Intrinsics.checkNotNullExpressionValue(mask, "mask");
        com.tencent.state.ViewExtensionsKt.updateLayoutParams(mask, new Function1<ViewGroup.MarginLayoutParams, Unit>() { // from class: com.tencent.state.status.SquareOnlineStatusMultiActionPanelHelper$showPanel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ViewGroup.MarginLayoutParams marginLayoutParams) {
                invoke2(marginLayoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ViewGroup.MarginLayoutParams receiver) {
                Context context;
                int dip2;
                Context context2;
                Intrinsics.checkNotNullParameter(receiver, "$receiver");
                if (data.size() != 2) {
                    context2 = SquareOnlineStatusMultiActionPanelHelper.this.context;
                    dip2 = ViewExtensionsKt.dip(context2, 66);
                } else {
                    context = SquareOnlineStatusMultiActionPanelHelper.this.context;
                    dip2 = ViewExtensionsKt.dip(context, 20);
                }
                receiver.topMargin = dip2;
            }
        });
        if (actionId != null) {
            actionId.intValue();
            for (BaseResourceInfo baseResourceInfo : data) {
                baseResourceInfo.setSelected(Intrinsics.areEqual(baseResourceInfo.getActionId(), actionId));
            }
        }
        this.panelContainer.post(new Runnable() { // from class: com.tencent.state.status.SquareOnlineStatusMultiActionPanelHelper$showPanel$4
            @Override // java.lang.Runnable
            public final void run() {
                SquareOnlineStatusMultiActionPanelAdapter squareOnlineStatusMultiActionPanelAdapter;
                boolean canShowPanel;
                DetailSelectMeView detailSelectMeView;
                boolean canShowPanel2;
                IReporter iReporter;
                Map<String, Object> panelReportParams;
                SquareOnlineStatusMultiActionPanelAdapter squareOnlineStatusMultiActionPanelAdapter2;
                int i3;
                Context context;
                Object obj;
                squareOnlineStatusMultiActionPanelAdapter = SquareOnlineStatusMultiActionPanelHelper.this.adapter;
                squareOnlineStatusMultiActionPanelAdapter.setData(data);
                FrameLayout frameLayout = SquareOnlineStatusMultiActionPanelHelper.this.panelContainer;
                canShowPanel = SquareOnlineStatusMultiActionPanelHelper.this.canShowPanel();
                boolean z16 = false;
                frameLayout.setVisibility(canShowPanel ? 0 : 8);
                detailSelectMeView = SquareOnlineStatusMultiActionPanelHelper.this.detailContainer;
                canShowPanel2 = SquareOnlineStatusMultiActionPanelHelper.this.canShowPanel();
                if (canShowPanel2) {
                    Iterator it = data.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        } else {
                            obj = it.next();
                            if (((BaseResourceInfo) obj).getHasSelected()) {
                                break;
                            }
                        }
                    }
                    BaseResourceInfo baseResourceInfo2 = (BaseResourceInfo) obj;
                    if (baseResourceInfo2 != null ? baseResourceInfo2.getIsLock() : false) {
                        z16 = true;
                    }
                }
                detailSelectMeView.updateBlindBoxTips(z16);
                ViewGroup.LayoutParams layoutParams2 = SquareOnlineStatusMultiActionPanelHelper.this.panelContainer.getLayoutParams();
                if (layoutParams2 != null) {
                    squareOnlineStatusMultiActionPanelAdapter2 = SquareOnlineStatusMultiActionPanelHelper.this.adapter;
                    if (squareOnlineStatusMultiActionPanelAdapter2.getNUM_BACKGOURND_ICON() >= 4) {
                        context = SquareOnlineStatusMultiActionPanelHelper.this.context;
                        i3 = ViewExtensionsKt.dip(context, 220);
                    } else {
                        i3 = -2;
                    }
                    layoutParams2.height = i3;
                    SquareOnlineStatusMultiActionPanelHelper.this.panelContainer.requestLayout();
                }
                if (SquareOnlineStatusMultiActionPanelHelper.this.panelContainer.getVisibility() != 0 || (iReporter = SquareOnlineStatusMultiActionPanelHelper.this.reporter) == null) {
                    return;
                }
                FrameLayout frameLayout2 = SquareOnlineStatusMultiActionPanelHelper.this.panelContainer;
                panelReportParams = SquareOnlineStatusMultiActionPanelHelper.this.getPanelReportParams();
                iReporter.reportEvent("imp", frameLayout2, panelReportParams);
            }
        });
    }

    public static /* synthetic */ void showPanel$default(SquareOnlineStatusMultiActionPanelHelper squareOnlineStatusMultiActionPanelHelper, List list, Integer num, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            num = null;
        }
        squareOnlineStatusMultiActionPanelHelper.showPanel(list, num);
    }
}
