package com.tencent.mobileqq.guild.feed.batchmanage.part;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.PartLifecycleCallbacks;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.batchmanage.part.FeedBatchManageInteractStateViewControllerPart;
import com.tencent.mobileqq.guild.feed.batchmanage.search.part.FeedBatchManageSearchLayerPart;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001b\u0010\r\u001a\u00020\u00028VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0007\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00028VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u0003\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/batchmanage/part/FeedBatchManageInteractStateViewControllerViewDependenciesImpl;", "Lcom/tencent/mobileqq/guild/feed/batchmanage/part/FeedBatchManageInteractStateViewControllerPart$b;", "Landroid/view/View;", "a", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/biz/richframework/part/PartManager;", "b", "Lcom/tencent/biz/richframework/part/PartManager;", "partManager", "c", "Lkotlin/Lazy;", "()Landroid/view/View;", "searchLayer", "d", "presentationLayer", "<init>", "(Landroid/view/View;Lcom/tencent/biz/richframework/part/PartManager;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedBatchManageInteractStateViewControllerViewDependenciesImpl implements FeedBatchManageInteractStateViewControllerPart.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View rootView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PartManager partManager;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy searchLayer;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy presentationLayer;

    public FeedBatchManageInteractStateViewControllerViewDependenciesImpl(@NotNull View rootView, @NotNull PartManager partManager) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(partManager, "partManager");
        this.rootView = rootView;
        this.partManager = partManager;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<View>() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.part.FeedBatchManageInteractStateViewControllerViewDependenciesImpl$searchLayer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                PartManager partManager2;
                partManager2 = FeedBatchManageInteractStateViewControllerViewDependenciesImpl.this.partManager;
                String b16 = com.tencent.mvi.base.route.c.b(FeedBatchManageSearchLayerPart.class);
                Intrinsics.checkNotNullExpressionValue(b16, "get(java)");
                PartLifecycleCallbacks part = partManager2.getPart(b16);
                Intrinsics.checkNotNull(part, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.util.function.IHostViewOwner");
                View O0 = ((co1.g) part).O0();
                Intrinsics.checkNotNull(O0);
                return O0;
            }
        });
        this.searchLayer = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<View>() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.part.FeedBatchManageInteractStateViewControllerViewDependenciesImpl$presentationLayer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                View view;
                view = FeedBatchManageInteractStateViewControllerViewDependenciesImpl.this.rootView;
                return view.findViewById(R.id.f166090ed2);
            }
        });
        this.presentationLayer = lazy2;
    }

    @Override // com.tencent.mobileqq.guild.feed.batchmanage.part.FeedBatchManageInteractStateViewControllerPart.b
    @NotNull
    public View a() {
        Object value = this.presentationLayer.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-presentationLayer>(...)");
        return (View) value;
    }

    @Override // com.tencent.mobileqq.guild.feed.batchmanage.part.FeedBatchManageInteractStateViewControllerPart.b
    @NotNull
    public View b() {
        return (View) this.searchLayer.getValue();
    }
}
