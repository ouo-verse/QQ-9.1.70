package com.tencent.mobileqq.guild.animate.subchannellist;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<RecyclerView.ViewHolder> f214316a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private final b f214317b;

    /* renamed from: c, reason: collision with root package name */
    private final TimeInterpolator f214318c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.animate.subchannellist.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public class C7672a extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RecyclerView.ViewHolder f214319d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f214320e;

        C7672a(RecyclerView.ViewHolder viewHolder, ViewPropertyAnimator viewPropertyAnimator) {
            this.f214319d = viewHolder;
            this.f214320e = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f214319d.itemView.setAlpha(1.0f);
            this.f214319d.itemView.setTranslationY(0.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f214320e.setListener(null);
            a.this.f214317b.c(this.f214319d);
            a.this.f214316a.remove(this.f214319d);
            a.this.f214317b.a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a.this.f214317b.b(this.f214319d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface b {
        void a();

        void b(RecyclerView.ViewHolder viewHolder);

        void c(RecyclerView.ViewHolder viewHolder);
    }

    public a(TimeInterpolator timeInterpolator, b bVar) {
        this.f214317b = bVar;
        this.f214318c = timeInterpolator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(RecyclerView.ViewHolder viewHolder, float f16, boolean z16, long j3) {
        float y16 = viewHolder.itemView.getY() - f16;
        ViewPropertyAnimator animate = viewHolder.itemView.animate();
        if (z16) {
            viewHolder.itemView.setAlpha(0.0f);
        }
        viewHolder.itemView.setTranslationY(-y16);
        animate.setInterpolator(this.f214318c);
        this.f214316a.add(viewHolder);
        animate.setDuration(j3).alpha(1.0f).translationY(0.0f).setListener(new C7672a(viewHolder, animate)).start();
    }

    public void e(RecyclerView.ViewHolder viewHolder) {
        if (!this.f214316a.remove(viewHolder)) {
        } else {
            throw new IllegalStateException("after animation is cancelled, item should not be in mAddAnimations list");
        }
    }

    public void f() {
        for (int size = this.f214316a.size() - 1; size >= 0; size--) {
            this.f214316a.get(size).itemView.animate().cancel();
        }
    }

    public boolean g() {
        return !this.f214316a.isEmpty();
    }

    public RecyclerView.ViewHolder c(RecyclerView.ViewHolder viewHolder) {
        return viewHolder;
    }
}
