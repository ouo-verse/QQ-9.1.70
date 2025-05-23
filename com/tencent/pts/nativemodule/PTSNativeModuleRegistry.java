package com.tencent.pts.nativemodule;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.pts.utils.PTSLog;
import java.util.HashMap;

/* loaded from: classes22.dex */
public class PTSNativeModuleRegistry {
    static IPatchRedirector $redirector_ = null;
    public static final String MODULE_NAME_ALL_IN_ONE_JUMP_REQUEST = "AllInOneJumpModule";
    public static final String MODULE_NAME_HANDLE_JS_EXCEPTION = "HandleJSException";
    public static final String MODULE_NAME_LOAD_FEEDS = "LoadFeedsModule";
    public static final String MODULE_NAME_MAKE_HTTP_REQUEST = "MakeHttpRequest";
    public static final String MODULE_NAME_MARK_ARTICLE_READ = "MarkArticleRead";
    public static final String MODULE_NAME_NAVIGATE_TO = "NavigateToModule";
    public static final String MODULE_NAME_REPORT_TO_1160 = "ReportTo1160";
    public static final String MODULE_NAME_REQUEST_FEEDS = "RequestFeedsModule";
    public static final String TAG = "PTSNativeModuleRegistry";
    public static boolean sIsDemo;
    private static HashMap<String, PTSNativeModule> sNativeModuleMap;

    /* loaded from: classes22.dex */
    public interface IPTSMarkArticleRead extends PTSNativeModule {
        void markArticleRead(long j3, long j16);
    }

    /* loaded from: classes22.dex */
    public interface IPTSReportTo1160 extends PTSNativeModule {
        void reportTo1160(String str, String str2, long j3, int i3, String str3, String str4);
    }

    /* loaded from: classes22.dex */
    interface PTSNativeModule {
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37387);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sNativeModuleMap = new HashMap<>();
            sIsDemo = false;
        }
    }

    PTSNativeModuleRegistry() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void JSLog(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if ("EVENT".equalsIgnoreCase(str)) {
                PTSLog.e(TAG, str2);
                return;
            }
            if ("DEBUG".equalsIgnoreCase(str)) {
                PTSLog.d(TAG, str2);
                return;
            } else if ("INFO".equalsIgnoreCase(str)) {
                PTSLog.i(TAG, str2);
                return;
            } else {
                if ("WARN".equalsIgnoreCase(str)) {
                    PTSLog.w(TAG, str2);
                    return;
                }
                return;
            }
        }
        PTSLog.i(TAG, str2);
    }

    public static void allInOneJump(String str) {
        PTSNativeModule pTSNativeModule = sNativeModuleMap.get(MODULE_NAME_ALL_IN_ONE_JUMP_REQUEST);
        if (pTSNativeModule instanceof IPTSAllInOneJump) {
            ((IPTSAllInOneJump) pTSNativeModule).allInOneJump(str);
        }
    }

    public static void clearNativeModule() {
        sNativeModuleMap.clear();
    }

    public static String getEnvVariable(String str) {
        if (TextUtils.equals(str, "is_demo")) {
            if (sIsDemo) {
                return "1";
            }
            return "0";
        }
        if (TextUtils.equals(str, "platform")) {
            return "Android";
        }
        return "";
    }

    public static void handleJSException(int i3, int i16, String str) {
        PTSNativeModule pTSNativeModule = sNativeModuleMap.get(MODULE_NAME_HANDLE_JS_EXCEPTION);
        if (pTSNativeModule instanceof IPTSHandleJSException) {
            ((IPTSHandleJSException) pTSNativeModule).handleJSException(i3, i16, str);
        }
    }

    public static void loadFeeds(long j3, long j16, int i3, long j17) {
        PTSNativeModule pTSNativeModule = sNativeModuleMap.get(MODULE_NAME_LOAD_FEEDS);
        if (pTSNativeModule instanceof IPTSLoadFeeds) {
            ((IPTSLoadFeeds) pTSNativeModule).loadFeeds(j3, j16, i3, j17);
        }
    }

    public static void makeHTTPRequest(String str, int i3, long j3, long j16, long j17) {
        PTSNativeModule pTSNativeModule = sNativeModuleMap.get(MODULE_NAME_MAKE_HTTP_REQUEST);
        if (pTSNativeModule instanceof IPTSMakeHttpRequest) {
            ((IPTSMakeHttpRequest) pTSNativeModule).makeHTTPRequest(str, i3, j3, j16, j17);
        }
    }

    public static void markArticleRead(long j3, long j16) {
        PTSNativeModule pTSNativeModule = sNativeModuleMap.get(MODULE_NAME_MARK_ARTICLE_READ);
        if (pTSNativeModule instanceof IPTSMarkArticleRead) {
            ((IPTSMarkArticleRead) pTSNativeModule).markArticleRead(j3, j16);
        }
    }

    public static void navigateTo(String str) {
        PTSNativeModule pTSNativeModule = sNativeModuleMap.get(MODULE_NAME_NAVIGATE_TO);
        if (pTSNativeModule instanceof IPTSNavigateTo) {
            ((IPTSNavigateTo) pTSNativeModule).navigateTo(str);
        }
    }

    public static void ptsLogger(boolean z16, String str) {
        if (z16) {
            if (PTSLog.isColorLevel()) {
                PTSLog.i(TAG, str);
                return;
            }
            return;
        }
        PTSLog.i(TAG, str);
    }

    public static void registerNativeModule(String str, PTSNativeModule pTSNativeModule) {
        if (!TextUtils.isEmpty(str) && pTSNativeModule != null) {
            sNativeModuleMap.put(str, pTSNativeModule);
        }
    }

    public static void reportTo1160(String str, String str2, long j3, int i3, String str3, String str4) {
        PTSNativeModule pTSNativeModule = sNativeModuleMap.get(MODULE_NAME_REPORT_TO_1160);
        if (pTSNativeModule instanceof IPTSReportTo1160) {
            ((IPTSReportTo1160) pTSNativeModule).reportTo1160(str, str2, j3, i3, str3, str4);
        }
    }

    public static void requestFeeds(long j3, long j16, boolean z16, long j17, long j18) {
        PTSNativeModule pTSNativeModule = sNativeModuleMap.get(MODULE_NAME_REQUEST_FEEDS);
        if (pTSNativeModule instanceof IPTSRequestFeeds) {
            ((IPTSRequestFeeds) pTSNativeModule).requestFeeds(j3, j16, z16, j17, j18);
        }
    }
}
