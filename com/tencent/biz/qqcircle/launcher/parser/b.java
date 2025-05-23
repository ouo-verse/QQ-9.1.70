package com.tencent.biz.qqcircle.launcher.parser;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.variation.HostRouteUtils;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleOpenSharePanelBean;
import com.tencent.biz.qqcircle.events.QCircleLaunchFolderEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSSelectSubTabEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSSelectedPageEvent;
import com.tencent.biz.qqcircle.immersive.tab.QFSRecommendTabFragment;
import com.tencent.biz.qqcircle.manager.QCircleFolderTabInfoManager;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.auto.engine.lib.ASInject;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePeriodCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.event.QCircleSelectTabEvent;
import com.tencent.mobileqq.qcircle.api.event.QCircleTriggerBottomRefreshEvent;
import com.tencent.mobileqq.qcircle.api.event.QFSReceivePushFeedEvent;
import com.tencent.mobileqq.qcircle.api.event.QFSRefreshTabEvent;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qcircle.api.global.QFSPushConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.beans.QCircleSchemeBean;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import java.util.List;
import qqcircle.QQCircleFeedBase$StTabInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends a {
    private void A(@NonNull HashMap<String, String> hashMap) {
        if (hashMap.containsKey("open_push_panel") && TextUtils.equals(hashMap.get("open_push_panel"), String.valueOf(1))) {
            QFSPushConfig.setIsNeedShowPushPanelWhenLogin(true);
        }
    }

    private void B(QCircleFolderBean qCircleFolderBean, HashMap<String, String> hashMap) {
        if (qCircleFolderBean != null && hashMap != null) {
            if (!hashMap.containsKey("sub_tab_type")) {
                return;
            }
            try {
                qCircleFolderBean.setAssignShowSubTabType(Integer.parseInt(hashMap.get("sub_tab_type")));
                return;
            } catch (Exception e16) {
                QLog.e("QCircleBaseSchemeParser", 1, "parseInt error!" + e16.toString());
                return;
            }
        }
        QLog.e("QCircleBaseSchemeParser", 1, "parseAssignShowSubTabTypeParam failed!");
    }

    private void C(QCircleFolderBean qCircleFolderBean, HashMap<String, String> hashMap) {
        if (qCircleFolderBean != null && hashMap != null) {
            if (hashMap.containsKey(QCircleSchemeAttr.Polymerize.TAB_TYPE)) {
                try {
                    qCircleFolderBean.setAssignShowTabType(Integer.parseInt(hashMap.get(QCircleSchemeAttr.Polymerize.TAB_TYPE)));
                    return;
                } catch (Exception e16) {
                    QLog.e("QCircleBaseSchemeParser", 1, "parseInt error!" + e16.toString());
                    return;
                }
            }
            return;
        }
        QLog.e("QCircleBaseSchemeParser", 1, "parseAssignShowTabTypeParam failed!");
    }

    private void D(HashMap<String, String> hashMap, HashMap<String, byte[]> hashMap2, QCircleFolderBean qCircleFolderBean) {
        if (hashMap.containsKey("uin")) {
            String str = hashMap.get("uin");
            QCircleReportHelper.getInstance().setInviteUin(str);
            qCircleFolderBean.setUin(str);
        }
        if (hashMap.containsKey(QCircleSchemeAttr.Folder.INVITE_ID)) {
            String str2 = hashMap.get(QCircleSchemeAttr.Folder.INVITE_ID);
            QCircleReportHelper.getInstance().setInviteId(str2);
            qCircleFolderBean.mInviteUin = str2;
        } else {
            QCircleReportHelper.getInstance().setInviteId(null);
        }
        if (hashMap.containsKey("key_is_publish")) {
            boolean z16 = true;
            if (Integer.parseInt(hashMap.get("key_is_publish")) != 1) {
                z16 = false;
            }
            qCircleFolderBean.setPublish(z16);
        }
        if (hashMap.containsKey("key_show_active_red_dot")) {
            qCircleFolderBean.setHasRedDot(Boolean.parseBoolean(hashMap.get("key_show_active_red_dot")));
        }
        if (hashMap.containsKey("key_unread_red_num")) {
            qCircleFolderBean.setUnreadRedNum(Integer.parseInt(hashMap.get("key_unread_red_num")));
        }
        if (hashMap2 != null && hashMap2.containsKey("key_red_dot_trans_info")) {
            qCircleFolderBean.setRedDotTransInfo(hashMap2.get("key_red_dot_trans_info"));
        }
    }

    private void E(QCircleFolderBean qCircleFolderBean, HashMap<String, String> hashMap) {
        if (hashMap == null) {
            return;
        }
        if (bb0.b.n(bb0.b.i().k(false), hashMap)) {
            QLog.e("QCircleBaseSchemeParser", 1, "parseForceInsertFeedParam setForceFromPushPreloadCache");
            qCircleFolderBean.setForceFromPushPreloadCache(true);
            return;
        }
        if (hashMap.containsKey("key_forced_inserted_feed_id")) {
            QCirclePluginGlobalInfo.U(hashMap.get("key_forced_inserted_feed_id"));
            qCircleFolderBean.setForceFromNetwork(true);
        }
        if (hashMap.containsKey("transdata")) {
            QCirclePluginGlobalInfo.h0(hashMap.get("transdata"));
        }
    }

    private void F(QCircleFolderBean qCircleFolderBean, HashMap<String, String> hashMap) {
        if (qCircleFolderBean != null && hashMap != null) {
            if (!hashMap.containsKey("key_forced_inserted_feed_id")) {
                return;
            }
            try {
                qCircleFolderBean.setForcedInsertedFeedId(hashMap.get("key_forced_inserted_feed_id"));
                return;
            } catch (Exception e16) {
                QLog.e("QCircleBaseSchemeParser", 1, "parseString error!" + e16.toString());
                return;
            }
        }
        QLog.e("QCircleBaseSchemeParser", 1, "parseForcedInsertedFeedIdParam failed!");
    }

    private void G(QCircleFolderBean qCircleFolderBean, HashMap<String, String> hashMap) {
        if (qCircleFolderBean != null && hashMap != null) {
            if (!hashMap.containsKey("from")) {
                return;
            }
            try {
                qCircleFolderBean.setFrom(hashMap.get("from"));
                return;
            } catch (Exception e16) {
                QLog.e("QCircleBaseSchemeParser", 1, "parseString error!" + e16.toString());
                return;
            }
        }
        QLog.e("QCircleBaseSchemeParser", 1, "parseFromParam failed!");
    }

    private void H(QCircleFolderBean qCircleFolderBean, HashMap<String, String> hashMap) {
        boolean z16;
        if (qCircleFolderBean != null && hashMap != null) {
            if (!hashMap.containsKey("key_is_from_publish")) {
                return;
            }
            try {
                if (Integer.parseInt(hashMap.get("key_is_from_publish")) == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                qCircleFolderBean.setIsFromPublish(z16);
                return;
            } catch (Exception e16) {
                QLog.e("QCircleBaseSchemeParser", 1, "parseInt error!" + e16.toString());
                return;
            }
        }
        QLog.e("QCircleBaseSchemeParser", 1, "parseIsFromPublishParam failed!");
    }

    private void I(QCircleFolderBean qCircleFolderBean, HashMap<String, String> hashMap) {
        boolean z16;
        if (qCircleFolderBean != null && hashMap != null && hashMap.containsKey("open_share_panel")) {
            try {
                if (Integer.parseInt(hashMap.get("open_share_panel")) == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                qCircleFolderBean.setOpenSharePanel(z16);
                QCirclePluginGlobalInfo.c0(new QCircleOpenSharePanelBean(qCircleFolderBean.getForcedInsertedFeedId(), qCircleFolderBean.getOpenSharePanel()));
            } catch (Exception e16) {
                QLog.e("QCircleBaseSchemeParser", 1, "parseOpenSharePanelParam error!" + e16);
            }
        }
    }

    private void J(QCircleFolderBean qCircleFolderBean, HashMap<String, String> hashMap) {
        qCircleFolderBean.setPymkTranferData(hashMap.get("transdata"));
        try {
            qCircleFolderBean.setPymkJumpType(Integer.parseInt(hashMap.get("type")));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void K(QCircleFolderBean qCircleFolderBean, HashMap<String, String> hashMap) {
        if (qCircleFolderBean != null && hashMap != null && hashMap.containsKey(QCircleSchemeAttr.TeenMode.IS_TEEN_MODE_LIMIT)) {
            String str = hashMap.get(QCircleSchemeAttr.TeenMode.IS_TEEN_MODE_LIMIT);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            qCircleFolderBean.setIsTeenModeLimit(str.equals("1"));
        }
    }

    private void L(HashMap<String, String> hashMap) {
        if (hashMap != null && hashMap.containsKey("from") && TextUtils.equals("message", hashMap.get("from")) && hashMap.containsKey("key_forced_inserted_feed_id")) {
            QCirclePluginGlobalInfo.U(hashMap.get("key_forced_inserted_feed_id"));
        }
    }

    private void M(@NonNull HashMap<String, String> hashMap, boolean z16) {
        if (bb0.b.n(bb0.b.i().k(false), hashMap)) {
            try {
                SimpleEventBus.getInstance().dispatchEvent(new QFSReceivePushFeedEvent(z16));
                return;
            } catch (Exception e16) {
                QLog.d("QCircleBaseSchemeParser", 1, "refreshFolderTab error:" + e16);
                return;
            }
        }
        if (hashMap.containsKey("key_forced_inserted_feed_id") && !TextUtils.isEmpty(hashMap.get("key_forced_inserted_feed_id"))) {
            try {
                SimpleEventBus.getInstance().dispatchEvent(new QFSRefreshTabEvent(Integer.parseInt(hashMap.get(QCircleSchemeAttr.Polymerize.TAB_TYPE)), false));
            } catch (Exception e17) {
                QLog.d("QCircleBaseSchemeParser", 1, "select tab param exception:" + e17.toString());
            }
        }
    }

    private void N(@NonNull HashMap<String, String> hashMap) {
        if (hashMap.containsKey(QCircleDaTongConstant.ElementParamKey.XSJ_REF_LOCATION) && !TextUtils.isEmpty(hashMap.get(QCircleDaTongConstant.ElementParamKey.XSJ_REF_LOCATION))) {
            QFSRecommendTabFragment.Y = hashMap.get(QCircleDaTongConstant.ElementParamKey.XSJ_REF_LOCATION);
        }
    }

    private void o(QCircleFolderBean qCircleFolderBean, HashMap<String, String> hashMap) {
        if (hashMap != null && hashMap.containsKey("key_scheme")) {
            qCircleFolderBean.setLastPageScheme(hashMap.get("key_scheme"));
            QCirclePluginGlobalInfo.g0(hashMap.get("key_scheme"));
        }
    }

    private void p(QCircleSchemeBean qCircleSchemeBean) {
        HashMap<String, String> attrs = qCircleSchemeBean.getAttrs();
        if (attrs == null) {
            return;
        }
        List<QQCircleFeedBase$StTabInfo> p16 = QCircleFolderTabInfoManager.m().p(com.tencent.biz.qqcircle.c.e().d(), new QCircleFolderBean(new QCircleReportBean()), false);
        if (p16 != null && !p16.isEmpty()) {
            for (int i3 = 0; i3 < p16.size(); i3++) {
                QQCircleFeedBase$StTabInfo qQCircleFeedBase$StTabInfo = p16.get(i3);
                if (qQCircleFeedBase$StTabInfo != null && 11 == qQCircleFeedBase$StTabInfo.tabType.get()) {
                    QLog.e("QCircleBaseSchemeParser", 1, "adjustActivityTabSchema find jump tab");
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("key_scheme", attrs.get("key_scheme"));
                    hashMap.put(QCircleSchemeAttr.Polymerize.TAB_TYPE, attrs.get(QCircleSchemeAttr.Polymerize.TAB_TYPE));
                    hashMap.put("is_force_jump_tab_page", attrs.get("is_force_jump_tab_page"));
                    qCircleSchemeBean.setAttrs(hashMap);
                    return;
                }
            }
            QLog.e("QCircleBaseSchemeParser", 1, "adjustActivityTabSchema jump to allPush tab");
            attrs.put(QCircleSchemeAttr.Polymerize.TAB_TYPE, String.valueOf(6));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void q(QCircleSchemeBean qCircleSchemeBean) {
        int i3;
        HashMap<String, String> attrs = qCircleSchemeBean.getAttrs();
        if (attrs == null) {
            return;
        }
        try {
        } catch (Exception e16) {
            QLog.e("QCircleBaseSchemeParser", 1, "adjustAllPushTabSchema error :" + e16);
        }
        if (attrs.containsKey("high_priority_tabtype")) {
            String str = attrs.get("high_priority_tabtype");
            if (!TextUtils.isEmpty(str)) {
                i3 = Integer.parseInt(str.trim());
                if (i3 != -1) {
                    return;
                }
                List<QQCircleFeedBase$StTabInfo> p16 = QCircleFolderTabInfoManager.m().p(com.tencent.biz.qqcircle.c.e().d(), new QCircleFolderBean(new QCircleReportBean()), false);
                if (p16 != null && !p16.isEmpty()) {
                    for (int i16 = 0; i16 < p16.size(); i16++) {
                        QQCircleFeedBase$StTabInfo qQCircleFeedBase$StTabInfo = p16.get(i16);
                        if (qQCircleFeedBase$StTabInfo != null && i3 == qQCircleFeedBase$StTabInfo.tabType.get()) {
                            QLog.e("QCircleBaseSchemeParser", 1, "adjustAllPushTabSchema find jump tab");
                            HashMap<String, String> hashMap = new HashMap<>();
                            hashMap.put("key_scheme", attrs.get("key_scheme"));
                            hashMap.put(QCircleSchemeAttr.Polymerize.TAB_TYPE, attrs.get("high_priority_tabtype"));
                            hashMap.put("is_force_jump_tab_page", attrs.get("is_force_jump_tab_page"));
                            qCircleSchemeBean.setAttrs(hashMap);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
        }
        i3 = -1;
        if (i3 != -1) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002a A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:6:0x0006, B:8:0x0010, B:10:0x001c, B:13:0x002a, B:17:0x0031), top: B:5:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void r(QCircleSchemeBean qCircleSchemeBean) {
        int i3;
        if (qCircleSchemeBean == null) {
            return;
        }
        try {
            HashMap<String, String> attrs = qCircleSchemeBean.getAttrs();
            if (attrs.containsKey(QCircleSchemeAttr.Polymerize.TAB_TYPE)) {
                String str = attrs.get(QCircleSchemeAttr.Polymerize.TAB_TYPE);
                if (!TextUtils.isEmpty(str)) {
                    i3 = Integer.parseInt(str.trim());
                    if (i3 != 11) {
                        p(qCircleSchemeBean);
                        return;
                    } else {
                        if (i3 == 6) {
                            q(qCircleSchemeBean);
                            return;
                        }
                        return;
                    }
                }
            }
            i3 = -1;
            if (i3 != 11) {
            }
        } catch (Exception e16) {
            QLog.e("QCircleBaseSchemeParser", 1, "adjustSchemaIfNeed error :" + e16);
        }
    }

    private int s(HashMap<String, String> hashMap, int i3) {
        if (!x(hashMap)) {
            return i3;
        }
        if (!QCirclePluginGlobalInfo.C()) {
            QCirclePluginGlobalInfo.e0(true);
        }
        if (QCirclePluginGlobalInfo.C() && uq3.c.E()) {
            return 9;
        }
        return i3;
    }

    private void t(HashMap<String, String> hashMap) {
        if (hashMap.containsKey(QCircleSchemeAttr.Polymerize.TAB_TYPE)) {
            try {
                int s16 = s(hashMap, Integer.parseInt(hashMap.get(QCircleSchemeAttr.Polymerize.TAB_TYPE).trim()));
                QCirclePluginGlobalInfo.f0(s16);
                QCircleSelectTabEvent qCircleSelectTabEvent = new QCircleSelectTabEvent(s16);
                if (hashMap.containsKey("needrefresh") && TextUtils.equals(hashMap.get("needrefresh"), "1")) {
                    qCircleSelectTabEvent.needRefresh();
                }
                qCircleSelectTabEvent.setIsFromSchema(true);
                SimpleEventBus.getInstance().dispatchEvent(qCircleSelectTabEvent);
            } catch (Exception e16) {
                QLog.d("QCircleBaseSchemeParser", 1, "select tab param exception:" + e16.toString());
            }
        }
        if (hashMap.containsKey("sub_tab_type")) {
            try {
                QFSSelectSubTabEvent qFSSelectSubTabEvent = new QFSSelectSubTabEvent(Integer.parseInt(hashMap.get("sub_tab_type").trim()));
                String str = hashMap.get("module_id");
                if (!TextUtils.isEmpty(str)) {
                    qFSSelectSubTabEvent.setAnchor(Integer.parseInt(str));
                }
                SimpleEventBus.getInstance().dispatchEvent(qFSSelectSubTabEvent);
            } catch (Exception e17) {
                QLog.d("QCircleBaseSchemeParser", 1, "select subtab exception:" + e17.toString());
            }
        }
    }

    private boolean u(HashMap<String, String> hashMap) {
        if (hashMap == null || !hashMap.containsKey("is_force_jump_sub_page") || !TextUtils.equals(hashMap.get("is_force_jump_sub_page"), String.valueOf(1))) {
            return false;
        }
        QLog.d("QCircleBaseSchemeParser", 1, "forceJumpSubPage");
        return true;
    }

    private boolean v(HashMap<String, String> hashMap) {
        if (hashMap == null || !hashMap.containsKey("is_force_jump_tab_page") || !TextUtils.equals(hashMap.get("is_force_jump_tab_page"), String.valueOf(1))) {
            return false;
        }
        QLog.d("QCircleBaseSchemeParser", 1, "isForceJumpTabPage");
        return true;
    }

    private boolean w(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            return false;
        }
        if (hashMap.containsKey(QCircleSchemeAttr.Detail.IS_MIDDLE_PAGE) && hashMap.get(QCircleSchemeAttr.Detail.IS_MIDDLE_PAGE).equals(String.valueOf(1))) {
            QLog.d("QCircleBaseSchemeParser", 1, "isMiddlePage");
            return true;
        }
        if (!QCircleDaTongConstant.ElementParamValue.QQ_SEARCHBAR_RESULTS.equals(hashMap.get("xsj_main_entrance")) || !"searchbar_entrance".equals(hashMap.get("xsj_sub_entrance"))) {
            return false;
        }
        QLog.d("QCircleBaseSchemeParser", 1, "is from qq_searchbar");
        return true;
    }

    private boolean x(HashMap<String, String> hashMap) {
        if (hashMap == null || !hashMap.containsKey("key_is_from_publish")) {
            return false;
        }
        try {
            if (Integer.parseInt(hashMap.get("key_is_from_publish")) != 1) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            QLog.e("QCircleBaseSchemeParser", 1, "[isFromPublishParam] parseInt error!" + e16.toString());
            return false;
        }
    }

    private boolean y(HashMap<String, String> hashMap) {
        boolean z16;
        if (v(hashMap)) {
            if (QCirclePluginUtil.isTabMode()) {
                return true;
            }
            QLog.e("QCircleBaseSchemeParser", 1, "isJumpTabPage forceJumpTabPage but not tab mode");
        }
        boolean isTabMode = QCirclePluginUtil.isTabMode();
        boolean isCurrentTabActive = QCircleHostGlobalInfo.isCurrentTabActive();
        if (isTabMode && !w(hashMap) && !u(hashMap) && isCurrentTabActive) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("QCircleBaseSchemeParser", 1, "[isJumpTabPage] result = " + z16 + ", QCirclePluginUtil.isTabMode() = " + isTabMode + ", !BuildConfig.IS_BUILD_SHADOW = true, QCircleHostGlobalInfo.isCurrentTabActive() = " + isCurrentTabActive);
        if (bz.t() && !bz.o() && isTabMode && ASInject.g().getAsEngineDelegate().isOnThirdTab(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE)) {
            QLog.d("QCircleBaseSchemeParser", 1, "[isJumpTabPage] is pad. ");
            return true;
        }
        return z16;
    }

    private void z(Context context, QCircleSchemeBean qCircleSchemeBean) {
        if (fb0.a.b("QCircleBaseSchemeParser_launchFolderPageBySchema", 500L) && !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_fast_schema_to_folder", true)) {
            return;
        }
        r(qCircleSchemeBean);
        QCirclePeriodCollect.record(QCirclePeriodCollect.PERIOD_PLUGIN_LOADED);
        HashMap<String, String> attrs = qCircleSchemeBean.getAttrs();
        if (attrs == null) {
            return;
        }
        bb0.b.i().e(qCircleSchemeBean);
        boolean y16 = y(attrs);
        SimpleEventBus.getInstance().dispatchEvent(new QCircleLaunchFolderEvent(y16));
        if (y16) {
            QCircleHostGlobalInfo.setTabModeSchema(attrs.get("key_scheme"));
            L(attrs);
            HostRouteUtils.openSplashActivity(context, attrs);
            SimpleEventBus.getInstance().dispatchEvent(new QCircleTriggerBottomRefreshEvent(true));
        } else {
            com.tencent.biz.qqcircle.launcher.c.I(context, O(qCircleSchemeBean, attrs));
            SimpleEventBus.getInstance().dispatchEvent(new QFSSelectedPageEvent(0));
        }
        t(attrs);
        M(attrs, y16);
        A(attrs);
        N(attrs);
    }

    public QCircleFolderBean O(QCircleSchemeBean qCircleSchemeBean, HashMap<String, String> hashMap) {
        if (qCircleSchemeBean.getEnterTime() <= 0) {
            qCircleSchemeBean.setEnterTime(System.currentTimeMillis());
        }
        QCircleFolderBean qCircleFolderBean = new QCircleFolderBean();
        qCircleFolderBean.setAttrs(hashMap);
        o(qCircleFolderBean, qCircleSchemeBean.getAttrs());
        b(qCircleSchemeBean, qCircleFolderBean);
        i(qCircleFolderBean, hashMap);
        C(qCircleFolderBean, hashMap);
        B(qCircleFolderBean, hashMap);
        j(qCircleFolderBean, hashMap);
        D(hashMap, qCircleSchemeBean.getByteAttrs(), qCircleFolderBean);
        H(qCircleFolderBean, hashMap);
        F(qCircleFolderBean, hashMap);
        G(qCircleFolderBean, hashMap);
        E(qCircleFolderBean, hashMap);
        K(qCircleFolderBean, hashMap);
        I(qCircleFolderBean, hashMap);
        QCircleContentDetailSchemeParser.A(qCircleFolderBean, hashMap);
        if (QCircleScheme.Q_CIRCLE_ACTION_OPEN_PYMK_PAGE.equals(qCircleSchemeBean.getSchemeAction())) {
            qCircleFolderBean.setOpenPymk(true);
            J(qCircleFolderBean, hashMap);
        } else {
            qCircleFolderBean.setOpenPymk(false);
        }
        qCircleFolderBean.setEnterTime(qCircleSchemeBean.getEnterTime());
        return qCircleFolderBean;
    }

    @Override // com.tencent.biz.qqcircle.launcher.parser.a
    public void f(Context context, QCircleSchemeBean qCircleSchemeBean) {
        if (qCircleSchemeBean.getEnterTime() <= 0) {
            qCircleSchemeBean.setEnterTime(System.currentTimeMillis());
        }
        z(context, qCircleSchemeBean);
    }
}
