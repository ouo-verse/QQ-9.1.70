package com.tencent.mobileqq.richmediabrowser;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.image.JpegExifReader;
import com.tencent.image.Utils;

/* compiled from: P */
/* loaded from: classes18.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public static final Drawable f281830a = new ColorDrawable(0);

    public static int a(String str) {
        if (com.tencent.mobileqq.activity.photo.incompatiblephoto.b.a(str)) {
            int heifOrientation = Utils.getHeifOrientation(str);
            if (heifOrientation != 3) {
                if (heifOrientation != 6) {
                    if (heifOrientation != 8) {
                        return 0;
                    }
                    return 270;
                }
                return 90;
            }
            return 180;
        }
        return JpegExifReader.getRotationDegree(str);
    }
}
