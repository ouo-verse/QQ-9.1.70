package com.tencent.richframework.gallery.bean;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "Ljava/io/Serializable;", "()V", "mediaSum", "", "getMediaSum", "()I", "setMediaSum", "(I)V", "positionOffset", "getPositionOffset", "setPositionOffset", "richMediaDataList", "", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "getRichMediaDataList", "()Ljava/util/List;", "setRichMediaDataList", "(Ljava/util/List;)V", "selectedItemMedia", "getSelectedItemMedia", "()Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "selectedPosition", "getSelectedPosition", "setSelectedPosition", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public class RFWLayerState implements Serializable {
    private int mediaSum;
    private int positionOffset;

    @Nullable
    private List<? extends RFWLayerItemMediaInfo> richMediaDataList;
    private int selectedPosition;

    public final int getMediaSum() {
        return this.mediaSum;
    }

    public final int getPositionOffset() {
        return this.positionOffset;
    }

    @Nullable
    public final List<RFWLayerItemMediaInfo> getRichMediaDataList() {
        return this.richMediaDataList;
    }

    @Nullable
    public final RFWLayerItemMediaInfo getSelectedItemMedia() {
        List<? extends RFWLayerItemMediaInfo> list;
        int i3 = this.selectedPosition;
        if (i3 >= 0 && (list = this.richMediaDataList) != null) {
            Intrinsics.checkNotNull(list);
            if (i3 < list.size()) {
                List<? extends RFWLayerItemMediaInfo> list2 = this.richMediaDataList;
                Intrinsics.checkNotNull(list2);
                return list2.get(this.selectedPosition);
            }
        }
        return null;
    }

    public final int getSelectedPosition() {
        return this.selectedPosition;
    }

    public final void setMediaSum(int i3) {
        this.mediaSum = i3;
    }

    public final void setPositionOffset(int i3) {
        this.positionOffset = i3;
    }

    public final void setRichMediaDataList(@Nullable List<? extends RFWLayerItemMediaInfo> list) {
        this.richMediaDataList = list;
    }

    public final void setSelectedPosition(int i3) {
        this.selectedPosition = i3;
    }
}
