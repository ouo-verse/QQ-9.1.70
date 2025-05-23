package com.tencent.mobileqq.mini.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.open.inner.auth.QQAuth;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0005\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/mini/ui/MainProcessLoadingFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "()V", "openListener", "com/tencent/mobileqq/mini/ui/MainProcessLoadingFragment$openListener$1", "Lcom/tencent/mobileqq/mini/ui/MainProcessLoadingFragment$openListener$1;", "buildAuthParamFromReqData", "Lcom/tencent/open/inner/auth/QQAuth$AuthParams;", "jsonString", "", "onActivityResult", "", "requestCode", "", QzoneIPCModule.RESULT_CODE, "data", "Landroid/content/Intent;", "onCreate", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MainProcessLoadingFragment extends QPublicBaseFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int ERR_CODE_DEFAULT = -1;
    private static final String ERR_MSG_DEFAULT = "unknown error";
    private static final String RET_KEY_CODE = "proxyAuthCode";
    private static MiniAppCmdInterface callback;
    private final MainProcessLoadingFragment$openListener$1 openListener = new wp3.b() { // from class: com.tencent.mobileqq.mini.ui.MainProcessLoadingFragment$openListener$1
        private final void authFailed(int retCode, String errMsg) {
            MiniAppCmdInterface callback2 = MainProcessLoadingFragment.INSTANCE.getCallback();
            if (callback2 != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("retCode", retCode);
                Unit unit = Unit.INSTANCE;
                callback2.onCmdListener(false, jSONObject);
            }
        }

        private final void authSucceed(String proxyAuthCode) {
            MiniAppCmdInterface callback2 = MainProcessLoadingFragment.INSTANCE.getCallback();
            if (callback2 != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("proxyAuthCode", proxyAuthCode);
                Unit unit = Unit.INSTANCE;
                callback2.onCmdListener(true, jSONObject);
            }
        }

        @Override // wp3.b
        public void onCancel() {
            QMLog.e(wp3.b.TAG, "onCancel");
            authFailed$default(this, 0, "Authorize canceled", 1, null);
        }

        @Override // wp3.b
        public void onComplete(Object response) {
            QMLog.i(wp3.b.TAG, "onComplete: rsp=" + response);
            if (response instanceof JSONObject) {
                String authCode = ((JSONObject) response).optString("proxy_code");
                if (!(authCode == null || authCode.length() == 0)) {
                    Intrinsics.checkNotNullExpressionValue(authCode, "authCode");
                    authSucceed(authCode);
                    return;
                }
            }
            authFailed$default(this, 0, "Authorize completed but proxy_code is empty", 1, null);
        }

        @Override // wp3.b
        public void onError(wp3.a e16) {
            Intrinsics.checkNotNullParameter(e16, "e");
            QMLog.e(wp3.b.TAG, "onError: errCode=" + e16.f446029a + ", errMsg=" + e16.f446030b);
            authFailed(e16.f446029a, e16.f446030b);
        }

        @Override // wp3.b
        public void onWarning(int code) {
            QMLog.e(wp3.b.TAG, "onWarning: code=" + code);
            authFailed$default(this, code, null, 2, null);
        }

        static /* synthetic */ void authFailed$default(MainProcessLoadingFragment$openListener$1 mainProcessLoadingFragment$openListener$1, int i3, String str, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                i3 = -1;
            }
            if ((i16 & 2) != 0) {
                str = "unknown error";
            }
            mainProcessLoadingFragment$openListener$1.authFailed(i3, str);
        }
    };

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/mini/ui/MainProcessLoadingFragment$Companion;", "", "()V", "ERR_CODE_DEFAULT", "", "ERR_MSG_DEFAULT", "", "RET_KEY_CODE", "callback", "Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;", "getCallback", "()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;", IECSearchBar.METHOD_SET_CALLBACK, "(Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MiniAppCmdInterface getCallback() {
            return MainProcessLoadingFragment.callback;
        }

        public final void setCallback(MiniAppCmdInterface miniAppCmdInterface) {
            MainProcessLoadingFragment.callback = miniAppCmdInterface;
        }

        Companion() {
        }
    }

    private final QQAuth.AuthParams buildAuthParamFromReqData(String jsonString) {
        Bundle bundle;
        if (jsonString == null || jsonString.length() == 0) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(jsonString);
            String appId = jSONObject.getString("appId");
            String proxyAppId = jSONObject.getString("proxyAppId");
            String proxyAppName = jSONObject.getString("proxyAppName");
            String permissions = jSONObject.getString("permissions");
            Intrinsics.checkNotNullExpressionValue(appId, "appId");
            if (!(appId.length() == 0)) {
                Intrinsics.checkNotNullExpressionValue(proxyAppId, "proxyAppId");
                if (!(proxyAppId.length() == 0)) {
                    Intrinsics.checkNotNullExpressionValue(proxyAppName, "proxyAppName");
                    if (!(proxyAppName.length() == 0)) {
                        Intrinsics.checkNotNullExpressionValue(permissions, "permissions");
                        if (!(permissions.length() == 0)) {
                            String base64EncodeNoWrap = QQAuth.AuthParams.base64EncodeNoWrap(jSONObject.optString("clientage_token"));
                            if (TextUtils.isEmpty(base64EncodeNoWrap)) {
                                bundle = null;
                            } else {
                                Bundle bundle2 = new Bundle();
                                bundle2.putString("key_proxy_token", base64EncodeNoWrap);
                                bundle = bundle2;
                            }
                            return new QQAuth.AuthParams(proxyAppId, appId, proxyAppName, permissions, bundle);
                        }
                    }
                }
            }
            return null;
        } catch (JSONException e16) {
            QMLog.e(QPublicBaseFragment.TAG, "buildAuthParamFromReqData failed ---> ", e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        onActivityResult(requestCode, resultCode, data);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QQAuth.AuthParams buildAuthParamFromReqData = buildAuthParamFromReqData(requireActivity().getIntent().getStringExtra("data"));
        if (buildAuthParamFromReqData == null) {
            MiniAppCmdInterface miniAppCmdInterface = callback;
            if (miniAppCmdInterface != null) {
                miniAppCmdInterface.onCmdListener(false, new JSONObject());
            }
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        QQAuth.getInstance().proxyAuth(getActivity(), this.openListener, buildAuthParamFromReqData);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
