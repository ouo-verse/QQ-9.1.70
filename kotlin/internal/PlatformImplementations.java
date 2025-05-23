package kotlin.internal;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.lang.reflect.Method;
import java.util.List;
import java.util.regex.MatchResult;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.FallbackThreadLocalRandom;
import kotlin.random.Random;
import kotlin.text.MatchGroup;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0012B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u0013"}, d2 = {"Lkotlin/internal/PlatformImplementations;", "", "()V", "addSuppressed", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "", "exception", "defaultPlatformRandom", "Lkotlin/random/Random;", "getMatchResultNamedGroup", "Lkotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", "name", "", "getSuppressed", "", "ReflectThrowable", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public class PlatformImplementations {

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c2\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lkotlin/internal/PlatformImplementations$ReflectThrowable;", "", "()V", "addSuppressed", "Ljava/lang/reflect/Method;", "getSuppressed", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static final class ReflectThrowable {

        @NotNull
        public static final ReflectThrowable INSTANCE = new ReflectThrowable();

        @JvmField
        @Nullable
        public static final Method addSuppressed;

        @JvmField
        @Nullable
        public static final Method getSuppressed;

        /* JADX WARN: Removed duplicated region for block: B:10:0x0042 A[LOOP:0: B:2:0x0016->B:10:0x0042, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0046 A[EDGE_INSN: B:11:0x0046->B:12:0x0046 BREAK  A[LOOP:0: B:2:0x0016->B:10:0x0042], SYNTHETIC] */
        static {
            Method method;
            Method method2;
            boolean z16;
            Object singleOrNull;
            Method[] throwableMethods = Throwable.class.getMethods();
            Intrinsics.checkNotNullExpressionValue(throwableMethods, "throwableMethods");
            int length = throwableMethods.length;
            int i3 = 0;
            int i16 = 0;
            while (true) {
                method = null;
                if (i16 < length) {
                    method2 = throwableMethods[i16];
                    if (Intrinsics.areEqual(method2.getName(), "addSuppressed")) {
                        Class<?>[] parameterTypes = method2.getParameterTypes();
                        Intrinsics.checkNotNullExpressionValue(parameterTypes, "it.parameterTypes");
                        singleOrNull = ArraysKt___ArraysKt.singleOrNull(parameterTypes);
                        if (Intrinsics.areEqual(singleOrNull, Throwable.class)) {
                            z16 = true;
                            if (!z16) {
                                break;
                            } else {
                                i16++;
                            }
                        }
                    }
                    z16 = false;
                    if (!z16) {
                    }
                } else {
                    method2 = null;
                    break;
                }
            }
            addSuppressed = method2;
            int length2 = throwableMethods.length;
            while (true) {
                if (i3 >= length2) {
                    break;
                }
                Method method3 = throwableMethods[i3];
                if (Intrinsics.areEqual(method3.getName(), "getSuppressed")) {
                    method = method3;
                    break;
                }
                i3++;
            }
            getSuppressed = method;
        }

        ReflectThrowable() {
        }
    }

    public void addSuppressed(@NotNull Throwable cause, @NotNull Throwable exception) {
        Intrinsics.checkNotNullParameter(cause, "cause");
        Intrinsics.checkNotNullParameter(exception, "exception");
        Method method = ReflectThrowable.addSuppressed;
        if (method != null) {
            method.invoke(cause, exception);
        }
    }

    @NotNull
    public Random defaultPlatformRandom() {
        return new FallbackThreadLocalRandom();
    }

    @Nullable
    public MatchGroup getMatchResultNamedGroup(@NotNull MatchResult matchResult, @NotNull String name) {
        Intrinsics.checkNotNullParameter(matchResult, "matchResult");
        Intrinsics.checkNotNullParameter(name, "name");
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0013, code lost:
    
        r3 = kotlin.collections.ArraysKt___ArraysJvmKt.asList((java.lang.Throwable[]) r3);
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<Throwable> getSuppressed(@NotNull Throwable exception) {
        List<Throwable> emptyList;
        List<Throwable> asList;
        Intrinsics.checkNotNullParameter(exception, "exception");
        Method method = ReflectThrowable.getSuppressed;
        if (method == null || (r3 = method.invoke(exception, new Object[0])) == null || asList == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return asList;
    }
}
