package m01;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000f"}, d2 = {"Lm01/a;", "Lm01/b;", "", "values", "", "d", "f", "Ljava/lang/String;", "lastValues", "pagerId", "", "viewRef", "viewName", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends b {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String lastValues;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String pagerId, int i3, String viewName) {
        super(pagerId, i3, viewName);
        Intrinsics.checkNotNullParameter(pagerId, "pagerId");
        Intrinsics.checkNotNullParameter(viewName, "viewName");
    }

    public final void d(String values) {
        Intrinsics.checkNotNullParameter(values, "values");
        if (Intrinsics.areEqual(this.lastValues, values)) {
            return;
        }
        setProp("values", values);
        this.lastValues = values;
    }
}
