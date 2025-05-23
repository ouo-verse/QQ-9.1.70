package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class JavaTypeEnhancementState {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final JavaTypeEnhancementState DEFAULT = new JavaTypeEnhancementState(JavaNullabilityAnnotationSettingsKt.getDefaultJsr305Settings$default(null, 1, null), JavaTypeEnhancementState$Companion$DEFAULT$1.INSTANCE);
    private final boolean disabledDefaultAnnotations;

    @NotNull
    private final Function1<FqName, ReportLevel> getReportLevelForAnnotation;

    @NotNull
    private final Jsr305Settings jsr305;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final JavaTypeEnhancementState getDEFAULT() {
            return JavaTypeEnhancementState.DEFAULT;
        }

        Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JavaTypeEnhancementState(@NotNull Jsr305Settings jsr305, @NotNull Function1<? super FqName, ? extends ReportLevel> getReportLevelForAnnotation) {
        boolean z16;
        Intrinsics.checkNotNullParameter(jsr305, "jsr305");
        Intrinsics.checkNotNullParameter(getReportLevelForAnnotation, "getReportLevelForAnnotation");
        this.jsr305 = jsr305;
        this.getReportLevelForAnnotation = getReportLevelForAnnotation;
        if (!jsr305.isDisabled() && getReportLevelForAnnotation.invoke(JavaNullabilityAnnotationSettingsKt.getJSPECIFY_ANNOTATIONS_PACKAGE()) != ReportLevel.IGNORE) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.disabledDefaultAnnotations = z16;
    }

    public final boolean getDisabledDefaultAnnotations() {
        return this.disabledDefaultAnnotations;
    }

    @NotNull
    public final Function1<FqName, ReportLevel> getGetReportLevelForAnnotation() {
        return this.getReportLevelForAnnotation;
    }

    @NotNull
    public final Jsr305Settings getJsr305() {
        return this.jsr305;
    }

    @NotNull
    public String toString() {
        return "JavaTypeEnhancementState(jsr305=" + this.jsr305 + ", getReportLevelForAnnotation=" + this.getReportLevelForAnnotation + ')';
    }
}
