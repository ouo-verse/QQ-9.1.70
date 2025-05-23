package hb3;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.luggage.wxaapi.InitDynamicPkgResult;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqsomonitor.api.ISoMonitorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.quic.internal.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AbiUtil;
import fb3.i;
import java.io.File;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes38.dex */
public class f {

    /* renamed from: h, reason: collision with root package name */
    private static volatile f f404660h;

    /* renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f404661a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    private final hb3.a f404662b = new hb3.b();

    /* renamed from: c, reason: collision with root package name */
    private final String f404663c;

    /* renamed from: d, reason: collision with root package name */
    private final String f404664d;

    /* renamed from: e, reason: collision with root package name */
    private final String f404665e;

    /* renamed from: f, reason: collision with root package name */
    private final String f404666f;

    /* renamed from: g, reason: collision with root package name */
    private final long f404667g;

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public interface b {
        void a(boolean z16, String str);
    }

    f() {
        String str;
        boolean isArm64Runtime = AbiUtil.isArm64Runtime(BaseApplicationImpl.getApplication());
        Locale locale = Locale.US;
        Object[] objArr = new Object[2];
        if (isArm64Runtime) {
            str = "arm64-v8a";
        } else {
            str = "armeabi-v7a";
        }
        objArr[0] = str;
        objArr[1] = "4.0.0-143-release";
        String format = String.format(locale, "wxa_dynamic_pkg_release_%s-%s.zip", objArr);
        this.f404663c = format;
        this.f404664d = VFSAssistantUtils.getSDKPrivatePath("Tencent/wxminiapp/") + "df/" + format;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(VFSAssistantUtils.getSDKPrivatePath("Tencent/wxminiapp/"));
        sb5.append("df/");
        this.f404666f = sb5.toString();
        this.f404665e = "https://downv6.qq.com/miniapp/wxminiapp/" + format;
        this.f404667g = 49293372L;
    }

