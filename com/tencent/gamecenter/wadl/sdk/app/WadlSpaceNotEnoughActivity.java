package com.tencent.gamecenter.wadl.sdk.app;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.richframework.compat.f;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import mqq.app.MobileQQ;
import ne0.a;

/* compiled from: P */
/* loaded from: classes6.dex */
public class WadlSpaceNotEnoughActivity extends QPublicBaseFragment implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener {
    public static final String TAG = "Wadl_WadlSpaceNotEnoughActivity";
    private WadlParams wadlParams;
    private final int whichOn = 1;
    private int lastWhich = 0;
    private QQCustomDialog alertDialog = null;

    private void finish() {
        QLog.i(TAG, 1, "finish...");
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            activity.finish();
        }
    }

    private Intent getIntent() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity.getIntent();
        }
        QLog.e(TAG, 1, "Fragment.getActivity() is null when calling getIntent()");
        return new Intent();
    }

    private void showDialog() {
        this.wadlParams = (WadlParams) getIntent().getParcelableExtra(WadlProxyConsts.PARAM_DOWNLOAD_INFO);
        QLog.d(TAG, 1, "showDialog wadlParams=" + this.wadlParams);
        FragmentActivity activity = getActivity();
        if (this.wadlParams != null && activity != null) {
            String qqStr = HardCodeUtil.qqStr(R.string.f214775tt);
            String qqStr2 = HardCodeUtil.qqStr(R.string.f214785tu);
            String qqStr3 = HardCodeUtil.qqStr(R.string.vje);
            String qqStr4 = HardCodeUtil.qqStr(R.string.vjd);
            try {
                QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230);
                this.alertDialog = createCustomDialog;
                createCustomDialog.setTitle(qqStr);
                this.alertDialog.setCanceledOnTouchOutside(false);
                this.alertDialog.setOnDismissListener(this);
                this.alertDialog.setMessage(qqStr2);
                this.alertDialog.setNegativeButton(qqStr3, this);
                this.alertDialog.setPositiveButton(qqStr4, this);
                this.alertDialog.show();
                return;
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "showDialog exception", th5);
                return;
            }
        }
        finish();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        activity.overridePendingTransition(0, 0);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i3) {
        this.lastWhich = i3;
        if (i3 == 1) {
            WadlParams wadlParams = this.wadlParams;
            wadlParams.ignoreSpace = 1;
            if (wadlParams.isRes) {
                WadlProxyServiceUtil.getProxyService().doDownloadResAction(this.wadlParams);
            } else {
                WadlProxyServiceUtil.getProxyService().doDownloadAction(this.wadlParams);
            }
        }
        dialogInterface.dismiss();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        QLog.d(TAG, 1, "onCreateView...processName=" + MobileQQ.processName);
        showDialog();
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        QLog.d(TAG, 1, "onDismiss...");
        finish();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return a.f(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return a.c(this, str, cls);
    }
}
