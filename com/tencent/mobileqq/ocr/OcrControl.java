package com.tencent.mobileqq.ocr;

import android.os.Handler;
import android.text.TextUtils;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.basics.motivevideo.report.GdtADFlyingStreamingReportHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.bc;
import com.tencent.mobileqq.app.bd;
import com.tencent.mobileqq.ar.arengine.m;
import com.tencent.mobileqq.ar.arengine.p;
import com.tencent.mobileqq.ar.arengine.q;
import com.tencent.mobileqq.msf.core.net.utils.MsfCmdConfig;
import com.tencent.mobileqq.ocr.api.IOCR;
import com.tencent.mobileqq.ocr.api.IOCRService;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;
import com.tencent.mobileqq.ocr.data.a;
import com.tencent.mobileqq.profilecard.vas.misc.VasProfileTemplatePreloadHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xweb.FileReaderHelper;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import v81.a;

/* compiled from: P */
/* loaded from: classes16.dex */
public class OcrControl {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name */
    public static final HashMap<String, String> f254571l;

    /* renamed from: a, reason: collision with root package name */
    private bd f254572a;

    /* renamed from: b, reason: collision with root package name */
    private bc f254573b;

    /* renamed from: c, reason: collision with root package name */
    private Object f254574c;

    /* renamed from: d, reason: collision with root package name */
    private a f254575d;

    /* renamed from: e, reason: collision with root package name */
    AppInterface f254576e;

    /* renamed from: f, reason: collision with root package name */
    v81.a f254577f;

    /* renamed from: g, reason: collision with root package name */
    HashMap<String, q> f254578g;

    /* renamed from: h, reason: collision with root package name */
    IOCRService f254579h;

    /* renamed from: i, reason: collision with root package name */
    Handler f254580i;

    /* renamed from: j, reason: collision with root package name */
    int f254581j;

    /* renamed from: k, reason: collision with root package name */
    a.c f254582k;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
        void a(int i3, OcrRecogResult ocrRecogResult, String str, long j3);

