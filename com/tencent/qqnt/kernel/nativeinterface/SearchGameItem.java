package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchGameItem {
    public String desc;
    public String icon;

    /* renamed from: id, reason: collision with root package name */
    public String f359213id;
    public String name;
    public int type;
    public String url;

    public SearchGameItem() {
        this.f359213id = "";
        this.name = "";
        this.icon = "";
        this.desc = "";
        this.url = "";
    }

    public String getDesc() {
        return this.desc;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getId() {
        return this.f359213id;
    }

    public String getName() {
        return this.name;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "SearchGameItem{id=" + this.f359213id + ",type=" + this.type + ",name=" + this.name + ",icon=" + this.icon + ",desc=" + this.desc + JefsClass.INDEX_URL + this.url + ",}";
    }

    public SearchGameItem(String str, int i3, String str2, String str3, String str4, String str5) {
        this.f359213id = str;
        this.type = i3;
        this.name = str2;
        this.icon = str3;
        this.desc = str4;
        this.url = str5;
    }
}
