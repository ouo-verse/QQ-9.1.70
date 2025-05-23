package com.tencent.mobileqq.vas.adv.qzone.logic;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.qq.e.comm.constants.Constants;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.util.e;
import com.tencent.gdtad.util.j;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoViewFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasQzoneYellowThread;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;
import com.tencent.mobileqq.vas.adv.qzone.api.IVasQZoneApi;
import com.tencent.mobileqq.vas.adv.qzone.data.VasAdMetaReportParam;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.xweb.FileReaderHelper;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import qz2.VasAdMetaReportParamNew;
import rz2.a;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes20.dex */
public class AdVideoViewController implements IAdVideoViewController {
    private float B;
    private float C;
    private boolean D;
    private int E;
    private int F;
    private WeakReference<com.tencent.mobileqq.vas.adv.qzone.logic.a> J;

    /* renamed from: a, reason: collision with root package name */
    private Context f308176a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f308177b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f308178c;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f308179d;

    /* renamed from: e, reason: collision with root package name */
    private ViewStub f308180e;

    /* renamed from: f, reason: collision with root package name */
    private View f308181f;

    /* renamed from: g, reason: collision with root package name */
    private ViewGroup f308182g;

    /* renamed from: i, reason: collision with root package name */
    private AlumBasicData f308184i;

    /* renamed from: j, reason: collision with root package name */
    private AdvRoundFrameLayout f308185j;

    /* renamed from: k, reason: collision with root package name */
    private ImageView f308186k;

    /* renamed from: l, reason: collision with root package name */
    BaseVideoView f308187l;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f308188m;

    /* renamed from: n, reason: collision with root package name */
    private ImageView f308189n;

    /* renamed from: o, reason: collision with root package name */
    private ImageView f308190o;

    /* renamed from: p, reason: collision with root package name */
    private AdvRoundFrameLayout f308191p;

    /* renamed from: q, reason: collision with root package name */
    private TextView f308192q;

    /* renamed from: r, reason: collision with root package name */
    private ImageView f308193r;

    /* renamed from: y, reason: collision with root package name */
    private boolean f308200y;

    /* renamed from: s, reason: collision with root package name */
    private long f308194s = 0;

    /* renamed from: t, reason: collision with root package name */
    private int f308195t = 0;

    /* renamed from: u, reason: collision with root package name */
    private boolean f308196u = false;

    /* renamed from: v, reason: collision with root package name */
    private long f308197v = 0;

    /* renamed from: w, reason: collision with root package name */
    private boolean f308198w = false;

    /* renamed from: x, reason: collision with root package name */
    private boolean f308199x = false;

    /* renamed from: z, reason: collision with root package name */
    private boolean f308201z = false;
    private boolean A = true;
    public ArrayList<AdExposureChecker> G = new ArrayList<>();
    public AdExposureChecker.ExposureCallback H = null;
    private WeakReference<Activity> I = null;
    private final View.OnTouchListener K = new a();
    View.OnClickListener L = new b();

