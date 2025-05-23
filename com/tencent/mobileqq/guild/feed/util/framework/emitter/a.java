package com.tencent.mobileqq.guild.feed.util.framework.emitter;

import androidx.lifecycle.LifecycleOwner;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\f\u0010\rJ#\u0010\u0010\u001a\u00020\u00042\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b0\u000eH\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/util/framework/emitter/a;", "T", "Lml3/a;", "callback", "", "a", "(Ljava/lang/Object;)V", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "b", "(Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;)V", "", "c", "(Ljava/lang/Object;)Z", "Lkotlin/Function1;", "dispatcher", "d", "(Lkotlin/jvm/functions/Function1;)V", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "mFunctionsCallBacks", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class a<T> implements ml3.a<T> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CopyOnWriteArrayList<T> mFunctionsCallBacks = new CopyOnWriteArrayList<>();

    @Override // ml3.a
    public void a(T callback) {
        if (this.mFunctionsCallBacks.contains(callback)) {
            return;
        }
        this.mFunctionsCallBacks.add(callback);
    }

    @Override // ml3.a
    public void b(T callback, @NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        a(callback);
    }

    @Override // ml3.a
    public boolean c(T callback) {
        if (this.mFunctionsCallBacks.contains(callback)) {
            this.mFunctionsCallBacks.remove(callback);
            return true;
        }
        return false;
    }

    public final void d(@NotNull Function1<? super T, Boolean> dispatcher) {
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Iterator<T> it = this.mFunctionsCallBacks.iterator();
        while (it.hasNext()) {
            dispatcher.invoke(it.next()).booleanValue();
        }
    }
}
