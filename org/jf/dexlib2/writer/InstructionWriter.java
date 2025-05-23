package org.jf.dexlib2.writer;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.Opcodes;
import org.jf.dexlib2.iface.instruction.DualReferenceInstruction;
import org.jf.dexlib2.iface.instruction.ReferenceInstruction;
import org.jf.dexlib2.iface.instruction.SwitchElement;
import org.jf.dexlib2.iface.instruction.formats.ArrayPayload;
import org.jf.dexlib2.iface.instruction.formats.Instruction10t;
import org.jf.dexlib2.iface.instruction.formats.Instruction10x;
import org.jf.dexlib2.iface.instruction.formats.Instruction11n;
import org.jf.dexlib2.iface.instruction.formats.Instruction11x;
import org.jf.dexlib2.iface.instruction.formats.Instruction12x;
import org.jf.dexlib2.iface.instruction.formats.Instruction20bc;
import org.jf.dexlib2.iface.instruction.formats.Instruction20t;
import org.jf.dexlib2.iface.instruction.formats.Instruction21c;
import org.jf.dexlib2.iface.instruction.formats.Instruction21ih;
import org.jf.dexlib2.iface.instruction.formats.Instruction21lh;
import org.jf.dexlib2.iface.instruction.formats.Instruction21s;
import org.jf.dexlib2.iface.instruction.formats.Instruction21t;
import org.jf.dexlib2.iface.instruction.formats.Instruction22b;
import org.jf.dexlib2.iface.instruction.formats.Instruction22c;
import org.jf.dexlib2.iface.instruction.formats.Instruction22cs;
import org.jf.dexlib2.iface.instruction.formats.Instruction22s;
import org.jf.dexlib2.iface.instruction.formats.Instruction22t;
import org.jf.dexlib2.iface.instruction.formats.Instruction22x;
import org.jf.dexlib2.iface.instruction.formats.Instruction23x;
import org.jf.dexlib2.iface.instruction.formats.Instruction30t;
import org.jf.dexlib2.iface.instruction.formats.Instruction31c;
import org.jf.dexlib2.iface.instruction.formats.Instruction31i;
import org.jf.dexlib2.iface.instruction.formats.Instruction31t;
import org.jf.dexlib2.iface.instruction.formats.Instruction32x;
import org.jf.dexlib2.iface.instruction.formats.Instruction35c;
import org.jf.dexlib2.iface.instruction.formats.Instruction35mi;
import org.jf.dexlib2.iface.instruction.formats.Instruction35ms;
import org.jf.dexlib2.iface.instruction.formats.Instruction3rc;
import org.jf.dexlib2.iface.instruction.formats.Instruction3rmi;
import org.jf.dexlib2.iface.instruction.formats.Instruction3rms;
import org.jf.dexlib2.iface.instruction.formats.Instruction45cc;
import org.jf.dexlib2.iface.instruction.formats.Instruction4rcc;
import org.jf.dexlib2.iface.instruction.formats.Instruction51l;
import org.jf.dexlib2.iface.instruction.formats.PackedSwitchPayload;
import org.jf.dexlib2.iface.instruction.formats.SparseSwitchPayload;
import org.jf.dexlib2.iface.reference.CallSiteReference;
import org.jf.dexlib2.iface.reference.FieldReference;
import org.jf.dexlib2.iface.reference.MethodHandleReference;
import org.jf.dexlib2.iface.reference.MethodProtoReference;
import org.jf.dexlib2.iface.reference.MethodReference;
import org.jf.dexlib2.iface.reference.Reference;
import org.jf.dexlib2.iface.reference.StringReference;
import org.jf.dexlib2.iface.reference.TypeReference;
import org.jf.util.ExceptionWithContext;
import s1.c;

/* compiled from: P */
/* loaded from: classes29.dex */
public class InstructionWriter<StringRef extends StringReference, TypeRef extends TypeReference, FieldRefKey extends FieldReference, MethodRefKey extends MethodReference, ProtoRefKey extends MethodProtoReference, MethodHandleKey extends MethodHandleReference, CallSiteKey extends CallSiteReference> {

    @Nonnull
    private final CallSiteSection<CallSiteKey, ?> callSiteSection;

    @Nonnull
    private final FieldSection<?, ?, FieldRefKey, ?> fieldSection;

