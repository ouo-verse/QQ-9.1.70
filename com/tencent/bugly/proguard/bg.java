package com.tencent.bugly.proguard;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.bugly.common.meta.UserMeta;
import com.tencent.bugly.common.reporter.IReporter;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.bugly.common.reporter.data.AttachmentInfo;
import com.tencent.bugly.common.reporter.data.ReportData;
import com.tencent.bugly.common.reporter.upload.UploadProxy;
import com.tencent.bugly.common.trace.TraceGenerator;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.ao;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import cooperation.qzone.util.QZoneAppCtrlUploadFileLogic;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class bg {
    private static JSONObject a(CrashDetailBean crashDetailBean) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", bd.c(crashDetailBean));
            jSONObject.put("name", crashDetailBean.f97896v);
            jSONObject.put("message", crashDetailBean.f97897w);
            jSONObject.put("addr", crashDetailBean.f97898x);
        } catch (Throwable th5) {
            av.b(th5);
        }
        return jSONObject;
    }

    private static Map<String, String> b(CrashDetailBean crashDetailBean) {
        HashMap hashMap = new HashMap();
        try {
            Map<String, String> map = crashDetailBean.f97866ag;
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, String> entry : crashDetailBean.f97866ag.entrySet()) {
                    hashMap.put("C03_" + entry.getKey(), entry.getValue());
                }
            }
        } catch (Throwable th5) {
            av.b(th5);
        }
        return hashMap;
    }

    private static JSONObject c(CrashDetailBean crashDetailBean) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", crashDetailBean.f97871al);
            jSONObject.put(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, crashDetailBean.f97872am);
            jSONObject.put("sdk_version", ba.d("G10", ""));
        } catch (Throwable th5) {
            av.b(th5);
        }
        return jSONObject;
    }

    private static JSONArray d(CrashDetailBean crashDetailBean) {
        String[] split;
        JSONArray jSONArray = new JSONArray();
        try {
            Map<String, String> map = crashDetailBean.f97867ah;
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, String> entry : crashDetailBean.f97867ah.entrySet()) {
                    if (entry.getKey().equalsIgnoreCase("SDK_INFO") && (split = entry.getValue().split("[\\[\\], ]+")) != null && split.length > 2) {
                        for (int i3 = 1; i3 < split.length; i3 += 2) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(ReportDataBuilder.KEY_PRODUCT_ID, split[i3]);
                            jSONObject.put("version", split[i3 + 1]);
                            jSONArray.mo162put(jSONObject);
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            av.b(th5);
        }
        return jSONArray;
    }

    private static JSONObject e(CrashDetailBean crashDetailBean) {
        String str = "";
        JSONObject makeAttributes = ReportDataBuilder.makeAttributes();
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject.put("system_free", crashDetailBean.K);
            jSONObject.put("system_total", crashDetailBean.N);
            jSONObject.put("java_heap", crashDetailBean.S);
            jSONObject.put("java_heap_max", crashDetailBean.T);
            jSONObject.put("java_heap_alloc", crashDetailBean.U);
            jSONObject.put("pss", crashDetailBean.Q);
            jSONObject.put("vss", crashDetailBean.R);
            jSONObject2.put("total", crashDetailBean.O);
            jSONObject2.put("free", crashDetailBean.L);
            jSONObject3.put("total", crashDetailBean.P);
            jSONObject3.put("free", crashDetailBean.M);
            makeAttributes.put("exp_info", a(crashDetailBean));
            makeAttributes.put(com.tencent.mobileqq.msf.core.c0.j.T0, "");
            makeAttributes.put(ReportDataBuilder.KEY_BIZ_EXTEND_INFO, new JSONObject(b(crashDetailBean)));
            makeAttributes.put(ReportDataBuilder.KEY_HOT_PATCH, c(crashDetailBean));
            makeAttributes.put("component_info", d(crashDetailBean));
            makeAttributes.put("process_name", crashDetailBean.I);
            makeAttributes.put("app_channel", crashDetailBean.f97887m);
            makeAttributes.put("memory", jSONObject);
            makeAttributes.put(QQPermissionConstants.Permission.STORAGE_GROUP, jSONObject2);
            makeAttributes.put("sd", jSONObject3);
            makeAttributes.put("app_start_time", crashDetailBean.f97860aa / 1000);
            makeAttributes.put("is_root", ai.c().s());
            makeAttributes.put("is_development", ai.c().Q);
            makeAttributes.put("is_first_install", crashDetailBean.f97881g);
            makeAttributes.put("app_in_foreground", crashDetailBean.f97861ab);
            makeAttributes.put("custom_upload_anything", ai.c().f97995ad);
            makeAttributes.put(ReportDataBuilder.KEY_OPERATION_LOG, crashDetailBean.f97889o);
            try {
                if (!TextUtils.isEmpty(crashDetailBean.f97875ap) && crashDetailBean.f97876b == 3) {
                    makeAttributes.put(ReportDataBuilder.KEY_GC_INFO, new JSONObject(crashDetailBean.f97875ap));
                }
            } catch (Throwable th5) {
                av.b(th5);
            }
            try {
                String a16 = crashDetailBean.a("stage");
                if (a16 != null) {
                    str = a16;
                }
                makeAttributes.put("stage", str);
                makeAttributes.put(ReportDataBuilder.KEY_USER_CUSTOM, bi.b(crashDetailBean));
                bi.a(makeAttributes, crashDetailBean);
            } catch (Throwable unused) {
            }
            av.c("[extra data]append extra data to attribute {%s}", crashDetailBean.f97878d);
        } catch (Throwable th6) {
            av.b(th6);
        }
        return makeAttributes;
    }

    private static JSONArray f(CrashDetailBean crashDetailBean) {
        JSONArray jSONArray = new JSONArray();
        try {
            Map<String, String> map = crashDetailBean.H;
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("call_stack", entry.getValue());
                    jSONObject.put(CrashHianalyticsData.THREAD_NAME, b(entry.getKey()));
                    jSONObject.put(CrashHianalyticsData.THREAD_ID, a(entry.getKey()));
                    jSONArray.mo162put(jSONObject);
                }
            }
        } catch (Throwable th5) {
            av.b(th5);
        }
        return jSONArray;
    }

    private static JSONObject g(CrashDetailBean crashDetailBean) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("call_stack", crashDetailBean.f97899y);
            jSONObject.put(CrashHianalyticsData.THREAD_NAME, b(crashDetailBean.J));
            jSONObject.put(CrashHianalyticsData.THREAD_ID, a(crashDetailBean.J));
        } catch (Throwable th5) {
            av.b(th5);
        }
        return jSONObject;
    }

    private static JSONObject h(CrashDetailBean crashDetailBean) {
        JSONObject jSONObject = new JSONObject();
        try {
            Map<String, String> a16 = bd.a(crashDetailBean, ai.c(), false);
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, String> entry : a16.entrySet()) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("key", entry.getKey());
                jSONObject2.put("value", entry.getValue());
                jSONArray.mo162put(jSONObject2);
            }
            jSONObject.put("value_map", jSONArray);
            jSONObject.put("reserved_map", a());
            jSONObject.put("lib_info", "");
        } catch (Throwable th5) {
            av.b(th5);
        }
        return jSONObject;
    }

    private static JSONObject i(CrashDetailBean crashDetailBean) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stacks", f(crashDetailBean));
            jSONObject.put("attributed_stack", g(crashDetailBean));
            jSONObject.put("exception_info", h(crashDetailBean));
        } catch (Throwable th5) {
            av.b(th5);
        }
        return jSONObject;
    }

    private static JSONArray a() throws JSONException {
        String str;
        JSONArray jSONArray = new JSONArray();
        ai c16 = ai.c();
        HashMap hashMap = new HashMap();
        hashMap.put("A26", c16.t());
        hashMap.put(Constants.IS_VM_DEVICE, "");
        StringBuilder sb5 = new StringBuilder();
        sb5.append(ai.F());
        hashMap.put(Constants.HAS_HOOK_FRAME, sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        sb6.append(c16.R);
        hashMap.put(Constants.IS_FIRST_INSTALLATION, sb6.toString());
        StringBuilder sb7 = new StringBuilder();
        sb7.append(c16.Q);
        hashMap.put(Constants.IS_DEVELOPMENT_DEVICE, sb7.toString());
        hashMap.put(Constants.BASE_IN_APP_NAME, c16.f98034v);
        List<o> list = p.f98528b;
        if (list != null) {
            for (o oVar : list) {
                String str2 = oVar.versionKey;
                if (str2 != null && (str = oVar.version) != null) {
                    hashMap.put(str2, str);
                }
            }
        }
        Map<String, String> y16 = c16.y();
        if (y16 != null) {
            for (Map.Entry<String, String> entry : y16.entrySet()) {
                if (!TextUtils.isEmpty(entry.getValue())) {
                    hashMap.put(entry.getKey(), entry.getValue());
                }
            }
        }
        for (Map.Entry entry2 : hashMap.entrySet()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", entry2.getKey());
            jSONObject.put("value", entry2.getValue());
            jSONArray.mo162put(jSONObject);
        }
        return jSONArray;
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.split("\\(");
        return (split == null || split.length < 2) ? str : split[0];
    }

    private static AttachmentInfo b(Context context, CrashDetailBean crashDetailBean) {
        AttachmentInfo attachmentInfo = new AttachmentInfo();
        ai.c();
        Iterator<cg> it = bd.a(crashDetailBean, context, true).iterator();
        while (it.hasNext()) {
            cg next = it.next();
            AttachmentInfo.Item item = new AttachmentInfo.Item();
            item.data = next.f98396c;
            item.fileName = next.f98395b;
            item.type = next.f98394a;
            attachmentInfo.addItem(item);
        }
        return attachmentInfo;
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.split("\\(");
        return (split == null || split.length < 2) ? str : split[1].replace(")", "");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:2|3)|(9:7|(1:9)(1:27)|10|(1:12)|13|14|(1:16)(2:21|(1:23)(1:24))|17|18)|28|10|(0)|13|14|(0)(0)|17|18) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x014c, code lost:
    
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x014d, code lost:
    
        com.tencent.bugly.proguard.av.b(r12);
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x009f A[Catch: all -> 0x0151, TRY_LEAVE, TryCatch #0 {all -> 0x0151, blocks: (B:3:0x000c, B:10:0x004f, B:12:0x009f, B:26:0x014d, B:14:0x00a7, B:16:0x00c9, B:17:0x00f2, B:21:0x00d8, B:23:0x00e0), top: B:2:0x000c, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00c9 A[Catch: all -> 0x014c, TryCatch #1 {all -> 0x014c, blocks: (B:14:0x00a7, B:16:0x00c9, B:17:0x00f2, B:21:0x00d8, B:23:0x00e0), top: B:13:0x00a7, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00d8 A[Catch: all -> 0x014c, TryCatch #1 {all -> 0x014c, blocks: (B:14:0x00a7, B:16:0x00c9, B:17:0x00f2, B:21:0x00d8, B:23:0x00e0), top: B:13:0x00a7, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static JSONObject a(Context context, CrashDetailBean crashDetailBean) {
        UserMeta userMeta;
        JSONObject e16;
        JSONObject i3;
        int i16;
        String str;
        ai c16;
        String str2;
        ai a16 = ai.a(context);
        JSONObject jSONObject = new JSONObject();
        try {
            userMeta = new UserMeta();
            userMeta.uin = crashDetailBean.f97895u;
            userMeta.buildNumber = crashDetailBean.f97886l;
            userMeta.appId = a16.f();
            userMeta.appVersion = crashDetailBean.f97885k;
            userMeta.sdkVersion = crashDetailBean.f97884j;
            userMeta.setModel(crashDetailBean.f97883i);
            userMeta.setUniqueID(crashDetailBean.f97882h);
            e16 = e(crashDetailBean);
            i3 = i(crashDetailBean);
            i16 = crashDetailBean.f97876b;
        } catch (Throwable th5) {
            av.b(th5);
        }
        if (i16 != 0 && i16 != 1) {
            str = i16 == 3 ? QZoneAppCtrlUploadFileLogic.ANR_LOG_DIRECTORY : "error";
            jSONObject = ReportDataBuilder.makeParam(context, str, "basic_info", userMeta);
            jSONObject.put("event_time", crashDetailBean.f97900z / 1000);
            jSONObject.put(ReportDataBuilder.KEY_EVENT_TIME_IN_MS, crashDetailBean.f97900z);
            jSONObject.put("app_name", a16.f98034v);
            jSONObject.put(ReportDataBuilder.KEY_ATTRIBUTES, e16);
            jSONObject.put(ReportDataBuilder.KEY_BODY, i3);
            jSONObject.put(ReportDataBuilder.KEY_CLIENT_IDENTIFY, UUID.randomUUID().toString());
            jSONObject.put(ReportDataBuilder.KEY_PROCESS_LAUNCH_ID, crashDetailBean.f97878d);
            if (!TextUtils.equals(TraceGenerator.getProcessLaunchId(), crashDetailBean.f97878d)) {
                jSONObject.put(ReportDataBuilder.KEY_LAUNCH_ID, crashDetailBean.f97878d);
            }
            jSONObject.getJSONObject(ReportDataBuilder.KEY_RESOURCE).put("network_type", aj.b(context));
            JSONObject jSONObject2 = jSONObject.getJSONObject(ReportDataBuilder.KEY_RESOURCE);
            c16 = ai.c();
            if (TextUtils.isEmpty(c16.f98028p)) {
                av.c("get cpu type from so:%s", c16.f98028p);
                str2 = c16.f98028p;
            } else if (TextUtils.isEmpty(c16.f98029q)) {
                str2 = "unknown";
            } else {
                av.c("get cpu type from lib dir:%s", c16.f98029q);
                str2 = c16.f98029q;
            }
            jSONObject2.put("cpu_type", str2);
            jSONObject.getJSONObject(ReportDataBuilder.KEY_RESOURCE).put("arch_ver", ai.c().n());
            jSONObject.getJSONObject(ReportDataBuilder.KEY_RESOURCE).put("country_code", aj.o());
            jSONObject.getJSONObject(ReportDataBuilder.KEY_RESOURCE).put("rom", ai.c().t());
            jSONObject.getJSONObject(ReportDataBuilder.KEY_RESOURCE).put(Constants.SP_EMULATOR_CONFIDENCE, ai.c().D());
            jSONObject.getJSONObject(ReportDataBuilder.KEY_RESOURCE).put(Constants.SP_EMULATOR_REASON, ai.c().E());
            return jSONObject;
        }
        str = "crash";
        jSONObject = ReportDataBuilder.makeParam(context, str, "basic_info", userMeta);
        jSONObject.put("event_time", crashDetailBean.f97900z / 1000);
        jSONObject.put(ReportDataBuilder.KEY_EVENT_TIME_IN_MS, crashDetailBean.f97900z);
        jSONObject.put("app_name", a16.f98034v);
        jSONObject.put(ReportDataBuilder.KEY_ATTRIBUTES, e16);
        jSONObject.put(ReportDataBuilder.KEY_BODY, i3);
        jSONObject.put(ReportDataBuilder.KEY_CLIENT_IDENTIFY, UUID.randomUUID().toString());
        jSONObject.put(ReportDataBuilder.KEY_PROCESS_LAUNCH_ID, crashDetailBean.f97878d);
        if (!TextUtils.equals(TraceGenerator.getProcessLaunchId(), crashDetailBean.f97878d)) {
        }
        jSONObject.getJSONObject(ReportDataBuilder.KEY_RESOURCE).put("network_type", aj.b(context));
        JSONObject jSONObject22 = jSONObject.getJSONObject(ReportDataBuilder.KEY_RESOURCE);
        c16 = ai.c();
        if (TextUtils.isEmpty(c16.f98028p)) {
        }
        jSONObject22.put("cpu_type", str2);
        jSONObject.getJSONObject(ReportDataBuilder.KEY_RESOURCE).put("arch_ver", ai.c().n());
        jSONObject.getJSONObject(ReportDataBuilder.KEY_RESOURCE).put("country_code", aj.o());
        jSONObject.getJSONObject(ReportDataBuilder.KEY_RESOURCE).put("rom", ai.c().t());
        jSONObject.getJSONObject(ReportDataBuilder.KEY_RESOURCE).put(Constants.SP_EMULATOR_CONFIDENCE, ai.c().D());
        jSONObject.getJSONObject(ReportDataBuilder.KEY_RESOURCE).put(Constants.SP_EMULATOR_REASON, ai.c().E());
        return jSONObject;
    }

    private static void a(final Context context, aq aqVar, final CrashDetailBean crashDetailBean, long j3, final boolean z16) {
        final UploadProxy uploadProxy = new UploadProxy(context, ai.c().f());
        final ReportData reportData = new ReportData(ai.c().g(), 1, "CrashUploadEvent", a(context, crashDetailBean));
        reportData.updateAttachment(b(context, crashDetailBean));
        Runnable runnable = new Runnable() { // from class: com.tencent.bugly.proguard.bg.1
            @Override // java.lang.Runnable
            public final void run() {
                ap apVar;
                try {
                    final aq a16 = aq.a();
                    if (a16 != null && (apVar = a16.f98072b) != null) {
                        apVar.a(830);
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    UploadProxy.this.reportFile(reportData, UploadProxy.this.getFileUploadUrl(1) + UploadProxy.this.getMD5Params(reportData), new IReporter.ReportCallback() { // from class: com.tencent.bugly.proguard.bg.1.1
                        @Override // com.tencent.bugly.common.reporter.IReporter.ReportCallback
                        public final void onFailure(int i3, String str, int i16, int i17) {
                            String str2;
                            ap apVar2;
                            av.a(crashDetailBean.f97896v + ", crash upload failed! ,errorCode = " + i3 + ",errorMsg = " + str, new Object[0]);
                            if (ai.c().f97995ad) {
                                return;
                            }
                            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(crashDetailBean);
                            if (z16) {
                                str2 = "realtime";
                            } else {
                                str2 = "cache";
                            }
                            bg.a((List<CrashDetailBean>) arrayList, false, currentTimeMillis2, str2, str);
                            bg.a(false, (List<CrashDetailBean>) arrayList);
                            aq aqVar2 = a16;
                            if (aqVar2 != null && (apVar2 = aqVar2.f98072b) != null) {
                                CrashDetailBean crashDetailBean2 = crashDetailBean;
                                apVar2.a(830, null, 0L, 0L, false, "upload fail,error code = " + i3 + ", errorMsg = " + str, crashDetailBean2.f97896v, crashDetailBean2.f97900z);
                            }
                        }

                        @Override // com.tencent.bugly.common.reporter.IReporter.ReportCallback
                        public final void onSuccess(int i3, int i16) {
                            String str;
                            ap apVar2;
                            int i17;
                            av.a(crashDetailBean.f97896v + ", crash upload success!", new Object[0]);
                            if (ai.c().f97995ad) {
                                return;
                            }
                            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(crashDetailBean);
                            if (z16) {
                                str = "realtime";
                            } else {
                                str = "cache";
                            }
                            bg.a((List<CrashDetailBean>) arrayList, true, currentTimeMillis2, str, "upload success");
                            bg.a(true, (List<CrashDetailBean>) arrayList);
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            if (!z16 && ((i17 = crashDetailBean.f97876b) == 0 || i17 == 1 || i17 == 3)) {
                                bh a17 = bh.a();
                                AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                a17.a(context, crashDetailBean.f97878d);
                            }
                            aq aqVar2 = a16;
                            if (aqVar2 != null && (apVar2 = aqVar2.f98072b) != null) {
                                CrashDetailBean crashDetailBean2 = crashDetailBean;
                                apVar2.a(830, null, i16, 0L, true, " crash upload success", crashDetailBean2.f97896v, crashDetailBean2.f97900z);
                            }
                        }

                        @Override // com.tencent.bugly.common.reporter.IReporter.ReportCallback
                        public final void onCached() {
                        }
                    });
                } catch (Throwable th5) {
                    av.b(th5);
                }
            }
        };
        if (z16) {
            aqVar.a(runnable, true, true, j3);
        } else {
            aqVar.a(runnable, false, false, 0L);
        }
    }

    public static void a(Context context, aq aqVar, List<CrashDetailBean> list, long j3, boolean z16) {
        if (list != null) {
            try {
                if (list.isEmpty()) {
                    return;
                }
                Iterator<CrashDetailBean> it = list.iterator();
                while (it.hasNext()) {
                    a(context, aqVar, it.next(), j3, z16);
                }
            } catch (Throwable th5) {
                av.b(th5);
            }
        }
    }

    public static void a(Context context, ak akVar, int i3, aq aqVar, final List<CrashDetailBean> list, long j3, final boolean z16, boolean z17) {
        try {
            String str = akVar.c().f97853r;
            String str2 = StrategyBean.f97837b;
            ci a16 = bd.a(context, list, ai.c());
            if (a16 == null) {
                av.d("create eupPkg fail!", new Object[0]);
                return;
            }
            byte[] a17 = am.a((m) a16);
            if (a17 == null) {
                av.d("send encode fail!", new Object[0]);
                return;
            }
            cj a18 = am.a(context, 830, a17);
            if (a18 == null) {
                av.d("request package is null.", new Object[0]);
                return;
            }
            final long currentTimeMillis = System.currentTimeMillis();
            ap apVar = new ap() { // from class: com.tencent.bugly.proguard.bg.2
                @Override // com.tencent.bugly.proguard.ap
                public final void a(int i16) {
                }

                @Override // com.tencent.bugly.proguard.ap
                public final void a(int i16, ck ckVar, long j16, long j17, boolean z18, String str3, String str4, long j18) {
                    bg.a((List<CrashDetailBean>) list, z18, System.currentTimeMillis() - currentTimeMillis, z16 ? "realtime" : "cache", str3);
                    bg.a(z18, (List<CrashDetailBean>) list);
                }
            };
            if (z16) {
                aqVar.a(i3, a18, str, str2, apVar, j3, z17);
            } else {
                aqVar.a(i3, a18, str, str2, apVar);
            }
        } catch (Throwable th5) {
            av.e("req cr error %s", th5.toString());
            if (av.b(th5)) {
                return;
            }
            th5.printStackTrace();
        }
    }

    public static void a(List<CrashDetailBean> list, boolean z16, long j3, String str, String str2) {
        ao aoVar;
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (CrashDetailBean crashDetailBean : list) {
            String str3 = bd.f98195h.get(Integer.valueOf(crashDetailBean.f97876b));
            if (!TextUtils.isEmpty(str3)) {
                arrayList.add(new ao.c(crashDetailBean.f97877c, str3, crashDetailBean.f97900z, z16, j3, str, str2));
            }
        }
        aoVar = ao.a.f98059a;
        aoVar.a(arrayList);
    }

    public static void a(boolean z16, List<CrashDetailBean> list) {
        if (list != null && list.size() > 0) {
            av.c("up finish update state %b", Boolean.valueOf(z16));
            for (CrashDetailBean crashDetailBean : list) {
                av.c("pre uid:%s uc:%d re:%b me:%b", crashDetailBean.f97877c, Integer.valueOf(crashDetailBean.f97894t), Boolean.valueOf(crashDetailBean.f97880f), Boolean.valueOf(crashDetailBean.f97892r));
                int i3 = crashDetailBean.f97894t + 1;
                crashDetailBean.f97894t = i3;
                crashDetailBean.f97880f = z16;
                av.c("set uid:%s uc:%d re:%b me:%b", crashDetailBean.f97877c, Integer.valueOf(i3), Boolean.valueOf(crashDetailBean.f97880f), Boolean.valueOf(crashDetailBean.f97892r));
            }
            Iterator<CrashDetailBean> it = list.iterator();
            while (it.hasNext()) {
                be.a().a(it.next());
            }
            av.c("update state size %d", Integer.valueOf(list.size()));
        }
        if (z16) {
            return;
        }
        av.b("[crash] upload fail.", new Object[0]);
    }
}
