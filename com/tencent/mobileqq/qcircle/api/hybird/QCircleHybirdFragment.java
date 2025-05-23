package com.tencent.mobileqq.qcircle.api.hybird;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ark.ark;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.IQCircleCommonUtil;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.ad;
import com.tencent.mobileqq.webview.swift.component.v;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.mobileqq.webview.view.WebBrowserViewContainerKt;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleHybirdFragment extends WebViewFragment {
    private static final String D = "QCircleHybirdFragment";
    private b C;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a extends com.tencent.mobileqq.webview.swift.proxy.a {
        a(t tVar) {
            super(tVar);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public int getCacheMode(ad adVar) {
            if (NetworkUtil.isNetworkAvailable(QCircleHybirdFragment.this.getActivity())) {
                return 2;
            }
            return super.getCacheMode(adVar);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onDataInit(Bundle bundle) {
            QCircleHybirdFragment.this.getUIStyleHandler().f314512m.Q = false;
            QCircleHybirdFragment.this.getUIStyleHandler().f314512m.f314631n = true;
            QCircleHybirdFragment.this.getUIStyleHandler().f314502d0 = QCircleHybirdFragment.this.getResource().getColor(R.color.cam, null);
            QCircleHybirdFragment.this.wh();
            super.onDataInit(bundle);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onFinalState(Bundle bundle) {
            super.onFinalState(bundle);
            if (QCircleHybirdFragment.this.getActivity().getRequestedOrientation() != 1) {
                QCircleHybirdFragment.this.getActivity().setRequestedOrientation(1);
            }
            QCircleHybirdFragment.this.getWebView().setVerticalScrollBarEnabled(false);
            QCircleHybirdFragment.this.getWebView().setHorizontalScrollBarEnabled(false);
            QCircleHybirdFragment.this.getWebView().getSettings().setDefaultTextEncodingName("utf-8");
            if (QCircleHybirdFragment.this.getUIStyleHandler() != null && QCircleHybirdFragment.this.getUIStyleHandler().U != null) {
                QCircleHybirdFragment.this.getUIStyleHandler().U.l(false);
            }
            ((WebViewFragment) QCircleHybirdFragment.this).webView.setMask(false);
            if (QCircleHybirdFragment.this.getActivity() != null) {
                QCircleHybirdFragment.this.C = new b(QCircleHybirdFragment.this);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("action_update_web_user_follow_state");
                intentFilter.addAction("action_update_web_tag_follow_state");
                QCircleHybirdFragment.this.getActivity().registerReceiver(QCircleHybirdFragment.this.C, intentFilter);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    private static class b extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<QCircleHybirdFragment> f261675a;

        public b(QCircleHybirdFragment qCircleHybirdFragment) {
            this.f261675a = new WeakReference<>(qCircleHybirdFragment);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            QCircleHybirdFragment qCircleHybirdFragment = this.f261675a.get();
            if (qCircleHybirdFragment != null && intent != null) {
                String action = intent.getAction();
                if (TextUtils.equals(action, "action_update_web_user_follow_state")) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("uin", intent.getStringExtra("uin"));
                        jSONObject.put("followstate", intent.getIntExtra("followstate", 0));
                        jSONObject.put("blackState", intent.getIntExtra("blackstate", 0));
                        if (qCircleHybirdFragment.getWebView() != null) {
                            qCircleHybirdFragment.getWebView().callJs(WebViewPlugin.toJsScript("updateQCircleFollowState", jSONObject, null));
                            return;
                        }
                        return;
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                        return;
                    }
                }
                if (TextUtils.equals(action, "action_update_web_tag_follow_state")) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("tagId", intent.getStringExtra("tagId"));
                        jSONObject2.put("followstate", intent.getIntExtra("followstate", 0));
                        if (qCircleHybirdFragment.getWebView() != null) {
                            qCircleHybirdFragment.getWebView().callJs(WebViewPlugin.toJsScript("updateQCircleTagFollowState", jSONObject2, null));
                        }
                    } catch (Exception e17) {
                        QLog.e(QCircleHybirdFragment.D, 1, "update tag follow state error.", e17);
                    }
                }
            }
        }
    }

    private void setWebViewBackground() {
        int i3;
        int i16;
        int i17;
        int i18;
        if (getWebView() != null) {
            v uIStyleHandler = getUIStyleHandler();
            Resources resources = getResources();
            boolean isInNightMode = ((IQCircleCommonUtil) QRoute.api(IQCircleCommonUtil.class)).isInNightMode();
            int i19 = R.color.can;
            if (isInNightMode) {
                i3 = R.color.can;
            } else {
                i3 = R.color.cam;
            }
            uIStyleHandler.f314501c0 = resources.getColor(i3);
            if (getUIStyleHandler().f314500b0 != null) {
                getUIStyleHandler().f314500b0.setBackgroundColor(getUIStyleHandler().f314501c0);
            }
            if (getWebView().getX5WebViewExtension() != null) {
                try {
                    View view = getWebView().getView();
                    Resources resources2 = getResources();
                    if (((IQCircleCommonUtil) QRoute.api(IQCircleCommonUtil.class)).isInNightMode()) {
                        i16 = R.color.can;
                    } else {
                        i16 = R.color.cam;
                    }
                    view.setBackgroundColor(resources2.getColor(i16));
                    CustomWebView webView = getWebView();
                    Resources resources3 = getResources();
                    if (((IQCircleCommonUtil) QRoute.api(IQCircleCommonUtil.class)).isInNightMode()) {
                        i17 = R.color.can;
                    } else {
                        i17 = R.color.cam;
                    }
                    webView.setBackgroundColor(resources3.getColor(i17));
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            } else {
                CustomWebView webView2 = getWebView();
                Resources resources4 = getResources();
                if (((IQCircleCommonUtil) QRoute.api(IQCircleCommonUtil.class)).isInNightMode()) {
                    i18 = R.color.can;
                } else {
                    i18 = R.color.cam;
                }
                webView2.setBackgroundColor(resources4.getColor(i18));
            }
            WebBrowserViewContainerKt webBrowserViewContainerKt = this.contentView;
            if (webBrowserViewContainerKt != null) {
                Resources resources5 = getResources();
                if (!((IQCircleCommonUtil) QRoute.api(IQCircleCommonUtil.class)).isInNightMode()) {
                    i19 = R.color.cam;
                }
                webBrowserViewContainerKt.setBackgroundColor(resources5.getColor(i19));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wh() {
        VideoReport.addToDetectionWhitelist(getHostActivity());
        VideoReport.setPageId(getView(), ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).getQCircleDaTongBasePageId());
        View view = getView();
        IQCircleReportApi iQCircleReportApi = (IQCircleReportApi) QRoute.api(IQCircleReportApi.class);
        String str = D;
        VideoReport.setPageParams(view, iQCircleReportApi.buildPageParams(str));
        QLog.i(str, 1, "reportDaTongRegister  subPage: " + str);
    }

    public void Ah() {
        Intent intent = new Intent();
        intent.setAction("action_update_native_tag_follow_state");
        if (getHostActivity() != null) {
            getHostActivity().sendBroadcast(intent);
        }
        yh(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount());
    }

    public void Bh(String str, int i3, int i16, String str2) {
        Intent intent = new Intent();
        intent.setAction("action_update_native_user_follow_state");
        intent.putExtra("uin", str);
        intent.putExtra("nick", str2);
        intent.putExtra("type", i3);
        intent.putExtra("isDoubly", i16);
        if (getHostActivity() != null) {
            getHostActivity().sendBroadcast(intent);
        }
    }

    public void Ch(Intent intent) {
        Activity hostActivity = getHostActivity();
        if (hostActivity == null) {
            QLog.w(D, 1, "[sendNativeUserWearingMedalUpdateBroadcast] activity should not be null.");
        } else if (hostActivity.isFinishing()) {
            QLog.w(D, 1, "[sendNativeUserWearingMedalUpdateBroadcast] activity is finishing state, not send broadcast.");
        } else {
            hostActivity.sendBroadcast(intent);
        }
    }

    public void Dh(int i3) {
        Intent intent = new Intent();
        intent.setAction("action_clear_message_red_poiont");
        intent.putExtra(WadlProxyConsts.CREATE_TIME, i3);
        if (getHostActivity() != null) {
            getHostActivity().sendBroadcast(intent);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webview.swift.WebViewProvider
    public void doOnBackEvent() {
        super.doOnBackEvent();
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    public t getWebViewKernelCallBack() {
        return new a(this.webViewSurface);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setWebViewBackground();
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (getQBaseActivity() != null && this.C != null) {
            getQBaseActivity().unregisterReceiver(this.C);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    public void uh(String str) {
        QLog.d(D, 1, "QCircleRefreshIconDecorate handleRefreshIconDecorate iconConfigJson is:" + str);
        Intent intent = new Intent();
        intent.setAction("action_refresh_icon_decorate");
        intent.putExtra(ark.ARKMETADATA_JSON, str);
        if (getHostActivity() != null) {
            getHostActivity().sendBroadcast(intent);
        }
    }

    public void vh(String str) {
        QLog.d(D, 1, "QCircleRefreshPushEffect handleRefreshPushEffect iconConfigJson is:" + str);
        Intent intent = new Intent();
        intent.setAction("action_refresh_push_effect");
        intent.putExtra(ark.ARKMETADATA_JSON, str);
        if (getHostActivity() != null) {
            getHostActivity().sendBroadcast(intent);
        }
    }

    public void xh(String str) {
        Intent intent = new Intent();
        intent.setAction("action_refresh_feed_list");
        intent.putExtra("pageType", str);
        if (getHostActivity() != null) {
            getHostActivity().sendBroadcast(intent);
        }
    }

    public void yh(String str) {
        Intent intent = new Intent();
        intent.setAction("action_reload_get_main_page");
        intent.putExtra("uin", str);
        if (getHostActivity() != null) {
            getHostActivity().sendBroadcast(intent);
        }
    }

    public void zh(int i3, int i16, String str) {
        Intent intent = new Intent();
        intent.setAction("action_update_native_auth_info");
        intent.putExtra("type", i3);
        intent.putExtra("status", i16);
        intent.putExtra("tagName", str);
        if (getHostActivity() != null) {
            getHostActivity().sendBroadcast(intent);
        }
    }
}
