package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;
import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProGameDownloadLink implements Serializable {
    long serialVersionUID = 1;
    public String platform = "";
    public String url = "";

    public String getPlatform() {
        return this.platform;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "GProGameDownloadLink{platform=" + this.platform + JefsClass.INDEX_URL + this.url + ",}";
    }
}
