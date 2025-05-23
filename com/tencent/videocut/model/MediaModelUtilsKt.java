package com.tencent.videocut.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a6\u0010\u0006\u001a\u00020\u0003*\u00020\u00032\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n`\u000b2\u0006\u0010\f\u001a\u00020\u0005\u00a8\u0006\r"}, d2 = {"getClipsMinusTransformTime", "", "Lcom/tencent/videocut/model/MediaClip;", "Lcom/tencent/videocut/model/MediaModel;", "enableTransform", "", "updateHDRClips", "inputMap", "Ljava/util/HashMap;", "", "Lcom/tencent/videocut/model/HDRModel;", "Lkotlin/collections/HashMap;", "useHDR", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class MediaModelUtilsKt {
    @NotNull
    public static final List<MediaClip> getClipsMinusTransformTime(@NotNull MediaModel mediaModel, boolean z16) {
        long j3;
        ResourceModel resourceModel;
        Intrinsics.checkNotNullParameter(mediaModel, "<this>");
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (Object obj : mediaModel.videos) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            MediaClip mediaClip = (MediaClip) obj;
            if (z16) {
                if (i3 != 0 && i3 != mediaModel.videos.size() - 1) {
                    j3 = 1000000;
                } else {
                    j3 = 500000;
                }
                ResourceModel resourceModel2 = mediaClip.resource;
                if (resourceModel2 != null) {
                    long j16 = resourceModel2.selectDuration;
                    resourceModel = resourceModel2.copy((r35 & 1) != 0 ? resourceModel2.id : null, (r35 & 2) != 0 ? resourceModel2.path : null, (r35 & 4) != 0 ? Long.valueOf(resourceModel2.scaleDuration) : Long.valueOf(j16 - j3), (r35 & 8) != 0 ? Long.valueOf(resourceModel2.sourceStart) : null, (r35 & 16) != 0 ? Long.valueOf(resourceModel2.sourceDuration) : Long.valueOf(j16 - j3), (r35 & 32) != 0 ? Long.valueOf(resourceModel2.selectStart) : null, (r35 & 64) != 0 ? Long.valueOf(resourceModel2.selectDuration) : Long.valueOf(j16 - j3), (r35 & 128) != 0 ? resourceModel2.type : null, (r35 & 256) != 0 ? resourceModel2.size : null, (r35 & 512) != 0 ? Float.valueOf(resourceModel2.volume) : null, (r35 & 1024) != 0 ? resourceModel2.extras : null, (r35 & 2048) != 0 ? resourceModel2.picClipRect : null, (r35 & 4096) != 0 ? resourceModel2.reversePath : null, (r35 & 8192) != 0 ? resourceModel2.normalPath : null, (r35 & 16384) != 0 ? resourceModel2.isReverseMode : null, (r35 & 32768) != 0 ? Float.valueOf(resourceModel2.deblurScore) : null, (r35 & 65536) != 0 ? resourceModel2.unknownFields() : null);
                } else {
                    resourceModel = null;
                }
                mediaClip = MediaClip.copy$default(mediaClip, resourceModel, null, null, null, null, null, null, 126, null);
            }
            arrayList.add(mediaClip);
            i3 = i16;
        }
        return arrayList;
    }

    @NotNull
    public static final MediaModel updateHDRClips(@NotNull MediaModel mediaModel, @NotNull HashMap<String, HDRModel> inputMap, boolean z16) {
        MediaModel copy;
        MediaModel copy2;
        String str;
        String str2;
        boolean equals$default;
        ResourceModel resourceModel;
        ResourceModel copy3;
        Intrinsics.checkNotNullParameter(mediaModel, "<this>");
        Intrinsics.checkNotNullParameter(inputMap, "inputMap");
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (MediaClip mediaClip : mediaModel.videos) {
            ResourceModel resourceModel2 = mediaClip.resource;
            ResourceModel resourceModel3 = null;
            if (resourceModel2 != null) {
                str = resourceModel2.path;
            } else {
                str = null;
            }
            if (z16) {
                if (resourceModel2 != null) {
                    str2 = resourceModel2.path;
                } else {
                    str2 = null;
                }
                HDRModel hDRModel = inputMap.get(str2);
                if (hDRModel != null) {
                    String str3 = hDRModel.hdrVideoPath;
                    ResourceModel resourceModel4 = mediaClip.resource;
                    if (resourceModel4 != null) {
                        resourceModel3 = resourceModel4.copy((r35 & 1) != 0 ? resourceModel4.id : null, (r35 & 2) != 0 ? resourceModel4.path : str3, (r35 & 4) != 0 ? Long.valueOf(resourceModel4.scaleDuration) : null, (r35 & 8) != 0 ? Long.valueOf(resourceModel4.sourceStart) : null, (r35 & 16) != 0 ? Long.valueOf(resourceModel4.sourceDuration) : null, (r35 & 32) != 0 ? Long.valueOf(resourceModel4.selectStart) : null, (r35 & 64) != 0 ? Long.valueOf(resourceModel4.selectDuration) : null, (r35 & 128) != 0 ? resourceModel4.type : null, (r35 & 256) != 0 ? resourceModel4.size : null, (r35 & 512) != 0 ? Float.valueOf(resourceModel4.volume) : null, (r35 & 1024) != 0 ? resourceModel4.extras : null, (r35 & 2048) != 0 ? resourceModel4.picClipRect : null, (r35 & 4096) != 0 ? resourceModel4.reversePath : null, (r35 & 8192) != 0 ? resourceModel4.normalPath : null, (r35 & 16384) != 0 ? resourceModel4.isReverseMode : null, (r35 & 32768) != 0 ? Float.valueOf(resourceModel4.deblurScore) : null, (r35 & 65536) != 0 ? resourceModel4.unknownFields() : null);
                    }
                    arrayList.add(MediaClip.copy$default(mediaClip, resourceModel3, null, null, null, null, null, null, 126, null));
                    linkedHashMap.put(hDRModel.originVideoPath, hDRModel);
                } else {
                    arrayList.add(mediaClip);
                }
            } else {
                boolean z17 = false;
                for (Map.Entry<String, HDRModel> entry : inputMap.entrySet()) {
                    equals$default = StringsKt__StringsJVMKt.equals$default(str, entry.getValue().hdrVideoPath, false, 2, null);
                    if (equals$default) {
                        String key = entry.getKey();
                        ResourceModel resourceModel5 = mediaClip.resource;
                        if (resourceModel5 != null) {
                            copy3 = resourceModel5.copy((r35 & 1) != 0 ? resourceModel5.id : null, (r35 & 2) != 0 ? resourceModel5.path : key, (r35 & 4) != 0 ? Long.valueOf(resourceModel5.scaleDuration) : null, (r35 & 8) != 0 ? Long.valueOf(resourceModel5.sourceStart) : null, (r35 & 16) != 0 ? Long.valueOf(resourceModel5.sourceDuration) : null, (r35 & 32) != 0 ? Long.valueOf(resourceModel5.selectStart) : null, (r35 & 64) != 0 ? Long.valueOf(resourceModel5.selectDuration) : null, (r35 & 128) != 0 ? resourceModel5.type : null, (r35 & 256) != 0 ? resourceModel5.size : null, (r35 & 512) != 0 ? Float.valueOf(resourceModel5.volume) : null, (r35 & 1024) != 0 ? resourceModel5.extras : null, (r35 & 2048) != 0 ? resourceModel5.picClipRect : null, (r35 & 4096) != 0 ? resourceModel5.reversePath : null, (r35 & 8192) != 0 ? resourceModel5.normalPath : null, (r35 & 16384) != 0 ? resourceModel5.isReverseMode : null, (r35 & 32768) != 0 ? Float.valueOf(resourceModel5.deblurScore) : null, (r35 & 65536) != 0 ? resourceModel5.unknownFields() : null);
                            resourceModel = copy3;
                        } else {
                            resourceModel = null;
                        }
                        arrayList.add(MediaClip.copy$default(mediaClip, resourceModel, null, null, null, null, null, null, 126, null));
                        z17 = true;
                    }
                }
                if (!z17) {
                    arrayList.add(mediaClip);
                }
            }
        }
        if (z16) {
            copy2 = mediaModel.copy((r39 & 1) != 0 ? mediaModel.id : null, (r39 & 2) != 0 ? mediaModel.name : null, (r39 & 4) != 0 ? mediaModel.version : null, (r39 & 8) != 0 ? mediaModel.createTime : null, (r39 & 16) != 0 ? mediaModel.updateTime : null, (r39 & 32) != 0 ? mediaModel.duration : null, (r39 & 64) != 0 ? mediaModel.videos : arrayList, (r39 & 128) != 0 ? mediaModel.audios : null, (r39 & 256) != 0 ? mediaModel.stickers : null, (r39 & 512) != 0 ? mediaModel.backgroundModel : null, (r39 & 1024) != 0 ? mediaModel.filterModels : null, (r39 & 2048) != 0 ? mediaModel.specialEffects : null, (r39 & 4096) != 0 ? mediaModel.transitions : null, (r39 & 8192) != 0 ? mediaModel.templateModel : null, (r39 & 16384) != 0 ? mediaModel.coverInfo : null, (r39 & 32768) != 0 ? mediaModel.exportSetting : null, (r39 & 65536) != 0 ? mediaModel.openHDR : null, (r39 & 131072) != 0 ? mediaModel.hdrModels : linkedHashMap, (r39 & 262144) != 0 ? mediaModel.smoothModels : null, (r39 & 524288) != 0 ? mediaModel.openSuperHDR : null, (r39 & 1048576) != 0 ? mediaModel.unknownFields() : null);
            return copy2;
        }
        copy = mediaModel.copy((r39 & 1) != 0 ? mediaModel.id : null, (r39 & 2) != 0 ? mediaModel.name : null, (r39 & 4) != 0 ? mediaModel.version : null, (r39 & 8) != 0 ? mediaModel.createTime : null, (r39 & 16) != 0 ? mediaModel.updateTime : null, (r39 & 32) != 0 ? mediaModel.duration : null, (r39 & 64) != 0 ? mediaModel.videos : arrayList, (r39 & 128) != 0 ? mediaModel.audios : null, (r39 & 256) != 0 ? mediaModel.stickers : null, (r39 & 512) != 0 ? mediaModel.backgroundModel : null, (r39 & 1024) != 0 ? mediaModel.filterModels : null, (r39 & 2048) != 0 ? mediaModel.specialEffects : null, (r39 & 4096) != 0 ? mediaModel.transitions : null, (r39 & 8192) != 0 ? mediaModel.templateModel : null, (r39 & 16384) != 0 ? mediaModel.coverInfo : null, (r39 & 32768) != 0 ? mediaModel.exportSetting : null, (r39 & 65536) != 0 ? mediaModel.openHDR : null, (r39 & 131072) != 0 ? mediaModel.hdrModels : null, (r39 & 262144) != 0 ? mediaModel.smoothModels : null, (r39 & 524288) != 0 ? mediaModel.openSuperHDR : null, (r39 & 1048576) != 0 ? mediaModel.unknownFields() : null);
        return copy;
    }
}
