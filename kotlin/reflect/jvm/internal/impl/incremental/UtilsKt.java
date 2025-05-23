package kotlin.reflect.jvm.internal.impl.incremental;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LocationInfo;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.incremental.components.Position;
import kotlin.reflect.jvm.internal.impl.incremental.components.ScopeKind;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class UtilsKt {
    public static final void record(@NotNull LookupTracker lookupTracker, @NotNull LookupLocation from, @NotNull ClassDescriptor scopeOwner, @NotNull Name name) {
        LocationInfo location;
        Intrinsics.checkNotNullParameter(lookupTracker, "<this>");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(scopeOwner, "scopeOwner");
        Intrinsics.checkNotNullParameter(name, "name");
        if (lookupTracker == LookupTracker.DO_NOTHING.INSTANCE || (location = from.getLocation()) == null) {
            return;
        }
        Position position = lookupTracker.getRequiresPosition() ? location.getPosition() : Position.Companion.getNO_POSITION();
        String filePath = location.getFilePath();
        String asString = DescriptorUtils.getFqName(scopeOwner).asString();
        Intrinsics.checkNotNullExpressionValue(asString, "getFqName(scopeOwner).asString()");
        ScopeKind scopeKind = ScopeKind.CLASSIFIER;
        String asString2 = name.asString();
        Intrinsics.checkNotNullExpressionValue(asString2, "name.asString()");
        lookupTracker.record(filePath, position, asString, scopeKind, asString2);
    }

    public static final void recordPackageLookup(@NotNull LookupTracker lookupTracker, @NotNull LookupLocation from, @NotNull String packageFqName, @NotNull String name) {
        LocationInfo location;
        Position no_position;
        Intrinsics.checkNotNullParameter(lookupTracker, "<this>");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        Intrinsics.checkNotNullParameter(name, "name");
        if (lookupTracker == LookupTracker.DO_NOTHING.INSTANCE || (location = from.getLocation()) == null) {
            return;
        }
        if (lookupTracker.getRequiresPosition()) {
            no_position = location.getPosition();
        } else {
            no_position = Position.Companion.getNO_POSITION();
        }
        lookupTracker.record(location.getFilePath(), no_position, packageFqName, ScopeKind.PACKAGE, name);
    }

    public static final void record(@NotNull LookupTracker lookupTracker, @NotNull LookupLocation from, @NotNull PackageFragmentDescriptor scopeOwner, @NotNull Name name) {
        Intrinsics.checkNotNullParameter(lookupTracker, "<this>");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(scopeOwner, "scopeOwner");
        Intrinsics.checkNotNullParameter(name, "name");
        String asString = scopeOwner.getFqName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "scopeOwner.fqName.asString()");
        String asString2 = name.asString();
        Intrinsics.checkNotNullExpressionValue(asString2, "name.asString()");
        recordPackageLookup(lookupTracker, from, asString, asString2);
    }
}
