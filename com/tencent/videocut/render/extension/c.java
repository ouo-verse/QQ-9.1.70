package com.tencent.videocut.render.extension;

import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.tavcut.core.render.builder.light.model.InputSource;
import com.tencent.videocut.model.FilterModel;
import com.tencent.videocut.model.LutFilterModel;
import com.tencent.videocut.render.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.components.Component;
import org.light.lightAssetKit.components.TimeOffset;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0012\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/videocut/model/FilterModel;", "", "isVideoTrackFilter", "Lcom/tencent/videocut/render/f;", "b", "Lcom/tencent/videocut/render/l;", "a", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class c {
    @NotNull
    public static final l a(@NotNull FilterModel filterModel, boolean z16) {
        String str;
        List<? extends Component> emptyList;
        Intrinsics.checkNotNullParameter(filterModel, "<this>");
        rd4.c cVar = rd4.c.f431135f;
        td4.f q16 = cVar.q();
        if (z16) {
            str = "videoTrackColorFilter";
        } else {
            str = CustomAnimation.KeyPath.COLOR_FILTER;
        }
        if (filterModel.color == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return new l(q16.a(str, emptyList), new InputSource(null, null, null, null, null, null, null, null, null, null, null, 2047, null), null, 4, null);
        }
        td4.e o16 = cVar.o();
        ArrayList arrayList = new ArrayList();
        if (!z16) {
            arrayList.add(o16.e(filterModel.startTimeUs, filterModel.durationUs));
        }
        return new l(q16.a(str, arrayList), new InputSource(filterModel.id, null, null, null, null, null, null, null, null, null, null, 2046, null), null, 4, null);
    }

    @NotNull
    public static final com.tencent.videocut.render.f b(@NotNull FilterModel filterModel, boolean z16) {
        String str;
        List listOf;
        Intrinsics.checkNotNullParameter(filterModel, "<this>");
        rd4.c cVar = rd4.c.f431135f;
        td4.f q16 = cVar.q();
        if (z16) {
            str = "videoTrackLutFilter";
        } else {
            str = "lutFilter";
        }
        LutFilterModel lutFilterModel = filterModel.lut;
        if (lutFilterModel != null) {
            td4.e o16 = cVar.o();
            InputSource b16 = cVar.r().b(lutFilterModel.filePath, filterModel.id);
            ArrayList arrayList = new ArrayList();
            if (!z16) {
                TimeOffset e16 = o16.e(filterModel.startTimeUs, filterModel.durationUs);
                long j3 = filterModel.durationUs;
                long j16 = 0;
                if (j3 >= 0) {
                    j16 = filterModel.startTimeUs + j3;
                }
                e16.setEndOffset(j16);
                arrayList.add(e16);
            }
            arrayList.add(o16.f(b16.getKey(), lutFilterModel.intensity / 100.0f));
            Entity a16 = q16.a(str, arrayList);
            listOf = CollectionsKt__CollectionsJVMKt.listOf(b16);
            return new com.tencent.videocut.render.f(a16, listOf, null, false, 12, null);
        }
        return com.tencent.videocut.render.f.INSTANCE.a();
    }
}
