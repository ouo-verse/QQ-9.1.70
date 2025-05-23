package com.tencent.mobileqq.guild.widget.qqui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import java.util.LinkedList;

/* loaded from: classes14.dex */
public class PinnedDividerListView extends XListView implements AbsListView.OnScrollListener {
    private LinkedList<View> C;

    /* renamed from: d, reason: collision with root package name */
    private Context f236465d;

    /* renamed from: e, reason: collision with root package name */
    private a f236466e;

    /* renamed from: f, reason: collision with root package name */
    private View f236467f;

    /* renamed from: h, reason: collision with root package name */
    private int f236468h;

    /* renamed from: i, reason: collision with root package name */
    private int f236469i;

    /* renamed from: m, reason: collision with root package name */
    private AbsListView.OnScrollListener f236470m;

    /* loaded from: classes14.dex */
    public static abstract class a extends BaseAdapter {
        public abstract void a(View view, int i3);

        public abstract int b();

        public abstract boolean c(int i3);

        public boolean d(View view, int i3) {
            return false;
        }
    }

    /* loaded from: classes14.dex */
    public interface b {
    }

    public PinnedDividerListView(Context context) {
        super(context);
        this.f236465d = null;
        this.f236466e = null;
        this.f236467f = null;
        this.f236468h = 0;
        this.f236469i = 0;
        this.f236470m = null;
        this.C = new LinkedList<>();
        init(context);
    }

    private void init(Context context) {
        this.f236465d = context;
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
        View view = this.f236467f;
        if (view != null && view.getVisibility() == 0) {
            drawChild(canvas, this.f236467f, getDrawingTime());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, com.tencent.widget.AdapterView, android.view.ViewGroup, android.view.View
    @SuppressLint({"WrongCall"})
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        if (this.f236467f != null) {
            int firstVisiblePosition = getFirstVisiblePosition() - this.C.size();
            if (firstVisiblePosition >= 0 && !this.f236466e.d(this.f236467f, firstVisiblePosition)) {
                this.f236467f.setVisibility(0);
                View view = this.f236467f;
                view.layout(0, -this.f236469i, view.getMeasuredWidth(), this.f236467f.getMeasuredHeight() - this.f236469i);
                this.f236466e.a(this.f236467f, firstVisiblePosition);
            } else {
                this.f236467f.setVisibility(4);
            }
        }
        int childCount = getChildCount();
        int size = this.C.size();
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
        View view = this.f236467f;
        if (view != null) {
            measureChild(view, i3, i16);
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        int i18;
        int i19;
        View childAt;
        if (this.f236467f != null) {
            if (i3 >= this.C.size() && !this.f236466e.d(this.f236467f, i3 - this.C.size())) {
                i3 -= this.C.size();
                this.f236466e.a(this.f236467f, i3);
                if (this.f236466e.c(i3)) {
                    this.f236468h = 0;
                    i18 = 1;
                } else {
                    View childAt2 = getChildAt(0);
                    if (childAt2 != null && childAt2.getBottom() > this.f236467f.getMeasuredHeight()) {
                        this.f236468h = 0;
                    } else if (this.f236466e.c(i3 + 1)) {
                        this.f236468h = 1;
                    } else {
                        this.f236468h = 0;
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
                if (this.f236468h == 1) {
                    View childAt4 = getChildAt(1);
                    int measuredHeight = this.f236467f.getMeasuredHeight();
                    if (childAt4 != null) {
                        i19 = childAt4.getTop();
                    } else {
                        i19 = 0;
                    }
                    this.f236469i = measuredHeight - i19;
                } else {
                    this.f236469i = 0;
                }
                this.f236467f.setVisibility(0);
                View view = this.f236467f;
                view.layout(0, -this.f236469i, view.getMeasuredWidth(), this.f236467f.getMeasuredHeight() - this.f236469i);
            } else {
                this.f236468h = -1;
                this.f236467f.setVisibility(4);
                int size = this.C.size();
                if (this.f236466e.getCount() > 0 && this.f236466e.c(0) && size >= i3 && size < i3 + i16) {
                    getChildAt(size - i3).setVisibility(0);
                }
            }
        }
        AbsListView.OnScrollListener onScrollListener = this.f236470m;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i3, i16, i17);
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        AbsListView.OnScrollListener onScrollListener = this.f236470m;
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

    @Override // com.tencent.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.f236470m = onScrollListener;
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
            this.f236466e = aVar;
            int b16 = aVar.b();
            if (b16 != 0) {
                this.f236467f = LayoutInflater.from(this.f236465d).inflate(b16, (ViewGroup) this, false);
                requestLayout();
            }
            super.setAdapter((ListAdapter) this.f236466e);
            return;
        }
        this.f236466e = null;
        super.setAdapter(listAdapter);
    }

    public PinnedDividerListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f236465d = null;
        this.f236466e = null;
        this.f236467f = null;
        this.f236468h = 0;
        this.f236469i = 0;
        this.f236470m = null;
        this.C = new LinkedList<>();
        init(context);
    }

    public PinnedDividerListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f236465d = null;
        this.f236466e = null;
        this.f236467f = null;
        this.f236468h = 0;
        this.f236469i = 0;
        this.f236470m = null;
        this.C = new LinkedList<>();
        init(context);
    }

    public void setOnLayoutListener(b bVar) {
    }
}
