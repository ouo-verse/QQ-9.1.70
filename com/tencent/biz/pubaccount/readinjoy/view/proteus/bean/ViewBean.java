package com.tencent.biz.pubaccount.readinjoy.view.proteus.bean;

import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ViewBean {
    public ViewBean[] children;
    public ValueBean valueBean = new ValueBean();
    public String viewId;
    public String viewType;

    private static void addExtraData(JSONObject jSONObject, Map<String, Object> map, String str) {
        if (jSONObject != null && map != null && !TextUtils.isEmpty(str)) {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                if (!str.equalsIgnoreCase(str2)) {
                    map.put(str2, jSONObject.opt(str2));
                }
            }
        }
    }

    private boolean bindValueWithoutId(JSONObject jSONObject, JSONObject jSONObject2) {
        Iterator keys = jSONObject.keys();
        boolean z16 = false;
        while (keys.hasNext()) {
            String str = (String) keys.next();
            try {
                if (this.valueBean.putTrueDynamicValue(str, jSONObject.get(str), false)) {
                    z16 = true;
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        if (jSONObject2 != null) {
            try {
                Iterator keys2 = jSONObject2.keys();
                while (keys2.hasNext()) {
                    String str2 = (String) keys2.next();
                    this.valueBean.putTrueDynamicValue(str2, jSONObject2.get(str2), false);
                }
            } catch (JSONException e17) {
                e17.printStackTrace();
            }
        }
        return setVisible(z16);
    }

    private static Map<String, Object> getKeyOriginValue(JSONObject jSONObject) throws JSONException {
        ArrayMap arrayMap = new ArrayMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object obj = jSONObject.get(str);
            if (obj != null) {
                arrayMap.put(str, obj);
            }
        }
        return arrayMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public void bindData(JSONObject jSONObject, JSONObject jSONObject2, Map<String, ViewBean> map) throws JSONException {
        String str;
        JSONObject optJSONObject = jSONObject.optJSONObject(this.viewId);
        if (optJSONObject != null) {
            setVisible(true);
            Map<String, Object> keyOriginValue = getKeyOriginValue(optJSONObject);
            addExtraData(jSONObject, keyOriginValue, this.viewId);
            for (Map.Entry<String, Object> entry : keyOriginValue.entrySet()) {
                this.valueBean.putTrueDynamicValue(entry.getKey(), entry.getValue());
            }
        } else {
            bindValueWithoutId(jSONObject, jSONObject2);
        }
        if (this.children != null) {
            boolean isVisibleDependeOnChilds = this.valueBean.isVisibleDependeOnChilds();
            HashMap hashMap = null;
            boolean z16 = false;
            for (ViewBean viewBean : this.children) {
                if (!viewBean.valueBean.isVisibleDependeOnChilds()) {
                    str = viewBean.valueBean.getVisibleDependeOnBrotherViewId();
                } else {
                    str = null;
                }
                if (str != null) {
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    hashMap.put(str, viewBean);
                }
                viewBean.bindData(jSONObject, jSONObject2, map);
                if (viewBean.valueBean.isVisible()) {
                    z16 = true;
                }
            }
            if (isVisibleDependeOnChilds) {
                setVisible(z16);
            }
            if (hashMap != null) {
                for (Map.Entry entry2 : hashMap.entrySet()) {
                    ViewBean findViewById = findViewById((String) entry2.getKey());
                    if (findViewById != null) {
                        boolean isVisible = findViewById.valueBean.isVisible();
                        ((ViewBean) entry2.getValue()).setVisible(isVisible);
                        if (isVisible) {
                            map.put(((ViewBean) entry2.getValue()).viewId, entry2.getValue());
                        } else {
                            map.remove(((ViewBean) entry2.getValue()).viewId);
                        }
                    }
                }
            }
        }
        if (this.valueBean.isVisible()) {
            map.put(this.viewId, this);
        } else {
            map.remove(this.viewId);
        }
    }

    public ViewBean findViewById(String str) {
        if (str.equals(this.viewId)) {
            return this;
        }
        return findViewFromChild(str);
    }

    public ViewBean findViewFromChild(String str) {
        ViewBean findViewById;
        ViewBean[] viewBeanArr = this.children;
        if (viewBeanArr != null) {
            for (ViewBean viewBean : viewBeanArr) {
                if (viewBean != null && (findViewById = viewBean.findViewById(str)) != null) {
                    return findViewById;
                }
            }
            return null;
        }
        return null;
    }

    public Object getDynamicValue(String str) {
        return this.valueBean.dynamicValue.get(str);
    }

    public void putDynamicValue(String str, Object obj) {
        this.valueBean.dynamicValue.put(str, obj);
    }

    public void putMapValue(String str, Object obj) {
        this.valueBean.putTrueDynamicValue(str, obj);
    }

    public boolean setVisible(boolean z16) {
        if (z16) {
            this.valueBean.putTrueDynamicValue("visibility", ParseCommon.VISIBLE);
            return z16;
        }
        if (this.valueBean.isDefalutVisible()) {
            this.valueBean.putTrueDynamicValue("visibility", ParseCommon.VISIBLE);
            return true;
        }
        this.valueBean.putTrueDynamicValue("visibility", ParseCommon.GONE);
        return false;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public ViewBean m98clone() {
        ViewBean viewBean = new ViewBean();
        viewBean.viewId = this.viewId;
        viewBean.viewType = this.viewType;
        ValueBean valueBean = this.valueBean;
        if (valueBean != null) {
            viewBean.valueBean = valueBean.m97clone();
        }
        ViewBean[] viewBeanArr = this.children;
        if (viewBeanArr != null) {
            viewBean.children = new ViewBean[viewBeanArr.length];
            int i3 = 0;
            while (true) {
                ViewBean[] viewBeanArr2 = this.children;
                if (i3 >= viewBeanArr2.length) {
                    break;
                }
                viewBean.children[i3] = viewBeanArr2[i3].m98clone();
                i3++;
            }
        }
        return viewBean;
    }
}
