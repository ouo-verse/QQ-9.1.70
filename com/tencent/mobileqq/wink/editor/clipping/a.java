package com.tencent.mobileqq.wink.editor.clipping;

import com.tencent.mobileqq.wink.editor.clipping.thumbnail.ThumbAssetModel;
import com.tencent.videocut.model.MediaType;
import com.tencent.videocut.model.ResourceModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\u0012\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003\u001a\n\u0010\u0006\u001a\u00020\u0003*\u00020\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/videocut/model/ResourceModel;", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/i;", "c", "", "value", "a", "b", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {
    @NotNull
    public static final ResourceModel a(@NotNull ResourceModel resourceModel, boolean z16) {
        Map mutableMap;
        String str;
        ResourceModel copy;
        Intrinsics.checkNotNullParameter(resourceModel, "<this>");
        mutableMap = MapsKt__MapsKt.toMutableMap(resourceModel.extras);
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        mutableMap.put("change_speed_passive", str);
        Unit unit = Unit.INSTANCE;
        copy = resourceModel.copy((r35 & 1) != 0 ? resourceModel.id : null, (r35 & 2) != 0 ? resourceModel.path : null, (r35 & 4) != 0 ? Long.valueOf(resourceModel.scaleDuration) : null, (r35 & 8) != 0 ? Long.valueOf(resourceModel.sourceStart) : null, (r35 & 16) != 0 ? Long.valueOf(resourceModel.sourceDuration) : null, (r35 & 32) != 0 ? Long.valueOf(resourceModel.selectStart) : null, (r35 & 64) != 0 ? Long.valueOf(resourceModel.selectDuration) : null, (r35 & 128) != 0 ? resourceModel.type : null, (r35 & 256) != 0 ? resourceModel.size : null, (r35 & 512) != 0 ? Float.valueOf(resourceModel.volume) : null, (r35 & 1024) != 0 ? resourceModel.extras : mutableMap, (r35 & 2048) != 0 ? resourceModel.picClipRect : null, (r35 & 4096) != 0 ? resourceModel.reversePath : null, (r35 & 8192) != 0 ? resourceModel.normalPath : null, (r35 & 16384) != 0 ? resourceModel.isReverseMode : null, (r35 & 32768) != 0 ? Float.valueOf(resourceModel.deblurScore) : null, (r35 & 65536) != 0 ? resourceModel.unknownFields() : null);
        return copy;
    }

    public static final boolean b(@NotNull ResourceModel resourceModel) {
        Intrinsics.checkNotNullParameter(resourceModel, "<this>");
        return Intrinsics.areEqual(resourceModel.extras.get("change_speed_passive"), "1");
    }

    @NotNull
    public static final ThumbAssetModel c(@NotNull ResourceModel resourceModel) {
        int i3;
        Intrinsics.checkNotNullParameter(resourceModel, "<this>");
        String str = resourceModel.path;
        MediaType mediaType = resourceModel.type;
        if (mediaType != null) {
            i3 = mediaType.ordinal();
        } else {
            i3 = 0;
        }
        return new ThumbAssetModel(str, i3, resourceModel.sourceDuration);
    }
}
