package com.tencent.qqnt.kernelpublic.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class JsonGrayElement implements Serializable {
    public long busiId;
    public boolean isServer;
    public String jsonStr;
    public String recentAbstract;
    long serialVersionUID;
    public XmlToJsonParam xmlToJsonParam;

    public JsonGrayElement() {
        this.serialVersionUID = 1L;
        this.jsonStr = "";
        this.recentAbstract = "";
    }

    public long getBusiId() {
        return this.busiId;
    }

    public boolean getIsServer() {
        return this.isServer;
    }

    public String getJsonStr() {
        return this.jsonStr;
    }

    public String getRecentAbstract() {
        return this.recentAbstract;
    }

    public XmlToJsonParam getXmlToJsonParam() {
        return this.xmlToJsonParam;
    }

    public String toString() {
        return "JsonGrayElement{busiId=" + this.busiId + ",jsonStr=" + this.jsonStr + ",recentAbstract=" + this.recentAbstract + ",isServer=" + this.isServer + ",xmlToJsonParam=" + this.xmlToJsonParam + ",}";
    }

    public JsonGrayElement(long j3, String str, String str2, boolean z16, XmlToJsonParam xmlToJsonParam) {
        this.serialVersionUID = 1L;
        this.busiId = j3;
        this.jsonStr = str;
        this.recentAbstract = str2;
        this.isServer = z16;
        this.xmlToJsonParam = xmlToJsonParam;
    }
}
