package com.tencent.tavcut.core.render.parser;

import android.content.Context;
import android.util.LruCache;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.tavcut.core.render.builder.light.model.pag.ImageLayerData;
import com.tencent.tavcut.core.render.builder.light.model.pag.LayerMarkData;
import com.tencent.tavcut.core.render.builder.light.model.pag.PagEffectData;
import com.tencent.tavcut.core.render.builder.light.model.pag.TextLayerData;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGFile;
import org.libpag.PAGLayer;
import org.libpag.PAGMarker;
import org.libpag.PAGText;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0019\u001a\u00020\u0004J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004J\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00142\u0006\u0010 \u001a\u00020!H\u0002J\u0012\u0010\"\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R'\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006'"}, d2 = {"Lcom/tencent/tavcut/core/render/parser/PagEffectParser;", "", "()V", "ASSET_FILE_PATH_PREFIX", "", "CACHE_MAP", "Landroid/util/LruCache;", "Lcom/tencent/tavcut/core/render/builder/light/model/pag/PagEffectData;", "getCACHE_MAP", "()Landroid/util/LruCache;", "CACHE_MAP$delegate", "Lkotlin/Lazy;", "CACHE_SIZE", "", HippyReporter.RemoveEngineReason.CLEAR_CACHE, "", "exist", "", "path", "getPAGTextList", "", "Lorg/libpag/PAGText;", "pagFile", "Lorg/libpag/PAGFile;", "parse", "filePath", "parseFromAsset", "context", "Landroid/content/Context;", "assetFileName", "parseLayerMark", "Lcom/tencent/tavcut/core/render/builder/light/model/pag/LayerMarkData;", "pagLayer", "Lorg/libpag/PAGLayer;", "parsePagFile", "readAllImageData", "Lcom/tencent/tavcut/core/render/builder/light/model/pag/ImageLayerData;", "readAllTextData", "Lcom/tencent/tavcut/core/render/builder/light/model/pag/TextLayerData;", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class PagEffectParser {
    private static final String ASSET_FILE_PATH_PREFIX = "android_asset://";

    /* renamed from: CACHE_MAP$delegate, reason: from kotlin metadata */
    private static final Lazy CACHE_MAP;
    private static final int CACHE_SIZE = 10;
    public static final PagEffectParser INSTANCE = new PagEffectParser();

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LruCache<String, PagEffectData>>() { // from class: com.tencent.tavcut.core.render.parser.PagEffectParser$CACHE_MAP$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LruCache<String, PagEffectData> invoke() {
                return new LruCache<>(10);
            }
        });
        CACHE_MAP = lazy;
    }

    PagEffectParser() {
    }

    private final boolean exist(String path) {
        boolean z16;
        if (path != null && path.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        return new File(path).exists();
    }

    private final LruCache<String, PagEffectData> getCACHE_MAP() {
        return (LruCache) CACHE_MAP.getValue();
    }

    private final List<PAGText> getPAGTextList(PAGFile pagFile) {
        int numTexts = pagFile.numTexts();
        if (numTexts > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < numTexts; i3++) {
                PAGText textData = pagFile.getTextData(i3);
                if (textData != null) {
                    arrayList.add(textData);
                }
            }
            return arrayList;
        }
        return null;
    }

    private final List<LayerMarkData> parseLayerMark(PAGLayer pagLayer) {
        PAGMarker[] markers = pagLayer.markers();
        Intrinsics.checkExpressionValueIsNotNull(markers, "pagLayer.markers()");
        ArrayList arrayList = new ArrayList(markers.length);
        for (PAGMarker pAGMarker : markers) {
            arrayList.add(new LayerMarkData(pAGMarker.mStartTime, pAGMarker.mDuration, pAGMarker.mComment));
        }
        return arrayList;
    }

    private final PagEffectData parsePagFile(PAGFile pagFile) {
        List<TextLayerData> readAllTextData = readAllTextData(pagFile);
        List<ImageLayerData> readAllImageData = readAllImageData(pagFile);
        long duration = pagFile.duration();
        return new PagEffectData(pagFile.path(), pagFile.width(), pagFile.height(), duration, readAllTextData, readAllImageData, pagFile.timeStretchMode());
    }

    private final List<ImageLayerData> readAllImageData(PAGFile pagFile) {
        boolean z16;
        ArrayList arrayList = new ArrayList();
        int numImages = pagFile.numImages();
        for (int i3 = 0; i3 < numImages; i3++) {
            PAGLayer[] layersByEditableIndex = pagFile.getLayersByEditableIndex(i3, 5);
            if (layersByEditableIndex != null) {
                if (layersByEditableIndex.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    PAGLayer imageLayer = layersByEditableIndex[0];
                    int editableIndex = imageLayer.editableIndex();
                    String layerName = imageLayer.layerName();
                    int layerType = imageLayer.layerType();
                    Intrinsics.checkExpressionValueIsNotNull(imageLayer, "imageLayer");
                    arrayList.add(new ImageLayerData(editableIndex, layerName, layerType, parseLayerMark(imageLayer)));
                }
            }
        }
        return arrayList;
    }

    private final List<TextLayerData> readAllTextData(PAGFile pagFile) {
        boolean z16;
        char c16;
        List<TextLayerData> emptyList;
        List<PAGText> pAGTextList = getPAGTextList(pagFile);
        List<PAGText> list = pAGTextList;
        char c17 = 0;
        char c18 = 1;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        int i3 = 0;
        while (i3 < size) {
            PAGLayer[] layersByEditableIndex = pagFile.getLayersByEditableIndex(i3, 3);
            if (layersByEditableIndex != null) {
                if (layersByEditableIndex.length == 0) {
                    c16 = c18;
                } else {
                    c16 = c17;
                }
                if ((c16 ^ c18) != 0) {
                    PAGLayer pagLayer = layersByEditableIndex[c17];
                    PAGText pAGText = pAGTextList.get(i3);
                    Integer valueOf = Integer.valueOf(pagLayer.editableIndex());
                    String layerName = pagLayer.layerName();
                    Integer valueOf2 = Integer.valueOf(pagLayer.layerType());
                    String str = pAGText.text;
                    Integer valueOf3 = Integer.valueOf(pAGText.fillColor);
                    String str2 = pAGText.fontFamily;
                    String str3 = pAGText.fontStyle;
                    Boolean valueOf4 = Boolean.valueOf(pAGText.applyStroke);
                    Boolean valueOf5 = Boolean.valueOf(pAGText.applyFill);
                    Float valueOf6 = Float.valueOf(pAGText.baselineShift);
                    Boolean valueOf7 = Boolean.valueOf(pAGText.boxText);
                    Boolean valueOf8 = Boolean.valueOf(pAGText.fauxItalic);
                    Boolean valueOf9 = Boolean.valueOf(pAGText.fauxBold);
                    Float valueOf10 = Float.valueOf(pAGText.fontSize);
                    Float valueOf11 = Float.valueOf(pAGText.strokeWidth);
                    Integer valueOf12 = Integer.valueOf(pAGText.strokeColor);
                    Boolean valueOf13 = Boolean.valueOf(pAGText.strokeOverFill);
                    Integer valueOf14 = Integer.valueOf(pAGText.justification);
                    Float valueOf15 = Float.valueOf(pAGText.leading);
                    Float valueOf16 = Float.valueOf(pAGText.tracking);
                    Integer valueOf17 = Integer.valueOf(pAGText.backgroundAlpha);
                    Integer valueOf18 = Integer.valueOf(pAGText.backgroundColor);
                    Intrinsics.checkExpressionValueIsNotNull(pagLayer, "pagLayer");
                    arrayList.add(new TextLayerData(valueOf, layerName, valueOf2, str, valueOf3, str2, str3, parseLayerMark(pagLayer), valueOf5, valueOf4, valueOf6, valueOf7, null, valueOf9, valueOf8, valueOf10, valueOf12, valueOf13, valueOf11, valueOf14, valueOf15, valueOf16, valueOf18, valueOf17, 4096, null));
                    i3++;
                    c17 = 0;
                    c18 = 1;
                }
            }
            i3++;
            c17 = 0;
            c18 = 1;
        }
        return arrayList;
    }

    public final void clearCache() {
        getCACHE_MAP().evictAll();
    }

    @Nullable
    public final PagEffectData parse(@NotNull String filePath) {
        Intrinsics.checkParameterIsNotNull(filePath, "filePath");
        if (!exist(filePath)) {
            return null;
        }
        PagEffectData pagEffectData = getCACHE_MAP().get(filePath);
        if (pagEffectData == null) {
            PAGFile Load = PagViewMonitor.Load(filePath);
            if (Load == null) {
                return null;
            }
            PagEffectData parsePagFile = parsePagFile(Load);
            if (parsePagFile != null) {
                INSTANCE.getCACHE_MAP().put(filePath, parsePagFile);
            }
            return parsePagFile;
        }
        return pagEffectData;
    }

    @Nullable
    public final PagEffectData parseFromAsset(@NotNull Context context, @NotNull String assetFileName) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(assetFileName, "assetFileName");
        String str = "android_asset://" + assetFileName;
        PagEffectData pagEffectData = getCACHE_MAP().get(str);
        if (pagEffectData == null) {
            PAGFile Load = PagViewMonitor.Load(context.getAssets(), assetFileName);
            if (Load != null) {
                PagEffectData parsePagFile = parsePagFile(Load);
                if (parsePagFile != null) {
                    INSTANCE.getCACHE_MAP().put(str, parsePagFile);
                }
                return parsePagFile;
            }
            return null;
        }
        return pagEffectData;
    }
}
