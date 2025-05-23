package com.tencent.mobileqq.resourcesgrab;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ResourceGrabView extends LinearLayout implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private Button C;
    private Button D;
    private Button E;
    TextView F;
    private WeakReference<Activity> G;
    private Application.ActivityLifecycleCallbacks H;

    /* renamed from: d, reason: collision with root package name */
    private boolean f281254d;

    /* renamed from: e, reason: collision with root package name */
    boolean f281255e;

    /* renamed from: f, reason: collision with root package name */
    private long f281256f;

    /* renamed from: h, reason: collision with root package name */
    private WindowManager.LayoutParams f281257h;

    /* renamed from: i, reason: collision with root package name */
    private WindowManager f281258i;

    /* renamed from: m, reason: collision with root package name */
    private Button f281259m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        float f281260d;

        /* renamed from: e, reason: collision with root package name */
        float f281261e;

        /* renamed from: f, reason: collision with root package name */
        int f281262f;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ResourceGrabView.this);
                return;
            }
            this.f281260d = 0.0f;
            this.f281261e = 0.0f;
            this.f281262f = 0;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        float y16 = motionEvent.getY();
                        ResourceGrabView.this.f281257h.y = (int) (r5.y + ((y16 - this.f281261e) / 3.0f));
                        WindowManager windowManager = ResourceGrabView.this.f281258i;
                        ResourceGrabView resourceGrabView = ResourceGrabView.this;
                        windowManager.updateViewLayout(resourceGrabView, resourceGrabView.f281257h);
                    }
                } else {
                    if (Math.abs(ResourceGrabView.this.f281257h.y - this.f281262f) <= ViewConfiguration.get(view.getContext()).getScaledTouchSlop() && System.currentTimeMillis() - ResourceGrabView.this.f281256f >= 500) {
                        ResourceGrabView.this.k();
                    }
                }
            } else {
                ResourceGrabView.this.f281256f = System.currentTimeMillis();
                this.f281260d = motionEvent.getX();
                this.f281261e = motionEvent.getY();
                this.f281262f = ResourceGrabView.this.f281257h.y;
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements Application.ActivityLifecycleCallbacks {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ResourceGrabView.this);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) bundle);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ResourceGrabView", 2, "onActivityCreated activity: " + activity);
            }
            ResourceGrabView.this.G = new WeakReference(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ResourceGrabView", 2, "onActivityDestroyed activity: " + activity);
            }
            if (activity instanceof BaseActivity) {
                Fragment findFragmentByTag = ((BaseActivity) activity).getSupportFragmentManager().findFragmentByTag("ResourceGrabFragment");
                if (findFragmentByTag instanceof ResourceGrabFragment) {
                    ((ResourceGrabFragment) findFragmentByTag).sh();
                }
            }
            ResourceGrabView.this.G = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ResourceGrabView", 2, "onActivityResumed activity: " + activity);
            }
            ResourceGrabView.this.G = new WeakReference(activity);
            ResourceGrabView resourceGrabView = ResourceGrabView.this;
            resourceGrabView.h(resourceGrabView.f281254d);
            ResourceGrabView.this.n();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity, (Object) bundle);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
            }
        }
    }

    public ResourceGrabView(Context context) {
        this(context, null, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private Activity i() {
        Activity activity;
        WeakReference<Activity> weakReference = this.G;
        if (weakReference != null) {
            activity = weakReference.get();
        } else {
            activity = null;
        }
        if (activity == null) {
            return BaseActivity.sTopActivity;
        }
        return activity;
    }

    private Fragment j() {
        Activity i3 = i();
        if (i3 instanceof BaseActivity) {
            return ((BaseActivity) i3).getSupportFragmentManager().findFragmentByTag("ResourceGrabFragment");
        }
        return null;
    }

    private void l() {
        setOnTouchListener(new a());
    }

    private void m() {
        this.f281258i = (WindowManager) getContext().getSystemService("window");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(ViewUtils.dpToPx(6.0f));
        gradientDrawable.setColor(-1);
        gradientDrawable.setStroke(ViewUtils.dpToPx(1.5f), getResources().getColor(R.color.skin_mode_selected_border_color));
        setBackgroundDrawable(gradientDrawable);
        this.f281259m = (Button) findViewById(R.id.akj);
        this.C = (Button) findViewById(R.id.tgo);
        this.D = (Button) findViewById(R.id.aga);
        this.E = (Button) findViewById(R.id.td_);
        this.F = (TextView) findViewById(R.id.f110736jb);
        this.f281259m.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.D.setOnClickListener(this);
        this.E.setOnClickListener(this);
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        String str;
        String str2;
        Button button = this.f281259m;
        if (this.f281254d) {
            str = "\u5173\u95ed";
        } else {
            str = "\u5f00\u542f";
        }
        button.setText(str);
        Button button2 = this.C;
        if (this.f281255e) {
            str2 = "\u4e0d\u53d1\u9001";
        } else {
            str2 = "\u53d1\u9001";
        }
        button2.setText(str2);
    }

    void h(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("ResourceGrabView", 2, "enableGrabResourceName on: " + z16);
        }
        Fragment j3 = j();
        if (!z16) {
            if (j3 instanceof ResourceGrabFragment) {
                ResourceGrabFragment resourceGrabFragment = (ResourceGrabFragment) j3;
                resourceGrabFragment.rh(this);
                resourceGrabFragment.sh();
                return;
            }
            return;
        }
        if (j3 instanceof ResourceGrabFragment) {
            ResourceGrabFragment resourceGrabFragment2 = (ResourceGrabFragment) j3;
            resourceGrabFragment2.rh(this);
            resourceGrabFragment2.uh();
            return;
        }
        Activity i3 = i();
        if (i3 instanceof BaseActivity) {
            ResourceGrabFragment resourceGrabFragment3 = new ResourceGrabFragment();
            resourceGrabFragment3.rh(this);
            ((BaseActivity) i3).getSupportFragmentManager().beginTransaction().add(resourceGrabFragment3, "ResourceGrabFragment").commitAllowingStateLoss();
            resourceGrabFragment3.uh();
        }
    }

    void k() {
        try {
            this.f281258i.removeView(this);
            com.tencent.mobileqq.resourcesgrab.a.a().f281265a = null;
            h(false);
            BaseApplicationImpl.getApplication().unregisterActivityLifecycleCallbacks(this.H);
        } catch (Exception e16) {
            QLog.d("ResourceGrabView", 1, "hideFromWindow error : " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o() {
        this.f281254d = false;
        this.f281259m.setText("\u5f00\u542f");
        this.f281255e = false;
        this.C.setText("\u53d1\u9001");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.akj) {
                if (this.f281254d) {
                    this.f281259m.setText("\u5f00\u542f");
                    h(false);
                    QQToast.makeText(getContext(), "\u8d44\u6e90\u83b7\u53d6\u529f\u80fd\u5df2\u5173\u95ed", 0).show();
                } else {
                    this.f281259m.setText("\u5173\u95ed");
                    h(true);
                    QQToast.makeText(getContext(), "\u8d44\u6e90\u83b7\u53d6\u529f\u80fd\u5df2\u5f00\u542f", 0).show();
                }
                this.f281254d = !this.f281254d;
            } else if (id5 == R.id.tgo) {
                if (this.f281255e) {
                    this.C.setText("\u53d1\u9001");
                    QQToast.makeText(getContext(), "\u53d1\u9001\u56fe\u7247\u81f3\u6211\u7684\u7535\u8111\u529f\u80fd\u5df2\u5173\u95ed", 0).show();
                } else {
                    this.C.setText("\u4e0d\u53d1\u9001");
                    QQToast.makeText(getContext(), "\u53d1\u9001\u56fe\u7247\u81f3\u6211\u7684\u7535\u8111\u529f\u80fd\u5df2\u5f00\u542f", 0).show();
                }
                this.f281255e = !this.f281255e;
            } else if (id5 == R.id.aga) {
                k();
            } else if (id5 == R.id.td_) {
                this.F.setText("");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public ResourceGrabView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public ResourceGrabView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f281254d = false;
        this.f281255e = false;
        this.f281256f = 0L;
        this.f281257h = new WindowManager.LayoutParams();
        this.H = new b();
        LayoutInflater.from(context).inflate(R.layout.e3j, (ViewGroup) this, true);
        m();
    }
}
