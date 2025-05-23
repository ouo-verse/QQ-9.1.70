package com.tencent.qqnt.qbasealbum.inject;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u000f"}, d2 = {"com/tencent/qqnt/qbasealbum/inject/QBaseAlbumCustomize$Builder$threadManager$1", "Lcom/tencent/qqnt/qbasealbum/inject/e;", "Ljava/lang/Runnable;", "runnable", "", "type", "", "execute", "b", "I", "availableProcessors", "Ljava/util/concurrent/ThreadPoolExecutor;", "c", "Ljava/util/concurrent/ThreadPoolExecutor;", "threadPool", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class QBaseAlbumCustomize$Builder$threadManager$1 implements e {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int availableProcessors;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ThreadPoolExecutor threadPool;

    /* JADX INFO: Access modifiers changed from: package-private */
    public QBaseAlbumCustomize$Builder$threadManager$1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        this.availableProcessors = availableProcessors;
        int i3 = (availableProcessors * 2) + 1;
        int i16 = (availableProcessors * 2) + 1;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        final QBaseAlbumCustomize$Builder$threadManager$1$threadPool$1 qBaseAlbumCustomize$Builder$threadManager$1$threadPool$1 = QBaseAlbumCustomize$Builder$threadManager$1$threadPool$1.INSTANCE;
        this.threadPool = new BaseThreadPoolExecutor(i3, i16, 0L, timeUnit, new PriorityBlockingQueue(11, new Comparator() { // from class: com.tencent.qqnt.qbasealbum.inject.h
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int b16;
                b16 = QBaseAlbumCustomize$Builder$threadManager$1.b(Function2.this, obj, obj2);
                return b16;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int b(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }

    @Override // com.tencent.qqnt.qbasealbum.inject.e
    public void execute(@NotNull Runnable runnable, int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable, type);
        } else {
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            this.threadPool.execute(runnable);
        }
    }
}
