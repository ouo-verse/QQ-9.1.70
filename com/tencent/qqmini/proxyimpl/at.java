package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.colornote.ColorNoteCurd;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.swipe.PostTable;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.launch.MiniSdkLauncher;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.util.AnimUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import mqq.util.WeakReference;

/* compiled from: P */
@ProxyService(proxy = PageGestureProxy.class)
/* loaded from: classes34.dex */
public class at implements PageGestureProxy, com.tencent.mobileqq.colornote.f {
    private com.tencent.mobileqq.colornote.f C;
    private QQCustomDialog D;
    private Vibrator F;
    private boolean G;
    private MiniAppInfo H;
    private IMiniAppContext I;

    /* renamed from: d, reason: collision with root package name */
    protected IColorNoteController f347816d;

    /* renamed from: e, reason: collision with root package name */
    public PostTable f347817e;

    /* renamed from: h, reason: collision with root package name */
    private WeakReference<Activity> f347819h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.mobileqq.colornote.swipe.d f347820i;

    /* renamed from: m, reason: collision with root package name */
    private ColorNoteCurd f347821m;

    /* renamed from: f, reason: collision with root package name */
    private boolean f347818f = false;
    private boolean E = true;
    private String J = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class a implements ha1.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference f347822a;

        a(WeakReference weakReference) {
            this.f347822a = weakReference;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ha1.a
        public void onColorNoteAnimFinish() {
            Activity activity = (Activity) this.f347822a.get();
            if (activity == null) {
                return;
            }
            if (at.this.H != null && at.this.H.isInternalApp()) {
                activity.finish();
            }
            AnimUtil.clearAnim(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class b extends com.tencent.mobileqq.colornote.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference f347824a;

        b(WeakReference weakReference) {
            this.f347824a = weakReference;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.colornote.g
        public void onAddColorNote(Bundle bundle, boolean z16) {
            super.onAddColorNote(bundle, z16);
            Activity activity = (Activity) this.f347824a.get();
            if (activity == null) {
                return;
            }
            if (at.this.H != null && at.this.H.isInternalApp()) {
                activity.finish();
            } else {
                activity.moveTaskToBack(true);
            }
        }

        @Override // com.tencent.mobileqq.colornote.g
        public void onDeleteColorNote(int i3, String str, boolean z16) {
            super.onDeleteColorNote(i3, str, z16);
            MiniAppConfig miniAppConfig = at.this.H != null ? new MiniAppConfig(MiniSdkLauncher.convert(at.this.H)) : null;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                if (miniAppConfig != null) {
                    MiniProgramLpReportDC04239.reportAsync(miniAppConfig, "addRecentColorSign", "recentColorSign_enter", "remove_ColorSign", null);
                    return;
                } else {
                    MiniProgramLpReportDC04239.reportAsync("addRecentColorSign", "recentColorSign_enter", "remove_ColorSign", null);
                    return;
                }
            }
            if (miniAppConfig != null) {
                MiniProgramLpReportDC04239.reportAsync(miniAppConfig, "addColorSign", "colorSign_enter", "remove_ColorSign", null);
            } else {
                MiniProgramLpReportDC04239.reportAsync("addColorSign", "colorSign_enter", "remove_ColorSign", null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class c extends com.tencent.mobileqq.colornote.g {
        c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.colornote.g
        public void onAddColorNote(Bundle bundle, boolean z16) {
            Activity activity;
            super.onAddColorNote(bundle, z16);
            if (at.this.f347819h == null || (activity = (Activity) at.this.f347819h.get()) == null) {
                return;
            }
            activity.moveTaskToBack(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class d implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f347827d;

        d(Activity activity) {
            this.f347827d = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (at.this.D.isShowing()) {
                at.this.D.dismiss();
            }
            ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).showList(this.f347827d, true);
        }
    }

    private void d(Activity activity, long j3) {
        if (this.F == null) {
            this.F = (Vibrator) activity.getSystemService("vibrator");
        }
        this.F.vibrate(j3);
    }

    private void e() {
        WeakReference<Activity> weakReference = this.f347819h;
        if (weakReference == null) {
            return;
        }
        QQCustomDialog qQCustomDialog = this.D;
        if (qQCustomDialog == null) {
            Activity activity = weakReference.get();
            if (activity == null) {
                return;
            }
            QQCustomDialog qQCustomDialog2 = new QQCustomDialog(activity, R.style.qZoneInputDialog);
            this.D = qQCustomDialog2;
            qQCustomDialog2.setContentView(R.layout.f167856jn);
            this.D.setCanceledOnTouchOutside(false);
            this.D.setTitle(activity.getString(R.string.img));
            this.D.setNegativeButton(activity.getString(R.string.imf), new d(activity));
        } else if (qQCustomDialog.isShowing()) {
            this.D.dismiss();
        }
        this.D.show();
        TextView titleTextView = this.D.getTitleTextView();
        titleTextView.setClickable(true);
        titleTextView.setFocusable(true);
        titleTextView.setFocusableInTouchMode(true);
        AccessibilityUtil.n(titleTextView, true);
    }

    private ColorNote f() {
        com.tencent.mobileqq.colornote.f fVar = this.C;
        if (fVar != null) {
            return fVar.getColorNote();
        }
        return null;
    }

    private void h(Activity activity) {
        if (TextUtils.isEmpty(BaseApplicationImpl.getApplication().getRuntime().getAccount())) {
            QLog.e("PageGuestureProxyImpl", 1, "initColorNote() fail, because of null account");
            return;
        }
        IColorNoteController iColorNoteController = (IColorNoteController) QRoute.api(IColorNoteController.class);
        this.f347816d = iColorNoteController;
        iColorNoteController.init(activity, false, true);
        this.f347816d.attachToActivity(activity);
        this.f347816d.setServiceInfo(this);
        WeakReference weakReference = new WeakReference(activity);
        this.f347816d.setOnColorNoteAnimFinishListener(new a(weakReference));
        this.f347816d.setOnColorNoteCurdListener(new b(weakReference));
        this.f347817e = new PostTable(activity);
        ((ViewGroup) activity.getWindow().getDecorView()).addView(this.f347817e);
        this.f347817e.setVisibility(4);
        this.f347817e.b(0.0d);
    }

    private void i() {
        ColorNoteCurd colorNoteCurd = new ColorNoteCurd();
        this.f347821m = colorNoteCurd;
        colorNoteCurd.l(new c());
    }

    public IColorNoteController g() {
        return this.f347816d;
    }

    @Override // com.tencent.mobileqq.colornote.f
    public ColorNote getColorNote() {
        MiniAppInfo miniAppInfo = this.H;
        if (miniAppInfo == null) {
            return null;
        }
        if (this.I != null && TextUtils.isEmpty(this.J)) {
            this.J = ActionBridge.PageActionBridge.getPageUrl(this.I);
        }
        String str = this.J;
        return new ColorNote.a().g(android.R.attr.theme).i(miniAppInfo.appId + "#@#" + miniAppInfo.verType).d(miniAppInfo.name).f(str != null ? str.getBytes() : null).h(miniAppInfo.desc).e(miniAppInfo.iconUrl).a();
    }

    public void j(com.tencent.mobileqq.colornote.f fVar) {
        this.C = fVar;
        i();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy
    public void onActivityCreate(Activity activity) {
        this.f347819h = new WeakReference<>(activity);
        h(activity);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy
    public void onActivityDestroy(Activity activity) {
        IColorNoteController iColorNoteController = this.f347816d;
        if (iColorNoteController != null) {
            iColorNoteController.onDestroy();
            this.f347816d = null;
        }
        this.F = null;
        this.f347817e = null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy
    public void onActivityPause(Activity activity) {
        IColorNoteController iColorNoteController = this.f347816d;
        if (iColorNoteController != null) {
            iColorNoteController.onPause();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy
    public void onActivityResume(Activity activity) {
        IColorNoteController iColorNoteController = this.f347816d;
        if (iColorNoteController != null) {
            iColorNoteController.onResume();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy
    public void onCreateMiniAppInfo(MiniAppInfo miniAppInfo) {
        this.H = miniAppInfo;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy
    public void onMoveTaskToBack(Activity activity) {
        IColorNoteController iColorNoteController = this.f347816d;
        if (iColorNoteController == null || !iColorNoteController.isColorNoteExist()) {
            return;
        }
        this.f347816d.exitAnimation();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy
    public void onPageWebViewInit() {
        Activity activity;
        WeakReference<Activity> weakReference = this.f347819h;
        if (weakReference != null && (activity = weakReference.get()) != null) {
            this.f347820i = new com.tencent.mobileqq.colornote.swipe.d(activity);
        }
        i();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy
    public void updateColorSignPath(String str) {
        this.J = str;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy
    public void onActivityStop(Activity activity) {
        QLog.d("PageGuestureProxyImpl", 1, "onActivityStop");
        IColorNoteController iColorNoteController = this.f347816d;
        if (iColorNoteController != null) {
            iColorNoteController.onPause();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy
    public void onLoadUrl(IMiniAppContext iMiniAppContext) {
        if (iMiniAppContext != null) {
            this.I = iMiniAppContext;
            this.H = iMiniAppContext.getMiniAppInfo();
        }
        j(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00c5  */
    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onViewReleasedAndNeedScrollOriginPosition(MotionEvent motionEvent) {
        PostTable postTable;
        boolean z16 = true;
        QLog.d("PageGuestureProxyImpl", 1, "onViewReleased");
        MiniAppInfo miniAppInfo = this.H;
        if (miniAppInfo != null ? miniAppInfo.isLimitedAccessApp() : false) {
            return false;
        }
        ColorNote f16 = f();
        boolean j3 = f16 != null ? this.f347821m.j(f16.getServiceType(), f16.getSubType()) : false;
        this.E = true;
        WeakReference<Activity> weakReference = this.f347819h;
        Activity activity = weakReference != null ? weakReference.get() : null;
        com.tencent.mobileqq.colornote.swipe.d dVar = this.f347820i;
        if (dVar != null && dVar.b(motionEvent, activity) && !j3 && f16 != null) {
            if (this.f347821m.d()) {
                Bundle parseBundle = f16.parseBundle();
                parseBundle.putInt("color_note_curd_from_type", 1);
                this.f347821m.a(parseBundle);
                ReportController.o(null, "dc00898", "", "", "0X800A742", "0X800A742", com.tencent.mobileqq.colornote.a.b(this.C.getColorNote().mServiceType), 0, "", "", "", "");
            } else {
                PostTable postTable2 = this.f347817e;
                if (postTable2 != null) {
                    postTable2.b(0.0d);
                }
                e();
                ReportController.o(null, "dc00898", "", "", "0X800A6CF", "0X800A6CF", 1, 0, "", "", "", "");
                postTable = this.f347817e;
                if (postTable != null) {
                    postTable.setVisibility(4);
                    this.f347818f = false;
                }
                return z16;
            }
        }
        z16 = false;
        postTable = this.f347817e;
        if (postTable != null) {
        }
        return z16;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy
    public void onProcessTouchEvent(MotionEvent motionEvent) {
        com.tencent.mobileqq.colornote.swipe.d dVar;
        PostTable postTable;
        ColorNoteCurd colorNoteCurd = this.f347821m;
        if (colorNoteCurd == null || !colorNoteCurd.i() || (dVar = this.f347820i) == null || this.f347817e == null) {
            return;
        }
        double c16 = dVar.c(motionEvent);
        this.f347821m.d();
        ColorNote colorNote = this.C.getColorNote();
        boolean j3 = colorNote != null ? this.f347821m.j(colorNote.getServiceType(), colorNote.getSubType()) : false;
        MiniAppInfo miniAppInfo = this.H;
        boolean isLimitedAccessApp = miniAppInfo != null ? miniAppInfo.isLimitedAccessApp() : false;
        if (c16 > 0.0d && !j3 && !isLimitedAccessApp && this.f347819h != null) {
            if (!this.f347818f) {
                this.f347817e.setVisibility(0);
                this.f347818f = true;
            }
            Activity activity = this.f347819h.get();
            if (this.f347821m.d() && activity != null) {
                if (this.f347820i.b(motionEvent, activity)) {
                    this.f347817e.g();
                    if (!this.G) {
                        d(activity, 20L);
                        this.G = true;
                    }
                } else {
                    this.f347817e.i();
                    this.G = false;
                }
            } else {
                this.f347817e.h();
            }
            this.f347817e.b(c16);
            if (this.E) {
                ReportController.o(null, "dc00898", "", "", "0X800A741", "0X800A741", com.tencent.mobileqq.colornote.a.b(this.C.getColorNote().mServiceType), 0, "", "", "", "");
                this.E = false;
            }
        } else if (c16 < 1.0E-8d || j3) {
            this.f347817e.setVisibility(4);
            this.f347818f = false;
        }
        if (motionEvent.getActionMasked() != 1 || (postTable = this.f347817e) == null) {
            return;
        }
        postTable.setVisibility(4);
        this.f347818f = false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy
    public void onActivityFinish(Activity activity) {
    }
}
