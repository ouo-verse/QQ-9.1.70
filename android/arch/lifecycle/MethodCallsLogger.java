package android.arch.lifecycle;

import android.support.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class MethodCallsLogger {
    private Map<String, Integer> mCalledMethods = new HashMap();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean approveCall(String str, int i3) {
        int i16;
        Integer num = this.mCalledMethods.get(str);
        boolean z16 = false;
        if (num != null) {
            i16 = num.intValue();
        } else {
            i16 = 0;
        }
        if ((i16 & i3) != 0) {
            z16 = true;
        }
        this.mCalledMethods.put(str, Integer.valueOf(i3 | i16));
        return !z16;
    }
}
