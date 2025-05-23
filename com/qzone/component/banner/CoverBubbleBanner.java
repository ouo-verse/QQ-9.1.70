package com.qzone.component.banner;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.common.account.LoginData;
import com.qzone.util.ar;
import com.qzone.widget.AsyncImageView;
import com.qzone.widget.AsyncImageable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IQbossReportManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable;
import cooperation.qzone.util.QZLog;
import java.util.Map;
import org.json.JSONObject;
import yo.f;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CoverBubbleBanner extends Banner {
    private RelativeLayout C;
    private AsyncImageView D;
    private TextView E;
    private TextView F;
    private Animation G;
    private Context H;
    private String I;
    private boolean J;
    private Drawable K;
    private boolean L;
    private int M;
    private AsyncImageable.AsyncImageListener N;
    private Handler P;

    /* renamed from: h, reason: collision with root package name */
    private com.qzone.feed.business.model.a f46320h;

    /* renamed from: i, reason: collision with root package name */
    private RelativeLayout f46321i;

    /* renamed from: m, reason: collision with root package name */
    private AsyncImageView f46322m;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f46323d;

        a(String str) {
            this.f46323d = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            CoverBubbleBanner.this.g();
            CoverBubbleBanner.this.J = true;
            yo.d.e(CoverBubbleBanner.I(CoverBubbleBanner.H(this.f46323d)), CoverBubbleBanner.this.H, null, null);
            ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportClick(CoverBubbleBanner.this.I, LoginData.getInstance().getUinString());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c extends Handler {
        c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                CoverBubbleBanner.this.M--;
                CoverBubbleBanner.this.J();
            }
            super.handleMessage(message);
        }
    }

    public CoverBubbleBanner(Context context) {
        super(context);
        this.J = false;
        this.L = false;
        this.M = -1;
        this.N = new b();
        this.P = new c(Looper.getMainLooper());
        this.H = context;
        this.G = AnimationUtils.loadAnimation(context, R.anim.f155015gn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String H(String str) {
        int indexOf;
        int indexOf2 = str.indexOf("#!");
        return (indexOf2 == -1 || (indexOf = str.indexOf("&sid=", indexOf2)) == -1) ? str : str.substring(0, indexOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String I(String str) {
        return f.j(str, "{refer}", "bubble");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        String str;
        String str2;
        this.P.removeMessages(1);
        int i3 = this.M;
        if (i3 < 0) {
            g();
            return;
        }
        int i16 = i3 / 60;
        if (i16 > 9) {
            str = String.valueOf(i16);
        } else {
            str = "0" + i16;
        }
        int i17 = this.M % 60;
        if (i17 > 9) {
            str2 = String.valueOf(i17);
        } else {
            str2 = "0" + i17;
        }
        this.E.setText(str);
        this.F.setText(str2);
        this.P.sendEmptyMessageDelayed(1, 1000L);
    }

    @Override // com.qzone.component.banner.Banner
    public int d() {
        return 0;
    }

    @Override // com.qzone.component.banner.Banner
    public int e() {
        return 7;
    }

    @Override // com.qzone.component.banner.Banner
    public void i(boolean z16) {
        RelativeLayout relativeLayout;
        if (!this.f46297e || (relativeLayout = this.f46321i) == null) {
            return;
        }
        if (z16) {
            relativeLayout.setVisibility(0);
        } else {
            relativeLayout.setVisibility(8);
        }
    }

    @Override // com.qzone.component.banner.Banner
    public boolean l() {
        return this.f46321i.isShown();
    }

    @Override // com.qzone.component.banner.Banner
    public void t(com.qzone.feed.business.model.a aVar) {
        if (this.f46321i == null || aVar == null || aVar.f47123g == null) {
            return;
        }
        this.J = false;
        boolean z16 = !G(this.f46320h, aVar);
        this.f46320h = aVar;
        BusinessADBannerData businessADBannerData = aVar.f47123g;
        String str = businessADBannerData.strPicUrl;
        String str2 = businessADBannerData.strJmpUrl;
        this.I = businessADBannerData.strTraceInfo;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f46321i.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.width = ar.e(110.0f);
        layoutParams.height = ar.e(60.0f);
        layoutParams.bottomMargin = ar.e(-16.0f);
        char c16 = 2;
        layoutParams.addRule(2, R.id.f166698hf1);
        this.f46321i.setLayoutParams(layoutParams);
        if (z16 && aVar.f47123g.dynBannerJsonData != null) {
            try {
                this.M = new JSONObject(aVar.f47123g.dynBannerJsonData).optInt("show_times");
            } catch (Exception e16) {
                QZLog.e("CoverBubbleBanner", "CoverBubbleBanner setting time error " + e16);
            }
        }
        this.L = this.M > 0;
        Map<String, String> map = this.f46320h.f47123g.extendinfo;
        if (map != null && !TextUtils.isEmpty(map.get("res_zip_url"))) {
            String str3 = this.f46320h.f47123g.extendinfo.get("res_zip_url");
            if (this.K == null) {
                Drawable zipAnimationDrawable = ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).getZipAnimationDrawable();
                this.K = zipAnimationDrawable;
                zipAnimationDrawable.setCallback(this.f46322m);
            }
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setAnimationRes(this.K, str3, -1);
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setShowLastFrameWhenStop(this.K, true);
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setScale(this.K, 1.0f);
            this.f46322m.setImageDrawable(this.K);
            this.f46321i.requestLayout();
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).start(this.K);
            ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportExpose(this.I, LoginData.getInstance().getUinString());
            this.f46321i.setVisibility(0);
        } else {
            this.f46322m.setAsyncImageListener(this.N);
            this.f46322m.setAsyncImage(str);
            c16 = 1;
        }
        if (this.M > 0) {
            if (c16 == 1) {
                this.f46322m.setScaleType(ImageView.ScaleType.FIT_START);
                this.f46322m.setAnimation(null);
            }
            this.C.setVisibility(0);
            this.D.setImageResource(R.drawable.fys);
            J();
        }
        this.f46321i.setOnClickListener(new a(str2));
    }

    @Override // com.qzone.component.banner.Banner
    public void g() {
        i(false);
        this.f46320h = null;
    }

    private boolean G(com.qzone.feed.business.model.a aVar, com.qzone.feed.business.model.a aVar2) {
        BusinessADBannerData businessADBannerData;
        Map<String, String> map;
        if (aVar != null && (businessADBannerData = aVar.f47123g) != null && aVar2 != null && aVar2.f47123g != null) {
            Map<String, String> map2 = businessADBannerData.extendinfo;
            if (map2 != null && !TextUtils.isEmpty(map2.get("res_zip_url")) && (map = aVar2.f47123g.extendinfo) != null && !TextUtils.isEmpty(map.get("res_zip_url"))) {
                if (aVar.f47123g.extendinfo.get("res_zip_url").equals(aVar2.f47123g.extendinfo.get("res_zip_url"))) {
                    return true;
                }
            } else if (!TextUtils.isEmpty(aVar.f47123g.strPicUrl) && aVar.f47123g.strPicUrl.equals(aVar2.f47123g.strPicUrl)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.qzone.component.banner.Banner
    public void h(ViewStub viewStub) {
        if (viewStub == null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) viewStub.inflate();
        this.f46321i = relativeLayout;
        this.f46322m = (AsyncImageView) relativeLayout.findViewById(R.id.f166699hf2);
        this.C = (RelativeLayout) this.f46321i.findViewById(R.id.hf6);
        this.D = (AsyncImageView) this.f46321i.findViewById(R.id.hf7);
        this.E = (TextView) this.f46321i.findViewById(R.id.f166700hf3);
        this.F = (TextView) this.f46321i.findViewById(R.id.f166701hf4);
        if (this.f46322m == null) {
            return;
        }
        this.f46321i.setVisibility(8);
        this.J = false;
        this.f46297e = true;
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements AsyncImageable.AsyncImageListener {
        b() {
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageLoaded(AsyncImageable asyncImageable) {
            ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportExpose(CoverBubbleBanner.this.I, LoginData.getInstance().getUinString());
            if (CoverBubbleBanner.this.f46321i == null || CoverBubbleBanner.this.f46322m == null) {
                return;
            }
            CoverBubbleBanner.this.f46321i.setVisibility(0);
            if (CoverBubbleBanner.this.L) {
                return;
            }
            CoverBubbleBanner.this.f46322m.startAnimation(CoverBubbleBanner.this.G);
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
    }
}
