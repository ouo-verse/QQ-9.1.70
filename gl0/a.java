package gl0;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J6\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0007\u0018\u00010\u0006H&J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H&\u00a8\u0006\r"}, d2 = {"Lgl0/a;", "", "", "filePath", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "", "rspHeader", "", "a", "errorMsg", "b", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public interface a {
    void a(@Nullable String filePath, int statusCode, @Nullable Map<String, ? extends List<String>> rspHeader);

    void b(@NotNull String errorMsg);
}
