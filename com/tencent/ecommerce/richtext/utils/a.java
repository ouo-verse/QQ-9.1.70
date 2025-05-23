package com.tencent.ecommerce.richtext.utils;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.internal.view.SupportMenu;
import com.tencent.ecommerce.richtext.utils.d;
import com.tencent.liteav.TXLiteAVCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, Integer> f105490a;

    /* renamed from: b, reason: collision with root package name */
    private static final d.c<Integer> f105491b;

    /* renamed from: c, reason: collision with root package name */
    private static final d.InterfaceC1112d<Number> f105492c;

    /* compiled from: P */
    /* renamed from: com.tencent.ecommerce.richtext.utils.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class C1111a implements d.c<Integer> {
        C1111a() {
        }

        @Override // com.tencent.ecommerce.richtext.utils.d.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Integer a(String str) {
            int i3 = 255;
            int u16 = e.u(str, 255);
            if (u16 < 0) {
                i3 = 0;
            } else if (u16 <= 255) {
                i3 = u16;
            }
            return Integer.valueOf(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class b implements d.InterfaceC1112d<Number> {
        b() {
        }

        @Override // com.tencent.ecommerce.richtext.utils.d.InterfaceC1112d
        public List<Number> a(List<String> list) {
            ArrayList arrayList = new ArrayList(4);
            int i3 = 0;
            while (i3 < 3) {
                int i16 = 255;
                int u16 = e.u(list.get(i3), 255);
                if (u16 < 0) {
                    i16 = 0;
                } else if (u16 <= 255) {
                    i16 = u16;
                }
                arrayList.add(Integer.valueOf(i16));
                i3++;
            }
            arrayList.add(Float.valueOf(list.get(i3)));
            return arrayList;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f105490a = hashMap;
        f105491b = new C1111a();
        f105492c = new b();
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
        hashMap.put("blueviolet", -7722014);
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
        hashMap.put("darkslategrey", -13676721);
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
        hashMap.put("gray", -8355712);
        hashMap.put("grey", -8355712);
        hashMap.put("green", -16744448);
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
        hashMap.put("transparent", 0);
    }

    public static boolean a(String str) {
        return f105490a.containsKey(str);
    }

    private static int b(float f16) {
        return (int) (f16 * 255.0f);
    }

    public static int c(String str) {
        return d(str, Integer.MIN_VALUE);
    }

    public static int d(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return i3;
        }
        String trim = str.trim();
        if (a(trim)) {
            return f105490a.get(trim).intValue();
        }
        Pair<Boolean, Integer> e16 = e(trim);
        if (((Boolean) e16.first).booleanValue()) {
            return ((Integer) e16.second).intValue();
        }
        try {
            if (trim.indexOf("rgba") == 0) {
                e16 = f(trim);
                if (((Boolean) e16.first).booleanValue()) {
                    return ((Integer) e16.second).intValue();
                }
            }
            if (trim.indexOf("rgb") == 0) {
                e16 = g(trim);
                if (((Boolean) e16.first).booleanValue()) {
                    return ((Integer) e16.second).intValue();
                }
            }
            if (((Integer) e16.second).intValue() == 0) {
                return ((Integer) e16.second).intValue();
            }
        } catch (RuntimeException unused) {
        }
        return i3;
    }

    @NonNull
    private static Pair<Boolean, Integer> e(String str) {
        if (str.length() == 4) {
            int parseInt = Integer.parseInt(str.substring(1, 2), 16);
            int parseInt2 = Integer.parseInt(str.substring(2, 3), 16);
            int parseInt3 = Integer.parseInt(str.substring(3, 4), 16);
            return new Pair<>(Boolean.TRUE, Integer.valueOf(Color.rgb(parseInt + (parseInt << 4), parseInt2 + (parseInt2 << 4), parseInt3 + (parseInt3 << 4))));
        }
        if (str.length() != 7 && str.length() != 9) {
            return new Pair<>(Boolean.FALSE, 0);
        }
        return new Pair<>(Boolean.TRUE, Integer.valueOf(Color.parseColor(str)));
    }

    @NonNull
    private static Pair<Boolean, Integer> f(String str) {
        List e16 = new d(str, f105492c).e("rgba");
        if (e16 != null && e16.size() == 4) {
            return new Pair<>(Boolean.TRUE, Integer.valueOf(Color.argb(b(((Number) e16.get(3)).floatValue()), ((Number) e16.get(0)).intValue(), ((Number) e16.get(1)).intValue(), ((Number) e16.get(2)).intValue())));
        }
        return new Pair<>(Boolean.FALSE, 0);
    }

    @NonNull
    private static Pair<Boolean, Integer> g(String str) {
        List e16 = new d(str, f105491b).e("rgb");
        if (e16 != null && e16.size() == 3) {
            return new Pair<>(Boolean.TRUE, Integer.valueOf(Color.rgb(((Integer) e16.get(0)).intValue(), ((Integer) e16.get(1)).intValue(), ((Integer) e16.get(2)).intValue())));
        }
        return new Pair<>(Boolean.FALSE, 0);
    }
}
