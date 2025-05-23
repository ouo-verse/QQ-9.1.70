package com.tencent.biz.qcircleshadow.lib;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.annotation.SuppressShadowCheck;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qcircleshadow.lib.variation.HostChatUtils;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qcircle.api.requests.QCircleGetUIDRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.a;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import feedcloud.FeedCloudRead$StGetUIDRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleHostChatHelper {
    private static final String TAG = "QCircleHostChatHelper";

    public static int getChatType(int i3) {
        if (i3 == 0) {
            return 1;
        }
        if (i3 == 1) {
            return 2;
        }
        return 113;
    }

    public static int getUnReadNum(String str, int i3) {
        return QCircleServiceImpl.getConversationFacade().getUnreadCount(str, i3);
    }

    @SuppressShadowCheck
    public static boolean isOneWayBoxConversation(MessageRecord messageRecord) {
        return ao.B(messageRecord);
    }

    public static void jumpPrivateChat(final Context context, final String str, String str2, final String str3, final Bundle bundle, final boolean z16) {
        if (!TextUtils.isEmpty(str2)) {
            prepareAndJumpAIOActivity(context, str2, str, str3, bundle, z16);
            return;
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str3);
        if (!TextUtils.isEmpty(uidFromUin)) {
            prepareAndJumpAIOActivity(context, uidFromUin, str, str3, bundle, z16);
        } else {
            VSNetworkHelper.getInstance().sendRequest((Context) null, new QCircleGetUIDRequest(1, str3), new VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StGetUIDRsp>() { // from class: com.tencent.biz.qcircleshadow.lib.QCircleHostChatHelper.1
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public void onReceive(BaseRequest baseRequest, boolean z17, long j3, String str4, FeedCloudRead$StGetUIDRsp feedCloudRead$StGetUIDRsp) {
                    if (z17 && j3 == 0 && feedCloudRead$StGetUIDRsp != null) {
                        QLog.d(QCircleHostChatHelper.TAG, 1, "[requestGetUID] uidValid = " + feedCloudRead$StGetUIDRsp.uidValid.get() + ", uid = " + feedCloudRead$StGetUIDRsp.uid.get() + ", errMsg = " + feedCloudRead$StGetUIDRsp.errMsg.get());
                        Bundle bundle2 = bundle;
                        if (bundle2 != null) {
                            bundle2.putString(HostChatUtils.QCIRCLE_CHAT_GET_UID_ERR_MSG_KEY(), feedCloudRead$StGetUIDRsp.errMsg.get());
                        }
                        if (feedCloudRead$StGetUIDRsp.uidValid.get() && feedCloudRead$StGetUIDRsp.uid.has()) {
                            ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).saveUidByUin(str3, feedCloudRead$StGetUIDRsp.uid.get());
                        }
                        QCircleHostChatHelper.prepareAndJumpAIOActivity(context, (feedCloudRead$StGetUIDRsp.uidValid.get() && feedCloudRead$StGetUIDRsp.uid.has()) ? feedCloudRead$StGetUIDRsp.uid.get() : str3, str, str3, bundle, z16);
                        return;
                    }
                    QLog.e(QCircleHostChatHelper.TAG, 1, "[requestGetUID] retCode:" + j3 + "  errorMsg:" + str4);
                    Bundle bundle3 = bundle;
                    if (bundle3 != null) {
                        bundle3.putString(HostChatUtils.QCIRCLE_CHAT_GET_UID_ERR_MSG_KEY(), str4);
                    }
                    Context context2 = context;
                    String str5 = str3;
                    QCircleHostChatHelper.prepareAndJumpAIOActivity(context2, str5, str, str5, bundle, z16);
                }
            });
        }
    }

    public static void prepareAndJumpAIOActivity(Context context, String str, String str2, String str3, Bundle bundle, boolean z16) {
        if (context == null) {
            QLog.e(TAG, 1, "[prepareAndJumpAIOActivity] context == null");
            return;
        }
        if (bundle == null) {
            QLog.e(TAG, 1, "[prepareAndJumpAIOActivity] bundle == null");
            return;
        }
        int i3 = bundle.getInt(QCircleHostConstants.AppConstants.Key.UIN_TYPE(), QCircleHostConstants.AppConstants.Value.UIN_TYPE_TEMP_CIRCLE());
        QLog.d(TAG, 1, "[prepareAndJumpAIOActivity] peerUid = " + str + ", peerNick = " + str2 + ", peerUin = " + str3 + ", uinType = " + i3);
        int chatType = getChatType(i3);
        bundle.putString("key_from", "40");
        try {
            if (z16) {
                ((IAIOStarterApi) a.b(IAIOStarterApi.class)).navigateToScaleAIO(context, chatType, str, str2, bundle);
            } else {
                ((IAIOStarterApi) a.b(IAIOStarterApi.class)).navigateToAIOActivity(context, chatType, str, str2, Long.parseLong(str3), bundle);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "[prepareAndJumpAIOActivity] error = " + e16.toString());
        }
    }
}
