package org.jf.dexlib2.analysis;

import com.google.common.base.Predicates;
import com.google.common.base.Suppliers;
import com.google.common.base.e;
import com.google.common.base.o;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.l;
import com.google.common.collect.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.AccessFlags;
import org.jf.dexlib2.HiddenApiRestriction;
import org.jf.dexlib2.analysis.util.TypeProtoUtils;
import org.jf.dexlib2.base.reference.BaseMethodReference;
import org.jf.dexlib2.iface.Annotation;
import org.jf.dexlib2.iface.ClassDef;
import org.jf.dexlib2.iface.Field;
import org.jf.dexlib2.iface.Method;
import org.jf.dexlib2.iface.MethodImplementation;
import org.jf.dexlib2.iface.MethodParameter;
import org.jf.dexlib2.iface.reference.FieldReference;
import org.jf.dexlib2.iface.reference.MethodReference;
import org.jf.dexlib2.util.AlignmentUtils;
import org.jf.dexlib2.util.MethodUtil;
import org.jf.util.ExceptionWithContext;
import org.jf.util.SparseArray;
import s1.c;

/* loaded from: classes29.dex */
public class ClassProto implements TypeProto {
    private static final byte OTHER = 2;
    private static final byte REFERENCE = 0;
    private static final byte WIDE = 1;

    @Nonnull
    protected final ClassPath classPath;

    @Nonnull
    protected final String type;
    protected boolean vtableFullyResolved = true;
    protected boolean interfacesFullyResolved = true;
    protected Set<String> unresolvedInterfaces = null;

    @Nonnull
    private final o<ClassDef> classDefSupplier = Suppliers.a(new o<ClassDef>() { // from class: org.jf.dexlib2.analysis.ClassProto.1
        @Override // com.google.common.base.o
        public ClassDef get() {
            ClassProto classProto = ClassProto.this;
            return classProto.classPath.getClassDef(classProto.type);
        }
    });

    @Nonnull
    private final o<LinkedHashMap<String, ClassDef>> preDefaultMethodInterfaceSupplier = Suppliers.a(new o<LinkedHashMap<String, ClassDef>>() { // from class: org.jf.dexlib2.analysis.ClassProto.2
        @Override // com.google.common.base.o
        public LinkedHashMap<String, ClassDef> get() {
            HashSet hashSet = new HashSet(0);
            LinkedHashMap<String, ClassDef> k3 = Maps.k();
            try {
                for (String str : ClassProto.this.getClassDef().getInterfaces()) {
                    if (!k3.containsKey(str)) {
                        try {
                            k3.put(str, ClassProto.this.classPath.getClassDef(str));
                        } catch (UnresolvedClassException unused) {
                            k3.put(str, null);
                            hashSet.add(str);
                            ClassProto.this.interfacesFullyResolved = false;
                        }
                        ClassProto classProto = (ClassProto) ClassProto.this.classPath.getClass(str);
                        for (String str2 : classProto.getInterfaces().keySet()) {
                            if (!k3.containsKey(str2)) {
                                k3.put(str2, classProto.getInterfaces().get(str2));
                            }
                        }
                        if (!classProto.interfacesFullyResolved) {
                            hashSet.addAll(classProto.getUnresolvedInterfaces());
                            ClassProto.this.interfacesFullyResolved = false;
                        }
                    }
                }
            } catch (UnresolvedClassException unused2) {
                k3.put(ClassProto.this.type, null);
                hashSet.add(ClassProto.this.type);
                ClassProto.this.interfacesFullyResolved = false;
            }
            if (ClassProto.this.isInterface() && !k3.containsKey(ClassProto.this.getType())) {
                k3.put(ClassProto.this.getType(), null);
            }
            String superclass = ClassProto.this.getSuperclass();
            if (superclass != null) {
                try {
                    ClassProto classProto2 = (ClassProto) ClassProto.this.classPath.getClass(superclass);
                    for (String str3 : classProto2.getInterfaces().keySet()) {
                        if (!k3.containsKey(str3)) {
                            k3.put(str3, null);
                        }
                    }
                    if (!classProto2.interfacesFullyResolved) {
                        hashSet.addAll(classProto2.getUnresolvedInterfaces());
                        ClassProto.this.interfacesFullyResolved = false;
                    }
                } catch (UnresolvedClassException unused3) {
                    hashSet.add(superclass);
                    ClassProto.this.interfacesFullyResolved = false;
                }
            }
            if (hashSet.size() > 0) {
                ClassProto.this.unresolvedInterfaces = hashSet;
            }
            return k3;
        }
    });

