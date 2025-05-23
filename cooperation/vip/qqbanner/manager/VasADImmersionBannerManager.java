package cooperation.vip.qqbanner.manager;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.widgets.QFSPagAnimView;
import com.tencent.biz.qqcircle.widgets.bc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.bannerprocessor.VasADBannerProcessor;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.startup.step.SetSplash;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.zipanimate.ZipFirstFrameLoadedListener;
import cooperation.vip.qqbanner.widget.NakedEyesView;
import i15.c;
import j15.a;
import j15.d;

/* compiled from: P */
/* loaded from: classes28.dex */
public class VasADImmersionBannerManager extends VasADBannerManager {
    private TextView H;
    private TextView I;
    private TextView J;
    private TextView K;
    private ImageView L;
    private NakedEyesView M;
    private ImageView N;
    private QFSPagAnimView P;
    private RelativeLayout Q;
    private RelativeLayout R;
    private FrameLayout S;
    private Drawable T;
    private d U;
    private ImageView V;
    private TextView W;
    private boolean X = false;
    private boolean Y = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class a implements View.OnLayoutChangeListener {
        a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            if (view.getHeight() > 0) {
                VasADImmersionBannerManager.this.f391316f.removeOnLayoutChangeListener(this);
                SetSplash.n(VasADImmersionBannerManager.this.f391316f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class b implements QFSPagAnimView.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a.C10566a f391334a;

        b(a.C10566a c10566a) {
            this.f391334a = c10566a;
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
        public /* synthetic */ void onAnimationCancel(QFSPagAnimView qFSPagAnimView) {
            bc.a(this, qFSPagAnimView);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
        public /* synthetic */ void onAnimationEnd(QFSPagAnimView qFSPagAnimView) {
            bc.b(this, qFSPagAnimView);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
        public /* synthetic */ void onAnimationRepeat(QFSPagAnimView qFSPagAnimView) {
            bc.c(this, qFSPagAnimView);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
        public /* synthetic */ void onAnimationStart(QFSPagAnimView qFSPagAnimView) {
            bc.d(this, qFSPagAnimView);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
        public /* synthetic */ void onAnimationUpdate(QFSPagAnimView qFSPagAnimView) {
            bc.e(this, qFSPagAnimView);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
        public void onPagPlayError(QFSPagAnimView qFSPagAnimView, String str) {
            bc.f(this, qFSPagAnimView, str);
            QLog.e("VasADBannerManager", 2, "mDynamicPagImageView onPagPlayError error", str);
            VasADImmersionBannerManager.this.P.R(this.f391334a.f409145c);
        }
    }

    private View W() {
        boolean z16;
        c cVar;
        Bundle bundle = new Bundle();
        d dVar = this.U;
        if (dVar != null && (cVar = dVar.f409148d) != null) {
            z16 = "1".equals(cVar.f407069j);
        } else {
            z16 = false;
        }
        bundle.putBoolean("data_key_status_bar_color", z16);
        return super.n(bundle);
    }

    private int X(d dVar) {
        c cVar;
        if (dVar != null && (cVar = this.U.f409148d) != null && !TextUtils.isEmpty(cVar.f407067h)) {
            try {
                return Integer.parseInt(cVar.f407067h);
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.i("VasADBannerManager", 1, "getFrameRate exception");
            }
        }
        return 24;
    }

    private String Y(c cVar) {
        if (!TextUtils.isEmpty(cVar.f407060a) && TextUtils.isEmpty(cVar.f407061b)) {
            return cVar.f407060a;
        }
        return cVar.f407061b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Z(j15.a aVar) {
        if (aVar == null || !(aVar instanceof d)) {
            return false;
        }
        d dVar = (d) aVar;
        this.U = dVar;
        c cVar = dVar.f409148d;
        if (cVar == null) {
            return false;
        }
        if (aVar.g()) {
            this.V.setVisibility(0);
            this.f391317h.setVisibility(8);
        }
        if (aVar.g() && a0(cVar)) {
            this.H.setVisibility(8);
            this.I.setVisibility(8);
            this.W.setVisibility(0);
            this.W.setText(Y(cVar));
            this.W.setTextColor(q(cVar.f407062c));
        } else {
            this.H.setText(j(cVar.f407060a));
            this.I.setText(j(cVar.f407061b));
            this.H.setTextColor(q(cVar.f407062c));
            this.I.setTextColor(q(cVar.f407062c));
        }
        this.J.setTextColor(q(cVar.f407062c));
        this.K.setTextColor(q(cVar.f407062c));
        M(q(cVar.f407062c));
        g0(dVar, cVar);
        return true;
    }

    private boolean a0(c cVar) {
        if ((TextUtils.isEmpty(cVar.f407060a) && !TextUtils.isEmpty(cVar.f407061b)) || (TextUtils.isEmpty(cVar.f407061b) && !TextUtils.isEmpty(cVar.f407060a))) {
            return true;
        }
        return false;
    }

    private void b0() {
        if (g() != null && h() != null) {
            QLog.i("VasADBannerManager", 1, "notifyBannerHide");
            BannerManager.l().D(VasADBannerProcessor.f185279h, 3001);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0() {
        if (g() != null && h() != null) {
            QLog.i("VasADBannerManager", 1, "notifyBannerShow");
            Message obtain = Message.obtain();
            obtain.what = 3000;
            obtain.obj = new View[]{this.f391316f, this.J, this.K, this.L, this.S, W()};
            BannerManager.l().G(VasADBannerProcessor.f185279h, obtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0() {
        QFSPagAnimView qFSPagAnimView;
        if (this.Y && (qFSPagAnimView = this.P) != null && !qFSPagAnimView.z()) {
            this.P.L();
        }
    }

    private void e0() {
        ViewGroup.LayoutParams layoutParams = this.f391316f.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        layoutParams.width = r();
        layoutParams.height = k();
        this.f391316f.setLayoutParams(layoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.Q.getLayoutParams();
        marginLayoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication());
        this.Q.setLayoutParams(marginLayoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.R.getLayoutParams();
        layoutParams2.width = r();
        layoutParams2.height = super.k();
        this.R.setLayoutParams(layoutParams2);
        f0();
        this.M.setWidthAndHeight(r(), k());
        this.M.setContainerViewWidthAndHeight(-1, layoutParams.height);
        this.f391316f.addOnLayoutChangeListener(new a());
    }

    private void f0() {
        this.N.setScaleType(ImageView.ScaleType.FIT_END);
        ViewGroup.LayoutParams layoutParams = this.N.getLayoutParams();
        layoutParams.width = (int) (k() * 2.0508475f);
        this.N.setLayoutParams(layoutParams);
        QFSPagAnimView qFSPagAnimView = this.P;
        if (qFSPagAnimView != null) {
            ViewGroup.LayoutParams layoutParams2 = qFSPagAnimView.getLayoutParams();
            layoutParams2.width = (int) (k() * 2.0508475f);
            this.P.setLayoutParams(layoutParams2);
        }
    }

    private void g0(d dVar, c cVar) {
        a.C10566a c10566a = dVar.f409140a.get(8);
        if (k0(c10566a, cVar)) {
            this.Y = true;
            i0(dVar, c10566a);
        } else {
            this.Y = false;
            this.P.setVisibility(8);
            j0(dVar, cVar);
        }
    }

    private void i0(d dVar, a.C10566a c10566a) {
        if (c10566a != null && !TextUtils.isEmpty(c10566a.f409145c)) {
            a.C10566a c10566a2 = dVar.f409140a.get(9);
            if (c10566a2 != null && !TextUtils.isEmpty(c10566a2.f409145c)) {
                this.P.setVisibility(0);
                this.P.R(c10566a2.f409145c);
                this.P.setImageViewScaleType(ImageView.ScaleType.CENTER_CROP);
                this.P.setPagAnimListener(new b(c10566a2));
                this.P.M(c10566a.f409145c);
                this.P.post(new Runnable() { // from class: cooperation.vip.qqbanner.manager.VasADImmersionBannerManager.4
                    @Override // java.lang.Runnable
                    public void run() {
                        VasADImmersionBannerManager.this.d0();
                    }
                });
                this.N.setVisibility(8);
                return;
            }
            QLog.d("VasADBannerManager", 1, "showDynamicImageView staticUrl is null");
            x();
        }
    }

    private void j0(d dVar, c cVar) {
        a.C10566a c10566a = dVar.f409140a.get(2);
        if (c10566a == null) {
            QLog.i("VasADBannerManager", 2, "handleBannerShow resourceInfo is null");
            return;
        }
        this.X = "1".equals(cVar.f407068i);
        QLog.i("VasADBannerManager", 2, "handleBannerShow mIsShowThreeDimension:" + this.X);
        this.T = ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).getZipAnimationDrawable();
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setAnimationRes(this.T, c10566a.f409145c, X(this.U));
        if (this.X) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setScale(this.T, (ViewUtils.getScreenWidth() / 720.0f) * 0.88f);
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setZipFirstFrameLoadedListener(this.T, new ZipFirstFrameLoadedListener() { // from class: cooperation.vip.qqbanner.manager.VasADImmersionBannerManager.5
                @Override // cooperation.qzone.zipanimate.ZipFirstFrameLoadedListener
                public void onZipFirstFrameLoaded(Drawable drawable) {
                    boolean z16;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("onZipFirstFrameLoaded d is null?:");
                    boolean z17 = true;
                    if (drawable == null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    sb5.append(String.valueOf(z16));
                    sb5.append(" mZipAnimationDrawable is null?:");
                    if (VasADImmersionBannerManager.this.T != null) {
                        z17 = false;
                    }
                    sb5.append(String.valueOf(z17));
                    QLog.i("VasADBannerManager", 2, sb5.toString());
                    if (VasADImmersionBannerManager.this.T != null) {
                        if (drawable != null) {
                            drawable.getIntrinsicWidth();
                            int intrinsicHeight = drawable.getIntrinsicHeight();
                            float screenWidth = (ViewUtils.getScreenWidth() / 720.0f) * 0.88f;
                            QLog.i("VasADBannerManager", 2, "onZipFirstFrameLoaded getIntrinsicWidth: " + drawable.getIntrinsicWidth() + " getIntrinsicHeight:" + drawable.getIntrinsicHeight() + " mScale:" + screenWidth);
                            VasADImmersionBannerManager.this.M.h(-1, (int) (((float) intrinsicHeight) * screenWidth));
                        }
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: cooperation.vip.qqbanner.manager.VasADImmersionBannerManager.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (VasADImmersionBannerManager.this.M.getVisibility() != 0) {
                                    VasADImmersionBannerManager.this.M.setVisibility(0);
                                }
                                VasADImmersionBannerManager.this.M.setImageDrawable(VasADImmersionBannerManager.this.T, true);
                            }
                        });
                    }
                }
            });
            if (this.M.getVisibility() != 0) {
                this.M.setVisibility(0);
            }
            URLImageView uRLImageView = this.f391318i;
            if (uRLImageView != null) {
                this.M.setBgViewDrawable(uRLImageView.getDrawable());
                this.f391318i.setVisibility(8);
            }
            this.M.setBgOnClickListener(this);
            this.N.setVisibility(8);
        } else {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setScale(this.T, ViewUtils.getScreenWidth() / 720.0f);
            this.N.setVisibility(0);
            this.M.setVisibility(8);
            URLImageView uRLImageView2 = this.f391318i;
            if (uRLImageView2 != null) {
                uRLImageView2.setVisibility(0);
            }
        }
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).clearFirstFrame(this.T);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setRepeatAnimation(this.T, true);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setShowLastFrameWhenStop(this.T, true);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).loadAndShowFirstFrame(this.T);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).start(this.T);
        QLog.i("VasADBannerManager", 2, cVar.toString());
        if (!this.X) {
            this.N.setImageDrawable(this.T);
        }
    }

    private boolean k0(a.C10566a c10566a, c cVar) {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("tian_shu_vas_banner_use_pag", true) && c10566a != null && !TextUtils.isEmpty(c10566a.f409143a) && cVar != null && !"1".equals(cVar.f407068i)) {
            return true;
        }
        return false;
    }

    @Override // cooperation.vip.qqbanner.manager.VasADBannerManager
    public View A() {
        View A = super.A();
        BaseActivity g16 = g();
        if (A != null && g16 != null) {
            this.H = (TextView) A.findViewById(R.id.k9g);
            this.I = (TextView) A.findViewById(R.id.kai);
            this.W = (TextView) A.findViewById(R.id.f111326kx);
            this.J = (TextView) A.findViewById(R.id.f10543660);
            this.K = (TextView) A.findViewById(R.id.f1056266i);
            this.L = (ImageView) A.findViewById(R.id.f164917ba3);
            this.N = (ImageView) A.findViewById(R.id.lla);
            this.P = (QFSPagAnimView) A.findViewById(R.id.xid);
            this.M = (NakedEyesView) A.findViewById(R.id.xij);
            this.Q = (RelativeLayout) A.findViewById(R.id.u8z);
            this.R = (RelativeLayout) A.findViewById(R.id.lpk);
            this.S = (FrameLayout) A.findViewById(R.id.v7e);
            ImageView imageView = (ImageView) A.findViewById(R.id.f165789xl2);
            this.V = imageView;
            imageView.setOnClickListener(this);
            A.findViewById(R.id.loading).setVisibility(8);
            e0();
            return new View(g16);
        }
        return null;
    }

    @Override // cooperation.vip.qqbanner.manager.VasADBannerManager
    public void E() {
        NakedEyesView nakedEyesView;
        super.E();
        QLog.i("VasADBannerManager", 2, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        if (this.T != null && (nakedEyesView = this.M) != null && this.X) {
            nakedEyesView.o();
        }
        if (this.T != null) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).stop(this.T);
        }
    }

    @Override // cooperation.vip.qqbanner.manager.VasADBannerManager
    public void F() {
        super.F();
        if (this.T != null) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).stop(this.T);
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).release(this.T);
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setZipFirstFrameLoadedListener(this.T, null);
            this.T = null;
        }
        NakedEyesView nakedEyesView = this.M;
        if (nakedEyesView != null) {
            nakedEyesView.k();
        }
    }

    @Override // cooperation.vip.qqbanner.manager.VasADBannerManager
    public void G(boolean z16) {
        super.G(z16);
        if (this.T != null) {
            if (z16) {
                ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).stop(this.T);
            } else {
                ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).start(this.T);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cooperation.vip.qqbanner.manager.VasADBannerManager
    public void J(final j15.a aVar) {
        super.J(aVar);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: cooperation.vip.qqbanner.manager.VasADImmersionBannerManager.2
            @Override // java.lang.Runnable
            public void run() {
                if (VasADImmersionBannerManager.this.Z(aVar)) {
                    VasADImmersionBannerManager.this.c0();
                }
            }
        });
    }

    @Override // cooperation.vip.qqbanner.manager.VasADBannerManager
    public void N() {
        super.N();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cooperation.vip.qqbanner.manager.VasADBannerManager
    public int k() {
        return super.k() + ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()) + ViewUtils.dpToPx(50.0f);
    }

    @Override // cooperation.vip.qqbanner.manager.VasADBannerManager
    public void onResume() {
        NakedEyesView nakedEyesView;
        super.onResume();
        QLog.i("VasADBannerManager", 2, "onResume");
        if (this.T != null && (nakedEyesView = this.M) != null && this.X) {
            nakedEyesView.j();
        }
        if (this.T != null) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).start(this.T);
        }
    }

    @Override // cooperation.vip.qqbanner.manager.VasADBannerManager
    protected int p() {
        return R.layout.hgw;
    }

    @Override // cooperation.vip.qqbanner.manager.VasADBannerManager
    public void x() {
        super.x();
        if (this.T != null) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).stop(this.T);
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).release(this.T);
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setZipFirstFrameLoadedListener(this.T, null);
        }
        NakedEyesView nakedEyesView = this.M;
        if (nakedEyesView != null) {
            nakedEyesView.k();
        }
        b0();
    }
}
