package com.tencent.mobileqq.microapp.apkg;

import Wallet.ApkgConfig;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.microapp.sdk.LaunchParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class a implements Serializable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private transient String f245837a;

    /* renamed from: b, reason: collision with root package name */
    private transient byte[] f245838b;

    /* renamed from: c, reason: collision with root package name */
    private Map f245839c;

    /* renamed from: d, reason: collision with root package name */
    private Map f245840d;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.microapp.apkg.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C8027a implements Serializable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public ApkgConfig f245841a;

        /* renamed from: b, reason: collision with root package name */
        public List f245842b;

        public C8027a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public void a(ApkgConfig apkgConfig) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) apkgConfig);
                return;
            }
            ApkgConfig apkgConfig2 = this.f245841a;
            this.f245841a = apkgConfig;
            if (apkgConfig2 != null && apkgConfig2.mini_version != apkgConfig.mini_version) {
                if (this.f245842b == null) {
                    this.f245842b = new LinkedList();
                }
                this.f245842b.add(apkgConfig);
                if (this.f245842b.size() > 1) {
                    ApkgConfig apkgConfig3 = (ApkgConfig) this.f245842b.get(0);
                    this.f245842b.remove(0);
                    a.a(apkgConfig3);
                }
            }
        }

        public C8027a(ApkgConfig apkgConfig) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.f245841a = apkgConfig;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) apkgConfig);
            }
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f245839c = new HashMap();
            this.f245840d = new HashMap();
        }
    }

    public static a a(QQAppInterface qQAppInterface) {
        a aVar;
        String a16 = a((AppRuntime) qQAppInterface);
        try {
            aVar = (a) QWalletTools.readObject(a16);
        } catch (Throwable th5) {
            th5.printStackTrace();
            aVar = null;
        }
        if (aVar == null) {
            aVar = new a();
        }
        aVar.f245837a = a16;
        aVar.f245838b = new byte[0];
        if (aVar.f245840d == null) {
            aVar.f245840d = new HashMap();
        }
        if (QLog.isColorLevel()) {
            QLog.d("ApkgConfigHolder", 2, "readApkgConfigHolder:" + aVar);
        }
        return aVar;
    }

    public ApkgConfig b(LaunchParam launchParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ApkgConfig) iPatchRedirector.redirect((short) 4, (Object) this, (Object) launchParam);
        }
        if (launchParam == null) {
            return null;
        }
        if (!TextUtils.isEmpty(launchParam.extraKey) && launchParam.scene == 1207) {
            Iterator it = this.f245840d.entrySet().iterator();
            while (it.hasNext()) {
                ApkgConfig apkgConfig = ((C8027a) ((Map.Entry) it.next()).getValue()).f245841a;
                if (launchParam.extraKey.equals(apkgConfig.qq_qr_code)) {
                    return apkgConfig;
                }
            }
        }
        int i3 = launchParam.scene;
        if (i3 != 1207 && i3 != 1208) {
            C8027a c8027a = (C8027a) this.f245839c.get(launchParam.miniAppId);
            if (c8027a != null) {
                return c8027a.f245841a;
            }
            return null;
        }
        if (!TextUtils.isEmpty(launchParam.extraKey)) {
            Iterator it5 = this.f245839c.entrySet().iterator();
            while (it5.hasNext()) {
                ApkgConfig apkgConfig2 = ((C8027a) ((Map.Entry) it5.next()).getValue()).f245841a;
                if (launchParam.scene == 1207 && launchParam.extraKey.equals(apkgConfig2.qq_qr_code)) {
                    return apkgConfig2;
                }
                if (launchParam.scene == 1208 && launchParam.extraKey.equals(apkgConfig2.wx_qr_code)) {
                    return apkgConfig2;
                }
            }
        }
        return null;
    }

    private static String a(AppRuntime appRuntime) {
        return appRuntime.getApplication().getFilesDir().getPath() + "/miniapp/" + appRuntime.getAccount() + "/.ApkgConfigs";
    }

    public void a(List list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
            return;
        }
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ApkgConfig apkgConfig = (ApkgConfig) it.next();
                if (apkgConfig != null && !TextUtils.isEmpty(apkgConfig.mini_appid)) {
                    if (apkgConfig.getRuntimeType() == 1) {
                        C8027a c8027a = (C8027a) this.f245840d.get(apkgConfig.mini_appid);
                        if (c8027a != null && !c8027a.f245841a.qq_qr_code.equals(apkgConfig.qq_qr_code)) {
                            a(c8027a.f245841a);
                        }
                        this.f245840d.put(apkgConfig.mini_appid, new C8027a(apkgConfig));
                    } else {
                        C8027a c8027a2 = (C8027a) this.f245839c.get(apkgConfig.mini_appid);
                        if (c8027a2 == null) {
                            c8027a2 = new C8027a();
                            this.f245839c.put(apkgConfig.mini_appid, new C8027a(apkgConfig));
                        }
                        c8027a2.a(apkgConfig);
                    }
                }
            }
            a();
        }
    }

    public static void a(ApkgConfig apkgConfig) {
        if (apkgConfig != null) {
            PreloadManager.deleteRes(apkgConfig.apkg_url, false, 0);
            Map<String, String> map = apkgConfig.sub_apkg_urls;
            if (map != null) {
                Iterator<String> it = map.values().iterator();
                while (it.hasNext()) {
                    PreloadManager.deleteRes(it.next(), false, 0);
                }
            }
            com.tencent.mobileqq.microapp.a.c.a(g.a(apkgConfig), false);
        }
    }

    public void a(LaunchParam launchParam) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) launchParam);
            return;
        }
        if (launchParam == null) {
            return;
        }
        boolean z17 = true;
        if (!TextUtils.isEmpty(launchParam.extraKey) && launchParam.scene == 1207) {
            Iterator it = this.f245840d.entrySet().iterator();
            while (it.hasNext()) {
                if (launchParam.extraKey.equals(((C8027a) ((Map.Entry) it.next()).getValue()).f245841a.qq_qr_code)) {
                    it.remove();
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        if (!z16) {
            int i3 = launchParam.scene;
            if (i3 != 1207 && i3 != 1208) {
                this.f245839c.remove(launchParam.miniAppId);
            } else if (!TextUtils.isEmpty(launchParam.extraKey)) {
                Iterator it5 = this.f245839c.entrySet().iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        z17 = z16;
                        break;
                    }
                    ApkgConfig apkgConfig = ((C8027a) ((Map.Entry) it5.next()).getValue()).f245841a;
                    if (launchParam.scene == 1207 && launchParam.extraKey.equals(apkgConfig.qq_qr_code)) {
                        it5.remove();
                        break;
                    } else if (launchParam.scene == 1208 && launchParam.extraKey.equals(apkgConfig.wx_qr_code)) {
                        it5.remove();
                        break;
                    }
                }
                z16 = z17;
            }
        }
        if (z16) {
            a();
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            ThreadManager.getFileThreadHandler().post(new b(this));
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }
}
