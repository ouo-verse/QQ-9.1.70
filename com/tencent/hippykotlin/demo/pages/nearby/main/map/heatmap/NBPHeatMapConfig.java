package com.tencent.hippykotlin.demo.pages.nearby.main.map.heatmap;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* loaded from: classes31.dex */
public final class NBPHeatMapConfig {
    public static final int[] HEAT_MAP_CONFIG_GRADIENT_COLORS_CUSTOM_DEFAULT;
    public static final int[] HEAT_MAP_CONFIG_GRADIENT_COLORS_DEFAULT;
    public static final List<Float> HEAT_MAP_CONFIG_GRADIENT_START_POINTS_CUSTOM_DEFAULT;
    public static final List<Float> HEAT_MAP_CONFIG_GRADIENT_START_POINTS_DEFAULT;
    public static final NBPHeatMapConfig INSTANCE;

    /* loaded from: classes31.dex */
    public static final class NearbyProHeatMapConfig {
        public final int[] customGradientColors;
        public final List<Float> customGradientStartPoints;
        public final boolean dynamicIntensityRangeMax;
        public final int[] gradientColors;
        public final List<Float> gradientStartPoints;
        public final float intensityRangeMax;
        public final float intensityRangeMin;
        public final int mode;
        public final float opacity;
        public final float optimizeEnlargeRatio;
        public final int optimizePreloadDis;
        public final float optimizeTransitionRatio;
        public final float optimizeZoomInRatio;
        public final float optimizeZoomOutRatio;
        public final int radius;

        /* JADX WARN: Incorrect types in method signature: (Ljava/lang/Object;IFFFZ[ILjava/util/List<Ljava/lang/Float;>;[ILjava/util/List<Ljava/lang/Float;>;IFFFF)V */
        public NearbyProHeatMapConfig(int i3, int i16, float f16, float f17, float f18, boolean z16, int[] iArr, List list, int[] iArr2, List list2, int i17, float f19, float f26, float f27, float f28) {
            this.mode = i3;
            this.radius = i16;
            this.opacity = f16;
            this.intensityRangeMin = f17;
            this.intensityRangeMax = f18;
            this.dynamicIntensityRangeMax = z16;
            this.gradientColors = iArr;
            this.gradientStartPoints = list;
            this.customGradientColors = iArr2;
            this.customGradientStartPoints = list2;
            this.optimizePreloadDis = i17;
            this.optimizeEnlargeRatio = f19;
            this.optimizeTransitionRatio = f26;
            this.optimizeZoomInRatio = f27;
            this.optimizeZoomOutRatio = f28;
        }
    }

