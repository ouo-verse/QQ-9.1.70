package com.tencent.qq.minibox.proxy;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.minibox.proxy.CallHostCallback;
import com.tencent.minibox.proxy.HostNotifyProxy;
import com.tencent.minibox.proxy.HostNotifySimpleBooleanCallback;
import com.tencent.minibox.proxy.LoginInfoCallback;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityBehind;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityForTool;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.minigame.api.IMiniGameVALoginApi;
import com.tencent.mobileqq.minigame.api.IMiniGameVAManager;
import com.tencent.mobileqq.minigame.api.IMiniGameVAShareApi;
import com.tencent.mobileqq.minigame.va.GameLoginInfo;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqsomonitor.api.ISoMonitorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.metadream.IMiniBoxUseMiniGameAbilityApi;
import com.tencent.qq.minibox.ui.FloatingPanelFragment;
import com.tencent.qq.minibox.ui.MiniBoxWebviewFragment;
import com.tencent.qq.minibox.ui.MiniGameVATransparentFragment;
import com.tencent.qq.minibox.ui.PermissionsInfoFragment;
import com.tencent.qq.minibox.util.MiniBoxSavePhotos2AlbumUtils;
import com.tencent.qzonehub.api.IQZoneRouteApi;
import com.tencent.qzonehub.api.IQzoneShareApi;
import com.vivo.push.PushClientConstants;
import cooperation.qzone.QZoneShareManager;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 (2\u00020\u0001:\u0002()B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u0016\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u001a\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00132\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u0019\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J \u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u001a\u0010\u001d\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\u001e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010!\u001a\u00020 H\u0016J \u0010%\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010#\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020$H\u0016\u00a8\u0006*"}, d2 = {"Lcom/tencent/qq/minibox/proxy/HostNotifyProxyImpl;", "Lcom/tencent/minibox/proxy/HostNotifyProxy;", "Landroid/os/Bundle;", "params", "", "f", "d", "i", "g", "p", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", DomainData.DOMAIN_NAME, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "l", "k", "", "Lcom/tencent/minibox/proxy/CallHostCallback;", "callback", "callHost", "action", "notifyHost", "route", "Lcom/tencent/minibox/proxy/HostNotifySimpleBooleanCallback;", "callBack", "saveImageToPhotosAlbum", "msdkShare", "showShareArkPanel", PushClientConstants.TAG_PKG_NAME, "", "allowWifiAutoUpdate", "updateWifiAutoUpdateFlag", "forceUpdate", "Lcom/tencent/minibox/proxy/LoginInfoCallback;", "getLoginInfo", "<init>", "()V", "a", "b", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class HostNotifyProxyImpl implements HostNotifyProxy {

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0001H\u0002J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u001c\u0010\u0010\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016R\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0012R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qq/minibox/proxy/HostNotifyProxyImpl$b;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "", "params", "", "a", "receiver", "d", "Lcom/tencent/minibox/proxy/CallHostCallback;", "callback", "b", "c", "Landroid/content/Intent;", "intent", "onReceive", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "Ljava/lang/String;", "vaParams", "<init>", "()V", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    private static final class b extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private WeakReference<CallHostCallback> callback;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String vaParams;

        private final void a(Context context, String params) {
            Intent intent = new Intent();
            intent.putExtra("va_data", params);
            intent.putExtra("public_fragment_window_feature", 1);
            QPublicFragmentActivity.b.b(context, intent, QPublicTransFragmentActivityBehind.class, MiniGameVATransparentFragment.class);
        }

        private final void d(Context context, BroadcastReceiver receiver) {
            try {
                context.unregisterReceiver(receiver);
            } catch (Exception e16) {
                QLog.e("HostNotifyProxyImpl", 1, "[MiniBox-callHost] e:" + e16);
            }
        }

        public final void b(@NotNull CallHostCallback callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.callback = new WeakReference<>(callback);
        }

        public final void c(@NotNull String params) {
            Intrinsics.checkNotNullParameter(params, "params");
            this.vaParams = params;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@Nullable Context context, @Nullable Intent intent) {
            String str;
            CallHostCallback callHostCallback;
            String str2;
            if (intent != null) {
                str = intent.getAction();
            } else {
                str = null;
            }
            if (str != null) {
                int hashCode = str.hashCode();
                if (hashCode != -1685490427) {
                    if (hashCode != -1010840266) {
                        if (hashCode == 1348851687 && str.equals("com.tencent.mobileqq.ACTION_VA_IPC_HANDLE_ACT_NULL") && context != null && (str2 = this.vaParams) != null) {
                            a(context, str2);
                        }
                    } else if (str.equals("com.tencent.mobileqq.ACTION_VA_TRANSPARENT_HANDLE")) {
                        String stringExtra = intent.getStringExtra("va_response");
                        QLog.i("HostNotifyProxyImpl", 1, "[MiniBox-callHost] VABroadcastReceiver receive result:" + stringExtra);
                        WeakReference<CallHostCallback> weakReference = this.callback;
                        if (weakReference != null && (callHostCallback = weakReference.get()) != null) {
                            if (stringExtra == null) {
                                stringExtra = "";
                            }
                            callHostCallback.response(stringExtra);
                        }
                        this.callback = null;
                    }
                } else if (str.equals("com.tencent.mobileqq.ACTION_VA_ACTIVITY_FINISH_HANDLE") && context != null) {
                    d(context, this);
                }
            }
            if (context != null) {
                d(context, this);
            }
            this.vaParams = null;
        }
    }

    private final void d(Bundle params) {
        QLog.i("HostNotifyProxyImpl", 1, "handleGameReport params:" + params);
        QIPCClientHelper.getInstance().callServer("minibox_qipc_module", "action_game_report", params, new EIPCResultCallback() { // from class: com.tencent.qq.minibox.proxy.e
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                HostNotifyProxyImpl.e(eIPCResult);
            }
        });
    }

    private final void f(Bundle params) {
        QLog.i("HostNotifyProxyImpl", 1, "handleNotifyMountServiceResult params:" + params);
        if (params != null) {
            if (params.getBoolean("isFailed")) {
                us3.m.f439991a.m("is_mount_service_hook_failed", true);
            } else {
                us3.m.f439991a.l("is_mount_service_hook_failed");
            }
        }
    }

    private final void g(Bundle params) {
        QLog.i("HostNotifyProxyImpl", 1, "ACTION_RESTART_APP params:" + params);
        QIPCClientHelper.getInstance().callServer("minibox_qipc_module", "action_restart_app", params, new EIPCResultCallback() { // from class: com.tencent.qq.minibox.proxy.d
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                HostNotifyProxyImpl.h(eIPCResult);
            }
        });
    }

    private final void i(Bundle params) {
        QLog.i("HostNotifyProxyImpl", 1, "handleStartYunGame params:" + params);
        QIPCClientHelper.getInstance().callServer("minibox_qipc_module", "action_start_yun_game", params, new EIPCResultCallback() { // from class: com.tencent.qq.minibox.proxy.f
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                HostNotifyProxyImpl.j(eIPCResult);
            }
        });
    }

    private final void k(Activity activity, Bundle params) {
        if (ns3.b.f421246a.g(activity, params)) {
            QLog.i("HostNotifyProxyImpl", 1, "msdkQQShare MetaDreamShareIntercept.handleShare!");
            return;
        }
        String string = params.getString("minibox_msdk_share_dir");
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 1);
        bundle.putString(AppConstants.Key.FORWARD_FILEPATH, string);
        bundle.putString(AppConstants.Key.FORWARD_THUMB, string);
        bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, string);
        bundle.putString(AppConstants.Key.FORWARD_EXTRA, string);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.putExtra(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
        intent.setComponent(new ComponentName(BaseApplication.context, "com.tencent.mobileqq.activity.ForwardRecentActivity"));
        intent.putExtra("forward_source_business_type", -1);
        intent.putExtra("forward_source_sub_business_type", "");
        activity.startActivity(intent);
    }

    private final void l(Activity activity, Bundle params) {
        ArrayList<String> arrayListOf;
        Long l3;
        String string = params.getString("minibox_msdk_share_dir");
        String string2 = params.getString("minibox_msdk_share_id");
        String string3 = params.getString("minibox_msdk_share_pkg");
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(MobileQQ.sMobileQQ.getPackageName(), ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).getQZonePublishMoodActivityClass().getName()));
        intent.putExtra("qzone_uin", ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount());
        intent.putExtra("key_need_save_draft", false);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(string);
        intent.putStringArrayListExtra("images", arrayListOf);
        intent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 3);
        intent.putExtra(QZoneShareManager.QZONE_SHARE_KEY_REUQIRE_STORAGE_PERMISSION, false);
        if (string2 != null) {
            l3 = Long.valueOf(Long.parseLong(string2));
        } else {
            l3 = null;
        }
        intent.putExtra(AppConstants.Key.SHARE_REQ_APP_ID, l3);
        intent.putExtra(QZoneShareManager.QZONE_SHARE_HULIAN_APPID, string2);
        intent.putExtra("pkg_name", string3);
        intent.putExtra(QZoneShareManager.KEY_IS_THIRDPARTYSHARE, true);
        ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).dontShowContact();
        activity.startActivity(intent);
    }

    private final void m(Bundle params) {
        String str;
        boolean z16;
        if (params != null) {
            str = params.getString("key_so_path");
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        ((ISoMonitorApi) QRoute.api(ISoMonitorApi.class)).registerSoFilePath(MobileQQ.sMobileQQ, str);
    }

    private final void n(Context context, Bundle params) {
        Intent intent = new Intent();
        intent.putExtras(params);
        intent.putExtra("isTransparentTitle", true);
        intent.putExtra("public_fragment_window_feature", 1);
        intent.addFlags(536870912);
        QPublicFragmentActivity.b.b(context, intent, QPublicTransFragmentActivityBehind.class, FloatingPanelFragment.class);
    }

    private final void o(Bundle params) {
        QLog.i("HostNotifyProxyImpl", 1, "original url == " + params + " , pid == " + Process.myPid());
        Intent intent = new Intent();
        intent.putExtra("url", params.getString("minibox_data"));
        intent.putExtra("minibox_pid", Process.myPid());
        intent.setComponent(new ComponentName(BaseApplication.getContext(), (Class<?>) QQBrowserActivity.class));
        intent.addFlags(268435456);
        intent.putExtra("fragmentClass", MiniBoxWebviewFragment.class);
        BaseApplication.getContext().startActivity(intent);
    }

    private final void p(Bundle params) {
        Intent intent = new Intent();
        intent.putExtras(params);
        QPublicFragmentActivity.b.b(BaseApplication.getContext(), intent, QPublicTransFragmentActivityForTool.class, MiniBoxWxPayFragment.class);
    }

    @Override // com.tencent.minibox.proxy.HostNotifyProxy
    public void callHost(@NotNull Context context, @NotNull String params, @NotNull CallHostCallback callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        boolean a16 = MiniBoxHostAction.INSTANCE.a(params);
        QLog.i("HostNotifyProxyImpl", 1, "[MiniBox-callHost] callHost needTransparentHandle:" + a16);
        if (!a16) {
            new MiniBoxHostAction(context, params, callback).f();
            return;
        }
        b bVar = new b();
        bVar.b(callback);
        bVar.c(params);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mobileqq.ACTION_VA_TRANSPARENT_HANDLE");
        intentFilter.addAction("com.tencent.mobileqq.ACTION_VA_IPC_HANDLE_ACT_NULL");
        intentFilter.addAction("com.tencent.mobileqq.ACTION_VA_ACTIVITY_FINISH_HANDLE");
        Unit unit = Unit.INSTANCE;
        context.registerReceiver(bVar, intentFilter);
        QIPCClientHelper qIPCClientHelper = QIPCClientHelper.getInstance();
        Bundle bundle = new Bundle();
        bundle.putString("keyVaIPCParams", params);
        qIPCClientHelper.callServer("minibox_qipc_module", "com.tencent.mobileqq.ACTION_VA_IPC_HANDLE", bundle);
    }

    @Override // com.tencent.minibox.proxy.HostNotifyProxy
    public void getLoginInfo(@NotNull String pkgName, boolean forceUpdate, @NotNull final LoginInfoCallback callBack) {
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        QLog.i("HostNotifyProxyImpl", 1, "getLoginInfo pkgName:" + pkgName + " forceUpdate:" + forceUpdate);
        ((IMiniGameVALoginApi) QRoute.api(IMiniGameVALoginApi.class)).getLoginInfo(pkgName, forceUpdate, new Function1<GameLoginInfo, Unit>() { // from class: com.tencent.qq.minibox.proxy.HostNotifyProxyImpl$getLoginInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GameLoginInfo gameLoginInfo) {
                invoke2(gameLoginInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable GameLoginInfo gameLoginInfo) {
                Unit unit;
                if (gameLoginInfo != null) {
                    LoginInfoCallback loginInfoCallback = LoginInfoCallback.this;
                    QLog.d("HostNotifyProxyImpl", 2, "getLoginInfo gameLoginInfo:" + gameLoginInfo);
                    String str = gameLoginInfo.accessToken;
                    Intrinsics.checkNotNullExpressionValue(str, "gameLoginInfo.accessToken");
                    String str2 = gameLoginInfo.payToken;
                    Intrinsics.checkNotNullExpressionValue(str2, "gameLoginInfo.payToken");
                    String str3 = gameLoginInfo.openId;
                    Intrinsics.checkNotNullExpressionValue(str3, "gameLoginInfo.openId");
                    String str4 = gameLoginInfo.appId;
                    Intrinsics.checkNotNullExpressionValue(str4, "gameLoginInfo.appId");
                    loginInfoCallback.onLoaded(str, str2, str3, str4);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    LoginInfoCallback.this.onLoaded("", "", "", "");
                }
            }
        });
    }

    @Override // com.tencent.minibox.proxy.HostNotifyProxy
    public void msdkShare(@Nullable Context context, @NotNull Bundle params) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (!(context instanceof Activity)) {
            QLog.i("HostNotifyProxyImpl", 4, "msdkShare: context is " + context);
            return;
        }
        QLog.d("HostNotifyProxyImpl", 4, "msdkShare");
        String string = params.getString("shareMethod");
        if (!Intrinsics.areEqual("shareGamePicture", string) && !Intrinsics.areEqual("shareGameStructMessage", string)) {
            if (params.getBoolean("minibox_msdk_share_qzone")) {
                l((Activity) context, params);
                return;
            } else {
                k((Activity) context, params);
                return;
            }
        }
        if (Intrinsics.areEqual("shareGamePicture", string) && !params.containsKey(PushClientConstants.TAG_PKG_NAME)) {
            Activity activity = (Activity) context;
            params.putString(PushClientConstants.TAG_PKG_NAME, activity.getPackageName());
            QLog.w("HostNotifyProxyImpl", 1, "add share game pic pkgName:" + activity.getPackageName());
        }
        ((IMiniGameVAShareApi) QRoute.api(IMiniGameVAShareApi.class)).openShareFragment((Activity) context, params);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0028. Please report as an issue. */
    @Override // com.tencent.minibox.proxy.HostNotifyProxy
    public void notifyHost(@NotNull String action, @Nullable Bundle params) {
        boolean z16;
        Intrinsics.checkNotNullParameter(action, "action");
        QLog.d("HostNotifyProxyImpl", 4, "HostNotifyProxyImpl,notifyHost action:" + action);
        String str = null;
        boolean z17 = false;
        switch (action.hashCode()) {
            case -1860907242:
                if (action.equals("minibox_on_app_foreground")) {
                    js3.a.f410940d.registerModule();
                    ((IMiniGameVAManager) QRoute.api(IMiniGameVAManager.class)).onProcessStateChange(true);
                    return;
                }
                QIPCClientHelper.getInstance().callServer("minibox_qipc_module", action, params, null);
                return;
            case -1762251357:
                if (action.equals("minibox_action_game_report")) {
                    d(params);
                    return;
                }
                QIPCClientHelper.getInstance().callServer("minibox_qipc_module", action, params, null);
                return;
            case -934034573:
                if (action.equals("minibox_action_restart_app")) {
                    g(params);
                    return;
                }
                QIPCClientHelper.getInstance().callServer("minibox_qipc_module", action, params, null);
                return;
            case -882590975:
                if (action.equals("minibox_on_app_background")) {
                    ((IMiniGameVAManager) QRoute.api(IMiniGameVAManager.class)).onProcessStateChange(false);
                    BaseApplication.getContext().sendBroadcast(new Intent("com.tencent.mobileqq.ACTION_VA_ACTIVITY_FINISH_HANDLE"));
                    return;
                }
                QIPCClientHelper.getInstance().callServer("minibox_qipc_module", action, params, null);
                return;
            case -578034739:
                if (action.equals("minibox_register_so")) {
                    m(params);
                    return;
                }
                QIPCClientHelper.getInstance().callServer("minibox_qipc_module", action, params, null);
                return;
            case -534512687:
                if (action.equals("process_init_dex_version")) {
                    if (params != null) {
                        str = params.getString("dex_version");
                    }
                    QLog.d("HostNotifyProxyImpl", 4, "ACTION_PROCESS_DEX_VERSION version:" + str);
                    if (str != null) {
                        if (str.length() > 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            z17 = true;
                        }
                    }
                    if (z17) {
                        CrashReport.putUserData(BaseApplication.getContext(), "miniboxDexVersion", str);
                        return;
                    }
                    return;
                }
                QIPCClientHelper.getInstance().callServer("minibox_qipc_module", action, params, null);
                return;
            case -196694404:
                if (action.equals("action_notify_mount_service_hook_result")) {
                    f(params);
                    return;
                }
                QIPCClientHelper.getInstance().callServer("minibox_qipc_module", action, params, null);
                return;
            case 1001700282:
                if (action.equals("minibox_action_start_yun_game")) {
                    i(params);
                    return;
                }
                QIPCClientHelper.getInstance().callServer("minibox_qipc_module", action, params, null);
                return;
            case 1103233298:
                if (action.equals("minibox_start_wx_pay")) {
                    if (params != null) {
                        p(params);
                        return;
                    }
                    return;
                }
                QIPCClientHelper.getInstance().callServer("minibox_qipc_module", action, params, null);
                return;
            case 1150465802:
                if (action.equals("minibox_saction_start_browser")) {
                    if (params != null) {
                        o(params);
                        return;
                    }
                    return;
                }
                QIPCClientHelper.getInstance().callServer("minibox_qipc_module", action, params, null);
                return;
            default:
                QIPCClientHelper.getInstance().callServer("minibox_qipc_module", action, params, null);
                return;
        }
    }

    @Override // com.tencent.minibox.proxy.HostNotifyProxy
    public void route(@NotNull Context context, @Nullable Bundle params) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "context");
        if (params != null) {
            obj = params.get("key_page_id");
        } else {
            obj = null;
        }
        boolean z16 = true;
        if (Intrinsics.areEqual(obj, (Object) 1)) {
            Intent intent = new Intent();
            intent.putExtras(params);
            QPublicFragmentActivity.start(context, intent, PermissionsInfoFragment.class);
        } else {
            if (!Intrinsics.areEqual(obj, (Object) 2)) {
                z16 = Intrinsics.areEqual(obj, (Object) 3);
            }
            if (z16) {
                n(context, params);
            }
        }
    }

    @Override // com.tencent.minibox.proxy.HostNotifyProxy
    public void saveImageToPhotosAlbum(@NotNull Activity activity, @NotNull Bundle params, @NotNull HostNotifySimpleBooleanCallback callBack) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        QLog.d("HostNotifyProxyImpl", 4, "saveImageToPhotosAlbum");
        String localFilePath = params.getString("path", null);
        boolean z16 = params.getBoolean("orientation", true);
        if (TextUtils.isEmpty(localFilePath)) {
            callBack.onFinish(false);
            QLog.e("HostNotifyProxyImpl", 1, "saveImageToPhotosAlbum localFilePath invalid");
        } else {
            MiniBoxSavePhotos2AlbumUtils miniBoxSavePhotos2AlbumUtils = MiniBoxSavePhotos2AlbumUtils.f344752a;
            Intrinsics.checkNotNullExpressionValue(localFilePath, "localFilePath");
            miniBoxSavePhotos2AlbumUtils.a(activity, localFilePath, z16, callBack);
        }
    }

    @Override // com.tencent.minibox.proxy.HostNotifyProxy
    public void showShareArkPanel(@Nullable Context context, @NotNull Bundle params) {
        Intrinsics.checkNotNullParameter(params, "params");
        String string = params.getString("minibox_msdk_share_pkg");
        String string2 = params.getString("minibox_msdk_share_appid");
        boolean z16 = params.getBoolean("minibox_is_landscape");
        QLog.i("HostNotifyProxyImpl", 1, "showShareArkPanel pkgName=" + string + " appId=" + string2 + " isLandscape=" + z16);
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).openSharePanel(context, string, string2, z16, 0);
    }

    @Override // com.tencent.minibox.proxy.HostNotifyProxy
    public void updateWifiAutoUpdateFlag(@NotNull String pkgName, boolean allowWifiAutoUpdate) {
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        ((IMiniBoxUseMiniGameAbilityApi) QRoute.api(IMiniBoxUseMiniGameAbilityApi.class)).updateWifiAutoUpdateFlag(pkgName, allowWifiAutoUpdate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(EIPCResult eIPCResult) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(EIPCResult eIPCResult) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(EIPCResult eIPCResult) {
    }
}
