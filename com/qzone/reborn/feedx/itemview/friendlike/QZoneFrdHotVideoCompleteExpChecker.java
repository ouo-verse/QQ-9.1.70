package com.qzone.reborn.feedx.itemview.friendlike;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.proxy.feedcomponent.model.FrdHotVideoSubFeedInfo;
import com.qzone.proxy.feedcomponent.model.ParsedFeedData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001e\u0011B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007J\b\u0010\b\u001a\u00020\u0004H\u0007J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R0\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/qzone/reborn/feedx/itemview/friendlike/QZoneFrdHotVideoCompleteExpChecker;", "", "Lcom/qzone/reborn/feedx/itemview/friendlike/QZoneFrdHotVideoCompleteExpChecker$CheckSource;", "source", "", "c", "i", "e", tl.h.F, "g", "f", "Landroidx/recyclerview/widget/RecyclerView;", "a", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "Lcom/qzone/reborn/feedx/itemview/friendlike/a;", "b", "Ljava/util/List;", "lastCompleteExpElementList", "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", "getCompleteExpListener", "()Lkotlin/jvm/functions/Function1;", "j", "(Lkotlin/jvm/functions/Function1;)V", "completeExpListener", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "d", "CheckSource", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneFrdHotVideoCompleteExpChecker {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final RecyclerView recyclerView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final List<CompleteExpElement> lastCompleteExpElementList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Function1<? super CompleteExpElement, Unit> completeExpListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/qzone/reborn/feedx/itemview/friendlike/QZoneFrdHotVideoCompleteExpChecker$CheckSource;", "", "(Ljava/lang/String;I)V", "SCROLL_IDLE", "BIND_DATA", "RESUME", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes37.dex */
    public enum CheckSource {
        SCROLL_IDLE,
        BIND_DATA,
        RESUME
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/feedx/itemview/friendlike/QZoneFrdHotVideoCompleteExpChecker$a", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 0) {
                QZoneFrdHotVideoCompleteExpChecker.this.i();
            }
        }
    }

    public QZoneFrdHotVideoCompleteExpChecker(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.recyclerView = recyclerView;
        this.lastCompleteExpElementList = new ArrayList();
        recyclerView.addOnScrollListener(new a());
        recyclerView.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() { // from class: com.qzone.reborn.feedx.itemview.friendlike.QZoneFrdHotVideoCompleteExpChecker.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void onChildViewAttachedToWindow(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void onChildViewDetachedFromWindow(final View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (view instanceof b) {
                    CollectionsKt__MutableCollectionsKt.removeAll(QZoneFrdHotVideoCompleteExpChecker.this.lastCompleteExpElementList, (Function1) new Function1<CompleteExpElement, Boolean>() { // from class: com.qzone.reborn.feedx.itemview.friendlike.QZoneFrdHotVideoCompleteExpChecker$2$onChildViewDetachedFromWindow$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(CompleteExpElement it) {
                            ParsedFeedData parsedFeedData;
                            Intrinsics.checkNotNullParameter(it, "it");
                            FrdHotVideoSubFeedInfo curSubFeedInfo = ((b) view).getCurSubFeedInfo();
                            return Boolean.valueOf(Intrinsics.areEqual((curSubFeedInfo == null || (parsedFeedData = curSubFeedInfo.getParsedFeedData()) == null) ? null : parsedFeedData.getFeedId(), it.getFeedId()));
                        }
                    });
                }
            }
        });
    }

    private final void c(final CheckSource source) {
        this.recyclerView.post(new Runnable() { // from class: com.qzone.reborn.feedx.itemview.friendlike.c
            @Override // java.lang.Runnable
            public final void run() {
                QZoneFrdHotVideoCompleteExpChecker.d(QZoneFrdHotVideoCompleteExpChecker.this, source);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(QZoneFrdHotVideoCompleteExpChecker this$0, CheckSource source) {
        int collectionSizeOrDefault;
        Set set;
        List minus;
        FrdHotVideoSubFeedInfo curSubFeedInfo;
        ParsedFeedData parsedFeedData;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(source, "$source");
        RecyclerView.LayoutManager layoutManager = this$0.recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null) {
            return;
        }
        IntRange intRange = new IntRange(linearLayoutManager.findFirstVisibleItemPosition(), linearLayoutManager.findLastVisibleItemPosition());
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(intRange, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            arrayList.add(TuplesKt.to(Integer.valueOf(nextInt), linearLayoutManager.findViewByPosition(nextInt)));
        }
        ArrayList<Pair> arrayList2 = new ArrayList();
        Iterator it5 = arrayList.iterator();
        while (true) {
            boolean z16 = false;
            if (!it5.hasNext()) {
                break;
            }
            Object next = it5.next();
            View second = (View) ((Pair) next).getSecond();
            if (second != null) {
                Intrinsics.checkNotNullExpressionValue(second, "second");
                if (ef.c.a(second)) {
                    z16 = true;
                }
            }
            if (z16) {
                arrayList2.add(next);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Pair pair : arrayList2) {
            Object second2 = pair.getSecond();
            b bVar = second2 instanceof b ? (b) second2 : null;
            String feedId = (bVar == null || (curSubFeedInfo = bVar.getCurSubFeedInfo()) == null || (parsedFeedData = curSubFeedInfo.getParsedFeedData()) == null) ? null : parsedFeedData.getFeedId();
            CompleteExpElement completeExpElement = !(feedId == null || feedId.length() == 0) ? new CompleteExpElement(((Number) pair.getFirst()).intValue(), feedId) : null;
            if (completeExpElement != null) {
                arrayList3.add(completeExpElement);
            }
        }
        set = CollectionsKt___CollectionsKt.toSet(this$0.lastCompleteExpElementList);
        minus = CollectionsKt___CollectionsKt.minus((Iterable) arrayList3, (Iterable) set);
        this$0.lastCompleteExpElementList.addAll(minus);
        if (QLog.isColorLevel()) {
            QLog.i("QZoneFrdHotVideoCompleteExpChecker", 1, "checkCompleteExpList, source=" + source + ", newCompleteList=" + minus);
        }
        Function1<? super CompleteExpElement, Unit> function1 = this$0.completeExpListener;
        if (function1 != null) {
            Iterator it6 = minus.iterator();
            while (it6.hasNext()) {
                function1.invoke(it6.next());
            }
        }
    }

    public final void e() {
        c(CheckSource.BIND_DATA);
    }

    public final void f() {
        this.lastCompleteExpElementList.clear();
    }

    public final void g() {
        this.lastCompleteExpElementList.clear();
    }

    public final void h() {
        c(CheckSource.RESUME);
    }

    public final void i() {
        c(CheckSource.SCROLL_IDLE);
    }

    public final void j(Function1<? super CompleteExpElement, Unit> function1) {
        this.completeExpListener = function1;
    }
}
