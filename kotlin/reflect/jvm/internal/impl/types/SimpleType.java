package kotlin.reflect.jvm.internal.impl.types;

import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.Iterator;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.text.StringsKt__StringBuilderKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class SimpleType extends UnwrappedType implements SimpleTypeMarker, TypeArgumentListMarker {
    public SimpleType() {
        super(null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    @NotNull
    public abstract SimpleType makeNullableAsSpecified(boolean z16);

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    @NotNull
    public abstract SimpleType replaceAttributes(@NotNull TypeAttributes typeAttributes);

    @NotNull
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        Iterator<AnnotationDescriptor> it = getAnnotations().iterator();
        while (it.hasNext()) {
            StringsKt__StringBuilderKt.append(sb5, "[", DescriptorRenderer.renderAnnotation$default(DescriptorRenderer.DEBUG_TEXT, it.next(), null, 2, null), "] ");
        }
        sb5.append(getConstructor());
        if (!getArguments().isEmpty()) {
            CollectionsKt___CollectionsKt.joinTo$default(getArguments(), sb5, ", ", "<", ">", 0, null, null, 112, null);
        }
        if (isMarkedNullable()) {
            sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply(builderAction).toString()");
        return sb6;
    }
}
