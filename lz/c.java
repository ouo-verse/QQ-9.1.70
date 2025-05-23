package lz;

import android.view.ViewGroup;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import lz.a;

/* compiled from: P */
/* loaded from: classes38.dex */
public abstract class c<M extends a> extends BaseViewHolder<M> {

    /* renamed from: d, reason: collision with root package name */
    protected b<M> f415796d;

    /* renamed from: e, reason: collision with root package name */
    private M f415797e;

    public c(ViewGroup viewGroup, int i3, b<M> bVar) {
        super(viewGroup, i3);
        this.f415796d = bVar;
    }

    private void f(M m3) {
        this.f415797e = m3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void b(boolean z16);

    @Override // com.tencent.widget.pull2refresh.BaseViewHolder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void bindData(M m3) {
        super.bindData(m3);
        f(m3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public M d() {
        return this.f415797e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        b<M> bVar = this.f415796d;
        if (bVar != null) {
            bVar.l(this.f415797e, getAdapterPosition());
        }
    }
}
