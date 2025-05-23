package f05;

import com.yolo.esports.download.common.DownloadInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH&J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH&\u00a8\u0006\u0011"}, d2 = {"Lf05/a;", "Lmm4/a;", "Lcom/yolo/esports/download/common/DownloadInfo;", "info", "", "A3", "", "url", "", "C3", "v0", "Lcom/yolo/esports/download/cb/a;", "listener", "b1", "M0", "J0", "f3", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes28.dex */
public interface a extends mm4.a {
    int A3(@NotNull DownloadInfo info);

    void C3(@NotNull String url);

    void J0(@NotNull DownloadInfo info, @NotNull com.yolo.esports.download.cb.a listener);

    void M0(@NotNull com.yolo.esports.download.cb.a listener);

    void b1(@NotNull com.yolo.esports.download.cb.a listener);

    void f3(@NotNull com.yolo.esports.download.cb.a listener);

    @Nullable
    DownloadInfo v0(@NotNull String url);
}
