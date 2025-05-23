package com.tencent.gdtad.downloader;

import android.text.TextUtils;
import com.tencent.gdtad.IAdConfigApi;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.halley.downloader.DownloaderTask;
import com.tencent.halley.downloader.DownloaderTaskListener;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.open.base.MD5Utils;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.pm.PackageUtil;
import com.vivo.push.PushClientConstants;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\u0007\b&\u0018\u0000  2\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b'\u0010(J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\bH\u0002J\u0012\u0010\u0013\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0014\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0015\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0016\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0017\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0018\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0019\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u001a\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u001b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u001c\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u001d\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u001e\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u001f\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010 \u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006*"}, d2 = {"Lcom/tencent/gdtad/downloader/t;", "Lcom/tencent/halley/downloader/DownloaderTaskListener;", "Lcom/tencent/open/downloadnew/DownloadInfo;", "info", "Lcom/tencent/halley/downloader/DownloaderTask;", "task", "", "k", "", "url", "", "needUpdate", tl.h.F, "d", "", "eventId", "i", PushClientConstants.TAG_PKG_NAME, "g", "onTaskPendingMainloop", "onTaskStartedMainloop", "onTaskDetectedMainloop", "onTaskReceivedMainloop", "onTaskPausedMainloop", "onTaskFailedMainloop", "onTaskCompletedMainloop", "onTaskStartedSubloop", "onTaskDetectedSubloop", "onTaskReceivedSubloop", "onTaskPausedSubloop", "onTaskFailedSubloop", "onTaskCompletedSubloop", "f", "Lcom/tencent/open/downloadnew/DownloadInfo;", "mDownloadInfo", "", "e", "J", "mLastProgressUpdateTime", "<init>", "()V", "a", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public abstract class t implements DownloaderTaskListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private DownloadInfo mDownloadInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long mLastProgressUpdateTime;

    private final void d(final DownloadInfo info) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gdtad.downloader.r
            @Override // java.lang.Runnable
            public final void run() {
                t.e(t.this, info);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(t this$0, DownloadInfo info) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        ((IGdtAPI) QRoute.api(IGdtAPI.class)).registerAppInstallerReceiver(MobileQQ.sMobileQQ);
        this$0.i(4001009, info);
        if (info.T && !TextUtils.isEmpty(info.f341189h)) {
            String str = info.f341189h;
            Intrinsics.checkNotNullExpressionValue(str, "info.packageName");
            if (!this$0.g(str)) {
                info.S = 5;
                p.f109191a.e(info, null);
            }
        }
    }

    private final boolean g(String pkgName) {
        if (PackageUtil.isPackageInstalled(MobileQQ.sMobileQQ.getApplicationContext(), pkgName) && ((IAdConfigApi) QRoute.api(IAdConfigApi.class)).getCanInstallCheck()) {
            return true;
        }
        return false;
    }

    private final DownloadInfo h(String url, boolean needUpdate) {
        String str;
        DownloadInfo downloadInfo = this.mDownloadInfo;
        if (downloadInfo != null) {
            if (downloadInfo != null) {
                str = downloadInfo.f341186f;
            } else {
                str = null;
            }
            if (TextUtils.equals(str, url) && !needUpdate) {
                return this.mDownloadInfo;
            }
        }
        DownloadInfo k3 = j.f109185f.k(url);
        this.mDownloadInfo = k3;
        return k3;
    }

    private final void i(final int eventId, final DownloadInfo info) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gdtad.downloader.q
            @Override // java.lang.Runnable
            public final void run() {
                t.j(eventId, info);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(int i3, DownloadInfo info) {
        Intrinsics.checkNotNullParameter(info, "$info");
        u.f109203a.a(i3, info);
    }

    private final void k(final DownloadInfo info, DownloaderTask task) {
        if (task == null) {
            return;
        }
        info.f341180b0 = task.getTotalLen();
        info.V = task.getReceivedLen();
        info.L = task.getFullSavePath();
        if (info.f341180b0 != 0) {
            info.Q = (int) ((((float) info.V) * 100.0f) / ((float) task.getTotalLen()));
        }
        if (info.Q == 100 && info.f() != 4) {
            info.k(4);
        }
        if (info.Q != 100 && info.f() == 4) {
            info.Q = 100;
        }
        if (NetConnInfoCenter.getServerTimeMillis() - this.mLastProgressUpdateTime < 500 && info.f() == 2) {
            return;
        }
        this.mLastProgressUpdateTime = NetConnInfoCenter.getServerTimeMillis();
        QLog.d("AdDownloadTaskListener", 2, "doDownloadAction pParamsJson=" + info);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gdtad.downloader.s
            @Override // java.lang.Runnable
            public final void run() {
                t.l(DownloadInfo.this);
            }
        }, 16, null, false);
        f(info);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(DownloadInfo info) {
        Intrinsics.checkNotNullParameter(info, "$info");
        j.f109185f.w(info);
        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).updateAdDownloadNotice(info);
        info.C = "ANDROIDQQ.FEED.ADVERTISE_" + MD5Utils.toMD5(info.f341186f);
        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).updateAdDownloadFile(info);
    }

    public abstract void f(@Nullable DownloadInfo info);

    @Override // com.tencent.halley.downloader.DownloaderTaskListener
    public void onTaskCompletedMainloop(@Nullable DownloaderTask task) {
        QLog.d("AdDownloadTaskListener", 2, " onTaskCompletedMainloop");
        if (task != null) {
            String fileUrl = task.getFileUrl();
            Intrinsics.checkNotNullExpressionValue(fileUrl, "it.url");
            DownloadInfo h16 = h(fileUrl, false);
            if (h16 != null) {
                h16.k(4);
            }
            if (h16 != null) {
                k(h16, task);
                d(h16);
            }
        }
    }

    @Override // com.tencent.halley.downloader.DownloaderTaskListener
    public void onTaskCompletedSubloop(@Nullable DownloaderTask task) {
        QLog.d("AdDownloadTaskListener", 2, " onTaskCompletedSubloop");
        if (task != null) {
            String fileUrl = task.getFileUrl();
            Intrinsics.checkNotNullExpressionValue(fileUrl, "it.url");
            DownloadInfo h16 = h(fileUrl, false);
            if (h16 != null) {
                h16.k(4);
            }
            String savePath = task.getFullSavePath();
            if (savePath != null) {
                Intrinsics.checkNotNullExpressionValue(savePath, "savePath");
                if (AdAPKInjectUtil.d().e(h16, new File(task.getFullSavePath()), 324) && h16 != null) {
                    h16.f341205u0 = true;
                }
            }
            if (h16 != null) {
                k(h16, task);
            }
        }
    }

    @Override // com.tencent.halley.downloader.DownloaderTaskListener
    public void onTaskDetectedMainloop(@Nullable DownloaderTask task) {
        QLog.d("AdDownloadTaskListener", 2, " onTaskDetectedMainloop");
    }

    @Override // com.tencent.halley.downloader.DownloaderTaskListener
    public void onTaskDetectedSubloop(@Nullable DownloaderTask task) {
        QLog.d("AdDownloadTaskListener", 2, " onTaskDetectedSubloop");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.halley.downloader.DownloaderTaskListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onTaskFailedMainloop(@Nullable DownloaderTask task) {
        boolean z16;
        boolean z17;
        boolean z18 = true;
        QLog.d("AdDownloadTaskListener", 1, " onTaskFailedMainloop");
        if (task != null) {
            String fileUrl = task.getFileUrl();
            Intrinsics.checkNotNullExpressionValue(fileUrl, "downloaderTask.url");
            DownloadInfo h16 = h(fileUrl, false);
            if (h16 != null) {
                if (h16.Q > 95) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    z16 = true;
                    if (!z16) {
                        if (h16 == null || h16.f() != 4) {
                            z18 = false;
                        }
                        if (!z18) {
                            if (h16 != null) {
                                h16.k(30);
                            }
                            if (h16 != null) {
                                k(h16, task);
                                i(4001006, h16);
                                return;
                            }
                            return;
                        }
                    }
                    QLog.d("AdDownloadTaskListener", 2, " onTaskFailedMainloop error, cancel update state");
                    if (h16 != null) {
                    }
                }
            }
            z16 = false;
            if (!z16) {
            }
            QLog.d("AdDownloadTaskListener", 2, " onTaskFailedMainloop error, cancel update state");
            if (h16 != null) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.halley.downloader.DownloaderTaskListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onTaskFailedSubloop(@Nullable DownloaderTask task) {
        boolean z16;
        boolean z17;
        boolean z18 = true;
        QLog.d("AdDownloadTaskListener", 1, " onTaskFailedSubloop");
        if (task != null) {
            String fileUrl = task.getFileUrl();
            Intrinsics.checkNotNullExpressionValue(fileUrl, "downloaderTask.url");
            DownloadInfo h16 = h(fileUrl, false);
            if (h16 != null) {
                if (h16.Q > 95) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    z16 = true;
                    if (!z16) {
                        if (h16 == null || h16.f() != 4) {
                            z18 = false;
                        }
                        if (!z18) {
                            if (h16 != null) {
                                h16.k(30);
                            }
                            if (h16 != null) {
                                k(h16, task);
                                i(4001006, h16);
                                return;
                            }
                            return;
                        }
                    }
                    QLog.d("AdDownloadTaskListener", 2, " onTaskFailedSubloop error, cancel update state");
                    if (h16 != null) {
                    }
                }
            }
            z16 = false;
            if (!z16) {
            }
            QLog.d("AdDownloadTaskListener", 2, " onTaskFailedSubloop error, cancel update state");
            if (h16 != null) {
            }
        }
    }

    @Override // com.tencent.halley.downloader.DownloaderTaskListener
    public void onTaskPausedMainloop(@Nullable DownloaderTask task) {
        QLog.d("AdDownloadTaskListener", 2, " onTaskPausedMainloop");
        if (task != null) {
            String fileUrl = task.getFileUrl();
            Intrinsics.checkNotNullExpressionValue(fileUrl, "it.url");
            DownloadInfo h16 = h(fileUrl, true);
            if (h16 != null) {
                h16.k(3);
            }
            if (h16 != null) {
                k(h16, task);
                i(4001004, h16);
            }
        }
    }

    @Override // com.tencent.halley.downloader.DownloaderTaskListener
    public void onTaskPausedSubloop(@Nullable DownloaderTask task) {
        QLog.d("AdDownloadTaskListener", 2, " onTaskPausedSubloop");
    }

    @Override // com.tencent.halley.downloader.DownloaderTaskListener
    public void onTaskPendingMainloop(@Nullable DownloaderTask task) {
        QLog.d("AdDownloadTaskListener", 2, " onTaskPendingMainloop");
    }

    @Override // com.tencent.halley.downloader.DownloaderTaskListener
    public void onTaskReceivedMainloop(@Nullable DownloaderTask task) {
        QLog.d("AdDownloadTaskListener", 2, " onTaskReceivedMainloop");
        if (task != null) {
            String fileUrl = task.getFileUrl();
            Intrinsics.checkNotNullExpressionValue(fileUrl, "it.url");
            DownloadInfo h16 = h(fileUrl, false);
            if (h16 != null) {
                h16.k(2);
            }
            if (h16 != null) {
                k(h16, task);
            }
        }
    }

    @Override // com.tencent.halley.downloader.DownloaderTaskListener
    public void onTaskReceivedSubloop(@Nullable DownloaderTask task) {
        QLog.d("AdDownloadTaskListener", 2, " onTaskReceivedSubloop");
        if (task != null) {
            String fileUrl = task.getFileUrl();
            Intrinsics.checkNotNullExpressionValue(fileUrl, "it.url");
            DownloadInfo h16 = h(fileUrl, false);
            if (h16 != null) {
                h16.k(2);
            }
            if (h16 != null) {
                k(h16, task);
            }
        }
    }

    @Override // com.tencent.halley.downloader.DownloaderTaskListener
    public void onTaskStartedMainloop(@Nullable DownloaderTask task) {
        QLog.d("AdDownloadTaskListener", 2, " onTaskStartedMainloop");
        if (task != null) {
            String fileUrl = task.getFileUrl();
            Intrinsics.checkNotNullExpressionValue(fileUrl, "it.url");
            DownloadInfo h16 = h(fileUrl, false);
            if (h16 != null) {
                h16.k(1);
            }
            if (h16 != null) {
                k(h16, task);
            }
            AdAPKInjectUtil.d().c(h16);
        }
    }

    @Override // com.tencent.halley.downloader.DownloaderTaskListener
    public void onTaskStartedSubloop(@Nullable DownloaderTask task) {
    }
}
