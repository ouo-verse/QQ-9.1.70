package com.tencent.mobileqq.qqvideoedit.editor.sticker;

import ak2.o;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qqvideoedit.editor.model.PointF;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.AnimationMode;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.StickerModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.TextItem;
import com.tencent.tavcut.model.PagEffectData;
import com.tencent.tavcut.model.TextLayerData;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a:\u0010\r\u001a\u00020\f*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/tavcut/model/PagEffectData;", "", "layerIndex", "Lcom/tencent/mobileqq/qqvideoedit/editor/model/PointF;", "originInView", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", "startTimeUs", "durationUs", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel$Type;", "type", "Lcom/tencent/mobileqq/qqvideoedit/editor/sticker/VideoStickerModel;", "a", "qqvideoedit_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {
    @NotNull
    public static final VideoStickerModel a(@NotNull PagEffectData pagEffectData, int i3, @NotNull PointF originInView, @NotNull MetaMaterial material, long j3, long j16, @NotNull StickerModel.Type type) {
        int collectionSizeOrDefault;
        AnimationMode animationMode;
        StickerModel.ActionType actionType;
        int i16;
        String d16;
        String d17;
        int i17;
        float f16;
        String str;
        Intrinsics.checkNotNullParameter(pagEffectData, "<this>");
        Intrinsics.checkNotNullParameter(originInView, "originInView");
        Intrinsics.checkNotNullParameter(material, "material");
        Intrinsics.checkNotNullParameter(type, "type");
        List<TextLayerData> list = pagEffectData.textLayerList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (TextLayerData textLayerData : list) {
            Integer num = textLayerData.layerIndex;
            int i18 = 0;
            if (num != null) {
                i16 = num.intValue();
            } else {
                i16 = 0;
            }
            String h16 = h.h(material);
            String t16 = h.t(material);
            String str2 = o.U;
            if (t16.equals(str2)) {
                d16 = com.tencent.videocut.utils.d.f384234a.d(o.R1(h.w(material)));
            } else {
                d16 = com.tencent.videocut.utils.d.f384234a.d(h.w(material));
            }
            String str3 = d16;
            Boolean bool = textLayerData.applyStroke;
            if (h.t(material).equals(str2)) {
                d17 = com.tencent.videocut.utils.d.f384234a.d(h.w(material));
            } else {
                d17 = com.tencent.videocut.utils.d.f384234a.d(h.c(material));
            }
            String str4 = d17;
            Integer num2 = textLayerData.backgroundAlpha;
            if (num2 != null) {
                i17 = num2.intValue();
            } else {
                i17 = 0;
            }
            int i19 = (i17 * 100) / 255;
            com.tencent.videocut.utils.d dVar = com.tencent.videocut.utils.d.f384234a;
            Integer num3 = textLayerData.strokeColor;
            if (num3 != null) {
                i18 = num3.intValue();
            }
            String d18 = dVar.d(i18);
            Float f17 = textLayerData.stokeWidth;
            if (f17 != null) {
                f16 = f17.floatValue();
            } else {
                f16 = 0.0f;
            }
            float f18 = f16 / 20;
            String l3 = h.l(material);
            if (l3 == null) {
                str = "";
            } else {
                str = l3;
            }
            arrayList.add(new TextItem(h16, str3, str, d18, f18, null, null, null, i16, textLayerData.fauxBold, textLayerData.fauxItalic, h.j(material), bool, textLayerData.leading, textLayerData.tracking, str4, i19, null, null, null, 917728, null));
        }
        String j17 = com.tencent.mobileqq.qqvideoedit.editor.b.j(material);
        int hashCode = j17.hashCode();
        if (hashCode != -934531685) {
            if (hashCode != 3387192) {
                if (hashCode == 103157261 && j17.equals("loop1")) {
                    animationMode = AnimationMode.FREEZE;
                }
                animationMode = AnimationMode.LOOP;
            } else {
                if (j17.equals("none")) {
                    animationMode = AnimationMode.LOOP;
                }
                animationMode = AnimationMode.LOOP;
            }
        } else {
            if (j17.equals("repeat")) {
                animationMode = AnimationMode.LOOP;
            }
            animationMode = AnimationMode.LOOP;
        }
        AnimationMode animationMode2 = animationMode;
        String uuid = UUID.randomUUID().toString();
        String str5 = pagEffectData.filePath;
        if (str5 == null) {
            str5 = "";
        }
        int i26 = pagEffectData.width;
        int i27 = pagEffectData.height;
        float v3 = h.v(material);
        float b16 = h.b(material);
        float e16 = h.e(material);
        float f19 = h.f(material);
        float r16 = h.r(material);
        float q16 = h.q(material);
        String id5 = material.f30533id;
        long u16 = h.u(material);
        if (Intrinsics.areEqual(h.a(material), "replace_all")) {
            actionType = StickerModel.ActionType.REPLACE_ALL;
        } else {
            actionType = StickerModel.ActionType.NONE;
        }
        float v16 = h.v(material);
        Intrinsics.checkNotNullExpressionValue(uuid, "toString()");
        Intrinsics.checkNotNullExpressionValue(id5, "id");
        return new VideoStickerModel(uuid, str5, j3, j16, i3, v3, b16, e16, f19, true, i26, i27, r16, q16, arrayList, "", 0, animationMode2, type, id5, null, 0, 0, u16, actionType, null, null, null, null, v16, 0.0f, originInView, null, null, null, null, material, 1584398336, 15, null);
    }
}
