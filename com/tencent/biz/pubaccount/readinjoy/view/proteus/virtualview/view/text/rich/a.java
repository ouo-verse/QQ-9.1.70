package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.RichTextParser;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.htmlcss.CssStyle;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.htmlcss.CssStyleSet;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.ImgNode;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.LayoutNode;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.TextNode;
import com.tencent.pts.utils.PTSValueConvertUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static int f79867a;

    /* renamed from: b, reason: collision with root package name */
    public static int f79868b;

    /* renamed from: c, reason: collision with root package name */
    public static int f79869c;

    /* renamed from: d, reason: collision with root package name */
    public static int f79870d;

    /* renamed from: e, reason: collision with root package name */
    private static TruncateAttr f79871e;

    /* renamed from: f, reason: collision with root package name */
    private static final Drawable f79872f = new ColorDrawable(Color.parseColor("#E9E9E9"));

    /* compiled from: P */
    /* renamed from: com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0814a {
        public static void a(Node node) {
            int fontWeightFromStringToInteger;
            Map<String, CssStyle> cssStyleMap = node.cssStyleSet.getCssStyleMap();
            if (cssStyleMap != null && cssStyleMap.size() > 0) {
                for (Map.Entry<String, CssStyle> entry : cssStyleMap.entrySet()) {
                    String str = entry.getValue().styleName;
                    Object obj = entry.getValue().styleValue;
                    int i3 = 0;
                    if ("line-height".equalsIgnoreCase(str)) {
                        try {
                            i3 = Integer.parseInt(String.valueOf(obj));
                        } catch (Exception e16) {
                            Log.e("RichTextStyleParser", "[dealTextStyle] parse line-height error! msg=" + e16 + " value = " + obj);
                        }
                        int i16 = (int) (i3 * node.nodeRatio);
                        if (a.f79867a < i16) {
                            a.f79867a = i16;
                        }
                    } else if ("font-size".equalsIgnoreCase(str)) {
                        try {
                            i3 = Integer.parseInt(String.valueOf(obj));
                        } catch (Exception e17) {
                            Log.e("RichTextStyleParser", "[dealTextStyle] parse font-size error! msg=" + e17 + " value = " + obj);
                        }
                        int i17 = (int) (i3 * node.nodeRatio);
                        if (a.f79868b < i17) {
                            a.f79868b = i17;
                        }
                    } else if ("color".equalsIgnoreCase(str)) {
                        Log.d("RichTextStyleParser", "dealTextStyle colorInt = " + a.i((String) obj));
                    } else if ("font-weight".equalsIgnoreCase(str)) {
                        try {
                            if (TextUtils.isDigitsOnly(String.valueOf(obj))) {
                                fontWeightFromStringToInteger = Integer.parseInt((String) obj);
                            } else {
                                fontWeightFromStringToInteger = CssStyle.getFontWeightFromStringToInteger(str);
                            }
                            i3 = fontWeightFromStringToInteger;
                        } catch (Exception unused) {
                            Log.e("RichTextStyleParser", "[dealTextStyle] parse font weight error");
                        }
                        if (a.f79869c < i3) {
                            a.f79868b = i3;
                        }
                    } else if ("-webkit-line-clamp".equalsIgnoreCase(str)) {
                        int intValue = ((Integer) obj).intValue();
                        if (a.f79870d < intValue) {
                            a.f79870d = intValue;
                        }
                    } else if ("display".equalsIgnoreCase(str)) {
                        Log.d("RichTextStyleParser", "dealTextStyle DISPLAY_STYLE");
                    } else if (CssStyleSet.HREF_STYLE.equalsIgnoreCase(str)) {
                        String valueOf = String.valueOf(obj);
                        cssStyleMap.get("color");
                        Log.d("RichTextStyleParser", "dealTextStyle href = " + valueOf);
                    }
                }
                return;
            }
            Log.e("RichTextStyleParser", "RichTextCssStyle dealTextStyle node.cssStyleSet.getCssStyleMap null!");
        }

        public static CssStyleSet b(String str, String str2, Node node, JSONObject jSONObject) {
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
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class c {
        private static void a(Node node, Node node2, JSONObject jSONObject, CssStyleSet cssStyleSet, JSONObject jSONObject2) {
            if (node2 == null) {
                return;
            }
            node2.cssStyleSet = cssStyleSet;
            b(node, node2, jSONObject2);
            c(node2, jSONObject);
        }

        private static void b(Node node, Node node2, JSONObject jSONObject) {
            node2.nodeRatio = node.nodeRatio;
            if (jSONObject != null && jSONObject.has("ratio")) {
                node2.nodeRatio = jSONObject.optDouble("ratio", 1.0d);
            }
        }

        private static void c(Node node, JSONObject jSONObject) {
            TruncateAttr parseTruncate = TruncateAttr.parseTruncate(jSONObject.optJSONObject(Node.TRUNCATE_ATTR));
            node.truncateAttr = parseTruncate;
            if (parseTruncate != null) {
                parseTruncate.nodeRatio = node.nodeRatio;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static Node d(Node node, String str, String str2, CssStyleSet cssStyleSet, JSONObject jSONObject, JSONObject jSONObject2) {
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
            a(node, layoutNode, jSONObject, cssStyleSet, jSONObject2);
            return layoutNode;
        }

        public static void e(Context context, Node node, SpannableStringBuilder spannableStringBuilder) {
            TruncateAttr truncateAttr;
            int max = Math.max(spannableStringBuilder.length(), 0);
            int i3 = node.nodeType;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3 && (truncateAttr = node.truncateAttr) != null) {
                        TruncateAttr unused = a.f79871e = truncateAttr;
                    }
                } else {
                    spannableStringBuilder.append(',');
                    b.a(context, (ImgNode) node, max, spannableStringBuilder.length(), spannableStringBuilder);
                }
            } else {
                spannableStringBuilder.append((CharSequence) ((TextNode) node).text);
                C0814a.a(node);
            }
            List<Node> list = node.children;
            if (list != null) {
                Iterator<Node> it = list.iterator();
                while (it.hasNext()) {
                    e(context, it.next(), spannableStringBuilder);
                }
            }
        }

        public static Node f(JSONArray jSONArray) {
            Node g16;
            LayoutNode layoutNode = new LayoutNode();
            if (jSONArray == null) {
                return layoutNode;
            }
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                if (optJSONObject != null && (g16 = g(optJSONObject, layoutNode)) != null) {
                    layoutNode.children.add(g16);
                }
            }
            return layoutNode;
        }

        private static Node g(JSONObject jSONObject, Node node) {
            String str;
            String optString = jSONObject.optString("name");
            JSONObject optJSONObject = jSONObject.optJSONObject(Node.ATTRS_ATTR);
            String optString2 = jSONObject.optString("type");
            if (optJSONObject != null) {
                str = optJSONObject.optString("style");
            } else {
                str = null;
            }
            Node d16 = d(node, optString, optString2, C0814a.b(optString, str, node, optJSONObject), jSONObject, optJSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray(Node.CHILDREN_ATTR);
            if (optJSONArray != null && d16 != null) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    Node g16 = g(optJSONArray.optJSONObject(i3), d16);
                    if (g16 != null) {
                        d16.children.add(g16);
                    }
                }
            }
            return d16;
        }
    }

    public static int e() {
        return f79868b;
    }

    public static int f() {
        return f79870d;
    }

    public static int g() {
        return f79867a;
    }

    public static void h(Context context, Object obj, SpannableStringBuilder spannableStringBuilder) {
        c.e(context, c.f((JSONArray) obj), spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int i(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (str.startsWith("#")) {
            return Color.parseColor(str);
        }
        return PTSValueConvertUtil.getColor(str);
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class b {
        public static void a(Context context, ImgNode imgNode, int i3, int i16, SpannableStringBuilder spannableStringBuilder) {
            Rect rect = new Rect();
            Map<String, CssStyle> cssStyleMap = imgNode.cssStyleSet.getCssStyleMap();
            if (cssStyleMap != null && cssStyleMap.size() > 0) {
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
                Drawable drawableFromNet = DrawableUtil.getDrawableFromNet(context, imgNode.src, a.f79872f, a.f79872f, rect.right, rect.bottom, new C0815a());
                if (drawableFromNet == null && (drawableFromNet = DrawableUtil.getDrawable(context, imgNode.src, a.f79872f, a.f79872f)) == null && (drawableFromNet = com.tencent.pts.utils.c.b(imgNode.src)) == null) {
                    Log.d("RichTextStyleParser", "\u8bf7\u5904\u7406\u672a\u77e5\u56fe\u7247: " + imgNode.src);
                    return;
                }
                drawableFromNet.setBounds(rect);
                RichTextParser.CustomImageSpan customImageSpan = new RichTextParser.CustomImageSpan(drawableFromNet, 101);
                if (a.f79871e != null) {
                    a.f79871e.imageSpans.add(customImageSpan);
                }
                spannableStringBuilder.setSpan(customImageSpan, i3, i16, 33);
                return;
            }
            Log.e("RichTextStyleParser", "RichTextImage dealImageNode node.cssStyleSet.getCssStyleMap null!");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0815a implements DrawableUtil.DrawableCallBack {
            C0815a() {
            }

            @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil.DrawableCallBack
            public void onCallBack(boolean z16, Drawable drawable) {
            }
        }
    }
}
