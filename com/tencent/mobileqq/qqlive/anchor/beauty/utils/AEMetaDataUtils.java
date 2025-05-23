package com.tencent.mobileqq.qqlive.anchor.beauty.utils;

import android.net.TrafficStats;
import com.tencent.aelight.camera.download.api.IAEDownloadMaterial;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.utils.g;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qcircle.weishi.module.publisher.entity.TemplateBean;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes17.dex */
public class AEMetaDataUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static int f270536a;

    /* renamed from: b, reason: collision with root package name */
    private static int f270537b;

    /* renamed from: c, reason: collision with root package name */
    private static int f270538c;

    /* renamed from: d, reason: collision with root package name */
    private static Map<String, AEMaterialMetaData> f270539d;

    /* renamed from: e, reason: collision with root package name */
    private static Map<String, AEMaterialMetaData> f270540e;

    /* renamed from: f, reason: collision with root package name */
    private static volatile boolean f270541f;

    /* renamed from: g, reason: collision with root package name */
    private static volatile boolean f270542g;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface a {
        void a(AEMaterialMetaData aEMaterialMetaData, int i3);

        void b(AEMaterialMetaData aEMaterialMetaData, int i3);

        void c(AEMaterialMetaData aEMaterialMetaData, String str);

        void onDownloadStart();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55156);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f270536a = -1;
        f270537b = -2;
        f270538c = 200;
        f270539d = new HashMap();
        f270540e = new HashMap();
        f270541f = false;
        f270542g = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String h(String str, String str2) {
        return str + str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String i(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static void j(String str, String str2, a aVar) {
        AEMaterialMetaData aEMaterialMetaData;
        if (f270540e.containsKey(str)) {
            aEMaterialMetaData = f270540e.get(str);
        } else {
            AEMaterialMetaData aEMaterialMetaData2 = new AEMaterialMetaData();
            aEMaterialMetaData2.f69050id = str;
            aEMaterialMetaData2.name = str;
            aEMaterialMetaData2.resurl = str2;
            f270540e.put(str, aEMaterialMetaData2);
            aEMaterialMetaData = aEMaterialMetaData2;
        }
        String i3 = i(aEMaterialMetaData.getLocalPath(), aEMaterialMetaData.f69050id, ".png");
        if (new File(i3).exists()) {
            aVar.c(aEMaterialMetaData, i3);
        } else {
            m(aEMaterialMetaData, aVar);
        }
    }

    public static void k(String str, String str2, a aVar) {
        AEMaterialMetaData aEMaterialMetaData;
        if (f270539d.containsKey(str)) {
            aEMaterialMetaData = f270539d.get(str);
        } else {
            AEMaterialMetaData aEMaterialMetaData2 = new AEMaterialMetaData();
            aEMaterialMetaData2.f69050id = str;
            aEMaterialMetaData2.name = str;
            aEMaterialMetaData2.resurl = str2;
            f270539d.put(str, aEMaterialMetaData2);
            aEMaterialMetaData = aEMaterialMetaData2;
        }
        String h16 = h(aEMaterialMetaData.getLocalPath(), TemplateBean.TEMPLATE_JSON);
        if (new File(h16).exists()) {
            aVar.c(aEMaterialMetaData, h16);
        } else {
            n(aEMaterialMetaData, aVar);
        }
    }

    public static void l(com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a aVar, a aVar2) {
        AEMaterialMetaData aEMaterialMetaData;
        if (f270539d.containsKey(aVar.f270491a)) {
            aEMaterialMetaData = f270539d.get(aVar.f270491a);
        } else {
            AEMaterialMetaData aEMaterialMetaData2 = new AEMaterialMetaData();
            String str = aVar.f270491a;
            aEMaterialMetaData2.f69050id = str;
            aEMaterialMetaData2.name = str;
            aEMaterialMetaData2.resurl = aVar.f270497g;
            aEMaterialMetaData2.md5 = aVar.f270498h;
            f270539d.put(str, aEMaterialMetaData2);
            aEMaterialMetaData = aEMaterialMetaData2;
        }
        String h16 = h(aEMaterialMetaData.getLocalPath(), TemplateBean.TEMPLATE_JSON);
        if (new File(h16).exists()) {
            aVar2.c(aEMaterialMetaData, h16);
        } else {
            n(aEMaterialMetaData, aVar2);
        }
    }

    private static void m(AEMaterialMetaData aEMaterialMetaData, a aVar) {
        if (f270542g || aEMaterialMetaData == null) {
            return;
        }
        f270542g = true;
        aVar.onDownloadStart();
        ThreadManagerV2.excute(new Runnable(aVar) { // from class: com.tencent.mobileqq.qqlive.anchor.beauty.utils.AEMetaDataUtils.2
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ a f270547e;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.qqlive.anchor.beauty.utils.AEMetaDataUtils$2$a */
            /* loaded from: classes17.dex */
            class a implements com.tencent.aelight.camera.download.a {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                    }
                }

                @Override // com.tencent.aelight.camera.download.a
                public void onDownloadFinish(AEMaterialMetaData aEMaterialMetaData, boolean z16, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, aEMaterialMetaData, Boolean.valueOf(z16), Integer.valueOf(i3));
                        return;
                    }
                    if (aEMaterialMetaData == null) {
                        AnonymousClass2.this.f270547e.b(aEMaterialMetaData, i3);
                        AEMetaDataUtils.f270542g = false;
                        return;
                    }
                    if (i3 != AEMetaDataUtils.f270538c) {
                        AnonymousClass2.this.f270547e.b(aEMaterialMetaData, i3);
                        AEMetaDataUtils.f270542g = false;
                        return;
                    }
                    if (!new File(aEMaterialMetaData.getLocalPath(), aEMaterialMetaData.f69050id + ".png").exists()) {
                        if (!new File(aEMaterialMetaData.getLocalZipPath()).exists()) {
                            AnonymousClass2.this.f270547e.b(aEMaterialMetaData, AEMetaDataUtils.f270537b);
                            AEMetaDataUtils.f270542g = false;
                            return;
                        }
                        if (!AEMaterialMetaData.this.unZipFile() && QLog.isColorLevel()) {
                            QLog.e("AEMetaDataUtils", 2, "judgeTemplateUsable unZipFile fail");
                        }
                        if (new File(aEMaterialMetaData.getLocalPath(), aEMaterialMetaData.f69050id + ".png").exists()) {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            a aVar = anonymousClass2.f270547e;
                            AEMaterialMetaData aEMaterialMetaData2 = AEMaterialMetaData.this;
                            aVar.c(aEMaterialMetaData2, AEMetaDataUtils.i(aEMaterialMetaData2.getLocalPath(), AEMaterialMetaData.this.f69050id, ".png"));
                        }
                    } else {
                        AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                        a aVar2 = anonymousClass22.f270547e;
                        AEMaterialMetaData aEMaterialMetaData3 = AEMaterialMetaData.this;
                        aVar2.c(aEMaterialMetaData3, AEMetaDataUtils.i(aEMaterialMetaData3.getLocalPath(), AEMaterialMetaData.this.f69050id, ".png"));
                    }
                    AEMetaDataUtils.f270542g = false;
                }

                @Override // com.tencent.aelight.camera.download.a
                public void onProgressUpdate(AEMaterialMetaData aEMaterialMetaData, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, (Object) aEMaterialMetaData, i3);
                        return;
                    }
                    QLog.i("AEMetaDataUtils", 1, String.format("startDownloadMaterial onProgressUpdate. progress:" + i3, new Object[0]));
                    AnonymousClass2.this.f270547e.a(aEMaterialMetaData, i3);
                }
            }

            {
                this.f270547e = aVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AEMaterialMetaData.this, (Object) aVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                IAEDownloadMaterial iAEDownloadMaterial = (IAEDownloadMaterial) QRoute.api(IAEDownloadMaterial.class);
                AppInterface a16 = g.a();
                AEMaterialMetaData aEMaterialMetaData2 = AEMaterialMetaData.this;
                iAEDownloadMaterial.startDownloadMaterial(a16, aEMaterialMetaData2, aEMaterialMetaData2.getZipDownloadPath(), new a());
            }
        }, 128, null, true);
    }

    private static void n(AEMaterialMetaData aEMaterialMetaData, a aVar) {
        if (f270541f || aEMaterialMetaData == null) {
            return;
        }
        f270541f = true;
        aVar.onDownloadStart();
        ThreadManagerV2.excute(new Runnable(aVar) { // from class: com.tencent.mobileqq.qqlive.anchor.beauty.utils.AEMetaDataUtils.1
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ a f270544e;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.qqlive.anchor.beauty.utils.AEMetaDataUtils$1$a */
            /* loaded from: classes17.dex */
            class a implements com.tencent.aelight.camera.download.a {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                    }
                }

                @Override // com.tencent.aelight.camera.download.a
                public void onDownloadFinish(AEMaterialMetaData aEMaterialMetaData, boolean z16, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, aEMaterialMetaData, Boolean.valueOf(z16), Integer.valueOf(i3));
                        return;
                    }
                    if (aEMaterialMetaData == null) {
                        AnonymousClass1.this.f270544e.b(aEMaterialMetaData, i3);
                        AEMetaDataUtils.f270541f = false;
                        return;
                    }
                    if (i3 != AEMetaDataUtils.f270538c) {
                        AnonymousClass1.this.f270544e.b(aEMaterialMetaData, i3);
                        AEMetaDataUtils.f270541f = false;
                        return;
                    }
                    if (!z16) {
                        AnonymousClass1.this.f270544e.b(aEMaterialMetaData, AEMetaDataUtils.f270536a);
                        AEMetaDataUtils.f270541f = false;
                        return;
                    }
                    if (!new File(aEMaterialMetaData.getLocalPath(), TemplateBean.TEMPLATE_JSON).exists()) {
                        if (!new File(aEMaterialMetaData.getLocalZipPath()).exists()) {
                            AnonymousClass1.this.f270544e.b(aEMaterialMetaData, AEMetaDataUtils.f270537b);
                            AEMetaDataUtils.f270541f = false;
                            return;
                        }
                        if (!AEMaterialMetaData.this.unZipFile() && QLog.isColorLevel()) {
                            QLog.e("AEMetaDataUtils", 2, "judgeTemplateUsable unZipFile fail");
                        }
                        if (new File(aEMaterialMetaData.getLocalPath(), TemplateBean.TEMPLATE_JSON).exists()) {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            a aVar = anonymousClass1.f270544e;
                            AEMaterialMetaData aEMaterialMetaData2 = AEMaterialMetaData.this;
                            aVar.c(aEMaterialMetaData2, AEMetaDataUtils.h(aEMaterialMetaData2.getLocalPath(), TemplateBean.TEMPLATE_JSON));
                        }
                    } else {
                        AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                        a aVar2 = anonymousClass12.f270544e;
                        AEMaterialMetaData aEMaterialMetaData3 = AEMaterialMetaData.this;
                        aVar2.c(aEMaterialMetaData3, AEMetaDataUtils.h(aEMaterialMetaData3.getLocalPath(), TemplateBean.TEMPLATE_JSON));
                    }
                    AEMetaDataUtils.f270541f = false;
                }

                @Override // com.tencent.aelight.camera.download.a
                public void onProgressUpdate(AEMaterialMetaData aEMaterialMetaData, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, (Object) aEMaterialMetaData, i3);
                        return;
                    }
                    QLog.i("AEMetaDataUtils", 1, String.format("startDownloadMaterial onProgressUpdate. progress:" + i3, new Object[0]));
                    AnonymousClass1.this.f270544e.a(aEMaterialMetaData, i3);
                }
            }

            {
                this.f270544e = aVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AEMaterialMetaData.this, (Object) aVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                TrafficStats.setThreadStatsTag(-255);
                IAEDownloadMaterial iAEDownloadMaterial = (IAEDownloadMaterial) QRoute.api(IAEDownloadMaterial.class);
                AppInterface a16 = g.a();
                AEMaterialMetaData aEMaterialMetaData2 = AEMaterialMetaData.this;
                iAEDownloadMaterial.startDownloadMaterial(a16, aEMaterialMetaData2, aEMaterialMetaData2.getZipDownloadPath(), new a());
            }
        }, 128, null, true);
    }

    public static Boolean o(String str, String str2) {
        AEMaterialMetaData aEMaterialMetaData;
        if (f270540e.containsKey(str)) {
            aEMaterialMetaData = f270540e.get(str);
        } else {
            AEMaterialMetaData aEMaterialMetaData2 = new AEMaterialMetaData();
            aEMaterialMetaData2.f69050id = str;
            aEMaterialMetaData2.name = str;
            aEMaterialMetaData2.resurl = str2;
            f270540e.put(str, aEMaterialMetaData2);
            aEMaterialMetaData = aEMaterialMetaData2;
        }
        return Boolean.valueOf(new File(i(aEMaterialMetaData.getLocalPath(), aEMaterialMetaData.f69050id, ".png")).exists());
    }

    public static Boolean p(String str, String str2) {
        return q(str, str2, null);
    }

    public static Boolean q(String str, String str2, String str3) {
        AEMaterialMetaData aEMaterialMetaData;
        if (f270539d.containsKey(str)) {
            aEMaterialMetaData = f270539d.get(str);
        } else {
            AEMaterialMetaData aEMaterialMetaData2 = new AEMaterialMetaData();
            aEMaterialMetaData2.f69050id = str;
            aEMaterialMetaData2.name = str;
            aEMaterialMetaData2.resurl = str2;
            aEMaterialMetaData2.md5 = str3;
            f270539d.put(str, aEMaterialMetaData2);
            aEMaterialMetaData = aEMaterialMetaData2;
        }
        return Boolean.valueOf(new File(h(aEMaterialMetaData.getLocalPath(), TemplateBean.TEMPLATE_JSON)).exists());
    }
}
