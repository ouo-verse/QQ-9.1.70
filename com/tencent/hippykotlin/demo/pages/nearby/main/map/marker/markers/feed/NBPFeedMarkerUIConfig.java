package com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed;

import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.kuikly.core.base.d;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;

/* loaded from: classes31.dex */
public final class NBPFeedMarkerUIConfig {
    public static final Companion Companion = new Companion();
    public static final Lazy<NBPFeedMarkerUIConfig> instance$delegate;
    public boolean showFeedMarkTitle;
    public float bubbleWidth = 58.0f;
    public float bubbleHeight = 69.0f;
    public float bubblePaddingTop = 4.0f;
    public String bubbleBgUrl = "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_jUVW0rZermB.png";
    public float bubbleBgWidth = 78.0f;
    public float bubbleBgHeight = 89.0f;
    public float bubbleBgX = -10.3f;
    public float bubbleBgY = -2.0f;
    public float imageWidth = 50.0f;
    public float imageHeight = 50.0f;
    public float imageRadius = 2.0f;
    public float redDotRadius = 18.0f;
    public float redDotFontSize = 10.0f;
    public float redDotLineHeight = 14.0f;
    public float redDotHeight = 18.0f;
    public float redDotPaddingH = 5.0f;
    public float redDotPosRight = -8.0f;
    public float redDotPosTop = -9.0f;
    public String cityWalkIcon = "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_u3qdpfVyDr5.png";
    public String sliderMoreIcon = "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_2gk8B10SKIK.png";
    public String textFeedBg = "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_drE-vtoQhMd.png";
    public float targetXPercent = 0.5f;
    public float targetYPercent = 1.0f;
    public float focusedScale = 1.5f;
    public float titleFontSize = 10.0f;
    public float titleLineHeight = 12.0f;
    public float titleMarginTop = 10.0f;
    public float titleMarginBottom = 4.0f;
    public float titleMarginLeft = 3.0f;
    public float collectionAreaPercent = 1.0E-4f;

    /* loaded from: classes31.dex */
    public static final class Companion {
        public final NBPFeedMarkerUIConfig getInstance() {
            return NBPFeedMarkerUIConfig.instance$delegate.getValue();
        }
    }

