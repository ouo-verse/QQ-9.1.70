package com.tencent.hippykotlin.demo.pages.nearby.main.theme;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* loaded from: classes31.dex */
public final class NBPThemeAttachConfig {
    public static final Companion Companion = new Companion();
    public final String hotText;
    public final List<h> markerGradientColors;
    public final String newText;
    public final List<NBPThemePosterConfig> posters;
    public final List<NBPThemePosterConfig> posters910;
    public final NBPThemeGuideConfig publishGuide;
    public final NBPThemeGuideConfig recommendGuide;
    public final String themeText;

    public NBPThemeAttachConfig() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public final int hashCode() {
        int hashCode = (this.posters910.hashCode() + ((this.posters.hashCode() + (this.markerGradientColors.hashCode() * 31)) * 31)) * 31;
        NBPThemeGuideConfig nBPThemeGuideConfig = this.recommendGuide;
        int hashCode2 = (hashCode + (nBPThemeGuideConfig == null ? 0 : nBPThemeGuideConfig.hashCode())) * 31;
        NBPThemeGuideConfig nBPThemeGuideConfig2 = this.publishGuide;
        return this.themeText.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.newText, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.hotText, (hashCode2 + (nBPThemeGuideConfig2 != null ? nBPThemeGuideConfig2.hashCode() : 0)) * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("NBPThemeAttachConfig(markerGradientColors=");
        m3.append(this.markerGradientColors);
        m3.append(", posters=");
        m3.append(this.posters);
        m3.append(", posters910=");
        m3.append(this.posters910);
        m3.append(", recommendGuide=");
        m3.append(this.recommendGuide);
        m3.append(", publishGuide=");
        m3.append(this.publishGuide);
        m3.append(", hotText=");
        m3.append(this.hotText);
        m3.append(", newText=");
        m3.append(this.newText);
        m3.append(", themeText=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.themeText, ')');
    }

    /* loaded from: classes31.dex */
    public static final class Companion {
        /* JADX WARN: Code restructure failed: missing block: B:62:0x011d, code lost:
        
            r1 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r6);
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x012a, code lost:
        
            r1 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r7);
         */
        /* JADX WARN: Removed duplicated region for block: B:75:0x0170 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final NBPThemeAttachConfig parseJsonStr(String str) {
            e eVar;
            ArrayList arrayList;
            ArrayList arrayList2;
            List emptyList;
            List emptyList2;
            NBPThemeGuideConfig nBPThemeGuideConfig;
            String str2;
            e m3;
            NBPThemeGuideConfig nBPThemeGuideConfig2;
            NBPThemePosterConfig parseJson;
            NBPThemePosterConfig parseJson2;
            boolean startsWith$default;
            if (str == null || str.length() == 0) {
                return new NBPThemeAttachConfig(null, null, null, null, null, null, null, null, 255, null);
            }
            try {
                eVar = new e(str);
            } catch (Exception unused) {
                eVar = new e();
            }
            ArrayList arrayList3 = new ArrayList();
            try {
                b l3 = eVar.l("border_color_arr");
                if (l3 != null) {
                    int c16 = l3.c();
                    for (int i3 = 0; i3 < c16; i3++) {
                        String o16 = l3.o(i3);
                        if (o16 == null) {
                            o16 = "";
                        }
                        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(o16, RelationNTPushServiceImpl.PRE_HEX_STRING, false, 2, null);
                        if (startsWith$default && o16.length() == 8) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("0xff");
                            String substring = o16.substring(2);
                            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                            sb5.append(substring);
                            o16 = sb5.toString();
                        }
                        arrayList3.add(new h(h.INSTANCE.o(o16)));
                    }
                }
            } catch (Throwable th5) {
                KLog.INSTANCE.i("NBPMainMapThemeViewModel", "createNBPMainMapTheme: " + th5);
                arrayList3.clear();
            }
            b l16 = eVar.l("posters");
            if (l16 != null) {
                arrayList = new ArrayList();
                int c17 = l16.c();
                for (int i16 = 0; i16 < c17; i16++) {
                    e l17 = l16.l(i16);
                    if (l17 != null && (parseJson2 = NBPThemePosterConfig.Companion.parseJson(l17)) != null) {
                        arrayList.add(parseJson2);
                    }
                }
            } else {
                arrayList = null;
            }
            b l18 = eVar.l("posters910");
            if (l18 != null) {
                arrayList2 = new ArrayList();
                int c18 = l18.c();
                for (int i17 = 0; i17 < c18; i17++) {
                    e l19 = l18.l(i17);
                    if (l19 != null && (parseJson = NBPThemePosterConfig.Companion.parseJson(l19)) != null) {
                        arrayList2.add(parseJson);
                    }
                }
            } else {
                arrayList2 = null;
            }
            String q16 = eVar.q("hot_tag", "\u70ed\u95e8\u52a8\u6001");
            String q17 = eVar.q("new_tag", "\u6700\u65b0\u52a8\u6001");
            String q18 = eVar.q("theme_tag", "");
            try {
                if (arrayList == null || emptyList == null) {
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                }
                List list = emptyList;
                if (arrayList2 == null || emptyList2 == null) {
                    emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                }
                List list2 = emptyList2;
                e m16 = eVar.m("recommend_guide");
                if (m16 != null) {
                    try {
                        str2 = q18;
                        try {
                            nBPThemeGuideConfig = new NBPThemeGuideConfig(m16.p("key"), m16.p("icon"), m16.p("text"), m16.p("theme_id"));
                        } catch (Exception unused2) {
                        }
                    } catch (Exception unused3) {
                    }
                    m3 = eVar.m("publish_guide");
                    if (m3 != null) {
                        try {
                            nBPThemeGuideConfig2 = new NBPThemeGuideConfig(m3.p("key"), m3.p("icon"), m3.p("text"), m3.p("theme_id"));
                        } catch (Exception unused4) {
                            nBPThemeGuideConfig2 = null;
                        }
                        return new NBPThemeAttachConfig(arrayList3, list, list2, nBPThemeGuideConfig, nBPThemeGuideConfig2, q16, q17, str2);
                    }
                    nBPThemeGuideConfig2 = null;
                    return new NBPThemeAttachConfig(arrayList3, list, list2, nBPThemeGuideConfig, nBPThemeGuideConfig2, q16, q17, str2);
                }
                str2 = q18;
                nBPThemeGuideConfig = null;
                m3 = eVar.m("publish_guide");
                if (m3 != null) {
                }
                nBPThemeGuideConfig2 = null;
                return new NBPThemeAttachConfig(arrayList3, list, list2, nBPThemeGuideConfig, nBPThemeGuideConfig2, q16, q17, str2);
            } catch (Exception unused5) {
                return new NBPThemeAttachConfig(null, null, null, null, null, null, null, null, 255, null);
            }
        }
    }

    public NBPThemeAttachConfig(List<h> list, List<NBPThemePosterConfig> list2, List<NBPThemePosterConfig> list3, NBPThemeGuideConfig nBPThemeGuideConfig, NBPThemeGuideConfig nBPThemeGuideConfig2, String str, String str2, String str3) {
        this.markerGradientColors = list;
        this.posters = list2;
        this.posters910 = list3;
        this.recommendGuide = nBPThemeGuideConfig;
        this.publishGuide = nBPThemeGuideConfig2;
        this.hotText = str;
        this.newText = str2;
        this.themeText = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NBPThemeAttachConfig)) {
            return false;
        }
        NBPThemeAttachConfig nBPThemeAttachConfig = (NBPThemeAttachConfig) obj;
        return Intrinsics.areEqual(this.markerGradientColors, nBPThemeAttachConfig.markerGradientColors) && Intrinsics.areEqual(this.posters, nBPThemeAttachConfig.posters) && Intrinsics.areEqual(this.posters910, nBPThemeAttachConfig.posters910) && Intrinsics.areEqual(this.recommendGuide, nBPThemeAttachConfig.recommendGuide) && Intrinsics.areEqual(this.publishGuide, nBPThemeAttachConfig.publishGuide) && Intrinsics.areEqual(this.hotText, nBPThemeAttachConfig.hotText) && Intrinsics.areEqual(this.newText, nBPThemeAttachConfig.newText) && Intrinsics.areEqual(this.themeText, nBPThemeAttachConfig.themeText);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ NBPThemeAttachConfig(List list, List list2, List list3, NBPThemeGuideConfig nBPThemeGuideConfig, NBPThemeGuideConfig nBPThemeGuideConfig2, String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(r2, r3, r4, null, null, "", "", "");
        List emptyList;
        List emptyList2;
        List emptyList3;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        emptyList3 = CollectionsKt__CollectionsKt.emptyList();
    }
}
