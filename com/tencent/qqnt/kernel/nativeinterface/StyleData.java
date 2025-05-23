package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class StyleData {
    public String styleName = "";
    public String url = "";
    public String style = "";

    public String getStyle() {
        return this.style;
    }

    public String getStyleName() {
        return this.styleName;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "StyleData{styleName=" + this.styleName + JefsClass.INDEX_URL + this.url + ",style=" + this.style + ",}";
    }
}
