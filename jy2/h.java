package jy2;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Ljy2/h;", "", "", "millis", "", "a", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f411172a = new h();

    h() {
    }

    @NotNull
    public final String a(long millis) {
        int i3 = ((int) millis) / 1000;
        int i16 = i3 % 60;
        int i17 = (i3 / 60) % 60;
        int i18 = i3 / 3600;
        if (i18 > 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i18), Integer.valueOf(i17), Integer.valueOf(i16)}, 3));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String format2 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i17), Integer.valueOf(i16)}, 2));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        return format2;
    }
}
