package com.tencent.gdtad.views.wechat.kf.natives;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.protocol.link_report;
import com.tencent.ad.tangram.statistics.AdReporterForLinkEvent;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.ad.tangram.statistics.metric.AdMetricService;
import com.tencent.ad.tangram.util.AdNavigationBarUtil;
import com.tencent.ad.tangram.web.AdBrowser;
import com.tencent.ad.tangram.wechat.AdWXCustomerService;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.statistics.metric.d;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityForTool;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtWXCustomerServiceFragment extends QPublicBaseFragment {
    private volatile GdtAd C;
    private volatile long D = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
    private volatile Animator E;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AdWXCustomerService.Params f109744d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f109745e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ WeakReference f109746f;

        a(AdWXCustomerService.Params params, String str, WeakReference weakReference) {
            this.f109744d = params;
            this.f109745e = str;
            this.f109746f = weakReference;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i3;
            GdtWXCustomerServiceFragment gdtWXCustomerServiceFragment;
            EventCollector.getInstance().onViewClickedBefore(view);
            QLog.i("GdtWXCustomerServiceFragment", 1, "[createOnClickButtonListener][onClick] start");
            AdBrowser.Params params = new AdBrowser.Params();
            AdWXCustomerService.Params params2 = this.f109744d;
            params.activity = params2.waekActivity;
            params.f61348ad = params2.f61350ad;
            params.url = this.f109745e;
            params.extrasForIntent = params2.extrasForIntent;
            AdError show = AdBrowser.getInstance().show(params);
            if (show != null) {
                i3 = show.getErrorCode();
            } else {
                i3 = Integer.MIN_VALUE;
            }
            QLog.i("GdtWXCustomerServiceFragment", 1, "[createOnClickButtonListener][onClick] end, errorCode:" + i3);
            WeakReference weakReference = this.f109746f;
            if (weakReference != null) {
                gdtWXCustomerServiceFragment = (GdtWXCustomerServiceFragment) weakReference.get();
            } else {
                gdtWXCustomerServiceFragment = null;
            }
            if (gdtWXCustomerServiceFragment != null) {
                gdtWXCustomerServiceFragment.rh(0);
                gdtWXCustomerServiceFragment.vh(4001081, Integer.MIN_VALUE);
            } else {
                QLog.e("GdtWXCustomerServiceFragment", 1, "[createOnClickButtonListener][onClick] error, fragment is null");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WeakReference f109747d;

        b(WeakReference weakReference) {
            this.f109747d = weakReference;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GdtWXCustomerServiceFragment gdtWXCustomerServiceFragment;
            EventCollector.getInstance().onViewClickedBefore(view);
            WeakReference weakReference = this.f109747d;
            if (weakReference != null) {
                gdtWXCustomerServiceFragment = (GdtWXCustomerServiceFragment) weakReference.get();
            } else {
                gdtWXCustomerServiceFragment = null;
            }
            if (gdtWXCustomerServiceFragment == null) {
                QLog.e("GdtWXCustomerServiceFragment", 1, "[createOnClickCloseListener][onClick] error, fragment is null");
            } else {
                QLog.i("GdtWXCustomerServiceFragment", 1, "[createOnClickCloseListener][onClick]");
                gdtWXCustomerServiceFragment.rh(0);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int rh(int i3) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            d.c("GdtWXCustomerServiceFragment", "[close] error, activity is null, errorCode:" + i3, null, AdMetricID.Click.WXCustomerService.Natives.Fragment.CLOSE_FAILED, AdMetricID.Click.WXCustomerService.Natives.Fragment.CLOSE_FAILED_TIME_MILLIS, this.C, uh(), 1);
            return 1;
        }
        d.e("GdtWXCustomerServiceFragment", "[close] errorCode:" + i3, AdMetricID.Click.WXCustomerService.Natives.Fragment.CLOSE_SUCCESS, AdMetricID.Click.WXCustomerService.Natives.Fragment.CLOSE_SUCCESS_TIME_MILLIS, this.C, uh());
        activity.finish();
        return 0;
    }

    private static View.OnClickListener sh(WeakReference<GdtWXCustomerServiceFragment> weakReference, AdWXCustomerService.Params params) {
        if (params != null && params.isValid()) {
            String urlForLandingPage = params.f61350ad.getUrlForLandingPage();
            if (TextUtils.isEmpty(urlForLandingPage)) {
                QLog.e("GdtWXCustomerServiceFragment", 1, "[createOnClickButtonListener] error, url is empty, aid:" + params.f61350ad.getAId() + " traceId:" + params.f61350ad.getTraceId());
                return null;
            }
            return new a(params, urlForLandingPage, weakReference);
        }
        QLog.e("GdtWXCustomerServiceFragment", 1, "[createOnClickButtonListener] error, params is not valid");
        return null;
    }

    private static View.OnClickListener th(WeakReference<GdtWXCustomerServiceFragment> weakReference, AdWXCustomerService.Params params) {
        if (params != null && params.isValid()) {
            return new b(weakReference);
        }
        QLog.e("GdtWXCustomerServiceFragment", 1, "[createOnClickCloseListener] error, params is not valid");
        return null;
    }

    private long uh() {
        if (this.D == WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
            return WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        return System.currentTimeMillis() - this.D;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vh(int i3, int i16) {
        link_report.LinkReport.ReportBiz reportBiz = new link_report.LinkReport.ReportBiz();
        if (i16 >= 0) {
            reportBiz.cost_time = i16;
        }
        AdReporterForLinkEvent.getInstance().reportAsync(getContext(), i3, this.C, reportBiz, null);
    }

    public static int wh(AdWXCustomerService.Params params, long j3) {
        if (params == null || !params.isValid()) {
            return 4;
        }
        Ad ad5 = params.f61350ad;
        if (!(ad5 instanceof GdtAd)) {
            return 4;
        }
        GdtAd gdtAd = (GdtAd) ad5;
        Bundle bundle = new Bundle();
        Bundle bundle2 = params.extrasForIntent;
        if (bundle2 != null && !bundle2.isEmpty()) {
            bundle.putAll(params.extrasForIntent);
            bundle.putParcelable("EXTRAS", params.extrasForIntent);
        }
        bundle.putParcelable("AD", gdtAd);
        bundle.putLong("START_TIME_MILLIS", j3);
        Intent intent = new Intent();
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtras(bundle);
        QPublicFragmentActivity.b.b(params.waekActivity.get(), intent, QPublicTransFragmentActivityForTool.class, GdtWXCustomerServiceFragment.class);
        return 0;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void beforeFinish() {
        QLog.i("GdtWXCustomerServiceFragment", 1, "[beforeFinish]");
        vh(4001071, (int) uh());
        super.beforeFinish();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        if (activity == null) {
            QLog.e("GdtWXCustomerServiceFragment", 1, "[initWindowStyleAndAnimation] error, activity is null");
            return;
        }
        QLog.i("GdtWXCustomerServiceFragment", 1, "[initWindowStyleAndAnimation]");
        activity.overridePendingTransition(0, 0);
        AdNavigationBarUtil.setTransparent(activity.getWindow());
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
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        Bundle arguments = getArguments();
        View view = null;
        if (arguments == null) {
            d.d("GdtWXCustomerServiceFragment", "[onCreateView] error, arguments is null", null, AdMetricID.Click.WXCustomerService.Natives.Fragment.ON_CREATE_VIEW_FAILED, this.C, 1);
            rh(1);
        } else {
            Parcelable parcelable = arguments.getParcelable("EXTRAS");
            if (!arguments.containsKey("AD")) {
                d.d("GdtWXCustomerServiceFragment", "[onCreateView] error, arguments do not contains KEY_AD", null, AdMetricID.Click.WXCustomerService.Natives.Fragment.ON_CREATE_VIEW_FAILED, this.C, 1);
                rh(1);
            } else {
                this.C = (GdtAd) arguments.getParcelable("AD");
                if (this.C != null && this.C.isValid()) {
                    if (!arguments.containsKey("START_TIME_MILLIS")) {
                        d.c("GdtWXCustomerServiceFragment", "[onCreateView] error, arguments do not contains KEY_START_TIME_MILLIS", null, AdMetricID.Click.WXCustomerService.Natives.Fragment.ON_CREATE_VIEW_FAILED, AdMetricID.Click.WXCustomerService.Natives.Fragment.ON_CREATE_VIEW_FAILED_TIME_MILLIS, this.C, uh(), 1);
                        rh(1);
                    } else {
                        this.D = arguments.getLong("START_TIME_MILLIS");
                        if (this.D == WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
                            d.c("GdtWXCustomerServiceFragment", "[onCreateView] error, mStartTimeMillis not valid", null, AdMetricID.Click.WXCustomerService.Natives.Fragment.ON_CREATE_VIEW_FAILED, AdMetricID.Click.WXCustomerService.Natives.Fragment.ON_CREATE_VIEW_FAILED_TIME_MILLIS, this.C, uh(), 1);
                            rh(1);
                        } else {
                            AdWXCustomerService.Params params = new AdWXCustomerService.Params();
                            params.waekActivity = new WeakReference<>(getActivity());
                            params.f61350ad = this.C;
                            if (parcelable instanceof Bundle) {
                                bundle2 = (Bundle) parcelable;
                            } else {
                                bundle2 = null;
                            }
                            params.extrasForIntent = bundle2;
                            boolean isNowThemeIsNight = QQTheme.isNowThemeIsNight();
                            View a16 = com.tencent.gdtad.views.wechat.kf.natives.a.a(params, sh(new WeakReference(this), params), th(new WeakReference(this), params), isNowThemeIsNight);
                            if (a16 == null) {
                                d.c("GdtWXCustomerServiceFragment", "[onCreateView] error, rootView is null", null, AdMetricID.Click.WXCustomerService.Natives.Fragment.ON_CREATE_VIEW_FAILED, AdMetricID.Click.WXCustomerService.Natives.Fragment.ON_CREATE_VIEW_FAILED_TIME_MILLIS, this.C, uh(), 1);
                                rh(1);
                            } else {
                                Animator b16 = com.tencent.gdtad.views.wechat.kf.natives.a.b(a16, isNowThemeIsNight);
                                if (b16 == null) {
                                    d.c("GdtWXCustomerServiceFragment", "[onCreateView] error, rootViewAnimator is null", null, AdMetricID.Click.WXCustomerService.Natives.Fragment.ON_CREATE_VIEW_FAILED, AdMetricID.Click.WXCustomerService.Natives.Fragment.ON_CREATE_VIEW_FAILED_TIME_MILLIS, this.C, uh(), 1);
                                    rh(1);
                                } else {
                                    this.E = b16;
                                    view = a16;
                                }
                            }
                        }
                    }
                } else {
                    d.d("GdtWXCustomerServiceFragment", "[onCreateView] error, mAd is not valid", null, AdMetricID.Click.WXCustomerService.Natives.Fragment.ON_CREATE_VIEW_FAILED, this.C, 1);
                    rh(1);
                }
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        Context context;
        QLog.i("GdtWXCustomerServiceFragment", 1, "[onFinish]");
        if (getContext() != null) {
            context = getContext().getApplicationContext();
        } else {
            context = null;
        }
        AdMetricService.getInstance().flush(new WeakReference<>(context));
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.overridePendingTransition(0, 0);
        }
        super.onFinish();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        QLog.i("GdtWXCustomerServiceFragment", 1, "[onPause]");
        super.onPause();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QLog.i("GdtWXCustomerServiceFragment", 1, "[onResume]");
        if (this.E != null) {
            this.E.start();
            this.E = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        QLog.i("GdtWXCustomerServiceFragment", 1, "[onViewCreated]");
    }
}
