package com.tencent.videocut.render.extension;

import com.tencent.mobileqq.wink.editor.transition.TransitionResourceManager;
import com.tencent.tavcut.core.render.builder.light.model.InputSource;
import com.tencent.tavcut.core.render.builder.light.model.pag.ImageLayerData;
import com.tencent.tavcut.core.render.builder.light.model.pag.LayerMarkData;
import com.tencent.tavcut.core.render.builder.light.model.pag.PagEffectData;
import com.tencent.videocut.model.TransitionModel;
import com.tencent.videocut.render.l;
import com.tencent.videocut.render.v;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.light.lightAssetKit.components.Component;
import org.light.lightAssetKit.components.Transition;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003\u00a8\u0006\b"}, d2 = {"Lcom/tencent/videocut/model/TransitionModel;", "Lcom/tencent/videocut/render/v;", "b", "", "path", "Lkotlin/Pair;", "", "a", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class h {
    @NotNull
    public static final Pair<Integer, Integer> a(@NotNull String path) {
        ArrayList arrayList;
        boolean z16;
        List<ImageLayerData> imageLayerList;
        Object firstOrNull;
        boolean z17;
        String desc;
        Intrinsics.checkNotNullParameter(path, "path");
        Pair<Integer, Integer> pair = new Pair<>(0, 1);
        if (!com.tencent.videocut.utils.g.f384239a.h(path)) {
            return pair;
        }
        PagEffectData A = rd4.c.f431135f.A(path);
        if (A != null && (imageLayerList = A.getImageLayerList()) != null) {
            arrayList = new ArrayList();
            for (Object obj : imageLayerList) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) ((ImageLayerData) obj).getLayerMarkList());
                LayerMarkData layerMarkData = (LayerMarkData) firstOrNull;
                if (layerMarkData != null && (desc = layerMarkData.getDesc()) != null) {
                    z17 = StringsKt__StringsKt.contains((CharSequence) desc, (CharSequence) "videoTrack", true);
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
            return new Pair<>(Integer.valueOf(((ImageLayerData) arrayList.get(0)).getLayerIndex()), Integer.valueOf(((ImageLayerData) arrayList.get(1)).getLayerIndex()));
        }
        return pair;
    }

    @NotNull
    public static final v b(@NotNull TransitionModel transitionModel) {
        String str;
        Pair<Integer, Integer> a16;
        List<? extends Component> listOf;
        Intrinsics.checkNotNullParameter(transitionModel, "<this>");
        if (transitionModel.isLandscape) {
            str = transitionModel.landscapePagPath;
        } else {
            str = transitionModel.pagPath;
        }
        rd4.c cVar = rd4.c.f431135f;
        InputSource a17 = cVar.r().a(str, transitionModel.id);
        td4.e o16 = cVar.o();
        if (Intrinsics.areEqual(TransitionResourceManager.d(str), "ZC_jichu_huadong")) {
            a16 = new Pair<>(0, 1);
        } else {
            a16 = a(str);
        }
        Transition b16 = o16.b(a17.getKey(), transitionModel.duration, a16.getFirst().intValue(), a16.getSecond().intValue());
        td4.f q16 = cVar.q();
        listOf = CollectionsKt__CollectionsJVMKt.listOf(b16);
        return new v(transitionModel.position, new l(q16.a("transition", listOf), a17, null, 4, null));
    }
}
