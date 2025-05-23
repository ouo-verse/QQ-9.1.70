package com.tencent.mobileqq.wink.editor.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004R\u0017\u0010\u000f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/view/e;", "", "", "progress", "", "e", "b", "", "c", "d", "a", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Landroid/animation/ValueAnimator;", "Landroid/animation/ValueAnimator;", "animator", "", "Ljava/lang/String;", "PAG_PATH", "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "dialog", "<init>", "(Landroid/content/Context;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ValueAnimator animator;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String PAG_PATH;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QCircleCommonLoadingDialog dialog;

    public e(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.PAG_PATH = "wink/pag/editor_loading_img_wezone.pag";
    }

    private final void e(int progress) {
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this.dialog;
        if (qCircleCommonLoadingDialog != null) {
            qCircleCommonLoadingDialog.setProgress(progress);
        }
    }

    public final void a() {
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this.dialog;
        if (qCircleCommonLoadingDialog != null) {
            qCircleCommonLoadingDialog.dismiss();
        }
    }

    public final void b() {
        QCircleCommonLoadingDialog.c cVar = new QCircleCommonLoadingDialog.c(this.context);
        cVar.p(this.context.getResources().getString(R.string.f215775wi));
        ImageView imageView = null;
        this.dialog = cVar.n(false).i(this.PAG_PATH).j("libtemplate").e(null).a();
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.animator = null;
        e(0);
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this.dialog;
        if (qCircleCommonLoadingDialog != null) {
            imageView = qCircleCommonLoadingDialog.i0();
        }
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public final boolean c() {
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this.dialog;
        if (qCircleCommonLoadingDialog != null) {
            return qCircleCommonLoadingDialog.isShowing();
        }
        return false;
    }

    public final void d() {
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog;
        if (!c() && (qCircleCommonLoadingDialog = this.dialog) != null) {
            qCircleCommonLoadingDialog.show();
        }
    }
}
