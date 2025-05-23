package com.tencent.state.library;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.library.holder.LibraryAvatarViewHolder;
import com.tencent.state.library.holder.LibraryImageViewHolder;
import com.tencent.state.library.holder.LibraryTableViewHolder;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.square.databinding.VasSquareItemLibraryAvatarBinding;
import com.tencent.state.square.databinding.VasSquareItemLibraryImageBinding;
import com.tencent.state.square.databinding.VasSquareItemLibraryTableBinding;
import com.tencent.state.template.map.TemplateMapAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J \u0010\u0006\u001a\n\u0012\u0002\b\u00030\u0007j\u0002`\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/library/LibraryMapAdapter;", "Lcom/tencent/state/template/map/TemplateMapAdapter;", "dataList", "", "Lcom/tencent/state/map/MapItem;", "(Ljava/util/List;)V", "doOnCreateViewHolder", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/map/ViewHolder;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "viewType", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibraryMapAdapter extends TemplateMapAdapter {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LibraryMapAdapter(List<MapItem> dataList) {
        super(dataList);
        Intrinsics.checkNotNullParameter(dataList, "dataList");
    }

    @Override // com.tencent.state.template.map.TemplateMapAdapter
    public MapViewHolder<?> doOnCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            VasSquareItemLibraryAvatarBinding inflate = VasSquareItemLibraryAvatarBinding.inflate(LayoutInflater.from(parent.getContext()));
            Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareItemLibraryAvat\u2026ontext)\n                )");
            return new LibraryAvatarViewHolder(inflate);
        }
        if (viewType == 2) {
            VasSquareItemLibraryTableBinding inflate2 = VasSquareItemLibraryTableBinding.inflate(LayoutInflater.from(parent.getContext()));
            Intrinsics.checkNotNullExpressionValue(inflate2, "VasSquareItemLibraryTabl\u2026ontext)\n                )");
            return new LibraryTableViewHolder(inflate2);
        }
        if (viewType != 3) {
            VasSquareItemLibraryImageBinding inflate3 = VasSquareItemLibraryImageBinding.inflate(LayoutInflater.from(parent.getContext()));
            Intrinsics.checkNotNullExpressionValue(inflate3, "VasSquareItemLibraryImag\u2026      )\n                )");
            return new LibraryImageViewHolder(inflate3);
        }
        VasSquareItemLibraryImageBinding inflate4 = VasSquareItemLibraryImageBinding.inflate(LayoutInflater.from(parent.getContext()));
        Intrinsics.checkNotNullExpressionValue(inflate4, "VasSquareItemLibraryImag\u2026ontext)\n                )");
        return new LibraryImageViewHolder(inflate4);
    }
}
