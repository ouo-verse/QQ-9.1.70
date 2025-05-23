package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes28.dex */
public final class JvmProtoBufUtil {

    @NotNull
    private static final ExtensionRegistryLite EXTENSION_REGISTRY;

    @NotNull
    public static final JvmProtoBufUtil INSTANCE = new JvmProtoBufUtil();

    static {
        ExtensionRegistryLite newInstance = ExtensionRegistryLite.newInstance();
        JvmProtoBuf.registerAllExtensions(newInstance);
        Intrinsics.checkNotNullExpressionValue(newInstance, "newInstance().apply(JvmP\u2026f::registerAllExtensions)");
        EXTENSION_REGISTRY = newInstance;
    }

    JvmProtoBufUtil() {
    }

    public static /* synthetic */ JvmMemberSignature.Field getJvmFieldSignature$default(JvmProtoBufUtil jvmProtoBufUtil, ProtoBuf.Property property, NameResolver nameResolver, TypeTable typeTable, boolean z16, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z16 = true;
        }
        return jvmProtoBufUtil.getJvmFieldSignature(property, nameResolver, typeTable, z16);
    }

    @JvmStatic
    public static final boolean isMovedFromInterfaceCompanion(@NotNull ProtoBuf.Property proto) {
        Intrinsics.checkNotNullParameter(proto, "proto");
        Flags.BooleanFlagField is_moved_from_interface_companion = JvmFlags.INSTANCE.getIS_MOVED_FROM_INTERFACE_COMPANION();
        Object extension = proto.getExtension(JvmProtoBuf.flags);
        Intrinsics.checkNotNullExpressionValue(extension, "proto.getExtension(JvmProtoBuf.flags)");
        Boolean bool = is_moved_from_interface_companion.get(((Number) extension).intValue());
        Intrinsics.checkNotNullExpressionValue(bool, "JvmFlags.IS_MOVED_FROM_I\u2026nsion(JvmProtoBuf.flags))");
        return bool.booleanValue();
    }

    private final String mapTypeDefault(ProtoBuf.Type type, NameResolver nameResolver) {
        if (type.hasClassName()) {
            return ClassMapperLite.mapClass(nameResolver.getQualifiedClassName(type.getClassName()));
        }
        return null;
    }

    @JvmStatic
    @NotNull
    public static final Pair<JvmNameResolver, ProtoBuf.Class> readClassDataFrom(@NotNull String[] data, @NotNull String[] strings) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(strings, "strings");
        byte[] decodeBytes = BitEncoding.decodeBytes(data);
        Intrinsics.checkNotNullExpressionValue(decodeBytes, "decodeBytes(data)");
        return readClassDataFrom(decodeBytes, strings);
    }

    @JvmStatic
    @NotNull
    public static final Pair<JvmNameResolver, ProtoBuf.Function> readFunctionDataFrom(@NotNull String[] data, @NotNull String[] strings) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(strings, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(BitEncoding.decodeBytes(data));
        return new Pair<>(INSTANCE.readNameResolver(byteArrayInputStream, strings), ProtoBuf.Function.parseFrom(byteArrayInputStream, EXTENSION_REGISTRY));
    }

    private final JvmNameResolver readNameResolver(InputStream inputStream, String[] strArr) {
        JvmProtoBuf.StringTableTypes parseDelimitedFrom = JvmProtoBuf.StringTableTypes.parseDelimitedFrom(inputStream, EXTENSION_REGISTRY);
        Intrinsics.checkNotNullExpressionValue(parseDelimitedFrom, "parseDelimitedFrom(this, EXTENSION_REGISTRY)");
        return new JvmNameResolver(parseDelimitedFrom, strArr);
    }

    @JvmStatic
    @NotNull
    public static final Pair<JvmNameResolver, ProtoBuf.Package> readPackageDataFrom(@NotNull String[] data, @NotNull String[] strings) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(strings, "strings");
        byte[] decodeBytes = BitEncoding.decodeBytes(data);
        Intrinsics.checkNotNullExpressionValue(decodeBytes, "decodeBytes(data)");
        return readPackageDataFrom(decodeBytes, strings);
    }

    @NotNull
    public final ExtensionRegistryLite getEXTENSION_REGISTRY() {
        return EXTENSION_REGISTRY;
    }

    @Nullable
    public final JvmMemberSignature.Method getJvmConstructorSignature(@NotNull ProtoBuf.Constructor proto, @NotNull NameResolver nameResolver, @NotNull TypeTable typeTable) {
        String str;
        int collectionSizeOrDefault;
        String joinToString$default;
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Constructor, JvmProtoBuf.JvmMethodSignature> constructorSignature = JvmProtoBuf.constructorSignature;
        Intrinsics.checkNotNullExpressionValue(constructorSignature, "constructorSignature");
        JvmProtoBuf.JvmMethodSignature jvmMethodSignature = (JvmProtoBuf.JvmMethodSignature) ProtoBufUtilKt.getExtensionOrNull(proto, constructorSignature);
        if (jvmMethodSignature != null && jvmMethodSignature.hasName()) {
            str = nameResolver.getString(jvmMethodSignature.getName());
        } else {
            str = "<init>";
        }
        if (jvmMethodSignature != null && jvmMethodSignature.hasDesc()) {
            joinToString$default = nameResolver.getString(jvmMethodSignature.getDesc());
        } else {
            List<ProtoBuf.ValueParameter> valueParameterList = proto.getValueParameterList();
            Intrinsics.checkNotNullExpressionValue(valueParameterList, "proto.valueParameterList");
            List<ProtoBuf.ValueParameter> list = valueParameterList;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (ProtoBuf.ValueParameter it : list) {
                JvmProtoBufUtil jvmProtoBufUtil = INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                String mapTypeDefault = jvmProtoBufUtil.mapTypeDefault(ProtoTypeTableUtilKt.type(it, typeTable), nameResolver);
                if (mapTypeDefault == null) {
                    return null;
                }
                arrayList.add(mapTypeDefault);
            }
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, "", "(", ")V", 0, null, null, 56, null);
        }
        return new JvmMemberSignature.Method(str, joinToString$default);
    }

    @Nullable
    public final JvmMemberSignature.Field getJvmFieldSignature(@NotNull ProtoBuf.Property proto, @NotNull NameResolver nameResolver, @NotNull TypeTable typeTable, boolean z16) {
        JvmProtoBuf.JvmFieldSignature jvmFieldSignature;
        int name;
        String mapTypeDefault;
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, JvmProtoBuf.JvmPropertySignature> propertySignature = JvmProtoBuf.propertySignature;
        Intrinsics.checkNotNullExpressionValue(propertySignature, "propertySignature");
        JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull(proto, propertySignature);
        if (jvmPropertySignature == null) {
            return null;
        }
        if (jvmPropertySignature.hasField()) {
            jvmFieldSignature = jvmPropertySignature.getField();
        } else {
            jvmFieldSignature = null;
        }
        if (jvmFieldSignature == null && z16) {
            return null;
        }
        if (jvmFieldSignature != null && jvmFieldSignature.hasName()) {
            name = jvmFieldSignature.getName();
        } else {
            name = proto.getName();
        }
        if (jvmFieldSignature != null && jvmFieldSignature.hasDesc()) {
            mapTypeDefault = nameResolver.getString(jvmFieldSignature.getDesc());
        } else {
            mapTypeDefault = mapTypeDefault(ProtoTypeTableUtilKt.returnType(proto, typeTable), nameResolver);
            if (mapTypeDefault == null) {
                return null;
            }
        }
        return new JvmMemberSignature.Field(nameResolver.getString(name), mapTypeDefault);
    }

    @Nullable
    public final JvmMemberSignature.Method getJvmMethodSignature(@NotNull ProtoBuf.Function proto, @NotNull NameResolver nameResolver, @NotNull TypeTable typeTable) {
        int name;
        List listOfNotNull;
        int collectionSizeOrDefault;
        List plus;
        int collectionSizeOrDefault2;
        String joinToString$default;
        String sb5;
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, JvmProtoBuf.JvmMethodSignature> methodSignature = JvmProtoBuf.methodSignature;
        Intrinsics.checkNotNullExpressionValue(methodSignature, "methodSignature");
        JvmProtoBuf.JvmMethodSignature jvmMethodSignature = (JvmProtoBuf.JvmMethodSignature) ProtoBufUtilKt.getExtensionOrNull(proto, methodSignature);
        if (jvmMethodSignature != null && jvmMethodSignature.hasName()) {
            name = jvmMethodSignature.getName();
        } else {
            name = proto.getName();
        }
        if (jvmMethodSignature == null || !jvmMethodSignature.hasDesc()) {
            listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull(ProtoTypeTableUtilKt.receiverType(proto, typeTable));
            List list = listOfNotNull;
            List<ProtoBuf.ValueParameter> valueParameterList = proto.getValueParameterList();
            Intrinsics.checkNotNullExpressionValue(valueParameterList, "proto.valueParameterList");
            List<ProtoBuf.ValueParameter> list2 = valueParameterList;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (ProtoBuf.ValueParameter it : list2) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList.add(ProtoTypeTableUtilKt.type(it, typeTable));
            }
            plus = CollectionsKt___CollectionsKt.plus((Collection) list, (Iterable) arrayList);
            List list3 = plus;
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
            Iterator it5 = list3.iterator();
            while (it5.hasNext()) {
                String mapTypeDefault = INSTANCE.mapTypeDefault((ProtoBuf.Type) it5.next(), nameResolver);
                if (mapTypeDefault == null) {
                    return null;
                }
                arrayList2.add(mapTypeDefault);
            }
            String mapTypeDefault2 = mapTypeDefault(ProtoTypeTableUtilKt.returnType(proto, typeTable), nameResolver);
            if (mapTypeDefault2 == null) {
                return null;
            }
            StringBuilder sb6 = new StringBuilder();
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList2, "", "(", ")", 0, null, null, 56, null);
            sb6.append(joinToString$default);
            sb6.append(mapTypeDefault2);
            sb5 = sb6.toString();
        } else {
            sb5 = nameResolver.getString(jvmMethodSignature.getDesc());
        }
        return new JvmMemberSignature.Method(nameResolver.getString(name), sb5);
    }

    @JvmStatic
    @NotNull
    public static final Pair<JvmNameResolver, ProtoBuf.Class> readClassDataFrom(@NotNull byte[] bytes, @NotNull String[] strings) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(strings, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        return new Pair<>(INSTANCE.readNameResolver(byteArrayInputStream, strings), ProtoBuf.Class.parseFrom(byteArrayInputStream, EXTENSION_REGISTRY));
    }

    @JvmStatic
    @NotNull
    public static final Pair<JvmNameResolver, ProtoBuf.Package> readPackageDataFrom(@NotNull byte[] bytes, @NotNull String[] strings) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(strings, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        return new Pair<>(INSTANCE.readNameResolver(byteArrayInputStream, strings), ProtoBuf.Package.parseFrom(byteArrayInputStream, EXTENSION_REGISTRY));
    }
}
