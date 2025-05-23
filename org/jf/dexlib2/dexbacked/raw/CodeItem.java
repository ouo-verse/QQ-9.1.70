package org.jf.dexlib2.dexbacked.raw;

import com.google.common.base.e;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.VerificationError;
import org.jf.dexlib2.dexbacked.CDexBackedDexFile;
import org.jf.dexlib2.dexbacked.DexBuffer;
import org.jf.dexlib2.dexbacked.DexReader;
import org.jf.dexlib2.dexbacked.instruction.DexBackedInstruction;
import org.jf.dexlib2.dexbacked.raw.util.DexAnnotator;
import org.jf.dexlib2.formatter.DexFormatter;
import org.jf.dexlib2.iface.instruction.FieldOffsetInstruction;
import org.jf.dexlib2.iface.instruction.InlineIndexInstruction;
import org.jf.dexlib2.iface.instruction.Instruction;
import org.jf.dexlib2.iface.instruction.NarrowLiteralInstruction;
import org.jf.dexlib2.iface.instruction.OffsetInstruction;
import org.jf.dexlib2.iface.instruction.OneRegisterInstruction;
import org.jf.dexlib2.iface.instruction.ReferenceInstruction;
import org.jf.dexlib2.iface.instruction.SwitchElement;
import org.jf.dexlib2.iface.instruction.ThreeRegisterInstruction;
import org.jf.dexlib2.iface.instruction.TwoRegisterInstruction;
import org.jf.dexlib2.iface.instruction.VerificationErrorInstruction;
import org.jf.dexlib2.iface.instruction.VtableIndexInstruction;
import org.jf.dexlib2.iface.instruction.WideLiteralInstruction;
import org.jf.dexlib2.iface.instruction.formats.ArrayPayload;
import org.jf.dexlib2.iface.instruction.formats.Instruction35c;
import org.jf.dexlib2.iface.instruction.formats.Instruction3rc;
import org.jf.dexlib2.iface.instruction.formats.PackedSwitchPayload;
import org.jf.dexlib2.iface.instruction.formats.SparseSwitchPayload;
import org.jf.dexlib2.iface.reference.Reference;
import org.jf.dexlib2.iface.reference.StringReference;
import org.jf.dexlib2.util.AnnotatedBytes;
import org.jf.util.ExceptionWithContext;
import org.jf.util.NumberUtils;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes29.dex */
public class CodeItem {
    public static int CDEX_INSTRUCTIONS_SIZE_AND_PREHEADER_FLAGS_OFFSET = 2;
    public static int CDEX_INSTRUCTIONS_SIZE_SHIFT = 5;
    public static int CDEX_INS_COUNT_SHIFT = 8;
    public static int CDEX_OUTS_COUNT_SHIFT = 4;
    public static int CDEX_PREHEADER_FLAGS_MASK = 31;
    public static int CDEX_PREHEADER_FLAG_INSTRUCTIONS_SIZE = 16;
    public static int CDEX_PREHEADER_FLAG_INS_COUNT = 2;
    public static int CDEX_PREHEADER_FLAG_OUTS_COUNT = 4;
    public static int CDEX_PREHEADER_FLAG_REGISTER_COUNT = 1;
    public static int CDEX_PREHEADER_FLAG_TRIES_COUNT = 8;
    public static int CDEX_REGISTER_COUNT_SHIFT = 12;
    public static int CDEX_TRIES_SIZE_SHIFT = 0;
    public static final int DEBUG_INFO_OFFSET = 8;
    public static final int INSTRUCTION_COUNT_OFFSET = 12;
    public static final int INSTRUCTION_START_OFFSET = 16;
    public static final int INS_OFFSET = 2;
    public static final int OUTS_OFFSET = 4;
    public static final int REGISTERS_OFFSET = 0;
    public static final int TRIES_SIZE_OFFSET = 6;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: org.jf.dexlib2.dexbacked.raw.CodeItem$2, reason: invalid class name */
    /* loaded from: classes29.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$jf$dexlib2$Format;

        static {
            int[] iArr = new int[Format.values().length];
            $SwitchMap$org$jf$dexlib2$Format = iArr;
            try {
                iArr[Format.Format10x.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format35c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format3rc.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.ArrayPayload.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.PackedSwitchPayload.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.SparseSwitchPayload.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class CodeItemAnnotator extends SectionAnnotator {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private SectionAnnotator debugInfoAnnotator;

        /* JADX INFO: Access modifiers changed from: protected */
        /* compiled from: P */
        /* loaded from: classes29.dex */
        public class PreInstructionInfo {
            public int instructionSize;
            public int triesCount;

