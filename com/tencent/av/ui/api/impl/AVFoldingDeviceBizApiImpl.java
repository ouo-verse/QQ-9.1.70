package com.tencent.av.ui.api.impl;

import android.content.Context;
import android.provider.Settings;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.foldable.FoldInfoUtils;
import com.tencent.av.foldable.h;
import com.tencent.av.n;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.ui.aj;
import com.tencent.av.ui.api.IAVFoldingDeviceBizApi;
import com.tencent.av.ui.chatroom.VideoChatRoomUIContoller;
import com.tencent.av.ui.x;
import com.tencent.av.utils.ba;
import com.tencent.av.widget.RotateLayout;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AVFoldingDeviceBizApiImpl implements IAVFoldingDeviceBizApi {
    public static final int LARGE_SCREEN_FOLDING_MODE = 1;
    private static final int LARGE_SCREEN_NORMAL_MODE = 0;
    private static final int SYSTEM_FOLDING_MODE_CLOSE = 0;
    private static final int SYSTEM_FOLDING_MODE_OPEN = 1;
    public static final String TAG = "AVFoldingDeviceBizApiImpl";
    private WeakReference<Context> mContext;
    private com.tencent.av.foldable.f mFoldInfoTracker;
    private int mFoldingMode = 0;
    private final h.a<Integer> mFoldStateListener = new h.a() { // from class: com.tencent.av.ui.api.impl.d
        @Override // com.tencent.av.foldable.h.a
        public final void a(Object obj) {
            AVFoldingDeviceBizApiImpl.this.lambda$new$0((Integer) obj);
        }
    };
    private int mFoldingState = 0;
    private int mGestureRotation = 0;
    private a mLargeScreenDeviceOrientationEventListener = null;
    private final h.a<Integer> mOpenStateListener = new h.a() { // from class: com.tencent.av.ui.api.impl.e
        @Override // com.tencent.av.foldable.h.a
        public final void a(Object obj) {
            AVFoldingDeviceBizApiImpl.this.lambda$new$1((Integer) obj);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a extends OrientationEventListener {
        public a(Context context, int i3) {
            super(context, i3);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i3) {
            AVActivity activity;
            if (AVFoldingDeviceBizApiImpl.this.isInFoldingMode() || (activity = AVFoldingDeviceBizApiImpl.this.getActivity()) == null || activity.isDestroyed()) {
                return;
            }
            int i16 = 0;
            try {
                if (Settings.System.getInt(activity.getContentResolver(), "accelerometer_rotation") == 0) {
                    AVFoldingDeviceBizApiImpl.this.rotateControlPanel(0);
                    return;
                }
            } catch (Settings.SettingNotFoundException e16) {
                QLog.e(AVFoldingDeviceBizApiImpl.TAG, 1, "get ACCELEROMETER_ROTATION error: " + e16);
            }
            if (i3 == -1 || activity.isFinishing()) {
                return;
            }
            if (i3 >= 45 && i3 < 135) {
                i16 = 90;
            } else if (i3 >= 135 && i3 < 225) {
                i16 = 180;
            } else if (i3 >= 225 && i3 < 314) {
                i16 = 270;
            }
            AVFoldingDeviceBizApiImpl.this.rotateControlPanel(i16);
        }
    }

    private void changeQavPanelFoldingMode(int i3) {
        final AVActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) activity.findViewById(R.id.g7p);
        if (i3 == 1 && relativeLayout != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.av.ui.api.impl.g
                @Override // java.lang.Runnable
                public final void run() {
                    AVFoldingDeviceBizApiImpl.this.lambda$changeQavPanelFoldingMode$5(activity);
                }
            });
            return;
        }
        aj ajVar = activity.I0;
        if (ajVar == null || ajVar.p() == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.tencent.av.ui.api.impl.f
            @Override // java.lang.Runnable
            public final void run() {
                AVFoldingDeviceBizApiImpl.lambda$changeQavPanelFoldingMode$4(AVActivity.this);
            }
        });
    }

    private void changeUIFoldingMode(int i3) {
        changeQavPanelFoldingMode(i3);
        changeVideoViewFoldingMode(i3);
        AVActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new b(this));
    }

    private void changeVideoViewFoldingMode(int i3) {
        VideoLayerUI videoLayerUI;
        AVActivity activity = getActivity();
        if (activity == null || (videoLayerUI = activity.J0) == null) {
            return;
        }
        int o26 = videoLayerUI.o2();
        SessionInfo f16 = n.e().f();
        QLog.d(TAG, 1, "changeVideoViewFoldingMode curLayoutMode=" + o26 + " session[remote=" + f16.O + " local=" + f16.N);
        if (i3 == 1) {
            if (o26 != 7 && (o26 != 1 || !f16.O || !f16.N)) {
                if (o26 != 8 && (f16.O || f16.N)) {
                    changeDoubleFoldingRotation(9);
                }
            } else {
                changeDoubleFoldingRotation(8);
            }
            if (!activity.I0.I()) {
                activity.H0.k0(new Object[]{110, Long.valueOf(com.tencent.av.utils.e.d())});
            }
            activity.getWindow().addFlags(1024);
            return;
        }
        if ((o26 == 8 && isInOpenState()) || (o26 == 1 && isInOpenState() && f16.N && f16.O)) {
            changeDoubleFoldingRotation(7);
        } else {
            if (o26 == 7 && isInOpenState()) {
                return;
            }
            changeDoubleFoldingRotation(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AVActivity getActivity() {
        WeakReference<Context> weakReference = this.mContext;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return (AVActivity) this.mContext.get();
    }

    private int getFinalFoldingMode() {
        if (isInOpenState()) {
            return this.mFoldingMode;
        }
        return 0;
    }

    private void handleFoldingState(final int i3) {
        final AVActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.tencent.av.ui.api.impl.c
            @Override // java.lang.Runnable
            public final void run() {
                AVFoldingDeviceBizApiImpl.this.lambda$handleFoldingState$3(i3, activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$changeQavPanelFoldingMode$4(AVActivity aVActivity) {
        aj ajVar = aVActivity.I0;
        if (ajVar == null || ajVar.p() == null) {
            return;
        }
        aVActivity.I0.p().setPanelBottomMargin(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$changeQavPanelFoldingMode$5(AVActivity aVActivity) {
        aj ajVar = aVActivity.I0;
        if (ajVar == null || ajVar.p() == null) {
            return;
        }
        rotateControlPanel(FoldInfoUtils.j(aVActivity) ? 270 : 90);
        aVActivity.I0.p().setPanelBottomMargin(Math.max((int) (((ba.getScreenWidth(aVActivity) / 4.0f) - (ba.dp2px(aVActivity, 64.0f) / 2.0f)) - 32.0f), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(Integer num) {
        this.mFoldingMode = num.intValue();
        changeUIFoldingMode(getFinalFoldingMode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(Integer num) {
        int intValue = num.intValue();
        this.mFoldingState = intValue;
        handleFoldingState(intValue);
        AVActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new b(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$2() {
        changeUIFoldingMode(getFinalFoldingMode());
    }

    private void onStart() {
        if (this.mLargeScreenDeviceOrientationEventListener == null) {
            this.mLargeScreenDeviceOrientationEventListener = new a(this.mContext.get(), 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rotateControlPanel(int i3) {
        aj ajVar;
        AVActivity activity = getActivity();
        if (activity == null || activity.isDestroyed()) {
            return;
        }
        VideoChatRoomUIContoller videoChatRoomUIContoller = activity.f74657h1;
        if (videoChatRoomUIContoller != null) {
            videoChatRoomUIContoller.w(i3);
        }
        RelativeLayout relativeLayout = (RelativeLayout) activity.findViewById(R.id.g7p);
        if (relativeLayout == null || (ajVar = activity.I0) == null || ajVar.p() == null) {
            return;
        }
        RotateLayout.LayoutParams layoutParams = (RotateLayout.LayoutParams) relativeLayout.getLayoutParams();
        if (layoutParams.f77225a == i3) {
            return;
        }
        layoutParams.f77225a = i3;
        relativeLayout.requestLayout();
        VideoLayerUI videoLayerUI = activity.J0;
        if (videoLayerUI != null) {
            videoLayerUI.d3(i3);
        } else {
            this.mGestureRotation = i3;
        }
    }

    @Override // com.tencent.av.ui.api.IAVFoldingDeviceBizApi
    public void changeDoubleFoldingRotation(final int i3) {
        AVActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        final boolean isInFoldingMode = isInFoldingMode();
        final int i16 = activity.S0;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "changeDoubleFoldingRotation isFoldingMode=" + isInFoldingMode + " rotationAngle = " + i16, new Throwable("\u6253\u5370\u5806\u6808"));
        }
        activity.runOnUiThread(new Runnable() { // from class: com.tencent.av.ui.api.impl.AVFoldingDeviceBizApiImpl.1
            @Override // java.lang.Runnable
            public void run() {
                AVActivity activity2 = AVFoldingDeviceBizApiImpl.this.getActivity();
                if (activity2 == null) {
                    return;
                }
                boolean j3 = FoldInfoUtils.j(activity2);
                int i17 = j3 ? 270 : 90;
                activity2.m4(j3, isInFoldingMode);
                if (!isInFoldingMode) {
                    i17 = 0;
                }
                activity2.U2(i3);
                VideoLayerUI videoLayerUI = activity2.J0;
                if (videoLayerUI != null) {
                    videoLayerUI.T1(i3);
                    activity2.J0.e1((i16 + i17) % 360, false);
                }
                activity2.j3(com.tencent.av.utils.e.d(), i17);
            }
        });
    }

    @Override // com.tencent.av.ui.api.IAVFoldingDeviceBizApi
    public void enableOrientation() {
        a aVar = this.mLargeScreenDeviceOrientationEventListener;
        if (aVar != null) {
            aVar.enable();
        }
    }

    @Override // com.tencent.av.ui.api.IAVFoldingDeviceBizApi
    public int getPanelRotation() {
        return this.mGestureRotation;
    }

    @Override // com.tencent.av.ui.api.IAVFoldingDeviceBizApi
    public void handleVideoCountChangeLayout(boolean z16, boolean z17) {
        VideoLayerUI videoLayerUI;
        AVActivity activity = getActivity();
        if (activity == null || (videoLayerUI = activity.J0) == null) {
            return;
        }
        int o26 = videoLayerUI.o2();
        if (z16) {
            if (!isInFoldingMode()) {
                if (o26 == 1 && z17 && isInOpenState()) {
                    changeDoubleFoldingRotation(7);
                    return;
                }
                return;
            }
            if (o26 == 1 || !z17) {
                changeDoubleFoldingRotation(9);
                return;
            } else {
                if (o26 == 9) {
                    changeDoubleFoldingRotation(8);
                    return;
                }
                return;
            }
        }
        if (!isInFoldingMode()) {
            if (o26 == 7) {
                changeDoubleFoldingRotation(1);
            }
        } else if (o26 == 9) {
            changeDoubleFoldingRotation(1);
        } else if (o26 == 8) {
            changeDoubleFoldingRotation(9);
        }
    }

    @Override // com.tencent.av.ui.api.IAVFoldingDeviceBizApi
    public void hideNavBarForOppoFindN() {
        Window window;
        View decorView;
        AVActivity activity = getActivity();
        if (activity == null || !x.g(activity) || !isInOpenState() || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 2 | 4 | 2048);
        window.clearFlags(134217728);
        window.addFlags(Integer.MIN_VALUE);
        window.setNavigationBarColor(-16777216);
    }

    @Override // com.tencent.av.ui.api.IAVFoldingDeviceBizApi
    public void init(Context context, boolean z16) {
        this.mContext = new WeakReference<>(context);
        this.mFoldInfoTracker = new com.tencent.av.foldable.f(context);
        if (x.g(context) && !z16) {
            this.mFoldInfoTracker.e(this.mFoldStateListener);
            this.mFoldInfoTracker.f(this.mOpenStateListener);
        }
        onStart();
    }

    @Override // com.tencent.av.ui.api.IAVFoldingDeviceBizApi
    public boolean isInFoldingMode() {
        return getFinalFoldingMode() == 1;
    }

    @Override // com.tencent.av.ui.api.IAVFoldingDeviceBizApi
    public boolean isInOpenState() {
        return this.mFoldingState == 1;
    }

    @Override // com.tencent.av.ui.api.IAVFoldingDeviceBizApi
    public void onCreateUI() {
        com.tencent.av.foldable.f fVar;
        AVActivity activity = getActivity();
        if (activity == null || (fVar = this.mFoldInfoTracker) == null) {
            return;
        }
        fVar.h(activity.getResources().getConfiguration());
    }

    @Override // com.tencent.av.ui.api.IAVFoldingDeviceBizApi
    public void onDestroy() {
        onStop();
        com.tencent.av.foldable.f fVar = this.mFoldInfoTracker;
        if (fVar != null) {
            fVar.a();
        }
    }

    @Override // com.tencent.av.ui.api.IAVFoldingDeviceBizApi
    public void onResume(boolean z16) {
        com.tencent.av.foldable.f fVar;
        AVActivity activity = getActivity();
        if (activity == null || (fVar = this.mFoldInfoTracker) == null) {
            return;
        }
        fVar.g();
        this.mFoldInfoTracker.h(activity.getResources().getConfiguration());
        this.mFoldingState = this.mFoldInfoTracker.c();
        if (!x.g(activity) || z16) {
            return;
        }
        this.mFoldingMode = this.mFoldInfoTracker.b();
        ((RelativeLayout) activity.findViewById(R.id.g7p)).post(new Runnable() { // from class: com.tencent.av.ui.api.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                AVFoldingDeviceBizApiImpl.this.lambda$onResume$2();
            }
        });
    }

    @Override // com.tencent.av.ui.api.IAVFoldingDeviceBizApi
    public void onStop() {
        a aVar = this.mLargeScreenDeviceOrientationEventListener;
        if (aVar != null) {
            aVar.disable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleFoldingState$3(int i3, AVActivity aVActivity) {
        if (i3 == 0) {
            onStop();
            aVActivity.a4();
            if (aVActivity.isDestroyed()) {
                return;
            }
            changeDoubleFoldingRotation(1);
            aj ajVar = aVActivity.I0;
            if (ajVar == null || ajVar.p() == null) {
                return;
            }
            aVActivity.I0.p().setPanelBottomMargin(0);
            rotateControlPanel(0);
            return;
        }
        aVActivity.d4();
        onStart();
        if (aVActivity.isDestroyed()) {
            return;
        }
        changeUIFoldingMode(getFinalFoldingMode());
    }
}
