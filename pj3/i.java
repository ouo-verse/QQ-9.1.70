package pj3;

import dl0.h;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t74.r;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ&\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u0016\u0010\f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lpj3/i;", "Ldl0/h;", "", "eventCode", "", "params", "", "a", "type", "b", "", "Z", "isFilamentOpen", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class i implements dl0.h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isFilamentOpen;

    @Override // dl0.h
    public void a(String eventCode, Map<String, String> params) {
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        r.e(null, eventCode, params, 1, null);
    }

    @Override // dl0.h
    public void b(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        h.a.a(this, type);
        if (!this.isFilamentOpen) {
            com.tencent.mobileqq.perf.report.a.e(true);
        }
        this.isFilamentOpen = true;
    }
}
