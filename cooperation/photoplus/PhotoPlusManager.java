package cooperation.photoplus;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.portal.o;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.f;
import com.tencent.mobileqq.vip.g;
import com.tencent.mobileqq.vip.h;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.util.VersionUtils;
import cooperation.photoplus.sticker.Sticker;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import org.json.JSONException;

/* loaded from: classes28.dex */
public class PhotoPlusManager implements Manager {
    public static final String C = AppConstants.SDCARD_PATH + "PhotoPlus/";

    /* renamed from: d, reason: collision with root package name */
    private AppInterface f390150d;

    /* renamed from: e, reason: collision with root package name */
    private List<Sticker> f390151e;

    /* renamed from: f, reason: collision with root package name */
    private ConcurrentHashMap<String, g> f390152f = new ConcurrentHashMap<>();

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f390153h = false;

    /* renamed from: i, reason: collision with root package name */
    private volatile boolean f390154i = false;

    /* renamed from: m, reason: collision with root package name */
    private MqqWeakReferenceHandler f390155m;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes28.dex */
    public class UpdateTask implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private List<Sticker> f390156d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f390157e;

        public UpdateTask(List<Sticker> list, boolean z16) {
            if (list != null) {
                this.f390156d = new ArrayList(list);
            }
            this.f390157e = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f390157e) {
                PhotoPlusManager.this.e(this.f390156d);
                return;
            }
            if (this.f390156d == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("PhotoPlusManager", 2, "[updateStickerResource] saved stickers = null");
                    return;
                }
                return;
            }
            if (!FileUtils.hasSDCardAndWritable()) {
                QLog.e("PhotoPlusManager", 1, "sdcard unavailable");
                return;
            }
            for (int i3 = 0; i3 < this.f390156d.size(); i3++) {
                Sticker sticker = this.f390156d.get(i3);
                if (QLog.isColorLevel()) {
                    QLog.d("PhotoPlusManager", 2, "[updateStickerResource] saved sticker:" + sticker);
                }
                StringBuilder sb5 = new StringBuilder();
                String str = PhotoPlusManager.C;
                sb5.append(str);
                sb5.append(sticker.getZipFilePath());
                String sb6 = sb5.toString();
                if (!new File(sb6).exists()) {
                    PhotoPlusManager.this.f(sticker.url, sb6, sticker.md5);
                } else {
                    String unzippedDir = sticker.getUnzippedDir();
                    String str2 = str + unzippedDir + sticker.getImageFileName();
                    String str3 = str + unzippedDir + sticker.getThumbImageFileName();
                    File file = new File(str2);
                    File file2 = new File(str3);
                    if (!file.exists() || !file2.exists()) {
                        if (QLog.isColorLevel()) {
                            QLog.e("PhotoPlusManager", 2, "[updateStickerResource] zip exist but resource not exist:" + sticker.getZipFilePath());
                        }
                        if (TextUtils.isEmpty(sticker.md5)) {
                            PhotoPlusManager.this.j(sb6);
                        } else {
                            if (sticker.md5.equalsIgnoreCase(o.e(sb6))) {
                                PhotoPlusManager.this.j(sb6);
                            } else {
                                if (QLog.isColorLevel()) {
                                    QLog.d("PhotoPlusManager", 2, "[updateStickerResource] checkMd5 failed: " + sb6);
                                }
                                FileUtils.deleteFile(sb6);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes28.dex */
    public class a extends f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f390158a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f390159b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f390160c;

        a(String str, String str2, String str3) {
            this.f390158a = str;
            this.f390159b = str2;
            this.f390160c = str3;
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onCancel(g gVar) {
            PhotoPlusManager.this.f390152f.remove(this.f390158a);
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDone(g gVar) {
            PhotoPlusManager.this.f390152f.remove(this.f390158a);
            if (gVar.i() == 3) {
                if (QLog.isColorLevel()) {
                    QLog.d("PhotoPlusManager", 2, "[onDone] download finished " + this.f390159b);
                }
                if (TextUtils.isEmpty(this.f390160c)) {
                    PhotoPlusManager.this.j(this.f390158a);
                    return;
                }
                if (this.f390160c.equalsIgnoreCase(o.e(this.f390158a))) {
                    PhotoPlusManager.this.j(this.f390158a);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("PhotoPlusManager", 2, "[onDone] checkMd5 failed: " + this.f390158a);
                }
                FileUtils.deleteFile(this.f390158a);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("PhotoPlusManager", 2, "[onDone] downloadFile failed: " + gVar.f313007e + " code=" + gVar.f313006d);
            }
        }
    }

    public PhotoPlusManager(AppInterface appInterface) {
        if (QLog.isColorLevel()) {
            QLog.d("PhotoPlusManager", 2, "[constructor]");
        }
        this.f390150d = appInterface;
        EntityManager createEntityManager = appInterface.getEntityManagerFactory().createEntityManager();
        this.f390151e = createEntityManager.query(Sticker.class, new Sticker().getTableName(), false, (String) null, (String[]) null, (String) null, (String) null, (String) null, (String) null);
        createEntityManager.close();
        this.f390155m = new MqqWeakReferenceHandler(ThreadManagerV2.getFileThreadLooper(), null);
        k(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(List<Sticker> list) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d("PhotoPlusManager", 2, "[deleteOldResources] start");
        }
        String str = C;
        File file = new File(str);
        if (file.exists()) {
            if (file.isDirectory()) {
                if (list == null) {
                    FileUtils.deleteDirectory(str);
                    return;
                }
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        if (file2.isDirectory()) {
                            String name = file2.getName();
                            Iterator<Sticker> it = list.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    Sticker next = it.next();
                                    if (name.equals(next.f390165id)) {
                                        String valueOf = String.valueOf(next.version);
                                        String str2 = next.version + ".zip";
                                        File[] listFiles2 = file2.listFiles();
                                        if (listFiles2 != null) {
                                            for (File file3 : listFiles2) {
                                                if (file3.isDirectory()) {
                                                    if (!file3.getName().equals(valueOf)) {
                                                        if (QLog.isColorLevel()) {
                                                            QLog.d("PhotoPlusManager", 2, "[updateStickerResource] delete old dir: " + file2.getName() + File.separator + file3.getName());
                                                        }
                                                        FileUtils.deleteDirectory(file3.getAbsolutePath());
                                                    }
                                                } else if (!file3.getName().equals(str2)) {
                                                    if (QLog.isColorLevel()) {
                                                        QLog.d("PhotoPlusManager", 2, "[updateStickerResource] delete old file: " + file2.getName() + File.separator + file3.getName());
                                                    }
                                                    file3.delete();
                                                }
                                            }
                                        }
                                        z16 = true;
                                    }
                                } else {
                                    z16 = false;
                                    break;
                                }
                            }
                            if (!z16) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("PhotoPlusManager", 2, "[updateStickerResource] delete old dir: " + file2.getName());
                                }
                                FileUtils.deleteDirectory(file2.getAbsolutePath());
                            }
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.d("PhotoPlusManager", 2, "[updateStickerResource] delete error file: " + file2.getName());
                            }
                            file2.delete();
                        }
                    }
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("PhotoPlusManager", 2, "[updateStickerResource] delete photo plus root directory");
            }
            file.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, String str2, String str3) {
        g gVar = this.f390152f.get(str2);
        if (gVar != null) {
            if (gVar.i() != 2 && gVar.i() != 3) {
                if (QLog.isColorLevel()) {
                    QLog.d("PhotoPlusManager", 2, "[download] task status error, cancel it " + str2);
                }
                gVar.c(true);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("PhotoPlusManager", 2, "[download] duplicated " + str2);
                    return;
                }
                return;
            }
        }
        g gVar2 = new g(str, new File(str2));
        gVar2.Q = true;
        h u16 = ((DownloaderFactory) this.f390150d.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).u(1);
        if (QLog.isColorLevel()) {
            QLog.d("PhotoPlusManager", 2, "[download] startDownload: " + str + " path=" + str2);
        }
        this.f390152f.put(str2, gVar2);
        u16.startDownload(gVar2, new a(str2, str, str3), null);
    }

    public List<Sticker> d() {
        if (this.f390151e == null) {
            return null;
        }
        return new ArrayList(this.f390151e);
    }

    public boolean g(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("PhotoPlusManager", 2, "[onNewConfigReceived] config:" + str);
        }
        if (this.f390153h) {
            return false;
        }
        try {
            this.f390151e = Sticker.parse(str);
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("PhotoPlusManager", 2, "[onNewConfigReceived] parse failed", e16);
            }
        }
        if (this.f390151e == null) {
            if (QLog.isColorLevel()) {
                QLog.d("PhotoPlusManager", 2, "[onNewConfigReceived] sticker = null");
            }
            return true;
        }
        if (QLog.isColorLevel()) {
            Iterator<Sticker> it = this.f390151e.iterator();
            while (it.hasNext()) {
                QLog.d("PhotoPlusManager", 2, "[onNewConfigReceived] sticker:" + it.next());
            }
        }
        EntityManager createEntityManager = this.f390150d.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = createEntityManager.getTransaction();
        try {
            try {
                transaction.begin();
                createEntityManager.drop(Sticker.class);
                Iterator<Sticker> it5 = this.f390151e.iterator();
                while (it5.hasNext()) {
                    createEntityManager.persistOrReplace(it5.next());
                }
                transaction.commit();
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.e("PhotoPlusManager", 2, "[onNewConfigReceived] db operation failed", e17);
                }
            }
            transaction.end();
            createEntityManager.close();
            k(true);
            return true;
        } catch (Throwable th5) {
            transaction.end();
            throw th5;
        }
    }

    public void h(boolean z16) {
        this.f390153h = z16;
    }

    public void i(boolean z16) {
        this.f390154i = z16;
    }

    void j(String str) {
        try {
            FileUtils.uncompressZip(str, str.substring(0, str.indexOf(".zip")) + File.separator, false);
            if (QLog.isColorLevel()) {
                QLog.d("PhotoPlusManager", 2, "[unzip] success: " + str);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("PhotoPlusManager", 2, "[unzip]", e16);
            }
            if (Utils.z() > 40960) {
                FileUtils.deleteFile(str);
            }
        }
    }

    public void k(boolean z16) {
        if (VersionUtils.isIceScreamSandwich()) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PhotoPlusManager", 2, "[updateStickerResource] isDelete=" + z16);
        }
        this.f390155m.post(new UpdateTask(this.f390151e, z16));
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
    }
}
