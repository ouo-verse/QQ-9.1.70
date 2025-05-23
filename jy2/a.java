package jy2;

import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH&J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\fH&\u00a8\u0006\u0011"}, d2 = {"Ljy2/a;", "", "Lcom/tencent/open/downloadnew/DownloadListener;", "listener", "", "e", "a", "Lcom/tencent/open/downloadnew/DownloadInfo;", "info", "c", "", "b", "", "url", "f", "d", "getDownloadInfoByUrl", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public interface a {
    void a(@NotNull DownloadListener listener);

    boolean b(@NotNull DownloadInfo info);

    void c(@NotNull DownloadInfo info);

    boolean d(@NotNull String url);

    void e(@NotNull DownloadListener listener);

    void f(@NotNull String url);

    @Nullable
    DownloadInfo getDownloadInfoByUrl(@NotNull String url);
}
