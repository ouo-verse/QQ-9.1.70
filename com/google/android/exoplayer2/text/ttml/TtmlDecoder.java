package com.google.android.exoplayer2.text.ttml;

import android.text.Layout;
import android.util.Log;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.ColorParser;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.XmlPullParserUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import tl.h;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class TtmlDecoder extends SimpleSubtitleDecoder {
    private static final String ATTR_BEGIN = "begin";
    private static final String ATTR_DURATION = "dur";
    private static final String ATTR_END = "end";
    private static final String ATTR_REGION = "region";
    private static final String ATTR_STYLE = "style";
    private static final int DEFAULT_FRAME_RATE = 30;
    private static final String TAG = "TtmlDecoder";
    private static final String TTP = "http://www.w3.org/ns/ttml#parameter";
    private final XmlPullParserFactory xmlParserFactory;
    private static final Pattern CLOCK_TIME = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final Pattern OFFSET_TIME = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    private static final Pattern FONT_SIZE = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    private static final Pattern PERCENTAGE_COORDINATES = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    private static final FrameAndTickRate DEFAULT_FRAME_AND_TICK_RATE = new FrameAndTickRate(30.0f, 1, 1);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class FrameAndTickRate {
        final float effectiveFrameRate;
        final int subFrameRate;
        final int tickRate;

        FrameAndTickRate(float f16, int i3, int i16) {
            this.effectiveFrameRate = f16;
            this.subFrameRate = i3;
            this.tickRate = i16;
        }
    }

    public TtmlDecoder() {
        super(TAG);
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            this.xmlParserFactory = newInstance;
            newInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e16) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e16);
        }
    }

    private TtmlStyle createIfNull(TtmlStyle ttmlStyle) {
        if (ttmlStyle == null) {
            return new TtmlStyle();
        }
        return ttmlStyle;
    }

    private static boolean isSupportedTag(String str) {
        if (!str.equals(TtmlNode.TAG_TT) && !str.equals("head") && !str.equals("body") && !str.equals("div") && !str.equals("p") && !str.equals(TtmlNode.TAG_SPAN) && !str.equals(TtmlNode.TAG_BR) && !str.equals("style") && !str.equals(TtmlNode.TAG_STYLING) && !str.equals(TtmlNode.TAG_LAYOUT) && !str.equals("region") && !str.equals(TtmlNode.TAG_METADATA) && !str.equals(TtmlNode.TAG_SMPTE_IMAGE) && !str.equals(TtmlNode.TAG_SMPTE_DATA) && !str.equals(TtmlNode.TAG_SMPTE_INFORMATION)) {
            return false;
        }
        return true;
    }

    private static void parseFontSize(String str, TtmlStyle ttmlStyle) throws SubtitleDecoderException {
        Matcher matcher;
        String[] split = str.split("\\s+");
        if (split.length == 1) {
            matcher = FONT_SIZE.matcher(str);
        } else if (split.length == 2) {
            matcher = FONT_SIZE.matcher(split[1]);
            Log.w(TAG, "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        } else {
            throw new SubtitleDecoderException("Invalid number of entries for fontSize: " + split.length + ".");
        }
        if (matcher.matches()) {
            String group = matcher.group(3);
            group.hashCode();
            char c16 = '\uffff';
            switch (group.hashCode()) {
                case 37:
                    if (group.equals("%")) {
                        c16 = 0;
                        break;
                    }
                    break;
                case 3240:
                    if (group.equals("em")) {
                        c16 = 1;
                        break;
                    }
                    break;
                case 3592:
                    if (group.equals("px")) {
                        c16 = 2;
                        break;
                    }
                    break;
            }
            switch (c16) {
                case 0:
                    ttmlStyle.setFontSizeUnit(3);
                    break;
                case 1:
                    ttmlStyle.setFontSizeUnit(2);
                    break;
                case 2:
                    ttmlStyle.setFontSizeUnit(1);
                    break;
                default:
                    throw new SubtitleDecoderException("Invalid unit for fontSize: '" + group + "'.");
            }
            ttmlStyle.setFontSize(Float.valueOf(matcher.group(1)).floatValue());
            return;
        }
        throw new SubtitleDecoderException("Invalid expression for fontSize: '" + str + "'.");
    }

    private FrameAndTickRate parseFrameAndTickRates(XmlPullParser xmlPullParser) throws SubtitleDecoderException {
        int i3;
        float f16;
        String attributeValue = xmlPullParser.getAttributeValue(TTP, "frameRate");
        if (attributeValue != null) {
            i3 = Integer.parseInt(attributeValue);
        } else {
            i3 = 30;
        }
        String attributeValue2 = xmlPullParser.getAttributeValue(TTP, "frameRateMultiplier");
        if (attributeValue2 != null) {
            if (attributeValue2.split(" ").length == 2) {
                f16 = Integer.parseInt(r2[0]) / Integer.parseInt(r2[1]);
            } else {
                throw new SubtitleDecoderException("frameRateMultiplier doesn't have 2 parts");
            }
        } else {
            f16 = 1.0f;
        }
        FrameAndTickRate frameAndTickRate = DEFAULT_FRAME_AND_TICK_RATE;
        int i16 = frameAndTickRate.subFrameRate;
        String attributeValue3 = xmlPullParser.getAttributeValue(TTP, "subFrameRate");
        if (attributeValue3 != null) {
            i16 = Integer.parseInt(attributeValue3);
        }
        int i17 = frameAndTickRate.tickRate;
        String attributeValue4 = xmlPullParser.getAttributeValue(TTP, "tickRate");
        if (attributeValue4 != null) {
            i17 = Integer.parseInt(attributeValue4);
        }
        return new FrameAndTickRate(i3 * f16, i16, i17);
    }

    private Map<String, TtmlStyle> parseHeader(XmlPullParser xmlPullParser, Map<String, TtmlStyle> map, Map<String, TtmlRegion> map2) throws IOException, XmlPullParserException {
        TtmlRegion parseRegionAttributes;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "style")) {
                String attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, "style");
                TtmlStyle parseStyleAttributes = parseStyleAttributes(xmlPullParser, new TtmlStyle());
                if (attributeValue != null) {
                    for (String str : parseStyleIds(attributeValue)) {
                        parseStyleAttributes.chain(map.get(str));
                    }
                }
                if (parseStyleAttributes.getId() != null) {
                    map.put(parseStyleAttributes.getId(), parseStyleAttributes);
                }
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "region") && (parseRegionAttributes = parseRegionAttributes(xmlPullParser)) != null) {
                map2.put(parseRegionAttributes.f32952id, parseRegionAttributes);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "head"));
        return map;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private TtmlNode parseNode(XmlPullParser xmlPullParser, TtmlNode ttmlNode, Map<String, TtmlRegion> map, FrameAndTickRate frameAndTickRate) throws SubtitleDecoderException {
        long j3;
        int attributeCount = xmlPullParser.getAttributeCount();
        TtmlStyle parseStyleAttributes = parseStyleAttributes(xmlPullParser, null);
        String[] strArr = null;
        long j16 = -9223372036854775807L;
        long j17 = -9223372036854775807L;
        long j18 = -9223372036854775807L;
        String str = "";
        for (int i3 = 0; i3 < attributeCount; i3++) {
            String attributeName = xmlPullParser.getAttributeName(i3);
            String attributeValue = xmlPullParser.getAttributeValue(i3);
            attributeName.hashCode();
            char c16 = '\uffff';
            switch (attributeName.hashCode()) {
                case -934795532:
                    if (attributeName.equals("region")) {
                        c16 = 0;
                    }
                    switch (c16) {
                        case 0:
                            if (!map.containsKey(attributeValue)) {
                                break;
                            } else {
                                str = attributeValue;
                                continue;
                                continue;
                                continue;
                                continue;
                                continue;
                                continue;
                            }
                        case 1:
                            j18 = parseTimeExpression(attributeValue, frameAndTickRate);
                            break;
                        case 2:
                            j17 = parseTimeExpression(attributeValue, frameAndTickRate);
                            break;
                        case 3:
                            j16 = parseTimeExpression(attributeValue, frameAndTickRate);
                            break;
                        case 4:
                            String[] parseStyleIds = parseStyleIds(attributeValue);
                            if (parseStyleIds.length > 0) {
                                strArr = parseStyleIds;
                                break;
                            }
                            break;
                    }
                case 99841:
                    if (attributeName.equals(ATTR_DURATION)) {
                        c16 = 1;
                    }
                    switch (c16) {
                    }
                    break;
                case 100571:
                    if (attributeName.equals("end")) {
                        c16 = 2;
                    }
                    switch (c16) {
                    }
                    break;
                case 93616297:
                    if (attributeName.equals(ATTR_BEGIN)) {
                        c16 = 3;
                    }
                    switch (c16) {
                    }
                    break;
                case 109780401:
                    if (attributeName.equals("style")) {
                        c16 = 4;
                    }
                    switch (c16) {
                    }
                    break;
                default:
                    switch (c16) {
                    }
                    break;
            }
        }
        if (ttmlNode != null) {
            long j19 = ttmlNode.startTimeUs;
            if (j19 != -9223372036854775807L) {
                if (j16 != -9223372036854775807L) {
                    j16 += j19;
                }
                if (j17 != -9223372036854775807L) {
                    j17 += j19;
                }
            }
        }
        if (j17 == -9223372036854775807L) {
            if (j18 != -9223372036854775807L) {
                j3 = j16 + j18;
            } else if (ttmlNode != null) {
                long j26 = ttmlNode.endTimeUs;
                if (j26 != -9223372036854775807L) {
                    j3 = j26;
                }
            }
            return TtmlNode.buildNode(xmlPullParser.getName(), j16, j3, parseStyleAttributes, strArr, str);
        }
        j3 = j17;
        return TtmlNode.buildNode(xmlPullParser.getName(), j16, j3, parseStyleAttributes, strArr, str);
    }

    private TtmlRegion parseRegionAttributes(XmlPullParser xmlPullParser) {
        float f16;
        String attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, "id");
        if (attributeValue == null) {
            return null;
        }
        String attributeValue2 = XmlPullParserUtil.getAttributeValue(xmlPullParser, TtmlNode.ATTR_TTS_ORIGIN);
        if (attributeValue2 != null) {
            Pattern pattern = PERCENTAGE_COORDINATES;
            Matcher matcher = pattern.matcher(attributeValue2);
            if (matcher.matches()) {
                int i3 = 1;
                try {
                    float parseFloat = Float.parseFloat(matcher.group(1)) / 100.0f;
                    float parseFloat2 = Float.parseFloat(matcher.group(2)) / 100.0f;
                    String attributeValue3 = XmlPullParserUtil.getAttributeValue(xmlPullParser, TtmlNode.ATTR_TTS_EXTENT);
                    if (attributeValue3 != null) {
                        Matcher matcher2 = pattern.matcher(attributeValue3);
                        if (matcher2.matches()) {
                            try {
                                float parseFloat3 = Float.parseFloat(matcher2.group(1)) / 100.0f;
                                float parseFloat4 = Float.parseFloat(matcher2.group(2)) / 100.0f;
                                String attributeValue4 = XmlPullParserUtil.getAttributeValue(xmlPullParser, TtmlNode.ATTR_TTS_DISPLAY_ALIGN);
                                if (attributeValue4 != null) {
                                    String lowerInvariant = Util.toLowerInvariant(attributeValue4);
                                    lowerInvariant.hashCode();
                                    if (!lowerInvariant.equals("center")) {
                                        if (lowerInvariant.equals("after")) {
                                            f16 = parseFloat2 + parseFloat4;
                                            i3 = 2;
                                            return new TtmlRegion(attributeValue, parseFloat, f16, 0, i3, parseFloat3);
                                        }
                                    } else {
                                        parseFloat2 += parseFloat4 / 2.0f;
                                        f16 = parseFloat2;
                                        return new TtmlRegion(attributeValue, parseFloat, f16, 0, i3, parseFloat3);
                                    }
                                }
                                i3 = 0;
                                f16 = parseFloat2;
                                return new TtmlRegion(attributeValue, parseFloat, f16, 0, i3, parseFloat3);
                            } catch (NumberFormatException unused) {
                                Log.w(TAG, "Ignoring region with malformed extent: " + attributeValue2);
                                return null;
                            }
                        }
                        Log.w(TAG, "Ignoring region with unsupported extent: " + attributeValue2);
                        return null;
                    }
                    Log.w(TAG, "Ignoring region without an extent");
                    return null;
                } catch (NumberFormatException unused2) {
                    Log.w(TAG, "Ignoring region with malformed origin: " + attributeValue2);
                    return null;
                }
            }
            Log.w(TAG, "Ignoring region with unsupported origin: " + attributeValue2);
            return null;
        }
        Log.w(TAG, "Ignoring region without an origin");
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x013e, code lost:
    
        if (r3.equals(com.google.android.exoplayer2.text.ttml.TtmlNode.LINETHROUGH) == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01a8, code lost:
    
        if (r3.equals("start") == false) goto L87;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private TtmlStyle parseStyleAttributes(XmlPullParser xmlPullParser, TtmlStyle ttmlStyle) {
        char c16;
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i3 = 0; i3 < attributeCount; i3++) {
            String attributeValue = xmlPullParser.getAttributeValue(i3);
            String attributeName = xmlPullParser.getAttributeName(i3);
            attributeName.hashCode();
            char c17 = 4;
            char c18 = 3;
            switch (attributeName.hashCode()) {
                case -1550943582:
                    if (attributeName.equals("fontStyle")) {
                        c16 = 0;
                        break;
                    }
                    break;
                case -1224696685:
                    if (attributeName.equals("fontFamily")) {
                        c16 = 1;
                        break;
                    }
                    break;
                case -1065511464:
                    if (attributeName.equals("textAlign")) {
                        c16 = 2;
                        break;
                    }
                    break;
                case -879295043:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_TEXT_DECORATION)) {
                        c16 = 3;
                        break;
                    }
                    break;
                case -734428249:
                    if (attributeName.equals("fontWeight")) {
                        c16 = 4;
                        break;
                    }
                    break;
                case 3355:
                    if (attributeName.equals("id")) {
                        c16 = 5;
                        break;
                    }
                    break;
                case 94842723:
                    if (attributeName.equals("color")) {
                        c16 = 6;
                        break;
                    }
                    break;
                case 365601008:
                    if (attributeName.equals("fontSize")) {
                        c16 = 7;
                        break;
                    }
                    break;
                case 1287124693:
                    if (attributeName.equals("backgroundColor")) {
                        c16 = '\b';
                        break;
                    }
                    break;
            }
            c16 = '\uffff';
            switch (c16) {
                case 0:
                    ttmlStyle = createIfNull(ttmlStyle).setItalic("italic".equalsIgnoreCase(attributeValue));
                    break;
                case 1:
                    ttmlStyle = createIfNull(ttmlStyle).setFontFamily(attributeValue);
                    break;
                case 2:
                    String lowerInvariant = Util.toLowerInvariant(attributeValue);
                    lowerInvariant.hashCode();
                    switch (lowerInvariant.hashCode()) {
                        case -1364013995:
                            if (lowerInvariant.equals("center")) {
                                c17 = 0;
                                break;
                            }
                            break;
                        case 100571:
                            if (lowerInvariant.equals("end")) {
                                c17 = 1;
                                break;
                            }
                            break;
                        case 3317767:
                            if (lowerInvariant.equals("left")) {
                                c17 = 2;
                                break;
                            }
                            break;
                        case 108511772:
                            if (lowerInvariant.equals("right")) {
                                c17 = 3;
                                break;
                            }
                            break;
                        case 109757538:
                            break;
                    }
                    c17 = '\uffff';
                    switch (c17) {
                        case 0:
                            ttmlStyle = createIfNull(ttmlStyle).setTextAlign(Layout.Alignment.ALIGN_CENTER);
                            break;
                        case 1:
                            ttmlStyle = createIfNull(ttmlStyle).setTextAlign(Layout.Alignment.ALIGN_OPPOSITE);
                            break;
                        case 2:
                            ttmlStyle = createIfNull(ttmlStyle).setTextAlign(Layout.Alignment.ALIGN_NORMAL);
                            break;
                        case 3:
                            ttmlStyle = createIfNull(ttmlStyle).setTextAlign(Layout.Alignment.ALIGN_OPPOSITE);
                            break;
                        case 4:
                            ttmlStyle = createIfNull(ttmlStyle).setTextAlign(Layout.Alignment.ALIGN_NORMAL);
                            break;
                    }
                case 3:
                    String lowerInvariant2 = Util.toLowerInvariant(attributeValue);
                    lowerInvariant2.hashCode();
                    switch (lowerInvariant2.hashCode()) {
                        case -1461280213:
                            if (lowerInvariant2.equals(TtmlNode.NO_UNDERLINE)) {
                                c18 = 0;
                                break;
                            }
                            break;
                        case -1026963764:
                            if (lowerInvariant2.equals("underline")) {
                                c18 = 1;
                                break;
                            }
                            break;
                        case 913457136:
                            if (lowerInvariant2.equals(TtmlNode.NO_LINETHROUGH)) {
                                c18 = 2;
                                break;
                            }
                            break;
                        case 1679736913:
                            break;
                    }
                    c18 = '\uffff';
                    switch (c18) {
                        case 0:
                            ttmlStyle = createIfNull(ttmlStyle).setUnderline(false);
                            break;
                        case 1:
                            ttmlStyle = createIfNull(ttmlStyle).setUnderline(true);
                            break;
                        case 2:
                            ttmlStyle = createIfNull(ttmlStyle).setLinethrough(false);
                            break;
                        case 3:
                            ttmlStyle = createIfNull(ttmlStyle).setLinethrough(true);
                            break;
                    }
                case 4:
                    ttmlStyle = createIfNull(ttmlStyle).setBold("bold".equalsIgnoreCase(attributeValue));
                    break;
                case 5:
                    if ("style".equals(xmlPullParser.getName())) {
                        ttmlStyle = createIfNull(ttmlStyle).setId(attributeValue);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    ttmlStyle = createIfNull(ttmlStyle);
                    try {
                        ttmlStyle.setFontColor(ColorParser.parseTtmlColor(attributeValue));
                        break;
                    } catch (IllegalArgumentException unused) {
                        Log.w(TAG, "Failed parsing color value: " + attributeValue);
                        break;
                    }
                case 7:
                    try {
                        ttmlStyle = createIfNull(ttmlStyle);
                        parseFontSize(attributeValue, ttmlStyle);
                        break;
                    } catch (SubtitleDecoderException unused2) {
                        Log.w(TAG, "Failed parsing fontSize value: " + attributeValue);
                        break;
                    }
                case '\b':
                    ttmlStyle = createIfNull(ttmlStyle);
                    try {
                        ttmlStyle.setBackgroundColor(ColorParser.parseTtmlColor(attributeValue));
                        break;
                    } catch (IllegalArgumentException unused3) {
                        Log.w(TAG, "Failed parsing background value: " + attributeValue);
                        break;
                    }
            }
        }
        return ttmlStyle;
    }

    private String[] parseStyleIds(String str) {
        return str.split("\\s+");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x009f, code lost:
    
        if (r13.equals("ms") == false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long parseTimeExpression(String str, FrameAndTickRate frameAndTickRate) throws SubtitleDecoderException {
        double d16;
        double d17;
        double d18;
        double d19;
        Matcher matcher = CLOCK_TIME.matcher(str);
        char c16 = 4;
        if (matcher.matches()) {
            double parseLong = (Long.parseLong(matcher.group(1)) * 3600) + (Long.parseLong(matcher.group(2)) * 60) + Long.parseLong(matcher.group(3));
            String group = matcher.group(4);
            double d26 = 0.0d;
            if (group != null) {
                d18 = Double.parseDouble(group);
            } else {
                d18 = 0.0d;
            }
            double d27 = parseLong + d18;
            String group2 = matcher.group(5);
            if (group2 != null) {
                d19 = ((float) Long.parseLong(group2)) / frameAndTickRate.effectiveFrameRate;
            } else {
                d19 = 0.0d;
            }
            double d28 = d27 + d19;
            if (matcher.group(6) != null) {
                d26 = (Long.parseLong(r13) / frameAndTickRate.subFrameRate) / frameAndTickRate.effectiveFrameRate;
            }
            return (long) ((d28 + d26) * 1000000.0d);
        }
        Matcher matcher2 = OFFSET_TIME.matcher(str);
        if (matcher2.matches()) {
            double parseDouble = Double.parseDouble(matcher2.group(1));
            String group3 = matcher2.group(2);
            group3.hashCode();
            switch (group3.hashCode()) {
                case 102:
                    if (group3.equals("f")) {
                        c16 = 0;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 104:
                    if (group3.equals(h.F)) {
                        c16 = 1;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 109:
                    if (group3.equals(QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO)) {
                        c16 = 2;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 116:
                    if (group3.equals("t")) {
                        c16 = 3;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 3494:
                    break;
                default:
                    c16 = '\uffff';
                    break;
            }
            switch (c16) {
                case 0:
                    d16 = frameAndTickRate.effectiveFrameRate;
                    parseDouble /= d16;
                    break;
                case 1:
                    d17 = 3600.0d;
                    break;
                case 2:
                    d17 = 60.0d;
                    break;
                case 3:
                    d16 = frameAndTickRate.tickRate;
                    parseDouble /= d16;
                    break;
                case 4:
                    d16 = 1000.0d;
                    parseDouble /= d16;
                    break;
            }
            parseDouble *= d17;
            return (long) (parseDouble * 1000000.0d);
        }
        throw new SubtitleDecoderException("Malformed time expression: " + str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public TtmlSubtitle decode(byte[] bArr, int i3, boolean z16) throws SubtitleDecoderException {
        try {
            XmlPullParser newPullParser = this.xmlParserFactory.newPullParser();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            TtmlSubtitle ttmlSubtitle = null;
            hashMap2.put("", new TtmlRegion(null));
            int i16 = 0;
            newPullParser.setInput(new ByteArrayInputStream(bArr, 0, i3), null);
            LinkedList linkedList = new LinkedList();
            FrameAndTickRate frameAndTickRate = DEFAULT_FRAME_AND_TICK_RATE;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.getEventType()) {
                TtmlNode ttmlNode = (TtmlNode) linkedList.peekLast();
                if (i16 == 0) {
                    String name = newPullParser.getName();
                    if (eventType == 2) {
                        if (TtmlNode.TAG_TT.equals(name)) {
                            frameAndTickRate = parseFrameAndTickRates(newPullParser);
                        }
                        if (!isSupportedTag(name)) {
                            Log.i(TAG, "Ignoring unsupported tag: " + newPullParser.getName());
                        } else if ("head".equals(name)) {
                            parseHeader(newPullParser, hashMap, hashMap2);
                        } else {
                            try {
                                TtmlNode parseNode = parseNode(newPullParser, ttmlNode, hashMap2, frameAndTickRate);
                                linkedList.addLast(parseNode);
                                if (ttmlNode != null) {
                                    ttmlNode.addChild(parseNode);
                                }
                            } catch (SubtitleDecoderException e16) {
                                Log.w(TAG, "Suppressing parser error", e16);
                            }
                        }
                        i16++;
                    } else if (eventType == 4) {
                        ttmlNode.addChild(TtmlNode.buildTextNode(newPullParser.getText()));
                    } else if (eventType == 3) {
                        if (newPullParser.getName().equals(TtmlNode.TAG_TT)) {
                            ttmlSubtitle = new TtmlSubtitle((TtmlNode) linkedList.getLast(), hashMap, hashMap2);
                        }
                        linkedList.removeLast();
                    }
                } else {
                    if (eventType != 2) {
                        if (eventType == 3) {
                            i16--;
                        }
                    }
                    i16++;
                }
                newPullParser.next();
            }
            return ttmlSubtitle;
        } catch (IOException e17) {
            throw new IllegalStateException("Unexpected error when reading input.", e17);
        } catch (XmlPullParserException e18) {
            throw new SubtitleDecoderException("Unable to decode source", e18);
        }
    }
}
