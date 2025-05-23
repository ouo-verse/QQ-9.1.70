package com.tencent.mobileqq.guild.animate.subchannellist;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<RecyclerView.ViewHolder> f214331a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private final b f214332b;

    /* renamed from: c, reason: collision with root package name */
    private final TimeInterpolator f214333c;

    /* renamed from: d, reason: collision with root package name */
    private final long f214334d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RecyclerView.ViewHolder f214335d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f214336e;

        a(RecyclerView.ViewHolder viewHolder, ViewPropertyAnimator viewPropertyAnimator) {
            this.f214335d = viewHolder;
            this.f214336e = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f214336e.setListener(null);
            this.f214335d.itemView.setAlpha(1.0f);
            this.f214335d.itemView.setTranslationY(0.0f);
            c.this.f214332b.b(this.f214335d);
            c.this.f214331a.remove(this.f214335d);
            c.this.f214332b.a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.f214332b.c(this.f214335d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface b {
        void a();

        void b(RecyclerView.ViewHolder viewHolder);

        void c(RecyclerView.ViewHolder viewHolder);
    }

    public c(TimeInterpolator timeInterpolator, long j3, b bVar) {
        this.f214332b = bVar;
        this.f214333c = timeInterpolator;
        this.f214334d = j3;
    }

    public void d(RecyclerView.ViewHolder viewHolder, float f16) {
        float y16 = viewHolder.itemView.getY() - f16;
        ViewPropertyAnimator animate = viewHolder.itemView.animate();
        animate.setInterpolator(this.f214333c);
        this.f214331a.add(viewHolder);
        animate.setDuration(this.f214334d).alpha(0.0f).translationY(-y16).setListener(new a(viewHolder, animate)).start();
    }

    public void e(RecyclerView.ViewHolder viewHolder) {
        if (!this.f214331a.remove(viewHolder)) {
        } else {
            throw new IllegalStateException("after animation is cancelled, item should not be in mRemoveAnimations list");
        }
    }

    public void f() {
        for (int size = this.f214331a.size() - 1; size >= 0; size--) {
            this.f214331a.get(size).itemView.animate().cancel();
        }
    }

    public boolean g() {
        return !this.f214331a.isEmpty();
    }

    public RecyclerView.ViewHolder c(RecyclerView.ViewHolder viewHolder) {
        return viewHolder;
    }
}
