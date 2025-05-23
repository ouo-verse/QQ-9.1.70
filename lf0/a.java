package lf0;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private RecyclerView.LayoutManager f414436a;

    public a(@NonNull RecyclerView.LayoutManager layoutManager) {
        this.f414436a = layoutManager;
    }

    public void a(View view) {
        this.f414436a.attachView(view);
    }

    public void b(RecyclerView.Recycler recycler) {
        this.f414436a.detachAndScrapAttachedViews(recycler);
    }

    public void c(View view, RecyclerView.Recycler recycler) {
        this.f414436a.detachAndScrapView(view, recycler);
    }

    public void d(View view) {
        this.f414436a.detachView(view);
    }

    public View e(int i3) {
        return this.f414436a.getChildAt(i3);
    }

    public int f() {
        return this.f414436a.getChildCount();
    }

    public int g() {
        return this.f414436a.getHeight();
    }

    public int h() {
        return this.f414436a.getItemCount();
    }

    public View i(int i3, RecyclerView.Recycler recycler) {
        View viewForPosition = recycler.getViewForPosition(i3);
        this.f414436a.addView(viewForPosition);
        this.f414436a.measureChildWithMargins(viewForPosition, 0, 0);
        return viewForPosition;
    }

    public int j(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return this.f414436a.getDecoratedMeasuredHeight(view) + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public int k(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return this.f414436a.getDecoratedMeasuredWidth(view) + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
    }

    public int l(View view) {
        return this.f414436a.getPosition(view);
    }

    public int m() {
        return this.f414436a.getWidth();
    }

    public void n(View view, int i3, int i16, int i17, int i18) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        this.f414436a.layoutDecorated(view, i3 + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i16 + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, i17 - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i18 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
    }

    public void o(int i3) {
        this.f414436a.offsetChildrenHorizontal(i3);
    }

    public void p(View view, RecyclerView.Recycler recycler) {
        recycler.recycleView(view);
    }

    public void q() {
        this.f414436a.removeAllViews();
    }

    public void r(RecyclerView.Recycler recycler) {
        this.f414436a.removeAndRecycleAllViews(recycler);
    }

    public void s() {
        this.f414436a.requestLayout();
    }

    public void t(RecyclerView.SmoothScroller smoothScroller) {
        this.f414436a.startSmoothScroll(smoothScroller);
    }
}
