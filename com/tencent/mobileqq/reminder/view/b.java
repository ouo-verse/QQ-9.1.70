package com.tencent.mobileqq.reminder.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b extends ReportDialog implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private ImageView C;
    private ImageView D;
    private TextView E;
    private TextView F;
    private TextView G;
    private RelativeLayout H;
    private RoundRelativeLayout I;
    private LinearLayout J;
    private InterfaceC8509b K;
    private final GestureDetector.OnGestureListener L;
    private GestureDetector M;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends GestureDetector.SimpleOnGestureListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, motionEvent, motionEvent2, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
            }
            if (QLog.isColorLevel()) {
                QLog.d("ReminderCustomDialog", 2, "[onFling] e1:" + motionEvent.getActionMasked() + ",e2:" + motionEvent2.getActionMasked() + ",velocityX:" + f16 + ",velocityY:" + f17);
            }
            if (f17 < 0.0f && Math.abs(f17) > Math.abs(f16) && b.this.K != null) {
                b.this.K.onFlingUp();
            }
            return false;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.reminder.view.b$b, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public interface InterfaceC8509b {
        void onClick();

        void onClose();

        void onFlingUp();
    }

    public b(Context context, int i3) {
        super(context, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, i3);
        } else {
            this.L = new a();
            P();
        }
    }

    private void P() {
        super.getWindow().setWindowAnimations(R.style.f243751n);
        getWindow().setDimAmount(0.5f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean Q(View view, MotionEvent motionEvent) {
        this.M.onTouchEvent(motionEvent);
        return false;
    }

    public b R(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (b) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        this.G.setText(str);
        return this;
    }

    public b S(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (b) iPatchRedirector.redirect((short) 8, (Object) this, z16);
        }
        this.G.setSingleLine(z16);
        return this;
    }

    public b U(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (b) iPatchRedirector.redirect((short) 10, (Object) this, i3);
        }
        if (i3 < 1) {
            this.I.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.J.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).leftMargin = ViewUtils.dpToPx(12.0f);
            }
            this.J.requestLayout();
        } else {
            this.D.setBackgroundResource(i3);
        }
        return this;
    }

    public b W(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (b) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        }
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#f5f5f5"));
        if (TextUtils.isEmpty(str)) {
            QLog.e("ReminderCustomDialog", 1, "[setIconUrl] url is empty");
            this.I.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.J.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).leftMargin = ViewUtils.dpToPx(12.0f);
            }
            this.J.requestLayout();
        } else {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mFailedDrawable = colorDrawable;
            obtain.mLoadingDrawable = colorDrawable;
            this.D.setBackground(URLDrawable.getDrawable(str, obtain));
        }
        return this;
    }

    public void X(InterfaceC8509b interfaceC8509b) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) interfaceC8509b);
        } else {
            this.K = interfaceC8509b;
        }
    }

    public b Y(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (b) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        this.F.setText(str);
        return this;
    }

    public b Z(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (b) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            this.E.setVisibility(8);
        } else {
            this.E.setText(str);
        }
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view);
        } else if (this.K != null) {
            int id5 = view.getId();
            if (id5 == R.id.dum) {
                this.K.onClose();
            } else if (id5 == R.id.idg) {
                this.K.onClick();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.app.Dialog
    public void setContentView(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        super.setContentView(i3);
        this.C = (ImageView) findViewById(R.id.dum);
        this.D = (ImageView) findViewById(R.id.dvu);
        this.E = (TextView) findViewById(R.id.f112086mz);
        this.F = (TextView) findViewById(R.id.kbs);
        this.G = (TextView) findViewById(R.id.k6s);
        this.H = (RelativeLayout) findViewById(R.id.idg);
        this.I = (RoundRelativeLayout) findViewById(R.id.f75653zj);
        this.J = (LinearLayout) findViewById(R.id.f166091ed3);
        this.I.f316195e = ViewUtils.dpToPx(4.0f);
        this.C.setOnClickListener(this);
        this.M = new GestureDetector(getContext(), this.L);
        this.H.setOnClickListener(this);
        this.H.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.reminder.view.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean Q;
                Q = b.this.Q(view, motionEvent);
                return Q;
            }
        });
        int dip2px = ViewUtils.dip2px(10.0f);
        BaseAIOUtils.h(this.C, dip2px, dip2px, dip2px, dip2px);
    }
}
