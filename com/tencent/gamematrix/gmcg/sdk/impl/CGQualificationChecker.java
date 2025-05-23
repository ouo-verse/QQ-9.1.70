package com.tencent.gamematrix.gmcg.sdk.impl;

import androidx.annotation.NonNull;
import com.tencent.gamematrix.gmcg.api.GmCgAuthParamProvider;
import com.tencent.gamematrix.gmcg.api.GmCgAuthRefreshListener;
import com.tencent.gamematrix.gmcg.api.GmCgError;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.gamematrix.gmcg.base.utils.CGFileUtil;
import com.tencent.gamematrix.gmcg.base.utils.CGStringUtil;
import com.tencent.gamematrix.gmcg.sdk.config.CGGlbConfig;
import com.tencent.gamematrix.gmcg.sdk.service.CGAllocDeviceInfo;
import com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService;
import com.tencent.gamematrix.gmcg.sdk.service.CGHoldDeviceResp;
import com.tencent.gamematrix.gmcg.sdk.service.CGInitAuthResp;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGQualificationChecker implements GmCgAuthParamProvider {
    private GmCgAuthRefreshListener mAuthRefreshListener;
    private CGBizHttpService mBizHttpService;
    private CGQualificationCheckResultListener mCheckResultListener;
    private boolean mQualificationForAction;
    private boolean mShouldCheckVip;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface CGCheckRunningOnSameDeviceResult {
        void onCheckRunningOnSameDeviceResult(boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface CGQualificationCheckResultListener {
        void onCGQualificationCheckResult(@NonNull GmCgError gmCgError);
    }

    public CGQualificationChecker() {
    }

    private void checkAuthTokenValid() {
        this.mBizHttpService.requestCheckAuthValid(new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.du
            @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
            public final void onResult(GmCgError gmCgError, Object obj) {
                CGQualificationChecker.this.lambda$checkAuthTokenValid$1(gmCgError, (CGInitAuthResp) obj);
            }
        });
    }

    private void checkQualificationOfAuth() {
        if (CGStringUtil.isEmpty(CGGlbConfig.getGmCgToken())) {
            tryGetTokenIfAuthInvalid(false);
        } else {
            checkAuthTokenValid();
        }
    }

    private void checkQualificationOfDevicePerformance() {
        if (!hasEnoughInternalStorage()) {
            onQualificationCheckFail(GmCgError.ErrorDeviceInsufficientStorage);
        }
    }

    private void checkQualificationOfIfOnSameDevice(final CGCheckRunningOnSameDeviceResult cGCheckRunningOnSameDeviceResult) {
        this.mBizHttpService.requestGetMyDevices(new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.dt
            @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
            public final void onResult(GmCgError gmCgError, Object obj) {
                CGQualificationChecker.this.lambda$checkQualificationOfIfOnSameDevice$3(cGCheckRunningOnSameDeviceResult, gmCgError, (CGHoldDeviceResp) obj);
            }
        });
    }

    private boolean checkVipQualificationFail(CGInitAuthResp cGInitAuthResp) {
        if (this.mShouldCheckVip && cGInitAuthResp != null && !cGInitAuthResp.vip) {
            return true;
        }
        return false;
    }

    private void doRequestInitAndAuth() {
        this.mBizHttpService.requestInitAndAuth(new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.ds
            @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
            public final void onResult(GmCgError gmCgError, Object obj) {
                CGQualificationChecker.this.lambda$doRequestInitAndAuth$2(gmCgError, (CGInitAuthResp) obj);
            }
        }, "checker");
    }

    private boolean hasEnoughInternalStorage() {
        long j3;
        if (CGGlbConfig.isForTV()) {
            j3 = GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_FOR_TV;
        } else {
            j3 = GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT;
        }
        if (CGFileUtil.getAvailableInternalMemorySize() >= j3) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$check$0(boolean z16) {
        if (z16) {
            checkQualificationOfAuth();
        } else {
            onQualificationCheckFail(GmCgError.ErrorNotAllowedToRunOnMultiDevice);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkAuthTokenValid$1(GmCgError gmCgError, CGInitAuthResp cGInitAuthResp) {
        if (GmCgError.isOK(gmCgError)) {
            if (checkVipQualificationFail(cGInitAuthResp)) {
                tryGetTokenIfAuthInvalid(true);
                return;
            } else {
                onQualificationCheckOk();
                return;
            }
        }
        tryGetTokenIfAuthInvalid(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkQualificationOfIfOnSameDevice$3(CGCheckRunningOnSameDeviceResult cGCheckRunningOnSameDeviceResult, GmCgError gmCgError, CGHoldDeviceResp cGHoldDeviceResp) {
        boolean z16;
        if (GmCgError.isOK(gmCgError)) {
            z16 = userDeviceInfoIsMatch(cGHoldDeviceResp.devices);
        } else {
            z16 = false;
        }
        if (cGCheckRunningOnSameDeviceResult != null) {
            cGCheckRunningOnSameDeviceResult.onCheckRunningOnSameDeviceResult(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doRequestInitAndAuth$2(GmCgError gmCgError, CGInitAuthResp cGInitAuthResp) {
        if (GmCgError.isOK(gmCgError)) {
            CGGlbConfig.setGmCgToken(cGInitAuthResp.token);
            onQualificationCheckOk();
        } else {
            onQualificationCheckFail(gmCgError);
        }
    }

    private void onQualificationCheckFail(@NonNull GmCgError gmCgError) {
        CGQualificationCheckResultListener cGQualificationCheckResultListener = this.mCheckResultListener;
        if (cGQualificationCheckResultListener != null) {
            cGQualificationCheckResultListener.onCGQualificationCheckResult(gmCgError);
        }
    }

    private void onQualificationCheckOk() {
        CGQualificationCheckResultListener cGQualificationCheckResultListener = this.mCheckResultListener;
        if (cGQualificationCheckResultListener != null) {
            cGQualificationCheckResultListener.onCGQualificationCheckResult(GmCgError.OK());
        }
    }

    private void tryGetTokenIfAuthInvalid(boolean z16) {
        GmCgAuthRefreshListener gmCgAuthRefreshListener = this.mAuthRefreshListener;
        if (gmCgAuthRefreshListener != null) {
            gmCgAuthRefreshListener.onGmCgAuthRefresh(this);
        } else if (z16) {
            onQualificationCheckFail(GmCgError.ErrorUserIsNotVip);
        } else {
            onQualificationCheckFail(GmCgError.ErrorInvalidToken);
        }
    }

    private boolean userDeviceInfoIsMatch(List<CGAllocDeviceInfo> list) {
        if (list != null && list.size() > 0) {
            Iterator<CGAllocDeviceInfo> it = list.iterator();
            while (it.hasNext()) {
                if (!CGGlbConfig.getLocalUserDeviceInfo().isMatch(it.next().userDeviceInfo)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public void check(CGBizHttpService cGBizHttpService, @NonNull CGQualificationCheckResultListener cGQualificationCheckResultListener) {
        this.mBizHttpService = cGBizHttpService;
        check(cGQualificationCheckResultListener);
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgAuthParamProvider
    public void onGmCgProvideAuthParam(String str, String str2) {
        if (CGStringUtil.notEmpty(str) && CGStringUtil.notEmpty(str2)) {
            CGGlbConfig.setLoginInfo(CGGlbConfig.getBizId(), str, str2, CGGlbConfig.getServerType());
            doRequestInitAndAuth();
        } else {
            onQualificationCheckFail(GmCgError.ErrorParamsWrong);
        }
    }

    public void setAuthRefreshListener(GmCgAuthRefreshListener gmCgAuthRefreshListener) {
        this.mAuthRefreshListener = gmCgAuthRefreshListener;
    }

    public void shouldCheckVip(boolean z16) {
        this.mShouldCheckVip = z16;
    }

    public CGQualificationChecker(boolean z16) {
        this(z16, false);
    }

    public CGQualificationChecker(boolean z16, boolean z17) {
        this();
        this.mQualificationForAction = z16;
        this.mShouldCheckVip = z17;
    }

    public void check(@NonNull CGQualificationCheckResultListener cGQualificationCheckResultListener) {
        this.mCheckResultListener = cGQualificationCheckResultListener;
        if (this.mBizHttpService == null) {
            this.mBizHttpService = new CGBizHttpService();
        }
        if (this.mQualificationForAction) {
            checkQualificationOfDevicePerformance();
            if (CGGlbConfig.isCgSSOEnabled()) {
                checkQualificationOfIfOnSameDevice(new CGCheckRunningOnSameDeviceResult() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.dr
                    @Override // com.tencent.gamematrix.gmcg.sdk.impl.CGQualificationChecker.CGCheckRunningOnSameDeviceResult
                    public final void onCheckRunningOnSameDeviceResult(boolean z16) {
                        CGQualificationChecker.this.lambda$check$0(z16);
                    }
                });
                return;
            } else {
                checkQualificationOfAuth();
                return;
            }
        }
        checkQualificationOfAuth();
    }
}
