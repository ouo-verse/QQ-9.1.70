package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;

/* loaded from: classes24.dex */
public final class PicMaterial {
    public PicStyle picStyle = PicStyle.values()[0];
    public StyleInfo styleInfo = new StyleInfo();
    public String url = "";
    public String md5 = "";

    public String getMd5() {
        return this.md5;
    }

    public PicStyle getPicStyle() {
        return this.picStyle;
    }

    public StyleInfo getStyleInfo() {
        return this.styleInfo;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "PicMaterial{picStyle=" + this.picStyle + ",styleInfo=" + this.styleInfo + JefsClass.INDEX_URL + this.url + ",md5=" + this.md5 + ",}";
    }
}
