package ky3;

import com.tencent.mobileqq.perf.rmonitor.QQRMonitorSDKManager;
import com.tencent.pb.performance.ClientPerformance$MonitorInfo;
import com.tencent.util.AppSetting;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lky3/a;", "", "", "log_url", "Lcom/tencent/pb/performance/ClientPerformance$MonitorInfo;", "a", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f413435a = new a();

    a() {
    }

    public static /* synthetic */ ClientPerformance$MonitorInfo b(a aVar, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        return aVar.a(str);
    }

    @NotNull
    public final ClientPerformance$MonitorInfo a(@Nullable String log_url) {
        Long longOrNull;
        ClientPerformance$MonitorInfo clientPerformance$MonitorInfo = new ClientPerformance$MonitorInfo();
        clientPerformance$MonitorInfo.app_version.set(AppSetting.getSubVersion());
        clientPerformance$MonitorInfo.uin.set(String.valueOf(QQRMonitorSDKManager.uin));
        clientPerformance$MonitorInfo.event_time.set(System.currentTimeMillis() / 1000);
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(AppSetting.getBuildNum());
        if (longOrNull != null) {
            clientPerformance$MonitorInfo.build_number.set(longOrNull.longValue());
        }
        if (log_url != null) {
            clientPerformance$MonitorInfo.log_url.set(log_url);
        }
        return clientPerformance$MonitorInfo;
    }
}
