package cf;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a extends b {
    public a(int i3) {
        this.f30765a = i3;
    }

    public a(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f30766b.put(str, Integer.valueOf(i3));
    }
}
