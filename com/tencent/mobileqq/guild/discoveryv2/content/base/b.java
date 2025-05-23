package com.tencent.mobileqq.guild.discoveryv2.content.base;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.api.FeedPreloadInfo;
import com.tencent.mobileqq.guild.feed.api.IFeedScrollMangerFactoryApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0010\u001a\u00020\u00042\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000eJ\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H&J,\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\u0016*\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/base/b;", "", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "f", "Lcom/tencent/mobileqq/guild/api/e;", "a", "b", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "d", "e", "c", "", "items", tl.h.F, "", "fromIndex", "toIndex", "Lcom/tencent/mobileqq/guild/api/b;", "i", "T", "g", "Lcom/tencent/mobileqq/guild/api/d;", "Lcom/tencent/mobileqq/guild/api/d;", "scrollManager", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.api.d scrollManager;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/content/base/b$a", "Lcom/tencent/mobileqq/guild/api/e;", "", "fromIndex", "toIndex", "", "Lcom/tencent/mobileqq/guild/api/b;", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements com.tencent.mobileqq.guild.api.e {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.api.e
        @NotNull
        public List<FeedPreloadInfo> a(int fromIndex, int toIndex) {
            Object m476constructorimpl;
            b bVar = b.this;
            try {
                Result.Companion companion = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(bVar.i(fromIndex, toIndex));
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            if (Result.m479exceptionOrNullimpl(m476constructorimpl) != null) {
                m476constructorimpl = CollectionsKt__CollectionsKt.emptyList();
            }
            return (List) m476constructorimpl;
        }
    }

    private final com.tencent.mobileqq.guild.api.e a() {
        return new a();
    }

    private final void f(RecyclerView recyclerView) {
        IFeedScrollMangerFactoryApi iFeedScrollMangerFactoryApi = (IFeedScrollMangerFactoryApi) QRoute.api(IFeedScrollMangerFactoryApi.class);
        Context context = recyclerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "recyclerView.context");
        com.tencent.mobileqq.guild.api.d createFeedScrollManager = iFeedScrollMangerFactoryApi.createFeedScrollManager(context, recyclerView, a());
        recyclerView.addOnScrollListener(createFeedScrollManager);
        createFeedScrollManager.e(recyclerView);
        this.scrollManager = createFeedScrollManager;
    }

    public final void b(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        f(recyclerView);
    }

    public final void c(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        com.tencent.mobileqq.guild.api.d dVar = this.scrollManager;
        if (dVar != null) {
            recyclerView.removeOnScrollListener(dVar);
            dVar.f();
        }
    }

    public final void d(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        com.tencent.mobileqq.guild.api.d dVar = this.scrollManager;
        if (dVar != null) {
            dVar.h(holder);
        }
    }

    public final void e(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        com.tencent.mobileqq.guild.api.d dVar = this.scrollManager;
        if (dVar != null) {
            dVar.i(holder);
        }
    }

    @NotNull
    public final <T> List<T> g(@NotNull List<? extends T> list, int i3, int i16) {
        int coerceIn;
        int coerceIn2;
        List<T> emptyList;
        List<T> emptyList2;
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            return emptyList2;
        }
        coerceIn = RangesKt___RangesKt.coerceIn(i3, 0, list.size() - 1);
        coerceIn2 = RangesKt___RangesKt.coerceIn(i16, coerceIn, list.size());
        if (coerceIn >= coerceIn2) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return list.subList(coerceIn, coerceIn2);
    }

    public final void h(@Nullable List<? extends Object> items) {
        com.tencent.mobileqq.guild.api.d dVar = this.scrollManager;
        if (dVar != null) {
            dVar.g();
        }
    }

    @NotNull
    public abstract List<FeedPreloadInfo> i(int fromIndex, int toIndex);
}
