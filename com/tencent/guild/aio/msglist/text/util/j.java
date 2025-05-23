package com.tencent.guild.aio.msglist.text.util;

import androidx.lifecycle.Observer;
import kotlin.Metadata;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B\u000f\u0012\u0006\u0010\b\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0007J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0001H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00028\u0001H&\u00a2\u0006\u0004\b\t\u0010\nR\"\u0010\u000f\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00018\u00008\u00000\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/guild/aio/msglist/text/util/j;", "Closure", "T", "Landroidx/lifecycle/Observer;", "value", "", "onChanged", "(Ljava/lang/Object;)V", "closure", "a", "(Ljava/lang/Object;Ljava/lang/Object;)V", "Lmqq/util/WeakReference;", "kotlin.jvm.PlatformType", "d", "Lmqq/util/WeakReference;", "mClosureWeakRef", "<init>", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public abstract class j<Closure, T> implements Observer<T> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<Closure> mClosureWeakRef;

    public j(Closure closure) {
        this.mClosureWeakRef = new WeakReference<>(closure);
    }

    public abstract void a(Closure closure, T value);

    @Override // androidx.lifecycle.Observer
    public void onChanged(T value) {
        Closure closure = this.mClosureWeakRef.get();
        if (closure == null) {
            return;
        }
        a(closure, value);
    }
}
