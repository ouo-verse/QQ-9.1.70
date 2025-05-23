package kk1;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.part.block.base.SafeStaggeredGridLayoutManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public class e extends RecyclerView.OnScrollListener {
    public static String E = "Guild_Feed_GAL_GuildFeedGalleryScrollManager";
    public static float F = 200.0f;
    public static float G = 3.0f;
    public static int H = -1;
    public static int I = 0;
    public static int J = 1;
    private long C;

    /* renamed from: d, reason: collision with root package name */
    private final RecyclerView f412595d;

    /* renamed from: e, reason: collision with root package name */
    private final Context f412596e;

    /* renamed from: f, reason: collision with root package name */
    private BaseListViewAdapter f412597f;

    /* renamed from: i, reason: collision with root package name */
    private int f412599i;

    /* renamed from: m, reason: collision with root package name */
    private int f412600m;

    /* renamed from: h, reason: collision with root package name */
    private boolean f412598h = false;
    private List<lk1.a> D = new ArrayList();

    public e(Context context, RecyclerView recyclerView, BaseListViewAdapter baseListViewAdapter) {
        this.f412596e = context;
        this.f412595d = recyclerView;
        this.f412597f = baseListViewAdapter;
    }

    private void dispatchScrollStateChanged(RecyclerView recyclerView, int i3, RecyclerView.LayoutManager layoutManager, int i16, int i17, int i18, int i19) {
        Iterator<lk1.a> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().f(recyclerView, i3, layoutManager, i16, i17, i18, i19, this.f412598h);
        }
    }

    private void f(RecyclerView recyclerView, int i3, int i16, boolean z16) {
        Iterator<lk1.a> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().e(recyclerView, i3, i16, z16);
        }
    }

    private void g(boolean z16) {
        int[] e16 = e();
        Iterator<lk1.a> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().j(e16[0], e16[1], e16[2], e16[3], z16);
        }
    }

    public void d(lk1.a aVar) {
        if (aVar != null) {
            aVar.a(this.f412596e, this.f412595d, this.f412597f, this);
            this.D.add(aVar);
        }
    }

    public int[] e() {
        int[] iArr = new int[4];
        try {
            RecyclerView recyclerView = this.f412595d;
            if (recyclerView != null) {
                if (recyclerView.getLayoutManager() instanceof SafeStaggeredGridLayoutManager) {
                    SafeStaggeredGridLayoutManager safeStaggeredGridLayoutManager = (SafeStaggeredGridLayoutManager) this.f412595d.getLayoutManager();
                    iArr[0] = safeStaggeredGridLayoutManager.findFirstVisibleItemPositions(null)[0];
                    iArr[1] = safeStaggeredGridLayoutManager.findLastVisibleItemPositions(null)[0];
                    iArr[2] = safeStaggeredGridLayoutManager.findFirstCompletelyVisibleItemPositions(null)[0];
                    iArr[3] = safeStaggeredGridLayoutManager.findLastCompletelyVisibleItemPositions(null)[0];
                } else if (this.f412595d.getLayoutManager() instanceof SafeGridLayoutManager) {
                    SafeGridLayoutManager safeGridLayoutManager = (SafeGridLayoutManager) this.f412595d.getLayoutManager();
                    iArr[0] = safeGridLayoutManager.findFirstVisibleItemPosition();
                    iArr[1] = safeGridLayoutManager.findLastVisibleItemPosition();
                    iArr[2] = safeGridLayoutManager.findFirstCompletelyVisibleItemPosition();
                    iArr[3] = safeGridLayoutManager.findLastCompletelyVisibleItemPosition();
                } else if (this.f412595d.getLayoutManager() instanceof SafeLinearLayoutManager) {
                    SafeLinearLayoutManager safeLinearLayoutManager = (SafeLinearLayoutManager) this.f412595d.getLayoutManager();
                    iArr[0] = safeLinearLayoutManager.findFirstVisibleItemPosition();
                    iArr[1] = safeLinearLayoutManager.findLastVisibleItemPosition();
                    iArr[2] = safeLinearLayoutManager.findFirstCompletelyVisibleItemPosition();
                    iArr[3] = safeLinearLayoutManager.findLastCompletelyVisibleItemPosition();
                }
                int i3 = iArr[0];
                int i16 = iArr[1] - i3;
                int i17 = iArr[2];
                int i18 = iArr[3] - i17;
                int h16 = h(i3);
                iArr[0] = h16;
                iArr[1] = h16 + i16;
                int h17 = h(i17);
                iArr[2] = h17;
                iArr[3] = h17 + i18;
            }
        } catch (Exception e16) {
            QLog.e(E, 1, "computePosition error", e16);
        }
        return iArr;
    }

    public void i(RecyclerView recyclerView) {
        Iterator<lk1.a> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().b(recyclerView);
        }
    }

    public void j(int i3) {
        Iterator<lk1.a> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().c(i3);
        }
    }

    public void k(RecyclerView.ViewHolder viewHolder) {
        Iterator<lk1.a> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().g(viewHolder);
        }
    }

    public void l(RecyclerView.ViewHolder viewHolder) {
        Iterator<lk1.a> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().h(viewHolder);
        }
    }

    public void m(int i3) {
        Iterator<lk1.a> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().i(i3);
        }
    }

    public void onDestroy() {
        Iterator<lk1.a> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
    }

    public void onPause() {
        Iterator<lk1.a> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
    }

    public void onResume() {
        Iterator<lk1.a> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().onResume();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
        super.onScrollStateChanged(recyclerView, i3);
        RecyclerView.LayoutManager layoutManager = this.f412595d.getLayoutManager();
        int[] e16 = e();
        dispatchScrollStateChanged(recyclerView, i3, layoutManager, e16[0], e16[1], e16[2], e16[3]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
        boolean z16;
        boolean z17 = true;
        if (i16 >= 0) {
            this.f412598h = true;
            int i17 = this.f412599i;
            if (i17 != I && i17 != H) {
                resetScrollParam();
                QLog.d(E, 4, "change orient to up:" + this.f412599i);
            }
            if (this.C == 0) {
                this.C = System.currentTimeMillis();
            }
            this.f412600m += i16;
            this.f412599i = I;
        } else {
            this.f412598h = false;
            int i18 = this.f412599i;
            if (i18 != J && i18 != H) {
                resetScrollParam();
                QLog.d(E, 4, "change orient to down:" + this.f412599i);
            }
            if (this.C == 0) {
                this.C = System.currentTimeMillis();
            }
            this.f412600m += i16;
            this.f412599i = J;
        }
        float currentTimeMillis = (float) (System.currentTimeMillis() - this.C);
        if (currentTimeMillis > F) {
            resetScrollParam();
            if (Math.abs(this.f412600m / currentTimeMillis) < G) {
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

    public void resetScrollParam() {
        this.f412599i = H;
        this.f412600m = 0;
        this.C = 0L;
    }

    private int h(int i3) {
        return i3;
    }
}
