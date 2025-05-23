package com.qq.e.comm.plugin.k;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.qq.e.comm.util.GDTLogger;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes3.dex */
public class bc {

    /* renamed from: a, reason: collision with root package name */
    private static int f39656a = -1;

    public static boolean a() {
        if (f39656a == -1) {
            try {
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(new byte[]{82, 73, 70, 70, 26, 0, 0, 0, 87, 69, 66, 80, 86, 80, 56, 76, 13, 0, 0, 0, 47, 0, 0, 0, RegisterType.UNINIT_REF, 7, RegisterType.UNINIT_REF, 17, 17, -120, -120, -2, 7, 0}, 0, 34);
                if (decodeByteArray != null) {
                    f39656a = 1;
                    decodeByteArray.recycle();
                } else {
                    f39656a = 0;
                }
            } catch (Exception e16) {
                f39656a = 0;
                e16.printStackTrace();
            }
        }
        GDTLogger.i("isWebPSupported : " + f39656a);
        if (f39656a == 1) {
            return true;
        }
        return false;
    }
}
