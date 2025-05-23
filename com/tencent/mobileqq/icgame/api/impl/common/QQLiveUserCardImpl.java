package com.tencent.mobileqq.icgame.api.impl.common;

import android.text.TextUtils;
import com.tencent.mobileqq.icgame.api.ILiveNetRequest;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.common.IQQLiveUserCard;
import com.tencent.mobileqq.icgame.api.impl.IQQLiveBaseModule;
import com.tencent.mobileqq.icgame.api.login.ILiveLoginApi;
import com.tencent.mobileqq.icgame.api.sso.QQLiveResponse;
import com.tencent.mobileqq.icgame.data.user.UserCardInfo;
import com.tencent.mobileqq.icgame.login.LiveLoginInfo;
import com.tencent.mobileqq.icgame.sso.request.GetUserInfoRequest;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mz0.d;
import mz0.f;
import u22.b;

/* compiled from: P */
/* loaded from: classes15.dex */
public class QQLiveUserCardImpl extends IQQLiveBaseModule implements IQQLiveUserCard {
    private static final String TAG = "ICGameUserCardImpl";

    private boolean checkSdk() {
        IQQLiveSDK iQQLiveSDK = this.sdkImpl;
        if (iQQLiveSDK != null && !iQQLiveSDK.isDestroyed() && !TextUtils.isEmpty(this.sdkImpl.getAppId())) {
            return true;
        }
        QLog.e(TAG, 1, "[checkSdk] invalid sdk");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getUserCardInfo$0(b bVar, QQLiveResponse qQLiveResponse) {
        if (!qQLiveResponse.isFailed() && qQLiveResponse.getRsp() != null) {
            UserCardInfo userCardInfo = new UserCardInfo();
            d dVar = (d) qQLiveResponse.getRsp();
            f fVar = dVar.f417851a;
            if (fVar != null) {
                userCardInfo.uid = fVar.f417861a;
                userCardInfo.nick = fVar.f417862b;
                userCardInfo.sex = fVar.f417863c;
                userCardInfo.headUrl = fVar.f417864d;
                userCardInfo.hometown = fVar.f417865e;
                userCardInfo.explicitUid = fVar.f417866f;
                userCardInfo.signature = fVar.f417867g;
                userCardInfo.f237299qq = fVar.f417868h;
            }
            mz0.b bVar2 = dVar.f417852b;
            if (bVar2 != null) {
                userCardInfo.fansNum = bVar2.f417845b;
                userCardInfo.followNum = bVar2.f417844a;
                userCardInfo.isFollow = bVar2.f417846c;
            }
            userCardInfo.showGift = dVar.f417855e;
            userCardInfo.enterRoomTips = dVar.f417858h;
            bVar.onSuccess(userCardInfo);
            return;
        }
        QLog.e(TAG, 1, "[getUserCardInfo] request failed, retCode=" + qQLiveResponse.getRetCode() + ", errMsg=" + qQLiveResponse.getErrMsg());
    }

    @Override // com.tencent.mobileqq.icgame.api.common.IQQLiveUserCard
    public void getUserCardInfo(long j3, final b bVar) {
        if (!checkSdk()) {
            QLog.e(TAG, 1, "[getUserCardInfo] invalid sdk");
        } else {
            ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new GetUserInfoRequest(this.sdkImpl.getAppId(), j3), new ILiveNetRequest.Callback() { // from class: com.tencent.mobileqq.icgame.api.impl.common.a
                @Override // com.tencent.mobileqq.icgame.api.ILiveNetRequest.Callback
                public final void onResponse(QQLiveResponse qQLiveResponse) {
                    QQLiveUserCardImpl.lambda$getUserCardInfo$0(b.this, qQLiveResponse);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.common.IQQLiveUserCard
    public void syncUserCardInfo(final u22.a aVar) {
        if (!checkSdk()) {
            QLog.e(TAG, 1, "[syncUserCardInfo] invalid sdk");
            return;
        }
        final String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        final String appId = this.sdkImpl.getAppId();
        LiveLoginInfo loginInfo = ((ILiveLoginApi) QRoute.api(ILiveLoginApi.class)).getLoginInfo(appId, account);
        if (loginInfo == null) {
            QLog.e(TAG, 4, "syncUserCardInfo no login info");
            aVar.onFailed(-1, "no login info");
        } else {
            getUserCardInfo(loginInfo.getUid(), new b() { // from class: com.tencent.mobileqq.icgame.api.impl.common.QQLiveUserCardImpl.1
                @Override // u22.b, com.tencent.mobileqq.qqlive.callback.BaseCallback
                public void onFailed(int i3, String str) {
                    super.onFailed(i3, str);
                    aVar.onFailed(i3, str);
                }

                @Override // u22.b
                public void onSuccess(UserCardInfo userCardInfo) {
                    super.onSuccess(userCardInfo);
                    if (userCardInfo != null) {
                        if (((ILiveLoginApi) QRoute.api(ILiveLoginApi.class)).updateUserInfo(appId, account, new LiveUserInfo(userCardInfo.uid, userCardInfo.headUrl, userCardInfo.nick, userCardInfo.sex))) {
                            aVar.a(userCardInfo);
                        } else {
                            aVar.onFailed(-1, "update local userinfo fail");
                        }
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void destroy() {
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void reset() {
    }
}
