package com.tencent.ecommerce.biz.util;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"com/tencent/ecommerce/biz/util/ECViewUtilKt$setOnVeryLongClickListener$1", "Landroid/view/View$OnTouchListener;", "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", "event", "", "onTouch", "", "d", "J", "longClickDuration", "Landroid/os/Handler;", "e", "Landroid/os/Handler;", "handler", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECViewUtilKt$setOnVeryLongClickListener$1 implements View.OnTouchListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long longClickDuration = 3000;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Handler handler = new Handler(Looper.getMainLooper());

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function0 f104863f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECViewUtilKt$setOnVeryLongClickListener$1(Function0 function0) {
        this.f104863f = function0;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v3, MotionEvent event) {
        if (event != null && event.getAction() == 0) {
            this.handler.postDelayed(new Runnable() { // from class: com.tencent.ecommerce.biz.util.ECViewUtilKt$setOnVeryLongClickListener$1$onTouch$1
                @Override // java.lang.Runnable
                public final void run() {
                    ECViewUtilKt$setOnVeryLongClickListener$1.this.f104863f.invoke();
                }
            }, this.longClickDuration);
        } else if (event != null && event.getAction() == 1) {
            this.handler.removeCallbacksAndMessages(null);
        }
        return true;
    }
}
