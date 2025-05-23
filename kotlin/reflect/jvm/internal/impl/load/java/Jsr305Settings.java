package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class Jsr305Settings {

    @NotNull
    private final Lazy description$delegate;

    @NotNull
    private final ReportLevel globalLevel;
    private final boolean isDisabled;

    @Nullable
    private final ReportLevel migrationLevel;

    @NotNull
    private final Map<FqName, ReportLevel> userDefinedLevelForSpecificAnnotation;

    /* JADX WARN: Multi-variable type inference failed */
    public Jsr305Settings(@NotNull ReportLevel globalLevel, @Nullable ReportLevel reportLevel, @NotNull Map<FqName, ? extends ReportLevel> userDefinedLevelForSpecificAnnotation) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(globalLevel, "globalLevel");
        Intrinsics.checkNotNullParameter(userDefinedLevelForSpecificAnnotation, "userDefinedLevelForSpecificAnnotation");
        this.globalLevel = globalLevel;
        this.migrationLevel = reportLevel;
        this.userDefinedLevelForSpecificAnnotation = userDefinedLevelForSpecificAnnotation;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String[]>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.Jsr305Settings$description$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String[] invoke() {
                List createListBuilder;
                List build;
                Jsr305Settings jsr305Settings = Jsr305Settings.this;
                createListBuilder = CollectionsKt__CollectionsJVMKt.createListBuilder();
                createListBuilder.add(jsr305Settings.getGlobalLevel().getDescription());
                ReportLevel migrationLevel = jsr305Settings.getMigrationLevel();
                if (migrationLevel != null) {
                    createListBuilder.add("under-migration:" + migrationLevel.getDescription());
                }
                for (Map.Entry<FqName, ReportLevel> entry : jsr305Settings.getUserDefinedLevelForSpecificAnnotation().entrySet()) {
                    createListBuilder.add('@' + entry.getKey() + ':' + entry.getValue().getDescription());
                }
                build = CollectionsKt__CollectionsJVMKt.build(createListBuilder);
                Object[] array = build.toArray(new String[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                return (String[]) array;
            }
        });
        this.description$delegate = lazy;
        ReportLevel reportLevel2 = ReportLevel.IGNORE;
        this.isDisabled = globalLevel == reportLevel2 && reportLevel == reportLevel2 && userDefinedLevelForSpecificAnnotation.isEmpty();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Jsr305Settings)) {
            return false;
        }
        Jsr305Settings jsr305Settings = (Jsr305Settings) obj;
        if (this.globalLevel == jsr305Settings.globalLevel && this.migrationLevel == jsr305Settings.migrationLevel && Intrinsics.areEqual(this.userDefinedLevelForSpecificAnnotation, jsr305Settings.userDefinedLevelForSpecificAnnotation)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final ReportLevel getGlobalLevel() {
        return this.globalLevel;
    }

    @Nullable
    public final ReportLevel getMigrationLevel() {
        return this.migrationLevel;
    }

    @NotNull
    public final Map<FqName, ReportLevel> getUserDefinedLevelForSpecificAnnotation() {
        return this.userDefinedLevelForSpecificAnnotation;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = this.globalLevel.hashCode() * 31;
        ReportLevel reportLevel = this.migrationLevel;
        if (reportLevel == null) {
            hashCode = 0;
        } else {
            hashCode = reportLevel.hashCode();
        }
        return ((hashCode2 + hashCode) * 31) + this.userDefinedLevelForSpecificAnnotation.hashCode();
    }

    public final boolean isDisabled() {
        return this.isDisabled;
    }

    @NotNull
    public String toString() {
        return "Jsr305Settings(globalLevel=" + this.globalLevel + ", migrationLevel=" + this.migrationLevel + ", userDefinedLevelForSpecificAnnotation=" + this.userDefinedLevelForSpecificAnnotation + ')';
    }

    public /* synthetic */ Jsr305Settings(ReportLevel reportLevel, ReportLevel reportLevel2, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(reportLevel, (i3 & 2) != 0 ? null : reportLevel2, (i3 & 4) != 0 ? MapsKt__MapsKt.emptyMap() : map);
    }
}
