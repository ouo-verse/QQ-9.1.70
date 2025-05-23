package ec3;

import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.mobileqq.zootopia.utils.m;
import com.tencent.qqperf.reporter.flow.TrafficFlowReporter;
import com.tencent.qqperf.reporter.flow.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J.\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n\u00a8\u0006\u0010"}, d2 = {"Lec3/c;", "", "", "networkTypeString", "", "a", "url", "taskUniqueKey", "fileSizeInKB", "businessScene", "", "isSilentDownload", "", "b", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f396091a = new c();

    c() {
    }

    private final int a(String networkTypeString) {
        boolean equals;
        equals = StringsKt__StringsJVMKt.equals(networkTypeString, Global.TRACKING_WIFI, true);
        if (equals) {
            return ((com.tencent.mobileqq.vip.d.d() == 1) && ac3.b.INSTANCE.e().getEnableDualDownload()) ? 2 : 0;
        }
        return 1;
    }

    public final void b(String url, String taskUniqueKey, String fileSizeInKB, String businessScene, boolean isSilentDownload) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(taskUniqueKey, "taskUniqueKey");
        Intrinsics.checkNotNullParameter(fileSizeInKB, "fileSizeInKB");
        Intrinsics.checkNotNullParameter(businessScene, "businessScene");
        String b16 = m.f329564a.b();
        TrafficFlowReporter.r(new b.a().b(1).k(url).e(fileSizeInKB).c(businessScene).g(a(b16)).f(!isSilentDownload ? 1 : 0).h(taskUniqueKey).i(b16).a());
    }
}
