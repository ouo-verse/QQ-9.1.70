package com.tencent.aelight.camera.aioeditor.takevideo;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.util.g;
import com.tencent.aelight.camera.aioeditor.capture.view.ProviderView;
import com.tencent.aelight.camera.aioeditor.capture.view.StaticStickerProviderView;
import com.tencent.aelight.camera.aioeditor.editipc.a;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.SendPanelManager;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.entry.api.IAECameraEntryManager;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;
import com.tencent.aelight.camera.report.api.IAEBaseReportParam;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.aj;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.LiuHaiUtils;
import cooperation.peak.PeakConstants;
import cooperation.qzone.widget.QzoneEmotionUtils;

/* compiled from: P */
/* loaded from: classes32.dex */
public class EditVideoStoryButton extends u implements View.OnClickListener {
    private ViewGroup C;
    private RelativeLayout D;
    private View E;
    private int F;
    private com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e G;
    EditVideoPartManager H;
    private String I;
    float J;
    boolean K;
    float L;
    private Dialog M;
    int N;
    aj P;

    /* renamed from: d, reason: collision with root package name */
    private long f67853d;

    /* renamed from: e, reason: collision with root package name */
    private long f67854e;

    /* renamed from: f, reason: collision with root package name */
    private ProviderView f67855f;

    /* renamed from: h, reason: collision with root package name */
    private DoodleLayout f67856h;

    /* renamed from: i, reason: collision with root package name */
    FrameLayout f67857i;

    /* renamed from: m, reason: collision with root package name */
    View f67858m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoStoryButton$2, reason: invalid class name */
    /* loaded from: classes32.dex */
    public class AnonymousClass2 implements a.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f67862a;

        /* compiled from: P */
        /* renamed from: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoStoryButton$2$1, reason: invalid class name */
        /* loaded from: classes32.dex */
        class AnonymousClass1 implements g.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f67864a;

            AnonymousClass1(String str) {
                this.f67864a = str;
            }

