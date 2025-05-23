package com.tencent.mobileqq.filemanager.fileviewer;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.activitymodule.DefaultActivityModuleProvider;
import com.tencent.mobileqq.app.activitymodule.IActivityModule;
import com.tencent.mobileqq.app.activitymodule.IActivityModuleProvider;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filebrowser.ITBSToolApi;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.tbstool.FileImporter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.ca;
import com.tencent.mobileqq.utils.u;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import com.tencent.util.TokenResUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.lang.reflect.Method;
import rx.functions.Action1;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FileBrowserActivity extends IphoneTitleBarActivity implements com.tencent.mobileqq.filemanager.fileviewer.g, View.OnClickListener {

    /* renamed from: a0, reason: collision with root package name */
    private String f208099a0;

    /* renamed from: b0, reason: collision with root package name */
    private TextView f208100b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f208101c0;

    /* renamed from: d0, reason: collision with root package name */
    private ImageView f208102d0;

    /* renamed from: e0, reason: collision with root package name */
    private AvatarLayout f208103e0;

    /* renamed from: f0, reason: collision with root package name */
    private RelativeLayout f208104f0;

    /* renamed from: g0, reason: collision with root package name */
    private DynamicAvatarView f208105g0;

    /* renamed from: i0, reason: collision with root package name */
    ForwardFileInfo f208107i0;

    /* renamed from: o0, reason: collision with root package name */
    protected FileBrowserManager f208113o0;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f208114p0;

    /* renamed from: q0, reason: collision with root package name */
    private String f208115q0;

    /* renamed from: r0, reason: collision with root package name */
    private int f208116r0;

    /* renamed from: s0, reason: collision with root package name */
    private FileBrowserMiniAIOHelper f208117s0;

    /* renamed from: u0, reason: collision with root package name */
    private IColorNoteController f208119u0;

    /* renamed from: w0, reason: collision with root package name */
    private int f208121w0;

    /* renamed from: h0, reason: collision with root package name */
    private com.tencent.mobileqq.filemanager.fileviewer.f f208106h0 = null;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f208108j0 = false;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f208109k0 = false;

    /* renamed from: l0, reason: collision with root package name */
    protected com.tencent.mobileqq.filemanager.fileviewer.i f208110l0 = null;

    /* renamed from: m0, reason: collision with root package name */
    private GestureDetector f208111m0 = null;

    /* renamed from: n0, reason: collision with root package name */
    protected int f208112n0 = 10000;

    /* renamed from: t0, reason: collision with root package name */
    private long[] f208118t0 = new long[5];

    /* renamed from: v0, reason: collision with root package name */
    private int f208120v0 = -1;

    /* renamed from: x0, reason: collision with root package name */
    private boolean f208122x0 = false;

    /* renamed from: y0, reason: collision with root package name */
    private final u f208123y0 = new u();

    /* renamed from: z0, reason: collision with root package name */
    com.tencent.mobileqq.filemanager.fileviewer.h f208124z0 = new b();
    boolean A0 = false;
    private BroadcastReceiver B0 = null;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements com.tencent.mobileqq.filemanager.fileviewer.h {
        b() {
        }

        private void b(boolean z16) {
            if (com.tencent.mobileqq.tbstool.gray.b.f291450a.g(FileBrowserActivity.this.U2())) {
                return;
            }
            View findViewById = FileBrowserActivity.this.findViewById(R.id.ibf);
            if (z16) {
                findViewById.setVisibility(4);
            } else {
                findViewById.setVisibility(0);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.fileviewer.h
        @TargetApi(14)
        public void D() {
            boolean z16;
            String configuration = FileBrowserActivity.this.getResources().getConfiguration().toString();
            if (!configuration.contains("hwMultiwindow-magic") && !configuration.contains("hw-magic-windows")) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (ImmersiveUtils.isSupporImmersive() == 1 && !z16) {
                RelativeLayout relativeLayout = (RelativeLayout) FileBrowserActivity.this.findViewById(R.id.iep);
                relativeLayout.setFitsSystemWindows(true);
                relativeLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(FileBrowserActivity.this), 0, 0);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.fileviewer.h
        public void a(int i3) {
            FileBrowserActivity fileBrowserActivity = FileBrowserActivity.this;
            fileBrowserActivity.f208100b0 = (TextView) fileBrowserActivity.findViewById(R.id.ivTitleName);
            FileBrowserActivity.this.f208100b0.setTextSize(1, 19.0f);
            FileBrowserActivity.this.f208100b0.setText(FileBrowserActivity.this.f208113o0.t());
        }

        @Override // com.tencent.mobileqq.filemanager.fileviewer.h
        public void g(boolean z16) {
            FileBrowserActivity.this.f208108j0 = z16;
            b(z16);
            RelativeLayout V2 = FileBrowserActivity.this.V2();
            if (!FileBrowserActivity.this.f208108j0) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(3, R.id.ibf);
                V2.setLayoutParams(layoutParams);
                FileBrowserActivity fileBrowserActivity = FileBrowserActivity.this;
                fileBrowserActivity.g3(SystemBarActivityModule.getSystemBarComp(fileBrowserActivity), FileBrowserActivity.this.f208108j0);
                LiuHaiUtils.closeFullScreen(FileBrowserActivity.this);
                FileBrowserActivity.this.getWindow().setFlags(0, 1024);
                return;
            }
            FileBrowserActivity fileBrowserActivity2 = FileBrowserActivity.this;
            fileBrowserActivity2.g3(SystemBarActivityModule.getSystemBarComp(fileBrowserActivity2), FileBrowserActivity.this.f208108j0);
            V2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            FileBrowserActivity fileBrowserActivity3 = FileBrowserActivity.this;
            fileBrowserActivity3.f208120v0 = fileBrowserActivity3.f208113o0.u();
            if (FileBrowserActivity.this.f208120v0 != 2 || !ScreenUtil.checkNavigationBarShow(FileBrowserActivity.this)) {
                LiuHaiUtils.resetFullScreen(FileBrowserActivity.this);
            }
            FileBrowserActivity.this.getWindow().setFlags(1024, 1024);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        @TargetApi(5)
        public void onReceive(Context context, Intent intent) {
            if ("com.tencent.qlink.destory.fmactivity".equalsIgnoreCase(intent.getAction())) {
                FileBrowserActivity.this.finish();
                FileBrowserActivity.this.overridePendingTransition(0, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d implements ha1.a {
        d() {
        }

        @Override // ha1.a
        public void onColorNoteAnimFinish() {
            FileBrowserActivity.super.finish();
            FileBrowserActivity.this.overridePendingTransition(0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class e extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f208133d;

        e(int i3) {
            this.f208133d = i3;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            FileBrowserManager fileBrowserManager;
            if (motionEvent != null && motionEvent2 != null) {
                float x16 = motionEvent.getX() - motionEvent2.getX();
                float abs = Math.abs((motionEvent.getY() - motionEvent2.getY()) / x16);
                if (x16 <= (-this.f208133d) && abs < 0.5f && (fileBrowserManager = FileBrowserActivity.this.f208113o0) != null && fileBrowserManager.x()) {
                    return FileBrowserActivity.this.onBackEvent();
                }
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class f implements Action1<Boolean> {
        f() {
        }

        @Override // rx.functions.Action1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Boolean bool) {
            if (!FileBrowserActivity.this.f208122x0 && bool.booleanValue()) {
                com.tencent.mobileqq.tbstool.gray.b.f291450a.e(FileBrowserActivity.this.U2()).d(FileBrowserActivity.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class g implements Action1<Boolean> {
        g() {
        }

        @Override // rx.functions.Action1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Boolean bool) {
            int i3;
            if (!FileBrowserActivity.this.f208122x0) {
                ImageView imageView = FileBrowserActivity.this.f208102d0;
                if (bool.booleanValue()) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                imageView.setVisibility(i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class h implements Action1<Boolean> {
        h() {
        }

        @Override // rx.functions.Action1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Boolean bool) {
            int i3;
            if (!FileBrowserActivity.this.f208122x0) {
                ImageView imageView = FileBrowserActivity.this.f208102d0;
                if (bool.booleanValue()) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                imageView.setVisibility(i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class i implements Action1<Boolean> {
        i() {
        }

        @Override // rx.functions.Action1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Boolean bool) {
            if (bool.booleanValue() && !FileBrowserActivity.this.f208122x0) {
                FileBrowserActivity.this.f208113o0.L();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static final class j {

        /* renamed from: a, reason: collision with root package name */
        private final Object f208139a;

        /* renamed from: b, reason: collision with root package name */
        private final Class f208140b;

        public j(Object obj, Class cls) {
            this.f208139a = obj;
            this.f208140b = cls;
        }

        Object a() {
            return this.f208139a;
        }

        Class b() {
            return this.f208140b;
        }
    }

    private void T2() {
        RelativeLayout V2 = V2();
        if (V2 == null) {
            return;
        }
        b3(V2.getParent(), "clearChildFocus", new j(V2, View.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String U2() {
        ForwardFileInfo forwardFileInfo = this.f208107i0;
        if (forwardFileInfo == null) {
            return "";
        }
        return forwardFileInfo.f();
    }

    private void W2() {
        IColorNoteController iColorNoteController = (IColorNoteController) QRoute.api(IColorNoteController.class);
        this.f208119u0 = iColorNoteController;
        iColorNoteController.init(this, !com.tencent.mobileqq.tbstool.gray.b.f291450a.g(U2()), true);
        this.f208119u0.setServiceInfo(this.f208113o0.r());
        this.f208119u0.attachToActivity(this);
        this.f208119u0.setOnColorNoteAnimFinishListener(new d());
        boolean g16 = this.f208113o0.g();
        if (!g16) {
            this.f208119u0.disablePostTable();
        } else {
            this.f208119u0.enablePostTable();
        }
        if (QLog.isColorLevel()) {
            QLog.i("FileBrowserActivity<FileAssistant>", 2, "initColorNoteController: checkShowFileColorNote[" + g16 + "]");
        }
    }

    private void Y2() {
        GestureDetector gestureDetector = new GestureDetector((Context) null, new e(getResources().getDisplayMetrics().widthPixels / 6));
        this.f208111m0 = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
    }

    private void Z2() {
        if (!com.tencent.mobileqq.tbstool.gray.b.f291450a.g(U2())) {
            return;
        }
        setTheme(android.R.style.Theme.Black);
    }

    private void b3(Object obj, String str, j... jVarArr) {
        Class<?>[] clsArr;
        Object[] objArr;
        if (obj == null) {
            return;
        }
        try {
            if (jVarArr == null) {
                clsArr = new Class[0];
            } else {
                clsArr = new Class[jVarArr.length];
            }
            if (jVarArr == null) {
                objArr = new Object[0];
            } else {
                objArr = new Object[jVarArr.length];
            }
            if (jVarArr != null) {
                int length = clsArr.length;
                for (int i3 = 0; i3 < length; i3++) {
                    clsArr[i3] = jVarArr[i3].b();
                    objArr[i3] = jVarArr[i3].a();
                }
            }
            Method declaredMethod = obj.getClass().getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(obj, objArr);
        } catch (Throwable unused) {
        }
    }

    private void e3() {
        int i3;
        if (!h3() || TextUtils.isEmpty(this.f208115q0) || (i3 = this.f208116r0) == 0) {
            return;
        }
        String str = this.f208115q0;
        int S = QFileUtils.S(i3);
        if (S == -1) {
            return;
        }
        FileBrowserMiniAIOHelper fileBrowserMiniAIOHelper = this.f208117s0;
        if (fileBrowserMiniAIOHelper != null) {
            fileBrowserMiniAIOHelper.d();
        }
        MiniChatActivity.Q2(this, S, str, ac.R(this.app, str, S));
    }

    private void f3() {
        if (d3()) {
            if (QLog.isColorLevel()) {
                QLog.w("FileBrowserActivity<FileAssistant>", 2, "registerQlinkFinishFMReceiver");
            }
            if (this.B0 == null) {
                this.B0 = new c();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.tencent.qlink.destory.fmactivity");
                this.app.getApp().registerReceiver(this.B0, intentFilter);
            }
        }
    }

    private boolean h3() {
        int i3 = this.f208116r0;
        if (i3 == 1 || i3 == 2 || i3 == 5 || i3 == 6 || i3 == 3 || i3 == 13 || i3 == 4) {
            return true;
        }
        return false;
    }

    private void i3() {
        if (this.B0 != null) {
            this.app.getApp().unregisterReceiver(this.B0);
            this.B0 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j3() {
        IColorNoteController iColorNoteController = this.f208119u0;
        if (iColorNoteController != null) {
            iColorNoteController.setServiceInfo(this.f208113o0.r());
            boolean g16 = this.f208113o0.g();
            if (!g16) {
                this.f208119u0.disablePostTable();
            } else {
                this.f208119u0.enablePostTable();
            }
            if (QLog.isColorLevel()) {
                QLog.i("FileBrowserActivity<FileAssistant>", 2, "updateColorNoteController: checkShowFileColorNote[" + g16 + "]");
            }
        }
    }

    private void l3() {
        FileBrowserManager fileBrowserManager = this.f208113o0;
        if (fileBrowserManager == null) {
            return;
        }
        if (fileBrowserManager != null) {
            final String t16 = fileBrowserManager.t();
            if (TextUtils.isEmpty(t16)) {
                QLog.i("FileBrowserActivity<FileAssistant>", 1, "updateTitleBar,but file name is empty.");
                return;
            }
            this.f208100b0.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity.6
                @Override // java.lang.Runnable
                public void run() {
                    String str = (String) TextUtils.ellipsize(t16, FileBrowserActivity.this.f208100b0.getPaint(), FileBrowserActivity.this.f208100b0.getMeasuredWidth() - 15, TextUtils.TruncateAt.END);
                    if (str.length() > 2 && str.substring(str.length() - 1).equals(com.tencent.mobileqq.filemanager.data.e.f207754m)) {
                        str = str.substring(0, str.length() - 1) + com.tencent.mobileqq.filemanager.data.e.f207752k;
                    }
                    FileBrowserActivity.this.f208100b0.setText(str);
                }
            });
        }
        int S = QFileUtils.S(this.f208116r0);
        if (!TextUtils.isEmpty(this.f208115q0) && S != -1 && h3() && this.f208113o0.f() && !this.f208113o0.y()) {
            this.f208117s0 = new FileBrowserMiniAIOHelper(this.app, this.f208115q0);
            this.f208117s0.b((ImageView) findViewById(R.id.d3q));
            this.f208104f0.setVisibility(0);
            this.f208103e0.setVisibility(0);
            this.f208103e0.d(0, this.f208105g0, false);
            this.f208103e0.setOnClickListener(this);
            DynamicAvatarView dynamicAvatarView = this.f208105g0;
            QQAppInterface qQAppInterface = this.app;
            dynamicAvatarView.setImageDrawable(FaceDrawable.getFaceDrawable(qQAppInterface, QFileUtils.M(qQAppInterface, S, this.f208115q0), this.f208115q0));
            this.f208103e0.setContentDescription("\u5feb\u6377\u804a\u5929");
        } else {
            this.f208104f0.setVisibility(8);
            this.f208103e0.setVisibility(8);
        }
        this.f208113o0.J(new g());
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.g
    public void K1() {
        FileBrowserManager fileBrowserManager = this.f208113o0;
        if (fileBrowserManager == null) {
            QLog.e("FileBrowserActivity<FileAssistant>", 1, "updateMenu but mFileBrowserManager is null!");
        } else {
            fileBrowserManager.M();
            this.f208113o0.J(new h());
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.g
    public boolean N() {
        return this.f208109k0;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.g
    public void P0() {
        finish();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.g
    public void R1() {
        FileBrowserManager fileBrowserManager = this.f208113o0;
        if (fileBrowserManager == null) {
            return;
        }
        fileBrowserManager.J(new i());
    }

    @TargetApi(14)
    protected boolean S2(Intent intent) {
        com.tencent.mobileqq.filemanager.fileviewer.e eVar = new com.tencent.mobileqq.filemanager.fileviewer.e(this.app);
        String str = this.f208099a0;
        if (str != null && str.trim().length() != 0) {
            eVar.s(this.f208099a0);
        }
        if (!eVar.i(intent)) {
            return false;
        }
        int intExtra = intent.getIntExtra("file_enter_file_browser_type", 0);
        if (this.f208113o0 == null) {
            FileBrowserManager fileBrowserManager = new FileBrowserManager(this, this, eVar.e(this));
            this.f208113o0 = fileBrowserManager;
            fileBrowserManager.I(this.f208124z0);
            this.f208113o0.H(intExtra);
        }
        QLog.d("fileBrowser", 1, "browse file use old fileBrowser, entrance " + intExtra);
        if (!this.f208113o0.h(V2(), new RelativeLayout.LayoutParams(-1, -1), intExtra, intent.getBundleExtra("file_browser_extra_params"))) {
            if (QLog.isColorLevel()) {
                QLog.w("FileBrowserActivity<FileAssistant>", 2, "error. can not create a fileviewer from FileBrowserManager");
            }
            return false;
        }
        if (!AppSetting.o(this) && this.f208113o0.v()) {
            setRequestedOrientation(1);
        }
        return true;
    }

    public RelativeLayout V2() {
        return (RelativeLayout) findViewById(R.id.c_o);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.g
    public void b(boolean z16) {
        int i3;
        View findViewById = findViewById(R.id.ibf);
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        findViewById.setVisibility(i3);
    }

    public boolean c3() {
        return this.f208114p0;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.g
    public void d(View view) {
        com.tencent.mobileqq.tbstool.gray.b.f291450a.e(U2()).h(this, this.f208113o0.w());
        this.f208113o0.J(new f());
    }

    public boolean d3() {
        if (!getIntent().getBooleanExtra("from_qlink", false) && !getIntent().getBooleanExtra("from_qlink_enter_recent", false)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        if (QLog.isColorLevel()) {
            QLog.d("forward", 2, "FileBrowserAct doOnActivityResult resultCode=" + i16 + "mForwardType=" + this.f208112n0);
        }
        if (i16 == 4) {
            if (this.f208106h0 == null) {
                com.tencent.mobileqq.filemanager.fileviewer.f fVar = new com.tencent.mobileqq.filemanager.fileviewer.f();
                this.f208106h0 = fVar;
                fVar.a(getIntent());
            }
            if (this.f208106h0.b() && intent != null && intent.getExtras() != null) {
                Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this), new int[]{2});
                m3.putExtras(new Bundle(intent.getExtras()));
                startActivity(m3);
            }
            setResult(4, intent);
            finish();
            return;
        }
        if (i3 == 14002) {
            QLog.d("FileBrowserActivity<FileAssistant>", 2, "FileBrowserAct finish for doc mini program ");
            finish();
        } else {
            FileBrowserManager fileBrowserManager = this.f208113o0;
            if (fileBrowserManager != null) {
                fileBrowserManager.C(i3, i16, intent);
            }
            super.doOnActivityResult(i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnConfigurationChanged(Configuration configuration) {
        super.doOnConfigurationChanged(configuration);
        FileBrowserManager fileBrowserManager = this.f208113o0;
        if (fileBrowserManager != null) {
            fileBrowserManager.D(configuration);
            if (!AppSetting.o(this) && this.f208113o0.v()) {
                setRequestedOrientation(-1);
                this.A0 = !this.A0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    @TargetApi(14)
    public boolean doOnCreate(Bundle bundle) {
        int i3;
        FileBrowserManager fileBrowserManager;
        boolean z16;
        getWindow().setSoftInputMode(48);
        Intent intent = getIntent();
        this.f208107i0 = (ForwardFileInfo) intent.getParcelableExtra("fileinfo");
        Z2();
        this.mActNeedImmersive = true;
        this.mNeedStatusTrans = true;
        ca.a(this);
        super.doOnCreate(bundle);
        LiuHaiUtils.enableNotch(this);
        this.f208116r0 = intent.getIntExtra("file_enter_file_browser_type", 0);
        String configValue = ((IFMConfig) QRoute.api(IFMConfig.class)).getConfigValue(this.app.getApplication().getBaseContext(), "OnlinePreView", "RotateScreen", "FunctionalSwitch");
        if (configValue != null) {
            try {
                i3 = Integer.parseInt(configValue);
            } catch (NumberFormatException unused) {
                if (QLog.isDevelopLevel()) {
                    QLog.i("FileBrowserActivity<FileAssistant>", 4, "can not format FMConfig value to integer");
                }
                i3 = 0;
            }
            if (1 == i3 && !AppSetting.o(this)) {
                setRequestedOrientation(-1);
            }
        }
        this.f208099a0 = intent.getStringExtra("c2c_discussion_recentfile");
        this.f208115q0 = intent.getStringExtra("file_browser_extra_params_uin");
        this.f208121w0 = intent.getIntExtra(IFileBrowserService.STRING_BROWSE_ID, 0);
        ForwardFileInfo forwardFileInfo = this.f208107i0;
        if (forwardFileInfo == null) {
            finish();
            return false;
        }
        int type = forwardFileInfo.getType();
        this.f208112n0 = type;
        if (10004 == type) {
            this.f208109k0 = true;
            FileManagerReporter.addData("0X8004BB3");
        } else {
            FileManagerReporter.addData("0X8004BC8");
        }
        if (intent.getBooleanExtra("_from_aio_", false)) {
            this.f208109k0 = true;
        }
        if (intent.getBooleanExtra("key_is_from_lite", false)) {
            this.f208114p0 = true;
        }
        LiuHaiUtils.initLiuHaiProperty(this);
        setContentViewNoTitle(R.layout.amo);
        initTitleBar();
        QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "createFromIntent intent" + intent);
        if (S2(intent) && (fileBrowserManager = this.f208113o0) != null) {
            this.f208120v0 = fileBrowserManager.u();
            W2();
            l3();
            FileManagerReporter.addData("0X8004C01");
            f3();
            Y2();
            String configuration = getResources().getConfiguration().toString();
            if (!configuration.contains("hwMultiwindow-magic") && !configuration.contains("hw-magic-windows")) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (ImmersiveUtils.isSupporImmersive() == 1 && !z16) {
                RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.iep);
                relativeLayout.setFitsSystemWindows(true);
                relativeLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
            }
            if (!FileManagerUtil.is2GOr3G()) {
                Intent intent2 = new Intent(this, (Class<?>) WebProcessReceiver.class);
                intent2.setAction(com.tencent.qqmini.miniapp.receiver.WebProcessReceiver.ACTION_DOWNLOAD_TBS);
                sendBroadcast(intent2, "com.tencent.msg.permission.pushnotify");
            }
            init(intent);
            if (this.f208108j0 && ImmersiveUtils.isSupporImmersive() == 1) {
                RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.jqf);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout2.getLayoutParams();
                layoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(this);
                relativeLayout2.setLayoutParams(layoutParams);
            }
            if (!com.tencent.mobileqq.tbstool.gray.b.f291450a.g(U2())) {
                return true;
            }
            FileBrowserManager fileBrowserManager2 = this.f208113o0;
            if (fileBrowserManager2 != null) {
                fileBrowserManager2.j(getIntent());
            }
            ((ITBSToolApi) QRoute.api(ITBSToolApi.class)).startWatchTopActivity(this);
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.i("FileBrowserActivity<FileAssistant>", 2, "create FileBrowserView failed");
        }
        finish();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        this.f208122x0 = true;
        if (QLog.isColorLevel() && !isFinishing()) {
            QLog.i("FileBrowserActivity<FileAssistant>", 2, "FileBrowserActivity is called doOnDestroy But not finished!");
        }
        T2();
        i3();
        if (this.f208119u0 != null) {
            FileBrowserManager fileBrowserManager = this.f208113o0;
            if (fileBrowserManager != null && fileBrowserManager.g()) {
                this.f208119u0.addHistoryNote();
            }
            this.f208119u0.onDestroy();
        }
        FileBrowserManager fileBrowserManager2 = this.f208113o0;
        if (fileBrowserManager2 != null) {
            fileBrowserManager2.k();
        }
        FileBrowserMiniAIOHelper fileBrowserMiniAIOHelper = this.f208117s0;
        if (fileBrowserMiniAIOHelper != null) {
            fileBrowserMiniAIOHelper.c();
        }
        if (this.f208121w0 > 0) {
            ((IFileBrowserService) QRoute.api(IFileBrowserService.class)).onDestroy(this.f208121w0);
        }
        FileImporter.f291396a.i();
        ((ITBSToolApi) QRoute.api(ITBSToolApi.class)).stopWatchTopActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        AbstractGifImage.pauseAll();
        ApngImage.pauseAll();
        FileBrowserManager fileBrowserManager = this.f208113o0;
        if (fileBrowserManager != null) {
            fileBrowserManager.l();
        }
        FileBrowserMiniAIOHelper fileBrowserMiniAIOHelper = this.f208117s0;
        if (fileBrowserMiniAIOHelper != null) {
            fileBrowserMiniAIOHelper.e();
        }
        IColorNoteController iColorNoteController = this.f208119u0;
        if (iColorNoteController != null) {
            iColorNoteController.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        AbstractGifImage.resumeAll();
        ApngImage.playByTag(0);
        FileBrowserManager fileBrowserManager = this.f208113o0;
        if (fileBrowserManager != null) {
            fileBrowserManager.m();
        }
        FileBrowserMiniAIOHelper fileBrowserMiniAIOHelper = this.f208117s0;
        if (fileBrowserMiniAIOHelper != null) {
            fileBrowserMiniAIOHelper.f();
        }
        IColorNoteController iColorNoteController = this.f208119u0;
        if (iColorNoteController != null) {
            iColorNoteController.onResume();
        }
        super.doOnResume();
        FileBrowserManager fileBrowserManager2 = this.f208113o0;
        if (fileBrowserManager2 != null) {
            fileBrowserManager2.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        super.doOnStart();
        FileBrowserManager fileBrowserManager = this.f208113o0;
        if (fileBrowserManager != null) {
            fileBrowserManager.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        super.doOnStop();
        FileBrowserManager fileBrowserManager = this.f208113o0;
        if (fileBrowserManager != null) {
            fileBrowserManager.o();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IColorNoteController iColorNoteController = this.f208119u0;
        if (iColorNoteController != null) {
            iColorNoteController.exitAnimation();
        } else {
            super.finish();
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.g
    public boolean g2() {
        IColorNoteController iColorNoteController = this.f208119u0;
        if (iColorNoteController != null) {
            return iColorNoteController.isColorNoteExist();
        }
        return false;
    }

    void g3(SystemBarCompact systemBarCompact, boolean z16) {
        if (z16) {
            if (ImmersiveUtils.isSupporImmersive() == 1 && systemBarCompact != null) {
                systemBarCompact.setStatusColor(0);
                systemBarCompact.setStatusBarColor(0);
                if (ThemeUtil.isDefaultOrDIYTheme(false)) {
                    systemBarCompact.setStatusBarDrawable(null);
                    return;
                }
                return;
            }
            return;
        }
        if (ImmersiveUtils.isSupporImmersive() == 1 && systemBarCompact != null) {
            int color = getResources().getColor(R.color.qui_common_bg_nav_secondary);
            systemBarCompact.setStatusColor(color);
            systemBarCompact.setStatusBarColor(color);
            if (ThemeUtil.isDefaultOrDIYTheme(false)) {
                systemBarCompact.setStatusBarDrawable(getResources().getDrawable(R.drawable.qui_bg_nav_secondary));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public IActivityModuleProvider getActivityModuleProvider() {
        return new a();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.g
    public void h2() {
        r2(false);
    }

    public void initTitleBar() {
        ((TextView) findViewById(R.id.dto)).setVisibility(8);
        ImageView imageView = (ImageView) findViewById(R.id.ivTitleBtnRightImage);
        this.f208102d0 = imageView;
        imageView.setImageResource(R.drawable.header_btn_more);
        this.f208102d0.setVisibility(8);
        this.f208102d0.setContentDescription(HardCodeUtil.qqStr(R.string.mhs));
        this.f208102d0.setOnClickListener(this);
        TextView textView = (TextView) findViewById(R.id.ivTitleBtnLeft);
        this.f208101c0 = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) findViewById(R.id.ivTitleName);
        this.f208100b0 = textView2;
        textView2.setTextSize(1, 19.0f);
        this.f208100b0.setOnClickListener(this);
        this.f208103e0 = (AvatarLayout) findViewById(R.id.head);
        this.f208105g0 = (DynamicAvatarView) findViewById(R.id.a6e);
        this.f208104f0 = (RelativeLayout) findViewById(R.id.f165675d35);
        if (TokenResUtils.useTokenRes3()) {
            this.f208101c0.setBackgroundResource(R.drawable.qui_chevron_left_icon_navigation_01_selector);
            int dip2px = ViewUtils.dip2px(24.0f);
            ViewGroup.LayoutParams layoutParams = this.f208101c0.getLayoutParams();
            this.f208101c0.setMinWidth(dip2px);
            layoutParams.width = dip2px;
            layoutParams.height = dip2px;
            this.f208102d0.setImageResource(R.drawable.qui_more_icon_navigation_01_selector);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.g
    public boolean isFullScreen() {
        return this.f208108j0;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        return false;
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    protected boolean onBackEvent() {
        boolean onBackEvent = super.onBackEvent();
        FileBrowserManager fileBrowserManager = this.f208113o0;
        if (fileBrowserManager != null) {
            fileBrowserManager.i();
        }
        return onBackEvent;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.ivTitleBtnRightImage) {
            if (this.f208123y0.c(1000L)) {
                QLog.d("FileBrowserActivity<FileAssistant>", 1, "show menu fast click forbid");
            } else {
                this.f208113o0.L();
            }
        } else if (id5 == R.id.ivTitleBtnLeft) {
            onBackEvent();
        } else if (id5 == R.id.head) {
            e3();
        } else if (id5 == R.id.ivTitleName) {
            long[] jArr = this.f208118t0;
            System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
            long[] jArr2 = this.f208118t0;
            jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
            long j3 = this.f208118t0[0];
            SystemClock.uptimeMillis();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ForwardFileInfo forwardFileInfo = (ForwardFileInfo) getIntent().getParcelableExtra("fileinfo");
        if (forwardFileInfo == null || !com.tencent.mobileqq.tbstool.gray.b.f291450a.g(forwardFileInfo.f())) {
            return;
        }
        FileImporter.f291396a.h(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, com.tencent.mobileqq.app.ISkinCallback, com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPostThemeChanged() {
        super.onPostThemeChanged();
        FileBrowserManager fileBrowserManager = this.f208113o0;
        if (fileBrowserManager != null) {
            fileBrowserManager.p();
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.g
    public void r2(final boolean z16) {
        if (isFinishing()) {
            return;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity.5

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity$5$a */
            /* loaded from: classes12.dex */
            class a implements Action1<Boolean> {
                a() {
                }

                @Override // rx.functions.Action1
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void call(Boolean bool) {
                    int i3;
                    if (!FileBrowserActivity.this.f208122x0) {
                        ImageView imageView = FileBrowserActivity.this.f208102d0;
                        if (bool.booleanValue()) {
                            i3 = 0;
                        } else {
                            i3 = 8;
                        }
                        imageView.setVisibility(i3);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                FileBrowserActivity fileBrowserActivity = FileBrowserActivity.this;
                fileBrowserActivity.f208113o0.B(fileBrowserActivity.V2(), new ViewGroup.LayoutParams(-1, -1), z16);
                FileBrowserActivity.this.j3();
                FileBrowserActivity.this.f208113o0.J(new a());
            }
        });
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.g
    public boolean s() {
        IColorNoteController iColorNoteController = this.f208119u0;
        if (iColorNoteController != null && !iColorNoteController.isColorNoteExist()) {
            if (this.f208119u0.canAddColorNote()) {
                this.f208119u0.insertColorNote();
                return true;
            }
            this.f208119u0.onCannotAdd();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.g
    public boolean shouldDisplayColorNote() {
        IColorNoteController iColorNoteController = this.f208119u0;
        if (iColorNoteController != null) {
            return iColorNoteController.shouldDisplayColorNote();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.g
    public void t2() {
        IColorNoteController iColorNoteController = this.f208119u0;
        if (iColorNoteController != null && iColorNoteController.isColorNoteExist()) {
            this.f208119u0.deleteColorNote();
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends DefaultActivityModuleProvider {
        a() {
        }

        @Override // com.tencent.mobileqq.app.activitymodule.DefaultActivityModuleProvider
        protected IActivityModule getSystemBarModule() {
            return new C7559a();
        }

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity$a$a, reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        class C7559a extends SystemBarActivityModule {
            C7559a() {
            }

            @Override // com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule, com.tencent.mobileqq.app.activitymodule.ISystemBar
            public void initNavigationBarColor() {
            }
        }
    }
}
