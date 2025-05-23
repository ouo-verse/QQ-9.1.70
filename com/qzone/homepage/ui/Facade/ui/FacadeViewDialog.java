package com.qzone.homepage.ui.Facade.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import com.qzone.common.account.LoginData;
import com.qzone.homepage.ui.Facade.FacadeVideoDownLoaderManager;
import com.qzone.homepage.ui.Facade.h;
import com.qzone.homepage.ui.Facade.i;
import com.qzone.homepage.ui.Facade.model.DownloadableInfo;
import com.qzone.homepage.ui.Facade.model.FacadeCacheData;
import com.qzone.homepage.ui.Facade.model.FacadeViewData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FacadeViewDialog extends ReportDialog {
    private static final Boolean R = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qzone_use_transparent_navigation_bar", true));
    private final String C;
    private Context D;
    private long E;
    private ImageButton F;
    private ImageButton G;
    private FacadeView H;
    private FacadeCacheData I;
    private h J;
    private Handler K;
    private Runnable L;
    private View.OnClickListener M;
    private WeakReference<DialogInterface.OnDismissListener> N;
    private WeakReference<DialogInterface.OnCancelListener> P;
    private g Q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FacadeViewDialog.this.X();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements DialogInterface.OnCancelListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (QZLog.isDevelopLevel()) {
                QZLog.d(FacadeViewDialog.this.C, 4, "onCancel");
            }
            FacadeViewDialog.this.Y();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            int id5 = view.getId();
            if (id5 == R.id.a48) {
                FacadeViewDialog.this.Y();
            } else if (id5 == R.id.bxt || id5 == R.id.c0n) {
                FacadeViewDialog.this.X();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class e implements DialogInterface.OnDismissListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            DialogInterface.OnDismissListener onDismissListener;
            if (FacadeViewDialog.this.N == null || (onDismissListener = (DialogInterface.OnDismissListener) FacadeViewDialog.this.N.get()) == null) {
                return;
            }
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class f implements DialogInterface.OnCancelListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            DialogInterface.OnCancelListener onCancelListener;
            if (FacadeViewDialog.this.P == null || (onCancelListener = (DialogInterface.OnCancelListener) FacadeViewDialog.this.P.get()) == null) {
                return;
            }
            onCancelListener.onCancel(dialogInterface);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface g {
        void onEnter();
    }

    public FacadeViewDialog(Context context, int i3) {
        super(context, i3);
        this.C = FacadeViewDialog.class.getSimpleName();
        this.L = new Runnable() { // from class: com.qzone.homepage.ui.Facade.ui.FacadeViewDialog.4
            @Override // java.lang.Runnable
            public void run() {
                FacadeViewDialog.this.X();
            }
        };
        this.M = new d();
        this.D = context;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        try {
            if (isShowing()) {
                dismiss();
            }
        } catch (Exception e16) {
            QZLog.e(QZLog.TO_DEVICE_TAG, "facadeview goback:" + Log.getStackTraceString(e16));
        }
        Context context = this.D;
        if (context == null || !(context instanceof Activity)) {
            return;
        }
        ((Activity) context).finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(FacadeCacheData facadeCacheData) {
        try {
            l0(facadeCacheData);
        } catch (Throwable th5) {
            QLog.e(this.C, 1, "tryShowGuestFacade,error:", Log.getStackTraceString(th5));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(long j3) {
        final FacadeCacheData h16 = this.J.h(this.E);
        long currentTimeMillis = System.currentTimeMillis() - j3;
        if (currentTimeMillis >= 1000) {
            QLog.e(this.C, 1, "tryShowGuestFacade time out,cost:", Long.valueOf(currentTimeMillis), "ms,direct enter");
        } else {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.homepage.ui.Facade.ui.d
                @Override // java.lang.Runnable
                public final void run() {
                    FacadeViewDialog.this.Z(h16);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(final long j3) {
        this.I = this.J.h(this.E);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.homepage.ui.Facade.ui.c
            @Override // java.lang.Runnable
            public final void run() {
                FacadeViewDialog.this.b0(j3);
            }
        });
    }

    private void d0(boolean z16) {
        String videoBgUrl;
        boolean z17 = true;
        e0(this.I, true);
        this.H.setFacadeStyle(this.I.mFacadeStyle);
        if (z16) {
            this.H.setModeAsViewSelf();
        } else {
            this.H.setModeAsViewGuest();
        }
        FacadeCacheData facadeCacheData = this.I;
        ArrayList<FacadeViewData> arrayList = facadeCacheData.mFacadeViewDatas;
        if (arrayList != null) {
            arrayList.removeAll(Collections.singleton(null));
        }
        if (arrayList != null && arrayList.size() > 0) {
            if (h.p() && !TextUtils.isEmpty(facadeCacheData.getTransparentVideoBgUrl())) {
                videoBgUrl = facadeCacheData.getTransparentVideoBgUrl();
            } else {
                videoBgUrl = facadeCacheData.getVideoBgUrl();
                z17 = false;
            }
            this.H.a(i.a(arrayList.get(0).getConfigRect()), videoBgUrl, z17);
            DownloadableInfo customFileInfo = arrayList.get(0).getCustomFileInfo();
            if (customFileInfo != null) {
                this.H.setFacadeImage(customFileInfo.fileUrl, customFileInfo.imageHeight, customFileInfo.imageWidth);
            }
        }
        Handler handler = new Handler(Looper.getMainLooper());
        this.K = handler;
        handler.postDelayed(this.L, 3000L);
    }

    public static FacadeViewDialog f0(Activity activity) {
        return new FacadeViewDialog(activity, R.style.f243073);
    }

    private void init() {
        this.J = h.l();
        setContentView(R.layout.bku);
        this.H = (FacadeView) findViewById(R.id.c0n);
        this.F = (ImageButton) findViewById(R.id.a48);
        this.G = (ImageButton) findViewById(R.id.bxt);
        this.H.setJumpBySchemeAllow(true);
        this.H.setFixedJump(new a());
        this.H.setOnClickListener(this.M);
        this.F.setOnClickListener(this.M);
        this.F.setPadding(ImmersiveUtils.dpToPx(16.0f), ImmersiveUtils.getStatusBarHeight(getContext()) + ImmersiveUtils.dpToPx(16.0f), 0, 0);
        this.G.setOnClickListener(this.M);
        setOnCancelListener(new b());
        setOnKeyListener(new c());
    }

    private void j0(boolean z16) {
        if (this.I == null) {
            return;
        }
        d0(z16);
        o0();
        this.H.setVisibility(0);
    }

    private void k0() {
        String videoBgUrl;
        FacadeCacheData h16 = this.J.h(this.E);
        this.I = h16;
        if (h16 == null) {
            X();
            return;
        }
        if (h.p() && !TextUtils.isEmpty(this.I.getTransparentVideoBgUrl())) {
            videoBgUrl = this.I.getTransparentVideoBgUrl();
        } else {
            videoBgUrl = this.I.getVideoBgUrl();
        }
        boolean h17 = com.qzone.homepage.ui.Facade.f.h(this.I.getImageWithoutAvatarUrls(), h.l().i());
        if (!TextUtils.isEmpty(videoBgUrl) && !FacadeVideoDownLoaderManager.f(videoBgUrl) && !QZoneHelper.isInQzoneFacadeDynamicBlackList()) {
            h17 = false;
        }
        if (h17) {
            j0(true);
        } else {
            X();
        }
    }

    private void m0() {
        if (!xe.a.f447839a.d()) {
            l0(this.J.h(this.E));
        } else {
            final long currentTimeMillis = System.currentTimeMillis();
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.homepage.ui.Facade.ui.b
                @Override // java.lang.Runnable
                public final void run() {
                    FacadeViewDialog.this.a0(currentTimeMillis);
                }
            });
        }
    }

    private void n0() {
        if (!com.qzone.reborn.configx.g.f53821a.b().C()) {
            k0();
        } else {
            final long currentTimeMillis = System.currentTimeMillis();
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.homepage.ui.Facade.ui.a
                @Override // java.lang.Runnable
                public final void run() {
                    FacadeViewDialog.this.c0(currentTimeMillis);
                }
            });
        }
    }

    private void o0() {
        int i3 = this.I.mFacadeStyle;
        if (i3 == 1) {
            this.F.setImageResource(R.drawable.aye);
            this.G.setImageResource(R.drawable.ayg);
        } else if (i3 == 2) {
            this.F.setImageResource(R.drawable.ayd);
            this.G.setImageResource(R.drawable.ayf);
        }
        this.F.setVisibility(0);
        this.G.setVisibility(0);
    }

    public void X() {
        Context context = this.D;
        if (context == null || !(context instanceof Activity)) {
            return;
        }
        try {
            ((Activity) context).getWindow().clearFlags(1024);
            if (isShowing()) {
                g gVar = this.Q;
                this.Q = null;
                if (gVar != null) {
                    gVar.onEnter();
                }
                dismiss();
            }
        } catch (Exception e16) {
            QZLog.e(QZLog.TO_DEVICE_TAG, "facadeview enter" + e16.toString());
        }
    }

    public void g0(g gVar) {
        this.Q = gVar;
    }

    public void i0(long j3) {
        this.E = j3;
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        try {
            Window window = getWindow();
            if (window != null) {
                window.setFlags(8, 8);
                if (R.booleanValue()) {
                    window.addFlags(Integer.MIN_VALUE);
                    window.setNavigationBarColor(0);
                }
            }
            super.show();
            if (getWindow() != null) {
                getWindow().clearFlags(8);
            }
            if (this.E == LoginData.getInstance().getUin()) {
                n0();
            } else {
                m0();
            }
            QUIImmersiveHelper.u(getWindow(), true, true);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog, android.app.Dialog
    protected void onStop() {
        try {
            setOnCancelListener(null);
        } catch (Throwable th5) {
            QZLog.e(QZLog.TO_DEVICE_TAG, "facadeview onStop:" + Log.getStackTraceString(th5));
        }
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements DialogInterface.OnKeyListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
            if (i3 != 4) {
                return false;
            }
            if (QZLog.isDevelopLevel()) {
                QZLog.d(FacadeViewDialog.this.C, 4, "onKey keyCode==KeyEvent.KEYCODE_BACK");
            }
            FacadeViewDialog.this.Y();
            return true;
        }
    }

    private void e0(FacadeCacheData facadeCacheData, boolean z16) {
        if (facadeCacheData == null || facadeCacheData.mFacadeViewDatas == null || facadeCacheData.mFacadeViewDatas.size() == 0 || facadeCacheData.mFacadeViewDatas.get(0) == null) {
            return;
        }
        this.H.setCanVisit(z16);
    }

    private void l0(FacadeCacheData facadeCacheData) {
        String videoBgUrl;
        if (facadeCacheData != null && facadeCacheData.mFacadeViewDatas != null) {
            this.I = facadeCacheData;
            boolean h16 = com.qzone.homepage.ui.Facade.f.h(facadeCacheData.getImageWithoutAvatarUrls(), h.l().i());
            if (h.p() && !TextUtils.isEmpty(this.I.getTransparentVideoBgUrl())) {
                videoBgUrl = this.I.getTransparentVideoBgUrl();
            } else {
                videoBgUrl = this.I.getVideoBgUrl();
            }
            if (!TextUtils.isEmpty(videoBgUrl) && !FacadeVideoDownLoaderManager.f(videoBgUrl) && !QZoneHelper.isInQzoneFacadeDynamicBlackList()) {
                h16 = false;
            }
            if (h16) {
                j0(false);
                return;
            } else {
                X();
                return;
            }
        }
        X();
    }

    @Override // android.app.Dialog
    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        if (onCancelListener == null) {
            super.setOnCancelListener(onCancelListener);
        } else {
            this.P = new WeakReference<>(onCancelListener);
            super.setOnCancelListener(new f());
        }
    }

    @Override // android.app.Dialog
    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener == null) {
            super.setOnDismissListener(onDismissListener);
        } else {
            this.N = new WeakReference<>(onDismissListener);
            super.setOnDismissListener(new e());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(long j3) {
        try {
            k0();
            QLog.d(this.C, 1, "tryShowHostFacade timeCost:", Long.valueOf(System.currentTimeMillis() - j3), "ms");
        } catch (Throwable th5) {
            QLog.e(this.C, 1, "tryShowHostFacade,error:", Log.getStackTraceString(th5));
        }
    }
}
