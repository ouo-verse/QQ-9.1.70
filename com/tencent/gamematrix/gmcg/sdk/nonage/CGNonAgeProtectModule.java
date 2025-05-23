package com.tencent.gamematrix.gmcg.sdk.nonage;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.tencent.gamematrix.gmcg.api.GmCgError;
import com.tencent.gamematrix.gmcg.base.utils.CGSharedPrefUtil;
import com.tencent.gamematrix.gmcg.sdk.config.CGGlbConfig;
import com.tencent.gamematrix.gmcg.sdk.nonage.bean.CGNonageCheckTokenResp;
import com.tencent.gamematrix.gmcg.sdk.nonage.bean.CGNonageCreateTokenResp;
import com.tencent.gamematrix.gmcg.sdk.nonage.bean.CGNonageGetUserAgeResp;
import com.tencent.gamematrix.gmcg.sdk.nonage.bean.CGNonageUser;
import com.tencent.gamematrix.gmcg.sdk.nonage.heatbeat.CGNonAgeHeartBeater;
import com.tencent.gamematrix.gmcg.sdk.nonage.net.CGNonAgeProtectRequest;
import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import com.tencent.gamematrix.gmcg.sdk.nonage.utils.HandlerUtils;
import com.tencent.gamematrix.gmcg.sdk.nonage.utils.QrCodeUtils;

/* loaded from: classes6.dex */
public class CGNonAgeProtectModule implements CGNonAgeHeartBeater.IHeartBeatListener {
    private static final String CGNONAGE_USER_CACHE = "CGNONAGE_USER_CACHE";
    private static final String TAG = "CGNonAgeProtect";
    private IUIchangeListener iUIchangeListener;
    private String mGameId;
    private Gson mGson;
    private CGNonAgeHeartBeater mHeatBeater;
    private Long mLastCheckTime;
    private ILoginListener mListener;
    private ILoginCheckListener mLoginCheckCallback;
    private Runnable mPoolTokenCheck;
    private CGNonageUser mUser;

    /* loaded from: classes6.dex */
    public interface ILoginCheckListener {
        void onLoginFailure(GmCgError gmCgError);

        void onLoginSuccess();
    }

    /* loaded from: classes6.dex */
    public interface ILoginListener {
        public static final int LOGIN_FAILURE = 2;
        public static final int LOGIN_NONAGE = 3;
        public static final int LOGIN_SUCCESS = 1;

        void onBitmapFailure();

        void onBitmapRefresh(Bitmap bitmap);

