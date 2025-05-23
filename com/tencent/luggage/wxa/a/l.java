package com.tencent.luggage.wxa.a;

import android.graphics.Matrix;
import android.util.Log;
import android.util.Xml;
import androidx.core.internal.view.SupportMenu;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.luggage.wxa.a.b;
import com.tencent.luggage.wxa.a.f;
import com.tencent.luggage.wxa.a.h;
import com.tencent.mobileqq.vas.avatar.NtFaceConstant;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasBusiness;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.pts.ui.vnode.PTSNodeTextBase;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.thumbplayer.api.common.TPChannelLayout;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import oicq.wlogin_sdk.tools.util;
import org.apache.httpcore.message.TokenParser;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.DefaultHandler2;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: P */
/* loaded from: classes8.dex */
public class l {

    /* renamed from: d, reason: collision with root package name */
    public int f120759d;

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.a.h f120756a = null;

    /* renamed from: b, reason: collision with root package name */
    public h.k0 f120757b = null;

    /* renamed from: c, reason: collision with root package name */
    public boolean f120758c = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f120760e = false;

    /* renamed from: f, reason: collision with root package name */
    public h f120761f = null;

    /* renamed from: g, reason: collision with root package name */
    public StringBuilder f120762g = null;

    /* renamed from: h, reason: collision with root package name */
    public boolean f120763h = false;

    /* renamed from: i, reason: collision with root package name */
    public StringBuilder f120764i = null;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f120765a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f120766b;

