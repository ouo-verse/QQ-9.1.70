package com.tencent.richframework.gallery.datacenter.converter;

import com.tencent.richframework.data.idata.IDataConverter;
import com.tencent.richframework.gallery.bean.RFWLayerPicLoadState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/richframework/gallery/datacenter/converter/PicLoadStateConverter;", "Lcom/tencent/richframework/data/idata/IDataConverter;", "Lcom/tencent/richframework/gallery/bean/RFWLayerPicLoadState;", "()V", "cloneConvertData", "rfwLayerPicLoadState", "getObserverKey", "", "update", "", "oldObj", "latestObj", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class PicLoadStateConverter implements IDataConverter<RFWLayerPicLoadState> {
    @Override // com.tencent.richframework.data.idata.IDataConverter
    @NotNull
    public RFWLayerPicLoadState cloneConvertData(@NotNull RFWLayerPicLoadState rfwLayerPicLoadState) {
        Intrinsics.checkNotNullParameter(rfwLayerPicLoadState, "rfwLayerPicLoadState");
        return rfwLayerPicLoadState;
    }

    @Override // com.tencent.richframework.data.idata.IDataConverter
    @NotNull
    public String getObserverKey(@NotNull RFWLayerPicLoadState rfwLayerPicLoadState) {
        Intrinsics.checkNotNullParameter(rfwLayerPicLoadState, "rfwLayerPicLoadState");
        return rfwLayerPicLoadState.getPicId();
    }

    @Override // com.tencent.richframework.data.idata.IDataConverter
    public void update(@NotNull RFWLayerPicLoadState oldObj, @NotNull RFWLayerPicLoadState latestObj) {
        Intrinsics.checkNotNullParameter(oldObj, "oldObj");
        Intrinsics.checkNotNullParameter(latestObj, "latestObj");
        oldObj.setSelectedPicInfo(latestObj.getSelectedPicInfo());
        oldObj.setPicLoadState(latestObj.getPicLoadState());
    }
}
