package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class VASMsgFont {
    public Integer diyFontCfgUpdateTime;
    public Integer diyFontImageId;
    public Integer fontId;
    public Integer magicFontType;
    public Long subFontId;

    public VASMsgFont() {
    }

    public Integer getDiyFontCfgUpdateTime() {
        return this.diyFontCfgUpdateTime;
    }

    public Integer getDiyFontImageId() {
        return this.diyFontImageId;
    }

    public Integer getFontId() {
        return this.fontId;
    }

    public Integer getMagicFontType() {
        return this.magicFontType;
    }

    public Long getSubFontId() {
        return this.subFontId;
    }

    public String toString() {
        return "VASMsgFont{fontId=" + this.fontId + ",subFontId=" + this.subFontId + ",diyFontCfgUpdateTime=" + this.diyFontCfgUpdateTime + ",diyFontImageId=" + this.diyFontImageId + ",magicFontType=" + this.magicFontType + ",}";
    }

    public VASMsgFont(Integer num, Long l3, Integer num2, Integer num3, Integer num4) {
        this.fontId = num;
        this.subFontId = l3;
        this.diyFontCfgUpdateTime = num2;
        this.diyFontImageId = num3;
        this.magicFontType = num4;
    }
}
