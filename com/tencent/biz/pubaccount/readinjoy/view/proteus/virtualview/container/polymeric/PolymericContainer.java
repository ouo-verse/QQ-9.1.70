package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.polymeric;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import org.json.JSONArray;

/* loaded from: classes4.dex */
public interface PolymericContainer {
    EventCallback getEventCallback();

    void setCellArray(BaseTemplateFactory baseTemplateFactory, JSONArray jSONArray);

    void setEventCallback(EventCallback eventCallback);
}
