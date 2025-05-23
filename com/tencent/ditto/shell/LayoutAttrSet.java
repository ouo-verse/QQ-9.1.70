package com.tencent.ditto.shell;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.ditto.utils.DittoLog;
import com.tencent.ditto.utils.DittoResourcesUtil;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class LayoutAttrSet {
    public static final int VALUE_NOT_SET = Integer.MIN_VALUE;
    public String above;
    public String alignBottom;
    public String alignLeft;
    public boolean alignParentBottom;
    public boolean alignParentLeft;
    public boolean alignParentRight;
    public boolean alignParentTop;
    public String alignRight;
    public String alignTop;
    public boolean alignWithParentIfMissing;
    public String below;
    public int bottom;
    public int bottomLeftRadius;
    public int bottomMargin;
    public int bottomPadding;
    public int bottomRightRadius;
    public int bottomShadowSize;
    public boolean centerHorizontal;
    public boolean centerInParent;
    public boolean centerVertical;
    public String gradientDirection;
    public int gradientEndColor;
    public int gradientStartColor;

    /* renamed from: id, reason: collision with root package name */
    public String f100546id;
    public int left;
    public int leftMargin;
    public int leftPadding;
    public int leftShadowSize;
    public int pressedAlpha;
    public int right;
    public int rightMargin;
    public int rightPadding;
    public int rightShadowSize;
    public int shadowResourceId;
    public String toLeftOf;
    public String toRightOf;
    public int top;
    public int topLeftRadius;
    public int topMargin;
    public int topPadding;
    public int topRightRadius;
    public int topShadowSize;
    static Map<String, Integer> attrValueCache = new ConcurrentHashMap();
    static long parseIntegerTotal = 0;
    static long count = 0;
    public Map<String, Object> mAttrs = new ConcurrentHashMap();
    public int width = -2;
    public int height = -2;
    public int orientation = 1;
    public int layout_gravity = 3;
    public int gravity = 3;
    public int weight = 0;
    public int bg_color = 0;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface ValueIndicator {
        boolean onJsonField(String str, Object obj);
    }

    public static LayoutAttrSet createFrom(JSONObject jSONObject) {
        return createFrom(jSONObject, null);
    }

    private Integer isDpOrPxValue(String str, float f16, int i3, char[] cArr, int i16) {
        char c16 = cArr[i16];
        if (c16 == 'd' && cArr[i16 + 1] == 'p') {
            float f17 = i3;
            attrValueCache.put(str, Integer.valueOf((int) (DittoUIEngine.g().getDensity() * f16 * f17)));
            return Integer.valueOf((int) (DittoUIEngine.g().getDensity() * f16 * f17));
        }
        if (c16 == 'p' && cArr[i16 + 1] == 'x') {
            int i17 = ((int) f16) * i3;
            attrValueCache.put(str, Integer.valueOf(i17));
            return Integer.valueOf(i17);
        }
        return null;
    }

    private int parseColor(String str) {
        try {
            return DittoResourcesUtil.parseColor(str);
        } catch (Throwable th5) {
            DittoLog.e(DittoLog.defaultTag, "the text " + str + " can't be parsed as color string", th5);
            return 0;
        }
    }

    private void parseContentB(String str, Object obj) {
        if (LayoutAttrDefine.ShadowSize.equals(str)) {
            parseShadowSize(obj.toString());
            return;
        }
        if (LayoutAttrDefine.BG_Color.equals(str)) {
            this.bg_color = parseColor(obj.toString());
            return;
        }
        if (LayoutAttrDefine.CENTER_VERTICAL.equals(str)) {
            this.centerVertical = ((Boolean) obj).booleanValue();
            return;
        }
        if (LayoutAttrDefine.CENTER_HORIZONTAL.equals(str)) {
            this.centerHorizontal = ((Boolean) obj).booleanValue();
            return;
        }
        if (LayoutAttrDefine.CENTER_IN_PARENT.equals(str)) {
            this.centerInParent = ((Boolean) obj).booleanValue();
            return;
        }
        if (LayoutAttrDefine.ALIGN_PARENT_LEFT.equals(str)) {
            this.alignParentLeft = ((Boolean) obj).booleanValue();
            return;
        }
        if (LayoutAttrDefine.ALIGN_PARENT_BOTTOM.equals(str)) {
            this.alignParentBottom = ((Boolean) obj).booleanValue();
            return;
        }
        if (LayoutAttrDefine.ALIGN_PARENT_RIGHT.equals(str)) {
            this.alignParentRight = ((Boolean) obj).booleanValue();
        } else if (LayoutAttrDefine.ALIGN_PARENT_TOP.equals(str)) {
            this.alignParentTop = ((Boolean) obj).booleanValue();
        } else {
            parseContentC(str, obj);
        }
    }

    private void parseContentC(String str, Object obj) {
        if (LayoutAttrDefine.ALIGN_WITH_PARENT_IF_MISSING.equals(str)) {
            this.alignWithParentIfMissing = ((Boolean) obj).booleanValue();
            return;
        }
        if (LayoutAttrDefine.ALIGN_TOP.equals(str)) {
            this.alignTop = obj.toString();
            return;
        }
        if (LayoutAttrDefine.ALIGN_BOTTOM.equals(str)) {
            this.alignBottom = obj.toString();
            return;
        }
        if (LayoutAttrDefine.ALIGN_LEFT.equals(str)) {
            this.alignLeft = obj.toString();
            return;
        }
        if (LayoutAttrDefine.ALIGN_RIGHT.equals(str)) {
            this.alignRight = obj.toString();
            return;
        }
        if (LayoutAttrDefine.ABOVE.equals(str)) {
            this.above = obj.toString();
            return;
        }
        if (LayoutAttrDefine.BELOW.equals(str)) {
            this.below = obj.toString();
            return;
        }
        if (LayoutAttrDefine.TO_LEFT_OF.equals(str)) {
            this.toLeftOf = obj.toString();
        } else if (LayoutAttrDefine.TO_RIGHT_OF.equals(str)) {
            this.toRightOf = obj.toString();
        } else {
            parseContentD(str, obj);
        }
    }

    private void parseContentD(String str, Object obj) {
        if (LayoutAttrDefine.MARGIN_LEFT.equals(str)) {
            this.leftMargin = parseInteger(obj.toString());
            return;
        }
        if (LayoutAttrDefine.MARGIN_RIGHT.equals(str)) {
            this.rightMargin = parseInteger(obj.toString());
            return;
        }
        if (LayoutAttrDefine.MARGIN_TOP.equals(str)) {
            this.topMargin = parseInteger(obj.toString());
            return;
        }
        if (LayoutAttrDefine.MARGIN_BOTTOM.equals(str)) {
            this.bottomMargin = parseInteger(obj.toString());
            return;
        }
        if (LayoutAttrDefine.PADDING_LEFT.equals(str)) {
            this.leftPadding = parseInteger(obj.toString());
            return;
        }
        if (LayoutAttrDefine.PADDING_RIGHT.equals(str)) {
            this.rightPadding = parseInteger(obj.toString());
            return;
        }
        if (LayoutAttrDefine.PADDING_TOP.equals(str)) {
            this.topPadding = parseInteger(obj.toString());
            return;
        }
        if (LayoutAttrDefine.PADDING_BOTTOM.equals(str)) {
            this.bottomPadding = parseInteger(obj.toString());
        } else if (LayoutAttrDefine.ShadowResourceId.equals(str)) {
            this.shadowResourceId = DittoUIEngine.g().getResourceId(obj.toString());
        } else {
            parseContentE(str, obj);
        }
    }

    private void parseContentE(String str, Object obj) {
        if (LayoutAttrDefine.BorderRadii4.equals(str)) {
            parseRadii4(obj.toString());
            return;
        }
        if (LayoutAttrDefine.BG_GRADIENT_DIRECTION.equals(str)) {
            this.gradientDirection = obj.toString();
            return;
        }
        if (LayoutAttrDefine.BG_GRADIENT_START_COLOR.equals(str)) {
            this.gradientStartColor = parseColor(obj.toString());
            return;
        }
        if (LayoutAttrDefine.BG_GRADIENT_END_COLOR.equals(str)) {
            this.gradientEndColor = parseColor(obj.toString());
        } else if (LayoutAttrDefine.PRESSED_ALPHA.equals(str)) {
            this.pressedAlpha = parseInteger(obj.toString());
        } else if ("weight".equals(str)) {
            this.weight = ((Integer) obj).intValue();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Integer parseIntegerNormal(String str) {
        char c16;
        str.hashCode();
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    c16 = 0;
                    break;
                }
                c16 = '\uffff';
                break;
            case 1443:
                if (str.equals("-0")) {
                    c16 = 1;
                    break;
                }
                c16 = '\uffff';
                break;
            case 343327108:
                if (str.equals(ParseCommon.LAYOUT_PARAMS_WRAP_CONTENT)) {
                    c16 = 2;
                    break;
                }
                c16 = '\uffff';
                break;
            case 1386124388:
                if (str.equals(ParseCommon.LAYOUT_PARAMS_MATCH_PARENT)) {
                    c16 = 3;
                    break;
                }
                c16 = '\uffff';
                break;
            default:
                c16 = '\uffff';
                break;
        }
        switch (c16) {
            case 0:
            case 1:
                return 0;
            case 2:
                return -2;
            case 3:
                return -1;
            default:
                return null;
        }
    }

    public void addLayoutAttr(String str, Object obj) {
        parseContent(str, obj);
        this.mAttrs.put(str, obj);
    }

    public String getAttr(String str, String str2) {
        try {
            return (String) this.mAttrs.get(str);
        } catch (Exception unused) {
            return str2;
        }
    }

    public <T> T getAttrWithDefault(String str, T t16) {
        try {
            T t17 = (T) this.mAttrs.get(str);
            if (t17 != null) {
                if (t16.getClass().isInstance(t17)) {
                    return t17;
                }
            }
            return t16;
        } catch (Exception unused) {
            return null;
        }
    }

    public int[] getIntArrayAttr(String str) {
        if (this.mAttrs.containsKey(str) && (this.mAttrs.get(str) instanceof JSONArray)) {
            JSONArray jSONArray = (JSONArray) this.mAttrs.get(str);
            int length = jSONArray.length();
            int[] iArr = new int[length];
            for (int i3 = 0; i3 < length; i3++) {
                try {
                    iArr[i3] = jSONArray.optInt(i3);
                } catch (Exception unused) {
                    return new int[0];
                }
            }
            return iArr;
        }
        return new int[0];
    }

    public int getPostFixedAttr(String str, int i3) {
        try {
            Object obj = this.mAttrs.get(str);
            if (obj != null) {
                return parseInteger((String) obj);
            }
            return i3;
        } catch (Exception unused) {
            return i3;
        }
    }

    public int getResourceId(String str) {
        return DittoUIEngine.g().getResourceId(getAttr(str, ""));
    }

    public boolean hasAttr(String str) {
        return this.mAttrs.containsKey(str);
    }

    protected void parseContent(String str, Object obj) {
        try {
            if ("id".equals(str)) {
                this.f100546id = obj.toString();
            } else if ("width".equals(str)) {
                this.width = parseInteger(obj.toString());
            } else if ("height".equals(str)) {
                this.height = parseInteger(obj.toString());
            } else if ("orientation".equals(str)) {
                this.orientation = LayoutAttrDefine.Orientation.parse(obj.toString());
            } else if (LayoutAttrDefine.Gravity.Layout_Gravity.equals(str)) {
                this.layout_gravity = LayoutAttrDefine.Gravity.parse(obj.toString());
            } else if (LayoutAttrDefine.Gravity.Gravity.equals(str)) {
                this.gravity = LayoutAttrDefine.Gravity.parse(obj.toString());
            } else if ("margin".equals(str)) {
                parseMargin(obj.toString());
            } else if ("padding".equals(str)) {
                parsePadding(obj.toString());
            } else {
                parseContentB(str, obj);
            }
        } catch (Exception e16) {
            DittoLog.e(DittoLog.defaultTag, String.format("parse attr err: %s : %s", str, obj.toString()), e16);
        }
    }

    public int parseInteger(String str) {
        if (attrValueCache.containsKey(str)) {
            return attrValueCache.get(str).intValue();
        }
        Integer parseIntegerNormal = parseIntegerNormal(str);
        if (parseIntegerNormal != null) {
            return parseIntegerNormal.intValue();
        }
        String replaceAll = str.replaceAll(" ", "");
        char[] charArray = replaceAll.toCharArray();
        int i3 = 10;
        boolean z16 = false;
        float f16 = 0.0f;
        int i16 = 1;
        for (int i17 = 0; i17 < charArray.length; i17++) {
            char c16 = charArray[i17];
            if (c16 >= '0' && c16 <= '9') {
                if (z16) {
                    f16 += Integer.parseInt(Character.valueOf(c16).toString()) / i3;
                    i3 *= 10;
                } else {
                    f16 = (f16 * 10.0f) + Integer.parseInt(Character.valueOf(c16).toString());
                }
            } else if (c16 == '.') {
                z16 = true;
            } else if (c16 == '-') {
                i16 = -1;
            } else {
                Integer isDpOrPxValue = isDpOrPxValue(replaceAll, f16, i16, charArray, i17);
                if (isDpOrPxValue != null) {
                    return isDpOrPxValue.intValue();
                }
            }
        }
        int i18 = ((int) f16) * i16;
        attrValueCache.put(replaceAll, Integer.valueOf(i18));
        return i18;
    }

    public void parseMargin(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String[] split = str.split(",");
            if (split != null && split.length >= 4) {
                int[] iArr = new int[4];
                for (int i3 = 0; i3 < 4; i3++) {
                    iArr[i3] = parseInteger(split[i3].trim());
                }
                this.leftMargin = iArr[0];
                this.topMargin = iArr[1];
                this.rightMargin = iArr[2];
                this.bottomMargin = iArr[3];
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void parsePadding(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String[] split = str.split(",");
            if (split != null && split.length >= 4) {
                int[] iArr = new int[4];
                for (int i3 = 0; i3 < 4; i3++) {
                    iArr[i3] = parseInteger(split[i3].trim());
                }
                this.leftPadding = iArr[0];
                this.topPadding = iArr[1];
                this.rightPadding = iArr[2];
                this.bottomPadding = iArr[3];
            }
        } catch (Exception unused) {
        }
    }

    public void parseRadii4(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String[] split = str.split(",");
            if (split != null && split.length >= 4) {
                int[] iArr = new int[4];
                for (int i3 = 0; i3 < 4; i3++) {
                    iArr[i3] = parseInteger(split[i3].trim());
                }
                this.topLeftRadius = iArr[0];
                this.topRightRadius = iArr[1];
                this.bottomRightRadius = iArr[2];
                this.bottomLeftRadius = iArr[3];
            }
        } catch (Exception unused) {
        }
    }

    public void parseShadowSize(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String[] split = str.split(",");
            if (split == null) {
                return;
            }
            if (split.length == 1) {
                int parseInteger = parseInteger(str.trim());
                this.bottomShadowSize = parseInteger;
                this.topShadowSize = parseInteger;
                this.rightShadowSize = parseInteger;
                this.leftShadowSize = parseInteger;
                return;
            }
            if (split.length < 4) {
                return;
            }
            int[] iArr = new int[4];
            for (int i3 = 0; i3 < 4; i3++) {
                iArr[i3] = parseInteger(split[i3].trim());
            }
            this.leftShadowSize = iArr[0];
            this.topShadowSize = iArr[1];
            this.rightShadowSize = iArr[2];
            this.bottomShadowSize = iArr[3];
        } catch (Exception unused) {
        }
    }

    public void setBottomMargin(int i3) {
        this.bottomMargin = i3;
    }

    public void setBottomPadding(int i3) {
        this.bottomPadding = i3;
    }

    public void setLeftMargin(int i3) {
        this.leftMargin = i3;
    }

    public void setLeftPadding(int i3) {
        this.leftPadding = i3;
    }

    public void setMargin(int i3, int i16, int i17, int i18) {
        this.leftMargin = i3;
        this.topMargin = i16;
        this.rightMargin = i17;
        this.bottomMargin = i18;
    }

    public void setRightMargin(int i3) {
        this.rightMargin = i3;
    }

    public void setRightPadding(int i3) {
        this.rightPadding = i3;
    }

    public void setTopMargin(int i3) {
        this.topMargin = i3;
    }

    public void setTopPadding(int i3) {
        this.topPadding = i3;
    }

    public static LayoutAttrSet createFrom(JSONObject jSONObject, ValueIndicator valueIndicator) {
        LayoutAttrSet layoutAttrSet = new LayoutAttrSet();
        if (jSONObject == null) {
            return layoutAttrSet;
        }
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = keys.next() + "";
                Object obj = jSONObject.get(str);
                if (!(valueIndicator != null ? valueIndicator.onJsonField(str, jSONObject.get(str)) : false)) {
                    layoutAttrSet.addLayoutAttr(str, obj);
                }
            }
        } catch (Exception e16) {
            DittoLog.e(DittoLog.defaultTag, "parse file err:", e16);
        }
        return layoutAttrSet;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public synchronized LayoutAttrSet m109clone() {
        LayoutAttrSet layoutAttrSet;
        layoutAttrSet = new LayoutAttrSet();
        layoutAttrSet.mAttrs.putAll(this.mAttrs);
        layoutAttrSet.f100546id = this.f100546id;
        layoutAttrSet.width = this.width;
        layoutAttrSet.height = this.height;
        layoutAttrSet.orientation = this.orientation;
        layoutAttrSet.layout_gravity = this.layout_gravity;
        layoutAttrSet.leftMargin = this.leftMargin;
        layoutAttrSet.topMargin = this.topMargin;
        layoutAttrSet.rightMargin = this.rightMargin;
        layoutAttrSet.bottomMargin = this.bottomMargin;
        layoutAttrSet.leftPadding = this.leftPadding;
        layoutAttrSet.topPadding = this.topPadding;
        layoutAttrSet.rightPadding = this.rightPadding;
        layoutAttrSet.bottomPadding = this.bottomPadding;
        layoutAttrSet.bg_color = this.bg_color;
        layoutAttrSet.centerVertical = this.centerVertical;
        layoutAttrSet.centerHorizontal = this.centerHorizontal;
        layoutAttrSet.centerInParent = this.centerInParent;
        layoutAttrSet.alignParentLeft = this.alignParentLeft;
        layoutAttrSet.alignParentBottom = this.alignParentBottom;
        layoutAttrSet.alignParentRight = this.alignParentRight;
        layoutAttrSet.alignParentTop = this.alignParentTop;
        layoutAttrSet.alignWithParentIfMissing = this.alignWithParentIfMissing;
        layoutAttrSet.alignTop = this.alignTop;
        layoutAttrSet.alignBottom = this.alignBottom;
        layoutAttrSet.alignLeft = this.alignLeft;
        layoutAttrSet.alignRight = this.alignRight;
        layoutAttrSet.above = this.above;
        layoutAttrSet.below = this.below;
        layoutAttrSet.toLeftOf = this.toLeftOf;
        layoutAttrSet.toRightOf = this.toRightOf;
        layoutAttrSet.topLeftRadius = this.topLeftRadius;
        layoutAttrSet.bottomLeftRadius = this.bottomLeftRadius;
        layoutAttrSet.topRightRadius = this.topRightRadius;
        layoutAttrSet.bottomRightRadius = this.bottomRightRadius;
        layoutAttrSet.gradientDirection = this.gradientDirection;
        layoutAttrSet.gradientStartColor = this.gradientStartColor;
        layoutAttrSet.gradientEndColor = this.gradientEndColor;
        layoutAttrSet.pressedAlpha = this.pressedAlpha;
        return layoutAttrSet;
    }

    public boolean getAttr(String str, boolean z16) {
        try {
            return ((Boolean) this.mAttrs.get(str)).booleanValue();
        } catch (Exception unused) {
            return z16;
        }
    }

    public int getAttr(String str, int i3) {
        try {
            return ((Integer) this.mAttrs.get(str)).intValue();
        } catch (Exception unused) {
            return i3;
        }
    }

    public float getAttr(String str, float f16) {
        try {
            return ((Number) this.mAttrs.get(str)).floatValue();
        } catch (Exception unused) {
            return f16;
        }
    }

    public long getAttr(String str, long j3) {
        try {
            return ((Long) this.mAttrs.get(str)).longValue();
        } catch (Exception unused) {
            return j3;
        }
    }
}
