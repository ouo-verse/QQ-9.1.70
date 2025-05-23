package org.jf.dexlib2.analysis;

import com.google.common.base.g;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.FiveRegisterInstruction;
import org.jf.dexlib2.iface.instruction.Instruction;
import org.jf.dexlib2.iface.instruction.OneRegisterInstruction;
import org.jf.dexlib2.iface.instruction.ReferenceInstruction;
import org.jf.dexlib2.iface.instruction.RegisterRangeInstruction;
import org.jf.dexlib2.iface.instruction.TwoRegisterInstruction;
import org.jf.dexlib2.iface.instruction.formats.Instruction22c;
import org.jf.dexlib2.iface.reference.MethodReference;
import org.jf.dexlib2.iface.reference.Reference;
import org.jf.dexlib2.iface.reference.TypeReference;
import org.jf.util.ExceptionWithContext;

/* compiled from: P */
/* loaded from: classes29.dex */
public class AnalyzedInstruction implements Comparable<AnalyzedInstruction> {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @Nonnull
    protected Instruction instruction;
    protected final int instructionIndex;

    @Nonnull
    protected final MethodAnalyzer methodAnalyzer;
    protected final Instruction originalInstruction;

    @Nonnull
    protected final RegisterType[] postRegisterMap;

    @Nonnull
    protected final RegisterType[] preRegisterMap;

    @Nonnull
    protected final TreeSet<AnalyzedInstruction> predecessors = new TreeSet<>();

    @Nonnull
    protected final LinkedList<AnalyzedInstruction> successors = new LinkedList<>();

