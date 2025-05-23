package com.tencent.sqshow.zootopia.nativeui.view.dialog;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import b94.e;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.sqshow.zootopia.nativeui.data.j;
import com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView;
import ga4.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oc4.a;
import tl.h;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u00042\u00020\u00012\u00020\u0002:\u0001=B/\b\u0007\u0012\u0006\u00107\u001a\u000206\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u000108\u0012\b\b\u0002\u0010:\u001a\u00020\u0010\u0012\u0006\u0010)\u001a\u00020$\u00a2\u0006\u0004\b;\u0010<J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\b\u0010\u0013\u001a\u00020\u0012H\u0014J\b\u0010\u0014\u001a\u00020\tH$J\b\u0010\u0015\u001a\u00020\u0012H\u0014J\b\u0010\u0016\u001a\u00020\u0010H\u0015J\b\u0010\u0017\u001a\u00020\u0012H\u0014J\u0006\u0010\u0018\u001a\u00020\tJ\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0010H\u0014J\b\u0010\u001d\u001a\u00020\u0010H\u0014J\b\u0010\u001e\u001a\u00020\u0003H\u0016J\b\u0010\u001f\u001a\u00020\u0003H\u0016J\b\u0010 \u001a\u00020\u0003H\u0016J\b\u0010!\u001a\u00020\u0003H\u0016J\b\u0010\"\u001a\u00020\u0003H\u0016J\b\u0010#\u001a\u00020\u0003H\u0014R\u001a\u0010)\u001a\u00020$8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010+R\u0016\u00101\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00100R\u0018\u00105\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u00104\u00a8\u0006>"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/BasePanelDialogView;", "Landroid/widget/FrameLayout;", "Lga4/g;", "", BdhLogUtil.LogTag.Tag_Conn, "B", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "Landroid/view/View;", "contentView", "Landroid/animation/AnimatorSet;", "y", ReportConstant.COSTREPORT_PREFIX, "H", "K", "", "r", "", "L", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, UserInfo.SEX_FEMALE, HippyTKDListViewAdapter.X, "M", "getView", "Lga4/h;", "dismissListener", "setOnDismissListener", "u", "t", "show", "o", DomainData.DOMAIN_NAME, "onShow", "onDismiss", "I", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "d", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "v", "()Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "mChannel", "e", "Landroid/view/View;", "mContentView", "f", "mBackgroundView", h.F, "Z", "mAnimating", "i", "mViewInitDone", "Lga4/h;", "mDismissListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/sqshow/zootopia/nativeui/data/j;)V", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public abstract class BasePanelDialogView extends FrameLayout implements g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final j mChannel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View mContentView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View mBackgroundView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mAnimating;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mViewInitDone;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ga4.h mDismissListener;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/dialog/BasePanelDialogView$c", "Loc4/a;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c extends a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f371736d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ BasePanelDialogView f371737e;

        c(View view, BasePanelDialogView basePanelDialogView) {
            this.f371736d = view;
            this.f371737e = basePanelDialogView;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            this.f371737e.H();
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            this.f371736d.setVisibility(0);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/dialog/BasePanelDialogView$d", "Loc4/a;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d extends a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f371738d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ BasePanelDialogView f371739e;

        d(View view, BasePanelDialogView basePanelDialogView) {
            this.f371738d = view;
            this.f371739e = basePanelDialogView;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            this.f371739e.K();
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            this.f371738d.setVisibility(0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasePanelDialogView(Context context, AttributeSet attributeSet, int i3, j mChannel) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mChannel, "mChannel");
        this.mChannel = mChannel;
        View view = new View(context, attributeSet, i3);
        view.setAlpha(0.0f);
        view.setBackgroundColor(r());
        this.mBackgroundView = view;
    }

    private final void A() {
        Object w3 = w();
        if (w3 == null) {
            return;
        }
        y94.a.l(this.mChannel.getReporter(), w3, false, 2, null);
    }

    private final void B() {
        Object w3 = w();
        if (w3 != null) {
            y94.a.j(this.mChannel.getReporter(), w3, false, 2, null);
        }
        VideoReport.traversePage(this.mContentView);
        I();
    }

    private final void C() {
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (F()) {
            if (this.mBackgroundView.getParent() instanceof ViewGroup) {
                ViewParent parent = this.mBackgroundView.getParent();
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent).removeView(this.mBackgroundView);
            }
            addView(this.mBackgroundView, layoutParams);
        }
        View m3 = m();
        m3.setVisibility(4);
        m3.setOnClickListener(new View.OnClickListener() { // from class: ga4.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BasePanelDialogView.D(view);
            }
        });
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(u(), t());
        int x16 = x();
        if (x16 == 1) {
            layoutParams2.gravity = 80;
        } else if (x16 == 2) {
            layoutParams2.gravity = 17;
        } else if (x16 == 3) {
            layoutParams2.gravity = 8388613;
        } else if (x16 == 4) {
            layoutParams2.gravity = 8388693;
        }
        if (m3.getParent() instanceof ViewGroup) {
            ViewParent parent2 = m3.getParent();
            Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent2).removeView(m3);
        }
        addView(m3, layoutParams2);
        this.mContentView = m3;
        if (F() && L()) {
            this.mBackgroundView.setOnClickListener(new View.OnClickListener() { // from class: ga4.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BasePanelDialogView.E(BasePanelDialogView.this, view);
                }
            });
        }
        this.mViewInitDone = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(BasePanelDialogView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(BasePanelDialogView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(BasePanelDialogView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q();
    }

    private final void p() {
        View view = this.mContentView;
        if (view == null || this.mAnimating) {
            return;
        }
        this.mAnimating = true;
        AnimatorSet s16 = s(view);
        ga4.h hVar = this.mDismissListener;
        if (hVar != null) {
            s16.addListener(new b(hVar, this));
        }
        s16.start();
    }

    private final void q() {
        View view = this.mContentView;
        if (view == null || this.mAnimating) {
            return;
        }
        this.mAnimating = true;
        y(view).start();
    }

    private final AnimatorSet s(View contentView) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new c(contentView, this));
        if (F()) {
            View view = this.mBackgroundView;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, view.getAlpha(), 0.0f);
            ofFloat.setDuration(100L);
            animatorSet.play(ofFloat);
        }
        int x16 = x();
        if (x16 == 1) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(contentView, "translationY", contentView.getTranslationY(), contentView.getHeight());
            ofFloat2.setDuration(100L);
            animatorSet.play(ofFloat2);
        } else if (x16 == 2) {
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(contentView, com.tencent.luggage.wxa.c8.c.f123400v, contentView.getAlpha(), 0.0f);
            ofFloat3.setDuration(100L);
            ofFloat3.setInterpolator(new DecelerateInterpolator(1.25f));
            animatorSet.play(ofFloat3);
        } else if (x16 == 3 || x16 == 4) {
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(contentView, "translationX", contentView.getTranslationX(), contentView.getWidth());
            ofFloat4.setDuration(100L);
            animatorSet.play(ofFloat4);
        }
        return animatorSet;
    }

    private final AnimatorSet y(final View contentView) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new d(contentView, this));
        if (F()) {
            View view = this.mBackgroundView;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, view.getAlpha(), 1.0f);
            ofFloat.setDuration(200L);
            animatorSet.play(ofFloat);
        }
        int x16 = x();
        if (x16 == 1) {
            contentView.setTranslationY(contentView.getHeight());
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(contentView, "translationY", contentView.getTranslationY(), 0.0f);
            ofFloat2.setDuration(200L);
            animatorSet.play(ofFloat2);
        } else if (x16 == 2) {
            contentView.setScaleX(0.0f);
            contentView.setScaleY(0.0f);
            contentView.setPivotX(contentView.getWidth() / 2.0f);
            contentView.setPivotY(contentView.getHeight() / 2.0f);
            ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat3.setDuration(200L);
            ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ga4.d
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BasePanelDialogView.z(contentView, valueAnimator);
                }
            });
            ofFloat3.setInterpolator(new OvershootInterpolator());
            animatorSet.play(ofFloat3);
        } else if (x16 == 3 || x16 == 4) {
            contentView.setTranslationX(contentView.getWidth());
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(contentView, "translationX", contentView.getTranslationX(), 0.0f);
            ofFloat4.setDuration(200L);
            animatorSet.play(ofFloat4);
        }
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(View contentView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(contentView, "$contentView");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        contentView.setScaleX(floatValue);
        contentView.setScaleY(floatValue);
    }

    protected boolean F() {
        return true;
    }

    protected boolean L() {
        return true;
    }

    protected boolean M() {
        return false;
    }

    @Override // ga4.g
    public boolean a() {
        return g.a.b(this);
    }

    @Override // ga4.g
    public void e(int i3) {
        g.a.c(this, i3);
    }

    protected abstract View m();

    public void n() {
        H();
    }

    public void o() {
        if (this.mAnimating) {
            return;
        }
        this.mChannel.getDialogController().g(this);
        this.mViewInitDone = false;
    }

    public void onDismiss() {
        post(new Runnable() { // from class: ga4.e
            @Override // java.lang.Runnable
            public final void run() {
                BasePanelDialogView.G(BasePanelDialogView.this);
            }
        });
        A();
    }

    @Override // ga4.g
    public void onShow() {
        if (!this.mViewInitDone) {
            C();
        }
        ga4.h hVar = this.mDismissListener;
        if (hVar != null) {
            hVar.b(this);
        }
        post(new Runnable() { // from class: ga4.a
            @Override // java.lang.Runnable
            public final void run() {
                BasePanelDialogView.J(BasePanelDialogView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int r() {
        return Color.parseColor("#80000000");
    }

    public void setOnDismissListener(ga4.h dismissListener) {
        Intrinsics.checkNotNullParameter(dismissListener, "dismissListener");
        this.mDismissListener = dismissListener;
    }

    public void show() {
        if (!this.mViewInitDone) {
            C();
        }
        this.mChannel.getDialogController().e(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int t() {
        e O = this.mChannel.O();
        if (!M() || O == null) {
            return -2;
        }
        return O.v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int u() {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: v, reason: from getter */
    public final j getMChannel() {
        return this.mChannel;
    }

    public Object w() {
        return g.a.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @PanelDialogStyle
    public int x() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(View view) {
        QLog.i("IGNORE", 4, "contentView clicked!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H() {
        this.mAnimating = false;
        this.mChannel.getDialogController().b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K() {
        this.mAnimating = false;
        B();
    }

    protected void I() {
    }

    @Override // ga4.g
    public final View getView() {
        return this;
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/dialog/BasePanelDialogView$b", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ga4.h f371734d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ BasePanelDialogView f371735e;

        b(ga4.h hVar, BasePanelDialogView basePanelDialogView) {
            this.f371734d = hVar;
            this.f371735e = basePanelDialogView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            this.f371734d.a(this.f371735e);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
        }
    }
}
