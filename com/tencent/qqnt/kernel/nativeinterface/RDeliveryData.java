package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RDeliveryData {
    public String key;
    public int switchState;
    public String value;
    public int valueType;

    public RDeliveryData() {
        this.key = "";
        this.value = "";
    }

    public String getKey() {
        return this.key;
    }

    public int getSwitchState() {
        return this.switchState;
    }

    public String getValue() {
        return this.value;
    }

    public int getValueType() {
        return this.valueType;
    }

    public String toString() {
        return "RDeliveryData{key=" + this.key + ",valueType=" + this.valueType + ",value=" + this.value + ",switchState=" + this.switchState + ",}";
    }

    public RDeliveryData(String str, int i3, String str2, int i16) {
        this.key = str;
        this.valueType = i3;
        this.value = str2;
        this.switchState = i16;
    }
}
