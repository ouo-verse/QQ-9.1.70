package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.data.ExpiredPushBanner;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.widget.ADView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.CommonMMKVUtils;
import com.tencent.widget.AbsListView;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import mqq.app.AppRuntime;

@KeepClassConstructor
/* loaded from: classes10.dex */
public class PushBannerProcessor extends BaseBannerProcessor implements com.tencent.mobileqq.banner.processor.c, com.tencent.mobileqq.banner.processor.b, Handler.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    public static final int f185251i;

    /* renamed from: d, reason: collision with root package name */
    public boolean f185252d;

    /* renamed from: e, reason: collision with root package name */
    public float f185253e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f185254f;

    /* renamed from: h, reason: collision with root package name */
    public int f185255h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f185261d;

        a(QBaseActivity qBaseActivity) {
            this.f185261d = qBaseActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PushBannerProcessor.this, (Object) qBaseActivity);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                com.tencent.mobileqq.struct.a aVar = (com.tencent.mobileqq.struct.a) view.getTag();
                if (aVar != null) {
                    aVar.f290281m.q();
                    int i3 = 0;
                    try {
                        if (!TextUtils.isEmpty(aVar.f290269a)) {
                            i3 = Integer.parseInt(aVar.f290269a);
                        }
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                    ReportController.o(this.f185261d.getAppRuntime(), "dc00898", "", "", "0X80087C1", "0X80087C1", i3, 0, "", "", "", "");
                    com.tencent.mobileqq.config.g gVar = new com.tencent.mobileqq.config.g(this.f185261d.getApplicationContext(), ConfigServlet.f202907b);
                    gVar.c();
                    gVar.i();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69228);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            f185251i = com.tencent.mobileqq.banner.d.f200269v;
        }
    }

    public PushBannerProcessor(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity);
            return;
        }
        this.f185252d = false;
        this.f185253e = 0.0f;
        this.f185254f = false;
        this.handler = new com.tencent.mobileqq.utils.ad(Looper.getMainLooper(), this);
    }

    private boolean h(com.tencent.mobileqq.config.e eVar, int i3, View view) {
        boolean z16;
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            return false;
        }
        com.tencent.mobileqq.struct.a aVar = new com.tencent.mobileqq.struct.a(eVar.c(0, i3), eVar.i(0, i3), eVar.j(0, i3));
        aVar.f290282n = eVar.g(0, i3);
        aVar.f290283o = eVar.h(0, i3);
        boolean a16 = aVar.a(eVar.g(0, i3));
        String str = aVar.f290271c;
        if (str != null && str.contains("|")) {
            String str2 = aVar.f290271c;
            long parseLong = Long.parseLong(str2.substring(0, str2.indexOf("|")));
            String str3 = aVar.f290271c;
            if (!com.tencent.mobileqq.util.o.d(parseLong, Long.parseLong(str3.substring(str3.indexOf("|") + 1)))) {
                return false;
            }
        }
        if (a16 && !"".equals(aVar.f290279k)) {
            ax c16 = bi.c((QQAppInterface) baseActivity.getAppRuntime(), baseActivity, aVar.f290279k);
            aVar.f290281m = c16;
            if (c16 == null) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                Bitmap f16 = eVar.f(0, i3);
                if (QLog.isDevelopLevel()) {
                    QLog.i("PUSH BANNER", 4, "addPushBanner, bannerPic = " + f16);
                }
                if (f16 != null) {
                    FrameLayout frameLayout = (FrameLayout) baseActivity.getLayoutInflater().inflate(R.layout.f168435w7, (ViewGroup) null);
                    ImageView imageView = (ImageView) frameLayout.findViewById(R.id.f163962dv);
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    imageView.setImageBitmap(f16);
                    DisplayMetrics displayMetrics = baseActivity.getResources().getDisplayMetrics();
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
                    layoutParams.height = Math.max((int) (displayMetrics.density * 30.0f), Math.min((Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) * 68) / 320, (f16.getHeight() * Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels)) / f16.getWidth()));
                    imageView.setLayoutParams(layoutParams);
                    ImageView imageView2 = (ImageView) frameLayout.findViewById(R.id.f166559g62);
                    imageView2.setTag(aVar);
                    imageView2.setContentDescription(HardCodeUtil.qqStr(R.string.jw9));
                    imageView2.setOnClickListener(new a(baseActivity));
                    frameLayout.setTag(aVar);
                    ((ADView) view.findViewById(R.id.f164052ip)).b(frameLayout, i3);
                    view.setTag(R.id.f164052ip, aVar.f290269a);
                    return true;
                }
            }
        }
        return false;
    }

    private void k(Message message) {
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            return;
        }
        if (o()) {
            BannerManager.l().O(f185251i, 2, message);
            FrameHelperActivity.ji((BaseActivity) baseActivity);
        } else {
            BannerManager.l().O(f185251i, 0, null);
        }
    }

    private boolean l() {
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            return false;
        }
        return CommonMMKVUtils.fromSpAdapter("mobileQQ").getBoolean(AppConstants.Preferences.PUSH_BANNER_REVEIVE_NEW + baseActivity.getAppRuntime().getAccount(), false);
    }

    private void m() {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.recent.bannerprocessor.PushBannerProcessor.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PushBannerProcessor.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    QBaseActivity baseActivity = PushBannerProcessor.this.getBaseActivity();
                    if (baseActivity == null) {
                        return;
                    }
                    try {
                        QQAppInterface qQAppInterface = (QQAppInterface) baseActivity.getAppRuntime();
                        com.tencent.mobileqq.config.e config = qQAppInterface.getConfig(qQAppInterface.getCurrentAccountUin(), true);
                        if (QLog.isColorLevel()) {
                            QLog.i("PushBannerConfig", 2, String.format(Locale.getDefault(), "initConfig config: %s", config));
                        }
                        if (config != null) {
                            ((BaseBannerProcessor) PushBannerProcessor.this).handler.sendEmptyMessage(2000);
                            return;
                        }
                        return;
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                        return;
                    }
                }
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }, 5, null, false);
    }

    private boolean n() {
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            return false;
        }
        return CommonMMKVUtils.fromSpAdapter("mobileQQ").getBoolean(AppConstants.Preferences.PUSH_BANNER_DISPLAY + baseActivity.getAppRuntime().getAccount(), true);
    }

    private boolean p() {
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null || baseActivity.getResources().getConfiguration().orientation == 1) {
            return true;
        }
        return false;
    }

    private boolean q(View view) {
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            return false;
        }
        com.tencent.mobileqq.config.e config = ((QQAppInterface) baseActivity.getAppRuntime()).getConfig(baseActivity.getAppRuntime().getCurrentAccountUin(), false);
        if (config == null) {
            if (QLog.isColorLevel()) {
                QLog.i("PushBannerConfig", 2, "loadPushBanner");
            }
            m();
            return false;
        }
        int k3 = config.k(0);
        if (k3 > 0) {
            ((ADView) view.findViewById(R.id.f164052ip)).i();
            int i3 = 0;
            for (int i16 = 0; i16 < k3; i16++) {
                if (h(config, i16, view)) {
                    i3++;
                }
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("Q.recent.banner", 4, "loadPushBanner, addnum = " + i3);
            }
            if (i3 > 0) {
                u();
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.banner.processor.b
    public void c(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) appRuntime);
        } else {
            this.handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.c
    public void d(com.tencent.mobileqq.banner.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) aVar);
        } else if (aVar.f200241a == f185251i && this.f185252d) {
            aVar.f200243c.findViewById(R.id.g5z).getLayoutParams().height = 0;
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public int defaultTipsBarType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return super.defaultTipsBarType();
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return f185251i;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) message)).booleanValue();
        }
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            return true;
        }
        int i3 = message.what;
        if (i3 != 1000) {
            if (i3 != 4000) {
                switch (i3) {
                    case 2000:
                        k(message);
                        break;
                    case 2001:
                        s(message.getData().getFloat("height"));
                        break;
                    case 2002:
                        t(message.getData().getBoolean(NodeProps.VISIBLE));
                        break;
                    case 2003:
                        r(message.getData().getBoolean("isStoryShow"), message.getData().getFloat("nodeOffset"));
                        break;
                    case 2004:
                        j(message.arg1);
                        break;
                    case 2005:
                        if (this.f185255h == 0) {
                            this.f185255h = BaseAIOUtils.f(50.0f, baseActivity.getResources());
                            break;
                        }
                        break;
                }
            } else {
                j(message.arg1);
            }
        } else {
            try {
                if (QLog.isColorLevel()) {
                    QLog.d("PushBanner", 2, "checkAndClosePushBanner");
                }
                i();
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("PushBanner", 2, "checkAndClosePushBanner Exception:", e16);
                }
            }
        }
        return true;
    }

    public void i() {
        com.tencent.mobileqq.banner.a f16;
        View view;
        ADView aDView;
        ViewGroup f17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null && (f16 = BannerManager.l().f(f185251i)) != null && (view = f16.f200243c) != null && (f17 = (aDView = (ADView) view.findViewById(R.id.f164052ip)).f(0)) != null) {
            boolean z16 = false;
            for (int childCount = f17.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = f17.getChildAt(childCount);
                com.tencent.mobileqq.struct.a aVar = (com.tencent.mobileqq.struct.a) childAt.getTag();
                String str = aVar.f290271c;
                int indexOf = str.indexOf("|");
                if (!com.tencent.mobileqq.util.o.d(Long.parseLong(str.substring(0, indexOf)), Long.parseLong(str.substring(indexOf + 1)))) {
                    aDView.k(0, childCount, childAt);
                    com.tencent.mobileqq.config.e.f202867e.h(aVar.f290282n);
                    z16 = true;
                }
            }
            if (z16) {
                if (f17.getChildCount() == 0) {
                    CommonMMKVUtils.fromSpAdapter("mobileQQ").edit().putBoolean(AppConstants.Preferences.PUSH_BANNER_DISPLAY + baseActivity.getAppRuntime().getAccount(), false).commit();
                    aDView.i();
                    BannerManager.l().O(f185251i, 0, null);
                    this.f185254f = false;
                } else {
                    u();
                }
                com.tencent.mobileqq.config.g gVar = new com.tencent.mobileqq.config.g(baseActivity.getApplicationContext(), ConfigServlet.f202907b);
                gVar.c();
                gVar.i();
                return;
            }
            u();
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public View initBanner(com.tencent.mobileqq.banner.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        }
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            return null;
        }
        View inflate = baseActivity.getLayoutInflater().inflate(R.layout.f168434w6, (ViewGroup) null);
        inflate.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        inflate.findViewById(R.id.g5z).setVisibility(8);
        ((LinearLayout) inflate.findViewById(R.id.close)).setOnClickListener(new View.OnClickListener(baseActivity) { // from class: com.tencent.mobileqq.activity.recent.bannerprocessor.PushBannerProcessor.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ QBaseActivity f185256d;

            {
                this.f185256d = baseActivity;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PushBannerProcessor.this, (Object) baseActivity);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                View view2;
                ViewGroup viewGroup;
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    CommonMMKVUtils.fromSpAdapter("mobileQQ").edit().putBoolean(AppConstants.Preferences.PUSH_BANNER_DISPLAY + this.f185256d.getAppRuntime().getAccount(), false).commit();
                    com.tencent.mobileqq.banner.a f16 = BannerManager.l().f(PushBannerProcessor.f185251i);
                    if (f16 != null && (view2 = f16.f200243c) != null) {
                        ADView aDView = (ADView) view2.findViewById(R.id.f164052ip);
                        if (aDView != null) {
                            viewGroup = aDView.f(0);
                        } else {
                            viewGroup = null;
                        }
                        if (viewGroup != null) {
                            int childCount = viewGroup.getChildCount();
                            LinkedList linkedList = new LinkedList();
                            for (int i3 = 0; i3 < childCount; i3++) {
                                View childAt = viewGroup.getChildAt(i3);
                                if (childAt != null) {
                                    linkedList.add((com.tencent.mobileqq.struct.a) childAt.getTag());
                                }
                            }
                            ThreadManager.getFileThreadHandler().post(new Runnable(childCount, linkedList) { // from class: com.tencent.mobileqq.activity.recent.bannerprocessor.PushBannerProcessor.1.1
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ int f185258d;

                                /* renamed from: e, reason: collision with root package name */
                                final /* synthetic */ List f185259e;

                                {
                                    this.f185258d = childCount;
                                    this.f185259e = linkedList;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, this, AnonymousClass1.this, Integer.valueOf(childCount), linkedList);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    long j3;
                                    int size;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    EntityManager createEntityManager = AnonymousClass1.this.f185256d.getAppRuntime().getEntityManagerFactory().createEntityManager();
                                    List<? extends Entity> query = createEntityManager.query(ExpiredPushBanner.class, false, null, null, null, null, AEEditorConstants.VIDEO_CLIP_END_TIME, null);
                                    if (query != null && (query.size() + this.f185258d) - 10 > 0) {
                                        for (int i16 = 0; i16 < size; i16++) {
                                            createEntityManager.remove((ExpiredPushBanner) query.get(i16));
                                        }
                                    }
                                    for (int i17 = 0; i17 < this.f185259e.size(); i17++) {
                                        com.tencent.mobileqq.struct.a aVar2 = (com.tencent.mobileqq.struct.a) this.f185259e.get(i17);
                                        if (aVar2 != null) {
                                            String str = aVar2.f290271c;
                                            if (str != null && str.contains("|")) {
                                                String str2 = aVar2.f290271c;
                                                j3 = Long.parseLong(str2.substring(str2.indexOf("|") + 1));
                                            } else {
                                                j3 = 0;
                                            }
                                            ExpiredPushBanner expiredPushBanner = new ExpiredPushBanner();
                                            expiredPushBanner.cid = Long.parseLong(aVar2.f290269a);
                                            expiredPushBanner.md5 = aVar2.f290283o;
                                            expiredPushBanner.endtime = j3;
                                            createEntityManager.persist(expiredPushBanner);
                                        }
                                    }
                                }
                            });
                            if (aDView != null) {
                                aDView.i();
                            }
                        }
                    }
                    BannerManager.l().O(PushBannerProcessor.f185251i, 0, null);
                    PushBannerProcessor.this.f185254f = false;
                    ReportController.o(this.f185256d.getAppRuntime(), "dc00898", "", "", "0X80087C3", "0X80087C3", 0, 0, "", "", "", "");
                    ReportController.r(this.f185256d.getAppRuntime(), "dc00898", "", "", BaseBannerProcessor.TVALUE_CLICK_COMMON, BaseBannerProcessor.TVALUE_CLICK_COMMON, 12, 0, "", "", "", "");
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        return inflate;
    }

    public Object j(int i3) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
        com.tencent.mobileqq.banner.a f16 = BannerManager.l().f(f185251i);
        if (f16 != null && (view = f16.f200243c) != null) {
            if (i3 == 0) {
                return view.getTag();
            }
            return view.getTag(i3);
        }
        return null;
    }

    public boolean o() {
        View view;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        QBaseActivity baseActivity = getBaseActivity();
        boolean z17 = false;
        if (baseActivity == null) {
            return false;
        }
        boolean l3 = l();
        if (this.f185254f && !l3) {
            z17 = true;
        } else if (n()) {
            com.tencent.mobileqq.banner.a f16 = BannerManager.l().f(f185251i);
            if (f16 != null) {
                view = initBanner(f16);
            } else {
                view = null;
            }
            if (view != null) {
                z16 = q(view);
            } else {
                z16 = false;
            }
            if (z16) {
                view.findViewById(R.id.g5z).setVisibility(0);
                this.f185254f = true;
                CommonMMKVUtils.fromSpAdapter("mobileQQ").edit().putBoolean(AppConstants.Preferences.PUSH_BANNER_REVEIVE_NEW + baseActivity.getAppRuntime().getAccount(), false).commit();
            }
            z17 = z16;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("Q.recent.banner", 4, "isNeedShowPushBanner, isNeedShow = " + z17);
        }
        return z17;
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void onAccountChanged() {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.handler.removeMessages(1000);
        com.tencent.mobileqq.banner.a f16 = BannerManager.l().f(f185251i);
        if (f16 != null && (view = f16.f200243c) != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.f164053iq);
            ADView aDView = (ADView) f16.f200243c.findViewById(R.id.f164052ip);
            if (aDView != null) {
                aDView.d();
                aDView.i();
            }
            if (relativeLayout != null) {
                relativeLayout.setPadding(0, -1, 0, 0);
            }
        }
        this.f185254f = false;
    }

    @Override // com.tencent.mobileqq.banner.processor.b
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.b
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        }
    }

    public void r(boolean z16, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(z16), Float.valueOf(f16));
        } else {
            this.f185252d = z16;
            this.f185253e = f16;
        }
    }

    public void s(float f16) {
        com.tencent.mobileqq.banner.a f17;
        View view;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.recent.banner", 2, "fight.setPushBannerHeight:" + f16 + ",mIsStoryShow:" + this.f185252d);
        }
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null || (f17 = BannerManager.l().f(f185251i)) == null || (view = f17.f200243c) == null || !f17.f200244d) {
            return;
        }
        float f18 = 0.0f;
        if (f16 > 0.0f) {
            t(true);
            return;
        }
        if (view == null) {
            return;
        }
        int abs = (int) Math.abs(f16);
        View findViewById = view.findViewById(R.id.g5z);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        int i17 = this.f185255h;
        if (this.f185252d) {
            if (layoutParams.height == i17) {
                return;
            }
            if (f16 >= (-i17)) {
                if (f16 < -3.0f) {
                    i3 = i17 - abs;
                    f18 = i3 / i17;
                    i17 = i3;
                }
                f18 = 1.0f;
            }
            i17 = 0;
        } else {
            if (layoutParams.height == 0) {
                return;
            }
            findViewById.findViewById(R.id.close).setVisibility(4);
            float f19 = this.f185253e;
            float f26 = i17;
            if (f16 >= f19 - f26) {
                if (f16 < f19) {
                    i3 = (int) ((f16 + f26) - f19);
                    f18 = i3 / f26;
                    i17 = i3;
                } else {
                    i17 = this.f185255h;
                    f18 = 1.0f;
                }
            }
            i17 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.recent.banner", 2, "fight.setPushBannerHeight.lp.height = " + layoutParams.height + "height:" + i17 + ",alpha:" + f18);
        }
        if (layoutParams.height != i17) {
            if (i17 == 0) {
                Object j3 = j(R.id.f164052ip);
                if (j3 != null && (j3 instanceof String)) {
                    try {
                        i16 = Integer.parseInt((String) j3);
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
                ReportController.o(baseActivity.getAppRuntime(), "dc00898", "", "", "0X80094CD", "0X80094CD", i16, 0, "", "", "", "");
            }
            layoutParams.height = i17;
            findViewById.setAlpha(f18);
            findViewById.requestLayout();
        }
    }

    public void t(boolean z16) {
        QBaseActivity baseActivity;
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        com.tencent.mobileqq.banner.a f16 = BannerManager.l().f(f185251i);
        if (f16 == null || f16.f200243c == null || (baseActivity = getBaseActivity()) == null || !f16.f200244d || (view = f16.f200243c) == null) {
            return;
        }
        View findViewById = view.findViewById(R.id.g5z);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        if (QLog.isColorLevel()) {
            QLog.d("Q.recent.banner", 2, "fight.setPushBannerHeight.lp.height1 = " + layoutParams.height);
        }
        int i3 = 0;
        if (z16) {
            if (layoutParams.height != this.f185255h || findViewById.findViewById(R.id.close).getVisibility() != 0 || findViewById.getAlpha() != 1.0f) {
                findViewById.findViewById(R.id.close).setVisibility(0);
                findViewById.setAlpha(1.0f);
                layoutParams.height = this.f185255h;
                findViewById.requestLayout();
                Object j3 = j(R.id.f164052ip);
                if (j3 != null && (j3 instanceof String)) {
                    try {
                        i3 = Integer.parseInt((String) j3);
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
                ReportController.o(baseActivity.getAppRuntime(), "dc00898", "", "", "0X80087C2", "0X80087C2", i3, 0, "3", "", "", "");
                return;
            }
            return;
        }
        if (layoutParams.height != 0) {
            findViewById.findViewById(R.id.close).setVisibility(4);
            findViewById.setAlpha(0.0f);
            layoutParams.height = 0;
            findViewById.requestLayout();
            Object j16 = j(R.id.f164052ip);
            if (j16 != null && (j16 instanceof String)) {
                try {
                    i3 = Integer.parseInt((String) j16);
                } catch (Throwable th6) {
                    th6.printStackTrace();
                }
            }
            ReportController.o(baseActivity.getAppRuntime(), "dc00898", "", "", "0X80094CD", "0X80094CD", i3, 0, "", "", "", "");
        }
    }

    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        this.handler.removeMessages(1000);
        long currentTimeMillis = System.currentTimeMillis() - 10;
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, 1);
        calendar.set(11, 0);
        calendar.clear(12);
        calendar.clear(13);
        calendar.clear(14);
        long timeInMillis = (calendar.getTimeInMillis() - currentTimeMillis) + MiniBoxNoticeInfo.MIN_5;
        if (QLog.isColorLevel()) {
            QLog.d("PushBanner", 2, "Check banner delay: " + timeInMillis);
        }
        this.handler.sendEmptyMessageDelayed(1000, timeInMillis);
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void updateBanner(com.tencent.mobileqq.banner.a aVar, Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar, (Object) message);
            return;
        }
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            return;
        }
        aVar.f200243c.findViewById(R.id.g5z).setVisibility(0);
        RelativeLayout relativeLayout = (RelativeLayout) aVar.f200243c.findViewById(R.id.f164053iq);
        ADView aDView = (ADView) aVar.f200243c.findViewById(R.id.f164052ip);
        if (p()) {
            relativeLayout.setPadding(0, 0, 0, 0);
            aDView.c();
        } else {
            relativeLayout.setPadding(0, -1, 0, 0);
        }
        ReportController.r(baseActivity.getAppRuntime(), "dc00898", "", "", BaseBannerProcessor.TVALUE_SHOW_COMMON, BaseBannerProcessor.TVALUE_SHOW_COMMON, 12, 0, "", "", "", "");
    }
}
