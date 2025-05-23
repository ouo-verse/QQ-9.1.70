package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.aelight.camera.util.api.IQIMShortVideoUtil;
import com.tencent.av.app.DeviceCapabilityExamination;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.app.message.messageclean.ScanSpaceManager;
import com.tencent.mobileqq.ark.api.IArkHelper;
import com.tencent.mobileqq.emoticonview.anisticker.AniStickerLottie;
import com.tencent.mobileqq.listentogether.api.IListenTogetherApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.webview.api.IWebDataApi;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.CacheManager;
import com.tencent.util.VersionUtils;
import cooperation.qqfav.QfavHelper;
import cooperation.qzone.QZoneHelper;
import java.io.File;
import java.util.Vector;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes9.dex */
public class QQSettingMsgHistoryActivity extends IphoneTitleBarActivity implements ViewTreeObserver.OnGlobalLayoutListener, com.tencent.mobileqq.app.message.messageclean.ad {
    static IPatchRedirector $redirector_;
    private static volatile ScanSpaceManager A0;

    /* renamed from: z0, reason: collision with root package name */
    static final String f176912z0;

    /* renamed from: a0, reason: collision with root package name */
    private String f176913a0;

    /* renamed from: b0, reason: collision with root package name */
    private View f176914b0;

    /* renamed from: c0, reason: collision with root package name */
    private View f176915c0;

    /* renamed from: d0, reason: collision with root package name */
    private View f176916d0;

    /* renamed from: e0, reason: collision with root package name */
    private ProgressBar f176917e0;

    /* renamed from: f0, reason: collision with root package name */
    private TextView f176918f0;

    /* renamed from: g0, reason: collision with root package name */
    private View f176919g0;

    /* renamed from: h0, reason: collision with root package name */
    private View f176920h0;

    /* renamed from: i0, reason: collision with root package name */
    private View f176921i0;

    /* renamed from: j0, reason: collision with root package name */
    private View f176922j0;

    /* renamed from: k0, reason: collision with root package name */
    private View f176923k0;

    /* renamed from: l0, reason: collision with root package name */
    private View f176924l0;

    /* renamed from: m0, reason: collision with root package name */
    private TextView f176925m0;

    /* renamed from: n0, reason: collision with root package name */
    private TextView f176926n0;

    /* renamed from: o0, reason: collision with root package name */
    private int f176927o0;

    /* renamed from: p0, reason: collision with root package name */
    private int f176928p0;

    /* renamed from: q0, reason: collision with root package name */
    private int f176929q0;

    /* renamed from: r0, reason: collision with root package name */
    private int f176930r0;

    /* renamed from: s0, reason: collision with root package name */
    private BounceScrollView f176931s0;

    /* renamed from: t0, reason: collision with root package name */
    QQProgressDialog f176932t0;

    /* renamed from: u0, reason: collision with root package name */
    boolean f176933u0;

    /* renamed from: v0, reason: collision with root package name */
    private String f176934v0;

    /* renamed from: w0, reason: collision with root package name */
    private long f176935w0;

    /* renamed from: x0, reason: collision with root package name */
    private long f176936x0;

