package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes28.dex */
public final class PropertiesConventionUtilKt {
    @NotNull
    public static final List<Name> getPropertyNamesCandidatesByAccessorName(@NotNull Name name) {
        List<Name> listOfNotNull;
        Intrinsics.checkNotNullParameter(name, "name");
        String asString = name.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "name.asString()");
        if (JvmAbi.isGetterName(asString)) {
            listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull(propertyNameByGetMethodName(name));
            return listOfNotNull;
        }
        if (JvmAbi.isSetterName(asString)) {
            return propertyNamesBySetMethodName(name);
        }
        return BuiltinSpecialProperties.INSTANCE.getPropertyNameCandidatesBySpecialGetterName(name);
    }

    @Nullable
    public static final Name propertyNameByGetMethodName(@NotNull Name methodName) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Name propertyNameFromAccessorMethodName$default = propertyNameFromAccessorMethodName$default(methodName, "get", false, null, 12, null);
        if (propertyNameFromAccessorMethodName$default == null) {
            return propertyNameFromAccessorMethodName$default(methodName, "is", false, null, 8, null);
        }
        return propertyNameFromAccessorMethodName$default;
    }

    @Nullable
    public static final Name propertyNameBySetMethodName(@NotNull Name methodName, boolean z16) {
        String str;
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        if (z16) {
            str = "is";
        } else {
            str = null;
        }
        return propertyNameFromAccessorMethodName$default(methodName, "set", false, str, 4, null);
    }

    private static final Name propertyNameFromAccessorMethodName(Name name, String str, boolean z16, String str2) {
        boolean startsWith$default;
        String removePrefix;
        String removePrefix2;
        if (name.isSpecial()) {
            return null;
        }
        String identifier = name.getIdentifier();
        Intrinsics.checkNotNullExpressionValue(identifier, "methodName.identifier");
        boolean z17 = false;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(identifier, str, false, 2, null);
        if (!startsWith$default || identifier.length() == str.length()) {
            return null;
        }
        char charAt = identifier.charAt(str.length());
        if ('a' <= charAt && charAt < '{') {
            z17 = true;
        }
        if (z17) {
            return null;
        }
        if (str2 != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str2);
            removePrefix2 = StringsKt__StringsKt.removePrefix(identifier, (CharSequence) str);
            sb5.append(removePrefix2);
            return Name.identifier(sb5.toString());
        }
        if (z16) {
            removePrefix = StringsKt__StringsKt.removePrefix(identifier, (CharSequence) str);
            String decapitalizeSmartForCompiler = CapitalizeDecapitalizeKt.decapitalizeSmartForCompiler(removePrefix, true);
            if (!Name.isValidIdentifier(decapitalizeSmartForCompiler)) {
                return null;
            }
            return Name.identifier(decapitalizeSmartForCompiler);
        }
        return name;
    }

    static /* synthetic */ Name propertyNameFromAccessorMethodName$default(Name name, String str, boolean z16, String str2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        if ((i3 & 8) != 0) {
            str2 = null;
        }
        return propertyNameFromAccessorMethodName(name, str, z16, str2);
    }

    @NotNull
    public static final List<Name> propertyNamesBySetMethodName(@NotNull Name methodName) {
        List<Name> listOfNotNull;
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) new Name[]{propertyNameBySetMethodName(methodName, false), propertyNameBySetMethodName(methodName, true)});
        return listOfNotNull;
    }
}
