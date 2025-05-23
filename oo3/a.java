package oo3;

import android.animation.Animator;
import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes22.dex */
class a implements Animator.AnimatorListener {

    /* renamed from: d, reason: collision with root package name */
    private c f423259d;

    public a(@NonNull c cVar) {
        this.f423259d = cVar;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        QLog.i("AnimatorImpl", 1, "onAnimationEnd");
        this.f423259d.onAnimationEnd();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }
}
