package com.tencent.mobileqq.util;

import android.graphics.drawable.Drawable;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class cz {
    public static Drawable a(String str, int i3, FaceDrawable.OnLoadingStateChangeListener onLoadingStateChangeListener) {
        return FaceDrawable.getFaceDrawable((AppInterface) MobileQQ.getMobileQQ().waitAppRuntime(null), i3, 4, str, onLoadingStateChangeListener);
    }

    public static Drawable b(String str) {
        return c(str, null);
    }

    public static Drawable c(String str, FaceDrawable.OnLoadingStateChangeListener onLoadingStateChangeListener) {
        String str2 = "";
        int i3 = 1;
        for (String str3 : str.split(ContainerUtils.FIELD_DELIMITER)) {
            String[] split = str3.split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (split.length == 2) {
                if (split[0].equals("type")) {
                    i3 = Integer.parseInt(split[1]);
                } else if (split[0].equals("uin")) {
                    str2 = split[1];
                }
            } else {
                throw new IllegalArgumentException("query string illegal");
            }
        }
        Drawable a16 = a(str2, i3, onLoadingStateChangeListener);
        if (a16 != null) {
            return a16;
        }
        throw new IllegalStateException("Drawable is null.");
    }
}
