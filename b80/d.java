package b80;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.tav.core.ExportErrorStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000  2\u00020\u0001:\u0002\u0015\u0018B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b*\u0010+J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J*\u0010\r\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J!\u0010\u0010\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u000e*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\b\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u0005J\u0006\u0010\u0013\u001a\u00020\u0005R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R$\u0010$\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010%R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010(\u00a8\u0006,"}, d2 = {"Lb80/d;", "", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, h.F, "", "k", "view", "", "start", "end", "", "hide", "e", "T", "id", "f", "(I)Landroid/view/View;", "p", "i", "Landroid/view/ViewStub;", "a", "Landroid/view/ViewStub;", "viewStub", "b", "Landroid/view/View;", "inflatedView", "c", "parentView", "Lb80/d$a;", "d", "Lb80/d$a;", "g", "()Lb80/d$a;", "o", "(Lb80/d$a;)V", "bannerOperation", "Z", "isAnimatoring", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "mHideBannerRunnable", "<init>", "(Landroid/view/ViewStub;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewStub viewStub;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View inflatedView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View parentView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a bannerOperation;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isAnimatoring;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable mHideBannerRunnable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lb80/d$a;", "", "", "hide", "", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public interface a {
        void a(boolean hide);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"b80/d$c", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c implements Animator.AnimatorListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f28055e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f28056f;

        c(boolean z16, View view) {
            this.f28055e = z16;
            this.f28056f = view;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            d.this.isAnimatoring = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            if (this.f28055e) {
                this.f28056f.setVisibility(8);
            }
            d.this.isAnimatoring = false;
            a bannerOperation = d.this.getBannerOperation();
            if (bannerOperation != null) {
                bannerOperation.a(this.f28055e);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            d.this.isAnimatoring = true;
        }
    }

    public d(@NotNull ViewStub viewStub) {
        Intrinsics.checkNotNullParameter(viewStub, "viewStub");
        this.viewStub = viewStub;
        this.mHideBannerRunnable = new Runnable() { // from class: b80.b
            @Override // java.lang.Runnable
            public final void run() {
                d.n(d.this);
            }
        };
    }

    private final void e(View view, int start, int end, boolean hide) {
        boolean z16;
        if (this.isAnimatoring) {
            if (hide && view != null) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        if (view != null && view.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", ViewUtils.dpToPx(start), ViewUtils.dpToPx(end));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat);
        animatorSet.setDuration(240L);
        animatorSet.start();
        animatorSet.addListener(new c(hide, view));
    }

    private final View h() {
        View view = this.inflatedView;
        if (view == null) {
            return m();
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(d this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = this$0.parentView;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private final void k() {
        if (this.parentView != null) {
            if (RFWThreadManager.isMainThread()) {
                e(this.parentView, 0, ExportErrorStatus.END_WRITE_AUDIO_SAMPLE, true);
            } else {
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: b80.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.l(d.this);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(d this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.e(this$0.parentView, 0, ExportErrorStatus.END_WRITE_AUDIO_SAMPLE, true);
    }

    private final View m() {
        if (this.inflatedView == null) {
            this.inflatedView = this.viewStub.inflate();
        }
        return this.inflatedView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(d this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.k();
    }

    @Nullable
    public final <T extends View> T f(int id5) {
        View h16 = h();
        if (h16 != null) {
            return (T) h16.findViewById(id5);
        }
        return null;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final a getBannerOperation() {
        return this.bannerOperation;
    }

    public final void i() {
        if (this.parentView != null) {
            if (RFWThreadManager.isMainThread()) {
                View view = this.parentView;
                if (view != null) {
                    view.setVisibility(8);
                }
            } else {
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: b80.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.j(d.this);
                    }
                });
            }
            SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(19, "", false));
        }
    }

    public final void o(@Nullable a aVar) {
        this.bannerOperation = aVar;
    }

    public final void p() {
        View findViewById;
        View h16 = h();
        if (h16 != null && (findViewById = h16.findViewById(R.id.f55642ig)) != null) {
            this.parentView = findViewById;
            findViewById.setVisibility(0);
            e(this.parentView, ExportErrorStatus.END_WRITE_AUDIO_SAMPLE, 0, false);
            SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(19, "", true));
            RFWThreadManager.getUIHandler().removeCallbacks(this.mHideBannerRunnable);
            RFWThreadManager.getUIHandler().postDelayed(this.mHideBannerRunnable, 5000L);
        }
    }
}
