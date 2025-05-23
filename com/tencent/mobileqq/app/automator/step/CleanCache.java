package com.tencent.mobileqq.app.automator.step;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.dpc.IDPCApiConstant;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.HotPicManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.RemoveTransaction;
import com.tencent.mobileqq.proavatar.api.IProAvatarUtilsApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import com.tencent.qqperf.monitor.crash.QQCrashReportManager;
import common.config.service.QzoneConfig;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
@Deprecated
/* loaded from: classes11.dex */
public class CleanCache extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f195330d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements Comparator<File> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CleanCache.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) file, (Object) file2)).intValue();
            }
            if (file.lastModified() > file2.lastModified()) {
                return -1;
            }
            if (file.lastModified() != file2.lastModified() || file.length() > file2.length()) {
                return 1;
            }
            if (file.length() < file2.length()) {
                return -1;
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b implements Comparator<File> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CleanCache.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) file, (Object) file2)).intValue();
            }
            if (file2.lastModified() - file.lastModified() > 0) {
                return 1;
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class c implements Comparator<File> {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CleanCache.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) file, (Object) file2)).intValue();
            }
            if (file2.lastModified() - file.lastModified() > 0) {
                return 1;
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class d implements Comparator<File> {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CleanCache.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) file, (Object) file2)).intValue();
            }
            if (file2.lastModified() - file.lastModified() > 0) {
                return 1;
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class e implements FilenameFilter {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CleanCache.this);
            }
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) file, (Object) str)).booleanValue();
            }
            return !str.contains("CrashInfoSummary.txt");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class f implements Comparator<File> {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CleanCache.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) file, (Object) file2)).intValue();
            }
            long lastModified = file.lastModified() - file2.lastModified();
            if (lastModified > 0) {
                return -1;
            }
            if (lastModified < 0) {
                return 1;
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class g implements Comparator<File> {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CleanCache.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) file, (Object) file2)).intValue();
            }
            if (file2.lastModified() - file.lastModified() > 0) {
                return 1;
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class h implements Comparator<File> {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CleanCache.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) file, (Object) file2)).intValue();
            }
            if (file2.lastModified() - file.lastModified() > 0) {
                return 1;
            }
            if (file2.lastModified() - file.lastModified() < 0) {
                return -1;
            }
            return 0;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70094);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f195330d = new String[]{AppConstants.S_DCARD_COLLECTION};
        }
    }

    public CleanCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int l(int i3) {
        File[] listFiles;
        String[] strArr = {AppConstants.PATH_HEAD_HD, "/data/data/com.tencent.mobileqq/files/head/_hd/"};
        for (int i16 = 0; i16 < 2; i16++) {
            File file = new File(strArr[i16]);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 3000) {
                int length = listFiles.length;
                int length2 = listFiles.length;
                int i17 = length - 2500;
                File[] x16 = x(listFiles);
                int length3 = (length2 - x16.length) + 0;
                if (QLog.isColorLevel()) {
                    QLog.d("IAutomator", 2, "onCleanCache. after delTemporaryQQHead. totalCount=" + length + ", currNeedDelCount=" + i17 + ", delCount=" + length3);
                }
                if (length3 < i17) {
                    Arrays.sort(x16, new b());
                    int length4 = x16.length;
                    File[] v3 = v(x16, length3, i17);
                    int length5 = length3 + (length4 - v3.length);
                    if (QLog.isColorLevel()) {
                        QLog.d("IAutomator", 2, "onCleanCache. after delSecondaryQQHead. totalCount=" + length + ", currNeedDelCount=" + i17 + ", delCount=" + length5);
                    }
                    if (length5 < i17) {
                        u(v3, length5, i17, length);
                    }
                }
                i3 = i17;
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int m(File file, int i3, int i16) {
        long j3;
        int i17 = 0;
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return 0;
            }
            int length = listFiles.length;
            if (file == URLDrawableHelper.diskCachePath && QLog.isColorLevel()) {
                QLog.d("IAutomator", 2, "before onCleanCache diskCachePath. " + length + " cache file(s)");
            }
            if (length > i3) {
                Arrays.sort(listFiles, new c());
                int length2 = listFiles.length;
                int i18 = length;
                j3 = 0;
                while (i17 < length2) {
                    File file2 = listFiles[i17];
                    j3 += file2.length();
                    file2.delete();
                    i18--;
                    if (i18 <= i16) {
                        break;
                    }
                    if (i18 % 200 == 0) {
                        try {
                            LockMethodProxy.sleep(100L);
                        } catch (InterruptedException unused) {
                        }
                    }
                    i17++;
                }
                i17 = length - i16;
                length = i18;
            } else {
                j3 = 0;
            }
            long currentTimeMillis = System.currentTimeMillis();
            for (int length3 = listFiles.length - length; length3 < listFiles.length; length3++) {
                File file3 = listFiles[length3];
                if (file3.exists() && file3.isFile()) {
                    if (currentTimeMillis - file3.lastModified() <= 2592000000L) {
                        break;
                    }
                    j3 += file3.length();
                    file3.delete();
                    i17++;
                    if (length3 % 200 == 0) {
                        try {
                            LockMethodProxy.sleep(100L);
                        } catch (InterruptedException unused2) {
                        }
                    }
                }
            }
            if (file == URLDrawableHelper.diskCachePath) {
                if (QLog.isColorLevel()) {
                    QLog.d("IAutomator", 2, "after onCleanCache diskCachePath delete " + i17 + " cache file(s) sumSize:" + ((j3 / 1024) / 1024));
                }
                if (i17 > 0) {
                    long z16 = ea.z(((Automator) this.mAutomator).E.getCurrentAccountUin());
                    long serverTime = NetConnInfoCenter.getServerTime() / 3600;
                    if (z16 != 0 && serverTime > z16) {
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "CleanDiskCache", true, serverTime - z16, i17, null, "");
                    }
                    ea.G3(((Automator) this.mAutomator).E.getCurrentAccountUin());
                }
            }
        }
        return i17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        File file = new File(com.tencent.mobileqq.hotpic.b.f237006d);
        File[] listFiles = file.listFiles();
        if (file.exists() && file.isDirectory()) {
            if (listFiles.length > 500) {
                try {
                    Arrays.sort(listFiles, new a());
                } catch (Exception unused) {
                    if (QLog.isColorLevel()) {
                        QLog.d("IAutomator", 2, "Arrays.sort error");
                    }
                }
                HashSet hashSet = new HashSet();
                T t16 = this.mAutomator;
                if (((Automator) t16).E == null) {
                    return;
                }
                Iterator it = ((LinkedList) HotPicManager.i(((Automator) t16).E).o().clone()).iterator();
                while (it.hasNext()) {
                    File diskFile = com.tencent.mobileqq.hotpic.b.getDiskFile(((HotPicData) it.next()).url);
                    if (diskFile != null) {
                        hashSet.add(diskFile);
                    }
                }
                ArrayList arrayList = new ArrayList();
                for (int i3 = 500; i3 < listFiles.length; i3++) {
                    File file2 = listFiles[i3];
                    if (hashSet.contains(file2)) {
                        hashSet.remove(file2);
                    } else {
                        arrayList.add(file2);
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("IAutomator", 2, "cleanResource,delete files count:" + arrayList.size());
                }
                Iterator it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    ((File) it5.next()).delete();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        int i3;
        File[] listFiles;
        if (QLog.isColorLevel()) {
            QLog.d("ZhituManager", 2, "cleanLightVideoCache...");
        }
        long currentTimeMillis = System.currentTimeMillis();
        File file = new File(CameraCaptureView.h.f281414t);
        int i16 = 0;
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            int length = listFiles.length;
            if (length > 25) {
                Arrays.sort(listFiles, new h());
                int length2 = listFiles.length;
                i3 = 0;
                while (i16 < length2) {
                    File file2 = listFiles[i16];
                    if (QLog.isColorLevel()) {
                        QLog.d("IAutomator", 2, "cleanLightVideoCache ===> deleteCount=" + i3 + ", delete dir=" + file2.getAbsolutePath());
                    }
                    FileUtils.deleteDirectory(file2.getAbsolutePath());
                    i3++;
                    if (i3 >= length - 10) {
                        break;
                    } else {
                        i16++;
                    }
                }
            } else {
                i3 = 0;
            }
            i16 = length;
        } else {
            i3 = 0;
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("cleanLightVideoCache(), totalCount=");
            sb5.append(i16);
            sb5.append(", deleteCount= ");
            sb5.append(i3);
            sb5.append(", targetDeleteCount=");
            sb5.append(i16 - 10);
            sb5.append(", cost: ");
            sb5.append(currentTimeMillis2);
            sb5.append(" ms");
            QLog.d("IAutomator", 2, sb5.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int p() {
        return m(((IProAvatarUtilsApi) QRoute.api(IProAvatarUtilsApi.class)).getDownloadCacheDir(), 3000, 2000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        File[] listFiles;
        String[] strArr = {AppConstants.PATH_HEAD_STRANGER, "/data/data/com.tencent.mobileqq/files/head/_stranger/"};
        for (int i3 = 0; i3 < 2; i3++) {
            File file = new File(strArr[i3]);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 300) {
                Arrays.sort(listFiles, new d());
                int length = listFiles.length;
                int i16 = 0;
                for (int i17 = 0; i17 < length; i17++) {
                    File file2 = listFiles[i17];
                    if (file2.exists()) {
                        file2.delete();
                    }
                    listFiles[i17] = null;
                    i16++;
                    if (length - i16 <= 20) {
                        break;
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("IAutomator", 2, "onCleanCache. delete stranger head...");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        int i3;
        int i16;
        File[] listFiles;
        if (QLog.isColorLevel()) {
            QLog.d("ZhituManager", 2, "cleanZhituCache...");
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (ZhituManager.f0()) {
            return;
        }
        ZhituManager.J0(true);
        File file = new File(VFSAssistantUtils.getSDKPrivatePath((AppConstants.SDCARD_PATH + AppConstants.SDCARD_PATH_ZHITU) + "/origin/"));
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            i3 = listFiles.length;
            if (i3 > 200) {
                Arrays.sort(listFiles, new g());
                i16 = 0;
                for (File file2 : listFiles) {
                    if (QLog.isColorLevel()) {
                        QLog.d("IAutomator", 2, "cleanZhituCache ===> deleteCount=" + i16 + ", delete dir=" + file2.getAbsolutePath());
                    }
                    FileUtils.deleteDirectory(file2.getAbsolutePath());
                    i16++;
                    if (i16 >= i3 - 50) {
                        break;
                    }
                }
            } else {
                i16 = 0;
            }
        } else {
            i3 = 0;
            i16 = 0;
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        ZhituManager.J0(false);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("delShortVideoCache(), totalCount=");
            sb5.append(i3);
            sb5.append(", deleteCount= ");
            sb5.append(i16);
            sb5.append(", targetDeleteCount=");
            sb5.append(i3 - 50);
            sb5.append(", cost: ");
            sb5.append(currentTimeMillis2);
            sb5.append(" ms");
            QLog.d("IAutomator", 2, sb5.toString());
        }
    }

    public static final void t(String str) {
        File file = new File(str + ".nomedia");
        if (!file.exists()) {
            try {
                file.createNewFile();
                if (QLog.isColorLevel()) {
                    QLog.d("IAutomator", 2, "create nomedia file:" + file.getAbsolutePath());
                }
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
    }

    private int u(File[] fileArr, int i3, int i16, int i17) {
        for (int i18 = 0; i18 < fileArr.length; i18++) {
            File file = fileArr[i18];
            if (file.exists()) {
                file.delete();
            }
            fileArr[i18] = null;
            i3++;
            if (QLog.isColorLevel()) {
                QLog.d("IAutomator", 2, "onCleanCache->delRemainQQHead. delete QQHead,filePath=" + file.getAbsolutePath());
            }
            if (i3 >= i16) {
                return i3;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("IAutomator", 2, "onCleanCache. after delRemainQQHead. totalCount=" + i17 + ", currNeedDelCount=" + i16 + ", delCount=" + i3);
        }
        return i3;
    }

    private File[] v(File[] fileArr, int i3, int i16) {
        LinkedList linkedList;
        EntityManager createEntityManager;
        EntityManager entityManager = null;
        try {
            linkedList = new LinkedList();
            createEntityManager = ((Automator) this.mAutomator).E.getEntityManagerFactory().createEntityManager();
        } catch (Exception unused) {
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            ArrayList arrayList = (ArrayList) createEntityManager.query(Friends.class, false, "groupid>=?", new String[]{"0"}, null, null, null, null);
            if (arrayList != null && arrayList.size() != 0) {
                for (int i17 = 0; i17 < arrayList.size(); i17++) {
                    linkedList.add(((Automator) this.mAutomator).E.getCustomFaceFilePath(false, ((Friends) arrayList.get(i17)).uin));
                }
            }
            List<TroopInfo> troopListFromCache = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getTroopListFromCache();
            if (troopListFromCache != null && troopListFromCache.size() > 0) {
                for (int i18 = 0; i18 < troopListFromCache.size(); i18++) {
                    linkedList.add(((Automator) this.mAutomator).E.getCustomFaceFilePath(true, troopListFromCache.get(i18).troopuin));
                }
            }
            int i19 = 0;
            for (int i26 = 0; i26 < fileArr.length; i26++) {
                File file = fileArr[i26];
                String absolutePath = file.getAbsolutePath();
                if (!linkedList.contains(absolutePath) && absolutePath.indexOf("discussion_") < 0 && absolutePath.indexOf("sys_") < 0) {
                    if (file.exists()) {
                        file.delete();
                    }
                    fileArr[i26] = null;
                    i19++;
                    if (QLog.isColorLevel()) {
                        QLog.d("IAutomator", 2, "onCleanCache->delSecondaryQQHead. delete QQHead,filePath=" + file.getAbsolutePath());
                    }
                    if (i3 + i19 >= i16) {
                        break;
                    }
                }
            }
            if (i19 > 0) {
                int length = fileArr.length - i19;
                File[] fileArr2 = new File[length];
                int i27 = 0;
                for (int i28 = 0; i28 < fileArr.length && i27 < length; i28++) {
                    File file2 = fileArr[i28];
                    if (file2 != null) {
                        int i29 = i27 + 1;
                        fileArr2[i27] = file2;
                        i27 = i29;
                    }
                }
                fileArr = fileArr2;
            }
            createEntityManager.close();
            return fileArr;
        } catch (Exception unused2) {
            entityManager = createEntityManager;
            if (entityManager != null) {
                entityManager.close();
            }
            return fileArr;
        } catch (Throwable th6) {
            th = th6;
            entityManager = createEntityManager;
            if (entityManager != null) {
                entityManager.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x000f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void w(EntityManager entityManager, List<Setting> list, int i3, List<Setting> list2, int i16) {
        int i17;
        int i18;
        String customFaceFilePathBySetting;
        if (list != null && i3 > i16) {
            if (list2 == null) {
                list2 = new ArrayList<>();
            }
            for (Setting setting : list) {
                if (setting != null && !TextUtils.isEmpty(setting.uin)) {
                    byte b16 = setting.bUsrType;
                    if (b16 == 32) {
                        i18 = 202;
                    } else if (b16 == 16) {
                        i18 = 16;
                    } else {
                        if (b16 == 116) {
                            i17 = com.tencent.mobileqq.extendfriend.apollo.face.a.f205555c;
                        } else {
                            i17 = 0;
                        }
                        i18 = 200;
                        customFaceFilePathBySetting = ((Automator) this.mAutomator).E.getCustomFaceFilePathBySetting(setting, i18, i17);
                        if (!TextUtils.isEmpty(customFaceFilePathBySetting) && !new File(customFaceFilePathBySetting).exists()) {
                            list2.add(setting);
                            if (!QLog.isColorLevel()) {
                                QLog.d("IAutomator", 2, "cleanSetingData," + setting.uin + "," + ((int) setting.bUsrType) + "," + ((Automator) this.mAutomator).E.getCustomFaceFilePathBySetting(setting, i18, 0));
                            }
                        }
                    }
                    i17 = 0;
                    customFaceFilePathBySetting = ((Automator) this.mAutomator).E.getCustomFaceFilePathBySetting(setting, i18, i17);
                    if (!TextUtils.isEmpty(customFaceFilePathBySetting)) {
                        list2.add(setting);
                        if (!QLog.isColorLevel()) {
                        }
                    }
                }
            }
            if (list2.size() > 0 && entityManager.isOpen()) {
                try {
                    ArrayList arrayList = new ArrayList();
                    for (Setting setting2 : list2) {
                        if (setting2 != null) {
                            arrayList.add(new RemoveTransaction(setting2));
                        }
                    }
                    entityManager.doMultiDBOperateByTransaction(arrayList);
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("IAutomator", 2, "cleanSettingData,", e16);
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00e1 A[Catch: all -> 0x0101, Exception -> 0x0104, TryCatch #6 {Exception -> 0x0104, all -> 0x0101, blocks: (B:66:0x0036, B:68:0x003c, B:69:0x0045, B:72:0x0059, B:10:0x0068, B:12:0x0089, B:15:0x0091, B:17:0x0094, B:19:0x00a0, B:21:0x00a6, B:22:0x00a9, B:24:0x00b3, B:26:0x00db, B:31:0x00e1, B:32:0x00e6, B:35:0x00eb, B:37:0x00ef), top: B:65:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private File[] x(File[] fileArr) {
        EntityManager entityManager;
        HashMap hashMap;
        int i3;
        Cursor cursor = null;
        try {
            entityManager = ((Automator) this.mAutomator).E.getEntityManagerFactory().createEntityManager();
            try {
                Cursor query = entityManager.query(false, Setting.class.getSimpleName(), new String[]{"uin", "bUsrType"}, "bSourceType=?", new String[]{"1"}, (String) null, (String) null, (String) null, (String) null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            hashMap = new HashMap(query.getCount());
                            do {
                                String string = query.getString(0);
                                boolean z16 = true;
                                short s16 = query.getShort(1);
                                QQAppInterface qQAppInterface = ((Automator) this.mAutomator).E;
                                if (s16 != 4) {
                                    z16 = false;
                                }
                                hashMap.put(qQAppInterface.getCustomFaceFilePath(z16, string), string);
                            } while (query.moveToNext());
                            DBMethodProxy.execSQL(entityManager, "delete from " + Setting.class.getSimpleName() + " where bSourceType = 1");
                            if (hashMap == null && hashMap.size() > 0) {
                                i3 = 0;
                                for (int i16 = 0; i16 < fileArr.length; i16++) {
                                    File file = fileArr[i16];
                                    String absolutePath = file.getAbsolutePath();
                                    if (hashMap.containsKey(absolutePath)) {
                                        if (file.exists()) {
                                            file.delete();
                                        }
                                        fileArr[i16] = null;
                                        i3++;
                                        if (QLog.isColorLevel()) {
                                            QLog.d("IAutomator", 2, "onCleanCache->delTemporaryQQHead. delete QQHead, uin=" + ((String) hashMap.get(absolutePath)) + ", filePath=" + absolutePath);
                                        }
                                    }
                                }
                            } else {
                                i3 = 0;
                            }
                            if (i3 > 0) {
                                int length = fileArr.length - i3;
                                File[] fileArr2 = new File[length];
                                int i17 = 0;
                                for (int i18 = 0; i18 < fileArr.length && i17 < length; i18++) {
                                    File file2 = fileArr[i18];
                                    if (file2 != null) {
                                        int i19 = i17 + 1;
                                        fileArr2[i17] = file2;
                                        i17 = i19;
                                    }
                                }
                                fileArr = fileArr2;
                            }
                            if (query != null) {
                                query.close();
                            }
                            entityManager.close();
                            return fileArr;
                        }
                    } catch (Exception unused) {
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (entityManager != null) {
                            entityManager.close();
                        }
                        return fileArr;
                    } catch (Throwable th5) {
                        th = th5;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (entityManager != null) {
                            entityManager.close();
                        }
                        throw th;
                    }
                }
                hashMap = null;
                DBMethodProxy.execSQL(entityManager, "delete from " + Setting.class.getSimpleName() + " where bSourceType = 1");
                if (hashMap == null) {
                }
                i3 = 0;
                if (i3 > 0) {
                }
                if (query != null) {
                }
                entityManager.close();
                return fileArr;
            } catch (Exception unused2) {
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception unused3) {
            entityManager = null;
        } catch (Throwable th7) {
            th = th7;
            entityManager = null;
        }
    }

    private void z(List<Setting> list) {
        if (list != null) {
            int i3 = 0;
            int i16 = 0;
            for (Setting setting : list) {
                if (setting != null && !TextUtils.isEmpty(setting.uin)) {
                    if (setting.bSourceType != 1 && setting.bUsrType != 32) {
                        i3++;
                    } else {
                        i16++;
                    }
                }
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("dataSize", String.valueOf(list.size()));
            hashMap.put("highSize", String.valueOf(i3));
            hashMap.put("lowSize", String.valueOf(i16));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(((Automator) this.mAutomator).E.getCurrentAccountUin(), "qq_head_setting", false, 0L, 0L, hashMap, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        ((Automator) this.mAutomator).E.getApp().getSharedPreferences("HEAD", 0).edit().clear().commit();
        y();
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.app.automator.step.CleanCache.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            private int f195331d;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CleanCache.this);
                } else {
                    this.f195331d = 0;
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    try {
                        CleanCache.this.l(this.f195331d);
                        CleanCache.this.r();
                        StringBuilder sb5 = new StringBuilder();
                        String str = AppConstants.SDCARD_PATH;
                        sb5.append(str);
                        sb5.append("photo");
                        File file = new File(sb5.toString());
                        File[] fileArr = {file, new File(str + "ptv_template"), new File(AppConstants.PATH_CUSTOM_HEAD_ROOT_SDCARD + File.separator + "_dynamic")};
                        int i3 = 0;
                        for (int i16 = 0; i16 < 3; i16++) {
                            i3 += CleanCache.this.m(fileArr[i16], 2000, 500);
                        }
                        int m3 = i3 + CleanCache.this.m(new File(SafeBitmapFactory.LARGE_MAP_CACHE_PATH), 150, 50) + CleanCache.this.m(URLDrawableHelper.diskCachePath, 5000, 2000) + CleanCache.this.p();
                        if (QLog.isColorLevel()) {
                            QLog.d("IAutomator", 2, "onCleanCache. delete " + m3 + " cache file(s)");
                        }
                        CleanCache.this.q();
                        CleanCache.this.k();
                        CleanCache.this.s();
                        CleanCache.this.o();
                        CleanCache.this.n();
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                    ((Automator) CleanCache.this.mAutomator).notifyUI(40001, true, null);
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        }, 2, null, false);
        return 7;
    }

    void k() {
        File[] listFiles;
        try {
            File file = new File(QQCrashReportManager.f363160d + AppConstants.PATH_CRASH_INFO);
            if (file.exists() && (listFiles = file.listFiles(new e())) != null) {
                if (listFiles.length > 10) {
                    Arrays.sort(listFiles, new f());
                    for (int i3 = 10; i3 < listFiles.length; i3++) {
                        listFiles[i3].delete();
                    }
                }
            }
        } catch (Throwable th5) {
            QLog.d("IAutomator", 1, "", th5);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void q() {
        int i3;
        int parseInt;
        EntityManager createEntityManager = ((Automator) this.mAutomator).E.getEntityManagerFactory().createEntityManager();
        List<? extends Entity> query = createEntityManager.query(Setting.class, new Setting().getTableName(), false, (String) null, (String[]) null, (String) null, (String) null, (String) null, (String) null);
        if (query != null) {
            i3 = query.size();
        } else {
            i3 = 0;
        }
        ArrayList arrayList = new ArrayList();
        String[] split = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPCNames.headCfg.name(), IDPCApiConstant.HEAD_CONFIG_DEFAULT).split("\\|");
        if (split.length > 1) {
            try {
                parseInt = Integer.parseInt(split[1]);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("IAutomator", 2, "cleanSetingData,", e16);
                }
            }
            int i16 = parseInt;
            if (QLog.isColorLevel()) {
                QLog.d("IAutomator", 2, "cleanSetingData", i3 + "," + i16);
            }
            w(createEntityManager, query, i3, arrayList, i16);
            z(query);
        }
        parseInt = QzoneConfig.DEFAULT_PHOTOVIEW_PHOTO_BYTES;
        int i162 = parseInt;
        if (QLog.isColorLevel()) {
        }
        w(createEntityManager, query, i3, arrayList, i162);
        z(query);
    }

    void y() {
        if (QLog.isColorLevel()) {
            QLog.d("IAutomator", 2, "initNoMediaFile");
        }
        CardHandler.I2();
        FileManagerUtil.initNoMedia();
        for (String str : f195330d) {
            if (FileUtils.fileExists(str)) {
                t(str);
            }
        }
    }
}
