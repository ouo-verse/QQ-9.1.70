package com.tencent.aelight.camera.ae.flashshow.util;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/util/u;", "", "", "msg", "", "duration", "", "a", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public static final u f65126a = new u();

    u() {
    }

    public final void a(String msg2, int duration) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#80000000"));
        gradientDrawable.setCornerRadius(ViewUtils.dpToPx(8.0f));
        gradientDrawable.setShape(0);
        int dip2px = ViewUtils.dip2px(12.0f);
        TextView textView = new TextView(MobileQQ.sMobileQQ);
        textView.setBackground(gradientDrawable);
        textView.setTextSize(2, 14.0f);
        textView.setPadding(dip2px, dip2px, dip2px, dip2px);
        textView.setLines(1);
        textView.setTextColor(-1);
        textView.setText(msg2);
        Toast toast = new Toast(MobileQQ.sMobileQQ);
        toast.setView(textView);
        toast.setDuration(duration);
        toast.setGravity(17, 0, 0);
        toast.show();
    }
}
