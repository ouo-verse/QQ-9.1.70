package h05;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.timi.game.utils.l;
import com.yolo.esports.download.cb.TaskCallbackCenter;
import com.yolo.esports.download.common.DownloadInfo;
import com.yolo.esports.download.common.HalleyDownloaderProxy;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a implements f05.a {

    /* renamed from: a, reason: collision with root package name */
    private HalleyDownloaderProxy f404032a;

    /* renamed from: b, reason: collision with root package name */
    private volatile Boolean f404033b = Boolean.FALSE;

    private void P3(DownloadInfo downloadInfo, DownloadInfo downloadInfo2) {
        downloadInfo2.L = downloadInfo.L;
        downloadInfo2.J = downloadInfo.J;
        if (!TextUtils.isEmpty(downloadInfo.f390015f)) {
            downloadInfo2.f390015f = downloadInfo.f390015f;
        }
        if (!TextUtils.isEmpty(downloadInfo.N)) {
            downloadInfo2.N = downloadInfo.N;
        }
        if (!TextUtils.isEmpty(downloadInfo.K) && TextUtils.isEmpty(downloadInfo2.K)) {
            downloadInfo2.K = downloadInfo.K;
        }
    }

    @Override // f05.a
    public int A3(@NotNull DownloadInfo downloadInfo) {
        return O3(downloadInfo, false);
    }

    @Override // f05.a
    public void C3(@NotNull String str) {
        String q16 = DownloadInfo.q(str);
        if (TextUtils.isEmpty(q16)) {
            return;
        }
        this.f404032a.e(q16, true);
    }

    @Override // f05.a
    public void J0(@NotNull DownloadInfo downloadInfo, @NotNull com.yolo.esports.download.cb.a aVar) {
        TaskCallbackCenter.f().e(downloadInfo.s(), aVar);
    }

    @Override // f05.a
    public void M0(@NotNull com.yolo.esports.download.cb.a aVar) {
        TaskCallbackCenter.f().o(aVar);
    }

    public int O3(@NotNull DownloadInfo downloadInfo, boolean z16) {
        String s16 = downloadInfo.s();
        if (TextUtils.isEmpty(s16)) {
            return -100;
        }
        DownloadInfo g16 = this.f404032a.g(s16);
        if (g16 == null) {
            l.i("DownloaderImpl_", "[startDownload] new task: info=" + downloadInfo);
            return this.f404032a.s(downloadInfo, z16);
        }
        P3(downloadInfo, g16);
        l.i("DownloaderImpl_", "[startDownload] old task: oldTask=" + g16);
        return this.f404032a.s(g16, z16);
    }

    @Override // f05.a
    public void b1(@NotNull com.yolo.esports.download.cb.a aVar) {
        TaskCallbackCenter.f().d(aVar);
    }

    @Override // f05.a
    public void f3(@NotNull com.yolo.esports.download.cb.a aVar) {
        TaskCallbackCenter.f().n(aVar);
    }

    @Override // mm4.a
    public void init(Context context) {
        if (!this.f404033b.booleanValue()) {
            synchronized (this) {
                if (!this.f404033b.booleanValue() || this.f404032a == null) {
                    HalleyDownloaderProxy h16 = HalleyDownloaderProxy.h();
                    this.f404032a = h16;
                    h16.j();
                    wn4.a.f445988a.i(this);
                }
                this.f404033b = Boolean.TRUE;
            }
        }
    }

    @Override // mm4.a
    public void o2() {
        wn4.a.f445988a.c();
        this.f404033b = Boolean.FALSE;
    }

    @Override // f05.a
    public DownloadInfo v0(@NotNull String str) {
        String q16 = DownloadInfo.q(str);
        if (TextUtils.isEmpty(q16)) {
            return null;
        }
        return this.f404032a.g(q16);
    }

    public void N3() {
    }
}
