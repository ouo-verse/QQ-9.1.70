package com.tencent.mobileqq.guild.feed.feedsquare.part.remake;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002`\u0005B7\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001a\u0010\u000e\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u001a\u0010\u0012\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\f\u001a\u0004\b\u0013\u0010\rR\u001a\u0010\u0018\u001a\u00020\u00148\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/a;", "Ldo1/a;", "", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/h;", "", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/IFeedCollectionViewState;", "a", "Ljava/util/List;", "d", "()Ljava/util/List;", "collection", "b", "Z", "()Z", "isFinished", "c", "e", "()Ljava/lang/Boolean;", "loadMoreState", "isLoading", "", "I", "getTotal", "()I", "total", "<init>", "(Ljava/util/List;ZZZI)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a implements do1.a<List<? extends com.tencent.mobileqq.guild.feed.feedsquare.data.h>, Boolean> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final List<com.tencent.mobileqq.guild.feed.feedsquare.data.h> collection;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean isFinished;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean loadMoreState;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isLoading;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int total;

    /* JADX WARN: Multi-variable type inference failed */
    public a(@Nullable List<? extends com.tencent.mobileqq.guild.feed.feedsquare.data.h> list, boolean z16, boolean z17, boolean z18, int i3) {
        this.collection = list;
        this.isFinished = z16;
        this.loadMoreState = z17;
        this.isLoading = z18;
        this.total = i3;
    }

    @Override // do1.a
    /* renamed from: b, reason: from getter */
    public boolean getIsFinished() {
        return this.isFinished;
    }

    @Override // do1.a
    @Nullable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public List<com.tencent.mobileqq.guild.feed.feedsquare.data.h> a() {
        return this.collection;
    }

    @Override // do1.a
    @NotNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public Boolean c() {
        return Boolean.valueOf(this.loadMoreState);
    }

    @Override // do1.a
    public int getTotal() {
        return this.total;
    }
}
