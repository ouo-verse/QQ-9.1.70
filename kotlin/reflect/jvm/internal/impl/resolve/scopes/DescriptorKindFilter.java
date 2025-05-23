package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.tencent.midas.comm.log.util.APLogFileUtil;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class DescriptorKindFilter {

    @JvmField
    @NotNull
    public static final DescriptorKindFilter ALL;
    private static final int ALL_KINDS_MASK;

    @JvmField
    @NotNull
    public static final DescriptorKindFilter CALLABLES;
    private static final int CALLABLES_MASK;

    @JvmField
    @NotNull
    public static final DescriptorKindFilter CLASSIFIERS;
    private static final int CLASSIFIERS_MASK;

    @NotNull
    public static final Companion Companion;

    @NotNull
    private static final List<Companion.MaskToName> DEBUG_MASK_BIT_NAMES;

    @NotNull
    private static final List<Companion.MaskToName> DEBUG_PREDEFINED_FILTERS_MASK_NAMES;

    @JvmField
    @NotNull
    public static final DescriptorKindFilter FUNCTIONS;
    private static final int FUNCTIONS_MASK;

    @JvmField
    @NotNull
    public static final DescriptorKindFilter NON_SINGLETON_CLASSIFIERS;
    private static final int NON_SINGLETON_CLASSIFIERS_MASK;

    @JvmField
    @NotNull
    public static final DescriptorKindFilter PACKAGES;
    private static final int PACKAGES_MASK;

    @JvmField
    @NotNull
    public static final DescriptorKindFilter SINGLETON_CLASSIFIERS;
    private static final int SINGLETON_CLASSIFIERS_MASK;

    @JvmField
    @NotNull
    public static final DescriptorKindFilter TYPE_ALIASES;
    private static final int TYPE_ALIASES_MASK;

    @JvmField
    @NotNull
    public static final DescriptorKindFilter VALUES;
    private static final int VALUES_MASK;

    @JvmField
    @NotNull
    public static final DescriptorKindFilter VARIABLES;
    private static final int VARIABLES_MASK;
    private static int nextMaskValue;

    @NotNull
    private final List<DescriptorKindExclude> excludes;
    private final int kindMask;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Companion {

        /* compiled from: P */
        /* loaded from: classes28.dex */
        private static final class MaskToName {
            private final int mask;

            @NotNull
            private final String name;

            public MaskToName(int i3, @NotNull String name) {
                Intrinsics.checkNotNullParameter(name, "name");
                this.mask = i3;
                this.name = name;
            }

            public final int getMask() {
                return this.mask;
            }

            @NotNull
            public final String getName() {
                return this.name;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int nextMask() {
            int i3 = DescriptorKindFilter.nextMaskValue;
            DescriptorKindFilter.nextMaskValue <<= 1;
            return i3;
        }

        public final int getALL_KINDS_MASK() {
            return DescriptorKindFilter.ALL_KINDS_MASK;
        }

        public final int getCLASSIFIERS_MASK() {
            return DescriptorKindFilter.CLASSIFIERS_MASK;
        }

        public final int getFUNCTIONS_MASK() {
            return DescriptorKindFilter.FUNCTIONS_MASK;
        }

        public final int getNON_SINGLETON_CLASSIFIERS_MASK() {
            return DescriptorKindFilter.NON_SINGLETON_CLASSIFIERS_MASK;
        }

        public final int getPACKAGES_MASK() {
            return DescriptorKindFilter.PACKAGES_MASK;
        }

        public final int getSINGLETON_CLASSIFIERS_MASK() {
            return DescriptorKindFilter.SINGLETON_CLASSIFIERS_MASK;
        }

        public final int getTYPE_ALIASES_MASK() {
            return DescriptorKindFilter.TYPE_ALIASES_MASK;
        }

        public final int getVARIABLES_MASK() {
            return DescriptorKindFilter.VARIABLES_MASK;
        }

        Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        byte b16;
        Companion.MaskToName maskToName;
        DescriptorKindFilter descriptorKindFilter;
        Companion.MaskToName maskToName2;
        Companion companion = new Companion(null);
        Companion = companion;
        nextMaskValue = 1;
        int nextMask = companion.nextMask();
        NON_SINGLETON_CLASSIFIERS_MASK = nextMask;
        int nextMask2 = companion.nextMask();
        SINGLETON_CLASSIFIERS_MASK = nextMask2;
        int nextMask3 = companion.nextMask();
        TYPE_ALIASES_MASK = nextMask3;
        int nextMask4 = companion.nextMask();
        PACKAGES_MASK = nextMask4;
        int nextMask5 = companion.nextMask();
        FUNCTIONS_MASK = nextMask5;
        int nextMask6 = companion.nextMask();
        VARIABLES_MASK = nextMask6;
        int nextMask7 = companion.nextMask() - 1;
        ALL_KINDS_MASK = nextMask7;
        int i3 = nextMask | nextMask2 | nextMask3;
        CLASSIFIERS_MASK = i3;
        int i16 = nextMask2 | nextMask5 | nextMask6;
        VALUES_MASK = i16;
        int i17 = nextMask5 | nextMask6;
        CALLABLES_MASK = i17;
        int i18 = 2;
        ALL = new DescriptorKindFilter(nextMask7, 0 == true ? 1 : 0, i18, 0 == true ? 1 : 0);
        CALLABLES = new DescriptorKindFilter(i17, 0 == true ? 1 : 0, i18, 0 == true ? 1 : 0);
        NON_SINGLETON_CLASSIFIERS = new DescriptorKindFilter(nextMask, 0 == true ? 1 : 0, i18, 0 == true ? 1 : 0);
        SINGLETON_CLASSIFIERS = new DescriptorKindFilter(nextMask2, 0 == true ? 1 : 0, i18, 0 == true ? 1 : 0);
        TYPE_ALIASES = new DescriptorKindFilter(nextMask3, 0 == true ? 1 : 0, i18, 0 == true ? 1 : 0);
        CLASSIFIERS = new DescriptorKindFilter(i3, 0 == true ? 1 : 0, i18, 0 == true ? 1 : 0);
        PACKAGES = new DescriptorKindFilter(nextMask4, 0 == true ? 1 : 0, i18, 0 == true ? 1 : 0);
        FUNCTIONS = new DescriptorKindFilter(nextMask5, 0 == true ? 1 : 0, i18, 0 == true ? 1 : 0);
        VARIABLES = new DescriptorKindFilter(nextMask6, 0 == true ? 1 : 0, i18, 0 == true ? 1 : 0);
        VALUES = new DescriptorKindFilter(i16, 0 == true ? 1 : 0, i18, 0 == true ? 1 : 0);
        Field[] fields = DescriptorKindFilter.class.getFields();
        Intrinsics.checkNotNullExpressionValue(fields, "T::class.java.fields");
        ArrayList<Field> arrayList = new ArrayList();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())) {
                arrayList.add(field);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Field field2 : arrayList) {
            Object obj = field2.get(null);
            if (obj instanceof DescriptorKindFilter) {
                descriptorKindFilter = (DescriptorKindFilter) obj;
            } else {
                descriptorKindFilter = null;
            }
            if (descriptorKindFilter != null) {
                int i19 = descriptorKindFilter.kindMask;
                String name = field2.getName();
                Intrinsics.checkNotNullExpressionValue(name, "field.name");
                maskToName2 = new Companion.MaskToName(i19, name);
            } else {
                maskToName2 = null;
            }
            if (maskToName2 != null) {
                arrayList2.add(maskToName2);
            }
        }
        DEBUG_PREDEFINED_FILTERS_MASK_NAMES = arrayList2;
        Field[] fields2 = DescriptorKindFilter.class.getFields();
        Intrinsics.checkNotNullExpressionValue(fields2, "T::class.java.fields");
        ArrayList arrayList3 = new ArrayList();
        for (Field field3 : fields2) {
            if (Modifier.isStatic(field3.getModifiers())) {
                arrayList3.add(field3);
            }
        }
        ArrayList<Field> arrayList4 = new ArrayList();
        for (Object obj2 : arrayList3) {
            if (Intrinsics.areEqual(((Field) obj2).getType(), Integer.TYPE)) {
                arrayList4.add(obj2);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        for (Field field4 : arrayList4) {
            Object obj3 = field4.get(null);
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) obj3).intValue();
            if (intValue == ((-intValue) & intValue)) {
                b16 = true;
            } else {
                b16 = false;
            }
            if (b16 != false) {
                String name2 = field4.getName();
                Intrinsics.checkNotNullExpressionValue(name2, "field.name");
                maskToName = new Companion.MaskToName(intValue, name2);
            } else {
                maskToName = null;
            }
            if (maskToName != null) {
                arrayList5.add(maskToName);
            }
        }
        DEBUG_MASK_BIT_NAMES = arrayList5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DescriptorKindFilter(int i3, @NotNull List<? extends DescriptorKindExclude> excludes) {
        Intrinsics.checkNotNullParameter(excludes, "excludes");
        this.excludes = excludes;
        Iterator it = excludes.iterator();
        while (it.hasNext()) {
            i3 &= ~((DescriptorKindExclude) it.next()).getFullyExcludedDescriptorKinds();
        }
        this.kindMask = i3;
    }

    public final boolean acceptsKinds(int i3) {
        if ((i3 & this.kindMask) != 0) {
            return true;
        }
        return false;
    }

    public boolean equals(@Nullable Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            cls = obj.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(DescriptorKindFilter.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.DescriptorKindFilter");
        DescriptorKindFilter descriptorKindFilter = (DescriptorKindFilter) obj;
        if (Intrinsics.areEqual(this.excludes, descriptorKindFilter.excludes) && this.kindMask == descriptorKindFilter.kindMask) {
            return true;
        }
        return false;
    }

    @NotNull
    public final List<DescriptorKindExclude> getExcludes() {
        return this.excludes;
    }

    public final int getKindMask() {
        return this.kindMask;
    }

    public int hashCode() {
        return (this.excludes.hashCode() * 31) + this.kindMask;
    }

    @Nullable
    public final DescriptorKindFilter restrictedToKindsOrNull(int i3) {
        int i16 = i3 & this.kindMask;
        if (i16 == 0) {
            return null;
        }
        return new DescriptorKindFilter(i16, this.excludes);
    }

    @NotNull
    public String toString() {
        Object obj;
        String str;
        String str2;
        boolean z16;
        Iterator<T> it = DEBUG_PREDEFINED_FILTERS_MASK_NAMES.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((Companion.MaskToName) obj).getMask() == this.kindMask) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        Companion.MaskToName maskToName = (Companion.MaskToName) obj;
        if (maskToName != null) {
            str = maskToName.getName();
        } else {
            str = null;
        }
        if (str == null) {
            List<Companion.MaskToName> list = DEBUG_MASK_BIT_NAMES;
            ArrayList arrayList = new ArrayList();
            for (Companion.MaskToName maskToName2 : list) {
                if (acceptsKinds(maskToName2.getMask())) {
                    str2 = maskToName2.getName();
                } else {
                    str2 = null;
                }
                if (str2 != null) {
                    arrayList.add(str2);
                }
            }
            str = CollectionsKt___CollectionsKt.joinToString$default(arrayList, APLogFileUtil.SEPARATOR_LOG, null, null, 0, null, null, 62, null);
        }
        return "DescriptorKindFilter(" + str + ", " + this.excludes + ')';
    }

    public /* synthetic */ DescriptorKindFilter(int i3, List list, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }
}
