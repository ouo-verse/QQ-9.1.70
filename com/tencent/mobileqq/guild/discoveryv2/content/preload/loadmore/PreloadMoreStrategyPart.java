package com.tencent.mobileqq.guild.discoveryv2.content.preload.loadmore;

import android.app.Activity;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discoveryv2.content.model.LoadMoreType;
import com.tencent.mobileqq.guild.discoveryv2.content.part.MVPFeedsPart;
import com.tencent.mobileqq.guild.discoveryv2.content.part.d;
import com.tencent.mobileqq.guild.discoveryv2.content.preload.loadmore.PreloadMoreStrategyPart$scrollListener$2;
import com.tencent.mobileqq.guild.discoveryv2.content.util.ContentMessage;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u00007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u000b*\u0001\u0014\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0019\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/preload/loadmore/PreloadMoreStrategyPart;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/part/MVPFeedsPart;", "", "F9", "D9", "E9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "", "e", "Z", "mPreloadMoreStrategyStarted", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "com/tencent/mobileqq/guild/discoveryv2/content/preload/loadmore/PreloadMoreStrategyPart$scrollListener$2$a", h.F, "Lkotlin/Lazy;", "C9", "()Lcom/tencent/mobileqq/guild/discoveryv2/content/preload/loadmore/PreloadMoreStrategyPart$scrollListener$2$a;", "scrollListener", "<init>", "()V", "i", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class PreloadMoreStrategyPart extends MVPFeedsPart {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mPreloadMoreStrategyStarted;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy scrollListener;

    public PreloadMoreStrategyPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<PreloadMoreStrategyPart$scrollListener$2.a>() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.preload.loadmore.PreloadMoreStrategyPart$scrollListener$2

            @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0016R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0013"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/content/preload/loadmore/PreloadMoreStrategyPart$scrollListener$2$a", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "newState", "onScrollStateChanged", "", "d", "J", "getLastPullTime", "()J", "setLastPullTime", "(J)V", "lastPullTime", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a extends RecyclerView.OnScrollListener {

                /* renamed from: d, reason: collision with root package name and from kotlin metadata */
                private long lastPullTime;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ PreloadMoreStrategyPart f217083e;

                a(PreloadMoreStrategyPart preloadMoreStrategyPart) {
                    this.f217083e = preloadMoreStrategyPart;
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
                    Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                    if (newState == 0 && !recyclerView.canScrollVertically(1)) {
                        this.f217083e.broadcastMessage("message_on_load_more", new ContentMessage.LoadMoreMessage(LoadMoreType.TYPE_FINGER_SLIDING, "DiscoveryV2.ContentPreLoadMoreStrategyPart"));
                    }
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
                    Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                    super.onScrolled(recyclerView, dx5, dy5);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (dy5 > 0 && recyclerView.canScrollVertically(dy5) && currentTimeMillis - this.lastPullTime > 300) {
                        this.f217083e.D9();
                        this.lastPullTime = currentTimeMillis;
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(PreloadMoreStrategyPart.this);
            }
        });
        this.scrollListener = lazy;
    }

    private final PreloadMoreStrategyPart$scrollListener$2.a C9() {
        return (PreloadMoreStrategyPart$scrollListener$2.a) this.scrollListener.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D9() {
        RecyclerView recyclerView = this.recyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        int computeVerticalScrollRange = recyclerView3.computeVerticalScrollRange();
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView2 = recyclerView4;
        }
        int computeVerticalScrollExtent = recyclerView2.computeVerticalScrollExtent();
        int i3 = (computeVerticalScrollRange - computeVerticalScrollOffset) - computeVerticalScrollExtent;
        if (i3 <= computeVerticalScrollExtent * 2) {
            QLog.i("DiscoveryV2.ContentPreLoadMoreStrategyPart", 1, "preLoadMore verticalScrollOffset = " + computeVerticalScrollOffset + " computeVerticalScrollRange = " + computeVerticalScrollRange + " computeVerticalScrollExtent = " + computeVerticalScrollExtent + " bottomDistance = " + i3);
            E9();
        }
    }

    private final void E9() {
        broadcastMessage("message_on_load_more", new ContentMessage.LoadMoreMessage(LoadMoreType.TYPE_PRE_LOAD_MORE, "DiscoveryV2.ContentPreLoadMoreStrategyPart"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F9() {
        if (!this.mPreloadMoreStrategyStarted) {
            QLog.i("DiscoveryV2.ContentPreLoadMoreStrategyPart", 1, "startPreLoadMoreStrategy");
            RecyclerView recyclerView = this.recyclerView;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView = null;
            }
            recyclerView.addOnScrollListener(C9());
            this.mPreloadMoreStrategyStarted = true;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        if (rootView == null) {
            return;
        }
        View findViewById = rootView.findViewById(R.id.uiw);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026scovery_v2_recycler_view)");
        this.recyclerView = (RecyclerView) findViewById;
        BuildersKt__Builders_commonKt.launch$default(d.b(this), null, null, new PreloadMoreStrategyPart$onInitView$1(this, null), 3, null);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        this.mPreloadMoreStrategyStarted = false;
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.removeOnScrollListener(C9());
    }
}
