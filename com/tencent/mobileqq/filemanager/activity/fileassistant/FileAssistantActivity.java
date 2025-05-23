package com.tencent.mobileqq.filemanager.activity.fileassistant;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.tendoc.TencentDocMyFileNameProcessor;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.api.IQlinkUtils;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.widget.HeaderScrollView;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyRouter;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.weiyun.api.IWeiyunApi;
import com.tencent.mobileqq.weiyun.api.IWeiyunHelper;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.TokenResUtils;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.json.JSONObject;
import qb1.c;
import ta1.m;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FileAssistantActivity extends BaseFileAssistantActivity implements com.tencent.mobileqq.widget.navbar.a {
    private final ViewPager.SimpleOnPageChangeListener A1;
    private FMObserver B1;
    Handler C1;
    NavBarCommon X0;
    private qb1.b Z0;

    /* renamed from: a1, reason: collision with root package name */
    private com.tencent.mobileqq.weiyun.c f206567a1;

    /* renamed from: d1, reason: collision with root package name */
    TextView f206570d1;

    /* renamed from: e1, reason: collision with root package name */
    TextView f206571e1;

    /* renamed from: f1, reason: collision with root package name */
    TextView f206572f1;

    /* renamed from: g1, reason: collision with root package name */
    TextView f206573g1;

    /* renamed from: h1, reason: collision with root package name */
    RedTouch f206574h1;

    /* renamed from: i1, reason: collision with root package name */
    RedTouch f206575i1;

    /* renamed from: j1, reason: collision with root package name */
    RedTouch f206576j1;

    /* renamed from: l1, reason: collision with root package name */
    BusinessInfoCheckUpdate.AppInfo f206578l1;

    /* renamed from: m1, reason: collision with root package name */
    BusinessInfoCheckUpdate.AppInfo f206579m1;

    /* renamed from: n1, reason: collision with root package name */
    BusinessInfoCheckUpdate.AppInfo f206580n1;

    /* renamed from: p1, reason: collision with root package name */
    private int[] f206582p1;

    /* renamed from: q1, reason: collision with root package name */
    private ViewStub f206583q1;

    /* renamed from: r1, reason: collision with root package name */
    qb1.c f206584r1;

    /* renamed from: s1, reason: collision with root package name */
    HeaderScrollView f206585s1;

    /* renamed from: t1, reason: collision with root package name */
    TextView f206586t1;

    /* renamed from: u1, reason: collision with root package name */
    ViewStub f206587u1;

    /* renamed from: v1, reason: collision with root package name */
    private QQPermission f206588v1;

    /* renamed from: w1, reason: collision with root package name */
    private ob1.b f206589w1;

    /* renamed from: x1, reason: collision with root package name */
    private ViewPager f206590x1;

    /* renamed from: y1, reason: collision with root package name */
    private WeakReference<com.tencent.mobileqq.filemanager.widget.a> f206591y1;

    /* renamed from: z1, reason: collision with root package name */
    private String f206592z1;
    boolean Y0 = false;

    /* renamed from: b1, reason: collision with root package name */
    private volatile boolean f206568b1 = false;

    /* renamed from: c1, reason: collision with root package name */
    boolean f206569c1 = false;

    /* renamed from: k1, reason: collision with root package name */
    private RedTouch f206577k1 = null;

    /* renamed from: o1, reason: collision with root package name */
    private int[] f206581o1 = {R.string.b__, R.string.f4g, R.string.ifx, R.string.vsu};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            FileAssistantActivity.this.f206583q1.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            FileAssistantActivity.this.f206583q1.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            FileAssistantActivity.this.f206583q1.setVisibility(8);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class c extends ViewPager.SimpleOnPageChangeListener {
        c() {
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            FileAssistantActivity.this.f206589w1.k(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class d extends QQPermission.BasePermissionsListener {
        d() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            FileAssistantActivity.this.C4();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
            FileAssistantActivity.this.C4();
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class e extends Handler {
        e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                FileAssistantActivity.this.G4();
            }
        }
    }

    public FileAssistantActivity() {
        int i3;
        int i16;
        int i17;
        int i18;
        int[] iArr = new int[4];
        if (TokenResUtils.useTokenRes4()) {
            i3 = R.drawable.qui_computer;
        } else {
            i3 = R.drawable.qfile_file_menu_dataline_nor;
        }
        iArr[0] = i3;
        if (TokenResUtils.useTokenRes4()) {
            i16 = R.drawable.qui_face_to_face_transmit;
        } else {
            i16 = R.drawable.qfile_file_menu_qlink_nor;
        }
        iArr[1] = i16;
        if (TokenResUtils.useTokenRes4()) {
            i17 = R.drawable.qui_weiyun;
        } else {
            i17 = R.drawable.qfile_file_menu_wyback_nor;
        }
        iArr[2] = i17;
        if (TokenResUtils.useTokenRes4()) {
            i18 = R.drawable.qui_qqdocs;
        } else {
            i18 = R.drawable.qfile_file_troopfile_list_menu_create_docs;
        }
        iArr[3] = i18;
        this.f206582p1 = iArr;
        this.f206587u1 = null;
        this.f206591y1 = null;
        this.f206592z1 = HardCodeUtil.qqStr(R.string.f186953so);
        this.A1 = new c();
        this.B1 = new FMObserver() { // from class: com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.filemanager.app.FMObserver
            public void P(long j3, long j16, String str, int i19) {
                super.P(j3, j16, str, i19);
                if (FileAssistantActivity.this.f206589w1 != null) {
                    FileAssistantActivity.this.f206589w1.i();
                }
            }

            @Override // com.tencent.mobileqq.filemanager.app.FMObserver
            protected void S(boolean z16, long j3, long j16, String str, int i19, int i26, String str2) {
                if (FileAssistantActivity.this.f206589w1 != null) {
                    FileAssistantActivity.this.f206589w1.i();
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.filemanager.app.FMObserver
            public void T(boolean z16, long j3, long j16, String str, int i19) {
                if (FileAssistantActivity.this.f206589w1 != null) {
                    FileAssistantActivity.this.f206589w1.i();
                }
            }

            @Override // com.tencent.mobileqq.filemanager.app.FMObserver
            protected void f0(int i19, String str) {
                if (!FileAssistantActivity.this.f206568b1) {
                    com.tencent.mobileqq.filemanager.util.d.f(str);
                }
            }

            @Override // com.tencent.mobileqq.filemanager.app.FMObserver
            protected void g0(final boolean z16) {
                if (FileAssistantActivity.this.f206568b1) {
                    return;
                }
                FileAssistantActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!z16) {
                            FileAssistantActivity.this.p4();
                        } else {
                            FileAssistantActivity.this.r4();
                        }
                    }
                });
            }
        };
        this.C1 = new e(Looper.getMainLooper());
    }

    private void B4() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("dst");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        intent.removeExtra("dst");
        if ("page_expired_file".equals(stringExtra) && z4()) {
            ((IQQKuiklyRouter) QRoute.api(IQQKuiklyRouter.class)).jump(this, m4(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C4() {
        Intent intent = new Intent(getApplicationContext(), (Class<?>) FMActivity.class);
        intent.putExtra("tab_tab_type", 1);
        intent.putExtra("qfile_entrance_type_key", 8);
        try {
            Bundle bundle = new Bundle();
            bundle.putLong("category", 15);
            intent.putExtra("bundle", bundle);
            intent.putExtra("from", "FileAssistant");
            intent.putExtra("custom_title", getString(R.string.b68));
            startActivityForResult(intent, 101);
            if (this.Y0) {
                FileManagerReporter.addData("0X8005538");
            } else {
                FileManagerReporter.addData("0X800681E");
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void D4() {
        this.f206568b1 = false;
        if (((IQQFileEngine) this.D0.getRuntimeService(IQQFileEngine.class)).hasQueriedVerifyPassword()) {
            ((IQQFileEngine) this.D0.getRuntimeService(IQQFileEngine.class)).queryNeedVerifyPwd();
            return;
        }
        if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            Intent intent = new Intent(getApplicationContext(), (Class<?>) FMActivity.class);
            intent.putExtra("tab_tab_type", 3);
            intent.putExtra("from", "FileAssistant");
            startActivityForResult(intent, 101);
            return;
        }
        com.tencent.mobileqq.filemanager.util.d.f(BaseApplication.getContext().getString(R.string.f187123t5));
    }

    private void E4(String str) {
        if (!z4()) {
            return;
        }
        VideoReport.reportEvent(str, n4(str));
    }

    private void F4(boolean z16) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put(IFileBrowserService.FILE_BROWSER_PAGE_FROM, Integer.valueOf(o4()));
        hashMap.put("dt_pgid", "pg_bas_my_file");
        if (z16) {
            str = "pgin";
        } else {
            str = "pgout";
        }
        VideoReport.reportEvent(str, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G4() {
        QLog.i("FileAssistantActivity", 1, "fileRedTouch updateAllRedTouch");
        H4();
        M4();
        L4();
        I4();
    }

    private void H4() {
        IRedTouchManager iRedTouchManager;
        if (this.f206575i1 == null || (iRedTouchManager = (IRedTouchManager) this.D0.getRuntimeService(IRedTouchManager.class, "")) == null) {
            return;
        }
        this.f206579m1 = iRedTouchManager.getAppInfo(1, "100160.100163");
        QLog.i("FileAssistantActivity", 1, "fileRedTouch updateDocsFileRedTouch info = " + this.f206579m1);
        this.f206575i1.parseRedTouch(this.f206579m1);
        BusinessInfoCheckUpdate.AppInfo appInfo = this.f206579m1;
        if (appInfo != null) {
            iRedTouchManager.onRedTouchItemExposure(appInfo, null);
        }
    }

    private void I4() {
        AppRuntime peekAppRuntime;
        IRedTouchManager iRedTouchManager;
        if (!z4() || this.f206577k1 == null || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null || (iRedTouchManager = (IRedTouchManager) peekAppRuntime.getRuntimeService(IRedTouchManager.class, "")) == null) {
            return;
        }
        boolean hasRedTouch = this.f206577k1.hasRedTouch();
        BusinessInfoCheckUpdate.AppInfo appInfo = iRedTouchManager.getAppInfo(1, "140130");
        this.f206577k1.parseRedTouch(appInfo);
        if (appInfo != null) {
            iRedTouchManager.onRedTouchItemExposure(appInfo, null);
        }
        if (this.f206577k1.hasRedTouch() && !hasRedTouch) {
            MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(this, QMMKVFile.FILE_QQ_FILE);
            String str = "expired_file_tips_config_showTimes_" + peekAppRuntime.getCurrentUin();
            int i3 = fromV2.getInt(str, 0);
            if (!k4(i3)) {
                return;
            }
            com.tencent.mobileqq.widget.tip.a m06 = QUIDefaultBubbleTip.r(this.f206577k1.getContext()).S(this.f206577k1).o0("\u6587\u4ef6\u5373\u5c06\u8fc7\u671f").b0(5000L).k0(1).R(0).m0(3);
            s4();
            com.tencent.mobileqq.filemanager.widget.a aVar = new com.tencent.mobileqq.filemanager.widget.a(m06);
            this.f206591y1 = new WeakReference<>(aVar);
            aVar.d();
            fromV2.putInt(str, i3 + 1);
        }
    }

    private void J4() {
        float f16;
        ImageView imageView = (ImageView) this.X0.findViewById(R.id.dsr);
        if (imageView != null) {
            if (QQTheme.isNowSimpleUI()) {
                f16 = 10.0f;
            } else {
                f16 = 16.0f;
            }
            int dip2px = ViewUtils.dip2px(f16);
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = dip2px;
                imageView.setLayoutParams(layoutParams);
            }
        }
        if (z4()) {
            this.X0.setRightImage2(getDrawable(R.drawable.kgj));
            this.X0.setRightImage2Desc(getString(R.string.f170904zw1));
            View findViewById = this.X0.findViewById(R.id.ivTitleBtnRightImage);
            if (findViewById != null) {
                this.f206577k1 = new RedTouch(this, findViewById).setGravity(53).applyTo();
            }
        }
    }

    private void L4() {
        IRedTouchManager iRedTouchManager;
        if (this.f206576j1 == null || (iRedTouchManager = (IRedTouchManager) this.D0.getRuntimeService(IRedTouchManager.class, "")) == null) {
            return;
        }
        this.f206580n1 = iRedTouchManager.getAppInfo(1, "100160.100162");
        QLog.i("FileAssistantActivity", 1, "fileRedTouch updateWeiyunBackupRedTouch info = " + this.f206580n1);
        this.f206576j1.parseRedTouch(this.f206580n1);
        BusinessInfoCheckUpdate.AppInfo appInfo = this.f206580n1;
        if (appInfo != null) {
            iRedTouchManager.onRedTouchItemExposure(appInfo, null);
        }
    }

    private void M4() {
        IRedTouchManager iRedTouchManager;
        if (this.f206574h1 == null || (iRedTouchManager = (IRedTouchManager) this.D0.getRuntimeService(IRedTouchManager.class, "")) == null) {
            return;
        }
        this.f206578l1 = iRedTouchManager.getAppInfo(1, "100160.100164");
        QLog.i("FileAssistantActivity", 1, "fileRedTouch updateWeiyunFileRedTouch info = " + this.f206578l1);
        this.f206574h1.parseRedTouch(this.f206578l1);
        BusinessInfoCheckUpdate.AppInfo appInfo = this.f206578l1;
        if (appInfo != null) {
            iRedTouchManager.onRedTouchItemExposure(appInfo, null);
        }
    }

    private void i4() {
        if (QQTheme.isNowThemeSimpleNight()) {
            this.f206570d1.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.kgn, 0, 0);
            this.f206573g1.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.qui_fast_folder, 0, 0);
            this.f206571e1.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.kgp, 0, 0);
            this.f206572f1.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.kgl, 0, 0);
        }
        if (TokenResUtils.useTokenRes3()) {
            this.f206570d1.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.f161619kh2, 0, 0);
            this.f206573g1.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.kgz, 0, 0);
            this.f206571e1.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.khg, 0, 0);
            this.f206572f1.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.kgf, 0, 0);
        }
    }

    private boolean k4(int i3) {
        JSONObject b16 = sb1.a.f433609a.b("expired_file_tips_config", "{}");
        int i16 = 3;
        if (b16 != null) {
            i16 = b16.optInt("maxShowTimes", 3);
        }
        if (i3 < i16) {
            return true;
        }
        return false;
    }

    private void l4(BusinessInfoCheckUpdate.AppInfo appInfo, String str) {
        QLog.i("FileAssistantActivity", 1, " fileRedTouch deleteRedTouch path = " + str);
        IRedTouchManager iRedTouchManager = (IRedTouchManager) this.D0.getRuntimeService(IRedTouchManager.class, "");
        if (appInfo == null) {
            iRedTouchManager.onRedTouchItemClick(str);
        } else {
            iRedTouchManager.onRedTouchItemClick(appInfo, null);
        }
    }

    private String m4(int i3) {
        return "mqqapi://kuikly/open?page_name=QQFileExpiringListPage&local_bundle_name=nearbypro&use_host_display_metrics=1&qui_token_theme_mode=0&page_from=" + i3;
    }

    private Map<String, String> n4(String str) {
        boolean z16;
        Object obj;
        com.tencent.mobileqq.filemanager.widget.a aVar;
        HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", "pg_bas_my_file");
        hashMap.put("dt_eid", "em_bas_expired_file_entry");
        RedTouch redTouch = this.f206577k1;
        boolean z17 = true;
        boolean z18 = false;
        if (redTouch != null && redTouch.hasRedTouch()) {
            z16 = true;
        } else {
            z16 = false;
        }
        String str2 = "1";
        if (z16) {
            obj = "1";
        } else {
            obj = "0";
        }
        hashMap.put("is_red_tips", obj);
        WeakReference<com.tencent.mobileqq.filemanager.widget.a> weakReference = this.f206591y1;
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            if ("imp".equals(str)) {
                z18 = aVar.getMIsShowing();
            } else {
                if (!aVar.getMIsShowing() && !aVar.b(1000L)) {
                    z17 = false;
                }
                z18 = z17;
            }
        }
        if (!z18) {
            str2 = "0";
        }
        hashMap.put("is_guiding_bubbles", str2);
        return hashMap;
    }

    private int o4() {
        String stringExtra = getIntent().getStringExtra("from");
        if (stringExtra == null) {
            return 2;
        }
        if (stringExtra.equals(QQPermissionConstants.Business.SCENE.TBS_TOOL)) {
            return 1;
        }
        if (!stringExtra.equals("FileAssistant")) {
            try {
                return Integer.parseInt(stringExtra);
            } catch (NumberFormatException e16) {
                QLog.e("FileAssistantActivity", 1, "getPageFrom failed. msg: " + e16.getMessage());
                return 2;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p4() {
        try {
            Intent intent = new Intent(getApplicationContext(), (Class<?>) FMActivity.class);
            Bundle bundle = new Bundle();
            bundle.putLong("category", 14L);
            intent.putExtra("bundle", bundle);
            intent.putExtra("tab_tab_type", 3);
            intent.putExtra("from", "FileAssistant");
            startActivityForResult(intent, 101);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r4() {
        Intent intent = new Intent(getApplicationContext(), (Class<?>) FMActivity.class);
        intent.putExtra("tab_tab_type", 3);
        intent.putExtra("from", "FileAssistant");
        startActivityForResult(intent, 101);
    }

    private void s4() {
        WeakReference<com.tencent.mobileqq.filemanager.widget.a> weakReference = this.f206591y1;
        if (weakReference == null) {
            return;
        }
        com.tencent.mobileqq.filemanager.widget.a aVar = weakReference.get();
        if (aVar != null) {
            aVar.a();
        }
        this.f206591y1 = null;
    }

    private void t4() {
        ValueAnimator ofInt = ValueAnimator.ofInt(this.f206583q1.getHeight(), 0);
        ofInt.setDuration(300L);
        ofInt.addUpdateListener(new a());
        ofInt.addListener(new b());
        ofInt.start();
    }

    private void u4() {
        this.f206572f1 = (TextView) findViewById(R.id.dpw);
        this.f206575i1 = new RedTouch(getApplicationContext(), this.f206572f1).setGravity(53).setRightMargin(10.0f).applyTo();
        this.f206572f1.setOnClickListener(this);
        ReportController.o(getAppRuntime(), "dc00898", "", "", "0X800906F", "0X800906F", 0, 0, "", "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v4() {
        qb1.c cVar = this.f206584r1;
        if (cVar != null && cVar.isSwitchOn()) {
            if (TextUtils.isEmpty(this.f206584r1.getTextContent())) {
                QLog.i("FileAssistantActivity", 1, "FileAssistantTips not ready, textContent is null");
                return;
            }
            ViewStub viewStub = (ViewStub) findViewById(R.id.uyz);
            this.f206583q1 = viewStub;
            viewStub.inflate();
            TextView textView = (TextView) findViewById(R.id.f111966mn);
            TextView textView2 = (TextView) findViewById(R.id.f111976mo);
            ImageView imageView = (ImageView) findViewById(R.id.y_1);
            textView.setText(this.f206584r1.getTextContent());
            textView2.setText(this.f206584r1.getJumpText());
            textView2.setOnClickListener(this);
            imageView.setOnClickListener(this);
            this.f206584r1.c();
            return;
        }
        QLog.i("FileAssistantActivity", 1, "FileAssistantTips is switch off");
    }

    private void w4() {
        m c16 = TencentDocMyFileNameProcessor.c();
        if (c16 != null) {
            this.f206572f1.setText(c16.f435714d);
            this.f206571e1.setText(c16.f435715e);
            this.f206592z1 = c16.f435716f;
        }
    }

    private void y4() {
        this.f206567a1 = new com.tencent.mobileqq.weiyun.c();
        PluginCommunicationHandler.getInstance().register(this.f206567a1);
        ((IWeiyunHelper) QRoute.api(IWeiyunHelper.class)).notifyEnterFileAssit(this.D0.getApplication());
    }

    private boolean z4() {
        return sb1.a.f433609a.c("expired_file_tips_config", false);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity
    public void J2(ArrayList<FileManagerEntity> arrayList) {
        ob1.b bVar = this.f206589w1;
        if (bVar != null) {
            bVar.d(arrayList);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity
    public void K2(ArrayList<WeiYunFileInfo> arrayList) {
        ob1.b bVar = this.f206589w1;
        if (bVar != null) {
            bVar.e(arrayList);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity
    public void L2(Set<FileInfo> set) {
        ob1.b bVar = this.f206589w1;
        if (bVar != null) {
            bVar.f(set, this.f206167a0);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity, com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        ViewStub viewStub = this.f206587u1;
        if (viewStub != null) {
            viewStub.setVisibility(8);
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity, mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        if (intent != null && intent.getExtras() != null && ((intent.getBooleanExtra("foward_editbar", false) || intent.getBooleanExtra("destroy_last_activity", false)) && i16 == 4)) {
            ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).openAIO(this, intent);
            finish();
        }
        if (i3 == 10001) {
            ((IWeiyunApi) QRoute.api(IWeiyunApi.class)).initPwdRecord(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        int i3;
        int i16;
        super.doOnCreate(bundle);
        this.Z0 = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).createFileAssistantExt();
        setContentView(R.layout.alb);
        this.f206588v1 = QQPermissionFactory.getQQPermission(this, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_FILE, QQPermissionConstants.Business.SCENE.QQ_FILE_MY_FILE_LOCAL_FILE));
        QLog.d("FileAssistantActivity", 1, "doOnCreate from: " + getIntent().getStringExtra("from"));
        if (((IQlinkUtils) QRoute.api(IQlinkUtils.class)).isAllowToQLink()) {
            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    AppRuntime appRuntime = FileAssistantActivity.this.getAppRuntime();
                    if (appRuntime == null) {
                        return;
                    }
                    SharedPreferences preferences = appRuntime.getPreferences();
                    boolean z16 = preferences.getBoolean("_file_assistant_guid_tips_", false);
                    IQFileConfigManager iQFileConfigManager = (IQFileConfigManager) FileAssistantActivity.this.D0.getRuntimeService(IQFileConfigManager.class, "");
                    FileAssistantActivity.this.f206584r1 = iQFileConfigManager.getFileAssistantTipsConfig();
                    FileAssistantActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FileAssistantActivity.this.v4();
                        }
                    });
                    if (!z16) {
                        preferences.edit().putBoolean("_file_assistant_guid_tips_", true).apply();
                        FileAssistantActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                FileAssistantActivity fileAssistantActivity = FileAssistantActivity.this;
                                fileAssistantActivity.f206587u1 = (ViewStub) fileAssistantActivity.findViewById(R.id.l0t);
                                View inflate = FileAssistantActivity.this.f206587u1.inflate();
                                FileAssistantActivity.this.f206587u1.setVisibility(8);
                                ((TextView) inflate.findViewById(R.id.kbr)).setText(HardCodeUtil.qqStr(R.string.f187163t9));
                            }
                        });
                    }
                }
            });
        }
        this.f206585s1 = (HeaderScrollView) findViewById(R.id.f165681d50);
        this.f206570d1 = (TextView) findViewById(R.id.dqc);
        this.f206573g1 = (TextView) findViewById(R.id.xu5);
        if (!((IFlashTransferApi) QRoute.api(IFlashTransferApi.class)).hasSendEntrance() && !((IFlashTransferApi) QRoute.api(IFlashTransferApi.class)).hasFlashTransferEntrance()) {
            this.f206573g1.setVisibility(8);
        }
        this.f206571e1 = (TextView) findViewById(R.id.drm);
        this.f206574h1 = new RedTouch(getApplicationContext(), this.f206571e1).setGravity(53).setRightMargin(10.0f).applyTo();
        u4();
        this.f206586t1 = (TextView) findViewById(R.id.dpx);
        this.f206570d1.setOnClickListener(this);
        this.f206573g1.setOnClickListener(this);
        this.f206571e1.setOnClickListener(this);
        this.f206586t1.setOnClickListener(this);
        findViewById(R.id.f166946jb3).setOnClickListener(this);
        NavBarCommon navBarCommon = (NavBarCommon) findViewById(R.id.rlCommenTitle);
        this.X0 = navBarCommon;
        navBarCommon.setTitle(getString(R.string.b7l));
        this.f206185s0 = getString(R.string.b7l);
        Drawable drawable = getDrawable(R.drawable.a8o);
        if (TokenResUtils.useTokenRes3()) {
            if (z4()) {
                i16 = R.drawable.qui_more_icon_navigation_01_selector;
            } else {
                i16 = R.drawable.qui_transmission_file_icon_navigation_01_selector;
            }
            drawable = getDrawable(i16);
        }
        i4();
        this.X0.setOnItemSelectListener(this);
        this.X0.setRightImage(drawable, null);
        this.X0.setRightImageDesc(HardCodeUtil.qqStr(R.string.f186733s3));
        J4();
        this.f206576j1 = new RedTouch(getApplicationContext(), this.X0).setGravity(53).setRightMargin(5.0f).setTopMargin(10.0f).applyTo();
        w4();
        this.Z0.d(this, this.f206585s1);
        x4();
        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).addObserver(this.B1);
        y4();
        G4();
        this.Z0.f(this.D0, this.C1);
        if (com.tencent.mobileqq.weiyun.utils.c.e(this, this.D0.getCurrentAccountUin()) == 1) {
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).preloadMiniApp();
            if (QLog.isColorLevel()) {
                QLog.d("FileAssistantActivity", 2, "doOnCreate, preload mini app process");
            }
        }
        int i17 = 0;
        this.Y0 = getIntent().getBooleanExtra("COMEFROMDESK", false);
        FileManagerReporter.a aVar = new FileManagerReporter.a();
        aVar.f209157b = "file_asst_in";
        aVar.f209158c = 11;
        FileManagerReporter.addData(this.D0.getCurrentAccountUin(), aVar);
        if (!((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).hasShortCut(this, new String[]{getString(R.string.b7l)})) {
            int length = this.f206581o1.length + 1;
            int[] iArr = new int[length];
            int length2 = this.f206582p1.length + 1;
            int[] iArr2 = new int[length2];
            int i18 = 0;
            while (true) {
                int[] iArr3 = this.f206581o1;
                if (i18 >= iArr3.length) {
                    break;
                }
                iArr[i18] = iArr3[i18];
                i18++;
            }
            iArr[length - 1] = R.string.f170946b74;
            this.f206581o1 = iArr;
            while (true) {
                int[] iArr4 = this.f206582p1;
                if (i17 >= iArr4.length) {
                    break;
                }
                iArr2[i17] = iArr4[i17];
                i17++;
            }
            int i19 = length2 - 1;
            if (TokenResUtils.useTokenRes4()) {
                i3 = R.drawable.qui_shortcut;
            } else {
                i3 = R.drawable.qfile_file_menu_sendtodesk_nor;
            }
            iArr2[i19] = i3;
            this.f206582p1 = iArr2;
        }
        VideoReport.setPageId(this, "pg_bas_my_file");
        B4();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        ViewPager viewPager = this.f206590x1;
        if (viewPager != null) {
            viewPager.removeOnPageChangeListener(this.A1);
            this.f206589w1.destroy();
        }
        if (this.B1 != null) {
            ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).deleteObserver(this.B1);
        }
        this.Z0.b(this.D0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        super.doOnNewIntent(intent);
        if (intent != null) {
            setIntent(intent);
            B4();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        super.doOnPause();
        this.f206568b1 = true;
        this.f206567a1.a(null);
        F4(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        this.rightViewText.setVisibility(8);
        this.X0.setTitle(getString(R.string.b7l));
        ob1.b bVar = this.f206589w1;
        if (bVar != null) {
            bVar.i();
        }
        this.f206586t1.setText(R.string.f186743s4);
        G4();
        refreshUI();
        F4(true);
        E4("imp");
    }

    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity
    public ListView getListView() {
        ob1.b bVar = this.f206589w1;
        if (bVar != null) {
            return bVar.g();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        super.onClick(view);
        int id5 = view.getId();
        if (id5 == R.id.dpx) {
            y3();
            if (r3()) {
                this.f206586t1.setText(R.string.cancel);
            } else {
                FileManagerReporter.addData("0X8009C32");
                this.f206586t1.setText(R.string.f186743s4);
            }
            this.X0.setTitle(getString(R.string.b7l));
            ob1.b bVar = this.f206589w1;
            if (bVar != null) {
                bVar.i();
            }
            this.rightViewText.setVisibility(8);
        } else if (id5 == R.id.dqc) {
            if (this.f206588v1.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) != 0) {
                this.f206588v1.requestPermissions(QQPermissionConstants.Permission.GROUP_STORAGE, 2, new d());
            } else {
                C4();
            }
        } else if (id5 == R.id.drm) {
            int e16 = com.tencent.mobileqq.weiyun.utils.c.e(this, this.D0.getCurrentAccountUin());
            if (e16 == 1) {
                String d16 = com.tencent.mobileqq.weiyun.utils.c.d(this, this.D0.getCurrentAccountUin());
                int f16 = com.tencent.mobileqq.weiyun.utils.c.f(this, this.D0.getCurrentAccountUin());
                if (!TextUtils.isEmpty(d16)) {
                    ((IWeiyunApi) QRoute.api(IWeiyunApi.class)).startWeiYunMiniApp(this, d16, f16, null);
                } else {
                    QLog.w("FileAssistantActivity", 2, "can not to start WeiYun Mini app, apkgUrl = " + d16 + ", version = " + f16);
                    D4();
                }
            } else {
                QLog.w("FileAssistantActivity", 2, "can not to start WeiYun Mini app, weiYunGrayConfig = " + e16);
                D4();
            }
            if (this.Y0) {
                FileManagerReporter.addData("0X800553A");
            } else {
                FileManagerReporter.addData("0X8006820");
            }
            l4(this.f206578l1, "100160.100164");
        } else if (id5 == R.id.dpw) {
            FileManagerReporter.addData("0X8009070");
            ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).gotoTIMTeamworkFileUrl(this, this.f206569c1);
            com.tencent.mobileqq.teamwork.b.f(this.D0);
            l4(this.f206579m1, "100160.100163");
        } else if (id5 == R.id.xu5) {
            ((IQQKuiklyRouter) QRoute.api(IQQKuiklyRouter.class)).jump(this, ((IFlashTransferApi) QRoute.api(IFlashTransferApi.class)).getCenterActivityScheme());
        } else if (id5 == R.id.y_1) {
            this.f206584r1.d();
            t4();
        } else if (id5 == R.id.f111976mo) {
            this.f206584r1.b();
            c.a a16 = ((IQFileConfigManager) this.D0.getRuntimeService(IQFileConfigManager.class, "")).getFileAssistantTipsConfig().a();
            if (a16 != null) {
                a16.jump(this);
            }
            t4();
        } else if (id5 == R.id.f166946jb3) {
            FileManagerReporter.addData("0X8009C33");
            ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).startSeach(this);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity, com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.widget.navbar.a
    public void onItemSelect(View view, int i3) {
        if (i3 == 5) {
            this.Z0.a(this, this.f206580n1, this.Y0, this.D0, this.f206581o1, this.f206582p1);
            this.Z0.c(this.X0, (this.X0.getWidth() - this.Z0.e()) - getResources().getDimensionPixelSize(R.dimen.au7), 0);
            ReportController.o(getAppRuntime(), "dc00898", "", "", "0X800A15E", "0X800A15E", 0, 0, "", "", "", "");
            return;
        }
        if (i3 == 4) {
            if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                com.tencent.mobileqq.filemanager.util.d.e(R.string.b_o);
                return;
            }
            E4("clck");
            l4(null, "140130");
            ((IQQKuiklyRouter) QRoute.api(IQQKuiklyRouter.class)).jump(this, m4(0));
            return;
        }
        if (i3 == 1) {
            finish();
        }
    }

    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity
    public void refreshUI() {
        super.refreshUI();
        ob1.b bVar = this.f206589w1;
        if (bVar != null) {
            bVar.i();
        }
    }

    protected void x4() {
        String[] strArr = {getString(R.string.ba_), getString(R.string.bab), this.f206592z1, getString(R.string.baf), getString(R.string.bac), getString(R.string.baa)};
        QUIPageTabBar qUIPageTabBar = (QUIPageTabBar) findViewById(R.id.f220102k);
        this.f206590x1 = (ViewPager) findViewById(R.id.viewPager);
        ob1.b bVar = new ob1.b(this, new int[]{3, 4, 20, 5, 6, 7});
        this.f206589w1 = bVar;
        bVar.j(this.f206585s1);
        this.f206590x1.addOnPageChangeListener(this.A1);
        this.f206590x1.setAdapter(this.f206589w1);
        this.f206589w1.k(0);
        this.f206590x1.setCurrentItem(0);
        qUIPageTabBar.setTabData(strArr);
        qUIPageTabBar.setViewPager(this.f206590x1);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity
    public void z3() {
        if (this.f206586t1 != null) {
            if (r3()) {
                this.f206586t1.setText(R.string.cancel);
            } else {
                this.f206586t1.setText(R.string.f186743s4);
            }
        }
    }
}
