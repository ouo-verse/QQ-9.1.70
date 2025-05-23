package com.tencent.biz.pubaccount.readinjoy.view.proteus.factory;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParserWithHotReload;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.loaders.ComplementFileStringLoader;
import java.io.IOException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes4.dex */
public class TemplateWithHotReloadFactory extends BaseTemplateFactory implements ProteusParserWithHotReload.IHotReloadChangedObserver {
    public TemplateWithHotReloadFactory() {
        if (ProteusParserWithHotReload.getInstance().isSupportHotReload()) {
            ProteusParserWithHotReload.getInstance().addHotReloadChangedObserver(this);
        }
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory
    public void createTemplate(int i3, String str, ViewBean viewBean, Map<String, Object> map) {
        if (ProteusParserWithHotReload.getInstance().isSupportHotReload()) {
            TemplateBean templateBean = new TemplateBean(i3, str, map);
            templateBean.setViewBean(viewBean);
            this.nameTemplateMap.put(str, templateBean);
            onAddTemplate(str, templateBean);
            return;
        }
        super.createTemplate(i3, str, viewBean, map);
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory
    public void createViewTemplate(JSONObject jSONObject, ComplementFileStringLoader complementFileStringLoader) throws JSONException {
        if (ProteusParserWithHotReload.getInstance().isSupportHotReload()) {
            ProteusParserWithHotReload.getInstance().createViewTemplate(this, jSONObject, complementFileStringLoader, (String) null);
        } else {
            super.createViewTemplate(jSONObject, complementFileStringLoader);
        }
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory
    public TemplateBean getTemplateBean(JSONObject jSONObject) throws JSONException {
        if (ProteusParserWithHotReload.getInstance().isSupportHotReload()) {
            return ProteusParserWithHotReload.getInstance().getTemplateBeanFromJson(this, jSONObject);
        }
        return super.getTemplateBean(jSONObject);
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParserWithHotReload.IHotReloadChangedObserver
    public void onHotReloadChanged(Context context, String str, String str2) {
        try {
            ProteusParserWithHotReload.getInstance().createViewTemplateFromFile(context, this, str2);
        } catch (IOException e16) {
            e16.printStackTrace();
        } catch (JSONException e17) {
            e17.printStackTrace();
        }
    }
}
