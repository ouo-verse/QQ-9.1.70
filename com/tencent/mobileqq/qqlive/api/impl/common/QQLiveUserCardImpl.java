package com.tencent.mobileqq.qqlive.api.impl.common;

import android.text.TextUtils;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.common.IQQLiveUserCard;
import com.tencent.mobileqq.qqlive.api.impl.IQQLiveBaseModule;
import com.tencent.mobileqq.qqlive.api.login.ILiveLoginApi;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.callback.common.IQQLiveSyncUserInfoCallback;
import com.tencent.mobileqq.qqlive.callback.common.IQQLiveUserCardInfoCallback;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qqlive.data.user.UserCardInfo;
import com.tencent.mobileqq.qqlive.login.LiveLoginInfo;
import com.tencent.mobileqq.qqlive.sso.request.GetUserInfoRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import rr4.d;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveUserCardImpl extends IQQLiveBaseModule implements IQQLiveUserCard {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QQLiveUserCardImpl";

    public QQLiveUserCardImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean checkSdk() {
        IQQLiveSDK iQQLiveSDK = this.sdkImpl;
        if (iQQLiveSDK != null && !iQQLiveSDK.isDestroyed() && !TextUtils.isEmpty(this.sdkImpl.getAppId())) {
            return true;
        }
        QLog.e(TAG, 1, "[checkSdk] invalid sdk");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getUserCardInfo$0(IQQLiveUserCardInfoCallback iQQLiveUserCardInfoCallback, QQLiveResponse qQLiveResponse) {
        d dVar = (d) qQLiveResponse.getRsp();
        if (!qQLiveResponse.isFailed() && dVar != null) {
            iQQLiveUserCardInfoCallback.onSuccess(UserCardInfo.from(dVar));
            return;
        }
        QLog.e(TAG, 1, "[getUserCardInfo] request failed, retCode=" + qQLiveResponse.getRetCode() + ", errMsg=" + qQLiveResponse.getErrMsg());
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.common.IQQLiveUserCard
    public void getUserCardInfo(long j3, final IQQLiveUserCardInfoCallback iQQLiveUserCardInfoCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), iQQLiveUserCardInfoCallback);
        } else if (!checkSdk()) {
            QLog.e(TAG, 1, "[getUserCardInfo] invalid sdk");
        } else {
            ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new GetUserInfoRequest(this.sdkImpl.getAppId(), j3), new ILiveNetRequest.Callback() { // from class: com.tencent.mobileqq.qqlive.api.impl.common.a
                @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
                public final void onResponse(QQLiveResponse qQLiveResponse) {
                    QQLiveUserCardImpl.lambda$getUserCardInfo$0(IQQLiveUserCardInfoCallback.this, qQLiveResponse);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.common.IQQLiveUserCard
    public void syncUserCardInfo(IQQLiveSyncUserInfoCallback iQQLiveSyncUserInfoCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) iQQLiveSyncUserInfoCallback);
            return;
        }
        if (!checkSdk()) {
            QLog.e(TAG, 1, "[syncUserCardInfo] invalid sdk");
            return;
        }
        String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        String appId = this.sdkImpl.getAppId();
        LiveLoginInfo loginInfo = ((ILiveLoginApi) QRoute.api(ILiveLoginApi.class)).getLoginInfo(appId, account);
        if (loginInfo == null) {
            QLog.e(TAG, 4, "syncUserCardInfo no login info");
            iQQLiveSyncUserInfoCallback.onFailed(-1, "no login info");
        } else {
            getUserCardInfo(loginInfo.q(), new IQQLiveUserCardInfoCallback(appId, account, iQQLiveSyncUserInfoCallback) { // from class: com.tencent.mobileqq.qqlive.api.impl.common.QQLiveUserCardImpl.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String val$appId;
                final /* synthetic */ IQQLiveSyncUserInfoCallback val$syncUserInfoCallback;
                final /* synthetic */ String val$uin;

                {
                    this.val$appId = appId;
                    this.val$uin = account;
                    this.val$syncUserInfoCallback = iQQLiveSyncUserInfoCallback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, QQLiveUserCardImpl.this, appId, account, iQQLiveSyncUserInfoCallback);
                    }
                }

                @Override // com.tencent.mobileqq.qqlive.callback.common.IQQLiveUserCardInfoCallback, com.tencent.mobileqq.qqlive.callback.BaseCallback
                public void onFailed(int i3, String str) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this, i3, (Object) str);
                    } else {
                        super.onFailed(i3, str);
                        this.val$syncUserInfoCallback.onFailed(i3, str);
                    }
                }

                @Override // com.tencent.mobileqq.qqlive.callback.common.IQQLiveUserCardInfoCallback
                public void onSuccess(UserCardInfo userCardInfo) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) userCardInfo);
                        return;
                    }
                    super.onSuccess(userCardInfo);
                    if (userCardInfo != null) {
                        if (((ILiveLoginApi) QRoute.api(ILiveLoginApi.class)).updateUserInfo(this.val$appId, this.val$uin, new LiveUserInfo(userCardInfo.uid, userCardInfo.headUrl, userCardInfo.nick, userCardInfo.sex))) {
                            this.val$syncUserInfoCallback.onSuccess(userCardInfo);
                        } else {
                            this.val$syncUserInfoCallback.onFailed(-1, "update local userinfo fail");
                        }
                    }
                }
            });
        }
    }
}
