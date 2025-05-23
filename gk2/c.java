package gk2;

import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.ColorFilterModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.FilterModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.LutFilterModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.RenderData;
import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0012\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/FilterModel;", "", "isVideoTrackFilter", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/q;", "b", "a", "qqvideoedit_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class c {
    @NotNull
    public static final RenderData a(@NotNull FilterModel filterModel, boolean z16) {
        String str;
        List<IdentifyComponent> emptyList;
        Intrinsics.checkNotNullParameter(filterModel, "<this>");
        od4.b bVar = od4.b.f422509e;
        xd4.f p16 = bVar.p();
        if (z16) {
            str = "videoTrackColorFilter";
        } else {
            str = CustomAnimation.KeyPath.COLOR_FILTER;
        }
        ColorFilterModel colorFilterModel = filterModel.color;
        if (colorFilterModel == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return new RenderData(p16.a(str, emptyList), new InputSource(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null), null, 4, null);
        }
        xd4.e n3 = bVar.n();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new IdentifyComponent(n3.m()));
        if (!z16) {
            arrayList.add(new IdentifyComponent(n3.e(filterModel.startTimeUs, filterModel.durationUs)));
        }
        arrayList.add(new IdentifyComponent(n3.l(colorFilterModel.sharpness, colorFilterModel.brightness, colorFilterModel.contrast, colorFilterModel.hue, colorFilterModel.highlights, colorFilterModel.shadows, colorFilterModel.saturation, colorFilterModel.temperature)));
        arrayList.add(new IdentifyComponent(n3.a(CustomAnimation.KeyPath.COLOR_FILTER)));
        return new RenderData(p16.a(str, arrayList), new InputSource(filterModel.id, null, null, null, null, null, null, null, null, null, null, null, 4094, null), null, 4, null);
    }

    @NotNull
    public static final RenderData b(@NotNull FilterModel filterModel, boolean z16) {
        String str;
        List<IdentifyComponent> emptyList;
        Intrinsics.checkNotNullParameter(filterModel, "<this>");
        od4.b bVar = od4.b.f422509e;
        xd4.f p16 = bVar.p();
        if (!z16) {
            str = "lutFilter";
        } else {
            str = "videoTrackLutFilter";
        }
        LutFilterModel lutFilterModel = filterModel.lut;
        if (lutFilterModel == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return new RenderData(p16.a(str, emptyList), new InputSource(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null), null, 4, null);
        }
        xd4.e n3 = bVar.n();
        InputSource b16 = bVar.q().b(lutFilterModel.filePath, filterModel.id);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new IdentifyComponent(n3.m()));
        if (!z16) {
            arrayList.add(new IdentifyComponent(n3.e(filterModel.startTimeUs, filterModel.durationUs)));
        }
        String str2 = b16.key;
        if (str2 == null) {
            str2 = "";
        }
        arrayList.add(new IdentifyComponent(n3.f(str2, lutFilterModel.intensity)));
        arrayList.add(new IdentifyComponent(n3.a("lutFilter")));
        return new RenderData(p16.a(str, arrayList), b16, null, 4, null);
    }
}
