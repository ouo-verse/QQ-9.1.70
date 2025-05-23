package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.widget.OverScrollRecyclerView;

/* compiled from: P */
/* loaded from: classes20.dex */
public class LebaOverScrollRecyclerView extends OverScrollRecyclerView {

    /* renamed from: e, reason: collision with root package name */
    private a f315772e;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        void a(float f16);

        void b(float f16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class b extends OverScrollRecyclerView.b {

        /* renamed from: m, reason: collision with root package name */
        a f315773m;

        public b(OverScrollRecyclerView.i iVar, float f16) {
            super(iVar, f16);
        }

        @Override // com.tencent.mobileqq.widget.OverScrollRecyclerView.b, android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            super.onAnimationUpdate(valueAnimator);
            a aVar = this.f315773m;
            if (aVar != null) {
                aVar.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class c extends OverScrollRecyclerView.f {

        /* renamed from: b, reason: collision with root package name */
        a f315774b;

        c() {
        }

        @Override // com.tencent.mobileqq.widget.OverScrollRecyclerView.f, com.tencent.mobileqq.widget.OverScrollRecyclerView.d
        public void translateView(View view, float f16) {
            super.translateView(view, f16);
            a aVar = this.f315774b;
            if (aVar != null) {
                aVar.a(f16);
            }
        }

        @Override // com.tencent.mobileqq.widget.OverScrollRecyclerView.f, com.tencent.mobileqq.widget.OverScrollRecyclerView.d
        public void translateViewAndEvent(View view, float f16, MotionEvent motionEvent) {
            super.translateViewAndEvent(view, f16, motionEvent);
            a aVar = this.f315774b;
            if (aVar != null) {
                aVar.a(f16);
            }
        }
    }

    public LebaOverScrollRecyclerView(Context context) {
        super(context);
        c();
    }

    private void c() {
        this.f315913d.f315932e = new c();
        OverScrollRecyclerView.i iVar = this.f315913d;
        iVar.C = new b(iVar, -2.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f315913d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.OverScrollRecyclerView, android.support.v7.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f315913d.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        a aVar = this.f315772e;
        if (aVar != null) {
            aVar.b(i16);
        }
    }

    public void setOverScrollHeader(a aVar) {
        this.f315772e = aVar;
        OverScrollRecyclerView.i iVar = this.f315913d;
        ((c) iVar.f315932e).f315774b = aVar;
        ((b) iVar.C).f315773m = aVar;
    }

    public LebaOverScrollRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public LebaOverScrollRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        c();
    }
}
