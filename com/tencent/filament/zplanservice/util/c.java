package com.tencent.filament.zplanservice.util;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a\n\u0010\u0001\u001a\u00020\u0000*\u00020\u0000\u001a\n\u0010\u0002\u001a\u00020\u0000*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0000*\u00020\u0000\u001a\u0012\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0000\u00a8\u0006\u0006"}, d2 = {"", "a", "b", "c", "path", "d", "zplan-service_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class c {
    @NotNull
    public static final String a(@NotNull String basename) {
        String substringAfterLast$default;
        Intrinsics.checkNotNullParameter(basename, "$this$basename");
        String str = File.separator;
        Intrinsics.checkNotNullExpressionValue(str, "File.separator");
        substringAfterLast$default = StringsKt__StringsKt.substringAfterLast$default(basename, str, (String) null, 2, (Object) null);
        return substringAfterLast$default;
    }

    @NotNull
    public static final String b(@NotNull String dirname) {
        boolean endsWith$default;
        String substringBeforeLast$default;
        String substringBeforeLast$default2;
        String substringBeforeLast$default3;
        Intrinsics.checkNotNullParameter(dirname, "$this$dirname");
        String str = File.separator;
        Intrinsics.checkNotNullExpressionValue(str, "File.separator");
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(dirname, str, false, 2, null);
        if (endsWith$default) {
            Intrinsics.checkNotNullExpressionValue(str, "File.separator");
            substringBeforeLast$default2 = StringsKt__StringsKt.substringBeforeLast$default(dirname, str, (String) null, 2, (Object) null);
            Intrinsics.checkNotNullExpressionValue(str, "File.separator");
            substringBeforeLast$default3 = StringsKt__StringsKt.substringBeforeLast$default(substringBeforeLast$default2, str, (String) null, 2, (Object) null);
            return substringBeforeLast$default3;
        }
        Intrinsics.checkNotNullExpressionValue(str, "File.separator");
        substringBeforeLast$default = StringsKt__StringsKt.substringBeforeLast$default(dirname, str, (String) null, 2, (Object) null);
        return substringBeforeLast$default;
    }

    @NotNull
    public static final String c(@NotNull String filename) {
        String substringBeforeLast$default;
        Intrinsics.checkNotNullParameter(filename, "$this$filename");
        substringBeforeLast$default = StringsKt__StringsKt.substringBeforeLast$default(a(filename), ".", (String) null, 2, (Object) null);
        return substringBeforeLast$default;
    }

    @NotNull
    public static final String d(@NotNull String pathAppend, @NotNull String path) {
        boolean endsWith$default;
        Intrinsics.checkNotNullParameter(pathAppend, "$this$pathAppend");
        Intrinsics.checkNotNullParameter(path, "path");
        endsWith$default = StringsKt__StringsKt.endsWith$default((CharSequence) pathAppend, File.separatorChar, false, 2, (Object) null);
        if (endsWith$default) {
            return pathAppend + path;
        }
        return pathAppend + File.separatorChar + path;
    }
}
