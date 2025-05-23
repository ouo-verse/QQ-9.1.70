package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.uimanager.ListItemRenderNode;
import com.tencent.mtt.hippy.views.hippylist.HippyRecyclerViewHolder;
import com.tencent.mtt.hippy.views.hippylist.NodePositionHelper;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes.dex */
public class HippyRecyclerExtension extends RecyclerView.ViewCacheExtension {

    /* renamed from: a, reason: collision with root package name */
    private final HippyEngineContext f26501a;

    /* renamed from: b, reason: collision with root package name */
    private final NodePositionHelper f26502b;

    /* renamed from: c, reason: collision with root package name */
    private HippyRecyclerViewBase f26503c;

    /* renamed from: d, reason: collision with root package name */
    private int f26504d;

    public HippyRecyclerExtension(HippyRecyclerViewBase hippyRecyclerViewBase, HippyEngineContext hippyEngineContext, NodePositionHelper nodePositionHelper) {
        this.f26502b = nodePositionHelper;
        this.f26503c = hippyRecyclerViewBase;
        this.f26501a = hippyEngineContext;
    }

    private View a(RecyclerView.Recycler recycler, int i3, int i16) {
        RecyclerView.ViewHolder a16 = a(recycler.mCachedViews, i3, i16);
        if (a16 == null) {
            return null;
        }
        recycler.mCachedViews.remove(a16);
        return a16.itemView;
    }

    public static boolean isNodeEquals(ListItemRenderNode listItemRenderNode, ListItemRenderNode listItemRenderNode2) {
        if (listItemRenderNode != null && listItemRenderNode2 != null) {
            return listItemRenderNode.equals(listItemRenderNode2);
        }
        return false;
    }

    protected View findInAttachedScrap(RecyclerView.Recycler recycler, int i3, int i16) {
        RecyclerView.ViewHolder a16 = a(recycler.mAttachedScrap, i3, i16);
        if (a16 != null) {
            a16.unScrap();
            return a16.itemView;
        }
        return null;
    }

    public int getCurrentPosition() {
        return this.f26504d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ViewCacheExtension
    public View getViewForPositionAndType(RecyclerView.Recycler recycler, int i3, int i16) {
        this.f26504d = i3;
        View findInAttachedScrap = findInAttachedScrap(recycler, i3, i16);
        if (findInAttachedScrap == null) {
            return a(recycler, i3, i16);
        }
        return findInAttachedScrap;
    }

    protected boolean isTheBestHolder(int i3, int i16, RecyclerView.ViewHolder viewHolder) {
        if (viewHolder.getAdapterPosition() != i3 || viewHolder.isInvalid() || viewHolder.isRemoved() || viewHolder.getItemViewType() != i16 || !(viewHolder instanceof HippyRecyclerViewHolder)) {
            return false;
        }
        return isNodeEquals(((HippyRecyclerViewHolder) viewHolder).bindNode, (ListItemRenderNode) this.f26501a.getRenderManager().getRenderNode(this.f26503c.getId()).getChildAt(this.f26502b.getRenderNodePosition(i3)));
    }

    private RecyclerView.ViewHolder a(ArrayList<RecyclerView.ViewHolder> arrayList, int i3, int i16) {
        int size = arrayList.size();
        for (int i17 = 0; i17 < size; i17++) {
            RecyclerView.ViewHolder viewHolder = arrayList.get(i17);
            if (isTheBestHolder(i3, i16, viewHolder)) {
                return viewHolder;
            }
        }
        return null;
    }
}
