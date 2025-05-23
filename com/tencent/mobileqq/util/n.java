package com.tencent.mobileqq.util;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.core.internal.view.SupportMenu;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Locale;
import java.util.StringTokenizer;

/* compiled from: P */
/* loaded from: classes20.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<String, Integer> f306791a;

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        f306791a = hashMap;
        hashMap.put("transparent", 0);
        hashMap.put("none", 0);
        hashMap.put("aliceblue", -984833);
        hashMap.put("antiquewhite", -332841);
        hashMap.put("aqua", -16711681);
        hashMap.put("aquamarine", -8388652);
        hashMap.put("azure", -983041);
        hashMap.put("beige", -657956);
        hashMap.put("bisque", -6972);
        hashMap.put("black", -16777216);
        hashMap.put("blanchedalmond", -5171);
        hashMap.put("blue", -16776961);
        hashMap.put("blueViolet", -7722014);
        hashMap.put("brown", -5952982);
        hashMap.put("burlywood", -2180985);
        hashMap.put("cadetblue", -10510688);
        hashMap.put("chartreuse", -8388864);
        hashMap.put("chocolate", -2987746);
        hashMap.put("coral", -32944);
        hashMap.put("cornflowerblue", -10185235);
        hashMap.put("cornsilk", -1828);
        hashMap.put("crimson", -2354116);
        hashMap.put("cyan", -16711681);
        hashMap.put("darkblue", -16777077);
        hashMap.put("darkcyan", -16741493);
        hashMap.put("darkgoldenrod", -4684277);
        hashMap.put("darkgray", -5658199);
        hashMap.put("darkgreen", -16751616);
        hashMap.put("darkkhaki", -4343957);
        hashMap.put("darkmagenta", -7667573);
        hashMap.put("darkolivegreen", -11179217);
        hashMap.put("darkorange", -29696);
        hashMap.put("darkorchid", -6737204);
        hashMap.put("darkred", -7667712);
        hashMap.put("darksalmon", -1468806);
        hashMap.put("darkseagreen", -7357297);
        hashMap.put("darkslateblue", -12042869);
        hashMap.put("darkslategray", -13676721);
        hashMap.put("darkturquoise", -16724271);
        hashMap.put("darkviolet", -7077677);
        hashMap.put("deeppink", -60269);
        hashMap.put("deepskyblue", -16728065);
        hashMap.put("dimgray", -9868951);
        hashMap.put("dimgrey", -9868951);
        hashMap.put("dodgerblue", -14774017);
        hashMap.put("firebrick", -5103070);
        hashMap.put("floralwhite", -1296);
        hashMap.put("forestgreen", -14513374);
        hashMap.put("fuchsia", -65281);
        hashMap.put("gainsboro", -2302756);
        hashMap.put("ghostwhite", -460545);
        hashMap.put("gold", -10496);
        hashMap.put("goldenrod", -2448096);
        hashMap.put("gray", -7829368);
        hashMap.put("grey", -8355712);
        hashMap.put("green", -16711936);
        hashMap.put("greenyellow", -5374161);
        hashMap.put("honeydew", -983056);
        hashMap.put("hotpink", -38476);
        hashMap.put("indianred", -3318692);
        hashMap.put("indigo", -11861886);
        hashMap.put("ivory", -16);
        hashMap.put("khaki", -989556);
        hashMap.put("lavender", -1644806);
        hashMap.put("lavenderblush", -3851);
        hashMap.put("lawngreen", -8586240);
        hashMap.put("lemonchiffon", Integer.valueOf(TXLiteAVCode.ERR_AUDIO_PLUGIN_INSTALL_NOT_AUTHORIZED));
        hashMap.put("lightblue", -5383962);
        hashMap.put("lightcoral", -1015680);
        hashMap.put("lightcyan", -2031617);
        hashMap.put("lightgoldenrodyellow", -329006);
        hashMap.put("lightgray", -2894893);
        hashMap.put("lightgrey", -2894893);
        hashMap.put("lightgreen", -7278960);
        hashMap.put("lightpink", -18751);
        hashMap.put("lightsalmon", -24454);
        hashMap.put("lightseagreen", -14634326);
        hashMap.put("lightskyblue", -7876870);
        hashMap.put("lightslategray", -8943463);
        hashMap.put("lightslategrey", -8943463);
        hashMap.put("lightsteelblue", -5192482);
        hashMap.put("lightyellow", -32);
        hashMap.put("lime", -16711936);
        hashMap.put("limegreen", -13447886);
        hashMap.put("linen", -331546);
        hashMap.put("magenta", -65281);
        hashMap.put("maroon", -8388608);
        hashMap.put("mediumaquamarine", -10039894);
        hashMap.put("mediumblue", -16777011);
        hashMap.put("mediumorchid", -4565549);
        hashMap.put("mediumpurple", -7114533);
        hashMap.put("mediumseagreen", -12799119);
        hashMap.put("mediumslateblue", -8689426);
        hashMap.put("mediumspringgreen", -16713062);
        hashMap.put("mediumturquoise", -12004916);
        hashMap.put("mediumvioletred", -3730043);
        hashMap.put("midnightblue", -15132304);
        hashMap.put("mintcream", -655366);
        hashMap.put("mistyrose", -6943);
        hashMap.put("moccasin", -6987);
        hashMap.put("navajowhite", -8531);
        hashMap.put("navy", -16777088);
        hashMap.put("oldlace", -133658);
        hashMap.put("olive", -8355840);
        hashMap.put("olivedrab", -9728477);
        hashMap.put("orange", -23296);
        hashMap.put("orangered", -47872);
        hashMap.put("orchid", -2461482);
        hashMap.put("palegoldenrod", -1120086);
        hashMap.put("palegreen", -6751336);
        hashMap.put("paleturquoise", -5247250);
        hashMap.put("palevioletred", -2396013);
        hashMap.put("papayawhip", -4139);
        hashMap.put("peachpuff", -9543);
        hashMap.put("peru", -3308225);
        hashMap.put("pink", -16181);
        hashMap.put("plum", -2252579);
        hashMap.put("powderblue", -5185306);
        hashMap.put("purple", -8388480);
        hashMap.put("rebeccapurple", -10079335);
        hashMap.put("red", Integer.valueOf(SupportMenu.CATEGORY_MASK));
        hashMap.put("rosybrown", -4419697);
        hashMap.put("royalblue", -12490271);
        hashMap.put("saddlebrown", -7650029);
        hashMap.put("salmon", -360334);
        hashMap.put("sandybrown", -744352);
        hashMap.put("seagreen", -13726889);
        hashMap.put("seashell", -2578);
        hashMap.put("sienna", -6270419);
        hashMap.put("silver", -4144960);
        hashMap.put("skyblue", -7876885);
        hashMap.put("slateblue", -9807155);
        hashMap.put("slategray", -9404272);
        hashMap.put("slategrey", -9404272);
        hashMap.put("snow", -1286);
        hashMap.put("springgreen", -16711809);
        hashMap.put("steelblue", -12156236);
        hashMap.put("tan", -2968436);
        hashMap.put("teal", -16744320);
        hashMap.put("thistle", -2572328);
        hashMap.put("tomato", -40121);
        hashMap.put("turquoise", -12525360);
        hashMap.put("violet", -1146130);
        hashMap.put("wheat", -663885);
        hashMap.put("white", -1);
        hashMap.put("whitesmoke", -657931);
        hashMap.put("yellow", -256);
        hashMap.put("yellowgreen", -6632142);
    }

    public static int a(String str) {
        StringTokenizer stringTokenizer;
        int argb;
        try {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            if (!str.startsWith("rgba") && !str.startsWith("rgb")) {
                if (str.charAt(0) == '#') {
                    long parseLong = Long.parseLong(str.substring(1), 16);
                    if (str.length() == 4) {
                        int parseInt = Integer.parseInt(str.substring(1, 4), 16);
                        int i3 = parseInt & 3840;
                        int i16 = parseInt & 240;
                        int i17 = parseInt & 15;
                        argb = Color.rgb((i3 >> 8) | (i3 >> 4), (i16 >> 4) | i16, i17 | (i17 << 4));
                    } else if (str.length() == 5) {
                        int parseInt2 = Integer.parseInt(str.substring(1, 5), 16) & 15;
                        int i18 = parseInt2 | (parseInt2 << 4);
                        argb = Color.argb(i18, i18, i18, i18);
                    } else {
                        if (str.length() == 7) {
                            parseLong |= -16777216;
                        } else if (str.length() == 9) {
                            parseLong = ((255 & parseLong) << 24) | (((-256) & parseLong) >> 8);
                        }
                        return (int) parseLong;
                    }
                    parseLong = argb;
                    return (int) parseLong;
                }
                Integer num = f306791a.get(str.toLowerCase(Locale.ROOT));
                if (num != null) {
                    return num.intValue();
                }
                return 0;
            }
            if (str.startsWith("rgba")) {
                stringTokenizer = new StringTokenizer(str, "rgba()");
            } else if (str.startsWith("rgb")) {
                stringTokenizer = new StringTokenizer(str, "rgb()");
            } else {
                stringTokenizer = null;
            }
            while (stringTokenizer != null && stringTokenizer.hasMoreElements()) {
                String nextToken = stringTokenizer.nextToken();
                if (nextToken != null) {
                    String[] split = nextToken.split(",");
                    if (split.length == 4) {
                        return Color.argb((int) (Float.valueOf(split[3].trim()).floatValue() * 255.0f), Integer.valueOf(split[0].trim()).intValue(), Integer.valueOf(split[1].trim()).intValue(), Integer.valueOf(split[2].trim()).intValue());
                    }
                    if (split.length == 3) {
                        return Color.rgb(Integer.valueOf(split[0].trim()).intValue(), Integer.valueOf(split[1].trim()).intValue(), Integer.valueOf(split[2].trim()).intValue());
                    }
                }
            }
            return 0;
        } catch (Exception e16) {
            QLog.e("ColorUtils", 1, "parseColor error" + str + e16);
            return 0;
        }
    }
}
