package com.tencent.mobileqq.widget.qqfloatingscreen.uiwrapper;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.intervideo.yiqikan.g;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageWrapper;
import gh2.b;
import gh2.e;
import gh2.f;

/* compiled from: P */
/* loaded from: classes20.dex */
public class FloatingWatchTogetherWrapper extends com.tencent.mobileqq.qqfloatingwindow.a implements b, IVideoOuterStatusListener {
    public static final String CLASS_NAME = "com.tencent.mobileqq.widget.qqfloatingscreen.uiwrapper.FloatingWatchTogetherWrapper";
    public static final int WAIT_ACTIVITY_ANIM_END_MILLIS = 500;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f317186e;

    /* renamed from: f, reason: collision with root package name */
    private IVideoInnerStatusListener f317187f;

    public FloatingWatchTogetherWrapper(Context context) {
        super(context);
        R(this);
    }

    private void p0() {
        View A = A(R.id.m2t);
        A.setContentDescription("\u4e00\u8d77\u770b\u60ac\u6d6e\u7a97");
        if (ThemeImageWrapper.isNightMode()) {
            A.setBackgroundColor(Color.parseColor("#4D000000"));
        } else {
            A.setBackgroundColor(Color.parseColor("#00000000"));
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a
    public void B(Context context) {
        super.B(context);
        K("\u5173\u95ed\u4e00\u8d77\u770b\u60ac\u6d6e\u7a97");
        ImageView imageView = (ImageView) A(R.id.m2q);
        this.f317186e = imageView;
        imageView.setContentDescription(HardCodeUtil.qqStr(R.string.mlo));
        g0(this, this.f317186e);
        i0(false, this.f317186e);
        p0();
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a
    public void J(FloatingScreenParams floatingScreenParams) {
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(FloatingScreenParams.QQFS_SP_NAME, 4);
        int i3 = sharedPreferences.getInt("KEY_QQFS_WATCH_TOGETHER_CENTER_X", Integer.MIN_VALUE);
        int i16 = sharedPreferences.getInt("KEY_QQFS_WATCH_TOGETHER_CENTER_Y", Integer.MIN_VALUE);
        if (i3 != Integer.MIN_VALUE && i16 != Integer.MIN_VALUE) {
            floatingScreenParams.setFloatingCenterX(i3);
            floatingScreenParams.setFloatingCenterY(i16);
        }
        if (QLog.isColorLevel()) {
            QLog.d("FloatingWatchTogetherWrapper", 2, "restoreLastCenterPosition: invoked. ", " centerX: ", Integer.valueOf(i3), " centerY: ", Integer.valueOf(i16));
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a
    public IVideoOuterStatusListener M(IVideoInnerStatusListener iVideoInnerStatusListener) {
        this.f317187f = iVideoInnerStatusListener;
        return this;
    }

    @Override // gh2.b
    public boolean d(int i3, int i16, int i17) {
        return false;
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, fh2.a
    public void initStatusReceiver() {
        g(2, new a());
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a
    public int j(final FloatingScreenParams floatingScreenParams, final View view) {
        if (floatingScreenParams == null) {
            if (v() != null) {
                floatingScreenParams = new FloatingScreenParams.FloatingBuilder().setShapeType(1).setCanZoom(false).build();
            } else {
                return 2;
            }
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.widget.qqfloatingscreen.uiwrapper.FloatingWatchTogetherWrapper.2
            @Override // java.lang.Runnable
            public void run() {
                FloatingWatchTogetherWrapper.this.initWidgetWrapper(view);
                FloatingWatchTogetherWrapper.this.setRoundCorners(floatingScreenParams.getInnerRoundCorner(), floatingScreenParams.getOuterRoundCorner());
                FloatingWatchTogetherWrapper.this.G();
                FloatingWatchTogetherWrapper.this.k(floatingScreenParams);
                FloatingWatchTogetherWrapper.this.updateFloatingView();
                FloatingWatchTogetherWrapper.this.initStatusReceiver();
            }
        }, 500L);
        return 0;
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.m2q) {
            IVideoInnerStatusListener iVideoInnerStatusListener = this.f317187f;
            if (iVideoInnerStatusListener != null) {
                iVideoInnerStatusListener.notifyVideoStart();
            }
        } else {
            super.onClick(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener
    public void onSetVideoCover(Bitmap bitmap) {
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener
    public void onVideoStart(int i3) {
        i0(false, this.f317186e);
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener
    public void onVideoStop() {
        i0(true, this.f317186e);
    }

    public void q0() {
        if (!t()) {
            boolean p16 = p();
            SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences(FloatingScreenParams.QQFS_SP_NAME, 4).edit();
            int r16 = r();
            int s16 = s();
            edit.putInt("KEY_QQFS_WATCH_TOGETHER_CENTER_X", r16);
            edit.putInt("KEY_QQFS_WATCH_TOGETHER_CENTER_Y", s16);
            edit.apply();
            if (QLog.isColorLevel()) {
                QLog.d("FloatingWatchTogetherWrapper", 2, "saveFloatingCenter: invoked. ", " centerX: ", Integer.valueOf(r16), " centerY: ", Integer.valueOf(s16), " isSmallFloating: ", Boolean.valueOf(p16));
            }
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, fh2.b
    public void quitWindowFloat(final int i3) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.widget.qqfloatingscreen.uiwrapper.FloatingWatchTogetherWrapper.3
            @Override // java.lang.Runnable
            public void run() {
                FloatingWatchTogetherWrapper.super.quitWindowFloat(i3);
                FloatingWatchTogetherWrapper.this.q0();
            }
        });
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener
    public void onSetVideoCover(Drawable drawable) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements f {
        a() {
        }

        @Override // gh2.f
        public void a() {
            FloatingWatchTogetherWrapper.this.U(false);
        }

        @Override // gh2.f
        public void b() {
            g.k().h(2);
        }

        @Override // gh2.f
        public void d(boolean z16) {
            FloatingWatchTogetherWrapper.this.U(true);
        }

        @Override // gh2.f
        public /* synthetic */ void e() {
            e.a(this);
        }

        @Override // gh2.f
        public void c() {
        }
    }

    @Override // gh2.b
    public void onDragEnd() {
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener
    public void onVideoBuffering() {
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener
    public void onOrientationChange(boolean z16) {
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener
    public void onVideoComplete(boolean z16) {
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener
    public void onVideoError(int i3) {
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener
    public void onVideoProgressUpdate(int i3) {
    }

    @Override // gh2.b
    public void e(int i3, int i16) {
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener
    public void onVideoSize(int i3, int i16) {
    }
}
