package com.tencent.mobileqq.qui.immersive.color;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes17.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f276887a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50606);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f276887a = new int[5];
        }
    }

    public static int a(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= 3 || height <= 3) {
            return 0;
        }
        int[] iArr = f276887a;
        int i3 = height - 3;
        iArr[2] = bitmap.getPixel(width / 2, i3);
        int pixel = bitmap.getPixel(3, i3);
        iArr[0] = pixel;
        if (pixel == iArr[2]) {
            return pixel;
        }
        int i16 = width - 3;
        int pixel2 = bitmap.getPixel(i16, i3);
        iArr[4] = pixel2;
        int i17 = iArr[0];
        if (i17 == pixel2) {
            return i17;
        }
        int i18 = iArr[2];
        if (pixel2 == i18) {
            return i18;
        }
        int i19 = width / 4;
        iArr[1] = bitmap.getPixel(i16 - i19, i3);
        iArr[3] = bitmap.getPixel(i19 + 3, i3);
        return b(iArr);
    }

    private static int b(@NonNull int[] iArr) {
        HashMap hashMap = new HashMap();
        int i3 = iArr[0];
        int i16 = 0;
        for (int i17 : iArr) {
            Integer num = (Integer) hashMap.get(Integer.valueOf(i17));
            if (num != null) {
                int intValue = num.intValue() + 1;
                hashMap.put(Integer.valueOf(i17), Integer.valueOf(intValue));
                if (intValue > i16) {
                    i3 = i17;
                    i16 = intValue;
                }
            } else {
                hashMap.put(Integer.valueOf(i17), 1);
            }
        }
        return i3;
    }
}
