package com.tencent.rdelivery.reshub.processor;

import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\n\u0010\u0001\u001a\u00020\u0000*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0002*\u00020\u0000\u001a\n\u0010\u0006\u001a\u00020\u0005*\u00020\u0000\u00a8\u0006\u0007"}, d2 = {"", "a", "", "c", "b", "", "d", "reshub_debug"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class p {
    @NotNull
    public static final String a(@NotNull String getUnzippingMarkFileName) {
        String trimEnd;
        Intrinsics.checkParameterIsNotNull(getUnzippingMarkFileName, "$this$getUnzippingMarkFileName");
        StringBuilder sb5 = new StringBuilder();
        trimEnd = StringsKt__StringsKt.trimEnd(getUnzippingMarkFileName, File.separatorChar);
        sb5.append(trimEnd);
        sb5.append("_unzipping_flag");
        return sb5.toString();
    }

    public static final void b(@NotNull String markFinishUnzipping) {
        Intrinsics.checkParameterIsNotNull(markFinishUnzipping, "$this$markFinishUnzipping");
        jz3.c.g(a(markFinishUnzipping), true);
    }

    public static final void c(@NotNull String markStartUnzipping) {
        Object m476constructorimpl;
        Intrinsics.checkParameterIsNotNull(markStartUnzipping, "$this$markStartUnzipping");
        String a16 = a(markStartUnzipping);
        try {
            Result.Companion companion = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(jz3.c.n(a16));
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            jz3.d.d("Unzip", "markStartUnzipping path = " + markStartUnzipping + " Exception: ", m479exceptionOrNullimpl);
        }
    }

    public static final boolean d(@NotNull String wasUnzipInterrupted) {
        Intrinsics.checkParameterIsNotNull(wasUnzipInterrupted, "$this$wasUnzipInterrupted");
        boolean exists = new File(a(wasUnzipInterrupted)).exists();
        if (exists) {
            jz3.d.e("Unzip", "wasUnzipInterrupted path = " + wasUnzipInterrupted + TokenParser.SP);
        }
        return exists;
    }
}
