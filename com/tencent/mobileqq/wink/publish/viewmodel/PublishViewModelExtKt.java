package com.tencent.mobileqq.wink.publish.viewmodel;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.wink.editor.WinkImageTavCut;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.picker.MediaData;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/viewmodel/PublishViewModel;", "", "b", "qq-wink-temp-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class PublishViewModelExtKt {
    public static final void b(@NotNull final PublishViewModel publishViewModel) {
        String str;
        String joinToString$default;
        Intrinsics.checkNotNullParameter(publishViewModel, "<this>");
        if (!publishViewModel.I0) {
            return;
        }
        ArrayList<String> arrayList = publishViewModel.f326012m;
        if (arrayList != null) {
            str = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ",", null, null, 0, null, null, 62, null);
        } else {
            str = null;
        }
        ArrayList<LocalMediaInfo> mediaInfos = publishViewModel.D;
        Intrinsics.checkNotNullExpressionValue(mediaInfos, "mediaInfos");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(mediaInfos, ",", null, null, 0, null, new Function1<LocalMediaInfo, CharSequence>() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.PublishViewModelExtKt$updateEditDataIfNeed$currentMediaPathsStr$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(LocalMediaInfo localMediaInfo) {
                String str2 = localMediaInfo.path;
                Intrinsics.checkNotNullExpressionValue(str2, "it.path");
                return str2;
            }
        }, 30, null);
        if (Intrinsics.areEqual(joinToString$default, str)) {
            return;
        }
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.ai
            @Override // java.lang.Runnable
            public final void run() {
                PublishViewModelExtKt.c(PublishViewModel.this);
            }
        }, 64, null, false, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(PublishViewModel this_updateEditDataIfNeed) {
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        int collectionSizeOrDefault2;
        int collectionSizeOrDefault3;
        int mapCapacity2;
        int coerceAtLeast2;
        int collectionSizeOrDefault4;
        List<MediaData> listOf;
        Object first;
        String str;
        Intrinsics.checkNotNullParameter(this_updateEditDataIfNeed, "$this_updateEditDataIfNeed");
        try {
            WinkEditDataWrapper c16 = com.tencent.mobileqq.wink.editor.draft.a.c(this_updateEditDataIfNeed.i2());
            if (c16 == null) {
                return;
            }
            ArrayList<LocalMediaInfo> originMediaInfos = c16.getOriginMediaInfos();
            Intrinsics.checkNotNull(originMediaInfos);
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(originMediaInfos, 10);
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
            LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
            for (Object obj : originMediaInfos) {
                linkedHashMap.put(((LocalMediaInfo) obj).path, (LocalMediaInfo) obj);
            }
            ArrayList<LocalMediaInfo> mediaInfos = this_updateEditDataIfNeed.D;
            Intrinsics.checkNotNullExpressionValue(mediaInfos, "mediaInfos");
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(mediaInfos, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault2);
            for (LocalMediaInfo localMediaInfo : mediaInfos) {
                LocalMediaInfo localMediaInfo2 = (LocalMediaInfo) linkedHashMap.get(localMediaInfo.path);
                if (localMediaInfo2 != null) {
                    localMediaInfo = localMediaInfo2;
                }
                arrayList.add(localMediaInfo);
            }
            ArrayList<WinkEditData> editDatas = c16.getEditDatas();
            collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(editDatas, 10);
            mapCapacity2 = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault3);
            coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(mapCapacity2, 16);
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(coerceAtLeast2);
            for (Object obj2 : editDatas) {
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) ((WinkEditData) obj2).getMediaModel().videos);
                ResourceModel resourceModel = ((MediaClip) first).resource;
                if (resourceModel != null) {
                    str = resourceModel.path;
                } else {
                    str = null;
                }
                linkedHashMap2.put(str, (WinkEditData) obj2);
            }
            ArrayList<LocalMediaInfo> mediaInfos2 = this_updateEditDataIfNeed.D;
            Intrinsics.checkNotNullExpressionValue(mediaInfos2, "mediaInfos");
            collectionSizeOrDefault4 = CollectionsKt__IterablesKt.collectionSizeOrDefault(mediaInfos2, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault4);
            for (LocalMediaInfo it : mediaInfos2) {
                WinkEditData winkEditData = (WinkEditData) linkedHashMap2.get(it.path);
                if (winkEditData == null) {
                    WinkImageTavCut.Companion companion = WinkImageTavCut.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(e93.i.d(it, 10000000L));
                    winkEditData = companion.a(listOf);
                }
                arrayList2.add(winkEditData);
            }
            com.tencent.mobileqq.wink.editor.draft.a.h(WinkEditDataWrapper.copy$default(c16, null, null, new ArrayList(arrayList2), new ArrayList(arrayList), null, null, null, 0L, false, null, null, false, 0, 0.0f, 0.0f, null, false, null, null, false, 0L, null, null, false, 0L, false, null, false, null, false, null, 0, null, false, false, null, false, false, false, null, null, null, null, false, -13, 4095, null), this_updateEditDataIfNeed.i2());
        } catch (Exception e16) {
            w53.b.e(PublishViewModel.N0, e16);
        }
    }
}