    static {
        List<Float> listOf;
        List<Float> listOf2;
        NBPHeatMapConfig nBPHeatMapConfig = new NBPHeatMapConfig();
        INSTANCE = nBPHeatMapConfig;
        h.Companion companion = h.INSTANCE;
        HEAT_MAP_CONFIG_GRADIENT_COLORS_DEFAULT = new int[]{nBPHeatMapConfig.heatMapArgb(204, 78, 255, 225), nBPHeatMapConfig.heatMapArgb(221, 255, 209, 79), nBPHeatMapConfig.heatMapArgb(221, 255, 131, 63), nBPHeatMapConfig.heatMapArgb(255, 255, 69, 114), nBPHeatMapConfig.heatMapArgb(255, 255, 63, 224)};
        Float valueOf = Float.valueOf(1.0f);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(0.35f), Float.valueOf(0.65f), Float.valueOf(0.85f), Float.valueOf(0.95f), valueOf});
        HEAT_MAP_CONFIG_GRADIENT_START_POINTS_DEFAULT = listOf;
        HEAT_MAP_CONFIG_GRADIENT_COLORS_CUSTOM_DEFAULT = new int[]{nBPHeatMapConfig.heatMapArgb(153, 255, 0, 0), nBPHeatMapConfig.heatMapArgb(153, 255, 255, 0), nBPHeatMapConfig.heatMapArgb(153, 0, 255, 0), nBPHeatMapConfig.heatMapArgb(153, 0, 255, 255), nBPHeatMapConfig.heatMapArgb(0, 0, 255, 255)};
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(0.0f), Float.valueOf(0.2f), Float.valueOf(0.5f), Float.valueOf(0.75f), valueOf});
        HEAT_MAP_CONFIG_GRADIENT_START_POINTS_CUSTOM_DEFAULT = listOf2;
    }

    public final NearbyProHeatMapConfig getNearbyProHeatMapConfig() {
        String str;
        int i3;
        float f16;
        float f17;
        float f18;
        int[] iArr;
        List<Float> list;
        b bVar;
        String str2;
        String str3;
        b bVar2;
        String str4 = "NBPHeatMapConfig";
        NearbyProHeatMapConfig nearbyProHeatMapConfig = new NearbyProHeatMapConfig(2, 35, 0.8f, 3.0f, 75.0f, false, HEAT_MAP_CONFIG_GRADIENT_COLORS_DEFAULT, HEAT_MAP_CONFIG_GRADIENT_START_POINTS_DEFAULT, HEAT_MAP_CONFIG_GRADIENT_COLORS_CUSTOM_DEFAULT, HEAT_MAP_CONFIG_GRADIENT_START_POINTS_CUSTOM_DEFAULT, 20000, 3.0f, 0.5f, 2.0f, 0.5f);
        try {
            String stringFromQQCommonConfig = QQNearbyModule.Companion.getInstance().getStringFromQQCommonConfig("101683", "");
            if (stringFromQQCommonConfig.length() == 0) {
                KLog.INSTANCE.e("NBPHeatMapConfig", "getNearbyProHeatMapConfig is empty, use default value");
                return nearbyProHeatMapConfig;
            }
            KLog.INSTANCE.e("NBPHeatMapConfig", "getNearbyProHeatMapConfig success, configString=" + stringFromQQCommonConfig);
            e eVar = new e(stringFromQQCommonConfig);
            int k3 = eVar.k("mode", 1);
            int[] values = BoxType$EnumUnboxingSharedUtility.values(2);
            int length = values.length;
            int i16 = 0;
            while (true) {
                if (i16 >= length) {
                    i3 = 2;
                    break;
                }
                int i17 = values[i16];
                if (BoxType$EnumUnboxingSharedUtility.ordinal(i17) == k3) {
                    i3 = i17;
                    break;
                }
                i16++;
            }
            int k16 = eVar.k("radius", 35);
            float i18 = (float) eVar.i("opacity", 0.800000011920929d);
            float i19 = (float) eVar.i("intensity_range_min", 3.0d);
            float i26 = (float) eVar.i("intensity_range_max", 75.0d);
            boolean g16 = eVar.g("dynamic_intensity_range_max", false);
            int[] iArr2 = HEAT_MAP_CONFIG_GRADIENT_COLORS_DEFAULT;
            List<Float> list2 = HEAT_MAP_CONFIG_GRADIENT_START_POINTS_DEFAULT;
            b l3 = eVar.l("gradient_config");
            String str5 = "g";
            String str6 = "r";
            if (l3 == null || l3.c() <= 0) {
                f16 = i18;
                str = "NBPHeatMapConfig";
                f17 = i19;
                f18 = i26;
                iArr = iArr2;
                list = list2;
            } else {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                int c16 = l3.c();
                if (c16 >= 0) {
                    int i27 = 0;
                    while (true) {
                        e l16 = l3.l(i27);
                        if (l16 != null) {
                            bVar2 = l3;
                            NBPHeatMapConfig nBPHeatMapConfig = INSTANCE;
                            h.Companion companion = h.INSTANCE;
                            str = str4;
                            try {
                                f18 = i26;
                                f17 = i19;
                                f16 = i18;
                                arrayList.add(Integer.valueOf(nBPHeatMapConfig.heatMapArgb(l16.j("a"), l16.j("r"), l16.j("g"), l16.j("b"))));
                                arrayList2.add(Float.valueOf((float) l16.h("sp")));
                            } catch (Throwable th5) {
                                th = th5;
                                AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("getRequestInfoOptimizeConfig error: ", th, KLog.INSTANCE, str);
                                return nearbyProHeatMapConfig;
                            }
                        } else {
                            f16 = i18;
                            str = str4;
                            f17 = i19;
                            f18 = i26;
                            bVar2 = l3;
                        }
                        if (i27 == c16) {
                            break;
                        }
                        i27++;
                        l3 = bVar2;
                        i26 = f18;
                        i19 = f17;
                        i18 = f16;
                        str4 = str;
                    }
                } else {
                    f16 = i18;
                    str = "NBPHeatMapConfig";
                    f17 = i19;
                    f18 = i26;
                }
                iArr = CollectionsKt___CollectionsKt.toIntArray(arrayList);
                list = arrayList2;
            }
            int[] iArr3 = HEAT_MAP_CONFIG_GRADIENT_COLORS_CUSTOM_DEFAULT;
            List<Float> list3 = HEAT_MAP_CONFIG_GRADIENT_START_POINTS_CUSTOM_DEFAULT;
            b l17 = eVar.l("gradient_config_custom");
            List<Float> list4 = list3;
            if (l17 != null) {
                list4 = list3;
                if (l17.c() > 0) {
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    int c17 = l17.c();
                    if (c17 >= 0) {
                        int i28 = 0;
                        while (true) {
                            e l18 = l17.l(i28);
                            if (l18 != null) {
                                NBPHeatMapConfig nBPHeatMapConfig2 = INSTANCE;
                                h.Companion companion2 = h.INSTANCE;
                                bVar = l17;
                                str3 = str6;
                                str2 = str5;
                                arrayList3.add(Integer.valueOf(nBPHeatMapConfig2.heatMapArgb(l18.j("a"), l18.j(str6), l18.j(str5), l18.j("b"))));
                                arrayList4.add(Float.valueOf((float) l18.h("sp")));
                            } else {
                                bVar = l17;
                                str2 = str5;
                                str3 = str6;
                            }
                            if (i28 == c17) {
                                break;
                            }
                            i28++;
                            l17 = bVar;
                            str6 = str3;
                            str5 = str2;
                        }
                    }
                    iArr3 = CollectionsKt___CollectionsKt.toIntArray(arrayList3);
                    list4 = arrayList4;
                }
            }
            return new NearbyProHeatMapConfig(i3, k16, f16, f17, f18, g16, iArr, list, iArr3, list4, eVar.k("optimize_preload_distance", 20000), (float) eVar.i("optimize_enlarge_ratio", 3.0d), (float) eVar.i("optimize_transition_ratio", 0.5d), (float) eVar.i("optimize_zoom_in_ratio", 2.0d), (float) eVar.i("optimize_zoom_out_ratio", 0.5d));
        } catch (Throwable th6) {
            th = th6;
            str = "NBPHeatMapConfig";
        }
    }

    public final int heatMapArgb(int i3, int i16, int i17, int i18) {
        return (i3 << 24) | (i16 << 16) | (i17 << 8) | i18;
    }
}
