package com.tencent.mobileqq.qqvideoedit.editor.draft;

import androidx.fragment.app.a;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.qqvideoedit.editor.sticker.VideoStickerModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.FilterModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaModel;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b!\b\u0086\b\u0018\u0000 =2\u00020\u0001:\u0001>B\u0083\u0001\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006\u0012\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006\u0012\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006\u0012\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0011\u00a2\u0006\u0004\b;\u0010<J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\u0017\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006H\u00c6\u0003J\u0017\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006H\u00c6\u0003J\u0017\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006H\u00c6\u0003J\u0017\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0011H\u00c6\u0003J\u0087\u0001\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00042\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\u00062\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f\u0018\u00010\u00062\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\b\b\u0002\u0010\u0019\u001a\u00020\u0011H\u00c6\u0001J\t\u0010\u001b\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u001cH\u00d6\u0001J\u0013\u0010 \u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u00d6\u0003R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R0\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R0\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010+\u001a\u0004\b0\u0010-\"\u0004\b1\u0010/R0\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010+\u001a\u0004\b2\u0010-\"\u0004\b3\u0010/R0\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010+\u001a\u0004\b4\u0010-\"\u0004\b5\u0010/R\"\u0010\u0019\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/draft/VideoEditData;", "Ljava/io/Serializable;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel;", "component1", "", "component2", "", "", "Lcom/tencent/mobileqq/qqvideoedit/editor/sticker/VideoStickerModel;", "component3", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/FilterModel;", "component4", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "component5", "", "Lcom/tencent/mobileqq/qqvideoedit/editor/draft/VideoStickerModelExtra;", "component6", "", "component7", "mediaModel", "durationUs", "stickerModelMap", "filterModelMap", "filterMaterialMap", "stickerExtraMap", "openHDR", "copy", "toString", "", "hashCode", "", "other", "equals", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel;", "getMediaModel", "()Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel;", "setMediaModel", "(Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel;)V", "J", "getDurationUs", "()J", "setDurationUs", "(J)V", "Ljava/util/Map;", "getStickerModelMap", "()Ljava/util/Map;", "setStickerModelMap", "(Ljava/util/Map;)V", "getFilterModelMap", "setFilterModelMap", "getFilterMaterialMap", "setFilterMaterialMap", "getStickerExtraMap", "setStickerExtraMap", "Z", "getOpenHDR", "()Z", "setOpenHDR", "(Z)V", "<init>", "(Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel;JLjava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Z)V", "Companion", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final /* data */ class VideoEditData implements Serializable {
    private static final long serialVersionUID = 599093938747237758L;
    private long durationUs;

    @Nullable
    private Map<String, MetaMaterial> filterMaterialMap;

    @Nullable
    private Map<String, FilterModel> filterModelMap;

    @NotNull
    private MediaModel mediaModel;
    private boolean openHDR;

    @Nullable
    private Map<String, VideoStickerModelExtra> stickerExtraMap;

    @Nullable
    private Map<String, VideoStickerModel> stickerModelMap;

    public VideoEditData(@NotNull MediaModel mediaModel, long j3, @Nullable Map<String, VideoStickerModel> map, @Nullable Map<String, FilterModel> map2, @Nullable Map<String, MetaMaterial> map3, @Nullable Map<String, VideoStickerModelExtra> map4, boolean z16) {
        Intrinsics.checkNotNullParameter(mediaModel, "mediaModel");
        this.mediaModel = mediaModel;
        this.durationUs = j3;
        this.stickerModelMap = map;
        this.filterModelMap = map2;
        this.filterMaterialMap = map3;
        this.stickerExtraMap = map4;
        this.openHDR = z16;
    }

    public static /* synthetic */ VideoEditData copy$default(VideoEditData videoEditData, MediaModel mediaModel, long j3, Map map, Map map2, Map map3, Map map4, boolean z16, int i3, Object obj) {
        MediaModel mediaModel2;
        long j16;
        Map map5;
        Map map6;
        Map map7;
        Map map8;
        boolean z17;
        if ((i3 & 1) != 0) {
            mediaModel2 = videoEditData.mediaModel;
        } else {
            mediaModel2 = mediaModel;
        }
        if ((i3 & 2) != 0) {
            j16 = videoEditData.durationUs;
        } else {
            j16 = j3;
        }
        if ((i3 & 4) != 0) {
            map5 = videoEditData.stickerModelMap;
        } else {
            map5 = map;
        }
        if ((i3 & 8) != 0) {
            map6 = videoEditData.filterModelMap;
        } else {
            map6 = map2;
        }
        if ((i3 & 16) != 0) {
            map7 = videoEditData.filterMaterialMap;
        } else {
            map7 = map3;
        }
        if ((i3 & 32) != 0) {
            map8 = videoEditData.stickerExtraMap;
        } else {
            map8 = map4;
        }
        if ((i3 & 64) != 0) {
            z17 = videoEditData.openHDR;
        } else {
            z17 = z16;
        }
        return videoEditData.copy(mediaModel2, j16, map5, map6, map7, map8, z17);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final MediaModel getMediaModel() {
        return this.mediaModel;
    }

    /* renamed from: component2, reason: from getter */
    public final long getDurationUs() {
        return this.durationUs;
    }

    @Nullable
    public final Map<String, VideoStickerModel> component3() {
        return this.stickerModelMap;
    }

    @Nullable
    public final Map<String, FilterModel> component4() {
        return this.filterModelMap;
    }

    @Nullable
    public final Map<String, MetaMaterial> component5() {
        return this.filterMaterialMap;
    }

    @Nullable
    public final Map<String, VideoStickerModelExtra> component6() {
        return this.stickerExtraMap;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getOpenHDR() {
        return this.openHDR;
    }

    @NotNull
    public final VideoEditData copy(@NotNull MediaModel mediaModel, long durationUs, @Nullable Map<String, VideoStickerModel> stickerModelMap, @Nullable Map<String, FilterModel> filterModelMap, @Nullable Map<String, MetaMaterial> filterMaterialMap, @Nullable Map<String, VideoStickerModelExtra> stickerExtraMap, boolean openHDR) {
        Intrinsics.checkNotNullParameter(mediaModel, "mediaModel");
        return new VideoEditData(mediaModel, durationUs, stickerModelMap, filterModelMap, filterMaterialMap, stickerExtraMap, openHDR);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoEditData)) {
            return false;
        }
        VideoEditData videoEditData = (VideoEditData) other;
        if (Intrinsics.areEqual(this.mediaModel, videoEditData.mediaModel) && this.durationUs == videoEditData.durationUs && Intrinsics.areEqual(this.stickerModelMap, videoEditData.stickerModelMap) && Intrinsics.areEqual(this.filterModelMap, videoEditData.filterModelMap) && Intrinsics.areEqual(this.filterMaterialMap, videoEditData.filterMaterialMap) && Intrinsics.areEqual(this.stickerExtraMap, videoEditData.stickerExtraMap) && this.openHDR == videoEditData.openHDR) {
            return true;
        }
        return false;
    }

    public final long getDurationUs() {
        return this.durationUs;
    }

    @Nullable
    public final Map<String, MetaMaterial> getFilterMaterialMap() {
        return this.filterMaterialMap;
    }

    @Nullable
    public final Map<String, FilterModel> getFilterModelMap() {
        return this.filterModelMap;
    }

    @NotNull
    public final MediaModel getMediaModel() {
        return this.mediaModel;
    }

    public final boolean getOpenHDR() {
        return this.openHDR;
    }

    @Nullable
    public final Map<String, VideoStickerModelExtra> getStickerExtraMap() {
        return this.stickerExtraMap;
    }

    @Nullable
    public final Map<String, VideoStickerModel> getStickerModelMap() {
        return this.stickerModelMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4 = ((this.mediaModel.hashCode() * 31) + a.a(this.durationUs)) * 31;
        Map<String, VideoStickerModel> map = this.stickerModelMap;
        int i3 = 0;
        if (map == null) {
            hashCode = 0;
        } else {
            hashCode = map.hashCode();
        }
        int i16 = (hashCode4 + hashCode) * 31;
        Map<String, FilterModel> map2 = this.filterModelMap;
        if (map2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = map2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        Map<String, MetaMaterial> map3 = this.filterMaterialMap;
        if (map3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = map3.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        Map<String, VideoStickerModelExtra> map4 = this.stickerExtraMap;
        if (map4 != null) {
            i3 = map4.hashCode();
        }
        int i19 = (i18 + i3) * 31;
        boolean z16 = this.openHDR;
        int i26 = z16;
        if (z16 != 0) {
            i26 = 1;
        }
        return i19 + i26;
    }

    public final void setDurationUs(long j3) {
        this.durationUs = j3;
    }

    public final void setFilterMaterialMap(@Nullable Map<String, MetaMaterial> map) {
        this.filterMaterialMap = map;
    }

    public final void setFilterModelMap(@Nullable Map<String, FilterModel> map) {
        this.filterModelMap = map;
    }

    public final void setMediaModel(@NotNull MediaModel mediaModel) {
        Intrinsics.checkNotNullParameter(mediaModel, "<set-?>");
        this.mediaModel = mediaModel;
    }

    public final void setOpenHDR(boolean z16) {
        this.openHDR = z16;
    }

    public final void setStickerExtraMap(@Nullable Map<String, VideoStickerModelExtra> map) {
        this.stickerExtraMap = map;
    }

    public final void setStickerModelMap(@Nullable Map<String, VideoStickerModel> map) {
        this.stickerModelMap = map;
    }

    @NotNull
    public String toString() {
        return "VideoEditData(mediaModel=" + this.mediaModel + ", durationUs=" + this.durationUs + ", stickerModelMap=" + this.stickerModelMap + ", filterModelMap=" + this.filterModelMap + ", filterMaterialMap=" + this.filterMaterialMap + ", stickerExtraMap=" + this.stickerExtraMap + ", openHDR=" + this.openHDR + ")";
    }

    public /* synthetic */ VideoEditData(MediaModel mediaModel, long j3, Map map, Map map2, Map map3, Map map4, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(mediaModel, (i3 & 2) != 0 ? 0L : j3, (i3 & 4) != 0 ? null : map, (i3 & 8) != 0 ? null : map2, (i3 & 16) != 0 ? null : map3, (i3 & 32) == 0 ? map4 : null, (i3 & 64) != 0 ? false : z16);
    }
}
