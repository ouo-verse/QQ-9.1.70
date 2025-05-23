package com.tencent.qqmini.minigame.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.minigame.R;
import com.tencent.qqmini.minigame.widget.DragableView;
import com.tencent.qqmini.sdk.launcher.core.IScreenRecord;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes23.dex */
public class ScreenRecDragableView extends DragableView implements View.OnClickListener {
    private RelativeLayout U;
    private FrameLayout V;
    private RelativeLayout W;

    /* renamed from: a0, reason: collision with root package name */
    private CircularProgressView f346772a0;

    /* renamed from: b0, reason: collision with root package name */
    private FrameLayout f346773b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f346774c0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f346775d0;

    /* renamed from: e0, reason: collision with root package name */
    private Handler f346776e0;

    /* renamed from: f0, reason: collision with root package name */
    private int f346777f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f346778g0;

    /* renamed from: h0, reason: collision with root package name */
    private int f346779h0;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f346780i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f346781j0;

    /* renamed from: k0, reason: collision with root package name */
    private a f346782k0;

    /* renamed from: l0, reason: collision with root package name */
    private IScreenRecord f346783l0;

    /* renamed from: m0, reason: collision with root package name */
    private Runnable f346784m0;

    /* renamed from: n0, reason: collision with root package name */
    private int f346785n0;

    /* renamed from: o0, reason: collision with root package name */
    private Runnable f346786o0;

    /* renamed from: p0, reason: collision with root package name */
    float f346787p0;

    /* renamed from: q0, reason: collision with root package name */
    private Runnable f346788q0;

    /* renamed from: r0, reason: collision with root package name */
    private Runnable f346789r0;

    /* renamed from: s0, reason: collision with root package name */
    private Runnable f346790s0;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface a {
        void a();
    }

    public ScreenRecDragableView(Context context) {
        super(context);
        this.f346775d0 = false;
        this.f346776e0 = new Handler(Looper.getMainLooper());
        this.f346777f0 = 0;
        this.f346778g0 = false;
        this.f346779h0 = 1;
        this.f346780i0 = false;
        this.f346781j0 = true;
        this.f346784m0 = new Runnable() { // from class: com.tencent.qqmini.minigame.ui.ScreenRecDragableView.1
            @Override // java.lang.Runnable
            public void run() {
                ScreenRecDragableView.this.f346780i0 = true;
                if (ScreenRecDragableView.this.f346779h0 == 3) {
                    ScreenRecDragableView.this.f346775d0 = false;
                    return;
                }
                ScreenRecDragableView.this.f346775d0 = true;
                ScreenRecDragableView.this.U.setVisibility(8);
                ScreenRecDragableView.this.V.setVisibility(0);
                ScreenRecDragableView.this.W.setVisibility(8);
            }
        };
        this.f346785n0 = 1;
        this.f346786o0 = new Runnable() { // from class: com.tencent.qqmini.minigame.ui.ScreenRecDragableView.2
            @Override // java.lang.Runnable
            public void run() {
                ScreenRecDragableView.this.W(0.65f);
            }
        };
        this.f346787p0 = 0.0f;
        this.f346788q0 = new Runnable() { // from class: com.tencent.qqmini.minigame.ui.ScreenRecDragableView.3
            @Override // java.lang.Runnable
            public void run() {
                ScreenRecDragableView screenRecDragableView = ScreenRecDragableView.this;
                float f16 = screenRecDragableView.f346787p0 + 5.5555553f;
                screenRecDragableView.f346787p0 = f16;
                if (f16 >= 1000.0f) {
                    screenRecDragableView.f346787p0 = 1000.0f;
                }
                screenRecDragableView.f346772a0.setProgress(ScreenRecDragableView.this.f346787p0);
                ScreenRecDragableView.this.f346776e0.postDelayed(this, 1000L);
            }
        };
        this.f346789r0 = new Runnable() { // from class: com.tencent.qqmini.minigame.ui.ScreenRecDragableView.4
            @Override // java.lang.Runnable
            public void run() {
                ScreenRecDragableView.L(ScreenRecDragableView.this);
                if (ScreenRecDragableView.this.P() && ScreenRecDragableView.this.f346782k0 != null) {
                    ScreenRecDragableView.this.f346782k0.a();
                    return;
                }
                if (ScreenRecDragableView.this.f346777f0 == 176) {
                    ScreenRecDragableView.this.f346776e0.post(ScreenRecDragableView.this.f346790s0);
                }
                ScreenRecDragableView.this.f346776e0.postDelayed(this, 1000L);
                ScreenRecDragableView.this.f346774c0.setText(ScreenRecDragableView.O(ScreenRecDragableView.this.f346777f0));
            }
        };
        this.f346790s0 = new Runnable() { // from class: com.tencent.qqmini.minigame.ui.ScreenRecDragableView.5
            @Override // java.lang.Runnable
            public void run() {
                if (ScreenRecDragableView.this.f346781j0) {
                    ScreenRecDragableView.this.f346774c0.setVisibility(8);
                    ScreenRecDragableView.this.f346781j0 = false;
                } else {
                    ScreenRecDragableView.this.f346774c0.setVisibility(0);
                    ScreenRecDragableView.this.f346781j0 = true;
                }
                ScreenRecDragableView.this.f346776e0.postDelayed(this, 300L);
            }
        };
    }

