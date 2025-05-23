package f94;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0014\u0010\n\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R0\u0010\u000e\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u000bj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006`\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lf94/c;", "", "", "refreshCurrentDress", "", "c", "Lmqq/util/WeakReference;", "Lf94/a;", "l", "b", "f", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "mListenerPool", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f398021a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final HashSet<WeakReference<a>> mListenerPool = new HashSet<>();

    c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(boolean z16) {
        Iterator<T> it = mListenerPool.iterator();
        while (it.hasNext()) {
            a aVar = (a) ((WeakReference) it.next()).get();
            if (aVar != null) {
                aVar.P(z16);
            }
        }
    }

    public final void b(WeakReference<a> l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        mListenerPool.add(l3);
    }

    public final void f(WeakReference<a> l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        mListenerPool.remove(l3);
    }

    public final void c(final boolean refreshCurrentDress) {
        QLog.i("ZPlanAvatarChangeManager_", 1, "refreshPannel");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: f94.b
            @Override // java.lang.Runnable
            public final void run() {
                c.e(refreshCurrentDress);
            }
        });
    }

    public static /* synthetic */ void d(c cVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        cVar.c(z16);
    }
}
