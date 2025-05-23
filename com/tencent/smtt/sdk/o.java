package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.export.external.libwebp;
import com.tencent.smtt.utils.TbsLog;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes23.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    private Context f369467a;

    /* renamed from: b, reason: collision with root package name */
    private Context f369468b;

    /* renamed from: c, reason: collision with root package name */
    private String f369469c;

    /* renamed from: d, reason: collision with root package name */
    private String[] f369470d;

    /* renamed from: e, reason: collision with root package name */
    private DexLoader f369471e;

    /* renamed from: f, reason: collision with root package name */
    private String f369472f;

    /* renamed from: g, reason: collision with root package name */
    private String f369473g = null;

    public o(Context context, Context context2, String str, String str2, String[] strArr, String str3) throws Exception {
        this.f369467a = null;
        this.f369468b = null;
        this.f369469c = null;
        this.f369470d = null;
        this.f369471e = null;
        this.f369472f = "TbsDexOpt";
        TbsLog.i("TbsWizard", "construction start...");
        if (context != null && context2 != null && !TextUtils.isEmpty(str) && strArr != null && strArr.length != 0) {
            this.f369467a = context.getApplicationContext();
            if (context2.getApplicationContext() != null) {
                this.f369468b = context2.getApplicationContext();
            } else {
                this.f369468b = context2;
            }
            this.f369469c = str;
            this.f369470d = strArr;
            this.f369472f = str2;
            for (int i3 = 0; i3 < this.f369470d.length; i3++) {
                TbsLog.i("TbsWizard", "#2 mDexFileList[" + i3 + "]: " + this.f369470d[i3]);
            }
            TbsLog.i("TbsWizard", "new DexLoader #2 libraryPath is " + str3 + " mCallerAppContext is " + this.f369467a + " dexOutPutDir is " + str2);
            this.f369471e = new DexLoader(str3, this.f369467a, this.f369470d, str2, QbSdk.f369007q);
            System.currentTimeMillis();
            a(context);
            libwebp.loadWepLibraryIfNeed(context2, this.f369469c);
            HashMap hashMap = new HashMap();
            Map<String, Object> map = QbSdk.f369007q;
            if (map != null) {
                hashMap.putAll(map);
            }
            Map<String, Object> map2 = QbSdk.f369007q;
            if (map2 != null && map2.containsKey(TbsCoreSettings.MULTI_PROCESS_ENABLE)) {
                if (hashMap.get(TbsCoreSettings.MULTI_PROCESS_ENABLE).equals(3)) {
                    Object invokeStaticMethod = this.f369471e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "isMutliProcessIsolatedSupported", null, new Object[0]);
                    if (!(invokeStaticMethod instanceof Boolean) || !((Boolean) invokeStaticMethod).booleanValue()) {
                        hashMap.put(TbsCoreSettings.MULTI_PROCESS_ENABLE, 1);
                        TbsLog.i("[MultiProcess]", "current core not support isolated multi process, switch to privileged process!");
                    }
                    if (Build.VERSION.SDK_INT == 28 && hashMap.get(TbsCoreSettings.MULTI_PROCESS_ENABLE).equals(3)) {
                        Object invokeStaticMethod2 = this.f369471e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "isAPI28MutliProcessIsolatedSupported", null, new Object[0]);
                        if (!(invokeStaticMethod2 instanceof Boolean) || !((Boolean) invokeStaticMethod2).booleanValue()) {
                            hashMap.put(TbsCoreSettings.MULTI_PROCESS_ENABLE, 1);
                            TbsLog.i("[MultiProcess]", "current core not support api=29 isolated multi process, switch to privileged process!");
                        }
                    }
                }
            } else {
                hashMap.put(TbsCoreSettings.MULTI_PROCESS_ENABLE, 0);
                TbsLog.i("[MultiProcess]", "default not enable multi process!");
            }
            this.f369471e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTbsSettings", new Class[]{Map.class}, hashMap);
            b(context);
            int c16 = c(context);
            if (c16 >= 0) {
                TbsLog.i("TbsWizard", "construction end...");
                return;
            }
            throw new Exception("TbsWizard init error: " + c16 + "; msg: " + this.f369473g);
        }
        throw new Exception("TbsWizard paramter error:-1callerContext:" + context + "hostcontext" + context2 + "isEmpty" + TextUtils.isEmpty(str) + "dexfileList" + strArr);
    }

    private void b(Context context) {
        Map<String, Object> map = QbSdk.f369007q;
        if (map == null) {
            return;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("tbss", 0).edit();
            for (String str : map.keySet()) {
                Object obj = map.get(str);
                if (obj instanceof String) {
                    edit.putString(str, (String) obj);
                    TbsLog.i("TbsWizard", "initTbsSettingsBySP key is " + str + " value is " + ((String) obj));
                }
            }
            edit.commit();
        } catch (Throwable th5) {
            TbsLog.i("TbsWizard", "stack is " + Log.getStackTraceString(th5));
        }
    }

    private int c(Context context) {
        int i3;
        TbsLog.i("TbsWizard", "initTesRuntimeEnvironment callerContext is " + context + " mHostContext is " + this.f369468b + " mDexLoader is " + this.f369471e + " mtbsInstallLocation is " + this.f369469c + " mDexOptPath is " + this.f369472f);
        DexLoader dexLoader = this.f369471e;
        Object invokeStaticMethod = dexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[]{Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, Integer.TYPE, String.class}, context, this.f369468b, dexLoader, this.f369469c, this.f369472f, TbsConfig.TBS_SDK_VERSIONNAME, 44357, QbSdk.a());
        if (invokeStaticMethod == null) {
            d();
            e();
            DexLoader dexLoader2 = this.f369471e;
            invokeStaticMethod = dexLoader2.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[]{Context.class, Context.class, DexLoader.class, String.class, String.class}, context, this.f369468b, dexLoader2, this.f369469c, this.f369472f);
        }
        if (invokeStaticMethod == null) {
            i3 = -3;
        } else if (invokeStaticMethod instanceof Integer) {
            i3 = ((Integer) invokeStaticMethod).intValue();
        } else if (invokeStaticMethod instanceof Throwable) {
            TbsCoreLoadStat.getInstance().a(this.f369467a, 321, (Throwable) invokeStaticMethod);
            i3 = -5;
        } else {
            i3 = -4;
        }
        if (i3 < 0) {
            Object invokeStaticMethod2 = this.f369471e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
            if (invokeStaticMethod2 instanceof Throwable) {
                Throwable th5 = (Throwable) invokeStaticMethod2;
                this.f369473g = "#" + th5.getMessage() + "; cause: " + th5.getCause() + "; th: " + th5;
            }
            if (invokeStaticMethod2 instanceof String) {
                this.f369473g = (String) invokeStaticMethod2;
            }
        } else {
            this.f369473g = null;
        }
        return i3;
    }

    private void d() {
        this.f369471e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "setTesSdkVersionName", new Class[]{String.class}, TbsConfig.TBS_SDK_VERSIONNAME);
    }

    private void e() {
        this.f369471e.setStaticField("com.tencent.tbs.tbsshell.TBSShell", "VERSION", 44357);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void a(Context context) {
        boolean z16;
        Map<String, Object> map = QbSdk.f369007q;
        if (map != null) {
            Object obj = map.get(TbsCoreSettings.TBS_SETTINGS_CHECK_TBS_VALIDITY);
            if (obj instanceof Boolean) {
                z16 = ((Boolean) obj).booleanValue();
                if (z16) {
                    return;
                }
                com.tencent.smtt.utils.o.b(context);
                return;
            }
        }
        z16 = true;
        if (z16) {
        }
    }

    public void a(Context context, Context context2, String str, String str2, String[] strArr, String str3) throws Exception {
        this.f369467a = context.getApplicationContext();
        if (this.f369468b.getApplicationContext() != null) {
            this.f369468b = this.f369468b.getApplicationContext();
        }
        this.f369469c = str;
        this.f369470d = strArr;
        this.f369472f = str2;
        libwebp.loadWepLibraryIfNeed(context2, str);
        Map<String, Object> map = QbSdk.f369007q;
        if (map != null) {
            this.f369471e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTbsSettings", new Class[]{Map.class}, map);
        }
        int c16 = c(context);
        if (c16 >= 0) {
            return;
        }
        throw new Exception("continueInit init error: " + c16 + "; msg: " + this.f369473g);
    }

    public String b() {
        String str = null;
        Object invokeStaticMethod = this.f369471e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "invokeStaticMethod", new Class[]{Boolean.TYPE, String.class, String.class, Class[].class, Object[].class}, Boolean.TRUE, "com.tencent.smtt.util.CrashTracker", "getCrashExtraCacheInfo", null, new Object[0]);
        if (invokeStaticMethod == null) {
            invokeStaticMethod = this.f369471e.invokeStaticMethod("com.tencent.smtt.util.CrashTracker", "getCrashExtraCacheInfo", null, new Object[0]);
        }
        if (invokeStaticMethod != null) {
            str = String.valueOf(invokeStaticMethod) + " ReaderPackName=" + TbsReaderView.gReaderPackName + " ReaderPackVersion=" + TbsReaderView.gReaderPackVersion;
        }
        return str == null ? "X5 core get cache nothing..." : str;
    }

    public String a() {
        String str = null;
        Object invokeStaticMethod = this.f369471e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "invokeStaticMethod", new Class[]{Boolean.TYPE, String.class, String.class, Class[].class, Object[].class}, Boolean.TRUE, "com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new Object[0]);
        if (invokeStaticMethod == null) {
            invokeStaticMethod = this.f369471e.invokeStaticMethod("com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new Object[0]);
        }
        if (invokeStaticMethod != null) {
            str = String.valueOf(invokeStaticMethod) + " ReaderPackName=" + TbsReaderView.gReaderPackName + " ReaderPackVersion=" + TbsReaderView.gReaderPackVersion;
        }
        return str == null ? "X5 core get nothing..." : str;
    }

    public DexLoader c() {
        return this.f369471e;
    }

    public boolean a(Context context, String str, String str2, Bundle bundle) {
        Object invokeStaticMethod = this.f369471e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "installLocalQbApk", new Class[]{Context.class, String.class, String.class, Bundle.class}, context, str, str2, bundle);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }
}
