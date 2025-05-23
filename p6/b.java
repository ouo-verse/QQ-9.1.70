package p6;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.qzone.misc.network.downloader.FileDownloaderManager;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import com.tencent.component.network.utils.thread.ThreadPool;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.util.MultiHashMap;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes35.dex */
public class b {

    /* renamed from: d, reason: collision with root package name */
    private static b f425421d;

    /* renamed from: a, reason: collision with root package name */
    private final MultiHashMap<p6.a, c> f425422a = new MultiHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private Downloader f425423b = null;

    /* renamed from: c, reason: collision with root package name */
    private final Handler f425424c = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class a implements ThreadPool.Job<Object> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ p6.a f425425d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f425426e;

        a(p6.a aVar, String str) {
            this.f425425d = aVar;
            this.f425426e = str;
        }

        @Override // com.tencent.component.network.utils.thread.ThreadPool.Job
        public Object run(ThreadPool.JobContext jobContext) {
            if (TextUtils.isEmpty(this.f425425d.f425416c)) {
                b.this.j(this.f425425d);
            }
            if (URLUtil.isNetworkUrl(this.f425426e)) {
                this.f425425d.f425416c = CacheManager.getAvatarFileCacheService().getPath(this.f425425d.f425417d);
                p6.a aVar = this.f425425d;
                aVar.f425419f = b.this.r(aVar);
                Downloader s16 = b.this.s();
                String insertMtype = MsfSdkUtils.insertMtype(AppConstants.HTTP_TYPE_QZONE_DOWNLOAD_AVATAR, this.f425426e);
                p6.a aVar2 = this.f425425d;
                s16.download(insertMtype, aVar2.f425416c, true, aVar2.f425419f);
                return null;
            }
            b bVar = b.this;
            p6.a aVar3 = this.f425425d;
            bVar.D(aVar3, bVar.k(aVar3, true));
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public interface c {
        void a(String str);

        void b(String str);

        void c(AnimationDrawable animationDrawable, String str, String str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static class d implements FilenameFilter {

        /* renamed from: d, reason: collision with root package name */
        private String f425430d;

        public d(String str) {
            this.f425430d = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            String str2 = this.f425430d;
            if (str2 == null) {
                return true;
            }
            return str.endsWith(str2);
        }
    }

    public static String F(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (URLUtil.isNetworkUrl(str)) {
            return str;
        }
        if (str.startsWith("file://")) {
            str = str.substring(7);
        }
        String str2 = File.separator;
        if (str.startsWith(str2)) {
            return str;
        }
        return str2 + str;
    }

    public static File G(String str, String str2) {
        File y16 = y(str, str2);
        m(y16);
        if (ZipUtils.unZipFolder(str2, y16.getAbsolutePath()) == 0) {
            return y16;
        }
        return null;
    }

    private Collection<c> l(p6.a aVar, boolean z16, Collection<c> collection) {
        c cVar;
        synchronized (this.f425422a) {
            if (z16) {
                cVar = this.f425422a.remove(aVar);
            } else {
                cVar = this.f425422a.get(aVar);
            }
            Collection<c> collection2 = (Collection) cVar;
            if (collection == null) {
                return collection2;
            }
            collection.clear();
            if (collection2 != null) {
                collection.addAll(collection2);
            }
            return collection;
        }
    }

    private static void m(File file) {
        if (!file.exists()) {
            file.mkdir();
            return;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return;
            }
            for (File file2 : listFiles) {
                if (!file2.isDirectory()) {
                    file2.delete();
                }
            }
            return;
        }
        file.mkdir();
    }

    public static boolean n(String str) {
        String dir = CacheManager.getAvatarFileCacheService().getDir();
        if (TextUtils.isEmpty(dir)) {
            return false;
        }
        File file = new File(dir + File.separator + q(str));
        if (!file.exists()) {
            return file.mkdir();
        }
        if (file.isDirectory()) {
            return false;
        }
        return file.mkdir();
    }

    public static String p(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String F = F(str);
        String b16 = o6.a.d().b(F);
        return TextUtils.isEmpty(b16) ? F : b16;
    }

    private static String q(String str) {
        String substring;
        int lastIndexOf;
        int lastIndexOf2 = str.lastIndexOf("/");
        if (lastIndexOf2 == -1 || (lastIndexOf = (substring = str.substring(0, lastIndexOf2)).lastIndexOf("/")) == -1) {
            return null;
        }
        return substring.substring(lastIndexOf + 1, substring.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Downloader.DownloadListener r(p6.a aVar) {
        return new C10982b(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Downloader s() {
        Downloader downloader;
        Downloader downloader2 = this.f425423b;
        if (downloader2 != null) {
            return downloader2;
        }
        try {
            downloader = FileDownloaderManager.g().getDownloader();
        } catch (Throwable th5) {
            QZLog.e(QZLog.TO_DEVICE_TAG, "getFileDownloader exception:" + th5.getStackTrace());
            downloader = null;
        }
        this.f425423b = downloader;
        return downloader;
    }

    private static String v(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return String.valueOf(str.hashCode());
    }

    public static b w() {
        b bVar = f425421d;
        if (bVar != null) {
            return bVar;
        }
        synchronized (b.class) {
            b bVar2 = f425421d;
            if (bVar2 != null) {
                return bVar2;
            }
            b bVar3 = new b();
            f425421d = bVar3;
            return bVar3;
        }
    }

    public static String[] x(String str, String str2) {
        String str3 = str2.substring(0, str2.lastIndexOf("/")) + File.separator + str;
        StringBuilder sb5 = new StringBuilder();
        File[] listFiles = new File(str3).listFiles(new d(".png"));
        if (!TextUtils.isEmpty(str3) && listFiles != null) {
            for (int i3 = 0; i3 < listFiles.length; i3++) {
                if (i3 != listFiles.length - 1) {
                    sb5.append(listFiles[i3].getName() + "_");
                } else {
                    sb5.append(listFiles[i3].getName());
                }
            }
        }
        return new String[]{str3, sb5.toString()};
    }

    public static File y(String str, String str2) {
        return new File(str2.substring(0, str2.lastIndexOf("/")) + File.separator + str);
    }

    public static boolean z(String str) {
        File[] listFiles;
        return new File(str).exists() && (listFiles = new File(str).listFiles(new d(".png"))) != null && listFiles.length > 0;
    }

    protected String B(p6.a aVar) {
        if (TextUtils.isEmpty(aVar.f425416c)) {
            j(aVar);
        }
        if (!TextUtils.isEmpty(aVar.f425416c)) {
            return aVar.f425416c;
        }
        PriorityThreadPool.getDefault().submit(new a(aVar, aVar.f425415b), PriorityThreadPool.Priority.HIGH);
        return null;
    }

    public String i(String str, String str2, c cVar) {
        if (!TextUtils.isEmpty(str) && cVar != null) {
            p6.a o16 = o(str, str2);
            j(o16);
            String str3 = o16.f425416c;
            if (!TextUtils.isEmpty(str3)) {
                return str3;
            }
            if (h(o16, cVar)) {
                B(o16);
            }
        }
        return "";
    }

    protected p6.a o(String str, String str2) {
        p6.a a16 = p6.a.a(p(str), str2);
        a16.f425415b = str;
        return a16;
    }

    public AnimationDrawable t(String str, String str2, String str3) {
        if (QZLog.isColorLevel()) {
            QZLog.d("FileLoader", 2, "getDrawable|url:" + str + "|ZipPath:" + str2);
        }
        String str4 = str2.substring(0, str2.lastIndexOf("/")) + File.separator + str3;
        if (!z(str4)) {
            if (QZLog.isDevelopLevel()) {
                QZLog.d("FileLoader", 4, str4 + " has miss");
            }
            G(str3, str2);
        }
        AnimationDrawable animationDrawable = new AnimationDrawable();
        File[] listFiles = new File(str4).listFiles(new d(".png"));
        if (listFiles != null) {
            for (File file : listFiles) {
                Bitmap r16 = com.qzone.util.image.c.r(file.getAbsolutePath(), ViewUtils.dip2px(92.0f), ViewUtils.dip2px(105.0f));
                if (r16 != null) {
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(r16);
                    bitmapDrawable.setBounds(0, 0, ViewUtils.dip2px(92.0f), ViewUtils.dip2px(105.0f));
                    animationDrawable.addFrame(bitmapDrawable, 110);
                }
            }
            return animationDrawable;
        }
        QZLog.w("FileLoader", "unzip failed");
        return null;
    }

    public File u(String str) {
        File file;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String F = F(str);
        if (TextUtils.isEmpty(F)) {
            return null;
        }
        if (URLUtil.isNetworkUrl(str)) {
            String b16 = o6.a.d().b(F);
            if (!TextUtils.isEmpty(b16)) {
                F = b16;
            }
            file = CacheManager.getAvatarFileCacheService().getFile(v(F));
        } else {
            file = new File(F);
        }
        if (A(file)) {
            return file;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Collection<c> k(p6.a aVar, boolean z16) {
        return l(aVar, z16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean A(File file) {
        return file != null && file.isFile() && file.length() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(p6.a aVar, Collection<c> collection) {
        if (collection == null) {
            return;
        }
        for (c cVar : collection) {
            if (cVar != null) {
                cVar.b(aVar.f425415b);
            }
        }
    }

    protected void j(p6.a aVar) {
        if (aVar == null) {
            return;
        }
        File u16 = u(aVar.f425415b);
        if (u16 != null) {
            aVar.f425416c = u16.getAbsolutePath();
            aVar.f425417d = u16.getName();
        } else {
            aVar.f425417d = v(aVar.f425414a);
        }
    }

    protected boolean h(p6.a aVar, c cVar) {
        boolean z16;
        if (cVar == null) {
            return false;
        }
        synchronized (this.f425422a) {
            int sizeOf = this.f425422a.sizeOf(aVar);
            this.f425422a.add(aVar, cVar);
            z16 = sizeOf == 0;
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(p6.a aVar, Collection<c> collection) {
        if (aVar == null || collection == null) {
            return;
        }
        for (c cVar : collection) {
            if (cVar != null) {
                cVar.a(aVar.f425415b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(p6.a aVar, Collection<c> collection) {
        if (aVar == null || collection == null) {
            return;
        }
        for (c cVar : collection) {
            if (cVar != null) {
                cVar.c(t(aVar.f425415b, aVar.f425416c, aVar.f425418e), aVar.f425417d, aVar.f425416c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: p6.b$b, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    public class C10982b implements Downloader.DownloadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ p6.a f425428a;

        C10982b(p6.a aVar) {
            this.f425428a = aVar;
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadCanceled(String str) {
            b bVar = b.this;
            p6.a aVar = this.f425428a;
            bVar.C(aVar, bVar.k(aVar, true));
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadFailed(String str, DownloadResult downloadResult) {
            b bVar = b.this;
            p6.a aVar = this.f425428a;
            bVar.D(aVar, bVar.k(aVar, true));
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadSucceed(String str, DownloadResult downloadResult) {
            p6.a aVar = this.f425428a;
            String str2 = aVar.f425416c;
            if (str2 == null) {
                b bVar = b.this;
                bVar.D(aVar, bVar.k(aVar, true));
                return;
            }
            File file = new File(str2);
            if (!b.A(file) && !CacheManager.isInternal(str2) && downloadResult.getPath() != null) {
                str2 = CacheManager.getAvatarFileCacheService().getPath(this.f425428a.f425417d);
                FileUtils.copyFiles(new File(downloadResult.getPath()), file);
            }
            if (!TextUtils.isEmpty(str2)) {
                CacheManager.getAvatarFileCacheService().updateLruFile(str2, true);
                this.f425428a.f425416c = str2;
            }
            if (str2 == null) {
                b bVar2 = b.this;
                p6.a aVar2 = this.f425428a;
                bVar2.D(aVar2, bVar2.k(aVar2, true));
            } else {
                b.G(this.f425428a.f425418e, str2);
                b bVar3 = b.this;
                p6.a aVar3 = this.f425428a;
                bVar3.E(aVar3, bVar3.k(aVar3, true));
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadProgress(String str, long j3, float f16) {
        }
    }
}
