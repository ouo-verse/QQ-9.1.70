package com.tencent.common.app;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Process;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.bigbrother.TeleScreenRunnable;
import com.tencent.mobileqq.haoliyou.IATHandler;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.ApplicationDelegate;
import com.tencent.mobileqq.qfix.QFixApplication;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.ThirdAppReportHelper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFixApplicationImpl extends QFixApplication {
    static IPatchRedirector $redirector_ = null;
    private static final int MAX_COUNT_FAIL_INSTALL_PATCH = 3;
    private static final int MAX_COUNT_FAIL_STARTUP_PATCH = 5;
    private static final int MAX_COUNT_N_CRASH_PER_HOUR = 3;
    private static final int MAX_COUNT_N_TRY_START = 3;
    private static final String TAG = "QFixAppImpl_PatchLogTag";
    public static String sDefaultDelegateClass;
    public static boolean sNLoaderUsing;
    private static String sProcessName;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(66012);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        sDefaultDelegateClass = "com.tencent.common.app.BaseApplicationImpl";
        sProcessName = null;
        sNLoaderUsing = false;
    }

    public QFixApplicationImpl() {
        super(sDefaultDelegateClass);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private JSONObject getLatestPatchConfig(String str) {
        JSONArray jSONArray;
        int optInt;
        try {
            if (TextUtils.isEmpty(str)) {
                jSONArray = new JSONArray();
            } else {
                jSONArray = new JSONArray(str);
            }
            if (jSONArray.length() == 0) {
                return null;
            }
            if (jSONArray.length() == 1) {
                return jSONArray.getJSONObject(0);
            }
            JSONObject jSONObject = null;
            int i3 = 0;
            for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i16);
                if (jSONObject2 != null && (optInt = jSONObject2.optInt("patchVersion", 0)) > i3) {
                    jSONObject = jSONObject2;
                    i3 = optInt;
                }
            }
            return jSONObject;
        } catch (JSONException e16) {
            Log.d(TAG, "getLatestPatchConfig exception=" + e16);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
    
        r0 = r1.processName;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getProcessName(Context context) {
        String str = sProcessName;
        if (str != null) {
            return str;
        }
        String str2 = null;
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
            if (runningAppProcesses != null) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next != null && next.pid == Process.myPid()) {
                        break;
                    }
                }
            }
        } catch (Exception unused) {
        }
        if (str2 == null) {
            str2 = "com.tencent.mobileqq";
        }
        sProcessName = str2;
        return str2;
    }

    public static int getVersionCode(Context context) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String getVersionName(Context context) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qfix.QFixApplication, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        } else {
            com.tencent.mobileqq.perf.startup.f.c(context);
            super.attachBaseContext(context);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SharedPreferences) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, i3);
        }
        ApplicationDelegate applicationDelegate = this.applicationLike;
        if (applicationDelegate != null) {
            return applicationDelegate.getSharedPreferences(str, i3);
        }
        return super.getSharedPreferences(str, i3);
    }

    public SharedPreferences getSystemSharedPreferences(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (SharedPreferences) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, i3);
        }
        return super.getSharedPreferences(str, i3);
    }

    @Override // com.tencent.mobileqq.qfix.QFixApplication
    public boolean isAndroidNPatchEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        sNLoaderUsing = false;
        return false;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent);
            return;
        }
        try {
            FileProvider7Helper.intentCompatForN(this, intent);
            ThirdAppReportHelper.reportThirdAppOpen(this, intent, 0);
            IATHandler.shellCheckAndDoSync(this, intent, new TeleScreenRunnable(intent) { // from class: com.tencent.common.app.QFixApplicationImpl.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Intent f99524d;

                {
                    this.f99524d = intent;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QFixApplicationImpl.this, (Object) intent);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        try {
                            QFixApplicationImpl.super.startActivity(this.f99524d);
                            return;
                        } catch (Throwable th5) {
                            QLog.e(QFixApplicationImpl.TAG, 1, th5, new Object[0]);
                            return;
                        }
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) intent, (Object) bundle);
            return;
        }
        try {
            FileProvider7Helper.intentCompatForN(this, intent);
            ThirdAppReportHelper.reportThirdAppOpen(this, intent, 0);
            IATHandler.shellCheckAndDoSync(this, intent, new TeleScreenRunnable(intent, bundle) { // from class: com.tencent.common.app.QFixApplicationImpl.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Intent f99525d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Bundle f99526e;

                {
                    this.f99525d = intent;
                    this.f99526e = bundle;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, QFixApplicationImpl.this, intent, bundle);
                    }
                }

                @Override // java.lang.Runnable
                @RequiresApi(api = 16)
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        try {
                            QFixApplicationImpl.super.startActivity(this.f99525d, this.f99526e);
                            return;
                        } catch (Throwable th5) {
                            QLog.e(QFixApplicationImpl.TAG, 1, th5, new Object[0]);
                            return;
                        }
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }
}
