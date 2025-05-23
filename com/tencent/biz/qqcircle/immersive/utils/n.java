package com.tencent.biz.qqcircle.immersive.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.Size;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes4.dex */
public class n {
    public static Size a(Context context, int i3) {
        return b(context, i3, i3);
    }

    public static Size b(Context context, int i3, int i16) {
        if (context == null) {
            QLog.e("QFSAvatarSizeUtils", 1, "[buildAvatarSize] context should not be null.");
            return null;
        }
        try {
            Resources resources = context.getResources();
            return new Size((int) resources.getDimension(i3), (int) resources.getDimension(i16));
        } catch (Throwable th5) {
            QLog.e("QFSAvatarSizeUtils", 1, "[buildAvatarSize] error: ", th5);
            return null;
        }
    }
}
