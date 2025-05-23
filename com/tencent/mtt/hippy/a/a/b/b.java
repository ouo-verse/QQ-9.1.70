package com.tencent.mtt.hippy.a.a.b;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.dom.node.DomNodeRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.uimanager.ControllerManager;
import com.tencent.mtt.hippy.uimanager.RenderManager;
import com.tencent.mtt.hippy.uimanager.RenderNode;
import com.tencent.mtt.hippy.utils.LogUtils;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mtt.hippy.dom.node.b f336924a;

    public static RenderNode a(HippyEngineContext hippyEngineContext, int i3, int i16) {
        RenderNode a16;
        if (hippyEngineContext == null) {
            return null;
        }
        com.tencent.mtt.hippy.dom.b domManager = hippyEngineContext.getDomManager();
        RenderManager renderManager = hippyEngineContext.getRenderManager();
        if (domManager != null && renderManager != null) {
            RenderNode renderNode = renderManager.getRenderNode(domManager.f());
            if (renderNode.getChildCount() > 0 && (a16 = a(renderNode, i3, i16)) != null) {
                return b(hippyEngineContext, i3, i16, a16);
            }
        }
        return null;
    }

    private static HippyRootView b(HippyEngineContext hippyEngineContext) {
        return hippyEngineContext.getInstance(hippyEngineContext.getDomManager().f());
    }

    private JSONArray c(JSONArray jSONArray, HippyMap hippyMap) {
        int i3;
        int i16;
        int i17;
        int i18;
        if (hippyMap != null) {
            i16 = hippyMap.containsKey(NodeProps.MARGIN_TOP) ? ((Integer) hippyMap.get(NodeProps.MARGIN_TOP)).intValue() : 0;
            i17 = hippyMap.containsKey(NodeProps.MARGIN_RIGHT) ? ((Integer) hippyMap.get(NodeProps.MARGIN_RIGHT)).intValue() : 0;
            i18 = hippyMap.containsKey(NodeProps.MARGIN_BOTTOM) ? ((Integer) hippyMap.get(NodeProps.MARGIN_BOTTOM)).intValue() : 0;
            i3 = hippyMap.containsKey(NodeProps.MARGIN_LEFT) ? ((Integer) hippyMap.get(NodeProps.MARGIN_LEFT)).intValue() : 0;
        } else {
            i3 = 0;
            i16 = 0;
            i17 = 0;
            i18 = 0;
        }
        JSONArray jSONArray2 = new JSONArray();
        try {
            jSONArray2.put(jSONArray.getInt(0) - i3);
            jSONArray2.put(jSONArray.getInt(1) - i16);
            jSONArray2.put(jSONArray.getInt(2) + i17);
            jSONArray2.put(jSONArray.getInt(3) - i16);
            jSONArray2.put(jSONArray.getInt(4) + i17);
            jSONArray2.put(jSONArray.getInt(5) + i18);
            jSONArray2.put(jSONArray.getInt(6) - i3);
            jSONArray2.put(jSONArray.getInt(7) + i18);
        } catch (Exception e16) {
            LogUtils.e("DomModel", "getPadding, exception:", e16);
        }
        return jSONArray2;
    }

    public JSONObject d(HippyEngineContext hippyEngineContext, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (hippyEngineContext != null && jSONObject != null) {
            com.tencent.mtt.hippy.dom.b domManager = hippyEngineContext.getDomManager();
            if (domManager == null) {
                return jSONObject2;
            }
            com.tencent.mtt.hippy.dom.node.b c16 = domManager.c(domManager.f());
            if (c16 == null) {
                return jSONObject2;
            }
            try {
                String[] split = jSONObject.optString("path").split(",");
                for (int i3 = 0; i3 < split.length; i3 += 2) {
                    int parseInt = Integer.parseInt(split[i3]);
                    String str = split[i3 + 1];
                    if (parseInt >= c16.getChildCount()) {
                        return jSONObject2;
                    }
                    com.tencent.mtt.hippy.dom.node.b childAt = c16.getChildAt(parseInt);
                    if (childAt != null && childAt.getDomNodeRecord() != null && str.equals(childAt.getDomNodeRecord().tagName)) {
                        c16 = childAt;
                    }
                }
                jSONObject2.put("nodeId", c16.getId());
            } catch (JSONException e16) {
                LogUtils.e("DomModel", "getNodeForPath, exception:", e16);
            }
        }
        return jSONObject2;
    }

    public JSONObject e(HippyEngineContext hippyEngineContext, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (hippyEngineContext != null && jSONObject != null) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("backendNodeIds");
                if (optJSONArray == null) {
                    return jSONObject2;
                }
                JSONArray jSONArray = new JSONArray();
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    jSONArray.put(optJSONArray.optInt(i3));
                }
                jSONObject2.put("nodeIds", jSONArray);
            } catch (JSONException e16) {
                LogUtils.e("DomModel", "getNodeByBackendIds, exception:", e16);
            }
        }
        return jSONObject2;
    }

    private static RenderNode a(RenderNode renderNode, int i3, int i16) {
        if (renderNode.getWidth() > 0 && renderNode.getHeight() > 0) {
            return renderNode;
        }
        RenderNode renderNode2 = null;
        for (int i17 = 0; i17 < renderNode.getChildCount(); i17++) {
            RenderNode childAt = renderNode.getChildAt(i17);
            if (renderNode2 == null || (childAt.getX() <= i3 && childAt.getY() <= i16 && renderNode2.getHeight() <= childAt.getHeight() && renderNode2.getWidth() <= childAt.getWidth())) {
                renderNode2 = renderNode.getChildAt(i17);
            }
        }
        return renderNode2;
    }

    private static RenderNode b(HippyEngineContext hippyEngineContext, int i3, int i16, RenderNode renderNode) {
        RenderNode renderNode2 = null;
        if (renderNode == null || !a(hippyEngineContext, i3, i16, renderNode)) {
            return null;
        }
        int childCount = renderNode.getChildCount();
        for (int i17 = 0; i17 < childCount; i17++) {
            RenderNode childAt = renderNode.getChildAt(i17);
            if (a(hippyEngineContext, i3, i16, childAt)) {
                renderNode2 = a(renderNode2, b(hippyEngineContext, i3, i16, childAt));
            }
        }
        return renderNode2 != null ? renderNode2 : renderNode;
    }

    public JSONObject c(HippyEngineContext hippyEngineContext, JSONObject jSONObject) {
        com.tencent.mtt.hippy.dom.node.b c16;
        if (hippyEngineContext == null || jSONObject == null) {
            return new JSONObject();
        }
        try {
            int optInt = jSONObject.optInt("nodeId", 0);
            com.tencent.mtt.hippy.dom.b domManager = hippyEngineContext.getDomManager();
            if (domManager != null && (c16 = domManager.c(optInt)) != null) {
                this.f336924a = c16;
            }
        } catch (Exception e16) {
            LogUtils.e("DomModel", "setInspectMode, exception:", e16);
        }
        return new JSONObject();
    }

    private static RenderNode a(RenderNode renderNode, RenderNode renderNode2) {
        return renderNode == null ? renderNode2 : (renderNode2 != null && renderNode.getWidth() * renderNode.getHeight() > renderNode2.getWidth() * renderNode2.getHeight()) ? renderNode2 : renderNode;
    }

    private static String b(HippyMap hippyMap) {
        StringBuilder sb5 = new StringBuilder();
        for (Map.Entry<String, Object> entry : hippyMap.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Number) {
                value = String.format("%.1f", Double.valueOf(((Number) value).doubleValue()));
            }
            sb5.append(key);
            sb5.append(":");
            sb5.append(value);
            sb5.append(";");
        }
        sb5.deleteCharAt(sb5.length() - 1);
        return sb5.toString();
    }

    private JSONArray a(int i3, int i16, int i17, int i18) {
        JSONArray jSONArray = new JSONArray();
        try {
            jSONArray.put(i3);
            jSONArray.put(i16);
            int i19 = i17 + i3;
            jSONArray.put(i19);
            jSONArray.put(i16);
            jSONArray.put(i19);
            int i26 = i16 + i18;
            jSONArray.put(i26);
            jSONArray.put(i3);
            jSONArray.put(i26);
        } catch (Exception e16) {
            LogUtils.e("DomModel", "getBorder, exception:", e16);
        }
        return jSONArray;
    }

    private JSONArray b(JSONArray jSONArray, HippyMap hippyMap) {
        int i3;
        int i16;
        int i17;
        int i18;
        if (hippyMap != null) {
            i16 = hippyMap.containsKey(NodeProps.PADDING_TOP) ? ((Integer) hippyMap.get(NodeProps.PADDING_TOP)).intValue() : 0;
            i17 = hippyMap.containsKey(NodeProps.PADDING_RIGHT) ? ((Integer) hippyMap.get(NodeProps.PADDING_RIGHT)).intValue() : 0;
            i18 = hippyMap.containsKey(NodeProps.PADDING_BOTTOM) ? ((Integer) hippyMap.get(NodeProps.PADDING_BOTTOM)).intValue() : 0;
            i3 = hippyMap.containsKey(NodeProps.PADDING_LEFT) ? ((Integer) hippyMap.get(NodeProps.PADDING_LEFT)).intValue() : 0;
        } else {
            i3 = 0;
            i16 = 0;
            i17 = 0;
            i18 = 0;
        }
        JSONArray jSONArray2 = new JSONArray();
        try {
            jSONArray2.put(jSONArray.getInt(0) + i3);
            jSONArray2.put(jSONArray.getInt(1) + i16);
            jSONArray2.put(jSONArray.getInt(2) - i17);
            jSONArray2.put(jSONArray.getInt(3) + i16);
            jSONArray2.put(jSONArray.getInt(4) - i17);
            jSONArray2.put(jSONArray.getInt(5) - i18);
            jSONArray2.put(jSONArray.getInt(6) + i3);
            jSONArray2.put(jSONArray.getInt(7) - i18);
        } catch (Exception e16) {
            LogUtils.e("DomModel", "getPadding, exception:", e16);
        }
        return jSONArray2;
    }

    private static JSONArray a(HippyMap hippyMap) {
        JSONArray jSONArray = new JSONArray();
        try {
            for (Map.Entry<String, Object> entry : hippyMap.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if ("style".equals(key) && (value instanceof HippyMap)) {
                    value = b((HippyMap) value);
                }
                if (value != null && (!(value instanceof String) || !TextUtils.isEmpty((String) value))) {
                    jSONArray.mo162put(key);
                    jSONArray.mo162put(value.toString());
                }
            }
        } catch (Exception e16) {
            LogUtils.e("DomModel", "getAttributeList, exception:", e16);
        }
        return jSONArray;
    }

    public JSONObject b(HippyEngineContext hippyEngineContext, JSONObject jSONObject) {
        if (hippyEngineContext == null || jSONObject == null) {
            return new JSONObject();
        }
        RenderNode a16 = a(hippyEngineContext, jSONObject.optInt(HippyTKDListViewAdapter.X, 0), jSONObject.optInt("y", 0));
        JSONObject jSONObject2 = new JSONObject();
        if (a16 != null) {
            try {
                jSONObject2.put("backendId", a16.getId());
                jSONObject2.put("frameId", "main_frame");
                jSONObject2.put("nodeId", a16.getId());
            } catch (Exception e16) {
                LogUtils.e("DomModel", "getNodeForLocation, exception:", e16);
            }
        }
        return jSONObject2;
    }

    private JSONArray a(JSONArray jSONArray, HippyMap hippyMap) {
        int i3;
        int i16;
        int i17;
        int i18;
        if (hippyMap != null) {
            i16 = hippyMap.containsKey(NodeProps.BORDER_TOP_WIDTH) ? ((Integer) hippyMap.get(NodeProps.BORDER_TOP_WIDTH)).intValue() : 0;
            i17 = hippyMap.containsKey(NodeProps.BORDER_RIGHT_WIDTH) ? ((Integer) hippyMap.get(NodeProps.BORDER_RIGHT_WIDTH)).intValue() : 0;
            i18 = hippyMap.containsKey(NodeProps.BORDER_BOTTOM_WIDTH) ? ((Integer) hippyMap.get(NodeProps.BORDER_BOTTOM_WIDTH)).intValue() : 0;
            i3 = hippyMap.containsKey(NodeProps.BORDER_LEFT_WIDTH) ? ((Integer) hippyMap.get(NodeProps.BORDER_LEFT_WIDTH)).intValue() : 0;
        } else {
            i3 = 0;
            i16 = 0;
            i17 = 0;
            i18 = 0;
        }
        JSONArray jSONArray2 = new JSONArray();
        try {
            jSONArray2.put(jSONArray.getInt(0) + i3);
            jSONArray2.put(jSONArray.getInt(1) + i16);
            jSONArray2.put(jSONArray.getInt(2) - i17);
            jSONArray2.put(jSONArray.getInt(3) + i16);
            jSONArray2.put(jSONArray.getInt(4) - i17);
            jSONArray2.put(jSONArray.getInt(5) - i18);
            jSONArray2.put(jSONArray.getInt(6) + i3);
            jSONArray2.put(jSONArray.getInt(7) - i18);
        } catch (Exception e16) {
            LogUtils.e("DomModel", "getPadding, exception:", e16);
        }
        return jSONArray2;
    }

    public JSONObject a(HippyEngineContext hippyEngineContext) {
        JSONObject a16;
        JSONArray optJSONArray;
        if (hippyEngineContext == null) {
            return new JSONObject();
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("root", jSONObject2);
            jSONObject2.put("nodeId", -3);
            jSONObject2.put("backendNodeId", -3);
            jSONObject2.put("nodeType", 9);
            jSONObject2.put("childNodeCount", 1);
            jSONObject2.put("nodeName", "#document");
            jSONObject2.put("baseURL", "");
            jSONObject2.put("documentURL", "");
            com.tencent.mtt.hippy.dom.b domManager = hippyEngineContext.getDomManager();
            if (domManager != null && (a16 = a(hippyEngineContext, domManager.f())) != null && (optJSONArray = a16.optJSONArray(Node.CHILDREN_ATTR)) != null) {
                jSONObject2.put(Node.CHILDREN_ATTR, optJSONArray);
            }
            return jSONObject;
        } catch (Exception e16) {
            LogUtils.e("DomModel", "getDocument, exception:", e16);
            return new JSONObject();
        }
    }

    private JSONObject a(HippyEngineContext hippyEngineContext, int i3) {
        JSONArray jSONArray = new JSONArray();
        com.tencent.mtt.hippy.dom.b domManager = hippyEngineContext.getDomManager();
        JSONObject jSONObject = null;
        if (domManager != null) {
            com.tencent.mtt.hippy.dom.node.b c16 = domManager.c(i3);
            if (c16 == null) {
                return null;
            }
            DomNodeRecord domNodeRecord = c16.getDomNodeRecord();
            if (domNodeRecord instanceof com.tencent.mtt.hippy.dom.node.a) {
                com.tencent.mtt.hippy.dom.node.a aVar = (com.tencent.mtt.hippy.dom.node.a) domNodeRecord;
                if (!TextUtils.isEmpty(aVar.f337382e)) {
                    jSONArray.mo162put(a(aVar));
                }
            }
            int childCount = c16.getChildCount();
            for (int i16 = 0; i16 < childCount; i16++) {
                jSONArray.mo162put(a(hippyEngineContext, c16.getChildAt(i16).getId()));
            }
            try {
                jSONObject = a((com.tencent.mtt.hippy.dom.node.a) domNodeRecord, 1);
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                jSONObject.put("childNodeCount", jSONArray.length());
                jSONObject.put(Node.CHILDREN_ATTR, jSONArray);
            } catch (Exception e16) {
                LogUtils.e("DomModel", "getNode, exception:", e16);
            }
        }
        return jSONObject;
    }

    public JSONObject a(HippyEngineContext hippyEngineContext, JSONObject jSONObject) {
        if (hippyEngineContext == null || jSONObject == null) {
            return new JSONObject();
        }
        try {
            int optInt = jSONObject.optInt("nodeId", -1);
            com.tencent.mtt.hippy.dom.b domManager = hippyEngineContext.getDomManager();
            RenderManager renderManager = hippyEngineContext.getRenderManager();
            if (domManager != null && renderManager != null) {
                com.tencent.mtt.hippy.dom.node.b c16 = domManager.c(optInt);
                RenderNode renderNode = renderManager.getRenderNode(optInt);
                if (c16 != null && (c16.getDomNodeRecord() instanceof com.tencent.mtt.hippy.dom.node.a) && renderNode != null) {
                    int[] a16 = a(hippyEngineContext, renderNode);
                    if (a16 == null) {
                        return new JSONObject();
                    }
                    JSONArray a17 = a(a16[0], a16[1], renderNode.getWidth(), renderNode.getHeight());
                    HippyMap hippyMap = ((com.tencent.mtt.hippy.dom.node.a) c16.getDomNodeRecord()).f337383f;
                    JSONArray a18 = a(a17, hippyMap);
                    JSONArray b16 = b(a18, hippyMap);
                    JSONArray c17 = c(a17, hippyMap);
                    JSONObject jSONObject2 = new JSONObject();
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("content", b16);
                    jSONObject3.put("padding", a18);
                    jSONObject3.put("border", a17);
                    jSONObject3.put("margin", c17);
                    jSONObject3.put("width", renderNode.getWidth());
                    jSONObject3.put("height", renderNode.getHeight());
                    jSONObject2.put("model", jSONObject3);
                    return jSONObject2;
                }
            }
        } catch (Exception e16) {
            LogUtils.e("DomModel", "getDocument, exception:", e16);
        }
        return new JSONObject();
    }

    private JSONObject a(com.tencent.mtt.hippy.dom.node.a aVar) {
        JSONObject a16 = a(aVar, 3);
        try {
            a16.put("childNodeCount", 0);
            a16.put(Node.CHILDREN_ATTR, new JSONArray());
        } catch (Exception e16) {
            LogUtils.e("DomModel", "getTextNodeJson, exception:", e16);
        }
        return a16;
    }

    public static JSONObject a(com.tencent.mtt.hippy.dom.node.a aVar, int i3) {
        if (aVar == null) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            int i16 = aVar.f337371id;
            if (i3 == 3) {
                i16 = -i16;
            }
            jSONObject.put("nodeId", i16);
            jSONObject.put("backendNodeId", aVar.f337371id);
            jSONObject.put("nodeType", i3);
            jSONObject.put("localName", aVar.className);
            jSONObject.put("nodeName", aVar.tagName);
            jSONObject.put("nodeValue", aVar.f337382e);
            jSONObject.put("parentId", aVar.pid);
            jSONObject.put("attributes", a(aVar.f337384g));
        } catch (Exception e16) {
            LogUtils.e("DomModel", "getTextNodeJson, exception:", e16);
        }
        return jSONObject;
    }

    private static boolean a(HippyEngineContext hippyEngineContext, int i3, int i16, RenderNode renderNode) {
        int[] a16;
        if (renderNode != null && (a16 = a(hippyEngineContext, renderNode)) != null) {
            int i17 = a16[0];
            int i18 = a16[1];
            return (i3 >= i17 && i16 >= i18) && (i3 <= i17 + renderNode.getWidth() && i16 <= i18 + renderNode.getHeight());
        }
        return false;
    }

    private static int[] a(HippyEngineContext hippyEngineContext, RenderNode renderNode) {
        int[] iArr = {renderNode.getX(), renderNode.getY()};
        ControllerManager controllerManager = hippyEngineContext.getRenderManager().getControllerManager();
        if (controllerManager != null) {
            View findView = controllerManager.findView(renderNode.getId());
            if (findView == null) {
                return null;
            }
            findView.getLocationOnScreen(iArr);
            HippyRootView b16 = b(hippyEngineContext);
            if (b16 != null) {
                int[] iArr2 = new int[2];
                b16.getLocationOnScreen(iArr2);
                iArr[0] = iArr[0] - iArr2[0];
                iArr[1] = iArr[1] - iArr2[1];
            }
        }
        return iArr;
    }
}
