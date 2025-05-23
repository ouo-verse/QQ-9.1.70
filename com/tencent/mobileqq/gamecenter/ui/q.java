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
import android.widget.TextView;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.gamecenter.api.IGameCenterRedPointConfigApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class q implements v, View.OnClickListener {
    private LinearLayout C;
    private RelativeLayout D;
    private ImageView E;
    private TextView F;
    private TextView G;
    private ImageView H;

    /* renamed from: d, reason: collision with root package name */
    private int f213349d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.gamecenter.data.d f213350e;

    /* renamed from: f, reason: collision with root package name */
    private ViewGroup f213351f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.gamecenter.api.c f213352h;

    /* renamed from: i, reason: collision with root package name */
    private LinearLayout f213353i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f213354m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a extends b {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ImageView f213355e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ImageView imageView) {
            super();
            this.f213355e = imageView;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            QLog.i("SimpleDynamic.GameCenterBannerViewCtrl", 1, "drawable download succeed.");
            this.f213355e.setImageDrawable(uRLDrawable);
            q.this.f();
        }
    }

    public q(int i3, ViewGroup viewGroup, com.tencent.mobileqq.gamecenter.api.c cVar) {
        this.f213349d = i3;
        this.f213351f = viewGroup;
        this.f213352h = cVar;
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
            this.f213351f.addView(this.f213353i, this.f213349d, new LinearLayout.LayoutParams(-1, -2));
            ((IGameCenterRedPointConfigApi) QRoute.api(IGameCenterRedPointConfigApi.class)).addSepcialRedPointShowCnt();
        } catch (Throwable unused) {
            QLog.e("SimpleDynamic.GameCenterBannerViewCtrl", 1, "addBannerDrawable errors!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Drawable drawable = this.E.getDrawable();
        if (drawable instanceof ApngDrawable) {
            e();
        } else if ((drawable instanceof URLDrawable) && ((URLDrawable) drawable).getStatus() == 1) {
            QLog.i("SimpleDynamic.GameCenterBannerViewCtrl", 1, "both are ready. Start to attach.");
            e();
        }
    }

    private void g() {
        try {
            this.f213352h.d();
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg865WithTianJi("", "1", "978", "9067", "906701", "906546", "", this.f213350e.f211994c, "20", "", "");
        } catch (Throwable th5) {
            QLog.e("SimpleDynamic.GameCenterBannerViewCtrl", 1, th5, new Object[0]);
        }
    }

    private int h() {
        int d16 = com.tencent.mobileqq.gamecenter.utils.c.d(35.0f, this.f213351f.getContext().getResources());
        View a16 = this.f213352h.a();
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

    private void i(int i3) {
        try {
            int h16 = h();
            int i16 = h16 - ((int) (i3 * 0.5d));
            QLog.i("SimpleDynamic.GameCenterBannerViewCtrl", 1, "arrowXPos:" + h16 + ",arrowWidth:" + i3 + ",leftMargin:" + i16);
            if (i16 <= 0) {
                return;
            }
            ((LinearLayout.LayoutParams) this.f213354m.getLayoutParams()).leftMargin = i16;
        } catch (Throwable th5) {
            QLog.e("SimpleDynamic.GameCenterBannerViewCtrl", 1, "[setArrowLeftMargin], errors:", th5);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.ui.v
    public void a() {
        LinearLayout linearLayout;
        ViewGroup viewGroup = this.f213351f;
        if (viewGroup != null && (linearLayout = this.f213353i) != null) {
            viewGroup.removeView(linearLayout);
            this.f213353i = null;
            this.f213351f = null;
            this.f213352h = null;
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.ui.v
    public void b(com.tencent.mobileqq.gamecenter.data.d dVar) {
        QLog.i("SimpleDynamic.GameCenterBannerViewCtrl", 1, "[addView]");
        if (dVar == null) {
            QLog.w("SimpleDynamic.GameCenterBannerViewCtrl", 1, "fail to addView, styleInfo is null.");
            return;
        }
        this.f213350e = dVar;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f213351f.getContext()).inflate(R.layout.eaj, (ViewGroup) null);
        this.f213353i = linearLayout;
        this.C = (LinearLayout) linearLayout.findViewById(R.id.ynp);
        this.f213354m = (ImageView) this.f213353i.findViewById(R.id.dtx);
        this.D = (RelativeLayout) this.f213353i.findViewById(R.id.f75793zx);
        this.C.setOnClickListener(this);
        this.F = (TextView) this.f213353i.findViewById(R.id.k6s);
        this.G = (TextView) this.f213353i.findViewById(R.id.f108896ec);
        this.E = (ImageView) this.f213353i.findViewById(R.id.dvu);
        this.H = (ImageView) this.f213353i.findViewById(R.id.dum);
        this.D.setVisibility(0);
        d(dVar.f212001j, this.E, Utils.n(32.0f, this.f213353i.getResources()), Utils.n(32.0f, this.f213353i.getResources()));
        this.G.setText(dVar.f212003l);
        this.F.setText(dVar.f212002k);
        this.D.setOnClickListener(this);
        int n3 = Utils.n(10.0f, this.f213353i.getResources());
        int n16 = Utils.n(6.0f, this.f213353i.getResources());
        if (!TextUtils.isEmpty(dVar.f211999h)) {
            d(dVar.f211999h, this.f213354m, n16, n3);
        } else {
            this.f213354m.setImageResource(R.drawable.joa);
            f();
        }
        i(n16);
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg865WithTianJi("", "1", "978", "9067", "906701", "906545", "", this.f213350e.f211994c, "8", "", "");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.C) {
            a();
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg865WithTianJi("", "1", "978", "9067", "906701", "906547", "", this.f213350e.f211994c, "20", "", "");
        } else if (view == this.D) {
            g();
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
