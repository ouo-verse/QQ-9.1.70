package com.caverock.androidsvg;

import android.graphics.Matrix;
import android.util.Log;
import com.caverock.androidsvg.CSSParser;
import com.caverock.androidsvg.PreserveAspectRatio;
import com.caverock.androidsvg.SVG;
import com.tencent.ams.mosaic.jsengine.component.ComponentFactory;
import com.tencent.mobileqq.vas.avatar.NtFaceConstant;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasBusiness;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.pts.ui.vnode.PTSNodeTextBase;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.thumbplayer.api.common.TPChannelLayout;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
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

/* loaded from: classes.dex */
public class SVGParser extends DefaultHandler2 {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr = null;
    private static final String CURRENTCOLOR = "currentColor";
    private static final String FEATURE_STRING_PREFIX = "http://www.w3.org/TR/SVG11/feature#";
    private static final String NONE = "none";
    private static final String SVG_NAMESPACE = "http://www.w3.org/2000/svg";
    private static final String TAG = "SVGParser";
    private static final String TAG_A = "a";
    private static final String TAG_CIRCLE = "circle";
    private static final String TAG_CLIPPATH = "clipPath";
    private static final String TAG_DEFS = "defs";
    private static final String TAG_DESC = "desc";
    private static final String TAG_ELLIPSE = "ellipse";
    private static final String TAG_G = "g";
    private static final String TAG_IMAGE = "image";
    private static final String TAG_LINE = "line";
    private static final String TAG_LINEARGRADIENT = "linearGradient";
    private static final String TAG_MARKER = "marker";
    private static final String TAG_MASK = "mask";
    private static final String TAG_PATH = "path";
    private static final String TAG_PATTERN = "pattern";
    private static final String TAG_POLYGON = "polygon";
    private static final String TAG_POLYLINE = "polyline";
    private static final String TAG_RADIALGRADIENT = "radialGradient";
    private static final String TAG_RECT = "rect";
    private static final String TAG_SOLIDCOLOR = "solidColor";
    private static final String TAG_STOP = "stop";
    private static final String TAG_STYLE = "style";
    private static final String TAG_SVG = "svg";
    private static final String TAG_SWITCH = "switch";
    private static final String TAG_SYMBOL = "symbol";
    private static final String TAG_TEXT = "text";
    private static final String TAG_TEXTPATH = "textPath";
    private static final String TAG_TITLE = "title";
    private static final String TAG_TREF = "tref";
    private static final String TAG_TSPAN = "tspan";
    private static final String TAG_USE = "use";
    private static final String TAG_VIEW = "view";
    private static final String VALID_DISPLAY_VALUES = "|inline|block|list-item|run-in|compact|marker|table|inline-table|table-row-group|table-header-group|table-footer-group|table-row|table-column-group|table-column|table-cell|table-caption|none|";
    private static final String VALID_VISIBILITY_VALUES = "|visible|hidden|collapse|";
    private static final String XLINK_NAMESPACE = "http://www.w3.org/1999/xlink";
    private int ignoreDepth;
    private static HashMap<String, Integer> colourKeywords = new HashMap<>();
    private static HashMap<String, SVG.Length> fontSizeKeywords = new HashMap<>(9);
    private static HashMap<String, Integer> fontWeightKeywords = new HashMap<>(13);
    private static HashMap<String, SVG.Style.FontStyle> fontStyleKeywords = new HashMap<>(3);
    private static HashMap<String, PreserveAspectRatio.Alignment> aspectRatioKeywords = new HashMap<>();
    protected static HashSet<String> supportedFeatures = new HashSet<>();
    private SVG svgDocument = null;
    private SVG.SvgContainer currentElement = null;
    private boolean ignoring = false;
    private boolean inMetadataElement = false;
    private String metadataTag = null;
    private StringBuilder metadataElementContents = null;
    private boolean inStyleElement = false;
    private StringBuilder styleElementContents = null;
    private HashSet<String> supportedFormats = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum SVGAttr {
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
        id,
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

        public static SVGAttr fromString(String str) {
            if (str.equals(Constants.Service.CLASS)) {
                return CLASS;
            }
            if (str.indexOf(95) != -1) {
                return UNSUPPORTED;
            }
            try {
                return valueOf(str.replace('-', util.base64_pad_url));
            } catch (IllegalArgumentException unused) {
                return UNSUPPORTED;
            }
        }

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static SVGAttr[] valuesCustom() {
            SVGAttr[] valuesCustom = values();
            int length = valuesCustom.length;
            SVGAttr[] sVGAttrArr = new SVGAttr[length];
            System.arraycopy(valuesCustom, 0, sVGAttrArr, 0, length);
            return sVGAttrArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class TextScanner {
        protected String input;
        protected int position = 0;

        public TextScanner(String str) {
            this.input = str.trim();
        }

        private int scanForFloat() {
            int i3;
            if (empty()) {
                return this.position;
            }
            int i16 = this.position;
            int charAt = this.input.charAt(i16);
            if (charAt == 45 || charAt == 43) {
                charAt = advanceChar();
            }
            if (Character.isDigit(charAt)) {
                i3 = this.position + 1;
                charAt = advanceChar();
                while (Character.isDigit(charAt)) {
                    i3 = this.position + 1;
                    charAt = advanceChar();
                }
            } else {
                i3 = i16;
            }
            if (charAt == 46) {
                i3 = this.position + 1;
                charAt = advanceChar();
                while (Character.isDigit(charAt)) {
                    i3 = this.position + 1;
                    charAt = advanceChar();
                }
            }
            if (charAt == 101 || charAt == 69) {
                int advanceChar = advanceChar();
                if (advanceChar == 45 || advanceChar == 43) {
                    advanceChar = advanceChar();
                }
                if (Character.isDigit(advanceChar)) {
                    int i17 = this.position + 1;
                    int advanceChar2 = advanceChar();
                    i3 = i17;
                    while (Character.isDigit(advanceChar2)) {
                        i3 = this.position + 1;
                        advanceChar2 = advanceChar();
                    }
                }
            }
            this.position = i16;
            return i3;
        }

        private int scanForInteger() {
            int i3;
            if (empty()) {
                return this.position;
            }
            int i16 = this.position;
            int charAt = this.input.charAt(i16);
            if (charAt == 45 || charAt == 43) {
                charAt = advanceChar();
            }
            if (Character.isDigit(charAt)) {
                i3 = this.position + 1;
                int advanceChar = advanceChar();
                while (Character.isDigit(advanceChar)) {
                    i3 = this.position + 1;
                    advanceChar = advanceChar();
                }
            } else {
                i3 = i16;
            }
            this.position = i16;
            return i3;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public int advanceChar() {
            if (this.position == this.input.length()) {
                return -1;
            }
            int i3 = this.position + 1;
            this.position = i3;
            if (i3 >= this.input.length()) {
                return -1;
            }
            return this.input.charAt(this.position);
        }

        public String ahead() {
            int i3 = this.position;
            while (!empty() && !isWhitespace(this.input.charAt(this.position))) {
                this.position++;
            }
            String substring = this.input.substring(i3, this.position);
            this.position = i3;
            return substring;
        }

        public Boolean checkedNextFlag(Object obj) {
            if (obj == null) {
                return null;
            }
            skipCommaWhitespace();
            return nextFlag();
        }

        public Float checkedNextFloat(Object obj) {
            if (obj == null) {
                return null;
            }
            skipCommaWhitespace();
            return nextFloat();
        }

        public boolean consume(char c16) {
            boolean z16 = this.position < this.input.length() && this.input.charAt(this.position) == c16;
            if (z16) {
                this.position++;
            }
            return z16;
        }

        public boolean empty() {
            if (this.position == this.input.length()) {
                return true;
            }
            return false;
        }

        public boolean hasLetter() {
            if (this.position == this.input.length()) {
                return false;
            }
            char charAt = this.input.charAt(this.position);
            if (charAt < 'a' || charAt > 'z') {
                if (charAt < 'A' || charAt > 'Z') {
                    return false;
                }
                return true;
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean isEOL(int i3) {
            if (i3 != 10 && i3 != 13) {
                return false;
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean isWhitespace(int i3) {
            if (i3 != 32 && i3 != 10 && i3 != 13 && i3 != 9) {
                return false;
            }
            return true;
        }

        public Integer nextChar() {
            if (this.position == this.input.length()) {
                return null;
            }
            String str = this.input;
            int i3 = this.position;
            this.position = i3 + 1;
            return Integer.valueOf(str.charAt(i3));
        }

        public Boolean nextFlag() {
            if (this.position == this.input.length()) {
                return null;
            }
            char charAt = this.input.charAt(this.position);
            if (charAt != '0' && charAt != '1') {
                return null;
            }
            boolean z16 = true;
            this.position++;
            if (charAt != '1') {
                z16 = false;
            }
            return Boolean.valueOf(z16);
        }

        public Float nextFloat() {
            int scanForFloat = scanForFloat();
            int i3 = this.position;
            if (scanForFloat == i3) {
                return null;
            }
            Float valueOf = Float.valueOf(Float.parseFloat(this.input.substring(i3, scanForFloat)));
            this.position = scanForFloat;
            return valueOf;
        }

        public String nextFunction() {
            if (empty()) {
                return null;
            }
            int i3 = this.position;
            int charAt = this.input.charAt(i3);
            while (true) {
                if ((charAt < 97 || charAt > 122) && (charAt < 65 || charAt > 90)) {
                    break;
                }
                charAt = advanceChar();
            }
            int i16 = this.position;
            while (isWhitespace(charAt)) {
                charAt = advanceChar();
            }
            if (charAt == 40) {
                this.position++;
                return this.input.substring(i3, i16);
            }
            this.position = i3;
            return null;
        }

        public Integer nextInteger() {
            int scanForInteger = scanForInteger();
            int i3 = this.position;
            if (scanForInteger == i3) {
                return null;
            }
            Integer valueOf = Integer.valueOf(Integer.parseInt(this.input.substring(i3, scanForInteger)));
            this.position = scanForInteger;
            return valueOf;
        }

        public SVG.Length nextLength() {
            Float nextFloat = nextFloat();
            if (nextFloat == null) {
                return null;
            }
            SVG.Unit nextUnit = nextUnit();
            if (nextUnit == null) {
                return new SVG.Length(nextFloat.floatValue(), SVG.Unit.px);
            }
            return new SVG.Length(nextFloat.floatValue(), nextUnit);
        }

        public String nextQuotedString() {
            if (empty()) {
                return null;
            }
            int i3 = this.position;
            char charAt = this.input.charAt(i3);
            if (charAt != '\'' && charAt != '\"') {
                return null;
            }
            int advanceChar = advanceChar();
            while (advanceChar != -1 && advanceChar != charAt) {
                advanceChar = advanceChar();
            }
            if (advanceChar == -1) {
                this.position = i3;
                return null;
            }
            int i16 = this.position + 1;
            this.position = i16;
            return this.input.substring(i3 + 1, i16 - 1);
        }

        public String nextToken() {
            return nextToken(TokenParser.SP);
        }

        public SVG.Unit nextUnit() {
            if (empty()) {
                return null;
            }
            if (this.input.charAt(this.position) == '%') {
                this.position++;
                return SVG.Unit.percent;
            }
            if (this.position > this.input.length() - 2) {
                return null;
            }
            try {
                String str = this.input;
                int i3 = this.position;
                SVG.Unit valueOf = SVG.Unit.valueOf(str.substring(i3, i3 + 2).toLowerCase(Locale.US));
                this.position += 2;
                return valueOf;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public Float possibleNextFloat() {
            int i3 = this.position;
            skipCommaWhitespace();
            Float nextFloat = nextFloat();
            if (nextFloat != null) {
                return nextFloat;
            }
            this.position = i3;
            return null;
        }

        public String restOfText() {
            if (empty()) {
                return null;
            }
            int i3 = this.position;
            this.position = this.input.length();
            return this.input.substring(i3);
        }

        public boolean skipCommaWhitespace() {
            skipWhitespace();
            if (this.position == this.input.length() || this.input.charAt(this.position) != ',') {
                return false;
            }
            this.position++;
            skipWhitespace();
            return true;
        }

        public void skipWhitespace() {
            while (this.position < this.input.length() && isWhitespace(this.input.charAt(this.position))) {
                this.position++;
            }
        }

        public String nextToken(char c16) {
            if (empty()) {
                return null;
            }
            char charAt = this.input.charAt(this.position);
            if (isWhitespace(charAt) || charAt == c16) {
                return null;
            }
            int i3 = this.position;
            int advanceChar = advanceChar();
            while (advanceChar != -1 && advanceChar != c16 && !isWhitespace(advanceChar)) {
                advanceChar = advanceChar();
            }
            return this.input.substring(i3, this.position);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0024  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean consume(String str) {
            boolean z16;
            int length = str.length();
            if (this.position <= this.input.length() - length) {
                String str2 = this.input;
                int i3 = this.position;
                if (str2.substring(i3, i3 + length).equals(str)) {
                    z16 = true;
                    if (z16) {
                        this.position += length;
                    }
                    return z16;
                }
            }
            z16 = false;
            if (z16) {
            }
            return z16;
        }
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr() {
        int[] iArr = $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[SVGAttr.valuesCustom().length];
        try {
            iArr2[SVGAttr.CLASS.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[SVGAttr.UNSUPPORTED.ordinal()] = 92;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[SVGAttr.clip.ordinal()] = 2;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[SVGAttr.clipPathUnits.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[SVGAttr.clip_path.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[SVGAttr.clip_rule.ordinal()] = 5;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr2[SVGAttr.color.ordinal()] = 6;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            iArr2[SVGAttr.cx.ordinal()] = 7;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            iArr2[SVGAttr.cy.ordinal()] = 8;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            iArr2[SVGAttr.d.ordinal()] = 14;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            iArr2[SVGAttr.direction.ordinal()] = 9;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            iArr2[SVGAttr.display.ordinal()] = 15;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            iArr2[SVGAttr.dx.ordinal()] = 10;
        } catch (NoSuchFieldError unused13) {
        }
        try {
            iArr2[SVGAttr.dy.ordinal()] = 11;
        } catch (NoSuchFieldError unused14) {
        }
        try {
            iArr2[SVGAttr.fill.ordinal()] = 16;
        } catch (NoSuchFieldError unused15) {
        }
        try {
            iArr2[SVGAttr.fill_opacity.ordinal()] = 18;
        } catch (NoSuchFieldError unused16) {
        }
        try {
            iArr2[SVGAttr.fill_rule.ordinal()] = 17;
        } catch (NoSuchFieldError unused17) {
        }
        try {
            iArr2[SVGAttr.font.ordinal()] = 19;
        } catch (NoSuchFieldError unused18) {
        }
        try {
            iArr2[SVGAttr.font_family.ordinal()] = 20;
        } catch (NoSuchFieldError unused19) {
        }
        try {
            iArr2[SVGAttr.font_size.ordinal()] = 21;
        } catch (NoSuchFieldError unused20) {
        }
        try {
            iArr2[SVGAttr.font_style.ordinal()] = 23;
        } catch (NoSuchFieldError unused21) {
        }
        try {
            iArr2[SVGAttr.font_weight.ordinal()] = 22;
        } catch (NoSuchFieldError unused22) {
        }
        try {
            iArr2[SVGAttr.fx.ordinal()] = 12;
        } catch (NoSuchFieldError unused23) {
        }
        try {
            iArr2[SVGAttr.fy.ordinal()] = 13;
        } catch (NoSuchFieldError unused24) {
        }
        try {
            iArr2[SVGAttr.gradientTransform.ordinal()] = 24;
        } catch (NoSuchFieldError unused25) {
        }
        try {
            iArr2[SVGAttr.gradientUnits.ordinal()] = 25;
        } catch (NoSuchFieldError unused26) {
        }
        try {
            iArr2[SVGAttr.height.ordinal()] = 26;
        } catch (NoSuchFieldError unused27) {
        }
        try {
            iArr2[SVGAttr.href.ordinal()] = 27;
        } catch (NoSuchFieldError unused28) {
        }
        try {
            iArr2[SVGAttr.id.ordinal()] = 28;
        } catch (NoSuchFieldError unused29) {
        }
        try {
            iArr2[SVGAttr.marker.ordinal()] = 29;
        } catch (NoSuchFieldError unused30) {
        }
        try {
            iArr2[SVGAttr.markerHeight.ordinal()] = 33;
        } catch (NoSuchFieldError unused31) {
        }
        try {
            iArr2[SVGAttr.markerUnits.ordinal()] = 34;
        } catch (NoSuchFieldError unused32) {
        }
        try {
            iArr2[SVGAttr.markerWidth.ordinal()] = 35;
        } catch (NoSuchFieldError unused33) {
        }
        try {
            iArr2[SVGAttr.marker_end.ordinal()] = 32;
        } catch (NoSuchFieldError unused34) {
        }
        try {
            iArr2[SVGAttr.marker_mid.ordinal()] = 31;
        } catch (NoSuchFieldError unused35) {
        }
        try {
            iArr2[SVGAttr.marker_start.ordinal()] = 30;
        } catch (NoSuchFieldError unused36) {
        }
        try {
            iArr2[SVGAttr.mask.ordinal()] = 36;
        } catch (NoSuchFieldError unused37) {
        }
        try {
            iArr2[SVGAttr.maskContentUnits.ordinal()] = 37;
        } catch (NoSuchFieldError unused38) {
        }
        try {
            iArr2[SVGAttr.maskUnits.ordinal()] = 38;
        } catch (NoSuchFieldError unused39) {
        }
        try {
            iArr2[SVGAttr.media.ordinal()] = 39;
        } catch (NoSuchFieldError unused40) {
        }
        try {
            iArr2[SVGAttr.offset.ordinal()] = 40;
        } catch (NoSuchFieldError unused41) {
        }
        try {
            iArr2[SVGAttr.opacity.ordinal()] = 41;
        } catch (NoSuchFieldError unused42) {
        }
        try {
            iArr2[SVGAttr.orient.ordinal()] = 42;
        } catch (NoSuchFieldError unused43) {
        }
        try {
            iArr2[SVGAttr.overflow.ordinal()] = 43;
        } catch (NoSuchFieldError unused44) {
        }
        try {
            iArr2[SVGAttr.pathLength.ordinal()] = 44;
        } catch (NoSuchFieldError unused45) {
        }
        try {
            iArr2[SVGAttr.patternContentUnits.ordinal()] = 45;
        } catch (NoSuchFieldError unused46) {
        }
        try {
            iArr2[SVGAttr.patternTransform.ordinal()] = 46;
        } catch (NoSuchFieldError unused47) {
        }
        try {
            iArr2[SVGAttr.patternUnits.ordinal()] = 47;
        } catch (NoSuchFieldError unused48) {
        }
        try {
            iArr2[SVGAttr.points.ordinal()] = 48;
        } catch (NoSuchFieldError unused49) {
        }
        try {
            iArr2[SVGAttr.preserveAspectRatio.ordinal()] = 49;
        } catch (NoSuchFieldError unused50) {
        }
        try {
            iArr2[SVGAttr.r.ordinal()] = 50;
        } catch (NoSuchFieldError unused51) {
        }
        try {
            iArr2[SVGAttr.refX.ordinal()] = 51;
        } catch (NoSuchFieldError unused52) {
        }
        try {
            iArr2[SVGAttr.refY.ordinal()] = 52;
        } catch (NoSuchFieldError unused53) {
        }
        try {
            iArr2[SVGAttr.requiredExtensions.ordinal()] = 54;
        } catch (NoSuchFieldError unused54) {
        }
        try {
            iArr2[SVGAttr.requiredFeatures.ordinal()] = 53;
        } catch (NoSuchFieldError unused55) {
        }
        try {
            iArr2[SVGAttr.requiredFonts.ordinal()] = 56;
        } catch (NoSuchFieldError unused56) {
        }
        try {
            iArr2[SVGAttr.requiredFormats.ordinal()] = 55;
        } catch (NoSuchFieldError unused57) {
        }
        try {
            iArr2[SVGAttr.rx.ordinal()] = 57;
        } catch (NoSuchFieldError unused58) {
        }
        try {
            iArr2[SVGAttr.ry.ordinal()] = 58;
        } catch (NoSuchFieldError unused59) {
        }
        try {
            iArr2[SVGAttr.solid_color.ordinal()] = 59;
        } catch (NoSuchFieldError unused60) {
        }
        try {
            iArr2[SVGAttr.solid_opacity.ordinal()] = 60;
        } catch (NoSuchFieldError unused61) {
        }
        try {
            iArr2[SVGAttr.spreadMethod.ordinal()] = 61;
        } catch (NoSuchFieldError unused62) {
        }
        try {
            iArr2[SVGAttr.startOffset.ordinal()] = 62;
        } catch (NoSuchFieldError unused63) {
        }
        try {
            iArr2[SVGAttr.stop_color.ordinal()] = 63;
        } catch (NoSuchFieldError unused64) {
        }
        try {
            iArr2[SVGAttr.stop_opacity.ordinal()] = 64;
        } catch (NoSuchFieldError unused65) {
        }
        try {
            iArr2[SVGAttr.stroke.ordinal()] = 65;
        } catch (NoSuchFieldError unused66) {
        }
        try {
            iArr2[SVGAttr.stroke_dasharray.ordinal()] = 66;
        } catch (NoSuchFieldError unused67) {
        }
        try {
            iArr2[SVGAttr.stroke_dashoffset.ordinal()] = 67;
        } catch (NoSuchFieldError unused68) {
        }
        try {
            iArr2[SVGAttr.stroke_linecap.ordinal()] = 68;
        } catch (NoSuchFieldError unused69) {
        }
        try {
            iArr2[SVGAttr.stroke_linejoin.ordinal()] = 69;
        } catch (NoSuchFieldError unused70) {
        }
        try {
            iArr2[SVGAttr.stroke_miterlimit.ordinal()] = 70;
        } catch (NoSuchFieldError unused71) {
        }
        try {
            iArr2[SVGAttr.stroke_opacity.ordinal()] = 71;
        } catch (NoSuchFieldError unused72) {
        }
        try {
            iArr2[SVGAttr.stroke_width.ordinal()] = 72;
        } catch (NoSuchFieldError unused73) {
        }
        try {
            iArr2[SVGAttr.style.ordinal()] = 73;
        } catch (NoSuchFieldError unused74) {
        }
        try {
            iArr2[SVGAttr.systemLanguage.ordinal()] = 74;
        } catch (NoSuchFieldError unused75) {
        }
        try {
            iArr2[SVGAttr.text_anchor.ordinal()] = 75;
        } catch (NoSuchFieldError unused76) {
        }
        try {
            iArr2[SVGAttr.text_decoration.ordinal()] = 76;
        } catch (NoSuchFieldError unused77) {
        }
        try {
            iArr2[SVGAttr.transform.ordinal()] = 77;
        } catch (NoSuchFieldError unused78) {
        }
        try {
            iArr2[SVGAttr.type.ordinal()] = 78;
        } catch (NoSuchFieldError unused79) {
        }
        try {
            iArr2[SVGAttr.vector_effect.ordinal()] = 79;
        } catch (NoSuchFieldError unused80) {
        }
        try {
            iArr2[SVGAttr.version.ordinal()] = 80;
        } catch (NoSuchFieldError unused81) {
        }
        try {
            iArr2[SVGAttr.viewBox.ordinal()] = 81;
        } catch (NoSuchFieldError unused82) {
        }
        try {
            iArr2[SVGAttr.viewport_fill.ordinal()] = 89;
        } catch (NoSuchFieldError unused83) {
        }
        try {
            iArr2[SVGAttr.viewport_fill_opacity.ordinal()] = 90;
        } catch (NoSuchFieldError unused84) {
        }
        try {
            iArr2[SVGAttr.visibility.ordinal()] = 91;
        } catch (NoSuchFieldError unused85) {
        }
        try {
            iArr2[SVGAttr.width.ordinal()] = 82;
        } catch (NoSuchFieldError unused86) {
        }
        try {
            iArr2[SVGAttr.x.ordinal()] = 83;
        } catch (NoSuchFieldError unused87) {
        }
        try {
            iArr2[SVGAttr.x1.ordinal()] = 85;
        } catch (NoSuchFieldError unused88) {
        }
        try {
            iArr2[SVGAttr.x2.ordinal()] = 87;
        } catch (NoSuchFieldError unused89) {
        }
        try {
            iArr2[SVGAttr.y.ordinal()] = 84;
        } catch (NoSuchFieldError unused90) {
        }
        try {
            iArr2[SVGAttr.y1.ordinal()] = 86;
        } catch (NoSuchFieldError unused91) {
        }
        try {
            iArr2[SVGAttr.y2.ordinal()] = 88;
        } catch (NoSuchFieldError unused92) {
        }
        $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr = iArr2;
        return iArr2;
    }

    static {
        colourKeywords.put("aliceblue", 15792383);
        colourKeywords.put("antiquewhite", 16444375);
        colourKeywords.put("aqua", 65535);
        colourKeywords.put("aquamarine", 8388564);
        colourKeywords.put("azure", 15794175);
        colourKeywords.put("beige", 16119260);
        colourKeywords.put("bisque", 16770244);
        colourKeywords.put("black", 0);
        colourKeywords.put("blanchedalmond", 16772045);
        colourKeywords.put("blue", 255);
        colourKeywords.put("blueviolet", 9055202);
        colourKeywords.put("brown", 10824234);
        colourKeywords.put("burlywood", 14596231);
        colourKeywords.put("cadetblue", 6266528);
        colourKeywords.put("chartreuse", 8388352);
        colourKeywords.put("chocolate", 13789470);
        colourKeywords.put("coral", 16744272);
        colourKeywords.put("cornflowerblue", 6591981);
        colourKeywords.put("cornsilk", 16775388);
        colourKeywords.put("crimson", 14423100);
        colourKeywords.put("cyan", 65535);
        colourKeywords.put("darkblue", 139);
        colourKeywords.put("darkcyan", 35723);
        colourKeywords.put("darkgoldenrod", 12092939);
        colourKeywords.put("darkgray", 11119017);
        colourKeywords.put("darkgreen", 25600);
        colourKeywords.put("darkgrey", 11119017);
        colourKeywords.put("darkkhaki", 12433259);
        colourKeywords.put("darkmagenta", 9109643);
        colourKeywords.put("darkolivegreen", 5597999);
        colourKeywords.put("darkorange", 16747520);
        colourKeywords.put("darkorchid", 10040012);
        colourKeywords.put("darkred", 9109504);
        colourKeywords.put("darksalmon", 15308410);
        colourKeywords.put("darkseagreen", 9419919);
        colourKeywords.put("darkslateblue", 4734347);
        colourKeywords.put("darkslategray", 3100495);
        colourKeywords.put("darkslategrey", 3100495);
        colourKeywords.put("darkturquoise", 52945);
        colourKeywords.put("darkviolet", 9699539);
        colourKeywords.put("deeppink", 16716947);
        colourKeywords.put("deepskyblue", 49151);
        colourKeywords.put("dimgray", 6908265);
        colourKeywords.put("dimgrey", 6908265);
        colourKeywords.put("dodgerblue", 2003199);
        colourKeywords.put("firebrick", 11674146);
        colourKeywords.put("floralwhite", 16775920);
        colourKeywords.put("forestgreen", 2263842);
        colourKeywords.put("fuchsia", 16711935);
        colourKeywords.put("gainsboro", 14474460);
        colourKeywords.put("ghostwhite", 16316671);
        colourKeywords.put("gold", 16766720);
        colourKeywords.put("goldenrod", 14329120);
        colourKeywords.put("gray", 8421504);
        colourKeywords.put("green", 32768);
        colourKeywords.put("greenyellow", 11403055);
        colourKeywords.put("grey", 8421504);
        colourKeywords.put("honeydew", 15794160);
        colourKeywords.put("hotpink", 16738740);
        colourKeywords.put("indianred", 13458524);
        colourKeywords.put("indigo", 4915330);
        colourKeywords.put("ivory", 16777200);
        colourKeywords.put("khaki", 15787660);
        colourKeywords.put("lavender", 15132410);
        colourKeywords.put("lavenderblush", 16773365);
        colourKeywords.put("lawngreen", 8190976);
        colourKeywords.put("lemonchiffon", 16775885);
        colourKeywords.put("lightblue", 11393254);
        colourKeywords.put("lightcoral", 15761536);
        colourKeywords.put("lightcyan", 14745599);
        colourKeywords.put("lightgoldenrodyellow", 16448210);
        colourKeywords.put("lightgray", 13882323);
        colourKeywords.put("lightgreen", 9498256);
        colourKeywords.put("lightgrey", 13882323);
        colourKeywords.put("lightpink", 16758465);
        colourKeywords.put("lightsalmon", 16752762);
        colourKeywords.put("lightseagreen", 2142890);
        colourKeywords.put("lightskyblue", 8900346);
        colourKeywords.put("lightslategray", 7833753);
        colourKeywords.put("lightslategrey", 7833753);
        colourKeywords.put("lightsteelblue", 11584734);
        colourKeywords.put("lightyellow", 16777184);
        colourKeywords.put("lime", 65280);
        colourKeywords.put("limegreen", 3329330);
        colourKeywords.put("linen", 16445670);
        colourKeywords.put("magenta", 16711935);
        colourKeywords.put("maroon", 8388608);
        colourKeywords.put("mediumaquamarine", 6737322);
        colourKeywords.put("mediumblue", 205);
        colourKeywords.put("mediumorchid", 12211667);
        colourKeywords.put("mediumpurple", 9662683);
        colourKeywords.put("mediumseagreen", 3978097);
        colourKeywords.put("mediumslateblue", 8087790);
        colourKeywords.put("mediumspringgreen", 64154);
        colourKeywords.put("mediumturquoise", 4772300);
        colourKeywords.put("mediumvioletred", 13047173);
        colourKeywords.put("midnightblue", 1644912);
        colourKeywords.put("mintcream", 16121850);
        colourKeywords.put("mistyrose", 16770273);
        colourKeywords.put("moccasin", 16770229);
        colourKeywords.put("navajowhite", 16768685);
        colourKeywords.put("navy", 128);
        colourKeywords.put("oldlace", 16643558);
        colourKeywords.put("olive", 8421376);
        colourKeywords.put("olivedrab", 7048739);
        colourKeywords.put("orange", 16753920);
        colourKeywords.put("orangered", 16729344);
        colourKeywords.put("orchid", 14315734);
        colourKeywords.put("palegoldenrod", 15657130);
        colourKeywords.put("palegreen", 10025880);
        colourKeywords.put("paleturquoise", 11529966);
        colourKeywords.put("palevioletred", 14381203);
        colourKeywords.put("papayawhip", 16773077);
        colourKeywords.put("peachpuff", 16767673);
        colourKeywords.put("peru", 13468991);
        colourKeywords.put("pink", 16761035);
        colourKeywords.put("plum", 14524637);
        colourKeywords.put("powderblue", 11591910);
        colourKeywords.put("purple", 8388736);
        colourKeywords.put("red", Integer.valueOf(ITVKAsset.VOD_ASSET_MASK_BIT));
        colourKeywords.put("rosybrown", 12357519);
        colourKeywords.put("royalblue", 4286945);
        colourKeywords.put("saddlebrown", 9127187);
        colourKeywords.put("salmon", 16416882);
        colourKeywords.put("sandybrown", 16032864);
        colourKeywords.put("seagreen", 3050327);
        colourKeywords.put("seashell", 16774638);
        colourKeywords.put("sienna", 10506797);
        colourKeywords.put("silver", 12632256);
        colourKeywords.put("skyblue", 8900331);
        colourKeywords.put("slateblue", 6970061);
        colourKeywords.put("slategray", 7372944);
        colourKeywords.put("slategrey", 7372944);
        colourKeywords.put("snow", 16775930);
        colourKeywords.put("springgreen", 65407);
        colourKeywords.put("steelblue", 4620980);
        colourKeywords.put("tan", 13808780);
        colourKeywords.put("teal", 32896);
        colourKeywords.put("thistle", 14204888);
        colourKeywords.put("tomato", 16737095);
        colourKeywords.put("turquoise", 4251856);
        colourKeywords.put("violet", 15631086);
        colourKeywords.put("wheat", 16113331);
        colourKeywords.put("white", 16777215);
        colourKeywords.put("whitesmoke", 16119285);
        colourKeywords.put("yellow", 16776960);
        colourKeywords.put("yellowgreen", 10145074);
        HashMap<String, SVG.Length> hashMap = fontSizeKeywords;
        SVG.Unit unit = SVG.Unit.pt;
        hashMap.put("xx-small", new SVG.Length(0.694f, unit));
        fontSizeKeywords.put("x-small", new SVG.Length(0.833f, unit));
        fontSizeKeywords.put(NtFaceConstant.SMALL, new SVG.Length(10.0f, unit));
        fontSizeKeywords.put("medium", new SVG.Length(12.0f, unit));
        fontSizeKeywords.put(NtFaceConstant.LARGE, new SVG.Length(14.4f, unit));
        fontSizeKeywords.put("x-large", new SVG.Length(17.3f, unit));
        fontSizeKeywords.put("xx-large", new SVG.Length(20.7f, unit));
        HashMap<String, SVG.Length> hashMap2 = fontSizeKeywords;
        SVG.Unit unit2 = SVG.Unit.percent;
        hashMap2.put("smaller", new SVG.Length(83.33f, unit2));
        fontSizeKeywords.put("larger", new SVG.Length(120.0f, unit2));
        fontWeightKeywords.put("normal", 400);
        fontWeightKeywords.put("bold", 700);
        fontWeightKeywords.put("bolder", 1);
        fontWeightKeywords.put(PTSNodeTextBase.WEIGHT_LIGHTER, -1);
        fontWeightKeywords.put("100", 100);
        fontWeightKeywords.put("200", 200);
        fontWeightKeywords.put(IndividuationPlugin.Business_Font, 300);
        fontWeightKeywords.put(IndividuationPlugin.Business_Pendant, 400);
        fontWeightKeywords.put("500", 500);
        fontWeightKeywords.put(IndividuationPlugin.Business_Theme, 600);
        fontWeightKeywords.put(IndividuationPlugin.Business_Profilecard, 700);
        fontWeightKeywords.put(IndividuationPlugin.Business_Suit, 800);
        fontWeightKeywords.put("900", 900);
        fontStyleKeywords.put("normal", SVG.Style.FontStyle.Normal);
        fontStyleKeywords.put("italic", SVG.Style.FontStyle.Italic);
        fontStyleKeywords.put("oblique", SVG.Style.FontStyle.Oblique);
        aspectRatioKeywords.put("none", PreserveAspectRatio.Alignment.None);
        aspectRatioKeywords.put("xMinYMin", PreserveAspectRatio.Alignment.XMinYMin);
        aspectRatioKeywords.put("xMidYMin", PreserveAspectRatio.Alignment.XMidYMin);
        aspectRatioKeywords.put("xMaxYMin", PreserveAspectRatio.Alignment.XMaxYMin);
        aspectRatioKeywords.put("xMinYMid", PreserveAspectRatio.Alignment.XMinYMid);
        aspectRatioKeywords.put("xMidYMid", PreserveAspectRatio.Alignment.XMidYMid);
        aspectRatioKeywords.put("xMaxYMid", PreserveAspectRatio.Alignment.XMaxYMid);
        aspectRatioKeywords.put("xMinYMax", PreserveAspectRatio.Alignment.XMinYMax);
        aspectRatioKeywords.put("xMidYMax", PreserveAspectRatio.Alignment.XMidYMax);
        aspectRatioKeywords.put("xMaxYMax", PreserveAspectRatio.Alignment.XMaxYMax);
        supportedFeatures.add("Structure");
        supportedFeatures.add("BasicStructure");
        supportedFeatures.add("ConditionalProcessing");
        supportedFeatures.add("Image");
        supportedFeatures.add("Style");
        supportedFeatures.add("ViewportAttribute");
        supportedFeatures.add(ComponentFactory.ComponentType.SHAPE);
        supportedFeatures.add("BasicText");
        supportedFeatures.add("PaintAttribute");
        supportedFeatures.add("BasicPaintAttribute");
        supportedFeatures.add("OpacityAttribute");
        supportedFeatures.add("BasicGraphicsAttribute");
        supportedFeatures.add("Marker");
        supportedFeatures.add("Gradient");
        supportedFeatures.add("Pattern");
        supportedFeatures.add("Clip");
        supportedFeatures.add("BasicClip");
        supportedFeatures.add("Mask");
        supportedFeatures.add("View");
    }

    private void circle(Attributes attributes) throws SAXException {
        debug("<circle>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Circle circle = new SVG.Circle();
            circle.document = this.svgDocument;
            circle.parent = this.currentElement;
            parseAttributesCore(circle, attributes);
            parseAttributesStyle(circle, attributes);
            parseAttributesTransform(circle, attributes);
            parseAttributesConditional(circle, attributes);
            parseAttributesCircle(circle, attributes);
            this.currentElement.addChild(circle);
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private void clipPath(Attributes attributes) throws SAXException {
        debug("<clipPath>", new Object[0]);
        if (this.currentElement != null) {
            SVG.ClipPath clipPath = new SVG.ClipPath();
            clipPath.document = this.svgDocument;
            clipPath.parent = this.currentElement;
            parseAttributesCore(clipPath, attributes);
            parseAttributesStyle(clipPath, attributes);
            parseAttributesTransform(clipPath, attributes);
            parseAttributesConditional(clipPath, attributes);
            parseAttributesClipPath(clipPath, attributes);
            this.currentElement.addChild(clipPath);
            this.currentElement = clipPath;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private void defs(Attributes attributes) throws SAXException {
        debug("<defs>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Defs defs = new SVG.Defs();
            defs.document = this.svgDocument;
            defs.parent = this.currentElement;
            parseAttributesCore(defs, attributes);
            parseAttributesStyle(defs, attributes);
            parseAttributesTransform(defs, attributes);
            this.currentElement.addChild(defs);
            this.currentElement = defs;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private void dumpNode(SVG.SvgObject svgObject, String str) {
        Log.d(TAG, String.valueOf(str) + svgObject);
        if (svgObject instanceof SVG.SvgConditionalContainer) {
            String str2 = String.valueOf(str) + "  ";
            Iterator<SVG.SvgObject> it = ((SVG.SvgConditionalContainer) svgObject).children.iterator();
            while (it.hasNext()) {
                dumpNode(it.next(), str2);
            }
        }
    }

    private void ellipse(Attributes attributes) throws SAXException {
        debug("<ellipse>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Ellipse ellipse = new SVG.Ellipse();
            ellipse.document = this.svgDocument;
            ellipse.parent = this.currentElement;
            parseAttributesCore(ellipse, attributes);
            parseAttributesStyle(ellipse, attributes);
            parseAttributesTransform(ellipse, attributes);
            parseAttributesConditional(ellipse, attributes);
            parseAttributesEllipse(ellipse, attributes);
            this.currentElement.addChild(ellipse);
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private void g(Attributes attributes) throws SAXException {
        debug("<g>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Group group = new SVG.Group();
            group.document = this.svgDocument;
            group.parent = this.currentElement;
            parseAttributesCore(group, attributes);
            parseAttributesStyle(group, attributes);
            parseAttributesTransform(group, attributes);
            parseAttributesConditional(group, attributes);
            this.currentElement.addChild(group);
            this.currentElement = group;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private void image(Attributes attributes) throws SAXException {
        debug("<image>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Image image = new SVG.Image();
            image.document = this.svgDocument;
            image.parent = this.currentElement;
            parseAttributesCore(image, attributes);
            parseAttributesStyle(image, attributes);
            parseAttributesTransform(image, attributes);
            parseAttributesConditional(image, attributes);
            parseAttributesImage(image, attributes);
            this.currentElement.addChild(image);
            this.currentElement = image;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private void line(Attributes attributes) throws SAXException {
        debug("<line>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Line line = new SVG.Line();
            line.document = this.svgDocument;
            line.parent = this.currentElement;
            parseAttributesCore(line, attributes);
            parseAttributesStyle(line, attributes);
            parseAttributesTransform(line, attributes);
            parseAttributesConditional(line, attributes);
            parseAttributesLine(line, attributes);
            this.currentElement.addChild(line);
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private void linearGradient(Attributes attributes) throws SAXException {
        debug("<linearGradiant>", new Object[0]);
        if (this.currentElement != null) {
            SVG.SvgLinearGradient svgLinearGradient = new SVG.SvgLinearGradient();
            svgLinearGradient.document = this.svgDocument;
            svgLinearGradient.parent = this.currentElement;
            parseAttributesCore(svgLinearGradient, attributes);
            parseAttributesStyle(svgLinearGradient, attributes);
            parseAttributesGradient(svgLinearGradient, attributes);
            parseAttributesLinearGradient(svgLinearGradient, attributes);
            this.currentElement.addChild(svgLinearGradient);
            this.currentElement = svgLinearGradient;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private void marker(Attributes attributes) throws SAXException {
        debug("<marker>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Marker marker = new SVG.Marker();
            marker.document = this.svgDocument;
            marker.parent = this.currentElement;
            parseAttributesCore(marker, attributes);
            parseAttributesStyle(marker, attributes);
            parseAttributesConditional(marker, attributes);
            parseAttributesViewBox(marker, attributes);
            parseAttributesMarker(marker, attributes);
            this.currentElement.addChild(marker);
            this.currentElement = marker;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private void mask(Attributes attributes) throws SAXException {
        debug("<mask>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Mask mask = new SVG.Mask();
            mask.document = this.svgDocument;
            mask.parent = this.currentElement;
            parseAttributesCore(mask, attributes);
            parseAttributesStyle(mask, attributes);
            parseAttributesConditional(mask, attributes);
            parseAttributesMask(mask, attributes);
            this.currentElement.addChild(mask);
            this.currentElement = mask;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private void parseAttributesCircle(SVG.Circle circle, Attributes attributes) throws SAXException {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            int i16 = $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i3)).ordinal()];
            if (i16 != 7) {
                if (i16 != 8) {
                    if (i16 != 50) {
                        continue;
                    } else {
                        SVG.Length parseLength = parseLength(trim);
                        circle.f31949r = parseLength;
                        if (parseLength.isNegative()) {
                            throw new SAXException("Invalid <circle> element. r cannot be negative");
                        }
                    }
                } else {
                    circle.f31948cy = parseLength(trim);
                }
            } else {
                circle.f31947cx = parseLength(trim);
            }
        }
    }

    private void parseAttributesClipPath(SVG.ClipPath clipPath, Attributes attributes) throws SAXException {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            if ($SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i3)).ordinal()] == 4) {
                if ("objectBoundingBox".equals(trim)) {
                    clipPath.clipPathUnitsAreUser = Boolean.FALSE;
                } else if ("userSpaceOnUse".equals(trim)) {
                    clipPath.clipPathUnitsAreUser = Boolean.TRUE;
                } else {
                    throw new SAXException("Invalid value for attribute clipPathUnits");
                }
            }
        }
    }

    private void parseAttributesConditional(SVG.SvgConditional svgConditional, Attributes attributes) throws SAXException {
        HashSet hashSet;
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            int i16 = $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i3)).ordinal()];
            if (i16 != 74) {
                switch (i16) {
                    case 53:
                        svgConditional.setRequiredFeatures(parseRequiredFeatures(trim));
                        break;
                    case 54:
                        svgConditional.setRequiredExtensions(trim);
                        break;
                    case 55:
                        svgConditional.setRequiredFormats(parseRequiredFormats(trim));
                        break;
                    case 56:
                        List<String> parseFontFamily = parseFontFamily(trim);
                        if (parseFontFamily != null) {
                            hashSet = new HashSet(parseFontFamily);
                        } else {
                            hashSet = new HashSet(0);
                        }
                        svgConditional.setRequiredFonts(hashSet);
                        break;
                }
            } else {
                svgConditional.setSystemLanguage(parseSystemLanguage(trim));
            }
        }
    }

    private void parseAttributesCore(SVG.SvgElementBase svgElementBase, Attributes attributes) throws SAXException {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String qName = attributes.getQName(i3);
            if (!qName.equals("id") && !qName.equals("xml:id")) {
                if (qName.equals("xml:space")) {
                    String trim = attributes.getValue(i3).trim();
                    if ("default".equals(trim)) {
                        svgElementBase.spacePreserve = Boolean.FALSE;
                        return;
                    } else {
                        if ("preserve".equals(trim)) {
                            svgElementBase.spacePreserve = Boolean.TRUE;
                            return;
                        }
                        throw new SAXException("Invalid value for \"xml:space\" attribute: " + trim);
                    }
                }
            } else {
                svgElementBase.f31971id = attributes.getValue(i3).trim();
                return;
            }
        }
    }

    private void parseAttributesEllipse(SVG.Ellipse ellipse, Attributes attributes) throws SAXException {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            int i16 = $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i3)).ordinal()];
            if (i16 != 7) {
                if (i16 != 8) {
                    if (i16 != 57) {
                        if (i16 != 58) {
                            continue;
                        } else {
                            SVG.Length parseLength = parseLength(trim);
                            ellipse.f31953ry = parseLength;
                            if (parseLength.isNegative()) {
                                throw new SAXException("Invalid <ellipse> element. ry cannot be negative");
                            }
                        }
                    } else {
                        SVG.Length parseLength2 = parseLength(trim);
                        ellipse.f31952rx = parseLength2;
                        if (parseLength2.isNegative()) {
                            throw new SAXException("Invalid <ellipse> element. rx cannot be negative");
                        }
                    }
                } else {
                    ellipse.f31951cy = parseLength(trim);
                }
            } else {
                ellipse.f31950cx = parseLength(trim);
            }
        }
    }

    private void parseAttributesGradient(SVG.GradientElement gradientElement, Attributes attributes) throws SAXException {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            int i16 = $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i3)).ordinal()];
            if (i16 != 24) {
                if (i16 != 25) {
                    if (i16 != 27) {
                        if (i16 != 61) {
                            continue;
                        } else {
                            try {
                                gradientElement.spreadMethod = SVG.GradientSpread.valueOf(trim);
                            } catch (IllegalArgumentException unused) {
                                throw new SAXException("Invalid spreadMethod attribute. \"" + trim + "\" is not a valid value.");
                            }
                        }
                    } else if (XLINK_NAMESPACE.equals(attributes.getURI(i3))) {
                        gradientElement.href = trim;
                    }
                } else if ("objectBoundingBox".equals(trim)) {
                    gradientElement.gradientUnitsAreUser = Boolean.FALSE;
                } else if ("userSpaceOnUse".equals(trim)) {
                    gradientElement.gradientUnitsAreUser = Boolean.TRUE;
                } else {
                    throw new SAXException("Invalid value for attribute gradientUnits");
                }
            } else {
                gradientElement.gradientTransform = parseTransformList(trim);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0077, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void parseAttributesImage(SVG.Image image, Attributes attributes) throws SAXException {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            int i16 = $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i3)).ordinal()];
            if (i16 != 26) {
                if (i16 != 27) {
                    if (i16 != 49) {
                        switch (i16) {
                            case 82:
                                SVG.Length parseLength = parseLength(trim);
                                image.width = parseLength;
                                if (parseLength.isNegative()) {
                                    throw new SAXException("Invalid <use> element. width cannot be negative");
                                }
                                break;
                            case 83:
                                image.f31954x = parseLength(trim);
                                break;
                            case 84:
                                image.f31955y = parseLength(trim);
                                break;
                        }
                    } else {
                        parsePreserveAspectRatio(image, trim);
                    }
                } else if (XLINK_NAMESPACE.equals(attributes.getURI(i3))) {
                    image.href = trim;
                }
            } else {
                SVG.Length parseLength2 = parseLength(trim);
                image.height = parseLength2;
                if (parseLength2.isNegative()) {
                    throw new SAXException("Invalid <use> element. height cannot be negative");
                }
            }
        }
    }

    private void parseAttributesLine(SVG.Line line, Attributes attributes) throws SAXException {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            switch ($SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i3)).ordinal()]) {
                case 85:
                    line.f31956x1 = parseLength(trim);
                    break;
                case 86:
                    line.f31958y1 = parseLength(trim);
                    break;
                case 87:
                    line.f31957x2 = parseLength(trim);
                    break;
                case 88:
                    line.f31959y2 = parseLength(trim);
                    break;
            }
        }
    }

    private void parseAttributesLinearGradient(SVG.SvgLinearGradient svgLinearGradient, Attributes attributes) throws SAXException {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            switch ($SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i3)).ordinal()]) {
                case 85:
                    svgLinearGradient.f31972x1 = parseLength(trim);
                    break;
                case 86:
                    svgLinearGradient.f31974y1 = parseLength(trim);
                    break;
                case 87:
                    svgLinearGradient.f31973x2 = parseLength(trim);
                    break;
                case 88:
                    svgLinearGradient.f31975y2 = parseLength(trim);
                    break;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ac, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void parseAttributesMarker(SVG.Marker marker, Attributes attributes) throws SAXException {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            int i16 = $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i3)).ordinal()];
            if (i16 != 42) {
                if (i16 != 51) {
                    if (i16 != 52) {
                        switch (i16) {
                            case 33:
                                SVG.Length parseLength = parseLength(trim);
                                marker.markerHeight = parseLength;
                                if (parseLength.isNegative()) {
                                    throw new SAXException("Invalid <marker> element. markerHeight cannot be negative");
                                }
                                break;
                            case 34:
                                if ("strokeWidth".equals(trim)) {
                                    marker.markerUnitsAreUser = false;
                                    break;
                                } else if ("userSpaceOnUse".equals(trim)) {
                                    marker.markerUnitsAreUser = true;
                                    break;
                                } else {
                                    throw new SAXException("Invalid value for attribute markerUnits");
                                }
                            case 35:
                                SVG.Length parseLength2 = parseLength(trim);
                                marker.markerWidth = parseLength2;
                                if (parseLength2.isNegative()) {
                                    throw new SAXException("Invalid <marker> element. markerWidth cannot be negative");
                                }
                                break;
                        }
                    } else {
                        marker.refY = parseLength(trim);
                    }
                } else {
                    marker.refX = parseLength(trim);
                }
            } else if ("auto".equals(trim)) {
                marker.orient = Float.valueOf(Float.NaN);
            } else {
                marker.orient = Float.valueOf(parseFloat(trim));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a7, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void parseAttributesMask(SVG.Mask mask, Attributes attributes) throws SAXException {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            int i16 = $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i3)).ordinal()];
            if (i16 != 26) {
                if (i16 != 37) {
                    if (i16 != 38) {
                        switch (i16) {
                            case 82:
                                SVG.Length parseLength = parseLength(trim);
                                mask.width = parseLength;
                                if (parseLength.isNegative()) {
                                    throw new SAXException("Invalid <mask> element. width cannot be negative");
                                }
                                break;
                            case 83:
                                mask.f31960x = parseLength(trim);
                                break;
                            case 84:
                                mask.f31961y = parseLength(trim);
                                break;
                        }
                    } else if ("objectBoundingBox".equals(trim)) {
                        mask.maskUnitsAreUser = Boolean.FALSE;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        mask.maskUnitsAreUser = Boolean.TRUE;
                    } else {
                        throw new SAXException("Invalid value for attribute maskUnits");
                    }
                } else if ("objectBoundingBox".equals(trim)) {
                    mask.maskContentUnitsAreUser = Boolean.FALSE;
                } else if ("userSpaceOnUse".equals(trim)) {
                    mask.maskContentUnitsAreUser = Boolean.TRUE;
                } else {
                    throw new SAXException("Invalid value for attribute maskContentUnits");
                }
            } else {
                SVG.Length parseLength2 = parseLength(trim);
                mask.height = parseLength2;
                if (parseLength2.isNegative()) {
                    throw new SAXException("Invalid <mask> element. height cannot be negative");
                }
            }
        }
    }

    private void parseAttributesPath(SVG.Path path, Attributes attributes) throws SAXException {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            int i16 = $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i3)).ordinal()];
            if (i16 != 14) {
                if (i16 != 44) {
                    continue;
                } else {
                    Float valueOf = Float.valueOf(parseFloat(trim));
                    path.pathLength = valueOf;
                    if (valueOf.floatValue() < 0.0f) {
                        throw new SAXException("Invalid <path> element. pathLength cannot be negative");
                    }
                }
            } else {
                path.f31962d = parsePath(trim);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00c0, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void parseAttributesPattern(SVG.Pattern pattern, Attributes attributes) throws SAXException {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            int i16 = $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i3)).ordinal()];
            if (i16 != 26) {
                if (i16 != 27) {
                    switch (i16) {
                        case 45:
                            if ("objectBoundingBox".equals(trim)) {
                                pattern.patternContentUnitsAreUser = Boolean.FALSE;
                                break;
                            } else if ("userSpaceOnUse".equals(trim)) {
                                pattern.patternContentUnitsAreUser = Boolean.TRUE;
                                break;
                            } else {
                                throw new SAXException("Invalid value for attribute patternContentUnits");
                            }
                        case 46:
                            pattern.patternTransform = parseTransformList(trim);
                            break;
                        case 47:
                            if ("objectBoundingBox".equals(trim)) {
                                pattern.patternUnitsAreUser = Boolean.FALSE;
                                break;
                            } else if ("userSpaceOnUse".equals(trim)) {
                                pattern.patternUnitsAreUser = Boolean.TRUE;
                                break;
                            } else {
                                throw new SAXException("Invalid value for attribute patternUnits");
                            }
                        default:
                            switch (i16) {
                                case 82:
                                    SVG.Length parseLength = parseLength(trim);
                                    pattern.width = parseLength;
                                    if (parseLength.isNegative()) {
                                        throw new SAXException("Invalid <pattern> element. width cannot be negative");
                                    }
                                    break;
                                case 83:
                                    pattern.f31963x = parseLength(trim);
                                    break;
                                case 84:
                                    pattern.f31964y = parseLength(trim);
                                    break;
                            }
                    }
                } else if (XLINK_NAMESPACE.equals(attributes.getURI(i3))) {
                    pattern.href = trim;
                }
            } else {
                SVG.Length parseLength2 = parseLength(trim);
                pattern.height = parseLength2;
                if (parseLength2.isNegative()) {
                    throw new SAXException("Invalid <pattern> element. height cannot be negative");
                }
            }
        }
    }

    private void parseAttributesPolyLine(SVG.PolyLine polyLine, Attributes attributes, String str) throws SAXException {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            if (SVGAttr.fromString(attributes.getLocalName(i3)) == SVGAttr.points) {
                TextScanner textScanner = new TextScanner(attributes.getValue(i3));
                ArrayList arrayList = new ArrayList();
                textScanner.skipWhitespace();
                while (!textScanner.empty()) {
                    Float nextFloat = textScanner.nextFloat();
                    if (nextFloat != null) {
                        textScanner.skipCommaWhitespace();
                        Float nextFloat2 = textScanner.nextFloat();
                        if (nextFloat2 != null) {
                            textScanner.skipCommaWhitespace();
                            arrayList.add(nextFloat);
                            arrayList.add(nextFloat2);
                        } else {
                            throw new SAXException("Invalid <" + str + "> points attribute. There should be an even number of coordinates.");
                        }
                    } else {
                        throw new SAXException("Invalid <" + str + "> points attribute. Non-coordinate content found in list.");
                    }
                }
                polyLine.points = new float[arrayList.size()];
                Iterator it = arrayList.iterator();
                int i16 = 0;
                while (it.hasNext()) {
                    polyLine.points[i16] = ((Float) it.next()).floatValue();
                    i16++;
                }
            }
        }
    }

    private void parseAttributesRadialGradient(SVG.SvgRadialGradient svgRadialGradient, Attributes attributes) throws SAXException {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            int i16 = $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i3)).ordinal()];
            if (i16 != 7) {
                if (i16 != 8) {
                    if (i16 != 12) {
                        if (i16 != 13) {
                            if (i16 != 50) {
                                continue;
                            } else {
                                SVG.Length parseLength = parseLength(trim);
                                svgRadialGradient.f31980r = parseLength;
                                if (parseLength.isNegative()) {
                                    throw new SAXException("Invalid <radialGradient> element. r cannot be negative");
                                }
                            }
                        } else {
                            svgRadialGradient.f31979fy = parseLength(trim);
                        }
                    } else {
                        svgRadialGradient.f31978fx = parseLength(trim);
                    }
                } else {
                    svgRadialGradient.f31977cy = parseLength(trim);
                }
            } else {
                svgRadialGradient.f31976cx = parseLength(trim);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x008e, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void parseAttributesRect(SVG.Rect rect, Attributes attributes) throws SAXException {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            int i16 = $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i3)).ordinal()];
            if (i16 != 26) {
                if (i16 != 57) {
                    if (i16 != 58) {
                        switch (i16) {
                            case 82:
                                SVG.Length parseLength = parseLength(trim);
                                rect.width = parseLength;
                                if (parseLength.isNegative()) {
                                    throw new SAXException("Invalid <rect> element. width cannot be negative");
                                }
                                break;
                            case 83:
                                rect.f31967x = parseLength(trim);
                                break;
                            case 84:
                                rect.f31968y = parseLength(trim);
                                break;
                        }
                    } else {
                        SVG.Length parseLength2 = parseLength(trim);
                        rect.f31966ry = parseLength2;
                        if (parseLength2.isNegative()) {
                            throw new SAXException("Invalid <rect> element. ry cannot be negative");
                        }
                    }
                } else {
                    SVG.Length parseLength3 = parseLength(trim);
                    rect.f31965rx = parseLength3;
                    if (parseLength3.isNegative()) {
                        throw new SAXException("Invalid <rect> element. rx cannot be negative");
                    }
                }
            } else {
                SVG.Length parseLength4 = parseLength(trim);
                rect.height = parseLength4;
                if (parseLength4.isNegative()) {
                    throw new SAXException("Invalid <rect> element. height cannot be negative");
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0061, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void parseAttributesSVG(SVG.Svg svg, Attributes attributes) throws SAXException {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            int i16 = $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i3)).ordinal()];
            if (i16 != 26) {
                if (i16 != 80) {
                    switch (i16) {
                        case 82:
                            SVG.Length parseLength = parseLength(trim);
                            svg.width = parseLength;
                            if (parseLength.isNegative()) {
                                throw new SAXException("Invalid <svg> element. width cannot be negative");
                            }
                            break;
                        case 83:
                            svg.f31969x = parseLength(trim);
                            break;
                        case 84:
                            svg.f31970y = parseLength(trim);
                            break;
                    }
                } else {
                    svg.version = trim;
                }
            } else {
                SVG.Length parseLength2 = parseLength(trim);
                svg.height = parseLength2;
                if (parseLength2.isNegative()) {
                    throw new SAXException("Invalid <svg> element. height cannot be negative");
                }
            }
        }
    }

    private void parseAttributesStop(SVG.Stop stop, Attributes attributes) throws SAXException {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            if ($SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i3)).ordinal()] == 40) {
                stop.offset = parseGradiantOffset(trim);
            }
        }
    }

    private void parseAttributesStyle(SVG.SvgElementBase svgElementBase, Attributes attributes) throws SAXException {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            if (trim.length() != 0) {
                int i16 = $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i3)).ordinal()];
                if (i16 != 1) {
                    if (i16 != 73) {
                        if (svgElementBase.baseStyle == null) {
                            svgElementBase.baseStyle = new SVG.Style();
                        }
                        processStyleProperty(svgElementBase.baseStyle, attributes.getLocalName(i3), attributes.getValue(i3).trim());
                    } else {
                        parseStyle(svgElementBase, trim);
                    }
                } else {
                    svgElementBase.classNames = CSSParser.parseClassAttribute(trim);
                }
            }
        }
    }

    private void parseAttributesTRef(SVG.TRef tRef, Attributes attributes) throws SAXException {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            if ($SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i3)).ordinal()] == 27 && XLINK_NAMESPACE.equals(attributes.getURI(i3))) {
                tRef.href = trim;
            }
        }
    }

    private void parseAttributesTextPath(SVG.TextPath textPath, Attributes attributes) throws SAXException {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            int i16 = $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i3)).ordinal()];
            if (i16 != 27) {
                if (i16 == 62) {
                    textPath.startOffset = parseLength(trim);
                }
            } else if (XLINK_NAMESPACE.equals(attributes.getURI(i3))) {
                textPath.href = trim;
            }
        }
    }

    private void parseAttributesTextPosition(SVG.TextPositionedContainer textPositionedContainer, Attributes attributes) throws SAXException {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            int i16 = $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i3)).ordinal()];
            if (i16 != 10) {
                if (i16 != 11) {
                    if (i16 != 83) {
                        if (i16 == 84) {
                            textPositionedContainer.f31984y = parseLengthList(trim);
                        }
                    } else {
                        textPositionedContainer.f31983x = parseLengthList(trim);
                    }
                } else {
                    textPositionedContainer.f31982dy = parseLengthList(trim);
                }
            } else {
                textPositionedContainer.f31981dx = parseLengthList(trim);
            }
        }
    }

    private void parseAttributesTransform(SVG.HasTransform hasTransform, Attributes attributes) throws SAXException {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            if (SVGAttr.fromString(attributes.getLocalName(i3)) == SVGAttr.transform) {
                hasTransform.setTransform(parseTransformList(attributes.getValue(i3)));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x006f, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void parseAttributesUse(SVG.Use use, Attributes attributes) throws SAXException {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            int i16 = $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i3)).ordinal()];
            if (i16 != 26) {
                if (i16 != 27) {
                    switch (i16) {
                        case 82:
                            SVG.Length parseLength = parseLength(trim);
                            use.width = parseLength;
                            if (parseLength.isNegative()) {
                                throw new SAXException("Invalid <use> element. width cannot be negative");
                            }
                            break;
                        case 83:
                            use.f31993x = parseLength(trim);
                            break;
                        case 84:
                            use.f31994y = parseLength(trim);
                            break;
                    }
                } else if (XLINK_NAMESPACE.equals(attributes.getURI(i3))) {
                    use.href = trim;
                }
            } else {
                SVG.Length parseLength2 = parseLength(trim);
                use.height = parseLength2;
                if (parseLength2.isNegative()) {
                    throw new SAXException("Invalid <use> element. height cannot be negative");
                }
            }
        }
    }

    private void parseAttributesViewBox(SVG.SvgViewBoxContainer svgViewBoxContainer, Attributes attributes) throws SAXException {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            int i16 = $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i3)).ordinal()];
            if (i16 != 49) {
                if (i16 == 81) {
                    svgViewBoxContainer.viewBox = parseViewBox(trim);
                }
            } else {
                parsePreserveAspectRatio(svgViewBoxContainer, trim);
            }
        }
    }

    private void parseCSSStyleSheet(String str) throws SAXException {
        this.svgDocument.addCSSRules(new CSSParser(CSSParser.MediaType.screen).parse(str));
    }

    private static SVG.CSSClipRect parseClip(String str) throws SAXException {
        if ("auto".equals(str)) {
            return null;
        }
        if (str.toLowerCase(Locale.US).startsWith("rect(")) {
            TextScanner textScanner = new TextScanner(str.substring(5));
            textScanner.skipWhitespace();
            SVG.Length parseLengthOrAuto = parseLengthOrAuto(textScanner);
            textScanner.skipCommaWhitespace();
            SVG.Length parseLengthOrAuto2 = parseLengthOrAuto(textScanner);
            textScanner.skipCommaWhitespace();
            SVG.Length parseLengthOrAuto3 = parseLengthOrAuto(textScanner);
            textScanner.skipCommaWhitespace();
            SVG.Length parseLengthOrAuto4 = parseLengthOrAuto(textScanner);
            textScanner.skipWhitespace();
            if (textScanner.consume(')')) {
                return new SVG.CSSClipRect(parseLengthOrAuto, parseLengthOrAuto2, parseLengthOrAuto3, parseLengthOrAuto4);
            }
            throw new SAXException("Bad rect() clip definition: " + str);
        }
        throw new SAXException("Invalid clip attribute shape. Only rect() is supported.");
    }

    private static SVG.Colour parseColour(String str) throws SAXException {
        if (str.charAt(0) == '#') {
            try {
                if (str.length() == 7) {
                    return new SVG.Colour(Integer.parseInt(str.substring(1), 16));
                }
                if (str.length() == 4) {
                    int parseInt = Integer.parseInt(str.substring(1), 16);
                    int i3 = parseInt & 3840;
                    int i16 = parseInt & 240;
                    int i17 = parseInt & 15;
                    return new SVG.Colour(i17 | (i3 << 12) | (i3 << 16) | (i16 << 8) | (i16 << 4) | (i17 << 4));
                }
                throw new SAXException("Bad hex colour value: " + str);
            } catch (NumberFormatException unused) {
                throw new SAXException("Bad colour value: " + str);
            }
        }
        if (str.toLowerCase(Locale.US).startsWith("rgb(")) {
            TextScanner textScanner = new TextScanner(str.substring(4));
            textScanner.skipWhitespace();
            int parseColourComponent = parseColourComponent(textScanner);
            textScanner.skipCommaWhitespace();
            int parseColourComponent2 = parseColourComponent(textScanner);
            textScanner.skipCommaWhitespace();
            int parseColourComponent3 = parseColourComponent(textScanner);
            textScanner.skipWhitespace();
            if (textScanner.consume(')')) {
                return new SVG.Colour((parseColourComponent << 16) | (parseColourComponent2 << 8) | parseColourComponent3);
            }
            throw new SAXException("Bad rgb() colour value: " + str);
        }
        return parseColourKeyword(str);
    }

    private static int parseColourComponent(TextScanner textScanner) throws SAXException {
        float floatValue = textScanner.nextFloat().floatValue();
        if (textScanner.consume('%')) {
            floatValue = (floatValue * 256.0f) / 100.0f;
        }
        if (floatValue < 0.0f) {
            return 0;
        }
        if (floatValue > 255.0f) {
            return 255;
        }
        return (int) floatValue;
    }

    private static SVG.Colour parseColourKeyword(String str) throws SAXException {
        Integer num = colourKeywords.get(str.toLowerCase(Locale.US));
        if (num != null) {
            return new SVG.Colour(num.intValue());
        }
        throw new SAXException("Invalid colour keyword: " + str);
    }

    private static SVG.SvgPaint parseColourSpecifer(String str) throws SAXException {
        if (str.equals("none")) {
            return null;
        }
        if (str.equals(CURRENTCOLOR)) {
            return SVG.CurrentColor.getInstance();
        }
        return parseColour(str);
    }

    private static SVG.Style.FillRule parseFillRule(String str) throws SAXException {
        if ("nonzero".equals(str)) {
            return SVG.Style.FillRule.NonZero;
        }
        if ("evenodd".equals(str)) {
            return SVG.Style.FillRule.EvenOdd;
        }
        throw new SAXException("Invalid fill-rule property: " + str);
    }

    private static float parseFloat(String str) throws SAXException {
        if (str.length() != 0) {
            try {
                return Float.parseFloat(str);
            } catch (NumberFormatException e16) {
                throw new SAXException("Invalid float value: " + str, e16);
            }
        }
        throw new SAXException("Invalid float value (empty string)");
    }

    private static void parseFont(SVG.Style style, String str) throws SAXException {
        String nextToken;
        int intValue;
        if ("|caption|icon|menu|message-box|small-caption|status-bar|".indexOf(String.valueOf(QbAddrData.DATA_SPLITER) + str + QbAddrData.DATA_SPLITER) != -1) {
            return;
        }
        TextScanner textScanner = new TextScanner(str);
        Integer num = null;
        SVG.Style.FontStyle fontStyle = null;
        String str2 = null;
        while (true) {
            nextToken = textScanner.nextToken('/');
            textScanner.skipWhitespace();
            if (nextToken != null) {
                if (num != null && fontStyle != null) {
                    break;
                }
                if (!nextToken.equals("normal") && (num != null || (num = fontWeightKeywords.get(nextToken)) == null)) {
                    if (fontStyle != null || (fontStyle = fontStyleKeywords.get(nextToken)) == null) {
                        if (str2 != null || !nextToken.equals("small-caps")) {
                            break;
                        } else {
                            str2 = nextToken;
                        }
                    }
                }
            } else {
                throw new SAXException("Invalid font style attribute: missing font size and family");
            }
        }
        SVG.Length parseFontSize = parseFontSize(nextToken);
        if (textScanner.consume('/')) {
            textScanner.skipWhitespace();
            String nextToken2 = textScanner.nextToken();
            if (nextToken2 != null) {
                parseLength(nextToken2);
                textScanner.skipWhitespace();
            } else {
                throw new SAXException("Invalid font style attribute: missing line-height");
            }
        }
        style.fontFamily = parseFontFamily(textScanner.restOfText());
        style.fontSize = parseFontSize;
        if (num == null) {
            intValue = 400;
        } else {
            intValue = num.intValue();
        }
        style.fontWeight = Integer.valueOf(intValue);
        if (fontStyle == null) {
            fontStyle = SVG.Style.FontStyle.Normal;
        }
        style.fontStyle = fontStyle;
        style.specifiedFlags |= 122880;
    }

    private static List<String> parseFontFamily(String str) throws SAXException {
        TextScanner textScanner = new TextScanner(str);
        ArrayList arrayList = null;
        do {
            String nextQuotedString = textScanner.nextQuotedString();
            if (nextQuotedString == null) {
                nextQuotedString = textScanner.nextToken(',');
            }
            if (nextQuotedString == null) {
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(nextQuotedString);
            textScanner.skipCommaWhitespace();
        } while (!textScanner.empty());
        return arrayList;
    }

    private static SVG.Length parseFontSize(String str) throws SAXException {
        SVG.Length length = fontSizeKeywords.get(str);
        if (length == null) {
            return parseLength(str);
        }
        return length;
    }

    private static SVG.Style.FontStyle parseFontStyle(String str) throws SAXException {
        SVG.Style.FontStyle fontStyle = fontStyleKeywords.get(str);
        if (fontStyle != null) {
            return fontStyle;
        }
        throw new SAXException("Invalid font-style property: " + str);
    }

    private static Integer parseFontWeight(String str) throws SAXException {
        Integer num = fontWeightKeywords.get(str);
        if (num != null) {
            return num;
        }
        throw new SAXException("Invalid font-weight property: " + str);
    }

    private static String parseFunctionalIRI(String str, String str2) throws SAXException {
        if (str.equals("none")) {
            return null;
        }
        if (str.startsWith("url(") && str.endsWith(")")) {
            return str.substring(4, str.length() - 1).trim();
        }
        throw new SAXException("Bad " + str2 + " attribute. Expected \"none\" or \"url()\" format");
    }

    private Float parseGradiantOffset(String str) throws SAXException {
        if (str.length() != 0) {
            int length = str.length();
            boolean z16 = true;
            if (str.charAt(str.length() - 1) == '%') {
                length--;
            } else {
                z16 = false;
            }
            try {
                float parseFloat = Float.parseFloat(str.substring(0, length));
                float f16 = 100.0f;
                if (z16) {
                    parseFloat /= 100.0f;
                }
                if (parseFloat < 0.0f) {
                    f16 = 0.0f;
                } else if (parseFloat <= 100.0f) {
                    f16 = parseFloat;
                }
                return Float.valueOf(f16);
            } catch (NumberFormatException e16) {
                throw new SAXException("Invalid offset value in <stop>: " + str, e16);
            }
        }
        throw new SAXException("Invalid offset value in <stop> (empty string)");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static SVG.Length parseLength(String str) throws SAXException {
        if (str.length() != 0) {
            int length = str.length();
            SVG.Unit unit = SVG.Unit.px;
            char charAt = str.charAt(length - 1);
            if (charAt == '%') {
                length--;
                unit = SVG.Unit.percent;
            } else if (length > 2 && Character.isLetter(charAt) && Character.isLetter(str.charAt(length - 2))) {
                length -= 2;
                try {
                    unit = SVG.Unit.valueOf(str.substring(length).toLowerCase(Locale.US));
                } catch (IllegalArgumentException unused) {
                    throw new SAXException("Invalid length unit specifier: " + str);
                }
            }
            try {
                return new SVG.Length(Float.parseFloat(str.substring(0, length)), unit);
            } catch (NumberFormatException e16) {
                throw new SAXException("Invalid length value: " + str, e16);
            }
        }
        throw new SAXException("Invalid length value (empty string)");
    }

    private static List<SVG.Length> parseLengthList(String str) throws SAXException {
        if (str.length() != 0) {
            ArrayList arrayList = new ArrayList(1);
            TextScanner textScanner = new TextScanner(str);
            textScanner.skipWhitespace();
            while (!textScanner.empty()) {
                Float nextFloat = textScanner.nextFloat();
                if (nextFloat != null) {
                    SVG.Unit nextUnit = textScanner.nextUnit();
                    if (nextUnit == null) {
                        nextUnit = SVG.Unit.px;
                    }
                    arrayList.add(new SVG.Length(nextFloat.floatValue(), nextUnit));
                    textScanner.skipCommaWhitespace();
                } else {
                    throw new SAXException("Invalid length list value: " + textScanner.ahead());
                }
            }
            return arrayList;
        }
        throw new SAXException("Invalid length list (empty string)");
    }

    private static SVG.Length parseLengthOrAuto(TextScanner textScanner) {
        if (textScanner.consume("auto")) {
            return new SVG.Length(0.0f);
        }
        return textScanner.nextLength();
    }

    private static float parseOpacity(String str) throws SAXException {
        float parseFloat = parseFloat(str);
        float f16 = 0.0f;
        if (parseFloat >= 0.0f) {
            f16 = 1.0f;
            if (parseFloat <= 1.0f) {
                return parseFloat;
            }
        }
        return f16;
    }

    private static Boolean parseOverflow(String str) throws SAXException {
        if (!NodeProps.VISIBLE.equals(str) && !"auto".equals(str)) {
            if (!"hidden".equals(str) && !"scroll".equals(str)) {
                throw new SAXException("Invalid toverflow property: " + str);
            }
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    private static SVG.SvgPaint parsePaintSpecifier(String str, String str2) throws SAXException {
        SVG.SvgPaint svgPaint;
        if (str.startsWith("url(")) {
            int indexOf = str.indexOf(")");
            if (indexOf != -1) {
                String trim = str.substring(4, indexOf).trim();
                String trim2 = str.substring(indexOf + 1).trim();
                if (trim2.length() > 0) {
                    svgPaint = parseColourSpecifer(trim2);
                } else {
                    svgPaint = null;
                }
                return new SVG.PaintReference(trim, svgPaint);
            }
            throw new SAXException("Bad " + str2 + " attribute. Unterminated url() reference");
        }
        return parseColourSpecifer(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:112:0x03ef, code lost:
    
        return r9;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x003b. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:17:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x03c9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static SVG.PathDefinition parsePath(String str) throws SAXException {
        TextScanner textScanner = new TextScanner(str);
        SVG.PathDefinition pathDefinition = new SVG.PathDefinition();
        if (textScanner.empty()) {
            return pathDefinition;
        }
        int intValue = textScanner.nextChar().intValue();
        int i3 = 109;
        if (intValue != 77 && intValue != 109) {
            return pathDefinition;
        }
        int i16 = intValue;
        float f16 = 0.0f;
        float f17 = 0.0f;
        float f18 = 0.0f;
        float f19 = 0.0f;
        float f26 = 0.0f;
        float f27 = 0.0f;
        while (true) {
            textScanner.skipWhitespace();
            int i17 = 108;
            switch (i16) {
                case 65:
                case 97:
                    Float nextFloat = textScanner.nextFloat();
                    Float checkedNextFloat = textScanner.checkedNextFloat(nextFloat);
                    Float checkedNextFloat2 = textScanner.checkedNextFloat(checkedNextFloat);
                    Boolean checkedNextFlag = textScanner.checkedNextFlag(checkedNextFloat2);
                    Boolean checkedNextFlag2 = textScanner.checkedNextFlag(checkedNextFlag);
                    Float checkedNextFloat3 = textScanner.checkedNextFloat(checkedNextFlag2);
                    Float checkedNextFloat4 = textScanner.checkedNextFloat(checkedNextFloat3);
                    if (checkedNextFloat4 != null && nextFloat.floatValue() >= 0.0f && checkedNextFloat.floatValue() >= 0.0f) {
                        if (i16 == 97) {
                            checkedNextFloat3 = Float.valueOf(checkedNextFloat3.floatValue() + f16);
                            checkedNextFloat4 = Float.valueOf(checkedNextFloat4.floatValue() + f18);
                        }
                        pathDefinition.arcTo(nextFloat.floatValue(), checkedNextFloat.floatValue(), checkedNextFloat2.floatValue(), checkedNextFlag.booleanValue(), checkedNextFlag2.booleanValue(), checkedNextFloat3.floatValue(), checkedNextFloat4.floatValue());
                        f16 = checkedNextFloat3.floatValue();
                        f18 = checkedNextFloat4.floatValue();
                        f17 = f16;
                        f19 = f18;
                        textScanner.skipCommaWhitespace();
                        if (!textScanner.empty()) {
                            return pathDefinition;
                        }
                        if (textScanner.hasLetter()) {
                            i16 = textScanner.nextChar().intValue();
                        }
                        i3 = 109;
                    }
                    break;
                case 67:
                case 99:
                    Float nextFloat2 = textScanner.nextFloat();
                    Float checkedNextFloat5 = textScanner.checkedNextFloat(nextFloat2);
                    Float checkedNextFloat6 = textScanner.checkedNextFloat(checkedNextFloat5);
                    Float checkedNextFloat7 = textScanner.checkedNextFloat(checkedNextFloat6);
                    Float checkedNextFloat8 = textScanner.checkedNextFloat(checkedNextFloat7);
                    Float checkedNextFloat9 = textScanner.checkedNextFloat(checkedNextFloat8);
                    if (checkedNextFloat9 == null) {
                        Log.e(TAG, "Bad path coords for " + ((char) i16) + " path segment");
                        return pathDefinition;
                    }
                    if (i16 == 99) {
                        checkedNextFloat8 = Float.valueOf(checkedNextFloat8.floatValue() + f16);
                        checkedNextFloat9 = Float.valueOf(checkedNextFloat9.floatValue() + f18);
                        nextFloat2 = Float.valueOf(nextFloat2.floatValue() + f16);
                        checkedNextFloat5 = Float.valueOf(checkedNextFloat5.floatValue() + f18);
                        checkedNextFloat6 = Float.valueOf(checkedNextFloat6.floatValue() + f16);
                        checkedNextFloat7 = Float.valueOf(checkedNextFloat7.floatValue() + f18);
                    }
                    Float f28 = checkedNextFloat6;
                    Float f29 = checkedNextFloat8;
                    Float f36 = checkedNextFloat7;
                    pathDefinition.cubicTo(nextFloat2.floatValue(), checkedNextFloat5.floatValue(), f28.floatValue(), f36.floatValue(), f29.floatValue(), checkedNextFloat9.floatValue());
                    f17 = f28.floatValue();
                    f19 = f36.floatValue();
                    f16 = f29.floatValue();
                    f18 = checkedNextFloat9.floatValue();
                    textScanner.skipCommaWhitespace();
                    if (!textScanner.empty()) {
                    }
                    break;
                case 72:
                case 104:
                    Float nextFloat3 = textScanner.nextFloat();
                    if (nextFloat3 == null) {
                        Log.e(TAG, "Bad path coords for " + ((char) i16) + " path segment");
                        return pathDefinition;
                    }
                    if (i16 == 104) {
                        nextFloat3 = Float.valueOf(nextFloat3.floatValue() + f16);
                    }
                    pathDefinition.lineTo(nextFloat3.floatValue(), f18);
                    f16 = nextFloat3.floatValue();
                    f17 = f16;
                    textScanner.skipCommaWhitespace();
                    if (!textScanner.empty()) {
                    }
                    break;
                case 76:
                case 108:
                    Float nextFloat4 = textScanner.nextFloat();
                    Float checkedNextFloat10 = textScanner.checkedNextFloat(nextFloat4);
                    if (checkedNextFloat10 == null) {
                        Log.e(TAG, "Bad path coords for " + ((char) i16) + " path segment");
                        return pathDefinition;
                    }
                    if (i16 == 108) {
                        nextFloat4 = Float.valueOf(nextFloat4.floatValue() + f16);
                        checkedNextFloat10 = Float.valueOf(checkedNextFloat10.floatValue() + f18);
                    }
                    pathDefinition.lineTo(nextFloat4.floatValue(), checkedNextFloat10.floatValue());
                    f16 = nextFloat4.floatValue();
                    f18 = checkedNextFloat10.floatValue();
                    f17 = f16;
                    f19 = f18;
                    textScanner.skipCommaWhitespace();
                    if (!textScanner.empty()) {
                    }
                    break;
                case 77:
                case 109:
                    Float nextFloat5 = textScanner.nextFloat();
                    Float checkedNextFloat11 = textScanner.checkedNextFloat(nextFloat5);
                    if (checkedNextFloat11 == null) {
                        Log.e(TAG, "Bad path coords for " + ((char) i16) + " path segment");
                        return pathDefinition;
                    }
                    if (i16 == i3 && !pathDefinition.isEmpty()) {
                        nextFloat5 = Float.valueOf(nextFloat5.floatValue() + f16);
                        checkedNextFloat11 = Float.valueOf(checkedNextFloat11.floatValue() + f18);
                    }
                    pathDefinition.moveTo(nextFloat5.floatValue(), checkedNextFloat11.floatValue());
                    f16 = nextFloat5.floatValue();
                    f18 = checkedNextFloat11.floatValue();
                    if (i16 != i3) {
                        i17 = 76;
                    }
                    f17 = f16;
                    f26 = f17;
                    f19 = f18;
                    f27 = f19;
                    i16 = i17;
                    textScanner.skipCommaWhitespace();
                    if (!textScanner.empty()) {
                    }
                    break;
                case 81:
                case 113:
                    Float nextFloat6 = textScanner.nextFloat();
                    Float checkedNextFloat12 = textScanner.checkedNextFloat(nextFloat6);
                    Float checkedNextFloat13 = textScanner.checkedNextFloat(checkedNextFloat12);
                    Float checkedNextFloat14 = textScanner.checkedNextFloat(checkedNextFloat13);
                    if (checkedNextFloat14 == null) {
                        Log.e(TAG, "Bad path coords for " + ((char) i16) + " path segment");
                        return pathDefinition;
                    }
                    if (i16 == 113) {
                        checkedNextFloat13 = Float.valueOf(checkedNextFloat13.floatValue() + f16);
                        checkedNextFloat14 = Float.valueOf(checkedNextFloat14.floatValue() + f18);
                        nextFloat6 = Float.valueOf(nextFloat6.floatValue() + f16);
                        checkedNextFloat12 = Float.valueOf(checkedNextFloat12.floatValue() + f18);
                    }
                    pathDefinition.quadTo(nextFloat6.floatValue(), checkedNextFloat12.floatValue(), checkedNextFloat13.floatValue(), checkedNextFloat14.floatValue());
                    f17 = nextFloat6.floatValue();
                    f19 = checkedNextFloat12.floatValue();
                    f16 = checkedNextFloat13.floatValue();
                    f18 = checkedNextFloat14.floatValue();
                    textScanner.skipCommaWhitespace();
                    if (!textScanner.empty()) {
                    }
                    break;
                case 83:
                case 115:
                    Float valueOf = Float.valueOf((f16 * 2.0f) - f17);
                    Float valueOf2 = Float.valueOf((2.0f * f18) - f19);
                    Float nextFloat7 = textScanner.nextFloat();
                    Float checkedNextFloat15 = textScanner.checkedNextFloat(nextFloat7);
                    Float checkedNextFloat16 = textScanner.checkedNextFloat(checkedNextFloat15);
                    Float checkedNextFloat17 = textScanner.checkedNextFloat(checkedNextFloat16);
                    if (checkedNextFloat17 == null) {
                        Log.e(TAG, "Bad path coords for " + ((char) i16) + " path segment");
                        return pathDefinition;
                    }
                    if (i16 == 115) {
                        checkedNextFloat16 = Float.valueOf(checkedNextFloat16.floatValue() + f16);
                        checkedNextFloat17 = Float.valueOf(checkedNextFloat17.floatValue() + f18);
                        nextFloat7 = Float.valueOf(nextFloat7.floatValue() + f16);
                        checkedNextFloat15 = Float.valueOf(checkedNextFloat15.floatValue() + f18);
                    }
                    Float f37 = nextFloat7;
                    Float f38 = checkedNextFloat16;
                    Float f39 = checkedNextFloat15;
                    pathDefinition.cubicTo(valueOf.floatValue(), valueOf2.floatValue(), f37.floatValue(), f39.floatValue(), f38.floatValue(), checkedNextFloat17.floatValue());
                    f17 = f37.floatValue();
                    f19 = f39.floatValue();
                    f16 = f38.floatValue();
                    f18 = checkedNextFloat17.floatValue();
                    textScanner.skipCommaWhitespace();
                    if (!textScanner.empty()) {
                    }
                    break;
                case 84:
                case 116:
                    Float valueOf3 = Float.valueOf((f16 * 2.0f) - f17);
                    Float valueOf4 = Float.valueOf((2.0f * f18) - f19);
                    Float nextFloat8 = textScanner.nextFloat();
                    Float checkedNextFloat18 = textScanner.checkedNextFloat(nextFloat8);
                    if (checkedNextFloat18 == null) {
                        Log.e(TAG, "Bad path coords for " + ((char) i16) + " path segment");
                        return pathDefinition;
                    }
                    if (i16 == 116) {
                        nextFloat8 = Float.valueOf(nextFloat8.floatValue() + f16);
                        checkedNextFloat18 = Float.valueOf(checkedNextFloat18.floatValue() + f18);
                    }
                    pathDefinition.quadTo(valueOf3.floatValue(), valueOf4.floatValue(), nextFloat8.floatValue(), checkedNextFloat18.floatValue());
                    f17 = valueOf3.floatValue();
                    f19 = valueOf4.floatValue();
                    f16 = nextFloat8.floatValue();
                    f18 = checkedNextFloat18.floatValue();
                    textScanner.skipCommaWhitespace();
                    if (!textScanner.empty()) {
                    }
                    break;
                case 86:
                case 118:
                    Float nextFloat9 = textScanner.nextFloat();
                    if (nextFloat9 == null) {
                        Log.e(TAG, "Bad path coords for " + ((char) i16) + " path segment");
                        return pathDefinition;
                    }
                    if (i16 == 118) {
                        nextFloat9 = Float.valueOf(nextFloat9.floatValue() + f18);
                    }
                    pathDefinition.lineTo(f16, nextFloat9.floatValue());
                    f18 = nextFloat9.floatValue();
                    f19 = f18;
                    textScanner.skipCommaWhitespace();
                    if (!textScanner.empty()) {
                    }
                    break;
                case 90:
                case 122:
                    pathDefinition.close();
                    f16 = f26;
                    f17 = f16;
                    f18 = f27;
                    f19 = f18;
                    textScanner.skipCommaWhitespace();
                    if (!textScanner.empty()) {
                    }
                    break;
                default:
                    return pathDefinition;
            }
        }
    }

    private static void parsePreserveAspectRatio(SVG.SvgPreserveAspectRatioContainer svgPreserveAspectRatioContainer, String str) throws SAXException {
        PreserveAspectRatio.Scale scale;
        TextScanner textScanner = new TextScanner(str);
        textScanner.skipWhitespace();
        String nextToken = textScanner.nextToken();
        if ("defer".equals(nextToken)) {
            textScanner.skipWhitespace();
            nextToken = textScanner.nextToken();
        }
        PreserveAspectRatio.Alignment alignment = aspectRatioKeywords.get(nextToken);
        textScanner.skipWhitespace();
        if (!textScanner.empty()) {
            String nextToken2 = textScanner.nextToken();
            if (nextToken2.equals("meet")) {
                scale = PreserveAspectRatio.Scale.Meet;
            } else if (nextToken2.equals("slice")) {
                scale = PreserveAspectRatio.Scale.Slice;
            } else {
                throw new SAXException("Invalid preserveAspectRatio definition: " + str);
            }
        } else {
            scale = null;
        }
        svgPreserveAspectRatioContainer.preserveAspectRatio = new PreserveAspectRatio(alignment, scale);
    }

    private static Set<String> parseRequiredFeatures(String str) throws SAXException {
        TextScanner textScanner = new TextScanner(str);
        HashSet hashSet = new HashSet();
        while (!textScanner.empty()) {
            String nextToken = textScanner.nextToken();
            if (nextToken.startsWith(FEATURE_STRING_PREFIX)) {
                hashSet.add(nextToken.substring(35));
            } else {
                hashSet.add("UNSUPPORTED");
            }
            textScanner.skipWhitespace();
        }
        return hashSet;
    }

    private static Set<String> parseRequiredFormats(String str) throws SAXException {
        TextScanner textScanner = new TextScanner(str);
        HashSet hashSet = new HashSet();
        while (!textScanner.empty()) {
            hashSet.add(textScanner.nextToken());
            textScanner.skipWhitespace();
        }
        return hashSet;
    }

    private static SVG.Length[] parseStrokeDashArray(String str) throws SAXException {
        SVG.Length nextLength;
        TextScanner textScanner = new TextScanner(str);
        textScanner.skipWhitespace();
        if (textScanner.empty() || (nextLength = textScanner.nextLength()) == null) {
            return null;
        }
        if (!nextLength.isNegative()) {
            float floatValue = nextLength.floatValue();
            ArrayList arrayList = new ArrayList();
            arrayList.add(nextLength);
            while (!textScanner.empty()) {
                textScanner.skipCommaWhitespace();
                SVG.Length nextLength2 = textScanner.nextLength();
                if (nextLength2 != null) {
                    if (!nextLength2.isNegative()) {
                        arrayList.add(nextLength2);
                        floatValue += nextLength2.floatValue();
                    } else {
                        throw new SAXException("Invalid stroke-dasharray. Dash segemnts cannot be negative: " + str);
                    }
                } else {
                    throw new SAXException("Invalid stroke-dasharray. Non-Length content found: " + str);
                }
            }
            if (floatValue == 0.0f) {
                return null;
            }
            return (SVG.Length[]) arrayList.toArray(new SVG.Length[arrayList.size()]);
        }
        throw new SAXException("Invalid stroke-dasharray. Dash segemnts cannot be negative: " + str);
    }

    private static SVG.Style.LineCaps parseStrokeLineCap(String str) throws SAXException {
        if ("butt".equals(str)) {
            return SVG.Style.LineCaps.Butt;
        }
        if ("round".equals(str)) {
            return SVG.Style.LineCaps.Round;
        }
        if ("square".equals(str)) {
            return SVG.Style.LineCaps.Square;
        }
        throw new SAXException("Invalid stroke-linecap property: " + str);
    }

    private static SVG.Style.LineJoin parseStrokeLineJoin(String str) throws SAXException {
        if ("miter".equals(str)) {
            return SVG.Style.LineJoin.Miter;
        }
        if ("round".equals(str)) {
            return SVG.Style.LineJoin.Round;
        }
        if ("bevel".equals(str)) {
            return SVG.Style.LineJoin.Bevel;
        }
        throw new SAXException("Invalid stroke-linejoin property: " + str);
    }

    private static void parseStyle(SVG.SvgElementBase svgElementBase, String str) throws SAXException {
        TextScanner textScanner = new TextScanner(str.replaceAll("/\\*.*?\\*/", ""));
        while (true) {
            String nextToken = textScanner.nextToken(':');
            textScanner.skipWhitespace();
            if (textScanner.consume(':')) {
                textScanner.skipWhitespace();
                String nextToken2 = textScanner.nextToken(';');
                if (nextToken2 == null) {
                    return;
                }
                textScanner.skipWhitespace();
                if (textScanner.empty() || textScanner.consume(';')) {
                    if (svgElementBase.style == null) {
                        svgElementBase.style = new SVG.Style();
                    }
                    processStyleProperty(svgElementBase.style, nextToken, nextToken2);
                    textScanner.skipWhitespace();
                }
            } else {
                return;
            }
        }
    }

    private static Set<String> parseSystemLanguage(String str) throws SAXException {
        TextScanner textScanner = new TextScanner(str);
        HashSet hashSet = new HashSet();
        while (!textScanner.empty()) {
            String nextToken = textScanner.nextToken();
            int indexOf = nextToken.indexOf(45);
            if (indexOf != -1) {
                nextToken = nextToken.substring(0, indexOf);
            }
            hashSet.add(new Locale(nextToken, "", "").getLanguage());
            textScanner.skipWhitespace();
        }
        return hashSet;
    }

    private static SVG.Style.TextAnchor parseTextAnchor(String str) throws SAXException {
        if ("start".equals(str)) {
            return SVG.Style.TextAnchor.Start;
        }
        if ("middle".equals(str)) {
            return SVG.Style.TextAnchor.Middle;
        }
        if ("end".equals(str)) {
            return SVG.Style.TextAnchor.End;
        }
        throw new SAXException("Invalid text-anchor property: " + str);
    }

    private static SVG.Style.TextDecoration parseTextDecoration(String str) throws SAXException {
        if ("none".equals(str)) {
            return SVG.Style.TextDecoration.None;
        }
        if ("underline".equals(str)) {
            return SVG.Style.TextDecoration.Underline;
        }
        if ("overline".equals(str)) {
            return SVG.Style.TextDecoration.Overline;
        }
        if (PTSNodeTextBase.TEXT_DECORATION_LINE_THROUGH.equals(str)) {
            return SVG.Style.TextDecoration.LineThrough;
        }
        if ("blink".equals(str)) {
            return SVG.Style.TextDecoration.Blink;
        }
        throw new SAXException("Invalid text-decoration property: " + str);
    }

    private static SVG.Style.TextDirection parseTextDirection(String str) throws SAXException {
        if ("ltr".equals(str)) {
            return SVG.Style.TextDirection.LTR;
        }
        if ("rtl".equals(str)) {
            return SVG.Style.TextDirection.RTL;
        }
        throw new SAXException("Invalid direction property: " + str);
    }

    private Matrix parseTransformList(String str) throws SAXException {
        Matrix matrix = new Matrix();
        TextScanner textScanner = new TextScanner(str);
        textScanner.skipWhitespace();
        while (!textScanner.empty()) {
            String nextFunction = textScanner.nextFunction();
            if (nextFunction != null) {
                if (nextFunction.equals("matrix")) {
                    textScanner.skipWhitespace();
                    Float nextFloat = textScanner.nextFloat();
                    textScanner.skipCommaWhitespace();
                    Float nextFloat2 = textScanner.nextFloat();
                    textScanner.skipCommaWhitespace();
                    Float nextFloat3 = textScanner.nextFloat();
                    textScanner.skipCommaWhitespace();
                    Float nextFloat4 = textScanner.nextFloat();
                    textScanner.skipCommaWhitespace();
                    Float nextFloat5 = textScanner.nextFloat();
                    textScanner.skipCommaWhitespace();
                    Float nextFloat6 = textScanner.nextFloat();
                    textScanner.skipWhitespace();
                    if (nextFloat6 != null && textScanner.consume(')')) {
                        Matrix matrix2 = new Matrix();
                        matrix2.setValues(new float[]{nextFloat.floatValue(), nextFloat3.floatValue(), nextFloat5.floatValue(), nextFloat2.floatValue(), nextFloat4.floatValue(), nextFloat6.floatValue(), 0.0f, 0.0f, 1.0f});
                        matrix.preConcat(matrix2);
                    } else {
                        throw new SAXException("Invalid transform list: " + str);
                    }
                } else if (nextFunction.equals(CanvasView.ACTION_TRANSLATE)) {
                    textScanner.skipWhitespace();
                    Float nextFloat7 = textScanner.nextFloat();
                    Float possibleNextFloat = textScanner.possibleNextFloat();
                    textScanner.skipWhitespace();
                    if (nextFloat7 != null && textScanner.consume(')')) {
                        if (possibleNextFloat == null) {
                            matrix.preTranslate(nextFloat7.floatValue(), 0.0f);
                        } else {
                            matrix.preTranslate(nextFloat7.floatValue(), possibleNextFloat.floatValue());
                        }
                    } else {
                        throw new SAXException("Invalid transform list: " + str);
                    }
                } else if (nextFunction.equals("scale")) {
                    textScanner.skipWhitespace();
                    Float nextFloat8 = textScanner.nextFloat();
                    Float possibleNextFloat2 = textScanner.possibleNextFloat();
                    textScanner.skipWhitespace();
                    if (nextFloat8 != null && textScanner.consume(')')) {
                        if (possibleNextFloat2 == null) {
                            matrix.preScale(nextFloat8.floatValue(), nextFloat8.floatValue());
                        } else {
                            matrix.preScale(nextFloat8.floatValue(), possibleNextFloat2.floatValue());
                        }
                    } else {
                        throw new SAXException("Invalid transform list: " + str);
                    }
                } else if (nextFunction.equals(CanvasView.ACTION_ROTATE)) {
                    textScanner.skipWhitespace();
                    Float nextFloat9 = textScanner.nextFloat();
                    Float possibleNextFloat3 = textScanner.possibleNextFloat();
                    Float possibleNextFloat4 = textScanner.possibleNextFloat();
                    textScanner.skipWhitespace();
                    if (nextFloat9 != null && textScanner.consume(')')) {
                        if (possibleNextFloat3 == null) {
                            matrix.preRotate(nextFloat9.floatValue());
                        } else if (possibleNextFloat4 != null) {
                            matrix.preRotate(nextFloat9.floatValue(), possibleNextFloat3.floatValue(), possibleNextFloat4.floatValue());
                        } else {
                            throw new SAXException("Invalid transform list: " + str);
                        }
                    } else {
                        throw new SAXException("Invalid transform list: " + str);
                    }
                } else if (nextFunction.equals("skewX")) {
                    textScanner.skipWhitespace();
                    Float nextFloat10 = textScanner.nextFloat();
                    textScanner.skipWhitespace();
                    if (nextFloat10 != null && textScanner.consume(')')) {
                        matrix.preSkew((float) Math.tan(Math.toRadians(nextFloat10.floatValue())), 0.0f);
                    } else {
                        throw new SAXException("Invalid transform list: " + str);
                    }
                } else if (nextFunction.equals("skewY")) {
                    textScanner.skipWhitespace();
                    Float nextFloat11 = textScanner.nextFloat();
                    textScanner.skipWhitespace();
                    if (nextFloat11 != null && textScanner.consume(')')) {
                        matrix.preSkew(0.0f, (float) Math.tan(Math.toRadians(nextFloat11.floatValue())));
                    } else {
                        throw new SAXException("Invalid transform list: " + str);
                    }
                } else {
                    throw new SAXException("Invalid transform list fn: " + nextFunction + ")");
                }
                if (textScanner.empty()) {
                    break;
                }
                textScanner.skipCommaWhitespace();
            } else {
                throw new SAXException("Bad transform function encountered in transform list: " + str);
            }
        }
        return matrix;
    }

    private static SVG.Style.VectorEffect parseVectorEffect(String str) throws SAXException {
        if ("none".equals(str)) {
            return SVG.Style.VectorEffect.None;
        }
        if ("non-scaling-stroke".equals(str)) {
            return SVG.Style.VectorEffect.NonScalingStroke;
        }
        throw new SAXException("Invalid vector-effect property: " + str);
    }

    private static SVG.Box parseViewBox(String str) throws SAXException {
        TextScanner textScanner = new TextScanner(str);
        textScanner.skipWhitespace();
        Float nextFloat = textScanner.nextFloat();
        textScanner.skipCommaWhitespace();
        Float nextFloat2 = textScanner.nextFloat();
        textScanner.skipCommaWhitespace();
        Float nextFloat3 = textScanner.nextFloat();
        textScanner.skipCommaWhitespace();
        Float nextFloat4 = textScanner.nextFloat();
        if (nextFloat != null && nextFloat2 != null && nextFloat3 != null && nextFloat4 != null) {
            if (nextFloat3.floatValue() >= 0.0f) {
                if (nextFloat4.floatValue() >= 0.0f) {
                    return new SVG.Box(nextFloat.floatValue(), nextFloat2.floatValue(), nextFloat3.floatValue(), nextFloat4.floatValue());
                }
                throw new SAXException("Invalid viewBox. height cannot be negative");
            }
            throw new SAXException("Invalid viewBox. width cannot be negative");
        }
        throw new SAXException("Invalid viewBox definition - should have four numbers");
    }

    private void path(Attributes attributes) throws SAXException {
        debug("<path>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Path path = new SVG.Path();
            path.document = this.svgDocument;
            path.parent = this.currentElement;
            parseAttributesCore(path, attributes);
            parseAttributesStyle(path, attributes);
            parseAttributesTransform(path, attributes);
            parseAttributesConditional(path, attributes);
            parseAttributesPath(path, attributes);
            this.currentElement.addChild(path);
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private void pattern(Attributes attributes) throws SAXException {
        debug("<pattern>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Pattern pattern = new SVG.Pattern();
            pattern.document = this.svgDocument;
            pattern.parent = this.currentElement;
            parseAttributesCore(pattern, attributes);
            parseAttributesStyle(pattern, attributes);
            parseAttributesConditional(pattern, attributes);
            parseAttributesViewBox(pattern, attributes);
            parseAttributesPattern(pattern, attributes);
            this.currentElement.addChild(pattern);
            this.currentElement = pattern;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private void polygon(Attributes attributes) throws SAXException {
        debug("<polygon>", new Object[0]);
        if (this.currentElement != null) {
            SVG.PolyLine polygon = new SVG.Polygon();
            polygon.document = this.svgDocument;
            polygon.parent = this.currentElement;
            parseAttributesCore(polygon, attributes);
            parseAttributesStyle(polygon, attributes);
            parseAttributesTransform(polygon, attributes);
            parseAttributesConditional(polygon, attributes);
            parseAttributesPolyLine(polygon, attributes, TAG_POLYGON);
            this.currentElement.addChild(polygon);
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private void polyline(Attributes attributes) throws SAXException {
        debug("<polyline>", new Object[0]);
        if (this.currentElement != null) {
            SVG.PolyLine polyLine = new SVG.PolyLine();
            polyLine.document = this.svgDocument;
            polyLine.parent = this.currentElement;
            parseAttributesCore(polyLine, attributes);
            parseAttributesStyle(polyLine, attributes);
            parseAttributesTransform(polyLine, attributes);
            parseAttributesConditional(polyLine, attributes);
            parseAttributesPolyLine(polyLine, attributes, TAG_POLYLINE);
            this.currentElement.addChild(polyLine);
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void processStyleProperty(SVG.Style style, String str, String str2) throws SAXException {
        if (str2.length() == 0 || str2.equals("inherit")) {
            return;
        }
        int i3 = $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(str).ordinal()];
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 5) {
                    if (i3 != 6) {
                        if (i3 != 9) {
                            if (i3 != 36) {
                                if (i3 != 41) {
                                    if (i3 != 43) {
                                        if (i3 != 79) {
                                            if (i3 != 59) {
                                                if (i3 != 60) {
                                                    if (i3 != 75) {
                                                        if (i3 != 76) {
                                                            switch (i3) {
                                                                case 15:
                                                                    if (str2.indexOf(124) < 0) {
                                                                        if (VALID_DISPLAY_VALUES.indexOf(String.valueOf(QbAddrData.DATA_SPLITER) + str2 + QbAddrData.DATA_SPLITER) != -1) {
                                                                            style.display = Boolean.valueOf(!str2.equals("none"));
                                                                            style.specifiedFlags |= 16777216;
                                                                            return;
                                                                        }
                                                                    }
                                                                    throw new SAXException("Invalid value for \"display\" attribute: " + str2);
                                                                case 16:
                                                                    style.fill = parsePaintSpecifier(str2, CanvasView.CUSTOM_ACTION_FILL);
                                                                    style.specifiedFlags |= 1;
                                                                    return;
                                                                case 17:
                                                                    style.fillRule = parseFillRule(str2);
                                                                    style.specifiedFlags |= 2;
                                                                    return;
                                                                case 18:
                                                                    style.fillOpacity = Float.valueOf(parseOpacity(str2));
                                                                    style.specifiedFlags |= 4;
                                                                    return;
                                                                case 19:
                                                                    parseFont(style, str2);
                                                                    return;
                                                                case 20:
                                                                    style.fontFamily = parseFontFamily(str2);
                                                                    style.specifiedFlags |= 8192;
                                                                    return;
                                                                case 21:
                                                                    style.fontSize = parseFontSize(str2);
                                                                    style.specifiedFlags |= 16384;
                                                                    return;
                                                                case 22:
                                                                    style.fontWeight = parseFontWeight(str2);
                                                                    style.specifiedFlags |= 32768;
                                                                    return;
                                                                case 23:
                                                                    style.fontStyle = parseFontStyle(str2);
                                                                    style.specifiedFlags |= 65536;
                                                                    return;
                                                                default:
                                                                    switch (i3) {
                                                                        case 29:
                                                                            String parseFunctionalIRI = parseFunctionalIRI(str2, str);
                                                                            style.markerStart = parseFunctionalIRI;
                                                                            style.markerMid = parseFunctionalIRI;
                                                                            style.markerEnd = parseFunctionalIRI;
                                                                            style.specifiedFlags |= 14680064;
                                                                            return;
                                                                        case 30:
                                                                            style.markerStart = parseFunctionalIRI(str2, str);
                                                                            style.specifiedFlags |= 2097152;
                                                                            return;
                                                                        case 31:
                                                                            style.markerMid = parseFunctionalIRI(str2, str);
                                                                            style.specifiedFlags |= 4194304;
                                                                            return;
                                                                        case 32:
                                                                            style.markerEnd = parseFunctionalIRI(str2, str);
                                                                            style.specifiedFlags |= VasBusiness.CHAT_FONT_SWITCH;
                                                                            return;
                                                                        default:
                                                                            switch (i3) {
                                                                                case 63:
                                                                                    if (str2.equals(CURRENTCOLOR)) {
                                                                                        style.stopColor = SVG.CurrentColor.getInstance();
                                                                                    } else {
                                                                                        style.stopColor = parseColour(str2);
                                                                                    }
                                                                                    style.specifiedFlags |= 67108864;
                                                                                    return;
                                                                                case 64:
                                                                                    style.stopOpacity = Float.valueOf(parseOpacity(str2));
                                                                                    style.specifiedFlags |= 134217728;
                                                                                    return;
                                                                                case 65:
                                                                                    style.stroke = parsePaintSpecifier(str2, "stroke");
                                                                                    style.specifiedFlags |= 8;
                                                                                    return;
                                                                                case 66:
                                                                                    if ("none".equals(str2)) {
                                                                                        style.strokeDashArray = null;
                                                                                    } else {
                                                                                        style.strokeDashArray = parseStrokeDashArray(str2);
                                                                                    }
                                                                                    style.specifiedFlags |= 512;
                                                                                    return;
                                                                                case 67:
                                                                                    style.strokeDashOffset = parseLength(str2);
                                                                                    style.specifiedFlags |= 1024;
                                                                                    return;
                                                                                case 68:
                                                                                    style.strokeLineCap = parseStrokeLineCap(str2);
                                                                                    style.specifiedFlags |= 64;
                                                                                    return;
                                                                                case 69:
                                                                                    style.strokeLineJoin = parseStrokeLineJoin(str2);
                                                                                    style.specifiedFlags |= 128;
                                                                                    return;
                                                                                case 70:
                                                                                    style.strokeMiterLimit = Float.valueOf(parseFloat(str2));
                                                                                    style.specifiedFlags |= 256;
                                                                                    return;
                                                                                case 71:
                                                                                    style.strokeOpacity = Float.valueOf(parseOpacity(str2));
                                                                                    style.specifiedFlags |= 16;
                                                                                    return;
                                                                                case 72:
                                                                                    style.strokeWidth = parseLength(str2);
                                                                                    style.specifiedFlags |= 32;
                                                                                    return;
                                                                                default:
                                                                                    switch (i3) {
                                                                                        case 89:
                                                                                            if (str2.equals(CURRENTCOLOR)) {
                                                                                                style.viewportFill = SVG.CurrentColor.getInstance();
                                                                                            } else {
                                                                                                style.viewportFill = parseColour(str2);
                                                                                            }
                                                                                            style.specifiedFlags |= 8589934592L;
                                                                                            return;
                                                                                        case 90:
                                                                                            style.viewportFillOpacity = Float.valueOf(parseOpacity(str2));
                                                                                            style.specifiedFlags |= 17179869184L;
                                                                                            return;
                                                                                        case 91:
                                                                                            if (str2.indexOf(124) < 0) {
                                                                                                if (VALID_VISIBILITY_VALUES.indexOf(String.valueOf(QbAddrData.DATA_SPLITER) + str2 + QbAddrData.DATA_SPLITER) != -1) {
                                                                                                    style.visibility = Boolean.valueOf(str2.equals(NodeProps.VISIBLE));
                                                                                                    style.specifiedFlags |= 33554432;
                                                                                                    return;
                                                                                                }
                                                                                            }
                                                                                            throw new SAXException("Invalid value for \"visibility\" attribute: " + str2);
                                                                                        default:
                                                                                            return;
                                                                                    }
                                                                            }
                                                                    }
                                                            }
                                                        }
                                                        style.textDecoration = parseTextDecoration(str2);
                                                        style.specifiedFlags |= 131072;
                                                        return;
                                                    }
                                                    style.textAnchor = parseTextAnchor(str2);
                                                    style.specifiedFlags |= 262144;
                                                    return;
                                                }
                                                style.solidOpacity = Float.valueOf(parseOpacity(str2));
                                                style.specifiedFlags |= 4294967296L;
                                                return;
                                            }
                                            if (str2.equals(CURRENTCOLOR)) {
                                                style.solidColor = SVG.CurrentColor.getInstance();
                                            } else {
                                                style.solidColor = parseColour(str2);
                                            }
                                            style.specifiedFlags |= 2147483648L;
                                            return;
                                        }
                                        style.vectorEffect = parseVectorEffect(str2);
                                        style.specifiedFlags |= 34359738368L;
                                        return;
                                    }
                                    style.overflow = parseOverflow(str2);
                                    style.specifiedFlags |= 524288;
                                    return;
                                }
                                style.opacity = Float.valueOf(parseOpacity(str2));
                                style.specifiedFlags |= 2048;
                                return;
                            }
                            style.mask = parseFunctionalIRI(str2, str);
                            style.specifiedFlags |= 1073741824;
                            return;
                        }
                        style.direction = parseTextDirection(str2);
                        style.specifiedFlags |= TPChannelLayout.TP_CH_TOP_SIDE_LEFT;
                        return;
                    }
                    style.color = parseColour(str2);
                    style.specifiedFlags |= 4096;
                    return;
                }
                style.clipRule = parseFillRule(str2);
                style.specifiedFlags |= 536870912;
                return;
            }
            style.clipPath = parseFunctionalIRI(str2, str);
            style.specifiedFlags |= VasBusiness.QWALLET;
            return;
        }
        style.clip = parseClip(str2);
        style.specifiedFlags |= 1048576;
    }

    private void radialGradient(Attributes attributes) throws SAXException {
        debug("<radialGradient>", new Object[0]);
        if (this.currentElement != null) {
            SVG.SvgRadialGradient svgRadialGradient = new SVG.SvgRadialGradient();
            svgRadialGradient.document = this.svgDocument;
            svgRadialGradient.parent = this.currentElement;
            parseAttributesCore(svgRadialGradient, attributes);
            parseAttributesStyle(svgRadialGradient, attributes);
            parseAttributesGradient(svgRadialGradient, attributes);
            parseAttributesRadialGradient(svgRadialGradient, attributes);
            this.currentElement.addChild(svgRadialGradient);
            this.currentElement = svgRadialGradient;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private void rect(Attributes attributes) throws SAXException {
        debug("<rect>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Rect rect = new SVG.Rect();
            rect.document = this.svgDocument;
            rect.parent = this.currentElement;
            parseAttributesCore(rect, attributes);
            parseAttributesStyle(rect, attributes);
            parseAttributesTransform(rect, attributes);
            parseAttributesConditional(rect, attributes);
            parseAttributesRect(rect, attributes);
            this.currentElement.addChild(rect);
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private void solidColor(Attributes attributes) throws SAXException {
        debug("<solidColor>", new Object[0]);
        if (this.currentElement != null) {
            SVG.SolidColor solidColor = new SVG.SolidColor();
            solidColor.document = this.svgDocument;
            solidColor.parent = this.currentElement;
            parseAttributesCore(solidColor, attributes);
            parseAttributesStyle(solidColor, attributes);
            this.currentElement.addChild(solidColor);
            this.currentElement = solidColor;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private void stop(Attributes attributes) throws SAXException {
        debug("<stop>", new Object[0]);
        SVG.SvgContainer svgContainer = this.currentElement;
        if (svgContainer != null) {
            if (svgContainer instanceof SVG.GradientElement) {
                SVG.Stop stop = new SVG.Stop();
                stop.document = this.svgDocument;
                stop.parent = this.currentElement;
                parseAttributesCore(stop, attributes);
                parseAttributesStyle(stop, attributes);
                parseAttributesStop(stop, attributes);
                this.currentElement.addChild(stop);
                this.currentElement = stop;
                return;
            }
            throw new SAXException("Invalid document. <stop> elements are only valid inside <linearGradiant> or <radialGradient> elements.");
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private void style(Attributes attributes) throws SAXException {
        debug("<style>", new Object[0]);
        if (this.currentElement != null) {
            String str = "all";
            boolean z16 = true;
            for (int i3 = 0; i3 < attributes.getLength(); i3++) {
                String trim = attributes.getValue(i3).trim();
                int i16 = $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i3)).ordinal()];
                if (i16 != 39) {
                    if (i16 == 78) {
                        z16 = trim.equals("text/css");
                    }
                } else {
                    str = trim;
                }
            }
            if (z16 && CSSParser.mediaMatches(str, CSSParser.MediaType.screen)) {
                this.inStyleElement = true;
                return;
            } else {
                this.ignoring = true;
                this.ignoreDepth = 1;
                return;
            }
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private void svg(Attributes attributes) throws SAXException {
        debug("<svg>", new Object[0]);
        SVG.Svg svg = new SVG.Svg();
        svg.document = this.svgDocument;
        svg.parent = this.currentElement;
        parseAttributesCore(svg, attributes);
        parseAttributesStyle(svg, attributes);
        parseAttributesConditional(svg, attributes);
        parseAttributesViewBox(svg, attributes);
        parseAttributesSVG(svg, attributes);
        SVG.SvgContainer svgContainer = this.currentElement;
        if (svgContainer == null) {
            this.svgDocument.setRootElement(svg);
        } else {
            svgContainer.addChild(svg);
        }
        this.currentElement = svg;
    }

    private void symbol(Attributes attributes) throws SAXException {
        debug("<symbol>", new Object[0]);
        if (this.currentElement != null) {
            SVG.SvgViewBoxContainer symbol = new SVG.Symbol();
            symbol.document = this.svgDocument;
            symbol.parent = this.currentElement;
            parseAttributesCore(symbol, attributes);
            parseAttributesStyle(symbol, attributes);
            parseAttributesConditional(symbol, attributes);
            parseAttributesViewBox(symbol, attributes);
            this.currentElement.addChild(symbol);
            this.currentElement = symbol;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private void text(Attributes attributes) throws SAXException {
        debug("<text>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Text text = new SVG.Text();
            text.document = this.svgDocument;
            text.parent = this.currentElement;
            parseAttributesCore(text, attributes);
            parseAttributesStyle(text, attributes);
            parseAttributesTransform(text, attributes);
            parseAttributesConditional(text, attributes);
            parseAttributesTextPosition(text, attributes);
            this.currentElement.addChild(text);
            this.currentElement = text;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private void textPath(Attributes attributes) throws SAXException {
        debug("<textPath>", new Object[0]);
        if (this.currentElement != null) {
            SVG.TextPath textPath = new SVG.TextPath();
            textPath.document = this.svgDocument;
            textPath.parent = this.currentElement;
            parseAttributesCore(textPath, attributes);
            parseAttributesStyle(textPath, attributes);
            parseAttributesConditional(textPath, attributes);
            parseAttributesTextPath(textPath, attributes);
            this.currentElement.addChild(textPath);
            this.currentElement = textPath;
            SVG.SvgContainer svgContainer = textPath.parent;
            if (svgContainer instanceof SVG.TextRoot) {
                textPath.setTextRoot((SVG.TextRoot) svgContainer);
                return;
            } else {
                textPath.setTextRoot(((SVG.TextChild) svgContainer).getTextRoot());
                return;
            }
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private void tref(Attributes attributes) throws SAXException {
        debug("<tref>", new Object[0]);
        SVG.SvgContainer svgContainer = this.currentElement;
        if (svgContainer != null) {
            if (svgContainer instanceof SVG.TextContainer) {
                SVG.TRef tRef = new SVG.TRef();
                tRef.document = this.svgDocument;
                tRef.parent = this.currentElement;
                parseAttributesCore(tRef, attributes);
                parseAttributesStyle(tRef, attributes);
                parseAttributesConditional(tRef, attributes);
                parseAttributesTRef(tRef, attributes);
                this.currentElement.addChild(tRef);
                SVG.SvgContainer svgContainer2 = tRef.parent;
                if (svgContainer2 instanceof SVG.TextRoot) {
                    tRef.setTextRoot((SVG.TextRoot) svgContainer2);
                    return;
                } else {
                    tRef.setTextRoot(((SVG.TextChild) svgContainer2).getTextRoot());
                    return;
                }
            }
            throw new SAXException("Invalid document. <tref> elements are only valid inside <text> or <tspan> elements.");
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private void tspan(Attributes attributes) throws SAXException {
        debug("<tspan>", new Object[0]);
        SVG.SvgContainer svgContainer = this.currentElement;
        if (svgContainer != null) {
            if (svgContainer instanceof SVG.TextContainer) {
                SVG.TSpan tSpan = new SVG.TSpan();
                tSpan.document = this.svgDocument;
                tSpan.parent = this.currentElement;
                parseAttributesCore(tSpan, attributes);
                parseAttributesStyle(tSpan, attributes);
                parseAttributesConditional(tSpan, attributes);
                parseAttributesTextPosition(tSpan, attributes);
                this.currentElement.addChild(tSpan);
                this.currentElement = tSpan;
                SVG.SvgContainer svgContainer2 = tSpan.parent;
                if (svgContainer2 instanceof SVG.TextRoot) {
                    tSpan.setTextRoot((SVG.TextRoot) svgContainer2);
                    return;
                } else {
                    tSpan.setTextRoot(((SVG.TextChild) svgContainer2).getTextRoot());
                    return;
                }
            }
            throw new SAXException("Invalid document. <tspan> elements are only valid inside <text> or other <tspan> elements.");
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private void use(Attributes attributes) throws SAXException {
        debug("<use>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Use use = new SVG.Use();
            use.document = this.svgDocument;
            use.parent = this.currentElement;
            parseAttributesCore(use, attributes);
            parseAttributesStyle(use, attributes);
            parseAttributesTransform(use, attributes);
            parseAttributesConditional(use, attributes);
            parseAttributesUse(use, attributes);
            this.currentElement.addChild(use);
            this.currentElement = use;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private void view(Attributes attributes) throws SAXException {
        debug("<view>", new Object[0]);
        if (this.currentElement != null) {
            SVG.SvgViewBoxContainer view = new SVG.View();
            view.document = this.svgDocument;
            view.parent = this.currentElement;
            parseAttributesCore(view, attributes);
            parseAttributesConditional(view, attributes);
            parseAttributesViewBox(view, attributes);
            this.currentElement.addChild(view);
            this.currentElement = view;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private void zwitch(Attributes attributes) throws SAXException {
        debug("<switch>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Switch r06 = new SVG.Switch();
            r06.document = this.svgDocument;
            r06.parent = this.currentElement;
            parseAttributesCore(r06, attributes);
            parseAttributesStyle(r06, attributes);
            parseAttributesTransform(r06, attributes);
            parseAttributesConditional(r06, attributes);
            this.currentElement.addChild(r06);
            this.currentElement = r06;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i3, int i16) throws SAXException {
        SVG.SvgObject svgObject;
        if (this.ignoring) {
            return;
        }
        if (this.inMetadataElement) {
            if (this.metadataElementContents == null) {
                this.metadataElementContents = new StringBuilder(i16);
            }
            this.metadataElementContents.append(cArr, i3, i16);
            return;
        }
        if (this.inStyleElement) {
            if (this.styleElementContents == null) {
                this.styleElementContents = new StringBuilder(i16);
            }
            this.styleElementContents.append(cArr, i3, i16);
            return;
        }
        SVG.SvgContainer svgContainer = this.currentElement;
        if (svgContainer instanceof SVG.TextContainer) {
            SVG.SvgConditionalContainer svgConditionalContainer = (SVG.SvgConditionalContainer) svgContainer;
            int size = svgConditionalContainer.children.size();
            if (size == 0) {
                svgObject = null;
            } else {
                svgObject = svgConditionalContainer.children.get(size - 1);
            }
            if (svgObject instanceof SVG.TextSequence) {
                SVG.TextSequence textSequence = (SVG.TextSequence) svgObject;
                textSequence.text = String.valueOf(textSequence.text) + new String(cArr, i3, i16);
                return;
            }
            ((SVG.SvgConditionalContainer) this.currentElement).addChild(new SVG.TextSequence(new String(cArr, i3, i16)));
        }
    }

    @Override // org.xml.sax.ext.DefaultHandler2, org.xml.sax.ext.LexicalHandler
    public void comment(char[] cArr, int i3, int i16) throws SAXException {
        if (!this.ignoring && this.inStyleElement) {
            if (this.styleElementContents == null) {
                this.styleElementContents = new StringBuilder(i16);
            }
            this.styleElementContents.append(cArr, i3, i16);
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) throws SAXException {
        StringBuilder sb5;
        super.endElement(str, str2, str3);
        if (this.ignoring) {
            int i3 = this.ignoreDepth - 1;
            this.ignoreDepth = i3;
            if (i3 == 0) {
                this.ignoring = false;
                return;
            }
        }
        if (!SVG_NAMESPACE.equals(str) && !"".equals(str)) {
            return;
        }
        if (!str2.equals("title") && !str2.equals("desc")) {
            if (str2.equals("style") && (sb5 = this.styleElementContents) != null) {
                this.inStyleElement = false;
                parseCSSStyleSheet(sb5.toString());
                this.styleElementContents.setLength(0);
                return;
            }
            if (str2.equals(TAG_SVG) || str2.equals(TAG_DEFS) || str2.equals("g") || str2.equals("use") || str2.equals("image") || str2.equals("text") || str2.equals(TAG_TSPAN) || str2.equals("switch") || str2.equals(TAG_SYMBOL) || str2.equals(TAG_MARKER) || str2.equals("linearGradient") || str2.equals(TAG_RADIALGRADIENT) || str2.equals("stop") || str2.equals(TAG_CLIPPATH) || str2.equals(TAG_TEXTPATH) || str2.equals(TAG_PATTERN) || str2.equals("view") || str2.equals(TAG_MASK) || str2.equals(TAG_SOLIDCOLOR)) {
                this.currentElement = ((SVG.SvgObject) this.currentElement).parent;
                return;
            }
            return;
        }
        this.inMetadataElement = false;
        if (this.metadataTag.equals("title")) {
            this.svgDocument.setTitle(this.metadataElementContents.toString());
        } else if (this.metadataTag.equals("desc")) {
            this.svgDocument.setDesc(this.metadataElementContents.toString());
        }
        this.metadataElementContents.setLength(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SVG parse(InputStream inputStream) throws SVGParseException {
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStream(inputStream);
        }
        try {
            inputStream.mark(3);
            int read = inputStream.read() + (inputStream.read() << 8);
            inputStream.reset();
            if (read == 35615) {
                inputStream = new GZIPInputStream(inputStream);
            }
        } catch (IOException unused) {
        }
        try {
            try {
                try {
                    try {
                        XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
                        xMLReader.setContentHandler(this);
                        xMLReader.setProperty("http://xml.org/sax/properties/lexical-handler", this);
                        xMLReader.parse(new InputSource(inputStream));
                        try {
                            inputStream.close();
                        } catch (IOException unused2) {
                            Log.e(TAG, "Exception thrown closing input stream");
                        }
                        return this.svgDocument;
                    } catch (IOException e16) {
                        throw new SVGParseException("File error", e16);
                    }
                } catch (ParserConfigurationException e17) {
                    throw new SVGParseException("XML Parser problem", e17);
                }
            } catch (SAXException e18) {
                throw new SVGParseException("SVG parse error: " + e18.getMessage(), e18);
            }
        } catch (Throwable th5) {
            try {
                inputStream.close();
            } catch (IOException unused3) {
                Log.e(TAG, "Exception thrown closing input stream");
            }
            throw th5;
        }
    }

    protected void setSupportedFormats(String[] strArr) {
        HashSet<String> hashSet = new HashSet<>(strArr.length);
        this.supportedFormats = hashSet;
        Collections.addAll(hashSet, strArr);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startDocument() throws SAXException {
        super.startDocument();
        this.svgDocument = new SVG();
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        super.startElement(str, str2, str3, attributes);
        if (this.ignoring) {
            this.ignoreDepth++;
            return;
        }
        if (!SVG_NAMESPACE.equals(str) && !"".equals(str)) {
            return;
        }
        if (str2.equals(TAG_SVG)) {
            svg(attributes);
            return;
        }
        if (str2.equals("g")) {
            g(attributes);
            return;
        }
        if (str2.equals(TAG_DEFS)) {
            defs(attributes);
            return;
        }
        if (str2.equals("use")) {
            use(attributes);
            return;
        }
        if (str2.equals("path")) {
            path(attributes);
            return;
        }
        if (str2.equals("rect")) {
            rect(attributes);
            return;
        }
        if (str2.equals("circle")) {
            circle(attributes);
            return;
        }
        if (str2.equals(TAG_ELLIPSE)) {
            ellipse(attributes);
            return;
        }
        if (str2.equals(TAG_LINE)) {
            line(attributes);
            return;
        }
        if (str2.equals(TAG_POLYLINE)) {
            polyline(attributes);
            return;
        }
        if (str2.equals(TAG_POLYGON)) {
            polygon(attributes);
            return;
        }
        if (str2.equals("text")) {
            text(attributes);
            return;
        }
        if (str2.equals(TAG_TSPAN)) {
            tspan(attributes);
            return;
        }
        if (str2.equals(TAG_TREF)) {
            tref(attributes);
            return;
        }
        if (str2.equals("switch")) {
            zwitch(attributes);
            return;
        }
        if (str2.equals(TAG_SYMBOL)) {
            symbol(attributes);
            return;
        }
        if (str2.equals(TAG_MARKER)) {
            marker(attributes);
            return;
        }
        if (str2.equals("linearGradient")) {
            linearGradient(attributes);
            return;
        }
        if (str2.equals(TAG_RADIALGRADIENT)) {
            radialGradient(attributes);
            return;
        }
        if (str2.equals("stop")) {
            stop(attributes);
            return;
        }
        if (str2.equals("a")) {
            g(attributes);
            return;
        }
        if (!str2.equals("title") && !str2.equals("desc")) {
            if (str2.equals(TAG_CLIPPATH)) {
                clipPath(attributes);
                return;
            }
            if (str2.equals(TAG_TEXTPATH)) {
                textPath(attributes);
                return;
            }
            if (str2.equals(TAG_PATTERN)) {
                pattern(attributes);
                return;
            }
            if (str2.equals("image")) {
                image(attributes);
                return;
            }
            if (str2.equals("view")) {
                view(attributes);
                return;
            }
            if (str2.equals(TAG_MASK)) {
                mask(attributes);
                return;
            }
            if (str2.equals("style")) {
                style(attributes);
                return;
            } else if (str2.equals(TAG_SOLIDCOLOR)) {
                solidColor(attributes);
                return;
            } else {
                this.ignoring = true;
                this.ignoreDepth = 1;
                return;
            }
        }
        this.inMetadataElement = true;
        this.metadataTag = str2;
    }

    private void debug(String str, Object... objArr) {
    }
}
