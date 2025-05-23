package gk2;

import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.TransitionModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.RenderData;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.TransitionRenderData;
import com.tencent.tavcut.composition.model.component.EntityIdentifier;
import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.composition.model.component.ScreenTransform;
import com.tencent.tavcut.composition.model.component.Transition;
import com.tencent.tavcut.model.ImageLayerData;
import com.tencent.tavcut.model.LayerMarkData;
import com.tencent.tavcut.model.PagEffectData;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TransitionModel;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/w;", "b", "", "path", "Lkotlin/Pair;", "", "a", "qqvideoedit_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class j {
    @NotNull
    public static final Pair<Integer, Integer> a(@NotNull String path) {
        ArrayList arrayList;
        boolean z16;
        List<ImageLayerData> list;
        Object firstOrNull;
        boolean z17;
        String str;
        Intrinsics.checkNotNullParameter(path, "path");
        Pair<Integer, Integer> pair = new Pair<>(0, 1);
        if (!com.tencent.videocut.utils.g.f384239a.h(path)) {
            return pair;
        }
        PagEffectData z18 = od4.b.f422509e.z(path);
        if (z18 != null && (list = z18.imageLayerList) != null) {
            arrayList = new ArrayList();
            for (Object obj : list) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) ((ImageLayerData) obj).layerMarkList);
                LayerMarkData layerMarkData = (LayerMarkData) firstOrNull;
                if (layerMarkData != null && (str = layerMarkData.desc) != null) {
                    z17 = StringsKt__StringsKt.contains((CharSequence) str, (CharSequence) "videoTrack", true);
                } else {
                    z17 = false;
                }
                if (z17) {
                    arrayList.add(obj);
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null && arrayList.size() == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return new Pair<>(Integer.valueOf(((ImageLayerData) arrayList.get(0)).layerIndex), Integer.valueOf(((ImageLayerData) arrayList.get(1)).layerIndex));
        }
        return pair;
    }

    @NotNull
    public static final TransitionRenderData b(@NotNull TransitionModel transitionModel) {
        String str;
        List<IdentifyComponent> listOf;
        Intrinsics.checkNotNullParameter(transitionModel, "<this>");
        if (transitionModel.isLandscape) {
            str = transitionModel.landscapePagPath;
        } else {
            str = transitionModel.pagPath;
        }
        od4.b bVar = od4.b.f422509e;
        InputSource a16 = bVar.q().a(str, transitionModel.id);
        xd4.e n3 = bVar.n();
        Pair<Integer, Integer> a17 = a(str);
        String str2 = a16.key;
        if (str2 == null) {
            str2 = "";
        }
        Transition b16 = n3.b(str2, transitionModel.duration, a17.getFirst().intValue(), a17.getSecond().intValue());
        ScreenTransform m3 = n3.m();
        EntityIdentifier a18 = n3.a("transition");
        xd4.f p16 = bVar.p();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new IdentifyComponent[]{new IdentifyComponent(b16), new IdentifyComponent(m3), new IdentifyComponent(a18)});
        return new TransitionRenderData(transitionModel.position, new RenderData(p16.a("transition", listOf), a16, null, 4, null));
    }
}
