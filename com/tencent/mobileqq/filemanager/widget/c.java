package com.tencent.mobileqq.filemanager.widget;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ScrollView;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private int f209529a = Build.VERSION.SDK_INT;

    /* renamed from: b, reason: collision with root package name */
    private a f209530b;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface a {
        View getScrollableView();
    }

    private View a() {
        a aVar = this.f209530b;
        if (aVar == null) {
            return null;
        }
        return aVar.getScrollableView();
    }

    private boolean b(AdapterView adapterView) {
        View childAt;
        if (adapterView == null || adapterView.getFirstVisiblePosition() != 0 || ((childAt = adapterView.getChildAt(0)) != null && childAt.getTop() != 0)) {
            return false;
        }
        return true;
    }

    private boolean c(com.tencent.widget.AdapterView adapterView) {
        View childAt;
        if (adapterView == null || adapterView.getFirstVisiblePosition() != 0 || ((childAt = adapterView.getChildAt(0)) != null && childAt.getTop() != 0)) {
            return false;
        }
        return true;
    }

    private boolean d(ScrollView scrollView) {
        if (scrollView == null || scrollView.getScrollY() <= 0) {
            return true;
        }
        return false;
    }

    public boolean e() {
        View a16 = a();
        if (a16 == null) {
            return true;
        }
        if (a16 instanceof com.tencent.widget.AdapterView) {
            return c((com.tencent.widget.AdapterView) a16);
        }
        if (a16 instanceof AdapterView) {
            return b((AdapterView) a16);
        }
        if (!(a16 instanceof ScrollView)) {
            return true;
        }
        return d((ScrollView) a16);
    }

    public void f(boolean z16) {
        a();
    }

    public void g(a aVar) {
        this.f209530b = aVar;
    }

    @SuppressLint({"NewApi"})
    public void h(int i3, int i16, int i17) {
        View a16 = a();
        if (a16 instanceof AbsListView) {
            ((AbsListView) a16).smoothScrollBy(i16, i17);
            return;
        }
        if (a16 instanceof com.tencent.widget.AbsListView) {
            ((com.tencent.widget.AbsListView) a16).smoothScrollBy(i16, i17);
        } else if (a16 instanceof ScrollView) {
            ((ScrollView) a16).fling(i3);
        } else if (a16 instanceof WebView) {
            ((WebView) a16).flingScroll(0, i3);
        }
    }
}
