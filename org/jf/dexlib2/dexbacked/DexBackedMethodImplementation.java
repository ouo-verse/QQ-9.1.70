package org.jf.dexlib2.dexbacked;

import com.google.common.collect.ImmutableList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.dexbacked.instruction.DexBackedInstruction;
import org.jf.dexlib2.dexbacked.util.DebugInfo;
import org.jf.dexlib2.dexbacked.util.FixedSizeList;
import org.jf.dexlib2.dexbacked.util.VariableSizeListIterator;
import org.jf.dexlib2.dexbacked.util.VariableSizeLookaheadIterator;
import org.jf.dexlib2.iface.MethodImplementation;
import org.jf.dexlib2.iface.debug.DebugItem;
import org.jf.dexlib2.iface.instruction.Instruction;
import org.jf.dexlib2.util.AlignmentUtils;
import org.jf.util.ExceptionWithContext;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DexBackedMethodImplementation implements MethodImplementation {
    protected final int codeOffset;

    @Nonnull
    public final DexBackedDexFile dexFile;

    @Nonnull
    public final DexBackedMethod method;

    /* JADX INFO: Access modifiers changed from: protected */
    public DexBackedMethodImplementation(@Nonnull DexBackedDexFile dexBackedDexFile, @Nonnull DexBackedMethod dexBackedMethod, int i3) {
        this.dexFile = dexBackedDexFile;
        this.method = dexBackedMethod;
        this.codeOffset = i3;
    }

    @Nonnull
    private DebugInfo getDebugInfo() {
        int debugOffset = getDebugOffset();
        if (debugOffset != -1 && debugOffset != 0) {
            if (debugOffset < 0) {
                System.err.println(String.format("%s: Invalid debug offset", this.method));
                return DebugInfo.newOrEmpty(this.dexFile, 0, this);
            }
            if (this.dexFile.getBaseDataOffset() + debugOffset >= this.dexFile.getBuffer().buf.length) {
                System.err.println(String.format("%s: Invalid debug offset", this.method));
                return DebugInfo.newOrEmpty(this.dexFile, 0, this);
            }
            return DebugInfo.newOrEmpty(this.dexFile, debugOffset, this);
        }
        return DebugInfo.newOrEmpty(this.dexFile, 0, this);
    }

    @Override // org.jf.dexlib2.iface.MethodImplementation
    @Nonnull
    public Iterable<? extends DebugItem> getDebugItems() {
        return getDebugInfo();
    }

    protected int getDebugOffset() {
        return this.dexFile.getDataBuffer().readInt(this.codeOffset + 8);
    }

    @Override // org.jf.dexlib2.iface.MethodImplementation
    @Nonnull
    public Iterable<? extends Instruction> getInstructions() {
        int instructionsSize = getInstructionsSize();
        final int instructionsStartOffset = getInstructionsStartOffset();
        final int i3 = (instructionsSize * 2) + instructionsStartOffset;
        return new Iterable<Instruction>() { // from class: org.jf.dexlib2.dexbacked.DexBackedMethodImplementation.1
            @Override // java.lang.Iterable
            public Iterator<Instruction> iterator() {
                return new VariableSizeLookaheadIterator<Instruction>(DexBackedMethodImplementation.this.dexFile.getDataBuffer(), instructionsStartOffset) { // from class: org.jf.dexlib2.dexbacked.DexBackedMethodImplementation.1.1
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // org.jf.dexlib2.dexbacked.util.VariableSizeLookaheadIterator
                    public Instruction readNextItem(@Nonnull DexReader dexReader) {
                        int offset = dexReader.getOffset();
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        if (offset >= i3) {
                            return endOfData();
                        }
                        Instruction readFrom = DexBackedInstruction.readFrom(DexBackedMethodImplementation.this.dexFile, dexReader);
                        int offset2 = dexReader.getOffset();
                        if (offset2 > i3 || offset2 < 0) {
                            throw new ExceptionWithContext("The last instruction in method %s is truncated", DexBackedMethodImplementation.this.method);
                        }
                        return readFrom;
                    }
                };
            }
        };
    }

    protected int getInstructionsSize() {
        return this.dexFile.getDataBuffer().readSmallUint(this.codeOffset + 12);
    }

    protected int getInstructionsStartOffset() {
        return this.codeOffset + 16;
    }

    @Nonnull
    public Iterator<String> getParameterNames(@Nullable DexReader dexReader) {
        return getDebugInfo().getParameterNames(dexReader);
    }

    @Override // org.jf.dexlib2.iface.MethodImplementation
    public int getRegisterCount() {
        return this.dexFile.getDataBuffer().readUshort(this.codeOffset);
    }

    public int getSize() {
        int size = getDebugInfo().getSize();
        int instructionsStartOffset = getInstructionsStartOffset() + (getInstructionsSize() * 2);
        Iterator<? extends DexBackedTryBlock> it = getTryBlocks().iterator();
        while (it.hasNext()) {
            Iterator<? extends DexBackedExceptionHandler> it5 = it.next().getExceptionHandlers().iterator();
            while (it5.hasNext()) {
                it5.next();
            }
            instructionsStartOffset = ((VariableSizeListIterator) it5).getReaderOffset();
        }
        return size + (instructionsStartOffset - this.codeOffset);
    }

    protected int getTriesSize() {
        return this.dexFile.getDataBuffer().readUshort(this.codeOffset + 6);
    }

    @Override // org.jf.dexlib2.iface.MethodImplementation
    @Nonnull
    public List<? extends DexBackedTryBlock> getTryBlocks() {
        final int triesSize = getTriesSize();
        if (triesSize > 0) {
            final int alignOffset = AlignmentUtils.alignOffset(getInstructionsStartOffset() + (getInstructionsSize() * 2), 4);
            final int i3 = (triesSize * 8) + alignOffset;
            return new FixedSizeList<DexBackedTryBlock>() { // from class: org.jf.dexlib2.dexbacked.DexBackedMethodImplementation.2
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return triesSize;
                }

                @Override // org.jf.dexlib2.dexbacked.util.FixedSizeList
                @Nonnull
                public DexBackedTryBlock readItem(int i16) {
                    return new DexBackedTryBlock(DexBackedMethodImplementation.this.dexFile, alignOffset + (i16 * 8), i3);
                }
            };
        }
        return ImmutableList.of();
    }
}