    /* renamed from: h, reason: collision with root package name */
    private Handler f308183h = new Handler(Looper.getMainLooper());

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements View.OnTouchListener {
        a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0021, code lost:
        
            if (r3 != 3) goto L24;
         */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (view != null && motionEvent != null) {
                int x16 = (int) motionEvent.getX();
                int y16 = (int) motionEvent.getY();
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            float x17 = motionEvent.getX();
                            if (AdVideoViewController.this.D && Math.abs(x17 - AdVideoViewController.this.B) > AdVideoViewController.this.C && x17 > AdVideoViewController.this.B) {
                                view.getParent().requestDisallowInterceptTouchEvent(false);
                            }
                        }
                    } else {
                        e.b(j.f109555a.d(), "" + AdVideoViewController.this.f308184i.traceId, new j.Location(x16, y16));
                    }
                    view.getParent().requestDisallowInterceptTouchEvent(false);
                } else {
                    AdVideoViewController.this.B = motionEvent.getX();
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    e.b(j.f109555a.c(), "" + AdVideoViewController.this.f308184i.traceId, new j.Location(x16, y16));
                }
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements View.OnClickListener {

        /* compiled from: P */
        /* loaded from: classes20.dex */
        class a implements AdExposureChecker.ExposureCallback {
            a() {
            }

            @Override // com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback
            public void onExposure(WeakReference<View> weakReference) {
                QZLog.i("AdExposureChecker", "onExposure");
                if (!TextUtils.isEmpty(AdVideoViewController.this.f308184i.qqbexposureInfor)) {
                    AdVideoViewController adVideoViewController = AdVideoViewController.this;
                    adVideoViewController.R(adVideoViewController.f308184i.qqbexposureInfor);
                }
                AdVideoViewController adVideoViewController2 = AdVideoViewController.this;
                adVideoViewController2.P(4, adVideoViewController2.f308184i.recCookie);
            }
        }

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            long j3;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view != null && view.getId() == R.id.seg) {
                QZLog.i("AdVideoViewController", " @getGdtInfo dispear");
                if (!TextUtils.isEmpty(AdVideoViewController.this.f308184i.negativeFeedbackUrl)) {
                    AdVideoViewController.this.R(AdVideoViewController.this.f308184i.negativeFeedbackUrl.replace("__ACT_TYPE__", "2001"));
                }
                if (AdVideoViewController.this.f308182g != null) {
                    AdVideoViewController.this.f308188m.setVisibility(8);
                    AdVideoViewController adVideoViewController = AdVideoViewController.this;
                    adVideoViewController.P(3, adVideoViewController.f308184i.recCookie);
                    AdVideoViewController adVideoViewController2 = AdVideoViewController.this;
                    adVideoViewController2.C(adVideoViewController2.f308187l, adVideoViewController2.f308182g);
                    AdVideoViewController.this.f308201z = true;
                }
            } else {
                BaseVideoView baseVideoView = AdVideoViewController.this.f308187l;
                if (baseVideoView != null) {
                    j3 = baseVideoView.getCurPlayingPos();
                } else {
                    j3 = 0;
                }
                long j16 = j3;
                com.tencent.mobileqq.vas.adv.qzone.logic.b bVar = com.tencent.mobileqq.vas.adv.qzone.logic.b.f308265a;
                WeakReference<Activity> weakReference = AdVideoViewController.this.I;
                Context context = AdVideoViewController.this.f308176a;
                AdVideoViewController adVideoViewController3 = AdVideoViewController.this;
                bVar.d(weakReference, context, adVideoViewController3.H, adVideoViewController3.f308184i, j16);
                if (AdVideoViewController.this.f308184i != null) {
                    AdVideoViewController adVideoViewController4 = AdVideoViewController.this;
                    adVideoViewController4.P(2, adVideoViewController4.f308184i.recCookie);
                }
                if (AdVideoViewController.this.f308184i != null) {
                    AdVideoViewController adVideoViewController5 = AdVideoViewController.this;
                    if (adVideoViewController5.H == null) {
                        adVideoViewController5.H = new a();
                    }
                    if (AdVideoViewController.this.J != null && AdVideoViewController.this.J.get() != null) {
                        ((com.tencent.mobileqq.vas.adv.qzone.logic.a) AdVideoViewController.this.J.get()).a(String.valueOf(AdVideoViewController.this.f308184i.aid), AdVideoViewController.this.F());
                    }
                }
                AdVideoViewController.this.f308198w = true;
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class c implements AdExposureChecker.ExposureCallback {
        c() {
        }

        @Override // com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback
        public void onExposure(WeakReference<View> weakReference) {
            QZLog.i("AdExposureChecker", "onExposure");
            if (!TextUtils.isEmpty(AdVideoViewController.this.f308184i.qqbexposureInfor)) {
                AdVideoViewController adVideoViewController = AdVideoViewController.this;
                adVideoViewController.R(adVideoViewController.f308184i.qqbexposureInfor);
            }
            AdVideoViewController adVideoViewController2 = AdVideoViewController.this;
            adVideoViewController2.P(4, adVideoViewController2.f308184i.recCookie);
        }
    }

    public AdVideoViewController(Context context) {
        this.f308176a = context;
    }

    private void B(AlumBasicData alumBasicData) {
        if (!QZoneFeedxAdvAdaptUtil.e(alumBasicData)) {
            return;
        }
        QZoneFeedxAdvAdaptUtil.a(this.f308182g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean E(AlumBasicData alumBasicData) {
        boolean z16;
        boolean z17 = false;
        if (alumBasicData == null) {
            return false;
        }
        int i3 = LocalMultiProcConfig.getInt(LocalMultiProcConfig.PREFS_NAME_LOCAL_QZ_SETTING, LocalMultiProcConfig.QZONE_SET_PLAYMODE, 0);
        if (i3 == 2 || (i3 == 0 && !NetworkUtil.isWifiConnected(this.f308176a))) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 && alumBasicData.autoPlay == 1) {
            z17 = true;
        }
        this.f308199x = z17;
        if (QLog.isColorLevel()) {
            QLog.d("AdVideoViewController", 2, "getCanAutoPlay = " + this.f308199x);
        }
        return this.f308199x;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String F() {
        int i3;
        AlumBasicData alumBasicData = this.f308184i;
        if (alumBasicData == null || (i3 = alumBasicData.sourceFrom) == 1 || i3 != 2) {
            return "";
        }
        return "pg_qz_group_album_endpage";
    }

    private RelativeLayout.LayoutParams H() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f308182g.getLayoutParams();
        this.E = (vz2.a.f443771a.b(this.f308176a) - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
        this.F = (int) Math.floor((r1 * 9) / 16.0f);
        return new RelativeLayout.LayoutParams(-1, this.F);
    }

    private void N() {
        WeakReference<com.tencent.mobileqq.vas.adv.qzone.logic.a> weakReference;
        AlumBasicData alumBasicData = this.f308184i;
        if (alumBasicData == null) {
            QLog.e("AdVideoViewController", 1, "reportDtExpo error");
        } else if (!alumBasicData.isDtExpoReport && (weakReference = this.J) != null && weakReference.get() != null) {
            this.J.get().b(String.valueOf(this.f308184i.aid), F());
            this.f308184i.isDtExpoReport = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(int i3, long j3, long j16, int i16, int i17, boolean z16, String str) {
        a.C11196a c11196a = new a.C11196a();
        c11196a.b(i3).c(z16).g(j3).d(j16).e(i16).f(i17);
        O(c11196a.a(), str);
    }

    private void U(TextView textView, @NonNull AlumBasicData alumBasicData) {
        if (textView == null) {
            return;
        }
        if (!TextUtils.isEmpty(alumBasicData.rightBottomButton)) {
            textView.setText(alumBasicData.rightBottomButton);
        } else if (alumBasicData.adInfo.product_type.get() == 12) {
            textView.setText(R.string.yjw);
        } else {
            textView.setText(R.string.yjx);
        }
    }

    static /* synthetic */ int o(AdVideoViewController adVideoViewController) {
        int i3 = adVideoViewController.f308195t;
        adVideoViewController.f308195t = i3 + 1;
        return i3;
    }

    public void C(BaseVideoView baseVideoView, View view) {
        if (view != null) {
            view.setVisibility(8);
        }
        if (baseVideoView != null) {
            M(baseVideoView);
        }
    }

    public String D(rz2.a aVar) {
        int i3;
        int i16;
        if (aVar == null) {
            return "";
        }
        try {
            int i17 = 1;
            if (aVar.f433001d <= 1) {
                i3 = 11;
            } else {
                i3 = 13;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("bt", aVar.f432998a + "");
            jSONObject.put(FileReaderHelper.ET_EXT, aVar.f432999b + "");
            StringBuilder sb5 = new StringBuilder();
            if (aVar.f432998a > 0) {
                i16 = 0;
            } else {
                i16 = 1;
            }
            sb5.append(i16);
            sb5.append("");
            jSONObject.put("bf", sb5.toString());
            StringBuilder sb6 = new StringBuilder();
            if (!aVar.f433000c) {
                i17 = 0;
            }
            sb6.append(i17);
            sb6.append("");
            jSONObject.put("ef", sb6.toString());
            jSONObject.put("pp", "0");
            jSONObject.put("pa", i3 + "");
            jSONObject.put("ft", aVar.f433003f + "");
            if (aVar.f433002e != 0) {
                jSONObject.put(Constants.KEYS.PLACEMENTS, aVar.f433002e + "");
            }
            return jSONObject.toString();
        } catch (Exception e16) {
            QZLog.e("AdVideoViewController", " @getGdtInfo createGDTVideoAttachment" + e16.toString());
            return null;
        }
    }

    public String G(String str, String str2) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            if (!TextUtils.isEmpty(str)) {
                stringBuffer.append(str);
            }
            if (!TextUtils.isEmpty(str2)) {
                stringBuffer.append("&video=");
                stringBuffer.append(URLEncoder.encode(str2));
            }
            return stringBuffer.toString();
        } catch (Exception e16) {
            QZLog.e("AdVideoViewController", " @getGdtInfo getHttpVideoPlayUrl" + e16.toString());
            return "";
        }
    }

    public void I(AlumBasicData alumBasicData) {
        int i3;
        ImageView.ScaleType scaleType;
        if (this.f308180e == null || this.f308200y || alumBasicData == null) {
            return;
        }
        boolean isUseAdNegativeFeedbackNewIcon = alumBasicData.isUseAdNegativeFeedbackNewIcon();
        this.C = ViewConfiguration.get(this.f308180e.getContext()).getScaledTouchSlop();
        this.D = alumBasicData.disableTouchSlideBack();
        if (isUseAdNegativeFeedbackNewIcon) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f308180e.getLayoutParams();
            marginLayoutParams.topMargin = ViewUtils.dip2px(35.0f);
            marginLayoutParams.bottomMargin = ViewUtils.dip2px(10.0f);
            this.f308180e.setLayoutParams(marginLayoutParams);
        }
        ViewStub viewStub = this.f308180e;
        if (isUseAdNegativeFeedbackNewIcon) {
            i3 = R.layout.hmg;
        } else {
            i3 = R.layout.hmf;
        }
        viewStub.setLayoutResource(i3);
        this.f308181f = this.f308180e.inflate();
        this.f308200y = true;
        QZLog.i("AdVideoViewController", " @getGdtInfo initAdvView");
        this.f308182g = (ViewGroup) this.f308181f.findViewById(R.id.sed);
        this.f308185j = (AdvRoundFrameLayout) this.f308181f.findViewById(R.id.see);
        int dip2px = ViewUtils.dip2px(3.0f);
        this.f308185j.setRaduis(dip2px, dip2px, 0, 0);
        this.f308186k = (ImageView) this.f308181f.findViewById(R.id.seh);
        this.f308179d = (ImageView) this.f308181f.findViewById(R.id.seg);
        this.f308177b = (TextView) this.f308181f.findViewById(R.id.sei);
        this.f308188m = (ImageView) this.f308181f.findViewById(R.id.sec);
        this.f308178c = (TextView) this.f308181f.findViewById(R.id.sej);
        this.f308182g.setOnClickListener(this.L);
        this.f308179d.setOnClickListener(this.L);
        this.f308192q = (TextView) this.f308181f.findViewById(R.id.f68063f1);
        this.f308187l = (BaseVideoView) QQVideoViewFactory.createBaseVideoView(this.f308176a, 0L, null, null);
        AdvRoundFrameLayout advRoundFrameLayout = (AdvRoundFrameLayout) this.f308181f.findViewById(R.id.sef);
        this.f308191p = advRoundFrameLayout;
        advRoundFrameLayout.setRaduis(ViewUtils.dip2px(10.0f));
        this.f308189n = new ImageView(this.f308176a);
        if (alumBasicData.isVerticalVideo()) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        } else {
            scaleType = ImageView.ScaleType.CENTER_CROP;
        }
        this.f308189n.setScaleType(scaleType);
        this.f308185j.setLayoutParams(H());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        ImageView imageView = new ImageView(this.f308176a);
        this.f308190o = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f308185j.addView(this.f308190o, layoutParams);
        BaseVideoView baseVideoView = this.f308187l;
        if (baseVideoView != null) {
            this.f308185j.addView(baseVideoView, layoutParams);
        } else {
            QZLog.i("AdVideoViewController", " @getGdtInfo mVideoView is null");
        }
        this.f308185j.addView(this.f308189n, layoutParams);
        ImageView imageView2 = new ImageView(this.f308176a);
        this.f308193r = imageView2;
        imageView2.setScaleType(ImageView.ScaleType.FIT_END);
        this.f308185j.addView(this.f308193r, com.tencent.mobileqq.vas.adv.qzone.logic.b.f308265a.a());
        this.f308182g.setOnTouchListener(this.K);
        B(alumBasicData);
    }

    public void J(BaseVideoView baseVideoView) {
        if (baseVideoView == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AdVideoViewController", 2, "pauseVideoPlay ");
        }
        baseVideoView.pause();
    }

    public void K(AlumBasicData alumBasicData) {
        if (alumBasicData != null && alumBasicData.preloadMiniApp == 1) {
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).preLoadAfterAdLoaded(this.f308176a, new GdtAd(alumBasicData.adInfo));
        }
    }

    public void L(final BaseVideoView baseVideoView, final AlumBasicData alumBasicData, int i3, Context context) {
        if (baseVideoView != null && alumBasicData != null && alumBasicData.isVideoAdvType()) {
            VideoPlayParam videoPlayParam = new VideoPlayParam();
            videoPlayParam.mSceneId = i3;
            videoPlayParam.mIsMute = true;
            videoPlayParam.mIsLoop = true;
            videoPlayParam.mUrls = new String[]{alumBasicData.videoUrl};
            videoPlayParam.mNeedPlayProgress = true;
            videoPlayParam.mVideoFileTimeMs = alumBasicData.videoShowTime;
            videoPlayParam.mCallback = new d(alumBasicData, baseVideoView);
            baseVideoView.setVideoParam(videoPlayParam);
            VasQzoneYellowThread.INSTANCE.execJob(new Runnable() { // from class: com.tencent.mobileqq.vas.adv.qzone.logic.AdVideoViewController.5
                @Override // java.lang.Runnable
                public void run() {
                    if (AdVideoViewController.this.E(alumBasicData) && AdVideoViewController.this.f308183h != null) {
                        AdVideoViewController.this.f308183h.post(new Runnable() { // from class: com.tencent.mobileqq.vas.adv.qzone.logic.AdVideoViewController.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                                AdVideoViewController.this.V(baseVideoView);
                            }
                        });
                    }
                }
            });
        }
    }

    public void M(BaseVideoView baseVideoView) {
        if (baseVideoView == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AdVideoViewController", 2, "realeseaPlayer ");
        }
        AlumBasicData alumBasicData = this.f308184i;
        if (alumBasicData != null && this.f308196u) {
            this.f308196u = false;
            S(this.f308195t, 0L, this.f308197v, 0, 3, false, alumBasicData.videoReportUrl);
        }
        baseVideoView.releasePlayer(false);
        this.f308187l = null;
    }

    public void O(rz2.a aVar, String str) {
        if (aVar != null && !TextUtils.isEmpty(str)) {
            String D = D(aVar);
            String G = G(str, D);
            if (QLog.isColorLevel()) {
                QLog.d("AdVideoViewController", 2, "reportHttpVideoUrl = " + D);
            }
            R(G);
        }
    }

    public void P(int i3, String str) {
        Q(i3, str, "");
    }

    public void Q(int i3, String str, String str2) {
        AlumBasicData alumBasicData = this.f308184i;
        if (alumBasicData != null && alumBasicData.sourceFrom == 2) {
            int b16 = com.tencent.mobileqq.vas.adv.qzone.logic.b.f308265a.b(i3);
            AlumBasicData alumBasicData2 = this.f308184i;
            ((IVasQZoneApi) QRoute.api(IVasQZoneApi.class)).reportAdvAsyncNew(new VasAdMetaReportParamNew(68, alumBasicData2.aid, "7088010619062240", alumBasicData2.traceId, b16, str2));
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            ((IVasQZoneApi) QRoute.api(IVasQZoneApi.class)).reportAdvAsync(new VasAdMetaReportParam(2, i3, 1, 0, VasAdvSupport.l().i(), null, str));
        } else {
            QZLog.i("AdVideoViewController", " @getGdtInfo sendBusinessReport");
        }
    }

    public void R(final String str) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).postDelayed(new Runnable() { // from class: com.tencent.mobileqq.vas.adv.qzone.logic.AdVideoViewController.6
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                try {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setReadTimeout(10000);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.connect();
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (QZLog.isColorLevel()) {
                        QZLog.i("AdVideoViewController", "@getGdtInfo exporsure rspCode " + responseCode + "\uff0c request thirdparty" + z16 + " url =" + str);
                    }
                } catch (Exception e16) {
                    if (QZLog.isColorLevel()) {
                        QZLog.w("AdVideoViewController", 2, e16.toString());
                    }
                }
            }
        }, 0L);
    }

    public void T(final ImageView imageView, final String str, final AlumBasicData alumBasicData, final Boolean bool) {
        if (imageView != null && !TextUtils.isEmpty(str) && alumBasicData != null) {
            Drawable loadImage = ImageLoader.getInstance().loadImage(str, new ImageLoader.ImageLoadListener() { // from class: com.tencent.mobileqq.vas.adv.qzone.logic.AdVideoViewController.7
                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageLoaded(String str2, final Drawable drawable, ImageLoader.Options options) {
                    if (drawable != null && AdVideoViewController.this.f308183h != null) {
                        AdVideoViewController.this.f308183h.post(new Runnable() { // from class: com.tencent.mobileqq.vas.adv.qzone.logic.AdVideoViewController.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                imageView.setImageDrawable(drawable);
                                if (bool.booleanValue()) {
                                    AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                                    AdVideoViewController.this.P(1, alumBasicData.recCookie);
                                }
                                if (alumBasicData.isVerticalVideo()) {
                                    AnonymousClass7 anonymousClass72 = AnonymousClass7.this;
                                    if (TextUtils.equals(str, alumBasicData.advimageUrl)) {
                                        ThreadManagerV2.excute(QZoneFeedxAdvAdaptUtil.b(AdVideoViewController.this.f308190o, drawable), 16, null, true);
                                    }
                                }
                                QZLog.i("AdVideoViewController", "@getGdtInfo setDataChanged onImageLoaded");
                            }
                        });
                    }
                }

                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageCanceled(String str2, ImageLoader.Options options) {
                }

                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageFailed(String str2, ImageLoader.Options options) {
                }

                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageProgress(String str2, float f16, ImageLoader.Options options) {
                }
            });
            if (bool.booleanValue()) {
                P(1, alumBasicData.recCookie);
            }
            if (loadImage != null) {
                imageView.setImageDrawable(loadImage);
                if (alumBasicData.isVerticalVideo() && TextUtils.equals(str, alumBasicData.advimageUrl)) {
                    ThreadManagerV2.excute(QZoneFeedxAdvAdaptUtil.b(this.f308190o, loadImage), 16, null, true);
                }
            }
        }
    }

    public void V(BaseVideoView baseVideoView) {
        if (baseVideoView == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AdVideoViewController", 2, "startVideoPlay  time =" + System.currentTimeMillis());
        }
        baseVideoView.play();
    }

    @Override // com.tencent.mobileqq.vas.adv.qzone.logic.IAdVideoViewController
    @NonNull
    public View getView() {
        return this.f308180e;
    }

    @Override // com.tencent.mobileqq.vas.adv.qzone.logic.IAdVideoViewController
    public void initStubView(@NotNull ViewGroup viewGroup) {
        this.f308180e = (ViewStub) LayoutInflater.from(this.f308176a).inflate(R.layout.hmc, viewGroup, false);
    }

    @Override // com.tencent.mobileqq.vas.adv.qzone.logic.IAdVideoViewController
    public boolean isAdClosed() {
        return this.f308201z;
    }

    @Override // com.tencent.mobileqq.vas.adv.qzone.logic.IAdVideoViewController
    public void onDestroy() {
        ViewGroup viewGroup = this.f308182g;
        if (viewGroup != null) {
            viewGroup.clearAnimation();
        }
        M(this.f308187l);
    }

    @Override // com.tencent.mobileqq.vas.adv.qzone.logic.IAdVideoViewController
    public void onPause() {
        if (QLog.isColorLevel()) {
            QLog.d("AdVideoViewController", 2, "onPause = ");
        }
        if (this.f308199x) {
            J(this.f308187l);
        }
    }

    @Override // com.tencent.mobileqq.vas.adv.qzone.logic.IAdVideoViewController
    public void onResume() {
        if (QLog.isColorLevel()) {
            QLog.d("AdVideoViewController", 2, "onResume = ");
        }
        if (this.f308199x) {
            V(this.f308187l);
        }
    }

    @Override // com.tencent.mobileqq.vas.adv.qzone.logic.IAdVideoViewController
    public void setAdReportEventListener(WeakReference<com.tencent.mobileqq.vas.adv.qzone.logic.a> weakReference) {
        if (weakReference == null) {
            return;
        }
        this.J = weakReference;
    }

    @Override // com.tencent.mobileqq.vas.adv.qzone.logic.IAdVideoViewController
    public void setOutActivity(Activity activity) {
        if (activity != null) {
            this.I = new WeakReference<>(activity);
        }
    }

    @Override // com.tencent.mobileqq.vas.adv.qzone.logic.IAdVideoViewController
    public void setVideoDataChanged(AlumBasicData alumBasicData, int i3) {
        qq_ad_get.QQAdGetRsp.AdInfo.AppInfo appInfo;
        PBStringField pBStringField;
        if (alumBasicData != null && alumBasicData.isVideoAdvType()) {
            I(alumBasicData);
            K(alumBasicData);
            L(this.f308187l, alumBasicData, i3, this.f308176a);
            T(this.f308186k, alumBasicData.advLogoUrl, alumBasicData, Boolean.FALSE);
            T(this.f308189n, alumBasicData.advimageUrl, alumBasicData, Boolean.TRUE);
            U(this.f308192q, alumBasicData);
            this.f308177b.setText(alumBasicData.advTextTitle);
            this.f308178c.setText(alumBasicData.advTextText);
            if (alumBasicData.isShowLeftSlideTip()) {
                this.f308193r.setImageDrawable(((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("AdVideoViewController", "https://business-ad.cdn-go.cn/cdn-website/latest/public/ad/leftslidehint.png"));
                this.f308193r.setVisibility(0);
            } else {
                this.f308193r.setVisibility(8);
            }
            if (this.A) {
                com.tencent.mobileqq.vas.adv.qzone.logic.b.f308265a.c(this.f308182g);
                this.A = false;
            }
            this.f308182g.setVisibility(0);
            if (QZLog.isColorLevel()) {
                QZLog.i("AdVideoViewController", "setDataChanged titile =" + alumBasicData.advTextTitle + " desc =" + alumBasicData.advTextText + " url =" + alumBasicData.advLogoUrl + "faceimage url =" + alumBasicData.advimageUrl);
            }
            this.f308184i = alumBasicData;
            qq_ad_get.QQAdGetRsp.AdInfo adInfo = alumBasicData.adInfo;
            if (adInfo != null && (appInfo = adInfo.app_info) != null && (pBStringField = appInfo.app_package_name) != null) {
                alumBasicData.originalExposureReport(alumBasicData, com.tencent.mobileqq.cooperation.a.d(pBStringField.get(), this.f308176a));
            }
            N();
            AdExposureChecker adExposureChecker = new AdExposureChecker(null, new WeakReference(this.f308181f));
            AlumBasicData alumBasicData2 = this.f308184i;
            if (alumBasicData2 != null && alumBasicData2.adInfo != null) {
                AdExposureChecker adExposureChecker2 = new AdExposureChecker(new GdtAd(this.f308184i.adInfo), new WeakReference(this.f308181f));
                if (this.H == null) {
                    this.H = new c();
                }
                adExposureChecker2.setCallback(new WeakReference<>(this.H));
                QZLog.i("AdExposureChecker", "startonExposure");
                this.G.add(adExposureChecker2);
                adExposureChecker = adExposureChecker2;
            }
            adExposureChecker.startCheck();
            return;
        }
        C(this.f308187l, this.f308182g);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class d implements VideoPlayerCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AlumBasicData f308217d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ BaseVideoView f308218e;

        d(AlumBasicData alumBasicData, BaseVideoView baseVideoView) {
            this.f308217d = alumBasicData;
            this.f308218e = baseVideoView;
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onLoopBack(long j3, long j16) {
            long j17;
            BaseVideoView baseVideoView = this.f308218e;
            if (baseVideoView != null) {
                j17 = baseVideoView.getCurPlayingPos();
            } else {
                j17 = 0;
            }
            AdVideoViewController.o(AdVideoViewController.this);
            if (AdVideoViewController.this.f308184i != null) {
                AdVideoViewController adVideoViewController = AdVideoViewController.this;
                adVideoViewController.S(adVideoViewController.f308195t, 0L, j17, 0, 3, true, this.f308217d.videoReportUrl);
                AdVideoViewController.this.f308194s = 0L;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AdVideoViewController", 2, "onLoopBack ");
            }
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onPlayError(long j3, int i3, int i16, int i17, String str) {
            long j16;
            BaseVideoView baseVideoView = this.f308218e;
            if (baseVideoView != null) {
                j16 = baseVideoView.getCurPlayingPos();
            } else {
                j16 = 0;
            }
            long j17 = j16;
            if (AdVideoViewController.this.f308184i != null) {
                AdVideoViewController adVideoViewController = AdVideoViewController.this;
                adVideoViewController.S(adVideoViewController.f308195t, AdVideoViewController.this.f308194s, j17, 3, 3, false, this.f308217d.videoReportUrl);
            }
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onPlayProgress(long j3, long j16) {
            AdVideoViewController.this.f308197v = j16;
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onStateChange(long j3, int i3) {
            int i16 = 2;
            if (QLog.isColorLevel()) {
                QLog.d("AdVideoViewController", 2, "onStateChange , state = " + i3 + ", msgUniseq=" + j3 + "time " + System.currentTimeMillis());
            }
            if (i3 != 4) {
                if (i3 == 6) {
                    if (AdVideoViewController.this.f308188m != null) {
                        AdVideoViewController.this.f308188m.setVisibility(0);
                    }
                    if (AdVideoViewController.this.f308198w) {
                        AdVideoViewController.this.f308198w = false;
                    } else {
                        i16 = 3;
                    }
                    int i17 = i16;
                    AdVideoViewController.this.f308196u = false;
                    if (this.f308217d != null) {
                        AdVideoViewController adVideoViewController = AdVideoViewController.this;
                        adVideoViewController.S(adVideoViewController.f308195t, AdVideoViewController.this.f308194s, AdVideoViewController.this.f308197v, 0, i17, false, this.f308217d.videoReportUrl);
                        return;
                    }
                    return;
                }
                return;
            }
            if (AdVideoViewController.this.f308188m != null) {
                AdVideoViewController.this.f308188m.setVisibility(8);
            }
            if (AdVideoViewController.this.f308189n != null) {
                AdVideoViewController.this.f308189n.setVisibility(8);
            }
            if (!AdVideoViewController.this.f308196u) {
                AdVideoViewController adVideoViewController2 = AdVideoViewController.this;
                adVideoViewController2.f308194s = adVideoViewController2.f308197v;
            }
            AdVideoViewController.this.f308196u = true;
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onDownloadComplete(long j3) {
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onFirstFrameRendered(long j3) {
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onDownloadProgress(long j3, long j16) {
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onCapFrame(long j3, boolean z16, int i3, int i16, Bitmap bitmap) {
        }
    }
}
