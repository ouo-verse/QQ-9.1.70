package com.tencent.ttpic.params;

/* compiled from: P */
/* loaded from: classes27.dex */
public class LightBasicBeauty {
    public static final String BASIC_BASIC_LIPS = "basicLips";
    public static final String BASIC_MULTIPLY = "basicMultiply";
    public static final String BASIC_SOFT_LIGHT = "basicSoftLight";
    private int defValue;
    private String path;
    private int type;

    public LightBasicBeauty(String str, int i3) {
        this.path = str;
        this.defValue = i3;
    }

    public int getDefValue() {
        return this.defValue;
    }

    public String getPath() {
        return this.path;
    }

    public int getType() {
        return this.type;
    }

    public LightBasicBeauty(String str, int i3, int i16) {
        this.path = str;
        this.defValue = i3;
        this.type = i16;
    }
}
