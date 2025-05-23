package p0;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\t"}, d2 = {"Lp0/d;", "", "", "", "getEvents", AdMetricTag.EVENT_NAME, "Lp0/a;", "argument", "handleEvent", "render_library_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public interface d {
    @Nullable
    List<String> getEvents();

    @Nullable
    String handleEvent(@NotNull String eventName, @NotNull a argument);
}
