package com.tencent.mobileqq.guild.widget.qqui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.tencent.mobileqq.guild.widget.qqui.PinnedDividerListView;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XBaseAdapter;
import java.util.LinkedList;

/* loaded from: classes14.dex */
public class PinnedDividerSwipListView extends SwipListView implements AbsListView.OnScrollListener {
    private Context N;
    private a P;
    private View Q;
    private int R;
    private int S;
    private AbsListView.OnScrollListener T;
    private LinkedList<View> U;

    /* loaded from: classes14.dex */
    public static abstract class a extends XBaseAdapter {
        public abstract void configDividerView(View view, int i3);

        public abstract int getDividerLayout();

        public abstract boolean isDividerView(int i3);
    }

    /* loaded from: classes14.dex */
    public static class b implements AbsListView.OnScrollListener {
    }

    public PinnedDividerSwipListView(Context context) {
        super(context);
        this.N = null;
        this.P = null;
        this.Q = null;
        this.R = 0;
        this.S = 0;
        this.T = null;
        this.U = new LinkedList<>();
        init(context);
    }

    private void init(Context context) {
        this.N = context;
        super.setOnScrollListener(this);
    }

    @Override // com.tencent.widget.ListView
    public void addHeaderView(View view) {
        addHeaderView(view, null, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.XListView, com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        View view = this.Q;
        if (view != null && view.getVisibility() == 0) {
            drawChild(canvas, this.Q, getDrawingTime());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, com.tencent.widget.AdapterView, android.view.ViewGroup, android.view.View
    @SuppressLint({"WrongCall"})
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        if (this.Q != null) {
            int firstVisiblePosition = getFirstVisiblePosition() - this.U.size();
            if (firstVisiblePosition >= 0) {
                this.Q.setVisibility(0);
                View view = this.Q;
                view.layout(0, -this.S, view.getMeasuredWidth(), this.Q.getMeasuredHeight() - this.S);
                this.P.configDividerView(this.Q, firstVisiblePosition);
            } else {
                this.Q.setVisibility(4);
            }
        }
        int childCount = getChildCount();
        int size = this.U.size();
        while (true) {
            size++;
            if (size < childCount) {
                View childAt = getChildAt(size);
                if (childAt.getVisibility() != 0) {
                    childAt.setVisibility(0);
                }
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.XListView, com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        View view = this.Q;
        if (view != null) {
            measureChild(view, i3, i16);
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        int i18;
        int i19;
        if (this.Q != null) {
            if (i3 >= this.U.size()) {
                i3 -= this.U.size();
                this.P.configDividerView(this.Q, i3);
                if (this.P.isDividerView(i3)) {
                    this.R = 0;
                    i18 = 1;
                } else {
                    View childAt = getChildAt(0);
                    if (childAt != null && childAt.getBottom() > this.Q.getMeasuredHeight()) {
                        this.R = 0;
                    } else if (this.P.isDividerView(i3 + 1)) {
                        this.R = 1;
                    } else {
                        this.R = 0;
                    }
                    i18 = 0;
                }
                int childCount = getChildCount();
                if (i18 != 0) {
                    View childAt2 = getChildAt(0);
                    if (childAt2.getVisibility() != 4) {
                        childAt2.setVisibility(4);
                    }
                }
                while (i18 < childCount) {
                    View childAt3 = getChildAt(i18);
                    if (childAt3.getVisibility() != 0) {
                        childAt3.setVisibility(0);
                    }
                    i18++;
                }
                if (this.R == 1) {
                    View childAt4 = getChildAt(1);
                    int measuredHeight = this.Q.getMeasuredHeight();
                    if (childAt4 != null) {
                        i19 = childAt4.getTop();
                    } else {
                        i19 = 0;
                    }
                    this.S = measuredHeight - i19;
                } else {
                    this.S = 0;
                }
                this.Q.setVisibility(0);
                View view = this.Q;
                view.layout(0, -this.S, view.getMeasuredWidth(), this.Q.getMeasuredHeight() - this.S);
            } else {
                this.R = -1;
                this.Q.setVisibility(4);
                int size = this.U.size();
                if (this.P.getCount() > 0 && this.P.isDividerView(0) && size >= i3 && size < i3 + i16) {
                    getChildAt(size - i3).setVisibility(0);
                }
            }
        }
        AbsListView.OnScrollListener onScrollListener = this.T;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i3, i16, i17);
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        AbsListView.OnScrollListener onScrollListener = this.T;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i3);
        }
    }

    @Override // com.tencent.widget.ListView
    public boolean removeHeaderView(View view) {
        boolean removeHeaderView = super.removeHeaderView(view);
        if (removeHeaderView) {
            this.U.remove(view);
        }
        return removeHeaderView;
    }

    @Override // com.tencent.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.T = onScrollListener;
    }

    @Override // com.tencent.widget.ListView
    public void addHeaderView(View view, Object obj, boolean z16) {
        super.addHeaderView(view, obj, z16);
        this.U.add(view);
    }

    @Override // com.tencent.mobileqq.guild.widget.qqui.SwipListView, com.tencent.widget.ListView, com.tencent.widget.AbsListView, com.tencent.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter instanceof a) {
            a aVar = (a) listAdapter;
            this.P = aVar;
            int dividerLayout = aVar.getDividerLayout();
            if (dividerLayout != 0) {
                this.Q = LayoutInflater.from(this.N).inflate(dividerLayout, (ViewGroup) this, false);
                requestLayout();
            }
            super.setAdapter((ListAdapter) this.P);
            return;
        }
        this.P = null;
        super.setAdapter(listAdapter);
    }

    public PinnedDividerSwipListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.N = null;
        this.P = null;
        this.Q = null;
        this.R = 0;
        this.S = 0;
        this.T = null;
        this.U = new LinkedList<>();
        init(context);
    }

    public PinnedDividerSwipListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.N = null;
        this.P = null;
        this.Q = null;
        this.R = 0;
        this.S = 0;
        this.T = null;
        this.U = new LinkedList<>();
        init(context);
    }

    public void setOnLayoutListener(PinnedDividerListView.b bVar) {
    }

    public void setOnScrollListenerAdapter(b bVar) {
    }
}
