package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class TodoBanner {
    public boolean isComplete;
    public boolean isExposure;
    public String redText = "";
    public String text = "";
    public String url = "";

    public boolean getIsComplete() {
        return this.isComplete;
    }

    public boolean getIsExposure() {
        return this.isExposure;
    }

    public String getRedText() {
        return this.redText;
    }

    public String getText() {
        return this.text;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "TodoBanner{redText=" + this.redText + ",text=" + this.text + JefsClass.INDEX_URL + this.url + ",isExposure=" + this.isExposure + ",isComplete=" + this.isComplete + ",}";
    }
}
