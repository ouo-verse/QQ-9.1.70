package com.tencent.mobileqq.guild.feed.manager;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.part.block.base.SafeStaggeredGridLayoutManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public class a extends com.tencent.mobileqq.guild.api.d {
    public static String E = "FeedScrollManager";
    public static float F = 200.0f;
    public static float G = 3.0f;
    public static int H = -1;
    public static int I = 0;
    public static int J = 1;
    private com.tencent.mobileqq.guild.api.e D;

    /* renamed from: d, reason: collision with root package name */
    private final RecyclerView f220157d;

    /* renamed from: e, reason: collision with root package name */
    private final Context f220158e;

    /* renamed from: h, reason: collision with root package name */
    private int f220160h;

    /* renamed from: i, reason: collision with root package name */
    private int f220161i;

    /* renamed from: m, reason: collision with root package name */
    private long f220162m;

    /* renamed from: f, reason: collision with root package name */
    private boolean f220159f = false;
    private List<com.tencent.mobileqq.guild.api.a> C = new ArrayList();

    public a(Context context, RecyclerView recyclerView, com.tencent.mobileqq.guild.api.e eVar) {
        this.f220158e = context;
        this.f220157d = recyclerView;
        this.D = eVar;
    }

    private void dispatchScrollStateChanged(RecyclerView recyclerView, int i3, RecyclerView.LayoutManager layoutManager, int i16, int i17, int i18, int i19) {
        Iterator<com.tencent.mobileqq.guild.api.a> it = this.C.iterator();
        while (it.hasNext()) {
            it.next().e(recyclerView, i3, layoutManager, i16, i17, i18, i19, this.f220159f);
        }
    }

    private void k(RecyclerView recyclerView, int i3, int i16, boolean z16) {
        Iterator<com.tencent.mobileqq.guild.api.a> it = this.C.iterator();
        while (it.hasNext()) {
            it.next().d(recyclerView, i3, i16, z16);
        }
    }

    private void l(boolean z16) {
        int[] d16 = d();
        Iterator<com.tencent.mobileqq.guild.api.a> it = this.C.iterator();
        while (it.hasNext()) {
            it.next().h(d16[0], d16[1], d16[2], d16[3], z16);
        }
    }

    @Override // com.tencent.mobileqq.guild.api.d
    public int[] d() {
        int[] iArr = new int[4];
        try {
            RecyclerView recyclerView = this.f220157d;
            if (recyclerView != null) {
                if (recyclerView.getLayoutManager() instanceof SafeStaggeredGridLayoutManager) {
                    SafeStaggeredGridLayoutManager safeStaggeredGridLayoutManager = (SafeStaggeredGridLayoutManager) this.f220157d.getLayoutManager();
                    iArr[0] = safeStaggeredGridLayoutManager.findFirstVisibleItemPositions(null)[0];
                    iArr[1] = safeStaggeredGridLayoutManager.findLastVisibleItemPositions(null)[1];
                    iArr[2] = safeStaggeredGridLayoutManager.findFirstCompletelyVisibleItemPositions(null)[0];
                    iArr[3] = safeStaggeredGridLayoutManager.findLastCompletelyVisibleItemPositions(null)[0];
                } else if (this.f220157d.getLayoutManager() instanceof SafeGridLayoutManager) {
                    SafeGridLayoutManager safeGridLayoutManager = (SafeGridLayoutManager) this.f220157d.getLayoutManager();
                    iArr[0] = safeGridLayoutManager.findFirstVisibleItemPosition();
                    iArr[1] = safeGridLayoutManager.findLastVisibleItemPosition();
                    iArr[2] = safeGridLayoutManager.findFirstCompletelyVisibleItemPosition();
                    iArr[3] = safeGridLayoutManager.findLastCompletelyVisibleItemPosition();
                } else if (this.f220157d.getLayoutManager() instanceof SafeLinearLayoutManager) {
                    SafeLinearLayoutManager safeLinearLayoutManager = (SafeLinearLayoutManager) this.f220157d.getLayoutManager();
                    iArr[0] = safeLinearLayoutManager.findFirstVisibleItemPosition();
                    iArr[1] = safeLinearLayoutManager.findLastVisibleItemPosition();
                    iArr[2] = safeLinearLayoutManager.findFirstCompletelyVisibleItemPosition();
                    iArr[3] = safeLinearLayoutManager.findLastCompletelyVisibleItemPosition();
                } else if (this.f220157d.getLayoutManager() instanceof com.tencent.mobileqq.guild.media.widget.audiofaceview.e) {
                    com.tencent.mobileqq.guild.media.widget.audiofaceview.e eVar = (com.tencent.mobileqq.guild.media.widget.audiofaceview.e) this.f220157d.getLayoutManager();
                    iArr[0] = eVar.findFirstVisibleItemPosition();
                    iArr[1] = eVar.findLastVisibleItemPosition();
                    iArr[2] = eVar.findFirstCompletelyVisibleItemPosition();
                    iArr[3] = eVar.findLastCompletelyVisibleItemPosition();
                }
            }
        } catch (Exception e16) {
            QLog.e(E, 1, "computePosition error", e16);
        }
        return iArr;
    }

    @Override // com.tencent.mobileqq.guild.api.d
    public void e(RecyclerView recyclerView) {
        Iterator<com.tencent.mobileqq.guild.api.a> it = this.C.iterator();
        while (it.hasNext()) {
            it.next().b(recyclerView);
        }
    }

    @Override // com.tencent.mobileqq.guild.api.d
    public void f() {
        Iterator<com.tencent.mobileqq.guild.api.a> it = this.C.iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
    }

    @Override // com.tencent.mobileqq.guild.api.d
    public void g() {
        Iterator<com.tencent.mobileqq.guild.api.a> it = this.C.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
    }

    @Override // com.tencent.mobileqq.guild.api.d
    public void h(RecyclerView.ViewHolder viewHolder) {
        Iterator<com.tencent.mobileqq.guild.api.a> it = this.C.iterator();
        while (it.hasNext()) {
            it.next().f(viewHolder);
        }
    }

    @Override // com.tencent.mobileqq.guild.api.d
    public void i(RecyclerView.ViewHolder viewHolder) {
        Iterator<com.tencent.mobileqq.guild.api.a> it = this.C.iterator();
        while (it.hasNext()) {
            it.next().g(viewHolder);
        }
    }

    public void j(com.tencent.mobileqq.guild.api.a aVar) {
        if (aVar != null) {
            aVar.a(this.f220158e, this.f220157d, this, this.D);
            this.C.add(aVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
        super.onScrollStateChanged(recyclerView, i3);
        RecyclerView.LayoutManager layoutManager = this.f220157d.getLayoutManager();
        int[] d16 = d();
        dispatchScrollStateChanged(recyclerView, i3, layoutManager, d16[0], d16[1], d16[2], d16[3]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
        boolean z16;
        boolean z17 = true;
        if (i16 >= 0) {
            this.f220159f = true;
            int i17 = this.f220160h;
            if (i17 != I && i17 != H) {
                resetScrollParam();
                QLog.d(E, 4, "change orient to up:" + this.f220160h);
            }
            if (this.f220162m == 0) {
                this.f220162m = System.currentTimeMillis();
            }
            this.f220161i += i16;
            this.f220160h = I;
        } else {
            this.f220159f = false;
            int i18 = this.f220160h;
            if (i18 != J && i18 != H) {
                resetScrollParam();
                QLog.d(E, 4, "change orient to down:" + this.f220160h);
            }
            if (this.f220162m == 0) {
                this.f220162m = System.currentTimeMillis();
            }
            this.f220161i += i16;
            this.f220160h = J;
        }
        float currentTimeMillis = (float) (System.currentTimeMillis() - this.f220162m);
        if (currentTimeMillis > F) {
            resetScrollParam();
            if (Math.abs(this.f220161i / currentTimeMillis) < G) {
                if (i16 >= 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                l(z16);
            }
        }
        if (i16 < 0) {
            z17 = false;
        }
        k(recyclerView, i3, i16, z17);
    }

    public void resetScrollParam() {
        this.f220160h = H;
        this.f220161i = 0;
        this.f220162m = 0L;
    }
}
