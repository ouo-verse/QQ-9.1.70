package e10;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes38.dex */
public class e {
    private static com.tencent.biz.pubaccount.weishi.recommend.d a(String str) {
        return new d(str);
    }

    public static com.tencent.biz.pubaccount.weishi.recommend.d b(String str) {
        if (TextUtils.isEmpty(str)) {
            return a(str);
        }
        if (TextUtils.equals(str, "1000")) {
            return a(str);
        }
        return new b(str);
    }
}
