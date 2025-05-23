package com.tencent.biz.qqcircle.immersive.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ao {

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends c {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f90132d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ c f90133e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f90134f;

        a(View view, c cVar, View view2) {
            this.f90132d = view;
            this.f90133e = cVar;
            this.f90134f = view2;
        }

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QLog.i("PlusEntry-QFSPublishButtonAnimUtil", 1, "closeExPublishButton, onAnimationEnd");
            this.f90134f.setVisibility(8);
            this.f90132d.setVisibility(0);
            c cVar = this.f90133e;
            if (cVar != null) {
                cVar.onAnimationEnd(animator);
            }
        }

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QLog.i("PlusEntry-QFSPublishButtonAnimUtil", 1, "closeExPublishButton, onAnimationStart");
            this.f90132d.setVisibility(0);
            c cVar = this.f90133e;
            if (cVar != null) {
                cVar.onAnimationStart(animator);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class b extends c {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f90135d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ c f90136e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f90137f;

        b(View view, c cVar, View view2) {
            this.f90135d = view;
            this.f90136e = cVar;
            this.f90137f = view2;
        }

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QLog.i("PlusEntry-QFSPublishButtonAnimUtil", 1, "showExPublishButton, onAnimationEnd");
            this.f90137f.setVisibility(8);
            this.f90135d.setVisibility(0);
            c cVar = this.f90136e;
            if (cVar != null) {
                cVar.onAnimationEnd(animator);
            }
        }

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QLog.i("PlusEntry-QFSPublishButtonAnimUtil", 1, "showExPublishButton, onAnimationStart");
            this.f90135d.setVisibility(0);
            c cVar = this.f90136e;
            if (cVar != null) {
                cVar.onAnimationStart(animator);
            }
        }
    }

    public static Animator a(View view, View view2, boolean z16, c cVar) {
        long j3;
        QLog.i("PlusEntry-QFSPublishButtonAnimUtil", 1, "closeExPublishButton");
        AnimatorSet animatorSet = new AnimatorSet();
        long j16 = 0;
        if (z16) {
            j3 = 200;
        } else {
            j3 = 0;
        }
        animatorSet.setDuration(j3);
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(view2, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f));
        arrayList.add(ObjectAnimator.ofFloat(view2, "ScaleX", 1.0f, 0.0f));
        arrayList.add(ObjectAnimator.ofFloat(view2, "ScaleY", 1.0f, 0.0f));
        animatorSet.playTogether(arrayList);
        AnimatorSet animatorSet2 = new AnimatorSet();
        if (z16) {
            j16 = 160;
        }
        animatorSet2.setDuration(j16);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f));
        animatorSet2.playTogether(arrayList2);
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playSequentially(animatorSet, animatorSet2);
        animatorSet2.addListener(new a(view, cVar, view2));
        animatorSet3.start();
        return animatorSet3;
    }

    public static Animator b(View view, View view2, c cVar) {
        QLog.i("PlusEntry-QFSPublishButtonAnimUtil", 1, "showExPublishButton");
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(160L);
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f));
        animatorSet.playTogether(arrayList);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(300L);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(ObjectAnimator.ofFloat(view2, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f));
        arrayList2.add(ObjectAnimator.ofFloat(view2, "ScaleX", 0.0f, 1.0f));
        arrayList2.add(ObjectAnimator.ofFloat(view2, "ScaleY", 0.0f, 1.0f));
        animatorSet2.playTogether(arrayList2);
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playSequentially(animatorSet, animatorSet2);
        animatorSet2.addListener(new b(view2, cVar, view));
        animatorSet3.start();
        return animatorSet3;
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class c extends com.tencent.mobileqq.widget.ak {
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
