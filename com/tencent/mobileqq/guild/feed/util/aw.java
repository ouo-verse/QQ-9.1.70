package com.tencent.mobileqq.guild.feed.util;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.MotionEvent;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u001a\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/util/aw;", "", "", "bgColor", "", "radius", "Landroid/graphics/drawable/Drawable;", "a", "Landroid/view/View;", "targetView", "Landroid/view/MotionEvent;", "event", "", "b", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class aw {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final aw f223853a = new aw();

    aw() {
    }

    @JvmStatic
    @NotNull
    public static final Drawable a(int bgColor, float radius) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(bgColor);
        gradientDrawable.setCornerRadius(e.a(MobileQQ.sMobileQQ, radius));
        return gradientDrawable;
    }

    public final boolean b(@Nullable View targetView, @Nullable MotionEvent event) {
        boolean z16;
        if (targetView == null || event == null) {
            return false;
        }
        int rawY = (int) event.getRawY();
        int rawX = (int) event.getRawX();
        int[] iArr = new int[2];
        targetView.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i16 = iArr[1];
        int measuredWidth = targetView.getMeasuredWidth() + i3;
        int measuredHeight = targetView.getMeasuredHeight() + i16;
        if (i16 <= rawY && rawY <= measuredHeight) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 || rawX < i3 || rawX > measuredWidth) {
            return false;
        }
        return true;
    }
}
