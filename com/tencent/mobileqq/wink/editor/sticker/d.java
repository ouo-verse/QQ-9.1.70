package com.tencent.mobileqq.wink.editor.sticker;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.wink.editor.model.PointF;
import com.tencent.tavcut.core.render.builder.light.model.pag.PagEffectData;
import com.tencent.tavcut.core.render.builder.light.model.pag.TextLayerData;
import com.tencent.videocut.model.AnimationMode;
import com.tencent.videocut.model.StickerModel;
import com.tencent.videocut.model.TextItem;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aN\u0010\u0010\u001a\u00020\u000f*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/tavcut/core/render/builder/light/model/pag/PagEffectData;", "", "layerIndex", "Lcom/tencent/mobileqq/wink/editor/model/PointF;", "originInView", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", "startTimeUs", "durationUs", "Lcom/tencent/videocut/model/StickerModel$Type;", "type", "", "postCropScale", "postCropTranslateY", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "a", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class d {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x02ba  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final WinkStickerModel a(@NotNull PagEffectData pagEffectData, int i3, @NotNull PointF originInView, @NotNull MetaMaterial material, long j3, long j16, @NotNull StickerModel.Type type, float f16, float f17) {
        ArrayList arrayList;
        ArrayList<MetaMaterialContent> metaMaterialContent;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        float f18;
        String str;
        String str2;
        String str3;
        AnimationMode animationMode;
        int i27;
        int i28;
        String filePath;
        StickerModel.ActionType actionType;
        com.tencent.mobileqq.wink.editor.util.m mVar;
        Pair h16;
        int collectionSizeOrDefault;
        int i29;
        String str4;
        Intrinsics.checkNotNullParameter(pagEffectData, "<this>");
        Intrinsics.checkNotNullParameter(originInView, "originInView");
        Intrinsics.checkNotNullParameter(material, "material");
        Intrinsics.checkNotNullParameter(type, "type");
        String str5 = "";
        if (m.m(material) == null) {
            List<TextLayerData> textLayerList = pagEffectData.getTextLayerList();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(textLayerList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            for (TextLayerData textLayerData : textLayerList) {
                Integer layerIndex = textLayerData.getLayerIndex();
                if (layerIndex != null) {
                    i29 = layerIndex.intValue();
                } else {
                    i29 = 0;
                }
                String l3 = m.l(material);
                com.tencent.videocut.utils.d dVar = com.tencent.videocut.utils.d.f384234a;
                String d16 = dVar.d(m.F(material));
                boolean e16 = m.e(material);
                String d17 = dVar.d(m.g(material));
                int f19 = m.f(material);
                String d18 = dVar.d(m.B(material));
                float C = m.C(material);
                String r16 = m.r(material);
                if (r16 == null) {
                    str4 = "";
                } else {
                    str4 = r16;
                }
                arrayList2.add(new TextItem(l3, d16, str4, d18, C, null, null, null, i29, textLayerData.getFauxBold(), textLayerData.getFauxItalic(), m.p(material), Boolean.valueOf(e16), textLayerData.getLeading(), textLayerData.getTracking(), d17, f19, null, null, Integer.valueOf(m.G(material)), null, 1442016, null));
            }
            arrayList = arrayList2;
        } else {
            ArrayList arrayList3 = new ArrayList();
            MetaMaterialContentWrapper m3 = m.m(material);
            if (m3 != null && (metaMaterialContent = m3.getMetaMaterialContent()) != null) {
                for (MetaMaterialContent metaMaterialContent2 : metaMaterialContent) {
                    Integer layerIndex2 = metaMaterialContent2.getLayerIndex();
                    if (layerIndex2 != null) {
                        i16 = layerIndex2.intValue();
                    } else {
                        i16 = 0;
                    }
                    String content = metaMaterialContent2.getContent();
                    com.tencent.videocut.utils.d dVar2 = com.tencent.videocut.utils.d.f384234a;
                    Integer textColor = metaMaterialContent2.getTextColor();
                    if (textColor != null) {
                        i17 = textColor.intValue();
                    } else {
                        i17 = 0;
                    }
                    String d19 = dVar2.d(i17);
                    Boolean applyStroke = metaMaterialContent2.getApplyStroke();
                    Integer backgroundColor = metaMaterialContent2.getBackgroundColor();
                    if (backgroundColor != null) {
                        i18 = backgroundColor.intValue();
                    } else {
                        i18 = 0;
                    }
                    String d26 = dVar2.d(i18);
                    Integer backgroundAlpha = metaMaterialContent2.getBackgroundAlpha();
                    if (backgroundAlpha != null) {
                        i19 = backgroundAlpha.intValue();
                    } else {
                        i19 = 0;
                    }
                    Integer strokeColor = metaMaterialContent2.getStrokeColor();
                    if (strokeColor != null) {
                        i26 = strokeColor.intValue();
                    } else {
                        i26 = 0;
                    }
                    String d27 = dVar2.d(i26);
                    Float stokeWidth = metaMaterialContent2.getStokeWidth();
                    if (stokeWidth != null) {
                        f18 = stokeWidth.floatValue();
                    } else {
                        f18 = 0.0f;
                    }
                    float f26 = f18;
                    String fontPath = metaMaterialContent2.getFontPath();
                    if (fontPath == null) {
                        str = "";
                    } else {
                        str = fontPath;
                    }
                    Boolean fauxBold = metaMaterialContent2.getFauxBold();
                    Boolean fauxItalic = metaMaterialContent2.getFauxItalic();
                    String fontFamily = metaMaterialContent2.getFontFamily();
                    if (fontFamily == null) {
                        str2 = "";
                    } else {
                        str2 = fontFamily;
                    }
                    Float leading = metaMaterialContent2.getLeading();
                    Float tracking = metaMaterialContent2.getTracking();
                    String fontStyle = metaMaterialContent2.getFontStyle();
                    if (fontStyle == null) {
                        str3 = "";
                    } else {
                        str3 = fontStyle;
                    }
                    arrayList3.add(new TextItem(content, d19, str, d27, f26, null, null, null, i16, fauxBold, fauxItalic, str2, applyStroke, leading, tracking, d26, i19, null, str3, metaMaterialContent2.getJustification(), null, 1179872, null));
                }
            }
            arrayList = arrayList3;
        }
        String Y = com.tencent.mobileqq.wink.editor.c.Y(material);
        switch (Y.hashCode()) {
            case -1266402665:
                if (Y.equals("freeze")) {
                    animationMode = AnimationMode.FREEZE;
                    break;
                }
                animationMode = AnimationMode.LOOP;
                break;
            case -934531685:
                if (Y.equals("repeat")) {
                    animationMode = AnimationMode.LOOP;
                    break;
                }
                animationMode = AnimationMode.LOOP;
                break;
            case -891851344:
                if (Y.equals("scale_up")) {
                    animationMode = AnimationMode.SCALE_UP;
                    break;
                }
                animationMode = AnimationMode.LOOP;
                break;
            case 3387192:
                if (Y.equals("none")) {
                    animationMode = AnimationMode.LOOP;
                    break;
                }
                animationMode = AnimationMode.LOOP;
                break;
            case 103157261:
                if (Y.equals("loop1")) {
                    animationMode = AnimationMode.FREEZE;
                    break;
                }
                animationMode = AnimationMode.LOOP;
                break;
            case 1923754326:
                if (Y.equals("scale_both")) {
                    animationMode = AnimationMode.SCALE_BOTH;
                    break;
                }
                animationMode = AnimationMode.LOOP;
                break;
            default:
                animationMode = AnimationMode.LOOP;
                break;
        }
        AnimationMode animationMode2 = animationMode;
        int width = pagEffectData.getWidth();
        int height = pagEffectData.getHeight();
        if (type == StickerModel.Type.DEFAULT && (h16 = com.tencent.mobileqq.wink.editor.util.m.h((mVar = com.tencent.mobileqq.wink.editor.util.m.f322645a), null, 1, null)) != null && ((Number) h16.getFirst()).intValue() != 0 && ((Number) h16.getSecond()).intValue() != 0) {
            height = 1280;
            int intValue = (((Number) com.tencent.mobileqq.wink.editor.util.m.h(mVar, null, 1, null).getFirst()).intValue() * 1280) / ((Number) com.tencent.mobileqq.wink.editor.util.m.h(mVar, null, 1, null).getSecond()).intValue();
            float f27 = intValue;
            int width2 = (int) ((f27 / pagEffectData.getWidth()) * pagEffectData.getHeight());
            if (width2 > 1280) {
                width = (int) (((f27 * 1.0f) * 1280) / width2);
            } else {
                i27 = intValue;
                i28 = width2;
                String uuid = UUID.randomUUID().toString();
                filePath = pagEffectData.getFilePath();
                if (filePath != null) {
                    str5 = filePath;
                }
                float A = m.A(material);
                float A2 = m.A(material);
                float d28 = m.d(material);
                float i36 = m.i(material);
                float j17 = m.j(material);
                float x16 = m.x(material);
                float w3 = m.w(material);
                String id5 = material.f30533id;
                long z16 = m.z(material);
                if (!Intrinsics.areEqual(m.c(material), "replace_all")) {
                    actionType = StickerModel.ActionType.REPLACE_ALL;
                } else {
                    actionType = StickerModel.ActionType.NONE;
                }
                float A3 = m.A(material);
                Intrinsics.checkNotNullExpressionValue(uuid, "toString()");
                Intrinsics.checkNotNullExpressionValue(id5, "id");
                return new WinkStickerModel(uuid, str5, j3, j16, i3, A, A2, d28, i36, j17, true, i27, i28, x16, w3, arrayList, "", 0, animationMode2, type, id5, null, 0, 0, z16, actionType, null, null, null, 0.0f, null, null, null, A3, 0.0f, originInView, null, null, null, null, material, null, null, null, null, false, null, null, false, f16, f17, null, false, -52428800, 1703669, null);
            }
        }
        i27 = width;
        i28 = height;
        String uuid2 = UUID.randomUUID().toString();
        filePath = pagEffectData.getFilePath();
        if (filePath != null) {
        }
        float A4 = m.A(material);
        float A22 = m.A(material);
        float d282 = m.d(material);
        float i362 = m.i(material);
        float j172 = m.j(material);
        float x162 = m.x(material);
        float w36 = m.w(material);
        String id52 = material.f30533id;
        long z162 = m.z(material);
        if (!Intrinsics.areEqual(m.c(material), "replace_all")) {
        }
        float A32 = m.A(material);
        Intrinsics.checkNotNullExpressionValue(uuid2, "toString()");
        Intrinsics.checkNotNullExpressionValue(id52, "id");
        return new WinkStickerModel(uuid2, str5, j3, j16, i3, A4, A22, d282, i362, j172, true, i27, i28, x162, w36, arrayList, "", 0, animationMode2, type, id52, null, 0, 0, z162, actionType, null, null, null, 0.0f, null, null, null, A32, 0.0f, originInView, null, null, null, null, material, null, null, null, null, false, null, null, false, f16, f17, null, false, -52428800, 1703669, null);
    }

    public static /* synthetic */ WinkStickerModel b(PagEffectData pagEffectData, int i3, PointF pointF, MetaMaterial metaMaterial, long j3, long j16, StickerModel.Type type, float f16, float f17, int i16, Object obj) {
        float f18;
        float f19;
        if ((i16 & 64) != 0) {
            f18 = 1.0f;
        } else {
            f18 = f16;
        }
        if ((i16 & 128) != 0) {
            f19 = 0.0f;
        } else {
            f19 = f17;
        }
        return a(pagEffectData, i3, pointF, metaMaterial, j3, j16, type, f18, f19);
    }
}
