package com.tencent.mobileqq.activity.qcircle.pad;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.richframework.recycler.QCircleMemoryManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.qcircle.QCircleFrame;
import com.tencent.mobileqq.activity.qcircle.utils.c;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.pad.e;
import com.tencent.mobileqq.pad.f;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class QCircleFunctionFragment extends QBaseFragment implements f {
    private FrameLayout C;
    private ViewGroup D;
    private boolean E = true;

    private QCircleFrame qh() {
        if (getActivity() != null) {
            for (Fragment fragment : getActivity().getSupportFragmentManager().getFragments()) {
                if (fragment instanceof MainFragment) {
                    return (QCircleFrame) ((MainFragment) fragment).getFrame(QCircleFrame.class);
                }
            }
            return null;
        }
        return null;
    }

    private void th() {
        Size size;
        if (!isAdded()) {
            return;
        }
        float g16 = e.g();
        boolean i3 = c.i();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int i16 = displayMetrics.widthPixels;
        int i17 = displayMetrics.heightPixels;
        if (i3) {
            size = new Size((int) (i16 * g16), i17);
        } else {
            size = new Size(i16, i17);
        }
        if (QCircleHostGlobalInfo.getQFunctionZoneSize() != null && QCircleHostGlobalInfo.getQFunctionZoneSize().equals(size)) {
            QLog.d("QCircleFunctionFragment", 1, "functionZoneSize is already set. saveSize=" + QCircleHostGlobalInfo.getQFunctionZoneSize() + ", functionZoneSize=" + size);
            return;
        }
        QLog.d("QCircleFunctionFragment", 1, "[setQFunctionZoneSize] QCircle show area size. W | " + size.getWidth() + ", H | " + size.getHeight());
        QCircleHostGlobalInfo.setQFunctionZoneSize(size);
    }

    private void uh() {
        if (this.C == null) {
            QLog.e(getTAG(), 1, "[setRootViewBackground] mRootView is null");
            return;
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_host_frame_layout_background", true);
        QLog.d(getTag(), 1, "[setRootViewBackground] configEnable:" + isSwitchOn);
        if (!isSwitchOn) {
            return;
        }
        this.C.setBackgroundColor(getResources().getColor(R.color.black));
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        th();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        QLog.d("QCircleFunctionFragment", 1, "onCreate: ");
        super.onCreate(bundle);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        QLog.d("QCircleFunctionFragment", 1, "onCreateView: ");
        th();
        this.C = (FrameLayout) layoutInflater.inflate(R.layout.g3l, (ViewGroup) null);
        uh();
        ph();
        FrameLayout frameLayout = this.C;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, frameLayout);
        return frameLayout;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QLog.d("QCircleFunctionFragment", 1, "onDestroy: ");
        sh();
        rh();
        QCircleHostGlobalInfo.setQFunctionZoneSize(null);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        QLog.d("QCircleFunctionFragment", 1, "onResume");
        super.onResume();
        QCircleFrame qh5 = qh();
        if (qh5 != null) {
            qh5.recoverFrame(this.C, false);
        }
        if (this.E) {
            QCircleMemoryManager.h();
            this.E = false;
        }
    }

    public void ph() {
        QCircleFrame qh5 = qh();
        if (qh5 == null) {
            QLog.d("QCircleFunctionFragment", 1, "[getPreloadDecorView] QCircleFrame is null. ");
            return;
        }
        ViewGroup viewGroup = (ViewGroup) qh5.getQCircleDecorView();
        this.D = viewGroup;
        if (viewGroup == null) {
            QLog.d("QCircleFunctionFragment", 1, "[getPreloadDecorView] decorView is null. ");
        } else if (this.C != null) {
            sh();
            this.C.addView(this.D, -1, -1);
        }
    }

    @Override // com.tencent.mobileqq.pad.f
    public boolean qOnBackPressed() {
        boolean z16;
        boolean z17;
        boolean z18;
        QCircleFrame qh5 = qh();
        if (QCirclePluginUtil.isSplitModeInnerBackClk() && qh5 != null && c.i()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (qh5 != null && !qh5.isQCircleTabSelected()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17 && !z16) {
            if (!QCirclePanelStateEvent.isCommentPanelShowing() && !QCirclePanelStateEvent.isSpecifiedPanelShowing(29) && !QCirclePanelStateEvent.isSpecifiedPanelShowing(21) && !QCirclePanelStateEvent.isSpecifiedPanelShowing(27) && !QCirclePanelStateEvent.isSpecifiedPanelShowing(36)) {
                z18 = false;
            } else {
                z18 = true;
            }
            if (z18 && c.i()) {
                if (qh5 != null) {
                    qh5.notifyBackPressed();
                }
                QLog.d("QCircleFunctionFragment", 1, "qOnBackPressed: innerBack return true");
                return true;
            }
            if (getActivity() != null && c.i()) {
                QLog.d("QCircleFunctionFragment", 1, "qOnBackPressed: return true, move back.");
                getActivity().moveTaskToBack(true);
                return true;
            }
            QLog.d("QCircleFunctionFragment", 1, "qOnBackPressed: return false");
            return false;
        }
        qh5.exitQCircleFragment();
        QLog.d("QCircleFunctionFragment", 1, "[qOnBackPressed] return false, exitQCircleFragment");
        return false;
    }

    public void rh() {
        this.D = null;
        this.C = null;
    }

    public void sh() {
        QLog.d("QCircleFunctionFragment", 1, "->removeDecorViewParent");
        ViewGroup viewGroup = this.D;
        if (viewGroup == null) {
            QLog.e("QCircleFunctionFragment", 1, "mDecorView == null");
        } else if (!(viewGroup.getParent() instanceof ViewGroup)) {
            QLog.e("QCircleFunctionFragment", 1, "mDecorView parent is not ViewGroup");
        } else {
            ((ViewGroup) this.D.getParent()).removeView(this.D);
        }
    }

    @Override // com.tencent.mobileqq.pad.f
    public void qOnNewIntent() {
    }
}