    public static f h() {
        if (f404660h == null) {
            synchronized (f.class) {
                if (f404660h == null) {
                    f404660h = new f();
                }
            }
        }
        return f404660h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k() {
        boolean z16 = i.w().D(this.f404664d) == InitDynamicPkgResult.OK;
        if (!z16) {
            QLog.i("[wxa-q]WxaDynamicPackageLoader", 1, "initDynamicPkg load failed");
        }
        p();
        this.f404661a.set(z16);
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(com.tencent.mobileqq.wxmini.api.data.b bVar) {
        if (j()) {
            if (bVar != null) {
                bVar.onCallback(true, new Bundle());
            }
        } else {
            if (e()) {
                boolean k3 = k();
                if (bVar != null) {
                    bVar.onCallback(k3, new Bundle());
                    return;
                }
                return;
            }
            g(new a(bVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m() {
        try {
            MMKVOptionEntity from = QMMKV.from(BaseApplicationImpl.getApplication(), "common_mmkv_configurations");
            if (TextUtils.equals("4.0.0-143-release", from.decodeString("pref_key_is_wx_so_register", ""))) {
                QLog.i("[wxa-q]WxaDynamicPackageLoader", 1, "So has registered.");
                return;
            }
            File i3 = i();
            if (!i3.exists()) {
                QLog.i("[wxa-q]WxaDynamicPackageLoader", 1, "Libs dir not exist!");
                return;
            }
            File[] listFiles = i3.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (file.getPath().endsWith(".so") && !file.getPath().contains(Utils.ANDROMEDA_NAME) && !file.getPath().contains("libliteavsdk.so") && !file.getPath().contains("libtxffmpeg.so") && !file.getPath().contains("libtxsoundtouch.so")) {
                        if (((ISoMonitorApi) QRoute.api(ISoMonitorApi.class)).isSoFileLegal(BaseApplicationImpl.getApplication(), file)) {
                            QLog.i("[wxa-q]WxaDynamicPackageLoader", 1, file.getName() + " is registered");
                        } else {
                            QLog.i("[wxa-q]WxaDynamicPackageLoader", 1, "register so: " + file.getName());
                            ((ISoMonitorApi) QRoute.api(ISoMonitorApi.class)).registerSoFile(BaseApplicationImpl.getApplication(), file);
                        }
                    }
                    QLog.i("[wxa-q]WxaDynamicPackageLoader", 1, "Don't register this file : " + file.getPath());
                }
                from.encodeString("pref_key_is_wx_so_register", "4.0.0-143-release").commitAsync();
                return;
            }
            QLog.i("[wxa-q]WxaDynamicPackageLoader", 1, "Not contain sub files!");
        } catch (Exception e16) {
            QLog.e("[wxa-q]WxaDynamicPackageLoader", 1, "registerWxSo error! " + e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(com.tencent.mobileqq.wxmini.api.data.b bVar) {
        String str;
        int unzipFix = ZipUtils.unzipFix(this.f404664d, i());
        QLog.i("[wxa-q]WxaDynamicPackageLoader", 2, "unzipDynamicPackage ret:" + unzipFix);
        Bundle bundle = new Bundle();
        if (unzipFix == 0) {
            str = null;
        } else {
            str = "unzip failed ret:" + unzipFix;
        }
        bundle.putString("message", str);
        bVar.onCallback(unzipFix == 0, bundle);
    }

    private void p() {
        ThreadManagerV2.excute(new Runnable() { // from class: hb3.e
            @Override // java.lang.Runnable
            public final void run() {
                f.this.m();
            }
        }, 64, null, false);
    }

    public boolean e() {
        File file = new File(this.f404664d);
        boolean z16 = file.exists() && file.length() == this.f404667g;
        QLog.i("[wxa-q]WxaDynamicPackageLoader", 1, "checkDynamicPackage success: " + z16);
        return z16;
    }

    public void f() {
        try {
            FileUtils.deleteDirectory(this.f404666f);
            QMMKV.from(BaseApplicationImpl.getApplication(), "common_mmkv_configurations").removeKey("pref_key_is_wx_so_register");
            this.f404661a.set(false);
            this.f404662b.clean();
            QLog.d("[wxa-q]WxaDynamicPackageLoader", 1, "deleteDirectory Dir:" + this.f404666f + " hasLoaded:" + this.f404661a.get());
        } catch (Exception e16) {
            QLog.e("[wxa-q]WxaDynamicPackageLoader", 1, "deleteDirectory error Dir:" + this.f404666f, e16);
        }
    }

    public void g(b bVar) {
        String str = this.f404665e;
        if (this.f404662b instanceof hb3.b) {
            str = this.f404663c;
        }
        QLog.i("[wxa-q]WxaDynamicPackageLoader", 1, "downloadDynamicPackage downloadUrl:" + str);
        this.f404662b.a(str, this.f404664d, bVar);
    }

    public File i() {
        return BaseApplication.getContext().getDir("libs", 0);
    }

    public boolean j() {
        return this.f404661a.get();
    }

    public void o(final com.tencent.mobileqq.wxmini.api.data.b bVar) {
        if (!j()) {
            ThreadManagerV2.excute(new Runnable() { // from class: hb3.d
                @Override // java.lang.Runnable
                public final void run() {
                    f.this.l(bVar);
                }
            }, 64, null, true);
        } else if (bVar != null) {
            bVar.onCallback(true, new Bundle());
        }
    }

    public void q(final com.tencent.mobileqq.wxmini.api.data.b bVar) {
        ThreadManagerV2.excute(new Runnable() { // from class: hb3.c
            @Override // java.lang.Runnable
            public final void run() {
                f.this.n(bVar);
            }
        }, 64, null, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class a implements b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.wxmini.api.data.b f404668a;

        a(com.tencent.mobileqq.wxmini.api.data.b bVar) {
            this.f404668a = bVar;
        }

        @Override // hb3.f.b
        public void a(boolean z16, String str) {
            if (z16) {
                boolean k3 = f.this.k();
                com.tencent.mobileqq.wxmini.api.data.b bVar = this.f404668a;
                if (bVar != null) {
                    bVar.onCallback(k3, new Bundle());
                    return;
                }
                return;
            }
            if (this.f404668a != null) {
                Bundle bundle = new Bundle();
                bundle.putString("message", str);
                this.f404668a.onCallback(false, bundle);
            }
        }
    }
}
