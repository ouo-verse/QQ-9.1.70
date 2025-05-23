package com.tencent.mobileqq.qcircle.api.impl;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.qcircle.api.ITVideoPublicAccountLauncherApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* loaded from: classes16.dex */
public class TVideoPublicAccountLauncherApiImpl implements ITVideoPublicAccountLauncherApi {
    private static final String TAG = "TVideoPublicAccountLauncherImpl";
    public static final String TVIDEO_PUBLIC_ACCOUNT_SCHEME_URL = "mqqapi://qcircle/opentvideopublicaccount?&xsj_custom_pgid=page_ugqqoa_play&xsj_main_entrance=tvideo_public_account&feedInfo=";

    private void clearRedPointIfNeed() {
        if (!hasUnReadMessage()) {
            QLog.d(TAG, 1, "no unReadMessage");
            return;
        }
        QCircleServiceImpl.getMessageFacade().setReaded(AppConstants.TVIDEO_PUBLIC_ACCOUNT_UIN, 1008);
        AppInterface appInterface = QCircleServiceImpl.getAppInterface();
        if (appInterface instanceof BaseQQAppInterface) {
            ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).sendReadConfirm((BaseQQAppInterface) appInterface, AppConstants.Q_CIRCLE_PUBLIC_ACCOUNT_UIN);
        }
        QLog.d(TAG, 1, "clearUnReadMessage");
    }

    private String getJumpUrl(String str) throws Exception {
        if (TextUtils.isEmpty(str)) {
            return TVIDEO_PUBLIC_ACCOUNT_SCHEME_URL;
        }
        String optString = new JSONObject(str).optString("oac_triggle");
        String[] split = optString.split(ContainerUtils.FIELD_DELIMITER);
        QLog.d(TAG, 1, "launchTVideoPublicAccountPage oacTriggle:", optString);
        for (String str2 : split) {
            if (str2.startsWith("busi_id") && str2.split(ContainerUtils.KEY_VALUE_DELIMITER).length > 1) {
                return TVIDEO_PUBLIC_ACCOUNT_SCHEME_URL + str2.split(ContainerUtils.KEY_VALUE_DELIMITER)[1];
            }
        }
        return "";
    }

    private boolean hasUnReadMessage() {
        IConversationFacade conversationFacade = QCircleServiceImpl.getConversationFacade();
        if (conversationFacade == null || conversationFacade.getUnreadCount(AppConstants.TVIDEO_PUBLIC_ACCOUNT_UIN, 1008) <= 0) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qcircle.api.ITVideoPublicAccountLauncherApi
    public void launchTVideoPublicAccountDetailPage(Context context) {
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, IPublicAccountDetailActivity.ROUTE_NAME);
        activityURIRequest.extra().putString("uin", AppConstants.TVIDEO_PUBLIC_ACCOUNT_UIN);
        activityURIRequest.extra().putInt("uintype", 1008);
        activityURIRequest.extra().putInt("source", 116);
        QRoute.startUri(activityURIRequest, (o) null);
    }

    @Override // com.tencent.mobileqq.qcircle.api.ITVideoPublicAccountLauncherApi
    public void launchTVideoPublicAccountPage(BaseQQAppInterface baseQQAppInterface, Context context, String str) {
        String str2;
        QLog.e(TAG, 1, "launchTVideoPublicAccountPage extendInfo = " + str);
        try {
            str2 = getJumpUrl(str);
        } catch (Exception e16) {
            QLog.d(TAG, 1, "launchTVideoPublicAccountPage JSONException:" + e16);
            str2 = "";
        }
        QLog.d(TAG, 1, "launchTVideoPublicAccountPage jumpUrl = ", str2);
        ax c16 = bi.c(baseQQAppInterface, context, str2);
        if (c16 == null) {
            QLog.e(TAG, 1, "jumpAction parse error");
        } else {
            clearRedPointIfNeed();
            c16.b();
        }
    }
}
