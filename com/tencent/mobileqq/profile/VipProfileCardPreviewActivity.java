package com.tencent.mobileqq.profile;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.qzone.homepage.ui.Facade.model.FacadeCacheData;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.profile.upload.a;
import com.tencent.mobileqq.profile.view.VipScaledViewPager;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ff;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.ProfileCardScrollImageView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.upload.uinterface.data.UpsImageUploadResult;
import com.tencent.widget.CirclePageIndicator;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes16.dex */
public class VipProfileCardPreviewActivity extends VipProfileCardBaseActivity implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    public ImageView G0;
    public View H0;
    public Drawable I0;
    public d J0;
    Runnable K0;
    public VipScaledViewPager L0;
    public CirclePageIndicator M0;
    public Button N0;
    public c O0;
    public int P0;
    public int Q0;
    public int R0;
    public int S0;
    public int T0;
    public int U0;
    public int V0;
    public int W0;
    public int X0;
    public int Y0;
    public float Z0;

    /* renamed from: a1, reason: collision with root package name */
    public int f260089a1;

    /* renamed from: b1, reason: collision with root package name */
    public float f260090b1;

    /* renamed from: c1, reason: collision with root package name */
    public int f260091c1;

    /* renamed from: d1, reason: collision with root package name */
    public boolean f260092d1;

    /* renamed from: e1, reason: collision with root package name */
    public float f260093e1;

    /* renamed from: f1, reason: collision with root package name */
    public float f260094f1;

    /* renamed from: g1, reason: collision with root package name */
    public long f260095g1;

    /* renamed from: h1, reason: collision with root package name */
    public ArrayList<Long> f260096h1;

    /* renamed from: i1, reason: collision with root package name */
    public List<g> f260097i1;

    /* renamed from: j1, reason: collision with root package name */
    public List<String> f260098j1;

    /* renamed from: k1, reason: collision with root package name */
    public int f260099k1;

    /* renamed from: l1, reason: collision with root package name */
    public int f260100l1;

    /* renamed from: m1, reason: collision with root package name */
    public int f260101m1;

    /* renamed from: n1, reason: collision with root package name */
    public String f260102n1;

    /* renamed from: o1, reason: collision with root package name */
    int f260103o1;

    /* renamed from: p1, reason: collision with root package name */
    String f260104p1;

    /* renamed from: q1, reason: collision with root package name */
    public boolean f260105q1;

    /* renamed from: r1, reason: collision with root package name */
    public boolean f260106r1;

    /* renamed from: s1, reason: collision with root package name */
    public int f260107s1;

    /* renamed from: t1, reason: collision with root package name */
    public String f260108t1;

    /* renamed from: u1, reason: collision with root package name */
    private volatile long f260109u1;

    /* renamed from: v1, reason: collision with root package name */
    HashMap<String, String> f260110v1;

    /* renamed from: w1, reason: collision with root package name */
    volatile boolean f260111w1;

    /* loaded from: classes16.dex */
    class a implements ViewPager.OnPageChangeListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        boolean f260123d;

        /* renamed from: e, reason: collision with root package name */
        boolean f260124e;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VipProfileCardPreviewActivity.this);
            } else {
                this.f260123d = false;
                this.f260124e = false;
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "onPageScrollStateChanged state = " + i3);
            }
            if (i3 == 1) {
                VipProfileCardPreviewActivity.this.L0.m();
                VipProfileCardPreviewActivity vipProfileCardPreviewActivity = VipProfileCardPreviewActivity.this;
                vipProfileCardPreviewActivity.b3(vipProfileCardPreviewActivity.f260091c1);
                this.f260124e = true;
            }
            if (i3 == 2) {
                this.f260123d = true;
            }
            if (i3 == 0) {
                if (this.f260123d) {
                    VipProfileCardPreviewActivity vipProfileCardPreviewActivity2 = VipProfileCardPreviewActivity.this;
                    vipProfileCardPreviewActivity2.z3(vipProfileCardPreviewActivity2.f260091c1);
                    this.f260123d = false;
                    VipProfileCardPreviewActivity.this.L0.n();
                }
                if (this.f260124e) {
                    VipProfileCardPreviewActivity.this.L0.n();
                    this.f260124e = false;
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Float.valueOf(f16), Integer.valueOf(i16));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "onPageScrolled pos = " + i3);
            }
            VipProfileCardPreviewActivity.this.L0.m();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "onPageSelected pos = " + i3);
            }
            VipProfileCardPreviewActivity.this.L0.n();
            VipProfileCardPreviewActivity.this.i3(i3);
            VipProfileCardPreviewActivity vipProfileCardPreviewActivity = VipProfileCardPreviewActivity.this;
            vipProfileCardPreviewActivity.f260091c1 = i3;
            QQAppInterface qQAppInterface = vipProfileCardPreviewActivity.app;
            ReportController.o(qQAppInterface, "CliOper", "", "", "card_mall", "0X8004C26", 0, 0, "", "", "", ff.h(qQAppInterface, qQAppInterface.getCurrentAccountUin()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class b extends com.tencent.mobileqq.profile.upload.task.b {
        static IPatchRedirector $redirector_;
        final /* synthetic */ long J;
        final /* synthetic */ String K;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(long j3, String str, byte[] bArr, String str2, long j16, String str3) {
            super(j3, str, bArr, str2);
            this.J = j16;
            this.K = str3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, VipProfileCardPreviewActivity.this, Long.valueOf(j3), str, bArr, str2, Long.valueOf(j16), str3);
            }
        }

        @Override // com.tencent.mobileqq.profile.upload.task.a
        public void e(int i3, Object... objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) objArr);
                return;
            }
            if (i3 != 1001) {
                if (i3 == 1002) {
                    VasCommonReporter.getServiceQuality("card_diy_upload").setNum1(1L).setNum2(SystemClock.uptimeMillis() - this.J).report(false);
                    VipProfileCardPreviewActivity.this.c3();
                    VipProfileCardPreviewActivity.this.f260066z0.sendMessage(VipProfileCardPreviewActivity.this.f260066z0.obtainMessage(24, c()));
                    return;
                }
                return;
            }
            VasCommonReporter.getServiceQuality("card_diy_upload").setNum1(0L).setNum2(SystemClock.uptimeMillis() - this.J).report(false);
            VipProfileCardPreviewActivity.this.c3();
            if (d() != null) {
                VipProfileCardPreviewActivity.this.u3(this.K, (UpsImageUploadResult) d());
            }
        }
    }

    /* loaded from: classes16.dex */
    public class c extends PagerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public LayoutInflater f260126d;

        /* renamed from: e, reason: collision with root package name */
        public Context f260127e;

        /* loaded from: classes16.dex */
        public class a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            ProfileCardScrollImageView f260129a;

            public a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
                }
            }
        }

        public c(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VipProfileCardPreviewActivity.this, (Object) context);
            } else {
                this.f260127e = context;
                this.f260126d = LayoutInflater.from(context);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, viewGroup, Integer.valueOf(i3), obj);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "destroyItem, pos = " + i3);
            }
            View view = (View) obj;
            viewGroup.removeView(view);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return VipProfileCardPreviewActivity.this.f260097i1.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @TargetApi(16)
        public Object instantiateItem(ViewGroup viewGroup, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup, i3);
            }
            if (QLog.isColorLevel()) {
                QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "instantiateItem, pos = " + i3);
            }
            View inflate = this.f260126d.inflate(R.layout.bex, viewGroup, false);
            a aVar = new a();
            aVar.f260129a = (ProfileCardScrollImageView) inflate.findViewById(R.id.cqo);
            inflate.setTag(aVar);
            aVar.f260129a.setScaleType(ImageView.ScaleType.FIT_XY);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) aVar.f260129a.getLayoutParams();
            VipProfileCardPreviewActivity vipProfileCardPreviewActivity = VipProfileCardPreviewActivity.this;
            layoutParams.width = vipProfileCardPreviewActivity.f260100l1;
            layoutParams.height = vipProfileCardPreviewActivity.f260099k1;
            aVar.f260129a.setLayoutParams(layoutParams);
            aVar.f260129a.setBackground(VipProfileCardPreviewActivity.this.I0);
            aVar.f260129a.setImageDrawable(this.f260127e.getResources().getDrawable(R.drawable.fsv));
            inflate.setId(i3);
            g gVar = VipProfileCardPreviewActivity.this.f260097i1.get(i3);
            viewGroup.addView(inflate);
            VipProfileCardPreviewActivity.this.t3(aVar, gVar, i3);
            return inflate;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, obj)).booleanValue();
            }
            if (view == obj) {
                return true;
            }
            return false;
        }
    }

    public VipProfileCardPreviewActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.I0 = null;
        this.P0 = -1;
        this.Q0 = 0;
        this.R0 = 0;
        this.S0 = 0;
        this.T0 = 0;
        this.U0 = 0;
        this.V0 = 0;
        this.W0 = 0;
        this.X0 = 0;
        this.Y0 = 0;
        this.Z0 = 0.0f;
        this.f260089a1 = 0;
        this.f260090b1 = 1.0f;
        this.f260091c1 = -1;
        this.f260092d1 = false;
        this.f260093e1 = 1.6666666f;
        this.f260094f1 = 1.775f;
        this.f260095g1 = -1L;
        this.f260096h1 = new ArrayList<>();
        this.f260097i1 = Collections.synchronizedList(new ArrayList());
        this.f260098j1 = Collections.synchronizedList(new ArrayList());
        this.f260102n1 = "0";
        this.f260103o1 = 0;
        this.f260104p1 = null;
        this.f260105q1 = false;
        this.f260106r1 = false;
        this.f260107s1 = -1;
        this.f260108t1 = "is_binding_shop";
        this.f260109u1 = -1L;
        this.f260110v1 = new HashMap<>();
        this.f260111w1 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s3(String str, long j3, byte[] bArr) {
        b bVar = new b(Long.parseLong(this.app.getCurrentAccountUin()), str, bArr, "qqprofile", j3, str);
        bVar.f260334n = bArr;
        bVar.f260346y = com.tencent.mobileqq.profile.upload.a.b(this.app, str);
        y3();
        com.tencent.mobileqq.profile.upload.task.c cVar = (com.tencent.mobileqq.profile.upload.task.c) this.app.getManager(QQManagerFactory.IMAGE_UPLOAD_MANAGER);
        cVar.b(this.app, null);
        bVar.j();
        cVar.c(this.app, bVar, null);
    }

    public void A3(int i3, g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3, (Object) gVar);
            return;
        }
        if (gVar == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "startDownload pos = " + i3 + ", status = " + gVar.f260160b);
        }
        int i16 = gVar.f260160b;
        if (i16 != 2 && i16 != 1) {
            gVar.f260160b = 1;
            List<String> g36 = g3(gVar);
            this.f260098j1.addAll(g36);
            C3(i3, g36);
        }
    }

    public void B3(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3, (Object) str);
        } else {
            ThreadManagerV2.post(new Runnable(i3, str) { // from class: com.tencent.mobileqq.profile.VipProfileCardPreviewActivity.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f260113d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f260114e;

                /* renamed from: com.tencent.mobileqq.profile.VipProfileCardPreviewActivity$4$a */
                /* loaded from: classes16.dex */
                class a extends com.tencent.mobileqq.vip.f {
                    static IPatchRedirector $redirector_;

                    a() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this);
                        }
                    }

                    @Override // com.tencent.mobileqq.vip.f
                    public void onDone(com.tencent.mobileqq.vip.g gVar) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                            iPatchRedirector.redirect((short) 4, (Object) this, (Object) gVar);
                        } else if (QLog.isColorLevel()) {
                            QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, String.format("Resource style end download, url : %s, resultCode : %d ", gVar.f313004c, Integer.valueOf(gVar.f313006d)));
                        }
                    }

                    @Override // com.tencent.mobileqq.vip.f
                    public void onProgress(com.tencent.mobileqq.vip.g gVar) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                            iPatchRedirector.redirect((short) 3, (Object) this, (Object) gVar);
                            return;
                        }
                        int i3 = (int) gVar.f313015m;
                        if (QLog.isColorLevel()) {
                            QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, String.format("Resource style progress, url : %s, progress : %d", gVar.f313004c, Integer.valueOf(i3)));
                        }
                    }

                    @Override // com.tencent.mobileqq.vip.f
                    public boolean onStart(com.tencent.mobileqq.vip.g gVar) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar)).booleanValue();
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, String.format("Resource style start download, url : %s, position : %s ", gVar.f313004c, Integer.valueOf(AnonymousClass4.this.f260113d)));
                        }
                        return true;
                    }
                }

                {
                    this.f260113d = i3;
                    this.f260114e = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, VipProfileCardPreviewActivity.this, Integer.valueOf(i3), str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    int K2 = VipProfileCardPreviewActivity.this.K2(this.f260114e, new a());
                    if (K2 != 19 && K2 != 0) {
                        Message obtainMessage = VipProfileCardPreviewActivity.this.f260066z0.obtainMessage(21);
                        obtainMessage.arg1 = this.f260113d;
                        VipProfileCardPreviewActivity.this.f260066z0.sendMessage(obtainMessage);
                        if (QLog.isColorLevel()) {
                            QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, String.format("styles download fail , url : %s, position : %d ", this.f260114e, Integer.valueOf(this.f260113d)));
                            return;
                        }
                        return;
                    }
                    Message obtainMessage2 = VipProfileCardPreviewActivity.this.f260066z0.obtainMessage(20);
                    obtainMessage2.arg1 = this.f260113d;
                    VipProfileCardPreviewActivity.this.f260066z0.sendMessage(obtainMessage2);
                    if (QLog.isColorLevel()) {
                        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, String.format("style download success , url : %s, position : %d ", this.f260114e, Integer.valueOf(this.f260113d)));
                    }
                    VipProfileCardPreviewActivity.this.f260098j1.remove(this.f260114e);
                }
            }, 5, null, true);
        }
    }

    public void C3(int i3, List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3, (Object) list);
        } else if (list != null && list.size() != 0) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                B3(i3, it.next());
            }
        }
    }

    public void D3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            setLeftViewName(R.string.button_back);
            setTitle(R.string.d3i);
        }
    }

    void E3(final String str) {
        final long uptimeMillis = SystemClock.uptimeMillis();
        com.tencent.mobileqq.profile.upload.a.c(this.app, new a.b() { // from class: com.tencent.mobileqq.profile.n
            @Override // com.tencent.mobileqq.profile.upload.a.b
            public final void a(byte[] bArr) {
                VipProfileCardPreviewActivity.this.s3(str, uptimeMillis, bArr);
            }
        });
    }

    @Override // com.tencent.mobileqq.profile.VipProfileCardBaseActivity
    protected void N2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        VipScaledViewPager vipScaledViewPager = this.L0;
        if (vipScaledViewPager == null) {
            return;
        }
        i3(vipScaledViewPager.getCurrentItem());
    }

    @Override // com.tencent.mobileqq.profile.VipProfileCardBaseActivity
    @TargetApi(16)
    protected boolean R2(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 1) {
            switch (i3) {
                case 27:
                    int childCount = this.L0.getChildCount();
                    for (int i16 = 0; i16 < childCount; i16++) {
                        View childAt = this.L0.getChildAt(i16);
                        if (childAt.getTag() instanceof c.a) {
                            ((c.a) childAt.getTag()).f260129a.setBackgroundDrawable(this.I0);
                        }
                    }
                    return true;
                case 28:
                    w3(message.arg1);
                    return true;
                case 29:
                    w3(message.arg1);
                    return true;
                default:
                    if (i3 == 2) {
                        this.G0.setBackground(this.I0);
                        return true;
                    }
                    if (i3 == 3) {
                        QQToast.makeText(this.f260042b0.getApplicationContext(), R.string.d36, 0).show();
                        return true;
                    }
                    if (i3 == 20) {
                        w3(message.arg1);
                        return true;
                    }
                    if (i3 == 5) {
                        QQToast.makeText(this.f260042b0.getApplicationContext(), R.string.d3x, 0).show();
                        int i17 = this.f260055o0;
                        if (i17 != 1 && i17 != 2) {
                            Intent profileCardIntentOnly = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getProfileCardIntentOnly(this, new AllInOne(this.app.getCurrentAccountUin(), 0));
                            profileCardIntentOnly.setFlags(67108864);
                            startActivity(profileCardIntentOnly);
                        } else if (this.f260103o1 == 1) {
                            BaseApplication.getContext().sendBroadcast(new Intent("com.tencent.mobileqq.action.closeWeb"), "com.tencent.msg.permission.pushnotify");
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra("uin", this.app.getCurrentAccountUin());
                            intent.putExtra(MttLoader.ENTRY_ID, this.f260055o0);
                            setResult(-1, intent);
                        }
                        v3();
                        finish();
                        return true;
                    }
                    if (i3 == 21) {
                        List<g> list = this.f260097i1;
                        if (list != null) {
                            list.get(message.arg1).f260160b = -1;
                        }
                        return true;
                    }
                    if (i3 != 24 && i3 != 25) {
                        return false;
                    }
                    if (i3 == 25) {
                        dismissDialog();
                    }
                    QQToast.makeText(getApplicationContext(), getResources().getString(R.string.f171202d42), 1).show();
                    return true;
            }
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.L0.getLayoutParams();
        layoutParams.height = this.P0;
        layoutParams.topMargin = this.X0;
        this.L0.setLayoutParams(layoutParams);
        this.L0.setScale(this.Z0);
        this.L0.setGap(this.Y0);
        this.L0.setAdapter(this.O0);
        this.M0.setViewPager(this.L0);
        this.M0.setVisibility(0);
        j3();
        this.L0.setCurrentItem(this.f260091c1);
        i3(this.f260091c1);
        if (QLog.isColorLevel()) {
            QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "initiate now mCurrentViewPos = " + this.f260091c1);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public void addObserver(BusinessObserver businessObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) businessObserver);
            return;
        }
        QQAppInterface qQAppInterface = this.app;
        if (qQAppInterface != null) {
            qQAppInterface.addObserver(businessObserver);
        }
    }

    void b3(int i3) {
        List<g> list;
        View findViewById;
        c.a aVar;
        if (this.L0 != null && (list = this.f260097i1) != null && i3 >= 0 && i3 < list.size() && (findViewById = this.L0.findViewById(i3)) != null && findViewById.getTag() != null && (aVar = (c.a) findViewById.getTag()) != null) {
            ProfileCardScrollImageView profileCardScrollImageView = aVar.f260129a;
            g gVar = this.f260097i1.get(i3);
            if (gVar != null) {
                int i16 = gVar.f260159a.animation;
                if (i16 != 0) {
                    if (i16 != 1) {
                        if (i16 == 2) {
                            if (QLog.isColorLevel()) {
                                QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "cancel ANIMATION_FADE_IN_OUT");
                            }
                            Runnable runnable = this.K0;
                            if (runnable != null) {
                                this.f260066z0.removeCallbacks(runnable);
                            }
                            Drawable drawable = profileCardScrollImageView.getDrawable();
                            if (drawable != null && (drawable instanceof TransitionDrawable)) {
                                ((TransitionDrawable) drawable).resetTransition();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "cancel ANIMATION_SCROLL");
                    }
                    profileCardScrollImageView.b();
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "cancel ANIMATION_NONE");
                }
            }
        }
    }

    void c3() {
        dismissDialog();
        this.f260066z0.removeMessages(25);
    }

    int calculateInSampleSize(BitmapFactory.Options options, int i3, int i16) {
        int i17 = 1;
        if (i3 != 0 && i16 != 0 && i3 != -1 && i16 != -1) {
            int i18 = options.outHeight;
            int i19 = options.outWidth;
            while (i18 > i16 && i19 > i3) {
                int round = Math.round(i18 / i16);
                int round2 = Math.round(i19 / i3);
                if (round <= round2) {
                    round = round2;
                }
                if (round < 2) {
                    break;
                }
                i19 /= 2;
                i18 /= 2;
                i17 *= 2;
            }
        }
        return i17;
    }

    long d3() {
        return this.f260097i1.get(this.L0.getCurrentItem()).f260159a.styleId;
    }

    @Override // com.tencent.mobileqq.profile.VipProfileCardBaseActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.profile.VipProfileCardBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    @TargetApi(16)
    public boolean doOnCreate(Bundle bundle) {
        String num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        VasCommonReporter.getHistoryFeature("card_diy").setValue2(OperateCustomButton.OPERATE_CREATE).report(false);
        this.f260111w1 = false;
        setContentView(R.layout.bey);
        getWindow().setBackgroundDrawable(null);
        this.f260042b0 = this;
        this.H0 = findViewById(R.id.gsb);
        QQAppInterface qQAppInterface = this.app;
        if (qQAppInterface != null && ThemeUtil.isInNightMode(qQAppInterface)) {
            View view = this.H0;
            if (view != null) {
                view.setVisibility(0);
            }
        } else {
            View view2 = this.H0;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
        if (this.app != null) {
            this.f260108t1 += this.app.getCurrentAccountUin();
        }
        this.M0 = (CirclePageIndicator) findViewById(R.id.fhp);
        this.N0 = (Button) findViewById(R.id.fcw);
        this.L0 = (VipScaledViewPager) findViewById(R.id.kwk);
        this.O0 = new c(this.f260042b0);
        if (DeviceInfoMonitor.getModel().equals("HUAWEI C8812E")) {
            this.L0.setLayerType(1, null);
        }
        float f16 = this.f260062v0 / 2.0f;
        this.f260090b1 = f16;
        int i3 = this.f260060t0;
        if (i3 / this.f260061u0 > (this.f260093e1 + this.f260094f1) / 2.0f) {
            float f17 = i3 / (f16 * 1136.0f);
            this.Q0 = Math.round(ProfileCardUtil.h(this.f260042b0, 15) * f17);
            this.R0 = Math.round(ProfileCardUtil.h(this.f260042b0, 15) * f17);
            this.S0 = Math.round(ProfileCardUtil.h(this.f260042b0, 15) * f17);
            this.T0 = ProfileCardUtil.h(this.f260042b0, 45);
            this.U0 = Math.round(ProfileCardUtil.h(this.f260042b0, 3) * f17);
            this.W0 = Math.round(ProfileCardUtil.h(this.f260042b0, 7) * f17);
            this.V0 = Math.round(ProfileCardUtil.g(this.f260042b0, 14.5f) * f17);
            this.X0 = Math.round(ProfileCardUtil.h(this.f260042b0, 20) * f17);
            this.Y0 = Math.round(f17 * ProfileCardUtil.h(this.f260042b0, 15));
            this.Z0 = 0.8245033f;
            this.f260089a1 = 18;
        } else {
            float f18 = i3 / (f16 * 800.0f);
            this.Q0 = Math.round(ProfileCardUtil.h(this.f260042b0, 11) * f18);
            this.R0 = Math.round(ProfileCardUtil.h(this.f260042b0, 10) * f18);
            this.S0 = Math.round(ProfileCardUtil.h(this.f260042b0, 11) * f18);
            this.T0 = ProfileCardUtil.h(this.f260042b0, 40);
            this.U0 = Math.round(ProfileCardUtil.h(this.f260042b0, 3) * f18);
            this.W0 = Math.round(ProfileCardUtil.h(this.f260042b0, 7) * f18);
            this.V0 = Math.round(ProfileCardUtil.g(this.f260042b0, 16.5f) * f18);
            this.X0 = Math.round(ProfileCardUtil.h(this.f260042b0, 20) * f18);
            this.Y0 = Math.round(f18 * ProfileCardUtil.h(this.f260042b0, 15));
            this.f260089a1 = 16;
            this.Z0 = 0.8192771f;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.N0.getLayoutParams();
        layoutParams.height = this.T0;
        int i16 = this.S0;
        layoutParams.leftMargin = i16;
        layoutParams.rightMargin = i16;
        layoutParams.bottomMargin = this.R0;
        this.N0.setTextSize(1, this.f260089a1);
        this.N0.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.M0.getLayoutParams();
        int i17 = this.V0;
        layoutParams2.topMargin = i17;
        layoutParams2.bottomMargin = i17;
        this.M0.setLayoutParams(layoutParams2);
        this.M0.setCirclePadding(this.W0);
        this.M0.setRadius(this.U0);
        int dimensionPixelSize = ((((((this.f260060t0 - this.X0) - this.R0) - this.T0) - (this.U0 * 2)) - (this.V0 * 2)) - getResources().getDimensionPixelSize(R.dimen.title_bar_height)) - ProfileCardUtil.B(getResources());
        this.P0 = dimensionPixelSize;
        this.f260099k1 = dimensionPixelSize;
        this.f260100l1 = Math.round(dimensionPixelSize / 1.78f);
        this.M0.setStrokeWidth(0.0f);
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.profile.VipProfileCardPreviewActivity.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VipProfileCardPreviewActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    VipProfileCardPreviewActivity.this.l3();
                    VipProfileCardPreviewActivity.this.p3();
                }
            }
        }, 8, null, true);
        D3();
        this.N0.setOnClickListener(this);
        QQAppInterface qQAppInterface2 = this.app;
        if (qQAppInterface2 != null) {
            qQAppInterface2.addObserver(this.A0, true);
        }
        this.M0.setOnPageChangeListener(new a());
        QQAppInterface qQAppInterface3 = this.app;
        if (qQAppInterface3 != null) {
            d dVar = this.J0;
            if (dVar == null) {
                num = "";
            } else {
                num = Integer.toString(dVar.f260137a);
            }
            String str = num;
            QQAppInterface qQAppInterface4 = this.app;
            ReportController.o(qQAppInterface3, "CliOper", "", "", "card_mall", "0X8004D59", 0, 0, str, "", "", ff.h(qQAppInterface4, qQAppInterface4.getCurrentAccountUin()));
        }
        return true;
    }

    @Override // com.tencent.mobileqq.profile.VipProfileCardBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
        } else {
            super.doOnDestroy();
            this.f260111w1 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.doOnPause();
        QQAppInterface qQAppInterface = this.app;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.A0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.doOnResume();
        QQAppInterface qQAppInterface = this.app;
        if (qQAppInterface != null) {
            qQAppInterface.addObserver(this.A0, true);
        }
    }

    void e3(String str, String str2) {
        ThreadManagerV2.post(new Runnable(str, str2) { // from class: com.tencent.mobileqq.profile.VipProfileCardPreviewActivity.7
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f260121d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f260122e;

            {
                this.f260121d = str;
                this.f260122e = str2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, VipProfileCardPreviewActivity.this, str, str2);
                }
            }

            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x015b -> B:33:0x015e). Please report as a decompilation issue!!! */
            @Override // java.lang.Runnable
            public void run() {
                BufferedInputStream bufferedInputStream;
                OutOfMemoryError e16;
                Exception e17;
                BitmapFactory.Options options;
                Resources resources;
                Bitmap decodeStream;
                Handler handler;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                BufferedInputStream bufferedInputStream2 = null;
                try {
                    try {
                        try {
                            options = new BitmapFactory.Options();
                            options.inJustDecodeBounds = true;
                            resources = VipProfileCardPreviewActivity.this.app.getApp().getResources();
                            BitmapFactory.decodeFile(this.f260121d, options);
                            options.inJustDecodeBounds = false;
                            options.inPreferredConfig = Bitmap.Config.RGB_565;
                            VipProfileCardPreviewActivity vipProfileCardPreviewActivity = VipProfileCardPreviewActivity.this;
                            options.inSampleSize = vipProfileCardPreviewActivity.calculateInSampleSize(options, vipProfileCardPreviewActivity.f260100l1, vipProfileCardPreviewActivity.f260099k1);
                            bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(this.f260121d)));
                        } catch (Exception e18) {
                            bufferedInputStream = null;
                            e17 = e18;
                        } catch (OutOfMemoryError e19) {
                            bufferedInputStream = null;
                            e16 = e19;
                        } catch (Throwable th5) {
                            th = th5;
                            if (0 != 0) {
                                try {
                                    bufferedInputStream2.close();
                                } catch (Exception e26) {
                                    QLog.e("ProfileCard.VipProfileCardPreviewActivity", 1, "doInitBackgroundImage close bis error, ", e26);
                                }
                            }
                            throw th;
                        }
                        try {
                            decodeStream = BitmapFactory.decodeStream(bufferedInputStream, null, options);
                        } catch (Exception e27) {
                            e17 = e27;
                            if (QLog.isColorLevel()) {
                                QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "Exception when init background:" + e17.getMessage());
                            }
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            return;
                        } catch (OutOfMemoryError e28) {
                            e16 = e28;
                            if (QLog.isColorLevel()) {
                                QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "OutOfMemoryError" + e16.getMessage());
                            }
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            return;
                        }
                    } catch (Exception e29) {
                        QLog.e("ProfileCard.VipProfileCardPreviewActivity", 1, "doInitBackgroundImage close bis error, ", e29);
                    }
                    if (decodeStream == null) {
                        try {
                            bufferedInputStream.close();
                            return;
                        } catch (Exception e36) {
                            QLog.e("ProfileCard.VipProfileCardPreviewActivity", 1, "doInitBackgroundImage close bis error, ", e36);
                            return;
                        }
                    }
                    int height = decodeStream.getHeight();
                    int width = decodeStream.getWidth();
                    VipProfileCardPreviewActivity vipProfileCardPreviewActivity2 = VipProfileCardPreviewActivity.this;
                    float f16 = vipProfileCardPreviewActivity2.f260061u0 / vipProfileCardPreviewActivity2.f260060t0;
                    int min = Math.min(width, (int) (height * f16));
                    int i3 = (int) (min / f16);
                    if (QLog.isColorLevel()) {
                        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "image info imageWidth=" + min + ",imageHeight=" + i3 + ", sampleSize = " + options.inSampleSize);
                    }
                    if (width != min || height != i3) {
                        Bitmap createBitmap = Bitmap.createBitmap(decodeStream, 0, 0, min, i3);
                        decodeStream.recycle();
                        if (QLog.isColorLevel()) {
                            QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "Background size not match screen size, create a new one to resize");
                        }
                        decodeStream = createBitmap;
                    }
                    if (decodeStream != null) {
                        int q16 = Utils.q(decodeStream);
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(resources, decodeStream);
                        bitmapDrawable.setTargetDensity(resources.getDisplayMetrics());
                        String str3 = this.f260122e;
                        if (str3 != null) {
                            ImageCacheHelper.f98636a.i(str3, new com.tencent.cache.api.g(bitmapDrawable.getConstantState(), q16), Business.AIO);
                        }
                        VipProfileCardPreviewActivity.this.I0 = bitmapDrawable;
                    }
                    VipProfileCardPreviewActivity vipProfileCardPreviewActivity3 = VipProfileCardPreviewActivity.this;
                    if (vipProfileCardPreviewActivity3.I0 != null && (handler = vipProfileCardPreviewActivity3.f260066z0) != null) {
                        handler.sendEmptyMessage(27);
                    }
                    bufferedInputStream.close();
                } catch (Throwable th6) {
                    th = th6;
                }
            }
        }, 8, null, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x007f A[Catch: all -> 0x00af, TRY_LEAVE, TryCatch #8 {all -> 0x00af, blocks: (B:57:0x0055, B:12:0x0079, B:14:0x007f), top: B:3:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a6 A[Catch: Exception -> 0x0061, TRY_ENTER, TryCatch #12 {Exception -> 0x0061, blocks: (B:60:0x0059, B:16:0x00a6, B:18:0x00ab), top: B:3:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00ab A[Catch: Exception -> 0x0061, TRY_LEAVE, TryCatch #12 {Exception -> 0x0061, blocks: (B:60:0x0059, B:16:0x00a6, B:18:0x00ab), top: B:3:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b9 A[Catch: all -> 0x00e8, TryCatch #2 {all -> 0x00e8, blocks: (B:24:0x00b3, B:26:0x00b9, B:27:0x00d1), top: B:23:0x00b3 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00dd A[Catch: Exception -> 0x00d9, TRY_LEAVE, TryCatch #10 {Exception -> 0x00d9, blocks: (B:35:0x00d5, B:30:0x00dd), top: B:34:0x00d5 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f3 A[Catch: Exception -> 0x00ef, TRY_LEAVE, TryCatch #0 {Exception -> 0x00ef, blocks: (B:52:0x00eb, B:45:0x00f3), top: B:51:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.graphics.Bitmap$Config] */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.io.BufferedInputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    Bitmap f3(String str, boolean z16) {
        Bitmap bitmap;
        BufferedInputStream bufferedInputStream;
        BitmapFactory.Options options;
        int i3 = 1;
        ?? r46 = Bitmap.Config.ARGB_8888;
        while (true) {
            bitmap = null;
            bitmap = null;
            bitmap = null;
            r8 = null;
            BufferedInputStream bufferedInputStream2 = null;
            bitmap = null;
            try {
                try {
                    if (i3 > 2) {
                        break;
                    }
                    try {
                        options = new BitmapFactory.Options();
                        options.inPreferredConfig = r46;
                        int i16 = this.f260063w0;
                        options.inDensity = i16;
                        options.inTargetDensity = i16;
                        options.inScreenDensity = i16;
                        r46 = new BufferedInputStream(new FileInputStream(new File(str)));
                        if (z16) {
                            try {
                                options.inJustDecodeBounds = true;
                                BitmapFactory.decodeStream(r46, null, options);
                                options.inSampleSize = calculateInSampleSize(options, this.f260100l1, this.f260099k1);
                            } catch (Exception e16) {
                                e = e16;
                                bufferedInputStream = null;
                                if (QLog.isColorLevel()) {
                                    QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "getFrameBitmap oom path = " + str + ", msg = " + e.getMessage() + ", try count : " + i3);
                                }
                                if (r46 != 0) {
                                    r46.close();
                                }
                                if (bufferedInputStream != null) {
                                    bufferedInputStream.close();
                                }
                                return bitmap;
                            } catch (OutOfMemoryError unused) {
                                bufferedInputStream = null;
                                bufferedInputStream2 = r46;
                                try {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "getFrameBitmap oom path = " + str + ", try count : " + i3);
                                    }
                                    Bitmap.Config config = Bitmap.Config.ARGB_4444;
                                    if (bufferedInputStream2 != null) {
                                        try {
                                            bufferedInputStream2.close();
                                        } catch (Exception e17) {
                                            QLog.e("ProfileCard.VipProfileCardPreviewActivity", 1, "getFrameBitmap close bis error, ", e17);
                                        }
                                    }
                                    if (bufferedInputStream == null) {
                                        bufferedInputStream.close();
                                    }
                                    i3++;
                                    r46 = config;
                                } catch (Throwable th5) {
                                    th = th5;
                                    if (bufferedInputStream2 != null) {
                                        try {
                                            bufferedInputStream2.close();
                                        } catch (Exception e18) {
                                            QLog.e("ProfileCard.VipProfileCardPreviewActivity", 1, "getFrameBitmap close bis error, ", e18);
                                            throw th;
                                        }
                                    }
                                    if (bufferedInputStream != null) {
                                        bufferedInputStream.close();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                bufferedInputStream = null;
                                bufferedInputStream2 = r46;
                                if (bufferedInputStream2 != null) {
                                }
                                if (bufferedInputStream != null) {
                                }
                                throw th;
                            }
                        }
                        options.inJustDecodeBounds = false;
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(str)));
                    } catch (Exception e19) {
                        e = e19;
                        r46 = 0;
                        bufferedInputStream = null;
                    } catch (OutOfMemoryError unused2) {
                        bufferedInputStream = null;
                    } catch (Throwable th7) {
                        th = th7;
                        bufferedInputStream = null;
                        if (bufferedInputStream2 != null) {
                        }
                        if (bufferedInputStream != null) {
                        }
                        throw th;
                    }
                    try {
                        bitmap = BitmapFactory.decodeStream(bufferedInputStream, null, options);
                        r46.close();
                        bufferedInputStream.close();
                        break;
                    } catch (Exception e26) {
                        e = e26;
                        if (QLog.isColorLevel()) {
                        }
                        if (r46 != 0) {
                        }
                        if (bufferedInputStream != null) {
                        }
                        return bitmap;
                    } catch (OutOfMemoryError unused3) {
                        bufferedInputStream2 = r46;
                        if (QLog.isColorLevel()) {
                        }
                        Bitmap.Config config2 = Bitmap.Config.ARGB_4444;
                        if (bufferedInputStream2 != null) {
                        }
                        if (bufferedInputStream == null) {
                        }
                        i3++;
                        r46 = config2;
                    }
                    i3++;
                    r46 = config2;
                } catch (Exception e27) {
                    QLog.e("ProfileCard.VipProfileCardPreviewActivity", 1, "getFrameBitmap close bis error, ", e27);
                }
            } catch (Throwable th8) {
                th = th8;
            }
        }
        return bitmap;
    }

    public List<String> g3(g gVar) {
        ProfileCardTemplate profileCardTemplate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this, (Object) gVar);
        }
        ArrayList arrayList = new ArrayList();
        if (gVar != null && (profileCardTemplate = gVar.f260159a) != null) {
            if (this.f260058r0 == 1) {
                arrayList.add(profileCardTemplate.imageWhiteSmall);
            } else {
                arrayList.add(profileCardTemplate.imageBlackSmall);
            }
            ProfileCardTemplate profileCardTemplate2 = gVar.f260159a;
            if (profileCardTemplate2.animation == 2) {
                if (this.f260058r0 == 1) {
                    arrayList.add(profileCardTemplate2.frameWhiteSmall);
                } else {
                    arrayList.add(profileCardTemplate2.frameBlackSmall);
                }
            }
        }
        return arrayList;
    }

    public void h3(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            String u16 = ProfileCardUtil.u(str);
            File file = new File(u16);
            if (file.isFile() && file.exists()) {
                String str2 = "profilecard_preview:" + u16;
                Object g16 = ImageCacheHelper.f98636a.g(str2);
                if (g16 instanceof com.tencent.cache.api.g) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "get image form sImageCache filePath=" + u16);
                    }
                    this.I0 = ((Drawable.ConstantState) ((com.tencent.cache.api.g) g16).b()).newDrawable();
                    return;
                }
                e3(u16, str2);
            }
        }
    }

    public void i3(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
            return;
        }
        List<g> list = this.f260097i1;
        if (list != null && i3 >= 0 && i3 < list.size() && this.f260097i1.get(i3) != null) {
            ProfileCardTemplate profileCardTemplate = this.f260097i1.get(i3).f260159a;
            if (profileCardTemplate.styleId == ProfileCardTemplate.PROFILE_CARD_STYLE_DIY) {
                this.N0.setText(R.string.d3j);
                this.f260102n1 = "3";
                return;
            }
            I2(profileCardTemplate, this.J0, false);
            int i16 = this.f260044d0;
            if (i16 == 4) {
                this.N0.setText(R.string.d3r);
                this.f260102n1 = "2";
            } else if (i16 == 2) {
                this.N0.setText(R.string.d3s);
                this.f260102n1 = "1";
            } else {
                this.N0.setText(R.string.d3m);
                this.f260102n1 = "0";
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        return false;
    }

    public void j3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        List<g> list = this.f260097i1;
        if (list != null && list.size() > 0) {
            int i3 = this.f260091c1;
            if (i3 != -1) {
                A3(this.f260091c1, this.f260097i1.get(i3));
            }
            for (int i16 = 0; i16 < this.f260097i1.size(); i16++) {
                int i17 = this.f260091c1;
                if (i17 == -1 || i16 != i17) {
                    A3(i16, this.f260097i1.get(i16));
                }
            }
        }
    }

    public void l3() {
        long[] jArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        P2();
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("preview")) {
                this.f260103o1 = 0;
                String stringExtra = intent.getStringExtra("preview");
                if (QLog.isColorLevel()) {
                    QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "initStyleAndBg preview = " + stringExtra);
                }
                try {
                    JSONObject jSONObject = new JSONObject(stringExtra);
                    if (jSONObject.has(MttLoader.ENTRY_ID)) {
                        this.f260055o0 = jSONObject.getInt(MttLoader.ENTRY_ID);
                    }
                    JSONObject jSONObject2 = jSONObject.getJSONObject(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME);
                    d dVar = new d();
                    this.J0 = dVar;
                    dVar.f260137a = jSONObject2.optInt("id");
                    this.J0.f260138b = jSONObject2.optString("name");
                    this.J0.f260139c = jSONObject2.optInt("type");
                    this.J0.f260140d = jSONObject2.optString("image_url");
                    this.J0.f260141e = jSONObject2.optString(FacadeCacheData.THUMB_URL);
                    this.J0.f260142f = jSONObject2.optInt(WinkDaTongReportConstant.ElementParamValue.XSJ_OPERATION_TYPE_AUTH);
                    this.J0.f260143g = jSONObject2.optInt("limitefree_type");
                    this.J0.f260144h = jSONObject2.optInt("limitefree_btime");
                    this.J0.f260145i = jSONObject2.optInt("limitefree_etime");
                    this.J0.f260151o = jSONObject2.optInt("color");
                    this.J0.f260146j = jSONObject2.optInt("tag");
                    this.J0.f260147k = jSONObject2.optInt("tag_btime");
                    this.J0.f260148l = jSONObject2.optInt("tag_etime");
                    this.J0.f260149m = jSONObject2.optInt("background_btime");
                    this.J0.f260150n = jSONObject2.optInt("background_etime");
                    d dVar2 = this.J0;
                    this.f260058r0 = dVar2.f260151o;
                    S2(dVar2);
                    this.f260095g1 = jSONObject2.optInt("style");
                    if (this.J0.f260137a == 160) {
                        this.f260095g1 = 1L;
                        jArr = Y2();
                    } else {
                        JSONArray jSONArray = jSONObject2.getJSONArray("style_list");
                        long[] jArr2 = new long[jSONArray.length()];
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            jArr2[i3] = jSONArray.getLong(i3);
                        }
                        jArr = jArr2;
                    }
                    n3(jArr);
                    h3(this.J0.f260140d);
                    return;
                } catch (JSONException unused) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "initStyleAndBg JSONException json = " + stringExtra);
                        return;
                    }
                    return;
                }
            }
            if (intent.hasExtra("custom_card_background")) {
                this.f260103o1 = 1;
                this.f260104p1 = intent.getStringExtra("custom_card_background");
                d dVar3 = new d();
                this.J0 = dVar3;
                dVar3.f260137a = 160;
                this.f260095g1 = 1L;
                n3(Y2());
                e3(this.f260104p1, null);
            }
        }
    }

    void n3(long[] jArr) {
        int i3 = 0;
        if (jArr != null) {
            while (i3 < jArr.length) {
                this.f260096h1.add(Long.valueOf(jArr[i3]));
                i3++;
            }
            i3 = 0;
            boolean z16 = false;
            for (int i16 = 0; i16 < this.f260096h1.size(); i16++) {
                long longValue = this.f260096h1.get(i16).longValue();
                if (longValue == this.f260054n0) {
                    this.f260091c1 = i16;
                    i3 = 1;
                    z16 = true;
                } else if (longValue == this.f260095g1) {
                    if (!z16) {
                        this.f260091c1 = i16;
                    }
                    i3 = 1;
                }
            }
        }
        if (i3 == 0 && this.f260096h1.size() > 0) {
            this.f260096h1.add(Long.valueOf(this.f260095g1));
            if (this.f260091c1 == -1) {
                this.f260091c1 = this.f260096h1.size() - 1;
            }
        }
        if (this.f260091c1 == -1) {
            this.f260091c1 = 0;
            this.f260092d1 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "initStyleAndBg mWebStyleList = " + this.f260096h1.toString() + ", mCurrentStyleId = " + this.f260054n0 + ", mWebStyleId = " + this.f260095g1 + ", mCurrentViewPos = " + this.f260091c1 + ", mStyleListNull = " + this.f260092d1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        QQAppInterface qQAppInterface = this.app;
        ReportController.o(qQAppInterface, "CliOper", "", "", "card_mall", "0X8004C28", 0, 0, "", "", "", ff.h(qQAppInterface, qQAppInterface.getCurrentAccountUin()));
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        List<g> list;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) view);
        } else if (view.getId() == R.id.fcw && this.L0 != null && (list = this.f260097i1) != null && list.size() > 0) {
            int i3 = this.f260103o1;
            if (i3 == 0) {
                g gVar = this.f260097i1.get(this.L0.getCurrentItem());
                QQAppInterface qQAppInterface = this.app;
                String str = this.f260102n1;
                String l3 = Long.toString(gVar.f260159a.styleId);
                QQAppInterface qQAppInterface2 = this.app;
                ReportController.o(qQAppInterface, "CliOper", "", "", "card_mall", "0X8004C27", 0, 0, str, l3, "", ff.h(qQAppInterface2, qQAppInterface2.getCurrentAccountUin()));
                if (I2(gVar.f260159a, this.J0, true)) {
                    int i16 = this.J0.f260137a;
                    if (i16 != 160) {
                        U2(gVar.f260159a.styleId, i16);
                    } else {
                        long d36 = d3();
                        d dVar = this.J0;
                        V2(d36, dVar.f260137a, dVar.f260140d, dVar.f260151o);
                    }
                }
            } else if (i3 == 1) {
                QQAppInterface qQAppInterface3 = this.app;
                ReportController.o(qQAppInterface3, "CliOper", "", "", "card_mall", "0X8004C27", 0, 0, this.f260102n1, "-1", "", ff.h(qQAppInterface3, qQAppInterface3.getCurrentAccountUin()));
                ProfileCardUtil.t0(this.f260104p1, 100, 0.5633803f);
                if (!TextUtils.isEmpty(this.f260110v1.get(this.f260104p1))) {
                    String str2 = this.f260104p1;
                    x3(str2, this.f260110v1.get(str2));
                } else {
                    E3(this.f260104p1);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.profile.VipProfileCardBaseActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    public void p3() {
        ArrayList arrayList;
        List<g> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "initTemplateListData start.");
        }
        if (this.f260097i1 != null && this.f260096h1 != null) {
            ArrayList<ProfileCardTemplate> J2 = J2();
            if (this.f260095g1 == 0) {
                ProfileCardTemplate profileCardTemplate = new ProfileCardTemplate();
                profileCardTemplate.styleId = 0L;
                profileCardTemplate.imageWhiteMin = "https://imgcache.gtimg.cn/club/mobile/profile/template/default_v_53.jpg";
                profileCardTemplate.imageBlackMin = "https://imgcache.gtimg.cn/club/mobile/profile/template/default_v_53.jpg";
                profileCardTemplate.imageWhiteSmall = "https://imgcache.gtimg.cn/club/mobile/profile/template/default_v_53.jpg";
                profileCardTemplate.imageBlackSmall = "https://imgcache.gtimg.cn/club/mobile/profile/template/default_v_53.jpg";
                profileCardTemplate.auth = "0";
                profileCardTemplate.name = getString(R.string.d3b);
                J2.add(profileCardTemplate);
            }
            if (J2 != null && J2.size() > 0) {
                arrayList = new ArrayList();
                if (this.f260092d1) {
                    for (int i3 = 0; i3 < J2.size(); i3++) {
                        ProfileCardTemplate profileCardTemplate2 = J2.get(i3);
                        long j3 = this.f260054n0;
                        long j16 = profileCardTemplate2.styleId;
                        if (j3 == j16) {
                            this.f260091c1 = i3;
                        }
                        this.f260096h1.add(Long.valueOf(j16));
                    }
                }
                int i16 = 0;
                while (i16 < this.f260096h1.size()) {
                    boolean z16 = false;
                    for (int i17 = 0; i17 < J2.size(); i17++) {
                        ProfileCardTemplate profileCardTemplate3 = J2.get(i17);
                        if (this.f260096h1.get(i16).longValue() == profileCardTemplate3.styleId) {
                            g gVar = new g();
                            gVar.f260159a = profileCardTemplate3;
                            if (r3(gVar)) {
                                gVar.f260160b = 2;
                            } else {
                                gVar.f260160b = 0;
                            }
                            T2(gVar.f260159a);
                            arrayList.add(gVar);
                            z16 = true;
                        }
                    }
                    if (!z16) {
                        this.f260096h1.remove(i16);
                        int i18 = this.f260091c1;
                        if (i18 > 0 && i16 <= i18) {
                            this.f260091c1 = i18 - 1;
                        }
                        i16--;
                    }
                    i16++;
                }
            } else {
                arrayList = null;
            }
            if (J2 != null && J2.size() > 0) {
                if (arrayList != null && arrayList.size() > 0) {
                    if (!this.f260106r1 && (list = this.f260097i1) != null) {
                        list.clear();
                    }
                    List<g> list2 = this.f260097i1;
                    if (list2 == null) {
                        return;
                    }
                    list2.addAll(arrayList);
                    this.f260105q1 = true;
                    if (QLog.isColorLevel()) {
                        for (int i19 = 0; i19 < this.f260097i1.size(); i19++) {
                            if (QLog.isColorLevel()) {
                                QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "initTemplateListData, style : " + this.f260097i1.get(i19).f260159a.styleId + ", status : " + this.f260097i1.get(i19).f260160b + ", position : " + i19);
                            }
                        }
                    }
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i26 = 0; i26 < J2.size(); i26++) {
                        g gVar2 = new g();
                        gVar2.f260159a = J2.get(i26);
                        if (r3(gVar2)) {
                            gVar2.f260160b = 2;
                        } else {
                            gVar2.f260160b = 0;
                        }
                        T2(gVar2.f260159a);
                        if (gVar2.f260159a.styleId != ProfileCardTemplate.PROFILE_CARD_STYLE_SHOPPING) {
                            arrayList2.add(gVar2);
                        }
                    }
                    List<g> list3 = this.f260097i1;
                    if (list3 == null) {
                        return;
                    }
                    list3.clear();
                    this.f260097i1.addAll(arrayList2);
                    this.f260105q1 = true;
                }
            }
            this.f260066z0.sendEmptyMessage(1);
        }
    }

    public boolean r3(g gVar) {
        List<String> g36;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) gVar)).booleanValue();
        }
        if (gVar == null || gVar.f260159a == null || (g36 = g3(gVar)) == null || g36.size() == 0) {
            return false;
        }
        Iterator<String> it = g36.iterator();
        while (it.hasNext()) {
            if (!ProfileCardUtil.M(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:78:0x01a2 -> B:56:0x01f5). Please report as a decompilation issue!!! */
    public void t3(c.a aVar, g gVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, aVar, gVar, Integer.valueOf(i3));
            return;
        }
        if (r3(gVar)) {
            gVar.f260160b = 2;
            if (QLog.isColorLevel()) {
                QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "loadImageDrawable pos = " + i3 + " info exist");
            }
            List<String> g36 = g3(gVar);
            if (g36 != null && g36.size() != 0) {
                if (gVar.f260159a.styleId == ProfileCardTemplate.PROFILE_CARD_STYLE_DIY) {
                    SparseArray<String> sparseArray = com.tencent.mobileqq.profile.diy.b.f260153a;
                    if (sparseArray != null && sparseArray.size() > 0) {
                        com.tencent.mobileqq.profile.diy.b.f260153a.keyAt(0);
                    } else {
                        com.tencent.mobileqq.profile.diy.b.a(this.app);
                    }
                    int i16 = getResources().getDisplayMetrics().widthPixels;
                }
                int i17 = gVar.f260159a.animation;
                if (i17 != 0) {
                    BufferedInputStream bufferedInputStream = null;
                    if (i17 != 1) {
                        if (i17 == 2) {
                            aVar.f260129a.setIsScroll(false);
                            if (g36.size() > 1 && !TextUtils.isEmpty(g36.get(0)) && !TextUtils.isEmpty(g36.get(1))) {
                                String str = g36.get(0) + g36.get(1);
                                Object g16 = ImageCacheHelper.f98636a.g(str);
                                if (g16 instanceof com.tencent.cache.api.g) {
                                    aVar.f260129a.setImageDrawable((Drawable) ((com.tencent.cache.api.g) g16).b());
                                    aVar.f260129a.setTag(Integer.valueOf(i3));
                                    if (this.f260091c1 == i3) {
                                        z3(i3);
                                        return;
                                    }
                                    return;
                                }
                                ThreadManagerV2.post(new Runnable(g36, str, i3) { // from class: com.tencent.mobileqq.profile.VipProfileCardPreviewActivity.6
                                    static IPatchRedirector $redirector_;

                                    /* renamed from: d, reason: collision with root package name */
                                    final /* synthetic */ List f260118d;

                                    /* renamed from: e, reason: collision with root package name */
                                    final /* synthetic */ String f260119e;

                                    /* renamed from: f, reason: collision with root package name */
                                    final /* synthetic */ int f260120f;

                                    {
                                        this.f260118d = g36;
                                        this.f260119e = str;
                                        this.f260120f = i3;
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                            iPatchRedirector2.redirect((short) 1, this, VipProfileCardPreviewActivity.this, g36, str, Integer.valueOf(i3));
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        TransitionDrawable transitionDrawable;
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                            iPatchRedirector2.redirect((short) 2, (Object) this);
                                            return;
                                        }
                                        long elapsedRealtime = SystemClock.elapsedRealtime();
                                        Bitmap f36 = VipProfileCardPreviewActivity.this.f3(ProfileCardUtil.u((String) this.f260118d.get(1)), true);
                                        Bitmap f37 = VipProfileCardPreviewActivity.this.f3(ProfileCardUtil.u((String) this.f260118d.get(0)), true);
                                        if (QLog.isColorLevel()) {
                                            QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "ANIMATION_SCROLL time " + (SystemClock.elapsedRealtime() - elapsedRealtime));
                                        }
                                        if (f36 != null && f37 != null) {
                                            transitionDrawable = new TransitionDrawable(new Drawable[]{new BitmapDrawable(VipProfileCardPreviewActivity.this.getResources(), f37), new BitmapDrawable(VipProfileCardPreviewActivity.this.getResources(), f36)});
                                        } else {
                                            transitionDrawable = null;
                                        }
                                        if (transitionDrawable != null) {
                                            ImageCacheHelper.f98636a.i(this.f260119e, new com.tencent.cache.api.g(transitionDrawable, Utils.q(f36) + Utils.q(f37)), Business.AIO);
                                            Message obtainMessage = VipProfileCardPreviewActivity.this.f260066z0.obtainMessage();
                                            obtainMessage.what = 29;
                                            obtainMessage.arg1 = this.f260120f;
                                            VipProfileCardPreviewActivity.this.f260066z0.sendMessage(obtainMessage);
                                        }
                                    }
                                }, 8, null, true);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    aVar.f260129a.setIsScroll(true);
                    String u16 = ProfileCardUtil.u(g36.get(0));
                    try {
                    } catch (Exception e16) {
                        QLog.e("ProfileCard.VipProfileCardPreviewActivity", 1, "loadImageDrawable fail: ", e16);
                    }
                    try {
                        try {
                            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(new File(u16)));
                            try {
                                BitmapFactory.Options options = new BitmapFactory.Options();
                                options.inJustDecodeBounds = true;
                                int i18 = this.f260063w0;
                                options.inDensity = i18;
                                options.inTargetDensity = i18;
                                options.inScreenDensity = i18;
                                BitmapFactory.decodeStream(bufferedInputStream2, null, options);
                                int i19 = options.outWidth;
                                this.f260101m1 = this.f260099k1 - ((options.outHeight * this.f260100l1) / i19);
                                aVar.f260129a.setScaleType(ImageView.ScaleType.MATRIX);
                                Matrix matrix = new Matrix();
                                int i26 = this.f260100l1;
                                float f16 = i19;
                                matrix.postScale(i26 / f16, i26 / f16);
                                aVar.f260129a.setImageMatrix(matrix);
                                Drawable drawable = (Drawable) ImageCacheHelper.f98636a.g(u16);
                                if (drawable != null) {
                                    aVar.f260129a.setImageDrawable(drawable);
                                    aVar.f260129a.setTag(Integer.valueOf(i3));
                                    if (this.f260091c1 == i3) {
                                        z3(i3);
                                    }
                                } else {
                                    ThreadManagerV2.post(new Runnable(u16, i3) { // from class: com.tencent.mobileqq.profile.VipProfileCardPreviewActivity.5
                                        static IPatchRedirector $redirector_;

                                        /* renamed from: d, reason: collision with root package name */
                                        final /* synthetic */ String f260116d;

                                        /* renamed from: e, reason: collision with root package name */
                                        final /* synthetic */ int f260117e;

                                        {
                                            this.f260116d = u16;
                                            this.f260117e = i3;
                                            IPatchRedirector iPatchRedirector2 = $redirector_;
                                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                                iPatchRedirector2.redirect((short) 1, this, VipProfileCardPreviewActivity.this, u16, Integer.valueOf(i3));
                                            }
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            IPatchRedirector iPatchRedirector2 = $redirector_;
                                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                                return;
                                            }
                                            Bitmap f36 = VipProfileCardPreviewActivity.this.f3(this.f260116d, false);
                                            if (f36 != null) {
                                                ImageCacheHelper.f98636a.i(this.f260116d, new BitmapDrawable(VipProfileCardPreviewActivity.this.getResources(), f36), Business.AIO);
                                                Message obtainMessage = VipProfileCardPreviewActivity.this.f260066z0.obtainMessage();
                                                obtainMessage.what = 28;
                                                obtainMessage.arg1 = this.f260117e;
                                                VipProfileCardPreviewActivity.this.f260066z0.sendMessage(obtainMessage);
                                            }
                                        }
                                    }, 8, null, true);
                                }
                                bufferedInputStream2.close();
                            } catch (Exception e17) {
                                e = e17;
                                bufferedInputStream = bufferedInputStream2;
                                QLog.e("ProfileCard.VipProfileCardPreviewActivity", 1, "loadImageDrawable fail: ", e);
                                if (bufferedInputStream != null) {
                                    bufferedInputStream.close();
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                bufferedInputStream = bufferedInputStream2;
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (Exception e18) {
                                        QLog.e("ProfileCard.VipProfileCardPreviewActivity", 1, "loadImageDrawable fail: ", e18);
                                    }
                                }
                                throw th;
                            }
                        } catch (Exception e19) {
                            e = e19;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } else {
                    aVar.f260129a.setIsScroll(false);
                    aVar.f260129a.setImageDrawable(URLDrawable.getDrawable("file://" + ProfileCardUtil.u(g36.get(0)), this.f260100l1, this.f260099k1, aVar.f260129a.getDrawable(), aVar.f260129a.getDrawable(), false));
                    aVar.f260129a.setTag(Integer.valueOf(i3));
                }
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "loadImageDrawable pos = " + i3 + " info not exist");
        }
    }

    void u3(String str, UpsImageUploadResult upsImageUploadResult) {
        if (QLog.isColorLevel()) {
            QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "url from UPS:" + upsImageUploadResult.url);
        }
        this.f260110v1.put(str, upsImageUploadResult.url);
        x3(str, upsImageUploadResult.url);
    }

    void v3() {
        if (!TextUtils.isEmpty(this.f260104p1)) {
            File file = new File(this.f260104p1);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    void w3(int i3) {
        View findViewById;
        VipScaledViewPager vipScaledViewPager = this.L0;
        if (vipScaledViewPager != null && this.f260097i1 != null && (findViewById = vipScaledViewPager.findViewById(i3)) != null && findViewById.getTag() != null) {
            t3((c.a) findViewById.getTag(), this.f260097i1.get(i3), i3);
        }
    }

    void x3(String str, String str2) {
        VasLogReporter.getProfileCard().reportHighest("setupCustomBg start");
        List<g> list = this.f260097i1;
        if (list != null && list.size() != 0) {
            d dVar = new d();
            dVar.f260137a = 160;
            ProfileCardTemplate profileCardTemplate = this.f260097i1.get(this.L0.getCurrentItem()).f260159a;
            if (profileCardTemplate != null && !this.f260111w1 && !isFinishing() && I2(profileCardTemplate, dVar, true)) {
                V2(d3(), 0L, str2, ProfileCardUtil.a(str));
                return;
            }
            return;
        }
        VasLogReporter.getProfileCard().reportHighest("setupCustomBg error 1");
    }

    void y3() {
        QQProgressDialog qQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
        this.f260041a0 = qQProgressDialog;
        qQProgressDialog.setCancelable(false);
        this.f260041a0.setMessage(R.string.f171203d43);
        try {
            this.f260041a0.show();
            this.f260066z0.sendEmptyMessageDelayed(25, 30000L);
        } catch (Exception unused) {
        }
    }

    public void z3(int i3) {
        List<g> list;
        View findViewById;
        c.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        int i16 = this.f260107s1;
        if (i16 != -1) {
            b3(i16);
            this.f260107s1 = -1;
        }
        if (this.L0 != null && (list = this.f260097i1) != null && i3 >= 0 && i3 < list.size() && (findViewById = this.L0.findViewById(i3)) != null && findViewById.getTag() != null && (aVar = (c.a) findViewById.getTag()) != null) {
            ProfileCardScrollImageView profileCardScrollImageView = aVar.f260129a;
            g gVar = this.f260097i1.get(i3);
            if (gVar == null || profileCardScrollImageView.getTag() == null) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "startAnimation pos = " + i3);
            }
            int i17 = gVar.f260159a.animation;
            if (i17 != 0) {
                if (i17 != 1) {
                    if (i17 == 2) {
                        if (QLog.isColorLevel()) {
                            QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "start ANIMATION_FADE_IN_OUT");
                        }
                        Drawable drawable = profileCardScrollImageView.getDrawable();
                        if (drawable instanceof TransitionDrawable) {
                            TransitionDrawable transitionDrawable = (TransitionDrawable) drawable;
                            transitionDrawable.setCrossFadeEnabled(true);
                            transitionDrawable.startTransition(1500);
                            Runnable runnable = new Runnable(transitionDrawable) { // from class: com.tencent.mobileqq.profile.VipProfileCardPreviewActivity.3
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ TransitionDrawable f260112d;

                                {
                                    this.f260112d = transitionDrawable;
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VipProfileCardPreviewActivity.this, (Object) transitionDrawable);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                        iPatchRedirector2.redirect((short) 2, (Object) this);
                                    } else {
                                        this.f260112d.reverseTransition(1500);
                                    }
                                }
                            };
                            this.K0 = runnable;
                            this.f260066z0.postDelayed(runnable, 2000L);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "start ANIMATION_SCROLL");
                }
                if (gVar.f260159a.styleId != ProfileCardTemplate.PROFILE_CARD_STYLE_DIY) {
                    profileCardScrollImageView.setScrollDuration(1500);
                    profileCardScrollImageView.c(this.f260101m1);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "no animation to start !");
            }
        }
    }
}
