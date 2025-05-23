package com.tencent.ecommerce.base.ui;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 72\u00020\u0001:\u00018B\u0019\u0012\u0006\u00104\u001a\u000203\u0012\b\b\u0002\u00102\u001a\u00020\u0019\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0003J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J:\u0010\u0010\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u0013J\u0012\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0014J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0002H\u0016R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010\"R\u0016\u0010)\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R*\u00100\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0014\u00102\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010\u0010\u00a8\u00069"}, d2 = {"Lcom/tencent/ecommerce/base/ui/SlidingUpDialog;", "Landroid/app/Dialog;", "", "initView", "W", "b0", "a0", "Landroid/view/View;", "view", "", "startY", "endY", "", "duration", "Lkotlin/Function0;", "animEndCallback", "Z", "Y", "customView", "Landroid/widget/FrameLayout$LayoutParams;", "layoutParams", ExifInterface.LATITUDE_SOUTH, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "", "cancel", "setCanceledOnTouchOutside", "dismiss", "Landroid/widget/FrameLayout;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/FrameLayout;", "contentLayout", "D", "Landroid/view/View;", "dialogLayout", "E", "canceledOnTouchOutside", UserInfo.SEX_FEMALE, "G", "Landroid/widget/FrameLayout$LayoutParams;", "customViewLp", "H", "Lkotlin/jvm/functions/Function0;", BdhLogUtil.LogTag.Tag_Req, "()Lkotlin/jvm/functions/Function0;", "X", "(Lkotlin/jvm/functions/Function0;)V", "showAnimEndCallback", "I", "hideCloseBtn", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Landroid/app/Activity;Z)V", "J", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class SlidingUpDialog extends ReportDialog {

    /* renamed from: C, reason: from kotlin metadata */
    private FrameLayout contentLayout;

    /* renamed from: D, reason: from kotlin metadata */
    private View dialogLayout;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean canceledOnTouchOutside;

    /* renamed from: F, reason: from kotlin metadata */
    private View customView;

    /* renamed from: G, reason: from kotlin metadata */
    private FrameLayout.LayoutParams customViewLp;

    /* renamed from: H, reason: from kotlin metadata */
    private Function0<Unit> showAnimEndCallback;

    /* renamed from: I, reason: from kotlin metadata */
    private final boolean hideCloseBtn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/base/ui/SlidingUpDialog$initView$2$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            SlidingUpDialog.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class c implements View.OnTouchListener {
        c() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (!SlidingUpDialog.this.canceledOnTouchOutside) {
                return true;
            }
            SlidingUpDialog.this.dismiss();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class d implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        public static final d f101130d = new d();

        d() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class e implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f101131d;

        e(View view) {
            this.f101131d = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            View view = this.f101131d;
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue != null) {
                view.setTranslationY(((Float) animatedValue).floatValue());
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public /* synthetic */ SlidingUpDialog(Activity activity, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, (i3 & 2) != 0 ? false : z16);
    }

    public static final /* synthetic */ FrameLayout P(SlidingUpDialog slidingUpDialog) {
        FrameLayout frameLayout = slidingUpDialog.contentLayout;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
        }
        return frameLayout;
    }

    private final void W() {
        View view = this.dialogLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogLayout");
        }
        view.setOnTouchListener(new c());
        FrameLayout frameLayout = this.contentLayout;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
        }
        frameLayout.setOnTouchListener(d.f101130d);
    }

    private final void Y() {
        Window window = getWindow();
        if (window != null) {
            window.getDecorView().setSystemUiVisibility(1280);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        }
    }

    private final void a0() {
        FrameLayout frameLayout = this.contentLayout;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
        }
        if (this.contentLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
        }
        Z(frameLayout, 0.0f, r3.getHeight(), 200L, new Function0<Unit>() { // from class: com.tencent.ecommerce.base.ui.SlidingUpDialog$slidingDown$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                super/*android.app.Dialog*/.dismiss();
            }
        });
    }

    private final void b0() {
        FrameLayout frameLayout = this.contentLayout;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
        }
        frameLayout.setVisibility(4);
        FrameLayout frameLayout2 = this.contentLayout;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
        }
        frameLayout2.post(new Runnable() { // from class: com.tencent.ecommerce.base.ui.SlidingUpDialog$slidingUp$1
            @Override // java.lang.Runnable
            public final void run() {
                SlidingUpDialog.P(SlidingUpDialog.this).setVisibility(0);
                SlidingUpDialog slidingUpDialog = SlidingUpDialog.this;
                slidingUpDialog.Z(SlidingUpDialog.P(slidingUpDialog), SlidingUpDialog.P(SlidingUpDialog.this).getHeight(), 0.0f, 200L, SlidingUpDialog.this.R());
            }
        });
    }

    public final Function0<Unit> R() {
        return this.showAnimEndCallback;
    }

    public final void S(View customView, FrameLayout.LayoutParams layoutParams) {
        this.customView = customView;
        this.customViewLp = layoutParams;
    }

    public final void X(Function0<Unit> function0) {
        this.showAnimEndCallback = function0;
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        a0();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        Window window = getWindow();
        if (window != null) {
            window.requestFeature(1);
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(-1, -1);
        }
        Y();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cur);
        initView();
        W();
        b0();
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean cancel) {
        super.setCanceledOnTouchOutside(cancel);
        this.canceledOnTouchOutside = cancel;
    }

    public SlidingUpDialog(Activity activity, boolean z16) {
        super(activity, android.R.style.Theme.Black.NoTitleBar);
        this.hideCloseBtn = z16;
        this.canceledOnTouchOutside = true;
        this.customViewLp = new FrameLayout.LayoutParams(-1, -2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z(View view, float startY, float endY, long duration, Function0<Unit> animEndCallback) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(startY, endY);
        ofFloat.addUpdateListener(new e(view));
        if (animEndCallback != null) {
            ofFloat.addListener(new f(animEndCallback));
        }
        ofFloat.setDuration(duration);
        ofFloat.start();
    }

    private final void initView() {
        this.contentLayout = (FrameLayout) findViewById(R.id.nur);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.nux);
        View view = this.customView;
        if (view != null) {
            frameLayout.addView(view, this.customViewLp);
        }
        this.dialogLayout = findViewById(R.id.nvh);
        View findViewById = findViewById(R.id.ntg);
        if (this.hideCloseBtn) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new b());
        }
    }

    public static /* synthetic */ void U(SlidingUpDialog slidingUpDialog, View view, FrameLayout.LayoutParams layoutParams, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            layoutParams = slidingUpDialog.customViewLp;
        }
        slidingUpDialog.S(view, layoutParams);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/base/ui/SlidingUpDialog$f", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationRepeat", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class f implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0 f101132d;

        f(Function0 function0) {
            this.f101132d = function0;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            this.f101132d.invoke();
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
