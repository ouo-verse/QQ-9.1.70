package com.tencent.mobileqq.guild.component.imagebanner;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class a<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    private RecyclerView F;

    /* renamed from: m, reason: collision with root package name */
    private long f215922m = 2000;
    private long C = 1000;
    private boolean D = true;
    private boolean E = true;

    public long getAnimationTime() {
        return this.C;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (isCanLoop()) {
            return k0() + 2;
        }
        return k0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getRealPosition(int i3) {
        if (isCanLoop()) {
            int k06 = (i3 % k0()) - 1;
            if (k06 < 0) {
                return k0() - 1;
            }
            return k06;
        }
        return i3;
    }

    public RecyclerView getRecyclerView() {
        return this.F;
    }

    public long getSwitchDurationTime() {
        return this.f215922m;
    }

    protected abstract void i0(VH vh5, int i3);

    public boolean isCanLoop() {
        if (k0() > 1 && this.D && !this.E) {
            return true;
        }
        return false;
    }

    protected abstract void j0(VH vh5, int i3, @NonNull List<Object> list);

    public abstract int k0();

    public boolean l0() {
        return this.E;
    }

    public void o0(boolean z16) {
        this.E = z16;
        if (z16) {
            this.D = false;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        this.F = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(@NonNull VH vh5, int i3) {
        i0(vh5, getRealPosition(i3));
    }

    public void setEnableLoop(boolean z16) {
        this.D = z16;
        if (z16) {
            this.E = false;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(@NonNull VH vh5, int i3, @NonNull List<Object> list) {
        super.onBindViewHolder(vh5, i3, list);
        j0(vh5, getRealPosition(i3), list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m0(VH vh5, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n0(VH vh5, int i3) {
    }
}
