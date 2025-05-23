package com.tencent.qcircle.weseevideo.model.template.auto;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR$\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u000e\u00a8\u0006*"}, d2 = {"Lcom/tencent/qcircle/weseevideo/model/template/auto/AEFrameModel;", "", "()V", "frameColor", "", "getFrameColor", "()I", "setFrameColor", "(I)V", "frameColorLayerName", "", "getFrameColorLayerName", "()Ljava/lang/String;", "setFrameColorLayerName", "(Ljava/lang/String;)V", "id", "getId", "setId", "imageFillMode", "getImageFillMode", "setImageFillMode", "imageLayerName", "getImageLayerName", "setImageLayerName", "isEmptyFrame", "", "()Z", "setEmptyFrame", "(Z)V", "pagFillMode", "getPagFillMode", "setPagFillMode", "pagItems", "Ljava/util/ArrayList;", "Lcom/tencent/qcircle/weseevideo/model/template/auto/AEFramePAGItem;", "getPagItems", "()Ljava/util/ArrayList;", "setPagItems", "(Ljava/util/ArrayList;)V", "selectedPAGName", "getSelectedPAGName", "setSelectedPAGName", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final class AEFrameModel {

    @SerializedName("frameColor")
    private int frameColor;

    @SerializedName("imageFillMode")
    private int imageFillMode;

    @SerializedName("isEmptyFrame")
    private boolean isEmptyFrame;

    @SerializedName("pagFillMode")
    private int pagFillMode;

    @SerializedName("id")
    @NotNull
    private String id = "";

    @SerializedName("pagItem")
    @NotNull
    private ArrayList<AEFramePAGItem> pagItems = new ArrayList<>();

    @SerializedName("imageLayerName")
    @NotNull
    private String imageLayerName = "";

    @SerializedName("frameColorLayerName")
    @NotNull
    private String frameColorLayerName = "";

    @NotNull
    private transient String selectedPAGName = "";

    public final int getFrameColor() {
        return this.frameColor;
    }

    @NotNull
    public final String getFrameColorLayerName() {
        return this.frameColorLayerName;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    public final int getImageFillMode() {
        return this.imageFillMode;
    }

    @NotNull
    public final String getImageLayerName() {
        return this.imageLayerName;
    }

    public final int getPagFillMode() {
        return this.pagFillMode;
    }

    @NotNull
    public final ArrayList<AEFramePAGItem> getPagItems() {
        return this.pagItems;
    }

    @NotNull
    public final String getSelectedPAGName() {
        return this.selectedPAGName;
    }

    /* renamed from: isEmptyFrame, reason: from getter */
    public final boolean getIsEmptyFrame() {
        return this.isEmptyFrame;
    }

    public final void setEmptyFrame(boolean z16) {
        this.isEmptyFrame = z16;
    }

    public final void setFrameColor(int i3) {
        this.frameColor = i3;
    }

    public final void setFrameColorLayerName(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.frameColorLayerName = str;
    }

    public final void setId(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.id = str;
    }

    public final void setImageFillMode(int i3) {
        this.imageFillMode = i3;
    }

    public final void setImageLayerName(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.imageLayerName = str;
    }

    public final void setPagFillMode(int i3) {
        this.pagFillMode = i3;
    }

    public final void setPagItems(@NotNull ArrayList<AEFramePAGItem> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
        this.pagItems = arrayList;
    }

    public final void setSelectedPAGName(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.selectedPAGName = str;
    }
}
