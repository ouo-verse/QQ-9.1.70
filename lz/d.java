package lz;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.widget.pull2refresh.BaseAdapter;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import lz.a;

/* compiled from: P */
/* loaded from: classes38.dex */
public abstract class d<M extends a, VH extends BaseViewHolder<M>> extends BaseAdapter<M, VH> implements b<M> {

    /* renamed from: d, reason: collision with root package name */
    protected int f415798d;

    /* renamed from: e, reason: collision with root package name */
    private final RecyclerView f415799e;

    /* renamed from: f, reason: collision with root package name */
    private b<M> f415800f;

    /* renamed from: h, reason: collision with root package name */
    private nz.a f415801h;

    public d(Context context, RecyclerView recyclerView) {
        super(context);
        this.f415798d = 0;
        this.f415799e = recyclerView;
    }

    private void u(int i3, boolean z16) {
        v(i3, z16);
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.f415799e.findViewHolderForAdapterPosition(i3);
        x.i("WSAbsSingleCheckAdapter-nel-log", "position:" + i3 + ", viewHolder:" + findViewHolderForAdapterPosition);
        if (findViewHolderForAdapterPosition == null) {
            notifyItemChanged(i3);
        } else if (findViewHolderForAdapterPosition instanceof c) {
            ((c) findViewHolderForAdapterPosition).b(z16);
        }
    }

    @Override // lz.b
    public void i(M m3, int i3) {
        b<M> bVar = this.f415800f;
        if (bVar != null) {
            bVar.i(m3, i3);
        }
    }

    @Override // lz.b
    public void l(M m3, int i3) {
        if (m3.isChecked()) {
            i(m3, i3);
            return;
        }
        r(i3);
        b<M> bVar = this.f415800f;
        if (bVar != null) {
            bVar.l(m3, i3);
        }
    }

    public int p() {
        return this.f415798d;
    }

    public nz.a q() {
        return this.f415801h;
    }

    public void r(int i3) {
        int i16 = this.f415798d;
        if (i16 == i3) {
            return;
        }
        u(i16, false);
        this.f415798d = i3;
        u(i3, true);
    }

    public void s(nz.a aVar) {
        this.f415801h = aVar;
    }

    public void t(b<M> bVar) {
        this.f415800f = bVar;
    }

    protected void v(int i3, boolean z16) {
        ((a) getDataList().get(i3)).setChecked(z16);
    }
}
