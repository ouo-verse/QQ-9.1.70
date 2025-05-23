package com.tencent.mobileqq.gamecenter.nt.aio.bottom;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/nt/aio/bottom/GameMallArkContainer;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class GameMallArkContainer extends RelativeLayout {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameMallArkContainer(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@Nullable MotionEvent ev5) {
        Integer num;
        ViewParent parent;
        if (ev5 != null) {
            num = Integer.valueOf(ev5.getAction());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 0) {
            ViewParent parent2 = getParent();
            if (parent2 != null) {
                parent2.requestDisallowInterceptTouchEvent(true);
            }
        } else if (num != null && num.intValue() == 1 && (parent = getParent()) != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(ev5);
    }
}
