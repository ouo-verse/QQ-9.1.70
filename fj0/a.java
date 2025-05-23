package fj0;

import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.ecommerce.biz.common.e;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u000b"}, d2 = {"Lfj0/a;", "", "", "groupId", "", "a", "", "windowType", "b", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f399472a = new a();

    a() {
    }

    public final void a(String groupId) {
        e eVar = new e();
        eVar.b("group_id", groupId);
        Map<Object, Object> f16 = eVar.f();
        cg0.a.b("ECQGroupWindowReport", "[reportGroupWindowRequest] " + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "qgroup_window_request", f16, false, 4, null);
    }

    public final void b(String groupId, int windowType) {
        e eVar = new e();
        eVar.b("group_id", groupId);
        eVar.b("window_type", String.valueOf(windowType));
        Map<Object, Object> f16 = eVar.f();
        cg0.a.b("ECQGroupWindowReport", "[reportGroupWindowRequest] " + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "qgroup_window_request_success", f16, false, 4, null);
    }
}
