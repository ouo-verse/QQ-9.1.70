package kotlin.reflect.jvm.internal.impl.name;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class CallableId {

    @NotNull
    private static final Companion Companion = new Companion(null);

    @Deprecated
    @NotNull
    private static final Name LOCAL_NAME;

    @Deprecated
    @NotNull
    private static final FqName PACKAGE_FQ_NAME_FOR_LOCAL;

    @NotNull
    private final Name callableName;

    @Nullable
    private final FqName className;

    @NotNull
    private final FqName packageName;

    @Nullable
    private final FqName pathToLocal;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }
    }

    static {
        Name name = SpecialNames.LOCAL;
        LOCAL_NAME = name;
        FqName fqName = FqName.topLevel(name);
        Intrinsics.checkNotNullExpressionValue(fqName, "topLevel(LOCAL_NAME)");
        PACKAGE_FQ_NAME_FOR_LOCAL = fqName;
    }

    public CallableId(@NotNull FqName packageName, @Nullable FqName fqName, @NotNull Name callableName, @Nullable FqName fqName2) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(callableName, "callableName");
        this.packageName = packageName;
        this.className = fqName;
        this.callableName = callableName;
        this.pathToLocal = fqName2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CallableId)) {
            return false;
        }
        CallableId callableId = (CallableId) obj;
        if (Intrinsics.areEqual(this.packageName, callableId.packageName) && Intrinsics.areEqual(this.className, callableId.className) && Intrinsics.areEqual(this.callableName, callableId.callableName) && Intrinsics.areEqual(this.pathToLocal, callableId.pathToLocal)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = this.packageName.hashCode() * 31;
        FqName fqName = this.className;
        int i3 = 0;
        if (fqName == null) {
            hashCode = 0;
        } else {
            hashCode = fqName.hashCode();
        }
        int hashCode3 = (((hashCode2 + hashCode) * 31) + this.callableName.hashCode()) * 31;
        FqName fqName2 = this.pathToLocal;
        if (fqName2 != null) {
            i3 = fqName2.hashCode();
        }
        return hashCode3 + i3;
    }

    @NotNull
    public String toString() {
        String replace$default;
        StringBuilder sb5 = new StringBuilder();
        String asString = this.packageName.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "packageName.asString()");
        replace$default = StringsKt__StringsJVMKt.replace$default(asString, '.', '/', false, 4, (Object) null);
        sb5.append(replace$default);
        sb5.append("/");
        FqName fqName = this.className;
        if (fqName != null) {
            sb5.append(fqName);
            sb5.append(".");
        }
        sb5.append(this.callableName);
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply(builderAction).toString()");
        return sb6;
    }

    public /* synthetic */ CallableId(FqName fqName, FqName fqName2, Name name, FqName fqName3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(fqName, fqName2, name, (i3 & 8) != 0 ? null : fqName3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CallableId(@NotNull FqName packageName, @NotNull Name callableName) {
        this(packageName, null, callableName, null, 8, null);
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(callableName, "callableName");
    }
}
