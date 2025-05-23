package com.tencent.mobileqq.wink.newalbum.collector;

import com.tencent.mobileqq.wink.newalbum.processor.WinkNewAlbumContext;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s83.WinkNewAlbumFeatureConfigInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b4\u00105J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007J\u0016\u0010\t\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0007J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u001c\u0010\u0011\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0007J2\u0010\u0016\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u0002H\u0007J\u001a\u0010\u0017\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\nR\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u001dR\u0016\u0010!\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u001aR\u0016\u0010#\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001aR\u0016\u0010$\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001aR\"\u0010*\u001a\u00020%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010&\u001a\u0004\b\u0019\u0010'\"\u0004\b(\u0010)R\"\u0010-\u001a\u00020%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010&\u001a\u0004\b\u001c\u0010'\"\u0004\b,\u0010)R3\u00103\u001a\u001e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\f0.j\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\f`/8\u0006\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b\"\u00102\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/collector/m;", "", "", "Ls83/b;", "featureConfigInfoList", "", "i", "Lcom/tencent/mobileqq/wink/newalbum/processor/d;", "contexts", "a", "", "imageFeature", "", "d", "feature1", "feature2", "", tl.h.F, "textFeature", "", "path", "pathFilter", "f", "e", "", "b", "D", "imageFeatureThreshold", "c", "[F", "beautyFeature", "uglyFeature", "screenFeature", "aestheticAlpha", "g", "aestheticStart", "aestheticEnd", "", "I", "()I", "setAestheticHighScoreCount", "(I)V", "aestheticHighScoreCount", "j", "setAestheticLowScoreCount", "aestheticLowScoreCount", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "k", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "scoreMap", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class m {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static float[] beautyFeature;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static float[] uglyFeature;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static float[] screenFeature;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static int aestheticHighScoreCount;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static int aestheticLowScoreCount;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final m f324110a = new m();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final double imageFeatureThreshold = w83.b.f445025a.w();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static double aestheticAlpha = 4.0d;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static double aestheticStart = 62.0d;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static double aestheticEnd = 70.0d;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, Float> scoreMap = new HashMap<>();

    m() {
    }

    @JvmStatic
    public static final void a(@NotNull List<WinkNewAlbumContext> contexts) {
        Intrinsics.checkNotNullParameter(contexts, "contexts");
        if (beautyFeature != null && uglyFeature != null && screenFeature != null && w83.b.f445025a.M()) {
            for (WinkNewAlbumContext winkNewAlbumContext : contexts) {
                winkNewAlbumContext.p(d(winkNewAlbumContext.getForwardResult().getPhotoFeature()));
                winkNewAlbumContext.getMetaData().E(winkNewAlbumContext.getAestheticScore());
                scoreMap.put(winkNewAlbumContext.getMetaData().getId(), Float.valueOf(winkNewAlbumContext.getAestheticScore()));
                if (winkNewAlbumContext.getAestheticScore() < w83.b.f445025a.c()) {
                    aestheticLowScoreCount++;
                } else {
                    aestheticHighScoreCount++;
                }
            }
        }
    }

    @JvmStatic
    public static final float d(@NotNull float[] imageFeature) {
        double coerceAtMost;
        Intrinsics.checkNotNullParameter(imageFeature, "imageFeature");
        m mVar = f324110a;
        float e16 = mVar.e(beautyFeature, imageFeature);
        float e17 = mVar.e(uglyFeature, imageFeature);
        double e18 = mVar.e(screenFeature, imageFeature);
        double d16 = aestheticStart;
        if (e18 < d16) {
            return e16 - e17;
        }
        double d17 = aestheticEnd;
        if (d17 - d16 > 0.0d) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost((e18 - d16) / (d17 - d16), 1.0d);
            return (e16 - e17) * ((float) Math.exp(coerceAtMost * aestheticAlpha * (-1)));
        }
        return e16 - e17;
    }

    @JvmStatic
    public static final float f(@Nullable float[] textFeature, @Nullable float[] imageFeature, @NotNull String path, @NotNull List<String> pathFilter) {
        boolean contains$default;
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(pathFilter, "pathFilter");
        if (com.tencent.qcircle.cooperation.config.debug.c.h(QCircleDebugKey$SwitchStateKey.QCIRCLE_WINK_NEWALBUM_COLLECT_PATH, 1) && w83.b.f445025a.M()) {
            Iterator<T> it = pathFilter.iterator();
            while (it.hasNext()) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) path, (CharSequence) it.next(), false, 2, (Object) null);
                if (contains$default) {
                    return f324110a.e(textFeature, imageFeature) + 5;
                }
            }
        }
        return f324110a.e(textFeature, imageFeature);
    }

    @JvmStatic
    public static final boolean h(@Nullable float[] feature1, @Nullable float[] feature2) {
        if (f324110a.e(feature1, feature2) > imageFeatureThreshold) {
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final void i(@NotNull List<WinkNewAlbumFeatureConfigInfo> featureConfigInfoList) {
        float[] fArr;
        Object obj;
        float[] fArr2;
        Object obj2;
        float[] fArr3;
        Object obj3;
        Intrinsics.checkNotNullParameter(featureConfigInfoList, "featureConfigInfoList");
        List<WinkNewAlbumFeatureConfigInfo> list = featureConfigInfoList;
        Iterator<T> it = list.iterator();
        while (true) {
            fArr = null;
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((WinkNewAlbumFeatureConfigInfo) obj).getStoryID(), "aesthetic_beauty")) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        WinkNewAlbumFeatureConfigInfo winkNewAlbumFeatureConfigInfo = (WinkNewAlbumFeatureConfigInfo) obj;
        if (winkNewAlbumFeatureConfigInfo != null) {
            fArr2 = winkNewAlbumFeatureConfigInfo.getTextFeature();
        } else {
            fArr2 = null;
        }
        beautyFeature = fArr2;
        Iterator<T> it5 = list.iterator();
        while (true) {
            if (it5.hasNext()) {
                obj2 = it5.next();
                if (Intrinsics.areEqual(((WinkNewAlbumFeatureConfigInfo) obj2).getStoryID(), "aesthetic_ugly")) {
                    break;
                }
            } else {
                obj2 = null;
                break;
            }
        }
        WinkNewAlbumFeatureConfigInfo winkNewAlbumFeatureConfigInfo2 = (WinkNewAlbumFeatureConfigInfo) obj2;
        if (winkNewAlbumFeatureConfigInfo2 != null) {
            fArr3 = winkNewAlbumFeatureConfigInfo2.getTextFeature();
        } else {
            fArr3 = null;
        }
        uglyFeature = fArr3;
        Iterator<T> it6 = list.iterator();
        while (true) {
            if (it6.hasNext()) {
                obj3 = it6.next();
                if (Intrinsics.areEqual(((WinkNewAlbumFeatureConfigInfo) obj3).getStoryID(), "aesthetic_doc")) {
                    break;
                }
            } else {
                obj3 = null;
                break;
            }
        }
        WinkNewAlbumFeatureConfigInfo winkNewAlbumFeatureConfigInfo3 = (WinkNewAlbumFeatureConfigInfo) obj3;
        if (winkNewAlbumFeatureConfigInfo3 != null) {
            fArr = winkNewAlbumFeatureConfigInfo3.getTextFeature();
        }
        screenFeature = fArr;
        List<String> b16 = w83.b.f445025a.b();
        if (b16 != null && b16.size() == 3) {
            try {
                aestheticAlpha = Double.parseDouble(b16.get(0));
                aestheticStart = Double.parseDouble(b16.get(1));
                aestheticEnd = Double.parseDouble(b16.get(2));
            } catch (Exception e16) {
                QLog.e("WinkNewAlbumSimilarityManager", 1, e16, new Object[0]);
            }
        }
    }

    public final int b() {
        return aestheticHighScoreCount;
    }

    public final int c() {
        return aestheticLowScoreCount;
    }

    public final float e(@Nullable float[] feature1, @Nullable float[] feature2) {
        boolean z16;
        boolean z17;
        float f16 = 0.0f;
        if (feature1 != null && feature2 != null) {
            if (feature1.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                if (feature2.length == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    if (feature1.length != feature2.length) {
                        QLog.e("WinkNewAlbumSimilarityManager", 1, "<compareSimilarityFromVisualCosine>, can not get similarity, feature len is diff, feature1 len is " + feature1.length + ", feature2 len is " + feature2.length);
                        return 0.0f;
                    }
                    int length = feature1.length;
                    for (int i3 = 0; i3 < length; i3++) {
                        f16 += feature1[i3] * feature2[i3];
                    }
                    return f16 * 100;
                }
            }
            QLog.e("WinkNewAlbumSimilarityManager", 1, "<compareSimilarityFromVisualCosine>, can not get similarity, feature is empty, feature1 len is " + feature1.length + ", feature2 len is " + feature2.length);
            return 0.0f;
        }
        QLog.e("WinkNewAlbumSimilarityManager", 1, "<compareSimilarityFromVisualCosine>, can not get similarity, one or both features are null");
        return 0.0f;
    }

    @NotNull
    public final HashMap<String, Float> g() {
        return scoreMap;
    }
}
