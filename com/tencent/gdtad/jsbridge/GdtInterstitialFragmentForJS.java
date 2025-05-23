package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.toast.AdToast;
import com.tencent.biz.richframework.compat.f;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.api.GdtAdError;
import com.tencent.gdtad.api.interstitial.GdtInterstitialParams;
import com.tencent.gdtad.api.interstitial.IGdtInterstitialAPI;
import com.tencent.gdtad.api.interstitial.IGdtInterstitialAd;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtInterstitialFragmentForJS extends QPublicBaseFragment {
    private static final String KEY_PARAMS = "params";
    private static final String TAG = "GdtInterstitialFragmentForJS";
    private IGdtInterstitialAd interstitialAd;

    @NonNull
    private GdtInterstitialParams interstitialParams = new GdtInterstitialParams();

    @NonNull
    private GdtAdLoader.Listener loadListener = new d();
    private GdtAdLoader loader;
    private GdtAdError loaderError;

    @Nullable
    private qq_ad_get.QQAdGet requestParams;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (GdtInterstitialFragmentForJS.this.loader == null) {
                GdtAdLoader.Session session = new GdtAdLoader.Session();
                session.request = GdtInterstitialFragmentForJS.this.requestParams;
                GdtInterstitialFragmentForJS.this.loader = new GdtAdLoader(session, new WeakReference(GdtInterstitialFragmentForJS.this.loadListener));
                GdtInterstitialFragmentForJS.this.loader.load(new WeakReference<>(GdtInterstitialFragmentForJS.this.getActivity()));
                str = "loading ad data";
            } else {
                str = "load ad data error";
            }
            AdToast.getInstance().show(GdtInterstitialFragmentForJS.this.getActivity().getApplicationContext(), 0, str, 0);
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
            String str;
            String str2;
            EventCollector.getInstance().onViewClickedBefore(view);
            GdtInterstitialFragmentForJS.this.interstitialParams.orientation = GdtInterstitialFragmentForJS.getScreenOrientation(GdtInterstitialFragmentForJS.this.getActivity());
            if (GdtInterstitialFragmentForJS.this.loader == null) {
                str2 = "ad is not loaded";
                AdToast.getInstance().show(GdtInterstitialFragmentForJS.this.getActivity().getApplicationContext(), 1, "ad is not loaded", 0);
            } else if (GdtInterstitialFragmentForJS.this.loaderError == null) {
                str2 = "ad is loading";
            } else if (GdtInterstitialFragmentForJS.this.loaderError.getErrorCode() != 0) {
                str2 = GdtInterstitialFragmentForJS.this.loaderError.getErrorMessage();
            } else {
                if (GdtInterstitialFragmentForJS.this.interstitialAd.show(GdtInterstitialFragmentForJS.this.getActivity())) {
                    str = "\u6b63\u5728\u6253\u5f00\u63d2\u5c4f";
                } else {
                    str = "\u6253\u5f00\u63d2\u5c4f\u9519\u8bef";
                }
                str2 = str;
            }
            AdToast.getInstance().show(GdtInterstitialFragmentForJS.this.getActivity().getApplicationContext(), 0, str2, 0);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ JSONObject f109244d;

        c(JSONObject jSONObject) {
            this.f109244d = jSONObject;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            EventCollector.getInstance().onViewClickedBefore(view);
            GdtInterstitialFragmentForJS.this.interstitialParams.orientation = GdtInterstitialFragmentForJS.getScreenOrientation(GdtInterstitialFragmentForJS.this.getActivity());
            if (GdtInterstitialFragmentForJS.this.loader == null) {
                str2 = "ad is not loaded";
                AdToast.getInstance().show(GdtInterstitialFragmentForJS.this.getActivity().getApplicationContext(), 1, "ad is not loaded", 0);
            } else if (GdtInterstitialFragmentForJS.this.loaderError == null) {
                str2 = "ad is loading";
            } else if (GdtInterstitialFragmentForJS.this.loaderError.getErrorCode() != 0) {
                str2 = GdtInterstitialFragmentForJS.this.loaderError.getErrorMessage();
            } else {
                GdtInterstitialFragmentForJS.this.interstitialAd.setAntiSpamParamsForDisplayOnReportServer(this.f109244d);
                if (GdtInterstitialFragmentForJS.this.interstitialAd.show(GdtInterstitialFragmentForJS.this.getActivity())) {
                    str = "\u6b63\u5728\u6253\u5f00\u63d2\u5c4f";
                } else {
                    str = "\u6253\u5f00\u63d2\u5c4f\u9519\u8bef";
                }
                str2 = str;
            }
            AdToast.getInstance().show(GdtInterstitialFragmentForJS.this.getActivity().getApplicationContext(), 0, str2, 0);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class d implements GdtAdLoader.Listener {
        d() {
        }

        @Override // com.tencent.gdtad.aditem.GdtAdLoader.Listener
        public void onResponse(@Nullable GdtAdLoader gdtAdLoader) {
            int i3;
            int i16;
            int i17 = Integer.MIN_VALUE;
            if (gdtAdLoader == null || gdtAdLoader.getSession() == null) {
                i3 = Integer.MIN_VALUE;
                i16 = Integer.MIN_VALUE;
            } else {
                long j3 = gdtAdLoader.getSession().timeMillis;
                int i18 = gdtAdLoader.getSession().ssoResponseCode;
                if (gdtAdLoader.getSession().response == null) {
                    i3 = Integer.MIN_VALUE;
                    i16 = Integer.MIN_VALUE;
                } else {
                    i16 = gdtAdLoader.getSession().response.ret.get();
                    if (i16 == 0 && gdtAdLoader.getSession().response.pos_ads_info.size() > 0 && (i17 = gdtAdLoader.getSession().response.pos_ads_info.get(0).ret.get()) == 0 && gdtAdLoader.getSession().response.pos_ads_info.get(0).ads_info.size() > 0) {
                        GdtInterstitialFragmentForJS.this.interstitialParams.clickOptions.f108486ad = new GdtAd(gdtAdLoader.getSession().response.pos_ads_info.get(0).ads_info.get(0));
                        GdtInterstitialFragmentForJS.this.interstitialParams.adInfoJson = GdtInterstitialFragmentForJS.this.interstitialParams.clickOptions.f108486ad.toString();
                        GdtInterstitialFragmentForJS.this.interstitialAd = ((IGdtInterstitialAPI) QRoute.api(IGdtInterstitialAPI.class)).build(GdtInterstitialFragmentForJS.this.getActivity(), GdtInterstitialFragmentForJS.this.interstitialParams);
                    }
                    i3 = i17;
                }
                i17 = i18;
            }
            GdtInterstitialFragmentForJS gdtInterstitialFragmentForJS = GdtInterstitialFragmentForJS.this;
            GdtInterstitialFragmentForJS.this.loaderError = new GdtAdError(gdtInterstitialFragmentForJS.getErrorCode(gdtInterstitialFragmentForJS.interstitialParams.clickOptions.f108486ad, i17, i16, i3));
            AdToast.getInstance().show(GdtInterstitialFragmentForJS.this.getActivity().getApplicationContext(), 0, String.format("on response:%s", GdtInterstitialFragmentForJS.this.loaderError.getErrorMessage()), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getScreenOrientation(@NonNull Activity activity) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i3 = displayMetrics.widthPixels;
        int i16 = displayMetrics.heightPixels;
        if (((rotation != 0 && rotation != 2) || i16 <= i3) && ((rotation != 1 && rotation != 3) || i3 <= i16)) {
            if (rotation != 0) {
                if (rotation != 1) {
                    if (rotation == 2) {
                        return 8;
                    }
                    if (rotation != 3) {
                        GdtLog.e(TAG, "Unknown screen orientation. Defaulting to landscape.");
                    }
                    return 9;
                }
                return 1;
            }
            return 0;
        }
        if (rotation != 0) {
            if (rotation != 1) {
                if (rotation != 2) {
                    if (rotation == 3) {
                        return 8;
                    }
                    GdtLog.e(TAG, "Unknown screen orientation. Defaulting to portrait.");
                }
                return 9;
            }
            return 0;
        }
        return 1;
    }

    public static void start(@Nullable Activity activity, Class<? extends QPublicFragmentActivity> cls, @Nullable JSONObject jSONObject) {
        if (activity != null && jSONObject != null) {
            GdtLog.i(TAG, "start");
            Bundle bundle = new Bundle();
            bundle.putString("params", jSONObject.toString());
            Intent intent = new Intent();
            intent.putExtra("public_fragment_window_feature", 1);
            intent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
            intent.putExtras(bundle);
            QPublicFragmentActivity.b.b(activity, intent, cls, GdtInterstitialFragmentForJS.class);
            return;
        }
        GdtLog.i(TAG, "start error");
    }

    protected int getErrorCode(@Nullable GdtAd gdtAd, int i3, int i16, int i17) {
        if (i3 == Integer.MIN_VALUE) {
            return 3;
        }
        if (i3 != 200) {
            return 6;
        }
        if (i16 != 0) {
            if (i16 != 1) {
                return 6;
            }
            return 4;
        }
        if (i17 != 0) {
            if (i17 != 102006) {
                return 6;
            }
            return 5;
        }
        if (gdtAd == null || !gdtAd.isValid()) {
            return 1;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @androidx.annotation.NonNull Class cls) {
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
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        String str;
        GdtLog.i(TAG, String.format("onActivityResult requestCode:%d resultCode:%d", Integer.valueOf(i3), Integer.valueOf(i16)));
        if (i3 == 10001) {
            IGdtInterstitialAd iGdtInterstitialAd = this.interstitialAd;
            if (iGdtInterstitialAd != null) {
                iGdtInterstitialAd.onClose(getActivity(), i16, intent);
            }
            if (i16 == -1) {
                str = "on closed";
            } else {
                str = "on closed error";
            }
            AdToast.getInstance().show(getActivity().getApplicationContext(), 0, str, 0);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LinearLayout linearLayout;
        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).initGdtContext(getContext(), new InitGdtContextParams());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key1", "value1");
            jSONObject.put("key2", "value2");
        } catch (Throwable th5) {
            GdtLog.e(TAG, "onCreateView", th5);
        }
        if (getArguments() == null) {
            linearLayout = null;
        } else {
            try {
                JSONObject jSONObject2 = new JSONObject(getArguments().getString("params"));
                JSONObject jSONObject3 = jSONObject2.getJSONObject("requestParams");
                JSONObject jSONObject4 = jSONObject2.getJSONObject("clickParams");
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("options", jSONObject4);
                this.requestParams = (qq_ad_get.QQAdGet) qq_ad_get.QQAdGet.class.cast(GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGet(), jSONObject3));
                GdtHandler.Options options = new GdtHandler.Options();
                GdtHandler.fillOptions(options, jSONObject5.toString());
                this.interstitialParams.clickOptions = options;
            } catch (JSONException e16) {
                GdtLog.e(TAG, "createParams error", e16);
            }
            Button button = new Button(getActivity());
            button.setText("load");
            button.setOnClickListener(new a());
            Button button2 = new Button(getActivity());
            button2.setText("show");
            button2.setOnClickListener(new b());
            Button button3 = new Button(getActivity());
            button3.setText("show - close after 5s");
            button3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.gdtad.jsbridge.GdtInterstitialFragmentForJS.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    String str2;
                    EventCollector.getInstance().onViewClickedBefore(view);
                    GdtInterstitialFragmentForJS.this.interstitialParams.orientation = GdtInterstitialFragmentForJS.getScreenOrientation(GdtInterstitialFragmentForJS.this.getActivity());
                    if (GdtInterstitialFragmentForJS.this.loader == null) {
                        str2 = "ad is not loaded";
                        AdToast.getInstance().show(GdtInterstitialFragmentForJS.this.getActivity().getApplicationContext(), 1, "ad is not loaded", 0);
                    } else if (GdtInterstitialFragmentForJS.this.loaderError == null) {
                        str2 = "ad is loading";
                    } else if (GdtInterstitialFragmentForJS.this.loaderError.getErrorCode() != 0) {
                        str2 = GdtInterstitialFragmentForJS.this.loaderError.getErrorMessage();
                    } else {
                        if (GdtInterstitialFragmentForJS.this.interstitialAd.show(GdtInterstitialFragmentForJS.this.getActivity())) {
                            str = "\u6b63\u5728\u6253\u5f00\u63d2\u5c4f";
                        } else {
                            str = "\u6253\u5f00\u63d2\u5c4f\u9519\u8bef";
                        }
                        str2 = str;
                        AdThreadManager.getInstance().postDelayed(new Runnable() { // from class: com.tencent.gdtad.jsbridge.GdtInterstitialFragmentForJS.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                GdtInterstitialFragmentForJS.this.interstitialAd.close(GdtInterstitialFragmentForJS.this.getActivity());
                            }
                        }, 0, 5000L);
                    }
                    AdToast.getInstance().show(GdtInterstitialFragmentForJS.this.getActivity().getApplicationContext(), 0, str2, 0);
                    EventCollector.getInstance().onViewClicked(view);
                }
            });
            Button button4 = new Button(getActivity());
            button4.setText("show with antiSpamTestParams");
            button4.setOnClickListener(new c(jSONObject));
            LinearLayout linearLayout2 = new LinearLayout(getActivity());
            linearLayout2.setBackgroundColor(Color.parseColor("#DBDBDB"));
            linearLayout2.setOrientation(1);
            linearLayout2.addView(button);
            linearLayout2.addView(button2);
            linearLayout2.addView(button3);
            linearLayout2.addView(button4);
            linearLayout = linearLayout2;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, linearLayout);
        return linearLayout;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
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
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @androidx.annotation.NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
