package com.tencent.tavcut.core.render.builder.light.model.pag;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u00c6\u0003J9\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/tavcut/core/render/builder/light/model/pag/ImageLayerData;", "", "layerIndex", "", "layerName", "", "layerType", "layerMarkList", "", "Lcom/tencent/tavcut/core/render/builder/light/model/pag/LayerMarkData;", "(ILjava/lang/String;ILjava/util/List;)V", "getLayerIndex", "()I", "getLayerMarkList", "()Ljava/util/List;", "getLayerName", "()Ljava/lang/String;", "getLayerType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final /* data */ class ImageLayerData {
    private final int layerIndex;

    @NotNull
    private final List<LayerMarkData> layerMarkList;

    @Nullable
    private final String layerName;
    private final int layerType;

    public ImageLayerData(int i3, @Nullable String str, int i16, @NotNull List<LayerMarkData> layerMarkList) {
        Intrinsics.checkParameterIsNotNull(layerMarkList, "layerMarkList");
        this.layerIndex = i3;
        this.layerName = str;
        this.layerType = i16;
        this.layerMarkList = layerMarkList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ImageLayerData copy$default(ImageLayerData imageLayerData, int i3, String str, int i16, List list, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = imageLayerData.layerIndex;
        }
        if ((i17 & 2) != 0) {
            str = imageLayerData.layerName;
        }
        if ((i17 & 4) != 0) {
            i16 = imageLayerData.layerType;
        }
        if ((i17 & 8) != 0) {
            list = imageLayerData.layerMarkList;
        }
        return imageLayerData.copy(i3, str, i16, list);
    }

    /* renamed from: component1, reason: from getter */
    public final int getLayerIndex() {
        return this.layerIndex;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getLayerName() {
        return this.layerName;
    }

    /* renamed from: component3, reason: from getter */
    public final int getLayerType() {
        return this.layerType;
    }

    @NotNull
    public final List<LayerMarkData> component4() {
        return this.layerMarkList;
    }

    @NotNull
    public final ImageLayerData copy(int layerIndex, @Nullable String layerName, int layerType, @NotNull List<LayerMarkData> layerMarkList) {
        Intrinsics.checkParameterIsNotNull(layerMarkList, "layerMarkList");
        return new ImageLayerData(layerIndex, layerName, layerType, layerMarkList);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ImageLayerData) {
                ImageLayerData imageLayerData = (ImageLayerData) other;
                if (this.layerIndex != imageLayerData.layerIndex || !Intrinsics.areEqual(this.layerName, imageLayerData.layerName) || this.layerType != imageLayerData.layerType || !Intrinsics.areEqual(this.layerMarkList, imageLayerData.layerMarkList)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final int getLayerIndex() {
        return this.layerIndex;
    }

    @NotNull
    public final List<LayerMarkData> getLayerMarkList() {
        return this.layerMarkList;
    }

    @Nullable
    public final String getLayerName() {
        return this.layerName;
    }

    public final int getLayerType() {
        return this.layerType;
    }

    public int hashCode() {
        int i3;
        int i16 = this.layerIndex * 31;
        String str = this.layerName;
        int i17 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = (((i16 + i3) * 31) + this.layerType) * 31;
        List<LayerMarkData> list = this.layerMarkList;
        if (list != null) {
            i17 = list.hashCode();
        }
        return i18 + i17;
    }

    @NotNull
    public String toString() {
        return "ImageLayerData(layerIndex=" + this.layerIndex + ", layerName=" + this.layerName + ", layerType=" + this.layerType + ", layerMarkList=" + this.layerMarkList + ")";
    }

    public /* synthetic */ ImageLayerData(int i3, String str, int i16, List list, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i17 & 2) != 0 ? null : str, i16, (i17 & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }
}
