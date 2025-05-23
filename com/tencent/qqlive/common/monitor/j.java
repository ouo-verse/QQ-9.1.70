package com.tencent.qqlive.common.monitor;

import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\t\b\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0006\u0010\t\u001a\u00020\u0004R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\r\u0082\u0001\u0006\u0011\u0012\u0013\u0014\u0015\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqlive/common/monitor/j;", "", "Lcom/tencent/qqlive/common/monitor/m;", "watcher", "", "a", "c", "b", "e", "d", "Ljava/util/LinkedList;", "Ljava/util/LinkedList;", "getWatchers", "()Ljava/util/LinkedList;", "watchers", "<init>", "()V", "Lcom/tencent/qqlive/common/monitor/a;", "Lcom/tencent/qqlive/common/monitor/b;", "Lcom/tencent/qqlive/common/monitor/c;", "Lcom/tencent/qqlive/common/monitor/d;", "Lcom/tencent/qqlive/common/monitor/e;", "Lcom/tencent/qqlive/common/monitor/f;", "qq-live-common-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkedList<m> watchers;

    public /* synthetic */ j(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final void a(@NotNull m watcher) {
        Intrinsics.checkNotNullParameter(watcher, "watcher");
        if (this.watchers.contains(watcher)) {
            return;
        }
        this.watchers.add(watcher);
    }

    public final void c(@NotNull m watcher) {
        Intrinsics.checkNotNullParameter(watcher, "watcher");
        this.watchers.remove(watcher);
    }

    public final void d() {
        Iterator<T> it = this.watchers.iterator();
        while (it.hasNext()) {
            ((m) it.next()).onNotify(this);
        }
    }

    j() {
        this.watchers = new LinkedList<>();
    }

    public void b() {
    }

    public void e() {
    }
}
