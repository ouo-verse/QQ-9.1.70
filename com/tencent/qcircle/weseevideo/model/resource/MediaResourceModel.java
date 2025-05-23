package com.tencent.qcircle.weseevideo.model.resource;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002BQ\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u000bJ\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00c6\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\bH\u00c6\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00c6\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00c6\u0003JU\u0010\u001a\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00c6\u0001J\u0006\u0010\u001b\u001a\u00020\u0000J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u00d6\u0003J\t\u0010 \u001a\u00020\bH\u00d6\u0001J\t\u0010!\u001a\u00020\"H\u00d6\u0001R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u0014\u00a8\u0006#"}, d2 = {"Lcom/tencent/qcircle/weseevideo/model/resource/MediaResourceModel;", "Ljava/io/Serializable;", "()V", "videos", "", "Lcom/tencent/qcircle/weseevideo/model/resource/MediaClipModel;", "backupVideos", "smartType", "", "recordAudios", "backgroundMusic", "(Ljava/util/List;Ljava/util/List;ILjava/util/List;Ljava/util/List;)V", "getBackgroundMusic", "()Ljava/util/List;", "getBackupVideos", "getRecordAudios", "getSmartType", "()I", "getVideos", "setVideos", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "copy", "deepCopy", "equals", "", "other", "", "hashCode", "toString", "", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final /* data */ class MediaResourceModel implements Serializable {

    @NotNull
    private final List<MediaClipModel> backgroundMusic;

    @Nullable
    private final List<MediaClipModel> backupVideos;

    @NotNull
    private final List<MediaClipModel> recordAudios;
    private final int smartType;

    @NotNull
    private List<MediaClipModel> videos;

    public MediaResourceModel(@NotNull List<MediaClipModel> videos, @Nullable List<MediaClipModel> list, int i3, @NotNull List<MediaClipModel> recordAudios, @NotNull List<MediaClipModel> backgroundMusic) {
        Intrinsics.checkParameterIsNotNull(videos, "videos");
        Intrinsics.checkParameterIsNotNull(recordAudios, "recordAudios");
        Intrinsics.checkParameterIsNotNull(backgroundMusic, "backgroundMusic");
        this.videos = videos;
        this.backupVideos = list;
        this.smartType = i3;
        this.recordAudios = recordAudios;
        this.backgroundMusic = backgroundMusic;
    }

    public static /* synthetic */ MediaResourceModel copy$default(MediaResourceModel mediaResourceModel, List list, List list2, int i3, List list3, List list4, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            list = mediaResourceModel.videos;
        }
        if ((i16 & 2) != 0) {
            list2 = mediaResourceModel.backupVideos;
        }
        List list5 = list2;
        if ((i16 & 4) != 0) {
            i3 = mediaResourceModel.smartType;
        }
        int i17 = i3;
        if ((i16 & 8) != 0) {
            list3 = mediaResourceModel.recordAudios;
        }
        List list6 = list3;
        if ((i16 & 16) != 0) {
            list4 = mediaResourceModel.backgroundMusic;
        }
        return mediaResourceModel.copy(list, list5, i17, list6, list4);
    }

    @NotNull
    public final List<MediaClipModel> component1() {
        return this.videos;
    }

    @Nullable
    public final List<MediaClipModel> component2() {
        return this.backupVideos;
    }

    /* renamed from: component3, reason: from getter */
    public final int getSmartType() {
        return this.smartType;
    }

    @NotNull
    public final List<MediaClipModel> component4() {
        return this.recordAudios;
    }

    @NotNull
    public final List<MediaClipModel> component5() {
        return this.backgroundMusic;
    }

    @NotNull
    public final MediaResourceModel copy(@NotNull List<MediaClipModel> videos, @Nullable List<MediaClipModel> backupVideos, int smartType, @NotNull List<MediaClipModel> recordAudios, @NotNull List<MediaClipModel> backgroundMusic) {
        Intrinsics.checkParameterIsNotNull(videos, "videos");
        Intrinsics.checkParameterIsNotNull(recordAudios, "recordAudios");
        Intrinsics.checkParameterIsNotNull(backgroundMusic, "backgroundMusic");
        return new MediaResourceModel(videos, backupVideos, smartType, recordAudios, backgroundMusic);
    }

    @NotNull
    public final MediaResourceModel deepCopy() {
        int collectionSizeOrDefault;
        List mutableList;
        List list;
        int collectionSizeOrDefault2;
        List mutableList2;
        int collectionSizeOrDefault3;
        List mutableList3;
        int collectionSizeOrDefault4;
        List<MediaClipModel> list2 = this.videos;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((MediaClipModel) it.next()).deepCopy());
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        List<MediaClipModel> list3 = this.backupVideos;
        if (list3 != null) {
            List<MediaClipModel> list4 = list3;
            collectionSizeOrDefault4 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault4);
            Iterator<T> it5 = list4.iterator();
            while (it5.hasNext()) {
                arrayList2.add(((MediaClipModel) it5.next()).deepCopy());
            }
            list = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
        } else {
            list = null;
        }
        List list5 = list;
        int i3 = this.smartType;
        List<MediaClipModel> list6 = this.recordAudios;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list6, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it6 = list6.iterator();
        while (it6.hasNext()) {
            arrayList3.add(((MediaClipModel) it6.next()).deepCopy());
        }
        mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList3);
        List<MediaClipModel> list7 = this.backgroundMusic;
        collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list7, 10);
        ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault3);
        Iterator<T> it7 = list7.iterator();
        while (it7.hasNext()) {
            arrayList4.add(((MediaClipModel) it7.next()).deepCopy());
        }
        mutableList3 = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList4);
        return new MediaResourceModel(mutableList, list5, i3, mutableList2, mutableList3);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof MediaResourceModel) {
                MediaResourceModel mediaResourceModel = (MediaResourceModel) other;
                if (!Intrinsics.areEqual(this.videos, mediaResourceModel.videos) || !Intrinsics.areEqual(this.backupVideos, mediaResourceModel.backupVideos) || this.smartType != mediaResourceModel.smartType || !Intrinsics.areEqual(this.recordAudios, mediaResourceModel.recordAudios) || !Intrinsics.areEqual(this.backgroundMusic, mediaResourceModel.backgroundMusic)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final List<MediaClipModel> getBackgroundMusic() {
        return this.backgroundMusic;
    }

    @Nullable
    public final List<MediaClipModel> getBackupVideos() {
        return this.backupVideos;
    }

    @NotNull
    public final List<MediaClipModel> getRecordAudios() {
        return this.recordAudios;
    }

    public final int getSmartType() {
        return this.smartType;
    }

    @NotNull
    public final List<MediaClipModel> getVideos() {
        return this.videos;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        List<MediaClipModel> list = this.videos;
        int i18 = 0;
        if (list != null) {
            i3 = list.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = i3 * 31;
        List<MediaClipModel> list2 = this.backupVideos;
        if (list2 != null) {
            i16 = list2.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (((i19 + i16) * 31) + this.smartType) * 31;
        List<MediaClipModel> list3 = this.recordAudios;
        if (list3 != null) {
            i17 = list3.hashCode();
        } else {
            i17 = 0;
        }
        int i27 = (i26 + i17) * 31;
        List<MediaClipModel> list4 = this.backgroundMusic;
        if (list4 != null) {
            i18 = list4.hashCode();
        }
        return i27 + i18;
    }

    public final void setVideos(@NotNull List<MediaClipModel> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.videos = list;
    }

    @NotNull
    public String toString() {
        return "MediaResourceModel(videos=" + this.videos + ", backupVideos=" + this.backupVideos + ", smartType=" + this.smartType + ", recordAudios=" + this.recordAudios + ", backgroundMusic=" + this.backgroundMusic + ")";
    }

    public /* synthetic */ MediaResourceModel(List list, List list2, int i3, List list3, List list4, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? new ArrayList() : list, (i16 & 2) != 0 ? new ArrayList() : list2, (i16 & 4) != 0 ? 0 : i3, (i16 & 8) != 0 ? new ArrayList() : list3, (i16 & 16) != 0 ? new ArrayList() : list4);
    }

    public MediaResourceModel() {
        this(new ArrayList(), new ArrayList(), 0, new ArrayList(), new ArrayList());
    }
}
