package org.jf.dexlib2.writer;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.collect.q;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.CharSequence;
import java.lang.Comparable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.Adler32;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.AccessFlags;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.HiddenApiRestriction;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.Opcodes;
import org.jf.dexlib2.base.BaseAnnotation;
import org.jf.dexlib2.base.BaseAnnotationElement;
import org.jf.dexlib2.builder.BuilderInstruction;
import org.jf.dexlib2.builder.MutableMethodImplementation;
import org.jf.dexlib2.builder.instruction.BuilderInstruction31c;
import org.jf.dexlib2.dexbacked.raw.HeaderItem;
import org.jf.dexlib2.formatter.DexFormatter;
import org.jf.dexlib2.iface.Annotation;
import org.jf.dexlib2.iface.AnnotationElement;
import org.jf.dexlib2.iface.ExceptionHandler;
import org.jf.dexlib2.iface.TryBlock;
import org.jf.dexlib2.iface.debug.DebugItem;
import org.jf.dexlib2.iface.debug.LineNumber;
import org.jf.dexlib2.iface.instruction.Instruction;
import org.jf.dexlib2.iface.instruction.OneRegisterInstruction;
import org.jf.dexlib2.iface.instruction.ReferenceInstruction;
import org.jf.dexlib2.iface.instruction.VariableRegisterInstruction;
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
import org.jf.dexlib2.iface.reference.StringReference;
import org.jf.dexlib2.iface.reference.TypeReference;
import org.jf.dexlib2.util.InstructionUtil;
import org.jf.dexlib2.util.MethodUtil;
import org.jf.dexlib2.writer.AnnotationSection;
import org.jf.dexlib2.writer.AnnotationSetSection;
import org.jf.dexlib2.writer.CallSiteSection;
import org.jf.dexlib2.writer.ClassSection;
import org.jf.dexlib2.writer.EncodedArraySection;
import org.jf.dexlib2.writer.FieldSection;
import org.jf.dexlib2.writer.MethodHandleSection;
import org.jf.dexlib2.writer.MethodSection;
import org.jf.dexlib2.writer.ProtoSection;
import org.jf.dexlib2.writer.StringSection;
import org.jf.dexlib2.writer.TypeListSection;
import org.jf.dexlib2.writer.TypeSection;
import org.jf.dexlib2.writer.io.DeferredOutputStream;
import org.jf.dexlib2.writer.io.DeferredOutputStreamFactory;
import org.jf.dexlib2.writer.io.DexDataStore;
import org.jf.dexlib2.writer.io.MemoryDeferredOutputStream;
import org.jf.dexlib2.writer.util.TryListBuilder;
import org.jf.util.ExceptionWithContext;
import s1.c;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class DexWriter<StringKey extends CharSequence, StringRef extends StringReference, TypeKey extends CharSequence, TypeRef extends TypeReference, ProtoRefKey extends MethodProtoReference, FieldRefKey extends FieldReference, MethodRefKey extends MethodReference, ClassKey extends Comparable<? super ClassKey>, CallSiteKey extends CallSiteReference, MethodHandleKey extends MethodHandleReference, AnnotationKey extends Annotation, AnnotationSetKey, TypeListKey, FieldKey, MethodKey, EncodedArrayKey, EncodedValue, AnnotationElement extends AnnotationElement, StringSectionType extends StringSection<StringKey, StringRef>, TypeSectionType extends TypeSection<StringKey, TypeKey, TypeRef>, ProtoSectionType extends ProtoSection<StringKey, TypeKey, ProtoRefKey, TypeListKey>, FieldSectionType extends FieldSection<StringKey, TypeKey, FieldRefKey, FieldKey>, MethodSectionType extends MethodSection<StringKey, TypeKey, ProtoRefKey, MethodRefKey, MethodKey>, ClassSectionType extends ClassSection<StringKey, TypeKey, TypeListKey, ClassKey, FieldKey, MethodKey, AnnotationSetKey, EncodedArrayKey>, CallSiteSectionType extends CallSiteSection<CallSiteKey, EncodedArrayKey>, MethodHandleSectionType extends MethodHandleSection<MethodHandleKey, FieldRefKey, MethodRefKey>, TypeListSectionType extends TypeListSection<TypeKey, TypeListKey>, AnnotationSectionType extends AnnotationSection<StringKey, TypeKey, AnnotationKey, AnnotationElement, EncodedValue>, AnnotationSetSectionType extends AnnotationSetSection<AnnotationKey, AnnotationSetKey>, EncodedArraySectionType extends EncodedArraySection<EncodedArrayKey, EncodedValue>> {
    public static final int MAX_POOL_SIZE = 65536;
    public static final int NO_INDEX = -1;
    public static final int NO_OFFSET = 0;
    private static Comparator<Map.Entry> toStringKeyComparator = new Comparator<Map.Entry>() { // from class: org.jf.dexlib2.writer.DexWriter.2
        @Override // java.util.Comparator
        public int compare(Map.Entry entry, Map.Entry entry2) {
            return entry.getKey().toString().compareTo(entry2.getKey().toString());
        }
    };
    public final AnnotationSectionType annotationSection;
    public final AnnotationSetSectionType annotationSetSection;
    public final CallSiteSectionType callSiteSection;
    public final ClassSectionType classSection;
    public final EncodedArraySectionType encodedArraySection;
    public final FieldSectionType fieldSection;
    public final MethodHandleSectionType methodHandleSection;
    public final MethodSectionType methodSection;
    protected final Opcodes opcodes;
    private final IndexSection<?>[] overflowableSections;
    public final ProtoSectionType protoSection;
    public final StringSectionType stringSection;
    public final TypeListSectionType typeListSection;
    public final TypeSectionType typeSection;
    protected int stringIndexSectionOffset = 0;
    protected int typeSectionOffset = 0;
    protected int protoSectionOffset = 0;
    protected int fieldSectionOffset = 0;
    protected int methodSectionOffset = 0;
    protected int classIndexSectionOffset = 0;
    protected int callSiteSectionOffset = 0;
    protected int methodHandleSectionOffset = 0;
    protected int stringDataSectionOffset = 0;
    protected int classDataSectionOffset = 0;
    protected int typeListSectionOffset = 0;
    protected int encodedArraySectionOffset = 0;
    protected int annotationSectionOffset = 0;
    protected int annotationSetSectionOffset = 0;
    protected int annotationSetRefSectionOffset = 0;
    protected int annotationDirectorySectionOffset = 0;
    protected int debugSectionOffset = 0;
    protected int codeSectionOffset = 0;
    protected int hiddenApiRestrictionsOffset = 0;
    protected int mapSectionOffset = 0;
    protected boolean hasHiddenApiRestrictions = false;
    protected int numAnnotationSetRefItems = 0;
    protected int numAnnotationDirectoryItems = 0;
    protected int numDebugInfoItems = 0;
    protected int numCodeItemItems = 0;
    protected int numClassDataItems = 0;
    private Comparator<Map.Entry<? extends CallSiteKey, Integer>> callSiteComparator = (Comparator<Map.Entry<? extends CallSiteKey, Integer>>) new Comparator<Map.Entry<? extends CallSiteKey, Integer>>() { // from class: org.jf.dexlib2.writer.DexWriter.1
        @Override // java.util.Comparator
        public int compare(Map.Entry<? extends CallSiteKey, Integer> entry, Map.Entry<? extends CallSiteKey, Integer> entry2) {
            DexWriter dexWriter = DexWriter.this;
            int itemOffset = dexWriter.encodedArraySection.getItemOffset(dexWriter.callSiteSection.getEncodedCallSite(entry.getKey()));
            DexWriter dexWriter2 = DexWriter.this;
            return c.a(itemOffset, dexWriter2.encodedArraySection.getItemOffset(dexWriter2.callSiteSection.getEncodedCallSite(entry2.getKey())));
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: org.jf.dexlib2.writer.DexWriter$4, reason: invalid class name */
    /* loaded from: classes29.dex */
    public static /* synthetic */ class AnonymousClass4 {
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
                $SwitchMap$org$jf$dexlib2$Format[Format.Format35mi.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format35ms.ordinal()] = 27;
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
                $SwitchMap$org$jf$dexlib2$Format[Format.ArrayPayload.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.PackedSwitchPayload.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.SparseSwitchPayload.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class CodeItemOffset<MethodKey> {
        int codeOffset;

        @Nonnull
        MethodKey method;

        CodeItemOffset(@Nonnull MethodKey methodkey, int i3) {
            this.codeOffset = i3;
            this.method = methodkey;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class InternalEncodedValueWriter extends EncodedValueWriter<StringKey, TypeKey, FieldRefKey, MethodRefKey, AnnotationElement, ProtoRefKey, MethodHandleKey, EncodedValue> {
        @Override // org.jf.dexlib2.writer.EncodedValueWriter
        protected void writeEncodedValue(@Nonnull EncodedValue encodedvalue) throws IOException {
            DexWriter.this.writeEncodedValue(this, encodedvalue);
        }

        InternalEncodedValueWriter(@Nonnull DexDataWriter dexDataWriter) {
            super(dexDataWriter, DexWriter.this.stringSection, DexWriter.this.typeSection, DexWriter.this.fieldSection, DexWriter.this.methodSection, DexWriter.this.protoSection, DexWriter.this.methodHandleSection, DexWriter.this.annotationSection);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class RestrictionsWriter {
        private final DexDataStore dataStore;
        private final DexDataWriter offsetsWriter;
        private final DexDataWriter restrictionsWriter;
        private final int startOffset;
        private boolean writeRestrictionsForClass = false;
        private int pendingBlankEntries = 0;

        public RestrictionsWriter(DexDataStore dexDataStore, DexDataWriter dexDataWriter, int i3) throws IOException {
            this.startOffset = dexDataWriter.getPosition();
            this.dataStore = dexDataStore;
            this.restrictionsWriter = dexDataWriter;
            int i16 = i3 * 4;
            dexDataWriter.writeInt(0);
            this.offsetsWriter = DexWriter.outputAt(dexDataStore, dexDataWriter.getPosition());
            for (int i17 = 0; i17 < i16; i17++) {
                this.restrictionsWriter.write(0);
            }
            this.restrictionsWriter.flush();
        }

        private void addBlankEntry() throws IOException {
            if (this.writeRestrictionsForClass) {
                this.restrictionsWriter.writeUleb128(HiddenApiRestriction.WHITELIST.getValue());
            } else {
                this.pendingBlankEntries++;
            }
        }

        public void close() throws IOException {
            this.offsetsWriter.close();
            DexDataWriter dexDataWriter = null;
            try {
                dexDataWriter = DexWriter.outputAt(this.dataStore, this.startOffset);
                dexDataWriter.writeInt(this.restrictionsWriter.getPosition() - this.startOffset);
                dexDataWriter.close();
            } catch (Throwable th5) {
                if (dexDataWriter != null) {
                    dexDataWriter.close();
                }
                throw th5;
            }
        }

        public void finishClass() throws IOException {
            if (!this.writeRestrictionsForClass) {
                this.offsetsWriter.writeInt(0);
            }
            this.writeRestrictionsForClass = false;
            this.pendingBlankEntries = 0;
        }

        public void writeRestriction(@Nonnull Set<HiddenApiRestriction> set) throws IOException {
            if (set.isEmpty()) {
                addBlankEntry();
                return;
            }
            if (!this.writeRestrictionsForClass) {
                this.writeRestrictionsForClass = true;
                this.offsetsWriter.writeInt(this.restrictionsWriter.getPosition() - this.startOffset);
                for (int i3 = 0; i3 < this.pendingBlankEntries; i3++) {
                    this.restrictionsWriter.writeUleb128(HiddenApiRestriction.WHITELIST.getValue());
                }
                this.pendingBlankEntries = 0;
            }
            this.restrictionsWriter.writeUleb128(HiddenApiRestriction.combineFlags(set));
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public abstract class SectionProvider {
        public SectionProvider() {
        }

        @Nonnull
        public abstract AnnotationSectionType getAnnotationSection();

        @Nonnull
        public abstract AnnotationSetSectionType getAnnotationSetSection();

        @Nonnull
        public abstract CallSiteSectionType getCallSiteSection();

        @Nonnull
        public abstract ClassSectionType getClassSection();

        @Nonnull
        public abstract EncodedArraySectionType getEncodedArraySection();

        @Nonnull
        public abstract FieldSectionType getFieldSection();

        @Nonnull
        public abstract MethodHandleSectionType getMethodHandleSection();

        @Nonnull
        public abstract MethodSectionType getMethodSection();

        @Nonnull
        public abstract ProtoSectionType getProtoSection();

        @Nonnull
        public abstract StringSectionType getStringSection();

        @Nonnull
        public abstract TypeListSectionType getTypeListSection();

        @Nonnull
        public abstract TypeSectionType getTypeSection();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DexWriter(Opcodes opcodes) {
        this.opcodes = opcodes;
        DexWriter<StringKey, StringRef, TypeKey, TypeRef, ProtoRefKey, FieldRefKey, MethodRefKey, ClassKey, CallSiteKey, MethodHandleKey, AnnotationKey, AnnotationSetKey, TypeListKey, FieldKey, MethodKey, EncodedArrayKey, EncodedValue, AnnotationElement, StringSectionType, TypeSectionType, ProtoSectionType, FieldSectionType, MethodSectionType, ClassSectionType, CallSiteSectionType, MethodHandleSectionType, TypeListSectionType, AnnotationSectionType, AnnotationSetSectionType, EncodedArraySectionType>.SectionProvider sectionProvider = getSectionProvider();
        this.stringSection = (StringSectionType) sectionProvider.getStringSection();
        TypeSectionType typesectiontype = (TypeSectionType) sectionProvider.getTypeSection();
        this.typeSection = typesectiontype;
        ProtoSectionType protosectiontype = (ProtoSectionType) sectionProvider.getProtoSection();
        this.protoSection = protosectiontype;
        FieldSectionType fieldsectiontype = (FieldSectionType) sectionProvider.getFieldSection();
        this.fieldSection = fieldsectiontype;
        MethodSectionType methodsectiontype = (MethodSectionType) sectionProvider.getMethodSection();
        this.methodSection = methodsectiontype;
        this.classSection = (ClassSectionType) sectionProvider.getClassSection();
        CallSiteSectionType callsitesectiontype = (CallSiteSectionType) sectionProvider.getCallSiteSection();
        this.callSiteSection = callsitesectiontype;
        MethodHandleSectionType methodhandlesectiontype = (MethodHandleSectionType) sectionProvider.getMethodHandleSection();
        this.methodHandleSection = methodhandlesectiontype;
        this.typeListSection = (TypeListSectionType) sectionProvider.getTypeListSection();
        this.annotationSection = (AnnotationSectionType) sectionProvider.getAnnotationSection();
        this.annotationSetSection = (AnnotationSetSectionType) sectionProvider.getAnnotationSetSection();
        this.encodedArraySection = (EncodedArraySectionType) sectionProvider.getEncodedArraySection();
        this.overflowableSections = new IndexSection[]{typesectiontype, protosectiontype, fieldsectiontype, methodsectiontype, callsitesectiontype, methodhandlesectiontype};
    }

    private int calcNumItems() {
        int i3;
        if (this.stringSection.getItems().size() > 0) {
            i3 = 3;
        } else {
            i3 = 1;
        }
        if (this.typeSection.getItems().size() > 0) {
            i3++;
        }
        if (this.protoSection.getItems().size() > 0) {
            i3++;
        }
        if (this.fieldSection.getItems().size() > 0) {
            i3++;
        }
        if (this.methodSection.getItems().size() > 0) {
            i3++;
        }
        if (this.callSiteSection.getItems().size() > 0) {
            i3++;
        }
        if (this.methodHandleSection.getItems().size() > 0) {
            i3++;
        }
        if (this.typeListSection.getItems().size() > 0) {
            i3++;
        }
        if (this.encodedArraySection.getItems().size() > 0) {
            i3++;
        }
        if (this.annotationSection.getItems().size() > 0) {
            i3++;
        }
        if (this.annotationSetSection.getItems().size() > 0 || shouldCreateEmptyAnnotationSet()) {
            i3++;
        }
        if (this.numAnnotationSetRefItems > 0) {
            i3++;
        }
        if (this.numAnnotationDirectoryItems > 0) {
            i3++;
        }
        if (this.numDebugInfoItems > 0) {
            i3++;
        }
        if (this.numCodeItemItems > 0) {
            i3++;
        }
        if (this.classSection.getItems().size() > 0) {
            i3++;
        }
        if (this.numClassDataItems > 0) {
            i3++;
        }
        if (shouldWriteHiddenApiRestrictions()) {
            i3++;
        }
        return i3 + 1;
    }

    private static <T extends Comparable<? super T>> Comparator<Map.Entry<? extends T, ?>> comparableKeyComparator() {
        return (Comparator<Map.Entry<? extends T, ?>>) new Comparator<Map.Entry<? extends T, ?>>() { // from class: org.jf.dexlib2.writer.DexWriter.3
            @Override // java.util.Comparator
            public int compare(Map.Entry<? extends T, ?> entry, Map.Entry<? extends T, ?> entry2) {
                return ((Comparable) entry.getKey()).compareTo(entry2.getKey());
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void fixInstructions(@Nonnull MutableMethodImplementation mutableMethodImplementation) {
        List<BuilderInstruction> instructions = mutableMethodImplementation.getInstructions();
        for (int i3 = 0; i3 < instructions.size(); i3++) {
            Instruction instruction = instructions.get(i3);
            if (instruction.getOpcode() == Opcode.CONST_STRING) {
                ReferenceInstruction referenceInstruction = (ReferenceInstruction) instruction;
                if (this.stringSection.getItemIndex((StringReference) referenceInstruction.getReference()) >= 65536) {
                    mutableMethodImplementation.replaceInstruction(i3, new BuilderInstruction31c(Opcode.CONST_STRING_JUMBO, ((OneRegisterInstruction) instruction).getRegisterA(), referenceInstruction.getReference()));
                }
            }
        }
    }

    private int getDataSectionOffset() {
        return (this.stringSection.getItemCount() * 4) + 112 + (this.typeSection.getItemCount() * 4) + (this.protoSection.getItemCount() * 12) + (this.fieldSection.getItemCount() * 8) + (this.methodSection.getItemCount() * 8) + (this.classSection.getItemCount() * 32) + (this.callSiteSection.getItemCount() * 4) + (this.methodHandleSection.getItemCount() * 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static DexDataWriter outputAt(DexDataStore dexDataStore, int i3) throws IOException {
        return new DexDataWriter(dexDataStore.outputAt(i3), i3);
    }

    private boolean shouldCreateEmptyAnnotationSet() {
        if (this.opcodes.api < 17) {
            return true;
        }
        return false;
    }

    private boolean shouldWriteHiddenApiRestrictions() {
        if (this.hasHiddenApiRestrictions && this.opcodes.api >= 29) {
            return true;
        }
        return false;
    }

    private void updateChecksum(@Nonnull DexDataStore dexDataStore) throws IOException {
        Adler32 adler32 = new Adler32();
        byte[] bArr = new byte[4096];
        InputStream readAt = dexDataStore.readAt(12);
        for (int read = readAt.read(bArr); read >= 0; read = readAt.read(bArr)) {
            adler32.update(bArr, 0, read);
        }
        OutputStream outputAt = dexDataStore.outputAt(8);
        DexDataWriter.writeInt(outputAt, (int) adler32.getValue());
        outputAt.close();
    }

    private void updateSignature(@Nonnull DexDataStore dexDataStore) throws IOException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA1);
            byte[] bArr = new byte[4096];
            InputStream readAt = dexDataStore.readAt(32);
            for (int read = readAt.read(bArr); read >= 0; read = readAt.read(bArr)) {
                messageDigest.update(bArr, 0, read);
            }
            byte[] digest = messageDigest.digest();
            if (digest.length == 20) {
                OutputStream outputAt = dexDataStore.outputAt(12);
                outputAt.write(digest);
                outputAt.close();
            } else {
                throw new RuntimeException("unexpected digest write: " + digest.length + " bytes");
            }
        } catch (NoSuchAlgorithmException e16) {
            throw new RuntimeException(e16);
        }
    }

    private void writeAnnotationDirectories(@Nonnull DexDataWriter dexDataWriter) throws IOException {
        dexDataWriter.align();
        this.annotationDirectorySectionOffset = dexDataWriter.getPosition();
        HashMap j3 = Maps.j();
        ByteBuffer allocate = ByteBuffer.allocate(65536);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        for (Comparable comparable : this.classSection.getSortedClasses()) {
            Collection<? extends FieldKey> sortedFields = this.classSection.getSortedFields(comparable);
            Collection<? extends MethodKey> sortedMethods = this.classSection.getSortedMethods(comparable);
            int size = (sortedFields.size() * 8) + (sortedMethods.size() * 16);
            if (size > allocate.capacity()) {
                allocate = ByteBuffer.allocate(size);
                allocate.order(ByteOrder.LITTLE_ENDIAN);
            }
            allocate.clear();
            int i3 = 0;
            for (FieldKey fieldkey : sortedFields) {
                Object fieldAnnotations = this.classSection.getFieldAnnotations(fieldkey);
                if (fieldAnnotations != null) {
                    i3++;
                    allocate.putInt(this.fieldSection.getFieldIndex(fieldkey));
                    allocate.putInt(this.annotationSetSection.getItemOffset(fieldAnnotations));
                }
            }
            int i16 = 0;
            for (MethodKey methodkey : sortedMethods) {
                Object methodAnnotations = this.classSection.getMethodAnnotations(methodkey);
                if (methodAnnotations != null) {
                    i16++;
                    allocate.putInt(this.methodSection.getMethodIndex(methodkey));
                    allocate.putInt(this.annotationSetSection.getItemOffset(methodAnnotations));
                }
            }
            int i17 = 0;
            for (MethodKey methodkey2 : sortedMethods) {
                int annotationSetRefListOffset = this.classSection.getAnnotationSetRefListOffset(methodkey2);
                if (annotationSetRefListOffset != 0) {
                    i17++;
                    allocate.putInt(this.methodSection.getMethodIndex(methodkey2));
                    allocate.putInt(annotationSetRefListOffset);
                }
            }
            Object classAnnotations = this.classSection.getClassAnnotations(comparable);
            if (i3 == 0 && i16 == 0 && i17 == 0) {
                if (classAnnotations != null) {
                    Integer num = (Integer) j3.get(classAnnotations);
                    if (num != null) {
                        this.classSection.setAnnotationDirectoryOffset(comparable, num.intValue());
                    } else {
                        j3.put(classAnnotations, Integer.valueOf(dexDataWriter.getPosition()));
                    }
                }
            }
            this.numAnnotationDirectoryItems++;
            this.classSection.setAnnotationDirectoryOffset(comparable, dexDataWriter.getPosition());
            dexDataWriter.writeInt(this.annotationSetSection.getNullableItemOffset(classAnnotations));
            dexDataWriter.writeInt(i3);
            dexDataWriter.writeInt(i16);
            dexDataWriter.writeInt(i17);
            dexDataWriter.write(allocate.array(), 0, allocate.position());
        }
    }

    private void writeAnnotationSetRefs(@Nonnull DexDataWriter dexDataWriter) throws IOException {
        dexDataWriter.align();
        this.annotationSetRefSectionOffset = dexDataWriter.getPosition();
        HashMap j3 = Maps.j();
        Iterator it = this.classSection.getSortedClasses().iterator();
        while (it.hasNext()) {
            for (MethodKey methodkey : this.classSection.getSortedMethods((Comparable) it.next())) {
                List<? extends AnnotationSetKey> parameterAnnotations = this.classSection.getParameterAnnotations(methodkey);
                if (parameterAnnotations != null) {
                    Integer num = (Integer) j3.get(parameterAnnotations);
                    if (num != null) {
                        this.classSection.setAnnotationSetRefListOffset(methodkey, num.intValue());
                    } else {
                        dexDataWriter.align();
                        int position = dexDataWriter.getPosition();
                        this.classSection.setAnnotationSetRefListOffset(methodkey, position);
                        j3.put(parameterAnnotations, Integer.valueOf(position));
                        this.numAnnotationSetRefItems++;
                        dexDataWriter.writeInt(parameterAnnotations.size());
                        for (AnnotationSetKey annotationsetkey : parameterAnnotations) {
                            if (this.annotationSetSection.getAnnotations(annotationsetkey).size() > 0) {
                                dexDataWriter.writeInt(this.annotationSetSection.getItemOffset(annotationsetkey));
                            } else if (shouldCreateEmptyAnnotationSet()) {
                                dexDataWriter.writeInt(this.annotationSetSectionOffset);
                            } else {
                                dexDataWriter.writeInt(0);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void writeAnnotationSets(@Nonnull DexDataWriter dexDataWriter) throws IOException {
        dexDataWriter.align();
        this.annotationSetSectionOffset = dexDataWriter.getPosition();
        if (shouldCreateEmptyAnnotationSet()) {
            dexDataWriter.writeInt(0);
        }
        for (Map.Entry entry : this.annotationSetSection.getItems()) {
            ImmutableList immutableSortedCopy = Ordering.from(BaseAnnotation.BY_TYPE).immutableSortedCopy(this.annotationSetSection.getAnnotations(entry.getKey()));
            dexDataWriter.align();
            entry.setValue(Integer.valueOf(dexDataWriter.getPosition()));
            dexDataWriter.writeInt(immutableSortedCopy.size());
            Iterator<E> it = immutableSortedCopy.iterator();
            while (it.hasNext()) {
                dexDataWriter.writeInt(this.annotationSection.getItemOffset((Annotation) it.next()));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void writeAnnotations(@Nonnull DexDataWriter dexDataWriter) throws IOException {
        InternalEncodedValueWriter internalEncodedValueWriter = new InternalEncodedValueWriter(dexDataWriter);
        this.annotationSectionOffset = dexDataWriter.getPosition();
        for (Map.Entry entry : this.annotationSection.getItems()) {
            entry.setValue(Integer.valueOf(dexDataWriter.getPosition()));
            Annotation annotation = (Annotation) entry.getKey();
            dexDataWriter.writeUbyte(this.annotationSection.getVisibility(annotation));
            dexDataWriter.writeUleb128(this.typeSection.getItemIndex((CharSequence) this.annotationSection.getType(annotation)));
            ImmutableList<AnnotationElement> immutableSortedCopy = Ordering.from(BaseAnnotationElement.BY_NAME).immutableSortedCopy(this.annotationSection.getElements(annotation));
            dexDataWriter.writeUleb128(immutableSortedCopy.size());
            for (AnnotationElement annotationElement : immutableSortedCopy) {
                dexDataWriter.writeUleb128(this.stringSection.getItemIndex((CharSequence) this.annotationSection.getElementName(annotationElement)));
                writeEncodedValue(internalEncodedValueWriter, this.annotationSection.getElementValue(annotationElement));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void writeCallSites(DexDataWriter dexDataWriter) throws IOException {
        this.callSiteSectionOffset = dexDataWriter.getPosition();
        ArrayList<Map.Entry> i3 = Lists.i(this.callSiteSection.getItems());
        Collections.sort(i3, this.callSiteComparator);
        int i16 = 0;
        for (Map.Entry entry : i3) {
            entry.setValue(Integer.valueOf(i16));
            dexDataWriter.writeInt(this.encodedArraySection.getItemOffset(this.callSiteSection.getEncodedCallSite((CallSiteReference) entry.getKey())));
            i16++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int writeClass(@Nonnull DexDataWriter dexDataWriter, @Nonnull DexDataWriter dexDataWriter2, int i3, @Nullable Map.Entry<? extends ClassKey, Integer> entry) throws IOException {
        boolean z16;
        if (entry == null) {
            return i3;
        }
        if (entry.getValue().intValue() != -1) {
            return i3;
        }
        ClassKey key = entry.getKey();
        entry.setValue(0);
        ClassSectionType classsectiontype = this.classSection;
        int writeClass = writeClass(dexDataWriter, dexDataWriter2, i3, classsectiontype.getClassEntryByType(classsectiontype.getSuperclass(key)));
        Iterator it = this.typeListSection.getTypes(this.classSection.getInterfaces(key)).iterator();
        while (it.hasNext()) {
            writeClass = writeClass(dexDataWriter, dexDataWriter2, writeClass, this.classSection.getClassEntryByType((CharSequence) it.next()));
        }
        int i16 = writeClass + 1;
        entry.setValue(Integer.valueOf(writeClass));
        dexDataWriter.writeInt(this.typeSection.getItemIndex(this.classSection.getType(key)));
        dexDataWriter.writeInt(this.classSection.getAccessFlags(key));
        dexDataWriter.writeInt(this.typeSection.getNullableItemIndex(this.classSection.getSuperclass(key)));
        dexDataWriter.writeInt(this.typeListSection.getNullableItemOffset(this.classSection.getInterfaces(key)));
        dexDataWriter.writeInt(this.stringSection.getNullableItemIndex(this.classSection.getSourceFile(key)));
        dexDataWriter.writeInt(this.classSection.getAnnotationDirectoryOffset(key));
        Collection<? extends FieldKey> sortedStaticFields = this.classSection.getSortedStaticFields(key);
        Collection<? extends FieldKey> sortedInstanceFields = this.classSection.getSortedInstanceFields(key);
        Collection<? extends MethodKey> sortedDirectMethods = this.classSection.getSortedDirectMethods(key);
        Collection<? extends MethodKey> sortedVirtualMethods = this.classSection.getSortedVirtualMethods(key);
        if (sortedStaticFields.size() <= 0 && sortedInstanceFields.size() <= 0 && sortedDirectMethods.size() <= 0 && sortedVirtualMethods.size() <= 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            dexDataWriter.writeInt(dexDataWriter2.getPosition());
        } else {
            dexDataWriter.writeInt(0);
        }
        Object staticInitializers = this.classSection.getStaticInitializers(key);
        if (staticInitializers != null) {
            dexDataWriter.writeInt(this.encodedArraySection.getItemOffset(staticInitializers));
        } else {
            dexDataWriter.writeInt(0);
        }
        if (z16) {
            this.numClassDataItems++;
            dexDataWriter2.writeUleb128(sortedStaticFields.size());
            dexDataWriter2.writeUleb128(sortedInstanceFields.size());
            dexDataWriter2.writeUleb128(sortedDirectMethods.size());
            dexDataWriter2.writeUleb128(sortedVirtualMethods.size());
            writeEncodedFields(dexDataWriter2, sortedStaticFields);
            writeEncodedFields(dexDataWriter2, sortedInstanceFields);
            writeEncodedMethods(dexDataWriter2, sortedDirectMethods);
            writeEncodedMethods(dexDataWriter2, sortedVirtualMethods);
        }
        return i16;
    }

    private void writeClasses(@Nonnull DexDataStore dexDataStore, @Nonnull DexDataWriter dexDataWriter, @Nonnull DexDataWriter dexDataWriter2) throws IOException {
        this.classIndexSectionOffset = dexDataWriter.getPosition();
        this.classDataSectionOffset = dexDataWriter2.getPosition();
        ArrayList<Map.Entry> i3 = Lists.i(this.classSection.getItems());
        Collections.sort(i3, comparableKeyComparator());
        Iterator it = i3.iterator();
        int i16 = 0;
        while (it.hasNext()) {
            i16 = writeClass(dexDataWriter, dexDataWriter2, i16, (Map.Entry) it.next());
        }
        if (!shouldWriteHiddenApiRestrictions()) {
            return;
        }
        this.hiddenApiRestrictionsOffset = dexDataWriter2.getPosition();
        RestrictionsWriter restrictionsWriter = new RestrictionsWriter(dexDataStore, dexDataWriter2, i3.size());
        try {
            for (Map.Entry entry : i3) {
                Iterator<? extends FieldKey> it5 = this.classSection.getSortedStaticFields((Comparable) entry.getKey()).iterator();
                while (it5.hasNext()) {
                    restrictionsWriter.writeRestriction(this.classSection.getFieldHiddenApiRestrictions(it5.next()));
                }
                Iterator<? extends FieldKey> it6 = this.classSection.getSortedInstanceFields((Comparable) entry.getKey()).iterator();
                while (it6.hasNext()) {
                    restrictionsWriter.writeRestriction(this.classSection.getFieldHiddenApiRestrictions(it6.next()));
                }
                Iterator<? extends MethodKey> it7 = this.classSection.getSortedDirectMethods((Comparable) entry.getKey()).iterator();
                while (it7.hasNext()) {
                    restrictionsWriter.writeRestriction(this.classSection.getMethodHiddenApiRestrictions(it7.next()));
                }
                Iterator<? extends MethodKey> it8 = this.classSection.getSortedVirtualMethods((Comparable) entry.getKey()).iterator();
                while (it8.hasNext()) {
                    restrictionsWriter.writeRestriction(this.classSection.getMethodHiddenApiRestrictions(it8.next()));
                }
                restrictionsWriter.finishClass();
            }
        } finally {
            restrictionsWriter.close();
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x00e1. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    private int writeCodeItem(@Nonnull DexDataWriter dexDataWriter, @Nonnull ByteArrayOutputStream byteArrayOutputStream, @Nonnull MethodKey methodkey, @Nonnull List<? extends TryBlock<? extends ExceptionHandler>> list, @Nullable Iterable<? extends Instruction> iterable, int i3) throws IOException {
        int parameterRegisterCount;
        if (iterable == null && i3 == 0) {
            return -1;
        }
        this.numCodeItemItems++;
        dexDataWriter.align();
        int position = dexDataWriter.getPosition();
        dexDataWriter.writeUshort(this.classSection.getRegisterCount(methodkey));
        dexDataWriter.writeUshort(MethodUtil.getParameterRegisterCount((Collection<? extends CharSequence>) this.typeListSection.getTypes(this.protoSection.getParameters(this.methodSection.getPrototype(methodkey))), AccessFlags.STATIC.isSet(this.classSection.getMethodAccessFlags(methodkey))));
        if (iterable != null) {
            List<TryBlock> massageTryBlocks = TryListBuilder.massageTryBlocks(list);
            int i16 = 0;
            int i17 = 0;
            for (Instruction instruction : iterable) {
                i17 += instruction.getCodeUnits();
                if (instruction.getOpcode().referenceType == 3) {
                    MethodReference methodReference = (MethodReference) ((ReferenceInstruction) instruction).getReference();
                    Opcode opcode = instruction.getOpcode();
                    if (InstructionUtil.isInvokePolymorphic(opcode)) {
                        parameterRegisterCount = ((VariableRegisterInstruction) instruction).getRegisterCount();
                    } else {
                        parameterRegisterCount = MethodUtil.getParameterRegisterCount(methodReference, InstructionUtil.isInvokeStatic(opcode));
                    }
                    if (parameterRegisterCount > i16) {
                        i16 = parameterRegisterCount;
                    }
                }
            }
            dexDataWriter.writeUshort(i16);
            dexDataWriter.writeUshort(massageTryBlocks.size());
            dexDataWriter.writeInt(i3);
            InstructionWriter makeInstructionWriter = InstructionWriter.makeInstructionWriter(this.opcodes, dexDataWriter, this.stringSection, this.typeSection, this.fieldSection, this.methodSection, this.protoSection, this.methodHandleSection, this.callSiteSection);
            dexDataWriter.writeInt(i17);
            int i18 = 0;
            for (Instruction instruction2 : iterable) {
                try {
                    switch (AnonymousClass4.$SwitchMap$org$jf$dexlib2$Format[instruction2.getOpcode().format.ordinal()]) {
                        case 1:
                            makeInstructionWriter.write((Instruction10t) instruction2);
                            i18 += instruction2.getCodeUnits();
                        case 2:
                            makeInstructionWriter.write((Instruction10x) instruction2);
                            i18 += instruction2.getCodeUnits();
                        case 3:
                            makeInstructionWriter.write((Instruction11n) instruction2);
                            i18 += instruction2.getCodeUnits();
                        case 4:
                            makeInstructionWriter.write((Instruction11x) instruction2);
                            i18 += instruction2.getCodeUnits();
                        case 5:
                            makeInstructionWriter.write((Instruction12x) instruction2);
                            i18 += instruction2.getCodeUnits();
                        case 6:
                            makeInstructionWriter.write((Instruction20bc) instruction2);
                            i18 += instruction2.getCodeUnits();
                        case 7:
                            makeInstructionWriter.write((Instruction20t) instruction2);
                            i18 += instruction2.getCodeUnits();
                        case 8:
                            makeInstructionWriter.write((Instruction21c) instruction2);
                            i18 += instruction2.getCodeUnits();
                        case 9:
                            makeInstructionWriter.write((Instruction21ih) instruction2);
                            i18 += instruction2.getCodeUnits();
                        case 10:
                            makeInstructionWriter.write((Instruction21lh) instruction2);
                            i18 += instruction2.getCodeUnits();
                        case 11:
                            makeInstructionWriter.write((Instruction21s) instruction2);
                            i18 += instruction2.getCodeUnits();
                        case 12:
                            makeInstructionWriter.write((Instruction21t) instruction2);
                            i18 += instruction2.getCodeUnits();
                        case 13:
                            makeInstructionWriter.write((Instruction22b) instruction2);
                            i18 += instruction2.getCodeUnits();
                        case 14:
                            makeInstructionWriter.write((Instruction22c) instruction2);
                            i18 += instruction2.getCodeUnits();
                        case 15:
                            makeInstructionWriter.write((Instruction22cs) instruction2);
                            i18 += instruction2.getCodeUnits();
                        case 16:
                            makeInstructionWriter.write((Instruction22s) instruction2);
                            i18 += instruction2.getCodeUnits();
                        case 17:
                            makeInstructionWriter.write((Instruction22t) instruction2);
                            i18 += instruction2.getCodeUnits();
                        case 18:
                            makeInstructionWriter.write((Instruction22x) instruction2);
                            i18 += instruction2.getCodeUnits();
                        case 19:
                            makeInstructionWriter.write((Instruction23x) instruction2);
                            i18 += instruction2.getCodeUnits();
                        case 20:
                            makeInstructionWriter.write((Instruction30t) instruction2);
                            i18 += instruction2.getCodeUnits();
                        case 21:
                            makeInstructionWriter.write((Instruction31c) instruction2);
                            i18 += instruction2.getCodeUnits();
                        case 22:
                            makeInstructionWriter.write((Instruction31i) instruction2);
                            i18 += instruction2.getCodeUnits();
                        case 23:
                            makeInstructionWriter.write((Instruction31t) instruction2);
                            i18 += instruction2.getCodeUnits();
                        case 24:
                            makeInstructionWriter.write((Instruction32x) instruction2);
                            i18 += instruction2.getCodeUnits();
                        case 25:
                            makeInstructionWriter.write((Instruction35c) instruction2);
                            i18 += instruction2.getCodeUnits();
                        case 26:
                            makeInstructionWriter.write((Instruction35mi) instruction2);
                            i18 += instruction2.getCodeUnits();
                        case 27:
                            makeInstructionWriter.write((Instruction35ms) instruction2);
                            i18 += instruction2.getCodeUnits();
                        case 28:
                            makeInstructionWriter.write((Instruction3rc) instruction2);
                            i18 += instruction2.getCodeUnits();
                        case 29:
                            makeInstructionWriter.write((Instruction3rmi) instruction2);
                            i18 += instruction2.getCodeUnits();
                        case 30:
                            makeInstructionWriter.write((Instruction3rms) instruction2);
                            i18 += instruction2.getCodeUnits();
                        case 31:
                            makeInstructionWriter.write((Instruction45cc) instruction2);
                            i18 += instruction2.getCodeUnits();
                        case 32:
                            makeInstructionWriter.write((Instruction4rcc) instruction2);
                            i18 += instruction2.getCodeUnits();
                        case 33:
                            makeInstructionWriter.write((Instruction51l) instruction2);
                            i18 += instruction2.getCodeUnits();
                        case 34:
                            makeInstructionWriter.write((ArrayPayload) instruction2);
                            i18 += instruction2.getCodeUnits();
                        case 35:
                            makeInstructionWriter.write((PackedSwitchPayload) instruction2);
                            i18 += instruction2.getCodeUnits();
                        case 36:
                            makeInstructionWriter.write((SparseSwitchPayload) instruction2);
                            i18 += instruction2.getCodeUnits();
                        default:
                            throw new ExceptionWithContext("Unsupported instruction format: %s", instruction2.getOpcode().format);
                    }
                } catch (RuntimeException e16) {
                    throw new ExceptionWithContext(e16, "Error while writing instruction at code offset 0x%x", Integer.valueOf(i18));
                }
            }
            if (massageTryBlocks.size() > 0) {
                dexDataWriter.align();
                HashMap j3 = Maps.j();
                Iterator it = massageTryBlocks.iterator();
                while (it.hasNext()) {
                    j3.put(((TryBlock) it.next()).getExceptionHandlers(), 0);
                }
                DexDataWriter.writeUleb128(byteArrayOutputStream, j3.size());
                for (TryBlock tryBlock : massageTryBlocks) {
                    int startCodeAddress = tryBlock.getStartCodeAddress();
                    int codeUnitCount = (tryBlock.getCodeUnitCount() + startCodeAddress) - startCodeAddress;
                    dexDataWriter.writeInt(startCodeAddress);
                    dexDataWriter.writeUshort(codeUnitCount);
                    if (tryBlock.getExceptionHandlers().size() != 0) {
                        Integer num = (Integer) j3.get(tryBlock.getExceptionHandlers());
                        if (num.intValue() != 0) {
                            dexDataWriter.writeUshort(num.intValue());
                        } else {
                            Integer valueOf = Integer.valueOf(byteArrayOutputStream.size());
                            dexDataWriter.writeUshort(valueOf.intValue());
                            j3.put(tryBlock.getExceptionHandlers(), valueOf);
                            int size = tryBlock.getExceptionHandlers().size();
                            if (((ExceptionHandler) tryBlock.getExceptionHandlers().get(size - 1)).getExceptionType() == null) {
                                size = (size * (-1)) + 1;
                            }
                            DexDataWriter.writeSleb128(byteArrayOutputStream, size);
                            for (ExceptionHandler exceptionHandler : tryBlock.getExceptionHandlers()) {
                                CharSequence exceptionType = this.classSection.getExceptionType(exceptionHandler);
                                int handlerCodeAddress = exceptionHandler.getHandlerCodeAddress();
                                if (exceptionType != null) {
                                    DexDataWriter.writeUleb128(byteArrayOutputStream, this.typeSection.getItemIndex(exceptionType));
                                    DexDataWriter.writeUleb128(byteArrayOutputStream, handlerCodeAddress);
                                } else {
                                    DexDataWriter.writeUleb128(byteArrayOutputStream, handlerCodeAddress);
                                }
                            }
                        }
                    } else {
                        throw new ExceptionWithContext("No exception handlers for the try block!", new Object[0]);
                    }
                }
                if (byteArrayOutputStream.size() > 0) {
                    byteArrayOutputStream.writeTo(dexDataWriter);
                    byteArrayOutputStream.reset();
                }
            }
        } else {
            dexDataWriter.writeUshort(0);
            dexDataWriter.writeUshort(0);
            dexDataWriter.writeInt(i3);
            dexDataWriter.writeInt(0);
        }
        return position;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e4 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void writeDebugAndCodeItems(@Nonnull DexDataWriter dexDataWriter, @Nonnull DeferredOutputStream deferredOutputStream) throws IOException {
        List<? extends TryBlock<? extends ExceptionHandler>> list;
        Iterable<? extends Instruction> iterable;
        int writeCodeItem;
        boolean z16;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.debugSectionOffset = dexDataWriter.getPosition();
        DebugWriter debugWriter = new DebugWriter(this.stringSection, this.typeSection, dexDataWriter);
        DexDataWriter dexDataWriter2 = new DexDataWriter(deferredOutputStream, 0);
        ArrayList<CodeItemOffset> h16 = Lists.h();
        for (Comparable comparable : this.classSection.getSortedClasses()) {
            for (Object obj : q.e(this.classSection.getSortedDirectMethods(comparable), this.classSection.getSortedVirtualMethods(comparable))) {
                List<? extends TryBlock<? extends ExceptionHandler>> tryBlocks = this.classSection.getTryBlocks(obj);
                Iterable<? extends Instruction> instructions = this.classSection.getInstructions(obj);
                Iterable<? extends DebugItem> debugItems = this.classSection.getDebugItems(obj);
                try {
                    if (instructions != null && this.stringSection.hasJumboIndexes()) {
                        Iterator<? extends Instruction> it = instructions.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                Instruction next = it.next();
                                if (next.getOpcode() == Opcode.CONST_STRING && this.stringSection.getItemIndex((StringReference) ((ReferenceInstruction) next).getReference()) >= 65536) {
                                    z16 = true;
                                    break;
                                }
                            } else {
                                z16 = false;
                                break;
                            }
                        }
                        if (z16) {
                            MutableMethodImplementation makeMutableMethodImplementation = this.classSection.makeMutableMethodImplementation(obj);
                            fixInstructions(makeMutableMethodImplementation);
                            iterable = makeMutableMethodImplementation.getInstructions();
                            list = makeMutableMethodImplementation.getTryBlocks();
                            debugItems = makeMutableMethodImplementation.getDebugItems();
                            ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
                            writeCodeItem = writeCodeItem(dexDataWriter2, byteArrayOutputStream, obj, list, iterable, writeDebugItem(dexDataWriter, debugWriter, this.classSection.getParameterNames(obj), debugItems));
                            if (writeCodeItem == -1) {
                                h16.add(new CodeItemOffset(obj, writeCodeItem));
                            }
                            byteArrayOutputStream = byteArrayOutputStream2;
                        }
                    }
                    writeCodeItem = writeCodeItem(dexDataWriter2, byteArrayOutputStream, obj, list, iterable, writeDebugItem(dexDataWriter, debugWriter, this.classSection.getParameterNames(obj), debugItems));
                    if (writeCodeItem == -1) {
                    }
                    byteArrayOutputStream = byteArrayOutputStream2;
                } catch (RuntimeException e16) {
                    throw new ExceptionWithContext(e16, "Exception occurred while writing code_item for method %s", this.methodSection.getMethodReference(obj));
                }
                list = tryBlocks;
                iterable = instructions;
                ByteArrayOutputStream byteArrayOutputStream22 = byteArrayOutputStream;
            }
        }
        dexDataWriter.align();
        this.codeSectionOffset = dexDataWriter.getPosition();
        dexDataWriter2.close();
        deferredOutputStream.writeTo(dexDataWriter);
        deferredOutputStream.close();
        for (CodeItemOffset codeItemOffset : h16) {
            this.classSection.setCodeItemOffset(codeItemOffset.method, this.codeSectionOffset + codeItemOffset.codeOffset);
        }
    }

    private int writeDebugItem(@Nonnull DexDataWriter dexDataWriter, @Nonnull DebugWriter<StringKey, TypeKey> debugWriter, @Nullable Iterable<? extends StringKey> iterable, @Nullable Iterable<? extends DebugItem> iterable2) throws IOException {
        int i3;
        int i16;
        int i17;
        if (iterable != null) {
            i3 = q.j(iterable);
            Iterator<? extends StringKey> it = iterable.iterator();
            int i18 = 0;
            i16 = -1;
            while (it.hasNext()) {
                if (it.next() != null) {
                    i16 = i18;
                }
                i18++;
            }
        } else {
            i3 = 0;
            i16 = -1;
        }
        if (i16 == -1 && (iterable2 == null || q.h(iterable2))) {
            return 0;
        }
        this.numDebugInfoItems++;
        int position = dexDataWriter.getPosition();
        if (iterable2 != null) {
            for (DebugItem debugItem : iterable2) {
                if (debugItem instanceof LineNumber) {
                    i17 = ((LineNumber) debugItem).getLineNumber();
                    break;
                }
            }
        }
        i17 = 0;
        dexDataWriter.writeUleb128(i17);
        dexDataWriter.writeUleb128(i3);
        if (iterable != null) {
            int i19 = 0;
            for (StringKey stringkey : iterable) {
                if (i19 == i3) {
                    break;
                }
                i19++;
                dexDataWriter.writeUleb128(this.stringSection.getNullableItemIndex(stringkey) + 1);
            }
        }
        if (iterable2 != null) {
            debugWriter.reset(i17);
            Iterator<? extends DebugItem> it5 = iterable2.iterator();
            while (it5.hasNext()) {
                this.classSection.writeDebugItem(debugWriter, it5.next());
            }
        }
        dexDataWriter.write(0);
        return position;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void writeEncodedArrays(@Nonnull DexDataWriter dexDataWriter) throws IOException {
        InternalEncodedValueWriter internalEncodedValueWriter = new InternalEncodedValueWriter(dexDataWriter);
        this.encodedArraySectionOffset = dexDataWriter.getPosition();
        for (Map.Entry entry : this.encodedArraySection.getItems()) {
            entry.setValue(Integer.valueOf(dexDataWriter.getPosition()));
            List encodedValueList = this.encodedArraySection.getEncodedValueList(entry.getKey());
            dexDataWriter.writeUleb128(encodedValueList.size());
            Iterator it = encodedValueList.iterator();
            while (it.hasNext()) {
                writeEncodedValue(internalEncodedValueWriter, it.next());
            }
        }
    }

    private void writeEncodedFields(@Nonnull DexDataWriter dexDataWriter, @Nonnull Collection<? extends FieldKey> collection) throws IOException {
        int i3 = 0;
        for (FieldKey fieldkey : collection) {
            int fieldIndex = this.fieldSection.getFieldIndex(fieldkey);
            if (!this.classSection.getFieldHiddenApiRestrictions(fieldkey).isEmpty()) {
                this.hasHiddenApiRestrictions = true;
            }
            dexDataWriter.writeUleb128(fieldIndex - i3);
            dexDataWriter.writeUleb128(this.classSection.getFieldAccessFlags(fieldkey));
            i3 = fieldIndex;
        }
    }

    private void writeEncodedMethods(@Nonnull DexDataWriter dexDataWriter, @Nonnull Collection<? extends MethodKey> collection) throws IOException {
        int i3 = 0;
        for (MethodKey methodkey : collection) {
            int methodIndex = this.methodSection.getMethodIndex(methodkey);
            if (!this.classSection.getMethodHiddenApiRestrictions(methodkey).isEmpty()) {
                this.hasHiddenApiRestrictions = true;
            }
            dexDataWriter.writeUleb128(methodIndex - i3);
            dexDataWriter.writeUleb128(this.classSection.getMethodAccessFlags(methodkey));
            dexDataWriter.writeUleb128(this.classSection.getCodeItemOffset(methodkey));
            i3 = methodIndex;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void writeFields(@Nonnull DexDataWriter dexDataWriter) throws IOException {
        this.fieldSectionOffset = dexDataWriter.getPosition();
        ArrayList<Map.Entry> i3 = Lists.i(this.fieldSection.getItems());
        Collections.sort(i3, comparableKeyComparator());
        int i16 = 0;
        for (Map.Entry entry : i3) {
            int i17 = i16 + 1;
            entry.setValue(Integer.valueOf(i16));
            FieldReference fieldReference = (FieldReference) entry.getKey();
            dexDataWriter.writeUshort(this.typeSection.getItemIndex((CharSequence) this.fieldSection.getDefiningClass(fieldReference)));
            dexDataWriter.writeUshort(this.typeSection.getItemIndex((CharSequence) this.fieldSection.getFieldType(fieldReference)));
            dexDataWriter.writeInt(this.stringSection.getItemIndex((CharSequence) this.fieldSection.getName(fieldReference)));
            i16 = i17;
        }
    }

    private void writeHeader(@Nonnull DexDataWriter dexDataWriter, int i3, int i16) throws IOException {
        dexDataWriter.write(HeaderItem.getMagicForApi(this.opcodes.api));
        dexDataWriter.writeInt(0);
        dexDataWriter.write(new byte[20]);
        dexDataWriter.writeInt(i16);
        dexDataWriter.writeInt(112);
        dexDataWriter.writeInt(HeaderItem.LITTLE_ENDIAN_TAG);
        dexDataWriter.writeInt(0);
        dexDataWriter.writeInt(0);
        dexDataWriter.writeInt(this.mapSectionOffset);
        writeSectionInfo(dexDataWriter, this.stringSection.getItems().size(), this.stringIndexSectionOffset);
        writeSectionInfo(dexDataWriter, this.typeSection.getItems().size(), this.typeSectionOffset);
        writeSectionInfo(dexDataWriter, this.protoSection.getItems().size(), this.protoSectionOffset);
        writeSectionInfo(dexDataWriter, this.fieldSection.getItems().size(), this.fieldSectionOffset);
        writeSectionInfo(dexDataWriter, this.methodSection.getItems().size(), this.methodSectionOffset);
        writeSectionInfo(dexDataWriter, this.classSection.getItems().size(), this.classIndexSectionOffset);
        dexDataWriter.writeInt(i16 - i3);
        dexDataWriter.writeInt(i3);
    }

    private void writeMapItem(@Nonnull DexDataWriter dexDataWriter) throws IOException {
        dexDataWriter.align();
        this.mapSectionOffset = dexDataWriter.getPosition();
        dexDataWriter.writeInt(calcNumItems());
        writeMapItem(dexDataWriter, 0, 1, 0);
        writeMapItem(dexDataWriter, 1, this.stringSection.getItems().size(), this.stringIndexSectionOffset);
        writeMapItem(dexDataWriter, 2, this.typeSection.getItems().size(), this.typeSectionOffset);
        writeMapItem(dexDataWriter, 3, this.protoSection.getItems().size(), this.protoSectionOffset);
        writeMapItem(dexDataWriter, 4, this.fieldSection.getItems().size(), this.fieldSectionOffset);
        writeMapItem(dexDataWriter, 5, this.methodSection.getItems().size(), this.methodSectionOffset);
        writeMapItem(dexDataWriter, 6, this.classSection.getItems().size(), this.classIndexSectionOffset);
        writeMapItem(dexDataWriter, 7, this.callSiteSection.getItems().size(), this.callSiteSectionOffset);
        writeMapItem(dexDataWriter, 8, this.methodHandleSection.getItems().size(), this.methodHandleSectionOffset);
        writeMapItem(dexDataWriter, 8194, this.stringSection.getItems().size(), this.stringDataSectionOffset);
        writeMapItem(dexDataWriter, 4097, this.typeListSection.getItems().size(), this.typeListSectionOffset);
        writeMapItem(dexDataWriter, 8197, this.encodedArraySection.getItems().size(), this.encodedArraySectionOffset);
        writeMapItem(dexDataWriter, 8196, this.annotationSection.getItems().size(), this.annotationSectionOffset);
        writeMapItem(dexDataWriter, 4099, this.annotationSetSection.getItems().size() + (shouldCreateEmptyAnnotationSet() ? 1 : 0), this.annotationSetSectionOffset);
        writeMapItem(dexDataWriter, 4098, this.numAnnotationSetRefItems, this.annotationSetRefSectionOffset);
        writeMapItem(dexDataWriter, 8198, this.numAnnotationDirectoryItems, this.annotationDirectorySectionOffset);
        writeMapItem(dexDataWriter, 8195, this.numDebugInfoItems, this.debugSectionOffset);
        writeMapItem(dexDataWriter, 8193, this.numCodeItemItems, this.codeSectionOffset);
        writeMapItem(dexDataWriter, 8192, this.numClassDataItems, this.classDataSectionOffset);
        if (shouldWriteHiddenApiRestrictions()) {
            writeMapItem(dexDataWriter, 61440, 1, this.hiddenApiRestrictionsOffset);
        }
        writeMapItem(dexDataWriter, 4096, 1, this.mapSectionOffset);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void writeMethodHandles(DexDataWriter dexDataWriter) throws IOException {
        int itemIndex;
        this.methodHandleSectionOffset = dexDataWriter.getPosition();
        int i3 = 0;
        for (Map.Entry entry : this.methodHandleSection.getItems()) {
            int i16 = i3 + 1;
            entry.setValue(Integer.valueOf(i3));
            MethodHandleReference methodHandleReference = (MethodHandleReference) entry.getKey();
            dexDataWriter.writeUshort(methodHandleReference.getMethodHandleType());
            dexDataWriter.writeUshort(0);
            switch (methodHandleReference.getMethodHandleType()) {
                case 0:
                case 1:
                case 2:
                case 3:
                    itemIndex = this.fieldSection.getItemIndex(this.methodHandleSection.getFieldReference(methodHandleReference));
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    itemIndex = this.methodSection.getItemIndex(this.methodHandleSection.getMethodReference(methodHandleReference));
                    break;
                default:
                    throw new ExceptionWithContext("Invalid method handle type: %d", Integer.valueOf(methodHandleReference.getMethodHandleType()));
            }
            dexDataWriter.writeUshort(itemIndex);
            dexDataWriter.writeUshort(0);
            i3 = i16;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void writeMethods(@Nonnull DexDataWriter dexDataWriter) throws IOException {
        this.methodSectionOffset = dexDataWriter.getPosition();
        ArrayList<Map.Entry> i3 = Lists.i(this.methodSection.getItems());
        Collections.sort(i3, comparableKeyComparator());
        int i16 = 0;
        for (Map.Entry entry : i3) {
            int i17 = i16 + 1;
            entry.setValue(Integer.valueOf(i16));
            MethodReference methodReference = (MethodReference) entry.getKey();
            dexDataWriter.writeUshort(this.typeSection.getItemIndex((CharSequence) this.methodSection.getDefiningClass(methodReference)));
            dexDataWriter.writeUshort(this.protoSection.getItemIndex(this.methodSection.getPrototype(methodReference)));
            dexDataWriter.writeInt(this.stringSection.getItemIndex((CharSequence) this.methodSection.getName(methodReference)));
            i16 = i17;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void writeProtos(@Nonnull DexDataWriter dexDataWriter) throws IOException {
        this.protoSectionOffset = dexDataWriter.getPosition();
        ArrayList<Map.Entry> i3 = Lists.i(this.protoSection.getItems());
        Collections.sort(i3, comparableKeyComparator());
        int i16 = 0;
        for (Map.Entry entry : i3) {
            int i17 = i16 + 1;
            entry.setValue(Integer.valueOf(i16));
            MethodProtoReference methodProtoReference = (MethodProtoReference) entry.getKey();
            dexDataWriter.writeInt(this.stringSection.getItemIndex((CharSequence) this.protoSection.getShorty(methodProtoReference)));
            dexDataWriter.writeInt(this.typeSection.getItemIndex((CharSequence) this.protoSection.getReturnType(methodProtoReference)));
            dexDataWriter.writeInt(this.typeListSection.getNullableItemOffset(this.protoSection.getParameters(methodProtoReference)));
            i16 = i17;
        }
    }

    private void writeSectionInfo(DexDataWriter dexDataWriter, int i3, int i16) throws IOException {
        dexDataWriter.writeInt(i3);
        if (i3 > 0) {
            dexDataWriter.writeInt(i16);
        } else {
            dexDataWriter.writeInt(0);
        }
    }

    private void writeStrings(@Nonnull DexDataWriter dexDataWriter, @Nonnull DexDataWriter dexDataWriter2) throws IOException {
        this.stringIndexSectionOffset = dexDataWriter.getPosition();
        this.stringDataSectionOffset = dexDataWriter2.getPosition();
        ArrayList<Map.Entry> i3 = Lists.i(this.stringSection.getItems());
        Collections.sort(i3, toStringKeyComparator);
        int i16 = 0;
        for (Map.Entry entry : i3) {
            int i17 = i16 + 1;
            entry.setValue(Integer.valueOf(i16));
            dexDataWriter.writeInt(dexDataWriter2.getPosition());
            String charSequence = ((CharSequence) entry.getKey()).toString();
            dexDataWriter2.writeUleb128(charSequence.length());
            dexDataWriter2.writeString(charSequence);
            dexDataWriter2.write(0);
            i16 = i17;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void writeTypeLists(@Nonnull DexDataWriter dexDataWriter) throws IOException {
        dexDataWriter.align();
        this.typeListSectionOffset = dexDataWriter.getPosition();
        for (Map.Entry entry : this.typeListSection.getItems()) {
            dexDataWriter.align();
            entry.setValue(Integer.valueOf(dexDataWriter.getPosition()));
            Collection types = this.typeListSection.getTypes(entry.getKey());
            dexDataWriter.writeInt(types.size());
            Iterator it = types.iterator();
            while (it.hasNext()) {
                dexDataWriter.writeUshort(this.typeSection.getItemIndex((CharSequence) it.next()));
            }
        }
    }

    private void writeTypes(@Nonnull DexDataWriter dexDataWriter) throws IOException {
        this.typeSectionOffset = dexDataWriter.getPosition();
        ArrayList<Map.Entry> i3 = Lists.i(this.typeSection.getItems());
        Collections.sort(i3, toStringKeyComparator);
        int i16 = 0;
        for (Map.Entry entry : i3) {
            entry.setValue(Integer.valueOf(i16));
            dexDataWriter.writeInt(this.stringSection.getItemIndex((CharSequence) this.typeSection.getString((CharSequence) entry.getKey())));
            i16++;
        }
    }

    @Nonnull
    public List<String> getFieldReferences() {
        ArrayList h16 = Lists.h();
        Iterator it = this.fieldSection.getItems().iterator();
        while (it.hasNext()) {
            h16.add(DexFormatter.INSTANCE.getFieldDescriptor((FieldReference) ((Map.Entry) it.next()).getKey()));
        }
        return h16;
    }

    @Nonnull
    public List<String> getMethodReferences() {
        ArrayList h16 = Lists.h();
        Iterator it = this.methodSection.getItems().iterator();
        while (it.hasNext()) {
            h16.add(DexFormatter.INSTANCE.getMethodDescriptor((MethodReference) ((Map.Entry) it.next()).getKey()));
        }
        return h16;
    }

    @Nonnull
    protected abstract DexWriter<StringKey, StringRef, TypeKey, TypeRef, ProtoRefKey, FieldRefKey, MethodRefKey, ClassKey, CallSiteKey, MethodHandleKey, AnnotationKey, AnnotationSetKey, TypeListKey, FieldKey, MethodKey, EncodedArrayKey, EncodedValue, AnnotationElement, StringSectionType, TypeSectionType, ProtoSectionType, FieldSectionType, MethodSectionType, ClassSectionType, CallSiteSectionType, MethodHandleSectionType, TypeListSectionType, AnnotationSectionType, AnnotationSetSectionType, EncodedArraySectionType>.SectionProvider getSectionProvider();

    @Nonnull
    public List<String> getTypeReferences() {
        ArrayList h16 = Lists.h();
        Iterator it = this.typeSection.getItems().iterator();
        while (it.hasNext()) {
            h16.add(((CharSequence) ((Map.Entry) it.next()).getKey()).toString());
        }
        return h16;
    }

    public boolean hasOverflowed() {
        return hasOverflowed(65536);
    }

    protected abstract void writeEncodedValue(@Nonnull DexWriter<StringKey, StringRef, TypeKey, TypeRef, ProtoRefKey, FieldRefKey, MethodRefKey, ClassKey, CallSiteKey, MethodHandleKey, AnnotationKey, AnnotationSetKey, TypeListKey, FieldKey, MethodKey, EncodedArrayKey, EncodedValue, AnnotationElement, StringSectionType, TypeSectionType, ProtoSectionType, FieldSectionType, MethodSectionType, ClassSectionType, CallSiteSectionType, MethodHandleSectionType, TypeListSectionType, AnnotationSectionType, AnnotationSetSectionType, EncodedArraySectionType>.InternalEncodedValueWriter internalEncodedValueWriter, @Nonnull EncodedValue encodedvalue) throws IOException;

    public void writeTo(@Nonnull DexDataStore dexDataStore) throws IOException {
        writeTo(dexDataStore, MemoryDeferredOutputStream.getFactory());
    }

    public boolean hasOverflowed(int i3) {
        for (IndexSection<?> indexSection : this.overflowableSections) {
            if (indexSection.getItemCount() > i3) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Finally extract failed */
    public void writeTo(@Nonnull DexDataStore dexDataStore, @Nonnull DeferredOutputStreamFactory deferredOutputStreamFactory) throws IOException {
        try {
            int dataSectionOffset = getDataSectionOffset();
            DexDataWriter outputAt = outputAt(dexDataStore, 0);
            DexDataWriter outputAt2 = outputAt(dexDataStore, 112);
            DexDataWriter outputAt3 = outputAt(dexDataStore, dataSectionOffset);
            try {
                writeStrings(outputAt2, outputAt3);
                writeTypes(outputAt2);
                writeTypeLists(outputAt3);
                writeProtos(outputAt2);
                writeFields(outputAt2);
                writeMethods(outputAt2);
                DexDataWriter outputAt4 = outputAt(dexDataStore, outputAt2.getPosition() + (this.classSection.getItemCount() * 32) + (this.callSiteSection.getItemCount() * 4));
                try {
                    writeMethodHandles(outputAt4);
                    outputAt4.close();
                    writeEncodedArrays(outputAt3);
                    DexDataWriter outputAt5 = outputAt(dexDataStore, outputAt2.getPosition() + (this.classSection.getItemCount() * 32));
                    try {
                        writeCallSites(outputAt5);
                        outputAt5.close();
                        writeAnnotations(outputAt3);
                        writeAnnotationSets(outputAt3);
                        writeAnnotationSetRefs(outputAt3);
                        writeAnnotationDirectories(outputAt3);
                        writeDebugAndCodeItems(outputAt3, deferredOutputStreamFactory.makeDeferredOutputStream());
                        writeClasses(dexDataStore, outputAt2, outputAt3);
                        writeMapItem(outputAt3);
                        writeHeader(outputAt, dataSectionOffset, outputAt3.getPosition());
                        outputAt.close();
                        outputAt2.close();
                        outputAt3.close();
                        updateSignature(dexDataStore);
                        updateChecksum(dexDataStore);
                    } catch (Throwable th5) {
                        outputAt5.close();
                        throw th5;
                    }
                } catch (Throwable th6) {
                    outputAt4.close();
                    throw th6;
                }
            } catch (Throwable th7) {
                outputAt.close();
                outputAt2.close();
                outputAt3.close();
                throw th7;
            }
        } finally {
            dexDataStore.close();
        }
    }

    private void writeMapItem(@Nonnull DexDataWriter dexDataWriter, int i3, int i16, int i17) throws IOException {
        if (i16 > 0) {
            dexDataWriter.writeUshort(i3);
            dexDataWriter.writeUshort(0);
            dexDataWriter.writeInt(i16);
            dexDataWriter.writeInt(i17);
        }
    }
}
