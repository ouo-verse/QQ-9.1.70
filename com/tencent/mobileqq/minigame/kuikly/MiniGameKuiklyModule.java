package com.tencent.mobileqq.minigame.kuikly;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountIPCModule;
import com.tencent.mobileqq.minigame.publicaccount.api.IMiniGamePublicAccountApi;
import com.tencent.mobileqq.minigame.publicaccount.utils.PublicAccountUtil;
import com.tencent.mobileqq.minispecial.kuikly.IMiniKuiklyApi;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.ThirdPartyMiniPageProxy;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import i01.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001f\u0010 JG\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002JG\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002JE\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002JE\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002J=\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002J \u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u0014H\u0002J=\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002JM\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00022+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002JI\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002J\b\u0010\u001d\u001a\u00020\nH\u0002JG\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002JI\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0016\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/minigame/kuikly/MiniGameKuiklyModule;", "Li01/e;", "", "method", "", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", MiniGameKuiklyModule.METHOD_SET_SHARE_PARAMS, MiniGameKuiklyModule.METHOD_OPEN_MINI_APP, "", "count", MiniGameKuiklyModule.METHOD_GET_ARK_MODELS, MiniGameKuiklyModule.METHOD_GET_PUBLIC_ACCOUNT_AIO_MSG_LIST, MiniGameKuiklyModule.METHOD_OPEN_AIO, "Lkotlin/Function0;", "call", "safeCallNativeMethod", "callBackSuccess", "code", "msg", "callBackResult", "Lorg/json/JSONObject;", "parseParams2Json", MiniGameKuiklyModule.METHOD_PRELOAD_MINI_GAME, MiniGameKuiklyModule.METHOD_PRELOAD_WXA, "<init>", "()V", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class MiniGameKuiklyModule extends e {
    private static final int AIO_MSG_LIST_DEFAULT_COUNT = 100;
    private static final int ERROR_PARAMS_INVALID = -1;
    private static final int ERROR_SYS_FAIL = -2;
    private static final int GAME_BOX_HIDE_TYPE_ALWAYS = 2;
    private static final int GAME_BOX_HIDE_TYPE_ONCE = 1;
    public static final String METHOD_GET_ARK_MODELS = "getMiniGameArkModels";
    public static final String METHOD_GET_PUBLIC_ACCOUNT_AIO_MSG_LIST = "getMiniGameAioMsgList";
    public static final String METHOD_OPEN_AIO = "openMiniGamePAAIO";
    public static final String METHOD_OPEN_MINIGAME_PA_DETAIL = "openMiniGamePublicAccountDetail";
    public static final String METHOD_OPEN_MINI_APP = "openMiniApp";
    public static final String METHOD_PRELOAD_MINI_GAME = "preloadMiniGame";
    public static final String METHOD_PRELOAD_WXA = "preloadWxa";
    public static final String METHOD_SET_SHARE_PARAMS = "setShareParams";
    public static final String MODULE_NAME = "MiniGameKuiklyModule";
    private static final String TAG = "MiniGameKuiklyModule";

    private final void getMiniGameAioMsgList(final String method, int count, final Function1<Object, Unit> callback) {
        QLog.d("MiniGameKuiklyModule", 1, "getMiniGameAioMsgList count:" + count);
        if (count <= 0) {
            count = 100;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("count", count);
        QIPCClientHelper.getInstance().callServer("MiniGamePublicAccountIPCModule", MiniGamePublicAccountIPCModule.ACTION_GET_MINI_GAME_AIO_ARK_MSG_LIST, bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.minigame.kuikly.a
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                MiniGameKuiklyModule.getMiniGameAioMsgList$lambda$3(MiniGameKuiklyModule.this, method, callback, eIPCResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getMiniGameAioMsgList$lambda$3(MiniGameKuiklyModule this$0, String method, Function1 function1, EIPCResult eIPCResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        String string = eIPCResult != null && eIPCResult.code == 0 ? eIPCResult.data.getString(MiniGamePublicAccountIPCModule.KEY_MSG_JSON_STRING) : null;
        if (string == null) {
            string = "";
        }
        this$0.callBackResult(method, 0, string, function1);
    }

    private final void getMiniGameArkModels(final String method, int count, final Function1<Object, Unit> callback) {
        Bundle bundle = new Bundle();
        bundle.putInt("count", count);
        QIPCClientHelper.getInstance().callServer("MiniGamePublicAccountIPCModule", MiniGamePublicAccountIPCModule.ACTION_GET_MINI_GAME_PUBLIC_MSG, bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.minigame.kuikly.b
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                MiniGameKuiklyModule.getMiniGameArkModels$lambda$1(MiniGameKuiklyModule.this, method, callback, eIPCResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getMiniGameArkModels$lambda$1(MiniGameKuiklyModule this$0, String method, Function1 function1, EIPCResult eIPCResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        String string = eIPCResult != null && eIPCResult.code == 0 ? eIPCResult.data.getString(MiniGamePublicAccountIPCModule.KEY_MSG_JSON_STRING) : null;
        if (string == null) {
            string = "";
        }
        this$0.callBackResult(method, 0, string, function1);
    }

    private final void openMiniGamePAAIO(String method, Function1<Object, Unit> callback) {
        Activity activity = getActivity();
        if (activity == null) {
            callBackResult(method, -2, "context is null.", callback);
            return;
        }
        IAIOStarterApi iAIOStarterApi = (IAIOStarterApi) QRoute.api(IAIOStarterApi.class);
        String string = activity.getString(R.string.f167742dr);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026ame_public_account_title)");
        iAIOStarterApi.navigateToAIO(activity, 103, IMiniGamePublicAccountApi.PEER_UID_MINI_GAME, string, AppConstants.MINI_GAME_PUBLIC_ACCOUNT_UIN_LONG_VALUE, null);
        callBackSuccess(method, callback);
    }

    private final JSONObject parseParams2Json(String method, Object params, Function1<Object, Unit> callback) {
        if (params instanceof String) {
            return new JSONObject((String) params);
        }
        callBackResult(method, -1, "please convert params to Json String.", callback);
        return null;
    }

    private final void preloadMiniGame() {
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).preloadMiniGame();
    }

    private final void preloadWxa(String method, Object params, Function1<Object, Unit> callback) {
        ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).preloadProcessEnv(true);
        callBackSuccess(method, callback);
    }

    private final Object safeCallNativeMethod(String method, Function0<Unit> call) {
        try {
            call.invoke();
            return Unit.INSTANCE;
        } catch (Exception e16) {
            QLog.e("MiniGameKuiklyModule", 1, "safe call " + method + " failed, exception=", e16);
            return null;
        }
    }

    private final void setShareParams(String method, Object params, Function1<Object, Unit> callback) {
        JSONObject parseParams2Json = parseParams2Json(method, params, callback);
        if (parseParams2Json == null) {
            return;
        }
        String optString = parseParams2Json.optString(ThirdPartyMiniPageProxy.KEY_SHARE_TEXT);
        Intrinsics.checkNotNullExpressionValue(optString, "paramsObj.optString(\"shareText\")");
        String optString2 = parseParams2Json.optString(ThirdPartyMiniPageProxy.KEY_SHARE_PIC_URL);
        Intrinsics.checkNotNullExpressionValue(optString2, "paramsObj.optString(\"sharePicUrl\")");
        String optString3 = parseParams2Json.optString(ThirdPartyMiniPageProxy.KEY_SHARE_QUERY);
        Intrinsics.checkNotNullExpressionValue(optString3, "paramsObj.optString(\"shareQuery\")");
        if (!(optString.length() == 0)) {
            if (!(optString2.length() == 0)) {
                ((IMiniKuiklyApi) QRoute.api(IMiniKuiklyApi.class)).setShareParams(optString, optString2, optString3);
                callBackSuccess(method, callback);
                return;
            }
        }
        QLog.e("MiniGameKuiklyModule", 1, "setShareParams: share param invalid.");
        callBackResult(method, -1, "share param invalid", callback);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0033. Please report as an issue. */
    @Override // i01.e, i01.a
    public Object call(final String method, final Object params, final Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (QLog.isDebugVersion()) {
            QLog.d("MiniGameKuiklyModule", 4, "call method=" + method + ", params=" + params);
        }
        switch (method.hashCode()) {
            case -741666654:
                if (method.equals(METHOD_OPEN_MINIGAME_PA_DETAIL)) {
                    PublicAccountUtil.openAccountDetail(getActivity());
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -718478907:
                if (method.equals(METHOD_GET_ARK_MODELS)) {
                    getMiniGameArkModels(method, params instanceof Integer ? ((Number) params).intValue() : 0, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -298632157:
                if (method.equals(METHOD_OPEN_AIO)) {
                    openMiniGamePAAIO(method, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -159236393:
                if (method.equals(METHOD_PRELOAD_WXA)) {
                    preloadWxa(method, params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -102393326:
                if (method.equals(METHOD_PRELOAD_MINI_GAME)) {
                    preloadMiniGame();
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 867669152:
                if (method.equals(METHOD_OPEN_MINI_APP)) {
                    return safeCallNativeMethod(method, new Function0<Unit>() { // from class: com.tencent.mobileqq.minigame.kuikly.MiniGameKuiklyModule$call$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            MiniGameKuiklyModule.this.openMiniApp(method, params, callback);
                        }
                    });
                }
                return super.call(method, params, callback);
            case 1082025015:
                if (method.equals(METHOD_GET_PUBLIC_ACCOUNT_AIO_MSG_LIST)) {
                    getMiniGameAioMsgList(method, params instanceof Integer ? ((Number) params).intValue() : 0, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1843874947:
                if (method.equals(METHOD_SET_SHARE_PARAMS)) {
                    setShareParams(method, params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            default:
                return super.call(method, params, callback);
        }
    }

    private final void callBackSuccess(String method, Function1<Object, Unit> callback) {
        callBackResult(method, 0, "", callback);
    }

    private final void callBackResult(String method, int code, String msg2, Function1<Object, Unit> callback) {
        if (callback == null) {
            return;
        }
        if (code < 0) {
            QLog.w("MiniGameKuiklyModule", 1, method + " call failed, code=" + code + ", msg=" + msg2);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", code);
            jSONObject.put("msg", msg2);
            callback.invoke(jSONObject.toString());
        } catch (Exception e16) {
            QLog.e("MiniGameKuiklyModule", 1, "callBackFail: exception=", e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openMiniApp(String method, Object params, Function1<Object, Unit> callback) {
        String str;
        String str2;
        int i3;
        String str3;
        JSONObject parseParams2Json = parseParams2Json(method, params, callback);
        if (parseParams2Json == null) {
            return;
        }
        String optString = parseParams2Json.optString("appId", "");
        if (optString == null || optString.length() == 0) {
            callBackResult(method, -1, "appId is empty", callback);
            return;
        }
        String optString2 = parseParams2Json.optString("path");
        int optInt = parseParams2Json.optInt("scene");
        boolean optBoolean = parseParams2Json.optBoolean("closeFloatingBox", false);
        String reportData = parseParams2Json.optString("reportData", "");
        JSONObject optJSONObject = parseParams2Json.optJSONObject("task");
        if (optJSONObject != null) {
            i3 = optJSONObject.optInt("taskType");
            str = optJSONObject.optString(MiniAppGetGameTaskTicketServlet.KEY_TASKID);
            Intrinsics.checkNotNullExpressionValue(str, "taskObj.optString(\"taskId\")");
            str2 = optJSONObject.optString("taskAppId");
            Intrinsics.checkNotNullExpressionValue(str2, "taskObj.optString(\"taskAppId\")");
        } else {
            str = "0";
            str2 = "";
            i3 = 0;
        }
        JSONObject optJSONObject2 = parseParams2Json.optJSONObject("virtualAppData");
        if (optJSONObject2 == null) {
            str3 = "";
        } else {
            str3 = optJSONObject2.optString("via", "");
            Intrinsics.checkNotNullExpressionValue(str3, "virtualAppData.optString(\"via\", \"\")");
            String category = optJSONObject2.optString("categoryTag", "");
            Intrinsics.checkNotNullExpressionValue(category, "category");
            if (category.length() > 0) {
                Intrinsics.checkNotNullExpressionValue(reportData, "reportData");
                if (reportData.length() > 0) {
                    reportData = reportData + "&category_tag=" + category;
                }
            }
        }
        if (TextUtils.isEmpty(optString)) {
            QLog.e("MiniGameKuiklyModule", 1, "launchMiniAppByAppId appId invalid");
            return;
        }
        if (((IMiniAppService) QRoute.api(IMiniAppService.class)).isWxAppId(optString)) {
            int optInt2 = parseParams2Json.optInt("hostScene");
            JSONObject optJSONObject3 = parseParams2Json.optJSONObject("extraDict");
            if (optJSONObject3 != null) {
                ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).startWxMiniAppByAppId(getContext(), optString, "", optInt2, 0, null, nf2.a.e(optJSONObject3));
            } else {
                ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).startWxMiniAppByAppId(getContext(), optString, "", optInt2);
            }
        } else {
            LaunchParam launchParam = new LaunchParam();
            launchParam.miniAppId = optString;
            launchParam.scene = optInt;
            launchParam.envVersion = "";
            launchParam.entryPath = optString2;
            launchParam.navigateExtData = "";
            launchParam.reportData = reportData;
            launchParam.taskId = str;
            launchParam.taskType = i3;
            launchParam.taskAppId = str2;
            launchParam.isCloseGameBox = optBoolean;
            launchParam.via = str3;
            MiniAppLauncher.launchMiniAppById(getContext(), launchParam, null);
        }
        callBackSuccess(method, callback);
    }
}
