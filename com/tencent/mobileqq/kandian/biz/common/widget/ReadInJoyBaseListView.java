package com.tencent.mobileqq.kandian.biz.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public abstract class ReadInJoyBaseListView extends XListView implements AbsListView.OnScrollListener {
    public int C;
    protected boolean D;
    protected int E;
    a F;
    protected boolean G;
    private ArrayList<ListView.OnScrollChangeListener> H;

    /* renamed from: d, reason: collision with root package name */
    protected TextView f239310d;

    /* renamed from: e, reason: collision with root package name */
    protected ProgressBar f239311e;

    /* renamed from: f, reason: collision with root package name */
    protected RelativeLayout f239312f;

    /* renamed from: h, reason: collision with root package name */
    protected int f239313h;

    /* renamed from: i, reason: collision with root package name */
    protected int f239314i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f239315m;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a implements AbsListView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name */
        List<AbsListView.OnScrollListener> f239316d = new ArrayList();

        public void a(AbsListView.OnScrollListener onScrollListener) {
            if (!this.f239316d.contains(onScrollListener)) {
                this.f239316d.add(onScrollListener);
            }
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
            Iterator<AbsListView.OnScrollListener> it = this.f239316d.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onScroll(absListView, i3, i16, i17);
                } catch (Throwable th5) {
                    if (QLog.isColorLevel()) {
                        QLog.e("ReadInJoyBaseListView", 2, "onScroll exp", th5);
                    }
                }
            }
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            Iterator<AbsListView.OnScrollListener> it = this.f239316d.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onScrollStateChanged(absListView, i3);
                } catch (Throwable th5) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ReadInJoyBaseListView", 2, "onScrollStateChanged exp", th5);
                    }
                }
            }
            if (i3 == 0) {
                VideoReport.traverseExposure();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface b {
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface c {
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface d {
    }

    public ReadInJoyBaseListView(Context context) {
        this(context, null);
    }

    private void c0(int i3) {
        RelativeLayout relativeLayout = this.f239312f;
        if (relativeLayout != null) {
            relativeLayout.setPadding(relativeLayout.getPaddingLeft(), 0, this.f239312f.getPaddingRight(), i3);
        }
    }

    public void b0(AbsListView.OnScrollListener onScrollListener) {
        a aVar = this.F;
        if (aVar != null) {
            aVar.a(onScrollListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d0(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, j52.a.f409456u4);
        this.f239315m = obtainStyledAttributes.getBoolean(j52.a.f409464v4, false);
        obtainStyledAttributes.recycle();
        if (this.f239315m) {
            e0();
        }
        super.setOnScrollListener(this.F);
        b0(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.XListView, com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    protected void e0() {
        LayoutInflater.from(getContext());
        this.f239311e = (ProgressBar) this.f239312f.findViewById(R.id.g5n);
        this.f239310d = (TextView) this.f239312f.findViewById(R.id.g5o);
        addFooterView(this.f239312f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, com.tencent.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        RelativeLayout relativeLayout;
        super.onLayout(z16, i3, i16, i17, i18);
        if (z16 && this.f239313h < 0 && (relativeLayout = this.f239312f) != null) {
            int height = relativeLayout.getHeight();
            this.f239313h = height;
            c0(-height);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.ListView, android.view.View
    public void onScrollChanged(int i3, int i16, int i17, int i18) {
        super.onScrollChanged(i3, i16, i17, i18);
        Iterator<ListView.OnScrollChangeListener> it = this.H.iterator();
        while (it.hasNext()) {
            it.next().onScrollChanged(this.mFirstPosition, getChildCount(), this.mItemCount);
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        boolean z16 = true;
        if (i3 != 1 && i3 != 2) {
            z16 = false;
        }
        this.D = z16;
    }

    public void setChannelId(int i3) {
        this.E = i3;
    }

    public void setCurrentStatus(int i3) {
        this.C = i3;
    }

    public void setNeedShowFootView(boolean z16) {
        this.f239315m = z16;
        e0();
    }

    @Override // com.tencent.widget.AbsListView
    public final void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        throw new RuntimeException("use addScrollListener  or removeScrollListener\uff0cbetter call addScrollListener in ReadInJoyBaseAdapter.onAddScrollListeners for control the call sequence");
    }

    public ReadInJoyBaseListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f239314i = 0;
        this.C = 0;
        this.D = false;
        this.F = new a();
        this.G = false;
        this.H = new ArrayList<>();
        d0(context, attributeSet);
    }

    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, com.tencent.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
    }

    public ReadInJoyBaseListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f239314i = 0;
        this.C = 0;
        this.D = false;
        this.F = new a();
        this.G = false;
        this.H = new ArrayList<>();
        d0(context, attributeSet);
    }

    public void setFooterView(boolean z16) {
    }

    public void setNoMoreData(boolean z16) {
    }

    public void setOnDrawCompleteListener(b bVar) {
    }

    public void setRefreshCallback(c cVar) {
    }

    public void setScrollEventCallback(d dVar) {
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
    }
}
