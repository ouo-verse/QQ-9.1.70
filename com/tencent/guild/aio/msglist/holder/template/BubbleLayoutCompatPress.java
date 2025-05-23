package com.tencent.guild.aio.msglist.holder.template;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.guild.aio.msglist.holder.template.BubbleLayoutCompatPress;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rB\u001b\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\f\u0010\u0010J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/template/BubbleLayoutCompatPress;", "Landroid/widget/LinearLayout;", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "Ljava/lang/Runnable;", "d", "Ljava/lang/Runnable;", "longPressRunnable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class BubbleLayoutCompatPress extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable longPressRunnable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleLayoutCompatPress(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.longPressRunnable = new Runnable() { // from class: eq0.a
            @Override // java.lang.Runnable
            public final void run() {
                BubbleLayoutCompatPress.b(BubbleLayoutCompatPress.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(BubbleLayoutCompatPress this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        long uptimeMillis = SystemClock.uptimeMillis();
        this$0.dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
        this$0.performLongClick();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@Nullable MotionEvent ev5) {
        Integer num;
        Handler handler;
        if (ev5 != null) {
            num = Integer.valueOf(ev5.getAction());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 0) {
            Handler handler2 = getHandler();
            if (handler2 != null) {
                handler2.postDelayed(this.longPressRunnable, ViewConfiguration.getLongPressTimeout());
            }
        } else {
            boolean z16 = true;
            if ((num == null || num.intValue() != 1) && (num == null || num.intValue() != 3)) {
                z16 = false;
            }
            if (z16 && (handler = getHandler()) != null) {
                handler.removeCallbacks(this.longPressRunnable);
            }
        }
        return super.dispatchTouchEvent(ev5);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleLayoutCompatPress(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.longPressRunnable = new Runnable() { // from class: eq0.a
            @Override // java.lang.Runnable
            public final void run() {
                BubbleLayoutCompatPress.b(BubbleLayoutCompatPress.this);
            }
        };
    }
}
