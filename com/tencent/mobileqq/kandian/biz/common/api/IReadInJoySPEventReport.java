package com.tencent.mobileqq.kandian.biz.common.api;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.mp.mobileqq_mp$ButtonInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin;
import com.tencent.widget.AbsListView;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import v62.b;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\r\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001a\u0010\u000b\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH&J8\u0010\u0013\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH&J\u001c\u0010\u0016\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H&J\u0012\u0010\u0017\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&J4\u0010\u001e\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0010\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\rH&J\b\u0010\u001f\u001a\u00020\u0004H&J\b\u0010 \u001a\u00020\u0004H&J\b\u0010!\u001a\u00020\u0004H&J\b\u0010\"\u001a\u00020\u0004H&J\b\u0010#\u001a\u00020\u0004H&J\b\u0010$\u001a\u00020\u0004H&J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\tH&J\u0018\u0010)\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u001aH&J\u001a\u0010)\u001a\u00020\u00042\b\u0010*\u001a\u0004\u0018\u00010\u000f2\u0006\u0010(\u001a\u00020\u001aH&J\b\u0010+\u001a\u00020\u0004H&J,\u00100\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u00010.H&J\u0010\u00101\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\tH&J\u0010\u00102\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u001aH&J6\u00107\u001a\u00020\u00042\b\u00103\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u00104\u001a\u00020\u001a2\b\u00105\u001a\u0004\u0018\u00010\u000f2\b\u00106\u001a\u0004\u0018\u00010\u000fH&J\u0010\u00109\u001a\u00020\u00042\u0006\u00108\u001a\u00020\tH&J\b\u0010:\u001a\u00020\u0004H&\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/common/api/IReadInJoySPEventReport;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lv62/b;", "foreBackGroundCallback", "", "addForeBackGroundCallback", "removeForeBackGroundCallback", "Lcom/tencent/widget/AbsListView;", "view", "", HippyTKDListViewAdapter.SCROLL_STATE, "onScrollStateChanged", "type", "", "extraMsg", "", "uin", MessageRoamJsPlugin.USERTYPE, "hasUnreadCount", "addAioEnterAndOutInfo", "", "cell", "reportPubAioItemClick", "enterPublicAccount", "", "enterMullis", "", "hasRed", "Lcom/tencent/mobileqq/data/ChatMessage;", "list", "reportInQQNews", "leaveMsgTab", "reportManualRefresMsg", "reportTabExposure", "recordOneKeyClean", "reportLeaveQQ", "reportInForeground", "reason", "reportAfterSyncMsg", "resId", "hasRedDot", "onLebaItemClick", "busiName", "onLebaResume", "menuId", "menuLevel", "Lcom/tencent/mobileqq/mp/mobileqq_mp$ButtonInfo;", "buttonInfo", "reportPubAioMenuAction", "reportDau", "updateDTRedPntStats", "action", "hasRedPot", "exposureInfo", "clickInfo", "reportQQNewsAction", "tabIndex", "reportFragmentTabClick", "registerScreenReceiver", "kandian-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IReadInJoySPEventReport extends QRouteApi {
    void addAioEnterAndOutInfo(int type, @Nullable List<?> extraMsg, @Nullable String uin, int userType, int hasUnreadCount);

    void addForeBackGroundCallback(@Nullable b foreBackGroundCallback);

    void enterPublicAccount(@Nullable String uin);

    void leaveMsgTab();

    void onLebaItemClick(int resId, boolean hasRedDot);

    void onLebaItemClick(@Nullable String busiName, boolean hasRedDot);

    void onLebaResume();

    void onScrollStateChanged(@Nullable AbsListView view, int scrollState);

    void recordOneKeyClean();

    void registerScreenReceiver();

    void removeForeBackGroundCallback(@Nullable b foreBackGroundCallback);

    void reportAfterSyncMsg(int reason);

    void reportDau(int type);

    void reportFragmentTabClick(int tabIndex);

    void reportInForeground();

    void reportInQQNews(@Nullable String uin, long enterMullis, boolean hasRed, @Nullable List<? extends ChatMessage> list);

    void reportLeaveQQ();

    void reportManualRefresMsg();

    void reportPubAioItemClick(@Nullable String uin, @Nullable Object cell);

    void reportPubAioMenuAction(@Nullable String uin, int menuId, int menuLevel, @Nullable mobileqq_mp$ButtonInfo buttonInfo);

    void reportQQNewsAction(@Nullable String action, long enterMullis, boolean hasRedPot, @Nullable String exposureInfo, @Nullable String clickInfo);

    void reportTabExposure();

    void updateDTRedPntStats(boolean hasRedDot);
}
