package com.tencent.mobileqq.troop.troopsquare.home;

import android.view.MotionEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J(\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/home/d;", "", "Landroid/view/MotionEvent;", "startEvent", "nowEvent", "", "a", "", "velocityX", "velocityY", "c", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public interface d {
    boolean a(@NotNull MotionEvent startEvent, @NotNull MotionEvent nowEvent);

    boolean c(@NotNull MotionEvent startEvent, @NotNull MotionEvent nowEvent, float velocityX, float velocityY);
}
