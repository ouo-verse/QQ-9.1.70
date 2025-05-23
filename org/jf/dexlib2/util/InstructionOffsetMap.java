package org.jf.dexlib2.util;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Nonnull;
import org.jf.dexlib2.iface.instruction.Instruction;
import org.jf.util.ExceptionWithContext;

/* compiled from: P */
/* loaded from: classes29.dex */
public class InstructionOffsetMap {

    @Nonnull
    private final int[] instructionCodeOffsets;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class InvalidInstructionIndex extends ExceptionWithContext {
        private final int instructionIndex;

        public InvalidInstructionIndex(int i3) {
            super("Instruction index out of bounds: %d", Integer.valueOf(i3));
            this.instructionIndex = i3;
        }

        public int getInstructionIndex() {
            return this.instructionIndex;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class InvalidInstructionOffset extends ExceptionWithContext {
        private final int instructionOffset;

        public InvalidInstructionOffset(int i3) {
            super("No instruction at offset %d", Integer.valueOf(i3));
            this.instructionOffset = i3;
        }

        public int getInstructionOffset() {
            return this.instructionOffset;
        }
    }

    public InstructionOffsetMap(@Nonnull List<? extends Instruction> list) {
        this.instructionCodeOffsets = new int[list.size()];
        int i3 = 0;
        for (int i16 = 0; i16 < list.size(); i16++) {
            this.instructionCodeOffsets[i16] = i3;
            i3 += list.get(i16).getCodeUnits();
        }
    }

    public int getInstructionCodeOffset(int i3) {
        if (i3 >= 0) {
            int[] iArr = this.instructionCodeOffsets;
            if (i3 < iArr.length) {
                return iArr[i3];
            }
        }
        throw new InvalidInstructionIndex(i3);
    }

    public int getInstructionIndexAtCodeOffset(int i3) {
        return getInstructionIndexAtCodeOffset(i3, true);
    }

    public int getInstructionIndexAtCodeOffset(int i3, boolean z16) {
        int binarySearch = Arrays.binarySearch(this.instructionCodeOffsets, i3);
        if (binarySearch >= 0) {
            return binarySearch;
        }
        if (z16) {
            throw new InvalidInstructionOffset(i3);
        }
        return (~binarySearch) - 1;
    }
}
