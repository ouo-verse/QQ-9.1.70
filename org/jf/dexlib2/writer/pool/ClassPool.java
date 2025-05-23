package org.jf.dexlib2.writer.pool;

import com.google.common.base.d;
import com.google.common.base.k;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.google.common.collect.l;
import com.google.common.collect.q;
import java.io.IOException;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.HiddenApiRestriction;
import org.jf.dexlib2.builder.MutableMethodImplementation;
import org.jf.dexlib2.formatter.DexFormatter;
import org.jf.dexlib2.iface.Annotation;
import org.jf.dexlib2.iface.ClassDef;
import org.jf.dexlib2.iface.ExceptionHandler;
import org.jf.dexlib2.iface.Field;
import org.jf.dexlib2.iface.Method;
import org.jf.dexlib2.iface.MethodImplementation;
import org.jf.dexlib2.iface.MethodParameter;
import org.jf.dexlib2.iface.TryBlock;
import org.jf.dexlib2.iface.debug.DebugItem;
import org.jf.dexlib2.iface.debug.EndLocal;
import org.jf.dexlib2.iface.debug.LineNumber;
import org.jf.dexlib2.iface.debug.RestartLocal;
import org.jf.dexlib2.iface.debug.SetSourceFile;
import org.jf.dexlib2.iface.debug.StartLocal;
import org.jf.dexlib2.iface.instruction.Instruction;
import org.jf.dexlib2.iface.instruction.ReferenceInstruction;
import org.jf.dexlib2.iface.reference.CallSiteReference;
import org.jf.dexlib2.iface.reference.FieldReference;
import org.jf.dexlib2.iface.reference.MethodReference;
import org.jf.dexlib2.iface.reference.Reference;
import org.jf.dexlib2.iface.reference.StringReference;
import org.jf.dexlib2.iface.reference.TypeReference;
import org.jf.dexlib2.iface.value.ArrayEncodedValue;
import org.jf.dexlib2.iface.value.EncodedValue;
import org.jf.dexlib2.writer.ClassSection;
import org.jf.dexlib2.writer.DebugWriter;
import org.jf.dexlib2.writer.pool.TypeListPool;
import org.jf.dexlib2.writer.util.StaticInitializerUtil;
import org.jf.util.AbstractForwardSequentialList;
import org.jf.util.ExceptionWithContext;

/* loaded from: classes29.dex */
public class ClassPool extends BasePool<String, PoolClassDef> implements ClassSection<CharSequence, CharSequence, TypeListPool.Key<? extends Collection<? extends CharSequence>>, PoolClassDef, Field, PoolMethod, Set<? extends Annotation>, ArrayEncodedValue> {
    private static final k<MethodParameter> HAS_PARAMETER_ANNOTATIONS = new k<MethodParameter>() { // from class: org.jf.dexlib2.writer.pool.ClassPool.2
        @Override // com.google.common.base.k
        public boolean apply(MethodParameter methodParameter) {
            return methodParameter.getAnnotations().size() > 0;
        }
    };
    private static final d<MethodParameter, Set<? extends Annotation>> PARAMETER_ANNOTATIONS = new d<MethodParameter, Set<? extends Annotation>>() { // from class: org.jf.dexlib2.writer.pool.ClassPool.3
        @Override // com.google.common.base.d
        public Set<? extends Annotation> apply(MethodParameter methodParameter) {
            return methodParameter.getAnnotations();
        }
    };
    private ImmutableList<PoolClassDef> sortedClasses;

    public ClassPool(@Nonnull DexPool dexPool) {
        super(dexPool);
        this.sortedClasses = null;
    }

