package com.tencent.zplan.luabridge.plugins.data;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\nH\u00c6\u0003JQ\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u00c6\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u00d6\u0003J\t\u0010&\u001a\u00020\u0003H\u00d6\u0001J\t\u0010'\u001a\u00020(H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u0015\u00a8\u0006)"}, d2 = {"Lcom/tencent/zplan/luabridge/plugins/data/CommonLoadingData;", "Ljava/io/Serializable;", "progress", "", "totalMode", "currentMode", "currentType", "viewType", WadlProxyConsts.SCENE_ID, "extData", "Lcom/tencent/zplan/luabridge/plugins/data/LoadingExtData;", "(IIIIIILcom/tencent/zplan/luabridge/plugins/data/LoadingExtData;)V", "getCurrentMode", "()I", "getCurrentType", "getExtData", "()Lcom/tencent/zplan/luabridge/plugins/data/LoadingExtData;", "setExtData", "(Lcom/tencent/zplan/luabridge/plugins/data/LoadingExtData;)V", HippyQQPagView.FunctionName.GET_PROGRESS, HippyQQPagView.FunctionName.SET_PROGRESS, "(I)V", "getSceneId", "getTotalMode", "getViewType", "setViewType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "toString", "", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final /* data */ class CommonLoadingData implements Serializable {
    private final int currentMode;
    private final int currentType;

    @Nullable
    private LoadingExtData extData;
    private int progress;
    private final int sceneId;
    private final int totalMode;
    private int viewType;

    public CommonLoadingData() {
        this(0, 0, 0, 0, 0, 0, null, 127, null);
    }

    public static /* synthetic */ CommonLoadingData copy$default(CommonLoadingData commonLoadingData, int i3, int i16, int i17, int i18, int i19, int i26, LoadingExtData loadingExtData, int i27, Object obj) {
        if ((i27 & 1) != 0) {
            i3 = commonLoadingData.progress;
        }
        if ((i27 & 2) != 0) {
            i16 = commonLoadingData.totalMode;
        }
        int i28 = i16;
        if ((i27 & 4) != 0) {
            i17 = commonLoadingData.currentMode;
        }
        int i29 = i17;
        if ((i27 & 8) != 0) {
            i18 = commonLoadingData.currentType;
        }
        int i36 = i18;
        if ((i27 & 16) != 0) {
            i19 = commonLoadingData.viewType;
        }
        int i37 = i19;
        if ((i27 & 32) != 0) {
            i26 = commonLoadingData.sceneId;
        }
        int i38 = i26;
        if ((i27 & 64) != 0) {
            loadingExtData = commonLoadingData.extData;
        }
        return commonLoadingData.copy(i3, i28, i29, i36, i37, i38, loadingExtData);
    }

    /* renamed from: component1, reason: from getter */
    public final int getProgress() {
        return this.progress;
    }

    /* renamed from: component2, reason: from getter */
    public final int getTotalMode() {
        return this.totalMode;
    }

    /* renamed from: component3, reason: from getter */
    public final int getCurrentMode() {
        return this.currentMode;
    }

    /* renamed from: component4, reason: from getter */
    public final int getCurrentType() {
        return this.currentType;
    }

    /* renamed from: component5, reason: from getter */
    public final int getViewType() {
        return this.viewType;
    }

    /* renamed from: component6, reason: from getter */
    public final int getSceneId() {
        return this.sceneId;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final LoadingExtData getExtData() {
        return this.extData;
    }

    @NotNull
    public final CommonLoadingData copy(int progress, int totalMode, int currentMode, int currentType, int viewType, int sceneId, @Nullable LoadingExtData extData) {
        return new CommonLoadingData(progress, totalMode, currentMode, currentType, viewType, sceneId, extData);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof CommonLoadingData) {
                CommonLoadingData commonLoadingData = (CommonLoadingData) other;
                if (this.progress != commonLoadingData.progress || this.totalMode != commonLoadingData.totalMode || this.currentMode != commonLoadingData.currentMode || this.currentType != commonLoadingData.currentType || this.viewType != commonLoadingData.viewType || this.sceneId != commonLoadingData.sceneId || !Intrinsics.areEqual(this.extData, commonLoadingData.extData)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final int getCurrentMode() {
        return this.currentMode;
    }

    public final int getCurrentType() {
        return this.currentType;
    }

    @Nullable
    public final LoadingExtData getExtData() {
        return this.extData;
    }

    public final int getProgress() {
        return this.progress;
    }

    public final int getSceneId() {
        return this.sceneId;
    }

    public final int getTotalMode() {
        return this.totalMode;
    }

    public final int getViewType() {
        return this.viewType;
    }

    public int hashCode() {
        int i3;
        int i16 = ((((((((((this.progress * 31) + this.totalMode) * 31) + this.currentMode) * 31) + this.currentType) * 31) + this.viewType) * 31) + this.sceneId) * 31;
        LoadingExtData loadingExtData = this.extData;
        if (loadingExtData != null) {
            i3 = loadingExtData.hashCode();
        } else {
            i3 = 0;
        }
        return i16 + i3;
    }

    public final void setExtData(@Nullable LoadingExtData loadingExtData) {
        this.extData = loadingExtData;
    }

    public final void setProgress(int i3) {
        this.progress = i3;
    }

    public final void setViewType(int i3) {
        this.viewType = i3;
    }

    @NotNull
    public String toString() {
        return "CommonLoadingData(progress=" + this.progress + ", totalMode=" + this.totalMode + ", currentMode=" + this.currentMode + ", currentType=" + this.currentType + ", viewType=" + this.viewType + ", sceneId=" + this.sceneId + ", extData=" + this.extData + ")";
    }

    public CommonLoadingData(int i3, int i16, int i17, int i18, int i19, int i26, @Nullable LoadingExtData loadingExtData) {
        this.progress = i3;
        this.totalMode = i16;
        this.currentMode = i17;
        this.currentType = i18;
        this.viewType = i19;
        this.sceneId = i26;
        this.extData = loadingExtData;
    }

    public /* synthetic */ CommonLoadingData(int i3, int i16, int i17, int i18, int i19, int i26, LoadingExtData loadingExtData, int i27, DefaultConstructorMarker defaultConstructorMarker) {
        this((i27 & 1) != 0 ? 0 : i3, (i27 & 2) != 0 ? 0 : i16, (i27 & 4) != 0 ? 0 : i17, (i27 & 8) != 0 ? 0 : i18, (i27 & 16) != 0 ? 0 : i19, (i27 & 32) == 0 ? i26 : 0, (i27 & 64) != 0 ? null : loadingExtData);
    }
}
