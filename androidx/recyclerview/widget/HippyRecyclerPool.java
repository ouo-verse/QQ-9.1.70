package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.views.hippylist.HippyRecyclerViewHolder;
import com.tencent.mtt.hippy.views.hippylist.NodePositionHelper;
import java.util.Iterator;

/* loaded from: classes.dex */
public class HippyRecyclerPool extends RecyclerView.RecycledViewPool {

    /* renamed from: a, reason: collision with root package name */
    private final View f26505a;

    /* renamed from: b, reason: collision with root package name */
    private final HippyRecyclerExtension f26506b;

    /* renamed from: c, reason: collision with root package name */
    private final HippyEngineContext f26507c;

    /* renamed from: d, reason: collision with root package name */
    private final NodePositionHelper f26508d;

    /* renamed from: e, reason: collision with root package name */
    private IHippyViewAboundListener f26509e;

    public HippyRecyclerPool(HippyEngineContext hippyEngineContext, View view, HippyRecyclerExtension hippyRecyclerExtension, NodePositionHelper nodePositionHelper) {
        this.f26508d = nodePositionHelper;
        this.f26507c = hippyEngineContext;
        this.f26505a = view;
        this.f26506b = hippyRecyclerExtension;
    }

    private void a(RecyclerView.ViewHolder viewHolder) {
        RecyclerView.RecycledViewPool.ScrapData scrapData = this.mScrap.get(viewHolder.getItemViewType());
        if (scrapData == null || scrapData.mScrapHeap.size() < scrapData.mMaxScrap) {
            return;
        }
        this.f26509e.onViewAbound((HippyRecyclerViewHolder) viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    public RecyclerView.ViewHolder getRecycledView(int i3) {
        RecyclerView.ViewHolder viewHolder;
        RecyclerView.RecycledViewPool.ScrapData scrapData = this.mScrap.get(i3);
        if (scrapData == null) {
            return null;
        }
        Iterator<RecyclerView.ViewHolder> it = scrapData.mScrapHeap.iterator();
        while (true) {
            if (it.hasNext()) {
                viewHolder = it.next();
                if (a((HippyRecyclerViewHolder) viewHolder)) {
                    scrapData.mScrapHeap.remove(viewHolder);
                    break;
                }
            } else {
                viewHolder = null;
                break;
            }
        }
        if (viewHolder == null) {
            viewHolder = super.getRecycledView(i3);
        }
        if ((viewHolder instanceof HippyRecyclerViewHolder) && ((HippyRecyclerViewHolder) viewHolder).isRenderDeleted()) {
            return null;
        }
        return viewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    public void putRecycledView(RecyclerView.ViewHolder viewHolder) {
        a(viewHolder);
        super.putRecycledView(viewHolder);
    }

    public void setViewAboundListener(IHippyViewAboundListener iHippyViewAboundListener) {
        this.f26509e = iHippyViewAboundListener;
    }

    private boolean a(HippyRecyclerViewHolder hippyRecyclerViewHolder) {
        if (hippyRecyclerViewHolder.bindNode == null) {
            return false;
        }
        return hippyRecyclerViewHolder.bindNode.equals(this.f26507c.getRenderManager().getRenderNode(this.f26505a.getId()).getChildAt(this.f26508d.getRenderNodePosition(this.f26506b.getCurrentPosition())));
    }
}
