package com.tencent.biz.pubaccount.readinjoy.view.proteus.factory;

import android.support.v4.util.ArrayMap;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ParseData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParser;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.loaders.ComplementFileStringLoader;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes4.dex */
public class BaseTemplateFactory {
    protected AtomicInteger templateId = new AtomicInteger(0);
    protected Map<String, TemplateBean> nameTemplateMap = new ArrayMap();
    private ProteusParser proteusParser = new ProteusParser();

    public void createTemplate(int i3, String str, ViewBean viewBean, Map<String, Object> map) {
        TemplateBean templateBean = new TemplateBean(i3, str, map);
        templateBean.setViewBean(viewBean);
        this.nameTemplateMap.put(str, templateBean);
        onAddTemplate(str, templateBean);
    }

    public void createViewTemplate(String str, ComplementFileStringLoader complementFileStringLoader) throws JSONException {
        createViewTemplate(new JSONObject(str), complementFileStringLoader);
    }

    public Map<String, TemplateBean> getNameTemplateMap() {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.putAll(this.nameTemplateMap);
        return arrayMap;
    }

    public ParseData getParseData(String str) {
        TemplateBean templateBean = this.nameTemplateMap.get(str);
        if (templateBean != null) {
            return templateBean.parseData;
        }
        return null;
    }

    public TemplateBean getTemplate(String str) {
        TemplateBean templateBean = this.nameTemplateMap.get(str);
        if (templateBean == null) {
            return null;
        }
        return templateBean.m96clone();
    }

    public TemplateBean getTemplateBean(JSONObject jSONObject) throws JSONException {
        return ProteusParser.getTemplateBean(this, jSONObject);
    }

    public int getTemplateId() {
        return this.templateId.get();
    }

    public boolean hasTemplate(String str) {
        return this.nameTemplateMap.containsKey(str);
    }

    public boolean isUsable() {
        if (getTemplateId() <= 0) {
            return false;
        }
        return true;
    }

    public int size() {
        return this.nameTemplateMap.size();
    }

    public void updateAllTemplate() {
        this.templateId.incrementAndGet();
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BaseTemplateFactory m99clone() {
        BaseTemplateFactory baseTemplateFactory = new BaseTemplateFactory();
        baseTemplateFactory.templateId = new AtomicInteger(getTemplateId());
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.putAll(this.nameTemplateMap);
        baseTemplateFactory.nameTemplateMap = arrayMap;
        return baseTemplateFactory;
    }

    public void createViewTemplate(JSONObject jSONObject, ComplementFileStringLoader complementFileStringLoader) throws JSONException {
        this.proteusParser.createViewTemplate(this, jSONObject, complementFileStringLoader);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onAddTemplate(String str, TemplateBean templateBean) {
    }
}