    @Nonnull
    private final MethodHandleSection<MethodHandleKey, ?, ?> methodHandleSection;

    @Nonnull
    private final MethodSection<?, ?, ?, MethodRefKey, ?> methodSection;

    @Nonnull
    private final Opcodes opcodes;

    @Nonnull
    private final ProtoSection<?, ?, ProtoRefKey, ?> protoSection;

    @Nonnull
    private final StringSection<?, StringRef> stringSection;
    private final Comparator<SwitchElement> switchElementComparator = new Comparator<SwitchElement>() { // from class: org.jf.dexlib2.writer.InstructionWriter.1
        @Override // java.util.Comparator
        public int compare(SwitchElement switchElement, SwitchElement switchElement2) {
            return c.a(switchElement.getKey(), switchElement2.getKey());
        }
    };

    @Nonnull
    private final TypeSection<?, ?, TypeRef> typeSection;

    @Nonnull
    private final DexDataWriter writer;

    InstructionWriter(@Nonnull Opcodes opcodes, @Nonnull DexDataWriter dexDataWriter, @Nonnull StringSection<?, StringRef> stringSection, @Nonnull TypeSection<?, ?, TypeRef> typeSection, @Nonnull FieldSection<?, ?, FieldRefKey, ?> fieldSection, @Nonnull MethodSection<?, ?, ?, MethodRefKey, ?> methodSection, @Nonnull ProtoSection<?, ?, ProtoRefKey, ?> protoSection, @Nonnull MethodHandleSection<MethodHandleKey, ?, ?> methodHandleSection, @Nonnull CallSiteSection<CallSiteKey, ?> callSiteSection) {
        this.opcodes = opcodes;
        this.writer = dexDataWriter;
        this.stringSection = stringSection;
        this.typeSection = typeSection;
        this.fieldSection = fieldSection;
        this.methodSection = methodSection;
        this.protoSection = protoSection;
        this.methodHandleSection = methodHandleSection;
        this.callSiteSection = callSiteSection;
    }

    private short getOpcodeValue(Opcode opcode) {
        Short opcodeValue = this.opcodes.getOpcodeValue(opcode);
        if (opcodeValue != null) {
            return opcodeValue.shortValue();
        }
        throw new ExceptionWithContext("Instruction %s is invalid for api %d", opcode.name, Integer.valueOf(this.opcodes.api));
    }

    private int getReference2Index(DualReferenceInstruction dualReferenceInstruction) {
        return getReferenceIndex(dualReferenceInstruction.getReferenceType2(), dualReferenceInstruction.getReference2());
    }