        static {
            int[] iArr = new int[g.values().length];
            f120766b = iArr;
            try {
                iArr[g.x.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f120766b[g.y.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f120766b[g.width.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f120766b[g.height.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f120766b[g.version.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f120766b[g.href.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f120766b[g.preserveAspectRatio.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f120766b[g.d.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f120766b[g.pathLength.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f120766b[g.rx.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f120766b[g.ry.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f120766b[g.cx.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f120766b[g.cy.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f120766b[g.r.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f120766b[g.x1.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f120766b[g.y1.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f120766b[g.x2.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f120766b[g.y2.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f120766b[g.dx.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f120766b[g.dy.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f120766b[g.requiredFeatures.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f120766b[g.requiredExtensions.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f120766b[g.systemLanguage.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f120766b[g.requiredFormats.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f120766b[g.requiredFonts.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f120766b[g.refX.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f120766b[g.refY.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                f120766b[g.markerWidth.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f120766b[g.markerHeight.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                f120766b[g.markerUnits.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                f120766b[g.orient.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                f120766b[g.gradientUnits.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                f120766b[g.gradientTransform.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                f120766b[g.spreadMethod.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                f120766b[g.fx.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                f120766b[g.fy.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                f120766b[g.offset.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                f120766b[g.clipPathUnits.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                f120766b[g.startOffset.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                f120766b[g.patternUnits.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                f120766b[g.patternContentUnits.ordinal()] = 41;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                f120766b[g.patternTransform.ordinal()] = 42;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                f120766b[g.maskUnits.ordinal()] = 43;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                f120766b[g.maskContentUnits.ordinal()] = 44;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                f120766b[g.style.ordinal()] = 45;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                f120766b[g.CLASS.ordinal()] = 46;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                f120766b[g.fill.ordinal()] = 47;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                f120766b[g.fill_rule.ordinal()] = 48;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                f120766b[g.fill_opacity.ordinal()] = 49;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                f120766b[g.stroke.ordinal()] = 50;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                f120766b[g.stroke_opacity.ordinal()] = 51;
            } catch (NoSuchFieldError unused51) {
            }
            try {
                f120766b[g.stroke_width.ordinal()] = 52;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                f120766b[g.stroke_linecap.ordinal()] = 53;
            } catch (NoSuchFieldError unused53) {
            }
            try {
                f120766b[g.stroke_linejoin.ordinal()] = 54;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                f120766b[g.stroke_miterlimit.ordinal()] = 55;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                f120766b[g.stroke_dasharray.ordinal()] = 56;
            } catch (NoSuchFieldError unused56) {
            }
            try {
                f120766b[g.stroke_dashoffset.ordinal()] = 57;
            } catch (NoSuchFieldError unused57) {
            }
            try {
                f120766b[g.opacity.ordinal()] = 58;
            } catch (NoSuchFieldError unused58) {
            }
            try {
                f120766b[g.color.ordinal()] = 59;
            } catch (NoSuchFieldError unused59) {
            }
            try {
                f120766b[g.font.ordinal()] = 60;
            } catch (NoSuchFieldError unused60) {
            }
            try {
                f120766b[g.font_family.ordinal()] = 61;
            } catch (NoSuchFieldError unused61) {
            }
            try {
                f120766b[g.font_size.ordinal()] = 62;
            } catch (NoSuchFieldError unused62) {
            }
            try {
                f120766b[g.font_weight.ordinal()] = 63;
            } catch (NoSuchFieldError unused63) {
            }
            try {
                f120766b[g.font_style.ordinal()] = 64;
            } catch (NoSuchFieldError unused64) {
            }
            try {
                f120766b[g.text_decoration.ordinal()] = 65;
            } catch (NoSuchFieldError unused65) {
            }
            try {
                f120766b[g.direction.ordinal()] = 66;
            } catch (NoSuchFieldError unused66) {
            }
            try {
                f120766b[g.text_anchor.ordinal()] = 67;
            } catch (NoSuchFieldError unused67) {
            }
            try {
                f120766b[g.overflow.ordinal()] = 68;
            } catch (NoSuchFieldError unused68) {
            }
            try {
                f120766b[g.marker.ordinal()] = 69;
            } catch (NoSuchFieldError unused69) {
            }
            try {
                f120766b[g.marker_start.ordinal()] = 70;
            } catch (NoSuchFieldError unused70) {
            }
            try {
                f120766b[g.marker_mid.ordinal()] = 71;
            } catch (NoSuchFieldError unused71) {
            }
            try {
                f120766b[g.marker_end.ordinal()] = 72;
            } catch (NoSuchFieldError unused72) {
            }
            try {
                f120766b[g.display.ordinal()] = 73;
            } catch (NoSuchFieldError unused73) {
            }
            try {
                f120766b[g.visibility.ordinal()] = 74;
            } catch (NoSuchFieldError unused74) {
            }
            try {
                f120766b[g.stop_color.ordinal()] = 75;
            } catch (NoSuchFieldError unused75) {
            }
            try {
                f120766b[g.stop_opacity.ordinal()] = 76;
            } catch (NoSuchFieldError unused76) {
            }
            try {
                f120766b[g.clip.ordinal()] = 77;
            } catch (NoSuchFieldError unused77) {
            }
            try {
                f120766b[g.clip_path.ordinal()] = 78;
            } catch (NoSuchFieldError unused78) {
            }
            try {
                f120766b[g.clip_rule.ordinal()] = 79;
            } catch (NoSuchFieldError unused79) {
            }
            try {
                f120766b[g.mask.ordinal()] = 80;
            } catch (NoSuchFieldError unused80) {
            }
            try {
                f120766b[g.solid_color.ordinal()] = 81;
            } catch (NoSuchFieldError unused81) {
            }
            try {
                f120766b[g.solid_opacity.ordinal()] = 82;
            } catch (NoSuchFieldError unused82) {
            }
            try {
                f120766b[g.viewport_fill.ordinal()] = 83;
            } catch (NoSuchFieldError unused83) {
            }
            try {
                f120766b[g.viewport_fill_opacity.ordinal()] = 84;
            } catch (NoSuchFieldError unused84) {
            }
            try {
                f120766b[g.vector_effect.ordinal()] = 85;
            } catch (NoSuchFieldError unused85) {
            }
            try {
                f120766b[g.image_rendering.ordinal()] = 86;
            } catch (NoSuchFieldError unused86) {
            }
            try {
                f120766b[g.viewBox.ordinal()] = 87;
            } catch (NoSuchFieldError unused87) {
            }
            try {
                f120766b[g.type.ordinal()] = 88;
            } catch (NoSuchFieldError unused88) {
            }
            try {
                f120766b[g.media.ordinal()] = 89;
            } catch (NoSuchFieldError unused89) {
            }
            int[] iArr2 = new int[h.values().length];
            f120765a = iArr2;
            try {
                iArr2[h.svg.ordinal()] = 1;
            } catch (NoSuchFieldError unused90) {
            }
            try {
                f120765a[h.g.ordinal()] = 2;
            } catch (NoSuchFieldError unused91) {
            }
            try {
                f120765a[h.defs.ordinal()] = 3;
            } catch (NoSuchFieldError unused92) {
            }
            try {
                f120765a[h.a.ordinal()] = 4;
            } catch (NoSuchFieldError unused93) {
            }
            try {
                f120765a[h.use.ordinal()] = 5;
            } catch (NoSuchFieldError unused94) {
            }
            try {
                f120765a[h.path.ordinal()] = 6;
            } catch (NoSuchFieldError unused95) {
            }
            try {
                f120765a[h.rect.ordinal()] = 7;
            } catch (NoSuchFieldError unused96) {
            }
            try {
                f120765a[h.circle.ordinal()] = 8;
            } catch (NoSuchFieldError unused97) {
            }
            try {
                f120765a[h.ellipse.ordinal()] = 9;
            } catch (NoSuchFieldError unused98) {
            }
            try {
                f120765a[h.line.ordinal()] = 10;
            } catch (NoSuchFieldError unused99) {
            }
            try {
                f120765a[h.polyline.ordinal()] = 11;
            } catch (NoSuchFieldError unused100) {
            }
            try {
                f120765a[h.polygon.ordinal()] = 12;
            } catch (NoSuchFieldError unused101) {
            }
            try {
                f120765a[h.text.ordinal()] = 13;
            } catch (NoSuchFieldError unused102) {
            }
            try {
                f120765a[h.tspan.ordinal()] = 14;
            } catch (NoSuchFieldError unused103) {
            }
            try {
                f120765a[h.tref.ordinal()] = 15;
            } catch (NoSuchFieldError unused104) {
            }
            try {
                f120765a[h.SWITCH.ordinal()] = 16;
            } catch (NoSuchFieldError unused105) {
            }
            try {
                f120765a[h.symbol.ordinal()] = 17;
            } catch (NoSuchFieldError unused106) {
            }
            try {
                f120765a[h.marker.ordinal()] = 18;
            } catch (NoSuchFieldError unused107) {
            }
            try {
                f120765a[h.linearGradient.ordinal()] = 19;
            } catch (NoSuchFieldError unused108) {
            }
            try {
                f120765a[h.radialGradient.ordinal()] = 20;
            } catch (NoSuchFieldError unused109) {
            }
            try {
                f120765a[h.stop.ordinal()] = 21;
            } catch (NoSuchFieldError unused110) {
            }
            try {
                f120765a[h.title.ordinal()] = 22;
            } catch (NoSuchFieldError unused111) {
            }
            try {
                f120765a[h.desc.ordinal()] = 23;
            } catch (NoSuchFieldError unused112) {
            }
            try {
                f120765a[h.clipPath.ordinal()] = 24;
            } catch (NoSuchFieldError unused113) {
            }
            try {
                f120765a[h.textPath.ordinal()] = 25;
            } catch (NoSuchFieldError unused114) {
            }
            try {
                f120765a[h.pattern.ordinal()] = 26;
            } catch (NoSuchFieldError unused115) {
            }
            try {
                f120765a[h.image.ordinal()] = 27;
            } catch (NoSuchFieldError unused116) {
            }
            try {
                f120765a[h.view.ordinal()] = 28;
            } catch (NoSuchFieldError unused117) {
            }
            try {
                f120765a[h.mask.ordinal()] = 29;
            } catch (NoSuchFieldError unused118) {
            }
            try {
                f120765a[h.style.ordinal()] = 30;
            } catch (NoSuchFieldError unused119) {
            }
            try {
                f120765a[h.solidColor.ordinal()] = 31;
            } catch (NoSuchFieldError unused120) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final Map f120767a;

        static {
            HashMap hashMap = new HashMap(10);
            f120767a = hashMap;
            hashMap.put("none", f.a.none);
            hashMap.put("xMinYMin", f.a.xMinYMin);
            hashMap.put("xMidYMin", f.a.xMidYMin);
            hashMap.put("xMaxYMin", f.a.xMaxYMin);
            hashMap.put("xMinYMid", f.a.xMinYMid);
            hashMap.put("xMidYMid", f.a.xMidYMid);
            hashMap.put("xMaxYMid", f.a.xMaxYMid);
            hashMap.put("xMinYMax", f.a.xMinYMax);
            hashMap.put("xMidYMax", f.a.xMidYMax);
            hashMap.put("xMaxYMax", f.a.xMaxYMax);
        }

        public static f.a a(String str) {
            return (f.a) f120767a.get(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public static final Map f120768a;

        static {
            HashMap hashMap = new HashMap(47);
            f120768a = hashMap;
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
            hashMap.put("darkgrey", -5658199);
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
            hashMap.put("green", -16744448);
            hashMap.put("greenyellow", -5374161);
            hashMap.put("grey", -8355712);
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
            hashMap.put("lightgreen", -7278960);
            hashMap.put("lightgrey", -2894893);
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

        public static Integer a(String str) {
            return (Integer) f120768a.get(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public static final Map f120769a;

        static {
            HashMap hashMap = new HashMap(9);
            f120769a = hashMap;
            h.e1 e1Var = h.e1.pt;
            hashMap.put("xx-small", new h.q(0.694f, e1Var));
            hashMap.put("x-small", new h.q(0.833f, e1Var));
            hashMap.put(NtFaceConstant.SMALL, new h.q(10.0f, e1Var));
            hashMap.put("medium", new h.q(12.0f, e1Var));
            hashMap.put(NtFaceConstant.LARGE, new h.q(14.4f, e1Var));
            hashMap.put("x-large", new h.q(17.3f, e1Var));
            hashMap.put("xx-large", new h.q(20.7f, e1Var));
            h.e1 e1Var2 = h.e1.percent;
            hashMap.put("smaller", new h.q(83.33f, e1Var2));
            hashMap.put("larger", new h.q(120.0f, e1Var2));
        }

        public static h.q a(String str) {
            return (h.q) f120769a.get(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public static final Map f120770a;

        static {
            HashMap hashMap = new HashMap(13);
            f120770a = hashMap;
            hashMap.put("normal", 400);
            hashMap.put("bold", 700);
            hashMap.put("bolder", 1);
            hashMap.put(PTSNodeTextBase.WEIGHT_LIGHTER, -1);
            hashMap.put("100", 100);
            hashMap.put("200", 200);
            hashMap.put(IndividuationPlugin.Business_Font, 300);
            hashMap.put(IndividuationPlugin.Business_Pendant, 400);
            hashMap.put("500", 500);
            hashMap.put(IndividuationPlugin.Business_Theme, 600);
            hashMap.put(IndividuationPlugin.Business_Profilecard, 700);
            hashMap.put(IndividuationPlugin.Business_Suit, 800);
            hashMap.put("900", 900);
        }

        public static Integer a(String str) {
            return (Integer) f120770a.get(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f extends DefaultHandler2 {
        public f() {
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i3, int i16) {
            l.this.H(new String(cArr, i3, i16));
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endDocument() {
            l.this.a();
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) {
            l.this.a(str, str2, str3);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void processingInstruction(String str, String str2) {
            l.this.a(str, l.this.b(new i(str2)));
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startDocument() {
            l.this.b();
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) {
            l.this.a(str, str2, str3, attributes);
        }

        public /* synthetic */ f(l lVar, a aVar) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum g {
        CLASS,
        clip,
        clip_path,
        clipPathUnits,
        clip_rule,
        color,
        cx,
        cy,
        direction,
        dx,
        dy,
        fx,
        fy,
        d,
        display,
        fill,
        fill_rule,
        fill_opacity,
        font,
        font_family,
        font_size,
        font_weight,
        font_style,
        gradientTransform,
        gradientUnits,
        height,
        href,
        image_rendering,
        marker,
        marker_start,
        marker_mid,
        marker_end,
        markerHeight,
        markerUnits,
        markerWidth,
        mask,
        maskContentUnits,
        maskUnits,
        media,
        offset,
        opacity,
        orient,
        overflow,
        pathLength,
        patternContentUnits,
        patternTransform,
        patternUnits,
        points,
        preserveAspectRatio,
        r,
        refX,
        refY,
        requiredFeatures,
        requiredExtensions,
        requiredFormats,
        requiredFonts,
        rx,
        ry,
        solid_color,
        solid_opacity,
        spreadMethod,
        startOffset,
        stop_color,
        stop_opacity,
        stroke,
        stroke_dasharray,
        stroke_dashoffset,
        stroke_linecap,
        stroke_linejoin,
        stroke_miterlimit,
        stroke_opacity,
        stroke_width,
        style,
        systemLanguage,
        text_anchor,
        text_decoration,
        transform,
        type,
        vector_effect,
        version,
        viewBox,
        width,
        x,
        y,
        x1,
        y1,
        x2,
        y2,
        viewport_fill,
        viewport_fill_opacity,
        visibility,
        UNSUPPORTED;


        /* renamed from: d1, reason: collision with root package name */
        public static final Map f120783d1 = new HashMap();

        static {
            for (g gVar : values()) {
                if (gVar == CLASS) {
                    f120783d1.put(Constants.Service.CLASS, gVar);
                } else if (gVar != UNSUPPORTED) {
                    f120783d1.put(gVar.name().replace(util.base64_pad_url, '-'), gVar);
                }
            }
        }

        public static g a(String str) {
            g gVar = (g) f120783d1.get(str);
            return gVar != null ? gVar : UNSUPPORTED;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum h {
        svg,
        a,
        circle,
        clipPath,
        defs,
        desc,
        ellipse,
        g,
        image,
        line,
        linearGradient,
        marker,
        mask,
        path,
        pattern,
        polygon,
        polyline,
        radialGradient,
        rect,
        solidColor,
        stop,
        style,
        SWITCH,
        symbol,
        text,
        textPath,
        title,
        tref,
        tspan,
        use,
        view,
        UNSUPPORTED;

        public static final Map V = new HashMap();

        static {
            for (h hVar : values()) {
                if (hVar == SWITCH) {
                    V.put(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, hVar);
                } else if (hVar != UNSUPPORTED) {
                    V.put(hVar.name(), hVar);
                }
            }
        }

        public static h a(String str) {
            h hVar = (h) V.get(str);
            return hVar != null ? hVar : UNSUPPORTED;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        public String f120829a;

        /* renamed from: c, reason: collision with root package name */
        public int f120831c;

        /* renamed from: b, reason: collision with root package name */
        public int f120830b = 0;

        /* renamed from: d, reason: collision with root package name */
        public com.tencent.luggage.wxa.a.e f120832d = new com.tencent.luggage.wxa.a.e();

        public i(String str) {
            this.f120831c = 0;
            String trim = str.trim();
            this.f120829a = trim;
            this.f120831c = trim.length();
        }

        public boolean a(int i3) {
            return i3 == 10 || i3 == 13;
        }

        public boolean b(int i3) {
            return i3 == 32 || i3 == 10 || i3 == 13 || i3 == 9;
        }

        public boolean c() {
            return this.f120830b == this.f120831c;
        }

        public boolean d() {
            int i3 = this.f120830b;
            if (i3 == this.f120831c) {
                return false;
            }
            char charAt = this.f120829a.charAt(i3);
            if ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z')) {
                return false;
            }
            return true;
        }

        public Integer e() {
            int i3 = this.f120830b;
            if (i3 == this.f120831c) {
                return null;
            }
            String str = this.f120829a;
            this.f120830b = i3 + 1;
            return Integer.valueOf(str.charAt(i3));
        }

        public Boolean f() {
            int i3 = this.f120830b;
            if (i3 == this.f120831c) {
                return null;
            }
            char charAt = this.f120829a.charAt(i3);
            if (charAt != '0' && charAt != '1') {
                return null;
            }
            boolean z16 = true;
            this.f120830b++;
            if (charAt != '1') {
                z16 = false;
            }
            return Boolean.valueOf(z16);
        }

        public float g() {
            float a16 = this.f120832d.a(this.f120829a, this.f120830b, this.f120831c);
            if (!Float.isNaN(a16)) {
                this.f120830b = this.f120832d.a();
            }
            return a16;
        }

        public String h() {
            if (c()) {
                return null;
            }
            int i3 = this.f120830b;
            int charAt = this.f120829a.charAt(i3);
            while (true) {
                if ((charAt < 97 || charAt > 122) && (charAt < 65 || charAt > 90)) {
                    break;
                }
                charAt = a();
            }
            int i16 = this.f120830b;
            while (b(charAt)) {
                charAt = a();
            }
            if (charAt == 40) {
                this.f120830b++;
                return this.f120829a.substring(i3, i16);
            }
            this.f120830b = i3;
            return null;
        }

        public h.q i() {
            float g16 = g();
            if (Float.isNaN(g16)) {
                return null;
            }
            h.e1 l3 = l();
            if (l3 == null) {
                return new h.q(g16, h.e1.px);
            }
            return new h.q(g16, l3);
        }

        public String j() {
            if (c()) {
                return null;
            }
            int i3 = this.f120830b;
            char charAt = this.f120829a.charAt(i3);
            if (charAt != '\'' && charAt != '\"') {
                return null;
            }
            int a16 = a();
            while (a16 != -1 && a16 != charAt) {
                a16 = a();
            }
            if (a16 == -1) {
                this.f120830b = i3;
                return null;
            }
            int i16 = this.f120830b + 1;
            this.f120830b = i16;
            return this.f120829a.substring(i3 + 1, i16 - 1);
        }

        public String k() {
            return a(TokenParser.SP, false);
        }

        public h.e1 l() {
            if (c()) {
                return null;
            }
            if (this.f120829a.charAt(this.f120830b) == '%') {
                this.f120830b++;
                return h.e1.percent;
            }
            int i3 = this.f120830b;
            if (i3 > this.f120831c - 2) {
                return null;
            }
            try {
                h.e1 valueOf = h.e1.valueOf(this.f120829a.substring(i3, i3 + 2).toLowerCase(Locale.US));
                this.f120830b += 2;
                return valueOf;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public String m() {
            if (c()) {
                return null;
            }
            int i3 = this.f120830b;
            char charAt = this.f120829a.charAt(i3);
            if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
                int a16 = a();
                while (true) {
                    if ((a16 < 65 || a16 > 90) && (a16 < 97 || a16 > 122)) {
                        break;
                    }
                    a16 = a();
                }
                return this.f120829a.substring(i3, this.f120830b);
            }
            this.f120830b = i3;
            return null;
        }

        public float n() {
            p();
            float a16 = this.f120832d.a(this.f120829a, this.f120830b, this.f120831c);
            if (!Float.isNaN(a16)) {
                this.f120830b = this.f120832d.a();
            }
            return a16;
        }

        public String o() {
            if (c()) {
                return null;
            }
            int i3 = this.f120830b;
            this.f120830b = this.f120831c;
            return this.f120829a.substring(i3);
        }

        public boolean p() {
            q();
            int i3 = this.f120830b;
            if (i3 == this.f120831c || this.f120829a.charAt(i3) != ',') {
                return false;
            }
            this.f120830b++;
            q();
            return true;
        }

        public void q() {
            while (true) {
                int i3 = this.f120830b;
                if (i3 < this.f120831c && b((int) this.f120829a.charAt(i3))) {
                    this.f120830b++;
                } else {
                    return;
                }
            }
        }

        public float a(float f16) {
            if (Float.isNaN(f16)) {
                return Float.NaN;
            }
            p();
            return g();
        }

        public String b(char c16) {
            return a(c16, false);
        }

        public String c(char c16) {
            return a(c16, true);
        }

        public String b() {
            int i3 = this.f120830b;
            while (!c() && !b((int) this.f120829a.charAt(this.f120830b))) {
                this.f120830b++;
            }
            String substring = this.f120829a.substring(i3, this.f120830b);
            this.f120830b = i3;
            return substring;
        }

        public float a(Boolean bool) {
            if (bool == null) {
                return Float.NaN;
            }
            p();
            return g();
        }

        public Boolean a(Object obj) {
            if (obj == null) {
                return null;
            }
            p();
            return f();
        }

        public boolean a(char c16) {
            int i3 = this.f120830b;
            boolean z16 = i3 < this.f120831c && this.f120829a.charAt(i3) == c16;
            if (z16) {
                this.f120830b++;
            }
            return z16;
        }

        public boolean a(String str) {
            int length = str.length();
            int i3 = this.f120830b;
            boolean z16 = i3 <= this.f120831c - length && this.f120829a.substring(i3, i3 + length).equals(str);
            if (z16) {
                this.f120830b += length;
            }
            return z16;
        }

        public int a() {
            int i3 = this.f120830b;
            int i16 = this.f120831c;
            if (i3 == i16) {
                return -1;
            }
            int i17 = i3 + 1;
            this.f120830b = i17;
            if (i17 < i16) {
                return this.f120829a.charAt(i17);
            }
            return -1;
        }

        public String a(char c16, boolean z16) {
            if (c()) {
                return null;
            }
            char charAt = this.f120829a.charAt(this.f120830b);
            if ((!z16 && b((int) charAt)) || charAt == c16) {
                return null;
            }
            int i3 = this.f120830b;
            int a16 = a();
            while (a16 != -1 && a16 != c16 && (z16 || !b(a16))) {
                a16 = a();
            }
            return this.f120829a.substring(i3, this.f120830b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class j implements Attributes {

        /* renamed from: a, reason: collision with root package name */
        public XmlPullParser f120833a;

        public j(XmlPullParser xmlPullParser) {
            this.f120833a = xmlPullParser;
        }

        @Override // org.xml.sax.Attributes
        public int getIndex(String str) {
            return -1;
        }

        @Override // org.xml.sax.Attributes
        public int getLength() {
            return this.f120833a.getAttributeCount();
        }

        @Override // org.xml.sax.Attributes
        public String getLocalName(int i3) {
            return this.f120833a.getAttributeName(i3);
        }

        @Override // org.xml.sax.Attributes
        public String getQName(int i3) {
            String attributeName = this.f120833a.getAttributeName(i3);
            if (this.f120833a.getAttributePrefix(i3) != null) {
                return this.f120833a.getAttributePrefix(i3) + ':' + attributeName;
            }
            return attributeName;
        }

        @Override // org.xml.sax.Attributes
        public String getType(int i3) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getURI(int i3) {
            return this.f120833a.getAttributeNamespace(i3);
        }

        @Override // org.xml.sax.Attributes
        public String getValue(String str) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public int getIndex(String str, String str2) {
            return -1;
        }

        @Override // org.xml.sax.Attributes
        public String getType(String str) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getValue(String str, String str2) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getType(String str, String str2) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getValue(int i3) {
            return this.f120833a.getAttributeValue(i3);
        }
    }

    public static h.f0.EnumC5978h D(String str) {
        str.hashCode();
        if (!str.equals("ltr")) {
            if (!str.equals("rtl")) {
                return null;
            }
            return h.f0.EnumC5978h.RTL;
        }
        return h.f0.EnumC5978h.LTR;
    }

    public static h.f0.i F(String str) {
        str.hashCode();
        if (!str.equals("none")) {
            if (!str.equals("non-scaling-stroke")) {
                return null;
            }
            return h.f0.i.NonScalingStroke;
        }
        return h.f0.i.None;
    }

    public static h.c G(String str) {
        i iVar = new i(str);
        iVar.q();
        float g16 = iVar.g();
        iVar.p();
        float g17 = iVar.g();
        iVar.p();
        float g18 = iVar.g();
        iVar.p();
        float g19 = iVar.g();
        if (!Float.isNaN(g16) && !Float.isNaN(g17) && !Float.isNaN(g18) && !Float.isNaN(g19)) {
            if (g18 >= 0.0f) {
                if (g19 >= 0.0f) {
                    return new h.c(g16, g17, g18, g19);
                }
                throw new k("Invalid viewBox. height cannot be negative");
            }
            throw new k("Invalid viewBox. width cannot be negative");
        }
        throw new k("Invalid viewBox definition - should have four numbers");
    }

    public static float b(float f16, float f17, float f18) {
        float f19;
        if (f18 < 0.0f) {
            f18 += 6.0f;
        }
        if (f18 >= 6.0f) {
            f18 -= 6.0f;
        }
        if (f18 < 1.0f) {
            f19 = (f17 - f16) * f18;
        } else {
            if (f18 < 3.0f) {
                return f17;
            }
            if (f18 >= 4.0f) {
                return f16;
            }
            f19 = (f17 - f16) * (4.0f - f18);
        }
        return f19 + f16;
    }

    public static com.tencent.luggage.wxa.a.f t(String str) {
        f.b bVar;
        i iVar = new i(str);
        iVar.q();
        String k3 = iVar.k();
        if ("defer".equals(k3)) {
            iVar.q();
            k3 = iVar.k();
        }
        f.a a16 = b.a(k3);
        iVar.q();
        if (iVar.c()) {
            bVar = null;
        } else {
            String k16 = iVar.k();
            k16.hashCode();
            if (k16.equals("meet")) {
                bVar = f.b.meet;
            } else if (k16.equals("slice")) {
                bVar = f.b.slice;
            } else {
                throw new k("Invalid preserveAspectRatio definition: " + str);
            }
        }
        return new com.tencent.luggage.wxa.a.f(a16, bVar);
    }

    public final void A(Attributes attributes) {
        a("<use>", new Object[0]);
        if (this.f120757b != null) {
            h.f1 f1Var = new h.f1();
            f1Var.f120648a = this.f120756a;
            f1Var.f120649b = this.f120757b;
            a((h.m0) f1Var, attributes);
            b(f1Var, attributes);
            a((h.o) f1Var, attributes);
            a((h.h0) f1Var, attributes);
            a(f1Var, attributes);
            this.f120757b.a(f1Var);
            this.f120757b = f1Var;
            return;
        }
        throw new k("Invalid document. Root element must be <svg>");
    }

    public final void B(Attributes attributes) {
        a("<view>", new Object[0]);
        if (this.f120757b != null) {
            h.s0 g1Var = new h.g1();
            g1Var.f120648a = this.f120756a;
            g1Var.f120649b = this.f120757b;
            a((h.m0) g1Var, attributes);
            a((h.h0) g1Var, attributes);
            a(g1Var, attributes);
            this.f120757b.a(g1Var);
            this.f120757b = g1Var;
            return;
        }
        throw new k("Invalid document. Root element must be <svg>");
    }

    public final void C(Attributes attributes) {
        a("<switch>", new Object[0]);
        if (this.f120757b != null) {
            h.t0 t0Var = new h.t0();
            t0Var.f120648a = this.f120756a;
            t0Var.f120649b = this.f120757b;
            a((h.m0) t0Var, attributes);
            b(t0Var, attributes);
            a((h.o) t0Var, attributes);
            a((h.h0) t0Var, attributes);
            this.f120757b.a(t0Var);
            this.f120757b = t0Var;
            return;
        }
        throw new k("Invalid document. Root element must be <svg>");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0026. Please report as an issue. */
    public final Matrix E(String str) {
        Matrix matrix = new Matrix();
        i iVar = new i(str);
        iVar.q();
        while (!iVar.c()) {
            String h16 = iVar.h();
            if (h16 != null) {
                char c16 = '\uffff';
                switch (h16.hashCode()) {
                    case -1081239615:
                        if (h16.equals("matrix")) {
                            c16 = 0;
                            break;
                        }
                        break;
                    case -925180581:
                        if (h16.equals(CanvasView.ACTION_ROTATE)) {
                            c16 = 1;
                            break;
                        }
                        break;
                    case 109250890:
                        if (h16.equals("scale")) {
                            c16 = 2;
                            break;
                        }
                        break;
                    case 109493390:
                        if (h16.equals("skewX")) {
                            c16 = 3;
                            break;
                        }
                        break;
                    case 109493391:
                        if (h16.equals("skewY")) {
                            c16 = 4;
                            break;
                        }
                        break;
                    case 1052832078:
                        if (h16.equals(CanvasView.ACTION_TRANSLATE)) {
                            c16 = 5;
                            break;
                        }
                        break;
                }
                switch (c16) {
                    case 0:
                        iVar.q();
                        float g16 = iVar.g();
                        iVar.p();
                        float g17 = iVar.g();
                        iVar.p();
                        float g18 = iVar.g();
                        iVar.p();
                        float g19 = iVar.g();
                        iVar.p();
                        float g26 = iVar.g();
                        iVar.p();
                        float g27 = iVar.g();
                        iVar.q();
                        if (!Float.isNaN(g27) && iVar.a(')')) {
                            Matrix matrix2 = new Matrix();
                            matrix2.setValues(new float[]{g16, g18, g26, g17, g19, g27, 0.0f, 0.0f, 1.0f});
                            matrix.preConcat(matrix2);
                            break;
                        } else {
                            throw new k("Invalid transform list: " + str);
                        }
                    case 1:
                        iVar.q();
                        float g28 = iVar.g();
                        float n3 = iVar.n();
                        float n16 = iVar.n();
                        iVar.q();
                        if (!Float.isNaN(g28) && iVar.a(')')) {
                            if (Float.isNaN(n3)) {
                                matrix.preRotate(g28);
                                break;
                            } else if (!Float.isNaN(n16)) {
                                matrix.preRotate(g28, n3, n16);
                                break;
                            } else {
                                throw new k("Invalid transform list: " + str);
                            }
                        } else {
                            throw new k("Invalid transform list: " + str);
                        }
                        break;
                    case 2:
                        iVar.q();
                        float g29 = iVar.g();
                        float n17 = iVar.n();
                        iVar.q();
                        if (!Float.isNaN(g29) && iVar.a(')')) {
                            if (Float.isNaN(n17)) {
                                matrix.preScale(g29, g29);
                                break;
                            } else {
                                matrix.preScale(g29, n17);
                                break;
                            }
                        } else {
                            throw new k("Invalid transform list: " + str);
                        }
                    case 3:
                        iVar.q();
                        float g36 = iVar.g();
                        iVar.q();
                        if (!Float.isNaN(g36) && iVar.a(')')) {
                            matrix.preSkew((float) Math.tan(Math.toRadians(g36)), 0.0f);
                            break;
                        } else {
                            throw new k("Invalid transform list: " + str);
                        }
                    case 4:
                        iVar.q();
                        float g37 = iVar.g();
                        iVar.q();
                        if (!Float.isNaN(g37) && iVar.a(')')) {
                            matrix.preSkew(0.0f, (float) Math.tan(Math.toRadians(g37)));
                            break;
                        } else {
                            throw new k("Invalid transform list: " + str);
                        }
                        break;
                    case 5:
                        iVar.q();
                        float g38 = iVar.g();
                        float n18 = iVar.n();
                        iVar.q();
                        if (!Float.isNaN(g38) && iVar.a(')')) {
                            if (Float.isNaN(n18)) {
                                matrix.preTranslate(g38, 0.0f);
                                break;
                            } else {
                                matrix.preTranslate(g38, n18);
                                break;
                            }
                        } else {
                            throw new k("Invalid transform list: " + str);
                        }
                        break;
                    default:
                        throw new k("Invalid transform list fn: " + h16 + ")");
                }
                if (!iVar.c()) {
                    iVar.p();
                } else {
                    return matrix;
                }
            } else {
                throw new k("Bad transform function encountered in transform list: " + str);
            }
        }
        return matrix;
    }

    public final void H(String str) {
        if (this.f120758c) {
            return;
        }
        if (this.f120760e) {
            if (this.f120762g == null) {
                this.f120762g = new StringBuilder(str.length());
            }
            this.f120762g.append(str);
        } else if (this.f120763h) {
            if (this.f120764i == null) {
                this.f120764i = new StringBuilder(str.length());
            }
            this.f120764i.append(str);
        } else if (this.f120757b instanceof h.z0) {
            a(str);
        }
    }

    public final void a() {
    }

    public final void c(Attributes attributes) {
        a("<clipPath>", new Object[0]);
        if (this.f120757b != null) {
            h.f fVar = new h.f();
            fVar.f120648a = this.f120756a;
            fVar.f120649b = this.f120757b;
            a((h.m0) fVar, attributes);
            b(fVar, attributes);
            a((h.o) fVar, attributes);
            a((h.h0) fVar, attributes);
            a(fVar, attributes);
            this.f120757b.a(fVar);
            this.f120757b = fVar;
            return;
        }
        throw new k("Invalid document. Root element must be <svg>");
    }

    public final void d(Attributes attributes) {
        a("<defs>", new Object[0]);
        if (this.f120757b != null) {
            h.i iVar = new h.i();
            iVar.f120648a = this.f120756a;
            iVar.f120649b = this.f120757b;
            a((h.m0) iVar, attributes);
            b(iVar, attributes);
            a((h.o) iVar, attributes);
            this.f120757b.a(iVar);
            this.f120757b = iVar;
            return;
        }
        throw new k("Invalid document. Root element must be <svg>");
    }

    public final void e(Attributes attributes) {
        a("<ellipse>", new Object[0]);
        if (this.f120757b != null) {
            h.j jVar = new h.j();
            jVar.f120648a = this.f120756a;
            jVar.f120649b = this.f120757b;
            a((h.m0) jVar, attributes);
            b(jVar, attributes);
            a((h.o) jVar, attributes);
            a((h.h0) jVar, attributes);
            a(jVar, attributes);
            this.f120757b.a(jVar);
            return;
        }
        throw new k("Invalid document. Root element must be <svg>");
    }

    public final void f(Attributes attributes) {
        a("<g>", new Object[0]);
        if (this.f120757b != null) {
            h.n nVar = new h.n();
            nVar.f120648a = this.f120756a;
            nVar.f120649b = this.f120757b;
            a((h.m0) nVar, attributes);
            b(nVar, attributes);
            a((h.o) nVar, attributes);
            a((h.h0) nVar, attributes);
            this.f120757b.a(nVar);
            this.f120757b = nVar;
            return;
        }
        throw new k("Invalid document. Root element must be <svg>");
    }

    public final void g(Attributes attributes) {
        a("<image>", new Object[0]);
        if (this.f120757b != null) {
            h.p pVar = new h.p();
            pVar.f120648a = this.f120756a;
            pVar.f120649b = this.f120757b;
            a((h.m0) pVar, attributes);
            b(pVar, attributes);
            a((h.o) pVar, attributes);
            a((h.h0) pVar, attributes);
            a(pVar, attributes);
            this.f120757b.a(pVar);
            this.f120757b = pVar;
            return;
        }
        throw new k("Invalid document. Root element must be <svg>");
    }

    public final void h(Attributes attributes) {
        a("<line>", new Object[0]);
        if (this.f120757b != null) {
            h.r rVar = new h.r();
            rVar.f120648a = this.f120756a;
            rVar.f120649b = this.f120757b;
            a((h.m0) rVar, attributes);
            b(rVar, attributes);
            a((h.o) rVar, attributes);
            a((h.h0) rVar, attributes);
            a(rVar, attributes);
            this.f120757b.a(rVar);
            return;
        }
        throw new k("Invalid document. Root element must be <svg>");
    }

    public final void i(Attributes attributes) {
        a("<linearGradient>", new Object[0]);
        if (this.f120757b != null) {
            h.n0 n0Var = new h.n0();
            n0Var.f120648a = this.f120756a;
            n0Var.f120649b = this.f120757b;
            a((h.m0) n0Var, attributes);
            b(n0Var, attributes);
            a((h.k) n0Var, attributes);
            a(n0Var, attributes);
            this.f120757b.a(n0Var);
            this.f120757b = n0Var;
            return;
        }
        throw new k("Invalid document. Root element must be <svg>");
    }

    public final void j(Attributes attributes) {
        a("<marker>", new Object[0]);
        if (this.f120757b != null) {
            h.s sVar = new h.s();
            sVar.f120648a = this.f120756a;
            sVar.f120649b = this.f120757b;
            a((h.m0) sVar, attributes);
            b(sVar, attributes);
            a((h.h0) sVar, attributes);
            a((h.s0) sVar, attributes);
            a(sVar, attributes);
            this.f120757b.a(sVar);
            this.f120757b = sVar;
            return;
        }
        throw new k("Invalid document. Root element must be <svg>");
    }

    public final void k(Attributes attributes) {
        a("<mask>", new Object[0]);
        if (this.f120757b != null) {
            h.t tVar = new h.t();
            tVar.f120648a = this.f120756a;
            tVar.f120649b = this.f120757b;
            a((h.m0) tVar, attributes);
            b(tVar, attributes);
            a((h.h0) tVar, attributes);
            a(tVar, attributes);
            this.f120757b.a(tVar);
            this.f120757b = tVar;
            return;
        }
        throw new k("Invalid document. Root element must be <svg>");
    }

    public final void l(Attributes attributes) {
        a("<path>", new Object[0]);
        if (this.f120757b != null) {
            h.w wVar = new h.w();
            wVar.f120648a = this.f120756a;
            wVar.f120649b = this.f120757b;
            a((h.m0) wVar, attributes);
            b(wVar, attributes);
            a((h.o) wVar, attributes);
            a((h.h0) wVar, attributes);
            a(wVar, attributes);
            this.f120757b.a(wVar);
            return;
        }
        throw new k("Invalid document. Root element must be <svg>");
    }

    public final Float m(String str) {
        if (str.length() != 0) {
            int length = str.length();
            boolean z16 = true;
            if (str.charAt(str.length() - 1) == '%') {
                length--;
            } else {
                z16 = false;
            }
            try {
                float a16 = a(str, 0, length);
                float f16 = 100.0f;
                if (z16) {
                    a16 /= 100.0f;
                }
                if (a16 < 0.0f) {
                    f16 = 0.0f;
                } else if (a16 <= 100.0f) {
                    f16 = a16;
                }
                return Float.valueOf(f16);
            } catch (NumberFormatException e16) {
                throw new k("Invalid offset value in <stop>: " + str, e16);
            }
        }
        throw new k("Invalid offset value in <stop> (empty string)");
    }

    public final void n(Attributes attributes) {
        a("<polygon>", new Object[0]);
        if (this.f120757b != null) {
            h.a0 b0Var = new h.b0();
            b0Var.f120648a = this.f120756a;
            b0Var.f120649b = this.f120757b;
            a((h.m0) b0Var, attributes);
            b(b0Var, attributes);
            a((h.o) b0Var, attributes);
            a((h.h0) b0Var, attributes);
            a(b0Var, attributes, "polygon");
            this.f120757b.a(b0Var);
            return;
        }
        throw new k("Invalid document. Root element must be <svg>");
    }

    public final void o(Attributes attributes) {
        a("<polyline>", new Object[0]);
        if (this.f120757b != null) {
            h.a0 a0Var = new h.a0();
            a0Var.f120648a = this.f120756a;
            a0Var.f120649b = this.f120757b;
            a((h.m0) a0Var, attributes);
            b(a0Var, attributes);
            a((h.o) a0Var, attributes);
            a((h.h0) a0Var, attributes);
            a(a0Var, attributes, "polyline");
            this.f120757b.a(a0Var);
            return;
        }
        throw new k("Invalid document. Root element must be <svg>");
    }

    public final void p(Attributes attributes) {
        a("<radialGradient>", new Object[0]);
        if (this.f120757b != null) {
            h.r0 r0Var = new h.r0();
            r0Var.f120648a = this.f120756a;
            r0Var.f120649b = this.f120757b;
            a((h.m0) r0Var, attributes);
            b(r0Var, attributes);
            a((h.k) r0Var, attributes);
            a(r0Var, attributes);
            this.f120757b.a(r0Var);
            this.f120757b = r0Var;
            return;
        }
        throw new k("Invalid document. Root element must be <svg>");
    }

    public final void q(Attributes attributes) {
        a("<rect>", new Object[0]);
        if (this.f120757b != null) {
            h.c0 c0Var = new h.c0();
            c0Var.f120648a = this.f120756a;
            c0Var.f120649b = this.f120757b;
            a((h.m0) c0Var, attributes);
            b(c0Var, attributes);
            a((h.o) c0Var, attributes);
            a((h.h0) c0Var, attributes);
            a(c0Var, attributes);
            this.f120757b.a(c0Var);
            return;
        }
        throw new k("Invalid document. Root element must be <svg>");
    }

    public final void r(Attributes attributes) {
        a("<solidColor>", new Object[0]);
        if (this.f120757b != null) {
            h.d0 d0Var = new h.d0();
            d0Var.f120648a = this.f120756a;
            d0Var.f120649b = this.f120757b;
            a(d0Var, attributes);
            b(d0Var, attributes);
            this.f120757b.a(d0Var);
            this.f120757b = d0Var;
            return;
        }
        throw new k("Invalid document. Root element must be <svg>");
    }

    public final void s(Attributes attributes) {
        a("<stop>", new Object[0]);
        h.k0 k0Var = this.f120757b;
        if (k0Var != null) {
            if (k0Var instanceof h.k) {
                h.e0 e0Var = new h.e0();
                e0Var.f120648a = this.f120756a;
                e0Var.f120649b = this.f120757b;
                a((h.m0) e0Var, attributes);
                b(e0Var, attributes);
                a(e0Var, attributes);
                this.f120757b.a(e0Var);
                this.f120757b = e0Var;
                return;
            }
            throw new k("Invalid document. <stop> elements are only valid inside <linearGradient> or <radialGradient> elements.");
        }
        throw new k("Invalid document. Root element must be <svg>");
    }

    public final void u(Attributes attributes) {
        a("<svg>", new Object[0]);
        h.g0 g0Var = new h.g0();
        g0Var.f120648a = this.f120756a;
        g0Var.f120649b = this.f120757b;
        a((h.m0) g0Var, attributes);
        b(g0Var, attributes);
        a((h.h0) g0Var, attributes);
        a((h.s0) g0Var, attributes);
        a(g0Var, attributes);
        h.k0 k0Var = this.f120757b;
        if (k0Var == null) {
            this.f120756a.a(g0Var);
        } else {
            k0Var.a(g0Var);
        }
        this.f120757b = g0Var;
    }

    public final void v(Attributes attributes) {
        a("<symbol>", new Object[0]);
        if (this.f120757b != null) {
            h.s0 u0Var = new h.u0();
            u0Var.f120648a = this.f120756a;
            u0Var.f120649b = this.f120757b;
            a((h.m0) u0Var, attributes);
            b(u0Var, attributes);
            a((h.h0) u0Var, attributes);
            a(u0Var, attributes);
            this.f120757b.a(u0Var);
            this.f120757b = u0Var;
            return;
        }
        throw new k("Invalid document. Root element must be <svg>");
    }

    public final void w(Attributes attributes) {
        a("<text>", new Object[0]);
        if (this.f120757b != null) {
            h.x0 x0Var = new h.x0();
            x0Var.f120648a = this.f120756a;
            x0Var.f120649b = this.f120757b;
            a((h.m0) x0Var, attributes);
            b(x0Var, attributes);
            a((h.o) x0Var, attributes);
            a((h.h0) x0Var, attributes);
            a((h.b1) x0Var, attributes);
            this.f120757b.a(x0Var);
            this.f120757b = x0Var;
            return;
        }
        throw new k("Invalid document. Root element must be <svg>");
    }

    public final void x(Attributes attributes) {
        a("<textPath>", new Object[0]);
        if (this.f120757b != null) {
            h.a1 a1Var = new h.a1();
            a1Var.f120648a = this.f120756a;
            a1Var.f120649b = this.f120757b;
            a((h.m0) a1Var, attributes);
            b(a1Var, attributes);
            a((h.h0) a1Var, attributes);
            a(a1Var, attributes);
            this.f120757b.a(a1Var);
            this.f120757b = a1Var;
            h.k0 k0Var = a1Var.f120649b;
            if (k0Var instanceof h.c1) {
                a1Var.a((h.c1) k0Var);
                return;
            } else {
                a1Var.a(((h.y0) k0Var).c());
                return;
            }
        }
        throw new k("Invalid document. Root element must be <svg>");
    }

    public final void y(Attributes attributes) {
        a("<tref>", new Object[0]);
        h.k0 k0Var = this.f120757b;
        if (k0Var != null) {
            if (k0Var instanceof h.z0) {
                h.v0 v0Var = new h.v0();
                v0Var.f120648a = this.f120756a;
                v0Var.f120649b = this.f120757b;
                a((h.m0) v0Var, attributes);
                b(v0Var, attributes);
                a((h.h0) v0Var, attributes);
                a(v0Var, attributes);
                this.f120757b.a(v0Var);
                h.k0 k0Var2 = v0Var.f120649b;
                if (k0Var2 instanceof h.c1) {
                    v0Var.a((h.c1) k0Var2);
                    return;
                } else {
                    v0Var.a(((h.y0) k0Var2).c());
                    return;
                }
            }
            throw new k("Invalid document. <tref> elements are only valid inside <text> or <tspan> elements.");
        }
        throw new k("Invalid document. Root element must be <svg>");
    }

    public final void z(Attributes attributes) {
        a("<tspan>", new Object[0]);
        h.k0 k0Var = this.f120757b;
        if (k0Var != null) {
            if (k0Var instanceof h.z0) {
                h.w0 w0Var = new h.w0();
                w0Var.f120648a = this.f120756a;
                w0Var.f120649b = this.f120757b;
                a((h.m0) w0Var, attributes);
                b(w0Var, attributes);
                a((h.h0) w0Var, attributes);
                a((h.b1) w0Var, attributes);
                this.f120757b.a(w0Var);
                this.f120757b = w0Var;
                h.k0 k0Var2 = w0Var.f120649b;
                if (k0Var2 instanceof h.c1) {
                    w0Var.a((h.c1) k0Var2);
                    return;
                } else {
                    w0Var.a(((h.y0) k0Var2).c());
                    return;
                }
            }
            throw new k("Invalid document. <tspan> elements are only valid inside <text> or other <tspan> elements.");
        }
        throw new k("Invalid document. Root element must be <svg>");
    }

    public final void a(String str, Object... objArr) {
    }

    public final void b(InputStream inputStream) {
        try {
            XmlPullParser newPullParser = Xml.newPullParser();
            j jVar = new j(newPullParser);
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-docdecl", false);
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
            newPullParser.setInput(inputStream, null);
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.nextToken()) {
                if (eventType == 0) {
                    b();
                } else if (eventType == 8) {
                    i iVar = new i(newPullParser.getText());
                    a(iVar.k(), b(iVar));
                } else if (eventType == 2) {
                    String name = newPullParser.getName();
                    if (newPullParser.getPrefix() != null) {
                        name = newPullParser.getPrefix() + ':' + name;
                    }
                    a(newPullParser.getNamespace(), newPullParser.getName(), name, jVar);
                } else if (eventType == 3) {
                    String name2 = newPullParser.getName();
                    if (newPullParser.getPrefix() != null) {
                        name2 = newPullParser.getPrefix() + ':' + name2;
                    }
                    a(newPullParser.getNamespace(), newPullParser.getName(), name2);
                } else if (eventType == 4) {
                    int[] iArr = new int[2];
                    a(newPullParser.getTextCharacters(iArr), iArr[0], iArr[1]);
                } else if (eventType == 5) {
                    H(newPullParser.getText());
                }
            }
            a();
        } catch (IOException e16) {
            throw new k("Stream error", e16);
        } catch (XmlPullParserException e17) {
            throw new k("XML parser problem", e17);
        }
    }

    public final void m(Attributes attributes) {
        a("<pattern>", new Object[0]);
        if (this.f120757b != null) {
            h.z zVar = new h.z();
            zVar.f120648a = this.f120756a;
            zVar.f120649b = this.f120757b;
            a((h.m0) zVar, attributes);
            b(zVar, attributes);
            a((h.h0) zVar, attributes);
            a((h.s0) zVar, attributes);
            a(zVar, attributes);
            this.f120757b.a(zVar);
            this.f120757b = zVar;
            return;
        }
        throw new k("Invalid document. Root element must be <svg>");
    }

    public com.tencent.luggage.wxa.a.h a(InputStream inputStream, boolean z16) {
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStream(inputStream);
        }
        try {
            inputStream.mark(3);
            int read = inputStream.read() + (inputStream.read() << 8);
            inputStream.reset();
            if (read == 35615) {
                inputStream = new BufferedInputStream(new GZIPInputStream(inputStream));
            }
        } catch (IOException unused) {
        }
        try {
            if (z16) {
                try {
                    inputStream.mark(4096);
                    byte[] bArr = new byte[4096];
                    String str = new String(bArr, 0, inputStream.read(bArr));
                    inputStream.reset();
                    if (str.indexOf("<!ENTITY ") >= 0) {
                        Log.d("SVGParser", "Switching to SAX parser to process entities");
                        a(inputStream);
                        com.tencent.luggage.wxa.a.h hVar = this.f120756a;
                        try {
                            inputStream.close();
                        } catch (IOException unused2) {
                            Log.e("SVGParser", "Exception thrown closing input stream");
                        }
                        return hVar;
                    }
                } catch (IOException e16) {
                    Log.e("SVGParser", "Error occurred while performing check for entities.  File may not be parsed correctly if it contains entity definitions.", e16);
                    b(inputStream);
                    com.tencent.luggage.wxa.a.h hVar2 = this.f120756a;
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                        Log.e("SVGParser", "Exception thrown closing input stream");
                    }
                    return hVar2;
                }
            }
            b(inputStream);
            com.tencent.luggage.wxa.a.h hVar3 = this.f120756a;
            try {
                inputStream.close();
            } catch (IOException unused4) {
                Log.e("SVGParser", "Exception thrown closing input stream");
            }
            return hVar3;
        } catch (Throwable th5) {
            try {
                inputStream.close();
            } catch (IOException unused5) {
                Log.e("SVGParser", "Exception thrown closing input stream");
            }
            throw th5;
        }
    }

    public static h.p0 r(String str) {
        if (str.startsWith("url(")) {
            int indexOf = str.indexOf(")");
            if (indexOf != -1) {
                String trim = str.substring(4, indexOf).trim();
                String trim2 = str.substring(indexOf + 1).trim();
                return new h.v(trim, trim2.length() > 0 ? f(trim2) : null);
            }
            return new h.v(str.substring(4).trim(), null);
        }
        return f(str);
    }

    public static h.f0.f B(String str) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1074341483:
                if (str.equals("middle")) {
                    c16 = 0;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    c16 = 1;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c16 = 2;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return h.f0.f.Middle;
            case 1:
                return h.f0.f.End;
            case 2:
                return h.f0.f.Start;
            default:
                return null;
        }
    }

    public static h.g d(String str) {
        if (str.charAt(0) == '#') {
            com.tencent.luggage.wxa.a.d a16 = com.tencent.luggage.wxa.a.d.a(str, 1, str.length());
            if (a16 != null) {
                int a17 = a16.a();
                if (a17 == 4) {
                    int b16 = a16.b();
                    int i3 = b16 & 3840;
                    int i16 = b16 & 240;
                    int i17 = b16 & 15;
                    return new h.g(i17 | (i3 << 8) | (-16777216) | (i3 << 12) | (i16 << 8) | (i16 << 4) | (i17 << 4));
                }
                if (a17 == 5) {
                    int b17 = a16.b();
                    int i18 = 61440 & b17;
                    int i19 = b17 & 3840;
                    int i26 = b17 & 240;
                    int i27 = b17 & 15;
                    return new h.g((i27 << 24) | (i27 << 28) | (i18 << 8) | (i18 << 4) | (i19 << 4) | i19 | i26 | (i26 >> 4));
                }
                if (a17 == 7) {
                    return new h.g(a16.b() | (-16777216));
                }
                if (a17 == 9) {
                    return new h.g((a16.b() >>> 8) | (a16.b() << 24));
                }
                throw new k("Bad hex colour value: " + str);
            }
            throw new k("Bad hex colour value: " + str);
        }
        String lowerCase = str.toLowerCase(Locale.US);
        boolean startsWith = lowerCase.startsWith("rgba(");
        if (!startsWith && !lowerCase.startsWith("rgb(")) {
            boolean startsWith2 = lowerCase.startsWith("hsla(");
            if (!startsWith2 && !lowerCase.startsWith("hsl(")) {
                return e(lowerCase);
            }
            i iVar = new i(str.substring(startsWith2 ? 5 : 4));
            iVar.q();
            float g16 = iVar.g();
            float a18 = iVar.a(g16);
            if (!Float.isNaN(a18)) {
                iVar.a('%');
            }
            float a19 = iVar.a(a18);
            if (!Float.isNaN(a19)) {
                iVar.a('%');
            }
            if (startsWith2) {
                float a26 = iVar.a(a19);
                iVar.q();
                if (!Float.isNaN(a26) && iVar.a(')')) {
                    return new h.g((a(a26 * 256.0f) << 24) | a(g16, a18, a19));
                }
                throw new k("Bad hsla() colour value: " + str);
            }
            iVar.q();
            if (!Float.isNaN(a19) && iVar.a(')')) {
                return new h.g(a(g16, a18, a19) | (-16777216));
            }
            throw new k("Bad hsl() colour value: " + str);
        }
        i iVar2 = new i(str.substring(startsWith ? 5 : 4));
        iVar2.q();
        float g17 = iVar2.g();
        if (!Float.isNaN(g17) && iVar2.a('%')) {
            g17 = (g17 * 256.0f) / 100.0f;
        }
        float a27 = iVar2.a(g17);
        if (!Float.isNaN(a27) && iVar2.a('%')) {
            a27 = (a27 * 256.0f) / 100.0f;
        }
        float a28 = iVar2.a(a27);
        if (!Float.isNaN(a28) && iVar2.a('%')) {
            a28 = (a28 * 256.0f) / 100.0f;
        }
        if (startsWith) {
            float a29 = iVar2.a(a28);
            iVar2.q();
            if (!Float.isNaN(a29) && iVar2.a(')')) {
                return new h.g((a(a29 * 256.0f) << 24) | (a(g17) << 16) | (a(a27) << 8) | a(a28));
            }
            throw new k("Bad rgba() colour value: " + str);
        }
        iVar2.q();
        if (!Float.isNaN(a28) && iVar2.a(')')) {
            return new h.g((a(g17) << 16) | (-16777216) | (a(a27) << 8) | a(a28));
        }
        throw new k("Bad rgb() colour value: " + str);
    }

    public static h.f0.g C(String str) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1171789332:
                if (str.equals(PTSNodeTextBase.TEXT_DECORATION_LINE_THROUGH)) {
                    c16 = 0;
                    break;
                }
                break;
            case -1026963764:
                if (str.equals("underline")) {
                    c16 = 1;
                    break;
                }
                break;
            case 3387192:
                if (str.equals("none")) {
                    c16 = 2;
                    break;
                }
                break;
            case 93826908:
                if (str.equals("blink")) {
                    c16 = 3;
                    break;
                }
                break;
            case 529818312:
                if (str.equals("overline")) {
                    c16 = 4;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return h.f0.g.LineThrough;
            case 1:
                return h.f0.g.Underline;
            case 2:
                return h.f0.g.None;
            case 3:
                return h.f0.g.Blink;
            case 4:
                return h.f0.g.Overline;
            default:
                return null;
        }
    }

    public static h.g e(String str) {
        Integer a16 = c.a(str);
        if (a16 != null) {
            return new h.g(a16.intValue());
        }
        throw new k("Invalid colour keyword: " + str);
    }

    public static h.p0 f(String str) {
        str.hashCode();
        if (str.equals("none")) {
            return h.g.f120604c;
        }
        if (!str.equals("currentColor")) {
            try {
                return d(str);
            } catch (k unused) {
                return null;
            }
        }
        return h.C5979h.a();
    }

    public static float h(String str) {
        int length = str.length();
        if (length != 0) {
            return a(str, 0, length);
        }
        throw new k("Invalid float value (empty string)");
    }

    public static List i(String str) {
        i iVar = new i(str);
        ArrayList arrayList = null;
        do {
            String j3 = iVar.j();
            if (j3 == null) {
                j3 = iVar.c(',');
            }
            if (j3 == null) {
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(j3);
            iVar.p();
        } while (!iVar.c());
        return arrayList;
    }

    public static h.f0.b k(String str) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1657669071:
                if (str.equals("oblique")) {
                    c16 = 0;
                    break;
                }
                break;
            case -1178781136:
                if (str.equals("italic")) {
                    c16 = 1;
                    break;
                }
                break;
            case -1039745817:
                if (str.equals("normal")) {
                    c16 = 2;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return h.f0.b.Oblique;
            case 1:
                return h.f0.b.Italic;
            case 2:
                return h.f0.b.Normal;
            default:
                return null;
        }
    }

    public static Integer l(String str) {
        return e.a(str);
    }

    public static h.q n(String str) {
        if (str.length() != 0) {
            int length = str.length();
            h.e1 e1Var = h.e1.px;
            char charAt = str.charAt(length - 1);
            if (charAt == '%') {
                length--;
                e1Var = h.e1.percent;
            } else if (length > 2 && Character.isLetter(charAt) && Character.isLetter(str.charAt(length - 2))) {
                length -= 2;
                try {
                    e1Var = h.e1.valueOf(str.substring(length).toLowerCase(Locale.US));
                } catch (IllegalArgumentException unused) {
                    throw new k("Invalid length unit specifier: " + str);
                }
            }
            try {
                return new h.q(a(str, 0, length), e1Var);
            } catch (NumberFormatException e16) {
                throw new k("Invalid length value: " + str, e16);
            }
        }
        throw new k("Invalid length value (empty string)");
    }

    public static List o(String str) {
        if (str.length() != 0) {
            ArrayList arrayList = new ArrayList(1);
            i iVar = new i(str);
            iVar.q();
            while (!iVar.c()) {
                float g16 = iVar.g();
                if (!Float.isNaN(g16)) {
                    h.e1 l3 = iVar.l();
                    if (l3 == null) {
                        l3 = h.e1.px;
                    }
                    arrayList.add(new h.q(g16, l3));
                    iVar.p();
                } else {
                    throw new k("Invalid length list value: " + iVar.b());
                }
            }
            return arrayList;
        }
        throw new k("Invalid length list (empty string)");
    }

    public static Float p(String str) {
        try {
            float h16 = h(str);
            float f16 = 0.0f;
            if (h16 >= 0.0f) {
                f16 = 1.0f;
                if (h16 > 1.0f) {
                }
                return Float.valueOf(h16);
            }
            h16 = f16;
            return Float.valueOf(h16);
        } catch (k unused) {
            return null;
        }
    }

    public static Boolean q(String str) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1217487446:
                if (str.equals("hidden")) {
                    c16 = 0;
                    break;
                }
                break;
            case -907680051:
                if (str.equals("scroll")) {
                    c16 = 1;
                    break;
                }
                break;
            case 3005871:
                if (str.equals("auto")) {
                    c16 = 2;
                    break;
                }
                break;
            case 466743410:
                if (str.equals(NodeProps.VISIBLE)) {
                    c16 = 3;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
            case 1:
                return Boolean.FALSE;
            case 2:
            case 3:
                return Boolean.TRUE;
            default:
                return null;
        }
    }

    public static Set v(String str) {
        i iVar = new i(str);
        HashSet hashSet = new HashSet();
        while (!iVar.c()) {
            String k3 = iVar.k();
            if (k3.startsWith("http://www.w3.org/TR/SVG11/feature#")) {
                hashSet.add(k3.substring(35));
            } else {
                hashSet.add("UNSUPPORTED");
            }
            iVar.q();
        }
        return hashSet;
    }

    public static Set A(String str) {
        i iVar = new i(str);
        HashSet hashSet = new HashSet();
        while (!iVar.c()) {
            String k3 = iVar.k();
            int indexOf = k3.indexOf(45);
            if (indexOf != -1) {
                k3 = k3.substring(0, indexOf);
            }
            hashSet.add(new Locale(k3, "", "").getLanguage());
            iVar.q();
        }
        return hashSet;
    }

    public static h.d c(String str) {
        if ("auto".equals(str) || !str.startsWith("rect(")) {
            return null;
        }
        i iVar = new i(str.substring(5));
        iVar.q();
        h.q a16 = a(iVar);
        iVar.p();
        h.q a17 = a(iVar);
        iVar.p();
        h.q a18 = a(iVar);
        iVar.p();
        h.q a19 = a(iVar);
        iVar.q();
        if (iVar.a(')') || iVar.c()) {
            return new h.d(a16, a17, a18, a19);
        }
        return null;
    }

    public static h.f0.a g(String str) {
        if ("nonzero".equals(str)) {
            return h.f0.a.NonZero;
        }
        if ("evenodd".equals(str)) {
            return h.f0.a.EvenOdd;
        }
        return null;
    }

    public static h.q j(String str) {
        try {
            h.q a16 = d.a(str);
            return a16 == null ? n(str) : a16;
        } catch (k unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:114:0x02a9, code lost:
    
        return r9;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x003b. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0280 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static h.x s(String str) {
        float a16;
        float a17;
        float f16;
        float f17;
        i iVar = new i(str);
        h.x xVar = new h.x();
        if (iVar.c()) {
            return xVar;
        }
        int intValue = iVar.e().intValue();
        int i3 = 109;
        if (intValue != 77 && intValue != 109) {
            return xVar;
        }
        int i16 = intValue;
        float f18 = 0.0f;
        float f19 = 0.0f;
        float f26 = 0.0f;
        float f27 = 0.0f;
        float f28 = 0.0f;
        float f29 = 0.0f;
        while (true) {
            iVar.q();
            switch (i16) {
                case 65:
                case 97:
                    float g16 = iVar.g();
                    float a18 = iVar.a(g16);
                    float a19 = iVar.a(a18);
                    Boolean a26 = iVar.a(Float.valueOf(a19));
                    Boolean a27 = iVar.a((Object) a26);
                    float a28 = iVar.a(a27);
                    float a29 = iVar.a(a28);
                    if (!Float.isNaN(a29) && g16 >= 0.0f && a18 >= 0.0f) {
                        if (i16 == 97) {
                            a28 += f19;
                            a29 += f18;
                        }
                        xVar.a(g16, a18, a19, a26.booleanValue(), a27.booleanValue(), a28, a29);
                        f19 = a28;
                        f26 = f19;
                        f18 = a29;
                        f27 = f18;
                        iVar.p();
                        if (!iVar.c()) {
                            return xVar;
                        }
                        if (iVar.d()) {
                            i16 = iVar.e().intValue();
                        }
                        i3 = 109;
                    }
                    break;
                case 67:
                case 99:
                    float g17 = iVar.g();
                    float a36 = iVar.a(g17);
                    float a37 = iVar.a(a36);
                    float a38 = iVar.a(a37);
                    a16 = iVar.a(a38);
                    a17 = iVar.a(a16);
                    if (Float.isNaN(a17)) {
                        Log.e("SVGParser", "Bad path coords for " + ((char) i16) + " path segment");
                        return xVar;
                    }
                    if (i16 == 99) {
                        a16 += f19;
                        a17 += f18;
                        g17 += f19;
                        a36 += f18;
                        a37 += f19;
                        a38 += f18;
                    }
                    f16 = a37;
                    f17 = a38;
                    xVar.a(g17, a36, f16, f17, a16, a17);
                    f26 = f16;
                    f19 = a16;
                    f27 = f17;
                    f18 = a17;
                    iVar.p();
                    if (!iVar.c()) {
                    }
                    break;
                case 72:
                case 104:
                    float g18 = iVar.g();
                    if (Float.isNaN(g18)) {
                        Log.e("SVGParser", "Bad path coords for " + ((char) i16) + " path segment");
                        return xVar;
                    }
                    if (i16 == 104) {
                        g18 += f19;
                    }
                    f19 = g18;
                    xVar.b(f19, f18);
                    f26 = f19;
                    iVar.p();
                    if (!iVar.c()) {
                    }
                    break;
                case 76:
                case 108:
                    float g19 = iVar.g();
                    float a39 = iVar.a(g19);
                    if (Float.isNaN(a39)) {
                        Log.e("SVGParser", "Bad path coords for " + ((char) i16) + " path segment");
                        return xVar;
                    }
                    if (i16 == 108) {
                        g19 += f19;
                        a39 += f18;
                    }
                    f19 = g19;
                    f18 = a39;
                    xVar.b(f19, f18);
                    f27 = f18;
                    f26 = f19;
                    iVar.p();
                    if (!iVar.c()) {
                    }
                    break;
                case 77:
                case 109:
                    float g26 = iVar.g();
                    float a46 = iVar.a(g26);
                    if (Float.isNaN(a46)) {
                        Log.e("SVGParser", "Bad path coords for " + ((char) i16) + " path segment");
                        return xVar;
                    }
                    if (i16 == i3 && !xVar.a()) {
                        g26 += f19;
                        a46 += f18;
                    }
                    f19 = g26;
                    f18 = a46;
                    xVar.a(f19, f18);
                    f27 = f18;
                    f29 = f27;
                    f26 = f19;
                    f28 = f26;
                    i16 = i16 != i3 ? 76 : 108;
                    iVar.p();
                    if (!iVar.c()) {
                    }
                    break;
                case 81:
                case 113:
                    f26 = iVar.g();
                    f27 = iVar.a(f26);
                    float a47 = iVar.a(f27);
                    float a48 = iVar.a(a47);
                    if (Float.isNaN(a48)) {
                        Log.e("SVGParser", "Bad path coords for " + ((char) i16) + " path segment");
                        return xVar;
                    }
                    if (i16 == 113) {
                        a47 += f19;
                        a48 += f18;
                        f26 += f19;
                        f27 += f18;
                    }
                    f19 = a47;
                    f18 = a48;
                    xVar.a(f26, f27, f19, f18);
                    iVar.p();
                    if (!iVar.c()) {
                    }
                    break;
                case 83:
                case 115:
                    float f36 = (f19 * 2.0f) - f26;
                    float f37 = (2.0f * f18) - f27;
                    float g27 = iVar.g();
                    float a49 = iVar.a(g27);
                    a16 = iVar.a(a49);
                    a17 = iVar.a(a16);
                    if (Float.isNaN(a17)) {
                        Log.e("SVGParser", "Bad path coords for " + ((char) i16) + " path segment");
                        return xVar;
                    }
                    if (i16 == 115) {
                        a16 += f19;
                        a17 += f18;
                        g27 += f19;
                        a49 += f18;
                    }
                    f16 = g27;
                    f17 = a49;
                    xVar.a(f36, f37, f16, f17, a16, a17);
                    f26 = f16;
                    f19 = a16;
                    f27 = f17;
                    f18 = a17;
                    iVar.p();
                    if (!iVar.c()) {
                    }
                    break;
                case 84:
                case 116:
                    f26 = (f19 * 2.0f) - f26;
                    f27 = (2.0f * f18) - f27;
                    float g28 = iVar.g();
                    float a56 = iVar.a(g28);
                    if (Float.isNaN(a56)) {
                        Log.e("SVGParser", "Bad path coords for " + ((char) i16) + " path segment");
                        return xVar;
                    }
                    if (i16 == 116) {
                        g28 += f19;
                        a56 += f18;
                    }
                    f19 = g28;
                    f18 = a56;
                    xVar.a(f26, f27, f19, f18);
                    iVar.p();
                    if (!iVar.c()) {
                    }
                    break;
                case 86:
                case 118:
                    float g29 = iVar.g();
                    if (Float.isNaN(g29)) {
                        Log.e("SVGParser", "Bad path coords for " + ((char) i16) + " path segment");
                        return xVar;
                    }
                    if (i16 == 118) {
                        g29 += f18;
                    }
                    f18 = g29;
                    xVar.b(f19, f18);
                    f27 = f18;
                    iVar.p();
                    if (!iVar.c()) {
                    }
                    break;
                case 90:
                case 122:
                    xVar.close();
                    f19 = f28;
                    f26 = f19;
                    f18 = f29;
                    f27 = f18;
                    iVar.p();
                    if (!iVar.c()) {
                    }
                    break;
                default:
                    return xVar;
            }
        }
    }

    public static h.f0.e u(String str) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -933002398:
                if (str.equals("optimizeQuality")) {
                    c16 = 0;
                    break;
                }
                break;
            case 3005871:
                if (str.equals("auto")) {
                    c16 = 1;
                    break;
                }
                break;
            case 362741610:
                if (str.equals("optimizeSpeed")) {
                    c16 = 2;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return h.f0.e.optimizeQuality;
            case 1:
                return h.f0.e.auto;
            case 2:
                return h.f0.e.optimizeSpeed;
            default:
                return null;
        }
    }

    public static Set w(String str) {
        i iVar = new i(str);
        HashSet hashSet = new HashSet();
        while (!iVar.c()) {
            hashSet.add(iVar.k());
            iVar.q();
        }
        return hashSet;
    }

    public static h.q[] x(String str) {
        h.q i3;
        i iVar = new i(str);
        iVar.q();
        if (iVar.c() || (i3 = iVar.i()) == null || i3.b()) {
            return null;
        }
        float a16 = i3.a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(i3);
        while (!iVar.c()) {
            iVar.p();
            h.q i16 = iVar.i();
            if (i16 == null || i16.b()) {
                return null;
            }
            arrayList.add(i16);
            a16 += i16.a();
        }
        if (a16 == 0.0f) {
            return null;
        }
        return (h.q[]) arrayList.toArray(new h.q[arrayList.size()]);
    }

    public final void t(Attributes attributes) {
        a("<style>", new Object[0]);
        if (this.f120757b != null) {
            String str = "all";
            boolean z16 = true;
            for (int i3 = 0; i3 < attributes.getLength(); i3++) {
                String trim = attributes.getValue(i3).trim();
                int i16 = a.f120766b[g.a(attributes.getLocalName(i3)).ordinal()];
                if (i16 == 88) {
                    z16 = trim.equals("text/css");
                } else if (i16 == 89) {
                    str = trim;
                }
            }
            if (z16 && com.tencent.luggage.wxa.a.b.a(str, b.f.screen)) {
                this.f120763h = true;
                return;
            } else {
                this.f120758c = true;
                this.f120759d = 1;
                return;
            }
        }
        throw new k("Invalid document. Root element must be <svg>");
    }

    public static h.f0.c y(String str) {
        if ("butt".equals(str)) {
            return h.f0.c.Butt;
        }
        if ("round".equals(str)) {
            return h.f0.c.Round;
        }
        if ("square".equals(str)) {
            return h.f0.c.Square;
        }
        return null;
    }

    public static h.f0.d z(String str) {
        if ("miter".equals(str)) {
            return h.f0.d.Miter;
        }
        if ("round".equals(str)) {
            return h.f0.d.Round;
        }
        if ("bevel".equals(str)) {
            return h.f0.d.Bevel;
        }
        return null;
    }

    public final void b() {
        this.f120756a = new com.tencent.luggage.wxa.a.h();
    }

    public final Map b(i iVar) {
        HashMap hashMap = new HashMap();
        iVar.q();
        String b16 = iVar.b('=');
        while (b16 != null) {
            iVar.a('=');
            hashMap.put(b16, iVar.j());
            iVar.q();
            b16 = iVar.b('=');
        }
        return hashMap;
    }

    public final void a(InputStream inputStream) {
        try {
            SAXParserFactory newInstance = SAXParserFactory.newInstance();
            newInstance.setFeature("http://xml.org/sax/features/external-general-entities", false);
            newInstance.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            XMLReader xMLReader = newInstance.newSAXParser().getXMLReader();
            f fVar = new f(this, null);
            xMLReader.setContentHandler(fVar);
            xMLReader.setProperty("http://xml.org/sax/properties/lexical-handler", fVar);
            xMLReader.parse(new InputSource(inputStream));
        } catch (IOException e16) {
            throw new k("Stream error", e16);
        } catch (ParserConfigurationException e17) {
            throw new k("XML parser problem", e17);
        } catch (SAXException e18) {
            throw new k("SVG parse error", e18);
        }
    }

    public final void b(Attributes attributes) {
        a("<circle>", new Object[0]);
        if (this.f120757b != null) {
            h.e eVar = new h.e();
            eVar.f120648a = this.f120756a;
            eVar.f120649b = this.f120757b;
            a((h.m0) eVar, attributes);
            b(eVar, attributes);
            a((h.o) eVar, attributes);
            a((h.h0) eVar, attributes);
            a(eVar, attributes);
            this.f120757b.a(eVar);
            return;
        }
        throw new k("Invalid document. Root element must be <svg>");
    }

    public final void a(String str, String str2, String str3, Attributes attributes) {
        if (this.f120758c) {
            this.f120759d++;
            return;
        }
        if ("http://www.w3.org/2000/svg".equals(str) || "".equals(str)) {
            if (str2.length() <= 0) {
                str2 = str3;
            }
            h a16 = h.a(str2);
            switch (a.f120765a[a16.ordinal()]) {
                case 1:
                    u(attributes);
                    return;
                case 2:
                    f(attributes);
                    return;
                case 3:
                    d(attributes);
                    return;
                case 4:
                    a(attributes);
                    return;
                case 5:
                    A(attributes);
                    return;
                case 6:
                    l(attributes);
                    return;
                case 7:
                    q(attributes);
                    return;
                case 8:
                    b(attributes);
                    return;
                case 9:
                    e(attributes);
                    return;
                case 10:
                    h(attributes);
                    return;
                case 11:
                    o(attributes);
                    return;
                case 12:
                    n(attributes);
                    return;
                case 13:
                    w(attributes);
                    return;
                case 14:
                    z(attributes);
                    return;
                case 15:
                    y(attributes);
                    return;
                case 16:
                    C(attributes);
                    return;
                case 17:
                    v(attributes);
                    return;
                case 18:
                    j(attributes);
                    return;
                case 19:
                    i(attributes);
                    return;
                case 20:
                    p(attributes);
                    return;
                case 21:
                    s(attributes);
                    return;
                case 22:
                case 23:
                    this.f120760e = true;
                    this.f120761f = a16;
                    return;
                case 24:
                    c(attributes);
                    return;
                case 25:
                    x(attributes);
                    return;
                case 26:
                    m(attributes);
                    return;
                case 27:
                    g(attributes);
                    return;
                case 28:
                    B(attributes);
                    return;
                case 29:
                    k(attributes);
                    return;
                case 30:
                    t(attributes);
                    return;
                case 31:
                    r(attributes);
                    return;
                default:
                    this.f120758c = true;
                    this.f120759d = 1;
                    return;
            }
        }
    }

    public final void b(h.m0 m0Var, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            if (trim.length() != 0) {
                int i16 = a.f120766b[g.a(attributes.getLocalName(i3)).ordinal()];
                if (i16 == 45) {
                    a(m0Var, trim);
                } else if (i16 != 46) {
                    if (m0Var.f120640e == null) {
                        m0Var.f120640e = new h.f0();
                    }
                    a(m0Var.f120640e, attributes.getLocalName(i3), attributes.getValue(i3).trim());
                } else {
                    m0Var.f120642g = com.tencent.luggage.wxa.a.b.b(trim);
                }
            }
        }
    }

    public final void b(String str) {
        this.f120756a.a(new com.tencent.luggage.wxa.a.b(b.f.screen, b.u.Document).a(str));
    }

    public final void a(char[] cArr, int i3, int i16) {
        if (this.f120758c) {
            return;
        }
        if (this.f120760e) {
            if (this.f120762g == null) {
                this.f120762g = new StringBuilder(i16);
            }
            this.f120762g.append(cArr, i3, i16);
        } else if (this.f120763h) {
            if (this.f120764i == null) {
                this.f120764i = new StringBuilder(i16);
            }
            this.f120764i.append(cArr, i3, i16);
        } else if (this.f120757b instanceof h.z0) {
            a(new String(cArr, i3, i16));
        }
    }

    public final void a(String str) {
        h.i0 i0Var = (h.i0) this.f120757b;
        int size = i0Var.f120612i.size();
        h.o0 o0Var = size == 0 ? null : (h.o0) i0Var.f120612i.get(size - 1);
        if (o0Var instanceof h.d1) {
            StringBuilder sb5 = new StringBuilder();
            h.d1 d1Var = (h.d1) o0Var;
            sb5.append(d1Var.f120531c);
            sb5.append(str);
            d1Var.f120531c = sb5.toString();
            return;
        }
        this.f120757b.a(new h.d1(str));
    }

    public final void a(String str, String str2, String str3) {
        if (this.f120758c) {
            int i3 = this.f120759d - 1;
            this.f120759d = i3;
            if (i3 == 0) {
                this.f120758c = false;
                return;
            }
            return;
        }
        if ("http://www.w3.org/2000/svg".equals(str) || "".equals(str)) {
            if (str2.length() <= 0) {
                str2 = str3;
            }
            int i16 = a.f120765a[h.a(str2).ordinal()];
            if (i16 != 13 && i16 != 14 && i16 != 1 && i16 != 2 && i16 != 3 && i16 != 4 && i16 != 5) {
                switch (i16) {
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 31:
                        break;
                    case 22:
                    case 23:
                        this.f120760e = false;
                        StringBuilder sb5 = this.f120762g;
                        if (sb5 != null) {
                            h hVar = this.f120761f;
                            if (hVar == h.title) {
                                this.f120756a.e(sb5.toString());
                            } else if (hVar == h.desc) {
                                this.f120756a.d(sb5.toString());
                            }
                            this.f120762g.setLength(0);
                            return;
                        }
                        return;
                    case 30:
                        StringBuilder sb6 = this.f120764i;
                        if (sb6 != null) {
                            this.f120763h = false;
                            b(sb6.toString());
                            this.f120764i.setLength(0);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
            Object obj = this.f120757b;
            if (obj != null) {
                this.f120757b = ((h.o0) obj).f120649b;
                return;
            }
            throw new k(String.format("Unbalanced end element </%s> found", str2));
        }
    }

    public final void a(String str, Map map) {
        if (str.equals("xml-stylesheet")) {
            com.tencent.luggage.wxa.a.h.e();
        }
    }

    public final void a(h.g0 g0Var, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            int i16 = a.f120766b[g.a(attributes.getLocalName(i3)).ordinal()];
            if (i16 == 1) {
                g0Var.f120606q = n(trim);
            } else if (i16 == 2) {
                g0Var.f120607r = n(trim);
            } else if (i16 == 3) {
                h.q n3 = n(trim);
                g0Var.f120608s = n3;
                if (n3.b()) {
                    throw new k("Invalid <svg> element. width cannot be negative");
                }
            } else if (i16 == 4) {
                h.q n16 = n(trim);
                g0Var.f120609t = n16;
                if (n16.b()) {
                    throw new k("Invalid <svg> element. height cannot be negative");
                }
            } else if (i16 == 5) {
                g0Var.f120610u = trim;
            }
        }
    }

    public final void a(Attributes attributes) {
        a("<a>", new Object[0]);
        if (this.f120757b != null) {
            h.b bVar = new h.b();
            bVar.f120648a = this.f120756a;
            bVar.f120649b = this.f120757b;
            a((h.m0) bVar, attributes);
            b(bVar, attributes);
            a((h.o) bVar, attributes);
            a((h.h0) bVar, attributes);
            a(bVar, attributes);
            this.f120757b.a(bVar);
            this.f120757b = bVar;
            return;
        }
        throw new k("Invalid document. Root element must be <svg>");
    }

    public final void a(h.b bVar, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            if (a.f120766b[g.a(attributes.getLocalName(i3)).ordinal()] == 6 && ("".equals(attributes.getURI(i3)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i3)))) {
                bVar.f120512p = trim;
            }
        }
    }

    public final void a(h.f1 f1Var, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            int i16 = a.f120766b[g.a(attributes.getLocalName(i3)).ordinal()];
            if (i16 == 1) {
                f1Var.f120599q = n(trim);
            } else if (i16 == 2) {
                f1Var.f120600r = n(trim);
            } else if (i16 == 3) {
                h.q n3 = n(trim);
                f1Var.f120601s = n3;
                if (n3.b()) {
                    throw new k("Invalid <use> element. width cannot be negative");
                }
            } else if (i16 != 4) {
                if (i16 == 6 && ("".equals(attributes.getURI(i3)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i3)))) {
                    f1Var.f120598p = trim;
                }
            } else {
                h.q n16 = n(trim);
                f1Var.f120602t = n16;
                if (n16.b()) {
                    throw new k("Invalid <use> element. height cannot be negative");
                }
            }
        }
    }

    public final void a(h.p pVar, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            int i16 = a.f120766b[g.a(attributes.getLocalName(i3)).ordinal()];
            if (i16 == 1) {
                pVar.f120651q = n(trim);
            } else if (i16 == 2) {
                pVar.f120652r = n(trim);
            } else if (i16 == 3) {
                h.q n3 = n(trim);
                pVar.f120653s = n3;
                if (n3.b()) {
                    throw new k("Invalid <use> element. width cannot be negative");
                }
            } else if (i16 == 4) {
                h.q n16 = n(trim);
                pVar.f120654t = n16;
                if (n16.b()) {
                    throw new k("Invalid <use> element. height cannot be negative");
                }
            } else if (i16 != 6) {
                if (i16 == 7) {
                    a((h.q0) pVar, trim);
                }
            } else if ("".equals(attributes.getURI(i3)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i3))) {
                pVar.f120650p = trim;
            }
        }
    }

    public final void a(h.w wVar, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            int i16 = a.f120766b[g.a(attributes.getLocalName(i3)).ordinal()];
            if (i16 == 8) {
                wVar.f120685o = s(trim);
            } else if (i16 != 9) {
                continue;
            } else {
                Float valueOf = Float.valueOf(h(trim));
                wVar.f120686p = valueOf;
                if (valueOf.floatValue() < 0.0f) {
                    throw new k("Invalid <path> element. pathLength cannot be negative");
                }
            }
        }
    }

    public final void a(h.c0 c0Var, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            int i16 = a.f120766b[g.a(attributes.getLocalName(i3)).ordinal()];
            if (i16 == 10) {
                h.q n3 = n(trim);
                c0Var.f120525s = n3;
                if (n3.b()) {
                    throw new k("Invalid <rect> element. rx cannot be negative");
                }
            } else if (i16 == 11) {
                h.q n16 = n(trim);
                c0Var.f120526t = n16;
                if (n16.b()) {
                    throw new k("Invalid <rect> element. ry cannot be negative");
                }
            } else if (i16 == 1) {
                c0Var.f120521o = n(trim);
            } else if (i16 == 2) {
                c0Var.f120522p = n(trim);
            } else if (i16 == 3) {
                h.q n17 = n(trim);
                c0Var.f120523q = n17;
                if (n17.b()) {
                    throw new k("Invalid <rect> element. width cannot be negative");
                }
            } else if (i16 != 4) {
                continue;
            } else {
                h.q n18 = n(trim);
                c0Var.f120524r = n18;
                if (n18.b()) {
                    throw new k("Invalid <rect> element. height cannot be negative");
                }
            }
        }
    }

    public final void a(h.e eVar, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            switch (a.f120766b[g.a(attributes.getLocalName(i3)).ordinal()]) {
                case 12:
                    eVar.f120533o = n(trim);
                    break;
                case 13:
                    eVar.f120534p = n(trim);
                    break;
                case 14:
                    h.q n3 = n(trim);
                    eVar.f120535q = n3;
                    if (n3.b()) {
                        throw new k("Invalid <circle> element. r cannot be negative");
                    }
                    break;
            }
        }
    }

    public final void a(h.j jVar, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            switch (a.f120766b[g.a(attributes.getLocalName(i3)).ordinal()]) {
                case 10:
                    h.q n3 = n(trim);
                    jVar.f120620q = n3;
                    if (n3.b()) {
                        throw new k("Invalid <ellipse> element. rx cannot be negative");
                    }
                    break;
                case 11:
                    h.q n16 = n(trim);
                    jVar.f120621r = n16;
                    if (n16.b()) {
                        throw new k("Invalid <ellipse> element. ry cannot be negative");
                    }
                    break;
                case 12:
                    jVar.f120618o = n(trim);
                    break;
                case 13:
                    jVar.f120619p = n(trim);
                    break;
            }
        }
    }

    public final void a(h.r rVar, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            switch (a.f120766b[g.a(attributes.getLocalName(i3)).ordinal()]) {
                case 15:
                    rVar.f120659o = n(trim);
                    break;
                case 16:
                    rVar.f120660p = n(trim);
                    break;
                case 17:
                    rVar.f120661q = n(trim);
                    break;
                case 18:
                    rVar.f120662r = n(trim);
                    break;
            }
        }
    }

    public final void a(h.a0 a0Var, Attributes attributes, String str) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            if (g.a(attributes.getLocalName(i3)) == g.points) {
                i iVar = new i(attributes.getValue(i3));
                ArrayList arrayList = new ArrayList();
                iVar.q();
                while (!iVar.c()) {
                    float g16 = iVar.g();
                    if (!Float.isNaN(g16)) {
                        iVar.p();
                        float g17 = iVar.g();
                        if (!Float.isNaN(g17)) {
                            iVar.p();
                            arrayList.add(Float.valueOf(g16));
                            arrayList.add(Float.valueOf(g17));
                        } else {
                            throw new k("Invalid <" + str + "> points attribute. There should be an even number of coordinates.");
                        }
                    } else {
                        throw new k("Invalid <" + str + "> points attribute. Non-coordinate content found in list.");
                    }
                }
                a0Var.f120508o = new float[arrayList.size()];
                Iterator it = arrayList.iterator();
                int i16 = 0;
                while (it.hasNext()) {
                    a0Var.f120508o[i16] = ((Float) it.next()).floatValue();
                    i16++;
                }
            }
        }
    }

    public final void a(h.b1 b1Var, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            int i16 = a.f120766b[g.a(attributes.getLocalName(i3)).ordinal()];
            if (i16 == 1) {
                b1Var.f120513o = o(trim);
            } else if (i16 == 2) {
                b1Var.f120514p = o(trim);
            } else if (i16 == 19) {
                b1Var.f120515q = o(trim);
            } else if (i16 == 20) {
                b1Var.f120516r = o(trim);
            }
        }
    }

    public final void a(h.v0 v0Var, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            if (a.f120766b[g.a(attributes.getLocalName(i3)).ordinal()] == 6 && ("".equals(attributes.getURI(i3)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i3)))) {
                v0Var.f120683o = trim;
            }
        }
    }

    public final void a(h.h0 h0Var, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            switch (a.f120766b[g.a(attributes.getLocalName(i3)).ordinal()]) {
                case 21:
                    h0Var.b(v(trim));
                    break;
                case 22:
                    h0Var.a(trim);
                    break;
                case 23:
                    h0Var.c(A(trim));
                    break;
                case 24:
                    h0Var.d(w(trim));
                    break;
                case 25:
                    List i16 = i(trim);
                    h0Var.a(i16 != null ? new HashSet(i16) : new HashSet(0));
                    break;
            }
        }
    }

    public final void a(h.s sVar, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            switch (a.f120766b[g.a(attributes.getLocalName(i3)).ordinal()]) {
                case 26:
                    sVar.f120669r = n(trim);
                    break;
                case 27:
                    sVar.f120670s = n(trim);
                    break;
                case 28:
                    h.q n3 = n(trim);
                    sVar.f120671t = n3;
                    if (n3.b()) {
                        throw new k("Invalid <marker> element. markerWidth cannot be negative");
                    }
                    break;
                case 29:
                    h.q n16 = n(trim);
                    sVar.f120672u = n16;
                    if (n16.b()) {
                        throw new k("Invalid <marker> element. markerHeight cannot be negative");
                    }
                    break;
                case 30:
                    if ("strokeWidth".equals(trim)) {
                        sVar.f120668q = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        sVar.f120668q = true;
                        break;
                    } else {
                        throw new k("Invalid value for attribute markerUnits");
                    }
                case 31:
                    if ("auto".equals(trim)) {
                        sVar.f120673v = Float.valueOf(Float.NaN);
                        break;
                    } else {
                        sVar.f120673v = Float.valueOf(h(trim));
                        break;
                    }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0093, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(h.k kVar, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            int i16 = a.f120766b[g.a(attributes.getLocalName(i3)).ordinal()];
            if (i16 != 6) {
                switch (i16) {
                    case 32:
                        if ("objectBoundingBox".equals(trim)) {
                            kVar.f120628i = Boolean.FALSE;
                            break;
                        } else if ("userSpaceOnUse".equals(trim)) {
                            kVar.f120628i = Boolean.TRUE;
                            break;
                        } else {
                            throw new k("Invalid value for attribute gradientUnits");
                        }
                    case 33:
                        kVar.f120629j = E(trim);
                        break;
                    case 34:
                        try {
                            kVar.f120630k = h.l.valueOf(trim);
                            break;
                        } catch (IllegalArgumentException unused) {
                            throw new k("Invalid spreadMethod attribute. \"" + trim + "\" is not a valid value.");
                        }
                }
            } else if ("".equals(attributes.getURI(i3)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i3))) {
                kVar.f120631l = trim;
            }
        }
    }

    public final void a(h.n0 n0Var, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            switch (a.f120766b[g.a(attributes.getLocalName(i3)).ordinal()]) {
                case 15:
                    n0Var.f120644m = n(trim);
                    break;
                case 16:
                    n0Var.f120645n = n(trim);
                    break;
                case 17:
                    n0Var.f120646o = n(trim);
                    break;
                case 18:
                    n0Var.f120647p = n(trim);
                    break;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005c, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(h.r0 r0Var, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            int i16 = a.f120766b[g.a(attributes.getLocalName(i3)).ordinal()];
            if (i16 == 35) {
                r0Var.f120666p = n(trim);
            } else if (i16 != 36) {
                switch (i16) {
                    case 12:
                        r0Var.f120663m = n(trim);
                        break;
                    case 13:
                        r0Var.f120664n = n(trim);
                        break;
                    case 14:
                        h.q n3 = n(trim);
                        r0Var.f120665o = n3;
                        if (n3.b()) {
                            throw new k("Invalid <radialGradient> element. r cannot be negative");
                        }
                        break;
                }
            } else {
                r0Var.f120667q = n(trim);
            }
        }
    }

    public final void a(h.e0 e0Var, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            if (a.f120766b[g.a(attributes.getLocalName(i3)).ordinal()] == 37) {
                e0Var.f120536h = m(trim);
            }
        }
    }

    public final void a(h.f fVar, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            if (a.f120766b[g.a(attributes.getLocalName(i3)).ordinal()] == 38) {
                if ("objectBoundingBox".equals(trim)) {
                    fVar.f120547p = Boolean.FALSE;
                } else if ("userSpaceOnUse".equals(trim)) {
                    fVar.f120547p = Boolean.TRUE;
                } else {
                    throw new k("Invalid value for attribute clipPathUnits");
                }
            }
        }
    }

    public final void a(h.a1 a1Var, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            int i16 = a.f120766b[g.a(attributes.getLocalName(i3)).ordinal()];
            if (i16 != 6) {
                if (i16 == 39) {
                    a1Var.f120510p = n(trim);
                }
            } else if ("".equals(attributes.getURI(i3)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i3))) {
                a1Var.f120509o = trim;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00d7, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(h.z zVar, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            int i16 = a.f120766b[g.a(attributes.getLocalName(i3)).ordinal()];
            if (i16 != 6) {
                if (i16 == 1) {
                    zVar.f120696t = n(trim);
                } else if (i16 == 2) {
                    zVar.f120697u = n(trim);
                } else if (i16 == 3) {
                    h.q n3 = n(trim);
                    zVar.f120698v = n3;
                    if (n3.b()) {
                        throw new k("Invalid <pattern> element. width cannot be negative");
                    }
                } else if (i16 != 4) {
                    switch (i16) {
                        case 40:
                            if ("objectBoundingBox".equals(trim)) {
                                zVar.f120693q = Boolean.FALSE;
                                break;
                            } else if ("userSpaceOnUse".equals(trim)) {
                                zVar.f120693q = Boolean.TRUE;
                                break;
                            } else {
                                throw new k("Invalid value for attribute patternUnits");
                            }
                        case 41:
                            if ("objectBoundingBox".equals(trim)) {
                                zVar.f120694r = Boolean.FALSE;
                                break;
                            } else if ("userSpaceOnUse".equals(trim)) {
                                zVar.f120694r = Boolean.TRUE;
                                break;
                            } else {
                                throw new k("Invalid value for attribute patternContentUnits");
                            }
                        case 42:
                            zVar.f120695s = E(trim);
                            break;
                    }
                } else {
                    h.q n16 = n(trim);
                    zVar.f120699w = n16;
                    if (n16.b()) {
                        throw new k("Invalid <pattern> element. height cannot be negative");
                    }
                }
            } else if ("".equals(attributes.getURI(i3)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i3))) {
                zVar.f120700x = trim;
            }
        }
    }

    public final void a(h.t tVar, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            int i16 = a.f120766b[g.a(attributes.getLocalName(i3)).ordinal()];
            if (i16 != 43) {
                if (i16 != 44) {
                    if (i16 == 1) {
                        tVar.f120677q = n(trim);
                    } else if (i16 == 2) {
                        tVar.f120678r = n(trim);
                    } else if (i16 == 3) {
                        h.q n3 = n(trim);
                        tVar.f120679s = n3;
                        if (n3.b()) {
                            throw new k("Invalid <mask> element. width cannot be negative");
                        }
                    } else if (i16 != 4) {
                        continue;
                    } else {
                        h.q n16 = n(trim);
                        tVar.f120680t = n16;
                        if (n16.b()) {
                            throw new k("Invalid <mask> element. height cannot be negative");
                        }
                    }
                } else if ("objectBoundingBox".equals(trim)) {
                    tVar.f120676p = Boolean.FALSE;
                } else if ("userSpaceOnUse".equals(trim)) {
                    tVar.f120676p = Boolean.TRUE;
                } else {
                    throw new k("Invalid value for attribute maskContentUnits");
                }
            } else if ("objectBoundingBox".equals(trim)) {
                tVar.f120675o = Boolean.FALSE;
            } else if ("userSpaceOnUse".equals(trim)) {
                tVar.f120675o = Boolean.TRUE;
            } else {
                throw new k("Invalid value for attribute maskUnits");
            }
        }
    }

    public final void a(h.m0 m0Var, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String qName = attributes.getQName(i3);
            if (!qName.equals("id") && !qName.equals("xml:id")) {
                if (qName.equals("xml:space")) {
                    String trim = attributes.getValue(i3).trim();
                    if ("default".equals(trim)) {
                        m0Var.f120639d = Boolean.FALSE;
                        return;
                    } else {
                        if ("preserve".equals(trim)) {
                            m0Var.f120639d = Boolean.TRUE;
                            return;
                        }
                        throw new k("Invalid value for \"xml:space\" attribute: " + trim);
                    }
                }
            } else {
                m0Var.f120638c = attributes.getValue(i3).trim();
                return;
            }
        }
    }

    public static void a(h.m0 m0Var, String str) {
        b.d dVar = new b.d(str.replaceAll("/\\*.*?\\*/", ""));
        while (!dVar.c()) {
            dVar.q();
            String v3 = dVar.v();
            dVar.q();
            if (!dVar.a(';')) {
                if (!dVar.a(':')) {
                    return;
                }
                dVar.q();
                String x16 = dVar.x();
                if (x16 != null) {
                    dVar.q();
                    if (dVar.c() || dVar.a(';')) {
                        if (m0Var.f120641f == null) {
                            m0Var.f120641f = new h.f0();
                        }
                        a(m0Var.f120641f, v3, x16);
                        dVar.q();
                    }
                }
            }
        }
    }

    public static void a(h.f0 f0Var, String str, String str2) {
        if (str2.length() == 0 || str2.equals("inherit")) {
            return;
        }
        try {
            switch (a.f120766b[g.a(str).ordinal()]) {
                case 47:
                    h.p0 r16 = r(str2);
                    f0Var.f120550b = r16;
                    if (r16 != null) {
                        f0Var.f120548a |= 1;
                        return;
                    }
                    return;
                case 48:
                    h.f0.a g16 = g(str2);
                    f0Var.f120552c = g16;
                    if (g16 != null) {
                        f0Var.f120548a |= 2;
                        return;
                    }
                    return;
                case 49:
                    Float p16 = p(str2);
                    f0Var.f120553d = p16;
                    if (p16 != null) {
                        f0Var.f120548a |= 4;
                        return;
                    }
                    return;
                case 50:
                    h.p0 r17 = r(str2);
                    f0Var.f120554e = r17;
                    if (r17 != null) {
                        f0Var.f120548a |= 8;
                        return;
                    }
                    return;
                case 51:
                    Float p17 = p(str2);
                    f0Var.f120555f = p17;
                    if (p17 != null) {
                        f0Var.f120548a |= 16;
                        return;
                    }
                    return;
                case 52:
                    f0Var.f120556g = n(str2);
                    f0Var.f120548a |= 32;
                    break;
                case 53:
                    h.f0.c y16 = y(str2);
                    f0Var.f120557h = y16;
                    if (y16 != null) {
                        f0Var.f120548a |= 64;
                        return;
                    }
                    return;
                case 54:
                    h.f0.d z16 = z(str2);
                    f0Var.f120558i = z16;
                    if (z16 != null) {
                        f0Var.f120548a |= 128;
                        return;
                    }
                    return;
                case 55:
                    f0Var.f120559j = Float.valueOf(h(str2));
                    f0Var.f120548a |= 256;
                    break;
                case 56:
                    if ("none".equals(str2)) {
                        f0Var.f120560k = null;
                        f0Var.f120548a |= 512;
                        return;
                    }
                    h.q[] x16 = x(str2);
                    f0Var.f120560k = x16;
                    if (x16 != null) {
                        f0Var.f120548a |= 512;
                        return;
                    }
                    return;
                case 57:
                    f0Var.f120561l = n(str2);
                    f0Var.f120548a |= 1024;
                    break;
                case 58:
                    f0Var.f120562m = p(str2);
                    f0Var.f120548a |= 2048;
                    return;
                case 59:
                    f0Var.C = d(str2);
                    f0Var.f120548a |= 4096;
                    break;
                case 60:
                    a(f0Var, str2);
                    return;
                case 61:
                    List i3 = i(str2);
                    f0Var.D = i3;
                    if (i3 != null) {
                        f0Var.f120548a |= 8192;
                        return;
                    }
                    return;
                case 62:
                    h.q j3 = j(str2);
                    f0Var.E = j3;
                    if (j3 != null) {
                        f0Var.f120548a |= 16384;
                        return;
                    }
                    return;
                case 63:
                    Integer l3 = l(str2);
                    f0Var.F = l3;
                    if (l3 != null) {
                        f0Var.f120548a |= 32768;
                        return;
                    }
                    return;
                case 64:
                    h.f0.b k3 = k(str2);
                    f0Var.G = k3;
                    if (k3 != null) {
                        f0Var.f120548a |= 65536;
                        return;
                    }
                    return;
                case 65:
                    h.f0.g C = C(str2);
                    f0Var.H = C;
                    if (C != null) {
                        f0Var.f120548a |= 131072;
                        return;
                    }
                    return;
                case 66:
                    h.f0.EnumC5978h D = D(str2);
                    f0Var.I = D;
                    if (D != null) {
                        f0Var.f120548a |= TPChannelLayout.TP_CH_TOP_SIDE_LEFT;
                        return;
                    }
                    return;
                case 67:
                    h.f0.f B = B(str2);
                    f0Var.J = B;
                    if (B != null) {
                        f0Var.f120548a |= 262144;
                        return;
                    }
                    return;
                case 68:
                    Boolean q16 = q(str2);
                    f0Var.K = q16;
                    if (q16 != null) {
                        f0Var.f120548a |= 524288;
                        return;
                    }
                    return;
                case 69:
                    String a16 = a(str2, str);
                    f0Var.M = a16;
                    f0Var.N = a16;
                    f0Var.O = a16;
                    f0Var.f120548a |= 14680064;
                    return;
                case 70:
                    f0Var.M = a(str2, str);
                    f0Var.f120548a |= 2097152;
                    return;
                case 71:
                    f0Var.N = a(str2, str);
                    f0Var.f120548a |= 4194304;
                    return;
                case 72:
                    f0Var.O = a(str2, str);
                    f0Var.f120548a |= VasBusiness.CHAT_FONT_SWITCH;
                    return;
                case 73:
                    if (str2.indexOf(124) < 0) {
                        if ("|inline|block|list-item|run-in|compact|marker|table|inline-table|table-row-group|table-header-group|table-footer-group|table-row|table-column-group|table-column|table-cell|table-caption|none|".contains(QbAddrData.DATA_SPLITER + str2 + QbAddrData.DATA_SPLITER)) {
                            f0Var.P = Boolean.valueOf(!str2.equals("none"));
                            f0Var.f120548a |= 16777216;
                            return;
                        }
                        return;
                    }
                    return;
                case 74:
                    if (str2.indexOf(124) < 0) {
                        if ("|visible|hidden|collapse|".contains(QbAddrData.DATA_SPLITER + str2 + QbAddrData.DATA_SPLITER)) {
                            f0Var.Q = Boolean.valueOf(str2.equals(NodeProps.VISIBLE));
                            f0Var.f120548a |= 33554432;
                            return;
                        }
                        return;
                    }
                    return;
                case 75:
                    if (str2.equals("currentColor")) {
                        f0Var.R = h.C5979h.a();
                    } else {
                        try {
                            f0Var.R = d(str2);
                        } catch (k e16) {
                            Log.w("SVGParser", e16.getMessage());
                            return;
                        }
                    }
                    f0Var.f120548a |= 67108864;
                    return;
                case 76:
                    f0Var.S = p(str2);
                    f0Var.f120548a |= 134217728;
                    return;
                case 77:
                    h.d c16 = c(str2);
                    f0Var.L = c16;
                    if (c16 != null) {
                        f0Var.f120548a |= 1048576;
                        return;
                    }
                    return;
                case 78:
                    f0Var.T = a(str2, str);
                    f0Var.f120548a |= VasBusiness.QWALLET;
                    return;
                case 79:
                    f0Var.U = g(str2);
                    f0Var.f120548a |= 536870912;
                    return;
                case 80:
                    f0Var.V = a(str2, str);
                    f0Var.f120548a |= 1073741824;
                    return;
                case 81:
                    if (str2.equals("currentColor")) {
                        f0Var.W = h.C5979h.a();
                    } else {
                        try {
                            f0Var.W = d(str2);
                        } catch (k e17) {
                            Log.w("SVGParser", e17.getMessage());
                            return;
                        }
                    }
                    f0Var.f120548a |= 2147483648L;
                    return;
                case 82:
                    f0Var.X = p(str2);
                    f0Var.f120548a |= 4294967296L;
                    return;
                case 83:
                    if (str2.equals("currentColor")) {
                        f0Var.Y = h.C5979h.a();
                    } else {
                        try {
                            f0Var.Y = d(str2);
                        } catch (k e18) {
                            Log.w("SVGParser", e18.getMessage());
                            return;
                        }
                    }
                    f0Var.f120548a |= 8589934592L;
                    return;
                case 84:
                    f0Var.Z = p(str2);
                    f0Var.f120548a |= 17179869184L;
                    return;
                case 85:
                    h.f0.i F = F(str2);
                    f0Var.f120549a0 = F;
                    if (F != null) {
                        f0Var.f120548a |= 34359738368L;
                        return;
                    }
                    return;
                case 86:
                    h.f0.e u16 = u(str2);
                    f0Var.f120551b0 = u16;
                    if (u16 != null) {
                        f0Var.f120548a |= TPChannelLayout.TP_CH_TOP_SIDE_RIGHT;
                        return;
                    }
                    return;
                default:
            }
        } catch (k unused) {
        }
    }

    public final void a(h.s0 s0Var, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            int i16 = a.f120766b[g.a(attributes.getLocalName(i3)).ordinal()];
            if (i16 == 7) {
                a((h.q0) s0Var, trim);
            } else if (i16 == 87) {
                s0Var.f120674p = G(trim);
            }
        }
    }

    public final void a(h.o oVar, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            if (g.a(attributes.getLocalName(i3)) == g.transform) {
                oVar.a(E(attributes.getValue(i3)));
            }
        }
    }

    public static float a(String str, int i3, int i16) {
        float a16 = new com.tencent.luggage.wxa.a.e().a(str, i3, i16);
        if (!Float.isNaN(a16)) {
            return a16;
        }
        throw new k("Invalid float value: " + str);
    }

    public static void a(h.q0 q0Var, String str) {
        q0Var.f120658o = t(str);
    }

    public static int a(float f16) {
        if (f16 < 0.0f) {
            return 0;
        }
        if (f16 > 255.0f) {
            return 255;
        }
        return Math.round(f16);
    }

    public static int a(float f16, float f17, float f18) {
        float f19 = f16 % 360.0f;
        if (f16 < 0.0f) {
            f19 += 360.0f;
        }
        float f26 = f19 / 60.0f;
        float f27 = f17 / 100.0f;
        float f28 = f18 / 100.0f;
        if (f27 < 0.0f) {
            f27 = 0.0f;
        } else if (f27 > 1.0f) {
            f27 = 1.0f;
        }
        float f29 = f28 >= 0.0f ? f28 > 1.0f ? 1.0f : f28 : 0.0f;
        float f36 = f29 <= 0.5f ? (f27 + 1.0f) * f29 : (f29 + f27) - (f27 * f29);
        float f37 = (f29 * 2.0f) - f36;
        return a(b(f37, f36, f26 - 2.0f) * 256.0f) | (a(b(f37, f36, f26 + 2.0f) * 256.0f) << 16) | (a(b(f37, f36, f26) * 256.0f) << 8);
    }

    public static void a(h.f0 f0Var, String str) {
        String b16;
        if ("|caption|icon|menu|message-box|small-caption|status-bar|".contains(QbAddrData.DATA_SPLITER + str + QbAddrData.DATA_SPLITER)) {
            i iVar = new i(str);
            Integer num = null;
            h.f0.b bVar = null;
            String str2 = null;
            while (true) {
                b16 = iVar.b('/');
                iVar.q();
                if (b16 != null) {
                    if (num != null && bVar != null) {
                        break;
                    }
                    if (!b16.equals("normal") && (num != null || (num = e.a(b16)) == null)) {
                        if (bVar != null || (bVar = k(b16)) == null) {
                            if (str2 != null || !b16.equals("small-caps")) {
                                break;
                            } else {
                                str2 = b16;
                            }
                        }
                    }
                } else {
                    return;
                }
            }
            h.q j3 = j(b16);
            if (iVar.a('/')) {
                iVar.q();
                String k3 = iVar.k();
                if (k3 != null) {
                    try {
                        n(k3);
                    } catch (k unused) {
                        return;
                    }
                }
                iVar.q();
            }
            f0Var.D = i(iVar.o());
            f0Var.E = j3;
            f0Var.F = Integer.valueOf(num == null ? 400 : num.intValue());
            if (bVar == null) {
                bVar = h.f0.b.Normal;
            }
            f0Var.G = bVar;
            f0Var.f120548a |= 122880;
        }
    }

    public static h.q a(i iVar) {
        if (iVar.a("auto")) {
            return new h.q(0.0f);
        }
        return iVar.i();
    }

    public static String a(String str, String str2) {
        if (str.equals("none") || !str.startsWith("url(")) {
            return null;
        }
        if (str.endsWith(")")) {
            return str.substring(4, str.length() - 1).trim();
        }
        return str.substring(4).trim();
    }
}
