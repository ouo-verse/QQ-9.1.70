package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes28.dex */
public final class BuiltinSpecialProperties {

    @NotNull
    private static final Map<Name, List<Name>> GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP;

    @NotNull
    public static final BuiltinSpecialProperties INSTANCE = new BuiltinSpecialProperties();

    @NotNull
    private static final Map<FqName, Name> PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP;

    @NotNull
    private static final Set<FqName> SPECIAL_FQ_NAMES;

    @NotNull
    private static final Set<Name> SPECIAL_SHORT_NAMES;

    static {
        FqName childSafe;
        FqName childSafe2;
        FqName child;
        FqName child2;
        FqName childSafe3;
        FqName child3;
        FqName child4;
        FqName child5;
        Map<FqName, Name> mapOf;
        int collectionSizeOrDefault;
        int mapCapacity;
        int collectionSizeOrDefault2;
        Set<Name> set;
        List distinct;
        FqNameUnsafe fqNameUnsafe = StandardNames.FqNames._enum;
        childSafe = BuiltinSpecialPropertiesKt.childSafe(fqNameUnsafe, "name");
        childSafe2 = BuiltinSpecialPropertiesKt.childSafe(fqNameUnsafe, "ordinal");
        child = BuiltinSpecialPropertiesKt.child(StandardNames.FqNames.collection, "size");
        FqName fqName = StandardNames.FqNames.map;
        child2 = BuiltinSpecialPropertiesKt.child(fqName, "size");
        childSafe3 = BuiltinSpecialPropertiesKt.childSafe(StandardNames.FqNames.charSequence, "length");
        child3 = BuiltinSpecialPropertiesKt.child(fqName, "keys");
        child4 = BuiltinSpecialPropertiesKt.child(fqName, "values");
        child5 = BuiltinSpecialPropertiesKt.child(fqName, "entries");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(childSafe, Name.identifier("name")), TuplesKt.to(childSafe2, Name.identifier("ordinal")), TuplesKt.to(child, Name.identifier("size")), TuplesKt.to(child2, Name.identifier("size")), TuplesKt.to(childSafe3, Name.identifier("length")), TuplesKt.to(child3, Name.identifier("keySet")), TuplesKt.to(child4, Name.identifier("values")), TuplesKt.to(child5, Name.identifier("entrySet")));
        PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP = mapOf;
        Set<Map.Entry<FqName, Name>> entrySet = mapOf.entrySet();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(entrySet, 10);
        ArrayList<Pair> arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            arrayList.add(new Pair(((FqName) entry.getKey()).shortName(), entry.getValue()));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Pair pair : arrayList) {
            Name name = (Name) pair.getSecond();
            Object obj = linkedHashMap.get(name);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(name, obj);
            }
            ((List) obj).add((Name) pair.getFirst());
        }
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(linkedHashMap.size());
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(mapCapacity);
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            Object key = entry2.getKey();
            distinct = CollectionsKt___CollectionsKt.distinct((Iterable) entry2.getValue());
            linkedHashMap2.put(key, distinct);
        }
        GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP = linkedHashMap2;
        Set<FqName> keySet = PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP.keySet();
        SPECIAL_FQ_NAMES = keySet;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(keySet, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it5 = keySet.iterator();
        while (it5.hasNext()) {
            arrayList2.add(((FqName) it5.next()).shortName());
        }
        set = CollectionsKt___CollectionsKt.toSet(arrayList2);
        SPECIAL_SHORT_NAMES = set;
    }

    BuiltinSpecialProperties() {
    }

    @NotNull
    public final Map<FqName, Name> getPROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP() {
        return PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP;
    }

    @NotNull
    public final List<Name> getPropertyNameCandidatesBySpecialGetterName(@NotNull Name name1) {
        List<Name> emptyList;
        Intrinsics.checkNotNullParameter(name1, "name1");
        List<Name> list = GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP.get(name1);
        if (list == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return list;
    }

    @NotNull
    public final Set<FqName> getSPECIAL_FQ_NAMES() {
        return SPECIAL_FQ_NAMES;
    }

    @NotNull
    public final Set<Name> getSPECIAL_SHORT_NAMES() {
        return SPECIAL_SHORT_NAMES;
    }
}
