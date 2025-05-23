package com.tencent.mobileqq.guild.feed.util;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.tencent.luggage.wxa.gh.e;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\u0004\b\u001f\u0010 J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR#\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\t\u0010\u0012R#\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0012R\u001c\u0010\u001b\u001a\n \u0018*\u0004\u0018\u00010\u00170\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/util/c;", "Landroid/view/View$OnTouchListener;", "Landroid/view/View;", "view", "Landroid/view/MotionEvent;", "event", "", "onTouch", "", "d", "J", "b", "()J", "longPressDuration", "Lkotlin/Function1;", "", "e", "Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function1;", e.a.NAME, "f", "c", NodeProps.ON_CLICK, "Landroid/os/Handler;", "kotlin.jvm.PlatformType", tl.h.F, "Landroid/os/Handler;", "handler", "i", "Z", "isLongPressed", "<init>", "(JLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c implements View.OnTouchListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long longPressDuration;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<View, Unit> onLongPress;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<View, Unit> onClick;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Handler handler;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isLongPressed;

    /* JADX WARN: Multi-variable type inference failed */
    public c(long j3, @NotNull Function1<? super View, Unit> onLongPress, @NotNull Function1<? super View, Unit> onClick) {
        Intrinsics.checkNotNullParameter(onLongPress, "onLongPress");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.longPressDuration = j3;
        this.onLongPress = onLongPress;
        this.onClick = onClick;
        this.handler = ThreadManagerV2.getUIHandlerV2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(c this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isLongPressed = true;
        if (view != null) {
            view.performHapticFeedback(5);
            ViewCompat.replaceAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_LONG_CLICK, null, null);
            this$0.onLongPress.invoke(view);
        }
    }

    /* renamed from: b, reason: from getter */
    public final long getLongPressDuration() {
        return this.longPressDuration;
    }

    @NotNull
    public final Function1<View, Unit> c() {
        return this.onClick;
    }

    @NotNull
    public final Function1<View, Unit> d() {
        return this.onLongPress;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@Nullable final View view, @Nullable MotionEvent event) {
        Integer num;
        if (event != null) {
            num = Integer.valueOf(event.getAction());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 0) {
            this.isLongPressed = false;
            if (view != null) {
                view.setPressed(true);
            }
            this.handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.util.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.e(c.this, view);
                }
            }, this.longPressDuration);
        } else if (num != null && num.intValue() == 1) {
            this.handler.removeCallbacksAndMessages(null);
            if (view != null) {
                view.setPressed(false);
            }
            if (!this.isLongPressed && view != null) {
                this.onClick.invoke(view);
            }
        } else if (num != null && num.intValue() == 3) {
            this.handler.removeCallbacksAndMessages(null);
            if (view != null) {
                view.setPressed(false);
            }
        }
        return true;
    }
}
