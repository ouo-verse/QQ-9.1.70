package com.tencent.mobileqq.vas.social;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.state.square.IThreadManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0006\u001a\u00020\u00032\u0010\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u0004H\u0016J\"\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0010\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\nH\u0016J\u001a\u0010\f\u001a\u00020\u00032\u0010\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u0004H\u0016J\u001a\u0010\r\u001a\u00020\u00032\u0010\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u0004H\u0016J\"\u0010\u000e\u001a\u00020\u00032\u0010\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001a\u0010\u000f\u001a\u00020\u00032\u0010\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u0004H\u0016J$\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0010\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/vas/social/u;", "Lcom/tencent/state/square/IThreadManager;", "Lkotlin/Function0;", "", "Lcom/tencent/state/square/Task;", "task", "postOnUi", "", "delay", "postOnUiDelayed", "Ljava/lang/Runnable;", "removeTask", "removeTaskOnUI", "postOnFileThread", "postOnFileThreadDelay", "postOnSubThread", "postOnSubThreadDelay", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class u implements IThreadManager {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    @Override // com.tencent.state.square.IThreadManager
    public void postOnFileThread(final Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.social.r
            @Override // java.lang.Runnable
            public final void run() {
                u.h(Function0.this);
            }
        }, 64, null, false);
    }

    @Override // com.tencent.state.square.IThreadManager
    public void postOnFileThreadDelay(final Function0<Unit> task, long delay) {
        Intrinsics.checkNotNullParameter(task, "task");
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.vas.social.t
            @Override // java.lang.Runnable
            public final void run() {
                u.i(Function0.this);
            }
        }, 64, null, false, delay);
    }

    @Override // com.tencent.state.square.IThreadManager
    public void postOnSubThread(final Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.social.o
            @Override // java.lang.Runnable
            public final void run() {
                u.j(Function0.this);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.state.square.IThreadManager
    public Runnable postOnSubThreadDelay(final Function0<Unit> task, long delay) {
        Intrinsics.checkNotNullParameter(task, "task");
        return ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.vas.social.p
            @Override // java.lang.Runnable
            public final void run() {
                u.k(Function0.this);
            }
        }, 16, null, false, delay);
    }

    @Override // com.tencent.state.square.IThreadManager
    public void postOnUi(final Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.social.q
            @Override // java.lang.Runnable
            public final void run() {
                u.l(Function0.this);
            }
        });
    }

    @Override // com.tencent.state.square.IThreadManager
    public void postOnUiDelayed(long delay, final Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.vas.social.s
            @Override // java.lang.Runnable
            public final void run() {
                u.m(Function0.this);
            }
        }, delay);
    }

    @Override // com.tencent.state.square.IThreadManager
    public void removeTask(Runnable task) {
        Intrinsics.checkNotNullParameter(task, "task");
        ThreadManagerV2.removeJob(task, 16);
    }

    @Override // com.tencent.state.square.IThreadManager
    public void removeTaskOnUI(final Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(new Runnable() { // from class: com.tencent.mobileqq.vas.social.n
            @Override // java.lang.Runnable
            public final void run() {
                u.n(Function0.this);
            }
        });
    }
}
