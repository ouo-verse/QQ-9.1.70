package com.tencent.mobileqq.guild.feed.feedsquare.part.remake;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.k;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0006\u001a\u00020\u00038&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00078&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/b;", "T", "", "Lcom/tencent/mvi/base/route/j;", "c", "()Lcom/tencent/mvi/base/route/j;", "messenger", "Landroidx/fragment/app/Fragment;", "a", "()Landroidx/fragment/app/Fragment;", "fragment", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/i;", "d", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/i;", SessionDbHelper.SESSION_ID, "Landroidx/lifecycle/LifecycleOwner;", "b", "()Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/mobileqq/guild/feed/feedsquare/viewmodel/k;", "e", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/viewmodel/k;", "vmApi", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class b<T> {
    @NotNull
    public abstract Fragment a();

    @NotNull
    public abstract LifecycleOwner b();

    @NotNull
    public abstract com.tencent.mvi.base.route.j c();

    @NotNull
    public abstract i<T> d();

    @NotNull
    public abstract k e();
}
