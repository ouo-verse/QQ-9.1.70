package org.jf.dexlib2.writer.builder;

import com.google.common.base.d;
import com.google.common.base.k;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.collect.l;
import com.google.common.collect.q;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.HiddenApiRestriction;
import org.jf.dexlib2.builder.MutableMethodImplementation;
import org.jf.dexlib2.iface.ExceptionHandler;
import org.jf.dexlib2.iface.Field;
import org.jf.dexlib2.iface.MethodImplementation;
import org.jf.dexlib2.iface.TryBlock;
import org.jf.dexlib2.iface.debug.DebugItem;
import org.jf.dexlib2.iface.debug.EndLocal;
import org.jf.dexlib2.iface.debug.LineNumber;
import org.jf.dexlib2.iface.debug.RestartLocal;
import org.jf.dexlib2.iface.debug.SetSourceFile;
import org.jf.dexlib2.iface.debug.StartLocal;
import org.jf.dexlib2.iface.instruction.Instruction;
import org.jf.dexlib2.iface.reference.StringReference;
import org.jf.dexlib2.iface.reference.TypeReference;
import org.jf.dexlib2.iface.value.EncodedValue;
import org.jf.dexlib2.util.EncodedValueUtils;
import org.jf.dexlib2.writer.ClassSection;
import org.jf.dexlib2.writer.DebugWriter;
import org.jf.dexlib2.writer.builder.BuilderEncodedValues;
import org.jf.util.AbstractForwardSequentialList;
import org.jf.util.ExceptionWithContext;

/* loaded from: classes29.dex */
public class BuilderClassPool extends BaseBuilderPool implements ClassSection<BuilderStringReference, BuilderTypeReference, BuilderTypeList, BuilderClassDef, BuilderField, BuilderMethod, BuilderAnnotationSet, BuilderEncodedValues.BuilderArrayEncodedValue> {

    @Nonnull
    private final ConcurrentMap<String, BuilderClassDef> internedItems;
    private ImmutableList<BuilderClassDef> sortedClasses;
    private static final k<Field> HAS_INITIALIZER = new k<Field>() { // from class: org.jf.dexlib2.writer.builder.BuilderClassPool.2
        @Override // com.google.common.base.k
        public boolean apply(Field field) {
            EncodedValue initialValue = field.getInitialValue();
            return (initialValue == null || EncodedValueUtils.isDefaultValue(initialValue)) ? false : true;
        }
    };
    private static final d<BuilderField, BuilderEncodedValues.BuilderEncodedValue> GET_INITIAL_VALUE = new d<BuilderField, BuilderEncodedValues.BuilderEncodedValue>() { // from class: org.jf.dexlib2.writer.builder.BuilderClassPool.3
        @Override // com.google.common.base.d
        public BuilderEncodedValues.BuilderEncodedValue apply(BuilderField builderField) {
            BuilderEncodedValues.BuilderEncodedValue initialValue = builderField.getInitialValue();
            return initialValue == null ? BuilderEncodedValues.defaultValueForType(builderField.getType()) : initialValue;
        }
    };
    private static final k<BuilderMethodParameter> HAS_PARAMETER_ANNOTATIONS = new k<BuilderMethodParameter>() { // from class: org.jf.dexlib2.writer.builder.BuilderClassPool.4
        @Override // com.google.common.base.k
        public boolean apply(BuilderMethodParameter builderMethodParameter) {
            return builderMethodParameter.getAnnotations().size() > 0;
        }
    };
    private static final d<BuilderMethodParameter, BuilderAnnotationSet> PARAMETER_ANNOTATIONS = new d<BuilderMethodParameter, BuilderAnnotationSet>() { // from class: org.jf.dexlib2.writer.builder.BuilderClassPool.5
        @Override // com.google.common.base.d
        public BuilderAnnotationSet apply(BuilderMethodParameter builderMethodParameter) {
            return builderMethodParameter.getAnnotations();
        }
    };

