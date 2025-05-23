package com.tencent.mobileqq.extendfriend.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqexpand.bean.feed.b;
import com.tencent.mobileqq.qqexpand.manager.e;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ExtendFriendReport {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static ExtendFriendReport f205559a;

    /* renamed from: b, reason: collision with root package name */
    private static int f205560b;

    /* renamed from: c, reason: collision with root package name */
    private static int f205561c;

    /* renamed from: d, reason: collision with root package name */
    private static String f205562d;

    /* renamed from: e, reason: collision with root package name */
    private static String f205563e;

    /* renamed from: f, reason: collision with root package name */
    private static b f205564f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71783);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
            return;
        }
        f205560b = -1;
        f205561c = -1;
        f205562d = null;
        f205563e = null;
        f205564f = null;
    }

    public ExtendFriendReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static ExtendFriendReport a() {
        if (f205559a == null) {
            f205559a = new ExtendFriendReport();
        }
        return f205559a;
    }

    public static String b() {
        if (!TextUtils.isEmpty(f205562d)) {
            return f205562d;
        }
        return "";
    }

    public static String c() {
        int i3 = f205561c;
        if (i3 >= 0) {
            return String.valueOf(i3 + 1);
        }
        return "";
    }

    public static String d() {
        if (!TextUtils.isEmpty(f205563e)) {
            return f205563e;
        }
        return "";
    }

    public static int e() {
        return f205560b;
    }

    public static String f(b bVar) {
        b.C8313b c8313b;
        String str;
        String str2;
        if (bVar != null) {
            List<b.C8313b> list = bVar.mSchoolInfos;
            String str3 = null;
            if (list != null && !list.isEmpty()) {
                c8313b = bVar.mSchoolInfos.get(0);
            } else {
                c8313b = null;
            }
            if (c8313b != null) {
                str2 = String.valueOf(c8313b.f263489b);
                str = c8313b.f263490c;
            } else {
                str = null;
                str2 = null;
            }
            List<b.a> list2 = bVar.mLabelInfos;
            if (list2 != null && !list2.isEmpty()) {
                StringBuilder sb5 = new StringBuilder();
                boolean z16 = true;
                for (b.a aVar : bVar.mLabelInfos) {
                    if (z16) {
                        sb5.append(aVar.f263487b);
                        z16 = false;
                    } else {
                        sb5.append(",");
                        sb5.append(aVar.f263487b);
                    }
                }
                str3 = sb5.toString();
            }
            return String.format("%s_%s_%s", str2, str, str3);
        }
        return "";
    }

    public static String g(QQAppInterface qQAppInterface) {
        String str;
        e eVar;
        if (qQAppInterface != null && (eVar = (e) qQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)) != null && !TextUtils.isEmpty(eVar.c0())) {
            str = eVar.c0();
        } else {
            str = "";
        }
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendReport", 2, String.format("getRecomTrace1 strRecomTrace=%s", str));
        }
        return str;
    }

    public static String h(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendReport", 2, String.format("getRecomTrace2 strRecomTrace=%s", str));
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        return "";
    }

    private void i(String str, String str2, boolean z16, long j3, long j16, HashMap<String, String> hashMap, String str3) {
        ThreadManagerV2.post(new Runnable(str, str2, z16, j3, j16, hashMap, str3) { // from class: com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String C;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f205565d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f205566e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ boolean f205567f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ long f205568h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ long f205569i;

            /* renamed from: m, reason: collision with root package name */
            final /* synthetic */ HashMap f205570m;

            {
                this.f205565d = str;
                this.f205566e = str2;
                this.f205567f = z16;
                this.f205568h = j3;
                this.f205569i = j16;
                this.f205570m = hashMap;
                this.C = str3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, ExtendFriendReport.this, str, str2, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), hashMap, str3);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    try {
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f205565d, this.f205566e, this.f205567f, this.f205568h, this.f205569i, this.f205570m, this.C);
                    } catch (Exception unused) {
                    }
                }
            }
        }, 5, null, false);
    }

    public static void p() {
        f205560b = -1;
        f205561c = -1;
        f205562d = null;
        f205563e = null;
        f205564f = null;
    }

    public static void q(int i3, int i16, String str, String str2, b bVar) {
        f205560b = i3;
        f205561c = i16;
        f205562d = str;
        f205563e = str2;
        f205564f = bVar;
    }

    public static void r(QQAppInterface qQAppInterface, String str) {
        e eVar;
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendReport", 2, String.format("updateRecomTrace strRecomTrace=%s", str));
        }
        if (!TextUtils.isEmpty(str) && qQAppInterface != null && (eVar = (e) qQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)) != null) {
            eVar.v(str);
        }
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendReport", 2, "reportEntry");
        }
        i("", "extend_friend_entry", true, 0L, 0L, new HashMap<>(), "");
    }

    public void k(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendReport", 2, String.format("reportEntryDuration duration=%s", Integer.valueOf(i3)));
        }
        i("", "extend_friend_entry_duration", true, i3, 0L, new HashMap<>(), "");
    }

    public void l(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendReport", 2, String.format("reportFeedReq success=%s result=%s", Boolean.valueOf(z16), Integer.valueOf(i3)));
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_FailCode", String.valueOf(i3));
        i("", "extend_friend_feed_req", z16, 0L, 0L, hashMap, "");
    }

    public void m(int i3) {
        String str;
        String str2;
        SosoLocation sosoLocation;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        SosoLbsInfo sosoInfo = ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).getSosoInfo();
        String str3 = "";
        if (sosoInfo == null || (sosoLocation = sosoInfo.mLocation) == null) {
            str = "";
            str2 = str;
        } else {
            if (!TextUtils.isEmpty(sosoLocation.city)) {
                str3 = sosoLocation.city;
            }
            str2 = String.format("%s;%s", Double.valueOf(sosoLocation.mLat02), Double.valueOf(sosoLocation.mLon02));
            str = str3;
        }
        ReportController.o(null, "dc00898", "", "", "0X800A68C", "0X800A68C", i3, 0, "", "", str, str2);
        HashMap hashMap = new HashMap();
        hashMap.put("frompage", String.valueOf(i3));
        ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("expose#chat_tab#view", true, -1L, -1L, hashMap, true, true);
    }

    public void n(int i3, String str, String str2, String str3, String str4, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), str, str2, str3, str4, str5);
        } else {
            ReportController.r(null, "dc00898", "", str, "0X800AD9A", "0X800AD9A", i3, 0, str2, str3, str4, str5);
        }
    }

    public void o(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendReport", 2, String.format("reportVoiceUploadReq success=%s result=%s", Boolean.valueOf(z16), Integer.valueOf(i3)));
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_FailCode", String.valueOf(i3));
        i("", "extend_friend_voice_upload_req", z16, 0L, 0L, hashMap, "");
    }
}
