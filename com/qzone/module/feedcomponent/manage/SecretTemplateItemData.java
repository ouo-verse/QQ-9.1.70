package com.qzone.module.feedcomponent.manage;

import android.graphics.Color;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;

/* compiled from: P */
/* loaded from: classes39.dex */
public class SecretTemplateItemData {
    public int backgroundColor;
    public String description;
    public int feedTitleColor;
    public int hintColor;

    /* renamed from: id, reason: collision with root package name */
    public String f48745id;
    public int opColor;
    public int templateType;
    public int textColor;

    public SecretTemplateItemData() {
    }

    public String toString() {
        return "backgroundColor=" + this.backgroundColor + "; textColor=" + this.textColor;
    }

    public SecretTemplateItemData(String str, int i3, int i16, int i17, int i18, int i19, String str2) {
        this.textColor = i3;
        this.backgroundColor = i16;
        this.f48745id = str;
        this.hintColor = i17;
        this.opColor = i18;
        this.templateType = i19;
        this.feedTitleColor = Color.parseColor(TipsElementData.DEFAULT_COLOR);
        this.description = str2;
    }

    public int getColor(String str) {
        if (str != null && str.equals("textColor")) {
            return this.textColor;
        }
        if (str != null && str.equals("backgroundColor")) {
            return this.backgroundColor;
        }
        return this.feedTitleColor;
    }
}
