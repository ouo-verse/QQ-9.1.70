package com.tencent.mobileqq.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import java.util.LinkedList;

/* loaded from: classes20.dex */
public class PinnedDividerListView extends XListView implements AbsListView.OnScrollListener {
    private LinkedList<View> C;
    private b D;

    /* renamed from: d, reason: collision with root package name */
    private Context f315958d;

    /* renamed from: e, reason: collision with root package name */
    private a f315959e;

    /* renamed from: f, reason: collision with root package name */
    private View f315960f;

    /* renamed from: h, reason: collision with root package name */
    private int f315961h;

    /* renamed from: i, reason: collision with root package name */
    private int f315962i;

    /* renamed from: m, reason: collision with root package name */
    private AbsListView.OnScrollListener f315963m;

    /* loaded from: classes20.dex */
    public static abstract class a extends BaseAdapter {
        public abstract void configDividerView(View view, int i3);

        public abstract int getDividerLayout();

        public abstract boolean isDividerView(int i3);

        public boolean needHideDivider(View view, int i3) {
            return false;
        }
    }

    /* loaded from: classes20.dex */
    public interface b {
        void onLayout(View view, int i3, int i16, int i17, int i18);
    }

    public PinnedDividerListView(Context context) {
        super(context);
        this.f315958d = null;
        this.f315959e = null;
        this.f315960f = null;
        this.f315961h = 0;
        this.f315962i = 0;
        this.f315963m = null;
        this.C = new LinkedList<>();
        this.D = null;
        init(context);
    }

    private void init(Context context) {
        this.f315958d = context;
        super.setOnScrollListener(this);
    }

    @Override // com.tencent.widget.ListView
    public void addHeaderView(View view) {
        addHeaderView(view, null, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a b0() {
        return this.f315959e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.XListView, com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        View view = this.f315960f;
        if (view != null && view.getVisibility() == 0) {
            drawChild(canvas, this.f315960f, getDrawingTime());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, com.tencent.widget.AdapterView, android.view.ViewGroup, android.view.View
    @SuppressLint({"WrongCall"})
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        if (this.f315960f != null) {
            int firstVisiblePosition = getFirstVisiblePosition() - this.C.size();
            if (firstVisiblePosition >= 0 && !this.f315959e.needHideDivider(this.f315960f, firstVisiblePosition)) {
                this.f315960f.setVisibility(0);
                View view = this.f315960f;
                view.layout(0, -this.f315962i, view.getMeasuredWidth(), this.f315960f.getMeasuredHeight() - this.f315962i);
                this.f315959e.configDividerView(this.f315960f, firstVisiblePosition);
            } else {
                this.f315960f.setVisibility(4);
            }
        }
        int childCount = getChildCount();
        int size = this.C.size();
        while (true) {
            size++;
            if (size >= childCount) {
                break;
            }
            View childAt = getChildAt(size);
            if (childAt.getVisibility() != 0) {
                childAt.setVisibility(0);
            }
        }
        b bVar = this.D;
        if (bVar != null) {
            bVar.onLayout(this, i3, i16, i17, i18);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.XListView, com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        View view = this.f315960f;
        if (view != null) {
            measureChild(view, i3, i16);
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        int i18;
        int i19;
        View childAt;
        if (this.f315960f != null) {
            if (i3 >= this.C.size() && !this.f315959e.needHideDivider(this.f315960f, i3 - this.C.size())) {
                i3 -= this.C.size();
                this.f315959e.configDividerView(this.f315960f, i3);
                if (this.f315959e.isDividerView(i3)) {
                    this.f315961h = 0;
                    i18 = 1;
                } else {
                    View childAt2 = getChildAt(0);
                    if (childAt2 != null && childAt2.getBottom() > this.f315960f.getMeasuredHeight()) {
                        this.f315961h = 0;
                    } else if (this.f315959e.isDividerView(i3 + 1)) {
                        this.f315961h = 1;
                    } else {
                        this.f315961h = 0;
                    }
                    i18 = 0;
                }
                int childCount = getChildCount();
                if (i18 != 0 && (childAt = getChildAt(0)) != null && childAt.getVisibility() != 4) {
                    childAt.setVisibility(4);
                }
                while (i18 < childCount) {
                    View childAt3 = getChildAt(i18);
                    if (childAt3.getVisibility() != 0) {
                        childAt3.setVisibility(0);
                    }
                    i18++;
                }
                if (this.f315961h == 1) {
                    View childAt4 = getChildAt(1);
                    int measuredHeight = this.f315960f.getMeasuredHeight();
                    if (childAt4 != null) {
                        i19 = childAt4.getTop();
                    } else {
                        i19 = 0;
                    }
                    this.f315962i = measuredHeight - i19;
                } else {
                    this.f315962i = 0;
                }
                this.f315960f.setVisibility(0);
                View view = this.f315960f;
                view.layout(0, -this.f315962i, view.getMeasuredWidth(), this.f315960f.getMeasuredHeight() - this.f315962i);
            } else {
                this.f315961h = -1;
                this.f315960f.setVisibility(4);
                int size = this.C.size();
                if (this.f315959e.getCount() > 0 && this.f315959e.isDividerView(0) && size >= i3 && size < i3 + i16) {
                    getChildAt(size - i3).setVisibility(0);
                }
            }
        }
        AbsListView.OnScrollListener onScrollListener = this.f315963m;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i3, i16, i17);
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        AbsListView.OnScrollListener onScrollListener = this.f315963m;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i3);
        }
    }

    @Override // com.tencent.widget.ListView
    public boolean removeHeaderView(View view) {
        boolean removeHeaderView = super.removeHeaderView(view);
        if (removeHeaderView) {
            this.C.remove(view);
        }
        return removeHeaderView;
    }

    public void setFloatingView(int i3, int i16) {
        View view = this.f315960f;
        if (view != null && (view instanceof TextView)) {
            ((TextView) view).setTextColor(i3);
            ((TextView) this.f315960f).setBackgroundColor(i16);
        }
    }

    public void setOnLayoutListener(b bVar) {
        this.D = bVar;
    }

    @Override // com.tencent.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.f315963m = onScrollListener;
    }

    @Override // com.tencent.widget.ListView
    public void addHeaderView(View view, Object obj, boolean z16) {
        super.addHeaderView(view, obj, z16);
        this.C.add(view);
    }

    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, com.tencent.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter instanceof a) {
            a aVar = (a) listAdapter;
            this.f315959e = aVar;
            int dividerLayout = aVar.getDividerLayout();
            if (dividerLayout != 0) {
                this.f315960f = LayoutInflater.from(this.f315958d).inflate(dividerLayout, (ViewGroup) this, false);
                requestLayout();
            }
            super.setAdapter((ListAdapter) this.f315959e);
            return;
        }
        this.f315959e = null;
        super.setAdapter(listAdapter);
    }

    public PinnedDividerListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f315958d = null;
        this.f315959e = null;
        this.f315960f = null;
        this.f315961h = 0;
        this.f315962i = 0;
        this.f315963m = null;
        this.C = new LinkedList<>();
        this.D = null;
        init(context);
    }

    public PinnedDividerListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f315958d = null;
        this.f315959e = null;
        this.f315960f = null;
        this.f315961h = 0;
        this.f315962i = 0;
        this.f315963m = null;
        this.C = new LinkedList<>();
        this.D = null;
        init(context);
    }
}
