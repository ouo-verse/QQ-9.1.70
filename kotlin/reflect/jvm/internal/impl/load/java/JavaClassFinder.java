package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Arrays;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface JavaClassFinder {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ JavaPackage findPackage$default(JavaClassFinder javaClassFinder, FqName fqName, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = true;
                }
                return javaClassFinder.findPackage(fqName, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findPackage");
        }
    }

    @Nullable
    JavaClass findClass(@NotNull Request request);

    @Nullable
    JavaPackage findPackage(@NotNull FqName fqName, boolean z16);

    @Nullable
    Set<String> knownClassNamesInPackage(@NotNull FqName fqName);

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Request {

        @NotNull
        private final ClassId classId;

        @Nullable
        private final JavaClass outerClass;

        @Nullable
        private final byte[] previouslyFoundClassFileContent;

        public Request(@NotNull ClassId classId, @Nullable byte[] bArr, @Nullable JavaClass javaClass) {
            Intrinsics.checkNotNullParameter(classId, "classId");
            this.classId = classId;
            this.previouslyFoundClassFileContent = bArr;
            this.outerClass = javaClass;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Request)) {
                return false;
            }
            Request request = (Request) obj;
            if (Intrinsics.areEqual(this.classId, request.classId) && Intrinsics.areEqual(this.previouslyFoundClassFileContent, request.previouslyFoundClassFileContent) && Intrinsics.areEqual(this.outerClass, request.outerClass)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final ClassId getClassId() {
            return this.classId;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = this.classId.hashCode() * 31;
            byte[] bArr = this.previouslyFoundClassFileContent;
            int i3 = 0;
            if (bArr == null) {
                hashCode = 0;
            } else {
                hashCode = Arrays.hashCode(bArr);
            }
            int i16 = (hashCode2 + hashCode) * 31;
            JavaClass javaClass = this.outerClass;
            if (javaClass != null) {
                i3 = javaClass.hashCode();
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "Request(classId=" + this.classId + ", previouslyFoundClassFileContent=" + Arrays.toString(this.previouslyFoundClassFileContent) + ", outerClass=" + this.outerClass + ')';
        }

        public /* synthetic */ Request(ClassId classId, byte[] bArr, JavaClass javaClass, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(classId, (i3 & 2) != 0 ? null : bArr, (i3 & 4) != 0 ? null : javaClass);
        }
    }
}
