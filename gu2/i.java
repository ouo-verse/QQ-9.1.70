package gu2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivityBehind;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.QADLandingPageInfo;
import com.tencent.mobileqq.tvideo.base.QFSVideoRewardAdFragment;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public class i extends hv2.h {
    @Nullable
    private FragmentActivity c(Context context) {
        FragmentActivity fragmentActivity;
        if (context instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) context;
        } else {
            Activity a16 = ev2.a.a();
            if (a16 instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) a16;
            } else {
                fragmentActivity = null;
            }
        }
        if (fragmentActivity == null) {
            n.e("[QAd]LandPageService", "activity is null");
            return null;
        }
        return fragmentActivity;
    }

    @Override // hv2.h
    public void a(Context context, QADLandingPageInfo qADLandingPageInfo) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("ad_land_page_info", qADLandingPageInfo);
        intent.putExtra("big_brother_source_key", "biz_src_ads_xsj");
        context.startActivity(QCircleHostLauncher.handleTVideoAdHybirdActivityIntent(context, qADLandingPageInfo.getUrl(), intent));
    }

    @Override // hv2.h
    public void b(Context context, Intent intent, Class<? extends Fragment> cls) {
        n.e("[QAd]LandPageService", "openAdPageByFragment");
        FragmentActivity c16 = c(context);
        if (c16 != null && intent != null) {
            if (!c16.isDestroyed() && !c16.isFinishing()) {
                intent.putExtra("public_fragment_window_feature", 1);
                QPublicFragmentActivity.b.b(c16, intent, QPublicFragmentActivityBehind.class, QFSVideoRewardAdFragment.class);
                return;
            } else {
                n.h("[QAd]LandPageService", "activity is destroyed, can't show reward ad.");
                return;
            }
        }
        n.h("[QAd]LandPageService", "currentActivity or intent is null, can't show reward ad.");
    }
}
