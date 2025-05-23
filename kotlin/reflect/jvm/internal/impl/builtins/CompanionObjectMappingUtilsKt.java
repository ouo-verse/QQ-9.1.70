package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class CompanionObjectMappingUtilsKt {
    public static final boolean isMappedIntrinsicCompanionObject(@NotNull CompanionObjectMapping companionObjectMapping, @NotNull ClassDescriptor classDescriptor) {
        ClassId classId;
        boolean contains;
        Intrinsics.checkNotNullParameter(companionObjectMapping, "<this>");
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        if (DescriptorUtils.isCompanionObject(classDescriptor)) {
            Set<ClassId> classIds = companionObjectMapping.getClassIds();
            ClassId classId2 = DescriptorUtilsKt.getClassId(classDescriptor);
            if (classId2 != null) {
                classId = classId2.getOuterClassId();
            } else {
                classId = null;
            }
            contains = CollectionsKt___CollectionsKt.contains(classIds, classId);
            if (contains) {
                return true;
            }
        }
        return false;
    }
}
