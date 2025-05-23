package com.tencent.mobileqq.wink.editor.subtitle;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.edit.bean.AEEditorDownloadResBean;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.sticker.MetaMaterialContent;
import com.tencent.mobileqq.wink.editor.sticker.MetaMaterialContentWrapper;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.mobileqq.wink.editor.sticker.text.bb;
import com.tencent.mobileqq.wink.editor.subtitle.source.Subtitle;
import com.tencent.mobileqq.wink.editor.subtitle.source.SubtitleLine;
import com.tencent.tavcut.core.render.builder.light.model.Timeline;
import com.tencent.tavcut.core.render.builder.light.model.pag.PagEffectData;
import com.tencent.tavcut.core.render.builder.light.model.pag.TextLayerData;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaType;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.SizeF;
import com.tencent.videocut.model.TextItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGText;
import org.light.TimeRange;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b1\u00102J\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\r\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J \u0010\u0013\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J!\u0010\u0017\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J \u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0011H\u0002JH\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00070\u001c2\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u001c2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010\u0007H\u0016JB\u0010'\u001a\u0014\u0012\u0004\u0012\u00020\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u001c2\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u001c2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020$0\u001eH\u0016J,\u0010)\u001a\u0004\u0018\u00010\u00072\u0006\u0010(\u001a\u00020$2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\"\u001a\u00020!H\u0016J \u0010,\u001a\u0004\u0018\u00010\u00072\u0014\u0010+\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001cH\u0016R\u001a\u00100\u001a\u00020*8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b%\u0010-\u001a\u0004\b.\u0010/\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/subtitle/a;", "Lcom/tencent/mobileqq/wink/editor/subtitle/n;", "", "position", "", "scale", "i", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "referenceSticker", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/editor/sticker/MetaMaterialContent;", "metaMaterialContent", "", "j", "model", "", "renderHeight", "", "pointY", "d", "Lcom/tencent/mobileqq/wink/editor/dr;", "tavCut", "defaultModel", "e", "(Lcom/tencent/mobileqq/wink/editor/dr;Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;)Ljava/lang/Float;", "stickerModel", "playerRealHeight", tl.h.F, "", "Lcom/tencent/mobileqq/wink/editor/subtitle/SubtitlesMapKey;", "", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/SubtitleLine;", "linesMap", "", "isBilingual", "winkStickerModel", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/Subtitle;", "b", TPReportKeys.VodExKeys.VOD_EX_HAS_SUBTITLE, "c", "subtitle", "a", "", "stickerMap", "f", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "LATER_NAME_TRANS", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a implements n {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f322144a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String LATER_NAME_TRANS = "translation";

    a() {
    }

    private final float d(WinkStickerModel model, int renderHeight, float pointY) {
        return (float) (1 - (Math.ceil((pointY - model.getOriginPointInView().f320588y) + (model.getSizeInView().f320588y / 2)) / (renderHeight / 2)));
    }

    private final Float e(dr tavCut, WinkStickerModel defaultModel) {
        float intValue;
        SizeF sizeF;
        boolean z16;
        Iterator<T> it = tavCut.V().videos.iterator();
        float f16 = Float.MAX_VALUE;
        while (it.hasNext()) {
            ResourceModel resourceModel = ((MediaClip) it.next()).resource;
            if (resourceModel != null && (sizeF = resourceModel.size) != null) {
                float f17 = sizeF.height;
                if (f17 == 0.0f) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    f16 = Math.min(sizeF.width / f17, f16);
                }
            }
        }
        Integer num = tavCut.getRenderSize().width;
        if (num != null) {
            int intValue2 = num.intValue();
            Integer num2 = tavCut.getRenderSize().height;
            if (num2 != null) {
                int intValue3 = num2.intValue();
                if (f16 > 0.0f) {
                    intValue = Math.min(intValue2 / f16, intValue3);
                } else {
                    Integer num3 = tavCut.getRenderSize().height;
                    Intrinsics.checkNotNull(num3);
                    intValue = num3.intValue();
                }
                return Float.valueOf(h(tavCut, defaultModel, intValue));
            }
        }
        return null;
    }

    private final float h(dr tavCut, WinkStickerModel stickerModel, float playerRealHeight) {
        int screenHeight;
        Integer num = tavCut.getRenderSize().height;
        if (num != null) {
            screenHeight = num.intValue();
        } else {
            screenHeight = ViewUtils.getScreenHeight();
        }
        return d(stickerModel, screenHeight, stickerModel.getLeftTopInView().f320588y + stickerModel.getOriginPointInView().f320588y + (playerRealHeight * 0.33f));
    }

    private final long i(long position, double scale) {
        if (Math.abs(scale - 1) < 0.01d) {
            return position;
        }
        return (long) (position / scale);
    }

    private final void j(WinkStickerModel referenceSticker, ArrayList<MetaMaterialContent> metaMaterialContent) {
        MetaMaterial material;
        if (referenceSticker != null && (material = referenceSticker.getMaterial()) != null) {
            for (MetaMaterialContent metaMaterialContent2 : metaMaterialContent) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    metaMaterialContent2.setTextColor(Integer.valueOf(com.tencent.mobileqq.wink.editor.sticker.m.F(material)));
                    metaMaterialContent2.setStrokeColor(Integer.valueOf(com.tencent.mobileqq.wink.editor.sticker.m.B(material)));
                    metaMaterialContent2.setApplyStroke(Boolean.valueOf(com.tencent.mobileqq.wink.editor.sticker.m.e(material)));
                    metaMaterialContent2.setStokeWidth(Float.valueOf(com.tencent.mobileqq.wink.editor.sticker.m.C(material)));
                    metaMaterialContent2.setBackgroundAlpha(Integer.valueOf(com.tencent.mobileqq.wink.editor.sticker.m.f(material)));
                    metaMaterialContent2.setBackgroundColor(Integer.valueOf(com.tencent.mobileqq.wink.editor.sticker.m.g(material)));
                    metaMaterialContent2.setFontFamily(com.tencent.mobileqq.wink.editor.sticker.m.p(material));
                    metaMaterialContent2.setFontPath(com.tencent.mobileqq.wink.editor.sticker.m.r(material));
                    Result.m476constructorimpl(Unit.INSTANCE);
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.m476constructorimpl(ResultKt.createFailure(th5));
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v32, types: [java.lang.Object] */
    @Override // com.tencent.mobileqq.wink.editor.subtitle.n
    @Nullable
    public WinkStickerModel a(@NotNull Subtitle subtitle, @NotNull dr tavCut, @Nullable WinkStickerModel referenceSticker, boolean isBilingual) {
        WinkStickerModel winkStickerModel;
        int collectionSizeOrDefault;
        MetaMaterial metaMaterial;
        TextItem copy;
        boolean z16;
        String str;
        float d16;
        Collection<WinkStickerModel> values;
        WinkStickerModel winkStickerModel2;
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(tavCut, "tavCut");
        if (referenceSticker == null) {
            Map<String, WinkStickerModel> m3 = tavCut.m();
            if (m3 != null && (values = m3.values()) != null) {
                Iterator it = values.iterator();
                while (true) {
                    if (it.hasNext()) {
                        winkStickerModel2 = it.next();
                        if (((WinkStickerModel) winkStickerModel2).isSubtitleSticker()) {
                            break;
                        }
                    } else {
                        winkStickerModel2 = 0;
                        break;
                    }
                }
                winkStickerModel = winkStickerModel2;
            } else {
                winkStickerModel = null;
            }
        } else {
            winkStickerModel = referenceSticker;
        }
        Integer num = tavCut.getRenderSize().width;
        if (num == null) {
            return null;
        }
        int intValue = num.intValue();
        Integer num2 = tavCut.getRenderSize().height;
        if (num2 == null) {
            return null;
        }
        int intValue2 = num2.intValue();
        if (winkStickerModel == null) {
            MetaMaterial a06 = com.tencent.mobileqq.wink.editor.sticker.m.a0();
            if (isBilingual) {
                String D0 = WinkEditorResourceManager.a1().D0();
                Intrinsics.checkNotNullExpressionValue(D0, "getInstance().chineseEnglishSubtitlePagPath");
                com.tencent.mobileqq.wink.editor.sticker.m.F0(a06, D0);
            } else {
                String K1 = WinkEditorResourceManager.a1().K1();
                Intrinsics.checkNotNullExpressionValue(K1, "getInstance().subtitleTextDefaultPagPath");
                com.tencent.mobileqq.wink.editor.sticker.m.F0(a06, K1);
            }
            MetaMaterialContentWrapper metaMaterialContentWrapper = new MetaMaterialContentWrapper(null, 1, null);
            MetaMaterialContent metaMaterialContent = new MetaMaterialContent(subtitle.getLine(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108862, null);
            MetaMaterialContent metaMaterialContent2 = new MetaMaterialContent(subtitle.getNnTranslate(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108862, null);
            PagEffectData A = rd4.c.f431135f.A(com.tencent.mobileqq.wink.editor.sticker.m.y(a06));
            if (A == null) {
                return null;
            }
            if (isBilingual) {
                for (TextLayerData textLayerData : A.getTextLayerList()) {
                    if (Intrinsics.areEqual(textLayerData.getLayerName(), "source")) {
                        metaMaterialContent.setLayerName(textLayerData.getLayerName());
                        metaMaterialContent.resetData(textLayerData);
                        metaMaterialContentWrapper.getMetaMaterialContent().add(metaMaterialContent);
                    }
                    if (Intrinsics.areEqual(textLayerData.getLayerName(), LATER_NAME_TRANS)) {
                        metaMaterialContent2.setLayerName(textLayerData.getLayerName());
                        metaMaterialContent2.resetData(textLayerData);
                        metaMaterialContentWrapper.getMetaMaterialContent().add(metaMaterialContent2);
                    }
                }
                com.tencent.mobileqq.wink.editor.sticker.m.o0(a06, metaMaterialContentWrapper);
                PAGText textData = com.tencent.mobileqq.wink.utils.x.b().c(com.tencent.mobileqq.wink.editor.sticker.m.y(a06)).getTextData(0);
                String str2 = textData.fontFamily;
                Intrinsics.checkNotNullExpressionValue(str2, "pagText.fontFamily");
                com.tencent.mobileqq.wink.editor.sticker.m.t0(a06, str2);
                com.tencent.mobileqq.wink.editor.sticker.m.x0(a06, "Regular");
                com.tencent.mobileqq.wink.editor.sticker.m.H0(a06, textData.strokeColor);
                com.tencent.mobileqq.wink.editor.sticker.m.e0(a06, textData.applyStroke);
                com.tencent.mobileqq.wink.editor.sticker.m.I0(a06, textData.strokeWidth);
                z16 = true;
            } else {
                com.tencent.mobileqq.wink.editor.sticker.m.n0(a06, subtitle.getLine());
                com.tencent.mobileqq.wink.editor.sticker.m.t0(a06, com.tencent.mobileqq.wink.editor.sticker.m.p(a06));
                com.tencent.mobileqq.wink.editor.sticker.m.x0(a06, "Regular");
                com.tencent.mobileqq.wink.editor.sticker.m.H0(a06, bb.f322032p0);
                z16 = true;
                com.tencent.mobileqq.wink.editor.sticker.m.e0(a06, true);
                com.tencent.mobileqq.wink.editor.sticker.m.I0(a06, 12.0f);
                com.tencent.mobileqq.wink.editor.sticker.m.L0(a06, 45L);
                com.tencent.mobileqq.wink.editor.sticker.m.M0(a06, 45L);
            }
            com.tencent.mobileqq.wink.editor.sticker.m.J0(a06, z16);
            com.tencent.mobileqq.wink.editor.sticker.m.v0(a06, "TEXT_DEFAULT_DEFAULT_ID");
            com.tencent.mobileqq.wink.editor.sticker.m.w0(a06, (String) WinkEditorResourceManager.a1().v3("TEXT_DEFAULT_DEFAULT_ID", 0).first);
            AEEditorDownloadResBean V0 = WinkEditorResourceManager.a1().V0("TEXT_DEFAULT_DEFAULT_ID");
            if (V0 != null) {
                str = V0.getFontFamily();
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            com.tencent.mobileqq.wink.editor.sticker.m.u0(a06, str);
            WinkStickerModel t16 = com.tencent.mobileqq.wink.editor.sticker.l.t(a06, tavCut, intValue, intValue2, subtitle.getAbsStartTimeUs(), subtitle.getDurationUs(), true, false, 64, null);
            if (t16 == null) {
                return null;
            }
            float f16 = t16.getLeftTopInView().f320588y + t16.getOriginPointInView().f320588y;
            Float e16 = e(tavCut, t16);
            if (e16 != null) {
                d16 = e16.floatValue();
            } else {
                d16 = d(t16, intValue2, f16 + (intValue2 * 0.33f));
            }
            WinkStickerModel a16 = com.tencent.mobileqq.wink.editor.sticker.e.a(t16, t16.centerX, d16);
            MetaMaterial material = t16.getMaterial();
            if (material != null) {
                com.tencent.mobileqq.wink.editor.sticker.m.Z(material, intValue);
                Unit unit = Unit.INSTANCE;
            }
            a16.updatePositionInView(intValue, intValue2, a16.scaleX, a16.scaleY, a16.centerX, a16.centerY);
            MetaMaterial material2 = a16.getMaterial();
            if (material2 != null) {
                com.tencent.mobileqq.wink.editor.sticker.m.J0(material2, true);
            }
            return a16;
        }
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        long absStartTimeUs = subtitle.getAbsStartTimeUs();
        long durationUs = subtitle.getDurationUs();
        List<TextItem> list = winkStickerModel.textItems;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it5 = list.iterator();
        while (it5.hasNext()) {
            copy = r33.copy((r38 & 1) != 0 ? r33.text : subtitle.getLine(), (r38 & 2) != 0 ? r33.textColor : null, (r38 & 4) != 0 ? r33.fontPath : null, (r38 & 8) != 0 ? r33.strokeColor : null, (r38 & 16) != 0 ? Float.valueOf(r33.strokeWidth) : null, (r38 & 32) != 0 ? r33.shadowColor : null, (r38 & 64) != 0 ? r33.shadowOpacity : null, (r38 & 128) != 0 ? r33.opacity : null, (r38 & 256) != 0 ? Integer.valueOf(r33.index) : null, (r38 & 512) != 0 ? r33.fauxBold : null, (r38 & 1024) != 0 ? r33.fauxItalic : null, (r38 & 2048) != 0 ? r33.fontFamily : null, (r38 & 4096) != 0 ? r33.applyStroke : null, (r38 & 8192) != 0 ? r33.leading : null, (r38 & 16384) != 0 ? r33.tracking : null, (r38 & 32768) != 0 ? r33.backgroundColor : null, (r38 & 65536) != 0 ? Integer.valueOf(r33.backgroundAlpha) : null, (r38 & 131072) != 0 ? r33.layerSize : null, (r38 & 262144) != 0 ? r33.fontStyle : null, (r38 & 524288) != 0 ? ((TextItem) it5.next()).unknownFields() : null);
            arrayList.add(copy);
        }
        MetaMaterial material3 = winkStickerModel.getMaterial();
        if (material3 != null) {
            metaMaterial = material3.copy();
        } else {
            metaMaterial = null;
        }
        WinkStickerModel copyAndUpdate$default = WinkStickerModel.copyAndUpdate$default(winkStickerModel, uuid, null, absStartTimeUs, durationUs, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, 0, 0, 0.0f, 0.0f, arrayList, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, 0.0f, null, null, 0.0f, 0.0f, null, null, null, null, null, metaMaterial, null, null, null, null, false, null, null, false, 0.0f, 0.0f, null, false, -32782, 1048447, null);
        MetaMaterial material4 = copyAndUpdate$default.getMaterial();
        if (material4 != null) {
            com.tencent.mobileqq.wink.editor.sticker.m.J0(material4, true);
        }
        MetaMaterial material5 = copyAndUpdate$default.getMaterial();
        if (material5 != null) {
            com.tencent.mobileqq.wink.editor.sticker.m.n0(material5, subtitle.getLine());
        }
        MetaMaterial material6 = copyAndUpdate$default.getMaterial();
        if (material6 != null) {
            MetaMaterialContentWrapper metaMaterialContentWrapper2 = new MetaMaterialContentWrapper(null, 1, null);
            MetaMaterialContent metaMaterialContent3 = new MetaMaterialContent(subtitle.getLine(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108862, null);
            MetaMaterialContent metaMaterialContent4 = new MetaMaterialContent(subtitle.getNnTranslate(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108862, null);
            PagEffectData A2 = rd4.c.f431135f.A(com.tencent.mobileqq.wink.editor.sticker.m.y(material6));
            if (A2 != null && isBilingual) {
                for (TextLayerData textLayerData2 : A2.getTextLayerList()) {
                    if (Intrinsics.areEqual(textLayerData2.getLayerName(), "source")) {
                        metaMaterialContent3.setLayerName(textLayerData2.getLayerName());
                        metaMaterialContent3.resetData(textLayerData2);
                        metaMaterialContentWrapper2.getMetaMaterialContent().add(metaMaterialContent3);
                    }
                    if (Intrinsics.areEqual(textLayerData2.getLayerName(), LATER_NAME_TRANS)) {
                        metaMaterialContent4.setLayerName(textLayerData2.getLayerName());
                        metaMaterialContent4.resetData(textLayerData2);
                        metaMaterialContentWrapper2.getMetaMaterialContent().add(metaMaterialContent4);
                    }
                }
                f322144a.j(winkStickerModel, metaMaterialContentWrapper2.getMetaMaterialContent());
                com.tencent.mobileqq.wink.editor.sticker.m.o0(material6, metaMaterialContentWrapper2);
            }
            WinkStickerModel v3 = com.tencent.mobileqq.wink.editor.sticker.l.v(material6, tavCut, intValue, intValue2, copyAndUpdate$default);
            if (v3 != null) {
                copyAndUpdate$default = v3;
            }
            com.tencent.mobileqq.wink.editor.sticker.m.Z(material6, intValue);
            Unit unit2 = Unit.INSTANCE;
        }
        WinkStickerModel winkStickerModel3 = copyAndUpdate$default;
        winkStickerModel3.updatePositionInView(intValue, intValue2, winkStickerModel3.scaleX, winkStickerModel3.scaleY, winkStickerModel3.centerX, winkStickerModel3.centerY);
        return winkStickerModel3;
    }

    @Override // com.tencent.mobileqq.wink.editor.subtitle.n
    @NotNull
    public Map<Subtitle, WinkStickerModel> b(@NotNull Map<SubtitlesMapKey, ? extends List<SubtitleLine>> linesMap, @NotNull dr tavCut, boolean isBilingual, @Nullable WinkStickerModel winkStickerModel) {
        boolean z16;
        List<SubtitleLine> list;
        TimeRange range;
        Object orNull;
        TimeRange timeRange;
        List list2;
        List list3;
        Iterator it;
        int i3;
        dr drVar;
        boolean z17;
        WinkStickerModel winkStickerModel2;
        HashMap hashMap;
        boolean isBlank;
        TimeRange timeRange2;
        boolean z18;
        Subtitle subtitle;
        Map<Subtitle, WinkStickerModel> emptyMap;
        Map<SubtitlesMapKey, ? extends List<SubtitleLine>> linesMap2 = linesMap;
        dr tavCut2 = tavCut;
        boolean z19 = isBilingual;
        WinkStickerModel winkStickerModel3 = winkStickerModel;
        Intrinsics.checkNotNullParameter(linesMap2, "linesMap");
        Intrinsics.checkNotNullParameter(tavCut2, "tavCut");
        List<Timeline> F1 = ((WinkVideoTavCut) tavCut2).F1();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : F1) {
            String type = ((Timeline) obj).getType();
            Object obj2 = linkedHashMap.get(type);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(type, obj2);
            }
            ((List) obj2).add(obj);
        }
        List list4 = (List) linkedHashMap.get("TransitionTrigger");
        if (list4 == null) {
            list4 = CollectionsKt__CollectionsKt.emptyList();
        }
        List list5 = (List) linkedHashMap.get("VideoSource");
        if (list5 == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            return emptyMap;
        }
        HashMap hashMap2 = new HashMap();
        Iterator it5 = tavCut.g0().iterator();
        int i16 = 0;
        while (it5.hasNext()) {
            Object next = it5.next();
            int i17 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            ResourceModel resourceModel = ((MediaClip) next).resource;
            if (resourceModel != null) {
                String str = resourceModel.path;
                if (resourceModel.type != MediaType.IMAGE) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16 && (list = linesMap2.get(new SubtitlesMapKey(str, resourceModel.id))) != null && (range = ((Timeline) list5.get(i16)).getRange()) != null) {
                    orNull = CollectionsKt___CollectionsKt.getOrNull(list4, i16 - 1);
                    Timeline timeline = (Timeline) orNull;
                    if (timeline != null && (timeRange = timeline.getRange()) != null) {
                        list2 = list4;
                        list3 = list5;
                    } else {
                        list2 = list4;
                        list3 = list5;
                        timeRange = new TimeRange(0L, 0L);
                    }
                    long j3 = resourceModel.selectStart;
                    TimeRange timeRange3 = timeRange;
                    long j16 = resourceModel.selectDuration;
                    long j17 = j3 + j16;
                    HashMap hashMap3 = hashMap2;
                    it = it5;
                    long j18 = range.startTime;
                    double d16 = j16 / resourceModel.scaleDuration;
                    ArrayList<Subtitle> arrayList = new ArrayList();
                    Iterator it6 = list.iterator();
                    while (it6.hasNext()) {
                        SubtitleLine subtitleLine = (SubtitleLine) it6.next();
                        Iterator it7 = it6;
                        int i18 = i17;
                        Subtitle subtitle2 = subtitleLine.toSubtitle(j18 + (subtitleLine.getStartTimeUs() - j3), new SubtitlesMapKey(str, resourceModel.id));
                        isBlank = StringsKt__StringsJVMKt.isBlank(subtitle2.getLine());
                        if (isBlank) {
                            timeRange2 = timeRange3;
                            subtitle = null;
                        } else {
                            timeRange2 = timeRange3;
                            long j19 = (long) (j3 + (timeRange2.duration * d16));
                            long startTimeUs = subtitle2.getStartTimeUs();
                            if (j19 <= startTimeUs && startTimeUs <= j17) {
                                z18 = true;
                            } else {
                                z18 = false;
                            }
                            if (!z18) {
                                subtitle2 = null;
                            } else if (subtitle2.getEndTimeUs() > j17) {
                                subtitle2 = Subtitle.copy$default(subtitle2, null, 0L, subtitle2.getDurationUs() - (subtitle2.getEndTimeUs() - j17), 0L, j17, null, 0, false, null, com.tencent.luggage.wxa.fg.d.CTRL_INDEX, null);
                            }
                            subtitle = subtitle2;
                        }
                        if (subtitle != null) {
                            arrayList.add(subtitle);
                        }
                        timeRange3 = timeRange2;
                        it6 = it7;
                        i17 = i18;
                    }
                    i3 = i17;
                    if (!arrayList.isEmpty()) {
                        if (Math.abs(d16 - 1) < 0.01d) {
                            for (Subtitle subtitle3 : arrayList) {
                                WinkStickerModel a16 = f322144a.a(subtitle3, tavCut, winkStickerModel, isBilingual);
                                if (a16 != null) {
                                    hashMap3.put(subtitle3, a16);
                                }
                            }
                        } else {
                            drVar = tavCut;
                            z17 = isBilingual;
                            winkStickerModel2 = winkStickerModel;
                            hashMap = hashMap3;
                            for (Subtitle subtitle4 : arrayList) {
                                a aVar = f322144a;
                                Subtitle copy$default = Subtitle.copy$default(subtitle4, null, j18 + aVar.i(subtitle4.getStartTimeUs() - j3, d16), aVar.i(subtitle4.getDurationUs(), d16), 0L, 0L, null, 0, false, null, 505, null);
                                WinkStickerModel a17 = aVar.a(copy$default, drVar, winkStickerModel2, z17);
                                if (a17 != null) {
                                    hashMap.put(copy$default, a17);
                                }
                            }
                            linesMap2 = linesMap;
                            tavCut2 = drVar;
                            z19 = z17;
                            winkStickerModel3 = winkStickerModel2;
                            hashMap2 = hashMap;
                            list4 = list2;
                            list5 = list3;
                            it5 = it;
                            i16 = i3;
                        }
                    }
                    drVar = tavCut;
                    z17 = isBilingual;
                    winkStickerModel2 = winkStickerModel;
                    hashMap = hashMap3;
                    linesMap2 = linesMap;
                    tavCut2 = drVar;
                    z19 = z17;
                    winkStickerModel3 = winkStickerModel2;
                    hashMap2 = hashMap;
                    list4 = list2;
                    list5 = list3;
                    it5 = it;
                    i16 = i3;
                }
            }
            z17 = z19;
            list2 = list4;
            list3 = list5;
            hashMap = hashMap2;
            it = it5;
            i3 = i17;
            winkStickerModel2 = winkStickerModel3;
            drVar = tavCut2;
            linesMap2 = linesMap;
            tavCut2 = drVar;
            z19 = z17;
            winkStickerModel3 = winkStickerModel2;
            hashMap2 = hashMap;
            list4 = list2;
            list5 = list3;
            it5 = it;
            i16 = i3;
        }
        return hashMap2;
    }

    @Override // com.tencent.mobileqq.wink.editor.subtitle.n
    @NotNull
    public Map<SubtitlesMapKey, List<SubtitleLine>> c(@NotNull Map<SubtitlesMapKey, ? extends List<SubtitleLine>> linesMap, @NotNull List<Subtitle> subtitles) {
        Intrinsics.checkNotNullParameter(linesMap, "linesMap");
        Intrinsics.checkNotNullParameter(subtitles, "subtitles");
        HashMap hashMap = new HashMap();
        for (SubtitlesMapKey subtitlesMapKey : linesMap.keySet()) {
            ArrayList arrayList = new ArrayList();
            for (Subtitle subtitle : subtitles) {
                if (Intrinsics.areEqual(subtitle.getBelongToVideoPath(), subtitlesMapKey)) {
                    arrayList.add(subtitle.toSubtitleLine());
                }
            }
            hashMap.put(subtitlesMapKey, arrayList);
        }
        return hashMap;
    }

    @Nullable
    public WinkStickerModel f(@Nullable Map<String, ? extends WinkStickerModel> stickerMap) {
        Collection<? extends WinkStickerModel> values;
        Object obj = null;
        if (stickerMap == null || (values = stickerMap.values()) == null) {
            return null;
        }
        Iterator<T> it = values.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((WinkStickerModel) next).isSubtitleSticker()) {
                obj = next;
                break;
            }
        }
        return (WinkStickerModel) obj;
    }

    @NotNull
    public final String g() {
        return LATER_NAME_TRANS;
    }
}