            public PreInstructionInfo(int i3, int i16) {
                this.triesCount = i3;
                this.instructionSize = i16;
            }
        }

        public CodeItemAnnotator(@Nonnull DexAnnotator dexAnnotator, @Nonnull MapItem mapItem) {
            super(dexAnnotator, mapItem);
        }

        private void addDebugInfoIdentity(int i3, String str) {
            SectionAnnotator sectionAnnotator = this.debugInfoAnnotator;
            if (sectionAnnotator != null) {
                sectionAnnotator.setItemIdentity(i3, str);
            }
        }

        private void annotateArrayPayload(@Nonnull AnnotatedBytes annotatedBytes, @Nonnull ArrayPayload arrayPayload) {
            List<Number> arrayElements = arrayPayload.getArrayElements();
            int elementWidth = arrayPayload.getElementWidth();
            annotatedBytes.annotate(2, arrayPayload.getOpcode().name, new Object[0]);
            annotatedBytes.indent();
            annotatedBytes.annotate(2, "element_width = %d", Integer.valueOf(elementWidth));
            annotatedBytes.annotate(4, "size = %d", Integer.valueOf(arrayElements.size()));
            if (arrayElements.size() > 0) {
                annotatedBytes.annotate(0, "elements:", new Object[0]);
            }
            annotatedBytes.indent();
            if (arrayElements.size() > 0) {
                for (int i3 = 0; i3 < arrayElements.size(); i3++) {
                    if (elementWidth == 8) {
                        long longValue = arrayElements.get(i3).longValue();
                        if (NumberUtils.isLikelyDouble(longValue)) {
                            annotatedBytes.annotate(elementWidth, "element[%d] = %d # %f", Integer.valueOf(i3), Long.valueOf(longValue), Double.valueOf(Double.longBitsToDouble(longValue)));
                        } else {
                            annotatedBytes.annotate(elementWidth, "element[%d] = %d", Integer.valueOf(i3), Long.valueOf(longValue));
                        }
                    } else {
                        int intValue = arrayElements.get(i3).intValue();
                        if (NumberUtils.isLikelyFloat(intValue)) {
                            annotatedBytes.annotate(elementWidth, "element[%d] = %d # %f", Integer.valueOf(i3), Integer.valueOf(intValue), Float.valueOf(Float.intBitsToFloat(intValue)));
                        } else {
                            annotatedBytes.annotate(elementWidth, "element[%d] = %d", Integer.valueOf(i3), Integer.valueOf(intValue));
                        }
                    }
                }
            }
            if (annotatedBytes.getCursor() % 2 != 0) {
                annotatedBytes.annotate(1, "padding", new Object[0]);
            }
            annotatedBytes.deindent();
            annotatedBytes.deindent();
        }

