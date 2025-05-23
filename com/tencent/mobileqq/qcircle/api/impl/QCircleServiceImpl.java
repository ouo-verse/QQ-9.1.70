package com.tencent.mobileqq.qcircle.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qcircleshadow.lib.QCircleHostClassHelper;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.auto.engine.enter.ASEngineEnter;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.auto.engine.lib.ASEnterBean;
import com.tencent.mobileqq.chat.api.IChatActivityApi;
import com.tencent.mobileqq.forward.api.IForwardApi;
import com.tencent.mobileqq.jump.api.IJumpApi;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qcircle.api.IQCircleService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePeriodCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.requests.QCircleGetMainPageProfileRequest;
import com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wxapi.api.IWXShareHelper;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import qqcircle.QQCircleMainPageProfile$GetQQProfileFeedListRsp;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleServiceImpl implements IQCircleService {
    private static final String TAG = "QCircleServiceImpl";

    public static IAccountRuntime getAccountApi() {
        return (IAccountRuntime) QRoute.api(IAccountRuntime.class);
    }

    public static AppInterface getAppInterface() {
        if (getAppRunTime() instanceof AppInterface) {
            return (AppInterface) getAppRunTime();
        }
        return null;
    }

    public static AppRuntime getAppRunTime() {
        return MobileQQ.sMobileQQ.waitAppRuntime(null);
    }

    public static IChatActivityApi getChatActivityApi() {
        return (IChatActivityApi) QRoute.api(IChatActivityApi.class);
    }

    public static IConversationFacade getConversationFacade() {
        if (getAppRunTime() != null) {
            return (IConversationFacade) getAppRunTime().getRuntimeService(IConversationFacade.class, "");
        }
        return (IConversationFacade) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IConversationFacade.class, "");
    }

    public static EntityManager getEntityManager() {
        if (getAppRunTime() != null) {
            return getAppRunTime().getEntityManagerFactory(getAppRunTime().getAccount()).createEntityManager();
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        return waitAppRuntime.getEntityManagerFactory(waitAppRuntime.getAccount()).createEntityManager();
    }

    public static IForwardApi getForwardApi() {
        return (IForwardApi) QRoute.api(IForwardApi.class);
    }

    public static IQCircleService getInstance() {
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null && mobileQQ.peekAppRuntime() != null) {
            return (IQCircleService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQCircleService.class, "");
        }
        return null;
    }

    public static IJumpApi getJumpApi() {
        return (IJumpApi) QRoute.api(IJumpApi.class);
    }

    public static IMessageFacade getMessageFacade() {
        return (IMessageFacade) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IMessageFacade.class, "");
    }

    public static IQQBaseService getQQService() {
        return (IQQBaseService) QRoute.api(IQQBaseService.class);
    }

    public static IWXShareHelper getWXShareHelper() {
        return (IWXShareHelper) QRoute.api(IWXShareHelper.class);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleService
    public boolean canJumpBySchema(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String fetchSchemaFromUrl = fetchSchemaFromUrl(str);
        if (TextUtils.isEmpty(fetchSchemaFromUrl) || !fetchSchemaFromUrl.contains("qcircle")) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleService
    public void downloadSkinPackage(String str) {
        QCircleSkinHelper.getInstance().downloadSkinPackage(str, null);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleService
    public void enterByScheme(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            Intent intent = new Intent(context, (Class<?>) QCircleHostClassHelper.getJumpActivityClass());
            intent.setData(Uri.parse(str));
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleService
    public void enterBySchemeAction(Context context, String str, @NonNull HashMap<String, String> hashMap) {
        if (QCircleScheme.Q_CIRCLE_ACTION_OPEN_FOLDER_PAGE.equals(str)) {
            QCirclePeriodCollect.record(QCirclePeriodCollect.PERIOD_ENTER_CLICK);
            QCircleFolderFunnelCollect.record(QCircleFolderFunnelCollect.PERIOD_ENTER_CIRCLE);
        }
        ASEngineEnter.b(new ASEnterBean(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE).setSchemeAction(str).setAttrs(hashMap));
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleService
    public void enterBySchemeSourceAction(Context context, String str, HashMap<String, String> hashMap, List<String> list) {
        if (context != null && !TextUtils.isEmpty(str) && list != null && !list.isEmpty()) {
            ASEngineEnter.b(new ASEnterBean(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE).setSchemeAction(str).setAttrs(hashMap).setSourceIds(list));
        }
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleService
    public String fetchSchemaFromUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Uri parse = Uri.parse(str);
        if (parse.isOpaque()) {
            return "";
        }
        String queryParameter = parse.getQueryParameter(QZoneDTLoginReporter.SCHEMA);
        if (!TextUtils.isEmpty(queryParameter)) {
            return queryParameter;
        }
        String queryParameter2 = parse.getQueryParameter("url");
        if (TextUtils.isEmpty(queryParameter2)) {
            return queryParameter;
        }
        return Uri.parse(queryParameter2).getQueryParameter(QZoneDTLoginReporter.SCHEMA);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleService
    public void refreshMainPageFeed(Context context, String str, String str2, VSDispatchObserver.OnVSRspCallBack<QQCircleMainPageProfile$GetQQProfileFeedListRsp> onVSRspCallBack) {
        QCircleGetMainPageProfileRequest qCircleGetMainPageProfileRequest = new QCircleGetMainPageProfileRequest(str, str2, 3);
        qCircleGetMainPageProfileRequest.setEnableCache(false);
        VSNetworkHelper.getInstance().sendRequest(context, qCircleGetMainPageProfileRequest, onVSRspCallBack);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleService
    public void enterBySchemeAction(Context context, String str, @NonNull HashMap<String, String> hashMap, @Nullable HashMap<String, byte[]> hashMap2) {
        if (QCircleScheme.Q_CIRCLE_ACTION_OPEN_FOLDER_PAGE.equals(str)) {
            QCirclePeriodCollect.record(QCirclePeriodCollect.PERIOD_ENTER_CLICK);
            QCircleFolderFunnelCollect.record(QCircleFolderFunnelCollect.PERIOD_ENTER_CIRCLE);
            if (hashMap2 != null && hashMap2.containsKey("key_red_dot_trans_info")) {
                QCircleFolderFunnelCollect.setRedInfo(true);
            } else {
                QCircleFolderFunnelCollect.setRedInfo(false);
            }
        }
        ASEngineEnter.b(new ASEnterBean(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE).setSchemeAction(str).setAttrs(hashMap).setByteAttrs(hashMap2));
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleService
    public void releaseWhenExitQCircle() {
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
    }
}
