package com.tencent.hippykotlin.demo.pages.nearby.mood_group.data;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.PopoverTriangle$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.compose_base.geometry.Point;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.w;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.tuxmeterqui.config.TuxUIConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;

/* loaded from: classes31.dex */
public final class NBPMoodGroupConfig {
    public static final Companion Companion = new Companion();
    public final BackgroundConfig backgroundConfig;
    public final BarrageConfig barrageConfig;
    public final IndicatorConfig indicatorConfig;
    public final JoinPropConfig joinPropConfig;
    public final MatchConfig matchMsgConfig;
    public final ShootConfig shootConfig;
    public final UserActionMenuConfig userActionMenuConfig;
    public final UserMarkerConfig userMarkerConfig;

    /* loaded from: classes31.dex */
    public static final class BubbleConfig {
        public static final Companion Companion = new Companion();
        public final h backgroundColor;
        public final h borderColor;
        public final float borderRadius;
        public final float borderWidth;
        public final int displayTime;
        public final h fontColor;
        public final float fontSize;
        public final boolean hasArrow;
        public final float lineHeight;
        public final float maxWidth;
        public final float offsetY;

        public BubbleConfig(int i3, float f16, float f17, float f18, h hVar, float f19, h hVar2, float f26, h hVar3, float f27, boolean z16) {
            this.displayTime = i3;
            this.maxWidth = f16;
            this.offsetY = f17;
            this.fontSize = f18;
            this.fontColor = hVar;
            this.lineHeight = f19;
            this.backgroundColor = hVar2;
            this.borderRadius = f26;
            this.borderColor = hVar3;
            this.borderWidth = f27;
            this.hasArrow = z16;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            int m3 = PopoverTriangle$$ExternalSyntheticOutline0.m(this.borderWidth, (this.borderColor.hashCode() + PopoverTriangle$$ExternalSyntheticOutline0.m(this.borderRadius, (this.backgroundColor.hashCode() + PopoverTriangle$$ExternalSyntheticOutline0.m(this.lineHeight, (this.fontColor.hashCode() + PopoverTriangle$$ExternalSyntheticOutline0.m(this.fontSize, PopoverTriangle$$ExternalSyntheticOutline0.m(this.offsetY, PopoverTriangle$$ExternalSyntheticOutline0.m(this.maxWidth, this.displayTime * 31, 31), 31), 31)) * 31, 31)) * 31, 31)) * 31, 31);
            boolean z16 = this.hasArrow;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return m3 + i3;
        }

        public final String toString() {
            return "BubbleConfig(displayTime=" + this.displayTime + ", maxWidth=" + this.maxWidth + ", offsetY=" + this.offsetY + ", fontSize=" + this.fontSize + ", fontColor=" + this.fontColor + ", lineHeight=" + this.lineHeight + ", backgroundColor=" + this.backgroundColor + ", borderRadius=" + this.borderRadius + ", borderColor=" + this.borderColor + ", borderWidth=" + this.borderWidth + ", hasArrow=" + this.hasArrow + ')';
        }

