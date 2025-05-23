package kotlin.reflect.jvm.internal.impl.name;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FqNamesUtilKt {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[State.values().length];
            try {
                iArr[State.BEGINNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[State.AFTER_DOT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[State.MIDDLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Nullable
    public static final <V> V findValueForMostSpecificFqname(@NotNull FqName fqName, @NotNull Map<FqName, ? extends V> values) {
        Object next;
        Intrinsics.checkNotNullParameter(fqName, "<this>");
        Intrinsics.checkNotNullParameter(values, "values");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<FqName, ? extends V>> it = values.entrySet().iterator();
        while (true) {
            boolean z16 = true;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<FqName, ? extends V> next2 = it.next();
            FqName key = next2.getKey();
            if (!Intrinsics.areEqual(fqName, key) && !isChildOf(fqName, key)) {
                z16 = false;
            }
            if (z16) {
                linkedHashMap.put(next2.getKey(), next2.getValue());
            }
        }
        if (!(!linkedHashMap.isEmpty())) {
            linkedHashMap = null;
        }
        if (linkedHashMap == null) {
            return null;
        }
        Iterator it5 = linkedHashMap.entrySet().iterator();
        if (!it5.hasNext()) {
            next = null;
        } else {
            next = it5.next();
            if (it5.hasNext()) {
                int length = tail((FqName) ((Map.Entry) next).getKey(), fqName).asString().length();
                do {
                    Object next3 = it5.next();
                    int length2 = tail((FqName) ((Map.Entry) next3).getKey(), fqName).asString().length();
                    if (length > length2) {
                        next = next3;
                        length = length2;
                    }
                } while (it5.hasNext());
            }
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry == null) {
            return null;
        }
        return (V) entry.getValue();
    }

    public static final boolean isChildOf(@NotNull FqName fqName, @NotNull FqName packageName) {
        Intrinsics.checkNotNullParameter(fqName, "<this>");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return Intrinsics.areEqual(parentOrNull(fqName), packageName);
    }

    public static final boolean isSubpackageOf(@NotNull FqName fqName, @NotNull FqName packageName) {
        Intrinsics.checkNotNullParameter(fqName, "<this>");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        if (Intrinsics.areEqual(fqName, packageName) || packageName.isRoot()) {
            return true;
        }
        String asString = fqName.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "this.asString()");
        String asString2 = packageName.asString();
        Intrinsics.checkNotNullExpressionValue(asString2, "packageName.asString()");
        return isSubpackageOf(asString, asString2);
    }

    public static final boolean isValidJavaFqName(@Nullable String str) {
        if (str == null) {
            return false;
        }
        State state = State.BEGINNING;
        for (int i3 = 0; i3 < str.length(); i3++) {
            char charAt = str.charAt(i3);
            int i16 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
            if (i16 != 1 && i16 != 2) {
                if (i16 != 3) {
                    continue;
                } else if (charAt == '.') {
                    state = State.AFTER_DOT;
                } else if (!Character.isJavaIdentifierPart(charAt)) {
                    return false;
                }
            } else {
                if (!Character.isJavaIdentifierPart(charAt)) {
                    return false;
                }
                state = State.MIDDLE;
            }
        }
        if (state == State.AFTER_DOT) {
            return false;
        }
        return true;
    }

    @Nullable
    public static final FqName parentOrNull(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "<this>");
        if (fqName.isRoot()) {
            return null;
        }
        return fqName.parent();
    }

    @NotNull
    public static final FqName tail(@NotNull FqName fqName, @NotNull FqName prefix) {
        Intrinsics.checkNotNullParameter(fqName, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (isSubpackageOf(fqName, prefix) && !prefix.isRoot()) {
            if (Intrinsics.areEqual(fqName, prefix)) {
                FqName ROOT = FqName.ROOT;
                Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                return ROOT;
            }
            String asString = fqName.asString();
            Intrinsics.checkNotNullExpressionValue(asString, "asString()");
            String substring = asString.substring(prefix.asString().length() + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            return new FqName(substring);
        }
        return fqName;
    }

    private static final boolean isSubpackageOf(String str, String str2) {
        boolean startsWith$default;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, str2, false, 2, null);
        return startsWith$default && str.charAt(str2.length()) == '.';
    }
}
