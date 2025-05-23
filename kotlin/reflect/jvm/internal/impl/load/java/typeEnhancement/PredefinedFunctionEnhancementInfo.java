package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes28.dex */
public final class PredefinedFunctionEnhancementInfo {

    @NotNull
    private final List<TypeEnhancementInfo> parametersInfo;

    @Nullable
    private final TypeEnhancementInfo returnTypeInfo;

    public PredefinedFunctionEnhancementInfo() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @NotNull
    public final List<TypeEnhancementInfo> getParametersInfo() {
        return this.parametersInfo;
    }

    @Nullable
    public final TypeEnhancementInfo getReturnTypeInfo() {
        return this.returnTypeInfo;
    }

    public PredefinedFunctionEnhancementInfo(@Nullable TypeEnhancementInfo typeEnhancementInfo, @NotNull List<TypeEnhancementInfo> parametersInfo) {
        Intrinsics.checkNotNullParameter(parametersInfo, "parametersInfo");
        this.returnTypeInfo = typeEnhancementInfo;
        this.parametersInfo = parametersInfo;
    }

    public /* synthetic */ PredefinedFunctionEnhancementInfo(TypeEnhancementInfo typeEnhancementInfo, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : typeEnhancementInfo, (i3 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }
}
