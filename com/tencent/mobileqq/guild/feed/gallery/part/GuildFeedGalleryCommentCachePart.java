package com.tencent.mobileqq.guild.feed.gallery.part;

import android.app.Activity;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import dk1.a;
import hk1.a;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/part/GuildFeedGalleryCommentCachePart;", "Lcom/tencent/mobileqq/guild/feed/part/d;", "Lhk1/a$d;", "A9", "", "args", "", "B9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "", "action", "handleBroadcastMessage", "getMessage", "Lkk1/a;", "d", "Lkotlin/Lazy;", "x9", "()Lkk1/a;", "commentDelegatesManager", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "e", "z9", "()Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "commentRecycledViewPool", "<init>", "()V", "f", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedGalleryCommentCachePart extends com.tencent.mobileqq.guild.feed.part.d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy commentDelegatesManager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy commentRecycledViewPool;

    public GuildFeedGalleryCommentCachePart() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<kk1.a>() { // from class: com.tencent.mobileqq.guild.feed.gallery.part.GuildFeedGalleryCommentCachePart$commentDelegatesManager$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final kk1.a invoke() {
                return new kk1.a();
            }
        });
        this.commentDelegatesManager = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<RecyclerView.RecycledViewPool>() { // from class: com.tencent.mobileqq.guild.feed.gallery.part.GuildFeedGalleryCommentCachePart$commentRecycledViewPool$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RecyclerView.RecycledViewPool invoke() {
                RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
                recycledViewPool.setMaxRecycledViews(6, 8);
                recycledViewPool.setMaxRecycledViews(7, 8);
                recycledViewPool.setMaxRecycledViews(4, 2);
                return recycledViewPool;
            }
        });
        this.commentRecycledViewPool = lazy2;
    }

    private final a.GetInputViewRecycledInfo A9() {
        return new a.GetInputViewRecycledInfo(z9(), x9());
    }

    private final void B9(Object args) {
        a.Companion companion = dk1.a.INSTANCE;
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        companion.a(activity);
    }

    private final kk1.a x9() {
        return (kk1.a) this.commentDelegatesManager.getValue();
    }

    private final RecyclerView.RecycledViewPool z9() {
        return (RecyclerView.RecycledViewPool) this.commentRecycledViewPool.getValue();
    }

    @Override // com.tencent.biz.richframework.part.Part
    @Nullable
    public Object getMessage(@Nullable String action, @Nullable Object args) {
        if (Intrinsics.areEqual(action, "message_get_comment_cache_recycled_info")) {
            return A9();
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        if (Intrinsics.areEqual(action, "message_comment_panel_close_event")) {
            B9(args);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
    }
}
