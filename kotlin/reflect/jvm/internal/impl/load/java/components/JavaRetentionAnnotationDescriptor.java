package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class JavaRetentionAnnotationDescriptor extends JavaAnnotationDescriptor {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JavaRetentionAnnotationDescriptor.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};

    @NotNull
    private final NotNullLazyValue allValueArguments$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaRetentionAnnotationDescriptor(@NotNull JavaAnnotation annotation, @NotNull LazyJavaResolverContext c16) {
        super(c16, annotation, StandardNames.FqNames.retention);
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        Intrinsics.checkNotNullParameter(c16, "c");
        this.allValueArguments$delegate = c16.getStorageManager().createLazyValue(new Function0<Map<Name, ? extends ConstantValue<?>>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.components.JavaRetentionAnnotationDescriptor$allValueArguments$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<Name, ? extends ConstantValue<?>> invoke() {
                Map<Name, ? extends ConstantValue<?>> emptyMap;
                ConstantValue<?> mapJavaRetentionArgument$descriptors_jvm = JavaAnnotationTargetMapper.INSTANCE.mapJavaRetentionArgument$descriptors_jvm(JavaRetentionAnnotationDescriptor.this.getFirstArgument());
                Map<Name, ? extends ConstantValue<?>> mapOf = mapJavaRetentionArgument$descriptors_jvm != null ? MapsKt__MapsJVMKt.mapOf(TuplesKt.to(JavaAnnotationMapper.INSTANCE.getRETENTION_ANNOTATION_VALUE$descriptors_jvm(), mapJavaRetentionArgument$descriptors_jvm)) : null;
                if (mapOf != null) {
                    return mapOf;
                }
                emptyMap = MapsKt__MapsKt.emptyMap();
                return emptyMap;
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    @NotNull
    public Map<Name, ConstantValue<?>> getAllValueArguments() {
        return (Map) StorageKt.getValue(this.allValueArguments$delegate, this, (KProperty<?>) $$delegatedProperties[0]);
    }
}