    static {
        Lazy<NBPFeedMarkerUIConfig> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<NBPFeedMarkerUIConfig>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerUIConfig$Companion$instance$2
            public static final String invoke$getNBPConfigString(e eVar, String str, String str2) {
                String p16 = eVar.p(str);
                return p16.length() > 0 ? p16 : str2;
            }

            @Override // kotlin.jvm.functions.Function0
            public final NBPFeedMarkerUIConfig invoke() {
                NBPFeedMarkerUIConfig nBPFeedMarkerUIConfig = new NBPFeedMarkerUIConfig();
                String stringFromQQCommonConfig = ((QQNearbyModule) c.f117352a.g().acquireModule("QQNearbyModule")).getStringFromQQCommonConfig("103216", "");
                if (stringFromQQCommonConfig.length() > 0) {
                    try {
                        e eVar = new e(stringFromQQCommonConfig);
                        float f16 = nBPFeedMarkerUIConfig.bubbleWidth;
                        double h16 = eVar.h("bubbleWidth");
                        if (h16 > 0.0d) {
                            f16 = (float) h16;
                        }
                        nBPFeedMarkerUIConfig.bubbleWidth = f16;
                        float f17 = nBPFeedMarkerUIConfig.bubbleHeight;
                        double h17 = eVar.h("bubbleHeight");
                        if (h17 > 0.0d) {
                            f17 = (float) h17;
                        }
                        nBPFeedMarkerUIConfig.bubbleHeight = f17;
                        float f18 = nBPFeedMarkerUIConfig.bubblePaddingTop;
                        double h18 = eVar.h("bubblePaddingTop");
                        if (h18 > 0.0d) {
                            f18 = (float) h18;
                        }
                        nBPFeedMarkerUIConfig.bubblePaddingTop = f18;
                        nBPFeedMarkerUIConfig.bubbleBgUrl = invoke$getNBPConfigString(eVar, "bubbleBgUrl", nBPFeedMarkerUIConfig.bubbleBgUrl);
                        float f19 = nBPFeedMarkerUIConfig.bubbleBgWidth;
                        double h19 = eVar.h("bubbleBgWidth");
                        if (h19 > 0.0d) {
                            f19 = (float) h19;
                        }
                        nBPFeedMarkerUIConfig.bubbleBgWidth = f19;
                        float f26 = nBPFeedMarkerUIConfig.bubbleBgHeight;
                        double h26 = eVar.h("bubbleBgHeight");
                        if (h26 > 0.0d) {
                            f26 = (float) h26;
                        }
                        nBPFeedMarkerUIConfig.bubbleBgHeight = f26;
                        float f27 = nBPFeedMarkerUIConfig.bubbleBgX;
                        double h27 = eVar.h("bubbleBgX");
                        if (h27 > 0.0d) {
                            f27 = (float) h27;
                        }
                        nBPFeedMarkerUIConfig.bubbleBgX = f27;
                        float f28 = nBPFeedMarkerUIConfig.bubbleBgY;
                        double h28 = eVar.h("bubbleBgY");
                        if (h28 > 0.0d) {
                            f28 = (float) h28;
                        }
                        nBPFeedMarkerUIConfig.bubbleBgY = f28;
                        float f29 = nBPFeedMarkerUIConfig.imageWidth;
                        double h29 = eVar.h("imageWidth");
                        if (h29 > 0.0d) {
                            f29 = (float) h29;
                        }
                        nBPFeedMarkerUIConfig.imageWidth = f29;
                        float f36 = nBPFeedMarkerUIConfig.imageHeight;
                        double h36 = eVar.h("imageHeight");
                        if (h36 > 0.0d) {
                            f36 = (float) h36;
                        }
                        nBPFeedMarkerUIConfig.imageHeight = f36;
                        float f37 = nBPFeedMarkerUIConfig.imageRadius;
                        double h37 = eVar.h("imageRadius");
                        if (h37 > 0.0d) {
                            f37 = (float) h37;
                        }
                        nBPFeedMarkerUIConfig.imageRadius = f37;
                        float f38 = nBPFeedMarkerUIConfig.redDotRadius;
                        double h38 = eVar.h("redDotRadius");
                        if (h38 > 0.0d) {
                            f38 = (float) h38;
                        }
                        nBPFeedMarkerUIConfig.redDotRadius = f38;
                        float f39 = nBPFeedMarkerUIConfig.redDotFontSize;
                        double h39 = eVar.h("redDotFontSize");
                        if (h39 > 0.0d) {
                            f39 = (float) h39;
                        }
                        nBPFeedMarkerUIConfig.redDotFontSize = f39;
                        float f46 = nBPFeedMarkerUIConfig.redDotLineHeight;
                        double h46 = eVar.h("redDotLineHeight");
                        if (h46 > 0.0d) {
                            f46 = (float) h46;
                        }
                        nBPFeedMarkerUIConfig.redDotLineHeight = f46;
                        float f47 = nBPFeedMarkerUIConfig.redDotHeight;
                        double h47 = eVar.h("redDotHeight");
                        if (h47 > 0.0d) {
                            f47 = (float) h47;
                        }
                        nBPFeedMarkerUIConfig.redDotHeight = f47;
                        float f48 = nBPFeedMarkerUIConfig.redDotPaddingH;
                        double h48 = eVar.h("redDotPaddingH");
                        if (h48 > 0.0d) {
                            f48 = (float) h48;
                        }
                        nBPFeedMarkerUIConfig.redDotPaddingH = f48;
                        float f49 = nBPFeedMarkerUIConfig.redDotPosRight;
                        double h49 = eVar.h("redDotPosRight");
                        if (h49 > 0.0d) {
                            f49 = (float) h49;
                        }
                        nBPFeedMarkerUIConfig.redDotPosRight = f49;
                        float f56 = nBPFeedMarkerUIConfig.redDotPosTop;
                        double h56 = eVar.h("redDotPosTop");
                        if (h56 > 0.0d) {
                            f56 = (float) h56;
                        }
                        nBPFeedMarkerUIConfig.redDotPosTop = f56;
                        nBPFeedMarkerUIConfig.cityWalkIcon = invoke$getNBPConfigString(eVar, "cityWalkIcon", nBPFeedMarkerUIConfig.cityWalkIcon);
                        nBPFeedMarkerUIConfig.sliderMoreIcon = invoke$getNBPConfigString(eVar, "sliderMoreIcon", nBPFeedMarkerUIConfig.sliderMoreIcon);
                        nBPFeedMarkerUIConfig.textFeedBg = invoke$getNBPConfigString(eVar, "textFeedBg", nBPFeedMarkerUIConfig.textFeedBg);
                        float f57 = nBPFeedMarkerUIConfig.targetXPercent;
                        double h57 = eVar.h("targetXPercent");
                        if (h57 > 0.0d) {
                            f57 = (float) h57;
                        }
                        nBPFeedMarkerUIConfig.targetXPercent = f57;
                        float f58 = nBPFeedMarkerUIConfig.targetYPercent;
                        double h58 = eVar.h("targetYPercent");
                        if (h58 > 0.0d) {
                            f58 = (float) h58;
                        }
                        nBPFeedMarkerUIConfig.targetYPercent = f58;
                        float f59 = nBPFeedMarkerUIConfig.focusedScale;
                        double h59 = eVar.h("focusedScale");
                        if (h59 > 0.0d) {
                            f59 = (float) h59;
                        }
                        nBPFeedMarkerUIConfig.focusedScale = f59;
                        float b16 = d.b(nBPFeedMarkerUIConfig.showFeedMarkTitle);
                        double h65 = eVar.h("showFeedMarkTitle");
                        if (h65 > 0.0d) {
                            b16 = (float) h65;
                        }
                        nBPFeedMarkerUIConfig.showFeedMarkTitle = d.a((int) b16);
                        float f65 = nBPFeedMarkerUIConfig.collectionAreaPercent;
                        double h66 = eVar.h("collectionAreaPercent");
                        if (h66 > 0.0d) {
                            f65 = (float) h66;
                        }
                        nBPFeedMarkerUIConfig.collectionAreaPercent = f65;
                        float f66 = nBPFeedMarkerUIConfig.titleFontSize;
                        double h67 = eVar.h("titleFontSize");
                        if (h67 > 0.0d) {
                            f66 = (float) h67;
                        }
                        nBPFeedMarkerUIConfig.titleFontSize = f66;
                        float f67 = nBPFeedMarkerUIConfig.titleLineHeight;
                        double h68 = eVar.h("titleLineHeight");
                        if (h68 > 0.0d) {
                            f67 = (float) h68;
                        }
                        nBPFeedMarkerUIConfig.titleLineHeight = f67;
                        float f68 = nBPFeedMarkerUIConfig.titleMarginTop;
                        double h69 = eVar.h("titleMarginTop");
                        if (h69 > 0.0d) {
                            f68 = (float) h69;
                        }
                        nBPFeedMarkerUIConfig.titleMarginTop = f68;
                        float f69 = nBPFeedMarkerUIConfig.titleMarginBottom;
                        double h75 = eVar.h("titleMarginBottom");
                        if (h75 > 0.0d) {
                            f69 = (float) h75;
                        }
                        nBPFeedMarkerUIConfig.titleMarginBottom = f69;
                        float f75 = nBPFeedMarkerUIConfig.titleMarginLeft;
                        double h76 = eVar.h("titleMarginLeft");
                        if (h76 > 0.0d) {
                            f75 = (float) h76;
                        }
                        nBPFeedMarkerUIConfig.titleMarginLeft = f75;
                    } catch (Throwable unused) {
                        new e();
                    }
                }
                return nBPFeedMarkerUIConfig;
            }
        });
        instance$delegate = lazy;
    }

    public final float getFocusedScale() {
        return this.focusedScale;
    }

    public final float getTargetXPercent() {
        return this.targetXPercent;
    }

    public final float getTargetYPercent() {
        return this.targetYPercent;
    }
}
