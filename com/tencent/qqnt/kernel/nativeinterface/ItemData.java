package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ItemData {
    public String name = "";
    public String templateInfo = "";
    public ArrayList<RequireFunction> requireFunction = new ArrayList<>();
    public ArrayList<CallbackData> callbackData = new ArrayList<>();
    public String placeHolder = "";

    public ArrayList<CallbackData> getCallbackData() {
        return this.callbackData;
    }

    public String getName() {
        return this.name;
    }

    public String getPlaceHolder() {
        return this.placeHolder;
    }

    public ArrayList<RequireFunction> getRequireFunction() {
        return this.requireFunction;
    }

    public String getTemplateInfo() {
        return this.templateInfo;
    }

    public String toString() {
        return "ItemData{name=" + this.name + ",templateInfo=" + this.templateInfo + ",requireFunction=" + this.requireFunction + ",callbackData=" + this.callbackData + ",placeHolder=" + this.placeHolder + ",}";
    }
}
