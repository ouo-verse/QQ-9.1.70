package com.tencent.biz.qqcircle.immersive.redpacket.task;

import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007\u00a2\u0006\u0004\b$\u0010%J9\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00028\u00002\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ%\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00028\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0002J\u0016\u0010\u0013\u001a\u00020\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u0011H\u0002J\u0014\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004H&J9\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00028\u00002\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0016\u00a2\u0006\u0004\b\u0016\u0010\u000bJ\b\u0010\u0017\u001a\u00020\tH\u0016R\"\u0010\u001f\u001a\u00020\u00188\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/task/BaseTask;", "DATA", "", "data", "Ljava/util/LinkedList;", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/p;", "processList", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/o;", "callback", "", tl.h.F, "(Ljava/lang/Object;Ljava/util/LinkedList;Lcom/tencent/biz/qqcircle/immersive/redpacket/task/o;)V", "e", "(Ljava/lang/Object;Lcom/tencent/biz/qqcircle/immersive/redpacket/task/o;)V", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/k;", "errorCode", "d", "Lkotlin/Function0;", "action", "l", "j", "initial", "g", "f", "", "a", "Z", "i", "()Z", "setCancelled", "(Z)V", "cancelled", "", "k", "()Ljava/lang/String;", "tag", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public abstract class BaseTask<DATA> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private volatile boolean cancelled;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/biz/qqcircle/immersive/redpacket/task/BaseTask$a", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/o;", "value", "", "onSuccess", "(Ljava/lang/Object;)V", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/k;", "errorCode", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class a implements o<DATA> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseTask<DATA> f89518a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ p<DATA> f89519b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ LinkedList<p<DATA>> f89520c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ o<DATA> f89521d;

        a(BaseTask<DATA> baseTask, p<DATA> pVar, LinkedList<p<DATA>> linkedList, o<DATA> oVar) {
            this.f89518a = baseTask;
            this.f89519b = pVar;
            this.f89520c = linkedList;
            this.f89521d = oVar;
        }

        @Override // com.tencent.biz.qqcircle.immersive.redpacket.task.o
        public void a(@NotNull ErrorCode errorCode) {
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            QLog.w(this.f89518a.k(), 1, "doTaskInternal, " + this.f89519b.a() + ", onError, errorCode:" + errorCode + ", cancelled: " + this.f89518a.getCancelled());
            if (!this.f89518a.getCancelled()) {
                this.f89518a.d(errorCode, this.f89521d);
            }
        }

        @Override // com.tencent.biz.qqcircle.immersive.redpacket.task.o
        public void onSuccess(DATA value) {
            QLog.d(this.f89518a.k(), 1, "doTaskInternal, " + this.f89519b.a() + ", onSuccess, value:" + value + ", cancelled:" + this.f89518a.getCancelled());
            if (!this.f89518a.getCancelled()) {
                this.f89518a.h(value, this.f89520c, this.f89521d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(final ErrorCode errorCode, final o<DATA> callback) {
        l(new Function0<Unit>() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.task.BaseTask$callbackErrorOnMain$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                callback.a(errorCode);
            }
        });
    }

    private final void e(final DATA data, final o<DATA> callback) {
        l(new Function0<Unit>() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.task.BaseTask$callbackSuccessOnMain$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                callback.onSuccess(data);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(DATA data, LinkedList<p<DATA>> processList, o<DATA> callback) {
        boolean z16;
        QLog.d(k(), 1, "doTaskInternal, data:" + data);
        if (processList != null && !processList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.d(k(), 1, "doTaskInternal, end ");
            e(data, callback);
            return;
        }
        p<DATA> remove = processList.remove(0);
        Intrinsics.checkNotNullExpressionValue(remove, "processList.removeAt(0)");
        p<DATA> pVar = remove;
        QLog.d(k(), 1, "doTaskInternal, process:" + pVar);
        pVar.b(data, new a(this, pVar, processList, callback));
    }

    private final void l(final Function0<Unit> action) {
        if (RFWThreadManager.isMainThread()) {
            action.invoke();
        } else {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.task.f
                @Override // java.lang.Runnable
                public final void run() {
                    BaseTask.m(Function0.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Function0 action) {
        Intrinsics.checkNotNullParameter(action, "$action");
        action.invoke();
    }

    public void f() {
        QLog.d(k(), 1, "cancel ");
        this.cancelled = true;
        Iterator<T> it = j().iterator();
        while (it.hasNext()) {
            ((p) it.next()).cancel();
        }
    }

    public void g(DATA initial, @NotNull LinkedList<p<DATA>> processList, @NotNull o<DATA> callback) {
        Intrinsics.checkNotNullParameter(processList, "processList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LinkedList<p<DATA>> linkedList = new LinkedList<>();
        Iterator<T> it = processList.iterator();
        while (it.hasNext()) {
            linkedList.add((p) it.next());
        }
        if (linkedList.isEmpty()) {
            QLog.d(k(), 1, "doTask, processList is null or empty ");
            e(initial, callback);
        } else {
            h(initial, linkedList, callback);
        }
    }

    /* renamed from: i, reason: from getter */
    protected final boolean getCancelled() {
        return this.cancelled;
    }

    @NotNull
    public abstract LinkedList<p<DATA>> j();

    @NotNull
    public abstract String k();
}
