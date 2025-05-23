package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdInteractionInfo extends JceStruct {
    static AdLightInteractionInfo cache_lightInteractionInfo = new AdLightInteractionInfo();
    static AdShakeLightInteractionInfo cache_shakeInteractionInfo = new AdShakeLightInteractionInfo();
    public String destUrl;
    public int interactionType;
    public AdLightInteractionInfo lightInteractionInfo;
    public AdShakeLightInteractionInfo shakeInteractionInfo;

    public AdInteractionInfo() {
        this.interactionType = 0;
        this.lightInteractionInfo = null;
        this.destUrl = "";
        this.shakeInteractionInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.interactionType = jceInputStream.read(this.interactionType, 0, false);
        this.lightInteractionInfo = (AdLightInteractionInfo) jceInputStream.read((JceStruct) cache_lightInteractionInfo, 1, false);
        this.destUrl = jceInputStream.readString(2, false);
        this.shakeInteractionInfo = (AdShakeLightInteractionInfo) jceInputStream.read((JceStruct) cache_shakeInteractionInfo, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.interactionType, 0);
        AdLightInteractionInfo adLightInteractionInfo = this.lightInteractionInfo;
        if (adLightInteractionInfo != null) {
            jceOutputStream.write((JceStruct) adLightInteractionInfo, 1);
        }
        String str = this.destUrl;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        AdShakeLightInteractionInfo adShakeLightInteractionInfo = this.shakeInteractionInfo;
        if (adShakeLightInteractionInfo != null) {
            jceOutputStream.write((JceStruct) adShakeLightInteractionInfo, 3);
        }
    }

    public AdInteractionInfo(int i3, AdLightInteractionInfo adLightInteractionInfo, String str, AdShakeLightInteractionInfo adShakeLightInteractionInfo) {
        this.interactionType = i3;
        this.lightInteractionInfo = adLightInteractionInfo;
        this.destUrl = str;
        this.shakeInteractionInfo = adShakeLightInteractionInfo;
    }
}
