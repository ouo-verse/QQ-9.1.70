package com.tencent.mobileqq.vas.pendant.drawable.bean;

import java.io.Serializable;

/* loaded from: classes20.dex */
public class DiyPendantSticker implements Serializable {
    public int angle;
    public String fontColor;
    public int fontId;
    public int fontType;
    public int stickerId;
    public String text;
    public int type;

    public DiyPendantSticker(int i3, int i16, int i17, String str, int i18, int i19, String str2) {
        this.type = i3;
        this.stickerId = i16;
        this.angle = i17;
        this.text = str;
        this.fontId = i18;
        this.fontType = i19;
        this.fontColor = str2;
    }
}