    static /* synthetic */ int L(ScreenRecDragableView screenRecDragableView) {
        int i3 = screenRecDragableView.f346777f0;
        screenRecDragableView.f346777f0 = i3 + 1;
        return i3;
    }

    public static String O(int i3) {
        String valueOf;
        String valueOf2;
        int i16 = i3 / 60;
        int i17 = i3 % 60;
        if (i16 < 10) {
            valueOf = "0" + i16;
        } else {
            valueOf = String.valueOf(i16);
        }
        if (i17 < 10) {
            valueOf2 = "0" + i17;
        } else {
            valueOf2 = String.valueOf(i17);
        }
        return valueOf + ":" + valueOf2;
    }

    private void R() {
        QMLog.i("ScreenRecDragView", "[onReady]");
        this.U.setVisibility(0);
        this.V.setVisibility(8);
        this.W.setVisibility(8);
        this.f346774c0.setVisibility(0);
        V();
        this.f346787p0 = 0.0f;
        this.f346772a0.setProgress(0.0f);
        this.f346777f0 = 0;
        this.f346774c0.setText(QzoneConfig.ALBUM_RECOM_EVENT_ALGO_USER_SAMPLE_DEFAULT);
        U();
    }

    private void S() {
        QMLog.i("ScreenRecDragView", "[onRecording]");
        this.U.setVisibility(8);
        this.V.setVisibility(8);
        this.W.setVisibility(0);
        V();
        this.f346776e0.postDelayed(this.f346788q0, 1000L);
        this.f346776e0.postDelayed(this.f346789r0, 1000L);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.W.getLayoutParams();
        if (this.f346785n0 == 1) {
            layoutParams.leftMargin = 0;
        } else {
            layoutParams.leftMargin = DisplayUtil.dip2px(getContext(), 15.0f);
        }
    }

    private void T() {
        QMLog.i("ScreenRecDragView", "[onStopped]");
        V();
        this.U.setVisibility(8);
        this.V.setVisibility(8);
        this.W.setVisibility(0);
    }

    private void U() {
        this.f346776e0.removeCallbacks(this.f346786o0);
        this.f346776e0.postDelayed(this.f346786o0, 5000L);
    }

