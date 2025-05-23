package com.tencent.qqprotect.report;

import android.text.TextUtils;
import com.google.protobuf.nano.MessageNano;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.channel.report.ReportReq;
import com.tencent.mobileqq.channel.report.SingleData;
import com.tencent.mobileqq.fe.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.common.b;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes25.dex */
public class O3Report {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static boolean f363546a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19645);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f363546a = false;
            }
        }

        public static void a() {
            f363546a = true;
        }
    }

    public static void a(String str, String str2, String str3) {
        b(null, str, str2, str3);
    }

    public static void c(String str, ArrayList<String> arrayList, ProtoUtils.TroopProtocolObserver troopProtocolObserver) {
        try {
            ReportReq reportReq = new ReportReq();
            reportReq.attaId = str;
            SingleData singleData = new SingleData();
            singleData.data = (String[]) arrayList.toArray(new String[arrayList.size()]);
            reportReq.singleDatas = new SingleData[]{singleData};
            AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
            if (appInterface != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("QSec.O3Report", 2, "ext1:" + TextUtils.join(",", arrayList) + " qua " + appInterface.getApp().getQua());
                }
                if (troopProtocolObserver == null) {
                    ProtoUtils.g(appInterface, MessageNano.toByteArray(reportReq), "trpc.o3.report.Report.SsoReport");
                } else {
                    ProtoUtils.d(appInterface, troopProtocolObserver, MessageNano.toByteArray(reportReq), "trpc.o3.report.Report.SsoReport");
                }
            }
        } catch (Throwable th5) {
            QLog.e("QSec.O3Report", 2, "doReport error!" + th5);
        }
    }

    private static void d(String str, List<String> list) {
        try {
            if (Integer.valueOf(list.get(0)).intValue() > 0) {
                String str2 = "loc_fatime_qt_" + MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
                MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
                if (System.currentTimeMillis() - from.decodeLong(str2, 0L) < 86400000) {
                    if (QLog.isColorLevel()) {
                        QLog.i("O3Report", 2, "fakeLocationReport: time has not arrived\uff01");
                    }
                } else {
                    e(str, list, "10002");
                    if (QLog.isColorLevel()) {
                        QLog.i("O3Report", 2, "fakeLocationReport: locationReport 10002");
                    }
                    from.encodeLong(str2, System.currentTimeMillis()).commitSync();
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private static void e(String str, List<String> list, String str2) {
        try {
            String qua = ((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).getApp().getQua();
            ArrayList arrayList = new ArrayList();
            arrayList.add(qua);
            arrayList.add(e.b().f());
            arrayList.add(b.c());
            arrayList.add(b.d());
            arrayList.add("env_detect");
            arrayList.add(str2);
            arrayList.add(list.get(0));
            arrayList.add(list.get(1));
            arrayList.add(list.get(2));
            arrayList.add(list.get(3));
            arrayList.add(str);
            c("00e00075618", arrayList, null);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static void f(String str, List<String> list) {
        d(str, list);
        g(str, list);
    }

    private static void g(String str, List<String> list) {
        try {
            if (str.equals("NearByPro")) {
                String str2 = "loc_netime_qt_" + MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin() + "_NearByPro";
                MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
                if (System.currentTimeMillis() - from.decodeLong(str2, 0L) < 86400000) {
                    if (QLog.isColorLevel()) {
                        QLog.i("O3Report", 2, "nearLocationReport: time has not arrived\uff01");
                    }
                } else {
                    e(str, list, "10003");
                    if (QLog.isColorLevel()) {
                        QLog.i("O3Report", 2, "nearLocationReport: locationReport 10003");
                    }
                    from.encodeLong(str2, System.currentTimeMillis()).commitSync();
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static void h() {
        i();
    }

    public static void j(String str, String str2, String str3) {
        ThreadManagerV2.excute(new Runnable(str, str2, str3) { // from class: com.tencent.qqprotect.report.O3Report.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f363543d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f363544e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f363545f;

            {
                this.f363543d = str;
                this.f363544e = str2;
                this.f363545f = str3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, str, str2, str3);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                    if (appInterface != null) {
                        e b16 = e.b();
                        if (b16.i()) {
                            String f16 = b16.f();
                            String qua = appInterface.getApp().getQua();
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(qua);
                            arrayList.add(f16);
                            arrayList.add("sign_report");
                            arrayList.add(this.f363543d);
                            arrayList.add(this.f363544e);
                            arrayList.add(this.f363545f);
                            arrayList.add("");
                            O3Report.c("0df00071646", arrayList, null);
                        }
                    }
                } catch (Throwable th5) {
                    QLog.e("QSec.O3Report", 2, "reportRt error!" + th5);
                }
            }
        }, 192, null, true);
    }

    public static void i() {
    }

    public static void b(String str, String str2, String str3, String str4) {
    }
}
