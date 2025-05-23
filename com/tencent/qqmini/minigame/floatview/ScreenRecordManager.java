package com.tencent.qqmini.minigame.floatview;

import android.content.Context;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.engine.ScreenRecordCallback;
import com.tencent.mobileqq.triton.lifecycle.LifeCycle;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.minigame.R;
import com.tencent.qqmini.minigame.helper.b;
import com.tencent.qqmini.minigame.screenrecord.GuideBubbleViewCtrl;
import com.tencent.qqmini.minigame.screenrecord.d;
import com.tencent.qqmini.minigame.ui.GuideBubbleView;
import com.tencent.qqmini.minigame.ui.ScreenRecDragableView;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IScreenRecord;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.utils.LiuHaiUtils;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.widget.MiniToast;
import java.io.File;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes23.dex */
public class ScreenRecordManager extends com.tencent.qqmini.minigame.floatview.a implements IScreenRecord, View.OnClickListener, ScreenRecordCallback, ScreenRecDragableView.a {
    private com.tencent.qqmini.minigame.screenrecord.b C;
    private String D;
    private GuideBubbleView F;
    private boolean H;
    private boolean I;
    private boolean J;
    private com.tencent.qqmini.minigame.screenrecord.a K;

    /* renamed from: m, reason: collision with root package name */
    private ScreenRecDragableView f346384m;
    private GuideBubbleViewCtrl E = new GuideBubbleViewCtrl();
    private int G = 1;
    private long L = 0;
    private int M = 0;
    private final LifeCycle N = new LifeCycle() { // from class: com.tencent.qqmini.minigame.floatview.ScreenRecordManager.1
        @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
        public void onStart() {
            ScreenRecordManager.this.I = false;
            if (ScreenRecordManager.this.G != 5 && ScreenRecordManager.this.J) {
                ScreenRecordManager.this.J = false;
                ScreenRecordManager screenRecordManager = ScreenRecordManager.this;
                if (screenRecordManager.f346399h != null && screenRecordManager.f346384m != null) {
                    ScreenRecordManager.this.f346384m.post(new Runnable() { // from class: com.tencent.qqmini.minigame.floatview.ScreenRecordManager.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ScreenRecordManager screenRecordManager2 = ScreenRecordManager.this;
                            screenRecordManager2.f346399h.prepareScreenRecord(screenRecordManager2.H, ScreenRecordManager.this.K.a(), ScreenRecordManager.this);
                        }
                    });
                }
            }
        }

        @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
        public void onStop() {
            ScreenRecordManager.this.I = true;
        }

        @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
        public void onDestroy() {
        }

        @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
        public void onFirstFrame() {
        }

        @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
        public void onGameLaunched(@NonNull TritonEngine tritonEngine) {
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class a implements b.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f346387a;

        a(int i3) {
            this.f346387a = i3;
        }

        @Override // com.tencent.qqmini.minigame.helper.b.c
        public void a(boolean z16) {
            ScreenRecordManager.this.H = z16;
            ScreenRecordManager.this.M = this.f346387a;
            if (ScreenRecordManager.this.I) {
                ScreenRecordManager.this.J = true;
            } else {
                ScreenRecordManager screenRecordManager = ScreenRecordManager.this;
                screenRecordManager.f346399h.prepareScreenRecord(z16, screenRecordManager.K.a(), ScreenRecordManager.this);
            }
        }
    }

    private com.tencent.qqmini.minigame.screenrecord.b A(int i3, ViewGroup viewGroup) {
        return new d(i3, viewGroup);
    }

    private void B() {
        QMLog.i("floatBox.ScreenRecordManager", "[detachRecordView]");
        if (this.f346396d != null && this.f346384m != null) {
            F(1);
            this.f346396d.removeView(this.f346384m);
            this.f346384m.Q();
            this.f346384m = null;
        }
    }

    private boolean C() {
        if (System.currentTimeMillis() - this.L > 500) {
            this.L = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    private void D() {
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.qqmini.minigame.floatview.ScreenRecordManager.3
            @Override // java.lang.Runnable
            public void run() {
                ScreenRecordManager screenRecordManager = ScreenRecordManager.this;
                screenRecordManager.F = screenRecordManager.E.b(1, ScreenRecordManager.this.f346396d.getContext());
                if (ScreenRecordManager.this.F != null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.topMargin = DisplayUtil.dip2px(ScreenRecordManager.this.F.getContext(), 39.0f);
                    layoutParams.leftMargin = DisplayUtil.dip2px(ScreenRecordManager.this.F.getContext(), 2.0f);
                    ScreenRecordManager screenRecordManager2 = ScreenRecordManager.this;
                    screenRecordManager2.f346396d.addView(screenRecordManager2.F, layoutParams);
                }
            }
        }, 3000L);
    }

