package com.tencent.kuikly.core.render.android.expand;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.kuikly.core.render.android.b;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.kuikly.core.render.android.performace.KRMonitorType;
import com.tencent.kuikly.core.render.android.performace.c;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u0011\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001fH\u0016J \u0010&\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\tH\u0016J$\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00102\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010%\u001a\u00020\tH\u0016J\u0016\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0001\u0018\u00010)H\u0016J\b\u0010+\u001a\u00020\u0010H\u0016J\b\u0010,\u001a\u00020\u0010H\u0016J\b\u0010-\u001a\u00020\u0010H\u0016\u00a8\u0006."}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/a;", "", "Lcom/tencent/kuikly/core/render/android/b;", "kuiklyRenderExport", "", "registerExternalRenderView", "registerExternalModule", "Ff", "registerViewExternalPropHandler", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "C2", "", "Lcom/tencent/kuikly/core/render/android/performace/KRMonitorType;", "ec", "p9", "Sa", "", "h4", "", "V0", "c1", "", "K0", "()Ljava/lang/Long;", "ng", "", "Re", "()Ljava/lang/Integer;", "Lj01/a;", "data", "pg", "Lcom/tencent/kuikly/core/render/android/performace/c;", "le", "", "throwable", "Lcom/tencent/kuikly/core/render/android/exception/ErrorReason;", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "executeMode", "Ia", "isSucceed", "onPageLoadComplete", "", "O1", "Cc", "M0", "u0", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public interface a {
    @NotNull
    KuiklyRenderCoreExecuteMode C2();

    boolean Cc();

    void Ff(@NotNull b kuiklyRenderExport);

    void Ia(@NotNull Throwable throwable, @NotNull ErrorReason errorReason, @NotNull KuiklyRenderCoreExecuteMode executeMode);

    @Nullable
    Long K0();

    boolean M0();

    @Nullable
    Map<String, Object> O1();

    @Nullable
    Integer Re();

    void Sa();

    @Nullable
    String V0();

    boolean c1();

    @NotNull
    List<KRMonitorType> ec();

    boolean h4();

    void le(@NotNull c data);

    boolean ng();

    void onPageLoadComplete(boolean isSucceed, @Nullable ErrorReason errorReason, @NotNull KuiklyRenderCoreExecuteMode executeMode);

    void p9();

    void pg(@NotNull j01.a data);

    void registerExternalModule(@NotNull b kuiklyRenderExport);

    void registerExternalRenderView(@NotNull b kuiklyRenderExport);

    void registerViewExternalPropHandler(@NotNull b kuiklyRenderExport);

    boolean u0();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.expand.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C5872a {
        @NotNull
        public static KuiklyRenderCoreExecuteMode a(@NotNull a aVar) {
            return KuiklyRenderCoreExecuteMode.JVM;
        }

        public static boolean b(@NotNull a aVar) {
            return false;
        }

        public static boolean c(@NotNull a aVar) {
            return true;
        }

        @Nullable
        public static Map<String, Object> d(@NotNull a aVar) {
            return null;
        }

        public static boolean e(@NotNull a aVar) {
            return false;
        }

        public static boolean f(@NotNull a aVar) {
            return false;
        }

        public static void g(@NotNull a aVar, @NotNull j01.a data) {
            Intrinsics.checkNotNullParameter(data, "data");
        }

        public static void h(@NotNull a aVar, @NotNull c data) {
            Intrinsics.checkNotNullParameter(data, "data");
        }

        public static void k(@NotNull a aVar, boolean z16, @Nullable ErrorReason errorReason, @NotNull KuiklyRenderCoreExecuteMode executeMode) {
            Intrinsics.checkNotNullParameter(executeMode, "executeMode");
        }

        public static /* synthetic */ void l(a aVar, boolean z16, ErrorReason errorReason, KuiklyRenderCoreExecuteMode kuiklyRenderCoreExecuteMode, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    errorReason = null;
                }
                aVar.onPageLoadComplete(z16, errorReason, kuiklyRenderCoreExecuteMode);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onPageLoadComplete");
        }

        public static void m(@NotNull a aVar, @NotNull Throwable throwable, @NotNull ErrorReason errorReason, @NotNull KuiklyRenderCoreExecuteMode executeMode) {
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            Intrinsics.checkNotNullParameter(errorReason, "errorReason");
            Intrinsics.checkNotNullParameter(executeMode, "executeMode");
        }

        @NotNull
        public static List<KRMonitorType> n(@NotNull a aVar) {
            List<KRMonitorType> listOf;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(KRMonitorType.LAUNCH);
            return listOf;
        }

        public static void o(@NotNull a aVar, @NotNull b kuiklyRenderExport) {
            Intrinsics.checkNotNullParameter(kuiklyRenderExport, "kuiklyRenderExport");
        }

        public static void p(@NotNull a aVar, @NotNull b kuiklyRenderExport) {
            Intrinsics.checkNotNullParameter(kuiklyRenderExport, "kuiklyRenderExport");
        }

        public static void q(@NotNull a aVar, @NotNull b kuiklyRenderExport) {
            Intrinsics.checkNotNullParameter(kuiklyRenderExport, "kuiklyRenderExport");
        }

        public static void r(@NotNull a aVar, @NotNull b kuiklyRenderExport) {
            Intrinsics.checkNotNullParameter(kuiklyRenderExport, "kuiklyRenderExport");
        }

        @Nullable
        public static Integer s(@NotNull a aVar) {
            return 48;
        }

        @Nullable
        public static Long t(@NotNull a aVar) {
            return null;
        }

        public static boolean u(@NotNull a aVar) {
            return true;
        }

        @Nullable
        public static String v(@NotNull a aVar) {
            return null;
        }

        public static boolean w(@NotNull a aVar) {
            return false;
        }

        public static void i(@NotNull a aVar) {
        }

        public static void j(@NotNull a aVar) {
        }
    }
}
