package com.tencent.mobileqq.wink.picker;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleSmartMatchMusic$MusicInfo;
import qqcircle.QQCircleSmartMatchMusic$MusicStuckPointInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\b\u00a2\u0006\u0004\b8\u00109J\u0095\u0001\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\b2\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\bH\u00c6\u0001J\t\u0010\u0019\u001a\u00020\u0018H\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u001aH\u00d6\u0001J\u0013\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\u0007\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006\u00a2\u0006\f\n\u0004\b$\u0010*\u001a\u0004\b+\u0010,R\u0017\u0010\f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b(\u0010-\u001a\u0004\b.\u0010/R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001f\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b4\u0010*\u001a\u0004\b5\u0010,R\u001f\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006\u00a2\u0006\f\n\u0004\b \u00106\u001a\u0004\b&\u00107R\u001f\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b5\u0010*\u001a\u0004\b0\u0010,R\u001f\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b+\u0010*\u001a\u0004\b4\u0010,\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/a;", "", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/b;", "nextStepUIStateViewModel", "Lcom/tencent/mobileqq/wink/picker/MediaPickerScene;", "mediaPickerScene", "Lcom/tencent/mobileqq/wink/picker/TabType;", "mediaPickerTabType", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "selectedMedia", "Lcom/tencent/mobileqq/wink/picker/e;", "videoTemplateData", "Lcom/tencent/mobileqq/wink/picker/d;", "templateLibraryData", "processedMedia", "Ljava/util/ArrayList;", "", "coverBitmaps", "Lqqcircle/QQCircleSmartMatchMusic$MusicInfo;", "musicInfo", "Lqqcircle/QQCircleSmartMatchMusic$MusicStuckPointInfo;", "musicStuckPointInfo", "a", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/b;", tl.h.F, "()Lcom/tencent/mobileqq/wink/picker/core/viewmodel/b;", "b", "Lcom/tencent/mobileqq/wink/picker/MediaPickerScene;", "d", "()Lcom/tencent/mobileqq/wink/picker/MediaPickerScene;", "c", "Lcom/tencent/mobileqq/wink/picker/TabType;", "e", "()Lcom/tencent/mobileqq/wink/picker/TabType;", "Ljava/util/List;", "j", "()Ljava/util/List;", "Lcom/tencent/mobileqq/wink/picker/e;", "l", "()Lcom/tencent/mobileqq/wink/picker/e;", "f", "Lcom/tencent/mobileqq/wink/picker/d;", "k", "()Lcom/tencent/mobileqq/wink/picker/d;", "g", "i", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "<init>", "(Lcom/tencent/mobileqq/wink/picker/core/viewmodel/b;Lcom/tencent/mobileqq/wink/picker/MediaPickerScene;Lcom/tencent/mobileqq/wink/picker/TabType;Ljava/util/List;Lcom/tencent/mobileqq/wink/picker/e;Lcom/tencent/mobileqq/wink/picker/d;Ljava/util/List;Ljava/util/ArrayList;Ljava/util/List;Ljava/util/List;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.picker.a, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class MediaPickerInput {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final com.tencent.mobileqq.wink.picker.core.viewmodel.b nextStepUIStateViewModel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final MediaPickerScene mediaPickerScene;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final TabType mediaPickerTabType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<LocalMediaInfo> selectedMedia;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final VideoTemplateData videoTemplateData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final TemplateLibraryData templateLibraryData;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final List<LocalMediaInfo> processedMedia;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final ArrayList<byte[]> coverBitmaps;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final List<QQCircleSmartMatchMusic$MusicInfo> musicInfo;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final List<QQCircleSmartMatchMusic$MusicStuckPointInfo> musicStuckPointInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public MediaPickerInput(@NotNull com.tencent.mobileqq.wink.picker.core.viewmodel.b nextStepUIStateViewModel, @NotNull MediaPickerScene mediaPickerScene, @NotNull TabType mediaPickerTabType, @NotNull List<? extends LocalMediaInfo> selectedMedia, @NotNull VideoTemplateData videoTemplateData, @Nullable TemplateLibraryData templateLibraryData, @Nullable List<? extends LocalMediaInfo> list, @Nullable ArrayList<byte[]> arrayList, @Nullable List<QQCircleSmartMatchMusic$MusicInfo> list2, @Nullable List<QQCircleSmartMatchMusic$MusicStuckPointInfo> list3) {
        Intrinsics.checkNotNullParameter(nextStepUIStateViewModel, "nextStepUIStateViewModel");
        Intrinsics.checkNotNullParameter(mediaPickerScene, "mediaPickerScene");
        Intrinsics.checkNotNullParameter(mediaPickerTabType, "mediaPickerTabType");
        Intrinsics.checkNotNullParameter(selectedMedia, "selectedMedia");
        Intrinsics.checkNotNullParameter(videoTemplateData, "videoTemplateData");
        this.nextStepUIStateViewModel = nextStepUIStateViewModel;
        this.mediaPickerScene = mediaPickerScene;
        this.mediaPickerTabType = mediaPickerTabType;
        this.selectedMedia = selectedMedia;
        this.videoTemplateData = videoTemplateData;
        this.templateLibraryData = templateLibraryData;
        this.processedMedia = list;
        this.coverBitmaps = arrayList;
        this.musicInfo = list2;
        this.musicStuckPointInfo = list3;
    }

    public static /* synthetic */ MediaPickerInput b(MediaPickerInput mediaPickerInput, com.tencent.mobileqq.wink.picker.core.viewmodel.b bVar, MediaPickerScene mediaPickerScene, TabType tabType, List list, VideoTemplateData videoTemplateData, TemplateLibraryData templateLibraryData, List list2, ArrayList arrayList, List list3, List list4, int i3, Object obj) {
        com.tencent.mobileqq.wink.picker.core.viewmodel.b bVar2;
        MediaPickerScene mediaPickerScene2;
        TabType tabType2;
        List list5;
        VideoTemplateData videoTemplateData2;
        TemplateLibraryData templateLibraryData2;
        List list6;
        ArrayList arrayList2;
        List list7;
        List list8;
        if ((i3 & 1) != 0) {
            bVar2 = mediaPickerInput.nextStepUIStateViewModel;
        } else {
            bVar2 = bVar;
        }
        if ((i3 & 2) != 0) {
            mediaPickerScene2 = mediaPickerInput.mediaPickerScene;
        } else {
            mediaPickerScene2 = mediaPickerScene;
        }
        if ((i3 & 4) != 0) {
            tabType2 = mediaPickerInput.mediaPickerTabType;
        } else {
            tabType2 = tabType;
        }
        if ((i3 & 8) != 0) {
            list5 = mediaPickerInput.selectedMedia;
        } else {
            list5 = list;
        }
        if ((i3 & 16) != 0) {
            videoTemplateData2 = mediaPickerInput.videoTemplateData;
        } else {
            videoTemplateData2 = videoTemplateData;
        }
        if ((i3 & 32) != 0) {
            templateLibraryData2 = mediaPickerInput.templateLibraryData;
        } else {
            templateLibraryData2 = templateLibraryData;
        }
        if ((i3 & 64) != 0) {
            list6 = mediaPickerInput.processedMedia;
        } else {
            list6 = list2;
        }
        if ((i3 & 128) != 0) {
            arrayList2 = mediaPickerInput.coverBitmaps;
        } else {
            arrayList2 = arrayList;
        }
        if ((i3 & 256) != 0) {
            list7 = mediaPickerInput.musicInfo;
        } else {
            list7 = list3;
        }
        if ((i3 & 512) != 0) {
            list8 = mediaPickerInput.musicStuckPointInfo;
        } else {
            list8 = list4;
        }
        return mediaPickerInput.a(bVar2, mediaPickerScene2, tabType2, list5, videoTemplateData2, templateLibraryData2, list6, arrayList2, list7, list8);
    }

    @NotNull
    public final MediaPickerInput a(@NotNull com.tencent.mobileqq.wink.picker.core.viewmodel.b nextStepUIStateViewModel, @NotNull MediaPickerScene mediaPickerScene, @NotNull TabType mediaPickerTabType, @NotNull List<? extends LocalMediaInfo> selectedMedia, @NotNull VideoTemplateData videoTemplateData, @Nullable TemplateLibraryData templateLibraryData, @Nullable List<? extends LocalMediaInfo> processedMedia, @Nullable ArrayList<byte[]> coverBitmaps, @Nullable List<QQCircleSmartMatchMusic$MusicInfo> musicInfo, @Nullable List<QQCircleSmartMatchMusic$MusicStuckPointInfo> musicStuckPointInfo) {
        Intrinsics.checkNotNullParameter(nextStepUIStateViewModel, "nextStepUIStateViewModel");
        Intrinsics.checkNotNullParameter(mediaPickerScene, "mediaPickerScene");
        Intrinsics.checkNotNullParameter(mediaPickerTabType, "mediaPickerTabType");
        Intrinsics.checkNotNullParameter(selectedMedia, "selectedMedia");
        Intrinsics.checkNotNullParameter(videoTemplateData, "videoTemplateData");
        return new MediaPickerInput(nextStepUIStateViewModel, mediaPickerScene, mediaPickerTabType, selectedMedia, videoTemplateData, templateLibraryData, processedMedia, coverBitmaps, musicInfo, musicStuckPointInfo);
    }

    @Nullable
    public final ArrayList<byte[]> c() {
        return this.coverBitmaps;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final MediaPickerScene getMediaPickerScene() {
        return this.mediaPickerScene;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final TabType getMediaPickerTabType() {
        return this.mediaPickerTabType;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaPickerInput)) {
            return false;
        }
        MediaPickerInput mediaPickerInput = (MediaPickerInput) other;
        if (Intrinsics.areEqual(this.nextStepUIStateViewModel, mediaPickerInput.nextStepUIStateViewModel) && this.mediaPickerScene == mediaPickerInput.mediaPickerScene && this.mediaPickerTabType == mediaPickerInput.mediaPickerTabType && Intrinsics.areEqual(this.selectedMedia, mediaPickerInput.selectedMedia) && Intrinsics.areEqual(this.videoTemplateData, mediaPickerInput.videoTemplateData) && Intrinsics.areEqual(this.templateLibraryData, mediaPickerInput.templateLibraryData) && Intrinsics.areEqual(this.processedMedia, mediaPickerInput.processedMedia) && Intrinsics.areEqual(this.coverBitmaps, mediaPickerInput.coverBitmaps) && Intrinsics.areEqual(this.musicInfo, mediaPickerInput.musicInfo) && Intrinsics.areEqual(this.musicStuckPointInfo, mediaPickerInput.musicStuckPointInfo)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final List<QQCircleSmartMatchMusic$MusicInfo> f() {
        return this.musicInfo;
    }

    @Nullable
    public final List<QQCircleSmartMatchMusic$MusicStuckPointInfo> g() {
        return this.musicStuckPointInfo;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final com.tencent.mobileqq.wink.picker.core.viewmodel.b getNextStepUIStateViewModel() {
        return this.nextStepUIStateViewModel;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5 = ((((((((this.nextStepUIStateViewModel.hashCode() * 31) + this.mediaPickerScene.hashCode()) * 31) + this.mediaPickerTabType.hashCode()) * 31) + this.selectedMedia.hashCode()) * 31) + this.videoTemplateData.hashCode()) * 31;
        TemplateLibraryData templateLibraryData = this.templateLibraryData;
        int i3 = 0;
        if (templateLibraryData == null) {
            hashCode = 0;
        } else {
            hashCode = templateLibraryData.hashCode();
        }
        int i16 = (hashCode5 + hashCode) * 31;
        List<LocalMediaInfo> list = this.processedMedia;
        if (list == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = list.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        ArrayList<byte[]> arrayList = this.coverBitmaps;
        if (arrayList == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = arrayList.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        List<QQCircleSmartMatchMusic$MusicInfo> list2 = this.musicInfo;
        if (list2 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = list2.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        List<QQCircleSmartMatchMusic$MusicStuckPointInfo> list3 = this.musicStuckPointInfo;
        if (list3 != null) {
            i3 = list3.hashCode();
        }
        return i19 + i3;
    }

    @Nullable
    public final List<LocalMediaInfo> i() {
        return this.processedMedia;
    }

    @NotNull
    public final List<LocalMediaInfo> j() {
        return this.selectedMedia;
    }

    @Nullable
    /* renamed from: k, reason: from getter */
    public final TemplateLibraryData getTemplateLibraryData() {
        return this.templateLibraryData;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final VideoTemplateData getVideoTemplateData() {
        return this.videoTemplateData;
    }

    @NotNull
    public String toString() {
        return "MediaPickerInput(nextStepUIStateViewModel=" + this.nextStepUIStateViewModel + ", mediaPickerScene=" + this.mediaPickerScene + ", mediaPickerTabType=" + this.mediaPickerTabType + ", selectedMedia=" + this.selectedMedia + ", videoTemplateData=" + this.videoTemplateData + ", templateLibraryData=" + this.templateLibraryData + ", processedMedia=" + this.processedMedia + ", coverBitmaps=" + this.coverBitmaps + ", musicInfo=" + this.musicInfo + ", musicStuckPointInfo=" + this.musicStuckPointInfo + ")";
    }

    public /* synthetic */ MediaPickerInput(com.tencent.mobileqq.wink.picker.core.viewmodel.b bVar, MediaPickerScene mediaPickerScene, TabType tabType, List list, VideoTemplateData videoTemplateData, TemplateLibraryData templateLibraryData, List list2, ArrayList arrayList, List list3, List list4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(bVar, mediaPickerScene, tabType, list, videoTemplateData, templateLibraryData, (i3 & 64) != 0 ? null : list2, (i3 & 128) != 0 ? null : arrayList, (i3 & 256) != 0 ? null : list3, (i3 & 512) != 0 ? null : list4);
    }
}
