package com.qzone.reborn.base;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.part.block.base.SafeStaggeredGridLayoutManager;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class q extends RecyclerView.OnScrollListener {
    public static float E = 500.0f;
    public static float F = 3.0f;
    public static int G = -1;
    public static int H = 0;
    public static int I = 1;
    private long C;

    /* renamed from: d, reason: collision with root package name */
    private final RecyclerView f53579d;

    /* renamed from: e, reason: collision with root package name */
    private h f53580e;

    /* renamed from: f, reason: collision with root package name */
    private final Context f53581f;

    /* renamed from: i, reason: collision with root package name */
    private int f53583i;

    /* renamed from: m, reason: collision with root package name */
    private int f53584m;

    /* renamed from: h, reason: collision with root package name */
    private boolean f53582h = false;
    private final List<p> D = new ArrayList();

    public q(Context context, RecyclerView recyclerView, h hVar) {
        this.f53581f = context;
        this.f53579d = recyclerView;
        this.f53580e = hVar;
    }

    private void f(boolean z16, int[] iArr) {
        Iterator<p> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().l(iArr[0], iArr[1], iArr[2], iArr[3], z16);
        }
    }

    public void g(RecyclerView recyclerView) {
        int orientation;
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            orientation = ((StaggeredGridLayoutManager) layoutManager).getOrientation();
        } else {
            orientation = layoutManager instanceof LinearLayoutManager ? ((LinearLayoutManager) layoutManager).getOrientation() : 1;
        }
        for (p pVar : this.D) {
            pVar.b(recyclerView);
            pVar.k(orientation);
        }
    }

    public void h(RecyclerView.ViewHolder viewHolder) {
        Iterator<p> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().i(viewHolder);
        }
    }

    public void i(RecyclerView.ViewHolder viewHolder) {
        Iterator<p> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().j(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
        super.onScrollStateChanged(recyclerView, i3);
        RecyclerView.LayoutManager layoutManager = this.f53579d.getLayoutManager();
        int[] e16 = e();
        dispatchScrollStateChanged(recyclerView, i3, layoutManager, e16[0], e16[1], e16[2], e16[3]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
        if (bl.b(this.D)) {
            return;
        }
        if (i16 >= 0) {
            this.f53582h = true;
            int i17 = this.f53583i;
            if (i17 != H && i17 != G) {
                resetScrollParam();
                if (QLog.isColorLevel()) {
                    QLog.d("QZMFeedScrollManager", 2, "change orient to up:" + this.f53583i);
                }
            }
            if (this.C == 0) {
                this.C = System.currentTimeMillis();
            }
            this.f53584m += i16;
            this.f53583i = H;
        } else {
            this.f53582h = false;
            int i18 = this.f53583i;
            if (i18 != I && i18 != G) {
                resetScrollParam();
                if (QLog.isColorLevel()) {
                    QLog.d("QZMFeedScrollManager", 2, "change orient to down:" + this.f53583i);
                }
            }
            if (this.C == 0) {
                this.C = System.currentTimeMillis();
            }
            this.f53584m += i16;
            this.f53583i = I;
        }
        float currentTimeMillis = (float) (System.currentTimeMillis() - this.C);
        int[] e16 = e();
        if (currentTimeMillis > E && Math.abs(this.f53584m / currentTimeMillis) < F) {
            f(i16 >= 0, e16);
            resetScrollParam();
        }
        dispatchScroll(recyclerView, i3, i16, i16 >= 0, e16);
    }

    public void resetScrollParam() {
        this.f53583i = G;
        this.f53584m = 0;
        this.C = 0L;
    }

    private void dispatchScroll(RecyclerView recyclerView, int i3, int i16, boolean z16, int[] iArr) {
        Iterator<p> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().f(recyclerView, i3, i16, z16, iArr[0], iArr[1], iArr[2], iArr[3]);
        }
    }

    private void dispatchScrollStateChanged(RecyclerView recyclerView, int i3, RecyclerView.LayoutManager layoutManager, int i16, int i17, int i18, int i19) {
        Iterator<p> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().g(recyclerView, i3, layoutManager, i16, i17, i18, i19, this.f53582h);
        }
    }

    public int[] e() {
        RecyclerView recyclerView;
        int[] iArr = new int[4];
        try {
            recyclerView = this.f53579d;
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (recyclerView == null) {
            return iArr;
        }
        if (recyclerView.getLayoutManager() instanceof SafeStaggeredGridLayoutManager) {
            SafeStaggeredGridLayoutManager safeStaggeredGridLayoutManager = (SafeStaggeredGridLayoutManager) this.f53579d.getLayoutManager();
            iArr[0] = safeStaggeredGridLayoutManager.findFirstVisibleItemPositions(null)[0];
            iArr[1] = safeStaggeredGridLayoutManager.findLastVisibleItemPositions(null)[0];
            iArr[2] = safeStaggeredGridLayoutManager.findFirstCompletelyVisibleItemPositions(null)[0];
            iArr[3] = safeStaggeredGridLayoutManager.findLastCompletelyVisibleItemPositions(null)[0];
        } else if (this.f53579d.getLayoutManager() instanceof SafeGridLayoutManager) {
            SafeGridLayoutManager safeGridLayoutManager = (SafeGridLayoutManager) this.f53579d.getLayoutManager();
            iArr[0] = safeGridLayoutManager.findFirstVisibleItemPosition();
            iArr[1] = safeGridLayoutManager.findLastVisibleItemPosition();
            iArr[2] = safeGridLayoutManager.findFirstCompletelyVisibleItemPosition();
            iArr[3] = safeGridLayoutManager.findLastCompletelyVisibleItemPosition();
        } else if (this.f53579d.getLayoutManager() instanceof SafeLinearLayoutManager) {
            SafeLinearLayoutManager safeLinearLayoutManager = (SafeLinearLayoutManager) this.f53579d.getLayoutManager();
            iArr[0] = safeLinearLayoutManager.findFirstVisibleItemPosition();
            iArr[1] = safeLinearLayoutManager.findLastVisibleItemPosition();
            iArr[2] = safeLinearLayoutManager.findFirstCompletelyVisibleItemPosition();
            iArr[3] = safeLinearLayoutManager.findLastCompletelyVisibleItemPosition();
        }
        return iArr;
    }

    public void onDestroy() {
        QLog.i("QZMFeedScrollManager", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        Iterator<p> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
        this.D.clear();
    }

    public void onPause() {
        QLog.i("QZMFeedScrollManager", 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        Iterator<p> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
    }

    public void onResume() {
        QLog.i("QZMFeedScrollManager", 1, "onResumed");
        Iterator<p> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().e();
        }
    }

    public void onStop() {
        QLog.i("QZMFeedScrollManager", 1, DKHippyEvent.EVENT_STOP);
        Iterator<p> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().h();
        }
    }

    public void d(p pVar) {
        if (pVar != null) {
            pVar.a(this.f53581f, this.f53579d, this.f53580e, this);
            this.D.add(pVar);
        }
    }
}
