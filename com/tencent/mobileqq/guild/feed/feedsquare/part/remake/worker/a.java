package com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker;

import bk1.a;
import com.tencent.mobileqq.guild.feed.feedsquare.adapter.GuildFeedSquareEmptyAdapter;
import com.tencent.mobileqq.guild.feed.square.GuildFeedSquareInitBean;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/worker/a;", "Lbk1/a$a;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/GuildFeedSquareEmptyAdapter;", "Lcom/tencent/mobileqq/guild/feed/square/GuildFeedSquareInitBean;", "Lcom/tencent/mobileqq/guild/feed/viewmodel/k;", "viewModel", "", "i", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/j;", DownloadInfo.spKey_Config, "j", "destroy", "", "d", "Z", "isMounted", "e", "Lcom/tencent/mobileqq/guild/feed/viewmodel/k;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a extends a.AbstractC0131a<GuildFeedSquareEmptyAdapter, GuildFeedSquareInitBean> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isMounted;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.feed.viewmodel.k viewModel;

    @Override // bk1.a.AbstractC0131a, qz0.a
    public void destroy() {
        super.destroy();
        this.isMounted = false;
        this.viewModel = null;
        b().q0();
    }

    public final void i(@NotNull com.tencent.mobileqq.guild.feed.viewmodel.k viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.viewModel = viewModel;
        this.isMounted = true;
    }

    @Override // bk1.a.AbstractC0131a
    @NotNull
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public GuildFeedSquareEmptyAdapter f(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.part.remake.j config) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (this.isMounted) {
            GuildFeedSquareInitBean b16 = d().d().b();
            Intrinsics.checkNotNull(b16);
            com.tencent.mobileqq.guild.feed.viewmodel.k kVar = this.viewModel;
            Intrinsics.checkNotNull(kVar);
            GuildFeedSquareEmptyAdapter guildFeedSquareEmptyAdapter = new GuildFeedSquareEmptyAdapter(b16, kVar, d().getFragment());
            guildFeedSquareEmptyAdapter.setHasStableIds(true);
            return guildFeedSquareEmptyAdapter;
        }
        throw new IllegalArgumentException("worker should be mounted before being used".toString());
    }
}
