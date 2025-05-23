package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.filemanager.widget.DragContainerLayout;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoViewFactory;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.DragView;

/* compiled from: P */
/* loaded from: classes12.dex */
public class VideoFileViewer extends com.tencent.mobileqq.filemanager.fileviewer.viewer.a implements View.OnTouchListener {
    private Button H;
    private TextView I;
    private SeekBar J;
    private LinearLayout K;
    private TextView L;
    private TextView M;
    private TextView N;
    private TextView P;
    private DragContainerLayout Q;
    private RelativeLayout R;
    private BaseVideoView S;
    private RelativeLayout T;
    private RelativeLayout U;
    private ImageView V;
    private ValueAnimator W;
    private boolean X;
    private boolean Y;
    private boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f208595a0;

    /* renamed from: b0, reason: collision with root package name */
    private VideoPlayParam f208596b0;

    /* renamed from: c0, reason: collision with root package name */
    private DragView.OnGestureChangeListener f208597c0;

    /* renamed from: d0, reason: collision with root package name */
    private float f208598d0;

    /* renamed from: e0, reason: collision with root package name */
    private float f208599e0;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f208600d;

        a(String str) {
            this.f208600d = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FileManagerUtil.openWithOtherApp(VideoFileViewer.this.f208607f, this.f208600d);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            VideoFileViewer.this.f208607f.finish();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = Float.valueOf(valueAnimator.getAnimatedValue().toString()).floatValue();
            if (VideoFileViewer.this.K.getVisibility() == 0 && Math.abs(VideoFileViewer.this.K.getAlpha() - floatValue) >= 0.02f) {
                VideoFileViewer.this.K.setAlpha(floatValue);
            }
            if (VideoFileViewer.this.K.getVisibility() == 0 && Math.abs(VideoFileViewer.this.K.getAlpha() - floatValue) >= 0.02f) {
                VideoFileViewer.this.K.setAlpha(floatValue);
            }
        }
    }

    public VideoFileViewer(Activity activity) {
        super(activity);
        this.X = false;
        this.Y = false;
        this.Z = false;
        this.f208595a0 = false;
        this.f208596b0 = null;
        this.f208597c0 = new d();
        this.f208598d0 = 0.0f;
        this.f208599e0 = 0.0f;
    }

    private String A(long j3) {
        long j16 = j3 / 1000;
        long j17 = j16 / 86400;
        long j18 = j16 % 86400;
        long j19 = j18 / 3600;
        long j26 = j18 % 3600;
        long j27 = j26 / 60;
        long j28 = j26 % 60;
        if (j17 > 0) {
            return String.format("%02d:%02d:%02d:%02d", Long.valueOf(j17), Long.valueOf(j19), Long.valueOf(j27), Long.valueOf(j28));
        }
        if (j19 > 0) {
            return String.format("%02d:%02d:%02d", Long.valueOf(j19), Long.valueOf(j27), Long.valueOf(j28));
        }
        return String.format("%02d:%02d", Long.valueOf(j27), Long.valueOf(j28));
    }

    public BaseVideoView B() {
        return this.S;
    }

    public void C(long j3, View.OnLongClickListener onLongClickListener) {
        if (this.S == null) {
            this.S = (BaseVideoView) QQVideoViewFactory.createBaseVideoView(this.f208607f, j3, null, null);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13, -1);
            this.S.setLayoutParams(layoutParams);
            DragContainerLayout dragContainerLayout = new DragContainerLayout(this.f208607f);
            this.Q = dragContainerLayout;
            dragContainerLayout.setContainerLongClickListener(onLongClickListener);
            this.Q.addView(this.S);
            int i3 = this.f208607f.getResources().getDisplayMetrics().widthPixels;
            this.Q.setGestureChangeListener(this.f208597c0);
            this.T.addView(this.Q, 0, new RelativeLayout.LayoutParams(-1, -1));
            VideoPlayParam videoPlayParam = this.f208596b0;
            if (videoPlayParam != null) {
                this.S.setVideoParam(videoPlayParam);
            }
        }
    }

    @TargetApi(11)
    public void D() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.3f);
        this.W = ofFloat;
        ofFloat.setDuration(2500L);
        this.W.addUpdateListener(new c());
    }

    public void E() {
        this.K.clearAnimation();
        this.K.setAlpha(1.0f);
    }

    public void F(long j3) {
        this.L.setText(A(j3));
    }

    public void G(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.K.setOnClickListener(onClickListener);
            this.H.setOnClickListener(onClickListener);
            this.I.setOnClickListener(onClickListener);
            this.N.setOnClickListener(onClickListener);
            this.P.setOnClickListener(onClickListener);
        }
    }

    public void H(boolean z16) {
        if (z16) {
            this.H.setBackgroundResource(R.drawable.agg);
            this.H.setContentDescription(this.f208607f.getString(R.string.aaa));
        } else {
            this.H.setBackgroundResource(R.drawable.age);
            this.H.setContentDescription(this.f208607f.getString(R.string.aad));
        }
    }

    public void I(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        if (onSeekBarChangeListener != null) {
            this.J.setOnSeekBarChangeListener(onSeekBarChangeListener);
        }
    }

    public void J(int i3) {
        this.J.setMax(i3);
    }

    public void K(int i3) {
        this.J.setProgress(i3);
    }

    public void L(long j3) {
        this.M.setText(A(j3));
    }

    @TargetApi(16)
    public void M(Drawable drawable) {
        this.S.setBackground(drawable);
    }

    public void N(boolean z16) {
        boolean z17;
        int i3 = 0;
        if (z16 && !this.f208595a0) {
            z17 = true;
        } else {
            z17 = false;
        }
        RelativeLayout relativeLayout = this.R;
        if (!z17) {
            i3 = 8;
        }
        relativeLayout.setVisibility(i3);
        this.Y = z16;
    }

    public void O(String str, String str2) {
        ((ViewGroup) this.f208606e).removeView(this.S);
        RelativeLayout relativeLayout = new RelativeLayout(this.f208607f);
        relativeLayout.setBackgroundColor(Color.parseColor("#D8DAE0"));
        TextView textView = new TextView(this.f208607f);
        textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.e_9, 0, 0);
        textView.setText(str2);
        textView.setTextSize(12.0f);
        textView.setTextColor(Color.parseColor("#83889A"));
        textView.setPadding(0, 15, 0, 0);
        relativeLayout.addView(textView, -2, -2);
        ((RelativeLayout.LayoutParams) textView.getLayoutParams()).addRule(13);
        if (q.f(str)) {
            TextView textView2 = new TextView(this.f208607f);
            textView2.setText("\u7528QQ\u6d4f\u89c8\u5668\u6253\u5f00");
            textView2.setContentDescription("\u7528qq\u6d4f\u89c8\u5668\u6253\u5f00");
            textView2.setTextSize(12.0f);
            textView2.setTextColor(Color.parseColor("#12B7F5"));
            textView2.setOnClickListener(new a(str));
            relativeLayout.addView(textView2, -2, -2);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView2.getLayoutParams();
            layoutParams.addRule(13);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, 0, 40);
            textView2.setLayoutParams(layoutParams);
        }
        ((ViewGroup) this.f208606e).addView(relativeLayout, -1, (int) (((WindowManager) this.f208607f.getSystemService("window")).getDefaultDisplay().getWidth() * 0.75d));
        ((RelativeLayout.LayoutParams) relativeLayout.getLayoutParams()).addRule(13);
        o(false);
        this.H.setVisibility(4);
        this.L.setVisibility(4);
        this.J.setVisibility(4);
        this.M.setVisibility(4);
        this.K.setBackgroundDrawable(null);
        this.f208606e.setOnClickListener(new b());
    }

    public void P(boolean z16) {
        if (z16) {
            this.U.setVisibility(0);
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setDuration(500L);
            rotateAnimation.setRepeatCount(-1);
            rotateAnimation.setRepeatMode(1);
            rotateAnimation.setStartTime(-1L);
            rotateAnimation.setInterpolator(new LinearInterpolator());
            this.V.startAnimation(rotateAnimation);
            return;
        }
        this.f208607f.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.viewer.VideoFileViewer.1
            @Override // java.lang.Runnable
            public void run() {
                if (VideoFileViewer.this.V.getVisibility() == 0) {
                    Animation animation = VideoFileViewer.this.V.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                    }
                    VideoFileViewer.this.V.clearAnimation();
                }
                VideoFileViewer.this.U.setVisibility(8);
            }
        });
    }

    public void Q(boolean z16) {
        Bundle bundle = this.G;
        int i3 = 0;
        if (bundle != null && bundle.getInt("key_source", 0) == 1) {
            z16 = false;
        }
        TextView textView = this.I;
        if (textView != null) {
            if (!z16) {
                i3 = 4;
            }
            textView.setVisibility(i3);
        }
    }

    public void R(boolean z16) {
        int i3;
        TextView textView = this.P;
        if (textView != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            textView.setVisibility(i3);
        }
    }

    public void S(boolean z16) {
        boolean z17;
        int i3 = 0;
        if (z16 && !this.f208595a0) {
            z17 = true;
        } else {
            z17 = false;
        }
        LinearLayout linearLayout = this.K;
        if (!z17) {
            i3 = 8;
        }
        linearLayout.setVisibility(i3);
        this.X = z16;
    }

    public void T() {
        if (this.K.getVisibility() == 0) {
            this.W.cancel();
            this.W.start();
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.viewer.a
    public View a() {
        return this.f208606e;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.viewer.a
    public void f() {
        QLog.i("FileBrowserViewBase", 4, "FileBrowserViewBase: VideoFileViewer initFileView");
        if (this.f208606e == null) {
            View inflate = ((LayoutInflater) BaseApplication.getContext().getSystemService("layout_inflater")).inflate(R.layout.amu, this.f208605d, false);
            this.f208606e = inflate;
            this.L = (TextView) inflate.findViewById(R.id.fxp);
            this.M = (TextView) this.f208606e.findViewById(R.id.f164298rh);
            this.K = (LinearLayout) this.f208606e.findViewById(R.id.koy);
            this.U = (RelativeLayout) this.f208606e.findViewById(R.id.g1k);
            TextView textView = (TextView) this.f208606e.findViewById(R.id.i9b);
            this.P = textView;
            textView.setText(HardCodeUtil.qqStr(R.string.v3x));
            this.V = (ImageView) this.f208606e.findViewById(R.id.g1j);
            this.U.setVisibility(8);
            this.J = (SeekBar) this.f208606e.findViewById(R.id.fvk);
            this.H = (Button) this.f208606e.findViewById(R.id.fuw);
            this.I = (TextView) this.f208606e.findViewById(R.id.epq);
            this.R = (RelativeLayout) this.f208606e.findViewById(R.id.jqf);
            this.N = (TextView) this.f208606e.findViewById(R.id.f164560a44);
            this.T = (RelativeLayout) this.f208606e.findViewById(R.id.c_p);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.viewer.a
    public void o(boolean z16) {
        boolean z17;
        if (z16 && !this.f208595a0) {
            z17 = true;
        } else {
            z17 = false;
        }
        super.o(z17);
        this.Z = z16;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2) {
                float abs = Math.abs(x16 - this.f208598d0);
                float abs2 = Math.abs(y16 - this.f208599e0);
                QLog.i("FileBrowserViewBase", 1, "absX[" + abs + "] --- absY[" + abs2 + "]\uff0cmPressDownY[" + this.f208599e0 + "]\uff0ccurrTouchY\u3010" + y16 + "\u3011");
                if (abs > abs2) {
                    float f16 = this.f208598d0;
                    if (x16 - f16 > 20.0f) {
                        QLog.i("FileBrowserViewBase", 1, "<--  \u5de6\u6ed1");
                        return true;
                    }
                    if (x16 - f16 < -20.0f) {
                        QLog.i("FileBrowserViewBase", 1, "-->  \u53f3\u6ed1");
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        this.f208598d0 = x16;
        this.f208599e0 = y16;
        return false;
    }

    public void z() {
        RelativeLayout relativeLayout = this.T;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class d implements DragView.OnGestureChangeListener {
        d() {
        }

        @Override // com.tencent.widget.DragView.OnGestureChangeListener
        public void onContentMove(float f16) {
            Drawable background;
            Drawable background2;
            VideoFileViewer.this.f208595a0 = true;
            if (VideoFileViewer.this.S != null && (background2 = VideoFileViewer.this.S.getBackground()) != null) {
                background2.mutate().setAlpha(0);
            }
            if (VideoFileViewer.this.T != null && (background = VideoFileViewer.this.T.getBackground()) != null) {
                background.mutate().setAlpha((int) (255.0f * f16));
            }
            if (f16 < 0.8f) {
                VideoFileViewer.this.K.setVisibility(8);
                VideoFileViewer.this.R.setVisibility(8);
                VideoFileViewer.this.f208608h.setVisibility(8);
            }
        }

        @Override // com.tencent.widget.DragView.OnGestureChangeListener
        public void onGestureFinish() {
            VideoFileViewer.this.f208595a0 = false;
            VideoFileViewer.this.F.q();
            VideoFileViewer.this.f208607f.overridePendingTransition(0, 0);
        }

        @Override // com.tencent.widget.DragView.OnGestureChangeListener
        public void onResetPosition() {
            VideoFileViewer.this.f208595a0 = false;
            if (VideoFileViewer.this.X) {
                VideoFileViewer.this.S(true);
            }
            if (VideoFileViewer.this.Y) {
                VideoFileViewer.this.N(true);
            }
            if (VideoFileViewer.this.Z) {
                VideoFileViewer.this.o(true);
            }
        }

        @Override // com.tencent.widget.DragView.OnGestureChangeListener
        public void onClickDragView() {
        }
    }
}
