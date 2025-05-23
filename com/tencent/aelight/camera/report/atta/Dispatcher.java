package com.tencent.aelight.camera.report.atta;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.AppInterface;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/aelight/camera/report/atta/Dispatcher;", "", "", "currentToken", "", "c", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", "Ljava/util/LinkedList;", "Lcom/tencent/aelight/camera/report/atta/Dispatcher$a;", "Ljava/util/LinkedList;", "logQueue", "Ljava/lang/Object;", "logQueueOpLock", "Ljava/util/concurrent/atomic/AtomicLong;", "d", "Ljava/util/concurrent/atomic/AtomicLong;", "requestToken", "<init>", "()V", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class Dispatcher {

    /* renamed from: a, reason: collision with root package name */
    public static final Dispatcher f69018a = new Dispatcher();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static LinkedList<a> logQueue = new LinkedList<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Object logQueueOpLock = new Object();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static AtomicLong requestToken = new AtomicLong(0);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\tR\u0011\u0010\u000e\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/aelight/camera/report/atta/Dispatcher$a;", "", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "c", "", "a", "Ljava/util/List;", "()Ljava/util/List;", "content", "", "b", "()I", "size", "<init>", "(Ljava/lang/String;)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final List<String> content;

        public a(String item) {
            List<String> mutableListOf;
            Intrinsics.checkNotNullParameter(item, "item");
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(item);
            this.content = mutableListOf;
        }

        public final List<String> a() {
            return this.content;
        }

        public final int b() {
            return this.content.size();
        }

        public final void c(String item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.content.add(item);
        }
    }

    Dispatcher() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(long currentToken) {
        boolean z16;
        List<String> emptyList;
        List<String> list;
        AppInterface a16 = com.tencent.aelight.camera.aebase.a.a();
        if (a16 == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (requestToken.compareAndSet(currentToken, currentTimeMillis)) {
            synchronized (logQueueOpLock) {
                z16 = true;
                if (!(!logQueue.isEmpty())) {
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                } else {
                    emptyList = logQueue.removeLast().a();
                }
                list = emptyList;
            }
            List<String> list2 = list;
            if (list2 != null && !list2.isEmpty()) {
                z16 = false;
            }
            if (z16) {
                requestToken.compareAndSet(currentTimeMillis, 0L);
            } else {
                f.f69041a.a(a16, currentTimeMillis, list, new Function2<Long, Boolean, Unit>() { // from class: com.tencent.aelight.camera.report.atta.Dispatcher$triggerRequest$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Long l3, Boolean bool) {
                        invoke(l3.longValue(), bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(long j3, boolean z17) {
                        Dispatcher.f69018a.c(j3);
                    }
                });
            }
        }
    }

    public final void b(String item) {
        Intrinsics.checkNotNullParameter(item, "item");
        synchronized (logQueueOpLock) {
            if (logQueue.isEmpty()) {
                logQueue.addFirst(new a(item));
            } else if (logQueue.getFirst().b() < 50) {
                logQueue.getFirst().c(item);
            } else if (logQueue.size() > 50) {
                ms.a.c("AttaReport", "too many log, ignore");
            } else {
                logQueue.addFirst(new a(item));
            }
            Unit unit = Unit.INSTANCE;
        }
        c(0L);
    }
}
