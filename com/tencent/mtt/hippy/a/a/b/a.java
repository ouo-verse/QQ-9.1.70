package com.tencent.mtt.hippy.a.a.b;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.hippy.qq.view.video.constants.HVideoConstants;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.dom.node.DomNodeRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.dom.node.TextNode;
import com.tencent.mtt.hippy.uimanager.RenderNode;
import com.tencent.mtt.hippy.utils.LogUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, String[]> f336921a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private Set<String> f336922b = new HashSet();

    /* renamed from: c, reason: collision with root package name */
    private Set<String> f336923c = new HashSet();

    public a() {
        a();
    }

    public static String a(String str) {
        StringBuilder sb5 = new StringBuilder();
        boolean z16 = true;
        for (String str2 : str.split("-")) {
            if (z16) {
                sb5.append(str2);
                z16 = false;
            } else {
                sb5.append(str2.replaceFirst(str2.substring(0, 1), str2.substring(0, 1).toUpperCase()));
            }
        }
        return sb5.toString();
    }

    private Object b(String str, String str2) {
        return this.f336922b.contains(str) ? Double.valueOf(d(str2)) : this.f336921a.containsKey(str) ? a(this.f336921a.get(str), str2) : this.f336923c.contains(str) ? Long.valueOf(e(str2)) : str2;
    }

    private static double d(String str) {
        try {
            return Double.parseDouble(str);
        } catch (Exception e16) {
            LogUtils.e("CSSModel", "getDoubleValue, Exception: ", e16);
            return 0.0d;
        }
    }

    private static long e(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e16) {
            LogUtils.e("CSSModel", "getLongValue, Exception: ", e16);
            return 0L;
        }
    }

    public JSONObject c(HippyEngineContext hippyEngineContext, int i3) {
        HippyMap hippyMap;
        JSONObject jSONObject = new JSONObject();
        try {
            DomNodeRecord domNodeRecord = hippyEngineContext.getDomManager().c(i3).getDomNodeRecord();
            if ((domNodeRecord instanceof com.tencent.mtt.hippy.dom.node.a) && (hippyMap = ((com.tencent.mtt.hippy.dom.node.a) domNodeRecord).f337383f) != null) {
                jSONObject.put("computedStyle", a(hippyEngineContext, i3, hippyMap));
            }
        } catch (Exception e16) {
            LogUtils.e("CSSModel", "getComputedStyle, Exception: ", e16);
        }
        return jSONObject;
    }

    private static String a(String[] strArr, String str) {
        if (strArr == null) {
            return null;
        }
        for (String str2 : strArr) {
            if (str2.equals(str)) {
                return str;
            }
        }
        return strArr[0];
    }

    public static String b(String str) {
        StringBuilder sb5 = new StringBuilder();
        boolean z16 = true;
        for (String str2 : str.split("(?=(?!^)[A-Z])")) {
            if (z16) {
                sb5.append(str2);
                z16 = false;
            } else {
                sb5.append(str2.replaceFirst(str2.substring(0, 1), "-" + str2.substring(0, 1).toLowerCase()));
            }
        }
        return sb5.toString();
    }

    private boolean c(String str) {
        return this.f336922b.contains(str) || this.f336921a.containsKey(str) || this.f336923c.contains(str);
    }

    private JSONArray a(HippyEngineContext hippyEngineContext, int i3, HippyMap hippyMap) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        if (hippyMap != null) {
            for (Map.Entry<String, Object> entry : hippyMap.entrySet()) {
                String key = entry.getKey();
                if (c(key) && !"width".equals(key) && !"height".equals(key)) {
                    jSONArray.mo162put(a(b(key), entry.getValue().toString()));
                }
            }
            for (Map.Entry<String, String> entry2 : b().entrySet()) {
                if (!hippyMap.containsKey(entry2.getKey())) {
                    jSONArray.mo162put(a(b(entry2.getKey()), entry2.getValue()));
                }
            }
            RenderNode renderNode = hippyEngineContext.getRenderManager().getRenderNode(i3);
            if (renderNode != null) {
                jSONArray.mo162put(a(b("width"), String.valueOf(renderNode.getWidth())));
                jSONArray.mo162put(a(b("height"), String.valueOf(renderNode.getHeight())));
            }
        }
        return jSONArray;
    }

    private Map<String, String> b() {
        HashMap hashMap = new HashMap();
        hashMap.put(NodeProps.PADDING_TOP, "0");
        hashMap.put(NodeProps.PADDING_RIGHT, "0");
        hashMap.put(NodeProps.PADDING_BOTTOM, "0");
        hashMap.put(NodeProps.PADDING_LEFT, "0");
        hashMap.put(NodeProps.BORDER_TOP_WIDTH, "0");
        hashMap.put(NodeProps.BORDER_RIGHT_WIDTH, "0");
        hashMap.put(NodeProps.BORDER_BOTTOM_WIDTH, "0");
        hashMap.put(NodeProps.BORDER_LEFT_WIDTH, "0");
        hashMap.put(NodeProps.MARGIN_TOP, "0");
        hashMap.put(NodeProps.MARGIN_RIGHT, "0");
        hashMap.put(NodeProps.MARGIN_BOTTOM, "0");
        hashMap.put(NodeProps.MARGIN_LEFT, "0");
        hashMap.put("display", "block");
        hashMap.put("position", ParseCommon.LAYOUT_PARAMS_RELATIVE);
        return hashMap;
    }

    private JSONObject a(int i3, int i16, int i17, int i18) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("startLine", i3);
        jSONObject.put("startColumn", i16);
        jSONObject.put("endLine", i17);
        jSONObject.put("endColumn", i18);
        return jSONObject;
    }

    public JSONObject b(HippyEngineContext hippyEngineContext, int i3) {
        return new JSONObject();
    }

    public JSONObject a(HippyEngineContext hippyEngineContext, int i3) {
        HippyMap hippyMap;
        JSONObject jSONObject = new JSONObject();
        try {
            DomNodeRecord domNodeRecord = hippyEngineContext.getDomManager().c(i3).getDomNodeRecord();
            if ((domNodeRecord instanceof com.tencent.mtt.hippy.dom.node.a) && (hippyMap = ((com.tencent.mtt.hippy.dom.node.a) domNodeRecord).f337383f) != null) {
                jSONObject.put("inlineStyle", a(hippyMap, i3));
            }
        } catch (Exception e16) {
            LogUtils.e("CSSModel", "getMatchedStyles, Exception: ", e16);
        }
        return jSONObject;
    }

    public JSONObject a(HippyEngineContext hippyEngineContext, JSONArray jSONArray, com.tencent.mtt.hippy.a.a.a.a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray2 = new JSONArray();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject a16 = a(hippyEngineContext, (JSONObject) jSONArray.opt(i3));
                if (a16 != null) {
                    jSONArray2.mo162put(a16);
                }
            }
            if (jSONArray2.length() > 0) {
                aVar.a(false);
                hippyEngineContext.getDomManager().g();
                aVar.a(true);
            }
            jSONObject.put("styles", jSONArray2);
        } catch (Exception e16) {
            LogUtils.e("CSSModel", "setStyleTexts, Exception: ", e16);
        }
        return jSONObject;
    }

    private JSONObject a(HippyEngineContext hippyEngineContext, JSONObject jSONObject) {
        String str;
        int optInt = jSONObject.optInt("styleSheetId");
        com.tencent.mtt.hippy.dom.node.b c16 = hippyEngineContext.getDomManager().c(optInt);
        if (c16 == null || c16.getDomNodeRecord() == null) {
            str = "setStyleText node is null";
        } else {
            HippyRootView hippyEngineContext2 = hippyEngineContext.getInstance(c16.getDomNodeRecord().rootId);
            if (hippyEngineContext2 != null) {
                HippyMap hippyMap = c16.getTotalProps() == null ? new HippyMap() : c16.getTotalProps().copy();
                HippyMap hippyMap2 = hippyMap.get("style") != null ? (HippyMap) hippyMap.get("style") : new HippyMap();
                for (String str2 : jSONObject.optString("text").split(";")) {
                    String[] split = str2.trim().split(":");
                    if (split.length == 2) {
                        String a16 = a(split[0].trim());
                        hippyMap2.pushObject(a16, b(a16, split[1].trim()));
                    }
                }
                hippyMap.pushMap("style", hippyMap2);
                hippyEngineContext.getDomManager().a(optInt, hippyMap, hippyEngineContext2);
                return a(hippyMap2, optInt);
            }
            str = "setStyleText hippyRootView is null";
        }
        LogUtils.e("CSSModel", str);
        return null;
    }

    private JSONObject a(HippyMap hippyMap, int i3) {
        JSONObject jSONObject = new JSONObject();
        if (hippyMap == null) {
            return jSONObject;
        }
        StringBuilder sb5 = new StringBuilder();
        try {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, Object> entry : hippyMap.entrySet()) {
                String key = entry.getKey();
                if (c(key)) {
                    String b16 = b(key);
                    String obj = entry.getValue().toString();
                    String str = "cssName:" + obj;
                    jSONArray.mo162put(a(b16, obj, a(0, sb5.length(), 0, sb5.length() + str.length() + 1)));
                    sb5.append(str);
                    sb5.append(";");
                }
            }
            jSONObject.put("styleSheetId", i3);
            jSONObject.put("cssProperties", jSONArray);
            jSONObject.put("shorthandEntries", new JSONArray());
            jSONObject.put("cssText", sb5);
            jSONObject.put(DownloaderConstant.KEY_RANGE, a(0, 0, 0, sb5.length()));
        } catch (Exception e16) {
            LogUtils.e("CSSModel", "getCSSStyle, Exception: ", e16);
        }
        return jSONObject;
    }

    private JSONObject a(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", str);
        jSONObject.put("value", str2);
        return jSONObject;
    }

    private JSONObject a(String str, String str2, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("name", str);
        jSONObject2.put("value", str2);
        jSONObject2.put("important", false);
        jSONObject2.put("implicit", false);
        jSONObject2.put("text", (Object) null);
        jSONObject2.put("parsedOk", true);
        jSONObject2.put("disabled", false);
        jSONObject2.put(DownloaderConstant.KEY_RANGE, jSONObject);
        return jSONObject2;
    }

    private void a() {
        this.f336922b.add(NodeProps.FLEX);
        this.f336922b.add(NodeProps.FLEX_GROW);
        this.f336922b.add(NodeProps.FLEX_SHRINK);
        this.f336922b.add(NodeProps.FLEX_BASIS);
        this.f336922b.add("width");
        this.f336922b.add("height");
        this.f336922b.add(NodeProps.MAX_WIDTH);
        this.f336922b.add(NodeProps.MIN_WIDTH);
        this.f336922b.add(NodeProps.MAX_HEIGHT);
        this.f336922b.add(NodeProps.MIN_HEIGHT);
        this.f336922b.add(NodeProps.MARGIN_TOP);
        this.f336922b.add(NodeProps.MARGIN_RIGHT);
        this.f336922b.add(NodeProps.MARGIN_BOTTOM);
        this.f336922b.add(NodeProps.MARGIN_LEFT);
        this.f336922b.add(NodeProps.PADDING_TOP);
        this.f336922b.add(NodeProps.PADDING_RIGHT);
        this.f336922b.add(NodeProps.PADDING_BOTTOM);
        this.f336922b.add(NodeProps.PADDING_LEFT);
        this.f336922b.add(NodeProps.BORDER_WIDTH);
        this.f336922b.add(NodeProps.BORDER_TOP_WIDTH);
        this.f336922b.add(NodeProps.BORDER_RIGHT_WIDTH);
        this.f336922b.add(NodeProps.BORDER_BOTTOM_WIDTH);
        this.f336922b.add(NodeProps.BORDER_LEFT_WIDTH);
        this.f336922b.add(NodeProps.BORDER_RADIUS);
        this.f336922b.add(NodeProps.BORDER_TOP_LEFT_RADIUS);
        this.f336922b.add(NodeProps.BORDER_TOP_RIGHT_RADIUS);
        this.f336922b.add(NodeProps.BORDER_BOTTOM_LEFT_RADIUS);
        this.f336922b.add(NodeProps.BORDER_BOTTOM_RIGHT_RADIUS);
        this.f336922b.add("top");
        this.f336922b.add("right");
        this.f336922b.add("bottom");
        this.f336922b.add("left");
        this.f336922b.add(NodeProps.Z_INDEX);
        this.f336922b.add("opacity");
        this.f336922b.add("fontSize");
        this.f336922b.add(NodeProps.LINE_HEIGHT);
        this.f336921a.put("display", new String[]{NodeProps.FLEX, "none"});
        this.f336921a.put(NodeProps.FLEX_DIRECTION, new String[]{"column", "column-reverse", "row", "row-reverse"});
        this.f336921a.put(NodeProps.FLEX_WRAP, new String[]{"nowrap", "wrap", "wrap-reverse"});
        this.f336921a.put(NodeProps.ALIGN_ITEMS, new String[]{"flex-start", "center", "flex-end", "stretch", "center", "baseline"});
        this.f336921a.put(NodeProps.ALIGN_SELF, new String[]{"auto", "flex-start", "center", "flex-end", "stretch", "center", "baseline"});
        this.f336921a.put(NodeProps.JUSTIFY_CONTENT, new String[]{"flex-start", "center", "flex-end", "space-between", "space-around", "space-evenly"});
        this.f336921a.put("overflow", new String[]{"hidden", NodeProps.VISIBLE, "scroll"});
        this.f336921a.put("position", new String[]{ParseCommon.LAYOUT_PARAMS_RELATIVE, "absolute"});
        this.f336921a.put(NodeProps.BACKGROUND_SIZE, new String[]{"auto", HVideoConstants.ResizeType.RESIZE_CONTAIN, "cover", "fit"});
        this.f336921a.put(NodeProps.BACKGROUND_POSITION_X, new String[]{"left", "center", "right"});
        this.f336921a.put(NodeProps.BACKGROUND_POSITION_Y, new String[]{"top", "center", "bottom"});
        this.f336921a.put("fontStyle", new String[]{"normal", "italic"});
        this.f336921a.put("fontWeight", new String[]{"normal", "bold", "100", "200", IndividuationPlugin.Business_Font, IndividuationPlugin.Business_Pendant, "500", IndividuationPlugin.Business_Theme, IndividuationPlugin.Business_Profilecard, IndividuationPlugin.Business_Suit, "900"});
        this.f336921a.put("textAlign", new String[]{"left", "center", "right"});
        this.f336921a.put(NodeProps.RESIZE_MODE, new String[]{"cover", HVideoConstants.ResizeType.RESIZE_CONTAIN, "stretch", "repeat", "center"});
        this.f336923c.add("backgroundColor");
        this.f336923c.add(NodeProps.BORDER_COLOR);
        this.f336923c.add(NodeProps.BORDER_LEFT_COLOR);
        this.f336923c.add(NodeProps.BORDER_TOP_COLOR);
        this.f336923c.add(NodeProps.BORDER_RIGHT_COLOR);
        this.f336923c.add(NodeProps.BORDER_BOTTOM_COLOR);
        this.f336923c.add(NodeProps.SHADOW_COLOR);
        this.f336923c.add("color");
        this.f336923c.add(TextNode.PROP_SHADOW_COLOR);
        this.f336923c.add("textDecorationColor");
    }
}
