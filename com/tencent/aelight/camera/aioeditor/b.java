package com.tencent.aelight.camera.aioeditor;

import android.util.SparseIntArray;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.statistics.ReportController;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static String f66575a = "";

    /* renamed from: b, reason: collision with root package name */
    public static String f66576b = "";

    /* renamed from: c, reason: collision with root package name */
    public static String f66577c = "";

    /* renamed from: d, reason: collision with root package name */
    public static String f66578d = "";

    /* renamed from: e, reason: collision with root package name */
    public static String f66579e = "";

    /* renamed from: f, reason: collision with root package name */
    public static boolean f66580f = false;

    /* renamed from: g, reason: collision with root package name */
    public static long f66581g = -1;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f66582h = false;

    /* renamed from: i, reason: collision with root package name */
    public static final SparseIntArray f66583i;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f66583i = sparseIntArray;
        sparseIntArray.put(10000, 1);
        sparseIntArray.put(10004, 2);
        sparseIntArray.put(10001, 3);
        sparseIntArray.put(10002, 4);
        sparseIntArray.put(10007, 5);
        sparseIntArray.put(10003, 6);
        sparseIntArray.put(10012, 7);
        sparseIntArray.put(10013, 8);
    }

    public static com.tencent.mobileqq.statistics.reportitem.b a() {
        com.tencent.mobileqq.statistics.reportitem.b bVar = new com.tencent.mobileqq.statistics.reportitem.b();
        bVar.f290084a = new SimpleDateFormat(DateUtil.DATE_FORMAT_14).format(new Date());
        bVar.f290085b = "";
        bVar.f290086c = "";
        bVar.f290087d = "";
        bVar.f290088e = f66583i.get(-1, -1);
        bVar.f290089f = "${count_unknown}";
        bVar.f290090g = "";
        bVar.f290091h = "";
        bVar.f290092i = "";
        bVar.f290093j = "";
        bVar.f290094k = "";
        bVar.f290095l = "";
        bVar.f290096m = "";
        bVar.f290097n = "";
        bVar.f290098o = "";
        bVar.f290099p = "";
        bVar.f290100q = "";
        bVar.f290101r = "";
        bVar.f290102s = "";
        bVar.f290103t = "";
        bVar.f290104u = "";
        bVar.f290105v = "";
        return bVar;
    }

    public static void b(int i3) {
        if (f66582h) {
            com.tencent.mobileqq.statistics.reportitem.b a16 = a();
            a16.f290090g = i3 + "";
            a16.f290086c = "0X800842B";
            a16.f290087d = "0X800842B";
            com.tencent.mobileqq.statistics.c.e(null, a16);
        }
    }

    public static void p(int i3) {
        if (f66582h) {
            com.tencent.mobileqq.statistics.reportitem.b a16 = a();
            a16.f290086c = "0X800842E";
            a16.f290087d = "0X800842E";
            if (a16.f290088e == 5) {
                a16.f290091h = f66575a;
            }
            a16.f290092i = f66576b;
            a16.f290093j = f66577c;
            a16.f290094k = f66578d;
            a16.f290095l = f66579e;
            a16.f290096m = i3 + "";
            com.tencent.mobileqq.statistics.c.e(null, a16);
            if (f66580f) {
                a16.f290086c = "0X80083B0";
                a16.f290087d = "0X80083B0";
                com.tencent.mobileqq.statistics.c.e(null, a16);
            }
        }
    }

    public static void q(int i3) {
        if (f66582h) {
            com.tencent.mobileqq.statistics.reportitem.b a16 = a();
            a16.f290086c = "0X8008431";
            a16.f290087d = "0X8008431";
            if (a16.f290088e == 5) {
                a16.f290091h = f66575a;
            }
            a16.f290092i = f66576b;
            a16.f290093j = f66577c;
            a16.f290094k = f66578d;
            a16.f290095l = f66579e;
            a16.f290096m = i3 + "";
            a16.f290099p = f66581g + "";
            com.tencent.mobileqq.statistics.c.e(null, a16);
            if (f66580f) {
                a16.f290086c = "0X80083AF";
                a16.f290087d = "0X80083AF";
                com.tencent.mobileqq.statistics.c.e(null, a16);
            }
        }
    }

    public static void j(com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e eVar) {
        i(null, eVar);
    }

    public static void e(EditVideoPartManager editVideoPartManager) {
        EditVideoParams editVideoParams;
        if (editVideoPartManager == null || (editVideoParams = editVideoPartManager.C) == null || editVideoParams.f204055d != 14) {
            return;
        }
        ReportController.o(null, "dc00898", "", "", "0X800A55F", "0X800A55F", !editVideoPartManager.l0() ? 1 : 2, 0, "", "", "", "");
    }

    public static void f(EditVideoPartManager editVideoPartManager) {
        EditVideoParams editVideoParams;
        if (editVideoPartManager == null || (editVideoParams = editVideoPartManager.C) == null || editVideoParams.f204055d != 14) {
            return;
        }
        ReportController.o(null, "dc00898", "", "", "0X800A558", "0X800A558", 0, 0, "", "", "", "");
    }

    public static void g(EditVideoPartManager editVideoPartManager) {
        EditVideoParams editVideoParams;
        if (editVideoPartManager == null || (editVideoParams = editVideoPartManager.C) == null || editVideoParams.f204055d != 14) {
            return;
        }
        ReportController.o(null, "dc00898", "", "", "0X800A556", "0X800A556", 0, 0, "", "", "", "");
    }

    public static void k(EditVideoPartManager editVideoPartManager) {
        EditVideoParams editVideoParams;
        if (editVideoPartManager == null || (editVideoParams = editVideoPartManager.C) == null || editVideoParams.f204055d != 14) {
            return;
        }
        ReportController.o(null, "dc00898", "", "", "0X800A559", "0X800A559", !editVideoPartManager.l0() ? 1 : 2, 0, "", "", "", "");
    }

    public static void l(EditVideoPartManager editVideoPartManager) {
        EditVideoParams editVideoParams;
        if (editVideoPartManager == null || (editVideoParams = editVideoPartManager.C) == null || editVideoParams.f204055d != 14) {
            return;
        }
        ReportController.o(null, "dc00898", "", "", "0X800A55E", "0X800A55E", !editVideoPartManager.l0() ? 1 : 2, 0, "", "", "", "");
    }

    public static void m(EditVideoPartManager editVideoPartManager) {
        EditVideoParams editVideoParams;
        if (editVideoPartManager == null || (editVideoParams = editVideoPartManager.C) == null || editVideoParams.f204055d != 14) {
            return;
        }
        ReportController.o(null, "dc00898", "", "", "0X800A557", "0X800A557", 0, 0, "", "", "", "");
    }

    public static void n(EditVideoPartManager editVideoPartManager) {
        EditVideoParams editVideoParams;
        if (editVideoPartManager == null || (editVideoParams = editVideoPartManager.C) == null || editVideoParams.f204055d != 14) {
            return;
        }
        ReportController.o(null, "dc00898", "", "", "0X800A555", "0X800A555", 0, 0, "", "", "", "");
    }

    public static void o(EditVideoPartManager editVideoPartManager) {
        EditVideoParams editVideoParams;
        if (editVideoPartManager == null || (editVideoParams = editVideoPartManager.C) == null || editVideoParams.f204055d != 14) {
            return;
        }
        ReportController.o(null, "dc00898", "", "", "0X800A55D", "0X800A55D", 0, 0, "", "", "", "");
    }

    public static void d(EditVideoPartManager editVideoPartManager, com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e eVar) {
        EditVideoParams editVideoParams;
        if (eVar == null || editVideoPartManager == null || (editVideoParams = editVideoPartManager.C) == null || editVideoParams.f204055d != 14) {
            return;
        }
        ReportController.o(null, "dc00898", "", "", "0X800A55B", "0X800A55B", eVar.f68842i ? 1 : 2, 0, "", "", "", "");
    }

    public static void h(EditVideoPartManager editVideoPartManager, com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e eVar) {
        EditVideoParams editVideoParams;
        if (eVar == null || editVideoPartManager == null || (editVideoParams = editVideoPartManager.C) == null || editVideoParams.f204055d != 14) {
            return;
        }
        ReportController.o(null, "dc00898", "", "", "0X800A55C", "0X800A55C", eVar.f68842i ? 1 : 2, 0, "", "", "", "");
    }

    public static void i(EditVideoPartManager editVideoPartManager, com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e eVar) {
        String str;
        EditVideoParams editVideoParams;
        if (eVar == null) {
            return;
        }
        if (editVideoPartManager == null || (editVideoParams = editVideoPartManager.C) == null || editVideoParams.f204055d == 14) {
            int i3 = eVar.f68837d;
            if (i3 == 1) {
                str = "2";
            } else if (i3 == 0) {
                str = "1";
            } else {
                str = "3";
            }
            ReportController.o(null, "dc00898", "", "", "0X800A55A", "0X800A55A", eVar.f68842i ? 1 : 2, 0, str, "", "", "");
        }
    }

    public static void c() {
    }
}
