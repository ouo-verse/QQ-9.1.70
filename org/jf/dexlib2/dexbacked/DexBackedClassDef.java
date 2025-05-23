package org.jf.dexlib2.dexbacked;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.q;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.base.reference.BaseTypeReference;
import org.jf.dexlib2.dexbacked.util.AnnotationsDirectory;
import org.jf.dexlib2.dexbacked.util.EncodedArrayItemIterator;
import org.jf.dexlib2.dexbacked.util.VariableSizeListIterator;
import org.jf.dexlib2.dexbacked.util.VariableSizeLookaheadIterator;
import org.jf.dexlib2.iface.ClassDef;
import org.jf.dexlib2.iface.reference.FieldReference;
import org.jf.dexlib2.iface.reference.MethodReference;
import org.jf.dexlib2.immutable.reference.ImmutableFieldReference;
import org.jf.dexlib2.immutable.reference.ImmutableMethodReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DexBackedClassDef extends BaseTypeReference implements ClassDef {
    static final int NO_HIDDEN_API_RESTRICTIONS = 7;

    @Nullable
    private AnnotationsDirectory annotationsDirectory;
    private final int classDefOffset;

    @Nonnull
    public final DexBackedDexFile dexFile;
    private final int directMethodCount;

    @Nullable
    private final HiddenApiRestrictionsReader hiddenApiRestrictionsReader;
    private final int instanceFieldCount;
    private final int staticFieldCount;
    private final int staticFieldsOffset;
    private final int virtualMethodCount;
    private int instanceFieldsOffset = 0;
    private int directMethodsOffset = 0;
    private int virtualMethodsOffset = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: org.jf.dexlib2.dexbacked.DexBackedClassDef$5, reason: invalid class name */
    /* loaded from: classes29.dex */
    public class AnonymousClass5 implements Iterable<DexBackedMethod> {
        final AnnotationsDirectory.AnnotationIterator methodAnnotationIterator;
        final AnnotationsDirectory.AnnotationIterator parameterAnnotationIterator;
        final /* synthetic */ AnnotationsDirectory val$annotationsDirectory;
        final /* synthetic */ Iterator val$hiddenApiRestrictionIterator;
        final /* synthetic */ int val$methodsStartOffset;
        final /* synthetic */ boolean val$skipDuplicates;

        AnonymousClass5(AnnotationsDirectory annotationsDirectory, int i3, Iterator it, boolean z16) {
            this.val$annotationsDirectory = annotationsDirectory;
            this.val$methodsStartOffset = i3;
            this.val$hiddenApiRestrictionIterator = it;
            this.val$skipDuplicates = z16;
            this.methodAnnotationIterator = annotationsDirectory.getMethodAnnotationIterator();
            this.parameterAnnotationIterator = annotationsDirectory.getParameterAnnotationIterator();
        }

        @Override // java.lang.Iterable
        @Nonnull
        public Iterator<DexBackedMethod> iterator() {
            return new VariableSizeLookaheadIterator<DexBackedMethod>(DexBackedClassDef.this.dexFile.getDataBuffer(), this.val$methodsStartOffset) { // from class: org.jf.dexlib2.dexbacked.DexBackedClassDef.5.1
                private int count;
                private int previousIndex;

                @Nullable
                private MethodReference previousMethod;

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // org.jf.dexlib2.dexbacked.util.VariableSizeLookaheadIterator
                @Nullable
                public DexBackedMethod readNextItem(@Nonnull DexReader dexReader) {
                    DexBackedMethod dexBackedMethod;
                    MethodReference methodReference;
                    ImmutableMethodReference of5;
                    do {
                        int i3 = this.count + 1;
                        this.count = i3;
                        if (i3 > DexBackedClassDef.this.virtualMethodCount) {
                            return endOfData();
                        }
                        Iterator it = AnonymousClass5.this.val$hiddenApiRestrictionIterator;
                        int intValue = it != null ? ((Integer) it.next()).intValue() : 7;
                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                        DexBackedClassDef dexBackedClassDef = DexBackedClassDef.this;
                        dexBackedMethod = new DexBackedMethod(dexBackedClassDef.dexFile, dexReader, dexBackedClassDef, this.previousIndex, anonymousClass5.methodAnnotationIterator, anonymousClass5.parameterAnnotationIterator, intValue);
                        methodReference = this.previousMethod;
                        of5 = ImmutableMethodReference.of(dexBackedMethod);
                        this.previousMethod = of5;
                        this.previousIndex = dexBackedMethod.methodIndex;
                        if (!AnonymousClass5.this.val$skipDuplicates || methodReference == null) {
                            break;
                        }
                    } while (methodReference.equals(of5));
                    return dexBackedMethod;
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class HiddenApiRestrictionsReader {
        private int directMethodsStartOffset;
        private int instanceFieldsStartOffset;
        private final int startOffset;
        private int virtualMethodsStartOffset;

        public HiddenApiRestrictionsReader(int i3) {
            this.startOffset = i3;
        }

        private int getDirectMethodsStartOffset() {
            if (this.directMethodsStartOffset == 0) {
                DexReader<? extends DexBuffer> readerAt = DexBackedClassDef.this.dexFile.getDataBuffer().readerAt(getInstanceFieldsStartOffset());
                for (int i3 = 0; i3 < DexBackedClassDef.this.instanceFieldCount; i3++) {
                    readerAt.readSmallUleb128();
                }
                this.directMethodsStartOffset = readerAt.getOffset();
            }
            return this.directMethodsStartOffset;
        }

        private int getInstanceFieldsStartOffset() {
            if (this.instanceFieldsStartOffset == 0) {
                DexReader<? extends DexBuffer> readerAt = DexBackedClassDef.this.dexFile.getDataBuffer().readerAt(this.startOffset);
                for (int i3 = 0; i3 < DexBackedClassDef.this.staticFieldCount; i3++) {
                    readerAt.readSmallUleb128();
                }
                this.instanceFieldsStartOffset = readerAt.getOffset();
            }
            return this.instanceFieldsStartOffset;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Iterator<Integer> getRestrictionsForDirectMethods() {
            return new VariableSizeListIterator<Integer>(DexBackedClassDef.this.dexFile.getDataBuffer(), getDirectMethodsStartOffset(), DexBackedClassDef.this.directMethodCount) { // from class: org.jf.dexlib2.dexbacked.DexBackedClassDef.HiddenApiRestrictionsReader.3
                @Override // org.jf.dexlib2.dexbacked.util.VariableSizeListIterator
                protected /* bridge */ /* synthetic */ Integer readNextItem(@Nonnull DexReader dexReader, int i3) {
                    return readNextItem((DexReader<? extends DexBuffer>) dexReader, i3);
                }

                @Override // org.jf.dexlib2.dexbacked.util.VariableSizeListIterator, java.util.ListIterator, java.util.Iterator
                public Integer next() {
                    if (nextIndex() == DexBackedClassDef.this.directMethodCount) {
                        HiddenApiRestrictionsReader.this.virtualMethodsStartOffset = getReaderOffset();
                    }
                    return (Integer) super.next();
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // org.jf.dexlib2.dexbacked.util.VariableSizeListIterator
                protected Integer readNextItem(@Nonnull DexReader<? extends DexBuffer> dexReader, int i3) {
                    return Integer.valueOf(dexReader.readSmallUleb128());
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Iterator<Integer> getRestrictionsForInstanceFields() {
            return new VariableSizeListIterator<Integer>(DexBackedClassDef.this.dexFile.getDataBuffer(), getInstanceFieldsStartOffset(), DexBackedClassDef.this.instanceFieldCount) { // from class: org.jf.dexlib2.dexbacked.DexBackedClassDef.HiddenApiRestrictionsReader.2
                @Override // org.jf.dexlib2.dexbacked.util.VariableSizeListIterator
                protected /* bridge */ /* synthetic */ Integer readNextItem(@Nonnull DexReader dexReader, int i3) {
                    return readNextItem((DexReader<? extends DexBuffer>) dexReader, i3);
                }

                @Override // org.jf.dexlib2.dexbacked.util.VariableSizeListIterator, java.util.ListIterator, java.util.Iterator
                public Integer next() {
                    if (nextIndex() == DexBackedClassDef.this.instanceFieldCount) {
                        HiddenApiRestrictionsReader.this.directMethodsStartOffset = getReaderOffset();
                    }
                    return (Integer) super.next();
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // org.jf.dexlib2.dexbacked.util.VariableSizeListIterator
                protected Integer readNextItem(@Nonnull DexReader<? extends DexBuffer> dexReader, int i3) {
                    return Integer.valueOf(dexReader.readSmallUleb128());
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public VariableSizeListIterator<Integer> getRestrictionsForStaticFields() {
            return new VariableSizeListIterator<Integer>(DexBackedClassDef.this.dexFile.getDataBuffer(), this.startOffset, DexBackedClassDef.this.staticFieldCount) { // from class: org.jf.dexlib2.dexbacked.DexBackedClassDef.HiddenApiRestrictionsReader.1
                @Override // org.jf.dexlib2.dexbacked.util.VariableSizeListIterator
                protected /* bridge */ /* synthetic */ Integer readNextItem(@Nonnull DexReader dexReader, int i3) {
                    return readNextItem((DexReader<? extends DexBuffer>) dexReader, i3);
                }

                @Override // org.jf.dexlib2.dexbacked.util.VariableSizeListIterator, java.util.ListIterator, java.util.Iterator
                public Integer next() {
                    if (nextIndex() == DexBackedClassDef.this.staticFieldCount) {
                        HiddenApiRestrictionsReader.this.instanceFieldsStartOffset = getReaderOffset();
                    }
                    return (Integer) super.next();
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // org.jf.dexlib2.dexbacked.util.VariableSizeListIterator
                protected Integer readNextItem(@Nonnull DexReader<? extends DexBuffer> dexReader, int i3) {
                    return Integer.valueOf(dexReader.readSmallUleb128());
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Iterator<Integer> getRestrictionsForVirtualMethods() {
            return new VariableSizeListIterator<Integer>(DexBackedClassDef.this.dexFile.getDataBuffer(), getVirtualMethodsStartOffset(), DexBackedClassDef.this.virtualMethodCount) { // from class: org.jf.dexlib2.dexbacked.DexBackedClassDef.HiddenApiRestrictionsReader.4
                @Override // org.jf.dexlib2.dexbacked.util.VariableSizeListIterator
                protected /* bridge */ /* synthetic */ Integer readNextItem(@Nonnull DexReader dexReader, int i3) {
                    return readNextItem((DexReader<? extends DexBuffer>) dexReader, i3);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // org.jf.dexlib2.dexbacked.util.VariableSizeListIterator
                protected Integer readNextItem(@Nonnull DexReader<? extends DexBuffer> dexReader, int i3) {
                    return Integer.valueOf(dexReader.readSmallUleb128());
                }
            };
        }

        private int getVirtualMethodsStartOffset() {
            if (this.virtualMethodsStartOffset == 0) {
                DexReader<? extends DexBuffer> readerAt = DexBackedClassDef.this.dexFile.getDataBuffer().readerAt(getDirectMethodsStartOffset());
                for (int i3 = 0; i3 < DexBackedClassDef.this.directMethodCount; i3++) {
                    readerAt.readSmallUleb128();
                }
                this.virtualMethodsStartOffset = readerAt.getOffset();
            }
            return this.virtualMethodsStartOffset;
        }
    }

    public DexBackedClassDef(@Nonnull DexBackedDexFile dexBackedDexFile, int i3, int i16) {
        this.dexFile = dexBackedDexFile;
        this.classDefOffset = i3;
        int readSmallUint = dexBackedDexFile.getBuffer().readSmallUint(i3 + 24);
        if (readSmallUint == 0) {
            this.staticFieldsOffset = -1;
            this.staticFieldCount = 0;
            this.instanceFieldCount = 0;
            this.directMethodCount = 0;
            this.virtualMethodCount = 0;
        } else {
            DexReader<? extends DexBuffer> readerAt = dexBackedDexFile.getDataBuffer().readerAt(readSmallUint);
            this.staticFieldCount = readerAt.readSmallUleb128();
            this.instanceFieldCount = readerAt.readSmallUleb128();
            this.directMethodCount = readerAt.readSmallUleb128();
            this.virtualMethodCount = readerAt.readSmallUleb128();
            this.staticFieldsOffset = readerAt.getOffset();
        }
        if (i16 != 0) {
            this.hiddenApiRestrictionsReader = new HiddenApiRestrictionsReader(i16);
        } else {
            this.hiddenApiRestrictionsReader = null;
        }
    }

    private AnnotationsDirectory getAnnotationsDirectory() {
        if (this.annotationsDirectory == null) {
            this.annotationsDirectory = AnnotationsDirectory.newOrEmpty(this.dexFile, this.dexFile.getBuffer().readSmallUint(this.classDefOffset + 20));
        }
        return this.annotationsDirectory;
    }

    private int getDirectMethodsOffset() {
        int i3 = this.directMethodsOffset;
        if (i3 > 0) {
            return i3;
        }
        DexReader<? extends DexBuffer> readerAt = this.dexFile.getDataBuffer().readerAt(getInstanceFieldsOffset());
        DexBackedField.skipFields(readerAt, this.instanceFieldCount);
        int offset = readerAt.getOffset();
        this.directMethodsOffset = offset;
        return offset;
    }

    private int getInstanceFieldsOffset() {
        int i3 = this.instanceFieldsOffset;
        if (i3 > 0) {
            return i3;
        }
        DexReader<? extends DexBuffer> readerAt = this.dexFile.getDataBuffer().readerAt(this.staticFieldsOffset);
        DexBackedField.skipFields(readerAt, this.staticFieldCount);
        int offset = readerAt.getOffset();
        this.instanceFieldsOffset = offset;
        return offset;
    }

    private int getVirtualMethodsOffset() {
        int i3 = this.virtualMethodsOffset;
        if (i3 > 0) {
            return i3;
        }
        DexReader<? extends DexBuffer> readerAt = this.dexFile.getDataBuffer().readerAt(getDirectMethodsOffset());
        DexBackedMethod.skipMethods(readerAt, this.directMethodCount);
        int offset = readerAt.getOffset();
        this.virtualMethodsOffset = offset;
        return offset;
    }

    @Override // org.jf.dexlib2.iface.ClassDef
    public int getAccessFlags() {
        return this.dexFile.getBuffer().readSmallUint(this.classDefOffset + 4);
    }

    @Override // org.jf.dexlib2.iface.ClassDef, org.jf.dexlib2.iface.Annotatable
    @Nonnull
    public Set<? extends DexBackedAnnotation> getAnnotations() {
        return getAnnotationsDirectory().getClassAnnotations();
    }

    @Override // org.jf.dexlib2.iface.ClassDef
    @Nonnull
    public Iterable<? extends DexBackedMethod> getDirectMethods() {
        return getDirectMethods(true);
    }

    @Override // org.jf.dexlib2.iface.ClassDef
    @Nonnull
    public Iterable<? extends DexBackedField> getFields() {
        return q.e(getStaticFields(), getInstanceFields());
    }

    @Override // org.jf.dexlib2.iface.ClassDef
    @Nonnull
    public Iterable<? extends DexBackedField> getInstanceFields() {
        return getInstanceFields(true);
    }

    @Override // org.jf.dexlib2.iface.ClassDef
    @Nonnull
    public List<String> getInterfaces() {
        final int readSmallUint = this.dexFile.getBuffer().readSmallUint(this.classDefOffset + 12);
        if (readSmallUint > 0) {
            final int readSmallUint2 = this.dexFile.getDataBuffer().readSmallUint(readSmallUint);
            return new AbstractList<String>() { // from class: org.jf.dexlib2.dexbacked.DexBackedClassDef.1
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return readSmallUint2;
                }

                @Override // java.util.AbstractList, java.util.List
                @Nonnull
                public String get(int i3) {
                    return DexBackedClassDef.this.dexFile.getTypeSection().get(DexBackedClassDef.this.dexFile.getDataBuffer().readUshort(readSmallUint + 4 + (i3 * 2)));
                }
            };
        }
        return ImmutableList.of();
    }

    @Override // org.jf.dexlib2.iface.ClassDef
    @Nonnull
    public Iterable<? extends DexBackedMethod> getMethods() {
        return q.e(getDirectMethods(), getVirtualMethods());
    }

    public int getSize() {
        int i3;
        int size = getInterfaces().size();
        if (size > 0) {
            i3 = 40 + (size * 2);
        } else {
            i3 = 36;
        }
        AnnotationsDirectory annotationsDirectory = getAnnotationsDirectory();
        if (!AnnotationsDirectory.EMPTY.equals(annotationsDirectory)) {
            i3 += 16;
            Set<? extends DexBackedAnnotation> classAnnotations = annotationsDirectory.getClassAnnotations();
            if (!classAnnotations.isEmpty()) {
                i3 = i3 + 4 + (classAnnotations.size() * 4);
            }
        }
        int readSmallUint = this.dexFile.getBuffer().readSmallUint(this.classDefOffset + 28);
        if (readSmallUint != 0) {
            i3 += this.dexFile.getDataBuffer().readerAt(readSmallUint).peekSmallUleb128Size();
        }
        int readSmallUint2 = this.dexFile.getBuffer().readSmallUint(this.classDefOffset + 24);
        if (readSmallUint2 > 0) {
            DexReader<? extends DexBuffer> readerAt = this.dexFile.getDataBuffer().readerAt(readSmallUint2);
            readerAt.readSmallUleb128();
            readerAt.readSmallUleb128();
            readerAt.readSmallUleb128();
            readerAt.readSmallUleb128();
            i3 += readerAt.getOffset() - readSmallUint2;
        }
        Iterator<? extends DexBackedField> it = getFields().iterator();
        while (it.hasNext()) {
            i3 += it.next().getSize();
        }
        Iterator<? extends DexBackedMethod> it5 = getMethods().iterator();
        while (it5.hasNext()) {
            i3 += it5.next().getSize();
        }
        return i3;
    }

    @Override // org.jf.dexlib2.iface.ClassDef
    @Nullable
    public String getSourceFile() {
        return this.dexFile.getStringSection().getOptional(this.dexFile.getBuffer().readOptionalUint(this.classDefOffset + 16));
    }

    @Override // org.jf.dexlib2.iface.ClassDef
    @Nonnull
    public Iterable<? extends DexBackedField> getStaticFields() {
        return getStaticFields(true);
    }

    @Override // org.jf.dexlib2.iface.ClassDef
    @Nullable
    public String getSuperclass() {
        return this.dexFile.getTypeSection().getOptional(this.dexFile.getBuffer().readOptionalUint(this.classDefOffset + 8));
    }

    @Override // org.jf.dexlib2.iface.reference.TypeReference, org.jf.dexlib2.iface.ClassDef
    @Nonnull
    public String getType() {
        return this.dexFile.getTypeSection().get(this.dexFile.getBuffer().readSmallUint(this.classDefOffset + 0));
    }

    @Nonnull
    public Iterable<? extends DexBackedMethod> getVirtualMethods(boolean z16) {
        if (this.virtualMethodCount > 0) {
            DexReader<? extends DexBuffer> readerAt = this.dexFile.getDataBuffer().readerAt(getVirtualMethodsOffset());
            AnnotationsDirectory annotationsDirectory = getAnnotationsDirectory();
            int offset = readerAt.getOffset();
            HiddenApiRestrictionsReader hiddenApiRestrictionsReader = this.hiddenApiRestrictionsReader;
            return new AnonymousClass5(annotationsDirectory, offset, hiddenApiRestrictionsReader == null ? null : hiddenApiRestrictionsReader.getRestrictionsForVirtualMethods(), z16);
        }
        return ImmutableSet.of();
    }

    @Nonnull
    public Iterable<? extends DexBackedMethod> getDirectMethods(final boolean z16) {
        if (this.directMethodCount > 0) {
            DexReader<? extends DexBuffer> readerAt = this.dexFile.getDataBuffer().readerAt(getDirectMethodsOffset());
            final AnnotationsDirectory annotationsDirectory = getAnnotationsDirectory();
            final int offset = readerAt.getOffset();
            HiddenApiRestrictionsReader hiddenApiRestrictionsReader = this.hiddenApiRestrictionsReader;
            final Iterator restrictionsForDirectMethods = hiddenApiRestrictionsReader == null ? null : hiddenApiRestrictionsReader.getRestrictionsForDirectMethods();
            return new Iterable<DexBackedMethod>() { // from class: org.jf.dexlib2.dexbacked.DexBackedClassDef.4
                @Override // java.lang.Iterable
                @Nonnull
                public Iterator<DexBackedMethod> iterator() {
                    final AnnotationsDirectory.AnnotationIterator methodAnnotationIterator = annotationsDirectory.getMethodAnnotationIterator();
                    final AnnotationsDirectory.AnnotationIterator parameterAnnotationIterator = annotationsDirectory.getParameterAnnotationIterator();
                    return new VariableSizeLookaheadIterator<DexBackedMethod>(DexBackedClassDef.this.dexFile.getDataBuffer(), offset) { // from class: org.jf.dexlib2.dexbacked.DexBackedClassDef.4.1
                        private int count;
                        private int previousIndex;

                        @Nullable
                        private MethodReference previousMethod;

                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // org.jf.dexlib2.dexbacked.util.VariableSizeLookaheadIterator
                        @Nullable
                        public DexBackedMethod readNextItem(@Nonnull DexReader dexReader) {
                            DexBackedMethod dexBackedMethod;
                            MethodReference methodReference;
                            ImmutableMethodReference of5;
                            do {
                                int i3 = this.count + 1;
                                this.count = i3;
                                if (i3 > DexBackedClassDef.this.directMethodCount) {
                                    DexBackedClassDef.this.virtualMethodsOffset = dexReader.getOffset();
                                    return endOfData();
                                }
                                Iterator it = restrictionsForDirectMethods;
                                int intValue = it != null ? ((Integer) it.next()).intValue() : 7;
                                DexBackedClassDef dexBackedClassDef = DexBackedClassDef.this;
                                dexBackedMethod = new DexBackedMethod(dexBackedClassDef.dexFile, dexReader, dexBackedClassDef, this.previousIndex, methodAnnotationIterator, parameterAnnotationIterator, intValue);
                                methodReference = this.previousMethod;
                                of5 = ImmutableMethodReference.of(dexBackedMethod);
                                this.previousMethod = of5;
                                this.previousIndex = dexBackedMethod.methodIndex;
                                if (!z16 || methodReference == null) {
                                    break;
                                }
                            } while (methodReference.equals(of5));
                            return dexBackedMethod;
                        }
                    };
                }
            };
        }
        int i3 = this.directMethodsOffset;
        if (i3 > 0) {
            this.virtualMethodsOffset = i3;
        }
        return ImmutableSet.of();
    }

    @Nonnull
    public Iterable<? extends DexBackedField> getInstanceFields(final boolean z16) {
        if (this.instanceFieldCount > 0) {
            DexReader<? extends DexBuffer> readerAt = this.dexFile.getDataBuffer().readerAt(getInstanceFieldsOffset());
            final AnnotationsDirectory annotationsDirectory = getAnnotationsDirectory();
            final int offset = readerAt.getOffset();
            HiddenApiRestrictionsReader hiddenApiRestrictionsReader = this.hiddenApiRestrictionsReader;
            final Iterator restrictionsForInstanceFields = hiddenApiRestrictionsReader == null ? null : hiddenApiRestrictionsReader.getRestrictionsForInstanceFields();
            return new Iterable<DexBackedField>() { // from class: org.jf.dexlib2.dexbacked.DexBackedClassDef.3
                @Override // java.lang.Iterable
                @Nonnull
                public Iterator<DexBackedField> iterator() {
                    final AnnotationsDirectory.AnnotationIterator fieldAnnotationIterator = annotationsDirectory.getFieldAnnotationIterator();
                    return new VariableSizeLookaheadIterator<DexBackedField>(DexBackedClassDef.this.dexFile.getDataBuffer(), offset) { // from class: org.jf.dexlib2.dexbacked.DexBackedClassDef.3.1
                        private int count;

                        @Nullable
                        private FieldReference previousField;
                        private int previousIndex;

                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // org.jf.dexlib2.dexbacked.util.VariableSizeLookaheadIterator
                        @Nullable
                        public DexBackedField readNextItem(@Nonnull DexReader dexReader) {
                            DexBackedField dexBackedField;
                            FieldReference fieldReference;
                            ImmutableFieldReference of5;
                            do {
                                int i3 = this.count + 1;
                                this.count = i3;
                                if (i3 > DexBackedClassDef.this.instanceFieldCount) {
                                    DexBackedClassDef.this.directMethodsOffset = dexReader.getOffset();
                                    return endOfData();
                                }
                                Iterator it = restrictionsForInstanceFields;
                                int intValue = it != null ? ((Integer) it.next()).intValue() : 7;
                                DexBackedClassDef dexBackedClassDef = DexBackedClassDef.this;
                                dexBackedField = new DexBackedField(dexBackedClassDef.dexFile, dexReader, dexBackedClassDef, this.previousIndex, fieldAnnotationIterator, intValue);
                                fieldReference = this.previousField;
                                of5 = ImmutableFieldReference.of(dexBackedField);
                                this.previousField = of5;
                                this.previousIndex = dexBackedField.fieldIndex;
                                if (!z16 || fieldReference == null) {
                                    break;
                                }
                            } while (fieldReference.equals(of5));
                            return dexBackedField;
                        }
                    };
                }
            };
        }
        int i3 = this.instanceFieldsOffset;
        if (i3 > 0) {
            this.directMethodsOffset = i3;
        }
        return ImmutableSet.of();
    }

    @Nonnull
    public Iterable<? extends DexBackedField> getStaticFields(final boolean z16) {
        if (this.staticFieldCount > 0) {
            DexReader<? extends DexBuffer> readerAt = this.dexFile.getDataBuffer().readerAt(this.staticFieldsOffset);
            final AnnotationsDirectory annotationsDirectory = getAnnotationsDirectory();
            final int readSmallUint = this.dexFile.getBuffer().readSmallUint(this.classDefOffset + 28);
            final int offset = readerAt.getOffset();
            HiddenApiRestrictionsReader hiddenApiRestrictionsReader = this.hiddenApiRestrictionsReader;
            final VariableSizeListIterator restrictionsForStaticFields = hiddenApiRestrictionsReader == null ? null : hiddenApiRestrictionsReader.getRestrictionsForStaticFields();
            return new Iterable<DexBackedField>() { // from class: org.jf.dexlib2.dexbacked.DexBackedClassDef.2
                @Override // java.lang.Iterable
                @Nonnull
                public Iterator<DexBackedField> iterator() {
                    final AnnotationsDirectory.AnnotationIterator fieldAnnotationIterator = annotationsDirectory.getFieldAnnotationIterator();
                    final EncodedArrayItemIterator newOrEmpty = EncodedArrayItemIterator.newOrEmpty(DexBackedClassDef.this.dexFile, readSmallUint);
                    return new VariableSizeLookaheadIterator<DexBackedField>(DexBackedClassDef.this.dexFile.getDataBuffer(), offset) { // from class: org.jf.dexlib2.dexbacked.DexBackedClassDef.2.1
                        private int count;

                        @Nullable
                        private FieldReference previousField;
                        private int previousIndex;

                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // org.jf.dexlib2.dexbacked.util.VariableSizeLookaheadIterator
                        @Nullable
                        public DexBackedField readNextItem(@Nonnull DexReader dexReader) {
                            DexBackedField dexBackedField;
                            FieldReference fieldReference;
                            ImmutableFieldReference of5;
                            do {
                                int i3 = this.count + 1;
                                this.count = i3;
                                if (i3 > DexBackedClassDef.this.staticFieldCount) {
                                    DexBackedClassDef.this.instanceFieldsOffset = dexReader.getOffset();
                                    return endOfData();
                                }
                                Iterator it = restrictionsForStaticFields;
                                int intValue = it != null ? ((Integer) it.next()).intValue() : 7;
                                DexBackedClassDef dexBackedClassDef = DexBackedClassDef.this;
                                dexBackedField = new DexBackedField(dexBackedClassDef.dexFile, dexReader, dexBackedClassDef, this.previousIndex, newOrEmpty, fieldAnnotationIterator, intValue);
                                fieldReference = this.previousField;
                                of5 = ImmutableFieldReference.of(dexBackedField);
                                this.previousField = of5;
                                this.previousIndex = dexBackedField.fieldIndex;
                                if (!z16 || fieldReference == null) {
                                    break;
                                }
                            } while (fieldReference.equals(of5));
                            return dexBackedField;
                        }
                    };
                }
            };
        }
        this.instanceFieldsOffset = this.staticFieldsOffset;
        return ImmutableSet.of();
    }

    @Override // org.jf.dexlib2.iface.ClassDef
    @Nonnull
    public Iterable<? extends DexBackedMethod> getVirtualMethods() {
        return getVirtualMethods(true);
    }
}
