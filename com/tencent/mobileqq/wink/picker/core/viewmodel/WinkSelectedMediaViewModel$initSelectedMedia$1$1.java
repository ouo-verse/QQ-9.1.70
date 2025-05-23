package com.tencent.mobileqq.wink.picker.core.viewmodel;

import android.os.Handler;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.wink.picker.MediaInfo;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class WinkSelectedMediaViewModel$initSelectedMedia$1$1 extends Lambda implements Function1<List<? extends LocalMediaInfo>, Unit> {
    final /* synthetic */ List<String> $localMediaPaths;
    final /* synthetic */ List<LocalMediaInfo> $qZoneMedia;
    final /* synthetic */ List<LocalMediaInfo> $tempCapturedMedia;
    final /* synthetic */ WinkSelectedMediaViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WinkSelectedMediaViewModel$initSelectedMedia$1$1(List<? extends LocalMediaInfo> list, List<? extends LocalMediaInfo> list2, WinkSelectedMediaViewModel winkSelectedMediaViewModel, List<String> list3) {
        super(1);
        this.$qZoneMedia = list;
        this.$tempCapturedMedia = list2;
        this.this$0 = winkSelectedMediaViewModel;
        this.$localMediaPaths = list3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(List qZoneMedia, List tempCapturedMedia, WinkSelectedMediaViewModel this$0, List it, List localMediaPaths) {
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        int collectionSizeOrDefault2;
        int mapCapacity2;
        int coerceAtLeast2;
        List list;
        LocalMediaInfo localMediaInfo;
        List list2;
        MutableLiveData mutableLiveData;
        List list3;
        List list4;
        List U1;
        List list5;
        Intrinsics.checkNotNullParameter(qZoneMedia, "$qZoneMedia");
        Intrinsics.checkNotNullParameter(tempCapturedMedia, "$tempCapturedMedia");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(localMediaPaths, "$localMediaPaths");
        if (qZoneMedia.isEmpty()) {
            if (tempCapturedMedia.isEmpty()) {
                list5 = this$0._selectedMedia;
                list5.addAll(it);
            } else {
                list4 = this$0._selectedMedia;
                U1 = this$0.U1(localMediaPaths, it, tempCapturedMedia);
                list4.addAll(U1);
            }
        } else {
            List list6 = it;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list6, 10);
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
            LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
            for (Object obj : list6) {
                linkedHashMap.put(((LocalMediaInfo) obj).path, obj);
            }
            List list7 = qZoneMedia;
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list7, 10);
            mapCapacity2 = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault2);
            coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(mapCapacity2, 16);
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(coerceAtLeast2);
            for (Object obj2 : list7) {
                linkedHashMap2.put(e93.i.v((LocalMediaInfo) obj2), obj2);
            }
            for (MediaInfo mediaInfo : com.tencent.mobileqq.wink.picker.core.c.f324480a.b().getAlreadySelectedMedia()) {
                if (mediaInfo.getMediaType().isLocalMedia()) {
                    LocalMediaInfo localMediaInfo2 = (LocalMediaInfo) linkedHashMap.get(mediaInfo.getLocalMediaPath());
                    if (localMediaInfo2 != null) {
                        list = this$0._selectedMedia;
                        list.add(localMediaInfo2);
                    }
                } else if (mediaInfo.getMediaType().isQZoneMedia() && (localMediaInfo = (LocalMediaInfo) linkedHashMap2.get(mediaInfo.getQZoneMediaId())) != null) {
                    list2 = this$0._selectedMedia;
                    list2.add(localMediaInfo);
                }
            }
        }
        mutableLiveData = this$0._selectedMediaChangedActionMutableLiveData;
        list3 = this$0._selectedMedia;
        mutableLiveData.setValue(new e93.d(list3));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends LocalMediaInfo> list) {
        invoke2(list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull final List<? extends LocalMediaInfo> it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final List<LocalMediaInfo> list = this.$qZoneMedia;
        final List<LocalMediaInfo> list2 = this.$tempCapturedMedia;
        final WinkSelectedMediaViewModel winkSelectedMediaViewModel = this.this$0;
        final List<String> list3 = this.$localMediaPaths;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.core.viewmodel.w
            @Override // java.lang.Runnable
            public final void run() {
                WinkSelectedMediaViewModel$initSelectedMedia$1$1.b(list, list2, winkSelectedMediaViewModel, it, list3);
            }
        });
    }
}
