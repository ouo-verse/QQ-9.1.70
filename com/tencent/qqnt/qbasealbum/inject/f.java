package com.tencent.qqnt.qbasealbum.inject;

import android.content.Context;
import android.widget.Toast;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/inject/f;", "", "Landroid/content/Context;", "context", "", "msg", "", "duration", "", UIJsPlugin.EVENT_SHOW_TOAST, "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public interface f {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class a {
        public static void a(@NotNull f fVar, @NotNull Context context, @Nullable CharSequence charSequence, int i3) {
            Intrinsics.checkNotNullParameter(context, "context");
            Toast.makeText(context, charSequence, i3).show();
        }
    }

    void showToast(@NotNull Context context, @Nullable CharSequence msg2, int duration);
}
