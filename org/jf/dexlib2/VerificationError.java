package org.jf.dexlib2;

import com.google.common.collect.Maps;
import java.util.HashMap;
import javax.annotation.Nullable;
import org.jf.util.ExceptionWithContext;

/* compiled from: P */
/* loaded from: classes29.dex */
public class VerificationError {
    public static final int CLASS_CHANGE_ERROR = 8;
    public static final int GENERIC = 1;
    public static final int ILLEGAL_CLASS_ACCESS = 5;
    public static final int ILLEGAL_FIELD_ACCESS = 6;
    public static final int ILLEGAL_METHOD_ACCESS = 7;
    public static final int INSTANTIATION_ERROR = 9;
    public static final int NO_SUCH_CLASS = 2;
    public static final int NO_SUCH_FIELD = 3;
    public static final int NO_SUCH_METHOD = 4;
    private static final HashMap<String, Integer> verificationErrorNames;

    static {
        HashMap<String, Integer> j3 = Maps.j();
        verificationErrorNames = j3;
        j3.put("generic-error", 1);
        j3.put("no-such-class", 2);
        j3.put("no-such-field", 3);
        j3.put("no-such-method", 4);
        j3.put("illegal-class-access", 5);
        j3.put("illegal-field-access", 6);
        j3.put("illegal-method-access", 7);
        j3.put("class-change-error", 8);
        j3.put("instantiation-error", 9);
    }

    public static int getVerificationError(String str) {
        Integer num = verificationErrorNames.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new ExceptionWithContext("Invalid verification error: %s", str);
    }

    @Nullable
    public static String getVerificationErrorName(int i3) {
        switch (i3) {
            case 1:
                return "generic-error";
            case 2:
                return "no-such-class";
            case 3:
                return "no-such-field";
            case 4:
                return "no-such-method";
            case 5:
                return "illegal-class-access";
            case 6:
                return "illegal-field-access";
            case 7:
                return "illegal-method-access";
            case 8:
                return "class-change-error";
            case 9:
                return "instantiation-error";
            default:
                return null;
        }
    }

    public static boolean isValidVerificationError(int i3) {
        if (i3 > 0 && i3 < 10) {
            return true;
        }
        return false;
    }
}
