package com.tencent.mobileqq.zplan.easteregg.asyntask;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 \u0007*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0001H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00028\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\t\u00a2\u0006\u0004\b\u000b\u0010\fJ%\u0010\r\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00028\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\tH$\u00a2\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00028\u0000H$\u00a2\u0006\u0004\b\u000f\u0010\u0010R3\u0010\u0017\u001a\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\t0\u00120\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/zplan/easteregg/asyntask/AsynTaskHandler;", "P", BdhLogUtil.LogTag.Tag_Req, "", "param", "result", "", "b", "(Ljava/lang/Object;Ljava/lang/Object;)V", "Lcom/tencent/mobileqq/zplan/easteregg/asyntask/a;", "listener", "e", "(Ljava/lang/Object;Lcom/tencent/mobileqq/zplan/easteregg/asyntask/a;)V", "f", "", "c", "(Ljava/lang/Object;)Ljava/lang/String;", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "a", "Lkotlin/Lazy;", "d", "()Ljava/util/concurrent/ConcurrentHashMap;", "listenerMap", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public abstract class AsynTaskHandler<P, R> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy listenerMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/easteregg/asyntask/AsynTaskHandler$b", "Lcom/tencent/mobileqq/zplan/easteregg/asyntask/a;", "result", "", "onResult", "(Ljava/lang/Object;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements a<R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AsynTaskHandler<P, R> f332876a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ P f332877b;

        b(AsynTaskHandler<P, R> asynTaskHandler, P p16) {
            this.f332876a = asynTaskHandler;
            this.f332877b = p16;
        }

        @Override // com.tencent.mobileqq.zplan.easteregg.asyntask.a
        public void onResult(R result) {
            this.f332876a.b(this.f332877b, result);
        }
    }

    public AsynTaskHandler() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ConcurrentHashMap<String, CopyOnWriteArrayList<a<R>>>>() { // from class: com.tencent.mobileqq.zplan.easteregg.asyntask.AsynTaskHandler$listenerMap$2
            @Override // kotlin.jvm.functions.Function0
            public final ConcurrentHashMap<String, CopyOnWriteArrayList<a<R>>> invoke() {
                return new ConcurrentHashMap<>();
            }
        });
        this.listenerMap = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void b(P param, R result) {
        CopyOnWriteArrayList<a<R>> copyOnWriteArrayList = d().get(c(param));
        if (copyOnWriteArrayList != null) {
            Iterator<a<R>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                a<R> next = it.next();
                next.onResult(result);
                copyOnWriteArrayList.remove(next);
                if (QLog.isDebugVersion()) {
                    QLog.i("AsynTaskHandler", 1, "task callback " + copyOnWriteArrayList.size());
                }
            }
        }
    }

    private final ConcurrentHashMap<String, CopyOnWriteArrayList<a<R>>> d() {
        return (ConcurrentHashMap) this.listenerMap.getValue();
    }

    protected abstract String c(P param);

    public final synchronized void e(P param, a<R> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        String c16 = c(param);
        if (d().get(c16) == null) {
            d().put(c16, new CopyOnWriteArrayList<>());
        }
        CopyOnWriteArrayList<a<R>> copyOnWriteArrayList = d().get(c16);
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.add(listener);
            if (copyOnWriteArrayList.size() > 1) {
                if (QLog.isDebugVersion()) {
                    QLog.i("AsynTaskHandler", 1, "task running " + copyOnWriteArrayList.size());
                }
                return;
            }
            f(param, new b(this, param));
        }
    }

    protected abstract void f(P param, a<R> listener);
}
