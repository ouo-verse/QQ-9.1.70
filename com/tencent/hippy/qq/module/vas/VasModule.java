package com.tencent.hippy.qq.module.vas;

import a33.b;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.fragment.HippyActivityLifecycleDispatcher;
import com.tencent.hippy.qq.fragment.HippyActivityLifecycleOwner;
import com.tencent.hippy.qq.module.QQBaseLifecycleModule;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VipMMKV;
import com.tencent.mobileqq.vas.api.IVasReaderApi;
import com.tencent.mobileqq.vas.api.IVasWebUrl;
import com.tencent.mobileqq.vas.api.VasSkey;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.hippy.VasFriendInfoHippyHelper;
import com.tencent.mobileqq.vas.hippy.VasHippyFontUtils;
import com.tencent.mobileqq.vas.hippy.d;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.mobileqq.webview.swift.cookie.SwiftTicketCookie;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.api.cookie.QQLiveCookieConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import mqq.manager.TicketManager;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import sd2.a;

/* compiled from: P */
@HippyNativeModule(name = VasModule.TAG)
/* loaded from: classes7.dex */
public class VasModule extends QQBaseLifecycleModule {
    private static final int ERROR_CODE_HIPPY_ENV = -2;
    private static final int ERROR_CODE_INNER = -1;
    private static final int ERROR_CODE_MODULE = -3;
    private static final String METHOD_PRELOAD_TOOL_PROCESS = "preloadToolProcess";
    public static final String MMKV_KEY_DT_REPORT_INDEX = "mmkv_key_dt_report_index";
    static final String TAG = "VasModule";
    private static final boolean removePt4Token = ar.INSTANCE.b("kenaiyu", "2024-12-13", "vas_bug_removept4token").isEnable(true);
    private final String METHOD_DOWNLOAD_FONT;
    private final String METHOD_GET_AUTH;
    private final String METHOD_GET_DT_REPORT_INDEX;
    private final String METHOD_GET_FRIEND_INFO;
    private final String METHOD_JUMP_SIGNATURE_PAGE;
    Promise mPromise;
    private ArrayList<String> mWhiteListOfGetFriendInfo;

