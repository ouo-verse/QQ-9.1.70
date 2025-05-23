package com.tencent.mobileqq.wink.editor.filter;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \b2\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u00a2\u0006\u0004\b0\u00101J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u0004R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0016\u0010!\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010)\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010+R\u0014\u0010/\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010.\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/filter/p;", "", "", "progress", "", "t", "i", "u", "j", "Landroid/view/View$OnClickListener;", "listener", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, tl.h.F, "g", "", "isDone", "r", "p", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "", "b", UserInfo.SEX_FEMALE, "detectPart", "c", "applyPart", "d", "Z", "detectDone", "e", "applyDone", "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "f", "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "dialog", "Landroid/view/View$OnClickListener;", "cancelListener", "Landroid/animation/ValueAnimator;", "Landroid/animation/ValueAnimator;", "animator", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "tipsDoneRunnable", "<init>", "(Landroid/content/Context;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private float detectPart;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private float applyPart;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean detectDone;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean applyDone;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QCircleCommonLoadingDialog dialog;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View.OnClickListener cancelListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ValueAnimator animator;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable tipsDoneRunnable;

    public p(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.detectPart = 0.5f;
        this.applyPart = 0.5f;
        this.tipsDoneRunnable = new Runnable() { // from class: com.tencent.mobileqq.wink.editor.filter.j
            @Override // java.lang.Runnable
            public final void run() {
                p.n(p.this);
            }
        };
    }

    private final int i() {
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this.dialog;
        if (qCircleCommonLoadingDialog != null) {
            return qCircleCommonLoadingDialog.k0();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(p this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View.OnClickListener onClickListener = this$0.cancelListener;
        if (onClickListener != null) {
            onClickListener.onClick(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(final p this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.filter.l
            @Override // java.lang.Runnable
            public final void run() {
                p.o(p.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(p this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.applyDone) {
            this$0.t(100);
            QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this$0.dialog;
            if (qCircleCommonLoadingDialog != null) {
                qCircleCommonLoadingDialog.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(p this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this$0.dialog;
        boolean z16 = false;
        if (qCircleCommonLoadingDialog != null && qCircleCommonLoadingDialog.j0() == 2) {
            z16 = true;
        }
        if (z16) {
            this$0.t(100);
            this$0.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(p this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.detectDone = z16;
        this$0.u();
    }

    private final void t(int progress) {
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this.dialog;
        if (qCircleCommonLoadingDialog != null) {
            qCircleCommonLoadingDialog.setProgress(progress);
        }
    }

    private final void u() {
        int coerceIn;
        float f16 = 0.0f;
        if (this.detectDone) {
            f16 = 0.0f + this.detectPart;
        }
        if (this.applyDone) {
            f16 += this.applyPart;
        }
        int i3 = i();
        coerceIn = RangesKt___RangesKt.coerceIn((int) (f16 * 100), 0, 100);
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(i3, coerceIn);
        ofInt.setDuration(200L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.wink.editor.filter.o
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                p.v(p.this, valueAnimator2);
            }
        });
        this.animator = ofInt;
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(p this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        this$0.t(((Integer) animatedValue).intValue());
    }

    public final void g() {
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this.dialog;
        if (qCircleCommonLoadingDialog != null) {
            qCircleCommonLoadingDialog.cancel();
        }
    }

    public final void h() {
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this.dialog;
        if (qCircleCommonLoadingDialog != null) {
            qCircleCommonLoadingDialog.dismiss();
        }
    }

    public final void j() {
        List<String> listOf;
        QCircleCommonLoadingDialog.c cVar = new QCircleCommonLoadingDialog.c(this.context);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{this.context.getResources().getString(R.string.f216415y9), this.context.getResources().getString(R.string.f216425y_), this.context.getResources().getString(R.string.f216435ya)});
        cVar.q(listOf);
        this.dialog = cVar.n(false).j("smart_filter").g(false).e(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.filter.k
            @Override // java.lang.Runnable
            public final void run() {
                p.k(p.this);
            }
        }).k(this.tipsDoneRunnable).f(500L).l(500L).a();
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.animator = null;
        t(0);
    }

    public final void l(@NotNull View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.cancelListener = listener;
    }

    public final void m() {
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this.dialog;
        if (qCircleCommonLoadingDialog != null) {
            qCircleCommonLoadingDialog.show();
        }
    }

    public final void p() {
        this.detectDone = true;
        this.applyDone = true;
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.filter.n
            @Override // java.lang.Runnable
            public final void run() {
                p.q(p.this);
            }
        });
    }

    public final void r(final boolean isDone) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.filter.m
            @Override // java.lang.Runnable
            public final void run() {
                p.s(p.this, isDone);
            }
        });
    }
}
