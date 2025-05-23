package com.tencent.mobileqq.faultreport.TrackerFilter;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.mqq.api.IThreadManagerApi;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePublishQualityDataBuilder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.winkreport.crashreport.WinkCrashReportParams;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import uq3.k;

/* compiled from: P */
/* loaded from: classes12.dex */
public class e implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static final Set<String> f205792b;

    /* renamed from: a, reason: collision with root package name */
    private int f205793a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42478);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f205792b = new HashSet(Arrays.asList("QCIRCLE", "GUILD", "QCIRCLE_AVATAR", "QZONE", QQWinkConstants.ENTRY_BUSINESS_KANDIAN, "ECOMMERCE", "SHARE_AVATAR", "QZONE_MOMENT", "QQLIVE_COVER", "QCIRCLE_REDPACKET", "QQLIVE_SKIN", "Flock"));
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f205793a = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(String str, com.tencent.mobileqq.faultreport.a aVar) {
        String str2;
        String str3;
        String str4;
        IQCircleReportApi iQCircleReportApi = (IQCircleReportApi) QRoute.api(IQCircleReportApi.class);
        QCirclePublishQualityDataBuilder ext1 = new QCirclePublishQualityDataBuilder().setTraceId(str).setKeyEventId(WinkCrashReportParams.E_PEAK_NEW_CRASH_PATHINFO).setExt1(aVar.f205794a);
        com.tencent.mobileqq.faultreport.contextinfo.a aVar2 = aVar.f205797d;
        if (aVar2 == null) {
            str2 = "";
        } else {
            str2 = aVar2.f205807e;
        }
        QCirclePublishQualityDataBuilder ext2 = ext1.setExt2(str2);
        com.tencent.mobileqq.faultreport.contextinfo.b bVar = aVar.f205798e;
        if (bVar == null) {
            str3 = "";
        } else {
            str3 = bVar.f205807e;
        }
        QCirclePublishQualityDataBuilder ext3 = ext2.setExt3(str3);
        if (aVar.f205797d == null) {
            str4 = "";
        } else {
            str4 = aVar.f205797d.f205806d + "";
        }
        iQCircleReportApi.uploadQualityReport(ext3.setExt4(str4).setExt5(aVar.f205795b + "").setExt6(aVar.a()));
    }

    @Override // com.tencent.mobileqq.faultreport.TrackerFilter.a
    public com.tencent.mobileqq.faultreport.a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.faultreport.a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        String h16 = k.a().h("wink_fault_tracker_info", null);
        try {
            if (!TextUtils.isEmpty(h16)) {
                com.tencent.mobileqq.faultreport.a aVar = new com.tencent.mobileqq.faultreport.a(h16);
                this.f205793a = aVar.f205795b;
                return aVar;
            }
        } catch (Exception e16) {
            QLog.e("FaultTracker.WinkReportFilter", 1, e16, new Object[0]);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.faultreport.TrackerFilter.a
    public boolean b(final com.tencent.mobileqq.faultreport.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar)).booleanValue();
        }
        if (aVar == null || !f205792b.contains(aVar.f205794a)) {
            return false;
        }
        final String str = aVar.f205799f.get("trace_id");
        if (TextUtils.isEmpty(str)) {
            QLog.d("FaultTracker.WinkReportFilter", 1, "report: traceId is empty");
            return false;
        }
        QLog.d("FaultTracker.WinkReportFilter", 1, "report: " + aVar);
        ((IThreadManagerApi) QRoute.api(IThreadManagerApi.class)).execute(new Runnable() { // from class: com.tencent.mobileqq.faultreport.TrackerFilter.d
            @Override // java.lang.Runnable
            public final void run() {
                e.g(str, aVar);
            }
        }, 128, null, false);
        k.a().p("wink_fault_tracker_info", "");
        this.f205793a = 0;
        return true;
    }

    @Override // com.tencent.mobileqq.faultreport.TrackerFilter.a
    public String c(com.tencent.mobileqq.faultreport.contextinfo.c cVar) {
        Fragment fragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) cVar);
        }
        try {
            if (cVar instanceof com.tencent.mobileqq.faultreport.contextinfo.a) {
                Activity activity = ((com.tencent.mobileqq.faultreport.contextinfo.a) cVar).f205801f.get();
                if (activity != null && activity.getIntent().hasExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID)) {
                    String stringExtra = activity.getIntent().getStringExtra(QQWinkConstants.ENTRY_BUSINESS_NAME);
                    if (TextUtils.isEmpty(stringExtra) || !f205792b.contains(stringExtra)) {
                        return "";
                    }
                    return stringExtra;
                }
            } else if ((cVar instanceof com.tencent.mobileqq.faultreport.contextinfo.b) && (fragment = ((com.tencent.mobileqq.faultreport.contextinfo.b) cVar).f205802f.get()) != null && fragment.getActivity() != null && fragment.getActivity().getIntent().hasExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID)) {
                String stringExtra2 = fragment.getActivity().getIntent().getStringExtra(QQWinkConstants.ENTRY_BUSINESS_NAME);
                if (!TextUtils.isEmpty(stringExtra2)) {
                    if (TextUtils.isEmpty(stringExtra2) || !f205792b.contains(stringExtra2)) {
                        return "";
                    }
                    return stringExtra2;
                }
                return stringExtra2;
            }
        } catch (Exception e16) {
            QLog.e("FaultTracker.WinkReportFilter", 1, e16, new Object[0]);
        }
        return "";
    }

    @Override // com.tencent.mobileqq.faultreport.TrackerFilter.a
    public boolean d(com.tencent.mobileqq.faultreport.a aVar, boolean z16) {
        boolean isInMultiWindowMode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, aVar, Boolean.valueOf(z16))).booleanValue();
        }
        if (aVar == null || !f205792b.contains(aVar.f205794a)) {
            return false;
        }
        com.tencent.mobileqq.faultreport.contextinfo.a aVar2 = aVar.f205797d;
        if (aVar2 != null) {
            Activity activity = aVar2.f205801f.get();
            if (Build.VERSION.SDK_INT >= 24 && activity != null) {
                isInMultiWindowMode = activity.isInMultiWindowMode();
                if (isInMultiWindowMode) {
                    return false;
                }
            }
        }
        String f16 = f(aVar);
        if (!TextUtils.isEmpty(f16)) {
            aVar.f205799f.put("trace_id", f16);
        } else {
            QLog.d("FaultTracker.WinkReportFilter", 1, "save: traceId is empty");
        }
        if (z16) {
            this.f205793a++;
            aVar.f205798e = null;
            aVar.f205797d = null;
        }
        aVar.f205795b = this.f205793a;
        QLog.d("FaultTracker.WinkReportFilter", 1, "save: " + aVar);
        k.a().p("wink_fault_tracker_info", aVar.toString());
        return true;
    }

    public String f(com.tencent.mobileqq.faultreport.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
        }
        if (aVar == null) {
            QLog.d("FaultTracker.WinkReportFilter", 1, "faultTrackerReportParam is null");
            return "";
        }
        Object obj = aVar.f205797d;
        if (obj == null) {
            obj = aVar.f205798e;
        }
        if (obj == null) {
            QLog.d("FaultTracker.WinkReportFilter", 1, "baseInfo is null");
            return "";
        }
        try {
            if (obj instanceof com.tencent.mobileqq.faultreport.contextinfo.a) {
                Activity activity = ((com.tencent.mobileqq.faultreport.contextinfo.a) obj).f205801f.get();
                if (activity != null && activity.getIntent().hasExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID)) {
                    return activity.getIntent().getStringExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID);
                }
            } else {
                Fragment fragment = ((com.tencent.mobileqq.faultreport.contextinfo.b) obj).f205802f.get();
                if (fragment != null && fragment.getActivity() != null && fragment.getActivity().getIntent().hasExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID)) {
                    return fragment.getActivity().getIntent().getStringExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID);
                }
            }
        } catch (Exception e16) {
            QLog.e("FaultTracker.WinkReportFilter", 1, e16, new Object[0]);
        }
        return "";
    }
}
