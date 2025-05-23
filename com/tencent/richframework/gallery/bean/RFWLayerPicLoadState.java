package com.tencent.richframework.gallery.bean;

import com.tencent.libra.LoadState;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/richframework/gallery/bean/RFWLayerPicLoadState;", "", "", "picId", "Ljava/lang/String;", "getPicId", "()Ljava/lang/String;", "setPicId", "(Ljava/lang/String;)V", "Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo$RFWPicInfo;", "selectedPicInfo", "Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo$RFWPicInfo;", "getSelectedPicInfo", "()Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo$RFWPicInfo;", "setSelectedPicInfo", "(Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo$RFWPicInfo;)V", "Lcom/tencent/libra/LoadState;", "picLoadState", "Lcom/tencent/libra/LoadState;", "getPicLoadState", "()Lcom/tencent/libra/LoadState;", "setPicLoadState", "(Lcom/tencent/libra/LoadState;)V", "<init>", "(Ljava/lang/String;Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo$RFWPicInfo;Lcom/tencent/libra/LoadState;)V", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class RFWLayerPicLoadState {

    @NotNull
    private String picId;

    @NotNull
    private LoadState picLoadState;

    @NotNull
    private RFWLayerPicInfo.RFWPicInfo selectedPicInfo;

    public RFWLayerPicLoadState(@NotNull String picId, @NotNull RFWLayerPicInfo.RFWPicInfo selectedPicInfo, @NotNull LoadState picLoadState) {
        Intrinsics.checkNotNullParameter(picId, "picId");
        Intrinsics.checkNotNullParameter(selectedPicInfo, "selectedPicInfo");
        Intrinsics.checkNotNullParameter(picLoadState, "picLoadState");
        this.picId = picId;
        this.selectedPicInfo = selectedPicInfo;
        this.picLoadState = picLoadState;
    }

    @NotNull
    public final String getPicId() {
        return this.picId;
    }

    @NotNull
    public final LoadState getPicLoadState() {
        return this.picLoadState;
    }

    @NotNull
    public final RFWLayerPicInfo.RFWPicInfo getSelectedPicInfo() {
        return this.selectedPicInfo;
    }

    public final void setPicLoadState(@NotNull LoadState loadState) {
        Intrinsics.checkNotNullParameter(loadState, "<set-?>");
        this.picLoadState = loadState;
    }

    public final void setSelectedPicInfo(@NotNull RFWLayerPicInfo.RFWPicInfo rFWPicInfo) {
        Intrinsics.checkNotNullParameter(rFWPicInfo, "<set-?>");
        this.selectedPicInfo = rFWPicInfo;
    }
}
