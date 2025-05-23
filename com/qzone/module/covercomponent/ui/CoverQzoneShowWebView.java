package com.qzone.module.covercomponent.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.qzone.module.covercomponent.utils.CoverHelper;
import com.qzone.module.covercomponent.utils.CoverURLDrawableHelper;
import com.qzone.module.covercomponent.utils.QzoneShowCutInnerSquareImageProcessor;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.qzone.proxy.covercomponent.adapter.CoverLog;
import com.qzone.proxy.covercomponent.env.CoverEnv;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.vas.VasQzoneYellowThread;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;
import cooperation.qzone.model.CoverCacheData;
import cooperation.qzone.webviewwrapper.IWebviewListener;
import cooperation.qzone.webviewwrapper.IWebviewWrapper;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CoverQzoneShowWebView extends CoverBaseView {
    public static final String TAG = "CoverQzoneShowWebView";
    public static final String TAG_QZONE_SHOW_BAD_DEVICE_HAS_HECHNGTU = "QzoneShowHengChengTu";
    public static final String TAG_QZONE_SHOW_DENGTA = "CoverQzoneShow";
    private Context J;
    private Activity K;
    private String L;
    private FrameLayout M;
    private ProgressBar N;
    private boolean P;
    private Handler Q;
    private Handler R;
    private long S;
    private int T;
    private int U;
    private int V;
    private float W;
    private boolean X;
    private boolean Y;
    private boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f48691a0;

    /* renamed from: b0, reason: collision with root package name */
    private long f48692b0;

    /* renamed from: c0, reason: collision with root package name */
    private long f48693c0;

    /* renamed from: d0, reason: collision with root package name */
    private String f48694d0;

    /* renamed from: e0, reason: collision with root package name */
    private String f48695e0;

    /* renamed from: f0, reason: collision with root package name */
    private String f48696f0;

    /* renamed from: g0, reason: collision with root package name */
    private double f48697g0;

    /* renamed from: h0, reason: collision with root package name */
    private WebviewCoverListener f48698h0;

    /* renamed from: i0, reason: collision with root package name */
    private WebviewCoverClickListener f48699i0;

    /* renamed from: j0, reason: collision with root package name */
    private ImageLoader.ImageLoadListener f48700j0;

    /* renamed from: k0, reason: collision with root package name */
    private MessageQueue.IdleHandler f48701k0;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f48702l0;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f48703m0;
    public IWebviewWrapper mQzoneShowWebView;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface WebviewCoverClickListener {
        void onClick(Context context, long j3, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface WebviewCoverListener {
        void onDowngradeImageClick(Context context, long j3, int i3);
    }

    private float A(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0.0f;
        }
        try {
            String queryParameter = Uri.parse(str).getQueryParameter("cover_ratio");
            if (queryParameter == null) {
                return 0.0f;
            }
            return Float.valueOf(queryParameter).floatValue();
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0.0f;
        }
    }

    private int B() {
        if (this.W > 0.0f) {
            int screenWidth = (int) (CoverEnv.getScreenWidth() * this.W);
            this.U = screenWidth;
            int i3 = this.V;
            if (i3 > 0) {
                this.U = screenWidth + i3;
            }
        } else {
            this.U = CoverEnv.getFinalCoverHeight();
        }
        return this.U;
    }

    private int C(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            String queryParameter = Uri.parse(str).getQueryParameter("hideheight");
            if (queryParameter == null) {
                return 0;
            }
            return Integer.valueOf(queryParameter).intValue();
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    private void D() {
        L();
        IWebviewWrapper iWebviewWrapper = this.mQzoneShowWebView;
        if (iWebviewWrapper != null) {
            iWebviewWrapper.onPause();
        }
    }

    private void E() {
        M();
        IWebviewWrapper iWebviewWrapper = this.mQzoneShowWebView;
        if (iWebviewWrapper != null) {
            iWebviewWrapper.onResume();
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.qzone.module.covercomponent.ui.CoverQzoneShowWebView.1
                @Override // android.os.MessageQueue.IdleHandler
                public boolean queueIdle() {
                    WebView webview = CoverQzoneShowWebView.this.mQzoneShowWebView.getWebview();
                    if (webview == null) {
                        return false;
                    }
                    try {
                        webview.postInvalidate();
                        return false;
                    } catch (Throwable th5) {
                        CoverQzoneShowWebView.this.P("webView.postInvalidate exception." + th5);
                        return false;
                    }
                }
            });
        }
    }

    private void G(Context context, FrameLayout frameLayout) {
        if (this.N != null) {
            return;
        }
        frameLayout.removeAllViewsInLayout();
        ProgressBar progressBar = new ProgressBar(context);
        this.N = progressBar;
        progressBar.setIndeterminate(true);
        this.N.setIndeterminateDrawable(context.getResources().getDrawable(CoverHelper.getResId(1)));
        int dip2px = CoverEnv.dip2px(23);
        int screenWidth = CoverEnv.getScreenWidth();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.U);
        int i3 = (screenWidth - dip2px) / 2;
        this.N.setPadding(i3, i3, i3, i3);
        frameLayout.addView(this.N, layoutParams);
        String z16 = z();
        if (!TextUtils.isEmpty(z16)) {
            J(z16);
        }
        N();
    }

    private void H(Context context, Activity activity, Intent intent, FrameLayout frameLayout) {
        if (this.N == null) {
            G(context, frameLayout);
        }
        System.currentTimeMillis();
        IWebviewWrapper webviewInstance = CoverEnv.getWebviewInstance(context);
        this.mQzoneShowWebView = webviewInstance;
        webviewInstance.preInit();
        Q();
        View webview = this.mQzoneShowWebView.getWebview();
        if (webview == null) {
            CoverLog.w(TAG, "webview is null", null);
            return;
        }
        if (this.W == 0.0f) {
            if (getCoverType() != 17) {
                webview.setLayerType(1, null);
            } else {
                webview.setLayerType(2, null);
            }
        }
        webview.setBackgroundColor(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(CoverEnv.getScreenWidth(), B());
        layoutParams.gravity = 17;
        webview.setLayoutParams(layoutParams);
        frameLayout.addView(webview);
        this.mQzoneShowWebView.onInit(activity, intent, this.f48696f0, new IWebviewListener() { // from class: com.qzone.module.covercomponent.ui.CoverQzoneShowWebView.7
            @Override // cooperation.qzone.webviewwrapper.IWebviewListener
            public void onPageFinished() {
                if (CoverQzoneShowWebView.this.N != null) {
                    CoverQzoneShowWebView.this.N.setIndeterminateDrawable(null);
                }
                if (CoverQzoneShowWebView.this.mQzoneShowWebView.getWebview() != null) {
                    CoverQzoneShowWebView.this.mQzoneShowWebView.getWebview().setOnLongClickListener(CoverQzoneShowWebView.this);
                }
            }

            @Override // cooperation.qzone.webviewwrapper.IWebviewListener
            public void onReceiveError(int i3, String str, String str2) {
            }
        });
    }

    private void I() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z16 = !CoverEnv.isSupportQzoneShowCover();
        this.Y = z16;
        if (z16) {
            this.X = true;
        } else {
            boolean isLowMemory = CoverEnv.isLowMemory();
            this.Z = isLowMemory;
            if (isLowMemory) {
                this.X = true;
            } else {
                this.X = false;
            }
        }
        P("enableDowngrade=" + this.X + ",isBadDevice=" + this.Y + ",isLowMemory=" + this.Z + ",cost time=" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
    }

    private void J(String str) {
        Drawable loadImage;
        P("loadLoadingPic:" + str);
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        obtain.extraProcessor = new QzoneShowCutInnerSquareImageProcessor(CoverEnv.getScreenWidth(), this.U, this.f48697g0);
        obtain.useMainThread = true;
        if (VasToggle.isEnable("qzone_cover_load_with_URLDrawable", false)) {
            loadImage = CoverURLDrawableHelper.getCoverDrawable(str, obtain, this.f48700j0);
        } else {
            loadImage = ImageLoader.getInstance().loadImage(str, this.f48700j0, obtain);
        }
        if (loadImage != null) {
            loadImage.setBounds(0, 0, CoverEnv.getScreenWidth(), this.U);
            O(this.N, loadImage);
        }
    }

    private void L() {
        if (isPaused()) {
            return;
        }
        u("callCommand('pause')");
    }

    private void M() {
        if (isPaused()) {
            u("callCommand('resume')");
        }
    }

    private void N() {
        ProgressBar progressBar;
        if (this.P || (progressBar = this.N) == null) {
            return;
        }
        this.P = true;
        progressBar.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.covercomponent.ui.CoverQzoneShowWebView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                CoverQzoneShowWebView.this.x();
                EventCollector.getInstance().onViewClicked(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(String str) {
        CoverLog.i(TAG, CoverLog.CLR, "id:" + this.T + "," + str);
    }

    private void Q() {
        IWebviewWrapper iWebviewWrapper = this.mQzoneShowWebView;
        if (iWebviewWrapper == null || iWebviewWrapper.getWebview() == null) {
            return;
        }
        if (this.f48699i0 == null) {
            this.mQzoneShowWebView.setOnWebviewTouchListener(null);
        } else {
            this.mQzoneShowWebView.setOnWebviewTouchListener(new View.OnTouchListener() { // from class: com.qzone.module.covercomponent.ui.CoverQzoneShowWebView.4

                /* renamed from: d, reason: collision with root package name */
                private long f48710d;

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        this.f48710d = System.currentTimeMillis();
                        return false;
                    }
                    if (action != 1) {
                        return false;
                    }
                    CoverLog.i(CoverQzoneShowWebView.TAG, CoverLog.DEV, "long click time = " + ViewConfiguration.getLongPressTimeout() + " currentTiem = " + (System.currentTimeMillis() - this.f48710d));
                    if (System.currentTimeMillis() - this.f48710d >= ViewConfiguration.getLongPressTimeout() || CoverQzoneShowWebView.this.f48699i0 == null) {
                        return false;
                    }
                    CoverQzoneShowWebView.this.f48699i0.onClick(CoverQzoneShowWebView.this.J, CoverQzoneShowWebView.this.f48693c0, CoverQzoneShowWebView.this.E);
                    return false;
                }
            });
        }
    }

    private void u(String str) {
        IWebviewWrapper iWebviewWrapper = this.mQzoneShowWebView;
        if (iWebviewWrapper != null) {
            iWebviewWrapper.callJs(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (this.X || this.mQzoneShowWebView != null || this.J == null) {
            return;
        }
        String str = this.L;
        if (str != null && str.length() != 0) {
            final Intent intent = new Intent();
            intent.putExtra("url", this.L);
            boolean hasProxyParam = CoverEnv.Webso.hasProxyParam(Uri.parse(this.L));
            if (hasProxyParam) {
                if (this.Q == null) {
                    this.Q = new Handler(Looper.getMainLooper()) { // from class: com.qzone.module.covercomponent.ui.CoverQzoneShowWebView.9
                        @Override // android.os.Handler
                        public void handleMessage(Message message) {
                            if (message.what == 203) {
                                Object obj = message.obj;
                                if (obj instanceof Bundle) {
                                    Bundle bundle = (Bundle) obj;
                                    if (CoverQzoneShowWebView.this.mQzoneShowWebView != null) {
                                        intent.putExtras(bundle);
                                    }
                                    CoverQzoneShowWebView.this.onWebViewReady(intent, true);
                                }
                            }
                        }
                    };
                }
                this.S = System.currentTimeMillis();
                P("delayShow mLastSendWnsRequestTime=" + this.S);
                CoverEnv.getBusinessThreadHandler().post(new Runnable() { // from class: com.qzone.module.covercomponent.ui.CoverQzoneShowWebView.10
                    @Override // java.lang.Runnable
                    public void run() {
                        CoverEnv.Webso.startWebSoRequestWithCheck(CoverQzoneShowWebView.this.L, CoverQzoneShowWebView.this.Q);
                        intent.putExtra(QzoneCoverConst.WebViewConst.KEY_WNS_PROXY_HTTP_DATA, CoverEnv.Webso.getHtmlData(CoverQzoneShowWebView.this.L));
                        CoverQzoneShowWebView.this.Q.post(new Runnable() { // from class: com.qzone.module.covercomponent.ui.CoverQzoneShowWebView.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass10 anonymousClass10 = AnonymousClass10.this;
                                CoverQzoneShowWebView.this.onWebViewReady(intent, false);
                            }
                        });
                    }
                });
            }
            try {
                H(this.J, this.K, intent, this.M);
                if (hasProxyParam) {
                    return;
                }
                onWebViewReady(intent, true);
                return;
            } catch (Throwable th5) {
                K(th5);
                return;
            }
        }
        CoverLog.i(TAG, CoverLog.CLR, "mQzoneShowUrl is empty, delayShow do nothing");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        P("doOnDowngradeImageClicked");
        if (this.J == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f48692b0 < 2000) {
            return;
        }
        this.f48692b0 = currentTimeMillis;
        WebviewCoverListener webviewCoverListener = this.f48698h0;
        if (webviewCoverListener != null) {
            webviewCoverListener.onDowngradeImageClick(this.J, this.f48693c0, this.E);
        }
    }

    private String z() {
        if (this.X) {
            String str = this.f48695e0;
            if (str != null && str.length() > 0) {
                F(true);
                return str;
            }
            P("get downgrade url empty!");
            F(false);
            return this.f48694d0;
        }
        return this.f48694d0;
    }

    @Override // com.qzone.module.covercomponent.ui.CoverBaseView, com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void delayShow() {
        P("delayShow start");
        if (this.f48701k0 != null) {
            Looper.myQueue().removeIdleHandler(this.f48701k0);
            Looper.myQueue().addIdleHandler(this.f48701k0);
        }
    }

    public float getCoverRatio() {
        return this.W;
    }

    public int getScreenHeight() {
        return this.U;
    }

    public void initAndShow(FrameLayout frameLayout, boolean z16) {
        this.M = frameLayout;
        G(this.J, frameLayout);
        setRefer(this.E);
        if (!CoverEnv.isNeedDelayShow()) {
            delayShow();
        } else if (z16) {
            delayShow();
        }
    }

    @Override // com.qzone.module.covercomponent.ui.CoverBaseView, com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onDestroy() {
        IWebviewWrapper iWebviewWrapper = this.mQzoneShowWebView;
        if (iWebviewWrapper != null) {
            iWebviewWrapper.onDestroy();
        }
        this.J = null;
        this.K = null;
        this.M = null;
        ProgressBar progressBar = this.N;
        if (progressBar != null && progressBar.getParent() != null) {
            ((ViewGroup) this.N.getParent()).removeView(this.N);
        }
        this.N = null;
        if (this.f48701k0 != null) {
            Looper.myQueue().removeIdleHandler(this.f48701k0);
            this.f48701k0 = null;
        }
        super.onDestroy();
    }

    @Override // com.qzone.module.covercomponent.ui.CoverBaseView, com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onInvisible() {
        if (isCoverVisible()) {
            D();
            super.onInvisible();
        }
    }

    @Override // com.qzone.module.covercomponent.ui.CoverBaseView, com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onPause() {
        if (isPaused()) {
            return;
        }
        D();
        super.onPause();
    }

    @Override // com.qzone.module.covercomponent.ui.CoverBaseView, com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onPullChanged(float f16) {
        onPullChanged((int) (f16 * 100.0f));
    }

    @Override // com.qzone.module.covercomponent.ui.CoverBaseView, com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onPullEnd() {
        if (isPaused()) {
            return;
        }
        this.f48702l0 = true;
        u("callCommand('endDragging')");
    }

    @Override // com.qzone.module.covercomponent.ui.CoverBaseView, com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onPullStart() {
        if (isPaused()) {
            return;
        }
        u("callCommand('beginDragging')");
    }

    @Override // com.qzone.module.covercomponent.ui.CoverBaseView, com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onResume() {
        if (isPaused()) {
            E();
            super.onResume();
        }
    }

    @Override // com.qzone.module.covercomponent.ui.CoverBaseView, com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public boolean onTouchEvent(Activity activity, View view, MotionEvent motionEvent, CoverCacheData coverCacheData) {
        return true;
    }

    @Override // com.qzone.module.covercomponent.ui.CoverBaseView, com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onVisible() {
        if (isCoverVisible()) {
            return;
        }
        E();
        super.onVisible();
    }

    public void onWebViewReady(Intent intent, boolean z16) {
        IWebviewWrapper iWebviewWrapper;
        if (this.X || (iWebviewWrapper = this.mQzoneShowWebView) == null) {
            return;
        }
        iWebviewWrapper.onWebViewReady(intent, z16);
        ProgressBar progressBar = this.N;
        if (progressBar != null) {
            progressBar.setIndeterminateDrawable(null);
        }
    }

    public void reloadWeb(long j3, String str, String str2, String str3) {
        ViewParent parent;
        this.f48693c0 = j3;
        this.f48694d0 = str2;
        this.f48695e0 = str3;
        if (str != null && str.length() > 0) {
            this.L = str;
        }
        if (System.currentTimeMillis() - this.S < 5000) {
            P("too fast not reload,mLastSendWnsRequestTime=" + this.S);
            return;
        }
        if (!this.X) {
            I();
            if (this.X) {
                IWebviewWrapper iWebviewWrapper = this.mQzoneShowWebView;
                if (iWebviewWrapper != null && iWebviewWrapper.getWebview() != null && (parent = this.mQzoneShowWebView.getWebview().getParent()) != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeViewInLayout(this.mQzoneShowWebView.getWebview());
                }
                y("1");
                N();
            }
        }
        String z16 = z();
        P("reloadweb load pic:" + z16);
        if (!TextUtils.isEmpty(z16)) {
            J(z16);
        }
        if (this.X) {
            return;
        }
        final String str4 = this.L;
        final Intent intent = new Intent();
        intent.putExtra("url", str4);
        if (CoverEnv.Webso.hasProxyParam(Uri.parse(str4))) {
            P("reload web startWebSoRequest");
            if (this.R == null) {
                this.R = new Handler(Looper.getMainLooper()) { // from class: com.qzone.module.covercomponent.ui.CoverQzoneShowWebView.2
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        if (message.what == 203 && (message.obj instanceof Bundle)) {
                            CoverQzoneShowWebView.this.P("reload web handleMessage MSG_WNS_HTTP_GET_DATA");
                            Bundle bundle = (Bundle) message.obj;
                            if (CoverQzoneShowWebView.this.mQzoneShowWebView.getWebview() != null) {
                                intent.putExtras(bundle);
                            }
                            CoverQzoneShowWebView.this.onWebViewReady(intent, true);
                        }
                    }
                };
            }
            VasQzoneYellowThread.INSTANCE.execJob(new Runnable() { // from class: com.qzone.module.covercomponent.ui.CoverQzoneShowWebView.3
                @Override // java.lang.Runnable
                public void run() {
                    CoverEnv.Webso.startWebSoRequest(str4, CoverQzoneShowWebView.this.R);
                }
            });
            return;
        }
        IWebviewWrapper iWebviewWrapper2 = this.mQzoneShowWebView;
        if (iWebviewWrapper2 == null || iWebviewWrapper2.getWebview() == null) {
            return;
        }
        this.mQzoneShowWebView.getWebview().loadUrl(str4);
    }

    public void setBackgroundTransparent() {
        ProgressBar progressBar = this.N;
        if (progressBar != null) {
            progressBar.setBackgroundColor(0);
            this.N.setIndeterminateDrawable(null);
        }
    }

    public void setWebviewClickListener(WebviewCoverClickListener webviewCoverClickListener) {
        this.f48699i0 = webviewCoverClickListener;
        Q();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        IWebviewWrapper iWebviewWrapper = this.mQzoneShowWebView;
        if (iWebviewWrapper != null) {
            iWebviewWrapper.callJs(str);
            CoverLog.i(TAG, CoverLog.CLR, "cover call js : " + str);
            return;
        }
        CoverLog.w(TAG, "calljs webview is null", null);
    }

    private void K(Throwable th5) {
        this.X = true;
        this.f48691a0 = true;
        String z16 = z();
        if (!TextUtils.isEmpty(z16)) {
            J(z16);
        }
        N();
        y("2");
        CoverLog.w(TAG, "webview error,downgrade.", th5);
    }

    public void onPullChanged(int i3) {
        isPaused();
    }

    public CoverQzoneShowWebView(int i3, Context context, Activity activity, long j3, String str, String str2, String str3, String str4, double d16, WebviewCoverListener webviewCoverListener) {
        super(i3);
        this.P = false;
        this.S = 0L;
        this.T = (int) (Math.random() * 1000000.0d);
        this.U = 0;
        this.V = 0;
        this.W = 0.0f;
        this.X = false;
        this.Y = false;
        this.Z = false;
        this.f48691a0 = false;
        this.f48692b0 = 0L;
        this.f48700j0 = new ImageLoader.ImageLoadListener() { // from class: com.qzone.module.covercomponent.ui.CoverQzoneShowWebView.6
            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageCanceled(String str5, ImageLoader.Options options) {
                CoverQzoneShowWebView.this.P("onImageCanceled url:" + str5);
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageFailed(String str5, ImageLoader.Options options) {
                CoverQzoneShowWebView.this.P("onImageFailed url:" + str5);
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageLoaded(String str5, Drawable drawable, ImageLoader.Options options) {
                CoverQzoneShowWebView.this.P("onImageLoaded url:" + str5);
                if (drawable == null) {
                    return;
                }
                drawable.setBounds(0, 0, CoverEnv.getScreenWidth(), CoverQzoneShowWebView.this.U);
                CoverQzoneShowWebView coverQzoneShowWebView = CoverQzoneShowWebView.this;
                coverQzoneShowWebView.O(coverQzoneShowWebView.N, drawable);
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageProgress(String str5, float f16, ImageLoader.Options options) {
            }
        };
        this.f48701k0 = new MessageQueue.IdleHandler() { // from class: com.qzone.module.covercomponent.ui.CoverQzoneShowWebView.8
            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                CoverQzoneShowWebView.this.P("delayShowImpl running");
                long currentTimeMillis = System.currentTimeMillis();
                CoverQzoneShowWebView.this.w();
                CoverQzoneShowWebView.this.P("delayShowImpl running cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                return false;
            }
        };
        this.f48702l0 = false;
        this.f48703m0 = false;
        P("new CoverQzoneShowWebView.type=" + i3);
        this.J = context;
        this.K = activity;
        this.L = str;
        this.W = A(str);
        this.V = C(this.L);
        this.U = B();
        this.f48693c0 = j3;
        this.f48694d0 = str2;
        this.f48695e0 = str3;
        this.f48696f0 = str4;
        this.f48698h0 = webviewCoverListener;
        double d17 = 1.0d;
        if (d16 > 0.0d && d16 <= 1.0d) {
            d17 = d16;
        }
        this.f48697g0 = d17;
        I();
        y("0");
        if (this.L == null) {
            CoverLog.i(TAG, CoverLog.CLR, "mQzoneShowUrl is null, set mIsEnableDowngrade to be true");
            this.X = true;
            return;
        }
        CoverLog.i(TAG, CoverLog.CLR, "mQzoneShowUrl is " + this.L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(View view, Drawable drawable) {
        ProgressBar progressBar;
        if (view != null) {
            view.setBackground(drawable);
        }
        if (!this.X || (progressBar = this.N) == null) {
            return;
        }
        progressBar.setIndeterminateDrawable(null);
    }

    @Override // com.qzone.module.covercomponent.ui.CoverBaseView, com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void dispatchPullEvent(int i3, int i16) {
        if (i3 > i16) {
            return;
        }
        if (i3 != 0 && !this.f48702l0) {
            if (!this.f48703m0) {
                this.f48703m0 = true;
                onPullStart();
            }
            onPullChanged((i3 * 100) / i16);
            return;
        }
        if (this.f48702l0) {
            this.f48702l0 = false;
        }
        if (i3 == 0) {
            this.f48703m0 = false;
        }
    }

    private void F(boolean z16) {
    }

    private void y(String str) {
    }

    @Override // com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void draw(Canvas canvas) {
    }
}
