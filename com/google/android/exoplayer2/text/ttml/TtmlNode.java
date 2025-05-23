package com.google.android.exoplayer2.text.ttml;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* compiled from: P */
/* loaded from: classes2.dex */
final class TtmlNode {
    public static final String ANONYMOUS_REGION_ID = "";
    public static final String ATTR_ID = "id";
    public static final String ATTR_TTS_BACKGROUND_COLOR = "backgroundColor";
    public static final String ATTR_TTS_COLOR = "color";
    public static final String ATTR_TTS_DISPLAY_ALIGN = "displayAlign";
    public static final String ATTR_TTS_EXTENT = "extent";
    public static final String ATTR_TTS_FONT_FAMILY = "fontFamily";
    public static final String ATTR_TTS_FONT_SIZE = "fontSize";
    public static final String ATTR_TTS_FONT_STYLE = "fontStyle";
    public static final String ATTR_TTS_FONT_WEIGHT = "fontWeight";
    public static final String ATTR_TTS_ORIGIN = "origin";
    public static final String ATTR_TTS_TEXT_ALIGN = "textAlign";
    public static final String ATTR_TTS_TEXT_DECORATION = "textDecoration";
    public static final String BOLD = "bold";
    public static final String CENTER = "center";
    public static final String END = "end";
    public static final String ITALIC = "italic";
    public static final String LEFT = "left";
    public static final String LINETHROUGH = "linethrough";
    public static final String NO_LINETHROUGH = "nolinethrough";
    public static final String NO_UNDERLINE = "nounderline";
    public static final String RIGHT = "right";
    public static final String START = "start";
    public static final String TAG_BODY = "body";
    public static final String TAG_BR = "br";
    public static final String TAG_DIV = "div";
    public static final String TAG_HEAD = "head";
    public static final String TAG_LAYOUT = "layout";
    public static final String TAG_METADATA = "metadata";
    public static final String TAG_P = "p";
    public static final String TAG_REGION = "region";
    public static final String TAG_SMPTE_DATA = "smpte:data";
    public static final String TAG_SMPTE_IMAGE = "smpte:image";
    public static final String TAG_SMPTE_INFORMATION = "smpte:information";
    public static final String TAG_SPAN = "span";
    public static final String TAG_STYLE = "style";
    public static final String TAG_STYLING = "styling";
    public static final String TAG_TT = "tt";
    public static final String UNDERLINE = "underline";
    private List<TtmlNode> children;
    public final long endTimeUs;
    public final boolean isTextNode;
    private final HashMap<String, Integer> nodeEndsByRegion;
    private final HashMap<String, Integer> nodeStartsByRegion;
    public final String regionId;
    public final long startTimeUs;
    public final TtmlStyle style;
    private final String[] styleIds;
    public final String tag;
    public final String text;

    TtmlNode(String str, String str2, long j3, long j16, TtmlStyle ttmlStyle, String[] strArr, String str3) {
        boolean z16;
        this.tag = str;
        this.text = str2;
        this.style = ttmlStyle;
        this.styleIds = strArr;
        if (str2 != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isTextNode = z16;
        this.startTimeUs = j3;
        this.endTimeUs = j16;
        this.regionId = (String) Assertions.checkNotNull(str3);
        this.nodeStartsByRegion = new HashMap<>();
        this.nodeEndsByRegion = new HashMap<>();
    }

    private void applyStyleToOutput(Map<String, TtmlStyle> map, SpannableStringBuilder spannableStringBuilder, int i3, int i16) {
        TtmlStyle resolveStyle;
        if (i3 != i16 && (resolveStyle = TtmlRenderUtil.resolveStyle(this.style, this.styleIds, map)) != null) {
            TtmlRenderUtil.applyStylesToSpan(spannableStringBuilder, i3, i16, resolveStyle);
        }
    }

    public static TtmlNode buildNode(String str, long j3, long j16, TtmlStyle ttmlStyle, String[] strArr, String str2) {
        return new TtmlNode(str, null, j3, j16, ttmlStyle, strArr, str2);
    }

    public static TtmlNode buildTextNode(String str) {
        return new TtmlNode(null, TtmlRenderUtil.applyTextElementSpacePolicy(str), -9223372036854775807L, -9223372036854775807L, null, null, "");
    }

    private SpannableStringBuilder cleanUpText(SpannableStringBuilder spannableStringBuilder) {
        int i3;
        int i16;
        int length = spannableStringBuilder.length();
        int i17 = 0;
        for (int i18 = 0; i18 < length; i18++) {
            if (spannableStringBuilder.charAt(i18) == ' ') {
                int i19 = i18 + 1;
                int i26 = i19;
                while (i26 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i26) == ' ') {
                    i26++;
                }
                int i27 = i26 - i19;
                if (i27 > 0) {
                    spannableStringBuilder.delete(i18, i18 + i27);
                    length -= i27;
                }
            }
        }
        if (length > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
            length--;
        }
        int i28 = 0;
        while (true) {
            i3 = length - 1;
            if (i28 >= i3) {
                break;
            }
            if (spannableStringBuilder.charAt(i28) == '\n') {
                int i29 = i28 + 1;
                if (spannableStringBuilder.charAt(i29) == ' ') {
                    spannableStringBuilder.delete(i29, i28 + 2);
                    length--;
                }
            }
            i28++;
        }
        if (length > 0 && spannableStringBuilder.charAt(i3) == ' ') {
            spannableStringBuilder.delete(i3, length);
            length--;
        }
        while (true) {
            i16 = length - 1;
            if (i17 >= i16) {
                break;
            }
            if (spannableStringBuilder.charAt(i17) == ' ') {
                int i36 = i17 + 1;
                if (spannableStringBuilder.charAt(i36) == '\n') {
                    spannableStringBuilder.delete(i17, i36);
                    length--;
                }
            }
            i17++;
        }
        if (length > 0 && spannableStringBuilder.charAt(i16) == '\n') {
            spannableStringBuilder.delete(i16, length);
        }
        return spannableStringBuilder;
    }

