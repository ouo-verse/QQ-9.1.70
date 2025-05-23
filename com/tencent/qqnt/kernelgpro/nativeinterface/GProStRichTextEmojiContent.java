package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;
import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProStRichTextEmojiContent implements Serializable {
    long serialVersionUID = 1;
    public String idd = "";
    public String type = "";
    public String name = "";
    public String url = "";

    public String getIdd() {
        return this.idd;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "GProStRichTextEmojiContent{idd=" + this.idd + ",type=" + this.type + ",name=" + this.name + JefsClass.INDEX_URL + this.url + ",}";
    }
}
