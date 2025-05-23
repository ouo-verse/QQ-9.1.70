package com.tencent.mobileqq.qqexpand.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqexpand.ipc.ExpandFlutterIPCClient;
import com.tencent.mobileqq.qqexpand.widget.m;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/fragment/ExpandBirthPickFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ExpandBirthPickFragment extends QPublicBaseFragment {

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/qqexpand/fragment/ExpandBirthPickFragment$b", "Lcom/tencent/mobileqq/qqexpand/widget/m$b;", "", "newBirthday", "", "onConfirm", "onCancel", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements m.b {
        b() {
        }

        @Override // com.tencent.mobileqq.qqexpand.widget.m.b
        public void onCancel() {
            FragmentActivity activity = ExpandBirthPickFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }

        @Override // com.tencent.mobileqq.qqexpand.widget.m.b
        public void onConfirm(int newBirthday) {
            ExpandFlutterIPCClient.g().f("METHOD_SET_BIRTH_DATE", new Bundle());
            FragmentActivity activity = ExpandBirthPickFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FrameLayout frameLayout = new FrameLayout(getQBaseActivity());
        frameLayout.setBackgroundColor(0);
        if (SystemBarActivityModule.getSystemBarComp(getQBaseActivity()) == null) {
            SystemBarActivityModule.setImmersiveStatus(getQBaseActivity(), 0);
        } else {
            SystemBarActivityModule.getSystemBarComp(getQBaseActivity()).setStatusBarDrawable(null);
            SystemBarActivityModule.getSystemBarComp(getQBaseActivity()).setStatusBarColor(0);
            SystemBarActivityModule.getSystemBarComp(getQBaseActivity()).setStatusColor(0);
        }
        QBaseActivity qBaseActivity = getQBaseActivity();
        Intrinsics.checkNotNullExpressionValue(qBaseActivity, "qBaseActivity");
        Bundle arguments = getArguments();
        m mVar = new m(qBaseActivity, arguments != null ? arguments.getInt("birth_date", 0) : 0, new b());
        if (QLog.isColorLevel()) {
            QLog.d("ExpandBirthPickFragment", 2, "showFillBirthdayDialog do show");
        }
        mVar.show();
        return frameLayout;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.overridePendingTransition(0, 0);
        }
        super.onPause();
    }
}
