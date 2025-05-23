package com.tencent.biz.qqcircle.immersive.views.banner;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.RFWIocBaseInterface;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class k<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    private RecyclerView F;

    /* renamed from: m, reason: collision with root package name */
    private long f90756m = 2000;
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
        return this.f90756m;
    }

    protected abstract void i0(VH vh5, int i3);

    public boolean isCanLoop() {
        if (k0() > 1 && this.D && !this.E) {
            return true;
        }
        return false;
    }

    public abstract int k0();

    /* JADX INFO: Access modifiers changed from: protected */
    public <T extends RFWIocBaseInterface> T l0(Class<T> cls) {
        T t16 = (T) RFWIocAbilityProvider.g().getIocInterface(cls, getRecyclerView(), null);
        RFWLog.i("qioc-RFWBaseBannerAdapter", RFWLog.USR, "getIocInterface  | iocClass = " + cls.getSimpleName() + " | iocInterface = " + t16 + " | this = " + this + " | viewHash = " + getRecyclerView().hashCode());
        return t16;
    }

    public boolean m0() {
        return this.E;
    }

    public boolean n0() {
        return this.D;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        this.F = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(@NonNull VH vh5, int i3) {
        i0(vh5, getRealPosition(i3));
    }

    public void q0(long j3) {
        this.C = j3;
    }

    public void r0(boolean z16) {
        this.E = z16;
        if (z16) {
            this.D = false;
        }
    }

    public void s0(long j3) {
        this.f90756m = j3;
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
    public void o0(VH vh5, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p0(VH vh5, int i3) {
    }

    protected void j0(VH vh5, int i3, @NonNull List<Object> list) {
    }
}
