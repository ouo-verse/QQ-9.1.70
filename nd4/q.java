package nd4;

import android.text.TextUtils;
import android.util.Log;

/* compiled from: P */
/* loaded from: classes26.dex */
final class q implements ld4.a {
    private boolean a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return false;
        }
        return true;
    }

    @Override // ld4.a
    public void i(String str, String str2) {
        if (a(str, str2)) {
            return;
        }
        Log.i(str, str2);
    }
}
