package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class Button {
    public String wording = "";
    public String url = "";

    public String getUrl() {
        return this.url;
    }

    public String getWording() {
        return this.wording;
    }

    public String toString() {
        return "Button{wording=" + this.wording + JefsClass.INDEX_URL + this.url + ",}";
    }
}