    /* renamed from: y0, reason: collision with root package name */
    private long f176937y0;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67402);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
            return;
        }
        f176912z0 = BaseApplication.getContext().getFilesDir() + File.separator + "ChatHistoryEventConfig.json";
    }

    public QQSettingMsgHistoryActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f176913a0 = "";
        this.f176933u0 = true;
        this.f176937y0 = 0L;
    }

    private static void G2(QQAppInterface qQAppInterface) {
        Manager manager = qQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER);
        if (manager == null || !(manager instanceof QZoneManagerImp)) {
            return;
        }
        ((QZoneManagerImp) manager).C = null;
    }

    public static void H2() {
        if (A0 != null) {
            A0.j();
            A0 = null;
        }
    }

    public static void I2(Activity activity, QQAppInterface qQAppInterface) {
        try {
            Intent intent = new Intent("qqplayer_exit_action");
            intent.putExtra("musicplayer.isDelFileOnDonwloadThreadOver", true);
            qQAppInterface.getApplication().getApplicationContext().sendBroadcast(intent);
            QZoneHelper.clearCache(qQAppInterface, false);
            G2(qQAppInterface);
            M2(qQAppInterface.getCurrentUin(), false);
            J2(qQAppInterface);
            L2();
            N2(qQAppInterface);
            com.tencent.mobileqq.utils.bu.a();
            ((IArkHelper) QRoute.api(IArkHelper.class)).cleanAppCache();
            ((IListenTogetherApi) QRoute.api(IListenTogetherApi.class)).removeAllCacheFiles();
            if (activity != null) {
                QfavHelper.d(activity, qQAppInterface.getCurrentAccountUin());
            }
            ((IPublicAccountJavascriptInterface) QRoute.api(IPublicAccountJavascriptInterface.class)).deleteAllH5Data(qQAppInterface);
            n0.a.g(new File(((IPublicAccountJavascriptInterface) QRoute.api(IPublicAccountJavascriptInterface.class)).getDataPath() + "/" + HexUtil.string2HexString(qQAppInterface.getAccount())));
            String e16 = com.tencent.biz.common.offline.c.e();
            if (e16 != null) {
                n0.a.g(new File(e16));
            }
            String f16 = com.tencent.biz.common.offline.c.f();
            if (f16 != null) {
                n0.a.g(new File(f16));
            }
            ((IWebDataApi) QRoute.api(IWebDataApi.class)).clearOfflineCache();
            String b16 = com.tencent.biz.common.offline.c.b();
            if (b16 != null) {
                n0.a.g(new File(b16));
            }
            try {
                n0.a.g(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MobileQQ/qbiz/"));
                n0.a.g(new File(BaseApplication.getContext().getFilesDir(), "qbiz"));
            } catch (Exception unused) {
            }
            n0.a.g(new File(BaseApplication.getContext().getFilesDir(), "WebOfflineRes"));
            qQAppInterface.getApplication().getSharedPreferences("OfflineWebResManager", 4).edit().clear().commit();
            com.tencent.mobileqq.webview.util.t.m("busi_html_offline_").f().a();
            n0.a.g(new File(AppConstants.SDCARD_GIFT_SAVE));
            File cacheFileBaseDir = CacheManager.getCacheFileBaseDir();
            if (cacheFileBaseDir != null) {
                n0.a.g(cacheFileBaseDir);
            }
            ShortVideoUtils.deleteDownloadTempFile();
            File file = new File(AppConstants.SDCARD_NEARBY_FLOWER);
            if (file.exists()) {
                n0.a.g(file);
            }
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(AppConstants.SDCARD_HOMEWORK_ATTACH);
            if (file2.exists()) {
                n0.a.g(file2);
            }
            File file3 = new File(AppConstants.SDCARD_TROOP_REWARD);
            if (file3.exists()) {
                n0.a.g(file3);
            }
            File file4 = new File(AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_PRELOAD);
            if (file4.exists()) {
                n0.a.g(file4);
            }
            File file5 = new File(AppConstants.SDCARD_PATH_READINJOY_TEMPLATE_VIDEO_PATH);
            if (file5.exists()) {
                n0.a.g(file5);
            }
            File file6 = new File(AppConstants.SDCARD_PATH + ".troop/nearby_video/");
            if (file6.exists()) {
                n0.a.g(file6);
            }
            File file7 = new File(AppConstants.SDCARD_AR_IMG);
            if (file7.exists()) {
                n0.a.g(file7);
            }
            File file8 = new File(AppConstants.SDCARD_AR_FEATURE);
            if (file8.exists()) {
                n0.a.g(file8);
            }
            File file9 = new File(AppConstants.SDCARD_AR_CONFIG);
            if (file9.exists()) {
                n0.a.g(file9);
            }
            File file10 = new File(AppConstants.SDCARD_AR_MODEL);
            if (file10.exists()) {
                n0.a.g(file10);
            }
            File file11 = new File(AppConstants.SDCARD_AR_RELATIONSHIP);
            if (file11.exists()) {
                n0.a.g(file11);
            }
            File file12 = new File(AppConstants.SDCARD_AR_TRANSFER);
            if (file12.exists()) {
                n0.a.g(file12);
            }
            File file13 = new File(AppConstants.SDCARD_AV);
            if (file13.exists()) {
                n0.a.g(file13);
            }
            File file14 = new File(DeviceCapabilityExamination.o());
            if (file14.exists()) {
                n0.a.g(file14);
            }
            File file15 = new File(AppConstants.SDCARD_NEARBY_PROFILE_NOW_VIDEO_DIR);
            if (file15.exists()) {
                n0.a.g(file15);
            }
            ((IVasQuickUpdateService) qQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "")).cleanCache();
            ((IStickerRecManager) qQAppInterface.getRuntimeService(IStickerRecManager.class)).deletePicCache();
            AniStickerLottie.clearCache();
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.d("AssitantSettingActivity", 2, "deleteOfflineData got exception:" + e17.getMessage());
            }
        }
    }

    static void J2(QQAppInterface qQAppInterface) {
        if (qQAppInterface.getApp() == null) {
            return;
        }
        BaseApplication.getContext().getPackageName();
        K2(Utils.w(BaseApplication.getContext()) + "thumbnails/");
    }

    private static void K2(String str) {
        File[] listFiles = new File(str).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                file.delete();
            }
        }
    }

    static void L2() {
        K2(AppConstants.SDCARD_PATH + "photo/");
    }

    public static void M2(String str, boolean z16) {
        int i3 = 0;
        while (true) {
            Vector<Integer> vector = CardHandler.F;
            if (i3 < vector.size()) {
                K2(CardHandler.E + vector.get(i3).intValue() + "/");
                i3++;
            } else {
                StringBuilder sb5 = new StringBuilder();
                String str2 = CardHandler.E;
                sb5.append(str2);
                sb5.append("background");
                sb5.append("/");
                K2(sb5.toString());
                K2(AppConstants.SDCARD_PATH + FaceUtil.IMG_TEMP + "/");
                K2(str2 + FaceUtil.IMG_TEMP + "/");
                K2(str2 + FaceUtil.PORTRAIT_HDAVATAR + "/");
                K2(AppConstants.PATH_CARD_QZONE);
                K2(str2 + "voice/");
                StringBuilder sb6 = new StringBuilder();
                sb6.append(com.tencent.gamecenter.common.util.a.J());
                sb6.append("/");
                K2(sb6.toString());
                K2(AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_SCREENSHOTS);
                K2(com.tencent.mobileqq.hotpic.b.f237006d);
                K2(com.tencent.mobileqq.scribble.e.a());
                return;
            }
        }
    }

    private static void N2(QQAppInterface qQAppInterface) {
        File file = URLDrawableHelper.diskCachePath;
        if (file != null) {
            K2(file.getAbsolutePath());
            if (qQAppInterface.getApp() instanceof BaseApplicationImpl) {
                ImageCacheHelper.f98636a.e();
            }
        }
    }

    private void P2() {
        this.f176914b0 = findViewById(R.id.bcm);
        this.f176915c0 = findViewById(R.id.f1b);
        this.f176917e0 = (ProgressBar) this.f176914b0.findViewById(R.id.igu);
        this.f176918f0 = (TextView) this.f176914b0.findViewById(R.id.bcn);
        this.f176934v0 = getResources().getString(R.string.f170653xj);
    }

    private void Q2() {
        View findViewById = findViewById(R.id.aw7);
        this.f176916d0 = findViewById;
        this.f176919g0 = findViewById.findViewById(R.id.f166633gt2);
        this.f176920h0 = this.f176916d0.findViewById(R.id.fmz);
        this.f176921i0 = this.f176916d0.findViewById(R.id.fm8);
        this.f176922j0 = this.f176916d0.findViewById(R.id.gmq);
        this.f176923k0 = this.f176916d0.findViewById(R.id.fm6);
        this.f176924l0 = this.f176916d0.findViewById(R.id.f166497fm4);
        this.f176925m0 = (TextView) this.f176916d0.findViewById(R.id.f166632gt1);
        this.f176926n0 = (TextView) this.f176916d0.findViewById(R.id.b7y);
        ((GradientDrawable) this.f176922j0.getBackground()).setColor(Color.parseColor("#00CAFC"));
        ((GradientDrawable) this.f176923k0.getBackground()).setColor(Color.parseColor("#FFCC00"));
        ((GradientDrawable) this.f176924l0.getBackground()).setColor(Color.parseColor("#EBEDF5"));
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.f159492al3);
        this.f176927o0 = dimensionPixelOffset;
        this.f176928p0 = dimensionPixelOffset / 8;
        int i3 = getResources().getDisplayMetrics().widthPixels;
        this.f176929q0 = i3;
        this.f176930r0 = (i3 - (this.f176927o0 * 2)) - (this.f176928p0 * 2);
    }

    private void R2(long j3) {
        long j16 = this.f176935w0 - j3;
        this.f176935w0 = j16;
        this.f176925m0.setText(com.tencent.mobileqq.app.message.messageclean.q.f(j16));
    }

    private void S2(int i3) {
        ProgressBar progressBar = this.f176917e0;
        if (progressBar != null) {
            progressBar.setProgress(i3);
        }
        TextView textView = this.f176918f0;
        if (textView != null) {
            textView.setText(String.format(this.f176934v0, i3 + "%"));
        }
    }

    private void T2() {
        if (A0 != null && A0.i()) {
            U2(A0.f196105e, A0.e(), A0.d(), A0.g());
            ((IQIMShortVideoUtil) QRoute.api(IQIMShortVideoUtil.class)).preLoadPeakProcess(this);
            if (VersionUtils.isGingerBread()) {
                this.f176931s0.setOverScrollMode(0);
                return;
            }
            return;
        }
        if (A0 != null) {
            A0.j();
        }
        A0 = new ScanSpaceManager();
        A0.m(this);
        A0.f();
    }

    private void U2(long j3, long j16, long j17, long j18) {
        String str;
        this.f176914b0.setVisibility(8);
        this.f176915c0.setVisibility(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f176919g0.getLayoutParams();
        int i3 = (int) ((j3 * 100) / j18);
        int min = (this.f176930r0 * Math.min(Math.max(i3, 2), 100)) / 100;
        layoutParams.width = min;
        this.f176919g0.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f176920h0.getLayoutParams();
        int min2 = (this.f176930r0 * Math.min(Math.max((int) ((j16 * 100) / j18), 1), 100)) / 100;
        layoutParams2.width = min2;
        this.f176920h0.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.f176921i0.getLayoutParams();
        int max = Math.max((this.f176930r0 - min) - min2, 0);
        layoutParams3.width = max;
        this.f176921i0.setLayoutParams(layoutParams3);
        if (i3 < 1) {
            str = "<1%";
        } else {
            str = i3 + "%";
        }
        this.f176926n0.setText(String.format(getString(R.string.f171488fc2), str));
        float baseNumber = FileUtils.getBaseNumber();
        this.f176925m0.setText(com.tencent.mobileqq.app.message.messageclean.q.g(j3, FileUtils.getBaseNumber()));
        this.f176935w0 = j3;
        QLog.d("QQSettingMsgHistoryActivity", 1, "showSpaceInfo qqSpaceLength: " + min + " phoneSpaceLength: " + min2 + " avaliableSpaceLength: " + max + " base: " + baseNumber);
    }

    private void V2() {
        Intent intent = getIntent();
        int i3 = 0;
        if (intent != null && intent.hasExtra("set_display_type")) {
            i3 = intent.getIntExtra("set_display_type", 0);
        }
        if (i3 == 2) {
            setTitle(R.string.hoa);
        } else {
            setTitle(R.string.fsb);
        }
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.ad
    public void B0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        ProgressBar progressBar = this.f176917e0;
        if (progressBar != null) {
            progressBar.setMax(100);
        }
        S2(0);
        this.f176914b0.setVisibility(0);
        this.f176915c0.setVisibility(8);
        if (VersionUtils.isGingerBread()) {
            this.f176931s0.setOverScrollMode(2);
        }
        this.f176936x0 = System.currentTimeMillis();
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.ad
    public void O1(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16));
        } else {
            S2((int) f16);
        }
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.ad
    public void U0(com.tencent.mobileqq.app.message.messageclean.be beVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, beVar, Boolean.valueOf(z16));
            return;
        }
        S2(100);
        U2(beVar.l(), beVar.i(), beVar.e(), beVar.f());
        ((IQIMShortVideoUtil) QRoute.api(IQIMShortVideoUtil.class)).preLoadPeakProcess(this);
        if (VersionUtils.isGingerBread()) {
            this.f176931s0.setOverScrollMode(0);
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = this.f176936x0;
        com.tencent.mobileqq.utils.w.a("storageUsedSpace", currentTimeMillis - j3, j3, currentTimeMillis, this.f176913a0);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        super.setContentView(R.layout.b2j);
        this.f176931s0 = (BounceScrollView) findViewById(R.id.ii_);
        setTitle(R.string.imq);
        P2();
        Q2();
        T2();
        this.f176913a0 = this.app.getCurrentAccountUin();
        setVolumeControlStream(3);
        if (com.tencent.mobileqq.utils.bj.d(this)) {
            com.tencent.mobileqq.utils.ff.T(this.app, "Safe_SpaceClean", "SpaceClean_", "enter_MsgHistory_had_installed_secure", 0, 0, null);
        } else {
            com.tencent.mobileqq.utils.ff.T(this.app, "Safe_SpaceClean", "SpaceClean_", "enter_MsgHistory_had_not_intalled_secure", 0, 0, null);
        }
        V2();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        QQProgressDialog qQProgressDialog = this.f176932t0;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            dismissDialog(1);
        }
        super.doOnDestroy();
        H2();
        com.tencent.mobileqq.qrscan.utils.b.c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnPostResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            super.doOnPostResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            super.doOnResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            super.doOnStart();
            ((com.tencent.mobileqq.apollo.handler.b) this.app.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).j2(new String[]{this.app.getCurrentAccountUin()}, new int[]{42255});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.onActivityResult(i3, i16, intent);
        if (i3 == 1 && intent != null) {
            long longExtra = intent.getLongExtra("extra_delete_total_file_size", 0L);
            if (longExtra > 0) {
                R2(longExtra);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else if (this.f176933u0) {
            this.f176933u0 = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public String setLastActivityName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return getString(R.string.a0y);
    }
}