    public VasModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
        this.METHOD_GET_AUTH = "getAuth";
        this.METHOD_JUMP_SIGNATURE_PAGE = "jumpSignaturePage";
        this.METHOD_GET_FRIEND_INFO = VasCommonJsPlugin.H5_CALLBACK_GETFRIENDINFO;
        this.METHOD_DOWNLOAD_FONT = "downloadFont";
        this.METHOD_GET_DT_REPORT_INDEX = "getDTReportIndexDic";
        this.mWhiteListOfGetFriendInfo = new ArrayList<String>() { // from class: com.tencent.hippy.qq.module.vas.VasModule.2
            {
                add(HippyQQConstants.ModuleName.QQ_VIP);
                add(HippyQQConstants.ModuleName.QQ_YELLOW_VIP);
                add(HippyQQConstants.ModuleName.QQ_BIG_CLUB);
                add(HippyQQConstants.ModuleName.QQ_VIP_PAY);
                add(HippyQQConstants.ModuleName.QQ_VIP_SSR);
                add(HippyQQConstants.ModuleName.QQ_VIP_V2);
            }
        };
    }

    public static void aSyncGetAuthWithDomain(final String str, final Promise promise) {
        AppInterface appInterface;
        String str2;
        if (checkDomainValid(str, promise) && (appInterface = HippyUtils.getAppInterface()) != null && appInterface.isLogin()) {
            final String currentAccountUin = appInterface.getCurrentAccountUin();
            if (!removePt4Token) {
                str2 = SwiftTicketCookie.p(appInterface, str);
            } else {
                str2 = "";
            }
            final String str3 = str2;
            final TicketManager ticketManager = (TicketManager) appInterface.getManager(2);
            ((IPskeyManager) appInterface.getRuntimeService(IPskeyManager.class, "all")).getPskey(new String[]{str}, new a() { // from class: com.tencent.hippy.qq.module.vas.VasModule.1
                @Override // sd2.a
                public void onFail(@NonNull String str4) {
                    QLog.e(VasModule.TAG, 1, "asyncTicket failed:", str4);
                    Promise.this.reject("get domain fail" + str4);
                    VasCommonReporter.getNewPsKey().setNum1(-1L).setValue1(str4).report(true);
                }

                @Override // sd2.a
                public void onSuccess(@NonNull Map<String, String> map) {
                    String str4 = map.get(str);
                    if (QLog.isColorLevel()) {
                        QLog.e(VasModule.TAG, 2, "psKey:", str4);
                    }
                    String onGetPskey = VasModule.onGetPskey(currentAccountUin, ticketManager, str4, str3);
                    if (!TextUtils.isEmpty(onGetPskey)) {
                        Promise.this.resolve(onGetPskey);
                        VasCommonReporter.getNewPsKey().setNum1(0L).setValue1(str4).report(true);
                    } else {
                        Promise.this.reject("unknown error");
                    }
                }
            });
        }
    }

    private static boolean checkDomainValid(String str, Promise promise) {
        if (TextUtils.isEmpty(str)) {
            if (promise != null) {
                promise.reject("params domain is empty");
            }
            return false;
        }
        if (!isEnableGetAuth(str)) {
            if (promise != null) {
                promise.reject("domain need to be add to whitelist");
            }
            return false;
        }
        return true;
    }

    public static String getAuthWithDomain(String str, Promise promise) {
        AppInterface appInterface;
        String str2;
        if (!checkDomainValid(str, promise) || (appInterface = HippyUtils.getAppInterface()) == null || !appInterface.isLogin()) {
            return null;
        }
        String currentAccountUin = appInterface.getCurrentAccountUin();
        if (!removePt4Token) {
            str2 = SwiftTicketCookie.p(appInterface, str);
        } else {
            str2 = "";
        }
        return onGetPskey(currentAccountUin, (TicketManager) appInterface.getManager(2), VasSkey.getPSkey(appInterface, str), str2);
    }

    private static boolean isEnableGetAuth(@NotNull String str) {
        return ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).checkDomainPermission(str);
    }

    private boolean lifeCyclePrepared() {
        HippyActivityLifecycleOwner hippyActivityLifecycleOwner = getHippyActivityLifecycleOwner();
        if (hippyActivityLifecycleOwner != null) {
            HippyActivityLifecycleDispatcher activityLifecycleDispatcher = hippyActivityLifecycleOwner.getActivityLifecycleDispatcher();
            activityLifecycleDispatcher.removeActivityLifecycleListener(this);
            activityLifecycleDispatcher.addActivityLifecycleListener(this);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String onGetPskey(String str, TicketManager ticketManager, String str2, String str3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uin", str);
            jSONObject.put(QQLiveCookieConstants.CookieKeys.COOKIE_KEY_P_UIN, str);
            jSONObject.put("skey", VasSkey.getSkey(ticketManager, str));
            jSONObject.put("p_skey", str2);
            if (!removePt4Token) {
                jSONObject.put("pt4_token", str3);
            }
            return jSONObject.toString();
        } catch (Throwable th5) {
            QLog.e(TAG, 2, "getAuth error = " + th5);
            return null;
        }
    }

    @HippyMethod(name = "deleteFile")
    public void deleteFile(HippyMap hippyMap, Promise promise) {
        int i3;
        if (hippyMap != null && getActivity() != null) {
            i3 = ((IVasReaderApi) QRoute.api(IVasReaderApi.class)).deleteFile(new File(getActivity().getCacheDir(), "vasNovel" + hippyMap.getString("subFilePath")).getAbsolutePath());
        } else {
            i3 = -1;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ret", i3);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, e16.getCause(), new Object[0]);
        }
        promise.resolve(jSONObject.toString());
    }

    @HippyMethod(name = "downloadFont")
    public void downloadFont(HippyArray hippyArray, Promise promise) {
        VasHippyFontUtils.k(hippyArray, promise);
    }

    @HippyMethod(name = "fetchFileList")
    public void fetchFileList(HippyMap hippyMap, Promise promise) {
        String str;
        if (hippyMap != null && getActivity() != null) {
            str = ((IVasReaderApi) QRoute.api(IVasReaderApi.class)).getFileList(new File(getActivity().getCacheDir(), "vasNovel" + hippyMap.getString("subFilePath")).getAbsolutePath());
        } else {
            str = "";
        }
        promise.resolve(str);
    }

    @HippyMethod(name = "getAuth")
    public void getAuth(HippyMap hippyMap, Promise promise) {
        if (promise == null) {
            return;
        }
        if (hippyMap != null && hippyMap.size() > 0) {
            HippyQQEngine engineInstance = HippyQQEngine.getEngineInstance(this.mContext.getEngineId());
            if (engineInstance == null) {
                promise.reject("engine is null");
                return;
            } else if (TextUtils.isEmpty(engineInstance.getModuleName())) {
                promise.reject("moduleName is empty");
                return;
            } else {
                aSyncGetAuthWithDomain(hippyMap.getString("domain"), promise);
                return;
            }
        }
        promise.reject("params is empty");
    }

    @HippyMethod(name = "getAvailableSpace")
    public void getAvailableSpace(HippyMap hippyMap, Promise promise) {
        String str;
        if (hippyMap != null) {
            str = ((IVasReaderApi) QRoute.api(IVasReaderApi.class)).getAvailableSpace();
        } else {
            str = "";
        }
        promise.resolve(str);
    }

    @HippyMethod(name = "getDTReportIndexDic")
    public void getDTReportIndex(Promise promise) {
        if (promise == null) {
            return;
        }
        String decodeString = VipMMKV.getCommon().decodeString(MMKV_KEY_DT_REPORT_INDEX, "");
        if (!TextUtils.isEmpty(decodeString)) {
            promise.resolve(decodeString);
        } else {
            promise.reject("index is empty");
        }
    }

    @HippyMethod(name = VasCommonJsPlugin.H5_CALLBACK_GETFRIENDINFO)
    public void getFriendInfo(HippyMap hippyMap, Promise promise) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "call getFriendInfo");
        }
        HippyQQEngine engineInstance = HippyQQEngine.getEngineInstance(this.mContext.getEngineId());
        if (engineInstance == null) {
            promise.reject(d.a(-2, "engine is null", null));
            return;
        }
        String moduleName = engineInstance.getModuleName();
        if (TextUtils.isEmpty(moduleName)) {
            promise.reject(d.a(-3, "moduleName don`t support", null));
            return;
        }
        if (!this.mWhiteListOfGetFriendInfo.contains(moduleName)) {
            promise.reject(d.a(-3, "moduleName don`t support", null));
        } else if (!lifeCyclePrepared()) {
            promise.reject(d.a(-2, "lifeCycle not prepared", null));
        } else {
            this.mPromise = promise;
            VasFriendInfoHippyHelper.c(hippyMap, promise, getActivity());
        }
    }

    @HippyMethod(name = "jumpSignaturePage")
    public void jumpSignaturePage(HippyMap hippyMap, Promise promise) {
        int i3 = hippyMap.getInt("templateId");
        int i16 = hippyMap.getInt(MessageForRichState.SIGN_MSG_FONT_ID);
        String string = hippyMap.getString("url");
        if (TextUtils.isEmpty(string)) {
            string = ((IVasWebUrl) QRoute.api(IVasWebUrl.class)).getUrl(IndividuationUrlHelper.UrlId.SIGNATURE_EDIT);
        }
        Bundle bundle = new Bundle();
        bundle.putString("signUrl", string);
        b.f(getActivity(), getAppInterface(), 0, "signature_geqian", -1, i3, i16, bundle);
        promise.resolve("success");
    }

    @HippyMethod(name = "novelGetFileSize")
    public void novelGetFileSize(HippyMap hippyMap, Promise promise) {
        String str;
        if (hippyMap != null && getActivity() != null) {
            str = ((IVasReaderApi) QRoute.api(IVasReaderApi.class)).getFileSize(new File(getActivity().getCacheDir(), "vasNovel" + hippyMap.getString("subFilePath")).getAbsolutePath());
        } else {
            str = "";
        }
        promise.resolve(str);
    }

    @Override // com.tencent.hippy.qq.module.QQBaseLifecycleModule, com.tencent.hippy.qq.fragment.HippyActivityLifecycleListener
    public void onActivityResult(Activity activity, int i3, int i16, Intent intent) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onActivityResult requestCode = " + i3 + " resultCode = " + i16);
        }
        Promise promise = this.mPromise;
        if (promise == null) {
            QLog.e(TAG, 2, "mPromise is null");
            return;
        }
        this.mPromise = null;
        if (i16 != -1) {
            if (i16 == 0) {
                if (i3 == 49) {
                    promise.reject(d.a(-1, "user choice nobody", null));
                    return;
                } else {
                    if (i3 == 50) {
                        promise.reject(d.a(-1, "user choice nobody", null));
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (i3 == 49) {
            VasFriendInfoHippyHelper.a(intent, promise);
        }
    }

    @Override // com.tencent.hippy.qq.module.QQBaseLifecycleModule, com.tencent.hippy.qq.fragment.HippyActivityLifecycleListener
    public void onNewIntent(Activity activity, Intent intent) {
        super.onNewIntent(activity, intent);
    }

    @HippyMethod(name = METHOD_PRELOAD_TOOL_PROCESS)
    public void preloadToolProcess(HippyMap hippyMap, Promise promise) {
        if (promise == null) {
            return;
        }
        HippyQQEngine engineInstance = HippyQQEngine.getEngineInstance(this.mContext.getEngineId());
        if (engineInstance == null) {
            promise.reject("engine is null");
        } else if (TextUtils.isEmpty(engineInstance.getModuleName())) {
            promise.reject("moduleName is empty");
        } else {
            ((IWebProcessPreload) QRoute.api(IWebProcessPreload.class)).preloadWebProcess(35, null);
            promise.resolve("success");
        }
    }

    @HippyMethod(name = "readFileByString")
    public void readFile(HippyMap hippyMap, Promise promise) {
        String str;
        if (hippyMap != null && getActivity() != null) {
            str = ((IVasReaderApi) QRoute.api(IVasReaderApi.class)).readFile(new File(getActivity().getCacheDir(), "vasNovel" + hippyMap.getString("subFilePath")).getAbsolutePath());
        } else {
            str = "";
        }
        promise.resolve(str);
    }

    @HippyMethod(name = "writeFileByString")
    public void writeFile(HippyMap hippyMap, Promise promise) {
        int i3;
        if (hippyMap != null && getActivity() != null) {
            i3 = ((IVasReaderApi) QRoute.api(IVasReaderApi.class)).writeFile(new File(getActivity().getCacheDir(), "vasNovel" + hippyMap.getString("subFilePath")).getAbsolutePath(), hippyMap.getBoolean("isAppend"), hippyMap.getString("data"));
        } else {
            i3 = -1;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ret", i3);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, e16.getCause(), new Object[0]);
        }
        promise.resolve(jSONObject.toString());
    }
}
