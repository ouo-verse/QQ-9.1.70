package oz;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi.drama.WSDramaPageFragment;
import com.tencent.widget.pull2refresh.BaseAdapter;
import com.tencent.widget.pull2refresh.BaseViewHolder;

/* compiled from: P */
/* loaded from: classes33.dex */
public class a extends BaseAdapter<c, e> {

    /* renamed from: d, reason: collision with root package name */
    private WSDramaPageFragment f424525d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f424526e;

    public a(Context context, WSDramaPageFragment wSDramaPageFragment) {
        super(context);
        this.f424526e = true;
        this.f424525d = wSDramaPageFragment;
    }

    @Override // com.tencent.widget.pull2refresh.BaseAdapter
    public int getCustomItemViewType(int i3) {
        return 0;
    }

    @Override // com.tencent.widget.pull2refresh.HeaderAndFooterAdapter
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void onBindCustomViewHolder(e eVar, int i3) {
        eVar.bindData(getDataList().get(i3));
    }

    @Override // com.tencent.widget.pull2refresh.HeaderAndFooterAdapter
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public e onCreateCustomViewHolder(ViewGroup viewGroup, int i3) {
        return new e(viewGroup, this.f424525d);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(BaseViewHolder<c> baseViewHolder) {
        super.onViewAttachedToWindow(baseViewHolder);
        if (this.f424526e) {
            return;
        }
        pz.a Bd = this.f424525d.Bd();
        tz.a.i(vz.a.f(Bd), vz.a.g(Bd), vz.a.d(Bd), vz.a.c(Bd), getDataList().get(baseViewHolder.getAdapterPosition()), this.f424525d.getFrom(), baseViewHolder.getAdapterPosition());
    }

    public void s(boolean z16) {
        this.f424526e = z16;
    }
}
