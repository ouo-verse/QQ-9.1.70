package com.tencent.mobileqq.app;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.HashMap;
import java.util.Map;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes11.dex */
public class NearbyFlowerManager implements Manager {
    static IPatchRedirector $redirector_;
    public static final String F;
    public static final String G;
    public static final String H;
    public static int I;
    public static int J;
    public Handler C;
    Map<String, Long> D;
    Map<String, Long> E;

    /* renamed from: d, reason: collision with root package name */
    public QQAppInterface f194867d;

    /* renamed from: e, reason: collision with root package name */
    public String f194868e;

    /* renamed from: f, reason: collision with root package name */
    public String f194869f;

    /* renamed from: h, reason: collision with root package name */
    public String f194870h;

    /* renamed from: i, reason: collision with root package name */
    public String f194871i;

    /* renamed from: m, reason: collision with root package name */
    public int f194872m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69834);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
            return;
        }
        F = HardCodeUtil.qqStr(R.string.ofk);
        G = HardCodeUtil.qqStr(R.string.ofs);
        H = HardCodeUtil.qqStr(R.string.ofn);
        I = 0;
        J = 60;
    }

    public NearbyFlowerManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f194872m = 0;
        this.D = new HashMap();
        this.E = new HashMap();
        this.f194867d = qQAppInterface;
        this.C = new Handler(Looper.getMainLooper());
        b();
    }

    public static void a(QQAppInterface qQAppInterface, String str) {
        ThreadManagerV2.postImmediately(new Runnable(str) { // from class: com.tencent.mobileqq.app.NearbyFlowerManager.1
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f194874e;

            {
                this.f194874e = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQAppInterface.this, (Object) str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                QQAppInterface qQAppInterface2 = QQAppInterface.this;
                if (qQAppInterface2 == null) {
                    return;
                }
                String str2 = this.f194874e;
                ReportController.n(qQAppInterface2, "CliOper", "", "", str2, str2, 0, 1, 0, "", "", "", "");
            }
        }, null, true);
    }

    private void b() {
        this.f194868e = (String) ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getValue(this.f194867d.getAccount(), "sp_file_nearby_flower_tip", 0, "senderGrayTip", F);
        this.f194869f = (String) ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getValue(this.f194867d.getAccount(), "sp_file_nearby_flower_tip", 0, "receiverGrayTip", "Ta\u9001\u4e86\u4f60XX\u6735YY\uff0c\u5feb\u548cTa\u8bf4\u58f0\u8c22\u8c22\u5427\u3002");
        this.f194870h = (String) ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getValue(this.f194867d.getAccount(), "sp_file_nearby_flower_tip", 0, "exchangeGrayTip", G);
        this.f194871i = (String) ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getValue(this.f194867d.getAccount(), "sp_file_nearby_flower_tip", 0, "exchangeHighLight", H);
        I = ((Integer) ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getValue(this.f194867d.getAccount(), "sp_file_nearby_flower_tip", 0, "openFlag", Integer.valueOf(I))).intValue();
        this.f194872m = ((Integer) ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getValue(this.f194867d.getAccount(), "sp_file_nearby_flower_tip", 0, "scoreThreshold", 0)).intValue();
    }

    public static void c(String str, String str2, String str3, String str4, String str5, String str6) {
        ReportController.o(null, "dc00899", "grp_lbs", "", str, str2, 0, 0, str3, str4, str5, str6);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.C.removeCallbacksAndMessages(null);
        }
    }
}