    private void E(int i3) {
        QMLog.i("floatBox.ScreenRecordManager", "[startRecord]");
        TritonEngine tritonEngine = this.f346399h;
        if (tritonEngine != null && this.f346396d != null) {
            if (!this.I) {
                tritonEngine.startScreenRecord();
            } else {
                this.J = true;
            }
            if (i3 == 1) {
                SDKMiniProgramLpReportDC04239.report4ScreenRecord(this.f346397e.getMiniAppInfo(), "set", "screenRecord", "screenRecord_on", "", "");
                return;
            } else {
                SDKMiniProgramLpReportDC04239.report4ScreenRecord(this.f346397e.getMiniAppInfo(), "lp", "startRecord", "", "", "");
                return;
            }
        }
        QMLog.e("floatBox.ScreenRecordManager", "[startRecord] mEngine or mRootView is null!");
    }

    private void F(int i3) {
        IMiniAppContext iMiniAppContext = this.f346397e;
        if (iMiniAppContext == null) {
            return;
        }
        this.G = i3;
        MiniAppInfo miniAppInfo = iMiniAppContext.getMiniAppInfo();
        if (miniAppInfo != null) {
            miniAppInfo.recordStatus = i3;
        }
        ScreenRecDragableView screenRecDragableView = this.f346384m;
        if (screenRecDragableView != null) {
            screenRecDragableView.M(i3);
        }
    }

    private ScreenRecDragableView z() {
        return new ScreenRecDragableView(this.f346396d.getContext());
    }

