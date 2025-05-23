package jy2;

import com.tencent.component.network.module.base.QDLog;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Ljy2/d;", "Ljy2/a;", QDLog.TAG_DOWNLOAD, "", "g", "Lcom/tencent/open/downloadnew/DownloadListener;", "listener", "e", "a", "Lcom/tencent/open/downloadnew/DownloadInfo;", "info", "c", "", "b", "", "url", "f", "d", "getDownloadInfoByUrl", "Ljy2/a;", "mDownloader", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class d implements a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f411161a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static a mDownloader;

    d() {
    }

    @Override // jy2.a
    public void a(@NotNull DownloadListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        a aVar = mDownloader;
        if (aVar != null) {
            aVar.a(listener);
        }
    }

    @Override // jy2.a
    public boolean b(@NotNull DownloadInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        a aVar = mDownloader;
        if (aVar != null) {
            return aVar.b(info);
        }
        return false;
    }

    @Override // jy2.a
    public void c(@NotNull DownloadInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        a aVar = mDownloader;
        if (aVar != null) {
            aVar.c(info);
        }
    }

    @Override // jy2.a
    public boolean d(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        a aVar = mDownloader;
        if (aVar != null) {
            return aVar.d(url);
        }
        return false;
    }

    @Override // jy2.a
    public void e(@NotNull DownloadListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        a aVar = mDownloader;
        if (aVar != null) {
            aVar.e(listener);
        }
    }

    @Override // jy2.a
    public void f(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        a aVar = mDownloader;
        if (aVar != null) {
            aVar.f(url);
        }
    }

    public final void g(@NotNull a downloader) {
        Intrinsics.checkNotNullParameter(downloader, "downloader");
        mDownloader = downloader;
    }

    @Override // jy2.a
    @Nullable
    public DownloadInfo getDownloadInfoByUrl(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        a aVar = mDownloader;
        if (aVar != null) {
            return aVar.getDownloadInfoByUrl(url);
        }
        return null;
    }
}
