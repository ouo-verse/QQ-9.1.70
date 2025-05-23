package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class AppCommonMenu implements Serializable {
    public int AppCommonMenuTemplateTemplate;
    long serialVersionUID = 1;
    public String menuId = "";
    public String icon = "";
    public String title = "";
    public String desc = "";
    public String btnText = "";
    public AppCommonMenuAction action = new AppCommonMenuAction();
    public String rightText = "";

    public AppCommonMenuAction getAction() {
        return this.action;
    }

    public int getAppCommonMenuTemplateTemplate() {
        return this.AppCommonMenuTemplateTemplate;
    }

    public String getBtnText() {
        return this.btnText;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getMenuId() {
        return this.menuId;
    }

    public String getRightText() {
        return this.rightText;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "AppCommonMenu{menuId=" + this.menuId + ",AppCommonMenuTemplateTemplate=" + this.AppCommonMenuTemplateTemplate + ",icon=" + this.icon + ",title=" + this.title + ",desc=" + this.desc + ",btnText=" + this.btnText + ",action=" + this.action + ",rightText=" + this.rightText + ",}";
    }
}
