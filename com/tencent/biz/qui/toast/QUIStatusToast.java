package com.tencent.biz.qui.toast;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.quicommon.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qui.quiblurview.QQBlurViewWrapper;
import com.tencent.qui.quiblurview.c;
import com.tencent.qui.quiblurview.f;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 +2\u00020\u0001:\u0001,B\u000f\u0012\u0006\u0010(\u001a\u00020\r\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016R\"\u0010\u0011\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0014R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006-"}, d2 = {"Lcom/tencent/biz/qui/toast/QUIStatusToast;", "Landroid/app/Dialog;", "", "O", "", "tips", "P", "", "resId", "setIcon", "show", "dismiss", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/ref/WeakReference;", "activityRef", "Landroid/widget/ImageView;", "D", "Landroid/widget/ImageView;", "bgIv", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "tipsView", UserInfo.SEX_FEMALE, "iconView", "Lcom/tencent/qui/quiblurview/QQBlurViewWrapper;", "G", "Lcom/tencent/qui/quiblurview/QQBlurViewWrapper;", "blurView", "Landroid/os/Handler;", "H", "Landroid/os/Handler;", "mainHandler", "Ljava/lang/Runnable;", "I", "Ljava/lang/Runnable;", "removeRunnable", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Landroid/app/Activity;)V", "J", "a", "QUIToast_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final class QUIStatusToast extends ReportDialog {

    /* renamed from: C, reason: from kotlin metadata */
    private final WeakReference<Activity> activityRef;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView bgIv;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView tipsView;

    /* renamed from: F, reason: from kotlin metadata */
    private ImageView iconView;

    /* renamed from: G, reason: from kotlin metadata */
    private QQBlurViewWrapper blurView;

    /* renamed from: H, reason: from kotlin metadata */
    private final Handler mainHandler;

    /* renamed from: I, reason: from kotlin metadata */
    private final Runnable removeRunnable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QUIStatusToast(@NotNull Activity activity) {
        super(activity, R.style.DialogNoBackground);
        Intrinsics.checkNotNullParameter(activity, "activity");
        WeakReference<Activity> weakReference = new WeakReference<>(activity);
        this.activityRef = weakReference;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.removeRunnable = new Runnable() { // from class: com.tencent.biz.qui.toast.QUIStatusToast$removeRunnable$1
            @Override // java.lang.Runnable
            public final void run() {
                WeakReference weakReference2;
                weakReference2 = QUIStatusToast.this.activityRef;
                Activity activity2 = (Activity) weakReference2.get();
                if (activity2 != null && !activity2.isFinishing() && !activity2.isDestroyed() && QUIStatusToast.this.isShowing()) {
                    QUIStatusToast.this.dismiss();
                }
            }
        };
        if (weakReference.get() != null) {
            Window window = getWindow();
            if (window != null) {
                window.setFlags(16, 16);
            }
            Window window2 = getWindow();
            if (window2 != null) {
                window2.setFlags(8, 8);
            }
            Window window3 = getWindow();
            if (window3 != null) {
                window3.setGravity(17);
            }
            setContentView(R.layout.hg9);
            setCancelable(true);
            this.bgIv = (ImageView) findViewById(R.id.f99195p5);
            this.tipsView = (TextView) findViewById(R.id.toast_msg);
            this.iconView = (ImageView) findViewById(R.id.toast_icon);
            this.blurView = (QQBlurViewWrapper) findViewById(R.id.f99175p3);
            O();
        }
    }

    private final void O() {
        Activity activity = this.activityRef.get();
        if (activity != null) {
            Intrinsics.checkNotNullExpressionValue(activity, "activityRef.get() ?: return");
            if (Build.VERSION.SDK_INT >= 31 && c.f363628c.b(activity)) {
                ImageView imageView = this.bgIv;
                if (imageView != null) {
                    imageView.setBackgroundResource(R.drawable.qui_status_toast_blur_bg);
                }
                e.o(this.blurView, 12);
                QQBlurViewWrapper qQBlurViewWrapper = this.blurView;
                if (qQBlurViewWrapper != null) {
                    qQBlurViewWrapper.a(new f.a(true, e.c(10.0f), this.bgIv, 0, new ColorDrawable(0), null));
                }
            }
        }
    }

    public final void P(@Nullable String tips) {
        TextView textView = this.tipsView;
        if (textView != null) {
            textView.setText(tips);
        }
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.mainHandler.removeCallbacks(this.removeRunnable);
        super.dismiss();
    }

    public final void setIcon(int resId) {
        ImageView imageView = this.iconView;
        if (imageView != null) {
            imageView.setImageDrawable(ie0.a.f().o(imageView.getContext(), resId, R.color.qui_common_icon_allwhite_primary, 1001));
        }
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        if (this.activityRef.get() != null) {
            super.show();
            this.mainHandler.removeCallbacks(this.removeRunnable);
            this.mainHandler.postDelayed(this.removeRunnable, 3000L);
        }
    }
}