        private void annotateDefaultInstruction(@Nonnull AnnotatedBytes annotatedBytes, @Nonnull Instruction instruction) {
            String str;
            String obj;
            ArrayList h16 = Lists.h();
            if (instruction instanceof OneRegisterInstruction) {
                h16.add(formatRegister(((OneRegisterInstruction) instruction).getRegisterA()));
                if (instruction instanceof TwoRegisterInstruction) {
                    h16.add(formatRegister(((TwoRegisterInstruction) instruction).getRegisterB()));
                    if (instruction instanceof ThreeRegisterInstruction) {
                        h16.add(formatRegister(((ThreeRegisterInstruction) instruction).getRegisterC()));
                    }
                }
            } else if (instruction instanceof VerificationErrorInstruction) {
                String verificationErrorName = VerificationError.getVerificationErrorName(((VerificationErrorInstruction) instruction).getVerificationError());
                if (verificationErrorName != null) {
                    h16.add(verificationErrorName);
                } else {
                    h16.add("invalid verification error type");
                }
            }
            if (instruction instanceof ReferenceInstruction) {
                ReferenceInstruction referenceInstruction = (ReferenceInstruction) instruction;
                Reference reference = referenceInstruction.getReference();
                if (referenceInstruction.getReferenceType() == 0) {
                    obj = DexFormatter.INSTANCE.getQuotedString((StringReference) reference);
                } else {
                    obj = referenceInstruction.getReference().toString();
                }
                h16.add(obj);
            } else if (instruction instanceof OffsetInstruction) {
                int codeOffset = ((OffsetInstruction) instruction).getCodeOffset();
                if (codeOffset >= 0) {
                    str = Marker.ANY_NON_NULL_MARKER;
                } else {
                    str = "-";
                }
                h16.add(String.format("%s0x%x", str, Integer.valueOf(Math.abs(codeOffset))));
            } else if (instruction instanceof NarrowLiteralInstruction) {
                int narrowLiteral = ((NarrowLiteralInstruction) instruction).getNarrowLiteral();
                if (NumberUtils.isLikelyFloat(narrowLiteral)) {
                    h16.add(String.format("%d # %f", Integer.valueOf(narrowLiteral), Float.valueOf(Float.intBitsToFloat(narrowLiteral))));
                } else {
                    h16.add(String.format("%d", Integer.valueOf(narrowLiteral)));
                }
            } else if (instruction instanceof WideLiteralInstruction) {
                long wideLiteral = ((WideLiteralInstruction) instruction).getWideLiteral();
                if (NumberUtils.isLikelyDouble(wideLiteral)) {
                    h16.add(String.format("%d # %f", Long.valueOf(wideLiteral), Double.valueOf(Double.longBitsToDouble(wideLiteral))));
                } else {
                    h16.add(String.format("%d", Long.valueOf(wideLiteral)));
                }
            } else if (instruction instanceof FieldOffsetInstruction) {
                h16.add(String.format("field@0x%x", Integer.valueOf(((FieldOffsetInstruction) instruction).getFieldOffset())));
            } else if (instruction instanceof VtableIndexInstruction) {
                h16.add(String.format("vtable@%d", Integer.valueOf(((VtableIndexInstruction) instruction).getVtableIndex())));
            } else if (instruction instanceof InlineIndexInstruction) {
                h16.add(String.format("inline@%d", Integer.valueOf(((InlineIndexInstruction) instruction).getInlineIndex())));
            }
            annotatedBytes.annotate(instruction.getCodeUnits() * 2, "%s %s", instruction.getOpcode().name, e.h(", ").d(h16));
        }

        private void annotateInstruction10x(@Nonnull AnnotatedBytes annotatedBytes, @Nonnull Instruction instruction) {
            annotatedBytes.annotate(2, instruction.getOpcode().name, new Object[0]);
        }

