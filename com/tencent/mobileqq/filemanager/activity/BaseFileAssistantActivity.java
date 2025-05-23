package com.tencent.mobileqq.filemanager.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoProcessor;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.f;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.util.p;
import com.tencent.mobileqq.filemanager.util.t;
import com.tencent.mobileqq.filemanager.util.y;
import com.tencent.mobileqq.filemanager.util.z;
import com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ISeparateForwardProxy;
import com.tencent.mobileqq.teamwork.bp;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ca;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class BaseFileAssistantActivity extends QIphoneTitleBarActivity implements View.OnClickListener {
    public String B0;
    public String C0;
    public BaseQQAppInterface D0;
    protected ArrayList<FileInfo> J0;
    private ISeparateForwardProxy S0;

    /* renamed from: j0, reason: collision with root package name */
    private String f206176j0;

    /* renamed from: k0, reason: collision with root package name */
    private String f206177k0;

    /* renamed from: l0, reason: collision with root package name */
    private String f206178l0;

    /* renamed from: m0, reason: collision with root package name */
    private int f206179m0;

    /* renamed from: n0, reason: collision with root package name */
    private int f206180n0;

    /* renamed from: o0, reason: collision with root package name */
    private int f206181o0;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f206182p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f206183q0;

    /* renamed from: r0, reason: collision with root package name */
    private int f206184r0;

    /* renamed from: s0, reason: collision with root package name */
    protected String f206185s0;

    /* renamed from: t0, reason: collision with root package name */
    private y f206186t0;

    /* renamed from: u0, reason: collision with root package name */
    private t f206187u0;

    /* renamed from: a0, reason: collision with root package name */
    protected SendBottomBar f206167a0 = null;

    /* renamed from: b0, reason: collision with root package name */
    protected QfileEditBottomBar f206168b0 = null;

    /* renamed from: c0, reason: collision with root package name */
    public RelativeLayout f206169c0 = null;

    /* renamed from: d0, reason: collision with root package name */
    public TextView f206170d0 = null;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f206171e0 = false;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f206172f0 = false;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f206173g0 = true;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f206174h0 = false;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f206175i0 = false;

    /* renamed from: v0, reason: collision with root package name */
    protected int f206188v0 = -1;

    /* renamed from: w0, reason: collision with root package name */
    protected boolean f206189w0 = false;

    /* renamed from: x0, reason: collision with root package name */
    protected boolean f206190x0 = false;

    /* renamed from: y0, reason: collision with root package name */
    protected boolean f206191y0 = false;

    /* renamed from: z0, reason: collision with root package name */
    public boolean f206192z0 = false;
    public boolean A0 = false;
    protected boolean E0 = false;
    protected int F0 = -1;
    protected long G0 = 0;
    protected String H0 = null;
    protected String I0 = null;
    protected boolean K0 = false;
    protected int L0 = 0;
    public boolean M0 = false;
    protected boolean N0 = false;
    public boolean O0 = false;
    public String P0 = "";
    public int Q0 = 20971520;
    private int R0 = 0;
    public long T0 = -1;
    private com.tencent.mobileqq.filemanager.activity.fileassistant.a U0 = null;
    boolean V0 = true;
    FMObserver W0 = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            BaseFileAssistantActivity.this.y3();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b extends FMObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        public void L(String str, String str2, Integer num, String str3, boolean z16) {
            super.L(str, str2, num, str3, z16);
        }
    }

    private void g3() {
        if (this.f206167a0 == null) {
            this.f206167a0 = (SendBottomBar) findViewById(R.id.imz);
        }
        if (this.f206168b0 == null) {
            this.f206168b0 = (QfileEditBottomBar) findViewById(R.id.brm);
        }
        this.f206168b0.setVisibility(8);
        this.f206167a0.setVisibility(8);
        if (p3()) {
            f3();
            this.f206167a0.H();
            this.f206167a0.setVisibility(0);
        } else if (n3()) {
            f3();
            this.f206168b0.e();
            this.f206168b0.setVisibility(0);
        }
    }

    private void h3() {
        if (this.f206169c0 == null) {
            this.f206169c0 = (RelativeLayout) findViewById(R.id.fue);
        }
        if (!p3() && !n3()) {
            this.f206169c0.setVisibility(8);
        } else {
            this.f206169c0.setVisibility(0);
        }
        H2(r3());
    }

    private void initTitleBar() {
        z3();
    }

    public void A3() {
        setTitle(this.f206185s0);
        if (this.f206188v0 == 1 && !r3()) {
            this.f206170d0.setVisibility(0);
        }
    }

    public void C3(int i3) {
        this.f206180n0 = i3;
    }

    public void D3(boolean z16) {
        this.f206167a0.setCheckAllEnable(z16);
    }

    public void E3(int i3) {
        long uptimeMillis = SystemClock.uptimeMillis();
        super.setContentViewNoTitle(R.layout.f168648am4);
        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.a6d);
        View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(i3, (ViewGroup) null);
        long uptimeMillis3 = SystemClock.uptimeMillis() - uptimeMillis;
        p.a(this, uptimeMillis2, uptimeMillis3 - uptimeMillis2, uptimeMillis3);
        relativeLayout.addView(inflate);
        this.rightViewText = (TextView) findViewById(R.id.ily);
        initUI();
        i3();
    }

    public void F3(com.tencent.mobileqq.filemanager.activity.fileassistant.a aVar) {
        this.U0 = aVar;
    }

    public void G3(boolean z16) {
        if (!this.N0) {
            QLog.i("File.Selector.BaseFileAssistantActivity", 1, "biz not support docs send!");
        } else {
            this.f206167a0.setDocsCheck(z16);
        }
    }

    public void H3(boolean z16, boolean z17, boolean z18, boolean z19, boolean z26) {
        this.f206167a0.setEditBtnVisible(z16);
        this.f206168b0.setEditBtnVisible(z17, z18, z19, z26);
    }

    public void I2() {
        this.f206167a0.H();
        this.f206168b0.e();
        long s16 = f.s();
        if (!this.M0 && this.f206188v0 != 8 && !ah.a1(this) && r3()) {
            if (f.s() == 0) {
                A3();
                return;
            }
            setTitle(HardCodeUtil.qqStr(R.string.f170943b71) + s16 + HardCodeUtil.qqStr(R.string.zyo));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I3(boolean z16) {
        this.f206173g0 = z16;
    }

    public void J3(boolean z16) {
        this.f206175i0 = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void K3(boolean z16) {
        this.f206174h0 = z16;
    }

    public void L3(boolean z16) {
        if (z16) {
            this.R0 |= 2;
        } else {
            this.R0 &= -3;
        }
    }

    public boolean M2() {
        return this.f206182p0;
    }

    public void M3(boolean z16) {
        if (z16) {
            this.R0 |= 1;
        } else {
            this.R0 &= -2;
        }
    }

    public int N2() {
        return this.L0;
    }

    public int P2() {
        return this.f206180n0;
    }

    public void P3(t tVar) {
        i3();
        this.f206187u0 = tVar;
        this.f206167a0.setClickListener(tVar);
        this.f206168b0.setClickListener(tVar);
    }

    public int Q2() {
        return this.f206184r0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Q3() {
        this.V0 = false;
        new Handler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity.1
            @Override // java.lang.Runnable
            public void run() {
                BaseFileAssistantActivity.this.V0 = true;
            }
        }, 1500L);
    }

    public ISeparateForwardProxy R2() {
        return this.S0;
    }

    public void R3(int i3) {
        this.f206179m0 = i3;
    }

    public int S2() {
        return this.f206179m0;
    }

    public void S3(boolean z16) {
        SendBottomBar sendBottomBar = this.f206167a0;
        if (sendBottomBar != null) {
            sendBottomBar.setSelectAllOrCancelAll(z16);
        }
    }

    public int T2() {
        return this.f206181o0;
    }

    public y U2() {
        return this.f206186t0;
    }

    public SendBottomBar V2() {
        return this.f206167a0;
    }

    public void V3() {
        this.rightViewText.setVisibility(0);
        AccessibilityUtil.o(this.rightViewText);
    }

    public String W2() {
        return this.I0;
    }

    public void W3(View.OnClickListener onClickListener) {
        this.f206170d0.setOnClickListener(onClickListener);
        this.f206170d0.setVisibility(0);
    }

    public void X3(boolean z16) {
        if (z16) {
            startTitleProgress();
        } else {
            stopTitleProgress();
        }
    }

    public int Y2() {
        return -1;
    }

    public String Z2() {
        return this.f206178l0;
    }

    public int[] b3() {
        return null;
    }

    public String c3() {
        return this.f206177k0;
    }

    public String d3() {
        return this.f206176j0;
    }

    @Override // com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        super.doOnActivityResult(i3, i16, intent);
        this.f206167a0.H();
        if (i16 == -1 && i3 == 109) {
            this.S0.onFowardActivityResult(intent);
        }
        if (i16 == 4) {
            if (this.f206183q0 && intent != null && intent.getExtras() != null) {
                ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).startChatAndSendMsg(this, intent.getExtras());
            }
            setResult(4, intent);
            finish();
            return;
        }
        if (i16 == -1 && i3 != 103 && i3 != 12289) {
            setResult(-1, intent);
            finish();
        } else if (i16 == 5) {
            setResult(5, null);
            finish();
        } else if (i16 == 10) {
            setResult(10, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        int i3;
        ca.a(this);
        super.doOnCreate(bundle);
        this.D0 = (BaseQQAppInterface) getAppRuntime();
        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).addObserver(this.W0);
        Intent intent = getIntent();
        K3(intent.getBooleanExtra("selectMode", p3()));
        I3(intent.getBooleanExtra("enableDelete", !p3()));
        this.f206176j0 = intent.getStringExtra(IProfileProtocolConst.PARAM_TARGET_UIN);
        this.f206177k0 = getIntent().getStringExtra("targetPeerUid");
        this.f206178l0 = intent.getStringExtra("srcDiscGroup");
        this.f206179m0 = intent.getIntExtra("peerType", 0);
        this.f206183q0 = intent.getBooleanExtra("rootEntrace", true);
        this.f206180n0 = intent.getIntExtra(IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, 0);
        this.f206184r0 = intent.getIntExtra("enterfrom", 0);
        this.f206181o0 = intent.getIntExtra("sendprepare", -100);
        this.f206182p0 = intent.getBooleanExtra("apautocreate", false);
        this.M0 = intent.getBooleanExtra("STRING_SingleSelect", false);
        this.f206191y0 = intent.getBooleanExtra("qlinkselect", false);
        this.E0 = intent.getBooleanExtra("only_show_local_tab", false);
        this.F0 = intent.getIntExtra(PictureConst.KEY_MAX_SELECT_COUNT, -1);
        this.G0 = intent.getLongExtra("max_select_size", 0L);
        this.I0 = intent.getStringExtra("send_btn_custom_text");
        this.K0 = intent.getBooleanExtra("send_btn_custom_text_show_count", false);
        this.J0 = intent.getParcelableArrayListExtra("default_select_file_info_list");
        this.H0 = intent.getStringExtra("custom_title");
        this.L0 = intent.getIntExtra("approval_attachment_customid", 0);
        this.N0 = intent.getBooleanExtra("select_file_support_send_docs_file", false);
        this.O0 = intent.getBooleanExtra(com.tencent.mobileqq.teamwork.t.f292401f, false);
        this.P0 = intent.getStringExtra(com.tencent.mobileqq.teamwork.t.f292402g);
        this.T0 = intent.getLongExtra("qrlogin_appid", -1L);
        this.f206171e0 = intent.getBooleanExtra("isTroopFile", false);
        this.f206172f0 = intent.getBooleanExtra("isOverSpace", false);
        intent.putExtra("uintype", 0);
        ISeparateForwardProxy iSeparateForwardProxy = (ISeparateForwardProxy) QRoute.api(ISeparateForwardProxy.class);
        this.S0 = iSeparateForwardProxy;
        iSeparateForwardProxy.createSeparateForward(this, 109);
        this.S0.onCreate();
        if ("FileAssistant".equalsIgnoreCase(getIntent().getStringExtra("from"))) {
            L3(true);
        }
        if (-1 == this.F0) {
            if (this.f206191y0) {
                i3 = 100;
            } else {
                i3 = 20;
            }
            this.F0 = i3;
        }
        if (this.O0) {
            f.M(1);
            bp.b().c();
            long c16 = TencentDocImportFileInfoProcessor.c().c();
            if (c16 == 0) {
                c16 = QZoneHelper.Constants.NO_WIFI_UPLOAD_VIDEO_MAX_SIZE_DEFAULT;
            }
            this.G0 = c16;
        } else {
            f.M(this.F0);
        }
        f.N(this.G0);
        ArrayList<FileInfo> arrayList = this.J0;
        if (arrayList != null) {
            Iterator<FileInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                f.c(it.next());
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("File.Selector.BaseFileAssistantActivity", 2, ">>>>>" + getClass().getSimpleName() + "<<<<< doOnCreate ");
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        if (QLog.isColorLevel()) {
            QLog.d("File.Selector.BaseFileAssistantActivity", 2, ">>>>>" + getClass().getSimpleName() + "<<<<< doOnDestroy ");
        }
        this.S0.onDestroy();
        if (this.W0 != null) {
            ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).deleteObserver(this.W0);
        }
        SendBottomBar sendBottomBar = this.f206167a0;
        if (sendBottomBar != null) {
            sendBottomBar.j0();
        }
        QfileEditBottomBar qfileEditBottomBar = this.f206168b0;
        if (qfileEditBottomBar != null) {
            qfileEditBottomBar.u();
        }
        super.doOnDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        AbstractGifImage.pauseAll();
        ApngImage.pauseAll();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        com.tencent.mobileqq.filemanager.activity.fileassistant.a aVar = this.U0;
        if (aVar != null) {
            aVar.f();
        }
        this.V0 = true;
        I2();
        AbstractGifImage.resumeAll();
        ApngImage.playByTag(0);
        this.f206167a0.k0();
        super.doOnResume();
    }

    public void e3() {
        this.rightViewText.setVisibility(8);
    }

    public void f3() {
        this.f206170d0.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        if (this.f206183q0) {
            if (P2() == 1) {
                ((IQQFileEngine) this.D0.getRuntimeService(IQQFileEngine.class)).exitQlinkLocalFileBrowser();
            }
            if (r3()) {
                f.k();
            }
        }
    }

    public BaseQQAppInterface getApp() {
        return (BaseQQAppInterface) getAppRuntime();
    }

    public ListView getListView() {
        return null;
    }

    public int getTabType() {
        return this.f206188v0;
    }

    public void i3() {
        if (this.f206186t0 == null) {
            this.f206186t0 = new z();
        }
    }

    protected void initUI() {
        if (this.f206170d0 == null) {
            this.f206170d0 = (TextView) findViewById(R.id.iim);
            f3();
        }
        initTitleBar();
        if (getIntent().getIntExtra("localSdCardfile", -1) == 1408041716) {
            e3();
        }
        g3();
        h3();
    }

    public boolean j3() {
        return this.f206167a0.Z();
    }

    public boolean l3() {
        return this.f206173g0;
    }

    public boolean n3() {
        return this.f206175i0;
    }

    @Override // com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    public boolean p3() {
        return this.f206174h0;
    }

    public boolean r3() {
        if (!p3() && !n3()) {
            return false;
        }
        return true;
    }

    public void refreshUI() {
        initUI();
    }

    public boolean s3() {
        return this.f206190x0;
    }

    @Override // com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i3) {
        super.setContentView(R.layout.f168648am4);
        if (Build.VERSION.SDK_INT >= 24 && (isInPictureInPictureMode() || isInMultiWindowMode())) {
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.rlCommenTitle);
            if (viewGroup instanceof NavBarCommon) {
                NavBarCommon navBarCommon = (NavBarCommon) viewGroup;
                ViewGroup.LayoutParams layoutParams = navBarCommon.getLayoutParams();
                int statusBarHeight = ViewUtils.getStatusBarHeight(this);
                layoutParams.height = getTitleBarHeight() + statusBarHeight;
                navBarCommon.setPadding(0, statusBarHeight, 0, 0);
            }
        }
        ((RelativeLayout) findViewById(R.id.a6d)).addView(((LayoutInflater) getSystemService("layout_inflater")).inflate(i3, (ViewGroup) null));
        initUI();
        i3();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i3) {
        intent.putExtra("selectMode", p3());
        intent.putExtra("enableDelete", l3());
        intent.putExtra(IProfileProtocolConst.PARAM_TARGET_UIN, this.f206176j0);
        intent.putExtra("targetPeerUid", this.f206177k0);
        intent.putExtra("srcDiscGroup", this.f206178l0);
        intent.putExtra("peerType", this.f206179m0);
        intent.putExtra(IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, this.f206180n0);
        intent.putExtra("enterfrom", this.f206184r0);
        intent.putExtra("sendprepare", this.f206181o0);
        intent.putExtra("apautocreate", this.f206182p0);
        intent.putExtra("qlinkselect", this.f206191y0);
        intent.putExtra("max_select_size", this.G0);
        intent.putExtra(PictureConst.KEY_MAX_SELECT_COUNT, this.F0);
        intent.putExtra("send_btn_custom_text", this.I0);
        intent.putExtra("custom_title", this.H0);
        intent.putExtra("rootEntrace", false);
        super.startActivityForResult(intent, i3);
    }

    public boolean t3() {
        if ((this.R0 & 2) == 2) {
            return true;
        }
        return false;
    }

    public boolean u3() {
        if (!this.f206189w0 && !this.f206191y0) {
            return false;
        }
        return true;
    }

    public boolean v3() {
        if ((this.R0 & 1) == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean w3() {
        return this.V0;
    }

    public boolean x3() {
        return this.K0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y3() {
        if (r3()) {
            f.k();
            J3(false);
            if (p3()) {
                setResult(5);
                finish();
                return;
            }
            this.rightViewText.setVisibility(0);
            this.rightViewText.setText(R.string.b5z);
            AccessibilityUtil.o(this.rightViewText);
            this.f206168b0.setVisibility(8);
            setTitle(this.f206185s0);
            refreshUI();
            B3();
            if (this.f206188v0 == 1) {
                this.f206170d0.setVisibility(0);
            }
            H2(false);
            return;
        }
        if (this.f206187u0 != null) {
            if (QLog.isColorLevel()) {
                QLog.e("File.Selector.BaseFileAssistantActivity", 2, "onRightEditClick");
            }
            this.f206187u0.e();
        }
        f.k();
        J3(true);
        this.rightViewText.setVisibility(0);
        this.rightViewText.setText(R.string.b5j);
        AccessibilityUtil.o(this.rightViewText);
        this.f206168b0.setVisibility(0);
        refreshUI();
        this.f206170d0.setVisibility(8);
        H2(true);
    }

    public void z3() {
        if (r3()) {
            this.rightViewText.setVisibility(0);
            this.rightViewText.setText(getString(R.string.b5j));
        } else {
            this.rightViewText.setVisibility(0);
            this.rightViewText.setText(R.string.b5z);
        }
        this.rightViewText.setOnClickListener(new a());
    }

    protected void B3() {
    }

    public void G2(ArrayList<FileManagerEntity> arrayList) {
    }

    public void H2(boolean z16) {
    }

    public void J2(ArrayList<FileManagerEntity> arrayList) {
    }

    public void K2(ArrayList<WeiYunFileInfo> arrayList) {
    }

    public void L2(Set<FileInfo> set) {
    }

    public void T3(int i3) {
    }

    public void U3(com.tencent.mobileqq.filemanager.activity.fileassistant.a aVar) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
