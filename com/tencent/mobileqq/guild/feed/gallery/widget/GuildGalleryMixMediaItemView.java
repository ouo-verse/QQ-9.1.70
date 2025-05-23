package com.tencent.mobileqq.guild.feed.gallery.widget;

import android.content.Context;
import android.view.MotionEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildSpeechApi;
import com.tencent.mobileqq.guild.feed.gallery.presenter.GuildFeedGalleryBottomPresenter;
import com.tencent.mobileqq.guild.feed.gallery.presenter.GuildFeedGalleryContentPresenter;
import com.tencent.mobileqq.guild.feed.gallery.presenter.GuildFeedGalleryDescPresenter;
import com.tencent.mobileqq.guild.feed.gallery.widget.NestedScrollableHost;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDefaultInitBean;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0014\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildGalleryMixMediaItemView;", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedGalleryBaseItemView;", "", NodeProps.ON_ATTACHED_TO_WINDOW, "", "getLayoutId", "", "Lcom/tencent/mobileqq/guild/feed/gallery/presenter/b;", "o0", "Landroid/content/Context;", "context", "viewType", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDefaultInitBean;", "initBean", "<init>", "(Landroid/content/Context;ILcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDefaultInitBean;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildGalleryMixMediaItemView extends GuildFeedGalleryBaseItemView {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/widget/GuildGalleryMixMediaItemView$a", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/NestedScrollableHost$a;", "Landroid/view/MotionEvent;", "motionEvent", "", "deltaX", "deltaY", "", IGuildSpeechApi.KEY_NEED_INTERCEPT, "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements NestedScrollableHost.a {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.feed.gallery.widget.NestedScrollableHost.a
        public boolean needIntercept(@Nullable MotionEvent motionEvent, float deltaX, float deltaY) {
            if (Math.abs(deltaX) >= Math.abs(deltaY)) {
                return true;
            }
            return false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildGalleryMixMediaItemView(@NotNull Context context, int i3, @NotNull GuildFeedDefaultInitBean initBean) {
        super(context, i3, initBean);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
    }

    @Override // com.tencent.mobileqq.guild.feed.widget.GuildBaseWidgetView, com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.eo8;
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.widget.GuildFeedGalleryBaseItemView
    @NotNull
    protected List<com.tencent.mobileqq.guild.feed.gallery.presenter.b> o0() {
        List<com.tencent.mobileqq.guild.feed.gallery.presenter.b> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.mobileqq.guild.feed.gallery.presenter.b[]{new com.tencent.mobileqq.guild.feed.gallery.presenter.q(getBean()), new GuildFeedGalleryContentPresenter(getBean()), new GuildFeedGalleryDescPresenter(getBean()), new GuildFeedGalleryBottomPresenter(getBean())});
        return listOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.feed.gallery.widget.GuildFeedGalleryBaseItemView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ((NestedScrollableHost) findViewById(R.id.v2f)).setDragInterceptDelegate(new a());
    }
}
