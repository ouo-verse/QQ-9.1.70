package com.tencent.mobileqq.vas.adv.qzone.logic;

import android.app.Activity;
import android.content.Context;
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
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.processor.OvalProcessor;
import com.tencent.component.media.image.view.AsyncImageView;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.gdtad.util.e;
import com.tencent.gdtad.util.j;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;
import com.tencent.mobileqq.vas.adv.qzone.api.IVasQZoneApi;
import com.tencent.mobileqq.vas.adv.qzone.data.VasAdMetaReportParam;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import qz2.VasAdMetaReportParamNew;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes20.dex */
public class AlbumRecommendAdvController implements IAlbumRecommendAdvController {
    private int A;

    /* renamed from: a, reason: collision with root package name */
    private Context f308226a;

    /* renamed from: b, reason: collision with root package name */
    private AdvRoundFrameLayout f308227b;

    /* renamed from: c, reason: collision with root package name */
    private ImageView f308228c;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f308229d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f308230e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f308231f;

    /* renamed from: g, reason: collision with root package name */
    private ImageView f308232g;

    /* renamed from: h, reason: collision with root package name */
    private AsyncImageView f308233h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f308234i;

    /* renamed from: j, reason: collision with root package name */
    private ViewStub f308235j;

    /* renamed from: k, reason: collision with root package name */
    private View f308236k;

    /* renamed from: l, reason: collision with root package name */
    private RelativeLayout f308237l;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f308238m;

    /* renamed from: o, reason: collision with root package name */
    private AlumBasicData f308240o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f308241p;

    /* renamed from: v, reason: collision with root package name */
    private WeakReference<com.tencent.mobileqq.vas.adv.qzone.logic.a> f308247v;

    /* renamed from: w, reason: collision with root package name */
    private float f308248w;

    /* renamed from: x, reason: collision with root package name */
    private float f308249x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f308250y;

    /* renamed from: z, reason: collision with root package name */
    private int f308251z;

    /* renamed from: q, reason: collision with root package name */
    private boolean f308242q = false;

    /* renamed from: r, reason: collision with root package name */
    private boolean f308243r = true;

    /* renamed from: s, reason: collision with root package name */
    public ArrayList<AdExposureChecker> f308244s = new ArrayList<>();

    /* renamed from: t, reason: collision with root package name */
    public AdExposureChecker.ExposureCallback f308245t = null;

    /* renamed from: u, reason: collision with root package name */
    private WeakReference<Activity> f308246u = null;
    View.OnClickListener B = new a();
    private final View.OnTouchListener C = new b();

