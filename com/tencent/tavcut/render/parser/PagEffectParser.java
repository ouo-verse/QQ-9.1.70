package com.tencent.tavcut.render.parser;

import android.util.LruCache;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.tavcut.model.ImageLayerData;
import com.tencent.tavcut.model.LayerMarkData;
import com.tencent.tavcut.model.PagEffectData;
import com.tencent.tavcut.model.TextLayerData;
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
import tl.h;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u0011R'\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00040\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/tavcut/render/parser/PagEffectParser;", "", "Lorg/libpag/PAGFile;", "pagFile", "Lcom/tencent/tavcut/model/PagEffectData;", "f", "", "Lcom/tencent/tavcut/model/TextLayerData;", h.F, "Lcom/tencent/tavcut/model/ImageLayerData;", "g", "Lorg/libpag/PAGText;", "c", "Lorg/libpag/PAGLayer;", "pagLayer", "Lcom/tencent/tavcut/model/LayerMarkData;", "e", "", "path", "", "a", "filePath", "d", "Landroid/util/LruCache;", "Lkotlin/Lazy;", "b", "()Landroid/util/LruCache;", "CACHE_MAP", "<init>", "()V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class PagEffectParser {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Lazy CACHE_MAP;

    /* renamed from: b, reason: collision with root package name */
    public static final PagEffectParser f374399b = new PagEffectParser();

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LruCache<String, PagEffectData>>() { // from class: com.tencent.tavcut.render.parser.PagEffectParser$CACHE_MAP$2
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

    private final boolean a(String path) {
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

    private final LruCache<String, PagEffectData> b() {
        return (LruCache) CACHE_MAP.getValue();
    }

    private final List<PAGText> c(PAGFile pagFile) {
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

    private final List<LayerMarkData> e(PAGLayer pagLayer) {
        PAGMarker[] markers = pagLayer.markers();
        Intrinsics.checkExpressionValueIsNotNull(markers, "pagLayer.markers()");
        ArrayList arrayList = new ArrayList(markers.length);
        for (PAGMarker pAGMarker : markers) {
            arrayList.add(new LayerMarkData(pAGMarker.mStartTime, pAGMarker.mDuration, pAGMarker.mComment, null, 8, null));
        }
        return arrayList;
    }

    private final PagEffectData f(PAGFile pagFile) {
        List<TextLayerData> h16 = h(pagFile);
        List<ImageLayerData> g16 = g(pagFile);
        long duration = pagFile.duration();
        return new PagEffectData(pagFile.path(), pagFile.width(), pagFile.height(), duration, h16, g16, pagFile.timeStretchMode(), null, 128, null);
    }

    private final List<ImageLayerData> g(PAGFile pagFile) {
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
                    arrayList.add(new ImageLayerData(editableIndex, layerName, layerType, e(imageLayer), null, 16, null));
                }
            }
        }
        return arrayList;
    }

    private final List<TextLayerData> h(PAGFile pagFile) {
        boolean z16;
        char c16;
        List<TextLayerData> emptyList;
        List<PAGText> c17 = c(pagFile);
        List<PAGText> list = c17;
        char c18 = 0;
        char c19 = 1;
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
                    c16 = c19;
                } else {
                    c16 = c18;
                }
                if ((c16 ^ c19) != 0) {
                    PAGLayer pagLayer = layersByEditableIndex[c18];
                    PAGText pAGText = c17.get(i3);
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
                    arrayList.add(new TextLayerData(valueOf, layerName, valueOf2, str, valueOf3, str2, str3, e(pagLayer), valueOf5, valueOf4, valueOf6, valueOf7, null, valueOf9, valueOf8, valueOf10, valueOf12, valueOf13, valueOf11, valueOf14, valueOf15, valueOf16, valueOf18, valueOf17, null, 16781312, null));
                    i3++;
                    c18 = 0;
                    c19 = 1;
                }
            }
            i3++;
            c18 = 0;
            c19 = 1;
        }
        return arrayList;
    }

    @Nullable
    public final PagEffectData d(@NotNull String filePath) {
        Intrinsics.checkParameterIsNotNull(filePath, "filePath");
        if (!a(filePath)) {
            return null;
        }
        PagEffectData pagEffectData = b().get(filePath);
        if (pagEffectData == null) {
            PAGFile Load = PagViewMonitor.Load(filePath);
            if (Load == null) {
                return null;
            }
            PagEffectData f16 = f(Load);
            if (f16 != null) {
                f374399b.b().put(filePath, f16);
            }
            return f16;
        }
        return pagEffectData;
    }
}
