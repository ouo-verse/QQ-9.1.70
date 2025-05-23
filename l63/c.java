package l63;

import c63.WinkClipOpCalcResult;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaType;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.picker.MediaData;
import com.tencent.videocut.render.extension.MediaClipUseType;
import com.tencent.videocut.render.extension.e;
import e63.SelectItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001e\u0010\t\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J$\u0010\r\u001a\u0004\u0018\u00010\f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\nH\u0002J(\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u0006\u001a\u00020\u0005J*\u0010\u0012\u001a\u00020\u000e2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\u0010J \u0010\u0013\u001a\u00020\u000e2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\nJ2\u0010\u0017\u001a\u00020\u000e2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00022\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0005J&\u0010\u001b\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0018\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u00a8\u0006\u001e"}, d2 = {"Ll63/c;", "", "", "Lcom/tencent/videocut/model/MediaClip;", "input", "", "playerTime", "", "d", "e", "Le63/b;", "selectItem", "Lcom/tencent/videocut/model/MediaType;", "f", "Lc63/a;", h.F, "", "speed", "i", "g", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "insertList", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "a", "index", "", "isStart", "b", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c {

    /* renamed from: a */
    @NotNull
    public static final c f413893a = new c();

    c() {
    }

    public static /* synthetic */ long c(c cVar, List list, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            z16 = true;
        }
        return cVar.b(list, i3, z16);
    }

    private final int d(List<? extends MediaClip> input, long playerTime) {
        Iterable<IndexedValue> withIndex;
        int lastIndex;
        long j3;
        boolean z16;
        ArrayList arrayList = new ArrayList();
        for (Object obj : input) {
            if (e.r((MediaClip) obj) != MediaClipUseType.ENDING) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        withIndex = CollectionsKt___CollectionsKt.withIndex(arrayList);
        long j16 = 0;
        for (IndexedValue indexedValue : withIndex) {
            ResourceModel resourceModel = ((MediaClip) indexedValue.getValue()).resource;
            if (resourceModel != null) {
                j3 = resourceModel.scaleDuration;
            } else {
                j3 = 0;
            }
            j16 += j3;
            if (j16 > playerTime) {
                return indexedValue.getIndex();
            }
        }
        lastIndex = CollectionsKt__CollectionsKt.getLastIndex(arrayList);
        return lastIndex;
    }

    private final long e(List<? extends MediaClip> input, long playerTime) {
        long j3;
        Iterator<T> it = input.iterator();
        long j16 = 0;
        while (it.hasNext()) {
            ResourceModel resourceModel = ((MediaClip) it.next()).resource;
            if (resourceModel != null) {
                j3 = resourceModel.scaleDuration;
            } else {
                j3 = 0;
            }
            long j17 = j3 + j16;
            if (j17 > playerTime) {
                return playerTime - j16;
            }
            j16 = j17;
        }
        return 0L;
    }

    private final MediaType f(List<? extends MediaClip> input, SelectItem<?> selectItem) {
        String str;
        MediaClip mediaClip;
        Iterator<T> it = input.iterator();
        do {
            str = null;
            if (!it.hasNext()) {
                return null;
            }
            mediaClip = (MediaClip) it.next();
            ResourceModel resourceModel = mediaClip.resource;
            if (resourceModel != null) {
                str = resourceModel.id;
            }
        } while (!Intrinsics.areEqual(str, selectItem.getId()));
        return mediaClip.resource.type;
    }

    @NotNull
    public final WinkClipOpCalcResult a(@NotNull List<? extends MediaClip> input, @NotNull List<? extends LocalMediaInfo> insertList, float r38, long playerTime) {
        int collectionSizeOrDefault;
        MediaData mediaData;
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(insertList, "insertList");
        List<? extends LocalMediaInfo> list = insertList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (LocalMediaInfo localMediaInfo : list) {
            if (QAlbumUtil.getMediaType(localMediaInfo) == 1) {
                String str = localMediaInfo.mMimeType;
                Intrinsics.checkNotNullExpressionValue(str, "it.mMimeType");
                int i3 = localMediaInfo.mediaWidth;
                int i16 = localMediaInfo.mediaHeight;
                long j3 = localMediaInfo.mDuration * 1000;
                String str2 = localMediaInfo.path;
                Intrinsics.checkNotNullExpressionValue(str2, "it.path");
                mediaData = new MediaData(0, str, i3, i16, 0L, 0L, j3, str2, localMediaInfo.path, localMediaInfo.mAlbumName);
            } else {
                String str3 = localMediaInfo.mMimeType;
                Intrinsics.checkNotNullExpressionValue(str3, "it.mMimeType");
                int i17 = localMediaInfo.mediaWidth;
                int i18 = localMediaInfo.mediaHeight;
                String str4 = localMediaInfo.path;
                Intrinsics.checkNotNullExpressionValue(str4, "it.path");
                mediaData = new MediaData(1, str3, i17, i18, 0L, 0L, 2500000L, str4, localMediaInfo.path, localMediaInfo.mAlbumName);
            }
            arrayList.add(mediaData);
        }
        List<MediaClip> d16 = com.tencent.videocut.render.repository.a.f384196a.d(arrayList, r38);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(input);
        int d17 = d(input, playerTime) + 1;
        arrayList2.addAll(d17, d16);
        return new WinkClipOpCalcResult(arrayList2, c(this, input, d17, false, 4, null));
    }

    public final long b(@NotNull List<? extends MediaClip> input, int index, boolean isStart) {
        int coerceIn;
        Iterable<IndexedValue> withIndex;
        long j3;
        Intrinsics.checkNotNullParameter(input, "input");
        coerceIn = RangesKt___RangesKt.coerceIn(index, 0, input.size());
        withIndex = CollectionsKt___CollectionsKt.withIndex(input);
        long j16 = 0;
        for (IndexedValue indexedValue : withIndex) {
            if (!isStart || indexedValue.getIndex() < coerceIn) {
                if (isStart || indexedValue.getIndex() <= coerceIn) {
                    ResourceModel resourceModel = ((MediaClip) indexedValue.getValue()).resource;
                    if (resourceModel != null) {
                        j3 = resourceModel.scaleDuration;
                    } else {
                        j3 = 0;
                    }
                    j16 += j3;
                }
            }
        }
        return j16;
    }

    @NotNull
    public final WinkClipOpCalcResult g(@NotNull List<? extends MediaClip> input, @NotNull SelectItem<?> selectItem) {
        Object obj;
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(selectItem, "selectItem");
        ArrayList arrayList = new ArrayList(input);
        Iterator it = arrayList.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            ResourceModel resourceModel = ((MediaClip) next).resource;
            if (resourceModel != null) {
                obj = resourceModel.id;
            }
            if (Intrinsics.areEqual(obj, selectItem.getId())) {
                obj = next;
                break;
            }
        }
        MediaClip mediaClip = (MediaClip) obj;
        int indexOf = arrayList.indexOf(mediaClip);
        if (mediaClip != null) {
            arrayList.remove(mediaClip);
        }
        return new WinkClipOpCalcResult(arrayList, b(arrayList, indexOf, true));
    }

    @NotNull
    public final WinkClipOpCalcResult h(@NotNull List<? extends MediaClip> input, @NotNull SelectItem<?> selectItem, long j3) {
        Object obj;
        ResourceModel resourceModel;
        boolean z16;
        ResourceModel copy;
        ResourceModel copy2;
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(selectItem, "selectItem");
        ArrayList arrayList = new ArrayList(input);
        Iterator it = arrayList.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            ResourceModel resourceModel2 = ((MediaClip) next).resource;
            if (resourceModel2 != null) {
                obj = resourceModel2.id;
            }
            if (Intrinsics.areEqual(obj, selectItem.getId())) {
                obj = next;
                break;
            }
        }
        MediaClip mediaClip = (MediaClip) obj;
        int indexOf = arrayList.indexOf(mediaClip);
        if (mediaClip != null && (resourceModel = mediaClip.resource) != null) {
            long e16 = e(arrayList, j3);
            long j16 = resourceModel.selectDuration;
            long j17 = resourceModel.scaleDuration;
            double d16 = (j16 * 1.0d) / j17;
            double d17 = e16 * d16;
            long j18 = (long) d17;
            long j19 = j17 - e16;
            long j26 = (long) (j19 * d16);
            if (f(arrayList, selectItem) == MediaType.VIDEO) {
                z16 = true;
            } else {
                z16 = false;
            }
            long j27 = resourceModel.selectStart;
            if (z16) {
                j27 = (long) (j27 + d17);
            }
            copy = resourceModel.copy((r35 & 1) != 0 ? resourceModel.id : a.a(resourceModel.id), (r35 & 2) != 0 ? resourceModel.path : null, (r35 & 4) != 0 ? Long.valueOf(resourceModel.scaleDuration) : Long.valueOf(j19), (r35 & 8) != 0 ? Long.valueOf(resourceModel.sourceStart) : null, (r35 & 16) != 0 ? Long.valueOf(resourceModel.sourceDuration) : null, (r35 & 32) != 0 ? Long.valueOf(resourceModel.selectStart) : Long.valueOf(j27), (r35 & 64) != 0 ? Long.valueOf(resourceModel.selectDuration) : Long.valueOf(j26), (r35 & 128) != 0 ? resourceModel.type : null, (r35 & 256) != 0 ? resourceModel.size : null, (r35 & 512) != 0 ? Float.valueOf(resourceModel.volume) : null, (r35 & 1024) != 0 ? resourceModel.extras : null, (r35 & 2048) != 0 ? resourceModel.picClipRect : null, (r35 & 4096) != 0 ? resourceModel.reversePath : null, (r35 & 8192) != 0 ? resourceModel.normalPath : null, (r35 & 16384) != 0 ? resourceModel.isReverseMode : null, (r35 & 32768) != 0 ? Float.valueOf(resourceModel.deblurScore) : null, (r35 & 65536) != 0 ? resourceModel.unknownFields() : null);
            MediaClip copy$default = MediaClip.copy$default(mediaClip, copy, null, null, null, null, null, null, 126, null);
            copy2 = resourceModel.copy((r35 & 1) != 0 ? resourceModel.id : null, (r35 & 2) != 0 ? resourceModel.path : null, (r35 & 4) != 0 ? Long.valueOf(resourceModel.scaleDuration) : Long.valueOf(e16), (r35 & 8) != 0 ? Long.valueOf(resourceModel.sourceStart) : null, (r35 & 16) != 0 ? Long.valueOf(resourceModel.sourceDuration) : null, (r35 & 32) != 0 ? Long.valueOf(resourceModel.selectStart) : null, (r35 & 64) != 0 ? Long.valueOf(resourceModel.selectDuration) : Long.valueOf(j18), (r35 & 128) != 0 ? resourceModel.type : null, (r35 & 256) != 0 ? resourceModel.size : null, (r35 & 512) != 0 ? Float.valueOf(resourceModel.volume) : null, (r35 & 1024) != 0 ? resourceModel.extras : null, (r35 & 2048) != 0 ? resourceModel.picClipRect : null, (r35 & 4096) != 0 ? resourceModel.reversePath : null, (r35 & 8192) != 0 ? resourceModel.normalPath : null, (r35 & 16384) != 0 ? resourceModel.isReverseMode : null, (r35 & 32768) != 0 ? Float.valueOf(resourceModel.deblurScore) : null, (r35 & 65536) != 0 ? resourceModel.unknownFields() : null);
            arrayList.set(indexOf, MediaClip.copy$default(mediaClip, copy2, null, null, null, null, null, null, 126, null));
            arrayList.add(indexOf + 1, copy$default);
            return new WinkClipOpCalcResult(arrayList, j3);
        }
        return new WinkClipOpCalcResult(arrayList, j3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x006d, code lost:
    
        r4 = r10.copy((r35 & 1) != 0 ? r10.id : null, (r35 & 2) != 0 ? r10.path : null, (r35 & 4) != 0 ? java.lang.Long.valueOf(r10.scaleDuration) : java.lang.Long.valueOf(r7), (r35 & 8) != 0 ? java.lang.Long.valueOf(r10.sourceStart) : null, (r35 & 16) != 0 ? java.lang.Long.valueOf(r10.sourceDuration) : null, (r35 & 32) != 0 ? java.lang.Long.valueOf(r10.selectStart) : null, (r35 & 64) != 0 ? java.lang.Long.valueOf(r10.selectDuration) : null, (r35 & 128) != 0 ? r10.type : null, (r35 & 256) != 0 ? r10.size : null, (r35 & 512) != 0 ? java.lang.Float.valueOf(r10.volume) : null, (r35 & 1024) != 0 ? r10.extras : null, (r35 & 2048) != 0 ? r10.picClipRect : null, (r35 & 4096) != 0 ? r10.reversePath : null, (r35 & 8192) != 0 ? r10.normalPath : null, (r35 & 16384) != 0 ? r10.isReverseMode : null, (r35 & 32768) != 0 ? java.lang.Float.valueOf(r10.deblurScore) : null, (r35 & 65536) != 0 ? r10.unknownFields() : null);
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final WinkClipOpCalcResult i(@NotNull List<? extends MediaClip> input, @Nullable SelectItem<?> selectItem, float speed) {
        Iterable<IndexedValue> withIndex;
        int collectionSizeOrDefault;
        String str;
        String str2;
        MediaClip mediaClip;
        ResourceModel copy;
        Intrinsics.checkNotNullParameter(input, "input");
        withIndex = CollectionsKt___CollectionsKt.withIndex(input);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(withIndex, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        int i3 = -1;
        for (IndexedValue indexedValue : withIndex) {
            ResourceModel resourceModel = ((MediaClip) indexedValue.getValue()).resource;
            ResourceModel resourceModel2 = null;
            if (resourceModel != null) {
                str = resourceModel.id;
            } else {
                str = null;
            }
            if (selectItem != null) {
                str2 = selectItem.getId();
            } else {
                str2 = null;
            }
            if (Intrinsics.areEqual(str, str2)) {
                ResourceModel resourceModel3 = ((MediaClip) indexedValue.getValue()).resource;
                if (resourceModel3 != null) {
                    long j3 = ((float) resourceModel3.selectDuration) / speed;
                    i3 = indexedValue.getIndex();
                    MediaClip mediaClip2 = (MediaClip) indexedValue.getValue();
                    ResourceModel resourceModel4 = ((MediaClip) indexedValue.getValue()).resource;
                    if (resourceModel4 != null && copy != null) {
                        resourceModel2 = com.tencent.mobileqq.wink.editor.clipping.a.a(copy, false);
                    }
                    mediaClip = MediaClip.copy$default(mediaClip2, resourceModel2, null, null, null, null, null, null, 126, null);
                    if (mediaClip != null) {
                    }
                }
                mediaClip = (MediaClip) indexedValue.getValue();
            } else {
                mediaClip = (MediaClip) indexedValue.getValue();
            }
            arrayList.add(mediaClip);
        }
        return new WinkClipOpCalcResult(arrayList, c(this, input, i3, false, 4, null));
    }
}
