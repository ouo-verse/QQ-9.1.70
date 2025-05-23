package com.tencent.biz.subscribe.part.block.base;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.subscribe.part.block.base.RefreshHeaderView;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes5.dex */
public abstract class PullLoadMoreAdapter<E> extends com.tencent.biz.subscribe.part.block.base.a<E> implements RefreshHeaderView.c {
    private static String S = "PullLoadMoreAdapter";
    private boolean G;
    private RecyclerView.ViewHolder I;
    private RefreshHeaderView J;
    private boolean K;
    private boolean L;
    private boolean M;
    private View N;
    protected RecyclerView P;
    protected RecyclerView.LayoutManager R;

    /* renamed from: f, reason: collision with root package name */
    protected final Handler f96177f = new Handler(Looper.getMainLooper());

    /* renamed from: h, reason: collision with root package name */
    protected String f96178h = HardCodeUtil.qqStr(R.string.kvj);

    /* renamed from: i, reason: collision with root package name */
    protected String f96179i = HardCodeUtil.qqStr(R.string.kxj);

    /* renamed from: m, reason: collision with root package name */
    protected String f96180m = HardCodeUtil.qqStr(R.string.kxi);
    protected String C = HardCodeUtil.qqStr(R.string.f184053ku);
    protected String D = HardCodeUtil.qqStr(R.string.pov);
    private boolean E = false;
    protected String F = this.C;
    private boolean H = true;
    private boolean Q = true;

    /* renamed from: com.tencent.biz.subscribe.part.block.base.PullLoadMoreAdapter$3, reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ PullLoadMoreAdapter this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.P.scrollToPosition(0);
        }
    }

    /* renamed from: com.tencent.biz.subscribe.part.block.base.PullLoadMoreAdapter$4, reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ PullLoadMoreAdapter this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.P.scrollToPosition(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
            super.onScrolled(recyclerView, i3, i16);
            if (i16 > 0) {
                PullLoadMoreAdapter.this.K();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends RecyclerView.ViewHolder {

        /* renamed from: d, reason: collision with root package name */
        private final FrameLayout f96182d;

        /* renamed from: e, reason: collision with root package name */
        private LinearLayout f96183e;

        /* renamed from: f, reason: collision with root package name */
        private ProgressBar f96184f;

        /* renamed from: h, reason: collision with root package name */
        private TextView f96185h;

