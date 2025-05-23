package com.tencent.mobileqq.guild.feed.search.sections;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.guild.feed.feedsquare.section.f;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedMediaSizeForSearchUtils;
import com.tencent.mobileqq.guild.media.widget.RoundCornerLayout;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J(\u0010\u000f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/search/sections/g;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lpn1/a;", "", "getViewStubLayoutId", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "data", "", "position", "", "", "payload", "p", "", "attached", "onAttachedChanged", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/f;", "d", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/f;", "components", "<init>", "()V", "e", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class g extends Section<pn1.a> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.feed.feedsquare.section.f components = new com.tencent.mobileqq.guild.feed.feedsquare.section.f(new b());

    /* compiled from: P */
    @Metadata(d1 = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000f\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\bH\u0016J \u0010\u0014\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016R\u001a\u0010\u001b\u001a\u00020\u00028\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001c"}, d2 = {"com/tencent/mobileqq/guild/feed/search/sections/g$b", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/f$b;", "", "dataSize", "d", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "getRecycledViewPool", com.tencent.luggage.wxa.c8.c.G, "Landroid/view/View;", "view", "", "i", "v", "", "elementId", "c", tl.h.F, "Lcom/tencent/mobileqq/guild/media/widget/RoundCornerLayout;", "position", "itemCount", "f", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/GuildFeedMediaSizeForSearchUtils;", "b", "a", "I", "g", "()I", "maxRow", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements f.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int maxRow = 1;

        b() {
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        @Nullable
        public Object a() {
            return f.b.a.b(this);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GuildFeedMediaSizeForSearchUtils e() {
            return GuildFeedMediaSizeForSearchUtils.f219293d;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        public void c(@Nullable View v3, @NotNull String elementId) {
            Intrinsics.checkNotNullParameter(elementId, "elementId");
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        public int d(int dataSize) {
            return 4;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        public void f(@NotNull RoundCornerLayout view, int position, int itemCount) {
            float f16;
            Intrinsics.checkNotNullParameter(view, "view");
            float f17 = 0.0f;
            if (position == 0) {
                f16 = ViewUtils.dpToPx(6.0f);
            } else {
                f16 = 0.0f;
            }
            if (position == itemCount - 1) {
                f17 = ViewUtils.dpToPx(6.0f);
            }
            view.setRadius(f16, f17, f17, f16);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        /* renamed from: g, reason: from getter */
        public int getMaxRow() {
            return this.maxRow;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        @Nullable
        public RecyclerView.RecycledViewPool getRecycledViewPool() {
            return null;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        public void h(@NotNull View v3) {
            Intrinsics.checkNotNullParameter(v3, "v");
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        public void i(int pos, @NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return this.components.e();
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean attached) {
        super.onAttachedChanged(attached);
        if (attached) {
            this.components.f();
        } else {
            this.components.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.components.i(rootView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull pn1.a data, int position, @Nullable List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.components.g(data.d(), position, payload);
    }
}
