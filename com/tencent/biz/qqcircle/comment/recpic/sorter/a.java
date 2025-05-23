package com.tencent.biz.qqcircle.comment.recpic.sorter;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\b\u0018\u0000 \u00052\u00020\u0001:\u0001\u0017B\u001d\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u001e\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J,\u0010\u0015\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u0014\u001a\u00020\u000e2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR \u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001fR\u0016\u0010\"\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010!R \u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001f\u00a8\u0006&"}, d2 = {"Lcom/tencent/biz/qqcircle/comment/recpic/sorter/a;", "", "", "message", "", "f", "", "Lcom/tencent/biz/qqcircle/comment/recpic/sorter/c;", "g", "image", "", "d", "result", "c", "", "currentStrategy", "", tl.h.F, "", "roughSorted", "startIndex", "e", "i", "a", "Ljava/util/List;", "images", "Lcom/tencent/biz/qqcircle/comment/recpic/sorter/b;", "b", "Lcom/tencent/biz/qqcircle/comment/recpic/sorter/b;", DownloadInfo.spKey_Config, "", "Ljava/util/Map;", "resultStrategyCount", "I", "resultCount", "selectedScores", "<init>", "(Ljava/util/List;Lcom/tencent/biz/qqcircle/comment/recpic/sorter/b;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<StrategyImage> images;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SortConfig config;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Integer, Integer> resultStrategyCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int resultCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Float> selectedScores;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f83861a;

        static {
            int[] iArr = new int[FilterStrategy.values().length];
            try {
                iArr[FilterStrategy.GLOBAL_DIFFERENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FilterStrategy.ADJACENT_DIFFERENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FilterStrategy.HYBRID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f83861a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class c<T> implements Comparator {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Float.valueOf(a.this.d((StrategyImage) t17)), Float.valueOf(a.this.d((StrategyImage) t16)));
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class d<T> implements Comparator {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Comparator f83863d;

        public d(Comparator comparator) {
            this.f83863d = comparator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            int compare = this.f83863d.compare(t16, t17);
            if (compare == 0) {
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((StrategyImage) t16).getStrategy()), Integer.valueOf(((StrategyImage) t17).getStrategy()));
                return compareValues;
            }
            return compare;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class e<T> implements Comparator {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Comparator f83864d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f83865e;

        public e(Comparator comparator, a aVar) {
            this.f83864d = comparator;
            this.f83865e = aVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            int compare = this.f83864d.compare(t16, t17);
            if (compare == 0) {
                Float f16 = this.f83865e.config.g().get(Integer.valueOf(((StrategyImage) t17).getStrategy()));
                if (f16 == null) {
                    f16 = Float.valueOf(1.0f);
                }
                Float f17 = this.f83865e.config.g().get(Integer.valueOf(((StrategyImage) t16).getStrategy()));
                if (f17 == null) {
                    f17 = Float.valueOf(1.0f);
                }
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(f16, f17);
                return compareValues;
            }
            return compare;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class f<T> implements Comparator {
        public f() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Float.valueOf(a.this.d((StrategyImage) t17)), Float.valueOf(a.this.d((StrategyImage) t16)));
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class g<T> implements Comparator {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Comparator f83867d;

        public g(Comparator comparator) {
            this.f83867d = comparator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            int compare = this.f83867d.compare(t16, t17);
            if (compare == 0) {
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((StrategyImage) t16).getStrategy()), Integer.valueOf(((StrategyImage) t17).getStrategy()));
                return compareValues;
            }
            return compare;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class h<T> implements Comparator {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Comparator f83868d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f83869e;

        public h(Comparator comparator, a aVar) {
            this.f83868d = comparator;
            this.f83869e = aVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            int compare = this.f83868d.compare(t16, t17);
            if (compare == 0) {
                Float f16 = this.f83869e.config.g().get(Integer.valueOf(((StrategyImage) t17).getStrategy()));
                if (f16 == null) {
                    f16 = Float.valueOf(1.0f);
                }
                Float f17 = this.f83869e.config.g().get(Integer.valueOf(((StrategyImage) t16).getStrategy()));
                if (f17 == null) {
                    f17 = Float.valueOf(1.0f);
                }
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(f16, f17);
                return compareValues;
            }
            return compare;
        }
    }

    public a(@NotNull List<StrategyImage> images, @NotNull SortConfig config) {
        Intrinsics.checkNotNullParameter(images, "images");
        Intrinsics.checkNotNullParameter(config, "config");
        this.images = images;
        this.config = config;
        this.resultStrategyCount = new LinkedHashMap();
        this.selectedScores = new LinkedHashMap();
    }

    private final float c(StrategyImage image, List<StrategyImage> result) {
        double pow;
        float f16;
        Object lastOrNull;
        Object lastOrNull2;
        float d16 = d(image);
        int i3 = b.f83861a[this.config.getFilterStrategy().ordinal()];
        boolean z16 = true;
        int i16 = 0;
        if (i3 != 1) {
            if (i3 == 2) {
                lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) result);
                StrategyImage strategyImage = (StrategyImage) lastOrNull;
                if (strategyImage == null || strategyImage.getStrategy() != image.getStrategy()) {
                    z16 = false;
                }
                if (z16) {
                    f16 = this.config.getDecayFactor();
                } else {
                    return d16;
                }
            } else if (i3 == 3) {
                if (this.resultCount < this.config.getHybridThresholdStart()) {
                    Integer num = this.resultStrategyCount.get(Integer.valueOf(image.getStrategy()));
                    if (num != null) {
                        i16 = num.intValue();
                    }
                    if (i16 > 0) {
                        pow = Math.pow(this.config.getDecayFactor(), i16);
                    } else {
                        return d16;
                    }
                } else if (this.resultCount < this.config.getHybridThresholdEnd()) {
                    lastOrNull2 = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) result);
                    StrategyImage strategyImage2 = (StrategyImage) lastOrNull2;
                    if (strategyImage2 == null || strategyImage2.getStrategy() != image.getStrategy()) {
                        z16 = false;
                    }
                    if (z16) {
                        f16 = this.config.getDecayFactor();
                    } else {
                        return d16;
                    }
                } else {
                    return d16;
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return d16 * f16;
        }
        Integer num2 = this.resultStrategyCount.get(Integer.valueOf(image.getStrategy()));
        if (num2 != null) {
            i16 = num2.intValue();
        }
        if (i16 > 0) {
            pow = Math.pow(this.config.getDecayFactor(), i16);
        } else {
            return d16;
        }
        f16 = (float) pow;
        return d16 * f16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float d(StrategyImage image) {
        float f16;
        float score = image.getScore();
        Float f17 = this.config.g().get(Integer.valueOf(image.getStrategy()));
        if (f17 != null) {
            f16 = f17.floatValue();
        } else {
            f16 = 1.0f;
        }
        return score * f16;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005c A[LOOP:0: B:10:0x0029->B:20:0x005c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0127 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a3 A[LOOP:1: B:36:0x007e->B:46:0x00a3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0127 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ee A[LOOP:2: B:59:0x00c9->B:69:0x00ee, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0127 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0129 A[LOOP:3: B:74:0x00f6->B:84:0x0129, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0127 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int e(List<StrategyImage> roughSorted, int startIndex, List<StrategyImage> result) {
        int i3;
        boolean z16;
        int i16;
        Object lastOrNull;
        boolean z17;
        Object lastOrNull2;
        boolean z18;
        boolean z19;
        int i17;
        int i18 = b.f83861a[this.config.getFilterStrategy().ordinal()];
        if (i18 != 1) {
            Integer num = null;
            if (i18 == 2) {
                lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) result);
                StrategyImage strategyImage = (StrategyImage) lastOrNull;
                if (strategyImage != null) {
                    num = Integer.valueOf(strategyImage.getStrategy());
                }
                i3 = 0;
                for (StrategyImage strategyImage2 : roughSorted) {
                    if (roughSorted.indexOf(strategyImage2) >= startIndex) {
                        int strategy = strategyImage2.getStrategy();
                        if (num == null || strategy != num.intValue()) {
                            z17 = true;
                            if (z17) {
                                i3++;
                            } else {
                                return i3;
                            }
                        }
                    }
                    z17 = false;
                    if (z17) {
                    }
                }
                return -1;
            }
            if (i18 == 3) {
                if (this.resultCount < this.config.getHybridThresholdStart()) {
                    i3 = 0;
                    for (StrategyImage strategyImage3 : roughSorted) {
                        if (roughSorted.indexOf(strategyImage3) >= startIndex) {
                            Integer num2 = this.resultStrategyCount.get(Integer.valueOf(strategyImage3.getStrategy()));
                            if (num2 != null) {
                                i17 = num2.intValue();
                            } else {
                                i17 = 0;
                            }
                            if (i17 == 0) {
                                z19 = true;
                                if (z19) {
                                    i3++;
                                } else {
                                    return i3;
                                }
                            }
                        }
                        z19 = false;
                        if (z19) {
                        }
                    }
                    return -1;
                }
                if (this.resultCount < this.config.getHybridThresholdEnd()) {
                    lastOrNull2 = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) result);
                    StrategyImage strategyImage4 = (StrategyImage) lastOrNull2;
                    if (strategyImage4 != null) {
                        num = Integer.valueOf(strategyImage4.getStrategy());
                    }
                    i3 = 0;
                    for (StrategyImage strategyImage5 : roughSorted) {
                        if (roughSorted.indexOf(strategyImage5) >= startIndex) {
                            int strategy2 = strategyImage5.getStrategy();
                            if (num == null || strategy2 != num.intValue()) {
                                z18 = true;
                                if (z18) {
                                    i3++;
                                } else {
                                    return i3;
                                }
                            }
                        }
                        z18 = false;
                        if (z18) {
                        }
                    }
                } else if (startIndex < roughSorted.size()) {
                    return startIndex;
                }
                return -1;
            }
            throw new NoWhenBranchMatchedException();
        }
        i3 = 0;
        for (StrategyImage strategyImage6 : roughSorted) {
            if (roughSorted.indexOf(strategyImage6) >= startIndex) {
                Integer num3 = this.resultStrategyCount.get(Integer.valueOf(strategyImage6.getStrategy()));
                if (num3 != null) {
                    i16 = num3.intValue();
                } else {
                    i16 = 0;
                }
                if (i16 == 0) {
                    z16 = true;
                    if (!z16) {
                        return i3;
                    }
                    i3++;
                }
            }
            z16 = false;
            if (!z16) {
            }
        }
        return -1;
    }

    private final List<StrategyImage> g() {
        int mapCapacity;
        List<StrategyImage> sortedWith;
        int mapCapacity2;
        List list;
        Object maxWithOrNull;
        List<StrategyImage> list2 = this.images;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : list2) {
            String path = ((StrategyImage) obj).getPath();
            Object obj2 = linkedHashMap.get(path);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(path, obj2);
            }
            ((List) obj2).add(obj);
        }
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(linkedHashMap.size());
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(mapCapacity);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Object key = entry.getKey();
            maxWithOrNull = CollectionsKt___CollectionsKt.maxWithOrNull((List) entry.getValue(), new g(new h(new f(), this)));
            Intrinsics.checkNotNull(maxWithOrNull);
            linkedHashMap2.put(key, (StrategyImage) maxWithOrNull);
        }
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(linkedHashMap2.values(), new d(new e(new c(), this)));
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_limit_rec_pic_sort_max_size", true)) {
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Object obj3 : sortedWith) {
                Integer valueOf = Integer.valueOf(((StrategyImage) obj3).getStrategy());
                Object obj4 = linkedHashMap3.get(valueOf);
                if (obj4 == null) {
                    obj4 = new ArrayList();
                    linkedHashMap3.put(valueOf, obj4);
                }
                ((List) obj4).add(obj3);
            }
            mapCapacity2 = MapsKt__MapsJVMKt.mapCapacity(linkedHashMap3.size());
            LinkedHashMap linkedHashMap4 = new LinkedHashMap(mapCapacity2);
            for (Map.Entry entry2 : linkedHashMap3.entrySet()) {
                Object key2 = entry2.getKey();
                List list3 = (List) entry2.getValue();
                if (list3.size() > this.config.getMaxCount()) {
                    list3 = list3.subList(0, this.config.getMaxCount());
                }
                linkedHashMap4.put(key2, list3);
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = linkedHashMap4.entrySet().iterator();
            while (it.hasNext()) {
                list = CollectionsKt___CollectionsKt.toList((List) ((Map.Entry) it.next()).getValue());
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, list);
            }
            return arrayList;
        }
        return sortedWith;
    }

    private final boolean h(int currentStrategy, List<StrategyImage> result) {
        int i3;
        Object lastOrNull;
        Object lastOrNull2;
        int i16;
        int i17 = b.f83861a[this.config.getFilterStrategy().ordinal()];
        if (i17 != 1) {
            if (i17 == 2) {
                lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) result);
                StrategyImage strategyImage = (StrategyImage) lastOrNull;
                if (strategyImage != null && strategyImage.getStrategy() == currentStrategy) {
                    return true;
                }
            } else if (i17 == 3) {
                if (this.resultCount < this.config.getHybridThresholdStart()) {
                    Integer num = this.resultStrategyCount.get(Integer.valueOf(currentStrategy));
                    if (num != null) {
                        i16 = num.intValue();
                    } else {
                        i16 = 0;
                    }
                    if (i16 > 0) {
                        return true;
                    }
                } else if (this.resultCount < this.config.getHybridThresholdEnd()) {
                    lastOrNull2 = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) result);
                    StrategyImage strategyImage2 = (StrategyImage) lastOrNull2;
                    if (strategyImage2 != null && strategyImage2.getStrategy() == currentStrategy) {
                        return true;
                    }
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else if (this.resultCount < this.config.getDecayThreshold()) {
            Integer num2 = this.resultStrategyCount.get(Integer.valueOf(currentStrategy));
            if (num2 != null) {
                i3 = num2.intValue();
            } else {
                i3 = 0;
            }
            if (i3 > 0) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final List<StrategyImage> i() {
        List<StrategyImage> mutableList;
        int i3;
        int i16;
        int i17;
        f("\u5f00\u59cb\u6392\u5e8f\uff0c\u8f93\u5165\u56fe\u7247\u6570\u91cf: " + this.images.size());
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) g());
        f("\n\u7c97\u6392\u7ed3\u679c:");
        int i18 = 0;
        for (Object obj : mutableList) {
            int i19 = i18 + 1;
            if (i18 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            StrategyImage strategyImage = (StrategyImage) obj;
            f(i18 + ": \u7b56\u7565=" + strategyImage.getStrategy() + ", ID=" + strategyImage.getId() + ", \u521d\u59cb\u5206\u6570=" + d(strategyImage));
            i18 = i19;
        }
        ArrayList arrayList = new ArrayList();
        while (!mutableList.isEmpty()) {
            StrategyImage strategyImage2 = mutableList.get(0);
            if (!h(strategyImage2.getStrategy(), arrayList)) {
                f("\n\u7b56\u7565" + strategyImage2.getStrategy() + "\u4e0d\u9700\u8981\u8870\u51cf\uff0c\u76f4\u63a5\u4f7f\u7528");
                mutableList.remove(0);
                Map<Integer, Integer> map = this.resultStrategyCount;
                Integer valueOf = Integer.valueOf(strategyImage2.getStrategy());
                Integer num = this.resultStrategyCount.get(Integer.valueOf(strategyImage2.getStrategy()));
                if (num != null) {
                    i3 = num.intValue();
                } else {
                    i3 = 0;
                }
                map.put(valueOf, Integer.valueOf(i3 + 1));
                this.resultCount++;
                arrayList.add(strategyImage2);
            } else {
                float c16 = c(strategyImage2, arrayList);
                f("\n\u5f53\u524d\u5019\u9009: ID=" + strategyImage2.getId() + ", \u7b56\u7565\u8ba1\u6570=" + this.resultStrategyCount.get(Integer.valueOf(strategyImage2.getStrategy())) + ", \u8870\u51cf\u540e\u5206\u6570=" + c16);
                int e16 = e(mutableList, 1, arrayList);
                if (e16 > 0) {
                    StrategyImage strategyImage3 = mutableList.get(e16);
                    float d16 = d(strategyImage3);
                    f("\u4e0b\u4e00\u4e2a\u6709\u6548\u56fe\u7247: ID=" + strategyImage3.getId() + ", \u7b56\u7565=" + strategyImage3.getStrategy() + ", \u539f\u59cb\u5206\u6570=" + d16);
                    if (d16 > c16) {
                        f("\u4f7f\u7528\u4e0b\u4e00\u4e2a\u6709\u6548\u56fe\u7247");
                        StrategyImage remove = mutableList.remove(e16);
                        Map<Integer, Integer> map2 = this.resultStrategyCount;
                        Integer valueOf2 = Integer.valueOf(remove.getStrategy());
                        Integer num2 = this.resultStrategyCount.get(Integer.valueOf(remove.getStrategy()));
                        if (num2 != null) {
                            i17 = num2.intValue();
                        } else {
                            i17 = 0;
                        }
                        map2.put(valueOf2, Integer.valueOf(i17 + 1));
                        this.resultCount++;
                        arrayList.add(remove);
                    }
                }
                f("\u4f7f\u7528\u5f53\u524d\u56fe\u7247");
                StrategyImage remove2 = mutableList.remove(0);
                Map<Integer, Integer> map3 = this.resultStrategyCount;
                Integer valueOf3 = Integer.valueOf(remove2.getStrategy());
                Integer num3 = this.resultStrategyCount.get(Integer.valueOf(remove2.getStrategy()));
                if (num3 != null) {
                    i16 = num3.intValue();
                } else {
                    i16 = 0;
                }
                map3.put(valueOf3, Integer.valueOf(i16 + 1));
                this.resultCount++;
                arrayList.add(remove2);
            }
        }
        f("\n\u6700\u7ec8\u6392\u5e8f\u7ed3\u679c:");
        int i26 = 0;
        for (Object obj2 : arrayList) {
            int i27 = i26 + 1;
            if (i26 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            StrategyImage strategyImage4 = (StrategyImage) obj2;
            f(i26 + ": \u7b56\u7565=" + strategyImage4.getStrategy() + ", ID=" + strategyImage4.getId() + ", \u539f\u59cb\u5206\u6570=" + strategyImage4.getScore());
            i26 = i27;
        }
        if (arrayList.size() > this.config.getMaxCount()) {
            return arrayList.subList(0, this.config.getMaxCount());
        }
        return arrayList;
    }

    private final void f(String message) {
    }
}