        private void annotateInstruction35c(@Nonnull AnnotatedBytes annotatedBytes, @Nonnull Instruction35c instruction35c) {
            ArrayList h16 = Lists.h();
            int registerCount = instruction35c.getRegisterCount();
            if (registerCount == 1) {
                h16.add(formatRegister(instruction35c.getRegisterC()));
            } else if (registerCount == 2) {
                h16.add(formatRegister(instruction35c.getRegisterC()));
                h16.add(formatRegister(instruction35c.getRegisterD()));
            } else if (registerCount == 3) {
                h16.add(formatRegister(instruction35c.getRegisterC()));
                h16.add(formatRegister(instruction35c.getRegisterD()));
                h16.add(formatRegister(instruction35c.getRegisterE()));
            } else if (registerCount == 4) {
                h16.add(formatRegister(instruction35c.getRegisterC()));
                h16.add(formatRegister(instruction35c.getRegisterD()));
                h16.add(formatRegister(instruction35c.getRegisterE()));
                h16.add(formatRegister(instruction35c.getRegisterF()));
            } else if (registerCount == 5) {
                h16.add(formatRegister(instruction35c.getRegisterC()));
                h16.add(formatRegister(instruction35c.getRegisterD()));
                h16.add(formatRegister(instruction35c.getRegisterE()));
                h16.add(formatRegister(instruction35c.getRegisterF()));
                h16.add(formatRegister(instruction35c.getRegisterG()));
            }
            annotatedBytes.annotate(6, String.format("%s {%s}, %s", instruction35c.getOpcode().name, e.h(", ").d(h16), instruction35c.getReference()), new Object[0]);
        }

        private void annotateInstruction3rc(@Nonnull AnnotatedBytes annotatedBytes, @Nonnull Instruction3rc instruction3rc) {
            int startRegister = instruction3rc.getStartRegister();
            annotatedBytes.annotate(6, String.format("%s {%s .. %s}, %s", instruction3rc.getOpcode().name, formatRegister(startRegister), formatRegister((instruction3rc.getRegisterCount() + startRegister) - 1), instruction3rc.getReference()), new Object[0]);
        }

        private void annotatePackedSwitchPayload(@Nonnull AnnotatedBytes annotatedBytes, @Nonnull PackedSwitchPayload packedSwitchPayload) {
            List<? extends SwitchElement> switchElements = packedSwitchPayload.getSwitchElements();
            annotatedBytes.annotate(2, packedSwitchPayload.getOpcode().name, new Object[0]);
            annotatedBytes.indent();
            annotatedBytes.annotate(2, "size = %d", Integer.valueOf(switchElements.size()));
            if (switchElements.size() == 0) {
                annotatedBytes.annotate(4, "first_key", new Object[0]);
            } else {
                annotatedBytes.annotate(4, "first_key = %d", Integer.valueOf(switchElements.get(0).getKey()));
                annotatedBytes.annotate(0, "targets:", new Object[0]);
                annotatedBytes.indent();
                for (int i3 = 0; i3 < switchElements.size(); i3++) {
                    annotatedBytes.annotate(4, "target[%d] = %d", Integer.valueOf(i3), Integer.valueOf(switchElements.get(i3).getOffset()));
                }
                annotatedBytes.deindent();
            }
            annotatedBytes.deindent();
        }

        private void annotateSparseSwitchPayload(@Nonnull AnnotatedBytes annotatedBytes, @Nonnull SparseSwitchPayload sparseSwitchPayload) {
            List<? extends SwitchElement> switchElements = sparseSwitchPayload.getSwitchElements();
            annotatedBytes.annotate(2, sparseSwitchPayload.getOpcode().name, new Object[0]);
            annotatedBytes.indent();
            annotatedBytes.annotate(2, "size = %d", Integer.valueOf(switchElements.size()));
            if (switchElements.size() > 0) {
                annotatedBytes.annotate(0, "keys:", new Object[0]);
                annotatedBytes.indent();
                for (int i3 = 0; i3 < switchElements.size(); i3++) {
                    annotatedBytes.annotate(4, "key[%d] = %d", Integer.valueOf(i3), Integer.valueOf(switchElements.get(i3).getKey()));
                }
                annotatedBytes.deindent();
                annotatedBytes.annotate(0, "targets:", new Object[0]);
                annotatedBytes.indent();
                for (int i16 = 0; i16 < switchElements.size(); i16++) {
                    annotatedBytes.annotate(4, "target[%d] = %d", Integer.valueOf(i16), Integer.valueOf(switchElements.get(i16).getOffset()));
                }
                annotatedBytes.deindent();
            }
            annotatedBytes.deindent();
        }