    public BuilderClassPool(@Nonnull DexBuilder dexBuilder) {
        super(dexBuilder);
        this.internedItems = Maps.i();
        this.sortedClasses = null;
    }

    @Nullable
    private BuilderStringReference checkStringReference(@Nullable StringReference stringReference) {
        if (stringReference == null) {
            return null;
        }
        try {
            return (BuilderStringReference) stringReference;
        } catch (ClassCastException unused) {
            throw new IllegalStateException("Only StringReference instances returned by DexBuilder.internStringReference or DexBuilder.internNullableStringReference may be used.");
        }
    }

    @Nullable
    private BuilderTypeReference checkTypeReference(@Nullable TypeReference typeReference) {
        if (typeReference == null) {
            return null;
        }
        try {
            return (BuilderTypeReference) typeReference;
        } catch (ClassCastException unused) {
            throw new IllegalStateException("Only TypeReference instances returned by DexBuilder.internTypeReference or DexBuilder.internNullableTypeReference may be used.");
        }
    }

    @Override // org.jf.dexlib2.writer.IndexSection
    public int getItemCount() {
        return this.internedItems.size();
    }

    @Override // org.jf.dexlib2.writer.IndexSection
    @Nonnull
    public Collection<? extends Map.Entry<? extends BuilderClassDef, Integer>> getItems() {
        return new BuilderMapEntryCollection<BuilderClassDef>(this.internedItems.values()) { // from class: org.jf.dexlib2.writer.builder.BuilderClassPool.8
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.jf.dexlib2.writer.builder.BuilderMapEntryCollection
            public int getValue(@Nonnull BuilderClassDef builderClassDef) {
                return builderClassDef.classDefIndex;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.jf.dexlib2.writer.builder.BuilderMapEntryCollection
            public int setValue(@Nonnull BuilderClassDef builderClassDef, int i3) {
                int i16 = builderClassDef.classDefIndex;
                builderClassDef.classDefIndex = i3;
                return i16;
            }
        };
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nonnull
    public Collection<? extends BuilderClassDef> getSortedClasses() {
        if (this.sortedClasses == null) {
            this.sortedClasses = Ordering.natural().immutableSortedCopy(this.internedItems.values());
        }
        return this.sortedClasses;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nonnull
    public BuilderClassDef internClass(@Nonnull BuilderClassDef builderClassDef) {
        if (this.internedItems.put(builderClassDef.getType(), builderClassDef) == null) {
            return builderClassDef;
        }
        throw new ExceptionWithContext("Class %s has already been interned", builderClassDef.getType());
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    public void writeDebugItem(@Nonnull DebugWriter<BuilderStringReference, BuilderTypeReference> debugWriter, DebugItem debugItem) throws IOException {
        switch (debugItem.getDebugItemType()) {
            case 3:
                StartLocal startLocal = (StartLocal) debugItem;
                debugWriter.writeStartLocal(startLocal.getCodeAddress(), startLocal.getRegister(), checkStringReference(startLocal.getNameReference()), checkTypeReference(startLocal.getTypeReference()), checkStringReference(startLocal.getSignatureReference()));
                return;
            case 4:
            default:
                throw new ExceptionWithContext("Unexpected debug item type: %d", Integer.valueOf(debugItem.getDebugItemType()));
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
                debugWriter.writeSetSourceFile(setSourceFile.getCodeAddress(), checkStringReference(setSourceFile.getSourceFileReference()));
                return;
            case 10:
                LineNumber lineNumber = (LineNumber) debugItem;
                debugWriter.writeLineNumber(lineNumber.getCodeAddress(), lineNumber.getLineNumber());
                return;
        }
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    public int getAccessFlags(@Nonnull BuilderClassDef builderClassDef) {
        return builderClassDef.accessFlags;
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    public int getAnnotationDirectoryOffset(@Nonnull BuilderClassDef builderClassDef) {
        return builderClassDef.annotationDirectoryOffset;
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    public int getAnnotationSetRefListOffset(@Nonnull BuilderMethod builderMethod) {
        return builderMethod.annotationSetRefListOffset;
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nullable
    public BuilderAnnotationSet getClassAnnotations(@Nonnull BuilderClassDef builderClassDef) {
        if (builderClassDef.annotations.isEmpty()) {
            return null;
        }
        return builderClassDef.annotations;
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nullable
    public Map.Entry<? extends BuilderClassDef, Integer> getClassEntryByType(@Nullable BuilderTypeReference builderTypeReference) {
        final BuilderClassDef builderClassDef;
        if (builderTypeReference == null || (builderClassDef = this.internedItems.get(builderTypeReference.getType())) == null) {
            return null;
        }
        return new Map.Entry<BuilderClassDef, Integer>() { // from class: org.jf.dexlib2.writer.builder.BuilderClassPool.1
            @Override // java.util.Map.Entry
            public BuilderClassDef getKey() {
                return builderClassDef;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Map.Entry
            public Integer getValue() {
                return Integer.valueOf(builderClassDef.classDefIndex);
            }

            @Override // java.util.Map.Entry
            public Integer setValue(Integer num) {
                BuilderClassDef builderClassDef2 = builderClassDef;
                int intValue = num.intValue();
                builderClassDef2.classDefIndex = intValue;
                return Integer.valueOf(intValue);
            }
        };
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    public int getCodeItemOffset(@Nonnull BuilderMethod builderMethod) {
        return builderMethod.codeItemOffset;
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nullable
    public Iterable<? extends DebugItem> getDebugItems(@Nonnull BuilderMethod builderMethod) {
        MethodImplementation implementation = builderMethod.getImplementation();
        if (implementation == null) {
            return null;
        }
        return implementation.getDebugItems();
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nullable
    public BuilderTypeReference getExceptionType(@Nonnull ExceptionHandler exceptionHandler) {
        return checkTypeReference(exceptionHandler.getExceptionTypeReference());
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    public int getFieldAccessFlags(@Nonnull BuilderField builderField) {
        return builderField.accessFlags;
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nullable
    public BuilderAnnotationSet getFieldAnnotations(@Nonnull BuilderField builderField) {
        if (builderField.annotations.isEmpty()) {
            return null;
        }
        return builderField.annotations;
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nonnull
    public Set<HiddenApiRestriction> getFieldHiddenApiRestrictions(@Nonnull BuilderField builderField) {
        return builderField.getHiddenApiRestrictions();
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nullable
    public Iterable<? extends Instruction> getInstructions(@Nonnull BuilderMethod builderMethod) {
        MethodImplementation implementation = builderMethod.getImplementation();
        if (implementation == null) {
            return null;
        }
        return implementation.getInstructions();
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nullable
    public BuilderTypeList getInterfaces(@Nonnull BuilderClassDef builderClassDef) {
        return builderClassDef.interfaces;
    }

    @Override // org.jf.dexlib2.writer.IndexSection
    public int getItemIndex(@Nonnull BuilderClassDef builderClassDef) {
        return builderClassDef.classDefIndex;
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    public int getMethodAccessFlags(@Nonnull BuilderMethod builderMethod) {
        return builderMethod.accessFlags;
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nullable
    public BuilderAnnotationSet getMethodAnnotations(@Nonnull BuilderMethod builderMethod) {
        if (builderMethod.annotations.isEmpty()) {
            return null;
        }
        return builderMethod.annotations;
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nonnull
    public Set<HiddenApiRestriction> getMethodHiddenApiRestrictions(@Nonnull BuilderMethod builderMethod) {
        return builderMethod.getHiddenApiRestrictions();
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nullable
    public List<? extends BuilderAnnotationSet> getParameterAnnotations(@Nonnull BuilderMethod builderMethod) {
        final List<? extends BuilderMethodParameter> parameters = builderMethod.getParameters();
        if (q.b(parameters, HAS_PARAMETER_ANNOTATIONS)) {
            return new AbstractForwardSequentialList<BuilderAnnotationSet>() { // from class: org.jf.dexlib2.writer.builder.BuilderClassPool.6
                @Override // org.jf.util.AbstractForwardSequentialList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
                @Nonnull
                public Iterator<BuilderAnnotationSet> iterator() {
                    return l.i(parameters).o(BuilderClassPool.PARAMETER_ANNOTATIONS).iterator();
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
    public Iterable<? extends BuilderStringReference> getParameterNames(@Nonnull BuilderMethod builderMethod) {
        return q.o(builderMethod.getParameters(), new d<BuilderMethodParameter, BuilderStringReference>() { // from class: org.jf.dexlib2.writer.builder.BuilderClassPool.7
            @Override // com.google.common.base.d
            @Nullable
            public BuilderStringReference apply(BuilderMethodParameter builderMethodParameter) {
                return builderMethodParameter.name;
            }
        });
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    public int getRegisterCount(@Nonnull BuilderMethod builderMethod) {
        MethodImplementation implementation = builderMethod.getImplementation();
        if (implementation == null) {
            return 0;
        }
        return implementation.getRegisterCount();
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nonnull
    public Collection<? extends BuilderMethod> getSortedDirectMethods(@Nonnull BuilderClassDef builderClassDef) {
        return builderClassDef.getDirectMethods();
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nonnull
    public Collection<? extends BuilderField> getSortedFields(@Nonnull BuilderClassDef builderClassDef) {
        return builderClassDef.getFields();
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nonnull
    public Collection<? extends BuilderField> getSortedInstanceFields(@Nonnull BuilderClassDef builderClassDef) {
        return builderClassDef.getInstanceFields();
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nonnull
    public Collection<? extends BuilderMethod> getSortedMethods(@Nonnull BuilderClassDef builderClassDef) {
        return builderClassDef.getMethods();
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nonnull
    public Collection<? extends BuilderField> getSortedStaticFields(@Nonnull BuilderClassDef builderClassDef) {
        return builderClassDef.getStaticFields();
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nonnull
    public Collection<? extends BuilderMethod> getSortedVirtualMethods(@Nonnull BuilderClassDef builderClassDef) {
        return builderClassDef.getVirtualMethods();
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nullable
    public BuilderStringReference getSourceFile(@Nonnull BuilderClassDef builderClassDef) {
        return builderClassDef.sourceFile;
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nullable
    public BuilderEncodedValues.BuilderArrayEncodedValue getStaticInitializers(@Nonnull BuilderClassDef builderClassDef) {
        return builderClassDef.staticInitializers;
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nullable
    public BuilderTypeReference getSuperclass(@Nonnull BuilderClassDef builderClassDef) {
        return builderClassDef.superclass;
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nonnull
    public List<? extends TryBlock<? extends ExceptionHandler>> getTryBlocks(@Nonnull BuilderMethod builderMethod) {
        MethodImplementation implementation = builderMethod.getImplementation();
        if (implementation == null) {
            return ImmutableList.of();
        }
        return implementation.getTryBlocks();
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nonnull
    public BuilderTypeReference getType(@Nonnull BuilderClassDef builderClassDef) {
        return builderClassDef.type;
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    @Nonnull
    public MutableMethodImplementation makeMutableMethodImplementation(@Nonnull BuilderMethod builderMethod) {
        MethodImplementation implementation = builderMethod.getImplementation();
        if (implementation instanceof MutableMethodImplementation) {
            return (MutableMethodImplementation) implementation;
        }
        return new MutableMethodImplementation(implementation);
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    public void setAnnotationDirectoryOffset(@Nonnull BuilderClassDef builderClassDef, int i3) {
        builderClassDef.annotationDirectoryOffset = i3;
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    public void setAnnotationSetRefListOffset(@Nonnull BuilderMethod builderMethod, int i3) {
        builderMethod.annotationSetRefListOffset = i3;
    }

    @Override // org.jf.dexlib2.writer.ClassSection
    public void setCodeItemOffset(@Nonnull BuilderMethod builderMethod, int i3) {
        builderMethod.codeItemOffset = i3;
    }
}
