package cooperation.plugin;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.DexReleasor;
import com.tencent.commonsdk.soload.SoLoadCore;
import com.tencent.commonsdk.zip.QZipFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.message.cleanup.tool.PluginCleanUpThoroughCacheTool;
import com.tencent.mobileqq.pluginsdk.PluginConst;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qshadow.core.QShadow;
import com.tencent.mobileqq.qshadow.utils.PluginIdUtil;
import com.tencent.mobileqq.qshadow.utils.QShadowRepository;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.er;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.Constant;
import cooperation.plugin.Dex2Oat;
import cooperation.qzone.util.RecycleableBufferedOutputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.zip.ZipEntry;

/* compiled from: P */
/* loaded from: classes28.dex */
public class f implements Handler.Callback {
    public static HandlerThread C;
    public static String D = Build.FINGERPRINT;

    /* renamed from: d, reason: collision with root package name */
    private boolean f390274d;

    /* renamed from: e, reason: collision with root package name */
    private Context f390275e;

    /* renamed from: f, reason: collision with root package name */
    private String f390276f;

    /* renamed from: i, reason: collision with root package name */
    private cooperation.plugin.a f390278i;

    /* renamed from: h, reason: collision with root package name */
    private HashMap<String, PluginInfo> f390277h = new HashMap<>();

