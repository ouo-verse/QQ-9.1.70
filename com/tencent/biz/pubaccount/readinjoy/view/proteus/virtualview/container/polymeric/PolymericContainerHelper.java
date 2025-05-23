package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.polymeric;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.BindDataUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class PolymericContainerHelper implements PolymericContainer {
    private String TAG = "PolymericContainerHelper";
    public List<TemplateBean> childs = new ArrayList();

    private void addCell(BaseTemplateFactory baseTemplateFactory, JSONObject jSONObject) {
        try {
            TemplateBean templateBean = baseTemplateFactory.getTemplateBean(jSONObject);
            if (templateBean != null) {
                this.childs.add(templateBean);
            } else {
                LogUtil.QLog.e(this.TAG, 1, "templateBean == null " + jSONObject);
            }
        } catch (JSONException e16) {
            LogUtil.QLog.e(this.TAG, 1, "addCell " + jSONObject, e16);
        }
    }

    public TemplateBean getCellData(int i3) {
        if (i3 >= this.childs.size()) {
            return null;
        }
        return this.childs.get(i3);
    }

    public Container getCellView(VafContext vafContext, int i3) {
        if (i3 >= this.childs.size()) {
            return null;
        }
        TemplateBean templateBean = this.childs.get(i3);
        Container inflate = vafContext.getViewFactory().inflate(vafContext, templateBean);
        BindDataUtil.bindDynamicValueWithoutRecursion(inflate, null, templateBean);
        return inflate;
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.polymeric.PolymericContainer
    public EventCallback getEventCallback() {
        return null;
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.polymeric.PolymericContainer
    public void setCellArray(BaseTemplateFactory baseTemplateFactory, JSONArray jSONArray) {
        if (jSONArray != null) {
            this.childs.clear();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                try {
                    addCell(baseTemplateFactory, jSONArray.getJSONObject(i3));
                } catch (JSONException e16) {
                    LogUtil.QLog.e(this.TAG, 1, "", e16);
                }
            }
        }
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.polymeric.PolymericContainer
    public void setEventCallback(EventCallback eventCallback) {
    }
}
