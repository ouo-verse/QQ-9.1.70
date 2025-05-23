package d94;

import kotlin.Metadata;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016R\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\b\u00a8\u0006\u000b"}, d2 = {"Ld94/c;", "", "Ld94/b;", "callback", "", "a", "b", "Lmqq/util/WeakReference;", "Lmqq/util/WeakReference;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f393249a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static WeakReference<b> callback;

    c() {
    }

    public void b() {
        WeakReference<b> weakReference = callback;
        if (weakReference != null) {
            weakReference.clear();
        }
        callback = null;
    }

    public void a(b callback2) {
        if (callback2 == null) {
            return;
        }
        callback = new WeakReference<>(callback2);
    }
}
