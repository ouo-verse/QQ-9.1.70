package com.tencent.mobileqq.minigame.va.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityLandscape;
import com.tencent.mobileqq.minigame.va.ui.RestartConfirmHandler;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0002\u000e\u000fB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\r\u001a\u00020\nH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/minigame/va/ui/RestartConfirmHandler;", "", "()V", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "btnReceiver", "Landroid/content/BroadcastReceiver;", "confirmListener", "Lcom/tencent/mobileqq/minigame/va/ui/RestartConfirmHandler$ConfirmDialogListener;", "initReceiver", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "showConfirmDialog", "unInitReceiver", "Companion", "ConfirmDialogListener", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class RestartConfirmHandler {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String DIALOG_CLOSE_INTENT_ACTION = "com.tencent.mobileqq.minigame.va.ui.RestartConfirmHandler.dialog.close";
    private static final String NEGATIVE_CLICK_INTENT_ACTION = "com.tencent.mobileqq.minigame.va.ui.RestartConfirmHandler.negativeClick";
    private static final String POSITIVE_CLICK_INTENT_ACTION = "com.tencent.mobileqq.minigame.va.ui.RestartConfirmHandler.positiveClick";
    private static final String TAG = "MiniGameVARestartConfirmHandler";
    private Activity activity;
    private BroadcastReceiver btnReceiver;
    private ConfirmDialogListener confirmListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/minigame/va/ui/RestartConfirmHandler$Companion;", "", "()V", "DIALOG_CLOSE_INTENT_ACTION", "", "NEGATIVE_CLICK_INTENT_ACTION", "POSITIVE_CLICK_INTENT_ACTION", "TAG", "onDialogClose", "", "onNegativeClick", "onPositiveClick", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        public final void onDialogClose() {
            QLog.d(RestartConfirmHandler.TAG, 2, "onDialogClose");
            BaseApplication.getContext().sendBroadcast(new Intent(RestartConfirmHandler.DIALOG_CLOSE_INTENT_ACTION));
        }

        public final void onNegativeClick() {
            QLog.d(RestartConfirmHandler.TAG, 2, "onNegativeClick");
            BaseApplication.getContext().sendBroadcast(new Intent(RestartConfirmHandler.NEGATIVE_CLICK_INTENT_ACTION));
        }

        public final void onPositiveClick() {
            QLog.d(RestartConfirmHandler.TAG, 2, "onPositiveClick");
            BaseApplication.getContext().sendBroadcast(new Intent(RestartConfirmHandler.POSITIVE_CLICK_INTENT_ACTION));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/minigame/va/ui/RestartConfirmHandler$ConfirmDialogListener;", "", "onNegativeClick", "", "onPositiveClick", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public interface ConfirmDialogListener {
        void onNegativeClick();

        void onPositiveClick();
    }

    private final void initReceiver() {
        if (this.btnReceiver == null) {
            this.btnReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.minigame.va.ui.RestartConfirmHandler$initReceiver$1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    RestartConfirmHandler.ConfirmDialogListener confirmDialogListener;
                    RestartConfirmHandler.ConfirmDialogListener confirmDialogListener2;
                    QLog.d("MiniGameVARestartConfirmHandler", 2, "intent.action:" + (intent != null ? intent.getAction() : null));
                    if (Intrinsics.areEqual("com.tencent.mobileqq.minigame.va.ui.RestartConfirmHandler.negativeClick", intent != null ? intent.getAction() : null)) {
                        confirmDialogListener2 = RestartConfirmHandler.this.confirmListener;
                        if (confirmDialogListener2 != null) {
                            confirmDialogListener2.onNegativeClick();
                            return;
                        }
                        return;
                    }
                    if (Intrinsics.areEqual("com.tencent.mobileqq.minigame.va.ui.RestartConfirmHandler.positiveClick", intent != null ? intent.getAction() : null)) {
                        confirmDialogListener = RestartConfirmHandler.this.confirmListener;
                        if (confirmDialogListener != null) {
                            confirmDialogListener.onPositiveClick();
                            return;
                        }
                        return;
                    }
                    if (Intrinsics.areEqual("com.tencent.mobileqq.minigame.va.ui.RestartConfirmHandler.dialog.close", intent != null ? intent.getAction() : null)) {
                        RestartConfirmHandler.this.unInitReceiver();
                    }
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(NEGATIVE_CLICK_INTENT_ACTION);
            intentFilter.addAction(POSITIVE_CLICK_INTENT_ACTION);
            intentFilter.addAction(DIALOG_CLOSE_INTENT_ACTION);
            Activity activity = this.activity;
            if (activity != null) {
                activity.registerReceiver(this.btnReceiver, intentFilter);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void unInitReceiver() {
        BroadcastReceiver broadcastReceiver = this.btnReceiver;
        if (broadcastReceiver != null) {
            Activity activity = this.activity;
            if (activity != null) {
                activity.unregisterReceiver(broadcastReceiver);
            }
            this.btnReceiver = null;
        }
    }

    public final void onDestroy() {
        unInitReceiver();
        QLog.i(TAG, 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
    }

    public final void showConfirmDialog(Activity activity, ConfirmDialogListener confirmListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(confirmListener, "confirmListener");
        this.confirmListener = confirmListener;
        this.activity = activity;
        initReceiver();
        Intent intent = new Intent();
        intent.putExtra("public_fragment_window_feature", 1);
        QPublicFragmentActivity.b.b(activity, intent, QPublicTransFragmentActivityLandscape.class, ConfirmDialogFragment.class);
        activity.overridePendingTransition(0, 0);
    }
}
