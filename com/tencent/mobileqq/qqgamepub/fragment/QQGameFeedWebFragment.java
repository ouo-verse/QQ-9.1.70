package com.tencent.mobileqq.qqgamepub.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.qwallet.temp.IQWalletApiProxy;
import com.tencent.avcore.jni.codec.HWColorFormat;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoRsp;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameWebPresenter;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qqgamepub.utils.g;
import com.tencent.mobileqq.qqgamepub.view.NavBarQQGamePub;
import com.tencent.mobileqq.qqgamepub.view.QQGamePubViewpager;
import com.tencent.mobileqq.qqgamepub.web.delegate.GameContentViewDelegate;
import com.tencent.mobileqq.qqgamepub.web.delegate.QQGameWebViewDelegate;
import com.tencent.mobileqq.qqgamepub.web.f;
import com.tencent.mobileqq.qqgamepub.web.view.QQGameIndicator2;
import com.tencent.mobileqq.qqgamepub.web.view.QQGamePubWebView;
import com.tencent.mobileqq.qqgamepub.web.view.UnreadTipLayout;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.URLUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import eipc.EIPCResult;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQGameFeedWebFragment extends QPublicBaseFragment implements mh2.c, jh2.c, QQGamePubWebView.a, QQGameWebViewDelegate.a, View.OnClickListener {
    static IPatchRedirector $redirector_;
    public QQGameWebPresenter C;
    public QQGameWebViewDelegate D;
    public GameContentViewDelegate E;
    private View F;
    private LinearLayout G;
    private RelativeLayout H;
    private QQGameIndicator2 I;
    private UnreadTipLayout J;
    private QQGamePubViewpager K;
    private GestureDetector L;
    private TextView M;
    private RelativeLayout N;
    private ImageView P;
    public TextView Q;
    public LinearLayout R;
    public ImageView S;
    public ImageView T;
    public NavBarQQGamePub U;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements IPreloadService.c {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQGameFeedWebFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService.c
        public void onResult(int i3, IPreloadService.PathResult pathResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) pathResult);
            } else if (i3 == 0 && !TextUtils.isEmpty(pathResult.folderPath)) {
                QLog.d("QQGamePub_GameWebPage", 1, "loading apng download succ!");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class b implements IPreloadService.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f264513a;

        b(View view) {
            this.f264513a = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQGameFeedWebFragment.this, (Object) view);
            }
        }

        @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService.c
        public void onResult(int i3, IPreloadService.PathResult pathResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                QQGameFeedWebFragment.this.Ih(i3, pathResult, this.f264513a);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) pathResult);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class c implements com.tencent.mobileqq.widget.navbar.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQGameFeedWebFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.navbar.a
        public void onItemSelect(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (i3 == 5) {
                ActivityURIRequest activityURIRequest = new ActivityURIRequest(QQGameFeedWebFragment.this.getBaseActivity(), IPublicAccountDetailActivity.ROUTE_NAME);
                activityURIRequest.extra().putString("uin", "2747277822");
                activityURIRequest.extra().putBoolean("fromQGamePub", true);
                QRoute.startUri(activityURIRequest, (o) null);
                return;
            }
            if (i3 == 1) {
                QQGameFeedWebFragment.this.Bh().l();
                QQGameFeedWebFragment.this.getBaseActivity().finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class d extends GestureDetector.SimpleOnGestureListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQGameFeedWebFragment.this);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) motionEvent)).booleanValue();
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) motionEvent)).booleanValue();
            }
            return super.onDoubleTapEvent(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) motionEvent)).booleanValue();
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class e implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQGameFeedWebFragment.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            return QQGameFeedWebFragment.this.L.onTouchEvent(motionEvent);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20404);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 40)) {
            redirector.redirect((short) 40);
            return;
        }
        l91.a.c(true);
        l91.a.a();
        GamePubAccountHelper.T("1");
    }

    public QQGameFeedWebFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.C = xh();
        }
    }

    private void Ch() {
        this.E.g();
    }

    private void Dh(View view) {
        this.N = (RelativeLayout) view.findViewById(R.id.f8b);
        this.P = (ImageView) view.findViewById(R.id.f8a);
        this.N.setBackgroundColor(-1);
        this.P.setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_newMsg_normal@2x.png"));
        this.N.setOnClickListener(this);
    }

    private void Eh() {
        int b16 = Ah().F().b();
        if (b16 > 1) {
            this.S.setVisibility(8);
            this.J.setVisibility(0);
            this.J.setUnreadNum(b16 - 1);
            this.J.setOnClickListener(this);
            this.J.post(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.fragment.QQGameFeedWebFragment.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQGameFeedWebFragment.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        QQGameFeedWebFragment.this.I.setVisibility(4);
                        QQGameFeedWebFragment.this.J.b();
                    }
                }
            });
            Ah().I().h();
        }
    }

    private void Fh(View view) {
        QQGameWebViewDelegate qQGameWebViewDelegate = new QQGameWebViewDelegate(Ah(), view);
        this.D = qQGameWebViewDelegate;
        qQGameWebViewDelegate.g(this);
        this.E = new GameContentViewDelegate(Ah(), view);
    }

    private boolean Hh() {
        if (getBaseActivity() != null && !getBaseActivity().isFinishing() && isAdded()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ih(int i3, IPreloadService.PathResult pathResult, View view) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable(i3, pathResult, view) { // from class: com.tencent.mobileqq.qqgamepub.fragment.QQGameFeedWebFragment.4
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f264509d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ IPreloadService.PathResult f264510e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ View f264511f;

            {
                this.f264509d = i3;
                this.f264510e = pathResult;
                this.f264511f = view;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, QQGameFeedWebFragment.this, Integer.valueOf(i3), pathResult, view);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (this.f264509d != 0 || TextUtils.isEmpty(this.f264510e.filePath)) {
                    QQGameFeedWebFragment.this.handleDefaultLoading();
                    return;
                }
                Drawable drawableForWallet = ((IQWalletApiProxy) QRoute.api(IQWalletApiProxy.class)).getDrawableForWallet(this.f264510e.filePath, null, null);
                if (drawableForWallet == null) {
                    QQGameFeedWebFragment.this.handleDefaultLoading();
                } else {
                    ((ImageView) this.f264511f.findViewById(R.id.xjj)).setImageDrawable(drawableForWallet);
                }
            }
        });
    }

    private void Jh() {
        this.D.h();
        this.E.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDefaultLoading() {
        this.G.removeAllViews();
        TextView textView = new TextView(getBaseActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = g.a(7.0f, BaseApplication.getContext().getResources());
        textView.setText(HardCodeUtil.qqStr(R.string.f17638314));
        textView.setTextColor(HWColorFormat.COLOR_FormatVendorStartUnused);
        ImageView imageView = new ImageView(getBaseActivity());
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mFailedDrawable = getBaseActivity().getResources().getDrawable(R.drawable.fos);
        obtain.mLoadingDrawable = getBaseActivity().getResources().getDrawable(R.drawable.fos);
        imageView.setImageDrawable(URLDrawable.getDrawable(MiniGamePublicAccountConst.HEAD_REFRESH, obtain));
        imageView.setVisibility(0);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setDuration(1000L);
        imageView.startAnimation(rotateAnimation);
        this.G.addView(imageView, new LinearLayout.LayoutParams(g.a(15.0f, BaseApplication.getContext().getResources()), g.a(15.0f, BaseApplication.getContext().getResources())));
        this.G.addView(textView, layoutParams);
    }

    private void initHead(View view) {
        this.H = (RelativeLayout) view.findViewById(R.id.bho);
        this.K = (QQGamePubViewpager) this.D.c().findViewById(R.id.c9m);
        this.I = (QQGameIndicator2) this.D.c().findViewById(R.id.fhp);
        this.Q = (TextView) view.findViewById(R.id.f112226nc);
        this.R = (LinearLayout) view.findViewById(R.id.yfx);
        this.T = (ImageView) view.findViewById(R.id.xkx);
        this.J = (UnreadTipLayout) this.D.c().findViewById(R.id.ydl);
        Ah().M(this.K, getContext());
        this.K.setOffscreenPageLimit(5);
        this.I.setViewPager(this.K);
        this.I.b();
        this.I.setPageListener(this);
        ImageView imageView = (ImageView) view.findViewById(R.id.icq);
        this.S = imageView;
        imageView.setImageDrawable(com.tencent.mobileqq.qqgamepub.data.b.d(null, null, "https://i.gtimg.cn/channel/imglib/202004/upload_a0fdb03e7c5c42246be0bf79cce9958f.png", "https://i.gtimg.cn/channel/imglib/202004/upload_a0fdb03e7c5c42246be0bf79cce9958f.png"));
        this.S.setOnClickListener(this);
        this.S.setVisibility(8);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.ars);
        imageView2.setVisibility(0);
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView2.setImageResource(R.drawable.njs);
        Eh();
    }

    private void initLoad(View view) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getBaseActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i3 = displayMetrics.heightPixels;
        this.G = (LinearLayout) view.findViewById(R.id.eet);
        int a16 = g.a(418.0f, BaseApplication.getContext().getResources());
        ViewGroup.LayoutParams layoutParams = this.G.getLayoutParams();
        layoutParams.height = g.a(i3 - a16, BaseApplication.getContext().getResources());
        this.G.setLayoutParams(layoutParams);
        IPreloadServiceProxy iPreloadServiceProxy = (IPreloadServiceProxy) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IPreloadServiceProxy.class, ProcessConstant.MULTI);
        if (TextUtils.isEmpty(com.tencent.mobileqq.qwallet.preload.a.j(MiniGamePublicAccountConst.QQGAME_WEB_LOADING_APNG, false, 0).filePath)) {
            handleDefaultLoading();
            yh(iPreloadServiceProxy);
        } else {
            zh(iPreloadServiceProxy, view);
        }
    }

    private void uh() {
        this.N.setVisibility(8);
        QQGamePubViewpager qQGamePubViewpager = this.K;
        if (qQGamePubViewpager != null) {
            qQGamePubViewpager.setCurrentItem(0);
        }
        Ah().I().b((String) this.P.getTag());
    }

    private void vh() {
        String str;
        QQGameMsgInfo A = Ah().A();
        String str2 = "";
        if (A == null) {
            str = "";
        } else {
            String str3 = A.gameAppId;
            if (!TextUtils.isEmpty(A.paMsgid)) {
                str2 = A.paMsgid;
            }
            str = str2;
            str2 = str3;
        }
        Ah().I().a(str2, str);
        ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).enterGameCenter(((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).getGamePubUrl());
    }

    private void yh(IPreloadServiceProxy iPreloadServiceProxy) {
        iPreloadServiceProxy.getResPath(MiniGamePublicAccountConst.QQGAME_WEB_LOADING_APNG, new a());
    }

    private void zh(IPreloadServiceProxy iPreloadServiceProxy, View view) {
        iPreloadServiceProxy.getResPath(MiniGamePublicAccountConst.QQGAME_WEB_LOADING_APNG, new b(view));
    }

    public QQGameWebPresenter Ah() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (QQGameWebPresenter) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        if (this.C == null) {
            this.C = xh();
        }
        return this.C;
    }

    public com.tencent.mobileqq.qqgamepub.web.a Bh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (com.tencent.mobileqq.qqgamepub.web.a) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        return Ah().C();
    }

    public void Gh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.D.e(getQBaseActivity(), Bh(), this);
        }
    }

    @Override // mh2.c
    public void R0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
            return;
        }
        com.tencent.mobileqq.qqgamepub.web.e F = Ah().F();
        if (F.c()) {
            if (F.d(i3)) {
                F.g(1);
                F.i();
                if (F.e()) {
                    o(true, F.b());
                    return;
                } else {
                    o(false, 0);
                    return;
                }
            }
            return;
        }
        o(false, 0);
    }

    @Override // mh2.c
    public int Rd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Integer) iPatchRedirector.redirect((short) 27, (Object) this)).intValue();
        }
        try {
            int f16 = this.E.f();
            if (QLog.isColorLevel()) {
                QLog.d("QQGamePub_GameWebPage", 1, "gameContentHeight=" + f16);
            }
            if (!Hh()) {
                return 417;
            }
            return (int) g.b(this.H.getMeasuredHeight() + f16, BaseApplication.getContext().getResources());
        } catch (Throwable th5) {
            QLog.d("QQGamePub_GameWebPage", 1, "getWebPading faile:" + th5.getMessage());
            return 417;
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.web.view.QQGamePubWebView.a
    public void Ve(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        com.tencent.mobileqq.qqgamepub.view.a d16 = Ah().i().d();
        if (i3 < g.a(Rd(), MobileQQ.sMobileQQ.getResources())) {
            if (d16 != null) {
                d16.onResume();
            }
        } else if (d16 != null) {
            d16.onPause();
        }
    }

    @Override // mh2.c
    public void W9(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, i3);
            return;
        }
        QQGamePubViewpager qQGamePubViewpager = this.K;
        if (qQGamePubViewpager != null) {
            qQGamePubViewpager.setCurrentItem(i3);
        }
    }

    @Override // mh2.c
    public int Wc() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Integer) iPatchRedirector.redirect((short) 36, (Object) this)).intValue();
        }
        QQGamePubViewpager qQGamePubViewpager = this.K;
        if (qQGamePubViewpager != null) {
            return qQGamePubViewpager.getCurrentItem();
        }
        return -1;
    }

    @Override // mh2.c
    public void Y5(Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) map);
            return;
        }
        QQGameWebViewDelegate qQGameWebViewDelegate = this.D;
        if (qQGameWebViewDelegate != null) {
            qQGameWebViewDelegate.d(map);
        }
    }

    @Override // mh2.c
    public void f7(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) str);
            return;
        }
        RelativeLayout relativeLayout = this.N;
        if (relativeLayout != null) {
            relativeLayout.setTag(str);
        }
    }

    @Override // mh2.c
    public QBaseActivity getBaseActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (QBaseActivity) iPatchRedirector.redirect((short) 39, (Object) this);
        }
        return getQBaseActivity();
    }

    public void initTitle(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view);
            return;
        }
        NavBarQQGamePub navBarQQGamePub = (NavBarQQGamePub) view.findViewById(R.id.rlCommenTitle);
        this.U = navBarQQGamePub;
        navBarQQGamePub.setGamePubType("1");
        this.E.i(this.U.g());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, (int) getResources().getDimension(R.dimen.title_bar_height));
        int statusBarHeight = ImmersiveUtils.getStatusBarHeight(MobileQQ.sMobileQQ.getApplicationContext());
        layoutParams.setMargins(0, statusBarHeight, 0, 0);
        this.U.setLayoutParams(layoutParams);
        QLog.d("QQGamePub_GameWebPage", 4, "statusBarHeight = " + statusBarHeight);
        ImageView imageView = (ImageView) this.U.findViewById(R.id.f165972dz1);
        this.U.setRightImage(getResources().getDrawable(R.drawable.dfq), getResources().getDrawable(R.drawable.f162247bi0));
        imageView.setImageResource(R.drawable.b6q);
        this.U.setBackgroundResource(R.drawable.njt);
        TextView titleTextView = this.U.getTitleTextView();
        this.M = titleTextView;
        titleTextView.setText(R.string.ivu);
        this.M.setTextColor(-1);
        this.U.setOnItemSelectListener(new c());
        initTitleEvent();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void initTitleEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            this.L = new GestureDetector(getBaseActivity(), new d());
            this.M.setOnTouchListener(new e());
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // mh2.c
    public void me() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        NavBarQQGamePub navBarQQGamePub = this.U;
        if (navBarQQGamePub != null) {
            navBarQQGamePub.k();
        }
    }

    @Override // mh2.c
    public void n3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        RelativeLayout relativeLayout = this.N;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    @Override // mh2.c
    public void o(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        if (!z16) {
            this.J.setVisibility(8);
            this.R.setVisibility(8);
            this.I.setVisibility(0);
            Ah().F().a();
            return;
        }
        this.S.setVisibility(8);
        this.J.setVisibility(0);
        this.J.setUnreadNum(i3);
    }

    @Override // mh2.c
    public void o5(EIPCResult eIPCResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) eIPCResult);
            return;
        }
        Bh().d();
        if (!Hh()) {
            QLog.e("QQGamePub_GameWebPage", 4, "QQGameFeedWebFragment Activity is null");
            return;
        }
        Ah().i().v(eIPCResult);
        Ah().r();
        if (Ah().i().l() > 0) {
            Ah().i().m(getQBaseActivity());
            this.K.setAdapter(Ah().H());
            this.I.b();
            int j3 = Ah().i().j();
            refreshHead(j3);
            Ah().Z(j3);
            Ah().L();
            return;
        }
        this.K.setAdapter(Ah().H());
        this.G.setVisibility(8);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        } else {
            super.onAttach(context);
            this.C.b(this);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        Bh().l();
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.f8b) {
                vh();
            } else if (id5 == R.id.icq) {
                uh();
            } else if (id5 == R.id.ydl) {
                wh();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
        } else {
            super.onCreate(bundle);
            com.tencent.mobileqq.qqgamepub.data.b.f264501a = true;
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            view = (View) iPatchRedirector.redirect((short) 2, this, layoutInflater, viewGroup, bundle);
        } else {
            Bh().k();
            Ah().U(getQBaseActivity());
            Ah().I().g(Ah().F().b());
            View inflate = layoutInflater.inflate(R.layout.eb_, viewGroup, false);
            this.F = inflate;
            Fh(inflate);
            Ah().Q(getQBaseActivity());
            Ah().N();
            initHead(this.F);
            Ah().B();
            Ch();
            Ah().Y();
            Ah().O();
            Bh().e();
            Gh();
            Dh(this.F);
            initTitle(this.F);
            initLoad(this.F);
            Ah().P();
            view = this.F;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        super.onDestroy();
        try {
            Jh();
            Ah().R();
            this.E.d();
            this.C.d();
        } catch (Throwable th5) {
            QLog.e("QQGamePub_GameWebPage", 4, "onDestroy err:" + th5.getMessage());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            super.onDestroyView();
            Ah().f0();
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this);
        } else {
            super.onDetach();
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.web.delegate.QQGameWebViewDelegate.a
    public void onPageFinished(WebView webView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) webView, (Object) str);
        } else {
            this.G.setVisibility(8);
            Ah().d0();
        }
    }

    @Override // jh2.c
    public void onPageScrolled(int i3, float f16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Integer.valueOf(i3), Float.valueOf(f16), Integer.valueOf(i16));
        }
    }

    @Override // jh2.c
    public void onPageSelected(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
        } else {
            Ah().u(i3, getQBaseActivity());
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.web.delegate.QQGameWebViewDelegate.a
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, webView, str, bitmap);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        super.onPause();
        this.D.i();
        com.tencent.mobileqq.qqgamepub.view.a d16 = Ah().i().d();
        if (d16 != null) {
            d16.onPause();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        super.onResume();
        this.D.j();
        com.tencent.mobileqq.qqgamepub.view.a d16 = Ah().i().d();
        if (d16 != null) {
            d16.onResume();
        }
        try {
            int l3 = Ah().i().l();
            QQGamePubViewpager qQGamePubViewpager = this.K;
            if (qQGamePubViewpager != null && l3 > 0 && qQGamePubViewpager.getCurrentItem() == l3) {
                this.K.setCurrentItem(l3 - 1);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        this.E.e();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            super.onStart();
        }
    }

    @Override // mh2.c
    public void q(GmpEnterInfoRsp gmpEnterInfoRsp, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, gmpEnterInfoRsp, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQGamePub_GameWebPage", 1, "rec game enter isSucc:" + z16);
        }
        if (!Hh()) {
            return;
        }
        if (z16) {
            if (this.U == null) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQGamePub_GameWebPage", 1, "show game enter icon");
            }
            this.U.setCurType(1);
            this.U.m(false);
            this.U.l(gmpEnterInfoRsp.icon, gmpEnterInfoRsp.content, gmpEnterInfoRsp.url);
            this.U.setmBubbleid(gmpEnterInfoRsp.bubbleId);
            GamePubAccountHelper.N(gmpEnterInfoRsp);
            Ah().I().e(gmpEnterInfoRsp.bubbleId, false);
            return;
        }
        ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).showGameEnterCacheInfo(this.U, gmpEnterInfoRsp);
        Ah().I().e(gmpEnterInfoRsp.bubbleId, true);
    }

    @Override // mh2.c
    public void refreshHead(int i3) {
        QQGamePubViewpager qQGamePubViewpager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, i3);
            return;
        }
        f H = Ah().H();
        if (Ah().H() != null) {
            H.l(Ah().E());
            this.I.b();
            if (i3 > 0) {
                Ah().i().r();
            }
            if (Hh() && (qQGamePubViewpager = this.K) != null && i3 > 0) {
                qQGamePubViewpager.setCurrentItem(i3);
            }
        }
    }

    public void wh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (this.K != null) {
            int b16 = Ah().F().b();
            int l3 = Ah().i().l();
            if (b16 >= 3) {
                this.K.setCurrentItem(Ah().G());
                return;
            }
            int currentItem = this.K.getCurrentItem();
            int i3 = currentItem + 1;
            if (i3 < l3) {
                this.K.setCurrentItem(i3);
            } else if (currentItem == l3 - 1) {
                this.K.setCurrentItem(l3);
            }
            if (b16 == 0) {
                this.I.setVisibility(0);
                this.J.setVisibility(4);
                this.I.d();
            }
        }
        Ah().I().i();
    }

    public QQGameWebPresenter xh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (QQGameWebPresenter) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return new QQGameWebPresenter();
    }

    @Override // mh2.c
    public void z2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.fragment.QQGameFeedWebFragment.8
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQGameFeedWebFragment.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    String feedWebUrl = ((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).getFeedWebUrl();
                    if (!URLUtil.isValidUrl(feedWebUrl)) {
                        return;
                    }
                    String f16 = QQGameFeedWebFragment.this.Ah().i().f(feedWebUrl, QQGameFeedWebFragment.this.Rd());
                    QQGameFeedWebFragment qQGameFeedWebFragment = QQGameFeedWebFragment.this;
                    qQGameFeedWebFragment.D.f(f16, qQGameFeedWebFragment.Bh());
                }
            });
        }
    }
}
