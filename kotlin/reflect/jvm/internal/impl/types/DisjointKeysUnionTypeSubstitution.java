package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class DisjointKeysUnionTypeSubstitution extends TypeSubstitution {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final TypeSubstitution first;

    @NotNull
    private final TypeSubstitution second;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final TypeSubstitution create(@NotNull TypeSubstitution first, @NotNull TypeSubstitution second) {
            Intrinsics.checkNotNullParameter(first, "first");
            Intrinsics.checkNotNullParameter(second, "second");
            if (first.isEmpty()) {
                return second;
            }
            if (second.isEmpty()) {
                return first;
            }
            return new DisjointKeysUnionTypeSubstitution(first, second, null);
        }

        Companion() {
        }
    }

    public /* synthetic */ DisjointKeysUnionTypeSubstitution(TypeSubstitution typeSubstitution, TypeSubstitution typeSubstitution2, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeSubstitution, typeSubstitution2);
    }

    @JvmStatic
    @NotNull
    public static final TypeSubstitution create(@NotNull TypeSubstitution typeSubstitution, @NotNull TypeSubstitution typeSubstitution2) {
        return Companion.create(typeSubstitution, typeSubstitution2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean approximateCapturedTypes() {
        if (!this.first.approximateCapturedTypes() && !this.second.approximateCapturedTypes()) {
            return false;
        }
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean approximateContravariantCapturedTypes() {
        if (!this.first.approximateContravariantCapturedTypes() && !this.second.approximateContravariantCapturedTypes()) {
            return false;
        }
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    @NotNull
    public Annotations filterAnnotations(@NotNull Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        return this.second.filterAnnotations(this.first.filterAnnotations(annotations));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    @Nullable
    /* renamed from: get */
    public TypeProjection mo1784get(@NotNull KotlinType key) {
        Intrinsics.checkNotNullParameter(key, "key");
        TypeProjection mo1784get = this.first.mo1784get(key);
        if (mo1784get == null) {
            return this.second.mo1784get(key);
        }
        return mo1784get;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean isEmpty() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    @NotNull
    public KotlinType prepareTopLevelType(@NotNull KotlinType topLevelType, @NotNull Variance position) {
        Intrinsics.checkNotNullParameter(topLevelType, "topLevelType");
        Intrinsics.checkNotNullParameter(position, "position");
        return this.second.prepareTopLevelType(this.first.prepareTopLevelType(topLevelType, position), position);
    }

    DisjointKeysUnionTypeSubstitution(TypeSubstitution typeSubstitution, TypeSubstitution typeSubstitution2) {
        this.first = typeSubstitution;
        this.second = typeSubstitution2;
    }
}
