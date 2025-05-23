package com.tencent.qcircle.tavcut.view.ext;

import android.view.MotionEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qcircle/tavcut/view/ext/OnSingleFlingListener;", "", "onFling", "", "e1", "Landroid/view/MotionEvent;", "e2", "velocityX", "", "velocityY", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public interface OnSingleFlingListener {
    boolean onFling(@Nullable MotionEvent e16, @Nullable MotionEvent e26, float velocityX, float velocityY);
}
