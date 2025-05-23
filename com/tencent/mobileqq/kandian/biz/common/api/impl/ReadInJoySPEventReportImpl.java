package com.tencent.mobileqq.kandian.biz.common.api.impl;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport;
import com.tencent.mobileqq.mp.mobileqq_mp$ButtonInfo;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.util.List;
import kotlin.Metadata;
import v62.b;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b;\u0010<J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J8\u0010\u0013\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u001c\u0010\u0016\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0017\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J4\u0010\u001e\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0010\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\rH\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016J\b\u0010 \u001a\u00020\u0004H\u0016J\b\u0010!\u001a\u00020\u0004H\u0016J\b\u0010\"\u001a\u00020\u0004H\u0016J\b\u0010#\u001a\u00020\u0004H\u0016J\b\u0010$\u001a\u00020\u0004H\u0016J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\tH\u0016J\u0018\u0010)\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u001aH\u0016J\u001a\u0010)\u001a\u00020\u00042\b\u0010*\u001a\u0004\u0018\u00010\u000f2\u0006\u0010(\u001a\u00020\u001aH\u0016J\b\u0010+\u001a\u00020\u0004H\u0016J,\u00100\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u00010.H\u0016J\u0010\u00101\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\tH\u0016J\u0010\u00102\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u001aH\u0016J6\u00107\u001a\u00020\u00042\b\u00103\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u00104\u001a\u00020\u001a2\b\u00105\u001a\u0004\u0018\u00010\u000f2\b\u00106\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u00109\u001a\u00020\u00042\u0006\u00108\u001a\u00020\tH\u0016J\b\u0010:\u001a\u00020\u0004H\u0016\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/common/api/impl/ReadInJoySPEventReportImpl;", "Lcom/tencent/mobileqq/kandian/biz/common/api/IReadInJoySPEventReport;", "Lv62/b;", "foreBackGroundCallback", "", "addForeBackGroundCallback", "removeForeBackGroundCallback", "Lcom/tencent/widget/AbsListView;", "view", "", HippyTKDListViewAdapter.SCROLL_STATE, "onScrollStateChanged", "type", "", "extraMsg", "", "uin", MessageRoamJsPlugin.USERTYPE, "hasUnreadCount", "addAioEnterAndOutInfo", "", "cell", "reportPubAioItemClick", "enterPublicAccount", "", "enterMullis", "", "hasRed", "Lcom/tencent/mobileqq/data/ChatMessage;", "list", "reportInQQNews", "leaveMsgTab", "reportManualRefresMsg", "reportTabExposure", "recordOneKeyClean", "reportLeaveQQ", "reportInForeground", "reason", "reportAfterSyncMsg", "resId", "hasRedDot", "onLebaItemClick", "busiName", "onLebaResume", "menuId", "menuLevel", "Lcom/tencent/mobileqq/mp/mobileqq_mp$ButtonInfo;", "buttonInfo", "reportPubAioMenuAction", "reportDau", "updateDTRedPntStats", "action", "hasRedPot", "exposureInfo", "clickInfo", "reportQQNewsAction", "tabIndex", "reportFragmentTabClick", "registerScreenReceiver", "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ReadInJoySPEventReportImpl implements IReadInJoySPEventReport {
    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport
    public void addAioEnterAndOutInfo(int type, List<?> extraMsg, String uin, int userType, int hasUnreadCount) {
        ReadinjoySPEventReport.J().w(type, extraMsg, uin, userType, hasUnreadCount);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport
    public void addForeBackGroundCallback(b foreBackGroundCallback) {
        ReadinjoySPEventReport.d.a(foreBackGroundCallback);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport
    public void enterPublicAccount(String uin) {
        ReadinjoySPEventReport.J().D(uin);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport
    public void leaveMsgTab() {
        ReadinjoySPEventReport.Z();
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport
    public void onLebaItemClick(int resId, boolean hasRedDot) {
        ReadinjoySPEventReport.J().a0(resId, hasRedDot);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport
    public void onLebaResume() {
        ReadinjoySPEventReport.J().c0();
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        ReadinjoySPEventReport.e.c(view, scrollState);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport
    public void recordOneKeyClean() {
        ReadinjoySPEventReport.J().f0();
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport
    public void registerScreenReceiver() {
        try {
            ReadinjoySPEventReport.g0();
        } catch (Exception e16) {
            QLog.e("ReadInJoySPEventReportImpl", 1, "registerScreenReceiver", e16);
        }
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport
    public void removeForeBackGroundCallback(b foreBackGroundCallback) {
        ReadinjoySPEventReport.d.g(foreBackGroundCallback);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport
    public void reportAfterSyncMsg(int reason) {
        ReadinjoySPEventReport.h0(reason);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport
    public void reportDau(int type) {
        ReadinjoySPEventReport.j0(type);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport
    public void reportFragmentTabClick(int tabIndex) {
        try {
            ReadinjoySPEventReport.e0(tabIndex);
        } catch (Exception e16) {
            QLog.e("ReadInJoySPEventReportImpl", 1, "doOnUpdateFrameOnTabClick", e16);
        }
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport
    public void reportInForeground() {
        ReadinjoySPEventReport.n0();
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport
    public void reportInQQNews(String uin, long enterMullis, boolean hasRed, List<? extends ChatMessage> list) {
        ReadinjoySPEventReport.J().p0(uin, enterMullis, hasRed, list);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport
    public void reportLeaveQQ() {
        ReadinjoySPEventReport.r0();
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport
    public void reportManualRefresMsg() {
        ReadinjoySPEventReport.J().t0();
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport
    public void reportPubAioItemClick(String uin, Object cell) {
        ReadinjoySPEventReport.J().x0(uin, (AbsStructMsgElement) cell);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport
    public void reportPubAioMenuAction(String uin, int menuId, int menuLevel, mobileqq_mp$ButtonInfo buttonInfo) {
        ReadinjoySPEventReport.J().y0(uin, menuId, menuLevel, buttonInfo);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport
    public void reportQQNewsAction(String action, long enterMullis, boolean hasRedPot, String exposureInfo, String clickInfo) {
        ReadinjoySPEventReport.J().A0(action, enterMullis, hasRedPot, exposureInfo, clickInfo);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport
    public void reportTabExposure() {
        try {
            ReadinjoySPEventReport.C0();
        } catch (Exception e16) {
            QLog.e("ReadInJoySPEventReportImpl", 1, "reportTabExposure", e16);
        }
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport
    public void updateDTRedPntStats(boolean hasRedDot) {
        ReadinjoySPEventReport.J().F0(hasRedDot);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport
    public void onLebaItemClick(String busiName, boolean hasRedDot) {
        ReadinjoySPEventReport.J().b0(busiName, hasRedDot);
    }
}
