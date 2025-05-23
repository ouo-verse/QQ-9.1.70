package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ad.tangram.toast.AdToast;
import com.tencent.biz.richframework.compat.f;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.api.GdtAd;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForTool;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes6.dex */
abstract class GdtBaseBannerFragment extends QPublicBaseFragment {
    private static final String KEY_PARAMS = "params";
    private static final String TAG = "GdtBaseBannerFragment";
    protected LinearLayout containerView;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z16;
            String str;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (GdtBaseBannerFragment.this.getAd() != null) {
                z16 = GdtBaseBannerFragment.this.getAd().load(GdtBaseBannerFragment.this.getActivity());
            } else {
                z16 = false;
            }
            if (z16) {
                str = "loading ad data";
            } else {
                str = "load ad data error";
            }
            AdToast.getInstance().show(GdtBaseBannerFragment.this.getActivity().getApplicationContext(), 0, str, 0);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (GdtBaseBannerFragment.this.getAd() == null) {
                AdToast.getInstance().show(GdtBaseBannerFragment.this.getActivity().getApplicationContext(), 1, "error", 0);
            } else if (!GdtBaseBannerFragment.this.getAd().isLoaded()) {
                AdToast.getInstance().show(GdtBaseBannerFragment.this.getActivity().getApplicationContext(), 1, "ad is not loaded", 0);
            } else if (GdtBaseBannerFragment.this.getAd().isInvalidated()) {
                AdToast.getInstance().show(GdtBaseBannerFragment.this.getActivity().getApplicationContext(), 1, "ad is invalidated", 0);
            } else {
                GdtBaseBannerFragment.this.onShow();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public static void start(@Nullable Activity activity, @Nullable JSONObject jSONObject, Class<? extends GdtBaseBannerFragment> cls) {
        if (activity != null && jSONObject != null) {
            GdtLog.i(TAG, "start");
            Bundle bundle = new Bundle();
            bundle.putString("params", jSONObject.toString());
            Intent intent = new Intent();
            intent.putExtra("public_fragment_window_feature", 1);
            intent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
            intent.putExtras(bundle);
            QPublicFragmentActivity.b.b(activity, intent, QPublicFragmentActivityForTool.class, cls);
            return;
        }
        GdtLog.i(TAG, "start error");
    }

    protected abstract GdtAd getAd();

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@Nullable Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        if (activity == null) {
            return;
        }
        activity.getWindow().addFlags(1024);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
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
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ScrollView scrollView;
        if (getArguments() == null) {
            scrollView = null;
        } else {
            String string = getArguments().getString("params");
            try {
                JSONObject jSONObject = new JSONObject(string);
                JSONObject jSONObject2 = jSONObject.getJSONObject("requestParams");
                JSONObject jSONObject3 = jSONObject.getJSONObject("clickParams");
                boolean z16 = jSONObject3.getBoolean("reportForClick");
                boolean optBoolean = jSONObject3.optBoolean("videoCeilingSupported", false);
                qq_ad_get.QQAdGet qQAdGet = (qq_ad_get.QQAdGet) qq_ad_get.QQAdGet.class.cast(GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGet(), jSONObject2));
                GdtHandler.Params params = new GdtHandler.Params();
                params.activity = new WeakReference<>(getActivity());
                params.reportForClick = z16;
                Bundle bundle2 = new Bundle();
                params.extra = bundle2;
                bundle2.putString(LaunchParam.KEY_REF_ID, "biz_src_miniapp");
                params.videoCeilingSupportedIfNotInstalled = optBoolean;
                onInit(string, qQAdGet, params);
            } catch (JSONException e16) {
                GdtLog.e(TAG, "createParams error", e16);
            }
            Button button = new Button(getActivity());
            button.setText("load");
            button.setOnClickListener(new a());
            Button button2 = new Button(getActivity());
            button2.setText("show");
            button2.setOnClickListener(new b());
            LinearLayout linearLayout = new LinearLayout(getActivity());
            this.containerView = linearLayout;
            linearLayout.setBackgroundColor(Color.parseColor("#DBDBDB"));
            this.containerView.setOrientation(1);
            this.containerView.addView(button);
            this.containerView.addView(button2);
            scrollView = new ScrollView(getActivity());
            scrollView.addView(this.containerView);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, scrollView);
        return scrollView;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    protected abstract void onInit(String str, qq_ad_get.QQAdGet qQAdGet, GdtHandler.Params params);

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    protected abstract void onShow();

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
