package com.tencent.tencentmap.mapsdk.maps.model;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes26.dex */
public class AoiLayerOptions {
    private int mMinLevel = -1;
    private int mMaxLevel = -1;

    public int getMaxLevel() {
        return this.mMaxLevel;
    }

    public int getMinLevel() {
        return this.mMinLevel;
    }

    public AoiLayerOptions setDisplayLevel(int i3, int i16) {
        if (i3 >= 0 && i16 >= 0 && i3 <= i16) {
            if (i3 < 3) {
                i3 = 3;
            }
            if (i16 > 20) {
                i16 = 20;
            }
            this.mMinLevel = i3;
            this.mMaxLevel = i16;
            return this;
        }
        Log.w("TencentMapSDK", "\u8bbe\u7f6eAoiLayer\u7684\u663e\u793a\u7ea7\u522b\u5931\u6548\uff0c\u6700\u5c0f\u7ea7\u522b\u8981\u5c0f\u4e8e\u7b49\u4e8e\u6700\u5927\u7ea7\u522b\uff0c\u5e76\u4e14\u5728[3,20]\u6570\u503c\u4e4b\u95f4\u3002");
        return this;
    }
}
