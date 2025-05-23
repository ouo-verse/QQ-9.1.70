package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ItemForSetting implements IKernelModel {
    public ArrayList<Integer> keyCodec;
    public PlatformTypeForSetting platformType;

    public ItemForSetting() {
        this.platformType = PlatformTypeForSetting.values()[0];
        this.keyCodec = new ArrayList<>();
    }

    public ArrayList<Integer> getKeyCodec() {
        return this.keyCodec;
    }

    public PlatformTypeForSetting getPlatformType() {
        return this.platformType;
    }

    public void setKeyCodec(ArrayList<Integer> arrayList) {
        this.keyCodec = arrayList;
    }

    public void setPlatformType(PlatformTypeForSetting platformTypeForSetting) {
        this.platformType = platformTypeForSetting;
    }

    public ItemForSetting(PlatformTypeForSetting platformTypeForSetting, ArrayList<Integer> arrayList) {
        this.platformType = PlatformTypeForSetting.values()[0];
        new ArrayList();
        this.platformType = platformTypeForSetting;
        this.keyCodec = arrayList;
    }
}
