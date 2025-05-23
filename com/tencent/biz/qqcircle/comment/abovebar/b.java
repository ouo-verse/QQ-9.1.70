package com.tencent.biz.qqcircle.comment.abovebar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.widgets.comment.CommentEditText;
import com.tencent.biz.richframework.order.IOrderElement;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class b implements IOrderElement {

    /* renamed from: h, reason: collision with root package name */
    private static ObjectAnimator f83293h;

    /* renamed from: d, reason: collision with root package name */
    protected final com.tencent.biz.qqcircle.comment.abovebar.a f83294d;

    /* renamed from: e, reason: collision with root package name */
    protected final View f83295e;

    /* renamed from: f, reason: collision with root package name */
    protected CommentEditText f83296f;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f83297d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f83298e;

        a(boolean z16, View view) {
            this.f83297d = z16;
            this.f83298e = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            b.f83293h = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.f83293h = null;
            if (!this.f83297d) {
                this.f83298e.setVisibility(8);
            }
            this.f83298e.setTag(-1, Boolean.FALSE);
            this.f83298e.setTag(-2, null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f83297d) {
                this.f83298e.setVisibility(0);
            }
            this.f83298e.setTag(-1, Boolean.TRUE);
            this.f83298e.setTag(-2, Boolean.valueOf(this.f83297d));
        }
    }

    public b(@NonNull View view, @NonNull com.tencent.biz.qqcircle.comment.abovebar.a aVar, @NonNull CommentEditText commentEditText) {
        this.f83294d = aVar;
        this.f83295e = view;
        this.f83296f = commentEditText;
        com.tencent.biz.qqcircle.immersive.manager.e.a().addElement(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(View view, float f16, boolean z16, Animator.AnimatorListener animatorListener) {
        boolean z17;
        boolean z18;
        float f17;
        if (view == null) {
            return;
        }
        if ((view.getTag(-1) instanceof Boolean) && ((Boolean) view.getTag(-1)).booleanValue()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if ((view.getTag(-2) instanceof Boolean) && ((Boolean) view.getTag(-2)).booleanValue()) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z16 == z18 && z17) {
            QLog.d("QFSCommentBaseAboveBar", 1, "showing state same, is animating. ");
            return;
        }
        ObjectAnimator objectAnimator = f83293h;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        float[] fArr = new float[2];
        if (z16) {
            f17 = f16;
        } else {
            f17 = 0.0f;
        }
        fArr[0] = f17;
        if (z16) {
            f16 = 0.0f;
        }
        fArr[1] = f16;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", fArr);
        f83293h = ofFloat;
        ofFloat.setDuration(200L);
        f83293h.addListener(new a(z16, view));
        if (animatorListener != null) {
            f83293h.addListener(animatorListener);
        }
        f83293h.start();
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public String getContextHashCode() {
        return String.valueOf(this.f83295e.hashCode());
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ String getElementExtraKey() {
        return com.tencent.biz.richframework.order.a.a(this);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public String getGroup() {
        return "comment_input_above_bar";
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ String getGroupExtraKey() {
        return com.tencent.biz.richframework.order.a.b(this);
    }

    public Context h() {
        return this.f83295e.getContext();
    }

    public String i() {
        com.tencent.biz.qqcircle.comment.abovebar.a aVar = this.f83294d;
        if (aVar != null && aVar.getFeed() != null) {
            return this.f83294d.getFeed().f398449id.get();
        }
        return "";
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ boolean isDataReady() {
        return com.tencent.biz.richframework.order.a.c(this);
    }

    public abstract void j();

    public void k(boolean z16) {
    }
}
