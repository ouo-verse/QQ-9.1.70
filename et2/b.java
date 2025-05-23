package et2;

import androidx.annotation.MainThread;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H'J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H'\u00a8\u0006\u000b"}, d2 = {"Let2/b;", "", "Let2/a;", "customShortcutBar", "", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "", "a", "", "b", "close", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public interface b {
    void a(@NotNull a customShortcutBar, @NotNull String businessName);

    @MainThread
    boolean b(@NotNull String businessName);

    @MainThread
    void close(@NotNull String businessName);
}
