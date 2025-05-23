package org.jf.dexlib2.util;

import org.jf.dexlib2.Opcode;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class InstructionUtil {
    InstructionUtil() {
    }

    public static boolean isInvokePolymorphic(Opcode opcode) {
        if (opcode != Opcode.INVOKE_POLYMORPHIC && opcode != Opcode.INVOKE_POLYMORPHIC_RANGE) {
            return false;
        }
        return true;
    }

    public static boolean isInvokeStatic(Opcode opcode) {
        if (opcode != Opcode.INVOKE_STATIC && opcode != Opcode.INVOKE_STATIC_RANGE) {
            return false;
        }
        return true;
    }
}
