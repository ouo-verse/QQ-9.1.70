package com.tencent.mobileqq.search.quicksearch;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0014\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\bR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/search/quicksearch/b;", "", "Lkotlin/Function0;", "", "action", "b", "", "a", "J", "minInterval", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "c", "lastExecutionTime", "", "d", "Z", "isPending", "<init>", "(J)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long minInterval;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler handler = new Handler(Looper.getMainLooper());

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long lastExecutionTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isPending;

    public b(long j3) {
        this.minInterval = j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(b this$0, Function0 action) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(action, "$action");
        this$0.isPending = false;
        action.invoke();
        this$0.lastExecutionTime = System.currentTimeMillis();
    }

    public final void b(@NotNull final Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        long currentTimeMillis = System.currentTimeMillis() - this.lastExecutionTime;
        if (currentTimeMillis >= this.minInterval) {
            action.invoke();
            this.lastExecutionTime = System.currentTimeMillis();
        } else if (!this.isPending) {
            this.isPending = true;
            this.handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.search.quicksearch.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.c(b.this, action);
                }
            }, this.minInterval - currentTimeMillis);
        }
    }
}
