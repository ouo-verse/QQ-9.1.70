package com.tencent.ecommerce.biz.util;

import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import androidx.constraintlayout.widget.Group;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u001a\u0010\u0004\u001a\u00020\u0002*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0007\u001a\n\u0010\u0005\u001a\u00020\u0002*\u00020\u0000\u001a\u0018\u0010\n\u001a\u00020\u0002*\u00020\u00062\f\b\u0001\u0010\t\u001a\u00020\u0007\"\u00020\b\u00a8\u0006\u000b"}, d2 = {"Landroid/view/View;", "Lkotlin/Function0;", "", "listener", "a", "c", "Landroidx/constraintlayout/widget/Group;", "", "", "ids", "b", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECViewUtilKt {
    public static final void a(View view, Function0<Unit> function0) {
        view.setOnTouchListener(new ECViewUtilKt$setOnVeryLongClickListener$1(function0));
    }

    public static final void b(Group group, int... iArr) {
        group.setReferencedIds(iArr);
        group.setVisibility(group.getVisibility());
    }

    public static final void c(View view) {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(1000L);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setFillAfter(true);
        Unit unit = Unit.INSTANCE;
        view.startAnimation(rotateAnimation);
    }
}
