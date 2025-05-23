package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class ReflectClassUtilKt {

    @NotNull
    private static final Map<Class<? extends Function<?>>, Integer> FUNCTION_CLASSES;

    @NotNull
    private static final List<KClass<? extends Object>> PRIMITIVE_CLASSES;

    @NotNull
    private static final Map<Class<? extends Object>, Class<? extends Object>> PRIMITIVE_TO_WRAPPER;

    @NotNull
    private static final Map<Class<? extends Object>, Class<? extends Object>> WRAPPER_TO_PRIMITIVE;

    static {
        List<KClass<? extends Object>> listOf;
        int collectionSizeOrDefault;
        Map<Class<? extends Object>, Class<? extends Object>> map;
        int collectionSizeOrDefault2;
        Map<Class<? extends Object>, Class<? extends Object>> map2;
        List listOf2;
        int collectionSizeOrDefault3;
        Map<Class<? extends Function<?>>, Integer> map3;
        int i3 = 0;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new KClass[]{Reflection.getOrCreateKotlinClass(Boolean.TYPE), Reflection.getOrCreateKotlinClass(Byte.TYPE), Reflection.getOrCreateKotlinClass(Character.TYPE), Reflection.getOrCreateKotlinClass(Double.TYPE), Reflection.getOrCreateKotlinClass(Float.TYPE), Reflection.getOrCreateKotlinClass(Integer.TYPE), Reflection.getOrCreateKotlinClass(Long.TYPE), Reflection.getOrCreateKotlinClass(Short.TYPE)});
        PRIMITIVE_CLASSES = listOf;
        List<KClass<? extends Object>> list = listOf;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            KClass kClass = (KClass) it.next();
            arrayList.add(TuplesKt.to(JvmClassMappingKt.getJavaObjectType(kClass), JvmClassMappingKt.getJavaPrimitiveType(kClass)));
        }
        map = MapsKt__MapsKt.toMap(arrayList);
        WRAPPER_TO_PRIMITIVE = map;
        List<KClass<? extends Object>> list2 = PRIMITIVE_CLASSES;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it5 = list2.iterator();
        while (it5.hasNext()) {
            KClass kClass2 = (KClass) it5.next();
            arrayList2.add(TuplesKt.to(JvmClassMappingKt.getJavaPrimitiveType(kClass2), JvmClassMappingKt.getJavaObjectType(kClass2)));
        }
        map2 = MapsKt__MapsKt.toMap(arrayList2);
        PRIMITIVE_TO_WRAPPER = map2;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class});
        List list3 = listOf2;
        collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault3);
        for (Object obj : list3) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            arrayList3.add(TuplesKt.to((Class) obj, Integer.valueOf(i3)));
            i3 = i16;
        }
        map3 = MapsKt__MapsKt.toMap(arrayList3);
        FUNCTION_CLASSES = map3;
    }

    @NotNull
    public static final ClassId getClassId(@NotNull Class<?> cls) {
        boolean z16;
        ClassId classId;
        ClassId classId2;
        Intrinsics.checkNotNullParameter(cls, "<this>");
        if (!cls.isPrimitive()) {
            if (!cls.isArray()) {
                if (cls.getEnclosingMethod() == null && cls.getEnclosingConstructor() == null) {
                    String simpleName = cls.getSimpleName();
                    Intrinsics.checkNotNullExpressionValue(simpleName, "simpleName");
                    if (simpleName.length() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        Class<?> declaringClass = cls.getDeclaringClass();
                        if (declaringClass == null || (classId2 = getClassId(declaringClass)) == null || (classId = classId2.createNestedClassId(Name.identifier(cls.getSimpleName()))) == null) {
                            classId = ClassId.topLevel(new FqName(cls.getName()));
                        }
                        Intrinsics.checkNotNullExpressionValue(classId, "declaringClass?.classId?\u2026Id.topLevel(FqName(name))");
                        return classId;
                    }
                }
                FqName fqName = new FqName(cls.getName());
                return new ClassId(fqName.parent(), FqName.topLevel(fqName.shortName()), true);
            }
            throw new IllegalArgumentException("Can't compute ClassId for array type: " + cls);
        }
        throw new IllegalArgumentException("Can't compute ClassId for primitive type: " + cls);
    }

    @NotNull
    public static final String getDesc(@NotNull Class<?> cls) {
        String replace$default;
        String replace$default2;
        Intrinsics.checkNotNullParameter(cls, "<this>");
        if (cls.isPrimitive()) {
            String name = cls.getName();
            switch (name.hashCode()) {
                case -1325958191:
                    if (name.equals("double")) {
                        return "D";
                    }
                    break;
                case 104431:
                    if (name.equals(PoiListCacheRecord.WEIGHT_TYPE)) {
                        return "I";
                    }
                    break;
                case 3039496:
                    if (name.equals("byte")) {
                        return "B";
                    }
                    break;
                case 3052374:
                    if (name.equals(WinkDaTongReportConstant.ElementParamValue.XSJ_EDIT_STICKER_TYPE_CHAR)) {
                        return BdhLogUtil.LogTag.Tag_Conn;
                    }
                    break;
                case 3327612:
                    if (name.equals(PoiListCacheRecord.TIMESTAMP_TYPE)) {
                        return "J";
                    }
                    break;
                case 3625364:
                    if (name.equals("void")) {
                        return "V";
                    }
                    break;
                case 64711720:
                    if (name.equals(HippyControllerProps.BOOLEAN)) {
                        return "Z";
                    }
                    break;
                case 97526364:
                    if (name.equals("float")) {
                        return UserInfo.SEX_FEMALE;
                    }
                    break;
                case 109413500:
                    if (name.equals(Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT)) {
                        return ExifInterface.LATITUDE_SOUTH;
                    }
                    break;
            }
            throw new IllegalArgumentException("Unsupported primitive type: " + cls);
        }
        if (cls.isArray()) {
            String name2 = cls.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "name");
            replace$default2 = StringsKt__StringsJVMKt.replace$default(name2, '.', '/', false, 4, (Object) null);
            return replace$default2;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append('L');
        String name3 = cls.getName();
        Intrinsics.checkNotNullExpressionValue(name3, "name");
        replace$default = StringsKt__StringsJVMKt.replace$default(name3, '.', '/', false, 4, (Object) null);
        sb5.append(replace$default);
        sb5.append(';');
        return sb5.toString();
    }

    @Nullable
    public static final Integer getFunctionClassArity(@NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        return FUNCTION_CLASSES.get(cls);
    }

    @NotNull
    public static final List<Type> getParameterizedTypeArguments(@NotNull Type type) {
        Sequence generateSequence;
        Sequence flatMap;
        List<Type> list;
        List<Type> list2;
        List<Type> emptyList;
        Intrinsics.checkNotNullParameter(type, "<this>");
        if (!(type instanceof ParameterizedType)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        if (parameterizedType.getOwnerType() != null) {
            generateSequence = SequencesKt__SequencesKt.generateSequence(type, (Function1<? super Type, ? extends Type>) ((Function1<? super Object, ? extends Object>) new Function1<ParameterizedType, ParameterizedType>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt$parameterizedTypeArguments$1
                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final ParameterizedType invoke(@NotNull ParameterizedType it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Type ownerType = it.getOwnerType();
                    if (ownerType instanceof ParameterizedType) {
                        return (ParameterizedType) ownerType;
                    }
                    return null;
                }
            }));
            flatMap = SequencesKt___SequencesKt.flatMap(generateSequence, new Function1<ParameterizedType, Sequence<? extends Type>>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt$parameterizedTypeArguments$2
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Sequence<Type> invoke(@NotNull ParameterizedType it) {
                    Sequence<Type> asSequence;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Type[] actualTypeArguments = it.getActualTypeArguments();
                    Intrinsics.checkNotNullExpressionValue(actualTypeArguments, "it.actualTypeArguments");
                    asSequence = ArraysKt___ArraysKt.asSequence(actualTypeArguments);
                    return asSequence;
                }
            });
            list = SequencesKt___SequencesKt.toList(flatMap);
            return list;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Intrinsics.checkNotNullExpressionValue(actualTypeArguments, "actualTypeArguments");
        list2 = ArraysKt___ArraysKt.toList(actualTypeArguments);
        return list2;
    }

    @Nullable
    public static final Class<?> getPrimitiveByWrapper(@NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        return WRAPPER_TO_PRIMITIVE.get(cls);
    }

    @NotNull
    public static final ClassLoader getSafeClassLoader(@NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader == null) {
            ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
            Intrinsics.checkNotNullExpressionValue(systemClassLoader, "getSystemClassLoader()");
            return systemClassLoader;
        }
        return classLoader;
    }

    @Nullable
    public static final Class<?> getWrapperByPrimitive(@NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        return PRIMITIVE_TO_WRAPPER.get(cls);
    }

    public static final boolean isEnumClassOrSpecializedEnumEntryClass(@NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        return Enum.class.isAssignableFrom(cls);
    }
}
