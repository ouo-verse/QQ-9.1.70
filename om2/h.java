package om2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.rlottie.AXrLottieDrawable;
import com.tencent.rlottie.a;
import java.io.File;

/* compiled from: P */
/* loaded from: classes18.dex */
public class h {
    public static c a(String str) {
        return b.c(str);
    }

    public static g b(Context context, String str, int i3, int i16) {
        AXrLottieDrawable a16 = a.C9743a.a(context, new File(str), i3, i16, true, true);
        if (a16 == null) {
            return null;
        }
        a16.c(true);
        return new f(a16);
    }

    public static g c(String str) {
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        if (decodeFile == null) {
            return null;
        }
        return new i(decodeFile);
    }
}
