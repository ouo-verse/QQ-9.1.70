package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class NotifyBanner {
    public String text = "";
    public String url = "";

    public String getText() {
        return this.text;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "NotifyBanner{text=" + this.text + JefsClass.INDEX_URL + this.url + ",}";
    }
}
