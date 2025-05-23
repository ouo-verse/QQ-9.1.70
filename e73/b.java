package e73;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.reflect.TypeToken;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.sticker.MetaMaterialContent;
import com.tencent.mobileqq.wink.editor.sticker.MetaMaterialContentWrapper;
import com.tencent.mobileqq.wink.editor.sticker.WinkPagStickerConfig;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.mobileqq.wink.editor.sticker.l;
import com.tencent.mobileqq.wink.editor.sticker.m;
import com.tencent.tavcut.core.render.builder.light.model.pag.PagEffectData;
import com.tencent.tavcut.core.render.builder.light.model.pag.TextLayerData;
import com.tencent.ttpic.util.GsonUtils;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.SizeF;
import com.tencent.videocut.render.extension.g;
import d73.LyricSticker;
import d73.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.light.lightAssetKit.components.ScreenTransform;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bH\u0002J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002JV\u0010\u001b\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J \u0010!\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0002J \u0010$\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u0019H\u0002J \u0010'\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u0019H\u0002J$\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00160\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u000b\u00a8\u0006,"}, d2 = {"Le73/b;", "", "Ld73/d;", "lyricSticker", "", h.F, "Ld73/e;", "lyricSentence", "", "foreignSentences", "d", "", "stickerDurationTimeUs", "f", "Lcom/tencent/mobileqq/wink/editor/WinkVideoTavCut;", "tavCut", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "metaMaterial", "sentence", "foreignSentence", "startFromUs", "durationUs", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "referenceSticker", "isBilingual", "", "widthOccupyHeight", "a", "stickerModel", "", "renderWidth", "renderHeight", "", "g", "Lcom/tencent/mobileqq/wink/editor/dr;", "playerRealHeight", "e", "model", "pointY", "c", "startOffsetTimeUs", "b", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f395828a = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001\u00a8\u0006\u0003"}, d2 = {"e73/b$a", "Lcom/google/gson/reflect/TypeToken;", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkPagStickerConfig;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a extends TypeToken<WinkPagStickerConfig> {
        a() {
        }
    }

    b() {
    }

    private final WinkStickerModel a(WinkVideoTavCut tavCut, MetaMaterial metaMaterial, e sentence, e foreignSentence, long startFromUs, long durationUs, WinkStickerModel referenceSticker, boolean isBilingual, float widthOccupyHeight) {
        float intValue;
        String str;
        Object orNull;
        Integer num = tavCut.getRenderSize().width;
        if (num != null) {
            int intValue2 = num.intValue();
            Integer num2 = tavCut.getRenderSize().height;
            if (num2 != null) {
                int intValue3 = num2.intValue();
                if (widthOccupyHeight > 0.0f) {
                    Intrinsics.checkNotNull(tavCut.getRenderSize().height);
                    intValue = Math.min(intValue2 / widthOccupyHeight, r7.intValue());
                } else {
                    Integer num3 = tavCut.getRenderSize().height;
                    Intrinsics.checkNotNull(num3);
                    intValue = num3.intValue();
                }
                float f16 = intValue;
                MetaMaterial material = metaMaterial.copy();
                MetaMaterialContentWrapper metaMaterialContentWrapper = new MetaMaterialContentWrapper(null, 1, null);
                String str2 = sentence.f393180a;
                Intrinsics.checkNotNullExpressionValue(str2, "sentence.mText");
                MetaMaterialContent metaMaterialContent = new MetaMaterialContent(str2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108862, null);
                if (foreignSentence != null) {
                    str = foreignSentence.f393180a;
                } else {
                    str = null;
                }
                if (str == null) {
                    str = "";
                }
                MetaMaterialContent metaMaterialContent2 = new MetaMaterialContent(str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108862, null);
                rd4.c cVar = rd4.c.f431135f;
                Intrinsics.checkNotNullExpressionValue(material, "material");
                PagEffectData A = cVar.A(m.y(material));
                if (A != null) {
                    m.B0(material, true);
                    com.tencent.mobileqq.wink.editor.c.A1(material, "scale_both");
                    if (isBilingual) {
                        for (TextLayerData textLayerData : A.getTextLayerList()) {
                            if (Intrinsics.areEqual(textLayerData.getLayerName(), "source")) {
                                metaMaterialContent.setLayerName(textLayerData.getLayerName());
                                metaMaterialContent.resetData(textLayerData);
                                metaMaterialContentWrapper.getMetaMaterialContent().add(metaMaterialContent);
                            }
                            if (Intrinsics.areEqual(textLayerData.getLayerName(), "translation")) {
                                metaMaterialContent2.setLayerName(textLayerData.getLayerName());
                                metaMaterialContent2.resetData(textLayerData);
                                metaMaterialContentWrapper.getMetaMaterialContent().add(metaMaterialContent2);
                            }
                        }
                    } else {
                        String str3 = sentence.f393180a;
                        Intrinsics.checkNotNullExpressionValue(str3, "sentence.mText");
                        MetaMaterialContent metaMaterialContent3 = new MetaMaterialContent(str3, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108862, null);
                        orNull = CollectionsKt___CollectionsKt.getOrNull(A.getTextLayerList(), 0);
                        metaMaterialContent3.resetData((TextLayerData) orNull);
                        metaMaterialContentWrapper.getMetaMaterialContent().add(metaMaterialContent3);
                    }
                    m.o0(material, metaMaterialContentWrapper);
                    WinkStickerModel t16 = l.t(material, tavCut, intValue2, intValue3, startFromUs, durationUs, true, false, 64, null);
                    if (t16 == null) {
                        return null;
                    }
                    if (referenceSticker == null) {
                        String c16 = com.tencent.mobileqq.wink.editor.sticker.e.c(t16);
                        if (com.tencent.mobileqq.wink.editor.sticker.e.e(t16, c16)) {
                            ScreenTransform f17 = com.tencent.videocut.render.utils.c.f384212a.f(c16);
                            if (f17 != null) {
                                t16 = WinkStickerModel.copyAndUpdate$default(t16, null, null, 0L, 0L, 0, t16.scaleX, t16.scaleY, g.a(f17), 0.0f, 0.0f, false, 0, 0, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, 0.0f, null, null, 0.0f, 0.0f, null, null, null, null, null, null, null, null, null, null, false, null, null, false, 0.0f, 0.0f, null, false, -993, 1048575, null);
                            }
                        } else {
                            t16 = com.tencent.mobileqq.wink.editor.sticker.e.a(t16, t16.centerX, e(tavCut, t16, f16));
                        }
                    } else {
                        t16 = WinkStickerModel.copyAndUpdate$default(t16, null, null, 0L, 0L, 0, referenceSticker.scaleX, referenceSticker.scaleY, referenceSticker.rotate, referenceSticker.centerX, referenceSticker.centerY, false, 0, 0, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, 0.0f, null, null, 0.0f, 0.0f, null, null, null, null, null, null, null, null, null, null, false, null, null, false, 0.0f, 0.0f, null, false, -993, 1048575, null);
                    }
                    g(t16, intValue2, intValue3);
                    return t16;
                }
            }
        }
        return null;
    }

    private final float c(WinkStickerModel model, int renderHeight, float pointY) {
        return (float) (1 - (Math.ceil((pointY - model.getOriginPointInView().f320588y) + (model.getSizeInView().f320588y / 2)) / (renderHeight / 2)));
    }

    private final e d(e lyricSentence, List<? extends e> foreignSentences) {
        if (lyricSentence != null && foreignSentences != null) {
            for (e eVar : foreignSentences) {
                if (eVar.f393181b == lyricSentence.f393181b) {
                    return eVar;
                }
            }
        }
        return null;
    }

    private final float e(dr tavCut, WinkStickerModel stickerModel, float playerRealHeight) {
        int screenHeight;
        Integer num = tavCut.getRenderSize().height;
        if (num != null) {
            screenHeight = num.intValue();
        } else {
            screenHeight = ViewUtils.getScreenHeight();
        }
        return c(stickerModel, screenHeight, stickerModel.getLeftTopInView().f320588y + stickerModel.getOriginPointInView().f320588y + ((playerRealHeight * 3.25f) / 10));
    }

    private final boolean f(e lyricSentence, long stickerDurationTimeUs) {
        boolean z16;
        String str = lyricSentence.f393180a;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && stickerDurationTimeUs >= lyricSentence.f393182c * 1000 * 0.5d) {
            return true;
        }
        return false;
    }

    private final void g(WinkStickerModel stickerModel, int renderWidth, int renderHeight) {
        stickerModel.updatePositionInView(renderWidth, renderHeight, stickerModel.scaleX, stickerModel.scaleY, stickerModel.centerX, stickerModel.centerY);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003d, code lost:
    
        if (r7 != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean h(LyricSticker lyricSticker) {
        String str;
        boolean z16;
        boolean z17;
        MetaMaterial material = lyricSticker.getMaterial();
        if (material == null) {
            return false;
        }
        if (!com.tencent.mobileqq.wink.editor.c.E0(material).contains("bilingual")) {
            String Z1 = WinkEditorResourceManager.a1().Z1(material);
            Intrinsics.checkNotNullExpressionValue(Z1, "getInstance().getTextPagContentPath(material)");
            m.F0(material, Z1);
            return false;
        }
        if (lyricSticker.getForeignLyric() != null) {
            d73.b foreignLyric = lyricSticker.getForeignLyric();
            if (foreignLyric != null && foreignLyric.k()) {
                z17 = true;
            } else {
                z17 = false;
            }
        }
        WinkPagStickerConfig winkPagStickerConfig = (WinkPagStickerConfig) GsonUtils.json2Obj(WinkEditorResourceDownloader.y(m.k(material)), new a().getType());
        if (winkPagStickerConfig != null) {
            str = winkPagStickerConfig.reservePagName;
        } else {
            str = null;
        }
        if (str != null) {
            String str2 = winkPagStickerConfig.reservePagName;
            Intrinsics.checkNotNullExpressionValue(str2, "config.reservePagName");
            if (str2.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                String Y1 = WinkEditorResourceManager.a1().Y1(material, winkPagStickerConfig.reservePagName);
                Intrinsics.checkNotNullExpressionValue(Y1, "getInstance()\n          \u2026l, config.reservePagName)");
                m.F0(material, Y1);
                return false;
            }
        }
        String Z12 = WinkEditorResourceManager.a1().Z1(material);
        Intrinsics.checkNotNullExpressionValue(Z12, "getInstance().getTextPagContentPath(material)");
        m.F0(material, Z12);
        return true;
    }

    @NotNull
    public final List<WinkStickerModel> b(@NotNull WinkVideoTavCut tavCut, @NotNull LyricSticker lyricSticker, long startOffsetTimeUs) {
        float f16;
        ArrayList<e> arrayList;
        float f17;
        long j3;
        ArrayList arrayList2;
        SizeF sizeF;
        Intrinsics.checkNotNullParameter(tavCut, "tavCut");
        Intrinsics.checkNotNullParameter(lyricSticker, "lyricSticker");
        ArrayList arrayList3 = new ArrayList();
        long mediaDurationUs = lyricSticker.getMediaDurationUs();
        long songStartTimeUs = lyricSticker.getSongStartTimeUs();
        d73.b lyric = lyricSticker.getLyric();
        lyricSticker.getForeignLyric();
        if (lyric != null && lyric.l() > 0) {
            boolean h16 = h(lyricSticker);
            int e16 = lyric.e(songStartTimeUs / 1000);
            if (e16 >= 0) {
                int l3 = lyric.l() - e16;
                List<e> i3 = lyric.i();
                Intrinsics.checkNotNullExpressionValue(i3, "lyric.sentenceList");
                Iterator<T> it = tavCut.V().videos.iterator();
                float f18 = Float.MAX_VALUE;
                while (true) {
                    boolean z16 = false;
                    if (!it.hasNext()) {
                        break;
                    }
                    ResourceModel resourceModel = ((MediaClip) it.next()).resource;
                    if (resourceModel != null && (sizeF = resourceModel.size) != null) {
                        float f19 = sizeF.height;
                        if (f19 == 0.0f) {
                            z16 = true;
                        }
                        if (!z16) {
                            f18 = Math.min(sizeF.width / f19, f18);
                        }
                    }
                }
                long j16 = startOffsetTimeUs;
                int i16 = 0;
                while (j16 < mediaDurationUs) {
                    int i17 = (i16 % l3) + e16;
                    e eVar = i3.get(i17);
                    if (i17 == lyric.l() - 1) {
                        f16 = f18;
                        eVar.f393182c = Math.max(0L, lyricSticker.getSongDurationUs() - (eVar.f393181b * 1000)) / 1000;
                    } else {
                        f16 = f18;
                    }
                    long j17 = eVar.f393182c;
                    long j18 = j17 * 1000;
                    if (i17 == e16) {
                        j18 = ((eVar.f393181b + j17) * 1000) - songStartTimeUs;
                    }
                    long min = Math.min(j18, mediaDurationUs - j16);
                    float f26 = f16;
                    List<e> list = i3;
                    int i18 = e16;
                    long j19 = eVar.f393182c;
                    String str = eVar.f393180a;
                    d73.b bVar = lyric;
                    StringBuilder sb5 = new StringBuilder();
                    ArrayList arrayList4 = arrayList3;
                    sb5.append("sentence index ");
                    sb5.append(i17);
                    sb5.append(", videoStartFromUs:");
                    sb5.append(j16 / 1000);
                    sb5.append(", videoDuration:");
                    sb5.append(mediaDurationUs / 1000);
                    sb5.append(", validDuration:");
                    sb5.append(min / 1000);
                    sb5.append(", sentenceDuration:");
                    sb5.append(j19);
                    sb5.append(", text:");
                    sb5.append(str);
                    w53.b.a("wink_sticker_lyric_Generator", sb5.toString());
                    d73.b foreignLyric = lyricSticker.getForeignLyric();
                    if (foreignLyric != null) {
                        arrayList = foreignLyric.f393162b;
                    } else {
                        arrayList = null;
                    }
                    e d16 = d(eVar, arrayList);
                    if (f(eVar, min)) {
                        MetaMaterial material = lyricSticker.getMaterial();
                        if (material == null) {
                            material = m.a0();
                        }
                        j3 = min;
                        f17 = f26;
                        WinkStickerModel a16 = a(tavCut, material, eVar, d16, j16, j3, lyricSticker.getReferenceSticker(), h16, f17);
                        arrayList2 = arrayList4;
                        if (a16 != null) {
                            arrayList2.add(a16);
                        }
                    } else {
                        f17 = f26;
                        j3 = min;
                        arrayList2 = arrayList4;
                    }
                    j16 += j3;
                    i16++;
                    f18 = f17;
                    e16 = i18;
                    i3 = list;
                    lyric = bVar;
                    arrayList3 = arrayList2;
                }
            }
        }
        return arrayList3;
    }
}
