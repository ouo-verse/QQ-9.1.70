package com.tencent.mobileqq.guild.feed.nativepublish.mediapreview;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/n;", "Lol3/b;", "<init>", "()V", "a", "b", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/n$a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/n$b;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class n implements ol3.b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/n$a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/n;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedPostMediaPreviewAdapter;", "d", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedPostMediaPreviewAdapter;", "a", "()Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedPostMediaPreviewAdapter;", "adapter", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedPostMediaPreviewAdapter;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends n {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final FeedPostMediaPreviewAdapter adapter;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull FeedPostMediaPreviewAdapter adapter) {
            super(null);
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            this.adapter = adapter;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final FeedPostMediaPreviewAdapter getAdapter() {
            return this.adapter;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/n$b;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/n;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends n {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final b f222204d = new b();

        b() {
            super(null);
        }
    }

    public /* synthetic */ n(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    n() {
    }
}
