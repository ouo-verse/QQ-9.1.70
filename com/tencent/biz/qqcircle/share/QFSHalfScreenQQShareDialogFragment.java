package com.tencent.biz.qqcircle.share;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.qqcircle.beans.QFSFriendDialogInitBean;
import com.tencent.biz.qqcircle.bizparts.QFSSharePart;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.FragmentPartProvider;
import com.tencent.biz.richframework.part.IPartFragmentHost;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSHalfScreenQQShareDialogFragment extends ReportAndroidXDialogFragment implements IPartFragmentHost {
    private QFSFriendDialogInitBean C;

    private String getFeedId() {
        QFSFriendDialogInitBean qFSFriendDialogInitBean = this.C;
        if (qFSFriendDialogInitBean != null && qFSFriendDialogInitBean.getShareInfo() != null && this.C.getShareInfo().feed != null && !TextUtils.isEmpty(this.C.getShareInfo().feed.f398449id.get())) {
            return this.C.getShareInfo().feed.f398449id.get();
        }
        QLog.d("QFSHalfScreenQQShareDialogFragment", 4, "[getFeedId] return null");
        return "";
    }

    private void initArguments() {
        if (getArguments() != null && getArguments().containsKey("key_bundle_common_init_bean")) {
            this.C = (QFSFriendDialogInitBean) getArguments().getSerializable("key_bundle_common_init_bean");
        }
    }

    private ArrayList<com.tencent.mobileqq.multishare.action.c> ph() {
        ArrayList<com.tencent.mobileqq.multishare.action.c> arrayList = new ArrayList<>();
        QFSFriendDialogInitBean qFSFriendDialogInitBean = this.C;
        if (qFSFriendDialogInitBean != null && qFSFriendDialogInitBean.getShareInfo() != null && !RFSafeListUtils.isEmpty(this.C.getShareInfo().mSelectedUserList)) {
            return this.C.getShareInfo().mSelectedUserList;
        }
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @Nullable
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.tencent.biz.qqcircle.share.part.d(this.C));
        arrayList.add(new com.tencent.biz.qqcircle.share.part.c(ph()));
        arrayList.add(new QFSSharePart());
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost, com.qzone.publish.ui.controller.a
    public /* synthetic */ Activity getHostActivity() {
        return com.tencent.biz.richframework.part.a.a(this);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* synthetic */ Context getHostContext() {
        return com.tencent.biz.richframework.part.a.b(this);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    /* renamed from: getHostLifecycleOwner */
    public /* synthetic */ LifecycleOwner getLifecycleOwner() {
        return com.tencent.biz.richframework.part.a.c(this);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* synthetic */ Object getViewTagData() {
        return ne0.a.d(this);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        initArguments();
        new FragmentPartProvider(this).initProvider();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.az7);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (getDialog() != null && getDialog().getWindow() != null) {
            Window window = getDialog().getWindow();
            if (Build.MANUFACTURER.equals("HUAWEI")) {
                window.clearFlags(67108864);
                if (window.getDecorView() != null) {
                    window.getDecorView().setSystemUiVisibility(5380);
                }
            }
            if (Build.VERSION.SDK_INT <= 29) {
                window.setSoftInputMode(16);
                QLog.d("QFSHalfScreenQQShareDialogFragment", 1, "os version < Q, SoftInputMode set SOFT_INPUT_ADJUST_RESIZE.");
            } else {
                window.setSoftInputMode(48);
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 8388613;
            attributes.width = cx.a(400.0f);
            int instantScreenHeight = DisplayUtil.getInstantScreenHeight(getDialog().getContext());
            int e16 = cx.e(getDialog().getContext());
            attributes.height = e16;
            QLog.d("QFSHalfScreenQQShareDialogFragment", 1, "[onCreateView] instantScreenHeight =" + instantScreenHeight + ", screenHeight =" + e16);
            window.setAttributes(attributes);
            getDialog().setCanceledOnTouchOutside(true);
        }
        View inflate = layoutInflater.inflate(R.layout.gd7, viewGroup, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NonNull DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(31, getFeedId(), false));
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(31, getFeedId(), true));
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }

    @Override // com.tencent.biz.richframework.part.IPartFragmentHost
    @NotNull
    public Fragment getHostFragment() {
        return this;
    }
}