    /* renamed from: n, reason: collision with root package name */
    private Handler f308239n = new Handler(Looper.getMainLooper());

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements View.OnClickListener {

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.vas.adv.qzone.logic.AlbumRecommendAdvController$a$a, reason: collision with other inner class name */
        /* loaded from: classes20.dex */
        class C8901a implements AdExposureChecker.ExposureCallback {
            C8901a() {
            }

            @Override // com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback
            public void onExposure(WeakReference<View> weakReference) {
                QZLog.i("AdExposureChecker", "onExposure");
                AlbumRecommendAdvController albumRecommendAdvController = AlbumRecommendAdvController.this;
                albumRecommendAdvController.x(albumRecommendAdvController.f308240o.qqbexposureInfor);
                AlbumRecommendAdvController albumRecommendAdvController2 = AlbumRecommendAdvController.this;
                albumRecommendAdvController2.v(4, albumRecommendAdvController2.f308240o.recCookie);
            }
        }

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view != null && view.getId() == R.id.hcl) {
                QZLog.i("AlbumRecommendAdvController", " @getGdtInfo dispear");
                if (!TextUtils.isEmpty(AlbumRecommendAdvController.this.f308240o.negativeFeedbackUrl)) {
                    AlbumRecommendAdvController.this.x(AlbumRecommendAdvController.this.f308240o.negativeFeedbackUrl.replace("__ACT_TYPE__", "2001"));
                }
                if (AlbumRecommendAdvController.this.f308237l != null) {
                    AlbumRecommendAdvController albumRecommendAdvController = AlbumRecommendAdvController.this;
                    albumRecommendAdvController.v(3, albumRecommendAdvController.f308240o.recCookie);
                    AlbumRecommendAdvController.this.hideAdView();
                    AlbumRecommendAdvController.this.f308242q = true;
                }
            } else {
                String a16 = j.f109555a.a(AlbumRecommendAdvController.this.f308240o.traceId, true);
                AlbumRecommendAdvController albumRecommendAdvController2 = AlbumRecommendAdvController.this;
                albumRecommendAdvController2.w(2, albumRecommendAdvController2.f308240o.recCookie, a16);
                AlbumRecommendAdvController albumRecommendAdvController3 = AlbumRecommendAdvController.this;
                if (albumRecommendAdvController3.f308245t == null) {
                    albumRecommendAdvController3.f308245t = new C8901a();
                }
                com.tencent.mobileqq.vas.adv.qzone.logic.b bVar = com.tencent.mobileqq.vas.adv.qzone.logic.b.f308265a;
                WeakReference<Activity> weakReference = AlbumRecommendAdvController.this.f308246u;
                Context context = AlbumRecommendAdvController.this.f308226a;
                AlbumRecommendAdvController albumRecommendAdvController4 = AlbumRecommendAdvController.this;
                bVar.d(weakReference, context, albumRecommendAdvController4.f308245t, albumRecommendAdvController4.f308240o, WebViewConstants.WV.ENABLE_WEBAIO_SWITCH);
                if (AlbumRecommendAdvController.this.f308247v != null && AlbumRecommendAdvController.this.f308247v.get() != null) {
                    ((com.tencent.mobileqq.vas.adv.qzone.logic.a) AlbumRecommendAdvController.this.f308247v.get()).a(String.valueOf(AlbumRecommendAdvController.this.f308240o.aid), AlbumRecommendAdvController.this.q());
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements View.OnTouchListener {
        b() {
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
                            if (AlbumRecommendAdvController.this.f308250y && Math.abs(x17 - AlbumRecommendAdvController.this.f308248w) > AlbumRecommendAdvController.this.f308249x && x17 > AlbumRecommendAdvController.this.f308248w) {
                                view.getParent().requestDisallowInterceptTouchEvent(false);
                            }
                        }
                    } else {
                        e.b(j.f109555a.d(), "" + AlbumRecommendAdvController.this.f308240o.traceId, new j.Location(x16, y16));
                    }
                    view.getParent().requestDisallowInterceptTouchEvent(false);
                } else {
                    AlbumRecommendAdvController.this.f308248w = motionEvent.getX();
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    e.b(j.f109555a.c(), "" + AlbumRecommendAdvController.this.f308240o.traceId, new j.Location(x16, y16));
                }
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class c implements AdExposureChecker.ExposureCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AlumBasicData f308260a;

        c(AlumBasicData alumBasicData) {
            this.f308260a = alumBasicData;
        }

        @Override // com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback
        public void onExposure(WeakReference<View> weakReference) {
            QZLog.i("AdExposureChecker", "onExposure");
            AlbumRecommendAdvController.this.x(this.f308260a.qqbexposureInfor);
            AlbumRecommendAdvController albumRecommendAdvController = AlbumRecommendAdvController.this;
            albumRecommendAdvController.v(4, albumRecommendAdvController.f308240o.recCookie);
        }
    }

    public AlbumRecommendAdvController(Context context, ViewGroup viewGroup) {
        this.f308226a = context;
        this.f308235j = (ViewStub) LayoutInflater.from(context).inflate(R.layout.hmc, viewGroup, false);
    }

    private void o() {
        if (!QZoneFeedxAdvAdaptUtil.e(this.f308240o)) {
            return;
        }
        QZoneFeedxAdvAdaptUtil.a(this.f308237l);
    }

