package androidx.recyclerview.widget;

import android.util.SparseArray;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mtt.hippy.uimanager.ListItemRenderNode;
import com.tencent.mtt.hippy.views.hippylist.HippyRecyclerViewHolder;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes.dex */
public class HippyItemTypeHelper {

    /* renamed from: a, reason: collision with root package name */
    HippyRecyclerViewBase f26484a;

    /* renamed from: b, reason: collision with root package name */
    private RecyclerView.Recycler f26485b;

    public HippyItemTypeHelper(HippyRecyclerViewBase hippyRecyclerViewBase) {
        this.f26484a = hippyRecyclerViewBase;
        this.f26485b = hippyRecyclerViewBase.mRecycler;
    }

    private void a(int i3, int i16, ListItemRenderNode listItemRenderNode) {
        RecyclerView.RecycledViewPool.ScrapData scrapData;
        if (this.f26485b.getRecycledViewPool() == null || (scrapData = this.f26485b.getRecycledViewPool().mScrap.get(i3)) == null || scrapData.mScrapHeap.isEmpty()) {
            return;
        }
        Iterator<RecyclerView.ViewHolder> it = scrapData.mScrapHeap.iterator();
        while (it.hasNext()) {
            RecyclerView.ViewHolder next = it.next();
            if (a(i3, i16, listItemRenderNode, next)) {
                scrapData.mScrapHeap.remove(next);
                a(i16, next);
                return;
            }
        }
    }

    public void updateItemType(int i3, int i16, ListItemRenderNode listItemRenderNode) {
        int childCount = this.f26484a.getChildCount();
        for (int i17 = 0; i17 < childCount; i17++) {
            HippyRecyclerViewBase hippyRecyclerViewBase = this.f26484a;
            if (a(i3, i16, listItemRenderNode, hippyRecyclerViewBase.getChildViewHolder(hippyRecyclerViewBase.getChildAt(i17)))) {
                return;
            }
        }
        if (a(i3, i16, listItemRenderNode, this.f26485b.mAttachedScrap) || a(i3, i16, listItemRenderNode, this.f26484a.mRecycler.mCachedViews)) {
            return;
        }
        a(i3, i16, listItemRenderNode);
    }

    private void a(int i3, RecyclerView.ViewHolder viewHolder) {
        viewHolder.mItemViewType = i3;
        SparseArray<RecyclerView.RecycledViewPool.ScrapData> sparseArray = this.f26485b.getRecycledViewPool().mScrap;
        RecyclerView.RecycledViewPool.ScrapData scrapData = sparseArray.get(i3);
        if (scrapData == null) {
            scrapData = new RecyclerView.RecycledViewPool.ScrapData();
            sparseArray.append(i3, scrapData);
        }
        scrapData.mScrapHeap.add(viewHolder);
    }

    private boolean a(int i3, int i16, ListItemRenderNode listItemRenderNode, RecyclerView.ViewHolder viewHolder) {
        if (viewHolder.getItemViewType() != i3 || !(viewHolder instanceof HippyRecyclerViewHolder) || ((HippyRecyclerViewHolder) viewHolder).bindNode != listItemRenderNode) {
            return false;
        }
        viewHolder.mItemViewType = i16;
        return true;
    }

    private boolean a(int i3, int i16, ListItemRenderNode listItemRenderNode, ArrayList<RecyclerView.ViewHolder> arrayList) {
        int size = arrayList.size();
        for (int i17 = 0; i17 < size; i17++) {
            if (a(i3, i16, listItemRenderNode, arrayList.get(i17))) {
                return true;
            }
        }
        return false;
    }
}
