package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;

/* loaded from: classes24.dex */
public final class GProLiveAnchorPlayStream {
    public Integer bitrate;
    public Integer codecType;
    public Integer definition;
    public String definitionName;
    public Integer type;
    public String url;

    public Integer getBitrate() {
        return this.bitrate;
    }

    public Integer getCodecType() {
        return this.codecType;
    }

    public Integer getDefinition() {
        return this.definition;
    }

    public String getDefinitionName() {
        return this.definitionName;
    }

    public Integer getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "GProLiveAnchorPlayStream{type=" + this.type + JefsClass.INDEX_URL + this.url + ",bitrate=" + this.bitrate + ",definition=" + this.definition + ",codecType=" + this.codecType + ",definitionName=" + this.definitionName + ",}";
    }
}
