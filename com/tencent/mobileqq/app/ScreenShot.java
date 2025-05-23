package com.tencent.mobileqq.app;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.core.util.Consumer;
import com.tencent.biz.richframework.util.RFWSaveUtil;
import com.tencent.biz.richframework.util.bean.RFWSaveMediaResultBean;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.Collections;
import java.util.List;
import mqq.app.AppActivity;
import mqq.app.Foreground;
import mqq.util.NativeUtil;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ScreenShot implements Handler.Callback, View.OnClickListener {
    static IPatchRedirector $redirector_;
    Button C;
    Button D;
    Bitmap E;
    Bitmap F;
    Bitmap G;
    final b H;
    Drawable I;
    Drawable J;
    private ViewGroup K;
    private boolean L;
    public Bitmap M;
    public Object N;

    /* renamed from: d, reason: collision with root package name */
    final Context f195045d;

    /* renamed from: e, reason: collision with root package name */
    private final Handler f195046e;

    /* renamed from: f, reason: collision with root package name */
    private final Handler f195047f;

    /* renamed from: h, reason: collision with root package name */
    Window f195048h;

    /* renamed from: i, reason: collision with root package name */
    Button f195049i;

    /* renamed from: m, reason: collision with root package name */
    Button f195050m;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f195052a;

        a(b bVar) {
            this.f195052a = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScreenShot.this, (Object) bVar);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                ScreenShot.this.f195047f.obtainMessage(2, 0, 0, this.f195052a).sendToTarget();
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) list, (Object) list2);
            } else {
                ScreenShot.this.f195046e.obtainMessage(1, 0, 0, this.f195052a).sendToTarget();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b extends View {
        static IPatchRedirector $redirector_;
        final Matrix C;
        int D;
        int E;
        int F;
        int G;
        int H;
        boolean I;
        int J;

        /* renamed from: d, reason: collision with root package name */
        Bitmap f195054d;

        /* renamed from: e, reason: collision with root package name */
        final Paint f195055e;

        /* renamed from: f, reason: collision with root package name */
        final Paint f195056f;

        /* renamed from: h, reason: collision with root package name */
        final Rect f195057h;

        /* renamed from: i, reason: collision with root package name */
        final Rect f195058i;

        /* renamed from: m, reason: collision with root package name */
        final Matrix f195059m;

        public b(Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScreenShot.this, (Object) context);
                return;
            }
            this.f195055e = new Paint();
            this.f195056f = new Paint();
            this.f195057h = new Rect();
            this.f195058i = new Rect();
            this.f195059m = new Matrix();
            this.C = new Matrix();
            setLongClickable(true);
        }

        private void b(Canvas canvas) {
            if (this.I && ScreenShot.this.G != null) {
                this.I = false;
                try {
                    this.f195054d = Bitmap.createBitmap(this.f195057h.width(), this.f195057h.height(), Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(this.f195054d);
                    this.C.reset();
                    this.C.postConcat(this.f195059m);
                    Matrix matrix = this.C;
                    Rect rect = this.f195057h;
                    matrix.postTranslate(-rect.left, -rect.top);
                    Bitmap bitmap = ScreenShot.this.G;
                    if (bitmap != null) {
                        canvas2.drawBitmap(bitmap, this.C, this.f195055e);
                    }
                } catch (IllegalArgumentException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ScreenShot", 2, this.f195057h.width() + ":" + this.f195057h.height(), e16);
                    }
                } catch (Throwable th5) {
                    this.f195054d = null;
                    if (QLog.isColorLevel()) {
                        QLog.d("ScreenShot", 2, "", th5);
                    }
                }
                this.f195055e.setColor(Integer.MIN_VALUE);
                this.f195055e.setStyle(Paint.Style.FILL);
                canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f195055e);
                ScreenShot.s("save and hide");
                ScreenShot.this.m();
                if (this.f195054d == null) {
                    QQToast.makeText(ScreenShot.this.f195045d.getApplicationContext(), R.string.h3u, 1).show();
                    return;
                } else {
                    ScreenShot.this.f195047f.obtainMessage(2, 0, 0, this).sendToTarget();
                    return;
                }
            }
            this.f195055e.setColor(Integer.MIN_VALUE);
            this.f195055e.setStyle(Paint.Style.FILL);
            canvas.drawRect(0.0f, 0.0f, getWidth(), this.f195057h.top, this.f195055e);
            canvas.drawRect(0.0f, this.f195057h.bottom, getWidth(), getHeight(), this.f195055e);
            Rect rect2 = this.f195057h;
            canvas.drawRect(0.0f, rect2.top, rect2.left, rect2.bottom, this.f195055e);
            Rect rect3 = this.f195057h;
            canvas.drawRect(rect3.right, rect3.top, getWidth(), this.f195057h.bottom, this.f195055e);
            this.f195055e.setStyle(Paint.Style.STROKE);
            this.f195055e.setColor(-16847);
            canvas.drawRect(this.f195057h, this.f195055e);
            if (this.f195057h.isEmpty()) {
                int width = (getWidth() / 2) - (ScreenShot.this.I.getIntrinsicWidth() / 2);
                int height = (getHeight() / 2) - (ScreenShot.this.I.getIntrinsicHeight() / 2);
                int intrinsicWidth = ScreenShot.this.I.getIntrinsicWidth() + width;
                int intrinsicHeight = ScreenShot.this.I.getIntrinsicHeight() + height;
                float f16 = getResources().getDisplayMetrics().density;
                ScreenShot.this.I.setBounds(width, height, intrinsicWidth, intrinsicHeight);
                ScreenShot.this.I.draw(canvas);
                this.f195056f.setTextSize(getResources().getDisplayMetrics().scaledDensity * 20.0f);
                this.f195056f.setAntiAlias(true);
                this.f195056f.setTextAlign(Paint.Align.CENTER);
                this.f195056f.setColor(-1);
                this.f195056f.setShadowLayer(2.0f, 0.0f, f16 * 2.0f, Integer.MIN_VALUE);
                canvas.drawText(ScreenShot.this.f195045d.getString(R.string.hnq), getWidth() / 2, intrinsicHeight + (f16 * 26.0f), this.f195056f);
            }
            int i3 = this.J;
            if (i3 != 100001 && i3 != 0) {
                this.f195055e.setStyle(Paint.Style.FILL);
                int intrinsicWidth2 = this.f195057h.left - (ScreenShot.this.J.getIntrinsicWidth() / 2);
                int intrinsicHeight2 = this.f195057h.top - (ScreenShot.this.J.getIntrinsicHeight() / 2);
                int intrinsicWidth3 = ScreenShot.this.J.getIntrinsicWidth() + intrinsicWidth2;
                int intrinsicHeight3 = ScreenShot.this.J.getIntrinsicHeight() + intrinsicHeight2;
                ScreenShot.this.J.setBounds(intrinsicWidth2, intrinsicHeight2, intrinsicWidth3, intrinsicHeight3);
                ScreenShot.this.J.draw(canvas);
                int intrinsicWidth4 = this.f195057h.right - (ScreenShot.this.J.getIntrinsicWidth() / 2);
                int intrinsicWidth5 = ScreenShot.this.J.getIntrinsicWidth() + intrinsicWidth4;
                ScreenShot.this.J.setBounds(intrinsicWidth4, intrinsicHeight2, intrinsicWidth5, intrinsicHeight3);
                ScreenShot.this.J.draw(canvas);
                int intrinsicHeight4 = this.f195057h.bottom - (ScreenShot.this.J.getIntrinsicHeight() / 2);
                int intrinsicHeight5 = ScreenShot.this.J.getIntrinsicHeight() + intrinsicHeight4;
                ScreenShot.this.J.setBounds(intrinsicWidth4, intrinsicHeight4, intrinsicWidth5, intrinsicHeight5);
                ScreenShot.this.J.draw(canvas);
                int intrinsicWidth6 = this.f195057h.left - (ScreenShot.this.J.getIntrinsicWidth() / 2);
                ScreenShot.this.J.setBounds(intrinsicWidth6, intrinsicHeight4, ScreenShot.this.J.getIntrinsicWidth() + intrinsicWidth6, intrinsicHeight5);
                ScreenShot.this.J.draw(canvas);
            }
        }

        public void a(boolean z16) {
            String str;
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, z16);
                return;
            }
            if (z16) {
                if (ScreenShot.this.E == null) {
                    Rect rect = new Rect();
                    ScreenShot.this.f195048h.getDecorView().getWindowVisibleDisplayFrame(rect);
                    i3 = rect.top;
                } else {
                    i3 = 0;
                }
                if (ScreenShot.this.G != null) {
                    if (this.f195059m.isIdentity()) {
                        this.f195057h.set(0, i3, ScreenShot.this.G.getWidth(), ScreenShot.this.G.getHeight());
                    } else {
                        this.f195057h.set(i3, 0, ScreenShot.this.G.getHeight(), ScreenShot.this.G.getWidth());
                    }
                }
            }
            if (this.f195057h.isEmpty()) {
                this.f195057h.left = getLeft();
                this.f195057h.right = getRight();
                this.f195057h.top = getTop();
                this.f195057h.bottom = getBottom();
            }
            if (this.f195057h.width() > 0 && this.f195057h.height() > 0) {
                this.I = true;
                if (z16) {
                    str = "1";
                } else {
                    str = "0";
                }
                ReportController.o(null, "CliOper", "", "", "0X8005007", "0X8005007", 0, 0, str, "", "", "");
                invalidate();
            }
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
                return;
            }
            super.onDraw(canvas);
            ScreenShot screenShot = ScreenShot.this;
            Bitmap bitmap = screenShot.E;
            if (bitmap != null) {
                screenShot.G = bitmap;
                this.f195059m.reset();
                DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                this.f195059m.reset();
                Bitmap bitmap2 = ScreenShot.this.G;
                if (bitmap2 != null && displayMetrics.heightPixels == bitmap2.getWidth() && displayMetrics.widthPixels == ScreenShot.this.G.getHeight()) {
                    this.f195059m.postTranslate((-ScreenShot.this.G.getWidth()) / 2, (-ScreenShot.this.G.getHeight()) / 2);
                    this.f195059m.postRotate(90.0f);
                    this.f195059m.postTranslate(ScreenShot.this.G.getHeight() / 2, ScreenShot.this.G.getWidth() / 2);
                }
            } else {
                int width = getWidth();
                int height = getHeight();
                ScreenShot screenShot2 = ScreenShot.this;
                if (screenShot2.F == null && width > 0 && height > 0) {
                    try {
                        screenShot2.F = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                        if (ScreenShot.this.F != null) {
                            ScreenShot.this.f195048h.getDecorView().draw(new Canvas(ScreenShot.this.F));
                            ScreenShot screenShot3 = ScreenShot.this;
                            screenShot3.G = screenShot3.F;
                        }
                    } catch (Throwable th5) {
                        if (QLog.isColorLevel()) {
                            QLog.d("mqq", 2, "", th5);
                        }
                    }
                }
                this.f195059m.reset();
                Bitmap bitmap3 = ScreenShot.this.G;
                if (bitmap3 != null && bitmap3.getWidth() != width) {
                    this.f195059m.postTranslate((-ScreenShot.this.G.getWidth()) / 2, (-ScreenShot.this.G.getHeight()) / 2);
                    this.f195059m.postRotate(90.0f);
                    this.f195059m.postTranslate(ScreenShot.this.G.getHeight() / 2, ScreenShot.this.G.getWidth() / 2);
                }
            }
            Bitmap bitmap4 = ScreenShot.this.G;
            if (bitmap4 != null) {
                canvas.drawBitmap(bitmap4, this.f195059m, this.f195055e);
            }
            int i3 = this.J;
            if (i3 != 0 && i3 != 100001) {
                this.f195055e.setStrokeWidth(3.0f);
                Paint paint = this.f195055e;
                int i16 = this.H + 1;
                this.H = i16;
                paint.setPathEffect(new DashPathEffect(new float[]{15.0f, 5.0f, 8.0f, 5.0f}, i16));
                invalidate();
            } else {
                this.f195055e.setStrokeWidth(1.0f);
                this.f195055e.setPathEffect(null);
                this.H = 0;
            }
            this.f195055e.setColor(-16847);
            Rect rect = this.f195057h;
            int i17 = rect.left;
            int i18 = rect.right;
            if (i17 > i18) {
                rect.left = i18;
                rect.right = i17;
            }
            int i19 = rect.top;
            int i26 = rect.bottom;
            if (i19 > i26) {
                rect.top = i26;
                rect.bottom = i19;
            }
            b(canvas);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) motionEvent)).booleanValue();
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        this.F = (int) motionEvent.getX();
                        int y16 = (int) motionEvent.getY();
                        this.G = y16;
                        int i3 = this.J;
                        if (i3 == 100004) {
                            int i16 = this.F;
                            int i17 = i16 - this.D;
                            int i18 = y16 - this.E;
                            this.D = i16;
                            this.E = y16;
                            Rect rect = this.f195057h;
                            if (rect.left + i17 >= 0 && rect.right + i17 <= getWidth()) {
                                Rect rect2 = this.f195057h;
                                rect2.left += i17;
                                rect2.right += i17;
                            }
                            Rect rect3 = this.f195057h;
                            if (rect3.top + i18 >= 0 && rect3.bottom + i18 <= getHeight()) {
                                Rect rect4 = this.f195057h;
                                rect4.top += i18;
                                rect4.bottom += i18;
                            }
                        } else if (i3 == 100001) {
                            Rect rect5 = this.f195057h;
                            rect5.left = this.D;
                            rect5.top = this.E;
                            rect5.right = this.F;
                            rect5.bottom = y16;
                        } else if (i3 == 100005) {
                            int i19 = this.F - this.D;
                            int i26 = y16 - this.E;
                            this.f195057h.set(this.f195058i);
                            int i27 = this.D;
                            Rect rect6 = this.f195057h;
                            if (i27 < rect6.left + (rect6.width() / 2)) {
                                Rect rect7 = this.f195057h;
                                int i28 = rect7.left + i19;
                                rect7.left = i28;
                                rect7.left = Math.max(i28, 0);
                            } else {
                                Rect rect8 = this.f195057h;
                                int i29 = rect8.right + i19;
                                rect8.right = i29;
                                rect8.right = Math.min(i29, getWidth());
                            }
                            int i36 = this.E;
                            Rect rect9 = this.f195057h;
                            if (i36 < rect9.top + (rect9.height() / 2)) {
                                Rect rect10 = this.f195057h;
                                int i37 = rect10.top + i26;
                                rect10.top = i37;
                                rect10.top = Math.max(i37, 0);
                            } else {
                                Rect rect11 = this.f195057h;
                                int i38 = rect11.bottom + i26;
                                rect11.bottom = i38;
                                rect11.bottom = Math.min(i38, getHeight());
                            }
                        }
                        ScreenShot.this.f195049i.setVisibility(8);
                        ScreenShot.this.f195050m.setVisibility(8);
                        ScreenShot.this.C.setVisibility(8);
                        ScreenShot.this.D.setVisibility(8);
                        invalidate();
                    }
                } else {
                    if (Math.abs(this.f195057h.width()) < 5) {
                        this.f195057h.setEmpty();
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        this.J = 100002;
                        ScreenShot.this.v(true);
                    } else {
                        this.J = 0;
                        ScreenShot.this.v(false);
                    }
                    invalidate();
                }
            } else {
                this.D = (int) motionEvent.getX();
                this.E = (int) motionEvent.getY();
                if (!this.f195057h.isEmpty()) {
                    if (this.f195057h.contains(this.D, this.E)) {
                        this.J = 100004;
                    } else {
                        Rect rect12 = this.f195057h;
                        if (new Rect(rect12.left - 20, rect12.top - 20, rect12.right + 20, rect12.bottom + 20).contains(this.D, this.E)) {
                            this.J = 100005;
                            this.f195058i.set(this.f195057h);
                        } else {
                            this.f195057h.setEmpty();
                            this.J = 100001;
                            this.f195055e.setStrokeWidth(1.0f);
                            this.f195055e.setPathEffect(null);
                            ScreenShot.this.v(false);
                        }
                    }
                } else {
                    this.J = 100001;
                    ScreenShot.this.v(false);
                }
                invalidate();
            }
            return super.onTouchEvent(motionEvent);
        }
    }

    public ScreenShot(Context context, Window window) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) window);
            return;
        }
        this.L = false;
        this.f195045d = context;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            while (activity.getParent() != null) {
                activity = activity.getParent();
            }
            this.f195048h = activity.getWindow();
        } else {
            this.f195048h = window;
        }
        this.I = context.getResources().getDrawable(R.drawable.bxd);
        this.J = context.getResources().getDrawable(R.drawable.bxc);
        this.H = new b(this.f195045d);
        Handler handler = new Handler(Looper.getMainLooper(), this);
        this.f195046e = handler;
        this.f195047f = new Handler(ThreadManagerV2.getFileThreadLooper(), this);
        if (Looper.getMainLooper() != Looper.myLooper()) {
            handler.sendEmptyMessage(4);
        } else {
            n();
        }
        this.N = new Object();
        this.M = null;
    }

    private boolean g() {
        if (QLog.isColorLevel()) {
            QLog.d("BaseActivity.ScreenShot", 2, "current phone Build.Model is " + DeviceInfoMonitor.getModel());
        }
        if (!p() && !DeviceInfoMonitor.getModel().contains("Lenovo S810t") && !DeviceInfoMonitor.getModel().contains("OPPO R7005") && !DeviceInfoMonitor.getModel().contains(HardCodeUtil.qqStr(R.string.t5i)) && !DeviceInfoMonitor.getModel().contains("vivo X5L") && !DeviceInfoMonitor.getModel().contains("OPPO N3") && !DeviceInfoMonitor.getModel().contains("OPPO R7") && !j()) {
            return true;
        }
        return false;
    }

    private boolean h() {
        if (this.f195045d.checkSelfPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            return true;
        }
        return false;
    }

    private boolean j() {
        if (!Build.MANUFACTURER.contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_MEIZU)) {
            return false;
        }
        if (!DeviceInfoMonitor.getModel().contains("M351") && !DeviceInfoMonitor.getModel().contains("M353") && !DeviceInfoMonitor.getModel().contains("M355") && !DeviceInfoMonitor.getModel().contains("M356") && !DeviceInfoMonitor.getModel().contains("MX4") && !DeviceInfoMonitor.getModel().contains("MX4 Pro") && !DeviceInfoMonitor.getModel().contains("m2 note")) {
            return false;
        }
        return true;
    }

    @Nullable
    private AppActivity k() {
        Context context = this.f195045d;
        if (context instanceof AppActivity) {
            return (AppActivity) context;
        }
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity instanceof AppActivity) {
            return (AppActivity) topActivity;
        }
        QLog.e("BaseActivity.ScreenShot", 1, "ScreenShot checkFilePermission, topActivity is Null");
        return null;
    }

    private void l(QQPermission.BasePermissionsListener basePermissionsListener) {
        AppActivity k3 = k();
        if (k3 == null) {
            return;
        }
        if ("has_grant".equals(com.tencent.mobileqq.util.cl.e(this.f195045d, "ScreenShot", "hasGrantPermission"))) {
            QLog.w("BaseActivity.ScreenShot", 1, "ScreenShot permission has req, so don't req again");
            basePermissionsListener.onDenied(Collections.singletonList(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE), Collections.singletonList(0));
        } else {
            QQPermissionFactory.getQQPermission(k3, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_SCREENSHOT, QQPermissionConstants.Business.SCENE.SAVE_SCREENSHOT)).requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, basePermissionsListener);
            com.tencent.mobileqq.util.cl.k(this.f195045d, "ScreenShot", "hasGrantPermission", "has_grant");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (isShowing()) {
            ((WindowManager) this.f195045d.getSystemService("window")).removeView(this.K);
        } else if (this.f195046e.hasMessages(4)) {
            this.f195046e.removeMessages(4);
        }
        this.G = null;
        this.E = null;
        this.F = null;
    }

    private void n() {
        ViewGroup viewGroup = (ViewGroup) ((LayoutInflater) this.f195045d.getSystemService("layout_inflater")).inflate(R.layout.f169078bx1, (ViewGroup) null);
        this.K = viewGroup;
        viewGroup.addView(this.H, 0);
        this.C = (Button) this.K.findViewById(R.id.ihz);
        this.f195049i = (Button) this.K.findViewById(R.id.cpt);
        this.D = (Button) this.K.findViewById(R.id.cancel);
        this.f195050m = (Button) this.K.findViewById(R.id.blk);
        this.D.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.f195049i.setOnClickListener(this);
        this.f195050m.setOnClickListener(this);
        this.L = true;
    }

    private boolean p() {
        if (!DeviceInfoMonitor.getModel().contains("Galaxy Nexus") && !DeviceInfoMonitor.getModel().contains("HTC S720") && !DeviceInfoMonitor.getModel().contains("SM-N9006")) {
            DeviceInfoMonitor.getModel().contains("ZTE U930");
            DeviceInfoMonitor.getModel().contains("HTC One X");
            DeviceInfoMonitor.getModel().contains("GT-I9260");
            if (!DeviceInfoMonitor.getModel().contains("vivo Y18L") && !DeviceInfoMonitor.getModel().contains("HM 1SW") && !DeviceInfoMonitor.getModel().contains("DOOV S2y") && !DeviceInfoMonitor.getModel().contains("H30-T10") && !DeviceInfoMonitor.getModel().contains("vivo Y17T") && !DeviceInfoMonitor.getModel().contains("HUAWEI B199") && !DeviceInfoMonitor.getModel().contains("NX511J") && !DeviceInfoMonitor.getModel().contains("vivo Y11iW") && !DeviceInfoMonitor.getModel().contains("R809") && !DeviceInfoMonitor.getModel().contains("V185") && !DeviceInfoMonitor.getModel().contains("I9300")) {
                return false;
            }
        }
        return true;
    }

    private boolean q(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        DisplayMetrics displayMetrics = this.f195045d.getResources().getDisplayMetrics();
        int i3 = displayMetrics.widthPixels;
        int i16 = displayMetrics.heightPixels;
        if ((width == i3 && height == i16) || (width == i16 && height == i3)) {
            int[] iArr = new int[width];
            bitmap.getPixels(iArr, 0, width, 0, height / 2, width, 1);
            for (int i17 = 0; i17 < width; i17++) {
                if (iArr[i17] != -16777216) {
                    return true;
                }
            }
            int[] iArr2 = new int[height];
            bitmap.getPixels(iArr2, 0, 1, width / 2, 0, 1, height);
            for (int i18 = 0; i18 < height; i18++) {
                if (iArr2[i18] != -16777216) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r0v5 */
    public /* synthetic */ void r(b bVar, RFWSaveMediaResultBean rFWSaveMediaResultBean) {
        ?? r06;
        if (rFWSaveMediaResultBean.isSuccess && !TextUtils.isEmpty(rFWSaveMediaResultBean.savePath)) {
            r06 = 1;
        } else {
            r06 = 0;
        }
        QLog.d("BaseActivity.ScreenShot", 1, "save bitmap result:" + ((boolean) r06) + ", path:" + rFWSaveMediaResultBean.savePath);
        if (r06 != 0) {
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f195045d).edit();
            edit.putString(AppConstants.Preferences.LAST_SCREEN_SHOT_URI, Uri.fromFile(new File(rFWSaveMediaResultBean.savePath)).toString());
            edit.commit();
        }
        this.f195046e.obtainMessage(1, r06, 0, new Pair(bVar, new File(rFWSaveMediaResultBean.savePath).getParent())).sendToTarget();
    }

    public static void s(String str) {
        if (QLog.isDevelopLevel()) {
            QLog.d("ScreenShot", 2, str);
        }
    }

    public static native int snapScreen(int i3, int i16);

    private void u() {
        if (!isShowing()) {
            WindowManager windowManager = (WindowManager) this.f195045d.getSystemService("window");
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            if (Build.VERSION.SDK_INT < 26) {
                layoutParams.type = 2003;
            } else {
                layoutParams.type = 2038;
            }
            layoutParams.format = 1;
            layoutParams.flags |= 256;
            try {
                if (((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).checkPermission(this.f195045d)) {
                    windowManager.addView(this.K, layoutParams);
                } else {
                    ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).enterPermissionRequestDialogCustom(this.f195045d, R.string.f227956sf, R.string.f227946se);
                }
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.e("ScreenShot", 2, "", th5);
                }
            }
            s("ScreenShot show");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z16) {
        if (z16) {
            this.f195049i.setVisibility(8);
            this.f195050m.setVisibility(8);
            this.C.setVisibility(0);
            this.D.setVisibility(0);
            return;
        }
        this.f195049i.setVisibility(0);
        this.f195050m.setVisibility(0);
        this.C.setVisibility(8);
        this.D.setVisibility(8);
    }

    public boolean f() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        b bVar = this.H;
        bVar.J = 0;
        bVar.f195057h.setEmpty();
        this.F = null;
        v(false);
        if (g()) {
            try {
                Bitmap screenshot = NativeUtil.screenshot();
                this.E = screenshot;
                this.G = screenshot;
                if (screenshot != null && !q(screenshot)) {
                    this.E = null;
                    this.G = null;
                }
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d("ScreenShot", 2, "", th5);
                }
            }
            s("ScreenShot activate");
        }
        boolean z16 = this.f195045d instanceof Activity;
        if (!z16 && this.E == null) {
            return false;
        }
        this.f195046e.sendEmptyMessage(3);
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        ReportController.o(null, "CliOper", "", "", "0X8005006", "0X8005006", 0, 0, str, "", "", "");
        return true;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        n();
                    }
                } else {
                    u();
                }
            } else {
                final b bVar = (b) message.obj;
                try {
                    if (!h()) {
                        QLog.w("BaseActivity.ScreenShot", 1, "Save ScreenShot but not permission");
                        l(new a(bVar));
                        return true;
                    }
                    String str = com.tencent.mobileqq.vfs.b.i().e() + "/photo/";
                    RFWSaveUtil.saveBitmapAndInsertImage(BaseApplication.getContext(), bVar.f195054d, str + System.currentTimeMillis() + ".jpg", false, new Consumer() { // from class: com.tencent.mobileqq.app.cv
                        @Override // androidx.core.util.Consumer
                        public final void accept(Object obj) {
                            ScreenShot.this.r(bVar, (RFWSaveMediaResultBean) obj);
                        }
                    });
                } catch (Exception unused) {
                }
            }
        } else if (message.arg1 == 1) {
            Pair pair = (Pair) message.obj;
            b bVar2 = (b) pair.first;
            String str2 = (String) pair.second;
            bVar2.J = 100001;
            v(false);
            bVar2.invalidate();
            bVar2.scheduleDrawable(null, new Runnable(bVar2) { // from class: com.tencent.mobileqq.app.ScreenShot.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ b f195051d;

                {
                    this.f195051d = bVar2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ScreenShot.this, (Object) bVar2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    b bVar3 = this.f195051d;
                    if (!bVar3.I) {
                        bVar3.f195057h.setEmpty();
                    }
                    this.f195051d.invalidate();
                }
            }, SystemClock.uptimeMillis() + 1000);
            QQToast.makeText(this.f195045d.getApplicationContext(), this.f195045d.getString(R.string.h4d).replace("${path}", str2), 1).show();
        } else {
            QQToast.makeText(this.f195045d.getApplicationContext(), R.string.h3u, 1).show();
        }
        return true;
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        s("disactivate");
        m();
        ReportController.o(null, "CliOper", "", "", "0X8005008", "0X8005008", 0, 0, "0", "", "", "");
    }

    public boolean isShowing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        ViewGroup viewGroup = this.K;
        if (viewGroup != null && viewGroup.getParent() != null) {
            return true;
        }
        return false;
    }

    public boolean o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.L;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.cpt) {
                this.H.a(true);
                boolean z16 = wy2.d.f446757g;
            } else if (id5 == R.id.ihz) {
                this.H.a(false);
                boolean z17 = wy2.d.f446757g;
            } else if (id5 == R.id.blk) {
                s("click disable");
                m();
                ReportController.o(null, "CliOper", "", "", "0X8005008", "0X8005008", 0, 0, "1", "", "", "");
                boolean z18 = wy2.d.f446757g;
            } else if (id5 == R.id.cancel) {
                s("click cancel");
                m();
                ReportController.o(null, "CliOper", "", "", "0X8005008", "0X8005008", 0, 0, "2", "", "", "");
                boolean z19 = wy2.d.f446757g;
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void t() throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        synchronized (this.N) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.app.ScreenShot.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ScreenShot.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    synchronized (ScreenShot.this.N) {
                        View decorView = ScreenShot.this.f195048h.getDecorView();
                        decorView.setDrawingCacheEnabled(true);
                        decorView.buildDrawingCache();
                        Bitmap drawingCache = decorView.getDrawingCache();
                        Rect rect = new Rect();
                        ScreenShot.this.f195048h.getDecorView().getWindowVisibleDisplayFrame(rect);
                        int i3 = rect.top;
                        int width = ((Activity) ScreenShot.this.f195045d).getWindowManager().getDefaultDisplay().getWidth();
                        int height = ((Activity) ScreenShot.this.f195045d).getWindowManager().getDefaultDisplay().getHeight();
                        try {
                            ScreenShot.this.M = Bitmap.createBitmap(drawingCache, 0, i3, width, height - i3);
                        } catch (OutOfMemoryError e16) {
                            if (QLog.isColorLevel()) {
                                QLog.d("ScreenShot", 2, e16, new Object[0]);
                            }
                        }
                        decorView.destroyDrawingCache();
                        ScreenShot.this.N.notifyAll();
                    }
                }
            });
            this.N.wait(5000L);
        }
    }
}
