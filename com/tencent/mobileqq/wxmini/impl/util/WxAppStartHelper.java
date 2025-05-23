package com.tencent.mobileqq.wxmini.impl.util;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.servlet.MiniAppGetTeenagerConfigServlet;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.util.cl;
import com.tencent.mobileqq.wxmini.servlet.WxMiniAppCmdUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import common.config.service.QzoneConfig;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes35.dex */
public class WxAppStartHelper {

    /* renamed from: d, reason: collision with root package name */
    private static int f327773d;

    /* renamed from: e, reason: collision with root package name */
    private static int f327774e;

    /* renamed from: a, reason: collision with root package name */
    private static final String f327770a = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.SECONDARY_KEY_STUDY_MODE_SCENE_WHITELIST, QzoneConfig.DEFAULT_STUDY_MODE_SCENE_WHITELIST);

    /* renamed from: b, reason: collision with root package name */
    private static final String f327771b = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.SECONDARY_KEY_STUDY_MODE_APPID_WHITELIST, QzoneConfig.DEFAULT_STUDY_MODE_APPID_WHITELIST);

    /* renamed from: c, reason: collision with root package name */
    private static String f327772c = "remoteAppidWhiteList";

    /* renamed from: f, reason: collision with root package name */
    private static String f327775f = "";

    /* renamed from: g, reason: collision with root package name */
    private static Runnable f327776g = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class a implements MiniAppCmdInterface {
        a() {
        }

        @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
        public void onCmdListener(boolean z16, JSONObject jSONObject) {
            QLog.e("[wxa-q]WxAppStartHelper", 1, "remote onCmdListener isSuc " + z16 + " ret = " + jSONObject);
            if (!z16 || jSONObject == null) {
                return;
            }
            WxAppStartHelper.f327773d = jSONObject.optInt(MiniAppGetTeenagerConfigServlet.KEY_FREQUENCY_SWITCH, -1);
            WxAppStartHelper.f327774e = jSONObject.optInt(MiniAppGetTeenagerConfigServlet.KEY_TIME_INTERVAL, -1);
            String optString = jSONObject.optString(MiniAppGetTeenagerConfigServlet.KEY_APPID_LIST, "");
            if (TextUtils.isEmpty(optString)) {
                QLog.i("[wxa-q]WxAppStartHelper", 1, "remote appIdWhiteList is empty.");
            }
            if (TextUtils.isEmpty(WxAppStartHelper.f327775f) || !WxAppStartHelper.f327775f.equals(optString)) {
                cl.g(BaseApplication.getContext(), WxAppStartHelper.f327772c);
                cl.j(BaseApplication.getContext(), WxAppStartHelper.f327772c, optString);
                WxAppStartHelper.f327775f = optString;
            }
            WxAppStartHelper.k();
        }
    }

    public static boolean j(String str, String str2) {
        if (!StudyModeManager.t()) {
            QLog.d("[wxa-q]WxAppStartHelper", 1, "shouldInterceptStartMiniApp is not teenager mode!");
            return false;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wxmini.impl.util.WxAppStartHelper.1
            @Override // java.lang.Runnable
            public void run() {
                if (WxAppStartHelper.f327773d == 0) {
                    WxAppStartHelper.l();
                } else {
                    QLog.i("[wxa-q]WxAppStartHelper", 1, "frequency switch is on, skip update whitelist.");
                }
            }
        }, 16, null, true);
        String str3 = f327771b;
        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str) && str3.contains(str)) {
            QLog.d("[wxa-q]WxAppStartHelper", 1, "shouldInterceptStartMiniApp in white appId!");
            return false;
        }
        String str4 = f327770a;
        if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str2) && str4.contains(str2)) {
            QLog.d("[wxa-q]WxAppStartHelper", 1, "shouldInterceptStartMiniApp in white scene!");
            return false;
        }
        if (TextUtils.isEmpty(f327775f)) {
            f327775f = cl.d(BaseApplication.getContext(), f327772c);
        }
        QLog.i("[wxa-q]WxAppStartHelper", 1, "mAppIDWhiteListRemote=" + f327775f);
        if (TextUtils.isEmpty(f327775f) || TextUtils.isEmpty(str) || !f327775f.contains(str)) {
            return true;
        }
        QLog.d("[wxa-q]WxAppStartHelper", 1, "shouldInterceptStartMiniApp is not teenager mode!");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k() {
        long j3 = f327774e * 1000;
        if (j3 > 0) {
            Runnable runnable = f327776g;
            if (runnable != null) {
                ThreadManagerV2.removeJob(runnable, 16);
            }
            f327776g = ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.wxmini.impl.util.WxAppStartHelper.3
                @Override // java.lang.Runnable
                public void run() {
                    QLog.i("[wxa-q]WxAppStartHelper", 1, " start mUpdateWhiteListRunnable");
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wxmini.impl.util.WxAppStartHelper.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QLog.i("[wxa-q]WxAppStartHelper", 1, "get whitelist at intervals.");
                            WxAppStartHelper.l();
                        }
                    }, 16, null, true);
                }
            }, 16, null, true, j3);
        }
    }

    public static void l() {
        WxMiniAppCmdUtil.e().f("", new a());
    }

    public static boolean m(String str, int i3) {
        if (!j(str, String.valueOf(i3))) {
            return true;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            QQToastUtil.showQQToast(0, R.string.f167672dk);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wxmini.impl.util.a
                @Override // java.lang.Runnable
                public final void run() {
                    QQToastUtil.showQQToast(0, R.string.f167672dk);
                }
            });
        }
        return false;
    }
}
