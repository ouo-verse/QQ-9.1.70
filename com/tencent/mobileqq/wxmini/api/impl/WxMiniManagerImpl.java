package com.tencent.mobileqq.wxmini.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.luggage.wxaapi.PreloadWxaProcessEnvResult;
import com.tencent.luggage.wxaapi.TdiAuthState;
import com.tencent.luggage.wxaapi.g;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityBehind;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.parser.bo;
import com.tencent.mobileqq.loginregister.IAccountBindingApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.mobileqq.wxmini.api.data.LauncherWxaState;
import com.tencent.mobileqq.wxmini.api.data.d;
import com.tencent.mobileqq.wxmini.impl.account.e;
import com.tencent.mobileqq.wxmini.impl.launcher.WxaInfo;
import com.tencent.mobileqq.wxmini.impl.launcher.WxaLauncher;
import com.tencent.mobileqq.wxmini.impl.ui.PreloadingFragment;
import com.tencent.mobileqq.wxmini.impl.util.WxaInfoObtainUtil;
import com.tencent.mobileqq.wxmini.impl.util.h;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.util.UiThreadUtil;
import common.config.service.QzoneConfig;
import fb3.i;
import hb3.f;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.IAccountCallback;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes35.dex */
public class WxMiniManagerImpl implements IWxMiniManager, IAccountCallback {
    private static final String ILINK_PROCESS = "com.tencent.ilink.ServiceProcess";
    private static final String PREFIX_WXA_URL = "https://mp.weixin.qq.com/a/";
    private static final String TAG = "[wxa-q]WxMiniManagerImpl";
    private static final String WXA_CONTAINER_PROCESS_KEY = "wxa_container";
    private static final int WX_APP_TYPE_DEV = 1;
    private static final int WX_APP_TYPE_EXPERIENCE = 2;
    private static final int WX_APP_TYPE_RELEASE = 0;
    private static final String WX_CODE = "WX_CODE";

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a implements com.tencent.mobileqq.wxmini.api.data.c {
        a() {
        }

        @Override // com.tencent.mobileqq.wxmini.api.data.c
        public void a(d dVar) {
            QLog.i(WxMiniManagerImpl.TAG, 1, "onLogout bind success");
        }

        @Override // com.tencent.mobileqq.wxmini.api.data.c
        public void onFail(int i3) {
            QLog.i(WxMiniManagerImpl.TAG, 1, "onLogout bind failed");
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class b implements f.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.wxmini.api.data.b f327631a;

        b(com.tencent.mobileqq.wxmini.api.data.b bVar) {
            this.f327631a = bVar;
        }

        @Override // hb3.f.b
        public void a(boolean z16, String str) {
            if (this.f327631a != null) {
                Bundle bundle = new Bundle();
                bundle.putString("message", str);
                this.f327631a.onCallback(z16, bundle);
            }
        }
    }

    private boolean isWxMiniAppEnable() {
        return QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.WX_MINIAPP_EABLE, 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$clearWxMiniAppCache$1() {
        BaseApplication context = BaseApplication.getContext();
        i.w().b0();
        h.a(context);
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public void attachBaseContext(Context context) {
        i.F();
        fb3.b.c();
        QLog.e(TAG, 1, "attachBaseContext");
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public boolean checkDynamicPackage() {
        return f.h().e();
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public void checkWxAuthed(final com.tencent.mobileqq.wxmini.api.data.b bVar) {
        i.w().r(new com.tencent.luggage.wxaapi.h() { // from class: com.tencent.mobileqq.wxmini.api.impl.c
            @Override // com.tencent.luggage.wxaapi.h
            public final void onStateChecked(TdiAuthState tdiAuthState, String str) {
                WxMiniManagerImpl.lambda$checkWxAuthed$2(com.tencent.mobileqq.wxmini.api.data.b.this, tdiAuthState, str);
            }
        });
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public void clearWxMiniAppCache() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wxmini.api.impl.b
            @Override // java.lang.Runnable
            public final void run() {
                WxMiniManagerImpl.lambda$clearWxMiniAppCache$1();
            }
        }, 64, null, true);
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public d getBindingWeChatUserInfo() {
        return getBindingWeChatUserInfoWithAccount("");
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public d getBindingWeChatUserInfoWithAccount(String str) {
        String a16 = com.tencent.mobileqq.wxmini.impl.account.h.a(str);
        if (!TextUtils.isEmpty(a16)) {
            try {
                d dVar = new d();
                JSONObject jSONObject = new JSONObject(a16);
                dVar.j(jSONObject.getInt("key_wx_account_type"));
                dVar.k(jSONObject.optString("key_wx_account_app_id"));
                dVar.m(jSONObject.optString("key_wx_account_code"));
                dVar.q(jSONObject.getString("key_wx_account_union_id"));
                dVar.p(jSONObject.getString("key_wx_account_open_id"));
                dVar.o(jSONObject.getString("key_wx_account_nick_name"));
                dVar.n(jSONObject.getString("key_wx_account_head_image_url"));
                dVar.l(jSONObject.getBoolean("key_wx_account_is_bound"));
                dVar.r(jSONObject.optString("key_wx_account_wx_func_token"));
                QLog.d(TAG, 1, "getBindingWeChatUserInfo thirdAccountInfo: " + dVar);
                return dVar;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "getBindingWeChatUserInfo JSONException error!", e16);
                return null;
            }
        }
        QLog.d(TAG, 1, "getBindingWeChatUserInfo thirdAccountInfo is null!");
        return null;
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public String getSDKVersion() {
        return i.w().z();
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public int getVersionTypeFromScheme(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "getVersionTypeFromScheme url is empty!");
            return 0;
        }
        QMLog.d(TAG, "getVersionTypeFromScheme url: " + str);
        if (str.contains("_vt=3")) {
            return 0;
        }
        if (str.contains("_vt=4")) {
            return 1;
        }
        return str.contains("_vt=1") ? 2 : 0;
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public Class<?> getWXMiniEntryClass() {
        return null;
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public Class<?> getWxBindJumpClass() {
        return bo.class;
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public void handleWXEntryActivityIntent(Activity activity, Intent intent) {
        try {
            i.w().C(activity, intent);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "fail to handle wx entry intent", e16);
        }
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public boolean hasRecentShowWxMiniTipInfo() {
        return fb3.b.c().d() != null;
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public void initApi() {
        QLog.d(TAG, 1, "initApi, cost: ", Long.valueOf(System.currentTimeMillis() - System.currentTimeMillis()));
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public boolean isWxCodeType(String str) {
        return WX_CODE.equals(str);
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public boolean isWxMiniApp(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(PREFIX_WXA_URL);
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public void loadDynamicPackage(com.tencent.mobileqq.wxmini.api.data.b bVar) {
        f.h().o(bVar);
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public void login(String str, com.tencent.mobileqq.wxmini.api.data.b bVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("ret_code", -1);
        bundle.putString("ret_message", "");
        bundle.putString("code", "function deprecated.");
        bVar.onCallback(false, bundle);
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public void onLogout(int i3) {
        onLogout(Constants.LogoutReason.user, i3);
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public void openWxBindingPage() {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        ((IAccountBindingApi) QRoute.api(IAccountBindingApi.class)).startAccountBindFragment(MobileQQ.sMobileQQ, intent);
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public void preCheckWxaPackages(com.tencent.mobileqq.wxmini.api.data.b bVar) {
        boolean e16 = f.h().e();
        QLog.i(TAG, 1, "preCheckWxaPackages isReady:" + e16);
        if (!e16) {
            f.h().g(new b(bVar));
        } else if (bVar != null) {
            bVar.onCallback(true, new Bundle());
        }
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public void preloadProcessEnv(final boolean z16) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wxmini.api.impl.WxMiniManagerImpl.6

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.wxmini.api.impl.WxMiniManagerImpl$6$a */
            /* loaded from: classes35.dex */
            class a implements g {
                a() {
                }

                @Override // com.tencent.luggage.wxaapi.g
                public void onPreloadResult(PreloadWxaProcessEnvResult preloadWxaProcessEnvResult) {
                    QLog.d(WxMiniManagerImpl.TAG, 2, "preloadProcessEnv result:" + preloadWxaProcessEnvResult);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                WxaLauncher.Y(z16 ? 2 : 1, new a());
            }
        }, 16, null, false);
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public void requestPayment(String str, long j3, String str2, String str3, String str4, String str5, com.tencent.mobileqq.wxmini.api.data.b bVar) {
        bVar.onCallback(false, new Bundle());
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public int resetQQMiniAppVtToWxMiniAppVt(int i3) {
        if (i3 != 1) {
            if (i3 == 4) {
                return 1;
            }
            return 0;
        }
        return 2;
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public void restartRecentShowWxMiniTipInfo() {
        WxaInfo d16 = fb3.b.c().d();
        i.w().O(BaseApplication.getContext(), d16.getCom.tencent.util.QQCustomArkDialogUtil.META_DATA java.lang.String(), d16.getVersionType(), d16.getPath(), d16.getScene(), null, new HashMap<>());
        fb3.b.c().k(null);
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public void sendWxAccountUnBindRequest(com.tencent.mobileqq.wxmini.api.data.c cVar) {
        e.e().l(cVar);
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public void sendWxAuthEvent(Context context, int i3) {
        if (isWxMiniAppEnable()) {
            Intent intent = new Intent();
            intent.putExtra("start_mode", 6);
            intent.putExtra("auth_source", i3);
            startActivity(context, intent);
        }
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public void setIsDebugIP(boolean z16) {
        i.w().Z(z16);
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public void startWxMiniAppByAppId(Context context, String str, String str2, int i3) {
        startWxMiniAppByAppId(context, str, str2, i3, 0);
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public void startWxMiniAppByAppIdWithCallback(Context context, String str, String str2, int i3, final com.tencent.mobileqq.wxmini.api.data.b bVar) {
        Intent intent = new Intent();
        intent.putExtra("start_mode", 0);
        intent.putExtra("app_id", str);
        intent.putExtra("scene", i3);
        intent.putExtra("path", str2);
        intent.putExtra("mini_receiver", new ResultReceiver(new Handler(Looper.getMainLooper())) { // from class: com.tencent.mobileqq.wxmini.api.impl.WxMiniManagerImpl.1
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i16, Bundle bundle) {
                super.onReceiveResult(i16, bundle);
                if (i16 == LauncherWxaState.STATE_LAUNCH_SUCCEED.getState()) {
                    bVar.onCallback(true, bundle);
                } else if (i16 == LauncherWxaState.STATE_LAUNCH_FAILED.getState()) {
                    bVar.onCallback(false, bundle);
                }
            }
        });
        startActivity(context, intent);
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public void startWxMiniAppByQQCode(Context context, String str, int i3) {
        Intent intent = new Intent();
        intent.putExtra("start_mode", 2);
        intent.putExtra("qq_code", str);
        intent.putExtra("scene", i3);
        startActivity(context, intent);
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public void startWxMiniAppByQQUrl(Context context, String str, int i3) {
        Intent intent = new Intent();
        intent.putExtra("start_mode", 4);
        intent.putExtra("url", str);
        intent.putExtra("scene", i3);
        intent.putExtra("version_type", getVersionTypeFromScheme(str));
        startActivity(context, intent);
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public void startWxMiniAppByUsername(Context context, String str, String str2, int i3) {
        startWxMiniAppByUsername(context, str, str2, i3, null);
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public void startWxMiniAppByUsernameWithCallback(String str, String str2, int i3, com.tencent.mobileqq.wxmini.api.data.b bVar) {
        startWxMiniAppByUsernameWithCallback(str, str2, i3, null, bVar);
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public void startWxMiniAppByWxCode(final Context context, String str, int i3) {
        if (StudyModeManager.t()) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                QQToast.makeText(context, R.string.f185153nt, 0).show();
            } else {
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.wxmini.api.impl.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        WxMiniManagerImpl.lambda$startWxMiniAppByWxCode$0(context);
                    }
                });
            }
            QLog.e(TAG, 1, "startWxMiniAppByWxCode getStudyMode error!");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("start_mode", 3);
        intent.putExtra("wx_code", str);
        intent.putExtra("scene", i3);
        startActivity(context, intent);
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public void startWxMiniAppByWxRawData(Context context, String str, int i3) {
        Intent intent = new Intent();
        intent.putExtra("start_mode", 5);
        intent.putExtra("wx_raw_data", str);
        intent.putExtra("scene", i3);
        startActivity(context, intent);
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public void unzipDynamicPackage(com.tencent.mobileqq.wxmini.api.data.b bVar) {
        f.h().q(bVar);
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public void updateTuringAIDTicket(String str) {
        i.w().c0(str);
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public void uploadLogFiles(final int i3, final int i16, final db3.b bVar) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wxmini.api.impl.WxMiniManagerImpl.7
            @Override // java.lang.Runnable
            public void run() {
                WxaLauncher.f0(i3, i16, bVar);
            }
        }, 128, null, false);
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager, mqq.app.IAccountCallback
    public void onLogout(final Constants.LogoutReason logoutReason) {
        ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).sendWxAccountUnBindRequest(new a());
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wxmini.api.impl.WxMiniManagerImpl.4
            @Override // java.lang.Runnable
            public void run() {
                i.w().t(logoutReason.name(), 3);
            }
        }, 16, null, true);
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public void requestWxMiniAppInfo(int i3, String str, int i16, db3.a aVar) {
        WxaInfoObtainUtil.w(i3, str, i16, true, aVar);
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public void startWxMiniAppByAppId(Context context, String str, String str2, int i3, int i16) {
        startWxMiniAppByAppId(context, str, str2, i3, i16, Uri.EMPTY);
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public void startWxMiniAppByUsername(Context context, String str, String str2, int i3, HashMap<String, Object> hashMap) {
        Intent intent = new Intent();
        intent.putExtra("start_mode", 1);
        intent.putExtra("username", str);
        intent.putExtra("scene", i3);
        intent.putExtra("path", str2);
        if (hashMap != null) {
            intent.putExtra("hostExtraData", hashMap);
        }
        startActivity(context, intent);
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public void startWxMiniAppByUsernameWithCallback(String str, String str2, int i3, HashMap<String, Object> hashMap, final com.tencent.mobileqq.wxmini.api.data.b bVar) {
        Intent intent = new Intent();
        intent.putExtra("start_mode", 1);
        intent.putExtra("username", str);
        intent.putExtra("scene", i3);
        intent.putExtra("path", str2);
        intent.putExtra("mini_receiver", new ResultReceiver(new Handler(Looper.getMainLooper())) { // from class: com.tencent.mobileqq.wxmini.api.impl.WxMiniManagerImpl.2
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i16, Bundle bundle) {
                super.onReceiveResult(i16, bundle);
                if (i16 == LauncherWxaState.STATE_LAUNCH_SUCCEED.getState()) {
                    bVar.onCallback(true, bundle);
                } else if (i16 == LauncherWxaState.STATE_LAUNCH_FAILED.getState()) {
                    bVar.onCallback(false, bundle);
                }
            }
        });
        if (hashMap != null) {
            intent.putExtra("hostExtraData", hashMap);
        }
        startActivity(BaseApplication.getContext(), intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$checkWxAuthed$2(com.tencent.mobileqq.wxmini.api.data.b bVar, TdiAuthState tdiAuthState, String str) {
        if (bVar != null) {
            boolean z16 = tdiAuthState == TdiAuthState.WechatTdi_Auth_State_OK;
            Bundle bundle = new Bundle();
            bundle.putInt("errCode", tdiAuthState.ordinal());
            bundle.putString("message", str);
            bVar.onCallback(z16, bundle);
        }
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public void startWxMiniAppByAppId(Context context, String str, String str2, int i3, int i16, Uri uri) {
        startWxMiniAppByAppId(context, str, str2, i3, i16, uri, null);
    }

    private void startActivity(Context context, Intent intent) {
        if (context != null) {
            intent.putExtra("public_fragment_window_feature", 1);
            boolean z16 = context instanceof Activity;
            if (!z16) {
                intent.addFlags(402653184);
            }
            QPublicFragmentActivity.b.b(context, intent, QPublicTransFragmentActivityBehind.class, PreloadingFragment.class);
            if (z16) {
                ((Activity) context).overridePendingTransition(0, 0);
                return;
            }
            return;
        }
        QLog.e(TAG, 1, "wxa start error, because context is null");
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public void onLogout(Constants.LogoutReason logoutReason, int i3) {
        i.w().t(logoutReason.name(), i3);
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public void startWxMiniApp(Context context, com.tencent.mobileqq.wxmini.api.data.e eVar, int i3) {
        if (eVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(eVar.f327615c)) {
            startWxMiniAppByAppId(context, eVar.f327615c, eVar.f327617e, i3);
        } else if (!TextUtils.isEmpty(eVar.f327616d)) {
            startWxMiniAppByUsername(context, eVar.f327616d, eVar.f327617e, i3);
        } else {
            QLog.e(TAG, 1, "startWxMiniApp error, appId and username are empty!");
        }
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniManager
    public void startWxMiniAppByAppId(Context context, String str, String str2, int i3, int i16, Uri uri, HashMap<String, Object> hashMap) {
        Intent intent = new Intent();
        intent.putExtra("start_mode", 0);
        intent.putExtra("app_id", str);
        intent.putExtra("scene", i3);
        intent.putExtra("path", str2);
        intent.putExtra("version_type", i16);
        intent.putExtra(LayoutAttrDefine.CLICK_URI, uri);
        if (hashMap != null) {
            intent.putExtra("hostExtraData", hashMap);
        }
        startActivity(context, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$startWxMiniAppByWxCode$0(Context context) {
        QQToast.makeText(context, R.string.f185153nt, 0).show();
    }

    @Override // mqq.app.IAccountCallback
    public void onAccountChangeFailed(AppRuntime appRuntime) {
    }

    @Override // mqq.app.IAccountCallback
    public void onAccountChanged(AppRuntime appRuntime) {
    }
}
