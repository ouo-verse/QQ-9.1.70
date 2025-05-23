package org.jf.dexlib2.dexbacked.instruction;

import com.google.common.collect.ImmutableList;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.util.List;
import javax.annotation.Nonnull;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.dexbacked.util.FixedSizeList;
import org.jf.dexlib2.iface.instruction.formats.ArrayPayload;
import org.jf.util.ExceptionWithContext;

/* loaded from: classes29.dex */
public class DexBackedArrayPayload extends DexBackedInstruction implements ArrayPayload {
    private static final int ELEMENTS_OFFSET = 8;
    private static final int ELEMENT_COUNT_OFFSET = 4;
    private static final int ELEMENT_WIDTH_OFFSET = 2;
    public static final Opcode OPCODE = Opcode.ARRAY_PAYLOAD;
    public final int elementCount;
    public final int elementWidth;

    /* renamed from: org.jf.dexlib2.dexbacked.instruction.DexBackedArrayPayload$1ReturnedList, reason: invalid class name */
    /* loaded from: classes29.dex */
    abstract class C1ReturnedList extends FixedSizeList<Number> {
        C1ReturnedList() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return DexBackedArrayPayload.this.elementCount;
        }
    }

    public DexBackedArrayPayload(@Nonnull DexBackedDexFile dexBackedDexFile, int i3) {
        super(dexBackedDexFile, OPCODE, i3);
        int readUshort = dexBackedDexFile.getDataBuffer().readUshort(i3 + 2);
        if (readUshort == 0) {
            this.elementWidth = 1;
            this.elementCount = 0;
            return;
        }
        this.elementWidth = readUshort;
        int readSmallUint = dexBackedDexFile.getDataBuffer().readSmallUint(i3 + 4);
        this.elementCount = readSmallUint;
        if (readUshort * readSmallUint <= TTL.MAX_VALUE) {
        } else {
            throw new ExceptionWithContext("Invalid array-payload instruction: element width*count overflows", new Object[0]);
        }
    }

    @Override // org.jf.dexlib2.iface.instruction.formats.ArrayPayload
    @Nonnull
    public List<Number> getArrayElements() {
        final int i3 = this.instructionStart + 8;
        if (this.elementCount == 0) {
            return ImmutableList.of();
        }
        int i16 = this.elementWidth;
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 != 4) {
                    if (i16 == 8) {
                        return new C1ReturnedList() { // from class: org.jf.dexlib2.dexbacked.instruction.DexBackedArrayPayload.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super();
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // org.jf.dexlib2.dexbacked.util.FixedSizeList
                            @Nonnull
                            public Number readItem(int i17) {
                                return Long.valueOf(DexBackedArrayPayload.this.dexFile.getDataBuffer().readLong(i3 + (i17 * 8)));
                            }
                        };
                    }
                    throw new ExceptionWithContext("Invalid element width: %d", Integer.valueOf(this.elementWidth));
                }
                return new C1ReturnedList() { // from class: org.jf.dexlib2.dexbacked.instruction.DexBackedArrayPayload.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super();
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // org.jf.dexlib2.dexbacked.util.FixedSizeList
                    @Nonnull
                    public Number readItem(int i17) {
                        return Integer.valueOf(DexBackedArrayPayload.this.dexFile.getDataBuffer().readInt(i3 + (i17 * 4)));
                    }
                };
            }
            return new C1ReturnedList() { // from class: org.jf.dexlib2.dexbacked.instruction.DexBackedArrayPayload.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // org.jf.dexlib2.dexbacked.util.FixedSizeList
                @Nonnull
                public Number readItem(int i17) {
                    return Integer.valueOf(DexBackedArrayPayload.this.dexFile.getDataBuffer().readShort(i3 + (i17 * 2)));
                }
            };
        }
        return new C1ReturnedList() { // from class: org.jf.dexlib2.dexbacked.instruction.DexBackedArrayPayload.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // org.jf.dexlib2.dexbacked.util.FixedSizeList
            @Nonnull
            public Number readItem(int i17) {
                return Integer.valueOf(DexBackedArrayPayload.this.dexFile.getDataBuffer().readByte(i3 + i17));
            }
        };
    }

    @Override // org.jf.dexlib2.dexbacked.instruction.DexBackedInstruction, org.jf.dexlib2.iface.instruction.Instruction
    public int getCodeUnits() {
        return (((this.elementWidth * this.elementCount) + 1) / 2) + 4;
    }

    @Override // org.jf.dexlib2.iface.instruction.formats.ArrayPayload
    public int getElementWidth() {
        return this.elementWidth;
    }
}
