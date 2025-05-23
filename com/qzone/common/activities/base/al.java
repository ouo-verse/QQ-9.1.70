package com.qzone.common.activities.base;

import android.view.View;
import com.tencent.widget.AbsListView;

/* compiled from: P */
/* loaded from: classes39.dex */
public class al implements AbsListView.OnScrollListener {
    private int C;

    /* renamed from: d, reason: collision with root package name */
    private a f45445d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f45446e;

    /* renamed from: f, reason: collision with root package name */
    private int f45447f;

    /* renamed from: h, reason: collision with root package name */
    private int f45448h;

    /* renamed from: i, reason: collision with root package name */
    private int f45449i;

    /* renamed from: m, reason: collision with root package name */
    private int f45450m;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface a {
        void a(int i3, int i16);
    }

    public al(a aVar) {
        this.f45445d = aVar;
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        if (absListView.getCount() == 0) {
            return;
        }
        if (i3 == 0) {
            this.f45446e = false;
            return;
        }
        if (i3 != 1) {
            return;
        }
        View childAt = absListView.getChildAt(0);
        this.f45447f = absListView.getFirstVisiblePosition();
        this.f45449i = childAt.getTop();
        this.f45450m = childAt.getBottom();
        this.f45448h = childAt.getHeight();
        this.f45446e = true;
        this.C = 0;
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        int i18;
        int i19;
        if (i17 == 0 || !this.f45446e || absListView == null || absListView.getChildAt(0) == null) {
            return;
        }
        View childAt = absListView.getChildAt(0);
        int top = childAt.getTop();
        int bottom = childAt.getBottom();
        int height = childAt.getHeight();
        int i26 = this.f45447f;
        if (i3 > i26) {
            int i27 = this.f45449i + this.f45448h;
            this.f45449i = i27;
            i19 = top - i27;
        } else {
            if (i3 < i26) {
                i18 = this.f45450m - this.f45448h;
                this.f45450m = i18;
            } else {
                i18 = this.f45450m;
            }
            i19 = bottom - i18;
        }
        int i28 = this.C + i19;
        this.C = i28;
        a aVar = this.f45445d;
        if (aVar != null) {
            aVar.a(i19, i28);
        }
        this.f45449i = top;
        this.f45450m = bottom;
        this.f45448h = height;
        this.f45447f = i3;
    }
}