    private void p() {
        AlumBasicData alumBasicData = this.f308240o;
        if (alumBasicData != null && alumBasicData.adInfo != null) {
            IGdtAdAPI iGdtAdAPI = (IGdtAdAPI) QRoute.api(IGdtAdAPI.class);
            iGdtAdAPI.initGdtContext(this.f308226a, new InitGdtContextParams());
            iGdtAdAPI.preLoadAfterAdLoaded(this.f308226a, new GdtAd(this.f308240o.adInfo));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String q() {
        int i3;
        AlumBasicData alumBasicData = this.f308240o;
        if (alumBasicData == null || (i3 = alumBasicData.sourceFrom) == 1 || i3 != 2) {
            return "";
        }
        return "pg_qz_group_album_endpage";
    }

    private RelativeLayout.LayoutParams r() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f308237l.getLayoutParams();
        this.f308251z = (vz2.a.f443771a.b(this.f308226a) - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
        this.A = (int) Math.floor((r1 * 9) / 16.0f);
        return new RelativeLayout.LayoutParams(-1, this.A);
    }

    private void s(boolean z16) {
        int i3;
        if (this.f308235j != null && !this.f308241p) {
            QZLog.i("AlbumRecommendAdvController", " @getGdtInfo initAdvView");
            if (z16) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f308235j.getLayoutParams();
                marginLayoutParams.topMargin = ViewUtils.dip2px(35.0f);
                marginLayoutParams.bottomMargin = ViewUtils.dip2px(10.0f);
                this.f308235j.setLayoutParams(marginLayoutParams);
            }
            ViewStub viewStub = this.f308235j;
            if (z16) {
                i3 = R.layout.hmd;
            } else {
                i3 = R.layout.hme;
            }
            viewStub.setLayoutResource(i3);
            View inflate = this.f308235j.inflate();
            this.f308236k = inflate;
            this.f308241p = true;
            this.f308237l = (RelativeLayout) inflate.findViewById(R.id.hcm);
            this.f308227b = (AdvRoundFrameLayout) inflate.findViewById(R.id.f68083f3);
            int dip2px = ViewUtils.dip2px(3.0f);
            this.f308227b.setRaduis(dip2px, dip2px, 0, 0);
            this.f308228c = (ImageView) inflate.findViewById(R.id.hco);
            this.f308229d = (ImageView) inflate.findViewById(R.id.f68073f2);
            this.f308232g = (ImageView) inflate.findViewById(R.id.hcl);
            this.f308230e = (TextView) inflate.findViewById(R.id.hcp);
            this.f308231f = (TextView) inflate.findViewById(R.id.hcn);
            AsyncImageView asyncImageView = (AsyncImageView) inflate.findViewById(R.id.f68043ez);
            this.f308233h = asyncImageView;
            asyncImageView.setAsyncImageProcessor(new OvalProcessor());
            this.f308233h.setWillNotDraw(false);
            this.f308233h.setAsyncPreferQuality(true);
            this.f308233h.setAsyncDefaultImage(R.drawable.bqc);
            this.f308234i = (TextView) inflate.findViewById(R.id.f68063f1);
            this.f308237l.setOnClickListener(this.B);
            this.f308232g.setOnClickListener(this.B);
            this.f308237l.setOnTouchListener(this.C);
            this.f308227b.setLayoutParams(r());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.f308228c.setLayoutParams(layoutParams);
            this.f308229d.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f308229d.setLayoutParams(layoutParams);
            ImageView imageView = new ImageView(this.f308226a);
            this.f308238m = imageView;
            imageView.setScaleType(ImageView.ScaleType.FIT_END);
            this.f308227b.addView(this.f308238m, com.tencent.mobileqq.vas.adv.qzone.logic.b.f308265a.a());
            o();
        }
    }

    private void u() {
        WeakReference<com.tencent.mobileqq.vas.adv.qzone.logic.a> weakReference;
        AlumBasicData alumBasicData = this.f308240o;
        if (alumBasicData == null) {
            QLog.e("AlbumRecommendAdvController", 1, "reportDtExpo error");
        } else if (!alumBasicData.isDtExpoReport && (weakReference = this.f308247v) != null && weakReference.get() != null) {
            this.f308247v.get().b(String.valueOf(this.f308240o.aid), q());
            this.f308240o.isDtExpoReport = true;
        }
    }

    @Override // com.tencent.mobileqq.vas.adv.qzone.logic.IAlbumRecommendAdvController
    public View getView() {
        return this.f308235j;
    }

    @Override // com.tencent.mobileqq.vas.adv.qzone.logic.IAlbumRecommendAdvController
    public void hideAdView() {
        RelativeLayout relativeLayout = this.f308237l;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
            this.f308237l.clearAnimation();
        }
        QZLog.i("AlbumRecommendAdvController", " hide ad view AlbumRecomAdvInfoView");
    }