        private String formatRegister(int i3) {
            return String.format("v%d", Integer.valueOf(i3));
        }

        protected void annotateInstructions(@Nonnull AnnotatedBytes annotatedBytes, @Nonnull DexReader dexReader, int i3) {
            annotatedBytes.annotate(0, "instructions:", new Object[0]);
            annotatedBytes.indent();
            int i16 = i3 * 2;
            annotatedBytes.setLimit(annotatedBytes.getCursor(), annotatedBytes.getCursor() + i16);
            int offset = dexReader.getOffset() + i16;
            while (dexReader.getOffset() < offset) {
                try {
                    try {
                        Instruction readFrom = DexBackedInstruction.readFrom(this.dexFile, dexReader);
                        if (dexReader.getOffset() > offset) {
                            annotatedBytes.annotateTo(offset, "truncated instruction", new Object[0]);
                            dexReader.setOffset(offset);
                        } else {
                            switch (AnonymousClass2.$SwitchMap$org$jf$dexlib2$Format[readFrom.getOpcode().format.ordinal()]) {
                                case 1:
                                    annotateInstruction10x(annotatedBytes, readFrom);
                                    break;
                                case 2:
                                    annotateInstruction35c(annotatedBytes, (Instruction35c) readFrom);
                                    break;
                                case 3:
                                    annotateInstruction3rc(annotatedBytes, (Instruction3rc) readFrom);
                                    break;
                                case 4:
                                    annotateArrayPayload(annotatedBytes, (ArrayPayload) readFrom);
                                    break;
                                case 5:
                                    annotatePackedSwitchPayload(annotatedBytes, (PackedSwitchPayload) readFrom);
                                    break;
                                case 6:
                                    annotateSparseSwitchPayload(annotatedBytes, (SparseSwitchPayload) readFrom);
                                    break;
                                default:
                                    annotateDefaultInstruction(annotatedBytes, readFrom);
                                    break;
                            }
                        }
                    } catch (ExceptionWithContext e16) {
                        e16.printStackTrace(System.err);
                        annotatedBytes.annotate(0, "annotation error: %s", e16.getMessage());
                        annotatedBytes.moveTo(offset);
                        dexReader.setOffset(offset);
                    }
                } finally {
                    annotatedBytes.clearLimit();
                    annotatedBytes.deindent();
                }
            }
        }

        @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
        public void annotateItem(@Nonnull AnnotatedBytes annotatedBytes, int i3, @Nullable String str) {
            try {
                DexReader<? extends DexBuffer> readerAt = this.dexFile.getBuffer().readerAt(annotatedBytes.getCursor());
                PreInstructionInfo annotatePreInstructionFields = annotatePreInstructionFields(annotatedBytes, readerAt, str);
                annotateInstructions(annotatedBytes, readerAt, annotatePreInstructionFields.instructionSize);
                annotatePostInstructionFields(annotatedBytes, readerAt, annotatePreInstructionFields.triesCount);
            } catch (ExceptionWithContext e16) {
                annotatedBytes.annotate(0, "annotation error: %s", e16.getMessage());
            }
        }