    private void V() {
        this.f346776e0.removeCallbacks(this.f346788q0);
        this.f346776e0.removeCallbacks(this.f346786o0);
        this.f346776e0.removeCallbacks(this.f346789r0);
        this.f346776e0.removeCallbacks(this.f346790s0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(float f16) {
        if (this.W == null) {
            return;
        }
        this.U.setAlpha(f16);
        int childCount = this.U.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            this.U.getChildAt(i3).setAlpha(f16);
        }
    }

    public void M(int i3) {
        this.f346779h0 = i3;
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 != 5) {
                        return;
                    }
                } else {
                    T();
                    return;
                }
            } else {
                S();
                return;
            }
        }
        R();
    }

    public int N() {
        return this.f346777f0;
    }

    public boolean P() {
        if (this.f346777f0 > 180) {
            return true;
        }
        return false;
    }

    public void Q() {
        QMLog.i("ScreenRecDragView", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        V();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqmini.minigame.widget.DragableView
    public boolean e(MotionEvent motionEvent) {
        W(1.0f);
        return super.e(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqmini.minigame.widget.DragableView
    public boolean f(MotionEvent motionEvent) {
        if (this.f346775d0) {
            removeCallbacks(this.f346784m0);
            return super.f(motionEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqmini.minigame.widget.DragableView
    public boolean g() {
        if (this.f346775d0) {
            return super.g();
        }
        QMLog.i("ScreenRecDragView", "mIsLongPressed:" + this.f346780i0 + ",mLastAction:" + this.C);
        if (this.f346780i0) {
            this.f346780i0 = false;
            return false;
        }
        if (!this.f346864f || this.C == 0) {
            performClick();
        }
        return false;
    }

    @Override // com.tencent.qqmini.minigame.widget.DragableView
    public void i() {
        LayoutInflater.from(getContext()).inflate(R.layout.mini_sdk_screen_recorder_drag_view, (ViewGroup) this, true);
        this.U = (RelativeLayout) findViewById(R.id.rl_static_container);
        this.V = (FrameLayout) findViewById(R.id.rl_drag_container);
        this.W = (RelativeLayout) findViewById(R.id.rl_recording_container);
        this.f346772a0 = (CircularProgressView) findViewById(R.id.iv_recording_icon);
        this.f346773b0 = (FrameLayout) findViewById(R.id.iv_remove_panel);
        this.f346774c0 = (TextView) findViewById(R.id.tv_timing);
        this.f346773b0.setOnClickListener(this);
    }

    @Override // com.tencent.qqmini.minigame.widget.DragableView
    public void o(int i3) {
        this.f346785n0 = i3;
        this.f346780i0 = false;
        if (i3 == 1) {
            RelativeLayout relativeLayout = this.U;
            Resources resources = getContext().getResources();
            int i16 = R.drawable.mini_sdk_screen_recorder_init_left_background;
            relativeLayout.setBackgroundDrawable(resources.getDrawable(i16));
            this.W.setBackgroundDrawable(getContext().getResources().getDrawable(i16));
        } else {
            RelativeLayout relativeLayout2 = this.U;
            Resources resources2 = getContext().getResources();
            int i17 = R.drawable.mini_sdk_screen_recorder_init_right_background;
            relativeLayout2.setBackgroundDrawable(resources2.getDrawable(i17));
            this.W.setBackgroundDrawable(getContext().getResources().getDrawable(i17));
        }
        this.U.setVisibility(0);
        this.V.setVisibility(8);
        this.W.setVisibility(8);
        U();
        QMLog.i("ScreenRecDragView", "[onViewLanded], mIsLongPressed:" + this.f346780i0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IScreenRecord iScreenRecord;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.f346773b0 && (iScreenRecord = this.f346783l0) != null) {
            iScreenRecord.detachRecordView(0);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.qqmini.minigame.widget.DragableView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean e16;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    return false;
                }
                e16 = f(motionEvent);
            } else {
                e16 = g();
                removeCallbacks(this.f346784m0);
                this.f346775d0 = false;
            }
        } else {
            e16 = e(motionEvent);
            postDelayed(this.f346784m0, ViewConfiguration.getLongPressTimeout());
        }
        this.C = actionMasked;
        return e16;
    }

    public void setRecordOvertimeListener(a aVar) {
        this.f346782k0 = aVar;
    }

    public void setRecorder(IScreenRecord iScreenRecord) {
        this.f346783l0 = iScreenRecord;
    }

    public ScreenRecDragableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f346775d0 = false;
        this.f346776e0 = new Handler(Looper.getMainLooper());
        this.f346777f0 = 0;
        this.f346778g0 = false;
        this.f346779h0 = 1;
        this.f346780i0 = false;
        this.f346781j0 = true;
        this.f346784m0 = new Runnable() { // from class: com.tencent.qqmini.minigame.ui.ScreenRecDragableView.1
            @Override // java.lang.Runnable
            public void run() {
                ScreenRecDragableView.this.f346780i0 = true;
                if (ScreenRecDragableView.this.f346779h0 == 3) {
                    ScreenRecDragableView.this.f346775d0 = false;
                    return;
                }
                ScreenRecDragableView.this.f346775d0 = true;
                ScreenRecDragableView.this.U.setVisibility(8);
                ScreenRecDragableView.this.V.setVisibility(0);
                ScreenRecDragableView.this.W.setVisibility(8);
            }
        };
        this.f346785n0 = 1;
        this.f346786o0 = new Runnable() { // from class: com.tencent.qqmini.minigame.ui.ScreenRecDragableView.2
            @Override // java.lang.Runnable
            public void run() {
                ScreenRecDragableView.this.W(0.65f);
            }
        };
        this.f346787p0 = 0.0f;
        this.f346788q0 = new Runnable() { // from class: com.tencent.qqmini.minigame.ui.ScreenRecDragableView.3
            @Override // java.lang.Runnable
            public void run() {
                ScreenRecDragableView screenRecDragableView = ScreenRecDragableView.this;
                float f16 = screenRecDragableView.f346787p0 + 5.5555553f;
                screenRecDragableView.f346787p0 = f16;
                if (f16 >= 1000.0f) {
                    screenRecDragableView.f346787p0 = 1000.0f;
                }
                screenRecDragableView.f346772a0.setProgress(ScreenRecDragableView.this.f346787p0);
                ScreenRecDragableView.this.f346776e0.postDelayed(this, 1000L);
            }
        };
        this.f346789r0 = new Runnable() { // from class: com.tencent.qqmini.minigame.ui.ScreenRecDragableView.4
            @Override // java.lang.Runnable
            public void run() {
                ScreenRecDragableView.L(ScreenRecDragableView.this);
                if (ScreenRecDragableView.this.P() && ScreenRecDragableView.this.f346782k0 != null) {
                    ScreenRecDragableView.this.f346782k0.a();
                    return;
                }
                if (ScreenRecDragableView.this.f346777f0 == 176) {
                    ScreenRecDragableView.this.f346776e0.post(ScreenRecDragableView.this.f346790s0);
                }
                ScreenRecDragableView.this.f346776e0.postDelayed(this, 1000L);
                ScreenRecDragableView.this.f346774c0.setText(ScreenRecDragableView.O(ScreenRecDragableView.this.f346777f0));
            }
        };
        this.f346790s0 = new Runnable() { // from class: com.tencent.qqmini.minigame.ui.ScreenRecDragableView.5
            @Override // java.lang.Runnable
            public void run() {
                if (ScreenRecDragableView.this.f346781j0) {
                    ScreenRecDragableView.this.f346774c0.setVisibility(8);
                    ScreenRecDragableView.this.f346781j0 = false;
                } else {
                    ScreenRecDragableView.this.f346774c0.setVisibility(0);
                    ScreenRecDragableView.this.f346781j0 = true;
                }
                ScreenRecDragableView.this.f346776e0.postDelayed(this, 300L);
            }
        };
    }

    public ScreenRecDragableView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f346775d0 = false;
        this.f346776e0 = new Handler(Looper.getMainLooper());
        this.f346777f0 = 0;
        this.f346778g0 = false;
        this.f346779h0 = 1;
        this.f346780i0 = false;
        this.f346781j0 = true;
        this.f346784m0 = new Runnable() { // from class: com.tencent.qqmini.minigame.ui.ScreenRecDragableView.1
            @Override // java.lang.Runnable
            public void run() {
                ScreenRecDragableView.this.f346780i0 = true;
                if (ScreenRecDragableView.this.f346779h0 == 3) {
                    ScreenRecDragableView.this.f346775d0 = false;
                    return;
                }
                ScreenRecDragableView.this.f346775d0 = true;
                ScreenRecDragableView.this.U.setVisibility(8);
                ScreenRecDragableView.this.V.setVisibility(0);
                ScreenRecDragableView.this.W.setVisibility(8);
            }
        };
        this.f346785n0 = 1;
        this.f346786o0 = new Runnable() { // from class: com.tencent.qqmini.minigame.ui.ScreenRecDragableView.2
            @Override // java.lang.Runnable
            public void run() {
                ScreenRecDragableView.this.W(0.65f);
            }
        };
        this.f346787p0 = 0.0f;
        this.f346788q0 = new Runnable() { // from class: com.tencent.qqmini.minigame.ui.ScreenRecDragableView.3
            @Override // java.lang.Runnable
            public void run() {
                ScreenRecDragableView screenRecDragableView = ScreenRecDragableView.this;
                float f16 = screenRecDragableView.f346787p0 + 5.5555553f;
                screenRecDragableView.f346787p0 = f16;
                if (f16 >= 1000.0f) {
                    screenRecDragableView.f346787p0 = 1000.0f;
                }
                screenRecDragableView.f346772a0.setProgress(ScreenRecDragableView.this.f346787p0);
                ScreenRecDragableView.this.f346776e0.postDelayed(this, 1000L);
            }
        };
        this.f346789r0 = new Runnable() { // from class: com.tencent.qqmini.minigame.ui.ScreenRecDragableView.4
            @Override // java.lang.Runnable
            public void run() {
                ScreenRecDragableView.L(ScreenRecDragableView.this);
                if (ScreenRecDragableView.this.P() && ScreenRecDragableView.this.f346782k0 != null) {
                    ScreenRecDragableView.this.f346782k0.a();
                    return;
                }
                if (ScreenRecDragableView.this.f346777f0 == 176) {
                    ScreenRecDragableView.this.f346776e0.post(ScreenRecDragableView.this.f346790s0);
                }
                ScreenRecDragableView.this.f346776e0.postDelayed(this, 1000L);
                ScreenRecDragableView.this.f346774c0.setText(ScreenRecDragableView.O(ScreenRecDragableView.this.f346777f0));
            }
        };
        this.f346790s0 = new Runnable() { // from class: com.tencent.qqmini.minigame.ui.ScreenRecDragableView.5
            @Override // java.lang.Runnable
            public void run() {
                if (ScreenRecDragableView.this.f346781j0) {
                    ScreenRecDragableView.this.f346774c0.setVisibility(8);
                    ScreenRecDragableView.this.f346781j0 = false;
                } else {
                    ScreenRecDragableView.this.f346774c0.setVisibility(0);
                    ScreenRecDragableView.this.f346781j0 = true;
                }
                ScreenRecDragableView.this.f346776e0.postDelayed(this, 300L);
            }
        };
    }
}
