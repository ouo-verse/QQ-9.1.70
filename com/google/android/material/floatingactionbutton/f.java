package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import androidx.annotation.AnimatorRes;
import androidx.annotation.Nullable;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import java.util.List;
import x0.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public interface f {
    boolean a();

    @AnimatorRes
    int b();

    void c(@Nullable ExtendedFloatingActionButton.j jVar);

    AnimatorSet d();

    void e();

    void f(@Nullable h hVar);

    List<Animator.AnimatorListener> getListeners();

    void onAnimationCancel();

    void onAnimationEnd();

    void onAnimationStart(Animator animator);
}