    private void internCode(@Nonnull Method method) {
        MethodImplementation implementation = method.getImplementation();
        if (implementation != null) {
            boolean z16 = false;
            for (Instruction instruction : implementation.getInstructions()) {
                if (instruction instanceof ReferenceInstruction) {
                    Reference reference = ((ReferenceInstruction) instruction).getReference();
                    int i3 = instruction.getOpcode().referenceType;
                    if (i3 != 0) {
                        if (i3 != 1) {
                            if (i3 != 2) {
                                if (i3 != 3) {
                                    if (i3 == 5) {
                                        ((CallSitePool) this.dexPool.callSiteSection).intern((CallSiteReference) reference);
                                    } else {
                                        throw new ExceptionWithContext("Unrecognized reference type: %d", Integer.valueOf(instruction.getOpcode().referenceType));
                                    }
                                } else {
                                    ((MethodPool) this.dexPool.methodSection).intern((MethodReference) reference);
                                }
                            } else {
                                ((FieldPool) this.dexPool.fieldSection).intern((FieldReference) reference);
                            }
                        } else {
                            ((TypePool) this.dexPool.typeSection).intern(((TypeReference) reference).getType());
                        }
                    } else {
                        ((StringPool) this.dexPool.stringSection).intern((StringReference) reference);
                    }
                }
                z16 = true;
            }
            List<? extends TryBlock<? extends ExceptionHandler>> tryBlocks = implementation.getTryBlocks();
            if (!z16 && tryBlocks.size() > 0) {
                throw new ExceptionWithContext("Method %s has no instructions, but has try blocks.", method);
            }
            Iterator<? extends TryBlock<? extends ExceptionHandler>> it = implementation.getTryBlocks().iterator();
            while (it.hasNext()) {
                Iterator<? extends Object> it5 = it.next().getExceptionHandlers().iterator();
                while (it5.hasNext()) {
                    ((TypePool) this.dexPool.typeSection).internNullable(((ExceptionHandler) it5.next()).getExceptionType());
                }
            }
        }
    }

