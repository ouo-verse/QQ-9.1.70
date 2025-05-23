package fi1;

import android.content.Context;
import com.tencent.mobileqq.guild.discoveryv2.parts.tabs.TabsSnapshot;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"Lfi1/a;", "Lcom/tencent/qqperf/monitor/crash/safemode/a;", "Landroid/content/Context;", "context", "", "a", "", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a implements com.tencent.qqperf.monitor.crash.safemode.a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f398762a = new a();

    a() {
    }

    @Override // com.tencent.qqperf.monitor.crash.safemode.a
    public void a(@Nullable Context context) {
        QLog.e("DiscoverSafeModeStartUpRunner", 1, "doOnSafeModeStartUp run!");
        TabsSnapshot.f217705a.a();
    }

    @Override // com.tencent.qqperf.monitor.crash.safemode.a
    @NotNull
    public String b() {
        return "DiscoverSafeModeStartUpRunner";
    }
}
