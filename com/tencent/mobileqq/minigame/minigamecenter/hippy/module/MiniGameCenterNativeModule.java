package com.tencent.mobileqq.minigame.minigamecenter.hippy.module;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.hippy.qq.module.QQBaseModule;
import com.tencent.mobileqq.icgame.api.IQQLiveUtil;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.minigame.kuikly.MiniGameKuiklyModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.IMiniBoxLauncher;
import com.tencent.qq.minibox.api.data.VirtualAppInfo;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.HippyPageProxy;
import com.tencent.tmediacodec.util.ThreadManager;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import us3.f;

/* compiled from: P */
@HippyNativeModule(name = MiniGameCenterNativeModule.TAG)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J\u001c\u0010\u000b\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J\u001c\u0010\f\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J\u001c\u0010\r\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J\u001c\u0010\u000e\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J\u001c\u0010\u000f\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J\u001c\u0010\u0010\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J\u001c\u0010\u0011\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J\u001c\u0010\u0012\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/minigame/minigamecenter/hippy/module/MiniGameCenterNativeModule;", "Lcom/tencent/hippy/qq/module/QQBaseModule;", "hippyEngineContext", "Lcom/tencent/mtt/hippy/HippyEngineContext;", "(Lcom/tencent/mtt/hippy/HippyEngineContext;)V", "closeGameBox", "", "params", "Lcom/tencent/mtt/hippy/common/HippyMap;", "promise", "Lcom/tencent/mtt/hippy/modules/Promise;", "completeGameBoxTask", "enterVaManagerPage", "getMiniBoxInstallApp", "hideGameBoxEntry", MiniGameKuiklyModule.METHOD_OPEN_MINI_APP, "preloadICGameRoom", MiniGameCenterNativeModule.METHOD_REMOVE_GAME_BOX_RED_DOT, "starVirtualApp", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameCenterNativeModule extends QQBaseModule {
    private static final int GAME_BOX_HIDE_TYPE_ALWAYS = 2;
    private static final int GAME_BOX_HIDE_TYPE_ONCE = 1;
    private static final String METHOD_REMOVE_GAME_BOX_RED_DOT = "removeGameBoxEntryRedDot";
    public static final int MINIBOX_CLICK_BY_APPID = 200;
    public static final int MINIBOX_CLICK_BY_APPINFO = 100;
    public static final int MINIBOX_CLICK_NO_DATA = -100;
    public static final String TAG = "MiniGameCenterNativeModule";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniGameCenterNativeModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
        Intrinsics.checkNotNullParameter(hippyEngineContext, "hippyEngineContext");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getMiniBoxInstallApp$lambda$3(Promise promise) {
        try {
            String miniBoxInstallApp = ((IMiniBoxLauncher) QRoute.api(IMiniBoxLauncher.class)).getMiniBoxInstallApp();
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushString("installApps", miniBoxInstallApp);
            if (promise != null) {
                promise.resolve(hippyMap);
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[getMiniBoxInstallApp error] msg:" + th5.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hideGameBoxEntry$lambda$4(String appId, Integer num) {
        Intrinsics.checkNotNullParameter(appId, "$appId");
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).removeGameBoxView(appId, num != null && num.intValue() == 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeGameBoxEntryRedDot$lambda$7$lambda$6(HashMap updateExt) {
        Intrinsics.checkNotNullParameter(updateExt, "$updateExt");
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).updateFloatView(18, METHOD_REMOVE_GAME_BOX_RED_DOT, updateExt);
    }

    @HippyMethod(name = "closeGameBox")
    public final void closeGameBox(HippyMap params, Promise promise) {
        HippyPageProxy hippyPageProxy = (HippyPageProxy) ProxyManager.get(HippyPageProxy.class);
        if (hippyPageProxy != null) {
            hippyPageProxy.closeHippyPage();
        }
    }

    @HippyMethod(name = "completeGameBoxTask")
    public final void completeGameBoxTask(HippyMap params, Promise promise) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, ">>>> completeGameBoxTask >>>>>");
        }
        if (params == null) {
            QLog.e(TAG, 1, ">>>> completeGameBoxTask >>>> params is null, return!");
            return;
        }
        String string = params.getString("appId");
        String string2 = params.getString(MiniAppGetGameTaskTicketServlet.KEY_TASKID);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, ">>>> completeGameBoxTask >>>> " + string + " >> " + string2);
        }
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).completeGameBoxTask(BaseApplication.getContext(), string2, string);
    }

    @HippyMethod(name = "enterVaManagerPage")
    public final void enterVaManagerPage(HippyMap params, Promise promise) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, ">>>> enterVaManagerPage");
        }
        String string = params != null ? params.getString("recommendData") : null;
        Intent intent = new Intent();
        if (string != null) {
            intent.putExtra("recommendData", f.f439985a.c(string));
        }
        QRouteApi api = QRoute.api(IMiniBoxLauncher.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IMiniBoxLauncher::class.java)");
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        IMiniBoxLauncher.a.a((IMiniBoxLauncher) api, context, "", null, 4, null);
    }

    @HippyMethod(name = "getMiniBoxInstallApp")
    public final void getMiniBoxInstallApp(HippyMap params, final Promise promise) {
        ThreadManager.execute(new Runnable() { // from class: com.tencent.mobileqq.minigame.minigamecenter.hippy.module.c
            @Override // java.lang.Runnable
            public final void run() {
                MiniGameCenterNativeModule.getMiniBoxInstallApp$lambda$3(Promise.this);
            }
        });
    }

    @HippyMethod(name = "preloadICGameRoom")
    public final void preloadICGameRoom(HippyMap params, Promise promise) {
        ((IQQLiveUtil) QRoute.api(IQQLiveUtil.class)).preloadICGameRoom();
    }

    @HippyMethod(name = MiniGameKuiklyModule.METHOD_OPEN_MINI_APP)
    public final void openMiniApp(HippyMap params, Promise promise) {
        String str;
        String str2;
        int i3;
        String str3;
        String str4;
        int i16;
        String str5;
        int i17;
        boolean startsWith$default;
        if (params == null) {
            QLog.e(TAG, 1, ">>>> openMiniApp >>>> params is null, return!");
            return;
        }
        String appId = params.getString("appId");
        String string = params.getString("path");
        int i18 = params.getInt("scene");
        HippyMap map = params.getMap("task");
        boolean z16 = params.getBoolean("closeFloatingBox");
        if (map != null && map.size() > 0) {
            i3 = map.getInt("taskType");
            str = map.getString(MiniAppGetGameTaskTicketServlet.KEY_TASKID);
            Intrinsics.checkNotNullExpressionValue(str, "taskParams.getString(\"taskId\")");
            str2 = map.getString("taskAppId");
            Intrinsics.checkNotNullExpressionValue(str2, "taskParams.getString(\"taskAppId\")");
            if (QLog.isColorLevel()) {
                QLog.d("floatBox.QQ", 2, ">>>> openMiniApp >>>> " + appId + " >> " + i3 + " >> " + str2 + " >> " + z16 + "  >> " + str);
            }
        } else {
            str = "0";
            str2 = "";
            i3 = 0;
        }
        HippyMap map2 = params.getMap("virtualAppData");
        if (!params.containsKey("reportData")) {
            str3 = str2;
            str4 = "";
        } else {
            str4 = params.getString("reportData");
            str3 = str2;
            Intrinsics.checkNotNullExpressionValue(str4, "params.getString(\"reportData\")");
        }
        if (map2 == null) {
            i16 = i3;
            str5 = "";
        } else {
            if (!map2.containsKey("via")) {
                i16 = i3;
                str5 = "";
            } else {
                str5 = map2.getString("via");
                i16 = i3;
                Intrinsics.checkNotNullExpressionValue(str5, "virtualAppData.getString(\"via\")");
            }
            if (map2.containsKey("categoryTag")) {
                String string2 = map2.getString("categoryTag");
                if (!TextUtils.isEmpty(string2) && params.containsKey("reportData")) {
                    str4 = str4 + "&category_tag=" + string2;
                }
            }
        }
        if (QLog.isColorLevel()) {
            i17 = 2;
            QLog.d(TAG, 2, ">>>> openMiniApp >>>> " + appId + " >> " + string + " >> " + i18 + " >> " + str4 + " >> " + z16);
        } else {
            i17 = 2;
        }
        if (TextUtils.isEmpty(appId)) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(appId, "appId");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(appId, "wx", false, i17, null);
        if (startsWith$default) {
            ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).startWxMiniAppByAppId(BaseApplication.getContext(), appId, string, i18);
            return;
        }
        LaunchParam launchParam = new LaunchParam();
        launchParam.miniAppId = appId;
        launchParam.scene = i18;
        launchParam.envVersion = "";
        launchParam.entryPath = string;
        launchParam.navigateExtData = "";
        launchParam.reportData = str4;
        launchParam.taskId = str;
        launchParam.taskType = i16;
        launchParam.taskAppId = str3;
        launchParam.isCloseGameBox = z16;
        launchParam.via = str5;
        MiniAppLauncher.launchMiniAppById(BaseApplication.getContext(), launchParam, null);
    }

    @HippyMethod(name = METHOD_REMOVE_GAME_BOX_RED_DOT)
    public final void removeGameBoxEntryRedDot(HippyMap params, Promise promise) {
        String string;
        if (params == null || (string = params.getString("appId")) == null) {
            return;
        }
        final HashMap hashMap = new HashMap();
        hashMap.put("appId", string);
        com.tencent.qqmini.sdk.core.manager.ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.minigame.minigamecenter.hippy.module.a
            @Override // java.lang.Runnable
            public final void run() {
                MiniGameCenterNativeModule.removeGameBoxEntryRedDot$lambda$7$lambda$6(hashMap);
            }
        });
    }

    @HippyMethod(name = "hideGameBoxEntry")
    public final void hideGameBoxEntry(HippyMap params, Promise promise) {
        final String string = params != null ? params.getString("appId") : null;
        if (string == null) {
            string = "";
        }
        final Integer valueOf = params != null ? Integer.valueOf(params.getInt("hideType")) : null;
        com.tencent.qqmini.sdk.core.manager.ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.minigame.minigamecenter.hippy.module.b
            @Override // java.lang.Runnable
            public final void run() {
                MiniGameCenterNativeModule.hideGameBoxEntry$lambda$4(string, valueOf);
            }
        });
    }

    @HippyMethod(name = "starVirtualApp")
    public final void starVirtualApp(HippyMap params, Promise promise) {
        int i3;
        Unit unit;
        int i16;
        String string = params != null ? params.getString("virtualAppData") : null;
        if (string != null) {
            VirtualAppInfo b16 = f.f439985a.b(string);
            IMiniBoxLauncher iMiniBoxLauncher = (IMiniBoxLauncher) QRoute.api(IMiniBoxLauncher.class);
            BaseApplication context = BaseApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext()");
            iMiniBoxLauncher.startVirtualApp(context, b16, 1);
            unit = Unit.INSTANCE;
            i3 = 100;
        } else {
            i3 = -1;
            unit = null;
        }
        if (unit == null) {
            String string2 = params != null ? params.getString("virtualAppId") : null;
            if (TextUtils.isEmpty(string2)) {
                i16 = -100;
            } else {
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).startAppByAppid(BaseApplication.getContext(), string2, "", "", 0, null);
                i16 = 200;
            }
            i3 = i16;
        }
        ((IMiniBoxLauncher) QRoute.api(IMiniBoxLauncher.class)).reportHippyEntryStatus(i3);
        if (promise != null) {
            promise.resolve(Integer.valueOf(i3));
        }
    }
}
