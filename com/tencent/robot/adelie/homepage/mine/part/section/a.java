package com.tencent.robot.adelie.homepage.mine.part.section;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqnt.kernel.nativeinterface.RobotSummary;
import com.tencent.robot.adelie.homepage.mine.part.AdelieCreateCenterHeaderView;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J*\u0010\u0010\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0014J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/robot/adelie/homepage/mine/part/section/a;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "La24/d;", "", "p", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "attached", "onAttachedChanged", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/robot/adelie/homepage/mine/part/AdelieCreateCenterHeaderView;", "d", "Lcom/tencent/robot/adelie/homepage/mine/part/AdelieCreateCenterHeaderView;", "headerView", "e", "La24/d;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a extends Section<a24.d> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AdelieCreateCenterHeaderView headerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a24.d data;

    private final void p() {
        VideoReport.setElementId(getRootView(), "em_bas_creator_banner");
        VideoReport.setElementClickPolicy(getRootView(), ClickPolicy.REPORT_NONE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean attached) {
        long j3;
        long j16;
        Map mapOf;
        RobotSummary summary;
        RobotSummary summary2;
        RobotSummary summary3;
        if (attached) {
            View rootView = getRootView();
            Pair[] pairArr = new Pair[3];
            a24.d dVar = this.data;
            long j17 = 0;
            if (dVar != null && (summary3 = dVar.getSummary()) != null) {
                j3 = summary3.robotNum;
            } else {
                j3 = 0;
            }
            pairArr[0] = TuplesKt.to("quantity_created", String.valueOf(j3));
            a24.d dVar2 = this.data;
            if (dVar2 != null && (summary2 = dVar2.getSummary()) != null) {
                j16 = summary2.friendNum;
            } else {
                j16 = 0;
            }
            pairArr[1] = TuplesKt.to("agent_friend", String.valueOf(j16));
            a24.d dVar3 = this.data;
            if (dVar3 != null && (summary = dVar3.getSummary()) != null) {
                j17 = summary.msgNum;
            }
            pairArr[2] = TuplesKt.to("message_number", String.valueOf(j17));
            mapOf = MapsKt__MapsKt.mapOf(pairArr);
            VideoReport.reportEvent("imp", rootView, mapOf);
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        super.onDestroy();
        AdelieCreateCenterHeaderView adelieCreateCenterHeaderView = this.headerView;
        if (adelieCreateCenterHeaderView != null) {
            adelieCreateCenterHeaderView.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        AdelieCreateCenterHeaderView adelieCreateCenterHeaderView;
        if (containerView != null) {
            adelieCreateCenterHeaderView = (AdelieCreateCenterHeaderView) containerView.findViewById(R.id.x8r);
        } else {
            adelieCreateCenterHeaderView = null;
        }
        this.headerView = adelieCreateCenterHeaderView;
        p();
        if (containerView != null) {
            FontSettingManager.resetViewSize2Normal(containerView.getContext(), containerView);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable a24.d data, int position, @Nullable List<Object> payload) {
        this.data = data;
        AdelieCreateCenterHeaderView adelieCreateCenterHeaderView = this.headerView;
        if (adelieCreateCenterHeaderView != null) {
            adelieCreateCenterHeaderView.setData(data);
        }
    }
}
