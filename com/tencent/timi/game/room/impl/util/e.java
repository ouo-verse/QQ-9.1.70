package com.tencent.timi.game.room.impl.util;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.timi.game.utils.l;
import trpc.yes.common.SafeOuterClass$SafeCheckResult;

/* compiled from: P */
/* loaded from: classes26.dex */
public class e {
    public static boolean a(Activity activity, SafeOuterClass$SafeCheckResult safeOuterClass$SafeCheckResult) {
        if (safeOuterClass$SafeCheckResult == null) {
            l.i("SafeChecker", "safeCheckResult is null");
            return false;
        }
        if (!safeOuterClass$SafeCheckResult.has()) {
            l.i("SafeChecker", "safeCheckResult is empty");
            return false;
        }
        if (safeOuterClass$SafeCheckResult.code.get() == 0) {
            l.i("SafeChecker", "safeCheckResult code == 0, this account is safe");
            return false;
        }
        String str = safeOuterClass$SafeCheckResult.check_msg.get();
        if (!TextUtils.isEmpty(str)) {
            com.tencent.timi.game.ui.widget.f.d(true, str);
            l.i("SafeChecker", "show safe msg : " + str);
        }
        String str2 = safeOuterClass$SafeCheckResult.verify_url.get();
        if (!TextUtils.isEmpty(str2)) {
            ((lo4.a) mm4.b.b(lo4.a.class)).y1(activity, str2);
            l.i("SafeChecker", "show safe url : " + str2);
        }
        return true;
    }
}
