package com.tencent.gdtad.kuikly.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.ad.tangram.statistics.metric.AdMetricService;
import com.tencent.ad.tangram.util.AdNavigationBarUtil;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.kuikly.GdtKuiklyRenderViewDelegate;
import com.tencent.gdtad.kuikly.fragment.a;
import com.tencent.gdtad.kuikly.receiver.GdtBaseKuiklyBroadcastReceiver;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.ProcessUtil;
import ht.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes6.dex */
public abstract class GdtBaseKuiklyFragment extends QPublicBaseFragment implements GdtKuiklyRenderViewDelegate.a {
    private String C;
    private String D;
    private int E = Integer.MIN_VALUE;
    private String F = null;
    private long G = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
    private boolean H = false;
    private final Handler I = new Handler(Looper.getMainLooper());
    private Runnable J;
    private volatile g K;
    private volatile GdtBaseKuiklyBroadcastReceiver L;

    private static Runnable rh(final WeakReference<GdtBaseKuiklyFragment> weakReference, final GdtAd gdtAd, final String str, final String str2, final long j3) {
        return new Runnable() { // from class: com.tencent.gdtad.kuikly.fragment.GdtBaseKuiklyFragment.1
            @Override // java.lang.Runnable
            public void run() {
                GdtBaseKuiklyFragment gdtBaseKuiklyFragment;
                long j16 = j3;
                long j17 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
                if (j16 != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
                    j17 = System.currentTimeMillis() - j3;
                }
                WeakReference weakReference2 = weakReference;
                if (weakReference2 != null) {
                    gdtBaseKuiklyFragment = (GdtBaseKuiklyFragment) weakReference2.get();
                } else {
                    gdtBaseKuiklyFragment = null;
                }
                if (gdtBaseKuiklyFragment == null) {
                    com.tencent.gdtad.kuikly.a.c("GdtBaseKuiklyFragment", "[createTimeoutRunnable][run] error, fragment is null", null, AdMetricID.Kuikly.Fragment.TIMEOUT_CALLBACK_FAILED, AdMetricID.Kuikly.Fragment.TIMEOUT_CALLBACK_FAILED_TIME_MILLIS, gdtAd, str, str2, j17, 1);
                } else {
                    com.tencent.gdtad.kuikly.a.h("GdtBaseKuiklyFragment", "[createTimeoutRunnable][run]", AdMetricID.Kuikly.Fragment.TIMEOUT_CALLBACK_SUCCESS, AdMetricID.Kuikly.Fragment.TIMEOUT_CALLBACK_SUCCESS_TIME_MILLIS, gdtAd, str, str2, j17);
                    gdtBaseKuiklyFragment.sh(13);
                }
            }
        };
    }

    private void xh(long j3) {
        QLog.i("GdtBaseKuiklyFragment", 1, "[postTimeoutCallback] delayTimeMillis:" + j3);
        this.I.postDelayed(this.J, j3);
    }

