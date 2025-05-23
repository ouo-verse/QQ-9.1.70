package com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl;

import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import bk1.a;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0006\u0010\u0012\u001a\u00020\u0001\u0012\"\u0010\u001a\u001a\u001e\u0012\u001a\u0012\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00140\u0013\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\"\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016R\u0014\u0010\u0012\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R0\u0010\u001a\u001a\u001e\u0012\u001a\u0012\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00140\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/delegate/impl/IocInjectHelperRecyclerViewInitializer;", "Lbk1/a$d;", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/j;", DownloadInfo.spKey_Config, "a", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "", "onStateChanged", "d", "Lbk1/a$d;", "initializer", "", "Lkotlin/Pair;", "Ljava/lang/Class;", "Lkotlin/Function0;", "", "e", "Ljava/util/List;", "iocConstructorList", "f", "Landroidx/recyclerview/widget/RecyclerView;", "rv", "<init>", "(Lbk1/a$d;Ljava/util/List;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class IocInjectHelperRecyclerViewInitializer implements a.d, LifecycleEventObserver {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a.d initializer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Pair<Class<?>, Function0<Object>>> iocConstructorList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView rv;

    /* JADX WARN: Multi-variable type inference failed */
    public IocInjectHelperRecyclerViewInitializer(@NotNull a.d initializer, @NotNull List<? extends Pair<? extends Class<?>, ? extends Function0<? extends Object>>> iocConstructorList) {
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        Intrinsics.checkNotNullParameter(iocConstructorList, "iocConstructorList");
        this.initializer = initializer;
        this.iocConstructorList = iocConstructorList;
    }

    @Override // bk1.a.d
    @NotNull
    public RecyclerView a(@Nullable RecyclerView recyclerView, @NotNull View rootView, @NotNull com.tencent.mobileqq.guild.feed.feedsquare.part.remake.j config) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(config, "config");
        RecyclerView a16 = this.initializer.a(recyclerView, rootView, config);
        for (Pair<Class<?>, Function0<Object>> pair : this.iocConstructorList) {
            yl1.n.y(a16, pair.component1(), pair.component2().invoke());
        }
        this.rv = recyclerView;
        return a16;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_DESTROY) {
            source.getLifecycle().removeObserver(this);
            Iterator<Pair<Class<?>, Function0<Object>>> it = this.iocConstructorList.iterator();
            while (it.hasNext()) {
                Class<?> component1 = it.next().component1();
                RecyclerView recyclerView = this.rv;
                if (recyclerView != null) {
                    yl1.n.D(recyclerView, component1);
                }
            }
        }
    }
}
