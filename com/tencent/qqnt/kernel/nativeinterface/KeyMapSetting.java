package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class KeyMapSetting implements IKernelModel {
    public KeyTypeForSetting keyType;
    public ArrayList<ItemForSetting> settings;

    public KeyMapSetting() {
        this.keyType = KeyTypeForSetting.values()[0];
        this.settings = new ArrayList<>();
    }

    public KeyTypeForSetting getKeyType() {
        return this.keyType;
    }

    public ArrayList<ItemForSetting> getSettings() {
        return this.settings;
    }

    public void setKeyType(KeyTypeForSetting keyTypeForSetting) {
        this.keyType = keyTypeForSetting;
    }

    public void setSettings(ArrayList<ItemForSetting> arrayList) {
        this.settings = arrayList;
    }

    public KeyMapSetting(KeyTypeForSetting keyTypeForSetting, ArrayList<ItemForSetting> arrayList) {
        this.keyType = KeyTypeForSetting.values()[0];
        new ArrayList();
        this.keyType = keyTypeForSetting;
        this.settings = arrayList;
    }
}
