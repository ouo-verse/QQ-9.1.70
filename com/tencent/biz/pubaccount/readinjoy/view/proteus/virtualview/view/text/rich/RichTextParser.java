package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.CustomMethodsRegister;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.RichTextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.htmlcss.CssStyle;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.htmlcss.CssStyleSet;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.ImgNode;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.LayoutNode;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.TextNode;
import com.tencent.pts.utils.PTSValueConvertUtil;
import com.tencent.pts.utils.c;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class RichTextParser {
    private static final Drawable GRAY_PLACEHOLDER = new ColorDrawable(Color.parseColor("#E9E9E9"));
    static final int LINK_TEXT_COLOR = -12541697;
    private static final String TAG = "RichTextParser";
    private static int maxFontSize = -1;
    private static int maxLineHeight = -1;
    private static int maxLines = 100;
    private static int spaceHeight;
    private static TruncateAttr truncateAttr;

    /* loaded from: classes4.dex */
    public static class CustomImageSpan extends ImageSpan {
        static final int ALIGN_VERTICAL_CENTER = 101;
        public boolean isSingleLine;
        private WeakReference<Drawable> mDrawableRef;

        /* JADX INFO: Access modifiers changed from: package-private */
        public CustomImageSpan(@NonNull Drawable drawable, int i3) {
            super(drawable, i3);
            this.isSingleLine = false;
        }

        private Drawable getCachedDrawable() {
            Drawable drawable;
            WeakReference<Drawable> weakReference = this.mDrawableRef;
            if (weakReference != null) {
                drawable = weakReference.get();
            } else {
                drawable = null;
            }
            if (drawable == null) {
                Drawable drawable2 = getDrawable();
                this.mDrawableRef = new WeakReference<>(drawable2);
                return drawable2;
            }
            return drawable;
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, @NonNull Paint paint) {
            Drawable cachedDrawable = getCachedDrawable();
            Rect bounds = cachedDrawable.getBounds();
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            int i26 = bounds.bottom;
            int i27 = fontMetricsInt.descent;
            int i28 = (((i18 - i26) + i27) - ((i27 - fontMetricsInt.ascent) >> 1)) + (i26 >> 1);
            canvas.save();
            canvas.translate(f16, i28);
            cachedDrawable.draw(canvas);
            canvas.restore();
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public int getSize(@NonNull Paint paint, CharSequence charSequence, int i3, int i16, @Nullable Paint.FontMetricsInt fontMetricsInt) {
            Rect bounds = getCachedDrawable().getBounds();
            if (fontMetricsInt != null) {
                int i17 = -bounds.bottom;
                fontMetricsInt.ascent = i17;
                fontMetricsInt.descent = 0;
                fontMetricsInt.top = i17;
                fontMetricsInt.bottom = 0;
            }
            return bounds.right;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class DrawableCallBack implements DrawableUtil.DrawableCallBack {
        private WeakReference<View> weakReference;

        DrawableCallBack(View view) {
            this.weakReference = new WeakReference<>(view);
        }

        @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil.DrawableCallBack
        public void onCallBack(boolean z16, Drawable drawable) {
            View view = this.weakReference.get();
            LogUtil.QLog.e(RichTextParser.TAG, 1, "onCallBack: isSuccess" + z16);
            if (view != null) {
                view.invalidate();
                LogUtil.QLog.e(RichTextParser.TAG, 1, "onCallBack: richNativeText != null");
            }
        }
    }

    private static void addExtraInfo(Node node, Node node2, JSONObject jSONObject, CssStyleSet cssStyleSet, JSONObject jSONObject2) {
        if (node2 == null) {
            return;
        }
        node2.cssStyleSet = cssStyleSet;
        addRatio(node, node2, jSONObject2);
        addTruncateInfo(node2, jSONObject);
    }

    private static void addRatio(Node node, Node node2, JSONObject jSONObject) {
        node2.nodeRatio = node.nodeRatio;
        if (jSONObject != null && jSONObject.has("ratio")) {
            node2.nodeRatio = jSONObject.optDouble("ratio", 1.0d);
        }
    }

    private static void addTruncateInfo(Node node, JSONObject jSONObject) {
        TruncateAttr parseTruncate = TruncateAttr.parseTruncate(jSONObject.optJSONObject(Node.TRUNCATE_ATTR));
        node.truncateAttr = parseTruncate;
        if (parseTruncate != null) {
            parseTruncate.nodeRatio = node.nodeRatio;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Node createNode(Node node, String str, String str2, CssStyleSet cssStyleSet, JSONObject jSONObject, JSONObject jSONObject2) {
        LayoutNode layoutNode = null;
        layoutNode = null;
        if ("text".equals(str2)) {
            String optString = jSONObject.optString("text");
            if (Node.valueIsLegal(optString)) {
                TextNode textNode = new TextNode();
                textNode.text = optString;
                layoutNode = textNode;
            }
        } else if ("img".equals(str)) {
            String optString2 = jSONObject2.optString("src");
            if (Node.valueIsLegal(optString2)) {
                ImgNode imgNode = new ImgNode();
                imgNode.src = optString2;
                layoutNode = imgNode;
            }
        } else {
            layoutNode = new LayoutNode();
        }
        addExtraInfo(node, layoutNode, jSONObject, cssStyleSet, jSONObject2);
        return layoutNode;
    }

    private static void dealImgNode(TextView textView, ImgNode imgNode, int i3, int i16, SpannableStringBuilder spannableStringBuilder) {
        Rect rect = new Rect();
        Map<String, CssStyle> cssStyleMap = imgNode.cssStyleSet.getCssStyleMap();
        if (cssStyleMap != null) {
            for (Map.Entry<String, CssStyle> entry : cssStyleMap.entrySet()) {
                String str = entry.getValue().styleName;
                Object obj = entry.getValue().styleValue;
                if ("width".equalsIgnoreCase(str)) {
                    rect.left = 0;
                    rect.right = ((Integer) obj).intValue();
                } else if ("height".equalsIgnoreCase(str)) {
                    rect.top = 0;
                    rect.bottom = ((Integer) obj).intValue();
                } else if ("display".equalsIgnoreCase(str) && "block".equals(obj) && spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) != '\n') {
                    spannableStringBuilder.append('\n');
                }
            }
        }
        Context context = textView.getContext();
        String str2 = imgNode.src;
        Drawable drawable = GRAY_PLACEHOLDER;
        Drawable drawableFromNet = DrawableUtil.getDrawableFromNet(context, str2, drawable, drawable, rect.right, rect.bottom, new DrawableCallBack(textView));
        if (drawableFromNet == null && (drawableFromNet = DrawableUtil.getDrawable(textView.getContext(), imgNode.src, drawable, drawable)) == null && (drawableFromNet = c.b(imgNode.src)) == null) {
            Log.d(TAG, "\u8bf7\u5904\u7406\u672a\u77e5\u56fe\u7247: " + imgNode.src);
            return;
        }
        drawableFromNet.setBounds(rect);
        CustomImageSpan customImageSpan = new CustomImageSpan(drawableFromNet, 101);
        TruncateAttr truncateAttr2 = truncateAttr;
        if (truncateAttr2 != null) {
            truncateAttr2.imageSpans.add(customImageSpan);
        }
        spannableStringBuilder.setSpan(customImageSpan, i3, i16, 33);
    }

    private static void dealNodeItem(TextView textView, Node node, SpannableStringBuilder spannableStringBuilder) {
        TruncateAttr truncateAttr2;
        int max = Math.max(spannableStringBuilder.length(), 0);
        int i3 = node.nodeType;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3 && (truncateAttr2 = node.truncateAttr) != null) {
                    truncateAttr = truncateAttr2;
                }
            } else {
                spannableStringBuilder.append(',');
                dealImgNode(textView, (ImgNode) node, max, spannableStringBuilder.length(), spannableStringBuilder);
            }
        } else {
            spannableStringBuilder.append(decodeEmotion(textView, ((TextNode) node).text));
            dealTextStyle(textView, node, max, spannableStringBuilder.length(), spannableStringBuilder);
        }
        List<Node> list = node.children;
        if (list != null) {
            Iterator<Node> it = list.iterator();
            while (it.hasNext()) {
                dealNodeItem(textView, it.next(), spannableStringBuilder);
            }
        }
    }

    private static void dealTextStyle(TextView textView, Node node, int i3, int i16, SpannableStringBuilder spannableStringBuilder) {
        Map<String, CssStyle> map;
        Map<String, CssStyle> cssStyleMap = node.cssStyleSet.getCssStyleMap();
        if (cssStyleMap != null) {
            for (Map.Entry<String, CssStyle> entry : cssStyleMap.entrySet()) {
                String str = entry.getValue().styleName;
                Object obj = entry.getValue().styleValue;
                int i17 = 0;
                if ("line-height".equalsIgnoreCase(str)) {
                    try {
                        i17 = Integer.parseInt(String.valueOf(obj));
                    } catch (Exception e16) {
                        Log.e(TAG, "[dealTextStyle] parse line-height error! msg=" + e16 + " value = " + obj);
                    }
                    int i18 = (int) (i17 * node.nodeRatio);
                    if (i18 > maxLineHeight) {
                        maxLineHeight = i18;
                    }
                } else if ("font-size".equalsIgnoreCase(str)) {
                    try {
                        i17 = Integer.parseInt(String.valueOf(obj));
                    } catch (Exception e17) {
                        Log.e(TAG, "[dealTextStyle] parse font-size error! msg=" + e17 + " value = " + obj);
                    }
                    int i19 = (int) (i17 * node.nodeRatio);
                    maxFontSize = Math.max(maxFontSize, i19);
                    RichTextUtils.addFontSizeSpan(spannableStringBuilder, i19, i3, i16);
                } else if ("color".equalsIgnoreCase(str)) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(parseColorString((String) obj)), i3, i16, 33);
                } else if ("font-weight".equalsIgnoreCase(str)) {
                    RichTextUtils.addFontWeightSpan(spannableStringBuilder, String.valueOf(obj), i3, i16);
                } else if ("-webkit-line-clamp".equalsIgnoreCase(str)) {
                    try {
                        maxLines = Integer.parseInt(String.valueOf(obj));
                    } catch (Exception e18) {
                        Log.e(TAG, "[dealTextStyle] parse -webkit-line-clamp error! msg=" + e18 + " value = " + obj);
                    }
                    textView.setMaxLines(maxLines);
                } else if (!"display".equalsIgnoreCase(str)) {
                    if (CssStyleSet.HREF_STYLE.equalsIgnoreCase(str)) {
                        String valueOf = String.valueOf(obj);
                        CssStyle cssStyle = cssStyleMap.get("color");
                        RichTextUtils.addClickSpan(textView, spannableStringBuilder, valueOf, getHyperLinkColor(cssStyle != null ? cssStyle.styleValue : Integer.valueOf(LINK_TEXT_COLOR), LINK_TEXT_COLOR), i3, i16);
                    } else if ("background-color".equalsIgnoreCase(str)) {
                        int parseColorString = parseColorString((String) obj);
                        CssStyle cssStyle2 = cssStyleMap.get("color");
                        int tagColor = getTagColor(cssStyle2 != null ? cssStyle2.styleValue : -16777216, -16777216);
                        CssStyle cssStyle3 = cssStyleMap.get("padding-top");
                        float tagFloat = getTagFloat(cssStyle3 != null ? cssStyle3.styleValue : 0, 0.0f);
                        CssStyle cssStyle4 = cssStyleMap.get("padding-bottom");
                        float tagFloat2 = getTagFloat(cssStyle4 != null ? cssStyle4.styleValue : 0, 0.0f);
                        CssStyle cssStyle5 = cssStyleMap.get("padding-left");
                        float tagFloat3 = getTagFloat(cssStyle5 != null ? cssStyle5.styleValue : 0, 0.0f);
                        CssStyle cssStyle6 = cssStyleMap.get("padding-right");
                        float tagFloat4 = getTagFloat(cssStyle6 != null ? cssStyle6.styleValue : 0, 0.0f);
                        CssStyle cssStyle7 = cssStyleMap.get("border-radius");
                        float tagFloat5 = getTagFloat(cssStyle7 != null ? cssStyle7.styleValue : 0, 0.0f);
                        CssStyle cssStyle8 = cssStyleMap.get("font-size");
                        map = cssStyleMap;
                        RichTextUtils.addTagSpan(spannableStringBuilder, i3, i16, parseColorString, tagColor, tagFloat3, tagFloat4, tagFloat, tagFloat2, tagFloat5, getTagFloat(cssStyle8 != null ? cssStyle8.styleValue : 0, 0.0f));
                        cssStyleMap = map;
                    }
                }
                map = cssStyleMap;
                cssStyleMap = map;
            }
        }
    }

    private static CharSequence decodeEmotion(TextView textView, CharSequence charSequence) {
        CustomMethodsRegister.CustomMethodInterface customMethodInterface = CustomMethodsRegister.customMethodInterface;
        if (customMethodInterface != null) {
            Object invoke = customMethodInterface.invoke(CustomMethodsRegister.CMD_DECODE_EMOTION, charSequence, new com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.a(textView));
            if (invoke instanceof CharSequence) {
                return (CharSequence) invoke;
            }
            return charSequence;
        }
        return charSequence;
    }

    private static void doLineSpace(TextView textView) {
        int i3;
        int i16 = maxLineHeight;
        if (i16 > 0 && i16 > (i3 = maxFontSize)) {
            int i17 = i16 - i3;
            spaceHeight = i17;
            textView.setLineSpacing(i17, 1.0f);
        }
    }

    private static CssStyleSet getCssStyleSet(String str, String str2, Node node, JSONObject jSONObject) {
        CssStyleSet cssStyleSet;
        CssStyleSet cssStyleSet2 = new CssStyleSet();
        if (node != null && (cssStyleSet = node.cssStyleSet) != null) {
            cssStyleSet2.addInheritStyle(cssStyleSet);
        }
        if (!"div".equalsIgnoreCase(str) && !"p".equalsIgnoreCase(str)) {
            if (CssStyleSet.STRONG_STYLE.equalsIgnoreCase(str)) {
                cssStyleSet2.addCssStyle(CssStyle.createStyle("font-weight", "bold"));
            } else if ("a".equalsIgnoreCase(str) && jSONObject != null) {
                cssStyleSet2.addCssStyle(CssStyle.createStyle(CssStyleSet.HREF_STYLE, jSONObject.optString(CssStyleSet.HREF_STYLE)));
            } else {
                cssStyleSet2.addCssStyle(CssStyle.getDisplay(false));
            }
        } else {
            cssStyleSet2.addCssStyle(CssStyle.getDisplay(true));
        }
        if (str2 != null) {
            for (String str3 : str2.split("[;]")) {
                if (str3 != null) {
                    String[] split = str3.split(":");
                    if (split.length == 2) {
                        cssStyleSet2.addCssStyle(CssStyle.createStyle(split[0].trim(), split[1].trim()));
                    }
                }
            }
        }
        return cssStyleSet2;
    }

    private static int getHyperLinkColor(Object obj, int i3) {
        if (obj == null) {
            return i3;
        }
        try {
            return parseColorString(String.valueOf(obj));
        } catch (Exception e16) {
            LogUtils.e(TAG, "getHyperLinkColor error! msg=" + e16);
            return i3;
        }
    }

    private static int getTagColor(Object obj, int i3) {
        if (obj == null) {
            return i3;
        }
        try {
            return parseColorString(String.valueOf(obj));
        } catch (Exception e16) {
            Log.e(TAG, "getTagFgColorColor error! msg=" + e16);
            return i3;
        }
    }

    private static float getTagFloat(Object obj, float f16) {
        if (obj == null) {
            return f16;
        }
        try {
            return Float.parseFloat(String.valueOf(obj));
        } catch (Exception e16) {
            Log.e(TAG, "getTagFloat error! msg=" + e16);
            return f16;
        }
    }

    public static TruncateAttr getTruncate() {
        TruncateAttr truncateAttr2 = truncateAttr;
        if (truncateAttr2 != null) {
            truncateAttr2.maxLines = maxLines;
        }
        return truncateAttr2;
    }

    private static void init() {
        maxLineHeight = -1;
        spaceHeight = 0;
        maxFontSize = -1;
        maxLines = 100;
        truncateAttr = null;
    }

    public static void parse(TextView textView, SpannableStringBuilder spannableStringBuilder, Object obj) {
        if (spannableStringBuilder == null || obj == null) {
            return;
        }
        init();
        dealNodeItem(textView, parse((JSONArray) obj), spannableStringBuilder);
        doLineSpace(textView);
    }

    private static int parseColorString(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (str.startsWith("#")) {
            return Color.parseColor(str);
        }
        return PTSValueConvertUtil.getColor(str);
    }

    private static Node parseNodeItem(JSONObject jSONObject, Node node) {
        String str;
        String optString = jSONObject.optString("name");
        JSONObject optJSONObject = jSONObject.optJSONObject(Node.ATTRS_ATTR);
        String optString2 = jSONObject.optString("type");
        if (optJSONObject != null) {
            str = optJSONObject.optString("style");
        } else {
            str = null;
        }
        Node createNode = createNode(node, optString, optString2, getCssStyleSet(optString, str, node, optJSONObject), jSONObject, optJSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray(Node.CHILDREN_ATTR);
        if (optJSONArray != null && createNode != null) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                Node parseNodeItem = parseNodeItem(optJSONArray.optJSONObject(i3), createNode);
                if (parseNodeItem != null) {
                    createNode.children.add(parseNodeItem);
                }
            }
        }
        return createNode;
    }

    private static Node parse(JSONArray jSONArray) {
        Node parseNodeItem;
        LayoutNode layoutNode = new LayoutNode();
        if (jSONArray == null) {
            return layoutNode;
        }
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i3);
            if (optJSONObject != null && (parseNodeItem = parseNodeItem(optJSONObject, layoutNode)) != null) {
                layoutNode.children.add(parseNodeItem);
            }
        }
        return layoutNode;
    }
}