    /* renamed from: m, reason: collision with root package name */
    private Handler f390279m = new Handler(k().getLooper(), this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class a implements FilenameFilter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f390280d;

        a(String str) {
            this.f390280d = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.endsWith(this.f390280d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class b implements Dex2Oat.c {
        b() {
        }

        @Override // cooperation.plugin.Dex2Oat.c
        public void a(File file, File file2) {
            if (QLog.isColorLevel()) {
                QLog.d("plugin_tag", 2, "dex2Oat onStart " + file.getAbsolutePath() + " o" + file2.getAbsolutePath());
            }
        }

        @Override // cooperation.plugin.Dex2Oat.c
        public void b(File file, File file2, File file3) {
            if (QLog.isColorLevel()) {
                QLog.d("plugin_tag", 2, "dex2Oat onSuccess " + file.getAbsolutePath() + " o" + file2.getAbsolutePath());
            }
        }

        @Override // cooperation.plugin.Dex2Oat.c
        public void c(File file, File file2, Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("plugin_tag", 2, "preDex2Oat onFailed " + file.getAbsolutePath() + " o" + file2.getAbsolutePath());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface c extends d {
        void j2(String str);

        void p4(boolean z16, String str);

        void u0(String str);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface d {
        void s1(String str, String str2, long j3);
    }

    public f(Context context, String str) {
        this.f390275e = context;
        this.f390276f = str;
        this.f390278i = cooperation.plugin.a.b(this.f390275e);
        l();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean A(PluginInfo pluginInfo) {
        boolean z16 = true;
        if (pluginInfo != null && pluginInfo.mType == 0 && pluginInfo.mSubType == 1) {
            if (pluginInfo.mState == 4) {
                return true;
            }
            return false;
        }
        if (pluginInfo == null || pluginInfo.mInstalledPath == null) {
            return false;
        }
        File file = new File(pluginInfo.mInstalledPath);
        if (file.exists() && file.isFile()) {
            if (e.f(pluginInfo, file)) {
                pluginInfo.mState = 4;
                pluginInfo.mInstalledPath = file.getAbsolutePath();
                if (QLog.isColorLevel()) {
                    QLog.d("plugin_tag", 2, "verifyInstalledPlugin :" + pluginInfo.mID + "," + z16);
                }
                return z16;
            }
            x(pluginInfo.mID);
            pluginInfo.mState = 0;
        }
        z16 = false;
        if (QLog.isColorLevel()) {
        }
        return z16;
    }

    private void b(String str) {
        e.b(str, j(this.f390275e));
    }

    private void f(PluginInfo pluginInfo, c cVar) {
        String str = pluginInfo.mID;
        QLog.d("plugin_tag", 1, "doSetupPlugin." + str);
        if (e.e(pluginInfo, this.f390275e)) {
            QLog.d("plugin_tag", 1, "plugin still running");
            if (cVar != null) {
                cVar.j2(str);
                return;
            }
            return;
        }
        if (!o(str)) {
            m(str, cVar);
        } else {
            n(pluginInfo, cVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean g(File file, QZipFile qZipFile, ZipEntry zipEntry) {
        RecycleableBufferedOutputStream recycleableBufferedOutputStream;
        InputStream inputStream;
        InputStream inputStream2 = null;
        r2 = null;
        RecycleableBufferedOutputStream recycleableBufferedOutputStream2 = null;
        inputStream2 = null;
        try {
            inputStream = qZipFile.getInputStream(zipEntry);
        } catch (IOException e16) {
            e = e16;
            recycleableBufferedOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            recycleableBufferedOutputStream = null;
        }
        try {
            if (!file.exists()) {
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
            }
            recycleableBufferedOutputStream2 = RecycleableBufferedOutputStream.obtain(new BufferedOutputStream(new FileOutputStream(file)));
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr);
                if (read > 0) {
                    recycleableBufferedOutputStream2.write(bArr, 0, read);
                } else {
                    try {
                        break;
                    } catch (IOException unused) {
                    }
                }
            }
            inputStream.close();
            if (recycleableBufferedOutputStream2 != null) {
                try {
                    recycleableBufferedOutputStream2.close();
                } catch (IOException unused2) {
                }
            }
            return true;
        } catch (IOException e17) {
            e = e17;
            RecycleableBufferedOutputStream recycleableBufferedOutputStream3 = recycleableBufferedOutputStream2;
            inputStream2 = inputStream;
            recycleableBufferedOutputStream = recycleableBufferedOutputStream3;
            try {
                QLog.e("plugin_tag", 1, e, new Object[0]);
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException unused3) {
                    }
                }
                if (recycleableBufferedOutputStream != null) {
                    try {
                        recycleableBufferedOutputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                return false;
            } catch (Throwable th6) {
                th = th6;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException unused5) {
                    }
                }
                if (recycleableBufferedOutputStream == null) {
                    try {
                        recycleableBufferedOutputStream.close();
                        throw th;
                    } catch (IOException unused6) {
                        throw th;
                    }
                }
                throw th;
            }
        } catch (Throwable th7) {
            th = th7;
            RecycleableBufferedOutputStream recycleableBufferedOutputStream4 = recycleableBufferedOutputStream2;
            inputStream2 = inputStream;
            recycleableBufferedOutputStream = recycleableBufferedOutputStream4;
            if (inputStream2 != null) {
            }
            if (recycleableBufferedOutputStream == null) {
            }
        }
    }

    public static String h() {
        String str = D;
        if (str == null) {
            return "";
        }
        return str;
    }

    static File j(Context context) {
        return PluginUtils.getPluginInstallDir(context);
    }

    public static HandlerThread k() {
        if (C == null) {
            synchronized (f.class) {
                if (C == null) {
                    HandlerThread newFreeHandlerThread = ThreadManagerV2.newFreeHandlerThread("QQ_PLUGIN", 0);
                    C = newFreeHandlerThread;
                    newFreeHandlerThread.start();
                }
            }
        }
        return C;
    }

    private boolean o(String str) {
        String[] list;
        if (!z() || (list = new File(this.f390276f).list(new a(str))) == null || list.length <= 0) {
            return false;
        }
        return true;
    }

    public static boolean q(String str, String str2) {
        boolean z16 = true;
        if (!PluginUtils.isOsNeedReleaseDex()) {
            return true;
        }
        int a16 = cooperation.plugin.c.a(str);
        if (a16 > 1) {
            BaseApplicationImpl baseApplicationImpl = BaseApplicationImpl.sApplication;
            DexReleasor dexReleasor = new DexReleasor(str2, PluginUtils.getPluginInstallDir(baseApplicationImpl).getAbsolutePath() + File.separator);
            int i3 = 1;
            while (true) {
                if (i3 >= a16) {
                    break;
                }
                int i16 = i3 + 1;
                String format = String.format("classes%d.dex", Integer.valueOf(i16));
                String multiDexName = PluginUtils.getMultiDexName(str, i16);
                if (-1 == dexReleasor.getEntryCrcCode(format)) {
                    QLog.d("plugin_tag", 1, "releaseMultiDexIfNeeded noDex " + format + " " + str);
                } else {
                    File file = new File(PluginUtils.getPluginInstallDir(baseApplicationImpl).getAbsolutePath(), multiDexName);
                    if (file.exists()) {
                        QLog.d("plugin_tag", 1, "releaseMultiDexIfNeeded  " + file.getAbsolutePath() + " exsit,delete first");
                        file.delete();
                    }
                    u(str2, format, file);
                    if (!file.exists()) {
                        QLog.d("plugin_tag", 1, "releaseMultiDexIfNeeded failed " + i3 + " " + file.getAbsolutePath());
                        z16 = false;
                        break;
                    }
                    StringBuilder sb5 = new StringBuilder(256);
                    sb5.append("releaseMultiDexIfNeeded ");
                    sb5.append(true);
                    sb5.append(" ");
                    sb5.append(file.getAbsolutePath());
                    QLog.d("plugin_tag", 1, sb5.toString());
                }
                i3 = i16;
            }
            dexReleasor.destroy();
        }
        return z16;
    }

    private static boolean u(String str, String str2, File file) {
        QZipFile qZipFile;
        if (QLog.isColorLevel()) {
            QLog.i("plugin_tag", 2, String.format("unzip %s of file %s  into %s ", str2, str, String.valueOf(file)));
        }
        try {
            qZipFile = new QZipFile(str);
        } catch (IOException e16) {
            QLog.e("plugin_tag", 1, e16, new Object[0]);
            qZipFile = null;
        }
        if (qZipFile == null) {
            QLog.e("plugin_tag", 1, String.format("unzip %s error", str));
            return false;
        }
        Enumeration<? extends ZipEntry> entries = qZipFile.entries();
        while (true) {
            if (!entries.hasMoreElements()) {
                break;
            }
            ZipEntry nextElement = entries.nextElement();
            if (!nextElement.getName().contains("..") && nextElement.getName().equals(str2)) {
                if (g(file, qZipFile, nextElement)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean x(String str) {
        return y(str, false);
    }

    private boolean y(String str, boolean z16) {
        PluginInfo pluginInfo = this.f390277h.get(str);
        if (pluginInfo != null && !z16 && e.e(pluginInfo, this.f390275e)) {
            QLog.d("plugin_tag", 2, "plugin still running " + str);
            return false;
        }
        this.f390277h.remove(str);
        b(str);
        if (pluginInfo != null && pluginInfo.mInstalledPath != null) {
            File file = new File(pluginInfo.mInstalledPath);
            if (file.exists()) {
                file.delete();
                QLog.d("plugin_tag", 2, "plugin uninstall " + str);
            }
        }
        if (pluginInfo == null || pluginInfo.mSubType != 1) {
            return true;
        }
        return QShadow.getInstance().uninstallPlugin(PluginIdUtil.convertQPluginId2QShadowId(str));
    }

    private boolean z() {
        boolean z16;
        if (TextUtils.isEmpty(this.f390276f) || !new File(this.f390276f).exists()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "verifyDownloadPath." + this.f390276f + ", " + z16);
        }
        return z16;
    }

    public long a() {
        long length;
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(PluginCleanUpThoroughCacheTool.CONFIG_KEY, true);
        Iterator it = new HashSet(this.f390277h.keySet()).iterator();
        long j3 = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            j3 += PluginUtils.getPluginCfgFile(j(this.f390275e), str).length();
            PluginInfo pluginInfo = this.f390277h.get(str);
            if (pluginInfo != null) {
                if (pluginInfo.mSubType == 1 && (isSwitchOn || !e.e(pluginInfo, this.f390275e))) {
                    length = QShadow.getInstance().installedPluginSize(PluginIdUtil.convertQPluginId2QShadowId(str));
                } else if (!TextUtils.isEmpty(pluginInfo.mInstalledPath)) {
                    length = new File(pluginInfo.mInstalledPath).length();
                }
                j3 += length;
            }
        }
        return j3;
    }

    public void c(String str, File file, c cVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(file);
        int i3 = 1;
        if (PluginUtils.isOsNeedReleaseDex() && cooperation.plugin.c.a(str) > 1) {
            arrayList.add(PluginUtils.getMultiDexSecondDex(this.f390275e, str));
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String a16 = Dex2Oat.a();
            if (QLog.isColorLevel()) {
                QLog.d("plugin_tag", 2, "dex2Oat targetISA = " + a16 + " " + str + " " + arrayList.size());
            }
            if (!TextUtils.isEmpty(a16)) {
                File file2 = new File(PluginUtils.getOptimizedDexPath(this.f390275e).getCanonicalPath());
                long currentTimeMillis2 = System.currentTimeMillis();
                boolean f16 = Dex2Oat.f(arrayList, file2, true, a16, new b());
                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                QLog.w("plugin_tag", 1, "dex2Oat " + currentTimeMillis3 + ", " + f16 + ", " + str);
                if (!f16) {
                    i3 = 2;
                }
                com.tencent.mobileqq.statistics.j.a(str, i3, currentTimeMillis3);
            } else {
                com.tencent.mobileqq.statistics.j.a(str, 3, 0L);
            }
            long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
            if (cVar != null) {
                cVar.s1(str, PluginConst.STAT_EXTRACT_DEX2OAT_COST, currentTimeMillis4);
            }
            if (QLog.isColorLevel()) {
                QLog.d("plugin_tag", 2, "install finish " + str);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void d(PluginInfo pluginInfo, c cVar) {
        this.f390279m.obtainMessage(67072, new Pair(pluginInfo, cVar)).sendToTarget();
    }

    public boolean e(PluginInfo pluginInfo, c cVar) {
        String str = pluginInfo.mID;
        if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "doDex2OatPlugin." + str);
        }
        PluginInfo i3 = i(str);
        if (i3 != null && i3.mState == 4) {
            QLog.d("plugin_tag", 1, "doDex2OatPlugin. already " + str);
        } else if (e.e(pluginInfo, this.f390275e)) {
            QLog.d("plugin_tag", 1, "doDex2OatPlugin. isPluginRunning " + str);
        } else {
            c(str, new File(PluginUtils.getPluginInstallDir(this.f390275e), str), cVar);
            pluginInfo.mState = 4;
            pluginInfo.mFingerPrint = h();
            s(pluginInfo);
            if (QLog.isColorLevel()) {
                QLog.d("plugin_tag", 2, "doDex2OatPlugin finish");
            }
        }
        if (cVar != null) {
            cVar.p4(true, str);
        }
        return true;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 != 66816) {
            if (i3 != 67072) {
                return false;
            }
            Pair pair = (Pair) message.obj;
            e((PluginInfo) pair.first, (c) pair.second);
            return true;
        }
        Pair pair2 = (Pair) message.obj;
        f((PluginInfo) pair2.first, (c) pair2.second);
        return true;
    }

    public PluginInfo i(String str) {
        if (!this.f390274d) {
            return null;
        }
        return this.f390277h.get(str);
    }

    public void l() {
        boolean z16;
        File j3 = j(this.f390275e);
        boolean d16 = e.d(j3);
        File[] c16 = e.c(j3);
        if (c16 != null) {
            for (File file : c16) {
                if (file.isFile()) {
                    if (d16) {
                        String[] a16 = com.tencent.mobileqq.startup.update.f.INSTANCE.a();
                        int length = a16.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 < length) {
                                String str = a16[i3];
                                if (!com.tencent.mobileqq.startup.step.b.a(str)) {
                                    if (file.getName().equals(str + PluginUtils.CONFIG_FILE_EXTEND_NAME)) {
                                        x(str);
                                        z16 = true;
                                        break;
                                    }
                                }
                                i3++;
                            } else {
                                z16 = false;
                                break;
                            }
                        }
                        if (z16) {
                        }
                    }
                    PluginInfo a17 = e.a(file);
                    if (a17 != null) {
                        if (A(a17) || (("expand.apk".equals(a17.mID) || !er.c(this.f390275e, "KEY_DISABLE_SAVE_PLUGIN_INFO", true, false)) && a17.mState == 2)) {
                            QLog.d("plugin_tag", 1, "put " + a17.mID + " in to mInstalledPlugins, state: " + a17.mState);
                            this.f390277h.put(a17.mID, a17);
                        }
                    } else {
                        file.delete();
                    }
                }
            }
        }
        if (d16) {
            e.h(j3);
        }
        if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "load installed plugin info. size:" + this.f390277h.size());
        }
        this.f390274d = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0228  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m(String str, c cVar) {
        boolean z16;
        boolean z17;
        boolean z18;
        String str2;
        boolean z19;
        String extractLibs;
        if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "installBuiltinPlugin." + str);
        }
        if (!this.f390274d) {
            if (cVar != null) {
                cVar.j2(str);
            }
            return false;
        }
        if (!this.f390278i.e(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("plugin_tag", 2, "not built in plugin.");
            }
            if (cVar != null) {
                cVar.j2(str);
            }
            return false;
        }
        File file = new File(PluginUtils.getPluginInstallDir(this.f390275e), str);
        PluginInfo pluginInfo = this.f390277h.get(str);
        PluginInfo a16 = this.f390278i.a(str);
        if (a16 == null) {
            QLog.d("plugin_tag", 1, "plugin not builtin");
            if (cVar != null) {
                cVar.p4(false, str);
            }
            return false;
        }
        if (pluginInfo != null && !a16.mMD5.equals(pluginInfo.mMD5)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (file.exists()) {
            z17 = A(pluginInfo);
        } else {
            z17 = false;
        }
        if (z17 && !z16) {
            if (QLog.isColorLevel()) {
                QLog.d("plugin_tag", 2, "plugin already installed.");
            }
            if (cVar != null) {
                cVar.p4(true, str);
            }
            return true;
        }
        if (cVar != null) {
            cVar.u0(str);
        }
        PluginInfo mo210clone = a16.mo210clone();
        mo210clone.mState = 3;
        this.f390277h.put(str, mo210clone);
        int i3 = a16.mSubType;
        String str3 = "";
        if (i3 == 1) {
            String convertQPluginId2QShadowId = PluginIdUtil.convertQPluginId2QShadowId(a16.mID);
            long currentTimeMillis = System.currentTimeMillis();
            boolean installPlugin = QShadow.getInstance().installPlugin(convertQPluginId2QShadowId);
            mo210clone.costDex2Oat = System.currentTimeMillis() - currentTimeMillis;
            if (!installPlugin) {
                if (cVar != null) {
                    cVar.p4(false, str);
                }
                this.f390277h.put(str, pluginInfo);
                return false;
            }
            str2 = QShadowRepository.getInstalledPlugin(this.f390275e, convertQPluginId2QShadowId, "");
            file = new File(Constant.getPluginInstalledPath(this.f390275e, convertQPluginId2QShadowId));
        } else {
            if (i3 == 2) {
                try {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    str3 = PluginUtils.extractPluginAndGetMd5Code(this.f390275e, str, file);
                    z18 = com.tencent.mobileqq.app.compact.a.k().j(str, (Application) this.f390275e.getApplicationContext());
                    try {
                        mo210clone.costDex2Oat = System.currentTimeMillis() - currentTimeMillis2;
                    } catch (Exception e16) {
                        e = e16;
                        QLog.e("plugin_tag", 1, "install df plugin failed ", e);
                        if (!z18) {
                        }
                        str2 = str3;
                        mo210clone.mLength = file.length();
                        mo210clone.mState = 4;
                        mo210clone.mInstalledPath = file.getAbsolutePath();
                        mo210clone.mMD5 = str2;
                        mo210clone.mFingerPrint = h();
                        this.f390277h.put(str, mo210clone);
                        s(mo210clone);
                        if (QLog.isColorLevel()) {
                        }
                        if (cVar != null) {
                        }
                        return true;
                    }
                } catch (Exception e17) {
                    e = e17;
                    z18 = false;
                }
                if (!z18) {
                    if (cVar != null) {
                        cVar.p4(false, str);
                    }
                    this.f390277h.put(str, pluginInfo);
                    return false;
                }
            } else {
                long currentTimeMillis3 = System.currentTimeMillis();
                try {
                    String substring = str.substring(0, str.indexOf(".apk"));
                    String releasedSoFilePath = SoLoadCore.getReleasedSoFilePath(this.f390275e, substring);
                    if (releasedSoFilePath == null) {
                        releasedSoFilePath = SoLoadCore.releaseSo(this.f390275e, substring);
                    }
                    if (releasedSoFilePath != null) {
                        File file2 = new File(releasedSoFilePath);
                        try {
                            str3 = mo210clone.mMD5;
                        } catch (Exception unused) {
                        }
                        file = file2;
                    }
                } catch (Exception unused2) {
                }
                if (TextUtils.isEmpty(str3)) {
                    try {
                        str3 = PluginUtils.extractPluginAndGetMd5Code(this.f390275e, str, file);
                    } catch (Exception e18) {
                        QLog.d("plugin_tag", 1, "extractPluginAndGetMd5Code failed installPath = " + file + ", leftSpace = " + FileUtils.getAvailableInnernalMemorySize(), e18);
                    }
                }
                String str4 = mo210clone.mMD5;
                if (QLog.isColorLevel()) {
                    QLog.d("plugin_tag", 2, "md5:" + str4 + " vs " + str3);
                }
                if (str3.equals(str4)) {
                    long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
                    if (cVar != null) {
                        cVar.s1(str, PluginConst.STAT_EXTRACT_APK_COST, currentTimeMillis4);
                    }
                    try {
                        String canonicalPath = PluginUtils.getPluginLibPath(this.f390275e, str).getCanonicalPath();
                        long currentTimeMillis5 = System.currentTimeMillis();
                        extractLibs = PluginUtils.extractLibs(file.getCanonicalPath(), canonicalPath);
                        long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis5;
                        if (cVar != null) {
                            cVar.s1(str, PluginConst.STAT_EXTRACT_LIB_COST, currentTimeMillis6);
                        }
                    } catch (Throwable th5) {
                        QLog.d("plugin_tag", 1, "extractLibs ", th5);
                    }
                    if (extractLibs != null) {
                        QLog.d("plugin_tag", 1, "extractLibs " + extractLibs);
                        z19 = true;
                        if (!z19) {
                            z19 = !q(str, file.getAbsolutePath());
                        }
                        if (!z19) {
                            file.delete();
                            if (cVar != null) {
                                cVar.p4(false, str);
                            }
                            this.f390277h.put(str, pluginInfo);
                            return false;
                        }
                        if (g.f6()) {
                            c(str, file, cVar);
                        }
                    } else {
                        z19 = false;
                        if (!z19) {
                        }
                        if (!z19) {
                        }
                    }
                } else {
                    if (cVar != null) {
                        cVar.p4(false, str);
                    }
                    this.f390277h.put(str, pluginInfo);
                    return false;
                }
            }
            str2 = str3;
        }
        mo210clone.mLength = file.length();
        mo210clone.mState = 4;
        mo210clone.mInstalledPath = file.getAbsolutePath();
        mo210clone.mMD5 = str2;
        mo210clone.mFingerPrint = h();
        this.f390277h.put(str, mo210clone);
        s(mo210clone);
        if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "install finish");
        }
        if (cVar != null) {
            cVar.p4(true, str);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean n(PluginInfo pluginInfo, c cVar) {
        boolean z16;
        boolean z17;
        boolean z18;
        String extractLibs;
        boolean z19;
        if (pluginInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.d("plugin_tag", 2, "installDownLoadPlugin. info null.");
            }
            throw new NullPointerException("specified PluginInfo is null");
        }
        String str = pluginInfo.mID;
        if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "installDownLoadPlugin." + str);
        }
        if (!this.f390274d) {
            if (cVar != null) {
                cVar.j2(str);
            }
            return false;
        }
        File file = new File(PluginUtils.getPluginInstallDir(this.f390275e), str);
        PluginInfo pluginInfo2 = this.f390277h.get(str);
        if (pluginInfo2 != null && !pluginInfo.mMD5.equals(pluginInfo2.mMD5)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (file.exists()) {
            z17 = A(pluginInfo2);
        } else {
            z17 = false;
        }
        if (z17 && !z16) {
            if (QLog.isColorLevel()) {
                QLog.d("plugin_tag", 2, "plugin installed.");
            }
            if (cVar != null) {
                cVar.j2(str);
            }
            return false;
        }
        if (!z()) {
            if (cVar != null) {
                cVar.j2(str);
            }
            return false;
        }
        File file2 = new File(new File(this.f390276f), str);
        if (!e.f(pluginInfo, file2)) {
            if (QLog.isColorLevel()) {
                QLog.d("plugin_tag", 2, "install fail. download file invalid.");
            }
            file2.delete();
            if (cVar != null) {
                cVar.j2(str);
            }
            return false;
        }
        if (cVar != null) {
            cVar.u0(str);
        }
        pluginInfo.mState = 3;
        this.f390277h.put(str, pluginInfo);
        QLog.d("plugin_tag", 1, "copyRes " + FileUtils.copyFile(file2, file));
        if (!e.f(pluginInfo, file)) {
            if (QLog.isColorLevel()) {
                QLog.d("plugin_tag", 2, "install fail. copy file invalid.");
            }
            file.delete();
            if (cVar != null) {
                cVar.p4(false, str);
            }
            this.f390277h.put(str, pluginInfo);
            return false;
        }
        int i3 = pluginInfo.mSubType;
        if (i3 == 1) {
            String convertQPluginId2QShadowId = PluginIdUtil.convertQPluginId2QShadowId(pluginInfo.mID);
            long currentTimeMillis = System.currentTimeMillis();
            if (QShadow.getInstance().preInstall(convertQPluginId2QShadowId, file) && QShadow.getInstance().installPlugin(convertQPluginId2QShadowId)) {
                z19 = true;
            } else {
                z19 = false;
            }
            pluginInfo.costDex2Oat = System.currentTimeMillis() - currentTimeMillis;
            if (!z19) {
                file.delete();
                if (cVar != null) {
                    cVar.p4(false, str);
                }
                this.f390277h.put(str, pluginInfo);
                return false;
            }
        } else if (i3 == 2) {
            long currentTimeMillis2 = System.currentTimeMillis();
            boolean j3 = com.tencent.mobileqq.app.compact.a.k().j(str, (Application) this.f390275e.getApplicationContext());
            pluginInfo.costDex2Oat = System.currentTimeMillis() - currentTimeMillis2;
            if (!j3) {
                file.delete();
                if (cVar != null) {
                    cVar.p4(false, str);
                }
                this.f390277h.put(str, pluginInfo);
                return false;
            }
        } else {
            try {
                extractLibs = PluginUtils.extractLibs(file.getCanonicalPath(), PluginUtils.getPluginLibPath(this.f390275e, str).getCanonicalPath());
            } catch (Throwable th5) {
                QLog.d("plugin_tag", 1, "extractLibs ", th5);
            }
            if (extractLibs != null) {
                QLog.d("plugin_tag", 1, "extractLibs " + extractLibs);
                z18 = true;
                if (!z18) {
                    z18 = !q(str, file.getAbsolutePath());
                }
                if (!z18) {
                    file.delete();
                    if (cVar != null) {
                        cVar.p4(false, str);
                    }
                    this.f390277h.put(str, pluginInfo);
                    return false;
                }
                if (g.f6()) {
                    c(str, file, cVar);
                }
            } else {
                z18 = false;
                if (!z18) {
                }
                if (!z18) {
                }
            }
        }
        pluginInfo.mState = 4;
        pluginInfo.mInstalledPath = file.getAbsolutePath();
        pluginInfo.mFingerPrint = h();
        this.f390277h.put(str, pluginInfo);
        s(pluginInfo);
        File file3 = new File(cooperation.plugin.patch.g.c(this.f390275e));
        if (!file3.exists()) {
            file3.mkdirs();
        }
        File file4 = new File(cooperation.plugin.patch.g.b(this.f390275e, pluginInfo.mID));
        if (file4.exists()) {
            file4.delete();
        }
        FileUtils.copyFile(file, file4);
        if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, String.format("plugin backup finish. [bakPath]=%s.", file4.getAbsolutePath()));
        }
        if (file2.exists()) {
            file2.delete();
        }
        if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "install finish.");
        }
        if (cVar != null) {
            cVar.p4(true, str);
        }
        return true;
    }

    public boolean p(String str) {
        boolean z16 = false;
        if (!this.f390274d) {
            return false;
        }
        PluginInfo pluginInfo = this.f390277h.get(str);
        if (pluginInfo != null && pluginInfo.mState == 4 && pluginInfo.mInstalledPath != null && new File(pluginInfo.mInstalledPath).exists()) {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "isPluginInstalled installed = " + z16);
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(PluginInfo pluginInfo) {
        this.f390277h.put(pluginInfo.mID, pluginInfo);
        s(pluginInfo);
    }

    void s(PluginInfo pluginInfo) {
        e.g(pluginInfo, j(this.f390275e));
    }

    public void t(PluginInfo pluginInfo, c cVar) {
        QLog.d("plugin_tag", 1, "setupPlugin." + pluginInfo.mID);
        this.f390279m.obtainMessage(66816, new Pair(pluginInfo, cVar)).sendToTarget();
    }

    public void v() {
        if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "uninstall all installed Plugin. " + this.f390277h.size());
        }
        if (!this.f390274d) {
            return;
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(PluginCleanUpThoroughCacheTool.CONFIG_KEY, true);
        Iterator it = new HashSet(this.f390277h.keySet()).iterator();
        while (it.hasNext()) {
            y((String) it.next(), isSwitchOn);
        }
    }

    public boolean w(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "uninstallPlugin." + str);
        }
        if (!this.f390274d) {
            return false;
        }
        return x(str);
    }
}
