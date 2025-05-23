package com.qzone.module.personalitycomponent.coverWidget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.qzone.proxy.personalitycomponent.adapter.PLog;
import com.qzone.proxy.personalitycomponent.adapter.PersonalityConfig;
import com.qzone.proxy.personalitycomponent.adapter.PersonalityEnv;
import com.qzone.proxy.personalitycomponent.adapter.PersonalityResources;
import com.qzone.proxy.personalitycomponent.model.WidgetQzoneVipData;
import com.qzone.proxy.vipcomponent.VipComponentProxy;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasQzoneYellowThread;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import cooperation.qzone.zipanimate.ZipAnimationDrawable;
import cooperation.vip.vipcomponent.QQUnionIconInfo;
import cooperation.vip.vipcomponent.util.VipResourcesListener;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneWidgetQZoneVipController extends com.qzone.module.personalitycomponent.coverWidget.b {
    private int A;
    private int A0;
    private int B;
    private String B0;
    private int C;
    private String C0;
    private int D;
    private String D0;
    private int E;
    private ImageLoader.ImageLoadListener E0;
    private int F;
    private View.OnClickListener F0;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private boolean L;
    private int M;
    private int N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private int V;
    private int W;
    private int X;
    private Drawable.Callback Y;
    private Paint Z;

    /* renamed from: a0, reason: collision with root package name */
    private ZipAnimationDrawable f48840a0;

    /* renamed from: b0, reason: collision with root package name */
    private Drawable f48841b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f48842c0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f48843d0;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f48844e0;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f48845f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f48846g0;

    /* renamed from: h, reason: collision with root package name */
    private WidgetQzoneVipData f48847h;

    /* renamed from: h0, reason: collision with root package name */
    private int f48848h0;

    /* renamed from: i, reason: collision with root package name */
    private int f48849i;

    /* renamed from: i0, reason: collision with root package name */
    private Bitmap f48850i0;

    /* renamed from: j, reason: collision with root package name */
    private int f48851j;

    /* renamed from: j0, reason: collision with root package name */
    private Bitmap f48852j0;

    /* renamed from: k, reason: collision with root package name */
    private int f48853k;

    /* renamed from: k0, reason: collision with root package name */
    private Bitmap f48854k0;

    /* renamed from: l, reason: collision with root package name */
    private int f48855l;

    /* renamed from: l0, reason: collision with root package name */
    private NinePatch f48856l0;

    /* renamed from: m, reason: collision with root package name */
    private int f48857m;

    /* renamed from: m0, reason: collision with root package name */
    private NinePatch f48858m0;

    /* renamed from: n, reason: collision with root package name */
    private int f48859n;

    /* renamed from: n0, reason: collision with root package name */
    private NinePatch f48860n0;

    /* renamed from: o, reason: collision with root package name */
    private int f48861o;

    /* renamed from: o0, reason: collision with root package name */
    private Rect f48862o0;

    /* renamed from: p, reason: collision with root package name */
    private int f48863p;

    /* renamed from: p0, reason: collision with root package name */
    private Rect f48864p0;

    /* renamed from: q, reason: collision with root package name */
    private int f48865q;

    /* renamed from: q0, reason: collision with root package name */
    private Rect f48866q0;

    /* renamed from: r, reason: collision with root package name */
    private int f48867r;

    /* renamed from: r0, reason: collision with root package name */
    private Bitmap f48868r0;

    /* renamed from: s, reason: collision with root package name */
    private int f48869s;

    /* renamed from: s0, reason: collision with root package name */
    private Drawable f48870s0;

    /* renamed from: t, reason: collision with root package name */
    private int f48871t;

    /* renamed from: t0, reason: collision with root package name */
    private Bitmap f48872t0;

    /* renamed from: u, reason: collision with root package name */
    private int f48873u;

    /* renamed from: u0, reason: collision with root package name */
    private Drawable f48874u0;

    /* renamed from: v, reason: collision with root package name */
    private int f48875v;

    /* renamed from: v0, reason: collision with root package name */
    private Paint f48876v0;

    /* renamed from: w, reason: collision with root package name */
    private int f48877w;

    /* renamed from: w0, reason: collision with root package name */
    private RectF f48878w0;

    /* renamed from: x, reason: collision with root package name */
    private int f48879x;

    /* renamed from: x0, reason: collision with root package name */
    private int f48880x0;

    /* renamed from: y, reason: collision with root package name */
    private int f48881y;

    /* renamed from: y0, reason: collision with root package name */
    private int f48882y0;

    /* renamed from: z, reason: collision with root package name */
    private int f48883z;

    /* renamed from: z0, reason: collision with root package name */
    private int f48884z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements VipResourcesListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f48889a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f48890b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f48891c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f48892d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f48893e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f48894f;

        c(int i3, int i16, boolean z16, boolean z17, boolean z18, String str) {
            this.f48889a = i3;
            this.f48890b = i16;
            this.f48891c = z16;
            this.f48892d = z17;
            this.f48893e = z18;
            this.f48894f = str;
        }

        @Override // cooperation.vip.vipcomponent.util.VipResourcesListener
        public void onFailed() {
            if (QZoneWidgetQZoneVipController.this.f48842c0) {
                return;
            }
            QZoneWidgetQZoneVipController.this.f48842c0 = true;
            QZoneWidgetQZoneVipController.this.M(this.f48889a, this.f48890b, "", this.f48891c, this.f48892d, this.f48893e, this.f48894f);
            QZoneWidgetQZoneVipController.this.W();
            QZoneWidgetQZoneVipController.this.t();
        }

        @Override // cooperation.vip.vipcomponent.util.VipResourcesListener
        public void onLoaded(Drawable drawable) {
            QZoneWidgetQZoneVipController.this.L = false;
            QZoneWidgetQZoneVipController.this.f48841b0 = drawable;
            if (QZoneWidgetQZoneVipController.this.f48841b0 != null) {
                QZoneWidgetQZoneVipController.this.f48841b0.setBounds(0, 0, QZoneWidgetQZoneVipController.this.f48841b0.getIntrinsicWidth(), QZoneWidgetQZoneVipController.this.f48841b0.getIntrinsicHeight());
            }
            QZoneWidgetQZoneVipController.this.W();
            QZoneWidgetQZoneVipController.this.t();
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
            if (QZoneWidgetQZoneVipController.this.f48847h != null) {
                if (QZoneWidgetQZoneVipController.this.f48843d0) {
                    QZoneWidgetQZoneVipController qZoneWidgetQZoneVipController = QZoneWidgetQZoneVipController.this;
                    PersonalityEnv.clickUnionVip(qZoneWidgetQZoneVipController.f48932d, qZoneWidgetQZoneVipController.f48847h.uin);
                } else {
                    String str = QZoneWidgetQZoneVipController.this.f48847h.vipurl;
                    if (QZoneWidgetQZoneVipController.this.f48932d != null && !TextUtils.isEmpty(str)) {
                        String replace = PersonalityEnv.replaceWithQua(str).replace("{pkUin}", String.valueOf(QZoneWidgetQZoneVipController.this.f48847h.uin));
                        PLog.d("VipWidget", "\u9ec4\u94bb\u6302\u4ef6 vipurl = " + replace);
                        PersonalityEnv.report("", "", "", 308, 12);
                        PersonalityEnv.handleScheme(replace, QZoneWidgetQZoneVipController.this.f48932d, null);
                        if (!TextUtils.isEmpty(QZoneWidgetQZoneVipController.this.f48847h.widgetStrRedpointTrace)) {
                            PersonalityEnv.reportqbossClick(QZoneWidgetQZoneVipController.this.f48847h.widgetStrRedpointTrace);
                            QZoneWidgetQZoneVipController.this.f48847h.widgetStrRedpointTrace = "";
                            if (QZoneWidgetQZoneVipController.this.f48840a0 != null) {
                                QZoneWidgetQZoneVipController.this.f48840a0.stop();
                                QZoneWidgetQZoneVipController.this.f48840a0.release();
                                QZoneWidgetQZoneVipController.this.f48840a0 = null;
                            }
                            QZoneWidgetQZoneVipController.this.r();
                        }
                    } else {
                        PLog.w("VipWidget", "\u9ec4\u94bb\u6302\u4ef6 vipurl is empty");
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QZoneWidgetQZoneVipController(Context context, Handler handler) {
        super(context, handler);
        this.f48871t = -1;
        this.f48873u = -1;
        this.L = true;
        this.f48842c0 = false;
        this.f48843d0 = false;
        this.f48844e0 = false;
        this.f48845f0 = false;
        this.f48880x0 = PersonalityEnv.dpToPx(5.0f);
        this.f48882y0 = PersonalityEnv.dpToPx(3.0f);
        this.E0 = new d();
        this.F0 = new e();
        this.f48933e = handler;
        this.f48929a = 1000;
        this.f48932d = context;
        this.f48878w0 = new RectF();
        if (this.f48932d != null) {
            this.f48849i = PersonalityEnv.dpToPx(13.0f);
            this.f48851j = PersonalityEnv.dpToPx(7.0f);
            this.f48853k = PersonalityEnv.dpToPx(6.5f);
            this.f48855l = PersonalityEnv.dpToPx(30.0f);
            this.f48857m = PersonalityEnv.dpToPx(41.0f);
            this.f48859n = PersonalityEnv.dpToPx(-7.0f);
            this.f48863p = PersonalityEnv.dpToPx(25.0f);
            this.f48865q = PersonalityEnv.dpToPx(30.0f);
            this.f48867r = PersonalityEnv.dpToPx(-28.0f);
            this.f48879x = PersonalityEnv.dpToPx(107.0f);
            this.f48881y = PersonalityEnv.dpToPx(5.0f);
            this.f48883z = PersonalityEnv.dpToPx(13.0f);
            this.A = PersonalityEnv.dpToPx(13.0f);
            this.B = PersonalityEnv.dpToPx(16.0f);
            this.C = PersonalityEnv.dpToPx(3.0f);
            this.D = PersonalityEnv.dpToPx(7.0f);
            this.f48869s = PersonalityEnv.dpToPx(3.0f);
            this.F = PersonalityEnv.dpToPx(3.0f);
            this.E = PersonalityEnv.dpToPx(3.0f);
            this.G = PersonalityEnv.dpToPx(60.0f);
            this.H = PersonalityEnv.dpToPx(60.0f);
            this.I = PersonalityEnv.dpToPx(17.5f);
            this.K = ViewUtils.dpToPx(8.0f);
            this.J = PersonalityEnv.dpToPx(15.0f);
            this.M = PersonalityEnv.dpToPx(2.0f);
            this.N = PersonalityEnv.dpToPx(4.0f);
            this.O = PersonalityEnv.dpToPx(60.0f);
            this.P = PersonalityEnv.dpToPx(4.0f);
            this.Q = PersonalityEnv.dpToPx(12.5f);
            this.R = PersonalityEnv.dpToPx(11.5f);
            this.S = PersonalityEnv.dpToPx(123.0f);
            this.T = PersonalityEnv.dpToPx(44.0f);
            this.V = PersonalityEnv.dpToPx(1.5f);
            this.W = PersonalityEnv.dpToPx(3.5f);
            this.X = PersonalityEnv.dpToPx(2.5f);
            this.f48875v = PersonalityEnv.dpToPx(2.0f);
            this.f48877w = PersonalityEnv.dpToPx(4.0f);
            this.f48861o = PersonalityEnv.dpToPx(30.0f);
            this.f48846g0 = PersonalityEnv.dpToPx(25.0f);
            this.f48848h0 = PersonalityEnv.dpToPx(4.0f);
            Paint paint = new Paint();
            this.Z = paint;
            paint.setAntiAlias(true);
            this.Z.setShadowLayer(1.0f, 1.0f, 1.0f, Color.parseColor("#cc000000"));
        }
    }

    private ZipAnimationDrawable K(int i3) {
        ZipAnimationDrawable zipAnimationDrawable = new ZipAnimationDrawable();
        zipAnimationDrawable.setAnimationRes(PersonalityConfig.getConfig("H5Url", PersonalityConfig.SECONDARY_WIDGET_UNOPEN_YELLOW_DIAMOND_ANIMATION, "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-vip/yellow_vip_home.zip"), 15);
        zipAnimationDrawable.setRepeatAnimation(true);
        zipAnimationDrawable.setShowLastFrameWhenStop(true);
        Drawable.Callback callback = this.Y;
        if (callback != null) {
            zipAnimationDrawable.setCallback(callback);
        }
        return zipAnimationDrawable;
    }

    private boolean N(int i3, Map<String, QQUnionIconInfo> map) {
        QQUnionIconInfo qQUnionVipUrl = PersonalityResources.getQQUnionVipUrl(i3, map);
        if (qQUnionVipUrl == null || TextUtils.isEmpty(qQUnionVipUrl.mIconUrl)) {
            return false;
        }
        int dpToPx = ViewUtils.dpToPx(qQUnionVipUrl.mIconWidth / 2.0f);
        int dpToPx2 = ViewUtils.dpToPx(qQUnionVipUrl.mIconHeight / 2.0f);
        this.f48857m = dpToPx;
        this.f48855l = dpToPx2;
        Drawable loadImage = ImageLoader.getInstance().loadImage(qQUnionVipUrl.mIconUrl, new b(dpToPx, dpToPx2), (ImageLoader.Options) null);
        this.f48841b0 = loadImage;
        if (loadImage == null) {
            return true;
        }
        loadImage.setBounds(0, 0, dpToPx, dpToPx2);
        return true;
    }

    private boolean P() {
        return this.f48844e0 || this.f48843d0;
    }

    private boolean Q() {
        return (TextUtils.isEmpty(this.C0) || TextUtils.isEmpty(this.B0)) ? false : true;
    }

    private boolean R(int i3) {
        if (i3 != 0 && i3 != 2) {
            return true;
        }
        return false;
    }

    private boolean S(int i3) {
        if (i3 == 1 || i3 == 2 || i3 == 5) {
            return true;
        }
        return false;
    }

    private void U() {
        ZipAnimationDrawable zipAnimationDrawable = this.f48840a0;
        if (zipAnimationDrawable != null) {
            zipAnimationDrawable.stop();
            this.f48840a0.release();
            this.f48840a0 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        Drawable drawable;
        if (P() || (drawable = this.f48841b0) == null) {
            return;
        }
        this.f48857m = drawable.getIntrinsicWidth();
        this.f48855l = this.f48841b0.getIntrinsicHeight();
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public String b() {
        return "\u5f00\u901a\u9ec4\u94bb";
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public View.OnClickListener c() {
        return this.F0;
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public int d() {
        WidgetQzoneVipData widgetQzoneVipData = this.f48847h;
        if (widgetQzoneVipData == null) {
            return 0;
        }
        this.U = widgetQzoneVipData.nameplateFlag;
        if (!TextUtils.isEmpty(widgetQzoneVipData.widgetBg) && R(this.f48847h.comVipType) && !this.f48845f0) {
            return ViewUtils.dip2px(100.0f);
        }
        WidgetQzoneVipData widgetQzoneVipData2 = this.f48847h;
        if (widgetQzoneVipData2.isVip) {
            if (this.f48845f0) {
                return this.H;
            }
            int i3 = (widgetQzoneVipData2.vipLevel >= 8 ? this.f48859n + this.f48851j + 0 : 0) + (this.f48880x0 * 2) + this.f48855l + this.f48865q + this.f48867r + this.C + this.f48881y + this.f48883z;
            return (Q() || !TextUtils.isEmpty(this.D0)) ? i3 + this.A : i3;
        }
        if (this.f48840a0 != null) {
            return ViewUtils.dip2px(100.0f);
        }
        return 0;
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public int g() {
        return this.f48929a;
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public void k() {
        U();
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public void n() {
        ZipAnimationDrawable zipAnimationDrawable = this.f48840a0;
        if (zipAnimationDrawable != null) {
            zipAnimationDrawable.stop();
        }
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public void p() {
        ZipAnimationDrawable zipAnimationDrawable = this.f48840a0;
        if (zipAnimationDrawable != null) {
            zipAnimationDrawable.restartAnimation();
        }
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public void q() {
        U();
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public void r() {
        VasQzoneYellowThread.INSTANCE.execJob(new Runnable() { // from class: com.qzone.module.personalitycomponent.coverWidget.QZoneWidgetQZoneVipController.1
            @Override // java.lang.Runnable
            public void run() {
                QZoneWidgetQZoneVipController.this.T();
                QZoneWidgetQZoneVipController.this.t();
            }
        });
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public void v(Drawable.Callback callback) {
        this.Y = callback;
    }

    private void L(Canvas canvas, Drawable drawable, int i3, int i16) {
        canvas.translate(i3, i16);
        drawable.draw(canvas);
        canvas.translate(-i3, -i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(int i3, int i16, String str, boolean z16, boolean z17, boolean z18, String str2) {
        m15.a aVar = (m15.a) VipComponentProxy.f50997g.getUiInterface().getComVipIcon(i16, i3, z16, z17, z18, str2, 7, str, new c(i3, i16, z16, z17, z18, str2));
        if ((aVar == null || aVar.d()) && this.f48841b0 != null) {
            return;
        }
        if (aVar != null && !aVar.d()) {
            this.L = false;
        } else {
            this.L = true;
        }
        this.f48841b0 = aVar;
        if (aVar != null) {
            aVar.setBounds(0, 0, aVar.getIntrinsicWidth(), this.f48841b0.getIntrinsicHeight());
        }
    }

    private void V(Map<String, QQUnionIconInfo> map) {
        QQUnionIconInfo qQUnionIconInfo;
        if (map == null || map.isEmpty() || (qQUnionIconInfo = map.get("widget_icon")) == null) {
            return;
        }
        this.B0 = qQUnionIconInfo.mExtendInfo.get("digital_origin_id");
        this.C0 = qQUnionIconInfo.mExtendInfo.get("digital_text");
        String str = qQUnionIconInfo.mCommonMapExtendInfo.get("yvip_lv10_id");
        this.D0 = str;
        if (!TextUtils.isEmpty(str)) {
            this.D0 = "NO." + this.D0;
        }
        String str2 = qQUnionIconInfo.mExtendInfo.get("digital_start_color");
        String str3 = qQUnionIconInfo.mExtendInfo.get("digital_end_color");
        try {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                this.f48884z0 = Color.parseColor(str2);
                this.A0 = Color.parseColor(str3);
            }
            this.f48884z0 = -1;
            this.A0 = -1;
        } catch (NumberFormatException e16) {
            PLog.e("QZoneWidgetQZoneVipController", String.valueOf(PLog.USR), e16);
        }
    }

    public boolean O(Object obj) {
        return obj != null && (obj instanceof WidgetQzoneVipData);
    }

    protected void T() {
        int i3;
        boolean z16;
        Bitmap bitmapFromResource;
        boolean z17;
        if (this.f48847h == null || this.f48932d == null) {
            return;
        }
        this.f48874u0 = ImageLoader.getInstance().loadImage(this.f48847h.widgetBg, new a());
        WidgetQzoneVipData widgetQzoneVipData = this.f48847h;
        int i16 = widgetQzoneVipData.comVipType;
        int i17 = widgetQzoneVipData.comViplevel;
        this.U = widgetQzoneVipData.nameplateFlag;
        if (this.f48843d0) {
            i3 = widgetQzoneVipData.unionVipRatio;
        } else {
            i3 = widgetQzoneVipData.vipRatio;
        }
        String str = widgetQzoneVipData.personalizedYellowVipUrl;
        boolean z18 = widgetQzoneVipData.isComAnnualVip;
        boolean z19 = widgetQzoneVipData.isComAnnualVipEver;
        this.f48881y = ViewUtils.dip2px(8.0f);
        if (!R(i16) && !this.f48843d0) {
            WidgetQzoneVipData widgetQzoneVipData2 = this.f48847h;
            if (widgetQzoneVipData2.loginUin == widgetQzoneVipData2.uin && this.f48840a0 == null) {
                this.f48840a0 = K(i16);
            }
        } else {
            if (this.f48844e0 || !(z17 = this.f48843d0)) {
                if (this.f48845f0) {
                    ImageLoader.Options obtain = ImageLoader.Options.obtain();
                    obtain.clipWidth = this.G;
                    obtain.clipHeight = this.H;
                    int i18 = this.U;
                    if (i18 == 1) {
                        this.f48870s0 = ImageLoader.getInstance().loadImage("https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_widget_vip_bronze_nameplate.png", this.E0, obtain);
                    } else if (i18 == 2) {
                        this.f48870s0 = ImageLoader.getInstance().loadImage("https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_widget_vip_silver_nameplate.png", this.E0, obtain);
                    } else if (i18 == 3) {
                        this.f48870s0 = ImageLoader.getInstance().loadImage("https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_widget_vip_gold_nameplate.png", this.E0, obtain);
                    }
                    Bitmap bitmapFromResource2 = PersonalityResources.getBitmapFromResource(this.f48932d, PersonalityResources.DrawableID.qzone_widget_vip_namaplate_bg, 0, 0);
                    if (bitmapFromResource2 != null) {
                        this.f48872t0 = Bitmap.createScaledBitmap(bitmapFromResource2, this.S, this.T, false);
                    }
                }
                if (this.f48842c0) {
                    str = "";
                }
                if (this.f48844e0) {
                    z16 = N(-1, this.f48847h.qqNewIconMap);
                    V(this.f48847h.qqNewIconMap);
                } else {
                    z16 = false;
                }
                if (!z16) {
                    WidgetQzoneVipData widgetQzoneVipData3 = this.f48847h;
                    M(i16, i17, str, z18, z19, widgetQzoneVipData3.isCustomDiamondUser, widgetQzoneVipData3.customDiamondUrl);
                }
                if (this.f48850i0 == null) {
                    Bitmap bitmapFromResource3 = PersonalityResources.getBitmapFromResource(this.f48932d, PersonalityResources.DrawableID.qzone_widget_vip_progress_bg, this.f48879x, this.f48881y);
                    this.f48850i0 = bitmapFromResource3;
                    if (bitmapFromResource3 != null) {
                        Bitmap bitmap = this.f48850i0;
                        this.f48856l0 = new NinePatch(bitmap, bitmap.getNinePatchChunk(), null);
                    }
                    this.f48862o0 = new Rect();
                }
                if (this.f48854k0 == null) {
                    Bitmap bitmapFromResource4 = PersonalityResources.getBitmapFromResource(this.f48932d, PersonalityResources.DrawableID.qzone_widget_vip_progress_value, this.f48879x, this.f48881y);
                    this.f48854k0 = bitmapFromResource4;
                    if (bitmapFromResource4 != null) {
                        Bitmap bitmap2 = this.f48854k0;
                        this.f48860n0 = new NinePatch(bitmap2, bitmap2.getNinePatchChunk(), null);
                    }
                    this.f48866q0 = new Rect();
                }
            } else if (z17) {
                this.f48881y = ViewUtils.dip2px(5.0f);
                WidgetQzoneVipData widgetQzoneVipData4 = this.f48847h;
                N(widgetQzoneVipData4.unionVipLevel, widgetQzoneVipData4.qqUnionIconMap);
                if (this.f48852j0 == null) {
                    Bitmap bitmapFromResource5 = PersonalityResources.getBitmapFromResource(this.f48932d, PersonalityResources.DrawableID.qzone_union_vip_progress_bg, this.f48879x, this.f48881y);
                    this.f48852j0 = bitmapFromResource5;
                    if (bitmapFromResource5 != null) {
                        Bitmap bitmap3 = this.f48852j0;
                        this.f48858m0 = new NinePatch(bitmap3, bitmap3.getNinePatchChunk(), null);
                    }
                    this.f48864p0 = new Rect();
                }
                this.f48876v0 = new Paint();
                this.f48876v0.setShader(new LinearGradient(0.0f, 0.0f, (i3 * this.f48879x) / 100, this.f48881y, new int[]{Color.parseColor("#2D6AD0"), Color.parseColor("#BD26AD"), Color.parseColor("#FF394E"), Color.parseColor("#FFA830")}, new float[]{0.0f, 0.33f, 0.66f, 1.0f}, Shader.TileMode.CLAMP));
                PersonalityEnv.reportUnionVipShow(this.f48847h.uin);
            }
            W();
            if (this.f48868r0 == null && (bitmapFromResource = PersonalityResources.getBitmapFromResource(this.f48932d, PersonalityResources.DrawableID.qzone_widget_vip_progress_divider, 2, this.D)) != null) {
                this.f48868r0 = Bitmap.createScaledBitmap(bitmapFromResource, 2, this.D, false);
            }
        }
        if (PLog.isColorLevel()) {
            PLog.d("QZoneWidgetQZoneVipController", PLog.CLR, "WidgetQzoneVipData uin: " + this.f48847h.uin + "type: " + i16 + "level: " + this.f48847h.vipLevel + "isAnnualVip:" + this.f48847h.isAnnualVip);
        }
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public int e() {
        return ViewUtils.dip2px(134.0f);
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public void w(Object obj) {
        int i3;
        if (obj != null && (obj instanceof WidgetQzoneVipData) && O(obj)) {
            WidgetQzoneVipData widgetQzoneVipData = (WidgetQzoneVipData) obj;
            this.f48847h = widgetQzoneVipData;
            if (!widgetQzoneVipData.isCustomDiamondUser && !TextUtils.isEmpty(widgetQzoneVipData.personalizedYellowVipUrl)) {
                this.f48842c0 = false;
            } else {
                this.f48842c0 = true;
            }
            WidgetQzoneVipData widgetQzoneVipData2 = this.f48847h;
            this.f48843d0 = widgetQzoneVipData2.isUnionVip && widgetQzoneVipData2.showUnionVip;
            boolean z16 = widgetQzoneVipData2.showNewVip;
            this.f48844e0 = z16;
            if (z16) {
                this.f48843d0 = false;
            }
            this.f48845f0 = !z16 && !this.f48843d0 && (i3 = widgetQzoneVipData2.nameplateFlag) > 0 && i3 < 4;
            T();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:160:0x05af  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0057  */
    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void l(Canvas canvas) {
        WidgetQzoneVipData widgetQzoneVipData;
        boolean z16;
        int i3;
        boolean z17;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        int i36;
        int i37;
        NinePatch ninePatch;
        Rect rect;
        NinePatch ninePatch2;
        Rect rect2;
        int i38;
        NinePatch ninePatch3;
        Rect rect3;
        Rect rect4;
        NinePatch ninePatch4;
        NinePatch ninePatch5;
        Rect rect5;
        if (canvas == null || (widgetQzoneVipData = this.f48847h) == null || this.Z == null || this.f48932d == null) {
            return;
        }
        String str = widgetQzoneVipData.vipLeftDays;
        if (str != null && str.length() > 0) {
            WidgetQzoneVipData widgetQzoneVipData2 = this.f48847h;
            if (widgetQzoneVipData2.loginUin == widgetQzoneVipData2.uin) {
                z16 = true;
                WidgetQzoneVipData widgetQzoneVipData3 = this.f48847h;
                i3 = widgetQzoneVipData3.comVipType;
                int i39 = widgetQzoneVipData3.comViplevel;
                z17 = this.f48843d0;
                if (!z17) {
                    i16 = widgetQzoneVipData3.unionVipScore;
                } else {
                    i16 = widgetQzoneVipData3.vipScore;
                }
                if (!z17) {
                    i17 = widgetQzoneVipData3.unionVipSpeed;
                } else {
                    i17 = widgetQzoneVipData3.vipSpeed;
                }
                if (!z17) {
                    i18 = widgetQzoneVipData3.unionVipRatio;
                } else {
                    i18 = widgetQzoneVipData3.vipRatio;
                }
                if (!z17) {
                    i19 = widgetQzoneVipData3.unionVipKeepDays;
                } else {
                    i19 = widgetQzoneVipData3.vipKeepdays;
                }
                if (!R(i3)) {
                    Drawable drawable = this.f48874u0;
                    if (drawable != null && !this.f48845f0) {
                        drawable.setBounds(0, 0, ViewUtils.dip2px(134.0f), ViewUtils.dip2px(100.0f));
                        this.f48874u0.draw(canvas);
                        canvas.translate(ViewUtils.dip2px(16.0f), ViewUtils.dip2px(30.0f));
                    }
                    if (this.f48845f0) {
                        int i46 = this.Q;
                        int i47 = this.U;
                        int i48 = i47 == 1 ? this.W + 0 : 0;
                        if (i47 == 2) {
                            i48 += this.V;
                        }
                        Bitmap bitmap = this.f48872t0;
                        if (bitmap != null) {
                            canvas.drawBitmap(bitmap, this.R, i46, this.Z);
                        }
                        Drawable drawable2 = this.f48870s0;
                        if (drawable2 != null) {
                            drawable2.setBounds(0, i48, this.G + 0, this.H + i48);
                            this.f48870s0.draw(canvas);
                        }
                        i26 = (this.G - this.f48857m) / 2;
                        i27 = (this.H - this.f48855l) / 2;
                    } else {
                        i26 = this.f48882y0 + 0;
                        i27 = this.f48880x0 + 0;
                    }
                    Drawable drawable3 = this.f48841b0;
                    if (drawable3 != null) {
                        L(canvas, drawable3, i26, i27);
                    }
                    if (this.f48845f0) {
                        i27 += this.J;
                    }
                    if (!P() && S(i3) && i39 >= 8) {
                        i27 = i27 + this.f48851j + this.f48859n;
                    }
                    int i49 = i27 + this.f48855l + this.f48867r + this.f48865q;
                    if (this.f48845f0) {
                        i49 -= this.J;
                        this.Z.setColor(Color.parseColor("#ffc000"));
                    } else {
                        this.Z.setColor(Color.parseColor(TipsElementData.DEFAULT_COLOR));
                    }
                    this.Z.setFakeBoldText(true);
                    this.Z.setTextSize(PersonalityEnv.dpToPx(10.0f));
                    int i56 = (int) (this.Z.getFontMetrics().descent - this.Z.getFontMetrics().ascent);
                    if (this.f48845f0) {
                        i29 = this.G + this.M;
                        i36 = (this.J + i56) - 10;
                        this.Z.setTextSize(PersonalityEnv.dpToPx(8.0f));
                        i28 = 0;
                    } else {
                        int i57 = i56 * 2;
                        i28 = i49 > i57 ? (i49 - i57) / 4 : 0;
                        i29 = i26 + this.f48857m + (this.f48882y0 * 2);
                        i36 = i56 + i28;
                    }
                    this.Z.setColor(Color.parseColor(TipsElementData.DEFAULT_COLOR));
                    float f16 = i29;
                    float f17 = i36;
                    canvas.drawText("\u6210\u957f\u503c", f16, f17, this.Z);
                    int i58 = i19;
                    int i59 = i18;
                    canvas.drawText("\u901f\u5ea6", ((int) this.Z.measureText("\u6210\u957f\u503c")) + i29 + PersonalityEnv.dpToPx(13.0f), f17, this.Z);
                    if (this.f48845f0) {
                        i37 = i36 + this.X + i56;
                    } else {
                        i37 = (int) ((i49 - i28) - this.Z.getFontMetrics().descent);
                    }
                    if (!this.f48843d0 && z16) {
                        if (this.f48847h.vipLeftDays.equals("0")) {
                            canvas.drawText("\u5c06\u4e8e\u4eca\u5929\u5230\u671f", f16, i37, this.Z);
                        } else {
                            canvas.drawText(String.format("\u8fd8\u6709%s\u5929\u5230\u671f", this.f48847h.vipLeftDays), f16, i37, this.Z);
                        }
                    } else {
                        float f18 = i37;
                        canvas.drawText(i16 + "", ((this.Z.measureText("\u6210\u957f\u503c") - this.Z.measureText(i16 + "")) / 2.0f) + f16, f18, this.Z);
                        canvas.drawText(i17 + "", ((int) this.Z.measureText("\u6210\u957f\u503c")) + i29 + PersonalityEnv.dpToPx(13.0f) + ((this.Z.measureText("\u901f\u5ea6") - this.Z.measureText(i17 + "")) / 2.0f), f18, this.Z);
                    }
                    if (this.f48845f0) {
                        int i65 = i37 + this.N;
                        if (this.f48850i0 != null && (ninePatch5 = this.f48856l0) != null && (rect5 = this.f48862o0) != null) {
                            rect5.left = i29;
                            rect5.top = i65;
                            rect5.right = this.O + i29;
                            rect5.bottom = this.P + i65;
                            ninePatch5.draw(canvas, rect5);
                        }
                        if (this.f48854k0 != null && (rect4 = this.f48866q0) != null && (ninePatch4 = this.f48860n0) != null) {
                            rect4.left = i29;
                            rect4.top = i65;
                            int i66 = ((this.O * this.f48847h.vipRatio) / 100) + i29;
                            rect4.right = i66;
                            int i67 = this.B;
                            if (i66 < i29 + i67) {
                                rect4.right = i29 + i67;
                            }
                            rect4.bottom = this.P + i65;
                            ninePatch4.draw(canvas, rect4);
                        }
                        String str2 = "\u8fde\u7eed\u5728\u7f51  " + this.f48847h.vipKeepdays + "\u5929";
                        this.Z.setColor(-1);
                        this.Z.setTextSize(PersonalityEnv.dpToPx(6.0f));
                        canvas.drawText(str2, f16, i65 + this.f48883z, this.Z);
                        return;
                    }
                    int i68 = i49 + this.C;
                    int i69 = this.f48879x;
                    int i75 = (i59 * i69) / 100;
                    if (this.f48843d0) {
                        if (this.f48852j0 == null || (ninePatch3 = this.f48858m0) == null || (rect3 = this.f48864p0) == null) {
                            i38 = 0;
                        } else {
                            i38 = 0;
                            rect3.left = 0;
                            rect3.top = i68;
                            rect3.right = i69 + 0;
                            rect3.bottom = this.f48881y + i68;
                            ninePatch3.draw(canvas, rect3);
                        }
                        RectF rectF = this.f48878w0;
                        rectF.left = i38;
                        rectF.top = i68;
                        rectF.right = i38 + i75;
                        rectF.bottom = this.f48881y + i68;
                        canvas.drawRoundRect(rectF, 6.0f, 6.0f, this.f48876v0);
                    } else {
                        if (this.f48850i0 != null && (ninePatch2 = this.f48856l0) != null && (rect2 = this.f48862o0) != null) {
                            rect2.left = 0;
                            rect2.top = i68;
                            rect2.right = i69 + 0;
                            rect2.bottom = this.f48881y + i68;
                            ninePatch2.draw(canvas, rect2);
                        }
                        if (this.f48854k0 != null && (ninePatch = this.f48860n0) != null && (rect = this.f48866q0) != null) {
                            rect.left = 0;
                            rect.top = i68;
                            int i76 = ((this.f48879x * i59) / 100) + 0;
                            rect.right = i76;
                            int i77 = this.B;
                            if (i76 < i77 + 0) {
                                rect.right = i77 + 0;
                            }
                            rect.bottom = this.f48881y + i68;
                            ninePatch.draw(canvas, rect);
                        }
                    }
                    if (this.f48868r0 != null) {
                        int i78 = 0;
                        while (i78 < 4) {
                            i78++;
                            canvas.drawBitmap(this.f48868r0, ((this.f48879x * i78) / 5) - 1, i68, this.Z);
                        }
                    }
                    this.Z.setFakeBoldText(false);
                    this.Z.setTextSize(PersonalityEnv.dpToPx(6.0f));
                    this.Z.setColor(Color.parseColor("#a64600"));
                    int i79 = (int) (this.Z.getFontMetrics().descent - this.Z.getFontMetrics().ascent);
                    String str3 = i59 + "%";
                    int measureText = (i75 - ((int) this.Z.measureText(str3))) - this.F;
                    if (measureText < 0) {
                        measureText = 0;
                    }
                    int i85 = this.f48881y;
                    int i86 = i85 > i79 ? (i85 - i79) / 2 : 0;
                    float f19 = measureText + this.E;
                    if (i79 >= i85) {
                        i79 = i85;
                    }
                    canvas.drawText(str3, f19, ((i79 + i68) + i86) - this.Z.getFontMetrics().descent, this.Z);
                    this.Z.setColor(-1);
                    this.Z.setFakeBoldText(true);
                    this.Z.setTextSize(PersonalityEnv.dpToPx(10.0f));
                    canvas.drawText("\u8fde\u7eed\u5728\u7f51\u65f6\u957f       " + i58 + "\u5929", 0.0f, ((this.f48881y + i68) + this.f48883z) - 5, this.Z);
                    if (!TextUtils.isEmpty(this.D0)) {
                        this.Z.setColor(-1);
                        this.Z.setFakeBoldText(true);
                        this.Z.setTextSize(PersonalityEnv.dpToPx(10.0f));
                        canvas.drawText("LV10\u4e13\u5c5eID  ", 0.0f, (((this.f48881y + i68) + this.f48883z) + this.A) - 5, this.Z);
                        float measureText2 = this.Z.measureText("LV10\u4e13\u5c5eID  ");
                        float f26 = (((this.f48881y + i68) + this.f48883z) + this.A) - 5;
                        ViewUtils.dpToPx(64.0f);
                        int dpToPx = ViewUtils.dpToPx(11.0f);
                        float measureText3 = this.Z.measureText(this.D0) + 5.0f + ViewUtils.dpToPx(4.0f);
                        float f27 = dpToPx;
                        this.Z.setShader(new LinearGradient(measureText2, (ViewUtils.dpToPx(2.0f) + f26) - f27, ViewUtils.dpToPx(4.0f) + measureText2 + measureText3, f26 + ViewUtils.dpToPx(2.0f), new int[]{Color.parseColor("#1AE5F8"), Color.parseColor("#3874F4"), Color.parseColor("#FF7BCA")}, (float[]) null, Shader.TileMode.CLAMP));
                        canvas.drawRoundRect(new RectF(measureText2, (ViewUtils.dpToPx(2.0f) + f26) - f27, ViewUtils.dpToPx(4.0f) + measureText2 + measureText3, f26 + ViewUtils.dpToPx(2.0f)), ViewUtils.dpToPx(5.0f), ViewUtils.dpToPx(5.0f), this.Z);
                        this.Z.setShader(null);
                        this.Z.setColor(-1);
                        this.Z.setFakeBoldText(true);
                        canvas.drawText(this.D0, measureText2 + ViewUtils.dpToPx(4.0f), (((i68 + this.f48881y) + this.f48883z) + this.A) - 5, this.Z);
                        return;
                    }
                    if (Q()) {
                        String str4 = this.C0 + "    " + this.B0;
                        int i87 = this.f48881y;
                        int i88 = this.f48883z;
                        int i89 = this.A;
                        this.Z.setShader(new LinearGradient(0.0f, (((i68 + i87) + i88) + (i89 / 2)) - 5, 0.0f, (((i87 + i68) + i88) + i89) - 5, this.f48884z0, this.A0, Shader.TileMode.CLAMP));
                        this.Z.setTextSize(PersonalityEnv.dpToPx(10.0f));
                        canvas.drawText(str4, 0.0f, (((i68 + this.f48881y) + this.f48883z) + this.A) - 5, this.Z);
                        this.Z.setShader(null);
                        return;
                    }
                    return;
                }
                ZipAnimationDrawable zipAnimationDrawable = this.f48840a0;
                if (zipAnimationDrawable != null) {
                    zipAnimationDrawable.setBounds(0, 0, ViewUtils.dip2px((float) (zipAnimationDrawable.getIntrinsicWidth() / 2.0d)), ViewUtils.dip2px((float) (this.f48840a0.getIntrinsicHeight() / 2.0d)));
                    this.f48840a0.draw(canvas);
                    if (this.f48840a0.isRunning()) {
                        return;
                    }
                    this.f48840a0.start();
                    return;
                }
                return;
            }
        }
        z16 = false;
        WidgetQzoneVipData widgetQzoneVipData32 = this.f48847h;
        i3 = widgetQzoneVipData32.comVipType;
        int i392 = widgetQzoneVipData32.comViplevel;
        z17 = this.f48843d0;
        if (!z17) {
        }
        if (!z17) {
        }
        if (!z17) {
        }
        if (!z17) {
        }
        if (!R(i3)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements ImageLoader.ImageLoadListener {
        a() {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            QZoneWidgetQZoneVipController.this.f48874u0 = drawable;
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements ImageLoader.ImageLoadListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f48886d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f48887e;

        b(int i3, int i16) {
            this.f48886d = i3;
            this.f48887e = i16;
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
            PLog.d("VipWidget", "getUnionVipIcon fail vipurl = " + str);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            QZoneWidgetQZoneVipController.this.f48841b0 = drawable;
            if (QZoneWidgetQZoneVipController.this.f48841b0 != null) {
                QZoneWidgetQZoneVipController.this.f48841b0.setBounds(0, 0, this.f48886d, this.f48887e);
            }
            QZoneWidgetQZoneVipController.this.W();
            QZoneWidgetQZoneVipController.this.t();
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class d implements ImageLoader.ImageLoadListener {
        d() {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            QZoneWidgetQZoneVipController.this.f48870s0 = drawable;
            QZoneWidgetQZoneVipController.this.t();
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }
}
