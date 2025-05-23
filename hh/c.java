package hh;

import android.content.Context;
import android.view.KeyEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.part.block.base.SafeStaggeredGridLayoutManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c extends RecyclerView.OnScrollListener {
    public static float F = 500.0f;
    public static float G = 3.0f;
    public static int H = -1;
    public static int I = 0;
    public static int J = 1;
    private long C;

    /* renamed from: d, reason: collision with root package name */
    private final RecyclerView f404915d;

    /* renamed from: e, reason: collision with root package name */
    private BaseListViewAdapter f404916e;

    /* renamed from: f, reason: collision with root package name */
    private final Context f404917f;

    /* renamed from: i, reason: collision with root package name */
    private int f404919i;

    /* renamed from: m, reason: collision with root package name */
    private int f404920m;

    /* renamed from: h, reason: collision with root package name */
    private boolean f404918h = false;
    private List<b> D = new ArrayList();
    private HashSet<RecyclerView.ViewHolder> E = new HashSet<>();

    public c(Context context, RecyclerView recyclerView, BaseListViewAdapter baseListViewAdapter) {
        this.f404917f = context;
        this.f404915d = recyclerView;
        this.f404916e = baseListViewAdapter;
    }

    private void i(boolean z16, int[] iArr) {
        Iterator<b> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().q(iArr[0], iArr[1], iArr[2], iArr[3], z16);
        }
    }

    public void bindViewHolder(RecyclerView.ViewHolder viewHolder) {
        HashSet<RecyclerView.ViewHolder> hashSet = this.E;
        if (hashSet == null || viewHolder == null) {
            return;
        }
        hashSet.add(viewHolder);
    }

    public void j(RecyclerView recyclerView) {
        int orientation;
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            orientation = ((StaggeredGridLayoutManager) layoutManager).getOrientation();
        } else {
            orientation = layoutManager instanceof LinearLayoutManager ? ((LinearLayoutManager) layoutManager).getOrientation() : 1;
        }
        for (b bVar : this.D) {
            bVar.i(recyclerView);
            bVar.p(orientation);
        }
    }

    public void k() {
        Iterator<b> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().k();
        }
    }

    public void l(RecyclerView.ViewHolder viewHolder) {
        this.E.add(viewHolder);
        KeyEvent.Callback callback = viewHolder.itemView;
        if (callback instanceof vg.d) {
            ((vg.d) callback).i0().onViewHolderAttachedToWindow(viewHolder);
        }
        Iterator<b> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().n(viewHolder);
        }
        QLog.i("QZoneFeedScrollManager", 2, "onViewAttachedToWindow  holderNum = " + this.E.size() + " | holder.getAdapterPosition() = " + viewHolder.getAdapterPosition() + " | holder = " + viewHolder);
    }

    public void m(RecyclerView.ViewHolder viewHolder) {
        this.E.remove(viewHolder);
        KeyEvent.Callback callback = viewHolder.itemView;
        if (callback instanceof vg.d) {
            ((vg.d) callback).i0().onViewHolderDetachedFromWindow(viewHolder);
        }
        Iterator<b> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().o(viewHolder);
        }
        QLog.i("QZoneFeedScrollManager", 2, "onViewDetachedFromWindow  holderNum = " + this.E.size() + " | holder.getAdapterPosition() = " + viewHolder.getAdapterPosition() + " | holder = " + viewHolder);
    }

    public void onResume() {
        QLog.i("QZoneFeedScrollManager", 1, "onResumed");
        Iterator<RecyclerView.ViewHolder> it = this.E.iterator();
        while (it.hasNext()) {
            RecyclerView.ViewHolder next = it.next();
            if (next.getAdapterPosition() == -1) {
                QLog.i("QZoneFeedScrollManager", 1, "onResumed , holder.position == -1  | holder = " + next);
            } else {
                KeyEvent.Callback callback = next.itemView;
                if (callback instanceof vg.d) {
                    ((vg.d) callback).i0().c();
                }
            }
        }
        Iterator<b> it5 = this.D.iterator();
        while (it5.hasNext()) {
            it5.next().onResume();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
        super.onScrollStateChanged(recyclerView, i3);
        RecyclerView.LayoutManager layoutManager = this.f404915d.getLayoutManager();
        int[] g16 = g();
        dispatchScrollStateChanged(recyclerView, i3, layoutManager, g16[0], g16[1], g16[2], g16[3]);
    }

    public void resetScrollParam() {
        this.f404919i = H;
        this.f404920m = 0;
        this.C = 0L;
    }

    private void dispatchScroll(RecyclerView recyclerView, int i3, int i16, boolean z16, int[] iArr) {
        Iterator<b> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().l(recyclerView, i3, i16, z16, iArr[0], iArr[1], iArr[2], iArr[3]);
        }
    }

    private void dispatchScrollStateChanged(RecyclerView recyclerView, int i3, RecyclerView.LayoutManager layoutManager, int i16, int i17, int i18, int i19) {
        Iterator<b> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().m(recyclerView, i3, layoutManager, i16, i17, i18, i19, this.f404918h);
        }
    }

    private int[] e() {
        int[] iArr = new int[4];
        RecyclerView recyclerView = this.f404915d;
        if (recyclerView != null && recyclerView.getLayoutManager() != null) {
            SafeGridLayoutManager safeGridLayoutManager = (SafeGridLayoutManager) this.f404915d.getLayoutManager();
            iArr[0] = safeGridLayoutManager.findFirstVisibleItemPosition();
            iArr[1] = safeGridLayoutManager.findLastVisibleItemPosition();
            iArr[2] = safeGridLayoutManager.findFirstCompletelyVisibleItemPosition();
            iArr[3] = safeGridLayoutManager.findLastCompletelyVisibleItemPosition();
        }
        return iArr;
    }

    private int[] f() {
        int[] iArr = new int[4];
        RecyclerView recyclerView = this.f404915d;
        if (recyclerView != null && recyclerView.getLayoutManager() != null) {
            SafeLinearLayoutManager safeLinearLayoutManager = (SafeLinearLayoutManager) this.f404915d.getLayoutManager();
            iArr[0] = safeLinearLayoutManager.findFirstVisibleItemPosition();
            iArr[1] = safeLinearLayoutManager.findLastVisibleItemPosition();
            iArr[2] = safeLinearLayoutManager.findFirstCompletelyVisibleItemPosition();
            iArr[3] = safeLinearLayoutManager.findLastCompletelyVisibleItemPosition();
        }
        return iArr;
    }

    private int[] h() {
        int[] iArr = new int[4];
        RecyclerView recyclerView = this.f404915d;
        if (recyclerView != null && recyclerView.getLayoutManager() != null) {
            SafeStaggeredGridLayoutManager safeStaggeredGridLayoutManager = (SafeStaggeredGridLayoutManager) this.f404915d.getLayoutManager();
            iArr[0] = safeStaggeredGridLayoutManager.findFirstVisibleItemPositions(null)[0];
            iArr[1] = safeStaggeredGridLayoutManager.findLastVisibleItemPositions(null)[0];
            iArr[2] = safeStaggeredGridLayoutManager.findFirstCompletelyVisibleItemPositions(null)[0];
            iArr[3] = safeStaggeredGridLayoutManager.findLastCompletelyVisibleItemPositions(null)[0];
        }
        return iArr;
    }

    private void onScrollDown(int i3) {
        this.f404918h = false;
        int i16 = this.f404919i;
        if (i16 != J && i16 != H) {
            resetScrollParam();
            if (QLog.isColorLevel()) {
                QLog.d("QZoneFeedScrollManager", 2, "change orient to down:" + this.f404919i);
            }
        }
        if (this.C == 0) {
            this.C = System.currentTimeMillis();
        }
        this.f404920m += i3;
        this.f404919i = J;
    }

    private void onScrollUp(int i3) {
        this.f404918h = true;
        int i16 = this.f404919i;
        if (i16 != I && i16 != H) {
            resetScrollParam();
            if (QLog.isColorLevel()) {
                QLog.d("QZoneFeedScrollManager", 2, "change orient to up:" + this.f404919i);
            }
        }
        if (this.C == 0) {
            this.C = System.currentTimeMillis();
        }
        this.f404920m += i3;
        this.f404919i = I;
    }

    public int[] g() {
        RecyclerView recyclerView;
        int[] iArr = new int[4];
        try {
            recyclerView = this.f404915d;
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (recyclerView == null) {
            return iArr;
        }
        if (recyclerView.getLayoutManager() instanceof SafeStaggeredGridLayoutManager) {
            iArr = h();
        } else if (this.f404915d.getLayoutManager() instanceof SafeGridLayoutManager) {
            iArr = e();
        } else if (this.f404915d.getLayoutManager() instanceof SafeLinearLayoutManager) {
            iArr = f();
        }
        return iArr;
    }

    public void onDestroy() {
        QLog.i("QZoneFeedScrollManager", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        Iterator<RecyclerView.ViewHolder> it = this.E.iterator();
        while (it.hasNext()) {
            KeyEvent.Callback callback = it.next().itemView;
            if (callback instanceof vg.d) {
                ((vg.d) callback).i0().onDestroy();
            }
        }
        Iterator<b> it5 = this.D.iterator();
        while (it5.hasNext()) {
            it5.next().onDestroy();
        }
        this.E.clear();
        this.D.clear();
    }

    public void onPause() {
        QLog.i("QZoneFeedScrollManager", 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        Iterator<RecyclerView.ViewHolder> it = this.E.iterator();
        while (it.hasNext()) {
            KeyEvent.Callback callback = it.next().itemView;
            if (callback instanceof vg.d) {
                ((vg.d) callback).i0().onPaused();
            }
        }
        Iterator<b> it5 = this.D.iterator();
        while (it5.hasNext()) {
            it5.next().j();
        }
    }

    public void onStop() {
        QLog.i("QZoneFeedScrollManager", 1, DKHippyEvent.EVENT_STOP);
        Iterator<RecyclerView.ViewHolder> it = this.E.iterator();
        while (it.hasNext()) {
            KeyEvent.Callback callback = it.next().itemView;
            if (callback instanceof vg.d) {
                ((vg.d) callback).i0().onStop();
            }
        }
        Iterator<b> it5 = this.D.iterator();
        while (it5.hasNext()) {
            it5.next().onStop();
        }
    }

    public void d(b bVar) {
        if (bVar != null) {
            bVar.a(this.f404917f, this.f404915d, this.f404916e, this);
            this.D.add(bVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
        if (i16 >= 0) {
            onScrollUp(i16);
        } else {
            onScrollDown(i16);
        }
        float currentTimeMillis = (float) (System.currentTimeMillis() - this.C);
        int[] g16 = g();
        if (currentTimeMillis > F && Math.abs(this.f404920m / currentTimeMillis) < G) {
            i(i16 >= 0, g16);
            resetScrollParam();
        }
        dispatchScroll(recyclerView, i3, i16, i16 >= 0, g16);
    }
}
