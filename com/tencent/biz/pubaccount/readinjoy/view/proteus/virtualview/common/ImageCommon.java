package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ImageCommon {
    public static final int SCALE_TYPE_CENTER_CROP = 2;
    public static final int SCALE_TYPE_FIT_XY = 1;
    private static HashMap<String, Integer> sImageResourceNameMap = new HashMap<>();

    public static Integer getDrawableResourceId(String str) {
        return sImageResourceNameMap.get(str);
    }

    public static void registerDrawable(String str, int i3) {
        sImageResourceNameMap.put(str, Integer.valueOf(i3));
    }

    public static void registerResource(String str, int i3) {
        registerDrawable(str, i3);
    }
}
