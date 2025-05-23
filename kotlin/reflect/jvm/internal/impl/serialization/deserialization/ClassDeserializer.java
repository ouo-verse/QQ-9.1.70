package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Iterator;
import java.util.Set;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class ClassDeserializer {

    @NotNull
    private static final Set<ClassId> BLACK_LIST;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final Function1<ClassKey, ClassDescriptor> classes;

    @NotNull
    private final DeserializationComponents components;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class ClassKey {

        @Nullable
        private final ClassData classData;

        @NotNull
        private final ClassId classId;

        public ClassKey(@NotNull ClassId classId, @Nullable ClassData classData) {
            Intrinsics.checkNotNullParameter(classId, "classId");
            this.classId = classId;
            this.classData = classData;
        }

        public boolean equals(@Nullable Object obj) {
            if ((obj instanceof ClassKey) && Intrinsics.areEqual(this.classId, ((ClassKey) obj).classId)) {
                return true;
            }
            return false;
        }

        @Nullable
        public final ClassData getClassData() {
            return this.classData;
        }

        @NotNull
        public final ClassId getClassId() {
            return this.classId;
        }

        public int hashCode() {
            return this.classId.hashCode();
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Set<ClassId> getBLACK_LIST() {
            return ClassDeserializer.BLACK_LIST;
        }

        Companion() {
        }
    }

    static {
        Set<ClassId> of5;
        of5 = SetsKt__SetsJVMKt.setOf(ClassId.topLevel(StandardNames.FqNames.cloneable.toSafe()));
        BLACK_LIST = of5;
    }

    public ClassDeserializer(@NotNull DeserializationComponents components) {
        Intrinsics.checkNotNullParameter(components, "components");
        this.components = components;
        this.classes = components.getStorageManager().createMemoizedFunctionWithNullableValues(new Function1<ClassKey, ClassDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer$classes$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final ClassDescriptor invoke(@NotNull ClassDeserializer.ClassKey key) {
                ClassDescriptor createClass;
                Intrinsics.checkNotNullParameter(key, "key");
                createClass = ClassDeserializer.this.createClass(key);
                return createClass;
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00bd A[EDGE_INSN: B:43:0x00bd->B:44:0x00bd BREAK  A[LOOP:1: B:34:0x0095->B:48:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[LOOP:1: B:34:0x0095->B:48:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ClassDescriptor createClass(ClassKey classKey) {
        Object obj;
        DeserializationContext createContext;
        boolean z16;
        DeserializedClassDescriptor deserializedClassDescriptor;
        ClassId classId = classKey.getClassId();
        Iterator<ClassDescriptorFactory> it = this.components.getFictitiousClassDescriptorFactories().iterator();
        while (it.hasNext()) {
            ClassDescriptor createClass = it.next().createClass(classId);
            if (createClass != null) {
                return createClass;
            }
        }
        if (BLACK_LIST.contains(classId)) {
            return null;
        }
        ClassData classData = classKey.getClassData();
        if (classData == null && (classData = this.components.getClassDataFinder().findClassData(classId)) == null) {
            return null;
        }
        NameResolver component1 = classData.component1();
        ProtoBuf.Class component2 = classData.component2();
        BinaryVersion component3 = classData.component3();
        SourceElement component4 = classData.component4();
        ClassId outerClassId = classId.getOuterClassId();
        if (outerClassId != null) {
            ClassDescriptor deserializeClass$default = deserializeClass$default(this, outerClassId, null, 2, null);
            if (deserializeClass$default instanceof DeserializedClassDescriptor) {
                deserializedClassDescriptor = (DeserializedClassDescriptor) deserializeClass$default;
            } else {
                deserializedClassDescriptor = null;
            }
            if (deserializedClassDescriptor == null) {
                return null;
            }
            Name shortClassName = classId.getShortClassName();
            Intrinsics.checkNotNullExpressionValue(shortClassName, "classId.shortClassName");
            if (!deserializedClassDescriptor.hasNestedClass$deserialization(shortClassName)) {
                return null;
            }
            createContext = deserializedClassDescriptor.getC();
        } else {
            PackageFragmentProvider packageFragmentProvider = this.components.getPackageFragmentProvider();
            FqName packageFqName = classId.getPackageFqName();
            Intrinsics.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
            Iterator<T> it5 = PackageFragmentProviderKt.packageFragments(packageFragmentProvider, packageFqName).iterator();
            while (true) {
                if (it5.hasNext()) {
                    obj = it5.next();
                    PackageFragmentDescriptor packageFragmentDescriptor = (PackageFragmentDescriptor) obj;
                    if (packageFragmentDescriptor instanceof DeserializedPackageFragment) {
                        Name shortClassName2 = classId.getShortClassName();
                        Intrinsics.checkNotNullExpressionValue(shortClassName2, "classId.shortClassName");
                        if (!((DeserializedPackageFragment) packageFragmentDescriptor).hasTopLevelClass(shortClassName2)) {
                            z16 = false;
                            if (!z16) {
                                break;
                            }
                        }
                    }
                    z16 = true;
                    if (!z16) {
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            PackageFragmentDescriptor packageFragmentDescriptor2 = (PackageFragmentDescriptor) obj;
            if (packageFragmentDescriptor2 == null) {
                return null;
            }
            DeserializationComponents deserializationComponents = this.components;
            ProtoBuf.TypeTable typeTable = component2.getTypeTable();
            Intrinsics.checkNotNullExpressionValue(typeTable, "classProto.typeTable");
            TypeTable typeTable2 = new TypeTable(typeTable);
            VersionRequirementTable.Companion companion = VersionRequirementTable.Companion;
            ProtoBuf.VersionRequirementTable versionRequirementTable = component2.getVersionRequirementTable();
            Intrinsics.checkNotNullExpressionValue(versionRequirementTable, "classProto.versionRequirementTable");
            createContext = deserializationComponents.createContext(packageFragmentDescriptor2, component1, typeTable2, companion.create(versionRequirementTable), component3, null);
        }
        return new DeserializedClassDescriptor(createContext, component2, component1, component3, component4);
    }

    public static /* synthetic */ ClassDescriptor deserializeClass$default(ClassDeserializer classDeserializer, ClassId classId, ClassData classData, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            classData = null;
        }
        return classDeserializer.deserializeClass(classId, classData);
    }

    @Nullable
    public final ClassDescriptor deserializeClass(@NotNull ClassId classId, @Nullable ClassData classData) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        return this.classes.invoke(new ClassKey(classId, classData));
    }
}