            @Override // com.tencent.aelight.camera.ae.util.g.a
            public void onFail() {
                ms.a.c("EditVideoStoryButton", "uploadArkVideo---generate gif onFail:");
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoStoryButton.2.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        EditVideoStoryButton.this.p0();
                        EditVideoStoryButton.this.mParent.L0();
                    }
                });
            }

            @Override // com.tencent.aelight.camera.ae.util.g.a
            public void onSuccess(String str) {
                ms.a.f("EditVideoStoryButton", "uploadArkVideo---generate gif onSuccess, gifPath=" + str);
                com.tencent.aelight.camera.aioeditor.editipc.a.n(str, QzoneEmotionUtils.SIGN_ICON_URL_END, new a.h() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoStoryButton.2.1.1
                    @Override // com.tencent.aelight.camera.aioeditor.editipc.a.h
                    public void onCancel() {
                        EditVideoStoryButton.this.p0();
                    }

                    @Override // com.tencent.aelight.camera.aioeditor.editipc.a.h
                    public void onFail() {
                        EditVideoStoryButton.this.p0();
                        EditVideoStoryButton.this.mParent.L0();
                    }

                    @Override // com.tencent.aelight.camera.aioeditor.editipc.a.h
                    public void onSuccess(final String str2) {
                        ms.a.f("EditVideoStoryButton", "uploadArkVideo---upload gif onSuccess, gifPath=" + str2);
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoStoryButton.2.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Point c16 = com.tencent.aelight.camera.ae.util.a.f65756a.c(AnonymousClass2.this.f67862a);
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                EditVideoStoryButton.this.mParent.F("video", anonymousClass1.f67864a, str2, c16.x, c16.y);
                                EditVideoStoryButton.this.E0(100);
                                EditVideoStoryButton.this.p0();
                            }
                        });
                    }

                    @Override // com.tencent.aelight.camera.aioeditor.editipc.a.h
                    public void onProgress(int i3) {
                    }
                });
            }
        }

        AnonymousClass2(String str) {
            this.f67862a = str;
        }

        @Override // com.tencent.aelight.camera.aioeditor.editipc.a.h
        public void onCancel() {
            ms.a.f("EditVideoStoryButton", "uploadArkVideo---onCancel:");
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoStoryButton.2.3
                @Override // java.lang.Runnable
                public void run() {
                    EditVideoStoryButton.this.p0();
                }
            });
        }

        @Override // com.tencent.aelight.camera.aioeditor.editipc.a.h
        public void onFail() {
            ms.a.c("EditVideoStoryButton", "uploadArkVideo---onFail:");
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoStoryButton.2.2
                @Override // java.lang.Runnable
                public void run() {
                    EditVideoStoryButton.this.p0();
                    EditVideoStoryButton.this.mParent.L0();
                }
            });
        }

        @Override // com.tencent.aelight.camera.aioeditor.editipc.a.h
        public void onProgress(final int i3) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoStoryButton.2.4
                @Override // java.lang.Runnable
                public void run() {
                    EditVideoStoryButton.this.E0(i3);
                }
            });
        }

        @Override // com.tencent.aelight.camera.aioeditor.editipc.a.h
        public void onSuccess(String str) {
            ms.a.f("EditVideoStoryButton", "uploadArkVideo---onSuccess: videoDownLoadUrl=" + str);
            com.tencent.aelight.camera.ae.util.g.f65767a.b(this.f67862a, EditVideoStoryButton.this.mParent.f67785f0, 1000L, new AnonymousClass1(str));
        }
    }

    public EditVideoStoryButton(EditVideoPartManager editVideoPartManager) {
        super(editVideoPartManager);
        this.F = 0;
        this.L = 3.0f;
        this.N = -1;
        this.H = editVideoPartManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0() {
        if (this.mParent.C.l("VIDEO_STORY_JUMP_TO_TYPE", 0) == 2) {
            return false;
        }
        return this.mParent.i1();
    }

    private void C0(int i3) {
        aj ajVar = this.P;
        if (ajVar == null) {
            return;
        }
        ajVar.t();
        this.P.i(i3);
        this.P.p(true);
        this.P.m(false);
        this.P.q(String.valueOf(i3) + "%");
        if (QLog.isColorLevel()) {
            QLog.w("EditVideoStoryButton", 2, "[setProgress] current:" + this.P.a() + ", progress:" + i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0(int i3) {
        if (A0()) {
            i3 = (int) (((i3 * 50.0f) / 100.0f) + 50.0f);
        }
        C0(i3);
    }

    private aj o0() {
        aj ajVar = new aj(getContext());
        ajVar.h(BaseAIOUtils.f(50.0f, getResources()));
        ajVar.f(true);
        ajVar.o(false);
        ajVar.r(-1);
        ajVar.e(0);
        ajVar.j(-15550475);
        ajVar.l(3);
        ajVar.E = true;
        ajVar.A = 2;
        ajVar.n(true);
        ajVar.g(new a());
        return ajVar;
    }

    private void q0() {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.f67854e < 800 || this.mUi.getActivity().isFinishing()) {
            return;
        }
        this.f67854e = uptimeMillis;
        QLog.i("[vs_publish_flow] ", 1, "on vs publish button click");
        ((IAEBaseReportParam) QRoute.api(IAEBaseReportParam.class)).resetEditInfo();
        if (A0() && !NetworkUtil.isNetworkAvailable()) {
            QQToast.makeText(getContext(), getContext().getString(R.string.f173056gt1), 0).show();
            return;
        }
        this.mParent.Q0();
        ((IAEBaseDataReporter) QRoute.api(IAEBaseDataReporter.class)).reportPostBtn();
        ((IAEBaseReportParam) QRoute.api(IAEBaseReportParam.class)).clearLatestPostMd5();
        if (this.mParent.l0()) {
            com.tencent.aelight.camera.aioeditor.b.f(this.mParent);
        } else {
            com.tencent.aelight.camera.aioeditor.b.g(this.mParent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(String str) {
        com.tencent.aelight.camera.aioeditor.editipc.a.n(str, ".mp4", new AnonymousClass2(str));
    }

    private Bundle u0() {
        Bundle bundle = this.mParent.Y;
        if (bundle != null) {
            return bundle.getBundle(ParseCommon.CONTAINER);
        }
        return null;
    }

    private void w0() {
        if (this.f67855f == null) {
            StaticStickerProviderView staticStickerProviderView = new StaticStickerProviderView(getContext());
            this.f67855f = staticStickerProviderView;
            staticStickerProviderView.setTabBarPosition(1);
            this.f67857i.addView(this.f67855f);
        }
        ProviderView providerView = this.f67855f;
        if (providerView == null) {
            if (QLog.isColorLevel()) {
                QLog.e("EditVideoStoryButton", 2, "build provider view failed ");
                return;
            }
            return;
        }
        if (!providerView.s()) {
            if (this.mParent.U != null) {
                int o16 = this.f67855f.o();
                int height = this.mParent.U.getHeight();
                if (height <= 0) {
                    height = LiuHaiUtils.BOTTOM_HEIGHT;
                }
                this.f67855f.m(o16 + ((int) UIUtils.o(getContext(), height)));
            }
            this.f67855f.v(u0());
        }
        this.f67855f.setVisibility(0);
        this.f67855f.y();
        this.f67857i.setVisibility(0);
        this.f67858m.setVisibility(0);
    }

    public void B0(String str, boolean z16, int i3) {
        if (this.M == null) {
            ReportDialog reportDialog = new ReportDialog(getContext());
            this.M = reportDialog;
            Window window = reportDialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable());
                window.setDimAmount(0.0f);
            }
            this.M.requestWindowFeature(1);
            this.M.setContentView(R.layout.ba8);
            ImageView imageView = (ImageView) this.M.findViewById(R.id.g1f);
            aj o06 = o0();
            this.P = o06;
            imageView.setImageDrawable(o06);
        }
        ((TextView) this.M.findViewById(R.id.f166327f13)).setText(str);
        this.M.setCancelable(z16);
        this.M.setCanceledOnTouchOutside(z16);
        this.P.i(0);
        getUi().getRootView().postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoStoryButton.3
            @Override // java.lang.Runnable
            public void run() {
                EditVideoStoryButton.this.M.show();
            }
        }, i3);
    }

    public void D0(int i3) {
        if (A0()) {
            i3 = (int) ((i3 * 50.0f) / 100.0f);
        }
        C0(i3);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoStateChanged(int i3, int i16, Object obj) {
        super.editVideoStateChanged(i3, i16, obj);
        if (i16 == 0) {
            if (i3 == 6) {
                y0(true, true, false);
            } else {
                x0(true, false);
            }
            n0();
            this.F = i16;
            this.G = null;
            return;
        }
        if (i16 == 3) {
            w0();
            return;
        }
        if (i16 == 6) {
            x0(false, false);
            return;
        }
        if (i16 != 20) {
            n0();
            return;
        }
        this.F = i16;
        if (obj instanceof com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e) {
            this.G = (com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e) obj;
        }
    }

    public void n0() {
        this.f67857i.setVisibility(8);
        this.f67858m.setVisibility(8);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public boolean onBackPressed() {
        return System.currentTimeMillis() < this.mAnimationEndTime;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (Math.abs(SystemClock.uptimeMillis() - this.f67853d) > 500) {
            this.f67853d = SystemClock.uptimeMillis();
            int id5 = view.getId();
            if (this.mAnimationEndTime > System.currentTimeMillis()) {
                hd0.c.v("EditVideoStoryButton", "animation is playing, please wait, animation end time: %d, now: %d.", Long.valueOf(this.mAnimationEndTime), Long.valueOf(System.currentTimeMillis()));
            } else {
                this.mParent.I();
                EditVideoDoodle editVideoDoodle = this.mParent.I;
                if (editVideoDoodle != null && this.f67856h == null) {
                    DoodleLayout V = editVideoDoodle.V();
                    this.f67856h = V;
                    V.setEditMode(false);
                    if (this.mParent.C.q() && this.mParent.f0() != null && !this.mParent.f0().getTakePicToVideo()) {
                        this.f67856h.setEditMode(true);
                    }
                }
                switch (id5) {
                    case R.id.s4g /* 2097545895 */:
                        this.mParent.n1();
                        break;
                    case R.id.s4h /* 2097545896 */:
                        ms.a.f("EditVideoStoryButton", "\u3010Click\u3011+ video_story_control_publish");
                        q0();
                        break;
                    case R.id.s4l /* 2097545900 */:
                        if (this.mParent.y(3)) {
                            this.mParent.t(0);
                            break;
                        } else {
                            this.mParent.t(3);
                            VSReporter.m("mystatus_edit", "sticker_entry_clk", 0, 0, new String[0]);
                            break;
                        }
                    case R.id.s4m /* 2097545901 */:
                        if (this.mParent.y(2)) {
                            this.mParent.t(0);
                            break;
                        } else {
                            this.mParent.O0();
                            VSReporter.m("mystatus_edit", "word_entry_clk", 0, 0, new String[0]);
                            break;
                        }
                }
            }
        } else {
            hd0.c.t("EditVideoStoryButton", "you click button too fast, ignore it !");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onCreate() {
        super.onCreate();
        v0();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onDestroy() {
        p0();
        super.onDestroy();
    }

    public void p0() {
        Dialog dialog = this.M;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    void t0() {
        aa aaVar = this.mUi;
        if (aaVar == null) {
            return;
        }
        aaVar.getRootView().postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoStoryButton.4
            @Override // java.lang.Runnable
            public void run() {
                EditVideoStoryButton editVideoStoryButton = EditVideoStoryButton.this;
                if (editVideoStoryButton.K) {
                    return;
                }
                float f16 = editVideoStoryButton.J;
                if (f16 < 50.0f) {
                    editVideoStoryButton.J = f16 + editVideoStoryButton.L;
                } else {
                    editVideoStoryButton.J = f16 + 1.0f;
                }
                float f17 = editVideoStoryButton.J;
                if (f17 > 99.0f) {
                    editVideoStoryButton.J = 99.0f;
                    editVideoStoryButton.D0((int) 99.0f);
                } else {
                    editVideoStoryButton.D0((int) f17);
                    EditVideoStoryButton.this.t0();
                }
            }
        }, 1000L);
    }

    public void z0(String str) {
        this.I = str;
    }

    public void s0(int i3, long j3) {
        this.J = i3;
        this.K = false;
        float f16 = 50000.0f / ((float) j3);
        this.L = f16;
        if (f16 == 0.0f) {
            this.L = 1.0f;
        }
        t0();
    }

    public void x0(boolean z16, boolean z17) {
        y0(z16, z17, true);
    }

    private void v0() {
        String str;
        findViewSure(R.id.rpy).setVisibility(8);
        ViewGroup viewGroup = (ViewGroup) findViewSure(R.id.s4c);
        this.C = viewGroup;
        viewGroup.setVisibility(0);
        this.D = (RelativeLayout) findViewSure(R.id.s4e);
        if (LiuHaiUtils.needShowLiuHaiTopBar()) {
            View findViewSure = findViewSure(R.id.s4n);
            this.E = findViewSure;
            findViewSure.setBackground(null);
        }
        findViewSure(R.id.s4h).setOnClickListener(this);
        if (!((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).isStoryDefaultShare(this.mUi.getActivity().getIntent()) && this.mParent.C.f204055d == 14) {
            ((TextView) findViewSure(R.id.s4h)).setText(HardCodeUtil.qqStr(R.string.m0j));
        }
        Intent intent = this.mUi.getActivity().getIntent();
        int aEFromType = ((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).getAEFromType(intent);
        if (((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).isFromCheckEntry(intent) || ((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).isFromMiniApp(intent) || aEFromType == js.a.f410917q.b() || aEFromType == js.a.f410910j.b() || aEFromType == js.a.f410920t.b() || aEFromType == js.a.f410921u.b() || aEFromType == js.a.f410918r.b() || aEFromType == js.a.f410922v.b() || aEFromType == js.a.f410925y.b()) {
            ((TextView) findViewSure(R.id.s4h)).setText(getContext().getText(R.string.y9p));
        }
        if (!((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).isStoryPhoto(intent, this.mParent.C.e()) && !((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).isSameStoryPhotoEntry(this.mUi.getActivity().getIntent())) {
            findViewSure(R.id.s4l).setOnClickListener(this);
            findViewSure(R.id.s4m).setOnClickListener(this);
        } else {
            findViewSure(R.id.s4q).setVisibility(8);
            findViewSure(R.id.s4l).setVisibility(8);
            findViewSure(R.id.s4m).setVisibility(8);
        }
        if (intent != null && intent.getBooleanExtra(AECameraConstants.KEY_FROM_PIC_CHOOSE, false)) {
            ((TextView) findViewSure(R.id.f163803s32)).setText(R.string.y8p);
        }
        findViewSure(R.id.s4g).setOnClickListener(this);
        this.f67857i = (FrameLayout) findViewSure(R.id.s4j);
        this.f67858m = findViewSure(R.id.s4f);
        RelativeLayout relativeLayout = this.mParent.U;
        if (relativeLayout != null) {
            int height = relativeLayout.getHeight();
            ViewGroup.LayoutParams layoutParams = this.f67857i.getLayoutParams();
            if (height <= 0) {
                layoutParams.height += LiuHaiUtils.BOTTOM_HEIGHT;
            } else {
                layoutParams.height += height;
            }
            this.f67857i.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.f67858m.getLayoutParams();
            if (height <= 0) {
                layoutParams2.height += LiuHaiUtils.BOTTOM_HEIGHT;
            } else {
                layoutParams2.height += height;
            }
            this.f67858m.setLayoutParams(layoutParams2);
        }
        if (com.tencent.biz.qqstory.utils.k.i() && ScreenUtil.getRealHeight(getContext()) / ScreenUtil.getRealWidth(getContext()) >= 2.0f && LiuHaiUtils.sHasNotch) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.D.getLayoutParams();
            layoutParams3.setMargins(layoutParams3.leftMargin, layoutParams3.topMargin + LiuHaiUtils.getNotchInScreenHeight((Activity) getContext()), layoutParams3.rightMargin, layoutParams3.bottomMargin);
            this.D.setLayoutParams(layoutParams3);
        }
        String[] strArr = new String[1];
        if (this.mParent.k0()) {
            str = "2";
        } else {
            str = "1";
        }
        strArr[0] = str;
        VSReporter.m("mystatus_edit", "edit_exp", 0, 0, strArr);
        if (this.mParent.l0()) {
            com.tencent.aelight.camera.aioeditor.b.m(this.mParent);
        } else {
            com.tencent.aelight.camera.aioeditor.b.n(this.mParent);
        }
    }

    public void y0(boolean z16, boolean z17, boolean z18) {
        if (z17) {
            long currentTimeMillis = System.currentTimeMillis() + 500;
            this.mAnimationEndTime = currentTimeMillis;
            if (z18) {
                this.mAnimationEndTime = currentTimeMillis + 500;
            }
            if (z16) {
                ad.b(this.C, z18, 500);
            } else {
                ad.a(this.C, 500);
            }
        } else {
            this.C.setAnimation(null);
            this.C.setVisibility(z16 ? 0 : 8);
            this.mAnimationEndTime = 0L;
        }
        this.mParent.s(Message.obtain(null, 11, Long.valueOf(this.mAnimationEndTime)));
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onActivityResult(int i3, int i16, final Intent intent) {
        String str;
        if (i3 == 21) {
            if (i16 == -1) {
                this.mParent.f67794m.finish(i16, intent, R.anim.dialog_exit, 0);
                return;
            }
            return;
        }
        if (i3 != 211) {
            return;
        }
        if (intent == null || ((str = this.I) != null && str.equals(intent.getStringExtra("fakeId")))) {
            final boolean z16 = this.F == 20;
            final com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e eVar = this.G;
            this.mParent.t(0);
            this.K = true;
            if (i16 == -1) {
                D0(100);
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoStoryButton.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!EditVideoStoryButton.this.A0() || z16) {
                            EditVideoStoryButton.this.p0();
                        }
                        String stringExtra = intent.getStringExtra("key_video_save_path");
                        String stringExtra2 = intent.getStringExtra(ShortVideoConstants.THUMBFILE_SEND_PATH);
                        boolean z17 = EditVideoStoryButton.this.mParent.C.l("VIDEO_STORY_JUMP_TO_TYPE", 0) == 2;
                        ms.a.f("EditVideoStoryButton", "jumpQzoneShuoshuoDirect=" + z17);
                        if (!z16) {
                            if (EditVideoStoryButton.this.A0()) {
                                ms.a.f("EditVideoStoryButton", "arkViewId is not empty, doUploadAndForwardVideoArkMsg");
                                EditVideoStoryButton.this.r0(stringExtra);
                                return;
                            } else {
                                ab.g(EditVideoStoryButton.this.mUi.getActivity(), stringExtra, stringExtra2, z17, "caller_aecamera");
                                return;
                            }
                        }
                        SendPanelManager.k().u(intent.getStringExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM));
                        String stringExtra3 = intent.getStringExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME);
                        ms.a.f("EditVideoStoryButton", "onPostRun---takeSameName=" + stringExtra3);
                        SendPanelManager.k().w(stringExtra3);
                        SendPanelManager k3 = SendPanelManager.k();
                        com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e eVar2 = eVar;
                        k3.A(eVar2.f68834a, eVar2.f68837d, stringExtra, stringExtra2, true);
                    }
                }, 64, null, true);
                return;
            }
            if (i16 != 1) {
                if (i16 == 0) {
                    p0();
                    return;
                }
                return;
            }
            p0();
            if (A0()) {
                this.mParent.L0();
                return;
            }
            StringBuilder sb5 = new StringBuilder(HardCodeUtil.qqStr(R.string.m2k));
            if (intent != null && intent.getStringExtra("error") != null) {
                sb5.append(MsgSummary.STR_COLON);
                sb5.append(intent.getStringExtra("error"));
            }
            QQToast.makeText(this.mUi.getContext(), 1, sb5, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements aj.b {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.aj.b
        public void onProgressCompleted(aj ajVar) {
            if (QLog.isColorLevel()) {
                QLog.i("EditVideoStoryButton", 2, "[onProgressCompleted] hide ProgressPieDrawable ,ppd = " + ajVar);
            }
        }

        @Override // com.tencent.mobileqq.widget.aj.b
        public void onProgressChanged(aj ajVar, int i3, int i16) {
        }
    }
}
