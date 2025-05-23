package mb4;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ,\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lmb4/c;", "", "", "eventCode", "", "params", "", "realTime", "", "b", "Lmb4/a;", "Lmb4/a;", "reporter", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f416532a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final a reporter = new a();

    c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(String eventCode, HashMap tmpParams, boolean z16) {
        Intrinsics.checkNotNullParameter(eventCode, "$eventCode");
        Intrinsics.checkNotNullParameter(tmpParams, "$tmpParams");
        reporter.e(eventCode, tmpParams, z16);
    }

    public final void b(final String eventCode, Map<String, String> params, final boolean realTime) {
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        Intrinsics.checkNotNullParameter(params, "params");
        final HashMap hashMap = new HashMap();
        hashMap.putAll(params);
        QLog.i("ZPlanTechReportManager_", 4, "reportEvent eventCode:" + eventCode + ", params:" + hashMap);
        ThreadManagerV2.excute(new Runnable() { // from class: mb4.b
            @Override // java.lang.Runnable
            public final void run() {
                c.d(eventCode, hashMap, realTime);
            }
        }, 128, null, false);
    }

    public static /* synthetic */ void c(c cVar, String str, Map map, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        cVar.b(str, map, z16);
    }
}
