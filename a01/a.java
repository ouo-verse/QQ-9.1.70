package a01;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004JL\u0010\u0010\u001a\u0004\u0018\u00010\u00012\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\b\u0010\f\u001a\u0004\u0018\u00010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"La01/a;", "", "", "a", "La01/b;", "bridgeDelegate", "", "b", "", "methodId", "arg0", "arg1", "arg2", "arg3", "arg4", "arg5", "c", "La01/b;", "delegate", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f25308a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static b delegate;

    a() {
    }

    public final boolean a() {
        return delegate != null;
    }

    public final void b(b bridgeDelegate) {
        Intrinsics.checkNotNullParameter(bridgeDelegate, "bridgeDelegate");
        delegate = bridgeDelegate;
    }

    public final Object c(int methodId, Object arg0, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5) {
        b bVar = delegate;
        if (bVar != null) {
            return bVar.callNative(methodId, arg0, arg1, arg2, arg3, arg4, arg5);
        }
        return null;
    }
}
