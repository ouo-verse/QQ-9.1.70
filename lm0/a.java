package lm0;

import android.graphics.Canvas;
import com.tencent.gdtad.basics.adshake.animatorview.animator.Animator;
import com.tencent.gdtad.basics.adshake.animatorview.animator.GroupAnimator;
import com.tencent.gdtad.basics.adshake.animatorview.animator.ProgressAnimator;
import com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer;
import com.tencent.gdtad.basics.adshake.animatorview.layer.GroupLayer;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a extends GroupLayer {

    /* compiled from: P */
    /* renamed from: lm0.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C10732a extends GroupAnimator {

        /* renamed from: a, reason: collision with root package name */
        private c f415000a;

        /* renamed from: b, reason: collision with root package name */
        private b f415001b;

        public C10732a(AnimatorLayer animatorLayer, Animator... animatorArr) {
            super(animatorLayer, animatorArr);
            a(animatorLayer);
        }

        private void a(AnimatorLayer animatorLayer) {
            b bVar = new b(animatorLayer);
            this.f415001b = bVar;
            bVar.setRepeatCount(0);
            c cVar = new c(animatorLayer);
            this.f415000a = cVar;
            cVar.setRepeatCount(0);
            addAnimators(this.f415001b, this.f415000a);
        }

        public void b(int i3) {
            this.f415001b.a(0.0f, 0.0f, i3);
        }

        public void c(float f16) {
            b bVar = this.f415001b;
            if (bVar != null) {
                bVar.b(f16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class b extends com.tencent.gdtad.basics.adshake.animatorview.animator.a {
        public b(AnimatorLayer animatorLayer) {
            super(animatorLayer);
            a(0.0f, 0.0f, -25.0f);
        }

        public void b(float f16) {
            setRotationDegrees(f16, f16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class c extends ProgressAnimator {
        public c(AnimatorLayer animatorLayer) {
            super(animatorLayer, 0.0f, 0.0f);
        }

        @Override // com.tencent.gdtad.basics.adshake.animatorview.animator.ProgressAnimator, com.tencent.gdtad.basics.adshake.animatorview.animator.Animator
        protected void onPostAnimation(Canvas canvas, AnimatorLayer animatorLayer, boolean z16) {
            if (z16 && !shouldRepeat()) {
                animatorLayer.postProgress(getToProgress());
            } else {
                animatorLayer.postProgress(computeProgress());
            }
        }
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer, com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorAction
    public void postRotationY(float f16) {
        throw null;
    }
}
