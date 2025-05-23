package com.tencent.qqmini.sdk.core.proxy.service;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.AuthJsProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.AuthDetailDialog;
import com.tencent.qqmini.sdk.widget.AuthDialog;
import org.json.JSONObject;

/* compiled from: P */
@ProxyService(proxy = AuthJsProxy.class)
/* loaded from: classes23.dex */
public class a extends AuthJsProxy {

    /* renamed from: a, reason: collision with root package name */
    protected AuthJsProxy.AuthDialogResConfig f348059a;

    /* renamed from: b, reason: collision with root package name */
    private AuthDialog f348060b;

    /* renamed from: c, reason: collision with root package name */
    private Bundle f348061c;

    /* renamed from: d, reason: collision with root package name */
    private DialogInterface.OnDismissListener f348062d;

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AuthJsProxy
    public void dismissAuthDialog() {
        QMLog.d("AuthJsProxyDefault", "dismissAuthDialog:" + this.f348060b);
        AuthDialog authDialog = this.f348060b;
        if (authDialog != null && authDialog.isShowing()) {
            this.f348060b.dismiss();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AuthJsProxy
    public Bundle getAuthDialogBundleData() {
        AuthDialog authDialog = this.f348060b;
        if (authDialog != null) {
            return authDialog.getData();
        }
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AuthJsProxy
    public AuthJsProxy.AuthDialogResConfig getAuthDialogResConfig() {
        return this.f348059a;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AuthJsProxy
    public int getAuthDialogType() {
        AuthDialog authDialog = this.f348060b;
        if (authDialog != null) {
            return authDialog.getAuthDialogType();
        }
        return 1;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AuthJsProxy
    public JSONObject getSelectPhoneNumber() {
        try {
            AuthJsProxy.AuthDialogResConfig authDialogResConfig = this.f348059a;
            if (authDialogResConfig != null && authDialogResConfig.phoneNumberList.length() > 0) {
                return this.f348059a.phoneNumberList.optJSONObject(r0.length() - 1);
            }
            return null;
        } catch (Throwable th5) {
            QMLog.e("AuthJsProxyDefault", "getSelectPhoneNumber error,", th5);
            return null;
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AuthJsProxy
    public void initAuthDialog(@NonNull Activity activity, AuthJsProxy.AuthDialogResConfig authDialogResConfig) {
        QMLog.d("AuthJsProxyDefault", "initAuthDialog" + authDialogResConfig.dialogType);
        this.f348059a = authDialogResConfig;
        authDialogResConfig.dialogType = 1;
        this.f348060b = new AuthDialog(activity, authDialogResConfig.miniAppContext, this.f348059a.dialogType);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AuthJsProxy
    public boolean isAuthConfirm() {
        AuthDialog authDialog = this.f348060b;
        if (authDialog != null) {
            return authDialog.isConfirm();
        }
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AuthJsProxy
    public boolean isAuthDialogInit() {
        if (this.f348060b != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AuthJsProxy
    public boolean isAuthDialogNotNull() {
        if (this.f348060b != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AuthJsProxy
    public boolean isAuthDialogShow() {
        AuthDialog authDialog = this.f348060b;
        if (authDialog != null && authDialog.isShowing()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AuthJsProxy
    public boolean isAuthRefuse() {
        AuthDialog authDialog = this.f348060b;
        if (authDialog != null) {
            return authDialog.isRefuse();
        }
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AuthJsProxy
    public void reportMiniAppEvent(String str) {
        if (this.f348060b == null) {
            return;
        }
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1367724422:
                if (str.equals("cancel")) {
                    c16 = 0;
                    break;
                }
                break;
            case 3127794:
                if (str.equals("expo")) {
                    c16 = 1;
                    break;
                }
                break;
            case 94750088:
                if (str.equals("click")) {
                    c16 = 2;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                this.f348060b.reportAuthDialogCancelTo4239();
                return;
            case 1:
                this.f348060b.reportAuthDialogExpoTo4239();
                return;
            case 2:
                this.f348060b.reportAuthDialogClickTo4239();
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AuthJsProxy
    public void setAuthDialogBundleData(Bundle bundle) {
        this.f348061c = bundle;
        AuthDialog authDialog = this.f348060b;
        if (authDialog != null) {
            authDialog.bindData(bundle);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AuthJsProxy
    public void setAuthDialogToNull() {
        this.f348060b = null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AuthJsProxy
    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.f348062d = onDismissListener;
        AuthDialog authDialog = this.f348060b;
        if (authDialog != null) {
            authDialog.setOnDismissListener(onDismissListener);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AuthJsProxy
    public void showAuthDialog(AuthJsProxy.AuthDialogResConfig authDialogResConfig) {
        QMLog.d("AuthJsProxyDefault", "showAuthDialog" + authDialogResConfig.dialogType);
        this.f348059a = authDialogResConfig;
        authDialogResConfig.dialogType = 1;
        AuthDialog.AuthDialogResBuilder authDialogResBuilder = new AuthDialog.AuthDialogResBuilder();
        authDialogResBuilder.setMiniAppIconUrl(authDialogResConfig.miniAppIconUrl).setMiniAppName(authDialogResConfig.miniAppName).setAuthTitle(authDialogResConfig.authTitle).setAuthDesc(authDialogResConfig.authDesc).setReportSubAction(authDialogResConfig.reportSubAction).setMiniAppInfo(authDialogResConfig.miniAppInfo).setLeftBtnText(authDialogResConfig.leftBtnText).setEventName(authDialogResConfig.eventName).setLeftBtnClickListener(authDialogResConfig.leftBtnClickListener).setRightBtnText(authDialogResConfig.rightBtnText).setRightBtnClickListener(authDialogResConfig.rightBtnClickListener);
        authDialogResBuilder.setPhoneNumberList(authDialogResConfig.phoneNumberList);
        AuthDialog authDialog = this.f348060b;
        if (authDialog != null) {
            DialogInterface.OnDismissListener onDismissListener = this.f348062d;
            if (onDismissListener != null) {
                authDialog.setOnDismissListener(onDismissListener);
            }
            Bundle bundle = this.f348061c;
            if (bundle != null) {
                this.f348060b.bindData(bundle);
            }
            this.f348060b.setCanceledOnTouchOutside(authDialogResConfig.canceledOnTouchOutside);
            this.f348060b.show(authDialogResBuilder);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AuthJsProxy
    public void showAuthListViewHintDialog(@NonNull Activity activity, AuthJsProxy.AuthDetailDialogResConfig authDetailDialogResConfig) {
        if (activity != null && !activity.isFinishing()) {
            new AuthDetailDialog(activity, authDetailDialogResConfig.curSubMsg, authDetailDialogResConfig.requestHeight, authDetailDialogResConfig.requestWidth, authDetailDialogResConfig.dialogType).show();
            return;
        }
        QMLog.e("AuthJsProxyDefault", "showAuthListViewHintDialog activity:" + activity);
    }
}
