package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.SerializerExtensionProtocol;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes28.dex */
public final class BuiltInSerializerProtocol extends SerializerExtensionProtocol {

    @NotNull
    public static final BuiltInSerializerProtocol INSTANCE = new BuiltInSerializerProtocol();

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    BuiltInSerializerProtocol() {
        super(r1, packageFqName, constructorAnnotation, classAnnotation, functionAnnotation, propertyAnnotation, propertyGetterAnnotation, propertySetterAnnotation, enumEntryAnnotation, compileTimeValue, parameterAnnotation, typeAnnotation, typeParameterAnnotation);
        ExtensionRegistryLite newInstance = ExtensionRegistryLite.newInstance();
        BuiltInsProtoBuf.registerAllExtensions(newInstance);
        Intrinsics.checkNotNullExpressionValue(newInstance, "newInstance().apply(Buil\u2026f::registerAllExtensions)");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, Integer> packageFqName = BuiltInsProtoBuf.packageFqName;
        Intrinsics.checkNotNullExpressionValue(packageFqName, "packageFqName");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Constructor, List<ProtoBuf.Annotation>> constructorAnnotation = BuiltInsProtoBuf.constructorAnnotation;
        Intrinsics.checkNotNullExpressionValue(constructorAnnotation, "constructorAnnotation");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, List<ProtoBuf.Annotation>> classAnnotation = BuiltInsProtoBuf.classAnnotation;
        Intrinsics.checkNotNullExpressionValue(classAnnotation, "classAnnotation");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, List<ProtoBuf.Annotation>> functionAnnotation = BuiltInsProtoBuf.functionAnnotation;
        Intrinsics.checkNotNullExpressionValue(functionAnnotation, "functionAnnotation");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> propertyAnnotation = BuiltInsProtoBuf.propertyAnnotation;
        Intrinsics.checkNotNullExpressionValue(propertyAnnotation, "propertyAnnotation");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> propertyGetterAnnotation = BuiltInsProtoBuf.propertyGetterAnnotation;
        Intrinsics.checkNotNullExpressionValue(propertyGetterAnnotation, "propertyGetterAnnotation");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> propertySetterAnnotation = BuiltInsProtoBuf.propertySetterAnnotation;
        Intrinsics.checkNotNullExpressionValue(propertySetterAnnotation, "propertySetterAnnotation");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.EnumEntry, List<ProtoBuf.Annotation>> enumEntryAnnotation = BuiltInsProtoBuf.enumEntryAnnotation;
        Intrinsics.checkNotNullExpressionValue(enumEntryAnnotation, "enumEntryAnnotation");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, ProtoBuf.Annotation.Argument.Value> compileTimeValue = BuiltInsProtoBuf.compileTimeValue;
        Intrinsics.checkNotNullExpressionValue(compileTimeValue, "compileTimeValue");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.ValueParameter, List<ProtoBuf.Annotation>> parameterAnnotation = BuiltInsProtoBuf.parameterAnnotation;
        Intrinsics.checkNotNullExpressionValue(parameterAnnotation, "parameterAnnotation");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Type, List<ProtoBuf.Annotation>> typeAnnotation = BuiltInsProtoBuf.typeAnnotation;
        Intrinsics.checkNotNullExpressionValue(typeAnnotation, "typeAnnotation");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.TypeParameter, List<ProtoBuf.Annotation>> typeParameterAnnotation = BuiltInsProtoBuf.typeParameterAnnotation;
        Intrinsics.checkNotNullExpressionValue(typeParameterAnnotation, "typeParameterAnnotation");
    }

    private final String shortName(FqName fqName) {
        if (fqName.isRoot()) {
            return "default-package";
        }
        String asString = fqName.shortName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "fqName.shortName().asString()");
        return asString;
    }

    @NotNull
    public final String getBuiltInsFileName(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return shortName(fqName) + ".kotlin_builtins";
    }

    @NotNull
    public final String getBuiltInsFilePath(@NotNull FqName fqName) {
        String replace$default;
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        StringBuilder sb5 = new StringBuilder();
        String asString = fqName.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "fqName.asString()");
        replace$default = StringsKt__StringsJVMKt.replace$default(asString, '.', '/', false, 4, (Object) null);
        sb5.append(replace$default);
        sb5.append('/');
        sb5.append(getBuiltInsFileName(fqName));
        return sb5.toString();
    }
}
