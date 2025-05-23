package com.tencent.av.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.utils.at;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class VideoInviteFloatBar implements View.OnTouchListener, View.OnClickListener {
    TextView G;
    TextView H;
    WindowManager J;

    /* renamed from: d, reason: collision with root package name */
    private Context f75176d;

    /* renamed from: f, reason: collision with root package name */
    private WindowManager.LayoutParams f75178f;

    /* renamed from: h, reason: collision with root package name */
    private View f75179h;

    /* renamed from: i, reason: collision with root package name */
    private float f75180i;

    /* renamed from: e, reason: collision with root package name */
    private boolean f75177e = false;

    /* renamed from: m, reason: collision with root package name */
    public boolean f75181m = false;
    boolean C = false;
    boolean D = true;
    boolean E = false;
    Intent F = null;
    private Handler I = new Handler();
    private Runnable K = new Runnable() { // from class: com.tencent.av.ui.VideoInviteFloatBar.1
        @Override // java.lang.Runnable
        public void run() {
            VideoInviteFloatBar.this.b();
        }
    };

    public VideoInviteFloatBar(Context context) {
        this.f75176d = context;
        this.J = (WindowManager) context.getSystemService("window");
        View inflate = ((LayoutInflater) this.f75176d.getSystemService("layout_inflater")).inflate(R.layout.f168524zl, (ViewGroup) null);
        this.f75179h = inflate;
        inflate.setOnTouchListener(this);
    }

    public TextView a() {
        return (TextView) this.f75179h.findViewById(R.id.f5e);
    }

    public void b() {
        Log.i("VideoInviteFloatBar", "hide");
        if (!this.f75177e) {
            return;
        }
        this.f75177e = false;
        try {
            if (QLog.isColorLevel()) {
                QLog.d("VideoInviteFloatBar", 2, "hide removeView start");
            }
            WindowManager windowManager = this.J;
            if (windowManager != null) {
                windowManager.removeView(this.f75179h);
            }
            if (QLog.isColorLevel()) {
                QLog.d("VideoInviteFloatBar", 2, "hide removeView end");
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("VideoInviteFloatBar", 2, "hide error : " + e16);
            }
        }
    }

    void c() {
        if (QLog.isColorLevel()) {
            QLog.d("VideoInviteFloatBar", 2, "initTN");
        }
        try {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.f75178f = layoutParams;
            layoutParams.height = -2;
            layoutParams.width = -1;
            layoutParams.flags = 2098088;
            if (Build.VERSION.SDK_INT >= 26) {
                layoutParams.type = 2038;
            } else {
                layoutParams.type = 2010;
            }
            layoutParams.format = -3;
            layoutParams.flags = 2098088 | 67108864;
            layoutParams.gravity = 49;
            layoutParams.windowAnimations = R.style.f174190sg;
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        try {
            if (QLog.isColorLevel()) {
                QLog.d("VideoInviteFloatBar", 2, "startHandler addView start");
            }
            this.J.addView(this.f75179h, this.f75178f);
            this.f75177e = true;
            if (QLog.isColorLevel()) {
                QLog.d("VideoInviteFloatBar", 2, "startHandler addView end");
            }
        } catch (WindowManager.BadTokenException e17) {
            if (QLog.isColorLevel()) {
                QLog.d("VideoInviteFloatBar", 2, "startHandler error : " + e17);
            }
        } catch (IllegalStateException e18) {
            this.J.updateViewLayout(this.f75179h, this.f75178f);
            if (QLog.isColorLevel()) {
                QLog.d("VideoInviteFloatBar", 2, "startHandler error : " + e18);
            }
        } catch (SecurityException e19) {
            if (QLog.isColorLevel()) {
                QLog.d("VideoInviteFloatBar", 2, "startHandler error : " + e19);
            }
        } catch (Exception e26) {
            AVCoreLog.printErrorLog("VideoInviteFloatBar", "startHandler error : " + e26);
        }
    }

    public void d() {
        Button button = (Button) this.f75179h.findViewById(R.id.f163839w);
        Button button2 = (Button) this.f75179h.findViewById(R.id.i6k);
        button.setVisibility(4);
        button2.setVisibility(4);
        this.H.setVisibility(4);
        this.f75179h.invalidate();
    }

    public void e(Bitmap bitmap) {
        ((ImageView) this.f75179h.findViewById(R.id.c0o)).setImageBitmap(bitmap);
    }

    public void f(Bitmap bitmap, String str) {
        ((ImageView) this.f75179h.findViewById(R.id.c0o)).setImageBitmap(bitmap);
        ((TextView) this.f75179h.findViewById(R.id.f5e)).setText(str);
    }

    public void g(String str) {
        TextView textView = (TextView) this.f75179h.findViewById(R.id.eqq);
        this.G = textView;
        textView.setText(str);
        this.f75179h.invalidate();
    }

    public void h(String str) {
        ((TextView) this.f75179h.findViewById(R.id.f5e)).setText(str);
    }

    public void i(String str) {
        TextView textView = (TextView) this.f75179h.findViewById(R.id.jm6);
        this.H = textView;
        textView.setText(str);
        this.f75179h.invalidate();
    }

    public void j(String str) {
        TextView textView = (TextView) this.f75179h.findViewById(R.id.eqq);
        this.G = textView;
        textView.setText(str);
        this.f75179h.invalidate();
    }

    public void k(boolean z16, boolean z17, boolean z18) {
        this.D = z16;
        this.E = z17;
        this.C = z18;
        QLog.w("VideoInviteFloatBar", 1, "show, mIsAudioMode[" + this.D + "], misMultiCall[" + this.E + "], mIsMultiIncomingCall[" + this.C + "]");
        if (this.f75177e) {
            return;
        }
        TextView textView = (TextView) this.f75179h.findViewById(R.id.eqq);
        Button button = (Button) this.f75179h.findViewById(R.id.f163839w);
        Button button2 = (Button) this.f75179h.findViewById(R.id.i6k);
        button.setClickable(true);
        button2.setClickable(true);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        if (z18) {
            if (this.D) {
                textView.setText(textView.getResources().getString(R.string.d8o));
            } else {
                textView.setText(textView.getResources().getString(R.string.d8p));
            }
        } else if (this.D) {
            textView.setText(textView.getResources().getString(R.string.d8n));
        } else {
            textView.setText(textView.getResources().getString(R.string.d8q));
        }
        c();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f163839w) {
            long d16 = com.tencent.av.utils.e.d();
            QLog.w("VideoInviteFloatBar", 1, "onClick accept, mIsMultiIncomingCall[" + this.C + "], misMultiCall[" + this.E + "], seq[" + d16 + "]");
            Intent intent = new Intent();
            at.f(intent, d16);
            if (this.C) {
                intent.setAction("tencent.video.invite.multiaccept");
            } else if (this.E) {
                intent.setAction("tencent.video.invite.gaaccept");
            } else {
                intent.setAction("tencent.video.invite.accept");
            }
            ((Button) this.f75179h.findViewById(R.id.f163839w)).setClickable(false);
            ((Button) this.f75179h.findViewById(R.id.i6k)).setClickable(false);
            intent.setPackage(this.f75176d.getPackageName());
            this.f75176d.sendBroadcast(intent);
        } else if (id5 == R.id.i6k) {
            long d17 = com.tencent.av.utils.e.d();
            QLog.w("VideoInviteFloatBar", 1, "onClick reject, mIsMultiIncomingCall[" + this.C + "], misMultiCall[" + this.E + "], seq[" + d17 + "]");
            Intent intent2 = new Intent();
            at.f(intent2, d17);
            if (this.C) {
                intent2.setAction("tencent.video.invite.multirefuse");
            } else if (this.E) {
                intent2.setAction("tencent.video.invite.gaignore");
            } else {
                intent2.setAction("tencent.video.invite.refuse");
            }
            intent2.setPackage(this.f75176d.getPackageName());
            this.f75176d.sendBroadcast(intent2);
            b();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Log.i("currP", "currX" + motionEvent.getRawX() + "====currY" + motionEvent.getRawY());
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 && motionEvent.getY() - this.f75180i < 0.0f) {
                b();
            }
        } else {
            motionEvent.getX();
            this.f75180i = motionEvent.getY();
        }
        return true;
    }
}
