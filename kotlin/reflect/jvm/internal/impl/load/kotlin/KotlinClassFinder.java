package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.KotlinMetadataFinder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface KotlinClassFinder extends KotlinMetadataFinder {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static abstract class Result {

        /* compiled from: P */
        /* loaded from: classes28.dex */
        public static final class ClassFileContent extends Result {

            @NotNull
            private final byte[] content;

            @NotNull
            public final byte[] getContent() {
                return this.content;
            }
        }

        /* compiled from: P */
        /* loaded from: classes28.dex */
        public static final class KotlinClass extends Result {

            @Nullable
            private final byte[] byteContent;

            @NotNull
            private final KotlinJvmBinaryClass kotlinJvmBinaryClass;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public KotlinClass(@NotNull KotlinJvmBinaryClass kotlinJvmBinaryClass, @Nullable byte[] bArr) {
                super(null);
                Intrinsics.checkNotNullParameter(kotlinJvmBinaryClass, "kotlinJvmBinaryClass");
                this.kotlinJvmBinaryClass = kotlinJvmBinaryClass;
                this.byteContent = bArr;
            }

            @NotNull
            public final KotlinJvmBinaryClass getKotlinJvmBinaryClass() {
                return this.kotlinJvmBinaryClass;
            }

            public /* synthetic */ KotlinClass(KotlinJvmBinaryClass kotlinJvmBinaryClass, byte[] bArr, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this(kotlinJvmBinaryClass, (i3 & 2) != 0 ? null : bArr);
            }
        }

        public /* synthetic */ Result(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final KotlinJvmBinaryClass toKotlinJvmBinaryClass() {
            KotlinClass kotlinClass;
            if (this instanceof KotlinClass) {
                kotlinClass = (KotlinClass) this;
            } else {
                kotlinClass = null;
            }
            if (kotlinClass == null) {
                return null;
            }
            return kotlinClass.getKotlinJvmBinaryClass();
        }

        Result() {
        }
    }

    @Nullable
    Result findKotlinClassOrContent(@NotNull JavaClass javaClass);

    @Nullable
    Result findKotlinClassOrContent(@NotNull ClassId classId);
}
