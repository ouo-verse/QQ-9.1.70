package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface DeclaredMemberIndex {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Empty implements DeclaredMemberIndex {

        @NotNull
        public static final Empty INSTANCE = new Empty();

        Empty() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
        @Nullable
        public JavaField findFieldByName(@NotNull Name name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
        @Nullable
        public JavaRecordComponent findRecordComponentByName(@NotNull Name name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
        @NotNull
        public Set<Name> getFieldNames() {
            Set<Name> emptySet;
            emptySet = SetsKt__SetsKt.emptySet();
            return emptySet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
        @NotNull
        public Set<Name> getMethodNames() {
            Set<Name> emptySet;
            emptySet = SetsKt__SetsKt.emptySet();
            return emptySet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
        @NotNull
        public Set<Name> getRecordComponentNames() {
            Set<Name> emptySet;
            emptySet = SetsKt__SetsKt.emptySet();
            return emptySet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
        @NotNull
        public List<JavaMethod> findMethodsByName(@NotNull Name name) {
            List<JavaMethod> emptyList;
            Intrinsics.checkNotNullParameter(name, "name");
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
    }

    @Nullable
    JavaField findFieldByName(@NotNull Name name);

    @NotNull
    Collection<JavaMethod> findMethodsByName(@NotNull Name name);

    @Nullable
    JavaRecordComponent findRecordComponentByName(@NotNull Name name);

    @NotNull
    Set<Name> getFieldNames();

    @NotNull
    Set<Name> getMethodNames();

    @NotNull
    Set<Name> getRecordComponentNames();
}
