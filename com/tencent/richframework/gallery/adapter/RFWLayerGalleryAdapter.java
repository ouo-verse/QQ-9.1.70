package com.tencent.richframework.gallery.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import com.tencent.mobileqq.R;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/richframework/gallery/adapter/RFWLayerGalleryAdapter;", "Lcom/tencent/richframework/gallery/adapter/RFWBaseLayerAdapter;", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "delegatesManager", "Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;", "", "(Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;)V", "getCurrentImageView", "Landroid/widget/ImageView;", "position", "", "getItemId", "", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class RFWLayerGalleryAdapter extends RFWBaseLayerAdapter<RFWLayerItemMediaInfo> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RFWLayerGalleryAdapter(@NotNull AdapterDelegatesManager<List<RFWLayerItemMediaInfo>> delegatesManager) {
        super(delegatesManager);
        Intrinsics.checkNotNullParameter(delegatesManager, "delegatesManager");
    }

    @Nullable
    public final ImageView getCurrentImageView(int position) {
        RecyclerView.LayoutManager layoutManager;
        RecyclerView recyclerView;
        RecyclerView.LayoutManager layoutManager2;
        View findViewByPosition;
        if (getRecyclerView() != null) {
            RecyclerView recyclerView2 = getRecyclerView();
            if (recyclerView2 != null) {
                layoutManager = recyclerView2.getLayoutManager();
            } else {
                layoutManager = null;
            }
            if (layoutManager != null && (recyclerView = getRecyclerView()) != null && (layoutManager2 = recyclerView.getLayoutManager()) != null && (findViewByPosition = layoutManager2.findViewByPosition(position)) != null) {
                Intrinsics.checkNotNullExpressionValue(findViewByPosition, "recyclerView?.layoutMana\u2026n(position)?: return null");
                RFWLog.i("RFWLayerPagePart", RFWLog.USR, "currentPos:" + position + "itemView:" + findViewByPosition);
                ImageView imageView = (ImageView) findViewByPosition.findViewById(R.id.f73983v1);
                if (imageView == null) {
                    return (ImageView) findViewByPosition.findViewById(R.id.f74033v6);
                }
                return imageView;
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        if (getItems().size() <= position) {
            return position;
        }
        String mediaId = getItems().get(position).getMediaId();
        if (!TextUtils.isEmpty(mediaId)) {
            if (mediaId != null) {
                position = mediaId.hashCode();
            } else {
                position = 0;
            }
        }
        return position;
    }
}
