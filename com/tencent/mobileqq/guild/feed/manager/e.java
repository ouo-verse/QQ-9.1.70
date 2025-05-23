package com.tencent.mobileqq.guild.feed.manager;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.part.block.base.SafeStaggeredGridLayoutManager;
import com.tencent.mobileqq.guild.feed.bean.GuildExtraTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public class e extends RecyclerView.OnScrollListener {
    public static String E = "GuildFeedScrollManager";
    public static float F = 200.0f;
    public static float G = 3.0f;
    public static int H = -1;
    public static int I = 0;
    public static int J = 1;
    private long C;

    /* renamed from: d, reason: collision with root package name */
    private final RecyclerView f220172d;

    /* renamed from: e, reason: collision with root package name */
    private BaseListViewAdapter f220173e;

    /* renamed from: f, reason: collision with root package name */
    private final Context f220174f;

    /* renamed from: i, reason: collision with root package name */
    private int f220176i;

    /* renamed from: m, reason: collision with root package name */
    private int f220177m;

    /* renamed from: h, reason: collision with root package name */
    private boolean f220175h = false;
    private List<b> D = new ArrayList();

    public e(Context context, RecyclerView recyclerView, BaseListViewAdapter baseListViewAdapter) {
        this.f220174f = context;
        this.f220172d = recyclerView;
        this.f220173e = baseListViewAdapter;
    }

    private void dispatchScrollStateChanged(RecyclerView recyclerView, int i3, RecyclerView.LayoutManager layoutManager, int i16, int i17, int i18, int i19) {
        Iterator<b> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().j(recyclerView, i3, layoutManager, i16, i17, i18, i19, this.f220175h);
        }
    }

    private void f(RecyclerView recyclerView, int i3, int i16, boolean z16) {
        Iterator<b> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().i(recyclerView, i3, i16, z16);
        }
    }

    private void g(boolean z16) {
        int[] e16 = e();
        Iterator<b> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().p(e16[0], e16[1], e16[2], e16[3], z16);
        }
    }

    private int h(int i3) {
        List list;
        BaseListViewAdapter baseListViewAdapter = this.f220173e;
        if (baseListViewAdapter != null) {
            list = baseListViewAdapter.getDataList();
        } else {
            list = null;
        }
        if (list != null && !list.isEmpty()) {
            BaseListViewAdapter baseListViewAdapter2 = this.f220173e;
            if (baseListViewAdapter2 instanceof MultiViewBlock) {
                int max = Math.max(((MultiViewBlock) baseListViewAdapter2).getPositionOffsetStart(), 0);
                int max2 = Math.max(i3 - max, 0);
                QLog.d(E, 4, "[checkPreload] offsetStart: " + max + ", firstVisiblePos " + max2);
                return max2;
            }
        }
        QLog.e(E, 4, "feeds is null or empty! ");
        return i3;
    }

    public void d(b bVar) {
        if (bVar != null) {
            bVar.a(this.f220174f, this.f220172d, this.f220173e, this);
            this.D.add(bVar);
        }
    }

    public int[] e() {
        int[] iArr = new int[4];
        try {
            RecyclerView recyclerView = this.f220172d;
            if (recyclerView != null) {
                if (recyclerView.getLayoutManager() instanceof SafeStaggeredGridLayoutManager) {
                    SafeStaggeredGridLayoutManager safeStaggeredGridLayoutManager = (SafeStaggeredGridLayoutManager) this.f220172d.getLayoutManager();
                    iArr[0] = safeStaggeredGridLayoutManager.findFirstVisibleItemPositions(null)[0];
                    iArr[1] = safeStaggeredGridLayoutManager.findLastVisibleItemPositions(null)[0];
                    iArr[2] = safeStaggeredGridLayoutManager.findFirstCompletelyVisibleItemPositions(null)[0];
                    iArr[3] = safeStaggeredGridLayoutManager.findLastCompletelyVisibleItemPositions(null)[0];
                } else if (this.f220172d.getLayoutManager() instanceof SafeGridLayoutManager) {
                    SafeGridLayoutManager safeGridLayoutManager = (SafeGridLayoutManager) this.f220172d.getLayoutManager();
                    iArr[0] = safeGridLayoutManager.findFirstVisibleItemPosition();
                    iArr[1] = safeGridLayoutManager.findLastVisibleItemPosition();
                    iArr[2] = safeGridLayoutManager.findFirstCompletelyVisibleItemPosition();
                    iArr[3] = safeGridLayoutManager.findLastCompletelyVisibleItemPosition();
                } else if (this.f220172d.getLayoutManager() instanceof SafeLinearLayoutManager) {
                    SafeLinearLayoutManager safeLinearLayoutManager = (SafeLinearLayoutManager) this.f220172d.getLayoutManager();
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

    public void i(boolean z16) {
        Iterator<b> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().e(z16);
        }
    }

    public void j(RecyclerView recyclerView) {
        Iterator<b> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().f(recyclerView);
        }
    }

    public void k() {
        Iterator<b> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().h();
        }
    }

    public void l(RecyclerView.ViewHolder viewHolder) {
        Iterator<b> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().k(viewHolder);
        }
    }

    public void m(RecyclerView.ViewHolder viewHolder) {
        Iterator<b> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().l(viewHolder);
        }
    }

    public void n(GuildExtraTypeInfo guildExtraTypeInfo) {
        Iterator<b> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().m(guildExtraTypeInfo);
        }
    }

    public void o(int i3) {
        Iterator<b> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().n(i3);
        }
    }

    public void onDestroy() {
        Iterator<b> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
    }

    public void onPause() {
        Iterator<b> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().g();
        }
    }

    public void onResume() {
        Iterator<b> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().onResume();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
        super.onScrollStateChanged(recyclerView, i3);
        RecyclerView.LayoutManager layoutManager = this.f220172d.getLayoutManager();
        int[] e16 = e();
        dispatchScrollStateChanged(recyclerView, i3, layoutManager, e16[0], e16[1], e16[2], e16[3]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
        boolean z16;
        boolean z17 = true;
        if (i16 >= 0) {
            this.f220175h = true;
            int i17 = this.f220176i;
            if (i17 != I && i17 != H) {
                resetScrollParam();
                QLog.d(E, 4, "change orient to up:" + this.f220176i);
            }
            if (this.C == 0) {
                this.C = System.currentTimeMillis();
            }
            this.f220177m += i16;
            this.f220176i = I;
        } else {
            this.f220175h = false;
            int i18 = this.f220176i;
            if (i18 != J && i18 != H) {
                resetScrollParam();
                QLog.d(E, 4, "change orient to down:" + this.f220176i);
            }
            if (this.C == 0) {
                this.C = System.currentTimeMillis();
            }
            this.f220177m += i16;
            this.f220176i = J;
        }
        float currentTimeMillis = (float) (System.currentTimeMillis() - this.C);
        if (currentTimeMillis > F) {
            resetScrollParam();
            if (Math.abs(this.f220177m / currentTimeMillis) < G) {
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

    public void p() {
        Iterator<b> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().o();
        }
    }

    public void resetScrollParam() {
        this.f220176i = H;
        this.f220177m = 0;
        this.C = 0L;
    }
}