    private void yh() {
        QLog.i("GdtBaseKuiklyFragment", 1, "[removeTimeoutCallback]");
        this.I.removeCallbacks(this.J);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int zh(a.d dVar, Class<? extends QPublicFragmentActivity> cls, Class<? extends GdtBaseKuiklyFragment> cls2, Bundle bundle, int i3) {
        GdtAd gdtAd;
        String str;
        String str2 = null;
        if (dVar != null) {
            gdtAd = dVar.b();
        } else {
            gdtAd = null;
        }
        if (dVar != null) {
            str = dVar.i();
        } else {
            str = null;
        }
        if (dVar != null) {
            str2 = dVar.getPageName();
        }
        String str3 = str2;
        if (dVar != null && dVar.isValid()) {
            com.tencent.gdtad.kuikly.a.k("GdtBaseKuiklyFragment", "[start]", AdMetricID.Kuikly.Fragment.START_SUCCESS, gdtAd, str, str3);
            Bundle bundle2 = new Bundle();
            if (bundle != null && !bundle.isEmpty()) {
                bundle2.putAll(bundle);
            }
            bundle2.putString("PARAM_BUNDLE_NAME", dVar.i());
            bundle2.putString("PARAM_PAGE_NAME", dVar.getPageName());
            bundle2.putInt("PARAM_HASH_CODE", dVar.hashCode());
            bundle2.putString("PARAM_FROM_PROCESS_NAME", ProcessUtil.getCurrentProcessName(dVar.getActivity()));
            bundle2.putLong("PARAM_TIMEOUT_MILLIS", dVar.e());
            bundle2.putLong("PARAM_START_TIME_MILLIS", dVar.d());
            Intent intent = new Intent();
            intent.putExtra("public_fragment_window_feature", 1);
            intent.putExtras(bundle2);
            if (i3 >= 0) {
                QPublicFragmentActivity.b.e(dVar.getActivity(), intent, cls, cls2, i3);
                return 0;
            }
            QPublicFragmentActivity.b.b(dVar.getActivity(), intent, cls, cls2);
            return 0;
        }
        com.tencent.gdtad.kuikly.a.f("GdtBaseKuiklyFragment", "[start] error, not valid", null, AdMetricID.Kuikly.Fragment.START_FAILED, gdtAd, str, str3, 4);
        return 4;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void beforeFinish() {
        com.tencent.gdtad.kuikly.a.h("GdtBaseKuiklyFragment", "[beforeFinish]", AdMetricID.Kuikly.Fragment.BEFORE_FINISH, AdMetricID.Kuikly.Fragment.BEFORE_FINISH_TIME_MILLIS, uh(), this.C, this.D, vh());
        if (this.K != null) {
            this.K.onDetach();
        }
        if (this.L != null) {
            this.L.k(new WeakReference<>(getContext()));
        }
        super.beforeFinish();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        if (activity == null) {
            QLog.e("GdtBaseKuiklyFragment", 1, "[initWindowStyleAndAnimation] error, activity is null");
            return;
        }
        QLog.i("GdtBaseKuiklyFragment", 1, "[initWindowStyleAndAnimation]");
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
        FragmentActivity activity = getActivity();
        View view = null;
        if (activity == null) {
            com.tencent.gdtad.kuikly.a.c("GdtBaseKuiklyFragment", "[onCreateView] error, activity is empty", null, AdMetricID.Kuikly.Fragment.ON_CREATE_VIEW_FAILED, AdMetricID.Kuikly.Fragment.ON_CREATE_VIEW_FAILED_TIME_MILLIS, uh(), this.C, this.D, vh(), 1);
        } else {
            Bundle arguments = getArguments();
            if (arguments == null) {
                com.tencent.gdtad.kuikly.a.c("GdtBaseKuiklyFragment", "[onCreateView] error, arguments is empty", null, AdMetricID.Kuikly.Fragment.ON_CREATE_VIEW_FAILED, AdMetricID.Kuikly.Fragment.ON_CREATE_VIEW_FAILED_TIME_MILLIS, uh(), this.C, this.D, vh(), 1);
                qh(1);
            } else if (!arguments.containsKey("PARAM_BUNDLE_NAME")) {
                com.tencent.gdtad.kuikly.a.c("GdtBaseKuiklyFragment", "[onCreateView] error, arguments do not contains KEY_BUNDLE_NAME", null, AdMetricID.Kuikly.Fragment.ON_CREATE_VIEW_FAILED, AdMetricID.Kuikly.Fragment.ON_CREATE_VIEW_FAILED_TIME_MILLIS, uh(), this.C, this.D, vh(), 1);
                qh(1);
            } else {
                String string = arguments.getString("PARAM_BUNDLE_NAME");
                this.C = string;
                if (TextUtils.isEmpty(string)) {
                    com.tencent.gdtad.kuikly.a.c("GdtBaseKuiklyFragment", "[onCreateView] error, mBundleName is empty", null, AdMetricID.Kuikly.Fragment.ON_CREATE_VIEW_FAILED, AdMetricID.Kuikly.Fragment.ON_CREATE_VIEW_FAILED_TIME_MILLIS, uh(), this.C, this.D, vh(), 1);
                    qh(1);
                } else if (!arguments.containsKey("PARAM_PAGE_NAME")) {
                    com.tencent.gdtad.kuikly.a.c("GdtBaseKuiklyFragment", "[onCreateView] error, arguments do not contains KEY_PAGE_NAME", null, AdMetricID.Kuikly.Fragment.ON_CREATE_VIEW_FAILED, AdMetricID.Kuikly.Fragment.ON_CREATE_VIEW_FAILED_TIME_MILLIS, uh(), this.C, this.D, vh(), 1);
                    qh(1);
                } else {
                    String string2 = arguments.getString("PARAM_PAGE_NAME");
                    this.D = string2;
                    if (TextUtils.isEmpty(string2)) {
                        com.tencent.gdtad.kuikly.a.c("GdtBaseKuiklyFragment", "[onCreateView] error, mPageName is empty", null, AdMetricID.Kuikly.Fragment.ON_CREATE_VIEW_FAILED, AdMetricID.Kuikly.Fragment.ON_CREATE_VIEW_FAILED_TIME_MILLIS, uh(), this.C, this.D, vh(), 1);
                        qh(1);
                    } else if (!arguments.containsKey("PARAM_HASH_CODE")) {
                        com.tencent.gdtad.kuikly.a.c("GdtBaseKuiklyFragment", "[onCreateView] error, arguments do not contains KEY_HASH_CODE", null, AdMetricID.Kuikly.Fragment.ON_CREATE_VIEW_FAILED, AdMetricID.Kuikly.Fragment.ON_CREATE_VIEW_FAILED_TIME_MILLIS, uh(), this.C, this.D, vh(), 1);
                        qh(1);
                    } else {
                        int i3 = arguments.getInt("PARAM_HASH_CODE", Integer.MIN_VALUE);
                        this.E = i3;
                        if (i3 == Integer.MIN_VALUE) {
                            com.tencent.gdtad.kuikly.a.c("GdtBaseKuiklyFragment", "[onCreateView] error, hashCode not valid", null, AdMetricID.Kuikly.Fragment.ON_CREATE_VIEW_FAILED, AdMetricID.Kuikly.Fragment.ON_CREATE_VIEW_FAILED_TIME_MILLIS, uh(), this.C, this.D, vh(), 1);
                            qh(1);
                        } else if (!arguments.containsKey("PARAM_FROM_PROCESS_NAME")) {
                            com.tencent.gdtad.kuikly.a.c("GdtBaseKuiklyFragment", "[onCreateView] error, arguments do not contains KEY_FROM_PROCESS_NAME", null, AdMetricID.Kuikly.Fragment.ON_CREATE_VIEW_FAILED, AdMetricID.Kuikly.Fragment.ON_CREATE_VIEW_FAILED_TIME_MILLIS, uh(), this.C, this.D, vh(), 1);
                            qh(1);
                        } else {
                            String string3 = arguments.getString("PARAM_FROM_PROCESS_NAME");
                            this.F = string3;
                            if (TextUtils.isEmpty(string3)) {
                                com.tencent.gdtad.kuikly.a.c("GdtBaseKuiklyFragment", "[onCreateView] error, mFromProcessName is empty", null, AdMetricID.Kuikly.Fragment.ON_CREATE_VIEW_FAILED, AdMetricID.Kuikly.Fragment.ON_CREATE_VIEW_FAILED_TIME_MILLIS, uh(), this.C, this.D, vh(), 1);
                                qh(1);
                            } else if (!arguments.containsKey("PARAM_TIMEOUT_MILLIS")) {
                                com.tencent.gdtad.kuikly.a.c("GdtBaseKuiklyFragment", "[onCreateView] error, arguments do not contains KEY_TIMEOUT_MILLIS", null, AdMetricID.Kuikly.Fragment.ON_CREATE_VIEW_FAILED, AdMetricID.Kuikly.Fragment.ON_CREATE_VIEW_FAILED_TIME_MILLIS, uh(), this.C, this.D, vh(), 1);
                                qh(1);
                            } else {
                                long j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
                                long j16 = arguments.getLong("PARAM_TIMEOUT_MILLIS", WebViewConstants.WV.ENABLE_WEBAIO_SWITCH);
                                if (j16 <= 0) {
                                    com.tencent.gdtad.kuikly.a.c("GdtBaseKuiklyFragment", "[onCreateView] error, timeoutMillis:" + j16, null, AdMetricID.Kuikly.Fragment.ON_CREATE_VIEW_FAILED, AdMetricID.Kuikly.Fragment.ON_CREATE_VIEW_FAILED_TIME_MILLIS, uh(), this.C, this.D, vh(), 4);
                                    qh(4);
                                } else if (!arguments.containsKey("PARAM_START_TIME_MILLIS")) {
                                    com.tencent.gdtad.kuikly.a.c("GdtBaseKuiklyFragment", "[onCreateView] error, arguments do not contains KEY_START_TIME_MILLIS", null, AdMetricID.Kuikly.Fragment.ON_CREATE_VIEW_FAILED, AdMetricID.Kuikly.Fragment.ON_CREATE_VIEW_FAILED_TIME_MILLIS, uh(), this.C, this.D, vh(), 1);
                                    qh(1);
                                } else {
                                    long j17 = arguments.getLong("PARAM_START_TIME_MILLIS", WebViewConstants.WV.ENABLE_WEBAIO_SWITCH);
                                    this.G = j17;
                                    if (j17 == WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
                                        com.tencent.gdtad.kuikly.a.c("GdtBaseKuiklyFragment", "[onCreateView] error, mStartTimeMillis not valid", null, AdMetricID.Kuikly.Fragment.ON_CREATE_VIEW_FAILED, AdMetricID.Kuikly.Fragment.ON_CREATE_VIEW_FAILED_TIME_MILLIS, uh(), this.C, this.D, vh(), 1);
                                        qh(1);
                                    } else {
                                        long vh5 = vh();
                                        if (vh5 >= 0) {
                                            j3 = j16 - vh5;
                                        }
                                        if (j3 <= 0) {
                                            com.tencent.gdtad.kuikly.a.c("GdtBaseKuiklyFragment", "[onCreateView] error, timeout, timeoutMillis:" + j16 + " durationMillis:" + vh5 + " delayTimeMillis:" + j3, null, AdMetricID.Kuikly.Fragment.ON_CREATE_VIEW_FAILED, AdMetricID.Kuikly.Fragment.ON_CREATE_VIEW_FAILED_TIME_MILLIS, uh(), this.C, this.D, vh(), 13);
                                            sh(13);
                                        } else {
                                            GdtKuiklyRenderViewDelegate gdtKuiklyRenderViewDelegate = new GdtKuiklyRenderViewDelegate(uh(), new WeakReference(this), this.I, this.C, this.D);
                                            gdtKuiklyRenderViewDelegate.h(this.G);
                                            a.C10472a c10472a = new a.C10472a();
                                            c10472a.context = activity;
                                            c10472a.f406221a = gdtKuiklyRenderViewDelegate;
                                            ht.a aVar = new ht.a();
                                            aVar.createEngine(activity, null, null);
                                            aVar.createView(c10472a);
                                            if (!(c10472a.f406222b instanceof View)) {
                                                com.tencent.gdtad.kuikly.a.c("GdtBaseKuiklyFragment", "[onCreateView] error, kuiklyRenderView not instanceof View", null, AdMetricID.Kuikly.Fragment.ON_CREATE_VIEW_FAILED, AdMetricID.Kuikly.Fragment.ON_CREATE_VIEW_FAILED_TIME_MILLIS, uh(), this.C, this.D, vh(), 1);
                                                sh(1);
                                            } else {
                                                com.tencent.gdtad.kuikly.a.h("GdtBaseKuiklyFragment", "[onCreateView]", AdMetricID.Kuikly.Fragment.ON_CREATE_VIEW_SUCCESS, AdMetricID.Kuikly.Fragment.ON_CREATE_VIEW_SUCCESS_TIME_MILLIS, uh(), this.C, this.D, vh());
                                                this.J = rh(new WeakReference(this), uh(), this.C, this.D, this.G);
                                                xh(j3);
                                                this.K = c10472a.f406222b;
                                                this.L = ph(this.I);
                                                view = (View) this.K;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        Context context;
        QLog.i("GdtBaseKuiklyFragment", 1, "[onFinish]");
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

    @Override // com.tencent.gdtad.kuikly.GdtKuiklyRenderViewDelegate.a
    public int onLoadFailed(int i3) {
        QLog.i("GdtBaseKuiklyFragment", 1, "[onLoadFailed] errorCode:" + i3);
        return sh(i3);
    }

    @Override // com.tencent.gdtad.kuikly.GdtKuiklyRenderViewDelegate.a
    public int onLoadSuccess() {
        QLog.i("GdtBaseKuiklyFragment", 1, "[onLoadSuccess]");
        yh();
        return 0;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        QLog.i("GdtBaseKuiklyFragment", 1, "[onPause]");
        if (this.K != null) {
            this.K.onPause();
        }
        super.onPause();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QLog.i("GdtBaseKuiklyFragment", 1, "[onResume]");
        if (this.K != null) {
            this.K.onResume();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        try {
            String gdtAd = uh().toString();
            if (TextUtils.isEmpty(gdtAd)) {
                com.tencent.gdtad.kuikly.a.c("GdtBaseKuiklyFragment", "[onViewCreated] error, adInfoString is empty", null, AdMetricID.Kuikly.Fragment.ON_VIEW_CREATED_FAILED, AdMetricID.Kuikly.Fragment.ON_VIEW_CREATED_FAILED_TIME_MILLIS, uh(), this.C, this.D, vh(), 1);
                sh(1);
                return;
            }
            if (!(this.K instanceof View)) {
                com.tencent.gdtad.kuikly.a.c("GdtBaseKuiklyFragment", "[onViewCreated] error, mKuiklyRenderView not instanceof View", null, AdMetricID.Kuikly.Fragment.ON_VIEW_CREATED_FAILED, AdMetricID.Kuikly.Fragment.ON_VIEW_CREATED_FAILED_TIME_MILLIS, uh(), this.C, this.D, vh(), 1);
                sh(1);
                return;
            }
            if (this.L == null) {
                com.tencent.gdtad.kuikly.a.c("GdtBaseKuiklyFragment", "[onViewCreated] error, mBroadcastReceiver is empty", null, AdMetricID.Kuikly.Fragment.ON_VIEW_CREATED_FAILED, AdMetricID.Kuikly.Fragment.ON_VIEW_CREATED_FAILED_TIME_MILLIS, uh(), this.C, this.D, vh(), 1);
                sh(1);
                return;
            }
            com.tencent.gdtad.kuikly.a.h("GdtBaseKuiklyFragment", "[onViewCreated]", AdMetricID.Kuikly.Fragment.ON_VIEW_CREATED_SUCCESS, AdMetricID.Kuikly.Fragment.ON_VIEW_CREATED_SUCCESS_TIME_MILLIS, uh(), this.C, this.D, vh());
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("bundle_name", this.C);
            hashMap.put(QAdVrReport.ElementID.AD_INFO, gdtAd);
            th(hashMap);
            this.K.b(this.D, hashMap, null);
            ((View) this.K).setBackgroundColor(0);
            this.L.i(new WeakReference<>(getContext()));
        } catch (Throwable th5) {
            com.tencent.gdtad.kuikly.a.c("GdtBaseKuiklyFragment", "[onViewCreated]", th5, AdMetricID.Kuikly.Fragment.ON_VIEW_CREATED_FAILED, AdMetricID.Kuikly.Fragment.ON_VIEW_CREATED_FAILED_TIME_MILLIS, uh(), this.C, this.D, vh(), 1);
            sh(1);
        }
    }

    protected abstract GdtBaseKuiklyBroadcastReceiver ph(Handler handler);

    public int qh(int i3) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            com.tencent.gdtad.kuikly.a.c("GdtBaseKuiklyFragment", "[close] error, not on main thread, errorCode:" + i3, null, AdMetricID.Kuikly.Fragment.CLOSE_FAILED, AdMetricID.Kuikly.Fragment.CLOSE_FAILED_TIME_MILLIS, uh(), this.C, this.D, vh(), 22);
            return 22;
        }
        yh();
        FragmentActivity activity = getActivity();
        if (activity == null) {
            com.tencent.gdtad.kuikly.a.c("GdtBaseKuiklyFragment", "[close] error, activity is null, errorCode:" + i3, null, AdMetricID.Kuikly.Fragment.CLOSE_FAILED, AdMetricID.Kuikly.Fragment.CLOSE_FAILED_TIME_MILLIS, uh(), this.C, this.D, vh(), 1);
            return 1;
        }
        com.tencent.gdtad.kuikly.a.h("GdtBaseKuiklyFragment", "[close] errorCode:" + i3, AdMetricID.Kuikly.Fragment.CLOSE_SUCCESS, AdMetricID.Kuikly.Fragment.CLOSE_SUCCESS_TIME_MILLIS, uh(), this.C, this.D, vh());
        activity.finish();
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int sh(int i3) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            com.tencent.gdtad.kuikly.a.c("GdtBaseKuiklyFragment", "[fallback] error, not on main thread, errorCode:" + i3 + " ", null, AdMetricID.Kuikly.Fragment.FALLBACK_FAILED, AdMetricID.Kuikly.Fragment.FALLBACK_FAILED_TIME_MILLIS, uh(), this.C, this.D, vh(), 22);
            return 22;
        }
        if (this.H) {
            com.tencent.gdtad.kuikly.a.c("GdtBaseKuiklyFragment", "[fallback] error, too frequently, errorCode:" + i3 + " ", null, AdMetricID.Kuikly.Fragment.FALLBACK_FAILED, AdMetricID.Kuikly.Fragment.FALLBACK_FAILED_TIME_MILLIS, uh(), this.C, this.D, vh(), 2);
            return 2;
        }
        QLog.i("GdtBaseKuiklyFragment", 1, "[fallback] start");
        this.H = true;
        int qh5 = qh(i3);
        if (qh5 != 0) {
            com.tencent.gdtad.kuikly.a.c("GdtBaseKuiklyFragment", "[fallback] error, close failed, errorCode:" + i3 + " closeErrorCode:" + qh5, null, AdMetricID.Kuikly.Fragment.FALLBACK_FAILED, AdMetricID.Kuikly.Fragment.FALLBACK_FAILED_TIME_MILLIS, uh(), this.C, this.D, vh(), qh5);
            return qh5;
        }
        a wh5 = wh();
        if (wh5 == null) {
            com.tencent.gdtad.kuikly.a.c("GdtBaseKuiklyFragment", "[fallback] error, launcher is null, errorCode:" + i3 + " ", null, AdMetricID.Kuikly.Fragment.FALLBACK_FAILED, AdMetricID.Kuikly.Fragment.FALLBACK_FAILED_TIME_MILLIS, uh(), this.C, this.D, vh(), 1);
            return 1;
        }
        int f16 = wh5.f(getActivity(), i3, this.E, this.F);
        if (f16 != 0) {
            com.tencent.gdtad.kuikly.a.c("GdtBaseKuiklyFragment", "[fallback] error, fallback failed, errorCode:" + i3 + " fallbackErrorCode:" + f16, null, AdMetricID.Kuikly.Fragment.FALLBACK_FAILED, AdMetricID.Kuikly.Fragment.FALLBACK_FAILED_TIME_MILLIS, uh(), this.C, this.D, vh(), f16);
            return f16;
        }
        com.tencent.gdtad.kuikly.a.i("GdtBaseKuiklyFragment", "[fallback] success, errorCode:" + i3, AdMetricID.Kuikly.Fragment.FALLBACK_SUCCESS, AdMetricID.Kuikly.Fragment.FALLBACK_SUCCESS_TIME_MILLIS, uh(), this.C, this.D, vh(), i3);
        return 0;
    }

    protected abstract void th(HashMap<String, Object> hashMap);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract GdtAd uh();

    /* JADX INFO: Access modifiers changed from: protected */
    public long vh() {
        if (this.G == WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
            return WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        return System.currentTimeMillis() - this.G;
    }

    protected abstract a wh();
}
