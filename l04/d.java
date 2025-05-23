package l04;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.tencent.bugly.common.utils.AndroidVersion;

/* compiled from: P */
/* loaded from: classes25.dex */
public class d {
    public static int a(@NonNull Bitmap bitmap) {
        if (AndroidVersion.isOverKitKat()) {
            return bitmap.getAllocationByteCount();
        }
        return bitmap.getByteCount();
    }
}
