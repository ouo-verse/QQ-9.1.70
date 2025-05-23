package com.tencent.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.guild.api.IGuildStandalonePageOpenApi;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes27.dex */
public class FitSystemWindowsRelativeLayout extends RelativeLayout implements Handler.Callback {
    static IPatchRedirector $redirector_;
    boolean C;

    /* renamed from: d, reason: collision with root package name */
    private int[] f384547d;

    /* renamed from: e, reason: collision with root package name */
    LottieAnimationView f384548e;

    /* renamed from: f, reason: collision with root package name */
    View f384549f;

    /* renamed from: h, reason: collision with root package name */
    View.OnTouchListener f384550h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f384551i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f384552m;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    class a implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FitSystemWindowsRelativeLayout.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface b {
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface c {
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface d {
    }

    public FitSystemWindowsRelativeLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f384547d = new int[4];
        this.f384548e = null;
        this.f384549f = new View(getContext());
        this.f384550h = new a();
        this.f384551i = false;
        this.f384552m = false;
    }

    private boolean a() {
        try {
            if (!f()) {
                return false;
            }
            if (!b()) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean b() {
        if (((IGuildStandalonePageOpenApi) QRoute.api(IGuildStandalonePageOpenApi.class)).getGuildChatFragmentShow()) {
            return true;
        }
        Fragment chatFragment = ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).getChatFragment("FitSystemWindowsRelativeLayout");
        if (chatFragment == null) {
            return false;
        }
        return chatFragment.isVisible();
    }

    private String c(int i3) {
        if (i3 != 0 && i3 != -1) {
            try {
                return getResources().getResourceEntryName(i3);
            } catch (Exception e16) {
                QLog.d("placeholder", 1, "convertIntIdToString error : ", e16);
            }
        }
        return "";
    }

    @SuppressLint({"ResourceType"})
    private int[] d(View view, int i3) {
        if (view == null) {
            return new int[]{0, i3};
        }
        if (i3 >= 3) {
            return new int[]{0, i3};
        }
        if (view.getId() != 0 && view.getId() != -1) {
            return new int[]{view.getId(), i3};
        }
        return d((View) view.getParent(), i3 + 1);
    }

    private QQAppInterface e() {
        Context context = getContext();
        if (context instanceof BaseActivity) {
            return ((BaseActivity) context).app;
        }
        BaseActivity baseActivity = BaseActivity.sTopActivity;
        if (baseActivity != null) {
            return baseActivity.app;
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            return (QQAppInterface) runtime;
        }
        return null;
    }

    private boolean f() {
        if (this.f384551i) {
            return this.f384552m;
        }
        QQAppInterface e16 = e();
        if (e16 == null) {
            return false;
        }
        boolean isFeatureSwitchEnable = ((IFeatureRuntimeService) e16.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("qq_fit_system_window_guild_return_false", false);
        this.f384552m = isFeatureSwitchEnable;
        this.f384551i = true;
        return isFeatureSwitchEnable;
    }

    private void g(View view) {
        Drawable drawable;
        if (view instanceof ViewGroup) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                g(((ViewGroup) view).getChildAt(i3));
            }
            return;
        }
        if (!(view instanceof ImageView) || (drawable = ((ImageView) view).getDrawable()) == null) {
            return;
        }
        Bitmap bitmap = null;
        if (drawable instanceof DrawableContainer) {
            Drawable current = drawable.getCurrent();
            if (current instanceof BitmapDrawable) {
                bitmap = ((BitmapDrawable) current).getBitmap();
            }
        } else if (drawable instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) drawable).getBitmap();
        }
        if (bitmap != null && bitmap.isRecycled()) {
            StringBuilder sb5 = new StringBuilder("catch bitmap recycled:");
            int[] d16 = d(view, 0);
            if (d16[0] != 0) {
                sb5.append(" ");
                sb5.append(view.getResources().getResourceEntryName(d16[0]));
                sb5.append(" id = ");
                sb5.append(d16[0]);
                sb5.append(" level = ");
                sb5.append(d16[1]);
                sb5.append(" string id = ");
                sb5.append(c(view.getId()));
                sb5.append(" isRecycled");
                com.tencent.qqperf.monitor.crash.catchedexception.a.b(new Throwable("BITMAP_RECYCLED " + ((Object) sb5)));
                QLog.d("placeholder", 1, sb5.toString());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas);
            return;
        }
        try {
            try {
                super.dispatchDraw(canvas);
            } catch (RuntimeException unused) {
                g(this);
            }
        } catch (Throwable th5) {
            QLog.e("placeholder", 1, th5, new Object[0]);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("placeholder", 2, "dispatchTouchEvent() called with: ev = [" + motionEvent + "]");
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) rect)).booleanValue();
        }
        int[] iArr = this.f384547d;
        iArr[0] = rect.left;
        iArr[1] = rect.top;
        iArr[2] = rect.right;
        rect.left = 0;
        rect.top = 0;
        rect.right = 0;
        if (a()) {
            super.fitSystemWindows(rect);
            return false;
        }
        return super.fitSystemWindows(rect);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 9) {
            switch (i3) {
                case 19:
                    if (QLog.isColorLevel()) {
                        QLog.i("placeholder", 2, "SHOW_PLACEHOLDER");
                    }
                    this.f384549f.setOnTouchListener(this.f384550h);
                    removeView(this.f384549f);
                    addView(this.f384549f, new RelativeLayout.LayoutParams(-1, -1));
                    break;
                case 20:
                    if (QLog.isColorLevel()) {
                        QLog.i("placeholder", 2, "HIDE_PLACEHOLDER");
                    }
                    removeView(this.f384549f);
                    break;
                case 21:
                    clearAnimation();
                    break;
            }
        } else {
            LottieAnimationView lottieAnimationView = this.f384548e;
            if (lottieAnimationView != null && this.C) {
                this.C = false;
                removeView(lottieAnimationView);
                this.f384548e = null;
            }
        }
        return false;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) canvas);
        } else {
            super.onDraw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setDispatchTouchEventListener(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) bVar);
        }
    }

    public void setOnInterceptTouchEventListener(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) cVar);
        }
    }

    public void setOnSizeChangeListener(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) dVar);
        }
    }

    @TargetApi(11)
    public FitSystemWindowsRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f384547d = new int[4];
        this.f384548e = null;
        this.f384549f = new View(getContext());
        this.f384550h = new a();
        this.f384551i = false;
        this.f384552m = false;
    }

    public FitSystemWindowsRelativeLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f384547d = new int[4];
        this.f384548e = null;
        this.f384549f = new View(getContext());
        this.f384550h = new a();
        this.f384551i = false;
        this.f384552m = false;
    }
}
