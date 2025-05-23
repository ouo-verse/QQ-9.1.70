package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class ReflectKotlinClass implements KotlinJvmBinaryClass {

    @NotNull
    public static final Factory Factory = new Factory(null);

    @NotNull
    private final KotlinClassHeader classHeader;

    @NotNull
    private final Class<?> klass;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Factory {
        public /* synthetic */ Factory(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final ReflectKotlinClass create(@NotNull Class<?> klass) {
            Intrinsics.checkNotNullParameter(klass, "klass");
            ReadKotlinClassHeaderAnnotationVisitor readKotlinClassHeaderAnnotationVisitor = new ReadKotlinClassHeaderAnnotationVisitor();
            ReflectClassStructure.INSTANCE.loadClassAnnotations(klass, readKotlinClassHeaderAnnotationVisitor);
            KotlinClassHeader createHeader = readKotlinClassHeaderAnnotationVisitor.createHeader();
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (createHeader == null) {
                return null;
            }
            return new ReflectKotlinClass(klass, createHeader, defaultConstructorMarker);
        }

        Factory() {
        }
    }

    public /* synthetic */ ReflectKotlinClass(Class cls, KotlinClassHeader kotlinClassHeader, DefaultConstructorMarker defaultConstructorMarker) {
        this(cls, kotlinClassHeader);
    }

    public boolean equals(@Nullable Object obj) {
        if ((obj instanceof ReflectKotlinClass) && Intrinsics.areEqual(this.klass, ((ReflectKotlinClass) obj).klass)) {
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    @NotNull
    public KotlinClassHeader getClassHeader() {
        return this.classHeader;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    @NotNull
    public ClassId getClassId() {
        return ReflectClassUtilKt.getClassId(this.klass);
    }

    @NotNull
    public final Class<?> getKlass() {
        return this.klass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    @NotNull
    public String getLocation() {
        String replace$default;
        StringBuilder sb5 = new StringBuilder();
        String name = this.klass.getName();
        Intrinsics.checkNotNullExpressionValue(name, "klass.name");
        replace$default = StringsKt__StringsJVMKt.replace$default(name, '.', '/', false, 4, (Object) null);
        sb5.append(replace$default);
        sb5.append(".class");
        return sb5.toString();
    }

    public int hashCode() {
        return this.klass.hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public void loadClassAnnotations(@NotNull KotlinJvmBinaryClass.AnnotationVisitor visitor, @Nullable byte[] bArr) {
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        ReflectClassStructure.INSTANCE.loadClassAnnotations(this.klass, visitor);
    }

    @NotNull
    public String toString() {
        return ReflectKotlinClass.class.getName() + MsgSummary.STR_COLON + this.klass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public void visitMembers(@NotNull KotlinJvmBinaryClass.MemberVisitor visitor, @Nullable byte[] bArr) {
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        ReflectClassStructure.INSTANCE.visitMembers(this.klass, visitor);
    }

    ReflectKotlinClass(Class<?> cls, KotlinClassHeader kotlinClassHeader) {
        this.klass = cls;
        this.classHeader = kotlinClassHeader;
    }
}
