package com.tencent.mobileqq.vas.manager.api.impl;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.mobileqq.vas.manager.api.IThemeSwitchManager;
import com.tencent.mobileqq.vas.theme.ThemeVipBehavior;
import com.tencent.mobileqq.vas.theme.diy.ThemeDiyStyleLogic;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.ui.IVasPagViewApi;
import com.tencent.mobileqq.vas.ui.VasPagView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import com.tencent.util.LoadingUtil;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.libpag.PAGFile;
import org.libpag.PAGImage;
import org.libpag.PAGView;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ThemeSwitchManagerImpl implements IThemeSwitchManager {
    private static final int D;

    /* renamed from: d, reason: collision with root package name */
    WeakReference<Dialog> f310001d;

    /* renamed from: e, reason: collision with root package name */
    public ThemeDiyStyleLogic.StyleCallBack f310002e;

    /* renamed from: f, reason: collision with root package name */
    Bitmap f310003f;

    /* renamed from: h, reason: collision with root package name */
    Boolean f310004h = Boolean.FALSE;

    /* renamed from: i, reason: collision with root package name */
    public AtomicBoolean f310005i = new AtomicBoolean(false);

    /* renamed from: m, reason: collision with root package name */
    WeakReference<Activity> f310006m = new WeakReference<>(null);
    Handler C = new d(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements Function1<PAGView, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f310011d;

        b(String str) {
            this.f310011d = str;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(PAGView pAGView) {
            PAGFile Load = PagViewMonitor.Load(this.f310011d);
            if (Load != null) {
                ThemeSwitchManagerImpl.this.f(pAGView);
                pAGView.setScaleMode(3);
                Load.replaceImage(0, PAGImage.FromBitmap(ThemeSwitchManagerImpl.this.f310003f));
                pAGView.setComposition(Load);
                pAGView.setProgress(0.0d);
                pAGView.setRepeatCount(1);
                return null;
            }
            if (QLog.isColorLevel()) {
                QLog.e("ThemeSwitchManager", 2, "initPagView pag file null");
            }
            ThemeSwitchManagerImpl.this.f310004h = Boolean.FALSE;
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class d extends Handler {
        d(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v18 */
        /* JADX WARN: Type inference failed for: r1v19 */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3, types: [android.app.Dialog, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v5, types: [android.app.Dialog, com.tencent.mobileqq.widget.QQProgressDialog] */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Activity activity;
            WeakReference<Activity> weakReference = ThemeSwitchManagerImpl.this.f310006m;
            Dialog dialog = null;
            if (weakReference != null && weakReference.get() != null) {
                activity = ThemeSwitchManagerImpl.this.f310006m.get();
            } else {
                activity = null;
            }
            if (activity == null) {
                QLog.d("ThemeSwitchManager", 2, "handleMessage activity is not TitleBarActivity, , what=" + message.what);
                return;
            }
            switch (message.what) {
                case 200:
                    if (!activity.isFinishing()) {
                        WeakReference<Dialog> weakReference2 = ThemeSwitchManagerImpl.this.f310001d;
                        if (weakReference2 != null) {
                            dialog = weakReference2.get();
                        }
                        if (dialog == null || !dialog.isShowing()) {
                            boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("theme_switch_dialog_8898_115959321", true);
                            QLog.i("ThemeSwitchManager", 1, "dialogSwitch:" + isSwitchOn);
                            ?? r16 = dialog;
                            if (isSwitchOn) {
                                Dialog createLoadingDialog = LoadingUtil.createLoadingDialog(activity, activity.getString(R.string.hu8), false);
                                if (createLoadingDialog == null) {
                                    QLog.i("ThemeSwitchManager", 1, "LoadingUtil.createLoadingDialog is null, use default dialog");
                                    r16 = createLoadingDialog;
                                } else {
                                    createLoadingDialog.setCancelable(true);
                                    r16 = createLoadingDialog;
                                }
                            }
                            if (r16 == 0) {
                                r16 = new QQProgressDialog(activity, ((QBaseActivity) activity).getTitleBarHeight());
                                r16.setCancelable(true);
                                r16.setMessage(R.string.hu8);
                            }
                            r16.show();
                            ThemeSwitchManagerImpl.this.f310001d = new WeakReference<>(r16);
                            VasLogReporter.getTheme().report("toast:" + activity.getString(R.string.hu8));
                            return;
                        }
                        return;
                    }
                    return;
                case 201:
                    ThemeSwitchManagerImpl.this.onPostThemeChanged();
                    int i3 = message.arg1;
                    if (i3 == 2 || i3 == -201 || i3 == -202) {
                        QQToast.makeText(activity, HardCodeUtil.qqStr(R.string.u4u), 0).show();
                    }
                    if (i3 != 0) {
                        VasLogReporter.getTheme().report("themeSwitch error:" + i3);
                        return;
                    }
                    return;
                case 202:
                    ThemeSwitchManagerImpl.this.n();
                    return;
                default:
                    throw new IllegalStateException("Unexpected value: " + message.what);
            }
        }
    }

    static {
        int i3;
        if (DeviceInfoUtils.isLowPerfDevice()) {
            i3 = Constants.Action.ACTION_APP_GUARD;
        } else {
            i3 = 1100;
        }
        D = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(PAGView pAGView) {
        pAGView.addListener(new c());
    }

    private void h() {
        ViewGroup viewGroup;
        WeakReference<Activity> weakReference = this.f310006m;
        if (weakReference == null) {
            return;
        }
        try {
            View k3 = k(weakReference.get());
            if (k3 != null && (viewGroup = (ViewGroup) k3.getParent()) != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("ThemeSwitchManager", 1, "resetAnimation, execute remove view");
                }
                viewGroup.removeView(k3);
                k3.setVisibility(8);
            }
        } catch (Exception e16) {
            QLog.e("ThemeSwitchManager", 1, "resetAnimation, error", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        Dialog dialog;
        WeakReference<Dialog> weakReference = this.f310001d;
        if (weakReference != null && (dialog = weakReference.get()) != null) {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
            this.f310001d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View k(Activity activity) {
        View g16 = g(activity);
        if (g16 instanceof ViewGroup) {
            return g16.findViewById(R.id.f96365hh);
        }
        return null;
    }

    private boolean l(VasPagView vasPagView) {
        this.C.sendEmptyMessageDelayed(202, 5000L);
        String vipThemeResPath = ThemeVipBehavior.getVipThemeResPath();
        if (TextUtils.isEmpty(vipThemeResPath)) {
            if (QLog.isColorLevel()) {
                QLog.e("ThemeSwitchManager", 2, "initPagView res null");
            }
            return false;
        }
        String str = File.separator;
        if (!vipThemeResPath.endsWith(str)) {
            vipThemeResPath = vipThemeResPath + str;
        }
        String str2 = vipThemeResPath + "skin_theme_vip.pag";
        if (!new File(str2).exists()) {
            if (QLog.isColorLevel()) {
                QLog.e("ThemeSwitchManager", 2, "initPagView pag null");
            }
            return false;
        }
        if (vasPagView == null) {
            return false;
        }
        IVasPagViewApi<PAGView> api = vasPagView.api();
        api.build();
        api.postAction(new b(str2));
        if (QLog.isColorLevel()) {
            QLog.e("ThemeSwitchManager", 2, "initPagView");
            return true;
        }
        return true;
    }

    private void m(View view) {
        if (view == null) {
            return;
        }
        ((VasPagView) view).api().postAction(new Function1<PAGView, Unit>() { // from class: com.tencent.mobileqq.vas.manager.api.impl.ThemeSwitchManagerImpl.4
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unit invoke(final PAGView pAGView) {
                ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.vas.manager.api.impl.ThemeSwitchManagerImpl.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        pAGView.play();
                        if (QLog.isColorLevel()) {
                            QLog.e("ThemeSwitchManager", 2, "playVipThemeAnimation pagView.play");
                        }
                    }
                }, 16, null, true, ThemeSwitchManagerImpl.D);
                return null;
            }
        });
        if (QLog.isColorLevel()) {
            QLog.e("ThemeSwitchManager", 2, "playVipThemeAnimation!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void n() {
        View k3 = k(this.f310006m.get());
        if (k3 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("ThemeSwitchManager", 1, "resetAnimation, remove view, tmpScreenShot==null");
            }
            this.f310005i.set(false);
            return;
        }
        try {
            ViewGroup viewGroup = (ViewGroup) k3.getParent();
            if (viewGroup != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("ThemeSwitchManager", 1, "resetAnimation, execute remove view");
                }
                viewGroup.removeView(k3);
                viewGroup.clearDisappearingChildren();
                k3.setVisibility(8);
            }
        } catch (Exception e16) {
            QLog.e("ThemeSwitchManager", 1, "resetAnimation, error", e16);
        }
        try {
            Bitmap bitmap = this.f310003f;
            if (bitmap != null) {
                bitmap.recycle();
                this.f310003f = null;
            }
        } catch (Exception e17) {
            QLog.e("ThemeSwitchManager", 1, "resetAnimation, error drawingCache", e17);
        }
        this.f310005i.set(false);
        this.f310004h = Boolean.FALSE;
    }

    @Override // com.tencent.mobileqq.vas.manager.api.IThemeSwitchManager
    public void clearOnErr(int i3) {
        Message message = new Message();
        message.what = 201;
        message.arg1 = i3;
        this.C.sendMessage(message);
    }

    @Override // com.tencent.mobileqq.vas.manager.api.IThemeSwitchManager
    public void doScreenShot() {
        doScreenShot(false);
    }

    protected View g(Activity activity) {
        View decorView;
        Window window = activity.getWindow();
        if (window != null && (decorView = window.getDecorView()) != null) {
            return decorView.getRootView();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.vas.manager.api.IThemeSwitchManager
    public boolean getIsEnableAnimate(Bundle bundle) {
        boolean z16;
        boolean z17;
        String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.theme_profile.name(), "1|1|1");
        if (QLog.isColorLevel()) {
            QLog.i("ThemeSwitchManager", 2, "getIsEnableAnimate profileStr:" + featureValue);
        }
        boolean z18 = false;
        if (!TextUtils.isEmpty(featureValue)) {
            Integer[] numArr = {0, 0, 0};
            int parseComplexParamsByStringToIntParser = ((IDPCApi) QRoute.api(IDPCApi.class)).parseComplexParamsByStringToIntParser(featureValue, numArr);
            if (QLog.isColorLevel()) {
                QLog.i("ThemeSwitchManager", 2, "getIsEnableAnimate size:" + parseComplexParamsByStringToIntParser + ", params:" + numArr);
            }
            if (parseComplexParamsByStringToIntParser >= 3) {
                if (numArr[0].intValue() == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (numArr[1].intValue() == 1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (numArr[2].intValue() == 1) {
                    z18 = true;
                }
                if (bundle != null) {
                    bundle.putBoolean(ThemeConstants.BUNDLE_KEY_DYNAMIC_SWITCH, z16);
                    bundle.putBoolean(ThemeConstants.BUNDLE_KEY_DYNAMIC_ENABLE, z17);
                    bundle.putBoolean(ThemeConstants.BUNDLE_KEY_DYNAMIC_WEBVIEW_ENABLE, z18);
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasManager
    @NotNull
    public String getManagerName() {
        return "ThemeSwitchManager";
    }

    @Override // com.tencent.mobileqq.vas.manager.api.IThemeSwitchManager
    @NotNull
    public ThemeDiyStyleLogic.StyleCallBack getstyleCallBack() {
        return this.f310002e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void j(Activity activity, Bitmap bitmap, View view) {
        VasPagView vasPagView;
        if (bitmap != null) {
            View k3 = k(activity);
            if (k3 != null && k3.getParent() != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("ThemeSwitchManager", 2, "doScreenShot, last one has not remove-->", k3);
                }
                ((ViewGroup) k3.getParent()).removeView(k3);
            }
            this.f310003f = Bitmap.createBitmap(bitmap);
            if (this.f310004h.booleanValue()) {
                VasPagView vasPagView2 = new VasPagView(activity);
                vasPagView2.setBackground(new BitmapDrawable(this.f310003f));
                this.f310004h = Boolean.valueOf(l(vasPagView2));
                vasPagView = vasPagView2;
            } else {
                vasPagView = null;
            }
            VasPagView vasPagView3 = vasPagView;
            if (!this.f310004h.booleanValue()) {
                ImageView imageView = new ImageView(activity);
                imageView.setImageBitmap(this.f310003f);
                vasPagView3 = imageView;
                if (((IVasDepTemp) QRoute.api(IVasDepTemp.class)).isQQBrowserActivity(activity)) {
                    imageView.setAlpha(220.0f);
                    vasPagView3 = imageView;
                    if (QLog.isColorLevel()) {
                        QLog.d("ThemeSwitchManager", 2, "doScreenShot, refActivity is QQBrowserActivity");
                        vasPagView3 = imageView;
                    }
                }
            }
            vasPagView3.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            vasPagView3.setId(R.id.f96365hh);
            ((ViewGroup) view).addView(vasPagView3);
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        i();
        if (VasNormalToggle.VAS_BUG_THEME_SWITCH_VIEW_LEAK.isEnable(true)) {
            h();
        }
    }

    @Override // com.tencent.mobileqq.vas.manager.api.IThemeSwitchManager
    public void onPostThemeChanged() {
        Dialog dialog;
        WeakReference<Dialog> weakReference = this.f310001d;
        if (weakReference != null && (dialog = weakReference.get()) != null && dialog.isShowing()) {
            dialog.dismiss();
            this.f310001d = null;
        }
        if (this.f310003f != null && this.f310006m != null) {
            if (QLog.isColorLevel()) {
                QLog.d("ThemeSwitchManager", 2, "onPostThemeChanged, isAnimating: ", Boolean.valueOf(this.f310005i.get()));
            }
            View k3 = k(this.f310006m.get());
            if (!this.f310005i.get() && k3 != null) {
                this.f310005i.set(true);
                if (this.f310004h.booleanValue()) {
                    try {
                        try {
                            m(k3);
                        } catch (Exception e16) {
                            QLog.e("ThemeSwitchManager", 1, "playVipThemeAnimation error", e16.getCause());
                        }
                        return;
                    } finally {
                        this.C.sendEmptyMessageDelayed(202, 5000L);
                    }
                }
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.1f);
                alphaAnimation.setDuration(50L);
                alphaAnimation.setInterpolator(new LinearInterpolator());
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setAnimationListener(new a());
                k3.startAnimation(alphaAnimation);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ThemeSwitchManager", 2, "onPostThemeChanged drawingCache is null");
        }
    }

    @Override // com.tencent.mobileqq.vas.manager.api.IThemeSwitchManager
    public void openSwitchDialog(Activity activity) {
        this.f310006m = new WeakReference<>(activity);
        this.C.sendEmptyMessage(200);
        if (VasNormalToggle.VAS_THEME_DIALOG_TIME_OUT_2.isEnable(true)) {
            this.C.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.vas.manager.api.impl.ThemeSwitchManagerImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    ThemeSwitchManagerImpl.this.i();
                }
            }, 15000L);
        }
    }

    @Override // com.tencent.mobileqq.vas.manager.api.IThemeSwitchManager
    public void setstyleCallBack(@NotNull ThemeDiyStyleLogic.StyleCallBack styleCallBack) {
        this.f310002e = styleCallBack;
    }

    @Override // com.tencent.mobileqq.vas.manager.api.IThemeSwitchManager
    public void doScreenShot(boolean z16) {
        WeakReference<Activity> weakReference;
        try {
            weakReference = this.f310006m;
        } catch (Throwable th5) {
            QLog.e("ThemeSwitchManager", 1, "doScreenShot oom, no animation", th5);
            this.f310003f = null;
            h();
        }
        if (weakReference != null && weakReference.get() != null) {
            this.f310004h = Boolean.valueOf(VasToggle.FEATURE_THEME_VIP_ANIMATION.isEnable(true) && z16);
            Activity activity = this.f310006m.get();
            View g16 = g(activity);
            if (g16 == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("ThemeSwitchManager", 2, "doScreenShot, rootView is null");
                    return;
                }
                return;
            }
            boolean isDrawingCacheEnabled = g16.isDrawingCacheEnabled();
            boolean willNotCacheDrawing = g16.willNotCacheDrawing();
            g16.setDrawingCacheEnabled(true);
            g16.setWillNotCacheDrawing(false);
            j(activity, g16.getDrawingCache(), g16);
            g16.setDrawingCacheEnabled(isDrawingCacheEnabled);
            g16.setWillNotCacheDrawing(willNotCacheDrawing);
            if (QLog.isColorLevel()) {
                QLog.d("ThemeSwitchManager", 2, "drawingCache is:" + this.f310003f);
                return;
            }
            return;
        }
        QLog.e("ThemeSwitchManager", 1, "doScreenShot, currActivityRef is null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            ThemeSwitchManagerImpl.this.n();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c implements PAGView.PAGViewListener {
        c() {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationEnd(PAGView pAGView) {
            if (QLog.isColorLevel()) {
                QLog.e("ThemeSwitchManager", 2, "pagView onAnimationEnd");
            }
            ThemeSwitchManagerImpl.this.n();
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationStart(PAGView pAGView) {
            if (QLog.isColorLevel()) {
                QLog.e("ThemeSwitchManager", 2, "pagView onAnimationStart");
            }
            ThemeSwitchManagerImpl themeSwitchManagerImpl = ThemeSwitchManagerImpl.this;
            View k3 = themeSwitchManagerImpl.k(themeSwitchManagerImpl.f310006m.get());
            if (k3 != null) {
                k3.setBackground(null);
            }
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationCancel(PAGView pAGView) {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationRepeat(PAGView pAGView) {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationUpdate(PAGView pAGView) {
        }
    }
}
