package com.tencent.av.ui.part.base;

import android.app.Activity;
import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoLayerUIBase;
import com.tencent.av.ui.m;
import com.tencent.av.utils.SignalStrengthReport;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* loaded from: classes32.dex */
public class AVSharpInfoPart extends nw.a {

    /* renamed from: i, reason: collision with root package name */
    private WeakReference<VideoAppInterface> f76226i;

    /* renamed from: m, reason: collision with root package name */
    private WeakReference<Context> f76227m;

    /* renamed from: e, reason: collision with root package name */
    private TextView f76223e = null;

    /* renamed from: f, reason: collision with root package name */
    private GestureDetector f76224f = null;

    /* renamed from: h, reason: collision with root package name */
    private ShowSharpInfoRunnable f76225h = null;
    View.OnTouchListener C = new a();
    GestureDetector.OnGestureListener D = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class ShowSharpInfoRunnable implements Runnable {
        ShowSharpInfoRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String A0;
            String str;
            if (AVSharpInfoPart.this.f76223e == null || AVSharpInfoPart.this.f76226i == null || r.h0() == null) {
                return;
            }
            SessionInfo f16 = n.e().f();
            if (VideoLayerUIBase.O0(f16)) {
                A0 = f16.f73028g2;
            } else {
                A0 = r.h0().A0();
            }
            if (A0 == null) {
                A0 = "null";
            }
            try {
                A0 = A0 + "\r\n";
                if (com.tencent.av.utils.e.j()) {
                    A0 = A0 + SignalStrengthReport.e(VideoAppInterface.N().getApp().getApplicationContext()).k();
                }
                str = A0 + "\r\n";
            } catch (Exception e16) {
                QLog.e(((nw.a) AVSharpInfoPart.this).f421444d, 1, "ShowSharpInfoRunnable exception : " + e16);
                str = A0;
            }
            AVSharpInfoPart.this.f76223e.setText(str);
            QLog.w(((nw.a) AVSharpInfoPart.this).f421444d, 1, "ShowSharpInfo\n" + str);
            ((VideoAppInterface) AVSharpInfoPart.this.f76226i.get()).M().postDelayed(this, 1000L);
        }
    }

    /* loaded from: classes32.dex */
    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (AVSharpInfoPart.this.f76224f != null) {
                return AVSharpInfoPart.this.f76224f.onTouchEvent(motionEvent);
            }
            return false;
        }
    }

    public void F9(boolean z16) {
        if (this.f76223e == null) {
            return;
        }
        boolean z17 = z16 && QLog.isColorLevel();
        if (z17) {
            this.f76223e.setVisibility(0);
        } else {
            this.f76223e.setVisibility(8);
        }
        com.tencent.av.utils.e.f77110b = z17;
        H9(z17);
    }

    void G9(boolean z16) {
        if (this.f76225h == null) {
            this.f76225h = new ShowSharpInfoRunnable();
        }
        WeakReference<VideoAppInterface> weakReference = this.f76226i;
        if (weakReference != null) {
            if (z16) {
                weakReference.get().M().post(this.f76225h);
            } else {
                weakReference.get().M().removeCallbacks(this.f76225h);
            }
        }
    }

    public void H9(boolean z16) {
        G9(z16);
    }

    @Override // nw.a
    public void onDestroy() {
        super.onDestroy();
        this.f76223e = null;
        this.f76224f = null;
        WeakReference<VideoAppInterface> weakReference = this.f76226i;
        if (weakReference != null) {
            weakReference.get().M().removeCallbacks(this.f76225h);
        }
        this.f76225h = null;
    }

    @Override // nw.a, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        z9(getContext(), nw.b.b());
        super.onInitView(view);
        AVActivity x95 = x9(this.f76227m);
        if (x95 == null) {
            if (QLog.isColorLevel()) {
                QLog.e(this.f421444d, 2, "initUI-->can not get AVActivity");
            }
        } else {
            this.f76223e = (TextView) x95.findViewById(m.l.f76079y);
            this.f76224f = new GestureDetector(this.f76227m.get(), this.D);
            this.f76223e.setOnTouchListener(this.C);
            this.f76223e.setMovementMethod(ScrollingMovementMethod.getInstance());
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        onDestroy();
    }

    @Override // nw.a
    public void z9(Context context, AppInterface appInterface) {
        super.z9(context, appInterface);
        this.f76226i = new WeakReference<>((VideoAppInterface) appInterface);
        this.f76227m = new WeakReference<>(context);
    }

    /* loaded from: classes32.dex */
    class b implements GestureDetector.OnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (AVSharpInfoPart.this.f76223e != null && AVSharpInfoPart.this.f76223e.isShown()) {
                AVSharpInfoPart.this.F9(false);
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
        }
    }
}
