package com.tencent.mobileqq.minigame.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.mini.appbrand.utils.ShareUtils;
import com.tencent.mobileqq.minigame.api.impl.MiniGameVAShareFragment;
import com.tencent.mobileqq.minigame.config.MiniGameVAInterceptConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.vivo.push.PushClientConstants;
import cooperation.qzone.QzoneIPCModule;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import mqq.util.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0002'(B\u0007\u00a2\u0006\u0004\b%\u0010&J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0012\u0010\u0015\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0012\u0010\u001a\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\"\u0010 \u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016R\u0018\u0010!\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/minigame/api/impl/MiniGameVAShareFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/mobileqq/mini/appbrand/utils/ShareUtils$ShareSimpleCallback;", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/wxapi/WXShareHelper$a;", "getHandler", "Landroid/os/Bundle;", "params", "", "shareGameStructMessage", "", PushClientConstants.TAG_PKG_NAME, "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "getMiniAppInfoFromPkgName", "getMiniGameAppId", "startGamePicShare", "path", "", "toSession", "startGamePicWxShare", Constants.FILE_INSTANCE_STATE, "onCreate", "", "result", "notifyShareResult", "uin", "onReceiverChoice", "onBackEvent", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "callbackScheme", "Ljava/lang/String;", "observer", "Lcom/tencent/mobileqq/wxapi/WXShareHelper$a;", "<init>", "()V", "Companion", "DefaultAsyncResult", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class MiniGameVAShareFragment extends QPublicBaseFragment implements ShareUtils.ShareSimpleCallback {
    private static final String TAG = "MiniGameVAShareFragment";
    private String callbackScheme;
    private final WXShareHelper.a observer = new WXShareHelper.a() { // from class: com.tencent.mobileqq.minigame.api.impl.w
        @Override // com.tencent.mobileqq.wxapi.WXShareHelper.a
        public final void onWXShareResp(BaseResp baseResp) {
            MiniGameVAShareFragment.observer$lambda$0(MiniGameVAShareFragment.this, baseResp);
        }
    };

    private final WeakReference<WXShareHelper.a> getHandler() {
        return new WeakReference<>(this.observer);
    }

    private final MiniAppInfo getMiniAppInfoFromPkgName(String pkgName) {
        String miniGameAppId = getMiniGameAppId(pkgName);
        if (!(miniGameAppId.length() > 0)) {
            return null;
        }
        MiniAppInfo miniAppInfo = new MiniAppInfo();
        miniAppInfo.appId = miniGameAppId;
        return miniAppInfo;
    }

    private final String getMiniGameAppId(String pkgName) {
        Map<String, MiniGameVAInterceptConfig.VAInterceptConfig> interceptConfigMap;
        MiniGameVAInterceptConfig miniGameVAInterceptConfig = (MiniGameVAInterceptConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(MiniGameVAInterceptConfig.CONFIG_ID);
        String str = "";
        if (miniGameVAInterceptConfig != null && (interceptConfigMap = miniGameVAInterceptConfig.getInterceptConfigMap()) != null) {
            for (Map.Entry<String, MiniGameVAInterceptConfig.VAInterceptConfig> entry : interceptConfigMap.entrySet()) {
                if (TextUtils.equals(pkgName, entry.getValue().getGameAppPkgName())) {
                    str = entry.getKey();
                }
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void observer$lambda$0(MiniGameVAShareFragment this$0, BaseResp baseResp) {
        boolean z16;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i(TAG, 1, "onWxShareResult: " + baseResp);
        WXShareHelper.b0().q0(this$0.getHandler().get());
        String str = this$0.callbackScheme;
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (z16) {
                    Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
                    intent.setData(Uri.parse(str));
                    intent.addFlags(268435456);
                    QLog.i(TAG, 1, "onWxShareResult, start callback scheme=" + str);
                    BaseApplication.getContext().startActivity(intent);
                    return;
                }
                return;
            }
        }
        z16 = true;
        if (z16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onReceiverChoice$lambda$3(MiniGameVAShareFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void shareGameStructMessage(Bundle params) {
        String string = params.getString("type", "qq");
        String string2 = params.getString("title", "");
        String pkgName = params.getString(PushClientConstants.TAG_PKG_NAME, "");
        String string3 = params.getString("path", "");
        String string4 = params.getString("desc", "");
        String string5 = params.getString(WadlProxyConsts.KEY_JUMP_URL, "");
        this.callbackScheme = params.getString("callback_scheme", "");
        if (string != null) {
            int hashCode = string.hashCode();
            if (hashCode != -791770330) {
                if (hashCode != -706272223) {
                    if (hashCode == 3616 && string.equals("qq")) {
                        Intrinsics.checkNotNullExpressionValue(pkgName, "pkgName");
                        MiniAppInfo miniAppInfoFromPkgName = getMiniAppInfoFromPkgName(pkgName);
                        if (miniAppInfoFromPkgName == null) {
                            QLog.d(TAG, 1, "shareGameStructMessage miniAppInfo null pkgName" + pkgName);
                            FragmentActivity activity = getActivity();
                            if (activity != null) {
                                activity.finish();
                                return;
                            }
                            return;
                        }
                        InnerShareData build = new InnerShareData.Builder().setFromActivity(getActivity()).setMiniAppInfo(miniAppInfoFromPkgName).setShareTarget(0).setTitle(string2).setSummary(string4).setSharePicPath(string3).setTargetUrl(string5).build();
                        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n              \u2026                 .build()");
                        ShareUtils.shareGameStructMsgToQQ(getActivity(), build, new DefaultAsyncResult(getActivity()));
                        return;
                    }
                } else if (string.equals("wxmoment")) {
                    WXShareHelper.b0().A(this.observer);
                    ShareUtils.startLinkToWeChat(getActivity(), string2, string4, string3, string5, false);
                    FragmentActivity activity2 = getActivity();
                    if (activity2 != null) {
                        activity2.finish();
                        return;
                    }
                    return;
                }
            } else if (string.equals("wechat")) {
                WXShareHelper.b0().A(this.observer);
                ShareUtils.startLinkToWeChat(getActivity(), string2, string4, string3, string5, true);
                FragmentActivity activity3 = getActivity();
                if (activity3 != null) {
                    activity3.finish();
                    return;
                }
                return;
            }
        }
        QLog.e(TAG, 1, "shareGameStructMessage not support share type=" + string);
        FragmentActivity activity4 = getActivity();
        if (activity4 != null) {
            activity4.finish();
        }
    }

    private final void startGamePicShare(Bundle params) {
        FragmentActivity activity;
        String path = params.getString("path", "");
        String string = params.getString("type", "");
        params.getString("shareData", "");
        String pkgName = params.getString(PushClientConstants.TAG_PKG_NAME, "");
        this.callbackScheme = params.getString("callback_scheme", "");
        boolean z16 = true;
        if (string != null) {
            int hashCode = string.hashCode();
            if (hashCode != -791770330) {
                if (hashCode != -706272223) {
                    if (hashCode != 3616) {
                        if (hashCode == 108102557 && string.equals("qzone")) {
                            ShareUtils.startSharePicToQzone(getActivity(), path, "");
                        }
                    } else if (string.equals("qq")) {
                        FragmentActivity activity2 = getActivity();
                        Intrinsics.checkNotNullExpressionValue(pkgName, "pkgName");
                        ShareUtils.shareGamePicWithTail2QQ(activity2, getMiniGameAppId(pkgName), path, this);
                        z16 = false;
                    }
                } else if (string.equals("wxmoment")) {
                    Intrinsics.checkNotNullExpressionValue(path, "path");
                    startGamePicWxShare(path, false);
                }
            } else if (string.equals("wechat")) {
                Intrinsics.checkNotNullExpressionValue(path, "path");
                startGamePicWxShare(path, true);
            }
            if (z16 || (activity = getActivity()) == null) {
            }
            activity.finish();
            return;
        }
        QLog.e(TAG, 1, "do not support share type=" + string);
        if (z16) {
        }
    }

    private final void startGamePicWxShare(String path, boolean toSession) {
        WXShareHelper.b0().A(this.observer);
        ShareUtils.startSharePicToWeChat(getActivity(), path, toSession);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.mini.appbrand.utils.ShareUtils.ShareSimpleCallback
    public void notifyShareResult(int result) {
        QLog.i(TAG, 1, "notifyShareResult " + result);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            Object obj = arguments.get("shareMethod");
            if (Intrinsics.areEqual(obj, "shareGamePicture")) {
                startGamePicShare(arguments);
            } else if (Intrinsics.areEqual(obj, "shareGameStructMessage")) {
                shareGameStructMessage(arguments);
            }
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.mini.appbrand.utils.ShareUtils.ShareSimpleCallback
    public void onReceiverChoice(String uin) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.minigame.api.impl.v
            @Override // java.lang.Runnable
            public final void run() {
                MiniGameVAShareFragment.onReceiverChoice$lambda$3(MiniGameVAShareFragment.this);
            }
        });
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/minigame/api/impl/MiniGameVAShareFragment$DefaultAsyncResult;", "Lcom/tencent/qqmini/sdk/launcher/core/proxy/AsyncResult;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "activityRef", "Lmqq/util/WeakReference;", "onReceiveResult", "", "isSuccess", "", "resultJson", "Lorg/json/JSONObject;", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class DefaultAsyncResult implements AsyncResult {
        private static final String TAG = "MiniGameVAShareFragment.DefaultAsyncResult";
        private final WeakReference<Activity> activityRef;

        public DefaultAsyncResult(Activity activity) {
            this.activityRef = new WeakReference<>(activity);
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
        public void onReceiveResult(boolean isSuccess, JSONObject resultJson) {
            QLog.d(TAG, 1, "shareGameStructMessage isSuccess:" + isSuccess + ", resultJson:" + resultJson);
            final Activity activity = this.activityRef.get();
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.minigame.api.impl.x
                @Override // java.lang.Runnable
                public final void run() {
                    MiniGameVAShareFragment.DefaultAsyncResult.onReceiveResult$lambda$0(activity);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onReceiveResult$lambda$0(Activity activity) {
            if (activity != null) {
                activity.finish();
            }
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1011 && resultCode == 0) {
            QLog.i(TAG, 1, "share game pic with tail on act result canceled");
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }
}
