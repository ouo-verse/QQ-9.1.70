package com.tencent.mobileqq.tvideo.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.QAdRewardFragment;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pw2.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ&\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/tvideo/base/QFSVideoRewardAdFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "onBackEvent", "needStatusTrans", "needImmersive", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "TAG", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/QAdRewardFragment;", "D", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/QAdRewardFragment;", "getFragment", "()Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/QAdRewardFragment;", "setFragment", "(Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/QAdRewardFragment;)V", "fragment", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class QFSVideoRewardAdFragment extends QPublicBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String TAG = "[QAd]QFSVideoRewardAdFragment";

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private QAdRewardFragment fragment;

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        QAdRewardFragment qAdRewardFragment = this.fragment;
        if (qAdRewardFragment != null) {
            qAdRewardFragment.onBackPressed();
            return true;
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.e_u, container, false);
        VideoReport.addToDetectionWhitelist(getHostActivity());
        VideoReport.setPageId(getActivity(), QAdVrReport.ReportEvent.PAGE_AD_REWARD);
        VideoReport.setPageParams(getActivity(), gy2.c.f(getTAG(), null));
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        boolean z16;
        FragmentManager supportFragmentManager;
        FragmentTransaction beginTransaction;
        FragmentTransaction add;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        FragmentActivity activity = getActivity();
        boolean z17 = true;
        if (activity != null && activity.isFinishing()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            FragmentActivity activity2 = getActivity();
            if (activity2 == null || !activity2.isDestroyed()) {
                z17 = false;
            }
            if (!z17) {
                QAdRewardFragment qAdRewardFragment = new QAdRewardFragment();
                qAdRewardFragment.ph(this);
                qAdRewardFragment.setArguments(getArguments());
                FragmentActivity activity3 = getActivity();
                if (activity3 != null && (supportFragmentManager = activity3.getSupportFragmentManager()) != null && (beginTransaction = supportFragmentManager.beginTransaction()) != null && (add = beginTransaction.add(qAdRewardFragment, "[RewardAd]QAdRewardFragment")) != null) {
                    add.commit();
                }
                this.fragment = qAdRewardFragment;
                return;
            }
        }
        n.e(this.TAG, "activity is finish");
    }
}
