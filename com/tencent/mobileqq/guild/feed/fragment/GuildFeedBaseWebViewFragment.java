package com.tencent.mobileqq.guild.feed.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.CallSuper;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.api.IGuildIPCService;
import com.tencent.mobileqq.guild.api.IGuildPublicToDetailFullLinkReportApi;
import com.tencent.mobileqq.guild.event.GuildFeedDetailReportEvent;
import com.tencent.mobileqq.guild.event.GuildSpeakThresholdAuthEvent;
import com.tencent.mobileqq.guild.feed.detail.event.GuildFeedDetailCacheRespEvent;
import com.tencent.mobileqq.guild.feed.event.GuildBeKickedEvent;
import com.tencent.mobileqq.guild.feed.event.GuildChannelDeleteEvent;
import com.tencent.mobileqq.guild.feed.event.GuildDeleteEvent;
import com.tencent.mobileqq.guild.feed.event.GuildDetailViewDestroyEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedDeleteEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedDetailLikeEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedMuteStateChangeEvent;
import com.tencent.mobileqq.guild.feed.event.GuildSpeakThresholdStateChangeEvent;
import com.tencent.mobileqq.guild.feed.fragment.GuildFeedBaseWebViewFragment;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.util.GuildFeedReportHelper;
import com.tencent.mobileqq.guild.feed.util.v;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.ab;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.s;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.mobileqq.webview.view.WebBrowserViewContainerKt;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.UiThreadUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import r12.a;

