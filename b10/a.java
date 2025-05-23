package b10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi.recommend.holder.c;
import com.tencent.mobileqq.R;
import com.tencent.widget.pull2refresh.BaseAdapter;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import mz.h;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a extends BaseAdapter<h, c> {

    /* renamed from: d, reason: collision with root package name */
    private InterfaceC0084a f27662d;

    /* compiled from: P */
    /* renamed from: b10.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public interface InterfaceC0084a {
        void a(BaseViewHolder<h> baseViewHolder);
    }

    public a(Context context) {
        super(context);
    }

    @Override // com.tencent.widget.pull2refresh.BaseAdapter
    public int getCustomItemViewType(int i3) {
        return 0;
    }

    @Override // com.tencent.widget.pull2refresh.HeaderAndFooterAdapter
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void onBindCustomViewHolder(c cVar, int i3) {
        cVar.bindData(getDataList().get(i3));
    }

    @Override // com.tencent.widget.pull2refresh.HeaderAndFooterAdapter
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public c onCreateCustomViewHolder(ViewGroup viewGroup, int i3) {
        return new c(LayoutInflater.from(this.context).inflate(R.layout.fvz, viewGroup, false));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(BaseViewHolder<h> baseViewHolder) {
        super.onViewAttachedToWindow(baseViewHolder);
        InterfaceC0084a interfaceC0084a = this.f27662d;
        if (interfaceC0084a != null) {
            interfaceC0084a.a(baseViewHolder);
        }
    }

    public void s(InterfaceC0084a interfaceC0084a) {
        this.f27662d = interfaceC0084a;
    }
}
