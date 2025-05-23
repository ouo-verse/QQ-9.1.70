package com.tencent.qcircle.weseevideo.camera.mvauto.redo;

import com.tencent.qcircle.weseevideo.model.resource.MediaClipModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0007J\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qcircle/weseevideo/camera/mvauto/redo/StoreModelConvert;", "", "()V", "convert", "Lcom/tencent/qcircle/weseevideo/camera/mvauto/redo/CutModelKt;", "it", "Lcom/tencent/qcircle/weseevideo/model/resource/MediaClipModel;", "", "resource", "restoreClipTimeRange", "data", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final class StoreModelConvert {
    public static final StoreModelConvert INSTANCE = new StoreModelConvert();

    StoreModelConvert() {
    }

    @NotNull
    public final List<CutModelKt> convert(@NotNull List<MediaClipModel> resource) {
        int collectionSizeOrDefault;
        Intrinsics.checkParameterIsNotNull(resource, "resource");
        List<MediaClipModel> list = resource;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(INSTANCE.convert((MediaClipModel) it.next()));
        }
        return arrayList;
    }

    @NotNull
    public final List<CutModelKt> restoreClipTimeRange(@NotNull List<CutModelKt> data) {
        List<CutModelKt> mutableList;
        IntRange indices;
        IntProgression reversed;
        VideoResourceModelKt copy;
        Intrinsics.checkParameterIsNotNull(data, "data");
        List<CutModelKt> list = data;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
        indices = CollectionsKt__CollectionsKt.getIndices(list);
        reversed = RangesKt___RangesKt.reversed(indices);
        Iterator<Integer> it = reversed.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            CutModelKt cutModelKt = mutableList.get(nextInt);
            if (cutModelKt.getResource().getSelectTimeDuration() < cutModelKt.getResource().getCutTimeDuration()) {
                copy = r6.copy((r45 & 1) != 0 ? r6.path : null, (r45 & 2) != 0 ? r6.type : 0, (r45 & 4) != 0 ? r6.scaleDuration : ((float) cutModelKt.getResource().getCutTimeDuration()) / cutModelKt.getResource().getScaleSpeed(), (r45 & 8) != 0 ? r6.sourceTimeStart : 0L, (r45 & 16) != 0 ? r6.sourceTimeDuration : 0L, (r45 & 32) != 0 ? r6.sourceTimeStartUs : 0L, (r45 & 64) != 0 ? r6.sourceTimeDurationUs : 0L, (r45 & 128) != 0 ? r6.selectTimeStart : cutModelKt.getResource().getCutTimeStart(), (r45 & 256) != 0 ? r6.selectTimeDuration : cutModelKt.getResource().getCutTimeDuration(), (r45 & 512) != 0 ? r6.selectTimeStartUs : 0L, (r45 & 1024) != 0 ? r6.selectTimeDurationUs : cutModelKt.getResource().getCutTimeDuration() * 1000, (r45 & 2048) != 0 ? r6.cutTimeStart : 0L, (r45 & 4096) != 0 ? r6.cutTimeDuration : 0L, (r45 & 8192) != 0 ? r6.width : 0, (r45 & 16384) != 0 ? r6.height : 0, (r45 & 32768) != 0 ? cutModelKt.getResource().rotate : 0);
                mutableList.set(nextInt, CutModelKt.copy$default(cutModelKt, null, copy, null, null, 13, null));
            }
        }
        return mutableList;
    }

    @NotNull
    public final CutModelKt convert(@NotNull MediaClipModel it) {
        Intrinsics.checkParameterIsNotNull(it, "it");
        return new CutModelKt(null, VideoResourceModelKt.INSTANCE.from(it.getResource()), VideoConfigurationModelKt.INSTANCE.from(it.getVideoConfigurationModel()), it.getAudioConfigurationModel(), 1, null);
    }
}