        void onLoginResult(int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class INNER {

        @SuppressLint({"StaticFieldLeak"})
        static CGNonAgeProtectModule INSTANCE = new CGNonAgeProtectModule();

        INNER() {
        }
    }

    /* loaded from: classes6.dex */
    public interface IUIchangeListener {
        void startQrActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkToken(@NonNull final String str) {
        CGNonAgeProtectRequest.getCheckToken(str, new CGNonAgeProtectRequest.IRequestCallback<CGNonageCheckTokenResp>() { // from class: com.tencent.gamematrix.gmcg.sdk.nonage.CGNonAgeProtectModule.2
            @Override // com.tencent.gamematrix.gmcg.sdk.nonage.net.CGNonAgeProtectRequest.IRequestCallback
            public void onError(GmCgError gmCgError) {
                CGNonAgeProtectModule.this.log("checktoken/err = " + gmCgError);
                HandlerUtils.postDelay(CGNonAgeProtectModule.this.mPoolTokenCheck, 1000L);
            }

            @Override // com.tencent.gamematrix.gmcg.sdk.nonage.net.CGNonAgeProtectRequest.IRequestCallback
            public void onSuccess(CGNonageCheckTokenResp cGNonageCheckTokenResp) {
                if (cGNonageCheckTokenResp == null || cGNonageCheckTokenResp.getResult() == null) {
                    CGNonAgeProtectModule.this.log("checkToken onSuccess: result == null || result.getResult() == null");
                    return;
                }
                if (cGNonageCheckTokenResp.getResult().getStatus() == -1) {
                    CGNonAgeProtectModule.this.log("checkToken onSuccess: token Expire");
                    CGNonAgeProtectModule.this.getLoginQrCodeAndLoop();
                    return;
                }
                if (cGNonageCheckTokenResp.getResult().getStatus() != 3 || TextUtils.isEmpty(cGNonageCheckTokenResp.getResult().getUid()) || TextUtils.isEmpty(cGNonageCheckTokenResp.getResult().getKey())) {
                    HandlerUtils.postDelay(CGNonAgeProtectModule.this.mPoolTokenCheck, 1000L);
                    return;
                }
                CGNonAgeProtectModule.this.log("checkToken success uid = " + cGNonageCheckTokenResp.getResult().getUid() + ", key = " + cGNonageCheckTokenResp.getResult().getKey());
                CGNonAgeProtectModule.this.startCheckUserAge(cGNonageCheckTokenResp.getResult().getAppid(), cGNonageCheckTokenResp.getResult().getUid(), cGNonageCheckTokenResp.getResult().getKey(), str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUserAge(final String str, final String str2, final String str3, final String str4, final int i3) {
        if (i3 >= 3) {
            log("checkUserAge failure retry time >= 3");
            ILoginListener iLoginListener = this.mListener;
            if (iLoginListener != null) {
                iLoginListener.onLoginResult(2);
            }
            onLoginCheckFailure();
            return;
        }
        CGNonAgeProtectRequest.getUserAge(str, str2, str3, new CGNonAgeProtectRequest.IRequestCallback<CGNonageGetUserAgeResp>() { // from class: com.tencent.gamematrix.gmcg.sdk.nonage.CGNonAgeProtectModule.3
            @Override // com.tencent.gamematrix.gmcg.sdk.nonage.net.CGNonAgeProtectRequest.IRequestCallback
            public void onError(GmCgError gmCgError) {
                CGNonAgeProtectModule.this.log("getUserAge failure appid = " + str + ", uid = " + str2 + ", key = " + str3 + ", token = " + str4 + ", this retry time= " + i3);
                CGNonAgeProtectModule.this.checkUserAge(str, str2, str3, str4, i3 + 1);
            }

            @Override // com.tencent.gamematrix.gmcg.sdk.nonage.net.CGNonAgeProtectRequest.IRequestCallback
            public void onSuccess(CGNonageGetUserAgeResp cGNonageGetUserAgeResp) {
                if (cGNonageGetUserAgeResp == null || cGNonageGetUserAgeResp.getErrCode() != 0 || cGNonageGetUserAgeResp.getResult() == null) {
                    CGNonAgeProtectModule.this.log("checckUserAge failure result == null || result.getErrCode() != 0 || result.getResult() == null");
                    HandlerUtils.post(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.nonage.CGNonAgeProtectModule.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            CGNonAgeProtectModule.this.checkUserAge(str, str2, str3, str4, i3 + 1);
                        }
                    });
                    return;
                }
                CGNonAgeProtectModule cGNonAgeProtectModule = CGNonAgeProtectModule.this;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("getUserAge result.getResult().getAge() < 18 == ");
                sb5.append(cGNonageGetUserAgeResp.getResult().getAge() < 18);
                cGNonAgeProtectModule.log(sb5.toString());
                if (cGNonageGetUserAgeResp.getResult().getAge() < 18 || NonAgeDebug.testChildren) {
                    if (CGNonAgeProtectModule.this.mListener != null) {
                        CGNonAgeProtectModule.this.mListener.onLoginResult(3);
                    }
                } else {
                    CGNonAgeProtectModule.this.saveUser(str2, str3, str, str4);
                    CGNonAgeProtectModule.this.onLoginCheckSuccess();
                    if (CGNonAgeProtectModule.this.mListener != null) {
                        CGNonAgeProtectModule.this.mListener.onLoginResult(1);
                    }
                    CGNonAgeProtectModule.this.mHeatBeater.startBeat();
                    CGNonAgeReport.reportLoginSuccess();
                }
            }
        });
    }

    public static CGNonAgeProtectModule getInstance() {
        return INNER.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(String str) {
        Log.d(TAG, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoginCheckFailure() {
        if (this.mLoginCheckCallback != null) {
            showToast("\u672a\u6210\u5e74\u6821\u9a8c\u6d41\u7a0b\u5931\u8d25\uff01");
            log("onLoginCheckFailure: truly failure" + Log.getStackTraceString(new Throwable()));
            this.mLoginCheckCallback.onLoginFailure(GmCgError.ErrorNonAgeCheckFailure);
            this.mLoginCheckCallback = null;
        }
        this.mLastCheckTime = Long.valueOf(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoginCheckSuccess() {
        if (this.mLoginCheckCallback != null) {
            log("onLoginCheckSuccess: truly success");
            this.mLoginCheckCallback.onLoginSuccess();
            this.mLoginCheckCallback = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveUser(String str, String str2, String str3, String str4) {
        CGNonageUser cGNonageUser = new CGNonageUser();
        this.mUser = cGNonageUser;
        cGNonageUser.setUserId(str);
        this.mUser.setKey(str2);
        this.mUser.setAppId(str3);
        this.mUser.setToken(str4);
        this.mUser.setSaveTime(System.currentTimeMillis() / 1000);
        CGSharedPrefUtil.put(CGGlbConfig.getAppContext(), CGNONAGE_USER_CACHE, new Gson().toJson(this.mUser));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDebugToast(String str) {
        showToast(str);
    }

    private void showDialog(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @Nullable Runnable runnable, @Nullable Runnable runnable2) {
        boolean z16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("title = ");
        sb5.append(str);
        sb5.append(",msg = ");
        sb5.append(str2);
        sb5.append(", iUIchangeListener is null? ");
        if (this.iUIchangeListener == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        log(sb5.toString());
    }

    private void showToast(String str) {
        Toast.makeText(CGGlbConfig.getAppContext(), str, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCheckUserAge(String str, String str2, String str3, String str4) {
        log("checkUserAge start");
        checkUserAge(str, str2, str3, str4, 1);
    }

    public void deleteUser() {
        this.mUser = null;
        CGSharedPrefUtil.put(CGGlbConfig.getAppContext(), CGNONAGE_USER_CACHE, "");
    }

    @NonNull
    public String getGameId() {
        return "" + this.mGameId;
    }

    public void getLoginQrCodeAndLoop(@Nullable ILoginListener iLoginListener) {
        this.mListener = iLoginListener;
        getLoginQrCodeAndLoop();
    }

    public CGNonageUser getUser() {
        return this.mUser;
    }

    public void login(String str, @Nullable ILoginCheckListener iLoginCheckListener) {
        if (this.mLastCheckTime != null && System.currentTimeMillis() - this.mLastCheckTime.longValue() < 2000) {
            if (iLoginCheckListener != null) {
                iLoginCheckListener.onLoginFailure(GmCgError.ErrorNonAgeCheckTooFrequent);
            }
        } else {
            this.mGameId = str;
            this.mLoginCheckCallback = iLoginCheckListener;
            this.mHeatBeater.startBeat();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.nonage.heatbeat.CGNonAgeHeartBeater.IHeartBeatListener
    public void onHeartBeatForceOffline(String str, String str2) {
        log("onForceOffline: title = " + str + ", msg = " + str2);
        showDialog(str, str2, "\u6211\u77e5\u9053\u4e86", "\u5207\u6362\u8d26\u53f7", new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.nonage.CGNonAgeProtectModule.4
            @Override // java.lang.Runnable
            public void run() {
                CGNonAgeProtectModule.this.onLoginCheckFailure();
                String str3 = "";
                if (CGNonAgeProtectModule.this.mUser != null) {
                    str3 = "" + CGNonAgeProtectModule.this.mUser.getUserId();
                }
                CGNonAgeReport.reportDialogClick("2", str3, true);
            }
        }, new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.nonage.CGNonAgeProtectModule.5
            @Override // java.lang.Runnable
            public void run() {
                CGNonAgeProtectModule.this.startQrActivity();
                String str3 = "";
                if (CGNonAgeProtectModule.this.mUser != null) {
                    str3 = "" + CGNonAgeProtectModule.this.mUser.getUserId();
                }
                CGNonAgeReport.reportDialogClick("2", str3, false);
            }
        });
        String str3 = "";
        if (this.mUser != null) {
            str3 = "" + this.mUser.getUserId();
        }
        CGNonAgeReport.reportDialogShow("2", str3);
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.nonage.heatbeat.CGNonAgeHeartBeater.IHeartBeatListener
    public void onHeartBeatSuccess() {
        onLoginCheckSuccess();
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.nonage.heatbeat.CGNonAgeHeartBeater.IHeartBeatListener
    public void onHeartBeatTimeout() {
        log("heartbeat time out");
        onLoginCheckFailure();
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.nonage.heatbeat.CGNonAgeHeartBeater.IHeartBeatListener
    public void onHeartBeatUserExpire() {
        log("user is expire");
        startQrActivity();
    }

    public void onLoginActivityDestroy() {
        onLoginCheckFailure();
        Runnable runnable = this.mPoolTokenCheck;
        if (runnable != null) {
            HandlerUtils.removeCallbacks(runnable);
        }
        this.mListener = null;
    }

    public void setIUIchangeListener(IUIchangeListener iUIchangeListener) {
        Log.d(TAG, "setIUIchangeListener: version = 1007");
        this.iUIchangeListener = iUIchangeListener;
    }

    public void startQrActivity() {
        boolean z16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CGNonAgeProtectModule/startQrActivity: iuChangeListener is null ? ");
        if (this.iUIchangeListener != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        Log.i(TAG, sb5.toString());
        IUIchangeListener iUIchangeListener = this.iUIchangeListener;
        if (iUIchangeListener != null) {
            iUIchangeListener.startQrActivity();
        }
    }

    public void stopHeartBeat() {
        log("stopHeartBeat");
        this.mHeatBeater.stop();
    }

    CGNonAgeProtectModule() {
        this.mLoginCheckCallback = null;
        this.mPoolTokenCheck = null;
        this.mGameId = "";
        this.mLastCheckTime = null;
        this.iUIchangeListener = null;
        this.mGson = new Gson();
        this.mUser = (CGNonageUser) this.mGson.fromJson((String) CGSharedPrefUtil.get(CGGlbConfig.getAppContext(), CGNONAGE_USER_CACHE, ""), CGNonageUser.class);
        this.mHeatBeater = new CGNonAgeHeartBeater(this);
    }

    public void getLoginQrCodeAndLoop() {
        log("getLoginQrCodeAndLoop");
        Runnable runnable = this.mPoolTokenCheck;
        if (runnable != null) {
            HandlerUtils.removeCallbacks(runnable);
        }
        this.mUser = null;
        CGNonAgeProtectRequest.getCreateToken(new CGNonAgeProtectRequest.IRequestCallback<CGNonageCreateTokenResp>() { // from class: com.tencent.gamematrix.gmcg.sdk.nonage.CGNonAgeProtectModule.1
            @Override // com.tencent.gamematrix.gmcg.sdk.nonage.net.CGNonAgeProtectRequest.IRequestCallback
            public void onError(GmCgError gmCgError) {
                CGNonAgeProtectModule.this.onLoginCheckFailure();
                CGNonAgeProtectModule.this.showDebugToast("\u83b7\u53d6\u767b\u5f55token\u5931\u8d25\uff0c\u7f51\u7edc\u6709\u95ee\u9898");
                CGNonAgeProtectModule.this.log("requestCreateToken fail errorcode = " + gmCgError.getErrorCode() + ", errormsg = " + gmCgError.getErrorMsg() + ", errordetail = " + gmCgError.getDetailErrorMsg());
                if (CGNonAgeProtectModule.this.mListener != null) {
                    CGNonAgeProtectModule.this.mListener.onBitmapFailure();
                }
            }

            @Override // com.tencent.gamematrix.gmcg.sdk.nonage.net.CGNonAgeProtectRequest.IRequestCallback
            public void onSuccess(CGNonageCreateTokenResp cGNonageCreateTokenResp) {
                final String token;
                if (cGNonageCreateTokenResp.getErrCode() != 0 && cGNonageCreateTokenResp.getStatus() != 1) {
                    CGNonAgeProtectModule.this.showDebugToast("\u83b7\u53d6\u767b\u5f55token\u5931\u8d25\uff0c\u8fd4\u56de\u72b6\u6001\u7801\u6709\u95ee\u9898");
                    CGNonAgeProtectModule.this.log("requestCreateToken fail result errcode = " + cGNonageCreateTokenResp.getErrCode() + ",result status = " + cGNonageCreateTokenResp.getStatus());
                    CGNonAgeProtectModule.this.onLoginCheckFailure();
                    return;
                }
                if (cGNonageCreateTokenResp.getErrCode() == 0 && cGNonageCreateTokenResp.getResult() == null) {
                    CGNonAgeProtectModule.this.showDebugToast("\u83b7\u53d6\u767b\u5f55token\u5931\u8d25\uff0cresult\u662f\u7a7a");
                    CGNonAgeProtectModule.this.log("requestCreateToken fail result.getErrCode() == 0 && result.getResult() == null");
                    CGNonAgeProtectModule.this.onLoginCheckFailure();
                    return;
                }
                if (cGNonageCreateTokenResp.getErrCode() != 0 && cGNonageCreateTokenResp.getStatus() == 1 && cGNonageCreateTokenResp.getData() == null) {
                    CGNonAgeProtectModule.this.showDebugToast("\u83b7\u53d6\u767b\u5f55token\u5931\u8d25\uff0cdata\u662f\u7a7a");
                    CGNonAgeProtectModule.this.log("requestCreateToken fail result.getErrCode() != 0 && result.getStatus() == 1 && result.getData() == null");
                    CGNonAgeProtectModule.this.onLoginCheckFailure();
                    return;
                }
                if (cGNonageCreateTokenResp.getErrCode() == 0) {
                    token = cGNonageCreateTokenResp.getResult().getToken();
                } else {
                    token = cGNonageCreateTokenResp.getData().getToken();
                }
                CGNonAgeProtectModule.this.log("token = " + token);
                Bitmap createQRCode = QrCodeUtils.createQRCode(CGNonAgeProtectRequest.getLoginQrCode(token), 500);
                if (CGNonAgeProtectModule.this.mListener != null) {
                    CGNonAgeProtectModule.this.mListener.onBitmapRefresh(createQRCode);
                }
                CGNonAgeProtectModule.this.mPoolTokenCheck = new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.nonage.CGNonAgeProtectModule.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CGNonAgeProtectModule.this.checkToken(token);
                    }
                };
                HandlerUtils.post(CGNonAgeProtectModule.this.mPoolTokenCheck);
            }
        });
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.nonage.heatbeat.CGNonAgeHeartBeater.IHeartBeatListener
    public void onHeartBeatTips(String str, String str2) {
    }
}
