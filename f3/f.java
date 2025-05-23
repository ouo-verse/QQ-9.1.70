package f3;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.yolo.esports.download.cb.TaskCallbackCenter;
import com.yolo.esports.download.common.DownloadInfo;
import f3.f;
import java.io.File;

/* compiled from: P */
/* loaded from: classes2.dex */
public class f {

    /* renamed from: b, reason: collision with root package name */
    private static final IAegisLogApi f397771b = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    /* renamed from: c, reason: collision with root package name */
    private static volatile f f397772c;

    /* renamed from: a, reason: collision with root package name */
    private final f05.a f397773a = com.tencent.mobileqq.qqlive.sail.b.f272169b;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements com.yolo.esports.download.cb.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ h3.a f397774a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ h3.b f397775b;

        a(h3.a aVar, h3.b bVar) {
            this.f397774a = aVar;
            this.f397775b = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void h(h3.b bVar, DownloadInfo downloadInfo) {
            if (bVar != null) {
                bVar.a(downloadInfo.f390014e, (int) downloadInfo.F, (int) downloadInfo.G);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void i(h3.a aVar, DownloadInfo downloadInfo) {
            if (aVar != null) {
                aVar.b(downloadInfo.f390014e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void j(h3.a aVar, DownloadInfo downloadInfo) {
            if (aVar != null) {
                aVar.a(downloadInfo.f390014e, new g3.a(downloadInfo.H, downloadInfo.I), new g3.b());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void k(h3.a aVar, DownloadInfo downloadInfo) {
            if (aVar != null) {
                aVar.c(downloadInfo.f390014e, new File(downloadInfo.f390017i), null);
            }
        }

        @Override // com.yolo.esports.download.cb.a
        public void a(final DownloadInfo downloadInfo) {
            f.f397771b.i("FileLoader", "onTaskStart, url:" + downloadInfo.f390014e + Thread.currentThread().getName());
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final h3.a aVar = this.f397774a;
            uIHandlerV2.post(new Runnable() { // from class: f3.d
                @Override // java.lang.Runnable
                public final void run() {
                    f.a.i(h3.a.this, downloadInfo);
                }
            });
        }

        @Override // com.yolo.esports.download.cb.a
        public void b(final DownloadInfo downloadInfo) {
            f.f397771b.i("FileLoader", "onTaskProgressChanged, progress:" + downloadInfo.t() + Thread.currentThread().getName());
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final h3.b bVar = this.f397775b;
            uIHandlerV2.post(new Runnable() { // from class: f3.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.a.h(h3.b.this, downloadInfo);
                }
            });
        }

        @Override // com.yolo.esports.download.cb.a
        public void c(final DownloadInfo downloadInfo) {
            f.f397771b.i("FileLoader", "onTaskStateChanged, url:" + downloadInfo.f390014e + ", state:" + downloadInfo.M + Thread.currentThread().getName());
            if (downloadInfo.H != 0) {
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final h3.a aVar = this.f397774a;
                uIHandlerV2.post(new Runnable() { // from class: f3.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        f.a.j(h3.a.this, downloadInfo);
                    }
                });
                f.this.f397773a.f3(this);
                return;
            }
            if (downloadInfo.v()) {
                Handler uIHandlerV22 = ThreadManagerV2.getUIHandlerV2();
                final h3.a aVar2 = this.f397774a;
                uIHandlerV22.post(new Runnable() { // from class: f3.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        f.a.k(h3.a.this, downloadInfo);
                    }
                });
                f.this.f397773a.f3(this);
            }
        }
    }

    f() {
    }

    private DownloadInfo e(String str) {
        DownloadInfo downloadInfo = new DownloadInfo();
        String f16 = f(BaseApplication.getContext());
        String b16 = i05.a.b(str);
        downloadInfo.f390014e = str;
        downloadInfo.f390015f = b16;
        downloadInfo.f390016h = f16;
        downloadInfo.U = i(str);
        f397771b.i("FileLoader", "downloadPath:" + f16);
        return downloadInfo;
    }

    private String f(Context context) {
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            return i05.a.c();
        }
        return externalFilesDir.getAbsolutePath() + "/tencent/qqlive/accompany";
    }

    private String h(String str) {
        String b16 = i05.a.b(str);
        String i3 = i(str);
        if (TextUtils.isEmpty(i3)) {
            return b16;
        }
        return b16 + "." + i3;
    }

    private String i(String str) {
        String lastPathSegment = Uri.parse(str).getLastPathSegment();
        if (!TextUtils.isEmpty(lastPathSegment) && lastPathSegment.endsWith(".tkm")) {
            return "tkm";
        }
        return "";
    }

    public static f j() {
        if (f397772c == null) {
            synchronized (f.class) {
                if (f397772c == null) {
                    f397772c = new f();
                }
            }
        }
        return f397772c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k(h3.a aVar, String str, int i3, DownloadInfo downloadInfo) {
        if (aVar != null) {
            aVar.a(str, new g3.a(i3, downloadInfo.I), new g3.b());
        }
    }

    public void d(String str) {
        this.f397773a.C3(str);
    }

    public File g(String str) {
        String str2 = f(BaseApplication.getContext()) + "/" + h(str);
        f397771b.i("FileLoader", "getFileFromDisk, fileAbsPath:" + str2);
        return new File(str2);
    }

    public void l(final String str, final h3.a aVar, h3.b bVar) {
        final DownloadInfo e16 = e(str);
        this.f397773a.J0(e16, new a(aVar, bVar));
        final int A3 = this.f397773a.A3(e16);
        f397771b.i("FileLoader", "startDownload result:" + A3);
        if (A3 == -100) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: f3.a
                @Override // java.lang.Runnable
                public final void run() {
                    f.k(h3.a.this, str, A3, e16);
                }
            });
        } else if (A3 == -99) {
            e16.H = A3;
            TaskCallbackCenter.f().l(e16.s(), e16);
        }
    }

    public void m() {
    }
}
