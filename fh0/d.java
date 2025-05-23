package fh0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ecommerce.base.ui.skeleton.ShimmerLayout;

/* compiled from: P */
/* loaded from: classes38.dex */
public class d extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private int C;
    private int[] D;
    private int E;
    private boolean F;
    private int G;
    private int H;

    /* renamed from: m, reason: collision with root package name */
    private int f398683m;

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class a extends RecyclerView.ViewHolder {
        a(View view) {
            super(view);
        }
    }

    private boolean i0() {
        int[] iArr = this.D;
        return (iArr == null || iArr.length == 0) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f398683m;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (i0()) {
            return j0(i3);
        }
        return super.getItemViewType(i3);
    }

    public int j0(int i3) {
        if (i0()) {
            int[] iArr = this.D;
            return iArr[i3 % iArr.length];
        }
        return this.C;
    }

    public void k0(int[] iArr) {
        this.D = iArr;
    }

    public void l0(int i3) {
        this.f398683m = i3;
    }

    public void m0(int i3) {
        this.C = i3;
    }

    public void n0(int i3) {
        this.H = i3;
    }

    public void o0(int i3) {
        this.E = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        if (this.F) {
            ShimmerLayout shimmerLayout = (ShimmerLayout) viewHolder.itemView;
            shimmerLayout.setShimmerAnimationDuration(this.G);
            shimmerLayout.setShimmerAngle(this.H);
            shimmerLayout.setShimmerColor(this.E);
            shimmerLayout.r();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (i0()) {
            this.C = i3;
        }
        if (this.F) {
            return new b(from, viewGroup, this.C);
        }
        return new a(from.inflate(this.C, viewGroup, false));
    }

    public void p0(int i3) {
        this.G = i3;
    }

    public void q0(boolean z16) {
        this.F = z16;
    }
}
