package jo;

import com.tencent.mobileqq.vas.VasPerfReportUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR.\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u0003\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\f\u0010\u0014\"\u0004\b\u0012\u0010\u0015R\"\u0010\u0019\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0017\u0010\u0015\u00a8\u0006\u001c"}, d2 = {"Ljo/a;", "", "", "a", "J", "getTotalCost", "()J", "e", "(J)V", VasPerfReportUtils.WHILE_COST_TOTAL, "", "", "b", "Ljava/util/Map;", "()Ljava/util/Map;", "setCostMap", "(Ljava/util/Map;)V", "costMap", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "sessionId", "d", "getStreamName", "streamName", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long totalCost;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Map<String, Long> costMap = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String sessionId = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String streamName = "";

    public final Map<String, Long> a() {
        return this.costMap;
    }

    /* renamed from: b, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sessionId = str;
    }

    public final void d(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.streamName = str;
    }

    public final void e(long j3) {
        this.totalCost = j3;
    }
}
