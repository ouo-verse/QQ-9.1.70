package com.tencent.guild.aio.halfpop.menu.debug;

import android.content.Context;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/guild/aio/halfpop/menu/debug/DebugLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dispatchKeyEvent", "", "event", "Landroid/view/KeyEvent;", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class DebugLayout extends FrameLayout {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(@Nullable KeyEvent event) {
        boolean z16 = false;
        if (event != null && event.getKeyCode() == 4) {
            z16 = true;
        }
        if (z16) {
            setVisibility(8);
            return true;
        }
        return super.dispatchKeyEvent(event);
    }
}