    private void internDebug(@Nonnull Method method) {
        Iterator<? extends MethodParameter> it = method.getParameters().iterator();
        while (it.hasNext()) {
            String name = it.next().getName();
            if (name != null) {
                ((StringPool) this.dexPool.stringSection).intern(name);
            }
        }
        MethodImplementation implementation = method.getImplementation();
        if (implementation != null) {
            for (DebugItem debugItem : implementation.getDebugItems()) {
                int debugItemType = debugItem.getDebugItemType();
                if (debugItemType != 3) {
                    if (debugItemType == 9) {
                        ((StringPool) this.dexPool.stringSection).internNullable(((SetSourceFile) debugItem).getSourceFile());
                    }
                } else {
                    StartLocal startLocal = (StartLocal) debugItem;
                    ((StringPool) this.dexPool.stringSection).internNullable(startLocal.getName());
                    ((TypePool) this.dexPool.typeSection).internNullable(startLocal.getType());
                    ((StringPool) this.dexPool.stringSection).internNullable(startLocal.getSignature());
                }
            }
        }
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nullable
    public Map.Entry<? extends PoolClassDef, Integer> getClassEntryByType(@Nullable CharSequence charSequence) {
        final PoolClassDef poolClassDef;
        if (charSequence == null || (poolClassDef = (PoolClassDef) this.internedItems.get(charSequence.toString())) == null) {
            return null;
        }
        return new Map.Entry<PoolClassDef, Integer>() { // from class: org.jf.dexlib2.writer.pool.ClassPool.1
            @Override // java.util.Map.Entry
            public PoolClassDef getKey() {
                return poolClassDef;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Map.Entry
            public Integer getValue() {
                return Integer.valueOf(poolClassDef.classDefIndex);
            }

            @Override // java.util.Map.Entry
            public Integer setValue(Integer num) {
                PoolClassDef poolClassDef2 = poolClassDef;
                int intValue = num.intValue();
                poolClassDef2.classDefIndex = intValue;
                return Integer.valueOf(intValue);
            }
        };
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nullable
    public CharSequence getExceptionType(@Nonnull ExceptionHandler exceptionHandler) {
        return exceptionHandler.getExceptionType();
    }

    @Override // org.jf.dexlib2.writer.IndexSection
    @Nonnull
    public Collection<? extends Map.Entry<PoolClassDef, Integer>> getItems() {
        return new AbstractCollection<Map.Entry<PoolClassDef, Integer>>() { // from class: org.jf.dexlib2.writer.pool.ClassPool.6
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            @Nonnull
            public Iterator<Map.Entry<PoolClassDef, Integer>> iterator() {
                return new Iterator<Map.Entry<PoolClassDef, Integer>>() { // from class: org.jf.dexlib2.writer.pool.ClassPool.6.1
                    Iterator<PoolClassDef> iter;

                    {
                        this.iter = ClassPool.this.internedItems.values().iterator();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.iter.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }

                    @Override // java.util.Iterator
                    public Map.Entry<PoolClassDef, Integer> next() {
                        return new Map.Entry<PoolClassDef, Integer>(this.iter.next()) { // from class: org.jf.dexlib2.writer.pool.ClassPool.1MapEntry

                            @Nonnull
                            private final PoolClassDef classDef;

                            {
                                this.classDef = r2;
                            }

                            @Override // java.util.Map.Entry
                            public PoolClassDef getKey() {
                                return this.classDef;
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // java.util.Map.Entry
                            public Integer getValue() {
                                return Integer.valueOf(this.classDef.classDefIndex);
                            }

                            @Override // java.util.Map.Entry
                            public Integer setValue(Integer num) {
                                PoolClassDef poolClassDef = this.classDef;
                                int i3 = poolClassDef.classDefIndex;
                                poolClassDef.classDefIndex = num.intValue();
                                return Integer.valueOf(i3);
                            }
                        };
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return ClassPool.this.internedItems.size();
            }
        };
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nonnull
    public Collection<? extends PoolClassDef> getSortedClasses() {
        if (this.sortedClasses == null) {
            this.sortedClasses = Ordering.natural().immutableSortedCopy(this.internedItems.values());
        }
        return this.sortedClasses;
    }

    public void intern(@Nonnull ClassDef classDef) {
        PoolClassDef poolClassDef = new PoolClassDef(classDef);
        if (((PoolClassDef) this.internedItems.put(poolClassDef.getType(), poolClassDef)) == null) {
            ((TypePool) this.dexPool.typeSection).intern(poolClassDef.getType());
            ((TypePool) this.dexPool.typeSection).internNullable(poolClassDef.getSuperclass());
            ((TypeListPool) this.dexPool.typeListSection).intern(poolClassDef.getInterfaces());
            ((StringPool) this.dexPool.stringSection).internNullable(poolClassDef.getSourceFile());
            HashSet hashSet = new HashSet();
            for (Field field : poolClassDef.getFields()) {
                String shortFieldDescriptor = DexFormatter.INSTANCE.getShortFieldDescriptor(field);
                if (hashSet.add(shortFieldDescriptor)) {
                    ((FieldPool) this.dexPool.fieldSection).intern(field);
                    EncodedValue initialValue = field.getInitialValue();
                    if (initialValue != null) {
                        this.dexPool.internEncodedValue(initialValue);
                    }
                    ((AnnotationSetPool) this.dexPool.annotationSetSection).intern(field.getAnnotations());
                    ArrayEncodedValue staticInitializers = getStaticInitializers(poolClassDef);
                    if (staticInitializers != null) {
                        ((EncodedArrayPool) this.dexPool.encodedArraySection).intern(staticInitializers);
                    }
                } else {
                    throw new ExceptionWithContext("Multiple definitions for field %s->%s", poolClassDef.getType(), shortFieldDescriptor);
                }
            }
            HashSet hashSet2 = new HashSet();
            for (PoolMethod poolMethod : poolClassDef.getMethods()) {
                String shortMethodDescriptor = DexFormatter.INSTANCE.getShortMethodDescriptor(poolMethod);
                if (hashSet2.add(shortMethodDescriptor)) {
                    ((MethodPool) this.dexPool.methodSection).intern(poolMethod);
                    internCode(poolMethod);
                    internDebug(poolMethod);
                    ((AnnotationSetPool) this.dexPool.annotationSetSection).intern(poolMethod.getAnnotations());
                    Iterator<? extends MethodParameter> it = poolMethod.getParameters().iterator();
                    while (it.hasNext()) {
                        ((AnnotationSetPool) this.dexPool.annotationSetSection).intern(it.next().getAnnotations());
                    }
                } else {
                    throw new ExceptionWithContext("Multiple definitions for method %s->%s", poolClassDef.getType(), shortMethodDescriptor);
                }
            }
            ((AnnotationSetPool) this.dexPool.annotationSetSection).intern(poolClassDef.getAnnotations());
            return;
        }
        throw new ExceptionWithContext("Class %s has already been interned", poolClassDef.getType());
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    public void writeDebugItem(@Nonnull DebugWriter<CharSequence, CharSequence> debugWriter, DebugItem debugItem) throws IOException {
        switch (debugItem.getDebugItemType()) {
            case 3:
                StartLocal startLocal = (StartLocal) debugItem;
                debugWriter.writeStartLocal(startLocal.getCodeAddress(), startLocal.getRegister(), startLocal.getName(), startLocal.getType(), startLocal.getSignature());
                return;
            case 5:
                EndLocal endLocal = (EndLocal) debugItem;
                debugWriter.writeEndLocal(endLocal.getCodeAddress(), endLocal.getRegister());
                return;
            case 6:
                RestartLocal restartLocal = (RestartLocal) debugItem;
                debugWriter.writeRestartLocal(restartLocal.getCodeAddress(), restartLocal.getRegister());
                return;
            case 7:
                debugWriter.writePrologueEnd(debugItem.getCodeAddress());
                return;
            case 8:
                debugWriter.writeEpilogueBegin(debugItem.getCodeAddress());
                return;
            case 9:
                SetSourceFile setSourceFile = (SetSourceFile) debugItem;
                debugWriter.writeSetSourceFile(setSourceFile.getCodeAddress(), setSourceFile.getSourceFile());
                break;
            case 10:
                LineNumber lineNumber = (LineNumber) debugItem;
                debugWriter.writeLineNumber(lineNumber.getCodeAddress(), lineNumber.getLineNumber());
                return;
        }
        throw new ExceptionWithContext("Unexpected debug item type: %d", Integer.valueOf(debugItem.getDebugItemType()));
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    public int getAccessFlags(@Nonnull PoolClassDef poolClassDef) {
        return poolClassDef.getAccessFlags();
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    public int getAnnotationDirectoryOffset(@Nonnull PoolClassDef poolClassDef) {
        return poolClassDef.annotationDirectoryOffset;
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    public int getAnnotationSetRefListOffset(@Nonnull PoolMethod poolMethod) {
        return poolMethod.annotationSetRefListOffset;
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nullable
    public Set<? extends Annotation> getClassAnnotations(@Nonnull PoolClassDef poolClassDef) {
        Set<? extends Annotation> annotations = poolClassDef.getAnnotations();
        if (annotations.size() == 0) {
            return null;
        }
        return annotations;
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    public int getCodeItemOffset(@Nonnull PoolMethod poolMethod) {
        return poolMethod.codeItemOffset;
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nullable
    public Iterable<? extends DebugItem> getDebugItems(@Nonnull PoolMethod poolMethod) {
        MethodImplementation implementation = poolMethod.getImplementation();
        if (implementation != null) {
            return implementation.getDebugItems();
        }
        return null;
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    public int getFieldAccessFlags(@Nonnull Field field) {
        return field.getAccessFlags();
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nullable
    public Set<? extends Annotation> getFieldAnnotations(@Nonnull Field field) {
        Set<? extends Annotation> annotations = field.getAnnotations();
        if (annotations.size() == 0) {
            return null;
        }
        return annotations;
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nonnull
    public Set<HiddenApiRestriction> getFieldHiddenApiRestrictions(@Nonnull Field field) {
        return field.getHiddenApiRestrictions();
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nullable
    public Iterable<? extends Instruction> getInstructions(@Nonnull PoolMethod poolMethod) {
        MethodImplementation implementation = poolMethod.getImplementation();
        if (implementation != null) {
            return implementation.getInstructions();
        }
        return null;
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nullable
    public TypeListPool.Key<List<String>> getInterfaces(@Nonnull PoolClassDef poolClassDef) {
        return poolClassDef.interfaces;
    }

    @Override // org.jf.dexlib2.writer.IndexSection
    public int getItemIndex(@Nonnull PoolClassDef poolClassDef) {
        return poolClassDef.classDefIndex;
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    public int getMethodAccessFlags(@Nonnull PoolMethod poolMethod) {
        return poolMethod.getAccessFlags();
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nullable
    public Set<? extends Annotation> getMethodAnnotations(@Nonnull PoolMethod poolMethod) {
        Set<? extends Annotation> annotations = poolMethod.getAnnotations();
        if (annotations.size() == 0) {
            return null;
        }
        return annotations;
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nonnull
    public Set<HiddenApiRestriction> getMethodHiddenApiRestrictions(@Nonnull PoolMethod poolMethod) {
        return poolMethod.getHiddenApiRestrictions();
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nullable
    public List<? extends Set<? extends Annotation>> getParameterAnnotations(@Nonnull PoolMethod poolMethod) {
        final List<? extends MethodParameter> parameters = poolMethod.getParameters();
        if (q.b(parameters, HAS_PARAMETER_ANNOTATIONS)) {
            return new AbstractForwardSequentialList<Set<? extends Annotation>>() { // from class: org.jf.dexlib2.writer.pool.ClassPool.4
                @Override // org.jf.util.AbstractForwardSequentialList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
                @Nonnull
                public Iterator<Set<? extends Annotation>> iterator() {
                    return l.i(parameters).o(ClassPool.PARAMETER_ANNOTATIONS).iterator();
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return parameters.size();
                }
            };
        }
        return null;
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nullable
    public Iterable<CharSequence> getParameterNames(@Nonnull PoolMethod poolMethod) {
        return q.o(poolMethod.getParameters(), new d<MethodParameter, CharSequence>() { // from class: org.jf.dexlib2.writer.pool.ClassPool.5
            @Override // com.google.common.base.d
            @Nullable
            public CharSequence apply(MethodParameter methodParameter) {
                return methodParameter.getName();
            }
        });
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    public int getRegisterCount(@Nonnull PoolMethod poolMethod) {
        MethodImplementation implementation = poolMethod.getImplementation();
        if (implementation != null) {
            return implementation.getRegisterCount();
        }
        return 0;
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nonnull
    public Collection<PoolMethod> getSortedDirectMethods(@Nonnull PoolClassDef poolClassDef) {
        return poolClassDef.getDirectMethods();
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nonnull
    public Collection<? extends Field> getSortedFields(@Nonnull PoolClassDef poolClassDef) {
        return poolClassDef.getFields();
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nonnull
    public Collection<? extends Field> getSortedInstanceFields(@Nonnull PoolClassDef poolClassDef) {
        return poolClassDef.getInstanceFields();
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nonnull
    public Collection<? extends PoolMethod> getSortedMethods(@Nonnull PoolClassDef poolClassDef) {
        return poolClassDef.getMethods();
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nonnull
    public Collection<? extends Field> getSortedStaticFields(@Nonnull PoolClassDef poolClassDef) {
        return poolClassDef.getStaticFields();
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nonnull
    public Collection<PoolMethod> getSortedVirtualMethods(@Nonnull PoolClassDef poolClassDef) {
        return poolClassDef.getVirtualMethods();
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nullable
    public CharSequence getSourceFile(@Nonnull PoolClassDef poolClassDef) {
        return poolClassDef.getSourceFile();
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nullable
    public ArrayEncodedValue getStaticInitializers(@Nonnull PoolClassDef poolClassDef) {
        return StaticInitializerUtil.getStaticInitializers(poolClassDef.getStaticFields());
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nullable
    public CharSequence getSuperclass(@Nonnull PoolClassDef poolClassDef) {
        return poolClassDef.getSuperclass();
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nonnull
    public List<? extends TryBlock<? extends ExceptionHandler>> getTryBlocks(@Nonnull PoolMethod poolMethod) {
        MethodImplementation implementation = poolMethod.getImplementation();
        if (implementation != null) {
            return implementation.getTryBlocks();
        }
        return ImmutableList.of();
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nonnull
    public CharSequence getType(@Nonnull PoolClassDef poolClassDef) {
        return poolClassDef.getType();
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nonnull
    public MutableMethodImplementation makeMutableMethodImplementation(@Nonnull PoolMethod poolMethod) {
        return new MutableMethodImplementation(poolMethod.getImplementation());
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    public void setAnnotationDirectoryOffset(@Nonnull PoolClassDef poolClassDef, int i3) {
        poolClassDef.annotationDirectoryOffset = i3;
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    public void setAnnotationSetRefListOffset(@Nonnull PoolMethod poolMethod, int i3) {
        poolMethod.annotationSetRefListOffset = i3;
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    public void setCodeItemOffset(@Nonnull PoolMethod poolMethod, int i3) {
        poolMethod.codeItemOffset = i3;
    }
}
