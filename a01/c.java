package a01;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015JL\u0010\n\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u00012\b\u0010\t\u001a\u0004\u0018\u00010\u0001J\u0006\u0010\f\u001a\u00020\u000bR$\u0010\u0013\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"La01/c;", "", "", "methodId", "arg0", "arg1", "arg2", "arg3", "arg4", "arg5", "c", "", "a", "La01/c$a;", "La01/c$a;", "getDelegate", "()La01/c$a;", "b", "(La01/c$a;)V", "delegate", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private a delegate;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\bf\u0018\u00002\u00020\u0001JN\u0010\n\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u00012\b\u0010\t\u001a\u0004\u0018\u00010\u0001H&\u00a8\u0006\u000b"}, d2 = {"La01/c$a;", "", "", "methodId", "arg0", "arg1", "arg2", "arg3", "arg4", "arg5", "callNative", "core_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public interface a {
        Object callNative(int methodId, Object arg0, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5);
    }

    public final void b(a aVar) {
        this.delegate = aVar;
    }

    public final Object c(int methodId, Object arg0, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5) {
        a aVar = this.delegate;
        if (aVar != null) {
            return aVar.callNative(methodId, arg0, arg1, arg2, arg3, arg4, arg5);
        }
        return null;
    }

    public final void a() {
    }
}
