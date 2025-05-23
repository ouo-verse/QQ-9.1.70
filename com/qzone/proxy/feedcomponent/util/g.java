package com.qzone.proxy.feedcomponent.util;

import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.PictureUrl;

/* compiled from: P */
/* loaded from: classes39.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static float f50901a = 1.78f;

    public static int a(float f16) {
        return Math.round(f16 * FeedGlobalEnv.g().getDensity());
    }

    public static int b(int i3) {
        if (i3 != 255) {
            return (int) (255.0d - ((255 - i3) * 0.5d));
        }
        return i3;
    }

    public static boolean c(int i3, int i16) {
        return ((float) i3) * f50901a < ((float) i16);
    }

    public static boolean d(PictureUrl pictureUrl) {
        return pictureUrl == null || TextUtils.isEmpty(pictureUrl.url);
    }
}
