package nn4;

import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u00a8\u0006\u0004"}, d2 = {"", "targetVer", "", "a", "timi-game-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b {
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0049 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final int a(@NotNull String str, @NotNull String targetVer) {
        int coerceAtLeast;
        int parseInt;
        int parseInt2;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(targetVer, "targetVer");
        Pattern compile = Pattern.compile("\\.");
        String[] split = compile.split(str);
        Intrinsics.checkNotNullExpressionValue(split, "p.split(this)");
        String[] split2 = compile.split(targetVer);
        Intrinsics.checkNotNullExpressionValue(split2, "p.split(targetVer)");
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(split.length, split2.length);
        for (int i3 = 0; i3 < coerceAtLeast; i3++) {
            if (i3 < split.length) {
                try {
                    parseInt = Integer.parseInt(split[i3]);
                } catch (Exception unused) {
                }
                if (i3 < split2.length) {
                    try {
                        parseInt2 = Integer.parseInt(split2[i3]);
                    } catch (Exception unused2) {
                    }
                    if (parseInt < parseInt2) {
                        return -1;
                    }
                    if (parseInt > parseInt2) {
                        return 1;
                    }
                }
                parseInt2 = 0;
                if (parseInt < parseInt2) {
                }
            }
            parseInt = 0;
            if (i3 < split2.length) {
            }
            parseInt2 = 0;
            if (parseInt < parseInt2) {
            }
        }
        return 0;
    }
}
