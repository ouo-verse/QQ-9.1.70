package oa0;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0016\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00028\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R$\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Loa0/a;", "T", "", "a", "()Ljava/lang/Object;", "Ljava/lang/Object;", "content", "", "<set-?>", "b", "Z", "getHasBeenHandled", "()Z", "hasBeenHandled", "<init>", "(Ljava/lang/Object;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public class a<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final T content;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean hasBeenHandled;

    public a(T t16) {
        this.content = t16;
    }

    @Nullable
    public final T a() {
        if (this.hasBeenHandled) {
            return null;
        }
        this.hasBeenHandled = true;
        return this.content;
    }
}
