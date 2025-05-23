package com.tencent.aio.widget.textView.creator;

import android.content.Context;
import android.graphics.Typeface;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0004J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/aio/widget/textView/creator/f;", "", "Lcom/tencent/aio/widget/textView/creator/f$a;", "e", "a", "simple-textView_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public interface f {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/aio/widget/textView/creator/f$a;", "", "", "assetPath", "Landroid/content/Context;", "context", "Landroid/graphics/Typeface;", "a", "simple-textView_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public interface a {
        @Nullable
        Typeface a(@Nullable String assetPath, @NotNull Context context);
    }

    @NotNull
    a e();
}
