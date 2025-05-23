package com.tencent.mobileqq.qqecommerce.biz.kuikly.container;

import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/c;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
final class c extends FrameLayout {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setFocusableInTouchMode(true);
        requestFocus();
        setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.container.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean c16;
                c16 = c.c(view, motionEvent);
                return c16;
            }
        });
        setOnKeyListener(new View.OnKeyListener() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.container.b
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i3, KeyEvent keyEvent) {
                boolean d16;
                d16 = c.d(view, i3, keyEvent);
                return d16;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(View view, int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            return true;
        }
        return false;
    }
}
