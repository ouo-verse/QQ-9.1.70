package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLoadingKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ClassDeclaredMemberIndex implements DeclaredMemberIndex {

    @NotNull
    private final Map<Name, JavaRecordComponent> components;

    @NotNull
    private final Map<Name, JavaField> fields;

    @NotNull
    private final JavaClass jClass;

    @NotNull
    private final Function1<JavaMember, Boolean> memberFilter;

    @NotNull
    private final Function1<JavaMethod, Boolean> methodFilter;

    @NotNull
    private final Map<Name, List<JavaMethod>> methods;

    /* JADX WARN: Multi-variable type inference failed */
    public ClassDeclaredMemberIndex(@NotNull JavaClass jClass, @NotNull Function1<? super JavaMember, Boolean> memberFilter) {
        Sequence asSequence;
        Sequence filter;
        Sequence asSequence2;
        Sequence filter2;
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        Intrinsics.checkNotNullParameter(memberFilter, "memberFilter");
        this.jClass = jClass;
        this.memberFilter = memberFilter;
        Function1<JavaMethod, Boolean> function1 = new Function1<JavaMethod, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.ClassDeclaredMemberIndex$methodFilter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull JavaMethod m3) {
                Function1 function12;
                Intrinsics.checkNotNullParameter(m3, "m");
                function12 = ClassDeclaredMemberIndex.this.memberFilter;
                return Boolean.valueOf(((Boolean) function12.invoke(m3)).booleanValue() && !JavaLoadingKt.isObjectMethodInInterface(m3));
            }
        };
        this.methodFilter = function1;
        asSequence = CollectionsKt___CollectionsKt.asSequence(jClass.getMethods());
        filter = SequencesKt___SequencesKt.filter(asSequence, function1);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : filter) {
            Name name = ((JavaMethod) obj).getName();
            Object obj2 = linkedHashMap.get(name);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(name, obj2);
            }
            ((List) obj2).add(obj);
        }
        this.methods = linkedHashMap;
        asSequence2 = CollectionsKt___CollectionsKt.asSequence(this.jClass.getFields());
        filter2 = SequencesKt___SequencesKt.filter(asSequence2, this.memberFilter);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Object obj3 : filter2) {
            linkedHashMap2.put(((JavaField) obj3).getName(), obj3);
        }
        this.fields = linkedHashMap2;
        Collection<JavaRecordComponent> recordComponents = this.jClass.getRecordComponents();
        Function1<JavaMember, Boolean> function12 = this.memberFilter;
        ArrayList arrayList = new ArrayList();
        for (Object obj4 : recordComponents) {
            if (((Boolean) function12.invoke(obj4)).booleanValue()) {
                arrayList.add(obj4);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(coerceAtLeast);
        for (Object obj5 : arrayList) {
            linkedHashMap3.put(((JavaRecordComponent) obj5).getName(), obj5);
        }
        this.components = linkedHashMap3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    @Nullable
    public JavaField findFieldByName(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.fields.get(name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    @NotNull
    public Collection<JavaMethod> findMethodsByName(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        List<JavaMethod> list = this.methods.get(name);
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    @Nullable
    public JavaRecordComponent findRecordComponentByName(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.components.get(name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    @NotNull
    public Set<Name> getFieldNames() {
        Sequence asSequence;
        Sequence filter;
        asSequence = CollectionsKt___CollectionsKt.asSequence(this.jClass.getFields());
        filter = SequencesKt___SequencesKt.filter(asSequence, this.memberFilter);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = filter.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(((JavaField) it.next()).getName());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    @NotNull
    public Set<Name> getMethodNames() {
        Sequence asSequence;
        Sequence filter;
        asSequence = CollectionsKt___CollectionsKt.asSequence(this.jClass.getMethods());
        filter = SequencesKt___SequencesKt.filter(asSequence, this.methodFilter);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = filter.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(((JavaMethod) it.next()).getName());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    @NotNull
    public Set<Name> getRecordComponentNames() {
        return this.components.keySet();
    }
}
