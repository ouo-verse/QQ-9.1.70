package com.qzone.component.banner;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.FeedEnvImpl;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.qzone.util.ToastUtil;
import com.qzone.util.l;
import com.qzone.widget.AsynAutoGifImageView;
import com.qzone.widget.AsyncImageView;
import com.qzone.widget.AsyncImageable;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.drawable.AutoGifDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IQbossReportManager;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qzonehub.api.report.IQzoneExceptionReport;
import common.config.service.QzoneConfig;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.exception.QZoneNewStyleBannerCrashException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class NewStyleOperationAdsBanner extends Banner {

    /* renamed from: l1, reason: collision with root package name */
    public static String f46379l1 = "NewStyleOperationAdsBanner";
    protected final String A0;
    protected final String B0;
    protected AsyncImageView C;
    protected final String C0;
    protected AsynAutoGifImageView D;
    protected final String D0;
    protected TextView E;
    public String E0;
    protected TextView F;
    public String F0;
    protected TextView G;
    public String G0;
    protected ImageView H;
    protected String H0;
    protected ImageView I;
    protected String I0;
    protected AsyncImageView J;
    protected String J0;
    protected AsyncImageView K;
    protected String K0;
    protected AsynAutoGifImageView L;
    protected String L0;
    protected AsynAutoGifImageView M;
    protected String M0;
    protected LinearLayout N;
    protected String N0;
    protected String O0;
    protected TextView P;
    protected String P0;
    protected TextView Q;
    protected String Q0;
    protected TextView R;
    protected String R0;
    protected long S;
    protected String S0;
    protected long T;
    protected String T0;
    protected long U;
    protected String U0;
    protected long V;
    protected String V0;
    protected long W;
    public int W0;
    private final int X0;
    private final int Y0;
    private final int Z0;

    /* renamed from: a0, reason: collision with root package name */
    protected long f46380a0;

    /* renamed from: a1, reason: collision with root package name */
    private final int f46381a1;

    /* renamed from: b0, reason: collision with root package name */
    protected String f46382b0;

    /* renamed from: b1, reason: collision with root package name */
    private final int f46383b1;

    /* renamed from: c0, reason: collision with root package name */
    protected String f46384c0;

    /* renamed from: c1, reason: collision with root package name */
    private final int f46385c1;

    /* renamed from: d0, reason: collision with root package name */
    protected String f46386d0;

    /* renamed from: d1, reason: collision with root package name */
    private final int f46387d1;

    /* renamed from: e0, reason: collision with root package name */
    protected boolean f46388e0;

    /* renamed from: e1, reason: collision with root package name */
    private final int f46389e1;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f46390f0;

    /* renamed from: f1, reason: collision with root package name */
    private final int f46391f1;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f46392g0;

    /* renamed from: g1, reason: collision with root package name */
    private final int f46393g1;

    /* renamed from: h, reason: collision with root package name */
    protected RelativeLayout f46394h;

    /* renamed from: h0, reason: collision with root package name */
    private HashSet<String> f46395h0;

    /* renamed from: h1, reason: collision with root package name */
    private ScaleAnimation f46396h1;

    /* renamed from: i, reason: collision with root package name */
    protected RelativeLayout f46397i;

    /* renamed from: i0, reason: collision with root package name */
    protected com.qzone.feed.business.model.a f46398i0;

    /* renamed from: i1, reason: collision with root package name */
    private ScaleAnimation f46399i1;

    /* renamed from: j0, reason: collision with root package name */
    private View.OnClickListener f46400j0;

    /* renamed from: j1, reason: collision with root package name */
    protected Handler f46401j1;

    /* renamed from: k0, reason: collision with root package name */
    protected AsyncImageable.AsyncImageListener f46402k0;

    /* renamed from: k1, reason: collision with root package name */
    private Runnable f46403k1;

    /* renamed from: l0, reason: collision with root package name */
    protected final String f46404l0;

    /* renamed from: m, reason: collision with root package name */
    protected ImageView f46405m;

    /* renamed from: m0, reason: collision with root package name */
    protected final String f46406m0;

    /* renamed from: n0, reason: collision with root package name */
    protected final String f46407n0;

    /* renamed from: o0, reason: collision with root package name */
    protected final String f46408o0;

    /* renamed from: p0, reason: collision with root package name */
    protected final String f46409p0;

    /* renamed from: q0, reason: collision with root package name */
    protected final String f46410q0;

    /* renamed from: r0, reason: collision with root package name */
    protected final String f46411r0;

    /* renamed from: s0, reason: collision with root package name */
    protected final String f46412s0;

    /* renamed from: t0, reason: collision with root package name */
    protected final String f46413t0;

    /* renamed from: u0, reason: collision with root package name */
    protected final String f46414u0;

    /* renamed from: v0, reason: collision with root package name */
    protected final String f46415v0;

    /* renamed from: w0, reason: collision with root package name */
    protected final String f46416w0;

    /* renamed from: x0, reason: collision with root package name */
    protected final String f46417x0;

    /* renamed from: y0, reason: collision with root package name */
    protected final String f46418y0;

    /* renamed from: z0, reason: collision with root package name */
    protected final String f46419z0;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements AsynAutoGifImageView.a {
        a() {
        }

        @Override // com.qzone.widget.AsynAutoGifImageView.a
        public boolean isListViewScrollIdle() {
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            NewStyleOperationAdsBanner.this.D();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            NewStyleOperationAdsBanner newStyleOperationAdsBanner = NewStyleOperationAdsBanner.this;
            if (newStyleOperationAdsBanner.f46297e && newStyleOperationAdsBanner.f46398i0 != null) {
                newStyleOperationAdsBanner.g();
                NewStyleOperationAdsBanner newStyleOperationAdsBanner2 = NewStyleOperationAdsBanner.this;
                newStyleOperationAdsBanner2.D.f60157f = null;
                newStyleOperationAdsBanner2.f46390f0 = true;
                ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportClose(NewStyleOperationAdsBanner.this.f46398i0.f47123g.strTraceInfo, null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class g implements AsynAutoGifImageView.a {
        g() {
        }

        @Override // com.qzone.widget.AsynAutoGifImageView.a
        public boolean isListViewScrollIdle() {
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class h implements AsynAutoGifImageView.a {
        h() {
        }

        @Override // com.qzone.widget.AsynAutoGifImageView.a
        public boolean isListViewScrollIdle() {
            return true;
        }
    }

    public NewStyleOperationAdsBanner(Context context) {
        super(context);
        this.f46392g0 = true;
        this.f46395h0 = new HashSet<>();
        this.f46404l0 = "pic_type";
        this.f46406m0 = "picture";
        this.f46407n0 = "picture2";
        this.f46408o0 = "picture_md5";
        this.f46409p0 = "title";
        this.f46410q0 = "sub_title_type";
        this.f46411r0 = "nick_pattern";
        this.f46412s0 = "end_time";
        this.f46413t0 = "content_text";
        this.f46414u0 = "corner_mark";
        this.f46415v0 = QZoneAdTianshuFeedData.KEY_BUTTON_TEXT;
        this.f46416w0 = "adv_mark";
        this.f46417x0 = "bgm_pic_cover_left";
        this.f46418y0 = "bgm_pic_cover_right";
        this.f46419z0 = "floating_gif";
        this.A0 = "button_gif";
        this.B0 = "button_type";
        this.C0 = "url";
        this.D0 = "scheme_url";
        this.X0 = 0;
        this.Y0 = 1;
        this.Z0 = 2;
        this.f46381a1 = 0;
        this.f46383b1 = 1;
        this.f46385c1 = 2;
        this.f46387d1 = 3;
        this.f46389e1 = 0;
        this.f46391f1 = 1;
        this.f46393g1 = 2;
        this.f46401j1 = new b(Looper.getMainLooper());
        this.f46403k1 = new Runnable() { // from class: com.qzone.component.banner.NewStyleOperationAdsBanner.14
            @Override // java.lang.Runnable
            public void run() {
                Handler handler = NewStyleOperationAdsBanner.this.getHandler();
                if (handler != null) {
                    handler.sendEmptyMessage(0);
                    if (NewStyleOperationAdsBanner.this.f46388e0) {
                        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).postDelayed(this, 1000L);
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        long currentTimeMillis = System.currentTimeMillis();
        this.T = currentTimeMillis;
        long j3 = this.S - (currentTimeMillis / 1000);
        this.U = j3;
        long j16 = ((j3 % 86400) / 3600) + ((j3 / 86400) * 24);
        this.V = j16;
        this.W = (j3 % 3600) / 60;
        this.f46380a0 = j3 % 60;
        if (j3 < 0) {
            this.f46388e0 = false;
            this.N.setVisibility(8);
            this.G.setVisibility(0);
            this.G.setText(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewOnGoing", "\u6b63\u5728\u8fdb\u884c\u4e2d"));
            return;
        }
        if (j16 > 99) {
            this.V = 99L;
            this.W = 59L;
            this.f46380a0 = 59L;
        }
        long j17 = this.V;
        if (j17 < 10) {
            this.f46382b0 = "0" + String.valueOf(this.V);
        } else {
            this.f46382b0 = String.valueOf(j17);
        }
        long j18 = this.W;
        if (j18 < 10) {
            this.f46384c0 = "0" + String.valueOf(this.W);
        } else {
            this.f46384c0 = String.valueOf(j18);
        }
        long j19 = this.f46380a0;
        if (j19 < 10) {
            this.f46386d0 = "0" + String.valueOf(this.f46380a0);
        } else {
            this.f46386d0 = String.valueOf(j19);
        }
        this.P.setText(this.f46382b0);
        this.Q.setText(this.f46384c0);
        this.R.setText(this.f46386d0);
    }

    private void J(boolean z16) {
        i H = i.H();
        if (H instanceof FeedEnvImpl) {
            ((FeedEnvImpl) H).Y2(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A() {
        Map<String, String> map;
        E();
        com.qzone.feed.business.model.a aVar = this.f46398i0;
        if (aVar != null) {
            this.W0 = aVar.f47131o;
            BusinessADBannerData businessADBannerData = aVar.f47123g;
            if (businessADBannerData == null || (map = businessADBannerData.extendinfo) == null || map.isEmpty()) {
                return;
            }
            this.E0 = this.f46398i0.f47123g.extendinfo.get("pic_type");
            this.F0 = this.f46398i0.f47123g.extendinfo.get("picture");
            this.G0 = this.f46398i0.f47123g.extendinfo.get("picture2");
            this.H0 = this.f46398i0.f47123g.extendinfo.get("title");
            this.I0 = this.f46398i0.f47123g.extendinfo.get("sub_title_type");
            this.J0 = this.f46398i0.f47123g.extendinfo.get("nick_pattern");
            this.K0 = this.f46398i0.f47123g.extendinfo.get("end_time");
            this.L0 = this.f46398i0.f47123g.extendinfo.get("content_text");
            this.M0 = this.f46398i0.f47123g.extendinfo.get("corner_mark");
            this.N0 = this.f46398i0.f47123g.extendinfo.get(QZoneAdTianshuFeedData.KEY_BUTTON_TEXT);
            this.O0 = this.f46398i0.f47123g.extendinfo.get("adv_mark");
            this.P0 = this.f46398i0.f47123g.extendinfo.get("bgm_pic_cover_left");
            this.Q0 = this.f46398i0.f47123g.extendinfo.get("bgm_pic_cover_right");
            this.R0 = this.f46398i0.f47123g.extendinfo.get("floating_gif");
            this.S0 = this.f46398i0.f47123g.extendinfo.get("button_gif");
            this.T0 = this.f46398i0.f47123g.extendinfo.get("button_type");
        }
    }

    protected void B() {
        this.f46402k0 = new AsyncImageable.AsyncImageListener() { // from class: com.qzone.component.banner.NewStyleOperationAdsBanner.3
            @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
            public void onImageLoaded(AsyncImageable asyncImageable) {
                final Drawable drawable;
                Handler handler;
                NewStyleOperationAdsBanner newStyleOperationAdsBanner = NewStyleOperationAdsBanner.this;
                if (newStyleOperationAdsBanner.f46398i0 == null || !newStyleOperationAdsBanner.f46297e || (drawable = ((AsyncImageView) asyncImageable).getDrawable()) == null || (handler = NewStyleOperationAdsBanner.this.f46401j1) == null) {
                    return;
                }
                handler.post(new Runnable() { // from class: com.qzone.component.banner.NewStyleOperationAdsBanner.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        NewStyleOperationAdsBanner.this.D.setVisibility(8);
                        NewStyleOperationAdsBanner.this.C.setVisibility(0);
                        NewStyleOperationAdsBanner.this.C.setImageDrawable(drawable);
                        NewStyleOperationAdsBanner.this.c();
                    }
                });
            }

            @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
            public void onImageFailed(AsyncImageable asyncImageable) {
            }

            @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
            public void onImageStarted(AsyncImageable asyncImageable) {
            }

            @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
            public void onImageProgress(AsyncImageable asyncImageable, float f16) {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E() {
        this.E0 = "";
        this.F0 = "";
        this.G0 = "";
        this.H0 = "";
        this.I0 = "";
        this.J0 = "";
        this.K0 = "";
        this.L0 = "";
        this.M0 = "";
        this.N0 = "";
        this.O0 = "";
        this.P0 = "";
        this.Q0 = "";
        this.R0 = "";
        this.S0 = "";
        this.T0 = "";
        this.U0 = "";
        this.V0 = "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F() {
        if (TextUtils.isEmpty(this.F0)) {
            return;
        }
        this.C.setAsyncImageListener(this.f46402k0);
        this.C.setAsyncImage(this.F0);
    }

    protected void I() {
        if (this.f46394h == null || this.f46398i0 == null) {
            return;
        }
        int color = getResources().getColor(R.color.qzone_skin_feed_background_color);
        this.f46394h.setBackgroundColor(Color.argb(this.f46398i0.f47124h, Color.red(color), Color.green(color), Color.blue(color)));
    }

    @Override // com.qzone.component.banner.Banner
    public boolean c() {
        ImageView imageView = this.H;
        if (imageView != null) {
            imageView.bringToFront();
        }
        ImageView imageView2 = this.I;
        if (imageView2 != null) {
            imageView2.bringToFront();
        }
        return super.c();
    }

    @Override // com.qzone.component.banner.Banner
    public int d() {
        return 700;
    }

    @Override // com.qzone.component.banner.Banner
    public int e() {
        return 18;
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.f46401j1;
    }

    @Override // com.qzone.component.banner.Banner
    public void i(boolean z16) {
        AsynAutoGifImageView asynAutoGifImageView;
        if (this.f46297e) {
            if (z16) {
                AsyncImageView asyncImageView = this.C;
                if (asyncImageView == null && this.D == null) {
                    QZLog.w("BUG_NULL_BANNER_BG", "NewStyleOperationAdsBanner image uninitialized.");
                    return;
                }
                if (asyncImageView == null || this.D != null) {
                    if (asyncImageView == null && (asynAutoGifImageView = this.D) != null) {
                        if (asynAutoGifImageView.f() == null) {
                            QZLog.w("BUG_NULL_BANNER_BG", "NewStyleOperationAdsBanner image uninitialized.");
                            return;
                        }
                    } else if (asyncImageView.getDrawable() == null && this.D.f() == null) {
                        QZLog.w("BUG_NULL_BANNER_BG", "NewStyleOperationAdsBanner image uninitialized.");
                        return;
                    }
                } else if (asyncImageView.getDrawable() == null) {
                    QZLog.w("BUG_NULL_BANNER_BG", "NewStyleOperationAdsBanner image uninitialized.");
                    return;
                }
                H();
            }
            J(z16);
            this.f46394h.setVisibility(z16 ? 0 : 8);
            if (z16) {
                this.f46298f = false;
                com.qzone.feed.business.model.a aVar = this.f46398i0;
                if (aVar == null || aVar.f47123g == null) {
                    return;
                }
                if (this.f46392g0) {
                    if (aVar != null && !aVar.f47133q) {
                        ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportExpose(this.f46398i0.f47123g.strTraceInfo, null);
                        com.qzone.component.banner.util.a.d(e(), false, this.f46398i0.f47123g.iAdID);
                        this.f46398i0.f47133q = true;
                        QZLog.d(f46379l1, 1, "just exposed:" + this.f46398i0.f47123g.strTraceInfo);
                        ToastUtil.g(l.a(R.string.oqt) + this.f46398i0.f47123g.strTraceInfo, 5);
                        return;
                    }
                    QZLog.w(f46379l1, "has already exposed:" + this.f46398i0.f47123g.strTraceInfo);
                    this.f46401j1.postDelayed(new Runnable() { // from class: com.qzone.component.banner.NewStyleOperationAdsBanner.4
                        @Override // java.lang.Runnable
                        public void run() {
                            ToastUtil.g(l.a(R.string.oqu) + NewStyleOperationAdsBanner.this.f46398i0.f47123g.strTraceInfo, 5);
                        }
                    }, 500L);
                    return;
                }
                this.f46392g0 = true;
                ToastUtil.g(l.a(R.string.oqy), 5);
            }
        }
    }

    @Override // com.qzone.component.banner.Banner
    public boolean l() {
        return this.f46297e && this.f46394h.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        this.f46390f0 = true;
        ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportClick(this.f46398i0.f47123g.strTraceInfo, null);
        HashMap hashMap = new HashMap();
        hashMap.put("key1", "adbanner");
        if (QZLog.isDevelopLevel()) {
            QZLog.d("OperationAdsBanner", 4, "----jump url:" + this.f46398i0.f47123g.strJmpUrl);
            QZLog.d("OperationAdsBanner", 4, "----schemeUrl url:" + this.f46398i0.f47123g.schemeUrl);
            QZLog.d("OperationAdsBanner", 4, "----schemeUrlurl:" + this.V0);
            QZLog.d("OperationAdsBanner", 4, "----jumpurl:" + this.U0);
        }
        if (TextUtils.isEmpty(this.f46398i0.f47123g.schemeUrl) && TextUtils.isEmpty(this.f46398i0.f47123g.strJmpUrl)) {
            if (!TextUtils.isEmpty(this.V0) || !TextUtils.isEmpty(this.U0)) {
                yo.g gVar = new yo.g(this.V0);
                gVar.f450709b = this.U0;
                gVar.f450714g = hashMap;
                yo.d.b(getContext(), gVar);
            }
        } else {
            yo.g gVar2 = new yo.g(this.f46398i0.f47123g.schemeUrl);
            gVar2.f450709b = this.f46398i0.f47123g.strJmpUrl;
            gVar2.f450714g = hashMap;
            yo.d.b(getContext(), gVar2);
        }
        com.qzone.component.banner.util.a.b(e(), 0, true, String.valueOf(this.f46398i0.f47123g.iAdID), true);
    }

    private void H() {
        boolean z16 = false;
        try {
            if (Integer.parseInt(this.T0) == 1) {
                z16 = true;
            }
        } catch (Exception unused) {
        }
        if (z16 && this.E != null) {
            if (this.f46396h1 == null) {
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.15f, 1.0f, 1.15f, 1, 0.5f, 1, 0.5f);
                this.f46396h1 = scaleAnimation;
                scaleAnimation.setInterpolator(new AccelerateInterpolator());
                this.f46396h1.setDuration(500L);
                this.f46396h1.setAnimationListener(new c());
            }
            if (this.f46399i1 == null) {
                ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.15f, 1.0f, 1.15f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.f46399i1 = scaleAnimation2;
                scaleAnimation2.setInterpolator(new DecelerateInterpolator());
                this.f46399i1.setDuration(500L);
                this.f46399i1.setAnimationListener(new d());
            }
            this.E.clearAnimation();
            this.E.startAnimation(this.f46396h1);
        }
    }

    private void y() {
        this.f46388e0 = true;
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(this.f46403k1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean C() {
        try {
            return Integer.parseInt(this.E0) == 1;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.qzone.component.banner.Banner
    public void destroy() {
        this.f46388e0 = false;
        AsynAutoGifImageView asynAutoGifImageView = this.D;
        if (asynAutoGifImageView != null) {
            asynAutoGifImageView.g();
        }
        AsynAutoGifImageView asynAutoGifImageView2 = this.L;
        if (asynAutoGifImageView2 != null) {
            asynAutoGifImageView2.g();
        }
        super.destroy();
    }

    @Override // com.qzone.component.banner.Banner
    public void g() {
        this.f46388e0 = false;
        super.g();
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null) {
                return;
            }
            if (message.what == 0) {
                NewStyleOperationAdsBanner.this.G();
                return;
            }
            if (QZLog.isColorLevel()) {
                QZLog.d(NewStyleOperationAdsBanner.f46379l1, 2, "--NewStyleOperationAdsBanner --handleMessage default what = " + message.what);
            }
        }
    }

    private String z(String str, int i3) {
        if (str == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        int length = str.length();
        int i16 = 0;
        int i17 = 0;
        while (true) {
            if (i16 >= length) {
                break;
            }
            if (Character.isHighSurrogate(str.charAt(i16))) {
                i17++;
                if (i17 <= i3) {
                    sb5.append(str.charAt(i16));
                    int i18 = i16 + 1;
                    if (i18 < length) {
                        sb5.append(str.charAt(i18));
                    }
                    i16++;
                } else {
                    sb5.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
                    break;
                }
            } else {
                if (!Character.isLowSurrogate(str.charAt(i16))) {
                    int codePointAt = str.codePointAt(i16);
                    i17 = (codePointAt < 0 || codePointAt > 255) ? i17 + 2 : i17 + 1;
                    if (i17 <= i3) {
                        sb5.append(str.charAt(i16));
                    } else {
                        sb5.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
                        break;
                    }
                } else {
                    continue;
                }
                i16++;
            }
        }
        return sb5.toString();
    }

    @Override // com.qzone.component.banner.Banner
    public void t(com.qzone.feed.business.model.a aVar) {
        BusinessADBannerData businessADBannerData;
        if (aVar != null && (businessADBannerData = aVar.f47123g) != null && ((businessADBannerData.extendinfo != null || !TextUtils.isEmpty(businessADBannerData.dynBannerJsonData)) && this.f46297e)) {
            this.f46398i0 = aVar;
            I();
            A();
            ImageView imageView = this.f46405m;
            if (imageView != null) {
                imageView.setOnClickListener(this.f46400j0);
            }
            this.f46298f = true;
            if (!TextUtils.isEmpty(this.F0)) {
                if (C()) {
                    this.C.setVisibility(8);
                    this.D.setVisibility(0);
                    this.D.setLayerType(1, null);
                    this.D.setAdjustViewBounds(false);
                    String str = this.D.f60157f;
                    if (str != null && str.equals(this.F0)) {
                        this.f46401j1.post(new Runnable() { // from class: com.qzone.component.banner.NewStyleOperationAdsBanner.5
                            @Override // java.lang.Runnable
                            public void run() {
                                NewStyleOperationAdsBanner.this.c();
                            }
                        });
                    } else {
                        this.D.setAsynGifImage(this.F0, new g(), new AutoGifDrawable.GifDownloadCallBackListener() { // from class: com.qzone.component.banner.NewStyleOperationAdsBanner.7
                            @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
                            public void onImageLoaded(String str2, Drawable drawable, ImageLoader.Options options) {
                                NewStyleOperationAdsBanner.this.D.postInvalidate();
                                NewStyleOperationAdsBanner.this.f46401j1.post(new Runnable() { // from class: com.qzone.component.banner.NewStyleOperationAdsBanner.7.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        NewStyleOperationAdsBanner.this.c();
                                    }
                                });
                            }

                            @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
                            public void onImageCanceled(String str2, ImageLoader.Options options) {
                            }

                            @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
                            public void onImageFailed(String str2, ImageLoader.Options options) {
                            }

                            @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
                            public void onImageProgress(String str2, float f16, ImageLoader.Options options) {
                            }
                        });
                    }
                } else {
                    F();
                }
            }
            if (!TextUtils.isEmpty(this.H0)) {
                this.F.setText(this.H0);
            }
            this.G.setVisibility(8);
            this.N.setVisibility(8);
            if (!TextUtils.isEmpty(this.I0)) {
                int intValue = Integer.valueOf(this.I0).intValue();
                if (intValue == 0) {
                    this.f46388e0 = false;
                    this.G.setVisibility(0);
                    this.G.setText(this.L0);
                } else if (intValue == 1) {
                    this.f46388e0 = true;
                    try {
                        this.S = Long.parseLong(this.K0);
                    } catch (NumberFormatException e16) {
                        e16.printStackTrace();
                        this.S = 0L;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    this.T = currentTimeMillis;
                    long j3 = this.S - (currentTimeMillis / 1000);
                    this.U = j3;
                    if (j3 >= 0) {
                        this.N.setVisibility(0);
                        y();
                    } else {
                        this.f46388e0 = false;
                        this.N.setVisibility(8);
                        this.G.setVisibility(0);
                        this.G.setText(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewOnGoing", "\u6b63\u5728\u8fdb\u884c\u4e2d"));
                    }
                } else {
                    if (intValue != 2) {
                        this.f46388e0 = false;
                        g();
                        return;
                    }
                    this.f46388e0 = false;
                    this.G.setVisibility(0);
                    try {
                        String replace = this.J0.replace("{nickname}", z(LoginData.getInstance().getNickName(""), 6));
                        this.J0 = replace;
                        this.G.setText(replace);
                    } catch (Exception e17) {
                        e17.printStackTrace();
                        this.G.setVisibility(4);
                        ((IQzoneExceptionReport) QRoute.api(IQzoneExceptionReport.class)).doReport(new QZoneNewStyleBannerCrashException(e17), "\u5e7f\u544abanner\u5b57\u7b26\u4e32\u5904\u7406\u5931\u8d25");
                    }
                }
            }
            if (!TextUtils.isEmpty(this.M0)) {
                int intValue2 = Integer.valueOf(this.M0).intValue();
                if (intValue2 == 1) {
                    this.H.setVisibility(0);
                    this.H.setImageResource(R.drawable.gae);
                } else if (intValue2 != 2) {
                    this.H.setVisibility(8);
                } else {
                    this.H.setVisibility(0);
                    this.H.setImageResource(R.drawable.gag);
                }
            }
            if (!TextUtils.isEmpty(this.S0)) {
                this.L.setVisibility(0);
                this.E.setVisibility(4);
                this.L.setLayerType(1, null);
                this.L.setAdjustViewBounds(false);
                AsynAutoGifImageView asynAutoGifImageView = this.L;
                if (asynAutoGifImageView.f60157f != null) {
                    this.f46401j1.post(new Runnable() { // from class: com.qzone.component.banner.NewStyleOperationAdsBanner.8
                        @Override // java.lang.Runnable
                        public void run() {
                            NewStyleOperationAdsBanner.this.c();
                        }
                    });
                } else {
                    asynAutoGifImageView.setAsynGifImage(this.S0, new h(), new AutoGifDrawable.GifDownloadCallBackListener() { // from class: com.qzone.component.banner.NewStyleOperationAdsBanner.10
                        @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
                        public void onImageLoaded(String str2, Drawable drawable, ImageLoader.Options options) {
                            NewStyleOperationAdsBanner.this.L.postInvalidate();
                            NewStyleOperationAdsBanner.this.f46401j1.post(new Runnable() { // from class: com.qzone.component.banner.NewStyleOperationAdsBanner.10.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    NewStyleOperationAdsBanner.this.c();
                                }
                            });
                        }

                        @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
                        public void onImageCanceled(String str2, ImageLoader.Options options) {
                        }

                        @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
                        public void onImageFailed(String str2, ImageLoader.Options options) {
                        }

                        @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
                        public void onImageProgress(String str2, float f16, ImageLoader.Options options) {
                        }
                    });
                    this.L.h();
                }
            } else {
                this.L.setVisibility(8);
                if (!TextUtils.isEmpty(this.N0)) {
                    this.E.setVisibility(0);
                    this.E.setText(this.N0);
                } else {
                    this.E.setVisibility(8);
                }
            }
            if (!TextUtils.isEmpty(this.O0)) {
                int intValue3 = Integer.valueOf(this.O0).intValue();
                if (intValue3 == 0) {
                    this.I.setVisibility(0);
                    this.I.setImageResource(R.drawable.gaa);
                } else if (intValue3 == 1) {
                    this.I.setVisibility(0);
                    this.I.setImageResource(R.drawable.ga_);
                } else if (intValue3 == 2) {
                    this.I.setVisibility(8);
                }
            }
            if (!TextUtils.isEmpty(this.P0)) {
                this.J.setAsyncImage(this.P0);
            }
            if (!TextUtils.isEmpty(this.Q0)) {
                this.K.setAsyncImage(this.Q0);
            }
            if (TextUtils.isEmpty(this.R0)) {
                return;
            }
            this.M.setVisibility(0);
            this.M.setLayerType(1, null);
            this.M.setAdjustViewBounds(false);
            this.M.setAsynGifImage(this.R0, new a(), new AutoGifDrawable.GifDownloadCallBackListener() { // from class: com.qzone.component.banner.NewStyleOperationAdsBanner.12
                @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
                public void onImageLoaded(String str2, Drawable drawable, ImageLoader.Options options) {
                    NewStyleOperationAdsBanner.this.M.postInvalidate();
                    NewStyleOperationAdsBanner.this.f46401j1.post(new Runnable() { // from class: com.qzone.component.banner.NewStyleOperationAdsBanner.12.1
                        @Override // java.lang.Runnable
                        public void run() {
                            NewStyleOperationAdsBanner.this.c();
                        }
                    });
                }

                @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
                public void onImageCanceled(String str2, ImageLoader.Options options) {
                }

                @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
                public void onImageFailed(String str2, ImageLoader.Options options) {
                }

                @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
                public void onImageProgress(String str2, float f16, ImageLoader.Options options) {
                }
            });
            return;
        }
        g();
    }

    @Override // com.qzone.component.banner.Banner
    public void h(ViewStub viewStub) {
        if (viewStub == null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) viewStub.inflate();
        this.f46394h = relativeLayout;
        if (relativeLayout == null) {
            return;
        }
        relativeLayout.setVisibility(8);
        J(false);
        this.f46397i = (RelativeLayout) this.f46394h.findViewById(R.id.fe9);
        this.C = (AsyncImageView) this.f46394h.findViewById(R.id.feo);
        this.D = (AsynAutoGifImageView) this.f46394h.findViewById(R.id.fem);
        this.f46405m = (ImageView) this.f46397i.findViewById(R.id.fec);
        this.E = (TextView) this.f46397i.findViewById(R.id.fej);
        this.J = (AsyncImageView) this.f46397i.findViewById(R.id.fe_);
        this.K = (AsyncImageView) this.f46397i.findViewById(R.id.fea);
        this.L = (AsynAutoGifImageView) this.f46397i.findViewById(R.id.cuk);
        this.F = (TextView) this.f46397i.findViewById(R.id.fes);
        this.G = (TextView) this.f46397i.findViewById(R.id.fer);
        this.H = (ImageView) this.f46394h.findViewById(R.id.fee);
        this.I = (ImageView) this.f46394h.findViewById(R.id.fe8);
        LinearLayout linearLayout = (LinearLayout) this.f46397i.findViewById(R.id.feg);
        this.N = linearLayout;
        this.P = (TextView) linearLayout.findViewById(R.id.fef);
        this.Q = (TextView) this.N.findViewById(R.id.feh);
        this.R = (TextView) this.N.findViewById(R.id.fei);
        this.M = (AsynAutoGifImageView) this.f46394h.findViewById(R.id.fel);
        if (this.C == null || this.f46405m == null) {
            return;
        }
        this.f46394h.setOnClickListener(new e());
        this.f46400j0 = new f();
        B();
        this.f46297e = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements Animation.AnimationListener {
        c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            NewStyleOperationAdsBanner newStyleOperationAdsBanner = NewStyleOperationAdsBanner.this;
            if (newStyleOperationAdsBanner.E == null || newStyleOperationAdsBanner.f46399i1 == null) {
                return;
            }
            NewStyleOperationAdsBanner newStyleOperationAdsBanner2 = NewStyleOperationAdsBanner.this;
            newStyleOperationAdsBanner2.E.startAnimation(newStyleOperationAdsBanner2.f46399i1);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class d implements Animation.AnimationListener {
        d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            NewStyleOperationAdsBanner newStyleOperationAdsBanner = NewStyleOperationAdsBanner.this;
            if (newStyleOperationAdsBanner.E == null || newStyleOperationAdsBanner.f46396h1 == null) {
                return;
            }
            NewStyleOperationAdsBanner newStyleOperationAdsBanner2 = NewStyleOperationAdsBanner.this;
            newStyleOperationAdsBanner2.E.startAnimation(newStyleOperationAdsBanner2.f46396h1);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
