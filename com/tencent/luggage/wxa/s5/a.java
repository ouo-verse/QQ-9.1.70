package com.tencent.luggage.wxa.s5;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.luggage.wxa.p3.g;
import com.tencent.luggage.wxa.t9.l;
import com.tencent.luggage.wxa.tn.w;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {
    public static String a() {
        String a16;
        if (b()) {
            a16 = "";
        } else {
            a16 = l.a(false);
        }
        boolean isEmpty = TextUtils.isEmpty(a16);
        String str = ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
        if (!isEmpty) {
            String substring = (ExifInterface.GPS_MEASUREMENT_IN_PROGRESS + a16 + "123456789ABCDEF").substring(0, 15);
            w.d("Luggage.DeviceId", "generateDeviceId by IMEI return %s", substring);
            return substring;
        }
        if (!b()) {
            String b16 = l.b();
            if (!TextUtils.isEmpty(b16)) {
                w.d("Luggage.DeviceId", "generateDeviceId by AndroidId return %s", b16);
                return b16;
            }
        }
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        for (int i3 = 0; i3 < 15; i3++) {
            str = str + ((char) (random.nextInt(25) + 65));
        }
        w.d("Luggage.DeviceId", "generateDeviceId by random return %s", str);
        return str;
    }

    public static boolean b() {
        if (g.a() != 1) {
            return true;
        }
        return false;
    }
}
