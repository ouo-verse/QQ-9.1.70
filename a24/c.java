package a24;

import com.tencent.qqnt.kernel.nativeinterface.RobotActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"La24/a;", "", "a", "robot-business-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c {
    /* JADX WARN: Removed duplicated region for block: B:11:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean a(@NotNull a aVar) {
        boolean z16;
        boolean z17;
        String str;
        boolean z18;
        String str2;
        boolean z19;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        RobotActivity robotActivity = aVar.getRobotActivity();
        if (robotActivity != null && (str2 = robotActivity.cover) != null) {
            if (str2.length() > 0) {
                z19 = true;
            } else {
                z19 = false;
            }
            if (z19) {
                z16 = true;
                if (z16) {
                    RobotActivity robotActivity2 = aVar.getRobotActivity();
                    if (robotActivity2 != null && (str = robotActivity2.jumpUrl) != null) {
                        if (str.length() > 0) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (z18) {
                            z17 = true;
                            if (z17) {
                                return true;
                            }
                        }
                    }
                    z17 = false;
                    if (z17) {
                    }
                }
                return false;
            }
        }
        z16 = false;
        if (z16) {
        }
        return false;
    }
}
