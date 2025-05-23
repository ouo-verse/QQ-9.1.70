package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RequireData {
    public String name = "";
    public String url = "";
    public String data = "";
    public ArrayList<CallbackData> callbackData = new ArrayList<>();
    public String templateInfo = "";

    public ArrayList<CallbackData> getCallbackData() {
        return this.callbackData;
    }

    public String getData() {
        return this.data;
    }

    public String getName() {
        return this.name;
    }

    public String getTemplateInfo() {
        return this.templateInfo;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "RequireData{name=" + this.name + JefsClass.INDEX_URL + this.url + ",data=" + this.data + ",callbackData=" + this.callbackData + ",templateInfo=" + this.templateInfo + ",}";
    }
}
