package com.tencent.biz.pubaccount.readinjoy.view.proteus.bean;

import android.support.v4.util.ArrayMap;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.model.ProteusStyleModel;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ParseData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes4.dex */
public class TemplateBean implements ProteusStyleModel {
    JSONObject data;
    private Map<String, Object> globalVariable;

    /* renamed from: id, reason: collision with root package name */
    private int f79863id;
    private final String styleName;
    private String styleSource;
    private ViewBean viewBean;
    public ParseData parseData = new ParseData();
    private Map<String, ViewBean> viewDataBinding = new ArrayMap();

    public TemplateBean(int i3, String str, Map<String, Object> map) {
        this.f79863id = i3;
        this.styleName = str;
        this.globalVariable = map;
    }

    public void bindData(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2;
        if (this.viewBean != null && jSONObject != null) {
            this.data = jSONObject;
            Map<String, Object> map = this.globalVariable;
            if (map != null && map.size() > 0) {
                jSONObject2 = new JSONObject();
                for (String str : this.globalVariable.keySet()) {
                    if (!jSONObject.has(str)) {
                        jSONObject2.put(str, this.globalVariable.get(str));
                    }
                }
            } else {
                jSONObject2 = null;
            }
            this.viewBean.bindData(jSONObject, jSONObject2, this.viewDataBinding);
            return;
        }
        throw new JSONException("dataJson is null");
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TemplateBean)) {
            return false;
        }
        TemplateBean templateBean = (TemplateBean) obj;
        if (this.f79863id != templateBean.f79863id) {
            return false;
        }
        String str = this.styleSource;
        if (str == null) {
            if (templateBean.getStyleSource() != null) {
                return false;
            }
        } else if (!str.equals(templateBean.getStyleSource())) {
            return false;
        }
        String str2 = this.styleName;
        if (str2 == null) {
            if (templateBean.getStyleName() != null) {
                return false;
            }
        } else if (!str2.equals(templateBean.getStyleName())) {
            return false;
        }
        return true;
    }

    public ViewBean findViewById(String str) {
        return this.viewDataBinding.get(str);
    }

    public JSONObject getData() {
        return this.data;
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.model.ProteusStyleModel
    public Object getDataAttribute(String str, String str2) {
        ViewBean viewBean = getViewBean(str);
        if (viewBean != null) {
            return viewBean.valueBean.getDataAttribute(str2);
        }
        return null;
    }

    public int getId() {
        return this.f79863id;
    }

    public String getStyleName() {
        return this.styleName;
    }

    public String getStyleSource() {
        return this.styleSource;
    }

    public ViewBean getViewBean() {
        return this.viewBean;
    }

    public Map<String, ViewBean> getViewDataBinding() {
        return this.viewDataBinding;
    }

    public void putDynamicJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                String str = (String) keys.next();
                Object obj = jSONObject.get(str);
                ViewBean findViewById = findViewById(str);
                if (findViewById != null && (obj instanceof JSONObject)) {
                    ValueBean valueBean = findViewById.valueBean;
                    JSONObject jSONObject2 = (JSONObject) obj;
                    Iterator keys2 = jSONObject2.keys();
                    while (keys2.hasNext()) {
                        String str2 = (String) keys2.next();
                        valueBean.putTrueDynamicValue(str2, jSONObject2.getString(str2));
                    }
                }
            } catch (JSONException e16) {
                LogUtil.QLog.d(TemplateBean.class.getSimpleName(), 2, "", e16);
            }
        }
    }

    public void refreshData() {
        try {
            if (this.viewBean != null && this.data != null) {
                this.viewDataBinding.clear();
                bindData(this.data);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public void setId(int i3) {
        this.f79863id = i3;
    }

    public void setStyleSource(String str) {
        this.styleSource = str;
    }

    public void setViewBean(ViewBean viewBean) {
        this.viewBean = viewBean;
    }

    public String toString() {
        return " id : " + this.f79863id + "  style: " + this.styleName + "  styleSource: " + this.styleSource;
    }

    private ViewBean getViewBean(String str) {
        if (str == null) {
            return this.viewBean;
        }
        return findViewById(str);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public TemplateBean m96clone() {
        TemplateBean templateBean = new TemplateBean(this.f79863id, this.styleName, this.globalVariable);
        templateBean.viewBean = this.viewBean.m98clone();
        templateBean.setStyleSource(this.styleSource);
        return templateBean;
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.model.ProteusStyleModel
    public Map<String, Object> getDataAttribute(String str) {
        ViewBean viewBean = getViewBean(str);
        if (viewBean != null) {
            return viewBean.valueBean.getDataAttribute();
        }
        return null;
    }
}