        void b();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73349);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        f254571l = hashMap;
        hashMap.put(OcrConfig.CHINESE, HardCodeUtil.qqStr(R.string.f172266ox3));
        hashMap.put("en", HardCodeUtil.qqStr(R.string.oxl));
        hashMap.put("af", HardCodeUtil.qqStr(R.string.oxp));
        hashMap.put("ar", HardCodeUtil.qqStr(R.string.owf));
        hashMap.put("eu", HardCodeUtil.qqStr(R.string.oxd));
        hashMap.put("be", HardCodeUtil.qqStr(R.string.owd));
        hashMap.put("hr", HardCodeUtil.qqStr(R.string.owk));
        hashMap.put("da", HardCodeUtil.qqStr(R.string.ow8));
        hashMap.put("nl", HardCodeUtil.qqStr(R.string.ox7));
        hashMap.put("fo", HardCodeUtil.qqStr(R.string.owx));
        hashMap.put("fi", HardCodeUtil.qqStr(R.string.owo));
        hashMap.put("fr", HardCodeUtil.qqStr(R.string.owh));
        hashMap.put("gd", HardCodeUtil.qqStr(R.string.oxj));
        hashMap.put("de", HardCodeUtil.qqStr(R.string.ow9));
        hashMap.put("he", HardCodeUtil.qqStr(R.string.f172265ox2));
        hashMap.put("hu", HardCodeUtil.qqStr(R.string.oxf));
        hashMap.put("id", HardCodeUtil.qqStr(R.string.owy));
        hashMap.put("it", HardCodeUtil.qqStr(R.string.owp));
        hashMap.put("kr", HardCodeUtil.qqStr(R.string.oxb));
        hashMap.put("lv", HardCodeUtil.qqStr(R.string.owr));
        hashMap.put("mk", HardCodeUtil.qqStr(R.string.oxn));
        hashMap.put("mt", HardCodeUtil.qqStr(R.string.owt));
        hashMap.put("no", HardCodeUtil.qqStr(R.string.owg));
        hashMap.put("pt", HardCodeUtil.qqStr(R.string.f172267ox4));
        hashMap.put(MsfCmdConfig.CMD_DELETE_FILE, HardCodeUtil.qqStr(R.string.own));
        hashMap.put("ro", HardCodeUtil.qqStr(R.string.owl));
        hashMap.put("sr", HardCodeUtil.qqStr(R.string.ox9));
        hashMap.put("sk", HardCodeUtil.qqStr(R.string.oxa));
        hashMap.put("sb", HardCodeUtil.qqStr(R.string.ow7));
        hashMap.put("es", HardCodeUtil.qqStr(R.string.owj));
        hashMap.put("sx", HardCodeUtil.qqStr(R.string.ows));
        hashMap.put(GdtADFlyingStreamingReportHelper.PARAM_KEY_SV, HardCodeUtil.qqStr(R.string.owu));
        hashMap.put("ts", HardCodeUtil.qqStr(R.string.owc));
        hashMap.put(ReportConstant.COSTREPORT_TRANS, HardCodeUtil.qqStr(R.string.f172264ox1));
        hashMap.put("ur", HardCodeUtil.qqStr(R.string.oxo));
        hashMap.put("vi", HardCodeUtil.qqStr(R.string.owa));
        hashMap.put(WidgetCacheLunarData.JI, HardCodeUtil.qqStr(R.string.f172262ow4));
        hashMap.put("sq", HardCodeUtil.qqStr(R.string.ow_));
        hashMap.put(VasProfileTemplatePreloadHelper.BACKGROUND, HardCodeUtil.qqStr(R.string.owi));
        hashMap.put("ca", HardCodeUtil.qqStr(R.string.owq));
        hashMap.put("cs", HardCodeUtil.qqStr(R.string.oxg));
        hashMap.put(FileReaderHelper.ET_EXT, HardCodeUtil.qqStr(R.string.oxe));
        hashMap.put("fa", HardCodeUtil.qqStr(R.string.oxc));
        hashMap.put("ga", HardCodeUtil.qqStr(R.string.ox_));
        hashMap.put("el", HardCodeUtil.qqStr(R.string.oxi));
        hashMap.put("hi", HardCodeUtil.qqStr(R.string.ox8));
        hashMap.put("is", HardCodeUtil.qqStr(R.string.ow6));
        hashMap.put("jp", HardCodeUtil.qqStr(R.string.oxm));
        hashMap.put("lt", HardCodeUtil.qqStr(R.string.owz));
        hashMap.put("ms", HardCodeUtil.qqStr(R.string.ow5));
        hashMap.put("pl", HardCodeUtil.qqStr(R.string.owe));
        hashMap.put("ru", HardCodeUtil.qqStr(R.string.owb));
        hashMap.put("sz", HardCodeUtil.qqStr(R.string.f172263ox0));
        hashMap.put("sl", HardCodeUtil.qqStr(R.string.ox6));
        hashMap.put("th", HardCodeUtil.qqStr(R.string.oww));
        hashMap.put("tn", HardCodeUtil.qqStr(R.string.oxh));
        hashMap.put("uk", HardCodeUtil.qqStr(R.string.owv));
        hashMap.put("ve", HardCodeUtil.qqStr(R.string.owm));
        hashMap.put("xh", HardCodeUtil.qqStr(R.string.oxk));
        hashMap.put("zu", HardCodeUtil.qqStr(R.string.ox5));
    }

    public OcrControl(AppInterface appInterface, a aVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appInterface, aVar, Integer.valueOf(i3));
            return;
        }
        this.f254574c = new Object();
        this.f254582k = new a.c() { // from class: com.tencent.mobileqq.ocr.OcrControl.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) OcrControl.this);
                }
            }

            @Override // v81.a.c
            public void a(int i16, String str, m mVar) {
                long j3;
                int i17;
                com.tencent.mobileqq.ocr.data.a aVar2;
                int i18;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i16), str, mVar);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("Q.ocr.control", 2, "retCode:" + i16 + ",sessionId:" + str + ",recogResult:" + mVar);
                }
                q h16 = OcrControl.this.h(str);
                if (h16 != null) {
                    j3 = System.currentTimeMillis() - h16.f198256q;
                } else {
                    j3 = 0;
                }
                long j16 = j3;
                int i19 = -1;
                if (h16 != null && h16.f198241b != null) {
                    if (i16 == 0 && mVar != null && (aVar2 = mVar.f198209g) != null) {
                        OcrRecogResult a16 = aVar2.a();
                        if (OcrControl.this.f254575d != null) {
                            OcrControl.this.f254575d.a(0, a16, h16.f198241b.f198239e, j16);
                        }
                        if (a16 != null && ((i18 = OcrControl.this.f254581j) == 1 || i18 == 2)) {
                            ThreadManagerV2.postImmediately(new Runnable(a16, h16) { // from class: com.tencent.mobileqq.ocr.OcrControl.5.1
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ OcrRecogResult f254591d;

                                /* renamed from: e, reason: collision with root package name */
                                final /* synthetic */ q f254592e;

                                {
                                    this.f254591d = a16;
                                    this.f254592e = h16;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, this, AnonymousClass5.this, a16, h16);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                    } else if (OcrControl.this.f254579h != null) {
                                        this.f254591d.filename = this.f254592e.f198241b.f198239e;
                                    }
                                }
                            }, null, false);
                        }
                        a.C8173a c8173a = aVar2.f254733a;
                        if (c8173a != null) {
                            i19 = c8173a.f254734a;
                            i17 = c8173a.f254736c;
                            ThreadManagerV2.postImmediately(new Runnable(h16) { // from class: com.tencent.mobileqq.ocr.OcrControl.5.2
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ q f254594d;

                                {
                                    this.f254594d = h16;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass5.this, (Object) h16);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    String str2 = this.f254594d.f198241b.f198235a;
                                    if (((IOCR) QRoute.api(IOCR.class)).getImageUtilOCRPATH().equals(new File(str2).getParent())) {
                                        FileUtils.deleteFile(str2);
                                        if (QLog.isColorLevel()) {
                                            QLog.d("Q.ocr.control", 2, "delete pic path:" + str2);
                                        }
                                    }
                                }
                            }, null, false);
                        }
                    } else if (OcrControl.this.f254575d != null) {
                        OcrControl.this.f254575d.a(3, null, h16.f198241b.f198239e, j16);
                    }
                    i17 = -1;
                    ThreadManagerV2.postImmediately(new Runnable(h16) { // from class: com.tencent.mobileqq.ocr.OcrControl.5.2
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ q f254594d;

                        {
                            this.f254594d = h16;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass5.this, (Object) h16);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            String str2 = this.f254594d.f198241b.f198235a;
                            if (((IOCR) QRoute.api(IOCR.class)).getImageUtilOCRPATH().equals(new File(str2).getParent())) {
                                FileUtils.deleteFile(str2);
                                if (QLog.isColorLevel()) {
                                    QLog.d("Q.ocr.control", 2, "delete pic path:" + str2);
                                }
                            }
                        }
                    }, null, false);
                } else {
                    i17 = -1;
                }
                ThreadManagerV2.post(new Runnable(i19, i17, i16) { // from class: com.tencent.mobileqq.ocr.OcrControl.5.3
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ int f254596d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ int f254597e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ int f254598f;

                    {
                        this.f254596d = i19;
                        this.f254597e = i17;
                        this.f254598f = i16;
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, this, AnonymousClass5.this, Integer.valueOf(i19), Integer.valueOf(i17), Integer.valueOf(i16));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                            return;
                        }
                        HashMap<String, String> hashMap = new HashMap<>();
                        hashMap.put("ocr_sso_code", String.valueOf(this.f254596d));
                        hashMap.put("ocr_code", String.valueOf(this.f254597e));
                        hashMap.put("ret_code", String.valueOf(this.f254598f));
                        try {
                            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "ocr_server_fail", true, 0L, 0L, hashMap, "", false);
                        } catch (Exception e16) {
                            e16.printStackTrace();
                            QLog.d("Q.ocr.control", 1, "collectPerformance exception: " + e16.getMessage());
                        }
                    }
                }, 5, null, false);
            }
        };
        this.f254576e = appInterface;
        this.f254575d = aVar;
        v81.a aVar2 = new v81.a(appInterface);
        this.f254577f = aVar2;
        aVar2.l();
        this.f254578g = new HashMap<>();
        this.f254579h = (IOCRService) this.f254576e.getRuntimeService(IOCRService.class, "");
        this.f254580i = new Handler();
        this.f254581j = i3;
    }

    private synchronized void c(q qVar) {
        synchronized (this.f254578g) {
            if (qVar != null) {
                if (!TextUtils.isEmpty(qVar.f198240a)) {
                    this.f254578g.put(qVar.f198240a, qVar);
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.ocr.control", 2, "add  req , sessionId:" + qVar.f198240a);
                    }
                }
            }
        }
    }

    private void e(Runnable runnable) {
        synchronized (this.f254574c) {
            bc bcVar = this.f254573b;
            if (bcVar != null) {
                bcVar.post(runnable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public q h(String str) {
        q qVar;
        synchronized (this.f254578g) {
            if (!TextUtils.isEmpty(str)) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.ocr.control", 2, "req had been remove, sessionId:" + str);
                }
                qVar = this.f254578g.remove(str);
            } else {
                qVar = null;
            }
        }
        return qVar;
    }

    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return String.format("%s_%s_%05d", this.f254576e.getCurrentAccountUin(), new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(System.currentTimeMillis())), Integer.valueOf(new Random().nextInt(100000)));
    }

    public void f(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16));
        } else {
            g(str, z16, null);
        }
    }

    public void g(String str, boolean z16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Boolean.valueOf(z16), str2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.ocr.control", 2, "recogPic picPath:" + str + ",needCompress:" + z16);
        }
        e(new Runnable(str, z16, str2) { // from class: com.tencent.mobileqq.ocr.OcrControl.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f254583d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ boolean f254584e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f254585f;

            {
                this.f254583d = str;
                this.f254584e = z16;
                this.f254585f = str2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, OcrControl.this, str, Boolean.valueOf(z16), str2);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (((IOCR) QRoute.api(IOCR.class)).checkImageFormat(this.f254583d)) {
                    String imagePath = ((IOCR) QRoute.api(IOCR.class)).getImagePath(new File(this.f254583d).getName(), false);
                    if (this.f254584e && ((IOCR) QRoute.api(IOCR.class)).compressImage(this.f254583d, imagePath)) {
                        p pVar = new p();
                        pVar.f198235a = imagePath;
                        pVar.f198236b = 0;
                        pVar.f198239e = this.f254583d;
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.ocr.control", 2, "upload pic size:" + (new File(imagePath).length() / 1024) + "KB");
                        }
                        OcrControl.this.j(pVar, this.f254585f);
                        return;
                    }
                    p pVar2 = new p();
                    String str3 = this.f254583d;
                    pVar2.f198235a = str3;
                    pVar2.f198236b = 0;
                    pVar2.f198239e = str3;
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.ocr.control", 2, "upload pic size:" + (new File(this.f254583d).length() / 1024) + "KB");
                    }
                    OcrControl.this.j(pVar2, this.f254585f);
                    return;
                }
                if (OcrControl.this.f254575d != null) {
                    OcrControl.this.f254575d.a(1, null, this.f254583d, 0L);
                }
            }
        });
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        k();
        if (QLog.isColorLevel()) {
            QLog.d("Q.ocr.control", 2, "Ocr control start");
        }
    }

    public synchronized void j(p pVar, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) pVar, (Object) str);
            return;
        }
        q qVar = new q();
        qVar.f198240a = d();
        qVar.f198241b = pVar;
        qVar.f198243d = 900000000;
        qVar.f198242c = 900000000;
        qVar.f198244e = 16L;
        qVar.f198245f = 0;
        qVar.f198254o = String.valueOf(this.f254576e.getAppid());
        qVar.f198255p = Long.parseLong(this.f254576e.getCurrentAccountUin());
        qVar.f198256q = System.currentTimeMillis();
        com.tencent.mobileqq.ocr.a aVar = new com.tencent.mobileqq.ocr.a();
        if (!TextUtils.isEmpty(str)) {
            aVar.f254625a = str;
        }
        qVar.f198252m = aVar;
        c(qVar);
        String str2 = qVar.f198240a;
        this.f254580i.postDelayed(new Runnable(str2) { // from class: com.tencent.mobileqq.ocr.OcrControl.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f254586d;

            {
                this.f254586d = str2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) OcrControl.this, (Object) str2);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else if (OcrControl.this.f254578g.get(this.f254586d) != null && OcrControl.this.f254575d != null) {
                    OcrControl.this.f254575d.b();
                }
            }
        }, 3000L);
        if (this.f254577f.n(qVar, this.f254582k)) {
            this.f254580i.postDelayed(new Runnable(str2, pVar) { // from class: com.tencent.mobileqq.ocr.OcrControl.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f254587d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ p f254588e;

                {
                    this.f254587d = str2;
                    this.f254588e = pVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, OcrControl.this, str2, pVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        q h16 = OcrControl.this.h(this.f254587d);
                        if (h16 != null && OcrControl.this.f254575d != null) {
                            OcrControl.this.f254575d.a(4, null, this.f254588e.f198239e, System.currentTimeMillis() - h16.f198256q);
                            return;
                        }
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }, 30000L);
        } else {
            this.f254575d.a(3, null, pVar.f198239e, 0L);
        }
        ThreadManagerV2.post(new Runnable(pVar) { // from class: com.tencent.mobileqq.ocr.OcrControl.4
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ p f254589d;

            {
                this.f254589d = pVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) OcrControl.this, (Object) pVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                long length = new File(this.f254589d.f198235a).length() / 1024;
                long length2 = new File(this.f254589d.f198239e).length() / 1024;
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("ocrFilesize", String.valueOf(length));
                hashMap.put("previewFilesize", String.valueOf(length2));
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "ocr_pic_size", true, 0L, 0L, hashMap, "", false);
            }
        }, 5, null, false);
    }

    public synchronized void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        QLog.i("Q.ocr.control", 1, "startUploadThread.");
        if (this.f254572a == null) {
            bd newHandlerRecycleThread = ThreadManagerV2.newHandlerRecycleThread("ocr_upload_thread" + System.currentTimeMillis(), 0);
            this.f254572a = newHandlerRecycleThread;
            this.f254573b = newHandlerRecycleThread.b();
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        n();
        v81.a aVar = this.f254577f;
        if (aVar != null) {
            aVar.e();
        }
        HashMap<String, q> hashMap = this.f254578g;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f254580i.removeCallbacksAndMessages(null);
        if (QLog.isColorLevel()) {
            QLog.d("Q.ocr.control", 2, "Ocr control stop");
        }
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        synchronized (this.f254578g) {
            this.f254578g.clear();
            v81.a aVar = this.f254577f;
            if (aVar != null) {
                aVar.e();
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.ocr.control", 2, "stopRecog...");
            }
        }
    }

    public synchronized void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        QLog.i("Q.ocr.control", 1, "stopUploadThread.");
        bc bcVar = this.f254573b;
        if (bcVar != null) {
            bcVar.removeCallbacksAndMessages(null);
        }
        this.f254573b = null;
        this.f254572a = null;
    }
}
