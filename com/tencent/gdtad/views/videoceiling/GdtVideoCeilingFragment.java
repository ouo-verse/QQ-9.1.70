package com.tencent.gdtad.views.videoceiling;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ad.tangram.downloader.AdDownloadConstants;
import com.tencent.ad.tangram.protocol.link_report;
import com.tencent.ad.tangram.statistics.AdReporterForLinkEvent;
import com.tencent.ad.tangram.util.AdSafeUtil;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingFragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.gdtad.api.videocelling.IGdtVideoCellingAPI;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtVideoCeilingFragment extends PublicBaseFragment {

    @NonNull
    public static String D = "key_result_receiver";

    @NonNull
    public static String E = "key_ad_position";
    private GdtVideoCeilingView C;

    private void qh() {
        Intent intent;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        if (intent != null && intent.getBooleanExtra(QQBrowserActivity.EXTRA_FINISH_ANIMATION_UP_DOWN, false)) {
            activity.overridePendingTransition(0, R.anim.f154423k);
        }
    }

    protected static void rh(@NonNull GdtVideoCeilingData gdtVideoCeilingData) {
        Object pbToJson;
        try {
            if (gdtVideoCeilingData.getAd() != null && (pbToJson = GdtJsonPbUtil.pbToJson(gdtVideoCeilingData.getAd().info)) != null && !JSONObject.NULL.equals(pbToJson)) {
                gdtVideoCeilingData.getAd().info = (qq_ad_get.QQAdGetRsp.AdInfo) qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(pbToJson.toString())));
            }
        } catch (Exception e16) {
            QLog.e("GdtBaseVideoCeilingFragment", 1, e16, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void sh(Activity activity, Intent intent) {
        ((IGdtVideoCellingAPI) QRoute.api(IGdtVideoCellingAPI.class)).startActivity(activity, intent, GdtVideoCeilingFragment.class);
    }

    private static void th(@NonNull GdtVideoCeilingData gdtVideoCeilingData, Activity activity) {
        int i3;
        if (gdtVideoCeilingData != null && gdtVideoCeilingData.isValid()) {
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).initGdtContext(activity, new InitGdtContextParams());
            link_report.LinkReport.ReportBiz reportBiz = new link_report.LinkReport.ReportBiz();
            reportBiz.wv_progress = 2;
            if (gdtVideoCeilingData.getActionCode() == 502 && gdtVideoCeilingData.getAd() != null && !TextUtils.isEmpty(gdtVideoCeilingData.getAd().getUrlForRewardLandingPage())) {
                i3 = 14;
            } else {
                i3 = 4;
            }
            reportBiz.lp_type = i3;
            if (((IGdtAPI) QRoute.api(IGdtAPI.class)).isClickCgiUrlForTool(gdtVideoCeilingData.getWebUrl())) {
                reportBiz.click_req_type = 1;
            } else {
                reportBiz.click_req_type = 3;
            }
            reportBiz.act_code = gdtVideoCeilingData.getActionCode();
            AdReporterForLinkEvent.getInstance().reportAsync(activity, 4003001, gdtVideoCeilingData.getAd(), reportBiz, null);
        }
    }

    public static void uh(@Nullable final Activity activity, @Nullable GdtVideoCeilingData gdtVideoCeilingData, boolean z16, @Nullable Bundle bundle, @Nullable GdtHandler.Options options) {
        boolean z17;
        if (activity != null && gdtVideoCeilingData != null && gdtVideoCeilingData.isValid()) {
            GdtLog.i("GdtBaseVideoCeilingFragment", "start");
            Bundle bundle2 = new Bundle();
            if (bundle != null && !bundle.isEmpty()) {
                bundle2.putAll(bundle);
            }
            rh(gdtVideoCeilingData);
            bundle2.putSerializable("data", gdtVideoCeilingData);
            final Intent intent = new Intent();
            if (gdtVideoCeilingData.getAd() != null && gdtVideoCeilingData.getAd().getNocoId() != 0) {
                intent.putExtra("GdtNocoId", gdtVideoCeilingData.getAd().getNocoId());
            }
            intent.putExtra("public_fragment_window_feature", 1);
            intent.putExtra("big_brother_source_key", AdDownloadConstants.DOWNLOAD_SOURCE_AD);
            intent.putExtras(bundle2);
            intent.putExtra("WebReport_IS_H5", false);
            intent.putExtra("WebReport_TRACE_ID", gdtVideoCeilingData.getAd().getTraceId());
            if (!intent.hasExtra("WebReport_POS_ID")) {
                intent.putExtra("WebReport_POS_ID", gdtVideoCeilingData.getAd().getPosId());
            }
            intent.putExtra("WebReport_AD_ID", String.valueOf(gdtVideoCeilingData.getAd().getAId()));
            if (gdtVideoCeilingData.getAd() != null && !TextUtils.isEmpty(gdtVideoCeilingData.getAd().getUrlForRewardLandingPage())) {
                z17 = true;
            } else {
                z17 = false;
            }
            intent.putExtra("WebReport_HAS_REWARD_LANDING_PAGE", z17);
            intent.putExtra("app_market_deeplink", gdtVideoCeilingData.getAd().getAppMarketDeeplink());
            if (z16) {
                intent.putExtra(QQBrowserActivity.EXTRA_FINISH_ANIMATION_UP_DOWN, true);
            }
            if (gdtVideoCeilingData.getAd().getAppMarketPackageName() != null) {
                intent.putExtra("app_market_package_name", (String[]) gdtVideoCeilingData.getAd().getAppMarketPackageName().toArray(new String[0]));
            }
            if (TextUtils.isEmpty(intent.getStringExtra(LaunchParam.KEY_REF_ID))) {
                GdtLog.e("GdtBaseVideoCeilingFragment", "start gdt empty refId");
            }
            if (options != null) {
                intent.putExtra("key_options", options);
            }
            intent.putExtra("WebReport_ACT_CODE", gdtVideoCeilingData.getActionCode());
            intent.putExtra("WebReport_CLICK_TIME", System.currentTimeMillis());
            th(gdtVideoCeilingData, activity);
            AdSafeUtil.safeRun(new Runnable() { // from class: zm0.a
                @Override // java.lang.Runnable
                public final void run() {
                    GdtVideoCeilingFragment.sh(activity, intent);
                }
            }, "GdtBaseVideoCeilingFragment", "[start]");
            if (z16) {
                activity.overridePendingTransition(R.anim.f154424l, R.anim.f154442w);
                return;
            }
            return;
        }
        GdtLog.e("GdtBaseVideoCeilingFragment", "start error");
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void beforeFinish() {
        ResultReceiver resultReceiver;
        super.beforeFinish();
        Bundle arguments = getArguments();
        if (arguments != null && (resultReceiver = (ResultReceiver) arguments.getParcelable(D)) != null && this.C != null) {
            Bundle bundle = new Bundle();
            bundle.putLong(E, this.C.n());
            resultReceiver.send(-1, bundle);
        }
        qh();
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@Nullable Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        if (activity == null) {
            return;
        }
        activity.setRequestedOrientation(1);
        activity.getWindow().addFlags(1024);
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        GdtVideoCeilingView gdtVideoCeilingView = this.C;
        if (gdtVideoCeilingView != null && gdtVideoCeilingView.i()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.f168003oq, viewGroup, false);
        GdtVideoCeilingView gdtVideoCeilingView = (GdtVideoCeilingView) inflate.findViewById(R.id.f167103kv4);
        this.C = gdtVideoCeilingView;
        GdtUIUtils.setNightThemeByFrameLayout(gdtVideoCeilingView);
        this.C.w(bundle);
        if (getArguments() != null && (getArguments().getSerializable("data") instanceof GdtVideoCeilingData)) {
            this.C.setData((GdtVideoCeilingData) getArguments().getSerializable("data"));
        }
        if (getBaseActivity() != null && getBaseActivity().getWindow() != null) {
            getBaseActivity().getWindow().setSoftInputMode(16);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        GdtVideoCeilingView gdtVideoCeilingView = this.C;
        if (gdtVideoCeilingView != null) {
            gdtVideoCeilingView.x();
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        GdtVideoCeilingView gdtVideoCeilingView = this.C;
        if (gdtVideoCeilingView != null) {
            gdtVideoCeilingView.y();
        }
        qh();
        super.onPause();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        GdtVideoCeilingView gdtVideoCeilingView = this.C;
        if (gdtVideoCeilingView != null) {
            gdtVideoCeilingView.z();
        }
    }
}
