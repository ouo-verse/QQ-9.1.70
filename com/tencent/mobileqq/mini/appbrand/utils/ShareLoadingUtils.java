package com.tencent.mobileqq.mini.appbrand.utils;

import android.app.Activity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/mini/appbrand/utils/ShareLoadingUtils;", "", "()V", "TAG", "", "dialogRef", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "dismissShareProgressDialog", "", "showShareProgressDialog", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class ShareLoadingUtils {
    public static final ShareLoadingUtils INSTANCE = new ShareLoadingUtils();
    private static final String TAG = "ShareLoadingUtils";
    private static WeakReference<QQProgressDialog> dialogRef;

    ShareLoadingUtils() {
    }

    @JvmStatic
    public static final void dismissShareProgressDialog() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.utils.e
            @Override // java.lang.Runnable
            public final void run() {
                ShareLoadingUtils.dismissShareProgressDialog$lambda$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dismissShareProgressDialog$lambda$1() {
        QQProgressDialog qQProgressDialog;
        try {
            WeakReference<QQProgressDialog> weakReference = dialogRef;
            if (weakReference != null && (qQProgressDialog = weakReference.get()) != null) {
                qQProgressDialog.dismiss();
            }
            dialogRef = null;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "dismissShareProgressDialog exception=", e16);
        }
    }

    @JvmStatic
    public static final void showShareProgressDialog(final Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.utils.d
            @Override // java.lang.Runnable
            public final void run() {
                ShareLoadingUtils.showShareProgressDialog$lambda$0(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showShareProgressDialog$lambda$0(Activity activity) {
        QQProgressDialog qQProgressDialog;
        Intrinsics.checkNotNullParameter(activity, "$activity");
        try {
            WeakReference<QQProgressDialog> weakReference = dialogRef;
            if (weakReference != null && (qQProgressDialog = weakReference.get()) != null) {
                qQProgressDialog.dismiss();
            }
            QQProgressDialog qQProgressDialog2 = new QQProgressDialog(activity, activity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            dialogRef = new WeakReference<>(qQProgressDialog2);
            qQProgressDialog2.setMessage(R.string.pe_);
            qQProgressDialog2.show();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "showShareProgressDialog exception=", e16);
        }
    }
}
