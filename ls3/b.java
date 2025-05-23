package ls3;

import com.tencent.qq.minibox.manager.MiniBoxDownloadTask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J@\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0002H&J+\u0010\u0015\u001a\u00020\f2!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\f0\u000fH&J\b\u0010\u0016\u001a\u00020\fH&\u00a8\u0006\u0017"}, d2 = {"Lls3/b;", "", "", "appId", "packageName", "apkUrl", "", "versionCode", "appName", "iconUrl", "Lls3/a;", "fromExt", "", "b", "c", "Lkotlin/Function1;", "Lcom/tencent/qq/minibox/manager/MiniBoxDownloadTask;", "Lkotlin/ParameterName;", "name", "task", "callback", "a", "destroy", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public interface b {
    void a(@NotNull Function1<? super MiniBoxDownloadTask, Unit> callback);

    void b(@NotNull String appId, @NotNull String packageName, @NotNull String apkUrl, int versionCode, @NotNull String appName, @NotNull String iconUrl, @NotNull DownloadFromExt fromExt);

    void c(@NotNull String packageName);

    void destroy();
}
