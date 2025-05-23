package com.tencent.gdtad.api.halfscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ad.tangram.AdClickLocationParams;
import com.tencent.ad.tangram.downloader.AdDownloadConstants;
import com.tencent.ad.tangram.halfScreenDownload.AdHalfScreenDownload;
import com.tencent.ad.tangram.json.AdJSONUtil;
import com.tencent.ad.tangram.util.AdSafeUtil;
import com.tencent.ad.tangram.util.AdStatusBarUtil;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityForTool;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtHalfScreenDownloadFragment extends QPublicBaseFragment {
    private com.tencent.gdtad.api.halfscreen.a C;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    private static class a implements i {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<GdtHalfScreenDownloadFragment> f108539a;

        public a(WeakReference<GdtHalfScreenDownloadFragment> weakReference) {
            this.f108539a = weakReference;
        }

        @Override // com.tencent.gdtad.api.halfscreen.i
        public void a() {
            GdtHalfScreenDownloadFragment gdtHalfScreenDownloadFragment;
            WeakReference<GdtHalfScreenDownloadFragment> weakReference = this.f108539a;
            if (weakReference != null) {
                gdtHalfScreenDownloadFragment = weakReference.get();
            } else {
                gdtHalfScreenDownloadFragment = null;
            }
            if (gdtHalfScreenDownloadFragment != null) {
                gdtHalfScreenDownloadFragment.finish();
            } else {
                GdtLog.e("GdtHalfScreenDownloadFragment", "[closeView] error");
            }
        }

        @Override // com.tencent.gdtad.api.halfscreen.i
        public Activity getActivity() {
            GdtHalfScreenDownloadFragment gdtHalfScreenDownloadFragment;
            WeakReference<GdtHalfScreenDownloadFragment> weakReference = this.f108539a;
            if (weakReference != null) {
                gdtHalfScreenDownloadFragment = weakReference.get();
            } else {
                gdtHalfScreenDownloadFragment = null;
            }
            if (gdtHalfScreenDownloadFragment == null) {
                GdtLog.e("GdtHalfScreenDownloadFragment", "[getActivity] fragment error");
                return null;
            }
            return gdtHalfScreenDownloadFragment.getQBaseActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        final FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
            AdSafeUtil.safeRun(new Runnable() { // from class: com.tencent.gdtad.api.halfscreen.c
                @Override // java.lang.Runnable
                public final void run() {
                    activity.overridePendingTransition(0, R.anim.f154430r);
                }
            }, "GdtHalfScreenDownloadFragment", "finish");
        }
    }

    private e rh() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            GdtLog.e("GdtHalfScreenDownloadFragment", "[initData] arguments is null");
            finish();
            return null;
        }
        e eVar = new e();
        eVar.f108565b = vh(arguments.getString("adInfo"));
        eVar.f108566c = (AdClickLocationParams) arguments.getParcelable("clickLocation");
        eVar.f108568e = arguments.getLong("startTimeMillis");
        if (wm0.b.m().p()) {
            eVar.f108564a = arguments.getBundle("extrasForIntent");
        } else {
            eVar.f108564a = arguments;
        }
        eVar.f108567d = new WeakReference<>(getActivity());
        return eVar;
    }

    private WindowManager.LayoutParams sh() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -1, 99, 256, -2);
        if (Build.VERSION.SDK_INT >= 28) {
            layoutParams.layoutInDisplayCutoutMode = 1;
        }
        return layoutParams;
    }

    public static void uh(AdHalfScreenDownload.Params params) {
        String adJSONUtil;
        if (params != null && params.isValid()) {
            GdtLog.i("GdtHalfScreenDownloadFragment", "[start] GdtBaseHalfScreenFragment");
            Intent intent = new Intent();
            intent.putExtra("big_brother_source_key", AdDownloadConstants.DOWNLOAD_SOURCE_AD);
            intent.putExtra("public_fragment_window_feature", 1);
            intent.putExtra("clickLocation", params.clickLocationParams);
            GdtAd gdtAd = (GdtAd) params.f61320ad;
            Object pbToJson = GdtJsonPbUtil.pbToJson(gdtAd.info);
            Activity activity = null;
            if (AdJSONUtil.isObjectNull(pbToJson) && (pbToJson instanceof JSONObject)) {
                adJSONUtil = null;
            } else {
                adJSONUtil = AdJSONUtil.toString((JSONObject) pbToJson);
            }
            intent.putExtra("adInfo", adJSONUtil);
            Bundle bundle = params.extrasForIntent;
            if (bundle != null && !bundle.isEmpty()) {
                intent.putExtras(params.extrasForIntent);
                if (wm0.b.m().p()) {
                    intent.putExtra("extrasForIntent", params.extrasForIntent);
                }
            }
            if (TextUtils.isEmpty(intent.getStringExtra(LaunchParam.KEY_REF_ID))) {
                GdtLog.e("GdtHalfScreenDownloadFragment", "[start] gdt empty refId");
            }
            com.tencent.gdtad.api.halfscreen.a.j(gdtAd, 4001065, WebViewConstants.WV.ENABLE_WEBAIO_SWITCH);
            intent.putExtra("startTimeMillis", System.currentTimeMillis());
            WeakReference<Activity> weakReference = params.weakActivity;
            if (weakReference != null) {
                activity = weakReference.get();
            }
            QPublicFragmentActivity.b.b(activity, intent, QPublicTransFragmentActivityForTool.class, GdtHalfScreenDownloadFragment.class);
            return;
        }
        GdtLog.e("GdtHalfScreenDownloadFragment", "[start] params error");
    }

    private GdtAd vh(String str) {
        try {
            return new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo) GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(str)));
        } catch (JSONException e16) {
            GdtLog.e("GdtHalfScreenDownloadFragment", "setPageDataUIParams", e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        if (activity == null) {
            GdtLog.e("GdtHalfScreenDownloadFragment", "activity is null");
            finish();
            return;
        }
        super.initWindowStyleAndAnimation(activity);
        Window window = activity.getWindow();
        if (window == null) {
            GdtLog.e("GdtHalfScreenDownloadFragment", "[initWindowStyleAndAnimation] window is null");
            finish();
            return;
        }
        window.setAttributes(sh());
        activity.overridePendingTransition(0, 0);
        if (window.getDecorView() == null) {
            GdtLog.e("GdtHalfScreenDownloadFragment", "[initWindowStyleAndAnimation] decorView is null");
            finish();
        } else {
            AdStatusBarUtil.setTransparent(window);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        GdtLog.i("GdtHalfScreenDownloadFragment", "[onCreate]: ");
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View g16;
        if (layoutInflater == null) {
            GdtLog.e("GdtHalfScreenDownloadFragment", "[onCreateView]: inflater is null");
            finish();
            g16 = null;
        } else {
            try {
                ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).initGdtContext(BaseApplication.getContext(), new InitGdtContextParams());
            } catch (Throwable th5) {
                GdtLog.e("GdtHalfScreenDownloadFragment", "[initData]", th5);
            }
            com.tencent.gdtad.api.halfscreen.a aVar = new com.tencent.gdtad.api.halfscreen.a(rh(), new a(new WeakReference(this)));
            this.C = aVar;
            g16 = aVar.g();
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, g16);
        return g16;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        com.tencent.gdtad.api.halfscreen.a aVar = this.C;
        if (aVar != null) {
            aVar.e();
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        com.tencent.gdtad.api.halfscreen.a aVar = this.C;
        if (aVar != null) {
            aVar.i();
        }
        super.onPause();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.tencent.gdtad.api.halfscreen.a aVar = this.C;
        if (aVar != null) {
            aVar.k();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        com.tencent.gdtad.api.halfscreen.a aVar = this.C;
        if (aVar != null) {
            aVar.l();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }
}
