package com.tencent.state.square.detail;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.view.SquareLoadingDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u0006\u0010\u0012\u001a\u00020\u000eJ\b\u0010\u0013\u001a\u00020\u0010H\u0016J\u0006\u0010\u0014\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/square/detail/LoadingDialogTask;", "Ljava/lang/Runnable;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "fragment", "Lcom/tencent/state/VasBaseFragment;", "(Landroid/app/Activity;Lcom/tencent/state/VasBaseFragment;)V", "getActivity", "()Landroid/app/Activity;", "getFragment", "()Lcom/tencent/state/VasBaseFragment;", "loadingDialog", "Lcom/tencent/state/view/SquareLoadingDialog;", WadlProxyConsts.PARAM_TIME_OUT, "", "onShowDialog", "", "onTimeOut", "resultInTime", TencentLocation.RUN_MODE, "start", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class LoadingDialogTask implements Runnable {
    private final Activity activity;
    private final VasBaseFragment fragment;
    private SquareLoadingDialog loadingDialog;
    private boolean timeOut;

    public LoadingDialogTask(Activity activity, VasBaseFragment vasBaseFragment) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        this.fragment = vasBaseFragment;
    }

    private final void onShowDialog() {
        SquareLoadingDialog squareLoadingDialog;
        SquareBaseKt.getSquareLog().d(DetailFragmentLauncher.TAG, "showDialog");
        this.loadingDialog = new SquareLoadingDialog(this.activity, false);
        DetailFragmentLauncher detailFragmentLauncher = DetailFragmentLauncher.INSTANCE;
        Activity activity = this.activity;
        if (!(activity instanceof FragmentActivity)) {
            activity = null;
        }
        if (detailFragmentLauncher.isValidActivity((FragmentActivity) activity) && (squareLoadingDialog = this.loadingDialog) != null) {
            squareLoadingDialog.show();
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(this, 2000L);
    }

    private final void onTimeOut() {
        SquareBaseKt.getSquareLog().d(DetailFragmentLauncher.TAG, WadlProxyConsts.PARAM_TIME_OUT);
        this.timeOut = true;
        SquareLoadingDialog squareLoadingDialog = this.loadingDialog;
        if (squareLoadingDialog != null) {
            squareLoadingDialog.dismiss();
        }
        DetailFragmentLauncher.INSTANCE.showErrorTips(this.activity, this.fragment, WadlProxyConsts.PARAM_TIME_OUT);
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final VasBaseFragment getFragment() {
        return this.fragment;
    }

    public final boolean resultInTime() {
        SquareBaseKt.getSquareLog().d(DetailFragmentLauncher.TAG, "resultInTime:" + this.timeOut);
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this);
        SquareLoadingDialog squareLoadingDialog = this.loadingDialog;
        if (squareLoadingDialog != null) {
            squareLoadingDialog.dismiss();
        }
        return !this.timeOut;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.loadingDialog == null) {
            onShowDialog();
        } else {
            onTimeOut();
        }
    }

    public final void start() {
        ThreadManagerV2.getUIHandlerV2().postDelayed(this, 1000L);
    }
}
