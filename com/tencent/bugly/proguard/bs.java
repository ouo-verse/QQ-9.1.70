package com.tencent.bugly.proguard;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.bugly.common.hotpatch.HotPatchWrapper;
import com.tencent.bugly.common.utils.FileUtil;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler;
import com.tencent.bugly.proguard.az;
import com.tencent.rmonitor.common.lifecycle.LifecycleCallback;
import cooperation.qzone.util.QZoneAppCtrlUploadFileLogic;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class bs implements NativeExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    private final Context f98341a;

    /* renamed from: b, reason: collision with root package name */
    private final bd f98342b;

    /* renamed from: c, reason: collision with root package name */
    private final ai f98343c;

    /* renamed from: d, reason: collision with root package name */
    private final ak f98344d;

    public bs(Context context, ai aiVar, bd bdVar, ak akVar) {
        this.f98341a = context;
        this.f98342b = bdVar;
        this.f98343c = aiVar;
        this.f98344d = akVar;
    }

    private static Map<String, String> a(String[] strArr) {
        int length;
        if (strArr == null) {
            length = 1;
        } else {
            length = strArr.length;
        }
        HashMap hashMap = new HashMap(length);
        if (strArr != null) {
            for (int i3 = 0; i3 < strArr.length; i3++) {
                String str = strArr[i3];
                if (str != null) {
                    av.a("Extra message[%d]: %s", Integer.valueOf(i3), str);
                    String[] split = str.split(ContainerUtils.KEY_VALUE_DELIMITER);
                    if (split.length == 2) {
                        hashMap.put(split[0], split[1]);
                    } else {
                        av.d("bad extraMsg %s", str);
                    }
                }
            }
        } else {
            av.c("not found extraMsg", new Object[0]);
        }
        return hashMap;
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final boolean clearPreDumpAnrInfo() {
        if (bn.a() == null) {
            return false;
        }
        bn a16 = bn.a();
        a16.f98303e = -1L;
        a16.f98302d = "";
        a16.f98301c = "";
        return true;
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final void handleNativeException(int i3, int i16, long j3, long j16, String str, String str2, String str3, String str4, String str5, int i17, String str6, int i18, int i19, int i26, String str7, String str8) {
        av.a("Native Crash Happen v1", new Object[0]);
        handleNativeException2(i3, i16, j3, j16, str, str2, str3, str4, str5, i17, str6, i18, i19, i26, str7, str8, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0087 A[Catch: all -> 0x0238, TryCatch #2 {all -> 0x0238, blocks: (B:69:0x001b, B:4:0x003b, B:6:0x0051, B:9:0x0058, B:10:0x0065, B:12:0x0087, B:13:0x00ba, B:15:0x00e4, B:16:0x00ec, B:19:0x00f9, B:21:0x0101, B:29:0x014d, B:30:0x0151, B:32:0x015b, B:66:0x00a5, B:67:0x0063), top: B:68:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00e4 A[Catch: all -> 0x0238, TryCatch #2 {all -> 0x0238, blocks: (B:69:0x001b, B:4:0x003b, B:6:0x0051, B:9:0x0058, B:10:0x0065, B:12:0x0087, B:13:0x00ba, B:15:0x00e4, B:16:0x00ec, B:19:0x00f9, B:21:0x0101, B:29:0x014d, B:30:0x0151, B:32:0x015b, B:66:0x00a5, B:67:0x0063), top: B:68:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x019d A[Catch: all -> 0x0234, TryCatch #1 {all -> 0x0234, blocks: (B:36:0x0197, B:38:0x019d, B:40:0x01a6), top: B:35:0x0197 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01a6 A[Catch: all -> 0x0234, TRY_LEAVE, TryCatch #1 {all -> 0x0234, blocks: (B:36:0x0197, B:38:0x019d, B:40:0x01a6), top: B:35:0x0197 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00a5 A[Catch: all -> 0x0238, TryCatch #2 {all -> 0x0238, blocks: (B:69:0x001b, B:4:0x003b, B:6:0x0051, B:9:0x0058, B:10:0x0065, B:12:0x0087, B:13:0x00ba, B:15:0x00e4, B:16:0x00ec, B:19:0x00f9, B:21:0x0101, B:29:0x014d, B:30:0x0151, B:32:0x015b, B:66:0x00a5, B:67:0x0063), top: B:68:0x001b }] */
    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void handleNativeException2(int i3, int i16, long j3, long j16, String str, String str2, String str3, String str4, String str5, int i17, String str6, int i18, int i19, int i26, String str7, String str8, String[] strArr) {
        String str9;
        String sb5;
        String str10;
        String str11;
        long j17;
        String str12;
        String str13;
        String str14;
        String str15;
        CrashDetailBean packageCrashBasicDatas;
        av.a("Native Crash Happen v2", new Object[0]);
        if (i17 > 0) {
            try {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(str);
                sb6.append("(");
                str9 = str6;
                sb6.append(str9);
                sb6.append(")");
                sb5 = sb6.toString();
            } catch (Throwable th5) {
                th = th5;
                if (av.a(th)) {
                }
            }
        } else {
            str9 = str6;
            sb5 = str;
        }
        String a16 = bt.a(str3);
        Map<String, String> a17 = a(strArr);
        ai aiVar = this.f98343c;
        String str16 = a17.get("ExceptionProcessName");
        try {
            if (str16 != null && str16.length() != 0) {
                av.c("Name of crash process: %s", str16);
                String str17 = str16;
                str10 = a17.get("ExceptionThreadName");
                av.c("crash thread name:%s tid:%s", str10, Integer.valueOf(i16));
                if (!TextUtils.isEmpty(str10)) {
                    str11 = Thread.currentThread().getName() + "(" + i16 + ")";
                } else {
                    str11 = str10 + "(" + i16 + ")";
                }
                j17 = (j3 * 1000) + (j16 / 1000);
                str12 = a17.get("SysLogPath");
                str13 = a17.get("JniLogPath");
                String fileParentPath = FileUtil.getFileParentPath(str5);
                if (!this.f98344d.b()) {
                    av.d("no remote but still store!", new Object[0]);
                }
                if (this.f98344d.c().f97841f && this.f98344d.b()) {
                    av.e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                    bd.a("NATIVE_CRASH", ba.a(), str17, str11, sb5 + "\n" + str2 + "\n" + a16, null);
                    FileUtil.deleteFile(fileParentPath);
                    return;
                }
                String str18 = i17 <= 0 ? "KERNEL" : str9;
                str14 = "UNKNOWN";
                if (i17 <= 0) {
                    str14 = i18 > 0 ? ah.a(i18) : "UNKNOWN";
                    if (!str14.equals(String.valueOf(i18))) {
                        str15 = str14 + "(" + i18 + ")";
                        String str19 = str11;
                        String str20 = sb5;
                        packageCrashBasicDatas = packageCrashBasicDatas(str11, j17, sb5, str2, a16, str4, str18, str15, str5, str12, str13, str8);
                        if (packageCrashBasicDatas == null) {
                            av.e("pkg crash datas fail!", new Object[0]);
                            return;
                        }
                        packageCrashDetailDatas(packageCrashBasicDatas, str17, null, null, true, -1L, -1L, -1L, -1L);
                        NativeCrashHandler.getInstance().modifyProcessingState(az.b.f98175g - 1, false);
                        bd.a("NATIVE_CRASH", ba.a(), str17, str19, str20 + "\n" + str2 + "\n" + a16, packageCrashBasicDatas);
                        try {
                            bd bdVar = this.f98342b;
                            if (bdVar == null) {
                                av.d("crashHandler is null. Won't upload native crash.", new Object[0]);
                                return;
                            }
                            boolean z16 = !bdVar.a(packageCrashBasicDatas, i17, true);
                            bt.a(true, fileParentPath);
                            if (z16) {
                                this.f98342b.b(packageCrashBasicDatas, true);
                            }
                            this.f98342b.a(packageCrashBasicDatas);
                            be.a().c();
                            return;
                        } catch (Throwable th6) {
                            th = th6;
                            if (av.a(th)) {
                                th.printStackTrace();
                                return;
                            }
                            return;
                        }
                    }
                }
                str15 = str14;
                String str192 = str11;
                String str202 = sb5;
                packageCrashBasicDatas = packageCrashBasicDatas(str11, j17, sb5, str2, a16, str4, str18, str15, str5, str12, str13, str8);
                if (packageCrashBasicDatas == null) {
                }
            }
            packageCrashBasicDatas = packageCrashBasicDatas(str11, j17, sb5, str2, a16, str4, str18, str15, str5, str12, str13, str8);
            if (packageCrashBasicDatas == null) {
            }
        } catch (Throwable th7) {
            th = th7;
        }
        str16 = aiVar.f98016d;
        String str172 = str16;
        str10 = a17.get("ExceptionThreadName");
        av.c("crash thread name:%s tid:%s", str10, Integer.valueOf(i16));
        if (!TextUtils.isEmpty(str10)) {
        }
        j17 = (j3 * 1000) + (j16 / 1000);
        str12 = a17.get("SysLogPath");
        str13 = a17.get("JniLogPath");
        String fileParentPath2 = FileUtil.getFileParentPath(str5);
        if (!this.f98344d.b()) {
        }
        if (this.f98344d.c().f97841f) {
        }
        if (i17 <= 0) {
        }
        str14 = "UNKNOWN";
        if (i17 <= 0) {
        }
        str15 = str14;
        String str1922 = str11;
        String str2022 = sb5;
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final CrashDetailBean packageCrashBasicDatas(String str, long j3, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        String str12;
        boolean j16 = be.a().j();
        if (j16) {
            av.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.f97876b = 1;
        crashDetailBean.f97882h = this.f98343c.h();
        crashDetailBean.f97883i = this.f98343c.i();
        ai aiVar = this.f98343c;
        crashDetailBean.f97885k = aiVar.f98032t;
        crashDetailBean.f97884j = aiVar.f98020h;
        crashDetailBean.f97886l = aiVar.O;
        crashDetailBean.f97887m = aiVar.f98035w;
        List<String> h16 = LifecycleCallback.G.h();
        crashDetailBean.f97889o = h16;
        if (h16 != null && !h16.isEmpty()) {
            NativeCrashHandler.getInstance().modifyAttachmentState(az.a.f98159b - 1);
        }
        ai aiVar2 = this.f98343c;
        crashDetailBean.f97881g = aiVar2.R;
        crashDetailBean.f97888n = aiVar2.r();
        crashDetailBean.f97895u = this.f98343c.g();
        crashDetailBean.f97896v = str2;
        if (j16) {
            str12 = str5 + "\n[Bugly]This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!";
        } else {
            str12 = str5;
        }
        crashDetailBean.f97897w = str12;
        crashDetailBean.f97898x = str3;
        String str13 = str4 == null ? "" : str4;
        crashDetailBean.f97899y = str13;
        crashDetailBean.f97900z = j3;
        crashDetailBean.C = ba.c(str13.getBytes());
        crashDetailBean.J = str;
        crashDetailBean.V = this.f98343c.t();
        crashDetailBean.f97890p = this.f98343c.q();
        crashDetailBean.f97891q = this.f98343c.B();
        crashDetailBean.D = str8;
        String a16 = bt.a(FileUtil.getFileParentPath(str8), str8);
        if (!ba.b(a16)) {
            crashDetailBean.f97869aj = a16;
        }
        crashDetailBean.E = bt.a(str9, be.f98211e, be.f98212f, be.f98213g, be.f98218l, j3);
        crashDetailBean.F = bt.a(str10, be.f98211e, be.f98212f, be.f98213g, null, j3);
        crashDetailBean.X = str7;
        crashDetailBean.Y = str6;
        crashDetailBean.Z = str11;
        crashDetailBean.N = this.f98343c.l();
        crashDetailBean.O = this.f98343c.k();
        crashDetailBean.P = this.f98343c.m();
        return crashDetailBean;
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final void packageCrashDetailDatas(CrashDetailBean crashDetailBean, String str, byte[] bArr, Map<String, String> map, boolean z16, long j3, long j16, long j17, long j18) {
        int i3;
        String str2;
        int indexOf;
        if (z16) {
            crashDetailBean.Q = aj.a(this.f98341a);
            crashDetailBean.R = aj.g();
            crashDetailBean.S = aj.h();
            crashDetailBean.T = aj.i();
            crashDetailBean.U = aj.j();
            crashDetailBean.K = aj.l();
            crashDetailBean.L = aj.f();
            crashDetailBean.M = aj.n();
            crashDetailBean.G = ay.a();
            ai aiVar = this.f98343c;
            crashDetailBean.f97860aa = aiVar.f97991a;
            crashDetailBean.f97861ab = aiVar.b();
            crashDetailBean.H = ba.a(this.f98343c.X, be.f98215i, false);
            int indexOf2 = crashDetailBean.f97899y.indexOf("java:\n");
            if (indexOf2 > 0 && (i3 = indexOf2 + 6) < crashDetailBean.f97899y.length()) {
                String substring = crashDetailBean.f97899y.substring(i3, r4.length() - 1);
                if (substring.length() > 0 && crashDetailBean.H.containsKey(crashDetailBean.J) && (indexOf = (str2 = crashDetailBean.H.get(crashDetailBean.J)).indexOf(substring)) > 0) {
                    String substring2 = str2.substring(indexOf);
                    crashDetailBean.H.put(crashDetailBean.J, substring2);
                    crashDetailBean.f97899y = crashDetailBean.f97899y.substring(0, i3);
                    crashDetailBean.f97899y += substring2;
                }
            }
            if (TextUtils.isEmpty(str)) {
                crashDetailBean.I = this.f98343c.f98016d;
            } else {
                crashDetailBean.I = str;
            }
            crashDetailBean.f97864ae = this.f98343c.A();
            ai aiVar2 = this.f98343c;
            crashDetailBean.f97865af = aiVar2.F;
            crashDetailBean.f97866ag = aiVar2.u();
            crashDetailBean.f97867ah = this.f98343c.z();
            crashDetailBean.f97871al = HotPatchWrapper.getInstance().getAppHotPatchNum();
            crashDetailBean.f97872am = HotPatchWrapper.getInstance().getBaseInHotfixRFix();
            bi.a(crashDetailBean);
        } else {
            crashDetailBean.I = str;
            crashDetailBean.K = j3;
            crashDetailBean.L = j16;
            crashDetailBean.M = j17;
            crashDetailBean.R = j18;
            if (crashDetailBean.E == null) {
                crashDetailBean.E = "This crash occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.";
            }
            crashDetailBean.f97860aa = -1L;
            crashDetailBean.f97864ae = -1;
            crashDetailBean.f97865af = -1;
            crashDetailBean.f97866ag = map;
            crashDetailBean.f97867ah = this.f98343c.z();
            crashDetailBean.H = null;
            crashDetailBean.f97871al = "";
            crashDetailBean.f97872am = "0";
            if (bArr != null) {
                crashDetailBean.G = bArr;
            }
        }
        if (TextUtils.isEmpty(crashDetailBean.I)) {
            crashDetailBean.I = "unknown(record)";
        }
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final boolean preDumpAnrInfo() {
        if (bn.a() == null) {
            return false;
        }
        return bn.a().d();
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final boolean updateStateAndHandleAnr() {
        boolean z16;
        if (bn.a() == null) {
            return false;
        }
        final bn a16 = bn.a();
        if (a16.f98299a.get()) {
            av.c("anr is processing, return", new Object[0]);
            return false;
        }
        ActivityManager activityManager = a16.f98300b;
        if (!bo.a() && ah.a(activityManager) && bo.a(activityManager, 21000L) == null) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            av.c("proc is not in anr, wait next check", new Object[0]);
            return false;
        }
        if (a16.a(System.currentTimeMillis())) {
            return false;
        }
        boolean a17 = a16.a(true);
        if (a17) {
            NativeCrashHandler.getInstance().recordProcessingState(QZoneAppCtrlUploadFileLogic.ANR_PATH, az.b.f98169a - 1);
            at.a().a(new Runnable() { // from class: com.tencent.bugly.proguard.bn.3
                public AnonymousClass3() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (bn.this.f98305g.b()) {
                        av.c("Found foreground anr, resend sigquit immediately.", new Object[0]);
                        NativeCrashHandler.getInstance().resendSigquit();
                        bn.this.b((CrashDetailBean) null);
                        av.c("Finish handling one anr.", new Object[0]);
                        return;
                    }
                    av.c("Found background anr, resend sigquit later.", new Object[0]);
                    bn.this.b((CrashDetailBean) null);
                    av.c("Finish handling one anr, now resend sigquit.", new Object[0]);
                    NativeCrashHandler.getInstance().resendSigquit();
                }
            });
        }
        return a17;
    }
}
