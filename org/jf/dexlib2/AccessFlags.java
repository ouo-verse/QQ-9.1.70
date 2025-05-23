package org.jf.dexlib2;

import com.tencent.raft.codegenmeta.utils.Constants;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes29.dex */
public enum AccessFlags {
    PUBLIC(1, "public", true, true, true),
    PRIVATE(2, "private", true, true, true),
    PROTECTED(4, "protected", true, true, true),
    STATIC(8, "static", true, true, true),
    FINAL(16, "final", true, true, true),
    SYNCHRONIZED(32, "synchronized", false, true, false),
    VOLATILE(64, "volatile", false, false, true),
    BRIDGE(64, "bridge", false, true, false),
    TRANSIENT(128, "transient", false, false, true),
    VARARGS(128, "varargs", false, true, false),
    NATIVE(256, "native", false, true, false),
    INTERFACE(512, Constants.Service.INTERFACE, true, false, false),
    ABSTRACT(1024, "abstract", true, true, false),
    STRICTFP(2048, "strictfp", false, true, false),
    SYNTHETIC(4096, "synthetic", true, true, true),
    ANNOTATION(8192, "annotation", true, false, false),
    ENUM(16384, "enum", true, false, true),
    CONSTRUCTOR(65536, "constructor", false, true, false),
    DECLARED_SYNCHRONIZED(131072, "declared-synchronized", false, true, false);

    private static HashMap<String, AccessFlags> accessFlagsByName;
    private static final AccessFlags[] allFlags;
    private String accessFlagName;
    private boolean validForClass;
    private boolean validForField;
    private boolean validForMethod;
    private int value;

    static {
        AccessFlags[] values = values();
        allFlags = values;
        accessFlagsByName = new HashMap<>();
        for (AccessFlags accessFlags : values) {
            accessFlagsByName.put(accessFlags.accessFlagName, accessFlags);
        }
    }

    AccessFlags(int i3, String str, boolean z16, boolean z17, boolean z18) {
        this.value = i3;
        this.accessFlagName = str;
        this.validForClass = z16;
        this.validForMethod = z17;
        this.validForField = z18;
    }

    private static String formatAccessFlags(AccessFlags[] accessFlagsArr) {
        int i3 = 0;
        for (AccessFlags accessFlags : accessFlagsArr) {
            i3 += accessFlags.toString().length() + 1;
        }
        StringBuilder sb5 = new StringBuilder(i3);
        for (AccessFlags accessFlags2 : accessFlagsArr) {
            sb5.append(accessFlags2.toString());
            sb5.append(" ");
        }
        if (accessFlagsArr.length > 0) {
            sb5.delete(sb5.length() - 1, sb5.length());
        }
        return sb5.toString();
    }

    public static String formatAccessFlagsForClass(int i3) {
        return formatAccessFlags(getAccessFlagsForClass(i3));
    }

    public static String formatAccessFlagsForField(int i3) {
        return formatAccessFlags(getAccessFlagsForField(i3));
    }

    public static String formatAccessFlagsForMethod(int i3) {
        return formatAccessFlags(getAccessFlagsForMethod(i3));
    }

    public static AccessFlags getAccessFlag(String str) {
        return accessFlagsByName.get(str);
    }

    public static AccessFlags[] getAccessFlagsForClass(int i3) {
        int i16 = 0;
        for (AccessFlags accessFlags : allFlags) {
            if (accessFlags.validForClass && (accessFlags.value & i3) != 0) {
                i16++;
            }
        }
        AccessFlags[] accessFlagsArr = new AccessFlags[i16];
        int i17 = 0;
        for (AccessFlags accessFlags2 : allFlags) {
            if (accessFlags2.validForClass && (accessFlags2.value & i3) != 0) {
                accessFlagsArr[i17] = accessFlags2;
                i17++;
            }
        }
        return accessFlagsArr;
    }

    public static AccessFlags[] getAccessFlagsForField(int i3) {
        int i16 = 0;
        for (AccessFlags accessFlags : allFlags) {
            if (accessFlags.validForField && (accessFlags.value & i3) != 0) {
                i16++;
            }
        }
        AccessFlags[] accessFlagsArr = new AccessFlags[i16];
        int i17 = 0;
        for (AccessFlags accessFlags2 : allFlags) {
            if (accessFlags2.validForField && (accessFlags2.value & i3) != 0) {
                accessFlagsArr[i17] = accessFlags2;
                i17++;
            }
        }
        return accessFlagsArr;
    }

    public static AccessFlags[] getAccessFlagsForMethod(int i3) {
        int i16 = 0;
        for (AccessFlags accessFlags : allFlags) {
            if (accessFlags.validForMethod && (accessFlags.value & i3) != 0) {
                i16++;
            }
        }
        AccessFlags[] accessFlagsArr = new AccessFlags[i16];
        int i17 = 0;
        for (AccessFlags accessFlags2 : allFlags) {
            if (accessFlags2.validForMethod && (accessFlags2.value & i3) != 0) {
                accessFlagsArr[i17] = accessFlags2;
                i17++;
            }
        }
        return accessFlagsArr;
    }

    public int getValue() {
        return this.value;
    }

    public boolean isSet(int i3) {
        if ((i3 & this.value) != 0) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.accessFlagName;
    }
}
