package com.tencent.mobileqq.splashad.config;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.splashad.config.AbsSplashConfigProcessor;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.Md5Utils;
import com.tencent.util.CommonMMKVUtils;
import cooperation.qzone.QZoneHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ThemeSplashHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f288753a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a extends AbsPreDownloadTask {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f288758d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ File f288759e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(BaseQQAppInterface baseQQAppInterface, String str, String str2, File file) {
            super(baseQQAppInterface, str);
            this.f288758d = str2;
            this.f288759e = file;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, baseQQAppInterface, str, str2, file);
            }
        }

        @Override // com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask
        protected void realCancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask
        protected void realStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("ThemeSplashHelper", 2, "requestDownload realStart: " + this.f288758d + ", path = " + this.f288759e.getAbsolutePath());
            }
            ThemeSplashHelper.t(this.ctrl, this.f288758d, this.f288759e);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public BitmapDrawable f288760a;

        /* renamed from: b, reason: collision with root package name */
        public BitmapDrawable f288761b;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75190);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f288753a = false;
        }
    }

    static /* bridge */ /* synthetic */ String f() {
        return r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(@NonNull Set<String> set) {
        try {
            File file = new File(r());
            long fileSizes = FileUtils.getFileSizes(r());
            if (file.exists() && file.isDirectory() && fileSizes > QZoneHelper.Constants.NO_WIFI_UPLOAD_VIDEO_MAX_SIZE_DEFAULT) {
                File[] listFiles = file.listFiles();
                long currentTimeMillis = System.currentTimeMillis();
                if (listFiles != null && listFiles.length > 0) {
                    for (File file2 : listFiles) {
                        if (!set.contains(file2.getName()) && currentTimeMillis - file2.lastModified() >= 172800) {
                            FileUtils.deleteFile(file2);
                        }
                    }
                }
                QLog.d("ThemeSplashHelper", 1, "checkAndExtremeDirCache clear before: " + fileSizes + ", after = " + FileUtils.getFileSizes(r()));
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w("ThemeSplashHelper", 2, "clearDirCache fail: ", e16);
            }
        }
    }

    public static void i() {
        FileUtils.delete(r(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j(@NonNull HashMap<String, String> hashMap) {
        for (String str : com.tencent.mobileqq.splashad.config.a.f288763b) {
            String str2 = hashMap.get(str);
            String e16 = c.a().e(str);
            if (str2 == null) {
                str2 = "";
            }
            CommonMMKVUtils.putString(e16, str2, false);
        }
        if (QLog.isColorLevel()) {
            QLog.d("ThemeSplashHelper", 2, "clearAndUpdateAllModeProp save map: " + hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k(String str, Map<String, String> map, Set<String> set, int i3) {
        com.tencent.mobileqq.splashad.config.b a16;
        if (TextUtils.isEmpty(str) || !map.containsKey(str) || (a16 = com.tencent.mobileqq.splashad.config.b.a(map.get(str))) == null) {
            return;
        }
        String[] strArr = {q(a16), o(a16)};
        StringBuilder sb5 = new StringBuilder("downloadModeConfigRes, do download for [");
        sb5.append(str);
        sb5.append("] : [");
        int i16 = i3 + 2;
        for (int i17 = 0; i17 < 2; i17++) {
            String str2 = strArr[i17];
            File p16 = p(str2);
            if (p16 != null && !s(p16)) {
                u(str2, p16, i16);
                set.add(p16.getName());
                sb5.append(p16.getName());
                sb5.append(',');
                i16--;
            }
        }
        sb5.append("]");
        if (QLog.isColorLevel()) {
            QLog.d("ThemeSplashHelper", 2, sb5.toString());
        }
    }

    @Nullable
    public static com.tencent.mobileqq.splashad.config.b l() {
        String str = "";
        String c16 = c.a().c();
        if (TextUtils.isEmpty(c16)) {
            if (QLog.isColorLevel()) {
                QLog.d("ThemeSplashHelper", 2, "getItemFromCurModeProp: curMode get null");
                return null;
            }
            return null;
        }
        try {
            str = CommonMMKVUtils.getString(c16, "", false);
        } catch (Throwable th5) {
            QLog.d("ThemeSplashHelper", 2, "getItemFromCurModeProp: get err: ", th5);
        }
        return com.tencent.mobileqq.splashad.config.b.a(str);
    }

    public static b m(Resources resources) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mobileqq.splashad.config.b l3 = l();
        FileInputStream fileInputStream3 = null;
        if (l3 == null) {
            QLog.d("ThemeSplashHelper", 1, "getSetSplashInfo: not use config. spend time = " + (System.currentTimeMillis() - currentTimeMillis));
            return null;
        }
        String q16 = q(l3);
        File p16 = p(q16);
        boolean s16 = s(p16);
        QLog.d("ThemeSplashHelper", 1, "splashUrl = " + q16 + ", isExist = " + s16 + ", cost = " + (System.currentTimeMillis() - currentTimeMillis));
        if (!s16) {
            return null;
        }
        try {
            b bVar = new b();
            fileInputStream2 = new FileInputStream(p16);
            try {
                bVar.f288760a = new BitmapDrawable(resources, fileInputStream2);
                File p17 = p(o(l3));
                if (s(p17)) {
                    fileInputStream = new FileInputStream(p17);
                    try {
                        try {
                            bVar.f288761b = new BitmapDrawable(resources, fileInputStream);
                        } catch (Throwable th5) {
                            th = th5;
                            fileInputStream3 = fileInputStream2;
                            FileUtils.close(fileInputStream3);
                            FileUtils.close(fileInputStream);
                            QLog.d("ThemeSplashHelper", 1, "getSetSplashInfo: use config. spend time = " + (System.currentTimeMillis() - currentTimeMillis));
                            throw th;
                        }
                    } catch (Exception e16) {
                        e = e16;
                        QLog.e("ThemeSplashHelper", 1, "getSetSplashInfo:", e);
                        FileUtils.close(fileInputStream2);
                        FileUtils.close(fileInputStream);
                        QLog.d("ThemeSplashHelper", 1, "getSetSplashInfo: use config. spend time = " + (System.currentTimeMillis() - currentTimeMillis));
                        return null;
                    }
                } else {
                    fileInputStream = null;
                }
                ThreadManagerV2.excute(new Runnable(q16) { // from class: com.tencent.mobileqq.splashad.config.ThemeSplashHelper.4
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ String f288757d;

                    {
                        this.f288757d = q16;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) q16);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            d.a(c.a().d(), this.f288757d);
                        }
                    }
                }, 128, null, true);
                FileUtils.close(fileInputStream2);
                FileUtils.close(fileInputStream);
                QLog.d("ThemeSplashHelper", 1, "getSetSplashInfo: use config. spend time = " + (System.currentTimeMillis() - currentTimeMillis));
                return bVar;
            } catch (Exception e17) {
                e = e17;
                fileInputStream = null;
            } catch (Throwable th6) {
                th = th6;
                fileInputStream = null;
                fileInputStream3 = fileInputStream2;
                FileUtils.close(fileInputStream3);
                FileUtils.close(fileInputStream);
                QLog.d("ThemeSplashHelper", 1, "getSetSplashInfo: use config. spend time = " + (System.currentTimeMillis() - currentTimeMillis));
                throw th;
            }
        } catch (Exception e18) {
            e = e18;
            fileInputStream = null;
            fileInputStream2 = null;
        } catch (Throwable th7) {
            th = th7;
            fileInputStream = null;
            FileUtils.close(fileInputStream3);
            FileUtils.close(fileInputStream);
            QLog.d("ThemeSplashHelper", 1, "getSetSplashInfo: use config. spend time = " + (System.currentTimeMillis() - currentTimeMillis));
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static Map<String, String> n(int i3) {
        try {
            AbsSplashConfigProcessor.a aVar = (AbsSplashConfigProcessor.a) am.s().x(i3);
            if (aVar == null) {
                return null;
            }
            return aVar.b();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w("ThemeSplashHelper", 2, "getSplashConfigMapByCId fail: ", e16);
            }
            return null;
        }
    }

    private static String o(com.tencent.mobileqq.splashad.config.b bVar) {
        boolean z16;
        if (ScreenUtil.SCREEN_WIDTH > 1500) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return bVar.f288767d;
        }
        return bVar.f288766c;
    }

    public static File p(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new File(r(), Md5Utils.getMD5(str));
    }

    private static String q(com.tencent.mobileqq.splashad.config.b bVar) {
        boolean z16;
        if (ScreenUtil.SCREEN_WIDTH > 1500) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return bVar.f288765b;
        }
        return bVar.f288764a;
    }

    private static String r() {
        String str = com.tencent.mobileqq.splashad.config.a.f288762a;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(BaseApplication.getContext().getCacheDir());
            sb5.append("theme_splash");
            String str2 = File.separator;
            sb5.append(str2);
            str = sb5.toString();
            if ("mounted".equals(Environment.getExternalStorageState())) {
                str = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "theme_splash" + str2);
            }
        } catch (Throwable th5) {
            QLog.e("ThemeSplashHelper", 1, th5, new Object[0]);
        }
        com.tencent.mobileqq.splashad.config.a.f288762a = str;
        return str;
    }

    public static boolean s(File file) {
        if (file != null && file.exists() && file.isFile()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void t(IPreDownloadController iPreDownloadController, String str, File file) {
        if (s(file)) {
            if (QLog.isColorLevel()) {
                QLog.i("ThemeSplashHelper", 2, "realDownload already exist : " + str);
            }
            iPreDownloadController.preDownloadSuccess(str, file.length());
            return;
        }
        ThreadManagerV2.excute(new Runnable(file, str, iPreDownloadController) { // from class: com.tencent.mobileqq.splashad.config.ThemeSplashHelper.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ File f288754d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f288755e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ IPreDownloadController f288756f;

            {
                this.f288754d = file;
                this.f288755e = str;
                this.f288756f = iPreDownloadController;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, file, str, iPreDownloadController);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                long j3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                boolean s16 = ThemeSplashHelper.s(this.f288754d);
                if (!s16) {
                    try {
                        s16 = HttpDownloadUtil.download((AppRuntime) null, this.f288755e, this.f288754d);
                    } catch (Throwable th5) {
                        QLog.w("ThemeSplashHelper", 1, "startDownload fail: ", th5);
                    }
                }
                IPreDownloadController iPreDownloadController2 = this.f288756f;
                String str2 = this.f288755e;
                if (s16) {
                    j3 = this.f288754d.length();
                } else {
                    j3 = -1;
                }
                iPreDownloadController2.preDownloadSuccess(str2, j3);
                if (QLog.isColorLevel()) {
                    QLog.i("ThemeSplashHelper", 2, "realDownload : " + this.f288755e + ", isSuccess = " + s16);
                }
            }
        }, 128, null, false);
    }

    private static void u(String str, File file, int i3) {
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (qQAppInterface == null) {
            return;
        }
        ((IPreDownloadController) qQAppInterface.getRuntimeService(IPreDownloadController.class)).requestPreDownload(10101, "app", file.getName(), i3, str, file.getAbsolutePath(), 2, 0, true, new a(qQAppInterface, "theme_splash", str, file));
    }

    public static void v() {
        if (f288753a) {
            if (QLog.isColorLevel()) {
                QLog.d("ThemeSplashHelper", 2, "triggerCheckAndDownload isChecking");
            }
        } else {
            f288753a = true;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.splashad.config.ThemeSplashHelper.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("ThemeSplashHelper", 2, "triggerCheckAndDownload check start");
                    }
                    c.a().f();
                    HashMap hashMap = new HashMap();
                    Map n3 = ThemeSplashHelper.n(852);
                    if (n3 != null) {
                        hashMap.putAll(n3);
                    }
                    ThemeSplashHelper.j(hashMap);
                    try {
                        FileUtils.createDirectory(ThemeSplashHelper.f());
                    } catch (IOException e16) {
                        QLog.w("ThemeSplashHelper", 1, "create dir fail : ", e16);
                    }
                    HashSet hashSet = new HashSet(hashMap.size() * 2);
                    String d16 = c.a().d();
                    ThemeSplashHelper.k(d16, hashMap, hashSet, 5);
                    for (String str : hashMap.keySet()) {
                        if (str != null && !str.equals(d16)) {
                            ThemeSplashHelper.k(str, hashMap, hashSet, 0);
                        }
                    }
                    ThemeSplashHelper.h(hashSet);
                    ThemeSplashHelper.f288753a = false;
                }
            }, 16, null, true);
        }
    }
}
