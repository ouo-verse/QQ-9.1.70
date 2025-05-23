package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.patch.QZonePatchService;
import dalvik.system.DexClassLoader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes23.dex */
public class n {

    /* renamed from: c, reason: collision with root package name */
    private static n f369421c;

    /* renamed from: e, reason: collision with root package name */
    private FileLock f369429e;

    /* renamed from: f, reason: collision with root package name */
    private FileOutputStream f369430f;

    /* renamed from: q, reason: collision with root package name */
    private QbSdk.TbsInstallerCallBack f369435q;

    /* renamed from: h, reason: collision with root package name */
    private static final ReentrantLock f369422h = new ReentrantLock();

    /* renamed from: i, reason: collision with root package name */
    private static final Lock f369423i = new ReentrantLock();

    /* renamed from: k, reason: collision with root package name */
    private static FileLock f369424k = null;

    /* renamed from: n, reason: collision with root package name */
    private static final ThreadLocal<Integer> f369425n = new ThreadLocal<Integer>() { // from class: com.tencent.smtt.sdk.n.1
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer initialValue() {
            return 0;
        }
    };

    /* renamed from: o, reason: collision with root package name */
    private static Handler f369426o = null;

    /* renamed from: a, reason: collision with root package name */
    static boolean f369419a = false;

