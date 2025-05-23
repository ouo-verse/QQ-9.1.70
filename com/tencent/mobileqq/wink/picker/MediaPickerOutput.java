package com.tencent.mobileqq.wink.picker;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleSmartMatchMusic$MusicInfo;
import qqcircle.QQCircleSmartMatchMusic$MusicStuckPointInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0004\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0004\u00a2\u0006\u0004\b#\u0010$Jc\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00042\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0004H\u00c6\u0001J\t\u0010\u0010\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0011H\u00d6\u0001J\u0013\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001f\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u001a\u001a\u0004\b\"\u0010\u001cR\u001f\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u001a\u001a\u0004\b\u001d\u0010\u001cR\u001f\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001a\u001a\u0004\b!\u0010\u001c\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/b;", "", "Lcom/tencent/mobileqq/wink/picker/MediaPickerScene;", "mediaPickerScene", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "selectedMedia", "Lcom/tencent/mobileqq/wink/picker/e;", "videoTemplateData", "processedMedia", "Lqqcircle/QQCircleSmartMatchMusic$MusicInfo;", "musicInfo", "Lqqcircle/QQCircleSmartMatchMusic$MusicStuckPointInfo;", "musicStuckPointInfo", "a", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/wink/picker/MediaPickerScene;", "getMediaPickerScene", "()Lcom/tencent/mobileqq/wink/picker/MediaPickerScene;", "b", "Ljava/util/List;", "f", "()Ljava/util/List;", "c", "Lcom/tencent/mobileqq/wink/picker/e;", "g", "()Lcom/tencent/mobileqq/wink/picker/e;", "d", "e", "<init>", "(Lcom/tencent/mobileqq/wink/picker/MediaPickerScene;Ljava/util/List;Lcom/tencent/mobileqq/wink/picker/e;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.picker.b, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class MediaPickerOutput {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final MediaPickerScene mediaPickerScene;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<LocalMediaInfo> selectedMedia;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final VideoTemplateData videoTemplateData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final List<LocalMediaInfo> processedMedia;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final List<QQCircleSmartMatchMusic$MusicInfo> musicInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final List<QQCircleSmartMatchMusic$MusicStuckPointInfo> musicStuckPointInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public MediaPickerOutput(@NotNull MediaPickerScene mediaPickerScene, @NotNull List<? extends LocalMediaInfo> selectedMedia, @NotNull VideoTemplateData videoTemplateData, @Nullable List<? extends LocalMediaInfo> list, @Nullable List<QQCircleSmartMatchMusic$MusicInfo> list2, @Nullable List<QQCircleSmartMatchMusic$MusicStuckPointInfo> list3) {
        Intrinsics.checkNotNullParameter(mediaPickerScene, "mediaPickerScene");
        Intrinsics.checkNotNullParameter(selectedMedia, "selectedMedia");
        Intrinsics.checkNotNullParameter(videoTemplateData, "videoTemplateData");
        this.mediaPickerScene = mediaPickerScene;
        this.selectedMedia = selectedMedia;
        this.videoTemplateData = videoTemplateData;
        this.processedMedia = list;
        this.musicInfo = list2;
        this.musicStuckPointInfo = list3;
    }

    public static /* synthetic */ MediaPickerOutput b(MediaPickerOutput mediaPickerOutput, MediaPickerScene mediaPickerScene, List list, VideoTemplateData videoTemplateData, List list2, List list3, List list4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            mediaPickerScene = mediaPickerOutput.mediaPickerScene;
        }
        if ((i3 & 2) != 0) {
            list = mediaPickerOutput.selectedMedia;
        }
        List list5 = list;
        if ((i3 & 4) != 0) {
            videoTemplateData = mediaPickerOutput.videoTemplateData;
        }
        VideoTemplateData videoTemplateData2 = videoTemplateData;
        if ((i3 & 8) != 0) {
            list2 = mediaPickerOutput.processedMedia;
        }
        List list6 = list2;
        if ((i3 & 16) != 0) {
            list3 = mediaPickerOutput.musicInfo;
        }
        List list7 = list3;
        if ((i3 & 32) != 0) {
            list4 = mediaPickerOutput.musicStuckPointInfo;
        }
        return mediaPickerOutput.a(mediaPickerScene, list5, videoTemplateData2, list6, list7, list4);
    }

    @NotNull
    public final MediaPickerOutput a(@NotNull MediaPickerScene mediaPickerScene, @NotNull List<? extends LocalMediaInfo> selectedMedia, @NotNull VideoTemplateData videoTemplateData, @Nullable List<? extends LocalMediaInfo> processedMedia, @Nullable List<QQCircleSmartMatchMusic$MusicInfo> musicInfo, @Nullable List<QQCircleSmartMatchMusic$MusicStuckPointInfo> musicStuckPointInfo) {
        Intrinsics.checkNotNullParameter(mediaPickerScene, "mediaPickerScene");
        Intrinsics.checkNotNullParameter(selectedMedia, "selectedMedia");
        Intrinsics.checkNotNullParameter(videoTemplateData, "videoTemplateData");
        return new MediaPickerOutput(mediaPickerScene, selectedMedia, videoTemplateData, processedMedia, musicInfo, musicStuckPointInfo);
    }

    @Nullable
    public final List<QQCircleSmartMatchMusic$MusicInfo> c() {
        return this.musicInfo;
    }

    @Nullable
    public final List<QQCircleSmartMatchMusic$MusicStuckPointInfo> d() {
        return this.musicStuckPointInfo;
    }

    @Nullable
    public final List<LocalMediaInfo> e() {
        return this.processedMedia;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaPickerOutput)) {
            return false;
        }
        MediaPickerOutput mediaPickerOutput = (MediaPickerOutput) other;
        if (this.mediaPickerScene == mediaPickerOutput.mediaPickerScene && Intrinsics.areEqual(this.selectedMedia, mediaPickerOutput.selectedMedia) && Intrinsics.areEqual(this.videoTemplateData, mediaPickerOutput.videoTemplateData) && Intrinsics.areEqual(this.processedMedia, mediaPickerOutput.processedMedia) && Intrinsics.areEqual(this.musicInfo, mediaPickerOutput.musicInfo) && Intrinsics.areEqual(this.musicStuckPointInfo, mediaPickerOutput.musicStuckPointInfo)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final List<LocalMediaInfo> f() {
        return this.selectedMedia;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final VideoTemplateData getVideoTemplateData() {
        return this.videoTemplateData;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3 = ((((this.mediaPickerScene.hashCode() * 31) + this.selectedMedia.hashCode()) * 31) + this.videoTemplateData.hashCode()) * 31;
        List<LocalMediaInfo> list = this.processedMedia;
        int i3 = 0;
        if (list == null) {
            hashCode = 0;
        } else {
            hashCode = list.hashCode();
        }
        int i16 = (hashCode3 + hashCode) * 31;
        List<QQCircleSmartMatchMusic$MusicInfo> list2 = this.musicInfo;
        if (list2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = list2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        List<QQCircleSmartMatchMusic$MusicStuckPointInfo> list3 = this.musicStuckPointInfo;
        if (list3 != null) {
            i3 = list3.hashCode();
        }
        return i17 + i3;
    }

    @NotNull
    public String toString() {
        return "MediaPickerOutput(mediaPickerScene=" + this.mediaPickerScene + ", selectedMedia=" + this.selectedMedia + ", videoTemplateData=" + this.videoTemplateData + ", processedMedia=" + this.processedMedia + ", musicInfo=" + this.musicInfo + ", musicStuckPointInfo=" + this.musicStuckPointInfo + ")";
    }
}
