package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.framework.common.hianalytics.LinkedHashMapPack;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class e {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f37010a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f37011b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ JSONArray f37012c;

        a(long j3, ArrayList arrayList, JSONArray jSONArray) {
            this.f37010a = j3;
            this.f37011b = arrayList;
            this.f37012c = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            com.huawei.hms.framework.network.grs.g.k.a aVar = new com.huawei.hms.framework.network.grs.g.k.a();
            aVar.put("total_time", this.f37010a);
            Iterator it = this.f37011b.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.o() || dVar.m()) {
                    aVar.put(e.b(dVar));
                    it.remove();
                    z16 = true;
                    break;
                }
            }
            z16 = false;
            if (!z16 && this.f37011b.size() > 0) {
                ArrayList arrayList = this.f37011b;
                d dVar2 = (d) arrayList.get(arrayList.size() - 1);
                aVar.put(e.b(dVar2));
                this.f37011b.remove(dVar2);
            }
            if (this.f37011b.size() > 0) {
                Iterator it5 = this.f37011b.iterator();
                while (it5.hasNext()) {
                    this.f37012c.mo162put(new JSONObject(e.b((d) it5.next())));
                }
            }
            if (this.f37012c.length() > 0) {
                aVar.put("failed_info", this.f37012c.toString());
            }
            Logger.d("HaReportHelper", "grssdk report data to aiops is: %s", new JSONObject(aVar.get()));
            HianalyticsHelper.getInstance().onEvent(aVar.get(), "grs_request");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static LinkedHashMap<String, String> b(d dVar) {
        LinkedHashMapPack linkedHashMapPack = new LinkedHashMapPack();
        Exception d16 = dVar.d();
        if (d16 != null) {
            linkedHashMapPack.put("error_code", ExceptionCode.getErrorCodeFromException(d16));
            linkedHashMapPack.put(CrashHianalyticsData.EXCEPTION_NAME, d16.getClass().getSimpleName());
            linkedHashMapPack.put("message", StringUtils.anonymizeMessage(d16.getMessage()));
        } else {
            linkedHashMapPack.put("error_code", dVar.b());
            linkedHashMapPack.put(CrashHianalyticsData.EXCEPTION_NAME, dVar.c());
        }
        try {
            linkedHashMapPack.put("domain", new URL(dVar.l()).getHost());
        } catch (MalformedURLException e16) {
            Logger.w("HaReportHelper", "report host MalformedURLException", e16);
        }
        linkedHashMapPack.put("req_start_time", dVar.h());
        linkedHashMapPack.put("req_end_time", dVar.g());
        linkedHashMapPack.put("req_total_time", dVar.i());
        return linkedHashMapPack.getAll();
    }

    public static void a(ArrayList<d> arrayList, long j3, JSONArray jSONArray, Context context) {
        if (context == null || arrayList == null || arrayList.size() <= 0 || !HianalyticsHelper.getInstance().isEnableReportNoSeed(context)) {
            return;
        }
        HianalyticsHelper.getInstance().getReportExecutor().submit(new a(j3, arrayList, jSONArray));
    }
}
