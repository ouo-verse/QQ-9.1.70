package com.tencent.mobileqq.activity.about.modelviewer;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.activity.about.modelviewer.c;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.http.api.IHttpService;
import com.tencent.qqnt.http.api.b;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001bB\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0002J\u001c\u0010\f\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rJ\u001e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rJ \u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rJ\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/activity/about/modelviewer/c;", "", "", "d", "b", "", "e", "", "g", tl.h.F, "filePath", "md5", "c", "Lcom/tencent/mobileqq/activity/about/modelviewer/c$a;", "callback", "i", "url", "k", "Ljava/io/File;", "downloadFile", "j", "f", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mIsDownloading", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f177734a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final AtomicBoolean mIsDownloading;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/activity/about/modelviewer/c$a;", "", "", "modelPath", "", "b", "errorMsg", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public interface a {
        void a(@NotNull String errorMsg);

        void b(@NotNull String modelPath);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/activity/about/modelviewer/c$b", "Lcom/tencent/qqnt/http/api/l;", "Lcom/tencent/qqnt/http/api/b;", "task", "Lcom/tencent/qqnt/http/api/m;", "result", "", "onSuccess", "onFailed", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class b implements com.tencent.qqnt.http.api.l {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f177736a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ File f177737b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f177738c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f177739d;

        b(QQAppInterface qQAppInterface, File file, String str, a aVar) {
            this.f177736a = qQAppInterface;
            this.f177737b = file;
            this.f177738c = str;
            this.f177739d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, qQAppInterface, file, str, aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(File downloadFile) {
            Intrinsics.checkNotNullParameter(downloadFile, "$downloadFile");
            if (downloadFile.exists()) {
                FileUtils.deleteFile(downloadFile);
            }
            c.mIsDownloading.set(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(File downloadFile, String md5, a callback) {
            Intrinsics.checkNotNullParameter(downloadFile, "$downloadFile");
            Intrinsics.checkNotNullParameter(md5, "$md5");
            Intrinsics.checkNotNullParameter(callback, "$callback");
            c.f177734a.j(downloadFile, md5, callback);
            if (downloadFile.exists()) {
                FileUtils.deleteFile(downloadFile);
            }
            c.mIsDownloading.set(false);
        }

        @Override // com.tencent.qqnt.http.api.l
        public void onFailed(@NotNull com.tencent.qqnt.http.api.b task, @NotNull com.tencent.qqnt.http.api.m result) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) task, (Object) result);
                return;
            }
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("ModelDownloader", 1, "onDownloadFailed " + result);
            final File file = this.f177737b;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.about.modelviewer.e
                @Override // java.lang.Runnable
                public final void run() {
                    c.b.c(file);
                }
            }, 64, null, false);
            ReportController.o(this.f177736a, "dc00898", "", "", "0X800C5B5", "0X800C5B5", 2, 0, "", "", "", "");
        }

        @Override // com.tencent.qqnt.http.api.l
        public void onSuccess(@NotNull com.tencent.qqnt.http.api.b task, @NotNull com.tencent.qqnt.http.api.m result) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) task, (Object) result);
                return;
            }
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("ModelDownloader", 1, "onDownloadSuccess " + result);
            final File file = this.f177737b;
            final String str = this.f177738c;
            final a aVar = this.f177739d;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.about.modelviewer.d
                @Override // java.lang.Runnable
                public final void run() {
                    c.b.d(file, str, aVar);
                }
            }, 64, null, false);
            ReportController.o(this.f177736a, "dc00898", "", "", "0X800C5B5", "0X800C5B5", 1, 0, "", "", "", "");
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26624);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f177734a = new c();
            mIsDownloading = new AtomicBoolean(false);
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean b() {
        if (!FileUtils.fileExists(g())) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean c(String filePath, String md5) {
        String d16;
        boolean equals;
        byte[] fileMd5;
        try {
            fileMd5 = MD5.getFileMd5(filePath);
        } catch (Throwable th5) {
            QLog.e("ModelDownloader", 1, "MD5.getFileMd5 exception ", th5);
            try {
                d16 = com.tencent.qqprotect.singleupdate.a.d(new File(filePath));
            } catch (Exception e16) {
                QLog.e("ModelDownloader", 1, "MD5FileUtil.getFileMD5String exception ", e16);
            }
        }
        if (fileMd5 != null) {
            d16 = HexUtil.bytes2HexStr(fileMd5);
            if (d16 != null) {
                equals = StringsKt__StringsJVMKt.equals(d16, md5, true);
                if (equals) {
                    return true;
                }
            }
            return false;
        }
        d16 = null;
        if (d16 != null) {
        }
        return false;
    }

    private final boolean d() {
        if (!b() || !c(g(), "8a9092af8ad65fe4e06cc975b313db4f")) {
            return false;
        }
        return true;
    }

    private final void e() {
        String g16 = g();
        if (g16 != null) {
            FileUtils.deleteFile(g16);
        }
    }

    private final String g() {
        return new File(f(), "QQ.glb").getAbsolutePath();
    }

    private final String h() {
        File file = new File(f(), "download_" + System.currentTimeMillis() + "_" + new Random().nextInt(10));
        if (file.exists()) {
            file.delete();
        }
        return file.getAbsolutePath();
    }

    @Nullable
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        File file = new File(BaseApplication.getContext().getFilesDir().toString() + "/about/model");
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public final void i(@NotNull a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (b()) {
            String g16 = g();
            Intrinsics.checkNotNull(g16);
            callback.b(g16);
            return;
        }
        k("https://static-res.qq.com/static-res/devinsu/medal/about/filament/3DModel1117.zip", "dfcd6ee8b8c8f5473000a26360f71fd8", callback);
    }

    public final void j(@Nullable File downloadFile, @NotNull String md5, @NotNull a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, downloadFile, md5, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(md5, "md5");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (downloadFile != null && downloadFile.exists()) {
            if (!c(downloadFile.getAbsolutePath(), md5)) {
                QLog.e("ModelDownloader", 1, "download file md5 error");
                callback.a("md5 check failed");
                return;
            }
            try {
                e();
                FileUtils.uncompressZip(downloadFile.getAbsolutePath(), f(), false);
                FileUtils.deleteFile(downloadFile);
                if (!d()) {
                    QLog.e("ModelDownloader", 1, "download and uncompress success, but check fail");
                    e();
                    callback.a("files check failed");
                    return;
                } else {
                    String g16 = g();
                    Intrinsics.checkNotNull(g16);
                    callback.b(g16);
                    QLog.i("ModelDownloader", 1, "uncompress file success");
                    return;
                }
            } catch (IOException e16) {
                QLog.e("ModelDownloader", 1, "uncompress fail ", e16);
                callback.a("uncompress fail");
                return;
            }
        }
        QLog.e("ModelDownloader", 1, "download file is not exist");
        callback.a("download model file failed!");
    }

    public final void k(@NotNull String url, @NotNull String md5, @NotNull a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, url, md5, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(md5, "md5");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String h16 = h();
        AtomicBoolean atomicBoolean = mIsDownloading;
        QLog.i("ModelDownloader", 1, "startDownload, isDownloading=" + atomicBoolean.get());
        if (atomicBoolean.getAndSet(true)) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        Intrinsics.checkNotNull(h16);
        File file = new File(h16);
        ((IHttpService) QRoute.api(IHttpService.class)).asyncExecute(new b.a("about3DModel", url, file).T(new b(qQAppInterface, file, md5, callback)).c());
        ReportController.y(qQAppInterface, "0X800C5B4");
    }
}
