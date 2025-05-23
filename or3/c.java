package or3;

import com.tencent.qmethod.monitor.report.base.reporter.data.ReportData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\b"}, d2 = {"Lor3/c;", "", "Lcom/tencent/qmethod/monitor/report/base/reporter/data/ReportData;", "reportData", "Lor3/c$a;", "callback", "", "a", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public interface c {
    boolean a(@NotNull ReportData reportData, @Nullable a callback);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lor3/c$a;", "", "", "dbId", "", "onSuccess", "errorCode", "", "errorMsg", "a", "onCached", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes22.dex */
    public interface a {
        void a(int errorCode, @NotNull String errorMsg, int dbId);

        void onCached();

        void onSuccess(int dbId);

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
        /* renamed from: or3.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes22.dex */
        public static final class C10936a {
            public static void a(a aVar) {
            }
        }
    }
}
