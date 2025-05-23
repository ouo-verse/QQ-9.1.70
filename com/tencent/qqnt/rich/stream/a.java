package com.tencent.qqnt.rich.stream;

import android.widget.TextView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0002H&J\b\u0010\t\u001a\u00020\bH&J\u001a\u0010\u000e\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH&J\"\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\fH&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/rich/stream/a;", "", "", "start", "pause", "cancel", "end", "b", "", "isStarted", "Landroid/widget/TextView;", "textView", "", "content", "c", "", "showedLength", "newContent", "a", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public interface a {
    void a(int showedLength, @Nullable TextView textView, @NotNull CharSequence newContent);

    void b();

    void c(@Nullable TextView textView, @NotNull CharSequence content);

    void cancel();

    void end();

    boolean isStarted();

    void pause();

    void start();
}
