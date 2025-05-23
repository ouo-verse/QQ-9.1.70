package com.tencent.mobileqq.winkpublish.uploader.report;

import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePublishQualityDataBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IWinkExport;
import com.tencent.mobileqq.winkpublish.config.WinkPublishConfigConstant;
import com.tencent.mobileqq.winkpublish.util.d;
import com.tencent.mobileqq.winkpublish.util.g;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes35.dex */
public class AUploadBusinessReport {

    /* renamed from: a, reason: collision with root package name */
    private static Random f327416a = new Random();

    /* renamed from: b, reason: collision with root package name */
    private static final Object[] f327417b = new Object[28];

    /* renamed from: c, reason: collision with root package name */
    private static long f327418c = SystemClock.uptimeMillis();

    /* renamed from: d, reason: collision with root package name */
    private static SparseArray<ArrayList<a>> f327419d = new SparseArray<>(28);

    /* renamed from: e, reason: collision with root package name */
    private static boolean f327420e = true;

    static /* bridge */ /* synthetic */ boolean b() {
        return e();
    }

    private static ArrayList<a> c() {
        return new ArrayList<a>() { // from class: com.tencent.mobileqq.winkpublish.uploader.report.AUploadBusinessReport.1
            private final boolean a(a aVar) {
                int i3 = aVar.f327428b;
                return (i3 == 0 || i3 == -2) ? false : true;
            }

            @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
            public boolean add(a aVar) {
                if (!a(aVar)) {
                    if (AUploadBusinessReport.f327416a.nextInt(Math.round(20.0f)) == 0 || AUploadBusinessReport.b()) {
                        return super.add((AnonymousClass1) aVar);
                    }
                    return false;
                }
                return super.add((AnonymousClass1) aVar);
            }
        };
    }

    public static synchronized void d() {
        synchronized (AUploadBusinessReport.class) {
            for (int i3 = 0; i3 < 28; i3++) {
                if (i3 != 1 && i3 != 11) {
                    f327419d.append(i3, new ArrayList<>());
                } else {
                    f327419d.append(i3, c());
                }
            }
            int i16 = 0;
            while (true) {
                Object[] objArr = f327417b;
                if (i16 < objArr.length) {
                    objArr[i16] = new Object();
                    i16++;
                } else {
                    f327420e = false;
                }
            }
        }
    }

    private static boolean e() {
        return false;
    }

    private static boolean f(int i3) {
        return i3 % 2 == 0 && i3 >= 0 && i3 < 28;
    }

    private static boolean g(int i3) {
        if (i3 == 0 || i3 == 1) {
            return true;
        }
        return false;
    }

    public static void i(int i3, int i16) {
        ArrayList arrayList;
        if (f327420e) {
            d();
        }
        if (f(i3) && g(i16) && d.k()) {
            int i17 = i3 + i16;
            ArrayList<a> arrayList2 = f327419d.get(i17);
            synchronized (f327417b[i17]) {
                arrayList = new ArrayList(arrayList2);
                if (i17 != 1 && i17 != 11) {
                    f327419d.setValueAt(i17, new ArrayList<>());
                    arrayList2.clear();
                    f327418c = SystemClock.uptimeMillis();
                }
                f327419d.setValueAt(i17, c());
                arrayList2.clear();
                f327418c = SystemClock.uptimeMillis();
            }
            g.d(new ReportRunnable(arrayList, i3, i16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static class ReportRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        boolean f327421d = false;

        /* renamed from: e, reason: collision with root package name */
        ArrayList<a> f327422e;

        /* renamed from: f, reason: collision with root package name */
        int f327423f;

        /* renamed from: h, reason: collision with root package name */
        int f327424h;

        public ReportRunnable(ArrayList<a> arrayList, int i3, int i16) {
            this.f327422e = arrayList;
            this.f327423f = i3;
            this.f327424h = i16;
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x006a A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0024 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void e() {
            if (this.f327421d) {
                QLog.w("[upload2]AUploadBusinessReport", 1, "inited = true");
                return;
            }
            if (this.f327422e.isEmpty()) {
                QLog.e("[upload2]AUploadBusinessReport", 1, "listToSend is empty.");
                return;
            }
            try {
                Iterator<a> it = this.f327422e.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next.b()) {
                        HashMap<String, String> c16 = next.c();
                        int i3 = next.f327438l;
                        if (i3 != 22 && i3 != 24) {
                            if (i3 != 18 && i3 != 20 && i3 != 26) {
                                f(next, "");
                                if (this.f327424h == 0) {
                                    QLog.i("[upload2]AUploadBusinessReport", 1, "upload2: --- " + c16.toString());
                                }
                            }
                            f(next, WinkPublishConfigConstant.EVENTID_PREFIX_QCIRCLE);
                            if (this.f327424h == 0) {
                            }
                        }
                        f(next, WinkPublishConfigConstant.EVENTID_PREFIX_GUILD);
                        if (this.f327424h == 0) {
                        }
                    }
                }
            } catch (Exception e16) {
                QLog.e("[upload2]AUploadBusinessReport", 1, "JSONException when uploadReport." + e16.getMessage());
            }
            this.f327421d = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            e();
        }

        private void f(a aVar, String str) {
            if (aVar == null) {
                return;
            }
            ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).uploadQualityReport(new QCirclePublishQualityDataBuilder().setKeyEventId(str + "P_UPLOAD_COST").setExt1(String.valueOf(aVar.f327431e)).setExt2(String.valueOf(aVar.f327430d)).setExt3(String.valueOf(aVar.f327427a)).setExt4(String.valueOf(aVar.f327436j)).setExt5(String.valueOf(aVar.f327438l)).setKeyRetCode(String.valueOf(aVar.f327428b)));
            if (aVar.f327438l == 20) {
                ((IWinkExport) QRoute.api(IWinkExport.class)).setUploadSpeed(aVar.f327427a, aVar.f327430d, aVar.f327431e);
            }
        }
    }

    public static void h(a aVar, int i3, int i16) {
        int i17;
        ArrayList<a> arrayList;
        if (aVar == null) {
            return;
        }
        if (f327420e) {
            d();
        }
        if (f(i3) && g(i16) && aVar.f327430d >= 0 && aVar.f327431e <= 900000 && (arrayList = f327419d.get((i17 = i3 + i16))) != null) {
            synchronized (f327417b[i17]) {
                arrayList.add(aVar);
            }
        }
    }
}
