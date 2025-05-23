package com.tencent.mobileqq.search.searchdetail.content.part;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchTemplateNineBoxGridItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u00112\u00020\u00012\u00020\u0002:\u0001'B\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u0012\u0006\u0010\"\u001a\u00020\u0007\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\tH\u0016J\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u000fJ\u0016\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0016R\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\"\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010#\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/part/u;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Lcom/tencent/mobileqq/search/searchdetail/content/part/r;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "e", "Lcom/tencent/mobileqq/search/searchdetail/content/base/e;", "adapter", "", "position", "", "g", "newState", "onScrollStateChanged", "", "delayMillis", tl.h.F, "Lcom/tencent/mobileqq/search/searchdetail/content/model/a;", "playItem", "f", "Lcom/tencent/mobileqq/search/searchdetail/c;", "currentItem", "", "c", "Lcom/tencent/mobileqq/search/searchdetail/content/part/ContentPart;", "d", "Lcom/tencent/mobileqq/search/searchdetail/content/part/ContentPart;", "getContentPart", "()Lcom/tencent/mobileqq/search/searchdetail/content/part/ContentPart;", "contentPart", "Lcom/tencent/mobileqq/search/searchdetail/content/base/e;", "getSearchResultListAdapter", "()Lcom/tencent/mobileqq/search/searchdetail/content/base/e;", "searchResultListAdapter", "I", "lastPlayIndex", "<init>", "(Lcom/tencent/mobileqq/search/searchdetail/content/part/ContentPart;Lcom/tencent/mobileqq/search/searchdetail/content/base/e;)V", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class u extends RecyclerView.OnScrollListener implements r {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ContentPart contentPart;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.search.searchdetail.content.base.e searchResultListAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int lastPlayIndex;

    public u(@NotNull ContentPart contentPart, @NotNull com.tencent.mobileqq.search.searchdetail.content.base.e searchResultListAdapter) {
        Intrinsics.checkNotNullParameter(contentPart, "contentPart");
        Intrinsics.checkNotNullParameter(searchResultListAdapter, "searchResultListAdapter");
        this.contentPart = contentPart;
        this.searchResultListAdapter = searchResultListAdapter;
        this.lastPlayIndex = -1;
    }

    private final void e(RecyclerView recyclerView) {
        Object orNull;
        com.tencent.mobileqq.search.searchdetail.content.model.a aVar;
        Object orNull2;
        com.tencent.mobileqq.search.searchdetail.content.model.a aVar2;
        boolean z16;
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        QLog.d("QQSearch.NetDetail.VideoPlayController", 4, "checkVisibleVideoItem," + findFirstVisibleItemPosition + "," + findLastVisibleItemPosition);
        QLog.d("QQSearch.NetDetail.VideoPlayController", 4, "completevisible " + linearLayoutManager.findFirstCompletelyVisibleItemPosition() + "," + linearLayoutManager.findLastCompletelyVisibleItemPosition());
        List<com.tencent.mobileqq.search.searchdetail.c> items = this.searchResultListAdapter.getItems();
        Intrinsics.checkNotNullExpressionValue(items, "searchResultListAdapter.items");
        orNull = CollectionsKt___CollectionsKt.getOrNull(items, this.lastPlayIndex);
        com.tencent.mobileqq.search.searchdetail.content.model.a aVar3 = null;
        if (orNull instanceof com.tencent.mobileqq.search.searchdetail.content.model.a) {
            aVar = (com.tencent.mobileqq.search.searchdetail.content.model.a) orNull;
        } else {
            aVar = null;
        }
        int i3 = this.lastPlayIndex;
        if (findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
            while (true) {
                List<com.tencent.mobileqq.search.searchdetail.c> items2 = this.searchResultListAdapter.getItems();
                Intrinsics.checkNotNullExpressionValue(items2, "searchResultListAdapter.items");
                orNull2 = CollectionsKt___CollectionsKt.getOrNull(items2, findFirstVisibleItemPosition);
                if (orNull2 instanceof com.tencent.mobileqq.search.searchdetail.content.model.a) {
                    aVar2 = (com.tencent.mobileqq.search.searchdetail.content.model.a) orNull2;
                } else {
                    aVar2 = null;
                }
                if (aVar2 != null && aVar2.getIsContainVideo()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16 && g(this.searchResultListAdapter, findFirstVisibleItemPosition)) {
                    if (aVar2.isPlaying()) {
                        return;
                    }
                    QLog.d("QQSearch.NetDetail.VideoPlayController", 4, "find playable index:" + findFirstVisibleItemPosition + ",lastIndex:" + this.lastPlayIndex);
                    aVar2.f(1);
                    this.searchResultListAdapter.notifyItemChanged(findFirstVisibleItemPosition, com.tencent.mobileqq.search.searchdetail.content.model.a.INSTANCE.a());
                    this.lastPlayIndex = findFirstVisibleItemPosition;
                    aVar3 = aVar2;
                } else if (findFirstVisibleItemPosition == findLastVisibleItemPosition) {
                    break;
                } else {
                    findFirstVisibleItemPosition++;
                }
            }
        }
        if (aVar != null && !Intrinsics.areEqual(aVar, aVar3)) {
            QLog.d("QQSearch.NetDetail.VideoPlayController", 4, "notifyLastItem stop");
            aVar.f(0);
            this.searchResultListAdapter.notifyItemChanged(i3, com.tencent.mobileqq.search.searchdetail.content.model.a.INSTANCE.a());
        }
    }

    private final boolean g(com.tencent.mobileqq.search.searchdetail.content.base.e adapter, int position) {
        LinearLayoutManager linearLayoutManager;
        View findViewByPosition;
        View findViewById;
        RecyclerView recyclerView = adapter.getRecyclerView();
        if (recyclerView == null) {
            return false;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            linearLayoutManager = (LinearLayoutManager) layoutManager;
        } else {
            linearLayoutManager = null;
        }
        if (linearLayoutManager == null || (findViewByPosition = linearLayoutManager.findViewByPosition(position)) == null || (findViewById = findViewByPosition.findViewById(R.id.f85654pj)) == null || findViewById.getHeight() <= 0) {
            return false;
        }
        if (!findViewById.getGlobalVisibleRect(new Rect()) || r4.height() / findViewById.getHeight() <= 0.5f) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ void i(u uVar, RecyclerView recyclerView, long j3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j3 = 0;
        }
        uVar.h(recyclerView, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(u this$0, RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(recyclerView, "$recyclerView");
        this$0.e(recyclerView);
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.part.r
    @NotNull
    public List<com.tencent.mobileqq.search.searchdetail.c> c(@NotNull com.tencent.mobileqq.search.searchdetail.c currentItem) {
        Intrinsics.checkNotNullParameter(currentItem, "currentItem");
        List<com.tencent.mobileqq.search.searchdetail.c> items = this.searchResultListAdapter.getItems();
        Intrinsics.checkNotNullExpressionValue(items, "searchResultListAdapter.items");
        ArrayList arrayList = new ArrayList();
        for (Object obj : items) {
            if (((com.tencent.mobileqq.search.searchdetail.c) obj) instanceof NetSearchTemplateNineBoxGridItem) {
                arrayList.add(obj);
            }
        }
        int indexOf = arrayList.indexOf(currentItem);
        QLog.d("QQSearch.NetDetail.VideoPlayController", 2, "getPlayList,index:" + indexOf + ",size:" + arrayList.size());
        if (indexOf > 0) {
            return arrayList.subList(indexOf, arrayList.size());
        }
        return arrayList;
    }

    public final void f(@NotNull RecyclerView recyclerView, @NotNull com.tencent.mobileqq.search.searchdetail.content.model.a playItem) {
        Object orNull;
        com.tencent.mobileqq.search.searchdetail.content.model.a aVar;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(playItem, "playItem");
        if (!(playItem instanceof com.tencent.mobileqq.search.searchdetail.c)) {
            return;
        }
        int indexOf = this.searchResultListAdapter.getItems().indexOf((com.tencent.mobileqq.search.searchdetail.c) playItem);
        QLog.d("QQSearch.NetDetail.VideoPlayController", 4, "clickPlayIcon  currentPlayIndex:" + indexOf + "  lastPlayIndex:" + this.lastPlayIndex);
        if (this.lastPlayIndex == indexOf) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        List<com.tencent.mobileqq.search.searchdetail.c> items = this.searchResultListAdapter.getItems();
        Intrinsics.checkNotNullExpressionValue(items, "searchResultListAdapter.items");
        orNull = CollectionsKt___CollectionsKt.getOrNull(items, this.lastPlayIndex);
        if (orNull instanceof com.tencent.mobileqq.search.searchdetail.content.model.a) {
            aVar = (com.tencent.mobileqq.search.searchdetail.content.model.a) orNull;
        } else {
            aVar = null;
        }
        int i3 = this.lastPlayIndex;
        this.lastPlayIndex = indexOf;
        if (aVar != null) {
            aVar.f(0);
        }
        if (i3 >= findFirstVisibleItemPosition && i3 <= findLastVisibleItemPosition && aVar != null && !Intrinsics.areEqual(aVar, playItem)) {
            QLog.d("QQSearch.NetDetail.VideoPlayController", 4, "notifyLastItem stop");
            this.searchResultListAdapter.notifyItemChanged(i3, com.tencent.mobileqq.search.searchdetail.content.model.a.INSTANCE.a());
        }
    }

    public final void h(@NotNull final RecyclerView recyclerView, long delayMillis) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        QLog.d("QQSearch.NetDetail.VideoPlayController", 4, "postCheckVisibleVideoItem");
        recyclerView.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.t
            @Override // java.lang.Runnable
            public final void run() {
                u.j(u.this, recyclerView);
            }
        }, delayMillis);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (newState != 0) {
            return;
        }
        QLog.d("QQSearch.NetDetail.VideoPlayController", 4, "onScrollStateChanged to IDLE, try to find item play");
        e(recyclerView);
    }
}