    private void getEventTimes(TreeSet<Long> treeSet, boolean z16) {
        boolean z17;
        boolean equals = "p".equals(this.tag);
        if (z16 || equals) {
            long j3 = this.startTimeUs;
            if (j3 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j3));
            }
            long j16 = this.endTimeUs;
            if (j16 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j16));
            }
        }
        if (this.children == null) {
            return;
        }
        for (int i3 = 0; i3 < this.children.size(); i3++) {
            TtmlNode ttmlNode = this.children.get(i3);
            if (!z16 && !equals) {
                z17 = false;
            } else {
                z17 = true;
            }
            ttmlNode.getEventTimes(treeSet, z17);
        }
    }

    private static SpannableStringBuilder getRegionOutput(String str, Map<String, SpannableStringBuilder> map) {
        if (!map.containsKey(str)) {
            map.put(str, new SpannableStringBuilder());
        }
        return map.get(str);
    }

    private void traverseForStyle(Map<String, TtmlStyle> map, Map<String, SpannableStringBuilder> map2) {
        int i3;
        for (Map.Entry<String, Integer> entry : this.nodeEndsByRegion.entrySet()) {
            String key = entry.getKey();
            if (this.nodeStartsByRegion.containsKey(key)) {
                i3 = this.nodeStartsByRegion.get(key).intValue();
            } else {
                i3 = 0;
            }
            applyStyleToOutput(map, map2.get(key), i3, entry.getValue().intValue());
            for (int i16 = 0; i16 < getChildCount(); i16++) {
                getChild(i16).traverseForStyle(map, map2);
            }
        }
    }

    private void traverseForText(long j3, boolean z16, String str, Map<String, SpannableStringBuilder> map) {
        boolean z17;
        this.nodeStartsByRegion.clear();
        this.nodeEndsByRegion.clear();
        String str2 = this.regionId;
        if (!"".equals(str2)) {
            str = str2;
        }
        if (this.isTextNode && z16) {
            getRegionOutput(str, map).append((CharSequence) this.text);
            return;
        }
        if (TAG_BR.equals(this.tag) && z16) {
            getRegionOutput(str, map).append('\n');
            return;
        }
        if (!TAG_METADATA.equals(this.tag) && isActive(j3)) {
            boolean equals = "p".equals(this.tag);
            for (Map.Entry<String, SpannableStringBuilder> entry : map.entrySet()) {
                this.nodeStartsByRegion.put(entry.getKey(), Integer.valueOf(entry.getValue().length()));
            }
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                TtmlNode child = getChild(i3);
                if (!z16 && !equals) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                child.traverseForText(j3, z17, str, map);
            }
            if (equals) {
                TtmlRenderUtil.endParagraph(getRegionOutput(str, map));
            }
            for (Map.Entry<String, SpannableStringBuilder> entry2 : map.entrySet()) {
                this.nodeEndsByRegion.put(entry2.getKey(), Integer.valueOf(entry2.getValue().length()));
            }
        }
    }

    public void addChild(TtmlNode ttmlNode) {
        if (this.children == null) {
            this.children = new ArrayList();
        }
        this.children.add(ttmlNode);
    }

    public TtmlNode getChild(int i3) {
        List<TtmlNode> list = this.children;
        if (list != null) {
            return list.get(i3);
        }
        throw new IndexOutOfBoundsException();
    }

    public int getChildCount() {
        List<TtmlNode> list = this.children;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<Cue> getCues(long j3, Map<String, TtmlStyle> map, Map<String, TtmlRegion> map2) {
        TreeMap treeMap = new TreeMap();
        traverseForText(j3, false, this.regionId, treeMap);
        traverseForStyle(map, treeMap);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : treeMap.entrySet()) {
            TtmlRegion ttmlRegion = map2.get(entry.getKey());
            arrayList.add(new Cue(cleanUpText((SpannableStringBuilder) entry.getValue()), null, ttmlRegion.line, ttmlRegion.lineType, ttmlRegion.lineAnchor, ttmlRegion.position, Integer.MIN_VALUE, ttmlRegion.width));
        }
        return arrayList;
    }

    public long[] getEventTimesUs() {
        TreeSet<Long> treeSet = new TreeSet<>();
        int i3 = 0;
        getEventTimes(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator<Long> it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i3] = it.next().longValue();
            i3++;
        }
        return jArr;
    }

    public String[] getStyleIds() {
        return this.styleIds;
    }

    public boolean isActive(long j3) {
        long j16 = this.startTimeUs;
        if ((j16 == -9223372036854775807L && this.endTimeUs == -9223372036854775807L) || ((j16 <= j3 && this.endTimeUs == -9223372036854775807L) || ((j16 == -9223372036854775807L && j3 < this.endTimeUs) || (j16 <= j3 && j3 < this.endTimeUs)))) {
            return true;
        }
        return false;
    }
}