    @Override // com.tencent.mobileqq.vas.adv.qzone.logic.IAlbumRecommendAdvController
    public void initAndRenderData(@NonNull final AlumBasicData alumBasicData) {
        qq_ad_get.QQAdGetRsp.AdInfo.AppInfo appInfo;
        PBStringField pBStringField;
        if (TextUtils.isEmpty(alumBasicData.advimageUrl)) {
            hideAdView();
            return;
        }
        this.f308240o = alumBasicData;
        this.f308249x = ViewConfiguration.get(this.f308235j.getContext()).getScaledTouchSlop();
        this.f308250y = alumBasicData.disableTouchSlideBack();
        s(alumBasicData.isUseAdNegativeFeedbackNewIcon());
        t(alumBasicData);
        qq_ad_get.QQAdGetRsp.AdInfo adInfo = alumBasicData.adInfo;
        if (adInfo != null && (appInfo = adInfo.app_info) != null && (pBStringField = appInfo.app_package_name) != null) {
            alumBasicData.originalExposureReport(alumBasicData, com.tencent.mobileqq.cooperation.a.d(pBStringField.get(), this.f308226a));
        }
        u();
        if (alumBasicData.advimageUrl.endsWith("sharp=")) {
            alumBasicData.advimageUrl += "true";
        }
        Drawable loadImage = ImageLoader.getInstance().loadImage(alumBasicData.advimageUrl, new ImageLoader.ImageLoadListener() { // from class: com.tencent.mobileqq.vas.adv.qzone.logic.AlbumRecommendAdvController.3
            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageLoaded(String str, final Drawable drawable, ImageLoader.Options options) {
                if (drawable != null && AlbumRecommendAdvController.this.f308239n != null) {
                    AlbumRecommendAdvController.this.f308239n.post(new Runnable() { // from class: com.tencent.mobileqq.vas.adv.qzone.logic.AlbumRecommendAdvController.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AlbumRecommendAdvController.this.f308228c.setImageDrawable(drawable);
                            if (alumBasicData.isVerticalPic()) {
                                ThreadManagerV2.excute(QZoneFeedxAdvAdaptUtil.b(AlbumRecommendAdvController.this.f308229d, drawable), 16, null, true);
                            }
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            AlbumRecommendAdvController.this.v(1, alumBasicData.recCookie);
                            QZLog.i("AlbumRecommendAdvController", "@getGdtInfo setDataChanged onImageLoaded");
                        }
                    });
                }
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
        });
        if (loadImage != null) {
            this.f308228c.setImageDrawable(loadImage);
            if (alumBasicData.isVerticalPic()) {
                ThreadManagerV2.excute(QZoneFeedxAdvAdaptUtil.b(this.f308229d, loadImage), 16, null, true);
            }
            v(1, alumBasicData.recCookie);
        }
        this.f308230e.setText(alumBasicData.advTextTitle);
        this.f308231f.setText(alumBasicData.advTextText);
        this.f308233h.setAsyncImage(alumBasicData.advLogoUrl);
        if (!TextUtils.isEmpty(alumBasicData.rightBottomButton)) {
            this.f308234i.setText(alumBasicData.rightBottomButton);
        } else {
            qq_ad_get.QQAdGetRsp.AdInfo adInfo2 = alumBasicData.adInfo;
            if (adInfo2 != null && adInfo2.product_type.get() == 12) {
                this.f308234i.setText("\u53bb\u4e0b\u8f7d");
            } else {
                this.f308234i.setText("\u53bb\u770b\u770b");
            }
        }
        if (alumBasicData.isShowLeftSlideTip()) {
            this.f308238m.setImageDrawable(((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("AlbumRecommendAdvController", "https://business-ad.cdn-go.cn/cdn-website/latest/public/ad/leftslidehint.png"));
            this.f308238m.setVisibility(0);
        } else {
            this.f308238m.setVisibility(8);
        }
        if (this.f308243r) {
            com.tencent.mobileqq.vas.adv.qzone.logic.b.f308265a.c(this.f308237l);
            this.f308243r = false;
        }
        this.f308237l.setVisibility(0);
        if (QZLog.isColorLevel()) {
            QZLog.i("AlbumRecommendAdvController", "setDataChanged titile =" + alumBasicData.advTextTitle + " desc =" + alumBasicData.advTextText + " url =" + alumBasicData.advimageUrl);
        }
        AdExposureChecker adExposureChecker = new AdExposureChecker(null, new WeakReference(this.f308236k));
        if (alumBasicData.adInfo != null) {
            AdExposureChecker adExposureChecker2 = new AdExposureChecker(new GdtAd(alumBasicData.adInfo), new WeakReference(this.f308236k));
            if (this.f308245t == null) {
                this.f308245t = new c(alumBasicData);
            }
            adExposureChecker2.setCallback(new WeakReference<>(this.f308245t));
            QZLog.i("AdExposureChecker", "startonExposure");
            this.f308244s.add(adExposureChecker2);
            adExposureChecker = adExposureChecker2;
        }
        adExposureChecker.startCheck();
    }

    @Override // com.tencent.mobileqq.vas.adv.qzone.logic.IAlbumRecommendAdvController
    public boolean isAdClosed() {
        return this.f308242q;
    }

    @Override // com.tencent.mobileqq.vas.adv.qzone.logic.IAlbumRecommendAdvController
    public void onDestroy() {
        RelativeLayout relativeLayout = this.f308237l;
        if (relativeLayout != null) {
            relativeLayout.clearAnimation();
        }
        ArrayList<AdExposureChecker> arrayList = this.f308244s;
        if (arrayList != null) {
            Iterator<AdExposureChecker> it = arrayList.iterator();
            while (it.hasNext()) {
                AdExposureChecker next = it.next();
                next.onActivityDestroy();
                next.setCallback(null);
            }
            this.f308244s.clear();
            this.f308245t = null;
        }
    }

    @Override // com.tencent.mobileqq.vas.adv.qzone.logic.IAlbumRecommendAdvController
    public void onPause() {
        ArrayList<AdExposureChecker> arrayList = this.f308244s;
        if (arrayList != null) {
            Iterator<AdExposureChecker> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onActivityPause();
            }
        }
    }

    @Override // com.tencent.mobileqq.vas.adv.qzone.logic.IAlbumRecommendAdvController
    public void onResume() {
        ArrayList<AdExposureChecker> arrayList = this.f308244s;
        if (arrayList != null) {
            Iterator<AdExposureChecker> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onActivityResume();
            }
        }
    }

