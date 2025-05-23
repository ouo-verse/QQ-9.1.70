package com.tencent.bugly.crashreport.crash.jni;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.common.utils.FileUtil;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.aa;
import com.tencent.bugly.proguard.ai;
import com.tencent.bugly.proguard.aj;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.at;
import com.tencent.bugly.proguard.av;
import com.tencent.bugly.proguard.aw;
import com.tencent.bugly.proguard.az;
import com.tencent.bugly.proguard.ba;
import com.tencent.bugly.proguard.bd;
import com.tencent.bugly.proguard.be;
import com.tencent.bugly.proguard.bs;
import com.tencent.bugly.proguard.bt;
import com.tencent.bugly.proguard.r;
import java.io.File;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class NativeCrashHandler implements aa.a, r {

    /* renamed from: a, reason: collision with root package name */
    private static NativeCrashHandler f97915a = null;

    /* renamed from: b, reason: collision with root package name */
    private static int f97916b = 1;
    public static boolean enableNativeDumpAllThreadStack = false;

    /* renamed from: g, reason: collision with root package name */
    private static String f97917g = null;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f97918h = false;

    /* renamed from: i, reason: collision with root package name */
    private static boolean f97919i = false;

    /* renamed from: p, reason: collision with root package name */
    private static boolean f97920p = true;

    /* renamed from: c, reason: collision with root package name */
    private final Context f97921c;

    /* renamed from: d, reason: collision with root package name */
    private final ai f97922d;

    /* renamed from: e, reason: collision with root package name */
    private final at f97923e;

    /* renamed from: f, reason: collision with root package name */
    private NativeExceptionHandler f97924f;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f97925j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f97926k = false;

    /* renamed from: l, reason: collision with root package name */
    private boolean f97927l = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f97928m = false;

    /* renamed from: n, reason: collision with root package name */
    private boolean f97929n = false;

    /* renamed from: o, reason: collision with root package name */
    private bd f97930o;

    @SuppressLint({"SdCardPath"})
    NativeCrashHandler(Context context, ai aiVar, bd bdVar, at atVar, boolean z16, String str) {
        this.f97921c = ba.a(context);
        if (ba.b(f97917g)) {
            try {
                if (ba.b(str)) {
                    str = context.getDir("bugly", 0).getAbsolutePath();
                }
            } catch (Throwable unused) {
                str = "/data/data/" + ai.a(context).f98015c + "/app_bugly";
            }
            f97917g = str;
        }
        this.f97930o = bdVar;
        this.f97922d = aiVar;
        this.f97923e = atVar;
        this.f97925j = z16;
        this.f97924f = new bs(context, aiVar, bdVar, ak.a());
        aa.a().f97934b.add(this);
    }

    private void a(int i3, String str) {
        if (str == null || str.length() <= 2048) {
            String d16 = ba.d(str);
            if (this.f97927l || this.f97926k) {
                if (d16 == null) {
                    d16 = "";
                }
                b(i3, d16);
            }
        }
    }

    private static void b(String str) {
        File[] listFiles;
        long b16 = ba.b() - be.f98217k;
        long b17 = ba.b() + 86400000;
        File file = new File(str);
        try {
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
                aw.a(listFiles);
                long folderSize = FileUtil.getFolderSize(file);
                for (File file2 : listFiles) {
                    long lastModified = file2.lastModified();
                    if (lastModified <= b16 || lastModified >= b17 || folderSize > be.f98216j) {
                        av.c("[Native] Delete native record: " + file2.getAbsolutePath(), new Object[0]);
                        if (file2.isFile()) {
                            folderSize -= file2.length();
                            file2.delete();
                        } else if (file2.isDirectory()) {
                            folderSize -= FileUtil.getFolderSize(file2);
                            FileUtil.deleteFolder(file2);
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            av.a(th5);
        }
    }

    private synchronized void c(boolean z16) {
        if (this.f97929n != z16) {
            av.a("user change native %b", Boolean.valueOf(z16));
            this.f97929n = z16;
        }
    }

    public static synchronized String getDumpFilePath() {
        String str;
        synchronized (NativeCrashHandler.class) {
            str = f97917g;
        }
        return str;
    }

    public static synchronized NativeCrashHandler getInstance(Context context, ai aiVar, bd bdVar, ak akVar, at atVar, boolean z16, String str) {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            if (f97915a == null) {
                f97915a = new NativeCrashHandler(context, aiVar, bdVar, atVar, z16, str);
            }
            nativeCrashHandler = f97915a;
        }
        return nativeCrashHandler;
    }

    private native String getSoCpuAbi();

    public static boolean isShouldHandleInJava() {
        return f97920p;
    }

    public static void setCustomFileUploadAble(boolean z16) {
        f97919i = z16;
    }

    public static synchronized void setDumpFilePath(String str) {
        synchronized (NativeCrashHandler.class) {
            if (f97918h) {
                av.a("setDumpFilePath after register, just return", new Object[0]);
            } else {
                f97917g = str;
            }
        }
    }

    public static void setShouldHandleInJava(boolean z16) {
        f97920p = z16;
        NativeCrashHandler nativeCrashHandler = f97915a;
        if (nativeCrashHandler != null) {
            nativeCrashHandler.b(999, String.valueOf(z16));
        }
    }

    @Override // com.tencent.bugly.proguard.r
    public boolean appendLogToNative(String str, String str2, String str3) {
        if ((this.f97926k || this.f97927l) && str != null && str2 != null && str3 != null) {
            try {
                if (this.f97927l) {
                    return appendNativeLog(str, str2, str3);
                }
                Boolean bool = (Boolean) ba.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "appendNativeLog", new Class[]{String.class, String.class, String.class}, new Object[]{str, str2, str3});
                if (bool == null) {
                    return false;
                }
                return bool.booleanValue();
            } catch (UnsatisfiedLinkError unused) {
            } catch (Throwable th5) {
                if (!av.a(th5)) {
                    th5.printStackTrace();
                }
            }
        }
        return false;
    }

    protected native boolean appendNativeLog(String str, String str2, String str3);

    protected native boolean appendWholeNativeLog(String str);

    public void checkSaveRecordCrash() {
        av.a("[Native] Check local record file and save db.", new Object[0]);
        if (!ba.a(this.f97921c, "native_record_lock")) {
            av.a("[Native] Failed to lock file for handling native crash record.", new Object[0]);
            return;
        }
        try {
            if (!f97920p) {
                b(999, "false");
            }
            a(f97917g);
            File[] listFiles = new File(f97917g).listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    if (file.isDirectory() && file.getName().startsWith("native_crash_")) {
                        a(file.getAbsolutePath());
                    }
                }
            }
            b(f97917g);
        } catch (Throwable unused) {
        }
        ba.b(this.f97921c, "native_record_lock");
    }

    public void disableCatchAnrTrace() {
        f97916b = 1;
    }

    public void dumpAnrNativeStack() {
        b(19, "1");
    }

    public void enableCatchAnrTrace() {
        f97916b |= 2;
    }

    public boolean filterSigabrtSysLog() {
        return b(998, "true");
    }

    public native void getFd();

    @Override // com.tencent.bugly.proguard.r
    public String getLogFromNative() {
        if (!this.f97926k && !this.f97927l) {
            return null;
        }
        try {
            if (this.f97927l) {
                return getNativeLog();
            }
            return (String) ba.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "getNativeLog", null, null);
        } catch (UnsatisfiedLinkError unused) {
            return null;
        } catch (Throwable th5) {
            if (!av.a(th5)) {
                th5.printStackTrace();
            }
            return null;
        }
    }

    public NativeExceptionHandler getNativeExceptionHandler() {
        return this.f97924f;
    }

    protected native String getNativeKeyValueList();

    protected native String getNativeLog();

    public native void getProcessInfoAnr();

    public native String getProperties(String str);

    public String getRunningCpuAbi() {
        try {
            return getSoCpuAbi();
        } catch (Throwable unused) {
            av.d("get so cpu abi failed\uff0cplease upgrade bugly so version", new Object[0]);
            return "";
        }
    }

    public String getSystemProperty(String str) {
        if (!this.f97927l && !this.f97926k) {
            return "fail";
        }
        return getProperties(str);
    }

    public boolean isEnableCatchAnrTrace() {
        if ((f97916b & 2) == 2) {
            return true;
        }
        return false;
    }

    public synchronized boolean isUserOpened() {
        return this.f97929n;
    }

    public native void modifyAttachmentState(int i3);

    public void modifyProcessingState(int i3, boolean z16) {
        modifyProcessingState(i3, z16, false);
    }

    public native void modifyProcessingState(int i3, boolean z16, boolean z17);

    public synchronized void onStrategyChanged(StrategyBean strategyBean) {
        boolean z16;
        if (strategyBean != null) {
            boolean z17 = strategyBean.f97841f;
            if (z17 != this.f97928m) {
                av.d("server native changed to %b", Boolean.valueOf(z17));
            }
        }
        if (ak.a().c().f97841f && this.f97929n) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 != this.f97928m) {
            av.a("native changed to %b", Boolean.valueOf(z16));
            b(z16);
        }
    }

    @Override // com.tencent.bugly.proguard.aa.a
    public void onSubProcessConfigChanged(boolean z16) {
        av.a("enableNativeSubProcess: ".concat(String.valueOf(z16)), new Object[0]);
        setNativeEnableSubProcess(Boolean.valueOf(z16));
    }

    public boolean putKeyValueToNative(String str, String str2) {
        if ((this.f97926k || this.f97927l) && str != null && str2 != null) {
            try {
                if (this.f97927l) {
                    return putNativeKeyValue(str, str2);
                }
                Boolean bool = (Boolean) ba.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "putNativeKeyValue", new Class[]{String.class, String.class}, new Object[]{str, str2});
                if (bool == null) {
                    return false;
                }
                return bool.booleanValue();
            } catch (UnsatisfiedLinkError unused) {
            } catch (Throwable th5) {
                if (!av.a(th5)) {
                    th5.printStackTrace();
                }
            }
        }
        return false;
    }

    protected native boolean putNativeKeyValue(String str, String str2);

    public void reRegisterANRHandler(boolean z16) {
        String str;
        if (this.f97927l || this.f97926k) {
            if (z16) {
                str = "true";
            } else {
                str = "false";
            }
            b(31, str);
        }
    }

    public void reRegisterNativeHandler(boolean z16) {
        String str;
        if (this.f97927l || this.f97926k) {
            if (z16) {
                str = "true";
            } else {
                str = "false";
            }
            b(30, str);
        }
    }

    public native void recordProcessingState(String str, int i3);

    protected native String regist(String str, String str2, String str3, String str4, boolean z16, int i3, long j3);

    public void removeEmptyNativeRecordFiles() {
        bt.b(f97917g);
    }

    protected native String removeNativeKeyValue(String str);

    public void resendSigquit() {
        b(20, "");
    }

    public void saveAdditionalAttachmentPaths(String str) {
        try {
            saveAdditionalAttachmentPathsNative(str);
        } catch (Throwable th5) {
            if (!av.d("Failed to save additional attachment paths. ".concat(String.valueOf(th5)), new Object[0])) {
                th5.printStackTrace();
            }
        }
    }

    protected native void saveAdditionalAttachmentPathsNative(String str);

    public boolean setAdditionalAttachmentPaths(ArrayList<String> arrayList) {
        try {
        } catch (Throwable th5) {
            if (!av.d("Failed to set additional attachment paths. ".concat(String.valueOf(th5)), new Object[0])) {
                th5.printStackTrace();
            }
        }
        if (f97919i && arrayList != null) {
            setAdditionalAttachmentPathsNative((String[]) arrayList.toArray(new String[arrayList.size()]));
            av.a("setAdditionalAttachmentPaths successful", new Object[0]);
            return true;
        }
        av.a("setAdditionalAttachmentPaths failed for sample ratio", new Object[0]);
        return false;
    }

    protected native void setAdditionalAttachmentPathsNative(String[] strArr);

    public boolean setAppHotPatchNum(String str) {
        return b(28, str);
    }

    public boolean setAppVersionLabel(String str) {
        return b(29, str);
    }

    public void setCaseLabel(String str) {
        a(33, str);
    }

    protected native void setCrashProcessingInfo(String str, String str2, String str3);

    public boolean setNativeAppBuildNum(String str) {
        return b(23, str);
    }

    public boolean setNativeAppChannel(String str) {
        return b(12, str);
    }

    public boolean setNativeAppPackage(String str) {
        return b(13, str);
    }

    public boolean setNativeAppVersion(String str) {
        return b(10, str);
    }

    public boolean setNativeDeviceId(String str) {
        return b(26, str);
    }

    public boolean setNativeDeviceModel(String str) {
        return b(25, str);
    }

    public boolean setNativeEnableDumpAllThread(Boolean bool) {
        String str;
        if (bool.booleanValue()) {
            str = "true";
        } else {
            str = "false";
        }
        return b(35, str);
    }

    public boolean setNativeEnableSubProcess(Boolean bool) {
        String str;
        if (bool.booleanValue()) {
            str = "true";
        } else {
            str = "false";
        }
        return b(22, str);
    }

    protected native void setNativeInfo(int i3, String str);

    @Override // com.tencent.bugly.proguard.r
    public boolean setNativeIsAppForeground(boolean z16) {
        String str;
        if (z16) {
            str = "true";
        } else {
            str = "false";
        }
        return b(14, str);
    }

    public boolean setNativeIsFirstInstall(boolean z16) {
        String str;
        if (z16) {
            str = "true";
        } else {
            str = "false";
        }
        return b(27, str);
    }

    public boolean setNativeLaunchTime(long j3) {
        try {
            return b(15, String.valueOf(j3));
        } catch (NumberFormatException e16) {
            if (!av.a(e16)) {
                e16.printStackTrace();
                return false;
            }
            return false;
        }
    }

    public boolean setNativeSdkVersion(String str) {
        return b(24, str);
    }

    public boolean setNativeUserId(String str) {
        return b(11, str);
    }

    public void setStage(String str) {
        a(34, str);
    }

    public void setTestLabel(String str) {
        a(32, str);
    }

    public synchronized void setUserOpened(boolean z16) {
        c(z16);
        boolean isUserOpened = isUserOpened();
        ak a16 = ak.a();
        if (a16 != null) {
            if (isUserOpened && a16.c().f97841f) {
                isUserOpened = true;
            } else {
                isUserOpened = false;
            }
        }
        if (isUserOpened != this.f97928m) {
            av.a("native changed to %b", Boolean.valueOf(isUserOpened));
            b(isUserOpened);
        }
    }

    public synchronized void startNativeMonitor() {
        boolean z16;
        if (!this.f97927l && !this.f97926k) {
            if (!ba.b(this.f97922d.B)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (be.f98208b) {
                String str = "Bugly_Native";
                if (z16) {
                    str = this.f97922d.B;
                }
                boolean tryLoadSo = tryLoadSo(str, z16);
                this.f97927l = tryLoadSo;
                if (!tryLoadSo && !z16) {
                    this.f97926k = tryLoadSo("NativeRQD", false);
                }
            } else {
                String str2 = "Bugly_Native";
                ai aiVar = this.f97922d;
                String str3 = aiVar.B;
                if (!z16) {
                    aiVar.getClass();
                } else {
                    str2 = str3;
                }
                this.f97927l = tryLoadSo(str2, z16);
            }
            if (!this.f97927l && !this.f97926k) {
                return;
            }
            a(this.f97925j);
            setNativeAppVersion(this.f97922d.f98032t);
            setNativeSdkVersion(this.f97922d.f98020h);
            setNativeAppBuildNum(this.f97922d.O);
            setNativeDeviceModel(this.f97922d.i());
            setNativeDeviceId(this.f97922d.h());
            setNativeIsFirstInstall(this.f97922d.R);
            setNativeAppChannel(this.f97922d.f98035w);
            setNativeAppPackage(this.f97922d.f98015c);
            setNativeUserId(this.f97922d.g());
            setNativeIsAppForeground(this.f97922d.b());
            setNativeLaunchTime(this.f97922d.f97991a);
            try {
                String str4 = az.a().f98155f;
                ai aiVar2 = this.f97922d;
                setCrashProcessingInfo(str4, aiVar2.f98016d, aiVar2.f98023k);
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        a(this.f97925j);
    }

    protected native void testCrash();

    public void testNativeCrash() {
        if (!this.f97927l) {
            av.d("[Native] Bugly SO file has not been load.", new Object[0]);
        } else {
            testCrash();
        }
    }

    public boolean tryLoadSo(String str, boolean z16) {
        boolean z17;
        try {
            av.a("[Native] Trying to load so: %s", str);
            if (z16) {
                System.load(str);
            } else {
                System.loadLibrary(str);
            }
        } catch (Throwable th5) {
            th = th5;
            z17 = false;
        }
        try {
            av.a("[Native] Successfully loaded SO: %s", str);
            return true;
        } catch (Throwable th6) {
            th = th6;
            z17 = true;
            av.d(th.getMessage(), new Object[0]);
            av.d("[Native] Failed to load so: %s", str);
            return z17;
        }
    }

    public void unBlockSigquit(boolean z16) {
        if (z16) {
            b(21, "true");
        } else {
            b(21, "false");
        }
    }

    protected native String unregist();

    public static synchronized NativeCrashHandler getInstance() {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            nativeCrashHandler = f97915a;
        }
        return nativeCrashHandler;
    }

    public void testNativeCrash(boolean z16, boolean z17, boolean z18) {
        b(16, String.valueOf(z16));
        b(17, String.valueOf(z17));
        b(18, String.valueOf(z18));
        testNativeCrash();
    }

    private synchronized void a(boolean z16) {
        if (this.f97928m) {
            av.d("[Native] Native crash report has already registered.", new Object[0]);
            return;
        }
        if (this.f97927l) {
            try {
                String regist = regist(this.f97921c.getFilesDir().getAbsolutePath(), f97917g, this.f97921c.getApplicationInfo().nativeLibraryDir, ai.f97988af, z16, f97916b, be.f98224r);
                f97918h = true;
                setNativeEnableDumpAllThread(Boolean.valueOf(enableNativeDumpAllThreadStack));
                if (regist != null) {
                    av.a("[Native] Native Crash Report enable.", new Object[0]);
                    this.f97922d.C = regist;
                    String concat = "-".concat(regist);
                    if (!be.f98208b && !this.f97922d.f98020h.contains(concat)) {
                        ai aiVar = this.f97922d;
                        aiVar.f98020h = aiVar.f98020h.concat("-").concat(this.f97922d.C);
                    }
                    av.a("comInfo.sdkVersion %s", this.f97922d.f98020h);
                    this.f97928m = true;
                    String runningCpuAbi = getRunningCpuAbi();
                    if (!TextUtils.isEmpty(runningCpuAbi)) {
                        this.f97922d.f(runningCpuAbi);
                    }
                    return;
                }
            } catch (Throwable unused) {
                av.c("[Native] Failed to load Bugly SO file.", new Object[0]);
            }
        } else if (this.f97926k) {
            try {
                Class cls = Integer.TYPE;
                Class[] clsArr = {String.class, String.class, cls, cls};
                Object[] objArr = new Object[4];
                objArr[0] = f97917g;
                objArr[1] = aj.d();
                objArr[2] = Integer.valueOf(z16 ? 1 : 5);
                objArr[3] = 1;
                String str = (String) ba.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler2", clsArr, objArr);
                if (str == null) {
                    ai.c();
                    str = (String) ba.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler", new Class[]{String.class, String.class, cls}, new Object[]{f97917g, aj.d(), Integer.valueOf(ai.C())});
                }
                if (str != null) {
                    this.f97928m = true;
                    this.f97922d.C = str;
                    ba.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", new Class[]{Boolean.TYPE}, new Object[]{Boolean.TRUE});
                    ba.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "setLogMode", new Class[]{cls}, new Object[]{Integer.valueOf(z16 ? 1 : 5)});
                    String runningCpuAbi2 = getRunningCpuAbi();
                    if (!TextUtils.isEmpty(runningCpuAbi2)) {
                        this.f97922d.f(runningCpuAbi2);
                    }
                    return;
                }
            } catch (Throwable unused2) {
            }
        }
        this.f97927l = false;
        this.f97926k = false;
    }

    private synchronized void b(boolean z16) {
        if (z16) {
            startNativeMonitor();
        } else {
            a();
        }
    }

    private boolean b(int i3, String str) {
        if (!this.f97927l) {
            return false;
        }
        try {
            setNativeInfo(i3, str);
            return true;
        } catch (UnsatisfiedLinkError unused) {
            return false;
        } catch (Throwable th5) {
            if (!av.a(th5)) {
                th5.printStackTrace();
            }
            return false;
        }
    }

    private void a(String str) {
        CrashDetailBean a16 = bt.a(this.f97921c, str, this.f97924f);
        if (a16 != null) {
            av.a("[Native] Get crash from native record.", new Object[0]);
            if (!this.f97930o.a(a16, false)) {
                av.a("[Native] Native crash record Need to upload.", new Object[0]);
            }
            bt.a(false, str);
        }
    }

    private synchronized void a() {
        if (!this.f97928m) {
            av.d("[Native] Native crash report has already unregistered.", new Object[0]);
            return;
        }
        try {
            if (unregist() != null) {
                av.a("[Native] Successfully closed native crash report.", new Object[0]);
                this.f97928m = false;
                return;
            }
        } catch (Throwable unused) {
            av.c("[Native] Failed to close native crash report.", new Object[0]);
        }
        try {
            ba.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", new Class[]{Boolean.TYPE}, new Object[]{Boolean.FALSE});
            this.f97928m = false;
            av.a("[Native] Successfully closed native crash report.", new Object[0]);
        } catch (Throwable unused2) {
            av.c("[Native] Failed to close native crash report.", new Object[0]);
            this.f97927l = false;
            this.f97926k = false;
        }
    }
}
