package com.tencent.biz.qqcircle.scrollers;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.part.block.base.SafeStaggeredGridLayoutManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b extends RecyclerView.OnScrollListener {
    public static String E = "QCircleFeedScrollHelper";
    public static float F = 500.0f;
    public static float G = 3.0f;
    public static int H = -1;
    public static int I = 0;
    public static int J = 1;
    private long C;

    /* renamed from: d, reason: collision with root package name */
    private final RecyclerView f92285d;

    /* renamed from: e, reason: collision with root package name */
    private BaseListViewAdapter f92286e;

    /* renamed from: f, reason: collision with root package name */
    private final Context f92287f;

    /* renamed from: i, reason: collision with root package name */
    private int f92289i;

    /* renamed from: m, reason: collision with root package name */
    private int f92290m;

    /* renamed from: h, reason: collision with root package name */
    private boolean f92288h = false;
    private List<a> D = new ArrayList();

    public b(Context context, RecyclerView recyclerView, BaseListViewAdapter baseListViewAdapter) {
        this.f92287f = context;
        this.f92285d = recyclerView;
        this.f92286e = baseListViewAdapter;
    }

    private void dispatchScrollStateChanged(RecyclerView recyclerView, int i3, RecyclerView.LayoutManager layoutManager, int i16, int i17, int i18, int i19) {
        Iterator<a> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().r(recyclerView, i3, layoutManager, i16, i17, i18, i19, this.f92288h);
        }
    }

    private void f(RecyclerView recyclerView, int i3, int i16, boolean z16) {
        Iterator<a> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().q(recyclerView, i3, i16, z16);
        }
    }

    private void g(boolean z16) {
        int[] e16 = e();
        Iterator<a> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().x(e16[0], e16[1], e16[2], e16[3], z16);
        }
    }

    public void d(a aVar) {
        if (aVar != null) {
            aVar.e(this.f92287f, this.f92285d, this.f92286e, this);
            this.D.add(aVar);
        }
    }

    public int[] e() {
        RecyclerView recyclerView;
        int[] iArr = new int[4];
        try {
            recyclerView = this.f92285d;
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (recyclerView == null) {
            return iArr;
        }
        if (recyclerView.getLayoutManager() instanceof SafeStaggeredGridLayoutManager) {
            SafeStaggeredGridLayoutManager safeStaggeredGridLayoutManager = (SafeStaggeredGridLayoutManager) this.f92285d.getLayoutManager();
            iArr[0] = safeStaggeredGridLayoutManager.findFirstVisibleItemPositions(null)[0];
            int[] findLastVisibleItemPositions = safeStaggeredGridLayoutManager.findLastVisibleItemPositions(null);
            iArr[1] = findLastVisibleItemPositions[findLastVisibleItemPositions.length - 1];
            iArr[2] = safeStaggeredGridLayoutManager.findFirstCompletelyVisibleItemPositions(null)[0];
            int[] findLastCompletelyVisibleItemPositions = safeStaggeredGridLayoutManager.findLastCompletelyVisibleItemPositions(null);
            iArr[3] = findLastCompletelyVisibleItemPositions[findLastCompletelyVisibleItemPositions.length - 1];
        } else if (this.f92285d.getLayoutManager() instanceof SafeGridLayoutManager) {
            SafeGridLayoutManager safeGridLayoutManager = (SafeGridLayoutManager) this.f92285d.getLayoutManager();
            iArr[0] = safeGridLayoutManager.findFirstVisibleItemPosition();
            iArr[1] = safeGridLayoutManager.findLastVisibleItemPosition();
            iArr[2] = safeGridLayoutManager.findFirstCompletelyVisibleItemPosition();
            iArr[3] = safeGridLayoutManager.findLastCompletelyVisibleItemPosition();
        } else if (this.f92285d.getLayoutManager() instanceof SafeLinearLayoutManager) {
            SafeLinearLayoutManager safeLinearLayoutManager = (SafeLinearLayoutManager) this.f92285d.getLayoutManager();
            iArr[0] = safeLinearLayoutManager.findFirstVisibleItemPosition();
            iArr[1] = safeLinearLayoutManager.findLastVisibleItemPosition();
            iArr[2] = safeLinearLayoutManager.findFirstCompletelyVisibleItemPosition();
            iArr[3] = safeLinearLayoutManager.findLastCompletelyVisibleItemPosition();
        }
        return iArr;
    }

    public void h(RecyclerView recyclerView) {
        int i3;
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            i3 = ((StaggeredGridLayoutManager) layoutManager).getOrientation();
        } else if (layoutManager instanceof LinearLayoutManager) {
            i3 = ((LinearLayoutManager) layoutManager).getOrientation();
        } else {
            i3 = 1;
        }
        for (a aVar : this.D) {
            aVar.n(recyclerView);
            aVar.v(i3);
        }
    }

    public void i() {
        Iterator<a> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().p();
        }
    }

    public void j(RecyclerView.ViewHolder viewHolder) {
        Iterator<a> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().s(viewHolder);
        }
    }

    public void k(RecyclerView.ViewHolder viewHolder) {
        Iterator<a> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().t(viewHolder);
        }
    }

    public void l(QCircleExtraTypeInfo qCircleExtraTypeInfo) {
        Iterator<a> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().u(qCircleExtraTypeInfo);
        }
    }

    public void m(int i3) {
        Iterator<a> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().w(i3);
        }
    }

    public void onDestroy() {
        Iterator<a> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
    }

    public void onPause() {
        Iterator<a> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().o();
        }
    }

    public void onResume() {
        Iterator<a> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().onResume();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
        super.onScrollStateChanged(recyclerView, i3);
        RecyclerView.LayoutManager layoutManager = this.f92285d.getLayoutManager();
        int[] e16 = e();
        dispatchScrollStateChanged(recyclerView, i3, layoutManager, e16[0], e16[1], e16[2], e16[3]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
        boolean z16;
        boolean z17 = true;
        if (i16 >= 0) {
            this.f92288h = true;
            int i17 = this.f92289i;
            if (i17 != I && i17 != H) {
                resetScrollParam();
                if (QLog.isColorLevel()) {
                    QLog.d(E, 2, "change orient to up:" + this.f92289i);
                }
            }
            if (this.C == 0) {
                this.C = System.currentTimeMillis();
            }
            this.f92290m += i16;
            this.f92289i = I;
        } else {
            this.f92288h = false;
            int i18 = this.f92289i;
            if (i18 != J && i18 != H) {
                resetScrollParam();
                if (QLog.isColorLevel()) {
                    QLog.d(E, 2, "change orient to down:" + this.f92289i);
                }
            }
            if (this.C == 0) {
                this.C = System.currentTimeMillis();
            }
            this.f92290m += i16;
            this.f92289i = J;
        }
        float currentTimeMillis = (float) (System.currentTimeMillis() - this.C);
        if (currentTimeMillis > F) {
            resetScrollParam();
            if (Math.abs(this.f92290m / currentTimeMillis) < G) {
                if (i16 >= 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                g(z16);
            }
        }
        if (i16 < 0) {
            z17 = false;
        }
        f(recyclerView, i3, i16, z17);
    }

    public void onStop() {
        Iterator<a> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().onStop();
        }
    }

    public void resetScrollParam() {
        this.f92289i = H;
        this.f92290m = 0;
        this.C = 0L;
    }
}
