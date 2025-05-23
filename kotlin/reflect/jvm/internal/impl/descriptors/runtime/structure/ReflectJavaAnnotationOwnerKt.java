package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class ReflectJavaAnnotationOwnerKt {
    @Nullable
    public static final ReflectJavaAnnotation findAnnotation(@NotNull Annotation[] annotationArr, @NotNull FqName fqName) {
        Annotation annotation;
        Intrinsics.checkNotNullParameter(annotationArr, "<this>");
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        int length = annotationArr.length;
        int i3 = 0;
        while (true) {
            if (i3 < length) {
                annotation = annotationArr[i3];
                if (Intrinsics.areEqual(ReflectClassUtilKt.getClassId(JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(annotation))).asSingleFqName(), fqName)) {
                    break;
                }
                i3++;
            } else {
                annotation = null;
                break;
            }
        }
        if (annotation == null) {
            return null;
        }
        return new ReflectJavaAnnotation(annotation);
    }

    @NotNull
    public static final List<ReflectJavaAnnotation> getAnnotations(@NotNull Annotation[] annotationArr) {
        Intrinsics.checkNotNullParameter(annotationArr, "<this>");
        ArrayList arrayList = new ArrayList(annotationArr.length);
        for (Annotation annotation : annotationArr) {
            arrayList.add(new ReflectJavaAnnotation(annotation));
        }
        return arrayList;
    }
}
