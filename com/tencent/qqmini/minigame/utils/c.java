package com.tencent.qqmini.minigame.utils;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ5\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0005\"\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqmini/minigame/utils/c;", "", "", "format", "defaultString", "", "args", "a", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "<init>", "()V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f346835a = new c();

    c() {
    }

    @NotNull
    public final String a(@NotNull String format, @NotNull String defaultString, @NotNull Object... args) {
        Intrinsics.checkParameterIsNotNull(format, "format");
        Intrinsics.checkParameterIsNotNull(defaultString, "defaultString");
        Intrinsics.checkParameterIsNotNull(args, "args");
        try {
            String format2 = String.format(format, Arrays.copyOf(args, args.length));
            Intrinsics.checkExpressionValueIsNotNull(format2, "java.lang.String.format(format, *args)");
            return format2;
        } catch (Exception e16) {
            QMLog.e("StringFormatUtils", "safeFormat error txt:" + format + ", ", e16);
            return defaultString;
        }
    }
}
