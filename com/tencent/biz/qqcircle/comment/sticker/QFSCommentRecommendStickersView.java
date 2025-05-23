package com.tencent.biz.qqcircle.comment.sticker;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.comment.sticker.c;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.mobileqq.R;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import java.util.List;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCommentRecommendStickersView extends RecyclerView {
    private static final int G = cx.a(93.0f);
    private WeakReference<View> C;
    private Runnable D;
    private Runnable E;
    private f F;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.biz.qqcircle.comment.sticker.c f83919f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.biz.qqcircle.comment.sticker.d f83920h;

    /* renamed from: i, reason: collision with root package name */
    private ValueAnimator f83921i;

    /* renamed from: m, reason: collision with root package name */
    private ValueAnimator f83922m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends LinearLayoutManager {
        a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            return true;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            QFSCommentRecommendStickersView.this.setTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            QFSCommentRecommendStickersView.this.setTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface f {
        void onDismiss();
    }

    public QFSCommentRecommendStickersView(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(boolean z16) {
        int i3;
        WeakReference<View> weakReference = this.C;
        if (weakReference != null && weakReference.get() != null) {
            View view = this.C.get();
            QCircleSkinHelper qCircleSkinHelper = QCircleSkinHelper.getInstance();
            if (z16) {
                i3 = R.color.qvideo_skin_color_bg_default;
            } else {
                i3 = R.color.aju;
            }
            view.setBackgroundColor(qCircleSkinHelper.getColor(i3));
        }
    }

    private void init() {
        a aVar = new a(getContext());
        aVar.setOrientation(0);
        setLayoutManager(aVar);
        com.tencent.biz.qqcircle.comment.sticker.c cVar = new com.tencent.biz.qqcircle.comment.sticker.c();
        this.f83919f = cVar;
        setAdapter(cVar);
        this.f83920h = new com.tencent.biz.qqcircle.comment.sticker.d(this);
    }

    public void F() {
        if (getVisibility() == 8) {
            return;
        }
        ValueAnimator valueAnimator = this.f83922m;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            return;
        }
        ValueAnimator valueAnimator2 = this.f83921i;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.f83921i.cancel();
        }
        if (this.f83922m == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, G);
            this.f83922m = ofFloat;
            ofFloat.addUpdateListener(new d());
            this.f83922m.addListener(new e());
            this.f83922m.setDuration(200L);
        }
        this.f83922m.start();
        removeCallbacks(this.D);
        removeCallbacks(this.E);
    }

    public void G() {
        removeCallbacks(this.E);
        setRunnable(this.E, 6000);
    }

    public void H(List<com.tencent.biz.qqcircle.comment.sticker.a> list, Runnable runnable) {
        if (getVisibility() != 0 && this.f83919f != null) {
            if (K(list)) {
                setVisibility(0);
                ValueAnimator valueAnimator = this.f83921i;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    return;
                }
                ValueAnimator valueAnimator2 = this.f83922m;
                if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                    this.f83922m.cancel();
                }
                if (this.f83921i == null) {
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(G, 0.0f);
                    this.f83921i = ofFloat;
                    ofFloat.addUpdateListener(new b());
                    this.f83921i.addListener(new c());
                    this.f83921i.setDuration(200L);
                }
                this.f83921i.start();
                if (this.D == null) {
                    this.D = new Runnable() { // from class: com.tencent.biz.qqcircle.comment.sticker.QFSCommentRecommendStickersView.4
                        @Override // java.lang.Runnable
                        public void run() {
                            QFSCommentRecommendStickersView.this.f83920h.d(true);
                        }
                    };
                }
                this.E = runnable;
                setRunnable(this.D, 500);
                setRunnable(this.E, 6000);
                return;
            }
            setVisibility(8);
        }
    }

    public boolean K(List<com.tencent.biz.qqcircle.comment.sticker.a> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        this.f83919f.r0(list);
        scrollToPosition(0);
        return true;
    }

    public void setDismissListener(f fVar) {
        this.F = fVar;
    }

    public void setDtPageId(String str) {
        com.tencent.biz.qqcircle.comment.sticker.c cVar = this.f83919f;
        if (cVar == null) {
            return;
        }
        cVar.n0(str);
    }

    public void setFeedId(String str) {
        com.tencent.biz.qqcircle.comment.sticker.c cVar = this.f83919f;
        if (cVar == null) {
            return;
        }
        cVar.o0(str);
    }

    public void setParentContainer(View view) {
        this.C = new WeakReference<>(view);
    }

    public void setRunnable(Runnable runnable, int i3) {
        if (runnable == null) {
            return;
        }
        postDelayed(runnable, i3);
    }

    public void setStickerClickListener(c.b bVar) {
        com.tencent.biz.qqcircle.comment.sticker.c cVar = this.f83919f;
        if (cVar == null) {
            return;
        }
        cVar.p0(bVar);
    }

    public QFSCommentRecommendStickersView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSCommentRecommendStickersView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        init();
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class c implements Animator.AnimatorListener {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QFSCommentRecommendStickersView.this.I(true);
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

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class e implements Animator.AnimatorListener {
        e() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (QFSCommentRecommendStickersView.this.F != null) {
                QFSCommentRecommendStickersView.this.F.onDismiss();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QFSCommentRecommendStickersView.this.I(false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
