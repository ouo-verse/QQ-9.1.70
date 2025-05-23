package com.tencent.bugly.proguard;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.bugly.common.constants.SPKey;
import com.tencent.bugly.common.meta.UserMeta;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.bugly.common.reporter.data.ReportData;
import com.tencent.bugly.common.reporter.upload.UploadProxy;
import com.tencent.bugly.common.sp.SharedPreferencesProvider;
import com.tencent.bugly.common.utils.FileUtil;
import com.tencent.bugly.common.utils.ProcessUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.rmonitor.base.config.ConfigFetcher;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class bw {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f98360a = false;

    /* renamed from: b, reason: collision with root package name */
    public static double f98361b;

    /* renamed from: c, reason: collision with root package name */
    private static long f98362c;

    /* renamed from: d, reason: collision with root package name */
    private static long f98363d;

    /* renamed from: e, reason: collision with root package name */
    private static int f98364e;

    public static void a(final Context context) {
        at.a().a(new Runnable() { // from class: com.tencent.bugly.proguard.bw.1
            @Override // java.lang.Runnable
            public final void run() {
                av.a("Check and upload exit info.", new Object[0]);
                if (aj.c() < 30) {
                    av.a("Api level is lower than 30, cannot get app exit info.", new Object[0]);
                    return;
                }
                com.tencent.rmonitor.base.config.data.k d16 = ConfigFetcher.g().d("application_exit");
                if (d16 instanceof y) {
                    y yVar = (y) d16;
                    bw.f98360a = yVar.f98582a;
                    bw.f98361b = yVar.f98583b;
                }
                try {
                    if (!bw.f98360a) {
                        av.a("App exit info disable.", new Object[0]);
                        return;
                    }
                    ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                    Method method = activityManager.getClass().getMethod("setProcessStateSummary", byte[].class);
                    if (method != null) {
                        method.invoke(activityManager, ai.f97988af.getBytes("UTF-8"));
                    }
                    if (!ProcessUtil.isMainProcess(context)) {
                        av.a("Not main process, do not check exit info.", new Object[0]);
                    } else {
                        bw.a(context, activityManager, bw.b(context));
                    }
                } catch (Throwable th5) {
                    av.a(th5);
                }
            }
        });
    }

    static /* synthetic */ String b(Context context) {
        String str = context.getFilesDir().getAbsolutePath() + File.separator + "bugly_exit_info";
        File file = new File(str);
        if (!file.exists()) {
            av.c("make exit info dir, ".concat(String.valueOf(file.mkdirs())), new Object[0]);
        }
        ArrayList<File> files = FileUtil.getFiles(str, null);
        if (files != null && !files.isEmpty()) {
            Iterator<File> it = files.iterator();
            while (it.hasNext()) {
                FileUtil.deleteFile(it.next());
            }
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x049c A[Catch: all -> 0x0559, TryCatch #4 {all -> 0x0559, blocks: (B:3:0x0005, B:13:0x0078, B:17:0x008b, B:18:0x009e, B:33:0x01a2, B:35:0x01c1, B:38:0x01c9, B:39:0x01cf, B:42:0x01e9, B:45:0x0208, B:51:0x021a, B:53:0x0228, B:55:0x022e, B:57:0x0235, B:59:0x023d, B:61:0x0245, B:63:0x024c, B:65:0x0253, B:67:0x025b, B:73:0x0263, B:75:0x026c, B:77:0x0273, B:82:0x031c, B:85:0x0380, B:98:0x0447, B:105:0x0444, B:110:0x0281, B:112:0x028c, B:114:0x028f, B:116:0x029e, B:118:0x02a8, B:120:0x02b3, B:121:0x02d7, B:123:0x02de, B:125:0x02e6, B:127:0x02f0, B:129:0x02fb, B:134:0x0489, B:136:0x049c, B:138:0x04a0, B:146:0x04f1, B:147:0x04f4, B:148:0x0506, B:157:0x0545, B:161:0x019f, B:172:0x054f, B:140:0x04a6, B:143:0x04c5), top: B:2:0x0005, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01c1 A[Catch: all -> 0x0559, TryCatch #4 {all -> 0x0559, blocks: (B:3:0x0005, B:13:0x0078, B:17:0x008b, B:18:0x009e, B:33:0x01a2, B:35:0x01c1, B:38:0x01c9, B:39:0x01cf, B:42:0x01e9, B:45:0x0208, B:51:0x021a, B:53:0x0228, B:55:0x022e, B:57:0x0235, B:59:0x023d, B:61:0x0245, B:63:0x024c, B:65:0x0253, B:67:0x025b, B:73:0x0263, B:75:0x026c, B:77:0x0273, B:82:0x031c, B:85:0x0380, B:98:0x0447, B:105:0x0444, B:110:0x0281, B:112:0x028c, B:114:0x028f, B:116:0x029e, B:118:0x02a8, B:120:0x02b3, B:121:0x02d7, B:123:0x02de, B:125:0x02e6, B:127:0x02f0, B:129:0x02fb, B:134:0x0489, B:136:0x049c, B:138:0x04a0, B:146:0x04f1, B:147:0x04f4, B:148:0x0506, B:157:0x0545, B:161:0x019f, B:172:0x054f, B:140:0x04a6, B:143:0x04c5), top: B:2:0x0005, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01e9 A[Catch: all -> 0x0559, TRY_ENTER, TryCatch #4 {all -> 0x0559, blocks: (B:3:0x0005, B:13:0x0078, B:17:0x008b, B:18:0x009e, B:33:0x01a2, B:35:0x01c1, B:38:0x01c9, B:39:0x01cf, B:42:0x01e9, B:45:0x0208, B:51:0x021a, B:53:0x0228, B:55:0x022e, B:57:0x0235, B:59:0x023d, B:61:0x0245, B:63:0x024c, B:65:0x0253, B:67:0x025b, B:73:0x0263, B:75:0x026c, B:77:0x0273, B:82:0x031c, B:85:0x0380, B:98:0x0447, B:105:0x0444, B:110:0x0281, B:112:0x028c, B:114:0x028f, B:116:0x029e, B:118:0x02a8, B:120:0x02b3, B:121:0x02d7, B:123:0x02de, B:125:0x02e6, B:127:0x02f0, B:129:0x02fb, B:134:0x0489, B:136:0x049c, B:138:0x04a0, B:146:0x04f1, B:147:0x04f4, B:148:0x0506, B:157:0x0545, B:161:0x019f, B:172:0x054f, B:140:0x04a6, B:143:0x04c5), top: B:2:0x0005, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x03e9 A[Catch: all -> 0x043f, TryCatch #7 {all -> 0x043f, blocks: (B:95:0x03b1, B:99:0x03e9, B:101:0x03fc, B:102:0x0421), top: B:94:0x03b1 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ void a(Context context, ActivityManager activityManager, String str) {
        String str2;
        String str3;
        SharedPreferences sharedPreferences;
        String str4;
        List list;
        Iterator it;
        String str5;
        String str6;
        long currentTimeMillis;
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        String str7;
        InputStream inputStream;
        InputStream inputStream2;
        Integer num;
        String str8;
        String str9;
        bx a16;
        JSONObject makeAttributes;
        JSONObject makeParam;
        ai a17;
        UserMeta userMeta;
        SharedPreferencesProvider sharedPreferencesProvider;
        Context context2;
        String str10 = str;
        try {
            Class<?> cls = activityManager.getClass();
            Class<?> cls2 = Integer.TYPE;
            Method method6 = cls.getMethod("getHistoricalProcessExitReasons", String.class, cls2, cls2);
            Class<?> cls3 = Class.forName("android.app.ApplicationExitInfo");
            Method method7 = cls3.getMethod("getTimestamp", new Class[0]);
            Method method8 = cls3.getMethod("getReason", new Class[0]);
            Method method9 = cls3.getMethod("getPid", new Class[0]);
            Method method10 = cls3.getMethod("getProcessName", new Class[0]);
            Method method11 = cls3.getMethod("getDescription", new Class[0]);
            Method method12 = cls3.getMethod("getTraceInputStream", new Class[0]);
            Method method13 = cls3.getMethod("getProcessStateSummary", new Class[0]);
            if (method6 != null && method7 != null && method8 != null && method9 != null && method10 != null && method11 != null && method12 != null && method13 != null) {
                SharedPreferences sharedPreferences2 = ai.c().V;
                if (sharedPreferences2 != null) {
                    f98362c = sharedPreferences2.getLong(Constants.SP_EXIT_LAST_TIME, 0L);
                    f98363d = sharedPreferences2.getLong(Constants.SP_EXIT_NORMAL_LAST_TIME, 0L);
                    f98364e = sharedPreferences2.getInt(Constants.SP_EXIT_NORMAL_COUNT, 0);
                }
                bx a18 = bx.a();
                try {
                    a18.f98368b = context;
                    a18.f98369c = new UserMeta();
                    a17 = ai.a(a18.f98368b);
                    a18.f98370d = a17;
                    str2 = Constants.SP_EXIT_LAST_TIME;
                } catch (Throwable th5) {
                    th = th5;
                    str2 = Constants.SP_EXIT_LAST_TIME;
                }
                try {
                    a18.f98369c.uin = a17.g();
                    UserMeta userMeta2 = a18.f98369c;
                    ai aiVar = a18.f98370d;
                    str4 = Constants.SP_EXIT_NORMAL_COUNT;
                    try {
                        userMeta2.buildNumber = aiVar.O;
                        userMeta2.appKey = "unknow_app_key";
                        userMeta2.appId = aiVar.f();
                        userMeta = a18.f98369c;
                        userMeta.appVersion = a18.f98370d.f98032t;
                        sharedPreferencesProvider = SharedPreferencesProvider.getInstance();
                        context2 = a18.f98368b;
                        str3 = Constants.SP_EXIT_NORMAL_LAST_TIME;
                        sharedPreferences = sharedPreferences2;
                    } catch (Throwable th6) {
                        th = th6;
                        str3 = Constants.SP_EXIT_NORMAL_LAST_TIME;
                        sharedPreferences = sharedPreferences2;
                    }
                    try {
                        userMeta.sharePreference = sharedPreferencesProvider.getSharedPreferences(context2, SPKey.SP_NAME, true);
                        a18.f98369c.crashSharedPreferences = SharedPreferencesProvider.getInstance().getSharedPreferences(a18.f98368b, Constants.BUGLY_SHARED_PREFERENCES, true);
                        UserMeta userMeta3 = a18.f98369c;
                        ai aiVar2 = a18.f98370d;
                        userMeta3.sdkVersion = aiVar2.f98020h;
                        userMeta3.setModel(aiVar2.i());
                        a18.f98369c.setUniqueID(a18.f98370d.h());
                        a18.f98371e = new UploadProxy(a18.f98368b, a18.f98370d.f());
                        StringBuilder sb5 = new StringBuilder();
                        String str11 = bx.f98366a;
                        sb5.append(str11);
                        String str12 = File.separator;
                        sb5.append(str12);
                        sb5.append("v1");
                        sb5.append(str12);
                        sb5.append(ai.a(a18.f98368b).f());
                        sb5.append(str12);
                        sb5.append("upload-file");
                        a18.f98372f = sb5.toString();
                        a18.f98373g = str11 + str12 + "v1" + str12 + ai.a(a18.f98368b).f() + str12 + "upload-json";
                    } catch (Throwable th7) {
                        th = th7;
                        av.b(th);
                        list = (List) method6.invoke(activityManager, null, 0, 0);
                        if (list != null) {
                        }
                        av.a("No exit info need to upload.", new Object[0]);
                        return;
                    }
                } catch (Throwable th8) {
                    th = th8;
                    str3 = Constants.SP_EXIT_NORMAL_LAST_TIME;
                    sharedPreferences = sharedPreferences2;
                    str4 = Constants.SP_EXIT_NORMAL_COUNT;
                    av.b(th);
                    list = (List) method6.invoke(activityManager, null, 0, 0);
                    if (list != null) {
                        it = list.iterator();
                        int i3 = 0;
                        int i16 = 0;
                        while (it.hasNext()) {
                        }
                        str5 = "ExitInfo";
                        str6 = ReportDataBuilder.KEY_ATTRIBUTES;
                        currentTimeMillis = System.currentTimeMillis();
                        if (86400000 < Math.abs(currentTimeMillis - f98363d)) {
                        }
                        sharedPreferences.edit().putInt(str4, f98364e).apply();
                        f98362c = currentTimeMillis;
                        sharedPreferences.edit().putLong(str2, f98362c).apply();
                        av.a("Success handle all info, query exit info: " + i3 + ", exception exit upload: " + i16, new Object[0]);
                        return;
                    }
                    av.a("No exit info need to upload.", new Object[0]);
                    return;
                }
                list = (List) method6.invoke(activityManager, null, 0, 0);
                if (list != null && !list.isEmpty()) {
                    it = list.iterator();
                    int i36 = 0;
                    int i162 = 0;
                    while (it.hasNext()) {
                        Object next = it.next();
                        Iterator it5 = it;
                        Long l3 = (Long) method7.invoke(next, new Object[0]);
                        Method method14 = method7;
                        Integer num2 = (Integer) method8.invoke(next, new Object[0]);
                        if (l3 == null || num2 == null) {
                            method = method13;
                            method2 = method9;
                            method3 = method10;
                            method4 = method11;
                            method5 = method12;
                            str10 = str;
                            it = it5;
                            method7 = method14;
                            method8 = method8;
                        } else {
                            if (l3.longValue() < f98362c || 50 <= i36 || 10 <= i162) {
                                str5 = "ExitInfo";
                                str6 = ReportDataBuilder.KEY_ATTRIBUTES;
                                break;
                            }
                            int i17 = i36 + 1;
                            Method method15 = method8;
                            if (num2.intValue() != 4 && num2.intValue() != 5 && num2.intValue() != 6 && num2.intValue() != 12 && num2.intValue() != 9 && num2.intValue() != 7 && num2.intValue() != 3 && num2.intValue() != 8) {
                                f98364e++;
                            } else {
                                String str13 = "";
                                if (num2.intValue() != 4 && num2.intValue() != 5 && num2.intValue() != 6) {
                                    method = method13;
                                    str7 = null;
                                    num = (Integer) method9.invoke(next, new Object[0]);
                                    method2 = method9;
                                    str8 = (String) method10.invoke(next, new Object[0]);
                                    method3 = method10;
                                    str9 = (String) method11.invoke(next, new Object[0]);
                                    method4 = method11;
                                    av.a("exitProcessId:" + num + "; exitProcessName:" + str8 + "; exitTime:" + l3 + "; exitReason:" + num2 + "; exitDescription:" + str9 + "; crashIdentify: " + str13, new Object[0]);
                                    if (num != null && str8 != null) {
                                        a16 = bx.a();
                                        int intValue = num.intValue();
                                        long longValue = l3.longValue();
                                        int intValue2 = num2.intValue();
                                        try {
                                            File a19 = (!TextUtils.isEmpty(str7) || TextUtils.isEmpty(str)) ? null : bx.a(str7, str10);
                                            JSONObject jSONObject = new JSONObject();
                                            makeAttributes = ReportDataBuilder.makeAttributes(new String[]{"stage"});
                                            method5 = method12;
                                            try {
                                                jSONObject.put(CrashHianalyticsData.PROCESS_ID, intValue);
                                                jSONObject.put("process_name", str8);
                                                jSONObject.put("exit_time", longValue);
                                                jSONObject.put("reason", intValue2);
                                                jSONObject.put("description", str9);
                                                jSONObject.put("crash_identify", str13);
                                                makeAttributes.put("type", "exception");
                                                makeAttributes.put("data", jSONObject);
                                                makeParam = ReportDataBuilder.makeParam(a16.f98368b, "exception", "application_exit", a16.f98369c);
                                                if (makeParam == null) {
                                                    makeParam.put(ReportDataBuilder.KEY_ATTRIBUTES, makeAttributes);
                                                    ReportData reportData = new ReportData(a16.f98369c.uin, 1, "ExitInfo", makeParam);
                                                    if (a19 != null) {
                                                        reportData.addFile(a19.getCanonicalPath(), true, true);
                                                        a16.f98371e.reportFile(reportData, a16.f98372f + a16.f98371e.getMD5Params(reportData), null);
                                                    } else {
                                                        a16.f98371e.reportJson(reportData, a16.f98373g + a16.f98371e.getMD5Params(reportData), null);
                                                    }
                                                }
                                            } catch (Throwable th9) {
                                                th = th9;
                                                av.b(th);
                                                i162++;
                                                str10 = str;
                                                it = it5;
                                                method7 = method14;
                                                method8 = method15;
                                                i36 = i17;
                                                method13 = method;
                                                method9 = method2;
                                                method10 = method3;
                                                method11 = method4;
                                                method12 = method5;
                                            }
                                        } catch (Throwable th10) {
                                            th = th10;
                                            method5 = method12;
                                        }
                                        i162++;
                                        str10 = str;
                                        it = it5;
                                        method7 = method14;
                                        method8 = method15;
                                        i36 = i17;
                                    }
                                    method5 = method12;
                                    str10 = str;
                                    it = it5;
                                    method7 = method14;
                                    method8 = method15;
                                    i36 = i17;
                                }
                                byte[] bArr = (byte[]) method13.invoke(next, new Object[0]);
                                if (bArr != null && bArr.length != 0) {
                                    String str14 = new String(bArr, "UTF-8");
                                    if (num2.intValue() != 6 || Math.random() >= f98361b || (inputStream2 = (InputStream) method12.invoke(next, new Object[0])) == null) {
                                        method = method13;
                                        str7 = null;
                                    } else {
                                        StringBuilder sb6 = new StringBuilder();
                                        sb6.append(str10);
                                        method = method13;
                                        sb6.append(File.separator);
                                        sb6.append("exit_trace_");
                                        sb6.append(str14);
                                        str7 = sb6.toString();
                                        FileUtil.writeFile(str7, inputStream2, false);
                                    }
                                    if (num2.intValue() == 5 && aj.c() >= 31 && Math.random() < f98361b && (inputStream = (InputStream) method12.invoke(next, new Object[0])) != null) {
                                        str7 = str10 + File.separator + "exit_tombs_" + str14;
                                        FileUtil.writeFile(str7, inputStream, false);
                                    }
                                    str13 = str14;
                                    num = (Integer) method9.invoke(next, new Object[0]);
                                    method2 = method9;
                                    str8 = (String) method10.invoke(next, new Object[0]);
                                    method3 = method10;
                                    str9 = (String) method11.invoke(next, new Object[0]);
                                    method4 = method11;
                                    av.a("exitProcessId:" + num + "; exitProcessName:" + str8 + "; exitTime:" + l3 + "; exitReason:" + num2 + "; exitDescription:" + str9 + "; crashIdentify: " + str13, new Object[0]);
                                    if (num != null) {
                                        a16 = bx.a();
                                        int intValue3 = num.intValue();
                                        long longValue2 = l3.longValue();
                                        int intValue22 = num2.intValue();
                                        if (TextUtils.isEmpty(str7)) {
                                        }
                                        JSONObject jSONObject2 = new JSONObject();
                                        makeAttributes = ReportDataBuilder.makeAttributes(new String[]{"stage"});
                                        method5 = method12;
                                        jSONObject2.put(CrashHianalyticsData.PROCESS_ID, intValue3);
                                        jSONObject2.put("process_name", str8);
                                        jSONObject2.put("exit_time", longValue2);
                                        jSONObject2.put("reason", intValue22);
                                        jSONObject2.put("description", str9);
                                        jSONObject2.put("crash_identify", str13);
                                        makeAttributes.put("type", "exception");
                                        makeAttributes.put("data", jSONObject2);
                                        makeParam = ReportDataBuilder.makeParam(a16.f98368b, "exception", "application_exit", a16.f98369c);
                                        if (makeParam == null) {
                                        }
                                        i162++;
                                        str10 = str;
                                        it = it5;
                                        method7 = method14;
                                        method8 = method15;
                                        i36 = i17;
                                    }
                                    method5 = method12;
                                    str10 = str;
                                    it = it5;
                                    method7 = method14;
                                    method8 = method15;
                                    i36 = i17;
                                }
                            }
                            method = method13;
                            method2 = method9;
                            method3 = method10;
                            method4 = method11;
                            method5 = method12;
                            str10 = str;
                            it = it5;
                            method7 = method14;
                            method8 = method15;
                            i36 = i17;
                        }
                        method13 = method;
                        method9 = method2;
                        method10 = method3;
                        method11 = method4;
                        method12 = method5;
                    }
                    str5 = "ExitInfo";
                    str6 = ReportDataBuilder.KEY_ATTRIBUTES;
                    currentTimeMillis = System.currentTimeMillis();
                    if (86400000 < Math.abs(currentTimeMillis - f98363d)) {
                        if (f98364e != 0) {
                            bx a26 = bx.a();
                            int i18 = f98364e;
                            try {
                                JSONObject makeAttributes2 = ReportDataBuilder.makeAttributes(new String[]{"stage"});
                                makeAttributes2.put("type", "normal");
                                makeAttributes2.put("count", i18);
                                JSONObject makeParam2 = ReportDataBuilder.makeParam(a26.f98368b, "exception", "application_exit", a26.f98369c);
                                if (makeParam2 != null) {
                                    makeParam2.put(str6, makeAttributes2);
                                    ReportData reportData2 = new ReportData(a26.f98369c.uin, 1, str5, makeParam2);
                                    a26.f98371e.reportJson(reportData2, a26.f98373g + a26.f98371e.getMD5Params(reportData2), null);
                                }
                            } catch (Throwable th11) {
                                av.b(th11);
                            }
                        }
                        f98363d = currentTimeMillis;
                        sharedPreferences.edit().putLong(str3, currentTimeMillis).apply();
                        f98364e = 0;
                    }
                    sharedPreferences.edit().putInt(str4, f98364e).apply();
                    f98362c = currentTimeMillis;
                    sharedPreferences.edit().putLong(str2, f98362c).apply();
                    av.a("Success handle all info, query exit info: " + i36 + ", exception exit upload: " + i162, new Object[0]);
                    return;
                }
                av.a("No exit info need to upload.", new Object[0]);
                return;
            }
            av.c("Failed to get ApplicationExitInfo method.", new Object[0]);
        } catch (Throwable th12) {
            av.a(th12);
        }
    }
}