    @Nonnull
    private final o<LinkedHashMap<String, ClassDef>> postDefaultMethodInterfaceSupplier = Suppliers.a(new o<LinkedHashMap<String, ClassDef>>() { // from class: org.jf.dexlib2.analysis.ClassProto.3
        @Override // com.google.common.base.o
        public LinkedHashMap<String, ClassDef> get() {
            HashSet hashSet = new HashSet(0);
            LinkedHashMap<String, ClassDef> k3 = Maps.k();
            String superclass = ClassProto.this.getSuperclass();
            if (superclass != null) {
                ClassProto classProto = (ClassProto) ClassProto.this.classPath.getClass(superclass);
                Iterator<String> it = classProto.getInterfaces().keySet().iterator();
                while (it.hasNext()) {
                    k3.put(it.next(), null);
                }
                if (!classProto.interfacesFullyResolved) {
                    hashSet.addAll(classProto.getUnresolvedInterfaces());
                    ClassProto.this.interfacesFullyResolved = false;
                }
            }
            try {
                for (String str : ClassProto.this.getClassDef().getInterfaces()) {
                    if (!k3.containsKey(str)) {
                        ClassProto classProto2 = (ClassProto) ClassProto.this.classPath.getClass(str);
                        try {
                            for (Map.Entry<String, ClassDef> entry : classProto2.getInterfaces().entrySet()) {
                                if (!k3.containsKey(entry.getKey())) {
                                    k3.put(entry.getKey(), entry.getValue());
                                }
                            }
                        } catch (UnresolvedClassException unused) {
                            k3.put(str, null);
                            hashSet.add(str);
                            ClassProto.this.interfacesFullyResolved = false;
                        }
                        if (!classProto2.interfacesFullyResolved) {
                            hashSet.addAll(classProto2.getUnresolvedInterfaces());
                            ClassProto.this.interfacesFullyResolved = false;
                        }
                        try {
                            k3.put(str, ClassProto.this.classPath.getClassDef(str));
                        } catch (UnresolvedClassException unused2) {
                            k3.put(str, null);
                            hashSet.add(str);
                            ClassProto.this.interfacesFullyResolved = false;
                        }
                    }
                }
            } catch (UnresolvedClassException unused3) {
                k3.put(ClassProto.this.type, null);
                hashSet.add(ClassProto.this.type);
                ClassProto.this.interfacesFullyResolved = false;
            }
            if (hashSet.size() > 0) {
                ClassProto.this.unresolvedInterfaces = hashSet;
            }
            return k3;
        }
    });

    @Nonnull
    private final o<SparseArray<FieldReference>> dalvikInstanceFieldsSupplier = Suppliers.a(new o<SparseArray<FieldReference>>() { // from class: org.jf.dexlib2.analysis.ClassProto.4
        static final /* synthetic */ boolean $assertionsDisabled = false;

        @Nonnull
        private ArrayList<Field> getSortedInstanceFields(@Nonnull ClassDef classDef) {
            ArrayList<Field> i3 = Lists.i(classDef.getInstanceFields());
            Collections.sort(i3);
            return i3;
        }

        private void swap(byte[] bArr, List<Field> list, int i3, int i16) {
            byte b16 = bArr[i3];
            bArr[i3] = bArr[i16];
            bArr[i16] = b16;
            list.set(i16, list.set(i3, list.get(i16)));
        }

        @Override // com.google.common.base.o
        public SparseArray<FieldReference> get() {
            ClassProto classProto;
            int i3;
            SparseArray<FieldReference> sparseArray;
            ArrayList<Field> sortedInstanceFields = getSortedInstanceFields(ClassProto.this.getClassDef());
            int size = sortedInstanceFields.size();
            byte[] bArr = new byte[sortedInstanceFields.size()];
            for (int i16 = 0; i16 < size; i16++) {
                bArr[i16] = ClassProto.getFieldType(sortedInstanceFields.get(i16));
            }
            int size2 = sortedInstanceFields.size() - 1;
            int i17 = 0;
            while (i17 < size) {
                if (bArr[i17] != 0) {
                    while (true) {
                        if (size2 <= i17) {
                            break;
                        }
                        if (bArr[size2] == 0) {
                            swap(bArr, sortedInstanceFields, i17, size2);
                            size2--;
                            break;
                        }
                        size2--;
                    }
                }
                if (bArr[i17] != 0) {
                    break;
                }
                i17++;
            }
            String superclass = ClassProto.this.getSuperclass();
            int i18 = 8;
            if (superclass != null) {
                classProto = (ClassProto) ClassProto.this.classPath.getClass(superclass);
                i3 = classProto.getNextFieldOffset();
            } else {
                classProto = null;
                i3 = 8;
            }
            int i19 = i3 % 8 == 0 ? 0 : 1;
            if (i17 < size && i17 % 2 != i19) {
                if (bArr[i17] == 1) {
                    int i26 = size - 1;
                    while (true) {
                        if (i26 <= i17) {
                            break;
                        }
                        if (bArr[i26] == 2) {
                            swap(bArr, sortedInstanceFields, i17, i26);
                            i17++;
                            break;
                        }
                        i26--;
                    }
                } else {
                    i17++;
                }
            }
            int i27 = size - 1;
            while (i17 < size) {
                if (bArr[i17] != 1) {
                    while (true) {
                        if (i27 <= i17) {
                            break;
                        }
                        if (bArr[i27] == 1) {
                            swap(bArr, sortedInstanceFields, i17, i27);
                            i27--;
                            break;
                        }
                        i27--;
                    }
                }
                if (bArr[i17] != 1) {
                    break;
                }
                i17++;
            }
            if (classProto != null) {
                sparseArray = classProto.getInstanceFields();
            } else {
                sparseArray = new SparseArray<>();
            }
            int size3 = sparseArray.size();
            SparseArray<FieldReference> sparseArray2 = new SparseArray<>(size3 + size);
            if (classProto != null && size3 > 0) {
                for (int i28 = 0; i28 < size3; i28++) {
                    sparseArray2.append(sparseArray.keyAt(i28), sparseArray.valueAt(i28));
                }
                int i29 = size3 - 1;
                int keyAt = sparseArray2.keyAt(i29);
                char charAt = sparseArray.valueAt(i29).getType().charAt(0);
                i18 = (charAt == 'J' || charAt == 'D') ? keyAt + 8 : keyAt + 4;
            }
            boolean z16 = false;
            for (int i36 = 0; i36 < size; i36++) {
                Field field = sortedInstanceFields.get(i36);
                if (bArr[i36] == 1 && !z16) {
                    if (i18 % 8 != 0) {
                        i18 += 4;
                    }
                    z16 = true;
                }
                sparseArray2.append(i18, field);
                i18 = bArr[i36] == 1 ? i18 + 8 : i18 + 4;
            }
            return sparseArray2;
        }
    });

