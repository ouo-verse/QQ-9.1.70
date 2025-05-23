package p0;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\u00020\u0005\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0006\u0010\u0007J!\u0010\b\u001a\u00020\u0005\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\b\u0010\u0007J\u001c\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tH&J2\u0010\u0012\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0010H&J\u001e\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tH&J\u001e\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\rH&J&\u0010\u0015\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0011\u001a\u00020\u0010H&\u00a8\u0006\u0016"}, d2 = {"Lp0/c;", "", "Lp0/d;", "T", "plugin", "", "c", "(Lp0/d;)V", "e", "", AdMetricTag.EVENT_NAME, "params", "b", "Lorg/json/JSONObject;", "Lp0/b;", "listener", "", "bUseLog", "d", "f", "a", "I", "render_library_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public interface c {
    void I(@NotNull String eventName, @Nullable String params, boolean bUseLog);

    @Nullable
    String a(@NotNull String eventName, @Nullable JSONObject params);

    void b(@NotNull String eventName, @Nullable String params);

    <T extends d> void c(@NotNull T plugin);

    void d(@NotNull String eventName, @Nullable JSONObject params, @Nullable b listener, boolean bUseLog);

    <T extends d> void e(@NotNull T plugin);

    @Nullable
    String f(@NotNull String eventName, @Nullable String params);
}