    private int getReferenceIndex(ReferenceInstruction referenceInstruction) {
        return getReferenceIndex(referenceInstruction.getReferenceType(), referenceInstruction.getReference());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nonnull
    public static <StringRef extends StringReference, TypeRef extends TypeReference, FieldRefKey extends FieldReference, MethodRefKey extends MethodReference, ProtoRefKey extends MethodProtoReference, MethodHandleKey extends MethodHandleReference, CallSiteKey extends CallSiteReference> InstructionWriter<StringRef, TypeRef, FieldRefKey, MethodRefKey, ProtoRefKey, MethodHandleKey, CallSiteKey> makeInstructionWriter(@Nonnull Opcodes opcodes, @Nonnull DexDataWriter dexDataWriter, @Nonnull StringSection<?, StringRef> stringSection, @Nonnull TypeSection<?, ?, TypeRef> typeSection, @Nonnull FieldSection<?, ?, FieldRefKey, ?> fieldSection, @Nonnull MethodSection<?, ?, ?, MethodRefKey, ?> methodSection, @Nonnull ProtoSection<?, ?, ProtoRefKey, ?> protoSection, @Nonnull MethodHandleSection<MethodHandleKey, ?, ?> methodHandleSection, @Nonnull CallSiteSection<CallSiteKey, ?> callSiteSection) {
        return new InstructionWriter<>(opcodes, dexDataWriter, stringSection, typeSection, fieldSection, methodSection, protoSection, methodHandleSection, callSiteSection);
    }

    private static int packNibbles(int i3, int i16) {
        return i3 | (i16 << 4);
    }

    public void write(@Nonnull Instruction10t instruction10t) {
        try {
            this.writer.write(getOpcodeValue(instruction10t.getOpcode()));
            this.writer.write(instruction10t.getCodeOffset());
        } catch (IOException e16) {
            throw new RuntimeException(e16);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int getReferenceIndex(int i3, Reference reference) {
        switch (i3) {
            case 0:
                return this.stringSection.getItemIndex((StringSection<?, StringRef>) reference);
            case 1:
                return this.typeSection.getItemIndex((TypeSection<?, ?, TypeRef>) reference);
            case 2:
                return this.fieldSection.getItemIndex((FieldReference) reference);
            case 3:
                return this.methodSection.getItemIndex((MethodReference) reference);
            case 4:
                return this.protoSection.getItemIndex((MethodProtoReference) reference);
            case 5:
                return this.callSiteSection.getItemIndex((CallSiteReference) reference);
            case 6:
                return this.methodHandleSection.getItemIndex((MethodHandleReference) reference);
            default:
                throw new ExceptionWithContext("Unknown reference type: %d", Integer.valueOf(i3));
        }
    }

    public void write(@Nonnull Instruction10x instruction10x) {
        try {
            this.writer.write(getOpcodeValue(instruction10x.getOpcode()));
            this.writer.write(0);
        } catch (IOException e16) {
            throw new RuntimeException(e16);
        }
    }

    public void write(@Nonnull Instruction11n instruction11n) {
        try {
            this.writer.write(getOpcodeValue(instruction11n.getOpcode()));
            this.writer.write(packNibbles(instruction11n.getRegisterA(), instruction11n.getNarrowLiteral()));
        } catch (IOException e16) {
            throw new RuntimeException(e16);
        }
    }

    public void write(@Nonnull Instruction11x instruction11x) {
        try {
            this.writer.write(getOpcodeValue(instruction11x.getOpcode()));
            this.writer.write(instruction11x.getRegisterA());
        } catch (IOException e16) {
            throw new RuntimeException(e16);
        }
    }

    public void write(@Nonnull Instruction12x instruction12x) {
        try {
            this.writer.write(getOpcodeValue(instruction12x.getOpcode()));
            this.writer.write(packNibbles(instruction12x.getRegisterA(), instruction12x.getRegisterB()));
        } catch (IOException e16) {
            throw new RuntimeException(e16);
        }
    }

    public void write(@Nonnull Instruction20bc instruction20bc) {
        try {
            this.writer.write(getOpcodeValue(instruction20bc.getOpcode()));
            this.writer.write(instruction20bc.getVerificationError());
            this.writer.writeUshort(getReferenceIndex(instruction20bc));
        } catch (IOException e16) {
            throw new RuntimeException(e16);
        }
    }

    public void write(@Nonnull Instruction20t instruction20t) {
        try {
            this.writer.write(getOpcodeValue(instruction20t.getOpcode()));
            this.writer.write(0);
            this.writer.writeShort(instruction20t.getCodeOffset());
        } catch (IOException e16) {
            throw new RuntimeException(e16);
        }
    }

    public void write(@Nonnull Instruction21c instruction21c) {
        try {
            this.writer.write(getOpcodeValue(instruction21c.getOpcode()));
            this.writer.write(instruction21c.getRegisterA());
            this.writer.writeUshort(getReferenceIndex(instruction21c));
        } catch (IOException e16) {
            throw new RuntimeException(e16);
        }
    }

    public void write(@Nonnull Instruction21ih instruction21ih) {
        try {
            this.writer.write(getOpcodeValue(instruction21ih.getOpcode()));
            this.writer.write(instruction21ih.getRegisterA());
            this.writer.writeShort(instruction21ih.getHatLiteral());
        } catch (IOException e16) {
            throw new RuntimeException(e16);
        }
    }

    public void write(@Nonnull Instruction21lh instruction21lh) {
        try {
            this.writer.write(getOpcodeValue(instruction21lh.getOpcode()));
            this.writer.write(instruction21lh.getRegisterA());
            this.writer.writeShort(instruction21lh.getHatLiteral());
        } catch (IOException e16) {
            throw new RuntimeException(e16);
        }
    }

    public void write(@Nonnull Instruction21s instruction21s) {
        try {
            this.writer.write(getOpcodeValue(instruction21s.getOpcode()));
            this.writer.write(instruction21s.getRegisterA());
            this.writer.writeShort(instruction21s.getNarrowLiteral());
        } catch (IOException e16) {
            throw new RuntimeException(e16);
        }
    }

    public void write(@Nonnull Instruction21t instruction21t) {
        try {
            this.writer.write(getOpcodeValue(instruction21t.getOpcode()));
            this.writer.write(instruction21t.getRegisterA());
            this.writer.writeShort(instruction21t.getCodeOffset());
        } catch (IOException e16) {
            throw new RuntimeException(e16);
        }
    }

    public void write(@Nonnull Instruction22b instruction22b) {
        try {
            this.writer.write(getOpcodeValue(instruction22b.getOpcode()));
            this.writer.write(instruction22b.getRegisterA());
            this.writer.write(instruction22b.getRegisterB());
            this.writer.write(instruction22b.getNarrowLiteral());
        } catch (IOException e16) {
            throw new RuntimeException(e16);
        }
    }

    public void write(@Nonnull Instruction22c instruction22c) {
        try {
            this.writer.write(getOpcodeValue(instruction22c.getOpcode()));
            this.writer.write(packNibbles(instruction22c.getRegisterA(), instruction22c.getRegisterB()));
            this.writer.writeUshort(getReferenceIndex(instruction22c));
        } catch (IOException e16) {
            throw new RuntimeException(e16);
        }
    }

    public void write(@Nonnull Instruction22cs instruction22cs) {
        try {
            this.writer.write(getOpcodeValue(instruction22cs.getOpcode()));
            this.writer.write(packNibbles(instruction22cs.getRegisterA(), instruction22cs.getRegisterB()));
            this.writer.writeUshort(instruction22cs.getFieldOffset());
        } catch (IOException e16) {
            throw new RuntimeException(e16);
        }
    }

    public void write(@Nonnull Instruction22s instruction22s) {
        try {
            this.writer.write(getOpcodeValue(instruction22s.getOpcode()));
            this.writer.write(packNibbles(instruction22s.getRegisterA(), instruction22s.getRegisterB()));
            this.writer.writeShort(instruction22s.getNarrowLiteral());
        } catch (IOException e16) {
            throw new RuntimeException(e16);
        }
    }

    public void write(@Nonnull Instruction22t instruction22t) {
        try {
            this.writer.write(getOpcodeValue(instruction22t.getOpcode()));
            this.writer.write(packNibbles(instruction22t.getRegisterA(), instruction22t.getRegisterB()));
            this.writer.writeShort(instruction22t.getCodeOffset());
        } catch (IOException e16) {
            throw new RuntimeException(e16);
        }
    }

    public void write(@Nonnull Instruction22x instruction22x) {
        try {
            this.writer.write(getOpcodeValue(instruction22x.getOpcode()));
            this.writer.write(instruction22x.getRegisterA());
            this.writer.writeUshort(instruction22x.getRegisterB());
        } catch (IOException e16) {
            throw new RuntimeException(e16);
        }
    }

    public void write(@Nonnull Instruction23x instruction23x) {
        try {
            this.writer.write(getOpcodeValue(instruction23x.getOpcode()));
            this.writer.write(instruction23x.getRegisterA());
            this.writer.write(instruction23x.getRegisterB());
            this.writer.write(instruction23x.getRegisterC());
        } catch (IOException e16) {
            throw new RuntimeException(e16);
        }
    }

    public void write(@Nonnull Instruction30t instruction30t) {
        try {
            this.writer.write(getOpcodeValue(instruction30t.getOpcode()));
            this.writer.write(0);
            this.writer.writeInt(instruction30t.getCodeOffset());
        } catch (IOException e16) {
            throw new RuntimeException(e16);
        }
    }

    public void write(@Nonnull Instruction31c instruction31c) {
        try {
            this.writer.write(getOpcodeValue(instruction31c.getOpcode()));
            this.writer.write(instruction31c.getRegisterA());
            this.writer.writeInt(getReferenceIndex(instruction31c));
        } catch (IOException e16) {
            throw new RuntimeException(e16);
        }
    }

    public void write(@Nonnull Instruction31i instruction31i) {
        try {
            this.writer.write(getOpcodeValue(instruction31i.getOpcode()));
            this.writer.write(instruction31i.getRegisterA());
            this.writer.writeInt(instruction31i.getNarrowLiteral());
        } catch (IOException e16) {
            throw new RuntimeException(e16);
        }
    }

    public void write(@Nonnull Instruction31t instruction31t) {
        try {
            this.writer.write(getOpcodeValue(instruction31t.getOpcode()));
            this.writer.write(instruction31t.getRegisterA());
            this.writer.writeInt(instruction31t.getCodeOffset());
        } catch (IOException e16) {
            throw new RuntimeException(e16);
        }
    }

    public void write(@Nonnull Instruction32x instruction32x) {
        try {
            this.writer.write(getOpcodeValue(instruction32x.getOpcode()));
            this.writer.write(0);
            this.writer.writeUshort(instruction32x.getRegisterA());
            this.writer.writeUshort(instruction32x.getRegisterB());
        } catch (IOException e16) {
            throw new RuntimeException(e16);
        }
    }

    public void write(@Nonnull Instruction35c instruction35c) {
        try {
            this.writer.write(getOpcodeValue(instruction35c.getOpcode()));
            this.writer.write(packNibbles(instruction35c.getRegisterG(), instruction35c.getRegisterCount()));
            this.writer.writeUshort(getReferenceIndex(instruction35c));
            this.writer.write(packNibbles(instruction35c.getRegisterC(), instruction35c.getRegisterD()));
            this.writer.write(packNibbles(instruction35c.getRegisterE(), instruction35c.getRegisterF()));
        } catch (IOException e16) {
            throw new RuntimeException(e16);
        }
    }

    public void write(@Nonnull Instruction35mi instruction35mi) {
        try {
            this.writer.write(getOpcodeValue(instruction35mi.getOpcode()));
            this.writer.write(packNibbles(instruction35mi.getRegisterG(), instruction35mi.getRegisterCount()));
            this.writer.writeUshort(instruction35mi.getInlineIndex());
            this.writer.write(packNibbles(instruction35mi.getRegisterC(), instruction35mi.getRegisterD()));
            this.writer.write(packNibbles(instruction35mi.getRegisterE(), instruction35mi.getRegisterF()));
        } catch (IOException e16) {
            throw new RuntimeException(e16);
        }
    }

    public void write(@Nonnull Instruction35ms instruction35ms) {
        try {
            this.writer.write(getOpcodeValue(instruction35ms.getOpcode()));
            this.writer.write(packNibbles(instruction35ms.getRegisterG(), instruction35ms.getRegisterCount()));
            this.writer.writeUshort(instruction35ms.getVtableIndex());
            this.writer.write(packNibbles(instruction35ms.getRegisterC(), instruction35ms.getRegisterD()));
            this.writer.write(packNibbles(instruction35ms.getRegisterE(), instruction35ms.getRegisterF()));
        } catch (IOException e16) {
            throw new RuntimeException(e16);
        }
    }

    public void write(@Nonnull Instruction3rc instruction3rc) {
        try {
            this.writer.write(getOpcodeValue(instruction3rc.getOpcode()));
            this.writer.write(instruction3rc.getRegisterCount());
            this.writer.writeUshort(getReferenceIndex(instruction3rc));
            this.writer.writeUshort(instruction3rc.getStartRegister());
        } catch (IOException e16) {
            throw new RuntimeException(e16);
        }
    }

    public void write(@Nonnull Instruction3rmi instruction3rmi) {
        try {
            this.writer.write(getOpcodeValue(instruction3rmi.getOpcode()));
            this.writer.write(instruction3rmi.getRegisterCount());
            this.writer.writeUshort(instruction3rmi.getInlineIndex());
            this.writer.writeUshort(instruction3rmi.getStartRegister());
        } catch (IOException e16) {
            throw new RuntimeException(e16);
        }
    }

    public void write(@Nonnull Instruction3rms instruction3rms) {
        try {
            this.writer.write(getOpcodeValue(instruction3rms.getOpcode()));
            this.writer.write(instruction3rms.getRegisterCount());
            this.writer.writeUshort(instruction3rms.getVtableIndex());
            this.writer.writeUshort(instruction3rms.getStartRegister());
        } catch (IOException e16) {
            throw new RuntimeException(e16);
        }
    }

    public void write(@Nonnull Instruction45cc instruction45cc) {
        try {
            this.writer.write(getOpcodeValue(instruction45cc.getOpcode()));
            this.writer.write(packNibbles(instruction45cc.getRegisterG(), instruction45cc.getRegisterCount()));
            this.writer.writeUshort(getReferenceIndex(instruction45cc));
            this.writer.write(packNibbles(instruction45cc.getRegisterC(), instruction45cc.getRegisterD()));
            this.writer.write(packNibbles(instruction45cc.getRegisterE(), instruction45cc.getRegisterF()));
            this.writer.writeUshort(getReference2Index(instruction45cc));
        } catch (IOException e16) {
            throw new RuntimeException(e16);
        }
    }

    public void write(@Nonnull Instruction4rcc instruction4rcc) {
        try {
            this.writer.write(getOpcodeValue(instruction4rcc.getOpcode()));
            this.writer.write(instruction4rcc.getRegisterCount());
            this.writer.writeUshort(getReferenceIndex(instruction4rcc));
            this.writer.writeUshort(instruction4rcc.getStartRegister());
            this.writer.writeUshort(getReference2Index(instruction4rcc));
        } catch (IOException e16) {
            throw new RuntimeException(e16);
        }
    }

    public void write(@Nonnull Instruction51l instruction51l) {
        try {
            this.writer.write(getOpcodeValue(instruction51l.getOpcode()));
            this.writer.write(instruction51l.getRegisterA());
            this.writer.writeLong(instruction51l.getWideLiteral());
        } catch (IOException e16) {
            throw new RuntimeException(e16);
        }
    }

    public void write(@Nonnull ArrayPayload arrayPayload) {
        try {
            this.writer.writeUshort(getOpcodeValue(arrayPayload.getOpcode()));
            this.writer.writeUshort(arrayPayload.getElementWidth());
            List<Number> arrayElements = arrayPayload.getArrayElements();
            this.writer.writeInt(arrayElements.size());
            int elementWidth = arrayPayload.getElementWidth();
            if (elementWidth == 1) {
                Iterator<Number> it = arrayElements.iterator();
                while (it.hasNext()) {
                    this.writer.write(it.next().byteValue());
                }
            } else if (elementWidth == 2) {
                Iterator<Number> it5 = arrayElements.iterator();
                while (it5.hasNext()) {
                    this.writer.writeShort(it5.next().shortValue());
                }
            } else if (elementWidth == 4) {
                Iterator<Number> it6 = arrayElements.iterator();
                while (it6.hasNext()) {
                    this.writer.writeInt(it6.next().intValue());
                }
            } else if (elementWidth == 8) {
                Iterator<Number> it7 = arrayElements.iterator();
                while (it7.hasNext()) {
                    this.writer.writeLong(it7.next().longValue());
                }
            }
            if ((this.writer.getPosition() & 1) != 0) {
                this.writer.write(0);
            }
        } catch (IOException e16) {
            throw new RuntimeException(e16);
        }
    }

    public void write(@Nonnull SparseSwitchPayload sparseSwitchPayload) {
        try {
            this.writer.writeUbyte(0);
            this.writer.writeUbyte(getOpcodeValue(sparseSwitchPayload.getOpcode()) >> 8);
            ImmutableList immutableSortedCopy = Ordering.from(this.switchElementComparator).immutableSortedCopy(sparseSwitchPayload.getSwitchElements());
            this.writer.writeUshort(immutableSortedCopy.size());
            Iterator<E> it = immutableSortedCopy.iterator();
            while (it.hasNext()) {
                this.writer.writeInt(((SwitchElement) it.next()).getKey());
            }
            Iterator<E> it5 = immutableSortedCopy.iterator();
            while (it5.hasNext()) {
                this.writer.writeInt(((SwitchElement) it5.next()).getOffset());
            }
        } catch (IOException e16) {
            throw new RuntimeException(e16);
        }
    }

    public void write(@Nonnull PackedSwitchPayload packedSwitchPayload) {
        try {
            this.writer.writeUbyte(0);
            this.writer.writeUbyte(getOpcodeValue(packedSwitchPayload.getOpcode()) >> 8);
            List<? extends SwitchElement> switchElements = packedSwitchPayload.getSwitchElements();
            this.writer.writeUshort(switchElements.size());
            if (switchElements.size() == 0) {
                this.writer.writeInt(0);
                return;
            }
            this.writer.writeInt(switchElements.get(0).getKey());
            Iterator<? extends SwitchElement> it = switchElements.iterator();
            while (it.hasNext()) {
                this.writer.writeInt(it.next().getOffset());
            }
        } catch (IOException e16) {
            throw new RuntimeException(e16);
        }
    }
}
