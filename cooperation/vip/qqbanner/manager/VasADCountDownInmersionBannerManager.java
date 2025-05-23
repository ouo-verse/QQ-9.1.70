package cooperation.vip.qqbanner.manager;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.bannerprocessor.VasADBannerProcessor;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.pay.api.impl.VasNativePayManagerImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tencent.widget.immersive.ImmersiveUtils;
import j15.a;
import j15.b;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: P */
/* loaded from: classes28.dex */
public class VasADCountDownInmersionBannerManager extends VasADBannerManager {
    private int H;
    private TextView I;
    private ImageView J;
    private ImageView K;
    private ImageView L;
    private ImageView M;
    private RelativeLayout N;
    private RelativeLayout P;
    private TextView Q;
    private TextView R;
    private FrameLayout S;
    private URLDrawable T;
    private URLDrawable U;
    private URLDrawable V;
    private URLDrawable W;
    private URLDrawable X;
    private b Y;
    private Timer Z;

    /* renamed from: a0, reason: collision with root package name */
    private TimerTask f391323a0;

    /* renamed from: b0, reason: collision with root package name */
    private long f391324b0;

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        QLog.e("QbossADCountDownInmersi", 1, "countDownComplete");
        j0();
        c0(true);
    }

    private URLDrawable X(b bVar, int i3) {
        ApngOptions apngOptions = new ApngOptions();
        apngOptions.setLoadingDrawable(new ColorDrawable(7));
        apngOptions.setUseCache(true);
        apngOptions.setTagId(new int[]{2});
        a.C10566a c10566a = bVar.f409140a.get(i3);
        if (c10566a == null) {
            QLog.e("QbossADCountDownInmersi", 1, "getApngDrawable error,type = " + i3);
            return null;
        }
        String str = c10566a.f409143a;
        String str2 = c10566a.f409145c;
        if (!FileUtils.isEmptyFile(str2)) {
            return ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("", apngOptions, str2);
        }
        if (!str.startsWith("https://")) {
            return null;
        }
        return ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable(PreDownloadConstants.DEPARTMENT_VAS, str, apngOptions);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Y(long j3) {
        long j16 = 0;
        if (j3 <= 0) {
            return "00:00:00";
        }
        if (j3 >= 3600) {
            j16 = j3 / 3600;
            j3 %= 3600;
        }
        return k0(j16) + ":" + k0(j3 / 60) + ":" + k0(j3 % 60);
    }

    private View Z() {
        boolean z16;
        i15.b l3;
        Bundle bundle = new Bundle();
        QLog.e("QbossADCountDownInmersi", 2, "getDataView");
        b bVar = this.Y;
        if (bVar != null && (l3 = bVar.l()) != null) {
            z16 = "1".equals(l3.f407059m);
        } else {
            z16 = false;
        }
        bundle.putBoolean("data_key_status_bar_color", z16);
        return super.n(bundle);
    }

    private URLDrawable a0(b bVar, int i3) {
        a.C10566a c10566a = bVar.f409140a.get(i3);
        if (c10566a == null) {
            QLog.e("QbossADCountDownInmersi", 1, "getApngDrawable error,type = " + i3);
            return null;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = URLDrawableHelper.getTransparent();
        obtain.mFailedDrawable = URLDrawableHelper.getTransparent();
        obtain.mPlayGifImage = false;
        final URLDrawable fileDrawable = URLDrawable.getFileDrawable(c10566a.f409145c, obtain);
        if (fileDrawable.getStatus() == 1) {
            QLog.i("QbossADCountDownInmersi", 1, "getLocalDrawable urlDrawable has memory data , url = " + c10566a.f409143a);
        } else {
            fileDrawable.setURLDrawableListener(new a(c10566a));
            ThreadManagerV2.excute(new Runnable() { // from class: cooperation.vip.qqbanner.manager.VasADCountDownInmersionBannerManager.3
                @Override // java.lang.Runnable
                public void run() {
                    URLDrawable uRLDrawable = fileDrawable;
                    if (uRLDrawable != null) {
                        uRLDrawable.downloadImediatly(true);
                    }
                }
            }, 64, null, false);
        }
        return fileDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(j15.a aVar) {
        if (aVar != null && (aVar instanceof b)) {
            b bVar = (b) aVar;
            this.Y = bVar;
            i15.b l3 = bVar.l();
            if (l3 == null) {
                return;
            }
            this.Q.setTextColor(q(l3.f407052f));
            this.R.setTextColor(q(l3.f407052f));
            M(q(l3.f407052f));
            this.T = X(bVar, 5);
            this.U = X(bVar, 6);
            this.V = a0(bVar, 3);
            this.W = a0(bVar, 4);
            this.X = a0(bVar, 7);
            this.I.setTextColor(q(l3.f407052f));
            g0();
            long j3 = l3.f407051e * 1000;
            this.f391324b0 = j3;
            long currentTimeMillis = (j3 - System.currentTimeMillis()) / 1000;
            QLog.e("QbossADCountDownInmersi", 1, "handleBannerShow countDownTotalTime = " + currentTimeMillis + " mCountDownTime = " + this.f391324b0 + " countDownTotalTime = " + currentTimeMillis);
            if (currentTimeMillis > 0) {
                i0();
            } else {
                W();
            }
        }
    }

    private void c0(boolean z16) {
        if (this.J == null) {
            return;
        }
        if (z16) {
            this.K.setVisibility(0);
            this.J.setVisibility(8);
            this.I.setVisibility(8);
            URLDrawable uRLDrawable = this.U;
            if (uRLDrawable != null) {
                this.M.setImageDrawable(uRLDrawable);
            }
            URLDrawable uRLDrawable2 = this.W;
            if (uRLDrawable2 != null) {
                this.K.setImageDrawable(uRLDrawable2);
            }
            URLDrawable uRLDrawable3 = this.X;
            if (uRLDrawable3 != null) {
                this.f391318i.setImageDrawable(uRLDrawable3);
                return;
            }
            return;
        }
        this.K.setVisibility(8);
        this.J.setVisibility(0);
        this.I.setVisibility(0);
        URLDrawable uRLDrawable4 = this.T;
        if (uRLDrawable4 != null) {
            this.M.setImageDrawable(uRLDrawable4);
        }
        URLDrawable uRLDrawable5 = this.V;
        if (uRLDrawable5 != null) {
            this.J.setImageDrawable(uRLDrawable5);
        }
    }

    private void d0() {
        if (g() != null && h() != null) {
            QLog.i("QbossADCountDownInmersi", 1, "notifyBannerHide");
            BannerManager.l().D(VasADBannerProcessor.f185279h, 3001);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0() {
        if (g() != null && h() != null) {
            QLog.i("QbossADCountDownInmersi", 1, "notifyBannerShow");
            Message obtain = Message.obtain();
            obtain.what = 3000;
            obtain.obj = new View[]{this.f391316f, this.Q, this.R, this.L, this.S, Z()};
            BannerManager.l().G(VasADBannerProcessor.f185279h, obtain);
        }
    }

    private void f0() {
        ViewGroup.LayoutParams layoutParams = this.f391316f.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        layoutParams.width = r();
        layoutParams.height = k();
        this.f391316f.setLayoutParams(layoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.N.getLayoutParams();
        marginLayoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication());
        this.N.setLayoutParams(marginLayoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.P.getLayoutParams();
        layoutParams2.width = r();
        layoutParams2.height = super.k();
        this.P.setLayoutParams(layoutParams2);
        this.M.setScaleType(ImageView.ScaleType.FIT_END);
        ViewGroup.LayoutParams layoutParams3 = this.M.getLayoutParams();
        int i3 = layoutParams.height;
        layoutParams3.width = (int) (i3 * 2.20339f);
        layoutParams3.height = i3;
        this.M.setLayoutParams(layoutParams3);
        ViewGroup.LayoutParams layoutParams4 = this.J.getLayoutParams();
        layoutParams4.width = ViewUtils.dpToPx(40.0f);
        layoutParams4.height = ViewUtils.dpToPx(40.0f);
        this.J.setLayoutParams(layoutParams4);
        ViewGroup.LayoutParams layoutParams5 = this.K.getLayoutParams();
        layoutParams5.width = ViewUtils.dpToPx(244.0f);
        layoutParams5.height = ViewUtils.dpToPx(38.0f);
        this.K.setLayoutParams(layoutParams5);
    }

    private void g0() {
        Typeface createFromAsset;
        AssetManager assets = BaseApplicationImpl.getApplication().getAssets();
        if (assets != null && (createFromAsset = Typeface.createFromAsset(assets, VasNativePayManagerImpl.DINALTERNATE_BOLD_FONT_PATH)) != null) {
            QLog.e("QbossADCountDownInmersi", 1, "setTypeFace");
            this.I.setTypeface(createFromAsset);
        }
    }

    private void i0() {
        c0(false);
        QLog.e("QbossADCountDownInmersi", 1, "startCountDown");
        j0();
        this.Z = new BaseTimer();
        TimerTask timerTask = new TimerTask() { // from class: cooperation.vip.qqbanner.manager.VasADCountDownInmersionBannerManager.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: cooperation.vip.qqbanner.manager.VasADCountDownInmersionBannerManager.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VasADCountDownInmersionBannerManager.this.I == null) {
                            return;
                        }
                        long currentTimeMillis = (VasADCountDownInmersionBannerManager.this.f391324b0 - System.currentTimeMillis()) / 1000;
                        if (currentTimeMillis <= 0) {
                            VasADCountDownInmersionBannerManager.this.W();
                        } else {
                            VasADCountDownInmersionBannerManager.this.I.setText(VasADCountDownInmersionBannerManager.this.Y(currentTimeMillis));
                        }
                    }
                });
            }
        };
        this.f391323a0 = timerTask;
        this.Z.schedule(timerTask, 0L, 1000L);
    }

    private void j0() {
        QLog.e("QbossADCountDownInmersi", 1, "stopTimer");
        TimerTask timerTask = this.f391323a0;
        if (timerTask != null) {
            timerTask.cancel();
        }
        Timer timer = this.Z;
        if (timer != null) {
            timer.cancel();
        }
        this.Z = null;
        this.f391323a0 = null;
    }

    private String k0(long j3) {
        if (j3 >= 0 && j3 < 10) {
            return "0" + Long.toString(j3);
        }
        return "" + j3;
    }

    @Override // cooperation.vip.qqbanner.manager.VasADBannerManager
    public View A() {
        View A = super.A();
        BaseActivity g16 = g();
        if (A != null && g16 != null) {
            this.I = (TextView) A.findViewById(R.id.f107046_c);
            this.J = (ImageView) A.findViewById(R.id.xih);
            this.K = (ImageView) A.findViewById(R.id.xii);
            this.Q = (TextView) A.findViewById(R.id.f10543660);
            this.R = (TextView) A.findViewById(R.id.f1056266i);
            this.L = (ImageView) A.findViewById(R.id.f164917ba3);
            this.M = (ImageView) A.findViewById(R.id.lla);
            this.N = (RelativeLayout) A.findViewById(R.id.u8z);
            this.P = (RelativeLayout) A.findViewById(R.id.lpk);
            this.S = (FrameLayout) A.findViewById(R.id.v7e);
            A.findViewById(R.id.loading).setVisibility(8);
            f0();
            return new View(g16);
        }
        return null;
    }

    @Override // cooperation.vip.qqbanner.manager.VasADBannerManager
    public void F() {
        super.F();
        j0();
        this.U = null;
        this.T = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cooperation.vip.qqbanner.manager.VasADBannerManager
    public void J(final j15.a aVar) {
        super.J(aVar);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: cooperation.vip.qqbanner.manager.VasADCountDownInmersionBannerManager.1
            @Override // java.lang.Runnable
            public void run() {
                j15.a aVar2 = aVar;
                if (aVar2 != null) {
                    VasADCountDownInmersionBannerManager.this.b0(aVar2);
                    VasADCountDownInmersionBannerManager.this.e0();
                }
            }
        });
    }

    @Override // cooperation.vip.qqbanner.manager.VasADBannerManager
    public void N() {
        super.N();
    }

    @Override // cooperation.vip.qqbanner.manager.VasADBannerManager
    public void b() {
        i15.b l3;
        b bVar = this.Y;
        if (bVar != null && (l3 = bVar.l()) != null && l3.f407058l) {
            return;
        }
        super.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cooperation.vip.qqbanner.manager.VasADBannerManager
    public int k() {
        int k3 = super.k();
        this.H = k3;
        return k3 + ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()) + ViewUtils.dpToPx(50.0f);
    }

    @Override // cooperation.vip.qqbanner.manager.VasADBannerManager
    protected int p() {
        return R.layout.hgv;
    }

    @Override // cooperation.vip.qqbanner.manager.VasADBannerManager
    public void x() {
        super.x();
        d0();
        j0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class a implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a.C10566a f391328d;

        a(a.C10566a c10566a) {
            this.f391328d = c10566a;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            QLog.i("QbossADCountDownInmersi", 1, "getLocalDrawable urlDrawable onLoadFialed , url = " + this.f391328d.f409143a);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            QLog.i("QbossADCountDownInmersi", 1, "getLocalDrawable urlDrawable onLoadSuccessed , url = " + this.f391328d.f409143a);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        }
    }
}