/* compiled from: P */
/* loaded from: classes13.dex */
public abstract class GuildFeedBaseWebViewFragment extends WebViewFragment implements SimpleEventReceiver {
    public static final String KEY_GESTURE_EXIT_FORM_LEFT_TO_RIGHT = "key_gesture_exit_from_left_to_right";
    private static final String LOG_TAG = "GuildFeedBaseWebViewFragment";
    private static final int XDISTANCE_LENGTH = 600;
    private static final int XDISTANCE_MIN = 150;
    private static final int XSPEED_MIN = 3000;
    private static final int YDISTANCE_LENGTH = 400;
    protected GuildFeedBaseInitBean mInitBean;
    protected boolean mIsPageFinish = false;
    protected boolean mIsSelfMute;
    protected boolean mIsSelfSpeakThresholdLimiting;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a extends com.tencent.mobileqq.webview.swift.proxy.a {
        a(t tVar) {
            super(tVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            GuildFeedBaseWebViewFragment.this.mIsPageFinish = true;
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public String getUAMark() {
            return "Guild";
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public boolean interceptStartLoadUrl() {
            ab.b("GuildFeedBaseWebViewFragment#WebViewKernelCallBack#interceptStartLoadUrl");
            GuildFeedBaseWebViewFragment.this.logMethodEvent("event_detail_webview_cb_intercept", "WebViewKernelCallBack#interceptStartLoadUrl", Boolean.TRUE);
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.fragment.c
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFeedBaseWebViewFragment.a.this.b();
                }
            }, 1000L);
            if (!GuildFeedBaseWebViewFragment.this.interceptStartLoadUrl()) {
                return super.interceptStartLoadUrl();
            }
            return false;
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onFinalState(Bundle bundle) {
            super.onFinalState(bundle);
            GuildFeedBaseWebViewFragment.this.initConfig();
            GuildFeedBaseWebViewFragment.this.initView();
            GuildFeedBaseWebViewFragment.this.initData();
            SimpleEventBus.getInstance().registerReceiver(GuildFeedBaseWebViewFragment.this);
            GuildFeedBaseWebViewFragment.this.initOtherPlugin();
            ab.b("GuildFeedBaseWebViewFragment#WebViewKernelCallBack#onFinalState");
            GuildFeedBaseWebViewFragment.this.logMethodEvent("event_detail_webview_cb_final_state", "WebViewKernelCallBack#onFinalState", Boolean.TRUE);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public boolean onLongClick(View view) {
            if (GuildFeedBaseWebViewFragment.this.enableWebViewLongClick()) {
                return super.onLongClick(view);
            }
            return false;
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            GuildFeedReportHelper.i().p(GuildFeedBaseWebViewFragment.this);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            GuildFeedReportHelper.i().q(GuildFeedBaseWebViewFragment.this);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onReceivedError(WebView webView, int i3, String str, String str2) {
            super.onReceivedError(webView, i3, str, str2);
            GuildFeedReportHelper.i().r(GuildFeedBaseWebViewFragment.this, i3, str);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public boolean onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            boolean onReceivedSslError = super.onReceivedSslError(webView, sslErrorHandler, sslError);
            GuildFeedReportHelper.i().s(GuildFeedBaseWebViewFragment.this);
            return onReceivedSslError;
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onWebViewInit(Bundle bundle, TouchWebView touchWebView) {
            ab.b("GuildFeedBaseWebViewFragment#WebViewKernelCallBack#onWebViewInit");
            super.onWebViewInit(bundle, touchWebView);
            GuildFeedBaseWebViewFragment.this.setWebViewBackground();
            GuildFeedReportHelper.i().t(GuildFeedBaseWebViewFragment.this);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public boolean softKeyboardResizeCompactOn() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class b implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        private float[] f219534d = new float[2];

        /* renamed from: e, reason: collision with root package name */
        private float[] f219535e = new float[2];

        /* renamed from: f, reason: collision with root package name */
        private VelocityTracker f219536f;

        /* renamed from: h, reason: collision with root package name */
        private WeakReference<GuildFeedBaseWebViewFragment> f219537h;

        public b(GuildFeedBaseWebViewFragment guildFeedBaseWebViewFragment) {
            this.f219537h = new WeakReference<>(guildFeedBaseWebViewFragment);
        }

        private void a(MotionEvent motionEvent) {
            if (this.f219536f == null) {
                this.f219536f = VelocityTracker.obtain();
            }
            this.f219536f.addMovement(motionEvent);
        }

        private int b() {
            this.f219536f.computeCurrentVelocity(1000);
            return Math.abs((int) this.f219536f.getXVelocity());
        }

        private void c() {
            this.f219536f.recycle();
            this.f219536f = null;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            GuildFeedBaseWebViewFragment guildFeedBaseWebViewFragment = this.f219537h.get();
            if (guildFeedBaseWebViewFragment == null) {
                QLog.i(GuildFeedBaseWebViewFragment.LOG_TAG, 1, "OnTouchListener: fragment is null");
                return false;
            }
            a(motionEvent);
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        this.f219534d[1] = motionEvent.getX();
                        this.f219535e[1] = motionEvent.getY();
                        int b16 = b();
                        float[] fArr = this.f219534d;
                        if (fArr[0] < 150.0f && fArr[1] > 600.0f) {
                            float[] fArr2 = this.f219535e;
                            if (Math.abs(fArr2[1] - fArr2[0]) < 400.0f && b16 > 3000) {
                                guildFeedBaseWebViewFragment.finish();
                                QLog.i(GuildFeedBaseWebViewFragment.LOG_TAG, 1, "OnTouchListener: fragment finish");
                            }
                        }
                    }
                } else {
                    this.f219534d = new float[2];
                    this.f219535e = new float[2];
                    c();
                }
            } else {
                this.f219534d[0] = motionEvent.getX();
                this.f219535e[0] = motionEvent.getY();
            }
            return false;
        }
    }

    private void handleBeKickedEvent(GuildBeKickedEvent guildBeKickedEvent) {
        if (isCurrentGuildId(guildBeKickedEvent.getGuildId())) {
            showToast(HardCodeUtil.qqStr(R.string.f144300oe));
            finish();
        }
    }

    private void handleDeleteEvent(GuildDeleteEvent guildDeleteEvent) {
        if (isCurrentGuildId(guildDeleteEvent.getGuildId())) {
            showToast(HardCodeUtil.qqStr(R.string.f144240o9));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initConfig() {
        if (getIntent() == null) {
            return;
        }
        if (getIntent().getBooleanExtra(KEY_GESTURE_EXIT_FORM_LEFT_TO_RIGHT, false)) {
            initGestureExitFromLeftToRightEvent();
        }
        GuildFeedBaseInitBean guildFeedBaseInitBean = (GuildFeedBaseInitBean) getIntent().getSerializableExtra(com.tencent.mobileqq.guild.feed.b.f218115a);
        this.mInitBean = guildFeedBaseInitBean;
        if (guildFeedBaseInitBean == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_guild_id", this.mInitBean.getGuildId());
        bundle.putString("key_channel_id", this.mInitBean.getChannelId());
        QIPCClientHelper.getInstance().callServer(IGuildIPCService.GUILD_NAME_IPC_NAME, "async_register_speakthreshold_observer", bundle, null);
        QIPCClientHelper.getInstance().callServer(IGuildIPCService.GUILD_NAME_IPC_NAME, "async_register_mute_observer", bundle, null);
    }

    private boolean isMainProcess() {
        if (MobileQQ.sProcessId == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onReceiveEvent$0(GuildSpeakThresholdAuthEvent guildSpeakThresholdAuthEvent, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ch.i1(getActivity(), guildSpeakThresholdAuthEvent.getJumpUrl());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logMethodEvent(String str, String str2, Boolean bool) {
        if (isMainProcess()) {
            if (bool.booleanValue()) {
                ((IGuildPublicToDetailFullLinkReportApi) QRoute.api(IGuildPublicToDetailFullLinkReportApi.class)).logMethodAndReport(str, str2, System.currentTimeMillis());
                return;
            } else {
                ((IGuildPublicToDetailFullLinkReportApi) QRoute.api(IGuildPublicToDetailFullLinkReportApi.class)).logMethod(str2, System.currentTimeMillis(), true);
                return;
            }
        }
        SimpleEventBus.getInstance().dispatchEvent(new GuildFeedDetailReportEvent(str, str2, System.currentTimeMillis(), bool.booleanValue()), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWebViewBackground() {
        int i3;
        int i16;
        CustomWebView webView = getWebView();
        int backgroundColorId = getBackgroundColorId();
        int backgroundNightColorId = getBackgroundNightColorId();
        if (webView == null) {
            return;
        }
        if (webView.getX5WebViewExtension() != null) {
            try {
                View view = webView.getView();
                if (QQTheme.isNowThemeIsNight()) {
                    i3 = backgroundNightColorId;
                } else {
                    i3 = backgroundColorId;
                }
                view.setBackgroundColor(i3);
                webView.getX5WebViewExtension().setVerticalTrackDrawable(null);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        if (QQTheme.isNowThemeIsNight()) {
            i16 = backgroundNightColorId;
        } else {
            i16 = backgroundColorId;
        }
        webView.setBackgroundColor(i16);
        WebBrowserViewContainerKt webBrowserViewContainerKt = this.contentView;
        if (webBrowserViewContainerKt != null) {
            if (QQTheme.isNowThemeIsNight()) {
                backgroundColorId = backgroundNightColorId;
            }
            webBrowserViewContainerKt.setBackgroundColor(backgroundColorId);
        }
        webView.setMask(false);
    }

    private void showToast(String str) {
        QQToast.makeText(getContext(), str, 0).show();
    }

    @RequiresApi(api = 17)
    public boolean available() {
        FragmentActivity activity = getActivity();
        if (activity == null || isDestroyed() || isDetached() || activity.isFinishing() || activity.isDestroyed()) {
            return false;
        }
        return true;
    }

    protected boolean enableWebViewLongClick() {
        return true;
    }

    public void finish() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @ColorInt
    protected abstract int getBackgroundColorId();

    @ColorInt
    protected abstract int getBackgroundNightColorId();

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(GuildDeleteEvent.class);
        arrayList.add(GuildChannelDeleteEvent.class);
        arrayList.add(GuildBeKickedEvent.class);
        arrayList.add(GuildFeedMuteStateChangeEvent.class);
        arrayList.add(GuildFeedDetailCacheRespEvent.class);
        arrayList.add(GuildSpeakThresholdStateChangeEvent.class);
        arrayList.add(GuildDetailViewDestroyEvent.class);
        arrayList.add(GuildSpeakThresholdAuthEvent.class);
        arrayList.add(GuildFeedDetailLikeEvent.class);
        arrayList.add(GuildFeedDeleteEvent.class);
        addEventClass(arrayList);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    public t getWebViewKernelCallBack() {
        return new a(this.webViewSurface);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void handleMuteChangeEvent(GuildFeedMuteStateChangeEvent guildFeedMuteStateChangeEvent) {
        GuildFeedBaseInitBean guildFeedBaseInitBean = this.mInitBean;
        if (guildFeedBaseInitBean != null && guildFeedMuteStateChangeEvent.guildId.equals(guildFeedBaseInitBean.getGuildId()) && guildFeedMuteStateChangeEvent.channelId.equals(this.mInitBean.getChannelId())) {
            this.mIsSelfMute = guildFeedMuteStateChangeEvent.isAtomicMute;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void handleSpeakThresholdChangeEvent(GuildSpeakThresholdStateChangeEvent guildSpeakThresholdStateChangeEvent) {
        GuildFeedBaseInitBean guildFeedBaseInitBean = this.mInitBean;
        if (guildFeedBaseInitBean != null && guildSpeakThresholdStateChangeEvent.mGuildId.equals(guildFeedBaseInitBean.getGuildId())) {
            guildSpeakThresholdStateChangeEvent.mChannelId.equals(this.mInitBean.getChannelId());
        }
    }

    protected abstract void initData();

    protected void initGestureExitFromLeftToRightEvent() {
        CustomWebView webView = getWebView();
        if (webView == null) {
            return;
        }
        webView.setOnTouchListener(new b(this));
    }

    protected abstract void initView();

    protected boolean interceptStartLoadUrl() {
        return false;
    }

    protected boolean isCurrentChannelId(List<String> list) {
        if (this.mInitBean != null) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str) && this.mInitBean.getChannelId().equals(str)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    protected boolean isCurrentGuildId(String str) {
        if (this.mInitBean != null && !TextUtils.isEmpty(str)) {
            return this.mInitBean.getGuildId().equals(str);
        }
        return false;
    }

    protected boolean isSpeakThresholdLimiting(int i3) {
        if (i3 != 4 && i3 != 2) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        ab.a();
        ab.b("GuildFeedBaseWebViewFragment#onCreate");
        logMethodEvent("event_detail_webview_oncreate", "GuildFeedBaseWebViewFragment#onCreate", Boolean.FALSE);
        GuildFeedReportHelper.i().o(this);
        super.onCreate(bundle);
        if (getIntent() == null) {
            return;
        }
        Serializable serializable = null;
        try {
            serializable = getIntent().getSerializableExtra(com.tencent.mobileqq.guild.feed.b.f218115a);
            GuildFeedBaseInitBean guildFeedBaseInitBean = (GuildFeedBaseInitBean) serializable;
            this.mInitBean = guildFeedBaseInitBean;
            if (guildFeedBaseInitBean == null) {
                finish();
                return;
            }
            Boolean bool = (Boolean) guildFeedBaseInitBean.getAttrs().get("jumpGuildFromLoadingPage");
            if (getActivity() != null) {
                if (bool != null && bool.booleanValue()) {
                    getActivity().overridePendingTransition(R.anim.l_, R.anim.l_);
                } else {
                    getActivity().overridePendingTransition(R.anim.f154619or, R.anim.f154425m);
                }
            }
        } catch (Exception e16) {
            s.f(WebViewFragment.TAG, "intent:" + getIntent() + " bean:" + serializable, e16);
            finish();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        setStatusBar();
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        v.a().e(WebViewFragment.TAG, true);
    }

    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent != null) {
            QLog.i(LOG_TAG, 1, "onReceiveEvent: event[" + simpleBaseEvent.getClass().getName() + "]");
        }
        if (simpleBaseEvent instanceof GuildDeleteEvent) {
            handleDeleteEvent((GuildDeleteEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof GuildBeKickedEvent) {
            handleBeKickedEvent((GuildBeKickedEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof GuildChannelDeleteEvent) {
            handleChannelDeleteEvent((GuildChannelDeleteEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof GuildFeedMuteStateChangeEvent) {
            handleMuteChangeEvent((GuildFeedMuteStateChangeEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof GuildSpeakThresholdStateChangeEvent) {
            handleSpeakThresholdChangeEvent((GuildSpeakThresholdStateChangeEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof GuildSpeakThresholdAuthEvent) {
            final GuildSpeakThresholdAuthEvent guildSpeakThresholdAuthEvent = (GuildSpeakThresholdAuthEvent) simpleBaseEvent;
            r12.a.a(getContext(), new a.C11105a(guildSpeakThresholdAuthEvent.getTipText(), guildSpeakThresholdAuthEvent.getJumpText(), new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.fragment.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildFeedBaseWebViewFragment.this.lambda$onReceiveEvent$0(guildSpeakThresholdAuthEvent, view);
                }
            })).b();
        }
        handleReceiveEvent(simpleBaseEvent);
    }

    protected void setStatusBar() {
        if (getActivity() != null && !getHostActivity().isFinishing() && getActivity().getWindow() != null) {
            Window window = getActivity().getWindow();
            if (window.getDecorView() != null) {
                window.getDecorView().setSystemUiVisibility(0);
            }
            window.setSoftInputMode(32);
            ImmersiveUtils.setStatusTextColor(!GuildThemeManager.f235286a.b(), getActivity().getWindow());
        }
    }

    protected void initOtherPlugin() {
    }

    private void handleChannelDeleteEvent(GuildChannelDeleteEvent guildChannelDeleteEvent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addEventClass(ArrayList arrayList) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
    }
}
