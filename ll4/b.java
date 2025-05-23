package ll4;

import trpc.yes.common.CommonOuterClass$QQUserId;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {
    public static boolean a(CommonOuterClass$QQUserId commonOuterClass$QQUserId, CommonOuterClass$QQUserId commonOuterClass$QQUserId2) {
        if (commonOuterClass$QQUserId == null && commonOuterClass$QQUserId2 == null) {
            return true;
        }
        if (commonOuterClass$QQUserId != null && commonOuterClass$QQUserId2 != null) {
            if (commonOuterClass$QQUserId.yes_uid.get() != 0 && commonOuterClass$QQUserId.yes_uid.get() == commonOuterClass$QQUserId2.yes_uid.get()) {
                return true;
            }
            if (commonOuterClass$QQUserId.uid.get() > 0 && commonOuterClass$QQUserId.uid.get() == commonOuterClass$QQUserId2.uid.get()) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean b(CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
        if (commonOuterClass$QQUserId == null) {
            return true;
        }
        if (commonOuterClass$QQUserId.uid.get() == 0 && commonOuterClass$QQUserId.yes_uid.get() == 0) {
            return true;
        }
        return false;
    }
}
