package h10;

import UserGrowth.stFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi.f;
import com.tencent.biz.pubaccount.weishi.util.r;
import com.tencent.mobileqq.R;
import com.tencent.open.base.ToastUtil;
import com.tencent.widget.pull2refresh.BaseAdapter;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import java.util.List;
import jz.g;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c extends BaseAdapter<stSimpleMetaPerson, BaseViewHolder<stSimpleMetaPerson>> implements e {

    /* renamed from: d, reason: collision with root package name */
    private f f404060d;

    /* renamed from: e, reason: collision with root package name */
    private stFeed f404061e;

    public c(Context context, f fVar) {
        super(context);
        this.f404060d = fVar;
    }

    @Override // com.tencent.widget.pull2refresh.BaseAdapter
    public int getCustomItemViewType(int i3) {
        return 0;
    }

    @Override // h10.e
    public void j(stSimpleMetaPerson stsimplemetaperson) {
        g.e().b(stsimplemetaperson.f25130id);
        removeItem((c) stsimplemetaperson);
        List<stSimpleMetaPerson> dataList = getDataList();
        if (dataList == null || dataList.size() == 0) {
            this.f404060d.removeItem((f) this.f404061e);
        }
        ToastUtil.a().b(R.string.f241807sv);
    }

    @Override // h10.e
    public void o(stSimpleMetaPerson stsimplemetaperson) {
        r.A(this.f404060d.p(), stsimplemetaperson.avatarSchema, 702, stsimplemetaperson);
    }

    @Override // com.tencent.widget.pull2refresh.HeaderAndFooterAdapter
    public void onBindCustomViewHolder(BaseViewHolder<stSimpleMetaPerson> baseViewHolder, int i3) {
        stSimpleMetaPerson item = getItem(i3);
        if (item != null && (baseViewHolder instanceof d)) {
            ((d) baseViewHolder).h(item, i3);
        }
    }

    @Override // com.tencent.widget.pull2refresh.HeaderAndFooterAdapter
    public BaseViewHolder<stSimpleMetaPerson> onCreateCustomViewHolder(ViewGroup viewGroup, int i3) {
        return d.j(viewGroup, this);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(BaseViewHolder<stSimpleMetaPerson> baseViewHolder) {
        f fVar;
        super.onViewAttachedToWindow(baseViewHolder);
        if ((baseViewHolder instanceof d) && (fVar = this.f404060d) != null && fVar.s().getUserVisibleHint()) {
            ((d) baseViewHolder).o();
        }
    }

    public void q(stFeed stfeed) {
        this.f404061e = stfeed;
    }
}
