package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdShakeLightInteractionInfo extends JceStruct {
    static AdLightInteractionCommonInfo cache_commonItem = new AdLightInteractionCommonInfo();
    static AdShakeAccelerateFactor cache_shakeAccelerateFactory = new AdShakeAccelerateFactor();
    public AdLightInteractionCommonInfo commonItem;
    public AdShakeAccelerateFactor shakeAccelerateFactory;
    public int shakeAcceleration;
    public String shakeIconUrl;
    public int shakeStyle;
    public int shakeTimes;

    public AdShakeLightInteractionInfo() {
        this.commonItem = null;
        this.shakeAcceleration = 0;
        this.shakeTimes = 0;
        this.shakeStyle = 0;
        this.shakeIconUrl = "";
        this.shakeAccelerateFactory = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.commonItem = (AdLightInteractionCommonInfo) jceInputStream.read((JceStruct) cache_commonItem, 0, false);
        this.shakeAcceleration = jceInputStream.read(this.shakeAcceleration, 1, false);
        this.shakeTimes = jceInputStream.read(this.shakeTimes, 2, false);
        this.shakeStyle = jceInputStream.read(this.shakeStyle, 3, false);
        this.shakeIconUrl = jceInputStream.readString(4, false);
        this.shakeAccelerateFactory = (AdShakeAccelerateFactor) jceInputStream.read((JceStruct) cache_shakeAccelerateFactory, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        AdLightInteractionCommonInfo adLightInteractionCommonInfo = this.commonItem;
        if (adLightInteractionCommonInfo != null) {
            jceOutputStream.write((JceStruct) adLightInteractionCommonInfo, 0);
        }
        jceOutputStream.write(this.shakeAcceleration, 1);
        jceOutputStream.write(this.shakeTimes, 2);
        jceOutputStream.write(this.shakeStyle, 3);
        String str = this.shakeIconUrl;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        AdShakeAccelerateFactor adShakeAccelerateFactor = this.shakeAccelerateFactory;
        if (adShakeAccelerateFactor != null) {
            jceOutputStream.write((JceStruct) adShakeAccelerateFactor, 5);
        }
    }

    public AdShakeLightInteractionInfo(AdLightInteractionCommonInfo adLightInteractionCommonInfo, int i3, int i16, int i17, String str, AdShakeAccelerateFactor adShakeAccelerateFactor) {
        this.commonItem = adLightInteractionCommonInfo;
        this.shakeAcceleration = i3;
        this.shakeTimes = i16;
        this.shakeStyle = i17;
        this.shakeIconUrl = str;
        this.shakeAccelerateFactory = adShakeAccelerateFactor;
    }
}
