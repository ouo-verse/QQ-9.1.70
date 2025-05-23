package com.tencent.mobileqq.guild.feed.feedsquare.part.remake;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.k;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedMainInitBean;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\f\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u0003B9\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0010\u0010\u0014\u001a\f\u0012\u0004\u0012\u00020\u00020\u000fj\u0002`\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001d\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010\t\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u000e\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0005\u0010\rR$\u0010\u0014\u001a\f\u0012\u0004\u0012\u00020\u00020\u000fj\u0002`\u00108\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0018\u001a\u00020\u00158\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0016\u001a\u0004\b\u000b\u0010\u0017R\u001a\u0010\u001d\u001a\u00020\u00198\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/c;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/b;", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedMainInitBean;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/FeedSectionBeanImplContext;", "Lcom/tencent/mvi/base/route/j;", "a", "Lcom/tencent/mvi/base/route/j;", "c", "()Lcom/tencent/mvi/base/route/j;", "messenger", "Landroidx/fragment/app/Fragment;", "b", "Landroidx/fragment/app/Fragment;", "()Landroidx/fragment/app/Fragment;", "fragment", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/i;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/FeedSectionInitBeanSession;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/i;", "d", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/i;", SessionDbHelper.SESSION_ID, "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/LifecycleOwner;", "()Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/mobileqq/guild/feed/feedsquare/viewmodel/k;", "e", "Lcom/tencent/mobileqq/guild/feed/feedsquare/viewmodel/k;", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/viewmodel/k;", "vmApi", "<init>", "(Lcom/tencent/mvi/base/route/j;Landroidx/fragment/app/Fragment;Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/i;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mobileqq/guild/feed/feedsquare/viewmodel/k;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c extends b<GuildFeedMainInitBean> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mvi.base.route.j messenger;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Fragment fragment;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final i<GuildFeedMainInitBean> session;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final k vmApi;

    public c(@NotNull com.tencent.mvi.base.route.j messenger, @NotNull Fragment fragment, @NotNull i<GuildFeedMainInitBean> session, @NotNull LifecycleOwner lifecycleOwner, @NotNull k vmApi) {
        Intrinsics.checkNotNullParameter(messenger, "messenger");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(vmApi, "vmApi");
        this.messenger = messenger;
        this.fragment = fragment;
        this.session = session;
        this.lifecycleOwner = lifecycleOwner;
        this.vmApi = vmApi;
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b
    @NotNull
    /* renamed from: a, reason: from getter */
    public Fragment getFragment() {
        return this.fragment;
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b
    @NotNull
    /* renamed from: b, reason: from getter */
    public LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b
    @NotNull
    /* renamed from: c, reason: from getter */
    public com.tencent.mvi.base.route.j getMessenger() {
        return this.messenger;
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b
    @NotNull
    public i<GuildFeedMainInitBean> d() {
        return this.session;
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b
    @NotNull
    /* renamed from: e, reason: from getter */
    public k getVmApi() {
        return this.vmApi;
    }
}
