package com.tencent.mobileqq.guild.feed.feedlist.section.recommend;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.feed.feedlist.section.FeedListMultiImageSection;
import com.tencent.mobileqq.guild.feed.feedsquare.section.f;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.AbsGuildFeedMediaSizeUtils;
import com.tencent.mobileqq.guild.media.widget.RoundCornerLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nR\u001a\u0010\b\u001a\u00020\u00038\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedlist/section/recommend/c;", "Lcom/tencent/mobileqq/guild/feed/feedlist/section/FeedListMultiImageSection;", "Lrj1/d;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/f$b;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/f$b;", "G", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/section/f$b;", "depends", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c extends FeedListMultiImageSection<rj1.d> {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final f.b depends = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0011\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\u001b\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J\t\u0010\f\u001a\u00020\u000bH\u0096\u0001J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096\u0001J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\u0011\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J!\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002H\u0096\u0001J\u0018\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u0014\u0010\u001a\u001a\u00020\u00028\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001b"}, d2 = {"com/tencent/mobileqq/guild/feed/feedlist/section/recommend/c$a", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/f$b;", "", "dataSize", "d", "Landroid/view/View;", "view", "", "elementId", "", "c", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/AbsGuildFeedMediaSizeUtils;", "e", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "getRecycledViewPool", "", "a", h.F, "Lcom/tencent/mobileqq/guild/media/widget/RoundCornerLayout;", "position", "itemCount", "f", com.tencent.luggage.wxa.c8.c.G, "i", "g", "()I", "maxRow", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements f.b {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ f.b f218612a;

        a() {
            this.f218612a = c.super.getDepends();
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        @Nullable
        public Object a() {
            return this.f218612a.a();
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        public void c(@Nullable View view, @NotNull String elementId) {
            Intrinsics.checkNotNullParameter(elementId, "elementId");
            this.f218612a.c(view, elementId);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        public int d(int dataSize) {
            return this.f218612a.d(dataSize);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        @NotNull
        public AbsGuildFeedMediaSizeUtils e() {
            return this.f218612a.e();
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        public void f(@NotNull RoundCornerLayout view, int position, int itemCount) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.f218612a.f(view, position, itemCount);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        /* renamed from: g */
        public int getMaxRow() {
            return this.f218612a.getMaxRow();
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        @Nullable
        public RecyclerView.RecycledViewPool getRecycledViewPool() {
            return this.f218612a.getRecycledViewPool();
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        public void h(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.f218612a.h(view);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        public void i(int pos, @NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            rj1.a.f431544a.h(c.this.q(), c.this.r(), c.M(c.this));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ rj1.d M(c cVar) {
        return (rj1.d) cVar.s();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.feed.feedlist.section.FeedListMultiImageSection
    @NotNull
    /* renamed from: G, reason: from getter */
    public f.b getDepends() {
        return this.depends;
    }
}
