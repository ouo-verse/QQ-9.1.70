package com.tencent.mobileqq.wink.editor.hdr;

import android.animation.ValueAnimator;
import android.content.Context;
import androidx.annotation.FloatRange;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \b2\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010*\u001a\u00020)\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0014\u0010\f\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0006\u0010\r\u001a\u00020\u0004J\u0010\u0010\u0010\u001a\u00020\u00042\b\b\u0001\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0018R\u0016\u0010\u001e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0018R\u0017\u0010\"\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010 \u001a\u0004\b\u001d\u0010!R\u0016\u0010%\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010$R\u0014\u0010(\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/hdr/k;", "", "", "tip", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/Runnable;", "runnable", "i", "Lkotlin/Function0;", "", "function", "g", "f", "", "progress", "k", "j", "d", "Landroid/animation/ValueAnimator;", "a", "Landroid/animation/ValueAnimator;", "animator", "b", "Ljava/lang/String;", "detectText", "c", "hdrText", "currentTipText", "e", "needShowText", "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "()Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "dialog", "", "J", "lastUpdateTipTimeStamp", tl.h.F, "Ljava/lang/Runnable;", "updateTipRunnable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ValueAnimator animator;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String detectText;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String hdrText;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String currentTipText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String needShowText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QCircleCommonLoadingDialog dialog;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long lastUpdateTipTimeStamp;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable updateTipRunnable;

    public k(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(R.string.f239507mn);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026_editor_hdr_detector_tip)");
        this.detectText = string;
        String string2 = context.getString(R.string.f239567mt);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.wink_editor_hdr_tip)");
        this.hdrText = string2;
        this.currentTipText = string;
        this.needShowText = string;
        QCircleCommonLoadingDialog a16 = new QCircleCommonLoadingDialog.c(context).n(false).p(string).j("image_enhance").a();
        Intrinsics.checkNotNullExpressionValue(a16, "Builder(context)\n       \u2026nhance\")\n        .build()");
        this.dialog = a16;
        this.updateTipRunnable = new Runnable() { // from class: com.tencent.mobileqq.wink.editor.hdr.i
            @Override // java.lang.Runnable
            public final void run() {
                k.n(k.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean h(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return (Boolean) tmp0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(float f16, k this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (f16 >= 1.0f) {
            this$0.m(this$0.hdrText);
        }
    }

    private final void m(String tip) {
        long coerceAtLeast;
        w53.b.a("WinkHDRProgressDialog", "tip = " + tip + ", progress = " + this.dialog.k0() + ", isShowing = " + this.dialog.isShowing());
        if (!Intrinsics.areEqual(tip, this.currentTipText) && !Intrinsics.areEqual(tip, this.needShowText)) {
            this.needShowText = tip;
            w53.b.a("WinkHDRProgressDialog", "in updateTip needShowText = " + tip + ", progress = " + this.dialog.k0() + ", currentTipText = " + this.currentTipText);
            ThreadManager.getUIHandler().removeCallbacks(this.updateTipRunnable);
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(1500 - (System.currentTimeMillis() - this.lastUpdateTipTimeStamp), 0L);
            ThreadManager.getUIHandler().postDelayed(this.updateTipRunnable, coerceAtLeast);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(k this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(this$0.currentTipText, this$0.needShowText)) {
            return;
        }
        this$0.lastUpdateTipTimeStamp = System.currentTimeMillis();
        String str = this$0.needShowText;
        this$0.currentTipText = str;
        w53.b.a("WinkHDRProgressDialog", "in updateTipRunnable needShowText = " + str + ", progress = " + this$0.dialog.k0() + ", currentTipText = " + this$0.currentTipText);
        this$0.dialog.J0(this$0.currentTipText);
    }

    public final void d() {
        this.dialog.dismiss();
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final QCircleCommonLoadingDialog getDialog() {
        return this.dialog;
    }

    public final void f() {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public final void g(@NotNull final Function0<Boolean> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        this.dialog.r0(new Callable() { // from class: com.tencent.mobileqq.wink.editor.hdr.h
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean h16;
                h16 = k.h(Function0.this);
                return h16;
            }
        });
    }

    public final void i(@NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.dialog.s0(runnable);
    }

    public final void j() {
        this.dialog.show();
    }

    public final void k(@FloatRange(from = 0.0d, to = 1.0d) final float progress) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.hdr.j
            @Override // java.lang.Runnable
            public final void run() {
                k.l(progress, this);
            }
        });
    }
}