        public b(View view) {
            super(view);
            this.f96184f = (ProgressBar) view.findViewById(R.id.lz7);
            this.f96183e = (LinearLayout) view.findViewById(R.id.f165997lp1);
            this.f96185h = (TextView) view.findViewById(R.id.kbr);
            this.f96182d = (FrameLayout) view.findViewById(R.id.v7r);
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends RecyclerView.ViewHolder {
        public c(RefreshHeaderView refreshHeaderView) {
            super(refreshHeaderView);
        }
    }

    public RefreshHeaderView A() {
        return this.J;
    }

    protected int B() {
        return 1;
    }

    public boolean C() {
        return this.H;
    }

    public boolean D() {
        return this.G;
    }

    public boolean E() {
        return this.E;
    }

    public boolean F() {
        RefreshHeaderView refreshHeaderView = this.J;
        if (refreshHeaderView != null) {
            return refreshHeaderView.getIsRefreshing();
        }
        return false;
    }

    protected abstract void G(RecyclerView.ViewHolder viewHolder, int i3);

    protected void H(RecyclerView.ViewHolder viewHolder, int i3) {
        boolean z16;
        int i16;
        if (viewHolder instanceof b) {
            b bVar = (b) viewHolder;
            if (!this.M) {
                bVar.f96183e.setVisibility(8);
                if (this.N != null) {
                    bVar.f96182d.setVisibility(8);
                }
                QLog.i(S, 1, "onBindProgressViewHolder hideLoadingFooter");
                return;
            }
            if (this.L && getItemCount() > B()) {
                z16 = true;
            } else {
                z16 = false;
            }
            bVar.f96184f.setIndeterminate(z16);
            ProgressBar progressBar = bVar.f96184f;
            if (z16) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            progressBar.setVisibility(i16);
            if (this.N != null && this.E) {
                bVar.f96183e.setVisibility(8);
                bVar.f96182d.setVisibility(0);
                QLog.i(S, 1, "onBindProgressViewHolder show CustomNoMoreDataView");
                return;
            }
            bVar.f96183e.setVisibility(0);
            bVar.f96185h.setText(this.F);
            if (this.N != null) {
                bVar.f96182d.setVisibility(8);
            }
            QLog.i(S, 1, "onBindProgressViewHolder show progress text:" + this.F);
        }
    }

    public void I(boolean z16, boolean z17) {
        String str;
        boolean z18;
        String str2;
        if (C()) {
            this.L = false;
            this.E = z17;
            this.K = z16;
            if (z17) {
                str = this.C;
            } else {
                str = "";
            }
            this.F = str;
            if (StringUtil.isEmpty(str) && (!z17 || this.N == null)) {
                z18 = false;
            } else {
                z18 = true;
            }
            this.M = z18;
            if (!z16) {
                if (!NetworkUtils.isNetworkAvailable(BaseApplication.getContext())) {
                    str2 = this.f96180m;
                } else {
                    str2 = this.f96179i;
                }
                this.F = str2;
                this.M = this.Q;
            }
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.subscribe.part.block.base.PullLoadMoreAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    PullLoadMoreAdapter.this.notifyDataSetChanged();
                }
            });
            QLog.i(S, 1, String.format("onLoadMoreCompleted: hashCode:%d ,isSuccess:%b, isFinish:%b, isShow:%b", Integer.valueOf(hashCode()), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(this.M)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J() {
        this.L = true;
        this.F = this.D;
        this.M = true;
        notifyItemChanged(getItemCount() - 1);
    }

    protected void K() {
        try {
            if (this.R == null) {
                this.R = this.P.getLayoutManager();
            }
            RecyclerView.LayoutManager layoutManager = this.R;
            if (layoutManager instanceof LinearLayoutManager) {
                if (((LinearLayoutManager) layoutManager).findLastVisibleItemPosition() >= this.R.getItemCount() - 3) {
                    O();
                    return;
                }
                return;
            }
            if (layoutManager instanceof StaggeredGridLayoutManager) {
                StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                int columnCountForAccessibility = staggeredGridLayoutManager.getColumnCountForAccessibility(null, null);
                if (columnCountForAccessibility == 1) {
                    int[] iArr = new int[1];
                    staggeredGridLayoutManager.findLastVisibleItemPositions(iArr);
                    if (iArr[0] >= staggeredGridLayoutManager.getItemCount() - 3) {
                        O();
                        return;
                    }
                    return;
                }
                int[] iArr2 = new int[columnCountForAccessibility];
                staggeredGridLayoutManager.findLastVisibleItemPositions(iArr2);
                int i3 = iArr2[columnCountForAccessibility - 1];
                if (columnCountForAccessibility == 2) {
                    int i16 = iArr2[1];
                    int i17 = iArr2[0];
                    if (i16 >= i17) {
                        i3 = i16;
                    } else {
                        i3 = i17;
                    }
                }
                if (i3 >= (staggeredGridLayoutManager.getItemCount() - y()) - (columnCountForAccessibility * 3)) {
                    O();
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void L(boolean z16) {
        this.H = z16;
    }

    public void M(boolean z16) {
        this.G = z16;
    }

    public void N(boolean z16) {
        if (this.J != null) {
            this.L = F();
            this.J.setRefreshing(z16);
        }
    }

    protected abstract void O();

    public void P(RecyclerView.LayoutManager layoutManager) {
        this.R = layoutManager;
    }

    @Override // com.tencent.biz.subscribe.part.block.base.a, android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f96195d.size() + y();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (this.G && i3 == 0) {
            return -10000;
        }
        if (z(i3) < this.f96195d.size()) {
            return 0;
        }
        return -99999;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.P = recyclerView;
        this.R = recyclerView.getLayoutManager();
        this.P.addOnScrollListener(new a());
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        if (viewHolder != null && i3 < getItemCount() && (!this.G || i3 != 0)) {
            if (-99999 == getItemViewType(i3)) {
                H(viewHolder, i3);
            } else {
                G(viewHolder, z(i3));
            }
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(viewHolder, i3, getItemId(i3));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        if (i3 == -99999) {
            return w(viewGroup, i3);
        }
        if (i3 == -10000) {
            RecyclerView.ViewHolder x16 = x(viewGroup, i3);
            this.I = x16;
            return x16;
        }
        return v(viewGroup, i3);
    }

    @Override // com.tencent.biz.subscribe.part.block.base.a, android.support.v7.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        RefreshHeaderView refreshHeaderView = this.J;
        if (refreshHeaderView != null) {
            refreshHeaderView.onDestroy();
        }
        this.f96177f.removeCallbacksAndMessages(null);
    }

    protected abstract RecyclerView.ViewHolder v(ViewGroup viewGroup, int i3);

    protected RecyclerView.ViewHolder w(ViewGroup viewGroup, int i3) {
        b bVar = new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.g3m, viewGroup, false));
        if (this.N != null) {
            bVar.f96182d.addView(this.N);
        }
        return bVar;
    }

    protected RecyclerView.ViewHolder x(ViewGroup viewGroup, int i3) {
        if (this.J == null) {
            RefreshHeaderView refreshHeaderView = new RefreshHeaderView(viewGroup.getContext());
            this.J = refreshHeaderView;
            refreshHeaderView.setMinimumHeight(1);
            this.J.setOnRefreshListener(this);
        }
        return new c(this.J);
    }

    public int y() {
        boolean z16 = this.G;
        if (this.H) {
            return (z16 ? 1 : 0) + 1;
        }
        return z16 ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int z(int i3) {
        if (this.G) {
            return i3 - 1;
        }
        return i3;
    }

    public void onRefresh() {
    }
}
