package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes28.dex */
public abstract class DeserializedPackageFragment extends PackageFragmentDescriptorImpl {

    @NotNull
    private final StorageManager storageManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedPackageFragment(@NotNull FqName fqName, @NotNull StorageManager storageManager, @NotNull ModuleDescriptor module) {
        super(module, fqName);
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(module, "module");
        this.storageManager = storageManager;
    }

    @NotNull
    public abstract ClassDataFinder getClassDataFinder();

    public boolean hasTopLevelClass(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        MemberScope memberScope = getMemberScope();
        if ((memberScope instanceof DeserializedMemberScope) && ((DeserializedMemberScope) memberScope).getClassNames$deserialization().contains(name)) {
            return true;
        }
        return false;
    }

    public abstract void initialize(@NotNull DeserializationComponents deserializationComponents);
}
