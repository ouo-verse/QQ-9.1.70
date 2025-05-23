package com.tencent.could.component.common.ai.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.heytap.databaseengine.utils.DateUtil;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.could.component.common.ai.callback.CrashListener;
import com.tencent.could.component.common.ai.eventreport.api.EventReporter;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CloudCrashHandler implements Thread.UncaughtExceptionHandler {
    static IPatchRedirector $redirector_;
    private static String TAG;
    private static CloudCrashHandler crashHandler;
    private static Date curDate;
    private static SimpleDateFormat formatter;
    private static String str;
    private WeakReference<Context> contextWeakReference;
    private String crashInfoTag;
    private List<CrashListener> crashListeners;
    private WeakReference<Thread.UncaughtExceptionHandler> defaultHandler;
    private String filterString;
    private Map<String, String> infos;
    private boolean isFilter;
    private boolean isReleaseType;
    private volatile boolean isWriterCrash;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13783);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        formatter = new SimpleDateFormat(DateUtil.DATE_FORMAT_14);
        Date date = new Date(System.currentTimeMillis());
        curDate = date;
        str = formatter.format(date);
        TAG = "CloudCrashHandler";
    }

    CloudCrashHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.infos = new HashMap();
        this.crashInfoTag = "crash";
        this.isFilter = false;
        this.filterString = "";
        this.isReleaseType = false;
        this.isWriterCrash = false;
    }

    private void collectDeviceInfo(Context context) {
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 1);
            if (packageInfo != null) {
                String str2 = packageInfo.versionName;
                if (str2 == null) {
                    str2 = "null";
                }
                String str3 = packageInfo.versionCode + "";
                this.infos.put("versionName", str2);
                this.infos.put("versionCode", str3);
            }
        } catch (PackageManager.NameNotFoundException e16) {
            Log.e(TAG, "an error occured when collect package info", e16);
        }
    }

    private Context getContext() {
        WeakReference<Context> weakReference = this.contextWeakReference;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private Thread.UncaughtExceptionHandler getUncaughtDefaultHandler() {
        WeakReference<Thread.UncaughtExceptionHandler> weakReference = this.defaultHandler;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private boolean handleException(Throwable th5) {
        Context context;
        if (th5 == null || (context = getContext()) == null || this.isWriterCrash) {
            return false;
        }
        this.isWriterCrash = true;
        collectDeviceInfo(context);
        saveCrashInfo2File(context, th5);
        return false;
    }

    public static CloudCrashHandler instance() {
        if (crashHandler == null) {
            crashHandler = new CloudCrashHandler();
        }
        return crashHandler;
    }

    private String saveCrashInfo2File(Context context, Throwable th5) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : this.infos.entrySet()) {
            stringBuffer.append(entry.getKey() + ContainerUtils.KEY_VALUE_DELIMITER + entry.getValue() + "\n");
        }
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th5.printStackTrace(printWriter);
            for (Throwable cause = th5.getCause(); cause != null; cause = cause.getCause()) {
                cause.printStackTrace(printWriter);
            }
            printWriter.close();
            String obj = stringWriter.toString();
            stringWriter.close();
            String str2 = "";
            if (TextUtils.isEmpty(obj)) {
                return "";
            }
            if (this.isFilter && !obj.contains(this.filterString)) {
                return "";
            }
            sendCrashCallBack(obj);
            stringBuffer.append(obj);
            String stringBuffer2 = stringBuffer.toString();
            EventReporter.getInstance().doReportErrorInfo("Crash", stringBuffer2, "");
            if (this.isReleaseType) {
                return "";
            }
            File externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir != null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(externalCacheDir);
                String str3 = File.separator;
                sb5.append(str3);
                sb5.append(this.crashInfoTag);
                sb5.append(str3);
                str2 = sb5.toString();
            }
            if (TextUtils.isEmpty(str2)) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(context.getCacheDir().getAbsolutePath());
                String str4 = File.separator;
                sb6.append(str4);
                sb6.append(this.crashInfoTag);
                sb6.append(str4);
                str2 = sb6.toString();
            }
            String str5 = "crash-" + str + "-" + System.currentTimeMillis() + ".log";
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(str2 + str5);
            fileOutputStream.write(stringBuffer2.getBytes());
            fileOutputStream.close();
            return str5;
        } catch (Exception e16) {
            Log.e(TAG, "an error occured while writing file...", e16);
            return null;
        }
    }

    private void sendCrashCallBack(String str2) {
        List<CrashListener> list = this.crashListeners;
        if (list == null) {
            return;
        }
        Iterator<CrashListener> it = list.iterator();
        while (it.hasNext()) {
            it.next().onCrash(str2);
        }
    }

    public void addCrashListener(CrashListener crashListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) crashListener);
            return;
        }
        if (this.crashListeners == null) {
            this.crashListeners = new ArrayList();
        }
        this.crashListeners.add(crashListener);
    }

    public void init(Context context, String str2, boolean z16, String str3, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, str2, Boolean.valueOf(z16), str3, Boolean.valueOf(z17));
            return;
        }
        this.contextWeakReference = new WeakReference<>(context);
        this.crashInfoTag = str2;
        this.isReleaseType = z17;
        this.isFilter = z16;
        this.filterString = str3;
        this.isWriterCrash = false;
        this.defaultHandler = new WeakReference<>(Thread.getDefaultUncaughtExceptionHandler());
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) thread, (Object) th5);
            return;
        }
        handleException(th5);
        Thread.UncaughtExceptionHandler uncaughtDefaultHandler = getUncaughtDefaultHandler();
        if (uncaughtDefaultHandler != null) {
            uncaughtDefaultHandler.uncaughtException(thread, th5);
            return;
        }
        try {
            LockMethodProxy.sleep(2000L);
        } catch (InterruptedException e16) {
            Log.e(TAG, "error : ", e16);
        }
        SystemMethodProxy.killProcess(Process.myPid());
        System.exit(1);
    }
}