    /* renamed from: b, reason: collision with root package name */
    static final FileFilter f369420b = new FileFilter() { // from class: com.tencent.smtt.sdk.n.2
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            if (name == null || name.endsWith(".jar_is_first_load_dex_flag_file")) {
                return false;
            }
            int i3 = Build.VERSION.SDK_INT;
            if (name.endsWith(QZonePatchService.PATCH_SUFFIX_DEX)) {
                return false;
            }
            if (i3 >= 26 && name.endsWith(".prof")) {
                return false;
            }
            if (i3 >= 26 && name.equals("oat")) {
                return false;
            }
            return true;
        }
    };

    /* renamed from: p, reason: collision with root package name */
    private static int f369427p = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f369428d = 0;

    /* renamed from: g, reason: collision with root package name */
    private boolean f369431g = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean f369432j = false;

    /* renamed from: l, reason: collision with root package name */
    private boolean f369433l = true;

    /* renamed from: m, reason: collision with root package name */
    private boolean f369434m = false;

    /* renamed from: r, reason: collision with root package name */
    private int f369436r = -1;

    n() {
        if (f369426o == null) {
            f369426o = new Handler(TbsHandlerThread.getInstance().getLooper()) { // from class: com.tencent.smtt.sdk.n.3
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    QbSdk.setTBSInstallingStatus(true);
                    int i3 = message.what;
                    if (i3 != 1) {
                        if (i3 != 3) {
                            QbSdk.setTBSInstallingStatus(false);
                            return;
                        }
                        TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE_EX");
                        Object[] objArr = (Object[]) message.obj;
                        n.this.b((Context) objArr[0], (Bundle) objArr[1]);
                        return;
                    }
                    TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE");
                    Object[] objArr2 = (Object[]) message.obj;
                    n.this.b((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized n a() {
        n nVar;
        synchronized (n.class) {
            if (f369421c == null) {
                synchronized (n.class) {
                    if (f369421c == null) {
                        f369421c = new n();
                    }
                }
            }
            nVar = f369421c;
        }
        return nVar;
    }

    public static void b() {
        f369425n.set(0);
    }

    private synchronized boolean c(Context context, boolean z16) {
        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch");
        boolean z17 = false;
        try {
        } catch (Throwable th5) {
            TbsLogReport.getInstance(context).setInstallErrorCode(215, th5.toString());
            QbSdk.a(context, "TbsInstaller::enableTbsCoreFromTpatch exception:" + Log.getStackTraceString(th5));
        }
        if (!p(context)) {
            return false;
        }
        ReentrantLock reentrantLock = f369422h;
        boolean tryLock = reentrantLock.tryLock();
        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch Locked =" + tryLock);
        if (tryLock) {
            try {
                int b16 = m.a(context).b("tpatch_status");
                int a16 = a(false, context);
                TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch copyStatus =" + b16);
                TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch tbsCoreInstalledVer =" + a16);
                if (b16 == 1) {
                    if (a16 == 0) {
                        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch tbsCoreInstalledVer = 0", true);
                        u(context);
                    } else if (z16) {
                        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch tbsCoreInstalledVer != 0", true);
                        u(context);
                    }
                    z17 = true;
                }
                reentrantLock.unlock();
            } catch (Throwable th6) {
                f369422h.unlock();
                throw th6;
            }
        }
        c();
        return z17;
    }

    private synchronized boolean d(Context context, boolean z16) {
        TbsLog.i("TbsInstaller", "enableTbsCoreFromUnzip", "canRenameTmpDir =" + z16);
        TbsLog.i("TbsInstaller", "enableTbsCoreFromUnzip", "#1#");
        boolean z17 = false;
        try {
        } catch (Exception e16) {
            QbSdk.a(context, "TbsInstaller::enableTbsCoreFromUnzip Exception: " + e16);
            e16.printStackTrace();
        }
        if (!p(context)) {
            return false;
        }
        TbsLog.i("TbsInstaller", "enableTbsCoreFromUnzip", "#2# getInstallFileLock Success!!");
        ReentrantLock reentrantLock = f369422h;
        boolean tryLock = reentrantLock.tryLock();
        TbsLog.i("TbsInstaller", "enableTbsCoreFromUnzip", "locked=" + tryLock);
        if (tryLock) {
            try {
                int c16 = m.a(context).c();
                TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip installStatus=" + c16);
                int a16 = a(false, context);
                if (c16 == 2) {
                    TbsLog.i("TbsInstaller", "enableTbsCoreFromUnzip", "#4# In Rename Logic");
                    if (a16 == 0) {
                        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer = 0", false);
                        t(context);
                    } else if (z16) {
                        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer != 0", false);
                        t(context);
                    }
                    z17 = true;
                }
                reentrantLock.unlock();
            } catch (Throwable th5) {
                f369422h.unlock();
                throw th5;
            }
        }
        c();
        return z17;
    }

    private void e(Context context, boolean z16) {
        if (context == null) {
            TbsLogReport.getInstance(context).setInstallErrorCode(225, "setTmpFolderCoreToRead context is null");
            TbsLog.i("TbsInstaller", "setTmpFolderCoreToRead inner return #01");
            return;
        }
        try {
            File file = new File(QbSdk.getTbsFolderDir(context), "tmp_folder_core_to_read.conf");
            if (z16) {
                if (file.exists()) {
                    TbsLog.i("TbsInstaller", "setTmpFolderCoreToRead inner tmp file already exist #01");
                } else {
                    TbsLog.i("TbsInstaller", "setTmpFolderCoreToRead inner tmp file create #01");
                    file.createNewFile();
                }
            } else {
                TbsLog.i("TbsInstaller", "setTmpFolderCoreToRead inner tmp file delete #01");
                FileUtil.b(file);
            }
        } catch (Exception e16) {
            TbsLogReport.getInstance(context).setInstallErrorCode(225, "setTmpFolderCoreToRead Exception message is " + e16.getMessage() + " Exception cause is " + e16.getCause());
            TbsLog.i("TbsInstaller", "setTmpFolderCoreToRead inner exception #01");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File o(Context context) {
        File file = new File(QbSdk.getTbsFolderDir(context), "core_private");
        if (!file.isDirectory() && !file.mkdir()) {
            return null;
        }
        return file;
    }

    private int q(Context context) {
        boolean z16 = true;
        if (m.a(context).d() != 1) {
            z16 = false;
        }
        boolean a16 = TbsDownloader.a(context);
        if (z16) {
            if (a16) {
                return 234;
            }
            return 221;
        }
        if (a16) {
            return 233;
        }
        return 200;
    }

    private static boolean r(Context context) {
        if (context == null) {
            TbsLog.i("TbsInstaller", "getTmpFolderCoreToRead", "#1#");
            return true;
        }
        try {
            if (new File(QbSdk.getTbsFolderDir(context), "tmp_folder_core_to_read.conf").exists()) {
                TbsLog.i("TbsInstaller", "getTmpFolderCoreToRead", "#2#");
                return true;
            }
            TbsLog.i("TbsInstaller", "getTmpFolderCoreToRead", "#3#");
            return false;
        } catch (Exception unused) {
            TbsLog.i("TbsInstaller", "getTmpFolderCoreToRead", "#4#");
            return true;
        }
    }

    private boolean s(Context context) {
        TbsLog.i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock #1 ");
        FileLock e16 = FileUtil.e(context);
        f369424k = e16;
        if (e16 == null) {
            TbsLog.i("TbsInstaller", "getTbsCoreRenameFileLock## failed!");
            return false;
        }
        TbsLog.i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock true ");
        return true;
    }

    private void t(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip");
        if (!s(context)) {
            TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
            return;
        }
        try {
            v(context);
            w(context);
            TbsLog.i("TbsInstaller", "after renameTbsCoreShareDir");
            TbsLog.i("TbsInstaller", "is thirdapp and not chmod");
            m.a(context).a(0);
            m.a(context).b(0);
            m.a(context).d(0);
            m.a(context).a("incrupdate_retry_num", 0);
            m.a(context).c(0, 3);
            m.a(context).a("");
            m.a(context).a("tpatch_num", 0);
            m.a(context).c(-1);
            f369425n.set(0);
            f369427p = 0;
        } catch (Throwable th5) {
            th5.printStackTrace();
            TbsLogReport.getInstance(context).setInstallErrorCode(219, "exception when renameing from unzip:" + th5.toString());
            TbsLog.e("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip Exception", true);
        }
        e(context);
    }

    private void u(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromTpatch");
        if (!s(context)) {
            TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
            return;
        }
        try {
            v(context);
            x(context);
            m.a(context).b(0, -1);
            m.a(context).a("tpatch_num", 0);
            f369425n.set(0);
        } catch (Exception e16) {
            e16.printStackTrace();
            TbsLogReport.getInstance(context).setInstallErrorCode(242, "exception when renameing from tpatch:" + e16.toString());
        }
        e(context);
    }

    private void v(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--deleteOldCore");
        FileUtil.a(n(context), false, true);
    }

    private void w(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--renameShareDir");
        File b16 = b(context, 0);
        File n3 = n(context);
        if (b16 != null && n3 != null) {
            boolean renameTo = b16.renameTo(n3);
            if (renameTo && this.f369435q != null) {
                this.f369435q.onCoreRenameFinished(n3.listFiles(new FileFilter() { // from class: com.tencent.smtt.sdk.n.4
                    @Override // java.io.FileFilter
                    public boolean accept(File file) {
                        return file.getName().contains(".so");
                    }
                }));
            }
            TbsLog.i("TbsInstaller", "renameTbsCoreShareDir rename success=" + renameTo);
            e(context, false);
            return;
        }
        TbsLog.i("TbsInstaller", "renameTbsCoreShareDir return,tmpTbsCoreUnzipDir=" + b16 + "tbsSharePath=" + n3);
    }

    private void x(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--renameTbsTpatchCoreDir");
        File b16 = b(context, 5);
        File n3 = n(context);
        if (b16 != null && n3 != null) {
            if (b16.renameTo(n3) && this.f369435q != null) {
                this.f369435q.onCoreRenameFinished(n3.listFiles(new FileFilter() { // from class: com.tencent.smtt.sdk.n.5
                    @Override // java.io.FileFilter
                    public boolean accept(File file) {
                        return file.getName().contains(".so");
                    }
                }));
            }
            TbsLog.i("TbsInstaller", "setTmpFolderCoreToRead call #09");
            e(context, false);
        }
    }

    private void y(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--clearNewTbsCore");
        File b16 = b(context, 0);
        if (b16 != null) {
            FileUtil.a(b16, false);
        }
        m.a(context).c(0, 5);
        m.a(context).c(-1);
        QbSdk.a(context, "TbsInstaller::clearNewTbsCore forceSysWebViewInner!");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f(Context context) {
        BufferedInputStream bufferedInputStream = null;
        try {
            File file = new File(m(context), "tbs.conf");
            if (!file.exists()) {
                return 0;
            }
            Properties properties = new Properties();
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                properties.load(bufferedInputStream2);
                bufferedInputStream2.close();
                String property = properties.getProperty("tbs_core_version");
                if (property == null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException unused) {
                    }
                    return 0;
                }
                int parseInt = Integer.parseInt(property);
                try {
                    bufferedInputStream2.close();
                } catch (IOException unused2) {
                }
                return parseInt;
            } catch (Exception unused3) {
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                return 0;
            } catch (Throwable th5) {
                th = th5;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused5) {
                    }
                }
                throw th;
            }
        } catch (Exception unused6) {
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g(Context context) {
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                File file = new File(n(context), "tbs.conf");
                if (!file.exists()) {
                    return 0;
                }
                TbsLog.i("TbsInstaller", "getTbsCoreInstalledVerInNolock tbsPropFile is " + file.getAbsolutePath());
                Properties properties = new Properties();
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                try {
                    properties.load(bufferedInputStream2);
                    bufferedInputStream2.close();
                    String property = properties.getProperty("tbs_core_version");
                    if (property == null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e16) {
                            TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e16.toString());
                        }
                        return 0;
                    }
                    int parseInt = Integer.parseInt(property);
                    if (f369427p == 0) {
                        f369427p = parseInt;
                    }
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e17) {
                        TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e17.toString());
                    }
                    return parseInt;
                } catch (Exception e18) {
                    e = e18;
                    bufferedInputStream = bufferedInputStream2;
                    TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock Exception=" + e.toString());
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e19) {
                            TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e19.toString());
                        }
                    }
                    return 0;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e26) {
                            TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e26.toString());
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e27) {
            e = e27;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h(Context context) {
        int i3 = f369427p;
        if (i3 != 0) {
            return i3;
        }
        return g(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(Context context) {
        if (f369427p != 0) {
            return;
        }
        f369427p = g(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean j(Context context) {
        if (!new File(n(context), "tbs.conf").exists()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k(Context context) {
        if (!p(context)) {
            return -1;
        }
        ReentrantLock reentrantLock = f369422h;
        boolean tryLock = reentrantLock.tryLock();
        TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerWithLock locked=" + tryLock);
        if (tryLock) {
            BufferedInputStream bufferedInputStream = null;
            try {
                try {
                    File file = new File(n(context), "tbs.conf");
                    if (!file.exists()) {
                        try {
                            if (reentrantLock.isHeldByCurrentThread()) {
                                reentrantLock.unlock();
                            }
                        } catch (Throwable th5) {
                            TbsLog.e("TbsInstaller", "TbsRenameLock.unlock exception: " + th5);
                        }
                        c();
                        return 0;
                    }
                    Properties properties = new Properties();
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                    try {
                        properties.load(bufferedInputStream2);
                        bufferedInputStream2.close();
                        String property = properties.getProperty("tbs_core_version");
                        if (property == null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException e16) {
                                TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerWithLock IOException=" + e16.toString());
                            }
                            try {
                                ReentrantLock reentrantLock2 = f369422h;
                                if (reentrantLock2.isHeldByCurrentThread()) {
                                    reentrantLock2.unlock();
                                }
                            } catch (Throwable th6) {
                                TbsLog.e("TbsInstaller", "TbsRenameLock.unlock exception: " + th6);
                            }
                            c();
                            return 0;
                        }
                        ThreadLocal<Integer> threadLocal = f369425n;
                        threadLocal.set(Integer.valueOf(Integer.parseInt(property)));
                        int intValue = threadLocal.get().intValue();
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e17) {
                            TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerWithLock IOException=" + e17.toString());
                        }
                        try {
                            ReentrantLock reentrantLock3 = f369422h;
                            if (reentrantLock3.isHeldByCurrentThread()) {
                                reentrantLock3.unlock();
                            }
                        } catch (Throwable th7) {
                            TbsLog.e("TbsInstaller", "TbsRenameLock.unlock exception: " + th7);
                        }
                        c();
                        return intValue;
                    } catch (Exception e18) {
                        e = e18;
                        bufferedInputStream = bufferedInputStream2;
                        TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerWithLock Exception=" + e.toString());
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e19) {
                                TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerWithLock IOException=" + e19.toString());
                            }
                        }
                        try {
                            ReentrantLock reentrantLock4 = f369422h;
                            if (reentrantLock4.isHeldByCurrentThread()) {
                                reentrantLock4.unlock();
                            }
                        } catch (Throwable th8) {
                            TbsLog.e("TbsInstaller", "TbsRenameLock.unlock exception: " + th8);
                        }
                        c();
                        return 0;
                    } catch (Throwable th9) {
                        th = th9;
                        bufferedInputStream = bufferedInputStream2;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e26) {
                                TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerWithLock IOException=" + e26.toString());
                            }
                        }
                        try {
                            ReentrantLock reentrantLock5 = f369422h;
                            if (reentrantLock5.isHeldByCurrentThread()) {
                                reentrantLock5.unlock();
                            }
                        } catch (Throwable th10) {
                            TbsLog.e("TbsInstaller", "TbsRenameLock.unlock exception: " + th10);
                        }
                        c();
                        throw th;
                    }
                } catch (Throwable th11) {
                    th = th11;
                }
            } catch (Exception e27) {
                e = e27;
            }
        } else {
            c();
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--cleanStatusAndTmpDir");
        m.a(context).a(0);
        m.a(context).b(0);
        m.a(context).d(0);
        m.a(context).a("incrupdate_retry_num", 0);
        if (!TbsDownloader.a(context)) {
            m.a(context).c(0, -1);
            m.a(context).a("");
            m.a(context).a("copy_retry_num", 0);
            m.a(context).c(-1);
            m.a(context).a(0, -1);
            FileUtil.a(b(context, 0), true);
            FileUtil.a(b(context, 1), true);
        }
    }

    File m(Context context) {
        File file = new File(QbSdk.getTbsFolderDir(context), "core_share_decouple");
        if (!file.isDirectory() && !file.mkdir()) {
            return null;
        }
        return file;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File n(Context context) {
        File file = new File(QbSdk.getTbsFolderDir(context), "core_share");
        if (!file.isDirectory() && !file.mkdir()) {
            TbsLog.i("TbsInstaller", "getTbsCoreShareDir,mkdir false");
            return null;
        }
        return file;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean p(Context context) {
        if (this.f369428d > 0) {
            TbsLog.i("TbsInstaller", "getTbsInstallingFileLock success,is cached= true");
            this.f369428d++;
            return true;
        }
        FileOutputStream b16 = FileUtil.b(context, true, "tbslock.txt");
        this.f369430f = b16;
        if (b16 != null) {
            FileLock a16 = FileUtil.a(context, b16);
            this.f369429e = a16;
            if (a16 == null) {
                TbsLog.i("TbsInstaller", "getTbsInstallingFileLock tbsFileLockFileLock == null");
                return false;
            }
            TbsLog.i("TbsInstaller", "getTbsInstallingFileLock success,is cached= false");
            this.f369428d++;
            return true;
        }
        TbsLog.i("TbsInstaller", "getTbsInstallingFileLock get install fos failed");
        return false;
    }

    public final synchronized void b(boolean z16) {
        this.f369433l = z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Context context, boolean z16) {
        if (QbSdk.f368993c) {
            return;
        }
        TbsLog.i("TbsInstaller", "installTbsCoreIfNeeded", "#1# check local x5core prepared to install");
        if (r(context)) {
            TbsLog.i("TbsInstaller", "installTbsCoreIfNeeded", "#2# try to install tbs core from tmp dir");
            if (a(context, "core_unzip_tmp") && d(context, z16)) {
                TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromUnzip !!");
            } else if (a(context, "tpatch_tmp") && c(context, z16)) {
                TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromTpatch !!");
            } else {
                TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, error !!");
            }
        }
    }

    public int a(boolean z16, Context context) {
        if (z16 || f369425n.get().intValue() <= 0) {
            f369425n.set(Integer.valueOf(g(context)));
        }
        return f369425n.get().intValue();
    }

    public final void a(QbSdk.TbsInstallerCallBack tbsInstallerCallBack) {
        this.f369435q = tbsInstallerCallBack;
    }

    public final synchronized void a(boolean z16) {
        this.f369434m = z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, boolean z16) {
        int c16;
        int b16;
        String d16;
        int c17;
        int b17;
        boolean z17 = true;
        if (z16) {
            this.f369432j = true;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessId=" + Process.myPid());
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentThreadName=" + Thread.currentThread().getName());
        if (p(context)) {
            ReentrantLock reentrantLock = f369422h;
            if (reentrantLock.tryLock()) {
                try {
                    c16 = m.a(context).c();
                    b16 = m.a(context).b();
                    d16 = m.a(context).d("install_apk_path");
                    c17 = m.a(context).c("copy_core_ver");
                    b17 = m.a(context).b("copy_status");
                    reentrantLock.unlock();
                } catch (Throwable th5) {
                    f369422h.unlock();
                    throw th5;
                }
            } else {
                d16 = null;
                c16 = -1;
                b17 = -1;
                b16 = 0;
                c17 = 0;
            }
            c();
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore installStatus=" + c16);
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreInstallVer=" + b16);
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsApkPath=" + d16);
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreCopyVer=" + c17);
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore copyStatus=" + b17);
            int i3 = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, 0);
            if (i3 != 1 && i3 != 2 && i3 != 4) {
                z17 = false;
            }
            if (!z17 && i3 != 0 && i3 != 5) {
                Bundle bundle = new Bundle();
                bundle.putInt(QCircleDaTongConstant.ElementParamValue.OPERATION, 10001);
                a(context, bundle);
            }
            if (c16 <= -1 || c16 >= 2) {
                return;
            }
            a(context, d16, b16);
        }
    }

    public int b(Context context) {
        if (!r(context)) {
            return 0;
        }
        if (a(context, "core_unzip_tmp")) {
            return -1;
        }
        if (a(context, "core_share_backup_tmp")) {
            return -2;
        }
        if (a(context, "core_copy_tmp")) {
            return -3;
        }
        return a(context, "tpatch_tmp") ? -4 : 1;
    }

    public void e(Context context) {
        FileLock fileLock = f369424k;
        if (fileLock != null) {
            FileUtil.a(context, fileLock);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(11)
    public void b(Context context, String str, int i3) {
        boolean z16;
        int i16;
        String str2;
        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-501);
        if (c(context)) {
            TbsLog.i("TbsInstaller", "isTbsLocalInstalled --> no installation!", true);
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-502);
            QbSdk.f369006p.onInstallFinish(-502);
            return;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsApkPath=" + str);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreTargetVer=" + i3);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread currentProcessId=" + Process.myPid());
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread currentThreadName=" + Thread.currentThread().getName());
        if (!FileUtil.b(context)) {
            long a16 = com.tencent.smtt.utils.r.a();
            long downloadMinFreeSpace = TbsDownloadConfig.getInstance(context).getDownloadMinFreeSpace();
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-504);
            String str3 = "rom is not enough when installing tbs core! curAvailROM=" + a16 + ",minReqRom=" + downloadMinFreeSpace;
            TbsLogReport.getInstance(context).setInstallErrorCode(210, str3);
            TbsLog.i("TbsInstaller", str3);
            QbSdk.f369006p.onInstallFinish(210);
            return;
        }
        if (!p(context)) {
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-505);
            TbsLog.i("TbsInstaller", "getInstalling file lock failed,return!");
            QbSdk.f369006p.onInstallFinish(-505);
            return;
        }
        Lock lock = f369423i;
        boolean tryLock = lock.tryLock();
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread locked =" + tryLock);
        if (tryLock) {
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-507);
            ReentrantLock reentrantLock = f369422h;
            reentrantLock.lock();
            try {
                int c16 = m.a(context).c("copy_core_ver");
                int b16 = m.a(context).b();
                TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreCopyVer =" + c16);
                TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreInstallVer =" + b16);
                TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreTargetVer =" + i3);
                if ((b16 > 0 && i3 > b16) || (c16 > 0 && i3 > c16)) {
                    l(context);
                }
                int c17 = m.a(context).c();
                int g16 = g(context);
                TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread installStatus1=" + c17);
                TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreInstalledVer=" + g16);
                if (c17 >= 0 && c17 < 2) {
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- retry.....", true);
                    z16 = true;
                } else {
                    if (c17 == 3 && g16 >= 0 && (i3 > g16 || this.f369434m)) {
                        l(context);
                        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- update TBS.....", true);
                        c17 = -1;
                    }
                    z16 = false;
                }
                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-508);
                TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread installStatus2=" + c17);
                if (c17 < 1) {
                    TbsLog.i("TbsInstaller", "STEP 2/2 begin installation.....", true);
                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-509);
                    if (z16) {
                        int c18 = m.a(context).c("unzip_retry_num");
                        if (c18 > 10) {
                            TbsLogReport.getInstance(context).setInstallErrorCode(201, "exceed unzip retry num!");
                            y(context);
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-510);
                            try {
                                reentrantLock.unlock();
                                lock.unlock();
                            } catch (Exception e16) {
                                e16.printStackTrace();
                            }
                            try {
                                c();
                                return;
                            } catch (Exception e17) {
                                e17.printStackTrace();
                                e17.printStackTrace();
                                return;
                            }
                        }
                        m.a(context).b(c18 + 1);
                    }
                    if (str == null) {
                        str2 = m.a(context).d("install_apk_path");
                        if (str2 == null) {
                            TbsLogReport.getInstance(context).setInstallErrorCode(202, "apk path is null!");
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-511);
                            try {
                                reentrantLock.unlock();
                                lock.unlock();
                            } catch (Exception e18) {
                                e18.printStackTrace();
                            }
                            try {
                                c();
                                return;
                            } catch (Exception e19) {
                                e19.printStackTrace();
                                e19.printStackTrace();
                                return;
                            }
                        }
                    } else {
                        str2 = str;
                    }
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread apkPath =" + str2);
                    i16 = b(context, str2);
                    if (i16 == 0) {
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-512);
                        TbsLogReport.getInstance(context).setInstallErrorCode(203, "apk version is 0!");
                        try {
                            reentrantLock.unlock();
                            lock.unlock();
                        } catch (Exception e26) {
                            e26.printStackTrace();
                        }
                        try {
                            c();
                            return;
                        } catch (Exception e27) {
                            e27.printStackTrace();
                            e27.printStackTrace();
                            return;
                        }
                    }
                    m.a(context).a("install_apk_path", str2);
                    m.a(context).c(i16, 0);
                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-548);
                    if (!b(context, new File(str2))) {
                        TbsLogReport.getInstance(context).setInstallErrorCode(207, "unzipTbsApk failed");
                        try {
                            reentrantLock.unlock();
                            lock.unlock();
                        } catch (Exception e28) {
                            e28.printStackTrace();
                        }
                        try {
                            c();
                            return;
                        } catch (Exception e29) {
                            e29.printStackTrace();
                            e29.printStackTrace();
                            return;
                        }
                    }
                    if (z16) {
                        int b17 = m.a(context).b("unlzma_status");
                        if (b17 > 5) {
                            TbsLogReport.getInstance(context).setInstallErrorCode(223, "exceed unlzma retry num!");
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-553);
                            y(context);
                            l.b(context);
                            Map<String, Object> map = TbsDownloadConfig.getInstance(context).mSyncMap;
                            Boolean bool = Boolean.TRUE;
                            map.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, bool);
                            TbsDownloadConfig.getInstance(context).mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_FULL_PACKAGE, bool);
                            TbsDownloadConfig.getInstance(context).commit();
                            try {
                                reentrantLock.unlock();
                                lock.unlock();
                            } catch (Exception e36) {
                                e36.printStackTrace();
                            }
                            try {
                                c();
                                return;
                            } catch (Exception e37) {
                                e37.printStackTrace();
                                e37.printStackTrace();
                                return;
                            }
                        }
                        m.a(context).d(b17 + 1);
                    }
                    m.a(context).c(i16, 1);
                } else {
                    i16 = 0;
                }
                if (c17 < 2) {
                    if (z16) {
                        int c19 = m.a(context).c("dexopt_retry_num");
                        if (c19 > 10) {
                            TbsLogReport.getInstance(context).setInstallErrorCode(208, "exceed dexopt retry num!");
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-514);
                            y(context);
                            try {
                                reentrantLock.unlock();
                                lock.unlock();
                            } catch (Exception e38) {
                                e38.printStackTrace();
                            }
                            try {
                                c();
                                return;
                            } catch (Exception e39) {
                                e39.printStackTrace();
                                e39.printStackTrace();
                                return;
                            }
                        }
                        m.a(context).a(c19 + 1);
                    }
                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-549);
                    if (!d(context, 0)) {
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-515);
                        try {
                            reentrantLock.unlock();
                            lock.unlock();
                        } catch (Exception e46) {
                            e46.printStackTrace();
                        }
                        try {
                            c();
                            return;
                        } catch (Exception e47) {
                            e47.printStackTrace();
                            e47.printStackTrace();
                            return;
                        }
                    }
                    m.a(context).c(i16, 2);
                    TbsLog.i("TbsInstaller", "STEP 2/2 installation completed! you can restart!", true);
                    TbsLog.i("TbsInstaller", "STEP 2/2 installation completed! you can restart! version:" + i3);
                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-516);
                    try {
                        SharedPreferences.Editor edit = context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4).edit();
                        edit.putInt("tbs_preload_x5_counter", 0);
                        edit.putInt("tbs_preload_x5_recorder", 0);
                        edit.putInt("tbs_preload_x5_version", i3);
                        edit.commit();
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-517);
                    } catch (Throwable th5) {
                        TbsLog.e("TbsInstaller", "Init tbs_preload_x5_counter#1 exception:" + Log.getStackTraceString(th5));
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-518);
                    }
                    if (i3 == 88888888) {
                        a(i3, str, context);
                    }
                    if (this.f369432j) {
                        TbsLogReport.getInstance(context).setInstallErrorCode(q(context), "continueInstallWithout core success");
                    } else {
                        if (str != null && this.f369433l) {
                            FileUtil.b(new File(str));
                        }
                        TbsLogReport.getInstance(context).setInstallErrorCode(q(context), "success");
                    }
                } else if (c17 == 2) {
                    if (str != null && this.f369433l) {
                        FileUtil.b(new File(str));
                    }
                    QbSdk.f369006p.onInstallFinish(200);
                }
                try {
                    f369422h.unlock();
                    f369423i.unlock();
                } catch (Exception e48) {
                    e48.printStackTrace();
                }
                try {
                    c();
                } catch (Exception e49) {
                    e49.printStackTrace();
                    e49.printStackTrace();
                }
            } finally {
            }
        } else {
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-519);
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(Context context) {
        File file = new File(n(context), "tbs.conf");
        boolean z16 = false;
        if (!file.exists()) {
            return false;
        }
        Properties properties = new Properties();
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                properties.load(bufferedInputStream2);
                boolean booleanValue = Boolean.valueOf(properties.getProperty("tbs_local_installation", "false")).booleanValue();
                if (booleanValue) {
                    try {
                        if (System.currentTimeMillis() - file.lastModified() > 259200000) {
                            z16 = true;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        z16 = booleanValue;
                        bufferedInputStream = bufferedInputStream2;
                        try {
                            th.printStackTrace();
                            return z16;
                        } finally {
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e16) {
                                    e16.printStackTrace();
                                }
                            }
                        }
                    }
                }
                TbsLog.i("TbsInstaller", "TBS_LOCAL_INSTALLATION is:" + booleanValue + " expired=" + z16);
                boolean z17 = booleanValue & (!z16);
                try {
                    bufferedInputStream2.close();
                    return z17;
                } catch (IOException e17) {
                    e17.printStackTrace();
                    return z17;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }

    public void d(Context context) {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        try {
            File file = new File(n(context), "tbs.conf");
            Properties properties = new Properties();
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    properties.load(bufferedInputStream);
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                bufferedInputStream = null;
            }
            try {
                properties.setProperty("tbs_local_installation", "false");
                properties.store(bufferedOutputStream, (String) null);
                try {
                    bufferedOutputStream.close();
                } catch (IOException unused3) {
                }
            } catch (Throwable unused4) {
                bufferedOutputStream2 = bufferedOutputStream;
                if (bufferedOutputStream2 != null) {
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException unused5) {
                    }
                }
                if (bufferedInputStream == null) {
                    return;
                }
                bufferedInputStream.close();
            }
            bufferedInputStream.close();
        } catch (Throwable unused6) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0099 A[Catch: Exception -> 0x00ab, TryCatch #1 {Exception -> 0x00ab, blocks: (B:7:0x0021, B:10:0x0037, B:17:0x006b, B:20:0x0074, B:26:0x008a, B:28:0x0090, B:31:0x0099, B:34:0x00a0, B:40:0x0061, B:41:0x003c, B:42:0x0041, B:45:0x0048, B:12:0x004c, B:14:0x0055), top: B:2:0x001a, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a0 A[Catch: Exception -> 0x00ab, TRY_LEAVE, TryCatch #1 {Exception -> 0x00ab, blocks: (B:7:0x0021, B:10:0x0037, B:17:0x006b, B:20:0x0074, B:26:0x008a, B:28:0x0090, B:31:0x0099, B:34:0x00a0, B:40:0x0061, B:41:0x003c, B:42:0x0041, B:45:0x0048, B:12:0x004c, B:14:0x0055), top: B:2:0x001a, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean d(Context context, int i3) {
        File b16;
        boolean z16;
        String property;
        TbsLog.i("TbsInstaller", "TbsInstaller-doTbsDexOpt start - dirMode: " + i3);
        boolean z17 = false;
        try {
            if (i3 != 0) {
                if (i3 == 1) {
                    b16 = b(context, 1);
                } else {
                    if (i3 != 2) {
                        TbsLog.e("TbsInstaller", "doDexoptOrDexoat mode error: " + i3);
                        return false;
                    }
                    b16 = n(context);
                }
            } else {
                if (TbsDownloader.a(context)) {
                    return true;
                }
                b16 = b(context, 0);
            }
            try {
                property = System.getProperty("java.vm.version");
            } catch (Throwable th5) {
                TbsLogReport.getInstance(context).setInstallErrorCode(226, th5);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            TbsLogReport.getInstance(context).setInstallErrorCode(209, e16.toString());
        }
        if (property != null) {
            if (property.startsWith("2")) {
                z16 = true;
                boolean z18 = Build.VERSION.SDK_INT != 23;
                boolean z19 = TbsDownloadConfig.getInstance(context).mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_STOP_PRE_OAT, false);
                if (z16 && z18 && !z19) {
                    z17 = true;
                }
                if (!z17 && d(context, b16)) {
                    TbsLog.i("TbsInstaller", "doTbsDexOpt -- doDexoatForArtVm");
                    return true;
                }
                if (!z16) {
                    TbsLog.i("TbsInstaller", "doTbsDexOpt -- is ART mode, skip!");
                    TbsLog.i("TbsInstaller", "TbsInstaller-doTbsDexOpt done");
                    return true;
                }
                TbsLog.i("TbsInstaller", "doTbsDexOpt -- doDexoptForDavlikVM");
                return c(context, b16);
            }
        }
        z16 = false;
        if (Build.VERSION.SDK_INT != 23) {
        }
        boolean z192 = TbsDownloadConfig.getInstance(context).mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_STOP_PRE_OAT, false);
        if (z16) {
            z17 = true;
        }
        if (!z17) {
        }
        if (!z16) {
        }
    }

    public static void a(Context context) {
        if (r(context)) {
            return;
        }
        if (a(context, "core_unzip_tmp")) {
            TbsCoreLoadStat.getInstance().a(context, 417, new Throwable("TMP_TBS_UNZIP_FOLDER_NAME"));
            TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_UNZIP_FOLDER_NAME");
        } else if (a(context, "core_share_backup_tmp")) {
            TbsCoreLoadStat.getInstance().a(context, 417, new Throwable("TMP_BACKUP_TBSCORE_FOLDER_NAME"));
            TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_BACKUP_TBSCORE_FOLDER_NAME");
        } else if (a(context, "core_copy_tmp")) {
            TbsCoreLoadStat.getInstance().a(context, 417, new Throwable("TMP_TBS_COPY_FOLDER_NAME"));
            TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_COPY_FOLDER_NAME");
        }
    }

    private void c(Context context, int i3) {
        TbsLog.i("TbsInstaller", "proceedTpatchStatus,result=" + i3);
        if (i3 != 0) {
            return;
        }
        TbsLog.i("TbsInstaller", "setTmpFolderCoreToRead call #03");
        e(context, true);
        m.a(context).b(TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0), 1);
    }

    private int c(Context context, Bundle bundle) {
        try {
            Bundle a16 = QbSdk.a(context, bundle);
            TbsLog.i("TbsInstaller", "tpatch finished,ret is" + a16);
            int i3 = a16.getInt("patch_result");
            if (i3 == 0) {
                String string = bundle.getString("new_apk_location");
                int i16 = bundle.getInt("new_core_ver");
                int a17 = a(new File(string));
                TbsLog.i("TbsInstaller", "doTpatch version is " + i16 + " patchVersion is " + a17);
                if (i16 != a17) {
                    TbsLog.i("TbsInstaller", "version not equals!!!" + i16 + "patchVersion:" + a17);
                    TbsLogReport.getInstance(context).setInstallErrorCode(240, "version=" + i16 + ",patchVersion=" + a17);
                    return 1;
                }
                TbsLog.i("TbsInstaller", "Tpatch success!");
                TbsLogReport.getInstance(context).setInstallErrorCode(236, "");
                return 0;
            }
            String string2 = bundle.getString("new_apk_location");
            if (!TextUtils.isEmpty(string2)) {
                FileUtil.b(new File(string2));
            }
            TbsLogReport.getInstance(context).setInstallErrorCode(i3, "tpatch fail,patch error_code=" + i3);
            return 1;
        } catch (Exception e16) {
            e16.printStackTrace();
            TbsLogReport.getInstance(context).setInstallErrorCode(239, "patch exception" + Log.getStackTraceString(e16));
            return 1;
        }
    }

    static boolean a(Context context, String str) {
        File file = new File(QbSdk.getTbsFolderDir(context), str);
        if (!file.exists()) {
            TbsLog.i("TbsInstaller", "isPrepareTbsCore", "#1# " + str);
            return false;
        }
        if (!new File(file, "tbs.conf").exists()) {
            TbsLog.i("TbsInstaller", "isPrepareTbsCore", "#2# " + str);
            return false;
        }
        TbsLog.i("TbsInstaller", "isPrepareTbsCore", "#3# " + str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, String str, int i3) {
        TbsLog.i("TbsInstaller", "installTbsCore Path: " + str + ";Ver: " + i3 + "\npn: " + context.getApplicationInfo().processName + "\npid: " + Process.myPid() + "\ntn: " + Thread.currentThread().getName());
        Object[] objArr = {context.getApplicationContext(), str, Integer.valueOf(i3)};
        Message message = new Message();
        message.what = 1;
        message.obj = objArr;
        f369426o.sendMessage(message);
    }

    private boolean d(Context context, File file) {
        try {
            File file2 = new File(file, "tbs_sdk_extension_dex.jar");
            File file3 = new File(file, "tbs_sdk_extension_dex.dex");
            ClassLoader classLoader = context.getClassLoader();
            file2.setReadOnly();
            new DexClassLoader(file2.getAbsolutePath(), file.getAbsolutePath(), null, classLoader);
            String a16 = d.a(context, file3.getAbsolutePath());
            if (TextUtils.isEmpty(a16)) {
                TbsLogReport.getInstance(context).setInstallErrorCode(226, "can not find oat command");
                return false;
            }
            for (File file4 : file.listFiles(new FileFilter() { // from class: com.tencent.smtt.sdk.n.7
                @Override // java.io.FileFilter
                public boolean accept(File file5) {
                    return file5.getName().endsWith(QZonePatchService.PATCH_SUFFIX);
                }
            })) {
                String substring = file4.getName().substring(0, r5.getName().length() - 4);
                RuntimeMonitor.exec(Runtime.getRuntime(), "/system/bin/dex2oat " + a16.replaceAll("tbs_sdk_extension_dex", substring) + " --dex-location=" + a().n(context) + File.separator + substring + QZonePatchService.PATCH_SUFFIX).waitFor();
            }
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            TbsLogReport.getInstance(context).setInstallErrorCode(226, e16);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void c() {
        int i3 = this.f369428d;
        if (i3 <= 0) {
            TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock currentTbsFileLockStackCount=" + this.f369428d + "call stack:" + Log.getStackTraceString(new Throwable()));
            return;
        }
        if (i3 > 1) {
            TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock with skip");
            this.f369428d--;
        } else {
            if (i3 == 1) {
                TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock without skip");
                FileUtil.a(this.f369429e, this.f369430f);
                this.f369428d = 0;
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x0097 -> B:15:0x00b1). Please report as a decompilation issue!!! */
    private void a(int i3, String str, Context context) {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        new File(str).delete();
        TbsLog.i("TbsInstaller", "Local tbs apk(" + str + ") is deleted!", true);
        File file = new File(QbSdk.getTbsFolderDir(context), "core_unzip_tmp");
        if (file.canRead()) {
            File file2 = new File(file, "tbs.conf");
            Properties properties = new Properties();
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file2));
                    try {
                        properties.load(bufferedInputStream);
                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                    } catch (Throwable th5) {
                        th = th5;
                    }
                    try {
                        properties.setProperty("tbs_local_installation", "true");
                        properties.store(bufferedOutputStream, (String) null);
                        TbsLog.i("TbsInstaller", "TBS_LOCAL_INSTALLATION is set!", true);
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e16) {
                            e16.printStackTrace();
                        }
                        bufferedInputStream.close();
                    } catch (Throwable th6) {
                        th = th6;
                        bufferedOutputStream2 = bufferedOutputStream;
                        try {
                            th.printStackTrace();
                            if (bufferedOutputStream2 != null) {
                                try {
                                    bufferedOutputStream2.close();
                                } catch (IOException e17) {
                                    e17.printStackTrace();
                                }
                            }
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                        } finally {
                        }
                    }
                } catch (Throwable th7) {
                    th = th7;
                    bufferedInputStream = null;
                }
            } catch (IOException e18) {
                e18.printStackTrace();
            }
        }
    }

    private boolean c(Context context, File file) {
        try {
            File[] listFiles = file.listFiles(new FileFilter() { // from class: com.tencent.smtt.sdk.n.6
                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    return file2.getName().endsWith(QZonePatchService.PATCH_SUFFIX);
                }
            });
            ClassLoader classLoader = context.getClassLoader();
            for (File file2 : listFiles) {
                TbsLog.i("TbsInstaller", "jarFile: " + file2.getAbsolutePath());
                file2.setReadOnly();
                new DexClassLoader(file2.getAbsolutePath(), file.getAbsolutePath(), null, classLoader);
            }
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            TbsLogReport.getInstance(context).setInstallErrorCode(209, e16.toString());
            TbsLog.i("TbsInstaller", "TbsInstaller-doTbsDexOpt done");
            return false;
        }
    }

    void a(Context context, Bundle bundle) {
        if (bundle == null || context == null) {
            return;
        }
        Object[] objArr = {context.getApplicationContext(), bundle};
        Message message = new Message();
        message.what = 3;
        message.obj = objArr;
        f369426o.sendMessage(message);
    }

    private boolean a(Context context, File file, boolean z16) {
        File b16;
        File file2;
        TbsLog.i("TbsInstaller", "TbsInstaller-unzipTbs start isDecoupleCore is " + z16);
        if (!FileUtil.c(file)) {
            TbsLogReport.getInstance(context).setInstallErrorCode(204, "apk is invalid!");
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-520);
            return false;
        }
        try {
            File tbsFolderDir = QbSdk.getTbsFolderDir(context);
            if (z16) {
                file2 = new File(tbsFolderDir, "core_share_decouple");
            } else {
                file2 = new File(tbsFolderDir, "core_unzip_tmp");
            }
            if (file2.exists() && !TbsDownloader.a(context)) {
                FileUtil.b(file2);
            }
        } catch (Throwable th5) {
            TbsLog.e("TbsInstaller", "TbsInstaller-unzipTbs -- delete unzip folder if exists exception" + Log.getStackTraceString(th5));
        }
        if (z16) {
            b16 = b(context, 2);
        } else {
            b16 = b(context, 0);
        }
        if (b16 == null) {
            TbsLogReport.getInstance(context).setInstallErrorCode(205, "tmp unzip dir is null!");
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-521);
            return false;
        }
        try {
            FileUtil.a(b16);
            if (z16) {
                FileUtil.a(b16, true);
            }
            boolean a16 = FileUtil.a(file, b16);
            if (a16) {
                a16 = a(b16, context);
            }
            if (z16) {
                for (String str : b16.list()) {
                    File file3 = new File(b16, str);
                    if (file3.getName().endsWith(QZonePatchService.PATCH_SUFFIX_DEX)) {
                        file3.delete();
                    }
                }
                try {
                    new File(o(context), "x5.tbs").delete();
                } catch (Exception unused) {
                }
            }
            if (!a16) {
                FileUtil.b(b16);
                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-522);
                TbsLog.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#1! exist:" + b16.exists());
            } else {
                TbsLog.i("TbsInstaller", "setTmpFolderCoreToRead call #05");
                e(context, true);
            }
            return a16;
        } catch (IOException e16) {
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-523);
            TbsLogReport.getInstance(context).setInstallErrorCode(206, e16);
            if (b16.exists()) {
                try {
                    FileUtil.b(b16);
                    TbsLog.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exist:" + b16.exists());
                } catch (Throwable th6) {
                    TbsLog.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exception:" + Log.getStackTraceString(th6));
                }
            }
            return false;
        } catch (Exception e17) {
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-523);
            TbsLogReport.getInstance(context).setInstallErrorCode(207, e17);
            if (b16.exists()) {
                try {
                    FileUtil.b(b16);
                    TbsLog.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exist:" + b16.exists());
                } catch (Throwable th7) {
                    TbsLog.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exception:" + Log.getStackTraceString(th7));
                }
            }
            return false;
        } finally {
            TbsLog.i("TbsInstaller", "TbsInstaller-unzipTbs done");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0160 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(File file, Context context) {
        Properties properties;
        Exception e16;
        BufferedInputStream bufferedInputStream;
        boolean z16;
        boolean z17;
        TbsLog.i("TbsInstaller", "finalCheckForTbsCoreValidity - " + file + ", " + context);
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                File file2 = new File(file, "1");
                properties = new Properties();
                try {
                    if (file2.exists()) {
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(file2));
                        try {
                            try {
                                properties.load(bufferedInputStream);
                                bufferedInputStream2 = bufferedInputStream;
                                z16 = true;
                            } catch (Throwable th5) {
                                th = th5;
                                bufferedInputStream2 = bufferedInputStream;
                                if (bufferedInputStream2 != null) {
                                }
                                throw th;
                            }
                        } catch (Exception e17) {
                            e16 = e17;
                            e16.printStackTrace();
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e18) {
                                    e18.printStackTrace();
                                }
                            }
                            z16 = true;
                            TbsLog.i("TbsInstaller", "finalCheckForTbsCoreValidity - need_check:" + z16);
                            if (z16) {
                            }
                            z17 = true;
                            TbsLog.i("TbsInstaller", "finalCheckForTbsCoreValidity - md5_check_success:" + z17);
                            if (!z16) {
                            }
                            TbsLog.i("TbsInstaller", "finalCheckForTbsCoreValidity success!");
                            return true;
                        }
                    } else {
                        z16 = false;
                    }
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                        }
                    }
                } catch (Exception e26) {
                    bufferedInputStream = null;
                    e16 = e26;
                }
            } catch (Throwable th6) {
                th = th6;
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e27) {
                        e27.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e28) {
            properties = null;
            e16 = e28;
            bufferedInputStream = null;
        }
        TbsLog.i("TbsInstaller", "finalCheckForTbsCoreValidity - need_check:" + z16);
        if (z16) {
            for (File file3 : file.listFiles()) {
                if (!"1".equals(file3.getName()) && !file3.getName().endsWith(QZonePatchService.PATCH_SUFFIX_DEX) && !"tbs.conf".equals(file3.getName()) && !file3.isDirectory() && !file3.getName().endsWith(".prof")) {
                    String a16 = com.tencent.smtt.utils.a.a(file3);
                    String property = properties.getProperty(file3.getName(), "");
                    if (property.equals("") || !property.equals(a16)) {
                        TbsLog.e("TbsInstaller", "md5_check_failure for (" + file3.getName() + ") targetMd5:" + property + ", realMd5:" + a16);
                        z17 = false;
                        break;
                    }
                    TbsLog.i("TbsInstaller", "md5_check_success for (" + file3.getName() + ")");
                }
            }
        }
        z17 = true;
        TbsLog.i("TbsInstaller", "finalCheckForTbsCoreValidity - md5_check_success:" + z17);
        if (!z16 && !z17) {
            TbsLog.e("TbsInstaller", "finalCheckForTbsCoreValidity - Verify failed after unzipping!");
            return false;
        }
        TbsLog.i("TbsInstaller", "finalCheckForTbsCoreValidity success!");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(Context context, int i3) {
        return a(b(context, i3));
    }

    int a(File file) {
        BufferedInputStream bufferedInputStream = null;
        try {
            TbsLog.i("TbsInstaller", "TbsInstaller--getTbsVersion  tbsShareDir is " + file);
            File file2 = new File(file, "tbs.conf");
            if (!file2.exists()) {
                return 0;
            }
            Properties properties = new Properties();
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file2));
            try {
                properties.load(bufferedInputStream2);
                bufferedInputStream2.close();
                String property = properties.getProperty("tbs_core_version");
                if (property == null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException unused) {
                    }
                    return 0;
                }
                int parseInt = Integer.parseInt(property);
                try {
                    bufferedInputStream2.close();
                } catch (IOException unused2) {
                }
                return parseInt;
            } catch (Exception unused3) {
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                return 0;
            } catch (Throwable th5) {
                th = th5;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused5) {
                    }
                }
                throw th;
            }
        } catch (Exception unused6) {
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0101 A[Catch: all -> 0x0254, Exception -> 0x0256, TryCatch #0 {all -> 0x0254, blocks: (B:22:0x00cc, B:27:0x00d6, B:29:0x00dc, B:40:0x00f7, B:42:0x0101, B:44:0x0122, B:45:0x012a, B:47:0x0130, B:48:0x0138, B:50:0x013e, B:51:0x0146, B:57:0x0176, B:59:0x0184, B:61:0x0192, B:64:0x01c9, B:66:0x01d2, B:73:0x0257, B:84:0x0208, B:90:0x021a, B:92:0x0235), top: B:21:0x00cc }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0176 A[Catch: all -> 0x0254, Exception -> 0x0256, TRY_ENTER, TryCatch #0 {all -> 0x0254, blocks: (B:22:0x00cc, B:27:0x00d6, B:29:0x00dc, B:40:0x00f7, B:42:0x0101, B:44:0x0122, B:45:0x012a, B:47:0x0130, B:48:0x0138, B:50:0x013e, B:51:0x0146, B:57:0x0176, B:59:0x0184, B:61:0x0192, B:64:0x01c9, B:66:0x01d2, B:73:0x0257, B:84:0x0208, B:90:0x021a, B:92:0x0235), top: B:21:0x00cc }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0200  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(Context context, Bundle bundle) {
        boolean z16;
        int c16;
        TbsLog.i("TbsInstaller", "TbsInstaller installLocalTbsCoreExInThreadthread " + Thread.currentThread().getName() + Log.getStackTraceString(new Throwable()));
        if (c(context)) {
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-539);
            return;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread");
        if (bundle == null || context == null) {
            return;
        }
        if (!FileUtil.b(context)) {
            long a16 = com.tencent.smtt.utils.r.a();
            long downloadMinFreeSpace = TbsDownloadConfig.getInstance(context).getDownloadMinFreeSpace();
            TbsLogReport.getInstance(context).setInstallErrorCode(210, "rom is not enough when patching tbs core! curAvailROM=" + a16 + ",minReqRom=" + downloadMinFreeSpace);
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-540);
            return;
        }
        if (!p(context)) {
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-541);
            return;
        }
        Lock lock = f369423i;
        boolean tryLock = lock.tryLock();
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread locked=" + tryLock);
        if (tryLock) {
            int i3 = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, 0);
            int i16 = 2;
            try {
            } catch (Throwable th5) {
                th = th5;
                i16 = 1;
            }
            try {
                try {
                    QbSdk.setTBSInstallingStatus(true);
                } catch (Exception e16) {
                    e = e16;
                }
                if (i3 != 5 && i3 != 3) {
                    if (g(context) > 0 && m.a(context).d() != 1) {
                        if (i3 != 1 && i3 != 2 && i3 != 4) {
                            z16 = false;
                            if (!z16 && i3 != 0) {
                                c16 = m.a(context).c("incrupdate_retry_num");
                                if (c16 <= 5) {
                                    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread exceed incrupdate num");
                                    String string = bundle.getString("old_apk_location");
                                    String string2 = bundle.getString("new_apk_location");
                                    String string3 = bundle.getString("diff_file_location");
                                    if (!TextUtils.isEmpty(string)) {
                                        FileUtil.b(new File(string));
                                    }
                                    if (!TextUtils.isEmpty(string2)) {
                                        FileUtil.b(new File(string2));
                                    }
                                    if (!TextUtils.isEmpty(string3)) {
                                        FileUtil.b(new File(string3));
                                    }
                                    TbsDownloadConfig.getInstance(context).mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.TRUE);
                                    TbsDownloadConfig.getInstance(context).commit();
                                    TbsLogReport.getInstance(context).setInstallErrorCode(224, "incrUpdate exceed retry max num");
                                    lock.unlock();
                                    c();
                                    if (i3 == 5) {
                                        c(context, 2);
                                    }
                                    QbSdk.setTBSInstallingStatus(false);
                                    return;
                                }
                                m.a(context).a("incrupdate_retry_num", c16 + 1);
                                File o16 = o(context);
                                if (o16 != null && new File(o16, "x5.tbs").exists()) {
                                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-550);
                                    Bundle a17 = QbSdk.a(context, bundle);
                                    if (a17 == null) {
                                        try {
                                            TbsLogReport.getInstance(context).setInstallErrorCode(228, "result null : " + bundle.getInt("new_core_ver"));
                                            i16 = 1;
                                        } catch (Exception e17) {
                                            e = e17;
                                            TbsLog.i("TbsInstaller", "installLocalTbsCoreExInThread exception:" + Log.getStackTraceString(e));
                                            e.printStackTrace();
                                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-543);
                                            TbsLogReport.getInstance(context).setInstallErrorCode(218, e.toString());
                                            f369423i.unlock();
                                            c();
                                            if (i3 == 5) {
                                                c(context, 1);
                                            }
                                            QbSdk.setTBSInstallingStatus(false);
                                            return;
                                        }
                                    } else {
                                        i16 = a17.getInt("patch_result");
                                        if (i16 != 0) {
                                            TbsLogReport.getInstance(context).setInstallErrorCode(228, "result " + i16 + ProgressTracer.SEPARATOR + bundle.getInt("new_core_ver"));
                                        }
                                    }
                                }
                            }
                            lock.unlock();
                            c();
                            if (i3 == 5) {
                                c(context, i16);
                            }
                            QbSdk.setTBSInstallingStatus(false);
                            return;
                        }
                        z16 = true;
                        if (!z16) {
                            c16 = m.a(context).c("incrupdate_retry_num");
                            if (c16 <= 5) {
                            }
                        }
                        lock.unlock();
                        c();
                        if (i3 == 5) {
                        }
                        QbSdk.setTBSInstallingStatus(false);
                        return;
                    }
                    QbSdk.setTBSInstallingStatus(false);
                    lock.unlock();
                    c();
                    if (i3 == 5) {
                        c(context, 2);
                    }
                    QbSdk.setTBSInstallingStatus(false);
                    return;
                }
                int c17 = c(context, bundle);
                TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread doTpatch result is " + c17);
                if (c17 == 1) {
                    m.a(context).a("tpatch_num", m.a(context).c("tpatch_num") + 1);
                }
                lock.unlock();
                c();
                if (i3 == 5) {
                    c(context, c17);
                }
                QbSdk.setTBSInstallingStatus(false);
                return;
            } catch (Throwable th6) {
                th = th6;
                f369423i.unlock();
                c();
                if (i3 == 5) {
                    c(context, i16);
                }
                QbSdk.setTBSInstallingStatus(false);
                throw th;
            }
        }
        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-547);
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File a(Context context, File file) {
        File file2 = new File(file, "core_share_decouple");
        if (file2.isDirectory() || file2.mkdir()) {
            return file2;
        }
        return null;
    }

    File a(Context context, int i3, boolean z16) {
        String str;
        File tbsFolderDir = QbSdk.getTbsFolderDir(context);
        switch (i3) {
            case 0:
                str = "core_unzip_tmp";
                break;
            case 1:
                str = "core_copy_tmp";
                break;
            case 2:
                str = "core_unzip_tmp_decouple";
                break;
            case 3:
                str = "core_share_backup";
                break;
            case 4:
                str = "core_share_backup_tmp";
                break;
            case 5:
                str = "tpatch_tmp";
                break;
            case 6:
                str = "tpatch_decouple_tmp";
                break;
            default:
                str = "";
                break;
        }
        TbsLog.i("TbsInstaller", "type=" + i3 + "needMakeDir=" + z16 + "folder=" + str);
        File file = new File(tbsFolderDir, str);
        if (!file.isDirectory()) {
            if (z16) {
                if (!file.mkdir()) {
                    TbsLog.i("TbsInstaller", "getCoreDir,mkdir false");
                    return null;
                }
            } else {
                TbsLog.i("TbsInstaller", "getCoreDir,no need mkdir");
                return null;
            }
        }
        return file;
    }

    private boolean b(Context context, File file) {
        return a(context, file, false);
    }

    int b(Context context, String str) {
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 0);
        if (packageArchiveInfo != null) {
            return packageArchiveInfo.versionCode;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File b(Context context, int i3) {
        return a(context, i3, true);
    }
}
