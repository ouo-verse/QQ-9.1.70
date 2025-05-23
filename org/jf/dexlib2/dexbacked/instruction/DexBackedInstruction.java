package org.jf.dexlib2.dexbacked.instruction;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.dexbacked.DexReader;
import org.jf.dexlib2.iface.instruction.Instruction;
import org.jf.util.ExceptionWithContext;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class DexBackedInstruction implements Instruction {

    @Nonnull
    public final DexBackedDexFile dexFile;
    public final int instructionStart;

    @Nonnull
    public final Opcode opcode;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: org.jf.dexlib2.dexbacked.instruction.DexBackedInstruction$1, reason: invalid class name */
    /* loaded from: classes29.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jf$dexlib2$Format;

        static {
            int[] iArr = new int[Format.values().length];
            $SwitchMap$org$jf$dexlib2$Format = iArr;
            try {
                iArr[Format.Format10t.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format10x.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format11n.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format11x.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format12x.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format20bc.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format20t.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format21c.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format21ih.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format21lh.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format21s.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format21t.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format22b.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format22c.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format22cs.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format22s.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format22t.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format22x.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format23x.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format30t.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format31c.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format31i.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format31t.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format32x.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format35c.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format35ms.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format35mi.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format3rc.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format3rmi.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format3rms.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format45cc.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format4rcc.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format51l.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.PackedSwitchPayload.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.SparseSwitchPayload.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.ArrayPayload.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
        }
    }

    public DexBackedInstruction(@Nonnull DexBackedDexFile dexBackedDexFile, @Nonnull Opcode opcode, int i3) {
        this.dexFile = dexBackedDexFile;
        this.opcode = opcode;
        this.instructionStart = i3;
    }

    private static DexBackedInstruction buildInstruction(@Nonnull DexBackedDexFile dexBackedDexFile, @Nullable Opcode opcode, int i3) {
        if (opcode == null) {
            return new DexBackedUnknownInstruction(dexBackedDexFile, i3);
        }
        switch (AnonymousClass1.$SwitchMap$org$jf$dexlib2$Format[opcode.format.ordinal()]) {
            case 1:
                return new DexBackedInstruction10t(dexBackedDexFile, opcode, i3);
            case 2:
                return new DexBackedInstruction10x(dexBackedDexFile, opcode, i3);
            case 3:
                return new DexBackedInstruction11n(dexBackedDexFile, opcode, i3);
            case 4:
                return new DexBackedInstruction11x(dexBackedDexFile, opcode, i3);
            case 5:
                return new DexBackedInstruction12x(dexBackedDexFile, opcode, i3);
            case 6:
                return new DexBackedInstruction20bc(dexBackedDexFile, opcode, i3);
            case 7:
                return new DexBackedInstruction20t(dexBackedDexFile, opcode, i3);
            case 8:
                return new DexBackedInstruction21c(dexBackedDexFile, opcode, i3);
            case 9:
                return new DexBackedInstruction21ih(dexBackedDexFile, opcode, i3);
            case 10:
                return new DexBackedInstruction21lh(dexBackedDexFile, opcode, i3);
            case 11:
                return new DexBackedInstruction21s(dexBackedDexFile, opcode, i3);
            case 12:
                return new DexBackedInstruction21t(dexBackedDexFile, opcode, i3);
            case 13:
                return new DexBackedInstruction22b(dexBackedDexFile, opcode, i3);
            case 14:
                return new DexBackedInstruction22c(dexBackedDexFile, opcode, i3);
            case 15:
                return new DexBackedInstruction22cs(dexBackedDexFile, opcode, i3);
            case 16:
                return new DexBackedInstruction22s(dexBackedDexFile, opcode, i3);
            case 17:
                return new DexBackedInstruction22t(dexBackedDexFile, opcode, i3);
            case 18:
                return new DexBackedInstruction22x(dexBackedDexFile, opcode, i3);
            case 19:
                return new DexBackedInstruction23x(dexBackedDexFile, opcode, i3);
            case 20:
                return new DexBackedInstruction30t(dexBackedDexFile, opcode, i3);
            case 21:
                return new DexBackedInstruction31c(dexBackedDexFile, opcode, i3);
            case 22:
                return new DexBackedInstruction31i(dexBackedDexFile, opcode, i3);
            case 23:
                return new DexBackedInstruction31t(dexBackedDexFile, opcode, i3);
            case 24:
                return new DexBackedInstruction32x(dexBackedDexFile, opcode, i3);
            case 25:
                return new DexBackedInstruction35c(dexBackedDexFile, opcode, i3);
            case 26:
                return new DexBackedInstruction35ms(dexBackedDexFile, opcode, i3);
            case 27:
                return new DexBackedInstruction35mi(dexBackedDexFile, opcode, i3);
            case 28:
                return new DexBackedInstruction3rc(dexBackedDexFile, opcode, i3);
            case 29:
                return new DexBackedInstruction3rmi(dexBackedDexFile, opcode, i3);
            case 30:
                return new DexBackedInstruction3rms(dexBackedDexFile, opcode, i3);
            case 31:
                return new DexBackedInstruction45cc(dexBackedDexFile, opcode, i3);
            case 32:
                return new DexBackedInstruction4rcc(dexBackedDexFile, opcode, i3);
            case 33:
                return new DexBackedInstruction51l(dexBackedDexFile, opcode, i3);
            case 34:
                return new DexBackedPackedSwitchPayload(dexBackedDexFile, i3);
            case 35:
                return new DexBackedSparseSwitchPayload(dexBackedDexFile, i3);
            case 36:
                return new DexBackedArrayPayload(dexBackedDexFile, i3);
            default:
                throw new ExceptionWithContext("Unexpected opcode format: %s", opcode.format.toString());
        }
    }

    @Nonnull
    public static Instruction readFrom(DexBackedDexFile dexBackedDexFile, @Nonnull DexReader dexReader) {
        int peekUbyte = dexReader.peekUbyte();
        if (peekUbyte == 0) {
            peekUbyte = dexReader.peekUshort();
        }
        DexBackedInstruction buildInstruction = buildInstruction(dexBackedDexFile, dexBackedDexFile.getOpcodes().getOpcodeByValue(peekUbyte), ((dexReader.getOffset() + dexReader.dexBuf.getBaseOffset()) - dexBackedDexFile.getBuffer().getBaseOffset()) - dexBackedDexFile.getBaseDataOffset());
        dexReader.moveRelative(buildInstruction.getCodeUnits() * 2);
        return buildInstruction;
    }

    @Override // org.jf.dexlib2.iface.instruction.Instruction
    public int getCodeUnits() {
        return this.opcode.format.size / 2;
    }

    @Override // org.jf.dexlib2.iface.instruction.Instruction
    @Nonnull
    public Opcode getOpcode() {
        return this.opcode;
    }
}
