package com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl;

import android.view.View;
import androidx.core.util.Supplier;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import bk1.a;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\t*\u0001\u001b\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u0014\u0012\u0006\u0010\u001a\u001a\u00020\u0001\u00a2\u0006\u0004\b!\u0010\"J\"\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/delegate/impl/FeedSquareVideoPlayManagerInjectRecyclerViewInitializer;", "Lbk1/a$d;", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/j;", DownloadInfo.spKey_Config, "a", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "", "onStateChanged", "Lyj1/e;", "d", "Lyj1/e;", "videoPlayManager", "Landroidx/core/util/Supplier;", "e", "Landroidx/core/util/Supplier;", "lifecycleOwnerProvider", "f", "Lbk1/a$d;", "initializer", "com/tencent/mobileqq/guild/feed/feedsquare/part/remake/delegate/impl/FeedSquareVideoPlayManagerInjectRecyclerViewInitializer$a", tl.h.F, "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/delegate/impl/FeedSquareVideoPlayManagerInjectRecyclerViewInitializer$a;", "videoPlayManagerRouter", "i", "Landroid/view/View;", "<init>", "(Lyj1/e;Landroidx/core/util/Supplier;Lbk1/a$d;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedSquareVideoPlayManagerInjectRecyclerViewInitializer implements a.d, LifecycleEventObserver {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final yj1.e videoPlayManager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Supplier<LifecycleOwner> lifecycleOwnerProvider;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a.d initializer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a videoPlayManagerRouter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View recyclerView;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/part/remake/delegate/impl/FeedSquareVideoPlayManagerInjectRecyclerViewInitializer$a", "Lxj1/f;", "Lyj1/e;", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements xj1.f {
        a() {
        }

        @Override // xj1.f
        @NotNull
        public yj1.e a() {
            return FeedSquareVideoPlayManagerInjectRecyclerViewInitializer.this.videoPlayManager;
        }
    }

    public FeedSquareVideoPlayManagerInjectRecyclerViewInitializer(@NotNull yj1.e videoPlayManager, @NotNull Supplier<LifecycleOwner> lifecycleOwnerProvider, @NotNull a.d initializer) {
        Intrinsics.checkNotNullParameter(videoPlayManager, "videoPlayManager");
        Intrinsics.checkNotNullParameter(lifecycleOwnerProvider, "lifecycleOwnerProvider");
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        this.videoPlayManager = videoPlayManager;
        this.lifecycleOwnerProvider = lifecycleOwnerProvider;
        this.initializer = initializer;
        this.videoPlayManagerRouter = new a();
    }

    @Override // bk1.a.d
    @NotNull
    public RecyclerView a(@Nullable RecyclerView recyclerView, @NotNull View rootView, @NotNull com.tencent.mobileqq.guild.feed.feedsquare.part.remake.j config) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(config, "config");
        LifecycleOwner lifecycleOwner = this.lifecycleOwnerProvider.get();
        lifecycleOwner.getLifecycle().addObserver(this);
        RecyclerView a16 = this.initializer.a(recyclerView, rootView, config);
        yl1.n.y(a16, xj1.f.class, this.videoPlayManagerRouter);
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "lifecycleOwner");
        wj1.e.a(a16, lifecycleOwner, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl.FeedSquareVideoPlayManagerInjectRecyclerViewInitializer$initializeFeedRecyclerView$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                FeedSquareVideoPlayManagerInjectRecyclerViewInitializer.this.videoPlayManager.b();
            }
        });
        this.recyclerView = a16;
        return a16;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_DESTROY) {
            source.getLifecycle().removeObserver(this);
            View view = this.recyclerView;
            if (view != null) {
                yl1.n.D(view, xj1.f.class);
            }
        }
    }
}
