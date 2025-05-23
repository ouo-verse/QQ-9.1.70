package com.tencent.biz.pubaccount.readinjoy.view.proteus.bean;

import android.support.v4.util.ArrayMap;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.AssertUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ValueBean {
    private static final String TAG = "ValueBean";
    private Map<String, Node> dynamicValueBinder = new ArrayMap();
    public Map<String, Object> normalValue = new ArrayMap();
    public Map<String, Object> dynamicValue = new ArrayMap();
    private Map<String, ValueNode> attributeDynamicValue = new ArrayMap();
    private Map<String, Object> dataAttributeLocalInfo = new ArrayMap();
    private Map<String, Object> dataAttributeRemoteInfo = new ArrayMap();
    private Map<String, ValueNode> dataAttributeDynamicValue = new ArrayMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class Node {
        String methodName;
        Node next;

        public Node(String str, Node node) {
            this.methodName = str;
            this.next = node;
        }
    }

    private void putTrueDynamicValueAttrbute(String str, Object obj, String str2) {
        ValueNode valueNode = this.attributeDynamicValue.get(str2);
        if (valueNode != null) {
            valueNode.setTrueValue(this.dynamicValue, str2, str, obj);
        }
    }

    private void putTrueDynamicValueDataAttr(String str, Object obj, String str2) {
        ValueNode valueNode = this.dataAttributeDynamicValue.get(str2);
        if (valueNode != null) {
            valueNode.setTrueValue(this.dataAttributeRemoteInfo, str2, str, obj);
            if ("$setRemoteInfo:".equals(str2)) {
                Object remove = this.dataAttributeRemoteInfo.remove("$setRemoteInfo:");
                if (remove instanceof JSONObject) {
                    JSONObject jSONObject = (JSONObject) remove;
                    Iterator keys = jSONObject.keys();
                    while (keys != null && keys.hasNext()) {
                        String str3 = (String) keys.next();
                        Object opt = jSONObject.opt(str3);
                        if (opt != null) {
                            this.dataAttributeRemoteInfo.put(str3, opt);
                        }
                    }
                }
            }
        }
    }

    public Object getDataAttribute(String str) {
        Object obj = this.dataAttributeRemoteInfo.get(str);
        return obj != null ? obj : this.dataAttributeLocalInfo.get(str);
    }

    public String getVisibleDependeOnBrotherViewId() {
        if (this.normalValue.containsKey(StringCommon.VISIBLE_DEPEPEND_ON_BROTHER)) {
            Object obj = this.normalValue.get(StringCommon.VISIBLE_DEPEPEND_ON_BROTHER);
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        }
        return null;
    }

    public boolean isDefalutVisible() {
        if (this.normalValue.containsKey(StringCommon.DEFAULT_VISIBLE) && "YES".equals((String) this.normalValue.get(StringCommon.DEFAULT_VISIBLE))) {
            return true;
        }
        return false;
    }

    public boolean isVisible() {
        return ParseCommon.VISIBLE.equals(this.dynamicValue.get("visibility"));
    }

    public boolean isVisibleDependeOnChilds() {
        if (this.normalValue.containsKey(StringCommon.VISIBLE_DEPEPEND_ON_CHILDREN) && "YES".equals(this.normalValue.get(StringCommon.VISIBLE_DEPEPEND_ON_CHILDREN))) {
            return true;
        }
        return false;
    }

    public void putAttributeDynamicValue(String str, Object obj) {
        this.attributeDynamicValue.put(str, new ValueNode(obj));
    }

    public void putDataAttributeDynamicValue(String str, Object obj) {
        this.dataAttributeDynamicValue.put(str, new ValueNode(obj));
    }

    public void putDataAttributeLocalData(String str, Object obj) {
        this.dataAttributeLocalInfo.put(str, obj);
    }

    public void putDynamicValue(String str, String str2) {
        this.dynamicValueBinder.put(str, new Node(str2, this.dynamicValueBinder.get(str)));
    }

    public void putNomalValue(String str, Object obj) {
        this.normalValue.put(str, obj);
    }

    public void putTrueDynamicValue(String str, Object obj) {
        putTrueDynamicValue(str, obj, true);
    }

    public String toString() {
        return "normalValueMap : " + this.normalValue.toString() + "\ndynamicValueMap : " + this.dynamicValue.toString() + "\ndynamicValueBinder : " + this.dynamicValueBinder.toString();
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public ValueBean m97clone() {
        ValueBean valueBean = new ValueBean();
        valueBean.normalValue = this.normalValue;
        valueBean.dynamicValueBinder = this.dynamicValueBinder;
        valueBean.attributeDynamicValue = this.attributeDynamicValue;
        valueBean.dataAttributeDynamicValue = this.dataAttributeDynamicValue;
        valueBean.dataAttributeLocalInfo = this.dataAttributeLocalInfo;
        return valueBean;
    }

    public boolean putTrueDynamicValue(String str, Object obj, boolean z16) {
        Node node = this.dynamicValueBinder.get(str);
        if (node == null) {
            if (!z16) {
                return false;
            }
            this.dynamicValue.put(str, obj);
            return false;
        }
        while (node != null) {
            putTrueDynamicValueAttrbute(str, obj, node.methodName);
            putTrueDynamicValueDataAttr(str, obj, node.methodName);
            node = node.next;
        }
        return true;
    }

    public Map<String, Object> getDataAttribute() {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.putAll(this.dataAttributeLocalInfo);
        arrayMap.putAll(this.dataAttributeRemoteInfo);
        return arrayMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class ValueNode {
        Object styleDynamicValue;

        public ValueNode(Object obj) {
            this.styleDynamicValue = obj;
        }

        private Object createJsonType(Object obj) {
            if (obj instanceof JSONObject) {
                return new JSONObject();
            }
            if (obj instanceof JSONArray) {
                return new JSONArray();
            }
            return null;
        }

        private String getDynamicValue(String str) {
            return "${" + str + "}";
        }

        private boolean isDynamicInString(String str, String str2) {
            return str2.contains(getDynamicValue(str));
        }

        private boolean isDynamicValue(String str, String str2) {
            if (!str.equals(str2)) {
                if (!("$" + str).equals(str2)) {
                    return false;
                }
                return true;
            }
            return true;
        }

        private String replace$Value(String str, String str2, Object obj) {
            return str.replace(getDynamicValue(str2), String.valueOf(obj));
        }

        public void setTrueValue(Map<String, Object> map, String str, String str2, Object obj) {
            boolean trueValue;
            Object obj2 = this.styleDynamicValue;
            if (obj2 instanceof String) {
                if (isDynamicValue(str2, (String) obj2)) {
                    trueValue = true;
                } else {
                    trueValue = false;
                    obj = null;
                }
            } else {
                Object obj3 = map.get(str);
                if (obj3 == null) {
                    obj3 = createJsonType(this.styleDynamicValue);
                }
                trueValue = setTrueValue(this.styleDynamicValue, obj3, str2, obj);
                obj = obj3;
            }
            if (trueValue && map != null) {
                map.put(str, obj);
            }
            if (AssertUtil.isDebugVersion()) {
                AssertUtil.assertInValidAttributesBinding(str);
            }
        }

        private boolean setTrueValue(Object obj, Object obj2, String str, Object obj3) {
            boolean z16 = false;
            int i3 = 0;
            if (obj instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) obj;
                JSONArray jSONArray2 = (JSONArray) obj2;
                boolean z17 = false;
                while (i3 < jSONArray.length()) {
                    try {
                        Object obj4 = jSONArray.get(i3);
                        if (obj4 instanceof String) {
                            String str2 = (String) obj4;
                            if (isDynamicValue(str, (String) obj4)) {
                                jSONArray2.put(i3, obj3);
                            } else if (isDynamicInString(str, str2)) {
                                jSONArray2.put(i3, replace$Value(str2, str, obj3));
                            } else if (jSONArray2.length() <= i3) {
                                jSONArray2.put(i3, obj4);
                            }
                            z17 = true;
                        } else {
                            Object obj5 = i3 < jSONArray2.length() ? jSONArray2.get(i3) : null;
                            if (obj5 == null) {
                                obj5 = createJsonType(obj4);
                            }
                            jSONArray2.put(i3, obj5);
                            z17 |= setTrueValue(obj4, obj5, str, obj3);
                        }
                    } catch (JSONException e16) {
                        LogUtil.QLog.e(ValueBean.TAG, 2, "setTrueValue: ", e16);
                    }
                    i3++;
                }
                return z17;
            }
            if (!(obj instanceof JSONObject)) {
                return false;
            }
            JSONObject jSONObject = (JSONObject) obj;
            JSONObject jSONObject2 = (JSONObject) obj2;
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str3 = (String) keys.next();
                try {
                    Object obj6 = jSONObject.get(str3);
                    if (obj6 instanceof String) {
                        String str4 = (String) obj6;
                        if (isDynamicValue(str, str4)) {
                            jSONObject2.put(str3, obj3);
                        } else if (isDynamicInString(str, str4)) {
                            jSONObject2.put(str3, replace$Value(str4, str, obj3));
                        } else if (!jSONObject2.has(str3)) {
                            jSONObject2.put(str3, obj6);
                        }
                        z16 = true;
                    } else if (obj6 instanceof Integer) {
                        jSONObject2.put(str3, obj6);
                    } else {
                        Object opt = jSONObject2.opt(str3);
                        if (opt == null) {
                            opt = createJsonType(obj6);
                            jSONObject2.put(str3, opt);
                        }
                        z16 |= setTrueValue(obj6, opt, str, obj3);
                    }
                } catch (JSONException e17) {
                    LogUtil.QLog.e(ValueBean.TAG, 2, "setTrueValue: ", e17);
                }
            }
            return z16;
        }
    }
}
