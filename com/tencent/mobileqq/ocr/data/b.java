package com.tencent.mobileqq.ocr.data;

import android.text.TextUtils;
import com.tencent.mobileqq.dpc.DPCObserver;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name */
    private static final String f254742k;

    /* renamed from: l, reason: collision with root package name */
    public static b f254743l;

    /* renamed from: m, reason: collision with root package name */
    public static DPCObserver f254744m;

    /* renamed from: a, reason: collision with root package name */
    public String f254745a;

    /* renamed from: b, reason: collision with root package name */
    public int f254746b;

    /* renamed from: c, reason: collision with root package name */
    public int f254747c;

    /* renamed from: d, reason: collision with root package name */
    public int f254748d;

    /* renamed from: e, reason: collision with root package name */
    public int f254749e;

    /* renamed from: f, reason: collision with root package name */
    public int f254750f;

    /* renamed from: g, reason: collision with root package name */
    public int f254751g;

    /* renamed from: h, reason: collision with root package name */
    public int f254752h;

    /* renamed from: i, reason: collision with root package name */
    public int f254753i;

    /* renamed from: j, reason: collision with root package name */
    public int f254754j;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements DPCObserver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.dpc.DPCObserver
        public void onDpcPullFinished(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            if (z16) {
                b.b();
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.ocr.dpc", 2, "onDpcPullFinished, hasChanged=" + z16);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32265);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f254742k = DPCNames.ocrCfg.name();
            f254744m = new a();
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f254746b = 1;
        this.f254747c = 70;
        this.f254748d = 800;
        this.f254749e = 1080;
        this.f254750f = 1920;
        this.f254751g = 100;
        this.f254752h = 6;
        this.f254753i = 140;
        this.f254754j = 100;
        ((IDPCApi) QRoute.api(IDPCApi.class)).addObserver(f254744m);
    }

    public static b a() {
        b bVar = f254743l;
        if (bVar != null) {
            return bVar;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.ocr.dpc", 2, "get ocrDpc is null");
        }
        b();
        return f254743l;
    }

    public static synchronized void b() {
        synchronized (b.class) {
            String featureValueWithoutAccountManager = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(f254742k);
            b bVar = new b();
            f254743l = bVar;
            bVar.f254745a = featureValueWithoutAccountManager;
            if (!TextUtils.isEmpty(featureValueWithoutAccountManager)) {
                String[] split = featureValueWithoutAccountManager.split("\\|");
                if (split.length >= 9) {
                    try {
                        f254743l.f254746b = Integer.valueOf(split[0]).intValue();
                        f254743l.f254747c = Integer.valueOf(split[1]).intValue();
                        f254743l.f254748d = Integer.valueOf(split[2]).intValue();
                        f254743l.f254749e = Integer.valueOf(split[3]).intValue();
                        f254743l.f254750f = Integer.valueOf(split[4]).intValue();
                        f254743l.f254751g = Integer.valueOf(split[5]).intValue();
                        f254743l.f254752h = Integer.valueOf(split[6]).intValue();
                        f254743l.f254753i = Integer.valueOf(split[7]).intValue();
                        f254743l.f254754j = Integer.valueOf(split[8]).intValue();
                    } catch (Exception e16) {
                        QLog.d("Q.ocr.dpc", 1, "load exp:" + e16.getMessage());
                        b bVar2 = f254743l;
                        bVar2.f254747c = 70;
                        bVar2.f254748d = 800;
                        bVar2.f254749e = 1080;
                        bVar2.f254750f = 1920;
                        bVar2.f254751g = 100;
                        bVar2.f254752h = 6;
                        bVar2.f254753i = 140;
                        bVar2.f254754j = 100;
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.ocr.dpc", 2, "load ocrDpc:" + f254743l);
            }
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return "ocrSwitch:" + this.f254746b + ",picQuality:" + this.f254747c + ",picShortestSide:" + this.f254748d + ",maxPreviewWidth:" + this.f254749e + ",maxPreviewHeight:" + this.f254750f + "," + this.f254751g + "," + this.f254752h + "," + this.f254753i + "," + this.f254754j;
    }
}
