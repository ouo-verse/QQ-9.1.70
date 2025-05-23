package com.tencent.mobileqq.wink.editor.hdr;

import com.tencent.videocut.model.HDRModel;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.ResourceModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u001e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0005"}, d2 = {"", "Lcom/tencent/videocut/model/MediaClip;", "", "hdrOpen", "a", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class f {
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0059, code lost:
    
        if (r2 != false) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008d A[SYNTHETIC] */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final List<MediaClip> a(@NotNull List<? extends MediaClip> list, boolean z16) {
        int collectionSizeOrDefault;
        String str;
        boolean z17;
        ResourceModel copy;
        boolean isBlank;
        boolean isBlank2;
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<? extends MediaClip> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (MediaClip mediaClip : list2) {
            if (z16) {
                ResourceModel resourceModel = mediaClip.resource;
                String str2 = null;
                if (resourceModel != null) {
                    str = resourceModel.path;
                } else {
                    str = null;
                }
                boolean z18 = false;
                if (str != null) {
                    isBlank2 = StringsKt__StringsJVMKt.isBlank(str);
                    if (!isBlank2) {
                        z17 = false;
                        if (!z17) {
                            HDRModel b16 = WinkHDRCacheManager.INSTANCE.a().b(str);
                            if (b16 != null) {
                                str2 = b16.hdrVideoPath;
                            }
                            String str3 = str2;
                            if (str3 != null) {
                                isBlank = StringsKt__StringsJVMKt.isBlank(str3);
                            }
                            z18 = true;
                            if (!z18) {
                                copy = r7.copy((r35 & 1) != 0 ? r7.id : null, (r35 & 2) != 0 ? r7.path : str3, (r35 & 4) != 0 ? Long.valueOf(r7.scaleDuration) : null, (r35 & 8) != 0 ? Long.valueOf(r7.sourceStart) : null, (r35 & 16) != 0 ? Long.valueOf(r7.sourceDuration) : null, (r35 & 32) != 0 ? Long.valueOf(r7.selectStart) : null, (r35 & 64) != 0 ? Long.valueOf(r7.selectDuration) : null, (r35 & 128) != 0 ? r7.type : null, (r35 & 256) != 0 ? r7.size : null, (r35 & 512) != 0 ? Float.valueOf(r7.volume) : null, (r35 & 1024) != 0 ? r7.extras : null, (r35 & 2048) != 0 ? r7.picClipRect : null, (r35 & 4096) != 0 ? r7.reversePath : null, (r35 & 8192) != 0 ? r7.normalPath : null, (r35 & 16384) != 0 ? r7.isReverseMode : null, (r35 & 32768) != 0 ? Float.valueOf(r7.deblurScore) : null, (r35 & 65536) != 0 ? mediaClip.resource.unknownFields() : null);
                                mediaClip = MediaClip.copy$default(mediaClip, copy, null, null, null, null, null, null, 126, null);
                            }
                        }
                    }
                }
                z17 = true;
                if (!z17) {
                }
            }
            arrayList.add(mediaClip);
        }
        return arrayList;
    }
}
