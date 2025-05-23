package com.tencent.mobileqq.guild.animate.subchannellist;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<RecyclerView.ViewHolder> f214322a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC7673b f214323b;

    /* renamed from: c, reason: collision with root package name */
    private final TimeInterpolator f214324c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RecyclerView.ViewHolder f214325d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f214326e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f214327f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f214328h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f214329i;

        a(RecyclerView.ViewHolder viewHolder, int i3, View view, int i16, ViewPropertyAnimator viewPropertyAnimator) {
            this.f214325d = viewHolder;
            this.f214326e = i3;
            this.f214327f = view;
            this.f214328h = i16;
            this.f214329i = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f214326e != 0) {
                this.f214327f.setTranslationX(0.0f);
            }
            if (this.f214328h != 0) {
                this.f214327f.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f214329i.setListener(null);
            this.f214329i.setUpdateListener(null);
            this.f214329i.setStartDelay(0L);
            b.this.f214323b.c(this.f214325d);
            b.this.f214322a.remove(this.f214325d);
            b.this.f214323b.a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            b.this.f214323b.b(this.f214325d);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.animate.subchannellist.b$b, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public interface InterfaceC7673b {
        void a();

        void b(RecyclerView.ViewHolder viewHolder);

        void c(RecyclerView.ViewHolder viewHolder);
    }

    public b(TimeInterpolator timeInterpolator, InterfaceC7673b interfaceC7673b) {
        this.f214323b = interfaceC7673b;
        this.f214324c = timeInterpolator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(RecyclerView.ViewHolder viewHolder, int i3, int i16, int i17, int i18, long j3, long j16) {
        View view = viewHolder.itemView;
        int i19 = i17 - i3;
        int i26 = i18 - i16;
        if (i19 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i26 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator animate = view.animate();
        this.f214322a.add(viewHolder);
        animate.setInterpolator(this.f214324c);
        animate.setDuration(j3);
        animate.setStartDelay(j16);
        animate.setListener(new a(viewHolder, i19, view, i26, animate)).start();
    }

    public void e(RecyclerView.ViewHolder viewHolder, int i3, int i16, int i17, int i18) {
        int i19 = i18 - i16;
        if (i17 - i3 != 0) {
            viewHolder.itemView.setTranslationX(0.0f);
        }
        if (i19 != 0) {
            viewHolder.itemView.setTranslationY(0.0f);
        }
        this.f214323b.c(viewHolder);
        this.f214323b.a();
    }

    public void f(RecyclerView.ViewHolder viewHolder) {
        if (!this.f214322a.remove(viewHolder)) {
        } else {
            throw new IllegalStateException("after animation is cancelled, item should not be in mMoveAnimations list");
        }
    }

    public void g() {
        for (int size = this.f214322a.size() - 1; size >= 0; size--) {
            this.f214322a.get(size).itemView.animate().cancel();
        }
    }

    public boolean h() {
        return !this.f214322a.isEmpty();
    }

    public RecyclerView.ViewHolder c(RecyclerView.ViewHolder viewHolder, int i3, int i16, int i17, int i18) {
        return viewHolder;
    }
}
