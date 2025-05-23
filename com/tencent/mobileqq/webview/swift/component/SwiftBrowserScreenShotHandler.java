package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.util.l;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.share.api.IScreenShotShareHelperFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.component.b;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.util.WeakReferenceHandler;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SwiftBrowserScreenShotHandler extends b.C8976b implements ShareActionSheet.OnItemClickListener, l.a, Handler.Callback {
    static IPatchRedirector $redirector_;
    com.tencent.biz.pubaccount.util.l C;
    LinearLayout D;
    Bitmap E;
    String F;
    int G;
    int H;
    float I;
    boolean J;
    boolean K;
    boolean L;
    String M;
    Handler N;
    private e62.a P;

    /* renamed from: e, reason: collision with root package name */
    private final String f314275e;

    /* renamed from: f, reason: collision with root package name */
    public Activity f314276f;

    /* renamed from: h, reason: collision with root package name */
    public WebViewProvider f314277h;

    /* renamed from: i, reason: collision with root package name */
    ElasticHorScrView f314278i;

    /* renamed from: m, reason: collision with root package name */
    int f314279m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f314285d;

        a(View view) {
            this.f314285d = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SwiftBrowserScreenShotHandler.this, (Object) view);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            Rect rect = new Rect();
            this.f314285d.getWindowVisibleDisplayFrame(rect);
            int height = this.f314285d.getRootView().getHeight() - rect.height();
            if (QLog.isDevelopLevel()) {
                QLog.d("SwiftBrowserScreenShotHandler", 2, "heightDiff:" + height);
            }
            if (height > 150) {
                SwiftBrowserScreenShotHandler swiftBrowserScreenShotHandler = SwiftBrowserScreenShotHandler.this;
                swiftBrowserScreenShotHandler.L = true;
                swiftBrowserScreenShotHandler.u(false, 0);
            } else {
                SwiftBrowserScreenShotHandler swiftBrowserScreenShotHandler2 = SwiftBrowserScreenShotHandler.this;
                if (swiftBrowserScreenShotHandler2.L) {
                    swiftBrowserScreenShotHandler2.L = false;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SwiftBrowserScreenShotHandler.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2 = "";
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                try {
                    str = Uri.parse(SwiftBrowserScreenShotHandler.this.P.getUrl()).getQueryParameter(AppConstants.Key.SHARE_REQ_ARTICLE_ID);
                } catch (Exception e16) {
                    e16.printStackTrace();
                    str = "";
                }
                if (str != null) {
                    str2 = str;
                }
                ReportController.o(null, "dc00899", IPublicAccountHandler.MAIN_ACTION, "", "0X8006A1D", "0X8006A1D", 0, 0, "", str2, "", "");
                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X8006A1D", "", "", str2, "", "");
                SwiftBrowserScreenShotHandler swiftBrowserScreenShotHandler = SwiftBrowserScreenShotHandler.this;
                if (swiftBrowserScreenShotHandler.J) {
                    swiftBrowserScreenShotHandler.K = true;
                    QQToast.makeText(BaseApplication.getContext(), 0, R.string.d6v, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                } else {
                    swiftBrowserScreenShotHandler.n(swiftBrowserScreenShotHandler.F);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SwiftBrowserScreenShotHandler.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                return;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("SwiftBrowserScreenShotHandler", 2, "showScreenshotPad->on hideAnimationEnd!");
            }
            SwiftBrowserScreenShotHandler.this.D.setVisibility(8);
            Bitmap bitmap = SwiftBrowserScreenShotHandler.this.E;
            if (bitmap != null && !bitmap.isRecycled()) {
                SwiftBrowserScreenShotHandler.this.E = null;
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    public SwiftBrowserScreenShotHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f314275e = "https://post.mp.qq.com/tmpl/default/client/article/html/jump.html?action=openUrl&url=";
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = 0;
        this.H = 0;
        this.I = 0.0f;
        this.J = false;
        this.K = false;
        this.L = false;
        this.N = new WeakReferenceHandler(Looper.getMainLooper(), this);
    }

    private void l() {
        e62.a createScreenShotShareHelper = ((IScreenShotShareHelperFactory) QRoute.api(IScreenShotShareHelperFactory.class)).createScreenShotShareHelper(this.f314276f);
        this.P = createScreenShotShareHelper;
        createScreenShotShareHelper.g(this);
        Intent intent = this.f314276f.getIntent();
        WebViewProvider webViewProvider = this.f314277h;
        if (webViewProvider != null) {
            intent = webViewProvider.getIntent();
        }
        String stringExtra = intent.getStringExtra("url");
        if (stringExtra == null && (stringExtra = intent.getStringExtra("key_params_qq")) == null) {
            stringExtra = "";
        }
        this.P.setUrl(stringExtra);
    }

    @Override // com.tencent.biz.pubaccount.util.l.a
    public void c(Uri uri, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, uri, str, Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.component.b.C8976b
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.e();
        this.f314276f = this.f314441d.getActivity();
        this.f314277h = this.f314441d.getWebViewProvider();
        l();
    }

    @Override // com.tencent.mobileqq.webview.swift.component.b.C8976b
    public void f(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) bundle);
            return;
        }
        super.f(i3, bundle);
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 == 10) {
                        p(bundle.getString("url", ""));
                        return;
                    }
                    return;
                }
                e62.a aVar = this.P;
                if (aVar != null) {
                    aVar.onConfigurationChanged();
                }
                int i16 = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
                ElasticHorScrView elasticHorScrView = this.f314278i;
                if (elasticHorScrView != null) {
                    if (i16 < this.f314279m) {
                        elasticHorScrView.setMove(true);
                        return;
                    } else {
                        elasticHorScrView.setMove(false);
                        return;
                    }
                }
                return;
            }
            v();
            Handler handler = this.N;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            e62.a aVar2 = this.P;
            if (aVar2 != null) {
                aVar2.onDestroy();
                return;
            }
            return;
        }
        if (m()) {
            if (QLog.isColorLevel()) {
                QLog.d("SwiftBrowserScreenShotHandler", 2, "ScreenshotResume!");
            }
            this.N.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.webview.swift.component.SwiftBrowserScreenShotHandler.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SwiftBrowserScreenShotHandler.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        SwiftBrowserScreenShotHandler.this.v();
                        SwiftBrowserScreenShotHandler.this.o(null);
                    }
                }
            }, 1000L);
        }
    }

    public void h(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, str, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SwiftBrowserScreenShotHandler", 2, "doMultiShare->imgUrl:" + str + ", isGif:" + z16);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bundle bundle = new Bundle();
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        String cookie = cookieManager.getCookie(str);
        if (cookie != null) {
            bundle.putString("Cookie", cookie);
        }
        this.P.c().show();
        this.M = str;
        ThreadManagerV2.executeOnSubThread(new Runnable(str, bundle, z16) { // from class: com.tencent.mobileqq.webview.swift.component.SwiftBrowserScreenShotHandler.5
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f314280d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Bundle f314281e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ boolean f314282f;

            {
                this.f314280d = str;
                this.f314281e = bundle;
                this.f314282f = z16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, SwiftBrowserScreenShotHandler.this, str, bundle, Boolean.valueOf(z16));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z17;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                String e16 = com.tencent.biz.common.util.e.e(BaseApplication.getContext(), this.f314280d, this.f314281e);
                boolean isShowing = SwiftBrowserScreenShotHandler.this.P.c().isShowing();
                if (!TextUtils.isEmpty(this.f314280d) && this.f314280d.equals(SwiftBrowserScreenShotHandler.this.M)) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("SwiftBrowserScreenShotHandler", 2, "doMultiShare download Finish!");
                    QLog.d("SwiftBrowserScreenShotHandler", 2, "isGif:" + this.f314282f + ", imgUrl:" + this.f314280d);
                    QLog.d("SwiftBrowserScreenShotHandler", 2, "isLastMultiShare:" + z17 + ", mLastMultiShareUrl:" + SwiftBrowserScreenShotHandler.this.M);
                    QLog.d("SwiftBrowserScreenShotHandler", 2, "isDialogShowing:" + isShowing + ", localPath:" + e16);
                }
                if (isShowing && z17) {
                    SwiftBrowserScreenShotHandler.this.N.post(new Runnable() { // from class: com.tencent.mobileqq.webview.swift.component.SwiftBrowserScreenShotHandler.5.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass5.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                SwiftBrowserScreenShotHandler.this.P.c().dismiss();
                            }
                        }
                    });
                    if (!TextUtils.isEmpty(e16)) {
                        SwiftBrowserScreenShotHandler swiftBrowserScreenShotHandler = SwiftBrowserScreenShotHandler.this;
                        swiftBrowserScreenShotHandler.F = e16;
                        swiftBrowserScreenShotHandler.P.i(3);
                        if (this.f314282f) {
                            SwiftBrowserScreenShotHandler.this.P.k(SwiftBrowserScreenShotHandler.this.F);
                            return;
                        } else {
                            SwiftBrowserScreenShotHandler.this.N.post(new Runnable() { // from class: com.tencent.mobileqq.webview.swift.component.SwiftBrowserScreenShotHandler.5.2
                                static IPatchRedirector $redirector_;

                                {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass5.this);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                    } else {
                                        SwiftBrowserScreenShotHandler swiftBrowserScreenShotHandler2 = SwiftBrowserScreenShotHandler.this;
                                        swiftBrowserScreenShotHandler2.n(swiftBrowserScreenShotHandler2.F);
                                    }
                                }
                            });
                            return;
                        }
                    }
                    com.tencent.biz.qrcode.util.h.T(1, R.string.d6u);
                }
            }
        });
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return false;
                }
                n(this.F);
            } else {
                if (QLog.isDevelopLevel()) {
                    QLog.d("SwiftBrowserScreenShotHandler", 2, "handleMessage->recv msg_hide_pad time:" + System.currentTimeMillis());
                }
                u(false, 0);
            }
        } else {
            if (QLog.isDevelopLevel()) {
                QLog.d("SwiftBrowserScreenShotHandler", 2, "handleMessage->recv msg_show_pad time:" + System.currentTimeMillis());
            }
            this.N.removeMessages(2);
            u(true, message.arg1);
            this.N.sendEmptyMessageDelayed(2, 3000L);
        }
        return true;
    }

    public void i(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, str, str2, Integer.valueOf(i3));
            return;
        }
        e62.a aVar = this.P;
        if (aVar != null) {
            aVar.f(str, str2, i3);
        }
    }

    View j() {
        int i3;
        v vVar = (v) this.f314441d.getProvider().a(2);
        com.tencent.mobileqq.webview.swift.r rVar = vVar.f314512m;
        if (!rVar.f314618a && !rVar.f314619b) {
            i3 = R.id.jqh;
        } else {
            i3 = R.id.ae8;
        }
        View findViewById = this.f314276f.findViewById(i3);
        if (vVar.V != null) {
            return this.f314277h.getContentView();
        }
        return findViewById;
    }

    public String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.P.e();
    }

    public boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        if (this.C != null) {
            return true;
        }
        return false;
    }

    public void n(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
        } else {
            if (TextUtils.isEmpty(str)) {
                com.tencent.biz.qrcode.util.h.T(1, R.string.d6y);
                return;
            }
            Intent startEditPic = ((IAELaunchEditPic) QRoute.api(IAELaunchEditPic.class)).startEditPic(this.f314276f, str, true, true, true, true, true, 4);
            startEditPic.putExtra("EditPicType", this.P.b());
            this.f314276f.startActivity(startEditPic);
        }
    }

    public void o(String str) {
        e62.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        if (this.C == null && this.f314276f != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.f314276f.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.G = displayMetrics.widthPixels;
            this.H = displayMetrics.heightPixels;
            this.I = displayMetrics.density;
            com.tencent.biz.pubaccount.util.l lVar = new com.tencent.biz.pubaccount.util.l(this.f314276f, this.G, this.H);
            this.C = lVar;
            lVar.e(this);
            View j3 = j();
            if (j3 != null) {
                j3.setDrawingCacheEnabled(true);
                j3.getViewTreeObserver().addOnGlobalLayoutListener(new a(j3));
            }
            if (QLog.isColorLevel()) {
                QLog.d("SwiftBrowserScreenShotHandler", 2, "registerScreenshotObserver->mScreenWidth:" + this.G + ", mScreenHeight:" + this.H + ", mScreenDensity:" + this.I);
            }
        }
        if (!TextUtils.isEmpty(str) && (aVar = this.P) != null) {
            aVar.j(str.replace("|", "\uff5c"));
            return;
        }
        e62.a aVar2 = this.P;
        if (aVar2 != null && TextUtils.isEmpty(aVar2.h()) && this.f314276f != null) {
            this.P.j(BaseApplication.getContext().getResources().getString(R.string.d6t));
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
    public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) actionSheetItem, (Object) shareActionSheet);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->begin!");
        }
        if (actionSheetItem == null) {
            if (QLog.isColorLevel()) {
                QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->tag null!");
                return;
            }
            return;
        }
        int i3 = actionSheetItem.action;
        WebViewProvider webViewProvider = this.f314277h;
        if (webViewProvider == null) {
            return;
        }
        String url = webViewProvider.getWebView().getUrl();
        try {
            str = Uri.parse(url).getQueryParameter(AppConstants.Key.SHARE_REQ_ARTICLE_ID);
        } catch (Exception e16) {
            e16.printStackTrace();
            str = "";
        }
        if (str == null) {
            str = "";
        }
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 9) {
                    if (i3 != 10) {
                        if (i3 == 12) {
                            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800787A", "0X800787A", 0, 0, str, url, "", "");
                            ReportController.o(null, "dc00899", IPublicAccountHandler.MAIN_ACTION, "", "0X8006A1F", "0X8006A1F", 0, 0, QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_DOWNLOADERROR, str, "", "");
                            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X8006A1F", "", QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_DOWNLOADERROR, str, "", "");
                            if (QLog.isColorLevel()) {
                                QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->do action sina weibo!");
                            }
                        }
                    } else {
                        ReportController.o(null, "dc00899", IPublicAccountHandler.MAIN_ACTION, "", "0X8006A1F", "0X8006A1F", 0, 0, QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_AVCAMERAUSED, str, "", "");
                        ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X8006A1F", "", QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_AVCAMERAUSED, str, "", "");
                        if (QLog.isColorLevel()) {
                            QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->do action wechat circle!");
                        }
                    }
                } else {
                    ReportController.o(null, "dc00899", IPublicAccountHandler.MAIN_ACTION, "", "0X8006A1F", "0X8006A1F", 0, 0, "1003", str, "", "");
                    ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X8006A1F", "", "1003", str, "", "");
                    if (QLog.isColorLevel()) {
                        QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->do action wechat!");
                    }
                }
            } else {
                ReportController.o(null, "dc00899", IPublicAccountHandler.MAIN_ACTION, "", "0X8006A1F", "0X8006A1F", 0, 0, "1002", str, "", "");
                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X8006A1F", "", "1002", str, "", "");
                if (QLog.isColorLevel()) {
                    QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->do action qzone!");
                }
            }
        } else {
            ReportController.o(null, "dc00899", IPublicAccountHandler.MAIN_ACTION, "", "0X8006A1F", "0X8006A1F", 0, 0, "1001", str, "", "");
            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X8006A1F", "", "1001", str, "", "");
            if (QLog.isColorLevel()) {
                QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->do action friend!");
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->end!");
        }
    }

    public void p(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        e62.a aVar = this.P;
        if (aVar != null) {
            aVar.setUrl(str);
        }
    }

    public void q(String str) {
        e62.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        } else if (!TextUtils.isEmpty(str) && (aVar = this.P) != null) {
            aVar.d(str);
        }
    }

    public void r(String str) {
        e62.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        } else if (!TextUtils.isEmpty(str) && (aVar = this.P) != null) {
            aVar.j(str.replace("|", "\uff5c"));
        }
    }

    public void s(JSONArray jSONArray) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) jSONArray);
            return;
        }
        e62.a aVar = this.P;
        if (aVar != null) {
            aVar.l(jSONArray);
        }
    }

    public void t(String str) {
        e62.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else if (!TextUtils.isEmpty(str) && (aVar = this.P) != null) {
            aVar.a(str);
        }
    }

    void u(boolean z16, int i3) {
        ViewGroup viewGroup;
        int intValue;
        ViewGroup viewGroup2;
        if (QLog.isDevelopLevel()) {
            QLog.d("SwiftBrowserScreenShotHandler", 2, "showScreenshotPad->begin isShow:" + z16 + ", orientation:" + i3);
        }
        if (z16) {
            if (this.L) {
                return;
            }
            LinearLayout linearLayout = this.D;
            if (linearLayout != null && (linearLayout.getTag() instanceof Integer) && (intValue = ((Integer) this.D.getTag()).intValue()) != i3) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("SwiftBrowserScreenShotHandler", 2, "showScreenshotPad->orientation change old:" + intValue + ", new:" + i3);
                }
                RelativeLayout relativeLayout = (RelativeLayout) this.f314276f.findViewById(R.id.ae8);
                v vVar = (v) this.f314441d.getProvider().a(2);
                if (vVar != null && (viewGroup2 = vVar.V) != null) {
                    viewGroup2.findViewById(R.id.ae8);
                }
                this.D.setVisibility(8);
                relativeLayout.removeView(this.D);
                this.D = null;
            }
            if (this.D == null) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("SwiftBrowserScreenShotHandler", 2, "showScreenshotPad->pad create time:" + System.currentTimeMillis());
                }
                this.D = (LinearLayout) LayoutInflater.from(BaseApplication.getContext()).inflate(R.layout.f168427vw, (ViewGroup) null);
                RelativeLayout relativeLayout2 = (RelativeLayout) this.f314276f.findViewById(R.id.ae8);
                v vVar2 = (v) this.f314441d.getProvider().a(2);
                if (vVar2 != null && (viewGroup = vVar2.V) != null) {
                    viewGroup.findViewById(R.id.ae8);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(12);
                layoutParams.setMargins(0, 0, BaseAIOUtils.f(10.0f, BaseApplication.getContext().getResources()), BaseAIOUtils.f(65.0f, BaseApplication.getContext().getResources()));
                relativeLayout2.addView(this.D, layoutParams);
                this.D.setTag(Integer.valueOf(i3));
                if (i3 == 2) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.D.findViewById(R.id.f166826ii0).getLayoutParams();
                    layoutParams2.width = BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.a1d);
                    layoutParams2.height = BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.a1e);
                }
                this.D.findViewById(R.id.f166826ii0).setOnClickListener(new b());
            }
            if (this.D.getAnimation() != null) {
                this.D.getAnimation().cancel();
                this.D.clearAnimation();
            }
            ((ImageView) this.D.findViewById(R.id.f166826ii0)).setImageBitmap(this.E);
            this.D.setVisibility(0);
            if (QLog.isDevelopLevel()) {
                QLog.d("SwiftBrowserScreenShotHandler", 2, "showScreenshotPad->pad visible time:" + System.currentTimeMillis());
                return;
            }
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("SwiftBrowserScreenShotHandler", 2, "showScreenshotPad->begin hide mScreenshotContainer:" + this.D);
            if (this.D != null) {
                QLog.d("SwiftBrowserScreenShotHandler", 2, "showScreenshotPad->begin hide mScreenshotContainerVisibility:" + this.D.getVisibility());
            }
        }
        LinearLayout linearLayout2 = this.D;
        if (linearLayout2 != null && linearLayout2.getVisibility() == 0) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(300L);
            alphaAnimation.setAnimationListener(new c());
            this.D.startAnimation(alphaAnimation);
            if (QLog.isDevelopLevel()) {
                QLog.d("SwiftBrowserScreenShotHandler", 2, "showScreenshotPad->pad gone time:" + System.currentTimeMillis());
            }
        }
    }

    public void v() {
        View j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        com.tencent.biz.pubaccount.util.l lVar = this.C;
        if (lVar != null) {
            lVar.c();
            if (this.f314276f != null && (j3 = j()) != null) {
                j3.setDrawingCacheEnabled(false);
            }
            this.C = null;
            if (QLog.isColorLevel()) {
                QLog.d("SwiftBrowserScreenShotHandler", 2, "unregisterScreenshotObserver!");
            }
        }
    }
}
