package h10;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi.f;
import com.tencent.widget.pull2refresh.BaseAdapter;
import com.tencent.widget.pull2refresh.BaseViewHolder;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends BaseAdapter<a00.b, BaseViewHolder<a00.b>> {

    /* renamed from: d, reason: collision with root package name */
    private f f404049d;

    public a(Context context, f fVar) {
        super(context);
        this.f404049d = fVar;
    }

    @Override // com.tencent.widget.pull2refresh.BaseAdapter
    public int getCustomItemViewType(int i3) {
        return 0;
    }

    @Override // com.tencent.widget.pull2refresh.HeaderAndFooterAdapter
    public void onBindCustomViewHolder(BaseViewHolder<a00.b> baseViewHolder, int i3) {
        a00.b item = getItem(i3);
        if (item != null && (baseViewHolder instanceof b)) {
            ((b) baseViewHolder).l(item, i3);
        }
    }

    @Override // com.tencent.widget.pull2refresh.HeaderAndFooterAdapter
    public BaseViewHolder<a00.b> onCreateCustomViewHolder(ViewGroup viewGroup, int i3) {
        return b.n(viewGroup, this);
    }

    public Activity p() {
        f fVar = this.f404049d;
        if (fVar != null) {
            return fVar.p();
        }
        return null;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(BaseViewHolder<a00.b> baseViewHolder) {
        f fVar;
        super.onViewAttachedToWindow(baseViewHolder);
        boolean z16 = baseViewHolder instanceof b;
        if (z16 && (fVar = this.f404049d) != null && fVar.s().getUserVisibleHint() && this.f404049d.s().isResumed()) {
            ((b) baseViewHolder).t();
        }
        if (z16) {
            ((b) baseViewHolder).r();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(BaseViewHolder<a00.b> baseViewHolder) {
        super.onViewDetachedFromWindow(baseViewHolder);
        baseViewHolder.onViewDetachedFromWindow();
    }
}
