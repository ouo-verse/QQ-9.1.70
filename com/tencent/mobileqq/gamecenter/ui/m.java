package com.tencent.mobileqq.gamecenter.ui;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class m implements v, View.OnClickListener {
    private ImageView C;
    private LinearLayout D;

    /* renamed from: d, reason: collision with root package name */
    private int f213318d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.gamecenter.data.d f213319e;

    /* renamed from: f, reason: collision with root package name */
    private ViewGroup f213320f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.gamecenter.api.c f213321h;

    /* renamed from: i, reason: collision with root package name */
    private RelativeLayout f213322i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f213323m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a extends b {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ImageView f213324e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ImageView imageView) {
            super();
            this.f213324e = imageView;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            QLog.i("SimpleDynamic.GameCenterBannerViewCtrl", 1, "drawable download succeed.");
            this.f213324e.setImageDrawable(uRLDrawable);
            m.this.f();
        }
    }

    public m(int i3, ViewGroup viewGroup, com.tencent.mobileqq.gamecenter.api.c cVar) {
        this.f213318d = i3;
        this.f213320f = viewGroup;
        this.f213321h = cVar;
    }

    private void d(String str, ImageView imageView, int i3, int i16) {
        URLDrawable uRLDrawable;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = i16;
        if (!TextUtils.isEmpty(str)) {
            ApngOptions apngOptions = new ApngOptions();
            apngOptions.setLoadingDrawable(new ColorDrawable(0));
            apngOptions.setRequestWidth(i3);
            apngOptions.setRequestHeight(i16);
            uRLDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable(m.class.getName(), str, apngOptions);
        } else {
            uRLDrawable = null;
        }
        if (uRLDrawable == null) {
            QLog.w("SimpleDynamic.GameCenterBannerViewCtrl", 1, "drawable is null.");
            return;
        }
        if (uRLDrawable.getStatus() == 1) {
            QLog.i("SimpleDynamic.GameCenterBannerViewCtrl", 1, "drawable exists in local path.");
            imageView.setImageDrawable(uRLDrawable.getCurrDrawable());
            f();
        } else {
            uRLDrawable.setURLDrawableListener(new a(imageView));
            uRLDrawable.startDownload();
            QLog.i("SimpleDynamic.GameCenterBannerViewCtrl", 1, "drawable start to download");
        }
    }

    private void e() {
        try {
            this.f213320f.addView(this.f213322i, this.f213318d, new LinearLayout.LayoutParams(-1, -2));
        } catch (Throwable unused) {
            QLog.e("SimpleDynamic.GameCenterBannerViewCtrl", 1, "addBannerDrawable errors!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Drawable drawable = this.f213323m.getDrawable();
        Drawable drawable2 = this.C.getDrawable();
        if ((drawable instanceof ApngDrawable) && (drawable2 instanceof ApngDrawable)) {
            e();
            return;
        }
        if ((drawable instanceof URLDrawable) && (drawable2 instanceof URLDrawable)) {
            URLDrawable uRLDrawable = (URLDrawable) drawable2;
            if (((URLDrawable) drawable).getStatus() == 1 && uRLDrawable.getStatus() == 1) {
                QLog.i("SimpleDynamic.GameCenterBannerViewCtrl", 1, "both are ready. Start to attach.");
                e();
            }
        }
    }

    private void g() {
        try {
            this.f213321h.d();
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg865WithTianJi("", "1", "978", "9067", "906701", "906546", "", this.f213319e.f211994c, "20", "", "");
        } catch (Throwable th5) {
            QLog.e("SimpleDynamic.GameCenterBannerViewCtrl", 1, th5, new Object[0]);
        }
    }

    private int h() {
        int d16 = com.tencent.mobileqq.gamecenter.utils.c.d(35.0f, this.f213320f.getContext().getResources());
        View a16 = this.f213321h.a();
        if (a16 == null) {
            return d16;
        }
        int width = a16.getWidth();
        int[] iArr = new int[2];
        a16.getLocationInWindow(iArr);
        int i3 = iArr[0] + ((int) (width * 0.5f));
        if (QLog.isColorLevel()) {
            QLog.d("SimpleDynamic.GameCenterBannerViewCtrl", 2, "width:" + width + ",location[0]=" + iArr[0]);
        }
        return i3;
    }

    private String i() {
        return MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentUin();
    }

    private String j() {
        return BaseApplication.getContext().getSharedPreferences("game_center_promotion_banner", 0).getString(i() + "pref_key_last_close_banner_id", "");
    }

    private boolean k(String str) {
        if (TextUtils.isEmpty(str) || !str.equals(j())) {
            return true;
        }
        return false;
    }

    private void l(int i3) {
        try {
            int h16 = h();
            int i16 = h16 - ((int) (i3 * 0.5d));
            QLog.i("SimpleDynamic.GameCenterBannerViewCtrl", 1, "arrowXPos:" + h16 + ",arrowWidth:" + i3 + ",leftMargin:" + i16);
            if (i16 <= 0) {
                return;
            }
            ((RelativeLayout.LayoutParams) this.C.getLayoutParams()).leftMargin = i16;
        } catch (Throwable th5) {
            QLog.e("SimpleDynamic.GameCenterBannerViewCtrl", 1, "[setArrowLeftMargin], errors:", th5);
        }
    }

    private void m(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        BaseApplication.getContext().getSharedPreferences("game_center_promotion_banner", 0).edit().putString(i() + "pref_key_last_close_banner_id", str).commit();
    }

    @Override // com.tencent.mobileqq.gamecenter.ui.v
    public void a() {
        RelativeLayout relativeLayout;
        ViewGroup viewGroup = this.f213320f;
        if (viewGroup != null && (relativeLayout = this.f213322i) != null) {
            viewGroup.removeView(relativeLayout);
            this.f213322i = null;
            this.f213320f = null;
            this.f213321h = null;
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.ui.v
    public void b(com.tencent.mobileqq.gamecenter.data.d dVar) {
        QLog.i("SimpleDynamic.GameCenterBannerViewCtrl", 1, "[addView]");
        if (dVar == null) {
            QLog.w("SimpleDynamic.GameCenterBannerViewCtrl", 1, "fail to addView, styleInfo is null.");
            return;
        }
        if (!k(dVar.f211994c)) {
            QLog.i("SimpleDynamic.GameCenterBannerViewCtrl", 1, "NOT show banner.");
            return;
        }
        this.f213319e = dVar;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f213320f.getContext()).inflate(R.layout.eai, (ViewGroup) null);
        this.f213322i = relativeLayout;
        this.f213323m = (ImageView) relativeLayout.findViewById(R.id.du8);
        this.D = (LinearLayout) this.f213322i.findViewById(R.id.ynp);
        this.C = (ImageView) this.f213322i.findViewById(R.id.dtx);
        this.f213323m.setOnClickListener(this);
        this.D.setOnClickListener(this);
        int i3 = this.f213320f.getContext().getResources().getDisplayMetrics().widthPixels;
        int i16 = (int) ((i3 * 140.0f) / 750.0f);
        d(dVar.f211998g, this.f213323m, i3, i16);
        int i17 = (int) (((i16 * 1.0f) * 20.0f) / 140.0f);
        int i18 = (int) (((i17 * 1.0f) * 36.0f) / 20.0f);
        d(dVar.f211999h, this.C, i18, i17);
        l(i18);
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg865WithTianJi("", "1", "978", "9067", "906701", "906545", "", this.f213319e.f211994c, "8", "", "");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.f213323m) {
            g();
        } else if (view == this.D) {
            a();
            m(this.f213319e.f211994c);
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg865WithTianJi("", "1", "978", "9067", "906701", "906547", "", this.f213319e.f211994c, "20", "", "");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements URLDrawable.URLDrawableListener {
        public b() {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        }
    }
}
