package com.tencent.mm.ui.widget.pulldown;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.luggage.wxa.lo.n;
import com.tencent.luggage.wxa.lo.r;
import com.tencent.mm.ui.widget.listview.PullDownListView;
import com.tencent.mm.ui.widget.pulldown.WeUIBounceView;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0016\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\n\u0010\u0015\u001a\u00020\u0014*\u00020\u0013J\n\u0010\u0017\u001a\u00020\u0016*\u00020\u0013R\u0014\u0010\u0018\u001a\u00020\u00148\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001c\u001a\u00020\u000e8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006 "}, d2 = {"Lcom/tencent/mm/ui/widget/pulldown/MMPullDownHelper;", "", "Lcom/tencent/mm/ui/widget/pulldown/WeUIBounceView;", "weUIPullDownView", "", "detectAndSolvePullDown", "Landroid/widget/ListView;", "listView", "handleListView", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "handleRecyclerView", "Landroid/view/View;", "view", "", "isVisible", "Landroid/widget/ScrollView;", "scrollView", "handleScrollView", "", "", "str", "", "max", "TAG", "Ljava/lang/String;", "a", "Z", "isDebug", "()Z", "<init>", "()V", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class MMPullDownHelper {

    @NotNull
    public static final String TAG = "WeUIPullDownView";

    @NotNull
    public static final MMPullDownHelper INSTANCE = new MMPullDownHelper();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final boolean isDebug = true;

    MMPullDownHelper() {
    }

    public final void detectAndSolvePullDown(@Nullable WeUIBounceView weUIPullDownView) {
        if (weUIPullDownView == null) {
            return;
        }
        View contentView = weUIPullDownView.getContentView();
        if (contentView instanceof ViewGroup) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(contentView);
            while (!linkedList.isEmpty()) {
                Object pollFirst = linkedList.pollFirst();
                Intrinsics.checkNotNullExpressionValue(pollFirst, "queue.pollFirst()");
                View view = (View) pollFirst;
                if (view instanceof ListView) {
                    handleListView(weUIPullDownView, (ListView) view);
                } else if (view instanceof RecyclerView) {
                    handleRecyclerView(weUIPullDownView, (RecyclerView) view);
                } else if (view instanceof ScrollView) {
                    handleScrollView(weUIPullDownView, (ScrollView) view);
                } else if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    int childCount = viewGroup.getChildCount();
                    for (int i3 = 0; i3 < childCount; i3++) {
                        if (viewGroup.getChildAt(i3) instanceof ViewGroup) {
                            View childAt = viewGroup.getChildAt(i3);
                            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
                            linkedList.addLast((ViewGroup) childAt);
                        }
                    }
                }
            }
        }
    }

    public final void handleListView(@NotNull WeUIBounceView weUIPullDownView, @NotNull final ListView listView) {
        final PullDownListView pullDownListView;
        Intrinsics.checkNotNullParameter(weUIPullDownView, "weUIPullDownView");
        Intrinsics.checkNotNullParameter(listView, "listView");
        if (listView instanceof PullDownListView) {
            pullDownListView = (PullDownListView) listView;
        } else {
            pullDownListView = null;
        }
        weUIPullDownView.setAtTopCallBack(new WeUIBounceView.IsAtTopCallBack() { // from class: com.tencent.mm.ui.widget.pulldown.MMPullDownHelper$handleListView$1
            @Override // com.tencent.mm.ui.widget.pulldown.WeUIBounceView.IsAtTopCallBack
            public final boolean isAtTop() {
                PullDownListView pullDownListView2 = PullDownListView.this;
                if (pullDownListView2 != null && pullDownListView2.isSupportOverscroll()) {
                    return false;
                }
                ListView listView2 = listView;
                View childAt = listView2.getChildAt(listView2.getFirstVisiblePosition());
                n.a("WeUIPullDownView", "dancy test weUIPullDownView, child:%s, first:%s", childAt, Integer.valueOf(listView.getFirstVisiblePosition()));
                if (childAt == null || childAt.getTop() != 0) {
                    return false;
                }
                n.a("WeUIPullDownView", "dancy test weUIPullDownView ture!!", new Object[0]);
                return true;
            }
        });
        weUIPullDownView.setAtBottomCallBack(new WeUIBounceView.IsAtBottomCallBack() { // from class: com.tencent.mm.ui.widget.pulldown.MMPullDownHelper$handleListView$2
            @Override // com.tencent.mm.ui.widget.pulldown.WeUIBounceView.IsAtBottomCallBack
            public final boolean isAtBottom() {
                Integer num;
                boolean z16;
                PullDownListView pullDownListView2 = PullDownListView.this;
                if (pullDownListView2 != null && pullDownListView2.isSupportOverscroll()) {
                    if (PullDownListView.this.getTranslationY() == 0.0f) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        return false;
                    }
                }
                ListView listView2 = listView;
                View childAt = listView2.getChildAt(listView2.getChildCount() - 1);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("lv at bottom bottomChild.bottom:");
                if (childAt != null) {
                    num = Integer.valueOf(childAt.getBottom());
                } else {
                    num = null;
                }
                sb5.append(num);
                sb5.append(",listView.height:");
                sb5.append(listView.getHeight());
                sb5.append(",lastVisiblePosition:");
                sb5.append(listView.getLastVisiblePosition());
                sb5.append(",cnt-1:");
                sb5.append(listView.getAdapter().getCount() - 1);
                sb5.append(",first:");
                sb5.append(listView.getFirstVisiblePosition());
                sb5.append(",childCnt:");
                sb5.append(listView.getChildCount());
                sb5.append("\uff0cscrollY:");
                sb5.append(listView.getScrollY());
                n.a("WeUIPullDownView", sb5.toString(), new Object[0]);
                if (childAt == null || childAt.getBottom() > listView.getHeight() || listView.getLastVisiblePosition() != listView.getAdapter().getCount() - 1) {
                    return false;
                }
                return true;
            }
        });
        listView.setOverScrollMode(2);
    }

    public final void handleRecyclerView(@NotNull WeUIBounceView weUIPullDownView, @NotNull final RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(weUIPullDownView, "weUIPullDownView");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        weUIPullDownView.setAtTopCallBack(new WeUIBounceView.IsAtTopCallBack() { // from class: com.tencent.mm.ui.widget.pulldown.MMPullDownHelper$handleRecyclerView$1
            @Override // com.tencent.mm.ui.widget.pulldown.WeUIBounceView.IsAtTopCallBack
            public final boolean isAtTop() {
                boolean z16;
                boolean z17;
                RecyclerView.LayoutManager layoutManager = RecyclerView.this.getLayoutManager();
                MMPullDownHelper mMPullDownHelper = MMPullDownHelper.INSTANCE;
                if (mMPullDownHelper.isDebug()) {
                    n.a("WeUIPullDownView", "rv layoutManager:" + layoutManager, new Object[0]);
                }
                boolean canScrollVertically = RecyclerView.this.canScrollVertically(-1);
                boolean z18 = true;
                View view = null;
                if (layoutManager instanceof LinearLayoutManager) {
                    Math.max(0, ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition());
                    if (RecyclerView.this.getChildCount() > 0) {
                        view = RecyclerView.this.getChildAt(0);
                    }
                    if (view != null) {
                        z17 = MMPullDownHelperKt.isCompleteVisible(view);
                    } else {
                        z17 = false;
                    }
                    if (canScrollVertically || !z17) {
                        z18 = false;
                    }
                    if (mMPullDownHelper.isDebug()) {
                        n.a("WeUIPullDownView", "rv atTop:" + z18 + " canScrollUp:" + canScrollVertically + " isVisible:" + z17, new Object[0]);
                    }
                    return z18;
                }
                if (!(layoutManager instanceof StaggeredGridLayoutManager)) {
                    return false;
                }
                if (RecyclerView.this.getChildCount() > 0) {
                    view = RecyclerView.this.getChildAt(0);
                }
                if (view != null) {
                    z16 = MMPullDownHelperKt.isCompleteVisible(view);
                } else {
                    z16 = false;
                }
                if (canScrollVertically || !z16) {
                    z18 = false;
                }
                if (mMPullDownHelper.isDebug()) {
                    n.a("WeUIPullDownView", "rv atTop:" + z18 + " canScrollUp:" + canScrollVertically + " isVisible:" + z16, new Object[0]);
                }
                return z18;
            }
        });
        weUIPullDownView.setAtBottomCallBack(new WeUIBounceView.IsAtBottomCallBack() { // from class: com.tencent.mm.ui.widget.pulldown.MMPullDownHelper$handleRecyclerView$2
            @Override // com.tencent.mm.ui.widget.pulldown.WeUIBounceView.IsAtBottomCallBack
            public final boolean isAtBottom() {
                boolean z16;
                RecyclerView.LayoutManager layoutManager = RecyclerView.this.getLayoutManager();
                boolean z17 = true;
                boolean canScrollVertically = RecyclerView.this.canScrollVertically(1);
                if (layoutManager instanceof LinearLayoutManager) {
                    boolean z18 = !canScrollVertically;
                    if (MMPullDownHelper.INSTANCE.isDebug()) {
                        n.a("WeUIPullDownView", "rv atBottom:" + z18 + " canScrollDown:" + canScrollVertically, new Object[0]);
                    }
                    return z18;
                }
                if (!(layoutManager instanceof StaggeredGridLayoutManager)) {
                    return false;
                }
                RecyclerView recyclerView2 = RecyclerView.this;
                View childAt = recyclerView2.getChildAt(recyclerView2.getChildCount() - 1);
                if (childAt != null) {
                    z16 = MMPullDownHelperKt.isCompleteVisible(childAt);
                } else {
                    z16 = false;
                }
                if (canScrollVertically || !z16) {
                    z17 = false;
                }
                if (MMPullDownHelper.INSTANCE.isDebug()) {
                    n.a("WeUIPullDownView", "rv atBottom:" + z17 + " canScrollDown:" + canScrollVertically + " isVisible" + z16, new Object[0]);
                }
                return z17;
            }
        });
        recyclerView.setOverScrollMode(2);
    }

    public final void handleScrollView(@NotNull WeUIBounceView weUIPullDownView, @NotNull final ScrollView scrollView) {
        Intrinsics.checkNotNullParameter(weUIPullDownView, "weUIPullDownView");
        Intrinsics.checkNotNullParameter(scrollView, "scrollView");
        weUIPullDownView.setAtTopCallBack(new WeUIBounceView.IsAtTopCallBack() { // from class: com.tencent.mm.ui.widget.pulldown.MMPullDownHelper$handleScrollView$1
            @Override // com.tencent.mm.ui.widget.pulldown.WeUIBounceView.IsAtTopCallBack
            public final boolean isAtTop() {
                n.a("WeUIPullDownView", "sv top callback", new Object[0]);
                if (scrollView.getScrollY() != 0) {
                    return false;
                }
                return true;
            }
        });
        weUIPullDownView.setAtBottomCallBack(new WeUIBounceView.IsAtBottomCallBack() { // from class: com.tencent.mm.ui.widget.pulldown.MMPullDownHelper$handleScrollView$2
            @Override // com.tencent.mm.ui.widget.pulldown.WeUIBounceView.IsAtBottomCallBack
            public final boolean isAtBottom() {
                n.a("WeUIPullDownView", "sv bottom callback", new Object[0]);
                View childAt = scrollView.getChildAt(0);
                if (childAt == null || childAt.getMeasuredHeight() > scrollView.getScrollY() + scrollView.getHeight()) {
                    return false;
                }
                return true;
            }
        });
        scrollView.setOverScrollMode(2);
    }

    public final boolean isDebug() {
        return isDebug;
    }

    public final boolean isVisible(@Nullable View view) {
        if (view == null || !view.isShown()) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        Point a16 = r.a(view.getContext());
        return rect.intersect(new Rect(0, 0, a16.x, a16.y));
    }

    public final int max(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int i3 = Integer.MIN_VALUE;
        for (int i16 : iArr) {
            i3 = Math.max(i3, i16);
        }
        return i3;
    }

    @NotNull
    public final String str(@NotNull int[] iArr) {
        boolean z16;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        StringBuilder sb5 = new StringBuilder();
        for (int i3 : iArr) {
            if (sb5.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                sb5.append(",");
            }
            sb5.append(i3);
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
        return sb6;
    }
}
