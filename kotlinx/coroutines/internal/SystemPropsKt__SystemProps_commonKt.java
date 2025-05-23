package kotlinx.coroutines.internal;

import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a,\u0010\u0000\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\u0000\u001a,\u0010\u0000\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\b2\b\b\u0002\u0010\u0006\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000\u00a8\u0006\t"}, d2 = {"systemProp", "", "propertyName", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "", "minValue", "maxValue", "", "kotlinx-coroutines-core"}, k = 5, mv = {1, 5, 1}, xi = 48, xs = "kotlinx/coroutines/internal/SystemPropsKt")
/* loaded from: classes28.dex */
public final /* synthetic */ class SystemPropsKt__SystemProps_commonKt {
    public static final boolean systemProp(@NotNull String str, boolean z16) {
        String systemProp = SystemPropsKt.systemProp(str);
        return systemProp == null ? z16 : Boolean.parseBoolean(systemProp);
    }

    public static /* synthetic */ int systemProp$default(String str, int i3, int i16, int i17, int i18, Object obj) {
        if ((i18 & 4) != 0) {
            i16 = 1;
        }
        if ((i18 & 8) != 0) {
            i17 = Integer.MAX_VALUE;
        }
        return SystemPropsKt.systemProp(str, i3, i16, i17);
    }

    public static final int systemProp(@NotNull String str, int i3, int i16, int i17) {
        return (int) SystemPropsKt.systemProp(str, i3, i16, i17);
    }

    public static /* synthetic */ long systemProp$default(String str, long j3, long j16, long j17, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            j16 = 1;
        }
        long j18 = j16;
        if ((i3 & 8) != 0) {
            j17 = Long.MAX_VALUE;
        }
        return SystemPropsKt.systemProp(str, j3, j18, j17);
    }

    public static final long systemProp(@NotNull String str, long j3, long j16, long j17) {
        Long longOrNull;
        String systemProp = SystemPropsKt.systemProp(str);
        if (systemProp == null) {
            return j3;
        }
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(systemProp);
        if (longOrNull == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + systemProp + '\'').toString());
        }
        long longValue = longOrNull.longValue();
        boolean z16 = false;
        if (j16 <= longValue && longValue <= j17) {
            z16 = true;
        }
        if (z16) {
            return longValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j16 + ".." + j17 + ", but is '" + longValue + '\'').toString());
    }
}
