package com.qzone.component.banner;

import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.common.account.LoginData;
import com.qzone.component.banner.SwipeOperationAdsBanner;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.qzone.util.ar;
import com.qzone.widget.AsynAutoGifImageView;
import com.qzone.widget.AsyncImageView;
import com.qzone.widget.AsyncImageable;
import com.qzone.widget.cardview.CardView;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.drawable.AutoGifDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qzonehub.api.report.IQzoneExceptionReport;
import common.config.service.QzoneConfig;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.exception.QZoneNewStyleBannerCrashException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class SwipeOpeationBannerChild implements SwipeOperationAdsBanner.b {
    public static String S = "NewStyleOperationAdsBanner";
    private boolean A;
    private i B;
    private AsyncImageable.AsyncImageListener C;
    private View.OnClickListener O;
    private com.qzone.component.banner.b P;

    /* renamed from: a, reason: collision with root package name */
    private CardView f46491a;

    /* renamed from: b, reason: collision with root package name */
    private RelativeLayout f46492b;

    /* renamed from: c, reason: collision with root package name */
    private ImageView f46493c;

    /* renamed from: d, reason: collision with root package name */
    private AsyncImageView f46494d;

    /* renamed from: e, reason: collision with root package name */
    private AsynAutoGifImageView f46495e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f46496f;

    /* renamed from: g, reason: collision with root package name */
    private TextView f46497g;

    /* renamed from: h, reason: collision with root package name */
    private TextView f46498h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f46499i;

    /* renamed from: j, reason: collision with root package name */
    private ImageView f46500j;

    /* renamed from: k, reason: collision with root package name */
    private AsyncImageView f46501k;

    /* renamed from: l, reason: collision with root package name */
    private AsyncImageView f46502l;

    /* renamed from: m, reason: collision with root package name */
    private AsynAutoGifImageView f46503m;

    /* renamed from: n, reason: collision with root package name */
    private LinearLayout f46504n;

    /* renamed from: o, reason: collision with root package name */
    private TextView f46505o;

    /* renamed from: p, reason: collision with root package name */
    private TextView f46506p;

    /* renamed from: q, reason: collision with root package name */
    private TextView f46507q;

    /* renamed from: r, reason: collision with root package name */
    private long f46508r;

    /* renamed from: s, reason: collision with root package name */
    private long f46509s;

    /* renamed from: t, reason: collision with root package name */
    private long f46510t;

    /* renamed from: u, reason: collision with root package name */
    private long f46511u;

    /* renamed from: v, reason: collision with root package name */
    private long f46512v;

    /* renamed from: w, reason: collision with root package name */
    private long f46513w;

    /* renamed from: x, reason: collision with root package name */
    private String f46514x;

    /* renamed from: y, reason: collision with root package name */
    private String f46515y;

    /* renamed from: z, reason: collision with root package name */
    private String f46516z;
    private final int D = 0;
    private final int E = 1;
    private final int F = 2;
    private final int G = 0;
    private final int H = 1;
    private final int I = 2;
    private final int J = 3;
    private final int K = 0;
    private final int L = 1;
    private final int M = 2;
    boolean N = false;
    private Handler Q = new h(Looper.getMainLooper());
    private Runnable R = new Runnable() { // from class: com.qzone.component.banner.SwipeOpeationBannerChild.10
        @Override // java.lang.Runnable
        public void run() {
            Handler o16 = SwipeOpeationBannerChild.this.o();
            if (o16 != null) {
                o16.sendEmptyMessage(0);
                if (SwipeOpeationBannerChild.this.A) {
                    QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).postDelayed(this, 1000L);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            ViewOutlineProvider.BACKGROUND.getOutline(view, outline);
            outline.setAlpha(0.5f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Integer num = (Integer) SwipeOpeationBannerChild.this.f46491a.getTag(R.id.f166939j94);
            if (num != null && SwipeOpeationBannerChild.this.P != null) {
                SwipeOpeationBannerChild.this.P.b(num.intValue());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Integer num = (Integer) SwipeOpeationBannerChild.this.f46491a.getTag(R.id.f166939j94);
            if (num != null && SwipeOpeationBannerChild.this.P != null) {
                SwipeOpeationBannerChild.this.P.a(num.intValue());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class d implements AsynAutoGifImageView.a {
        d() {
        }

        @Override // com.qzone.widget.AsynAutoGifImageView.a
        public boolean isListViewScrollIdle() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class f implements AsynAutoGifImageView.a {
        f() {
        }

        @Override // com.qzone.widget.AsynAutoGifImageView.a
        public boolean isListViewScrollIdle() {
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        public String f46528a;

        /* renamed from: b, reason: collision with root package name */
        public String f46529b;

        /* renamed from: c, reason: collision with root package name */
        public String f46530c;

        /* renamed from: d, reason: collision with root package name */
        public String f46531d;

        /* renamed from: e, reason: collision with root package name */
        public String f46532e;

        /* renamed from: f, reason: collision with root package name */
        public String f46533f;

        /* renamed from: g, reason: collision with root package name */
        public String f46534g;

        /* renamed from: h, reason: collision with root package name */
        public String f46535h;

        /* renamed from: i, reason: collision with root package name */
        public String f46536i;

        /* renamed from: j, reason: collision with root package name */
        public String f46537j;

        /* renamed from: k, reason: collision with root package name */
        public String f46538k;

        /* renamed from: l, reason: collision with root package name */
        public String f46539l;

        /* renamed from: m, reason: collision with root package name */
        public String f46540m;

        /* renamed from: n, reason: collision with root package name */
        public String f46541n;

        /* renamed from: o, reason: collision with root package name */
        public String f46542o;

        public static ArrayList<i> a(String str) throws JSONException {
            JSONArray jSONArray = new JSONArray(str);
            ArrayList<i> arrayList = new ArrayList<>();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                i iVar = new i();
                arrayList.add(iVar);
                iVar.f46529b = jSONObject.optString("picture");
                iVar.f46528a = jSONObject.optString("pic_type");
                iVar.f46530c = jSONObject.optString("title");
                iVar.f46531d = jSONObject.optString("sub_title_type");
                iVar.f46532e = jSONObject.optString("nick_pattern");
                iVar.f46533f = jSONObject.optString("end_time");
                iVar.f46534g = jSONObject.optString("content_text");
                iVar.f46535h = jSONObject.optString("corner_mark");
                iVar.f46536i = jSONObject.optString(QZoneAdTianshuFeedData.KEY_BUTTON_TEXT);
                iVar.f46537j = jSONObject.optString("adv_mark");
                iVar.f46538k = jSONObject.optString("bgm_pic_cover_left");
                iVar.f46539l = jSONObject.optString("bgm_pic_cover_right");
                iVar.f46540m = jSONObject.optString("floating_gif");
                iVar.f46541n = jSONObject.optString("scheme_url");
                iVar.f46542o = jSONObject.optString("url");
            }
            return arrayList;
        }
    }

    SwipeOpeationBannerChild() {
    }

    public static SwipeOpeationBannerChild m() {
        return new SwipeOpeationBannerChild();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f46509s = currentTimeMillis;
        long j3 = this.f46508r - (currentTimeMillis / 1000);
        this.f46510t = j3;
        long j16 = ((j3 % 86400) / 3600) + ((j3 / 86400) * 24);
        this.f46511u = j16;
        this.f46512v = (j3 % 3600) / 60;
        this.f46513w = j3 % 60;
        if (j3 < 0) {
            this.A = false;
            this.f46504n.setVisibility(8);
            this.f46498h.setVisibility(0);
            this.f46498h.setText(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewOnGoing", "\u6b63\u5728\u8fdb\u884c\u4e2d"));
            return;
        }
        if (j16 > 99) {
            this.f46511u = 99L;
            this.f46512v = 59L;
            this.f46513w = 59L;
        }
        long j17 = this.f46511u;
        if (j17 < 10) {
            this.f46514x = "0" + String.valueOf(this.f46511u);
        } else {
            this.f46514x = String.valueOf(j17);
        }
        long j18 = this.f46512v;
        if (j18 < 10) {
            this.f46515y = "0" + String.valueOf(this.f46512v);
        } else {
            this.f46515y = String.valueOf(j18);
        }
        long j19 = this.f46513w;
        if (j19 < 10) {
            this.f46516z = "0" + String.valueOf(this.f46513w);
        } else {
            this.f46516z = String.valueOf(j19);
        }
        this.f46505o.setText(this.f46514x);
        this.f46506p.setText(this.f46515y);
        this.f46507q.setText(this.f46516z);
    }

    public Handler o() {
        return this.Q;
    }

    public void q(com.qzone.component.banner.b bVar) {
        this.P = bVar;
    }

    public void s(i iVar) {
        this.B = iVar;
        this.N = false;
        if (!TextUtils.isEmpty(iVar.f46529b)) {
            if (Integer.valueOf(this.B.f46528a).intValue() == 1) {
                this.f46495e.setVisibility(0);
                this.f46495e.setLayerType(1, null);
                this.f46495e.setAdjustViewBounds(false);
                String str = this.f46495e.f60157f;
                if (str == null || !str.equals(this.B.f46529b)) {
                    ImageLoader.getInstance().clear(this.B.f46529b);
                    this.f46495e.setAsynGifImage(this.B.f46529b, new d(), new e());
                }
            } else {
                this.f46494d.setAsyncImageListener(this.C);
                this.f46494d.setAsyncImage(this.B.f46529b);
            }
        }
        if (!TextUtils.isEmpty(this.B.f46530c)) {
            this.f46497g.setText(this.B.f46530c);
        }
        this.f46498h.setVisibility(8);
        this.f46504n.setVisibility(8);
        if (!TextUtils.isEmpty(this.B.f46531d)) {
            int intValue = Integer.valueOf(this.B.f46531d).intValue();
            if (intValue == 0) {
                this.A = false;
                this.f46498h.setVisibility(0);
                this.f46498h.setText(this.B.f46534g);
            } else if (intValue == 1) {
                this.A = true;
                try {
                    this.f46508r = Long.parseLong(this.B.f46533f);
                } catch (NumberFormatException e16) {
                    e16.printStackTrace();
                    this.f46508r = 0L;
                }
                long currentTimeMillis = System.currentTimeMillis();
                this.f46509s = currentTimeMillis;
                long j3 = this.f46508r - (currentTimeMillis / 1000);
                this.f46510t = j3;
                if (j3 >= 0) {
                    this.f46504n.setVisibility(0);
                    l();
                } else {
                    this.A = false;
                    this.f46504n.setVisibility(8);
                    this.f46498h.setVisibility(0);
                    this.f46498h.setText(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewOnGoing", "\u6b63\u5728\u8fdb\u884c\u4e2d"));
                }
            } else {
                if (intValue != 2) {
                    this.A = false;
                    return;
                }
                this.A = false;
                this.f46498h.setVisibility(0);
                try {
                    String n3 = n(LoginData.getInstance().getNickName(""), 6);
                    i iVar2 = this.B;
                    iVar2.f46532e = iVar2.f46532e.replace("{nickname}", n3);
                    this.f46498h.setText(this.B.f46532e);
                } catch (Exception e17) {
                    e17.printStackTrace();
                    this.f46498h.setVisibility(4);
                    ((IQzoneExceptionReport) QRoute.api(IQzoneExceptionReport.class)).doReport(new QZoneNewStyleBannerCrashException(e17), "\u5e7f\u544abanner\u5b57\u7b26\u4e32\u5904\u7406\u5931\u8d25");
                }
            }
        }
        if (!TextUtils.isEmpty(this.B.f46535h)) {
            int intValue2 = Integer.valueOf(this.B.f46535h).intValue();
            if (intValue2 == 0) {
                this.f46499i.setVisibility(8);
            } else if (intValue2 == 1) {
                this.f46499i.setVisibility(0);
                this.f46499i.setImageResource(R.drawable.gae);
            } else if (intValue2 != 2) {
                this.f46499i.setVisibility(8);
            } else {
                this.f46499i.setVisibility(0);
                this.f46499i.setImageResource(R.drawable.gag);
            }
        }
        if (!TextUtils.isEmpty(this.B.f46536i)) {
            this.f46496f.setVisibility(0);
            this.f46496f.setText(this.B.f46536i);
        }
        if (!TextUtils.isEmpty(this.B.f46537j)) {
            int intValue3 = Integer.valueOf(this.B.f46537j).intValue();
            if (intValue3 == 0) {
                this.f46500j.setVisibility(0);
                this.f46500j.setImageResource(R.drawable.gaa);
            } else if (intValue3 == 1) {
                this.f46500j.setVisibility(0);
                this.f46500j.setImageResource(R.drawable.ga_);
            } else if (intValue3 == 2) {
                this.f46500j.setVisibility(8);
            }
        }
        if (!TextUtils.isEmpty(this.B.f46538k)) {
            this.f46501k.setAsyncImage(this.B.f46538k);
        }
        if (!TextUtils.isEmpty(this.B.f46539l)) {
            this.f46502l.setAsyncImage(this.B.f46539l);
        }
        if (TextUtils.isEmpty(this.B.f46540m)) {
            return;
        }
        this.f46503m.setVisibility(0);
        this.f46503m.setLayerType(1, null);
        this.f46503m.setAdjustViewBounds(false);
        ImageLoader.getInstance().clear(this.B.f46540m);
        this.f46503m.setAsynGifImage(this.B.f46540m, new f(), new g());
    }

    private void l() {
        this.A = true;
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(this.R);
    }

    @Override // com.qzone.component.banner.SwipeOperationAdsBanner.b
    public void a() {
        this.N = false;
        AsynAutoGifImageView asynAutoGifImageView = this.f46495e;
        if (asynAutoGifImageView != null) {
            asynAutoGifImageView.i();
        }
        AsynAutoGifImageView asynAutoGifImageView2 = this.f46503m;
        if (asynAutoGifImageView2 != null) {
            asynAutoGifImageView2.i();
        }
    }

    @Override // com.qzone.component.banner.SwipeOperationAdsBanner.b
    public void b() {
        this.N = true;
        AsynAutoGifImageView asynAutoGifImageView = this.f46495e;
        if (asynAutoGifImageView != null && asynAutoGifImageView.getVisibility() == 0) {
            this.f46495e.h();
        }
        AsynAutoGifImageView asynAutoGifImageView2 = this.f46503m;
        if (asynAutoGifImageView2 == null || asynAutoGifImageView2.getVisibility() != 0) {
            return;
        }
        this.f46503m.h();
    }

    public void p(View view) {
        ImageView imageView;
        CardView cardView = (CardView) view;
        this.f46491a = cardView;
        cardView.setOutlineProvider(new a());
        this.f46491a.setCardElevation(ar.d(5.0f));
        view.setTag(R.id.f166935j90, this);
        this.f46492b = (RelativeLayout) this.f46491a.findViewById(R.id.fe9);
        this.f46494d = (AsyncImageView) this.f46491a.findViewById(R.id.feo);
        this.f46495e = (AsynAutoGifImageView) this.f46491a.findViewById(R.id.fem);
        this.f46493c = (ImageView) this.f46492b.findViewById(R.id.fec);
        this.f46496f = (TextView) this.f46492b.findViewById(R.id.fej);
        this.f46501k = (AsyncImageView) this.f46492b.findViewById(R.id.fe_);
        this.f46502l = (AsyncImageView) this.f46492b.findViewById(R.id.fea);
        this.f46497g = (TextView) this.f46492b.findViewById(R.id.fes);
        this.f46498h = (TextView) this.f46492b.findViewById(R.id.fer);
        this.f46499i = (ImageView) this.f46491a.findViewById(R.id.fee);
        this.f46500j = (ImageView) this.f46491a.findViewById(R.id.fe8);
        LinearLayout linearLayout = (LinearLayout) this.f46492b.findViewById(R.id.feg);
        this.f46504n = linearLayout;
        this.f46505o = (TextView) linearLayout.findViewById(R.id.fef);
        this.f46506p = (TextView) this.f46504n.findViewById(R.id.feh);
        this.f46507q = (TextView) this.f46504n.findViewById(R.id.fei);
        this.f46503m = (AsynAutoGifImageView) this.f46491a.findViewById(R.id.fel);
        this.f46491a.setOnClickListener(new b());
        c cVar = new c();
        this.O = cVar;
        if (this.f46494d == null || (imageView = this.f46493c) == null) {
            return;
        }
        imageView.setOnClickListener(cVar);
        this.C = new AsyncImageable.AsyncImageListener() { // from class: com.qzone.component.banner.SwipeOpeationBannerChild.4
            @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
            public void onImageLoaded(AsyncImageable asyncImageable) {
                final Drawable drawable;
                if (SwipeOpeationBannerChild.this.B == null || (drawable = ((AsyncImageView) asyncImageable).getDrawable()) == null || SwipeOpeationBannerChild.this.Q == null) {
                    return;
                }
                SwipeOpeationBannerChild.this.Q.post(new Runnable() { // from class: com.qzone.component.banner.SwipeOpeationBannerChild.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SwipeOpeationBannerChild.this.f46495e.setVisibility(8);
                        SwipeOpeationBannerChild.this.f46494d.setVisibility(0);
                        SwipeOpeationBannerChild.this.f46494d.setImageDrawable(drawable);
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

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class h extends Handler {
        h(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null) {
                return;
            }
            if (message.what == 0) {
                SwipeOpeationBannerChild.this.r();
                return;
            }
            if (QZLog.isColorLevel()) {
                QZLog.d(SwipeOpeationBannerChild.S, 2, "--NewStyleOperationAdsBanner --handleMessage default what = " + message.what);
            }
        }
    }

    private String n(String str, int i3) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class e implements AutoGifDrawable.GifDownloadCallBackListener {
        e() {
        }

        @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            SwipeOpeationBannerChild swipeOpeationBannerChild = SwipeOpeationBannerChild.this;
            if (!swipeOpeationBannerChild.N) {
                swipeOpeationBannerChild.f46495e.i();
            } else {
                swipeOpeationBannerChild.f46495e.h();
            }
        }

        @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
        public void onImageFailed(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class g implements AutoGifDrawable.GifDownloadCallBackListener {
        g() {
        }

        @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            SwipeOpeationBannerChild swipeOpeationBannerChild = SwipeOpeationBannerChild.this;
            if (swipeOpeationBannerChild.N) {
                swipeOpeationBannerChild.f46503m.h();
            } else {
                swipeOpeationBannerChild.f46503m.i();
            }
        }

        @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
        public void onImageFailed(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }
}