        /* loaded from: classes31.dex */
        public static final class Companion {
            public final BubbleConfig parseFromJson(e eVar) {
                if (eVar == null) {
                    KLog.INSTANCE.e("NBPMoodGroupConfig", "parseBubbleConfigFromJson jsonObj is null");
                    return null;
                }
                return new BubbleConfig(eVar.k("displayTime", 3000), (float) eVar.i(NodeProps.MAX_WIDTH, 300.0d), (float) eVar.i("offsetY", 12.0d), (float) eVar.i("fontSize", 14.0d), UtilsKt.toColor(eVar.p("fontColor")), (float) eVar.i(NodeProps.LINE_HEIGHT, 20.0d), UtilsKt.toColor(eVar.p("backgroundColor")), (float) eVar.i(NodeProps.BORDER_RADIUS, 6.0d), UtilsKt.toColor(eVar.p(NodeProps.BORDER_COLOR)), (float) eVar.i(NodeProps.BORDER_WIDTH, 0.0d), eVar.g("hasArrow", true));
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BubbleConfig)) {
                return false;
            }
            BubbleConfig bubbleConfig = (BubbleConfig) obj;
            return this.displayTime == bubbleConfig.displayTime && Float.compare(this.maxWidth, bubbleConfig.maxWidth) == 0 && Float.compare(this.offsetY, bubbleConfig.offsetY) == 0 && Float.compare(this.fontSize, bubbleConfig.fontSize) == 0 && Intrinsics.areEqual(this.fontColor, bubbleConfig.fontColor) && Float.compare(this.lineHeight, bubbleConfig.lineHeight) == 0 && Intrinsics.areEqual(this.backgroundColor, bubbleConfig.backgroundColor) && Float.compare(this.borderRadius, bubbleConfig.borderRadius) == 0 && Intrinsics.areEqual(this.borderColor, bubbleConfig.borderColor) && Float.compare(this.borderWidth, bubbleConfig.borderWidth) == 0 && this.hasArrow == bubbleConfig.hasArrow;
        }
    }

    /* loaded from: classes31.dex */
    public static final class Companion {
        /* JADX WARN: Code restructure failed: missing block: B:101:0x0a54, code lost:
        
            if (r2 == null) goto L313;
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x09d9, code lost:
        
            if (r2 == null) goto L286;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:107:0x0bdd A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:108:0x0bdf  */
        /* JADX WARN: Type inference failed for: r0v21, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r3v23, types: [java.util.List] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final NBPMoodGroupConfig parseFromJsonStr(String str) {
            ImageConfig imageConfig;
            IndicatorConfig indicatorConfig;
            ImageConfig imageConfig2;
            String str2;
            Direction direction;
            e eVar;
            IndicatorConfig indicatorConfig2;
            GradientColor gradientColor;
            e eVar2;
            b bVar;
            IndicatorConfig indicatorConfig3;
            int i3;
            String str3;
            ImageConfig imageConfig3;
            ArrayList arrayList;
            BackgroundConfig backgroundConfig;
            ?? emptyList;
            String str4;
            e eVar3;
            String str5;
            String str6;
            String str7;
            String str8;
            BackgroundConfig backgroundConfig2;
            List list;
            b bVar2;
            BackgroundConfig backgroundConfig3;
            String str9;
            String str10;
            ImageConfig imageConfig4;
            String str11;
            String str12;
            e eVar4;
            String str13;
            UserActionMenuConfig userActionMenuConfig;
            e eVar5;
            String str14;
            String str15;
            String str16;
            String str17;
            String str18;
            String str19;
            String str20;
            ArrayList arrayList2;
            String str21;
            UserActionMenuConfig userActionMenuConfig2;
            b bVar3;
            String str22;
            String str23;
            UserActionMenuConfig userActionMenuConfig3;
            e eVar6;
            int i16;
            ArrayList arrayList3;
            String str24;
            String str25;
            ImageConfig imageConfig5;
            ImageConfig imageConfig6;
            String str26;
            String str27;
            String str28;
            String str29;
            String str30;
            String str31;
            String str32;
            String str33;
            String str34;
            String str35;
            String str36;
            String str37;
            BubbleConfig bubbleConfig;
            BarrageReplyInteractionConfig barrageReplyInteractionConfig;
            String str38;
            String str39;
            BarrageLocalReplyEffect barrageLocalReplyEffect;
            ArrayList arrayList4;
            String str40;
            BarrageConfig barrageConfig;
            ?? emptyList2;
            String str41;
            ImageConfig imageConfig7;
            String str42;
            BarrageConfig barrageConfig2;
            String str43;
            String str44;
            String str45;
            JoinPropConfig joinPropConfig;
            ShootConfig shootConfig;
            Object d16;
            Object d17;
            JoinPropConfig joinPropConfig2;
            String str46;
            String str47;
            String str48;
            String str49;
            int i17;
            ShootConfig shootConfig2;
            BackgroundImage backgroundImage;
            BackgroundImage backgroundImage2;
            Guide guide;
            MatchConfig matchConfig;
            List emptyList3;
            List emptyList4;
            ImageConfig imageConfig8;
            BubbleConfig parseFromJson;
            BubbleConfig parseFromJson2;
            BubbleConfig parseFromJson3;
            UserMarkerConfig userMarkerConfig;
            Object d18;
            Object d19;
            if (str.length() == 0) {
                KLog.INSTANCE.e("NBPMoodGroupConfig", "parse NBPMoodGroupConfig jsonStr is empty");
                return null;
            }
            try {
                e eVar7 = new e(str);
                e m3 = eVar7.m("indicatorConfig");
                String str50 = "parseImageConfig jsonObj is null";
                String str51 = "src";
                String str52 = "height";
                String str53 = "width";
                if (m3 == null) {
                    KLog.INSTANCE.e("NBPMoodGroupConfig", "parseIndicatorConfigFromJson jsonObj is null");
                    indicatorConfig = null;
                } else {
                    e m16 = m3.m("moodIcon");
                    if (m16 == null) {
                        KLog.INSTANCE.e("NBPMoodGroupConfig", "parseImageConfig jsonObj is null");
                        imageConfig = null;
                    } else {
                        imageConfig = new ImageConfig(m16.p("src"), (float) m16.h("width"), (float) m16.h("height"));
                    }
                    if (imageConfig == null) {
                        imageConfig = new ImageConfig(null, 0.0f, 0.0f, 7, null);
                    }
                    indicatorConfig = new IndicatorConfig(imageConfig, m3.p("moodTitle"), m3.p("mapThemeId"), m3.p("joinButtonText"), UtilsKt.toColor(m3.p("joinButtonTextColor")), UtilsKt.toColor(m3.p("joinButtonBgColor")));
                }
                if (indicatorConfig == null) {
                    return null;
                }
                e m17 = eVar7.m("backgroundConfig");
                String str54 = "backgroundColor";
                if (m17 == null) {
                    KLog.INSTANCE.e("NBPMoodGroupConfig", "parseBackgroundConfigFromJson jsonObj is null");
                    eVar = eVar7;
                    str3 = "NBPMoodGroupConfig";
                    backgroundConfig = null;
                    indicatorConfig2 = indicatorConfig;
                } else {
                    e m18 = m17.m("background");
                    if (m18 == null) {
                        KLog.INSTANCE.e("NBPMoodGroupConfig", "parseImageConfig jsonObj is null");
                        str2 = "NBPMoodGroupConfig";
                        imageConfig2 = null;
                    } else {
                        str2 = "NBPMoodGroupConfig";
                        imageConfig2 = new ImageConfig(m18.p("src"), (float) m18.h("width"), (float) m18.h("height"));
                    }
                    if (imageConfig2 == null) {
                        imageConfig2 = new ImageConfig(null, 0.0f, 0.0f, 7, null);
                    }
                    ImageConfig imageConfig9 = imageConfig2;
                    e m19 = m17.m("backgroundColor");
                    if (m19 == null) {
                        eVar = eVar7;
                        gradientColor = null;
                        indicatorConfig2 = indicatorConfig;
                    } else {
                        switch (m19.j("direction")) {
                            case 0:
                                direction = Direction.TO_TOP;
                                break;
                            case 1:
                                direction = Direction.TO_BOTTOM;
                                break;
                            case 2:
                                direction = Direction.TO_LEFT;
                                break;
                            case 3:
                                direction = Direction.TO_RIGHT;
                                break;
                            case 4:
                                direction = Direction.TO_TOP_LEFT;
                                break;
                            case 5:
                                direction = Direction.TO_TOP_RIGHT;
                                break;
                            case 6:
                                direction = Direction.TO_BOTTOM_LEFT;
                                break;
                            case 7:
                                direction = Direction.TO_BOTTOM_RIGHT;
                                break;
                            default:
                                direction = Direction.TO_BOTTOM;
                                break;
                        }
                        ArrayList arrayList5 = new ArrayList();
                        b l3 = m19.l("colorStops");
                        if (l3 != null) {
                            int c16 = l3.c();
                            int i18 = 0;
                            while (i18 < c16) {
                                e l16 = l3.l(i18);
                                if (l16 != null) {
                                    eVar2 = eVar7;
                                    bVar = l3;
                                    indicatorConfig3 = indicatorConfig;
                                    i3 = c16;
                                    arrayList5.add(new j(UtilsKt.toColor(l16.p("color")), (float) l16.i("stop", 0.0d)));
                                } else {
                                    eVar2 = eVar7;
                                    bVar = l3;
                                    indicatorConfig3 = indicatorConfig;
                                    i3 = c16;
                                }
                                i18++;
                                indicatorConfig = indicatorConfig3;
                                c16 = i3;
                                eVar7 = eVar2;
                                l3 = bVar;
                            }
                        }
                        eVar = eVar7;
                        indicatorConfig2 = indicatorConfig;
                        Object[] array = arrayList5.toArray(new j[0]);
                        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                        gradientColor = new GradientColor(direction, (j[]) array);
                    }
                    e m26 = m17.m("mainBuilding");
                    if (m26 == null) {
                        str3 = str2;
                        KLog.INSTANCE.e(str3, "parseImageConfig jsonObj is null");
                        imageConfig3 = null;
                    } else {
                        str3 = str2;
                        imageConfig3 = new ImageConfig(m26.p("src"), (float) m26.h("width"), (float) m26.h("height"));
                    }
                    ImageConfig imageConfig10 = imageConfig3 == null ? new ImageConfig(null, 0.0f, 0.0f, 7, null) : imageConfig3;
                    b l17 = m17.l("seatArea");
                    if (l17 == null) {
                        KLog.INSTANCE.e(str3, "parsePoints jsonArr is null");
                        emptyList = CollectionsKt__CollectionsKt.emptyList();
                        arrayList = emptyList;
                    } else {
                        ArrayList arrayList6 = new ArrayList();
                        int c17 = l17.c();
                        for (int i19 = 0; i19 < c17; i19++) {
                            Point parsePointFromJson = UtilsKt.parsePointFromJson(l17.l(i19));
                            if (parsePointFromJson != null) {
                                arrayList6.add(parsePointFromJson);
                            }
                        }
                        arrayList = arrayList6;
                    }
                    float i26 = (float) m17.i("seatPaddingLeft", 15.0d);
                    w parseSizeFromJson = UtilsKt.parseSizeFromJson(m17.m("hostAreaSize"));
                    if (parseSizeFromJson == null) {
                        parseSizeFromJson = new w(210.0f, 300.0f);
                    }
                    backgroundConfig = new BackgroundConfig(imageConfig9, gradientColor, imageConfig10, arrayList, i26, parseSizeFromJson, (float) m17.i("hostAreaMarginTop", 380.0d));
                }
                if (backgroundConfig == null) {
                    return null;
                }
                e eVar8 = eVar;
                e m27 = eVar8.m("userActionMenuConfig");
                String str55 = "clickMsg";
                String str56 = "icon";
                String str57 = "interactionId";
                if (m27 == null) {
                    KLog.INSTANCE.e(str3, "parseUserActionMenuConfigFromJson jsonObj is null");
                    str4 = str3;
                    eVar3 = eVar8;
                    str5 = "interactionId";
                    str6 = "parseImageConfig jsonObj is null";
                    str7 = "width";
                    str8 = "backgroundColor";
                    backgroundConfig2 = backgroundConfig;
                    userActionMenuConfig = null;
                } else {
                    b l18 = m27.l("interactions");
                    if (l18 == null) {
                        KLog.INSTANCE.e(str3, "parseInteractionsFromJson jsonArr is null");
                        list = CollectionsKt__CollectionsKt.emptyList();
                        str4 = str3;
                        eVar3 = eVar8;
                        str5 = "interactionId";
                        str6 = "parseImageConfig jsonObj is null";
                        str7 = "width";
                        str8 = "backgroundColor";
                        backgroundConfig2 = backgroundConfig;
                    } else {
                        ArrayList arrayList7 = new ArrayList();
                        int c18 = l18.c();
                        int i27 = 0;
                        while (i27 < c18) {
                            int i28 = c18;
                            e l19 = l18.l(i27);
                            if (l19 == null) {
                                str12 = str3;
                                eVar4 = eVar8;
                                str10 = str57;
                                str11 = str50;
                                str13 = str53;
                                str9 = str54;
                                bVar2 = l18;
                                backgroundConfig3 = backgroundConfig;
                            } else {
                                bVar2 = l18;
                                String p16 = l19.p(str57);
                                backgroundConfig3 = backgroundConfig;
                                String p17 = l19.p("name");
                                str9 = str54;
                                e m28 = l19.m("icon");
                                if (m28 == null) {
                                    KLog.INSTANCE.e(str3, str50);
                                    str12 = str3;
                                    eVar4 = eVar8;
                                    str10 = str57;
                                    str11 = str50;
                                    str13 = str53;
                                    imageConfig4 = null;
                                } else {
                                    str10 = str57;
                                    str11 = str50;
                                    str12 = str3;
                                    eVar4 = eVar8;
                                    str13 = str53;
                                    imageConfig4 = new ImageConfig(m28.p("src"), (float) m28.h(str53), (float) m28.h("height"));
                                }
                                if (imageConfig4 != null) {
                                    arrayList7.add(new UserActionMenuInteraction(p16, p17, imageConfig4, l19.p("clickMsg")));
                                }
                            }
                            i27++;
                            str53 = str13;
                            c18 = i28;
                            l18 = bVar2;
                            backgroundConfig = backgroundConfig3;
                            str54 = str9;
                            str57 = str10;
                            str50 = str11;
                            str3 = str12;
                            eVar8 = eVar4;
                        }
                        str4 = str3;
                        eVar3 = eVar8;
                        str5 = str57;
                        str6 = str50;
                        str7 = str53;
                        str8 = str54;
                        backgroundConfig2 = backgroundConfig;
                        list = arrayList7;
                    }
                    Point parsePointFromJson2 = UtilsKt.parsePointFromJson(m27.m("offset"));
                    if (parsePointFromJson2 == null) {
                        parsePointFromJson2 = new Point(0.0f, 6.0f);
                    }
                    userActionMenuConfig = new UserActionMenuConfig(list, parsePointFromJson2);
                }
                if (userActionMenuConfig == null) {
                    return null;
                }
                e eVar9 = eVar3;
                e m29 = eVar9.m("barrageConfig");
                String str58 = "texts";
                String str59 = "offsetY";
                String str60 = "";
                if (m29 == null) {
                    String str61 = str4;
                    KLog.INSTANCE.e(str61, "parseBarrageConfigFromJson jsonObj is null");
                    eVar5 = eVar9;
                    str14 = str7;
                    str15 = "texts";
                    str16 = "offsetY";
                    str17 = "src";
                    str18 = "height";
                    str40 = "";
                    str20 = str61;
                    str21 = str6;
                    barrageConfig = null;
                    userActionMenuConfig2 = userActionMenuConfig;
                } else {
                    String str62 = str4;
                    b l26 = m29.l("items");
                    if (l26 == null) {
                        KLog.INSTANCE.e(str62, "parseBarrageItemsFromJson jsonArr is null");
                        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                        eVar5 = eVar9;
                        str16 = "offsetY";
                        str17 = "src";
                        str18 = "height";
                        str19 = "";
                        str20 = str62;
                        str21 = str6;
                        userActionMenuConfig2 = userActionMenuConfig;
                        str14 = str7;
                        str15 = "texts";
                        arrayList2 = emptyList2;
                    } else {
                        ArrayList arrayList8 = new ArrayList();
                        int c19 = l26.c();
                        int i29 = 0;
                        while (i29 < c19) {
                            int i36 = c19;
                            e l27 = l26.l(i29);
                            if (l27 == null) {
                                eVar6 = eVar9;
                                str37 = str55;
                                str22 = str56;
                                str35 = str59;
                                str30 = str51;
                                str31 = str52;
                                str32 = str60;
                                str38 = str62;
                                bVar3 = l26;
                                i16 = i29;
                                str33 = str8;
                                str27 = str5;
                                str26 = str6;
                                str29 = str7;
                                str39 = str58;
                                arrayList4 = arrayList8;
                                userActionMenuConfig3 = userActionMenuConfig;
                            } else {
                                bVar3 = l26;
                                String p18 = l27.p("id");
                                String p19 = l27.p("text");
                                e m36 = l27.m(str56);
                                if (m36 == null) {
                                    str22 = str56;
                                    str23 = str6;
                                    KLog.INSTANCE.e(str62, str23);
                                    eVar6 = eVar9;
                                    str25 = str59;
                                    i16 = i29;
                                    arrayList3 = arrayList8;
                                    userActionMenuConfig3 = userActionMenuConfig;
                                    imageConfig5 = null;
                                    str24 = str58;
                                } else {
                                    str22 = str56;
                                    str23 = str6;
                                    userActionMenuConfig3 = userActionMenuConfig;
                                    eVar6 = eVar9;
                                    i16 = i29;
                                    arrayList3 = arrayList8;
                                    str24 = str58;
                                    str25 = str59;
                                    imageConfig5 = new ImageConfig(m36.p(str51), (float) m36.h(str7), (float) m36.h(str52));
                                }
                                if (imageConfig5 == null) {
                                    str37 = str55;
                                    str31 = str52;
                                    str32 = str60;
                                    str33 = str8;
                                    str27 = str5;
                                    arrayList4 = arrayList3;
                                    str35 = str25;
                                    str29 = str7;
                                    str26 = str23;
                                    str30 = str51;
                                    str38 = str62;
                                    str39 = str24;
                                } else {
                                    boolean g16 = l27.g("joinAutoShow", false);
                                    String q16 = l27.q("aioMsg", str60);
                                    boolean g17 = l27.g("sameAutoShow", false);
                                    e m37 = l27.m("replyInteraction");
                                    if (m37 == null) {
                                        KLog.INSTANCE.e(str62, "parseBarrageReplyConfigFromJson jsonObj is null");
                                        str37 = str55;
                                        str31 = str52;
                                        str32 = str60;
                                        str36 = str62;
                                        str33 = str8;
                                        str27 = str5;
                                        str35 = str25;
                                        barrageReplyInteractionConfig = null;
                                        str29 = str7;
                                        str26 = str23;
                                        str30 = str51;
                                        str34 = str24;
                                    } else {
                                        String str63 = str5;
                                        String p26 = m37.p(str63);
                                        e m38 = m37.m("replyButtonImage");
                                        if (m38 == null) {
                                            KLog.INSTANCE.e(str62, str23);
                                            str26 = str23;
                                            str27 = str63;
                                            str28 = p26;
                                            imageConfig6 = null;
                                        } else {
                                            str26 = str23;
                                            str27 = str63;
                                            str28 = p26;
                                            imageConfig6 = new ImageConfig(m38.p(str51), (float) m38.h(str7), (float) m38.h(str52));
                                        }
                                        if (imageConfig6 == null) {
                                            imageConfig6 = new ImageConfig(null, 0.0f, 0.0f, 7, null);
                                        }
                                        String p27 = m37.p(str55);
                                        e m39 = m37.m("replyBubble");
                                        if (m39 == null) {
                                            KLog.INSTANCE.e(str62, "parseBubbleConfigFromJson jsonObj is null");
                                            str37 = str55;
                                            str31 = str52;
                                            str32 = str60;
                                            str36 = str62;
                                            str33 = str8;
                                            str35 = str25;
                                            bubbleConfig = null;
                                            str29 = str7;
                                            str30 = str51;
                                            str34 = str24;
                                        } else {
                                            String str64 = str55;
                                            str29 = str7;
                                            String str65 = str25;
                                            str30 = str51;
                                            str31 = str52;
                                            str32 = str60;
                                            str33 = str8;
                                            str34 = str24;
                                            str35 = str65;
                                            str36 = str62;
                                            str37 = str64;
                                            bubbleConfig = new BubbleConfig(m39.k("displayTime", 3000), (float) m39.i(NodeProps.MAX_WIDTH, 300.0d), (float) m39.i(str65, 12.0d), (float) m39.i("fontSize", 14.0d), UtilsKt.toColor(m39.p("fontColor")), (float) m39.i(NodeProps.LINE_HEIGHT, 20.0d), UtilsKt.toColor(m39.p(str33)), (float) m39.i(NodeProps.BORDER_RADIUS, 6.0d), UtilsKt.toColor(m39.p(NodeProps.BORDER_COLOR)), (float) m39.i(NodeProps.BORDER_WIDTH, 0.0d), m39.g("hasArrow", true));
                                        }
                                        barrageReplyInteractionConfig = new BarrageReplyInteractionConfig(str28, imageConfig6, p27, bubbleConfig);
                                    }
                                    e m46 = l27.m("localReplyEffect");
                                    if (m46 == null) {
                                        str38 = str36;
                                        KLog.INSTANCE.e(str38, "parseBarrageLocalReplyEffect jsonObj is null");
                                        str39 = str34;
                                        barrageLocalReplyEffect = null;
                                    } else {
                                        str38 = str36;
                                        str39 = str34;
                                        b l28 = m46.l(str39);
                                        if (l28 == null) {
                                            l28 = new b();
                                        }
                                        ArrayList arrayList9 = new ArrayList();
                                        int c26 = l28.c();
                                        for (int i37 = 0; i37 < c26; i37++) {
                                            String o16 = l28.o(i37);
                                            if (o16 != null) {
                                                arrayList9.add(o16);
                                            }
                                        }
                                        barrageLocalReplyEffect = new BarrageLocalReplyEffect(arrayList9, m46.g("needRefNick", false), m46.k("autoReplyDuring", 0));
                                    }
                                    arrayList4 = arrayList3;
                                    arrayList4.add(new BarrageItemConfig(p18, p19, imageConfig5, g16, q16, g17, barrageReplyInteractionConfig, barrageLocalReplyEffect));
                                }
                            }
                            i29 = i16 + 1;
                            str62 = str38;
                            arrayList8 = arrayList4;
                            str8 = str33;
                            c19 = i36;
                            userActionMenuConfig = userActionMenuConfig3;
                            l26 = bVar3;
                            str56 = str22;
                            eVar9 = eVar6;
                            str51 = str30;
                            str52 = str31;
                            str60 = str32;
                            str59 = str35;
                            str58 = str39;
                            str7 = str29;
                            str6 = str26;
                            str5 = str27;
                            str55 = str37;
                        }
                        eVar5 = eVar9;
                        str14 = str7;
                        str15 = str58;
                        str16 = str59;
                        str17 = str51;
                        str18 = str52;
                        str19 = str60;
                        str20 = str62;
                        arrayList2 = arrayList8;
                        str21 = str6;
                        userActionMenuConfig2 = userActionMenuConfig;
                    }
                    str40 = str19;
                    barrageConfig = new BarrageConfig(arrayList2, m29.q("defaultAioMsg", str40), m29.k("localLoopTime", 3000), m29.k("requestLoopDefaultTime", 5000));
                }
                if (barrageConfig == null) {
                    return null;
                }
                e eVar10 = eVar5;
                e m47 = eVar10.m("joinPropConfig");
                if (m47 == null) {
                    KLog.INSTANCE.e(str20, "parseJoinPropConfig jsonObj is null");
                    str43 = str15;
                    str44 = str14;
                    barrageConfig2 = barrageConfig;
                    str41 = str21;
                    str42 = str17;
                    str45 = str18;
                    joinPropConfig = null;
                } else {
                    String q17 = m47.q("title", str40);
                    String q18 = m47.q(TuxUIConstants.POP_BTN_TEXT, str40);
                    float h16 = (float) m47.h("imagePadding");
                    e m48 = m47.m("image");
                    if (m48 == null) {
                        str41 = str21;
                        KLog.INSTANCE.e(str20, str41);
                        str43 = str15;
                        str44 = str14;
                        barrageConfig2 = barrageConfig;
                        str42 = str17;
                        str45 = str18;
                        imageConfig7 = null;
                    } else {
                        str41 = str21;
                        str42 = str17;
                        barrageConfig2 = barrageConfig;
                        str43 = str15;
                        str44 = str14;
                        str45 = str18;
                        imageConfig7 = new ImageConfig(m48.p(str42), (float) m48.h(str14), (float) m48.h(str45));
                    }
                    joinPropConfig = new JoinPropConfig(q17, q18, h16, imageConfig7);
                }
                if (joinPropConfig == null) {
                    return null;
                }
                e m49 = eVar10.m("shootConfig");
                if (m49 == null) {
                    KLog.INSTANCE.e(str20, "parseJoinPropConfig jsonObj is null");
                    shootConfig = null;
                } else {
                    ArrayList arrayList10 = new ArrayList();
                    b l29 = m49.l("emojis");
                    if (l29 != null) {
                        int c27 = l29.c();
                        for (int i38 = 0; i38 < c27; i38++) {
                            if (BooleanCompanionObject.INSTANCE instanceof e) {
                                d17 = Boolean.valueOf(l29.e(i38));
                            } else if (IntCompanionObject.INSTANCE instanceof e) {
                                d17 = Integer.valueOf(l29.i(i38));
                            } else if (LongCompanionObject.INSTANCE instanceof e) {
                                d17 = Long.valueOf(l29.m(i38));
                            } else if (StringCompanionObject.INSTANCE instanceof e) {
                                d17 = l29.o(i38);
                            } else if (DoubleCompanionObject.INSTANCE instanceof e) {
                                d17 = Double.valueOf(l29.g(i38));
                            } else {
                                d17 = l29.d(i38);
                            }
                            if (d17 != null) {
                                e eVar11 = (e) d17;
                                arrayList10.add(new ShootEmojiItemConfig(eVar11.p("emojiId"), eVar11.p("entranceIcon"), eVar11.p("topGuideTip"), eVar11.p("newTopGuideTip"), eVar11.p("bottomTip"), eVar11.p("shootIcon"), eVar11.p("boomAPNG"), eVar11.p("bottomPNG"), eVar11.p("emojiUrl"), eVar11.p("captionImageUrl")));
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                            }
                        }
                    }
                    ArrayList arrayList11 = new ArrayList();
                    b l36 = m49.l("numbers");
                    if (l36 != null) {
                        int c28 = l36.c();
                        for (int i39 = 0; i39 < c28; i39++) {
                            if (BooleanCompanionObject.INSTANCE instanceof String) {
                                d16 = Boolean.valueOf(l36.e(i39));
                            } else if (IntCompanionObject.INSTANCE instanceof String) {
                                d16 = Integer.valueOf(l36.i(i39));
                            } else if (LongCompanionObject.INSTANCE instanceof String) {
                                d16 = Long.valueOf(l36.m(i39));
                            } else if (StringCompanionObject.INSTANCE instanceof String) {
                                d16 = l36.o(i39);
                            } else if (DoubleCompanionObject.INSTANCE instanceof String) {
                                d16 = Double.valueOf(l36.g(i39));
                            } else {
                                d16 = l36.d(i39);
                            }
                            if (d16 != null) {
                                arrayList11.add((String) d16);
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                        }
                    }
                    shootConfig = new ShootConfig(arrayList10, arrayList11, (float) m49.i("boomEffectRadius", 120.0d));
                }
                if (shootConfig == null) {
                    return null;
                }
                e m56 = eVar10.m("matchConfig");
                if (m56 == null) {
                    KLog.INSTANCE.e(str20, "parseMatchConfig jsonObj is null");
                    joinPropConfig2 = joinPropConfig;
                    str46 = str41;
                    str47 = str42;
                    str48 = str44;
                    matchConfig = null;
                    i17 = 0;
                    shootConfig2 = shootConfig;
                } else {
                    b l37 = m56.l(str43);
                    ArrayList arrayList12 = new ArrayList();
                    if (l37 != null) {
                        int c29 = l37.c();
                        for (int i46 = 0; i46 < c29; i46++) {
                            arrayList12.add(String.valueOf(l37.p(i46, str40)));
                        }
                    }
                    e m57 = m56.m("topRightBackgroundImg");
                    if (m57 != null) {
                        str48 = str44;
                        i17 = 0;
                        shootConfig2 = shootConfig;
                        joinPropConfig2 = joinPropConfig;
                        str47 = str42;
                        str46 = str41;
                        str49 = str16;
                        backgroundImage = new BackgroundImage(m57.k(str48, 0), m57.k(str45, 0), m57.q("url", str40), m57.k(str49, 0));
                    } else {
                        joinPropConfig2 = joinPropConfig;
                        str46 = str41;
                        str47 = str42;
                        str48 = str44;
                        str49 = str16;
                        i17 = 0;
                        shootConfig2 = shootConfig;
                        backgroundImage = new BackgroundImage(0, 0, str40, 0);
                    }
                    String q19 = m56.q("cardBackgroundImg", str40);
                    e m58 = m56.m("cartoonImg");
                    if (m58 != null) {
                        backgroundImage2 = new BackgroundImage(m58.k(str48, i17), m58.k(str45, i17), m58.q("url", str40), m58.k(str49, i17));
                    } else {
                        backgroundImage2 = new BackgroundImage(i17, i17, str40, i17);
                    }
                    b l38 = m56.l("welcomeText");
                    ArrayList arrayList13 = new ArrayList();
                    if (l38 != null) {
                        int c36 = l38.c();
                        for (int i47 = i17; i47 < c36; i47++) {
                            arrayList13.add(String.valueOf(l38.p(i47, str40)));
                        }
                    }
                    e m59 = m56.m("guide");
                    if (m59 == null) {
                        KLog.INSTANCE.e(str20, "parseGuide jsonObj is null");
                        guide = null;
                    } else {
                        String q26 = m59.q("guideText", str40);
                        b l39 = m59.l("images");
                        ArrayList arrayList14 = new ArrayList();
                        if (l39 != null) {
                            int c37 = l39.c();
                            for (int i48 = i17; i48 < c37; i48++) {
                                arrayList14.add(String.valueOf(l39.p(i48, str40)));
                            }
                        }
                        guide = new Guide(q26, arrayList14);
                    }
                    matchConfig = guide == null ? null : new MatchConfig(arrayList12, backgroundImage, q19, backgroundImage2, arrayList13, guide);
                }
                if (matchConfig == null) {
                    return null;
                }
                b l46 = eVar10.l("hostImageryConfig");
                if (l46 != null) {
                    ArrayList arrayList15 = new ArrayList();
                    int c38 = l46.c();
                    for (int i49 = i17; i49 < c38; i49++) {
                        if (BooleanCompanionObject.INSTANCE instanceof String) {
                            d19 = Boolean.valueOf(l46.e(i49));
                        } else if (IntCompanionObject.INSTANCE instanceof String) {
                            d19 = Integer.valueOf(l46.i(i49));
                        } else if (LongCompanionObject.INSTANCE instanceof String) {
                            d19 = Long.valueOf(l46.m(i49));
                        } else if (StringCompanionObject.INSTANCE instanceof String) {
                            d19 = l46.o(i49);
                        } else if (DoubleCompanionObject.INSTANCE instanceof String) {
                            d19 = Double.valueOf(l46.g(i49));
                        } else {
                            d19 = l46.d(i49);
                        }
                        if (d19 != null) {
                            arrayList15.add((String) d19);
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    }
                    emptyList3 = CollectionsKt___CollectionsKt.toList(arrayList15);
                }
                emptyList3 = CollectionsKt__CollectionsKt.emptyList();
                List list2 = emptyList3;
                b l47 = eVar10.l("imageryConfig");
                if (l47 != null) {
                    ArrayList arrayList16 = new ArrayList();
                    int c39 = l47.c();
                    while (i17 < c39) {
                        if (BooleanCompanionObject.INSTANCE instanceof String) {
                            d18 = Boolean.valueOf(l47.e(i17));
                        } else if (IntCompanionObject.INSTANCE instanceof String) {
                            d18 = Integer.valueOf(l47.i(i17));
                        } else if (LongCompanionObject.INSTANCE instanceof String) {
                            d18 = Long.valueOf(l47.m(i17));
                        } else if (StringCompanionObject.INSTANCE instanceof String) {
                            d18 = l47.o(i17);
                        } else if (DoubleCompanionObject.INSTANCE instanceof String) {
                            d18 = Double.valueOf(l47.g(i17));
                        } else {
                            d18 = l47.d(i17);
                        }
                        if (d18 != null) {
                            arrayList16.add((String) d18);
                            i17++;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    }
                    emptyList4 = CollectionsKt___CollectionsKt.toList(arrayList16);
                }
                emptyList4 = CollectionsKt__CollectionsKt.emptyList();
                List list3 = emptyList4;
                e m65 = eVar10.m("userMarkerConfig");
                if (m65 == null) {
                    KLog.INSTANCE.e(str20, "parseUserMarkerConfigFromJson jsonObj is null");
                } else {
                    w parseSizeFromJson2 = UtilsKt.parseSizeFromJson(m65.m("containerSize"));
                    if (parseSizeFromJson2 == null) {
                        parseSizeFromJson2 = new w(200.0f, 200.0f);
                    }
                    w wVar = parseSizeFromJson2;
                    w parseSizeFromJson3 = UtilsKt.parseSizeFromJson(m65.m("markerSize"));
                    if (parseSizeFromJson3 == null) {
                        parseSizeFromJson3 = new w(70.0f, 70.0f);
                    }
                    w wVar2 = parseSizeFromJson3;
                    w parseSizeFromJson4 = UtilsKt.parseSizeFromJson(m65.m("imageSize"));
                    if (parseSizeFromJson4 == null) {
                        parseSizeFromJson4 = new w(70.0f, 54.0f);
                    }
                    w wVar3 = parseSizeFromJson4;
                    w parseSizeFromJson5 = UtilsKt.parseSizeFromJson(m65.m("infoBarSize"));
                    if (parseSizeFromJson5 == null) {
                        parseSizeFromJson5 = new w(70.0f, 16.0f);
                    }
                    w wVar4 = parseSizeFromJson5;
                    String p28 = m65.p("infoBarBgColor");
                    float i56 = (float) m65.i("infoBarRadius", 8.0d);
                    w parseSizeFromJson6 = UtilsKt.parseSizeFromJson(m65.m("avatarContainerSize"));
                    if (parseSizeFromJson6 == null) {
                        parseSizeFromJson6 = new w(16.0f, 16.0f);
                    }
                    w wVar5 = parseSizeFromJson6;
                    w parseSizeFromJson7 = UtilsKt.parseSizeFromJson(m65.m("avatarSize"));
                    if (parseSizeFromJson7 == null) {
                        parseSizeFromJson7 = new w(12.0f, 12.0f);
                    }
                    w wVar6 = parseSizeFromJson7;
                    float i57 = (float) m65.i("avatarBorder", 0.6d);
                    String p29 = m65.p("avatarBorderColor");
                    e m66 = m65.m("avatarOnlineIcon");
                    if (m66 == null) {
                        KLog.INSTANCE.e(str20, str46);
                        imageConfig8 = null;
                    } else {
                        imageConfig8 = new ImageConfig(m66.p(str47), (float) m66.h(str48), (float) m66.h(str45));
                    }
                    if (imageConfig8 == null) {
                        imageConfig8 = new ImageConfig(null, 0.0f, 0.0f, 7, null);
                    }
                    ImageConfig imageConfig11 = imageConfig8;
                    float i58 = (float) m65.i("nicknameLineHeight", 10.0d);
                    float i59 = (float) m65.i("nicknameFontSize", 8.0d);
                    String p36 = m65.p("nicknameFontColor");
                    float i65 = (float) m65.i("nicknameMaxWidth", 50.0d);
                    float i66 = (float) m65.i("nicknameMarginLeft", 2.0d);
                    BubbleConfig.Companion companion = BubbleConfig.Companion;
                    BubbleConfig parseFromJson4 = companion.parseFromJson(m65.m("hostNormalBubbleConfig"));
                    if (parseFromJson4 != null && (parseFromJson = companion.parseFromJson(m65.m("guestNormalBubbleConfig"))) != null && (parseFromJson2 = companion.parseFromJson(m65.m("replyBubbleConfig"))) != null && (parseFromJson3 = companion.parseFromJson(m65.m("localEffectBubbleConfig"))) != null) {
                        userMarkerConfig = new UserMarkerConfig(wVar, wVar2, wVar3, wVar4, UtilsKt.toColor(p28), i56, wVar5, wVar6, i57, UtilsKt.toColor(p29), imageConfig11, i58, i59, UtilsKt.toColor(p36), i65, i66, parseFromJson4, parseFromJson, parseFromJson2, parseFromJson3, list2, list3);
                        if (userMarkerConfig != null) {
                            return null;
                        }
                        return new NBPMoodGroupConfig(indicatorConfig2, backgroundConfig2, userMarkerConfig, userActionMenuConfig2, barrageConfig2, joinPropConfig2, shootConfig2, matchConfig);
                    }
                }
                userMarkerConfig = null;
                if (userMarkerConfig != null) {
                }
            } catch (Exception e16) {
                KLog kLog = KLog.INSTANCE;
                StringBuilder m67 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("parse NBPMoodGroupConfig parse json error: ");
                m67.append(e16.getMessage());
                kLog.e("NBPMoodGroupConfig", m67.toString());
                return null;
            }
        }
    }

    public NBPMoodGroupConfig(IndicatorConfig indicatorConfig, BackgroundConfig backgroundConfig, UserMarkerConfig userMarkerConfig, UserActionMenuConfig userActionMenuConfig, BarrageConfig barrageConfig, JoinPropConfig joinPropConfig, ShootConfig shootConfig, MatchConfig matchConfig) {
        this.indicatorConfig = indicatorConfig;
        this.backgroundConfig = backgroundConfig;
        this.userMarkerConfig = userMarkerConfig;
        this.userActionMenuConfig = userActionMenuConfig;
        this.barrageConfig = barrageConfig;
        this.joinPropConfig = joinPropConfig;
        this.shootConfig = shootConfig;
        this.matchMsgConfig = matchConfig;
    }

    public final int hashCode() {
        return this.matchMsgConfig.hashCode() + ((this.shootConfig.hashCode() + ((this.joinPropConfig.hashCode() + ((this.barrageConfig.hashCode() + ((this.userActionMenuConfig.hashCode() + ((this.userMarkerConfig.hashCode() + ((this.backgroundConfig.hashCode() + (this.indicatorConfig.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("NBPMoodGroupConfig(indicatorConfig=");
        m3.append(this.indicatorConfig);
        m3.append(", backgroundConfig=");
        m3.append(this.backgroundConfig);
        m3.append(", userMarkerConfig=");
        m3.append(this.userMarkerConfig);
        m3.append(", userActionMenuConfig=");
        m3.append(this.userActionMenuConfig);
        m3.append(", barrageConfig=");
        m3.append(this.barrageConfig);
        m3.append(", joinPropConfig=");
        m3.append(this.joinPropConfig);
        m3.append(", shootConfig=");
        m3.append(this.shootConfig);
        m3.append(", matchMsgConfig=");
        m3.append(this.matchMsgConfig);
        m3.append(')');
        return m3.toString();
    }

    /* loaded from: classes31.dex */
    public static final class BackgroundConfig {
        public final ImageConfig background;
        public final GradientColor backgroundColor;
        public final float hostAreaMarginTop;
        public final w hostAreaSize;
        public final ImageConfig mainBuilding;
        public final List<Point> seatArea;
        public final float seatPaddingLeft;

        public BackgroundConfig(ImageConfig imageConfig, GradientColor gradientColor, ImageConfig imageConfig2, List<Point> list, float f16, w wVar, float f17) {
            this.background = imageConfig;
            this.backgroundColor = gradientColor;
            this.mainBuilding = imageConfig2;
            this.seatArea = list;
            this.seatPaddingLeft = f16;
            this.hostAreaSize = wVar;
            this.hostAreaMarginTop = f17;
        }

        public final ImageConfig getBackground() {
            return this.background;
        }

        public final int hashCode() {
            int hashCode = this.background.hashCode() * 31;
            GradientColor gradientColor = this.backgroundColor;
            return Float.floatToIntBits(this.hostAreaMarginTop) + ((this.hostAreaSize.hashCode() + PopoverTriangle$$ExternalSyntheticOutline0.m(this.seatPaddingLeft, (this.seatArea.hashCode() + ((this.mainBuilding.hashCode() + ((hashCode + (gradientColor == null ? 0 : gradientColor.hashCode())) * 31)) * 31)) * 31, 31)) * 31);
        }

        public final String toString() {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("BackgroundConfig(background=");
            m3.append(this.background);
            m3.append(", backgroundColor=");
            m3.append(this.backgroundColor);
            m3.append(", mainBuilding=");
            m3.append(this.mainBuilding);
            m3.append(", seatArea=");
            m3.append(this.seatArea);
            m3.append(", seatPaddingLeft=");
            m3.append(this.seatPaddingLeft);
            m3.append(", hostAreaSize=");
            m3.append(this.hostAreaSize);
            m3.append(", hostAreaMarginTop=");
            m3.append(this.hostAreaMarginTop);
            m3.append(')');
            return m3.toString();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BackgroundConfig)) {
                return false;
            }
            BackgroundConfig backgroundConfig = (BackgroundConfig) obj;
            return Intrinsics.areEqual(this.background, backgroundConfig.background) && Intrinsics.areEqual(this.backgroundColor, backgroundConfig.backgroundColor) && Intrinsics.areEqual(this.mainBuilding, backgroundConfig.mainBuilding) && Intrinsics.areEqual(this.seatArea, backgroundConfig.seatArea) && Float.compare(this.seatPaddingLeft, backgroundConfig.seatPaddingLeft) == 0 && Intrinsics.areEqual(this.hostAreaSize, backgroundConfig.hostAreaSize) && Float.compare(this.hostAreaMarginTop, backgroundConfig.hostAreaMarginTop) == 0;
        }
    }

    /* loaded from: classes31.dex */
    public static final class BackgroundImage {
        public final int height;
        public final int offsetY;
        public final String url;
        public final int width;

        public BackgroundImage(int i3, int i16, String str, int i17) {
            this.width = i3;
            this.height = i16;
            this.url = str;
            this.offsetY = i17;
        }

        public final int hashCode() {
            return this.offsetY + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.url, QQAudioParams$$ExternalSyntheticOutline0.m(this.height, this.width * 31, 31), 31);
        }

        public final String toString() {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("BackgroundImage(width=");
            m3.append(this.width);
            m3.append(", height=");
            m3.append(this.height);
            m3.append(", url=");
            m3.append(this.url);
            m3.append(", offsetY=");
            return AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(m3, this.offsetY, ')');
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BackgroundImage)) {
                return false;
            }
            BackgroundImage backgroundImage = (BackgroundImage) obj;
            return this.width == backgroundImage.width && this.height == backgroundImage.height && Intrinsics.areEqual(this.url, backgroundImage.url) && this.offsetY == backgroundImage.offsetY;
        }
    }

    /* loaded from: classes31.dex */
    public static final class BarrageConfig {
        public final String defaultAioMsg;
        public final List<BarrageItemConfig> items;
        public final int localLoopTime;
        public final int requestLoopDefaultTime;

        public BarrageConfig(List<BarrageItemConfig> list, String str, int i3, int i16) {
            this.items = list;
            this.defaultAioMsg = str;
            this.localLoopTime = i3;
            this.requestLoopDefaultTime = i16;
        }

        public final int hashCode() {
            return this.requestLoopDefaultTime + QQAudioParams$$ExternalSyntheticOutline0.m(this.localLoopTime, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.defaultAioMsg, this.items.hashCode() * 31, 31), 31);
        }

        public final String toString() {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("BarrageConfig(items=");
            m3.append(this.items);
            m3.append(", defaultAioMsg=");
            m3.append(this.defaultAioMsg);
            m3.append(", localLoopTime=");
            m3.append(this.localLoopTime);
            m3.append(", requestLoopDefaultTime=");
            return AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(m3, this.requestLoopDefaultTime, ')');
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BarrageConfig)) {
                return false;
            }
            BarrageConfig barrageConfig = (BarrageConfig) obj;
            return Intrinsics.areEqual(this.items, barrageConfig.items) && Intrinsics.areEqual(this.defaultAioMsg, barrageConfig.defaultAioMsg) && this.localLoopTime == barrageConfig.localLoopTime && this.requestLoopDefaultTime == barrageConfig.requestLoopDefaultTime;
        }
    }

    /* loaded from: classes31.dex */
    public static final class BarrageItemConfig {
        public final String aioMsg;
        public final ImageConfig icon;

        /* renamed from: id, reason: collision with root package name */
        public final String f114228id;
        public final boolean joinAutoShow;
        public final BarrageLocalReplyEffect localReplyEffect;
        public final BarrageReplyInteractionConfig replyInteraction;
        public final boolean sameAutoShow;
        public final String text;

        public BarrageItemConfig(String str, String str2, ImageConfig imageConfig, boolean z16, String str3, boolean z17, BarrageReplyInteractionConfig barrageReplyInteractionConfig, BarrageLocalReplyEffect barrageLocalReplyEffect) {
            this.f114228id = str;
            this.text = str2;
            this.icon = imageConfig;
            this.joinAutoShow = z16;
            this.aioMsg = str3;
            this.sameAutoShow = z17;
            this.replyInteraction = barrageReplyInteractionConfig;
            this.localReplyEffect = barrageLocalReplyEffect;
        }

        public final boolean canReplyBarrage() {
            return (this.replyInteraction == null || this.localReplyEffect == null) ? false : true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            int hashCode = (this.icon.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.text, this.f114228id.hashCode() * 31, 31)) * 31;
            boolean z16 = this.joinAutoShow;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.aioMsg, (hashCode + i3) * 31, 31);
            boolean z17 = this.sameAutoShow;
            int i16 = (m3 + (z17 ? 1 : z17 ? 1 : 0)) * 31;
            BarrageReplyInteractionConfig barrageReplyInteractionConfig = this.replyInteraction;
            int hashCode2 = (i16 + (barrageReplyInteractionConfig == null ? 0 : barrageReplyInteractionConfig.hashCode())) * 31;
            BarrageLocalReplyEffect barrageLocalReplyEffect = this.localReplyEffect;
            return hashCode2 + (barrageLocalReplyEffect != null ? barrageLocalReplyEffect.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("BarrageItemConfig(id=");
            m3.append(this.f114228id);
            m3.append(", text=");
            m3.append(this.text);
            m3.append(", icon=");
            m3.append(this.icon);
            m3.append(", joinAutoShow=");
            m3.append(this.joinAutoShow);
            m3.append(", aioMsg=");
            m3.append(this.aioMsg);
            m3.append(", sameAutoShow=");
            m3.append(this.sameAutoShow);
            m3.append(", replyInteraction=");
            m3.append(this.replyInteraction);
            m3.append(", localReplyEffect=");
            m3.append(this.localReplyEffect);
            m3.append(')');
            return m3.toString();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BarrageItemConfig)) {
                return false;
            }
            BarrageItemConfig barrageItemConfig = (BarrageItemConfig) obj;
            return Intrinsics.areEqual(this.f114228id, barrageItemConfig.f114228id) && Intrinsics.areEqual(this.text, barrageItemConfig.text) && Intrinsics.areEqual(this.icon, barrageItemConfig.icon) && this.joinAutoShow == barrageItemConfig.joinAutoShow && Intrinsics.areEqual(this.aioMsg, barrageItemConfig.aioMsg) && this.sameAutoShow == barrageItemConfig.sameAutoShow && Intrinsics.areEqual(this.replyInteraction, barrageItemConfig.replyInteraction) && Intrinsics.areEqual(this.localReplyEffect, barrageItemConfig.localReplyEffect);
        }
    }

    /* loaded from: classes31.dex */
    public static final class BarrageLocalReplyEffect {
        public final int autoReplyDuring;
        public final boolean needRefNick;
        public final List<String> texts;

        public BarrageLocalReplyEffect(List<String> list, boolean z16, int i3) {
            this.texts = list;
            this.needRefNick = z16;
            this.autoReplyDuring = i3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            int hashCode = this.texts.hashCode() * 31;
            boolean z16 = this.needRefNick;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return this.autoReplyDuring + ((hashCode + i3) * 31);
        }

        public final String toString() {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("BarrageLocalReplyEffect(texts=");
            m3.append(this.texts);
            m3.append(", needRefNick=");
            m3.append(this.needRefNick);
            m3.append(", autoReplyDuring=");
            return AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(m3, this.autoReplyDuring, ')');
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BarrageLocalReplyEffect)) {
                return false;
            }
            BarrageLocalReplyEffect barrageLocalReplyEffect = (BarrageLocalReplyEffect) obj;
            return Intrinsics.areEqual(this.texts, barrageLocalReplyEffect.texts) && this.needRefNick == barrageLocalReplyEffect.needRefNick && this.autoReplyDuring == barrageLocalReplyEffect.autoReplyDuring;
        }
    }

    /* loaded from: classes31.dex */
    public static final class BarrageReplyInteractionConfig {
        public final String clickMsg;
        public final String interactionId;
        public final BubbleConfig replyBubble;
        public final ImageConfig replyButtonImage;

        public BarrageReplyInteractionConfig(String str, ImageConfig imageConfig, String str2, BubbleConfig bubbleConfig) {
            this.interactionId = str;
            this.replyButtonImage = imageConfig;
            this.clickMsg = str2;
            this.replyBubble = bubbleConfig;
        }

        public final int hashCode() {
            int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.clickMsg, (this.replyButtonImage.hashCode() + (this.interactionId.hashCode() * 31)) * 31, 31);
            BubbleConfig bubbleConfig = this.replyBubble;
            return m3 + (bubbleConfig == null ? 0 : bubbleConfig.hashCode());
        }

        public final String toString() {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("BarrageReplyInteractionConfig(interactionId=");
            m3.append(this.interactionId);
            m3.append(", replyButtonImage=");
            m3.append(this.replyButtonImage);
            m3.append(", clickMsg=");
            m3.append(this.clickMsg);
            m3.append(", replyBubble=");
            m3.append(this.replyBubble);
            m3.append(')');
            return m3.toString();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BarrageReplyInteractionConfig)) {
                return false;
            }
            BarrageReplyInteractionConfig barrageReplyInteractionConfig = (BarrageReplyInteractionConfig) obj;
            return Intrinsics.areEqual(this.interactionId, barrageReplyInteractionConfig.interactionId) && Intrinsics.areEqual(this.replyButtonImage, barrageReplyInteractionConfig.replyButtonImage) && Intrinsics.areEqual(this.clickMsg, barrageReplyInteractionConfig.clickMsg) && Intrinsics.areEqual(this.replyBubble, barrageReplyInteractionConfig.replyBubble);
        }
    }

    /* loaded from: classes31.dex */
    public static final class GradientColor {
        public final j[] colorStops;
        public final Direction direction;

        public GradientColor(Direction direction, j[] jVarArr) {
            this.direction = direction;
            this.colorStops = jVarArr;
        }

        public final int hashCode() {
            return Arrays.hashCode(this.colorStops) + (this.direction.hashCode() * 31);
        }

        public final String toString() {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("GradientColor(direction=");
            m3.append(this.direction);
            m3.append(", colorStops=");
            m3.append(Arrays.toString(this.colorStops));
            m3.append(')');
            return m3.toString();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GradientColor)) {
                return false;
            }
            GradientColor gradientColor = (GradientColor) obj;
            return this.direction == gradientColor.direction && Intrinsics.areEqual(this.colorStops, gradientColor.colorStops);
        }
    }

    /* loaded from: classes31.dex */
    public static final class Guide {
        public final String guideText;
        public final List<String> images;

        public Guide(String str, List<String> list) {
            this.guideText = str;
            this.images = list;
        }

        public final int hashCode() {
            return this.images.hashCode() + (this.guideText.hashCode() * 31);
        }

        public final String toString() {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Guide(guideText=");
            m3.append(this.guideText);
            m3.append(", images=");
            m3.append(this.images);
            m3.append(')');
            return m3.toString();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Guide)) {
                return false;
            }
            Guide guide = (Guide) obj;
            return Intrinsics.areEqual(this.guideText, guide.guideText) && Intrinsics.areEqual(this.images, guide.images);
        }
    }

    /* loaded from: classes31.dex */
    public static final class IndicatorConfig {
        public final h joinButtonBgColor;
        public final String joinButtonText;
        public final h joinButtonTextColor;
        public final String mapThemeId;
        public final ImageConfig moodIcon;
        public final String moodTitle;

        public IndicatorConfig(ImageConfig imageConfig, String str, String str2, String str3, h hVar, h hVar2) {
            this.moodIcon = imageConfig;
            this.moodTitle = str;
            this.mapThemeId = str2;
            this.joinButtonText = str3;
            this.joinButtonTextColor = hVar;
            this.joinButtonBgColor = hVar2;
        }

        public final int hashCode() {
            return this.joinButtonBgColor.hashCode() + ((this.joinButtonTextColor.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.joinButtonText, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.mapThemeId, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.moodTitle, this.moodIcon.hashCode() * 31, 31), 31), 31)) * 31);
        }

        public final String toString() {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("IndicatorConfig(moodIcon=");
            m3.append(this.moodIcon);
            m3.append(", moodTitle=");
            m3.append(this.moodTitle);
            m3.append(", mapThemeId=");
            m3.append(this.mapThemeId);
            m3.append(", joinButtonText=");
            m3.append(this.joinButtonText);
            m3.append(", joinButtonTextColor=");
            m3.append(this.joinButtonTextColor);
            m3.append(", joinButtonBgColor=");
            m3.append(this.joinButtonBgColor);
            m3.append(')');
            return m3.toString();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IndicatorConfig)) {
                return false;
            }
            IndicatorConfig indicatorConfig = (IndicatorConfig) obj;
            return Intrinsics.areEqual(this.moodIcon, indicatorConfig.moodIcon) && Intrinsics.areEqual(this.moodTitle, indicatorConfig.moodTitle) && Intrinsics.areEqual(this.mapThemeId, indicatorConfig.mapThemeId) && Intrinsics.areEqual(this.joinButtonText, indicatorConfig.joinButtonText) && Intrinsics.areEqual(this.joinButtonTextColor, indicatorConfig.joinButtonTextColor) && Intrinsics.areEqual(this.joinButtonBgColor, indicatorConfig.joinButtonBgColor);
        }
    }

    /* loaded from: classes31.dex */
    public static final class JoinPropConfig {
        public final String btnText;
        public final ImageConfig image;
        public final float imagePadding;
        public final String title;

        public JoinPropConfig(String str, String str2, float f16, ImageConfig imageConfig) {
            this.title = str;
            this.btnText = str2;
            this.imagePadding = f16;
            this.image = imageConfig;
        }

        public final int hashCode() {
            int m3 = PopoverTriangle$$ExternalSyntheticOutline0.m(this.imagePadding, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.btnText, this.title.hashCode() * 31, 31), 31);
            ImageConfig imageConfig = this.image;
            return m3 + (imageConfig == null ? 0 : imageConfig.hashCode());
        }

        public final String toString() {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("JoinPropConfig(title=");
            m3.append(this.title);
            m3.append(", btnText=");
            m3.append(this.btnText);
            m3.append(", imagePadding=");
            m3.append(this.imagePadding);
            m3.append(", image=");
            m3.append(this.image);
            m3.append(')');
            return m3.toString();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof JoinPropConfig)) {
                return false;
            }
            JoinPropConfig joinPropConfig = (JoinPropConfig) obj;
            return Intrinsics.areEqual(this.title, joinPropConfig.title) && Intrinsics.areEqual(this.btnText, joinPropConfig.btnText) && Float.compare(this.imagePadding, joinPropConfig.imagePadding) == 0 && Intrinsics.areEqual(this.image, joinPropConfig.image);
        }
    }

    /* loaded from: classes31.dex */
    public static final class MatchConfig {
        public final String cardBackgroundImg;
        public final BackgroundImage cartoonImg;
        public final Guide guide;
        public final List<String> texts;
        public final BackgroundImage topRightBackgroundImg;
        public final List<String> welcomeText;

        public MatchConfig(List<String> list, BackgroundImage backgroundImage, String str, BackgroundImage backgroundImage2, List<String> list2, Guide guide) {
            this.texts = list;
            this.topRightBackgroundImg = backgroundImage;
            this.cardBackgroundImg = str;
            this.cartoonImg = backgroundImage2;
            this.welcomeText = list2;
            this.guide = guide;
        }

        public final int hashCode() {
            return this.guide.hashCode() + ((this.welcomeText.hashCode() + ((this.cartoonImg.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.cardBackgroundImg, (this.topRightBackgroundImg.hashCode() + (this.texts.hashCode() * 31)) * 31, 31)) * 31)) * 31);
        }

        public final String toString() {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("MatchConfig(texts=");
            m3.append(this.texts);
            m3.append(", topRightBackgroundImg=");
            m3.append(this.topRightBackgroundImg);
            m3.append(", cardBackgroundImg=");
            m3.append(this.cardBackgroundImg);
            m3.append(", cartoonImg=");
            m3.append(this.cartoonImg);
            m3.append(", welcomeText=");
            m3.append(this.welcomeText);
            m3.append(", guide=");
            m3.append(this.guide);
            m3.append(')');
            return m3.toString();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MatchConfig)) {
                return false;
            }
            MatchConfig matchConfig = (MatchConfig) obj;
            return Intrinsics.areEqual(this.texts, matchConfig.texts) && Intrinsics.areEqual(this.topRightBackgroundImg, matchConfig.topRightBackgroundImg) && Intrinsics.areEqual(this.cardBackgroundImg, matchConfig.cardBackgroundImg) && Intrinsics.areEqual(this.cartoonImg, matchConfig.cartoonImg) && Intrinsics.areEqual(this.welcomeText, matchConfig.welcomeText) && Intrinsics.areEqual(this.guide, matchConfig.guide);
        }
    }

    /* loaded from: classes31.dex */
    public static final class ShootConfig {
        public final float boomEffectRadius;
        public final List<ShootEmojiItemConfig> emojis;
        public final List<String> numbers;

        public ShootConfig(List<ShootEmojiItemConfig> list, List<String> list2, float f16) {
            this.emojis = list;
            this.numbers = list2;
            this.boomEffectRadius = f16;
        }

        public final int hashCode() {
            return Float.floatToIntBits(this.boomEffectRadius) + ((this.numbers.hashCode() + (this.emojis.hashCode() * 31)) * 31);
        }

        public final String toString() {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ShootConfig(emojis=");
            m3.append(this.emojis);
            m3.append(", numbers=");
            m3.append(this.numbers);
            m3.append(", boomEffectRadius=");
            m3.append(this.boomEffectRadius);
            m3.append(')');
            return m3.toString();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ShootConfig)) {
                return false;
            }
            ShootConfig shootConfig = (ShootConfig) obj;
            return Intrinsics.areEqual(this.emojis, shootConfig.emojis) && Intrinsics.areEqual(this.numbers, shootConfig.numbers) && Float.compare(this.boomEffectRadius, shootConfig.boomEffectRadius) == 0;
        }
    }

    /* loaded from: classes31.dex */
    public static final class ShootEmojiItemConfig {
        public final String boomAPNG;
        public final String bottomPNG;
        public final String bottomTip;
        public final String captionImageUrl;
        public final String emojiId;
        public final String emojiUrl;
        public final String entranceIcon;
        public final String newTopGuideTip;
        public final String shootIcon;
        public final String topGuideTip;

        public ShootEmojiItemConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
            this.emojiId = str;
            this.entranceIcon = str2;
            this.topGuideTip = str3;
            this.newTopGuideTip = str4;
            this.bottomTip = str5;
            this.shootIcon = str6;
            this.boomAPNG = str7;
            this.bottomPNG = str8;
            this.emojiUrl = str9;
            this.captionImageUrl = str10;
        }

        public final int hashCode() {
            return this.captionImageUrl.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.emojiUrl, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.bottomPNG, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.boomAPNG, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.shootIcon, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.bottomTip, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.newTopGuideTip, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.topGuideTip, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.entranceIcon, this.emojiId.hashCode() * 31, 31), 31), 31), 31), 31), 31), 31), 31);
        }

        public final String toString() {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ShootEmojiItemConfig(emojiId=");
            m3.append(this.emojiId);
            m3.append(", entranceIcon=");
            m3.append(this.entranceIcon);
            m3.append(", topGuideTip=");
            m3.append(this.topGuideTip);
            m3.append(", newTopGuideTip=");
            m3.append(this.newTopGuideTip);
            m3.append(", bottomTip=");
            m3.append(this.bottomTip);
            m3.append(", shootIcon=");
            m3.append(this.shootIcon);
            m3.append(", boomAPNG=");
            m3.append(this.boomAPNG);
            m3.append(", bottomPNG=");
            m3.append(this.bottomPNG);
            m3.append(", emojiUrl=");
            m3.append(this.emojiUrl);
            m3.append(", captionImageUrl=");
            return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.captionImageUrl, ')');
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ShootEmojiItemConfig)) {
                return false;
            }
            ShootEmojiItemConfig shootEmojiItemConfig = (ShootEmojiItemConfig) obj;
            return Intrinsics.areEqual(this.emojiId, shootEmojiItemConfig.emojiId) && Intrinsics.areEqual(this.entranceIcon, shootEmojiItemConfig.entranceIcon) && Intrinsics.areEqual(this.topGuideTip, shootEmojiItemConfig.topGuideTip) && Intrinsics.areEqual(this.newTopGuideTip, shootEmojiItemConfig.newTopGuideTip) && Intrinsics.areEqual(this.bottomTip, shootEmojiItemConfig.bottomTip) && Intrinsics.areEqual(this.shootIcon, shootEmojiItemConfig.shootIcon) && Intrinsics.areEqual(this.boomAPNG, shootEmojiItemConfig.boomAPNG) && Intrinsics.areEqual(this.bottomPNG, shootEmojiItemConfig.bottomPNG) && Intrinsics.areEqual(this.emojiUrl, shootEmojiItemConfig.emojiUrl) && Intrinsics.areEqual(this.captionImageUrl, shootEmojiItemConfig.captionImageUrl);
        }
    }

    /* loaded from: classes31.dex */
    public static final class UserActionMenuConfig {
        public final List<UserActionMenuInteraction> interactions;
        public final Point offset;

        public UserActionMenuConfig(List<UserActionMenuInteraction> list, Point point) {
            this.interactions = list;
            this.offset = point;
        }

        public final int hashCode() {
            return this.offset.hashCode() + (this.interactions.hashCode() * 31);
        }

        public final String toString() {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("UserActionMenuConfig(interactions=");
            m3.append(this.interactions);
            m3.append(", offset=");
            m3.append(this.offset);
            m3.append(')');
            return m3.toString();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UserActionMenuConfig)) {
                return false;
            }
            UserActionMenuConfig userActionMenuConfig = (UserActionMenuConfig) obj;
            return Intrinsics.areEqual(this.interactions, userActionMenuConfig.interactions) && Intrinsics.areEqual(this.offset, userActionMenuConfig.offset);
        }
    }

    /* loaded from: classes31.dex */
    public static final class UserActionMenuInteraction {
        public final String clickMsg;
        public final ImageConfig icon;
        public final String interactionId;
        public final String name;

        public UserActionMenuInteraction(String str, String str2, ImageConfig imageConfig, String str3) {
            this.interactionId = str;
            this.name = str2;
            this.icon = imageConfig;
            this.clickMsg = str3;
        }

        public final int hashCode() {
            return this.clickMsg.hashCode() + ((this.icon.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.name, this.interactionId.hashCode() * 31, 31)) * 31);
        }

        public final String toString() {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("UserActionMenuInteraction(interactionId=");
            m3.append(this.interactionId);
            m3.append(", name=");
            m3.append(this.name);
            m3.append(", icon=");
            m3.append(this.icon);
            m3.append(", clickMsg=");
            return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.clickMsg, ')');
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UserActionMenuInteraction)) {
                return false;
            }
            UserActionMenuInteraction userActionMenuInteraction = (UserActionMenuInteraction) obj;
            return Intrinsics.areEqual(this.interactionId, userActionMenuInteraction.interactionId) && Intrinsics.areEqual(this.name, userActionMenuInteraction.name) && Intrinsics.areEqual(this.icon, userActionMenuInteraction.icon) && Intrinsics.areEqual(this.clickMsg, userActionMenuInteraction.clickMsg);
        }
    }

    /* loaded from: classes31.dex */
    public static final class UserMarkerConfig {
        public final float avatarBorder;
        public final h avatarBorderColor;
        public final w avatarContainerSize;
        public final ImageConfig avatarOnlineIcon;
        public final float avatarRadius;
        public final w avatarSize;
        public final w containerSize;
        public final List<String> guestMarkerImages;
        public final BubbleConfig guestNormalBubbleConfig;
        public final List<String> hostMarkerImages;
        public final BubbleConfig hostNormalBubbleConfig;
        public final w imageSize;
        public final h infoBarBgColor;
        public final float infoBarRadius;
        public final w infoBarSize;
        public final BubbleConfig localEffectBubbleConfig;
        public final w markerSize;
        public final h nicknameFontColor;
        public final float nicknameFontSize;
        public final float nicknameLineHeight;
        public final float nicknameMarginLeft;
        public final float nicknameMaxWidth;
        public final BubbleConfig replyBubbleConfig;

        public UserMarkerConfig(w wVar, w wVar2, w wVar3, w wVar4, h hVar, float f16, w wVar5, w wVar6, float f17, h hVar2, ImageConfig imageConfig, float f18, float f19, h hVar3, float f26, float f27, BubbleConfig bubbleConfig, BubbleConfig bubbleConfig2, BubbleConfig bubbleConfig3, BubbleConfig bubbleConfig4, List<String> list, List<String> list2) {
            this.containerSize = wVar;
            this.markerSize = wVar2;
            this.imageSize = wVar3;
            this.infoBarSize = wVar4;
            this.infoBarBgColor = hVar;
            this.infoBarRadius = f16;
            this.avatarContainerSize = wVar5;
            this.avatarSize = wVar6;
            this.avatarBorder = f17;
            this.avatarBorderColor = hVar2;
            this.avatarOnlineIcon = imageConfig;
            this.nicknameLineHeight = f18;
            this.nicknameFontSize = f19;
            this.nicknameFontColor = hVar3;
            this.nicknameMaxWidth = f26;
            this.nicknameMarginLeft = f27;
            this.hostNormalBubbleConfig = bubbleConfig;
            this.guestNormalBubbleConfig = bubbleConfig2;
            this.replyBubbleConfig = bubbleConfig3;
            this.localEffectBubbleConfig = bubbleConfig4;
            this.hostMarkerImages = list;
            this.guestMarkerImages = list2;
            this.avatarRadius = wVar6.getWidth() / 2.0f;
        }

        public final w getContainerSize() {
            return this.containerSize;
        }

        public final w getMarkerSize() {
            return this.markerSize;
        }

        public final int hashCode() {
            return this.guestMarkerImages.hashCode() + ((this.hostMarkerImages.hashCode() + ((this.localEffectBubbleConfig.hashCode() + ((this.replyBubbleConfig.hashCode() + ((this.guestNormalBubbleConfig.hashCode() + ((this.hostNormalBubbleConfig.hashCode() + PopoverTriangle$$ExternalSyntheticOutline0.m(this.nicknameMarginLeft, PopoverTriangle$$ExternalSyntheticOutline0.m(this.nicknameMaxWidth, (this.nicknameFontColor.hashCode() + PopoverTriangle$$ExternalSyntheticOutline0.m(this.nicknameFontSize, PopoverTriangle$$ExternalSyntheticOutline0.m(this.nicknameLineHeight, (this.avatarOnlineIcon.hashCode() + ((this.avatarBorderColor.hashCode() + PopoverTriangle$$ExternalSyntheticOutline0.m(this.avatarBorder, (this.avatarSize.hashCode() + ((this.avatarContainerSize.hashCode() + PopoverTriangle$$ExternalSyntheticOutline0.m(this.infoBarRadius, (this.infoBarBgColor.hashCode() + ((this.infoBarSize.hashCode() + ((this.imageSize.hashCode() + ((this.markerSize.hashCode() + (this.containerSize.hashCode() * 31)) * 31)) * 31)) * 31)) * 31, 31)) * 31)) * 31, 31)) * 31)) * 31, 31), 31)) * 31, 31), 31)) * 31)) * 31)) * 31)) * 31)) * 31);
        }

        public final String toString() {
            return "UserMarkerConfig(containerSize=" + this.containerSize + ", markerSize=" + this.markerSize + ", imageSize=" + this.imageSize + ", infoBarSize=" + this.infoBarSize + ", infoBarBgColor=" + this.infoBarBgColor + ", infoBarRadius=" + this.infoBarRadius + ", avatarContainerSize=" + this.avatarContainerSize + ", avatarSize=" + this.avatarSize + ", avatarBorder=" + this.avatarBorder + ", avatarBorderColor=" + this.avatarBorderColor + ", avatarOnlineIcon=" + this.avatarOnlineIcon + ", nicknameLineHeight=" + this.nicknameLineHeight + ", nicknameFontSize=" + this.nicknameFontSize + ", nicknameFontColor=" + this.nicknameFontColor + ", nicknameMaxWidth=" + this.nicknameMaxWidth + ", nicknameMarginLeft=" + this.nicknameMarginLeft + ", hostNormalBubbleConfig=" + this.hostNormalBubbleConfig + ", guestNormalBubbleConfig=" + this.guestNormalBubbleConfig + ", replyBubbleConfig=" + this.replyBubbleConfig + ", localEffectBubbleConfig=" + this.localEffectBubbleConfig + ", hostMarkerImages=" + this.hostMarkerImages + ", guestMarkerImages=" + this.guestMarkerImages + ')';
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UserMarkerConfig)) {
                return false;
            }
            UserMarkerConfig userMarkerConfig = (UserMarkerConfig) obj;
            return Intrinsics.areEqual(this.containerSize, userMarkerConfig.containerSize) && Intrinsics.areEqual(this.markerSize, userMarkerConfig.markerSize) && Intrinsics.areEqual(this.imageSize, userMarkerConfig.imageSize) && Intrinsics.areEqual(this.infoBarSize, userMarkerConfig.infoBarSize) && Intrinsics.areEqual(this.infoBarBgColor, userMarkerConfig.infoBarBgColor) && Float.compare(this.infoBarRadius, userMarkerConfig.infoBarRadius) == 0 && Intrinsics.areEqual(this.avatarContainerSize, userMarkerConfig.avatarContainerSize) && Intrinsics.areEqual(this.avatarSize, userMarkerConfig.avatarSize) && Float.compare(this.avatarBorder, userMarkerConfig.avatarBorder) == 0 && Intrinsics.areEqual(this.avatarBorderColor, userMarkerConfig.avatarBorderColor) && Intrinsics.areEqual(this.avatarOnlineIcon, userMarkerConfig.avatarOnlineIcon) && Float.compare(this.nicknameLineHeight, userMarkerConfig.nicknameLineHeight) == 0 && Float.compare(this.nicknameFontSize, userMarkerConfig.nicknameFontSize) == 0 && Intrinsics.areEqual(this.nicknameFontColor, userMarkerConfig.nicknameFontColor) && Float.compare(this.nicknameMaxWidth, userMarkerConfig.nicknameMaxWidth) == 0 && Float.compare(this.nicknameMarginLeft, userMarkerConfig.nicknameMarginLeft) == 0 && Intrinsics.areEqual(this.hostNormalBubbleConfig, userMarkerConfig.hostNormalBubbleConfig) && Intrinsics.areEqual(this.guestNormalBubbleConfig, userMarkerConfig.guestNormalBubbleConfig) && Intrinsics.areEqual(this.replyBubbleConfig, userMarkerConfig.replyBubbleConfig) && Intrinsics.areEqual(this.localEffectBubbleConfig, userMarkerConfig.localEffectBubbleConfig) && Intrinsics.areEqual(this.hostMarkerImages, userMarkerConfig.hostMarkerImages) && Intrinsics.areEqual(this.guestMarkerImages, userMarkerConfig.guestMarkerImages);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NBPMoodGroupConfig)) {
            return false;
        }
        NBPMoodGroupConfig nBPMoodGroupConfig = (NBPMoodGroupConfig) obj;
        return Intrinsics.areEqual(this.indicatorConfig, nBPMoodGroupConfig.indicatorConfig) && Intrinsics.areEqual(this.backgroundConfig, nBPMoodGroupConfig.backgroundConfig) && Intrinsics.areEqual(this.userMarkerConfig, nBPMoodGroupConfig.userMarkerConfig) && Intrinsics.areEqual(this.userActionMenuConfig, nBPMoodGroupConfig.userActionMenuConfig) && Intrinsics.areEqual(this.barrageConfig, nBPMoodGroupConfig.barrageConfig) && Intrinsics.areEqual(this.joinPropConfig, nBPMoodGroupConfig.joinPropConfig) && Intrinsics.areEqual(this.shootConfig, nBPMoodGroupConfig.shootConfig) && Intrinsics.areEqual(this.matchMsgConfig, nBPMoodGroupConfig.matchMsgConfig);
    }
}
