package com.tencent.state.status;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.mmkv.SKey;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.data.BaseResourceInfo;
import com.tencent.state.square.mmkv.IMMKV;
import com.tencent.state.utils.DrawableUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u0016\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020 J\u0010\u0010)\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001eH\u0002J\u0010\u0010*\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001eH\u0002J\u0014\u0010+\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0,H\u0002J\u0012\u0010/\u001a\u00020&2\b\u00100\u001a\u0004\u0018\u00010\u0004H\u0016J\u000e\u00101\u001a\u00020&2\u0006\u00102\u001a\u000203J\u0010\u00104\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001eH\u0002R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\u0019\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010!\u001a\u0004\u0018\u00010\"8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010$\u00a8\u00065"}, d2 = {"Lcom/tencent/state/status/SquareOnlineStatusMultiActionPanelHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "listener", "Lcom/tencent/state/status/ISquareOnlineStatusMultiActionPanelListener;", "reportDependency", "Lcom/tencent/state/status/IReportDependency;", "mmkv", "Lcom/tencent/state/square/mmkv/IMMKV;", "(Landroid/view/View;Lcom/tencent/state/status/ISquareOnlineStatusMultiActionPanelListener;Lcom/tencent/state/status/IReportDependency;Lcom/tencent/state/square/mmkv/IMMKV;)V", "actionIconView", "Landroid/widget/ImageView;", "getActionIconView", "()Landroid/widget/ImageView;", "actionLockView", "getActionLockView", "()Landroid/view/View;", "actionNameView", "Landroid/widget/TextView;", "getActionNameView", "()Landroid/widget/TextView;", "actionReddotView", "getActionReddotView", "contentView", "Landroid/widget/RelativeLayout;", "getContentView", "()Landroid/widget/RelativeLayout;", "curData", "Lcom/tencent/state/square/data/BaseResourceInfo;", "curDataIndex", "", "reporter", "Lcom/tencent/state/square/IReporter;", "getReporter", "()Lcom/tencent/state/square/IReporter;", "bindData", "", "data", "position", "checkAndShowLock", "checkAndShowReddot", "getReportParams", "", "", "", NodeProps.ON_CLICK, "v", "refreshSelectState", "selected", "", "setIcon", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareOnlineStatusMultiActionPanelHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final ImageView actionIconView;
    private final View actionLockView;
    private final TextView actionNameView;
    private final View actionReddotView;
    private final RelativeLayout contentView;
    private BaseResourceInfo curData;
    private int curDataIndex;
    private final ISquareOnlineStatusMultiActionPanelListener listener;
    private final IMMKV mmkv;
    private final IReportDependency reportDependency;

    public /* synthetic */ SquareOnlineStatusMultiActionPanelHolder(View view, ISquareOnlineStatusMultiActionPanelListener iSquareOnlineStatusMultiActionPanelListener, IReportDependency iReportDependency, IMMKV immkv, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, (i3 & 2) != 0 ? null : iSquareOnlineStatusMultiActionPanelListener, (i3 & 4) != 0 ? null : iReportDependency, immkv);
    }

    private final void checkAndShowLock(BaseResourceInfo data) {
        this.actionLockView.setVisibility(data.getIsLock() ? 0 : 8);
    }

    private final void checkAndShowReddot(BaseResourceInfo data) {
        String redDotId = data.getRedDotId();
        if (redDotId == null || redDotId.length() == 0) {
            this.actionReddotView.setVisibility(8);
        } else if (IMMKV.DefaultImpls.decodeBool$default(this.mmkv, SKey.DetailMe.KEY_ONLINE_STATUS_MULTI_ACTION_ITEM_REDDOT, false, data.getRedDotId(), false, 8, null)) {
            this.actionReddotView.setVisibility(8);
        } else {
            this.actionReddotView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> getReportParams() {
        Map<String, Object> mutableMapOf;
        BaseResourceInfo baseResourceInfo = this.curData;
        if (baseResourceInfo != null) {
            Pair[] pairArr = new Pair[3];
            pairArr[0] = TuplesKt.to(SquareReportConst.Key.KEY_STATE_ID, Integer.valueOf(baseResourceInfo.getStatus().getId()));
            pairArr[1] = TuplesKt.to(SquareReportConst.Key.KEY_RICH_STATE_ID, Integer.valueOf(baseResourceInfo.getStatus().getRichStatus()));
            pairArr[2] = TuplesKt.to("zplan_is_redpoint", Integer.valueOf(this.actionReddotView.getVisibility() == 0 ? 1 : 0));
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
            IReportDependency iReportDependency = this.reportDependency;
            if (iReportDependency != null) {
                iReportDependency.fillReportParams(mutableMapOf, SquareReportConst.Key.KEY_ACTION_ID, baseResourceInfo);
            }
            if (mutableMapOf != null) {
                return mutableMapOf;
            }
        }
        return new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IReporter getReporter() {
        IReportDependency iReportDependency = this.reportDependency;
        if (iReportDependency != null) {
            return iReportDependency.getIReporter();
        }
        return null;
    }

    private final void setIcon(BaseResourceInfo data) {
        String motionUrl = data.getMotionUrl();
        if (Intrinsics.areEqual(this.actionIconView.getTag(), motionUrl)) {
            return;
        }
        this.actionIconView.setImageDrawable(SquareOnlineStatusUtils.INSTANCE.getUrlDrawable(motionUrl, null, DrawableUtil.INSTANCE.getDrawable(R.drawable.i9h), false));
        this.actionIconView.setTag(motionUrl);
    }

    public final void bindData(BaseResourceInfo data, int position) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.curData = data;
        this.curDataIndex = position;
        setIcon(data);
        this.actionNameView.setText(data.getMotionName());
        checkAndShowReddot(data);
        checkAndShowLock(data);
        refreshSelectState(data.getHasSelected());
        this.contentView.post(new Runnable() { // from class: com.tencent.state.status.SquareOnlineStatusMultiActionPanelHolder$bindData$1
            @Override // java.lang.Runnable
            public final void run() {
                IReporter reporter;
                Map<String, Object> reportParams;
                reporter = SquareOnlineStatusMultiActionPanelHolder.this.getReporter();
                if (reporter != null) {
                    RelativeLayout contentView = SquareOnlineStatusMultiActionPanelHolder.this.getContentView();
                    reportParams = SquareOnlineStatusMultiActionPanelHolder.this.getReportParams();
                    reporter.reportEvent("imp", contentView, reportParams);
                }
            }
        });
    }

    public final ImageView getActionIconView() {
        return this.actionIconView;
    }

    public final View getActionLockView() {
        return this.actionLockView;
    }

    public final TextView getActionNameView() {
        return this.actionNameView;
    }

    public final View getActionReddotView() {
        return this.actionReddotView;
    }

    public final RelativeLayout getContentView() {
        return this.contentView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        BaseResourceInfo baseResourceInfo;
        ISquareOnlineStatusMultiActionPanelListener iSquareOnlineStatusMultiActionPanelListener;
        IReporter reporter = getReporter();
        if (reporter != null) {
            reporter.reportEvent("clck", this.contentView, getReportParams());
        }
        int i3 = this.curDataIndex;
        if (i3 == -1 || (baseResourceInfo = this.curData) == null || (iSquareOnlineStatusMultiActionPanelListener = this.listener) == null) {
            return;
        }
        iSquareOnlineStatusMultiActionPanelListener.onItemClick(i3, baseResourceInfo.getStatus(), baseResourceInfo);
    }

    public final void refreshSelectState(boolean selected) {
        this.contentView.setSelected(selected);
        this.actionNameView.setSelected(selected);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareOnlineStatusMultiActionPanelHolder(View itemView, ISquareOnlineStatusMultiActionPanelListener iSquareOnlineStatusMultiActionPanelListener, IReportDependency iReportDependency, IMMKV mmkv) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(mmkv, "mmkv");
        this.listener = iSquareOnlineStatusMultiActionPanelListener;
        this.reportDependency = iReportDependency;
        this.mmkv = mmkv;
        View findViewById = itemView.findViewById(R.id.pp5);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026ulti_action_item_content)");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById;
        this.contentView = relativeLayout;
        View findViewById2 = itemView.findViewById(R.id.pp6);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.\u2026e_multi_action_item_icon)");
        this.actionIconView = (ImageView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.pp8);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.\u2026e_multi_action_item_name)");
        this.actionNameView = (TextView) findViewById3;
        View findViewById4 = itemView.findViewById(R.id.pp9);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.\u2026multi_action_item_reddot)");
        this.actionReddotView = findViewById4;
        View findViewById5 = itemView.findViewById(R.id.pp7);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.\u2026e_multi_action_item_lock)");
        this.actionLockView = findViewById5;
        this.curDataIndex = -1;
        relativeLayout.setOnClickListener(this);
        IReporter reporter = getReporter();
        if (reporter != null) {
            reporter.setElementInfo(relativeLayout, SquareReportConst.ElementId.ELEMENT_ID_MULTI_ACTION_ITEM, new LinkedHashMap(), false, false);
        }
    }
}