    @Override // com.tencent.mobileqq.vas.adv.qzone.logic.IAlbumRecommendAdvController
    public void setAdReportEventListener(WeakReference<com.tencent.mobileqq.vas.adv.qzone.logic.a> weakReference) {
        if (weakReference == null) {
            return;
        }
        this.f308247v = weakReference;
    }

    @Override // com.tencent.mobileqq.vas.adv.qzone.logic.IAlbumRecommendAdvController
    public void setOutActivity(Activity activity) {
        this.f308246u = new WeakReference<>(activity);
    }

    public void t(AlumBasicData alumBasicData) {
        qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        PBUInt32Field pBUInt32Field;
        if (alumBasicData != null && (adInfo = alumBasicData.adInfo) != null) {
            qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo displayInfo = adInfo.display_info;
            if (displayInfo != null && (pBUInt32Field = displayInfo.mini_program_type) != null && pBUInt32Field.get() == 11) {
                if (alumBasicData.preloadMiniApp == 1) {
                    p();
                    return;
                }
                return;
            }
            p();
        }
    }

    public void v(int i3, String str) {
        w(i3, str, "");
    }

    public void w(int i3, String str, String str2) {
        AlumBasicData alumBasicData = this.f308240o;
        if (alumBasicData != null && alumBasicData.sourceFrom == 2) {
            int b16 = com.tencent.mobileqq.vas.adv.qzone.logic.b.f308265a.b(i3);
            AlumBasicData alumBasicData2 = this.f308240o;
            ((IVasQZoneApi) QRoute.api(IVasQZoneApi.class)).reportAdvAsyncNew(new VasAdMetaReportParamNew(68, alumBasicData2.aid, "7088010619062240", alumBasicData2.traceId, b16, str2));
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            ((IVasQZoneApi) QRoute.api(IVasQZoneApi.class)).reportAdvAsync(new VasAdMetaReportParam(2, i3, 1, 0, VasAdvSupport.l().i(), null, str));
        } else {
            QZLog.i("AlbumRecommendAdvController", " @getGdtInfo clickAlumAdvPicViewInfo");
        }
    }

    public void x(final String str) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).postDelayed(new Runnable() { // from class: com.tencent.mobileqq.vas.adv.qzone.logic.AlbumRecommendAdvController.5
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
                        QZLog.i("AlbumRecommendAdvController", "@getGdtInfo exporsure rspCode " + responseCode + "\uff0c request thirdparty" + z16 + " url =" + str);
                    }
                } catch (Exception e16) {
                    if (QZLog.isColorLevel()) {
                        QZLog.w("AlbumRecommendAdvController", 2, e16.toString());
                    }
                }
            }
        }, 0L);
    }
}
