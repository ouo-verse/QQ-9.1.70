package com.tencent.mobileqq.aio.input.dialog;

import android.text.Spanned;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J\b\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&J(\u0010\u000f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH&J0\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH&J(\u0010\u0013\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH&J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H&J\b\u0010\u0016\u001a\u00020\u0015H&\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/aio/input/dialog/a;", "", "", "", "g", "", "f", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "c", "Landroid/text/Spanned;", "spannedChars", "", "selectionStart", "lineCount", "a", "traceId", "", "b", "e", "d", "", "getTag", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public interface a {
    boolean a(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull Spanned spannedChars, int selectionStart, int lineCount);

    void b(int traceId, @NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull Spanned spannedChars, int selectionStart, int lineCount);

    boolean c(@NotNull com.tencent.aio.api.runtime.a aioContext);

    void d(int traceId, @NotNull com.tencent.aio.api.runtime.a aioContext);

    boolean e(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull Spanned spannedChars, int selectionStart, int lineCount);

    boolean f();

    @NotNull
    List<Character> g();

    @NotNull
    String getTag();
}
