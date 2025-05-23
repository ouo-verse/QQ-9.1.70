package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdLightInteractionInfo extends JceStruct {
    public String interactDesc;
    public String interactTitle;
    public int interactionDirectionType;
    public int layoutDirection;
    public float ratio;
    public String zipUrlStr;

    public AdLightInteractionInfo() {
        this.layoutDirection = 0;
        this.interactionDirectionType = 0;
        this.interactTitle = "";
        this.interactDesc = "";
        this.zipUrlStr = "";
        this.ratio = 0.0f;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.layoutDirection = jceInputStream.read(this.layoutDirection, 0, false);
        this.interactionDirectionType = jceInputStream.read(this.interactionDirectionType, 1, false);
        this.interactTitle = jceInputStream.readString(2, false);
        this.interactDesc = jceInputStream.readString(3, false);
        this.zipUrlStr = jceInputStream.readString(4, false);
        this.ratio = jceInputStream.read(this.ratio, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.layoutDirection, 0);
        jceOutputStream.write(this.interactionDirectionType, 1);
        String str = this.interactTitle;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.interactDesc;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        String str3 = this.zipUrlStr;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        jceOutputStream.write(this.ratio, 5);
    }

    public AdLightInteractionInfo(int i3, int i16, String str, String str2, String str3, float f16) {
        this.layoutDirection = i3;
        this.interactionDirectionType = i16;
        this.interactTitle = str;
        this.interactDesc = str2;
        this.zipUrlStr = str3;
        this.ratio = f16;
    }
}
