package com.tencent.mobileqq.microapp.widget.media;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.microapp.R;
import com.tencent.mobileqq.microapp.appbrand.page.ServiceWebview;
import com.tencent.mobileqq.microapp.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.microapp.appbrand.ui.AppBrandUI;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.superplayer.vinfo.TVKPlayerVideoInfo;
import com.tencent.qqmini.sdk.widget.media.MiniAppVideoConstants;
import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;
import java.util.Properties;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes15.dex */
public class MiniAppVideoPlayer extends FrameLayout implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final String f246186a;

    /* renamed from: aa, reason: collision with root package name */
    private boolean f246187aa;

    /* renamed from: ab, reason: collision with root package name */
    private View f246188ab;

    /* renamed from: ac, reason: collision with root package name */
    private long f246189ac;

    /* renamed from: b, reason: collision with root package name */
    public String f246190b;

    /* renamed from: c, reason: collision with root package name */
    public ServiceWebview f246191c;

    /* renamed from: d, reason: collision with root package name */
    public int f246192d;

    /* renamed from: e, reason: collision with root package name */
    public String f246193e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f246194f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f246195g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f246196h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f246197i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f246198j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f246199k;

    /* renamed from: l, reason: collision with root package name */
    public String f246200l;

    /* renamed from: m, reason: collision with root package name */
    public WeakReference f246201m;

    /* renamed from: n, reason: collision with root package name */
    public WebviewContainer f246202n;

    /* renamed from: o, reason: collision with root package name */
    public JSONObject f246203o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f246204p;

    /* renamed from: q, reason: collision with root package name */
    public a f246205q;

    /* renamed from: r, reason: collision with root package name */
    private View f246206r;

    /* renamed from: s, reason: collision with root package name */
    private TVK_IMediaPlayer f246207s;

    /* renamed from: t, reason: collision with root package name */
    private ViewGroup f246208t;

    /* renamed from: u, reason: collision with root package name */
    private IVideoViewBase f246209u;

    /* renamed from: v, reason: collision with root package name */
    private TVK_IProxyFactory f246210v;

    /* renamed from: w, reason: collision with root package name */
    private ImageView f246211w;

    /* renamed from: x, reason: collision with root package name */
    private ImageView f246212x;

    /* renamed from: y, reason: collision with root package name */
    private FrameLayout f246213y;

    /* renamed from: z, reason: collision with root package name */
    private Context f246214z;

    /* loaded from: classes15.dex */
    public class a implements Observer {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MiniAppVideoPlayer.this);
            }
        }

        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) observable, obj);
                return;
            }
            if (obj instanceof String) {
                String str = (String) obj;
                if (MiniAppVideoConstants.NOTIFY_STATUS_RESET.equals(str)) {
                    MiniAppVideoPlayer.this.g();
                    MiniAppVideoPlayer.this.a();
                    return;
                }
                if (MiniAppVideoConstants.NOTIFY_STATUS_RESUME.equals(str)) {
                    MiniAppVideoPlayer miniAppVideoPlayer = MiniAppVideoPlayer.this;
                    com.tencent.mobileqq.microapp.appbrand.a aVar = miniAppVideoPlayer.f246202n.appBrandRuntime;
                    if (aVar == null) {
                        return;
                    }
                    if (aVar.f245905j) {
                        miniAppVideoPlayer.g();
                        MiniAppVideoPlayer.this.a();
                    } else {
                        miniAppVideoPlayer.b();
                    }
                }
            }
        }
    }

    public MiniAppVideoPlayer(@NonNull Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            a(context);
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        WeakReference weakReference = this.f246201m;
        if (weakReference != null && weakReference.get() != null) {
            AppBrandUI appBrandUI = (AppBrandUI) this.f246201m.get();
            FrameLayout frameLayout = this.f246202n.appBrandRuntime.f245902g.fullScreenLayout;
            ViewGroup viewGroup = (ViewGroup) this.f246188ab.getParent();
            if (viewGroup == null) {
                return;
            }
            viewGroup.removeAllViews();
            this.f246204p = true;
            appBrandUI.getWindow().setFlags(1024, 1024);
            appBrandUI.getWindow().getDecorView().setSystemUiVisibility(2);
            appBrandUI.setRequestedOrientation(0);
            a((Activity) appBrandUI);
            frameLayout.addView(this.f246188ab);
            frameLayout.setVisibility(0);
            frameLayout.bringToFront();
        }
    }

    public long e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Long) iPatchRedirector.redirect((short) 11, (Object) this)).longValue();
        }
        return this.f246207s.getCurrentPostion();
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            a(e());
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        WeakReference weakReference = this.f246201m;
        if (weakReference == null || weakReference.get() == null || !this.f246204p) {
            return;
        }
        this.f246189ac = this.f246207s.getCurrentPostion();
        if (QLog.isColorLevel()) {
            QLog.d(this.f246186a, 2, "smallScreen current pos is: " + this.f246189ac);
        }
        this.f246204p = false;
        FrameLayout frameLayout = this.f246202n.appBrandRuntime.f245902g.fullScreenLayout;
        frameLayout.setVisibility(8);
        frameLayout.removeAllViews();
        AppBrandUI appBrandUI = (AppBrandUI) this.f246201m.get();
        if (appBrandUI != null) {
            appBrandUI.setRequestedOrientation(1);
            appBrandUI.getWindow().getDecorView().setSystemUiVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) view);
        } else if (view.getId() == R.id.k) {
            a(e());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        if (str.startsWith("wxfile")) {
            this.f246200l = com.tencent.mobileqq.microapp.appbrand.b.b.a().c(str);
        } else if (str.startsWith("http") || str.startsWith("https")) {
            this.f246200l = str;
        }
    }

    public void b(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSONObject);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.f246186a, 2, "initVideoPlayerSettings isFullScreen: " + this.f246204p);
        }
        if (this.f246204p) {
            return;
        }
        a(jSONObject);
        b(this.f246214z);
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.f246194f = false;
        if (this.f246207s.isPlaying()) {
            this.f246207s.pause();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("data", this.f246190b);
                this.f246191c.evaluteJs("WeixinJSBridge.subscribeHandler(\"onVideoPause\", " + jSONObject + "," + this.f246192d + ")");
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            this.f246207s.release();
        } else {
            iPatchRedirector.redirect((short) 10, (Object) this);
        }
    }

    public MiniAppVideoPlayer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f246186a = MiniAppVideoPlayer.class.getName();
        this.f246207s = null;
        this.f246209u = null;
        this.f246210v = null;
        this.f246194f = false;
        this.f246187aa = false;
        a(context);
    }

    public void a(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSONObject);
            return;
        }
        this.f246195g = jSONObject.optBoolean("showBasicControls");
        this.f246196h = jSONObject.optBoolean("enableDanmu");
        jSONObject.optBoolean("showDanmuBtn");
        this.f246197i = jSONObject.optBoolean("autoplay");
        this.f246198j = jSONObject.optBoolean("loop");
        jSONObject.optBoolean("pageGesture");
        this.f246199k = jSONObject.optBoolean("customCache");
        jSONObject.optBoolean("showProgress");
        jSONObject.optBoolean("showLiveBtn");
        jSONObject.optBoolean("showPlayBtn");
        jSONObject.optBoolean("showCenterPlayBtn");
        jSONObject.optBoolean("showFullScreenBtn");
        jSONObject.optBoolean("enableProgressGesture");
        if (StringUtil.isEmpty(this.f246193e)) {
            this.f246193e = jSONObject.optString(QAdVrReport.ElementID.AD_POSTER);
        }
        jSONObject.optInt("initialTime");
        TVK_IMediaPlayer tVK_IMediaPlayer = this.f246207s;
        if (tVK_IMediaPlayer != null) {
            this.f246189ac = tVK_IMediaPlayer.getCurrentPostion();
        }
    }

    private void b(Context context) {
        ImageView imageView;
        if (!this.f246187aa) {
            TVK_SDKMgr.initSdk(getContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
            this.f246187aa = true;
        }
        if (!TVK_SDKMgr.isInstalled(getContext())) {
            if (QLog.isColorLevel()) {
                QLog.d(this.f246186a, 2, "TVK_SDK is not installed");
                return;
            }
            return;
        }
        TVK_IProxyFactory proxyFactory = TVK_SDKMgr.getProxyFactory();
        this.f246210v = proxyFactory;
        if (proxyFactory == null) {
            return;
        }
        IVideoViewBase createVideoView_Scroll = proxyFactory.createVideoView_Scroll(context);
        this.f246209u = createVideoView_Scroll;
        TVK_IMediaPlayer createMediaPlayer = this.f246210v.createMediaPlayer(context, createVideoView_Scroll);
        this.f246207s = createMediaPlayer;
        if (createMediaPlayer == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View view = this.f246209u;
        this.f246188ab = view;
        view.setLayoutParams(layoutParams);
        this.f246188ab.setVisibility(0);
        this.f246207s.setXYaxis(2);
        if (!this.f246197i) {
            if (!StringUtil.isEmpty(this.f246193e)) {
                URLDrawable drawable = URLDrawable.getDrawable(this.f246193e, (URLDrawable.URLDrawableOptions) null);
                if (drawable != null && (imageView = this.f246211w) != null) {
                    imageView.setImageDrawable(drawable);
                }
            } else if (!StringUtil.isEmpty(this.f246200l)) {
                com.tencent.mobileqq.microapp.a.c.a(this.f246200l, new j(this));
            }
        }
        try {
            if (this.f246195g) {
                Properties properties = new Properties();
                if (this.f246196h) {
                    properties.put("mHaveDanmu", "true");
                    this.f246207s.attachDanmuView();
                }
                if (this.f246199k) {
                    properties.put("mHaveCacheDownload", "true");
                }
                this.f246207s.attachControllerView(properties);
            }
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
        }
        this.f246207s.setOnControllerClickListener(new k(this));
        this.f246207s.setOnVideoPreparedListener(new l(this));
        this.f246207s.setOnCompletionListener(new m(this));
        this.f246207s.setOnErrorListener(new p(this));
        this.f246207s.setOnInfoListener(new q(this));
        this.f246207s.setOnSeekCompleteListener(new r(this));
        this.f246213y.setVisibility(0);
        this.f246208t.removeAllViews();
        this.f246208t.addView(this.f246188ab);
        this.f246208t.setBackgroundColor(-16777216);
        if (this.f246189ac <= 0 || !NetworkUtil.isWifiConnected(this.f246214z)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.f246186a, 2, "play current pos is: " + this.f246189ac);
        }
        a(this.f246189ac);
    }

    private void a(Context context) {
        this.f246214z = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.b, (ViewGroup) null);
        this.f246206r = inflate;
        this.f246208t = (FrameLayout) inflate.findViewById(R.id.j);
        this.f246213y = (FrameLayout) this.f246206r.findViewById(R.id.r);
        this.f246211w = (ImageView) this.f246206r.findViewById(R.id.q);
        ImageView imageView = (ImageView) this.f246206r.findViewById(R.id.k);
        this.f246212x = imageView;
        imageView.setOnClickListener(this);
        addView(this.f246206r);
        this.f246205q = new a();
        com.tencent.mobileqq.microapp.a.a.a().a(new i(this));
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            this.f246207s.stop();
        } else {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    public void a(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, j3);
            return;
        }
        if (StringUtil.isEmpty(this.f246200l)) {
            return;
        }
        this.f246194f = true;
        this.f246207s.stop();
        TVK_PlayerVideoInfo tVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
        tVK_PlayerVideoInfo.setConfigMap(TVKPlayerVideoInfo.PLAYER_CFG_KEY_KEEP_LAST_FRAME, "true");
        if (this.f246198j) {
            tVK_PlayerVideoInfo.setPlayType(38);
            this.f246207s.setLoopback(true);
        }
        if (!this.f246200l.startsWith("http") && !this.f246200l.startsWith("https")) {
            tVK_PlayerVideoInfo.setPlayType(4);
        } else {
            tVK_PlayerVideoInfo.setPlayType(5);
        }
        if (this.f246196h) {
            this.f246207s.startPlayDanmu();
        }
        this.f246207s.openMediaPlayerByUrl(getContext(), this.f246200l, j3, 0L, tVK_PlayerVideoInfo);
        this.f246213y.setVisibility(8);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", this.f246190b);
            this.f246191c.evaluteJs("WeixinJSBridge.subscribeHandler(\"onVideoPlay\", " + jSONObject + "," + this.f246192d + ")");
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public void b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        TVK_IMediaPlayer tVK_IMediaPlayer = this.f246207s;
        if (tVK_IMediaPlayer != null) {
            tVK_IMediaPlayer.addDanmuContentForLocal(str);
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.f246194f = true;
        if (this.f246207s.isPauseing()) {
            this.f246207s.start();
        }
    }

    private void a(Activity activity) {
        activity.getWindow().getDecorView().getSystemUiVisibility();
        activity.getWindow().getDecorView().setSystemUiVisibility(5894 | 2048);
    }
}
