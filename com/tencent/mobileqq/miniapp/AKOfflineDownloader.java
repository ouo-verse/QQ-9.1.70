package com.tencent.mobileqq.miniapp;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.h;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public class AKOfflineDownloader extends b {
    static IPatchRedirector $redirector_;

    public AKOfflineDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(boolean z16, String str, String str2, int i3, String str3, Object obj) {
        int i16;
        c cVar = new c();
        if ("MiniAppLauncher".equals(str2)) {
            i16 = 1;
        } else {
            i16 = 5;
        }
        cVar.f246789h = i16;
        cVar.f246788f = z16;
        cVar.f246790i = str2;
        if (z16) {
            cVar.f246791m = new Object[]{str, obj, Integer.valueOf(i3), e(str3, "")};
        } else {
            cVar.f246791m = new Object[]{str, obj, Integer.valueOf(i3)};
        }
        if (cVar.f246789h == 1) {
            com.tencent.biz.qqstory.base.c.a().dispatch("MiniAppManager", cVar);
        } else {
            com.tencent.biz.qqstory.base.c.a().dispatch(cVar);
        }
    }

    public static String e(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return com.tencent.biz.common.offline.c.c(str) + str;
        }
        return com.tencent.biz.common.offline.c.c(str) + str + File.separator + str2;
    }

    @Override // com.tencent.mobileqq.miniapp.b
    public void a(String str, String str2, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, obj);
            return;
        }
        String substring = str.substring(3);
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime == null) {
            d(false, str, str2, -1, substring, obj);
        } else {
            HtmlOffline.k(substring, runtime, new com.tencent.biz.common.offline.a(substring, str, str2, obj, System.currentTimeMillis()) { // from class: com.tencent.mobileqq.miniapp.AKOfflineDownloader.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f246772d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f246773e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f246774f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ Object f246775h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ long f246776i;

                {
                    this.f246772d = substring;
                    this.f246773e = str;
                    this.f246774f = str2;
                    this.f246775h = obj;
                    this.f246776i = r10;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, AKOfflineDownloader.this, substring, str, str2, obj, Long.valueOf(r10));
                    }
                }

                @Override // com.tencent.biz.common.offline.a
                public void loaded(String str3, int i3) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) str3, i3);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("AKOfflineDownloader", 2, "checkUpByBusinessId loaded, code:" + i3 + ", param :" + str3);
                    }
                    if (i3 != 0) {
                        AKOfflineDownloader.d(false, this.f246773e, this.f246774f, -1, this.f246772d, this.f246775h);
                        return;
                    }
                    if (str3 == null) {
                        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.miniapp.AKOfflineDownloader.1.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                    return;
                                }
                                Bundle bundle = new Bundle();
                                bundle.putString("bid", AnonymousClass1.this.f246772d);
                                bundle.putString("path", AKOfflineDownloader.e(AnonymousClass1.this.f246772d, ""));
                                boolean f16 = AKOfflineDownloader.this.f(bundle);
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                AKOfflineDownloader.d(f16, anonymousClass1.f246773e, anonymousClass1.f246774f, 1, anonymousClass1.f246772d, anonymousClass1.f246775h);
                                QLog.d("AKOfflineDownloader", 2, " checkUpByBusinessId load success. param null. cost=", Long.valueOf(System.currentTimeMillis() - AnonymousClass1.this.f246776i));
                            }
                        }, 64, null, true);
                    } else if (str3.contains("url")) {
                        AKOfflineDownloader.d(true, this.f246773e, this.f246774f, 2, this.f246772d, this.f246775h);
                        QLog.d("AKOfflineDownloader", 2, "checkUpByBusinessId load success. contains url. cost=", Long.valueOf(System.currentTimeMillis() - this.f246776i));
                    } else {
                        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.miniapp.AKOfflineDownloader.1.2
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                    return;
                                }
                                Bundle bundle = new Bundle();
                                bundle.putString("bid", AnonymousClass1.this.f246772d);
                                bundle.putString("path", AKOfflineDownloader.e(AnonymousClass1.this.f246772d, ""));
                                boolean f16 = AKOfflineDownloader.this.f(bundle);
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                AKOfflineDownloader.d(f16, anonymousClass1.f246773e, anonymousClass1.f246774f, 3, anonymousClass1.f246772d, anonymousClass1.f246775h);
                                QLog.d("AKOfflineDownloader", 2, "checkUpByBusinessId load success. no update. cost=", Long.valueOf(System.currentTimeMillis() - AnonymousClass1.this.f246776i));
                            }
                        }, 64, null, true);
                    }
                }

                @Override // com.tencent.biz.common.offline.a
                public void progress(int i3) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this, i3);
                    }
                }
            }, true, 0, true);
        }
    }

    protected boolean f(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle)).booleanValue();
        }
        if (bundle == null) {
            return false;
        }
        String string = bundle.getString("bid");
        String string2 = bundle.getString("path");
        if (!HtmlOffline.R(string) || !h.k(string2, string)) {
            return false;
        }
        return true;
    }
}
