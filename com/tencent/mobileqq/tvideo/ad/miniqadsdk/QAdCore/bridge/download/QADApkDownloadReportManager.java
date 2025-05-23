package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.download;

import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.QADApkDownloadTaskState;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.f;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.thread.QAdThreadManager;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QADApkDownloadReportManager implements gv2.b {

    /* renamed from: b, reason: collision with root package name */
    private boolean f303763b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f303764c;

    /* renamed from: a, reason: collision with root package name */
    private c f303762a = new c();

    /* renamed from: d, reason: collision with root package name */
    private fv2.b f303765d = new fv2.b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f303768a;

        static {
            int[] iArr = new int[QADApkDownloadTaskState.values().length];
            f303768a = iArr;
            try {
                iArr[QADApkDownloadTaskState.TASK_DOWNLOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f303768a[QADApkDownloadTaskState.TASK_YYB_DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f303768a[QADApkDownloadTaskState.TASK_PAUSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f303768a[QADApkDownloadTaskState.TASK_SUCCEED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f303768a[QADApkDownloadTaskState.TASK_FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f303768a[QADApkDownloadTaskState.TASK_APK_INSTALLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f303768a[QADApkDownloadTaskState.TASK_LAUNCH_INSTALL_SUCCESS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f303768a[QADApkDownloadTaskState.TASK_LAUNCH_INSTALL_FAILED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f303768a[QADApkDownloadTaskState.TASK_DELETE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public QADApkDownloadReportManager(boolean z16, boolean z17) {
        this.f303763b = z16;
        this.f303764c = z17;
    }

    private void d(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.e eVar) {
        this.f303762a.b(eVar.d());
    }

    private b e(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.e eVar) {
        if (eVar == null) {
            return null;
        }
        return f(eVar.d());
    }

    private void g(b bVar, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.e eVar) {
        switch (a.f303768a[eVar.a().ordinal()]) {
            case 1:
            case 2:
                l(bVar, eVar);
                return;
            case 3:
                k(bVar, eVar);
                return;
            case 4:
                i(bVar, eVar);
                return;
            case 5:
                j(bVar, eVar);
                return;
            case 6:
                m(bVar, eVar);
                return;
            case 7:
                o(bVar, eVar);
                return;
            case 8:
                n(bVar, eVar);
                return;
            case 9:
                h(bVar, eVar);
                return;
            default:
                return;
        }
    }

    private void h(b bVar, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.e eVar) {
        fv2.a a16 = this.f303765d.a(bVar);
        if (a16 != null) {
            a16.b(bVar, eVar);
        }
    }

    private void i(b bVar, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.e eVar) {
        fv2.a a16 = this.f303765d.a(bVar);
        if (a16 != null) {
            a16.d(bVar, eVar);
        }
    }

    private void j(b bVar, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.e eVar) {
        fv2.a a16 = this.f303765d.a(bVar);
        if (a16 != null) {
            a16.e(bVar, eVar);
        }
    }

    private void k(b bVar, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.e eVar) {
        fv2.a a16 = this.f303765d.a(bVar);
        if (a16 != null) {
            a16.f(bVar, eVar);
        }
    }

    private void l(b bVar, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.e eVar) {
        fv2.a a16 = this.f303765d.a(bVar);
        if (a16 != null) {
            a16.g(bVar, eVar);
        }
    }

    private void m(b bVar, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.e eVar) {
        fv2.a a16 = this.f303765d.a(bVar);
        if (a16 != null) {
            a16.c(bVar, eVar);
        }
    }

    private void n(b bVar, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.e eVar) {
        fv2.a a16 = this.f303765d.a(bVar);
        if (a16 != null) {
            a16.a(bVar, eVar);
        }
    }

    private void o(b bVar, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.e eVar) {
        fv2.a a16 = this.f303765d.a(bVar);
        if (a16 != null) {
            a16.a(bVar, eVar);
        }
    }

    @Override // gv2.b
    @WorkerThread
    public void a(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.d dVar) {
        b f16;
        if (dVar != null && (f16 = f(dVar.a())) != null && f16.f303771b <= 0) {
            f16.f303771b = dVar.d();
            this.f303762a.d(dVar.a(), f16);
        }
    }

    @Override // gv2.b
    @WorkerThread
    public void b(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.e eVar) {
        b e16;
        if (eVar == null || (e16 = e(eVar)) == null) {
            return;
        }
        if (this.f303763b) {
            g(e16, eVar);
        }
        if (QADApkDownloadTaskState.TASK_DELETE == eVar.a() || QADApkDownloadTaskState.TASK_APK_INSTALLED == eVar.a()) {
            d(eVar);
        }
    }

    public b f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f303762a.c(str);
    }

    @MainThread
    public void p(final f fVar) {
        final b bVar = new b(fVar);
        QAdThreadManager.INSTANCE.execIo(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.download.QADApkDownloadReportManager.1
            @Override // java.lang.Runnable
            public void run() {
                QADApkDownloadReportManager.this.f303762a.a(fVar.f303811b, bVar);
            }
        });
    }
}
