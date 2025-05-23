package he1;

import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.springhb.preload.ToStringExtKt;
import com.tencent.mobileqq.springhb.preload.h;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.spring_hb.Preload$NYCommonInfo;
import tencent.im.spring_hb.Preload$SsoNYGetPreloadReq;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    private static final Object f404800b = new Object();

    /* renamed from: a, reason: collision with root package name */
    private volatile h f404801a;

    private void a(AppRuntime appRuntime) {
        try {
            IPreloadService iPreloadService = (IPreloadService) appRuntime.getRuntimeService(IPreloadService.class, "");
            if (iPreloadService == null) {
                QLog.e("SearchPopPreloadConfigProcessor", 1, "checkPreloadResDownloaded preloadManager == null");
                return;
            }
            kl2.a moduleByMID = iPreloadService.getModuleByMID("search_pop_animation_preload");
            if (moduleByMID != null && !moduleByMID.resDownloaded()) {
                QLog.i("SearchPopPreloadConfigProcessor", 1, "checkPreloadResDownloaded startCheckConfig");
                iPreloadService.startCheckConfig(false);
            }
        } catch (Exception e16) {
            QLog.e("SearchPopPreloadConfigProcessor", 1, "checkPreloadResDownloaded error: " + e16);
        }
    }

    private static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    private Preload$NYCommonInfo c() {
        Preload$NYCommonInfo preload$NYCommonInfo = new Preload$NYCommonInfo();
        preload$NYCommonInfo.platform.set(1);
        preload$NYCommonInfo.qqVersion.set(AppSetting.f99551k);
        preload$NYCommonInfo.model.set(ah.F());
        preload$NYCommonInfo.brand.set(ah.C());
        preload$NYCommonInfo.ver.set(ah.t());
        preload$NYCommonInfo.appid.set(AppSetting.f());
        preload$NYCommonInfo.net.set(k());
        return preload$NYCommonInfo;
    }

    private String f() {
        String currentAccountUin;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (currentAccountUin = peekAppRuntime.getCurrentAccountUin()) == null) {
            return "";
        }
        return currentAccountUin;
    }

    private String g() {
        try {
            return QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeString("search_pop_config_md5_sys_" + f(), "");
        } catch (Exception e16) {
            QLog.e("SearchPopPreloadConfigProcessor", 1, "getLocalConfigMD5FromMMKV fail.", e16);
            return null;
        }
    }

    private int k() {
        switch (NetworkUtil.getNetworkType(BaseApplication.getContext())) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 5;
            case 3:
                return 4;
            case 4:
                return 3;
            case 5:
                return 6;
            case 6:
                return 7;
            default:
                return 0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 7, insn: 0x00b8: MOVE (r3 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]) (LINE:185), block:B:57:0x00b8 */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a3  */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v16, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8, types: [com.tencent.mobileqq.springhb.preload.h] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private h l() {
        ObjectInputStream objectInputStream;
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream2;
        ?? r85;
        Exception e16;
        boolean z16;
        h hVar;
        Closeable closeable;
        h hVar2;
        String str = "search_pop_preload_config_" + f();
        ?? fileStreamPath = BaseApplication.getContext().getFileStreamPath(str);
        ObjectInputStream objectInputStream3 = null;
        if (!fileStreamPath.exists()) {
            return null;
        }
        synchronized (f404800b) {
            try {
                try {
                    if (TextUtils.equals(g(), MD5Utils.encodeFileHexStr(fileStreamPath.getAbsolutePath()))) {
                        fileInputStream = new FileInputStream((File) fileStreamPath);
                        try {
                            fileStreamPath = new BufferedInputStream(fileInputStream);
                            try {
                                objectInputStream2 = new ObjectInputStream(fileStreamPath);
                                try {
                                    r85 = new h();
                                    try {
                                        r85.d(objectInputStream2);
                                        objectInputStream3 = objectInputStream2;
                                        z16 = false;
                                        closeable = fileStreamPath;
                                        hVar2 = r85;
                                    } catch (Exception e17) {
                                        e16 = e17;
                                        QLog.e("SearchPopPreloadConfigProcessor", 1, "loadLocalPreloadConfig fail.", e16);
                                        b(objectInputStream2);
                                        b(fileStreamPath);
                                        b(fileInputStream);
                                        z16 = true;
                                        hVar = r85;
                                        if (z16) {
                                        }
                                        QLog.d("SearchPopPreloadConfigProcessor", 1, "loadLocalPreloadConfig fileName=", str);
                                        return hVar;
                                    }
                                } catch (Exception e18) {
                                    r85 = 0;
                                    e16 = e18;
                                }
                            } catch (Exception e19) {
                                r85 = 0;
                                e16 = e19;
                                objectInputStream2 = null;
                            } catch (Throwable th5) {
                                th = th5;
                                b(objectInputStream3);
                                b(fileStreamPath);
                                b(fileInputStream);
                                throw th;
                            }
                        } catch (Exception e26) {
                            e = e26;
                            objectInputStream2 = null;
                            r85 = objectInputStream2;
                            e16 = e;
                            fileStreamPath = r85;
                            QLog.e("SearchPopPreloadConfigProcessor", 1, "loadLocalPreloadConfig fail.", e16);
                            b(objectInputStream2);
                            b(fileStreamPath);
                            b(fileInputStream);
                            z16 = true;
                            hVar = r85;
                            if (z16) {
                            }
                            QLog.d("SearchPopPreloadConfigProcessor", 1, "loadLocalPreloadConfig fileName=", str);
                            return hVar;
                        } catch (Throwable th6) {
                            th = th6;
                            fileStreamPath = 0;
                        }
                    } else {
                        QLog.e("SearchPopPreloadConfigProcessor", 1, "loadLocalPreloadConfig local config md5 not match.");
                        closeable = null;
                        fileInputStream = null;
                        hVar2 = null;
                        z16 = true;
                    }
                    b(objectInputStream3);
                    b(closeable);
                    b(fileInputStream);
                    hVar = hVar2;
                } catch (Exception e27) {
                    e = e27;
                    fileInputStream = null;
                    objectInputStream2 = null;
                } catch (Throwable th7) {
                    th = th7;
                    fileStreamPath = 0;
                    fileInputStream = null;
                }
            } catch (Throwable th8) {
                th = th8;
                objectInputStream3 = objectInputStream;
            }
        }
        if (z16) {
            e();
        }
        QLog.d("SearchPopPreloadConfigProcessor", 1, "loadLocalPreloadConfig fileName=", str);
        return hVar;
    }

    private void n(AppRuntime appRuntime) {
        QLog.i("SearchPopPreloadConfigProcessor", 1, "onUpdate");
        if (this.f404801a != null && this.f404801a.f289508b != null && this.f404801a.f289508b.length() >= 1) {
            IPreloadService iPreloadService = (IPreloadService) appRuntime.getRuntimeService(IPreloadService.class, "");
            iPreloadService.replaceConfig(this.f404801a.f289508b, 4);
            iPreloadService.savePreloadConfig();
            iPreloadService.startCheckConfig(true);
            return;
        }
        QLog.e("SearchPopPreloadConfigProcessor", 1, "onUpdate PreloadConfig invalid");
    }

    private void o(int i3, String str) {
        QLog.d("SearchPopPreloadConfigProcessor", 1, "saveLocalConfigInfoToMMKV version=", Integer.valueOf(i3), " md5=", str);
        try {
            String f16 = f();
            String str2 = "search_pop_config_version_sys_" + f16;
            MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            fromV2.encodeLong(str2, i3);
            fromV2.encodeString("search_pop_config_md5_sys_" + f16, str);
        } catch (Exception e16) {
            QLog.e("SearchPopPreloadConfigProcessor", 1, "saveLocalConfigInfoToMMKV fail:", e16);
        }
    }

    public Preload$SsoNYGetPreloadReq d() {
        try {
            Preload$SsoNYGetPreloadReq preload$SsoNYGetPreloadReq = new Preload$SsoNYGetPreloadReq();
            preload$SsoNYGetPreloadReq.commonInfo.set(c());
            preload$SsoNYGetPreloadReq.scene.set(2);
            preload$SsoNYGetPreloadReq.ver.set(h());
            return preload$SsoNYGetPreloadReq;
        } catch (Throwable th5) {
            QLog.e("SearchPopPreloadConfigProcessor", 1, "createReqPreloadConfigData e=", th5);
            return null;
        }
    }

    public void e() {
        try {
            synchronized (f404800b) {
                String str = "search_pop_preload_config_" + f();
                QLog.d("SearchPopPreloadConfigProcessor", 1, "deleteLocalEntryConfig fileName=", str);
                File fileStreamPath = BaseApplication.getContext().getFileStreamPath(str);
                if (fileStreamPath.exists()) {
                    fileStreamPath.delete();
                }
            }
            o(0, "");
        } catch (Exception e16) {
            QLog.e("SearchPopPreloadConfigProcessor", 1, "deleteLocalEntryConfig fail.", e16);
        }
    }

    public int h() {
        j(true);
        if (this.f404801a != null) {
            return this.f404801a.f289507a;
        }
        return i();
    }

    public int i() {
        int i3 = 0;
        try {
            i3 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeInt("search_pop_config_version_sys_" + f(), 0);
            QLog.i("SearchPopPreloadConfigProcessor", 1, "getLocalConfigVersionFromMMKV version: " + i3);
            return i3;
        } catch (Exception e16) {
            QLog.e("SearchPopPreloadConfigProcessor", 1, "getLocalConfigVersionFromMMKV fail.", e16);
            return i3;
        }
    }

    public h j(boolean z16) {
        if (this.f404801a == null && z16) {
            try {
                h l3 = l();
                if (l3 != null) {
                    this.f404801a = l3;
                }
            } catch (Throwable th5) {
                QLog.e("SearchPopPreloadConfigProcessor", 1, "getLocalPreloadConfig fail:", th5);
            }
        }
        return this.f404801a;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m(AppRuntime appRuntime, int i3, String str) {
        int i16;
        boolean z16;
        h j3 = j(true);
        if (j3 != null) {
            try {
                i16 = j3.f289507a;
            } catch (Throwable th5) {
                QLog.e("SearchPopPreloadConfigProcessor", 1, "onGetPreloadConfig fail.", th5);
            }
        } else {
            i16 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SearchPopPreloadConfigProcessor", 2, "onGetPreloadConfig preVersion=", Integer.valueOf(i16), " remoteVersion=", Integer.valueOf(i3));
        }
        if (j3 == null || i16 != i3) {
            j3 = h.a(i3, str);
            if (j3 == null) {
                QLog.e("SearchPopPreloadConfigProcessor", 1, "onGetPreloadConfig parse config fail.");
                e();
            } else {
                p(appRuntime, j3);
            }
            z16 = true;
            if (!z16) {
                this.f404801a = j3;
                n(appRuntime);
            } else {
                a(appRuntime);
            }
            if (!QLog.isColorLevel() && this.f404801a != null) {
                QLog.d("SearchPopPreloadConfigProcessor", 2, "onGetPreloadConfig change=", Boolean.valueOf(z16), " config=", ToStringExtKt.a(this.f404801a, true));
                return;
            }
        }
        z16 = false;
        if (!z16) {
        }
        if (!QLog.isColorLevel()) {
        }
    }

    public void p(AppRuntime appRuntime, h hVar) {
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        BufferedOutputStream bufferedOutputStream;
        synchronized (f404800b) {
            String str = "search_pop_preload_config_" + appRuntime.getCurrentUin();
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                File fileStreamPath = BaseApplication.getContext().getFileStreamPath(str);
                File fileStreamPath2 = BaseApplication.getContext().getFileStreamPath(str + ".tmp");
                QLog.d("SearchPopPreloadConfigProcessor", 1, "saveLocalPreloadConfig fileName=", str);
                if (fileStreamPath2.exists()) {
                    fileStreamPath2.delete();
                }
                fileStreamPath2.createNewFile();
                FileOutputStream fileOutputStream2 = new FileOutputStream(fileStreamPath2);
                try {
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream2);
                    try {
                        objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
                    } catch (Throwable th5) {
                        th = th5;
                        objectOutputStream = null;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    objectOutputStream = null;
                }
                try {
                    hVar.e(objectOutputStream);
                    objectOutputStream.flush();
                    fileOutputStream2.flush();
                    if (fileStreamPath.exists()) {
                        fileStreamPath.delete();
                    }
                    fileStreamPath2.renameTo(fileStreamPath);
                    o(hVar.f289507a, MD5Utils.encodeFileHexStr(fileStreamPath.getAbsolutePath()));
                    b(fileOutputStream2);
                    b(bufferedOutputStream);
                } catch (Throwable th7) {
                    th = th7;
                    bufferedOutputStream2 = bufferedOutputStream;
                    Throwable th8 = th;
                    fileOutputStream = fileOutputStream2;
                    th = th8;
                    try {
                        QLog.e("SearchPopPreloadConfigProcessor", 1, "saveLocalEntryConfig fail:", th);
                        e();
                        b(fileOutputStream);
                        b(bufferedOutputStream2);
                        b(objectOutputStream);
                    } catch (Throwable th9) {
                        b(fileOutputStream);
                        b(bufferedOutputStream2);
                        b(objectOutputStream);
                        throw th9;
                    }
                }
            } catch (Throwable th10) {
                th = th10;
                fileOutputStream = null;
                objectOutputStream = null;
            }
            b(objectOutputStream);
        }
    }
}
