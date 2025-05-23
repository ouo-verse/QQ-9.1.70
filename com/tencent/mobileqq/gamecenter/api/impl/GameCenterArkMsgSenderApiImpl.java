package com.tencent.mobileqq.gamecenter.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.gamecenter.api.IGameCenterArkMsgSenderApi;
import com.tencent.mobileqq.gamecenter.protocols.ArkMsgSender;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GameCenterArkMsgSenderApiImpl implements IGameCenterArkMsgSenderApi, com.tencent.mobileqq.ark.module.g {
    public static final String APP_ID_KING_RED_PACK_ARK = "com.tencent.gamecenter.sgame_redpack";
    public static final String EVENT_NAME_SHOW_RED_PACK_VIEW = "open_sgame_coupon_redpack_view";
    public static final String TAG = "GameCenterArkMsgSenderApiImpl";
    private WeakReference<com.tencent.mobileqq.gamecenter.api.a> mMsgSendCallbackRef;

    private com.tencent.mobileqq.gamecenter.api.a getCallback() {
        WeakReference<com.tencent.mobileqq.gamecenter.api.a> weakReference = this.mMsgSendCallbackRef;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterArkMsgSenderApi
    public void invokeFriendChooserThenSendArkMsg(String str, com.tencent.mobileqq.gamecenter.api.a aVar) {
        if (QLog.isDevelopLevel()) {
            QLog.i(TAG, 1, "[invokeFriendChooserThenSendArkMsg], requestJson:" + str);
        }
        if (TextUtils.isEmpty(str) && aVar != null) {
            aVar.a(-1);
        }
        this.mMsgSendCallbackRef = new WeakReference<>(aVar);
        Context context = QBaseActivity.sTopActivity;
        if (context == null) {
            context = BaseApplication.getContext();
        }
        Intent intent = new Intent();
        intent.putExtras(new Bundle());
        intent.putExtra("requestJson", str);
        intent.putExtra(AppConstants.Key.FORWARD_IS_FROMJUMP, false);
        intent.putExtra("k_favorites", false);
        intent.putExtra("system_share", true);
        intent.putExtra("emoInputType", 0);
        intent.putExtra("forward_type", 1056);
        RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTE_JUMP_FORWARD_RECENT);
    }

    @Override // com.tencent.mobileqq.ark.module.g
    public boolean notify(String str, String str2, final String str3) {
        if (QLog.isDevelopLevel()) {
            QLog.i(TAG, 2, "[notify], appName:" + str + ",eventName:" + str2 + ",params:" + str3);
        }
        if (!APP_ID_KING_RED_PACK_ARK.equals(str) || !EVENT_NAME_SHOW_RED_PACK_VIEW.equals(str2)) {
            return false;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.api.impl.GameCenterArkMsgSenderApiImpl.1
            @Override // java.lang.Runnable
            public void run() {
                GameCenterArkMsgSenderApiImpl.this.showRedPackFloatView(str3);
            }
        });
        return true;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterArkMsgSenderApi
    public void registerArkNotify() {
        ((IArkAPIService) QRoute.api(IArkAPIService.class)).registerAppNotification(APP_ID_KING_RED_PACK_ARK, this);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterArkMsgSenderApi
    public void sendArkMsg(String str, com.tencent.mobileqq.gamecenter.api.a aVar) {
        ArkMsgSender arkMsgSender = new ArkMsgSender();
        if (aVar == null) {
            aVar = getCallback();
        }
        arkMsgSender.k(aVar);
        try {
            JSONObject jSONObject = new JSONObject(str);
            arkMsgSender.j(jSONObject.optInt("aioType"), jSONObject.optString("number"), str);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "[sendRedPackArkMsg], error:" + e16);
            if (aVar != null) {
                aVar.a(-1);
            }
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterArkMsgSenderApi
    public void showRedPackFloatView(String str) {
        Context context = QBaseActivity.sTopActivity;
        if (context == null) {
            context = BaseApplication.getContext();
        }
        com.tencent.mobileqq.gamecenter.ui.x xVar = new com.tencent.mobileqq.gamecenter.ui.x(context, R.style.a0x);
        xVar.S();
        xVar.setCanceledOnTouchOutside(true);
        xVar.U(com.tencent.mobileqq.gamecenter.data.m.a(str));
        xVar.show();
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterArkMsgSenderApi
    public void unRegisterArkNotify() {
        ((IArkAPIService) QRoute.api(IArkAPIService.class)).registerAppNotification(APP_ID_KING_RED_PACK_ARK, null);
    }
}
