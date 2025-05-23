package com.tencent.richframework.gallery.part;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.IAccountCallback;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0016\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R\u0017\u0010\u0012\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/richframework/gallery/part/AccountStatusPart;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "Lmqq/app/IAccountCallback;", "", "finishHost", "finishActivity", "", "Landroidx/fragment/app/Fragment;", "fragmentList", "", "canFinishActivityAfterFragmentFinish", "Lmqq/app/AppRuntime;", "newRuntime", "onAccountChanged", "onAccountChangeFailed", "Lmqq/app/Constants$LogoutReason;", "reason", "onLogout", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "Z", "getSwitch", "()Z", "<init>", "()V", "Companion", "qq-layer-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AccountStatusPart extends RFWLayerBasePart implements IAccountCallback {
    private final boolean switch;

    public AccountStatusPart() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("layer_account_status_open", true);
        this.switch = isSwitchOn;
        if (isSwitchOn) {
            MobileQQ.sMobileQQ.registerAccountCallback(this);
        }
    }

    private final boolean canFinishActivityAfterFragmentFinish(List<? extends Fragment> fragmentList) {
        for (Fragment fragment : fragmentList) {
            if (!Intrinsics.areEqual(fragment, getPartHost()) && fragment.getView() != null) {
                return false;
            }
        }
        return true;
    }

    private final void finishActivity() {
        RFWLog.i("AccountStatusPart", RFWLog.USR, "finishActivity");
        getActivity().finish();
        getActivity().overridePendingTransition(0, 0);
    }

    private final void finishHost() {
        RFWLog.i("AccountStatusPart", RFWLog.USR, "finishHost");
        if (getPartHost() instanceof Fragment) {
            Object partHost = getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            Fragment fragment = (Fragment) partHost;
            if (!fragment.isAdded()) {
                RFWLog.e("AccountStatusPart", RFWLog.USR, "hostFragment is not add");
                return;
            }
            FragmentTransaction beginTransaction = fragment.getParentFragmentManager().beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "hostFragment.parentFragm\u2026anager.beginTransaction()");
            beginTransaction.remove(fragment);
            beginTransaction.commitAllowingStateLoss();
            List<Fragment> fragments = fragment.getParentFragmentManager().getFragments();
            Intrinsics.checkNotNullExpressionValue(fragments, "hostFragment.parentFragmentManager.fragments");
            if (canFinishActivityAfterFragmentFinish(fragments)) {
                finishActivity();
                return;
            }
            return;
        }
        if (getPartHost() instanceof Activity) {
            finishActivity();
        } else {
            RFWLog.e("AccountStatusPart", RFWLog.USR, "unKnown partHost");
        }
    }

    @Override // mqq.app.IAccountCallback
    public void onAccountChanged(@Nullable AppRuntime newRuntime) {
        finishHost();
    }

    @Override // mqq.app.IAccountCallback
    public void onLogout(@Nullable Constants.LogoutReason reason) {
        finishHost();
    }

    @Override // mqq.app.IAccountCallback
    public void onAccountChangeFailed(@Nullable AppRuntime newRuntime) {
    }
}
