package com.tencent.ditto.utils;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.ditto.content.res.DittoResources;
import com.tencent.ditto.shell.DittoUIEngine;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DittoResourcesUtil {
    public static final String COLOR_ID_PREFIX = "@color/";
    public static final String CUSTOM_COLOR_ID_PREFIX = "@customColor/";
    public static final int CUSTOM_COLOR_ID_PREFIX_LENGTH = 13;
    public static final String TAG = "DittoResourcesUtil";

    public static int parseColor(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith(COLOR_ID_PREFIX)) {
                DittoResources dittoResources = DittoUIEngine.g().getDittoResources();
                if (dittoResources != null) {
                    return dittoResources.getColor(DittoUIEngine.g().getResourceId(str));
                }
                throw new IllegalStateException("CanvasResources is null");
            }
            if (str.startsWith(CUSTOM_COLOR_ID_PREFIX)) {
                DittoResources dittoResources2 = DittoUIEngine.g().getDittoResources();
                if (dittoResources2 != null) {
                    return dittoResources2.getCustomColor(str.substring(CUSTOM_COLOR_ID_PREFIX_LENGTH));
                }
                throw new IllegalStateException("CanvasResources is null");
            }
            return Color.parseColor(str);
        }
        throw new IllegalArgumentException("Unknown color");
    }
}
