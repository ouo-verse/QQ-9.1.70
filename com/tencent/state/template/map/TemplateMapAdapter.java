package com.tencent.state.template.map;

import android.view.ViewGroup;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.map.MapAdapter;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.template.item.TemplateAvatarItem;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J \u0010\b\u001a\n\u0012\u0002\b\u00030\tj\u0002`\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u001c\u0010\u0012\u001a\u00020\u000e2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J \u0010\u0016\u001a\n\u0012\u0002\b\u00030\tj\u0002`\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0004H\u0016R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/state/template/map/TemplateMapAdapter;", "Lcom/tencent/state/map/MapAdapter;", "dataList", "", "Lcom/tencent/state/map/MapItem;", "(Ljava/util/List;)V", "getDataList", "()Ljava/util/List;", "doOnCreateViewHolder", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/map/ViewHolder;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "getItemData", "index", "indexOf", "block", "Lkotlin/Function1;", "", "onCreateViewHolder", "setItemData", "", "data", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class TemplateMapAdapter extends MapAdapter {
    private static final String TAG = "LibraryMapAdapter";
    private final List<MapItem> dataList;

    public TemplateMapAdapter(List<MapItem> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        this.dataList = dataList;
        Iterator<MapItem> it = dataList.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            }
            MapItem next = it.next();
            if ((next instanceof TemplateAvatarItem) && ((TemplateAvatarItem) next).getUser().isMe()) {
                break;
            } else {
                i3++;
            }
        }
        setMeIndex(i3);
    }

    public abstract MapViewHolder<?> doOnCreateViewHolder(ViewGroup parent, int viewType);

    protected final List<MapItem> getDataList() {
        return this.dataList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.dataList.size();
    }

    @Override // com.tencent.state.map.MapAdapter
    public MapItem getItemData(int index) {
        Object orNull;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.dataList, index);
        return (MapItem) orNull;
    }

    @Override // com.tencent.state.map.IMapDataIndexer
    public int indexOf(Function1<? super MapItem, Boolean> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Iterator<MapItem> it = this.dataList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (block.invoke(it.next()).booleanValue()) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    @Override // com.tencent.state.map.MapAdapter
    public void setItemData(int index, MapItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (index == getMeIndex()) {
            SquareBaseKt.getSquareLog().i(TAG, "update meIndex=-1");
            setMeIndex(-1);
        }
        this.dataList.set(index, data);
        if ((data instanceof TemplateAvatarItem) && ((TemplateAvatarItem) data).getUser().isMe()) {
            setMeIndex(index);
            SquareBaseKt.getSquareLog().i(TAG, "update meIndex=" + index);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MapViewHolder<?> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return doOnCreateViewHolder(parent, viewType);
    }
}