    @Nullable
    protected Map<PredecessorOverrideKey, RegisterType> predecessorRegisterOverrides = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class PredecessorOverrideKey {
        public final AnalyzedInstruction analyzedInstruction;
        public final int registerNumber;

        public PredecessorOverrideKey(AnalyzedInstruction analyzedInstruction, int i3) {
            this.analyzedInstruction = analyzedInstruction;
            this.registerNumber = i3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            PredecessorOverrideKey predecessorOverrideKey = (PredecessorOverrideKey) obj;
            if (g.a(Integer.valueOf(this.registerNumber), Integer.valueOf(predecessorOverrideKey.registerNumber)) && g.a(this.analyzedInstruction, predecessorOverrideKey.analyzedInstruction)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return g.b(this.analyzedInstruction, Integer.valueOf(this.registerNumber));
        }
    }

    public AnalyzedInstruction(@Nonnull MethodAnalyzer methodAnalyzer, @Nonnull Instruction instruction, int i3, int i16) {
        this.methodAnalyzer = methodAnalyzer;
        this.instruction = instruction;
        this.originalInstruction = instruction;
        this.instructionIndex = i3;
        this.postRegisterMap = new RegisterType[i16];
        this.preRegisterMap = new RegisterType[i16];
        RegisterType registerType = RegisterType.getRegisterType((byte) 0, (TypeProto) null);
        for (int i17 = 0; i17 < i16; i17++) {
            this.preRegisterMap[i17] = registerType;
            this.postRegisterMap[i17] = registerType;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean addPredecessor(AnalyzedInstruction analyzedInstruction) {
        return this.predecessors.add(analyzedInstruction);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addSuccessor(AnalyzedInstruction analyzedInstruction) {
        this.successors.add(analyzedInstruction);
    }

    public int getDestinationRegister() {
        if (this.instruction.getOpcode().setsRegister()) {
            return ((OneRegisterInstruction) this.instruction).getRegisterA();
        }
        throw new ExceptionWithContext("Cannot call getDestinationRegister() for an instruction that doesn't store a value", new Object[0]);
    }

    @Nonnull
    public Instruction getInstruction() {
        return this.instruction;
    }

    public int getInstructionIndex() {
        return this.instructionIndex;
    }

    @Nonnull
    protected RegisterType getMergedPreRegisterTypeFromPredecessors(int i3) {
        Iterator<AnalyzedInstruction> it = this.predecessors.iterator();
        RegisterType registerType = null;
        while (it.hasNext()) {
            RegisterType predecessorRegisterType = getPredecessorRegisterType(it.next(), i3);
            if (predecessorRegisterType != null) {
                if (registerType == null) {
                    registerType = predecessorRegisterType;
                } else {
                    registerType = predecessorRegisterType.merge(registerType);
                }
            }
        }
        if (registerType != null) {
            return registerType;
        }
        throw new IllegalStateException();
    }

    @Nonnull
    public Instruction getOriginalInstruction() {
        return this.originalInstruction;
    }

    @Nonnull
    public RegisterType getPostInstructionRegisterType(int i3) {
        return this.postRegisterMap[i3];
    }

    @Nonnull
    public RegisterType getPreInstructionRegisterType(int i3) {
        return this.preRegisterMap[i3];
    }

    public int getPredecessorCount() {
        return this.predecessors.size();
    }

    public RegisterType getPredecessorRegisterType(@Nonnull AnalyzedInstruction analyzedInstruction, int i3) {
        RegisterType registerType;
        Map<PredecessorOverrideKey, RegisterType> map = this.predecessorRegisterOverrides;
        if (map != null && (registerType = map.get(new PredecessorOverrideKey(analyzedInstruction, i3))) != null) {
            return registerType;
        }
        return analyzedInstruction.postRegisterMap[i3];
    }

    public SortedSet<AnalyzedInstruction> getPredecessors() {
        return Collections.unmodifiableSortedSet(this.predecessors);
    }

    public int getRegisterCount() {
        return this.postRegisterMap.length;
    }

    public List<Integer> getSetRegisters() {
        int startRegister;
        ArrayList h16 = Lists.h();
        if (this.instruction.getOpcode().setsRegister()) {
            h16.add(Integer.valueOf(getDestinationRegister()));
        }
        if (this.instruction.getOpcode().setsWideRegister()) {
            h16.add(Integer.valueOf(getDestinationRegister() + 1));
        }
        if (isInvokeInit()) {
            Instruction instruction = this.instruction;
            if (instruction instanceof FiveRegisterInstruction) {
                startRegister = ((FiveRegisterInstruction) instruction).getRegisterC();
            } else {
                startRegister = ((RegisterRangeInstruction) instruction).getStartRegister();
            }
            byte b16 = getPreInstructionRegisterType(startRegister).category;
            int i3 = 0;
            if (b16 != 16 && b16 != 17) {
                if (b16 == 0) {
                    while (true) {
                        RegisterType[] registerTypeArr = this.preRegisterMap;
                        if (i3 >= registerTypeArr.length) {
                            break;
                        }
                        byte b17 = registerTypeArr[i3].category;
                        if (b17 == 16 || b17 == 17) {
                            h16.add(Integer.valueOf(i3));
                        }
                        i3++;
                    }
                }
            } else {
                h16.add(Integer.valueOf(startRegister));
                RegisterType registerType = this.preRegisterMap[startRegister];
                while (true) {
                    RegisterType[] registerTypeArr2 = this.preRegisterMap;
                    if (i3 >= registerTypeArr2.length) {
                        break;
                    }
                    if (i3 != startRegister) {
                        RegisterType registerType2 = registerTypeArr2[i3];
                        if (registerType2.equals(registerType)) {
                            h16.add(Integer.valueOf(i3));
                        } else {
                            byte b18 = registerType2.category;
                            if ((b18 == 16 || b18 == 17) && this.postRegisterMap[i3].category == 0) {
                                h16.add(Integer.valueOf(i3));
                            }
                        }
                    }
                    i3++;
                }
            }
        }
        if (this.instructionIndex > 0 && this.methodAnalyzer.getClassPath().isArt() && getPredecessorCount() == 1 && (this.instruction.getOpcode() == Opcode.IF_EQZ || this.instruction.getOpcode() == Opcode.IF_NEZ)) {
            AnalyzedInstruction first = this.predecessors.first();
            if (first.instruction.getOpcode() == Opcode.INSTANCE_OF && MethodAnalyzer.canPropagateTypeAfterInstanceOf(first, this, this.methodAnalyzer.getClassPath())) {
                Instruction22c instruction22c = (Instruction22c) first.instruction;
                h16.add(Integer.valueOf(instruction22c.getRegisterB()));
                if (this.instructionIndex > 1) {
                    Iterator<AnalyzedInstruction> it = first.predecessors.iterator();
                    RegisterType registerType3 = null;
                    int i16 = -1;
                    while (it.hasNext()) {
                        AnalyzedInstruction next = it.next();
                        Opcode opcode = next.instruction.getOpcode();
                        if (opcode == Opcode.MOVE_OBJECT || opcode == Opcode.MOVE_OBJECT_16 || opcode == Opcode.MOVE_OBJECT_FROM16) {
                            TwoRegisterInstruction twoRegisterInstruction = (TwoRegisterInstruction) next.instruction;
                            RegisterType postInstructionRegisterType = next.getPostInstructionRegisterType(twoRegisterInstruction.getRegisterB());
                            if (twoRegisterInstruction.getRegisterA() == instruction22c.getRegisterB() && postInstructionRegisterType.type != null) {
                                if (registerType3 == null) {
                                    registerType3 = RegisterType.getRegisterType(this.methodAnalyzer.getClassPath(), (TypeReference) instruction22c.getReference());
                                }
                                if (MethodAnalyzer.isNotWideningConversion(postInstructionRegisterType, registerType3)) {
                                    if (i16 != -1) {
                                        if (i16 != twoRegisterInstruction.getRegisterB()) {
                                        }
                                    } else {
                                        i16 = twoRegisterInstruction.getRegisterB();
                                    }
                                }
                            }
                        }
                        i16 = -1;
                    }
                    if (i16 != -1) {
                        h16.add(Integer.valueOf(i16));
                    }
                }
            }
        }
        return h16;
    }

    @Nonnull
    public List<AnalyzedInstruction> getSuccessors() {
        return Collections.unmodifiableList(this.successors);
    }

    public boolean isBeginningInstruction() {
        if (this.predecessors.size() == 0 || this.predecessors.first().instructionIndex != -1) {
            return false;
        }
        return true;
    }

    public boolean isInvokeInit() {
        if (!this.instruction.getOpcode().canInitializeReference()) {
            return false;
        }
        Reference reference = ((ReferenceInstruction) this.instruction).getReference();
        if (!(reference instanceof MethodReference)) {
            return false;
        }
        return ((MethodReference) reference).getName().equals("<init>");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean mergeRegister(int i3, RegisterType registerType, BitSet bitSet, boolean z16) {
        RegisterType merge;
        RegisterType registerType2 = this.preRegisterMap[i3];
        if (z16) {
            merge = getMergedPreRegisterTypeFromPredecessors(i3);
        } else {
            merge = registerType2.merge(registerType);
        }
        if (merge.equals(registerType2)) {
            return false;
        }
        this.preRegisterMap[i3] = merge;
        bitSet.clear(this.instructionIndex);
        if (setsRegister(i3)) {
            return false;
        }
        this.postRegisterMap[i3] = merge;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean overridePredecessorRegisterType(@Nonnull AnalyzedInstruction analyzedInstruction, int i3, @Nonnull RegisterType registerType, BitSet bitSet) {
        if (this.predecessorRegisterOverrides == null) {
            this.predecessorRegisterOverrides = Maps.j();
        }
        this.predecessorRegisterOverrides.put(new PredecessorOverrideKey(analyzedInstruction, i3), registerType);
        RegisterType mergedPreRegisterTypeFromPredecessors = getMergedPreRegisterTypeFromPredecessors(i3);
        if (this.preRegisterMap[i3].equals(mergedPreRegisterTypeFromPredecessors)) {
            return false;
        }
        this.preRegisterMap[i3] = mergedPreRegisterTypeFromPredecessors;
        bitSet.clear(this.instructionIndex);
        if (setsRegister(i3) || this.postRegisterMap[i3].equals(mergedPreRegisterTypeFromPredecessors)) {
            return false;
        }
        this.postRegisterMap[i3] = mergedPreRegisterTypeFromPredecessors;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void restoreOdexedInstruction() {
        this.instruction = this.originalInstruction;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setDeodexedInstruction(Instruction instruction) {
        this.instruction = instruction;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean setPostRegisterType(int i3, RegisterType registerType) {
        if (this.postRegisterMap[i3].equals(registerType)) {
            return false;
        }
        this.postRegisterMap[i3] = registerType;
        return true;
    }

    public boolean setsRegister(int i3) {
        int startRegister;
        byte b16;
        if (isInvokeInit()) {
            Instruction instruction = this.instruction;
            if (instruction instanceof FiveRegisterInstruction) {
                startRegister = ((FiveRegisterInstruction) instruction).getRegisterC();
            } else {
                startRegister = ((RegisterRangeInstruction) instruction).getStartRegister();
            }
            RegisterType preInstructionRegisterType = getPreInstructionRegisterType(startRegister);
            if (preInstructionRegisterType.category == 0 && ((b16 = getPreInstructionRegisterType(i3).category) == 16 || b16 == 17)) {
                return true;
            }
            byte b17 = preInstructionRegisterType.category;
            if (b17 != 16 && b17 != 17) {
                return false;
            }
            if (i3 == startRegister) {
                return true;
            }
            return preInstructionRegisterType.equals(getPreInstructionRegisterType(i3));
        }
        if (this.instructionIndex > 0 && this.methodAnalyzer.getClassPath().isArt() && getPredecessorCount() == 1 && (this.instruction.getOpcode() == Opcode.IF_EQZ || this.instruction.getOpcode() == Opcode.IF_NEZ)) {
            AnalyzedInstruction first = this.predecessors.first();
            if (first.instruction.getOpcode() == Opcode.INSTANCE_OF && MethodAnalyzer.canPropagateTypeAfterInstanceOf(first, this, this.methodAnalyzer.getClassPath())) {
                Instruction22c instruction22c = (Instruction22c) first.instruction;
                if (i3 == instruction22c.getRegisterB()) {
                    return true;
                }
                if (this.instructionIndex > 1) {
                    Iterator<AnalyzedInstruction> it = first.predecessors.iterator();
                    RegisterType registerType = null;
                    int i16 = -1;
                    while (it.hasNext()) {
                        AnalyzedInstruction next = it.next();
                        Opcode opcode = next.instruction.getOpcode();
                        if (opcode == Opcode.MOVE_OBJECT || opcode == Opcode.MOVE_OBJECT_16 || opcode == Opcode.MOVE_OBJECT_FROM16) {
                            TwoRegisterInstruction twoRegisterInstruction = (TwoRegisterInstruction) next.instruction;
                            RegisterType postInstructionRegisterType = next.getPostInstructionRegisterType(twoRegisterInstruction.getRegisterB());
                            if (twoRegisterInstruction.getRegisterA() == instruction22c.getRegisterB() && postInstructionRegisterType.type != null) {
                                if (registerType == null) {
                                    registerType = RegisterType.getRegisterType(this.methodAnalyzer.getClassPath(), (TypeReference) instruction22c.getReference());
                                }
                                if (MethodAnalyzer.isNotWideningConversion(postInstructionRegisterType, registerType)) {
                                    if (i16 != -1) {
                                        if (i16 != twoRegisterInstruction.getRegisterB()) {
                                        }
                                    } else {
                                        i16 = twoRegisterInstruction.getRegisterB();
                                    }
                                }
                            }
                        }
                        i16 = -1;
                    }
                    if (i16 != -1 && i3 == i16) {
                        return true;
                    }
                }
            }
        }
        if (!this.instruction.getOpcode().setsRegister()) {
            return false;
        }
        int destinationRegister = getDestinationRegister();
        if (i3 == destinationRegister) {
            return true;
        }
        if (!this.instruction.getOpcode().setsWideRegister() || i3 != destinationRegister + 1) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Comparable
    public int compareTo(@Nonnull AnalyzedInstruction analyzedInstruction) {
        int i3 = this.instructionIndex;
        int i16 = analyzedInstruction.instructionIndex;
        if (i3 < i16) {
            return -1;
        }
        return i3 == i16 ? 0 : 1;
    }
}
