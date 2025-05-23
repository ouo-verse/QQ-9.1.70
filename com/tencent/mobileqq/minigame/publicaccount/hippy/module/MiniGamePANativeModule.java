package com.tencent.mobileqq.minigame.publicaccount.hippy.module;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.hippy.qq.module.QQBaseModule;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.minigame.kuikly.MiniGameKuiklyModule;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountIPCModule;
import com.tencent.mobileqq.minigame.publicaccount.api.IMiniGamePublicAccountApi;
import com.tencent.mobileqq.minigame.publicaccount.utils.PublicAccountUtil;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.ShortcutUtils;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.json.JSONObject;

@HippyNativeModule(name = MiniGamePANativeModule.CLASSNAME)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J)\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u00a2\u0006\u0002\u0010\rJ\u001a\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0007J\"\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\nH\u0002J\u001a\u0010\u0015\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u001a\u0010\u0016\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\u0018\u001a\u00020\u0006H\u0007J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0007\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/minigame/publicaccount/hippy/module/MiniGamePANativeModule;", "Lcom/tencent/hippy/qq/module/QQBaseModule;", "hippyEngineContext", "Lcom/tencent/mtt/hippy/HippyEngineContext;", "(Lcom/tencent/mtt/hippy/HippyEngineContext;)V", "addShortCutFailed", "", "code", "", "msg", "", "promise", "Lcom/tencent/mtt/hippy/modules/Promise;", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/tencent/mtt/hippy/modules/Promise;)V", MiniChatConstants.MINI_APP_ADD_SHORTCUT, "params", "Lcom/tencent/mtt/hippy/common/HippyMap;", "appendParams", "url", "key", "value", MiniGameKuiklyModule.METHOD_GET_PUBLIC_ACCOUNT_AIO_MSG_LIST, MiniGameKuiklyModule.METHOD_GET_ARK_MODELS, "getMiniGameHippyData", "openAIO", MiniGameKuiklyModule.METHOD_OPEN_MINI_APP, "openMiniGamePADetail", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGamePANativeModule extends QQBaseModule {
    public static final int AIO_MSG_LIST_DEFAULT_COUNT = 100;
    public static final String CLASSNAME = "MiniGamePANativeModule";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniGamePANativeModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
        Intrinsics.checkNotNullParameter(hippyEngineContext, "hippyEngineContext");
    }

    private final void addShortCutFailed(Integer code, String msg2, Promise promise) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("code", code);
        jSONObject.put("message", msg2);
        promise.reject(jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addShortcut$lambda$5(Context context, final String str, final String str2, final String str3, final Promise promise, final MiniGamePANativeModule this$0) {
        Intrinsics.checkNotNullParameter(promise, "$promise");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final boolean y16 = UiApiPlugin.y(context, UiApiPlugin.M(context, null, str, QQBrowserActivity.WEB_FLOAT_SHORTCUT_FROM), str2, str3);
        if (QLog.isColorLevel()) {
            QLog.d(CLASSNAME, 2, "addShortcut isSuccess=" + y16);
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.minigame.publicaccount.hippy.module.c
            @Override // java.lang.Runnable
            public final void run() {
                MiniGamePANativeModule.addShortcut$lambda$5$lambda$4(y16, promise, this$0, str2, str3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addShortcut$lambda$5$lambda$4(boolean z16, Promise promise, MiniGamePANativeModule this$0, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(promise, "$promise");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            promise.resolve("");
            return;
        }
        this$0.addShortCutFailed(-1, "createShortcut failed, title=" + str + ", icon=" + str2 + ", url=" + str3, promise);
    }

    private final String appendParams(String url, String key, String value) {
        boolean contains$default;
        if (TextUtils.isEmpty(url) || TextUtils.isEmpty(key) || TextUtils.isEmpty(value)) {
            return url;
        }
        String str = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, false, 2, (Object) null);
        if (contains$default) {
            str = ContainerUtils.FIELD_DELIMITER;
        }
        return url + str + key + ContainerUtils.KEY_VALUE_DELIMITER + value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getMiniGameAioMsgList$lambda$3(Promise promise, EIPCResult eIPCResult) {
        Intrinsics.checkNotNullParameter(promise, "$promise");
        boolean z16 = false;
        if (eIPCResult != null && eIPCResult.code == 0) {
            z16 = true;
        }
        promise.resolve(z16 ? eIPCResult.data.getString(MiniGamePublicAccountIPCModule.KEY_MSG_JSON_STRING) : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getMiniGameArkModels$lambda$1(Promise promise, EIPCResult eIPCResult) {
        Intrinsics.checkNotNullParameter(promise, "$promise");
        boolean z16 = false;
        if (eIPCResult != null && eIPCResult.code == 0) {
            z16 = true;
        }
        promise.resolve(z16 ? eIPCResult.data.getString(MiniGamePublicAccountIPCModule.KEY_MSG_JSON_STRING) : null);
    }

    @HippyMethod(name = MiniChatConstants.MINI_APP_ADD_SHORTCUT)
    public final void addShortcut(HippyMap params, final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (QLog.isColorLevel()) {
            QLog.i(CLASSNAME, 2, MiniChatConstants.MINI_APP_ADD_SHORTCUT);
        }
        if (params == null) {
            addShortCutFailed(-1, "params is null!", promise);
            return;
        }
        final String string = params.getString("title");
        final String string2 = params.getString("icon");
        final String string3 = params.getString("url");
        final Context baseContext = MobileQQ.sMobileQQ.getBaseContext();
        if (ShortcutUtils.i(baseContext) == 1) {
            ShortcutUtils.B(getActivity());
            addShortCutFailed(-1, "no permission to create shortcut", promise);
        } else if (QQUtils.j(baseContext, new String[]{string})) {
            QQToast.makeText(getActivity(), R.string.b1c, 0).show(getActivity().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            promise.resolve("");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.minigame.publicaccount.hippy.module.d
                @Override // java.lang.Runnable
                public final void run() {
                    MiniGamePANativeModule.addShortcut$lambda$5(baseContext, string3, string, string2, promise, this);
                }
            }, 128, null, true);
        }
    }

    @HippyMethod(name = MiniGameKuiklyModule.METHOD_GET_PUBLIC_ACCOUNT_AIO_MSG_LIST)
    public final void getMiniGameAioMsgList(HippyMap params, final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        int i3 = params != null ? params.getInt("count") : 0;
        QLog.d(CLASSNAME, 2, "getMiniGameAioMsgList count=" + i3);
        if (i3 <= 0) {
            i3 = 100;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("count", i3);
        QIPCClientHelper.getInstance().callServer("MiniGamePublicAccountIPCModule", MiniGamePublicAccountIPCModule.ACTION_GET_MINI_GAME_AIO_ARK_MSG_LIST, bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.minigame.publicaccount.hippy.module.a
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                MiniGamePANativeModule.getMiniGameAioMsgList$lambda$3(Promise.this, eIPCResult);
            }
        });
    }

    @HippyMethod(name = MiniGameKuiklyModule.METHOD_GET_ARK_MODELS)
    public final void getMiniGameArkModels(HippyMap params, final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        int i3 = params != null ? params.getInt("count") : 0;
        if (QLog.isColorLevel()) {
            QLog.i(CLASSNAME, 2, "getMiniGameArkModels count=" + i3);
        }
        Bundle bundle = new Bundle();
        bundle.putInt("count", i3);
        QIPCClientHelper.getInstance().callServer("MiniGamePublicAccountIPCModule", MiniGamePublicAccountIPCModule.ACTION_GET_MINI_GAME_PUBLIC_MSG, bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.minigame.publicaccount.hippy.module.b
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                MiniGamePANativeModule.getMiniGameArkModels$lambda$1(Promise.this, eIPCResult);
            }
        });
    }

    @HippyMethod(name = "getMiniGameHippyData")
    public final void getMiniGameHippyData(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        HippyMap hippyMap = new HippyMap();
        HippyQQEngine hippyQQEngine = getHippyQQEngine();
        HippyQQPreloadEngine hippyQQPreloadEngine = hippyQQEngine instanceof HippyQQPreloadEngine ? (HippyQQPreloadEngine) hippyQQEngine : null;
        if (hippyQQPreloadEngine != null) {
            hippyMap.pushInt("useLocalJsBundle", hippyQQPreloadEngine.mReportJSBundleState == 0 ? 0 : 1);
        }
        promise.resolve(hippyMap);
    }

    @HippyMethod(name = "openAIO")
    public final void openAIO() {
        if (QLog.isColorLevel()) {
            QLog.i(CLASSNAME, 2, "openAIO");
        }
        try {
            IAIOStarterApi iAIOStarterApi = (IAIOStarterApi) QRoute.api(IAIOStarterApi.class);
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            String string = getActivity().getString(R.string.f167742dr);
            Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str\u2026ame_public_account_title)");
            iAIOStarterApi.navigateToAIO(activity, 103, IMiniGamePublicAccountApi.PEER_UID_MINI_GAME, string, AppConstants.MINI_GAME_PUBLIC_ACCOUNT_UIN_LONG_VALUE, null);
        } catch (Throwable th5) {
            QLog.e(CLASSNAME, 1, "jumpMiniGameAIO error", th5);
        }
    }

    @HippyMethod(name = MiniGameKuiklyModule.METHOD_OPEN_MINI_APP)
    public final void openMiniApp(HippyMap params) {
        boolean contains$default;
        Intrinsics.checkNotNullParameter(params, "params");
        String schema = params.getString("url");
        int i3 = params.getInt("scene");
        if (QLog.isColorLevel()) {
            QLog.i(CLASSNAME, 2, "openMiniApp:" + schema + ", scene:" + i3);
        }
        Activity activity = getActivity();
        if (activity == null) {
            QLog.e(CLASSNAME, 1, "openMiniApp activity is null");
            return;
        }
        boolean z16 = false;
        if (schema != null) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) schema, (CharSequence) "host_scene", false, 2, (Object) null);
            if (!contains$default) {
                z16 = true;
            }
        }
        if (z16 && params.containsKey("hostScene")) {
            int i16 = params.getInt("hostScene");
            Intrinsics.checkNotNullExpressionValue(schema, "schema");
            appendParams(schema, "host_scene", String.valueOf(i16));
        }
        try {
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(activity, schema, i3, null);
        } catch (Exception e16) {
            QLog.e(CLASSNAME, 1, "openMiniApp error: " + e16.getMessage());
        }
    }

    @HippyMethod(name = MiniGameKuiklyModule.METHOD_OPEN_MINIGAME_PA_DETAIL)
    public final void openMiniGamePADetail(HippyMap params) {
        Intrinsics.checkNotNullParameter(params, "params");
        PublicAccountUtil.openAccountDetail(getActivity());
    }
}
