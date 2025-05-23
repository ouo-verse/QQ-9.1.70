package com.tencent.mobileqq.qqecommerce.base.plugin;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.richframework.compat.f;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.auto.engine.event.ASEngineEnterEvent;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.util.LoadingUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;

/* loaded from: classes35.dex */
public class ECPluginLoadingFragment extends QPublicBaseFragment implements SimpleEventReceiver {
    private Dialog mProgressDialog;

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissDialog() {
        Dialog dialog = this.mProgressDialog;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.mProgressDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchCancel() {
        ASEngineEnterEvent aSEngineEnterEvent = new ASEngineEnterEvent(ASEngineConstants.BusinessKey.BUSINESS_FLASH_SHOW);
        aSEngineEnterEvent.setCancel(true);
        SimpleEventBus.getInstance().dispatchEvent(aSEngineEnterEvent);
    }

    private void showProgress() {
        if (this.mProgressDialog == null) {
            Dialog showLoadingDialog = LoadingUtil.showLoadingDialog(getActivity(), HardCodeUtil.qqStr(R.string.f183703jw), false);
            this.mProgressDialog = showLoadingDialog;
            showLoadingDialog.setOnKeyListener(new a());
        }
        if (this.mProgressDialog.isShowing() || getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        this.mProgressDialog.show();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(ASEngineEnterEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        SystemBarCompact systemBarComp;
        super.onCreate(bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
        if (ImmersiveUtils.isSupporImmersive() != 0 && (systemBarComp = SystemBarActivityModule.getSystemBarComp((QPublicFragmentActivity) getActivity())) != null) {
            systemBarComp.init();
            systemBarComp.setStatusBarColor(getResources().getColor(R.color.ajr));
        }
        showProgress();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if ((simpleBaseEvent instanceof ASEngineEnterEvent) && ((ASEngineEnterEvent) simpleBaseEvent).getBusinessKey().equals(ASEngineConstants.BusinessKey.BUSINESS_ECOMMERCE)) {
            com.tencent.mobileqq.auto.engine.loader.a.e(ASEngineConstants.BusinessKey.BUSINESS_ECOMMERCE).B(true);
            dismissDialog();
            if (getActivity() != null) {
                getActivity().finish();
                getActivity().overridePendingTransition(0, 0);
            }
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class a implements DialogInterface.OnKeyListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
            if (i3 != 4 || keyEvent.getAction() != 0) {
                return true;
            }
            ECPluginLoadingFragment.this.dismissDialog();
            ECPluginLoadingFragment.this.dispatchCancel();
            if (ECPluginLoadingFragment.this.getActivity() == null) {
                return true;
            }
            ECPluginLoadingFragment.this.getActivity().finish();
            return true;
        }
    }
}