        protected void annotatePostInstructionFields(@Nonnull AnnotatedBytes annotatedBytes, @Nonnull DexReader dexReader, int i3) {
            boolean z16;
            if (i3 > 0) {
                if (dexReader.getOffset() % 4 != 0) {
                    dexReader.readUshort();
                    annotatedBytes.annotate(2, "padding", new Object[0]);
                }
                annotatedBytes.annotate(0, "try_items:", new Object[0]);
                annotatedBytes.indent();
                for (int i16 = 0; i16 < i3; i16++) {
                    try {
                        annotatedBytes.annotate(0, "try_item[%d]:", Integer.valueOf(i16));
                        annotatedBytes.indent();
                        annotatedBytes.annotate(4, "start_addr = 0x%x", Integer.valueOf(dexReader.readSmallUint()));
                        annotatedBytes.annotate(2, "insn_count = 0x%x", Integer.valueOf(dexReader.readUshort()));
                        annotatedBytes.annotate(2, "handler_off = 0x%x", Integer.valueOf(dexReader.readUshort()));
                        annotatedBytes.deindent();
                    } catch (Throwable th5) {
                        throw th5;
                    } finally {
                    }
                }
                annotatedBytes.deindent();
                int readSmallUleb128 = dexReader.readSmallUleb128();
                annotatedBytes.annotate(0, "encoded_catch_handler_list:", new Object[0]);
                annotatedBytes.annotateTo(dexReader.getOffset(), "size = %d", Integer.valueOf(readSmallUleb128));
                annotatedBytes.indent();
                for (int i17 = 0; i17 < readSmallUleb128; i17++) {
                    try {
                        annotatedBytes.annotate(0, "encoded_catch_handler[%d]", Integer.valueOf(i17));
                        annotatedBytes.indent();
                        int readSleb128 = dexReader.readSleb128();
                        annotatedBytes.annotateTo(dexReader.getOffset(), "size = %d", Integer.valueOf(readSleb128));
                        if (readSleb128 <= 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        int abs = Math.abs(readSleb128);
                        if (abs != 0) {
                            annotatedBytes.annotate(0, "handlers:", new Object[0]);
                            annotatedBytes.indent();
                            for (int i18 = 0; i18 < abs; i18++) {
                                try {
                                    annotatedBytes.annotate(0, "encoded_type_addr_pair[%d]", Integer.valueOf(i17));
                                    annotatedBytes.indent();
                                    try {
                                        annotatedBytes.annotateTo(dexReader.getOffset(), TypeIdItem.getReferenceAnnotation(this.dexFile, dexReader.readSmallUleb128()), new Object[0]);
                                        annotatedBytes.annotateTo(dexReader.getOffset(), "addr = 0x%x", Integer.valueOf(dexReader.readSmallUleb128()));
                                        annotatedBytes.deindent();
                                    } catch (Throwable th6) {
                                        throw th6;
                                    }
                                } catch (Throwable th7) {
                                    annotatedBytes.deindent();
                                    throw th7;
                                }
                            }
                            annotatedBytes.deindent();
                        }
                        if (z16) {
                            annotatedBytes.annotateTo(dexReader.getOffset(), "catch_all_addr = 0x%x", Integer.valueOf(dexReader.readSmallUleb128()));
                        }
                        annotatedBytes.deindent();
                    } catch (Throwable th8) {
                        throw th8;
                    } finally {
                    }
                }
            }
        }

        protected PreInstructionInfo annotatePreInstructionFields(@Nonnull AnnotatedBytes annotatedBytes, @Nonnull DexReader dexReader, @Nullable String str) {
            annotatedBytes.annotate(2, "registers_size = %d", Integer.valueOf(dexReader.readUshort()));
            annotatedBytes.annotate(2, "ins_size = %d", Integer.valueOf(dexReader.readUshort()));
            annotatedBytes.annotate(2, "outs_size = %d", Integer.valueOf(dexReader.readUshort()));
            int readUshort = dexReader.readUshort();
            annotatedBytes.annotate(2, "tries_size = %d", Integer.valueOf(readUshort));
            int readInt = dexReader.readInt();
            annotatedBytes.annotate(4, "debug_info_off = 0x%x", Integer.valueOf(readInt));
            if (readInt > 0) {
                addDebugInfoIdentity(readInt, str);
            }
            int readSmallUint = dexReader.readSmallUint();
            annotatedBytes.annotate(4, "insns_size = 0x%x", Integer.valueOf(readSmallUint));
            return new PreInstructionInfo(readUshort, readSmallUint);
        }

        @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
        public int getItemAlignment() {
            return 4;
        }

        @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
        @Nonnull
        public String getItemName() {
            return "code_item";
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class TryItem {
        public static final int CODE_UNIT_COUNT_OFFSET = 4;
        public static final int HANDLER_OFFSET = 6;
        public static final int ITEM_SIZE = 8;
        public static final int START_ADDRESS_OFFSET = 0;
    }

    public static SectionAnnotator makeAnnotator(@Nonnull DexAnnotator dexAnnotator, @Nonnull MapItem mapItem) {
        if (dexAnnotator.dexFile instanceof CDexBackedDexFile) {
            return makeAnnotatorForCDex(dexAnnotator, mapItem);
        }
        return makeAnnotatorForDex(dexAnnotator, mapItem);
    }

    @Nonnull
    private static SectionAnnotator makeAnnotatorForCDex(@Nonnull DexAnnotator dexAnnotator, @Nonnull MapItem mapItem) {
        return new CodeItemAnnotator(dexAnnotator, mapItem) { // from class: org.jf.dexlib2.dexbacked.raw.CodeItem.1
            private List<Integer> sortedItems;

            @Override // org.jf.dexlib2.dexbacked.raw.CodeItem.CodeItemAnnotator
            protected CodeItemAnnotator.PreInstructionInfo annotatePreInstructionFields(@Nonnull AnnotatedBytes annotatedBytes, @Nonnull DexReader dexReader, @Nullable String str) {
                int readUshort = dexReader.readUshort();
                int i3 = (readUshort >> CodeItem.CDEX_TRIES_SIZE_SHIFT) & 15;
                int i16 = (readUshort >> CodeItem.CDEX_OUTS_COUNT_SHIFT) & 15;
                int i17 = (readUshort >> CodeItem.CDEX_INS_COUNT_SHIFT) & 15;
                int i18 = (readUshort >> CodeItem.CDEX_REGISTER_COUNT_SHIFT) & 15;
                int cursor = annotatedBytes.getCursor();
                annotatedBytes.annotate(2, "tries_size = %d", Integer.valueOf(i3));
                annotatedBytes.annotate(0, "outs_size = %d", Integer.valueOf(i16));
                annotatedBytes.annotate(0, "ins_size = %d", Integer.valueOf(i17));
                annotatedBytes.annotate(0, "registers_size = %d", Integer.valueOf(i18));
                int readUshort2 = dexReader.readUshort();
                int i19 = readUshort2 >> CodeItem.CDEX_INSTRUCTIONS_SIZE_SHIFT;
                annotatedBytes.annotate(2, "insns_size = %d", Integer.valueOf(i19));
                int cursor2 = annotatedBytes.getCursor();
                int i26 = CodeItem.CDEX_PREHEADER_FLAGS_MASK;
                if ((readUshort2 & i26) != 0) {
                    int bitCount = Integer.bitCount(i26 & readUshort2);
                    if ((CodeItem.CDEX_PREHEADER_FLAG_INSTRUCTIONS_SIZE & readUshort2) != 0) {
                        bitCount++;
                    }
                    annotatedBytes.moveTo(cursor - (bitCount * 2));
                    annotatedBytes.deindent();
                    annotatedBytes.annotate(0, "[preheader for next code_item]", new Object[0]);
                    annotatedBytes.indent();
                    annotatedBytes.moveTo(cursor2);
                }
                if ((CodeItem.CDEX_PREHEADER_FLAG_INSTRUCTIONS_SIZE & readUshort2) != 0) {
                    annotatedBytes.annotate(0, "insns_size_preheader_flag=1", new Object[0]);
                    int i27 = cursor - 2;
                    dexReader.setOffset(i27);
                    int readUshort3 = dexReader.readUshort();
                    cursor = i27 - 2;
                    dexReader.setOffset(cursor);
                    int readUshort4 = readUshort3 + dexReader.readUshort();
                    annotatedBytes.moveTo(cursor);
                    int i28 = i19 + readUshort4;
                    annotatedBytes.annotate(2, "insns_size = %d + %d = %d", Integer.valueOf(i19), Integer.valueOf(readUshort4), Integer.valueOf(i28));
                    annotatedBytes.moveTo(cursor2);
                    i19 = i28;
                }
                if ((CodeItem.CDEX_PREHEADER_FLAG_REGISTER_COUNT & readUshort2) != 0) {
                    annotatedBytes.annotate(0, "registers_size_preheader_flag=1", new Object[0]);
                    cursor -= 2;
                    annotatedBytes.moveTo(cursor);
                    dexReader.setOffset(cursor);
                    int readUshort5 = dexReader.readUshort();
                    annotatedBytes.annotate(2, "registers_size = %d + %d = %d", Integer.valueOf(i18), Integer.valueOf(readUshort5), Integer.valueOf(i18 + readUshort5));
                    annotatedBytes.moveTo(cursor2);
                }
                if ((CodeItem.CDEX_PREHEADER_FLAG_INS_COUNT & readUshort2) != 0) {
                    annotatedBytes.annotate(0, "ins_size_preheader_flag=1", new Object[0]);
                    cursor -= 2;
                    annotatedBytes.moveTo(cursor);
                    dexReader.setOffset(cursor);
                    int readUshort6 = dexReader.readUshort();
                    annotatedBytes.annotate(2, "ins_size = %d + %d = %d", Integer.valueOf(i17), Integer.valueOf(readUshort6), Integer.valueOf(i17 + readUshort6));
                    annotatedBytes.moveTo(cursor2);
                }
                if ((CodeItem.CDEX_PREHEADER_FLAG_OUTS_COUNT & readUshort2) != 0) {
                    annotatedBytes.annotate(0, "outs_size_preheader_flag=1", new Object[0]);
                    cursor -= 2;
                    annotatedBytes.moveTo(cursor);
                    dexReader.setOffset(cursor);
                    int readUshort7 = dexReader.readUshort();
                    annotatedBytes.annotate(2, "outs_size = %d + %d = %d", Integer.valueOf(i16), Integer.valueOf(readUshort7), Integer.valueOf(i16 + readUshort7));
                    annotatedBytes.moveTo(cursor2);
                }
                if ((CodeItem.CDEX_PREHEADER_FLAG_TRIES_COUNT & readUshort2) != 0) {
                    annotatedBytes.annotate(0, "tries_size_preheader_flag=1", new Object[0]);
                    int i29 = cursor - 2;
                    annotatedBytes.moveTo(i29);
                    dexReader.setOffset(i29);
                    int readUshort8 = dexReader.readUshort();
                    int i36 = i3 + readUshort8;
                    annotatedBytes.annotate(2, "tries_size = %d + %d = %d", Integer.valueOf(i3), Integer.valueOf(readUshort8), Integer.valueOf(i36));
                    annotatedBytes.moveTo(cursor2);
                    i3 = i36;
                }
                dexReader.setOffset(cursor2);
                return new CodeItemAnnotator.PreInstructionInfo(i3, i19);
            }

            @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
            public void annotateSection(@Nonnull AnnotatedBytes annotatedBytes) {
                ArrayList arrayList = new ArrayList(this.itemIdentities.keySet());
                this.sortedItems = arrayList;
                arrayList.sort(new Comparator() { // from class: org.jf.dexlib2.dexbacked.raw.b
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return ((Integer) obj).compareTo((Integer) obj2);
                    }
                });
                annotatedBytes.moveTo(this.sectionOffset);
                annotateSectionInner(annotatedBytes, this.itemIdentities.size());
            }

            @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
            protected int getItemOffset(int i3, int i16) {
                return this.sortedItems.get(i3).intValue();
            }
        };
    }

    @Nonnull
    private static SectionAnnotator makeAnnotatorForDex(@Nonnull DexAnnotator dexAnnotator, @Nonnull MapItem mapItem) {
        return new CodeItemAnnotator(dexAnnotator, mapItem);
    }
}
