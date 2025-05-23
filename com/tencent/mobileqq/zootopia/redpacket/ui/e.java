package com.tencent.mobileqq.zootopia.redpacket.ui;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.RotateAnimation;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \b2\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/zootopia/redpacket/ui/e;", "Landroid/app/Dialog;", "Landroid/content/Context;", "context", "", "a", "<init>", "(Landroid/content/Context;)V", "d", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class e extends Dialog {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context) {
        super(context, R.style.f174248g8);
        Intrinsics.checkNotNullParameter(context, "context");
        a(context);
    }

    private final void a(Context context) {
        super.requestWindowFeature(1);
        setContentView(LayoutInflater.from(context).inflate(R.layout.f167427d91, (ViewGroup) null, false));
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.color.f81668);
        }
        View findViewById = findViewById(R.id.q6e);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(500L);
        rotateAnimation.setRepeatCount(-1);
        findViewById.setAnimation(rotateAnimation);
        rotateAnimation.start();
    }
}
