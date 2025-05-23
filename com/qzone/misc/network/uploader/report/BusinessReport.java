package com.qzone.misc.network.uploader.report;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_dc02727;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class BusinessReport {

    /* renamed from: a, reason: collision with root package name */
    private static Random f48566a = new Random();

    /* renamed from: b, reason: collision with root package name */
    private static final Object[] f48567b = new Object[16];

    /* renamed from: c, reason: collision with root package name */
    private static long f48568c = SystemClock.uptimeMillis();

    /* renamed from: d, reason: collision with root package name */
    private static SparseArray<ArrayList<a>> f48569d = new SparseArray<>(16);

    /* renamed from: e, reason: collision with root package name */
    private static boolean f48570e = true;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class ReportRunnable implements Runnable {
        String C;
        String D;

        /* renamed from: h, reason: collision with root package name */
        ArrayList<a> f48574h;

        /* renamed from: i, reason: collision with root package name */
        int f48575i;

        /* renamed from: m, reason: collision with root package name */
        int f48576m;

        /* renamed from: d, reason: collision with root package name */
        boolean f48571d = false;

        /* renamed from: e, reason: collision with root package name */
        boolean f48572e = false;

        /* renamed from: f, reason: collision with root package name */
        int f48573f = 0;
        int E = 0;

        public ReportRunnable(ArrayList<a> arrayList, int i3, int i16) {
            this.f48574h = arrayList;
            this.f48575i = i3;
            this.f48576m = i16;
        }

        private void a(int i3, int i16) {
            HashMap<String, String> hashMap = new HashMap<>();
            if (i3 == 1) {
                hashMap.put("report_try_time", String.valueOf(i16));
            } else if (i3 == 2) {
                hashMap.put("report_try_count", String.valueOf(i16));
            }
            if (hashMap.size() > 0) {
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, StatisticCollector.QZONE_UPLOAD_REPORT_TRY_AGAIN, true, 0L, 0L, hashMap, (String) null, true);
            }
        }

        private void e() {
            if (this.f48571d || this.f48574h.isEmpty()) {
                return;
            }
            ArrayList<a> arrayList = this.f48574h;
            int config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_REPORT, QzoneConfig.SECONDARY_KEY_UPLOAD_SWITCH, 0);
            int i3 = this.f48576m;
            if (i3 == 0 && config == 0) {
                this.C = a.c(0, i3);
                Iterator<a> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().g(this.f48575i);
                }
            } else {
                this.C = a.c(this.f48575i, i3);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("count", arrayList.size());
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray();
                Iterator<a> it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    a next = it5.next();
                    if (next.d()) {
                        jSONArray.mo162put(next.h());
                    }
                    if (next.e()) {
                        jSONArray2.mo162put(next.h());
                    }
                }
                jSONObject.put("data", jSONArray);
                this.E = jSONArray.length();
                g(jSONArray2);
                if (this.f48576m == 0) {
                    QZLog.i("BusinessReport", "upload2: --- " + jSONObject.toString());
                }
            } catch (Exception e16) {
                QZLog.e("BusinessReport", "JSONException when uploadReport.", e16);
                jSONObject = null;
            }
            if (jSONObject != null) {
                this.D = jSONObject.toString();
            }
            this.f48571d = true;
        }

        private void f() {
            while (!this.f48572e) {
                int i3 = this.f48573f;
                if (i3 > 3) {
                    QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.ReportThread).postDelayed(this, MiniBoxNoticeInfo.MIN_5);
                    this.f48573f = 0;
                    return;
                }
                if (i3 != 0) {
                    try {
                        a(1, 1);
                        a(2, this.E);
                    } catch (Exception e16) {
                        this.f48573f++;
                        QZLog.e("BusinessReport", "exception when report", e16);
                    }
                }
                OkHttpClient okHttpClient = new OkHttpClient();
                RequestBody create = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), this.D);
                String authority = new URL(this.C).getAuthority();
                Response execute = okHttpClient.newCall(new Request.Builder().url(this.C).addHeader("Host", authority).addHeader("x-online-host", authority).post(create).build()).execute();
                if (execute.code() == 200) {
                    this.f48574h.clear();
                    execute.close();
                    this.f48572e = true;
                    QZLog.i("BusinessReport", 2, "report success.");
                } else {
                    QZLog.e("BusinessReport", "okHttpClient send tryCount:" + this.f48573f);
                    this.f48573f = this.f48573f + 1;
                }
            }
        }

        private void g(JSONArray jSONArray) {
            int config = QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_UPLOAD_LP_REPORT_SAMPLE, 0);
            int config2 = QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_UPLOAD_LP_REPORT_NOW, 0);
            QZLog.i("BusinessReport", "upload2: needSample \uff1d  " + config + " reportNow = " + config2);
            LpReportInfo_dc02727.report(jSONArray, config == 1, config2 == 1);
        }

        @Override // java.lang.Runnable
        public void run() {
            e();
            if (TextUtils.isEmpty(this.C) || TextUtils.isEmpty(this.D)) {
                return;
            }
            f();
        }
    }

    static /* bridge */ /* synthetic */ boolean b() {
        return e();
    }

    private static ArrayList<a> c() {
        return new ArrayList<a>() { // from class: com.qzone.misc.network.uploader.report.BusinessReport.1
            private final boolean a(a aVar) {
                int i3 = aVar.f48580b;
                return (i3 == 0 || i3 == -2) ? false : true;
            }

            @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
            public boolean add(a aVar) {
                if (!a(aVar)) {
                    if (BusinessReport.f48566a.nextInt(Math.round(20.0f)) == 0 || BusinessReport.b()) {
                        return super.add((AnonymousClass1) aVar);
                    }
                    return false;
                }
                return super.add((AnonymousClass1) aVar);
            }
        };
    }

    public static synchronized void d() {
        synchronized (BusinessReport.class) {
            for (int i3 = 0; i3 < 16; i3++) {
                if (i3 != 1 && i3 != 11) {
                    f48569d.append(i3, new ArrayList<>());
                } else {
                    f48569d.append(i3, c());
                }
            }
            int i16 = 0;
            while (true) {
                Object[] objArr = f48567b;
                if (i16 < objArr.length) {
                    objArr[i16] = new Object();
                    i16++;
                } else {
                    f48570e = false;
                }
            }
        }
    }

    private static boolean e() {
        return false;
    }

    private static boolean f(int i3) {
        return i3 % 2 == 0 && i3 >= 0 && i3 < 16;
    }

    private static boolean g(int i3) {
        if (i3 == 0 || i3 == 1) {
            return true;
        }
        return false;
    }

    public static void i(int i3, int i16) {
        ArrayList arrayList;
        if (f48570e) {
            d();
        }
        if (f(i3) && g(i16) && NetworkState.isNetSupport()) {
            int i17 = i3 + i16;
            ArrayList<a> arrayList2 = f48569d.get(i17);
            synchronized (f48567b[i17]) {
                arrayList = new ArrayList(arrayList2);
                if (i17 != 1 && i17 != 11) {
                    f48569d.setValueAt(i17, new ArrayList<>());
                    arrayList2.clear();
                    f48568c = SystemClock.uptimeMillis();
                }
                f48569d.setValueAt(i17, c());
                arrayList2.clear();
                f48568c = SystemClock.uptimeMillis();
            }
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.ReportThread).post(new ReportRunnable(arrayList, i3, i16));
        }
    }

    public static void h(a aVar, int i3, int i16) {
        if (aVar == null) {
            return;
        }
        if (f48570e) {
            d();
        }
        if (f(i3) && g(i16) && aVar.f48582d >= 0 && aVar.f48583e <= 900000) {
            int i17 = i3 + i16;
            long uptimeMillis = SystemClock.uptimeMillis() - f48568c;
            ArrayList<a> arrayList = f48569d.get(i17);
            if (arrayList == null) {
                return;
            }
            synchronized (f48567b[i17]) {
                arrayList.add(aVar);
            }
            if (i17 != 1) {
                if (i17 == 5) {
                    i(i3, i16);
                    return;
                } else if (i17 != 7 && i17 != 11) {
                    return;
                }
            }
            if (arrayList.size() >= 10 || uptimeMillis >= 600000) {
                i(i3, i16);
            }
        }
    }
}
