package com.tencent.mobileqq.guild.feed.morepanel;

import android.content.Context;
import android.os.Bundle;
import androidx.core.util.Consumer;
import com.tencent.mobileqq.guild.feed.util.framework.route.InterfaceRouterImpl;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\u0004\b\u0001\u0010\u00032\u00020\u0004B\u0017\u0012\u0006\u0010\u0017\u001a\u00028\u0000\u0012\u0006\u0010\u001b\u001a\u00028\u0001\u00a2\u0006\u0004\b.\u0010/J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\r\u001a\u00020\f2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\nJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u000eJ\u0019\u0010\u0010\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\fH\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00028\u00008\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001b\u001a\u00028\u00018\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010 \u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\"\u0010#\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\n0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\"R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\"R\u0017\u0010)\u001a\u00020%8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010&\u001a\u0004\b'\u0010(R!\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010*\u001a\u0004\b+\u0010,\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "Landroid/content/Context;", BdhLogUtil.LogTag.Tag_Conn, "T", "", "obj", "", "c", "(Ljava/lang/Object;)Ljava/lang/Boolean;", "d", "Landroidx/core/util/Consumer;", "task", "", "a", "Ljava/lang/Runnable;", "b", "e", "(Ljava/lang/Object;)V", "f", "()V", "Landroid/content/Context;", tl.h.F, "()Landroid/content/Context;", "context", "Ljava/lang/Object;", "j", "()Ljava/lang/Object;", "feedSourceData", "Lcom/tencent/mobileqq/guild/feed/util/framework/route/a;", "Lcom/tencent/mobileqq/guild/feed/util/framework/route/a;", "g", "()Lcom/tencent/mobileqq/guild/feed/util/framework/route/a;", "apiRouter", "Ljava/util/LinkedList;", "Ljava/util/LinkedList;", "onTransactionBeginTaskList", "onTransactionEndTaskList", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "i", "()Landroid/os/Bundle;", "extra", "Lkotlin/Lazy;", "k", "()Ljava/util/LinkedList;", "references", "<init>", "(Landroid/content/Context;Ljava/lang/Object;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class PanelContext<C extends Context, T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final C context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final T feedSourceData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.feed.util.framework.route.a apiRouter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkedList<Consumer<Object>> onTransactionBeginTaskList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkedList<Runnable> onTransactionEndTaskList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Bundle extra;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy references;

    public PanelContext(@NotNull C context, T t16) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.feedSourceData = t16;
        this.apiRouter = new InterfaceRouterImpl();
        this.onTransactionBeginTaskList = new LinkedList<>();
        this.onTransactionEndTaskList = new LinkedList<>();
        this.extra = new Bundle();
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<LinkedList<Object>>() { // from class: com.tencent.mobileqq.guild.feed.morepanel.PanelContext$references$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LinkedList<Object> invoke() {
                return new LinkedList<>();
            }
        });
        this.references = lazy;
    }

    private final LinkedList<Object> k() {
        return (LinkedList) this.references.getValue();
    }

    public final void a(@NotNull Consumer<Object> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        this.onTransactionBeginTaskList.add(task);
    }

    public final void b(@NotNull Runnable task) {
        Intrinsics.checkNotNullParameter(task, "task");
        this.onTransactionEndTaskList.add(task);
    }

    @Nullable
    public final Boolean c(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        LinkedList<Object> k3 = k();
        if (!(!k3.contains(obj))) {
            k3 = null;
        }
        if (k3 == null) {
            return null;
        }
        return Boolean.valueOf(k3.add(obj));
    }

    public final boolean d(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        return k().remove(obj);
    }

    public final void e(@Nullable Object obj) {
        Iterator<T> it = new LinkedList(this.onTransactionBeginTaskList).iterator();
        while (it.hasNext()) {
            ((Consumer) it.next()).accept(obj);
        }
    }

    public final void f() {
        Iterator<T> it = new LinkedList(this.onTransactionEndTaskList).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final com.tencent.mobileqq.guild.feed.util.framework.route.a getApiRouter() {
        return this.apiRouter;
    }

    @NotNull
    public final C h() {
        return this.context;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final Bundle getExtra() {
        return this.extra;
    }

    public final T j() {
        return this.feedSourceData;
    }
}