    @Override // com.tencent.qqmini.minigame.ui.ScreenRecDragableView.a
    public void a() {
        stopRecord(0);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IScreenRecord
    public void attachRecordView() {
        int i3;
        QMLog.i("floatBox.ScreenRecordManager", "[attachRecordView]");
        if (this.f346396d == null) {
            return;
        }
        B();
        Context context = this.f346396d.getContext();
        ScreenRecDragableView z16 = z();
        this.f346384m = z16;
        z16.setRecordOvertimeListener(this);
        this.f346384m.setRecorder(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(context, 85.0f), DisplayUtil.dip2px(this.f346396d.getContext(), 29.0f));
        layoutParams.addRule(9, -1);
        int dip2px = DisplayUtil.dip2px(context, 9.0f);
        if (LiuHaiUtils.isLiuHaiUseValid()) {
            i3 = DisplayUtil.getStatusBarHeight(context);
        } else {
            i3 = 0;
        }
        layoutParams.topMargin = dip2px + i3;
        layoutParams.leftMargin = 0;
        this.f346396d.addView(this.f346384m, layoutParams);
        this.G = 2;
        this.f346384m.setOnClickListener(this);
        F(2);
        IMiniAppContext iMiniAppContext = this.f346397e;
        if (iMiniAppContext != null) {
            SDKMiniProgramLpReportDC04239.report4ScreenRecord(iMiniAppContext.getMiniAppInfo(), "lp", "expo", "", "", "");
        }
    }

    @Override // com.tencent.qqmini.minigame.floatview.a
    public void b(String str) {
        attachRecordView();
    }

    @Override // com.tencent.qqmini.minigame.floatview.a
    public void c() {
        detachRecordView(3);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IScreenRecord
    public void detachRecordView(int i3) {
        IMiniAppContext iMiniAppContext;
        B();
        if (i3 == 0 && (iMiniAppContext = this.f346397e) != null) {
            SDKMiniProgramLpReportDC04239.report4ScreenRecord(iMiniAppContext.getMiniAppInfo(), "lp", "disappear", "", "", "0");
        }
    }

    @Override // com.tencent.qqmini.minigame.floatview.a
    public void f() {
        QMLog.i("floatBox.ScreenRecordManager", "[onDestroy]");
        stopRecord(3);
        com.tencent.qqmini.minigame.screenrecord.b bVar = this.C;
        if (bVar != null) {
            bVar.remove();
        }
        detachRecordView(3);
        TritonEngine tritonEngine = this.f346399h;
        if (tritonEngine != null) {
            tritonEngine.removeLifeCycleObserver(this.N);
        }
    }

    @Override // com.tencent.qqmini.minigame.floatview.a
    public void j(TritonEngine tritonEngine) {
        super.j(tritonEngine);
        tritonEngine.observeLifeCycle(this.N);
    }

    @Override // com.tencent.qqmini.minigame.floatview.a
    public void l(MiniAppInfo miniAppInfo) {
        IMiniAppContext iMiniAppContext;
        super.l(miniAppInfo);
        if (miniAppInfo != null && (iMiniAppContext = this.f346397e) != null) {
            this.K = new com.tencent.qqmini.minigame.screenrecord.a(iMiniAppContext.getContext());
            F(this.G);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (C()) {
            QMLog.i("floatBox.ScreenRecordManager", "[onClick],mStatus:" + this.G);
            int i3 = this.G;
            if (i3 == 2) {
                E(0);
            } else if (i3 == 3) {
                if (this.f346384m.N() < 3) {
                    Context context = this.f346384m.getContext();
                    MiniToast.makeText(context, context.getResources().getString(R.string.mini_game_screen_record_at_least_3s), 0).show();
                } else {
                    stopRecord(0);
                    GuideBubbleView guideBubbleView = this.F;
                    if (guideBubbleView != null) {
                        guideBubbleView.setVisibility(8);
                    }
                }
            } else if (i3 == 5) {
                prepareAndStartRecord(0);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.triton.engine.ScreenRecordCallback
    public void onCompleted(@NotNull File file) {
        QMLog.i("floatBox.ScreenRecordManager", "[engine->onCompleted]");
        this.G = 5;
        ScreenRecDragableView screenRecDragableView = this.f346384m;
        if (screenRecDragableView != null && file != null) {
            boolean P = screenRecDragableView.P();
            com.tencent.qqmini.minigame.screenrecord.b A = A(P ? 1 : 0, this.f346396d);
            this.C = A;
            A.a(this.f346397e, this.f346399h, this);
            String absolutePath = file.getAbsolutePath();
            this.D = absolutePath;
            this.C.e(absolutePath, false);
        }
        F(5);
    }

    @Override // com.tencent.mobileqq.triton.engine.ScreenRecordCallback
    public void onFailed(@NotNull Exception exc) {
        QMLog.e("floatBox.ScreenRecordManager", "[onFailed], msg:" + exc);
        if (this.f346396d == null) {
            return;
        }
        F(5);
        Context context = this.f346396d.getContext();
        MiniToast.makeText(context, context.getResources().getString(R.string.mini_game_record_failed), 0).show();
    }

    @Override // com.tencent.mobileqq.triton.engine.ScreenRecordCallback
    public void onInputSurfaceReady(@NonNull Surface surface) {
        QMLog.i("floatBox.ScreenRecordManager", "[engine->onInputSurfaceReady]");
        TritonEngine tritonEngine = this.f346399h;
        if (tritonEngine != null) {
            tritonEngine.onInputSurfaceReady(surface);
        }
    }

    @Override // com.tencent.mobileqq.triton.engine.ScreenRecordCallback
    public void onReady() {
        QMLog.i("floatBox.ScreenRecordManager", "[engine->onReady]");
        E(this.M);
    }

    @Override // com.tencent.mobileqq.triton.engine.ScreenRecordCallback
    public void onRelease() {
        QMLog.i("floatBox.ScreenRecordManager", "[engine->onRelease]");
        TritonEngine tritonEngine = this.f346399h;
        if (tritonEngine != null) {
            tritonEngine.onScreenRecordRelease();
        }
    }

    @Override // com.tencent.mobileqq.triton.engine.ScreenRecordCallback
    public void onStarted() {
        QMLog.i("floatBox.ScreenRecordManager", "[engine->onStarted]");
        F(3);
        D();
    }

    @Override // com.tencent.mobileqq.triton.engine.ScreenRecordCallback
    public void onStopped() {
        QMLog.i("floatBox.ScreenRecordManager", "[engine->onStopped]");
        F(4);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IScreenRecord
    public void prepareAndStartRecord(int i3) {
        QMLog.i("floatBox.ScreenRecordManager", "[prepareAndStartRecord]");
        if (this.f346399h != null && this.f346396d != null) {
            com.tencent.qqmini.minigame.helper.b bVar = new com.tencent.qqmini.minigame.helper.b(this.f346398f, new a(i3), QQPermissionConstants.Permission.RECORD_AUDIO);
            MiniAppInfo miniAppInfo = this.f346397e.getMiniAppInfo();
            bVar.c(miniAppInfo.name, miniAppInfo.iconUrl, this.f346396d.getContext().getString(R.string.mini_sdk_permission_dialog_use_audio_title), this.f346396d.getContext().getString(R.string.mini_sdk_permission_dialog_use_audio_content));
            return;
        }
        QMLog.e("floatBox.ScreenRecordManager", "[prepareAndStartRecord] mEngine or mRootView is null!");
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IScreenRecord
    public void removePreview() {
        QMLog.i("floatBox.ScreenRecordManager", "[removePreview]");
        com.tencent.qqmini.minigame.screenrecord.b bVar = this.C;
        if (bVar == null) {
            return;
        }
        bVar.remove();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IScreenRecord
    public void stopRecord(int i3) {
        QMLog.i("floatBox.ScreenRecordManager", "[stopRecord], from:" + i3);
        TritonEngine tritonEngine = this.f346399h;
        if (tritonEngine == null) {
            return;
        }
        tritonEngine.stopScreenRecord();
        ScreenRecDragableView screenRecDragableView = this.f346384m;
        if (screenRecDragableView == null) {
            return;
        }
        int N = screenRecDragableView.N();
        if (i3 == 1) {
            SDKMiniProgramLpReportDC04239.report4ScreenRecord(this.f346397e.getMiniAppInfo(), "set", "screenRecord", "screenRecord_off", "", String.valueOf(N));
        } else {
            SDKMiniProgramLpReportDC04239.report4ScreenRecord(this.f346397e.getMiniAppInfo(), "lp", "endRecord", "", "", String.valueOf(N));
        }
    }
}
