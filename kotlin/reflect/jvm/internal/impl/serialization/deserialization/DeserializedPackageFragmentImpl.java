package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolverImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPackageMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes28.dex */
public abstract class DeserializedPackageFragmentImpl extends DeserializedPackageFragment {
    private MemberScope _memberScope;

    @Nullable
    private ProtoBuf.PackageFragment _proto;

    @NotNull
    private final ProtoBasedClassDataFinder classDataFinder;

    @Nullable
    private final DeserializedContainerSource containerSource;

    @NotNull
    private final BinaryVersion metadataVersion;

    @NotNull
    private final NameResolverImpl nameResolver;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedPackageFragmentImpl(@NotNull FqName fqName, @NotNull StorageManager storageManager, @NotNull ModuleDescriptor module, @NotNull ProtoBuf.PackageFragment proto, @NotNull BinaryVersion metadataVersion, @Nullable DeserializedContainerSource deserializedContainerSource) {
        super(fqName, storageManager, module);
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
        this.metadataVersion = metadataVersion;
        this.containerSource = deserializedContainerSource;
        ProtoBuf.StringTable strings = proto.getStrings();
        Intrinsics.checkNotNullExpressionValue(strings, "proto.strings");
        ProtoBuf.QualifiedNameTable qualifiedNames = proto.getQualifiedNames();
        Intrinsics.checkNotNullExpressionValue(qualifiedNames, "proto.qualifiedNames");
        NameResolverImpl nameResolverImpl = new NameResolverImpl(strings, qualifiedNames);
        this.nameResolver = nameResolverImpl;
        this.classDataFinder = new ProtoBasedClassDataFinder(proto, nameResolverImpl, metadataVersion, new Function1<ClassId, SourceElement>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragmentImpl$classDataFinder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final SourceElement invoke(@NotNull ClassId it) {
                DeserializedContainerSource deserializedContainerSource2;
                Intrinsics.checkNotNullParameter(it, "it");
                deserializedContainerSource2 = DeserializedPackageFragmentImpl.this.containerSource;
                if (deserializedContainerSource2 != null) {
                    return deserializedContainerSource2;
                }
                SourceElement NO_SOURCE = SourceElement.NO_SOURCE;
                Intrinsics.checkNotNullExpressionValue(NO_SOURCE, "NO_SOURCE");
                return NO_SOURCE;
            }
        });
        this._proto = proto;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
    @NotNull
    public MemberScope getMemberScope() {
        MemberScope memberScope = this._memberScope;
        if (memberScope == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_memberScope");
            return null;
        }
        return memberScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment
    public void initialize(@NotNull DeserializationComponents components) {
        Intrinsics.checkNotNullParameter(components, "components");
        ProtoBuf.PackageFragment packageFragment = this._proto;
        if (packageFragment != null) {
            this._proto = null;
            ProtoBuf.Package r46 = packageFragment.getPackage();
            Intrinsics.checkNotNullExpressionValue(r46, "proto.`package`");
            this._memberScope = new DeserializedPackageMemberScope(this, r46, this.nameResolver, this.metadataVersion, this.containerSource, components, "scope of " + this, new Function0<Collection<? extends Name>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragmentImpl$initialize$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Collection<? extends Name> invoke() {
                    int collectionSizeOrDefault;
                    Collection<ClassId> allClassIds = DeserializedPackageFragmentImpl.this.getClassDataFinder().getAllClassIds();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : allClassIds) {
                        ClassId classId = (ClassId) obj;
                        if ((classId.isNestedClass() || ClassDeserializer.Companion.getBLACK_LIST().contains(classId)) ? false : true) {
                            arrayList.add(obj);
                        }
                    }
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                    ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(((ClassId) it.next()).getShortClassName());
                    }
                    return arrayList2;
                }
            });
            return;
        }
        throw new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize".toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment
    @NotNull
    public ProtoBasedClassDataFinder getClassDataFinder() {
        return this.classDataFinder;
    }
}
