package com.tencent.mobileqq.guild.feed.feedlist.section.recommend;

import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.guild.feed.feedlist.section.FeedListSingleImageSection;
import com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSingleImageComponents;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nR\u001a\u0010\b\u001a\u00020\u00038\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedlist/section/recommend/d;", "Lcom/tencent/mobileqq/guild/feed/feedlist/section/FeedListSingleImageSection;", "Lrj1/d;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSingleImageComponents$b;", "E", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSingleImageComponents$b;", "D", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSingleImageComponents$b;", "depends", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d extends FeedListSingleImageSection<rj1.d> {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final GuildFeedSingleImageComponents.b depends = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/feed/feedlist/section/recommend/d$a", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSingleImageComponents$b;", "Landroid/view/View;", "imageView", "", "b", "", "a", "Landroid/widget/ImageView;", "image", "c", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements GuildFeedSingleImageComponents.b {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ GuildFeedSingleImageComponents.b f218614a;

        a() {
            this.f218614a = d.super.getDepends();
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSingleImageComponents.b
        @Nullable
        public Object a() {
            return this.f218614a.a();
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSingleImageComponents.b
        public void b(@NotNull View imageView) {
            Intrinsics.checkNotNullParameter(imageView, "imageView");
            this.f218614a.b(imageView);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSingleImageComponents.b
        public void c(@NotNull ImageView image) {
            Intrinsics.checkNotNullParameter(image, "image");
            rj1.a.f431544a.h(d.this.q(), d.this.r(), d.J(d.this));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ rj1.d J(d dVar) {
        return (rj1.d) dVar.s();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.feed.feedlist.section.FeedListSingleImageSection
    @NotNull
    /* renamed from: D, reason: from getter */
    public GuildFeedSingleImageComponents.b getDepends() {
        return this.depends;
    }
}