    @Nonnull
    private final o<SparseArray<FieldReference>> artInstanceFieldsSupplier = Suppliers.a(new o<SparseArray<FieldReference>>() { // from class: org.jf.dexlib2.analysis.ClassProto.5
        private void addFieldGap(int i3, int i16, @Nonnull PriorityQueue<FieldGap> priorityQueue) {
            while (i3 < i16) {
                int i17 = i16 - i3;
                if (i17 >= 4 && i3 % 4 == 0) {
                    priorityQueue.add(FieldGap.newFieldGap(i3, 4, ClassProto.this.classPath.oatVersion));
                    i3 += 4;
                } else if (i17 >= 2 && i3 % 2 == 0) {
                    priorityQueue.add(FieldGap.newFieldGap(i3, 2, ClassProto.this.classPath.oatVersion));
                    i3 += 2;
                } else {
                    priorityQueue.add(FieldGap.newFieldGap(i3, 1, ClassProto.this.classPath.oatVersion));
                    i3++;
                }
            }
        }

        private int getFieldSize(@Nonnull FieldReference fieldReference) {
            return ClassProto.getTypeSize(fieldReference.getType().charAt(0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getFieldSortOrder(@Nonnull FieldReference fieldReference) {
            char charAt = fieldReference.getType().charAt(0);
            if (charAt != 'F') {
                if (charAt != 'L') {
                    if (charAt != 'S') {
                        if (charAt != 'I') {
                            if (charAt == 'J') {
                                return 1;
                            }
                            if (charAt != 'Z') {
                                if (charAt != '[') {
                                    switch (charAt) {
                                        case 'B':
                                            return 8;
                                        case 'C':
                                            return 5;
                                        case 'D':
                                            return 2;
                                        default:
                                            throw new ExceptionWithContext("Invalid field type: %s", fieldReference.getType());
                                    }
                                }
                            } else {
                                return 7;
                            }
                        } else {
                            return 3;
                        }
                    } else {
                        return 6;
                    }
                }
                return 0;
            }
            return 4;
        }

        @Nonnull
        private ArrayList<Field> getSortedInstanceFields(@Nonnull ClassDef classDef) {
            ArrayList<Field> i3 = Lists.i(classDef.getInstanceFields());
            Collections.sort(i3, new Comparator<Field>() { // from class: org.jf.dexlib2.analysis.ClassProto.5.1
                @Override // java.util.Comparator
                public int compare(Field field, Field field2) {
                    int a16 = c.a(getFieldSortOrder(field), getFieldSortOrder(field2));
                    if (a16 != 0) {
                        return a16;
                    }
                    int compareTo = field.getName().compareTo(field2.getName());
                    return compareTo != 0 ? compareTo : field.getType().compareTo(field2.getType());
                }
            });
            return i3;
        }

        @Override // com.google.common.base.o
        public SparseArray<FieldReference> get() {
            PriorityQueue<FieldGap> priorityQueue = new PriorityQueue<>();
            SparseArray<FieldReference> sparseArray = new SparseArray<>();
            ArrayList<Field> sortedInstanceFields = getSortedInstanceFields(ClassProto.this.getClassDef());
            String superclass = ClassProto.this.getSuperclass();
            int i3 = 0;
            if (superclass != null) {
                SparseArray<FieldReference> instanceFields = ((ClassProto) ClassProto.this.classPath.getClass(superclass)).getInstanceFields();
                FieldReference fieldReference = null;
                int i16 = 0;
                for (int i17 = 0; i17 < instanceFields.size(); i17++) {
                    i16 = instanceFields.keyAt(i17);
                    fieldReference = instanceFields.valueAt(i17);
                    sparseArray.put(i16, fieldReference);
                }
                if (fieldReference != null) {
                    i3 = i16 + getFieldSize(fieldReference);
                }
            }
            Iterator<Field> it = sortedInstanceFields.iterator();
            while (it.hasNext()) {
                Field next = it.next();
                int fieldSize = getFieldSize(next);
                if (!AlignmentUtils.isAligned(i3, fieldSize)) {
                    int alignOffset = AlignmentUtils.alignOffset(i3, fieldSize);
                    addFieldGap(i3, alignOffset, priorityQueue);
                    i3 = alignOffset;
                }
                FieldGap peek = priorityQueue.peek();
                if (peek != null && peek.size >= fieldSize) {
                    priorityQueue.poll();
                    sparseArray.put(peek.offset, next);
                    int i18 = peek.size;
                    if (i18 > fieldSize) {
                        int i19 = peek.offset;
                        addFieldGap(fieldSize + i19, i19 + i18, priorityQueue);
                    }
                } else {
                    sparseArray.append(i3, next);
                    i3 += fieldSize;
                }
            }
            return sparseArray;
        }
    });

    @Nonnull
    private final o<List<Method>> preDefaultMethodVtableSupplier = Suppliers.a(new o<List<Method>>() { // from class: org.jf.dexlib2.analysis.ClassProto.6
        @Override // com.google.common.base.o
        public List<Method> get() {
            ArrayList h16 = Lists.h();
            try {
                String superclass = ClassProto.this.getSuperclass();
                if (superclass != null) {
                    ClassProto classProto = (ClassProto) ClassProto.this.classPath.getClass(superclass);
                    h16.addAll(classProto.getVtable());
                    if (!classProto.vtableFullyResolved) {
                        ClassProto.this.vtableFullyResolved = false;
                        return h16;
                    }
                }
                if (!ClassProto.this.isInterface()) {
                    ClassProto classProto2 = ClassProto.this;
                    classProto2.addToVtable(classProto2.getClassDef().getVirtualMethods(), h16, true, true);
                    for (ClassDef classDef : ClassProto.this.getDirectInterfaces()) {
                        ArrayList h17 = Lists.h();
                        Iterator<? extends Method> it = classDef.getVirtualMethods().iterator();
                        while (it.hasNext()) {
                            h17.add(new ReparentedMethod(it.next(), ClassProto.this.type));
                        }
                        ClassProto.this.addToVtable(h17, h16, false, true);
                    }
                }
                return h16;
            } catch (UnresolvedClassException unused) {
                h16.addAll(((ClassProto) ClassProto.this.classPath.getClass("Ljava/lang/Object;")).getVtable());
                ClassProto.this.vtableFullyResolved = false;
                return h16;
            }
        }
    });

    @Nonnull
    private final o<List<Method>> buggyPostDefaultMethodVtableSupplier = Suppliers.a(new o<List<Method>>() { // from class: org.jf.dexlib2.analysis.ClassProto.7
        @Override // com.google.common.base.o
        public List<Method> get() {
            ArrayList arrayList;
            ArrayList h16 = Lists.h();
            int i3 = 0;
            try {
                String superclass = ClassProto.this.getSuperclass();
                if (superclass != null) {
                    ClassProto classProto = (ClassProto) ClassProto.this.classPath.getClass(superclass);
                    h16.addAll(classProto.getVtable());
                    if (!classProto.vtableFullyResolved) {
                        ClassProto.this.vtableFullyResolved = false;
                        return h16;
                    }
                }
                if (!ClassProto.this.isInterface()) {
                    ClassProto classProto2 = ClassProto.this;
                    classProto2.addToVtable(classProto2.getClassDef().getVirtualMethods(), h16, true, true);
                    ArrayList i16 = Lists.i(ClassProto.this.getInterfaces().keySet());
                    ArrayList h17 = Lists.h();
                    ArrayList h18 = Lists.h();
                    ArrayList h19 = Lists.h();
                    final HashMap j3 = Maps.j();
                    int size = i16.size() - 1;
                    while (size >= 0) {
                        for (Method method : ClassProto.this.classPath.getClassDef((String) i16.get(size)).getVirtualMethods()) {
                            int findMethodIndexInVtableReverse = ClassProto.this.findMethodIndexInVtableReverse(h16, method);
                            Method method2 = findMethodIndexInVtableReverse >= 0 ? (Method) h16.get(findMethodIndexInVtableReverse) : null;
                            int i17 = i3;
                            while (i17 < h16.size()) {
                                Method method3 = (Method) h16.get(i17);
                                if (MethodUtil.methodSignaturesMatch(method3, method)) {
                                    if (ClassProto.this.classPath.shouldCheckPackagePrivateAccess()) {
                                        arrayList = i16;
                                        if (!AnalyzedMethodUtil.canAccess(ClassProto.this, method3, true, false, false)) {
                                        }
                                    } else {
                                        arrayList = i16;
                                    }
                                    if (ClassProto.this.interfaceMethodOverrides(method, method3)) {
                                        h16.set(i17, method);
                                    }
                                } else {
                                    arrayList = i16;
                                }
                                i17++;
                                i16 = arrayList;
                            }
                            ArrayList arrayList2 = i16;
                            if (findMethodIndexInVtableReverse < 0 || ClassProto.this.isOverridableByDefaultMethod((Method) h16.get(findMethodIndexInVtableReverse))) {
                                int findMethodIndexInVtable = ClassProto.this.findMethodIndexInVtable(h17, method);
                                if (findMethodIndexInVtable < 0) {
                                    if (ClassProto.this.findMethodIndexInVtable(h18, method) < 0) {
                                        int findMethodIndexInVtable2 = ClassProto.this.findMethodIndexInVtable(h19, method);
                                        if (findMethodIndexInVtable2 >= 0) {
                                            if (!AccessFlags.ABSTRACT.isSet(method.getAccessFlags()) && !((ClassProto) ClassProto.this.classPath.getClass(((Method) h19.get(findMethodIndexInVtable2)).getDefiningClass())).implementsInterface(method.getDefiningClass())) {
                                                j3.put(method, Integer.valueOf(((Integer) j3.get((Method) h19.remove(findMethodIndexInVtable2))).intValue()));
                                                h17.add(method);
                                            }
                                        } else if (AccessFlags.ABSTRACT.isSet(method.getAccessFlags())) {
                                            if (method2 == null) {
                                                h19.add(method);
                                                j3.put(method, Integer.valueOf(j3.size()));
                                            }
                                        } else if (method2 == null || ClassProto.this.interfaceMethodOverrides(method, method2)) {
                                            h17.add(method);
                                            j3.put(method, Integer.valueOf(j3.size()));
                                        }
                                    }
                                } else if (!AccessFlags.ABSTRACT.isSet(method.getAccessFlags()) && !((ClassProto) ClassProto.this.classPath.getClass(((Method) h17.get(findMethodIndexInVtable)).getDefiningClass())).implementsInterface(method.getDefiningClass())) {
                                    h18.add((Method) h17.remove(findMethodIndexInVtable));
                                }
                            }
                            i16 = arrayList2;
                            i3 = 0;
                        }
                        size--;
                        i3 = 0;
                    }
                    Comparator<MethodReference> comparator = new Comparator<MethodReference>() { // from class: org.jf.dexlib2.analysis.ClassProto.7.1
                        @Override // java.util.Comparator
                        public int compare(MethodReference methodReference, MethodReference methodReference2) {
                            return c.a(((Integer) j3.get(methodReference)).intValue(), ((Integer) j3.get(methodReference2)).intValue());
                        }
                    };
                    Collections.sort(h19, comparator);
                    Collections.sort(h17, comparator);
                    Collections.sort(h18, comparator);
                    h16.addAll(h19);
                    h16.addAll(h17);
                    h16.addAll(h18);
                }
                return h16;
            } catch (UnresolvedClassException unused) {
                h16.addAll(((ClassProto) ClassProto.this.classPath.getClass("Ljava/lang/Object;")).getVtable());
                ClassProto.this.vtableFullyResolved = false;
                return h16;
            }
        }
    });

    @Nonnull
    private final o<List<Method>> postDefaultMethodVtableSupplier = Suppliers.a(new o<List<Method>>() { // from class: org.jf.dexlib2.analysis.ClassProto.8
        @Override // com.google.common.base.o
        public List<Method> get() {
            ArrayList h16 = Lists.h();
            try {
                String superclass = ClassProto.this.getSuperclass();
                if (superclass != null) {
                    ClassProto classProto = (ClassProto) ClassProto.this.classPath.getClass(superclass);
                    h16.addAll(classProto.getVtable());
                    if (!classProto.vtableFullyResolved) {
                        ClassProto.this.vtableFullyResolved = false;
                        return h16;
                    }
                }
                if (!ClassProto.this.isInterface()) {
                    ClassProto classProto2 = ClassProto.this;
                    classProto2.addToVtable(classProto2.getClassDef().getVirtualMethods(), h16, true, true);
                    List m3 = Lists.m(Lists.i(ClassProto.this.getDirectInterfaces()));
                    ArrayList h17 = Lists.h();
                    ArrayList h18 = Lists.h();
                    ArrayList h19 = Lists.h();
                    final HashMap j3 = Maps.j();
                    Iterator it = m3.iterator();
                    while (it.hasNext()) {
                        for (Method method : ((ClassDef) it.next()).getVirtualMethods()) {
                            int findMethodIndexInVtable = ClassProto.this.findMethodIndexInVtable(h16, method);
                            if (findMethodIndexInVtable >= 0) {
                                if (ClassProto.this.interfaceMethodOverrides(method, (Method) h16.get(findMethodIndexInVtable))) {
                                    h16.set(findMethodIndexInVtable, method);
                                }
                            } else {
                                int findMethodIndexInVtable2 = ClassProto.this.findMethodIndexInVtable(h17, method);
                                if (findMethodIndexInVtable2 < 0) {
                                    if (ClassProto.this.findMethodIndexInVtable(h18, method) < 0) {
                                        int findMethodIndexInVtable3 = ClassProto.this.findMethodIndexInVtable(h19, method);
                                        if (findMethodIndexInVtable3 >= 0) {
                                            if (!AccessFlags.ABSTRACT.isSet(method.getAccessFlags()) && !((ClassProto) ClassProto.this.classPath.getClass(((Method) h19.get(findMethodIndexInVtable3)).getDefiningClass())).implementsInterface(method.getDefiningClass())) {
                                                j3.put(method, Integer.valueOf(((Integer) j3.get((Method) h19.remove(findMethodIndexInVtable3))).intValue()));
                                                h17.add(method);
                                            }
                                        } else if (!AccessFlags.ABSTRACT.isSet(method.getAccessFlags())) {
                                            h17.add(method);
                                            j3.put(method, Integer.valueOf(j3.size()));
                                        } else {
                                            h19.add(method);
                                            j3.put(method, Integer.valueOf(j3.size()));
                                        }
                                    }
                                } else if (!AccessFlags.ABSTRACT.isSet(method.getAccessFlags()) && !((ClassProto) ClassProto.this.classPath.getClass(((Method) h17.get(findMethodIndexInVtable2)).getDefiningClass())).implementsInterface(method.getDefiningClass())) {
                                    h18.add((Method) h17.remove(findMethodIndexInVtable2));
                                }
                            }
                        }
                    }
                    Comparator<MethodReference> comparator = new Comparator<MethodReference>() { // from class: org.jf.dexlib2.analysis.ClassProto.8.1
                        @Override // java.util.Comparator
                        public int compare(MethodReference methodReference, MethodReference methodReference2) {
                            return c.a(((Integer) j3.get(methodReference)).intValue(), ((Integer) j3.get(methodReference2)).intValue());
                        }
                    };
                    Collections.sort(h17, comparator);
                    Collections.sort(h18, comparator);
                    Collections.sort(h19, comparator);
                    ClassProto.this.addToVtable(h17, h16, false, false);
                    ClassProto.this.addToVtable(h18, h16, false, false);
                    ClassProto.this.addToVtable(h19, h16, false, false);
                }
                return h16;
            } catch (UnresolvedClassException unused) {
                h16.addAll(((ClassProto) ClassProto.this.classPath.getClass("Ljava/lang/Object;")).getVtable());
                ClassProto.this.vtableFullyResolved = false;
                return h16;
            }
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes29.dex */
    public static abstract class FieldGap implements Comparable<FieldGap> {
        public final int offset;
        public final int size;

        public static FieldGap newFieldGap(int i3, int i16, int i17) {
            if (i17 >= 67) {
                return new FieldGap(i3, i16) { // from class: org.jf.dexlib2.analysis.ClassProto.FieldGap.1
                    @Override // java.lang.Comparable
                    public int compareTo(@Nonnull FieldGap fieldGap) {
                        int a16 = c.a(fieldGap.size, this.size);
                        return a16 != 0 ? a16 : c.a(this.offset, fieldGap.offset);
                    }
                };
            }
            return new FieldGap(i3, i16) { // from class: org.jf.dexlib2.analysis.ClassProto.FieldGap.2
                @Override // java.lang.Comparable
                public int compareTo(@Nonnull FieldGap fieldGap) {
                    int a16 = c.a(this.size, fieldGap.size);
                    return a16 != 0 ? a16 : c.a(fieldGap.offset, this.offset);
                }
            };
        }

        FieldGap(int i3, int i16) {
            this.offset = i3;
            this.size = i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes29.dex */
    public static class ReparentedMethod extends BaseMethodReference implements Method {
        private final String definingClass;
        private final Method method;

        public ReparentedMethod(Method method, String str) {
            this.method = method;
            this.definingClass = str;
        }

        @Override // org.jf.dexlib2.iface.Method, org.jf.dexlib2.iface.Member
        public int getAccessFlags() {
            return this.method.getAccessFlags();
        }

        @Override // org.jf.dexlib2.iface.Method, org.jf.dexlib2.iface.Annotatable
        @Nonnull
        public Set<? extends Annotation> getAnnotations() {
            return this.method.getAnnotations();
        }

        @Override // org.jf.dexlib2.iface.reference.MethodReference, org.jf.dexlib2.iface.Method, org.jf.dexlib2.iface.Member
        @Nonnull
        public String getDefiningClass() {
            return this.definingClass;
        }

        @Override // org.jf.dexlib2.iface.Method, org.jf.dexlib2.iface.Member
        @Nonnull
        public Set<HiddenApiRestriction> getHiddenApiRestrictions() {
            return this.method.getHiddenApiRestrictions();
        }

        @Override // org.jf.dexlib2.iface.Method
        @Nullable
        public MethodImplementation getImplementation() {
            return this.method.getImplementation();
        }

        @Override // org.jf.dexlib2.iface.reference.MethodReference, org.jf.dexlib2.iface.Method, org.jf.dexlib2.iface.Member
        @Nonnull
        public String getName() {
            return this.method.getName();
        }

        @Override // org.jf.dexlib2.iface.reference.MethodReference
        @Nonnull
        public List<? extends CharSequence> getParameterTypes() {
            return this.method.getParameterTypes();
        }

        @Override // org.jf.dexlib2.iface.Method
        @Nonnull
        public List<? extends MethodParameter> getParameters() {
            return this.method.getParameters();
        }

        @Override // org.jf.dexlib2.iface.reference.MethodReference, org.jf.dexlib2.iface.Method
        @Nonnull
        public String getReturnType() {
            return this.method.getReturnType();
        }
    }

    public ClassProto(@Nonnull ClassPath classPath, @Nonnull String str) {
        if (str.charAt(0) == 'L') {
            this.classPath = classPath;
            this.type = str;
            return;
        }
        throw new ExceptionWithContext("Cannot construct ClassProto for non reference type: %s", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r2 = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addToVtable(@Nonnull Iterable<? extends Method> iterable, @Nonnull List<Method> list, boolean z16, boolean z17) {
        Iterable<? extends Method> iterable2;
        if (z17) {
            ArrayList i3 = Lists.i(iterable);
            Collections.sort(i3);
            iterable2 = i3;
        }
        for (Method method : iterable2) {
            int findMethodIndexInVtable = findMethodIndexInVtable(list, method);
            if (findMethodIndexInVtable >= 0) {
                if (z16) {
                    list.set(findMethodIndexInVtable, method);
                }
            } else {
                list.add(method);
            }
        }
    }

    private boolean checkInterface(@Nonnull ClassProto classProto) {
        boolean z16;
        boolean z17;
        try {
            z17 = isInterface();
            z16 = true;
        } catch (UnresolvedClassException unused) {
            z16 = false;
            z17 = true;
        }
        if (z17) {
            try {
                if (classProto.implementsInterface(getType())) {
                    return true;
                }
            } catch (UnresolvedClassException e16) {
                if (z16) {
                    throw e16;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int findMethodIndexInVtableReverse(@Nonnull List<Method> list, MethodReference methodReference) {
        for (int size = list.size() - 1; size >= 0; size--) {
            Method method = list.get(size);
            if (MethodUtil.methodSignaturesMatch(method, methodReference) && (!this.classPath.shouldCheckPackagePrivateAccess() || AnalyzedMethodUtil.canAccess(this, method, true, false, false))) {
                return size;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte getFieldType(@Nonnull FieldReference fieldReference) {
        char charAt = fieldReference.getType().charAt(0);
        if (charAt != 'D' && charAt != 'J') {
            if (charAt == 'L' || charAt == '[') {
                return (byte) 0;
            }
            return (byte) 2;
        }
        return (byte) 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNextFieldOffset() {
        SparseArray<FieldReference> instanceFields = getInstanceFields();
        if (instanceFields.size() == 0) {
            if (!this.classPath.isArt()) {
                return 8;
            }
            return 0;
        }
        int size = instanceFields.size() - 1;
        int keyAt = instanceFields.keyAt(size);
        FieldReference valueAt = instanceFields.valueAt(size);
        if (this.classPath.isArt()) {
            return keyAt + getTypeSize(valueAt.getType().charAt(0));
        }
        char charAt = valueAt.getType().charAt(0);
        if (charAt != 'D' && charAt != 'J') {
            return keyAt + 4;
        }
        return keyAt + 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getTypeSize(char c16) {
        if (c16 != 'F' && c16 != 'L') {
            if (c16 != 'S') {
                if (c16 != 'I') {
                    if (c16 != 'J') {
                        if (c16 != 'Z') {
                            if (c16 != '[') {
                                switch (c16) {
                                    case 'B':
                                        break;
                                    case 'C':
                                        return 2;
                                    case 'D':
                                        return 8;
                                    default:
                                        throw new ExceptionWithContext("Invalid type: %s", Character.valueOf(c16));
                                }
                            } else {
                                return 4;
                            }
                        }
                        return 1;
                    }
                    return 8;
                }
                return 4;
            }
            return 2;
        }
        return 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean interfaceMethodOverrides(@Nonnull Method method, @Nonnull Method method2) {
        if (((ClassProto) this.classPath.getClass(method2.getDefiningClass())).isInterface()) {
            return ((ClassProto) this.classPath.getClass(method.getDefiningClass())).implementsInterface(method2.getDefiningClass());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isOverridableByDefaultMethod(@Nonnull Method method) {
        return ((ClassProto) this.classPath.getClass(method.getDefiningClass())).isInterface();
    }

    @Override // org.jf.dexlib2.analysis.TypeProto
    public int findMethodIndexInVtable(@Nonnull MethodReference methodReference) {
        return findMethodIndexInVtable(getVtable(), methodReference);
    }

    @Nonnull
    public ClassDef getClassDef() {
        return this.classDefSupplier.get();
    }

    @Override // org.jf.dexlib2.analysis.TypeProto
    @Nonnull
    public ClassPath getClassPath() {
        return this.classPath;
    }

    @Override // org.jf.dexlib2.analysis.TypeProto
    @Nonnull
    public TypeProto getCommonSuperclass(@Nonnull TypeProto typeProto) {
        boolean z16;
        if (!(typeProto instanceof ClassProto)) {
            return typeProto.getCommonSuperclass(this);
        }
        if (this != typeProto && !getType().equals(typeProto.getType())) {
            if (getType().equals("Ljava/lang/Object;")) {
                return this;
            }
            if (typeProto.getType().equals("Ljava/lang/Object;")) {
                return typeProto;
            }
            try {
            } catch (UnresolvedClassException unused) {
                z16 = true;
            }
            if (checkInterface((ClassProto) typeProto)) {
                return this;
            }
            z16 = false;
            try {
                if (((ClassProto) typeProto).checkInterface(this)) {
                    return typeProto;
                }
            } catch (UnresolvedClassException unused2) {
                z16 = true;
            }
            if (z16) {
                return this.classPath.getUnknownClass();
            }
            ArrayList k3 = Lists.k(this);
            q.a(k3, TypeProtoUtils.getSuperclassChain(this));
            ArrayList k16 = Lists.k(typeProto);
            q.a(k16, TypeProtoUtils.getSuperclassChain(typeProto));
            List m3 = Lists.m(k3);
            List m16 = Lists.m(k16);
            for (int min = Math.min(m3.size(), m16.size()) - 1; min >= 0; min--) {
                TypeProto typeProto2 = (TypeProto) m3.get(min);
                if (typeProto2.getType().equals(((TypeProto) m16.get(min)).getType())) {
                    return typeProto2;
                }
            }
            return this.classPath.getUnknownClass();
        }
        return this;
    }

    @Nonnull
    protected Iterable<ClassDef> getDirectInterfaces() {
        l h16 = l.i(getInterfaces().values()).h(Predicates.a());
        if (this.interfacesFullyResolved) {
            return h16;
        }
        throw new UnresolvedClassException("Interfaces for class %s not fully resolved: %s", getType(), e.g(',').d(getUnresolvedInterfaces()));
    }

    @Override // org.jf.dexlib2.analysis.TypeProto
    @Nullable
    public FieldReference getFieldByOffset(int i3) {
        if (getInstanceFields().size() == 0) {
            return null;
        }
        return getInstanceFields().get(i3);
    }

    @Nonnull
    public SparseArray<FieldReference> getInstanceFields() {
        if (this.classPath.isArt()) {
            return this.artInstanceFieldsSupplier.get();
        }
        return this.dalvikInstanceFieldsSupplier.get();
    }

    @Nonnull
    protected LinkedHashMap<String, ClassDef> getInterfaces() {
        if (this.classPath.isArt() && this.classPath.oatVersion >= 72) {
            return this.postDefaultMethodInterfaceSupplier.get();
        }
        return this.preDefaultMethodInterfaceSupplier.get();
    }

    @Override // org.jf.dexlib2.analysis.TypeProto
    @Nullable
    public Method getMethodByVtableIndex(int i3) {
        List<Method> vtable = getVtable();
        if (i3 >= 0 && i3 < vtable.size()) {
            return vtable.get(i3);
        }
        return null;
    }

    @Override // org.jf.dexlib2.analysis.TypeProto
    @Nullable
    public String getSuperclass() {
        return getClassDef().getSuperclass();
    }

    @Override // org.jf.dexlib2.analysis.TypeProto
    @Nonnull
    public String getType() {
        return this.type;
    }

    @Nonnull
    protected Set<String> getUnresolvedInterfaces() {
        Set<String> set = this.unresolvedInterfaces;
        if (set == null) {
            return ImmutableSet.of();
        }
        return set;
    }

    @Nonnull
    public List<Method> getVtable() {
        int i3;
        if (this.classPath.isArt() && (i3 = this.classPath.oatVersion) >= 72) {
            if (i3 < 87) {
                return this.buggyPostDefaultMethodVtableSupplier.get();
            }
            return this.postDefaultMethodVtableSupplier.get();
        }
        return this.preDefaultMethodVtableSupplier.get();
    }

    @Override // org.jf.dexlib2.analysis.TypeProto
    public boolean implementsInterface(@Nonnull String str) {
        if (getInterfaces().containsKey(str)) {
            return true;
        }
        if (this.interfacesFullyResolved) {
            return false;
        }
        throw new UnresolvedClassException("Interfaces for class %s not fully resolved", getType());
    }

    @Override // org.jf.dexlib2.analysis.TypeProto
    public boolean isInterface() {
        if ((getClassDef().getAccessFlags() & AccessFlags.INTERFACE.getValue()) != 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.type;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int findMethodIndexInVtable(@Nonnull List<Method> list, MethodReference methodReference) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            Method method = list.get(i3);
            if (MethodUtil.methodSignaturesMatch(method, methodReference) && (!this.classPath.shouldCheckPackagePrivateAccess() || AnalyzedMethodUtil.canAccess(this, method, true, false, false))) {
                return i3;
            }
        }
        return -1;
    }
}
